/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票の発行パラメータを定義したEntityクラスです。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TsuchishoHakoProcessParameter implements IBatchProcessParameter {

    private RString 帳票分類ID;
    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private int 出力対象区分;
    private FlexibleDate 発行日;
    private RDateTime 帳票作成日時;
    private RString 基準日時;
    private RString 出力順ID;
    private RString 帳票ID;
    private boolean 一括発行フラグ;

}
