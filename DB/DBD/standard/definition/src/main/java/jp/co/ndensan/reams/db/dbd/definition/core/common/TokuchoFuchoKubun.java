package jp.co.ndensan.reams.db.dbd.definition.core.common;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴普徴区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum TokuchoFuchoKubun {

    /**
     * コード:※1 名称:特別徴収 略称:定義なし 略称:特徴
     */
    特別徴収("1", "特別徴収", "特徴"),
    /**
     * コード:※2 名称:普通徴収 略称:定義なし 略称:普徴
     */
    普通徴収("2", "普通徴収", "普徴");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private TokuchoFuchoKubun(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 特徴普徴区分のコードを返します。
     *
     * @return 特徴普徴区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特徴普徴区分の名称を返します。
     *
     * @return 特徴普徴区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特徴普徴区分の略称を返します。
     *
     * @return 特徴普徴区分の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 特徴普徴区分のコードと一致する内容を探します。
     *
     * @param code 特徴普徴区分のコード
     * @return {@code code} に対応する特徴普徴区分
     */
    public static TokuchoFuchoKubun toValue(RString code) {
        for (TokuchoFuchoKubun tokuchoFuchoKubun : TokuchoFuchoKubun.values()) {
            if (tokuchoFuchoKubun.code.equals(code)) {
                return tokuchoFuchoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特徴普徴区分"));
    }
}
