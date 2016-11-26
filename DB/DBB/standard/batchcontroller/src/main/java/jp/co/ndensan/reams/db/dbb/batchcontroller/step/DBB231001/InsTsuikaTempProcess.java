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
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchotaishoshaichiransakusei.TokuchoSeidokanIFSakuseiMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoseidokanifsakusei.TokuchoSeidokanIFSakuseiDBUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakusei.TokuChoSoufuJohoSakuseiEntity;
import jp.co.ndensan.reams.db.dbb.service.tokuchosoufujohosakuseibatch.TokuChoSoufuJohoSakuseiBatch;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
    private static final int NUM6 = 6;
    private final RString 月2 = new RString("02");
    private final RString 月4 = new RString("04");
    private final RString 月6 = new RString("06");
    private final RString 月8 = new RString("08");
    private final RString 月10 = new RString("10");
    private final RString 月12 = new RString("12");
    private final RString 月4開始_待機 = new RString("04");
    private static final RString RS30 = new RString("30");
    private static final RString RS00 = new RString("00");
    private static final RString SELECT = new RString("select");
    private static final RString SELECTFEB = new RString("selectFeb");
    private static final RString SELECTAPR = new RString("selectApr");
    private static final RString SELECTJUN = new RString("selectJun");
    private static final RString SELECTAUG = new RString("selectAug");
    private static final RString SELECTOCT = new RString("selectOct");
    private static final RString SELECTDEC = new RString("selectDec");
    private static final RString 特徴制度間IF全件作成 = new RString("DBBMN84002");
    private static final RString 特徴制度間IF作成 = new RString("DBBMN84001");
    private boolean 月4開始_待機FLG = false;
    private static final RString ORIGINSQLPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "tokuchosoufujohosakusei.ITokuChoSoufuJohoSakuseiMapper.");
    private static final RString SQLPATH101202 = new RString("selectUe10122T0511NenkinTokuchoKaifuJohotemp");
    private static final RString SQLPATH0406 = new RString("select46UeT0511NenkinTokuchoKaifuJohotemp");
    private static final RString SQLPATH08 = new RString("select8UeT0511NenkinTokuchoKaifuJohotemp");
    private TokuchoSeidokanIFSakuseiDBUpdateProcessParameter parameter;
    private RDateTime システム日時;
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
    private TokuchoSeidokanIFSakuseiMyBatisParameter param;
    @BatchWriter
    private IBatchTableWriter<UeT0515KaigohokenNenkinTokuchoTaishoshaJoho550Entity> 対象者情報追加Temp;

    @Override
    protected void initialize() {
        param = new TokuchoSeidokanIFSakuseiMyBatisParameter(parameter.get処理年度());
        int 特徴開始年数 = parameter.get特別徴収開始年月().getYearValue();
        RString 特徴開始月数 = DateConverter.formatMonthFull(parameter.get特別徴収開始年月().getMonthValue());
        FlexibleYear 入力処理年度 = null;
        RString 通知内容コード = null;
        RString 捕捉月 = RString.EMPTY;
        RString 遷移元メニュー = parameter.get遷移元メニュー();
        if (月4開始_待機.equals(DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_6月捕捉, RDate.getNowDate(), SubGyomuCode.DBB介護賦課))
                || 月4開始_待機.equals(
                        DbBusinessConfig.get(ConfigNameDBB.特別徴収_特徴開始月_8月捕捉, RDate.getNowDate(), SubGyomuCode.DBB介護賦課))) {
            月4開始_待機FLG = true;
        }
        if (月8.equals(特徴開始月数)) {
            if (特徴制度間IF全件作成.equals(遷移元メニュー)) {
                param.setSelectSQL(SELECTAUG);
            }
            入力処理年度 = new FlexibleYear(DateConverter.formatYearFull(特徴開始年数));
            通知内容コード = RS30;
            捕捉月 = 月2;
        } else if (月10.equals(特徴開始月数)) {
            if (特徴制度間IF全件作成.equals(遷移元メニュー)) {
                param.setSelectSQL(SELECTOCT);
            }
            入力処理年度 = new FlexibleYear(DateConverter.formatYearFull(特徴開始年数));
            通知内容コード = RS00;
            捕捉月 = 月4;
        } else if (月12.equals(特徴開始月数)) {
            if (特徴制度間IF全件作成.equals(遷移元メニュー)) {
                param.setSelectSQL(SELECTDEC);
            }
            入力処理年度 = new FlexibleYear(DateConverter.formatYearFull(特徴開始年数));
            通知内容コード = RS30;
            捕捉月 = 月6;
        } else if (月2.equals(特徴開始月数)) {
            if (特徴制度間IF全件作成.equals(遷移元メニュー)) {
                param.setSelectSQL(SELECTFEB);
            }
            入力処理年度 = new FlexibleYear(DateConverter.formatYearFull(特徴開始年数 - 1));
            通知内容コード = RS30;
            捕捉月 = 月8;
        } else if (月4.equals(特徴開始月数)) {
            if (特徴制度間IF全件作成.equals(遷移元メニュー)) {
                param.setSelectSQL(SELECTAPR);
            }
            入力処理年度 = new FlexibleYear(DateConverter.formatYearFull(特徴開始年数 - 1));
            通知内容コード = RS30;
            捕捉月 = 月10;
        } else if (月6.equals(特徴開始月数)) {
            if (特徴制度間IF全件作成.equals(遷移元メニュー)) {
                param.setSelectSQL(SELECTJUN);
            }
            入力処理年度 = new FlexibleYear(DateConverter.formatYearFull(特徴開始年数 - 1));
            通知内容コード = RS30;
            捕捉月 = 月12;
        }
        if (特徴制度間IF作成.equals(遷移元メニュー)) {
            param = new TokuchoSeidokanIFSakuseiMyBatisParameter(
                    入力処理年度, 通知内容コード, 捕捉月);
            param.setSelectSQL(SELECT);
        }
        resultEntities = new ArrayList();
        シーケンスMap = new HashMap<>();
        existingFlag = false;
        sakuseiBatch = TokuChoSoufuJohoSakuseiBatch.createInstance();
        if (月2.equals(特徴開始月数) || 月10.equals(特徴開始月数) || 月12.equals(特徴開始月数)) {
            path = ORIGINSQLPATH.concat(SQLPATH101202);
        } else if (月4.equals(特徴開始月数) || 月6.equals(特徴開始月数)) {
            path = ORIGINSQLPATH.concat(SQLPATH0406);
        } else if (月8.equals(特徴開始月数)) {
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
        param.set四月待機フラグ(月4開始_待機FLG);
        return new BatchDbReader(path, param);
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
        if (resultEntities.size() < NUM6 && null != beforeKey && null != nowKey && beforeKey.equals(nowKey)) {
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
