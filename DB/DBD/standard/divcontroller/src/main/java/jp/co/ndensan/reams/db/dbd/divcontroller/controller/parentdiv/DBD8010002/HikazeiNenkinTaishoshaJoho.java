/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD8010002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd8100201.HikazeiNennkinTaishouSyaJohoTorikomiBatchParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd8100203.SokyuHikazeiNenkinBatchParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002.DBD8010002StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010002.HikazeiNenkinTaishoshaJohoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD8010002.HikazeiNenkinTaishoshaJohoHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD8010002.HikazeiNenkinTaishoshaJohoValidationHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 非課税年金対象者情報取込画面のDivControllerです。
 *
 * @reamsid_L DBD-4910-010 huangh
 */
public class HikazeiNenkinTaishoshaJoho {

    private static final RString DBDMN81002 = new RString("DBDMN81002");

    /**
     * 画面初期化処理です。
     *
     * @param div JissiJyokyohyoDiv
     * @return ResponseData<JissiJyokyohyoDiv>
     */
    public ResponseData<HikazeiNenkinTaishoshaJohoDiv> onLoad(HikazeiNenkinTaishoshaJohoDiv div) {
        List<RString> 取込対象市町村コードリスト = getHandler(div).onLoad(div);
        ViewStateHolder.put(ViewStateKeys.取込対象市町村コードリスト, new ArrayList<>(取込対象市町村コードリスト));

        if (DBD8010002StateName.非課税年金対象者情報_単一用.getName().equals(div.getHdnState())) {
            return ResponseData.of(div).setState(DBD8010002StateName.非課税年金対象者情報_単一用);
        } else if (DBD8010002StateName.非課税年金対象者情報_広域用.getName().equals(div.getHdnState())) {
            return ResponseData.of(div).setState(DBD8010002StateName.非課税年金対象者情報_広域用);
        } else if (DBD8010002StateName.遡及非課税年金対象者同定.getName().equals(div.getHdnState())) {
            return ResponseData.of(div).setState(DBD8010002StateName.遡及非課税年金対象者同定);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 年度DDLの選択処理です。
     *
     * @param div JissiJyokyohyoDiv
     * @return ResponseData<JissiJyokyohyoDiv>
     */
    public ResponseData<HikazeiNenkinTaishoshaJohoDiv> onChange_ddlShoriNendo(HikazeiNenkinTaishoshaJohoDiv div) {
        List<RString> 取込対象市町村コードリスト = getHandler(div).onChange_ddlShoriNendo(div);
        ViewStateHolder.put(ViewStateKeys.取込対象市町村コードリスト, new ArrayList<>(取込対象市町村コードリスト));

        return ResponseData.of(div).respond();
    }

    /**
     * 月DDLの選択処理です。
     *
     * @param div JissiJyokyohyoDiv
     * @return ResponseData<JissiJyokyohyoDiv>
     */
    public ResponseData<HikazeiNenkinTaishoshaJohoDiv> onChange_ddlTuki(HikazeiNenkinTaishoshaJohoDiv div) {
        List<RString> 取込対象市町村コードリスト = getHandler(div).onChange_ddlTuki(div);
        ViewStateHolder.put(ViewStateKeys.取込対象市町村コードリスト, new ArrayList<>(取込対象市町村コードリスト));

        return ResponseData.of(div).respond();
    }

    /**
     * 処理設定のクリンク処理です。
     *
     * @param div JissiJyokyohyoDiv
     * @return ResponseData<JissiJyokyohyoDiv>
     */
    public ResponseData<HikazeiNenkinTaishoshaJohoDiv> onClick_btnShoriSettei(HikazeiNenkinTaishoshaJohoDiv div) {

        getHandler(div).onClick_btnShoriSettei(div);

        return ResponseData.of(div).setState(DBD8010002StateName.処理設定);
    }

    /**
     * 処理設定のクリンク処理です。
     *
     * @param div JissiJyokyohyoDiv
     * @return ResponseData<JissiJyokyohyoDiv>
     */
    public ResponseData<HikazeiNenkinTaishoshaJohoDiv> onClick_btnBatchRegister(HikazeiNenkinTaishoshaJohoDiv div) {

//        if (DBDMN81002.equals(ResponseHolder.getMenuID())) {
//            //TODO check
//        } else {
//        }
        getHandler(div).onClick_btnBatchRegister(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 処理設定のクリンク処理です。
     *
     * @param div JissiJyokyohyoDiv
     * @return HikazeiNennkinTaishouSyaJohoTorikomiBatchParameter
     */
    public ResponseData<HikazeiNennkinTaishouSyaJohoTorikomiBatchParameter> createDBD301010BatchParamter(HikazeiNenkinTaishoshaJohoDiv div) {

        List<RString> 構成市町村コードリスト = ViewStateHolder.
                get(ViewStateKeys.取込対象市町村コードリスト, new ArrayList<>().getClass());

        return ResponseData.of(getHandler(div).createDBD301010BatchParamter(div, 構成市町村コードリスト)).respond();
    }

    /**
     * 処理設定のクリンク処理です。
     *
     * @param div JissiJyokyohyoDiv
     * @return SokyuHikazeiNenkinBatchParameter
     */
    public ResponseData<SokyuHikazeiNenkinBatchParameter> createDBD301020BatchParamter(HikazeiNenkinTaishoshaJohoDiv div) {

        return ResponseData.of(getHandler(div).createDBD301020BatchParamter(div)).respond();
    }

    private HikazeiNenkinTaishoshaJohoHandler getHandler(HikazeiNenkinTaishoshaJohoDiv div) {
        return new HikazeiNenkinTaishoshaJohoHandler(div);
    }

    private HikazeiNenkinTaishoshaJohoValidationHandler getValidationHandler(HikazeiNenkinTaishoshaJohoDiv div) {
        return new HikazeiNenkinTaishoshaJohoValidationHandler(div);
    }
}
