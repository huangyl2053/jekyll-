package jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連情報取込エラー区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 zhangrui
 */
public enum KokuhorenJoho_TorikomiErrorKubun {

    /**
     * コード:01 名称:キー項目不一致 略称:定義なし
     */
    キー項目不一致("01", "キー項目不一致"),
    /**
     * コード:02 名称:レコード構成不正 略称:定義なし
     */
    レコード構成不正("02", "レコード構成不正"),
    /**
     * コード:03 名称:必須レコードなし 略称:定義なし
     */
    必須レコードなし("03", "必須レコードなし"),
    /**
     * コード:04 名称:複数レコード不可 略称:定義なし
     */
    複数レコード不可("04", "複数レコード不可"),
    /**
     * コード:05 名称:名称取得エラー 略称:定義なし
     */
    名称取得エラー("05", "名称取得エラー"),
    /**
     * コード:06 名称:データ不正_通知書データのみ 略称:定義なし
     */
    データ不正_通知書データのみ("06", "データ不正_通知書データのみ"),
    /**
     * コード:07 名称:データ不正_一覧データのみ 略称:定義なし
     */
    データ不正_一覧データのみ("07", "データ不正_一覧データのみ"),
    /**
     * コード:10 名称:新旧被保険者番号変換エラー 略称:定義なし
     */
    新旧被保険者番号変換エラー("10", "新旧被保険者番号変換エラー"),
    /**
     * コード:20 名称:被保険者情報取得エラー 略称:定義なし
     */
    被保険者情報取得エラー("20", "被保険者情報取得エラー"),
    /**
     * コード:30 名称:宛名取得エラー 略称:定義なし
     */
    宛名取得エラー("30", "宛名取得エラー"),
    /**
     * コード:40 名称:世帯集約番号取得エラー 略称:定義なし
     */
    世帯集約番号取得エラー("40", "世帯集約番号取得エラー"),
    /**
     * コード:41 名称:証記載保険者番号取得エラー 略称:定義なし
     */
    証記載保険者番号取得エラー("41", "証記載保険者番号取得エラー"),
    /**
     * コード:60 名称:再処理不可 略称:定義なし
     */
    再処理不可("60", "再処理不可"),
    /**
     * コード:61 名称:再処理データなし 略称:定義なし
     */
    再処理データなし("61", "再処理データなし"),
    /**
     * コード:62 名称:関連データなし 略称:定義なし
     */
    関連データなし("62", "関連データなし"),
    /**
     * コード:63 名称:給付実績情報内容不一致 略称:定義なし
     */
    給付実績情報内容不一致("63", "給付実績情報内容不一致"),
    /**
     * コード:64 名称:更新対象データなし 略称:定義なし
     */
    更新対象データなし("64", "更新対象データなし"),
    /**
     * コード:99 名称:取込対象データなし 略称:定義なし
     */
    取込対象データなし("99", "取込対象データなし");

    private final RString code;
    private final RString fullName;

