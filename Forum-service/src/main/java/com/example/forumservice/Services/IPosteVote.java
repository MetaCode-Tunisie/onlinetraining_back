package com.example.forumservice.Services;

import com.example.forumservice.Entities.TypeVote;

public interface IPosteVote {
    public void vote(Long idPost, TypeVote typeVote);
}
