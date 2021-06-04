package com.example.clase4tm.repository;

import com.example.clase4tm.dto.LinkDTO;

public interface ILinkRepository {
    public Integer addLink(LinkDTO link);
    public LinkDTO getLink(Integer linkID);
    public LinkDTO invalidateLink(Integer linkID);
    public Integer getMetric(Integer linkID);
    public void incrementMetric(Integer linkID);
}
