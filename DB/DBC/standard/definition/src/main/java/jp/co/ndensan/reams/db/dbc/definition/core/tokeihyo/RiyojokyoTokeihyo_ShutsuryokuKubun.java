package jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用状況統計表_出力区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum RiyojokyoTokeihyo_ShutsuryokuKubun {

    /**
     * コード:1 名称:出力しない 略称:定義なし
     */
    出力しない("0", "出力しない"),
    /**
     * コード:2 名称:出力する 略称:定義なし
     */
    出力する("1", "出力する");

    private final RString code;
    private final RString fullName;

    private RiyojokyoTokeihyo_ShutsuryokuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 利用状況統計表_出力区分のコードを返します。
     *
     * @return 利用状況統計表_出力区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 利用状況統計表_出力区分の名称を返します。
     *
     * @return 利用状況統計表_出力区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 利用状況統計表_出力区分のコードと一致する内容を探します。
     *
     * @param code 利用状況統計表_出力区分のコード
     * @return {@code code} に対応する利用状況統計表_出力区分
     */
    public static RiyojokyoTokeihyo_ShutsuryokuKubun toValue(RString code) {
        for (RiyojokyoTokeihyo_ShutsuryokuKubun shutsuryokuKubun : RiyojokyoTokeihyo_ShutsuryokuKubun.values()) {
            if (shutsuryokuKubun.code.equals(code)) {
                return shutsuryokuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("利用状況統計表_出力区分"));
    }
}
