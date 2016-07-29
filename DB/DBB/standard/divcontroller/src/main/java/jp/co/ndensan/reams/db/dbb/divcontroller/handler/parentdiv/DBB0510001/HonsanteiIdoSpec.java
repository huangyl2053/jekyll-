/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0510001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0510001.HonsanteiIdoDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBBGM44001_本算定異動（現年度）の入力チェックSpecです。
 *
 * @reamsid_L DBB-0880-010 wangkanglei
 */
public enum HonsanteiIdoSpec implements IPredicate<HonsanteiIdoDiv> {

    /**
     * 処理対象
     */
    処理対象 {
                @Override
                public boolean apply(HonsanteiIdoDiv div) {
                    return SpecHelper.is処理対象(div);
                }
            },
    /**
     * 特徴開始通知書の発行日
     */
    特徴開始通知書の発行日 {
                @Override
                public boolean apply(HonsanteiIdoDiv div) {
                    return SpecHelper.is特徴開始通知書の発行日(div);
                }
            },
    /**
     * 通知書チェックボックス
     */
    通知書チェックボックス {
                @Override
                public boolean apply(HonsanteiIdoDiv div) {
                    return SpecHelper.is通知書チェックボックス(div);
                }
            },
    /**
     * 決定通知書の発行日
     */
    決定通知書の発行日 {
                @Override
                public boolean apply(HonsanteiIdoDiv div) {
                    return SpecHelper.is決定通知書の発行日(div);
                }
            },
    /**
     * 変更通知書の対象者
     */
    変更通知書の対象者 {
                @Override
                public boolean apply(HonsanteiIdoDiv div) {
                    return SpecHelper.is変更通知書の対象者(div);
                }
            },
    /**
     * 変更通知書の発行日
     */
    変更通知書の発行日 {
                @Override
                public boolean apply(HonsanteiIdoDiv div) {
                    return SpecHelper.is変更通知書の発行日(div);
                }
            },
    /**
     * 納入通知書の対象者
     */
    納入通知書の対象者 {
                @Override
                public boolean apply(HonsanteiIdoDiv div) {
                    return SpecHelper.is納入通知書の対象者(div);
                }
            },
    /**
     * 納入通知書の発行日
     */
    納入通知書の発行日 {
                @Override
                public boolean apply(HonsanteiIdoDiv div) {
                    return SpecHelper.is納入通知書の発行日(div);
                }
            },
    /**
     * 処理対象と出力期の一致
     */
    処理対象と出力期の一致 {
                @Override
                public boolean apply(HonsanteiIdoDiv div) {
                    return SpecHelper.is処理対象と出力期の一致(div);
                }
            };

    private static class SpecHelper {

        private static final RString 月 = new RString("月");
        private static final int NUM_0 = 0;
        private static final int NUM_2 = 2;

        public static boolean is処理対象(HonsanteiIdoDiv div) {
            RString key = div.getHonsanteiIdoShoriNaiyo().getDdlShoritsuki().getSelectedKey();
            return !key.isEmpty();
        }

        public static boolean is特徴開始通知書の発行日(HonsanteiIdoDiv div) {
            RDate 特徴開始通知書発行日 = div.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho()
                    .getTxtTokuchoKaishiTsuchishoHakkoYMD().getValue();
            return 特徴開始通知書発行日 != null;
        }

        public static boolean is通知書チェックボックス(HonsanteiIdoDiv div) {
            List<RString> 決定通知書チェックボックス = div.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho()
                    .getChkKetteiTsuchi().getSelectedKeys();
            List<RString> 変更通知書チェックボックス = div.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho()
                    .getChkHenkoTsuchi().getSelectedKeys();
            return !決定通知書チェックボックス.isEmpty() || !変更通知書チェックボックス.isEmpty();
        }

        public static boolean is決定通知書の発行日(HonsanteiIdoDiv div) {
            RDate 決定通知書発行日 = div.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho()
                    .getTxtKetteiTsuchiHakkoYMD().getValue();
            return 決定通知書発行日 != null;
        }

        public static boolean is変更通知書の対象者(HonsanteiIdoDiv div) {
            List<RString> 変更通知書対象者 = div.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho()
                    .getChkHenkoTsuchiTaishosha().getSelectedKeys();
            return !変更通知書対象者.isEmpty();
        }

        public static boolean is変更通知書の発行日(HonsanteiIdoDiv div) {
            RDate 変更通知書発行日 = div.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho()
                    .getTxtHenkoTsuchiHakkoYMD().getValue();
            return 変更通知書発行日 != null;
        }

        public static boolean is納入通知書の対象者(HonsanteiIdoDiv div) {
            List<RString> 納入通知書対象者 = div.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho()
                    .getChkNotsuTaishoSha().getSelectedKeys();
            return !納入通知書対象者.isEmpty();
        }

        public static boolean is納入通知書の発行日(HonsanteiIdoDiv div) {
            RDate 納入通知書発行日 = div.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho()
                    .getTxtNotsuHakkoYMD().getValue();
            return 納入通知書発行日 != null;
        }

        public static boolean is処理対象と出力期の一致(HonsanteiIdoDiv div) {
            RString key1 = div.getHonsanteiIdoShoriNaiyo().getDdlShoritsuki().getSelectedKey();
            RString key2 = div.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho()
                    .getDdlNotsuShuturyokuki().getSelectedValue();
            RString 出力期_月 = key2.split(月.toString()).get(NUM_0);
            return key1.equals(出力期_月.substring(出力期_月.length() - NUM_2, 出力期_月.length()));
        }
    }
}
