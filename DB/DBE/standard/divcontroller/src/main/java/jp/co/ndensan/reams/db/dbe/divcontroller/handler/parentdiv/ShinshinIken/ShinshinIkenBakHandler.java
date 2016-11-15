/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.ShinshinIken;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem.ShujiiIkenshoIkenItemIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshokinyuitem.ShujiiIkenshoKinyuItemIdentifier;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShinshinIken.ShinshinIken.ShinshinIkenDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku02;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 心身の意見入力のHandlerクラスです。
 *
 * @reamsid_L DBE-3000-120 dongyabin
 */
public class ShinshinIkenBakHandler {

    private static final RString KEY_0 = new RString("key0");
    private static final RString KEY_1 = new RString("key1");
    private static final RString KEY_2 = new RString("key2");
    private static final RString KEY_3 = new RString("key3");
    private static final RString KEY_4 = new RString("key4");
    private static final RString KEY_5 = new RString("key5");
    private static final RString KEY_6 = new RString("key6");
    private static final RString KEY_7 = new RString("key7");
    private static final RString KEY_8 = new RString("key8");
    private static final RString KEY_9 = new RString("key9");
    private static final RString KEY_10 = new RString("key10");
    private static final int その他_記入項目 = 1;
    private static final int その他の精神神経症状_記入項目 = 2;
    private static final int 専門医受診の有無_記入項目 = 3;
    private static final int 身長_記入項目 = 4;
    private static final int 体重_記入項目 = 5;
    private static final int 四肢欠損_記入項目 = 6;
    private static final int 麻痺_その他_記入項目 = 7;
    private static final int 筋力の低下_記入項目 = 8;
    private static final int 関節の拘縮_記入項目 = 9;
    private static final int 関節の痛み_記入項目 = 10;
    private static final int じょくそう_記入項目 = 11;
    private static final int その他の皮膚疾患_記入項目 = 12;
    private static final int 寝たきり度 = 13;
    private static final int 認知症高齢者の日常生活自立度 = 14;
    private static final int 短期記憶 = 15;
    private static final int 認知能力 = 16;
    private static final int 伝達能力 = 17;
    private static final int 認知症の周辺症状 = 18;
    private static final int 幻視幻聴 = 19;
    private static final int 妄想 = 20;
    private static final int 昼夜逆転 = 21;
    private static final int 暴言 = 22;
    private static final int 暴行 = 23;
    private static final int 介護への抵抗 = 24;
    private static final int 徘徊 = 25;
    private static final int 火の不始末 = 26;
    private static final int 不潔行為 = 27;
    private static final int 異食行動 = 28;
    private static final int 性的問題行動 = 29;
    private static final int その他 = 30;
    private static final int その他の精神神経症状 = 31;
    private static final int 専門医受診の有無 = 32;
    private static final int 利き腕 = 33;
    private static final int 過去6カ月の体重の変化 = 34;
    private static final int 四肢欠損 = 35;
    private static final int 麻痺 = 36;
    private static final int 麻痺_右上肢 = 37;
    private static final int 麻痺_右上肢_程度 = 38;
    private static final int 麻痺_左上肢 = 39;
    private static final int 麻痺_左上肢_程度 = 40;
    private static final int 麻痺_右下肢 = 41;
    private static final int 麻痺_右下肢_程度 = 42;
    private static final int 麻痺_左下肢 = 43;
    private static final int 麻痺_左下肢_程度 = 44;
    private static final int 麻痺_その他 = 45;
    private static final int 麻痺_その他_程度 = 46;
    private static final int 筋力の低下 = 47;
    private static final int 筋力の低下_程度 = 48;
    private static final int 関節の拘縮 = 49;
    private static final int 関節の拘縮_程度 = 50;
    private static final int 関節の痛み = 51;
    private static final int 関節の痛み_程度 = 52;
    private static final int 失調_不随意運動 = 53;
    private static final int 失調_不随意運動_上肢_右 = 54;
    private static final int 失調_不随意運動_上肢_左 = 55;
    private static final int 失調_不随意運動_下肢_右 = 56;
    private static final int 失調_不随意運動_下肢_左 = 57;
    private static final int 失調_不随意運動_体幹_右 = 58;
    private static final int 失調_不随意運動_体幹_左 = 59;
    private static final int じょくそう = 60;
    private static final int じょくそう_程度 = 61;
    private static final int その他の皮膚疾患 = 62;
    private static final int その他の皮膚疾患_程度 = 63;
    private final ShinshinIkenDiv div;
    private final NinteiShinseiJoho 要介護認定申請情報;
    private final RString 管理番号;
    private final RString 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     * @param 要介護認定申請情報 要介護認定申請情報
     * @param 管理番号 管理番号
     * @param 履歴番号 履歴番号
     */
    public ShinshinIkenBakHandler(ShinshinIkenDiv div,
            NinteiShinseiJoho 要介護認定申請情報,
            RString 管理番号,
            RString 履歴番号) {
        this.div = div;
        this.要介護認定申請情報 = 要介護認定申請情報;
        this.管理番号 = 管理番号;
        this.履歴番号 = 履歴番号;
    }

