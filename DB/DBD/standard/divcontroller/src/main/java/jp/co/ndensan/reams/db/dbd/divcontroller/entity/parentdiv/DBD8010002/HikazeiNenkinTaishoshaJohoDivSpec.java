/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 非課税年金対象者情報取込バリデーションクラスです。
 *
 * @reamsid_L DBD-4910-010 huangh
 */
public enum HikazeiNenkinTaishoshaJohoDivSpec implements IPredicate<HikazeiNenkinTaishoshaJohoDiv> {

    編集なしチェック {
        /**
         * 編集なしチェックです。
         *
         * @param div 非課税年金対象者情報取込Div
         * @return true:変更あるです、false:変更ないです。
         */
        @Override
        public boolean apply(HikazeiNenkinTaishoshaJohoDiv div) {

            List<dgShoriSettei_Row> rowList = div.getDgShoriSettei().getDataSource();
            for (dgShoriSettei_Row row : rowList) {
                if (!row.getHdnSyokiShoriJotai().equals(row.getTxtShoriJotai().getSelectedKey())) {
                    return true;
                }
            }
            return false;
        }
    },
}
