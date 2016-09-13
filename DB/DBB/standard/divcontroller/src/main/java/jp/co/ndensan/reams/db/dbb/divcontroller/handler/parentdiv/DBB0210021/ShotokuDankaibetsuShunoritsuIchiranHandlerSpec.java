/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0210021;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210021.ShotokuDankaibetsuShunoritsuIchiranDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBB0210021_保険料段階別収納率一覧表作成のクラスです。
 *
 * @reamsid_L DBB-1630-010 wangxingpeng
 */
public enum ShotokuDankaibetsuShunoritsuIchiranHandlerSpec implements IPredicate<ShotokuDankaibetsuShunoritsuIchiranDiv> {

    /**
     * 年齢基準日必須項目チェック
     */
    年齢基準日必須項目チェック {
                @Override
                public boolean apply(ShotokuDankaibetsuShunoritsuIchiranDiv div) {
                    return SpecHelper.is年齢基準日必須項目チェック(div);
                }
            },
    /**
     * 基準年月必須項目チェック
     */
    基準年月必須項目チェック {
                @Override
                public boolean apply(ShotokuDankaibetsuShunoritsuIchiranDiv div) {
                    return SpecHelper.is基準年月必須項目チェック(div);
                }
            },
    /**
     * 生年月日年齢必須項目チェック
     */
    生年月日年齢必須項目チェック {
                @Override
                public boolean apply(ShotokuDankaibetsuShunoritsuIchiranDiv div) {
                    return SpecHelper.is生年月日年齢必須項目チェック(div);
                }
            };

    private static class SpecHelper {

        private static final RString NUM_1 = new RString("1");
        private static final RString 年齢 = new RString("nenrei");
        private static final RString 生年月 = new RString("umareYMD");

        public static boolean is年齢基準日必須項目チェック(ShotokuDankaibetsuShunoritsuIchiranDiv div) {
            RDate 年齢基準日 = div.getTxtNenreiKijunYMD().getValue();
            if (div.getRadNenrei().getSelectedKey().equals(年齢)) {
                return 年齢基準日 != null;
            }
            return true;
        }

        public static boolean is基準年月必須項目チェック(ShotokuDankaibetsuShunoritsuIchiranDiv div) {
            RString 基準年 = div.getDdlJukyuKijunY().getSelectedValue();
            RString 基準月 = div.getDdlJukyuKijunM().getSelectedValue();
            if (!(div.getRadChushutsuJoken().getSelectedKey().equals(NUM_1))) {
                return !(基準年.isNullOrEmpty() || 基準月.isNullOrEmpty());
            }
            return true;
        }

        public static boolean is生年月日年齢必須項目チェック(ShotokuDankaibetsuShunoritsuIchiranDiv div) {
            if (div.getRadNenrei().getSelectedKey().equals(年齢)) {
                return true;
            }
            return div.getRadUmareYMD().getSelectedKey().equals(生年月);
        }
    }
}
