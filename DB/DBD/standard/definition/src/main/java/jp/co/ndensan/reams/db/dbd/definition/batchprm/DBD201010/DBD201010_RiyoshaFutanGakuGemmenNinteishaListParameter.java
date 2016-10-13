/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD201010;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.KyusochishaJukyushaKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.HihokenshaKeizaiJokyo;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.JukyushaKubun2;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.SetaiHyoji;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.TargetList;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt00002.NinteishaListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt00002.TaishoshaIchijiTokuteiProcessParamter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist.CSVSettings;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
public class DBD201010_RiyoshaFutanGakuGemmenNinteishaListParameter extends BatchParameterBase {

    private TargetList 対象リスト;
    private FlexibleDate 基準日;
    private FlexibleYear 所得年度;
    private KyusochishaJukyushaKubun 旧措置区分;
    private SetaiHyoji 世帯表示;
    private JukyushaKubun2 受給者区分;
    private List<HihokenshaKeizaiJokyo> 世帯非課税等;
    private List<CSVSettings> csv出力設定;
    private Long 改頁出力順ID;
    private RString 帳票ID;

    /**
     * 対象者一次特定の引数を返します。
     *
     * @return 対象者一次特定の引数
     */
    public TaishoshaIchijiTokuteiProcessParamter toTaishoshaIchijiTokuteiProcessParamter() {
        return new TaishoshaIchijiTokuteiProcessParamter(対象リスト, 受給者区分, 旧措置区分, 基準日);
    }

    /**
     * 利用者負担額減免認定者リスト発行の引数を返します。。
     *
     * @param 帳票作成日時 RDate
     * @return 利用者負担額減免認定者リスト発行の引数
     */
    public NinteishaListSakuseiProcessParameter toNinteishaListSakuseiProcessParameter(RDate 帳票作成日時) {
        return new NinteishaListSakuseiProcessParameter(対象リスト, 基準日, 所得年度,
                旧措置区分, 世帯表示, 受給者区分, 世帯非課税等, csv出力設定, 改頁出力順ID, 帳票ID, 帳票作成日時);
    }
}
