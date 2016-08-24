/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchoheijunka6tsuchishoikatsuhako;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheijunka6tsuchishoikatsuhako.OutputChohyoIchiran;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 画面の入力情報。
 *
 * @reamsid_L DBB-0820-010 xuyue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HeijunkaKeisanPageJoho {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private RString 増額平準化方法;
    private RString 減額平準化方法;
    private RString 帳票グループ;
    private RString 出力対象指示フラグ;
    private FlexibleDate 発行日;
    private RString 文書番号;
    private boolean 一括発行フラグ;
    private ArrayList<OutputChohyoIchiran> 出力帳票一覧List;

}
