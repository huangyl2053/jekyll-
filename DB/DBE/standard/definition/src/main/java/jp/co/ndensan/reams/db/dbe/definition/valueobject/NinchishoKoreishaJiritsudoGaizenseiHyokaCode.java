/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認知症高齢者の自立度蓋然性評価を表すコードです。
 *
 * @author n8178 城間篤人
 */
public class NinchishoKoreishaJiritsudoGaizenseiHyokaCode extends Code {

    /**
     * 引数から、認知症高齢者の自立度蓋然性評価を表すコードを受け取り、インスタンスを生成します。
     *
     * @param code 認知症高齢者の自立度蓋然性評価コード
     * @throws NullPointerException 引数にnullが渡された場合
     * @throws IllegalArgumentException 引数が20桁以下の文字列でない場合
     */
    public NinchishoKoreishaJiritsudoGaizenseiHyokaCode(RString code) throws NullPointerException, IllegalArgumentException {
        super(code);
    }
}
