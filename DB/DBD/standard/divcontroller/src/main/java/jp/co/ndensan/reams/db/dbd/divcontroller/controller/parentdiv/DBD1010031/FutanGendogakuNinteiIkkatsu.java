/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1010031;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD101010.DBD101010_FutanGendogakuNinteiShinseiIkkatsuShoninParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010031.FutangendogakuShoninMainDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担限度額認定申請承認（一括）のビジネス設計です。
 *
 * @reamsid_L DBD-3710-060 xuejm
 */
public class FutanGendogakuNinteiIkkatsu {

    private static final int NO_0 = 0;
    private static final int NO_4 = 4;

    /**
     * バッチパラメータを設定します。
     *
     * @param div FutangendogakuShoninMainDiv
     * @return DBD101010_FutanGendogakuNinteiShinseiIkkatsuShoninParameter
     */
    public DBD101010_FutanGendogakuNinteiShinseiIkkatsuShoninParameter createFutanGendogakuIkkatsuNinteiParameter(FutangendogakuShoninMainDiv div) {
        DBD101010_FutanGendogakuNinteiShinseiIkkatsuShoninParameter parameter
                = new DBD101010_FutanGendogakuNinteiShinseiIkkatsuShoninParameter();
        if (div.getFutangendogakuShonin().getTxtSakuseiNendo().getValue() != null
                && !div.getFutangendogakuShonin().getTxtSakuseiNendo().getValue().isEmpty()) {
            parameter.set作成年度(new FlexibleYear(div.getFutangendogakuShonin().getTxtSakuseiNendo().getValue().toString()
                    .substring(NO_0, NO_4)));
        }
        if (div.getTxtChoteiKikan().getFromValue() != null) {
            parameter.set認定期間_開始日(new FlexibleDate(div.getTxtChoteiKikan().getFromValue().toDateString()));
        }
        if (div.getTxtChoteiKikan().getToValue() != null) {
            parameter.set認定期間_終了日(new FlexibleDate(div.getTxtChoteiKikan().getToValue().toDateString()));
        }
        parameter.set決定日(div.getTxtKetteibi().getValue());
        if (div.getTxtShinseibiJoken().getFromValue() != null) {
            parameter.set申請日開始(new FlexibleDate(div.getTxtShinseibiJoken().getFromValue().toDateString()));
        }
        if (div.getTxtShinseibiJoken().getToValue() != null) {
            parameter.set申請日終了(new FlexibleDate(div.getTxtShinseibiJoken().getToValue().toDateString()));
        }
        parameter.set非課税時_承認しないフラグ(div.getChkHikazeiKyakka().isAllSelected());
        parameter.set非課税時_承認しない理由(div.getTxtShoninShinaiRiyu1().getValue());
        parameter.set配偶者課税時_承認しないフラグ(div.getChkHaigushaKazei().isAllSelected());
        parameter.set配偶者課税時_承認しない理由(div.getTxtShoninShinaiRiyu2().getValue());
        parameter.set預貯金等超過時_承認しないフラグ(div.getChkYochokinJogenOver().isAllSelected());
        parameter.set預貯金等超過時_理由(div.getTxtShoninShinaiRiyu3().getValue());

        parameter.setテスト処理(div.getChkTest().isAllSelected());
        parameter.set確認リスト出力(div.getShinseiPrint().isIsPublish());
        parameter.set発行日(div.getTxtHakkoYMD().getValue());
        if (div.getCcdChohyoShutsuryokujun().get出力順ID() != null) {
            parameter.set改頁出力順ID(new RString(div.getCcdChohyoShutsuryokujun().get出力順ID().toString()));
        }
        parameter.set帳票ID(new RString(ReportIdDBD.DBD200005.getReportId().toString()));
        return parameter;
    }

}
