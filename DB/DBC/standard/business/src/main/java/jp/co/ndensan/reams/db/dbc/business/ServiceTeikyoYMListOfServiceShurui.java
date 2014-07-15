/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.List;

/**
 * サービス種類に対応するサービス提供年月のリストを保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ServiceTeikyoYMListOfServiceShurui {

    private final ServiceShurui サービス種類;
    private final List<JigyoshaNoListOfServiceTeikyoYM> サービス提供年月リスト;

    /**
     * インスタンスを生成します。
     *
     * @param サービス種類 サービス種類
     * @param サービス提供年月リスト サービス提供年月リスト
     */
    public ServiceTeikyoYMListOfServiceShurui(
            ServiceShurui サービス種類,
            List<JigyoshaNoListOfServiceTeikyoYM> サービス提供年月リスト) {
        this.サービス種類 = サービス種類;
        this.サービス提供年月リスト = サービス提供年月リスト;
    }

    /**
     * サービス種類を返します。
     *
     * @return サービス種類
     */
    public ServiceShurui getサービス種類() {
        return サービス種類;
    }

    /**
     * サービス提供年月リストを返します。
     *
     * @return サービス提供年月リスト
     */
    public List<JigyoshaNoListOfServiceTeikyoYM> getサービス提供年月リスト() {
        return サービス提供年月リスト;
    }
}
