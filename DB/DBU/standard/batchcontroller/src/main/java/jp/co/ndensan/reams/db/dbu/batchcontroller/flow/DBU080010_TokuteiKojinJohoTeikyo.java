/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010.HihokenshaJohoNNTempUpdateProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010.HihokenshaJohoProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010.JogaiTokureiSyaJyohouProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010.JogaiTokureiSyaJyohouUpdateProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010.JukyushaKihonJohoTeikyoJohoSyutokuProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010.JukyushaKihonJohoTeikyoKihonJohoNNTempUpdateProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010.KyuufuJyohouProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010.KyuufuJyohouUpdateProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010.RiyoshaFutanwariaiProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010.RiyoshaFutanwariaiUpdateProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010.ShoriDateKanriUpdateProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010.SougouJigyouJyohouProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010.SougouJigyouJyohouUpdateProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010.TokuteiKojinJohoHensyuProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010.TokuteiKojinJohoTeikyoKanriUpdateProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010.TokuteiKojinJohoTeikyoSetParameterProcess;
import jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010.TokuteiKojinKadouKahiHanteiProcess;
import jp.co.ndensan.reams.db.dbu.business.core.basic.TokuteiKojinJohoHanKanri;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU080010.DBU080010_TokuteiKojinJohoTeikyoParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.DataSetNo;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.RenkeisakiDantainaiTogoAtena;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.TokuteiKojinJohomeiCode;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.HihokenshaJohoProcessParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.JogaiTokureiSyaJyohouProcessParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.JukyushaKihonJohoProcessParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.RiyoshaFutanwariaiProcessParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.SougouJigyouJyohouProcessParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.TokuteiKojinJohoHensyuProcessParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.TokuteiKojinJohoTeikyoKanriUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.TokuteiKojinJohoTeikyoProcessParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.TokuteiKojinKadouKahiHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定個人情報提供のバッチフ処理クラスです
 *
 * @reamsid_L DBU-4880-090 wangxiaodong
 */
public class DBU080010_TokuteiKojinJohoTeikyo extends BatchFlowBase<DBU080010_TokuteiKojinJohoTeikyoParameter> {

    private static final String バッチパラメータの取得 = "TokuteiKojinJohoTeikyoSetParameter";
    private static final String 処理日付管理マスタの更新 = "ShoriDateKanriUpdate";
    private static final String 稼働可否の判定 = "TokuteiKojinKadouKahiHantei";
    private static final String 被保険者 = "HihokenshaJoho";
    private static final String 被保険者_更新用 = "HihokenshaJohoNNTempUpdateProcess";
    private static final String 受給者基本情報_提供情報取得 = "JukyushaKihonJohoTeikyoJohoSyutoku";
    private static final String 受給者基本情報_中間DB更新 = "JukyushaKihonJohoNNTempUpdate";
    private static final String 住所地特例者情報 = "JogaiTokureiSyaJyohou";
    private static final String 住所地特例者情報_更新用 = "JogaiTokureiSyaJyohouUpdate";
    private static final String 特定個人情報提供管理_更新 = "TokuteiKojinJohoTeikyoKanriUpdate";
    private static final String 負担割合 = "RiyoshaFutanwariai";
    private static final String 負担割合_更新用 = "RiyoshaFutanwariaiUpdate";
    private static final String 総合事業情報 = "SougouJigyouJyohou";
    private static final String 総合事業情報_更新用 = "SougouJigyouJyohouUpdate";
    private static final String 給付情報 = "KyuufuJyohou";
    private static final String 給付情報_更新用 = "KyuufuJyohouUpdate";
    private static final RString 使用する = new RString("1");
    private static final RString 稼働 = new RString("1");
    private static final RString 文字列_特定個人情報 = new RString("TeikyoKihonJoho");
    private static final RString 文字列_TEMP = new RString("Temp");
    private static final String 特定個人情報編集_標準 = "TokuteiKojinJohoHensyu";
    private DBU080010_TokuteiKojinJohoTeikyoParameter parameter;
    private TokuteiKojinKadouKahiHanteiProcessParameter hanteiProcessParameter;
    private TokuteiKojinJohoTeikyoKanriUpdateProcessParameter updateProcessParameter;
    private TokuteiKojinJohoHensyuProcessParameter hensyuProcessParameter;
    private List<TokuteiKojinJohoHanKanri> 具合版番号情報List;
    private RString 提供基本情報中間テーブル名;
    private RString 特定個人情報名コード;
    private RString 版番号;
    private RDate システム日付;

