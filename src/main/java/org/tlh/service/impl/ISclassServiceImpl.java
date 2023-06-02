package org.tlh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tlh.domain.Sclass;
import org.tlh.mapper.ISclassMapper;
import org.tlh.query.SclassQuery;
import org.tlh.service.ISclassService;
import org.tlh.until.PageList;

import java.util.List;

@Service
public class ISclassServiceImpl implements ISclassService {
    @Autowired
    private ISclassMapper sclassMapper;
    @Override
    public List<Sclass> selectAll() {

        return sclassMapper.selectAll();
    }

    @Override
    public Sclass selectById(Long id) {

        return sclassMapper.selectById(id);
    }

    @Override
    public void add(Sclass sclass) {
        sclassMapper.add(sclass);
    }

    @Override
    public void update(Sclass sclass) {
        sclassMapper.update(sclass);
    }

    @Override
    public void deleteById(Long id) {
        sclassMapper.deleteById(id);
    }

    @Override
    public PageList<Sclass> queryByPage(SclassQuery query) {
        //new一个pagelist对象来接收参数
        PageList<Sclass> pageList=new PageList<>();
        //查询当前页的数据
        List<Sclass> rows = sclassMapper.selectByPage(query);
        pageList.setRows(rows);
        //统计条数
        Long total = sclassMapper.count(query);
        pageList.setTotal(total);
        return pageList;
    }

    @Override
    public void batchDelete(List<Long> ids) {
        sclassMapper.batchDelete(ids);
    }
}
