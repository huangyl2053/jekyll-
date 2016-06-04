/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheijunka6tsuchishoikatsuhako.OutputChohyoIchiran;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 通知書の発行_バッチ処理クラスパラメータクラスです。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TsuchishoHakoProcessParameter implements IBatchProcessParameter {

    private RString 出力対象区分;
    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private FlexibleDate 発行日;
    private RDateTime 帳票作成日時;
    private List<OutputChohyoIchiran> 出力帳票entity;

}
