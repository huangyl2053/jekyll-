/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB1120001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.shotokujohotyushuturenkeikoiki.ShotokuJohoTyushutuRenkeiKoikiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.shichosonkado.ShichosonJohoResult;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120001.ShotokuJohoChushutsuKoikiBatchParameterDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1120001.ShotokuJohoChushutsuKoikiBatchParameterHandler;
import jp.co.ndensan.reams.db.dbb.service.core.shotokujohotyushuturenkeikoiki.ShotokuJohoChushutsuRenkeiKoiki;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.basic.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
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
    private static final RString FORMAT_平 = new RString("平%s");

    /**
     * 画面初期化のonLoadメソッドです。
     *
     * @param div ShotokuJohoChushutsuKoikiBatchParameterDiv
     * @return ResponseData<ShotokuJohoChushutsuKoikiBatchParameterDiv>
     */
    public ResponseData<ShotokuJohoChushutsuKoikiBatchParameterDiv> onLoad(ShotokuJohoChushutsuKoikiBatchParameterDiv div) {
        RString 遷移区分 = null;
        FlexibleYear 年度 = null;
        RDate currentTime = RDate.getNowDate();
        RString メニューID = ResponseHolder.getMenuID();
        if (所得情報抽出_連携当初.equals(メニューID)) {
            遷移区分 = 遷移区分_0;
            年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, currentTime,
                    SubGyomuCode.DBB介護賦課));
            RDate 処理年度 = new RDate(String.format(FORMAT_平.toString(), 年度.toString()));
            div.getShotokuJohoChushutsuKoikiPanel().getTxtShoriNendoKoiki().setValue(処理年度);
        } else if (所得情報抽出_連携異動.equals(メニューID)) {
            遷移区分 = 遷移区分_1;
            年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_所得年度, currentTime,
                    SubGyomuCode.DBB介護賦課));
            RDate 処理年度 = new RDate(String.format(FORMAT_平.toString(), 年度.toString()));
            div.getShotokuJohoChushutsuKoikiPanel().getTxtShoriNendoKoiki().setValue(処理年度);
        }
        SearchResult<KoikiZenShichosonJoho> koikiZenShichosonJohoList = KoikiShichosonJohoFinder
                .createInstance().getGenShichosonJoho();
        List<ShichosonJohoResult> shichosonJohoList = ShotokuJohoChushutsuRenkeiKoiki.createInstance()
                .getShichosonJoho(koikiZenShichosonJohoList.records(), 遷移区分, 年度);
        ShotokuJohoChushutsuKoikiBatchParameterHandler handler = getHandler(div);
        handler.initCheck(currentTime);
        handler.shichosonIchiran(currentTime, shichosonJohoList);
        div.getShotokuJohoChushutsuKoikiPanel().getTxtShoriNendoKoiki().setDisabled(true);
        div.getShotokuJohoChushutsuKoikiPanel().getCcdChohyoShutsuryokujunKoiki().load(SubGyomuCode.DBB介護賦課, 帳票ID);
        return createResponse(div);
    }

    /**
     * 「実行する」を押下場合、バリデーションメソッドです。
     *
     * @param div ShotokuJohoChushutsuKoikiBatchParameterDiv
     * @param files FileData
     * @return ResponseData
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ResponseData<ShotokuJohoChushutsuKoikiBatchParameterDiv> onclick_checkRegister(
            ShotokuJohoChushutsuKoikiBatchParameterDiv div, FileData[] files) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(getValidationHandler(div).checkFilesStates(files));
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」を押下場合、バッチを起動します。
     *
     * @param div 異動チェックリストDIV
     * @return ResponseData<ShotokuJohoTyushutuRenkeiKoikiParameter>
     */
    public ResponseData<ShotokuJohoTyushutuRenkeiKoikiParameter> onclick_batchRegister(
            ShotokuJohoChushutsuKoikiBatchParameterDiv div) {
        ShotokuJohoChushutsuKoikiBatchParameterHandler handler = getHandler(div);
        ShotokuJohoTyushutuRenkeiKoikiParameter parameter = handler.getBatchParamter();
        return ResponseData.of(parameter).respond();
    }

    private ResponseData<ShotokuJohoChushutsuKoikiBatchParameterDiv> createResponse(
            ShotokuJohoChushutsuKoikiBatchParameterDiv div) {
        return ResponseData.of(div).respond();
    }

    private ShotokuJohoChushutsuKoikiBatchParameterHandler getHandler(ShotokuJohoChushutsuKoikiBatchParameterDiv div) {
        return ShotokuJohoChushutsuKoikiBatchParameterHandler.of(div);
    }

    private ShotokuJohoChushutsuKoikiBatchParameterHandler getValidationHandler(
            ShotokuJohoChushutsuKoikiBatchParameterDiv div) {
        return new ShotokuJohoChushutsuKoikiBatchParameterHandler(div);
    }
}
