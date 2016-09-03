/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU010030;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.processprm.ippangenbutsu.JigyoHokokuGeppoIppanGenbutsuProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業報告月報_一般現物のパラメータクラスです。
 *
 * @reamsid_L DBU-5540-030 suguangjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBU010030_JigyoHokokuGeppo_IppanGenbutsuParamter extends BatchParameterBase {

    private static final String PRINTCONTROLKBN = "printControlKbn";
    private static final String CSVID = "csvId";
    private static final String KOUIKIFLAG = "kouikiflag";
    private static final String GAPPEIFLAG = "gappeiflag";
    private static final String SHICHOSONCODE = "shichosonCode";
    private static final String KOSEISHICHOSONLIST = "koseiShichosonList";
    private static final String KYUSHICHOSONLIST = "kyuShichosonList";
    private static final String TAISHOUSHICHOSONLIST = "taishouShichosonList";
    private static final String KYUUSHICHOUSONFLAG = "kyuushichousonflag";
    private static final String SHUKEINENGETU = "shukeinengetu";
    private static final String KYUUHUZISSEKIKBNCODE = "kyuuhuzissekikbnCode";
    private static final String HOUKOKUNENGETU = "houkokunengetu";
    private static final String TOUKEITAISHOUKBN = "toukeitaishoukbn";
    private static final String SHORINITIZI = "shorinitizi";
    private static final String BACTHID = "bacthId";

    @BatchParameter(key = PRINTCONTROLKBN, name = "プリントコントロール区分")
    private RString プリントコントロール区分;
    @BatchParameter(key = CSVID, name = "作成CSVファイルID")
    private RString 作成CSVファイルID;
    @BatchParameter(key = KOUIKIFLAG, name = "広域フラグ")
    private boolean 広域フラグ;
    @BatchParameter(key = GAPPEIFLAG, name = "合併フラグ")
    private boolean 合併フラグ;
    @BatchParameter(key = SHICHOSONCODE, name = "市町村コード")
    private RString 市町村コード;
    @BatchParameter(key = KOSEISHICHOSONLIST, name = "構成市町村コードList")
    private List<RString> 構成市町村コードリスト;
    @BatchParameter(key = KYUSHICHOSONLIST, name = "旧市町村コードList")
    private List<RString> 旧市町村コードリスト;
    @BatchParameter(key = TAISHOUSHICHOSONLIST, name = "対象市町村コードList")
    private List<RString> 対象市町村コードList;
    @BatchParameter(key = KYUUSHICHOUSONFLAG, name = "旧市町村フラグ")
    private RString 旧市町村フラグ;
    @BatchParameter(key = SHUKEINENGETU, name = "集計年月(審査年月)")
    private RString 集計年月;
    @BatchParameter(key = KYUUHUZISSEKIKBNCODE, name = "給付実績区分コード")
    private RString 給付実績区分コード;
    @BatchParameter(key = HOUKOKUNENGETU, name = "報告年月")
    private RString 報告年月;
    @BatchParameter(key = TOUKEITAISHOUKBN, name = "統計対象区分")
    private RString 統計対象区分;
    @BatchParameter(key = SHORINITIZI, name = "処理日時")
    private RString 処理日時;
    @BatchParameter(key = BACTHID, name = "バッチID")
    private RString バッチID;

    /**
     * Process用のパラメータを生成します。
     *
     * @return JigyoHokokuGeppoIppanGenbutsuProcessParamter
     */
    public JigyoHokokuGeppoIppanGenbutsuProcessParamter toProcessParamter() {
        return new JigyoHokokuGeppoIppanGenbutsuProcessParamter(
                プリントコントロール区分,
                作成CSVファイルID,
                広域フラグ,
                合併フラグ,
                市町村コード,
                構成市町村コードリスト,
                旧市町村コードリスト,
                対象市町村コードList,
                旧市町村フラグ,
                集計年月,
                給付実績区分コード,
                報告年月,
                統計対象区分, 処理日時,
                バッチID,
                RString.EMPTY);
    }
}
