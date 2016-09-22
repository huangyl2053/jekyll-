/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.dbd5030001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.TsuchishoHakkoJoho;
import jp.co.ndensan.reams.db.dbd.business.core.dbd5030001.DgTsuchishoHakkoBussiness;
import jp.co.ndensan.reams.db.dbd.business.core.dbd5030001.TsuchiShoriBusiness;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4122TsuchishoHakkoJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5030001.TsuchiShoriEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd583001.TsuchiShoHakkouCsvEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4122TsuchishoHakkoJohoDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.tsuchishori.ITsuchiShoriMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 完了処理・通知書発行表示情報を取得する
 *
 * @reamsid_L DBD-2040-010 chenxin
 */
public class TsuchiShoriManager {

    private final MapperProvider mapperProvider;
    private final DbT4122TsuchishoHakkoJohoDac 通知書発行情報dac;
    private static final RString CSVファイル名 = new RString("通知書発行対象者一覧.csv");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");

    TsuchiShoriManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.通知書発行情報dac = InstanceProvider.create(DbT4122TsuchishoHakkoJohoDac.class);
    }

    /**
     * TsuchiShoriManagerのインスタンス化
     *
     * @return TsuchiShoriManager
     */
    public static TsuchiShoriManager createInstance() {
        return InstanceProvider.create(TsuchiShoriManager.class);
    }

    /**
     * 初期化情報を取得取得する。
     *
     * @return List<TsuchiShoriBusiness>
     */
    public List<TsuchiShoriBusiness> 初期化情報取得() {
        List<TsuchiShoriBusiness> 初期化情報 = new ArrayList<>();
        ITsuchiShoriMapper mapper = mapperProvider.create(ITsuchiShoriMapper.class);
        List<TsuchiShoriEntity> entities = mapper.初期化データ取得();
        for (TsuchiShoriEntity entity : entities) {
            初期化情報.add(new TsuchiShoriBusiness(entity));
        }
        return 初期化情報;
    }

    /**
     * 通知書発行情報を取得する。
     *
     * @return List<TsuchishoHakkoJoho>
     */
    public List<TsuchishoHakkoJoho> 通知書発行情報() {
        List<TsuchishoHakkoJoho> 通知書発行情報 = new ArrayList<>();
        DbT4122TsuchishoHakkoJohoDac dac = InstanceProvider.create(DbT4122TsuchishoHakkoJohoDac.class);
        for (DbT4122TsuchishoHakkoJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            通知書発行情報.add(new TsuchishoHakkoJoho(entity));
        }
        return 通知書発行情報;
    }

    /**
     * CSVファイルを出力する。
     *
     * @param 画面更新情報ビジネス List<DgTsuchishoHakkoBussiness>
     * @return SharedFileEntryDescriptor
     */
    public SharedFileEntryDescriptor CSVファイル出力(List<DgTsuchishoHakkoBussiness> 画面更新情報ビジネス) {
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSVファイル名);
        try (CsvWriter<TsuchiShoHakkouCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8withBOM).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build()) {
            for (DgTsuchishoHakkoBussiness business : 画面更新情報ビジネス) {
                csvWriter.writeLine(converterDataSourceFromToCsvEntity(business));
            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(CSVファイル名));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        SharedFileEntryDescriptor entry = SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
        return entry;
    }

    /**
     * CsvEntityを作成する。
     *
     * @param business DgTsuchishoHakkoBussiness
     * @return TsuchiShoHakkouCsvEntity
     */
    public TsuchiShoHakkouCsvEntity converterDataSourceFromToCsvEntity(DgTsuchishoHakkoBussiness business) {
        TsuchiShoHakkouCsvEntity csvEntity = new TsuchiShoHakkouCsvEntity();
        csvEntity.set保険者(business.getHokensha());
        csvEntity.set被保険者番号(business.getHihoNumber());
        csvEntity.set氏名(business.getHihoShimei());
        csvEntity.set認定申請日(business.getNinteiShinseiDay().getValue().wareki().toDateString());
        csvEntity.set申請区分申請時(business.getShinseiKubunShinseiji());
        csvEntity.set申請区分法令(business.getShinseiKubunHorei());
        csvEntity.set通知完了日(business.getTsuchiKanryobi().getValue().wareki().toDateString());
        csvEntity.set認定結果通知書発行日(business.getNinteitsuchishobi().getValue().wareki().toDateString());
        csvEntity.set区分変更通知書発行日(business.getKubunhenkotsuchishobi().getValue().wareki().toDateString());
        csvEntity.setサービス変更通知書発行日(business.getServicehenkotsuchishobi().getValue().wareki().toDateString());
        csvEntity.set認定却下通知書発行日(business.getNinteikyakatsuchishobi().getValue().wareki().toDateString());
        csvEntity.set認定取消通知書発行日(business.getNinteitorikeshitsuchishobi().getValue().wareki().toDateString());
        return csvEntity;
    }

    /**
     * UPDATE処理を行う。
     *
     * @param 画面情報 TsuchishoHakkoJoho
     */
    @Transaction
    public void save(TsuchishoHakkoJoho 画面情報) {
        通知書発行情報dac.save(画面情報.toEntity());
    }

    /**
     * INSERT処理を行う。
     *
     * @param 画面情報 TsuchishoHakkoJoho
     */
    @Transaction
    public void insert(TsuchishoHakkoJoho 画面情報) {
        通知書発行情報dac.save(画面情報.toEntity());
    }
}
