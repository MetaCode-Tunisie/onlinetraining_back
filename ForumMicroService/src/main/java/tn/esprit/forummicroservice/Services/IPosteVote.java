package tn.esprit.forummicroservice.Services;

import tn.esprit.forummicroservice.Entities.TypeVote;

public interface IPosteVote {
    public void vote(Long idPost, TypeVote typeVote);
}
