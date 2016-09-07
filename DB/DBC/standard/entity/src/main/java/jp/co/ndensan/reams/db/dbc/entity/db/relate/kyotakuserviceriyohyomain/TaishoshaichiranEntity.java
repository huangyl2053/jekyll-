/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyotakuserviceriyohyomain;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象情報一覧entityです。
 *
 * @reamsid_L DBC-1930-030 huzongcheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaishoshaichiranEntity {

    private FlexibleYearMonth riyoYM;
    private RString koshinKubun;
    private FlexibleDate koshinYMD;
    private FlexibleYearMonth sofuYM;

}
