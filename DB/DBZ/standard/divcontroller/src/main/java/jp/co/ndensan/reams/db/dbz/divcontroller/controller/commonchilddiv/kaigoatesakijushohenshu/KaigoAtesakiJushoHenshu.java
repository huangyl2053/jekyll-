/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.kaigoatesakijushohenshu;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatesakijushohenshu.KaigoAtesakiJushoHenshu.KaigoAtesakiJushoHenshuDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatesakijushohenshu.KaigoAtesakiJushoHenshu.KaigoAtesakiJushoHenshuHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 介護住所編集方法ダイアログのDivControllerです。
 *
 * @reamsid_L DBA-1201-050 yaodongsheng
 */
public class KaigoAtesakiJushoHenshu {

    /**
     * onLoad時の処理です。
     *
     * @param div {@link KaigoAtesakiJushoHenshuDiv  介護住所編集方法ダイアログDiv}
     * @return 介護住所編集方法ダイアログDivを持つResponseData
     */
    public ResponseData<KaigoAtesakiJushoHenshuDiv> onLoad(KaigoAtesakiJushoHenshuDiv div) {
        getHandler(div).initlize();
        return ResponseData.of(div).respond();
    }

    /**
     * 住所編集方法onChangeの処理です。
     *
     * @param div {@link KaigoAtesakiJushoHenshuDiv  介護住所編集方法ダイアログDiv}
     * @return 介護住所編集方法ダイアログDivを持つResponseData
     */
    public ResponseData<KaigoAtesakiJushoHenshuDiv> onChange_jusho(KaigoAtesakiJushoHenshuDiv div) {
        if (!div.getHdnGunMei().equals(div.getRadGunmeiHyojiUmu().getSelectedKey())
                || !div.getHdnShichosonMei().equals(div.getRadCitymeiHyojiUmu().getSelectedKey())
                || !div.getHdnKatagaki().equals(div.getRadKatagakiHyojiUmu().getSelectedKey())
                || !div.getHdnTodofukenMei().equals(div.getRadKenmeiHyojiUmu().getSelectedKey())
                || !div.getHdnHensyuHoho().equals(div.getDdlChoikiHenshu().getSelectedKey())) {
            div.getBtnKakutei().setDisabled(false);
        } else if (div.getHdnGunMei().equals(div.getRadGunmeiHyojiUmu().getSelectedKey())
                && div.getHdnShichosonMei().equals(div.getRadCitymeiHyojiUmu().getSelectedKey())
                && div.getHdnKatagaki().equals(div.getRadKatagakiHyojiUmu().getSelectedKey())
                && div.getHdnTodofukenMei().equals(div.getRadKenmeiHyojiUmu().getSelectedKey())
                && div.getHdnHensyuHoho().equals(div.getDdlChoikiHenshu().getSelectedKey())) {
            div.getBtnKakutei().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 確定btnの処理です。
     *
     * @param div {@link KaigoAtesakiJushoHenshuDiv  介護住所編集方法ダイアログDiv}
     * @return 介護住所編集方法ダイアログDivを持つResponseData
     */
    public ResponseData<KaigoAtesakiJushoHenshuDiv> onClick_kakunin(KaigoAtesakiJushoHenshuDiv div) {
        div.setHdnTodofukenMei(div.getRadKenmeiHyojiUmu().getSelectedKey());
        div.setHdnGunMei(div.getRadGunmeiHyojiUmu().getSelectedKey());
        div.setHdnShichosonMei(div.getRadCitymeiHyojiUmu().getSelectedKey());
        div.setHdnHensyuHoho(div.getDdlChoikiHenshu().getSelectedKey());
        div.setHdnKatagaki(div.getRadKatagakiHyojiUmu().getSelectedKey());
        return ResponseData.of(div).respond();
    }

    private KaigoAtesakiJushoHenshuHandler getHandler(KaigoAtesakiJushoHenshuDiv div) {
        return new KaigoAtesakiJushoHenshuHandler(div);
    }

}
