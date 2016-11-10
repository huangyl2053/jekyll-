/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 計算対象者ファイルEntity項目定義クラスです。
 *
 * @reamsid_L DBE-1500-020 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class KakobunJissekiKihonTempTableEntity extends DbTableEntityBase<KakobunJissekiKihonTempTableEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TempTableColumnOrder(1)
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(2)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(3)
    private RString shotsicode;
    @TempTableColumnOrder(4)
    private FlexibleYear nendo;
    @TempTableColumnOrder(5)
    private FlexibleYearMonth nengetsu;
    @TempTableColumnOrder(6)
    private FlexibleDate nengetsuymd;
    @TempTableColumnOrder(7)
    private RString chusyutsumaster1;
    @TempTableColumnOrder(8)
    private RString chusyutsujiyu1;
    @TempTableColumnOrder(9)
    private RString chusyutsushikibetsu1;
    @TempTableColumnOrder(10)
    private RString chusyutsumaster2;
    @TempTableColumnOrder(11)
    private RString chusyutsujiyu2;
    @TempTableColumnOrder(12)
    private RString chusyutsushikibetsu2;
    @TempTableColumnOrder(13)
    private RString chusyutsumaster3;
    @TempTableColumnOrder(14)
    private RString chusyutsujiyu3;
    @TempTableColumnOrder(15)
    private RString chusyutsushikibetsu3;
    @TempTableColumnOrder(16)
    private RString chusyutsumaster4;
    @TempTableColumnOrder(17)
    private RString chusyutsushikibetsu4;
    @TempTableColumnOrder(18)
    private RString chusyutsujiyu4;
    @TempTableColumnOrder(19)
    private RString chusyutsumaster5;
    @TempTableColumnOrder(20)
    private RString chusyutsushikibetsu5;
    @TempTableColumnOrder(21)
    private RString chusyutsujiyu5;
    @TempTableColumnOrder(22)
    private RString chusyutsumaster6;
    @TempTableColumnOrder(23)
    private RString chusyutsushikibetsu6;
    @TempTableColumnOrder(24)
    private RString chusyutsujiyu6;
    @TempTableColumnOrder(25)
    private RString chusyutsumaster7;
    @TempTableColumnOrder(26)
    private RString chusyutsushikibetsu7;
    @TempTableColumnOrder(27)
    private RString chusyutsujiyu7;
    @TempTableColumnOrder(28)
    private RString chusyutsumaster8;
    @TempTableColumnOrder(29)
    private RString chusyutsushikibetsu8;
    @TempTableColumnOrder(30)
    private RString chusyutsujiyu8;
    @TempTableColumnOrder(31)
    private RString chusyutsumaster9;
    @TempTableColumnOrder(32)
    private RString chusyutsushikibetsu9;
    @TempTableColumnOrder(33)
    private RString chusyutsujiyu9;
    @TempTableColumnOrder(34)
    private RString chusyutsumaster10;
    @TempTableColumnOrder(35)
    private RString chusyutsushikibetsu10;
    @TempTableColumnOrder(36)
    private RString chusyutsujiyu10;
}
