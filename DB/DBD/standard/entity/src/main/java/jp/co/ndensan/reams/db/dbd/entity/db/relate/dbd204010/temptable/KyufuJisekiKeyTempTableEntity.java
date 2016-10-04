/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd204010.temptable;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 給付実績キー一時テーブルEntity
 *
 * @reamsid_L DBD-3880-050 jinge
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJisekiKeyTempTableEntity extends DbTableEntityBase<KyufuJisekiKeyTempTableEntity> implements IDbAccessable {

    /**
     * テーブル名です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("KyufuJisekiSanshoKeyTemps"));
    }

    @TempTableColumnOrder(1)
    private NyuryokuShikibetsuNo inputShikibetsuNo;
    @TempTableColumnOrder(2)
    private HokenshaNo shokisaiHokenshaNo;
    @TempTableColumnOrder(3)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(4)
    private FlexibleYearMonth shinsaYM;
    @TempTableColumnOrder(5)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(6)
    private JigyoshaNo jigyoshoNo;
    @TempTableColumnOrder(7)
    private RString toshiNo;
    @TempTableColumnOrder(8)
    private RString kyufuSakuseiKubunCode;

}
