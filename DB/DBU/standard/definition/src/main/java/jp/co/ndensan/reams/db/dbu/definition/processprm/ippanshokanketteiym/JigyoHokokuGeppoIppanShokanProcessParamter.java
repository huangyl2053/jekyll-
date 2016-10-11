/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.ippanshokanketteiym;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.ippanshokanketteiym.JigyoHokokuGeppoIppanShokanMybatisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import lombok.Getter;

/**
 * 事業報告月報_一般状況のProcess用パラメータクラスです。
 *
 * @reamsid_L DBU-5550-030 suguangjun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class JigyoHokokuGeppoIppanShokanProcessParamter implements IBatchProcessParameter {

    private final RString プリントコントロール区分;
    private final RString 決定年月;
    private final RString 報告年月;
    private final RString 年度;
    private final RString 作成日時;
    private final YMDHMS 処理日時;
    private final RString 給付集計区分;
    private final RString 市町村コード;
    private final RString 構成市町村区分;
    private final RString 旧市町村区分;
    private final List<RString> 構成市町村コードList;
    private final List<RString> 旧市町村コードList;
    private final List<RString> 過去集計分市町村コードList;
    private final RString 過去集計分旧市町村区分;
    private final RString 作成CSVファイルID;
    private final RString バッチID;
    private final RString 集計番号;
    private final RString csvFilePath;
    private final FileSpoolManager manager;

    /**
     * コンストラクタです。
     *
     * @param プリントコントロール区分 プリントコントロール区分
     * @param 決定年月 決定年月
     * @param 作成CSVファイルID 作成CSVファイルID
     * @param 年度 年度
     * @param 作成日時 作成日時
     * @param 市町村コード 市町村コード
     * @param 給付集計区分 給付集計区分
     * @param 構成市町村コードList 構成市町村コードList
     * @param 構成市町村区分 構成市町村区分
     * @param 旧市町村区分 旧市町村区分
     * @param 旧市町村コードList 旧市町村コードList
     * @param 報告年月 報告年月
     * @param 過去集計分市町村コードList 過去集計分市町村コードList
     * @param 過去集計分旧市町村区分 過去集計分旧市町村区分
     * @param 処理日時 処理日時
     * @param バッチID バッチID
     * @param 集計番号 集計番号
     * @param csvFilePath csvFilePath
     * @param manager manager
     */
    public JigyoHokokuGeppoIppanShokanProcessParamter(RString プリントコントロール区分,
            RString 決定年月,
            RString 報告年月,
            RString 年度,
            RString 作成日時,
            YMDHMS 処理日時,
            RString 給付集計区分,
            RString 市町村コード,
            RString 構成市町村区分,
            RString 旧市町村区分,
            List<RString> 構成市町村コードList,
            List<RString> 旧市町村コードList,
            List<RString> 過去集計分市町村コードList,
            RString 過去集計分旧市町村区分,
            RString 作成CSVファイルID,
            RString バッチID,
            RString 集計番号,
            RString csvFilePath,
            FileSpoolManager manager) {
        this.プリントコントロール区分 = プリントコントロール区分;
        this.決定年月 = 決定年月;
        this.報告年月 = 報告年月;
        this.年度 = 年度;
        this.作成日時 = 作成日時;
        this.処理日時 = 処理日時;
        this.給付集計区分 = 給付集計区分;
        this.市町村コード = 市町村コード;
        this.構成市町村区分 = 構成市町村区分;
        this.旧市町村区分 = 旧市町村区分;
        this.構成市町村コードList = 構成市町村コードList;
        this.旧市町村コードList = 旧市町村コードList;
        this.過去集計分市町村コードList = 過去集計分市町村コードList;
        this.過去集計分旧市町村区分 = 過去集計分旧市町村区分;
        this.作成CSVファイルID = 作成CSVファイルID;
        this.バッチID = バッチID;
        this.集計番号 = 集計番号;
        this.csvFilePath = csvFilePath;
        this.manager = manager;
    }

    /**
     * temp事業報告償還分決定年月統計元データのmybatisのパラメータを生成します。
     *
     * @return JigyoHokokuGeppoIppanShokanMybatisParamter
     */
    public JigyoHokokuGeppoIppanShokanMybatisParamter toDataMybitisParamter() {
        return JigyoHokokuGeppoIppanShokanMybatisParamter.createDataParam(new Code(集計番号), 決定年月,
                旧市町村区分, 旧市町村コードList);
    }

    /**
     * 事業報告統計データを削除のmybatisのパラメータを生成します。
     *
     * @return JigyoHokokuGeppoIppanShokanMybatisParamter
     */
    public JigyoHokokuGeppoIppanShokanMybatisParamter tocreateDelete事業報告統計データParam() {
        return JigyoHokokuGeppoIppanShokanMybatisParamter.createDelete事業報告統計データParam(決定年月, 市町村コード,
                構成市町村区分, 構成市町村コードList, 旧市町村区分, 旧市町村コードList);
    }

    /**
     * 事業報告統計データを削除のmybatisのパラメータを生成します。
     *
     * @return JigyoHokokuGeppoIppanShokanMybatisParamter
     */
    public JigyoHokokuGeppoIppanShokanMybatisParamter tocreateSelect事業報告統計データParam() {
        return JigyoHokokuGeppoIppanShokanMybatisParamter.createSelect事業報告統計データParam(決定年月, 市町村コード,
                構成市町村区分, 構成市町村コードList, 旧市町村区分, 旧市町村コードList);
    }

    /**
     * 処理日付管理マスタのmybatisのパラメータを生成します。
     *
     * @return JigyoHokokuGeppoIppanShokanMybatisParamter
     */
    public JigyoHokokuGeppoIppanShokanMybatisParamter tocreate処理日付管理マスタParam() {
        return JigyoHokokuGeppoIppanShokanMybatisParamter.createInsertDataParam(決定年月, 市町村コード, 構成市町村区分, 構成市町村コードList,
                旧市町村区分, 旧市町村コードList, プリントコントロール区分, 年度, 作成日時, 処理日時);
    }

    /**
     * 事業報告統計データ_12_13のmybatisのパラメータを生成します。
     *
     * @return JigyoHokokuGeppoIppanShokanMybatisParamter
     */
    public JigyoHokokuGeppoIppanShokanMybatisParamter tocreate事業報告統計データ_12_13MybitisParamter() {
        return JigyoHokokuGeppoIppanShokanMybatisParamter.create事業報告統計データ_12_13Param(決定年月,
                プリントコントロール区分, 市町村コード, 過去集計分市町村コードList);
    }

    /**
     * 事業報告統計データ_12_13のmybatisのパラメータを生成します。
     *
     * @return JigyoHokokuGeppoIppanShokanMybatisParamter
     */
    public JigyoHokokuGeppoIppanShokanMybatisParamter tocreate事業報告統計データ_14MybitisParamter() {
        return JigyoHokokuGeppoIppanShokanMybatisParamter.create事業報告統計データ_14Param(決定年月,
                プリントコントロール区分, 市町村コード, 過去集計分市町村コードList);
    }
}
