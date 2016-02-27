/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.valueobject.tokuchoheijunka6gatsutsuchishoikkatsuhakko;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import lombok.Getter;
import lombok.Setter;

/**
 * HeijunkaKeisanDivのTempDataクラスです。
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TsuchishoIkkatsuHakkoTempData implements Serializable {

    private RYear 調定年度;
    private RYear 賦課年度;
    private Object 出力帳票一覧List;
    private RDate 発行日;
    private RString 出力対象;
    private boolean 一括発行フラグ;

}
