/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
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
public class TsuchishoIdoshaTorokuProcessParameter implements IBatchProcessParameter {

    private int 出力対象区分;
    private RDateTime 帳票作成日時;
    private RString 帳票ID;
    private RString 出力順ID;

}
