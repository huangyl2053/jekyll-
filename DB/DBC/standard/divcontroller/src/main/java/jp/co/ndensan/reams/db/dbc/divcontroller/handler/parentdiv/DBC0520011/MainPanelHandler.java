/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0520011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhoShikakuInfo;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0520011.MainPanelDiv;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KokuhoShikakuInfoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 国保資格情報登録
 *
 * @reamsid_L DBD-5730-010 tianyh
 */
public class MainPanelHandler {

    private final MainPanelDiv div;

    private static final RString コード = new RString("2");
    private static final RString コード111 = new RString("111");
    private static final RString コード112 = new RString("112");
    private static final RString コード120 = new RString("120");
    private static final RString コード211 = new RString("211");
    private static final RString 単一市町村 = new RString("1");
    private static final RString 広域市町村 = new RString("2");
    private static final RString 広域保険者 = new RString("3");
    private static final RString 広域審査会 = new RString("4");

    /**
     * コンストラクタです。
     *
     * @param div mainPanelDiv
     */
    public MainPanelHandler(MainPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化
     *
     * @param shikibetsuCode ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     */
    public void initialize(ShikibetsuCode shikibetsuCode, HihokenshaNo 被保険者番号) {
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        RString 介護導入形態 = shichosonSecurityJoho.get導入形態コード().value();
        if (介護導入形態.equals(コード111)) {
            介護導入形態 = 広域保険者;
        }
        if (介護導入形態.equals(コード112)) {
            介護導入形態 = 広域市町村;
        }
        if (介護導入形態.equals(コード120)) {
            介護導入形態 = 単一市町村;
        }
        if (介護導入形態.equals(コード211)) {
            介護導入形態 = 広域審査会;
        }
        div.getHeaderPanel().getCcdAtenaInfo().setKaigoDonyuKeitai(介護導入形態);
        div.getHeaderPanel().getCcdAtenaInfo().setShoriType(コード);
        div.getHeaderPanel().getCcdAtenaInfo().setShinseishaJohoByShikibetsuCode(ShinseishoKanriNo.EMPTY, shikibetsuCode);
        div.getHeaderPanel().getCcdAtenaInfo().initialize();
        div.getHeaderPanel().getCcdShikakuInfo().set被保険者番号(被保険者番号.value());
        KokuhoShikakuInfoManager kokuhoShikakuInfoManager = new KokuhoShikakuInfoManager();
        KokuhoShikakuInfo kokuhoShikakuInfo = kokuhoShikakuInfoManager.get国保資格詳細情報(shikibetsuCode);
        if (kokuhoShikakuInfo != null) {
            if (kokuhoShikakuInfo.get国保保険証番号() != null && !kokuhoShikakuInfo.get国保保険証番号().isEmpty()) {
                div.getMeisaiPanel().getTxtKokuhoHokenshoNo().setValue(new Decimal(kokuhoShikakuInfo.get国保保険証番号().toString()));
            }
            if (kokuhoShikakuInfo.get国保個人番号() != null && !kokuhoShikakuInfo.get国保個人番号().isEmpty()) {
                div.getMeisaiPanel().getTxtKokuhoKojinNo().setValue(kokuhoShikakuInfo.get国保個人番号());
            }
            div.getMeisaiPanel().getTxtShikakuShutokuYMD().setValue(
                    new RDate(edit日付パターン1(new FlexibleDate(kokuhoShikakuInfo.get資格取得日())).toString()));
            div.getMeisaiPanel().getTxtShikakuSoshitsuYMD().setValue(
                    new RDate(edit日付パターン1(new FlexibleDate(kokuhoShikakuInfo.get資格喪失日())).toString()));
            div.getMeisaiPanel().getTxtKokuhoNo().setValue(kokuhoShikakuInfo.get国保番号());
            List<RString> keys = new ArrayList<>();
            if (kokuhoShikakuInfo.get登録区分().equals(new RString("1"))) {
                keys.add(new RString("key0"));
            }
            div.getMeisaiPanel().getChkTorokuKubun().setSelectedItemsByKey(keys);
            RString 文字コード = DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_国保ＩＦ種類, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
            if (文字コード.equals(new RString("2"))) {
                div.getMeisaiPanel().getTxtTaishokuGaitoYMD().setValue(
                        new RDate(edit日付パターン1(new FlexibleDate(kokuhoShikakuInfo.get退職該当日())).toString()));
                div.getMeisaiPanel().getTxtTaishokuHigaitoYMD().setValue(
                        new RDate(edit日付パターン1(new FlexibleDate(kokuhoShikakuInfo.get退職非該当日())).toString()));
                div.getMeisaiPanel().getDdlKojinKubunCode().setSelectedKey(kokuhoShikakuInfo.get個人区分コード());
            } else {
                div.getMeisaiPanel().getTxtTaishokuGaitoYMD().setDisplayNone(true);
                div.getMeisaiPanel().getTxtTaishokuHigaitoYMD().setDisplayNone(true);
                div.getMeisaiPanel().getDdlKojinKubunCode().setDisplayNone(true);
            }
            前排他の設定(shikibetsuCode, kokuhoShikakuInfo.get履歴番号());
        }
    }

    /**
     * データを保存する
     *
     * @param shikibetsuCode ShikibetsuCode
     * @return boolean
     */
    public boolean updateorinsert(ShikibetsuCode shikibetsuCode) {
        boolean flag = false;
        KokuhoShikakuInfoManager kokuhoShikakuInfoManager = new KokuhoShikakuInfoManager();
        KokuhoShikakuInfo kokuhoShikakuInfo = kokuhoShikakuInfoManager.get国保資格詳細情報(shikibetsuCode);
        if (kokuhoShikakuInfo != null) {
            setkokuhoShikakuInfo(kokuhoShikakuInfo);
            if (kokuhoShikakuInfoManager.save国保資格詳細情報(kokuhoShikakuInfo)) {
                前排他制御の解除(shikibetsuCode, kokuhoShikakuInfo.get履歴番号());
                flag = true;
            }
        } else {
            KokuhoShikakuInfo kokuhoShikakuInfo2 = new KokuhoShikakuInfo(shikibetsuCode, new RString("0001"));
            setkokuhoShikakuInfo(kokuhoShikakuInfo2);
            if (kokuhoShikakuInfoManager.save国保資格詳細情報(kokuhoShikakuInfo2)) {
                flag = true;
            }
        }
        return flag;
    }

    private void setkokuhoShikakuInfo(KokuhoShikakuInfo kokuhoShikakuInfo) {
        if (div.getTxtKokuhoHokenshoNo().getValue() != null) {
            kokuhoShikakuInfo.createBuilderForEdit().set国保保険証番号(new RString(div.getTxtKokuhoHokenshoNo().getValue().toString()));
        }
//        if (!div.getDdlKokuhoHokenshaNo().getSelectedValue().isNullOrEmpty()) {
//            kokuhoShikakuInfo.createBuilderForEdit().set国保保険者番号(div.getDdlKokuhoHokenshaNo().getSelectedValue());
//        }
        if (!div.getTxtKokuhoKojinNo().getValue().isNullOrEmpty()) {
            kokuhoShikakuInfo.createBuilderForEdit().set国保個人番号(div.getTxtKokuhoKojinNo().getValue());
        }
        if (!div.getTxtKokuhoNo().getValue().isNullOrEmpty()) {
            kokuhoShikakuInfo.createBuilderForEdit().set国保番号(div.getTxtKokuhoNo().getValue());
        }
        if (div.getTxtShikakuShutokuYMD().getValue() != null) {
            kokuhoShikakuInfo.createBuilderForEdit().set資格取得日(div.getTxtShikakuShutokuYMD().getValue().toDateString());
        }
        if (div.getTxtShikakuSoshitsuYMD().getValue() != null) {
            kokuhoShikakuInfo.createBuilderForEdit().set資格喪失日(div.getTxtShikakuShutokuYMD().getValue().toDateString());
        }
        if (div.getTxtTaishokuGaitoYMD().getValue() != null) {
            kokuhoShikakuInfo.createBuilderForEdit().set退職該当日(div.getTxtTaishokuGaitoYMD().getValue().toDateString());
        }
        if (div.getTxtTaishokuHigaitoYMD().getValue() != null) {
            kokuhoShikakuInfo.createBuilderForEdit().set退職非該当日(div.getTxtTaishokuHigaitoYMD().getValue().toDateString());
        }
        if (!div.getDdlKojinKubunCode().getSelectedValue().isNullOrEmpty()) {
            kokuhoShikakuInfo.createBuilderForEdit().set個人区分コード(div.getDdlKojinKubunCode().getSelectedValue());
        }
        if (div.getChkTorokuKubun().getSelectedKeys().size() > 0) {
            kokuhoShikakuInfo.createBuilderForEdit().set登録区分(new RString("1"));
        } else {
            kokuhoShikakuInfo.createBuilderForEdit().set登録区分(new RString("0"));
        }
    }

    private RString edit日付パターン1(FlexibleDate date) {
        return date == null ? RString.EMPTY : date.wareki().toDateString();
    }

    private void 前排他の設定(ShikibetsuCode shikibetsuCode, RString rirekiNo) {
//        LockingKey 排他キー = new LockingKey(shikibetsuCode.value().concat(rirekiNo));
//        RealInitialLocker.lock(new LockingKey(排他キー));
        LockingKey 排他キー = new LockingKey(new RString("DBCShikibetsuCode").concat(shikibetsuCode.getColumnValue()).
                concat(new RString("DBCrirekiNo")).concat(rirekiNo));
        RealInitialLocker.lock(new LockingKey(排他キー));
    }

    private void 前排他制御の解除(ShikibetsuCode shikibetsuCode, RString rirekiNo) {
//        LockingKey 排他キー = new LockingKey(shikibetsuCode.value().concat(rirekiNo));
        LockingKey 排他キー = new LockingKey(new RString("DBCShikibetsuCode").concat(shikibetsuCode.getColumnValue()).
                concat(new RString("DBCrirekiNo")).concat(rirekiNo));
        RealInitialLocker.release(new LockingKey(排他キー));
    }
}
