/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD519003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5190003.RenkeiDataShutsuryokuSikakuSakuseiSoshitsuProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.chohyoshuchiryokuyoshiseijyoho.ChohyoShuchiryokuyoShiseiJyohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5190003.ShinsaHanteiIraiIchiranhyoCsvEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiYukoKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.EucFileOutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
    private static final RString ファイル名_日本語 = new RString("資格喪失（死亡）データ送信ファイル");
    private static final RString ファイル名_英数字 = new RString("NCI201.csv");
    private static final RString 今回開始日時 = new RString("【今回開始日時】");
    private static final RString 今回終了日時 = new RString("【今回終了日時】");
    private static final RString 申請書管理番号 = new RString("申請書管理番号");
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
                build();
    }

    @Override
    protected void process(ChohyoShuchiryokuyoShiseiJyohoEntity entity) {
        连番++;
        ShinsaHanteiIraiIchiranhyoCsvEntity csvEntity = getCsvEntity(entity);
        csvWriter.writeLine(csvEntity);
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                ファイル名_日本語,
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(JobContextHolder.getJobId()),
                ファイル名_英数字,
                EUC_ENTITY_ID.toRString(),
                new RString(连番),
                contribute());
        EucFileOutputJokenhyoFactory.createInstance(item).print();
        ExpandedInformation expandedInformations
                = new ExpandedInformation(new Code("0001"), 申請書管理番号, 申請書管理番号);
        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, expandedInformations);
        AccessLogger.log(AccessLogType.照会, personalData);
        manager.spool(SubGyomuCode.DBD介護受給, filepath);
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        if (para.getKonkaikaishidatetime() != null && para.getKonkaikaishidatetime().getDate().isWareki()) {
            出力条件.add(今回開始日時.concat(para.getKonkaikaishidatetime().getDate().wareki().toDateString()));
        }
        if (para.getKonkaishoridatetime() != null && para.getKonkaishoridatetime().getDate().isWareki()) {
            出力条件.add(今回終了日時.concat(para.getKonkaishoridatetime().getDate().wareki().toDateString()));
        }
        return 出力条件;
    }

    private ShinsaHanteiIraiIchiranhyoCsvEntity getCsvEntity(ChohyoShuchiryokuyoShiseiJyohoEntity entity) {
        ShinsaHanteiIraiIchiranhyoCsvEntity csvEntity = new ShinsaHanteiIraiIchiranhyoCsvEntity();
        csvEntity.set識別コード(entity.get識別コード().value());
        csvEntity.set保険者番号(entity.get証記載保険者番号().value());
        csvEntity.set被保険者番号(entity.get被保険者番号().value());
        FlexibleDate date = entity.get認定申請年月日();
        FlexibleDate newdate = new FlexibleDate(date.getYearValue(), date.getMonthValue(), 1);
        csvEntity.set認定申請日(new RString(newdate.wareki().toString()));
        csvEntity.set枝番(entity.get枝番());
        csvEntity.set申請区分法令コード(new RString(NinteiShinseiKubunShinsei.職権.toString()));
        csvEntity.set申請区分申請時コード(new RString(NinteiShinseiKubunShinsei.資格喪失_死亡.toString()));
        csvEntity.set取下区分コード(new RString(NinteiShinseiYukoKubunCode.有効.toString()));
        csvEntity.set被保険者区分コード(HihokenshaKubunCode.toValue(entity.get被保険者区分コード()).get名称());
        csvEntity.set申請代行区分コード(ShinseiTodokedeDaikoKubunCode.toValue(entity.get申請届出代行区分コード().value()).get名称());
        csvEntity.set生年月日(entity.get生年月日().wareki().toDateString());
        csvEntity.set性別コード(Seibetsu.toValue(entity.get性別()).get名称());
        csvEntity.set前回の認定審査会結果(YokaigoJotaiKubun09.toValue(entity.get前回要介護状態区分コード().value()).get名称());
        return csvEntity;
    }

}
