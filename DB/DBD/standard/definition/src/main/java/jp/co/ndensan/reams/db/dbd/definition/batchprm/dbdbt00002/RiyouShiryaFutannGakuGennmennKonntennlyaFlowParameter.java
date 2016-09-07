/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbdbt00002;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.KyusochishaKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.HihokenshaKeizaiJokyo;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.JukyushaKubun2;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.SetaiHyoji;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TargetList;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt00002.ChohyoShutsuryokuJohoShutokuProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt00002.HchiJinoSyouriCreateProcessParamter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.common.CSVSettings;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 利用者負担額減免認定者リスト作成バッチパラメタークラスです.
 *
 * @reamsid_L DBD-3980-030 x_youyj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RiyouShiryaFutannGakuGennmennKonntennlyaFlowParameter extends BatchParameterBase {

    // 対象リスト
    private TargetList 対象リスト;
    // 基準日
    private FlexibleDate 基準日;
    // 所得年度
    private RString 所得年度;
    // 旧措置区分
    private KyusochishaKubun 旧措置区分;
    // 世帯表示
    private SetaiHyoji 世帯表示;
    // 受給者区分
    private JukyushaKubun2 受給者区分;
    // 世帯非課税等
    private List<HihokenshaKeizaiJokyo> 世帯非課税等;
    // CSV出力設定
    private CSVSettings 出力設定;
    // 改頁出力順ID
    private Long 改頁出力順ID;
    // 帳票ID
    private RString 帳票ID;

    /**
     * 対象者一次特定の引数を返します。
     *
     * @return 対象者一次特定の引数
     */
    public HchiJinoSyouriCreateProcessParamter toHchiJinoSyouriCreateProcessParamter() {
        return new HchiJinoSyouriCreateProcessParamter(対象リスト, 受給者区分, 旧措置区分, 基準日);
    }

    /**
     * 利用者負担額減免認定者リスト発行の引数を返します。。
     *
     * @return 利用者負担額減免認定者リスト発行の引数
     */
    public ChohyoShutsuryokuJohoShutokuProcessParameter toChohyoShutsuryokuJohoShutokuProcessParameter() {
        return new ChohyoShutsuryokuJohoShutokuProcessParameter(対象リスト, 基準日, 所得年度,
                旧措置区分, 世帯表示, 受給者区分, 世帯非課税等, 出力設定, 改頁出力順ID, 帳票ID);
    }
}
