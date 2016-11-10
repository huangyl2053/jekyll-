/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC060020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyufuhitsuchisho.KyufuhiTsuchishoBatchMybitisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufuhitsuchisho.KyufuhiTsuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoIchiranCsvEntity;
import jp.co.ndensan.reams.db.dbc.service.core.kyufuhitsuchisho.KyufuhiTuchiHakkoIchiranCSV;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt250FindAtesakiFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DoitsuninDaihyoshaYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
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
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 給付費通知発行一覧表のCSVファイルを作成します。
 *
 * @reamsid_L DBC-2280-030 lizhuoxuan
 */
public class KyufuhiTuchiHakkoIchiranProcess extends BatchProcessBase<KyufuhiTuchiHakkoEntity> {

    private static final RString 介護給付費福祉用具貸与品目情報取得SQL = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kyufuhitsuchisho.IKyufuhiTsuchishoMapper.getSeikatsuHogoJukyusha");
    private AtesakiPSMSearchKeyBuilder 宛先builder;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200044");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 出力ファイル名
            = new RString("DBC200044_KyufuhiTuchiHakkoIchiran.csv");
    private KyufuhiTsuchishoProcessParameter processParameter;
    private static final RString 保険者コード_拡張情報 = new RString("0003");
    private static final RString 被保険者番号_拡張情報 = new RString("被保険者番号");
    private FileSpoolManager manager;
    private RString eucFilePath;
    private List<PersonalData> personalDataList;
    private boolean flag = true;
    @BatchWriter
    private CsvWriter<KyufuhiTuchiHakkoIchiranCsvEntity> eucCsvWriter;

    @Override
    protected IBatchReader createReader() {
        IAtesakiGyomuHanteiKey 宛先業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付);
        宛先builder = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー);
        宛先builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        宛先builder.set基準日(new FlexibleDate(processParameter.get処理年月日()));
        宛先builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        UaFt250FindAtesakiFunction uaFt250Psm = new UaFt250FindAtesakiFunction(宛先builder.build());
        KyufuhiTsuchishoBatchMybitisParameter mybatisParam = processParameter.
                toKyufuhiTsuchishoBatchMybitisParameter(new RString(uaFt250Psm.getParameterMap().get("psmAtesaki").toString()),
                        get宛名PSM検索きー());
        return new BatchDbReader(介護給付費福祉用具貸与品目情報取得SQL, mybatisParam);
    }

    @Override
    protected void initialize() {
        personalDataList = new ArrayList<>();
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        eucCsvWriter = BatchWriters.csvWriter(KyufuhiTuchiHakkoIchiranCsvEntity.class)
                .filePath(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected void process(KyufuhiTuchiHakkoEntity entity) {
        if (flag) {
            KyufuhiTuchiHakkoIchiranCsvEntity csvEntity = new KyufuhiTuchiHakkoIchiranCsvEntity();
            csvEntity.set作成日時(RDate.getNowDate().toDateString());
            eucCsvWriter.writeLine(csvEntity);
        }
        eucCsvWriter.writeLine(new KyufuhiTuchiHakkoIchiranCSV().csvファイル作成(entity));
        if (!RString.isNullOrEmpty(entity.get被保険者番号())) {
            personalDataList.add(toPersonalData(entity));
        }
    }

    @Override
    protected void afterExecute() {
        if (!flag) {
            eucCsvWriter.close();
            manager.spool(eucFilePath);
        } else {
            AccessLogUUID log = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
            eucCsvWriter.close();
            manager.spool(eucFilePath, log);
        }
    }

    private PersonalData toPersonalData(KyufuhiTuchiHakkoEntity entity) {
        if (RString.isNullOrEmpty(entity.get被保険者番号())) {
            if (entity.getAtesakiEntity() == null) {
                return PersonalData.of(ShikibetsuCode.EMPTY);
            } else {
                return PersonalData.of(entity.getAtesakiEntity().getShikibetsuCode());
            }
        } else {
            ExpandedInformation expandedInfo = new ExpandedInformation(new Code(保険者コード_拡張情報), 被保険者番号_拡張情報, entity.get被保険者番号());
            if (entity.getAtesakiEntity() == null) {
                return PersonalData.of(ShikibetsuCode.EMPTY);
            } else {
                return PersonalData.of(entity.getAtesakiEntity().getShikibetsuCode(), expandedInfo);
            }
        }
    }

    private IShikibetsuTaishoPSMSearchKey get宛名PSM検索きー() {
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        住民種別.add(JuminShubetsu.日本人);
        住民種別.add(JuminShubetsu.外国人);
        住民種別.add(JuminShubetsu.住登外個人_日本人);
        住民種別.add(JuminShubetsu.住登外個人_外国人);
        List<JuminJotai> 住民状態 = new ArrayList<>();
        住民状態.add(JuminJotai.住民);
        住民状態.add(JuminJotai.住登外);
        住民状態.add(JuminJotai.消除者);
        住民状態.add(JuminJotai.転出者);
        住民状態.add(JuminJotai.死亡者);
        builder.set住民種別(住民種別);
        builder.set住民状態(住民状態);
        builder.set同一人代表者優先区分(DoitsuninDaihyoshaYusenKubun.同一人代表者を優先しない);
        return builder.build();
    }
}
