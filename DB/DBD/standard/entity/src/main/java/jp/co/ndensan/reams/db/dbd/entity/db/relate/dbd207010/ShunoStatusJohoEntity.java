/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス5SQL検索結果の収納情報クラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShunoStatusJohoEntity {

    private FlexibleYear 収納状況_調定年度;
    private FlexibleYear 収納状況_賦課年度;
    private RString 収納状況_通知書番号;
    private int 収納状況_期;
    private HihokenshaNo 収納状況_被保険者番号;
    private ShikibetsuCode 収納状況_識別コード;
    private RDate 収納状況_納期限;
    private Decimal 収納状況_調定額;
    private FlexibleDate 収納状況_収入日;
    private Decimal 収納状況_収入額;
    private FlexibleDate 収納状況_督促状発行日;
    private FlexibleDate 収納状況_時効起算日;
    private RString 収納状況_時効区分;
    private RString 収納状況_完納_未納区分;
    private Decimal 収納状況_未納額;
    private RString 収納状況_時効起算事由;
    private RString 収納状況_滞納区分;
    private int 収納状況_最長滞納期間;
    private Decimal 収納状況_以前滞納額;
    private RString 収納状況_以前滞納区分;
    private boolean 収納状況_過年度フラグ;
}
