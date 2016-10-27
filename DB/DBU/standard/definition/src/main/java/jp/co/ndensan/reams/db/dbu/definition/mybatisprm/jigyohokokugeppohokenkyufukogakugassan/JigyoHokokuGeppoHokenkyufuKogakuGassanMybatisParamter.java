/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppohokenkyufukogakugassan;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 事業状況報告資料（月報）作成 保険給付決定状況（高額合算分）のMybatisパラメータクラスです。
 *
 * @reamsid_L DBU-5590-030 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter implements IMyBatisParameter {

    private final RString 開始年月;
    private final RString 終了年月;
    private final List<RString> 旧市町村コードリスト;
    private final RString 決定年月;
    private final RString 集計番号;
    private final List<RString> 市町村コードリスト;
    private final RString 集計年月;
    private final List<RString> 集計番号リスト;
    private final List<RString> 表番号リスト;
    private final RString サブ業務コード;
    private final RString 処理名;
    private final RString 処理枝番;
    private final RString 年度;
    private final RString 基準年月日;
    private final YMDHMS 基準日時;

    private JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter(RString 開始年月, RString 終了年月, List<RString> 旧市町村コードリスト,
            RString 決定年月, RString 集計番号, List<RString> 市町村コードリスト, RString 集計年月, List<RString> 集計番号リスト,
            List<RString> 表番号リスト, RString サブ業務コード, RString 処理名, RString 処理枝番, RString 年度,
            RString 基準年月日, YMDHMS 基準日時) {
        this.開始年月 = 開始年月;
        this.終了年月 = 終了年月;
        this.旧市町村コードリスト = 旧市町村コードリスト;
        this.決定年月 = 決定年月;
        this.集計番号 = 集計番号;
        this.市町村コードリスト = 市町村コードリスト;
        this.集計年月 = 集計年月;
        this.集計番号リスト = 集計番号リスト;
        this.表番号リスト = 表番号リスト;
        this.サブ業務コード = サブ業務コード;
        this.処理名 = 処理名;
        this.処理枝番 = 処理枝番;
        this.年度 = 年度;
        this.基準年月日 = 基準年月日;
        this.基準日時 = 基準日時;
    }

    /**
     * 事業状況報告統計元データ作成のパラメータを生成します。
     *
     * @param 開始年月 開始年月
     * @param 終了年月 終了年月
     * @return JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter
     */
    public static JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter createInsertKougakuDataParam(RString 開始年月, RString 終了年月) {
        return new JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter(開始年月, 終了年月, null, RString.EMPTY, RString.EMPTY, null,
                RString.EMPTY, null, null, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, null);
    }

    /**
     * 処理結果確認リスト情報のパラメータを生成します。
     *
     * @param 旧市町村コードリスト 旧市町村コードリスト
     * @return JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter
     */
    public static JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter createShoriKekkaListDataParam(List<RString> 旧市町村コードリスト) {
        return new JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter(RString.EMPTY, RString.EMPTY, 旧市町村コードリスト, RString.EMPTY,
                RString.EMPTY, null, RString.EMPTY, null, null, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, null);
    }

    /**
     * 事業状況報告統計元データ作成のパラメータを生成します。
     *
     * @param 集計番号 集計番号
     * @param 決定年月 決定年月
     * @return JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter
     */
    public static JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter createInsertKougakuCSVDataParam(RString 集計番号, RString 決定年月) {
        return new JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter(RString.EMPTY, RString.EMPTY, null, 決定年月, 集計番号, null,
                RString.EMPTY, null, null, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, null);
    }

    /**
     * 事業報告統計データの削除処理mybatisのパラメータを生成します。
     *
     * @param 市町村コードList 市町村コードList
     * @param 集計年月 集計年月
     * @param 集計番号List 集計番号List
     * @param 表番号List 表番号List
     *
     * @return JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter
     */
    public static JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter createDeleteDataParam(List<RString> 市町村コードList, RString 集計年月,
            List<RString> 集計番号List, List<RString> 表番号List) {
        return new JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter(RString.EMPTY, RString.EMPTY, null, RString.EMPTY,
                RString.EMPTY, 市町村コードList, 集計年月, 集計番号List, 表番号List, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, null);
    }

    /**
     * 事業状況報告統計情報処理mybatisのパラメータを生成します。
     *
     * @param 市町村コードList 市町村コードList
     * @param 集計年月 集計年月
     *
     * @return JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter
     */
    public static JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter createSelectDataParam(List<RString> 市町村コードList, RString 集計年月) {
        return new JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter(RString.EMPTY, RString.EMPTY, null, RString.EMPTY,
                RString.EMPTY, 市町村コードList, 集計年月, null, null, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, null);
    }

    /**
     * 処理日付管理マスタへ登録処理mybatisのパラメータを生成します。
     *
     * @param 市町村コードList 市町村コードList
     * @param 処理名 処理名
     * @param 処理枝番 処理枝番
     * @param 年度 年度
     * @param 基準年月日 基準年月日
     * @param 基準日時 基準日時
     *
     * @return JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter
     */
    public static JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter createInsertShoriDataParam(List<RString> 市町村コードList,
            RString 処理名, RString 処理枝番, RString 年度, RString 基準年月日, YMDHMS 基準日時) {
        return new JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter(RString.EMPTY, RString.EMPTY, null, RString.EMPTY,
                RString.EMPTY, 市町村コードList, RString.EMPTY, null, null, new RString("DBU"), 処理名, 処理枝番,
                年度, 基準年月日, 基準日時);
    }

    /**
     * 事業状況報告統計情報の取得処理mybatisのパラメータを生成します。
     *
     * @param 市町村コードリスト 市町村コードリスト
     * @param 集計年月 集計年月
     * @param 集計番号リスト 集計番号リスト
     * @param 表番号リスト 表番号リスト
     * @return JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter
     */
    public static JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter createJigyohokokuCompYoshikiDataParam(List<RString> 市町村コードリスト,
            RString 集計年月, List<RString> 集計番号リスト, List<RString> 表番号リスト) {
        return new JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter(RString.EMPTY, RString.EMPTY, null, RString.EMPTY,
                RString.EMPTY, 市町村コードリスト, 集計年月, 集計番号リスト, 表番号リスト, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, null);
    }
}
