/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.ippanshokanketteiym;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.HyoNo;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.PrintControlKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.Syorimei;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 事業報告月報_一般状況のMybatisパラメータクラスです。
 *
 * @reamsid_L DBU-5550-030 suguangjun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class JigyoHokokuGeppoIppanShokanMybatisParamter implements IMyBatisParameter {

    private final Code 集計番号;
    private final RString 決定年月;
    private final RString プリントコントロール区分;
    private final List<RString> 旧市町村コードList;
    private final List<RString> 市町村コードList;
    private final RString 市町村コード;
    private final RString 構成市町村区分;
    private final RString 旧市町村区分;
    private final List<RString> 集計番号リスト;
    private final List<RString> 表番号リスト;
    private final RString サブ業務コード;
    private final RString 処理名;
    private final RString 処理枝番;
    private final RString 年度;
    private final RString 基準年月日;
    private final RString 基準日時;
    private static final int INDEX = 8;
    private static final RString 市町村区分_構成市町村 = new RString("1");
    private static final RString 市町村区分_旧市町村 = new RString("1");

    private JigyoHokokuGeppoIppanShokanMybatisParamter(Code 集計番号,
            RString 決定年月,
            RString プリントコントロール区分,
            List<RString> 旧市町村コードList,
            List<RString> 市町村コードList,
            RString 市町村コード,
            RString 構成市町村区分,
            RString 旧市町村区分,
            List<RString> 集計番号リスト,
            List<RString> 表番号リスト,
            RString サブ業務コード,
            RString 処理名,
            RString 処理枝番,
            RString 年度,
            RString 基準年月日,
            RString 基準日時) {
        this.集計番号 = 集計番号;
        this.決定年月 = 決定年月;
        this.プリントコントロール区分 = プリントコントロール区分;
        this.市町村コード = 市町村コード;
        this.旧市町村コードList = 旧市町村コードList;
        this.市町村コードList = 市町村コードList;
        this.集計番号リスト = 集計番号リスト;
        this.構成市町村区分 = 構成市町村区分;
        this.旧市町村区分 = 旧市町村区分;
        this.表番号リスト = 表番号リスト;
        this.サブ業務コード = サブ業務コード;
        this.処理名 = 処理名;
        this.処理枝番 = 処理枝番;
        this.年度 = 年度;
        this.基準年月日 = 基準年月日;
        this.基準日時 = 基準日時;
    }

    /**
     * 事業報告月報_一般状況mybatisのパラメータを生成します。
     *
     * @param 集計番号 集計番号
     * @param 決定年月 決定年月
     * @param 旧市町村区分 旧市町村区分
     * @param 旧市町村コードList 旧市町村コードList
     * @return JigyoHokokuGeppoIppanShokanMybatisParamter
     */
    public static JigyoHokokuGeppoIppanShokanMybatisParamter createDataParam(Code 集計番号,
            RString 決定年月, RString 旧市町村区分, List<RString> 旧市町村コードList) {
        List<RString> 旧市町村コードリスト = new ArrayList<>();
        if (市町村区分_旧市町村.equals(旧市町村区分)) {
            旧市町村コードリスト.addAll(旧市町村コードList);
        }
        return new JigyoHokokuGeppoIppanShokanMybatisParamter(集計番号,
                決定年月, RString.EMPTY, 旧市町村コードリスト, null,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, null, null, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
    }

    /**
     * 事業状況報告統計情報の削除処理mybatisのパラメータを生成します。
     *
     * @param 決定年月 決定年月
     * @param 市町村コード 市町村コード
     * @param 構成市町村区分 構成市町村区分
     * @param 構成市町村コードリスト 構成市町村コードリスト
     * @param 旧市町村区分 旧市町村区分
     * @param 旧市町村コードリスト 旧市町村コードリスト
     *
     * @return JigyoHokokuGeppoIppanShokanMybatisParamter
     */
    public static JigyoHokokuGeppoIppanShokanMybatisParamter createDelete事業報告統計データParam(
            RString 決定年月,
            RString 市町村コード,
            RString 構成市町村区分,
            List<RString> 構成市町村コードリスト,
            RString 旧市町村区分,
            List<RString> 旧市町村コードリスト) {
        List<RString> 市町村コードリスト = new ArrayList<>();
        市町村コードリスト.add(市町村コード);
        if (市町村区分_構成市町村.equals(構成市町村区分)) {
            市町村コードリスト.addAll(構成市町村コードリスト);
        }
        if (市町村区分_旧市町村.equals(旧市町村区分)) {
            市町村コードリスト.addAll(旧市町村コードリスト);
        }
        return new JigyoHokokuGeppoIppanShokanMybatisParamter(Code.EMPTY,
                決定年月, RString.EMPTY, 旧市町村コードリスト, 市町村コードリスト,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, get集計番号List(), get表番号List(), RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
    }

    /**
     * 事業状況報告統計情報の取得処理mybatisのパラメータを生成します。
     *
     * @param 決定年月 決定年月
     * @param 市町村コード 市町村コード
     * @param 構成市町村区分 構成市町村区分
     * @param 構成市町村コードリスト 構成市町村コードリスト
     * @param 旧市町村区分 旧市町村区分
     * @param 旧市町村コードリスト 旧市町村コードリスト
     *
     * @return JigyoHokokuGeppoIppanShokanMybatisParamter
     */
    public static JigyoHokokuGeppoIppanShokanMybatisParamter createSelect事業報告統計データParam(
            RString 決定年月,
            RString 市町村コード,
            RString 構成市町村区分,
            List<RString> 構成市町村コードリスト,
            RString 旧市町村区分,
            List<RString> 旧市町村コードリスト) {
        List<RString> 市町村コードリスト = new ArrayList<>();
        市町村コードリスト.add(市町村コード);
        if (市町村区分_構成市町村.equals(構成市町村区分)) {
            市町村コードリスト.addAll(構成市町村コードリスト);
        }
        if (市町村区分_旧市町村.equals(旧市町村区分)) {
            市町村コードリスト.addAll(旧市町村コードリスト);
        }
        return new JigyoHokokuGeppoIppanShokanMybatisParamter(Code.EMPTY,
                決定年月, RString.EMPTY, 旧市町村コードリスト, 市町村コードリスト,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, null, null, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
    }

    /**
     * 事業報告月報_一般状況mybatisのパラメータを生成します。
     *
     * @param 対象市町村コードList 対象市町村コードList
     * @param 決定年月 決定年月
     * @return JigyoHokokuGeppoIppanShokanMybatisParamter
     */
    public static JigyoHokokuGeppoIppanShokanMybatisParamter create事業報告統計データ_12_13Param(
            RString 決定年月, List<RString> 対象市町村コードList) {
        List<RString> 集計番号List = new ArrayList<>();
        集計番号List.add(ShukeiNo.一般状況_12_居宅介護_介護予防_サービス受給者数.getコード());
        集計番号List.add(ShukeiNo.一般状況_13_地域密着型_介護予防_サービス受給者数.getコード());
        List<RString> 表番号List = new ArrayList<>();
        表番号List.add(HyoNo.償還_決定年月_一般状況.getコード());
        表番号List.add(HyoNo.償還_決定年月_一般状況_旧市町村.getコード());
        return new JigyoHokokuGeppoIppanShokanMybatisParamter(Code.EMPTY,
                決定年月, RString.EMPTY, null, 対象市町村コードList,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, 集計番号List, 表番号List, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
    }

    /**
     * 事業報告月報_一般状況mybatisのパラメータを生成します。
     *
     * @param 対象市町村コードList 対象市町村コードList
     * @param 決定年月 決定年月
     * @return JigyoHokokuGeppoIppanShokanMybatisParamter
     */
    public static JigyoHokokuGeppoIppanShokanMybatisParamter create事業報告統計データ_14Param(
            RString 決定年月, List<RString> 対象市町村コードList) {
        List<RString> 集計番号List = new ArrayList<>();
        集計番号List.add(ShukeiNo.一般状況_14_施設介護サービス受給者数_介護老人福祉施設.getコード());
        集計番号List.add(ShukeiNo.一般状況_15_施設介護サービス受給者数_介護老人保健施設.getコード());
        集計番号List.add(ShukeiNo.一般状況_16_施設介護サービス受給者数_介護療養型医療施設_総数含む.getコード());
        List<RString> 表番号List = new ArrayList<>();
        表番号List.add(HyoNo.償還_決定年月_一般状況.getコード());
        表番号List.add(HyoNo.償還_決定年月_一般状況_旧市町村.getコード());
        return new JigyoHokokuGeppoIppanShokanMybatisParamter(Code.EMPTY,
                決定年月, RString.EMPTY, null, 対象市町村コードList,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, 集計番号List, 表番号List, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
    }

    /**
     * 処理日付管理マスタの登録処理mybatisのパラメータを生成します。
     *
     * @param 決定年月 決定年月
     * @param 市町村コード 市町村コード
     * @param 構成市町村区分 構成市町村区分
     * @param 構成市町村コードリスト 構成市町村コードリスト
     * @param 旧市町村区分 旧市町村区分
     * @param 旧市町村コードリスト 旧市町村コードリスト
     * @param プリントコントロール区分 プリントコントロール区分
     * @param 年度 年度
     * @param 作成日時 作成日時
     * @param 処理日時 処理日時
     *
     * @return JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter
     */
    public static JigyoHokokuGeppoIppanShokanMybatisParamter createInsertDataParam(RString 決定年月,
            RString 市町村コード,
            RString 構成市町村区分,
            List<RString> 構成市町村コードリスト,
            RString 旧市町村区分,
            List<RString> 旧市町村コードリスト,
            RString プリントコントロール区分,
            RString 年度,
            RString 作成日時,
            RString 処理日時) {
        List<RString> 市町村コードリスト = new ArrayList<>();
        市町村コードリスト.add(市町村コード);
        if (市町村区分_構成市町村.equals(構成市町村区分)) {
            市町村コードリスト.addAll(構成市町村コードリスト);
        }
        if (市町村区分_旧市町村.equals(旧市町村区分)) {
            市町村コードリスト.addAll(旧市町村コードリスト);
        }
        RString 基準年月日 = RString.EMPTY;
        RString 基準日時 = RString.EMPTY;
        if (PrintControlKubun.集計のみ.getコード().equals(プリントコントロール区分)
                || PrintControlKubun.集計後印刷.getコード().equals(プリントコントロール区分)) {
            if (!RString.isNullOrEmpty(処理日時)) {
                基準年月日 = 処理日時.substring(0, INDEX);
                基準日時 = 処理日時;
            }
        } else if (PrintControlKubun.過去分の印刷.getコード().equals(プリントコントロール区分) && !RString.isNullOrEmpty(作成日時)) {
            基準年月日 = 作成日時.substring(0, INDEX);
            基準日時 = 作成日時;
        }
        RString 処理枝番 = RString.EMPTY;
        if (!RString.isNullOrEmpty(決定年月)) {
            処理枝番 = new RString(new RDate(決定年月.toString()).getMonthValue()).concat("00");
        }
        return new JigyoHokokuGeppoIppanShokanMybatisParamter(Code.EMPTY,
                RString.EMPTY, RString.EMPTY, null, 市町村コードリスト,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, null, null, new RString("DBU"),
                Syorimei.月報報告一般状況１２_１４償還分決定.get名称(), 処理枝番, 年度, 基準年月日, 基準日時);
    }

    private static List<RString> get集計番号List() {
        List<RString> 集計番号リスト = new ArrayList<>();
        集計番号リスト.add(ShukeiNo.一般状況_12_居宅介護_介護予防_サービス受給者数.getコード());
        集計番号リスト.add(ShukeiNo.一般状況_14_施設介護サービス受給者数_介護老人福祉施設.getコード());
        集計番号リスト.add(ShukeiNo.一般状況_15_施設介護サービス受給者数_介護老人保健施設.getコード());
        集計番号リスト.add(ShukeiNo.一般状況_16_施設介護サービス受給者数_介護療養型医療施設_総数含む.getコード());
        集計番号リスト.add(ShukeiNo.一般状況_13_地域密着型_介護予防_サービス受給者数.getコード());
        return 集計番号リスト;
    }

    private static List<RString> get表番号List() {
        List<RString> 表番号リスト = new ArrayList<>();
        表番号リスト.add(HyoNo.償還_決定年月_一般状況.getコード());
        表番号リスト.add(HyoNo.償還_決定年月_一般状況_旧市町村.getコード());
        return 表番号リスト;
    }

}
