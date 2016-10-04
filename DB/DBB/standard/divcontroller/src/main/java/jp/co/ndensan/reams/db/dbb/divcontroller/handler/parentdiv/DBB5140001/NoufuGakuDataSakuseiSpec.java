/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB5140001;

import java.util.List;
import java.util.regex.Pattern;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB5140001.NoufuGakuDataSakuseiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB5140001.dgKoikiShoriTaishoSelect_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB5140001.dgTanitsuShoriJoken_Row;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 納付額データ作成Divのハンドラクラスです。
 *
 * @reamsid_L DBB-1890-010 chenhui
 */
public enum NoufuGakuDataSakuseiSpec implements IPredicate<NoufuGakuDataSakuseiDiv> {

    /**
     * 単一チェック
     */
    単一チェック {
                @Override
                public boolean apply(NoufuGakuDataSakuseiDiv div) {
                    return SpecHelper.単一チェック(div);
                }
            },
    /**
     * 広域チェック
     */
    広域チェック {
                @Override
                public boolean apply(NoufuGakuDataSakuseiDiv div) {
                    return SpecHelper.広域チェック(div);
                }
            };

    private static class SpecHelper {

        private static final int INT100 = 100;
        private static final int INT_100 = -100;

        /**
         * 入力された値が、-99～+99までに収まっているかをチェックする。
         *
         * @param div NoufuGakuDataSakuseiDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean 単一チェック(NoufuGakuDataSakuseiDiv div) {
            List<dgTanitsuShoriJoken_Row> 抽出条件Rows = div.getChushutsuKikan().getDgTanitsuShoriJoken().getDataSource();
            if (抽出条件Rows == null || 抽出条件Rows.isEmpty()) {
                return true;
            }
            RString 抽出終了補正 = 抽出条件Rows.get(0).getTxtKikanEdHosei().getValue();
            return (check英数(抽出終了補正) && check範囲(抽出終了補正));
        }

        /**
         * 入力された値が、-99～+99までに収まっているかをチェックする。
         *
         * @param div NoufuGakuDataSakuseiDiv
         * @return 「false」エラー 「true」正常
         */
        public static boolean 広域チェック(NoufuGakuDataSakuseiDiv div) {
            List<dgKoikiShoriTaishoSelect_Row> 処理対象Rows = div.getKoikiShori().getDgKoikiShoriTaishoSelect().getSelectedItems();
            if (処理対象Rows == null || 処理対象Rows.isEmpty()) {
                return true;
            }
            boolean result = true;
            for (dgKoikiShoriTaishoSelect_Row row : 処理対象Rows) {
                RString 抽出終了補正 = row.getTxtKikanEdHosei().getValue();
                result = result && (check英数(抽出終了補正) && check範囲(抽出終了補正));
            }
            return result;
        }

        private static boolean check英数(RString 抽出終了補正) {
            Pattern pattern = Pattern.compile("^(\\-|\\+)?\\d+$");
            return pattern.matcher(抽出終了補正.toString()).matches();
        }

        private static boolean check範囲(RString 抽出終了) {
            Integer 抽出終了補正 = Integer.valueOf(抽出終了.toString());
            return (INT_100 < 抽出終了補正 && 抽出終了補正 < INT100);
        }
    }
}
