/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010002;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010002.SystemKanriNinteiShienTotalDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * システム管理登録（認定支援システムとのデータ交換）画面のチェックロジックです。
 *
 * @reamsid_L DBD-3761-010 tz_chengpeng
 */
public enum SystemKanriNinteiShienTotalSpec implements IPredicate<SystemKanriNinteiShienTotalDiv> {

    /**
     * 認定ＩＦ改定日が未入力チェック。
     */
    認定ＩＦ改定日が未入力チェック {
                @Override
                public boolean apply(SystemKanriNinteiShienTotalDiv div) {
                    RDate 認定ＩＦ改定日 = div.getSystemKanri().getSystemKanriNinteiShien().
                    getTxtNinteiIfKaiteiYMD().getValue();
                    return null != 認定ＩＦ改定日;
                }
            },
    /**
     * 旧様式_認定結果ファイルが未入力チェック。
     */
    旧様式_認定結果ファイルが未入力チェック {
                @Override
                public boolean apply(SystemKanriNinteiShienTotalDiv div) {
                    RString 旧様式_認定結果ファイル = div.getSystemKanri().getSystemKanriNinteiShien().
                    getTxtNinteiKekkaFileOld().getValue();
                    return !旧様式_認定結果ファイル.isNullOrEmpty();
                }
            },
    /**
     * 旧様式_指定事業出力ファイルが未入力チェック。
     */
    旧様式_指定事業出力ファイルが未入力チェック {
                @Override
                public boolean apply(SystemKanriNinteiShienTotalDiv div) {
                    RString 旧様式_指定事業出力ファイル = div.getSystemKanri().getSystemKanriNinteiShien().
                    getTxtShiteiJigyoOutFileOld().getValue();
                    return !旧様式_指定事業出力ファイル.isNullOrEmpty();
                }
            },
    /**
     * 旧様式_調査員出力ファイルが未入力チェック。
     */
    旧様式_調査員出力ファイルが未入力チェック {
                @Override
                public boolean apply(SystemKanriNinteiShienTotalDiv div) {
                    RString 旧様式_調査員出力ファイル = div.getSystemKanri().getSystemKanriNinteiShien().
                    getTxtChosainOutFileOld().getValue();
                    return !旧様式_調査員出力ファイル.isNullOrEmpty();
                }
            },
    /**
     * 旧様式_医療機関出力ファイルが未入力チェック。
     */
    旧様式_医療機関出力ファイルが未入力チェック {
                @Override
                public boolean apply(SystemKanriNinteiShienTotalDiv div) {
                    RString 旧様式_医療機関出力ファイル = div.getSystemKanri().getSystemKanriNinteiShien().
                    getTxtIryoKikanOutFileOld().getValue();
                    return !旧様式_医療機関出力ファイル.isNullOrEmpty();
                }
            },
    /**
     * 旧様式_主治医出力ファイルが未入力チェック。
     */
    旧様式_主治医出力ファイルが未入力チェック {
                @Override
                public boolean apply(SystemKanriNinteiShienTotalDiv div) {
                    RString 旧様式_主治医出力ファイル = div.getSystemKanri().getSystemKanriNinteiShien().
                    getTxtShujiiOutFileOld().getValue();
                    return !旧様式_主治医出力ファイル.isNullOrEmpty();
                }
            },
    /**
     * 旧様式_申請情報出力ファイルが未入力チェック。
     */
    旧様式_申請情報出力ファイルが未入力チェック {
                @Override
                public boolean apply(SystemKanriNinteiShienTotalDiv div) {
                    RString 旧様式_申請情報出力ファイル = div.getSystemKanri().getSystemKanriNinteiShien().
                    getTxtShinseiJohoOutFileOld().getValue();
                    return !旧様式_申請情報出力ファイル.isNullOrEmpty();
                }
            },
    /**
     * 新様式_認定結果ファイルが未入力チェック。
     */
    新様式_認定結果ファイルが未入力チェック {
                @Override
                public boolean apply(SystemKanriNinteiShienTotalDiv div) {
                    RString 新様式_認定結果ファイル = div.getSystemKanri().getSystemKanriNinteiShien().
                    getTxtNinteiKekkaFileNew().getValue();
                    return !新様式_認定結果ファイル.isNullOrEmpty();
                }
            },
    /**
     * 新様式_指定事業出力ファイルが未入力チェック。
     */
    新様式_指定事業出力ファイルが未入力チェック {
                @Override
                public boolean apply(SystemKanriNinteiShienTotalDiv div) {
                    RString 新様式_指定事業出力ファイル = div.getSystemKanri().getSystemKanriNinteiShien().
                    getTxtShiteiJigyoOutFileNew().getValue();
                    return !新様式_指定事業出力ファイル.isNullOrEmpty();
                }
            },
    /**
     * 新様式_調査員出力ファイルが未入力チェック。
     */
    新様式_調査員出力ファイルが未入力チェック {
                @Override
                public boolean apply(SystemKanriNinteiShienTotalDiv div) {
                    RString 新様式_調査員出力ファイル = div.getSystemKanri().getSystemKanriNinteiShien().
                    getTxtChosainOutFileNew().getValue();
                    return !新様式_調査員出力ファイル.isNullOrEmpty();
                }
            },
    /**
     * 新様式_医療機関出力ファイルが未入力チェック。
     */
    新様式_医療機関出力ファイルが未入力チェック {
                @Override
                public boolean apply(SystemKanriNinteiShienTotalDiv div) {
                    RString 新様式_医療機関出力ファイル = div.getSystemKanri().getSystemKanriNinteiShien().
                    getTxtIryoKikanOutFileNew().getValue();
                    return !新様式_医療機関出力ファイル.isNullOrEmpty();
                }
            },
    /**
     * 新様式_主治医出力ファイルが未入力チェック。
     */
    新様式_主治医出力ファイルが未入力チェック {
                @Override
                public boolean apply(SystemKanriNinteiShienTotalDiv div) {
                    RString 新様式_主治医出力ファイル = div.getSystemKanri().getSystemKanriNinteiShien().
                    getTxtShujiiOutFileNew().getValue();
                    return !新様式_主治医出力ファイル.isNullOrEmpty();
                }
            },
    /**
     * 新様式_申請情報出力ファイルが未入力チェック。
     */
    新様式_申請情報出力ファイルが未入力チェック {
                @Override
                public boolean apply(SystemKanriNinteiShienTotalDiv div) {
                    RString 新様式_申請情報出力ファイル = div.getSystemKanri().getSystemKanriNinteiShien().
                    getTxtShinseiJohoOutFileNew().getValue();
                    return !新様式_申請情報出力ファイル.isNullOrEmpty();
                }
            },
    /**
     * 新様式_死亡情報ファイルが未入力チェック。
     */
    新様式_死亡情報ファイルが未入力チェック {
                @Override
                public boolean apply(SystemKanriNinteiShienTotalDiv div) {
                    RString 死亡情報ファイル = div.getSystemKanri().getSystemKanriNinteiShien().
                    getTxtShiboJohoFile().getValue();
                    if (!div.getSystemKanri().getSystemKanriNinteiShien().getTxtShiboJohoFile().isDisplayNone()) {
                        return !死亡情報ファイル.isNullOrEmpty();
                    }
                    return true;
                }
            },
    /**
     * 新様式_転入死亡ファイルが未入力チェック。
     */
    新様式_転入死亡ファイルが未入力チェック {
                @Override
                public boolean apply(SystemKanriNinteiShienTotalDiv div) {
                    RString 転入死亡ファイル = div.getSystemKanri().getSystemKanriNinteiShien().
                    getTxtTennyuShiboFile().getValue();
                    if (!div.getSystemKanri().getSystemKanriNinteiShien().getTxtTennyuShiboFile().isDisplayNone()) {
                        return !転入死亡ファイル.isNullOrEmpty();
                    }
                    return true;
                }
            },
    /**
     * 対象更新のデータ変更チェック
     */
    対象更新のデータ変更チェック {
                @Override
                public boolean apply(SystemKanriNinteiShienTotalDiv div) {
                    RDate 日期 = new RDate(FlexibleDate.getNowDate().toString());

                    RString ＩＦ種類_初期データ = DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_ＩＦ種類, 日期, SubGyomuCode.DBD介護受給);
                    RString 医調取込み_初期データ = DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_医調取込み, 日期, SubGyomuCode.DBD介護受給);
                    RString 認定ＩＦ改定日_初期データ = DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_認定ＩＦ改定日, 日期, SubGyomuCode.DBD介護受給);
                    RString 類似変換_初期データ = DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_類似変換, 日期, SubGyomuCode.DBD介護受給);
                    RString 一括認定日区分_初期データ = DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_一括認定日区分, 日期, SubGyomuCode.DBD介護受給);

                    RString ＩＦ種類_変更データ = div.getSystemKanri().getSystemKanriNinteiShien().getDdlIfShurui().getSelectedKey();
                    RString 医調取込み_変更データ = div.getSystemKanri().getSystemKanriNinteiShien().getDdlShujiiChosainJohoTorikomi().getSelectedKey();
                    RDate 認定ＩＦ改定日 = div.getSystemKanri().getSystemKanriNinteiShien().getTxtNinteiIfKaiteiYMD().getValue();
                    RString 認定ＩＦ改定日_変更データ = 認定ＩＦ改定日 != null ? 認定ＩＦ改定日.toDateString() : null;
                    RString 類似変換_変更データ = div.getSystemKanri().getSystemKanriNinteiShien().getRadShinseiKanren().getSelectedKey();
                    RString 一括認定日区分_変更データ = div.getSystemKanri().getSystemKanriNinteiShien().getRadIkkatsuKoshin().getSelectedKey();

                    boolean checkResult = !ＩＦ種類_初期データ.equals(ＩＦ種類_変更データ)
                    || !認定ＩＦ改定日_初期データ.equals(認定ＩＦ改定日_変更データ)
                    || !類似変換_初期データ.equals(類似変換_変更データ)
                    || !一括認定日区分_初期データ.equals(一括認定日区分_変更データ);
                    if (!div.getSystemKanri().getSystemKanriNinteiShien().getDdlShujiiChosainJohoTorikomi().isDisplayNone()) {
                        checkResult = checkResult || !医調取込み_初期データ.equals(医調取込み_変更データ);
                    }
                    checkResult = checkResult || 旧様式のデータ変更チェック(div, 日期) || 新様式のデータ変更チェック(div, 日期);
                    return checkResult;
                }

                private boolean 旧様式のデータ変更チェック(SystemKanriNinteiShienTotalDiv div, RDate 日期) {
                    RString 認定結果ファイル_初期データ = DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_認定結果ＩＦ, 日期, SubGyomuCode.DBD介護受給);
                    RString 指定事業出力ファイル_初期データ = DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_指定事業出力Ｆ, 日期, SubGyomuCode.DBD介護受給);
                    RString 調査員出力ファイル_初期データ = DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_調査員出力Ｆ, 日期, SubGyomuCode.DBD介護受給);
                    RString 医療機関出力ファイル_初期データ = DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_医療機関出力Ｆ, 日期, SubGyomuCode.DBD介護受給);
                    RString 主治医出力ファイル_初期データ = DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_主治医出力Ｆ, 日期, SubGyomuCode.DBD介護受給);
                    RString 申請情報出力ファイル_初期データ = DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_申請情報出力Ｆ, 日期, SubGyomuCode.DBD介護受給);

                    RString 認定結果ファイル_変更データ = div.getSystemKanri().getSystemKanriNinteiShien().getTxtNinteiKekkaFileOld().getValue();
                    RString 指定事業出力ファイル_変更データ = div.getSystemKanri().getSystemKanriNinteiShien().getTxtShiteiJigyoOutFileOld().getValue();
                    RString 調査員出力ファイル_変更データ = div.getSystemKanri().getSystemKanriNinteiShien().getTxtChosainOutFileOld().getValue();
                    RString 医療機関出力ファイル_変更データ = div.getSystemKanri().getSystemKanriNinteiShien().getTxtIryoKikanOutFileOld().getValue();
                    RString 主治医出力ファイル_変更データ = div.getSystemKanri().getSystemKanriNinteiShien().getTxtShujiiOutFileOld().getValue();
                    RString 申請情報出力ファイル_変更データ = div.getSystemKanri().getSystemKanriNinteiShien().getTxtShinseiJohoOutFileOld().getValue();
                    return !認定結果ファイル_初期データ.equals(認定結果ファイル_変更データ)
                    || !指定事業出力ファイル_初期データ.equals(指定事業出力ファイル_変更データ)
                    || !調査員出力ファイル_初期データ.equals(調査員出力ファイル_変更データ)
                    || !医療機関出力ファイル_初期データ.equals(医療機関出力ファイル_変更データ)
                    || !主治医出力ファイル_初期データ.equals(主治医出力ファイル_変更データ)
                    || !申請情報出力ファイル_初期データ.equals(申請情報出力ファイル_変更データ);
                }

                private boolean 新様式のデータ変更チェック(SystemKanriNinteiShienTotalDiv div, RDate 日期) {
                    RString 認定結果ファイル_新_初期データ = DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_認定結果ＩＦ_新, 日期, SubGyomuCode.DBD介護受給);
                    RString 指定事業出力ファイル_新_初期データ = DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_指定事業出力Ｆ_新, 日期, SubGyomuCode.DBD介護受給);
                    RString 調査員出力ファイル_新_初期データ = DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_調査員出力Ｆ_新, 日期, SubGyomuCode.DBD介護受給);
                    RString 医療機関出力ファイル_新_初期データ = DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_医療機関出力Ｆ_新, 日期, SubGyomuCode.DBD介護受給);
                    RString 主治医出力ファイル_新_初期データ = DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_主治医出力Ｆ_新, 日期, SubGyomuCode.DBD介護受給);
                    RString 申請情報出力ファイル_新_初期データ = DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_申請情報出力Ｆ_新, 日期, SubGyomuCode.DBD介護受給);
                    RString 転入_資格喪失情報_初期データ = DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_転入_資格喪失情報出力Ｆ, 日期, SubGyomuCode.DBD介護受給);

                    RString 認定結果ファイル_新_変更データ = div.getSystemKanri().getSystemKanriNinteiShien().getTxtNinteiKekkaFileNew().getValue();
                    RString 指定事業出力ファイル_新_変更データ = div.getSystemKanri().getSystemKanriNinteiShien().getTxtShiteiJigyoOutFileNew().getValue();
                    RString 調査員出力ファイル_新_変更データ = div.getSystemKanri().getSystemKanriNinteiShien().getTxtChosainOutFileNew().getValue();
                    RString 医療機関出力ファイル_新_変更データ = div.getSystemKanri().getSystemKanriNinteiShien().getTxtIryoKikanOutFileNew().getValue();
                    RString 主治医出力ファイル_新_変更データ = div.getSystemKanri().getSystemKanriNinteiShien().getTxtShujiiOutFileNew().getValue();
                    RString 申請情報出力ファイル_新_変更データ = div.getSystemKanri().getSystemKanriNinteiShien().getTxtShinseiJohoOutFileNew().getValue();
                    RString 死亡情報ファイル_変更データ = div.getSystemKanri().getSystemKanriNinteiShien().getTxtShiboJohoFile().getValue();
                    RString 転入死亡ファイル_変更データ = div.getSystemKanri().getSystemKanriNinteiShien().getTxtTennyuShiboFile().getValue();

                    boolean checkResult = !認定結果ファイル_新_初期データ.equals(認定結果ファイル_新_変更データ)
                    || !指定事業出力ファイル_新_初期データ.equals(指定事業出力ファイル_新_変更データ)
                    || !調査員出力ファイル_新_初期データ.equals(調査員出力ファイル_新_変更データ)
                    || !医療機関出力ファイル_新_初期データ.equals(医療機関出力ファイル_新_変更データ)
                    || !主治医出力ファイル_新_初期データ.equals(主治医出力ファイル_新_変更データ)
                    || !申請情報出力ファイル_新_初期データ.equals(申請情報出力ファイル_新_変更データ);

                    if (!div.getSystemKanri().getSystemKanriNinteiShien().getTxtShiboJohoFile().isDisplayNone()) {
                        checkResult = checkResult || !転入_資格喪失情報_初期データ.equals(死亡情報ファイル_変更データ);
                    }
                    if (!div.getSystemKanri().getSystemKanriNinteiShien().getTxtTennyuShiboFile().isDisplayNone()) {
                        checkResult = checkResult || !転入_資格喪失情報_初期データ.equals(転入死亡ファイル_変更データ);
                    }
                    return checkResult;
                }
            };

}
