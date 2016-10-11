/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd210010;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付制限対象者一覧CSVの支払方法管理データEntityです。
 *
 * @reamsid_L DBD-4300-030 liuwei2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoHenkoEntity {

    private HihokenshaNo 被保険者番号;
    private RString 管理区分;
    private int 履歴番号;
    private RString 登録区分;
    private FlexibleDate 適用開始年月日;
    private FlexibleDate 適用終了年月日;
    private RString 終了区分;
    private FlexibleDate 予告登録年月日;
    private FlexibleDate 差止依頼書受理年月日;
    private FlexibleDate 予告通知書発行年月日;
    private FlexibleDate 弁明書提出期限;
    private FlexibleDate 弁明書受付年月日;
    private RString 弁明理由コード;
    private FlexibleDate 弁明審査決定年月日;
    private RString 弁明審査結果区分;
    private FlexibleDate 償還払化決定年月日;
    private FlexibleDate 償還払化通知書発行年月日;
    private FlexibleDate 被保険者証提出期限;
    private FlexibleDate 減額決定年月日;
    private FlexibleDate 減額通知書発行年月日;
    private HokenKyufuRitsu 給付率;
    private FlexibleDate 終了申請書受付年月日;
    private FlexibleDate 終了申請年月日;
    private RString 終了申請理由コード;
    private FlexibleDate 終了申請審査決定年月日;
    private RString 終了申請審査結果区分;

    private FlexibleDate 差止決定年月日;
    private FlexibleDate 差止解除年月日;
    private FlexibleDate 控除決定年月日;

    private ShikibetsuCode 識別コード;
    private LasdecCode 市町村コード;
    private FlexibleDate 資格取得年月日;
    private FlexibleDate 資格喪失年月日;
    private LasdecCode 広住特措置元市町村コード;
    private RString 広域内住所地特例フラグ;

    private FlexibleDate 認定年月日;
    private Code 要介護認定状態区分コード;

    private FlexibleDate 認定有効期間開始年月日;
    private FlexibleDate 認定有効期間終了年月日;

    private Decimal 徴収権消滅期間;
    private Decimal 納付済期間;
    private Decimal 納付済減額期間;
    private FlexibleDate 確定減額期間開始年月日;
    private FlexibleDate 確定減額期間終了年月日;

    private AtenaMeisho 名称;
    private AtenaKanaMeisho カナ名称;
    private FlexibleDate 生年月日;
    private RString 性別コード;
    private RString 郵便番号;
    private ZenkokuJushoCode 全国住所コード;
    private GyoseikuCode 行政区コード;
    private RString 世帯コード;
    private AtenaJusho 住所;
    private RString 番地;
    private RString 方書;
    private ChoikiCode 町域コード;
    private RString flag;
    private RString flag1;
    private ShoKisaiHokenshaNo 証記載保険者番号;

}
