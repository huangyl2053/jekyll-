/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002.ChkIchijiHanteiKekkaProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002.ChkNinteiChosahyo02Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002.ChkNinteiChosahyo12Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002.ChkNinteiChosahyo22Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002.ChkNinteiChosahyo32Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002.ChkNinteiChosahyo42Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002.ChkNinteiChosahyo52Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002.ChkShujiiIkenshoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002.ChkSonotaShiryoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002.ChkTokkiJiko03Process;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002.ChkTokkiJiko31TextProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002.KoroshoShikibetsuCodeProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002.NinteichosaProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002.UpdateDataProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE090002.DBE090002_NinteikekkaJohoteikyoParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.yokaigoninteijohoteikyo.YokaigoBatchProcessParamter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定結果情報提供票のバッチフロークラスです。
 *
 * @reamsid_L DBE-0230-030 zhangzhiming
 */
public class DBE090002_NinteikekkaJohoteikyo extends BatchFlowBase<DBE090002_NinteikekkaJohoteikyoParameter> {

    private static final String 厚労省IF識別コード = "koroshoIfShikibetsuCode";
    private static final String 認定調査票の作成02 = "chkNinteiChosahyoReport02";
    private static final String 認定調査票の作成12 = "chkNinteiChosahyoReport12";
    private static final String 認定調査票の作成22 = "chkNinteiChosahyoReport22";
    private static final String 認定調査票の作成32 = "chkNinteiChosahyoReport32";
    private static final String 認定調査票の作成42 = "chkNinteiChosahyoReport42";
    private static final String 認定調査票の作成52 = "chkNinteiChosahyoReport52";
    private static final String 特記事項の区分 = "ninteichosaReport";
    private static final String 特記事項の作成03 = "chkTokkiJikoReport03";
    private static final String 特記事項の作成31_TEXT = "chkTokkiJikoReport31_Text";
    private static final String 主治医意見書の作成 = "chkShujiiIkenshoReport";
    private static final String その他資料の作成 = "chkSonotaShiryoReport";
    private static final String 一次判定結果の作成 = "chkIchijiHanteiKekkaReport";
    private static final String 要介護認定申請情報の更新 = "updateData";
    private static final RString 認定調査票_選択された = new RString("1");
    private static final RString 特記事項_選択された = new RString("1");
    private static final RString 主治医意見書_選択された = new RString("1");
    private static final RString その他資料_選択された = new RString("1");
    private static final RString 一次判定結果_選択された = new RString("1");
    private static final RString 総合事業実施済 = new RString("2");
    private static final RString 総合事業未実施 = new RString("1");

    private YokaigoBatchProcessParamter processParameter;

