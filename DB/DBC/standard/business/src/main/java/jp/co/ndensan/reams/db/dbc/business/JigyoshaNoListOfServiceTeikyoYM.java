/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;

/**
 * サービス提供年月に対応する事業所番号のリストを保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class JigyoshaNoListOfServiceTeikyoYM {

    private final ServiceTeikyoYM サービス提供年月;
    private final List<JigyoshaNo> 事業所番号リスト;

    /**
     * インスタンスを生成します。
     *
     * @param サービス提供年月 サービス提供年月
     * @param 事業所番号リスト 事業所番号リスト
     */
    public JigyoshaNoListOfServiceTeikyoYM(
            ServiceTeikyoYM サービス提供年月,
            List<JigyoshaNo> 事業所番号リスト) {
        this.サービス提供年月 = サービス提供年月;
        this.事業所番号リスト = 事業所番号リスト;
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
     * 事業所番号リストを返します。
     *
     * @return 事業所番号リスト
     */
    public List<JigyoshaNo> get事業所番号リスト() {
        return 事業所番号リスト;
    }
}
