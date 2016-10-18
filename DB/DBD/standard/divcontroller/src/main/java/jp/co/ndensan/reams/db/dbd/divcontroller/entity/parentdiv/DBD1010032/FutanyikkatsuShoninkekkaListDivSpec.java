/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010032;

import java.util.ArrayList;
import java.util.List;
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
                    List<dgNinteiIchiran_Row> dgNinteiIchiransize = null;
                    if (div.getDatagridhojipanel().getDgNinteiIchiran() != null) {
                        dgNinteiIchiransize = div.getDatagridhojipanel().getDgNinteiIchiran().getDataSource();
                    }
                    return dgNinteiIchiransize != null && !dgNinteiIchiransize.isEmpty();
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
                    List<RString> KEYS = new ArrayList<>();
                    if (div.getDatagridhojipanel().getDgNinteiIchiran() != null) {
                        for (int i = 0; i < div.getDatagridhojipanel().getDgNinteiIchiran().getDataSource().size(); i++) {
                            if (div.getDatagridhojipanel().getDgNinteiIchiran().getDataSource().get(i)
                            .getJotai().equals(new RString("修正"))) {
                                KEYS.add(new RString(i));
                            }
                        }
                    }
                    return !KEYS.isEmpty();
                }
            };
}