    @Override
    protected void defineFlow() {
        システム日付 = RDate.getNowDate();
        if (使用する.equals(DbBusinessConfig.get(ConfigNameDBU.番号制度_使用制御, システム日付, SubGyomuCode.DBU介護統計報告))
                && 稼働.equals(DbBusinessConfig.get(ConfigNameDBU.番号制度_提供機能使用制御, システム日付, SubGyomuCode.DBU介護統計報告))
                && new RDate(DbBusinessConfig.get(ConfigNameDBU.番号制度_利用開始日,
                                システム日付, SubGyomuCode.DBU介護統計報告).toString()).isBeforeOrEquals(システム日付)) {
            parameter = getParameter();
            executeStep(バッチパラメータの取得);
            boolean is未来基準日 = getResult(Boolean.class, バッチパラメータの取得,
                    TokuteiKojinJohoTeikyoSetParameterProcess.ISMIRAIDATE);
            if (!is未来基準日) {
                setバッチパラメータ();
                executeStep(処理日付管理マスタの更新);
                exeバッチ処理();
            }
        }
    }

    private void exeバッチ処理() {
        hanteiProcessParameter = parameter.toTokuteiKojinKadouKahiHanteiProcessParameter();
        updateProcessParameter = parameter.toTokuteiKojinJohoTeikyoKanriUpdateProcessParameter();
        for (RString 提供要個人情報名コード : parameter.get特定個人情報()) {
            特定個人情報名コード = 提供要個人情報名コード;
            if (TokuteiKojinJohomeiCode.特定個人情報版管理番号04.getコード().equals(提供要個人情報名コード)) {
                exe住所地特例者情報();
                exe負担割合();
                exe給付情報();
                exe総合事業情報();
            }
            exe被保険者();
            exe受給者基本情報();
        }
    }

    /**
     * バッチパラメータを取得します。
     *
     * @return IBatchFlowCommand
     */
    @Step(バッチパラメータの取得)
    protected IBatchFlowCommand exeHanKanriNoHantei() {
        TokuteiKojinJohoTeikyoProcessParameter processParameter = parameter.toTokuteiKojinJohoTeikyoProcessParameter();
        return simpleBatch(TokuteiKojinJohoTeikyoSetParameterProcess.class).arguments(processParameter).define();
    }

    /**
     * バッチパラメータを取得します。
     *
     * @return IBatchFlowCommand
     */
    @Step(処理日付管理マスタの更新)
    protected IBatchFlowCommand exeShoriDateKanriUpdate() {
        TokuteiKojinJohoTeikyoProcessParameter processParameter = parameter.toTokuteiKojinJohoTeikyoProcessParameter();
        return loopBatch(ShoriDateKanriUpdateProcess.class).arguments(processParameter).define();
    }

