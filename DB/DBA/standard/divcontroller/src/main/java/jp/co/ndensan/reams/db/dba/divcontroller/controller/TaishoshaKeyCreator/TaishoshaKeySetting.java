/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.TaishoshaKeyCreator;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.TaishoshaKeyCreator.TaishoshaKeySettingDiv;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.ResponseDatas;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStateKey;
import jp.co.ndensan.reams.db.dbz.model.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * テスト用の対象者Keyを作成するためのDivControllerです。<br/>
 * 検索画面から対象者を受け取る前提の親Divのテストを行う際に、遷移元の親画面として使用します。
 *
 * @author n8178 城間篤人
 */
public class TaishoshaKeySetting {

    public ResponseData<TaishoshaKeySettingDiv> onLoad(TaishoshaKeySettingDiv settingDiv) {

        settingDiv.getTxtSetai().setValue(new RString("123450000100001"));
        settingDiv.getTxtShikibetsu().setValue(new RString("000000000000318"));
        settingDiv.getTxtHihoNo().setValue(new RString("0000001112"));

        return ResponseDatas.createSettingDataTo(settingDiv);
    }

    public ResponseData<TaishoshaKeySettingDiv> onClick_btnNext(TaishoshaKeySettingDiv settingDiv) {

        SetaiCode setai = new SetaiCode(settingDiv.getTxtSetai().getValue());
        ShikibetsuCode shikibetsu = new ShikibetsuCode(settingDiv.getTxtShikibetsu().getValue());
        HihokenshaNo hihoNo = new HihokenshaNo(settingDiv.getTxtHihoNo().getValue());

        TaishoshaKey taishosha = new TaishoshaKey(hihoNo, shikibetsu, setai);
        ViewStateHolder.put(ViewStateKey.資格対象者, taishosha);

        return ResponseDatas.createSettingDataTo(settingDiv);
    }
}
