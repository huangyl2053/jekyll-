/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス5SQL検索結果クラスです．
 *
 * @reamsid_L DBD-3650-050 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoHenkoHaakuFiveEntity {

    private HihokenshaNo 対象者情報_被保険者番号;

    //収納状況一時テーブル
    private List<ShunoStatusJohoEntity> 収納状況情報リスト;

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
    private RString 滞納者対策情報_登録区分;
    private RString 滞納者対策情報_終了区分;

    private ShikibetsuCode 生活保護受給者_識別コード;

    private Code 認定情報_要介護認定状態区分コード;
    private FlexibleDate 認定情報_認定有効期間開始年月日;
    private FlexibleDate 認定情報_認定有効期間終了年月日;
    private FlexibleDate 認定情報_認定年月日;

    private UaFt200FindShikibetsuTaishoEntity 宛名情報;

    private HihokenshaNo 資格情報_被保険者番号;
    private ShikibetsuCode 資格情報_識別コード;
    private FlexibleDate 資格情報_資格取得年月日;
    private FlexibleDate 資格情報_資格喪失年月日;
    private RString 資格情報_資格喪失事由コード;
    private RString 資格情報_被保険者区分コード;
    private RString 資格情報_住所地特例フラグ;

    private HihokenshaNo 申請中認定情報_被保険者番号;

}
