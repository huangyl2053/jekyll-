/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5150011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5150011.DBC5150011MainDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 画面設計_DBCMNJ2006_サービスコード一覧表のの入力チェックSpecです。
 *
 * @reamsid_L DBC-3310-010 chenyadong
 */
public enum DBC5150011MainMainSpec implements IPredicate<DBC5150011MainDiv> {

    /**
     * サービス種類コード_桁数チェックです。
     */
    サービス種類コード_桁数チェック {
                @Override
                public boolean apply(DBC5150011MainDiv div) {
                    return SpecHelper.isサービス種類コード_桁数チェック(div);
                }
            },
    /**
     * サービス分類_指定なしチェックです。
     */
    サービス分類_指定なしチェック {
                @Override
                public boolean apply(DBC5150011MainDiv div) {
                    return SpecHelper.isサービス分類_指定なしチェック(div);
                }
            },
    /**
     * 出力方法_指定なしチェックです。
     */
    出力方法_指定なしチェック {
                @Override
                public boolean apply(DBC5150011MainDiv div) {
                    return SpecHelper.is出力方法_指定なしチェック(div);
                }
            };
    private static final int 整数_TWO = 2;

    private static class SpecHelper {

        public static boolean isサービス種類コード_桁数チェック(DBC5150011MainDiv div) {
            if (div.getRadChushutsuJokenServiceCode().getSelectedKey() != null
                    && !div.getRadChushutsuJokenServiceCode().getSelectedKey().isEmpty()) {
                return div.getCcdServiceShurui().getサービス種類コード().length() == 整数_TWO;
            }
            return true;
        }

        public static boolean isサービス分類_指定なしチェック(DBC5150011MainDiv div) {
            if (div.getRadChushutsuJokenServiceBunrui().getSelectedKey() != null
                    && !div.getRadChushutsuJokenServiceBunrui().getSelectedKey().isEmpty()) {
                return !div.getDgServiceBunruiList().getSelectedItems().isEmpty();
            }
            return true;
        }

        public static boolean is出力方法_指定なしチェック(DBC5150011MainDiv div) {
            return !div.getChkShutsuryokuTaisho().getSelectedItems().isEmpty();
        }
    }
}
