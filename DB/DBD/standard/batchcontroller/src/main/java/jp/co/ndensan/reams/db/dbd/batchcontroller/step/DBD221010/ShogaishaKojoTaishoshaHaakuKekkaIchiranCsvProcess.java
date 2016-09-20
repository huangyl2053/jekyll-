/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD221010;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4038ShogaishaKoujoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100201.FuicchiCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shogaishakojotaishoshahaakukekkaichiran.ShogaishaKojoTaishoshaCsvEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * バッチ設計_DBDMN41001_障がい者控除対象者把握のCSV出力クラスです。
 *
 * @reamsid_L DBD-3850-030 liuwei2
 */
public class ShogaishaKojoTaishoshaHaakuKekkaIchiranCsvProcess extends BatchProcessBase<DbT4038ShogaishaKoujoEntity> {

    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString CSV_WRITER_ENCLOSURE = new RString("\"");
    private static final EucEntityId CSV_ENTITY_ID = new EucEntityId(new RString("DBD419001"));
    private static final RString CSVファイル名 = new RString("ShogaishaKojoTaishoshaHaakuKekkaIchiranData.csv");
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shogaishakoujohaaku"
                    + ".IShogaishaKojoTaishoshaHaakuKekkaIchiranMapper.get障がい者控除");
    private RString csvFilePath;
    private FileSpoolManager manager;
    private RString fileName;

    @BatchWriter
    private CsvWriter<ShogaishaKojoTaishoshaCsvEntity> csvWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, CSV_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        csvFilePath = manager.getEucOutputDirectry();
        fileName = Path.combinePath(csvFilePath, CSVファイル名);
        csvWriter = new CsvWriter.InstanceBuilder(fileName)
                .alwaysWriteHeader(FuicchiCsvEntity.class)
                .setEncode(Encode.UTF_8withBOM)
                .setDelimiter(CSV_WRITER_DELIMITER)
                .setEnclosure(CSV_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected void process(DbT4038ShogaishaKoujoEntity item) {
        ShogaishaKojoTaishoshaCsvEntity csvEntity = new ShogaishaKojoTaishoshaCsvEntity();
        setCsvEntity(csvEntity, item);
        csvWriter.writeLine(csvEntity);
    }

    private void setCsvEntity(ShogaishaKojoTaishoshaCsvEntity csvEntity, DbT4038ShogaishaKoujoEntity list) {
        csvEntity.setShoKisaiHokenshaNo(list.getShoKisaiHokenshaNo().value());
        csvEntity.setHihokenshaNo(list.getHihokenshaNo().value());
        csvEntity.setRirekiNo(new RString(String.valueOf(list.getRirekiNo())));

        FlexibleDate shinsheiymd = list.getShinseiYMD();
        if (shinsheiymd == null) {
            csvEntity.setShinseiYMD(RString.EMPTY);
        } else {
            csvEntity.setShinseiYMD(new RString(shinsheiymd.toString()));
        }

        FlexibleDate ketteiymd = list.getKetteiYMD();
        if (ketteiymd == null) {
            csvEntity.setKetteiYMD(RString.EMPTY);
        } else {
            csvEntity.setKetteiYMD(new RString(ketteiymd.toString()));
        }

        FlexibleDate kijunymd = list.getKijunYMD();
        if (kijunymd == null) {
            csvEntity.setKijunYMD(RString.EMPTY);
        } else {
            csvEntity.setKijunYMD(new RString(kijunymd.toString()));
        }

        FlexibleDate haakuymd = list.getHaakuYMD();
        if (haakuymd == null) {
            csvEntity.setHaakuYMD(RString.EMPTY);
        } else {
            csvEntity.setHaakuYMD(new RString(haakuymd.toString()));
        }

        RString shinsheijiyu = list.getShinseiJiyu();
        if (shinsheijiyu == null) {
            csvEntity.setShinseiJiyu(RString.EMPTY);
        } else {
            csvEntity.setShinseiJiyu(new RString(shinsheijiyu.toString()));
        }

        RString ninteiKubun = list.getNinteiKubun();
        if (ninteiKubun == null) {
            csvEntity.setNinteiKubun(RString.EMPTY);
        } else {
            csvEntity.setNinteiKubun(new RString(ninteiKubun.toString()));
        }

        RString ninteiNaiyo = list.getNinteiNaiyo();
        if (ninteiNaiyo == null) {
            csvEntity.setNinteiNaiyo(RString.EMPTY);
        } else {
            csvEntity.setNinteiNaiyo(new RString(ninteiNaiyo.toString()));
        }

        Code jiritsudoCode = list.getNinchishoNichijoSeikatsuJiritsudoCode();
        if (jiritsudoCode == null) {
            csvEntity.setNinchishoNichijoSeikatsuJiritsudoCode(RString.EMPTY);
        } else {
            csvEntity.setNinchishoNichijoSeikatsuJiritsudoCode(new RString(jiritsudoCode.toString()));
        }

        Code shogaiNichiCode = list.getShogaiNichijoSeikatsuJiritsudoCode();
        if (shogaiNichiCode == null) {
            csvEntity.setShogaiNichijoSeikatsuJiritsudoCode(RString.EMPTY);
        } else {
            csvEntity.setShogaiNichijoSeikatsuJiritsudoCode(new RString(shogaiNichiCode.toString()));
        }
        csvEntity.setShogaishaTechoUmu(new RString(String.valueOf(list.getShogaishaTechoUmu())));

        RString shikakuSoshitsuJiyuCode = list.getShikakuSoshitsuJiyuCode();
        if (shikakuSoshitsuJiyuCode != null) {
            csvEntity.setShikakuSoshitsuJiyuCode(new RString(shikakuSoshitsuJiyuCode.toString()));
        } else {
            csvEntity.setShikakuSoshitsuJiyuCode(RString.EMPTY);
        }

        FlexibleDate shikakuSoshitsuYMD = list.getShikakuSoshitsuYMD();
        if (shikakuSoshitsuYMD == null) {
            csvEntity.setShikakuSoshitsuYMD(RString.EMPTY);
        } else {
            csvEntity.setShikakuSoshitsuYMD(new RString(shikakuSoshitsuYMD.toString()));
        }

        csvEntity.setNinteishoHakkoTaishogai(new RString(String.valueOf(list.getNinteishoHakkoTaishogai())));
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
        manager.spool(csvFilePath);
    }
}
