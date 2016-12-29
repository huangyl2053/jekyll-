/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.ShinshinIken;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShinshinIken.ShinshinIken.ShinshinIkenDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 心身の意見入力のチェック処理クラスです。
 */
public enum ShinshinIkenSpec implements IPredicate<ShinshinIkenDiv> {

    /**
     * 認知症周辺症状詳細チェックです。
     */
    認知症周辺症状詳細チェック {

                @Override
        public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getRadNinchishoShuhenShojoUmu().getSelectedKey().contains(KEY_0)
                            && div.getChkNinchishoShuhenShojo().getSelectedKeys().isEmpty()
                            && div.getChkNinchishoShuhenShojoSonota().getSelectedKeys().isEmpty());
}
            },
    /**
     * その他の症状名チェックです。
     */
    その他の症状名チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getChkNinchishoShuhenShojoSonota().getSelectedKeys().contains(KEY_0)
                            && div.getTxtSonotaKinyu().getValue().isEmpty());
                }
            },
    /**
     * 専門医受診詳細事項チェックです。
     */
    専門医受診詳細事項チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getRadSenmonJushin().getSelectedKey().contains(KEY_1)
                            && div.getTxtShosaiTokkiJiko().getValue().isEmpty());
                }
            },
    /**
     * 四肢欠損部位チェックです。
     */
    四肢欠損部位チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getChkShishiKesson().getSelectedKeys().contains(KEY_0)
                            && div.getTxtShishiKessonBui().getValue().isEmpty());
                }
            },
    /**
     * その他部位チェックです。
     */
    その他部位チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getChkSonotaMahi().getSelectedKeys().contains(KEY_0)
                            && div.getTxtSonotaMahiBui().getValue().isEmpty());
                }
            },
    /**
     * 筋力の低下部位チェックです。
     */
    筋力の低下部位チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getChkKinryokuTeika().getSelectedKeys().contains(KEY_0)
                            && div.getTxtKinryokuTeikaBui().getValue().isEmpty());
                }
            },
    /**
     * 関節の拘縮部位ェックです。
     */
    関節の拘縮部位チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getChkKansetsuKoshuku().getSelectedKeys().contains(KEY_0)
                            && div.getTxtKansetsuKoshukuBui().getValue().isEmpty());
                }
            },
    /**
     * 関節の痛み部位チェックです。
     */
    関節の痛み部位チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getChkKansetsuItami().getSelectedKeys().contains(KEY_0)
                            && div.getTxtKansetsuItamiBui().getValue().isEmpty());
                }
            },
    /**
     * 褥瘡部位チェックです。
     */
    褥瘡部位チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getChkJokuso().getSelectedKeys().contains(KEY_0)
                            && div.getTxtJokusoBui().getValue().isEmpty());
                }
            },
    /**
     * その他の皮膚疾患部位チェックです。
     */
    その他の皮膚疾患部位チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getChkSonotaHifuShikkan().getSelectedKeys().contains(KEY_0)
                    && div.getTxtSonotaHifuShikkanBui().getValue().isEmpty());
                }
            };

    private static final RString KEY_0 = new RString("key0");
    private static final RString KEY_1 = new RString("key1");
}
