/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5030001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5030001.TsuchiShoriDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5030001.dgtsuchishohakko_Row;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 完了処理・通知書発行画面のチェックロジックです。
 *
 * @reamsid_L DBD-2040-010 chenxin
 */
public enum TsuchiShoriSpec implements IPredicate<TsuchiShoriDiv> {

    /**
     * 通知書発行対象者一覧データの存在チェック
     */
    通知書発行対象者一覧データの存在チェック {
                @Override
                public boolean apply(TsuchiShoriDiv div) {
                    return !div.getDgtsuchishohakko().getDataSource().isEmpty();
                }
            },
    /**
     * 通知書発行対象者一覧データの行選択チェック
     */
    通知書発行対象者一覧データの行選択チェック {
                @Override
                public boolean apply(TsuchiShoriDiv div) {
                    return !div.getDgtsuchishohakko().getSelectedItems().isEmpty();
                }
            },
    /**
     * 通知書発行対象者一覧選択行の完了処理事前チェック
     */
    通知書発行対象者一覧選択行の完了処理事前チェック {
                @Override
                public boolean apply(TsuchiShoriDiv div) {
                    List<dgtsuchishohakko_Row> 画面情報 = div.getDgtsuchishohakko().getSelectedItems();
                    for (dgtsuchishohakko_Row row : 画面情報) {
                        if (row.getNinteitsuchishobi().getValue().isEmpty()
                        && row.getKubunhenkotsuchishobi().getValue().isEmpty()
                        && row.getServicehenkotsuchishobi().getValue().isEmpty()
                        && row.getNinteikyakatsuchishobi().getValue().isEmpty()
                        && row.getNinteitorikeshitsuchishobi().getValue().isEmpty()) {
                            return false;
                        }
                    }
                    return true;
                }
            };
}
