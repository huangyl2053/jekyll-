/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD519003;

import jp.co.ndensan.reams.db.dbd.business.core.dbd519003.ShinsaHanteiIraiIchiranhyoCsvProcessCore;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5190003.RenkeiDataShutsuryokuSikakuSakuseiSoshitsuProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.chohyoshuchiryokuyoshiseijyoho.ChohyoShuchiryokuyoShiseiJyohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5190003.ShinsaHanteiIraiIchiranhyoCsvEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.EucFileOutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 資格喪失（死亡）データのCsvProcessクラスです。
 *
 * @reamsid_L DBD-2110-010 LDNS shaotw
 */
public class ShinsaHanteiIraiIchiranhyoCsvProcess extends BatchProcessBase<ChohyoShuchiryokuyoShiseiJyohoEntity> {

    private static final RString MYBATIS_SELECT_ID_資格喪失 = new RString("jp.co.ndensan.reams.db.dbd.persistence"
            + ".db.mapper.relate.shikakusoushitsudata.IShikakuSoushitsuDataMapper.getShikakuSoshitsuEntity");
    private RenkeiDataShutsuryokuSikakuSakuseiSoshitsuProcessParameter para;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBD519003"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 申請書管理番号 = new RString("申請書管理番号");
    private ShinsaHanteiIraiIchiranhyoCsvProcessCore core;
    private int 连番;
    private static final int COUNT_ZERO = 0;
    private FileSpoolManager manager;
    private RString filepath;
    private IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey;

    @BatchWriter
    private CsvWriter<ShinsaHanteiIraiIchiranhyoCsvEntity> csvWriter;

    @Override
    protected void initialize() {
        连番 = COUNT_ZERO;
        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.未定義);
        shikibetsuTaishoPSMSearchKey = key.build();
        core = new ShinsaHanteiIraiIchiranhyoCsvProcessCore();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID_資格喪失,
                para.toRenkeiDataShutsuryokuSikakuSakuseiSoshitsuMybatisParameter(shikibetsuTaishoPSMSearchKey));
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        filepath = Path.combinePath(manager.getEucOutputDirectry(), para.getNewfilename());
        csvWriter = new CsvWriter.InstanceBuilder(filepath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void process(ChohyoShuchiryokuyoShiseiJyohoEntity entity) {
        连番++;
        ShinsaHanteiIraiIchiranhyoCsvEntity csvEntity = core.toCsvEntity(entity);
        csvWriter.writeLine(csvEntity);
        if (entity.get申請書管理番号() != null) {
            PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY,
                    new ExpandedInformation(new Code("0001"), 申請書管理番号, entity.get申請書管理番号().value()));
            AccessLogger.log(AccessLogType.照会, personalData);
        }
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        EucFileOutputJokenhyoItem item = core.資格喪失CSV出力(连番, para, association);
        EucFileOutputJokenhyoFactory.createInstance(item).print();
        manager.spool(SubGyomuCode.DBD介護受給, filepath);
    }
}
