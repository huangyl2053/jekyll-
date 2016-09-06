package jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者IF_突合依頼情報抽出区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 sunhaidi
 */
public enum JyukyusyaIF_TotugoIraiJyohoTyusyutuKubun {

    /**
     * コード:1 名称:認定期間内の最新情報 略称:認定期間内の最新情報
     */
    認定期間内の最新情報("1", "認定期間内の最新情報", "認定期間内の最新情報"),

    /**
     * コード:2 名称:認定期間内の全情報 略称:認定期間内の全情報
     */
    認定期間内の全情報("2", "認定期間内の全情報", "認定期間内の全情報"),

    /**
     * コード:3 名称:一定期間内の最新情報 略称:一定期間内の最新情報
     */
    一定期間内の最新情報("3", "一定期間内の最新情報", "一定期間内の最新情報"),

    /**
     * コード:4 名称:一定期間内の全情報 略称:一定期間内の全情報
     */
    一定期間内の全情報("4", "一定期間内の全情報", "一定期間内の全情報");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private JyukyusyaIF_TotugoIraiJyohoTyusyutuKubun(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 受給者IF_突合依頼情報抽出区分のコードを返します。
     *
     * @return 受給者IF_突合依頼情報抽出区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 受給者IF_突合依頼情報抽出区分の名称を返します。
     *
     * @return 受給者IF_突合依頼情報抽出区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 受給者IF_突合依頼情報抽出区分の略称を返します。
     *
     * @return 受給者IF_突合依頼情報抽出区分の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 受給者IF_突合依頼情報抽出区分のコードと一致する内容を探します。
     *
     * @param code 受給者IF_突合依頼情報抽出区分のコード
     * @return {@code code} に対応する受給者IF_突合依頼情報抽出区分
     */
    public static JyukyusyaIF_TotugoIraiJyohoTyusyutuKubun toValue(RString code) {
        for (JyukyusyaIF_TotugoIraiJyohoTyusyutuKubun value : JyukyusyaIF_TotugoIraiJyohoTyusyutuKubun.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}
