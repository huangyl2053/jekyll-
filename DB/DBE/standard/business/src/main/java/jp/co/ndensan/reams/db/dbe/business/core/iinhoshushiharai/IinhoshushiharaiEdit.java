/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.iinhoshushiharai;

import jp.co.ndensan.reams.db.dbe.business.core.shujiihoshushiharai.ShujiiHoshuShiharaiEdit;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbi.HoshuShiharaiJunbiRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会委員報酬支払通知書のEditクラスです。
 *
 * @reamsid_L DBE-1980-030 suguangjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IinhoshushiharaiEdit {

    /**
     * 介護認定審査会委員報酬支払明細書の編集処理です。
     *
     * @param entity HoshuShiharaiJunbiRelateEntity
     * @return Iinhoshushiharai
     */
    public Iinhoshushiharai getIinhoshushiharai(HoshuShiharaiJunbiRelateEntity entity) {
        int 差引支給額 = entity.getHoshu() - entity.getShinsakaiKojoZeigaku();
        Iinhoshushiharai iinhoshushiharai = new Iinhoshushiharai();
        iinhoshushiharai.set郵便番号(entity.getYubinNo().value());
        iinhoshushiharai.set住所(entity.getJusho());
        if (entity.getShujiiCode() != null && !entity.getShujiiCode().isEmpty()) {
            iinhoshushiharai.set審査機関(entity.getIryoKikanMeisho());
            iinhoshushiharai.set代表者名(entity.getT5911_daihyoshaName());
        }
        if (entity.getNinteichosainCode() != null && !entity.getNinteichosainCode().isEmpty()) {
            iinhoshushiharai.set審査機関(entity.getJigyoshaMeisho());
            iinhoshushiharai.set代表者名(entity.getDaihyoshaName());
        }
        if (entity.getSonotaKikanCode() != null && !entity.getSonotaKikanCode().isEmpty()) {
            iinhoshushiharai.set審査機関(entity.getKikanMeisho());
            iinhoshushiharai.set代表者名(new RString(entity.getShinsakaiIinShimei().toString()));
        }
        iinhoshushiharai.set名称付与(DbBusinessConfig.get(ConfigNameDBE.介護認定審査会委員報酬支払通知書_宛先敬称, RDate.getNowDate(),
                SubGyomuCode.DBE認定支援));
        iinhoshushiharai.setバーコード(ShujiiHoshuShiharaiEdit.getバーコード(entity));
        iinhoshushiharai.setその他(entity.getShinsakaiIinCode());
        iinhoshushiharai.setタイトル(DbBusinessConfig.get(ConfigNameDBE.介護認定審査会委員報酬支払通知書, RDate.getNowDate(),
                SubGyomuCode.DBE認定支援));
        iinhoshushiharai.set審査会委員氏名(new RString(entity.getShinsakaiIinShimei().toString()));
        iinhoshushiharai.set報酬報償費(new RString(entity.getHoshu()));
        iinhoshushiharai.set源泉所得税(new RString(entity.getShinsakaiKojoZeigaku()));
        iinhoshushiharai.set差引支給額(new RString(差引支給額));
        iinhoshushiharai.set費用弁償(new RString(entity.getShinsakaiKotsuhi()));
        iinhoshushiharai.set合計(new RString(差引支給額 + entity.getShinsakaiKotsuhi()));
        iinhoshushiharai.set審査会出席回数(new RString(entity.getX5603_count()));
        return iinhoshushiharai;
    }

}
