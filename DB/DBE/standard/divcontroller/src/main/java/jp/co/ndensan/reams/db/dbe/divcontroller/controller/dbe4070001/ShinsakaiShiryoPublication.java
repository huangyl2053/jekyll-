/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.dbe4070001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001.ShinsakaiSearchDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001.ShinsakaiShiryoPublicationDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001.dgShinsakaiList_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 審査会資料作成時の資料発行Divの処理を表します。
 *
 * @author N1013 松本直樹
 */
public class ShinsakaiShiryoPublication {

    /**
     * 審査会選択Divの審査会一覧の審査会が選択された際の資料発行Divの処理を表します。
     *
     * @param div 資料発行Div
     * @param searchDiv 審査会選択Div
     * @return ResponseData
     */
    public ResponseData onClick_btnSentaku(ShinsakaiShiryoPublicationDiv div,
            ShinsakaiSearchDiv searchDiv) {
        ResponseData<ShinsakaiShiryoPublicationDiv> response = new ResponseData<>();

        dgShinsakaiList_Row dataRow = searchDiv.getShinsakaiList().getDgShinsakaiList().getClickedItem();

        div.getPublicationTargetShinsakai().getTxtGogitaiName().setValue(dataRow.getGogitaiName());
        div.getPublicationTargetShinsakai().getTxtGogitaiNo().setValue(dataRow.getGogitaiNo());
        div.getPublicationTargetShinsakai().getTxtShinsakaiKaijo().setValue(dataRow.getShinsakaiKaijo());
        div.getPublicationTargetShinsakai().getTxtShinsakaiKaisaiNo().setValue(dataRow.getKaisaiNo());
        div.getPublicationTargetShinsakai().getTxtShinsakaiKaishiYoteiTime().setValue(
                RTime.parse(dataRow.getKaishiYoteiTime().toString()));
        div.getPublicationTargetShinsakai().getTxtShinsakaiYoteiDate().setValue(dataRow.getKaisaiYoteiDate().getValue());
        div.getPublicationTargetShinsakai().getTxtShiryoSakusei().setValue(dataRow.getShiryoSakuseiKubun());
        Decimal wariateNinzu = new Decimal(dataRow.getWariateNinzu().toString());
        Decimal yoteiTeiin = new Decimal(dataRow.getYoteiTeiin().toString());
        div.getPublicationTargetShinsakai().getTxtWariateNinzu().setValue(wariateNinzu);
        div.getPublicationTargetShinsakai().getTxtYoteiTeiin().setValue(yoteiTeiin);

        if (dataRow.getShiryoSakuseiKubun().equalsIgnoreCase(new RString("済"))) {
            div.getLatestPublication().getTxtOperationDate().setValue(new FlexibleDate("20140602"));
            div.getLatestPublication().getTxtShoriKubun().setValue(new RString("全件"));
        } else {
            div.getLatestPublication().getTxtOperationDate().setValue(FlexibleDate.EMPTY);
            div.getLatestPublication().getTxtShoriKubun().setValue(RString.EMPTY);
        }

        div.getPublishingCondition1().getPublishingConditionForJimukyoku1().getTxtCopyNumForJimukyoku1().setValue(Decimal.ONE);
        div.getPublishingCondition1().getPublishingConditionForShinsakaiIin1().getTxtCopyNumForShinsakaiIin1().setValue(Decimal.ONE);

        response.data = div;
        return response;
    }

    /**
     * 資料発行Divの「発行の範囲を指定する」ボタン押下時の処理を表します。
     *
     * @param div 資料発行Div
     * @param searchDiv 審査会選択Div
     * @return ResponseData
     */
    public ResponseData onClick_btnToChangeCondition2(ShinsakaiShiryoPublicationDiv div,
            ShinsakaiSearchDiv searchDiv) {
        ResponseData<ShinsakaiShiryoPublicationDiv> response = new ResponseData<>();

        div.getPublishingCondition2().getPublishingConditionForJimukyoku2().getTtxtCopyNumForJimukyoku2().setValue(Decimal.ONE);
        div.getPublishingCondition2().getPublishingConditionForJimukyoku2().getPageRangeForJimukyoku().setTxtPageRangeForJimukyokuFrom(null);
        div.getPublishingCondition2().getPublishingConditionForJimukyoku2().getPageRangeForJimukyoku().setTxtPageRangeForJimukyokuTo(null);

        div.getPublishingCondition2().getPublishingConditionForShinsakaiIin2().getTxtCopyNumForShinsakaiIin2().setValue(Decimal.ONE);
        div.getPublishingCondition2().getPublishingConditionForShinsakaiIin2().getPageRangeAssignmentForShinsakaiIin().
                setTxtPageRangeAssignmentForShinsakaiIinFrom(null);
        div.getPublishingCondition2().getPublishingConditionForShinsakaiIin2().getPageRangeAssignmentForShinsakaiIin().
                setTxtPageRangeAssignmentForShinsakaiIinTo(null);

        response.data = div;
        return response;
    }

    /**
     * 資料発行Divの作成条件指定画面の「戻る」ボタン押下時の処理を表します。
     *
     * @param div 資料発行Div
     * @param searchDiv 審査会選択Div
     * @return ResponseData
     */
    public ResponseData onClick_btnToReturn(ShinsakaiShiryoPublicationDiv div,
            ShinsakaiSearchDiv searchDiv) {
        ResponseData<ShinsakaiShiryoPublicationDiv> response = new ResponseData<>();

        div.getPublishingCondition1().getPublishingConditionForJimukyoku1().getTxtCopyNumForJimukyoku1().setValue(Decimal.ONE);
        div.getPublishingCondition1().getPublishingConditionForShinsakaiIin1().getTxtCopyNumForShinsakaiIin1().setValue(Decimal.ONE);

        response.data = div;
        return response;
    }

}
