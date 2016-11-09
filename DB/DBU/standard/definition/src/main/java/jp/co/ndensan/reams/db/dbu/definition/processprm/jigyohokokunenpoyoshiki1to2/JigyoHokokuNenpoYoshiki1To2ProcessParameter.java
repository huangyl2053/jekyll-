/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokunenpoyoshiki1to2;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpoyoshiki1to2.Yoshiki1To2ComMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpoyoshiki1to2.Yoshiki1To2ReportDataMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import lombok.Getter;

/**
 * 事業状況報告年報　様式１・２のProcess用パラメータクラスです
 *
 * @reamsid_L DBU-5610-030 chengsanyuan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class JigyoHokokuNenpoYoshiki1To2ProcessParameter implements IBatchProcessParameter {

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
    private final RString 合併市町村区分;
    private final RString 広域構成市町村区分;
    private final List<RString> 構成市町村コードリスト;
    private final List<RString> 旧市町村コードリスト;
    private final List<RString> 過去集計分市町村コードリスト;
    private final RString 過去集計分旧市町村区分;
    private final RString csvFilePath;
    private final FileSpoolManager manager;

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
     * @param 合併市町村区分 合併市町村区分
     * @param 広域構成市町村区分 広域構成市町村区分
     * @param 構成市町村コードリスト 構成市町村コードリスト
     * @param 旧市町村コードリスト 旧市町村コードリスト
     * @param 過去集計分市町村コードリスト 過去集計分市町村コードリスト
     * @param 過去集計分旧市町村区分 過去集計分旧市町村区分
     * @param csvFilePath csvFilePath
     * @param manager manager
     */
    public JigyoHokokuNenpoYoshiki1To2ProcessParameter(RString プリントコントロール区分,
            RString 報告年度, RString 報告開始年月, RString 報告終了年月,
            RString 集計年度, RString 集計開始年月, RString 集計終了年月,
            RDateTime 作成日時, RDateTime 処理日時, RString 市町村コード,
            RString 合併市町村区分, RString 広域構成市町村区分,
            List<RString> 構成市町村コードリスト, List<RString> 旧市町村コードリスト,
            List<RString> 過去集計分市町村コードリスト, RString 過去集計分旧市町村区分,
            RString csvFilePath, FileSpoolManager manager) {
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
        this.合併市町村区分 = 合併市町村区分;
        this.広域構成市町村区分 = 広域構成市町村区分;
        this.構成市町村コードリスト = 構成市町村コードリスト;
        this.旧市町村コードリスト = 旧市町村コードリスト;
        this.過去集計分市町村コードリスト = 過去集計分市町村コードリスト;
        this.過去集計分旧市町村区分 = 過去集計分旧市町村区分;
        this.csvFilePath = csvFilePath;
        this.manager = manager;
    }

    /**
     * 介護賦課・被保険者者台帳取得のパラメータを生成します
     *
     * @return Yoshiki1To2ComMybatisParameter
     */
    public Yoshiki1To2ComMybatisParameter toFukaHihokenshaParam() {
        return Yoshiki1To2ComMybatisParameter.createFukaHihokenshaParam(集計年度);
    }

    /**
     * 帳票作成用のデータパラメータを生成します
     *
     * @param 集計番号フラグ 集計番号フラグ
     * @return Yoshiki1To2ReportDataMybatisParameter
     */
    public Yoshiki1To2ReportDataMybatisParameter toGetReportDataParm(RString 集計番号フラグ) {
        return Yoshiki1To2ReportDataMybatisParameter.createGetReportDataParam(過去集計分旧市町村区分,
                市町村コード, 構成市町村コードリスト, 旧市町村コードリスト, 集計年度, 集計番号フラグ);
    }
}
