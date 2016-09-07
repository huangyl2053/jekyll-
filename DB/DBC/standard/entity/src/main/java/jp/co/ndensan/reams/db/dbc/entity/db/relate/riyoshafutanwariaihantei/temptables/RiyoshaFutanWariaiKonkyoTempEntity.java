/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 利用者負担割合根拠Tempエンティティのクラスです。
 *
 * @reamsid_L DBC-5010-040 quxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RiyoshaFutanWariaiKonkyoTempEntity extends DbTableEntityBase<RiyoshaFutanWariaiKonkyoTempEntity> implements IDbAccessable {

    private FlexibleYear nendo;
    private HihokenshaNo hihokenshaNo;
    private Decimal rirekiNo;
    private int edaNo;
    private HihokenshaNo setaiinHihokenshaNo;
    private Decimal setaiinShotokuRirekiNo;

}
