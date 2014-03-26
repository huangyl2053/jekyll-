/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一次判定警告コードを表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class IchijiHanteiKeikokuCode extends Code {

    /**
     * 一次判定警告コードを表す文字列を受け取り、インスタンスを生成します。
     *
     * @param code 一次判定警告コード
     * @throws NullPointerException 引数にnullが渡された場合
     * @throws IllegalArgumentException 文字列が20桁より大きい場合
     */
    public IchijiHanteiKeikokuCode(RString code) throws NullPointerException, IllegalArgumentException {
        super(code);
    }
}
