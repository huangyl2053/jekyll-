/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE511001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.GogitaiJohoIkkatuSakuseiErrorMessage;
import jp.co.ndensan.reams.db.dbe.definition.core.hoshu.GogitaichoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.gogitaijohosakusei.GogitaiJohoSakuseiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohosakusei.GogitaiJohoSakuseiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohosakusei.GogitaiJohoSakuseiErrKekkaCSVEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohosakusei.TempGogitaiJohoSakusei;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohosakusei.TempGogitaiJohoSakuseiEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.gogitaijohosakusei.IGogitaiJohoSakuseiMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5591GogitaiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5593GogitaiWariateIinJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.api.EucOtherInfo;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.editor.EucDateFormator;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.log.RLogger;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * DB更新・エラー結果CSV作成プロセスです。
 *
 * @author n3304 岡澤 政幸
 */
public class GogitaiJohoSakuseiProcess extends BatchProcessBase<TempGogitaiJohoSakuseiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate."
            + "gogitaijohosakusei.IGogitaiJohoSakuseiMapper.getTempGogitaiJohoSakuseiSearchResult");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString CSV_WRITER_ENCLOSURE = new RString("\"");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_8 = 8;
    private static final int INT_40 = 40;
    private static final RString POSITIVE_INTEGERS_REGEX = new RString("^[1-9]\\d*$");
    private static final RString FLAG_TRUE = new RString("1");
    private static final RString FLAG_FALSE = new RString("0");
    private static final RString 合議体NO = new RString("合議体NO：");
    private int insertCount;
    private boolean csv出力;
    private boolean noErrorFlag;
    private boolean gogitaiInsertedFlag;
    private RString before合議体NO;
    private IGogitaiJohoSakuseiMapper mapper;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE511002"));
    private FileSpoolManager manager;
    private RString eucFilePath;
    private RString errorMessage;

    @BatchWriter
    private CsvWriter<GogitaiJohoSakuseiErrKekkaCSVEntity> csvWriter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5591GogitaiJohoEntity> dbT5591EntityWriter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5593GogitaiWariateIinJohoEntity> dbT5593EntityWriter;

    @Override
    protected void initialize() {
        insertCount = 0;
        errorMessage = RString.EMPTY;
        csv出力 = false;
        noErrorFlag = true;
        gogitaiInsertedFlag = false;
        before合議体NO = RString.EMPTY;
    }

    @Override
    protected void createWriter() {
        dbT5591EntityWriter = new BatchPermanentTableWriter(DbT5591GogitaiJohoEntity.class);
        dbT5593EntityWriter = new BatchPermanentTableWriter(DbT5593GogitaiWariateIinJohoEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, EUC_ENTITY_ID.toRString()));
        csvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                hasHeader(true).
                setDelimiter(CSV_WRITER_DELIMITER).
                setEnclosure(CSV_WRITER_ENCLOSURE).
                setEncode(Encode.SJIS).
                setNewLine(NewLine.CRLF).
                build();

        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void beforeExecute() {
        mapper = getMapper(IGogitaiJohoSakuseiMapper.class);
    }

    @Override
    protected void process(TempGogitaiJohoSakuseiEntity entity) {
        TempGogitaiJohoSakusei 合議体情報 = entity.get合議体情報作成Temp();

        noErrorFlag = true;
        errorMessage = RString.EMPTY;
        isClearInsertCount(合議体情報.get合議体NO());

        csv項目チェック(合議体情報);
        if (!noErrorFlag) {
            csvWriter.writeLine(createErrKekkaCSVEntity(合議体情報));
            before合議体NO = 合議体情報.get合議体NO();
            csv出力 = true;
            return;
        }

        有効期間チェック(合議体情報);
        if (!noErrorFlag) {
            csvWriter.writeLine(createErrKekkaCSVEntity(合議体情報));
            before合議体NO = 合議体情報.get合議体NO();
            csv出力 = true;
            return;
        }

        各項目チェック1(合議体情報);
        各項目チェック2(合議体情報);
        if (!noErrorFlag) {
            csvWriter.writeLine(createErrKekkaCSVEntity(合議体情報));
            before合議体NO = 合議体情報.get合議体NO();
            csv出力 = true;
            return;
        }

        定員チェック(合議体情報);
        if (!gogitaiInsertedFlag) {
            dbT5591EntityWriter.insert(createDbT5591Entity(合議体情報));
            gogitaiInsertedFlag = true;
        }
        if (is合議体割当委員情報登録済(合議体情報)) {
            dbT5593EntityWriter.update(createDbT5593Entity(合議体情報));
            insertCount++;
        } else {
            dbT5593EntityWriter.insert(createDbT5593Entity(合議体情報));
            insertCount++;
        }

        if (!noErrorFlag) {
            csvWriter.writeLine(createErrKekkaCSVEntity(合議体情報));
            csv出力 = true;
        }
        before合議体NO = 合議体情報.get合議体NO();
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
        if (csv出力) {
            manager.spool(eucFilePath);
        }
    }

    private void csv項目チェック(TempGogitaiJohoSakusei 合議体情報) {
        if (!(is数字チェック1(合議体情報) && is数字チェック2(合議体情報))) {
            RString message = new RString(UrErrorMessages.不正.getMessage().replace("データの形式、内容").evaluate());
            errorMessage = errorMessage.concat(message);
            RLogger.error(message);
            noErrorFlag = false;
        }

        if (合議体情報.get有効開始日().length() != INT_8 || !FlexibleDate.canConvert(合議体情報.get有効開始日())
                || 合議体情報.get有効終了日().length() != INT_8 || !FlexibleDate.canConvert(合議体情報.get有効終了日())) {
            RString message = new RString(UrErrorMessages.項目に対する制約.getMessage().replace("日付項目", "yyyymmddの形式").evaluate());
            errorMessage = errorMessage.concat(message);
            RLogger.error(message);
            noErrorFlag = false;
        } else if (new FlexibleDate(合議体情報.get有効開始日()).isAfter(new FlexibleDate(合議体情報.get有効終了日()))) {
            RString message = GogitaiJohoIkkatuSakuseiErrorMessage.有効開始日大有効終了日.getMessage();
            errorMessage = errorMessage.concat(message);
            RLogger.error(message);
            noErrorFlag = false;
        }
    }

    private void 有効期間チェック(TempGogitaiJohoSakusei 合議体情報) {
        List<GogitaiJohoSakuseiEntity> 合議体情報List = mapper.getGogitaiJohoByYukoKikanKaishiYMD(
                GogitaiJohoSakuseiParameter.createGogitaiJohoSakuseiParameter(
                        FlexibleDate.MAX,
                        true,
                        Integer.parseInt(合議体情報.get合議体NO().toString()),
                        new FlexibleDate(合議体情報.get有効開始日()),
                        RString.EMPTY,
                        0
                ));
        if (合議体情報List != null && !合議体情報List.isEmpty()) {
            RString message = GogitaiJohoIkkatuSakuseiErrorMessage.有効期間不正.getMessage()
                    .concat(EucDateFormator.y_slash.format(new RString(合議体情報List.get(INT_0).get合議体情報().getGogitaiYukoKikanShuryoYMD().toString())));
            RLogger.error(message);
            errorMessage = errorMessage.concat(message);
            noErrorFlag = false;
        }
    }

    private void 各項目チェック1(TempGogitaiJohoSakusei 合議体情報) {
        if (合議体情報.get合議体NO().length() != INT_2) {
            RString message = GogitaiJohoIkkatuSakuseiErrorMessage.合議体Noは２桁.getMessage();
            RLogger.error(message);
            errorMessage = errorMessage.concat(message);
            noErrorFlag = true;
        }
        if (RString.isNullOrEmpty(合議体情報.get合議体名称())) {
            RString message = GogitaiJohoIkkatuSakuseiErrorMessage.合議体名称が空.getMessage();
            RLogger.error(message);
            errorMessage = errorMessage.concat(message);
            noErrorFlag = true;
        } else if (INT_40 < 合議体情報.get合議体名称().length()) {
            RString message = GogitaiJohoIkkatuSakuseiErrorMessage.合議体名称の桁数.getMessage();
            RLogger.error(message);
            errorMessage = errorMessage.concat(message);
            noErrorFlag = true;
        }
        if (!RTime.canConvert(合議体情報.get合議体開始予定時刻())) {
            RString message = GogitaiJohoIkkatuSakuseiErrorMessage.開始予定時刻が時刻.getMessage();
            RLogger.error(message);
            errorMessage = errorMessage.concat(message);
            noErrorFlag = true;
        }
        if (!RTime.canConvert(合議体情報.get合議体終了予定時刻())) {
            RString message = GogitaiJohoIkkatuSakuseiErrorMessage.終了予定時刻が時刻.getMessage();
            RLogger.error(message);
            errorMessage = errorMessage.concat(message);
            noErrorFlag = true;
        }
        if (mapper.getKaisaiBashoJohoCount(合議体情報.get開催場所コード()) == INT_0) {
            RString message = GogitaiJohoIkkatuSakuseiErrorMessage.開催場所コードがテーブルに存在.getMessage();
            RLogger.error(message);
            errorMessage = errorMessage.concat(message);
            noErrorFlag = true;
        }
        if (INT_4 < 合議体情報.get審査会予定定員().length()) {
            RString message = GogitaiJohoIkkatuSakuseiErrorMessage.予定定員の桁数大4.getMessage();
            RLogger.error(message);
            errorMessage = errorMessage.concat(message);
            noErrorFlag = true;
        }
        if (INT_4 < 合議体情報.get審査会自動割当定員().length()) {
            RString message = GogitaiJohoIkkatuSakuseiErrorMessage.自動割当定員の桁数大4.getMessage();
            RLogger.error(message);
            errorMessage = errorMessage.concat(message);
            noErrorFlag = true;
        }
        if (INT_4 < 合議体情報.get審査会委員定員().length()) {
            RString message = GogitaiJohoIkkatuSakuseiErrorMessage.委員定員の桁数大4.getMessage();
            RLogger.error(message);
            errorMessage = errorMessage.concat(message);
            noErrorFlag = true;
        }
    }

    private void 各項目チェック2(TempGogitaiJohoSakusei 合議体情報) {
        if (!(FLAG_TRUE.equals(合議体情報.get精神科医所属())
                || FLAG_FALSE.equals(合議体情報.get精神科医所属()))) {
            RString message = GogitaiJohoIkkatuSakuseiErrorMessage.精神科医所属が01.getMessage();
            RLogger.error(message);
            errorMessage = errorMessage.concat(message);
            noErrorFlag = true;
        }
        if (!(FLAG_TRUE.equals(合議体情報.get合議体ダミーフラグ())
                || FLAG_FALSE.equals(合議体情報.get合議体ダミーフラグ()))) {
            RString message = GogitaiJohoIkkatuSakuseiErrorMessage.ダミーフラグが01.getMessage();
            RLogger.error(message);
            errorMessage = errorMessage.concat(message);
            noErrorFlag = true;
        }
        if (mapper.getShinsakaiIinJohoCount(合議体情報.get審査会委員コード()) == INT_0) {
            RString message = GogitaiJohoIkkatuSakuseiErrorMessage.審査会委員コードがテーブルに存在.getMessage();
            RLogger.error(message);
            errorMessage = errorMessage.concat(message);
            noErrorFlag = true;
        }
        if (!(GogitaichoKubunCode.通常.getコード().equals(合議体情報.get合議体長区分コード())
                || GogitaichoKubunCode.副合議体長.getコード().equals(合議体情報.get合議体長区分コード())
                || GogitaichoKubunCode.合議体長.getコード().equals(合議体情報.get合議体長区分コード()))) {
            RString message = GogitaiJohoIkkatuSakuseiErrorMessage.合議体長区分コードが012.getMessage();
            RLogger.error(message);
            errorMessage = errorMessage.concat(message);
            noErrorFlag = true;
        }
        if (!(FLAG_TRUE.equals(合議体情報.get補欠())
                || FLAG_FALSE.equals(合議体情報.get補欠()))) {
            RString message = GogitaiJohoIkkatuSakuseiErrorMessage.補欠が01.getMessage();
            RLogger.error(message);
            errorMessage = errorMessage.concat(message);
            noErrorFlag = true;
        }
    }

    private void 定員チェック(TempGogitaiJohoSakusei 合議体情報) {
        if (合議体情報.get審査会委員定員().toInt() < INT_3) {
            RString message = 合議体NO.concat(合議体情報.get合議体NO()).concat(GogitaiJohoIkkatuSakuseiErrorMessage.委員数が3人未満.getMessage());
            RLogger.error(message);
            errorMessage = errorMessage.concat(message);
            noErrorFlag = true;
        }
        if (合議体情報.get審査会委員定員().toInt() < (insertCount + INT_1)) {
            RString message = 合議体NO.concat(合議体情報.get合議体NO()).concat(GogitaiJohoIkkatuSakuseiErrorMessage.委員数が超過.getMessage());
            RLogger.error(message);
            errorMessage = errorMessage.concat(message);
            noErrorFlag = true;
        }

    }

    private boolean is合議体割当委員情報登録済(TempGogitaiJohoSakusei 合議体情報) {
        int count = mapper.getGogitaiWariateIinJohoCount(GogitaiJohoSakuseiParameter.createGogitaiJohoSakuseiParameter(
                FlexibleDate.MAX,
                true,
                合議体情報.get合議体NO().toInt(),
                new FlexibleDate(合議体情報.get有効開始日()),
                合議体情報.get審査会委員コード(),
                INT_0
        ));

        return INT_0 < count;
    }

    private boolean is数字チェック1(TempGogitaiJohoSakusei 合議体情報) {
        return RStringUtil.matchesRegex(合議体情報.get合議体NO().trim(), POSITIVE_INTEGERS_REGEX)
                && RStringUtil.matchesRegex(合議体情報.get有効開始日().trim(), POSITIVE_INTEGERS_REGEX)
                && RStringUtil.matchesRegex(合議体情報.get有効終了日().trim(), POSITIVE_INTEGERS_REGEX)
                && RStringUtil.matchesRegex(合議体情報.get合議体開始予定時刻().trim(), POSITIVE_INTEGERS_REGEX)
                && RStringUtil.matchesRegex(合議体情報.get合議体終了予定時刻().trim(), POSITIVE_INTEGERS_REGEX);
    }

    private boolean is数字チェック2(TempGogitaiJohoSakusei 合議体情報) {
        return RStringUtil.matchesRegex(合議体情報.get審査会予定定員().trim(), POSITIVE_INTEGERS_REGEX)
                && RStringUtil.matchesRegex(合議体情報.get審査会自動割当定員().trim(), POSITIVE_INTEGERS_REGEX)
                && RStringUtil.matchesRegex(合議体情報.get審査会委員定員().trim(), POSITIVE_INTEGERS_REGEX)
                && RStringUtil.matchesRegex(合議体情報.get開催場所コード().trim(), POSITIVE_INTEGERS_REGEX)
                && RStringUtil.matchesRegex(合議体情報.get精神科医所属().trim(), POSITIVE_INTEGERS_REGEX)
                && RStringUtil.matchesRegex(合議体情報.get合議体ダミーフラグ().trim(), POSITIVE_INTEGERS_REGEX)
                && RStringUtil.matchesRegex(合議体情報.get審査会委員コード().trim(), POSITIVE_INTEGERS_REGEX)
                && RStringUtil.matchesRegex(合議体情報.get補欠().trim(), POSITIVE_INTEGERS_REGEX)
                && RStringUtil.matchesRegex(合議体情報.get合議体長区分コード().trim(), POSITIVE_INTEGERS_REGEX);
    }

    private DbT5591GogitaiJohoEntity createDbT5591Entity(TempGogitaiJohoSakusei 合議体情報) {
        DbT5591GogitaiJohoEntity entity = new DbT5591GogitaiJohoEntity();

        entity.setGogitaiNo(合議体情報.get合議体NO().toInt());
        entity.setGogitaiYukoKikanKaishiYMD(new FlexibleDate(合議体情報.get有効開始日()));
        entity.setGogitaiYukoKikanShuryoYMD(new FlexibleDate(合議体情報.get有効終了日()));
        entity.setGogitaiMei(合議体情報.get合議体名称());
        entity.setGogitaiKaishiYoteiTime(合議体情報.get合議体開始予定時刻());
        entity.setGogitaiShuryoYoteiTime(合議体情報.get合議体終了予定時刻());
        entity.setShinsakaiKaisaiBashoCode(合議体情報.get開催場所コード());
        entity.setShinsakaiYoteiTeiin(合議体情報.get審査会予定定員().toInt());
        entity.setShinsakaiJidoWariateTeiin(合議体情報.get審査会自動割当定員().toInt());
        entity.setShinsakaiIinTeiin(合議体情報.get審査会委員定員().toInt());
        entity.setGogitaiSeishinkaSonzaiFlag(strToBoolean(合議体情報.get精神科医所属()));
        entity.setGogitaiDummyFlag(strToBoolean(合議体情報.get合議体ダミーフラグ()));

        return entity;
    }

    private DbT5593GogitaiWariateIinJohoEntity createDbT5593Entity(TempGogitaiJohoSakusei 合議体情報) {
        DbT5593GogitaiWariateIinJohoEntity entity = new DbT5593GogitaiWariateIinJohoEntity();

        entity.setGogitaiNo(合議体情報.get合議体NO().toInt());
        entity.setGogitaiYukoKikanKaishiYMD(new FlexibleDate(合議体情報.get有効開始日()));
        entity.setGogitaiYukoKikanShuryoYMD(new FlexibleDate(合議体情報.get有効終了日()));
        entity.setShinsakaiIinCode(合議体情報.get審査会委員コード());
        entity.setGogitaichoKubunCode(new Code(合議体情報.get合議体長区分コード()));
        entity.setSubstituteFlag(strToBoolean(合議体情報.get補欠()));

        return entity;
    }

    private GogitaiJohoSakuseiErrKekkaCSVEntity createErrKekkaCSVEntity(TempGogitaiJohoSakusei 合議体情報) {
        GogitaiJohoSakuseiErrKekkaCSVEntity entity = new GogitaiJohoSakuseiErrKekkaCSVEntity();

        entity.set合議体NO(合議体情報.get合議体NO());
        entity.set合議体名称(合議体情報.get合議体名称());
        entity.set有効開始日(合議体情報.get有効開始日());
        entity.set有効終了日(合議体情報.get有効終了日());
        entity.set合議体開始予定時刻(合議体情報.get合議体開始予定時刻());
        entity.set合議体終了予定時刻(合議体情報.get合議体終了予定時刻());
        entity.set審査会予定定員(合議体情報.get審査会予定定員());
        entity.set審査会自動割当定員(合議体情報.get審査会自動割当定員());
        entity.set審査会委員定員(合議体情報.get審査会委員定員());
        entity.set開催場所コード(合議体情報.get開催場所コード());
        entity.set精神科医所属(合議体情報.get精神科医所属());
        entity.set合議体ダミーフラグ(合議体情報.get合議体ダミーフラグ());
        entity.set審査会委員コード(合議体情報.get審査会委員コード());
        entity.set補欠(合議体情報.get補欠());
        entity.set合議体長区分コード(合議体情報.get合議体長区分コード());
        entity.setエラー事由(errorMessage);

        return entity;
    }

    private void isClearInsertCount(RString 合議体NO) {
        if (!before合議体NO.equals(合議体NO)) {
            gogitaiInsertedFlag = false;
            insertCount = 0;
        }
    }

    private RString intToRStr(int no) {
        return new RString(no);
    }

    private boolean strToBoolean(RString str) {
        return FLAG_TRUE.equals(str);
    }

}
