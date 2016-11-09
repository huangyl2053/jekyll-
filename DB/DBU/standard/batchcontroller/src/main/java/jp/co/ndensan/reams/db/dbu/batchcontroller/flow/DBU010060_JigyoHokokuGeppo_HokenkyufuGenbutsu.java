/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU010060.DBU010060_JigyoHokokuGeppo_HokenkyufuGenbutsuParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.PrintControlKubun;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 保険給付決定状況【現物分・償還分合算（審査年月）】のバッチフロークラスです。
 *
 * @reamsid_L DBU-5560-030 xuyannan
 */
public class DBU010060_JigyoHokokuGeppo_HokenkyufuGenbutsu
        extends BatchFlowBase<DBU010060_JigyoHokokuGeppo_HokenkyufuGenbutsuParameter> {

    private static final String 給付実績集計根拠一時テーブル作成プロセス = "給付実績集計根拠一時テーブル作成";
    private static final String 給付実績集計根拠一時テーブル再作成プロセス = "給付実績集計根拠一時テーブル再作成";
    private static final String 事業報告資料登録_給付実績プロセス = "事業報告資料登録_給付実績";
    private static final String 特定入所者集計根拠テーブル作成プロセス = "特定入所者集計根拠テーブル作成";
    private static final String 事業報告資料登録_特定入所者プロセス = "事業報告資料登録_特定入所者";
    private static final String 事業報告月報様式_01出力プロセス = "事業報告月報様式_01出力";
    private static final String 事業報告月報様式_02出力プロセス = "事業報告月報様式_02出力";
    private static final String 事業報告月報様式_03出力プロセス = "事業報告月報様式_03出力";
    private static final String 事業報告月報様式_04出力プロセス = "事業報告月報様式_04出力";
    private static final String 事業報告複合様式_05出力プロセス = "事業報告複合様式_05出力";
    private static final String 処理結果確認リスト帳票出力_作成区分エラーフラグ分プロセス = "処理結果確認リスト帳票出力_作成区分エラーフラグ分";
    private static final String 処理結果確認リスト帳票出力_負担割合エラーフラグ分プロセス = "処理結果確認リスト帳票出力_負担割合エラーフラグ分";
    private static final String 処理結果確認リスト帳票出力_前後給付率エラーフラグ分プロセス = "処理結果確認リスト帳票出力_前後給付率エラーフラグ分";
    private static final String 処理結果確認リスト帳票出力_市町村コード分プロセス = "処理結果確認リスト帳票出力_市町村コード分";
    private DBU010060_JigyoHokokuGeppo_HokenkyufuGenbutsuParameter parameter;
    private FileSpoolManager manager;

    @Override
    protected void defineFlow() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                new EucEntityId("DBU010060"), UzUDE0831EucAccesslogFileType.Csv);
        parameter = getParameter();
        parameter.setCsvFilePath(manager.getEucOutputDirectry());
        parameter.setManager(manager);
        if (PrintControlKubun.集計のみ.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(給付実績集計根拠一時テーブル作成プロセス);
            executeStep(給付実績集計根拠一時テーブル再作成プロセス);
            executeStep(事業報告資料登録_給付実績プロセス);
            executeStep(特定入所者集計根拠テーブル作成プロセス);
            executeStep(事業報告資料登録_特定入所者プロセス);
            executeStep(処理結果確認リスト帳票出力_作成区分エラーフラグ分プロセス);
            executeStep(処理結果確認リスト帳票出力_負担割合エラーフラグ分プロセス);
            executeStep(処理結果確認リスト帳票出力_前後給付率エラーフラグ分プロセス);
            executeStep(処理結果確認リスト帳票出力_市町村コード分プロセス);
        } else if (PrintControlKubun.集計後印刷.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(給付実績集計根拠一時テーブル作成プロセス);
            executeStep(給付実績集計根拠一時テーブル再作成プロセス);
            executeStep(事業報告資料登録_給付実績プロセス);
            executeStep(特定入所者集計根拠テーブル作成プロセス);
            executeStep(事業報告資料登録_特定入所者プロセス);
            executeStep(事業報告月報様式_01出力プロセス);
            executeStep(事業報告月報様式_02出力プロセス);
            executeStep(事業報告月報様式_03出力プロセス);
            executeStep(事業報告月報様式_04出力プロセス);
            executeStep(事業報告複合様式_05出力プロセス);
            executeStep(処理結果確認リスト帳票出力_作成区分エラーフラグ分プロセス);
            executeStep(処理結果確認リスト帳票出力_負担割合エラーフラグ分プロセス);
            executeStep(処理結果確認リスト帳票出力_前後給付率エラーフラグ分プロセス);
            executeStep(処理結果確認リスト帳票出力_市町村コード分プロセス);
        } else if (PrintControlKubun.過去分の印刷.getコード().equals(getParameter().getプリントコントロール区分())) {
            executeStep(事業報告月報様式_01出力プロセス);
            executeStep(事業報告月報様式_02出力プロセス);
            executeStep(事業報告月報様式_03出力プロセス);
            executeStep(事業報告月報様式_04出力プロセス);
            executeStep(事業報告複合様式_05出力プロセス);
        }
    }

}
