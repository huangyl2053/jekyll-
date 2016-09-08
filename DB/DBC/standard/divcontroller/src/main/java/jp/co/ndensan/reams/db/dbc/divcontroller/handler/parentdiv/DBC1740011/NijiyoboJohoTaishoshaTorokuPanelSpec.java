/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1740011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1740011.NijiyoboJohoTaishoshaTorokuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1740011.dgKihonInfo_Row;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合事業（経過措置）対象者登録 のSpecです。
 *
 * @reamsid_L DBC-2400-010 yuqingzhang
 */
public enum NijiyoboJohoTaishoshaTorokuPanelSpec implements IPredicate<NijiyoboJohoTaishoshaTorokuPanelDiv> {

    /**
     * 適用期間重複のチェックです。
     */
    適用期間重複 {
                @Override
                public boolean apply(NijiyoboJohoTaishoshaTorokuPanelDiv div) {
                    return SpecHelper.is適用期間重複(div);
                }
            },
    /**
     * 開始日と終了日の前後順のチェックです
     */
    開始日と終了日の前後順 {
                @Override
                public boolean apply(NijiyoboJohoTaishoshaTorokuPanelDiv div) {
                    return SpecHelper.is開始日と終了日の前後順(div);
                }
            };

    /**
     * {@link NijiyoboJohoTaishoshaTorokuPanelSpec}における判定ロジックのHelperクラスです。
     */
    private static class SpecHelper {

        private static final RString 追加 = new RString("追加");
        private static final RString ZERO = new RString("0");

        public static boolean is適用期間重複(NijiyoboJohoTaishoshaTorokuPanelDiv div) {
            List<dgKihonInfo_Row> rowList = div.getKihonnInfo().getDgKihonInfo().getDataSource();
            RString clickRirekiNo = 追加.equals(div.getOperateState()) ? ZERO
                    : div.getKihonnInfo().getDgKihonInfo().getClickedItem().getRirekiNo();
            RDate 適用期間の開始日 = div.getSoukoinfo().getTxtymfromto().getFromValue();
            RDate 適用期間の終了日 = div.getSoukoinfo().getTxtymfromto().getToValue();
            boolean is適用期間重複 = false;
            for (dgKihonInfo_Row row : rowList) {
                if ((!clickRirekiNo.equals(row.getRirekiNo()))
                        && !((null != row.getTekiyouKaishiBi().getValue() && 適用期間の終了日.isBefore(row.getTekiyouKaishiBi().getValue()))
                        || (null != row.getTekiyouKaishiBi().getValue() && row.getTekiyouKaishiBi().getValue().isBefore(適用期間の開始日)))) {
                    is適用期間重複 = true;
                }
            }
            return !is適用期間重複;
        }

        public static boolean is開始日と終了日の前後順(NijiyoboJohoTaishoshaTorokuPanelDiv div) {
            RDate 適用期間の開始日 = div.getSoukoinfo().getTxtymfromto().getFromValue();
            RDate 適用期間の終了日 = div.getSoukoinfo().getTxtymfromto().getToValue();
            return !適用期間の終了日.isBefore(適用期間の開始日);
        }
    }
}
