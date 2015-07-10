/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者番号の印字方法を示す列挙値です。
 *
 * @author n8178 城間篤人
 */
public enum HihokenshaNoPrintType {

    /**
     * 被保険者番号の前ゼロをスペースに変換することを示します。
     */
    前ゼロをスペースに変換("1"),
    /**
     * 被保険者番号をそのまま印字することを示します。
     */
    そのまま("2");

    private final RString value;

    private HihokenshaNoPrintType(String value) {
        this.value = new RString(value);
    }

    /**
     * 被保険者番号印字方法を表す文字列を印字します。
     *
     * @return 被保険者番号印字方法を表す文字列
     */
    public RString getValue() {
        return value;
    }

    /**
     * 引数から指定した文字列に対応する、被保険者番号印字方法を取得します。
     *
     * @param value 被保険者番号印字方法を表す文字列
     * @return 引数の文字列に対応した被保険者番号印字方法
     * @throws IllegalArgumentException 対応する被保険者番号印字方法が存在しない場合
     */
    public static HihokenshaNoPrintType toValue(RString value) throws IllegalArgumentException {
        for (HihokenshaNoPrintType printType : values()) {
            if (printType.getValue().equals(value)) {
                return printType;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("引数から受け取った文字列を、被保険者番号印字方法"));
    }

}
