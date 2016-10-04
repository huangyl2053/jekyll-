/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010004;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010004.SystemKanriTokubetsuChiikiTotalDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * システム管理登録（特別地域加算減免確認番号）画面のHandlerです。
 *
 * @reamsid_L DBD-3763-010 tz_chengpeng
 */
public class SystemKanriTokubetsuChiikiTotalHandler {

    private static final RString 変更理由 = new RString("を使用して更新");

    private final SystemKanriTokubetsuChiikiTotalDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SystemKanriTokubetsuChiikiTotalDiv
     */
    public SystemKanriTokubetsuChiikiTotalHandler(SystemKanriTokubetsuChiikiTotalDiv div) {
        this.div = div;
    }

    /**
     * 画面項目保存
     */
    public void save画面項目() {
        RDate 日期 = RDate.getNowDate();

        BusinessConfig.update(ConfigNameDBD.特別地域加算減免確認番号_使用有無, div.getSystemKanri().getSystemKanriTokubetsuChiiki().getRadKakuninNo().getSelectedKey(),
                ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        BusinessConfig.update(ConfigNameDBD.特別地域加算減免確認番号_採番基準, div.getSystemKanri().getSystemKanriTokubetsuChiiki().getRadSaiban().getSelectedKey(),
                ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        BusinessConfig.update(ConfigNameDBD.特別地域加算減免確認番号_番号引継ぎ, div.getSystemKanri().getSystemKanriTokubetsuChiiki().getRadNoHikitsugi().getSelectedKey(),
                ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        BusinessConfig.update(ConfigNameDBD.特別地域加算減免確認番号_有効桁数,
                new RString(div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtYukoKetasu().getValue().toString()),
                ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        BusinessConfig.update(ConfigNameDBD.特別地域加算減免減額率_分子,
                new RString(div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtGengakuRitsu1().getValue().toString()),
                ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        BusinessConfig.update(ConfigNameDBD.特別地域加算減免減額率_分母,
                new RString(div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtGengakuRitsu2().getValue().toString()),
                ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
    }

    /**
     * 画面初期化
     */
    public void initialize() {
        RDate 日期 = RDate.getNowDate();
        div.getSystemKanri().getSystemKanriTokubetsuChiiki().getRadKakuninNo()
                .setSelectedKey(DbBusinessConfig.get(ConfigNameDBD.特別地域加算減免確認番号_使用有無, 日期, SubGyomuCode.DBD介護受給));
        div.getSystemKanri().getSystemKanriTokubetsuChiiki().getRadSaiban()
                .setSelectedKey(DbBusinessConfig.get(ConfigNameDBD.特別地域加算減免確認番号_採番基準, 日期, SubGyomuCode.DBD介護受給));
        div.getSystemKanri().getSystemKanriTokubetsuChiiki().getRadNoHikitsugi()
                .setSelectedKey(DbBusinessConfig.get(ConfigNameDBD.特別地域加算減免確認番号_番号引継ぎ, 日期, SubGyomuCode.DBD介護受給));
        div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtYukoKetasu()
                .setValue(new Decimal(DbBusinessConfig.get(ConfigNameDBD.特別地域加算減免確認番号_有効桁数, 日期, SubGyomuCode.DBD介護受給).toString()));
        div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtGengakuRitsu1()
                .setValue(new Decimal(DbBusinessConfig.get(ConfigNameDBD.特別地域加算減免減額率_分子, 日期, SubGyomuCode.DBD介護受給).toString()));
        div.getSystemKanri().getSystemKanriTokubetsuChiiki().getTxtGengakuRitsu2()
                .setValue(new Decimal(DbBusinessConfig.get(ConfigNameDBD.特別地域加算減免減額率_分母, 日期, SubGyomuCode.DBD介護受給).toString()));

    }

}
