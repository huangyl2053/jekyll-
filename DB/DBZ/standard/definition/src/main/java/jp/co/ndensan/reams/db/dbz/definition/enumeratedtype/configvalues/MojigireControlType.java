/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 文字切れ時の制御方法を表す列挙値です。
 *
 * @author n8178 城間篤人
 */
public enum MojigireControlType {

    /**
     * 文字切れ時に印字しないことを示します。
     */
    印字しない("0"),
    /**
     * 文字切れ時に、印字可能範囲まで印字することを示します。
     */
    印字可能範囲まで印字する("1"),
    /**
     * 文字切れ時に、オーバーフローした文字を印字します。
     */
    オーバーフロー文字を印字する("2");

    private final RString value;

    private MojigireControlType(String value) {
        this.value = new RString(value);
    }

    /**
     * 文字切れ時制御方法を表す文字列を返します。
     *
     * @return 文字切れ時制御方法を表す文字列
     */
    public RString getValue() {
        return value;
    }

    /**
     * 引数から指定した文字列に対応する、文字切れ時制御方法を取得します。
     *
     * @param value 文字切れ時制御方法を表す文字列
     * @return 引数の文字列に対応した文字切れ時制御方法
     * @throws IllegalArgumentException 対応する文字切れ時制御方法が存在しない場合
     */
    public static MojigireControlType toValue(RString value) throws IllegalArgumentException {
        for (MojigireControlType controlType : values()) {
            if (controlType.getValue().equals(value)) {
                return controlType;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("引数から受け取った文字列を、文字切れ時制御方法"));
    }
}
