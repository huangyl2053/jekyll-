/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * 収納状況一時テーブルEntityです。
 *
 * @reamsid_L DBD-3630-050 liangbc
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShunoJohoTempTableEntity extends DbTableEntityBase<ShunoJohoTempTableEntity> implements IDbAccessable {

    @TableName
    public static final RString TABLE_NAME = new RString("ShunoJohoTempTable");

    private FlexibleYear choteiNendo;
    private FlexibleYear fukaNendo;
    private TsuchishoNo tsuchishoNo;
    private int ki;
    private HihokenshaNo hihokenshaNo;
    private ShikibetsuCode shikibetsuCode;
    private RDate nokigenYMD;
    private Decimal choteigaku;
    private RDate shunyuYMD;
    private Decimal shunyugaku;
    private RDate tokusokujoHakkoYMD;
    private FlexibleYear jikoKisanYMD;
    private RString jikoKisanYMDKubun;
    private RString kannouMinouKubun;
    private Decimal minougaku;
    private RString jikoKisanJiyu;
    private RString 滞納区分;
    private RString 最長滞納期間;
    private Decimal 以前滞納額;
    private RString 以前滞納区分;
    private boolean 過年度フラグ;

}
