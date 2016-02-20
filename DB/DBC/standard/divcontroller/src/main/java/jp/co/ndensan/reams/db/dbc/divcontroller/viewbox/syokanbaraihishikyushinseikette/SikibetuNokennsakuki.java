/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.syokanbaraihishikyushinseikette;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 識別番号検索キーのParameter
 *
 * @author wangkanglei
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class SikibetuNokennsakuki implements Serializable {

    private static final long serialVersionUID = 1L;
    private final RString sikibetuNo;
    private final FlexibleYearMonth serviceTeikyoYM;

    public SikibetuNokennsakuki(RString sikibetuNo, FlexibleYearMonth serviceTeikyoYM) {
        this.sikibetuNo = sikibetuNo;
        this.serviceTeikyoYM = serviceTeikyoYM;
    }
}
