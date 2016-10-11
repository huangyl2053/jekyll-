/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD519001;

import jp.co.ndensan.reams.db.dbd.business.core.dbd519001.MakeNinteiShinseiJohoFileManager;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd519001.MakeNinteiShinseiJohoFileProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519001.MakeNinteiShinseiJohoFileCsvDensanEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519001.temp.KouikiyoukaigoNinteishinseiJouhouTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.EucFileOutputJokenhyoFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IEucFileOutputJokenhyoPrinter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.report.externalcharacter.PublishExternalCharacterErrorList;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 申請情報IFファイル作成_process処理クラスです。
 *
 * @reamsid_L DBD-1480-020 liuyl
 */
public class MakeNinteiShinseiJohoFileProcess extends BatchProcessBase<KouikiyoukaigoNinteishinseiJouhouTempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper."
            + "relate.ninteishinseiinfoif.IMakeNinteiShinseiJohoFileMapper.select要介護認定申請連携データ");
    private static final RString 連携データ種類 = new RString("【連携データ種類】");
    private static final RString 証記載保険者番号 = new RString("【証記載保険者番号】");
    private static final RString 市町村コード = new RString("【市町村コード】");
    private static final RString 被保険者番号 = new RString("【被保険者番号】");
    private static final RString 抽出開始日時 = new RString("【抽出開始日時】");
    private static final RString 抽出終了日時 = new RString("【抽出終了日時】");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private MakeNinteiShinseiJohoFileProcessParameter parameter;
    private RString eucFilePath;
    private Association 地方公共団体;
    @BatchWriter
    private CsvWriter<MakeNinteiShinseiJohoFileCsvDensanEntity> densanWriter;
    private RString 文字コード;
    private RString 要介護ＩＦ_類似変換;
    private boolean isPublished = false;

    @Override
    protected void initialize() {
        文字コード = DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_文字コード, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        要介護ＩＦ_類似変換 = DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_類似変換, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
    }

    @Override
    protected void createWriter() {
        eucFilePath = Path.combinePath(Path.getTmpDirectoryPath(), parameter.get連携ファイル名());
        Encode encode;
        if (文字コード.equals(new RString("1"))) {
            encode = Encode.SJIS;
        } else {
            encode = Encode.UTF_8;
        }
        if (要介護ＩＦ_類似変換.equals(new RString("1"))) {
            densanWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                    canAppend(false).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setNewLine(NewLine.CRLF).
                    hasHeader(true).
                    setEncode(encode).
                    build();

        } else {
            densanWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                    canAppend(false).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setNewLine(NewLine.CRLF).
                    hasHeader(true).
                    build();
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);

    }

    @Override
    protected void process(KouikiyoukaigoNinteishinseiJouhouTempEntity entity) {
        MakeNinteiShinseiJohoFileManager manager = new MakeNinteiShinseiJohoFileManager();
        densanWriter.writeLine(manager.createMakeNinteiShinseiJohoFileCsvDensanEntity(entity));
        AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, manager.toPersonalData(entity));
        isPublished = true;
    }

    @Override
    protected void afterExecute() {
        MakeNinteiShinseiJohoFileManager manager = new MakeNinteiShinseiJohoFileManager();
        IEucFileOutputJokenhyoPrinter printer = EucFileOutputJokenhyoFactory.createInstance(manager.バッチ出力条件リストの出力(parameter, 地方公共団体));
        printer.print();
        densanWriter.close();
        if (isPublished && 文字コード.equals(new RString("1"))) {
            PublishExternalCharacterErrorList.publish(eucFilePath);
        }
    }
}
