package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 通知書定型文管理項目番号を表す列挙型です。
 *
 * @author LDNS
 */
public enum TeikenbunKomokuNo {

    /**
     * コード:1 名称:申請書文言 略称:定義なし
     */
    申請書文言("1", "申請書文言"),
    /**
     * コード:2 名称:注意文言 略称:定義なし
     */
    注意文言("2", "注意文言"),
    /**
     * コード:3 名称:同意文言 略称:定義なし
     */
    同意文言("3", "同意文言"),
    /**
     * コード:4 名称:申請書文言２ 略称:定義なし
     */
    申請書文言２("4", "申請書文言２"),
    /**
     * コード:5 名称:申請書文言３ 略称:定義なし
     */
    申請書文言３("5", "申請書文言３"),
    /**
     * コード:6 名称:内容１ 略称:定義なし
     */
    内容１("6", "内容１"),
    /**
     * コード:7 名称:内容２ 略称:定義なし
     */
    内容２("7", "内容２"),
    /**
     * コード:8 名称:内容３ 略称:定義なし
     */
    内容３("8", "内容３");

    private final RString code;
    private final RString fullName;

    private TeikenbunKomokuNo(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 通知書定型文管理項目番号のコードを返します。
     *
     * @return 通知書定型文管理項目番号のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 通知書定型文管理項目番号の名称を返します。
     *
     * @return 通知書定型文管理項目番号の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 通知書定型文管理項目番号のコードと一致する内容を探します。
     *
     * @param code 通知書定型文管理項目番号のコード
     * @return {@code code} に対応する通知書定型文管理項目番号
     */
    public static TeikenbunKomokuNo toValue(RString code) {

        for (TeikenbunKomokuNo teikenbunKomokuNo : TeikenbunKomokuNo.values()) {
            if (teikenbunKomokuNo.code.equals(code)) {
                return teikenbunKomokuNo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("通知書定型文管理項目番号"));
    }
}
