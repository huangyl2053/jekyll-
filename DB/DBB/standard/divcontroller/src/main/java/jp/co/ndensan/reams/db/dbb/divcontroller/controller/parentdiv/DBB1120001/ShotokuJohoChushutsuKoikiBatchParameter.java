/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB1120001;

import java.io.File;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.shichosonkado.ShichosonJohoResult;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB112002.DBB112002_ToushoShotokuJohoChushutsuRenkeiKoikiParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB112004.DBB112004_ShotokuJohoChushutsuRenkeiKoikiParameter;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120001.ShotokuJohoChushutsuKoikiBatchParameterDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120001.dgShichosonIchiran_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1120001.ShotokuJohoChushutsuKoikiBatchParameterHandler;
import jp.co.ndensan.reams.db.dbb.service.core.shotokujohotyushuturenkeikoiki.ShotokuJohoChushutsuRenkeiKoiki;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 所得情報抽出・連携（広域用）のクラスです。
 *
 * @reamsid_L DBB-1690-010 sunhui
 */
public class ShotokuJohoChushutsuKoikiBatchParameter {

    private static final RString 遷移区分_0 = new RString("0");
    private static final RString 遷移区分_1 = new RString("1");
    private static final ReportId 帳票ID = new ReportId("DBB200008_KaigoHokenShotokuJohoIchiran");
    private static final RString 所得情報抽出_連携当初 = new RString("DBBMN51006");
    private static final RString 所得情報抽出_連携異動 = new RString("DBBMN51008");
    private static final RString DEC05F001 = new RString("DEC05F001");
    private static final RString DEE01F001 = new RString("DEE01F001");
    private static final RString DEC05F001またはDEE01F001 = new RString("DEC05F001またはDEE01F001");
    private static final RString COMMON_BUTTON_FIELD_NAME = new RString("btnBatchRegisterKoiki");
    private static final RString COMMON_BUTTON_FIELD_NAME_当初 = new RString("btnBatchRegisterDousyo");
    private static final RString 事務広域 = new RString("111");
    private static final RString 広域保険者でないため = new RString("広域保険者でないため");
    private static final RString 当初所得引出 = new RString("当初所得引出");
    private static final RString 所得引出 = new RString("所得引出");

