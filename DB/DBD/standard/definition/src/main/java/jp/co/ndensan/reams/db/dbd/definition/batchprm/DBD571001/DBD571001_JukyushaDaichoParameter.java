/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD571001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd571001.IdoChushutsuDaichoProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 受給者台帳のバッチパラメータクラスです。
 *
 * @reamsid_L DBD-1760-020 panxiaobo
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD571001_JukyushaDaichoParameter extends BatchParameterBase {

    @BatchParameter(key = "抽出条件設定区分", name = "抽出条件設定区分")
    private RString 抽出条件設定区分;
    @BatchParameter(key = "被保険者番号_From", name = "被保険者番号_From")
    private RString 被保険者番号_From;
    @BatchParameter(key = "被保険者番号_To", name = "被保険者番号_To")
    private RString 被保険者番号_To;
    @BatchParameter(key = "今回抽出開始年月日", name = "今回抽出開始年月日")
    private RDate 今回抽出開始年月日;
    @BatchParameter(key = "今回抽出開始時分秒", name = "今回抽出開始時分秒")
    private RTime 今回抽出開始時分秒;
    @BatchParameter(key = "今回抽出終了年月日", name = "今回抽出終了年月日")
    private RDate 今回抽出終了年月日;
    @BatchParameter(key = "今回抽出終了時分秒", name = "今回抽出終了時分秒")
    private RTime 今回抽出終了時分秒;
    @BatchParameter(key = "異動抽出対象リスト", name = "異動抽出対象リスト")
    private List<RString> 異動抽出対象リスト;
    @BatchParameter(key = "出力オプション区分", name = "出力オプション区分")
    private RString 出力オプション区分;
    @BatchParameter(key = "出力順設定リスト", name = "出力順設定リスト")
    private RString 出力順設定リスト;
    @BatchParameter(key = "市町村コード", name = "市町村コード")
    private RString 市町村コード;

    /**
     * バーチのパラメータを作成します。
     *
     * @return IdoChushutsuDaichoProcessParameter
     */
    public IdoChushutsuDaichoProcessParameter toIdoChushutsuDaichoProcessParameter() {
        return new IdoChushutsuDaichoProcessParameter(
                抽出条件設定区分,
                new HihokenshaNo(被保険者番号_From),
                new HihokenshaNo(被保険者番号_To),
                今回抽出開始年月日,
                今回抽出開始時分秒,
                今回抽出終了年月日,
                今回抽出終了時分秒,
                異動抽出対象リスト,
                出力オプション区分,
                出力順設定リスト,
                市町村コード);
    }
}
