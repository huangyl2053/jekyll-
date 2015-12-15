package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 二次判定結果入力方法を表す列挙型です。
 *
 * @author LDNS
 */
public enum NijiHanteiKekkaInputHoho {

    /**
     * コード:1 名称:画面入力 略称:定義なし
     */
    画面入力("1", "画面入力"),
    /**
     * コード:2 名称:モバイル取込み 略称:定義なし
     */
    モバイル取込み("2", "モバイル取込み"),
    /**
     * コード:3 名称:OCR取込み 略称:定義なし
     */
    OCR取込み("3", "OCR取込み");

    private final RString code;
    private final RString fullName;

    private NijiHanteiKekkaInputHoho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 二次判定結果入力方法のコードを返します。
     *
     * @return 二次判定結果入力方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 二次判定結果入力方法の名称を返します。
     *
     * @return 二次判定結果入力方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 二次判定結果入力方法のコードと一致する内容を探します。
     *
     * @param code 二次判定結果入力方法のコード
     * @return {@code code} に対応する二次判定結果入力方法
     */
    public static NijiHanteiKekkaInputHoho toValue(RString code) {

        for (NijiHanteiKekkaInputHoho nijiHanteiKekkaInputHoho : NijiHanteiKekkaInputHoho.values()) {
            if (nijiHanteiKekkaInputHoho.code.equals(code)) {
                return nijiHanteiKekkaInputHoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("二次判定結果入力方法"));
    }
}
