package jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 喪失区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum SoshitsuKubun {

    /**
     * コード:1 名称:資格判定なし 略称:定義なし
     */
    資格判定なし("1", "資格判定なし"),
    /**
     * コード:2 名称:資格取得者のみ 略称:定義なし
     */
    資格取得者のみ("2", "資格取得者のみ"),
    /**
     * コード:3 名称:資格喪失者のみ 略称:定義なし
     */
    資格喪失者のみ("3", "資格喪失者のみ");

    private final RString code;
    private final RString fullName;

    private SoshitsuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 喪失区分のコードを返します。
     *
     * @return 喪失区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 喪失区分の名称を返します。
     *
     * @return 喪失区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 喪失区分のコードと一致する内容を探します。
     *
     * @param code 喪失区分のコード
     * @return {@code code} に対応する喪失区分
     */
    public static SoshitsuKubun toValue(RString code) {
        for (SoshitsuKubun soshitsuKubun : SoshitsuKubun.values()) {
            if (soshitsuKubun.code.equals(code)) {
                return soshitsuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("対応する喪失区分"));
    }
}
