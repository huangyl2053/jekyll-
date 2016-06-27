/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kougakushinseiichiranjohyou;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * ビジネス設計_DBCKD00005_高額申請一覧共有子Div（画面）
 *
 * @reamsid_L DBC-2020-050 quxiaodong
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KougakuShinseiIchiranJohyouParameter {

    private final HihokenshaNo hiHokenshaNo;
    private final FlexibleYearMonth serviceTeikyoYMFrom;
    private final FlexibleYearMonth serviceTeikyoYMTo;

    /**
     * コンストラクタです
     *
     * @param hiHokenshaNo HihokenshaNo
     * @param serviceTeikyoYMFrom FlexibleYearMonth
     * @param serviceTeikyoYMTo FlexibleYearMonth
     */
    public KougakuShinseiIchiranJohyouParameter(HihokenshaNo hiHokenshaNo,
            FlexibleYearMonth serviceTeikyoYMFrom,
            FlexibleYearMonth serviceTeikyoYMTo) {
        this.hiHokenshaNo = hiHokenshaNo;
        this.serviceTeikyoYMFrom = serviceTeikyoYMFrom;
        this.serviceTeikyoYMTo = serviceTeikyoYMTo;
    }
}
