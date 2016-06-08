package jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 日付抽出区分を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 wangchao
 */
public enum HizukeChushutsuKubun {

    /**
     * コード:1 名称:直近 略称:定義なし
     */
    直近("1", "直近"),
    /**
     * コード:2 名称:基準日 略称:定義なし
     */
    基準日("2", "基準日"),
    /**
     * コード:3 名称:範囲 略称:定義なし
     */
    範囲("3", "範囲");

    private final RString code;
    private final RString fullName;

    private HizukeChushutsuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 日付抽出区分のコードを返します。
     *
     * @return 日付抽出区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 日付抽出区分の名称を返します。
     *
     * @return 日付抽出区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 日付抽出区分のコードと一致する内容を探します。
     *
     * @param code 日付抽出区分のコード
     * @return {@code code} に対応する日付抽出区分
     */
    public static HizukeChushutsuKubun toValue(RString code) {
        for (HizukeChushutsuKubun hizukeChushutsuKubun : HizukeChushutsuKubun.values()) {
            if (hizukeChushutsuKubun.code.equals(code)) {
                return hizukeChushutsuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("日付抽出区分"));
    }
}
