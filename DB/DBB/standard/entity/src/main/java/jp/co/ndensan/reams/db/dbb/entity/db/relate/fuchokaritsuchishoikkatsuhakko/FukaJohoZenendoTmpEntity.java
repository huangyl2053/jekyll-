/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokaritsuchishoikkatsuhakko;

import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 異動賦課情報一時テーブル
 *
 * @reamsid_L DBB-0710-030 yebangqiang
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaJohoZenendoTmpEntity extends DbTableEntityBase<FukaJohoZenendoTmpEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private RString fuka_InsertDantaiCd;
    @TempTableColumnOrder(2)
    private RDateTime fuka_InsertTimestamp;
    @TempTableColumnOrder(3)
    private RString fuka_InsertReamsLoginId;
    @TempTableColumnOrder(4)
    private UUID fuka_InsertContextId;
    @TempTableColumnOrder(5)
    private boolean fuka_IsDeleted = false;
    @TempTableColumnOrder(6)
    private int fuka_UpdateCount = 0;
    @TempTableColumnOrder(7)
    private RDateTime fuka_LastUpdateTimestamp;
    @TempTableColumnOrder(8)
    private RString fuka_LastUpdateReamsLoginId;
    @TempTableColumnOrder(9)
    private FlexibleYear fuka_ChoteiNendo;
    @TempTableColumnOrder(10)
    private FlexibleYear fuka_FukaNendo;
    @TempTableColumnOrder(11)
    @PrimaryKey
    private TsuchishoNo fuka_TsuchishoNo;
    @TempTableColumnOrder(12)
    private int fuka_RirekiNo;
    @TempTableColumnOrder(13)
    private HihokenshaNo fuka_HihokenshaNo;
    @TempTableColumnOrder(14)
    private ShikibetsuCode fuka_ShikibetsuCode;
    @TempTableColumnOrder(15)
    private SetaiCode fuka_SetaiCode;
    @TempTableColumnOrder(16)
    private int fuka_SetaiInsu;
    @TempTableColumnOrder(17)
    private FlexibleDate fuka_ShikakuShutokuYMD;
    @TempTableColumnOrder(18)
    private RString fuka_ShikakuShutokuJiyu;
    @TempTableColumnOrder(19)
    private FlexibleDate fuka_ShikakuSoshitsuYMD;
    @TempTableColumnOrder(20)
    private RString fuka_ShikakuSoshitsuJiyu;
    @TempTableColumnOrder(21)
    private RString fuka_SeihofujoShurui;
    @TempTableColumnOrder(22)
    private FlexibleDate fuka_SeihoKaishiYMD;
    @TempTableColumnOrder(23)
    private FlexibleDate fuka_SeihoHaishiYMD;
    @TempTableColumnOrder(24)
    private FlexibleDate fuka_RonenKaishiYMD;
    @TempTableColumnOrder(25)
    private FlexibleDate fuka_RonenHaishiYMD;
    @TempTableColumnOrder(26)
    private FlexibleDate fuka_FukaYMD;
    @TempTableColumnOrder(27)
    private RString fuka_KazeiKubun;
    @TempTableColumnOrder(28)
    private RString fuka_SetaikazeiKubun;
    @TempTableColumnOrder(29)
    private Decimal fuka_GokeiShotokuGaku;
    @TempTableColumnOrder(30)
    private Decimal fuka_NenkinShunyuGaku;
    @TempTableColumnOrder(31)
    private RString fuka_HokenryoDankai;
    @TempTableColumnOrder(32)
    private RString fuka_HokenryoDankai1;
    @TempTableColumnOrder(33)
    private Decimal fuka_NengakuHokenryo1;
    @TempTableColumnOrder(34)
    private FlexibleYearMonth fuka_TsukiwariStartYM1;
    @TempTableColumnOrder(35)
    private FlexibleYearMonth fuka_TsukiwariEndYM1;
    @TempTableColumnOrder(36)
    private RString fuka_HokenryoDankai2;
    @TempTableColumnOrder(37)
    private Decimal fuka_NengakuHokenryo2;
    @TempTableColumnOrder(38)
    private FlexibleYearMonth fuka_TsukiwariStartYM2;
    @TempTableColumnOrder(39)
    private FlexibleYearMonth fuka_TsukiwariEndYM2;
    @TempTableColumnOrder(40)
    private YMDHMS fuka_ChoteiNichiji;
    @TempTableColumnOrder(41)
    private RString fuka_ChoteiJiyu1;
    @TempTableColumnOrder(42)
    private RString fuka_ChoteiJiyu2;
    @TempTableColumnOrder(43)
    private RString fuka_ChoteiJiyu3;
    @TempTableColumnOrder(44)
    private RString fuka_ChoteiJiyu4;
    @TempTableColumnOrder(45)
    private RString fuka_KoseiM;
    @TempTableColumnOrder(46)
    private Decimal fuka_GemmenMaeHokenryo;
    @TempTableColumnOrder(47)
    private Decimal fuka_GemmenGaku;
    @TempTableColumnOrder(48)
    private Decimal fuka_KakuteiHokenryo;
    @TempTableColumnOrder(49)
    private RString fuka_HokenryoDankaiKarisanntei;
    @TempTableColumnOrder(50)
    private int fuka_ChoshuHohoRirekiNo;
    @TempTableColumnOrder(51)
    private YMDHMS fuka_IdoKijunNichiji;
    @TempTableColumnOrder(52)
    private RString fuka_KozaKubun;
    @TempTableColumnOrder(53)
    private RString fuka_KyokaisoKubun;
    @TempTableColumnOrder(54)
    private RString fuka_ShokkenKubun;
    @TempTableColumnOrder(55)
    private LasdecCode fuka_FukaShichosonCode;
    @TempTableColumnOrder(56)
    private Decimal fuka_TkSaishutsuKampuGaku;
    @TempTableColumnOrder(57)
    private Decimal fuka_FuSaishutsuKampuGaku;
    @TempTableColumnOrder(58)
    private Decimal fuka_Choteigaku;
    @TempTableColumnOrder(59)
    @PrimaryKey
    private int fuka_Ki;
    @TempTableColumnOrder(60)
    @PrimaryKey
    private RString fuka_ChoshuHouhou;
    @TempTableColumnOrder(61)
    private Decimal fuka_ChoteiId;
    @TempTableColumnOrder(62)
    private Decimal fuka_ShunoId;
}
