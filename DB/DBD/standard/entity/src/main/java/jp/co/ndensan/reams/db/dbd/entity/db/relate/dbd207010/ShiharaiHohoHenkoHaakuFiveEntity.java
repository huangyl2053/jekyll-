/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス5SQL検索結果クラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoHenkoHaakuFiveEntity {

    //被保険者台帳管理
    private HihokenshaNo 支払方法変更情報_被保険者番号;

    private ShikibetsuCode 支払方法変更情報_識別コード;
    private RString 支払方法変更情報_被保険者氏名カナ;
    private RString 支払方法変更情報_被保険者氏名;
    private YubinNo 支払方法変更情報_郵便番号;
    private RString 支払方法変更情報_住所;
    private FlexibleDate 支払方法変更情報_資格取得日;
    private FlexibleDate 支払方法変更情報_資格喪失日;
    private RString 支払方法変更情報_喪失事由;
    private RString 支払方法変更情報_申請中;
    private Code 支払方法変更情報_世帯番号;
    private GyoseikuCode 支払方法変更情報_行政区コード;
    private RString 支払方法変更情報_行政区;
    private RString 支払方法変更情報_資格区分;
    private RString 支払方法変更情報_住特フラグ;
    private RString 支払方法変更情報_生保;
    private Code 支払方法変更情報_要介護度;
    private FlexibleDate 支払方法変更情報_認定開始年月日;
    private FlexibleDate 支払方法変更情報_認定終了年月日;
    private FlexibleDate 支払方法変更情報_認定日;
    private FlexibleDate 支払方法変更情報_申請日;
    private RString reqProcess;
    //収納状況一時テーブル
    private FlexibleYear 収納状況_調定年度;
    private FlexibleYear 収納状況_賦課年度;
    private RString 収納状況_通知書番号;
    private int 収納状況_期;
    private HihokenshaNo 収納状況_被保険者番号;
    private ShikibetsuCode 収納状況_識別コード;
    private FlexibleDate 収納状況_納期限;
    private Decimal 収納状況_調定額;
    private FlexibleDate 収納状況_収入日;
    private Decimal 収納状況_収入額;
    private FlexibleDate 収納状況_督促状発行日;
    private FlexibleDate 時効起算日;
    private RString 収納状況_時効区分;
    private RString 完納_未納区分;
    private Decimal 収納状況_未納額;
    private RString 収納状況_時効起算事由;
    private RString 収納状況_滞納区分;
    private int 収納状況_最長滞納期間;
    private Decimal 収納状況_以前滞納額;
    private RString 収納状況_以前滞納区分;
    private boolean 収納状況_過年度フラグ;

    //償還未払い情報一時テーブル
    private HihokenshaNo 償還未払い_被保険者番号;
    private RString 償還未払い_申請中;
    private FlexibleDate 償還未払い_申請日;
    private int 償還未払い_申請中件数;
    private RString 償還未払い_整理番号;
    private FlexibleYearMonth 償還未払い_提供年月;
    private int 償還未払い_未通知件数;

    //滞納者対策情報一時テーブル
    private HihokenshaNo 滞納者対策情報_被保険者番号;
    private FlexibleDate 滞納者対策情報_適用開始日;
    private FlexibleDate 滞納者対策情報_適用終了日;
    private FlexibleDate 滞納者対策情報_終了受付日;
    private FlexibleDate 滞納者対策情報_予告発行日;
    private FlexibleDate 滞納者対策情報_弁明期限;
    private FlexibleDate 滞納者対策情報_弁明受付日;
    private FlexibleDate 滞納者対策情報_償還発行日;
    private int 滞納者対策情報_償還証期限;
    private int 滞納者対策情報_差止中件数;
    private Decimal 滞納者対策情報_差止中金額;
    private FlexibleDate 滞納者対策情報_差止納付期日;
    private int 滞納者対策情報_控除件数;
    private FlexibleDate 滞納者対策情報_控除証期限;
}
