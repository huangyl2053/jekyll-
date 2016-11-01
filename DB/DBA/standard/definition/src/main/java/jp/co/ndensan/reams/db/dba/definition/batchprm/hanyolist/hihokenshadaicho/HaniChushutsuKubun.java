package jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 範囲抽出日区分を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 wangchao
 */
public enum HaniChushutsuKubun {

    /**
     * コード:1 名称:取得日 略称:取得日
     */
    取得日("1", "取得日", "取得日"),
    /**
     * コード:2 名称:取得届出日 略称:取得届出日
     */
    取得届出日("2", "取得届出日", "取得届出日"),
    /**
     * コード:4 名称:喪失日 略称:喪失日
     */
    喪失日("4", "喪失日", "喪失日"),
    /**
     * コード:5 名称:喪失届出日 略称:喪失届出日
     */
    喪失届出日("5", "喪失届出日", "喪失届出日");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private HaniChushutsuKubun(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
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
     * 範囲抽出日区分の略称を返します。
     *
     * @return 範囲抽出日区分の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 範囲抽出日区分のコードと一致する内容を探します。
     *
     * @param code 範囲抽出日区分のコード
     * @return {@code code} に対応する範囲抽出日区分
     */
    public static HaniChushutsuKubun toValue(RString code) {
        for (HaniChushutsuKubun haniChushutsuKubun : HaniChushutsuKubun.values()) {
            if (haniChushutsuKubun.code.equals(code)) {
                return haniChushutsuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("範囲抽出日区分"));
    }
}
