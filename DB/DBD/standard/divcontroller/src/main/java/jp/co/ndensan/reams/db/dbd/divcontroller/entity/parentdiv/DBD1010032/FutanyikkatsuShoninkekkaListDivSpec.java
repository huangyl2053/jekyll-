/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010032;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一括承認結果一覧の入力チェック
 *
 * @reamsid_L DBD-3710-030 xuejm
 */
public enum FutanyikkatsuShoninkekkaListDivSpec implements IPredicate<FutanyikkatsuShoninkekkaListDiv> {

    承認確定対象存在チェック {
                /**
                 * 承認確定対象存在チェック .
                 *
                 * @param div FutanyikkatsuShoninkekkaListDiv
                 * @return true:承認結果一覧にデータが非空です、false:承認結果一覧にデータがないの場合。
                 */
                @Override
                public boolean apply(FutanyikkatsuShoninkekkaListDiv div) {
                    return div.getDatagridhojipanel().getDgNinteiIchiran().getDataSource() != null
                    && !div.getDatagridhojipanel().getDgNinteiIchiran().getDataSource().isEmpty();
                }
            },
    修正保存対象存在チェック {

                /**
                 * 修正保存対象存在チェック .
                 *
                 * @param div FutanyikkatsuShoninkekkaListDiv
                 * @return true:承認結果一覧に状態 = 修正があるの場合、false:承認結果一覧に状態 = 修正のデータがないの場合。
                 */
                @Override
                public boolean apply(FutanyikkatsuShoninkekkaListDiv div) {
                    boolean dgninteiichiran_jotai = false;
                    if (div.getDatagridhojipanel().getDgNinteiIchiran().getActiveRow().getJotai() != null) {
                        dgninteiichiran_jotai = div.getDatagridhojipanel().getDgNinteiIchiran().getActiveRow().getJotai().equals(new RString("修正"));
                    }
                    return dgninteiichiran_jotai;
                }
            };
}
