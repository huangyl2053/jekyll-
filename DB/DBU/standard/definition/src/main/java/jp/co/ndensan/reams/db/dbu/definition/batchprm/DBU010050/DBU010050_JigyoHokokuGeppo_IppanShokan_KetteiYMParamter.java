/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU010050;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.processprm.ippanshokanketteiym.JigyoHokokuGeppoIppanShokanProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;

/**
 * 事業報告月報_一般状況のパラメータクラスです。
 *
 * @reamsid_L DBU-5550-030 suguangjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBU010050_JigyoHokokuGeppo_IppanShokan_KetteiYMParamter extends BatchParameterBase {

    private static final String PRINTCONTROLKBN = "printControlKbn";
    private static final String KETTEIYM = "ketteiYM";
    private static final String HOUKOKUYM = "houkokuYM";
    private static final String NENDO = "nendo";
    private static final String SAKUSEINITIZI = "sakuseinitizi";
    private static final String SHORINITIZI = "shorinitizi";
    private static final String KYUHUSHUKEIKBN = "kyuhushukeikbn";
    private static final String SHICHOSONCODE = "shichosoncode";
    private static final String KOUSEISHICHOSONKBN = "kouseishichosonkbn";
    private static final String KYUSHICHOSONKBN = "kyushichosonkbn";
    private static final String KOUSEISHICHOSONLIST = "kouseishichosonList";
    private static final String KAKOSKHUNSHICHOSONLIST = "kakoskhunshichosonList";
    private static final String KAKOSKHUNKYUSHICHOSONKBNLIST = "kakoskhunkyushichosonkbnList";
    private static final String KAKOSKHUNKYUSHICHOSONKBN = "kakoskhunkyushichosonkbn";
    private static final String CSVID = "csvId";
    private static final String BACTHID = "bacthId";
    private static final String SHUKEINO = "shukeiNo";
    private static final String SYUTURYOKUCSVFILEPATH = "syuturyokuCSVFilePath";
    private static final String MANAGER = "manager";

    @BatchParameter(key = PRINTCONTROLKBN, name = "プリントコントロール区分")
    private RString プリントコントロール区分;
    @BatchParameter(key = KETTEIYM, name = "決定年月")
    private RString 決定年月;
    @BatchParameter(key = HOUKOKUYM, name = "報告年月")
    private RString 報告年月;
    @BatchParameter(key = NENDO, name = "年度")
    private RString 年度;
    @BatchParameter(key = SAKUSEINITIZI, name = "作成日時")
    private RString 作成日時;
    @BatchParameter(key = SHORINITIZI, name = "処理日時")
    private YMDHMS 処理日時;
    @BatchParameter(key = KYUHUSHUKEIKBN, name = "給付集計区分")
    private RString 給付集計区分;
    @BatchParameter(key = SHICHOSONCODE, name = "市町村コード")
    private RString 市町村コード;
    @BatchParameter(key = KOUSEISHICHOSONKBN, name = "構成市町村区分")
    private RString 構成市町村区分;
    @BatchParameter(key = KYUSHICHOSONKBN, name = "旧市町村区分")
    private RString 旧市町村区分;
    @BatchParameter(key = KOUSEISHICHOSONLIST, name = "構成市町村コードList")
    private List<RString> 構成市町村コードList;
    @BatchParameter(key = KAKOSKHUNSHICHOSONLIST, name = "旧市町村コードList")
    private List<RString> 旧市町村コードList;
    @BatchParameter(key = KAKOSKHUNKYUSHICHOSONKBNLIST, name = "過去集計分市町村コードList")
    private List<RString> 過去集計分市町村コードList;
    @BatchParameter(key = KAKOSKHUNKYUSHICHOSONKBN, name = "過去集計分旧市町村区分")
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
    public DBU010050_JigyoHokokuGeppo_IppanShokan_KetteiYMParamter() {
    }

    /**
     * Process用のパラメータを生成します。
     *
     * @return JigyoHokokuGeppoIppanGenbutsuProcessParamter
     */
    public JigyoHokokuGeppoIppanShokanProcessParamter toProcessParamter() {
        return new JigyoHokokuGeppoIppanShokanProcessParamter(
                プリントコントロール区分,
                決定年月,
                報告年月,
                年度,
                作成日時,
                処理日時,
                給付集計区分,
                市町村コード,
                構成市町村区分,
                旧市町村区分,
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
