/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.hokenkyufushokankettei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.PrintControlKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNoyoshiki2;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.Syorimei;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;

/**
 * 保険給付【償還_決定】のMybatisパラメータクラスです。
 *
 * @reamsid_L DBU-5570-030 xuyannan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter implements IMyBatisParameter {

    private static final RString 市町村コード区分 = new RString("1");
    private static final int INDEX8 = 8;
    private final RString プリントコントロール区分;
    private final RString 審査年月;
    private final RString 集計年月;
    private final RString 市町村コード;
    private final RString 旧市町村コード;
    private final RString 構成市町村区分;
    private final RString 旧市町村区分;
    private final List<RString> 構成市町村コードリスト;
    private final List<RString> 旧市町村コードリスト;
    private final List<RString> 市町村コードリスト;
    private final RString 作成日付;
    private final YMDHMS 処理日時;
    private final RString サブ業務コード;
    private final RString 処理名;
    private final RString 処理枝番;
    private final RString 集計年度;
    private final RString 基準年月日;
    private final RString 基準日時;
    private final List<RString> 集計番号List;
    private final RString 報告年月;
    private final RString 表番号;
    private final RString 集計番号;
    private final int 縦軸index;
    private final int 横軸index;
    private final Decimal 集計結果値;
    private final RString 統計対象区分;
    private final RString 報告年度;
    private final List<RString> 表番号List;

    /**
     * コンストラクタです。
     *
     */
    private JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter(
            RString プリントコントロール区分,
            RString 審査年月,
            RString 集計年月,
            RString 市町村コード,
            RString 旧市町村コード,
            RString 構成市町村区分,
            RString 旧市町村区分,
            List<RString> 構成市町村コードリスト,
            List<RString> 旧市町村コードリスト,
            List<RString> 市町村コードリスト,
            RString 作成日付,
            YMDHMS 処理日時,
            RString サブ業務コード,
            RString 処理名,
            RString 処理枝番,
            RString 集計年度,
            RString 基準年月日,
            RString 基準日時,
            List<RString> 集計番号List,
            RString 報告年月,
            RString 表番号,
            RString 集計番号,
            int 縦軸index,
            int 横軸index,
            Decimal 集計結果値,
            RString 統計対象区分,
            RString 報告年度,
            List<RString> 表番号List) {
        this.プリントコントロール区分 = プリントコントロール区分;
        this.審査年月 = 審査年月;
        this.集計年月 = 集計年月;
        this.市町村コード = 市町村コード;
        this.旧市町村コード = 旧市町村コード;
        this.構成市町村区分 = 構成市町村区分;
        this.旧市町村区分 = 旧市町村区分;
        this.構成市町村コードリスト = 構成市町村コードリスト;
        this.旧市町村コードリスト = 旧市町村コードリスト;
        this.市町村コードリスト = 市町村コードリスト;
        this.作成日付 = 作成日付;
        this.処理日時 = 処理日時;
        this.サブ業務コード = サブ業務コード;
        this.処理名 = 処理名;
        this.処理枝番 = 処理枝番;
        this.集計年度 = 集計年度;
        this.基準年月日 = 基準年月日;
        this.基準日時 = 基準日時;
        this.集計番号List = 集計番号List;
        this.報告年月 = 報告年月;
        this.表番号 = 表番号;
        this.集計番号 = 集計番号;
        this.縦軸index = 縦軸index;
        this.横軸index = 横軸index;
        this.集計結果値 = 集計結果値;
        this.統計対象区分 = 統計対象区分;
        this.報告年度 = 報告年度;
        this.表番号List = 表番号List;
    }

    /**
     * 保険給付【償還_決定】の根拠CSV情報作成処理mybatisのパラメータを生成します。
     *
     * @param 集計年月 集計年月
     * @return JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter
     */
    public static JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter create根拠CSV情報作成Paramter(
            RString 集計年月) {
        return new JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter(
                RString.EMPTY,
                RString.EMPTY,
                集計年月,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                null,
                null,
                null,
                RString.EMPTY,
                YMDHMS.now(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                null,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                0,
                0,
                Decimal.ZERO,
                RString.EMPTY,
                RString.EMPTY,
                null);
    }

    /**
     * 処理日付管理マスタへ登録処理mybatisのパラメータを生成します。
     *
     * @param 集計年月 集計年月
     * @param 市町村コード 市町村コード
     * @param 構成市町村区分 構成市町村区分
     * @param 旧市町村区分 旧市町村区分
     * @param 構成市町村コードリスト 構成市町村コードリスト
     * @param 旧市町村コードリスト 旧市町村コードリスト
     * @param 作成日付 作成日付
     * @param 処理日時 処理日時
     * @param プリントコントロール区分 プリントコントロール区分
     * @return JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter
     */
    public static JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter create処理日付管理マスタへ登録Paramter(
            RString 集計年月,
            RString 市町村コード,
            RString 構成市町村区分,
            RString 旧市町村区分,
            List<RString> 構成市町村コードリスト,
            List<RString> 旧市町村コードリスト,
            RString 作成日付,
            YMDHMS 処理日時,
            RString プリントコントロール区分) {
        List<RString> 市町村コードList = new ArrayList<>();
        RString 基準年月日 = RString.EMPTY;
        RString 基準日時 = RString.EMPTY;
        市町村コードList.add(市町村コード);
        if (市町村コード区分.equals(構成市町村区分)) {
            市町村コードList.addAll(構成市町村コードリスト);
        } else if (市町村コード区分.equals(旧市町村区分)) {
            市町村コードList.addAll(旧市町村コードリスト);
        }
        if (PrintControlKubun.集計のみ.getコード().equals(プリントコントロール区分)
                || PrintControlKubun.集計後印刷.getコード().equals(プリントコントロール区分)) {
            基準年月日 = 処理日時.toDateString();
            基準日時 = new RString(処理日時.toString());
        } else if (PrintControlKubun.過去分の印刷.getコード().equals(プリントコントロール区分)) {
            基準年月日 = 作成日付.substring(0, INDEX8);
            基準日時 = 作成日付;
        }
        return new JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter(
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                null,
                null,
                市町村コードList,
                RString.EMPTY,
                YMDHMS.now(),
                new RString("DBU"),
                Syorimei.月報報告保険給付決定償還分決定.get名称(),
                new RString("0099"),
                new FlexibleYearMonth(集計年月).getNendo().toDateString(),
                基準年月日,
                基準日時,
                null,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                0,
                0,
                Decimal.ZERO,
                RString.EMPTY,
                RString.EMPTY,
                null);
    }

    /**
     * 保険給付【償還_決定】の根拠CSV情報作成処理mybatisのパラメータを生成します。
     *
     * @param 市町村コードList 市町村コードList
     * @param 集計年月 集計年月
     * @param 表番号List 表番号List
     * @return JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter
     */
    public static JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter create事業状況報告取得Paramter(
            List<RString> 市町村コードList,
            RString 集計年月,
            List<RString> 表番号List) {
        return new JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter(
                RString.EMPTY,
                RString.EMPTY,
                集計年月,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                null,
                null,
                市町村コードList,
                RString.EMPTY,
                YMDHMS.now(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                get集計番号List(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                0,
                0,
                Decimal.ZERO,
                RString.EMPTY,
                RString.EMPTY,
                表番号List);
    }

    /**
     * 事業報告統計データ削除処理mybatisのパラメータを生成します。
     *
     * @param 集計年月 集計年月
     * @return JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter
     */
    public static JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter delete事業状況報告取得Paramter(RString 集計年月) {
        return new JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter(
                RString.EMPTY,
                new RString(new FlexibleYearMonth(集計年月).getMonthValue()),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                null,
                null,
                null,
                RString.EMPTY,
                YMDHMS.now(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                new FlexibleYearMonth(集計年月).getNendo().toDateString(),
                RString.EMPTY,
                RString.EMPTY,
                get集計番号List(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                0,
                0,
                Decimal.ZERO,
                RString.EMPTY,
                RString.EMPTY,
                null);
    }

    /**
     * 集計結果値取得処理mybatisのパラメータを生成します。
     *
     * @param 市町村コード 市町村コード
     * @param 旧町村コード 旧町村コード
     * @param 構成市町村区分 構成市町村区分
     * @param 旧市町村区分 旧市町村区分
     * @param 縦軸index 縦軸index
     * @param 横軸index 横軸index
     * @return JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter
     */
    public static JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter get集計結果値のParameter(
            RString 市町村コード,
            RString 旧町村コード,
            RString 構成市町村区分,
            RString 旧市町村区分,
            int 縦軸index,
            int 横軸index) {
        return new JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter(
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                市町村コード,
                旧町村コード,
                構成市町村区分,
                旧市町村区分,
                null,
                null,
                null,
                RString.EMPTY,
                YMDHMS.now(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                null,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                縦軸index,
                横軸index,
                Decimal.ZERO,
                RString.EMPTY,
                RString.EMPTY,
                null);
    }

    /**
     * 事業報告統計データ更新処理mybatisのパラメータを生成します。
     *
     * @param 市町村コード 市町村コード
     * @param 旧町村コード 旧町村コード
     * @param 構成市町村区分 構成市町村区分
     * @param 旧市町村区分 旧市町村区分
     * @param 報告年月 報告年月
     * @param 集計年月 集計年月
     * @param 表番号 表番号
     * @param 集計番号 集計番号
     * @param 縦軸index 縦軸index
     * @param 横軸index 横軸index
     * @param 集計結果値 集計結果値
     * @param 統計対象区分 統計対象区分
     * @return JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter
     */
    public static JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter set事業報告統計データのParameter(
            RString 市町村コード,
            RString 旧町村コード,
            RString 構成市町村区分,
            RString 旧市町村区分,
            RString 報告年月,
            RString 集計年月,
            RString 表番号,
            RString 集計番号,
            int 縦軸index,
            int 横軸index,
            Decimal 集計結果値,
            RString 統計対象区分) {
        return new JigyoHokokuRenkeiHokenkyufuShokanKetteiMybatisParameter(
                RString.EMPTY,
                RString.EMPTY,
                new RString(new FlexibleYearMonth(集計年月).getMonthValue()),
                市町村コード,
                旧町村コード,
                構成市町村区分,
                旧市町村区分,
                null,
                null,
                null,
                RString.EMPTY,
                YMDHMS.now(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                new FlexibleYearMonth(集計年月).getNendo().toDateString(),
                RString.EMPTY,
                RString.EMPTY,
                null,
                new RString(new FlexibleYearMonth(報告年月).getMonthValue()),
                表番号,
                集計番号,
                縦軸index,
                横軸index,
                集計結果値,
                統計対象区分,
                new FlexibleYearMonth(報告年月).getNendo().toDateString(),
                null);
    }

    private static List<RString> get集計番号List() {
        List<RString> 集計番号List = new ArrayList<>();
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付1総数_件数.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付1総数_単位数.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付1総数_費用額.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付1総数_給付費.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付2二割負担被保険者分_再掲_件数.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付2二割負担被保険者分_再掲_単位数.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付2二割負担被保険者分_再掲_費用額.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付2二割負担被保険者分_再掲_給付費.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付2第２号被保険者分_再掲_件数.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付2第２号被保険者分_再掲_単位数.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付2第２号被保険者分_再掲_費用額.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付2第２号被保険者分_再掲_給付費.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付3総数_特例分_件数.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付3総数_特例分_単位数.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付3総数_特例分_費用額.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付3総数_特例分_給付費.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付4第２号被保険者分_再掲_特例分_件数.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付4第２号被保険者分_再掲_特例分_単位数.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付4第２号被保険者分_再掲_特例分_費用額.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付4第２号被保険者分_再掲_特例分_給付費.getコード());
        集計番号List.add(ShukeiNoyoshiki2._2_特定入所者介護_介護予防_サービス費1総数_件数.getコード());
        集計番号List.add(ShukeiNoyoshiki2._2_特定入所者介護_介護予防_サービス費1総数_給付費.getコード());
        集計番号List.add(ShukeiNoyoshiki2._2_特定入所者介護_介護予防_サービス費2第２号被保険者分_件数.getコード());
        集計番号List.add(ShukeiNoyoshiki2._2_特定入所者介護_介護予防_サービス費2第２号被保険者分_給付費.getコード());
        return 集計番号List;
    }
}
