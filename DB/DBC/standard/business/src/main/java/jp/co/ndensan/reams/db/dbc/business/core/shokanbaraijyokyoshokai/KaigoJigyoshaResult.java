/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai;

import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyosha.KaigoJigyosha;

/**
 * 介護事業者情報取得の返却結果
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoJigyoshaResult {

    private KaigoJigyosha entity;

    /**
     * 介護事業者情報取得の返却結果を生成します
     *
     * @param entity KaigoJigyosha
     */
    public KaigoJigyoshaResult(KaigoJigyosha entity) {
        this.entity = entity;
    }
}
