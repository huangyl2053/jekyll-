/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.TekiyoJogaiTaishoGaitoshaDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.TekiyoJogaiTaishoshaJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.TekiyoJogaishaDbJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.tblAtenaSimpleDiv;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 適用除外対象者パネルに対応するDivControllerです。
 *
 * @author n8178 城間篤人
 */
public class TekiyoJogaiTaishoshaJoho {

    private static final RString TEKIYO_JOGAI_TAISHOSHA = new RString("TekiyoJogaiTaishosha.yml");

    /**
     * 該当者グリッドから一人が選択された際に、適用除外対象者情報パネルに対象者の詳細な情報を表示します。
     *
     * @param tekiyoJogaiTaishoshaJohoDiv 適用除外退所者情報Div
     * @param tekiyoJogaiTaishoGaitoshaDiv 適用除外対象該当者Div
     * @return レスポンス
     */
    public ResponseData onClick_btnSelectGaitosha(TekiyoJogaiTaishoshaJohoDiv tekiyoJogaiTaishoshaJohoDiv,
            TekiyoJogaiTaishoGaitoshaDiv tekiyoJogaiTaishoGaitoshaDiv) {
        ResponseData<TekiyoJogaiTaishoshaJohoDiv> response = new ResponseData<>();

        int rowId = tekiyoJogaiTaishoGaitoshaDiv.getDgTekiyoJogaiTaishoGaitosha().getClickedRowId();
        setTaishoshaJoho(tekiyoJogaiTaishoshaJohoDiv, rowId);

        response.data = tekiyoJogaiTaishoshaJohoDiv;
        return response;
    }

    /**
     * 検索した結果、処理対象者が一人しかいない場合、その一人の詳細情報を適用除外対象者情報パネルに表示します。
     *
     * @param tekiyoJogaiTaishoshaJohoDiv 適用除外退所者情報Div
     * @param tekiyoJogaiTaishoGaitoshaDiv 適用除外対象該当者Div
     * @return レスポンス
     */
    public ResponseData onOnlyRow_dgTekiyoJogaiTaishoGaitosha(TekiyoJogaiTaishoshaJohoDiv tekiyoJogaiTaishoshaJohoDiv,
            TekiyoJogaiTaishoGaitoshaDiv tekiyoJogaiTaishoGaitoshaDiv) {
        ResponseData<TekiyoJogaiTaishoshaJohoDiv> response = new ResponseData<>();

        setTaishoshaJoho(tekiyoJogaiTaishoshaJohoDiv, 0);

        response.data = tekiyoJogaiTaishoshaJohoDiv;
        return response;
    }

    private void setTaishoshaJoho(TekiyoJogaiTaishoshaJohoDiv tekiyoJogaiTaishoshaJohoDiv, int rowID) {
        List<HashMap> taishoshaList = YamlLoader.FOR_DBA.loadAsList(TEKIYO_JOGAI_TAISHOSHA);

        setCommonInfo(tekiyoJogaiTaishoshaJohoDiv.getTekiyoJogaishaCommonJoho(), taishoshaList.get(rowID));
        setDbInfo(tekiyoJogaiTaishoshaJohoDiv.getTekiyoJogaishaDbJoho(), taishoshaList.get(rowID));
    }

    private void setCommonInfo(AtenaShokaiSimpleDiv tekiyoJogaishaCommonJoho, HashMap taishosha) {
        tblAtenaSimpleDiv atenaData = tekiyoJogaishaCommonJoho.getTblAtenaSimple();
        atenaData.getTxtAtenaKanaMeisho().setValue(new RString(taishosha.get("カナ氏名").toString()));
        atenaData.getTxtAtenaMeisho().setValue(new RString(taishosha.get("氏名").toString()));
        atenaData.getTxtGyoseiku().setValue(new RString(taishosha.get("行政区").toString()));
        atenaData.getTxtJuminJotai().setValue(new RString(taishosha.get("住民状態").toString()));
        atenaData.getTxtJuminShubetsu().setValue(new RString(taishosha.get("住民種別").toString()));
        atenaData.getTxtJusho().setValue(new RString(taishosha.get("住所").toString()));
        atenaData.getTxtKojinHojinCode().setValue(new RString(taishosha.get("個人法人コード").toString()));
        atenaData.getTxtNenrei().setValue(new RString(taishosha.get("年齢").toString()));
        atenaData.getTxtSeibetsu().setValue(new RString(taishosha.get("性別").toString()));
        atenaData.getTxtSeinengappiYMD().setValue(new RDate(taishosha.get("生年月日").toString()));
        atenaData.getTxtSetaiCode().setValue(new RString(taishosha.get("世帯コード").toString()));
        atenaData.getTxtShikibetsuCode().setValue(new RString(taishosha.get("識別コード").toString()));
        atenaData.getTxtYubinNo().setValue(new YubinNo(taishosha.get("郵便番号").toString()));
    }

    private void setDbInfo(TekiyoJogaishaDbJohoDiv tekiyoJogaishaDbJoho, HashMap taishosha) {
        tekiyoJogaishaDbJoho.getTxtHihokenshaNo().setValue(new RString(taishosha.get("被保番号").toString()));
        tekiyoJogaishaDbJoho.getTxtKyuHihokenshaNo().setValue(new RString(taishosha.get("旧被保番号").toString()));
        tekiyoJogaishaDbJoho.getTxtKyuShichoson().setValue(new RString(taishosha.get("旧市町村").toString()));
        tekiyoJogaishaDbJoho.getTxtNinteiKikan().setFromValue(new RDate(taishosha.get("認定期間開始").toString()));
        tekiyoJogaishaDbJoho.getTxtNinteiKikan().setToValue(new RDate(taishosha.get("認定期間終了").toString()));
        tekiyoJogaishaDbJoho.getTxtYokaigodo().setValue(new RString(taishosha.get("要介護度").toString()));
    }
}
