/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KyufuJissekiKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KyufuSakuseiKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.RecodeShubetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ToshiNo;

/**
 * 給付実績の詳細キー情報を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class KyufuJissekiDetailKeyInfo {

    private final KokanShikibetsuNo 交換情報識別番号;
    private final InputShikibetsuNo 入力識別番号;
    private final RecodeShubetsuCode レコード種別コード;
    private final ShoKisaiHokenshaNo 証記載保険者番号;
    private final KaigoHihokenshaNo 被保番号;
    private final ServiceTeikyoYM サービス提供年月;
    private final JigyoshaNo 事業所番号;
    private final KyufuSakuseiKubun 給付実績情報作成区分;
    private final KyufuJissekiKubun 給付実績区分;
    private final ToshiNo 通番;
    private final List<ServiceTeikyoYMListOfServiceShurui> 対象サービス種類リスト;

    /**
     * インスタンスを生成します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @param 入力識別番号 入力識別番号
     * @param レコード種別コード レコード種別コード
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保番号 被保番号
     * @param サービス提供年月 サービス提供年月
     * @param 事業所番号 事業所番号
     * @param 給付実績情報作成区分 給付実績情報作成区分
     * @param 給付実績区分 給付実績区分
     * @param 通番 通番
     * @param 対象サービス種類リスト 対象サービス種類リスト
     */
    public KyufuJissekiDetailKeyInfo(
            KokanShikibetsuNo 交換情報識別番号,
            InputShikibetsuNo 入力識別番号,
            RecodeShubetsuCode レコード種別コード,
            ShoKisaiHokenshaNo 証記載保険者番号,
            KaigoHihokenshaNo 被保番号,
            ServiceTeikyoYM サービス提供年月,
            JigyoshaNo 事業所番号,
            KyufuSakuseiKubun 給付実績情報作成区分,
            KyufuJissekiKubun 給付実績区分,
            ToshiNo 通番,
            List<ServiceTeikyoYMListOfServiceShurui> 対象サービス種類リスト) {
        this.交換情報識別番号 = 交換情報識別番号;
        this.入力識別番号 = 入力識別番号;
        this.レコード種別コード = レコード種別コード;
        this.証記載保険者番号 = 証記載保険者番号;
        this.被保番号 = 被保番号;
        this.サービス提供年月 = サービス提供年月;
        this.事業所番号 = 事業所番号;
        this.給付実績情報作成区分 = 給付実績情報作成区分;
        this.給付実績区分 = 給付実績区分;
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
     * レコード種別コードを返します。
     *
     * @return レコード種別コード
     */
    public RecodeShubetsuCode getレコード種別コード() {
        return レコード種別コード;
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
     * 給付実績情報作成区分を返します。
     *
     * @return 給付実績情報作成区分
     */
    public KyufuSakuseiKubun get給付実績情報作成区分() {
        return 給付実績情報作成区分;
    }

    /**
     * 給付実績区分を返します。
     *
     * @return 給付実績区分
     */
    public KyufuJissekiKubun get給付実績区分() {
        return 給付実績区分;
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
}
