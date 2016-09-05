/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppohokenkyufukogaku;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 事業状況報告資料（月報）作成 保険給付決定情報（高額介護サービス費）のMybatisパラメータクラスです。
 *
 * @reamsid_L DBU-5580-030 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter implements IMyBatisParameter {

    private final List<RString> 市町村コードリスト;
    private final RString 集計年月;
    private final List<RString> 集計番号リスト;
    private final List<RString> 表番号リスト;
    private final List<RString> 旧市町村コードリスト;
    private final RString 年度;
    private final RString 基準年月日;
    private final YMDHMS 基準日時;
    private final RString サブ業務コード;
    private final RString 処理名;

    /**
     * コンストラクタです。
     *
     * @param 市町村コードリスト 市町村コードリスト
     * @param 集計年月 集計年月
     * @param 集計番号リスト 集計番号リスト
     * @param 表番号リスト 表番号リスト
     * @param 旧市町村コードリスト 旧市町村コードリスト
     * @param 年度 年度
     * @param 基準年月日 基準年月日
     * @param 基準日時 基準日時
     * @param サブ業務コード サブ業務コード
     * @param 処理名 処理名
     */
    private JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter(List<RString> 市町村コードリスト, RString 集計年月,
            List<RString> 集計番号リスト, List<RString> 表番号リスト, List<RString> 旧市町村コードリスト, RString 年度,
            RString 基準年月日, YMDHMS 基準日時, RString サブ業務コード, RString 処理名) {
        this.市町村コードリスト = 市町村コードリスト;
        this.集計年月 = 集計年月;
        this.集計番号リスト = 集計番号リスト;
        this.表番号リスト = 表番号リスト;
        this.旧市町村コードリスト = 旧市町村コードリスト;
        this.年度 = 年度;
        this.基準年月日 = 基準年月日;
        this.基準日時 = 基準日時;
        this.サブ業務コード = サブ業務コード;
        this.処理名 = 処理名;
    }

    /**
     * 事業状況報告統計情報の取得処理mybatisのパラメータを生成します。
     *
     * @param 市町村コードリスト 市町村コードリスト
     * @param 集計年月 集計年月
     * @param 集計番号リスト 集計番号リスト
     * @param 表番号リスト 表番号リスト
     * @return JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter
     */
    public static JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter createJigyohokokuCompYoshikiDataParam(List<RString> 市町村コードリスト,
            RString 集計年月, List<RString> 集計番号リスト, List<RString> 表番号リスト) {
        return new JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter(市町村コードリスト, 集計年月, 集計番号リスト, 表番号リスト, null,
                RString.EMPTY, RString.EMPTY, YMDHMS.now(), RString.EMPTY, RString.EMPTY);
    }

    /**
     * 事業状況報告統計元データ作成のパラメータを生成します。
     *
     * @param 集計年月 集計年月
     * @return JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter
     */
    public static JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter createInsertKougakuDataParam(RString 集計年月) {
        return new JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter(null, 集計年月, null, null, null,
                RString.EMPTY, RString.EMPTY, YMDHMS.now(), RString.EMPTY, RString.EMPTY);
    }

    /**
     * 処理結果確認リスト情報のパラメータを生成します。
     *
     * @param 旧市町村コードリスト 旧市町村コードリスト
     * @return JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter
     */
    public static JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter createShoriKekkaListDataParam(List<RString> 旧市町村コードリスト) {
        return new JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter(null, RString.EMPTY, null, null, 旧市町村コードリスト,
                RString.EMPTY, RString.EMPTY, YMDHMS.now(), RString.EMPTY, RString.EMPTY);
    }

    /**
     * 事業報告統計データの削除処理mybatisのパラメータを生成します。
     *
     * @param 市町村コードList 市町村コードList
     * @param 集計年月 集計年月
     * @param 集計番号List 集計番号List
     * @param 表番号List 表番号List
     *
     * @return JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter
     */
    public static JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter createDeleteDataParam(List<RString> 市町村コードList, RString 集計年月,
            List<RString> 集計番号List, List<RString> 表番号List) {
        return new JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter(市町村コードList, 集計年月, 集計番号List, 表番号List, null,
                RString.EMPTY, RString.EMPTY, YMDHMS.now(), RString.EMPTY, RString.EMPTY);
    }

    /**
     * 処理日付管理マスタへ登録処理mybatisのパラメータを生成します。
     *
     * @param 市町村コードList 市町村コードList
     * @param 処理枝番 処理枝番
     * @param 年度 年度
     * @param 基準年月日 基準年月日
     * @param 基準日時 基準日時
     *
     * @return JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter
     */
    public static JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter createInsertShoriDataParam(List<RString> 市町村コードList, RString 処理枝番,
            RString 年度, RString 基準年月日, YMDHMS 基準日時) {
        return new JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter(市町村コードList, 処理枝番, null, null, null,
                年度, 基準年月日, 基準日時, new RString("DBU"), new RString("月報報告　保険給付決定　高額介護サービス費分"));
    }

    /**
     * 事業状況報告統計情報処理mybatisのパラメータを生成します。
     *
     * @param 市町村コードList 市町村コードList
     * @param 集計年月 集計年月
     * @param 集計番号List 集計番号List
     *
     * @return JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter
     */
    public static JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter createSelectDataParam(List<RString> 市町村コードList, RString 集計年月,
            List<RString> 集計番号List) {
        return new JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter(市町村コードList, 集計年月, 集計番号List, null, null,
                RString.EMPTY, RString.EMPTY, YMDHMS.now(), RString.EMPTY, RString.EMPTY);
    }
}
