/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokunenpohokenkyufukogaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpohokenkyufukogaku.JigyoHokokuNenpoHokenkyufuKogakuMybatisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 事業状況報告資料（年報）作成　保険給付決定状況(高額分)のProcess用パラメータクラスです。
 *
 * @reamsid_L DBU-5600-060 lishengli
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoHokokuNenpoHokenkyufuKogakuProcessParamter implements IBatchProcessParameter {

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
     * @param 過去集計分旧市町村区分 過去集計分旧市町村区分
     */
    public JigyoHokokuNenpoHokenkyufuKogakuProcessParamter(
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
        this.過去集計分旧市町村区分 = 過去集計分旧市町村区分;
    }

    /**
     * 事業報告統計データの削除処理mybatisのパラメータを生成します。
     *
     * @return JigyoHokokuNenpoHokenkyufuKogakuMybatisParamter
     */
    public JigyoHokokuNenpoHokenkyufuKogakuMybatisParamter toDeleteDataMybitisParamter() {
        return JigyoHokokuNenpoHokenkyufuKogakuMybatisParamter.createDeleteDataParam(集計年度,
                市町村コード, 構成市町村区分, 構成市町村コードリスト, 旧市町村区分, 旧市町村コードリスト);
    }

    /**
     * 事業状況報告統計情報の取得処理mybatisのパラメータを生成します。
     *
     * @return JigyoHokokuNenpoHokenkyufuKogakuMybatisParamter
     */
    public JigyoHokokuNenpoHokenkyufuKogakuMybatisParamter toSelectDataMybitisParamter() {
        return JigyoHokokuNenpoHokenkyufuKogakuMybatisParamter.createSelectDataParam(集計開始年月,
                集計終了年月, 市町村コード, 構成市町村区分, 構成市町村コードリスト, 旧市町村区分, 旧市町村コードリスト);
    }

    /**
     * 処理日付管理マスタの登録処理mybatisのパラメータを生成します。
     *
     * @return JigyoHokokuNenpoHokenkyufuKogakuMybatisParamter
     */
    public JigyoHokokuNenpoHokenkyufuKogakuMybatisParamter toInsertDataMybitisParamter() {
        return JigyoHokokuNenpoHokenkyufuKogakuMybatisParamter.createInsertDataParam(市町村コード,
                構成市町村区分, 構成市町村コードリスト, 旧市町村区分, 旧市町村コードリスト,
                プリントコントロール区分, 集計年度, 作成日時, 処理日時);
    }

    /**
     * 事業状況報告統計帳票用情報の取得処理mybatisのパラメータを生成します。
     *
     * @return JigyoHokokuNenpoHokenkyufuKogakuMybatisParamter
     */
    public JigyoHokokuNenpoHokenkyufuKogakuMybatisParamter toSelectReportDataMybitisParamter() {
        return JigyoHokokuNenpoHokenkyufuKogakuMybatisParamter.createSelectReportDataParam(市町村コード,
                プリントコントロール区分, 集計年度, 過去集計分市町村コードリスト);
    }
}
