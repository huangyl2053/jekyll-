/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyojokyohokokushiryonemposakuseiiti;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.HyoNo;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.PrintControlKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.Syorimei;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 事業状況報告資料（年報）作成　一般状況（１～１１）のMybatisパラメータクラスです。
 *
 * @reamsid_L DBU-5600-030 dingyi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter implements IMyBatisParameter {

    private final List<RString> 市町村コードリスト;
    private final RString 集計年月;
    private final List<RString> 集計番号リスト;
    private final List<RString> 表番号リスト;
    private final RString 集計区分;
    private final RString 集計開始年月;
    private final RString 集計終了年月;
    private final RString サブ業務コード;
    private final RString 処理名;
    private final RString 処理枝番;
    private final RString 年度;
    private final RString 基準年月日;
    private final RString 基準日時;
    private static final RString 市町村区分_構成市町村 = new RString("1");
    private static final RString 市町村区分_旧市町村 = new RString("1");
    private static final int INDEX = 8;

    /**
     * コンストラクタです。
     *
     * @param 市町村コードリスト 市町村コードリスト
     * @param 集計年月 集計年月
     * @param 集計番号リスト 集計番号リスト
     * @param 表番号リスト 表番号リスト
     * @param 集計区分 集計区分PanelAtenaDiv
     * @param 集計開始年月 集計開始年月
     * @param 集計終了年月 集計終了年月
     * @param サブ業務コード サブ業務コード
     * @param 処理名 処理名
     * @param 処理枝番 処理枝番
     * @param 年度 年度
     * @param 基準年月日 基準年月日
     * @param 基準日時 基準日時
     */
    private JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter(
            List<RString> 市町村コードリスト,
            RString 集計年月,
            List<RString> 集計番号リスト,
            List<RString> 表番号リスト,
            RString 集計区分,
            RString 集計開始年月,
            RString 集計終了年月,
            RString サブ業務コード,
            RString 処理名,
            RString 処理枝番,
            RString 年度,
            RString 基準年月日,
            RString 基準日時) {
        this.市町村コードリスト = 市町村コードリスト;
        this.集計年月 = 集計年月;
        this.集計番号リスト = 集計番号リスト;
        this.表番号リスト = 表番号リスト;
        this.集計区分 = 集計区分;
        this.集計開始年月 = 集計開始年月;
        this.集計終了年月 = 集計終了年月;
        this.サブ業務コード = サブ業務コード;
        this.処理名 = 処理名;
        this.処理枝番 = 処理枝番;
        this.年度 = 年度;
        this.基準年月日 = 基準年月日;
        this.基準日時 = 基準日時;
    }

    /**
     * 事業報告統計データの削除処理mybatisのパラメータを生成します。
     *
     * @param 集計年度 集計年度
     * @param 市町村コード 市町村コード
     * @param 構成市町村区分 構成市町村区分
     * @param 構成市町村コードリスト 構成市町村コードリスト
     * @param 旧市町村区分 旧市町村区分
     * @param 旧市町村コードリスト 旧市町村コードリスト
     *
     * @return JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter
     */
    public static JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter createDeleteDataParam(
            RString 集計年度,
            RString 市町村コード,
            RString 構成市町村区分,
            List<RString> 構成市町村コードリスト,
            RString 旧市町村区分,
            List<RString> 旧市町村コードリスト) {
        List<RString> 市町村コードリスト = new ArrayList<>();
        市町村コードリスト.add(市町村コード);
        if (市町村区分_構成市町村.equals(構成市町村区分) && 構成市町村コードリスト != null && !構成市町村コードリスト.isEmpty()) {
            市町村コードリスト.addAll(構成市町村コードリスト);
        }
        if (市町村区分_旧市町村.equals(旧市町村区分) && 旧市町村コードリスト != null && !旧市町村コードリスト.isEmpty()) {
            市町村コードリスト.addAll(旧市町村コードリスト);
        }
        return new JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter(
                市町村コードリスト, 集計年度.concat("00"), get集計番号List(), get表番号List(),
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
    }

    /**
     * 事業状況報告統計情報の取得処理mybatisのパラメータを生成します。
     *
     * @param 集計開始年月 集計開始年月
     * @param 集計終了年月 集計終了年月
     * @param 市町村コード 市町村コード
     * @param 構成市町村区分 構成市町村区分
     * @param 構成市町村コードリスト 構成市町村コードリスト
     * @param 旧市町村区分 旧市町村区分
     * @param 旧市町村コードリスト 旧市町村コードリスト
     *
     * @return JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter
     */
    public static JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter createSelectDataParam(
            RString 集計開始年月,
            RString 集計終了年月,
            RString 市町村コード,
            RString 構成市町村区分,
            List<RString> 構成市町村コードリスト,
            RString 旧市町村区分,
            List<RString> 旧市町村コードリスト) {
        List<RString> 市町村コードリスト = new ArrayList<>();
        市町村コードリスト.add(市町村コード);
        if (市町村区分_構成市町村.equals(構成市町村区分) && 構成市町村コードリスト != null && !構成市町村コードリスト.isEmpty()) {
            市町村コードリスト.addAll(構成市町村コードリスト);
        }
        if (市町村区分_旧市町村.equals(旧市町村区分) && 旧市町村コードリスト != null && !旧市町村コードリスト.isEmpty()) {
            市町村コードリスト.addAll(旧市町村コードリスト);
        }
        return new JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter(
                市町村コードリスト, RString.EMPTY, get集計番号List(), get表番号List(),
                new RString("1"), 集計開始年月, 集計終了年月, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
    }

    /**
     * 処理日付管理マスタの登録処理mybatisのパラメータを生成します。
     *
     * @param 市町村コード 市町村コード
     * @param 構成市町村区分 構成市町村区分
     * @param 構成市町村コードリスト 構成市町村コードリスト
     * @param 旧市町村区分 旧市町村区分
     * @param 旧市町村コードリスト 旧市町村コードリスト
     * @param プリントコントロール区分 プリントコントロール区分
     * @param 集計開始年月 集計開始年月
     * @param 集計終了年月 集計終了年月
     * @param 年度 年度
     * @param 作成日時 作成日時
     * @param 処理日時 処理日時
     *
     * @return JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter
     */
    public static JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter createInsertDataParam(
            RString 市町村コード,
            RString 構成市町村区分,
            List<RString> 構成市町村コードリスト,
            RString 旧市町村区分,
            List<RString> 旧市町村コードリスト,
            RString プリントコントロール区分,
            RString 年度,
            RString 作成日時,
            RString 処理日時,
            RString 集計開始年月,
            RString 集計終了年月) {
        List<RString> 市町村コードリスト = new ArrayList<>();
        市町村コードリスト.add(市町村コード);
        if (市町村区分_構成市町村.equals(構成市町村区分) && 構成市町村コードリスト != null && !構成市町村コードリスト.isEmpty()) {
            市町村コードリスト.addAll(構成市町村コードリスト);
        }
        if (市町村区分_旧市町村.equals(旧市町村区分) && 旧市町村コードリスト != null && !旧市町村コードリスト.isEmpty()) {
            市町村コードリスト.addAll(旧市町村コードリスト);
        }
        RString 基準年月日 = RString.EMPTY;
        RString 基準日時 = RString.EMPTY;
        if (PrintControlKubun.集計のみ.getコード().equals(プリントコントロール区分)
                || PrintControlKubun.集計後印刷.getコード().equals(プリントコントロール区分)) {
            基準年月日 = 処理日時.substring(0, INDEX);
            基準日時 = 処理日時;
        } else if (PrintControlKubun.過去分の印刷.getコード().equals(プリントコントロール区分)) {
            基準年月日 = 作成日時.substring(0, INDEX);
            基準日時 = 作成日時;
        }
        return new JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter(
                市町村コードリスト, RString.EMPTY, null, null, RString.EMPTY,
                集計開始年月, 集計終了年月, new RString("DBU"), Syorimei.年報報告一般状況１_１１.get名称(),
                new RString("0099"), 年度, 基準年月日, 基準日時);
    }

    /**
     * 事業状況報告統計帳票用情報の取得処理mybatisのパラメータを生成します。
     *
     * @param 市町村コード 市町村コード
     * @param プリントコントロール区分 プリントコントロール区分
     * @param 年度 年度
     * @param 過去集計分市町村コードリスト 過去集計分市町村コードリスト
     *
     * @return JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter
     */
    public static JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter createSelectReportDataParam(
            RString 市町村コード,
            RString プリントコントロール区分,
            RString 年度,
            List<RString> 過去集計分市町村コードリスト) {
        List<RString> 市町村コードリスト = new ArrayList<>();
        if (PrintControlKubun.集計後印刷.getコード().equals(プリントコントロール区分)) {
            市町村コードリスト.add(市町村コード);
        } else if (PrintControlKubun.過去分の印刷.getコード().equals(プリントコントロール区分)) {
            if (過去集計分市町村コードリスト == null || 過去集計分市町村コードリスト.isEmpty()) {
                市町村コードリスト.add(市町村コード);
            } else {
                市町村コードリスト.addAll(過去集計分市町村コードリスト);
            }
        }
        return new JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter(
                市町村コードリスト, 年度.concat("00"), get集計番号List(), get表番号List(),
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
    }

    private static List<RString> get集計番号List() {
        List<RString> 集計番号リスト = new ArrayList<>();
        集計番号リスト.add(ShukeiNo.別紙_1_第1号被保険者のいる世帯数.getコード());
        集計番号リスト.add(ShukeiNo.一般状況_1_第1号被保険者数.getコード());
        集計番号リスト.add(ShukeiNo.一般状況_2_第1号被保険者増減内訳_当月中増.getコード());
        集計番号リスト.add(ShukeiNo.一般状況_2_第2号被保険者増減内訳_当月中減.getコード());
        集計番号リスト.add(ShukeiNo.一般状況_4_所得段階別第１号被保険者数.getコード());
        集計番号リスト.add(ShukeiNo.一般状況_5_標準負担減額認定.getコード());
        集計番号リスト.add(ShukeiNo.一般状況_4_利用者負担減額_免除認定_総数.getコード());
        集計番号リスト.add(ShukeiNo.一般状況_7_特定標準負担_旧措置.getコード());
        集計番号リスト.add(ShukeiNo.一般状況_5_介護老人福祉施設旧措置入所者に係る減額_免除認定_総数_利用者負担.getコード());
        集計番号リスト.add(ShukeiNo.一般状況_8_標準負担減額認定_第２号.getコード());
        集計番号リスト.add(ShukeiNo.一般状況_7_利用者負担減額_免除認定_再掲_第2号被保険者分.getコード());
        集計番号リスト.add(ShukeiNo.一般状況_10_特定標準負担_旧措置_第２号.getコード());
        集計番号リスト.add(ShukeiNo.一般状況_8_介護老人福祉施設旧措置入所者に係る減額_免除認定_再掲_第2号被保険者分_利用者負担.getコード());
        集計番号リスト.add(ShukeiNo.一般状況_11_要介護_要支援_認定者数.getコード());
        集計番号リスト.add(ShukeiNo.一般状況_3_食費_居住費に係る負担限度額認定_総数.getコード());
        集計番号リスト.add(ShukeiNo.一般状況_5_介護老人福祉施設旧措置入所者に係る減額_免除認定_総数_特定負担限度額.getコード());
        集計番号リスト.add(ShukeiNo.一般状況_6_食費_居住費に係る負担限度額認定_再掲_第2号被保険者分.getコード());
        集計番号リスト.add(ShukeiNo.一般状況_8_介護老人福祉施設旧措置入所者に係る減額_免除認定_再掲_第2号被保険者分_特定負担限度額.getコード());
        集計番号リスト.add(ShukeiNo.一般状況_10_利用者負担第4段階における_食費_居住費の特例減額措置.getコード());
        集計番号リスト.add(ShukeiNo.一般状況_9_食費_居住費に係る負担限度額認定_再掲_税制改正による激変緩和措置を受けている者.getコード());
        return 集計番号リスト;
    }

    private static List<RString> get表番号List() {
        List<RString> 表番号リスト = new ArrayList<>();
        表番号リスト.add(HyoNo.現物_一般状況.getコード());
        表番号リスト.add(HyoNo.現物_一般状況_旧市町村.getコード());
        return 表番号リスト;
    }
}
