/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010.TokuteiKojinJohoTeikyoSetParameterProcess;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU080010.DBU080010_TokuteiKojinJohoTeikyoParameter;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU080010.DBU080010_TokuteiKojinJohoTeikyoParameterHandler;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.RenkeisakiDantainaiTogoAtena;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShinkiIdoKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.TeikyoYohi;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定個人情報提供のバッチフ処理クラスです
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
public class DBU080010_TokuteiKojinJohoTeikyo extends BatchFlowBase<DBU080010_TokuteiKojinJohoTeikyoParameter> {

    private static final String バッチパラメータの取得 = "TokuteiKojinJohoTeikyoSetParameter";
    private static final String 受給者基本情報 = "JukyushaDaicho";
    private static final RString 使用する = new RString("0");
    private static final RString 稼働 = new RString("1");
    private DBU080010_TokuteiKojinJohoTeikyoParameter parameter;
//    private RString 特定個人情報名コード;

    @Override
    protected void defineFlow() {
        RDate システム日付 = RDate.getNowDate();
        if (使用する.equals(DbBusinessConfig.get(ConfigNameDBU.番号制度_使用制御, システム日付))
                && 稼働.equals(DbBusinessConfig.get(ConfigNameDBU.番号制度_提供機能使用制御, システム日付))
                && new RDate(DbBusinessConfig.get(ConfigNameDBU.番号制度_利用開始日, システム日付).toString()).isBeforeOrEquals(システム日付)) {
            parameter = getParameter();
            executeStep(バッチパラメータの取得);
            setバッチパラメータ();
            for (DBU080010_TokuteiKojinJohoTeikyoParameterHandler parameterHandler : parameter.get特定個人情報()) {
                if (TeikyoYohi.提供要 == parameterHandler.get受給者()) {
//                    特定個人情報名コード = parameterHandler.get特定個人情報名コード();
                    executeStep(受給者基本情報);
                }
            }
        }
    }

    /**
     * バッチパラメータを取得します。
     *
     * @return IBatchFlowCommand
     */
    @Step(バッチパラメータの取得)
    protected IBatchFlowCommand exeHanKanriNoHantei() {
        return simpleBatch(TokuteiKojinJohoTeikyoSetParameterProcess.class).define();
    }

    /**
     * 受給者基本情報を行います。
     *
     * @return IBatchFlowCommand
     */
//    @Step(受給者基本情報)
//    protected IBatchFlowCommand exeJukyushaDaicho() {
//        JukyushaKihonJohoProcessParameter processParameter = new JukyushaKihonJohoProcessParameter();
//        processParameter.set特定個人情報名コード(特定個人情報名コード);
//        return loopBatch(JukyushaKihonJohoProcess.class).arguments(processParameter).define();
//    }
//
    private void setバッチパラメータ() {
        parameter.set新規異動区分(getResult(ShinkiIdoKubun.class, new RString(バッチパラメータの取得),
                TokuteiKojinJohoTeikyoSetParameterProcess.SHINKIIDOKUBUN));
        parameter.set対象開始日時(getResult(RDateTime.class, new RString(バッチパラメータの取得),
                TokuteiKojinJohoTeikyoSetParameterProcess.TAISHOKAISHITIMESTAMP));
        parameter.set対象終了日時(getResult(RDateTime.class, new RString(バッチパラメータの取得),
                TokuteiKojinJohoTeikyoSetParameterProcess.TAISHOSHURYOTIMESTAMP));
        parameter.set連携先団体内統合宛名_連携方式(getResult(RenkeisakiDantainaiTogoAtena.class, new RString(バッチパラメータの取得),
                TokuteiKojinJohoTeikyoSetParameterProcess.RENKEISAKIDANTAINAITOGOATENA));
        parameter.set対象終了日時(RDateTime.MAX);
    }
}
