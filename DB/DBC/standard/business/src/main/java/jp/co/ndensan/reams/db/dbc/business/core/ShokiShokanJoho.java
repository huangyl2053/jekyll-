/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 初期の償還払決定情報です。
 *
 * @reamsid_L DBC-1030-180 zhuxj2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokiShokanJoho implements Serializable {

    private FlexibleYearMonth サービス提供年月;
    private RString 整理番号;
    private RString 画面モード;
    private HihokenshaNo 被保番号;
    private Decimal 前回支払金額合計;
    private RDate 決定日;
    private RString 支給区分;
    private RString 増減理由等;
    private RString 不支給理由等一;
    private RString 不支給理由等二;

    /**
     * インスタンスを生成します。
     *
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 画面モード 画面モード
     * @param 被保番号 被保番号
     * @param 前回支払金額合計 前回支払金額合計
     * @param 決定日 決定日
     * @param 支給区分 支給区分
     * @param 増減理由等 増減理由等
     * @param 不支給理由等一 不支給理由等一
     * @param 不支給理由等二 不支給理由等二
     */
    public ShokiShokanJoho(FlexibleYearMonth サービス提供年月, RString 整理番号, RString 画面モード, HihokenshaNo 被保番号, Decimal 前回支払金額合計,
            RDate 決定日, RString 支給区分, RString 増減理由等, RString 不支給理由等一, RString 不支給理由等二) {
        this.サービス提供年月 = サービス提供年月;
        this.整理番号 = 整理番号;
        this.画面モード = 画面モード;
        this.被保番号 = 被保番号;
        this.前回支払金額合計 = 前回支払金額合計;
        this.決定日 = 決定日;
        this.支給区分 = 支給区分;
        this.増減理由等 = 増減理由等;
        this.不支給理由等一 = 不支給理由等一;
        this.不支給理由等二 = 不支給理由等二;
    }
}
