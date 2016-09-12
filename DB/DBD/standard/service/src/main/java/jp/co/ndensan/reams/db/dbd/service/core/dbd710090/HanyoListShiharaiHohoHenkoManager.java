/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.dbd710090;

import jp.co.ndensan.reams.db.dbd.business.core.dbd710090.HanyoListShiharaiHohoHenkoBusiness;
import jp.co.ndensan.reams.db.dbd.business.core.dbd710090.HanyoListShiharaiNotContainNoBusiness;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt13011.GeneralPurposeListOutputEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt13011.GeneralPurposeListOutputEucCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt13011.GeneralPurposeListOutputNotContainNoEucCsvEntity;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 汎用リスト出力(施設入退所)ＣＳＶ編集クラスです．
 *
 * @reamsid_L DBD-1570-030 x_lilh
 */
public class HanyoListShiharaiHohoHenkoManager {

    /**
     * HanyoListShiharaiHohoHenkoManagerのインスタンス化
     *
     * @return HanyoListShiharaiHohoHenkoManager
     */
    public static HanyoListShiharaiHohoHenkoManager createInstance() {
        return InstanceProvider.create(HanyoListShiharaiHohoHenkoManager.class);
    }

    /**
     * 連番ありCSV情報設定
     *
     * @param eucCsvEntity CSV情報設定情報
     * @param entity SQL取得結果情報
     * @param count 連番アカウント
     * @param 地方公共団体情報 地方公共団体情報
     * @param 保険者リスト 保険者リスト
     * @param 日付スラッシュ付加 日付スラッシュ付加
     */
    public void 連番ありCSV情報設定(GeneralPurposeListOutputEucCsvEntity eucCsvEntity, GeneralPurposeListOutputEntity entity,
            int count, Association 地方公共団体情報, HokenshaList 保険者リスト, boolean 日付スラッシュ付加) {
        HanyoListShiharaiHohoHenkoBusiness bus = new HanyoListShiharaiHohoHenkoBusiness();
        bus.setEucCsvEntity(eucCsvEntity, entity, count, 地方公共団体情報, 保険者リスト, 日付スラッシュ付加);
    }

    /**
     * 連番なしCSV情報設定
     *
     * @param eucCsvEntity CSV情報設定情報
     * @param entity SQL取得結果情報
     * @param 地方公共団体情報 地方公共団体情報
     * @param 保険者リスト 保険者リスト
     * @param 日付スラッシュ付加 日付スラッシュ付加
     */
    public void 連番なしCSV情報設定(GeneralPurposeListOutputNotContainNoEucCsvEntity eucCsvEntity, GeneralPurposeListOutputEntity entity,
            Association 地方公共団体情報, HokenshaList 保険者リスト, boolean 日付スラッシュ付加) {
        HanyoListShiharaiNotContainNoBusiness bus = new HanyoListShiharaiNotContainNoBusiness();
        bus.setEucCsvEntity(eucCsvEntity, entity, 地方公共団体情報, 保険者リスト, 日付スラッシュ付加);
    }
}
