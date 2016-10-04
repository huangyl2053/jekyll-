/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010003;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010003.SystemKanriShakaiFukushiTotalDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * システム管理登録（社会福祉法人確認番号）画面のHandlerです。
 *
 * @reamsid_L DBD-3762-010 tz_chengpeng
 */
public class SystemKanriShakaiFukushiTotalHandler {

    private final SystemKanriShakaiFukushiTotalDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SystemKanriShakaiFukushiTotalDiv
     */
    public SystemKanriShakaiFukushiTotalHandler(SystemKanriShakaiFukushiTotalDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化
     */
    public void initialize() {
        RDate 日期 = RDate.getNowDate();
        div.getSystemKanri().getSystemKanriShakaiFukushi().getRadKakuninNo()
                .setSelectedKey(DbBusinessConfig.get(ConfigNameDBD.社会福祉法人減免確認番号_使用有無, 日期, SubGyomuCode.DBD介護受給));
        div.getSystemKanri().getSystemKanriShakaiFukushi().getRadSaiban()
                .setSelectedKey(DbBusinessConfig.get(ConfigNameDBD.社会福祉法人減免確認番号_採番基準, 日期, SubGyomuCode.DBD介護受給));
        div.getSystemKanri().getSystemKanriShakaiFukushi().getRadNoHikitsugi()
                .setSelectedKey(DbBusinessConfig.get(ConfigNameDBD.社会福祉法人減免確認番号_番号引継ぎ, 日期, SubGyomuCode.DBD介護受給));
        div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtYukoKetasu()
                .setValue(new Decimal(DbBusinessConfig.get(ConfigNameDBD.社会福祉法人減免確認番号_有効桁数, 日期, SubGyomuCode.DBD介護受給).toString()));
        div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtGenmenRitsu1()
                .setValue(new Decimal(DbBusinessConfig.get(ConfigNameDBD.社会福祉法人減免減免率_分子, 日期, SubGyomuCode.DBD介護受給).toString()));
        div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtGenmenRitsu2()
                .setValue(new Decimal(DbBusinessConfig.get(ConfigNameDBD.社会福祉法人減免減免率_分母, 日期, SubGyomuCode.DBD介護受給).toString()));
        div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtKeigenRitsu1()
                .setValue(new Decimal(DbBusinessConfig.get(ConfigNameDBD.社会福祉法人軽減軽減率_分子, 日期, SubGyomuCode.DBD介護受給).toString()));
        div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtKeigenRitsu2()
                .setValue(new Decimal(DbBusinessConfig.get(ConfigNameDBD.社会福祉法人軽減軽減率_分母, 日期, SubGyomuCode.DBD介護受給).toString()));
    }

    /**
     * 画面項目変更保存
     */
    public void save画面項目() {
        RDate 日期 = RDate.getNowDate();

        BusinessConfig.update(ConfigNameDBD.社会福祉法人減免確認番号_使用有無, div.getSystemKanri().getSystemKanriShakaiFukushi().getRadKakuninNo().getSelectedKey(),
                ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        BusinessConfig.update(ConfigNameDBD.社会福祉法人減免確認番号_採番基準, div.getSystemKanri().getSystemKanriShakaiFukushi().getRadSaiban().getSelectedKey(),
                ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        BusinessConfig.update(ConfigNameDBD.社会福祉法人減免確認番号_番号引継ぎ, div.getSystemKanri().getSystemKanriShakaiFukushi().getRadNoHikitsugi().getSelectedKey(),
                ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        BusinessConfig.update(ConfigNameDBD.社会福祉法人減免確認番号_有効桁数,
                new RString(div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtYukoKetasu().getValue().toString()),
                ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        BusinessConfig.update(ConfigNameDBD.社会福祉法人減免減免率_分子,
                new RString(div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtGenmenRitsu1().getValue().toString()),
                ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        BusinessConfig.update(ConfigNameDBD.社会福祉法人減免減免率_分母,
                new RString(div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtGenmenRitsu2().getValue().toString()),
                ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        BusinessConfig.update(ConfigNameDBD.社会福祉法人軽減軽減率_分子,
                new RString(div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtKeigenRitsu1().getValue().toString()),
                ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        BusinessConfig.update(ConfigNameDBD.社会福祉法人軽減軽減率_分母,
                new RString(div.getSystemKanri().getSystemKanriShakaiFukushi().getTxtKeigenRitsu2().getValue().toString()),
                ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
    }

    private static final RString 変更理由 = new RString("を使用して更新");
}
