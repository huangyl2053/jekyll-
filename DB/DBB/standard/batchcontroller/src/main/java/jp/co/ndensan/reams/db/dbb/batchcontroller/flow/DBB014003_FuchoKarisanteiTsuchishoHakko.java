/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014003.FuchoKarisanteiKoshingoIchijiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014003.FuchoKarisanteiKoshingoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014003.InsKaigoFukaZenendoTempProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014003.PrtNonyuTsuchishoHakkoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014003.SaishinChoteiNichijiShutokuProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014003.UpdateFukaZenendoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014003.UpdateKeisangoJohoIchijiProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014003.UpdateKeisangoJohoProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014003.UpdateNenkenKoseigoJohoProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB003001.DBB003001_KeisangoJohoSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB014003.BatchFuchoKariSanteiEntity;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB014003.DBB014003_FuchoKarisanteiTsuchishoHakkoParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb014003.FuchoKarisanteiTsuchishoHakkoProcessParameter;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 普徴仮算定通知書一括発行のFlowクラスです。
 *
 * @reamsid_L DBB-0710-030 yebangqiang
 */
public class DBB014003_FuchoKarisanteiTsuchishoHakko extends BatchFlowBase<DBB014003_FuchoKarisanteiTsuchishoHakkoParameter> {

    private DBB014003_FuchoKarisanteiTsuchishoHakkoParameter parameter;

    private static final String 最新調定日時取得 = "saishinChoteiNichijiShutoku";
    private static final String 計算後情報作成 = "keisangoJohoSakusei";
    private static final String 普徴仮算定の更新後データ_計算後情報一時 = "fuchoKarisanteiKoshingoIchiji";
    private static final String 異動賦課情報一時テーブル_計算後情報一時更新 = "updFuchoKarisanteiKoshingoIchiji";
    private static final String 普徴仮算定の更新後データ_計算後情報 = "fuchoKarisanteiKoshingo";
    private static final String 異動賦課情報一時テーブル_計算後情報更新 = "updFuchoKarisanteiKoshingo";
    private static final String 異動賦課情報一時テーブル_年金特徴回付情報更新 = "UpdateNenkenKoseigoJoho";
    private static final String 前年度の賦課情報_介護賦課前年度 = "InsKaigoFukaZenendoTemp";
    private static final String 前年度の賦課情報_更新 = "UpdateFukaZenendo";
    private static final String 納入通知書の発行 = "PrtNonyuTsuchishoHakko";
    private static RString 最新調定日時;
    private YMDHMS システム日時;

    private static final RString KEISANGOJOHOSAKUEEIFLOW_FLOWID = new RString("DBB003001_KeisangoJohoSakusei");

    @Override
    protected void initialize() {
        システム日時 = YMDHMS.now();
    }

    @Override
    protected void defineFlow() {
        parameter = getParameter();
        if (parameter == null) {
            return;
        }
        executeStep(最新調定日時取得);
        最新調定日時 = getResult(RString.class, new RString(最新調定日時取得), SaishinChoteiNichijiShutokuProcess.最新調定日時);
        if (parameter.is一括発行起動フラグ()) {
            executeStep(計算後情報作成);
            executeStep(普徴仮算定の更新後データ_計算後情報一時);
            executeStep(異動賦課情報一時テーブル_計算後情報一時更新);
        } else {
            executeStep(普徴仮算定の更新後データ_計算後情報);
            executeStep(異動賦課情報一時テーブル_計算後情報更新);
        }
        executeStep(異動賦課情報一時テーブル_年金特徴回付情報更新);
        executeStep(前年度の賦課情報_介護賦課前年度);
        executeStep(前年度の賦課情報_更新);
        executeStep(納入通知書の発行);
    }

    /**
     * 処理日付管理テーブル更新を行います。
     *
     * @return バッチコマンド
     */
    @Step(最新調定日時取得)
    protected IBatchFlowCommand saishinChoteiNichijiShutokuProcess() {
        return simpleBatch(SaishinChoteiNichijiShutokuProcess.class).arguments(createParameter()).define();
    }

    /**
     * 計算後情報作成です。
     *
     * @return バッチコマンド
     */
    @Step(計算後情報作成)
    protected IBatchFlowCommand kiisagoJyohouSakuseiIchiProcess() {
        return otherBatchFlow(KEISANGOJOHOSAKUEEIFLOW_FLOWID, SubGyomuCode.DBB介護賦課,
                getKeisangoJohoSakuseiBatchParamter()).define();
    }

