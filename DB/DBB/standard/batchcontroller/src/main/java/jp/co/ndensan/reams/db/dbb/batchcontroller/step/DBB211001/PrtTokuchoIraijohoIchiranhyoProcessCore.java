/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * キーブレイク判定及び処理ロジッククラスです。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
public class PrtTokuchoIraijohoIchiranhyoProcessCore {

    private static final int NUMBER_FIVE = 5;
    private final IOutputOrder 出力順;
    private boolean 改頁;
    private List<RString> 出力順List;
    private List<RString> breakPage;
    private List<RString> breakItemIds;

    /**
     * コンストラクタです。
     *
     * @param 出力順 出力順
     */
    public PrtTokuchoIraijohoIchiranhyoProcessCore(IOutputOrder 出力順) {
        this.出力順 = 出力順;
        initialize();
    }

    /**
     * 改ページ判断です。
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

    /**
     * 出力順項です。
     *
     * @return List<RString> 出力順項
     */
    public List<RString> 出力順項() {
        return 出力順List;
    }

    private void initialize() {
        改頁 = false;
        breakItemIds = new ArrayList<>();
        出力順List = new ArrayList<>();
        set出力順改頁();
    }

    private void set出力順改頁() {
        if (出力順 == null || 出力順.get設定項目リスト() == null || 出力順.get設定項目リスト().isEmpty()) {
            return;
        }
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
                出力順List.add(displayName);
            }
        }
        addItem(出力順List);
        addItem(breakPage);
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
