/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040030;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc040030.KogakugassanJikofutangakuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040030.FutangakuTashoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040030.KogakuGassanUpdateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040030.KogakugassanJikofutangakuInfoHoseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040030.KogakugassanJikofutangakuInfoHoseiTempEntity;

/**
 * 高額合算自己負担額情報補正（一括）のマッパインタフェースクラスです。
 *
 * @reamsid_L DBC-2320-060 chenyadong
 */
public interface IKogakugassanJikofutangakuInfoHoseiMapper {

    /**
     * 高額合算自己負担額情報を取得する。
     *
     * @param parameter KogakugassanJikofutangakuMybatisParameter
     * @return DbT3070KogakuGassanJikoFutanGakuEntity
     */
    List<KogakugassanJikofutangakuInfoHoseiEntity> get高額合算自己負担額情報(
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
     * 高額合算自己負担額データを取得する。
     *
     * @return KogakuGassanUpdateEntity
     */
    List<KogakuGassanUpdateEntity> select高額合算自己負担額データ();

    /**
     * 高額合算自己負担額明細データを取得する。
     *
     * @param parameter KogakugassanJikofutangakuMybatisParameter
     * @return KogakuGassanUpdateEntity
     */
    List<KogakuGassanUpdateEntity> select高額合算自己負担額明細データ(KogakugassanJikofutangakuMybatisParameter parameter);

    /**
     * 中間DBを取得する。
     *
     * @param parameter KogakugassanJikofutangakuMybatisParameter
     * @return KogakugassanJikofutangakuInfoHoseiTempEntity
     */
    List<KogakugassanJikofutangakuInfoHoseiTempEntity> get中間DB(KogakugassanJikofutangakuMybatisParameter parameter);

    /**
     * get負担額補正対象者データを取得する。
     *
     * @param parameter KogakugassanJikofutangakuMybatisParameter
     * @return FutangakuTashoshaEntity
     */
    FutangakuTashoshaEntity get負担額補正対象者データ(KogakugassanJikofutangakuMybatisParameter parameter);

}
