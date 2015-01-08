/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証に印字される、居宅支援事業者履歴の印字方法を表す列挙型です。
 *
 * @author n8178 城間篤人
 */
public enum KyotakuJigyoshaRirekiPrintType {

    /**
     * 居宅支援事業者履歴を印字することを示します。
     */
    表示("0"),
    /**
     * 居宅支援事業者履歴を印字しないことを示します。
     */
    非表示("1"),
    /**
     * 居宅支援事業者履歴を印字するが、上から"*"を重ねて印字して潰すことを示します。
     */
    アスタリスク("2"),
    /**
     * 居宅支援事業者履歴を印字するが、抹消線を引くことを示します。
     */
    抹消線("3");

    private final RString value;

    private KyotakuJigyoshaRirekiPrintType(String value) {
        this.value = new RString(value);
    }

    /**
     * 居宅支援事業者印字方法を表す文字列を印字します。
     *
     * @return 居宅支援事業者印字方法を表す文字列
     */
    public RString getValue() {
        return value;
    }

    /**
     * 引数から指定した文字列に対応する、居宅支援事業者印字方法を取得します。
     *
     * @param value 居宅支援事業者印字方法を表す文字列
     * @return 引数の文字列に対応した居宅支援事業者印字方法
     * @throws IllegalArgumentException 対応する居宅支援事業者印字方法が存在しない場合
     */
    public static KyotakuJigyoshaRirekiPrintType toValue(RString value) throws IllegalArgumentException {
        for (KyotakuJigyoshaRirekiPrintType printType : values()) {
            if (printType.getValue().equals(value)) {
                return printType;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("引数から受け取った文字列を、居宅支援事業者印字方法"));
    }

}
