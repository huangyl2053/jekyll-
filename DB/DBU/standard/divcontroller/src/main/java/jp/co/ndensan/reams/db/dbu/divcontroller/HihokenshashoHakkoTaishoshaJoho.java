/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011.SearchHihokenshashoHakkoDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011.HihokenshashoHakkoTaishoshaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証発行対象者情報Divを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class HihokenshashoHakkoTaishoshaJoho {

    /**
     * 被保険者証発行該当者一覧画面-「選択」ボタン押下時の処理を表します。
     *
     * @param panel HihokenshashoHakkoTaishoshaJohoDiv
     * @param panel2 HihokenshashoHakkoTaishoGaitoshaDiv
     * @return ResponseData
     */
    public ResponseData<HihokenshashoHakkoTaishoshaJohoDiv> dispTaishoshaJoho(
            HihokenshashoHakkoTaishoshaJohoDiv panel, SearchHihokenshashoHakkoDiv panel2) {
        ResponseData<HihokenshashoHakkoTaishoshaJohoDiv> response = new ResponseData<>();

        List<HashMap> hihokenshashoHakkoTaishoshaJohoList = YamlLoader.DBU.loadAsList(
                new RString("dbu0410011/HihokenshashoHakkoTaishoshaJoho.yml"));

        HashMap hashMap = hihokenshashoHakkoTaishoshaJohoList.get(
                panel2.getCcdHihokenshashoHakkoTaishoGaitosha().getDgSearchResult().getClickedRowId());

        ControlGenerator ymlData = new ControlGenerator(hashMap);

        //対象者情報の出力
        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTxtAtenaMeisho().
                setValue(panel2.getCcdHihokenshashoHakkoTaishoGaitosha().getDgSearchResult().getClickedItem().getShimei());

        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTxtAtenaKanaMeisho().
                setValue(panel2.getCcdHihokenshashoHakkoTaishoGaitosha().getDgSearchResult().getClickedItem().getKanaShimsei());

        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTxtJusho().
                setValue(panel2.getCcdHihokenshashoHakkoTaishoGaitosha().getDgSearchResult().getClickedItem().getJusho());

        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTxtSeinengappiYMD().
                setValue(panel2.getCcdHihokenshashoHakkoTaishoGaitosha().getDgSearchResult().
                        getClickedItem().getBirthDay().getValue());

        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTxtNenrei().
                setValue(ymlData.getAsRString("nenrei"));

        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTxtSeibetsu().
                setValue(panel2.getCcdHihokenshashoHakkoTaishoGaitosha().getDgSearchResult().
                        getClickedItem().getGender());

        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTxtGyoseiku().
                setValue(ymlData.getAsRString("gyoseiku"));

        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTxtYubinNo().
                setValue(new YubinNo(panel2.getCcdHihokenshashoHakkoTaishoGaitosha().getDgSearchResult().
                                getClickedItem().getYubinNo()));

        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTxtNihonjinGaikokujin().
                setValue(ymlData.getAsRString("nihonjingaikokujin"));

        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTxtJuminJotai().
                setValue(ymlData.getAsRString("juminjotai"));

        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTxtShikibetsuCode().
                setValue(panel2.getCcdHihokenshashoHakkoTaishoGaitosha().getDgSearchResult().
                        getClickedItem().getShikibetsuCode());

        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTxtKojinHojinCode().
                setValue(panel2.getCcdHihokenshashoHakkoTaishoGaitosha().getDgSearchResult().
                        getClickedItem().getKojinNo());

        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTxtSetaiCode().
                setValue(panel2.getCcdHihokenshashoHakkoTaishoGaitosha().getDgSearchResult().
                        getClickedItem().getSetaiCode());

        //介護資格基本情報
        panel.getCcdKaigoShikakuKihon().getTxtHihokenshaNo().
                setValue(panel2.getCcdHihokenshashoHakkoTaishoGaitosha().getDgSearchResult().
                        getClickedItem().getHihokenshaNo());

        if (ymlData.getAsRString("shutokuymd").toString().isEmpty()) {
            panel.getCcdKaigoShikakuKihon().getTxtShutokuYmd().clearValue();
        } else {
            panel.getCcdKaigoShikakuKihon().getTxtShutokuYmd().
                    setValue(ymlData.getAsRDate("shutokuymd"));
        }

        if (ymlData.getAsRString("shutokujiyu").toString().isEmpty()) {
            panel.getCcdKaigoShikakuKihon().getTxtShutokuJiyu().clearValue();
        } else {
            panel.getCcdKaigoShikakuKihon().getTxtShutokuJiyu().
                    setValue(ymlData.getAsRString("shutokujiyu"));
        }

        if (ymlData.getAsRString("shikakuJotai").toString().isEmpty()) {
            panel.getCcdKaigoShikakuKihon().getTxtShikakuJotai().clearValue();
        } else {
            panel.getCcdKaigoShikakuKihon().getTxtShikakuJotai().
                    setValue(ymlData.getAsRString("shikakuJotai"));
        }

        if (ymlData.getAsRString("soshitsuymd").toString().isEmpty()) {
            panel.getCcdKaigoShikakuKihon().getTxtSoshitsuYmd().clearValue();
        } else {
            panel.getCcdKaigoShikakuKihon().getTxtSoshitsuYmd().
                    setValue(ymlData.getAsRDate("soshitsuymd"));
        }

        if (ymlData.getAsRString("soshitsujiyu").toString().isEmpty()) {
            panel.getCcdKaigoShikakuKihon().getTxtSoshitsuJiyu().clearValue();
        } else {
            panel.getCcdKaigoShikakuKihon().getTxtSoshitsuJiyu().
                    setValue(ymlData.getAsRString("soshitsujiyu"));
        }

        if (ymlData.getAsRString("jutokukaijo").toString().isEmpty()) {
            panel.getCcdKaigoShikakuKihon().getTxtJutokuKaijo().clearValue();
        } else {
            panel.getCcdKaigoShikakuKihon().getTxtJutokuKaijo().
                    setValue(ymlData.getAsRDate("jutokukaijo"));
        }

        if (ymlData.getAsRString("jutokutekiyo").toString().isEmpty()) {
            panel.getCcdKaigoShikakuKihon().getTxtJutokuTekiyo().clearValue();
        } else {
            panel.getCcdKaigoShikakuKihon().getTxtJutokuTekiyo().
                    setValue(ymlData.getAsRDate("jutokutekiyo"));
        }

        if (ymlData.getAsRString("kaigodo").toString().isEmpty()) {
            panel.getCcdKaigoShikakuKihon().getTxtYokaigoJotaiKubun().clearValue();
        } else {
            panel.getCcdKaigoShikakuKihon().getTxtYokaigoJotaiKubun().
                    setValue(ymlData.getAsRString("kaigodo"));
        }

        if (ymlData.getAsRString("kyusochinyusho").toString().isEmpty()) {
            panel.getCcdKaigoShikakuKihon().getTxtKyuSochiNyusho().clearValue();
        } else {
            panel.getCcdKaigoShikakuKihon().getTxtKyuSochiNyusho().
                    setValue(ymlData.getAsRString("kyusochinyusho"));
        }

        if (ymlData.getAsRString("ninteikikanfrom").toString().isEmpty()) {

            panel.getCcdKaigoShikakuKihon().getTxtNinteiKaishiYmd().clearValue();
        } else {
            panel.getCcdKaigoShikakuKihon().getTxtNinteiKaishiYmd().
                    setValue(ymlData.getAsRDate("ninteikikanfrom"));
        }

        if (ymlData.getAsRString("ninteikikanto").toString().isEmpty()) {
            panel.getCcdKaigoShikakuKihon().getTxtNinteiShuryoYmd().clearValue();
        } else {
            panel.getCcdKaigoShikakuKihon().getTxtNinteiShuryoYmd().
                    setValue(ymlData.getAsRDate("ninteikikanto"));
        }

        response.data = panel;
        return response;

    }

}
