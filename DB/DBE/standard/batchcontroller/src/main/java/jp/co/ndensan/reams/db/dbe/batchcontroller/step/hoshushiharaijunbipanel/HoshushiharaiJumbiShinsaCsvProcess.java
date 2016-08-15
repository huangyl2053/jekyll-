/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.hoshushiharaijunbipanel;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.hoshushiharaijunbipanel.HoshushiharaiJumbiBusiness;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hoshushiharaijunbipanel.HoshushiharaiJumbiPanelProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbipanel.HoshushiharaiJumbiPanelBatchRelateEntity;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.service.core.koza.KozaManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 認定調査報酬振込先情報のprocessです。
 *
 * @reamsid_L DBE-1990-020 lizhuoxuan
 */
public class HoshushiharaiJumbiShinsaCsvProcess extends BatchProcessBase<HoshushiharaiJumbiPanelBatchRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hoshushiharaijunbipanel.IHoshuShiharaiJunbiPanelMapper"
            + ".get審査会委員報酬");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBE622001");
    private HoshushiharaiJumbiPanelProcessParamter processParameter;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private int count = 0;
    private int kinkaku = 0;
    private static final int maxKeepVersions = 1;
    private static final int INT_ONE = 110;
    private static final int INT_NINE = 119;
    private OutputParameter<RString> outSharedFileName;
    private OutputParameter<RDateTime> outSharedFileID;

    @BatchWriter
    BatchSimpleWriter batchsimplewriter;

    @Override
    protected void initialize() {
        outSharedFileName = new OutputParameter<>();
        outSharedFileID = new OutputParameter<>();
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), new RString("HoshuShiharaiShinsakaiiin.DAT"));

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toHoshushiharaiJumbiPanelBatchMybitisParameter());
    }

    @Override
    protected void createWriter() {
        batchsimplewriter = new BatchSimpleWriter(eucFilePath, Encode.SJIS);
    }

    @Override
    protected void process(HoshushiharaiJumbiPanelBatchRelateEntity entity) {
        count++;
        kinkaku = kinkaku + entity.getShinsakaiHoshuGokei();
        HoshushiharaiJumbiBusiness business = new HoshushiharaiJumbiBusiness();
        batchsimplewriter.writeLine(business.setEucCsvEntity(entity, getKoza(entity),
                processParameter.getFurikomishiteiday()));
    }

    @Override
    protected void afterExecute() {
        FilesystemName ファイル名称 = new FilesystemName(new RString("HoshuShiharaiShinsakaiiin.DAT"));
        setSharedFile(ファイル名称);
        RStringBuilder builder = new RStringBuilder();
        builder.append(new RString("8"));
        builder.append(count);
        builder.append(kinkaku);
        builder.append(RString.EMPTY.padLeft(RString.HALF_SPACE, INT_ONE));
        batchsimplewriter.writeLine(builder.toRString());
        builder = new RStringBuilder();
        builder.append(new RString("9"));
        builder.append(RString.EMPTY.padLeft(RString.HALF_SPACE, INT_NINE));
        batchsimplewriter.writeLine(builder.toRString());
        batchsimplewriter.close();
        manager.spool(eucFilePath);
        outputJokenhyoFactory();
    }

    private void setSharedFile(FilesystemName 共有ファイル名) {
        SharedFile.defineSharedFile(共有ファイル名, maxKeepVersions, SharedFile.GROUP_ALL, null, false, null);
        RDateTime fileId = SharedFile.copyToSharedFile(new FilesystemPath(eucFilePath), 共有ファイル名);
        outSharedFileName.setValue(共有ファイル名.toRString());
        outSharedFileID.setValue(fileId);
    }

    private List<Koza> getKoza(HoshushiharaiJumbiPanelBatchRelateEntity entity) {
        if (entity.getNinteichosaItakusakiCode() != null && !entity.getNinteichosaItakusakiCode().isEmpty()) {
            return get口座情報(new KamokuCode("003"), entity.getNinteichosaItakusakiCode());
        }
        if (entity.getShujiiIryoKikanCode() != null && !entity.getShujiiIryoKikanCode().isEmpty()) {
            return get口座情報(new KamokuCode("002"), entity.getShujiiIryoKikanCode());
        }
        if (entity.getSonotaKikanCode() != null && !entity.getSonotaKikanCode().isEmpty()) {
            return get口座情報(new KamokuCode("004"), entity.getSonotaKikanCode());
        }
        return null;
    }

    /**
     * 口座情報の編集処理です。
     *
     * @param kamokuCode 科目コード
     * @param 業務固有キー 業務固有キー
     * @return ChosaHoshuShiharaiEntity
     */
    private List<Koza> get口座情報(KamokuCode kamokuCode, RString key) {
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        builder.set業務コード(GyomuCode.DB介護保険);
        builder.setサブ業務コード(SubGyomuCode.DBE認定支援);
        builder.set科目コード(kamokuCode);
        List<RString> 業務固有キー = new ArrayList<>();
        業務固有キー.add(key);
        builder.set業務固有キーリスト(業務固有キー);
        builder.set用途区分(new KozaYotoKubunCodeValue(new RString("1")));
        IKozaSearchKey searchKey = builder.build();
        return KozaManager.createInstance().get口座(searchKey);
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                new RString("報酬支払いデータ（審査会委員報酬）"),
                association.getLasdecCode_().value(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                new RString("HoshuShiharaiShinsakaiiin.DAT"),
                EUC_ENTITY_ID.toRString(),
                new HoshushiharaiJumbiBusiness().get出力件数(new Decimal(batchsimplewriter.getCount())),
                new HoshushiharaiJumbiBusiness().get出力条件(processParameter));
        OutputJokenhyoFactory.createInstance(item).print();
    }
}
