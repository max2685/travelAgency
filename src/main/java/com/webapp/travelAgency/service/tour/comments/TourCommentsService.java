package com.webapp.travelAgency.service.tour.comments;

import com.webapp.travelAgency.model.Comment;
import org.springframework.stereotype.Service;

public interface TourCommentsService {
    void saveComment(Comment comment);
}
