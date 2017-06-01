/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosadataoutput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosadataoutput.NinteiChosaDataOutputResult;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosadataoutput.NinteiChosaFileOutputProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaOutputPersonalDataEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.api.EucOtherInfo;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.ZipUtil;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 *
 * @author n3509
 */
public class NinteiChosaFileOutputProcess extends BatchProcessBase<NinteiChosaOutputPersonalDataEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosadataoutput.INinteiChosaDataOutputMapper."
            + "getPersonalData");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBE224005");
    private static final EucEntityId EUC_ENTITY_ID_DATA = new EucEntityId("DBE224001");
    private static final EucEntityId EUC_ENTITY_ID_TOKKI = new EucEntityId("DBE224003");
    private static final EucEntityId EUC_ENTITY_ID_GAIKYO = new EucEntityId("DBE224004");
    private static final EucEntityId EUC_ENTITY_ID_CHOSAIN = new EucEntityId("DBE224002");
    private NinteiChosaFileOutputProcessParamter processParamter;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private static final RString underscore = new RString("_");
    private static final RString ZIP拡張子 = new RString(".zip");
    private final NinteiChosaDataOutputResult business = new NinteiChosaDataOutputResult();
    private final List<PersonalData> personalDataList = new ArrayList<>();

    @Override
    protected void beforeExecute() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Other);
        RStringBuilder EUCファイル名称 = new RStringBuilder();
        EUCファイル名称.append(DbBusinessConfig.get(ConfigNameDBE.認定調査結果入力用ZIPファイル名称, RDate.getNowDate(), processParamter.getShichosonCode()))
                .append(underscore).append(processParamter.getAddedFileName()).append(ZIP拡張子);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), EUCファイル名称.toRString());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toNinteiChosaFileOutputMybitisParameter());
    }

    @Override
    protected void process(NinteiChosaOutputPersonalDataEntity entity) {
        PersonalData personalData = business.getPersonalData(entity);
        personalDataList.add(personalData);
    }

    @Override
    protected void afterExecute() {
        List<RString> filePathes = new ArrayList<>();
        filePathes.add(Path.combinePath(processParamter.getTempFilePath(), EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, EUC_ENTITY_ID_DATA.toRString())));
        filePathes.add(Path.combinePath(processParamter.getTempFilePath(), EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, EUC_ENTITY_ID_TOKKI.toRString())));
        filePathes.add(Path.combinePath(processParamter.getTempFilePath(), EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, EUC_ENTITY_ID_GAIKYO.toRString())));
        filePathes.add(Path.combinePath(processParamter.getTempFilePath(), EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, EUC_ENTITY_ID_CHOSAIN.toRString())));
        ZipUtil.createFromFiles(eucFilePath, filePathes);
        AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
        manager.spool(eucFilePath, accessLogUUID);
    }

}
