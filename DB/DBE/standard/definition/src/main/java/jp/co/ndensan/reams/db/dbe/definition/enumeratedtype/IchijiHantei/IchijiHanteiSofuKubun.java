package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHantei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一次判定結果送付区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum IchijiHanteiSofuKubun {

    /**
     * コード:0 名称:未送付 略称:定義なし
     */
    未送付("0", "未送付"),
    /**
     * コード:1 名称:送付済 略称:定義なし
     */
    送付済("1", "送付済");

    private final RString code;
    private final RString fullName;

    private IchijiHanteiSofuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 一次判定結果送付区分のコードを返します。
     *
     * @return 一次判定結果送付区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 一次判定結果送付区分の名称を返します。
     *
     * @return 一次判定結果送付区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 一次判定結果送付区分のコードと一致する内容を探します。
     *
     * @param code 一次判定結果送付区分のコード
     * @return {@code code} に対応する一次判定結果送付区分
     */
    public static IchijiHanteiSofuKubun toValue(RString code) {

        for (IchijiHanteiSofuKubun ichijiHanteiSofuKubun : IchijiHanteiSofuKubun.values()) {
            if (ichijiHanteiSofuKubun.code.equals(code)) {
                return ichijiHanteiSofuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("一次判定結果送付区分"));
    }
}
