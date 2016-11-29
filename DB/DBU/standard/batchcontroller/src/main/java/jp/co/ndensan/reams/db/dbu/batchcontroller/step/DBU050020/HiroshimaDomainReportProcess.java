/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU050020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.core.idolistidojoho.IdoListIdojohoKubun;
import jp.co.ndensan.reams.db.dbu.business.core.koikinaitenkyoresultlist.KoikinaiTenkyoResultListChohyoDataSakusei;
import jp.co.ndensan.reams.db.dbu.business.core.koikinaitenkyoresultlist.KoikinaiTenkyoResultListCsvDataSakusei;
import jp.co.ndensan.reams.db.dbu.business.report.koikinaitenkyokekkaichiranhyo.KoikinaiTenkyoKekkaIchiranhyoBodyItem;
import jp.co.ndensan.reams.db.dbu.business.report.koikinaitenkyokekkaichiranhyo.KoikinaiTenkyoKekkaIchiranhyoHeadItem;
import jp.co.ndensan.reams.db.dbu.business.report.koikinaitenkyokekkaichiranhyo.KoikinaiTenkyoKekkaIchiranhyoReport;
import jp.co.ndensan.reams.db.dbu.definition.processprm.hiroshimadomain.HiroshimaDomainProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hiroshimadomain.HiroshimaDomainEucCsvEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hiroshimadomain.HiroshimaDomainRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kouikitenkyoresultlist.KoikinaiTenkyoCSVDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kouikitenkyoresultlist.KoikinaiTenkyoEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kouikitenkyoresultlist.KoikinaiTenkyoListEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kouikitenkyoresultlist.KoikinaiTenkyoResultEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.koikinaitenkyokekkaichiranhyo.KoikinaiTenkyoKekkaIchiranhyoReportSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 広域内転居結果一覧表_バッチフ処理クラスです
 *
 * @reamsid_L DBU-1150-020 chenaoqi
 */
