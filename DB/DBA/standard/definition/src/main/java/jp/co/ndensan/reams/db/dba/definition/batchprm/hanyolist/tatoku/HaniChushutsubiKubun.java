package jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.tatoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 範囲抽出日区分を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 wangchao
 */
public enum HaniChushutsubiKubun {

    /**
     * コード:1 名称:適用日 略称:定義なし
     */
    適用日("1", "適用日"),
    /**
     * コード:2 名称:適用届出日 略称:定義なし
     */
    適用届出日("2", "適用届出日"),
    /**
     * コード:3 名称:解除日 略称:定義なし
     */
    解除日("3", "解除日"),
    /**
     * コード:4 名称:解除届出日 略称:定義なし
     */
    解除届出日("4", "解除届出日");

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
