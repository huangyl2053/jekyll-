package jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用状況統計表_サービス区分を表す列挙型です。
 *
 *  @reamsid_L DBC-9999-023 sunhaidi
 */
public enum RiyojokyoTokeihyo_ServiceKubun {

    /**
     * コード:1 名称:在宅 略称:在宅
     */
    在宅("1", "在宅", "在宅"),

    /**
     * コード:2 名称:施設 略称:施設
     */
    施設("2", "施設", "施設"),

    /**
     * コード:3 名称:その他 略称:その他
     */
    その他("3", "その他", "その他"),

    /**
     * コード:9 名称:混在 略称:混在
     */
    混在("9", "混在", "混在");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private RiyojokyoTokeihyo_ServiceKubun(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 利用状況統計表_サービス区分のコードを返します。
     *
     * @return 利用状況統計表_サービス区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 利用状況統計表_サービス区分の名称を返します。
     *
     * @return 利用状況統計表_サービス区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 利用状況統計表_サービス区分の略称を返します。
     *
     * @return 利用状況統計表_サービス区分の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 利用状況統計表_サービス区分のコードと一致する内容を探します。
     *
     * @param code 利用状況統計表_サービス区分のコード
     * @return {@code code} に対応する利用状況統計表_サービス区分
     */
    public static RiyojokyoTokeihyo_ServiceKubun toValue(RString code) {
        for (RiyojokyoTokeihyo_ServiceKubun value : RiyojokyoTokeihyo_ServiceKubun.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}
