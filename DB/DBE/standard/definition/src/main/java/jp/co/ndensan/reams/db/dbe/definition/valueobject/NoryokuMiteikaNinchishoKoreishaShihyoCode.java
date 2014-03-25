/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 能力が低下していない認知症高齢者の指標を表すコードです。
 *
 * @author n8178 城間篤人
 */
public class NoryokuMiteikaNinchishoKoreishaShihyoCode extends Code {

    /**
     * 引数から、能力が低下していない認知症高齢者の指標を表すコードを受け取り、インスタンスを生成します。
     *
     * @param code 能力未低下認知症高齢者指標コード
     * @throws NullPointerException 引数にnullが渡された場合
     * @throws IllegalArgumentException 引数が20桁以下の文字列でない場合
     */
    public NoryokuMiteikaNinchishoKoreishaShihyoCode(RString code) throws NullPointerException, IllegalArgumentException {
        super(code);
    }
}
