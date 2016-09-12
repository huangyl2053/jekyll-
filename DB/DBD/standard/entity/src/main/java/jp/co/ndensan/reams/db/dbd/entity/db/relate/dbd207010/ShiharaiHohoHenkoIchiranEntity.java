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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 支払方法変更Entityクラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoHenkoIchiranEntity {

    //宛名情報
    private HihokenshaNo 宛名情報被保険者番号;
    private ShikibetsuCode 宛名情報識別コード;
    private RString 宛名情報被保険者氏名カナ;
    private RString 宛名情報被保険者氏名;
    private RString 宛名情報世帯番号;
    private RString 宛名情報行政区ｺｰﾄﾞ;
    private RString 宛名情報行政区;
    private RString 宛名情報住所コード;
    private RString 宛名情報郵便番号;
    private RString 宛名情報住所;

    //資格情報
    private FlexibleDate 資格情報資格取得日;
    private FlexibleDate 資格情報資格喪失日;
    private RString 資格情報喪失事由;
    private RString 資格情報資格区分;
    private RString 資格情報住特フラグ;
    private RString 資格情報生保;

    //認定情報
    private RString 認定情報要介護度;
    private RString 認定情報認定有効期間;
    private FlexibleDate 認定情報認定日;
    private RString 認定情報申請中;
    private FlexibleDate 認定情報申請日;

    //償還未払い情報
    private RString 償還未払い申請中;
    private FlexibleDate 償還未払い申請日;
    private int 償還未払い申請中件数;
    private RString 償還未払い整理番号;
    private FlexibleYearMonth 償還未払い提供年月;
    private int 未通知件数;

    //滞納管理情報
    private RString 滞納管理情報滞納管理状況;
    private int 滞納管理情報最長滞納期間;
    private Decimal 滞納管理情報以前滞納額;
    private RString 滞納管理情報以前滞納区分;
    private boolean 滞納管理情報終了状況;

    //滞納者対策情報
    private FlexibleDate 滞納者対策1行目適用開始日;
    private FlexibleDate 滞納者対策2行目適用終了日;
    private FlexibleDate 滞納者対策3行目終了受付日;
    private FlexibleDate 滞納者対策4行目予告発行日;
    private FlexibleDate 滞納者対策5行目弁明期限;
    private FlexibleDate 滞納者対策6行目弁明受付日;
    private FlexibleDate 滞納者対策7行目償還発行日;
    private FlexibleDate 滞納者対策8行目償還証期限;
    private int 滞納者対策9行目差止中件数;
    private Decimal 滞納者対策10行目差止中金額;
    private FlexibleDate 滞納者対策11行目差止納付期日;
    private int 滞納者対策12行目控除件数;
    private FlexibleDate 滞納者対策13行目控除証期限;
    private RString 滞納者対策14行目;
    private RString 滞納者対策15行目;
    private RString 滞納者対策16行目;
    private RString 滞納者対策17行目;

    //収納情報
    private FlexibleYear 収納賦課年度;
    private RString 収納期別;
    private Decimal 収納保険料金;
    private RString 収納納期限;
    private Decimal 収納滞納額;
    private RString 収納滞納区分;
    private FlexibleDate 収納時効起算日;
    private RString 収納時効起算事由;
    private boolean 収納過年度フラグ;
    private RString 収納収納情報なし;
}
