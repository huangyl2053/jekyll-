/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassanshikyuketteihosei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanshikyuketteihosei.KogakuGassanShikyuGakuKeisanKekkaParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanshikyuketteihosei.KogakuGassanShikyuGakuKeisanKekkaUpdateParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanshikyuketteihosei.ShoriModeHanteiParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3075KogakuGassanKyufuJissekiEntity;

/**
 * ビジネス設計_DBCMN62004_DBCMNN1005_支給決定情報補正（単）(事業分兼)
 *
 * @reamsid_L DBC-2290-030 quxiaodong
 */
public interface IKogakuGassanShikyuKetteiHoseiMapper {

    /**
     * 高額合算給付実績取得です。
     *
     * @param 高額合算給付実績 ShoriModeHanteiParameter
     * @return DbT3075KogakuGassanKyufuJissekiEntity
     */
    List<DbT3075KogakuGassanKyufuJissekiEntity> get高額合算給付実績(
            ShoriModeHanteiParameter 高額合算給付実績);

    /**
     * 高額合算支給額計算結果の取得です。
     *
     * @param 高額合算支給額計算結果 KogakuGassanShikyuGakuKeisanKekkaParameter
     * @return DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity
     */
    DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity get高額合算支給額計算結果(
            KogakuGassanShikyuGakuKeisanKekkaParameter 高額合算支給額計算結果);

    /**
     *
     * 高額合算給付実績論理削除
     *
     * @param 高額合算給付実績 KogakuGassanShikyuGakuKeisanKekkaUpdateParameter
     */
    void logicalDelete高額合算給付実績(KogakuGassanShikyuGakuKeisanKekkaUpdateParameter 高額合算給付実績);

    /**
     * 高額合算給付実績物理削除
     *
     * @param 高額合算給付実績 KogakuGassanShikyuGakuKeisanKekkaUpdateParameter
     */
    void physicalDelete高額合算給付実績(KogakuGassanShikyuGakuKeisanKekkaUpdateParameter 高額合算給付実績);

    /**
     * 高額合算給付実績更新
     *
     * @param 高額合算給付実績 KogakuGassanShikyuGakuKeisanKekkaUpdateParameter
     */
    void update高額合算給付実績(KogakuGassanShikyuGakuKeisanKekkaUpdateParameter 高額合算給付実績);

}
