/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 賦課情報の取得_バッチ処理クラスパラメータクラスです。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaJohoShutokuProcessParameter implements IBatchProcessParameter {

    private boolean 一括発行フラグ;
    private FlexibleYear 調定年度;
}
