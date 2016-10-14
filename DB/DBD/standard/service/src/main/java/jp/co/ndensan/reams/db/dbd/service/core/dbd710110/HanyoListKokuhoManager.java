/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.dbd710110;

import jp.co.ndensan.reams.db.dbd.business.core.dbd710110.HanyoListKokuhoBusiness;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutokokuho.HanyoRisutoKokuhoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutokokuho.HanyoRisutoKokuhoEucCsvEntity;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 汎用リスト出力(国保)_ＣＳＶ編集クラスです。
 *
 * @reamsid_L DBD-5510-030 panxiaobo
 */
public class HanyoListKokuhoManager {

    /**
     * HanyoListKokuhoManagerのインスタンス化
     *
     * @return HanyoListKokuhoManager
     */
    public static HanyoListKokuhoManager createInstance() {
        return InstanceProvider.create(HanyoListKokuhoManager.class);
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
    public void CSV情報設定(HanyoRisutoKokuhoEucCsvEntity eucCsvEntity, HanyoRisutoKokuhoEntity entity,
            Association 地方公共団体情報, HokenshaList 保険者リスト, boolean 日付スラッシュ付加) {
        HanyoListKokuhoBusiness bus = new HanyoListKokuhoBusiness();
        bus.setEucCsvEntity(地方公共団体情報, 日付スラッシュ付加, eucCsvEntity, entity, 保険者リスト);
    }

    /**
     * ＣＳＶ情報
     *
     * @return eucCsvEntity eucCsvEntity
     */
    public HanyoRisutoKokuhoEucCsvEntity setBlank() {
        HanyoListKokuhoBusiness bus = new HanyoListKokuhoBusiness();
        HanyoRisutoKokuhoEucCsvEntity eucCsvEntity = bus.setNewBlank();
        return eucCsvEntity;
    }
}