public class HiroshimaDomainReportProcess extends BatchProcessBase<HiroshimaDomainRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.hiroshimadomain.IHiroshimaDomainMapper.get転入転出異動情報");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBU200004_KoikinaiTenkyoKekkaIchiranhyo.csv");
    private static final ReportId DBU200004 = new ReportId("DBU200004_KoikinaiTenkyoKekkaIchiranhyo");
    private static final RString INDEX = new RString("000000");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString DELIMITER = new RString(" ");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString STRING_SAKUSEI = new RString("作成");
    private LasdecCode 市町村コード;
    private RString 市町村名称;
    private RString eucFilePath;
    private FileSpoolManager manager;
    @BatchWriter
    private BatchReportWriter<KoikinaiTenkyoKekkaIchiranhyoReportSource> batchReportWriter;
    private ReportSourceWriter<KoikinaiTenkyoKekkaIchiranhyoReportSource> reportSourceWriter;
    private CsvWriter<HiroshimaDomainEucCsvEntity> eucCsvWriter;
    private HiroshimaDomainProcessParameter processParameter;
    private List<KoikinaiTenkyoEntity> list;
    private boolean flag;

    @Override
    protected void initialize() {
        list = new ArrayList<>();
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        List<JuminShubetsu> 住民種別List = new ArrayList();
        List<JuminJotai> 住民状態List = new ArrayList();
        住民種別List.add(JuminShubetsu.日本人);
        住民種別List.add(JuminShubetsu.外国人);
        住民状態List.add(JuminJotai.住民);
        住民状態List.add(JuminJotai.住登外);
        住民状態List.add(JuminJotai.消除者);
        住民状態List.add(JuminJotai.転出者);
        住民状態List.add(JuminJotai.死亡者);
        builder.set住民種別(住民種別List);
        builder.set住民状態(住民状態List);
        builder.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
        processParameter.set宛名検索条件(searchKey);
        flag = false;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toIHiroshimaDomainMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(DBU200004.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, new RString("DBU200004_KoikinaiTenkyoKekkaIchiranhyo.csv"));
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();
    }

    @Override
    protected void process(HiroshimaDomainRelateEntity 転入転出異動情報Entity) {
        KoikinaiTenkyoEntity entity = new KoikinaiTenkyoEntity();
        if (転入転出異動情報Entity == null) {
            entity.set氏名(new AtenaMeisho(UrErrorMessages.該当データなし.toString()));
            flag = true;
        } else {
            if (転入転出異動情報Entity.get転出PSM_住登内住所() != null
                    && 転入転出異動情報Entity.get転出PSM_住登内番地() != null
                    && 転入転出異動情報Entity.get転出PSM_住登内方書() != null) {
                RString 前住所 = 転入転出異動情報Entity.get転出PSM_住登内住所().concat(DELIMITER).
                        concat(転入転出異動情報Entity.get転出PSM_住登内番地()).
                        concat(転入転出異動情報Entity.get転出PSM_住登内方書());
                entity.set前住所(前住所);
            }
            if (転入転出異動情報Entity.get転入PSM_住登内住所() != null
                    && 転入転出異動情報Entity.get転入PSM_住登内番地() != null
                    && 転入転出異動情報Entity.get転入PSM_住登内方書() != null) {

                RString 現住所 = 転入転出異動情報Entity.get転入PSM_住登内住所().concat(DELIMITER).
                        concat(転入転出異動情報Entity.get転入PSM_住登内番地()).
                        concat(転入転出異動情報Entity.get転入PSM_住登内方書());
                entity.set現住所(現住所);
            }

            entity.set被保険者番号(転入転出異動情報Entity.get転入_被保険者番号());
            entity.set氏名カナ(転入転出異動情報Entity.get転入PSM_カナ名称());
            entity.set氏名(転入転出異動情報Entity.get転入PSM_名称());
            entity.set旧住民コード(転入転出異動情報Entity.get転出_識別コード());
            entity.set転出予定日(転入転出異動情報Entity.get転出PSM_転出予定異動年月日());
            entity.set転出確定日(転入転出異動情報Entity.get転出PSM_転出確定異動年月日());
            entity.set転出確定通知日(転入転出異動情報Entity.get転出PSM_転出確定通知年月日());
            entity.set処理日(転入転出異動情報Entity.get転入_異動日());
            entity.set新住民コード(転入転出異動情報Entity.get転入_識別コード());
            entity.set登録異動日(転入転出異動情報Entity.get転入PSM_登録異動年月日());
            entity.set登録届出日(転入転出異動情報Entity.get転入PSM_登録異動届出日());
            entity.set異動情報(IdoListIdojohoKubun.広域内転居.get名称());
        }
        list.add(entity);

    }

    @Override
    protected void afterExecute() {
        if (processParameter.get市町村コード() != null
                && !INDEX.equals(processParameter.get市町村コード().value())) {
            市町村コード = processParameter.get市町村コード();
            市町村名称 = processParameter.get市町村名称();
        } else {
            Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
            市町村コード = 導入団体クラス.getLasdecCode_();
            市町村名称 = 導入団体クラス.get市町村名();
        }
        List<KoikinaiTenkyoResultEntity> 広域内転居結果帳票List = get帳票リスト(list, 市町村コード, 市町村名称);
        List<KoikinaiTenkyoKekkaIchiranhyoBodyItem> itemList = get広域内転居結果一覧表ボディのITEM(広域内転居結果帳票List);
        KoikinaiTenkyoKekkaIchiranhyoHeadItem headItem = new KoikinaiTenkyoKekkaIchiranhyoHeadItem(印刷日時表示作成(),
                市町村コード.value(),
                市町村名称);
        KoikinaiTenkyoKekkaIchiranhyoReport report = KoikinaiTenkyoKekkaIchiranhyoReport.createFrom(headItem, itemList);
        report.writeBy(reportSourceWriter);
        List<KoikinaiTenkyoCSVDataEntity> 広域内転居結果CSV = get広域内転居結果CSV(list);
        get広域内転居結果のCSV出力(広域内転居結果CSV);
        eucCsvWriter.close();
        manager.spool(eucFilePath);

    }

    /**
     * get帳票リスト
     *
     * @param list list
     * @param 市町村コード 市町村コード
     * @param 市町村名称 市町村名称
     * @return 帳票リスト
     */
    private List<KoikinaiTenkyoResultEntity> get帳票リスト(List<KoikinaiTenkyoEntity> list, LasdecCode 市町村コード, RString 市町村名称) {

        KoikinaiTenkyoListEntity 広域内転居結果一覧Entity = new KoikinaiTenkyoListEntity();
        if (flag) {
            KoikinaiTenkyoEntity 広域内転居結果Entity = new KoikinaiTenkyoEntity();
            広域内転居結果Entity.set氏名(new AtenaMeisho(UrErrorMessages.該当データなし.toString()));
            list.add(広域内転居結果Entity);
            広域内転居結果一覧Entity.set市町村コード(市町村コード);
            広域内転居結果一覧Entity.set市町村名(市町村名称);
            広域内転居結果一覧Entity.setEntity(list);
        } else {
            広域内転居結果一覧Entity.setEntity(list);
            広域内転居結果一覧Entity.set市町村コード(市町村コード);
            広域内転居結果一覧Entity.set市町村名(市町村名称);
        }
        KoikinaiTenkyoResultListChohyoDataSakusei chohyoSut = new KoikinaiTenkyoResultListChohyoDataSakusei();

        return chohyoSut.getKoikinai(広域内転居結果一覧Entity);
    }

    /**
     * get広域内転居結果CSV
     *
     * @param list
     * @return 広域内転居結果CSV
     */
    private List<KoikinaiTenkyoCSVDataEntity> get広域内転居結果CSV(List<KoikinaiTenkyoEntity> list) {
        if (flag) {
            KoikinaiTenkyoEntity 広域内転居結果Entity = new KoikinaiTenkyoEntity();
            広域内転居結果Entity.set氏名(new AtenaMeisho(UrErrorMessages.該当データなし.toString()));
            list.add(広域内転居結果Entity);
        }
        KoikinaiTenkyoResultListCsvDataSakusei csvSut = new KoikinaiTenkyoResultListCsvDataSakusei();
        return csvSut.getKoikinaiTenkyoResultListCsvData(list);
    }

    /**
     * CSV出力
     *
     * @param 広域内転居結果CSV 広域内転居結果CSV
     */
    private void get広域内転居結果のCSV出力(List<KoikinaiTenkyoCSVDataEntity> 広域内転居結果CSV) {
        if (広域内転居結果CSV != null && !広域内転居結果CSV.isEmpty()) {
            for (KoikinaiTenkyoCSVDataEntity csvDataEntity : 広域内転居結果CSV) {
                eucCsvWriter.writeLine(new HiroshimaDomainEucCsvEntity(csvDataEntity.get被保険者番号(),
                        csvDataEntity.get氏名カナ(),
                        csvDataEntity.get氏名(),
                        csvDataEntity.get旧住民コード(),
                        csvDataEntity.get前住所(),
                        csvDataEntity.get転出予定日(),
                        csvDataEntity.get転出確定日(),
                        csvDataEntity.get転出確定通知日(),
                        csvDataEntity.get処理日(),
                        csvDataEntity.get新住民コード(),
                        csvDataEntity.get現住所(),
                        csvDataEntity.get登録異動日(),
                        csvDataEntity.get登録届出日(),
                        csvDataEntity.get異動情報()
                ));
            }
        }

    }

    /**
     * get広域内転居結果一覧表ボディのITEM
     *
     * @param 広域内転居結果帳票List 広域内転居結果帳票List
     * @return 広域内転居結果一覧表ボディのITEM
     */
    private List<KoikinaiTenkyoKekkaIchiranhyoBodyItem> get広域内転居結果一覧表ボディのITEM(List<KoikinaiTenkyoResultEntity> 広域内転居結果帳票List) {
        List<KoikinaiTenkyoKekkaIchiranhyoBodyItem> itemList = new ArrayList<>();

        for (KoikinaiTenkyoResultEntity 広域内転居結果帳票Entity : 広域内転居結果帳票List) {
            KoikinaiTenkyoKekkaIchiranhyoBodyItem item = new KoikinaiTenkyoKekkaIchiranhyoBodyItem(
                    広域内転居結果帳票Entity.get被保険者番号(),
                    広域内転居結果帳票Entity.get氏名カナ(),
                    広域内転居結果帳票Entity.get旧住民コード(),
                    広域内転居結果帳票Entity.get前住所(),
                    広域内転居結果帳票Entity.get転出予定日(),
                    広域内転居結果帳票Entity.get転出確定日(),
                    広域内転居結果帳票Entity.get転出確定通知日(),
                    広域内転居結果帳票Entity.get処理日(),
                    広域内転居結果帳票Entity.get氏名(),
                    広域内転居結果帳票Entity.get新住民コード(),
                    広域内転居結果帳票Entity.get現住所(),
                    広域内転居結果帳票Entity.get登録異動日(),
                    広域内転居結果帳票Entity.get登録届出日(),
                    広域内転居結果帳票Entity.get異動情報()
            );
            itemList.add(item);
        }

        return itemList;
    }

    private RString 印刷日時表示作成() {
        RStringBuilder builder = new RStringBuilder();
        RDateTime now = RDateTime.now();
        builder.append(now.getDate().wareki()
                .eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.BLANK)
                .toDateString());
        builder.append(RString.HALF_SPACE);
        builder.append(now.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        return builder.append(RString.FULL_SPACE).append(STRING_SAKUSEI).toRString();
    }

}
