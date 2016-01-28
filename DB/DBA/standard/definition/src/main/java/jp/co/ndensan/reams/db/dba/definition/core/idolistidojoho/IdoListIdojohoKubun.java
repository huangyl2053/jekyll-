package jp.co.ndensan.reams.db.dba.definition.core.idolistidojoho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 異動リスト異動情報区分を表す列挙型です。
 */
public enum IdoListIdojohoKubun {

    /**
     * コード:101 名称:取得異動 略称:定義なし
     */
    取得異動("101", "取得異動"),
    /**
     * コード:102 名称:喪失異動 略称:定義なし
     */
    喪失異動("102", "喪失異動"),
    /**
     * コード:103 名称:変更移動 略称:定義なし
     */
    変更移動("103", "変更移動"),
    /**
     * コード:104 名称:住特適用異動 略称:定義なし
     */
    住特適用異動("104", "住特適用異動"),
    /**
     * コード:105 名称:住特解除異動 略称:定義なし
     */
    住特解除異動("105", "住特解除異動"),
    /**
     * コード:106 名称:適用異動 略称:定義なし
     */
    適用異動("106", "適用異動"),
    /**
     * コード:107 名称:解除異動 略称:定義なし
     */
    解除異動("107", "解除異動"),
    /**
     * コード:108 名称:入所異動 略称:定義なし
     */
    入所異動("108", "入所異動"),
    /**
     * コード:109 名称:退所異動 略称:定義なし
     */
    退所異動("109", "退所異動"),
    /**
     * コード:110 名称:開始異動 略称:定義なし
     */
    開始異動("110", "開始異動"),
    /**
     * コード:111 名称:廃止異動 略称:定義なし
     */
    廃止異動("111", "廃止異動"),
    /**
     * コード:112 名称:終了異動 略称:定義なし
     */
    終了異動("112", "終了異動"),
    /**
     * コード:201 名称:取得削除 略称:定義なし
     */
    取得削除("201", "取得削除"),
    /**
     * コード:202 名称:喪失削除 略称:定義なし
     */
    喪失削除("202", "喪失削除"),
    /**
     * コード:203 名称:変更削除 略称:定義なし
     */
    変更削除("203", "変更削除"),
    /**
     * コード:204 名称:住特適用削除 略称:定義なし
     */
    住特適用削除("204", "住特適用削除"),
    /**
     * コード:205 名称:住特解除削除 略称:定義なし
     */
    住特解除削除("205", "住特解除削除"),
    /**
     * コード:206 名称:適用削除 略称:定義なし
     */
    適用削除("206", "適用削除"),
    /**
     * コード:207 名称:解除削除 略称:定義なし
     */
    解除削除("207", "解除削除"),
    /**
     * コード:301 名称:広域内転居 略称:定義なし
     */
    広域内転居("301", "広域内転居");

    private final RString code;
    private final RString fullName;

    private IdoListIdojohoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 異動リスト異動情報区分のコードを返します。
     *
     * @return 異動リスト異動情報区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 異動リスト異動情報区分の名称を返します。
     *
     * @return 異動リスト異動情報区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 異動リスト異動情報区分のコードと一致する内容を探します。
     *
     * @param code 異動リスト異動情報区分のコード
     * @return {@code code} に対応する異動リスト異動情報区分
     */
    public static IdoListIdojohoKubun toValue(RString code) {
        for (IdoListIdojohoKubun idoListIdojohoKubun : IdoListIdojohoKubun.values()) {
            if (idoListIdojohoKubun.code.equals(code)) {
                return idoListIdojohoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("異動リスト異動情報区分"));
    }
}
