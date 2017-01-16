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
                    return !(div.getNinchishoShuhenShojo().getRadNinchishoShuhenShojoUmu()
                    .getSelectedKey().contains(KEY_2)
                    && div.getNinchishoShuhenShojo().getChkNinchishoShuhenShojo()
                    .getSelectedKeys().isEmpty()
                    && div.getNinchishoShuhenShojo().getChkNinchishoShuhenShojoSonota()
                    .getSelectedKeys().isEmpty());
                }
            },
    /**
     * 認知症周辺症状詳細チェックです。
     */
    認知症周辺症状詳細その他入力チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getNinchishoShuhenShojo().getChkNinchishoShuhenShojoSonota().getSelectedKeys().contains(KEY_0)
                    && div.getNinchishoShuhenShojo().getTxtSonotaKinyu().getValue().isEmpty());
                }
            },
    /**
     * その他の症状名チェックです。
     */
    その他の症状名チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getSonotaShojo().getRadSonotaShojo().getSelectedKey().contains(KEY_2)
                    && div.getSonotaShojo().getTxtShojomei().getValue().isEmpty());
                }
            },
    /**
     * 専門医受診詳細事項チェックです。
     */
    専門医受診詳細事項チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getSonotaShojo().getRadSenmonJushin().getSelectedKey().contains(KEY_2)
                    && div.getSonotaShojo().getTxtShosaiTokkiJiko().getValue().isEmpty());
                }
            },
    /**
     * 四肢欠損部位チェックです。
     */
    四肢欠損部位チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getKaradaJotai().getChkShishiKesson().getSelectedKeys().contains(KEY_0)
                    && div.getKaradaJotai().getTxtShishiKessonBui().getValue().isEmpty());
                }
            },
    /**
     * 麻痺チェックです。
     */
    麻痺チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getKaradaJotai().getChkShishiKesson().getSelectedKeys().contains(KEY_0)
                    && div.getKaradaJotai().getChkMigiJoshiMahi().getSelectedKeys().isEmpty()
                    && div.getKaradaJotai().getChkMigiKashiMahi().getSelectedKeys().isEmpty()
                    && div.getKaradaJotai().getChkHidariJoshiMahi().getSelectedKeys().isEmpty()
                    && div.getKaradaJotai().getChkHidariKashiMahi().getSelectedKeys().isEmpty()
                    && div.getKaradaJotai().getChkSonotaMahi().getSelectedKeys().isEmpty());
                }
            },
    /**
     * 麻痺右上肢程度チェックです。
     */
    麻痺右上肢程度チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getKaradaJotai().getChkMigiJoshiMahi().getSelectedKeys().contains(KEY_0)
                    && div.getKaradaJotai().getRadMigiJoshiMahiTeido().getSelectedKey().isEmpty());
                }
            },
    /**
     * 麻痺右下肢程度チェックです。
     */
    麻痺右下肢程度チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getKaradaJotai().getChkMigiKashiMahi().getSelectedKeys().contains(KEY_0)
                    && div.getKaradaJotai().getRadMigiKashiMahiTeido().getSelectedKey().isEmpty());
                }
            },
    /**
     * 麻痺左上肢程度チェックです。
     */
    麻痺左上肢程度チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getKaradaJotai().getChkHidariJoshiMahi().getSelectedKeys().contains(KEY_0)
                    && div.getKaradaJotai().getRadHidariJoshiMahiTeido().getSelectedKey().isEmpty());
                }
            },
    /**
     * 麻痺左下肢程度チェックです。
     */
    麻痺左下肢程度チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getKaradaJotai().getChkHidariKashiMahi().getSelectedKeys().contains(KEY_0)
                    && div.getKaradaJotai().getRadHidariKashiMahiTeido().getSelectedKey().isEmpty());
                }
            },
    /**
     * 麻痺その他程度チェックです。
     */
    麻痺その他部位程度チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getKaradaJotai().getChkSonotaMahi().getSelectedKeys().contains(KEY_0)
                    && div.getKaradaJotai().getRadSonotaMahiTeido().getSelectedKey().isEmpty());
                }
            },
    /**
     * その他部位チェックです。
     */
    その他部位チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getKaradaJotai().getChkSonotaMahi().getSelectedKeys().contains(KEY_0)
                    && div.getKaradaJotai().getTxtSonotaMahiBui().getValue().isEmpty());
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
     * 筋力の低下程度チェックです。
     */
    筋力の低下程度チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getChkKinryokuTeika().getSelectedKeys().contains(KEY_0)
                    && div.getRadKinryokuTeikaTeido().getSelectedKey().isEmpty());
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
     * 関節の拘縮程度ェックです。
     */
    関節の拘縮程度チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getChkKansetsuKoshuku().getSelectedKeys().contains(KEY_0)
                    && div.getRadKansetsuKoshukuTeido().getSelectedKey().isEmpty());
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
     * 関節の痛み程度チェックです。
     */
    関節の痛み程度チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getChkKansetsuItami().getSelectedKeys().contains(KEY_0)
                    && div.getRadKansetsuItamiTeido().getSelectedKey().isEmpty());
                }
            },
    /**
     * 失調・不随意運動詳細部位必須チェックです。
     */
    失調不随意運動詳細部位必須チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getChkShicchoFuzuii().getSelectedKeys().contains(KEY_0)
                    && div.getChkFuzuiiJoshi().getSelectedKeys().isEmpty()
                    && div.getChkFuzuiiKashi().getSelectedKeys().isEmpty()
                    && div.getChkTaikan().getSelectedKeys().isEmpty());
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
     * 褥瘡程度チェックです。
     */
    褥瘡程度チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getChkJokuso().getSelectedKeys().contains(KEY_0)
                    && div.getRadJokusoTeido().getSelectedKey().isEmpty());
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
            },
    /**
     * その他の皮膚疾患程度チェックです。
     */
    その他の皮膚疾患程度チェック {

                @Override
                public boolean apply(ShinshinIkenDiv div) {
                    return !(div.getChkSonotaHifuShikkan().getSelectedKeys().contains(KEY_0)
                    && div.getRadSonotaHifuShikkanTeido().getSelectedKey().isEmpty());
                }
            };

    private static final RString KEY_0 = new RString("key0");
    private static final RString KEY_1 = new RString("key1");
    private static final RString KEY_2 = new RString("key2");
}
