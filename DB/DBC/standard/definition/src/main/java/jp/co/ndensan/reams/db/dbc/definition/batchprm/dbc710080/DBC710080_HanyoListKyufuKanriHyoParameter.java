/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc710080;

import jp.co.ndensan.reams.db.dbc.definition.core.chushutsujoken.ChushutsuJoken;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
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
public class DBC710080_HanyoListKyufuKanriHyoParameter {

    private static final long serialVersionUID = 1L;

    private static final String A = "給付対象年月From";
    @BatchParameter(key = A, name = "給付対象年月From")
    private RDate 給付対象年月From;

    private static final String B = "給付対象年月To";
    @BatchParameter(key = B, name = "給付対象年月To")
    private RDate 給付対象年月To;

    private static final String C = "居宅支援事業者コード";
    @BatchParameter(key = C, name = "居宅支援事業者コード")
    private RString 居宅支援事業者コード;

    private static final String D = "居宅支援事業者名";
    @BatchParameter(key = D, name = "居宅支援事業者名")
    private RString 居宅支援事業者名;

    private static final String E = "委託先支援事業者コード";
    @BatchParameter(key = E, name = "委託先支援事業者コード")
    private RString 委託先支援事業者コード;

    private static final String F = "委託先支援事業者名";
    @BatchParameter(key = F, name = "委託先支援事業者名")
    private RString 委託先支援事業者名;

    private static final String G = "明細行出力有無";
    @BatchParameter(key = G, name = "明細行出力有無")
    private ChushutsuJoken 明細行出力有無;

    private static final String H = "項目名付加";
    @BatchParameter(key = H, name = "項目名付加")
    private boolean 項目名付加;

    private static final String I = "連番付加";
    @BatchParameter(key = I, name = "連番付加")
    private boolean 連番付加;

    private static final String J = "日付スラッシュ付加";
    @BatchParameter(key = J, name = "日付スラッシュ付加")
    private boolean 日付スラッシュ付加;

    private static final String K = "保険者コード";
    @BatchParameter(key = K, name = "保険者コード")
    private LasdecCode 保険者コード;

    private static final String L = "出力順";
    @BatchParameter(key = L, name = "出力順")
    private Long 出力順;

    private static final String M = "出力項目";
    @BatchParameter(key = M, name = "出力項目")
    private RString 出力項目;

}
