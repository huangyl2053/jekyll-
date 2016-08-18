/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD8010002;

import java.util.ArrayList;
import java.util.List;
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
        ViewStateHolder.put(ViewStateKeys.取込対象市町村コードリスト,
                取込対象市町村コードリスト == null ? null : new ArrayList<>(取込対象市町村コードリスト));

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
        ViewStateHolder.put(ViewStateKeys.取込対象市町村コードリスト,
                取込対象市町村コードリスト == null ? null : new ArrayList<>(取込対象市町村コードリスト));

        return ResponseData.of(div).respond();
    }

    private HikazeiNenkinTaishoshaJohoHandler getHandler(HikazeiNenkinTaishoshaJohoDiv div) {
        return new HikazeiNenkinTaishoshaJohoHandler(div);
    }

    private HikazeiNenkinTaishoshaJohoValidationHandler getValidationHandler(HikazeiNenkinTaishoshaJohoDiv div) {
        return new HikazeiNenkinTaishoshaJohoValidationHandler(div);
    }
}
