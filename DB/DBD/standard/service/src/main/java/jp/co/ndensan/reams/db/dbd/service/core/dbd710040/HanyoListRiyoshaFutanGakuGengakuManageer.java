/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.dbd710040;

import jp.co.ndensan.reams.db.dbd.business.core.dbd710040.HanyoListRiyoshaFutanGakuGengakuBusiness;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyolistriyoshafutangakugengaku.RiyoshaFutanGakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyolistriyoshafutangakugengaku.RiyoshaFutanGakuGengakuEucCsvEntity;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 汎用リスト出力(利用者負担額減免)_ＣＳＶ編集クラスです．
 *
 * @reamsid_L DBD-3950-030 panxiaobo
 */
public class HanyoListRiyoshaFutanGakuGengakuManageer {

    /**
     * HanyoListShiharaiHohoHenkoManagerのインスタンス化
     *
     * @return HanyoListShiharaiHohoHenkoManager
     */
    public static HanyoListRiyoshaFutanGakuGengakuManageer createInstance() {
        return InstanceProvider.create(HanyoListRiyoshaFutanGakuGengakuManageer.class);
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
    public void CSV情報設定(RiyoshaFutanGakuGengakuEucCsvEntity eucCsvEntity, RiyoshaFutanGakuGengakuEntity entity,
            Association 地方公共団体情報, HokenshaList 保険者リスト, boolean 日付スラッシュ付加) {
        HanyoListRiyoshaFutanGakuGengakuBusiness bus = new HanyoListRiyoshaFutanGakuGengakuBusiness();
        bus.setEucCsvEntity(地方公共団体情報, 日付スラッシュ付加, eucCsvEntity, entity, 保険者リスト);
    }

    /**
     * ＣＳＶ情報
     *
     * @return RiyoshaFutanGakuGengakuEucCsvEntity eucCsvEntity
     */
    public RiyoshaFutanGakuGengakuEucCsvEntity setBlank() {
        HanyoListRiyoshaFutanGakuGengakuBusiness bus = new HanyoListRiyoshaFutanGakuGengakuBusiness();
        RiyoshaFutanGakuGengakuEucCsvEntity eucCsvEntity = bus.setNewBlank();
        return eucCsvEntity;
    }
}
