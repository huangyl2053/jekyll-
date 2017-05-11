/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 一次判定結果を扱うユーティリティです。
 */
public final class IchijiHanteiKekkaSupport {

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
     * @param code 一次判定結果コード
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

    /**
     * @param 厚労省IF識別コード 厚労省IF識別コード
     * @param 一次判定結果コード 一次判定結果コード
     * @param 一次判定結果コード_認知症加算 一次判定結果コード（認知症加算）
     * @return 一次判定結果の名称。認知症加算後の結果に変化がある場合「略称→略称」の形式
     */
    public static RString compose一次判定結果表示名(RString 厚労省IF識別コード, RString 一次判定結果コード, RString 一次判定結果コード_認知症加算) {
        IIchijiHanteiKekkaCode kekkaName = toValueOrEmpty(厚労省IF識別コード, 一次判定結果コード);
        if (Objects.equals(一次判定結果コード, 一次判定結果コード_認知症加算) || RString.isNullOrEmpty(一次判定結果コード_認知症加算)) {
            return kekkaName.get名称();
        }
        IIchijiHanteiKekkaCode kasanName = toValueOrEmpty(厚労省IF識別コード, 一次判定結果コード_認知症加算);
        return new RStringBuilder().append(kekkaName.get略称()).append("→").append(kasanName.get略称()).toRString();
    }

}
