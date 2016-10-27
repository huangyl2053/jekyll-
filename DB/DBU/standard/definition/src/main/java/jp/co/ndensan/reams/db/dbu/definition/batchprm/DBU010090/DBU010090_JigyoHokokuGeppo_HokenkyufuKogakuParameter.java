/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU010090;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppohokenkyufukogaku.JigyoHokokuGeppoHokenkyufuKogakuProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;

/**
 * 事業状況報告資料（月報）作成 保険給付決定情報（高額介護サービス費）のバッチのパラメータです。
 *
 * @reamsid_L DBU-5580-030 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DBU010090_JigyoHokokuGeppo_HokenkyufuKogakuParameter extends BatchParameterBase {

    private static final String PRINTCONTROLKBN = "printControlKbn";
    private static final String SHUKEIYM = "shukeiym";
    private static final String HOKOKUYM = "hokokuym";
    private static final String NENDO = "nendo";
    private static final String SAKUSEIDATE = "sakuseidate";
    private static final String SHORIDATE = "shoriDate";
    private static final String SHICHOSONCODE = "shichosonCode";
    private static final String KOSEISHICHOSONKBN = "koseiShichosonKbn";
    private static final String KYUSHICHOSONKBN = "kyuShichosonKbn";
    private static final String KOSEISHICHOSONLIST = "koseiShichosonList";
    private static final String KYUSHICHOSONLIST = "kyuShichosonList";
    private static final String KAKOSHUKEISHICHOSONLIST = "kakoShukeiShichosonList";
    private static final String KAKOSHUKEIKYUSHICHOSONKBN = "kakoShukeiKyuShichosonKbn";
    private static final String BATCHID = "batchid";
    private static final String SYUTURYOKUCSVFILEPATH = "syuturyokuCSVFilePath";
    private static final String MANAGER = "manager";
    private static final long serialVersionUID = -3583581895977881896L;

    @BatchParameter(key = PRINTCONTROLKBN, name = "プリントコントロール区分")
    private RString プリントコントロール区分;
    @BatchParameter(key = SHUKEIYM, name = "集計年月")
    private RString 集計年月;
    @BatchParameter(key = HOKOKUYM, name = "報告年月")
    private RString 報告年月;
    @BatchParameter(key = NENDO, name = "年度")
    private RString 年度;
    @BatchParameter(key = SAKUSEIDATE, name = "作成日時")
    private RString 作成日時;
    @BatchParameter(key = SHORIDATE, name = "処理日時")
    private YMDHMS 処理日時;
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
    @BatchParameter(key = SYUTURYOKUCSVFILEPATH, name = "出力CSVファイルPath")
    private RString csvFilePath;
    @BatchParameter(key = MANAGER, name = "manager")
    private FileSpoolManager manager;

    /**
     * Process用のパラメータを生成します。
     *
     * @return JigyoHokokuGeppoHokenkyufuKogakuProcessParamter
     */
    public JigyoHokokuGeppoHokenkyufuKogakuProcessParamter toProcessParamter() {
        return new JigyoHokokuGeppoHokenkyufuKogakuProcessParamter(
                プリントコントロール区分,
                集計年月,
                報告年月,
                年度,
                作成日時,
                処理日時,
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
