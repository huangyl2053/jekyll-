/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.uz.uza.lang.Range;

/**
 * 給付実績のキー情報を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class KyufuJissekiKeyInfo {

    private final KaigoHihokenshaNo 被保番号;
    private final Range<ServiceTeikyoYM> サービス提供期間;
    private final InputShikibetsuNo 入力識別番号;
    private final ServiceShuruiCode サービス種類コード;
    private final ServiceTeikyoYM サービス提供年月;

    /**
     * インスタンスを生成します。
     *
     * @param 被保番号 被保番号
     * @param サービス提供期間 サービス提供期間
     * @param 入力識別番号 入力識別番号
     * @param サービス種類コード サービス種類コード
     * @param サービス提供年月 サービス提供年月
     */
    public KyufuJissekiKeyInfo(
            KaigoHihokenshaNo 被保番号,
            Range<ServiceTeikyoYM> サービス提供期間,
            InputShikibetsuNo 入力識別番号,
            ServiceShuruiCode サービス種類コード,
            ServiceTeikyoYM サービス提供年月) {
        this.被保番号 = 被保番号;
        this.サービス提供期間 = サービス提供期間;
        this.入力識別番号 = 入力識別番号;
        this.サービス種類コード = サービス種類コード;
        this.サービス提供年月 = サービス提供年月;
    }

    /**
     * 被保番号を返します。
     *
     * @return 被保番号
     */
    public KaigoHihokenshaNo get被保番号() {
        return 被保番号;
    }

    /**
     * サービス提供期間を返します。
     *
     * @return サービス提供期間
     */
    public Range<ServiceTeikyoYM> getサービス提供期間() {
        return サービス提供期間;
    }

    /**
     * 入力識別番号を返します。
     *
     * @return 入力識別番号
     */
    public InputShikibetsuNo get入力識別番号() {
        return 入力識別番号;
    }

    /**
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return サービス種類コード;
    }

    /**
     * サービス提供年月を返します。
     *
     * @return サービス提供年月
     */
    public ServiceTeikyoYM getサービス提供年月() {
        return サービス提供年月;
    }
}
