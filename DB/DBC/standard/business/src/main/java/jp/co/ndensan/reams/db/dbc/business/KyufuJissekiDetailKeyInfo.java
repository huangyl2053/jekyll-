/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ToshiNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績の詳細キー情報を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class KyufuJissekiDetailKeyInfo {

    private final KokanShikibetsuNo 交換情報識別番号;
    private final InputShikibetsuNo 入力識別番号;
    private final ShoKisaiHokenshaNo 証記載保険者番号;
    private final KaigoHihokenshaNo 被保番号;
    private final ServiceTeikyoYM サービス提供年月;
    private final JigyoshaNo 事業所番号;
    private final ToshiNo 通番;
    private final List<ServiceTeikyoYMListOfServiceShurui> 対象サービス種類リスト;

    private static final RString NOT_SUPPORT = new RString("Not supported yet.");

    /**
     * インスタンスを生成します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @param 入力識別番号 入力識別番号
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保番号 被保番号
     * @param サービス提供年月 サービス提供年月
     * @param 事業所番号 事業所番号
     * @param 通番 通番
     * @param 対象サービス種類リスト 対象サービス種類リスト
     */
    public KyufuJissekiDetailKeyInfo(
            KokanShikibetsuNo 交換情報識別番号,
            InputShikibetsuNo 入力識別番号,
            ShoKisaiHokenshaNo 証記載保険者番号,
            KaigoHihokenshaNo 被保番号,
            ServiceTeikyoYM サービス提供年月,
            JigyoshaNo 事業所番号,
            ToshiNo 通番,
            List<ServiceTeikyoYMListOfServiceShurui> 対象サービス種類リスト) {
        this.交換情報識別番号 = 交換情報識別番号;
        this.入力識別番号 = 入力識別番号;
        this.証記載保険者番号 = 証記載保険者番号;
        this.被保番号 = 被保番号;
        this.サービス提供年月 = サービス提供年月;
        this.事業所番号 = 事業所番号;
        this.通番 = 通番;
        this.対象サービス種類リスト = 対象サービス種類リスト;
    }

    /**
     * 交換情報識別番号を返します。
     *
     * @return 交換情報識別番号
     */
    public KokanShikibetsuNo get交換情報識別番号() {
        return 交換情報識別番号;
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
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return 証記載保険者番号;
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
     * サービス提供年月を返します。
     *
     * @return サービス提供年月
     */
    public ServiceTeikyoYM getサービス提供年月() {
        return サービス提供年月;
    }

    /**
     * 事業所番号を返します。
     *
     * @return 事業所番号
     */
    public JigyoshaNo get事業所番号() {
        return 事業所番号;
    }

    /**
     * 通番を返します。
     *
     * @return 通番
     */
    public ToshiNo get通番() {
        return 通番;
    }

    /**
     * 対象サービス種類リストを返します。
     *
     * @return 対象サービス種類リスト
     */
    public List<ServiceTeikyoYMListOfServiceShurui> get対象サービス種類リスト() {
        return 対象サービス種類リスト;
    }

    /**
     * 前月の情報が存在するか判定する
     *
     * @return 存在する場合はtrueを返す
     */
    public boolean isPrevMonth() {
        throw new UnsupportedOperationException(NOT_SUPPORT.toString()); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 次月の情報が存在するか判定する
     *
     * @return 存在する場合はtrueを返す
     */
    public boolean isNextMonth() {
        throw new UnsupportedOperationException(NOT_SUPPORT.toString()); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 前事業所の情報が存在するか判定する
     *
     * @return 存在する場合はtrueを返す
     */
    public boolean isPrevJigyosha() {
        throw new UnsupportedOperationException(NOT_SUPPORT.toString()); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 次事業所の情報が存在するか判定する
     *
     * @return 存在する場合はtrueを返す
     */
    public boolean isNextJigyosha() {
        throw new UnsupportedOperationException(NOT_SUPPORT.toString()); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * キー情報を前月に設定する
     */
    public void prevMonth() {
        throw new UnsupportedOperationException(NOT_SUPPORT.toString()); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * キー情報を次月に設定する
     */
    public void nextMonth() {
        throw new UnsupportedOperationException(NOT_SUPPORT.toString()); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * キー情報を前事業所に設定する
     */
    public void prevJigyosha() {
        throw new UnsupportedOperationException(NOT_SUPPORT.toString()); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * キー情報を次事業所に設定する
     */
    public void nextJigyosha() {
        throw new UnsupportedOperationException(NOT_SUPPORT.toString()); //To change body of generated methods, choose Tools | Templates.
    }
}
