/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 給付実績居宅サービス情報の、請求金額に関連する情報です。
 *
 * @author n8178 城間篤人
 */
public class KyotakuServiceSeikyuKingakuJoho {

    private final int 単位数;
    private final int 回数;
    private final int サービス単位数;
    private final int サービス単位数合計;
    private final int 請求金額;

    public KyotakuServiceSeikyuKingakuJoho(int 単位数, int 回数, int サービス単位数,
            int サービス単位数合計, int 請求金額) throws IllegalArgumentException {
        check0未満(単位数, UrErrorMessages.項目に対する制約.getMessage().replace("単位数", "0以上"));
        check0未満(回数, UrErrorMessages.項目に対する制約.getMessage().replace("単位数", "0以上"));
        check0未満(サービス単位数, UrErrorMessages.項目に対する制約.getMessage().replace("単位数", "0以上"));
        check0未満(サービス単位数合計, UrErrorMessages.項目に対する制約.getMessage().replace("単位数", "0以上"));
        check0未満(請求金額, UrErrorMessages.項目に対する制約.getMessage().replace("単位数", "0以上"));

        this.単位数 = 単位数;
        this.回数 = 回数;
        this.サービス単位数 = サービス単位数;
        this.サービス単位数合計 = サービス単位数合計;
        this.請求金額 = 請求金額;
    }

    private int check0未満(int チェック項目, Message エラーメッセージ) {
        if (チェック項目 < 0) {
            throw new IllegalArgumentException(エラーメッセージ.getMessage());
        }
        return チェック項目;
    }

    /**
     * 単位数を取得します。
     *
     * @return 単位数
     */
    public int get単位数() {
        return 単位数;
    }

    /**
     * 回数を取得します。
     *
     * @return 回数
     */
    public int get回数() {
        return 回数;
    }

    /**
     * サービス単位数を取得します。
     *
     * @return サービス単位数
     */
    public int getサービス単位数() {
        return サービス単位数;
    }

    /**
     * サービス単位数の合計を取得します。
     *
     * @return サービス単位数合計
     */
    public int getサービス単位数合計() {
        return サービス単位数合計;
    }

    /**
     * 請求金額を取得します。
     *
     * @return 請求金額
     */
    public int get請求金額() {
        return 請求金額;
    }

}
