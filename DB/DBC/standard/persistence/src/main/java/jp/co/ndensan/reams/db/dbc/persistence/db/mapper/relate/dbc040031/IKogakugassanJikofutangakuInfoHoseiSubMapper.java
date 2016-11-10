/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040031;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040010.JissekiFutangakuDataTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040030.KogakugassanJikofutangakuInfoHoseiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040031.KogakugassanJikofutangakuInfoHoseiSubEntity;

/**
 * 高額支給額集計データのマッパインタフェースクラスです。
 *
 * @reamsid_L DBC-2320-050 yuanzhenxia
 */
public interface IKogakugassanJikofutangakuInfoHoseiSubMapper {

    /**
     * 高額支給額集計データを取得する。
     *
     * @return List<KogakugassanJikofutangakuInfoHoseiSubEntity>
     */
    List<KogakugassanJikofutangakuInfoHoseiSubEntity> get高額支給額集計データ();

    /**
     * 中間DBデータを取得する。
     *
     * @return List<KogakugassanJikofutangakuInfoHoseiTempEntity>
     */
    List<KogakugassanJikofutangakuInfoHoseiTempEntity> get中間DBデータ();

    /**
     * 実績基本データを取得する。
     *
     * @return List<JissekiFutangakuDataTempEntity>
     */
    List<JissekiFutangakuDataTempEntity> get実績基本データ();

}
