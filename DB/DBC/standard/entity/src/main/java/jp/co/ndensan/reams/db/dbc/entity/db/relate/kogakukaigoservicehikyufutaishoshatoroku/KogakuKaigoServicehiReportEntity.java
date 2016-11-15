/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票とCSVのデータを取得のエンティティクラスです。
 *
 * @reamsid_L DBC-2010-040 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKaigoServicehiReportEntity {

    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;
    private FlexibleYearMonth サービス提供年月;
    private SetaiCode 世帯コード;
    private RString 高額判定結果;
    private Decimal 利用者負担額;
    private Decimal 支給予定金額;
    private LasdecCode 市町村コード;
    private RString 備考欄個人所得区分;
    private AtenaMeisho 名称;
    private Code 要介護認定状態区分コード;
    private boolean 旧措置者フラグ;
    private FlexibleDate 認定有効期間開始年月日;
    private FlexibleDate 認定有効期間終了年月日;
    private HokenshaNo 証記載保険者番号;
    private AtenaKanaMeisho カナ名称;
    private YubinNo 郵便番号;
    private ChoikiCode 町域コード;
    private GyoseikuCode 行政区コード;

}
