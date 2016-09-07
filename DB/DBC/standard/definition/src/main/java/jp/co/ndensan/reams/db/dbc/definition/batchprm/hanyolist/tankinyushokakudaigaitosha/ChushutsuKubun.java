package jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.tankinyushokakudaigaitosha;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 抽出区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum ChushutsuKubun {

    /**
     * コード:0 名称:すべて 略称:定義なし
     */
    すべて("0", "すべて"),
    /**
     * コード:1 名称:最新拡大データ 略称:定義なし
     */
    最新拡大データ("1", "最新拡大データ");

    private final RString code;
    private final RString fullName;

    private ChushutsuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 抽出区分のコードを返します。
     *
     * @return 抽出区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 抽出区分の名称を返します。
     *
     * @return 抽出区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 抽出区分のコードと一致する内容を探します。
     *
     * @param code 抽出区分のコード
     * @return {@code code} に対応する抽出区分
     */
    public static ChushutsuKubun toValue(RString code) {
        for (ChushutsuKubun chushutsuKubun : ChushutsuKubun.values()) {
            if (chushutsuKubun.code.equals(code)) {
                return chushutsuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("抽出区分"));
    }
}
