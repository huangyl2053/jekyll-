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
import jp.co.ndensan.reams.db.dbe.business.mapper.Minashi2GoshaDaichoMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IMinashi2GoshaDaichoDac;
import jp.co.ndensan.reams.ua.uax.realservice.shikibetsutaisho.IKojinFinder;
import jp.co.ndensan.reams.ua.uax.realservice.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * みなし2号台帳
 *
 * @author N8211 田辺 紘一
 */
public class Minashi2GoshaDaichoFinder implements IMinashi2GoshaDaichoFinder {

    private final IMinashi2GoshaDaichoDac dac;

    /**
     * コンストラクタです。
     */
    public Minashi2GoshaDaichoFinder() {
        dac = InstanceProvider.createWithCustomize(IMinashi2GoshaDaichoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dac みなし2号被保険者のデータアクセス機能を提供するインタフェース
     */
    Minashi2GoshaDaichoFinder(IMinashi2GoshaDaichoDac dac) {
        this.dac = dac;
    }

    @Override
    public List<IMinashi2GoshaDaicho> getみなし2号者台帳(ISearchCondition condition) {
        List<IMinashi2GoshaDaicho> minashi2GoshaDaicho = new ArrayList<>();

        for (DbT1012Minashi2GoshaDaichoEntity entity : dac.select(condition.makeSearchCondition())) {
            minashi2GoshaDaicho.add(Minashi2GoshaDaichoMapper.toMinashi2GoshaDaicho(entity));
        }

        return minashi2GoshaDaicho;
    }

}