    /**
     * 確定ボタンを押します。
     *
     * @return 要介護認定申請情報
     */
    public NinteiShinseiJoho onClickBtnKakutei() {
        return set呼び出し元画面への戻り値();
    }

    private NinteiShinseiJoho set呼び出し元画面への戻り値() {
        
        ShujiiIkenshoIraiJohoIdentifier 主治医意見書作成依頼情報Key = new ShujiiIkenshoIraiJohoIdentifier(new ShinseishoKanriNo(管理番号),
                Integer.valueOf(履歴番号.toString()));
        ShujiiIkenshoJohoIdentifier 要介護認定主治医意見書情報Key = new ShujiiIkenshoJohoIdentifier(new ShinseishoKanriNo(管理番号),
                Integer.valueOf(履歴番号.toString()));
            ShujiiIkenshoJoho 要介護認定主治医意見書情報 = 要介護認定申請情報.getShujiiIkenshoIraiJoho(主治医意見書作成依頼情報Key).
                    getSeishinTechoNini(要介護認定主治医意見書情報Key);

        set意見項目Emtpy(要介護認定主治医意見書情報, 寝たきり度);
        set意見項目(要介護認定主治医意見書情報, 寝たきり度, div.getRadShogaiKoreishaNichijoSeikatsuJiritsudo().getSelectedKey());
        
        set意見項目Emtpy(要介護認定主治医意見書情報, 認知症高齢者の日常生活自立度);
        set意見項目(要介護認定主治医意見書情報, 認知症高齢者の日常生活自立度, div.getRadNinchishoKoreishaJiritsu().getSelectedKey());

        set意見項目(要介護認定主治医意見書情報, 短期記憶, div.getRadTankiKioku().getSelectedKey());
        set意見項目(要介護認定主治医意見書情報, 認知能力, div.getRadNichijoNinchiNoryoku().getSelectedKey());
        set意見項目(要介護認定主治医意見書情報, 伝達能力, div.getRadIshiDentatsuNoryoku().getSelectedKey());
        set意見項目Emtpy(要介護認定主治医意見書情報, 認知症の周辺症状);
        set意見項目(要介護認定主治医意見書情報, 認知症の周辺症状, div.getRadNinchishoShuhenShojoUmu().getSelectedKey());
        
        if (div.getChkNinchishoShuhenShojo().getSelectedKeys().contains(KEY_0)) {
            set意見項目(要介護認定主治医意見書情報, 幻視幻聴, KEY_1);
        } else {
            set意見項目(要介護認定主治医意見書情報, 幻視幻聴, KEY_0);
        }
        if (div.getChkNinchishoShuhenShojo().getSelectedKeys().contains(KEY_1)) {
            set意見項目(要介護認定主治医意見書情報, 妄想, KEY_1);
        } else {
            set意見項目(要介護認定主治医意見書情報, 妄想, KEY_0);
        }
        if (div.getChkNinchishoShuhenShojo().getSelectedKeys().contains(KEY_2)) {
            set意見項目(要介護認定主治医意見書情報, 昼夜逆転, KEY_1);
        } else {
            set意見項目(要介護認定主治医意見書情報, 昼夜逆転, KEY_0);
        }
        if (div.getChkNinchishoShuhenShojo().getSelectedKeys().contains(KEY_3)) {
            set意見項目(要介護認定主治医意見書情報, 暴言, KEY_1);
        } else {
            set意見項目(要介護認定主治医意見書情報, 暴言, KEY_0);
        }
        if (div.getChkNinchishoShuhenShojo().getSelectedKeys().contains(KEY_4)) {
            set意見項目(要介護認定主治医意見書情報, 暴行, KEY_1);
        } else {
            set意見項目(要介護認定主治医意見書情報, 暴行, KEY_0);
        }
        if (div.getChkNinchishoShuhenShojo().getSelectedKeys().contains(KEY_5)) {
            set意見項目(要介護認定主治医意見書情報, 介護への抵抗, KEY_1);
        } else {
            set意見項目(要介護認定主治医意見書情報, 介護への抵抗, KEY_0);
        }
        if (div.getChkNinchishoShuhenShojo().getSelectedKeys().contains(KEY_6)) {
            set意見項目(要介護認定主治医意見書情報, 徘徊, KEY_1);
        } else {
            set意見項目(要介護認定主治医意見書情報, 徘徊, KEY_0);
        }
        if (div.getChkNinchishoShuhenShojo().getSelectedKeys().contains(KEY_7)) {
            set意見項目(要介護認定主治医意見書情報, 火の不始末, KEY_1);
        } else {
            set意見項目(要介護認定主治医意見書情報, 火の不始末, KEY_0);
        }
        if (div.getChkNinchishoShuhenShojo().getSelectedKeys().contains(KEY_8)) {
            set意見項目(要介護認定主治医意見書情報, 不潔行為, KEY_1);
        } else {
            set意見項目(要介護認定主治医意見書情報, 不潔行為, KEY_0);
        }
        if (div.getChkNinchishoShuhenShojo().getSelectedKeys().contains(KEY_9)) {
            set意見項目(要介護認定主治医意見書情報, 異食行動, KEY_1);
        } else {
            set意見項目(要介護認定主治医意見書情報, 異食行動, KEY_0);
        }
        if (div.getChkNinchishoShuhenShojo().getSelectedKeys().contains(KEY_10)) {
            set意見項目(要介護認定主治医意見書情報, 性的問題行動, KEY_1);
        } else {
            set意見項目(要介護認定主治医意見書情報, 性的問題行動, KEY_0);
        }
        set意見項目(要介護認定主治医意見書情報, その他, keyToItemNasiari(div.getChkNinchishoShuhenShojoSonota().getSelectedKeys()));
        set記入項目(要介護認定主治医意見書情報, その他_記入項目, div.getTxtSonotaKinyu().getValue());
        set意見項目Emtpy(要介護認定主治医意見書情報, その他の精神神経症状);
        set意見項目(要介護認定主治医意見書情報, その他の精神神経症状, div.getRadSonotaShojo().getSelectedKey());

        set記入項目(要介護認定主治医意見書情報, その他の精神神経症状_記入項目, div.getTxtShojomei().getValue());
        set意見項目Emtpy(要介護認定主治医意見書情報, 専門医受診の有無);
        set意見項目(要介護認定主治医意見書情報, 専門医受診の有無, div.getRadSenmonJushin().getSelectedKey());

        set記入項目(要介護認定主治医意見書情報, 専門医受診の有無_記入項目, div.getTxtShosaiTokkiJiko().getValue());
        set意見項目Emtpy(要介護認定主治医意見書情報, 利き腕);
        set意見項目(要介護認定主治医意見書情報, 利き腕, div.getRadKikiude().getSelectedKey());

        set記入項目(要介護認定主治医意見書情報, 身長_記入項目, div.getTxtShincho().getValue());
        set記入項目(要介護認定主治医意見書情報, 体重_記入項目, div.getTxtTaiju().getValue());
        set意見項目Emtpy(要介護認定主治医意見書情報, 過去6カ月の体重の変化);
        set意見項目(要介護認定主治医意見書情報, 過去6カ月の体重の変化, set過去6カ月の体重(div.getRadKakoTaijuHenka().getSelectedKey()));
        
        return set呼び出し元画面への戻り値_下();
    }

