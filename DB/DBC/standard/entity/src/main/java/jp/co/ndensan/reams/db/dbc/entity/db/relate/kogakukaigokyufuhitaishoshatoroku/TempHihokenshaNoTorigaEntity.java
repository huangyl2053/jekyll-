/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 給付実績中間高額一時テーブルのエンティティクラスです。
 *
 * @reamsid_L DBC-2010-040 huzongcheng
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TempHihokenshaNoTorigaEntity extends DbTableEntityBase<TempKyufujissekiTyukannEntity> implements IDbAccessable {

    private HihokenshaNo hiHokenshaNo;
}
