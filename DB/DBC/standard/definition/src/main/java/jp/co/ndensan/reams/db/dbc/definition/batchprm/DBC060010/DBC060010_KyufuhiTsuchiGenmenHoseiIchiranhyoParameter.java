/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC060010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufutsuchigenmenhosei.KyufuTsuchiGenmenHoseiProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付費通知減免補正一覧表のバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-2270-030 lijia
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC060010_KyufuhiTsuchiGenmenHoseiIchiranhyoParameter extends BatchParameterBase {

    private static final long serialVersionUID = 2899708024047360350L;
    @BatchParameter(key = "サービス開始年月", name = "サービス開始年月")
    private FlexibleYearMonth サービス開始年月;
    @BatchParameter(key = "サービス終了年月", name = "サービス終了年月")
    private FlexibleYearMonth サービス終了年月;
    @BatchParameter(key = "市町村コード", name = "市町村コードList")
    private List<HokenshaNo> 市町村コードList;
    @BatchParameter(key = "帳票出力順ID", name = "帳票出力順ID")
    private RString 帳票出力順ID;

    /**
     * プロセスパラメータを作成します。
     *
     */
    public DBC060010_KyufuhiTsuchiGenmenHoseiIchiranhyoParameter() {
    }

    /**
     * プロセスパラメータを作成します。
     *
     * @return プロセスパラメータ
     */
    public KyufuTsuchiGenmenHoseiProcessParameter toProcessParameter() {
        return new KyufuTsuchiGenmenHoseiProcessParameter(
                サービス開始年月, サービス終了年月, 市町村コードList, 帳票出力順ID);
    }
}
