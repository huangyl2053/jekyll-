/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011.HihokenshashoHakkoTaishoGaitoshaDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011.HihokenshashoHakkoTaishoshaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
            HihokenshashoHakkoTaishoshaJohoDiv panel, HihokenshashoHakkoTaishoGaitoshaDiv panel2) {
        ResponseData<HihokenshashoHakkoTaishoshaJohoDiv> response = new ResponseData<>();

        List<HashMap> hihokenshashoHakkoTaishoshaJohoList = YamlLoader.FOR_DBU.loadAsList(
                new RString("dbu0410011/HihokenshashoHakkoTaishoshaJoho.yml"));

        HashMap hashMap = hihokenshashoHakkoTaishoshaJohoList.get(
                panel2.getDgHihokenshashoHakkoTaishoGaitosha().getClickedRowId());

        ControlGenerator ymlData = new ControlGenerator(hashMap);

        //対象者情報の出力
        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTblAtenaSimple().getTxtAtenaMeisho().
                setValue(panel2.getDgHihokenshashoHakkoTaishoGaitosha().getClickedItem().getShimei());

        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTblAtenaSimple().getTxtAtenaKanaMeisho().
                setValue(ymlData.getAsRString("shimeikana"));

        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTblAtenaSimple().getTxtJusho().
                setValue(panel2.getDgHihokenshashoHakkoTaishoGaitosha().getClickedItem().getJusho());

        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTblAtenaSimple().getTxtSeinengappiYMD().
                setValue(new RDate(panel2.getDgHihokenshashoHakkoTaishoGaitosha().getClickedItem().
                                getDateOfBirth().toString()));

        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTblAtenaSimple().getTxtNenrei().
                setValue(ymlData.getAsRString("nenrei"));

        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTblAtenaSimple().getTxtSeibetsu().
                setValue(panel2.getDgHihokenshashoHakkoTaishoGaitosha().getClickedItem().getGender());

        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTblAtenaSimple().getTxtGyoseiku().
                setValue(ymlData.getAsRString("gyoseiku"));

        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTblAtenaSimple().getTxtYubinNo().
                setValue(new YubinNo(ymlData.getAsRString("yubinno")));

        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTblAtenaSimple().getTxtJuminShubetsu().
                setValue(ymlData.getAsRString("juminshubetsu"));

        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTblAtenaSimple().getTxtJuminJotai().
                setValue(ymlData.getAsRString("juminjotai"));

        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTblAtenaSimple().getTxtShikibetsuCode().
                setValue(ymlData.getAsRString("shikibetsucode"));

        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTblAtenaSimple().getTxtKojinHojinCode().
                setValue(ymlData.getAsRString("kojincode"));

        panel.getHihokenshashoHakkoTaishoshaCommonJoho().getTblAtenaSimple().getTxtSetaiCode().
                setValue(ymlData.getAsRString("setaicode"));

        panel.getHihokenshashoHakkoTaishoshaDbJoho().getTxtHihokenshaNo().
                setValue(panel2.getDgHihokenshashoHakkoTaishoGaitosha().getClickedItem().getHihokenshaNo());

        panel.getHihokenshashoHakkoTaishoshaDbJoho().getTxtKyuHihokenshaNo().
                setValue(ymlData.getAsRString("kyuhihono"));

        panel.getHihokenshashoHakkoTaishoshaDbJoho().getTxtYokaigodo().
                setValue(ymlData.getAsRString("kaigodo"));

        panel.getHihokenshashoHakkoTaishoshaDbJoho().getTxtNinteiKikan().
                setFromValue(new RDate(ymlData.getAsRString("ninteikikanfrom").toString()));

        panel.getHihokenshashoHakkoTaishoshaDbJoho().getTxtNinteiKikan().
                setToValue(new RDate(ymlData.getAsRString("ninteikikanto").toString()));

        panel.getHihokenshashoHakkoTaishoshaDbJoho().getTxtKyuShichoson().
                setValue(ymlData.getAsRString("kyushichoson"));

        response.data = panel;
        return response;

    }

}
