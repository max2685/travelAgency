package com.webapp.travelAgency.service.tour.comments;

import com.webapp.travelAgency.repository.CommentRepository;
import com.webapp.travelAgency.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TourCommentsServiceImpl implements TourCommentsService {
    @Autowired private CommentRepository commentRepository;

    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }
}
