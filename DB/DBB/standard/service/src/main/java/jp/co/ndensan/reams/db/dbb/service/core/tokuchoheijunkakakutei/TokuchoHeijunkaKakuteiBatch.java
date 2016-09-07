/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokuchoheijunkakakutei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheinjunkakakutei.HeinjunkaAfterParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheinjunkakakutei.TokuchoHeinjunkaKakuteiItirannParameter;
import jp.co.ndensan.reams.db.dbb.entity.csv.TokubetsuChoshuHeijunkaKakuteiCSVEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunkakakutei.FukaTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunkakakutei.TokuchoHeinjunkaKakuteiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunkakakutei.TokuchoHeinjunkaKakuteiItirannEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2003KibetsuDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoheijunkakakutei.ITokuchoHeinjunkaKakuteiMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.fukajoho.fukajoho.FukaJohoManager;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.ue.uex.definition.core.TokubetsuChoshuGimushaCode;
import jp.co.ndensan.reams.ue.uex.definition.core.UEXCodeShubetsu;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * ビジネス設計_DBBBZ35004_1_特徴平準化確定（バッチ）
 *
 * @reamsid_L DBB-0830-050 xuhao
 */
public class TokuchoHeijunkaKakuteiBatch {

    private final MapperProvider mProvider;
    private static final int 整数_ZREO = 0;
    private static final int 整数_ONE = 1;
    private static final int 整数_THREE = 3;
    private final RString コード_ZREO = new RString("0");
    private final RString コード_ONE = new RString("1");
    private final RString コード_ログコード = new RString("0003");
    private final RString 文字列_ONE = new RString("1");
    private final RString 普徴額_1期 = new RString("01");
    private final RString 普徴額_2期 = new RString("02");
    private final RString 普徴額_3期 = new RString("03");
    private final RString 普徴額_4期 = new RString("04");
    private final RString 普徴額_5期 = new RString("05");
    private final RString 普徴額_6期 = new RString("06");
    private final RString 対象 = new RString("対象");
    private final RString 差額以下のため対象外 = new RString("差額以下のため対象外");
    private static final RString キー_調定ID = new RString("choteiId");
    private static final RString キー_収納ID = new RString("shunoId");
    private static final RString 定数_被保険者番号 = new RString("被保険者番号");
    private static final RString タイトル = new RString("介護保険　特徴仮算定平準化確定一覧表");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBB200029"));
    private static final RString 英数字ファイル名 = new RString("TokubetsuChoshuHeijunkaKakuteiData.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString バッチパラメータ名_調定年度 = new RString("【調定年度】");
    private static final RString バッチパラメータ名_調定日時 = new RString("【調定日時】");
    private static final RString 日本語ファイル名 = new RString("介護保険特徴仮算定平準化確定一覧表_作成日時.csv");
    private static final RString CSV出力有無 = new RString("");
    private static final ReportId EUC_ID = new ReportId("DBB012002");

    private EucCsvWriter<TokubetsuChoshuHeijunkaKakuteiCSVEntity> eucCsvWriter;

    private final DbT2003KibetsuDac 介護期別Dac = InstanceProvider.create(DbT2003KibetsuDac.class);
    private final DbT2002FukaDac 介護賦課Dac = InstanceProvider.create(DbT2002FukaDac.class);
    private final DbT7022ShoriDateKanriDac 処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);

