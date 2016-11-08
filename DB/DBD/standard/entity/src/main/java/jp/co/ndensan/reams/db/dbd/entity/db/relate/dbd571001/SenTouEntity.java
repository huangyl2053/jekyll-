/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBD571001_受給者台帳を取得するEntityクラスです。
 *
 * @reamsid_L DBD-1760-020 panxiaobo
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SenTouEntity {

    private LasdecCode 受給者台帳_市町村コード;
    private HihokenshaNo 受給者台帳_被保険者番号;
    private RString 受給者台帳_履歴番号;
    private RString 受給者台帳_枝番;
    private ShikibetsuCode 受給者台帳_識別コード;
    private FlexibleDate 受給者台帳_認定年月日;
    private Code 受給者台帳_受給申請事由;
    private RString 受給者台帳_データ区分;
    private RString 受給者台帳_要介護認定状態区分コード;
    private FlexibleDate 受給者台帳_認定有効期間開始年月日;
    private FlexibleDate 受給者台帳_認定有効期間終了年月日;
    private Decimal 受給者台帳_支給限度単位数;
    private FlexibleDate 受給者台帳_支給限度有効開始年月日;
    private FlexibleDate 受給者台帳_支給限度有効終了年月日;
    private Decimal 受給者台帳_短期入所支給限度日数;
    private FlexibleDate 受給者台帳_短期入所支給限度開始年月日;
    private FlexibleDate 受給者台帳_短期入所支給限度終了年月日;
    private boolean 受給者台帳_旧措置者フラグ;
    private FlexibleDate 受給者台帳_喪失年月日;
    private boolean 受給者台帳_資格取得前申請フラグ;
    private FlexibleDate 受給者台帳_受給資格証明書発行年月日１;
    private FlexibleDate 受給者台帳_受給資格証明書発行年月日２;
    private RString 受給者台帳_届出者申請者関係コード;
    private RString 受給者台帳_届出者本人との関係;
    private RString t4101_申請書管理番号;
    private RString t4101_厚労省IF識別コード;
    private FlexibleDate t4101_延期通知発行年月日;
    private Decimal t4101_延期通知発行回数;
    private boolean t4101_指定医フラグ;
    private RString t4101_認定申請区分_申請時_コード;
    private RString t4101_認定申請区分_法令_コード;
    private RString t4101_訪問調査先郵便番号;
    private RString t4101_訪問調査先住所;
    private RString t4101_訪問調査先名称;
    private RString t4101_訪問調査先電話番号;
    private int psm_履歴番号;
    private RString psm_名称;
    private RString psm_カナ名称;
    private RString psm_全国住所コード;
    private RString psm_住所;
    private RString psm_性別コード;
    private FlexibleDate psm_生年月日;
    private RString psm_世帯コード;
    private ShikibetsuCode psm_識別コード;
    private RString psm_行政区コード;
    private RString psm_行政区名称;
    private RString psm_連絡先1;
    private RString psm_連絡先2;
    private RString psm_地区コード1;
    private RString psm_地区名1;
    private RString psm_地区コード2;
    private RString psm_地区名2;
    private RString psm_地区コード3;
    private RString psm_地区名3;
    private RString psm_町域コード;
    private FlexibleDate psm_処理年月日;
    private RString t7005_識別コード;
    private RString t7005_老人保健市町村コード;
    private RString t7005_老人保健受給者番号;
    private RString t7051_市町村識別ID;
    private RString t7051_市町村名称;
    private RString x1008_識別コード;
    private int x1008_履歴番号;
    private RString x1008_医療保険種別コード;
    private RString x1008_医療保険者番号;
    private RString x1008_医療保険者名称;
    private RString x1008_医療保険記号番号;
    private FlexibleYearMonth x3015_サービス提供年月;
    private FlexibleYearMonth x3017_サービス提供年月;
    private RString x3056_被保険者番号;
    private RString x3056_証記載保険者番号;
    private int x3056_履歴番号;
    private FlexibleYearMonth x3056_サービス提供年月;
    private RString x3034_被保険者番号;
    private FlexibleYearMonth x3034_サービス提供年月;
    private RString x3034_整理番号;
    private RString x2002_調定年度;
    private RString x2002_賦課年度;
    private RString x2002_通知書番号;
    private int x2002_履歴番号;
    private RString x2002_保険料段階;
    private int rank_number;

}
