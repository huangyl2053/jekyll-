/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.futangendogakunintei.futangendogakuninteishinsei;

import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.basic.IDbT4036FutanGendogakuNinteiBatchTestResultsMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 負担限度額認定申請を管理するクラスです。
 */
public class FutangendogakuNinteiShinseiManager {

    private final MapperProvider mapperProvider;
    private IDbT4036FutanGendogakuNinteiBatchTestResultsMapper dbt4036mapper;

    /**
     * コンストラクタです。
     */
    public FutangendogakuNinteiShinseiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 負担限度額認定申請を管理するクラスを生成します。
     *
     * @return 負担限度額認定申請を管理するクラス
     */
    public static FutangendogakuNinteiShinseiManager createInstance() {
        return InstanceProvider.create(FutangendogakuNinteiShinseiManager.class);
    }

    /**
     * 介護保険負担限度額認定を削除する。
     *
     * @param hihokenshaNo 被保険者番号
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public int delete利用者負担額減額by被保険者番号(HihokenshaNo hihokenshaNo) {
        dbt4036mapper = mapperProvider.create(IDbT4036FutanGendogakuNinteiBatchTestResultsMapper.class);
        return dbt4036mapper.deleteByHihokenshaNo(hihokenshaNo);
    }
}
