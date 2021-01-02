package com.cwp.study.springcloud.gateway.service.impl;

import com.cwp.study.springcloud.gateway.service.PathMatchService;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;
import org.springframework.stereotype.Service;


@Service
public class PathMatchServiceImpl implements PathMatchService {

    private PatternMatcher pathMatcher;

    public PathMatchServiceImpl() {
        this.pathMatcher = new AntPathMatcher();
    }

    @Override
    public boolean pathMatches(String pattern, String path) {
        PatternMatcher pathMatcher = getPathMatcher();
        return pathMatcher.matches(pattern, path);
    }

    public PatternMatcher getPathMatcher() {
        return pathMatcher;
    }
}
