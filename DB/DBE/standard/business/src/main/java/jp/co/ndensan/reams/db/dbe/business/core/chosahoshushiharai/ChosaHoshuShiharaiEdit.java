/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chosahoshushiharai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahoshushiharai.ChosaHoshuShiharaiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbi.HoshuShiharaiJunbiRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCodeResult;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査報酬支払通知書のEditクラスです。
 *
 * @reamsid_L DBE-1980-020 suguangjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaHoshuShiharaiEdit {

    private static int 在宅新規件数 = 1;
    private static int 在宅再調査件数 = 1;
    private static int 施設新規件数 = 1;
    private static int 施設再調査件数 = 1;
    private static int その他の件数 = 1;
    private static int その他の金額 = 1;

    private static RString ninteichosaItakusakiCode = RString.EMPTY;

    /**
     * 要介護認定・要支援認定等申請者の編集処理です。
     *
     * @param entity 要介護認定申請
     * @param 消費税率 消費税率
     * @return ChosaHoshuShiharaiEntity
     */
    public ChosaHoshuShiharaiEntity getChosaHoshuShiharaiEntity(HoshuShiharaiJunbiRelateEntity entity, RString 消費税率) {
        ChosaHoshuShiharaiEntity shiharaientity = new ChosaHoshuShiharaiEntity();
        shiharaientity.set郵便番号(entity.getYubinNo().value());
        shiharaientity.set住所(entity.getJusho());
        shiharaientity.set調査機関(entity.getJigyoshaMeisho());
        shiharaientity.set代表者名(entity.getDaihyoshaName());
        shiharaientity.setその他(entity.getNinteichosaItakusakiCode());
        shiharaientity.set名称付与(DbBusinessConfig.get(ConfigNameDBE.認定調査報酬支払通知書_宛先敬称, RDate.getNowDate(),
                SubGyomuCode.DBE認定支援));
        shiharaientity.set帳票タイトル(DbBusinessConfig.get(ConfigNameDBE.認定調査報酬支払通知書, RDate.getNowDate(),
                SubGyomuCode.DBE認定支援));
        int 単価税込 = 0;
        if (!RString.isNullOrEmpty(消費税率)) {
            単価税込 = entity.getTanka().intValue() * Integer.valueOf(消費税率.toString());
            その他の金額 = entity.getChosaItakuryo() * Integer.valueOf(消費税率.toString());
        }
        if (!ninteichosaItakusakiCode.equals(entity.getNinteichosaItakusakiCode())) {
            if (new Code("0").equals(entity.getNinteiChosaKubunCode()) && new Code("1").equals(entity.getChosaJisshiBashoCode())) {
                在宅新規件数 = 1;
                shiharaientity.set在宅新規件数(kinngakuFormat(new Decimal(在宅新規件数)));
                shiharaientity.set在宅新規単価税込(kinngakuFormat(new Decimal(単価税込)));
            } else if (new Code("1").equals(entity.getNinteiChosaKubunCode()) && new Code("1").equals(entity.getChosaJisshiBashoCode())) {
                在宅再調査件数 = 1;
                shiharaientity.set在宅再調査件数(kinngakuFormat(new Decimal(在宅再調査件数)));
                shiharaientity.set在宅再調査単価税込(kinngakuFormat(new Decimal(単価税込)));
            } else if (new Code("0").equals(entity.getNinteiChosaKubunCode()) && new Code("2").equals(entity.getChosaJisshiBashoCode())) {
                施設新規件数 = 1;
                shiharaientity.set施設新規件数(kinngakuFormat(new Decimal(施設新規件数)));
                shiharaientity.set施設新規単価税込(kinngakuFormat(new Decimal(単価税込)));
            } else if (new Code("1").equals(entity.getNinteiChosaKubunCode()) && new Code("2").equals(entity.getChosaJisshiBashoCode())) {
                施設再調査件数 = 1;
                shiharaientity.set施設再調査件数(kinngakuFormat(new Decimal(施設再調査件数)));
                shiharaientity.set施設再調査単価税込(kinngakuFormat(new Decimal(単価税込)));
            } else {
                その他の件数 = 1;
                shiharaientity.setその他の設定件数(kinngakuFormat(new Decimal(その他の件数)));
            }
        }
        getChosaHoshuShihaEntity(entity, shiharaientity, 単価税込, 消費税率);
        ninteichosaItakusakiCode = entity.getNinteichosaItakusakiCode();
        int 在宅新規合計 = 0;
        int 在宅再調査合計 = 0;
        int 施設新規合計 = 0;
        int 施設再調査合計 = 0;
        if (entity.getTanka() != null) {
            在宅新規合計 = 在宅新規件数 * 単価税込;
            在宅再調査合計 = 在宅再調査件数 * 単価税込;
            施設新規合計 = 施設新規件数 * 単価税込;
            施設再調査合計 = 施設再調査件数 * 単価税込;
        }
        shiharaientity.set在宅新規合計(kinngakuFormat(new Decimal(在宅新規合計)));
        shiharaientity.set在宅再調査合計(kinngakuFormat(new Decimal(在宅再調査合計)));
        shiharaientity.set施設新規合計(kinngakuFormat(new Decimal(施設新規合計)));
        shiharaientity.set施設再調査合計(kinngakuFormat(new Decimal(施設再調査合計)));
        shiharaientity.setその他の設定件数(kinngakuFormat(new Decimal(その他の件数)));
        shiharaientity.setその他の単価税込(RString.EMPTY);
        shiharaientity.setその他の金額合計(kinngakuFormat(new Decimal(その他の金額)));
        int 合計金額 = 在宅新規合計 + 在宅再調査合計 + 施設新規合計 + 施設再調査合計 + その他の金額;
        shiharaientity.set合計金額(kinngakuFormat(new Decimal(合計金額)));
        shiharaientity.setバーコード(getバーコード(entity).getCustomerBarCode());
        return shiharaientity;
    }

    private ChosaHoshuShiharaiEntity getChosaHoshuShihaEntity(HoshuShiharaiJunbiRelateEntity entity,
            ChosaHoshuShiharaiEntity shiharaientity, int 単価税込, RString 消費税率) {
        int その他金額 = 0;
        if (消費税率 != null) {
            その他金額 = entity.getChosaItakuryo() * Integer.valueOf(消費税率.toString());
        }
        if (ninteichosaItakusakiCode.equals(entity.getNinteichosaItakusakiCode())) {
            if (new Code("0").equals(entity.getNinteiChosaKubunCode()) && new Code("1").equals(entity.getChosaJisshiBashoCode())) {
                在宅新規件数 = 在宅新規件数 + 1;
                shiharaientity.set在宅新規件数(kinngakuFormat(new Decimal(在宅新規件数)));
                shiharaientity.set在宅新規単価税込(kinngakuFormat(new Decimal(単価税込)));
            } else if (new Code("1").equals(entity.getNinteiChosaKubunCode()) && new Code("1").equals(entity.getChosaJisshiBashoCode())) {
                在宅再調査件数 = 在宅再調査件数 + 1;
                shiharaientity.set在宅再調査件数(kinngakuFormat(new Decimal(在宅再調査件数)));
                shiharaientity.set在宅再調査単価税込(kinngakuFormat(new Decimal(単価税込)));
            } else if (new Code("0").equals(entity.getNinteiChosaKubunCode()) && new Code("2").equals(entity.getChosaJisshiBashoCode())) {
                施設新規件数 = 施設新規件数 + 1;
                shiharaientity.set施設新規件数(kinngakuFormat(new Decimal(施設新規件数)));
                shiharaientity.set施設新規単価税込(kinngakuFormat(new Decimal(単価税込)));
            } else if (new Code("1").equals(entity.getNinteiChosaKubunCode()) && new Code("2").equals(entity.getChosaJisshiBashoCode())) {
                施設再調査件数 = 施設再調査件数 + 1;
                shiharaientity.set施設再調査件数(kinngakuFormat(new Decimal(施設再調査件数)));
                shiharaientity.set施設再調査単価税込(kinngakuFormat(new Decimal(単価税込)));
            } else {
                その他の件数 = その他の件数 + 1;
                その他の金額 = その他の金額 + その他金額;
            }
        }
        return shiharaientity;
    }

    private RString kinngakuFormat(Decimal date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(date, 0);
    }

    private CustomerBarCodeResult getバーコード(HoshuShiharaiJunbiRelateEntity entity) {
        CustomerBarCode code = new CustomerBarCode();
        CustomerBarCodeResult result = code.convertCustomerBarCode(entity.getYubinNo().value(), entity.getJusho());
        return result;
    }
}
