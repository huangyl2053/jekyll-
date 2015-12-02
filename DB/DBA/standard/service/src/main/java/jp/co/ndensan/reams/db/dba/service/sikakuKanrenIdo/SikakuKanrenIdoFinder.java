/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.sikakuKanrenIdo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.sikakuKanrenIdo.SikakuKanrenIdoParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.SikakuKanrenIdoEntity;
import jp.co.ndensan.reams.db.dba.persistence.mapper.basic.DbT5051KoseiShichosonMasterMapper;
import jp.co.ndensan.reams.db.dba.persistence.mapper.basic.SikakuKanrenIdoMapper;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * @author soft863
 */
public class SikakuKanrenIdoFinder {

    private final MapperProvider mapperProvider;
    private final DbT7051KoseiShichosonMasterDac db7051Dac;

    public SikakuKanrenIdoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.db7051Dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
    }

    public static SikakuKanrenIdoFinder createInstance() {
        return InstanceProvider.create(SikakuKanrenIdoFinder.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link DbT7056GappeiShichosonDac}
     */
//    SikakuKanrenIdoFinder(MapperProvider mapperProvider) {
//        this.mapperProvider = mapperProvider;
//    }
    /**
     * 一覧データ取得リストを取得する
     *
     * @param params ShikakuTokusoInputGuideParameter
     * @return List<ServiceJigyoshaInputGuideRelateEntity> 一覧データ取得取得リスト
     */
    public List<SikakuKanrenIdoEntity> getSikakuKanrenIdo(SikakuKanrenIdoParameter params) {
        SikakuKanrenIdoMapper ShikakuTokusoMappers = mapperProvider.create(SikakuKanrenIdoMapper.class);
        List<SikakuKanrenIdoEntity> 一覧データ取得リスト = ShikakuTokusoMappers.getSikakuKanrenIdo(params);
        //get画面一覧データ取得リスト(一覧データ取得リスト);
        if (一覧データ取得リスト == null || 一覧データ取得リスト.isEmpty()) {
            return new ArrayList<>();
        }
        List<SikakuKanrenIdoEntity> SikakuKanrenIdoList = new ArrayList<>();
        for (SikakuKanrenIdoEntity entity : 一覧データ取得リスト) {
            SikakuKanrenIdoList.add(entity);
        }
        return SikakuKanrenIdoList;
    }

    @Transaction
    public List<DbT5051KoseiShichosonMasterEntity> getKoseiShichosonMasterList() {
        DbT5051KoseiShichosonMasterMapper KoseiShichosonMasterMapper = mapperProvider.create(DbT5051KoseiShichosonMasterMapper.class);
        List<DbT5051KoseiShichosonMasterEntity> mapperList = KoseiShichosonMasterMapper.getKoseiShichosonMasterList();
        if (mapperList.isEmpty()) {
            return new ArrayList<>();
        }
        for (DbT5051KoseiShichosonMasterEntity entity : mapperList) {
//            KoseiShichosonMaster.add(new KoseiShichosonMaster(entity));
        }
        return mapperList;

    }

}
