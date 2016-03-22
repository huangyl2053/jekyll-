/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukyufutaishoshain;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishoshain.DbTKogakuKyufuTaishoshaDataTempTableEntity;

/**
 * 高額介護サービス費給付対象者取込みDB操作です。
 */
public interface IKogakuKyufuTaishoshaInMapper {

    /**
     * 一時テーブル取得する。
     *
     * @return List<KogakuKyufuTaishoshaIchiranhyoEntity>
     */
    List<DbTKogakuKyufuTaishoshaDataTempTableEntity> select一時テーブル();

    /**
     * updateDbT3054サービス提供年月
     */
    void updateDbT3054サービス提供年月();

    /**
     * updateDbT3055サービス提供年月
     */
    void updateDbT3055サービス提供年月();

    /**
     * insert高額介護サービス費給付対象者合計
     */
    void insert高額介護サービス費給付対象者合計();

    /**
     * insert高額介護サービス費給付対象者明細
     */
    void insert高額介護サービス費給付対象者明細();
}
