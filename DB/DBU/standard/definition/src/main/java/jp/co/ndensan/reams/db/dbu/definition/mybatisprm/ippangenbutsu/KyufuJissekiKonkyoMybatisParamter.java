/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.ippangenbutsu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.PrintControlKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.Syorimei;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 事業報告月報_一般現物のMybatisパラメータクラスです。
 *
 * @reamsid_L DBU-5540-030 suguangjun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class KyufuJissekiKonkyoMybatisParamter implements IMyBatisParameter {

    private final RString 集計番号;
    private final RString 一時テーブル名;
    private final RString プリントコントロール区分;
    private final RString 市町村コード;
    private final List<RString> 市町村コードList;
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

    private KyufuJissekiKonkyoMybatisParamter(RString 集計番号,
            RString 一時テーブル名,
            RString プリントコントロール区分,
            RString 市町村コード,
            List<RString> 市町村コードList,
            List<RString> 集計番号リスト,
            List<RString> 表番号リスト,
            RString サブ業務コード,
            RString 処理名,
            RString 処理枝番,
            RString 年度,
            RString 基準年月日,
            RString 基準日時) {
        this.集計番号 = 集計番号;
        this.一時テーブル名 = 一時テーブル名;
        this.プリントコントロール区分 = プリントコントロール区分;
        this.市町村コード = 市町村コード;
        this.市町村コードList = 市町村コードList;
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
     * 事業報告月報_一般現物mybatisのパラメータを生成します。
     *
     * @param 集計番号 集計番号
     * @param 一時テーブル名 一時テーブル名
     * @return KyufuJissekiKonkyoMybatisParamter
     */
    public static KyufuJissekiKonkyoMybatisParamter createDataParam(RString 集計番号, RString 一時テーブル名) {
        return new KyufuJissekiKonkyoMybatisParamter(集計番号,
                一時テーブル名, RString.EMPTY, RString.EMPTY, null,
                null, null, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY);
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
     * @param 年度 年度
     * @param 作成日時 作成日時
     * @param 処理日時 処理日時
     *
     * @return JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter
     */
    public static KyufuJissekiKonkyoMybatisParamter createInsertDataParam(
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
            基準年月日 = 処理日時.substring(0, INDEX);
            基準日時 = 処理日時;
        } else if (PrintControlKubun.過去分の印刷.getコード().equals(プリントコントロール区分)) {
            基準年月日 = 作成日時.substring(0, INDEX);
            基準日時 = 作成日時;
        }
        return new KyufuJissekiKonkyoMybatisParamter(RString.EMPTY, RString.EMPTY, RString.EMPTY, 市町村コード,
                市町村コードリスト, null, null, new RString("DBU"), Syorimei.月報報告一般状況１２_１４現物分.get名称(),
                new RString("0099"), 年度, 基準年月日, 基準日時);
    }

}
