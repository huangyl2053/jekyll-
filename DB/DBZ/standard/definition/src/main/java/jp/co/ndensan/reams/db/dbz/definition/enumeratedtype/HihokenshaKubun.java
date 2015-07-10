/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
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
    第1号被保険者("1", "第1号"),
    /**
     * 被保険者区分が「2号被保険者」であることを表します。 <br />
     * コード：2
     */
    第2号被保険者("2", "第2号");

    private final RString theCode;
    private final RString ryakusho;

    private HihokenshaKubun(String code, String ryakusho) {
        this.theCode = new RString(code);
        this.ryakusho = new RString(ryakusho);
    }

    /**
     * コードを返します。
     *
     * @return 被保険者区分コード
     */
    public RString code() {
        return theCode;
    }

    /**
     * 被保険者区分の略称を返します。
     *
     * @return 略称
     */
    public RString get略称() {
        return ryakusho;
    }

    /**
     * {@link #name() name()}を{@link RString}へ変換して返します。
     *
     * @return {@link #name() name()}を{@link RString}へ変換した物
     */
    public RString toRString() {
        return new RString(name());
    }

    /**
     * 引数のコードに対応する{@link HihokenshaKubun}を返します。
     *
     * @param code コード
     * @return コードに対応する{@link HihokenshaKubun}
     * @throws IllegalArgumentException コードに対応する{@link HihokenshaKubun}が無い時
     */
    public static HihokenshaKubun toValue(RString code) {
        for (HihokenshaKubun data : values()) {
            if (data.code().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(HihokenshaKubun.class.getSimpleName()));
    }
}
