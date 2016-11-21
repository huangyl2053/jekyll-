/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA050010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.syoritaisyoshichoson.SyoriTaisyoShichoson;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba050010.JuminkirokuIdojohoTorokuKoikiProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.euc.juminidorendoshikakutoroku.FuseigoListCsvEntity;
import jp.co.ndensan.reams.db.dba.service.core.juminidorendoshikakutoroku.JuminIdoRendoShikakuToroku;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ua.uax.business.core.idoruiseki.ShikibetsuTaishoIdoJoho;
import jp.co.ndensan.reams.ua.uax.business.core.idoruiseki.ShikibetsuTaishoIdoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.service.core.idoruiseki.ShikibetsuTaishoIdoFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 住民異動連携情報登録【広域保険者用】のProcessのクラス。
 *
 * @reamsid_L DBA-1390-010 wanghuafeng
 */
public class SyoriTaisyoShichosonProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate."
            + "syoritaisyoshichoson.ISyoriTaisyoShichosonMapper.get宛名連動介護保険更新");
    private JuminkirokuIdojohoTorokuKoikiProcessParameter processParameter;
    private static final RString 異動後 = new RString("2");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString FILENAME = new RString("fuseigoList.csv");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBA800001");
    private RString 市町村コード;
    private RDateTime 抽出開始日時;
    private DbT7022ShoriDateKanriEntity 処理日付情報;
    private FileSpoolManager manager;
    private SyoriTaisyoShichoson business;
    private RString filePath;
    @BatchWriter
    private CsvWriter<FuseigoListCsvEntity> csvWriter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> tableWrite;

    @Override
    protected void initialize() {
        business = new SyoriTaisyoShichoson();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toJuminkirokuIdojohoTorokuKoikiMybatisParameter());
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        filePath = Path.combinePath(manager.getEucOutputDirectry(), FILENAME);
        csvWriter = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(getEncode()).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build();
        tableWrite = new BatchPermanentTableWriter<>(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity item) {
        if (item.getKijunTimestamp() != null) {
            抽出開始日時 = item.getKijunTimestamp().getRDateTime();
        }
        処理日付情報 = item;
        市町村コード = item.getShichosonCode().value();
        tableWrite.update(business.データ更新(processParameter, 処理日付情報));
        更新宛名識別対象異動分取得PSM(抽出開始日時, processParameter, 市町村コード);
        business.setlist(item);
    }

    private void 更新宛名識別対象異動分取得PSM(RDateTime 抽出開始日時, JuminkirokuIdojohoTorokuKoikiProcessParameter processParameter,
            RString 現地方公共団体コード) {
        SyoriTaisyoShichoson syoritaisyoshichoson = new SyoriTaisyoShichoson();
        ShikibetsuTaishoIdoSearchKeyBuilder keyBuilder = syoritaisyoshichoson.宛名識別対象異動分取得PSM(抽出開始日時, processParameter);
        ShikibetsuTaishoIdoFinder finder = ShikibetsuTaishoIdoFinder.createInstance();
        List<ShikibetsuTaishoIdoJoho> 宛名累積マスタデータリスト = finder.get宛名識別対象異動(keyBuilder.build());
        JuminIdoRendoShikakuToroku juminidorendoshikakutoroku = new JuminIdoRendoShikakuToroku();
        for (ShikibetsuTaishoIdoJoho 宛名識別対象 : 宛名累積マスタデータリスト) {
            if (異動後.equals(宛名識別対象.get異動前後区分())
                    && 現地方公共団体コード.equals(宛名識別対象.get現地方公共団体コード().value())) {
                juminidorendoshikakutoroku.to住民異動情報(宛名識別対象, csvWriter);
            }
        }
    }

    @Override
    protected void afterExecute() {
        if (business.getlist() == null) {
            business.getlist() = new ArrayList<>();
        }
        DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
        for (int i = 0; i < processParameter.getShichosonCode().size(); i++) {
            if (!business.getlist().contains(processParameter.getShichosonCode().get(i))) {
                business.データ登録(processParameter, entity, processParameter.getShichosonCode().get(i));
                tableWrite.insert(entity);
                更新宛名識別対象異動分取得PSM(null, processParameter, processParameter.getShichosonCode().get(i));
            }
        }
        manager.spool(filePath);
    }

    private Encode getEncode() {
        RString sakiEncodeKeitai = DbBusinessConfig.get(ConfigNameDBU.EUC共通_文字コード, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        Encode encode = Encode.UTF_8withBOM;
        if (new RString("1").equals(sakiEncodeKeitai)) {
            encode = Encode.UTF_8withBOM;
        } else if (new RString("2").equals(sakiEncodeKeitai)) {
            encode = Encode.SJIS;
        } else if (new RString("3").equals(sakiEncodeKeitai)) {
            encode = Encode.SJIS;
        }
        return encode;
    }
}
