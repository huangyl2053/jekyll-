/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU070020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.kaigojuminhyokobetsukoikiunyo.KaigoJuminhyoKobetsuKoikiunyo;
import jp.co.ndensan.reams.db.dbu.definition.processprm.kaigojyuminhyokoukiu.KaiGoJuminHyokouKiuProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojuminhyo.KaigoJuminhyoRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojuminhyokobetsujikou.IKaigoJuminhyoEucCsvEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojuminhyokobetsujikou.KaigoJuminhyoEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojuminhyokobetsujikou.RendoPatternEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojyuminhyoutashajuki.KaigoJyuminhyouKoikiunyoJuniCSVDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojyuminhyoutashajuki.KaigoJyuminhyouKoikiunyoJuniEucCSVDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojyuminhyoutashajuki.KaigoJyuminhyouTashajukiCSVDateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojyuminhyoutashajuki.KaigoJyuminhyouTashajukiDateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojyuminhyoutashajuki.KaigoJyuminhyouTashajukiEucCSVDateEntity;
import jp.co.ndensan.reams.db.dbu.service.core.kaigojyuminhyoutashajuki.KaiGoJuminHyokouKiuEucCsvBusiness;
import jp.co.ndensan.reams.db.dbu.service.core.kaigojyuminhyoutashajuki.KaigoJyuminhyouKoikiunyoCSVDataSakuseiFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.RenkeiDataFormatVersion;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SofuRenkeiDataKyoyuFileName;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7035RendoPatternEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic.IDbT7035RendoPatternMapper;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 介護住民票個別事項連携情報作成【広域運用】のバッチのパラメータです。
 *
 * @reamsid_L DBU-0550-020 wanghui
 *
 */
