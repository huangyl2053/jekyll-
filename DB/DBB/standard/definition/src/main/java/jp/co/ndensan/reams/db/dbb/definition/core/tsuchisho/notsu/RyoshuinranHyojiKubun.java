package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 領収印欄表示区分を表す列挙型です。
 *
 * @reamsid_L DBB-9999-023 liangbc
 */
public enum RyoshuinranHyojiKubun {

    /**
     * コード:1 名称:「口座振替」を印字する 略称:定義なし
     */
    口座振替を印字する("1", "「口座振替」を印字する"),
    /**
     * コード:2 名称:「　」を印字する 略称:定義なし
     */
    空白を印字する("2", "「　　　　」を印字する");

    private final RString code;
    private final RString fullName;

    private RyoshuinranHyojiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 領収印欄表示区分のコードを返します。
     *
     * @return 領収印欄表示区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 領収印欄表示区分の名称を返します。
     *
     * @return 領収印欄表示区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 領収印欄表示区分のコードと一致する内容を探します。
     *
     * @param code 領収印欄表示区分のコード
     * @return {@code code} に対応する領収印欄表示区分
     */
    public static RyoshuinranHyojiKubun toValue(RString code) {
        for (RyoshuinranHyojiKubun ryoshuinranHyojiKubun : RyoshuinranHyojiKubun.values()) {
            if (ryoshuinranHyojiKubun.code.equals(code)) {
                return ryoshuinranHyojiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("領収印欄表示区分"));
    }
}
