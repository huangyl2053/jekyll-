/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.core.shotoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.strings.IRStringConvertable;

/**
 * 登録業務の列挙型です。
 */
public enum TorokuGyomu implements IRStringConvertable {

    /**
     * 住民税 <br />
     * コード : 1
     */
    住民税("1"),
    /**
     * 介護保険 <br />
     * コード : 2
     */
    介護保険("2");
    private final RString code;

    private TorokuGyomu(String code) {
        this.code = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString code() {
        return this.code;
    }

    /**
     * 指定のコードに対応するTorokuGyomuを返します。
     *
     * @param code コード
     * @return 指定のコードに対応するTorokuGyomu
     * @throws IllegalArgumentException 指定のコードに対応するTorokuGyomuがないとき
     */
    public static TorokuGyomu toValue(RString code) throws IllegalArgumentException {
        for (TorokuGyomu target : values()) {
            if (target.code().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない
                .getMessage().replace("コードに対応する登録区分").evaluate());
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }
}
