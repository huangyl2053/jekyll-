/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsataishodataoutput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinsataishodataoutput.ShinsakaiFileOutputProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.api.EucOtherInfo;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.ZipUtil;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 *
 * @author n3509
 */
public class ShinsakaiFileOutputProcess extends SimpleBatchProcessBase {

    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBE518006");
    private static final EucEntityId EUC_ENTITY_ID_SHINSAKAIJOHO = new EucEntityId("DBE518001");
    private static final EucEntityId EUC_ENTITY_ID_IINJOHO = new EucEntityId("DBE518002");
    private static final EucEntityId EUC_ENTITY_ID_GAIKYO = new EucEntityId("DBE518003");
    private static final EucEntityId EUC_ENTITY_ID_KIHON = new EucEntityId("DBE518004");
    private static final EucEntityId EUC_ENTITY_ID_CODE = new EucEntityId("DBE518005");
    private ShinsakaiFileOutputProcessParameter processParamter;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private static final RString underscore = new RString("_");
    private static final RString ZIP拡張子 = new RString(".zip");

    @Override
    protected void beforeExecute() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Other);
        RStringBuilder EUCファイル名称 = new RStringBuilder();
        EUCファイル名称.append(DbBusinessConfig.get(ConfigNameDBE.介護認定審査会結果入力用ZIPファイル名称, RDate.getNowDate()))
                .append(underscore).append(processParamter.getKaisaiBangou()).append(ZIP拡張子);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), EUCファイル名称.toRString());
    }

    @Override
    protected void process() {
        List<RString> filePathes = new ArrayList<>();
        filePathes.add(Path.combinePath(processParamter.getTempPath(), EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, EUC_ENTITY_ID_SHINSAKAIJOHO.toRString())));
        filePathes.add(Path.combinePath(processParamter.getTempPath(), EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, EUC_ENTITY_ID_IINJOHO.toRString())));
        filePathes.add(Path.combinePath(processParamter.getTempPath(), EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, EUC_ENTITY_ID_GAIKYO.toRString())));
        filePathes.add(Path.combinePath(processParamter.getTempPath(), EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, EUC_ENTITY_ID_KIHON.toRString())));
        filePathes.add(Path.combinePath(processParamter.getTempPath(), EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, EUC_ENTITY_ID_CODE.toRString())));

        ZipUtil.createFromFiles(eucFilePath, filePathes);
    }

    @Override
    protected void afterExecute() {
        manager.spool(eucFilePath, processParamter.getAccessLogUUID());
    }
}
