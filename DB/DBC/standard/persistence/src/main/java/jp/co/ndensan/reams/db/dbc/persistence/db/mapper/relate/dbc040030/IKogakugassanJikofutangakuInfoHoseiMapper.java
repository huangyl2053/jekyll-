/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040030;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc040030.KogakugassanJikofutangakuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040030.KogakugassanJikofutangakuInfoHoseiTempEntity;

/**
 * 高額合算自己負担額情報補正（一括）のマッパインタフェースクラスです。
 *
 * @reamsid_L DBC-2320-060 chenyadong
 */
public interface IKogakugassanJikofutangakuInfoHoseiMapper {

    /**
     * 高額合算自己負担額データを取得する。
     *
     * @param parameter KogakugassanJikofutangakuMybatisParameter
     * @return DbT3070KogakuGassanJikoFutanGakuEntity
     */
    List<DbT3070KogakuGassanJikoFutanGakuEntity> get高額合算自己負担額データ(
            KogakugassanJikofutangakuMybatisParameter parameter);

    /**
     * 被保険者情報と宛名情報付加を取得する。
     *
     * @param parameter KogakugassanJikofutangakuMybatisParameter
     * @return KogakugassanJikofutangakuInfoHoseiTempEntity
     */
    List<KogakugassanJikofutangakuInfoHoseiTempEntity> get被保険者情報と宛名情報付加(
            KogakugassanJikofutangakuMybatisParameter parameter);

    /**
     * 中間DBを取得する。
     *
     * @param parameter KogakugassanJikofutangakuMybatisParameter
     * @return KogakugassanJikofutangakuInfoHoseiTempEntity
     */
    KogakugassanJikofutangakuInfoHoseiTempEntity select中間DB(
            KogakugassanJikofutangakuMybatisParameter parameter);

    /**
     * 中間DBをクリアする。
     */
    void delete中間DB();

    /**
     * 高額合算自己負担額明細データを取得する。
     *
     * @return KogakugassanJikofutangakuInfoHoseiTempEntity
     */
    List<KogakugassanJikofutangakuInfoHoseiTempEntity> get高額合算自己負担額明細データ();

}
