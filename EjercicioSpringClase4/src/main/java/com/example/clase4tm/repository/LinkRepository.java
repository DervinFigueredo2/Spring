package com.example.clase4tm.repository;

import com.example.clase4tm.dto.LinkDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepository implements ILinkRepository {

    private HashMap<Integer, LinkDTO> links;
    private HashMap<Integer, Integer> metrics;
    private Integer lastID;

    public LinkRepository() {
        this.links = new HashMap<Integer, LinkDTO>();
        this.metrics = new HashMap<Integer, Integer>();
        this.lastID = 0;
    }

    @Override
    public Integer addLink(LinkDTO link) {
        Integer id = ++lastID;
        links.put(id, link);
        return id;
    }

    @Override
    public LinkDTO getLink(Integer linkID) {
        return links.get(linkID);
    }

    public void incrementMetric(Integer linkID) {
        this.metrics.put(linkID, this.metrics.getOrDefault(linkID, 0) + 1);
    }

    public Integer getMetric(Integer linkID){
        return this.metrics.get(linkID);
    }

    @Override
    public LinkDTO invalidateLink(Integer linkID) {
        LinkDTO link = getLink(linkID);
        link.setValido(false);
        return link;
    }


}
