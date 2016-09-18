/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 振込データ作成_エラー区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 x_lilh
 */
public enum FurikomiDataSakusei_ErrorKubun {

    /**
     * コード:1 名称:振込データなし 略称:定義なし
     */
    振込データなし("1", "振込データなし"),
    /**
     * コード:2 名称:被保険者宛名情報取得 略称:定義なし
     */
    被保険者宛名情報取得("2", "被保険者宛名情報取得"),
    /**
     * コード:2 名称:一覧表データなし 略称:定義なし
     */
    一覧表データなし("2", "一覧表データなし");

    private final RString code;
    private final RString fullName;

    private FurikomiDataSakusei_ErrorKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 振込データ作成_エラー区分のコードを返します。
     *
     * @return 振込データ作成_エラー区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 振込データ作成_エラー区分の名称を返します。
     *
     * @return 振込データ作成_エラー区分の名称
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
        if (FurikomiDataSakusei_ErrorKubun.振込データなし.getコード().contains(code)) {
            return new RString("振込データ作成");
        } else if ((FurikomiDataSakusei_ErrorKubun.被保険者宛名情報取得.getコード().contains(code))) {
            return new RString("被保険者・宛名情報取得");
        } else if (FurikomiDataSakusei_ErrorKubun.一覧表データなし.getコード().contains(code)) {
            return new RString("振込明細一覧表作成");
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
        if (FurikomiDataSakusei_ErrorKubun.振込データなし.getコード().contains(code)) {
            return new RString("振込対象データがありません。");
        } else if ((FurikomiDataSakusei_ErrorKubun.被保険者宛名情報取得.getコード().contains(code))) {
            return new RString("該当データがありません。");
        } else if (FurikomiDataSakusei_ErrorKubun.一覧表データなし.getコード().contains(code)) {
            return new RString("条件に該当するデータがありません。");
        }
        return null;
    }

    /**
     * 振込データ作成_エラー区分のコードと一致する内容を探します。
     *
     * @param code 振込データ作成_エラー区分のコード
     * @return {@code code} に対応する振込データ作成_エラー区分名称
     */
    public static FurikomiDataSakusei_ErrorKubun toValue(RString code) {

        for (FurikomiDataSakusei_ErrorKubun furikomiTani : FurikomiDataSakusei_ErrorKubun.values()) {
            if (furikomiTani.code.equals(code)) {
                return furikomiTani;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("振込データ作成_エラー区分"));
    }
}
