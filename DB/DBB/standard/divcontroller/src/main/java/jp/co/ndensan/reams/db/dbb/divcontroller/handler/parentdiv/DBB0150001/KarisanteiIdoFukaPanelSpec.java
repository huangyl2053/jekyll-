/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0150001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0150001.KarisanteiIdoFukaPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBBGM36001_仮算定異動賦課の入力チェックSpecです。
 *
 * @reamsid_L DBB-0890-010 wangkanglei
 */
public enum KarisanteiIdoFukaPanelSpec implements IPredicate<KarisanteiIdoFukaPanelDiv> {

    /**
     * 仮算定額変更通知書の発行日
     */
    仮算定額変更通知書の発行日 {
                @Override
                public boolean apply(KarisanteiIdoFukaPanelDiv div) {
                    return SpecHelper.is仮算定額変更通知書の発行日(div);
                }
            },
    /**
     * 納入通知書_発行日
     */
    納入通知書_発行日 {
                @Override
                public boolean apply(KarisanteiIdoFukaPanelDiv div) {
                    return SpecHelper.is納入通知書の発行日(div);
                }
            },
    /**
     * 納入通知書_対象者
     */
    納入通知書_対象者 {
                @Override
                public boolean apply(KarisanteiIdoFukaPanelDiv div) {
                    return SpecHelper.is納入通知書の対象者(div);
                }
            },
    /**
     * 特徴開始通知書_発行日
     */
    特徴開始通知書_発行日 {
                @Override
                public boolean apply(KarisanteiIdoFukaPanelDiv div) {
                    return SpecHelper.is特徴開始通知書の発行日(div);
                }
            },
    /**
     * 処理対象と出力期の一致
     */
    処理対象と出力期の一致 {
                @Override
                public boolean apply(KarisanteiIdoFukaPanelDiv div) {
                    return SpecHelper.is処理対象と出力期の一致(div);
                }
            };

    private static class SpecHelper {

        private static final RString 月 = new RString("月");
        private static final int NUM_0 = 0;
        private static final int NUM_2 = 2;

        public static boolean is仮算定額変更通知書の発行日(KarisanteiIdoFukaPanelDiv div) {
            RDate 仮算定額変更通知書_発行日 = div.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho()
                    .getTxtKariHenkoTsuchiHakkoYMD().getValue();
            return 仮算定額変更通知書_発行日 != null;
        }

        public static boolean is納入通知書の発行日(KarisanteiIdoFukaPanelDiv div) {
            RDate 納入通知書_発行日 = div.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho()
                    .getTxtNotsuHakkoYMD().getValue();
            return 納入通知書_発行日 != null;
        }

        public static boolean is納入通知書の対象者(KarisanteiIdoFukaPanelDiv div) {
            List<RString> 納入通知書_対象者 = div.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho()
                    .getChkNotsuTaishosha().getSelectedKeys();
            return !納入通知書_対象者.isEmpty();
        }

        public static boolean is特徴開始通知書の発行日(KarisanteiIdoFukaPanelDiv div) {
            RDate 特徴開始通知書_発行日 = div.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho()
                    .getTxtTokuKaishiTsuchiHakkoYMD().getValue();
            return 特徴開始通知書_発行日 != null;
        }

        public static boolean is処理対象と出力期の一致(KarisanteiIdoFukaPanelDiv div) {
            RString key1 = div.getShoriJokyo().getKarisanteiIdoShoriNaiyo().getDdlShorigetsu().getSelectedKey();
            RString key2 = div.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho()
                    .getDdlNotsuShuturyokuki().getSelectedValue();
            if (!RString.isNullOrEmpty(key2)) {
                RString 出力期_月 = key2.split(月.toString()).get(NUM_0);
                return key1.equals(出力期_月.substring(出力期_月.length() - NUM_2, 出力期_月.length()));
            } else {
                return false;
            }
        }
    }
}
