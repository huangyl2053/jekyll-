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

    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;

    /**
     * 介護認定審査委員報酬・費用弁償等支払明細書の編集処理です。
     *
     * @param meisaisho 費用弁償等支払明細書
     * @param entity HoshuShiharaiJunbiRelateEntity
     * @param koza 口座情報
     * @param index index
     * @param 対象期間 対象期間
     * @param 振込予定日 振込予定日
     * @return HiyobenshotoShiharaimeisaisho
     */
    public HiyobenshotoShiharaimeisaisho getHiyobenshotoShiharaiMeisai(HiyobenshotoShiharaimeisaisho meisaisho,
            HoshuShiharaiJunbiRelateEntity entity, List<Koza> koza, int index, RString 対象期間, RString 振込予定日) {
        Decimal 差引支払額 = new Decimal(entity.getHoshu()).subtract(entity.getShinsakaiKojoZeigaku()).roundUpTo(0);
        if (index % INDEX_4 == 1) {
            if (entity.getShinsakaiIinShimei() != null) {
                meisaisho.set審査会委員氏名1(entity.getShinsakaiIinShimei().value());
            }
            meisaisho.set報酬1(new RString(entity.getHoshu()));
            meisaisho.set費用弁償1(new RString(entity.getShinsakaiKotsuhi()));
            meisaisho.set所得税1(new RString(entity.getShinsakaiKojoZeigaku()));
            meisaisho.set差引支払額1(decimalToRString(差引支払額));
            meisaisho.set小計1(decimalToRString(差引支払額.add(entity.getHoshu()).roundUpTo(0)));
            meisaisho.set審査会出席回数1(new RString(entity.getX5603_count()));
            meisaisho.set市町村名称1(entity.getShichosonMeisho());
            meisaisho.set対象期間1(対象期間);
            meisaisho.set振込予定日1(振込予定日);
            if (koza != null && !koza.isEmpty()) {
                meisaisho.set金融機関1(new RString(koza.get(0).get金融機関().toString()));
                meisaisho.set支店1(new RString(koza.get(0).get支店().toString()));
                meisaisho.set種別1(new RString(koza.get(0).get預金種別().toString()));
                meisaisho.set番号1(new RString(koza.get(0).get口座番号().toString()));
            }
        } else if (index % INDEX_4 == 2) {
            if (entity.getShinsakaiIinShimei() != null) {
                meisaisho.set審査会委員氏名2(entity.getShinsakaiIinShimei().value());
            }
            meisaisho.set報酬2(new RString(entity.getHoshu()));
            meisaisho.set費用弁償2(new RString(entity.getShinsakaiKotsuhi()));
            meisaisho.set所得税2(new RString(entity.getShinsakaiKojoZeigaku()));
            meisaisho.set差引支払額2(decimalToRString(差引支払額));
            meisaisho.set小計2(decimalToRString(差引支払額.add(entity.getHoshu()).roundUpTo(0)));
            meisaisho.set審査会出席回数2(new RString(entity.getX5603_count()));
            meisaisho.set市町村名称2(entity.getShichosonMeisho());
            meisaisho.set対象期間2(対象期間);
            meisaisho.set振込予定日2(振込予定日);
            if (koza != null && !koza.isEmpty()) {
                meisaisho.set金融機関2(new RString(koza.get(0).get金融機関().toString()));
                meisaisho.set支店2(new RString(koza.get(0).get支店().toString()));
                meisaisho.set種別2(new RString(koza.get(0).get預金種別().toString()));
                meisaisho.set番号2(new RString(koza.get(0).get口座番号().toString()));
            }
        } else if (index % INDEX_4 == INDEX_3) {
            if (entity.getShinsakaiIinShimei() != null) {
                meisaisho.set審査会委員氏名3(entity.getShinsakaiIinShimei().value());
            }
            meisaisho.set報酬3(new RString(entity.getHoshu()));
            meisaisho.set費用弁償3(new RString(entity.getShinsakaiKotsuhi()));
            meisaisho.set所得税3(new RString(entity.getShinsakaiKojoZeigaku()));
            meisaisho.set差引支払額3(decimalToRString(差引支払額));
            meisaisho.set小計3(decimalToRString(差引支払額.add(entity.getHoshu()).roundUpTo(0)));
            meisaisho.set審査会出席回数3(new RString(entity.getX5603_count()));
            meisaisho.set市町村名称3(entity.getShichosonMeisho());
            meisaisho.set対象期間3(対象期間);
            meisaisho.set振込予定日3(振込予定日);
            if (koza != null && !koza.isEmpty()) {
                meisaisho.set金融機関3(new RString(koza.get(0).get金融機関().toString()));
                meisaisho.set支店3(new RString(koza.get(0).get支店().toString()));
                meisaisho.set種別3(new RString(koza.get(0).get預金種別().toString()));
                meisaisho.set番号3(new RString(koza.get(0).get口座番号().toString()));
            }
        } else {
            if (entity.getShinsakaiIinShimei() != null) {
                meisaisho.set審査会委員氏名4(entity.getShinsakaiIinShimei().value());
            }
            meisaisho.set報酬4(new RString(entity.getHoshu()));
            meisaisho.set費用弁償4(new RString(entity.getShinsakaiKotsuhi()));
            meisaisho.set所得税4(new RString(entity.getShinsakaiKojoZeigaku()));
            meisaisho.set差引支払額4(decimalToRString(差引支払額));
            meisaisho.set小計4(decimalToRString(差引支払額.add(entity.getHoshu()).roundUpTo(0)));
            meisaisho.set審査会出席回数4(new RString(entity.getX5603_count()));
            meisaisho.set市町村名称4(entity.getShichosonMeisho());
            meisaisho.set対象期間4(対象期間);
            meisaisho.set振込予定日4(振込予定日);
            if (koza != null && !koza.isEmpty()) {
                meisaisho.set金融機関4(new RString(koza.get(0).get金融機関().toString()));
                meisaisho.set支店4(new RString(koza.get(0).get支店().toString()));
                meisaisho.set種別4(new RString(koza.get(0).get預金種別().toString()));
                meisaisho.set番号4(new RString(koza.get(0).get口座番号().toString()));
            }
        }
        return meisaisho;
    }

    private RString decimalToRString(Decimal date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return new RString(date.toString());
    }
}
