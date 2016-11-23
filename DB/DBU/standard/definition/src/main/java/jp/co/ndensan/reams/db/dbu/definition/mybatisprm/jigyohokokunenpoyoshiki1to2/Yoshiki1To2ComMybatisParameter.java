/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpoyoshiki1to2;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNoyoshiki2;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;

/**
 * 事業状況報告年報　様式１・２のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBU-5610-030 chengsanyuan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class Yoshiki1To2ComMybatisParameter implements IMyBatisParameter {

    private final FlexibleYear 集計年度;
    private final FlexibleDate 基準日;
    private final RString 集計対象月;
    private final Code 表番号;
    private final Code 集計番号;
    private final List<Code> 集計番号List;

    private final FlexibleYear 報告年度;
    private final RString 報告年月;
    private final Decimal 縦番号;
    private final Decimal 横番号;
    private final Decimal 集計結果値;
    private final RString 集計項目名称;
    private final LasdecCode 市町村コード;

    private final boolean is前回処理結果;
    private final boolean is市町村特別給付;

    private static final RString 年月_00 = new RString("00");
    private static final RString 月日_0331 = new RString("0331");

    /**
     * コンストラクタです。
     */
    private Yoshiki1To2ComMybatisParameter(FlexibleYear 集計年度,
            FlexibleDate 基準日, RString 集計対象月, Code 表番号,
            Code 集計番号, List<Code> 集計番号List, FlexibleYear 報告年度,
            RString 報告年月, Decimal 縦番号,
            Decimal 横番号, Decimal 集計結果値, RString 集計項目名称,
            LasdecCode 市町村コード,
            boolean is前回処理結果, boolean is市町村特別給付) {
        this.集計年度 = 集計年度;
        this.基準日 = 基準日;
        this.集計対象月 = 集計対象月;
        this.表番号 = 表番号;
        this.集計番号 = 集計番号;
        this.集計番号List = 集計番号List;
        this.is前回処理結果 = is前回処理結果;
        this.is市町村特別給付 = is市町村特別給付;
        this.報告年度 = 報告年度;
        this.報告年月 = 報告年月;
        this.縦番号 = 縦番号;
        this.横番号 = 横番号;
        this.集計結果値 = 集計結果値;
        this.集計項目名称 = 集計項目名称;
        this.市町村コード = 市町村コード;
    }

    /**
     * 事業状況報告年報　様式１・２の介護賦課・被保険者者台帳取得のパラメータを生成します。
     *
     * @param 集計年度 集計年度
     *
     * @return JigyoHokokuNenpoIppanGenbutsuMybatisParamter
     */
    public static Yoshiki1To2ComMybatisParameter createFukaHihokenshaParam(
            RString 集計年度) {
        FlexibleYear 年度 = new FlexibleYear(集計年度);
        FlexibleDate 基準日 = new FlexibleDate(集計年度.concat(月日_0331));
        return new Yoshiki1To2ComMybatisParameter(
                年度, 基準日, RString.EMPTY, Code.EMPTY, Code.EMPTY, null,
                FlexibleYear.EMPTY, RString.EMPTY,
                Decimal.ONE, Decimal.ONE, Decimal.ONE, RString.EMPTY,
                LasdecCode.EMPTY, false, false);
    }

    /**
     * 前回処理結果データを削除のパラメータを生成します。
     *
     * @param 集計年度 集計年度
     * @param 表番号 表番号
     *
     * @return JigyoHokokuNenpoIppanGenbutsuMybatisParamter
     */
    public static Yoshiki1To2ComMybatisParameter createDelZenkaiSyoriDataParam(
            RString 集計年度, RString 表番号) {
        FlexibleYear 年度 = new FlexibleYear(集計年度);
        return new Yoshiki1To2ComMybatisParameter(
                年度, FlexibleDate.EMPTY,
                年月_00,
                new Code(表番号),
                new Code(ShukeiNo.一般状況_4_所得段階別第１号被保険者数.getコード()), null,
                FlexibleYear.EMPTY,
                RString.EMPTY,
                Decimal.ONE, Decimal.ONE, Decimal.ONE,
                RString.EMPTY, LasdecCode.EMPTY, true, false);
    }

    /**
     * 市町村特別給付を削除のパラメータを生成します。
     *
     * @param 集計年度 集計年度
     * @param 表番号 表番号
     *
     * @return JigyoHokokuNenpoIppanGenbutsuMybatisParamter
     */
    public static Yoshiki1To2ComMybatisParameter createDelShishoconParam(
            RString 集計年度, RString 表番号) {
        FlexibleYear 年度 = new FlexibleYear(集計年度);
        List<Code> list = new ArrayList<>();
        list.add(new Code(ShukeiNoyoshiki2.市町村特別給付_件数.getコード()));
        list.add(new Code(ShukeiNoyoshiki2.市町村特別給付_費用額.getコード()));
        list.add(new Code(ShukeiNoyoshiki2.市町村特別給付_給付額.getコード()));
        return new Yoshiki1To2ComMybatisParameter(
                年度, FlexibleDate.EMPTY,
                年月_00, new Code(表番号),
                Code.EMPTY, list, FlexibleYear.EMPTY,
                RString.EMPTY,
                Decimal.ONE, Decimal.ONE, Decimal.ONE,
                RString.EMPTY, LasdecCode.EMPTY, false, true);
    }

    /**
     * 被保険者数を削除のパラメータを生成します。
     *
     * @param 集計年度 集計年度
     * @param 表番号 表番号
     *
     * @return JigyoHokokuNenpoIppanGenbutsuMybatisParamter
     */
    public static Yoshiki1To2ComMybatisParameter createDelHihokenshaParam(
            RString 集計年度, RString 表番号) {
        FlexibleYear 年度 = new FlexibleYear(集計年度);
        List<Code> list = new ArrayList<>();
        list.add(new Code(ShukeiNo.別紙_1_第1号被保険者のいる世帯数.getコード()));
        list.add(new Code(ShukeiNo.一般状況_1_第1号被保険者数.getコード()));
        list.add(new Code(ShukeiNo.一般状況_2_第1号被保険者増減内訳_当月中増.getコード()));
        list.add(new Code(ShukeiNo.一般状況_2_第2号被保険者増減内訳_当月中減.getコード()));
        return new Yoshiki1To2ComMybatisParameter(
                年度, FlexibleDate.EMPTY,
                年月_00, new Code(表番号),
                Code.EMPTY, list, FlexibleYear.EMPTY,
                RString.EMPTY,
                Decimal.ONE, Decimal.ONE, Decimal.ONE,
                RString.EMPTY, LasdecCode.EMPTY, false, true);
    }

    /**
     * 事業報告統計データに追加のデータを作成する
     *
     * @param 集計年度 集計年度
     * @param 表番号 表番号
     * @param 集計番号 集計番号
     * @param 報告年度 報告年度
     * @param 縦番号 縦番号
     * @param 横番号 横番号
     * @param 集計結果値 集計結果値
     * @param 集計項目名称 集計項目名称
     * @param 市町村コード 市町村コード
     * @return Yoshiki1To2ComMybatisParameter
     */
    public static Yoshiki1To2ComMybatisParameter createInsJigyoHokokuTokeiParam(
            RString 集計年度, Code 表番号,
            Code 集計番号, RString 報告年度,
            Decimal 縦番号,
            Decimal 横番号, Decimal 集計結果値, RString 集計項目名称, RString 市町村コード) {
        return new Yoshiki1To2ComMybatisParameter(new FlexibleYear(集計年度),
                FlexibleDate.EMPTY, 年月_00, 表番号,
                集計番号, null, new FlexibleYear(報告年度), 年月_00,
                縦番号, 横番号, 集計結果値, 集計項目名称, new LasdecCode(市町村コード), true, true);
    }
}