    /**
     * 画面初期化のonLoadメソッドです。
     *
     * @param div ShotokuJohoChushutsuKoikiBatchParameterDiv
     * @return ResponseData<ShotokuJohoChushutsuKoikiBatchParameterDiv>
     */
    public ResponseData<ShotokuJohoChushutsuKoikiBatchParameterDiv> onLoad(ShotokuJohoChushutsuKoikiBatchParameterDiv div) {
        RString 遷移区分 = null;
        RString 年度 = null;
        RDate currentTime = RDate.getNowDate();
        RString メニューID = ResponseHolder.getMenuID();
        if (ResponseHolder.isReRequest()
                && (new RString(DbzErrorMessages.使用不可
                        .getMessage().getCode()).equals(ResponseHolder.getMessageCode())
                || new RString(DbbErrorMessages.処理不可_関連機能未処理済
                        .getMessage().getCode()).equals(ResponseHolder.getMessageCode()))) {
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMON_BUTTON_FIELD_NAME_当初, true);
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMON_BUTTON_FIELD_NAME, true);
            return createResponse(div);
        }
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報 != null && 市町村セキュリティ情報.get導入形態コード() != null) {
            RString 市町村形態コード = new RString(市町村セキュリティ情報.get導入形態コード().value().toString());
            if (!事務広域.equals(市町村形態コード)) {
                return ResponseData.of(div).addMessage(DbzErrorMessages.使用不可.getMessage()
                        .replace(広域保険者でないため.toString())).respond();
            }
        }
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, currentTime, SubGyomuCode.DBB介護賦課);
        RString 所得年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_所得年度, currentTime, SubGyomuCode.DBB介護賦課);
        if (所得情報抽出_連携異動.equals(メニューID) && !調定年度.equals(所得年度)) {
            return ResponseData.of(div).addMessage(DbbErrorMessages.処理不可_関連機能未処理済.getMessage()
                    .replace(当初所得引出.toString(), 所得引出.toString())).respond();
        }
        if (所得情報抽出_連携当初.equals(メニューID)) {
            遷移区分 = 遷移区分_0;
            年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, currentTime,
                    SubGyomuCode.DBB介護賦課);
            div.getShotokuJohoChushutsuKoikiPanel().getTxtShoriNendoKoiki().setValue(new RDate(年度.toString()));
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMON_BUTTON_FIELD_NAME, true);
        } else if (所得情報抽出_連携異動.equals(メニューID)) {
            遷移区分 = 遷移区分_1;
            年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_所得年度, currentTime,
                    SubGyomuCode.DBB介護賦課);
            div.getShotokuJohoChushutsuKoikiPanel().getTxtShoriNendoKoiki().setValue(new RDate(年度.toString()));
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(COMMON_BUTTON_FIELD_NAME_当初, true);
        }
        ShotokuJohoChushutsuKoikiBatchParameterHandler handler = getHandler(div);
        SearchResult<KoikiZenShichosonJoho> koikiZenShichosonJohoList = handler.shichosonIchiran(currentTime);
        if (年度 != null) {
            List<ShichosonJohoResult> shichosonJohoList = ShotokuJohoChushutsuRenkeiKoiki.createInstance()
                    .getShichosonJoho(koikiZenShichosonJohoList.records(), 遷移区分, new FlexibleYear(年度));
            if (shichosonJohoList != null) {
                handler.check処理区分(shichosonJohoList);
            }
        }
        div.getShotokuJohoChushutsuKoikiPanel().getTxtShoriNendoKoiki().setDisabled(true);
        div.getShotokuJohoChushutsuKoikiPanel().getCcdChohyoShutsuryokujunKoiki().load(SubGyomuCode.DBB介護賦課, 帳票ID);
        return createResponse(div);
    }

    /**
     * 「実行する」を押下場合、バリデーションメソッドです。
     *
     * @param div ShotokuJohoChushutsuKoikiBatchParameterDiv
     * @return ResponseData
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<ShotokuJohoChushutsuKoikiBatchParameterDiv> onclick_checkRegister(
            ShotokuJohoChushutsuKoikiBatchParameterDiv div) {
        List<UzT0885SharedFileEntryEntity> 国保List = SharedFile.searchSharedFile(DEC05F001);
        List<UzT0885SharedFileEntryEntity> 国保情報List = SharedFile.searchSharedFile(DEE01F001);
        for (UzT0885SharedFileEntryEntity entity : 国保List) {
            国保情報List.add(entity);
        }
        for (UzT0885SharedFileEntryEntity entity : 国保情報List) {
            ReadOnlySharedFileEntryDescriptor descriptor
                    = ReadOnlySharedFileEntryDescriptor.fromEntity(entity);
            RString path = SharedFile.getDirectAccessPath(descriptor);
            FilesystemPath filesystemPath = SharedFile.copyToLocal(descriptor, FilesystemPath.fromString(path));
            File file = new File(filesystemPath.toString());
            int count = 1;
            File[] files = file.listFiles();
            for (File file1 : files) {
                if (file1.getName().startsWith(DEE01F001.toString()) || file1.getName().startsWith(DEC05F001.toString())) {
                    count++;
                }
            }
            if (count <= 1) {
                throw new ApplicationException(DbzErrorMessages.アップロードファイルが不正.getMessage()
                        .replace(DEC05F001またはDEE01F001.toString()).evaluate());
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」を押下場合、DBB112002 バッチを起動します。
     *
     * @param div ShotokuJohoChushutsuKoikiBatchParameterDiv
     * @return ResponseData<DBB112002_ToushoShotokuJohoChushutsuRenkeiKoikiParameter>
     */
    public ResponseData<DBB112002_ToushoShotokuJohoChushutsuRenkeiKoikiParameter> onclick_batchRegister_DBB112002(
            ShotokuJohoChushutsuKoikiBatchParameterDiv div) {
        DBB112002_ToushoShotokuJohoChushutsuRenkeiKoikiParameter parameter = getHandler(div).getBatchParamter_DBB112002();
        return ResponseData.of(parameter).respond();
    }

    /**
     * 「実行する」を押下場合、DBB112004 バッチを起動します。
     *
     * @param div 異動チェックリストDIV
     * @return ResponseData<DBB112004_ShotokuJohoChushutsuRenkeiKoikiParameter>
     */
    public ResponseData<DBB112004_ShotokuJohoChushutsuRenkeiKoikiParameter> onclick_batchRegister_DBB112004(
            ShotokuJohoChushutsuKoikiBatchParameterDiv div) {
        DBB112004_ShotokuJohoChushutsuRenkeiKoikiParameter parameter = getHandler(div).getBatchParamter_DBB112004();
        return ResponseData.of(parameter).respond();
    }

    /**
     * 「実行する」を押下場合、バリデーションメソッドです。
     *
     * @param div ShotokuJohoChushutsuKoikiBatchParameterDiv
     * @return ResponseData
     */
    public ResponseData<ShotokuJohoChushutsuKoikiBatchParameterDiv> onClick_onSelect(
            ShotokuJohoChushutsuKoikiBatchParameterDiv div) {
        DataGrid<dgShichosonIchiran_Row> grid = div.getDgShichosonIchiran();
        if (grid.getSelectedItems().isEmpty()) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_FIELD_NAME, true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_FIELD_NAME_当初, true);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_FIELD_NAME, false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(COMMON_BUTTON_FIELD_NAME_当初, false);
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<ShotokuJohoChushutsuKoikiBatchParameterDiv> createResponse(
            ShotokuJohoChushutsuKoikiBatchParameterDiv div) {
        return ResponseData.of(div).respond();
    }

    private ShotokuJohoChushutsuKoikiBatchParameterHandler getHandler(ShotokuJohoChushutsuKoikiBatchParameterDiv div) {
        return ShotokuJohoChushutsuKoikiBatchParameterHandler.of(div);
    }

}
