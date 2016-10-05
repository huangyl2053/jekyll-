/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsaketteihokenshain;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.saishori.SaiShoriKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連インタフェース管理更新パラメータです。
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings ("PMD.UnusedPrivateField")
public class SaishinsaKetteiProcessParameter implements IBatchProcessParameter {

    private FlexibleYearMonth 処理年月;
    private FlexibleYearMonth 処理対象年月;
    private ReportId 帳票ID;
    private RString 出力順ID;
    private RDateTime システム日付;
    private SaiShoriKubun 再処理区分;
    private int レコード件数合計;
    private List<RString> fileNameList;
    private RString 交換情報識別番号;

}
