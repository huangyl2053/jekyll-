/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0230011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.kaigojuminhyokobetsukoikiunyo.KaigoJuminhyoKobetsuKoikiunyo;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU070020.DBU070020_KobetsujikoRenkei_KoikiParameter;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.kobetsujikorenkeiinfosakuseikoiki.KaigoJuminhyoKobetsuParameter;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.kobetsujikorenkeiinfosakuseikoiki.KobetsuKoikiunyoParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0230011.KobetsuJikoRenkeiInfoSakuseiKoikiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0230011.dgKobetsuJikoRenkeiInfoSakuseiKoik_Row;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0230011.KaigoJyuminhyouHandler;
import jp.co.ndensan.reams.db.dbu.service.core.kaigojuminhyobatchparameter.KaigoJuminhyoKobetsuKoikiunyoBatchParameterSakuseiFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 介護住民票個別事項連携情報作成【広域運用】画面Divを制御します。
 *
 * @reamsid_L DBU-0550-010 zhangzhiming
 */
public class KobetsuJikoRenkeiInfoSakuseiKoiki {

    private static final int 連番 = 6;

    /**
     * 画面初期化表示する。
     *
     * @param div div
     * @return ResponseData<KobetsuJikoRenkeiInfoSakuseiKoikiDiv>
     */
    public ResponseData onLoad(KobetsuJikoRenkeiInfoSakuseiKoikiDiv div) {
        KaigoJuminhyoKobetsuKoikiunyoBatchParameterSakuseiFinder finder = KaigoJuminhyoKobetsuKoikiunyoBatchParameterSakuseiFinder.createInstance();
        List<KaigoJuminhyoKobetsuKoikiunyo> businessList = finder.getKoikiunyoChushutsukikanJohoList().records();
        getHandler(div).load(businessList);
        return ResponseData.of(div).respond();
    }

    /**
     * 修正ボタン。<br/>
     *
     * @param div div
     * @return ResponseData<KobetsuJikoRenkeiInfoSakuseiKoikiDiv>
     */
    public ResponseData<KobetsuJikoRenkeiInfoSakuseiKoikiDiv> onClick_ModifyButton(KobetsuJikoRenkeiInfoSakuseiKoikiDiv div) {
        getHandler(div).onClick_ModifyButton();
        return ResponseData.of(div).respond();
    }

    /**
     * 確定ボタン。<br/>
     *
     * @param div div
     * @return ResponseData<KobetsuJikoRenkeiInfoSakuseiKoikiDiv>
     */
    public ResponseData<KobetsuJikoRenkeiInfoSakuseiKoikiDiv> onClick_KakuButton(KobetsuJikoRenkeiInfoSakuseiKoikiDiv div) {
        ValidationMessageControlPairs validationMessageControlPairs = getHandler(div).validateCheck();
        if (validationMessageControlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validationMessageControlPairs).respond();
        }
        getHandler(div).onClick_KakuButton();
        return ResponseData.of(div).respond();
    }

    /**
     * 閉じるボタン。<br/>
     *
     * @param div div
     * @return ResponseData<KobetsuJikoRenkeiInfoSakuseiKoikiDiv>
     */
    public ResponseData<KobetsuJikoRenkeiInfoSakuseiKoikiDiv> onClick_CloseButton(KobetsuJikoRenkeiInfoSakuseiKoikiDiv div) {
        getHandler(div).onClick_CloseButton();
        return ResponseData.of(div).respond();
    }

    /**
     * 「全件作成する」を押下する。<br/>
     *
     * @param div div
     * @return ResponseData<KobetsuJikoRenkeiInfoSakuseiKoikiDiv>
     */
    public ResponseData<KobetsuJikoRenkeiInfoSakuseiKoikiDiv> onClick_ChkZenken(KobetsuJikoRenkeiInfoSakuseiKoikiDiv div) {
        getHandler(div).onClick_ChkZenken();
        return ResponseData.of(div).respond();
    }

    /**
     * 実行対象選択の有無をチェックする。<br/>
     *
     * @param div div
     * @return ResponseData<KobetsuJikoRenkeiInfoSakuseiKoikiDiv>
     */
    public ResponseData<KobetsuJikoRenkeiInfoSakuseiKoikiDiv> onClick_Check(KobetsuJikoRenkeiInfoSakuseiKoikiDiv div) {
        int i = 0;
        for (dgKobetsuJikoRenkeiInfoSakuseiKoik_Row row : div.getDgKobetsuJikoRenkeiInfoSakuseiKoik().getDataSource()) {
            if (row.getSelected()) {
                i = i + 1;
            }
        }
        if (i == 0) {
            throw new ApplicationException(UrErrorMessages.選択されていない.getMessage().replace("実行対象").evaluate());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 一覧表を発行するボタンが押下され、バッチパラメータを作成します。<br/>
     *
     * @param div div
     * @return ResponseData<KobetsuKoikiunyoBatchParameter>
     */
    public ResponseData<DBU070020_KobetsujikoRenkei_KoikiParameter> onClick_JikkouButton(KobetsuJikoRenkeiInfoSakuseiKoikiDiv div) {
        KaigoJuminhyoKobetsuKoikiunyoBatchParameterSakuseiFinder finder = KaigoJuminhyoKobetsuKoikiunyoBatchParameterSakuseiFinder
                .createInstance();
        List<KaigoJuminhyoKobetsuParameter> kobetsuLsit = new ArrayList<>();
        for (dgKobetsuJikoRenkeiInfoSakuseiKoik_Row row : div.getDgKobetsuJikoRenkeiInfoSakuseiKoik().getDataSource()) {
            if (row.getSelected()) {
                KaigoJuminhyoKobetsuParameter kobetsu = new KaigoJuminhyoKobetsuParameter();
                kobetsu.setKonkaiStSakuseiTime(row.getTxtKonkaiStSakuseiTime().getValue());
                kobetsu.setKonkaiStSakuseiYMD(row.getTxtKonkaiStSakuseiYMD().getValue());
                kobetsu.setSakiShichoson(row.getTxtSakiShichoson().getValue().substring(0, 連番));
                kobetsuLsit.add(kobetsu);
            }
        }
        List<KobetsuKoikiunyoParameter> businessList = finder.getKaigoJuminhyoKobetsuKoikiunyoBatchParameter(kobetsuLsit).records();
        DBU070020_KobetsujikoRenkei_KoikiParameter parameter = new DBU070020_KobetsujikoRenkei_KoikiParameter(businessList);
        return ResponseData.of(parameter).respond();
    }

    private KaigoJyuminhyouHandler getHandler(KobetsuJikoRenkeiInfoSakuseiKoikiDiv div) {
        return new KaigoJyuminhyouHandler(div);
    }
}
