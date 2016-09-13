/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3020003;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「時効起算日特殊登録」画面のSpecクラスです。
 *
 * @reamsid_L DBD-3820-010 huangh
 */
public enum JukoKisambiTokushuTorokuSpec implements IPredicate<JukoKisambiTokushuTorokuDiv> {

    一括用特殊時効起算日必須チェック {
        /**
         * 開始日が未入力チェックです。
         *
         * @param div 時効起算日特殊登録Div
         * @return true:非空です、false:空です。
         */
        @Override
        public boolean apply(JukoKisambiTokushuTorokuDiv div) {
            return div.getTxtTokushuJikoKisambi().getValue() != null
                    && !div.getTxtTokushuJikoKisambi().getValue().isEmpty()
                    && div.getTxtTokushuJikoKisambi().isValid();
        }
    },
    一括用特殊時効起算日事由DDL必須チェック {
        /**
         * 終了日が未入力チェックです。
         *
         * @param div 時効起算日特殊登録Div
         * @return true:非空です、false:空です。
         */
        @Override
        public boolean apply(JukoKisambiTokushuTorokuDiv div) {
            return !RString.isNullOrEmpty(div.getDdlFukushaJikoKisambiJiyu().getSelectedValue());
        }
    },
    特殊時効起算日入力チェック {
        /**
         * 終了日が未入力チェックです。
         *
         * @param div 時効起算日特殊登録Div
         * @return true:非空です、false:空です。
         */
        @Override
        public boolean apply(JukoKisambiTokushuTorokuDiv div) {

            List<dgJikoKisambi_Row> 時効起算日登録List = div.getDgJikoKisambi().getDataSource();
            for (dgJikoKisambi_Row row : 時効起算日登録List) {
                return (row.getTokushuJikoKisaibi().getValue() != null
                        && !row.getTokushuJikoKisaibi().getValue().isEmpty()
                        && row.getTokushuJikoKisaibi().isValid()
                        && !RString.isNullOrEmpty(row.getTokushuJikoKisaibiJiyu().getSelectedValue()))
                        || ((row.getTokushuJikoKisaibi().getValue() == null
                        || row.getTokushuJikoKisaibi().getValue().isEmpty()
                        || !row.getTokushuJikoKisaibi().isValid())
                        && RString.isNullOrEmpty(row.getTokushuJikoKisaibiJiyu().getSelectedValue()));

            }
            return true;
        }
    },
}
