/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DbCommonInfoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.JushochiTokureiTaishosaInfoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所地特例対象者の情報を表示するパネルの、Divコントローラです。
 *
 * @author n8178 城間篤人
 */
public class JushochiTokureiTaishosaInfo {

    private static final RString DATA_SOURCE = new RString("dba/demoData/JushochiTokureiTaishosha.yml");

    /**
     * 検索して表示された住所地特例対象者から一人を選択した際に動作するメソッドです。 該当者の詳細な情報をパネルに表示します。
     *
     * @param div JushochiTokureiTaishosaInfoDiv
     * @return レスポンスデータ
     */
    public ResponseData onClick_btnSelectJushochiTokureiTaishosha(JushochiTokureiTaishosaInfoDiv div) {
        List<HashMap> demoDataList = YamlLoader.loadAsList(DATA_SOURCE);
        HashMap demoData = demoDataList.get(0);

        ResponseData<JushochiTokureiTaishosaInfoDiv> response = new ResponseData<>();
        setAtenaJoho(div.getAtenaJoho(), demoData);
        setDbCommonInfo(div.getDbCommonInfo(), demoData);
        response.data = div;
        return response;
    }

    private void setAtenaJoho(AtenaShokaiSimpleDiv atena, Map demoData) {

        atena.getTxtAtenaKanaMeisho().setValue(new RString(demoData.get("カナ氏名").toString()));
        atena.getTxtAtenaMeisho().setValue(new RString(demoData.get("氏名").toString()));
        atena.getTxtGyoseiku().setValue(new RString(demoData.get("行政区").toString()));
        atena.getTxtJuminJotai().setValue(new RString(demoData.get("住民状態").toString()));
        atena.getTxtNihonjinGaikokujin().setValue(new RString(demoData.get("住民種別").toString()));
        atena.getTxtJusho().setValue(new RString(demoData.get("住所").toString()));
        atena.getTxtKojinHojinCode().setValue(new RString(demoData.get("個人法人コード").toString()));
        atena.getTxtNenrei().setValue(new RString(demoData.get("氏名").toString()));
        atena.getTxtSeibetsu().setValue(new RString(demoData.get("性別").toString()));
        atena.getTxtSeinengappiYMD().setValue(new RDate(demoData.get("生年月日").toString()));
        atena.getTxtSetaiCode().setValue(new RString(demoData.get("世帯コード").toString()));
        atena.getTxtShikibetsuCode().setValue(new RString(demoData.get("識別コード").toString()));
        atena.getTxtYubinNo().setValue(new YubinNo(demoData.get("郵便番号").toString()));
    }

    private void setDbCommonInfo(DbCommonInfoDiv dbCommonInfo, Map demoData) {

        dbCommonInfo.getTxtHihokenshaNo().setValue(new RString(demoData.get("被保番号").toString()));
        dbCommonInfo.getTxtKyuHihokenshaNo().setValue(new RString(demoData.get("旧被保番号").toString()));
        dbCommonInfo.getTxtNinteiKikan().setFromValue(new RDate(demoData.get("認定期間開始").toString()));
        dbCommonInfo.getTxtNinteiKikan().setToValue(new RDate(demoData.get("認定期間終了").toString()));
        dbCommonInfo.getTxtYokaigodo().setValue(new RString(demoData.get("要介護度").toString()));
    }
}
