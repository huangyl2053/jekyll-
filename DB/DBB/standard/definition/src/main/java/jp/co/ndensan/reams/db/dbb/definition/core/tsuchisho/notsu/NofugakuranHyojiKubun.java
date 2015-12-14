package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 納付額欄表示区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum NofugakuranHyojiKubun {

    /**
     * コード:1 名称:口座振替を印字する 略称:「口座振替」を印字する
     */
    _口座振替_を印字する("1", "口座振替を印字する", "「口座振替」を印字する"),
    /**
     * コード:2 名称:空白を印字する 略称:「」を印字する
     */
    __を印字する("2", "空白を印字する", "「」を印字する"),
    /**
     * コード:3 名称:マスクを印字する 略称:「＊＊＊＊」を印字する
     */
    星印を印字する("3", "マスクを印字する", "「＊＊＊＊」を印字する"),
    /**
     * コード:4 名称:金額出力 略称:金額出力
     */
    金額出力("4", "金額出力", "金額出力");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private NofugakuranHyojiKubun(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
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
     * 納付額欄表示区分の略称を返します。
     *
     * @return 納付額欄表示区分の略称
     */
    public RString get略称() {
        return shortName;
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
