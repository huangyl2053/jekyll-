package jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連情報取込エラー区分を表す列挙型です。
 *
 * @reamsid_L DBC-0980-550 zhangrui
 */
public enum KokuhorenJoho_TorikomiErrorKubun {

    /**
     * コード:10 名称:新旧被保険者番号変換エラー 略称:定義なし
     */
    新旧被保険者番号変換エラー("10", "新旧被保険者番号変換", "新被保険者番号に変換できません。"),
    /**
     * コード:20 名称:被保険者情報取得エラー 略称:定義なし
     */
    被保険者情報取得エラー("20", "被保険者・宛名情報取得", "被保険者台帳が存在しません。"),
    /**
     * コード:30 名称:宛名取得エラー 略称:定義なし
     */
    宛名取得エラー("30", "被保険者・宛名情報取得", "宛名が存在しません。"),
    /**
     * コード:40 名称:世帯集約番号取得エラー 略称:定義なし
     */
    世帯集約番号取得エラー("40", "世帯集約番号取得", "世帯集約番号の取得ができません。"),
    /**
     * コード:60 名称:再処理不可 略称:定義なし
     */
    再処理不可("60", "DB登録", "関連データが登録済のため再処理できません。"),
    /**
     * コード:61 名称:再処理データなし 略称:定義なし
     */
    再処理データなし("61", "DB登録", "再処理対象ファイルにデータが存在しません。"),
    /**
     * コード:62 名称:関連データなし 略称:定義なし
     */
    関連データなし("62", "DB登録", "関連データが存在しません。"),
    /**
     * コード:99 名称:取込対象データなし 略称:定義なし
     */
    取込対象データなし("99", "DB登録", "取り込むデータがありません。");
    private final RString コード;
    private final RString 処理名;
    private final RString エラーメッセージ;

    private KokuhorenJoho_TorikomiErrorKubun(String code, String 処理名, String エラーメッセージ) {
        this.コード = new RString(code);
        this.処理名 = new RString(処理名);
        this.エラーメッセージ = new RString(エラーメッセージ);
    }

    /**
     * コードを取ります
     *
     * @return コード
     */
    public RString getコード() {
        return コード;
    }

    /**
     * 処理名を取ります
     *
     * @return 処理名
     */
    public RString get処理名() {
        return 処理名;
    }

    /**
     * エラーメッセージを取ります
     *
     * @return エラーメッセージ
     */
    public RString getエラーメッセージ() {
        return エラーメッセージ;
    }

    /**
     * 国保連情報取込エラー区分のコードと一致する内容を探します。
     *
     * @param code 国保連情報取込エラー区分のコード
     * @return {@code code} に対応する国保連情報取込エラー区分
     */
    public static KokuhorenJoho_TorikomiErrorKubun toValue(RString code) {
        for (KokuhorenJoho_TorikomiErrorKubun errorKubun : KokuhorenJoho_TorikomiErrorKubun.values()) {
            if (errorKubun.コード.equals(code)) {
                return errorKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("国保連情報取込エラー区分"));
    }

}
