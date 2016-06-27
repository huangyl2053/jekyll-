/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokenshoshikakushohakko;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 *
 * 居宅給付計画届出Entityです。
 *
 * @reamsid_L DBA-1090-021 huangh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyotakuKeikakuTodokedeEntity implements IDbAccessable {

    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth 対象年月;
    private Decimal 履歴番号;
    private FlexibleDate 届出年月日;
    private RString 居宅計画区分;
    private FlexibleDate 適用開始年月日;
    private FlexibleDate 適用終了年月日;
    private JigyoshaNo 計画事業者番号;
    private JigyoshaNo 委託先事業者番号;
    private RString 居宅計画作成者名称;
}
