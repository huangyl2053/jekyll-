/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180020.work7;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.euc.riyoshafutanwariaihantei.RiyoshaFutanWariaiHanteiCsvEditor;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180020.DBC180020ProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc180020.RiyoshaFutanWariaiHanteiCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.FutanWariaiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.KonkaiRiyoshaFutanWariaiJohoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.RiyoshaFutanWariaiMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.TsukibetsuFutanWariaiTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.riyoshafutanwariaihantei.RiyoshaFutanWariaiHantei;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 利用者負担割合、利用者負担割合明細、今回利用者負担割合情報Tempの登録のクラスです。<br/>
 * 処理詳細11
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class FutanWariaiLoginProcess extends BatchKeyBreakBase<FutanWariaiRelateEntity> {

    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("3");
    private static final RString TABLENAME = new RString("KonkaiRiyoshaFutanWariaiJohoTemp");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "riyoshafutanwariaihantei.IRiyoshaFutanwariaiMapper.select負担割合と明細");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("shoriKekkaKakuninList"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString CSVFILENAME = new RString("shoriKekkaKakuninList.csv");
    private DBC180020ProcessParameter parameter;
    private HihokenshaNo beforeNo;
    private HihokenshaNo nowNo;
    private RiyoshaFutanWariaiMeisaiTempEntity last;
    private FlexibleYear nendo;
    private int rirekiNo;
    private int edaNo;
    private RiyoshaFutanWariaiHanteiCsvEditor csvEditor;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private boolean existingFlag;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 今回利用者負担割合情報Temp;
    @BatchWriter
    private BatchPermanentTableWriter 利用者負担割合Writer;
    @BatchWriter
    private BatchPermanentTableWriter 利用者負担割合明細Writer;

    @BatchWriter
    private CsvWriter<RiyoshaFutanWariaiHanteiCsvEntity> eucCsvWriter;

    @Override
    protected void initialize() {
        existingFlag = false;
        rirekiNo = 1;
        edaNo = 0;
        nendo = new FlexibleYear(parameter.getTaishoNendo().toDateString());
    }

    @Override
    protected void createWriter() {
        this.manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = this.manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, CSVFILENAME);
        RString 文字コード
                = BusinessConfig.get(ConfigNameDBU.EUC共通_文字コード, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(getEncode(文字コード)).
                setNewLine(NewLine.CRLF).
                hasHeader(true).build();
        今回利用者負担割合情報Temp
                = new BatchEntityCreatedTempTableWriter(TABLENAME, KonkaiRiyoshaFutanWariaiJohoTempEntity.class);
        利用者負担割合Writer = new BatchPermanentTableWriter(DbT3113RiyoshaFutanWariaiEntity.class);
        利用者負担割合明細Writer = new BatchPermanentTableWriter(DbT3114RiyoshaFutanWariaiMeisaiEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH, parameter.toMyBatisParameter(RiyoshaFutanWariaiHantei.createInstance().
                getTaishoShuryobi(parameter.getTaishoNendo())));
    }

    @Override
    protected void usualProcess(FutanWariaiRelateEntity entity) {
        existingFlag = true;
        if (getBefore() == null) {
            return;
        }
        List<TsukibetsuFutanWariaiTempEntity> 月別負担割合新リスト = entity.get月別負担割合新();
        List<TsukibetsuFutanWariaiTempEntity> 月別負担割合現リスト = entity.get月別負担割合現();
        if (subProcess(月別負担割合新リスト, 月別負担割合現リスト)) {
            return;
        }
        last = entity.get利用者負担割合明細();
        RiyoshaFutanWariaiMeisaiTempEntity 利用者負担割合明細 = getBefore().get利用者負担割合明細();
        beforeNo = 利用者負担割合明細.getHihokenshaNo();
        nowNo = last.getHihokenshaNo();
        edaNo++;
        loopHandle(利用者負担割合明細);
        if (!beforeNo.equals(nowNo)) {
            rirekiNo = 1;
        } else {
            rirekiNo++;
        }
    }

    private boolean subProcess(List<TsukibetsuFutanWariaiTempEntity> 月別負担割合新リスト,
            List<TsukibetsuFutanWariaiTempEntity> 月別負担割合現リスト) {
        if (月別負担割合新リスト.isEmpty() || 月別負担割合現リスト.isEmpty()) {
            return true;
        }
        TsukibetsuFutanWariaiTempEntity 月別負担割合新 = 月別負担割合新リスト.get(0);
        TsukibetsuFutanWariaiTempEntity 月別負担割合現 = 月別負担割合現リスト.get(0);
        if (月別負担割合現.isShokenFlag()) {
            HihokenshaNo hino = 月別負担割合新.getHihokenshaNo();
            csvEditor = new RiyoshaFutanWariaiHanteiCsvEditor(ONE, hino == null ? RString.EMPTY : hino.value());
            eucCsvWriter.writeLine(csvEditor.edit());
            return true;
        }
        if (ZERO.equals(月別負担割合新.getFutanwariaiKubunAug())
                && ZERO.equals(月別負担割合新.getFutanwariaiKubunSept())
                && ZERO.equals(月別負担割合新.getFutanwariaiKubunOct())
                && ZERO.equals(月別負担割合新.getFutanwariaiKubunNov())
                && ZERO.equals(月別負担割合新.getFutanwariaiKubunDec())
                && ZERO.equals(月別負担割合新.getFutanwariaiKubunJan())
                && ZERO.equals(月別負担割合新.getFutanwariaiKubunFeb())
                && ZERO.equals(月別負担割合新.getFutanwariaiKubunMar())
                && ZERO.equals(月別負担割合新.getFutanwariaiKubunApr())
                && ZERO.equals(月別負担割合新.getFutanwariaiKubunMay())
                && ZERO.equals(月別負担割合新.getFutanwariaiKubunJul())
                && ZERO.equals(月別負担割合新.getFutanwariaiKubunJun())) {
            HihokenshaNo hino = 月別負担割合新.getHihokenshaNo();
            csvEditor = new RiyoshaFutanWariaiHanteiCsvEditor(TWO, hino == null ? RString.EMPTY : hino.value());
            eucCsvWriter.writeLine(csvEditor.edit());
            return true;
        }
        return false;
    }

    @Override
    protected void afterExecute() {
        if (!existingFlag) {
            return;
        }
        loopHandle(last);
    }

    @Override
    protected void keyBreakProcess(FutanWariaiRelateEntity t) {
    }

    private void loopHandle(RiyoshaFutanWariaiMeisaiTempEntity 利用者負担割合明細) {
        DbT3113RiyoshaFutanWariaiEntity dbt3113Entity = new DbT3113RiyoshaFutanWariaiEntity();
        DbT3114RiyoshaFutanWariaiMeisaiEntity dbt3114Entity = new DbT3114RiyoshaFutanWariaiMeisaiEntity();
        dbt3113Entity.setNendo(nendo);
        dbt3113Entity.setHihokenshaNo(利用者負担割合明細.getHihokenshaNo());
        dbt3113Entity.setRirekiNo(rirekiNo);
        dbt3113Entity.setHakoFuyoFlag(false);
        dbt3113Entity.setShokenFlag(false);
        dbt3113Entity.setHanteiYMD(FlexibleDate.getNowDate());
        dbt3113Entity.setHanteiKubun(parameter.getShoriKubun());
        dbt3113Entity.setKoseiJiyu(new Code(利用者負担割合明細.getKoseiJiyu()));
        dbt3113Entity.setHakoKubun(ZERO);
        dbt3113Entity.setHakoYMD(FlexibleDate.EMPTY);
        dbt3113Entity.setKofuYMD(FlexibleDate.EMPTY);
        dbt3113Entity.setLogicalDeletedFlag(false);
        dbt3114Entity.setNendo(nendo);
        dbt3114Entity.setHihokenshaNo(利用者負担割合明細.getHihokenshaNo());
        dbt3114Entity.setRirekiNo(rirekiNo);
        dbt3114Entity.setEdaNo(edaNo);
        dbt3114Entity.setShikakuKubun(利用者負担割合明細.getShikakuKubun());
        dbt3114Entity.setFutanWariaiKubun(利用者負担割合明細.getFutanWariaiKubun());
        dbt3114Entity.setYukoKaishiYMD(利用者負担割合明細.getYukoKaishiYMD());
        dbt3114Entity.setYukoShuryoYMD(利用者負担割合明細.getYukoShuryoYMD());
        dbt3114Entity.setHonninGoukeiShotokuGaku(利用者負担割合明細.getHonninGoukeiShotokuGaku());
        dbt3114Entity.setSetaiIchigouHihokenshaSu(利用者負担割合明細.getSetaiIchigouHihokenshaSu());
        dbt3114Entity.setNenkinShunyuGoukei(利用者負担割合明細.getNenkinShunyuGoukei());
        dbt3114Entity.setSonotanoGoukeiShotokuKingakuGoukei(利用者負担割合明細.getSonotanoGoukeiShotokuKingakuGoukei());
        dbt3114Entity.setKoseiRiyu(利用者負担割合明細.getKoseiRiyu());
        dbt3114Entity.setSetaiCd(利用者負担割合明細.getSetaiCd());
        dbt3114Entity.setLogicalDeletedFlag(false);
        利用者負担割合Writer.insert(dbt3113Entity);
        利用者負担割合明細Writer.insert(dbt3114Entity);
        if (parameter.isTestMode()) {
            KonkaiRiyoshaFutanWariaiJohoTempEntity insertTemp = new KonkaiRiyoshaFutanWariaiJohoTempEntity();
            insertTemp.setNendo(nendo.toDateString());
            insertTemp.setHihokenshaNo(dbt3114Entity.getHihokenshaNo());
            insertTemp.setEdaNo(dbt3114Entity.getEdaNo());
            insertTemp.setFutanWariaiKubun(dbt3114Entity.getFutanWariaiKubun());
            FlexibleDate yukoKaishiYMD = dbt3114Entity.getYukoKaishiYMD();
            FlexibleDate yukoShuryoYMD = dbt3114Entity.getYukoShuryoYMD();
            insertTemp.setYukoKaishiYMD(yukoKaishiYMD);
            insertTemp.setYukoShuryoYMD(yukoShuryoYMD);
            insertTemp.setHoninGokeishotokuKingaku(dbt3114Entity.getHonninGoukeiShotokuGaku());
            insertTemp.setSetaiIchigouHihokenshaSu(dbt3114Entity.getSetaiIchigouHihokenshaSu());
            insertTemp.setNenkinShunyuGoukei(dbt3114Entity.getNenkinShunyuGoukei());
            insertTemp.setSonotaGokeiShotokuKingaku(dbt3114Entity.getSonotanoGoukeiShotokuKingakuGoukei());
            Code koseiJiyu = dbt3113Entity.getKoseiJiyu();
            insertTemp.setKoseiJiyu(koseiJiyu == null ? RString.EMPTY : koseiJiyu.value());
            今回利用者負担割合情報Temp.insert(insertTemp);
        }
    }

    private Encode getEncode(RString sakiEncodeKeitai) {
        Encode encode = Encode.UTF_8withBOM;
        if (TWO.equals(sakiEncodeKeitai)) {
            encode = Encode.SJIS;
        } else if (THREE.equals(sakiEncodeKeitai)) {
//            QA
            encode = Encode.JIS;
        }
        return encode;
    }

}
