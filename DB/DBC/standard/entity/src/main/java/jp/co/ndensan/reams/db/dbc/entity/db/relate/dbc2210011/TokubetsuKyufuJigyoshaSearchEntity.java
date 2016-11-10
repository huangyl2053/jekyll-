/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc2210011;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3065ShichosonTokubetsuKyufuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3066ShichosonTokubetuKyufuServiceEntity;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 市町村特別給付・サービス事業者のentityクラスです。
 *
 * @reamsid_L DBC-3430-010 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuKyufuJigyoshaSearchEntity extends DbTableEntityBase<TokubetsuKyufuJigyoshaSearchEntity> implements IDbAccessable {

    private DbT3065ShichosonTokubetsuKyufuJigyoshaEntity 事業者;
    private DbT3066ShichosonTokubetuKyufuServiceEntity サービス;
}
