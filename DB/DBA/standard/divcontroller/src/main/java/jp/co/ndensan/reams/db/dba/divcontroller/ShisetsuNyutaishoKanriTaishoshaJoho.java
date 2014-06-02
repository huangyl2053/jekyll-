/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2020011.ShisetsuNyutaishoKainriTaishoshaJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2020011.ShisetsuNyutaishoKanriTaishoGaitoshaDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2020011.ShisetsuNyutaishoKanriTaishoshaDbJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2020011.dgShisetsuNyutaishoKanriGaitosha_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.tblAtenaSimpleDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.SaikinShorishaRirekiDiv;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 施設入退所履歴管理の対象者共通情報を表示するDivのコントローラです。
 *
 * @author n8178 城間篤人
 */
public class ShisetsuNyutaishoKanriTaishoshaJoho {

    private static final RString SHISETSU_NYUTAISHO_KANRI_TAISHOSHA = new RString("DBA2010011/TaishoshaData.yml");

    /**
     * 該当者検索画面でグリッドから対象者を選択した際に実行されます。
     *
     * @param taishoshaJohoDiv 対象者情報Div
     * @param gaitoshaDiv 該当者Div
     * @param saikinShorishaDiv 最近処理者Div
     * @return レスポンス
     */
    public ResponseData onClick_btnSelect(ShisetsuNyutaishoKainriTaishoshaJohoDiv taishoshaJohoDiv,
            ShisetsuNyutaishoKanriTaishoGaitoshaDiv gaitoshaDiv,
            SaikinShorishaRirekiDiv saikinShorishaDiv) {
        ResponseData<ShisetsuNyutaishoKainriTaishoshaJohoDiv> response = new ResponseData<>();

        DataGrid<dgShisetsuNyutaishoKanriGaitosha_Row> gaitoshaGrid = gaitoshaDiv.getDgShisetsuNyutaishoKanriGaitosha();
        dgShisetsuNyutaishoKanriGaitosha_Row row = gaitoshaGrid.getClickedItem();

        List<HashMap> gaitoshaList = YamlLoader.FOR_DBA.loadAsList(SHISETSU_NYUTAISHO_KANRI_TAISHOSHA);
        for (HashMap gaitosha : gaitoshaList) {
            if (gaitosha.get("被保番号").toString().equals(row.getHihokenshaNo().toString())) {
                setCommonData(taishoshaJohoDiv, gaitosha);
                break;
            }
        }

        response.data = taishoshaJohoDiv;
        return response;
    }

    private void setCommonData(ShisetsuNyutaishoKainriTaishoshaJohoDiv taishoshaJohoDiv, HashMap gaitosha) {
        tblAtenaSimpleDiv commonJoho = taishoshaJohoDiv.getShisetsuNyutaisyoKanriTaishoshaCommonJoho().getTblAtenaSimple();
        commonJoho.getTxtAtenaKanaMeisho().setValue(new RString(gaitosha.get("カナ氏名").toString()));
        commonJoho.getTxtAtenaMeisho().setValue(new RString(gaitosha.get("氏名").toString()));
        commonJoho.getTxtGyoseiku().setValue(new RString(gaitosha.get("行政区").toString()));
        commonJoho.getTxtJuminJotai().setValue(new RString(gaitosha.get("住民状態").toString()));
        commonJoho.getTxtJuminShubetsu().setValue(new RString(gaitosha.get("住民種別").toString()));
        commonJoho.getTxtJusho().setValue(new RString(gaitosha.get("住所").toString()));
        commonJoho.getTxtKojinHojinCode().setValue(new RString(gaitosha.get("個人法人コード").toString()));
        commonJoho.getTxtNenrei().setValue(new RString(gaitosha.get("年齢").toString()));
        commonJoho.getTxtSeibetsu().setValue(new RString(gaitosha.get("性別").toString()));
        commonJoho.getTxtSeinengappiYMD().setValue(new RDate(gaitosha.get("生年月日").toString()));
        commonJoho.getTxtSetaiCode().setValue(new RString(gaitosha.get("世帯コード").toString()));
        commonJoho.getTxtShikibetsuCode().setValue(new RString(gaitosha.get("識別コード").toString()));
        commonJoho.getTxtYubinNo().setValue(new YubinNo(gaitosha.get("郵便番号").toString()));

        ShisetsuNyutaishoKanriTaishoshaDbJohoDiv dbJoho = taishoshaJohoDiv.getShisetsuNyutaishoKanriTaishoshaDbJoho();
        dbJoho.getTxtHihokenshaNo().setValue(new RString(gaitosha.get("被保番号").toString()));
        dbJoho.getTxtKyuHihokenshaNo().setValue(new RString(gaitosha.get("旧被保番号").toString()));
        dbJoho.getTxtKyuShichoson().setValue(new RString(gaitosha.get("旧市町村").toString()));
        dbJoho.getTxtNinteiKikan().setFromValue(new RDate(gaitosha.get("認定期間開始").toString()));
        dbJoho.getTxtNinteiKikan().setToValue(null);
        dbJoho.getTxtYokaigodo().setValue(new RString(gaitosha.get("要介護度").toString()));
    }

