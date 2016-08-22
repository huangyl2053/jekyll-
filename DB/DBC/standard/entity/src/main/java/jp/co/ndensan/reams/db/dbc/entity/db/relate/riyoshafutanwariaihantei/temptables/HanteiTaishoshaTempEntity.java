/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 判定対象者Tempエンティティのクラスです。
 *
 * @reamsid_L DBC-4950-032 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanteiTaishoshaTempEntity
        extends DbTableEntityBase<HanteiTaishoshaTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private FlexibleYear taishoNendo;
    @TempTableColumnOrder(2)
    private FlexibleYearMonth taishoTsuki;
    @TempTableColumnOrder(3)
    private RString taishoKubun;
    @TempTableColumnOrder(4)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(5)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(6)
    private SetaiCode setaiCode;
    @TempTableColumnOrder(7)
    private RString idoShubetsu;
    @TempTableColumnOrder(8)
    private FlexibleDate atenaIdobi;
    @TempTableColumnOrder(9)
    private RString atenaIdoJiyu;
    @TempTableColumnOrder(10)
    private FlexibleDate idobi;
    @TempTableColumnOrder(11)
    private RString idoJiyuCode;
    @TempTableColumnOrder(12)
    private FlexibleDate shikakuShiyutokiDate;
    @TempTableColumnOrder(13)
    private FlexibleDate firstShikakuShiyutokiDate;
    @TempTableColumnOrder(14)
    private RString hihokenshaKubunCode;
    @TempTableColumnOrder(15)
    private RString cityCode;
    @TempTableColumnOrder(16)
    private RString rirekiNo;
    @TempTableColumnOrder(17)
    private RString edaNo;
    @TempTableColumnOrder(18)
    private RString jukyuShinseiJiyu;
    @TempTableColumnOrder(19)
    private FlexibleDate ninteiYukoKaishiDate;
    @TempTableColumnOrder(20)
    private FlexibleDate ninteiYukoShuryoDate;
    @TempTableColumnOrder(21)
    private FlexibleDate ninteiDate;
    @TempTableColumnOrder(22)
    private RString yoKaigoninteiJoutaiKubunCode;
    @TempTableColumnOrder(23)
    private boolean kyuSochishaFlag;
    @TempTableColumnOrder(24)
    private FlexibleYear shotokuNendo;
    @TempTableColumnOrder(25)
    private RString shotokuRirekiNo;
    @TempTableColumnOrder(26)
    private RString kazeiKubun;
    @TempTableColumnOrder(27)
    private RString kazeiKubunGemmenGo;
    @TempTableColumnOrder(28)
    private Decimal gokeiShotokuGaku;
    @TempTableColumnOrder(29)
    private Decimal nenkiniShunyuGaku;
    @TempTableColumnOrder(30)
    private Decimal nenkiniShotokuGaku;
    @TempTableColumnOrder(31)
    private Decimal kazeiShotokuGaku;
    @TempTableColumnOrder(32)
    private RString gekihenKanwaKubun;
    @TempTableColumnOrder(33)
    private FlexibleDate hanteiKijunYMD;
}
