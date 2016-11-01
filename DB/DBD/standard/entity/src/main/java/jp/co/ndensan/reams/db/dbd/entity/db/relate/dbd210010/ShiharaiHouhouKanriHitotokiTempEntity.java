/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd210010;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 支払方法管理一時テーブルentityクラスです。
 *
 * @reamsid_L DBD-4300-030 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHouhouKanriHitotokiTempEntity extends
        DbTableEntityBase<ShiharaiHouhouKanriHitotokiTempEntity> implements IDbAccessable {

    /**
     * テーブル名です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("shiharaiHouhouKanriHitotokiTemp"));
    }
    @TempTableColumnOrder(1)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(2)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(3)
    private LasdecCode shichosonCode;
    @TempTableColumnOrder(4)
    private AtenaMeisho meisho;
    @TempTableColumnOrder(5)
    private AtenaKanaMeisho kanaMeisho;
    @TempTableColumnOrder(6)
    private FlexibleDate seinengappiYMD;
    @TempTableColumnOrder(7)
    private RString seibetsuCode;
    @TempTableColumnOrder(8)
    private RString yubinNo;
    @TempTableColumnOrder(9)
    private ZenkokuJushoCode zenkokuJushoCode;
    @TempTableColumnOrder(10)
    private GyoseikuCode gyoseikuCode;
    @TempTableColumnOrder(11)
    private RString setaiCode;
    @TempTableColumnOrder(12)
    private RString jusho;
    @TempTableColumnOrder(13)
    private FlexibleDate shikakuShutokuYMD;
    @TempTableColumnOrder(14)
    private FlexibleDate shikakuSoshitsuYMD;
    @TempTableColumnOrder(15)
    private FlexibleDate ninteiShinseihi;
    @TempTableColumnOrder(16)
    private Code yokaigoJotaiKubunCode;
    @TempTableColumnOrder(17)
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    @TempTableColumnOrder(18)
    private FlexibleDate ninteiYukoKikanShuryoYMD;
    @TempTableColumnOrder(19)
    private FlexibleDate ninteiihi;
    @TempTableColumnOrder(20)
    private RString kanriKubun;
    @TempTableColumnOrder(21)
    private int rirekiNo;
    @TempTableColumnOrder(22)
    private RString torokuKubun;
    @TempTableColumnOrder(23)
    private FlexibleDate tekiyoKaishiYMD;
    @TempTableColumnOrder(24)
    private FlexibleDate tekiyoShuryoYMD;
    @TempTableColumnOrder(25)
    private RString shuryoKubun;
    @TempTableColumnOrder(26)
    private FlexibleDate yokoku_TorokuYMD;
    @TempTableColumnOrder(27)
    private FlexibleDate sashitome_IraiJuriYMD;
    @TempTableColumnOrder(28)
    private FlexibleDate yokoku_TsuchiHakkoYMD;
    @TempTableColumnOrder(29)
    private FlexibleDate bemmei_TeishutsuYMD;
    @TempTableColumnOrder(30)
    private FlexibleDate bemmei_UketsukeYMD;
    @TempTableColumnOrder(31)
    private RString bemmei_RiyuCode;
    @TempTableColumnOrder(32)
    private FlexibleDate bemmei_ShinsaKetteiYMD;
    @TempTableColumnOrder(33)
    private RString bemmei_ShinsaKekkaKubun;
    @TempTableColumnOrder(34)
    private FlexibleDate shokan_KetteiYMD;
    @TempTableColumnOrder(35)
    private FlexibleDate shokan_TsuchiHakkoYMD;
    @TempTableColumnOrder(36)
    private FlexibleDate hihokenshaShoTeishutsuYMD;
    @TempTableColumnOrder(37)
    private RString sashitomeFlag;
    @TempTableColumnOrder(38)
    private FlexibleDate sashitome_KetteiYMD;
    @TempTableColumnOrder(39)
    private FlexibleDate sashitome_KaijoYMD;
    @TempTableColumnOrder(40)
    private FlexibleDate kojo_KetteiYMD;
    @TempTableColumnOrder(41)
    private FlexibleDate gemmen_KetteiYMD;
    @TempTableColumnOrder(42)
    private FlexibleDate gemmen_TsuchiHakkoYMD;
    @TempTableColumnOrder(43)
    private HokenKyufuRitsu kyufuRitsu;
    @TempTableColumnOrder(44)
    private FlexibleDate shuryoShinsei_UketsukeYMD;
    @TempTableColumnOrder(45)
    private FlexibleDate shuryoShinsei_YMD;
    @TempTableColumnOrder(46)
    private RString shuryoShinsei_RiyuCode;
    @TempTableColumnOrder(47)
    private FlexibleDate shuryoShinsei_ShinsaKetteiYMD;
    @TempTableColumnOrder(48)
    private RString shuryoShinsei_ShinsaKekkaKubun;
    @TempTableColumnOrder(49)
    private Decimal choshukenShometsuKikan;
    @TempTableColumnOrder(50)
    private Decimal nofusumiKikan;
    @TempTableColumnOrder(51)
    private Decimal nofusumiGengakuKikan;
    @TempTableColumnOrder(52)
    private FlexibleDate kakutei_GengakuKaishiYMD;
    @TempTableColumnOrder(53)
    private FlexibleDate kakutei_GengakuShuryoYMD;
    @TempTableColumnOrder(54)
    private RString koikinaiJushochiTokureiFlag;
    @TempTableColumnOrder(55)
    private ChoikiCode choikiCode;
    @TempTableColumnOrder(56)
    private RString flag;
    @TempTableColumnOrder(57)
    private LasdecCode koikinaiTokureiSochimotoShichosonCode;
    @TempTableColumnOrder(58)
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;

}
