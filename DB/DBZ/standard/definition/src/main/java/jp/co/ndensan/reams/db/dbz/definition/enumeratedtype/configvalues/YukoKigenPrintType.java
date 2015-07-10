/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証を印字する際に、有効期限をどのように印字するかを表す列挙値です。
 *
 * @author n8178 城間篤人
 */
public enum YukoKigenPrintType {

    /**
     * 合併日～有効期限を印字することを示します。
     */
    合併日から有効期限("1"),
    /**
     * 有効期限のみ印字することを示します。
     */
    有効期限のみ("2");

    private final RString value;

    private YukoKigenPrintType(String value) {
        this.value = new RString(value);
    }

    /**
     * 有効期限印字方法を表す文字列を印字します。
     *
     * @return 有効期限印字方法を表す文字列
     */
    public RString getValue() {
        return value;
    }

    /**
     * 引数から指定した文字列に対応する、有効期限印字方法を取得します。
     *
     * @param value 有効期限印字方法を表す文字列
     * @return 引数の文字列に対応した有効期限印字方法
     * @throws IllegalArgumentException 対応する有効期限印字方法が存在しない場合
     */
    public static YukoKigenPrintType toValue(RString value) throws IllegalArgumentException {
        for (YukoKigenPrintType printType : values()) {
            if (printType.getValue().equals(value)) {
                return printType;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("引数から受け取った文字列を、有効期限印字方法"));
    }

}
