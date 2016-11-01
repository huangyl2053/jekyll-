/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc2210011;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3065ShichosonTokubetsuKyufuJigyoshaEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author liuyl
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuKyufuJigyoshaSearchEntity {

    private DbT3065ShichosonTokubetsuKyufuJigyoshaEntity 事業者;
    private RString 市町村特別給付用サービス名;
}
