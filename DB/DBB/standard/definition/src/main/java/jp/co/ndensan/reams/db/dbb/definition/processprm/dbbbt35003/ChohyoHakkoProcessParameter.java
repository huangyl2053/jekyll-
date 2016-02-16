/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt35003;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;

/**
 *　
 * 帳票の発行_バッチ処理クラスパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
public class ChohyoHakkoProcessParameter implements IBatchProcessParameter {
    
    private RYear 調定年度;
    private RString 出力対象区分;
    private RDate 発行日;
    private RDateTime 帳票作成日時;
    private Object 出力帳票一覧List;

}
