/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.dbd710130;

import jp.co.ndensan.reams.db.dbd.business.core.dbd710130.HanyoListJigyoTaishoshaBusiness;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutojigyotaishosha.HanyoRisutoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutojigyotaishosha.HanyoRisutoJigyoTaishoshaEucCsvEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 汎用リスト出力(事業対象者)_ＣＳＶ編集クラスです。
 *
 * @reamsid_L DBD-5080-030 panxiaobo
 */
public class HanyoListJigyoTaishoshaManager {

    /**
     * HanyoListJigyoTaishoshaManagerのインスタンス化
     *
     * @return HanyoListJigyoTaishoshaManager
     */
    public static HanyoListJigyoTaishoshaManager createInstance() {
        return InstanceProvider.create(HanyoListJigyoTaishoshaManager.class);
    }

    /**
     * 連番ありCSV情報設定
     *
     * @param eucCsvEntity CSV情報設定情報
     * @param entity SQL取得結果情報
     * @param 地方公共団体情報 地方公共団体情報
     * @param 日付スラッシュ付加 日付スラッシュ付加
     */
    public void CSV情報設定(HanyoRisutoJigyoTaishoshaEucCsvEntity eucCsvEntity, HanyoRisutoJigyoTaishoshaEntity entity,
            Association 地方公共団体情報, boolean 日付スラッシュ付加) {
        HanyoListJigyoTaishoshaBusiness bus = new HanyoListJigyoTaishoshaBusiness();
        bus.setEucCsvEntity(地方公共団体情報, 日付スラッシュ付加, eucCsvEntity, entity);
    }

    /**
     * ＣＳＶ情報
     *
     * @return eucCsvEntity eucCsvEntity
     */
    public HanyoRisutoJigyoTaishoshaEucCsvEntity setBlank() {
        HanyoListJigyoTaishoshaBusiness bus = new HanyoListJigyoTaishoshaBusiness();
        HanyoRisutoJigyoTaishoshaEucCsvEntity eucCsvEntity = bus.setNewBlank();
        return eucCsvEntity;
    }
}
