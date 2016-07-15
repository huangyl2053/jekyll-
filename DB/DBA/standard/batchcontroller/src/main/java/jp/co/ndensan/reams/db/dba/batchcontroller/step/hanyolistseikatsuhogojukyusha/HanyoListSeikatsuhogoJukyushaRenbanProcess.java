/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.hanyolistseikatsuhogojukyusha;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hanyolistseikatsuhogojukyusha.HanyoListSeikatsuhogoJukyushaResult;
import jp.co.ndensan.reams.db.dba.definition.processprm.hanyolistseikatsuhogojukyusha.SeikatsuhogoJukyushaProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hanyolistseikatsuhogojukyusha.SeikatsuhogoJukyushaRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hanyolistseikatsuhogojukyusha.SeikatsuhogoJukyushaRenbanCsvEntity;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.basic.KaigoDonyuKeitaiManager;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt250FindAtesakiFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtenaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.code.FujoShuruiCodeValue;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 汎用リスト_生活保護受給者のデータを作成します(連番なし)。
 *
 * @reamsid_L DBA-1580-030 xuyannan
 */
public class HanyoListSeikatsuhogoJukyushaRenbanProcess extends BatchProcessBase<SeikatsuhogoJukyushaRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hanyolistseikatsuhogojukyusha."
            + "IHanyoListSeikatsuhogoJukyushaMapper.getSeikatsuHogoJukyusha");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBA701006");
    private static final RString FILENAME = new RString("HanyoList_SeikatsuHogoJukyusha.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString コンマ = new RString("、");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private SeikatsuhogoJukyushaProcessParameter processParamter;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private List<KoseiShichosonMaster> koseiShichosonJoho;
    private List<KaigoDonyuKeitai> kaigoDonyuKeitai;
    private Association association;
    private EucCsvWriter<SeikatsuhogoJukyushaRenbanCsvEntity> eucCsvWriter;
    private SeikatsuhogoJukyushaRelateEntity lastEntity;
    private List<PersonalData> personalDataList;
    private int i;
    private RStringBuilder newBuilder;
    private RStringBuilder oldBuilder;
    private RStringBuilder 生活保護種別builder;
    private RString psmShikibetsuTaisho;
    private RString psmAtesaki;

    @Override
    protected void initialize() {
        koseiShichosonJoho = KoseiShichosonJohoFinder.createInstance().get現市町村情報();
        kaigoDonyuKeitai = KaigoDonyuKeitaiManager.createInstance().get介護導入形態By業務分類(GyomuBunrui.介護事務);
        association = AssociationFinderFactory.createInstance().getAssociation();
        personalDataList = new ArrayList<>();
        newBuilder = new RStringBuilder();
        oldBuilder = new RStringBuilder();
        生活保護種別builder = new RStringBuilder();
        i = 0;
        lastEntity = new SeikatsuhogoJukyushaRelateEntity();
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
        AtenaSearchKeyBuilder atenaSearchKeyBuilder = new AtenaSearchKeyBuilder(
                KensakuYusenKubun.未定義, AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBA介護資格));
        UaFt250FindAtesakiFunction uaFt250Psm = new UaFt250FindAtesakiFunction(atenaSearchKeyBuilder.build().get宛先検索キー());
        psmAtesaki = new RString(uaFt250Psm.getParameterMap().get("psmAtesaki").toString());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toSeikatsuhogoJukyushaMybatisParameter(psmShikibetsuTaisho, psmAtesaki));
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), FILENAME);
        eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(processParamter.isKomokumeiFuka()).
                build();
    }

    @Override
    protected void process(SeikatsuhogoJukyushaRelateEntity entity) {
        newBuilder.append(entity.get識別コード()).append(RString.HALF_SPACE).append(entity.get業務コード())
                .append(RString.HALF_SPACE).append(entity.get生活保護開始日());
        if (RString.isNullOrEmpty(oldBuilder.toRString()) || newBuilder.equals(oldBuilder)) {
            生活保護種別builder.append(new FujoShuruiCodeValue(entity.get生活保護種別()).getRyakusho());
            生活保護種別builder.append(コンマ);
        } else {
            eucCsvWriter.writeLine(new HanyoListSeikatsuhogoJukyushaResult().
                    setRenbanEucCsvEntity(processParamter, lastEntity, koseiShichosonJoho, ++i, association, 生活保護種別builder));
            personalDataList.add(toPersonalData(entity));
            生活保護種別builder = new RStringBuilder();
            生活保護種別builder.append(new FujoShuruiCodeValue(entity.get生活保護種別()).getRyakusho());
            生活保護種別builder.append(コンマ);
        }
        oldBuilder = newBuilder;
        newBuilder = new RStringBuilder();
        lastEntity = entity;
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.writeLine(new HanyoListSeikatsuhogoJukyushaResult().
                setRenbanEucCsvEntity(processParamter, lastEntity, koseiShichosonJoho, i, association, 生活保護種別builder));
        personalDataList.add(toPersonalData(lastEntity));
        eucCsvWriter.close();
        AccessLogUUID log = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
        manager.spool(eucFilePath, log);
        バッチ出力条件リストの出力();
    }

    private void バッチ出力条件リストの出力() {
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                new RString("汎用リスト 生活保護受給者CSV"),
                association.getLasdecCode_().value(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                new RString("HanyoList_SeikatsuHogoJukyusha.csv"),
                EUC_ENTITY_ID.toRString(),
                new RString(String.valueOf(eucCsvWriter.getCount())),
                new HanyoListSeikatsuhogoJukyushaResult().get出力条件(processParamter, kaigoDonyuKeitai));
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private PersonalData toPersonalData(SeikatsuhogoJukyushaRelateEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                entity.get被保険者番号());
        return PersonalData.of(entity.getPsmEntity() == null ? ShikibetsuCode.EMPTY : entity.getPsmEntity().getShikibetsuCode(), expandedInfo);
    }
}
