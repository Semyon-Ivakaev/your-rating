package dev.baseapi.Yourrating.user.comment.usecase.impl;

import dev.baseapi.Yourrating.user.comment.mapper.CommentToCommentResponseMapper;
import dev.baseapi.Yourrating.user.comment.model.Comment;
import dev.baseapi.Yourrating.user.comment.service.CommentService;
import dev.baseapi.Yourrating.user.comment.usecase.CommentFindUseCase;
import dev.baseapi.Yourrating.user.comment.web.model.CommentFindRequest;
import dev.baseapi.Yourrating.user.comment.web.model.CommentResponse;
import dev.baseapi.Yourrating.user.profile.api.service.CurrentUserProfileApiService;
import dev.baseapi.Yourrating.user.profile.model.UserProfile;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

import static dev.baseapi.Yourrating.user.comment.model.Comment_.CREATED_TIMESTAMP;

@Component
public class CommentFindUseCaseFacade implements CommentFindUseCase {

    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final CommentService commentService;
    private final CommentToCommentResponseMapper commentToCommentResponseMapper;

    public CommentFindUseCaseFacade(CurrentUserProfileApiService currentUserProfileApiService,
                                    CommentService commentService, CommentToCommentResponseMapper commentToCommentResponseMapper) {
        this.currentUserProfileApiService = currentUserProfileApiService;
        this.commentService = commentService;
        this.commentToCommentResponseMapper = commentToCommentResponseMapper;
    }

    @Override
    public Collection<CommentResponse> findComments(CommentFindRequest findRequest) {

        UserProfile owner = this.currentUserProfileApiService.currentUserProfile();

        // CREATED_TIMESTAMP берется добавлением в билд.грейдл annotationProcessor 'org.hibernate.orm:hibernate-jpamodelgen'
        // а затем запуском грейдл таски в билде. Генерируется класс Comment_ откуда и берется эта статик переменная
        Sort sort = Sort.by(Sort.Direction.DESC, CREATED_TIMESTAMP);

        Pageable pageable = PageRequest.of(findRequest.page(), findRequest.limit(), sort);

        Collection<Comment> allOwnerComments = this.commentService.findAllComments(owner, pageable);

        return allOwnerComments.stream()
                .map(this.commentToCommentResponseMapper::map)
                .collect(Collectors.toList());
    }
}
