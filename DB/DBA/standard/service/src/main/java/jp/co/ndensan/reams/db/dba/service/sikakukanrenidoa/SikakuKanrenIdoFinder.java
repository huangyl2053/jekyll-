/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.sikakukanrenidoa;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.param.sikakukanrenido.SikakuKanrenIdoParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.SikakuKanrenIdoEntity;

import jp.co.ndensan.reams.db.dba.persistence.mapper.basic.sikakukanrenido.ISikakuKanrenIdoMapper;
import jp.co.ndensan.reams.db.dbz.business.sikakujiyushutoku.SikakuJiyuShutoku;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.koseishichoson.DbT7051KoseiShichosonMasterEntity;

import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 資格関連異動一覧クラスです。
 */
public class SikakuKanrenIdoFinder {

    private final MapperProvider mapperProvider;
    private final DbT7051KoseiShichosonMasterDac db7051Dac;
    private final SikakuJiyuShutoku sikaku;

    private static final RString コード種別_0126 = new RString("0126");

    /**
     * コンストラクタ
     *
     */
    public SikakuKanrenIdoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.db7051Dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
        this.sikaku = InstanceProvider.create(SikakuJiyuShutoku.class);

    }

    /**
     * クラスをcreateメソッドです。
     *
     * @return 資格関連異動一覧の取得処理するクラス
     */
    public static SikakuKanrenIdoFinder createInstance() {
        return InstanceProvider.create(SikakuKanrenIdoFinder.class);
    }

    /**
     * 一覧データ取得リストを取得する
     *
     * @param params ShikakuTokusoInputGuideParameter
     * @return List<ServiceJigyoshaInputGuideRelateEntity> 一覧データ取得取得リスト
     */
    public List<SikakuKanrenIdoEntity> getSikakuKanrenIdo(SikakuKanrenIdoParameter params) {
        ISikakuKanrenIdoMapper shikakuTokusoMappers = mapperProvider.create(ISikakuKanrenIdoMapper.class);
        List<SikakuKanrenIdoEntity> 一覧データ取得リスト = shikakuTokusoMappers.getSikakuKanrenIdo(params);
        //get画面一覧データ取得リスト(一覧データ取得リスト);
        if (一覧データ取得リスト == null || 一覧データ取得リスト.isEmpty()) {
            return new ArrayList<>();
        }
        List<SikakuKanrenIdoEntity> sikakuKanrenIdoList = new ArrayList<>();
        for (SikakuKanrenIdoEntity entity : 一覧データ取得リスト) {
            sikakuKanrenIdoList.add(entity);
        }
        return sikakuKanrenIdoList;
    }

    /**
     * 所在保険者リスト情報取得
     *
     * @param systemDate RDate
     * @return List<DbT7051KoseiShichosonMasterEntity>
     */
    @Transaction
    public List<DbT7051KoseiShichosonMasterEntity> selectByKoseiShichosonMasterList(RDate systemDate) {

        List<DbT7051KoseiShichosonMasterEntity> businessList = new ArrayList<>();
        List<DbT7051KoseiShichosonMasterEntity> entityList = db7051Dac.selectByKoseiShichosonMasterList(systemDate);
        if (entityList != null && !entityList.isEmpty()) {

            for (DbT7051KoseiShichosonMasterEntity entity : entityList) {
                businessList.add(entity);
            }
        } else {

            return new ArrayList<>();
        }
        return businessList;
    }
}
