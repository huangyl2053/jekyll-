/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chosahoshumeisai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbi.HoshuShiharaiJunbiRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
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
public class ChosaHoshumeisaiEdit {

    private static final RString MARU = new RString("○");
    private int 合計件数新規在宅 = 0;
    private int 合計件数新規施設 = 0;
    private int 合計件数継続在宅 = 0;
    private int 合計件数継続施設 = 0;
    private Decimal 合計金額 = Decimal.ZERO;

    /**
     * 要介護認定・要支援認定等申請者の編集処理です。
     *
     * @param entity 要介護認定申請
     * @return ChosaHoshuShiharaiEntity
     */
    public ChosaHoshumeisai getChosaHoshumeisai(HoshuShiharaiJunbiRelateEntity entity) {
        ChosaHoshumeisai hoshumeisai = new ChosaHoshumeisai();
        hoshumeisai.setタイトル(DbBusinessConfig.get(ConfigNameDBE.認定調査報酬支払明細書, RDate.getNowDate(),
                SubGyomuCode.DBE認定支援));
        hoshumeisai.set保険者名(entity.getShichosonMeisho());
        hoshumeisai.set調査機関名(entity.getJigyoshaMeisho());
        hoshumeisai.set調査員名(entity.getChosainShimei());
        hoshumeisai.set調査員コード(entity.getNinteichosainCode());
        hoshumeisai.set帳票印刷日時(get帳票印刷日時());
        hoshumeisai.set被保険者番号(entity.getHihokenshaNo());
        if (entity.getHihokenshaName() != null) {
            hoshumeisai.set被保険者氏名(entity.getHihokenshaName().value());
        }

        if (entity.getNinteiChosaKubunCode() != null && entity.getChosaJisshiBashoCode() != null
                && ChosaKubun.新規調査.getコード().equals(entity.getNinteiChosaKubunCode().value())
                && ChosaJisshiBashoCode.自宅内.getコード().equals(entity.getChosaJisshiBashoCode().value())) {
            hoshumeisai.set新規申請在宅(MARU);
            hoshumeisai.set新規申請施設(RString.EMPTY);
            合計件数新規在宅 = 合計件数新規在宅 + 1;
        } else {
            hoshumeisai.set新規申請在宅(RString.EMPTY);
            hoshumeisai.set新規申請施設(MARU);
            合計件数新規施設 = 合計件数新規施設 + 1;
        }
        if (entity.getNinteiChosaKubunCode() != null && entity.getChosaJisshiBashoCode() != null
                && ChosaKubun.再調査.getコード().equals(entity.getNinteiChosaKubunCode().value())
                && ChosaJisshiBashoCode.自宅内.getコード().equals(entity.getChosaJisshiBashoCode().value())) {
            hoshumeisai.set継続申請在宅(MARU);
            hoshumeisai.set継続申請施設(RString.EMPTY);
            合計件数継続在宅 = 合計件数継続在宅 + 1;
        } else {
            hoshumeisai.set継続申請在宅(RString.EMPTY);
            hoshumeisai.set継続申請施設(MARU);
            合計件数継続施設 = 合計件数継続施設 + 1;
        }
        hoshumeisai.set調査票作成料(intToRString(entity.getChosaItakuryo()));
        hoshumeisai.set合計件数新規在宅(intToRString(合計件数新規在宅));
        hoshumeisai.set合計件数新規施設(intToRString(合計件数新規施設));
        hoshumeisai.set合計件数継続在宅(intToRString(合計件数継続在宅));
        hoshumeisai.set合計件数継続施設(intToRString(合計件数継続施設));
        合計金額 = 合計金額.add(entity.getChosaItakuryo());
        hoshumeisai.set合計金額(decimalToRString(合計金額));
        return hoshumeisai;
    }

    private RString get帳票印刷日時() {
        RDateTime dateTime = RDateTime.now();
        RStringBuilder hakkoYMD = new RStringBuilder();
        hakkoYMD.append(dateTime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        hakkoYMD.append(RString.HALF_SPACE);
        hakkoYMD.append(dateTime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        return hakkoYMD.toRString();
    }

    private RString decimalToRString(Decimal date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return new RString(date.toString());
    }

    private RString intToRString(int date) {
        return new RString(String.valueOf(date));
    }
}
