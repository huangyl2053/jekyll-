/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.strings.IRStringConvertable;

/**
 * 基本運用の処理状態を定義した列挙型です。
 *
 * @author n3521 星野 正明
 */
public enum KihonunyoShoriJotai implements IRStringConvertable {

    /**
     * 未処理分であることを表します。
     */
    未処理("0", "未", "未処理"),
    /**
     * 処理可能分であることを表します。
     */
    処理可能("1", "可", "処理可能");

    private final RString code;
    private final RString shortName;
    private final RString fullName;

    private KihonunyoShoriJotai(String code, String shortName, String fullName) {
        this.code = new RString(code);
        this.shortName = new RString(shortName);
        this.fullName = new RString(fullName);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString getCode() {
        return this.code;
    }

    /**
     * 基本運用の処理状態の略称を返します。
     *
     * @return 基本運用の処理状態の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 基本運用の処理状態の名称を返します。
     *
     * @return 基本運用の処理状態の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 指定のコードに対応するKihonunyoShoriJotaiを返します。
     *
     * @param code コード
     * @return 指定のコードに対応するJigyoshaKubun
     * @throws IllegalArgumentException 指定のコードに対応するJigyoshaKubunがないとき
     */
    public static KihonunyoShoriJotai toValue(RString code) throws IllegalArgumentException {
        for (KihonunyoShoriJotai target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない
                .getMessage().replace("コードに対応する基本運用の処理状態").evaluate());
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }

}
