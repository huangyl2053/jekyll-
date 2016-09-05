/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710080;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(給付管理票)
 *
 * @reamsid_L DBC-3096-010 zhengshenlei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC710080_HanyoListKyufuKanriHyoParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;

    private static final String YEAR_FROM = "給付対象年月From";
    @BatchParameter(key = YEAR_FROM, name = "給付対象年月From")
    private RDate 給付対象年月From;

    private static final String YEAR_TO = "給付対象年月To";
    @BatchParameter(key = YEAR_TO, name = "給付対象年月To")
    private RDate 給付対象年月To;

    private static final String HOME_WORKER_CODE = "居宅支援事業者コード";
    @BatchParameter(key = HOME_WORKER_CODE, name = "居宅支援事業者コード")
    private RString 居宅支援事業者コード;

    private static final String HOME_WORKER_NAME = "居宅支援事業者名";
    @BatchParameter(key = HOME_WORKER_NAME, name = "居宅支援事業者名")
    private RString 居宅支援事業者名;

    private static final String SUPPORT_WORKER_CODE = "委託先支援事業者コード";
    @BatchParameter(key = SUPPORT_WORKER_CODE, name = "委託先支援事業者コード")
    private RString 委託先支援事業者コード;

    private static final String SUPPORT_WORKER_NAME = "委託先支援事業者名";
    @BatchParameter(key = SUPPORT_WORKER_NAME, name = "委託先支援事業者名")
    private RString 委託先支援事業者名;

    private static final String DETAIL_OUTPUT = "明細行出力有無";
    @BatchParameter(key = DETAIL_OUTPUT, name = "明細行出力有無")
    private RString 明細行出力有無;

    private static final String PROJECT_NAME_ADD = "項目名付加";
    @BatchParameter(key = PROJECT_NAME_ADD, name = "項目名付加")
    private boolean 項目名付加;

    private static final String NO_ADD = "連番付加";
    @BatchParameter(key = NO_ADD, name = "連番付加")
    private boolean 連番付加;

    private static final String DATE_SLASH_ADD = "日付スラッシュ付加";
    @BatchParameter(key = DATE_SLASH_ADD, name = "日付スラッシュ付加")
    private boolean 日付スラッシュ付加;

    private static final String INSURANCE_CODE = "保険者コード";
    @BatchParameter(key = INSURANCE_CODE, name = "保険者コード")
    private LasdecCode 保険者コード;

    private static final String OUTPUT_ORDER = "出力順";
    @BatchParameter(key = OUTPUT_ORDER, name = "出力順")
    private Long 出力順;

    private static final String OUTPUT_ITEM = "出力項目";
    @BatchParameter(key = OUTPUT_ITEM, name = "出力項目")
    private RString 出力項目;

}
