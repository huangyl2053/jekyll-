package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * カスタマバーコード変換エラー編集方法を表す列挙型です。
 *
 * @author LDNS
 */
public enum CustomerBarcodeHenkanErrorHenshuHoho {

    /**
     * コード:1 名称:空白をセット 略称:定義なし
     */
    空白をセット("1", "空白をセット"),
    /**
     * コード:2 名称:入力郵便番号をセット 略称:定義なし
     */
    入力郵便番号をセット("2", "入力郵便番号をセット");

    private final RString code;
    private final RString fullName;

    private CustomerBarcodeHenkanErrorHenshuHoho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * カスタマバーコード変換エラー編集方法のコードを返します。
     *
     * @return カスタマバーコード変換エラー編集方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * カスタマバーコード変換エラー編集方法の名称を返します。
     *
     * @return カスタマバーコード変換エラー編集方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * カスタマバーコード変換エラー編集方法のコードと一致する内容を探します。
     *
     * @param code カスタマバーコード変換エラー編集方法のコード
     * @return {@code code} に対応するカスタマバーコード変換エラー編集方法
     */
    public static CustomerBarcodeHenkanErrorHenshuHoho toValue(RString code) {

        for (CustomerBarcodeHenkanErrorHenshuHoho value : CustomerBarcodeHenkanErrorHenshuHoho.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("カスタマバーコード変換エラー編集方法"));
    }
}
