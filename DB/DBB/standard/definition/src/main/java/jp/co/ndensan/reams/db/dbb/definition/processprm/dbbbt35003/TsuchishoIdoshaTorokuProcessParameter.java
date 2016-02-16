/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt35003;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *　
 * 通知書発行後異動者の登録_バッチ処理クラスパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
public class TsuchishoIdoshaTorokuProcessParameter implements IBatchProcessParameter {
    
    private RString 出力対象区分;
    private RDateTime 帳票作成日時;
    private Object 出力帳票一覧List;

}
