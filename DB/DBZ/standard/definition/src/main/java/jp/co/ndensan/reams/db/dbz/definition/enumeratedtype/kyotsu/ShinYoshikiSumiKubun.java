package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 新様式印書済区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShinYoshikiSumiKubun {

    /**
     * コード:01 名称:新様式印書している 略称:定義なし
     */
    新様式印書している("01", "新様式印書している"),
    /**
     * コード:00 名称:新様式印書していない 略称:定義なし
     */
    新様式印書していない("00", "新様式印書していない");

    private final RString code;
    private final RString fullName;

    private ShinYoshikiSumiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 新様式印書済区分のコードを返します。
     *
     * @return 新様式印書済区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 新様式印書済区分の名称を返します。
     *
     * @return 新様式印書済区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 新様式印書済区分のコードと一致する内容を探します。
     *
     * @param code 新様式印書済区分のコード
     * @return {@code code} に対応する新様式印書済区分
     */
    public static ShinYoshikiSumiKubun toValue(RString code) {

        for (ShinYoshikiSumiKubun shinYoshikiSumiKubun : ShinYoshikiSumiKubun.values()) {
            if (shinYoshikiSumiKubun.code.equals(code)) {
                return shinYoshikiSumiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("新様式印書済区分"));
    }
}
