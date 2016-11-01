/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd210010;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付制限対象者一覧のデータEntityです。
 *
 * @reamsid_L DBD-4300-030 liuwei2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuSeikentaishoshaEntity {

    private HihokenshaNo 被保険者番号;

    private ShikibetsuCode 識別コード;

    private LasdecCode 市町村コード;

    private AtenaMeisho 氏名;

    private AtenaKanaMeisho カナ氏名;

    private FlexibleDate 生年月日;

    private RString 性別コード;

    private RString 郵便番号;

    private ZenkokuJushoCode 住所コード;

    private GyoseikuCode 行政区コード;

    private RString 世帯コード;

    private RString 住所;

    private FlexibleDate 資格取得日;

    private FlexibleDate 資格喪失日;

    private FlexibleDate 認定申請日;

    private Code 要介護状態区分;

    private FlexibleDate 認定有効開始年月日;

    private FlexibleDate 認定有効終了年月日;

    private FlexibleDate 認定日;

    private RString 管理区分;

    private RString 登録区分;

    private FlexibleDate 適用開始日;

    private FlexibleDate 適用終了日;

    private RString 終了区分;

    private FlexibleDate 予告登録日;

    private FlexibleDate 差止依頼書受理日;

    private FlexibleDate 予告通知書出力日;

    private FlexibleDate 予告通知書発行日;

    private FlexibleDate 弁明書提出期限;

    private FlexibleDate 弁明書受付日;

    private RString 弁明理由;

    private FlexibleDate 弁明内容決定日;

    private RString 弁明審査結果;

    private FlexibleDate 償還払化決定日;

    private FlexibleDate 償還払化通知書出力日;

    private FlexibleDate 償還払化通知書発行日;

    private FlexibleDate 被保険者証提出期限;

    private RString 差止対象フラグ;

    private FlexibleDate 差止決定日;

    private FlexibleDate 差止解除日;

    private FlexibleDate 控除決定日;

    private FlexibleDate 減額決定日;

    private FlexibleDate 減額通知書出力日;

    private FlexibleDate 減額通知書発行日;

    private HokenKyufuRitsu 給付率;

    private FlexibleDate 終了申請書受付日;

    private FlexibleDate 終了申請年月日;

    private RString 終了申請理由;

    private FlexibleDate 終了申請内容決定日;

    private RString 終了申請審査結果;

    private Decimal 徴収権消滅期間;

    private Decimal 納付済期間;

    private Decimal 納付済減額期間;

    private FlexibleDate 確定給付額減額期間開始日;

    private FlexibleDate 確定給付額減額期間終了日;

    private Decimal 通知時滞納額合計;

    private Decimal 現在滞納額合計;

    private LasdecCode 広住特措置元市町村コード;

    private RString 広域内住所地特例フラグ;
}
