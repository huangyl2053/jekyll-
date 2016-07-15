/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.hiyobenshotoshiharaimeisaisho;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbi.HoshuShiharaiJunbiRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査委員報酬・費用弁償等支払明細書のEditクラスです。
 *
 * @reamsid_L DBE-1980-048 suguangjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HiyobenshotoShiharaiMeisaishoEdit {

    /**
     * 介護認定審査会委員報酬支払明細書の編集処理です。
     *
     * @param entity HoshuShiharaiJunbiRelateEntity
     * @return HiyobenshotoShiharaimeisaisho
     */
    public HiyobenshotoShiharaimeisaisho getHiyobenshotoShiharaiMeisai(HoshuShiharaiJunbiRelateEntity entity) {
        HiyobenshotoShiharaimeisaisho meisaiJoho = new HiyobenshotoShiharaimeisaisho();
        int 差引支払額 = entity.getHoshu() - entity.getShinsakaiKojoZeigaku();
        meisaiJoho.set審査会委員氏名(entity.getChosainShimei());
        meisaiJoho.set報酬(new RString(entity.getHoshu()));
        meisaiJoho.set費用弁償(new RString(entity.getShinsakaiKotsuhi()));
        meisaiJoho.set所得税(new RString(entity.getShinsakaiKojoZeigaku()));
        meisaiJoho.set差引支払額(new RString(差引支払額));
        meisaiJoho.set小計(new RString(差引支払額 + entity.getHoshu()));
        meisaiJoho.set審査会出席回数(new RString(entity.getX5603_count()));
        meisaiJoho.set市町村名称(entity.getShichosonMeisho());
        return meisaiJoho;
    }
}
