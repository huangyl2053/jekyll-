/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.KozaFurikomiTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;

/**
 * 振込データ登録処理のmapperです
 *
 * @reamsid_L DBC-5010-030 x_lilh
 */
public interface IFurikomiDataTourokuMapper {

    /**
     * 口座振込一時情報を取得します．
     *
     * @return 口座振込一時情報
     */
    List<KozaFurikomiTempTableEntity> select口座振込一時情報();

    /**
     * 償還払支給判定結果情報を取得します．
     *
     * @return 償還払支給判定結果情報
     */
    List<DbT3036ShokanHanteiKekkaEntity> select依頼済_償還払支給判定結果情報();

    /**
     * 高額介護サービス費支給判定結果情報を取得します．
     *
     * @return 高額介護サービス費支給判定結果情報
     */
    List<DbT3057KogakuShikyuHanteiKekkaEntity> select依頼済_高額介護サービス費支給判定結果情報();

    /**
     * 償還払支給判定結果情報_取消を取得します．
     *
     * @return 償還払支給判定結果情報_取消情報
     */
    List<DbT3036ShokanHanteiKekkaEntity> select依頼済取消_償還払支給判定結果情報();

    /**
     * 高額介護サービス費支給判定結果情報_取消を取得します．
     *
     * @return 高額介護サービス費支給判定結果情報_取消情報
     */
    List<DbT3057KogakuShikyuHanteiKekkaEntity> select依頼済取消_高額介護サービス費支給判定結果情報();

}
