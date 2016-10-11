/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.ippangenbutsu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.Syorimei;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 事業報告月報_一般現物のMybatisパラメータクラスです。
 *
 * @reamsid_L DBU-5540-030 suguangjun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class JigyoHokokuGeppoIppanGenbutsuMybatisParamter implements IMyBatisParameter {

    private final RString 集計番号;
    private final RString 一時テーブル名;
    private final RString プリントコントロール区分;
    private final RString 市町村コード;
    private final List<RString> 市町村コードList;
    private final List<RString> 集計番号List;
    private final List<RString> 表番号List;
    private final RString サブ業務コード;
    private final RString 処理名;
    private final RString 処理枝番;
    private final RString 年度;
    private final RString 基準年月日;
    private final YMDHMS 基準日時;
    private final RString 構成市町村区分;
    private final List<RString> 構成市町村コードList;
    private final RString 集計年月;
    private final RString 給付集計区分;
    private static final int INDEX = 8;
    private static final int INDEX_4 = 4;
    private static final int INDEX_6 = 6;
    private static final RString 市町村区分_構成市町村 = new RString("1");
    private static final RString 給付集計区分_現物分 = new RString("1");
    private static final RString 給付集計区分_償還分審査 = new RString("2");
    private static final RString 過去集計分旧市町村区分_2 = new RString("2");
    private static final RString 給付集計区分_1 = new RString("1");
    private static final RString 給付集計区分_2 = new RString("2");

    private JigyoHokokuGeppoIppanGenbutsuMybatisParamter(RString 集計番号,
            RString 一時テーブル名,
            RString プリントコントロール区分,
            RString 市町村コード,
            List<RString> 市町村コードList,
            List<RString> 集計番号List,
            List<RString> 表番号List,
            RString サブ業務コード,
            RString 処理名,
            RString 処理枝番,
            RString 年度,
            RString 基準年月日,
            YMDHMS 基準日時,
            RString 構成市町村区分,
            List<RString> 構成市町村コードList,
            RString 集計年月,
            RString 給付集計区分) {
        this.集計番号 = 集計番号;
        this.一時テーブル名 = 一時テーブル名;
        this.プリントコントロール区分 = プリントコントロール区分;
        this.市町村コード = 市町村コード;
        this.市町村コードList = 市町村コードList;
        this.集計番号List = 集計番号List;
        this.表番号List = 表番号List;
        this.サブ業務コード = サブ業務コード;
        this.処理名 = 処理名;
        this.処理枝番 = 処理枝番;
        this.年度 = 年度;
        this.基準年月日 = 基準年月日;
        this.基準日時 = 基準日時;
        this.構成市町村区分 = 構成市町村区分;
        this.構成市町村コードList = 構成市町村コードList;
        this.集計年月 = 集計年月;
        this.給付集計区分 = 給付集計区分;
    }

    /**
     * temp事業報告統計元データmybatisのパラメータを生成します。
     *
     * @param 構成市町村区分 構成市町村区分
     * @param 構成市町村コードList 構成市町村コードList
     * @param 市町村コード 市町村コード
     * @param 集計年月 集計年月
     * @param 給付集計区分 給付集計区分
     * @return JigyoHokokuGeppoIppanGenbutsuMybatisParamter
     */
    public static JigyoHokokuGeppoIppanGenbutsuMybatisParamter create事業報告統計元データParam(RString 構成市町村区分,
            List<RString> 構成市町村コードList, RString 市町村コード, RString 集計年月, RString 給付集計区分) {
        List<RString> 市町村コードList = new ArrayList<>();
        if (市町村区分_構成市町村.equals(構成市町村区分)) {
            市町村コードList.addAll(構成市町村コードList);
        } else {
            市町村コードList.add(市町村コード);
        }
        return new JigyoHokokuGeppoIppanGenbutsuMybatisParamter(RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, 市町村コードList,
                null, null, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, YMDHMS.now(), RString.EMPTY, null, 集計年月, 給付集計区分);
    }

    /**
     * 事業報告月報_一般現物mybatisのパラメータを生成します。
     *
     * @param 集計番号 集計番号
     * @param 一時テーブル名 一時テーブル名
     * @return KyufuJissekiKonkyoMybatisParamter
     */
    public static JigyoHokokuGeppoIppanGenbutsuMybatisParamter createDataParam(RString 集計番号, RString 一時テーブル名) {
        return new JigyoHokokuGeppoIppanGenbutsuMybatisParamter(集計番号,
                一時テーブル名, RString.EMPTY, RString.EMPTY, null,
                null, null, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, YMDHMS.now(), RString.EMPTY, null, RString.EMPTY, RString.EMPTY);
    }

    /**
     * 処理日付管理マスタの登録処理mybatisのパラメータを生成します。
     *
     * @param 市町村コード 市町村コード
     * @param 構成市町村区分 構成市町村区分
     * @param 構成市町村コードリスト 構成市町村コードリスト
     * @param 集計年月 集計年月
     * @param 給付集計区分 給付集計区分
     * @param 作成日時 作成日時
     * @param 処理日時 処理日時
     *
     * @return JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter
     */
    public static JigyoHokokuGeppoIppanGenbutsuMybatisParamter createInsertDataParam(
            RString 市町村コード,
            RString 構成市町村区分,
            List<RString> 構成市町村コードリスト,
            RString 集計年月,
            RString 給付集計区分,
            RString 作成日時,
            YMDHMS 処理日時) {
        List<RString> 市町村コードリスト = new ArrayList<>();
        市町村コードリスト.add(市町村コード);
        RString 処理名 = RString.EMPTY;
        if (給付集計区分_現物分.equals(給付集計区分)) {
            処理名 = Syorimei.月報報告一般状況１２_１４現物分.get名称();
        } else if (給付集計区分_償還分審査.equals(給付集計区分)) {
            処理名 = Syorimei.月報報告一般状況１２_１４償還分審査.get名称();
        }
        RString 処理枝番 = RString.EMPTY;
        RString 年度 = RString.EMPTY;
        if (!RString.isNullOrEmpty(集計年月)) {
            処理枝番 = 集計年月.substring(INDEX_4, INDEX_6).concat(new RString("00"));
            年度 = 集計年月.substring(0, INDEX_4);
        }
        RString 基準年月日 = 処理日時.getDate().toDateString();
        YMDHMS 基準日時 = 処理日時;
        return new JigyoHokokuGeppoIppanGenbutsuMybatisParamter(RString.EMPTY, RString.EMPTY, RString.EMPTY, 市町村コード,
                市町村コードリスト, null, null, new RString("DBU"), 処理名, 処理枝番, 年度,
                基準年月日, 基準日時, RString.EMPTY, null, RString.EMPTY, RString.EMPTY);
    }

    /**
     * 事業報告統計データ_12-13mybatisのパラメータを生成します。
     *
     * @param 過去集計分市町村コードList 過去集計分市町村コードList
     * @param 集計年月 集計年月
     * @param 給付集計区分 給付集計区分
     * @param 過去集計分旧市町村区分 過去集計分旧市町村区分
     *
     * @return JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter
     */
    public static JigyoHokokuGeppoIppanGenbutsuMybatisParamter create事業報告統計データ_12_13Param(
            List<RString> 過去集計分市町村コードList,
            RString 集計年月,
            RString 給付集計区分,
            RString 過去集計分旧市町村区分) {
        List<RString> 市町村コードリスト = new ArrayList<>();
        市町村コードリスト.addAll(過去集計分市町村コードList);
        List<RString> 表番号List = new ArrayList<>();
        if (過去集計分旧市町村区分_2.equals(過去集計分旧市町村区分)) {
            if (給付集計区分_1.equals(給付集計区分)) {
                表番号List.add(new RString("11"));
            } else if (給付集計区分_2.equals(給付集計区分)) {
                表番号List.add(new RString("13"));
            }
        } else {
            if (給付集計区分_1.equals(給付集計区分)) {
                表番号List.add(new RString("01"));
            } else if (給付集計区分_2.equals(給付集計区分)) {
                表番号List.add(new RString("03"));
            }
        }
        List<RString> 集計番号List = new ArrayList<>();
        集計番号List.add(ShukeiNo.toValue(new RString("1200")).getコード());
        集計番号List.add(ShukeiNo.toValue(new RString("1400")).getコード());
        return new JigyoHokokuGeppoIppanGenbutsuMybatisParamter(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                市町村コードリスト, 集計番号List, 表番号List, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, YMDHMS.now(), RString.EMPTY, null, 集計年月, 給付集計区分);
    }

    /**
     * 事業報告統計データ_12-13mybatisのパラメータを生成します。
     *
     * @param 過去集計分市町村コードList 過去集計分市町村コードList
     * @param 集計年月 集計年月
     * @param 給付集計区分 給付集計区分
     * @param 過去集計分旧市町村区分 過去集計分旧市町村区分
     *
     * @return JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter
     */
    public static JigyoHokokuGeppoIppanGenbutsuMybatisParamter create事業報告統計データ_14Param(
            List<RString> 過去集計分市町村コードList,
            RString 集計年月,
            RString 給付集計区分,
            RString 過去集計分旧市町村区分) {
        List<RString> 市町村コードリスト = new ArrayList<>();
        市町村コードリスト.addAll(過去集計分市町村コードList);
        List<RString> 表番号List = new ArrayList<>();
        if (過去集計分旧市町村区分_2.equals(過去集計分旧市町村区分)) {
            if (給付集計区分_1.equals(給付集計区分)) {
                表番号List.add(new RString("11"));
            } else if (給付集計区分_2.equals(給付集計区分)) {
                表番号List.add(new RString("13"));
            }
        } else {
            if (給付集計区分_1.equals(給付集計区分)) {
                表番号List.add(new RString("01"));
            } else if (給付集計区分_2.equals(給付集計区分)) {
                表番号List.add(new RString("03"));
            }
        }
        List<RString> 集計番号List = new ArrayList<>();
        集計番号List.add(ShukeiNo.toValue(new RString("1391")).getコード());
        集計番号List.add(ShukeiNo.toValue(new RString("1392")).getコード());
        集計番号List.add(ShukeiNo.toValue(new RString("1393")).getコード());
        return new JigyoHokokuGeppoIppanGenbutsuMybatisParamter(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                市町村コードリスト, 集計番号List, 表番号List, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, YMDHMS.now(), RString.EMPTY, null, 集計年月, 給付集計区分);
    }
}
