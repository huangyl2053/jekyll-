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
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;

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
    private static final String SHUUKEIYM = "shuukeiYM";
    private static final String HOUKOKUYM = "houkokuYM";
    private static final String SAKUSEINITIZI = "sakuseinitizi";
    private static final String SHORINITIZI = "shorinitizi";
    private static final String KYUHUSHUKEIKBN = "kyuhushukeikbn";
    private static final String KYUSHICHOUSONKBN = "kyushichousonkbn";
    private static final String KOUSEISHICHOUSONKBN = "kouseishichousonkbn";
    private static final String SHICHOSONCODE = "shichosonCode";
    private static final String KOUSEISHICHOUSONCODELIST = "kouseishichousonCodeList";
    private static final String KYUSHICHOUSONCODELIST = "kyushichousonCodeList";
    private static final String KASHUKHSHICHOUSONCODELIST = "kashukhshichousonCodeList";
    private static final String KASHUKHKYUSHICHOUSONKBN = "kashukhkyushichousonkbn";
    private static final String CSVID = "csvId";
    private static final String BACTHID = "bacthId";
    private static final String SHUKEINO = "shukeiNo";
    private static final String SYUTURYOKUCSVFILEPATH = "syuturyokuCSVFilePath";
    private static final String MANAGER = "manager";

    @BatchParameter(key = PRINTCONTROLKBN, name = "プリントコントロール区分")
    private RString プリントコントロール区分;
    @BatchParameter(key = SHUUKEIYM, name = "集計年月")
    private RString 集計年月;
    @BatchParameter(key = HOUKOKUYM, name = "報告年月")
    private RString 報告年月;
    @BatchParameter(key = SAKUSEINITIZI, name = "作成日時")
    private RString 作成日時;
    @BatchParameter(key = SHORINITIZI, name = "処理日時")
    private RString 処理日時;
    @BatchParameter(key = KYUHUSHUKEIKBN, name = "給付集計区分")
    private RString 給付集計区分;
    @BatchParameter(key = KYUSHICHOUSONKBN, name = "旧市町村区分")
    private RString 旧市町村区分;
    @BatchParameter(key = KOUSEISHICHOUSONKBN, name = "構成市町村区分")
    private RString 構成市町村区分;
    @BatchParameter(key = SHICHOSONCODE, name = "市町村コード")
    private RString 市町村コード;
    @BatchParameter(key = KOUSEISHICHOUSONCODELIST, name = "構成市町村コードList")
    private List<RString> 構成市町村コードList;
    @BatchParameter(key = KYUSHICHOUSONCODELIST, name = "旧市町村コードList")
    private List<RString> 旧市町村コードList;
    @BatchParameter(key = KASHUKHSHICHOUSONCODELIST, name = "過去集計分市町村コードList")
    private List<RString> 過去集計分市町村コードList;
    @BatchParameter(key = KASHUKHKYUSHICHOUSONKBN, name = "過去集計分旧市町村区分")
    private RString 過去集計分旧市町村区分;
    @BatchParameter(key = CSVID, name = "作成CSVファイルID")
    private RString 作成CSVファイルID;
    @BatchParameter(key = BACTHID, name = "バッチID")
    private RString バッチID;
    @BatchParameter(key = SHUKEINO, name = "集計番号")
    private RString 集計番号;
    @BatchParameter(key = SYUTURYOKUCSVFILEPATH, name = "出力CSVファイルPath")
    private RString csvFilePath;
    @BatchParameter(key = MANAGER, name = "manager")
    private FileSpoolManager manager;

    /**
     * コンストラクタです。
     */
    public DBU010030_JigyoHokokuGeppo_IppanGenbutsuParamter() {
    }

    /**
     * Process用のパラメータを生成します。
     *
     * @return JigyoHokokuGeppoIppanGenbutsuProcessParamter
     */
    public JigyoHokokuGeppoIppanGenbutsuProcessParamter toProcessParamter() {
        return new JigyoHokokuGeppoIppanGenbutsuProcessParamter(
                プリントコントロール区分,
                集計年月,
                報告年月,
                作成日時,
                処理日時,
                給付集計区分,
                旧市町村区分,
                構成市町村区分,
                市町村コード,
                構成市町村コードList,
                旧市町村コードList,
                過去集計分市町村コードList,
                過去集計分旧市町村区分,
                作成CSVファイルID,
                バッチID,
                集計番号,
                csvFilePath,
                manager);
    }
}
