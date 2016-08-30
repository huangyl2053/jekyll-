/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc710160;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBCGM23016_汎用リスト出力(高額合算計算結果連絡票情報)
 *
 * @reamsid_L DBC-3100-010 zhengshenlei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC710160_HanyoListKogakuGassanKeisanKekkaRenrakuHyoParameter {

    private static final long serialVersionUID = 1L;

    private static final String A = "抽出区分";
    @BatchParameter(key = A, name = "抽出区分")
    private RString 抽出区分;

    private static final String B = "データ区分";
    @BatchParameter(key = B, name = "データ区分")
    private RString データ区分;

    private static final String C = "データ種類";
    @BatchParameter(key = C, name = "データ種類")
    private RString データ種類;

    private static final String D = "対象年度";
    @BatchParameter(key = D, name = "対象年度")
    private RString 対象年度;

    private static final String E = "受取年月From";
    @BatchParameter(key = E, name = "受取年月From")
    private RDate 受取年月From;

    private static final String F = "受取年月To";
    @BatchParameter(key = F, name = "受取年月To")
    private RDate 受取年月To;

    private static final String G = "送付年月From";
    @BatchParameter(key = G, name = "送付年月From")
    private RDate 送付年月From;

    private static final String H = "送付年月To";
    @BatchParameter(key = H, name = "送付年月To")
    private RDate 送付年月To;

    private static final String I = "項目名付加";
    @BatchParameter(key = I, name = "項目名付加")
    private boolean 項目名付加;

    private static final String J = "連番付加";
    @BatchParameter(key = J, name = "連番付加")
    private boolean 連番付加;

    private static final String K = "日付スラッシュ付加";
    @BatchParameter(key = K, name = "日付スラッシュ付加")
    private boolean 日付スラッシュ付加;

    private static final String L = "保険者コード";
    @BatchParameter(key = L, name = "保険者コード")
    private LasdecCode 保険者コード;

    private static final String M = "出力順";
    @BatchParameter(key = M, name = "出力順")
    private Long 出力順;

    private static final String N = "出力項目";
    @BatchParameter(key = N, name = "出力項目")
    private RString 出力項目;

}
