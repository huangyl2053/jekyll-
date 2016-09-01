/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連情報作成エラー区分を表す列挙型です。
 *
 * @reamsid_L DBC-2460-011 jiangwenkai
 */
public enum KokuhorenJoho_SakuseiErrorKubun {

    /**
     * コード:01 名称:送付対象データなし 略称:定義なし
     */
    送付対象データなし("01", "送付対象データなし"),
    /**
     * コード:02 名称:名称取得エラー 略称:定義なし
     */
    名称取得エラー("02", "名称取得エラー"),
    /**
     * コード:03 名称:被保険者_宛名情報取得エラー 略称:定義なし
     */
    被保険者_宛名情報取得エラー("03", "被保険者_宛名情報取得エラー"),
    /**
     * コード:04 名称:証記載保険者番号取得エラー 略称:定義なし
     */
    証記載保険者番号取得エラー("04", "証記載保険者番号取得エラー"),
    /**
     * コード:05 名称:口座情報取得エラー 略称:定義なし
     */
    口座情報取得エラー("05", "口座情報取得エラー"),
    /**
     * コード:06 名称:明細情報取得エラー 略称:定義なし
     */
    明細情報取得エラー("06", "明細情報取得エラー");

    private final RString code;
    private final RString fullName;

    private KokuhorenJoho_SakuseiErrorKubun(String code, String fullName) {
        this.code = new RString(code);
        this.fullName = new RString(fullName);
    }

    /**
     * コードを取ります
     *
     * @return コード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 名称を取ります
     *
     * @return 名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 処理名を取ります
     *
     * @param code コード
     * @return 処理名
     */
    public static RString get処理名(RString code) {
        if (KokuhorenJoho_SakuseiErrorKubun.送付対象データなし.getコード().contains(code)) {
            return new RString("送付対象データ取得");
        } else if ((KokuhorenJoho_SakuseiErrorKubun.名称取得エラー.getコード().contains(code))) {
            return new RString("名称取得");
        } else if (KokuhorenJoho_SakuseiErrorKubun.被保険者_宛名情報取得エラー.getコード().contains(code)) {
            return new RString("被保険者・宛名情報取得");
        } else if ((KokuhorenJoho_SakuseiErrorKubun.証記載保険者番号取得エラー.getコード().contains(code))) {
            return new RString("証記載保険者番号取得");
        } else if (KokuhorenJoho_SakuseiErrorKubun.口座情報取得エラー.getコード().contains(code)) {
            return new RString("口座情報取得");
        } else if (KokuhorenJoho_SakuseiErrorKubun.明細情報取得エラー.getコード().contains(code)) {
            return new RString("送付対象データ取得");
        }
        return null;
    }

    /**
     * エラーメッセージを取ります
     *
     * @param code コード
     * @return エラーメッセージ
     */
    public static RString getエラーメッセージ(RString code) {
        if (KokuhorenJoho_SakuseiErrorKubun.送付対象データなし.getコード().contains(code)) {
            return new RString("送付するデータがありません。");
        } else if ((KokuhorenJoho_SakuseiErrorKubun.名称取得エラー.getコード().contains(code))) {
            return new RString("名称が取得できません。");
        } else if (KokuhorenJoho_SakuseiErrorKubun.被保険者_宛名情報取得エラー.getコード().contains(code)) {
            return new RString("該当データがありません。");
        } else if ((KokuhorenJoho_SakuseiErrorKubun.証記載保険者番号取得エラー.getコード().contains(code))) {
            return new RString("証記載保険者番号が取得できません。");
        } else if (KokuhorenJoho_SakuseiErrorKubun.口座情報取得エラー.getコード().contains(code)) {
            return new RString("該当データがありません。");
        } else if (KokuhorenJoho_SakuseiErrorKubun.明細情報取得エラー.getコード().contains(code)) {
            return new RString("明細データが取得できません。");
        }
        return null;
    }

    /**
     * 国保連情報作成エラー区分のコードと一致する内容を探します。
     *
     * @param code 国保連情報作成エラー区分のコード
     * @return {@code code} に対応する国保連情報作成エラー区分
     */
    public static KokuhorenJoho_SakuseiErrorKubun toValue(RString code) {
        for (KokuhorenJoho_SakuseiErrorKubun errorKubun : KokuhorenJoho_SakuseiErrorKubun.values()) {
            if (errorKubun.code.equals(code)) {
                return errorKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("国保連情報作成エラー区分"));
    }

}
