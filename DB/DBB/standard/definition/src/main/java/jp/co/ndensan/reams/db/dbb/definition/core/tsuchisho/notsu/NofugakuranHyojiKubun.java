package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 納付額欄表示区分を表す列挙型です。
 *
 * @reamsid_L DBB-9999-023 liangbc
 */
public enum NofugakuranHyojiKubun {

    /**
     * コード:1 名称:「口座振替」を印字する 略称:定義なし
     */
    口座振替を印字する("1", "「口座振替」を印字する"),
    /**
     * コード:2 名称:空白を印字する 略称:定義なし
     */
    空白を印字する("2", "「　　　　」を印字する"),
    /**
     * コード:3 名称:マスクを印字する 略称:定義なし
     */
    マスクを印字する("3", "「＊＊＊＊」を印字する"),
    /**
     * コード:4 名称:金額出力 略称:定義なし
     */
    金額出力("4", "金額出力");

    private final RString code;
    private final RString fullName;

    private NofugakuranHyojiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 納付額欄表示区分のコードを返します。
     *
     * @return 納付額欄表示区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 納付額欄表示区分の名称を返します。
     *
     * @return 納付額欄表示区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 納付額欄表示区分のコードと一致する内容を探します。
     *
     * @param code 納付額欄表示区分のコード
     * @return {@code code} に対応する納付額欄表示区分
     */
    public static NofugakuranHyojiKubun toValue(RString code) {
        for (NofugakuranHyojiKubun nofugakuranHyojiKubun : NofugakuranHyojiKubun.values()) {
            if (nofugakuranHyojiKubun.code.equals(code)) {
                return nofugakuranHyojiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("納付額欄表示区分"));
    }
}
