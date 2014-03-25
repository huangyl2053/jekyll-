/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定状態の安定性コードを表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class KaigoNinteiJotaiAnteiseiCode extends Code {

    /**
     * 引数から要介護認定状態の安定性を表すコードを受け取り、インスタンスを生成します。
     *
     * @param code 要介護認定状態の安定性を表すコード
     * @throws NullPointerException 引数にnullが渡された場合
     * @throws IllegalArgumentException 引数が20桁以下の文字列でない場合
     */
    public KaigoNinteiJotaiAnteiseiCode(RString code) throws NullPointerException, IllegalArgumentException {
        super(code);
    }
}
