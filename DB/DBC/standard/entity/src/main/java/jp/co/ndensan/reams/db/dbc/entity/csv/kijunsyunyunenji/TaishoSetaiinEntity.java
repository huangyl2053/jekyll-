/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 対象世帯員クラスです
 *
 * @reamsid_L DBC-4630-030 jiangwenkai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaishoSetaiinEntity implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private RString shotaiCode;
    @TempTableColumnOrder(2)
    private FlexibleYear shoriNendo;
    @TempTableColumnOrder(3)
    private RString setaikazeiKubun;
    @TempTableColumnOrder(4)
    private RString kazeiShotokuKubun;
    @TempTableColumnOrder(5)
    private Decimal soushuu;
    @TempTableColumnOrder(6)
    private RString message;
    @TempTableColumnOrder(7)
    private RString shuturyokuUmu;
    @TempTableColumnOrder(8)
    private Integer nennshouLess16Num;
    @TempTableColumnOrder(9)
    private Integer nennshouLess16_18Num;
    @TempTableColumnOrder(10)
    private RString rannkuShichosonCode;
    @TempTableColumnOrder(11)
    private FlexibleDate shotaikijunDay;
    @TempTableColumnOrder(12)
    private FlexibleDate shotaikijunDay2;
    @TempTableColumnOrder(13)
    private Integer koushinnNo;
    @TempTableColumnOrder(14)
    private Boolean innjiGirisiamojiKubun;
    @PrimaryKey
    @TempTableColumnOrder(15)
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    @TempTableColumnOrder(16)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(17)
    private RString shichosonCode;
    @TempTableColumnOrder(18)
    private RString jushochiTokureiFlag;
    @TempTableColumnOrder(19)
    private RString kazeiKubun;
    @TempTableColumnOrder(20)
    private Decimal kazeiShotokuGaku;
    @TempTableColumnOrder(21)
    private Decimal kazeiShotokuGakuAfter;
    @TempTableColumnOrder(22)
    private Decimal nenkinShunyuGaku;
    @TempTableColumnOrder(23)
    private Decimal sonotanoGoukeiShotokuKingakuGoukei;
    @TempTableColumnOrder(24)
    private RString hennshuuZokugaraCode;
    @TempTableColumnOrder(25)
    private RString atenaDateDhubetsu_1231;
    @TempTableColumnOrder(26)
    private RString atenaDateDhubetsu_kijunDay;
    @TempTableColumnOrder(27)
    private RString hihokenshaName;
    @TempTableColumnOrder(28)
    private RString hihokenshaKana;
    @TempTableColumnOrder(29)
    private RString sex;
    @TempTableColumnOrder(30)
    private FlexibleDate seinengappiYMD;
    @TempTableColumnOrder(31)
    private RString age;
    @TempTableColumnOrder(32)
    private RString hihokennshaKubun;
    @TempTableColumnOrder(33)
    private RString jukyuKubun;
    @TempTableColumnOrder(34)
    private RString nijiHanteiYokaigoJotaiKubunCode;
    @TempTableColumnOrder(35)
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    @TempTableColumnOrder(36)
    private FlexibleDate ninteiYukoKikanShuryoYMD;
    @TempTableColumnOrder(37)
    private FlexibleDate tekiyoKaishiYMD;
    @TempTableColumnOrder(38)
    private FlexibleDate tekiyoShuryoYMD;
    @TempTableColumnOrder(39)
    private RString atenaInnjiKubun;
    @TempTableColumnOrder(40)
    private RString shinnseishoJuusho;
    @TempTableColumnOrder(41)
    private RString rennrakusaki;
    @TempTableColumnOrder(42)
    private RString oshiraseRennrakusaki;

}