    private NinteiShinseiJoho set呼び出し元画面への戻り値_下() {
        ShujiiIkenshoIraiJohoIdentifier 主治医意見書作成依頼情報Key = new ShujiiIkenshoIraiJohoIdentifier(new ShinseishoKanriNo(管理番号),
                Integer.valueOf(履歴番号.toString()));
        ShujiiIkenshoJohoIdentifier 要介護認定主治医意見書情報Key = new ShujiiIkenshoJohoIdentifier(new ShinseishoKanriNo(管理番号),
                Integer.valueOf(履歴番号.toString()));
            ShujiiIkenshoJoho 要介護認定主治医意見書情報 = 要介護認定申請情報.getShujiiIkenshoIraiJoho(主治医意見書作成依頼情報Key).
                    getSeishinTechoNini(要介護認定主治医意見書情報Key);
        
        set意見項目(要介護認定主治医意見書情報, 四肢欠損, keyToItemNasiari(div.getChkShishiKesson().getSelectedKeys()));
        set記入項目(要介護認定主治医意見書情報, 四肢欠損_記入項目, div.getTxtShishiKessonBui().getValue());
        set意見項目(要介護認定主治医意見書情報, 麻痺, keyToItemNasiari(div.getChkMahi().getSelectedKeys()));
        set意見項目(要介護認定主治医意見書情報, 麻痺_右上肢, keyToItemNasiari(div.getChkMigiJoshiMahi().getSelectedKeys()));
        set意見項目Emtpy(要介護認定主治医意見書情報, 麻痺_右上肢_程度);
        set意見項目(要介護認定主治医意見書情報, 麻痺_右上肢_程度, div.getRadMigiJoshiMahiTeido().getSelectedKey());
        set意見項目(要介護認定主治医意見書情報, 麻痺_左上肢, keyToItemNasiari(div.getChkHidariJoshiMahi().getSelectedKeys()));
        set意見項目Emtpy(要介護認定主治医意見書情報, 麻痺_左上肢_程度);
        set意見項目(要介護認定主治医意見書情報, 麻痺_左上肢_程度, div.getRadHidariJoshiMahiTeido().getSelectedKey());
        set意見項目(要介護認定主治医意見書情報, 麻痺_右下肢, keyToItemNasiari(div.getChkMigiKashiMahi().getSelectedKeys()));
        set意見項目Emtpy(要介護認定主治医意見書情報, 麻痺_右下肢_程度);
        set意見項目(要介護認定主治医意見書情報, 麻痺_右下肢_程度, div.getRadMigiKashiMahiTeido().getSelectedKey());
        set意見項目(要介護認定主治医意見書情報, 麻痺_左下肢, keyToItemNasiari(div.getChkHidariKashiMahi().getSelectedKeys()));
        set意見項目Emtpy(要介護認定主治医意見書情報, 麻痺_左下肢_程度);
        set意見項目(要介護認定主治医意見書情報, 麻痺_左下肢_程度, div.getRadHidariKashiMahiTeido().getSelectedKey());
        set意見項目(要介護認定主治医意見書情報, 麻痺_その他, keyToItemNasiari(div.getChkSonotaMahi().getSelectedKeys()));
        set記入項目(要介護認定主治医意見書情報, 麻痺_その他_記入項目, div.getTxtSonotaMahiBui().getValue());
        set意見項目Emtpy(要介護認定主治医意見書情報, 麻痺_その他_程度);
        set意見項目(要介護認定主治医意見書情報, 麻痺_その他_程度, div.getRadSonotaMahiTeido().getSelectedKey());
        set意見項目(要介護認定主治医意見書情報, 筋力の低下, keyToItemNasiari(div.getChkKinryokuTeika().getSelectedKeys()));
        set記入項目(要介護認定主治医意見書情報, 筋力の低下_記入項目, div.getTxtKinryokuTeikaBui().getValue());
        set意見項目Emtpy(要介護認定主治医意見書情報, 筋力の低下_程度);
        set意見項目(要介護認定主治医意見書情報, 筋力の低下_程度, div.getRadKinryokuTeikaTeido().getSelectedKey());
        set意見項目(要介護認定主治医意見書情報, 関節の拘縮, keyToItemNasiari(div.getChkKansetsuKoshuku().getSelectedKeys()));
        set記入項目(要介護認定主治医意見書情報, 関節の拘縮_記入項目, div.getTxtKansetsuKoshukuBui().getValue());
        set意見項目Emtpy(要介護認定主治医意見書情報, 関節の拘縮_程度);
        set意見項目(要介護認定主治医意見書情報, 関節の拘縮_程度, div.getRadKansetsuKoshukuTeido().getSelectedKey());
        
        set意見項目(要介護認定主治医意見書情報, 関節の痛み, keyToItemNasiari(div.getChkKansetsuItami().getSelectedKeys()));
        set記入項目(要介護認定主治医意見書情報, 関節の痛み_記入項目, div.getTxtKansetsuItamiBui().getValue());
        set意見項目Emtpy(要介護認定主治医意見書情報, 関節の痛み_程度);
        set意見項目(要介護認定主治医意見書情報, 関節の痛み_程度, div.getRadKansetsuItamiTeido().getSelectedKey());

        set意見項目(要介護認定主治医意見書情報, 失調_不随意運動, keyToItemNasiari(div.getChkShicchoFuzuii().getSelectedKeys()));
        if (div.getChkFuzuiiJoshi().getSelectedKeys().contains(KEY_0)) {
            set意見項目(要介護認定主治医意見書情報, 失調_不随意運動_上肢_右, KEY_1);
        }
        if (div.getChkFuzuiiJoshi().getSelectedKeys().contains(KEY_1)) {
            set意見項目(要介護認定主治医意見書情報, 失調_不随意運動_上肢_左, KEY_1);
        }
        if (div.getChkFuzuiiKashi().getSelectedKeys().contains(KEY_0)) {
            set意見項目(要介護認定主治医意見書情報, 失調_不随意運動_下肢_右, KEY_1);
        }
        if (div.getChkFuzuiiKashi().getSelectedKeys().contains(KEY_1)) {
            set意見項目(要介護認定主治医意見書情報, 失調_不随意運動_下肢_左, KEY_1);
        }
        if (div.getChkTaikan().getSelectedKeys().contains(KEY_0)) {
            set意見項目(要介護認定主治医意見書情報, 失調_不随意運動_体幹_右, KEY_1);
        }
        if (div.getChkTaikan().getSelectedKeys().contains(KEY_1)) {
            set意見項目(要介護認定主治医意見書情報, 失調_不随意運動_体幹_左, KEY_1);
        }
        set意見項目(要介護認定主治医意見書情報, じょくそう, keyToItemNasiari(div.getChkJokuso().getSelectedKeys()));
        set記入項目(要介護認定主治医意見書情報, じょくそう_記入項目, div.getTxtJokusoBui().getValue());
        set意見項目Emtpy(要介護認定主治医意見書情報, じょくそう_程度);
        set意見項目(要介護認定主治医意見書情報, じょくそう_程度, div.getRadJokusoTeido().getSelectedKey());
        set意見項目(要介護認定主治医意見書情報, その他の皮膚疾患, keyToItemNasiari(div.getChkSonotaHifuShikkan().getSelectedKeys()));
        set記入項目(要介護認定主治医意見書情報, その他の皮膚疾患_記入項目, div.getTxtSonotaHifuShikkanBui().getValue());
        set意見項目Emtpy(要介護認定主治医意見書情報, その他の皮膚疾患_程度);
        set意見項目(要介護認定主治医意見書情報, その他の皮膚疾患_程度, div.getRadSonotaHifuShikkanTeido().getSelectedKey());
        
        要介護認定申請情報.createBuilderForEdit().setShujiiIkenshoIraiJoho(要介護認定申請情報.getShujiiIkenshoIraiJoho(主治医意見書作成依頼情報Key)
                .createBuilderForEdit().setShujiiIkenshoJoho(要介護認定主治医意見書情報).build());
        return 要介護認定申請情報;
    }

