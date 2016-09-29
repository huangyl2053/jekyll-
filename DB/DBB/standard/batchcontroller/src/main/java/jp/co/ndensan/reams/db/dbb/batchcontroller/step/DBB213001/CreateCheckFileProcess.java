/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB213001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchosofujohorenkei.TokuchoSofuJohoRenkeiProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.csv.CheckFileCsvEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosofujohorenkei.TokuchoSofuJohoRenkeiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoseiShichoson;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * チェックファイルプロセスです。
 *
 * @reamsid_L DBB-1790-040 yuanzhenxia
 */
public class CreateCheckFileProcess extends BatchProcessBase<TokuchoSofuJohoRenkeiEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchosofujohorenkei.ITokuchoSofuJohoRenkeiMapper"
                    + ".select特徴送付情報連携のデータ");
    // TODO QA No1635 EucEntityId
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("CHKCSV"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString ファイル出力Z12 = new RString("Z12_nnnnnn_CHK.Csv");
    private static final RString ファイル出力Z1A = new RString("Z1A_nnnnnn_CHK.Csv");
    private static final RString NNNNNN = new RString("nnnnnn");
    private static final RString Z12 = new RString("Z12");
    private static final int INT_ZERO = 0;
    private static final int INT_FIVE = 5;
    private TokuchoSofuJohoRenkeiProcessParameter proParameter;
    private FlexibleYear 処理年度;
    private RYearMonth 処理対象年月;
    private List<RString> 市町村コードリスト;
    private List<RString> ファイル出力CHKZ12List;
    private List<RString> ファイル出力CHKZ1AList;
    private Map<RString, RString> 市町村IDMap;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private Map<RString, CsvWriter> ファイル出力Z12Map;
    private Map<RString, CsvWriter> ファイル出力Z1AMap;
    @BatchWriter
    private CsvWriter<CheckFileCsvEntity> z12Writer;
    private CsvWriter<CheckFileCsvEntity> z1AWriter;

    @Override
    protected void initialize() {
        処理年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        処理対象年月 = RDate.getNowDate().getYearMonth();
        市町村コードリスト = new ArrayList<>();
        ファイル出力CHKZ12List = new ArrayList<>();
        ファイル出力CHKZ1AList = new ArrayList<>();
        市町村IDMap = new HashMap<>();
        ファイル出力Z12Map = new HashMap<>();
        ファイル出力Z1AMap = new HashMap<>();
        proParameter = new TokuchoSofuJohoRenkeiProcessParameter();
        KoikiShichosonJohoFinder finder = KoikiShichosonJohoFinder.createInstance();
        List<KoseiShichoson> 広域市町村情報 = finder.getKoseiShichosonList().records();
        if (!広域市町村情報.isEmpty()) {
            for (KoseiShichoson item : 広域市町村情報) {
                市町村コードリスト.add(item.get市町村コード().value().substring(INT_ZERO, INT_FIVE));
                市町村IDMap.put(item.get市町村コード().value().substring(INT_ZERO, INT_FIVE), item.get市町村識別ID());
            }
        }
        proParameter.set処理年度(処理年度);
        proParameter.set処理対象年月(処理対象年月);
        proParameter.set市町村コードリスト(市町村コードリスト);

    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        for (RString 市町村コード : 市町村コードリスト) {
            RString chkZ12 = ファイル出力Z12.replace(NNNNNN, 市町村コード);
            ファイル出力CHKZ12List.add(chkZ12);
            eucFilePath = Path.combinePath(spoolWorkPath, chkZ12);
            z12Writer = new CsvWriter.InstanceBuilder(eucFilePath).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.SJIS).
                    setNewLine(NewLine.CRLF).
                    hasHeader(true).
                    build();
            ファイル出力Z12Map.put(市町村コード, z12Writer);
            RString chkZ1A = ファイル出力Z1A.replace(NNNNNN, 市町村コード);
            ファイル出力CHKZ1AList.add(chkZ1A);
            eucFilePath = Path.combinePath(spoolWorkPath, chkZ1A);
            z1AWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.SJIS).
                    setNewLine(NewLine.CRLF).
                    hasHeader(true).
                    build();
            ファイル出力Z1AMap.put(市町村コード, z1AWriter);

        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, proParameter.toTokuchoSofuJohoRenkeiMybitisParameter());
    }

    @Override
    protected void process(TokuchoSofuJohoRenkeiEntity entity) {
        ファイル出力Z12Map.get(entity.get市町村コードDT()).writeLine(new CheckFileCsvEntity(
                RString.EMPTY,
                new RString(RDateTime.now().toString()),
                Z12,
                処理対象年月.toDateString(),
                entity.get市町村コードDT(),
                RDate.getNowDate().toDateString(),
                RString.EMPTY
        ));
        ファイル出力Z1AMap.get(entity.get市町村コードDT()).writeLine(new CheckFileCsvEntity(
                RString.EMPTY,
                new RString(RDateTime.now().toString()),
                Z12,
                処理対象年月.toDateString(),
                entity.get市町村コードDT(),
                RDate.getNowDate().toDateString(),
                RString.EMPTY
        ));
    }

    @Override
    protected void afterExecute() {
        for (RString fileName : ファイル出力CHKZ12List) {
            FilesystemName sharedFileName = new FilesystemName(fileName);
            SharedFile.defineSharedFile(sharedFileName);
            FilesystemPath 絶対パス = new FilesystemPath(Path.getTmpDirectoryPath());
            SharedFile.copyToSharedFile(絶対パス, sharedFileName);
        }
        for (RString fileName : ファイル出力CHKZ1AList) {
            FilesystemName sharedFileName = new FilesystemName(fileName);
            SharedFile.defineSharedFile(sharedFileName);
            FilesystemPath 絶対パス = new FilesystemPath(Path.getTmpDirectoryPath());
            SharedFile.copyToSharedFile(絶対パス, sharedFileName);
        }
    }

}
