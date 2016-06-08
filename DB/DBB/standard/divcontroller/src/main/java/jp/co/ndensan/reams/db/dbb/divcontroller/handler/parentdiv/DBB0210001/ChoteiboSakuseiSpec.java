/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0210001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210001.ChoteiboSakuseiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * {@link ChoteiboSakuseiDiv}の仕様クラスです。 <br> {@link ChoteiboSakuseiDiv}における画面としての仕様を定義しています。
 *
 * @reamsid_L DBB-0770-010 cuilin
 */
public enum ChoteiboSakuseiSpec implements IPredicate<ChoteiboSakuseiDiv> {

    /**
     * 処理年度必須チェック
     */
    処理年度入力 {
                @Override
                public boolean apply(ChoteiboSakuseiDiv div) {
                    return SpecHelper.is処理年度入力(div);
                }
            },
    /**
     * 抽出調定日時の開始年月日必須チェック
     */
    抽出調定日時の開始年月日入力 {
                @Override
                public boolean apply(ChoteiboSakuseiDiv div) {
                    return SpecHelper.is抽出調定日時の開始年月日入力(div);
                }
            },
    /**
     * 抽出調定日時の開始時分秒（以上）必須チェック
     */
    抽出調定日時の開始時分秒入力 {
                @Override
                public boolean apply(ChoteiboSakuseiDiv div) {
                    return SpecHelper.is抽出調定日時の開始時分秒入力(div);
                }
            },
    /**
     * 抽出調定日時の終了年月日必須チェック
     */
    抽出調定日時の終了年月日入力 {
                @Override
                public boolean apply(ChoteiboSakuseiDiv div) {
                    return SpecHelper.is抽出調定日時の終了年月日入力(div);
                }
            },
    /**
     * 抽出調定日時の終了時分秒（未満）必須チェック
     */
    抽出調定日時の終了時分秒入力 {
                @Override
                public boolean apply(ChoteiboSakuseiDiv div) {
                    return SpecHelper.is抽出調定日時の終了時分秒入力(div);
                }
            };

    private static class SpecHelper {

        public static boolean is処理年度入力(ChoteiboSakuseiDiv div) {
            return !div.getDdlShoriNendo().getSelectedKey().isEmpty();
        }

        public static boolean is抽出調定日時の開始年月日入力(ChoteiboSakuseiDiv div) {
            return div.getTxtChushutsuStYMD().getValue() != null;
        }

        public static boolean is抽出調定日時の開始時分秒入力(ChoteiboSakuseiDiv div) {
            return div.getTxtChushutsuStTime().getValue() != null;
        }

        public static boolean is抽出調定日時の終了年月日入力(ChoteiboSakuseiDiv div) {
            return div.getTxtChushutsuEdYMD().getValue() != null;
        }

        public static boolean is抽出調定日時の終了時分秒入力(ChoteiboSakuseiDiv div) {
            return div.getTxtChushutsuEdTime().getValue() != null;
        }
    }
}