public class KaiGoJuminHyokouKiuEucCsvProcess extends BatchProcessBase<KaigoJuminhyoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.kaigojyuminhyokoukiu."
            + "IkaigojyuminhyokoukiuMapper.getKaigoJuminhyoEntity");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("KaigoJuminhyoEucCsv"));
    List<KaigoJuminhyoKobetsuKoikiunyo> koikiunyoEntityList = new ArrayList<>();
    private RString renkeiFileName = RString.EMPTY;
    private static final RString 日時 = new RString("@日時@");
    private static final RString 市町村コード = new RString("@市町村コード@");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private KaiGoJuminHyokouKiuProcessParameter processParameter;
    private final int maxKeepVersions = 1000;
    private FileSpoolManager manager;
    private KaigoJyuminhyouKoikiunyoCSVDataSakuseiFinder finder;
    List<KaigoJyuminhyouTashajukiCSVDateEntity> hachiCSVDataEntityList = new ArrayList<>();
    List<KaigoJyuminhyouKoikiunyoJuniCSVDataEntity> junitoJugoCSVDataEntityList = new ArrayList<>();
    private RString eucFilePath;
    List<KaigoJuminhyoEntity> kaigoJuminhyoEntityList = new ArrayList<>();
    List<DbT1001HihokenshaDaichoEntity> dbT1001Entity = new ArrayList<>();
    private OutputParameter<RString> outSharedFileName;
    private OutputParameter<RDateTime> outSharedFileID;
    private KaiGoJuminHyokouKiuEucCsvBusiness business;
    private IDbT7035RendoPatternMapper rendoPatternMapper;
    private DbT7035RendoPatternEntity dbT7035Entity;
    private RendoPatternEntity rendoPatternEntity;
    @BatchWriter
    private CsvWriter<IKaigoJuminhyoEucCsvEntity> eucCsvWriterJunitoJugo;

    @Override
    protected void initialize() {
        business = new KaiGoJuminHyokouKiuEucCsvBusiness();
        outSharedFileName = new OutputParameter<>();
        outSharedFileID = new OutputParameter<>();
        rendoPatternMapper = getMapper(IDbT7035RendoPatternMapper.class);
        dbT7035Entity = rendoPatternMapper.getRendoPatternEntity(new FlexibleDate(RDate.getNowDate().toDateString()));
        if (dbT7035Entity == null) {
            throw new BatchInterruptedException(DbzErrorMessages.連携パターン取得エラー.getMessage().toString());
        }
        rendoPatternEntity = new RendoPatternEntity();
        rendoPatternEntity.setSakiFormatVersion(dbT7035Entity.getSakiFormatVersion());
        rendoPatternEntity.setSakiEncodeKeitai(dbT7035Entity.getSakiEncodeKeitai());
        rendoPatternEntity.setCodeHenkanKubun(dbT7035Entity.getCodeHenkanKubun());
        rendoPatternEntity.setRenkeiFileName(dbT7035Entity.getRenkeiFileName());
        renkeiFileName = rendoPatternEntity.getRenkeiFileName();
        if (!RString.isNullOrEmpty(renkeiFileName)) {
            if (renkeiFileName.contains(日時)) {
                renkeiFileName = renkeiFileName.replace(日時.toString(), new YMDHMS(RDate.getNowDateTime()).toString());
            }
            if (renkeiFileName.contains(市町村コード)) {
                Association association = AssociationFinderFactory.createInstance().getAssociation();
                renkeiFileName = renkeiFileName.replace(市町村コード.toString(), association.get地方公共団体コード().toString());
            }
        }
        rendoPatternEntity.setRenkeiFileName(renkeiFileName);
        finder = KaigoJyuminhyouKoikiunyoCSVDataSakuseiFinder.createInstance();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toKaiGoJuminHyokouKiuMapperParameter());
    }

    @Override
    protected void createWriter() {
        if (RenkeiDataFormatVersion.他社介護標準_固定長.getコード().equals(rendoPatternEntity.getSakiFormatVersion())
                || RenkeiDataFormatVersion.Ｒ_ＮＥＴ介護標準_固定長.getコード().equals(rendoPatternEntity.getSakiFormatVersion())
                || RenkeiDataFormatVersion.Ｒｅａｍｓ介護標準_固定長.getコード().equals(rendoPatternEntity.getSakiFormatVersion())) {
            manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Other);
        }
        if (RenkeiDataFormatVersion.他社介護標準_ＣＳＶ版.getコード().equals(rendoPatternEntity.getSakiFormatVersion())
                || RenkeiDataFormatVersion.Ｒ_ＮＥＴ介護標準_ＣＳＶ版.getコード().equals(rendoPatternEntity.getSakiFormatVersion())
                || RenkeiDataFormatVersion.Ｒｅａｍｓ介護標準_ＣＳＶ版.getコード().equals(rendoPatternEntity.getSakiFormatVersion())) {
            manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        }
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, new RString(rendoPatternEntity.getRenkeiFileName().toString()));
        if (RenkeiDataFormatVersion.他社介護標準_固定長.getコード().equals(rendoPatternEntity.getSakiFormatVersion())
                || RenkeiDataFormatVersion.他社介護標準_ＣＳＶ版.getコード().equals(rendoPatternEntity.getSakiFormatVersion())) {
            eucCsvWriterJunitoJugo = new CsvWriter.InstanceBuilder(eucFilePath).
                    setEncode(business.getEncode(rendoPatternEntity.getSakiEncodeKeitai()))
                    .setDelimiter(EUC_WRITER_DELIMITER)
                    .setEnclosure(EUC_WRITER_ENCLOSURE)
                    .setNewLine(NewLine.CRLF)
                    .hasHeader(true).
                    build();
        }
        if (RenkeiDataFormatVersion.Ｒ_ＮＥＴ介護標準_固定長.getコード().equals(rendoPatternEntity.getSakiFormatVersion())
                || RenkeiDataFormatVersion.Ｒ_ＮＥＴ介護標準_ＣＳＶ版.getコード().equals(rendoPatternEntity.getSakiFormatVersion())
                || RenkeiDataFormatVersion.Ｒｅａｍｓ介護標準_固定長.getコード().equals(rendoPatternEntity.getSakiFormatVersion())
                || RenkeiDataFormatVersion.Ｒｅａｍｓ介護標準_ＣＳＶ版.getコード().equals(rendoPatternEntity.getSakiFormatVersion())) {
            eucCsvWriterJunitoJugo = new CsvWriter.InstanceBuilder(eucFilePath).
                    setEncode(business.getEncode(rendoPatternEntity.getSakiEncodeKeitai()))
                    .setDelimiter(EUC_WRITER_DELIMITER)
                    .setEnclosure(EUC_WRITER_ENCLOSURE)
                    .setNewLine(NewLine.CRLF)
                    .hasHeader(true).
                    build();
        }
    }

    @Override
    protected void process(KaigoJuminhyoRelateEntity entity) {
        business.setkaigoJuminhyoEntityList(entity);
    }

    @Override
    protected void afterExecute() {
        if (RenkeiDataFormatVersion.他社介護標準_固定長.getコード().equals(rendoPatternEntity.getSakiFormatVersion())
                || RenkeiDataFormatVersion.他社介護標準_ＣＳＶ版.getコード().equals(rendoPatternEntity.getSakiFormatVersion())) {
            List<KaigoJyuminhyouTashajukiDateEntity> entityList = get介護住民票個別事項連携情報リストのIsEmpty(business.getkaigoJuminhyoEntityList());
            for (int i = 0; i < processParameter.getKobetsuKoikiunyoParameterList().size(); i++) {
                hachiCSVDataEntityList = finder.getKaigoJyuminhyouTashajukiHachiCSVData(entityList,
                        processParameter.getKobetsuKoikiunyoParameterList().get(i).getShichosonCode(),
                        rendoPatternEntity.getCodeHenkanKubun()).records();
                get広域8桁CSVデータのCSV出力(hachiCSVDataEntityList);
            }
        }
        if (RenkeiDataFormatVersion.Ｒ_ＮＥＴ介護標準_固定長.getコード().equals(rendoPatternEntity.getSakiFormatVersion())
                || RenkeiDataFormatVersion.Ｒ_ＮＥＴ介護標準_ＣＳＶ版.getコード().equals(rendoPatternEntity.getSakiFormatVersion())) {
            List<KaigoJyuminhyouTashajukiDateEntity> entityList = get介護住民票個別事項連携情報リストのIsEmpty(business.getkaigoJuminhyoEntityList());
            for (int i = 0; i < processParameter.getKobetsuKoikiunyoParameterList().size(); i++) {
                junitoJugoCSVDataEntityList
                        = finder.getKaigoJyuminhyouKoikiunyoJuniCSVData(entityList,
                                processParameter.getKobetsuKoikiunyoParameterList().get(i).getShichosonCode(),
                                rendoPatternEntity.getCodeHenkanKubun()).records();
                get広域12桁または15桁CSVデータのCSV出力(junitoJugoCSVDataEntityList);

            }
        }
        if (RenkeiDataFormatVersion.Ｒｅａｍｓ介護標準_固定長.getコード().equals(rendoPatternEntity.getSakiFormatVersion())
                || RenkeiDataFormatVersion.Ｒｅａｍｓ介護標準_ＣＳＶ版.getコード().equals(rendoPatternEntity.getSakiFormatVersion())) {
            List<KaigoJyuminhyouTashajukiDateEntity> entityList = get介護住民票個別事項連携情報リストのIsEmpty(business.getkaigoJuminhyoEntityList());
            for (int i = 0; i < processParameter.getKobetsuKoikiunyoParameterList().size(); i++) {
                junitoJugoCSVDataEntityList
                        = finder.getKaigoJyuminhyouKoikiunyoJugoCSVData(entityList,
                                processParameter.getKobetsuKoikiunyoParameterList().get(i).getShichosonCode(),
                                rendoPatternEntity.getCodeHenkanKubun()).records();
                get広域12桁または15桁CSVデータのCSV出力(junitoJugoCSVDataEntityList);

            }
        }
        eucCsvWriterJunitoJugo.close();
        for (int i = 0; i < processParameter.getKobetsuKoikiunyoParameterList().size(); i++) {
            FilesystemName ファイル名称 = new FilesystemName(new RString(processParameter.getShichosonCode().toString())
                    .concat(SofuRenkeiDataKyoyuFileName.介護個別事項異動情報_一定間隔.get名称()));
            setSharedFile(ファイル名称);
        }
        manager.spool(eucFilePath);
    }

    private void setSharedFile(FilesystemName 共有ファイル名) {
        SharedFile.defineSharedFile(共有ファイル名, maxKeepVersions, SharedFile.GROUP_ALL, null, false, null);
        RDateTime fileId = SharedFile.copyToSharedFile(new FilesystemPath(eucFilePath), 共有ファイル名);
        outSharedFileName.setValue(共有ファイル名.toRString());
        outSharedFileID.setValue(fileId);
    }

    private void get広域8桁CSVデータのCSV出力(List<KaigoJyuminhyouTashajukiCSVDateEntity> hachiCSVDataEntityList) {
        for (KaigoJyuminhyouTashajukiCSVDateEntity entity : hachiCSVDataEntityList) {
            eucCsvWriterJunitoJugo.writeLine(
                    new KaigoJyuminhyouKoikiunyoJuniEucCSVDataEntity(
                            entity.get市町村コード(),
                            entity.get識別ＩＤ(),
                            entity.getタイムスタンプ(),
                            entity.get最終レコード区分(),
                            entity.get連番(),
                            entity.getＦＩＬＬＥＲ1(),
                            entity.get被保険者番号(),
                            entity.get識別コード(),
                            entity.get資格取得日(),
                            entity.get資格喪失日(),
                            entity.get受給認定年月日(),
                            entity.get受給認定取消年月日(),
                            entity.get資格区分(),
                            entity.get受給者区分(),
                            entity.get更新日時(),
                            entity.getＦＩＬＬＥＲ2()
                    ));
        }
    }

    private void get広域12桁または15桁CSVデータのCSV出力(List<KaigoJyuminhyouKoikiunyoJuniCSVDataEntity> junitoJugoCSVDataEntityList) {
        for (KaigoJyuminhyouKoikiunyoJuniCSVDataEntity entity : junitoJugoCSVDataEntityList) {
            eucCsvWriterJunitoJugo.writeLine(
                    new KaigoJyuminhyouTashajukiEucCSVDateEntity(
                            entity.get市町村コード(),
                            entity.get識別ＩＤ(),
                            entity.getタイムスタンプ(),
                            entity.get最終レコード区分(),
                            entity.get連番(),
                            entity.get識別コード(),
                            entity.get被保険者番号(),
                            entity.get資格取得日(),
                            entity.get資格喪失日(),
                            entity.get資格被保険者区分(),
                            entity.get住所地特例者区分(),
                            entity.get受給者区分(),
                            entity.get要介護状態区分コード(),
                            entity.get認定有効開始日(),
                            entity.get認定有効終了日(),
                            entity.get受給認定年月日(),
                            entity.get受給認定取消年月日(),
                            entity.get削除フラグ(),
                            entity.get作成日時(),
                            entity.get更新日時()
                    ));
        }
    }

    private List<KaigoJyuminhyouTashajukiDateEntity> get介護住民票個別事項連携情報リストのIsEmpty(List<KaigoJuminhyoEntity> kaigoJuminhyoEntityList) {
        List<KaigoJyuminhyouTashajukiDateEntity> tashajukiDateEntity = new ArrayList<>();
        for (KaigoJuminhyoEntity entity : kaigoJuminhyoEntityList) {
            if (!RString.isNullOrEmpty(entity.get広域運用_shikibetsuCode()) && !RString.isNullOrEmpty(entity.get広域運用_shichosonCode())) {
                KaigoJyuminhyouTashajukiDateEntity tashaJukiDataEntity = business.get介護住民票個別事項連携情報作成広域運用情報の作成処理(entity);
                KaigoJyuminhyouTashajukiDateEntity kaigoJuminhyoTashaJukiData = finder.getKaigoJyuminhyouKoikiunyoData(tashaJukiDataEntity);
                tashajukiDateEntity.add(kaigoJuminhyoTashaJukiData);
            }
        }
        return tashajukiDateEntity;
    }
}
