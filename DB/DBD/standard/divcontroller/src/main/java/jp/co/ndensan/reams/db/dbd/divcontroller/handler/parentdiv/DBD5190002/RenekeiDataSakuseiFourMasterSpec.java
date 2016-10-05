/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5190002;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190002.RenekeiDataSakuseiFourMasterDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定関連データ作成画面のチェックロジックです。
 *
 * @reamsid_L DBD-2100-010 liwul
 */
public enum RenekeiDataSakuseiFourMasterSpec implements IPredicate<RenekeiDataSakuseiFourMasterDiv> {

    /**
     * 今回処理日時_終了日時が開始日時以前チェック。
     */
    今回処理日時_終了日時が開始日時以前チェック {
                @Override
                public boolean apply(RenekeiDataSakuseiFourMasterDiv div) {
                    if (SpecHelper.抽出条件ラジオボタンが対象期間(div)) {
                        return div.getTxtkonkaishoriymdtime().getFromValue() == null
                        || div.getTxtkonkaishoriymdtime().getToValue() == null
                        || div.getTxtkonkaishoriymdtime().getFromValue().isBefore(div.getTxtkonkaishoriymdtime().getToValue());
                    }
                    return true;
                }
            },
    /**
     * 今回開始チェック（年月日）。
     */
    今回開始チェック_年月日 {
                @Override
                public boolean apply(RenekeiDataSakuseiFourMasterDiv div) {
                    if (SpecHelper.抽出条件ラジオボタンが対象期間(div)) {
                        return div.getTxtkonkaishoriymdtime().getFromDateValue() != null;
                    }
                    return true;
                }
            },
    /**
     * 今回開始チェック（時分秒）。
     */
    今回開始チェック_時分秒 {
                @Override
                public boolean apply(RenekeiDataSakuseiFourMasterDiv div) {
                    if (SpecHelper.抽出条件ラジオボタンが対象期間(div)) {
                        return div.getTxtkonkaishoriymdtime().getFromTimeValue() != null;
                    }
                    return true;
                }
            },
    /**
     * 今回終了チェック_年月日。
     */
    今回終了チェック_年月日 {
                @Override
                public boolean apply(RenekeiDataSakuseiFourMasterDiv div) {
                    if (SpecHelper.抽出条件ラジオボタンが対象期間(div)) {
                        return div.getTxtkonkaishoriymdtime().getToDateValue() != null;
                    }
                    return true;
                }
            },
    /**
     * 今回終了チェック（時分秒）。
     */
    今回終了チェック_時分秒 {
                @Override
                public boolean apply(RenekeiDataSakuseiFourMasterDiv div) {
                    if (SpecHelper.抽出条件ラジオボタンが対象期間(div)) {
                        return div.getTxtkonkaishoriymdtime().getToTimeValue() != null;
                    }
                    return true;
                }
            };

    private static class SpecHelper {

        static final RString 対象期間KEY = new RString("key0");

        static boolean 抽出条件ラジオボタンが対象期間(RenekeiDataSakuseiFourMasterDiv div) {
            return div.getRadChushutsuJoken().getSelectedKey().equals(対象期間KEY);
        }
    }
}
