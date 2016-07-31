/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 世帯員把握入力事業高額一時テーブルのエンティティクラスです。
 *
 * @reamsid_L DBC-2010-040 jiangzongyue
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TempSetaiinJigyoHaakuNyuryokuEntity
        extends DbTableEntityBase<TempSetaiinJigyoHaakuNyuryokuEntity> implements IDbAccessable {

    private HihokenshaNo hihokenshaNo;
    private ShikibetsuCode shikibetsuCode;
    private ShikibetsuCode setaiInshikibetsuCode;
    private FlexibleDate kijunYMD;
    private FlexibleYear shotokuNendo;
    private LasdecCode shichosonCode;
    private RString jushochiTokureiFlag;
}
