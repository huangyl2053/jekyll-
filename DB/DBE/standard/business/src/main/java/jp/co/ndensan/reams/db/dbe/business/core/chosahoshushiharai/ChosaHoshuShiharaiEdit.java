/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chosahoshushiharai;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahoshushiharai.ChosaHoshuShiharaiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbi.HoshuShiharaiJunbiRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCodeResult;
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

    private int 在宅新規件数;
    private int 在宅再調査件数;
    private int 施設新規件数;
    private int 施設再調査件数;
    private int その他の件数;
    private Decimal その他の金額 = Decimal.ZERO;
    private RString ninteichosaItakusakiCode = RString.EMPTY;

    /**
     * 認定調査報酬支払通知書の編集処理です。
     *
     * @param entity 要介護認定申請
     * @param 消費税率 消費税率
     * @param 認証者 認証者
     * @param 通知文 通知文
     * @param 口座情報 口座情報
     * @return ChosaHoshuShiharaiEntity
     */
    public ChosaHoshuShiharaiEntity getChosaHoshuShiharaiEntity(HoshuShiharaiJunbiRelateEntity entity, RString 消費税率,
            NinshoshaSource 認証者, Map<Integer, RString> 通知文, Koza 口座情報) {
        ChosaHoshuShiharaiEntity shiharaientity = new ChosaHoshuShiharaiEntity();
        shiharaientity.set電子公印(認証者.denshiKoin);
        shiharaientity.set発行日(認証者.hakkoYMD);
        shiharaientity.set認証者役職名(認証者.ninshoshaYakushokuMei);
        shiharaientity.set認証者役職名1(認証者.ninshoshaYakushokuMei1);
        shiharaientity.set公印文字列(認証者.koinMojiretsu);
        shiharaientity.set認証者役職名2(認証者.ninshoshaYakushokuMei2);
        shiharaientity.set認証者氏名カナ(認証者.ninshoshaShimeiKakenai);
        shiharaientity.set認証者氏名掛ける(認証者.ninshoshaShimeiKakeru);
        shiharaientity.set公印省略(認証者.koinShoryaku);
        shiharaientity.set通知文1(通知文.get(1));
        shiharaientity.set通知文2(通知文.get(2));
        if (口座情報 != null) {
            shiharaientity.set種別(口座情報.get預金種別().get預金種別名称());
            shiharaientity.set番号(口座情報.get口座番号());
            shiharaientity.set金融機関(口座情報.getCombined金融機関名and支店名());
            shiharaientity.set名議人(口座情報.get口座名義人().value());
        }
        shiharaientity.set郵便番号(entity.getYubinNo().value());
        shiharaientity.set住所(entity.getJusho());
        shiharaientity.set調査機関(entity.getJigyoshaMeisho());
        shiharaientity.set代表者名(entity.getDaihyoshaName());
        shiharaientity.setその他(entity.getNinteichosaItakusakiCode());
        shiharaientity.set名称付与(DbBusinessConfig.get(ConfigNameDBE.認定調査報酬支払通知書_宛先敬称, RDate.getNowDate(),
                SubGyomuCode.DBE認定支援));
        shiharaientity.set帳票タイトル(DbBusinessConfig.get(ConfigNameDBE.認定調査報酬支払通知書, RDate.getNowDate(),
                SubGyomuCode.DBE認定支援));
        Decimal 単価税込 = nullOrZero(entity.getTanka()).multiply(rstringToDecimal(消費税率)).roundUpTo(0);
        その他の金額 = rstringToDecimal(消費税率).multiply(entity.getChosaItakuryo());
        if (!ninteichosaItakusakiCode.equals(entity.getNinteichosaItakusakiCode())) {
            if (entity.getNinteiChosaKubunCode() != null && entity.getChosaJisshiBashoCode() != null
                    && ChosaKubun.新規調査.getコード().equals(entity.getNinteiChosaKubunCode().value())
                    && ChosaJisshiBashoCode.自宅内.getコード().equals(entity.getChosaJisshiBashoCode().value())) {
                在宅新規件数 = 1;
                shiharaientity.set在宅新規件数(intToRString(在宅新規件数));
                shiharaientity.set在宅新規単価税込(decimalToRString(単価税込));
            } else if (entity.getNinteiChosaKubunCode() != null && entity.getChosaJisshiBashoCode() != null
                    && ChosaKubun.再調査.getコード().equals(entity.getNinteiChosaKubunCode().value())
                    && ChosaJisshiBashoCode.自宅内.getコード().equals(entity.getChosaJisshiBashoCode().value())) {
                在宅再調査件数 = 1;
                shiharaientity.set在宅再調査件数(intToRString(在宅再調査件数));
                shiharaientity.set在宅再調査単価税込(decimalToRString(単価税込));
            } else if (entity.getNinteiChosaKubunCode() != null && entity.getChosaJisshiBashoCode() != null
                    && ChosaKubun.新規調査.getコード().equals(entity.getNinteiChosaKubunCode().value())
                    && ChosaJisshiBashoCode.自宅外.getコード().equals(entity.getChosaJisshiBashoCode().value())) {
                施設新規件数 = 1;
                shiharaientity.set施設新規件数(intToRString(施設新規件数));
                shiharaientity.set施設新規単価税込(decimalToRString(単価税込));
            } else if (entity.getNinteiChosaKubunCode() != null && entity.getChosaJisshiBashoCode() != null
                    && ChosaKubun.再調査.getコード().equals(entity.getNinteiChosaKubunCode().value())
                    && ChosaJisshiBashoCode.自宅外.getコード().equals(entity.getChosaJisshiBashoCode().value())) {
                施設再調査件数 = 1;
                shiharaientity.set施設再調査件数(intToRString(施設再調査件数));
                shiharaientity.set施設再調査単価税込(decimalToRString(単価税込));
            } else {
                その他の件数 = 1;
                shiharaientity.setその他の設定件数(intToRString(その他の件数));
            }
        }
        getChosaHoshuShihaEntity(entity, shiharaientity, 単価税込, 消費税率);
        ninteichosaItakusakiCode = entity.getNinteichosaItakusakiCode();
        Decimal 在宅新規合計 = 単価税込.multiply(在宅新規件数);
        Decimal 在宅再調査合計 = 単価税込.multiply(在宅再調査件数);
        Decimal 施設新規合計 = 単価税込.multiply(施設新規件数);
        Decimal 施設再調査合計 = 単価税込.multiply(施設再調査件数);
        shiharaientity.set在宅新規合計(decimalToRString(在宅新規合計.roundUpTo(0)));
        shiharaientity.set在宅再調査合計(decimalToRString(在宅再調査合計.roundUpTo(0)));
        shiharaientity.set施設新規合計(decimalToRString(施設新規合計.roundUpTo(0)));
        shiharaientity.set施設再調査合計(decimalToRString(施設再調査合計.roundUpTo(0)));
        shiharaientity.setその他の設定件数(intToRString(その他の件数));
        shiharaientity.setその他の単価税込(RString.EMPTY);
        shiharaientity.setその他の金額合計(decimalToRString(その他の金額.roundUpTo(0)));
        Decimal 合計金額 = 在宅新規合計.add(在宅再調査合計).add(施設新規合計).add(施設再調査合計).add(その他の金額);
        shiharaientity.set合計金額(decimalToRString(合計金額.roundUpTo(0)));
        shiharaientity.setバーコード(getバーコード(entity));
        return shiharaientity;
    }

    private ChosaHoshuShiharaiEntity getChosaHoshuShihaEntity(HoshuShiharaiJunbiRelateEntity entity,
            ChosaHoshuShiharaiEntity shiharaientity, Decimal 単価税込, RString 消費税率) {
        その他の金額 = rstringToDecimal(消費税率).multiply(entity.getChosaItakuryo()).roundUpTo(0);
        if (ninteichosaItakusakiCode.equals(entity.getNinteichosaItakusakiCode())) {
            if (entity.getNinteiChosaKubunCode() != null && entity.getChosaJisshiBashoCode() != null
                    && ChosaKubun.新規調査.getコード().equals(entity.getNinteiChosaKubunCode().value())
                    && ChosaJisshiBashoCode.自宅内.getコード().equals(entity.getChosaJisshiBashoCode().value())) {
                在宅新規件数 = 在宅新規件数 + 1;
                shiharaientity.set在宅新規件数(intToRString(在宅新規件数));
                shiharaientity.set在宅新規単価税込(decimalToRString(単価税込));
            } else if (entity.getNinteiChosaKubunCode() != null && entity.getChosaJisshiBashoCode() != null
                    && ChosaKubun.再調査.getコード().equals(entity.getNinteiChosaKubunCode().value())
                    && ChosaJisshiBashoCode.自宅内.getコード().equals(entity.getChosaJisshiBashoCode().value())) {
                在宅再調査件数 = 在宅再調査件数 + 1;
                shiharaientity.set在宅再調査件数(intToRString(在宅再調査件数));
                shiharaientity.set在宅再調査単価税込(decimalToRString(単価税込));
            } else if (entity.getNinteiChosaKubunCode() != null && entity.getChosaJisshiBashoCode() != null
                    && ChosaKubun.新規調査.getコード().equals(entity.getNinteiChosaKubunCode().value())
                    && ChosaJisshiBashoCode.自宅外.getコード().equals(entity.getChosaJisshiBashoCode().value())) {
                施設新規件数 = 施設新規件数 + 1;
                shiharaientity.set施設新規件数(intToRString(施設新規件数));
                shiharaientity.set施設新規単価税込(decimalToRString(単価税込));
            } else if (entity.getNinteiChosaKubunCode() != null && entity.getChosaJisshiBashoCode() != null
                    && ChosaKubun.再調査.getコード().equals(entity.getNinteiChosaKubunCode().value())
                    && ChosaJisshiBashoCode.自宅外.getコード().equals(entity.getChosaJisshiBashoCode().value())) {
                施設再調査件数 = 施設再調査件数 + 1;
                shiharaientity.set施設再調査件数(intToRString(施設再調査件数));
                shiharaientity.set施設再調査単価税込(decimalToRString(単価税込));
            } else {
                その他の件数 = その他の件数 + 1;
                その他の金額 = その他の金額.add(その他の金額).roundUpTo(0);
            }
        }
        return shiharaientity;
    }

    private RString decimalToRString(Decimal date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return new RString(date.toString());
    }

    private RString intToRString(int date) {
        return new RString(date);
    }

    private Decimal rstringToDecimal(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return Decimal.ZERO;
        }
        return new Decimal(date.toString());
    }

    private Decimal nullOrZero(Decimal data) {
        if (data == null) {
            return Decimal.ZERO;
        }
        return data;
    }

    /**
     * バーコードの編集処理です。
     *
     * @param entity バーコード
     * @return RString
     */
    public static RString getバーコード(HoshuShiharaiJunbiRelateEntity entity) {
        CustomerBarCode code = new CustomerBarCode();
        CustomerBarCodeResult result = code.convertCustomerBarCode(entity.getYubinNo().value(), entity.getJusho());
        RString バーコード = RString.EMPTY;
        if (result != null) {
            バーコード = result.getCustomerBarCode();
        }
        return バーコード;
    }
}
