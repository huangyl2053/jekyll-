/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 今回利用者負担割合情報の一時表エンティティです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KonkaiRiyoshaFutanWariaiJohoTempEntity
        extends DbTableEntityBase<KonkaiRiyoshaFutanWariaiJohoTempEntity> implements IDbAccessable {

    private HihokenshaNo hihokenshaNo;
    private RString koseiJiyu;
    private RString nendo;
    private int edaNo;
    private RString futanWariaiKubun;
    private Decimal honinGokeishotokuKingaku;
    private Integer setaiIchigouHihokenshaSu;
    private FlexibleDate yukoKaishiYMD;
    private FlexibleDate yukoShuryoYMD;
    private Decimal nenkinShunyuGoukei;
    private Decimal sonotaGokeiShotokuKingaku;

}
