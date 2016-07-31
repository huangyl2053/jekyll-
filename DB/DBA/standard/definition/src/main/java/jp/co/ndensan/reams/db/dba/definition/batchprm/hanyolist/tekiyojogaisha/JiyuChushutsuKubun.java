package jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.tekiyojogaisha;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事由抽出区分を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 wangchao
 */
public enum JiyuChushutsuKubun {

    /**
     * コード:1 名称:適用除外者のみ 略称:定義なし
     */
    適用除外者のみ("1", "適用除外者のみ"),
    /**
     * コード:2 名称:適用除外解除者のみ 略称:定義なし
     */
    適用除外解除者のみ("2", "適用除外解除者のみ"),
    /**
     * コード:0 名称:両方 略称:定義なし
     */
    両方("0", "両方");

    private final RString code;
    private final RString fullName;

    private JiyuChushutsuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 事由抽出区分のコードを返します。
     *
     * @return 事由抽出区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 事由抽出区分の名称を返します。
     *
     * @return 事由抽出区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 事由抽出区分のコードと一致する内容を探します。
     *
     * @param code 事由抽出区分のコード
     * @return {@code code} に対応する事由抽出区分
     */
    public static JiyuChushutsuKubun toValue(RString code) {
        for (JiyuChushutsuKubun jiyuChushutsuKubun : JiyuChushutsuKubun.values()) {
            if (jiyuChushutsuKubun.code.equals(code)) {
                return jiyuChushutsuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("事由抽出区分"));
    }
}
