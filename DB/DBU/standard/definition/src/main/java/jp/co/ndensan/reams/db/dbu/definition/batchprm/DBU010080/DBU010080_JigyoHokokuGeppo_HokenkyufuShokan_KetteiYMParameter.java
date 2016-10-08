/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU010080;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.processprm.hokenkyufushokankettei.JigyoHokokuRenkeiHokenkyufuShokanKetteiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;

/**
 * 保険給付【償還_決定】のパラメータクラスです。
 *
 * @reamsid_L DBU-5570-030 xuyannan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBU010080_JigyoHokokuGeppo_HokenkyufuShokan_KetteiYMParameter extends BatchParameterBase {

    private static final String PRINTCONTROLKBN = "printControlKbn";
    private static final String SHUKEIYM = "shukeiYM";
    private static final String HOKOKUYM = "hokokuYM";
    private static final String SAKUSEIDATE = "sakuseiDate";
    private static final String SHORITIME = "shoriTime";
    private static final String TOUKEITAISHOUKBN = "toukeiTaishouKbn";
    private static final String SHICHOSONCODE = "shichosonCode";
    private static final String KOSEISHICHOSONKBN = "koseiShichosonKbn";
    private static final String KYUSHICHOSONKBN = "kyuShichosonKbn";
    private static final String KOSEISHICHOSONLIST = "koseiShichosonList";
    private static final String KYUSHICHOSONLIST = "kyuShichosonList";
    private static final String KAKOSHUKEISHICHOSONLIST = "kakoShukeiShichosonList";
    private static final String KAKOSHUKEIKYUSHICHOSONKBN = "kakoShukeiKyuShichosonKbn";
    private static final String BATCHID = "batchId";
    private static final String CSVFILEPATH = "CSVFilePath";
    private static final String MANAGER = "manager";

    @BatchParameter(key = PRINTCONTROLKBN, name = "プリントコントロール区分")
    private RString プリントコントロール区分;
    @BatchParameter(key = SHUKEIYM, name = "集計年月")
    private RString 集計年月;
    @BatchParameter(key = HOKOKUYM, name = "報告年月")
    private RString 報告年月;
    @BatchParameter(key = SAKUSEIDATE, name = "作成日付")
    private RString 作成日付;
    @BatchParameter(key = SHORITIME, name = "処理日時")
    private YMDHMS 処理日時;
    @BatchParameter(key = TOUKEITAISHOUKBN, name = "統計対象区分")
    private RString 統計対象区分;
    @BatchParameter(key = SHICHOSONCODE, name = "市町村コード")
    private RString 市町村コード;
    @BatchParameter(key = KOSEISHICHOSONKBN, name = "構成市町村区分")
    private RString 構成市町村区分;
    @BatchParameter(key = KYUSHICHOSONKBN, name = "旧市町村区分")
    private RString 旧市町村区分;
    @BatchParameter(key = KOSEISHICHOSONLIST, name = "構成市町村コードリスト")
    private List<RString> 構成市町村コードリスト;
    @BatchParameter(key = KYUSHICHOSONLIST, name = "旧市町村コードリスト")
    private List<RString> 旧市町村コードリスト;
    @BatchParameter(key = KAKOSHUKEISHICHOSONLIST, name = "過去集計分市町村コードリスト")
    private List<RString> 過去集計分市町村コードリスト;
    @BatchParameter(key = KAKOSHUKEIKYUSHICHOSONKBN, name = "過去集計分旧市町村区分")
    private RString 過去集計分旧市町村区分;
    @BatchParameter(key = BATCHID, name = "バッチID")
    private RString バッチID;
    @BatchParameter(key = CSVFILEPATH, name = "出力CSVファイルPath")
    private RString csvFilePath;
    @BatchParameter(key = MANAGER, name = "manager")
    private FileSpoolManager manager;

    /**
     * コンストラクタです。
     */
    public DBU010080_JigyoHokokuGeppo_HokenkyufuShokan_KetteiYMParameter() {
    }

    /**
     * Process用のパラメータを生成します。
     *
     * @return JigyoHokokuRenkeiHokenkyufuShokanKetteiProcessParameter
     */
    public JigyoHokokuRenkeiHokenkyufuShokanKetteiProcessParameter toProcessParamter() {
        return new JigyoHokokuRenkeiHokenkyufuShokanKetteiProcessParameter(
                プリントコントロール区分,
                集計年月,
                報告年月,
                作成日付,
                処理日時,
                統計対象区分,
                市町村コード,
                構成市町村区分,
                旧市町村区分,
                構成市町村コードリスト,
                旧市町村コードリスト,
                過去集計分市町村コードリスト,
                過去集計分旧市町村区分,
                バッチID,
                csvFilePath,
                manager);
    }
}
