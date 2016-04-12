/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchokarisanteifuka;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ用パラメータのクラスです。
 *
 * @reamsid_L DBB-0790-020 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoKariSanteiParameter {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private List<BatchTokuchoKariSanteiResult> 出力帳票一覧List;
    private FlexibleDate 発行日;
    private RString 出力対象;

}
