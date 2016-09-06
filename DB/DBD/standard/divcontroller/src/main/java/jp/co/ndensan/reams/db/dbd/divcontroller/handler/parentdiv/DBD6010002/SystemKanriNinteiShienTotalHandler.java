/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.jukyunintei.yokaigointerface.YokaigoInterfaceIchoTorikomi;
import jp.co.ndensan.reams.db.dbd.definition.core.jukyunintei.yokaigointerface.YokaigoInterfaceShurui;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010002.SystemKanriNinteiShienTotalDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * システム管理登録（認定支援システムとのデータ交換）画面のHandlerです。
 *
 * @reamsid_L DBD-3761-010 tz_chengpeng
 */
public class SystemKanriNinteiShienTotalHandler {

    private final SystemKanriNinteiShienTotalDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SystemKanriNinteiShienTotalDiv
     */
    public SystemKanriNinteiShienTotalHandler(SystemKanriNinteiShienTotalDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化
     */
    public void initialize() {
        setDDL項目();
        set初期化ファイル();
        RString iF種類 = div.getSystemKanri().getSystemKanriNinteiShien().getDdlIfShurui().getSelectedKey();
        if (!YokaigoInterfaceShurui.厚労省.getコード().equals(iF種類)) {
            if (YokaigoInterfaceShurui.ＢＳＮ.getコード().equals(iF種類) || YokaigoInterfaceShurui.ＦＮＳ.getコード().equals(iF種類)) {
                div.getSystemKanri().getSystemKanriNinteiShien().getTxtShiboJohoFile().setDisplayNone(false);
            } else if (YokaigoInterfaceShurui.ＮＥＣ.getコード().equals(iF種類)) {
                div.getSystemKanri().getSystemKanriNinteiShien().getTxtTennyuShiboFile().setDisplayNone(false);
            }
        } else {
            div.getSystemKanri().getSystemKanriNinteiShien().getDdlShujiiChosainJohoTorikomi().setDisplayNone(false);
        }
    }

    /**
     * DDL項目の設定
     */
    private void setDDL項目() {
        List<KeyValueDataSource> iF_種類データソース = new ArrayList<>();
        for (YokaigoInterfaceShurui iF_種類 : YokaigoInterfaceShurui.values()) {
            iF_種類データソース.add(new KeyValueDataSource(iF_種類.getコード(), iF_種類.get名称()));
        }
        div.getSystemKanri().getSystemKanriNinteiShien().getDdlIfShurui().setDataSource(iF_種類データソース);

        List<KeyValueDataSource> iF_医調取込データソース = new ArrayList<>();
        for (YokaigoInterfaceIchoTorikomi iF_医調取込 : YokaigoInterfaceIchoTorikomi.values()) {
            iF_医調取込データソース.add(new KeyValueDataSource(iF_医調取込.getコード(), iF_医調取込.get名称()));
        }
        div.getSystemKanri().getSystemKanriNinteiShien().getDdlShujiiChosainJohoTorikomi().setDataSource(iF_医調取込データソース);
    }

    /**
     * 画面初期値の設定
     */
    private void set初期化ファイル() {
        RDate 日期 = RDate.getNowDate();
        div.getSystemKanri().getSystemKanriNinteiShien().getDdlIfShurui()
                .setSelectedKey(DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_ＩＦ種類, 日期, SubGyomuCode.DBD介護受給));
        div.getSystemKanri().getSystemKanriNinteiShien().getDdlShujiiChosainJohoTorikomi()
                .setSelectedKey(DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_医調取込み, 日期, SubGyomuCode.DBD介護受給));
        div.getSystemKanri().getSystemKanriNinteiShien().getTxtNinteiIfKaiteiYMD()
                .setValue(new RDate(DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_認定ＩＦ改定日, 日期, SubGyomuCode.DBD介護受給).toString()));
        div.getSystemKanri().getSystemKanriNinteiShien().getRadShinseiKanren()
                .setSelectedKey(DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_類似変換, 日期, SubGyomuCode.DBD介護受給));
        div.getSystemKanri().getSystemKanriNinteiShien().getRadIkkatsuKoshin()
                .setSelectedKey(DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_一括認定日区分, 日期, SubGyomuCode.DBD介護受給));
        div.getSystemKanri().getSystemKanriNinteiShien().getTxtNinteiKekkaFileOld()
                .setValue(DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_認定結果ＩＦ, 日期, SubGyomuCode.DBD介護受給));
        div.getSystemKanri().getSystemKanriNinteiShien().getTxtShiteiJigyoOutFileOld().
                setValue(DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_指定事業出力Ｆ, 日期, SubGyomuCode.DBD介護受給));
        div.getSystemKanri().getSystemKanriNinteiShien().getTxtChosainOutFileOld().
                setValue(DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_調査員出力Ｆ, 日期, SubGyomuCode.DBD介護受給));
        div.getSystemKanri().getSystemKanriNinteiShien().getTxtIryoKikanOutFileOld().
                setValue(DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_医療機関出力Ｆ, 日期, SubGyomuCode.DBD介護受給));
        div.getSystemKanri().getSystemKanriNinteiShien().getTxtShujiiOutFileOld().
                setValue(DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_主治医出力Ｆ, 日期, SubGyomuCode.DBD介護受給));
        div.getSystemKanri().getSystemKanriNinteiShien().getTxtShinseiJohoOutFileOld().
                setValue(DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_申請情報出力Ｆ, 日期, SubGyomuCode.DBD介護受給));
        div.getSystemKanri().getSystemKanriNinteiShien().getTxtNinteiKekkaFileNew()
                .setValue(DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_認定結果ＩＦ_新, 日期, SubGyomuCode.DBD介護受給));
        div.getSystemKanri().getSystemKanriNinteiShien().getTxtShiteiJigyoOutFileNew().
                setValue(DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_指定事業出力Ｆ_新, 日期, SubGyomuCode.DBD介護受給));
        div.getSystemKanri().getSystemKanriNinteiShien().getTxtChosainOutFileNew().
                setValue(DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_調査員出力Ｆ_新, 日期, SubGyomuCode.DBD介護受給));
        div.getSystemKanri().getSystemKanriNinteiShien().getTxtIryoKikanOutFileNew().
                setValue(DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_医療機関出力Ｆ_新, 日期, SubGyomuCode.DBD介護受給));
        div.getSystemKanri().getSystemKanriNinteiShien().getTxtShujiiOutFileNew().
                setValue(DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_主治医出力Ｆ_新, 日期, SubGyomuCode.DBD介護受給));
        div.getSystemKanri().getSystemKanriNinteiShien().getTxtShinseiJohoOutFileNew().
                setValue(DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_申請情報出力Ｆ_新, 日期, SubGyomuCode.DBD介護受給));
        div.getSystemKanri().getSystemKanriNinteiShien().getTxtShiboJohoFile().
                setValue(DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_転入_資格喪失情報出力Ｆ, 日期, SubGyomuCode.DBD介護受給));
        div.getSystemKanri().getSystemKanriNinteiShien().getTxtTennyuShiboFile().
                setValue(DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_転入_資格喪失情報出力Ｆ, 日期, SubGyomuCode.DBD介護受給));
    }

    /**
     * 画面項目変更保存
     */
    public void 画面項目変更保存() {
        RDate 日期 = RDate.getNowDate();

        YokaigoInterfaceShurui iF種類 = YokaigoInterfaceShurui.toValue(div.getSystemKanri().getSystemKanriNinteiShien().getDdlIfShurui().getSelectedKey());
        BusinessConfig.update(ConfigNameDBD.要介護ＩＦ_ＩＦ種類, iF種類.getコード(), ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        if (!div.getSystemKanri().getSystemKanriNinteiShien().getDdlShujiiChosainJohoTorikomi().isDisplayNone()) {
            YokaigoInterfaceShurui iF医調取込 = YokaigoInterfaceShurui.toValue(div.getSystemKanri().getSystemKanriNinteiShien().getDdlShujiiChosainJohoTorikomi().getSelectedKey());
            BusinessConfig.update(ConfigNameDBD.要介護ＩＦ_医調取込み, iF医調取込.getコード(), ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        }
        RDate 認定ＩＦ改定日 = div.getSystemKanri().getSystemKanriNinteiShien().getTxtNinteiIfKaiteiYMD().getValue();
        BusinessConfig.update(ConfigNameDBD.要介護ＩＦ_認定ＩＦ改定日, 認定ＩＦ改定日.toDateString(), ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        RString 申請関連ＩＦ類字変換 = div.getSystemKanri().getSystemKanriNinteiShien().getRadShinseiKanren().getSelectedKey();
        BusinessConfig.update(ConfigNameDBD.要介護ＩＦ_類似変換, 申請関連ＩＦ類字変換, ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        RString 一括更新認定時のボタン初期値 = div.getSystemKanri().getSystemKanriNinteiShien().getRadIkkatsuKoshin().getSelectedKey();
        BusinessConfig.update(ConfigNameDBD.要介護ＩＦ_一括認定日区分, 一括更新認定時のボタン初期値, ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        RString 旧様式_認定結果ファイル = div.getSystemKanri().getSystemKanriNinteiShien().getTxtNinteiKekkaFileOld().getValue();
        BusinessConfig.update(ConfigNameDBD.要介護ＩＦ_認定結果ＩＦ, 旧様式_認定結果ファイル, ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        RString 旧様式_指定事業出力ファイル = div.getSystemKanri().getSystemKanriNinteiShien().getTxtShiteiJigyoOutFileOld().getValue();
        BusinessConfig.update(ConfigNameDBD.要介護ＩＦ_指定事業出力Ｆ, 旧様式_指定事業出力ファイル, ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        RString 旧様式_調査員出力ファイル = div.getSystemKanri().getSystemKanriNinteiShien().getTxtChosainOutFileOld().getValue();
        BusinessConfig.update(ConfigNameDBD.要介護ＩＦ_調査員出力Ｆ, 旧様式_調査員出力ファイル, ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        RString 旧様式_医療機関出力ファイル = div.getSystemKanri().getSystemKanriNinteiShien().getTxtIryoKikanOutFileOld().getValue();
        BusinessConfig.update(ConfigNameDBD.要介護ＩＦ_医療機関出力Ｆ, 旧様式_医療機関出力ファイル, ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        RString 旧様式_主治医出力ファイル = div.getSystemKanri().getSystemKanriNinteiShien().getTxtShujiiOutFileOld().getValue();
        BusinessConfig.update(ConfigNameDBD.要介護ＩＦ_主治医出力Ｆ, 旧様式_主治医出力ファイル, ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        RString 旧様式_申請情報出力ファイル = div.getSystemKanri().getSystemKanriNinteiShien().getTxtShinseiJohoOutFileOld().getValue();
        BusinessConfig.update(ConfigNameDBD.要介護ＩＦ_申請情報出力Ｆ, 旧様式_申請情報出力ファイル, ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        RString 新様式_認定結果ファイル = div.getSystemKanri().getSystemKanriNinteiShien().getTxtNinteiKekkaFileNew().getValue();
        BusinessConfig.update(ConfigNameDBD.要介護ＩＦ_認定結果ＩＦ_新, 新様式_認定結果ファイル, ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        RString 新様式_指定事業出力ファイル = div.getSystemKanri().getSystemKanriNinteiShien().getTxtShiteiJigyoOutFileNew().getValue();
        BusinessConfig.update(ConfigNameDBD.要介護ＩＦ_指定事業出力Ｆ_新, 新様式_指定事業出力ファイル, ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        RString 新様式_調査員出力ファイル = div.getSystemKanri().getSystemKanriNinteiShien().getTxtChosainOutFileNew().getValue();
        BusinessConfig.update(ConfigNameDBD.要介護ＩＦ_調査員出力Ｆ_新, 新様式_調査員出力ファイル, ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        RString 新様式_医療機関出力ファイル = div.getSystemKanri().getSystemKanriNinteiShien().getTxtIryoKikanOutFileNew().getValue();
        BusinessConfig.update(ConfigNameDBD.要介護ＩＦ_医療機関出力Ｆ_新, 新様式_医療機関出力ファイル, ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        RString 新様式_主治医出力ファイル = div.getSystemKanri().getSystemKanriNinteiShien().getTxtShujiiOutFileNew().getValue();
        BusinessConfig.update(ConfigNameDBD.要介護ＩＦ_主治医出力Ｆ_新, 新様式_主治医出力ファイル, ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        RString 新様式_申請情報出力ファイル = div.getSystemKanri().getSystemKanriNinteiShien().getTxtShinseiJohoOutFileNew().getValue();
        BusinessConfig.update(ConfigNameDBD.要介護ＩＦ_申請情報出力Ｆ_新, 新様式_申請情報出力ファイル, ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        if (!div.getSystemKanri().getSystemKanriNinteiShien().getTxtShiboJohoFile().isDisplayNone()) {
            RString 新様式_死亡情報ファイル = div.getSystemKanri().getSystemKanriNinteiShien().getTxtShiboJohoFile().getValue();
            BusinessConfig.update(ConfigNameDBD.要介護ＩＦ_転入_資格喪失情報出力Ｆ, 新様式_死亡情報ファイル, ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        }
        if (!div.getSystemKanri().getSystemKanriNinteiShien().getTxtTennyuShiboFile().isDisplayNone()) {
            RString 新様式_転入死亡ファイル = div.getSystemKanri().getSystemKanriNinteiShien().getTxtTennyuShiboFile().getValue();
            BusinessConfig.update(ConfigNameDBD.要介護ＩＦ_転入_資格喪失情報出力Ｆ, 新様式_転入死亡ファイル, ResponseHolder.getMenuID().concat(変更理由), RString.EMPTY, 日期);
        }
    }

    private static final RString 変更理由 = new RString("を使用して更新");
}
