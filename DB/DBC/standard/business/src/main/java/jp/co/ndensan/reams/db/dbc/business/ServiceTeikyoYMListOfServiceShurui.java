/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceShuruiCode;

/**
 * サービス種類に対応するサービス提供年月のリストを保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ServiceTeikyoYMListOfServiceShurui {

    private final ServiceShuruiCode サービス種類コード;
    private final List<JigyoshaNoListOfServiceTeikyoYM> サービス提供年月リスト;

    /**
     * インスタンスを生成します。
     *
     * @param サービス種類コード サービス種類コード
     * @param サービス提供年月リスト サービス提供年月リスト
     */
    public ServiceTeikyoYMListOfServiceShurui(
            ServiceShuruiCode サービス種類コード,
            List<JigyoshaNoListOfServiceTeikyoYM> サービス提供年月リスト) {
        this.サービス種類コード = サービス種類コード;
        this.サービス提供年月リスト = サービス提供年月リスト;
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
     * サービス提供年月リストを返します。
     *
     * @return サービス提供年月リスト
     */
    public List<JigyoshaNoListOfServiceTeikyoYM> getサービス提供年月リスト() {
        return サービス提供年月リスト;
    }
}