    @Override
    protected void prepareConfigData() {
        FlexibleDate 特記事項判定日
                = new FlexibleDate(DbBusinessConfig.get(ConfigNameDBE.特記事項判定日, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        processParameter = getParameter().toYokaigoBatchProcessParamter(特記事項判定日);
    }

    @Override
    protected void defineFlow() {
        executeStep(厚労省IF識別コード);
        if (認定調査票_選択された.equals(getParameter().getChkNinteiChosahyo())) {
            define認定調査票Flow();
        }
        if (特記事項_選択された.equals(getParameter().getChkTokkiJiko())) {
            define特記事項Flow();
        }
        if (主治医意見書_選択された.equals(getParameter().getChkShujiiIkensho())) {
            executeStep(主治医意見書の作成);
        }
        if (その他資料_選択された.equals(getParameter().getChkSonotaShiryo())) {
            executeStep(その他資料の作成);
        }
        if (一次判定結果_選択された.equals(getParameter().getChkIchijiHanteiKekka())) {
            executeStep(一次判定結果の作成);
        }
        executeStep(要介護認定申請情報の更新);
    }

    private void define認定調査票Flow() {
        List<RString> 厚労省IF識別コードList = getResult(List.class, new RString(厚労省IF識別コード), KoroshoShikibetsuCodeProcess.OUT_DATA_LIST);
        if (!厚労省IF識別コードList.isEmpty()) {
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コードList.get(0))
                    && 総合事業実施済.equals(DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
                executeStep(認定調査票の作成02);
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コードList.get(0))
                    && 総合事業未実施.equals(DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
                executeStep(認定調査票の作成12);
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コードList.get(0))) {
                executeStep(認定調査票の作成22);
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コードList.get(0))) {
                executeStep(認定調査票の作成32);
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コードList.get(0))) {
                executeStep(認定調査票の作成42);
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コードList.get(0))) {
                executeStep(認定調査票の作成52);
            }
        }
    }

    private void define特記事項Flow() {
        executeStep(特記事項の区分);
        List<RString> 特記事項区分List = getResult(List.class, new RString(特記事項の区分), NinteichosaProcess.OUT_DATA_LIST);
        if (特記事項区分List.contains(TokkijikoTextImageKubun.イメージ.getコード())) {
            executeStep(特記事項の作成03);
        } else if (特記事項区分List.contains(TokkijikoTextImageKubun.テキスト.getコード())) {
            executeStep(特記事項の作成31_TEXT);
        }
    }

    /**
     * 厚労省IF識別コードの取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(厚労省IF識別コード)
    protected IBatchFlowCommand koroshoIfShikibetsuCode() {
        return loopBatch(KoroshoShikibetsuCodeProcess.class)
                .arguments(processParameter)
                .define();
    }

    /**
     * 特記事項の区分の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(特記事項の区分)
    protected IBatchFlowCommand ninteichosaReport() {
        return loopBatch(NinteichosaProcess.class)
                .arguments(processParameter)
                .define();
    }

    /**
     * 認定調査票の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(認定調査票の作成02)
    protected IBatchFlowCommand chkNinteiChosahyo02Report() {
        return loopBatch(ChkNinteiChosahyo02Process.class)
                .arguments(processParameter)
                .define();
    }

    /**
     * 認定調査票の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(認定調査票の作成12)
    protected IBatchFlowCommand chkNinteiChosahyo12Report() {
        return loopBatch(ChkNinteiChosahyo12Process.class)
                .arguments(processParameter)
                .define();
    }

    /**
     * 認定調査票の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(認定調査票の作成22)
    protected IBatchFlowCommand chkNinteiChosahyo22Report() {
        return loopBatch(ChkNinteiChosahyo22Process.class)
                .arguments(processParameter)
                .define();
    }

    /**
     * 認定調査票の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(認定調査票の作成32)
    protected IBatchFlowCommand chkNinteiChosahyo32Report() {
        return loopBatch(ChkNinteiChosahyo32Process.class)
                .arguments(processParameter)
                .define();
    }

    /**
     * 認定調査票の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(認定調査票の作成42)
    protected IBatchFlowCommand chkNinteiChosahyo42Report() {
        return loopBatch(ChkNinteiChosahyo42Process.class)
                .arguments(processParameter)
                .define();
    }

    /**
     * 認定調査票の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(認定調査票の作成52)
    protected IBatchFlowCommand chkNinteiChosahyo52Report() {
        return loopBatch(ChkNinteiChosahyo52Process.class)
                .arguments(processParameter)
                .define();
    }

    /**
     * 特記事項（テキスト）の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(特記事項の作成31_TEXT)
    protected IBatchFlowCommand chkTokkiJikoReport31_Text() {
        return loopBatch(ChkTokkiJiko31TextProcess.class)
                .arguments(processParameter)
                .define();
    }

    /**
     * 特記事項の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(特記事項の作成03)
    protected IBatchFlowCommand chkTokkiJikoReport03() {
        return loopBatch(ChkTokkiJiko03Process.class)
                .arguments(processParameter)
                .define();
    }

    /**
     * 主治医意見書の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(主治医意見書の作成)
    protected IBatchFlowCommand chkShujiiIkenshoReport() {
        return loopBatch(ChkShujiiIkenshoProcess.class)
                .arguments(processParameter)
                .define();
    }

    /**
     * その他資料の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(その他資料の作成)
    protected IBatchFlowCommand chkSonotaShiryoReport() {
        return loopBatch(ChkSonotaShiryoProcess.class)
                .arguments(processParameter)
                .define();
    }

    /**
     * 一次判定結果の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(一次判定結果の作成)
    protected IBatchFlowCommand chkIchijiHanteiKekkaReport() {
        return loopBatch(ChkIchijiHanteiKekkaProcess.class)
                .arguments(processParameter)
                .define();
    }

    /**
     * 要介護認定申請情報の更新を行います。
     *
     * @return バッチコマンド
     */
    @Step(要介護認定申請情報の更新)
    protected IBatchFlowCommand updateData() {
        return loopBatch(UpdateDataProcess.class)
                .arguments(processParameter)
                .define();
    }
}
