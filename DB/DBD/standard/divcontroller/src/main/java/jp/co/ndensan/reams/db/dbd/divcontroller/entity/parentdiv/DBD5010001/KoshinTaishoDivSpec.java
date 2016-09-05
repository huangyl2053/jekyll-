/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5010001;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 画面設計_DBD5010001_完了処理・更新管理バリデーションクラスです。
 *
 * @author_L DBD-2030-010 x_youyj
 */
public enum KoshinTaishoDivSpec implements IPredicate<KoshinTaishoDiv> {

    更新管理完了対象者一覧データの存在チェック {
                /**
                 * 対象者一覧が0件チェックです。
                 *
                 * @param div 更新管理完了対象者一覧Div
                 * @return true:更新管理完了対象者一覧非0です、false:更新管理完了対象者一覧が0です。
                 */
                @Override
                public boolean apply(KoshinTaishoDiv div) {
                    return !div.getCcdKoshinTaisho().getDataSource().isEmpty();
                }
            },
    更新管理完了対象者一覧データの行選択チェック {
                /**
                 * 対象者一覧が未選択チェックです。
                 *
                 * @param div 更新管理完了対象者一覧Div
                 * @return true:対象者一覧が選択です、false:対象者一覧が未選択です。
                 */
                @Override
                public boolean apply(KoshinTaishoDiv div) {
                    return !div.getCcdKoshinTaisho().getCheckbox().isEmpty();
                }
            },
    更新管理完了対象者一覧選択行の完了処理事前チェック {
                /**
                 * 対完了処理事前チェックです。
                 *
                 * @param div 更新管理完了対象者一覧Div
                 * @return
                 * true:選択されたレコードの「通知年月日」が空白です、false:選択されたレコードの「通知年月日」が非空です。
                 */
                @Override
                public boolean apply(KoshinTaishoDiv div) {
                    for (dgNinteiTaskList_Row row : div.getCcdKoshinTaisho().getCheckbox()) {
                        if (row.getChosahyoDataNyuryokuDay().getValue() == null ||
                                "".equals(row.getChosahyoDataNyuryokuDay().getValue().toString())) {
                            return true;
                        }
                    }
                    return false;
                }
            }

}
