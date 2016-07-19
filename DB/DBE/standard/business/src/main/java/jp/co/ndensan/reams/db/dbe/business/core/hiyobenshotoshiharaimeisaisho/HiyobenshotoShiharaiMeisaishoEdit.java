/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.hiyobenshotoshiharaimeisaisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbi.HoshuShiharaiJunbiRelateEntity;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査委員報酬・費用弁償等支払明細書のEditクラスです。
 *
 * @reamsid_L DBE-1980-020 suguangjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HiyobenshotoShiharaiMeisaishoEdit {

    /**
     * 介護認定審査委員報酬・費用弁償等支払明細書の編集処理です。
     *
     * @param entity HoshuShiharaiJunbiRelateEntity
     * @param koza 口座情報
     * @return HiyobenshotoShiharaimeisaisho
     */
    public HiyobenshotoShiharaimeisaisho getHiyobenshotoShiharaiMeisai(HoshuShiharaiJunbiRelateEntity entity, List<Koza> koza) {
        HiyobenshotoShiharaimeisaisho meisaiJoho = new HiyobenshotoShiharaimeisaisho();
        Decimal 差引支払額 = new Decimal(entity.getHoshu()).subtract(entity.getShinsakaiKojoZeigaku());
        meisaiJoho.set審査会委員氏名(entity.getChosainShimei());
        meisaiJoho.set報酬(new RString(entity.getHoshu()));
        meisaiJoho.set費用弁償(new RString(entity.getShinsakaiKotsuhi()));
        meisaiJoho.set所得税(new RString(entity.getShinsakaiKojoZeigaku()));
        meisaiJoho.set差引支払額(decimalToRString(差引支払額));
        meisaiJoho.set小計(decimalToRString(差引支払額.add(entity.getHoshu())));
        meisaiJoho.set審査会出席回数(new RString(entity.getX5603_count()));
        meisaiJoho.set市町村名称(entity.getShichosonMeisho());
        if (koza != null && !koza.isEmpty()) {
            meisaiJoho.set金融機関(new RString(koza.get(0).get金融機関().toString()));
            meisaiJoho.set支店(new RString(koza.get(0).get支店().toString()));
            meisaiJoho.set種別(new RString(koza.get(0).get預金種別().toString()));
            meisaiJoho.set番号(new RString(koza.get(0).get口座番号().toString()));
        }
        return meisaiJoho;
    }

    private RString decimalToRString(Decimal date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return new RString(date.toString());
    }
}
