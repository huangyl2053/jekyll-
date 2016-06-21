/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import lombok.Getter;
import lombok.Setter;

/**
 * 賦課情報の「更正前」計算後情報の更新処理のパラメータクラスです。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoseimaeJohoUpdateProcessParameter implements IBatchProcessParameter {

    private Object 計算後List;

}