    /**
     * コンストラクタです。
     */
    public TokuchoHeijunkaKakuteiBatch() {
        mProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mProvider mProvider
     */
    TokuchoHeijunkaKakuteiBatch(MapperProvider mProvider) {
        this.mProvider = mProvider;
    }

    /**
     * 特徴平準化前後の賦課情報取得
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     */
    public void selectTokuchoHeijunkaFuka(
            FlexibleYear 賦課年度,
            FlexibleYear 調定年度,
            YMDHMS 調定日時) {
        ITokuchoHeinjunkaKakuteiMapper mapper = mProvider.create(ITokuchoHeinjunkaKakuteiMapper.class);
        mapper.create特徴平準化賦課Temp();
        HeinjunkaAfterParameter parameter = HeinjunkaAfterParameter.createParameter(調定年度, 賦課年度, 調定日時);
        FukaJohoManager manager = FukaJohoManager.createInstance();
        List<FukaJoho> 平準化後の賦課の情報List = manager.get平準化後の賦課の情報(parameter);
        for (FukaJoho 平準化後の賦課の情報 : 平準化後の賦課の情報List) {
            TokuchoHeinjunkaKakuteiEntity entity = get平準化後の賦課の情報(平準化後の賦課の情報);
            mapper.inset特徴平準化賦課Temp(entity);
        }
        List<FukaJohoRelateEntity> relateEntityList = mapper.select平準化前の賦課の情報();
        if (relateEntityList != null && !relateEntityList.isEmpty()) {
            for (FukaJohoRelateEntity relateEntity : relateEntityList) {
                relateEntity.initializeMd5ToEntities();
                FukaJoho 平準化前の賦課の情報 = new FukaJoho(relateEntity);
                TokuchoHeinjunkaKakuteiEntity 平準化前entity = new TokuchoHeinjunkaKakuteiEntity();
                平準化前entity.set平準化前調定年度(平準化前の賦課の情報.get調定年度());
                平準化前entity.set平準化前賦課年度(平準化前の賦課の情報.get賦課年度());
                平準化前entity.set平準化前通知書番号(平準化前の賦課の情報.get通知書番号());
                平準化前entity.set平準化前履歴番号(平準化前の賦課の情報.get履歴番号());
                平準化前entity.set平準化前被保険者番号(平準化前の賦課の情報.get被保険者番号());
                平準化前entity.set平準化前識別コード(平準化前の賦課の情報.get識別コード());
                平準化前entity.set平準化前世帯コード(平準化前の賦課の情報.get世帯コード());
                平準化前entity.set平準化前世帯員数(平準化前の賦課の情報.get世帯員数());
                平準化前entity.set平準化前資格取得日(平準化前の賦課の情報.get資格取得日());
                平準化前entity.set平準化前資格取得事由(平準化前の賦課の情報.get資格取得事由());
                平準化前entity.set平準化前資格喪失日(平準化前の賦課の情報.get資格喪失日());
                平準化前entity.set平準化前資格喪失事由(平準化前の賦課の情報.get資格喪失事由());
                平準化前entity.set平準化前生活保護扶助種類(平準化前の賦課の情報.get生活保護扶助種類());
                平準化前entity.set平準化前生保開始日(平準化前の賦課の情報.get生保開始日());
                平準化前entity.set平準化前生保廃止日(平準化前の賦課の情報.get生保廃止日());
                平準化前entity.set平準化前老年開始日(平準化前の賦課の情報.get老年開始日());
                平準化前entity.set平準化前老年廃止日(平準化前の賦課の情報.get老年廃止日());
                平準化前entity.set平準化前賦課期日(平準化前の賦課の情報.get賦課期日());
                平準化前entity.set平準化前課税区分(平準化前の賦課の情報.get課税区分());
                平準化前entity.set平準化前世帯課税区分(平準化前の賦課の情報.get世帯課税区分());
                平準化前entity.set平準化前合計所得金額(平準化前の賦課の情報.get合計所得金額());
                平準化前entity.set平準化前公的年金収入額(平準化前の賦課の情報.get公的年金収入額());
                平準化前entity.set平準化前保険料段階(平準化前の賦課の情報.get保険料段階());
                平準化前entity.set平準化前保険料算定段階1(平準化前の賦課の情報.get保険料算定段階1());
                平準化前entity.set平準化前算定年額保険料1(平準化前の賦課の情報.get算定年額保険料1());
                平準化前entity.set平準化前月割開始年月1(平準化前の賦課の情報.get月割開始年月1());
                平準化前entity.set平準化前月割終了年月1(平準化前の賦課の情報.get月割終了年月1());
                平準化前entity.set平準化前保険料算定段階2(平準化前の賦課の情報.get保険料算定段階2());
                平準化前entity.set平準化前算定年額保険料2(平準化前の賦課の情報.get算定年額保険料2());
                平準化前entity.set平準化前月割開始年月2(平準化前の賦課の情報.get月割開始年月2());
                平準化前entity.set平準化前月割終了年月2(平準化前の賦課の情報.get月割終了年月2());
                平準化前entity.set平準化前調定日時(平準化前の賦課の情報.get調定日時());
                平準化前entity.set平準化前調定事由1(平準化前の賦課の情報.get調定事由1());
                平準化前entity.set平準化前調定事由2(平準化前の賦課の情報.get調定事由2());
                平準化前entity.set平準化前調定事由3(平準化前の賦課の情報.get調定事由3());
                平準化前entity.set平準化前調定事由4(平準化前の賦課の情報.get調定事由4());
                平準化前entity.set平準化前減免前介護保険料_年額(平準化前の賦課の情報.get減免前介護保険料_年額());
                平準化前entity.set平準化前減免額(平準化前の賦課の情報.get減免額());
                平準化前entity.set平準化前確定介護保険料_年額(平準化前の賦課の情報.get確定介護保険料_年額());
                平準化前entity.set平準化前保険料段階_仮算定時(平準化前の賦課の情報.get保険料段階_仮算定時());
                平準化前entity.set平準化前徴収方法履歴番号(平準化前の賦課の情報.get徴収方法履歴番号());
                平準化前entity.set平準化前異動基準日時(平準化前の賦課の情報.get異動基準日時());
                平準化前entity.set平準化前口座区分(平準化前の賦課の情報.get口座区分());
                平準化前entity.set平準化前境界層区分(平準化前の賦課の情報.get境界層区分());
                平準化前entity.set平準化前職権区分(平準化前の賦課の情報.get職権区分());
                平準化前entity.set平準化前賦課市町村コード(平準化前の賦課の情報.get賦課市町村コード());
                平準化前entity.set平準化前特徴歳出還付額(平準化前の賦課の情報.get特徴歳出還付額());
                平準化前entity.set平準化前普徴歳出還付額(平準化前の賦課の情報.get普徴歳出還付額());
                平準化前entity.set平準化前特徴期別金額01(平準化前の賦課の情報.get特徴期別金額01());
                平準化前entity.set平準化前特徴期別金額02(平準化前の賦課の情報.get特徴期別金額02());
                平準化前entity.set平準化前特徴期別金額03(平準化前の賦課の情報.get特徴期別金額03());
                平準化前entity.set平準化前特徴期別金額04(平準化前の賦課の情報.get特徴期別金額04());
                平準化前entity.set平準化前特徴期別金額05(平準化前の賦課の情報.get特徴期別金額05());
                平準化前entity.set平準化前特徴期別金額06(平準化前の賦課の情報.get特徴期別金額06());
                平準化前entity.set平準化前普徴期別金額01(平準化前の賦課の情報.get普徴期別金額01());
                平準化前entity.set平準化前普徴期別金額02(平準化前の賦課の情報.get普徴期別金額02());
                平準化前entity.set平準化前普徴期別金額03(平準化前の賦課の情報.get普徴期別金額03());
                平準化前entity.set平準化前普徴期別金額04(平準化前の賦課の情報.get普徴期別金額04());
                平準化前entity.set平準化前普徴期別金額05(平準化前の賦課の情報.get普徴期別金額05());
                平準化前entity.set平準化前普徴期別金額06(平準化前の賦課の情報.get普徴期別金額06());
                平準化前entity.set平準化前普徴期別金額07(平準化前の賦課の情報.get普徴期別金額07());
                平準化前entity.set平準化前普徴期別金額08(平準化前の賦課の情報.get普徴期別金額08());
                平準化前entity.set平準化前普徴期別金額09(平準化前の賦課の情報.get普徴期別金額09());
                平準化前entity.set平準化前普徴期別金額10(平準化前の賦課の情報.get普徴期別金額10());
                平準化前entity.set平準化前普徴期別金額11(平準化前の賦課の情報.get普徴期別金額11());
                平準化前entity.set平準化前普徴期別金額12(平準化前の賦課の情報.get普徴期別金額12());
                平準化前entity.set平準化前普徴期別金額13(平準化前の賦課の情報.get普徴期別金額13());
                平準化前entity.set平準化前普徴期別金額14(平準化前の賦課の情報.get普徴期別金額14());
                mapper.update特徴平準化賦課Temp(平準化前entity);
            }
        }
    }

    private TokuchoHeinjunkaKakuteiEntity get平準化後の賦課の情報(FukaJoho 平準化後の賦課の情報) {
        TokuchoHeinjunkaKakuteiEntity entity = new TokuchoHeinjunkaKakuteiEntity();
        entity.set調定年度(平準化後の賦課の情報.get調定年度());
        entity.set賦課年度(平準化後の賦課の情報.get賦課年度());
        entity.set通知書番号(平準化後の賦課の情報.get通知書番号());
        entity.set履歴番号(平準化後の賦課の情報.get履歴番号());
        entity.set被保険者番号(平準化後の賦課の情報.get被保険者番号());
        entity.set識別コード(平準化後の賦課の情報.get識別コード());
        entity.set世帯コード(平準化後の賦課の情報.get世帯コード());
        entity.set世帯員数(平準化後の賦課の情報.get世帯員数());
        entity.set資格取得日(平準化後の賦課の情報.get資格取得日());
        entity.set資格取得事由(平準化後の賦課の情報.get資格取得事由());
        entity.set資格喪失日(平準化後の賦課の情報.get資格喪失日());
        entity.set資格喪失事由(平準化後の賦課の情報.get資格喪失事由());
        entity.set生活保護扶助種類(平準化後の賦課の情報.get生活保護扶助種類());
        entity.set生保開始日(平準化後の賦課の情報.get生保開始日());
        entity.set生保廃止日(平準化後の賦課の情報.get生保廃止日());
        entity.set老年開始日(平準化後の賦課の情報.get老年開始日());
        entity.set老年廃止日(平準化後の賦課の情報.get老年廃止日());
        entity.set賦課期日(平準化後の賦課の情報.get賦課期日());
        entity.set課税区分(平準化後の賦課の情報.get課税区分());
        entity.set世帯課税区分(平準化後の賦課の情報.get世帯課税区分());
        entity.set合計所得金額(平準化後の賦課の情報.get合計所得金額());
        entity.set公的年金収入額(平準化後の賦課の情報.get公的年金収入額());
        entity.set保険料段階(平準化後の賦課の情報.get保険料段階());
        entity.set保険料算定段階1(平準化後の賦課の情報.get保険料算定段階1());
        entity.set算定年額保険料1(平準化後の賦課の情報.get算定年額保険料1());
        entity.set月割開始年月1(平準化後の賦課の情報.get月割開始年月1());
        entity.set月割終了年月1(平準化後の賦課の情報.get月割終了年月1());
        entity.set保険料算定段階2(平準化後の賦課の情報.get保険料算定段階2());
        entity.set算定年額保険料2(平準化後の賦課の情報.get算定年額保険料2());
        entity.set月割開始年月2(平準化後の賦課の情報.get月割開始年月2());
        entity.set月割終了年月2(平準化後の賦課の情報.get月割終了年月2());
        entity.set調定日時(平準化後の賦課の情報.get調定日時());
        entity.set調定事由1(平準化後の賦課の情報.get調定事由1());
        entity.set調定事由2(平準化後の賦課の情報.get調定事由2());
        entity.set調定事由3(平準化後の賦課の情報.get調定事由3());
        entity.set調定事由4(平準化後の賦課の情報.get調定事由4());
        entity.set減免前介護保険料_年額(平準化後の賦課の情報.get減免前介護保険料_年額());
        entity.set減免額(平準化後の賦課の情報.get減免額());
        entity.set確定介護保険料_年額(平準化後の賦課の情報.get確定介護保険料_年額());
        entity.set保険料段階_仮算定時(平準化後の賦課の情報.get保険料段階_仮算定時());
        entity.set徴収方法履歴番号(平準化後の賦課の情報.get徴収方法履歴番号());
        entity.set異動基準日時(平準化後の賦課の情報.get異動基準日時());
        entity.set口座区分(平準化後の賦課の情報.get口座区分());
        entity.set境界層区分(平準化後の賦課の情報.get境界層区分());
        entity.set職権区分(平準化後の賦課の情報.get職権区分());
        entity.set賦課市町村コード(平準化後の賦課の情報.get賦課市町村コード());
        entity.set特徴歳出還付額(平準化後の賦課の情報.get特徴歳出還付額());
        entity.set普徴歳出還付額(平準化後の賦課の情報.get普徴歳出還付額());
        entity.set特徴期別金額01(平準化後の賦課の情報.get特徴期別金額01());
        entity.set特徴期別金額02(平準化後の賦課の情報.get特徴期別金額02());
        entity.set特徴期別金額03(平準化後の賦課の情報.get特徴期別金額03());
        entity.set特徴期別金額04(平準化後の賦課の情報.get特徴期別金額04());
        entity.set特徴期別金額05(平準化後の賦課の情報.get特徴期別金額05());
        entity.set特徴期別金額06(平準化後の賦課の情報.get特徴期別金額06());
        entity.set普徴期別金額01(平準化後の賦課の情報.get普徴期別金額01());
        entity.set普徴期別金額02(平準化後の賦課の情報.get普徴期別金額02());
        entity.set普徴期別金額03(平準化後の賦課の情報.get普徴期別金額03());
        entity.set普徴期別金額04(平準化後の賦課の情報.get普徴期別金額04());
        entity.set普徴期別金額05(平準化後の賦課の情報.get普徴期別金額05());
        entity.set普徴期別金額06(平準化後の賦課の情報.get普徴期別金額06());
        entity.set普徴期別金額07(平準化後の賦課の情報.get普徴期別金額07());
        entity.set普徴期別金額08(平準化後の賦課の情報.get普徴期別金額08());
        entity.set普徴期別金額09(平準化後の賦課の情報.get普徴期別金額09());
        entity.set普徴期別金額10(平準化後の賦課の情報.get普徴期別金額10());
        entity.set普徴期別金額11(平準化後の賦課の情報.get普徴期別金額11());
        entity.set普徴期別金額12(平準化後の賦課の情報.get普徴期別金額12());
        entity.set普徴期別金額13(平準化後の賦課の情報.get普徴期別金額13());
        entity.set普徴期別金額14(平準化後の賦課の情報.get普徴期別金額14());
        RString 調定ID = RString.EMPTY;
        for (int i = 整数_ZREO; i < 平準化後の賦課の情報.get調定ID().size(); i++) {
            調定ID = 調定ID.concat(new RString(平準化後の賦課の情報.get調定ID().get(i).toString()).concat(EUC_WRITER_DELIMITER));
        }
        entity.set調定ID(調定ID.substring(整数_ZREO, 調定ID.length() - 整数_ONE));
        RString 収納ID = RString.EMPTY;
        for (int i = 整数_ZREO; i < 平準化後の賦課の情報.get収納ID().size(); i++) {
            収納ID = 収納ID.concat(new RString(平準化後の賦課の情報.get収納ID().get(i).toString()).concat(EUC_WRITER_DELIMITER));
        }
        entity.set収納ID(収納ID.substring(整数_ZREO, 収納ID.length() - 整数_ONE));
        return entity;
    }

    /**
     * 対象と対象外取得
     *
     * @param 遷移区分 Code
     * @param 差額Map Map<RString, Decimal>
     */
    public void selectTaishoJoho(
            RString 遷移区分,
            Map<RString, Decimal> 差額Map) {
        ITokuchoHeinjunkaKakuteiMapper mapper = mProvider.create(ITokuchoHeinjunkaKakuteiMapper.class);
        List<TokuchoHeinjunkaKakuteiEntity> 賦課情報List = mapper.select特徴平準化賦課Temp();
        List<FukaTempEntity> 賦課EntityList = new ArrayList<>();
        for (TokuchoHeinjunkaKakuteiEntity 賦課情報 : 賦課情報List) {
            RString 平準化後保険料段階_仮算定時 = 賦課情報.get保険料段階_仮算定時();
            Decimal 差額 = 差額Map.get(平準化後保険料段階_仮算定時);
            if (差額 != null) {
                FukaTempEntity 賦課Entity = 対象と対象外の判定(遷移区分, 差額, 賦課情報);
                賦課EntityList.add(賦課Entity);
            }
        }
        mapper.create賦課Temp();
        for (FukaTempEntity entity : 賦課EntityList) {
            mapper.inset賦課Temp(entity);
        }

    }

    /**
     * 対象と対象外の判定
     *
     * @param 遷移区分 Code
     * @param 差額 Decimal
     * @param 賦課情報 TokuchoHeinjunkaKakuteiEntity
     * @return 賦課Entity
     */
    private FukaTempEntity 対象と対象外の判定(RString 遷移区分, Decimal 差額, TokuchoHeinjunkaKakuteiEntity 賦課情報) {
        FukaTempEntity entity = new FukaTempEntity();
        if (遷移区分.equals(コード_ZREO)) {
            if (差額.equals(Decimal.ZERO)) {
                entity = create賦課Entity(賦課情報);
                entity.set対象区分(コード_ONE);

            } else {
                entity = get賦課Entity_遷移区分_0(差額, 賦課情報, entity);
            }

        }
        if (遷移区分.equals(コード_ONE)) {
            if (差額.equals(Decimal.ZERO)) {
                entity = create賦課Entity(賦課情報);
                entity.set対象区分(コード_ONE);

            } else {
                entity = get賦課Entity_遷移区分_1(差額, 賦課情報, entity);
            }
        }
        return entity;
    }

    private FukaTempEntity get賦課Entity_遷移区分_0(Decimal 差額, TokuchoHeinjunkaKakuteiEntity 賦課情報, FukaTempEntity entity) {
        Decimal 期別差額 = Decimal.ZERO;
        if (賦課情報.get平準化前特徴期別金額02() != null && 賦課情報.get特徴期別金額02() != null) {
            期別差額 = 賦課情報.get平準化前特徴期別金額02().subtract(賦課情報.get特徴期別金額02()).abs();
        }
        if (期別差額.subtract(差額).doubleValue() <= 0) {
            entity = create賦課Entity(賦課情報);
            entity.set対象区分(コード_ZREO);

        } else {
            entity = create賦課Entity(賦課情報);
            entity.set対象区分(コード_ONE);
        }
        return entity;
    }

    private FukaTempEntity get賦課Entity_遷移区分_1(Decimal 差額, TokuchoHeinjunkaKakuteiEntity 賦課情報, FukaTempEntity entity) {
        Decimal 期別差額 = Decimal.ZERO;
        if (賦課情報.get平準化前特徴期別金額03() != null && 賦課情報.get特徴期別金額03() != null) {
            期別差額 = 賦課情報.get平準化前特徴期別金額03().subtract(賦課情報.get特徴期別金額03()).abs();
        }
        if (期別差額.subtract(差額).doubleValue() <= 0) {
            entity = create賦課Entity(賦課情報);
            entity.set対象区分(コード_ZREO);

        } else {
            entity = create賦課Entity(賦課情報);
            entity.set対象区分(コード_ONE);
        }
        return entity;
    }

    private FukaTempEntity create賦課Entity(TokuchoHeinjunkaKakuteiEntity 賦課情報) {
        FukaTempEntity entity = new FukaTempEntity();
        entity.set平準化前調定年度(賦課情報.get平準化前調定年度());
        entity.set平準化前賦課年度(賦課情報.get平準化前賦課年度());
        entity.set平準化前通知書番号(賦課情報.get平準化前通知書番号());
        entity.set平準化前履歴番号(賦課情報.get平準化前履歴番号());
        entity.set平準化前被保険者番号(賦課情報.get平準化前被保険者番号());
        entity.set平準化前識別コード(賦課情報.get平準化前識別コード());
        entity.set平準化前世帯コード(賦課情報.get平準化前世帯コード());
        entity.set平準化前世帯員数(賦課情報.get平準化前世帯員数());
        entity.set平準化前資格取得日(賦課情報.get平準化前資格取得日());
        entity.set平準化前資格取得事由(賦課情報.get平準化前資格取得事由());
        entity.set平準化前資格喪失日(賦課情報.get平準化前資格喪失日());
        entity.set平準化前資格喪失事由(賦課情報.get平準化前資格喪失事由());
        entity.set平準化前生活保護扶助種類(賦課情報.get平準化前生活保護扶助種類());
        entity.set平準化前生保開始日(賦課情報.get平準化前生保開始日());
        entity.set平準化前生保廃止日(賦課情報.get平準化前生保廃止日());
        entity.set平準化前老年開始日(賦課情報.get平準化前老年開始日());
        entity.set平準化前老年廃止日(賦課情報.get平準化前老年廃止日());
        entity.set平準化前賦課期日(賦課情報.get平準化前賦課期日());
        entity.set平準化前課税区分(賦課情報.get平準化前課税区分());
        entity.set平準化前世帯課税区分(賦課情報.get平準化前世帯課税区分());
        entity.set平準化前合計所得金額(賦課情報.get平準化前合計所得金額());
        entity.set平準化前公的年金収入額(賦課情報.get平準化前公的年金収入額());
        entity.set平準化前保険料段階(賦課情報.get平準化前保険料段階());
        entity.set平準化前保険料算定段階1(賦課情報.get平準化前保険料算定段階1());
        entity.set平準化前算定年額保険料1(賦課情報.get平準化前算定年額保険料1());
        entity.set平準化前月割開始年月1(賦課情報.get平準化前月割開始年月1());
        entity.set平準化前月割終了年月1(賦課情報.get平準化前月割終了年月1());
        entity.set平準化前保険料算定段階2(賦課情報.get平準化前保険料算定段階2());
        entity.set平準化前算定年額保険料2(賦課情報.get平準化前算定年額保険料2());
        entity.set平準化前月割開始年月2(賦課情報.get平準化前月割開始年月2());
        entity.set平準化前月割終了年月2(賦課情報.get平準化前月割終了年月2());
        entity.set平準化前調定日時(賦課情報.get平準化前調定日時());
        entity.set平準化前調定事由1(賦課情報.get平準化前調定事由1());
        entity.set平準化前調定事由2(賦課情報.get平準化前調定事由2());
        entity.set平準化前調定事由3(賦課情報.get平準化前調定事由3());
        entity.set平準化前調定事由4(賦課情報.get平準化前調定事由4());
        entity.set平準化前減免前介護保険料_年額(賦課情報.get平準化前減免前介護保険料_年額());
        entity.set平準化前減免額(賦課情報.get平準化前減免額());
        entity.set平準化前確定介護保険料_年額(賦課情報.get平準化前確定介護保険料_年額());
        entity.set平準化前保険料段階_仮算定時(賦課情報.get平準化前保険料段階_仮算定時());
        entity.set平準化前徴収方法履歴番号(賦課情報.get平準化前徴収方法履歴番号());
        entity.set平準化前異動基準日時(賦課情報.get平準化前異動基準日時());
        entity.set平準化前口座区分(賦課情報.get平準化前口座区分());
        entity.set平準化前境界層区分(賦課情報.get平準化前境界層区分());
        entity.set平準化前職権区分(賦課情報.get平準化前職権区分());
        entity.set平準化前賦課市町村コード(賦課情報.get平準化前賦課市町村コード());
        entity.set平準化前特徴歳出還付額(賦課情報.get平準化前特徴歳出還付額());
        entity.set平準化前普徴歳出還付額(賦課情報.get平準化前普徴歳出還付額());
        entity.set平準化前特徴期別金額01(賦課情報.get平準化前特徴期別金額01());
        entity.set平準化前特徴期別金額02(賦課情報.get平準化前特徴期別金額02());
        entity.set平準化前特徴期別金額03(賦課情報.get平準化前特徴期別金額03());
        entity.set平準化前特徴期別金額04(賦課情報.get平準化前特徴期別金額04());
        entity.set平準化前特徴期別金額05(賦課情報.get平準化前特徴期別金額05());
        entity.set平準化前特徴期別金額06(賦課情報.get平準化前特徴期別金額06());
        entity.set平準化前普徴期別金額01(賦課情報.get平準化前普徴期別金額01());
        entity.set平準化前普徴期別金額02(賦課情報.get平準化前普徴期別金額02());
        entity.set平準化前普徴期別金額03(賦課情報.get平準化前普徴期別金額03());
        entity.set平準化前普徴期別金額04(賦課情報.get平準化前普徴期別金額04());
        entity.set平準化前普徴期別金額05(賦課情報.get平準化前普徴期別金額05());
        entity.set平準化前普徴期別金額06(賦課情報.get平準化前普徴期別金額06());
        entity.set平準化前普徴期別金額07(賦課情報.get平準化前普徴期別金額07());
        entity.set平準化前普徴期別金額08(賦課情報.get平準化前普徴期別金額08());
        entity.set平準化前普徴期別金額09(賦課情報.get平準化前普徴期別金額09());
        entity.set平準化前普徴期別金額10(賦課情報.get平準化前普徴期別金額10());
        entity.set平準化前普徴期別金額11(賦課情報.get平準化前普徴期別金額11());
        entity.set平準化前普徴期別金額12(賦課情報.get平準化前普徴期別金額12());
        entity.set平準化前普徴期別金額13(賦課情報.get平準化前普徴期別金額13());
        entity.set平準化前普徴期別金額14(賦課情報.get平準化前普徴期別金額14());
        entity.set調定年度(賦課情報.get調定年度());
        entity.set賦課年度(賦課情報.get賦課年度());
        entity.set通知書番号(賦課情報.get通知書番号());
        entity.set履歴番号(賦課情報.get履歴番号());
        entity.set被保険者番号(賦課情報.get被保険者番号());
        entity.set識別コード(賦課情報.get識別コード());
        entity.set世帯コード(賦課情報.get世帯コード());
        entity.set世帯員数(賦課情報.get世帯員数());
        entity.set資格取得日(賦課情報.get資格取得日());
        entity.set資格取得事由(賦課情報.get資格取得事由());
        entity.set資格喪失日(賦課情報.get資格喪失日());
        entity.set資格喪失事由(賦課情報.get資格喪失事由());
        entity.set生活保護扶助種類(賦課情報.get生活保護扶助種類());
        entity.set生保開始日(賦課情報.get生保開始日());
        entity.set生保廃止日(賦課情報.get生保廃止日());
        entity.set老年開始日(賦課情報.get老年開始日());
        entity.set老年廃止日(賦課情報.get老年廃止日());
        entity.set賦課期日(賦課情報.get賦課期日());
        entity.set課税区分(賦課情報.get課税区分());
        entity.set世帯課税区分(賦課情報.get世帯課税区分());
        entity.set合計所得金額(賦課情報.get合計所得金額());
        entity.set公的年金収入額(賦課情報.get公的年金収入額());
        entity.set保険料段階(賦課情報.get保険料段階());
        entity.set保険料算定段階1(賦課情報.get保険料算定段階1());
        entity.set算定年額保険料1(賦課情報.get算定年額保険料1());
        entity.set月割開始年月1(賦課情報.get月割開始年月1());
        entity.set月割終了年月1(賦課情報.get月割終了年月1());
        entity.set保険料算定段階2(賦課情報.get保険料算定段階2());
        entity.set算定年額保険料2(賦課情報.get算定年額保険料2());
        entity.set月割開始年月2(賦課情報.get月割開始年月2());
        entity.set月割終了年月2(賦課情報.get月割終了年月2());
        entity.set調定日時(賦課情報.get調定日時());
        entity.set調定事由1(賦課情報.get調定事由1());
        entity.set調定事由2(賦課情報.get調定事由2());
        entity.set調定事由3(賦課情報.get調定事由3());
        entity.set調定事由4(賦課情報.get調定事由4());
        entity.set減免前介護保険料_年額(賦課情報.get減免前介護保険料_年額());
        entity.set減免額(賦課情報.get減免額());
        entity.set確定介護保険料_年額(賦課情報.get確定介護保険料_年額());
        entity.set保険料段階_仮算定時(賦課情報.get保険料段階_仮算定時());
        entity.set徴収方法履歴番号(賦課情報.get徴収方法履歴番号());
        entity.set異動基準日時(賦課情報.get異動基準日時());
        entity.set口座区分(賦課情報.get口座区分());
        entity.set境界層区分(賦課情報.get境界層区分());
        entity.set職権区分(賦課情報.get職権区分());
        entity.set賦課市町村コード(賦課情報.get賦課市町村コード());
        entity.set特徴歳出還付額(賦課情報.get特徴歳出還付額());
        entity.set普徴歳出還付額(賦課情報.get普徴歳出還付額());
        entity.set特徴期別金額01(賦課情報.get特徴期別金額01());
        entity.set特徴期別金額02(賦課情報.get特徴期別金額02());
        entity.set特徴期別金額03(賦課情報.get特徴期別金額03());
        entity.set特徴期別金額04(賦課情報.get特徴期別金額04());
        entity.set特徴期別金額05(賦課情報.get特徴期別金額05());
        entity.set特徴期別金額06(賦課情報.get特徴期別金額06());
        entity.set普徴期別金額01(賦課情報.get普徴期別金額01());
        entity.set普徴期別金額02(賦課情報.get普徴期別金額02());
        entity.set普徴期別金額03(賦課情報.get普徴期別金額03());
        entity.set普徴期別金額04(賦課情報.get普徴期別金額04());
        entity.set普徴期別金額05(賦課情報.get普徴期別金額05());
        entity.set普徴期別金額06(賦課情報.get普徴期別金額06());
        entity.set普徴期別金額07(賦課情報.get普徴期別金額07());
        entity.set普徴期別金額08(賦課情報.get普徴期別金額08());
        entity.set普徴期別金額09(賦課情報.get普徴期別金額09());
        entity.set普徴期別金額10(賦課情報.get普徴期別金額10());
        entity.set普徴期別金額11(賦課情報.get普徴期別金額11());
        entity.set普徴期別金額12(賦課情報.get普徴期別金額12());
        entity.set普徴期別金額13(賦課情報.get普徴期別金額13());
        entity.set普徴期別金額14(賦課情報.get普徴期別金額14());
        entity.set調定ID(賦課情報.get調定ID());
        entity.set収納ID(賦課情報.get収納ID());

        return entity;
    }

    /**
     * 特徴平準化確定
     */
    public void confirmTokuchoHeijunka() {
        ITokuchoHeinjunkaKakuteiMapper mapper = mProvider.create(ITokuchoHeinjunkaKakuteiMapper.class);
        mapper.update調定共通_介護継承();
        List<FukaTempEntity> 賦課TempList = mapper.select賦課Temp();
        for (FukaTempEntity 賦課Temp : 賦課TempList) {
            List<Long> 調定IDList = get調定IDList(賦課Temp.get調定ID());
            List<Long> 収納IDList = get収納IDList(賦課Temp.get収納ID());
            Map<String, Object> parameter_調定ID = new HashMap<>();
            Map<String, Object> parameter_収納ID = new HashMap<>();
            parameter_調定ID.put(キー_調定ID.toString(), 調定IDList);
            parameter_収納ID.put(キー_収納ID.toString(), 収納IDList);
            mapper.delete調定額内訳_介護継承(parameter_調定ID);
            mapper.delete調定状況_介護継承(parameter_収納ID);
            mapper.delete収納管理マスタ_介護継承(parameter_収納ID);
            mapper.delete調定共通_介護継承(parameter_調定ID);
            List<DbT2003KibetsuEntity> 介護期別List = 介護期別Dac.select介護期別(賦課Temp.get調定年度(), 賦課Temp.get賦課年度(),
                    賦課Temp.get通知書番号(), 賦課Temp.get履歴番号(), 文字列_ONE);
            if (介護期別List != null && !介護期別List.isEmpty()) {
                delete介護期別(介護期別List);
            }
            if (コード_ZREO.equals(賦課Temp.get対象区分())) {
                DbT2002FukaEntity entity = 介護賦課Dac.selectByKey(
                        賦課Temp.get調定年度(), 賦課Temp.get賦課年度(), 賦課Temp.get通知書番号(), 賦課Temp.get履歴番号());
                if (entity != null) {
                    entity.setState(EntityDataState.Deleted);
                    介護賦課Dac.delete(entity);
                }
            }
        }
    }

    private void delete介護期別(List<DbT2003KibetsuEntity> 介護期別List) {
        for (DbT2003KibetsuEntity entity : 介護期別List) {
            entity.setState(EntityDataState.Deleted);
            介護期別Dac.delete(entity);
        }
    }

    private List<Long> get調定IDList(RString 調定ID) {
        List<Long> 調定IDList = new ArrayList<>();
        List<RString> 調定List = 調定ID.split(",");
        for (RString 調定 : 調定List) {
            調定IDList.add(Long.valueOf(調定.toString()));
        }
        return 調定IDList;
    }

    private List<Long> get収納IDList(RString 収納ID) {
        List<Long> 収納IDList = new ArrayList<>();
        List<RString> 収納List = 収納ID.split(",");
        for (RString 収納 : 収納List) {
            収納IDList.add(Long.valueOf(収納.toString()));
        }
        return 収納IDList;
    }

    /**
     * 特徴平準化確定CSVファイル出力
     *
     * @param 賦課年度 FlexibleYear
     * @param 調定年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @param 作成日時 YMDHMS
     */
    public void spoolTokuchoHeijunkaKakutei(
            FlexibleYear 賦課年度,
            FlexibleYear 調定年度,
            YMDHMS 調定日時,
            YMDHMS 作成日時) {
        TokuchoHeinjunkaKakuteiItirannParameter paramter = new TokuchoHeinjunkaKakuteiItirannParameter(
                調定日時.getDate().toDateString(), 調定年度.minusYear(整数_ONE));
        ITokuchoHeinjunkaKakuteiMapper mapper = mProvider.create(ITokuchoHeinjunkaKakuteiMapper.class);
        List<TokuchoHeinjunkaKakuteiItirannEntity> 特徴平準化確定一覧entityList = mapper.selest特徴平準化確定一覧(paramter);
        FileSpoolManager manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        RString eucFilePath = Path.combinePath(spoolWorkPath, 英数字ファイル名);
        eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true)
                .build();
        List<PersonalData> personalDataList = new ArrayList<>();
        for (TokuchoHeinjunkaKakuteiItirannEntity 特徴平準化確定一覧 : 特徴平準化確定一覧entityList) {
            TokubetsuChoshuHeijunkaKakuteiCSVEntity entity = setCSVEntity(特徴平準化確定一覧, 賦課年度, 作成日時);
            eucCsvWriter.writeLine(entity);
            personalDataList.add(toPersonalData(特徴平準化確定一覧));

        }
        AccessLogUUID accessLog = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
        manager.spool(SubGyomuCode.DBB介護賦課, eucFilePath, accessLog);
        eucCsvWriter.close();
        バッチ出力条件リストの出力(調定年度, 調定日時);

    }

