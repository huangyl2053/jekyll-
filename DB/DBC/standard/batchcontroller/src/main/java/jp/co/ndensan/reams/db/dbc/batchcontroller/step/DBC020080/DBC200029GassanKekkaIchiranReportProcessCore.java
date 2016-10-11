/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * キーブレイク判定及び処理ロジッククラスです。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DBC200029GassanKekkaIchiranReportProcessCore {

    private static final int NUMBER_ZERO = 0;
    private static final int NUMBER_ONE = 1;
    private static final int NUMBER_TWO = 2;
    private static final int NUMBER_THREE = 3;
    private static final int NUMBER_FOUR = 4;
    private static final int NUMBER_FIVE = 5;
    private final IOutputOrder 出力順;
    private RString 出力順1;
    private RString 出力順2;
    private RString 出力順3;
    private RString 出力順4;
    private RString 出力順5;
    private RString 改頁1;
    private RString 改頁2;
    private RString 改頁3;
    private RString 改頁4;
    private RString 改頁5;
    private boolean 改頁;
    private List<RString> breakPage;
    private List<RString> breakItemIds;

    /**
     * コンストラクタです。
     *
     * @param 出力順 IOutputOrder
     */
    public DBC200029GassanKekkaIchiranReportProcessCore(IOutputOrder 出力順) {
        this.出力順 = 出力順;
        initialize();
    }

    /**
     * 改ページの判断です。
     *
     * @return 改頁 boolean
     */
    public boolean is改頁() {
        return 改頁;
    }

    /**
     * 改ページ判断です。
     *
     * @return List<RString> 改頁項
     */
    public List<RString> 改頁項() {
        return breakItemIds;
    }

    private void initialize() {
        改頁 = false;
        breakItemIds = new ArrayList<>();
        出力順1 = RString.EMPTY;
        出力順2 = RString.EMPTY;
        出力順3 = RString.EMPTY;
        出力順4 = RString.EMPTY;
        出力順5 = RString.EMPTY;
        改頁1 = RString.EMPTY;
        改頁2 = RString.EMPTY;
        改頁3 = RString.EMPTY;
        改頁4 = RString.EMPTY;
        改頁5 = RString.EMPTY;
        set出力順改頁();
    }

    private void set出力順改頁() {
        if (出力順 == null || 出力順.get設定項目リスト() == null || 出力順.get設定項目リスト().isEmpty()) {
            return;
        }
        List<RString> sort = new ArrayList<>();
        RString displayName;
        breakPage = new ArrayList<>();
        for (ISetSortItem item : 出力順.get設定項目リスト()) {
            displayName = item.get項目名();
            if (displayName != null) {
                if (item.is改頁項目()) {
                    breakPage.add(displayName);
                    breakItemIds.add(item.get項目ID());
                    改頁 = true;
                }
                sort.add(displayName);
            }
        }
        addItem(sort);
        addItem(breakPage);
        出力順1 = sort.get(NUMBER_ZERO);
        出力順2 = sort.get(NUMBER_ONE);
        出力順3 = sort.get(NUMBER_TWO);
        出力順4 = sort.get(NUMBER_THREE);
        出力順5 = sort.get(NUMBER_FOUR);
        改頁1 = breakPage.get(NUMBER_ZERO);
        改頁2 = breakPage.get(NUMBER_ONE);
        改頁3 = breakPage.get(NUMBER_TWO);
        改頁4 = breakPage.get(NUMBER_THREE);
        改頁5 = breakPage.get(NUMBER_FOUR);
    }

    private void addItem(List<RString> list) {
        int num = list.size();
        if (num < NUMBER_FIVE) {
            num = NUMBER_FIVE - num;
            for (int i = 0; i < num; i++) {
                list.add(RString.EMPTY);
            }
        }
    }

}
