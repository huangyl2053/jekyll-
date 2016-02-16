/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt35003;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RYear;

/**
 *　
 * 賦課情報の取得_バッチ処理クラスパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
public class FukaJohoShutokuProcessParameter implements IBatchProcessParameter {
    
    private RYear 調定年度;
    private boolean 一括発行フラグ;

}