    private void set意見項目Emtpy(ShujiiIkenshoJoho 要介護認定主治医意見書情報_T, int 連番) {
        要介護認定主治医意見書情報_T.createBuilderForEdit().setShujiiIkenshoIkenItem(要介護認定主治医意見書情報_T
                .getShujiiIkenshoIkenItem(create意見項目の識別子(連番)).createBuilderForEdit().set意見項目(RString.EMPTY).build()).build();
    }

    private void set意見項目(ShujiiIkenshoJoho 要介護認定主治医意見書情報_T, int 連番, RString key) {
        要介護認定主治医意見書情報_T.createBuilderForEdit().setShujiiIkenshoIkenItem(要介護認定主治医意見書情報_T
                .getShujiiIkenshoIkenItem(create意見項目の識別子(連番)).createBuilderForEdit().set意見項目(keyToItem(key)).build()).build();
    }

    private void set記入項目(ShujiiIkenshoJoho 要介護認定主治医意見書情報_T, int 連番, RString key) {
        要介護認定主治医意見書情報_T.createBuilderForEdit().setShujiiIkenshoKinyuItem(要介護認定主治医意見書情報_T
                .getShujiiIkenshoKinyuItem(create記入項目の識別子(連番)).createBuilderForEdit().set記入項目(key).build()).build();
    }

