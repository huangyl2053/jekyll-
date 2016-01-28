package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅/施設区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ZaitakuShisetsuKubun {

    /**
     * コード:1 名称:在宅 略称:定義なし
     */
    在宅("1", "在宅"),
    /**
     * コード:2 名称:施設 略称:定義なし
     */
    施設("2", "施設");

    private final RString code;
    private final RString fullName;

    private ZaitakuShisetsuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 在宅/施設区分のコードを返します。
     *
     * @return 在宅/施設区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅/施設区分の名称を返します。
     *
     * @return 在宅/施設区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅/施設区分のコードと一致する内容を探します。
     *
     * @param code 在宅/施設区分のコード
     * @return {@code code} に対応する在宅/施設区分
     */
    public static ZaitakuShisetsuKubun toValue(RString code) {

        for (ZaitakuShisetsuKubun zaitakuShisetsuKubun : ZaitakuShisetsuKubun.values()) {
            if (zaitakuShisetsuKubun.code.equals(code)) {
                return zaitakuShisetsuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅/施設区分"));
    }
}
