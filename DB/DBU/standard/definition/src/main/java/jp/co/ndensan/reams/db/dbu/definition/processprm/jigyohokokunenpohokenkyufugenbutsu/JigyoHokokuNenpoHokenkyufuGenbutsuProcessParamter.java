/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokunenpohokenkyufugenbutsu;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpohokenkyufugenbutsu.JigyoHokokuNenpoHokenkyufuGenbutsuMybatisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 事業状況報告資料（年報）作成　一般状況（１２～１４）のProcess用パラメータクラスです。
 *
 * @reamsid_L DBU-5600-050 lishengli
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoHokokuNenpoHokenkyufuGenbutsuProcessParamter implements IBatchProcessParameter {

    private final RString プリントコントロール区分;
    private final RString 報告年度;
    private final RString 報告開始年月;
    private final RString 報告終了年月;
    private final RString 集計年度;
    private final RString 集計開始年月;
    private final RString 集計終了年月;
    private final RDateTime 作成日時;
    private final RDateTime 処理日時;
    private final RString 市町村コード;
    private final RString 構成市町村区分;
    private final RString 旧市町村区分;
    private final List<RString> 構成市町村コードリスト;
    private final List<RString> 旧市町村コードリスト;
    private final List<RString> 過去集計分市町村コードリスト;
    private final RString 給付集計区分;
    private final RString 過去集計分旧市町村区分;

    /**
     * コンストラクタです。
     *
     * @param プリントコントロール区分 プリントコントロール区分
     * @param 報告年度 報告年度
     * @param 報告開始年月 報告開始年月
     * @param 報告終了年月 報告終了年月
     * @param 集計年度 集計年度
     * @param 集計開始年月 集計開始年月
     * @param 集計終了年月 集計終了年月
     * @param 作成日時 作成日時
     * @param 処理日時 処理日時
     * @param 市町村コード 市町村コード
     * @param 構成市町村区分 構成市町村区分
     * @param 旧市町村区分 旧市町村区分
     * @param 構成市町村コードリスト 構成市町村コードリスト
     * @param 旧市町村コードリスト 旧市町村コードリスト
     * @param 過去集計分市町村コードリスト 過去集計分市町村コードリスト
     * @param 給付集計区分 給付集計区分
     * @param 過去集計分旧市町村区分 過去集計分旧市町村区分
     */
    public JigyoHokokuNenpoHokenkyufuGenbutsuProcessParamter(
            RString プリントコントロール区分,
            RString 報告年度,
            RString 報告開始年月,
            RString 報告終了年月,
            RString 集計年度,
            RString 集計開始年月,
            RString 集計終了年月,
            RDateTime 作成日時,
            RDateTime 処理日時,
            RString 市町村コード,
            RString 構成市町村区分,
            RString 旧市町村区分,
            List<RString> 構成市町村コードリスト,
            List<RString> 旧市町村コードリスト,
            List<RString> 過去集計分市町村コードリスト,
            RString 給付集計区分,
            RString 過去集計分旧市町村区分) {
        this.プリントコントロール区分 = プリントコントロール区分;
        this.報告年度 = 報告年度;
        this.報告開始年月 = 報告開始年月;
        this.報告終了年月 = 報告終了年月;
        this.集計年度 = 集計年度;
        this.集計開始年月 = 集計開始年月;
        this.集計終了年月 = 集計終了年月;
        this.作成日時 = 作成日時;
        this.処理日時 = 処理日時;
        this.市町村コード = 市町村コード;
        this.構成市町村区分 = 構成市町村区分;
        this.旧市町村区分 = 旧市町村区分;
        this.構成市町村コードリスト = 構成市町村コードリスト;
        this.旧市町村コードリスト = 旧市町村コードリスト;
        this.過去集計分市町村コードリスト = 過去集計分市町村コードリスト;
        this.給付集計区分 = 給付集計区分;
        this.過去集計分旧市町村区分 = 過去集計分旧市町村区分;
    }

    /**
     * 事業報告統計データの削除処理mybatisのパラメータを生成します。
     *
     * @return JigyoHokokuNenpoHokenkyufuGenbutsuMybatisParamter
     */
    public JigyoHokokuNenpoHokenkyufuGenbutsuMybatisParamter toDeleteDataMybitisParamter() {
        return JigyoHokokuNenpoHokenkyufuGenbutsuMybatisParamter.createDeleteDataParam(集計年度,
                市町村コード, 構成市町村区分, 構成市町村コードリスト, 旧市町村区分, 給付集計区分, 旧市町村コードリスト);
    }

    /**
     * 事業状況報告統計情報の取得処理mybatisのパラメータを生成します。
     *
     * @return JigyoHokokuNenpoHokenkyufuGenbutsuMybatisParamter
     */
    public JigyoHokokuNenpoHokenkyufuGenbutsuMybatisParamter toSelectDataMybitisParamter() {
        return JigyoHokokuNenpoHokenkyufuGenbutsuMybatisParamter.createSelectDataParam(集計開始年月,
                集計終了年月, 市町村コード, 構成市町村区分, 構成市町村コードリスト, 旧市町村区分, 給付集計区分, 旧市町村コードリスト);
    }

    /**
     * 処理日付管理マスタの登録処理mybatisのパラメータを生成します。
     *
     * @return JigyoHokokuNenpoHokenkyufuGenbutsuMybatisParamter
     */
    public JigyoHokokuNenpoHokenkyufuGenbutsuMybatisParamter toInsertDataMybitisParamter() {
        return JigyoHokokuNenpoHokenkyufuGenbutsuMybatisParamter.createInsertDataParam(市町村コード,
                構成市町村区分, 構成市町村コードリスト, 旧市町村区分, 給付集計区分, 旧市町村コードリスト,
                プリントコントロール区分, 集計年度, 作成日時, 処理日時);
    }

    /**
     * 事業状況報告統計帳票用情報の取得処理mybatisのパラメータを生成します。
     *
     * @return JigyoHokokuNenpoHokenkyufuGenbutsuMybatisParamter
     */
    public JigyoHokokuNenpoHokenkyufuGenbutsuMybatisParamter toSelectReportDataMybitisParamter() {
        return JigyoHokokuNenpoHokenkyufuGenbutsuMybatisParamter.createSelectReportDataParam(市町村コード,
                プリントコントロール区分, 給付集計区分, 集計年度, 過去集計分市町村コードリスト);
    }
}
