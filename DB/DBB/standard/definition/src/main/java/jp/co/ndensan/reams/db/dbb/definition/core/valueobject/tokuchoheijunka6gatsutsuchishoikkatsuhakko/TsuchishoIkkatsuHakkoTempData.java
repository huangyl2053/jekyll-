/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.valueobject.tokuchoheijunka6gatsutsuchishoikkatsuhakko;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * HeijunkaKeisanDivのTempDataクラスです。
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TsuchishoIkkatsuHakkoTempData {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private Object 出力帳票一覧List;
    private FlexibleDate 発行日;
    private RString 出力対象;
    private boolean 一括発行フラグ;

}
