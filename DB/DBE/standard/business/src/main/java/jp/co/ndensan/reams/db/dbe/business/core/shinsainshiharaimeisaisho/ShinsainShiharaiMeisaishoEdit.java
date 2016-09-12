/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsainshiharaimeisaisho;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbi.HoshuShiharaiJunbiRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会委員報酬支払明細書のEditクラスです。
 *
 * @reamsid_L DBE-1980-020 suguangjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsainShiharaiMeisaishoEdit {

    /**
     * 介護認定審査会委員報酬支払明細書の編集処理です。
     *
     * @param entity HoshuShiharaiJunbiRelateEntity
     * @return ShinsainShiharaimeisaisho
     */
    public ShinsainShiharaimeisaisho getShinsainShiharaimeisaishoEntity(HoshuShiharaiJunbiRelateEntity entity) {
        ShinsainShiharaimeisaisho meisaisho = new ShinsainShiharaimeisaisho();
        meisaisho.setタイトル(DbBusinessConfig.get(ConfigNameDBE.介護認定審査会委員報酬支払明細書, RDate.getNowDate(),
                SubGyomuCode.DBE認定支援));
        meisaisho.set保険者名(entity.getShichosonMeisho());
        meisaisho.set審査委員名(entity.getShinsakaiIinShimei().value());
        meisaisho.set審査委員コード(entity.getShinsakaiIinCode());
        meisaisho.set帳票印刷日時(dateFormat142());
        meisaisho.set被保険者番号(entity.getHihokenshaNo());
        meisaisho.set被保険者氏名(entity.getHihokenshaName().value());
        meisaisho.set生年月日(dateFormat(entity.getSeinengappiYMD()));
        meisaisho.set査会開催年月日(dateFormat(entity.getShinsakaiKaisaiYMD()));
        meisaisho.set報酬総額(new RString(entity.getHoshu()));
        meisaisho.set費用弁償(new RString(entity.getShinsakaiKotsuhi()));
        meisaisho.set税額控除(new RString(entity.getShinsakaiKojoZeigaku()));
        meisaisho.set報酬合計(new RString(entity.getShinsakaiHoshuGokei()));
        return meisaisho;
    }

    private RString dateFormat(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().toDateString();
    }

    private RString dateFormat142() {
        RDateTime dateTime = RDateTime.now();
        RStringBuilder 帳票印刷日時 = new RStringBuilder();
        帳票印刷日時.append(dateTime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        帳票印刷日時.append(RString.HALF_SPACE);
        帳票印刷日時.append(dateTime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        return 帳票印刷日時.toRString();
    }
}
