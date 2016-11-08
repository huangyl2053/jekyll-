/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA090010;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dba.business.core.atenasealcreate.AtenaSealCreateResult;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba090010.AtenaSealCreateProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.AtenaSealCreateDBZ100001Entity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.DbTAtenaSealCreateTempTableEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.ShorikekkarisutoichijiTBLEntity;
import jp.co.ndensan.reams.db.dbz.business.core.atenaseal.AtenaSealReportBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.report.atenaseal.AtenaSealReport;
import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shutsuryokujun.ShutsuryokujunRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.report.atenaseal.AtenaSealCreateReportSource;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 *
 * 宛名識別対象一時テーブル3の帳票を作成、データを作成します。
 *
 * @reamsid_L DBA-1210-030 zhengsongling
 */
public class ShikakuShutokuToJukyuNinteiShinseityuIgaiCyouHyouProcess extends BatchProcessBase<AtenaSealCreateDBZ100001Entity> {

    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString 現住所 = new RString("genjusho");
    private static final int 枚数_TWELVE = 12;
    private static final int 剰余_THREE = 3;
    private static final int 剰余_FOUR = 4;
    private static final int 剰余_FIVE = 5;
    private static final int 剰余_SIX = 6;
    private static final int 剰余_SEVEN = 7;
    private static final int 剰余_EIGHT = 8;
    private static final int 剰余_NINE = 9;
    private static final int 剰余_TEN = 10;
    private static final int 剰余_ELEVEN = 11;
    private static final int 剰余_ONE = 1;
    private static final int 剰余_TWO = 2;
    private static final RString KAKKORIGHT = new RString("）");
    private static final RString KAKKOLEFT = new RString("（");
    private static final RString ADDRESSEE = new RString("宛名シール");
    private static final RString TABLE_処理結果リスト一時TBL = new RString("ShorikekkarisutoichijiTBL");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.atenasealcreate.IAtenaSealCreateDBZ100001Mapper.getEntityListStree");
    private static final RString TABLE_宛名識別対象一時テーブル3 = new RString("DbWT2009AtenaShikibetuTaisyou3");
    private boolean can終了;
    private AtenaSealCreateProcessParameter processParamter;
    private AtenaSealReportBusiness business;
    private KoikiZenShichosonJoho koikiZenShichosonJoho;
    private Map<Decimal, AtenaSealCreateDBZ100001Entity> mapDBZ100001Entity;
    private Map<Decimal, PersonalData> mapPersonalDataList;
    private int 枚数;
    private int 帳票枚数;
    private ShutsuryokujunRelateEntity 出力順Entity;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時TBL;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 宛名識別対象一時テーブル3;
    @BatchWriter
    private BatchReportWriter<AtenaSealCreateReportSource> batchReportWriter;
    private ReportSourceWriter<AtenaSealCreateReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        koikiZenShichosonJoho = KoikiShichosonJohoFinder.createInstance().koseiShichosonJoho().records().get(0);
        枚数 = 0;
        mapDBZ100001Entity = new HashMap<>();
        mapPersonalDataList = new HashMap<>();
        出力順Entity = get出力順項目();
    }

    @Override
    protected IBatchReader createReader() {
        boolean has出力順 = false;
        if (!RString.isNullOrEmpty(出力順Entity.get出力順OrderBy())) {
            has出力順 = true;
        } else {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage().replace(実行不可MESSAGE.toString()).toString());
        }
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toAtenaSealCreateShutsuMybatisParameter(has出力順, 出力順Entity.get出力順OrderBy()));
    }

    @Override
    protected void createWriter() {
        処理結果リスト一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_処理結果リスト一時TBL,
                ShorikekkarisutoichijiTBLEntity.class);
        宛名識別対象一時テーブル3 = new BatchEntityCreatedTempTableWriter(TABLE_宛名識別対象一時テーブル3,
                DbTAtenaSealCreateTempTableEntity.class);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBZ.DBZ100001.getReportId().value(), SubGyomuCode.DBZ介護共通).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(AtenaSealCreateDBZ100001Entity entity) {
        mapDBZ100001Entity.put(new Decimal(枚数++), entity);
        mapPersonalDataList.put(new Decimal(枚数++), toPersonalData(entity));
    }

    @Override
    protected void afterExecute() {
        List<AtenaSealCreateDBZ100001Entity> listDBZ100001 = new ArrayList<>();
        List<PersonalData> personalDataList = new ArrayList<>();
        List<AtenaSealReportBusiness> listBusiness = new ArrayList<>();
        Set keyDBZ100001Entity = mapDBZ100001Entity.keySet();
        Set keyPersonalDataList = mapPersonalDataList.keySet();
        if (keyDBZ100001Entity != null) {
            Iterator iterator = keyDBZ100001Entity.iterator();
            while (iterator.hasNext()) {
                Object key = iterator.next();
                listDBZ100001.add(mapDBZ100001Entity.get(new Decimal(key.toString())));
            }
        }
        if (keyPersonalDataList != null) {
            Iterator iterator = keyPersonalDataList.iterator();
            while (iterator.hasNext()) {
                Object key = iterator.next();
                personalDataList.add(mapPersonalDataList.get(new Decimal(key.toString())));
            }
        }
        if (listDBZ100001.isEmpty()) {
            処理結果リスト一時TBL.insert(new AtenaSealCreateResult().set処理結果リスト一時TBL());
        } else {
            Collections.sort(listDBZ100001, new ShikakuShutokuToJukyuNinteiShinseityuIgaiCyouHyouProcess.コードComparator());
            if (listDBZ100001.size() == 1) {
                onlyOne(listDBZ100001, listBusiness);
            } else {
                can終了 = false;
                iTeraTion(listDBZ100001, listBusiness);
            }
            for (AtenaSealReportBusiness busi : listBusiness) {
                AtenaSealReport report = new AtenaSealReport(busi);
                report.writeBy(reportSourceWriter);
            }
        }
        AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
    }

    private void iTeraTion(List<AtenaSealCreateDBZ100001Entity> listDBZ100001,
            List<AtenaSealReportBusiness> listBusiness) {
        帳票枚数 = 1;
        business = new AtenaSealReportBusiness();
        for (int i = 0; i < listDBZ100001.size(); i++) {
            if (can終了) {
                business = new AtenaSealReportBusiness();
                can終了 = false;
            }
            if (i + 1 == listDBZ100001.size()) {
                can終了 = true;
                cyouHyou(business, i, listBusiness, listDBZ100001);
                break;
            }
            if (!listDBZ100001.get(i).get市町村コード().equals(listDBZ100001.get(i + 1).get市町村コード())) {
                can終了 = true;
            }
            cyouHyou(business, i, listBusiness, listDBZ100001);
        }
    }

    private void cyouHyou(AtenaSealReportBusiness business, int i,
            List<AtenaSealReportBusiness> listBusiness,
            List<AtenaSealCreateDBZ100001Entity> listDBZ100001) {
        if (帳票枚数 % 枚数_TWELVE == 剰余_ONE) {
            partOne(listDBZ100001, business, i, listBusiness);
        } else if (帳票枚数 % 枚数_TWELVE == 剰余_TWO) {
            partTwo(listDBZ100001, business, i, listBusiness);
        } else if (帳票枚数 % 枚数_TWELVE == 剰余_THREE) {
            partThree(listDBZ100001, business, i, listBusiness);
        } else if (帳票枚数 % 枚数_TWELVE == 剰余_FOUR) {
            partFour(listDBZ100001, business, i, listBusiness);
        } else if (帳票枚数 % 枚数_TWELVE == 剰余_FIVE) {
            partFive(listDBZ100001, business, i, listBusiness);
        } else if (帳票枚数 % 枚数_TWELVE == 剰余_SIX) {
            partSix(listDBZ100001, business, i, listBusiness);
        } else if (帳票枚数 % 枚数_TWELVE == 剰余_SEVEN) {
            partSeven(listDBZ100001, business, i, listBusiness);
        } else if (帳票枚数 % 枚数_TWELVE == 剰余_EIGHT) {
            partEight(listDBZ100001, business, i, listBusiness);
        } else if (帳票枚数 % 枚数_TWELVE == 剰余_NINE) {
            partNine(listDBZ100001, business, i, listBusiness);
        } else if (帳票枚数 % 枚数_TWELVE == 剰余_TEN) {
            partTen(listDBZ100001, business, i, listBusiness);
        } else if (帳票枚数 % 枚数_TWELVE == 剰余_ELEVEN) {
            partEleven(listDBZ100001, business, i, listBusiness);
        } else if (帳票枚数 % 枚数_TWELVE == 0) {
            partTwelve(listDBZ100001, business, i, listBusiness);
        }
        帳票枚数++;
    }

    private static class コードComparator implements Comparator<AtenaSealCreateDBZ100001Entity>, Serializable {

        @Override
        public int compare(AtenaSealCreateDBZ100001Entity o1, AtenaSealCreateDBZ100001Entity o2) {
            return o1.get市町村コード().compareTo(o2.get市町村コード());
        }
    }

    private void onlyOne(List<AtenaSealCreateDBZ100001Entity> listDBZ100001,
            List<AtenaSealReportBusiness> listBusiness) {
        business = new AtenaSealReportBusiness();
        business.setShichosonCode(listDBZ100001.get(0).get市町村コード());
        business.setShichosonName(listDBZ100001.get(0).get市町村名称());
        business.setTitle(ADDRESSEE);
        business.setPrintTimeStamp(dateFormat(RDate.getNowDate().toDateString()));
        business.setYubinNo(listDBZ100001.get(0).get郵便番号());
        business.setGyoseiku(listDBZ100001.get(0).get行政区());
        RString 住所 = nullToEmpty(listDBZ100001.get(0).get住所());
        if (processParamter.isIsshichosonmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get市町村名称());
        }
        if (processParamter.isIstodofukenmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get都道府県名称());
        }
        if (processParamter.isIsgunmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get郡名称());
        }
        business.setJushoText(住所);
        if (processParamter.isIskatagaki()) {
            if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
                business.setKatagakiSmall1(listDBZ100001.get(0).get方書());
            } else {
                business.setKatagakiSmall2(listDBZ100001.get(0).get方書());
            }
        }
        business.setDainoKubunMei(RString.EMPTY);
        if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
            business.setShimeiSmall1(listDBZ100001.get(0).get氏名());
        } else {
            business.setShimeiSmall2(listDBZ100001.get(0).get氏名());
        }
        business.setSamabunShimeiSmall2(processParamter.getKeishou());
        business.setSamabunShimeiSmall1(processParamter.getKeishou());
        business.setKakkoLeft2(KAKKOLEFT);
        business.setKakkoLeft1(KAKKOLEFT);
        business.setMeishoFuyo2(processParamter.getKeishou());
        business.setMeishoFuyo1(processParamter.getKeishou());
        business.setSamaBun2(processParamter.getKeishou());
        business.setSamaBun1(processParamter.getKeishou());
        business.setKakkoRight2(KAKKORIGHT);
        business.setKakkoRight1(KAKKORIGHT);
        business.setCustomerBarCode(listDBZ100001.get(0).getバーコード住所());
        business.set住所(listDBZ100001.get(0).get住所());
        business.set識別コード1(listDBZ100001.get(0).get識別コード());
        listBusiness.add(business);
    }

    private void partOne(List<AtenaSealCreateDBZ100001Entity> listDBZ100001, AtenaSealReportBusiness business, int i,
            List<AtenaSealReportBusiness> listBusiness) {
        business.setShichosonCode(nullToEmpty(listDBZ100001.get(i).get市町村コード()));
        business.setShichosonName(nullToEmpty(listDBZ100001.get(i).get市町村名称()));
        business.setTitle(ADDRESSEE);
        business.setPrintTimeStamp(dateFormat(RDate.getNowDate().toDateString()));
        business.setYubinNo(listDBZ100001.get(i).get郵便番号());
        business.setGyoseiku(listDBZ100001.get(i).get行政区());
        RString 住所 = nullToEmpty(listDBZ100001.get(i).get住所());
        if (processParamter.isIsshichosonmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get市町村名称());
        }
        if (processParamter.isIstodofukenmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get都道府県名称());
        }
        if (processParamter.isIsgunmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get郡名称());
        }
        business.setJushoText(住所);
        if (processParamter.isIskatagaki()) {
            if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
                business.setKatagakiSmall1(listDBZ100001.get(i).get方書());
            } else {
                business.setKatagakiSmall2(listDBZ100001.get(i).get方書());
            }
        }
        business.setDainoKubunMei(RString.EMPTY);
        if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
            business.setShimeiSmall1(listDBZ100001.get(i).get氏名());
        } else {
            business.setShimeiSmall2(listDBZ100001.get(i).get氏名());
        }
        business.setSamabunShimeiSmall2(processParamter.getKeishou());
        business.setSamabunShimeiSmall1(processParamter.getKeishou());
        business.setKakkoLeft2(KAKKOLEFT);
        business.setKakkoLeft1(KAKKOLEFT);
        business.setMeishoFuyo2(processParamter.getKeishou());
        business.setMeishoFuyo1(processParamter.getKeishou());
        business.setSamaBun2(processParamter.getKeishou());
        business.setSamaBun1(processParamter.getKeishou());
        business.setKakkoRight2(KAKKORIGHT);
        business.setKakkoRight1(KAKKORIGHT);
        business.setCustomerBarCode(listDBZ100001.get(i).getバーコード住所());
        business.set識別コード1(listDBZ100001.get(i).get識別コード());
        business.set住所(listDBZ100001.get(i).get住所());
        if (can終了) {
            listBusiness.add(business);
            帳票枚数 = 0;
        }
    }

    private void partTwo(List<AtenaSealCreateDBZ100001Entity> listDBZ100001, AtenaSealReportBusiness business, int i,
            List<AtenaSealReportBusiness> listBusiness) {
        business.setShichosonCode(listDBZ100001.get(i).get市町村コード());
        business.setShichosonName(listDBZ100001.get(i).get市町村名称());
        business.setTitle(ADDRESSEE);
        business.setPrintTimeStamp(dateFormat(RDate.getNowDate().toDateString()));
        business.setYubinNo1(listDBZ100001.get(i).get郵便番号());
        business.setGyoseiku1(listDBZ100001.get(i).get行政区());
        RString 住所 = nullToEmpty(listDBZ100001.get(i).get住所());
        if (processParamter.isIsshichosonmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get市町村名称());
        }
        if (processParamter.isIstodofukenmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get都道府県名称());
        }
        if (processParamter.isIsgunmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get郡名称());
        }
        business.setJushoText1(住所);
        if (processParamter.isIskatagaki()) {
            if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
                business.setKatagakiSmall3(listDBZ100001.get(i).get方書());
            } else {
                business.setKatagakiSmall4(listDBZ100001.get(i).get方書());
            }
        }
        business.setDainoKubunMei1(RString.EMPTY);
        if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
            business.setShimeiSmall3(listDBZ100001.get(i).get氏名());
        } else {
            business.setShimeiSmall4(listDBZ100001.get(i).get氏名());
        }
        business.setSamabunShimeiSmall4(processParamter.getKeishou());
        business.setSamabunShimeiSmall3(processParamter.getKeishou());
        business.setKakkoLeft4(KAKKOLEFT);
        business.setKakkoLeft3(KAKKOLEFT);
        business.setMeishoFuyo4(processParamter.getKeishou());
        business.setMeishoFuyo3(processParamter.getKeishou());
        business.setSamaBun4(processParamter.getKeishou());
        business.setSamaBun3(processParamter.getKeishou());
        business.setKakkoRight4(KAKKORIGHT);
        business.setKakkoRight3(KAKKORIGHT);
        business.setCustomerBarCode1(listDBZ100001.get(i).getバーコード住所());
        business.set識別コード2(listDBZ100001.get(i).get識別コード());
        business.set住所1(listDBZ100001.get(i).get住所());
        if (can終了) {
            listBusiness.add(business);
            帳票枚数 = 0;
        }
    }

    private void partThree(List<AtenaSealCreateDBZ100001Entity> listDBZ100001, AtenaSealReportBusiness business, int i,
            List<AtenaSealReportBusiness> listBusiness) {
        business.setShichosonCode(listDBZ100001.get(i).get市町村コード());
        business.setShichosonName(listDBZ100001.get(i).get市町村名称());
        business.setTitle(ADDRESSEE);
        business.setPrintTimeStamp(dateFormat(RDate.getNowDate().toDateString()));
        business.setYubinNo2(listDBZ100001.get(i).get郵便番号());
        business.setGyoseiku2(listDBZ100001.get(i).get行政区());
        RString 住所 = nullToEmpty(listDBZ100001.get(i).get住所());
        if (processParamter.isIsshichosonmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get市町村名称());
        }
        if (processParamter.isIstodofukenmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get都道府県名称());
        }
        if (processParamter.isIsgunmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get郡名称());
        }
        business.setJushoText2(住所);
        if (processParamter.isIskatagaki()) {
            if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
                business.setKatagakiSmall5(listDBZ100001.get(i).get方書());
            } else {
                business.setKatagakiSmall6(listDBZ100001.get(i).get方書());
            }
        }
        business.setDainoKubunMei3(RString.EMPTY);
        business.setShimeiSmall6(listDBZ100001.get(i).get氏名());
        business.setShimeiSmall5(listDBZ100001.get(i).get氏名());
        business.setSamabunShimeiSmall6(processParamter.getKeishou());
        business.setSamabunShimeiSmall5(processParamter.getKeishou());
        business.setKakkoLeft6(KAKKOLEFT);
        business.setKakkoLeft5(KAKKOLEFT);
        business.setMeishoFuyo6(processParamter.getKeishou());
        business.setMeishoFuyo5(processParamter.getKeishou());
        business.setSamaBun6(processParamter.getKeishou());
        business.setSamaBun5(processParamter.getKeishou());
        business.setKakkoRight6(KAKKORIGHT);
        business.setKakkoRight5(KAKKORIGHT);
        business.setCustomerBarCode2(listDBZ100001.get(i).getバーコード住所());
        business.set識別コード3(listDBZ100001.get(i).get識別コード());
        business.set住所2(listDBZ100001.get(i).get住所());
        if (can終了) {
            listBusiness.add(business);
            帳票枚数 = 0;
        }
    }

    private void partFour(List<AtenaSealCreateDBZ100001Entity> listDBZ100001, AtenaSealReportBusiness business, int i,
            List<AtenaSealReportBusiness> listBusiness) {
        business.setShichosonCode(listDBZ100001.get(i).get市町村コード());
        business.setShichosonName(listDBZ100001.get(i).get市町村名称());
        business.setTitle(ADDRESSEE);
        business.setPrintTimeStamp(dateFormat(RDate.getNowDate().toDateString()));
        business.setYubinNo3(listDBZ100001.get(i).get郵便番号());
        business.setGyoseiku3(listDBZ100001.get(i).get行政区());
        RString 住所 = nullToEmpty(listDBZ100001.get(i).get住所());
        if (processParamter.isIsshichosonmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get市町村名称());
        }
        if (processParamter.isIstodofukenmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get都道府県名称());
        }
        if (processParamter.isIsgunmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get郡名称());
        }
        business.setJushoText3(住所);
        if (processParamter.isIskatagaki()) {
            if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
                business.setKatagakiSmall7(listDBZ100001.get(i).get方書());
            } else {
                business.setKatagakiSmall8(listDBZ100001.get(i).get方書());
            }
        }
        business.setDainoKubunMei3(RString.EMPTY);
        if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
            business.setShimeiSmall7(listDBZ100001.get(i).get氏名());
        } else {
            business.setShimeiSmall8(listDBZ100001.get(i).get氏名());
        }
        business.setSamabunShimeiSmall8(processParamter.getKeishou());
        business.setSamabunShimeiSmall7(processParamter.getKeishou());
        business.setKakkoLeft8(KAKKOLEFT);
        business.setKakkoLeft7(KAKKOLEFT);
        business.setMeishoFuyo8(processParamter.getKeishou());
        business.setMeishoFuyo7(processParamter.getKeishou());
        business.setSamaBun8(processParamter.getKeishou());
        business.setSamaBun7(processParamter.getKeishou());
        business.setKakkoRight8(KAKKORIGHT);
        business.setKakkoRight7(KAKKORIGHT);
        business.setCustomerBarCode3(listDBZ100001.get(i).getバーコード住所());
        business.set識別コード4(listDBZ100001.get(i).get識別コード());
        business.set住所3(listDBZ100001.get(i).get住所());
        if (can終了) {
            listBusiness.add(business);
            帳票枚数 = 0;
        }
    }

    private void partFive(List<AtenaSealCreateDBZ100001Entity> listDBZ100001, AtenaSealReportBusiness business, int i,
            List<AtenaSealReportBusiness> listBusiness) {
        business.setShichosonCode(listDBZ100001.get(i).get市町村コード());
        business.setShichosonName(listDBZ100001.get(i).get市町村名称());
        business.setTitle(ADDRESSEE);
        business.setPrintTimeStamp(dateFormat(RDate.getNowDate().toDateString()));
        business.setYubinNo4(listDBZ100001.get(i).get郵便番号());
        business.setGyoseiku4(listDBZ100001.get(i).get行政区());
        RString 住所 = nullToEmpty(listDBZ100001.get(i).get住所());
        if (processParamter.isIsshichosonmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get市町村名称());
        }
        if (processParamter.isIstodofukenmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get都道府県名称());
        }
        if (processParamter.isIsgunmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get郡名称());
        }
        business.setJushoText4(住所);
        if (processParamter.isIskatagaki()) {
            if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
                business.setKatagakiSmall9(listDBZ100001.get(i).get方書());
            } else {
                business.setKatagakiSmall10(listDBZ100001.get(i).get方書());
            }
        }
        business.setDainoKubunMei4(RString.EMPTY);
        if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
            business.setShimeiSmall9(listDBZ100001.get(i).get氏名());
        } else {
            business.setShimeiSmall10(listDBZ100001.get(i).get氏名());
        }
        business.setSamabunShimeiSmall10(processParamter.getKeishou());
        business.setSamabunShimeiSmall9(processParamter.getKeishou());
        business.setKakkoLeft10(KAKKOLEFT);
        business.setKakkoLeft9(KAKKOLEFT);
        business.setMeishoFuyo10(processParamter.getKeishou());
        business.setMeishoFuyo9(processParamter.getKeishou());
        business.setSamaBun10(processParamter.getKeishou());
        business.setSamaBun9(processParamter.getKeishou());
        business.setKakkoRight10(KAKKORIGHT);
        business.setKakkoRight9(KAKKORIGHT);
        business.setCustomerBarCode4(listDBZ100001.get(i).getバーコード住所());
        business.set識別コード5(listDBZ100001.get(i).get識別コード());
        business.set住所4(listDBZ100001.get(i).get住所());
        if (can終了) {
            listBusiness.add(business);
            帳票枚数 = 0;
        }
    }

    private void partSix(List<AtenaSealCreateDBZ100001Entity> listDBZ100001, AtenaSealReportBusiness business, int i,
            List<AtenaSealReportBusiness> listBusiness) {
        business.setShichosonCode(listDBZ100001.get(i).get市町村コード());
        business.setShichosonName(listDBZ100001.get(i).get市町村名称());
        business.setTitle(ADDRESSEE);
        business.setPrintTimeStamp(dateFormat(RDate.getNowDate().toDateString()));
        business.setYubinNo5(listDBZ100001.get(i).get郵便番号());
        business.setGyoseiku5(listDBZ100001.get(i).get行政区());
        RString 住所 = nullToEmpty(listDBZ100001.get(i).get住所());
        if (processParamter.isIsshichosonmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get市町村名称());
        }
        if (processParamter.isIstodofukenmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get都道府県名称());
        }
        if (processParamter.isIsgunmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get郡名称());
        }
        business.setJushoText5(住所);
        if (processParamter.isIskatagaki()) {
            if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
                business.setKatagakiSmall11(listDBZ100001.get(i).get方書());
            } else {
                business.setKatagakiSmall12(listDBZ100001.get(i).get方書());
            }
        }
        business.setDainoKubunMei5(RString.EMPTY);
        if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
            business.setShimeiSmall11(listDBZ100001.get(i).get氏名());
        } else {
            business.setShimeiSmall12(listDBZ100001.get(i).get氏名());
        }
        business.setSamabunShimeiSmall12(processParamter.getKeishou());
        business.setSamabunShimeiSmall11(processParamter.getKeishou());
        business.setKakkoLeft12(KAKKOLEFT);
        business.setKakkoLeft11(KAKKOLEFT);
        business.setMeishoFuyo12(processParamter.getKeishou());
        business.setMeishoFuyo11(processParamter.getKeishou());
        business.setSamaBun12(processParamter.getKeishou());
        business.setSamaBun11(processParamter.getKeishou());
        business.setKakkoRight12(KAKKORIGHT);
        business.setKakkoRight11(KAKKORIGHT);
        business.setCustomerBarCode5(listDBZ100001.get(i).getバーコード住所());
        business.set識別コード6(listDBZ100001.get(i).get識別コード());
        business.set住所5(listDBZ100001.get(i).get住所());
        if (can終了) {
            listBusiness.add(business);
            帳票枚数 = 0;
        }
    }

    private void partSeven(List<AtenaSealCreateDBZ100001Entity> listDBZ100001, AtenaSealReportBusiness business, int i,
            List<AtenaSealReportBusiness> listBusiness) {
        business.setShichosonCode(listDBZ100001.get(i).get市町村コード());
        business.setShichosonName(listDBZ100001.get(i).get市町村名称());
        business.setTitle(ADDRESSEE);
        business.setPrintTimeStamp(dateFormat(RDate.getNowDate().toDateString()));
        business.setYubinNo6(listDBZ100001.get(i).get郵便番号());
        business.setGyoseiku6(listDBZ100001.get(i).get行政区());
        RString 住所 = nullToEmpty(listDBZ100001.get(i).get住所());
        if (processParamter.isIsshichosonmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get市町村名称());
        }
        if (processParamter.isIstodofukenmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get都道府県名称());
        }
        if (processParamter.isIsgunmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get郡名称());
        }
        business.setJushoText6(住所);
        if (processParamter.isIskatagaki()) {
            if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
                business.setKatagakiSmall13(listDBZ100001.get(i).get方書());
            } else {
                business.setKatagakiSmall14(listDBZ100001.get(i).get方書());
            }
        }
        business.setDainoKubunMei6(RString.EMPTY);
        if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
            business.setShimeiSmall13(listDBZ100001.get(i).get氏名());
        } else {
            business.setShimeiSmall14(listDBZ100001.get(i).get氏名());
        }
        business.setSamabunShimeiSmall14(processParamter.getKeishou());
        business.setSamabunShimeiSmall13(processParamter.getKeishou());
        business.setKakkoLeft14(KAKKOLEFT);
        business.setKakkoLeft13(KAKKOLEFT);
        business.setMeishoFuyo14(processParamter.getKeishou());
        business.setMeishoFuyo13(processParamter.getKeishou());
        business.setSamaBun14(processParamter.getKeishou());
        business.setSamaBun13(processParamter.getKeishou());
        business.setKakkoRight14(KAKKORIGHT);
        business.setKakkoRight13(KAKKORIGHT);
        business.setCustomerBarCode6(listDBZ100001.get(i).getバーコード住所());
        business.set識別コード7(listDBZ100001.get(i).get識別コード());
        business.set住所6(listDBZ100001.get(i).get住所());
        if (can終了) {
            listBusiness.add(business);
            帳票枚数 = 0;
        }
    }

    private void partEight(List<AtenaSealCreateDBZ100001Entity> listDBZ100001, AtenaSealReportBusiness business, int i,
            List<AtenaSealReportBusiness> listBusiness) {
        business.setShichosonCode(listDBZ100001.get(i).get市町村コード());
        business.setShichosonName(listDBZ100001.get(i).get市町村名称());
        business.setTitle(ADDRESSEE);
        business.setPrintTimeStamp(dateFormat(RDate.getNowDate().toDateString()));
        business.setYubinNo7(listDBZ100001.get(i).get郵便番号());
        business.setGyoseiku7(listDBZ100001.get(i).get行政区());
        RString 住所 = nullToEmpty(listDBZ100001.get(i).get住所());
        if (processParamter.isIsshichosonmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get市町村名称());
        }
        if (processParamter.isIstodofukenmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get都道府県名称());
        }
        if (processParamter.isIsgunmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get郡名称());
        }
        business.setJushoText7(住所);
        if (processParamter.isIskatagaki()) {
            if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
                business.setKatagakiSmall15(listDBZ100001.get(i).get方書());
            } else {
                business.setKatagakiSmall16(listDBZ100001.get(i).get方書());
            }
        }
        business.setDainoKubunMei7(RString.EMPTY);
        if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
            business.setShimeiSmall15(listDBZ100001.get(i).get氏名());
        } else {
            business.setShimeiSmall16(listDBZ100001.get(i).get氏名());
        }
        business.setSamabunShimeiSmall16(processParamter.getKeishou());
        business.setSamabunShimeiSmall15(processParamter.getKeishou());
        business.setKakkoLeft18(KAKKOLEFT);
        business.setKakkoLeft17(KAKKOLEFT);
        business.setMeishoFuyo16(processParamter.getKeishou());
        business.setMeishoFuyo15(processParamter.getKeishou());
        business.setSamaBun16(processParamter.getKeishou());
        business.setSamaBun15(processParamter.getKeishou());
        business.setKakkoRight16(KAKKORIGHT);
        business.setKakkoRight15(KAKKORIGHT);
        business.setCustomerBarCode7(listDBZ100001.get(i).getバーコード住所());
        business.set識別コード8(listDBZ100001.get(i).get識別コード());
        business.set住所7(listDBZ100001.get(i).get住所());
        if (can終了) {
            listBusiness.add(business);
            帳票枚数 = 0;
        }
    }

    private void partNine(List<AtenaSealCreateDBZ100001Entity> listDBZ100001, AtenaSealReportBusiness business, int i,
            List<AtenaSealReportBusiness> listBusiness) {
        business.setShichosonCode(listDBZ100001.get(i).get市町村コード());
        business.setShichosonName(listDBZ100001.get(i).get市町村名称());
        business.setTitle(ADDRESSEE);
        business.setPrintTimeStamp(dateFormat(RDate.getNowDate().toDateString()));
        business.setYubinNo8(listDBZ100001.get(i).get郵便番号());
        business.setGyoseiku8(listDBZ100001.get(i).get行政区());
        RString 住所 = nullToEmpty(listDBZ100001.get(i).get住所());
        if (processParamter.isIsshichosonmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get市町村名称());
        }
        if (processParamter.isIstodofukenmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get都道府県名称());
        }
        if (processParamter.isIsgunmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get郡名称());
        }
        business.setJushoText8(住所);
        if (processParamter.isIskatagaki()) {
            if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
                business.setKatagakiSmall17(listDBZ100001.get(i).get方書());
            } else {
                business.setKatagakiSmall18(listDBZ100001.get(i).get方書());
            }
        }
        business.setDainoKubunMei8(RString.EMPTY);
        if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
            business.setShimeiSmall17(listDBZ100001.get(i).get氏名());
        } else {
            business.setShimeiSmall18(listDBZ100001.get(i).get氏名());
        }
        business.setSamabunShimeiSmall18(processParamter.getKeishou());
        business.setSamabunShimeiSmall17(processParamter.getKeishou());
        business.setKakkoLeft18(KAKKOLEFT);
        business.setKakkoLeft17(KAKKOLEFT);
        business.setMeishoFuyo18(processParamter.getKeishou());
        business.setMeishoFuyo17(processParamter.getKeishou());
        business.setSamaBun18(processParamter.getKeishou());
        business.setSamaBun17(processParamter.getKeishou());
        business.setKakkoRight18(KAKKORIGHT);
        business.setKakkoRight17(KAKKORIGHT);
        business.setCustomerBarCode8(listDBZ100001.get(i).getバーコード住所());
        business.set識別コード9(listDBZ100001.get(i).get識別コード());
        business.set住所8(listDBZ100001.get(i).get住所());
        if (can終了) {
            listBusiness.add(business);
            帳票枚数 = 0;
        }
    }

    private void partTen(List<AtenaSealCreateDBZ100001Entity> listDBZ100001, AtenaSealReportBusiness business, int i,
            List<AtenaSealReportBusiness> listBusiness) {
        business.setShichosonCode(listDBZ100001.get(i).get市町村コード());
        business.setShichosonName(listDBZ100001.get(i).get市町村名称());
        business.setTitle(ADDRESSEE);
        business.setPrintTimeStamp(dateFormat(RDate.getNowDate().toDateString()));
        business.setYubinNo9(listDBZ100001.get(i).get郵便番号());
        business.setGyoseiku9(listDBZ100001.get(i).get行政区());
        RString 住所 = nullToEmpty(listDBZ100001.get(i).get住所());
        if (processParamter.isIsshichosonmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get市町村名称());
        }
        if (processParamter.isIstodofukenmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get都道府県名称());
        }
        if (processParamter.isIsgunmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get郡名称());
        }
        business.setJushoText9(住所);
        if (processParamter.isIskatagaki()) {
            if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
                business.setKatagakiSmall19(listDBZ100001.get(i).get方書());
            } else {
                business.setKatagakiSmall20(listDBZ100001.get(i).get方書());
            }
        }
        business.setDainoKubunMei9(RString.EMPTY);
        if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
            business.setShimeiSmall19(listDBZ100001.get(i).get氏名());
        } else {
            business.setShimeiSmall20(listDBZ100001.get(i).get氏名());
        }
        business.setSamabunShimeiSmall20(processParamter.getKeishou());
        business.setSamabunShimeiSmall19(processParamter.getKeishou());
        business.setKakkoLeft20(KAKKOLEFT);
        business.setKakkoLeft19(KAKKOLEFT);
        business.setMeishoFuyo20(processParamter.getKeishou());
        business.setMeishoFuyo19(processParamter.getKeishou());
        business.setSamaBun20(processParamter.getKeishou());
        business.setSamaBun19(processParamter.getKeishou());
        business.setKakkoRight20(KAKKORIGHT);
        business.setKakkoRight19(KAKKORIGHT);
        business.setCustomerBarCode9(listDBZ100001.get(i).getバーコード住所());
        business.set識別コード10(listDBZ100001.get(i).get識別コード());
        business.set住所9(listDBZ100001.get(i).get住所());
        if (can終了) {
            listBusiness.add(business);
            帳票枚数 = 0;
        }
    }

    private void partEleven(List<AtenaSealCreateDBZ100001Entity> listDBZ100001, AtenaSealReportBusiness business, int i,
            List<AtenaSealReportBusiness> listBusiness) {
        business.setShichosonCode(listDBZ100001.get(i).get市町村コード());
        business.setShichosonName(listDBZ100001.get(i).get市町村名称());
        business.setTitle(ADDRESSEE);
        business.setPrintTimeStamp(dateFormat(RDate.getNowDate().toDateString()));
        business.setYubinNo10(listDBZ100001.get(i).get郵便番号());
        business.setGyoseiku10(listDBZ100001.get(i).get行政区());
        RString 住所 = nullToEmpty(listDBZ100001.get(i).get住所());
        if (processParamter.isIsshichosonmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get市町村名称());
        }
        if (processParamter.isIstodofukenmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get都道府県名称());
        }
        if (processParamter.isIsgunmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get郡名称());
        }
        business.setJushoText10(住所);
        if (processParamter.isIskatagaki()) {
            if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
                business.setKatagakiSmall21(listDBZ100001.get(i).get方書());
            } else {
                business.setKatagakiSmall22(listDBZ100001.get(i).get方書());
            }
        }
        business.setDainoKubunMei10(RString.EMPTY);
        if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
            business.setShimeiSmall21(listDBZ100001.get(i).get氏名());
        } else {
            business.setShimeiSmall22(listDBZ100001.get(i).get氏名());
        }
        business.setSamabunShimeiSmall22(processParamter.getKeishou());
        business.setSamabunShimeiSmall21(processParamter.getKeishou());
        business.setKakkoLeft22(KAKKOLEFT);
        business.setKakkoLeft21(KAKKOLEFT);
        business.setMeishoFuyo22(processParamter.getKeishou());
        business.setMeishoFuyo21(processParamter.getKeishou());
        business.setSamaBun22(processParamter.getKeishou());
        business.setSamaBun21(processParamter.getKeishou());
        business.setKakkoRight22(KAKKORIGHT);
        business.setKakkoRight21(KAKKORIGHT);
        business.setCustomerBarCode10(listDBZ100001.get(i).getバーコード住所());
        business.set識別コード11(listDBZ100001.get(i).get識別コード());
        business.set住所10(listDBZ100001.get(i).get住所());
        if (can終了) {
            listBusiness.add(business);
            帳票枚数 = 0;
        }
    }

    private void partTwelve(List<AtenaSealCreateDBZ100001Entity> listDBZ100001, AtenaSealReportBusiness business, int i,
            List<AtenaSealReportBusiness> listBusiness) {
        business.setShichosonCode(listDBZ100001.get(i).get市町村コード());
        business.setShichosonName(listDBZ100001.get(i).get市町村名称());
        business.setTitle(ADDRESSEE);
        business.setPrintTimeStamp(dateFormat(RDate.getNowDate().toDateString()));
        business.setYubinNo11(listDBZ100001.get(i).get郵便番号());
        business.setGyoseiku11(listDBZ100001.get(i).get行政区());
        RString 住所 = nullToEmpty(listDBZ100001.get(i).get住所());
        if (processParamter.isIsshichosonmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get市町村名称());
        }
        if (processParamter.isIstodofukenmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get都道府県名称());
        }
        if (processParamter.isIsgunmeisho()) {
            住所 = 住所.concat(koikiZenShichosonJoho.get郡名称());
        }
        business.setJushoText11(住所);
        if (processParamter.isIskatagaki()) {
            if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
                business.setKatagakiSmall23(listDBZ100001.get(i).get方書());
            } else {
                business.setKatagakiSmall24(listDBZ100001.get(i).get方書());
            }
        }
        business.setDainoKubunMei11(RString.EMPTY);
        if (現住所.equals(processParamter.getSaiyuusenjyusho())) {
            business.setShimeiSmall23(listDBZ100001.get(i).get氏名());
        } else {
            business.setShimeiSmall24(listDBZ100001.get(i).get氏名());
        }
        business.setSamabunShimeiSmall24(processParamter.getKeishou());
        business.setSamabunShimeiSmall23(processParamter.getKeishou());
        business.setKakkoLeft24(KAKKOLEFT);
        business.setKakkoLeft23(KAKKOLEFT);
        business.setMeishoFuyo24(processParamter.getKeishou());
        business.setMeishoFuyo23(processParamter.getKeishou());
        business.setSamaBun24(processParamter.getKeishou());
        business.setSamaBun23(processParamter.getKeishou());
        business.setKakkoRight24(KAKKORIGHT);
        business.setKakkoRight23(KAKKORIGHT);
        business.setCustomerBarCode11(listDBZ100001.get(i).getバーコード住所());
        business.set識別コード12(listDBZ100001.get(i).get識別コード());
        business.set住所11(listDBZ100001.get(i).get住所());
        listBusiness.add(business);
        帳票枚数 = 0;
        can終了 = true;
    }

    private RString dateFormat(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return new FlexibleDate(obj).wareki().fillType(FillType.BLANK).toDateString();
    }

    private ShutsuryokujunRelateEntity get出力順項目() {
        return ReportUtil.get出力順情報(AtenaSealCreateResult.ShutsuryokujunEnum.class,
                SubGyomuCode.DBZ介護共通,
                ReportIdDBZ.DBZ100001.getReportId(),
                processParamter.getShutsutuokujyunid());
    }

    private PersonalData toPersonalData(AtenaSealCreateDBZ100001Entity entity) {
        if (RString.isNullOrEmpty(entity.get識別コード())) {
            return PersonalData.of(ShikibetsuCode.EMPTY);
        } else {
            return PersonalData.of(new ShikibetsuCode(entity.get識別コード()));
        }
    }

    private RString nullToEmpty(RString value) {
        if (RString.isNullOrEmpty(value)) {
            return RString.EMPTY;
        }
        return value;
    }
}
