/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2060001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2060001.NinteichosaKekkaNyushuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2060001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 完了処理・認定調査結果入手のクラスファイルです。
 *
 * @author n3304 岡澤 政幸
 */
public enum NinteichosaKekkaNyushuSpec implements IPredicate<NinteichosaKekkaNyushuDiv> {

    /**
     * 認定調査票入手一覧データの存在チェックです。
     */
    認定調査票入手一覧データの存在チェック {

                @Override
                public boolean apply(NinteichosaKekkaNyushuDiv div) {
                    return !SpecHelper.is認定調査票入手一覧が0件(div);
                }
            },
    /**
     * 認定調査票入手一覧データの行選択チェック1です。
     */
    認定調査票入手一覧データの行選択チェック1 {

                @Override
                public boolean apply(NinteichosaKekkaNyushuDiv div) {
                    return !SpecHelper.is認定調査票入手一覧未選択(div);
                }
            },
    /**
     * 認定調査票入手一覧データの行選択チェック2です。
     */
    認定調査票入手一覧データの行選択チェック2 {

                @Override
                public boolean apply(NinteichosaKekkaNyushuDiv div) {
                    return !SpecHelper.is認定調査票入手一覧複数行選択(div);
                }
            },
    /**
     * 認定調査票入手一覧選択行の完了処理事前チェックです。
     */
    認定調査票入手一覧選択行の登録処理事前チェック {

                @Override
                public boolean apply(NinteichosaKekkaNyushuDiv div) {
                    return !SpecHelper.is認定調査票入手一覧調査実施日が入力済の行を選択(div);
                }
            },
    /**
     * 認定調査票入手一覧選択行の完了処理事前チェックです。
     */
    認定調査票入手一覧選択行の完了処理事前チェック {

                @Override
                public boolean apply(NinteichosaKekkaNyushuDiv div) {
                    return !SpecHelper.is認定調査票入手一覧調査実施日が空白行を選択(div);
                }
            };

    /**
     * {@link NinteichosaKekkaNyushuSpec}における判定ロジックのHelperクラスです。
     */
    private static class SpecHelper {

        /**
         * 認定調査票入手一覧データが0件のとき、trueを返します。
         *
         * @param div NinteichosaKekkaNyushuDiv
         * @return booelan
         */
        public static boolean is認定調査票入手一覧が0件(NinteichosaKekkaNyushuDiv div) {
            return div.getNinteichosakekkainput().getDgNinteiTaskList().getDataSource() == null
                    || div.getNinteichosakekkainput().getDgNinteiTaskList().getDataSource().isEmpty();
        }

        /**
         * 認定調査票入手一覧データを未選択のとき、trueを返します。
         *
         * @param div NinteichosaKekkaNyushuDiv
         * @return booelan
         */
        public static boolean is認定調査票入手一覧未選択(NinteichosaKekkaNyushuDiv div) {
            if (is認定調査票入手一覧が0件(div)) {
                return false;
            }
            return div.getNinteichosakekkainput().getDgNinteiTaskList().getSelectedItems() == null
                    || div.getNinteichosakekkainput().getDgNinteiTaskList().getSelectedItems().isEmpty();
        }

        /**
         * 認定調査票入手一覧データを複数行選択しているとき、trueを返します。
         *
         * @param div NinteichosaKekkaNyushuDiv
         * @return booelan
         */
        public static boolean is認定調査票入手一覧複数行選択(NinteichosaKekkaNyushuDiv div) {
            if (is認定調査票入手一覧未選択(div)) {
                return false;
            }
            return 1 < div.getNinteichosakekkainput().getDgNinteiTaskList().getSelectedItems().size();
        }

        /**
         * 認定調査票入手一覧データで調査実施日が入力済の行を選択しているとき、trueを返します。
         *
         * @param div NinteichosaKekkaNyushuDiv
         * @return booelan
         */
        public static boolean is認定調査票入手一覧調査実施日が入力済の行を選択(NinteichosaKekkaNyushuDiv div) {
            if (is認定調査票入手一覧未選択(div)) {
                return false;
            }
            for (dgNinteiTaskList_Row item : div.getNinteichosakekkainput().getDgNinteiTaskList().getSelectedItems()) {
                if (item.getChosaJisshiYMD().getValue() != null) {
                    return true;
                }
            }
            return false;
        }

        /**
         * 認定調査票入手一覧データで調査実施日が空白の行を選択しているとき、trueを返します。
         *
         * @param div NinteichosaKekkaNyushuDiv
         * @return booelan
         */
        public static boolean is認定調査票入手一覧調査実施日が空白行を選択(NinteichosaKekkaNyushuDiv div) {
            if (is認定調査票入手一覧未選択(div)) {
                return false;
            }
            for (dgNinteiTaskList_Row item : div.getNinteichosakekkainput().getDgNinteiTaskList().getSelectedItems()) {
                if (item.getChosaJisshiYMD().getValue() == null) {
                    return true;
                }
            }
            return false;
        }
    }

}
