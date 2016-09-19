/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 居宅給付計画自己作成管理一時のEntity
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class KyotakuKeikakuJikosakuseiKanriTempEntity extends DbTableEntityBase<KyotakuKeikakuJikosakuseiKanriTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private RString renban;
    @TempTableColumnOrder(2)
    private RString hihokenshaNo;
    @TempTableColumnOrder(3)
    private FlexibleYearMonth taishoYM;
    @TempTableColumnOrder(4)
    private FlexibleYearMonth rirekiNo;
    @TempTableColumnOrder(5)
    private FlexibleYearMonth riyoYM;
    @TempTableColumnOrder(6)
    private RString kyotakuServiceKubun;
    @TempTableColumnOrder(7)
    private RString meisaiNo;
    @TempTableColumnOrder(8)
    private RString serviceTeikyoJigyoshaNo;
    @TempTableColumnOrder(9)
    private RString serviceShuruiCode;
    @TempTableColumnOrder(10)
    private RString serviceKomokuCode;
    @TempTableColumnOrder(11)
    private RString taniSu;
    @TempTableColumnOrder(12)
    private RString kaisu_Nissu;
    @TempTableColumnOrder(13)
    private RString waribikiGoTekiyoRitsu;
    @TempTableColumnOrder(14)
    private RString waribikiGoTekiyoTaniSu;
    @TempTableColumnOrder(15)
    private RString kyufuTaishoNissu;
    @TempTableColumnOrder(16)
    private RString goukeiFlag;
    @TempTableColumnOrder(17)
    private RString shuruiGendoNaiTaniSuNissu;
    @TempTableColumnOrder(18)
    private RString shuruiGendoChokaTaniSuNissu;
    @TempTableColumnOrder(19)
    private RString kubunGendoNaiTaniSuNissu;
    @TempTableColumnOrder(20)
    private RString kubunGendoChokaTaniSuNissu;
    @TempTableColumnOrder(21)
    private RString taniSuTanka;
    @TempTableColumnOrder(22)
    private RString kyufuRitsu;
    @TempTableColumnOrder(23)
    private RString kyufuKeikakuTaniSu;
    @TempTableColumnOrder(24)
    private RString zenkaiRiyoNissu;
    @TempTableColumnOrder(25)
    private RString konkaiKeikakuRiyoNissu;
    @TempTableColumnOrder(26)
    private RString zanteiKubun;
    @TempTableColumnOrder(27)
    private RString koshinKubun;
    @TempTableColumnOrder(28)
    private FlexibleDate koshinYMD;
    @TempTableColumnOrder(29)
    private FlexibleYearMonth sofuYM;
    @TempTableColumnOrder(30)
    private RString hyojiYokaigoJotaiKubunCode;
    @TempTableColumnOrder(31)
    private RString hyojiShikyuGendoTanisu;
    @TempTableColumnOrder(32)
    private RString yokaigoJotaiKubunCode;
    @TempTableColumnOrder(33)
    private FlexibleYearMonth ninteiYukoKikanKaishiYM;
    @TempTableColumnOrder(34)
    private FlexibleYearMonth ninteiYukoKikanShuryoYM;
    @TempTableColumnOrder(35)
    private RString shikyuGendoTanisu;
    @TempTableColumnOrder(36)
    private FlexibleYearMonth shikyuGendoKaishiYM;
    @TempTableColumnOrder(37)
    private FlexibleYearMonth shikyuGendoShuryoYM;
    @TempTableColumnOrder(38)
    private RString tankiYokaigoJotaiKubunCode;
    @TempTableColumnOrder(39)
    private RString tankiSikyuGendoNissu;
    @TempTableColumnOrder(40)
    private FlexibleYearMonth tankiShikyuGendoKaishiYM;
    @TempTableColumnOrder(41)
    private FlexibleYearMonth tankiShikyuGendoShuryoYM;
    @TempTableColumnOrder(42)
    private RString serviceTeikyoJigyoshaName;
    @TempTableColumnOrder(43)
    private RString hokenshaNo;
    @TempTableColumnOrder(44)
    private RString hokenshaName;
}
