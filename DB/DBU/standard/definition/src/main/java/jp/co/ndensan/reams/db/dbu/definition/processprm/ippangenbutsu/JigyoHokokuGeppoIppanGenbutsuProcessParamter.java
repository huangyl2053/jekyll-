/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.ippangenbutsu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.ippangenbutsu.KyufuJissekiKonkyoMybatisParamter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.ippangenbutsu.TempJigyoHokokuTokeiMotoDataMybatisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    private final RString 作成CSVファイルID;
    private final boolean 広域フラグ;
    private final boolean 合併フラグ;
    private final RString 市町村コード;
    private final List<RString> 構成市町村コードList;
    private final List<RString> 旧市町村コードList;
    private final List<RString> 対象市町村コードList;
    private final RString 旧市町村フラグ;
    private final RString 集計年月;
    private final RString 給付実績区分コード;
    private final RString 報告年月;
    private final RString 統計対象区分;
    private final RString 処理日時;
    private final RString バッチID;
    private final RString 集計番号;

    /**
     * コンストラクタです。
     *
     * @param プリントコントロール区分 プリントコントロール区分
     * @param 作成CSVファイルID 作成CSVファイルID
     * @param 広域フラグ 広域フラグ
     * @param 合併フラグ 合併フラグ
     * @param 市町村コード 市町村コード
     * @param 構成市町村コードList 構成市町村コードList
     * @param 旧市町村コードList 旧市町村コードList
     * @param 対象市町村コードList 対象市町村コードList
     * @param 旧市町村フラグ 旧市町村フラグ
     * @param 集計年月 集計年月
     * @param 給付実績区分コード 給付実績区分コード
     * @param 報告年月 報告年月
     * @param 統計対象区分 統計対象区分
     * @param 処理日時 処理日時
     * @param バッチID バッチID
     * @param 集計番号 集計番号
     */
    public JigyoHokokuGeppoIppanGenbutsuProcessParamter(RString プリントコントロール区分,
            RString 作成CSVファイルID,
            boolean 広域フラグ,
            boolean 合併フラグ,
            RString 市町村コード,
            List<RString> 構成市町村コードList,
            List<RString> 旧市町村コードList,
            List<RString> 対象市町村コードList,
            RString 旧市町村フラグ,
            RString 集計年月,
            RString 給付実績区分コード,
            RString 報告年月,
            RString 統計対象区分,
            RString 処理日時,
            RString バッチID,
            RString 集計番号) {
        this.プリントコントロール区分 = プリントコントロール区分;
        this.作成CSVファイルID = 作成CSVファイルID;
        this.広域フラグ = 広域フラグ;
        this.合併フラグ = 合併フラグ;
        this.市町村コード = 市町村コード;
        this.構成市町村コードList = 構成市町村コードList;
        this.旧市町村コードList = 旧市町村コードList;
        this.対象市町村コードList = 対象市町村コードList;
        this.旧市町村フラグ = 旧市町村フラグ;
        this.集計年月 = 集計年月;
        this.給付実績区分コード = 給付実績区分コード;
        this.報告年月 = 報告年月;
        this.統計対象区分 = 統計対象区分;
        this.処理日時 = 処理日時;
        this.バッチID = バッチID;
        this.集計番号 = 集計番号;
    }

    /**
     * temp事業報告統計元データ作成のmybatisのパラメータを生成します。
     *
     * @return JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter
     */
    public TempJigyoHokokuTokeiMotoDataMybatisParamter toDataMybitisParamter() {
        List<RString> 集計番号List = new ArrayList<>();
        return TempJigyoHokokuTokeiMotoDataMybatisParamter.createDataParam(市町村コード,
                集計年月, 給付実績区分コード, 集計番号List, 構成市町村コードList,
                旧市町村コードList, 広域フラグ, 合併フラグ);
    }

    /**
     * 事業状況報告統計情報の取得処理mybatisのパラメータを生成します。
     *
     * @return JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter
     */
    public KyufuJissekiKonkyoMybatisParamter toSelectDataMybitisParamter() {
        return KyufuJissekiKonkyoMybatisParamter.createDataParam(集計番号,
                new RString("tempJigyoHokokuTokeiMotoData"));
    }

    /**
     * 処理日付管理マスタの登録処理mybatisのパラメータを生成します。
     *
     * @return JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter
     */
    public KyufuJissekiKonkyoMybatisParamter toInsertDataMybitisParamter() {
        return KyufuJissekiKonkyoMybatisParamter.createInsertDataParam(市町村コード,
                RString.EMPTY, null, RString.EMPTY, null,
                プリントコントロール区分, RString.EMPTY, RString.EMPTY, 処理日時);
    }
//
//    /**
//     * 事業状況報告統計帳票用情報の取得処理mybatisのパラメータを生成します。
//     *
//     * @return JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter
//     */
//    public JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter toSelectReportDataMybitisParamter() {
//        return JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter.createSelectReportDataParam(市町村コード,
//                プリントコントロール区分, 集計年度, 過去集計分市町村コードリスト);
//    }
}
