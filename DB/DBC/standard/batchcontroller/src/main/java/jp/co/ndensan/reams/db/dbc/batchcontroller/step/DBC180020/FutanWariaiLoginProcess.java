/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180020;

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
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

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
    private static final RString TABLENAME = new RString("KonkaiRiyoshaFutanWariaiJohoTemp");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "riyoshafutanwariaihantei.IRiyoshaFutanwariaiMapper.select負担割合と明細");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBC900004"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString CSVFILENAME = new RString("DBC900004_ShoriKekkaKakuninList.csv");
    private DBC180020ProcessParameter parameter;
    private HihokenshaNo beforeNo;
    private HihokenshaNo nowNo;
    private FlexibleYear nendo;
    private int rirekiNo;
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
        nendo = new FlexibleYear(parameter.getTaishoNendo().toDateString());
    }

    @Override
    protected void createWriter() {
        this.manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = this.manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, CSVFILENAME);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
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
        List<TsukibetsuFutanWariaiTempEntity> 月別負担割合新リスト = entity.get月別負担割合新();
        List<TsukibetsuFutanWariaiTempEntity> 月別負担割合現リスト = entity.get月別負担割合現();
        if (csvOutputHandle(月別負担割合新リスト, 月別負担割合現リスト)) {
            return;
        }
        nowNo = entity.get利用者負担割合明細().getHihokenshaNo();
        if (getBefore() == null) {
            beforeNo = null;
            loopHandle(entity);
            return;
        }
        beforeNo = getBefore().get利用者負担割合明細().getHihokenshaNo();
        loopHandle(entity);
    }

    private boolean csvOutputHandle(List<TsukibetsuFutanWariaiTempEntity> 月別負担割合新リスト,
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
        eucCsvWriter.close();
        manager.spool(eucFilePath);
    }

    @Override
    protected void keyBreakProcess(FutanWariaiRelateEntity t) {
    }

    private int getMaxRirekiNo(List<TsukibetsuFutanWariaiTempEntity> 月別負担割合現リスト) {
        return 月別負担割合現リスト == null || 月別負担割合現リスト.isEmpty() ? 1 : 月別負担割合現リスト.get(0).getRirekiNo() + 1;
    }

    private void loopHandle(FutanWariaiRelateEntity nowEntity) {
        List<TsukibetsuFutanWariaiTempEntity> 月別負担割合現リスト = nowEntity.get月別負担割合現();
        if (beforeNo == null || !nowNo.equals(beforeNo)) {
            rirekiNo = getMaxRirekiNo(月別負担割合現リスト);
            insert3113Entity(nowEntity.get利用者負担割合明細());
        }
        insert3114Entity(nowEntity.get利用者負担割合明細());
    }

    private void insert3113Entity(RiyoshaFutanWariaiMeisaiTempEntity 利用者負担割合明細Temp) {
        RString koseiJiyu = 利用者負担割合明細Temp.getKoseiJiyu();
        DbT3113RiyoshaFutanWariaiEntity dbt3113Entity = new DbT3113RiyoshaFutanWariaiEntity();
        dbt3113Entity.setNendo(nendo);
        dbt3113Entity.setHihokenshaNo(利用者負担割合明細Temp.getHihokenshaNo());
        dbt3113Entity.setRirekiNo(rirekiNo);
        dbt3113Entity.setHakoFuyoFlag(false);
        dbt3113Entity.setShokenFlag(false);
        dbt3113Entity.setHanteiYMD(FlexibleDate.getNowDate());
        dbt3113Entity.setHanteiKubun(parameter.getShoriKubun());
        dbt3113Entity.setKoseiJiyu(RString.isNullOrEmpty(koseiJiyu) ? null : new Code(koseiJiyu));
        dbt3113Entity.setHakoKubun(ZERO);
        dbt3113Entity.setHakoYMD(FlexibleDate.EMPTY);
        dbt3113Entity.setKofuYMD(FlexibleDate.EMPTY);
        dbt3113Entity.setLogicalDeletedFlag(false);
        if (!parameter.isTestMode()) {
            利用者負担割合Writer.insert(dbt3113Entity);
        }
    }

    private void insert3114Entity(RiyoshaFutanWariaiMeisaiTempEntity 利用者負担割合明細) {
        RString koseiJiyu = 利用者負担割合明細.getKoseiJiyu();
        DbT3114RiyoshaFutanWariaiMeisaiEntity dbt3114Entity = new DbT3114RiyoshaFutanWariaiMeisaiEntity();
        dbt3114Entity.setNendo(nendo);
        dbt3114Entity.setHihokenshaNo(利用者負担割合明細.getHihokenshaNo());
        dbt3114Entity.setRirekiNo(rirekiNo);
        dbt3114Entity.setEdaNo(利用者負担割合明細.getEdaNo());
        dbt3114Entity.setShikakuKubun(利用者負担割合明細.getShikakuKubun());
        dbt3114Entity.setFutanWariaiKubun(利用者負担割合明細.getFutanWariaiKubun());
        dbt3114Entity.setYukoKaishiYMD(利用者負担割合明細.getYukoKaishiYMD());
        dbt3114Entity.setYukoShuryoYMD(利用者負担割合明細.getYukoShuryoYMD());
        dbt3114Entity.setHonninGoukeiShotokuGaku(nonullDecimal(利用者負担割合明細.getHonninGoukeiShotokuGaku()));
        dbt3114Entity.setSetaiIchigouHihokenshaSu(利用者負担割合明細.getSetaiIchigouHihokenshaSu());
        dbt3114Entity.setNenkinShunyuGoukei(nonullDecimal(利用者負担割合明細.getNenkinShunyuGoukei()));
        dbt3114Entity.setSonotanoGoukeiShotokuKingakuGoukei(
                nonullDecimal(利用者負担割合明細.getSonotanoGoukeiShotokuKingakuGoukei()));
        dbt3114Entity.setKoseiRiyu(利用者負担割合明細.getKoseiRiyu());
        dbt3114Entity.setSetaiCd(利用者負担割合明細.getSetaiCd());
        dbt3114Entity.setLogicalDeletedFlag(false);
        if (!parameter.isTestMode()) {
            利用者負担割合明細Writer.insert(dbt3114Entity);
        }
        KonkaiRiyoshaFutanWariaiJohoTempEntity insertTemp = new KonkaiRiyoshaFutanWariaiJohoTempEntity();
        insertTemp.setNendo(nendo);
        insertTemp.setHihokenshaNo(dbt3114Entity.getHihokenshaNo());
        insertTemp.setEdaNo(dbt3114Entity.getEdaNo());
        insertTemp.setFutanWariaiKubun(dbt3114Entity.getFutanWariaiKubun());
        FlexibleDate yukoKaishiYMD = dbt3114Entity.getYukoKaishiYMD();
        FlexibleDate yukoShuryoYMD = dbt3114Entity.getYukoShuryoYMD();
        insertTemp.setYukoKaishiYMD(yukoKaishiYMD);
        insertTemp.setYukoShuryoYMD(yukoShuryoYMD);
        insertTemp.setHoninGokeishotokuKingaku(nonullDecimal(dbt3114Entity.getHonninGoukeiShotokuGaku()));
        insertTemp.setSetaiIchigouHihokenshaSu(dbt3114Entity.getSetaiIchigouHihokenshaSu());
        insertTemp.setNenkinShunyuGoukei(nonullDecimal(dbt3114Entity.getNenkinShunyuGoukei()));
        insertTemp.setSonotaGokeiShotokuKingaku(nonullDecimal(dbt3114Entity.getSonotanoGoukeiShotokuKingakuGoukei()));
        insertTemp.setKoseiJiyu(RString.isNullOrEmpty(koseiJiyu) ? null : koseiJiyu);
        今回利用者負担割合情報Temp.insert(insertTemp);
    }

    private Decimal nonullDecimal(Decimal dec) {
        if (dec == null) {
            return Decimal.ZERO;
        }
        return dec;
    }
}
