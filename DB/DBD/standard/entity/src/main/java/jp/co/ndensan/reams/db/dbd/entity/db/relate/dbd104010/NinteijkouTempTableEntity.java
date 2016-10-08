/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd104010;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定状況表出力用一時テーブルのentityです。
 *
 * @reamsid_L　DBD-3770-060 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteijkouTempTableEntity extends DbTableEntityBase<NinteijkouTempTableEntity> implements IDbAccessable {

    /**
     * テーブル名です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("TmpNDecimaleijkou"));
    }
    @TempTableColumnOrder(1)
    private LasdecCode shichosonCode;
    @TempTableColumnOrder(2)
    private RString shichosonName;
    @TempTableColumnOrder(3)
    private RString title;
    @TempTableColumnOrder(4)
    private RString innjiKubun;
    @TempTableColumnOrder(5)
    private Decimal sigatukensu;
    @TempTableColumnOrder(6)
    private Decimal sigatusotishakensu;
    @TempTableColumnOrder(7)
    private Decimal gogatukensu;
    @TempTableColumnOrder(8)
    private Decimal gogatusotishakensu;
    @TempTableColumnOrder(9)
    private Decimal lokugatukensu;
    @TempTableColumnOrder(10)
    private Decimal lokugatusotishakensu;
    @TempTableColumnOrder(11)
    private Decimal shichigatukensu;
    @TempTableColumnOrder(12)
    private Decimal shichigatusotishakensu;
    @TempTableColumnOrder(13)
    private Decimal hachigatukensu;
    @TempTableColumnOrder(14)
    private Decimal hachigatusotishakensu;
    @TempTableColumnOrder(15)
    private Decimal kugatukensu;
    @TempTableColumnOrder(16)
    private Decimal kugatusotishakensu;
    @TempTableColumnOrder(17)
    private Decimal jyugatukensu;
    @TempTableColumnOrder(18)
    private Decimal jyugatusotishakensu;
    @TempTableColumnOrder(19)
    private Decimal jyuichigatukensu;
    @TempTableColumnOrder(20)
    private Decimal jyuichigatusotishakensu;
    @TempTableColumnOrder(21)
    private Decimal jyunigatukensu;
    @TempTableColumnOrder(22)
    private Decimal jyunigatusotishakensu;
    @TempTableColumnOrder(23)
    private Decimal ichigatukensu;
    @TempTableColumnOrder(24)
    private Decimal ichigatusotishakensu;
    @TempTableColumnOrder(25)
    private Decimal nigatukensu;
    @TempTableColumnOrder(26)
    private Decimal nigatusotishakensu;
    @TempTableColumnOrder(27)
    private Decimal sangatukensu;
    @TempTableColumnOrder(28)
    private Decimal sangatusotishakensu;
    @TempTableColumnOrder(29)
    private Decimal goukeikensu;
    @TempTableColumnOrder(30)
    private Decimal goukeisotishakensu;

}
