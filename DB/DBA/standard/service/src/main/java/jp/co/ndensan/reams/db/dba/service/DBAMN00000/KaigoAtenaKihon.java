/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.DBAMN00000;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.DBAMN00000.KaigoAtenaKihonEntity;
import jp.co.ndensan.reams.db.dba.persistence.DBAMN00000.KaigoAtenaKihonMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護宛名基本情報を取得するクラスです。
 *
 */
public class KaigoAtenaKihon {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public KaigoAtenaKihon() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 介護資格系基本情報取得する。
     *
     * @param ShikibetsuCode shikibetsuCode
     * @return List DbT1001HihokenshaDaichoEntity
     */
    // TODO QA-21,QA-33
    public List<KaigoAtenaKihonEntity> getKaigoShikakuKihon(ShikibetsuCode shikibetsuCode) {
        KaigoAtenaKihonMapper mapper = mapperProvider.create(KaigoAtenaKihonMapper.class);
        List<KaigoAtenaKihonEntity> kaigoAtenaKihonList = mapper.selectKaigoShikakuKihonByShikibetsuCode(shikibetsuCode);
        if (kaigoAtenaKihonList.isEmpty()) {
            return new ArrayList();
        }
        return kaigoAtenaKihonList;
    }

    /**
     * 介護宛名基本情報初期化する。
     *
     * @param ShikibetsuCode shikibetsuCode
     */
    // TODO QA-30
    public void load(ShikibetsuCode shikibetsuCode) {

        getKaigoShikakuKihon(shikibetsuCode);
    }
}
