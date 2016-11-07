/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.tokubetsukyufujigyoshasearch;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShichosonTokubetsuKyufuJigyosha;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc2210011.TokubetsuKyufuJigyoshaSearchEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author liuyl
 */
public class TokubetsuKyufuJigyoshaSearchBusiness implements Serializable {

    private TokubetsuKyufuJigyoshaSearchEntity entity;

    public TokubetsuKyufuJigyoshaSearchBusiness(TokubetsuKyufuJigyoshaSearchEntity entity) {
        this.entity = entity;
    }

    public ShichosonTokubetsuKyufuJigyosha get事業者() {
        return new ShichosonTokubetsuKyufuJigyosha(entity.get事業者());
    }

    public RString get市町村特別給付用サービス名() {
        return entity.get市町村特別給付用サービス名();
    }
}
