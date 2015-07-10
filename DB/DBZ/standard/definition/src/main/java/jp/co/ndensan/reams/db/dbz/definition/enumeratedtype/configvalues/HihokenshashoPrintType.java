/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証の表示タイプを表す列挙値です。
 *
 * @author n8178 城間篤人
 */
public enum HihokenshashoPrintType {

    /**
     * A4サイズ横向きを示します。
     */
    A4横("01"),
    /**
     * B4サイズ横向きを示します。
     */
    B4横("21");

    private final RString value;

    private HihokenshashoPrintType(String value) {
        this.value = new RString(value);
    }

    /**
     * 証表示タイプを表す文字列を取得します。
     *
     * @return 証表示タイプを表す文字列
     */
    public RString getValue() {
        return value;
    }

    /**
     * 引数から指定した文字列に対応する、証表示タイプを取得します。
     *
     * @param value 証表示タイプを表す文字列
     * @return 引数の文字列に対応した証表示タイプ
     * @throws IllegalArgumentException 対応する証表示タイプが存在しない場合
     */
    public static HihokenshashoPrintType toValue(RString value) throws IllegalArgumentException {
        for (HihokenshashoPrintType printType : values()) {
            if (printType.getValue().equals(value)) {
                return printType;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("引数から受け取った文字列を、証表示タイプ"));
    }
}
