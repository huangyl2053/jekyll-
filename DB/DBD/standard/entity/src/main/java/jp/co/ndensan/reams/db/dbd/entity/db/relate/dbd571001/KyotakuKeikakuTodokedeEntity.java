/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
public class KyotakuKeikakuTodokedeEntity {

    private HihokenshaNo 居宅計画届出_被保険者番号;
    private FlexibleYearMonth 居宅計画届出_対象年月;
    private int 居宅計画届出_履歴番号;
    private RString 居宅計画届出_届出区分;
    private RString 居宅計画届出_作成区分コード;
    private FlexibleDate 居宅計画届出_届出年月日;
    private FlexibleDate 居宅計画届出_計画変更年月日;
    private FlexibleDate 居宅計画届出_適用開始年月日;
    private FlexibleDate 居宅計画届出_適用終了年月日;
    private RString 居宅計画届出_計画事業者番号;
    private RString 居宅計画届出_事業者名称;
    private RString 居宅計画届出_電話番号;
}