    private ShujiiIkenshoIkenItemIdentifier create意見項目の識別子(int 連番) {
        return new ShujiiIkenshoIkenItemIdentifier(new ShinseishoKanriNo(管理番号), Integer.parseInt(履歴番号.toString()), 連番);
    }

    private ShujiiIkenshoKinyuItemIdentifier create記入項目の識別子(int 連番) {
        return new ShujiiIkenshoKinyuItemIdentifier(new ShinseishoKanriNo(管理番号), Integer.parseInt(履歴番号.toString()), 連番);
    }

    private RString keyToItem(RString key) {
        if (KEY_0.equals(key)) {
            return IkenKomoku02.自立.getコード();
        } else if (KEY_1.equals(key)) {
            return IkenKomoku02.J1.getコード();
        } else if (KEY_2.equals(key)) {
            return IkenKomoku02.J2.getコード();
        } else if (KEY_3.equals(key)) {
            return IkenKomoku02.A1.getコード();
        } else if (KEY_4.equals(key)) {
            return IkenKomoku02.A2.getコード();
        } else if (KEY_5.equals(key)) {
            return IkenKomoku02.B1.getコード();
        } else if (KEY_6.equals(key)) {
            return IkenKomoku02.B2.getコード();
        } else if (KEY_7.equals(key)) {
            return IkenKomoku02.C1.getコード();
        } else if (KEY_8.equals(key)) {
            return IkenKomoku02.C2.getコード();
        } else if (KEY_9.equals(key)) {
            return IkenKomoku02.未記入.getコード();
        } else {
            return IkenKomoku01.無.getコード();
        }
    }

    private RString keyToItemNasiari(List<RString> keys) {
        if (keys.contains(KEY_0)) {
            return KEY_1;
        }
        return KEY_0;
    }

    private RString set過去6カ月の体重(RString keys) {
        if (keys.contains(KEY_0)) {
            return KEY_0;
        } else if (keys.contains(KEY_1)) {
            return KEY_2;
        } else {
            return KEY_1;
        }
    }
}