    private KokuhorenJoho_TorikomiErrorKubun(String code, String fullName) {
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
        if (KokuhorenJoho_TorikomiErrorKubun.新旧被保険者番号変換エラー.getコード().contains(code)) {
            return new RString("新旧被保険者番号変換");
        } else if ((KokuhorenJoho_TorikomiErrorKubun.被保険者情報取得エラー.getコード().contains(code))
                || (KokuhorenJoho_TorikomiErrorKubun.宛名取得エラー.getコード().contains(code))) {
            return new RString("被保険者・宛名情報取得");
        } else if (KokuhorenJoho_TorikomiErrorKubun.世帯集約番号取得エラー.getコード().contains(code)) {
            return new RString("被保険者・世帯集約番号取得");
        } else if ((KokuhorenJoho_TorikomiErrorKubun.再処理不可.getコード().contains(code))
                || (KokuhorenJoho_TorikomiErrorKubun.再処理データなし.getコード().contains(code))
                || (KokuhorenJoho_TorikomiErrorKubun.関連データなし.getコード().contains(code))
                || (KokuhorenJoho_TorikomiErrorKubun.取込対象データなし.getコード().contains(code))
                || (KokuhorenJoho_TorikomiErrorKubun.給付実績情報内容不一致.getコード().contains(code))
                || (KokuhorenJoho_TorikomiErrorKubun.更新対象データなし.getコード().contains(code))) {
            return new RString("DB登録");
        } else if (KokuhorenJoho_TorikomiErrorKubun.証記載保険者番号取得エラー.getコード().contains(code)) {
            return new RString("証記載保険者番号取得");
        } else if (KokuhorenJoho_TorikomiErrorKubun.キー項目不一致.getコード().contains(code)
                || KokuhorenJoho_TorikomiErrorKubun.レコード構成不正.getコード().contains(code)
                || KokuhorenJoho_TorikomiErrorKubun.必須レコードなし.getコード().contains(code)
                || KokuhorenJoho_TorikomiErrorKubun.複数レコード不可.getコード().contains(code)
                || KokuhorenJoho_TorikomiErrorKubun.名称取得エラー.getコード().contains(code)
                || KokuhorenJoho_TorikomiErrorKubun.データ不正_通知書データのみ.getコード().contains(code)
                || KokuhorenJoho_TorikomiErrorKubun.データ不正_一覧データのみ.getコード().contains(code)) {
            return new RString("CSVファイル取込");
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
        if (KokuhorenJoho_TorikomiErrorKubun.新旧被保険者番号変換エラー.getコード().contains(code)) {
            return new RString("新被保険者番号に変換できません。");
        } else if ((KokuhorenJoho_TorikomiErrorKubun.被保険者情報取得エラー.getコード().contains(code))) {
            return new RString("被保険者台帳が存在しません。");
        } else if (KokuhorenJoho_TorikomiErrorKubun.宛名取得エラー.getコード().contains(code)) {
            return new RString("宛名が存在しません。");
        } else if (KokuhorenJoho_TorikomiErrorKubun.世帯集約番号取得エラー.getコード().contains(code)) {
            return new RString("世帯集約番号の取得ができません。");
        } else if (KokuhorenJoho_TorikomiErrorKubun.再処理不可.getコード().contains(code)) {
            return new RString("関連データが登録済のため再処理できません。");
        } else if (KokuhorenJoho_TorikomiErrorKubun.再処理データなし.getコード().contains(code)) {
            return new RString("再処理対象ファイルにデータが存在しません。");
        } else if (KokuhorenJoho_TorikomiErrorKubun.関連データなし.getコード().contains(code)) {
            return new RString("関連データが存在しません。");
        } else if (KokuhorenJoho_TorikomiErrorKubun.取込対象データなし.getコード().contains(code)) {
            return new RString("取り込むデータがありません。");
        } else if (KokuhorenJoho_TorikomiErrorKubun.キー項目不一致.getコード().contains(code)) {
            return new RString("キー項目が不一致です。");
        } else if (KokuhorenJoho_TorikomiErrorKubun.レコード構成不正.getコード().contains(code)) {
            return new RString("レコード構成が不正です。（不要レコード存在）");
        } else if (KokuhorenJoho_TorikomiErrorKubun.必須レコードなし.getコード().contains(code)) {
            return new RString("必須レコードが存在しません。");
        } else if (KokuhorenJoho_TorikomiErrorKubun.複数レコード不可.getコード().contains(code)) {
            return new RString("レコード構成が不正です。（複数レコード不可）");
        } else if (KokuhorenJoho_TorikomiErrorKubun.名称取得エラー.getコード().contains(code)) {
            return new RString("名称が取得できません。");
        } else if (KokuhorenJoho_TorikomiErrorKubun.データ不正_通知書データのみ.getコード().contains(code)) {
            return new RString("データが不正です。通知書データしかありません。");
        } else if (KokuhorenJoho_TorikomiErrorKubun.データ不正_一覧データのみ.getコード().contains(code)) {
            return new RString("データが不正です。一覧データしかありません。");
        } else if (KokuhorenJoho_TorikomiErrorKubun.証記載保険者番号取得エラー.getコード().contains(code)) {
            return new RString("証記載保険者番号の取得ができません。");
        } else if (KokuhorenJoho_TorikomiErrorKubun.給付実績情報内容不一致.getコード().contains(code)) {
            return new RString("返却元の保険者保有給付実績情報と内容が一致しません。");
        } else if (KokuhorenJoho_TorikomiErrorKubun.更新対象データなし.getコード().contains(code)) {
            return new RString("更新対象のデータが存在しません。");
        }
        return null;
    }

    /**
     * 国保連情報取込エラー区分のコードと一致する内容を探します。
     *
     * @param code 国保連情報取込エラー区分のコード
     * @return {@code code} に対応する国保連情報取込エラー区分
     */
    public static KokuhorenJoho_TorikomiErrorKubun toValue(RString code) {
        for (KokuhorenJoho_TorikomiErrorKubun errorKubun : KokuhorenJoho_TorikomiErrorKubun.values()) {
            if (errorKubun.code.equals(code)) {
                return errorKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("国保連情報取込エラー区分"));
    }
}
