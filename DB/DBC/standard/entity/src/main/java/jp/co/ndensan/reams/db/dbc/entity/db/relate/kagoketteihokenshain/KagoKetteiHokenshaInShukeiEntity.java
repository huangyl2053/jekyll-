/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteihokenshain;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 過誤決定通知書（保険者分）情報（集計）一時テーブルEntity
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KagoKetteiHokenshaInShukeiEntity implements Serializable {

    private RString kokanShikibetsuNo;
    private FlexibleYearMonth toriatsukaiYM;
    private HokenshaNo shokisaiHokenshaNo;
    private RString shokisaiHokenshaNa;
    private FlexibleDate sakuseiYMD;
    private RString kokukoRengoukaiNa;

    private int kaigoKyufuhiKensu;
    private Decimal kaigoKyufuhiTanisu;
    private Decimal kaigoKyufuhiFutangaku;
    private int kogakuServicehiKensu;
    private Decimal kogakuServicehiTanisu;
    private Decimal kogakuServicehiFutangaku;
    private int tokuteiNyushoshaServicehiKensu;
    private Decimal tokuteiNyushoshaServicehiTanisu;
    private Decimal tokuteiNyushoshaServicehiFutangaku;
}