    /**
     * 受給者基本情報を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(稼働可否の判定)
    protected IBatchFlowCommand exeJukyushaKihonJohoKadouKahinoHantei() {
        return simpleBatch(TokuteiKojinKadouKahiHanteiProcess.class).arguments(hanteiProcessParameter).define();
    }

    /**
     * 受給者基本情報を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(特定個人情報提供管理_更新)
    protected IBatchFlowCommand updateTokuteiKojinJohoTeikyoKanri() {
        updateProcessParameter.set版番号(版番号);
        updateProcessParameter.set中間テーブル名(提供基本情報中間テーブル名);
        updateProcessParameter.set特定個人情報名コード(特定個人情報名コード);
        return simpleBatch(TokuteiKojinJohoTeikyoKanriUpdateProcess.class).arguments(updateProcessParameter).define();
    }

    private void exe住所地特例者情報() {
        hanteiProcessParameter.setデータセット番号(DataSetNo._0102住所地特例情報.getコード());
        updateProcessParameter.setデータセット番号(DataSetNo._0102住所地特例情報.getコード());
        hanteiProcessParameter.set特定個人情報名コード(特定個人情報名コード);
        updateProcessParameter.set特定個人情報名コード(特定個人情報名コード);
        executeStep(稼働可否の判定);
        exe特定個人情報提供By稼働可否(住所地特例者情報, 住所地特例者情報_更新用);
    }

    private void exe給付情報() {
        hanteiProcessParameter.setデータセット番号(DataSetNo._0300給付情報.getコード());
        hanteiProcessParameter.set特定個人情報名コード(特定個人情報名コード);
        executeStep(稼働可否の判定);
        exe特定個人情報提供By稼働可否(給付情報, 給付情報_更新用);
    }

    private void exe負担割合() {
        hanteiProcessParameter.setデータセット番号(DataSetNo._0202負担割合.getコード());
        hanteiProcessParameter.set特定個人情報名コード(特定個人情報名コード);
        executeStep(稼働可否の判定);
        exe特定個人情報提供By稼働可否(負担割合, 負担割合_更新用);
    }

    private void exe総合事業情報() {
        hanteiProcessParameter.setデータセット番号(DataSetNo._0400総合事業.getコード());
        hanteiProcessParameter.set特定個人情報名コード(特定個人情報名コード);
        executeStep(稼働可否の判定);
        exe特定個人情報提供By稼働可否(総合事業情報, 総合事業情報_更新用);
    }

    private void exe受給者基本情報() {
        hanteiProcessParameter.setデータセット番号(DataSetNo._0201受給者基本情報.getコード());
        hanteiProcessParameter.set特定個人情報名コード(特定個人情報名コード);
        executeStep(稼働可否の判定);
        exe特定個人情報提供By稼働可否(受給者基本情報_提供情報取得, 受給者基本情報_中間DB更新);
    }

    private void exe被保険者() {
        hanteiProcessParameter.setデータセット番号(DataSetNo._0101被保険者情報.getコード());
        hanteiProcessParameter.set特定個人情報名コード(特定個人情報名コード);
        executeStep(稼働可否の判定);
        exe特定個人情報提供By稼働可否(被保険者, 被保険者_更新用);
    }

    /**
     * 受給者基本情報を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(受給者基本情報_提供情報取得)
    protected IBatchFlowCommand exeJukyushaKihonJohoTeikyoJohoSyutoku() {
        JukyushaKihonJohoProcessParameter processParameter = parameter.toJukyushaKihonJohoProcessParameter();
        processParameter.set特定個人情報名コード(特定個人情報名コード);
        processParameter.set提供基本情報中間テーブル名(提供基本情報中間テーブル名);
        return loopBatch(JukyushaKihonJohoTeikyoJohoSyutokuProcess.class).arguments(processParameter).define();
    }

    /**
     * 受給者基本情報を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(受給者基本情報_中間DB更新)
    protected IBatchFlowCommand exeJukyushaDaicho() {
        JukyushaKihonJohoProcessParameter processParameter = parameter.toJukyushaKihonJohoProcessParameter();
        processParameter.set特定個人情報名コード(特定個人情報名コード);
        processParameter.set提供基本情報中間テーブル名(提供基本情報中間テーブル名);
        return loopBatch(JukyushaKihonJohoTeikyoKihonJohoNNTempUpdateProcess.class).arguments(processParameter).define();
    }

    /**
     * 総合事業情報を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(総合事業情報)
    protected IBatchFlowCommand exeSougouJigyouJyohou() {
        SougouJigyouJyohouProcessParameter processParameter = parameter.toSougouJigyouJyohouProcessParameter();
        processParameter.set版番号(版番号);
        processParameter.set特定個人情報名コード(特定個人情報名コード);
        processParameter.set提供基本情報中間テーブル名(提供基本情報中間テーブル名);
        return loopBatch(SougouJigyouJyohouProcess.class).arguments(processParameter).define();
    }

    /**
     * 総合事業情報_更新用を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(総合事業情報_更新用)
    protected IBatchFlowCommand exeSougouJigyouJyohouUpdate() {
        SougouJigyouJyohouProcessParameter processParameter = parameter.toSougouJigyouJyohouProcessParameter();
        processParameter.set版番号(版番号);
        processParameter.set特定個人情報名コード(特定個人情報名コード);
        processParameter.set提供基本情報中間テーブル名(提供基本情報中間テーブル名);
        return loopBatch(SougouJigyouJyohouUpdateProcess.class).arguments(processParameter).define();
    }

    /**
     * 負担割合を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(負担割合)
    protected IBatchFlowCommand exeRiyoshaFutanwariai() {
        RiyoshaFutanwariaiProcessParameter processParameter = parameter.toRiyoshaFutanwariaiProcessParameter();
        processParameter.set版番号(版番号);
        processParameter.set特定個人情報名コード(特定個人情報名コード);
        processParameter.set提供基本情報中間テーブル名(提供基本情報中間テーブル名);
        return loopBatch(RiyoshaFutanwariaiProcess.class).arguments(processParameter).define();
    }

    /**
     * 負担割合_更新用を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(負担割合_更新用)
    protected IBatchFlowCommand exeRiyoshaFutanwariaiUpdate() {
        RiyoshaFutanwariaiProcessParameter processParameter = parameter.toRiyoshaFutanwariaiProcessParameter();
        processParameter.set提供基本情報中間テーブル名(提供基本情報中間テーブル名);
        return loopBatch(RiyoshaFutanwariaiUpdateProcess.class).arguments(processParameter).define();
    }

    /**
     * 給付情報を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(給付情報)
    protected IBatchFlowCommand exeKyuufuJyohou() {
        SougouJigyouJyohouProcessParameter processParameter = parameter.toSougouJigyouJyohouProcessParameter();
        processParameter.set版番号(版番号);
        processParameter.set特定個人情報名コード(特定個人情報名コード);
        processParameter.set提供基本情報中間テーブル名(提供基本情報中間テーブル名);
        return loopBatch(KyuufuJyohouProcess.class).arguments(processParameter).define();
    }

    /**
     * 給付情報_更新用を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(給付情報_更新用)
    protected IBatchFlowCommand exeKyuufuJyohouUpdate() {
        SougouJigyouJyohouProcessParameter processParameter = parameter.toSougouJigyouJyohouProcessParameter();
        processParameter.set版番号(版番号);
        processParameter.set特定個人情報名コード(特定個人情報名コード);
        processParameter.set提供基本情報中間テーブル名(提供基本情報中間テーブル名);
        return loopBatch(KyuufuJyohouUpdateProcess.class).arguments(processParameter).define();
    }

    /**
     * 住所地特例者情報を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(住所地特例者情報)
    protected IBatchFlowCommand exeJogaiTokureiSyaJyohou() {
        JogaiTokureiSyaJyohouProcessParameter processParameter = parameter.toJogaiTokureiSyaJyohouProcessParameter();
        processParameter.set版番号(版番号);
        processParameter.set特定個人情報名コード(特定個人情報名コード);
        processParameter.set提供基本情報中間テーブル名(提供基本情報中間テーブル名);
        return loopBatch(JogaiTokureiSyaJyohouProcess.class).arguments(processParameter).define();
    }

    /**
     * 住所地特例者情報_更新用を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(住所地特例者情報_更新用)
    protected IBatchFlowCommand exeJogaiTokureiSyaJyohouUpdate() {
        JogaiTokureiSyaJyohouProcessParameter processParameter = parameter.toJogaiTokureiSyaJyohouProcessParameter();
        processParameter.set版番号(版番号);
        processParameter.set提供基本情報中間テーブル名(提供基本情報中間テーブル名);
        processParameter.set特定個人情報名コード(特定個人情報名コード);
        return loopBatch(JogaiTokureiSyaJyohouUpdateProcess.class).arguments(processParameter).define();
    }

    /**
     * 被保険者を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(被保険者)
    protected IBatchFlowCommand exeHihokenshaJoho() {
        HihokenshaJohoProcessParameter processParameter = parameter.toHihokenshaJohoProcessParameter();
        processParameter.set版番号(版番号);
        processParameter.set特定個人情報名コード(特定個人情報名コード);
        processParameter.set提供基本情報中間テーブル名(提供基本情報中間テーブル名);
        return loopBatch(HihokenshaJohoProcess.class).arguments(processParameter).define();
    }

    /**
     * 被保険者_更新用を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(被保険者_更新用)
    protected IBatchFlowCommand exeHihokenshaJohoUpdate() {
        HihokenshaJohoProcessParameter processParameter = parameter.toHihokenshaJohoProcessParameter();
        processParameter.set版番号(版番号);
        processParameter.set特定個人情報名コード(特定個人情報名コード);
        processParameter.set提供基本情報中間テーブル名(提供基本情報中間テーブル名);
        return loopBatch(HihokenshaJohoNNTempUpdateProcess.class).arguments(processParameter).define();
    }

    private void exe特定個人情報提供By稼働可否(String stepName1, String stepName2) {
        具合版番号情報List = getResult(List.class, 稼働可否の判定, TokuteiKojinKadouKahiHanteiProcess.HANNOJOHOLIST);
        if (具合版番号情報List != null && !具合版番号情報List.isEmpty()) {
            for (TokuteiKojinJohoHanKanri hanKanri : 具合版番号情報List) {
                提供基本情報中間テーブル名 = 文字列_特定個人情報.concat(
                        特定個人情報名コード.substring(特定個人情報名コード.length() - 2).concat(文字列_TEMP));
                版番号 = hanKanri.get版番号();
                executeStep(stepName1);
                executeStep(stepName2);
                executeStep(特定個人情報提供管理_更新);
                RString 連携先団体内統合宛名_連携方式 = DbBusinessConfig.get(
                        ConfigNameDBU.番号制度_連携先団体内統合宛名_連携方式, システム日付, SubGyomuCode.DBU介護統計報告);
                boolean is電文あり = RenkeisakiDantainaiTogoAtena.標準_中間SVBS.getコード().equals(連携先団体内統合宛名_連携方式);
                if (is電文あり) {
                    set特定個人情報編集標準バッチパラメータ(stepName1);
                    executeStep(特定個人情報編集_標準);
                }
            }
        }
    }

    /**
     * 特定個人情報編集_標準用を行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(特定個人情報編集_標準)
    protected IBatchFlowCommand exeTokuteiKojinJohoHensyu() {
        return loopBatch(TokuteiKojinJohoHensyuProcess.class).arguments(hensyuProcessParameter).define();
    }

    private void setバッチパラメータ() {
        parameter.set新規異動区分(getResult(RString.class, バッチパラメータの取得,
                TokuteiKojinJohoTeikyoSetParameterProcess.SHINKIIDOKUBUN));
        parameter.set対象開始日時(getResult(RDateTime.class, バッチパラメータの取得,
                TokuteiKojinJohoTeikyoSetParameterProcess.TAISHOKAISHITIMESTAMP));
        parameter.set対象終了日時(getResult(RDateTime.class, バッチパラメータの取得,
                TokuteiKojinJohoTeikyoSetParameterProcess.TAISHOSHURYOTIMESTAMP));
        parameter.set連携先団体内統合宛名_連携方式(getResult(RString.class, バッチパラメータの取得,
                TokuteiKojinJohoTeikyoSetParameterProcess.RENKEISAKIDANTAINAITOGOATENA));
    }

    private void set特定個人情報編集標準バッチパラメータ(String processName) {
        TokuteiKojinJohoHensyuProcessParameter processParameter = new TokuteiKojinJohoHensyuProcessParameter();
        processParameter.set中間DBテーブル名(提供基本情報中間テーブル名);
        processParameter.set新規異動区分(parameter.get新規異動区分());
        processParameter.set版番号(版番号);
        switch (processName) {
            case 住所地特例者情報:
                processParameter.set特定個人情報名コード(TokuteiKojinJohomeiCode.特定個人情報版管理番号04.getコード());
                processParameter.setデータセット番号(DataSetNo._0102住所地特例情報.getコード());
                processParameter.set基準日(new FlexibleDate(parameter.get対象終了日時().getDate().toDateString()));
                break;
            case 負担割合:
                processParameter.set特定個人情報名コード(特定個人情報名コード);
                processParameter.setデータセット番号(DataSetNo._0202負担割合.getコード());
                // TODO
                processParameter.set基準日(new FlexibleDate(parameter.get対象終了日時().getDate().toDateString()));
                break;
            case 給付情報:
                processParameter.set特定個人情報名コード(TokuteiKojinJohomeiCode.特定個人情報版管理番号04.getコード());
                processParameter.setデータセット番号(DataSetNo._0300給付情報.getコード());
                processParameter.set基準日(new FlexibleDate(parameter.get対象終了日時().getDate().toDateString()));
                break;
            case 総合事業情報:
                processParameter.set特定個人情報名コード(TokuteiKojinJohomeiCode.特定個人情報版管理番号04.getコード());
                processParameter.setデータセット番号(DataSetNo._0400総合事業.getコード());
                processParameter.set基準日(new FlexibleDate(parameter.get対象終了日時().getDate().toDateString()));
                break;
            case 被保険者:
                processParameter.set特定個人情報名コード(特定個人情報名コード);
                processParameter.setデータセット番号(DataSetNo._0101被保険者情報.getコード());
                // TODO
                processParameter.set基準日(new FlexibleDate(parameter.get対象終了日時().getDate().toDateString()));
                break;
            case 受給者基本情報_中間DB更新:
                processParameter.set特定個人情報名コード(特定個人情報名コード);
                processParameter.setデータセット番号(DataSetNo._0201受給者基本情報.getコード());
                // TODO
                processParameter.set基準日(new FlexibleDate(parameter.get対象終了日時().getDate().toDateString()));
                break;
            default:
                break;
        }
        hensyuProcessParameter = processParameter;
    }
}
