/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA730010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hanyolisttekiyojogaisha.HanyoListTekiyoJogaishaResult;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba730010.HanyoListTekiyoJogaishaProcessParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hanyolisttekiyojogaisha.HanyoListTekiyoJogaishaCsvEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hanyolisttekiyojogaisha.HanyoListTekiyoJogaishaRelateEntity;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.basic.KaigoDonyuKeitaiManager;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt250FindAtesakiFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtenaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 汎用リスト_適用除外者のデータを作成します。
 *
 * @reamsid_L DBA-1600-030 yaodongsheng
 */
public class HanyoListTekiyoJogaishaProcess extends BatchProcessBase<HanyoListTekiyoJogaishaRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hanyolisttekiyokaisha.IHanyoListTekiyoJogaishaMapper.getTekiyoKaisha");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBA701003");
    private static final RString FILENAME = new RString("HanyoList_TekiyoJogaisha.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final int NUM5 = 5;
    private HanyoListTekiyoJogaishaProcessParameter processParamter;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private List<KoseiShichosonMaster> koseiShichosonJoho;
    private List<KaigoDonyuKeitai> kaigoDonyuKeitai;
    private Association association;
    private EucCsvWriter<HanyoListTekiyoJogaishaCsvEntity> eucCsvWriter;
    private List<PersonalData> personalDataList;

    @Override
    protected void initialize() {
        koseiShichosonJoho = KoseiShichosonJohoFinder.createInstance().get現市町村情報();
        kaigoDonyuKeitai = KaigoDonyuKeitaiManager.createInstance().get介護導入形態By業務分類(GyomuBunrui.介護事務);
        association = AssociationFinderFactory.createInstance().getAssociation();
        personalDataList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        if (processParamter.isJukyushaJoho_Nihonjin()) {
            住民種別.add(JuminShubetsu.日本人);
            住民種別.add(JuminShubetsu.住登外個人_日本人);
        }
        if (processParamter.isJukyushaJoho_Gaikokujin()) {
            住民種別.add(JuminShubetsu.外国人);
            住民種別.add(JuminShubetsu.住登外個人_外国人);
        }
        key.set住民種別(住民種別);
        if (Chiku.住所.getコード().equals(processParamter.getPsmChiku_Kubun())) {
            if (!RString.isNullOrEmpty(processParamter.getPsmGyoseiku_From())) {
                key.set町域コード開始値(new ChoikiCode(processParamter.getPsmGyoseiku_From()));
            }
            if (!RString.isNullOrEmpty(processParamter.getPsmGyoseiku_To())) {
                key.set町域コード開始値(new ChoikiCode(processParamter.getPsmGyoseiku_To()));
            }
        } else if (Chiku.行政区.getコード().equals(processParamter.getPsmChiku_Kubun())) {
            if (!RString.isNullOrEmpty(processParamter.getPsmGyoseiku_From())) {
                key.set行政区コード開始値(new GyoseikuCode(processParamter.getPsmGyoseiku_From()));
            }
            if (!RString.isNullOrEmpty(processParamter.getPsmGyoseiku_To())) {
                key.set行政区コード終了値(new GyoseikuCode(processParamter.getPsmGyoseiku_To()));
            }
        } else if (Chiku.地区.getコード().equals(processParamter.getPsmChiku_Kubun())) {
            if (!RString.isNullOrEmpty(processParamter.getPsmChiku1_From())) {
                key.set地区コード1開始値(new ChikuCode(processParamter.getPsmChiku1_From()));
            }
            if (!RString.isNullOrEmpty(processParamter.getPsmChiku1_To())) {
                key.set地区コード1終了値(new ChikuCode(processParamter.getPsmChiku1_To()));
            }
            if (!RString.isNullOrEmpty(processParamter.getPsmChiku2_From())) {
                key.set地区コード2開始値(new ChikuCode(processParamter.getPsmChiku2_From()));
            }
            if (!RString.isNullOrEmpty(processParamter.getPsmChiku2_To())) {
                key.set地区コード2終了値(new ChikuCode(processParamter.getPsmChiku2_To()));
            }
            if (!RString.isNullOrEmpty(processParamter.getPsmChiku3_From())) {
                key.set地区コード3開始値(new ChikuCode(processParamter.getPsmChiku3_From()));
            }
            if (!RString.isNullOrEmpty(processParamter.getPsmChiku3_To())) {
                key.set地区コード3終了値(new ChikuCode(processParamter.getPsmChiku3_To()));
            }
        }
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RString psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
        AtenaSearchKeyBuilder atenaSearchKeyBuilder = new AtenaSearchKeyBuilder(
                KensakuYusenKubun.未定義, AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBA介護資格));
        UaFt250FindAtesakiFunction uaFt250Psm = new UaFt250FindAtesakiFunction(atenaSearchKeyBuilder.build().get宛先検索キー());
        RString psmAtesaki = new RString(uaFt250Psm.getParameterMap().get("psmAtesaki").toString());
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toHanyoListTekiyoJogaishaMybatisParameter(
                psmShikibetsuTaisho, psmAtesaki, get出力順()));
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
    protected void process(HanyoListTekiyoJogaishaRelateEntity entity) {
        eucCsvWriter.writeLine(new HanyoListTekiyoJogaishaResult()
                .setEucCsvEntity(processParamter, entity, koseiShichosonJoho, association));
        personalDataList.add(toPersonalData(entity));
    }

    @Override
    protected void afterExecute() {
//        if (eucCsvWriter.getCount() == 0) {
//            eucCsvWriter.writeLine(setBlank());
//        }
        eucCsvWriter.close();
        AccessLogUUID log = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
        manager.spool(eucFilePath, log);
        バッチ出力条件リストの出力();
    }

    private HanyoListTekiyoJogaishaCsvEntity setBlank() {
        HanyoListTekiyoJogaishaCsvEntity entity = new HanyoListTekiyoJogaishaCsvEntity();
        entity.set識別コード(RString.EMPTY);
        entity.set住民種別(RString.EMPTY);
        entity.set氏名(RString.EMPTY);
        entity.set氏名カナ(RString.EMPTY);
        entity.set生年月日(RString.EMPTY);
        entity.set年齢(RString.EMPTY);
        entity.set性別(RString.EMPTY);
        entity.set続柄コード(RString.EMPTY);
        entity.set世帯コード(RString.EMPTY);
        entity.set世帯主名(RString.EMPTY);
        entity.set住所コード(RString.EMPTY);
        entity.set郵便番号(RString.EMPTY);
        entity.set住所番地方書(RString.EMPTY);
        entity.set住所(RString.EMPTY);
        entity.set番地(RString.EMPTY);
        entity.set方書(RString.EMPTY);
        entity.set行政区コード(RString.EMPTY);
        entity.set行政区名(RString.EMPTY);
        entity.set地区１(RString.EMPTY);
        entity.set地区２(RString.EMPTY);
        entity.set地区３(RString.EMPTY);
        entity.set連絡先１(RString.EMPTY);
        entity.set連絡先２(RString.EMPTY);
        entity.set登録異動日(RString.EMPTY);
        entity.set登録事由(RString.EMPTY);
        entity.set登録届出日(RString.EMPTY);
        entity.set住定異動日(RString.EMPTY);
        entity.set住定事由(RString.EMPTY);
        entity.set住定届出日(RString.EMPTY);
        entity.set消除異動日(RString.EMPTY);
        entity.set消除事由(RString.EMPTY);
        entity.set消除届出日(RString.EMPTY);
        entity.set転出入理由(RString.EMPTY);
        entity.set前住所郵便番号(RString.EMPTY);
        entity.set前住所番地方書(RString.EMPTY);
        entity.set前住所(RString.EMPTY);
        entity.set前住所番地(RString.EMPTY);
        entity.set前住所方書(RString.EMPTY);
        entity.set市町村コード(RString.EMPTY);
        entity.set市町村名(RString.EMPTY);
        entity.set保険者コード(RString.EMPTY);
        entity.set保険者名(RString.EMPTY);
        entity.set空白(RString.EMPTY);
        entity.set被保険者番号(RString.EMPTY);
        entity.set資格取得事由(RString.EMPTY);
        entity.set資格取得日(RString.EMPTY);
        entity.set資格取得届出日(RString.EMPTY);
        entity.set喪失事由(RString.EMPTY);
        entity.set資格喪失日(RString.EMPTY);
        entity.set資格喪失届日(RString.EMPTY);
        entity.set資格区分(RString.EMPTY);
        entity.set住所地特例状態(RString.EMPTY);
        entity.set資格証記載保険者番号(RString.EMPTY);
        entity.set適用除外適用事由(RString.EMPTY);
        entity.set適用除外適用日(RString.EMPTY);
        entity.set適用除外適用届出日(RString.EMPTY);
        entity.set適用除外解除事由(RString.EMPTY);
        entity.set適用除外解除日(RString.EMPTY);
        entity.set適用除外解除届出日(RString.EMPTY);
        entity.set適用除外施設コード(RString.EMPTY);
        entity.set適用除外施設名称(RString.EMPTY);
        entity.set適用除外入所日(RString.EMPTY);
        entity.set適用除外退所日(RString.EMPTY);
        entity.set適用除外施設郵便番号(RString.EMPTY);
        entity.set適用除外施設住所(RString.EMPTY);
        entity.set適用除外施設電話番号(RString.EMPTY);
        entity.set施設退所通知発行日(RString.EMPTY);
        entity.set施設変更通知発行日(RString.EMPTY);
        entity.set医療保険種別(RString.EMPTY);
        entity.set医療保険番号(RString.EMPTY);
        entity.set医療保険者名(RString.EMPTY);
        entity.set医療保険記号番号(RString.EMPTY);
        return entity;
    }

    private void バッチ出力条件リストの出力() {
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                new RString("汎用リスト 適用除外者CSV"),
                association.getLasdecCode_().value(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                new RString("HanyoList_TekiyoJogaisha.csv"),
                EUC_ENTITY_ID.toRString(),
                new RString(String.valueOf(eucCsvWriter.getCount())),
                new HanyoListTekiyoJogaishaResult().get出力条件(processParamter, kaigoDonyuKeitai));
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private PersonalData toPersonalData(HanyoListTekiyoJogaishaRelateEntity entity) {
        if (RString.isNullOrEmpty(entity.get被保険者番号())) {
            return PersonalData.of(entity.getPsmEntity() == null ? ShikibetsuCode.EMPTY : entity.getPsmEntity().getShikibetsuCode());
        } else {
            ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                    entity.get被保険者番号());
            return PersonalData.of(entity.getPsmEntity() == null ? ShikibetsuCode.EMPTY : entity.getPsmEntity().getShikibetsuCode(), expandedInfo);
        }
    }

    private RString get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = finder.get出力順(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA701003.getReportId(),
                processParamter.getShutsuryokujunId());
        RString 出力順 = RString.EMPTY;
        if (outputOrder != null) {
            出力順 = ChohyoUtil.get出力順OrderBy(MyBatisOrderByClauseCreator.create(
                    HanyoListTekiyoJogaishaResult.ShutsuryokujunEnum.class, outputOrder), NUM5);
        }
        return 出力順;
    }
}
