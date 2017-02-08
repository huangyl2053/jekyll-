/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosadataoutput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosadataoutput.NinteiChosaFileOutputProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.api.EucOtherInfo;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.ZipUtil;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 *
 * @author n3509
 */
public class NinteiChosaFileOutputProcess extends SimpleBatchProcessBase {

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
    private static final RString csv拡張子 = new RString(".csv");

    @Override
    protected void beforeExecute() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Other);
        RStringBuilder EUCファイル名称 = new RStringBuilder();
        EUCファイル名称.append(EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, EUC_ENTITY_ID.toRString()))
                .append(underscore).append(processParamter.getAddedFileName()).append(ZIP拡張子);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), EUCファイル名称.toRString());
    }

    @Override
    protected void process() {
        List<RString> filePathes = new ArrayList<>();
        filePathes.add(Path.combinePath(processParamter.getTempFilePath(), EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, EUC_ENTITY_ID_DATA.toRString()).concat(csv拡張子)));
        filePathes.add(Path.combinePath(processParamter.getTempFilePath(), EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, EUC_ENTITY_ID_TOKKI.toRString()).concat(csv拡張子)));
        filePathes.add(Path.combinePath(processParamter.getTempFilePath(), EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, EUC_ENTITY_ID_GAIKYO.toRString()).concat(csv拡張子)));
        filePathes.add(Path.combinePath(processParamter.getTempFilePath(), EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, EUC_ENTITY_ID_CHOSAIN.toRString()).concat(csv拡張子)));

        ZipUtil.createFromFiles(eucFilePath, filePathes);
    }

    @Override
    protected void afterExecute() {
        manager.spool(eucFilePath);
    }

}
