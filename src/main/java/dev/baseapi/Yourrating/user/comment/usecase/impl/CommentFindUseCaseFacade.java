package dev.baseapi.Yourrating.user.comment.usecase.impl;

import dev.baseapi.Yourrating.user.comment.mapper.CommentPageToCommentPageResponseMapper;
import dev.baseapi.Yourrating.user.comment.model.Comment;
import dev.baseapi.Yourrating.user.comment.service.CommentService;
import dev.baseapi.Yourrating.user.comment.usecase.CommentFindUseCase;
import dev.baseapi.Yourrating.user.comment.web.model.CommentFindRequest;
import dev.baseapi.Yourrating.user.comment.web.model.CommentPageResponse;
import dev.baseapi.Yourrating.user.profile.api.service.CurrentUserProfileApiService;
import dev.baseapi.Yourrating.user.profile.model.UserProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import static dev.baseapi.Yourrating.user.comment.model.Comment_.CREATED_TIMESTAMP;

@Component
public class CommentFindUseCaseFacade implements CommentFindUseCase {

    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final CommentService commentService;
    private final CommentPageToCommentPageResponseMapper commentPageToCommentPageResponseMapper;

    public CommentFindUseCaseFacade(CurrentUserProfileApiService currentUserProfileApiService,
                                    CommentService commentService,
                                    CommentPageToCommentPageResponseMapper commentPageToCommentPageResponseMapper) {
        this.currentUserProfileApiService = currentUserProfileApiService;
        this.commentService = commentService;
        this.commentPageToCommentPageResponseMapper = commentPageToCommentPageResponseMapper;
    }

    @Override
    public CommentPageResponse findComments(CommentFindRequest findRequest) {

        UserProfile owner = this.currentUserProfileApiService.currentUserProfile();

        // CREATED_TIMESTAMP берется добавлением в билд.грейдл annotationProcessor 'org.hibernate.orm:hibernate-jpamodelgen'
        // а затем запуском грейдл таски в билде. Генерируется класс Comment_ откуда и берется эта статик переменная
        Sort sort = Sort.by(Sort.Direction.DESC, CREATED_TIMESTAMP);

        Pageable pageable = PageRequest.of(findRequest.page(), findRequest.limit(), sort);

        Page<Comment> allOwnerComments = this.commentService.findAllComments(owner, pageable);

        return commentPageToCommentPageResponseMapper.map(allOwnerComments);
    }
}
