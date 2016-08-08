/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000014;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000014.FutanWariaiShoHakkoPanelDiv;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link FutanWariaiShoHakkoPanelDiv}の仕様クラスです。 <br> {@link FutanWariaiShoHakkoPanelDiv}における画面としての仕様を定義しています。
 *
 * @reamsid_L DBC-4990-010 pengxingyi
 */
public enum FutanWariaiShoHakkoSpec implements IPredicate<FutanWariaiShoHakkoPanelDiv> {

    /**
     * 抽出期間不正
     */
    抽出期間不正 {
                @Override
                public boolean apply(FutanWariaiShoHakkoPanelDiv div) {
                    return SpecHelper.is抽出期間不正(div);
                }
            };

    private static class SpecHelper {

        private static final RString ZERO = new RString("0");

        public static boolean is抽出期間不正(FutanWariaiShoHakkoPanelDiv div) {
            if (ZERO.equals(div.getPanelJoken().getRadKubun().getSelectedKey())) {
                return true;
            }
            YMDHMS 前回終了日時 = new YMDHMS(div.getPanelKikan().getTxtZenkaiShuryoDate().getValue(),
                    div.getPanelKikan().getTxtZenkaiShuryoTime().getValue());
            YMDHMS 今回開始日時 = new YMDHMS(div.getPanelKikan().getTxtKonkaiKaishiDate().getValue(),
                    div.getPanelKikan().getTxtKonkaiKaishiTime().getValue());
            return 今回開始日時.isBeforeOrEquals(前回終了日時);
        }

    }

}
