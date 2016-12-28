/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域業務範囲コードのコンフィグの取得結果の列挙型クラスです。
 */
public enum KoikiGyomuHaniCodeType {

    /**
     * 広域審査会のみ
     */
    広域審査会のみ("1"),
    /**
     * 広域審査会のみと依頼業務
     */
    広域審査会のみと依頼業務("2");
    private final RString code;

    private KoikiGyomuHaniCodeType(String code) {
        this.code = new RString(code);
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
     * name()と同じ文字列をRString型で返します。
     *
     * @return name()と同じ文字列を持ったRString
     */
    public RString toRString() {
        return new RString(this.toString());
    }

    /**
     * 指定された広域業務範囲コードに該当するEnumを返します。
     *
     * @param code 広域業務範囲コード
     * @return 引数のコードに対応するKoikiGyomuHaniCodeType型のenum
     * @throws NullPointerException Error
     * @throws IllegalArgumentException 実在しない広域業務範囲コードの場合
     */
    public static KoikiGyomuHaniCodeType toValue(RString code) throws NullPointerException, IllegalArgumentException {

        for (KoikiGyomuHaniCodeType item : KoikiGyomuHaniCodeType.values()) {
            if (item.code.equals(code)) {
                return item;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("広域業務範囲コード").evaluate());

    }
}
