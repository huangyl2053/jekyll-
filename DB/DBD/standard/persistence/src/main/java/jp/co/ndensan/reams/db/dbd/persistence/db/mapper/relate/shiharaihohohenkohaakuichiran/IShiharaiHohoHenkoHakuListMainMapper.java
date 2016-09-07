/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohohenkohaakuichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShiharaiHohoHenkoHaakuFiveEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShiharaiHohoHenkoHaakuFourEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShiharaiHohoHenkoHaakuOneEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShiharaiHohoHenkoHaakuThreeEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShiharaiHohoHenkoHaakuTwoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 支払方法変更滞納者把握情報取得クラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
public interface IShiharaiHohoHenkoHakuListMainMapper {

    /**
     * 支払方法変更情報を取得します．
     *
     * @param 基準日 基準日
     * @return 支払方法変更情報
     */
    List<ShiharaiHohoHenkoHaakuOneEntity> find支払方法変更情報(FlexibleDate 基準日);

    /**
     * 償還未払い情報の取得
     *
     * @return 償還未払い情報
     */
    List<ShiharaiHohoHenkoHaakuTwoEntity> find償還未払い情報();

    /**
     * 最大履歴の取得
     *
     * @return 最大履歴情報
     */
    List<ShiharaiHohoHenkoHaakuThreeEntity> find最大履歴情報();

    /**
     * 最大の履歴番号レコードの情報を取得する
     *
     * @return 最大の履歴番号レコードの情報
     */
    List<ShiharaiHohoHenkoHaakuFourEntity> find最大の履歴番号レコードの情報();

    /**
     * 滞納者対策情報取得
     *
     * @return 滞納者対策情報
     */
    List<ShiharaiHohoHenkoHaakuFourEntity> find滞納者対策情報();

    /**
     * 帳票印字用データを取得して、支払方法変更リストを取得します．
     *
     * @return 帳票印字用データ
     */
    List<ShiharaiHohoHenkoHaakuFiveEntity> find帳票印字用データ();
}
