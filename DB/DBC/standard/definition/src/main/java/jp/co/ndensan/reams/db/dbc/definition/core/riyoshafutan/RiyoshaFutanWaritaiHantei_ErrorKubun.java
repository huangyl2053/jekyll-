/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.riyoshafutan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用者負担割合判定_エラー区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 yuanzhenxia
 */
public enum RiyoshaFutanWaritaiHantei_ErrorKubun {

    /**
     * コード:01 名称:受給者_被保険者台帳取得 略称:定義なし
     */
    受給者_被保険者台帳取得("01", "受給者_被保険者台帳取得"),
    /**
     * コード:02 名称:受給者_宛名取得 略称:定義なし
     */
    受給者_宛名取得("02", "受給者_宛名取得"),
    /**
     * コード:03 名称:総合事業対象者_被保険者台帳取得 略称:定義なし
     */
    総合事業対象者_被保険者台帳取得("03", "総合事業対象者_被保険者台帳取得"),
    /**
     * コード:04 名称:総合事業対象者_宛名取得 略称:定義なし
     */
    総合事業対象者_宛名取得("04", "総合事業対象者_宛名取得"),
    /**
     * コード:05 名称:負担割合判定一覧作成 略称:定義なし
     */
    負担割合判定一覧作成("05", "負担割合判定一覧作成");

    private final RString code;
    private final RString fullName;

    private RiyoshaFutanWaritaiHantei_ErrorKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 利用者負担割合判定_エラー区分のコードを返します。
     *
     * @return 利用者負担割合判定_エラー区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 利用者負担割合判定_エラー区分の名称を返します。
     *
     * @return 利用者負担割合判定_エラー区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 利用者負担割合判定_エラー区分のコードと一致する内容を探します。
     *
     * @param code 利用者負担割合判定_エラー区分のコード
     * @return {@code code} に対応する 利用者負担割合判定_エラー区分
     */
    public static RiyoshaFutanWaritaiHantei_ErrorKubun toValue(RString code) {

        for (RiyoshaFutanWaritaiHantei_ErrorKubun errorKubun : RiyoshaFutanWaritaiHantei_ErrorKubun.values()) {
            if (errorKubun.code.equals(code)) {
                return errorKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(" 利用者負担割合判定_エラー区分"));
    }

}
