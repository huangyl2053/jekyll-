/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppohokenkyufukogaku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.HyoNo;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.PrintControlKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNo;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppohokenkyufukogaku.JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import lombok.Getter;

/**
 * 事業状況報告資料（月報）作成 保険給付決定情報（高額介護サービス費）のProcess用パラメータクラスです。
 *
 * @reamsid_L DBU-5580-030 zhangzhiming
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class JigyoHokokuGeppoHokenkyufuKogakuProcessParamter implements IBatchProcessParameter {

    private final RString プリントコントロール区分;
    private final RString 集計年月;
    private final RString 報告年月;
    private final RString 年度;
    private final RString 作成日時;
    private final YMDHMS 処理日時;
    private final RString 市町村コード;
    private final RString 構成市町村区分;
    private final RString 旧市町村区分;
    private final List<RString> 構成市町村コードリスト;
    private final List<RString> 旧市町村コードリスト;
    private final RString 過去集計分旧市町村区分;
    private final RString バッチID;
    private final RString csvFilePath;
    private final List<RString> 過去集計分市町村コードリスト;
    private final FileSpoolManager manager;
    private static final RString 区分 = new RString("1");
    private static final RString 区分_2 = new RString("2");
    private static final RString 区分_3 = new RString("3");
    private static final int INDEX = 8;
    private static final int 連番_4 = 4;

    /**
     * コンストラクタです。
     *
     * @param プリントコントロール区分 プリントコントロール区分
     * @param 集計年月 集計年月
     * @param 報告年月 報告年月
     * @param 年度 年度
     * @param 作成日時 作成日時
     * @param 処理日時 処理日時
     * @param 市町村コード 市町村コード
     * @param 構成市町村区分 構成市町村区分
     * @param 旧市町村区分 旧市町村区分
     * @param 構成市町村コードリスト 構成市町村コードリスト
     * @param 旧市町村コードリスト 旧市町村コードリスト
     * @param 過去集計分市町村コードリスト 過去集計分市町村コードリスト
     * @param 過去集計分旧市町村区分 過去集計分旧市町村区分
     * @param バッチID バッチID
     * @param csvFilePath csvFilePath
     * @param manager manager
     */
    public JigyoHokokuGeppoHokenkyufuKogakuProcessParamter(RString プリントコントロール区分, RString 集計年月, RString 報告年月,
            RString 年度, RString 作成日時, YMDHMS 処理日時, RString 市町村コード, RString 構成市町村区分, RString 旧市町村区分,
            List<RString> 構成市町村コードリスト, List<RString> 旧市町村コードリスト, List<RString> 過去集計分市町村コードリスト,
            RString 過去集計分旧市町村区分, RString バッチID, RString csvFilePath, FileSpoolManager manager) {
        this.プリントコントロール区分 = プリントコントロール区分;
        this.集計年月 = 集計年月;
        this.報告年月 = 報告年月;
        this.年度 = 年度;
        this.作成日時 = 作成日時;
        this.処理日時 = 処理日時;
        this.市町村コード = 市町村コード;
        this.構成市町村区分 = 構成市町村区分;
        this.旧市町村区分 = 旧市町村区分;
        this.構成市町村コードリスト = 構成市町村コードリスト;
        this.旧市町村コードリスト = 旧市町村コードリスト;
        this.過去集計分市町村コードリスト = 過去集計分市町村コードリスト;
        this.過去集計分旧市町村区分 = 過去集計分旧市町村区分;
        this.バッチID = バッチID;
        this.csvFilePath = csvFilePath;
        this.manager = manager;
    }

    /**
     * 事業状況報告統計情報取得処理mybatisのパラメータを生成します。
     *
     * @return JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter
     */
    public JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter toJigyohokokuCompYoshikiMybitisParamter() {
        List<RString> 過去集計分市町村コードList = new ArrayList<>();
        if (区分_2.equals(プリントコントロール区分)) {
            過去集計分市町村コードList.add(市町村コード);
        }
        if (区分_3.equals(プリントコントロール区分)) {
            if (過去集計分市町村コードリスト == null || 過去集計分市町村コードリスト.isEmpty()) {
                過去集計分市町村コードList.add(市町村コード);
            } else {
                過去集計分市町村コードList.addAll(過去集計分市町村コードリスト);
            }
        }
        List 集計番号List = new ArrayList<>();
        集計番号List.add(ShukeiNo.利用者負担第五段階_0700.getコード());
        集計番号List.add(ShukeiNo.利用者負担第四段階_0701.getコード());
        集計番号List.add(ShukeiNo.利用者負担第三段階_0702.getコード());
        集計番号List.add(ShukeiNo.利用者負担第二段階_0703.getコード());
        集計番号List.add(ShukeiNo.利用者負担第一段階_0704.getコード());
        集計番号List.add(ShukeiNo.合計_07.getコード());
        集計番号List.add(ShukeiNo.利用者負担第三段階_0706.getコード());
        集計番号List.add(ShukeiNo.利用者負担第二段階_0707.getコード());
        List 表番号List = new ArrayList<>();
        表番号List.add(HyoNo.償還_決定年月_保険給付決定状況.getコード());
        表番号List.add(HyoNo.高額サービス費_保険給付決定状況_旧市町村.getコード());
        return JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter.createJigyohokokuCompYoshikiDataParam(過去集計分市町村コードList,
                集計年月, 集計番号List, 表番号List);
    }

    /**
     * 事業状況報告統計元データ作成処理mybatisのパラメータを生成します。
     *
     * @return JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter
     */
    public JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter toInsertKougakuDataMybitisParamter() {
        return JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter.createInsertKougakuDataParam(集計年月);
    }

    /**
     * 事業状況報告情報処理mybatisのパラメータを生成します。
     *
     * @param 集計番号 集計番号
     * @return JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter
     */
    public JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter toJigyoHokokuDataCSVMybitisParamter(RString 集計番号) {
        return JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter.createInsertKougakuDataParam(集計番号);
    }

    /**
     * 事業状況報告統計元データ作成処理mybatisのパラメータを生成します。
     *
     * @param 旧市町村区分 旧市町村区分
     * @return JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter
     */
    public JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter toShoriKekkaListDataMybitisParamter(RString 旧市町村区分) {
        if (!区分.equals(旧市町村区分)) {
            List<RString> コードリスト = new ArrayList<>();
            コードリスト.add(RString.EMPTY);
            return JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter.createShoriKekkaListDataParam(コードリスト);
        }
        return JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter.createShoriKekkaListDataParam(旧市町村コードリスト);
    }

    /**
     * 処理日付管理登録s処理mybatisのパラメータを生成します。
     *
     * @return JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter
     */
    public JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter toInsertShoriDataMybitisParamter() {
        List<RString> 市町村コードリスト = new ArrayList<>();
        市町村コードリスト.add(市町村コード);
        if (区分.equals(構成市町村区分)) {
            市町村コードリスト.addAll(構成市町村コードリスト);
        }
        if (区分.equals(旧市町村区分)) {
            市町村コードリスト.addAll(旧市町村コードリスト);
        }
        RString 基準年月日 = RString.EMPTY;
        YMDHMS 基準日時 = YMDHMS.now();
        if (PrintControlKubun.集計のみ.getコード().equals(プリントコントロール区分)
                || PrintControlKubun.集計後印刷.getコード().equals(プリントコントロール区分)) {
            基準年月日 = 処理日時.getDate().toDateString();
            基準日時 = 処理日時;
        } else if (PrintControlKubun.過去分の印刷.getコード().equals(プリントコントロール区分)) {
            基準年月日 = 作成日時.substring(0, INDEX);
            基準日時 = new YMDHMS(作成日時);
        }
        return JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter.createInsertShoriDataParam(市町村コードリスト,
                new RString("00").concat(集計年月.substring(連番_4)), 年度, 基準年月日, 基準日時);
    }

    /**
     * 事業報告統計データの削除処理mybatisのパラメータを生成します。
     *
     * @return JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter
     */
    public JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter toDeleteDataMybitisParamter() {
        List<RString> 市町村コードList = new ArrayList<>();
        市町村コードList.add(市町村コード);
        if (区分.equals(構成市町村区分)) {
            市町村コードList.addAll(構成市町村コードリスト);
        }
        if (区分.equals(旧市町村区分)) {
            市町村コードList.addAll(旧市町村コードリスト);
        }
        List 集計番号List = new ArrayList<>();
        集計番号List.add(ShukeiNo.利用者負担第五段階_0700.getコード());
        集計番号List.add(ShukeiNo.利用者負担第四段階_0701.getコード());
        集計番号List.add(ShukeiNo.利用者負担第三段階_0702.getコード());
        集計番号List.add(ShukeiNo.利用者負担第二段階_0703.getコード());
        集計番号List.add(ShukeiNo.利用者負担第一段階_0704.getコード());
        集計番号List.add(ShukeiNo.合計_07.getコード());
        集計番号List.add(ShukeiNo.利用者負担第三段階_0706.getコード());
        集計番号List.add(ShukeiNo.利用者負担第二段階_0707.getコード());
        List 表番号List = new ArrayList<>();
        表番号List.add(HyoNo.償還_決定年月_保険給付決定状況.getコード());
        表番号List.add(HyoNo.高額サービス費_保険給付決定状況_旧市町村.getコード());
        return JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter.createDeleteDataParam(市町村コードList, 集計年月, 集計番号List, 表番号List);
    }

    /**
     * 事業状況報告統計情報の取得処理mybatisのパラメータを生成します。
     *
     * @return JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter
     */
    public JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter toSelectDataMybitisParamter() {
        List<RString> 市町村コードList = new ArrayList<>();
        市町村コードList.add(市町村コード.concat(区分));
        if (区分.equals(構成市町村区分)) {
            for (RString list : 構成市町村コードリスト) {
                市町村コードList.add(list.concat(区分_2));
            }
        }
        if (区分.equals(旧市町村区分)) {
            for (RString list : 旧市町村コードリスト) {
                市町村コードList.add(list.concat(区分_3));
            }
        }
        List 集計番号List = new ArrayList<>();
        集計番号List.add(ShukeiNo.利用者負担第五段階_0700.getコード());
        集計番号List.add(ShukeiNo.利用者負担第四段階_0701.getコード());
        集計番号List.add(ShukeiNo.利用者負担第三段階_0702.getコード());
        集計番号List.add(ShukeiNo.利用者負担第二段階_0703.getコード());
        集計番号List.add(ShukeiNo.利用者負担第一段階_0704.getコード());
        集計番号List.add(ShukeiNo.合計_07.getコード());
        集計番号List.add(ShukeiNo.利用者負担第三段階_0706.getコード());
        集計番号List.add(ShukeiNo.利用者負担第二段階_0707.getコード());
        return JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter.createSelectDataParam(市町村コードList, 集計年月, 集計番号List);
    }
}
