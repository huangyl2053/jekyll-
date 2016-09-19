/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt22006.temptable;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 承認結果一時テーブルのクラスです。
 *
 * @reamsid_L DBD-3710-070 chenxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoninKekkaTempEntity extends DbTableEntityBase<ShoninKekkaTempEntity> implements IDbAccessable {

    /**
     * テーブル名です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("shoninKekkaTempEntity"));
    }
    @TempTableColumnOrder(1)
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @TempTableColumnOrder(2)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(3)
    private int rirekiNo;
    @TempTableColumnOrder(4)
    private RString kyusochishaKubun;
    @TempTableColumnOrder(5)
    private RString shinseiRiyuKubun;
    @TempTableColumnOrder(6)
    private RString riyoshaFutanDankai;
    @TempTableColumnOrder(7)
    private boolean kyokaisoGaitoshaKubun;
    @TempTableColumnOrder(8)
    private boolean gekihenKanwaSochiTaishoshaKubun;
    @TempTableColumnOrder(9)
    private RString kyoshitsuShubetsu;
    @TempTableColumnOrder(10)
    private Decimal shokuhiFutanGendogaku;
    @TempTableColumnOrder(11)
    private Decimal unitTypeKoshitsu;
    @TempTableColumnOrder(12)
    private Decimal unitTypeJunKoshitsu;
    @TempTableColumnOrder(13)
    private Decimal juraiTypeKoshitsu_Tokuyo;
    @TempTableColumnOrder(14)
    private Decimal juraiTypeKoshitsu_Roken_Ryoyo;
    @TempTableColumnOrder(15)
    private Decimal tashoshitsu;
    @TempTableColumnOrder(16)
    private boolean haigushaUmuFlag;
    @TempTableColumnOrder(17)
    private AtenaMeisho haigushaShimei;
    @TempTableColumnOrder(18)
    private AtenaKanaMeisho haigushaShimeiKana;
    @TempTableColumnOrder(19)
    private FlexibleDate haigushaSeinenGappiYMD;
    @TempTableColumnOrder(20)
    private AtenaJusho haigushaJusho;
    @TempTableColumnOrder(21)
    private RString haigushaRenrakusaki;
    @TempTableColumnOrder(22)
    private AtenaJusho haigushaJusho2;
    @TempTableColumnOrder(23)
    private RString haigushaKazeiKubun;
    @TempTableColumnOrder(24)
    private ShikibetsuCode haigushaShikibetsuCd;
    @TempTableColumnOrder(25)
    private RString yochokinShinkokuKubun;
    @TempTableColumnOrder(26)
    private Decimal yochokinGaku;
    @TempTableColumnOrder(27)
    private Decimal yukashoukenGaisangaku;
    @TempTableColumnOrder(28)
    private Decimal sonotaKingaku;
    @TempTableColumnOrder(29)
    private FlexibleDate shinseiYMD;
    @TempTableColumnOrder(30)
    private FlexibleDate ketteiYMD;
    @TempTableColumnOrder(31)
    private FlexibleDate tekiyoKaishiYMD;
    @TempTableColumnOrder(32)
    private FlexibleDate tekiyoShuryoYMD;
    @TempTableColumnOrder(33)
    private RString ketteiKubun;
    @TempTableColumnOrder(34)
    private RString hiShoninRiyu;
    @TempTableColumnOrder(35)
    private YMDHMS batchShoriNitiji;
    @TempTableColumnOrder(36)
    private boolean izokuNenkinJukyuFlag;
    @TempTableColumnOrder(37)
    private boolean shogaiNenkinJukyuFlag;

}
