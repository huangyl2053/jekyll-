/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB231001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoseidokanifsakusei.TokuchoSeidokanIFSakuseiDBUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakusei.TokuChoSoufuJohoSakuseiEntity;
import jp.co.ndensan.reams.db.dbb.service.tokuchosoufujohosakuseibatch.TokuChoSoufuJohoSakuseiBatch;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険年金特徴対象者情報追加用データ作成のプロセスクラスです。
 *
 * @reamsid_L DBB-1830-040 liuyang
 */
public class InsTsuikaTempProcess extends BatchKeyBreakBase<TokuChoSoufuJohoSakuseiEntity> {

    private static final RString T_対象者情報追加TMP = new RString("KaigohokenNenkinTokuchoTaishoshaJohoTemp");
    private static final int NUM2 = 2;
    private static final int NUM4 = 4;
    private static final int NUM6 = 6;
    private static final int NUM8 = 8;
    private static final int NUM10 = 10;
    private static final int NUM12 = 12;
    private static final RString ORIGINSQLPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "tokuchosoufujohosakusei.ITokuChoSoufuJohoSakuseiMapper.");
    private static final RString SQLPATH101202 = new RString("selectUe10122T0511NenkinTokuchoKaifuJohotemp");
    private static final RString SQLPATH0406 = new RString("select46UeT0511NenkinTokuchoKaifuJohotemp");
    private static final RString SQLPATH08 = new RString("select8UeT0511NenkinTokuchoKaifuJohotemp");
    private TokuchoSeidokanIFSakuseiDBUpdateProcessParameter parameter;
    private RDateTime システム日時;
    private int 特徴開始月数;
    private RString path;
    private boolean existingFlag;
    private TokuChoSoufuJohoSakuseiBatch sakuseiBatch;
    private RString nowKey;
    private RString beforeKey;
    private List<TokuChoSoufuJohoSakuseiEntity> resultEntities;
    private Map<RString, Integer> シーケンスMap;
    private int 連番;
    private YMDHMS 基準日時;
    private RString 特徴開始月_6月捕捉;
    private RString 特徴開始月_8月捕捉;
    @BatchWriter
    private IBatchTableWriter<UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity> 対象者情報追加Temp;

    @Override
    protected void initialize() {
        resultEntities = new ArrayList();
        シーケンスMap = new HashMap<>();
        existingFlag = false;
        sakuseiBatch = TokuChoSoufuJohoSakuseiBatch.createInstance();
        特徴開始月数 = parameter.get特別徴収開始年月().getMonthValue();
        if (特徴開始月数 == NUM2 || 特徴開始月数 == NUM10 || 特徴開始月数 == NUM12) {
            path = ORIGINSQLPATH.concat(SQLPATH101202);
        } else if (特徴開始月数 == NUM4 || 特徴開始月数 == NUM6) {
            path = ORIGINSQLPATH.concat(SQLPATH0406);
        } else if (特徴開始月数 == NUM8) {
            path = ORIGINSQLPATH.concat(SQLPATH08);
        }
    }

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        RDate nowDate = RDate.getNowDate();
        特徴開始月_6月捕捉 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_6月捕捉, nowDate, SubGyomuCode.DBB介護賦課);
        特徴開始月_8月捕捉 = DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_8月捕捉, nowDate, SubGyomuCode.DBB介護賦課);
        基準日時 = sakuseiBatch.chkTokuchoIraikinKeisan(parameter.get特別徴収開始年月(), parameter.get処理年度());
        連番 = sakuseiBatch.get最大の連番();
        システム日時 = parameter.getシステム日時();
    }

    @Override
    protected void createWriter() {
        対象者情報追加Temp = new BatchEntityCreatedTempTableWriter<>(T_対象者情報追加TMP,
                UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(path);
    }

    @Override
    protected void usualProcess(TokuChoSoufuJohoSakuseiEntity entity) {
        existingFlag = true;
        if (getBefore() == null) {
            resultEntities.add(entity);
            return;
        }
        beforeKey = sakuseiBatch.getKeyOfTokuChoSoufuJohoSakuseiEntity(getBefore());
        nowKey = sakuseiBatch.getKeyOfTokuChoSoufuJohoSakuseiEntity(entity);
        if (resultEntities.size() < NUM6 && beforeKey.equals(nowKey)) {
            resultEntities.add(entity);
            return;
        }
        対象者情報追加Temp.insert(sakuseiBatch.setTuikaData(parameter.get特別徴収開始年月(),
                システム日時, 連番, 基準日時, 特徴開始月_6月捕捉, 特徴開始月_8月捕捉, resultEntities, シーケンスMap));
        resultEntities.clear();
        resultEntities.add(entity);
    }

    @Override
    protected void keyBreakProcess(TokuChoSoufuJohoSakuseiEntity entity) {
    }

    @Override
    protected void afterExecute() {
        if (!existingFlag) {
            return;
        }
        対象者情報追加Temp.insert(sakuseiBatch.setTuikaData(parameter.get特別徴収開始年月(),
                システム日時, 連番, 基準日時, 特徴開始月_6月捕捉, 特徴開始月_8月捕捉, resultEntities, シーケンスMap));
    }
}
