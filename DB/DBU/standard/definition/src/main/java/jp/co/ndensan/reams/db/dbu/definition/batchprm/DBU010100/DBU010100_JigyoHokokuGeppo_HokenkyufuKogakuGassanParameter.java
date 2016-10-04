/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU010100;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppohokenkyufukogakugassan.JigyoHokokuGeppoHokenkyufuKogakuGassanProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;

/**
 * 事業状況報告資料（月報）作成 保険給付決定状況（高額合算分）のバッチのパラメータです。
 *
 * @reamsid_L DBU-5590-030 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DBU010100_JigyoHokokuGeppo_HokenkyufuKogakuGassanParameter extends BatchParameterBase {

    private static final String PRINTCONTROLKBN = "printControlKbn";
    private static final String HOKOKUKBN = "hokokukbn";
    private static final String HOKOKUYM = "hokokuym";
    private static final String NENDO = "nendo";
    private static final String KETTEIYM = "ketteiym";
    private static final String HOKOKUNENDO = "hokokunendo";
    private static final String SHUKEINENDO = "shukeinendo";
    private static final String SHUKEIKAISHIYM = "shukeikaishiym";
    private static final String SHUKEISHUURYOUYM = "shukeishuuryouym";
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
    private static final long serialVersionUID = -628501499009795975L;

    @BatchParameter(key = PRINTCONTROLKBN, name = "プリントコントロール区分")
    private RString プリントコントロール区分;
    @BatchParameter(key = HOKOKUKBN, name = "報告区分")
    private RString 報告区分;
    @BatchParameter(key = HOKOKUYM, name = "報告年月")
    private RString 報告年月;
    @BatchParameter(key = NENDO, name = "年度")
    private RString 年度;
    @BatchParameter(key = KETTEIYM, name = "決定年月")
    private RString 決定年月;
    @BatchParameter(key = HOKOKUNENDO, name = "報告年度")
    private RString 報告年度;
    @BatchParameter(key = SHUKEINENDO, name = "集計年度")
    private RString 集計年度;
    @BatchParameter(key = SHUKEIKAISHIYM, name = "集計開始年月")
    private RString 集計開始年月;
    @BatchParameter(key = SHUKEISHUURYOUYM, name = "集計終了年月")
    private RString 集計終了年月;
    @BatchParameter(key = SAKUSEIDATE, name = "作成日時")
    private RString 作成日時;
    @BatchParameter(key = SHORIDATE, name = "処理日時")
    private RString 処理日時;
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
     * @return JigyoHokokuGeppoHokenkyufuKogakuGassanProcessParamter
     */
    public JigyoHokokuGeppoHokenkyufuKogakuGassanProcessParamter toProcessParamter() {
        return new JigyoHokokuGeppoHokenkyufuKogakuGassanProcessParamter(プリントコントロール区分, 報告区分, 報告年月, 年度, 決定年月,
                報告年度, 集計年度, 集計開始年月, 集計終了年月, 作成日時, 処理日時, 市町村コード,
                構成市町村区分, 旧市町村区分, 構成市町村コードリスト, 旧市町村コードリスト, 過去集計分市町村コードリスト,
                過去集計分旧市町村区分, バッチID, csvFilePath, manager);
    }
}
