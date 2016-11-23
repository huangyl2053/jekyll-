/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.dbd5010001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.dbd5010001.KoshinTaishoBussiness;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5010001.KoshinTaishoCsvEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4201NinteichosaIraiJohoDac;
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
 * 画面設計_DBD5010001_完了処理・更新管理のMapperです。
 *
 * @reamsid_L DBD-2030-010 x_youyj
 */
public class KoshinTaishoManager {

    private final DbT4201NinteichosaIraiJohoDac dac;
    private final DbT4101NinteiShinseiJohoDac johodac;
    private final DbT4001JukyushaDaichoDac daichoDac;

    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString CSVFILENAME = new RString("更新管理対象者一覧.csv");

    /**
     * KoshinTaishoManagerのインスタンス化
     *
     * @return KoshinTaishoManager
     */
    public static KoshinTaishoManager createInstance() {
        return InstanceProvider.create(KoshinTaishoManager.class);
    }

    KoshinTaishoManager() {
        this.dac = InstanceProvider.create(DbT4201NinteichosaIraiJohoDac.class);
        this.johodac = InstanceProvider.create(DbT4101NinteiShinseiJohoDac.class);
        this.daichoDac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
    }

    /**
     * CSVファイルを出力する。
     *
     * @param 画面更新情報ビジネス List<KoshinTaishoBussiness>
     * @return SharedFileEntryDescriptor
     */
    public SharedFileEntryDescriptor csvSyutsuryoku(List<KoshinTaishoBussiness> 画面更新情報ビジネス) {
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), CSVFILENAME);
        try (CsvWriter<KoshinTaishoCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER)
                .setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF).hasHeader(true).build()) {
            for (KoshinTaishoBussiness business : 画面更新情報ビジネス) {
                csvWriter.writeLine(converterDataSourceFromToCsvEntity(business));
            }
            csvWriter.close();
        }
        SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName.fromString(CSVFILENAME));
        sfd = SharedFile.defineSharedFile(sfd);
        CopyToSharedFileOpts opts = new CopyToSharedFileOpts().isCompressedArchive(false);
        return SharedFile.copyToSharedFile(sfd, new FilesystemPath(filePath), opts);
    }

    /**
     * CsvEntityを作成する。
     *
     * @param business DgTsuchishoHakkoBussiness
     * @return TsuchiShoHakkouCsvEntity
     */
    public KoshinTaishoCsvEntity converterDataSourceFromToCsvEntity(KoshinTaishoBussiness business) {
        KoshinTaishoCsvEntity csvEntity = new KoshinTaishoCsvEntity();
        csvEntity.set保険者(business.get保険者());
        csvEntity.set被保険者被保番号(business.get被保険者被保番号());
        csvEntity.set被保険者氏名(business.get被保険者氏名());
        csvEntity.set更新対象完了日(business.get更新対象完了日());
        csvEntity.set更新対象通知年月日(business.get更新対象通知年月日());
        return csvEntity;
    }

    /**
     * 認定調査依頼情報を更新する。
     *
     * @param 認定調査依頼情報 DbT4201NinteichosaIraiJohoEntity
     */
    @Transaction
    public void updateDbt4201johon(DbT4201NinteichosaIraiJohoEntity 認定調査依頼情報) {
        dac.save(認定調査依頼情報);
    }

    /**
     * 要介護認定申請情報を更新する。
     *
     * @param 認定申請情報 DbT4101NinteiShinseiJohoEntity
     */
    @Transaction
    public void updateDbt4101johon(DbT4101NinteiShinseiJohoEntity 認定申請情報) {

        johodac.update(認定申請情報);
    }
    
    /**
     * 受給者台帳を作成する。
     *
     * @param 受給者台帳情報 DbT4001JukyushaDaichoEntity
     */
    @Transaction
    public void insertDbt4001johon(DbT4001JukyushaDaichoEntity 受給者台帳情報) {
        daichoDac.save(受給者台帳情報);
    }
}
