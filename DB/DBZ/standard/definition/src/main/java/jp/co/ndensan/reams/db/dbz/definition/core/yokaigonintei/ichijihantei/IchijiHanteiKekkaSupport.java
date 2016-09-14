/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一次判定結果を扱うユーティリティです。
 */
public class IchijiHanteiKekkaSupport {

    private IchijiHanteiKekkaSupport() {
    }

    private static final IIchijiHanteiKekkaCode EMPTY;

    static {

        EMPTY = new IIchijiHanteiKekkaCode() {

            @Override
            public RString getコード() {
                return RString.EMPTY;
            }

            @Override
            public RString get名称() {
                return RString.EMPTY;
            }

            @Override
            public RString get略称() {
                return RString.EMPTY;
            }
        };
    }

    /**
     * 指定の厚労省IF識別コード時点での一次判定結果コードに対する名称や略称を返却します。
     *
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param コード 一次判定結果コード
     * @return 入力のコードに対応する名称や略称
     */
    public static IIchijiHanteiKekkaCode toValueOrEmpty(final RString 厚労省IF識別コード, final RString コード) {
        if (!KoroshoIfShikibetsuCode.existsCode(厚労省IF識別コード)) {
            return EMPTY;
        }
        KoroshoIfShikibetsuCode kisc = KoroshoIfShikibetsuCode.toValue(厚労省IF識別コード);
        switch (kisc) {
            case 認定ｿﾌﾄ2009_SP3:
                return ifNullThenEMPTY(IchijiHanteiKekkaCode09.toValueOrNull(コード));
            case 認定ｿﾌﾄ2009:
                return ifNullThenEMPTY(IchijiHanteiKekkaCode09.toValueOrNull(コード));
            case 認定ｿﾌﾄ2006_新要介護認定適用区分が未適用:
                return ifNullThenEMPTY(IchijiHanteiKekkaCode06.toValueOrNull(コード));
            case 認定ｿﾌﾄ2002:
                return ifNullThenEMPTY(IchijiHanteiKekkaCode02.toValueOrNull(コード));
            case 認定ｿﾌﾄ99:
                return ifNullThenEMPTY(IchijiHanteiKekkaCode99.toValueOrNull(コード));
            default:
                return EMPTY;
        }
    }

    private static IIchijiHanteiKekkaCode ifNullThenEMPTY(IIchijiHanteiKekkaCode value) {
        return value == null ? EMPTY : value;
    }

    /**
     * 指定の厚労省IF識別コード時点での一次判定結果コードに対する名称や略称を返却します。
     *
     * @param コード 一次判定結果コード
     * @return 入力のコードに対応する名称や略称
     */
    public static IIchijiHanteiKekkaCode toValueOrEmpty(RString code) {
        IIchijiHanteiKekkaCode conveterd = IchijiHanteiKekkaCode09.toValueOrNull(code);
        if (conveterd != null) {
            return conveterd;
        }
        conveterd = IchijiHanteiKekkaCode06.toValueOrNull(code);
        if (conveterd != null) {
            return conveterd;
        }
        conveterd = IchijiHanteiKekkaCode02.toValueOrNull(code);
        if (conveterd != null) {
            return conveterd;
        }
        conveterd = IchijiHanteiKekkaCode99.toValueOrNull(code);
        if (conveterd != null) {
            return conveterd;
        }
        return EMPTY;
    }
}
