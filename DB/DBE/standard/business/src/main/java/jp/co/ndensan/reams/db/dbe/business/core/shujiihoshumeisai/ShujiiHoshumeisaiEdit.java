/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shujiihoshumeisai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbi.HoshuShiharaiJunbiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiihoshumeisai.ShujiiHoshumeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.ZaitakuShisetsuKubun;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * 主治医意見書作成報酬支払明細書のEditクラスです。
 *
 * @reamsid_L DBE-1980-020 suguangjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiHoshumeisaiEdit {

    private static final RString MARU = new RString("○");
    private int 合計件数新規在宅 = 0;
    private int 合計件数新規施設 = 0;
    private int 合計件数継続在宅 = 0;
    private int 合計件数継続施設 = 0;
    private Decimal 合計金額 = Decimal.ZERO;

    /**
     * 主治医意見書作成報酬支払明細書の編集処理です。
     *
     * @param entity 要介護認定申請
     * @return ChosaHoshuShiharaiEntity
     */
    public ShujiiHoshumeisaiEntity getShujiiHoshumeisaiEntity(HoshuShiharaiJunbiRelateEntity entity) {
        ShujiiHoshumeisaiEntity shumeisaiEntity = new ShujiiHoshumeisaiEntity();
        shumeisaiEntity.set保険者名(entity.getShichosonMeisho());
        shumeisaiEntity.set医療機関名(entity.getIryoKikanMeisho());
        shumeisaiEntity.set医師名(entity.getShujiiName());
        shumeisaiEntity.set印刷日時(get帳票印刷日時());
        shumeisaiEntity.set被保険者番号(entity.getHihokenshaNo());
        if (entity.getHihokenshaName() != null) {
            shumeisaiEntity.set被保険者氏名(entity.getHihokenshaName().value());
        }
        RString 報酬基準日 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書報酬基準日, RDate.getNowDate(),
                SubGyomuCode.DBE認定支援);
        if (new RString("1").equals(報酬基準日)) {
            shumeisaiEntity.set意見書提出日(dateFormat9(entity.getIkenshoJuryoYMD()));
        }
        if (new RString("2").equals(報酬基準日)) {
            shumeisaiEntity.set意見書提出日(dateFormat9(entity.getIkenshoReadYMD()));
        }
        if (entity.getIkenshoSakuseiKaisuKubun() != null && entity.getZaitakuShisetsuKubun() != null
                && IkenshoSakuseiKaisuKubun.初回.getコード().equals(entity.getIkenshoSakuseiKaisuKubun().value())
                && ZaitakuShisetsuKubun.在宅.getコード().equals(entity.getZaitakuShisetsuKubun().value())) {
            shumeisaiEntity.set新規在宅(MARU);
            shumeisaiEntity.set新規施設(RString.EMPTY);
            合計件数新規在宅 = 合計件数新規在宅 + 1;
        } else {
            shumeisaiEntity.set新規在宅(RString.EMPTY);
            shumeisaiEntity.set新規在宅(MARU);
            合計件数新規施設 = 合計件数新規施設 + 1;
        }
        if (entity.getIkenshoSakuseiKaisuKubun() != null && entity.getZaitakuShisetsuKubun() != null
                && IkenshoSakuseiKaisuKubun._2回目以降.getコード().equals(entity.getIkenshoSakuseiKaisuKubun().value())
                && ZaitakuShisetsuKubun.在宅.getコード().equals(entity.getZaitakuShisetsuKubun().value())) {
            shumeisaiEntity.set継続在宅(MARU);
            shumeisaiEntity.set継続施設(RString.EMPTY);
            合計件数継続在宅 = 合計件数継続在宅 + 1;
        } else {
            shumeisaiEntity.set継続在宅(RString.EMPTY);
            shumeisaiEntity.set継続在宅(MARU);
            合計件数継続施設 = 合計件数継続施設 + 1;
        }
        shumeisaiEntity.set意見書作成料(intToRString(entity.getIkenshoSakuseiryo()));
        shumeisaiEntity.set新規在宅件数(intToRString(合計件数新規在宅));
        shumeisaiEntity.set新規施設件数(intToRString(合計件数新規施設));
        shumeisaiEntity.set継続在宅件数(intToRString(合計件数継続在宅));
        shumeisaiEntity.set継続施設件数(intToRString(合計件数継続施設));
        shumeisaiEntity.set合計金額(shumeisaiEntity.get意見書作成料());
        return shumeisaiEntity;
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

    private RString dateFormat9(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
    }

    private RString intToRString(int date) {
        return new RString(String.valueOf(date));
    }
}
