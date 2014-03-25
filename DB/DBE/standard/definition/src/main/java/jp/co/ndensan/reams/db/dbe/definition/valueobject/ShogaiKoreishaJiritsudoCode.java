/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 障害高齢者自立度コードを表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShogaiKoreishaJiritsudoCode extends Code {

    /**
     * 引数から障害高齢者自立度コードを受け取り、インスタンスを生成します。
     *
     * @param code 障害高齢者自立度コード
     * @throws NullPointerException 引数にnullが渡された場合
     * @throws IllegalArgumentException 引数が20桁以下の文字列でない場合
     */
    public ShogaiKoreishaJiritsudoCode(RString code) throws NullPointerException, IllegalArgumentException {
        super(code);
    }
}