    /**
     * 普徴仮算定の更新後データ_計算後情報一時を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(普徴仮算定の更新後データ_計算後情報一時)
    protected IBatchFlowCommand fuchoKarisanteiKoshingoIchijiProcess() {
        return loopBatch(FuchoKarisanteiKoshingoIchijiProcess.class).arguments(createParameter()).define();
    }

    /**
     * 計算後情報一時更新を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(異動賦課情報一時テーブル_計算後情報一時更新)
    protected IBatchFlowCommand updateKeisangoJohoIchijiProcess() {
        return loopBatch(UpdateKeisangoJohoIchijiProcess.class).arguments(createParameter()).define();
    }

    /**
     * 普徴仮算定の更新後データ_計算後情報一時を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(普徴仮算定の更新後データ_計算後情報)
    protected IBatchFlowCommand fuchoKarisanteiKoshingoProcess() {
        return loopBatch(FuchoKarisanteiKoshingoProcess.class).arguments(createParameter()).define();
    }

    /**
     * 計算後情報更新を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(異動賦課情報一時テーブル_計算後情報更新)
    protected IBatchFlowCommand updateKeisangoJohoProcess() {
        return loopBatch(UpdateKeisangoJohoProcess.class).arguments(createParameter()).define();
    }

    /**
     * 年金特徴回付情報更新を呼び出す。
     *
     * @return バッチコマンド
     */
    @Step(異動賦課情報一時テーブル_年金特徴回付情報更新)
    protected IBatchFlowCommand updateNenkenKoseigoJohoProcess() {
        return loopBatch(UpdateNenkenKoseigoJohoProcess.class).arguments(createParameter()).define();
    }

    /**
     * 前年度の賦課情報_介護賦課前年度Tempに出力する。
     *
     * @return バッチコマンド
     */
    @Step(前年度の賦課情報_介護賦課前年度)
    protected IBatchFlowCommand insKaigoFukaZenendoTempProcess() {
        return loopBatch(InsKaigoFukaZenendoTempProcess.class).arguments(createParameter()).define();
    }

    /**
     * 前年度の賦課情報_を更新するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(前年度の賦課情報_更新)
    protected IBatchFlowCommand updateFukaZenendoProcess() {
        return loopBatch(UpdateFukaZenendoProcess.class).arguments(createParameter()).define();
    }

    /**
     * 納入通知書の発行するメソッドです。
     *
     * @return バッチコマンド
     */
    @Step(納入通知書の発行)
    protected IBatchFlowCommand prtNonyuTsuchishoHakkoProcess() {
        return loopBatch(PrtNonyuTsuchishoHakkoProcess.class).arguments(createParameter()).define();
    }

    private DBB003001_KeisangoJohoSakuseiParameter getKeisangoJohoSakuseiBatchParamter() {
        ReportId 帳票分類ID = parameter.get出力帳票一覧List().get(0).get帳票分類ID();
        RString 帳票分類IDR = 帳票分類ID == null || 帳票分類ID.isEmpty() ? RString.EMPTY : 帳票分類ID.getColumnValue();
        return new DBB003001_KeisangoJohoSakuseiParameter(parameter.get調定年度().toDateString(),
                parameter.get賦課年度().toDateString(), 最新調定日時, RString.EMPTY, 帳票分類IDR);
    }

    private FuchoKarisanteiTsuchishoHakkoProcessParameter createParameter() {
        FuchoKarisanteiTsuchishoHakkoProcessParameter processParameter = new FuchoKarisanteiTsuchishoHakkoProcessParameter();
        processParameter.set調定年度(parameter.get調定年度());
        processParameter.set賦課年度(parameter.get賦課年度());
        processParameter.set一括発行起動フラグ(parameter.is一括発行起動フラグ());
        List<BatchFuchoKariSanteiEntity> 出力帳票一覧List = parameter.get出力帳票一覧List();
        processParameter.set出力帳票一覧List(出力帳票一覧List);
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
        processParameter.setShikibetsutaishoParam(new UaFt200FindShikibetsuTaishoParam(searchKey));
        processParameter.set出力期(parameter.get出力期());
        processParameter.set出力期の表示方法(parameter.get出力期の表示方法());
        processParameter.set対象者(parameter.get対象者());
        processParameter.set生活保護対象者をまとめて先頭に出力(parameter.get生活保護対象者をまとめて先頭に出力());
        processParameter.setページごとに山分け(parameter.getページごとに山分け());
        processParameter.set発行日(parameter.get発行日());
        processParameter.setシステム日時(システム日時);
        return processParameter;
    }
}
