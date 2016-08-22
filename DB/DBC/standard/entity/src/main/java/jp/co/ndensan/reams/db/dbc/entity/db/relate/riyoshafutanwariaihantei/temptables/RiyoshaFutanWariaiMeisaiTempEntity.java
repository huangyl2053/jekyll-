/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 利用者負担割合明細Tempエンティティのクラスです。
 *
 * @reamsid_L DBC-4950-032 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RiyoshaFutanWariaiMeisaiTempEntity
        extends DbTableEntityBase<RiyoshaFutanWariaiMeisaiTempEntity> implements IDbAccessable {

    private FlexibleYear nendo;
    private HihokenshaNo hihokenshaNo;
    private int edaNo;
    private RString shikakuKubun;
    private RString futanWariaiKubun;
    private FlexibleDate yukoKaishiYMD;
    private FlexibleDate yukoShuryoYMD;
    private Decimal honninGoukeiShotokuGaku;
    private int setaiIchigouHihokenshaSu;
    private Decimal nenkinShunyuGoukei;
    private Decimal sonotanoGoukeiShotokuKingakuGoukei;
    private RString koseiRiyu;
    private SetaiCode setaiCd;
    private RString koseiJiyu;
    private RString hanteiKubun;
    private FlexibleDate ninteiYukoKaishiDate;
    private FlexibleDate jukyuKaishiYMD;
    private FlexibleDate jukyuHaishiYMD;
    private FlexibleDate atenaIdobi;
}
