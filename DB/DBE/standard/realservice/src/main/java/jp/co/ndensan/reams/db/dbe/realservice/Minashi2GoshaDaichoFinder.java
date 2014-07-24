/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.IMinashi2GoshaDaicho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT1012Minashi2GoshaDaichoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.Minashi2GoshaDaichoMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.Minashi2GoshaDaichoDac;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * みなし2号台帳
 *
 * @author N8211 田辺 紘一
 */
public class Minashi2GoshaDaichoFinder implements IMinashi2GoshaDaichoFinder {

// TODO 田辺 紘一 〆日に間に合わず 2014/07/24

    private final Minashi2GoshaDaichoDac dac;

    /**
     * コンストラクタです。
     */
    public Minashi2GoshaDaichoFinder() {
        dac = InstanceProvider.create(Minashi2GoshaDaichoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dac みなし2号被保険者のデータアクセス機能を提供するインタフェース
     */
    Minashi2GoshaDaichoFinder(Minashi2GoshaDaichoDac dac) {
        this.dac = dac;
    }

    @Override
    public boolean existみなし2号者台帳(ISearchCondition condition) {
        return getみなし2号者台帳(condition) != null;
    }

    @Override
    public List<IMinashi2GoshaDaicho> getみなし2号者台帳(ISearchCondition condition) {
        List<IMinashi2GoshaDaicho> minashi2GoshaDaicho = new ArrayList<>();

        for (DbT1012Minashi2GoshaDaichoEntity entity : dac.select(condition)) {
            minashi2GoshaDaicho.add(Minashi2GoshaDaichoMapper.toMinashi2GoshaDaicho(entity));
        }

        if (minashi2GoshaDaicho.size() > 0) {
            return minashi2GoshaDaicho;
        }

        return null;
    }

}
