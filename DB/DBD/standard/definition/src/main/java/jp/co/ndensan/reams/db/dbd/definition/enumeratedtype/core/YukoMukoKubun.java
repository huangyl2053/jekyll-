package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 有効無効区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum YukoMukoKubun {

    /**
     * コード:0 名称:初期値（申請中の場合） 略称:定義なし
     */
    初期値_申請中の場合("0", "初期値（申請中の場合）"),
    /**
     * コード:1 名称:有効 略称:定義なし
     */
    有効("1", "有効"),
    /**
     * コード:2 名称:無効 略称:定義なし
     */
    無効("2", "無効");

    private final RString code;
    private final RString fullName;

    private YukoMukoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 有効無効区分のコードを返します。
     *
     * @return 有効無効区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 有効無効区分の名称を返します。
     *
     * @return 有効無効区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 有効無効区分のコードと一致する内容を探します。
     *
     * @param code 有効無効区分のコード
     * @return {@code code} に対応する有効無効区分
     */
    public static YukoMukoKubun toValue(RString code) {

        for (YukoMukoKubun yukoMukoKubun : YukoMukoKubun.values()) {
            if (yukoMukoKubun.code.equals(code)) {
                return yukoMukoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("有効無効区分"));
    }
}