    private TokubetsuChoshuHeijunkaKakuteiCSVEntity setCSVEntity(TokuchoHeinjunkaKakuteiItirannEntity 特徴平準化確定一覧, FlexibleYear 賦課年度, YMDHMS 作成日時) {
        TokubetsuChoshuHeijunkaKakuteiCSVEntity entity = new TokubetsuChoshuHeijunkaKakuteiCSVEntity();
        entity.set作成年月日(作成日時.getDate().seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString());
        entity.set作成日時(作成日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        entity.setタイトル(タイトル);
        entity.set年度(賦課年度.toDateString());
        set通知書番号(特徴平準化確定一覧, entity);
        set被保険者番号(特徴平準化確定一覧, entity);
        set識別コード(特徴平準化確定一覧, entity);
        set世帯コード(特徴平準化確定一覧, entity);
        set氏名(特徴平準化確定一覧, entity);
        set行政区コード(特徴平準化確定一覧, entity);
        set町域コード(特徴平準化確定一覧, entity);
        set町域_管内_管外住所(特徴平準化確定一覧, entity);
        set番地(特徴平準化確定一覧, entity);
        entity.set保険料段階_仮算定時(特徴平準化確定一覧.getFukeEntity().get保険料段階_仮算定時());
        HokenryoDankaiList 保険料段階リスト = new HokenryoDankaiSettings().getCurrent保険料段階List();
        HokenryoDankai 保険料段階 = 保険料段階リスト.getBy段階区分(特徴平準化確定一覧.getFukeEntity().get保険料段階_仮算定時());
        if (保険料段階.get保険料率() != null) {
            RString 今年度保険料率 = DecimalFormatter.toコンマ区切りRString(保険料段階.get保険料率(), 整数_ZREO);
            entity.set今年度保険料率(今年度保険料率);
        }
        TokubetsuChoshuGimushaCode 特別徴収業務者コード = 特徴平準化確定一覧.get年金特徴回付情報_介護継承().getDtTokubetsuChoshuGimushaCode();
        if (特別徴収業務者コード != null) {
            entity.set特別徴収業務者コード(特別徴収業務者コード.toRString());
            RString 特別徴収業務者 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開, UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(), 特別徴収業務者コード.value());
            entity.set特別徴収業務者(特別徴収業務者);
        }
        RString 特別徴収対象年金コード = 特徴平準化確定一覧.get徴収方法Newest().getKariNenkinCode();
        entity.set特別徴収対象年金コード(特別徴収対象年金コード);
        if (特別徴収対象年金コード != null) {
            RString 特別徴収対象年金 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                    UEXCodeShubetsu.年金コード.getCodeShubetsu(), new Code(特別徴収対象年金コード.substring(整数_ZREO, 整数_THREE)));
            entity.set特別徴収対象年金(特別徴収対象年金);
        }
        set変更前特徴額_１期(特徴平準化確定一覧, entity);
        set変更前特徴額_２期(特徴平準化確定一覧, entity);
        set変更前特徴額_３期(特徴平準化確定一覧, entity);
        set変更後特徴額_１期(特徴平準化確定一覧, entity);
        set変更後特徴額_２期(特徴平準化確定一覧, entity);
        set変更後特徴額_３期(特徴平準化確定一覧, entity);
        set普徴額_1期(特徴平準化確定一覧, entity);
        set普徴額_2期(特徴平準化確定一覧, entity);
        set普徴額_3期(特徴平準化確定一覧, entity);
        set普徴額_4期(特徴平準化確定一覧, entity);
        set普徴額_5期(特徴平準化確定一覧, entity);
        set普徴額_6期(特徴平準化確定一覧, entity);
        if (コード_ZREO.equals(特徴平準化確定一覧.getFukeEntity().get対象区分())) {
            entity.set備考(差額以下のため対象外);
        }
        if (コード_ONE.equals(特徴平準化確定一覧.getFukeEntity().get対象区分())) {
            entity.set備考(対象);
        }
        return entity;
    }

    private void set普徴額_6期(TokuchoHeinjunkaKakuteiItirannEntity 特徴平準化確定一覧, TokubetsuChoshuHeijunkaKakuteiCSVEntity entity) {
        if (is仮徴収期間(普徴額_6期) && 特徴平準化確定一覧.getFukeEntity().get普徴期別金額06() == null) {
            entity.set普徴額_6期(DecimalFormatter.toコンマ区切りRString(Decimal.ZERO, 整数_ZREO));
        }
        if (特徴平準化確定一覧.getFukeEntity().get普徴期別金額06() != null) {
            entity.set普徴額_6期(DecimalFormatter.toコンマ区切りRString(特徴平準化確定一覧.getFukeEntity().get普徴期別金額06(), 整数_ZREO));
        }
    }

    private void set普徴額_5期(TokuchoHeinjunkaKakuteiItirannEntity 特徴平準化確定一覧, TokubetsuChoshuHeijunkaKakuteiCSVEntity entity) {
        if (is仮徴収期間(普徴額_5期) && 特徴平準化確定一覧.getFukeEntity().get普徴期別金額05() == null) {
            entity.set普徴額_5期(DecimalFormatter.toコンマ区切りRString(Decimal.ZERO, 整数_ZREO));
        }
        if (特徴平準化確定一覧.getFukeEntity().get普徴期別金額05() != null) {
            entity.set普徴額_5期(DecimalFormatter.toコンマ区切りRString(特徴平準化確定一覧.getFukeEntity().get普徴期別金額05(), 整数_ZREO));
        }
    }

    private void set普徴額_4期(TokuchoHeinjunkaKakuteiItirannEntity 特徴平準化確定一覧, TokubetsuChoshuHeijunkaKakuteiCSVEntity entity) {
        if (is仮徴収期間(普徴額_4期) && 特徴平準化確定一覧.getFukeEntity().get普徴期別金額04() == null) {
            entity.set普徴額_4期(DecimalFormatter.toコンマ区切りRString(Decimal.ZERO, 整数_ZREO));
        }
        if (特徴平準化確定一覧.getFukeEntity().get普徴期別金額04() != null) {
            entity.set普徴額_4期(DecimalFormatter.toコンマ区切りRString(特徴平準化確定一覧.getFukeEntity().get普徴期別金額04(), 整数_ZREO));
        }
    }

    private void set普徴額_3期(TokuchoHeinjunkaKakuteiItirannEntity 特徴平準化確定一覧, TokubetsuChoshuHeijunkaKakuteiCSVEntity entity) {
        if (is仮徴収期間(普徴額_3期) && 特徴平準化確定一覧.getFukeEntity().get普徴期別金額03() == null) {
            entity.set普徴額_3期(DecimalFormatter.toコンマ区切りRString(Decimal.ZERO, 整数_ZREO));
        }
        if (特徴平準化確定一覧.getFukeEntity().get普徴期別金額03() != null) {
            entity.set普徴額_3期(DecimalFormatter.toコンマ区切りRString(特徴平準化確定一覧.getFukeEntity().get普徴期別金額03(), 整数_ZREO));
        }
    }

    private void set普徴額_2期(TokuchoHeinjunkaKakuteiItirannEntity 特徴平準化確定一覧, TokubetsuChoshuHeijunkaKakuteiCSVEntity entity) {
        if (is仮徴収期間(普徴額_2期) && 特徴平準化確定一覧.getFukeEntity().get普徴期別金額02() == null) {
            entity.set普徴額_2期(DecimalFormatter.toコンマ区切りRString(Decimal.ZERO, 整数_ZREO));
        }
        if (特徴平準化確定一覧.getFukeEntity().get普徴期別金額02() != null) {
            entity.set普徴額_2期(DecimalFormatter.toコンマ区切りRString(特徴平準化確定一覧.getFukeEntity().get普徴期別金額02(), 整数_ZREO));
        }
    }

    private void set普徴額_1期(TokuchoHeinjunkaKakuteiItirannEntity 特徴平準化確定一覧, TokubetsuChoshuHeijunkaKakuteiCSVEntity entity) {
        if (is仮徴収期間(普徴額_1期) && 特徴平準化確定一覧.getFukeEntity().get普徴期別金額01() == null) {
            entity.set普徴額_1期(DecimalFormatter.toコンマ区切りRString(Decimal.ZERO, 整数_ZREO));
        }
        if (特徴平準化確定一覧.getFukeEntity().get普徴期別金額01() != null) {
            entity.set普徴額_1期(DecimalFormatter.toコンマ区切りRString(特徴平準化確定一覧.getFukeEntity().get普徴期別金額01(), 整数_ZREO));
        }
    }

    private void set変更後特徴額_３期(TokuchoHeinjunkaKakuteiItirannEntity 特徴平準化確定一覧, TokubetsuChoshuHeijunkaKakuteiCSVEntity entity) {
        if (特徴平準化確定一覧.getFukeEntity().get特徴期別金額03() != null) {
            entity.set変更後特徴額_３期(DecimalFormatter.toコンマ区切りRString(特徴平準化確定一覧.getFukeEntity().get特徴期別金額03(), 整数_ZREO));
        }
    }

    private void set変更後特徴額_２期(TokuchoHeinjunkaKakuteiItirannEntity 特徴平準化確定一覧, TokubetsuChoshuHeijunkaKakuteiCSVEntity entity) {
        if (特徴平準化確定一覧.getFukeEntity().get特徴期別金額02() != null) {
            entity.set変更後特徴額_２期(DecimalFormatter.toコンマ区切りRString(特徴平準化確定一覧.getFukeEntity().get特徴期別金額02(), 整数_ZREO));
        }
    }

    private void set変更後特徴額_１期(TokuchoHeinjunkaKakuteiItirannEntity 特徴平準化確定一覧, TokubetsuChoshuHeijunkaKakuteiCSVEntity entity) {
        if (特徴平準化確定一覧.getFukeEntity().get特徴期別金額01() != null) {
            entity.set変更後特徴額_１期(DecimalFormatter.toコンマ区切りRString(特徴平準化確定一覧.getFukeEntity().get特徴期別金額01(), 整数_ZREO));
        }
    }

    private void set変更前特徴額_３期(TokuchoHeinjunkaKakuteiItirannEntity 特徴平準化確定一覧, TokubetsuChoshuHeijunkaKakuteiCSVEntity entity) {
        if (特徴平準化確定一覧.getFukeEntity().get平準化前特徴期別金額03() != null) {
            entity.set変更前特徴額_３期(DecimalFormatter.toコンマ区切りRString(特徴平準化確定一覧.getFukeEntity().get平準化前特徴期別金額03(), 整数_ZREO));
        }
    }

    private void set変更前特徴額_２期(TokuchoHeinjunkaKakuteiItirannEntity 特徴平準化確定一覧, TokubetsuChoshuHeijunkaKakuteiCSVEntity entity) {
        if (特徴平準化確定一覧.getFukeEntity().get平準化前特徴期別金額02() != null) {
            entity.set変更前特徴額_２期(DecimalFormatter.toコンマ区切りRString(特徴平準化確定一覧.getFukeEntity().get平準化前特徴期別金額02(), 整数_ZREO));
        }
    }

    private void set変更前特徴額_１期(TokuchoHeinjunkaKakuteiItirannEntity 特徴平準化確定一覧, TokubetsuChoshuHeijunkaKakuteiCSVEntity entity) {
        if (特徴平準化確定一覧.getFukeEntity().get平準化前特徴期別金額01() != null) {
            entity.set変更前特徴額_１期(DecimalFormatter.toコンマ区切りRString(特徴平準化確定一覧.getFukeEntity().get平準化前特徴期別金額01(), 整数_ZREO));
        }
    }

    private void set番地(TokuchoHeinjunkaKakuteiItirannEntity 特徴平準化確定一覧, TokubetsuChoshuHeijunkaKakuteiCSVEntity entity) {
        AtenaBanchi 番地 = 特徴平準化確定一覧.get宛名().getBanchi();
        if (番地 != null) {
            entity.set番地(番地.value());
        }
    }

    private void set町域_管内_管外住所(TokuchoHeinjunkaKakuteiItirannEntity 特徴平準化確定一覧, TokubetsuChoshuHeijunkaKakuteiCSVEntity entity) {
        AtenaJusho 町域_管内_管外住所 = 特徴平準化確定一覧.get宛名().getJusho();
        if (町域_管内_管外住所 != null) {
            entity.set町域_管内_管外住所(町域_管内_管外住所.value());
        }
    }

    private void set町域コード(TokuchoHeinjunkaKakuteiItirannEntity 特徴平準化確定一覧, TokubetsuChoshuHeijunkaKakuteiCSVEntity entity) {
        ChoikiCode 町域コード = 特徴平準化確定一覧.get宛名().getChoikiCode();
        if (町域コード != null) {
            entity.set町域コード(町域コード.value());
        }
    }

    private void set行政区コード(TokuchoHeinjunkaKakuteiItirannEntity 特徴平準化確定一覧, TokubetsuChoshuHeijunkaKakuteiCSVEntity entity) {
        GyoseikuCode 行政区コード = 特徴平準化確定一覧.get宛名().getGyoseikuCode();
        if (行政区コード != null) {
            entity.set行政区コード(行政区コード.value());
        }
    }

    private void set氏名(TokuchoHeinjunkaKakuteiItirannEntity 特徴平準化確定一覧, TokubetsuChoshuHeijunkaKakuteiCSVEntity entity) {
        AtenaMeisho 氏名 = 特徴平準化確定一覧.get宛名().getKanjiShimei();
        if (氏名 != null) {
            entity.set氏名(氏名.value());
        }
    }

    private void set世帯コード(TokuchoHeinjunkaKakuteiItirannEntity 特徴平準化確定一覧, TokubetsuChoshuHeijunkaKakuteiCSVEntity entity) {
        if (特徴平準化確定一覧.getFukeEntity().get世帯コード() != null) {
            entity.set世帯コード(特徴平準化確定一覧.getFukeEntity().get世帯コード().value());
        }
    }

    private void set識別コード(TokuchoHeinjunkaKakuteiItirannEntity 特徴平準化確定一覧, TokubetsuChoshuHeijunkaKakuteiCSVEntity entity) {
        if (特徴平準化確定一覧.getFukeEntity().get識別コード() != null) {
            entity.set識別コード(特徴平準化確定一覧.getFukeEntity().get識別コード().value());
        }
    }

    private void set被保険者番号(TokuchoHeinjunkaKakuteiItirannEntity 特徴平準化確定一覧, TokubetsuChoshuHeijunkaKakuteiCSVEntity entity) {
        if (特徴平準化確定一覧.getFukeEntity().get被保険者番号() != null) {

            entity.set被保険者番号(特徴平準化確定一覧.getFukeEntity().get被保険者番号().value());
        }
    }

    private void set通知書番号(TokuchoHeinjunkaKakuteiItirannEntity 特徴平準化確定一覧, TokubetsuChoshuHeijunkaKakuteiCSVEntity entity) {
        if (特徴平準化確定一覧.getFukeEntity().get通知書番号() != null) {
            entity.set通知書番号(特徴平準化確定一覧.getFukeEntity().get通知書番号().value());
        }
    }

    private boolean is仮徴収期間(RString 期) {
        boolean flag = false;
        FuchoKiUtil 月期対応取得_普徴 = new FuchoKiUtil();
        KitsukiList 期月リスト_普徴 = 月期対応取得_普徴.get期月リスト();
        KitsukiList 仮徴収期間 = 期月リスト_普徴.filtered仮算定期間();
        for (Kitsuki kitsuki : 仮徴収期間.toList()) {
            if (期.equals(kitsuki.get期())) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    private void バッチ出力条件リストの出力(FlexibleYear 調定年度, YMDHMS 調定日時) {
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = 地方公共団体.getLasdecCode_().value();
        RString 市町村名 = 地方公共団体.get市町村名();
        RString 出力件数 = new RString(String.valueOf(eucCsvWriter.getCount()));

        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(バッチパラメータ名_調定年度);
        builder.append(調定年度.wareki().toDateString());
        出力条件.add(builder.toRString());
        RString 帳票作成年月日 = 調定日時.getDate().wareki().toDateString();
        RString 帳票作成時 = 調定日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss);
        builder = new RStringBuilder();
        builder.append(バッチパラメータ名_調定日時);
        builder.append(帳票作成年月日);
        builder.append(RString.FULL_SPACE);
        builder.append(帳票作成時);
        出力条件.add(builder.toRString());

        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                EUC_ID.value(),
                導入団体コード,
                市町村名,
                new RString(String.valueOf(JobContextHolder.getJobId())),
                日本語ファイル名,
                出力件数,
                CSV出力有無,
                英数字ファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private PersonalData toPersonalData(TokuchoHeinjunkaKakuteiItirannEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(コード_ログコード), 定数_被保険者番号,
                entity.getFukeEntity().get被保険者番号().value());
        return PersonalData.of(entity.getFukeEntity().get識別コード(), expandedInfo);
    }

    /**
     * 処理日付管理テーブル更新
     *
     * @param 処理名 RString
     * @param 処理枝番 RString
     * @param 年度 FlexibleYear
     * @param 年度内連番 RString
     * @param システム日時 YMDHMS
     */
    public void update処理日付管理(RString 処理名, RString 処理枝番, FlexibleYear 年度, RString 年度内連番, YMDHMS システム日時) {
        List<DbT7022ShoriDateKanriEntity> entityList = 処理日付管理Dac.selectBySomeKeys(SubGyomuCode.DBB介護賦課,
                処理名, 処理枝番, 年度, 年度内連番);
        if (entityList != null) {
            update処理日付管理(entityList, システム日時);
        }
    }

    private void update処理日付管理(List<DbT7022ShoriDateKanriEntity> entityList, YMDHMS システム日時) {
        for (DbT7022ShoriDateKanriEntity entity : entityList) {
            entity.setKijunTimestamp(システム日時);
            entity.setState(EntityDataState.Modified);
            処理日付管理Dac.save(entity);
        }
    }
}
