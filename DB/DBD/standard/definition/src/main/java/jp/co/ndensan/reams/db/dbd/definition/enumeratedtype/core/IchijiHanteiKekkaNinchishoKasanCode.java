package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定一次判定結果コード09（認知症加算）を表す列挙型です。
 *
 * @author LDNS
 */
public enum IchijiHanteiKekkaNinchishoKasanCode {

    /**
     * コード:1 名称:なし（□□） 略称:定義なし
     */
    なし("1", "なし（□□）"),
    /**
     * コード:2 名称:一段階の重度変更（■□） 略称:定義なし
     */
    一段階の重度変更("2", "一段階の重度変更（■□）"),
    /**
     * コード:3 名称:二段階の重度変更（■■） 略称:定義なし
     */
    二段階の重度変更("3", "二段階の重度変更（■■）");

    private final RString code;
    private final RString fullName;

    private IchijiHanteiKekkaNinchishoKasanCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 要介護認定一次判定結果コード09（認知症加算）のコードを返します。
     *
     * @return 要介護認定一次判定結果コード09（認知症加算）のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 要介護認定一次判定結果コード09（認知症加算）の名称を返します。
     *
     * @return 要介護認定一次判定結果コード09（認知症加算）の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 要介護認定一次判定結果コード09（認知症加算）のコードと一致する内容を探します。
     *
     * @param code 要介護認定一次判定結果コード09（認知症加算）のコード
     * @return {@code code} に対応する要介護認定一次判定結果コード09（認知症加算）
     */
    public static IchijiHanteiKekkaNinchishoKasanCode toValue(RString code) {

        for (IchijiHanteiKekkaNinchishoKasanCode value : IchijiHanteiKekkaNinchishoKasanCode.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("要介護認定一次判定結果コード09（認知症加算）"));
    }
}
