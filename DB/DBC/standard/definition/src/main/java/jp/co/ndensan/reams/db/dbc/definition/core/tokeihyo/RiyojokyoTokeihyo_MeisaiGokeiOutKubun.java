package jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用状況統計表_明細合計出力区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum RiyojokyoTokeihyo_MeisaiGokeiOutKubun {

    /**
     * コード:1 名称:明細合計 略称:定義なし
     */
    明細合計("1", "明細合計"),
    /**
     * コード:2 名称:明細のみ 略称:定義なし
     */
    明細のみ("2", "明細のみ"),
    /**
     * コード:3 名称:合計のみ 略称:定義なし
     */
    合計のみ("3", "合計のみ");

    private final RString code;
    private final RString fullName;

    private RiyojokyoTokeihyo_MeisaiGokeiOutKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 利用状況統計表_明細合計出力区分のコードを返します。
     *
     * @return 利用状況統計表_明細合計出力区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 利用状況統計表_明細合計出力区分の名称を返します。
     *
     * @return 利用状況統計表_明細合計出力区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 利用状況統計表_明細合計出力区分のコードと一致する内容を探します。
     *
     * @param code 利用状況統計表_明細合計出力区分のコード
     * @return {@code code} に対応する利用状況統計表_明細合計出力区分
     */
    public static RiyojokyoTokeihyo_MeisaiGokeiOutKubun toValue(RString code) {
        for (RiyojokyoTokeihyo_MeisaiGokeiOutKubun meisaiGokeiOutKubun : RiyojokyoTokeihyo_MeisaiGokeiOutKubun.values()) {
            if (meisaiGokeiOutKubun.code.equals(code)) {
                return meisaiGokeiOutKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("利用状況統計表_明細合計出力区分"));
    }
}