    /**
     * 該当者検索画面で、グリッドに表示された該当者が一人しかいない場合に実行されます。
     *
     * @param taishoshaJohoDiv 対象者情報Div
     * @param gaitoshaDiv 該当者Div
     * @param saikinShorishaDiv 最近処理者Div
     * @return レスポンス
     */
    public ResponseData onOnlyRow_dgShisetsuNyutaishoKanriGaitosha(ShisetsuNyutaishoKainriTaishoshaJohoDiv taishoshaJohoDiv,
            ShisetsuNyutaishoKanriTaishoGaitoshaDiv gaitoshaDiv,
            SaikinShorishaRirekiDiv saikinShorishaDiv) {
        ResponseData<ShisetsuNyutaishoKainriTaishoshaJohoDiv> response = new ResponseData<>();

        response.data = taishoshaJohoDiv;
        return response;
    }

    /**
     * 該当者検索画面で、グリッドから対象者をダブルクリックで選択した際に実行されます。
     *
     * @param taishoshaJohoDiv 対象者情報Div
     * @param gaitoshaDiv 該当者Div
     * @param saikinShorishaDiv 最近処理者Div
     * @return レスポンス
     */
    public ResponseData onSelectByDblClick_dgShisetsuNyutaishoKanriGaitosha(ShisetsuNyutaishoKainriTaishoshaJohoDiv taishoshaJohoDiv,
            ShisetsuNyutaishoKanriTaishoGaitoshaDiv gaitoshaDiv,
            SaikinShorishaRirekiDiv saikinShorishaDiv) {
        ResponseData<ShisetsuNyutaishoKainriTaishoshaJohoDiv> response = new ResponseData<>();

        response.data = taishoshaJohoDiv;
        return response;
    }

    /**
     * 該当者検索画面で、最近処理者Divから対象者を選択した際に実行されます。
     *
     * @param taishoshaJohoDiv 対象者情報Div
     * @param gaitoshaDiv 該当者Div
     * @param saikinShorishaDiv 最近処理者Div
     * @return レスポンス
     */
    public ResponseData onClick_btnSaikinShorishaHyoji(ShisetsuNyutaishoKainriTaishoshaJohoDiv taishoshaJohoDiv,
            ShisetsuNyutaishoKanriTaishoGaitoshaDiv gaitoshaDiv,
            SaikinShorishaRirekiDiv saikinShorishaDiv) {
        ResponseData<ShisetsuNyutaishoKainriTaishoshaJohoDiv> response = new ResponseData<>();

        response.data = taishoshaJohoDiv;
        return response;
    }
}
