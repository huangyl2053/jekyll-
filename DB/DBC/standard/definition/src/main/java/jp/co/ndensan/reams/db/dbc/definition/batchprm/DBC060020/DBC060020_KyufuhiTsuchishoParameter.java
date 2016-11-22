/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC060020;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufuhitsuchisho.KyufuhiTsuchishoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付費通知書作成(一括)のバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-2280-030 chenxiangyu
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC060020_KyufuhiTsuchishoParameter extends BatchParameterBase {

    private static final String KEY_SHUTSURYOKUJUN_ID = "shutsuryokujunId";
    private static final long serialVersionUID = 5255077799026629051L;
    @BatchParameter(key = "処理年月日", name = "処理年月日")
    private FlexibleDate 処理年月日;
    @BatchParameter(key = "サービス種類区分", name = "サービス種類区分")
    private RString サービス種類区分;
    @BatchParameter(key = "サービス開始年月", name = "サービス開始年月")
    private FlexibleYearMonth サービス開始年月;
    @BatchParameter(key = "サービス終了年月", name = "サービス終了年月")
    private FlexibleYearMonth サービス終了年月;
    @BatchParameter(key = "福祉用具貸与ページ出力区分", name = "福祉用具貸与ページ出力区分")
    private RString 福祉用具貸与ページ出力区分;
    @BatchParameter(key = "集約区分", name = "集約区分")
    private RString 集約区分;
    @BatchParameter(key = "保険者構成", name = "保険者構成")
    private RString 保険者構成;
    @BatchParameter(key = "証記載保険者番号", name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @BatchParameter(key = "要介護度", name = "要介護度")
    private RString 要介護度;
    @BatchParameter(key = "死亡者分を対象としない", name = "死亡者分を対象としない")
    private RString 死亡者分を対象としない;
    @BatchParameter(key = "ゼロ査定実績を対象としない", name = "ゼロ査定実績を対象としない")
    private RString ゼロ査定実績を対象としない;
    @BatchParameter(key = "再審査分を対象としない", name = "再審査分を対象としない")
    private RString 再審査分を対象としない;
    @BatchParameter(key = "過誤分を対象としない", name = "過誤分を対象としない")
    private RString 過誤分を対象としない;
    @BatchParameter(key = "施設分を対象としない", name = "施設分を対象としない")
    private RString 施設分を対象としない;
    @BatchParameter(key = "特定入所者介護を対象としない", name = "特定入所者介護を対象としない")
    private RString 特定入所者介護を対象としない;
    @BatchParameter(key = "償還分を対象としない", name = "償還分を対象としない")
    private RString 償還分を対象としない;
    @BatchParameter(key = "被保険者番号", name = "被保険者番号")
    private RString 被保険者番号;
    @BatchParameter(key = KEY_SHUTSURYOKUJUN_ID, name = "出力順ID")
    private Long shutsuryokujunId;
    @BatchParameter(key = "文書番号", name = "文書番号")
    private RString 文書番号;
    @BatchParameter(key = "loginUserId", name = "loginUserId")
    private RString loginUserId;

    /**
     * プロセスパラメータを作成します。
     *
     */
    public DBC060020_KyufuhiTsuchishoParameter() {
    }

    /**
     * プロセスパラメータを作成します。
     *
     * @return プロセスパラメータ
     */
    public KyufuhiTsuchishoProcessParameter toProcessParameter() {
        return new KyufuhiTsuchishoProcessParameter(new RString(処理年月日.toString()), サービス種類区分, new RString(サービス開始年月.toString()),
                new RString(サービス終了年月.toString()), 福祉用具貸与ページ出力区分, 集約区分, 保険者構成, 証記載保険者番号, 要介護度, 死亡者分を対象としない,
                ゼロ査定実績を対象としない, 再審査分を対象としない, 過誤分を対象としない, 施設分を対象としない, 特定入所者介護を対象としない,
                償還分を対象としない, shutsuryokujunId, 文書番号);
    }
}
