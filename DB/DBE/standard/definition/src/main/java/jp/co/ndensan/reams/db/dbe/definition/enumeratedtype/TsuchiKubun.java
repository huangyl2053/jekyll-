/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 通知区分を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum TsuchiKubun {

    /**
     * 通知区分が「認定」であることを表します。<br />
     * コード : 0
     */
    認定("0"),
    /**
     * 通知区分が「変更」であることを表します。<br />
     * コード : 1
     */
    変更("1"),
    /**
     * 通知区分が「サ変」であることを表します。<br />
     * コード : 2
     */
    サ変("2"),
    /**
     * 通知区分が「却下」であることを表します。<br />
     * コード : 3
     */
    却下("3"),
    /**
     * 通知区分が「取消」であることを表します。<br />
     * コード : 4
     */
    取消("4"),
    /**
     * 通知区分が「延期」であることを表します。<br />
     * コード : 5
     */
    延期("5"),
    /**
     * 通知区分が「区却」であることを表します。<br />
     * コード : 6
     */
    区却("6");
    private RString code;

    private TsuchiKubun(String code) {
        this.code = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 引数のコードに対応する通知区分を返します。
     *
     * @param code コード
     * @return 通知区分
     */
    public static TsuchiKubun toValue(RString code) {
        for (TsuchiKubun data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する通知区分").evaluate());
    }
}
