/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBDBT00004;

import java.util.ArrayList;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 社会福祉法人軽減認定者リスト作成バッチパラメタークラスです．
 *
 * @reamsid_LDBD-3830-040 tianyh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD200004_ShakaiFukushiHojinKeigenNinteishaBatchParameter extends BatchParameterBase {

    @BatchParameter(key = "対象リスト", name = "対象リスト")
    private RString 対象リスト;
    @BatchParameter(key = "対象期間指定", name = "対象期間指定")
    private RString 対象期間指定;
    @BatchParameter(key = "対象年度の開始年月日", name = "対象年度の開始年月日")
    private FlexibleDate 対象年度の開始年月日;
    @BatchParameter(key = "対象年度の終了年月日", name = "対象年度の終了年月日")
    private FlexibleDate 対象年度の終了年月日;
    @BatchParameter(key = "所得年度", name = "所得年度")
    private FlexibleYear 所得年度;
    @BatchParameter(key = "旧措置者区分", name = "旧措置者区分")
    private RString 旧措置者区分;
    @BatchParameter(key = "世帯表示", name = "世帯表示")
    private RString 世帯表示;
    @BatchParameter(key = "基準日", name = "基準日")
    private FlexibleDate 基準日;
    @BatchParameter(key = "課税判定等基準日", name = "課税判定等基準日")
    private FlexibleDate 課税判定等基準日;
    @BatchParameter(key = "受給者区分", name = "受給者区分")
    private RString 受給者区分;
    @BatchParameter(key = "世帯非課税等", name = "世帯非課税等")
    private ArrayList<RString> 世帯非課税等;
    @BatchParameter(key = "抽出対象", name = "抽出対象")
    private RString 抽出対象;
    @BatchParameter(key = "CSV出力設定", name = "CSV出力設定")
    private ArrayList<RString> CSV出力設定;
    @BatchParameter(key = "改頁出力順ID", name = "改頁出力順ID")
    private long 改頁出力順ID;
    @BatchParameter(key = "帳票ID", name = "帳票ID")
    private RString 帳票ID;

}
