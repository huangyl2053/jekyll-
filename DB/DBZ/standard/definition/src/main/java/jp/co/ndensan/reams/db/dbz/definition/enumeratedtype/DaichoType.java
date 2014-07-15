/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 台帳種別を表す列挙型です。
 *
 * @author N3317 塚田 萌
 */
public enum DaichoType {

    /**
     * 台帳種別が「被保険者台帳」であることを表します。 <br />
     * コード：1
     */
    被保険者台帳("1"),
    /**
     * 台帳種別が「適用除外者台帳」であることを表します。 <br />
     * コード：2
     */
    適用除外者台帳("2"),
    /**
     * 台帳種別が「他市町村住所地特例者台帳」であることを表します。 <br />
     * コード：2
     */
    他市町村住所地特例者台帳("3");
    private final RString code;

    private DaichoType(String code) {
        this.code = new RString(code);
    }

    /**
     * RString型の台帳種別コードを返します。
     *
     * @return 台帳種別コード
     */
    public RString getCode() {
        return code;
    }

    /**
     * RString型の台帳種別コードをもらい、コードに対応するDaichoType型のenumを返します。
     *
     * @param code 台帳種別コード
     * @return 引数のコードに対応するDaichoType型のenum
     */
    public static DaichoType toValue(RString code) {
        for (DaichoType data : values()) {
            if (data.getCode().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("指定したコードに対応する台帳種別").getMessage());
    }
}
