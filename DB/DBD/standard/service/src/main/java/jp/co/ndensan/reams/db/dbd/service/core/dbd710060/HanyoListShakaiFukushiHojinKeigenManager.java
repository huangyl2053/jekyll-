/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.dbd710060;

import jp.co.ndensan.reams.db.dbd.business.core.dbd710060.HanyoListShakaiFukushiHojinKeigenBusiness;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutoshakaifukushihojinkeigen.ShakaiFukushiHojinKeigenEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutoshakaifukushihojinkeigen.ShakaiFukushiHojinKeigenEucCsvEntity;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 汎用リスト出力(社会福祉法人軽減)_ＣＳＶ編集クラスです．。
 *
 * @reamsid_L DBD-3900-030 panxiaobo
 */
public class HanyoListShakaiFukushiHojinKeigenManager {

    /**
     * HanyoListHomonKaigoRiyoshaFutanGakuGengakuManagerのインスタンス化
     *
     * @return HanyoListShiharaiHohoHenkoManager
     */
    public static HanyoListShakaiFukushiHojinKeigenManager createInstance() {
        return InstanceProvider.create(HanyoListShakaiFukushiHojinKeigenManager.class);
    }

    /**
     * 連番ありCSV情報設定
     *
     * @param eucCsvEntity CSV情報設定情報
     * @param entity SQL取得結果情報
     * @param 地方公共団体情報 地方公共団体情報
     * @param 保険者リスト 保険者リスト
     * @param 日付スラッシュ付加 日付スラッシュ付加
     */
    public void CSV情報設定(ShakaiFukushiHojinKeigenEucCsvEntity eucCsvEntity, ShakaiFukushiHojinKeigenEntity entity,
            Association 地方公共団体情報, HokenshaList 保険者リスト, boolean 日付スラッシュ付加) {
        HanyoListShakaiFukushiHojinKeigenBusiness bus = new HanyoListShakaiFukushiHojinKeigenBusiness();
        bus.setEucCsvEntity(地方公共団体情報, 日付スラッシュ付加, eucCsvEntity, entity, 保険者リスト);
    }

    /**
     * ＣＳＶ情報
     *
     * @return eucCsvEntity eucCsvEntity
     */
    public ShakaiFukushiHojinKeigenEucCsvEntity setBlank() {
        HanyoListShakaiFukushiHojinKeigenBusiness bus = new HanyoListShakaiFukushiHojinKeigenBusiness();
        ShakaiFukushiHojinKeigenEucCsvEntity eucCsvEntity = bus.setNewBlank();
        return eucCsvEntity;
    }
}
