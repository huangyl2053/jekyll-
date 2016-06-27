/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyotakuservicekeikakuichiran;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共有子Div「居宅計画」の一覧Entityです。
 *
 * @reamsid_L DBD-3560-080 huangh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyotakuServiceKeikakuIchiranEntity {

    private FlexibleYearMonth 対象年月;
    private RString 作成区分コード;
    private RString 暫定区分;
    private JigyoshaNo 事業者番号;
    private AtenaMeisho 事業者名称;
    private FlexibleDate 適用開始年月日;
    private FlexibleDate 適用終了年月日;
    private int 履歴番号;
}
