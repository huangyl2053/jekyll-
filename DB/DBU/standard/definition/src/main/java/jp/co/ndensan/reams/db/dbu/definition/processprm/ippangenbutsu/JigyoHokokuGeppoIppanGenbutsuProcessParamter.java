/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.ippangenbutsu;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.ippangenbutsu.JigyoHokokuGeppoIppanGenbutsuMybatisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import lombok.Getter;

/**
 * 事業報告月報_一般現物のProcess用パラメータクラスです。
 *
 * @reamsid_L DBU-5540-030 suguangjun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class JigyoHokokuGeppoIppanGenbutsuProcessParamter implements IBatchProcessParameter {

    private final RString プリントコントロール区分;
    private final RString 集計年月;
    private final RString 報告年月;
    private final RString 作成日時;
    private final RString 処理日時;
    private final RString 給付集計区分;
    private final RString 旧市町村区分;
    private final RString 構成市町村区分;
    private final RString 市町村コード;
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
     * @param 作成CSVファイルID 作成CSVファイルID
     * @param 作成日時 作成日時
     * @param 給付集計区分 給付集計区分
     * @param 旧市町村区分 旧市町村区分
     * @param 構成市町村区分 構成市町村区分
     * @param 市町村コード 市町村コード
     * @param 構成市町村コードList 構成市町村コードList
     * @param 旧市町村コードList 旧市町村コードList
     * @param 過去集計分市町村コードList 過去集計分市町村コードList
     * @param 過去集計分旧市町村区分 過去集計分旧市町村区分
     * @param 集計年月 集計年月
     * @param 報告年月 報告年月
     * @param 処理日時 処理日時
     * @param バッチID バッチID
     * @param 集計番号 集計番号
     * @param csvFilePath csvFilePath
     * @param manager manager
     */
    public JigyoHokokuGeppoIppanGenbutsuProcessParamter(RString プリントコントロール区分,
            RString 集計年月,
            RString 報告年月,
            RString 作成日時,
            RString 処理日時,
            RString 給付集計区分,
            RString 旧市町村区分,
            RString 構成市町村区分,
            RString 市町村コード,
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
        this.集計年月 = 集計年月;
        this.報告年月 = 報告年月;
        this.作成日時 = 作成日時;
        this.処理日時 = 処理日時;
        this.給付集計区分 = 給付集計区分;
        this.旧市町村区分 = 旧市町村区分;
        this.構成市町村区分 = 構成市町村区分;
        this.市町村コード = 市町村コード;
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
     * temp事業報告統計元データ作成のmybatisのパラメータを生成します。
     *
     * @return JigyoHokokuGeppoIppanGenbutsuMybatisParamter
     */
    public JigyoHokokuGeppoIppanGenbutsuMybatisParamter toDataMybitisParamter() {
        return JigyoHokokuGeppoIppanGenbutsuMybatisParamter.create事業報告統計元データParam(構成市町村区分,
                構成市町村コードList, 市町村コード, 集計年月, 給付集計区分);
    }

    /**
     * 事業状況報告統計情報の取得処理mybatisのパラメータを生成します。
     *
     * @return JigyoHokokuGeppoIppanGenbutsuMybatisParamter
     */
    public JigyoHokokuGeppoIppanGenbutsuMybatisParamter toSelectDataMybitisParamter() {
        return JigyoHokokuGeppoIppanGenbutsuMybatisParamter.createDataParam(集計番号,
                new RString("\"tempJigyoHokokuTokeiMotoData\""));
    }

    /**
     * 処理日付管理マスタの登録処理mybatisのパラメータを生成します。
     *
     * @return JigyoHokokuGeppoIppanGenbutsuMybatisParamter
     */
    public JigyoHokokuGeppoIppanGenbutsuMybatisParamter toInsertDataMybitisParamter() {
        return JigyoHokokuGeppoIppanGenbutsuMybatisParamter.createInsertDataParam(市町村コード,
                構成市町村区分, 構成市町村コードList, 集計年月, 給付集計区分, 作成日時, 処理日時);
    }

    /**
     * 事業報告統計データ_12-13を取得する処理mybatisのパラメータを生成します。
     *
     * @return JigyoHokokuGeppoIppanGenbutsuMybatisParamter
     */
    public JigyoHokokuGeppoIppanGenbutsuMybatisParamter to事業報告統計データ_12_13MybitisParamter() {
        return JigyoHokokuGeppoIppanGenbutsuMybatisParamter.create事業報告統計データ_12_13Param(過去集計分市町村コードList,
                集計年月, 給付集計区分, 過去集計分旧市町村区分);
    }

    /**
     * 事業報告統計データ_14を取得する処理mybatisのパラメータを生成します。
     *
     * @return JigyoHokokuGeppoIppanGenbutsuMybatisParamter
     */
    public JigyoHokokuGeppoIppanGenbutsuMybatisParamter to事業報告統計データ_14MybitisParamter() {
        return JigyoHokokuGeppoIppanGenbutsuMybatisParamter.create事業報告統計データ_14Param(過去集計分市町村コードList,
                集計年月, 給付集計区分, 過去集計分旧市町村区分);
    }
}
