/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者区分を表す列挙型です。
 *
 * @author N8187 久保田 英男
 */
public enum HihokenshaKubun {

    /**
     * 被保険者区分が「1号被保険者」であることを表します。 <br />
     * コード：1
     */
    被保険者1号("1"),
    /**
     * 被保険者区分が「2号被保険者」であることを表します。 <br />
     * コード：2
     */
    被保険者2号("2");
    private final RString code;

    private HihokenshaKubun(String code) {
        this.code = new RString(code);
    }

    /**
     * RString型の被保険者区分コードを返します。
     *
     * @return 被保険者区分コード
     */
    public RString getCode() {
        return code;
    }

    /**
     * RString型の被保険者区分をもらい、コードに対応するHihokenshaKubun型のenumを返します。
     *
     * @param code 被保険者区分コード
     * @return 引数のコードに対応するHihokenshaKubun型のenum
     */
    public static HihokenshaKubun toValue(RString code) {
        for (HihokenshaKubun data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("指定したコードに対応するHihokenshaKubun").getMessage());
    }

}
