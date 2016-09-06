/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0520011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhoShikakuInfo;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0520011.KokuhoShikakuInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KokuhoShikakuInfoManager;
import jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin.TorokuKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.HokenshaKosei;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 国保資格情報登録
 *
 * @reamsid_L DBD-5730-010 tianyh
 */
public class KokuhoShikakuInfoPanelHandler {

    private final KokuhoShikakuInfoPanelDiv div;
    private KokuhoShikakuInfo 国保資格詳細情報;
    private static final RString コード = new RString("2");

    /**
     * コンストラクタです。
     *
     * @param div KokuhoShikakuInfoPanelDiv
     */
    public KokuhoShikakuInfoPanelHandler(KokuhoShikakuInfoPanelDiv div) {
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
        if (DonyuKeitaiCode.事務広域.getCode().equals(介護導入形態)) {
            介護導入形態 = HokenshaKosei.広域保険者.getコード();
        }
        if (DonyuKeitaiCode.事務単一.getCode().equals(介護導入形態)) {
            介護導入形態 = HokenshaKosei.単一市町村.getコード();
        }
        if (DonyuKeitaiCode.事務構成市町村.getCode().equals(介護導入形態)) {
            介護導入形態 = HokenshaKosei.広域市町村.getコード();
        }
        div.getHeaderPanel().getCcdAtenaInfo().setKaigoDonyuKeitai(介護導入形態);
        div.getHeaderPanel().getCcdAtenaInfo().setShoriType(コード);
        div.getHeaderPanel().getCcdAtenaInfo().setShinseishaJohoByShikibetsuCode(ShinseishoKanriNo.EMPTY, shikibetsuCode);
        div.getHeaderPanel().getCcdAtenaInfo().initialize();
        div.getHeaderPanel().getCcdShikakuInfo().initialize(shichosonSecurityJoho.get市町村情報().get市町村コード().value(), 被保険者番号.value());
        KokuhoShikakuInfoManager kokuhoShikakuInfoManager = KokuhoShikakuInfoManager.createInstance();
        国保資格詳細情報 = kokuhoShikakuInfoManager.get国保資格詳細情報(shikibetsuCode);
        if (国保資格詳細情報 != null) {
            if (国保資格詳細情報.get国保保険証番号() != null && !国保資格詳細情報.get国保保険証番号().isEmpty()) {
                div.getMeisaiPanel().getTxtKokuhoHokenshoNo().setValue(new Decimal(国保資格詳細情報.get国保保険証番号().toString()));
            }
            if (国保資格詳細情報.get国保個人番号() != null && !国保資格詳細情報.get国保個人番号().isEmpty()) {
                div.getMeisaiPanel().getTxtKokuhoKojinNo().setValue(国保資格詳細情報.get国保個人番号());
            }
            if (国保資格詳細情報.get資格取得日() != null) {
                div.getMeisaiPanel().getTxtShikakuShutokuYMD().setValue(
                        new RDate(国保資格詳細情報.get資格取得日().toString()));
            }
            if (国保資格詳細情報.get資格喪失日() != null) {
                div.getMeisaiPanel().getTxtShikakuSoshitsuYMD().setValue(
                        new RDate(国保資格詳細情報.get資格喪失日().toString()));
            }
            div.getMeisaiPanel().getTxtKokuhoNo().setValue(国保資格詳細情報.get国保番号());
            List<RString> keys = new ArrayList<>();
            if (TorokuKubun.取込.getコード().equals(国保資格詳細情報.get登録区分())) {
                keys.add(new RString("key0"));
            }
            div.getMeisaiPanel().getChkTorokuKubun().setSelectedItemsByKey(keys);
            set文字コード();
            前排他の設定(shikibetsuCode, 国保資格詳細情報.get履歴番号());
        } else {
            前排他の設定(shikibetsuCode, RString.EMPTY);
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
        KokuhoShikakuInfoManager kokuhoShikakuInfoManager = KokuhoShikakuInfoManager.createInstance();
        if (国保資格詳細情報 != null) {
            setkokuhoShikakuInfo(国保資格詳細情報);
            if (kokuhoShikakuInfoManager.save国保資格詳細情報(国保資格詳細情報)) {
                前排他制御の解除(shikibetsuCode, 国保資格詳細情報.get履歴番号());
                flag = true;
            }
        } else {
            KokuhoShikakuInfo kokuhoShikakuInfo2 = new KokuhoShikakuInfo(shikibetsuCode, new RString("0001"));
            setkokuhoShikakuInfo(kokuhoShikakuInfo2);
            if (kokuhoShikakuInfoManager.save国保資格詳細情報(kokuhoShikakuInfo2)) {
                前排他制御の解除(shikibetsuCode, kokuhoShikakuInfo2.get履歴番号());
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 「一覧へ戻る」ボタンの処理
     *
     * @param shikibetsuCode shikibetsuCode
     * @param div FutangendogakuShinseiDiv
     */
    public void onClick_btnBack(ShikibetsuCode shikibetsuCode, KokuhoShikakuInfoPanelDiv div) {
        if (国保資格詳細情報 != null) {
            前排他制御の解除(shikibetsuCode, 国保資格詳細情報.get履歴番号());
        } else {
            前排他制御の解除(shikibetsuCode, RString.EMPTY);
        }
    }

    private void set文字コード() {
        RString 文字コード = DbBusinessConfig.get(ConfigNameDBC.国保_後期高齢ＩＦ_国保ＩＦ種類, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (new RString("2").equals(文字コード)) {
            if (国保資格詳細情報.get退職該当日() != null) {
                div.getMeisaiPanel().getTxtTaishokuGaitoYMD().setValue(
                        new RDate(国保資格詳細情報.get退職該当日().toString()));
            }
            if (国保資格詳細情報.get退職非該当日() != null) {
                div.getMeisaiPanel().getTxtTaishokuHigaitoYMD().setValue(
                        new RDate(国保資格詳細情報.get退職非該当日().toString()));
            }
            div.getMeisaiPanel().getDdlKojinKubunCode().setSelectedKey(国保資格詳細情報.get個人区分コード());
        } else {
            div.getMeisaiPanel().getTxtTaishokuGaitoYMD().setDisplayNone(true);
            div.getMeisaiPanel().getTxtTaishokuHigaitoYMD().setDisplayNone(true);
            div.getMeisaiPanel().getDdlKojinKubunCode().setDisplayNone(true);
        }
    }

    private void setkokuhoShikakuInfo(KokuhoShikakuInfo kokuhoShikakuInfo) {
        if (div.getTxtKokuhoHokenshoNo().getValue() != null) {
            kokuhoShikakuInfo.createBuilderForEdit().set国保保険証番号(new RString(div.getTxtKokuhoHokenshoNo().getValue().toString())).build();
        }
//        if (!div.getDdlKokuhoHokenshaNo().getSelectedValue().isNullOrEmpty()) {
//            kokuhoShikakuInfo.createBuilderForEdit().set国保保険者番号(div.getDdlKokuhoHokenshaNo().getSelectedValue()).build();
//        }
        if (!div.getTxtKokuhoKojinNo().getValue().isNullOrEmpty()) {
            kokuhoShikakuInfo.createBuilderForEdit().set国保個人番号(div.getTxtKokuhoKojinNo().getValue()).build();
        }
        if (!div.getTxtKokuhoNo().getValue().isNullOrEmpty()) {
            kokuhoShikakuInfo.createBuilderForEdit().set国保番号(div.getTxtKokuhoNo().getValue()).build();
        }
        if (div.getTxtShikakuShutokuYMD().getValue() != null) {
            kokuhoShikakuInfo.createBuilderForEdit().set資格取得日(div.getTxtShikakuShutokuYMD().getValue().toDateString()).build();
        }
        if (div.getTxtShikakuSoshitsuYMD().getValue() != null) {
            kokuhoShikakuInfo.createBuilderForEdit().set資格喪失日(div.getTxtShikakuShutokuYMD().getValue().toDateString()).build();
        }
        if (div.getTxtTaishokuGaitoYMD().getValue() != null) {
            kokuhoShikakuInfo.createBuilderForEdit().set退職該当日(div.getTxtTaishokuGaitoYMD().getValue().toDateString()).build();
        }
        if (div.getTxtTaishokuHigaitoYMD().getValue() != null) {
            kokuhoShikakuInfo.createBuilderForEdit().set退職非該当日(div.getTxtTaishokuHigaitoYMD().getValue().toDateString()).build();
        }
        if (!div.getDdlKojinKubunCode().getSelectedValue().isNullOrEmpty()) {
            kokuhoShikakuInfo.createBuilderForEdit().set個人区分コード(div.getDdlKojinKubunCode().getSelectedValue()).build();
        }
        if (div.getChkTorokuKubun().getSelectedKeys().size() > 0) {
            kokuhoShikakuInfo.createBuilderForEdit().set登録区分(new RString("1")).build();
        } else {
            kokuhoShikakuInfo.createBuilderForEdit().set登録区分(new RString("0")).build();
        }
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
