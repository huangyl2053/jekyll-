/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010005;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010005.SystemKanriKoikiDataTotalDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * システム管理登録（広域データ交換）画面のチェックロジックです。
 *
 * @reamsid_L DBD-3764-010 tz_chengpeng
 */
public enum SystemKanriKoikiDataTotalSpec implements IPredicate<SystemKanriKoikiDataTotalDiv> {

    /**
     * 一次判定ファイル名が未入力チェック。
     */
    一次判定ファイル名が未入力チェック {
                @Override
                public boolean apply(SystemKanriKoikiDataTotalDiv div) {
                    return !div.getSystemKanri().getSystemKanriKoikiData().
                    getTxtIchijiHanteiFileName().getValue().isNullOrEmpty();
                }
            },
    /**
     * 訪問調査ファイル名が未入力チェック。
     */
    訪問調査ファイル名が未入力チェック {
                @Override
                public boolean apply(SystemKanriKoikiDataTotalDiv div) {
                    return !div.getSystemKanri().getSystemKanriKoikiData().
                    getTxtHomonChosaFileName().getValue().isNullOrEmpty();
                }
            },
    /**
     * 特記事項ファイル名が未入力チェック。
     */
    特記事項ファイル名が未入力チェック {
                @Override
                public boolean apply(SystemKanriKoikiDataTotalDiv div) {
                    return !div.getSystemKanri().getSystemKanriKoikiData().
                    getTxtTokkiJikoFileName().getValue().isNullOrEmpty();
                }
            },
    /**
     * 意見書ファイル名が未入力チェック。
     */
    意見書ファイル名が未入力チェック {
                @Override
                public boolean apply(SystemKanriKoikiDataTotalDiv div) {
                    return !div.getSystemKanri().getSystemKanriKoikiData().
                    getTxtIkenshoFile().getValue().isNullOrEmpty();
                }
            },
    /**
     * 日医意見書ファイル名が未入力チェック。
     */
    日医意見書ファイル名が未入力チェック {
                @Override
                public boolean apply(SystemKanriKoikiDataTotalDiv div) {
                    return !div.getSystemKanri().getSystemKanriKoikiData().
                    getTxtNichiiIkenshoFile().getValue().isNullOrEmpty();
                }
            },
    /**
     * 死亡情報ファイル名が未入力チェック。
     */
    死亡情報ファイル名が未入力チェック {
                @Override
                public boolean apply(SystemKanriKoikiDataTotalDiv div) {
                    return !div.getSystemKanri().getSystemKanriKoikiData().
                    getTxtShiboJohoFile().getValue().isNullOrEmpty();
                }
            },
    /**
     * 対象更新のデータ変更チェック
     */
    対象更新のデータ変更チェック {
                @Override
                public boolean apply(SystemKanriKoikiDataTotalDiv div) {
                    RDate 日期 = new RDate(FlexibleDate.getNowDate().toString());

                    RString 認定有効終了日抽出_初期値 = DbBusinessConfig.get(ConfigNameDBD.広域認定支援システム_認定有効終了日抽出, 日期, SubGyomuCode.DBD介護受給);
                    RString 申請者並び順_初期値 = DbBusinessConfig.get(ConfigNameDBD.広域認定支援システム_申請者並び順, 日期, SubGyomuCode.DBD介護受給);
                    RString 調査実施日初期値_初期値 = DbBusinessConfig.get(ConfigNameDBD.広域認定支援システム_調査実施日初期値, 日期, SubGyomuCode.DBD介護受給);
                    RString 意見書申請照会有無_初期値 = DbBusinessConfig.get(ConfigNameDBD.広域認定支援システム_意見書申請照会有無, 日期, SubGyomuCode.DBD介護受給);

                    RString 認定有効終了日抽出_画面設定値 = div.getSystemKanri().getSystemKanriKoikiData().getRadNinteiYukoShuryobi().getSelectedKey();
                    RString 申請者並び順_画面設定値 = div.getSystemKanri().getSystemKanriKoikiData().getDdlChosainSchedule().getSelectedKey();
                    RString 調査実施日初期値_画面設定値 = div.getSystemKanri().getSystemKanriKoikiData().getDdlHomonChosa().getSelectedKey();
                    RString 意見書申請照会有無_画面設定値 = div.getSystemKanri().getSystemKanriKoikiData().getRadIkenshoShinsei().getSelectedKey();

                    boolean checkResult = !認定有効終了日抽出_初期値.equals(認定有効終了日抽出_画面設定値)
                    || !申請者並び順_初期値.equals(申請者並び順_画面設定値)
                    || !調査実施日初期値_初期値.equals(調査実施日初期値_画面設定値)
                    || !意見書申請照会有無_初期値.equals(意見書申請照会有無_画面設定値);
                    checkResult = checkResult || ファイル名変更チェック(div, 日期);
                    return checkResult;
                }

                private boolean ファイル名変更チェック(SystemKanriKoikiDataTotalDiv div, RDate 日期) {
                    RString 一次判定ファイル名_初期値 = DbBusinessConfig.get(ConfigNameDBD.広域認定支援システム_一次判定Ｆ名, 日期, SubGyomuCode.DBD介護受給);
                    RString 訪問調査ファイル名_初期値 = DbBusinessConfig.get(ConfigNameDBD.広域認定支援システム_訪問調査Ｆ名, 日期, SubGyomuCode.DBD介護受給);
                    RString 特記事項ファイル名_初期値 = DbBusinessConfig.get(ConfigNameDBD.広域認定支援システム_特記事項Ｆ名, 日期, SubGyomuCode.DBD介護受給);
                    RString 意見書ファイル名_初期値 = DbBusinessConfig.get(ConfigNameDBD.広域認定支援システム_意見書Ｆ名, 日期, SubGyomuCode.DBD介護受給);
                    RString 日医意見書ファイル名_初期値 = DbBusinessConfig.get(ConfigNameDBD.広域認定支援システム_日医意見書Ｆ名, 日期, SubGyomuCode.DBD介護受給);
                    RString 死亡情報ファイル名_初期値 = DbBusinessConfig.get(ConfigNameDBD.広域認定支援システム_資格喪失Ｆ名, 日期, SubGyomuCode.DBD介護受給);

                    RString 一次判定ファイル名_画面設定値 = div.getSystemKanri().getSystemKanriKoikiData().getTxtIchijiHanteiFileName().getValue();
                    RString 訪問調査ファイル名_画面設定値 = div.getSystemKanri().getSystemKanriKoikiData().getTxtHomonChosaFileName().getValue();
                    RString 特記事項ファイル名_画面設定値 = div.getSystemKanri().getSystemKanriKoikiData().getTxtTokkiJikoFileName().getValue();
                    RString 意見書ファイル名_画面設定値 = div.getSystemKanri().getSystemKanriKoikiData().getTxtIkenshoFile().getValue();
                    RString 日医意見書ファイル名_画面設定値 = div.getSystemKanri().getSystemKanriKoikiData().getTxtNichiiIkenshoFile().getValue();
                    RString 死亡情報ファイル名_画面設定値 = div.getSystemKanri().getSystemKanriKoikiData().getTxtShiboJohoFile().getValue();
                    return !一次判定ファイル名_初期値.equals(一次判定ファイル名_画面設定値)
                    || !訪問調査ファイル名_初期値.equals(訪問調査ファイル名_画面設定値)
                    || !特記事項ファイル名_初期値.equals(特記事項ファイル名_画面設定値)
                    || !意見書ファイル名_初期値.equals(意見書ファイル名_画面設定値)
                    || !日医意見書ファイル名_初期値.equals(日医意見書ファイル名_画面設定値)
                    || !死亡情報ファイル名_初期値.equals(死亡情報ファイル名_画面設定値);
                }
            };

}
