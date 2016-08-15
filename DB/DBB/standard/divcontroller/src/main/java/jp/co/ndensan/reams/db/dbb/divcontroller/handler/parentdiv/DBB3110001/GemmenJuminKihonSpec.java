/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3110001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001.GemmenJuminKihonDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001.KiwarigakuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001.PrintInfoDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護保険料減免画面
 *
 * @reamsid_L DBB-1660-010 gongliang
 */
public enum GemmenJuminKihonSpec implements IPredicate<GemmenJuminKihonDiv> {

    /**
     * 未指定
     */
    未指定 {
                @Override
                public boolean apply(GemmenJuminKihonDiv div) {
                    return SpecHelper.is未指定(div);
                }
            },
    /**
     * 賦課情報の存在チェック
     */
    賦課情報の存在チェック {
                @Override
                public boolean apply(GemmenJuminKihonDiv div) {
                    return false;
                }

            },
    /**
     * 減免額の整合性チェック
     */
    減免額の整合性チェック {
                @Override
                public boolean apply(GemmenJuminKihonDiv div) {
                    return SpecHelper.減免額の整合性チェック(div);
                }
            },
    /**
     * 決定日の必須入力チェック
     */
    決定日の必須入力チェック {
                @Override
                public boolean apply(GemmenJuminKihonDiv div) {
                    return SpecHelper.決定日の必須入力チェック(div);
                }
            },
    /**
     * 減免額の必須入力チェック
     */
    減免額の必須入力チェック {
                @Override
                public boolean apply(GemmenJuminKihonDiv div) {
                    return SpecHelper.減免額の必須入力チェック(div);
                }
            },
    /**
     * validate計算処理の未実行
     */
    計算処理の未実行チェック {
                @Override
                public boolean apply(GemmenJuminKihonDiv div) {
                    return true;
                }
            },
    /**
     * 決定日の必須入力チェック２
     */
    決定日の必須入力チェック２ {
                @Override
                public boolean apply(GemmenJuminKihonDiv div) {
                    return SpecHelper.決定日の必須入力チェック２(div);
                }
            };

    private static class SpecHelper {

        private static final RString 減免決定通知書 = new RString("保険料減免決定通知書");
        private static final RString カンマ = new RString(",");
        private static final RString 定値_ゼロ = new RString("0");
        private static final RString 状況_決定済 = new RString("決定済");

        public static boolean is未指定(GemmenJuminKihonDiv div) {
            PrintInfoDiv 発行パネル = div.getGemmenPrintinfo().getPrintInfo();
            boolean is減免決定通知書checked;
            boolean is取消決定通知書checked;
            if (減免決定通知書.equals(発行パネル.getPritPublish1().getTitle())) {
                is減免決定通知書checked = 発行パネル.getPritPublish1().isIsPublish() && 発行パネル.getPritPublish1().isVisible();
                is取消決定通知書checked = false;
            } else {
                is取消決定通知書checked = 発行パネル.getPritPublish1().isIsPublish() && 発行パネル.getPritPublish1().isVisible();
                is減免決定通知書checked = false;
            }
            boolean is変更通知書兼特徴checked = 発行パネル.getPritPublish2().isIsPublish() && 発行パネル.getPritPublish2().isVisible();
            boolean is納入通知書checked = 発行パネル.getPritPublish3().isIsPublish() && 発行パネル.getPritPublish3().isVisible();
            boolean is賦課台帳checked = 発行パネル.getPritPublish4().isIsPublish() && 発行パネル.getPritPublish4().isVisible();
            return is減免決定通知書checked || is取消決定通知書checked || is変更通知書兼特徴checked || is納入通知書checked || is賦課台帳checked;
        }

        public static boolean 減免額の整合性チェック(GemmenJuminKihonDiv div) {
            KiwarigakuDiv 減免情報パネル = div.getGemmenMain().getKiwarigaku();
            Decimal 減免額 = 減免情報パネル.getTxtGemmengaku().getValue();
            if (減免額 == null) {
                return true;
            }
            RString 普通徴収減免前_合計R = 減免情報パネル.getKiwarigakuPanel1().getLblFuchoGemmemMaeTotal().getText();
            Decimal 普通徴収減免前_合計 = 普通徴収減免前_合計R == null || 普通徴収減免前_合計R.isEmpty()
                    ? null : new Decimal(普通徴収減免前_合計R.replace(カンマ, RString.EMPTY).toString());
            RString 普通徴収減免後_合計R = 減免情報パネル.getKiwarigakuPanel1().getLblFuchoGemmemGoTotal().getText();
            Decimal 普通徴収減免後_合計 = 普通徴収減免後_合計R == null || 普通徴収減免後_合計R.isEmpty()
                    ? null : new Decimal(普通徴収減免後_合計R.replace(カンマ, RString.EMPTY).toString());
            RString 特別徴収減免前_合計R = 減免情報パネル.getKiwarigakuPanel1().getLblTokuchoGemmemMaeTotal().getText();
            Decimal 特別徴収減免前_合計 = 特別徴収減免前_合計R == null || 特別徴収減免前_合計R.isEmpty()
                    ? null : new Decimal(特別徴収減免前_合計R.replace(カンマ, RString.EMPTY).toString());
            RString 特別徴収減免後_合計R = 減免情報パネル.getKiwarigakuPanel1().getLblTokuchoGemmemGoTotal().getText();
            Decimal 特別徴収減免後_合計 = 特別徴収減免後_合計R == null || 特別徴収減免後_合計R.isEmpty()
                    ? null : new Decimal(特別徴収減免後_合計R.replace(カンマ, RString.EMPTY).toString());
            Decimal 減免額check = null;
            if (普通徴収減免前_合計 != null && 普通徴収減免後_合計 != null) {
                減免額check = 普通徴収減免前_合計.subtract(普通徴収減免後_合計);
            }
            if (特別徴収減免前_合計 != null && 特別徴収減免後_合計 != null) {
                if (減免額check == null) {
                    減免額check = 特別徴収減免前_合計.subtract(特別徴収減免後_合計);
                } else {
                    減免額check = 減免額check.add(特別徴収減免前_合計.subtract(特別徴収減免後_合計));
                }
            }
            return 減免額.equals(減免額check);
        }

        public static boolean 決定日の必須入力チェック(GemmenJuminKihonDiv div) {
            return !(div.getGemmenMain().getKiwarigaku().getTxtGemmengaku().getValue() != null
                    && div.getGemmenMain().getKeteiinfo().getTxtKetteiYMD() == null);
        }

        public static boolean 減免額の必須入力チェック(GemmenJuminKihonDiv div) {
            return !(div.getGemmenMain().getKeteiinfo().getTxtKetteiYMD() != null
                    && 定値_ゼロ.equals(div.getGemmenMain().getKeteiinfo().getRadKetteiKubun().getSelectedKey())
                    && div.getGemmenMain().getKiwarigaku().getTxtGemmengaku().getValue() == null);
        }

        public static boolean 決定日の必須入力チェック２(GemmenJuminKihonDiv div) {
            RString 状況 = div.getGemmenMain().getShinseiJokyo().getTxtShinseiJokyo().getValue();
            return !(状況_決定済.equals(状況) && div.getGemmenMain().getKeteiinfo().getTxtKetteiYMD() == null);
        }
    }
}
