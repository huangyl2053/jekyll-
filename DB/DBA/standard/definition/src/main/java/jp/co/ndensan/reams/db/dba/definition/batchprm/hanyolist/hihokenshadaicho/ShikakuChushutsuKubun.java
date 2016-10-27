package jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格抽出区分を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 wangchao
 */
public enum ShikakuChushutsuKubun {

    /**
     * コード:1 名称:資格取得者のみ 略称:資格取得者のみ
     */
    資格取得者のみ("1", "資格取得者のみ", "資格取得者のみ"),
    /**
     * コード:2 名称:資格喪失者のみ 略称:資格喪失者のみ
     */
    資格喪失者のみ("2", "資格喪失者のみ", "資格喪失者のみ"),
    /**
     * コード:0 名称:両方 略称:両方
     */
    両方("0", "両方", "両方");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private ShikakuChushutsuKubun(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 資格抽出区分のコードを返します。
     *
     * @return 資格抽出区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 資格抽出区分の名称を返します。
     *
     * @return 資格抽出区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 資格抽出区分の略称を返します。
     *
     * @return 資格抽出区分の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 資格抽出区分のコードと一致する内容を探します。
     *
     * @param code 資格抽出区分のコード
     * @return {@code code} に対応する資格抽出区分
     */
    public static ShikakuChushutsuKubun toValue(RString code) {
        for (ShikakuChushutsuKubun shikakuChushutsuKubun : ShikakuChushutsuKubun.values()) {
            if (shikakuChushutsuKubun.code.equals(code)) {
                return shikakuChushutsuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("資格抽出区分"));
    }
}
