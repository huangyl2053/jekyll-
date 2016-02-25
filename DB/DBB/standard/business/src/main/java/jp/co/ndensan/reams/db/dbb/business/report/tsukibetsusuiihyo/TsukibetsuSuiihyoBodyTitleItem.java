/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 月別推移表ボディのTitleITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TsukibetsuSuiihyoBodyTitleItem {

    private final RString listTitle_1;

    /**
     * インスタンスを生成します。
     *
     * @param listTitle_1
     */
    public TsukibetsuSuiihyoBodyTitleItem(RString listTitle_1) {
        this.listTitle_1 = listTitle_1;
    }

}
