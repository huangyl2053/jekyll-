package jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.seiho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 範囲抽出日区分を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 wangchao
 */
public enum HaniChushutsubiKubun {

    /**
     * コード:1 名称:生保開始日 略称:定義なし
     */
    生保開始日("1", "生保開始日"),
    /**
     * コード:2 名称:生保終了日 略称:定義なし
     */
    生保終了日("2", "生保終了日");

    private final RString code;
    private final RString fullName;

    private HaniChushutsubiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 範囲抽出日区分のコードを返します。
     *
     * @return 範囲抽出日区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 範囲抽出日区分の名称を返します。
     *
     * @return 範囲抽出日区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 範囲抽出日区分のコードと一致する内容を探します。
     *
     * @param code 範囲抽出日区分のコード
     * @return {@code code} に対応する範囲抽出日区分
     */
    public static HaniChushutsubiKubun toValue(RString code) {
        for (HaniChushutsubiKubun haniChushutsubiKubun : HaniChushutsubiKubun.values()) {
            if (haniChushutsubiKubun.code.equals(code)) {
                return haniChushutsubiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("範囲抽出日区分"));
    }
}
