package jp.co.ndensan.reams.db.dbc.definition.core.keiyakuservice;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 契約サービス種類を表す列挙型です。
 *
 * @author LDNS
 */
public enum KeiyakuServiceShurui {

    /**
     * コード:01 名称:福祉用具 略称:定義なし
     */
    福祉用具("01", "福祉用具"),
    /**
     * コード:02 名称:住宅改修 略称:定義なし
     */
    住宅改修("02", "住宅改修"),
    /**
     * コード:03 名称:予防福祉用具 略称:定義なし
     */
    予防福祉用具("03", "予防福祉用具"),
    /**
     * コード:04 名称:予防住宅改修 略称:定義なし
     */
    予防住宅改修("04", "予防住宅改修"),
    /**
     * コード:05 名称:償還払支給 略称:定義なし
     */
    償還払支給("05", "償還払支給"),
    /**
     * コード:06 名称:高額給付支給 略称:定義なし
     */
    高額給付支給("06", "高額給付支給");

    private final RString code;
    private final RString fullName;

    private KeiyakuServiceShurui(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 契約サービス種類のコードを返します。
     *
     * @return 契約サービス種類のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 契約サービス種類の名称を返します。
     *
     * @return 契約サービス種類の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 契約サービス種類のコードと一致する内容を探します。
     *
     * @param code 契約サービス種類のコード
     * @return {@code code} に対応する契約サービス種類
     */
    public static KeiyakuServiceShurui toValue(RString code) {

        for (KeiyakuServiceShurui keiyakuServiceShurui : KeiyakuServiceShurui.values()) {
            if (keiyakuServiceShurui.code.equals(code)) {
                return keiyakuServiceShurui;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("契約サービス種類"));
    }
}
