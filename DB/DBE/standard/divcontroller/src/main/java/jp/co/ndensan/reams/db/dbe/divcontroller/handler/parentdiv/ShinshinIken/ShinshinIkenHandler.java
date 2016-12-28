/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.ShinshinIken;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem.ShujiiIkenshoIkenItem;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshokinyuitem.ShujiiIkenshoKinyuItem;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShinshinIken.ShinshinIken.ShinshinIkenDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku05;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku07;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku08;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku10;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 *
 * 心身の意見入力のHandlerクラスです。
 *
 * @reamsid_L DBE-3000-120 dongyabin
 */
public class ShinshinIkenHandler {

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
    private static final List<RString> チェックボックス_SELECT = new ArrayList<>();
    private final ShinshinIkenDiv div;
    private final NinteiShinseiJoho 要介護認定申請情報;
    private final RString 管理番号;
    private final RString 履歴番号;
    private final ShujiiIkenshoIraiJohoIdentifier 主治医意見書作成依頼情報Key;
    private final ShujiiIkenshoJohoIdentifier 要介護認定主治医意見書情報Key;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     * @param 要介護認定申請情報 要介護認定申請情報
     * @param 管理番号 管理番号
     * @param 履歴番号 履歴番号
     */
    public ShinshinIkenHandler(ShinshinIkenDiv div,
            NinteiShinseiJoho 要介護認定申請情報,
            RString 管理番号,
            RString 履歴番号) {
        this.div = div;
        this.要介護認定申請情報 = 要介護認定申請情報;
        this.管理番号 = 管理番号;
        this.履歴番号 = 履歴番号;
        主治医意見書作成依頼情報Key = new ShujiiIkenshoIraiJohoIdentifier(new ShinseishoKanriNo(管理番号),
                Integer.valueOf(履歴番号.toString()));
        要介護認定主治医意見書情報Key = new ShujiiIkenshoJohoIdentifier(new ShinseishoKanriNo(管理番号),
                Integer.valueOf(履歴番号.toString()));
    }

    /**
     * 心身の意見入力の初期化処理です。
     *
     */
    public void onLoad() {
        if (要介護認定申請情報 != null) {
            if (要介護認定申請情報.getShujiiIkenshoIraiJoho(主治医意見書作成依頼情報Key).
                    getShujiiIkenshoJohoList().isEmpty()) {
                要介護認定申請情報.getShujiiIkenshoIraiJoho(主治医意見書作成依頼情報Key).createBuilderForEdit().
                        setShujiiIkenshoJoho(new ShujiiIkenshoJoho(new ShinseishoKanriNo(管理番号), Integer.parseInt(履歴番号.toString())));
            }
            ShujiiIkenshoJoho 要介護認定主治医意見書情報 = 要介護認定申請情報.getShujiiIkenshoIraiJoho(主治医意見書作成依頼情報Key).
                    getSeishinTechoNini(要介護認定主治医意見書情報Key);
            if (要介護認定主治医意見書情報 != null) {
                List<ShujiiIkenshoKinyuItem> 記入項目List = 要介護認定主治医意見書情報.getShujiiIkenshoKinyuItemList();
                List<ShujiiIkenshoIkenItem> 意見項目List = 要介護認定主治医意見書情報.getShujiiIkenshoIkenItemList();
                set意見項目(意見項目List);
                set記入項目(記入項目List);
                for (ShujiiIkenshoIkenItem 意見項目 : 意見項目List) {
                    要介護認定主治医意見書情報 = 要介護認定主治医意見書情報.createBuilderForEdit().setShujiiIkenshoIkenItem(意見項目).build();
                }
                for (ShujiiIkenshoKinyuItem 記入項目 : 記入項目List) {
                    要介護認定主治医意見書情報 = 要介護認定主治医意見書情報.createBuilderForEdit().setShujiiIkenshoKinyuItem(記入項目).build();
                }
            }

            ViewStateHolder.put(ViewStateKeys.意見書情報, 要介護認定申請情報);
        }
    }

    /**
     * 初期化の場合、画面に選択の値を設定します。
     */
    public void setSelectKey() {
        div.setSelectKeys(getSelectKey());
    }

    /**
     * 認知症周辺症状ラジオボタンのChange処理です。
     */
    public void changeRadNinchishoShuhenShojoUmu() {
        if (div.getRadNinchishoShuhenShojoUmu().getSelectedKey().equals(KEY_1)) {
            div.getChkNinchishoShuhenShojo().setReadOnly(false);
            div.getChkNinchishoShuhenShojoSonota().setReadOnly(false);
            ShujiiIkenshoJoho 要介護認定主治医意見書情報 = 要介護認定申請情報.getShujiiIkenshoIraiJoho(主治医意見書作成依頼情報Key).
                    getSeishinTechoNini(要介護認定主治医意見書情報Key);
            set幻視幻聴(要介護認定主治医意見書情報.getShujiiIkenshoIkenItemList());
            setその他(要介護認定主治医意見書情報.getShujiiIkenshoIkenItemList());
            setその他記入項目(要介護認定主治医意見書情報.getShujiiIkenshoKinyuItemList());
        } else if (div.getRadNinchishoShuhenShojoUmu().getSelectedKey().equals(KEY_0)) {
            div.getChkNinchishoShuhenShojo().setReadOnly(true);
            div.getChkNinchishoShuhenShojoSonota().setReadOnly(true);
            div.getTxtSonotaKinyu().setReadOnly(true);
            div.getChkNinchishoShuhenShojo().setSelectedItemsByKey(チェックボックス_SELECT);
            div.getChkNinchishoShuhenShojoSonota().setSelectedItemsByKey(チェックボックス_SELECT);
            div.getTxtSonotaKinyu().clearValue();
        }
    }

    /**
     * その他認知症周辺症状チェックボックスのChange処理です。
     */
    public void changeChkNinchishoShuhenShojoSonota() {
        if (div.getChkNinchishoShuhenShojoSonota().getSelectedKeys().contains(KEY_0)) {
            div.getTxtSonotaKinyu().setReadOnly(false);
            ShujiiIkenshoJoho 要介護認定主治医意見書情報 = 要介護認定申請情報.getShujiiIkenshoIraiJoho(主治医意見書作成依頼情報Key).
                    getSeishinTechoNini(要介護認定主治医意見書情報Key);
            setその他記入項目(要介護認定主治医意見書情報.getShujiiIkenshoKinyuItemList());
        } else {
            div.getTxtSonotaKinyu().setReadOnly(true);
            div.getTxtSonotaKinyu().clearValue();
        }
    }

    /**
     * その他の精神神経症状チェックボックスのChange処理です。
     */
    public void changeRadSonotaShojo() {
        if (div.getRadSonotaShojo().getSelectedKey().equals(KEY_1)) {
            div.getTxtShojomei().setReadOnly(false);
            div.getRadSenmonJushin().setReadOnly(false);
            ShujiiIkenshoJoho 要介護認定主治医意見書情報 = 要介護認定申請情報.getShujiiIkenshoIraiJoho(主治医意見書作成依頼情報Key).
                    getSeishinTechoNini(要介護認定主治医意見書情報Key);
            setその他の精神神経症状記入項目(要介護認定主治医意見書情報.getShujiiIkenshoKinyuItemList());
            set専門医受診の有無(要介護認定主治医意見書情報.getShujiiIkenshoIkenItemList());
            set専門医受診の有無記入項目(要介護認定主治医意見書情報.getShujiiIkenshoKinyuItemList());
        } else if (div.getRadSonotaShojo().getSelectedKey().equals(KEY_0)) {
            div.getTxtShojomei().setReadOnly(true);
            div.getRadSenmonJushin().setReadOnly(true);
            div.getTxtShosaiTokkiJiko().setReadOnly(true);
            div.getTxtShojomei().clearValue();
            div.getRadSenmonJushin().clearSelectedItem();
            div.getTxtShosaiTokkiJiko().clearValue();
        }
    }

    /**
     * 専門医受診の有無ラジオボタンのChange処理です。
     */
    public void changeRadSenmonJushin() {
        if (div.getRadSenmonJushin().getSelectedKey().equals(KEY_1)) {
            div.getTxtShosaiTokkiJiko().setReadOnly(false);
            ShujiiIkenshoJoho 要介護認定主治医意見書情報 = 要介護認定申請情報.getShujiiIkenshoIraiJoho(主治医意見書作成依頼情報Key).
                    getSeishinTechoNini(要介護認定主治医意見書情報Key);
            set専門医受診の有無記入項目(要介護認定主治医意見書情報.getShujiiIkenshoKinyuItemList());
        } else if (div.getRadSenmonJushin().getSelectedKey().equals(KEY_0)) {
            div.getTxtShosaiTokkiJiko().setReadOnly(true);
            div.getTxtShosaiTokkiJiko().clearValue();
        }
    }

    /**
     * 四肢欠損チェックボックスのChange処理です。
     */
    public void changeChkShishiKesson() {
        if (div.getChkShishiKesson().getSelectedKeys().contains(KEY_0)) {
            div.getTxtShishiKessonBui().setReadOnly(false);
            ShujiiIkenshoJoho 要介護認定主治医意見書情報 = 要介護認定申請情報.getShujiiIkenshoIraiJoho(主治医意見書作成依頼情報Key).
                    getSeishinTechoNini(要介護認定主治医意見書情報Key);
            set四肢欠損記入項目(要介護認定主治医意見書情報.getShujiiIkenshoKinyuItemList());
        } else {
            div.getTxtShishiKessonBui().setReadOnly(true);
            div.getTxtShishiKessonBui().clearValue();
        }
    }

    /**
     * 麻痺チェックボックスのChange処理です。
     */
    public void changeChkMahi() {
        if (div.getChkMahi().getSelectedKeys().contains(KEY_0)) {
            div.getChkMigiJoshiMahi().setReadOnly(false);
            div.getChkHidariJoshiMahi().setReadOnly(false);
            div.getChkMigiKashiMahi().setReadOnly(false);
            div.getChkHidariKashiMahi().setReadOnly(false);
            div.getChkSonotaMahi().setReadOnly(false);
            ShujiiIkenshoJoho 要介護認定主治医意見書情報 = 要介護認定申請情報.getShujiiIkenshoIraiJoho(主治医意見書作成依頼情報Key).
                    getSeishinTechoNini(要介護認定主治医意見書情報Key);
            set麻痺_右上肢(要介護認定主治医意見書情報.getShujiiIkenshoIkenItemList());
            set麻痺_左上肢(要介護認定主治医意見書情報.getShujiiIkenshoIkenItemList());
            set麻痺_右下肢(要介護認定主治医意見書情報.getShujiiIkenshoIkenItemList());
            set麻痺_左下肢(要介護認定主治医意見書情報.getShujiiIkenshoIkenItemList());
            set麻痺_その他(要介護認定主治医意見書情報.getShujiiIkenshoIkenItemList());
        } else {
            div.getRadMigiJoshiMahiTeido().setReadOnly(true);
            div.getRadHidariJoshiMahiTeido().setReadOnly(true);
            div.getRadMigiKashiMahiTeido().setReadOnly(true);
            div.getRadHidariKashiMahiTeido().setReadOnly(true);
            div.getRadSonotaMahiTeido().setReadOnly(true);
            div.getTxtSonotaMahiBui().setReadOnly(true);
            div.getChkMigiJoshiMahi().setReadOnly(true);
            div.getChkHidariJoshiMahi().setReadOnly(true);
            div.getChkMigiKashiMahi().setReadOnly(true);
            div.getChkHidariKashiMahi().setReadOnly(true);
            div.getChkSonotaMahi().setReadOnly(true);
            div.getChkMigiJoshiMahi().setSelectedItemsByKey(チェックボックス_SELECT);
            div.getChkHidariJoshiMahi().setSelectedItemsByKey(チェックボックス_SELECT);
            div.getChkMigiKashiMahi().setSelectedItemsByKey(チェックボックス_SELECT);
            div.getChkHidariKashiMahi().setSelectedItemsByKey(チェックボックス_SELECT);
            div.getChkSonotaMahi().setSelectedItemsByKey(チェックボックス_SELECT);
            div.getRadMigiJoshiMahiTeido().clearSelectedItem();
            div.getRadHidariJoshiMahiTeido().clearSelectedItem();
            div.getRadMigiKashiMahiTeido().clearSelectedItem();
            div.getRadHidariKashiMahiTeido().clearSelectedItem();
            div.getRadSonotaMahiTeido().clearSelectedItem();
            div.getTxtSonotaMahiBui().clearValue();
        }
    }

    /**
     * 右上肢チェックボックスのChange処理です。
     */
    public void changeChkMigiJoshiMahi() {
        if (div.getChkMigiJoshiMahi().getSelectedKeys().contains(KEY_0)) {
            div.getRadMigiJoshiMahiTeido().setReadOnly(false);
            ShujiiIkenshoJoho 要介護認定主治医意見書情報 = 要介護認定申請情報.getShujiiIkenshoIraiJoho(主治医意見書作成依頼情報Key).
                    getSeishinTechoNini(要介護認定主治医意見書情報Key);
            set麻痺_右上肢_程度(要介護認定主治医意見書情報.getShujiiIkenshoIkenItemList());
        } else {
            div.getRadMigiJoshiMahiTeido().setReadOnly(true);
            div.getRadMigiJoshiMahiTeido().clearSelectedItem();
        }
    }

    /**
     * 左上肢チェックボックスのChange処理です。
     */
    public void changeChkHidariJoshiMahi() {
        if (div.getChkHidariJoshiMahi().getSelectedKeys().contains(KEY_0)) {
            div.getRadHidariJoshiMahiTeido().setReadOnly(false);
            ShujiiIkenshoJoho 要介護認定主治医意見書情報 = 要介護認定申請情報.getShujiiIkenshoIraiJoho(主治医意見書作成依頼情報Key).
                    getSeishinTechoNini(要介護認定主治医意見書情報Key);
            set麻痺_左上肢_程度(要介護認定主治医意見書情報.getShujiiIkenshoIkenItemList());
        } else {
            div.getRadHidariJoshiMahiTeido().setReadOnly(true);
            div.getRadHidariJoshiMahiTeido().clearSelectedItem();
        }
    }

    /**
     * 右下肢チェックボックスのChange処理です。
     */
    public void changeChkMigiKashiMahi() {
        if (div.getChkMigiKashiMahi().getSelectedKeys().contains(KEY_0)) {
            div.getRadMigiKashiMahiTeido().setReadOnly(false);
            ShujiiIkenshoJoho 要介護認定主治医意見書情報 = 要介護認定申請情報.getShujiiIkenshoIraiJoho(主治医意見書作成依頼情報Key).
                    getSeishinTechoNini(要介護認定主治医意見書情報Key);
            set麻痺_右下肢_程度(要介護認定主治医意見書情報.getShujiiIkenshoIkenItemList());
        } else {
            div.getRadMigiKashiMahiTeido().setReadOnly(true);
            div.getRadMigiKashiMahiTeido().clearSelectedItem();
        }
    }

    /**
     * 左下肢チェックボックスのChange処理です。
     */
    public void changeChkHidariKashiMahi() {
        if (div.getChkHidariKashiMahi().getSelectedKeys().contains(KEY_0)) {
            div.getRadHidariKashiMahiTeido().setReadOnly(false);
            ShujiiIkenshoJoho 要介護認定主治医意見書情報 = 要介護認定申請情報.getShujiiIkenshoIraiJoho(主治医意見書作成依頼情報Key).
                    getSeishinTechoNini(要介護認定主治医意見書情報Key);
            set麻痺_左下肢_程度(要介護認定主治医意見書情報.getShujiiIkenshoIkenItemList());
        } else {
            div.getRadHidariKashiMahiTeido().setReadOnly(true);
            div.getRadHidariKashiMahiTeido().clearSelectedItem();
        }
    }

    /**
     * その他麻痺チェックボックスのChange処理です。
     */
    public void changeChkSonotaMahi() {
        if (div.getChkSonotaMahi().getSelectedKeys().contains(KEY_0)) {
            div.getTxtSonotaMahiBui().setReadOnly(false);
            div.getRadSonotaMahiTeido().setReadOnly(false);
            ShujiiIkenshoJoho 要介護認定主治医意見書情報 = 要介護認定申請情報.getShujiiIkenshoIraiJoho(主治医意見書作成依頼情報Key).
                    getSeishinTechoNini(要介護認定主治医意見書情報Key);
            set麻痺_その他記入項目(要介護認定主治医意見書情報.getShujiiIkenshoKinyuItemList());
            set麻痺_その他_程度(要介護認定主治医意見書情報.getShujiiIkenshoIkenItemList());
        } else {
            div.getRadSonotaMahiTeido().setReadOnly(true);
            div.getTxtSonotaMahiBui().setReadOnly(true);
            div.getRadSonotaMahiTeido().clearSelectedItem();
            div.getTxtSonotaMahiBui().clearValue();
        }
    }

    /**
     * 筋力の低下チェックボックスのChange処理です。
     */
    public void changeChkKinryokuTeika() {
        if (div.getChkKinryokuTeika().getSelectedKeys().contains(KEY_0)) {
            div.getTxtKinryokuTeikaBui().setReadOnly(false);
            div.getRadKinryokuTeikaTeido().setReadOnly(false);
            ShujiiIkenshoJoho 要介護認定主治医意見書情報 = 要介護認定申請情報.getShujiiIkenshoIraiJoho(主治医意見書作成依頼情報Key).
                    getSeishinTechoNini(要介護認定主治医意見書情報Key);
            set筋力の低下記入項目(要介護認定主治医意見書情報.getShujiiIkenshoKinyuItemList());
            set筋力の低下_程度(要介護認定主治医意見書情報.getShujiiIkenshoIkenItemList());
        } else {
            div.getRadKinryokuTeikaTeido().setReadOnly(true);
            div.getRadKinryokuTeikaTeido().clearSelectedItem();
            div.getTxtKinryokuTeikaBui().setReadOnly(true);
            div.getTxtKinryokuTeikaBui().clearValue();
        }
    }

    /**
     * 関節の拘縮チェックボックスのChange処理です。
     */
    public void changeChkKansetsuKoshuku() {
        if (div.getChkKansetsuKoshuku().getSelectedKeys().contains(KEY_0)) {
            div.getTxtKansetsuKoshukuBui().setReadOnly(false);
            div.getRadKansetsuKoshukuTeido().setReadOnly(false);
            ShujiiIkenshoJoho 要介護認定主治医意見書情報 = 要介護認定申請情報.getShujiiIkenshoIraiJoho(主治医意見書作成依頼情報Key).
                    getSeishinTechoNini(要介護認定主治医意見書情報Key);
            set関節の拘縮記入項目(要介護認定主治医意見書情報.getShujiiIkenshoKinyuItemList());
            set関節の拘縮_程度(要介護認定主治医意見書情報.getShujiiIkenshoIkenItemList());
        } else {
            div.getTxtKansetsuKoshukuBui().setReadOnly(true);
            div.getRadKansetsuKoshukuTeido().setReadOnly(true);
            div.getTxtKansetsuKoshukuBui().clearValue();
            div.getRadKansetsuKoshukuTeido().clearSelectedItem();
        }
    }

    /**
     * 関節の痛みチェックボックスのChange処理です。
     */
    public void changeChkKansetsuItami() {
        if (div.getChkKansetsuItami().getSelectedKeys().contains(KEY_0)) {
            div.getTxtKansetsuItamiBui().setReadOnly(false);
            div.getRadKansetsuItamiTeido().setReadOnly(false);
            ShujiiIkenshoJoho 要介護認定主治医意見書情報 = 要介護認定申請情報.getShujiiIkenshoIraiJoho(主治医意見書作成依頼情報Key).
                    getSeishinTechoNini(要介護認定主治医意見書情報Key);
            set関節の痛み記入項目(要介護認定主治医意見書情報.getShujiiIkenshoKinyuItemList());
            set関節の痛み_程度(要介護認定主治医意見書情報.getShujiiIkenshoIkenItemList());
        } else {
            div.getTxtKansetsuItamiBui().setReadOnly(true);
            div.getRadKansetsuItamiTeido().setReadOnly(true);
            div.getTxtKansetsuItamiBui().clearValue();
            div.getRadKansetsuItamiTeido().clearSelectedItem();
        }
    }

    /**
     * 失調不随意運動チェックボックスのChange処理です。
     */
    public void changeChkShicchoFuzuii() {
        if (div.getChkShicchoFuzuii().getSelectedKeys().contains(KEY_0)) {
            div.getChkFuzuiiJoshi().setReadOnly(false);
            div.getChkFuzuiiKashi().setReadOnly(false);
            div.getChkTaikan().setReadOnly(false);
            ShujiiIkenshoJoho 要介護認定主治医意見書情報 = 要介護認定申請情報.getShujiiIkenshoIraiJoho(主治医意見書作成依頼情報Key).
                    getSeishinTechoNini(要介護認定主治医意見書情報Key);
            set失調不随意運動_上肢(要介護認定主治医意見書情報.getShujiiIkenshoIkenItemList());
            set失調不随意運動_下肢(要介護認定主治医意見書情報.getShujiiIkenshoIkenItemList());
            set失調不随意運動_体幹(要介護認定主治医意見書情報.getShujiiIkenshoIkenItemList());
        } else {
            div.getChkFuzuiiJoshi().setReadOnly(true);
            div.getChkFuzuiiKashi().setReadOnly(true);
            div.getChkTaikan().setReadOnly(true);
            div.getChkFuzuiiJoshi().setSelectedItemsByKey(チェックボックス_SELECT);
            div.getChkFuzuiiKashi().setSelectedItemsByKey(チェックボックス_SELECT);
            div.getChkTaikan().setSelectedItemsByKey(チェックボックス_SELECT);
        }
    }

    /**
     * 褥瘡チェックボックスのChange処理です。
     */
    public void changeChkJokuso() {
        if (div.getChkJokuso().getSelectedKeys().contains(KEY_0)) {
            div.getTxtJokusoBui().setReadOnly(false);
            div.getRadJokusoTeido().setReadOnly(false);
            ShujiiIkenshoJoho 要介護認定主治医意見書情報 = 要介護認定申請情報.getShujiiIkenshoIraiJoho(主治医意見書作成依頼情報Key).
                    getSeishinTechoNini(要介護認定主治医意見書情報Key);
            set褥瘡記入項目(要介護認定主治医意見書情報.getShujiiIkenshoKinyuItemList());
            set褥瘡_程度(要介護認定主治医意見書情報.getShujiiIkenshoIkenItemList());
        } else {
            div.getTxtJokusoBui().setReadOnly(true);
            div.getRadJokusoTeido().setReadOnly(true);
            div.getTxtJokusoBui().clearValue();
            div.getRadJokusoTeido().clearSelectedItem();
        }
    }

    /**
     * その他皮膚疾患チェックボックスのChange処理です。
     */
    public void changeChkSonotaHifuShikkan() {
        if (div.getChkSonotaHifuShikkan().getSelectedKeys().contains(KEY_0)) {
            div.getTxtSonotaHifuShikkanBui().setReadOnly(false);
            div.getRadSonotaHifuShikkanTeido().setReadOnly(false);
            ShujiiIkenshoJoho 要介護認定主治医意見書情報 = 要介護認定申請情報.getShujiiIkenshoIraiJoho(主治医意見書作成依頼情報Key).
                    getSeishinTechoNini(要介護認定主治医意見書情報Key);
            setその他の皮膚疾患記入項目(要介護認定主治医意見書情報.getShujiiIkenshoKinyuItemList());
            setその他の皮膚疾患_程度(要介護認定主治医意見書情報.getShujiiIkenshoIkenItemList());
        } else {
            div.getTxtSonotaHifuShikkanBui().setReadOnly(true);
            div.getRadSonotaHifuShikkanTeido().setReadOnly(true);
            div.getTxtSonotaHifuShikkanBui().clearValue();
            div.getRadSonotaHifuShikkanTeido().clearSelectedItem();
        }
    }

    /**
     * 画面選択の値の設定します。
     *
     * @return 画面選択の値
     */
    public RString getSelectKey() {
        RStringBuilder 画面選択の値 = new RStringBuilder();
        画面選択の値.append(div.getRadShogaiKoreishaNichijoSeikatsuJiritsudo().getSelectedKey())
                .append(div.getRadNinchishoKoreishaJiritsu().getSelectedKey())
                .append(div.getRadTankiKioku().getSelectedKey())
                .append(div.getRadNichijoNinchiNoryoku().getSelectedKey())
                .append(div.getRadIshiDentatsuNoryoku().getSelectedKey())
                .append(div.getRadNinchishoShuhenShojoUmu().getSelectedKey())
                .append(div.getChkNinchishoShuhenShojo().getSelectedKeys())
                .append(div.getChkNinchishoShuhenShojoSonota().getSelectedKeys())
                .append(div.getTxtSonotaKinyu().getValue())
                .append(div.getRadSonotaShojo().getSelectedKey())
                .append(div.getTxtShojomei().getValue())
                .append(div.getRadSenmonJushin().getSelectedKey())
                .append(div.getTxtShosaiTokkiJiko().getValue())
                .append(div.getRadKikiude().getSelectedKey())
                .append(div.getTxtShincho().getValue())
                .append(div.getTxtTaiju().getValue())
                .append(div.getRadKakoTaijuHenka().getSelectedKey())
                .append(div.getChkShishiKesson().getSelectedKeys())
                .append(div.getTxtShishiKessonBui().getValue())
                .append(div.getChkMahi().getSelectedKeys())
                .append(div.getChkMigiJoshiMahi().getSelectedKeys())
                .append(div.getRadMigiJoshiMahiTeido().getSelectedKey())
                .append(div.getChkHidariJoshiMahi().getSelectedKeys())
                .append(div.getRadHidariJoshiMahiTeido().getSelectedKey())
                .append(div.getChkMigiKashiMahi().getSelectedKeys())
                .append(div.getRadMigiKashiMahiTeido().getSelectedKey())
                .append(div.getChkHidariKashiMahi().getSelectedKeys())
                .append(div.getRadHidariKashiMahiTeido().getSelectedKey())
                .append(div.getChkSonotaMahi().getSelectedKeys())
                .append(div.getTxtSonotaMahiBui().getValue())
                .append(div.getRadSonotaMahiTeido().getSelectedKey())
                .append(div.getChkKinryokuTeika().getSelectedKeys())
                .append(div.getTxtKinryokuTeikaBui().getValue())
                .append(div.getRadKinryokuTeikaTeido().getSelectedKey())
                .append(div.getChkKansetsuKoshuku().getSelectedKeys())
                .append(div.getTxtKansetsuKoshukuBui().getValue())
                .append(div.getRadKansetsuKoshukuTeido().getSelectedKey())
                .append(div.getChkKansetsuItami().getSelectedKeys())
                .append(div.getTxtKansetsuItamiBui().getValue())
                .append(div.getRadKansetsuItamiTeido().getSelectedKey())
                .append(div.getChkShicchoFuzuii().getSelectedKeys())
                .append(div.getChkFuzuiiJoshi().getSelectedKeys())
                .append(div.getChkFuzuiiKashi().getSelectedKeys())
                .append(div.getChkTaikan().getSelectedKeys())
                .append(div.getChkJokuso().getSelectedKeys())
                .append(div.getTxtJokusoBui().getValue())
                .append(div.getRadJokusoTeido().getSelectedKey())
                .append(div.getChkSonotaHifuShikkan().getSelectedKeys())
                .append(div.getTxtSonotaHifuShikkanBui().getValue())
                .append(div.getRadSonotaHifuShikkanTeido().getSelectedKey());
        return 画面選択の値.toRString();
    }

    private void set意見項目(List<ShujiiIkenshoIkenItem> 意見項目List) {
        if (意見項目List.isEmpty()
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(意見項目List.get(0).get厚労省IF識別コード().getColumnValue())) {
            set障害高齢者の日常生活自立度(意見項目List);
            set認知症高齢者の日常生活自立度(意見項目List);
            set短期記憶(意見項目List);
            set認知能力(意見項目List);
            set伝達能力(意見項目List);
            set認知症の周辺症状(意見項目List);
            set幻視幻聴(意見項目List);
            setその他(意見項目List);
            setその他の精神神経症状(意見項目List);
            set専門医受診の有無(意見項目List);
            set利き腕(意見項目List);
            set過去6カ月の体重の変化(意見項目List);
            set四肢欠損(意見項目List);
            set麻痺(意見項目List);
            set麻痺_右上肢(意見項目List);
            set麻痺_右上肢_程度(意見項目List);
            set麻痺_左上肢(意見項目List);
            set麻痺_左上肢_程度(意見項目List);
            set麻痺_右下肢(意見項目List);
            set麻痺_右下肢_程度(意見項目List);
            set麻痺_左下肢(意見項目List);
            set麻痺_左下肢_程度(意見項目List);
            set麻痺_その他(意見項目List);
            set麻痺_その他_程度(意見項目List);
            set筋力の低下(意見項目List);
            set筋力の低下_程度(意見項目List);
            set関節の拘縮(意見項目List);
            set関節の拘縮_程度(意見項目List);
            set関節の痛み(意見項目List);
            set関節の痛み_程度(意見項目List);
            set失調不随意運動(意見項目List);
            set失調不随意運動_上肢(意見項目List);
            set失調不随意運動_下肢(意見項目List);
            set失調不随意運動_体幹(意見項目List);
            set褥瘡(意見項目List);
            set褥瘡_程度(意見項目List);
            setその他の皮膚疾患(意見項目List);
            setその他の皮膚疾患_程度(意見項目List);
        }
    }

    private void set記入項目(List<ShujiiIkenshoKinyuItem> 記入項目List) {
        if (記入項目List.isEmpty()
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(記入項目List.get(0).get厚労省IF識別コード().getColumnValue())) {
            setその他記入項目(記入項目List);
            setその他の精神神経症状記入項目(記入項目List);
            set専門医受診の有無記入項目(記入項目List);
            set身長(記入項目List);
            set体重(記入項目List);
            set四肢欠損記入項目(記入項目List);
            set麻痺_その他記入項目(記入項目List);
            set筋力の低下記入項目(記入項目List);
            set関節の拘縮記入項目(記入項目List);
            set関節の痛み記入項目(記入項目List);
            set褥瘡記入項目(記入項目List);
            setその他の皮膚疾患記入項目(記入項目List);
        }
    }

    private void set障害高齢者の日常生活自立度(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        RString selectKey = KEY_9;
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (寝たきり度 == item.get連番()) {
                flag = true;
                selectKey = setRadioKey(item);
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 寝たきり度).createBuilderForEdit().set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        div.getRadShogaiKoreishaNichijoSeikatsuJiritsudo().setSelectedKey(selectKey);
    }

    private void set認知症高齢者の日常生活自立度(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        RString selectKey = KEY_8;
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (認知症高齢者の日常生活自立度 == item.get連番()) {
                flag = true;
                selectKey = set認知症高齢者の日常生活自立度Key(item);
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 認知症高齢者の日常生活自立度).createBuilderForEdit().set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        div.getRadNinchishoKoreishaJiritsu().setSelectedKey(selectKey);
    }

    private void set短期記憶(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (短期記憶 == item.get連番()) {
                flag = true;
                div.getRadTankiKioku().setSelectedKey(setCheck短期記憶(item));
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            div.getRadTankiKioku().setSelectedKey(KEY_2);
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 短期記憶).createBuilderForEdit().set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
    }

    private void set認知能力(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (認知能力 == item.get連番()) {
                flag = true;
                div.getRadNichijoNinchiNoryoku().setSelectedKey(setCheck認知能(item));
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            div.getRadNichijoNinchiNoryoku().setSelectedKey(KEY_2);
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 認知能力).createBuilderForEdit().set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
    }

    private void set伝達能力(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (伝達能力 == item.get連番()) {
                flag = true;
                div.getRadIshiDentatsuNoryoku().setSelectedKey(setCheck伝達能力(item));
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            div.getRadIshiDentatsuNoryoku().setSelectedKey(KEY_2);
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 伝達能力).createBuilderForEdit().set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
    }

    private void set認知症の周辺症状(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        RString selectKey = KEY_0;
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (認知症の周辺症状 == item.get連番()) {
                flag = true;
                if (IkenKomoku07.有.getコード().equals(item.get意見項目())) {
                    selectKey = KEY_1;
                }
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 認知症の周辺症状).createBuilderForEdit().set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        div.getRadNinchishoShuhenShojoUmu().setSelectedKey(selectKey);
        if (div.getRadNinchishoShuhenShojoUmu().getSelectedKey().equals(KEY_1)) {
            div.getChkNinchishoShuhenShojo().setReadOnly(false);
            div.getChkNinchishoShuhenShojoSonota().setReadOnly(false);
        }
    }

    private void set幻視幻聴(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean 幻視幻聴flag = false;
        boolean 妄想flag = false;
        boolean 昼夜逆転flag = false;
        boolean 暴言flag = false;
        boolean 暴行flag = false;
        boolean 介護への抵抗flag = false;
        boolean 徘徊flag = false;
        boolean 火の不始末flag = false;
        boolean 不潔行為flag = false;
        boolean 異食行動flag = false;
        boolean 性的問題行動flag = false;

        List<RString> selectKey = new ArrayList<>();
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            switch (item.get連番()) {
                case 幻視幻聴:
                    幻視幻聴flag = true;
                    selectKey.addAll(setCheckBox(item, KEY_0));
                    モード判断_意見項目(item);
                    break;
                case 妄想:
                    妄想flag = true;
                    selectKey.addAll(setCheckBox(item, KEY_1));
                    モード判断_意見項目(item);
                    break;
                case 昼夜逆転:
                    昼夜逆転flag = true;
                    selectKey.addAll(setCheckBox(item, KEY_2));
                    モード判断_意見項目(item);
                    break;
                case 暴言:
                    暴言flag = true;
                    selectKey.addAll(setCheckBox(item, KEY_3));
                    モード判断_意見項目(item);
                    break;
                case 暴行:
                    暴行flag = true;
                    selectKey.addAll(setCheckBox(item, KEY_4));
                    モード判断_意見項目(item);
                    break;
                case 介護への抵抗:
                    介護への抵抗flag = true;
                    selectKey.addAll(setCheckBox(item, KEY_5));
                    モード判断_意見項目(item);
                    break;
                case 徘徊:
                    徘徊flag = true;
                    selectKey.addAll(setCheckBox(item, KEY_6));
                    モード判断_意見項目(item);
                    break;
                case 火の不始末:
                    火の不始末flag = true;
                    selectKey.addAll(setCheckBox(item, KEY_7));
                    モード判断_意見項目(item);
                    break;
                case 不潔行為:
                    不潔行為flag = true;
                    selectKey.addAll(setCheckBox(item, KEY_8));
                    モード判断_意見項目(item);
                    break;
                case 異食行動:
                    異食行動flag = true;
                    selectKey.addAll(setCheckBox(item, KEY_9));
                    モード判断_意見項目(item);
                    break;
                case 性的問題行動:
                    性的問題行動flag = true;
                    selectKey.addAll(setCheckBox(item, KEY_10));
                    モード判断_意見項目(item);
                    break;
                default:
                    break;
            }
        }
        set幻視幻聴データ(幻視幻聴flag,
                妄想flag,
                昼夜逆転flag,
                暴言flag, 暴行flag,
                介護への抵抗flag,
                徘徊flag,
                火の不始末flag,
                不潔行為flag,
                異食行動flag,
                性的問題行動flag,
                意見項目List);
        div.getChkNinchishoShuhenShojo().setSelectedItemsByKey(selectKey);
    }

    private void set幻視幻聴データ(boolean 幻視幻聴flag,
            boolean 妄想flag,
            boolean 昼夜逆転flag,
            boolean 暴言flag,
            boolean 暴行flag,
            boolean 介護への抵抗flag,
            boolean 徘徊flag,
            boolean 火の不始末flag,
            boolean 不潔行為flag,
            boolean 異食行動flag,
            boolean 性的問題行動flag,
            List<ShujiiIkenshoIkenItem> 意見項目List) {
        if (!幻視幻聴flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 幻視幻聴).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!妄想flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 妄想).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!昼夜逆転flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 昼夜逆転).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!暴言flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 暴言).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!暴行flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 暴行).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!介護への抵抗flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 介護への抵抗).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!徘徊flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 徘徊).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!火の不始末flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 火の不始末).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!不潔行為flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 不潔行為).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!異食行動flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 異食行動).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!性的問題行動flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 性的問題行動).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
    }

    private void setその他(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        List<RString> selectKey = new ArrayList<>();
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (その他 == item.get連番()) {
                flag = true;
                selectKey.addAll(setCheckBox(item, KEY_0));
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), その他).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        div.getChkNinchishoShuhenShojoSonota().setSelectedItemsByKey(selectKey);
        if (div.getChkNinchishoShuhenShojoSonota().getSelectedKeys().contains(KEY_0)) {
            div.getTxtSonotaKinyu().setReadOnly(false);
        }
    }

    private void setその他記入項目(List<ShujiiIkenshoKinyuItem> 記入項目List) {
        boolean flag = false;
        for (ShujiiIkenshoKinyuItem item : 記入項目List) {
            if (その他_記入項目 == item.get連番()) {
                flag = true;
                div.getTxtSonotaKinyu().setValue(get記入項目の値(item));
                モード判断_記入項目(item);
            }
        }
        if (!flag) {
            記入項目List.add(new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), その他_記入項目).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
    }

    private void setその他の精神神経症状(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        RString selectKey = KEY_0;
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (その他の精神神経症状 == item.get連番()) {
                flag = true;
                if (IkenKomoku07.有.getコード().equals(item.get意見項目())) {
                    selectKey = KEY_1;
                }
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), その他の精神神経症状).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        div.getRadSonotaShojo().setSelectedKey(selectKey);
        if (div.getRadSonotaShojo().getSelectedKey().equals(KEY_1)) {
            div.getTxtShojomei().setReadOnly(false);
            div.getRadSenmonJushin().setReadOnly(false);
        }
    }

    private void setその他の精神神経症状記入項目(List<ShujiiIkenshoKinyuItem> 記入項目List) {
        boolean flag = false;
        for (ShujiiIkenshoKinyuItem item : 記入項目List) {
            if (その他の精神神経症状_記入項目 == item.get連番()) {
                flag = true;
                div.getTxtShojomei().setValue(get記入項目の値(item));
                モード判断_記入項目(item);
            }
        }
        if (!flag) {
            記入項目List.add(new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), その他の精神神経症状_記入項目).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
    }

    private void set専門医受診の有無(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        RString selectKey = KEY_0;
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (専門医受診の有無 == item.get連番()) {
                flag = true;
                if (IkenKomoku07.有.getコード().equals(item.get意見項目())) {
                    selectKey = KEY_1;
                }
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 専門医受診の有無).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        div.getRadSenmonJushin().setSelectedKey(selectKey);
        if (div.getRadSenmonJushin().getSelectedKey().equals(KEY_1)) {
            div.getTxtShosaiTokkiJiko().setReadOnly(false);
        }
    }

    private void set専門医受診の有無記入項目(List<ShujiiIkenshoKinyuItem> 記入項目List) {
        boolean flag = false;
        for (ShujiiIkenshoKinyuItem item : 記入項目List) {
            if (専門医受診の有無_記入項目 == item.get連番()) {
                flag = true;
                div.getTxtShosaiTokkiJiko().setValue(get記入項目の値(item));
                モード判断_記入項目(item);
            }
        }
        if (!flag) {
            記入項目List.add(new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 専門医受診の有無_記入項目).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
    }

    private void set利き腕(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        RString selectKey = RString.EMPTY;
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (利き腕 == item.get連番()) {
                flag = true;
                selectKey = setCheck右左(item);
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 利き腕).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!RString.isNullOrEmpty(selectKey)) {
            div.getRadKakoTaijuHenka().setSelectedKey(selectKey);
        }
    }

    private void set身長(List<ShujiiIkenshoKinyuItem> 記入項目List) {
        boolean flag = false;
        for (ShujiiIkenshoKinyuItem item : 記入項目List) {
            if (身長_記入項目 == item.get連番()) {
                flag = true;
                div.getTxtShincho().setValue(get記入項目の値(item));
                モード判断_記入項目(item);
            }
        }
        if (!flag) {
            記入項目List.add(new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 身長_記入項目).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
    }

    private void set体重(List<ShujiiIkenshoKinyuItem> 記入項目List) {
        boolean flag = false;
        for (ShujiiIkenshoKinyuItem item : 記入項目List) {
            if (体重_記入項目 == item.get連番()) {
                flag = true;
                div.getTxtTaiju().setValue(get記入項目の値(item));
                モード判断_記入項目(item);
            }
        }
        if (!flag) {
            記入項目List.add(new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 体重_記入項目).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
    }

    private void set過去6カ月の体重の変化(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        RString selectKey = RString.EMPTY;
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (過去6カ月の体重の変化 == item.get連番()) {
                flag = true;
                selectKey = setCheckBox体重の変化(item);
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 過去6カ月の体重の変化).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!RString.isNullOrEmpty(selectKey)) {
            div.getRadKakoTaijuHenka().setSelectedKey(selectKey);
        }
    }

    private void set四肢欠損(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        List<RString> selectKey = new ArrayList<>();
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (四肢欠損 == item.get連番()) {
                flag = true;
                selectKey.addAll(setCheckBox(item, KEY_0));
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 四肢欠損).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        div.getChkShishiKesson().setSelectedItemsByKey(selectKey);
        if (div.getChkShishiKesson().getSelectedKeys().contains(KEY_0)) {
            div.getTxtShishiKessonBui().setReadOnly(false);
        }
    }

    private void set四肢欠損記入項目(List<ShujiiIkenshoKinyuItem> 記入項目List) {
        boolean flag = false;
        for (ShujiiIkenshoKinyuItem item : 記入項目List) {
            if (四肢欠損_記入項目 == item.get連番()) {
                flag = true;
                div.getTxtShishiKessonBui().setValue(get記入項目の値(item));
                モード判断_記入項目(item);
            }
        }
        if (!flag) {
            記入項目List.add(new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 四肢欠損_記入項目).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
    }

    private void set麻痺(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        List<RString> selectKey = new ArrayList<>();
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (麻痺 == item.get連番()) {
                flag = true;
                selectKey.addAll(setCheckBox(item, KEY_0));
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 麻痺).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        div.getChkMahi().setSelectedItemsByKey(selectKey);
        if (div.getChkMahi().getSelectedKeys().contains(KEY_0)) {
            div.getChkMigiJoshiMahi().setReadOnly(false);
            div.getChkHidariJoshiMahi().setReadOnly(false);
            div.getChkMigiKashiMahi().setReadOnly(false);
            div.getChkHidariKashiMahi().setReadOnly(false);
            div.getChkSonotaMahi().setReadOnly(false);
        }
    }

    private void set麻痺_右上肢(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        List<RString> selectKey = new ArrayList<>();
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (麻痺_右上肢 == item.get連番()) {
                flag = true;
                selectKey.addAll(setCheckBox(item, KEY_0));
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 麻痺_右上肢).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        div.getChkMigiJoshiMahi().setSelectedItemsByKey(selectKey);
        if (div.getChkMigiJoshiMahi().getSelectedKeys().contains(KEY_0)) {
            div.getRadMigiJoshiMahiTeido().setReadOnly(false);
        }
    }

    private void set麻痺_右上肢_程度(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        RString selectKey = RString.EMPTY;
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (麻痺_右上肢_程度 == item.get連番()) {
                flag = true;
                selectKey = set程度(item);
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 麻痺_右上肢_程度).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!RString.isNullOrEmpty(selectKey)) {
            div.getRadMigiJoshiMahiTeido().setSelectedKey(selectKey);
        }
    }

    private void set麻痺_左上肢(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        List<RString> selectKey = new ArrayList<>();
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (麻痺_左上肢 == item.get連番()) {
                flag = true;
                selectKey.addAll(setCheckBox(item, KEY_0));
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 麻痺_左上肢).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        div.getChkHidariJoshiMahi().setSelectedItemsByKey(selectKey);
        if (div.getChkHidariJoshiMahi().getSelectedKeys().contains(KEY_0)) {
            div.getRadHidariJoshiMahiTeido().setReadOnly(false);
        }
    }

    private void set麻痺_左上肢_程度(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        RString selectKey = RString.EMPTY;
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (麻痺_左上肢_程度 == item.get連番()) {
                flag = true;
                selectKey = set程度(item);
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 麻痺_左上肢_程度).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!RString.isNullOrEmpty(selectKey)) {
            div.getRadHidariJoshiMahiTeido().setSelectedKey(selectKey);
        }
    }

    private void set麻痺_右下肢(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        List<RString> selectKey = new ArrayList<>();
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (麻痺_右下肢 == item.get連番()) {
                flag = true;
                selectKey.addAll(setCheckBox(item, KEY_0));
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 麻痺_右下肢).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        div.getChkMigiKashiMahi().setSelectedItemsByKey(selectKey);
        if (div.getChkMigiKashiMahi().getSelectedKeys().contains(KEY_0)) {
            div.getRadMigiKashiMahiTeido().setReadOnly(false);
        }
    }

    private void set麻痺_右下肢_程度(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        RString selectKey = RString.EMPTY;
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (麻痺_右下肢_程度 == item.get連番()) {
                flag = true;
                selectKey = set程度(item);
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 麻痺_右下肢_程度).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!RString.isNullOrEmpty(selectKey)) {
            div.getRadMigiKashiMahiTeido().setSelectedKey(selectKey);
        }
    }

    private void set麻痺_左下肢(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        List<RString> selectKey = new ArrayList<>();
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (麻痺_左下肢 == item.get連番()) {
                flag = true;
                selectKey.addAll(setCheckBox(item, KEY_0));
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 麻痺_左下肢).createBuilderForEdit().set厚労省IF識別コード(
                            new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        div.getChkHidariKashiMahi().setSelectedItemsByKey(selectKey);
        if (div.getChkHidariKashiMahi().getSelectedKeys().contains(KEY_0)) {
            div.getRadHidariKashiMahiTeido().setReadOnly(false);
        }
    }

    private void set麻痺_左下肢_程度(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        RString selectKey = RString.EMPTY;
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (麻痺_左下肢_程度 == item.get連番()) {
                flag = true;
                selectKey = set程度(item);
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 麻痺_左下肢_程度).createBuilderForEdit().set厚労省IF識別コード(new Code(
                                    KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!RString.isNullOrEmpty(selectKey)) {
            div.getRadHidariKashiMahiTeido().setSelectedKey(selectKey);
        }
    }

    private void set麻痺_その他(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        List<RString> selectKey = new ArrayList<>();
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (麻痺_その他 == item.get連番()) {
                flag = true;
                selectKey.addAll(setCheckBox(item, KEY_0));
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 麻痺_その他).createBuilderForEdit().set厚労省IF識別コード(new Code(
                                    KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        div.getChkSonotaMahi().setSelectedItemsByKey(selectKey);
        if (div.getChkSonotaMahi().getSelectedKeys().contains(KEY_0)) {
            div.getTxtSonotaMahiBui().setReadOnly(false);
            div.getRadSonotaMahiTeido().setReadOnly(false);
        }
    }

    private void set麻痺_その他記入項目(List<ShujiiIkenshoKinyuItem> 記入項目List) {
        boolean flag = false;
        for (ShujiiIkenshoKinyuItem item : 記入項目List) {
            if (麻痺_その他_記入項目 == item.get連番()) {
                flag = true;
                div.getTxtSonotaMahiBui().setValue(get記入項目の値(item));
                モード判断_記入項目(item);
            }
        }
        if (!flag) {
            記入項目List.add(new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 麻痺_その他_記入項目).createBuilderForEdit().set厚労省IF識別コード(new Code(
                                    KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
    }

    private void set麻痺_その他_程度(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        RString selectKey = RString.EMPTY;
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (麻痺_その他_程度 == item.get連番()) {
                flag = true;
                selectKey = set程度(item);
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 麻痺_その他_程度).createBuilderForEdit().set厚労省IF識別コード(new Code(
                                    KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!RString.isNullOrEmpty(selectKey)) {
            div.getRadSonotaMahiTeido().setSelectedKey(selectKey);
        }
    }

    private void set筋力の低下(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        List<RString> selectKey = new ArrayList<>();
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (筋力の低下 == item.get連番()) {
                flag = true;
                selectKey.addAll(setCheckBox(item, KEY_0));
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 筋力の低下).createBuilderForEdit().set厚労省IF識別コード(new Code(
                                    KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        div.getChkKinryokuTeika().setSelectedItemsByKey(selectKey);
        if (div.getChkKinryokuTeika().getSelectedKeys().contains(KEY_0)) {
            div.getTxtKinryokuTeikaBui().setReadOnly(false);
            div.getRadKinryokuTeikaTeido().setReadOnly(false);
        }
    }

    private void set筋力の低下記入項目(List<ShujiiIkenshoKinyuItem> 記入項目List) {
        boolean flag = false;
        for (ShujiiIkenshoKinyuItem item : 記入項目List) {
            if (筋力の低下_記入項目 == item.get連番()) {
                flag = true;
                div.getTxtKinryokuTeikaBui().setValue(get記入項目の値(item));
                モード判断_記入項目(item);
            }
        }
        if (!flag) {
            記入項目List.add(new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 筋力の低下_記入項目).createBuilderForEdit().set厚労省IF識別コード(new Code(
                                    KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
    }

    private void set筋力の低下_程度(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        RString selectKey = RString.EMPTY;
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (筋力の低下_程度 == item.get連番()) {
                flag = true;
                selectKey = set程度(item);
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 筋力の低下_程度).createBuilderForEdit().set厚労省IF識別コード(new Code(
                                    KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!RString.isNullOrEmpty(selectKey)) {
            div.getRadKinryokuTeikaTeido().setSelectedKey(selectKey);
        }
    }

    private void set関節の拘縮(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        List<RString> selectKey = new ArrayList<>();
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (関節の拘縮 == item.get連番()) {
                flag = true;
                selectKey.addAll(setCheckBox(item, KEY_0));
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 関節の拘縮).createBuilderForEdit().set厚労省IF識別コード(new Code(
                                    KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        div.getChkKansetsuKoshuku().setSelectedItemsByKey(selectKey);
        if (div.getChkKansetsuKoshuku().getSelectedKeys().contains(KEY_0)) {
            div.getTxtKansetsuKoshukuBui().setReadOnly(false);
            div.getRadKansetsuKoshukuTeido().setReadOnly(false);
        }
    }

    private void set関節の拘縮記入項目(List<ShujiiIkenshoKinyuItem> 記入項目List) {
        boolean flag = false;
        for (ShujiiIkenshoKinyuItem item : 記入項目List) {
            if (関節の拘縮_記入項目 == item.get連番()) {
                flag = true;
                div.getTxtKansetsuKoshukuBui().setValue(get記入項目の値(item));
                モード判断_記入項目(item);
            }
        }
        if (!flag) {
            記入項目List.add(new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 関節の拘縮_記入項目).createBuilderForEdit().set厚労省IF識別コード(new Code(
                                    KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
    }

    private void set関節の拘縮_程度(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        RString selectKey = RString.EMPTY;
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (関節の拘縮_程度 == item.get連番()) {
                flag = true;
                selectKey = set程度(item);
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 関節の拘縮_程度).createBuilderForEdit().set厚労省IF識別コード(new Code(
                                    KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!RString.isNullOrEmpty(selectKey)) {
            div.getRadKansetsuKoshukuTeido().setSelectedKey(selectKey);
        }
    }

    private void set関節の痛み(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        List<RString> selectKey = new ArrayList<>();
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (関節の痛み == item.get連番()) {
                flag = true;
                selectKey.addAll(setCheckBox(item, KEY_0));
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 関節の痛み).createBuilderForEdit().set厚労省IF識別コード(new Code(
                                    KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        div.getChkKansetsuItami().setSelectedItemsByKey(selectKey);
        if (div.getChkKansetsuItami().getSelectedKeys().contains(KEY_0)) {
            div.getTxtKansetsuItamiBui().setReadOnly(false);
            div.getRadKansetsuItamiTeido().setReadOnly(false);
        }
    }

    private void set関節の痛み記入項目(List<ShujiiIkenshoKinyuItem> 記入項目List) {
        boolean flag = false;
        for (ShujiiIkenshoKinyuItem item : 記入項目List) {
            if (関節の痛み_記入項目 == item.get連番()) {
                flag = true;
                div.getTxtKansetsuItamiBui().setValue(get記入項目の値(item));
                モード判断_記入項目(item);
            }
        }
        if (!flag) {
            記入項目List.add(new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 関節の痛み_記入項目).createBuilderForEdit().set厚労省IF識別コード(new Code(
                                    KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
    }

    private void set関節の痛み_程度(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        RString selectKey = RString.EMPTY;
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (関節の痛み_程度 == item.get連番()) {
                flag = true;
                selectKey = set程度(item);
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 関節の痛み_程度).createBuilderForEdit().set厚労省IF識別コード(new Code(
                                    KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!RString.isNullOrEmpty(selectKey)) {
            div.getRadKansetsuItamiTeido().setSelectedKey(selectKey);
        }
    }

    private void set失調不随意運動(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        List<RString> selectKey = new ArrayList<>();
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (失調_不随意運動 == item.get連番()) {
                flag = true;
                selectKey.addAll(setCheckBox(item, KEY_0));
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 失調_不随意運動).createBuilderForEdit().set厚労省IF識別コード(new Code(
                                    KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        div.getChkShicchoFuzuii().setSelectedItemsByKey(selectKey);
        if (div.getChkShicchoFuzuii().getSelectedKeys().contains(KEY_0)) {
            div.getChkFuzuiiJoshi().setReadOnly(false);
            div.getChkFuzuiiKashi().setReadOnly(false);
            div.getChkTaikan().setReadOnly(false);
        }
    }

    private void set失調不随意運動_上肢(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean 右flag = false;
        boolean 左flag = false;

        List<RString> selectKey = new ArrayList<>();
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            switch (item.get連番()) {
                case 失調_不随意運動_上肢_右:
                    右flag = true;
                    selectKey.addAll(setCheckBox(item, KEY_0));
                    モード判断_意見項目(item);
                    break;
                case 失調_不随意運動_上肢_左:
                    左flag = true;
                    selectKey.addAll(setCheckBox(item, KEY_1));
                    モード判断_意見項目(item);
                    break;
                default:
                    break;
            }
        }
        if (!右flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 失調_不随意運動_上肢_右).createBuilderForEdit().set厚労省IF識別コード(new Code(
                                    KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!左flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 失調_不随意運動_上肢_左).createBuilderForEdit().set厚労省IF識別コード(new Code(
                                    KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }

        div.getChkFuzuiiJoshi().setSelectedItemsByKey(selectKey);
    }

    private void set失調不随意運動_下肢(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean 右flag = false;
        boolean 左flag = false;

        List<RString> selectKey = new ArrayList<>();
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            switch (item.get連番()) {
                case 失調_不随意運動_下肢_右:
                    右flag = true;
                    selectKey.addAll(setCheckBox(item, KEY_0));
                    モード判断_意見項目(item);
                    break;
                case 失調_不随意運動_下肢_左:
                    左flag = true;
                    selectKey.addAll(setCheckBox(item, KEY_1));
                    モード判断_意見項目(item);
                    break;
                default:
                    break;
            }
        }
        if (!右flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 失調_不随意運動_下肢_右).createBuilderForEdit().set厚労省IF識別コード(new Code(
                                    KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!左flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 失調_不随意運動_下肢_左).createBuilderForEdit().set厚労省IF識別コード(new Code(
                                    KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        div.getChkTaikan().setSelectedItemsByKey(selectKey);
    }

    private void set失調不随意運動_体幹(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean 右flag = false;
        boolean 左flag = false;

        List<RString> selectKey = new ArrayList<>();
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            switch (item.get連番()) {
                case 失調_不随意運動_体幹_右:
                    右flag = true;
                    selectKey.addAll(setCheckBox(item, KEY_0));
                    モード判断_意見項目(item);
                    break;
                case 失調_不随意運動_体幹_左:
                    左flag = true;
                    selectKey.addAll(setCheckBox(item, KEY_1));
                    モード判断_意見項目(item);
                    break;
                default:
                    break;
            }
        }
        if (!右flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 失調_不随意運動_体幹_右).createBuilderForEdit().set厚労省IF識別コード(new Code(
                                    KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!左flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), 失調_不随意運動_体幹_左).createBuilderForEdit().set厚労省IF識別コード(new Code(
                                    KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        div.getChkFuzuiiKashi().setSelectedItemsByKey(selectKey);
    }

    private void set褥瘡(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        List<RString> selectKey = new ArrayList<>();
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (じょくそう == item.get連番()) {
                flag = true;
                selectKey.addAll(setCheckBox(item, KEY_0));
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), じょくそう).createBuilderForEdit().set厚労省IF識別コード(new Code(
                                    KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        div.getChkJokuso().setSelectedItemsByKey(selectKey);
        if (div.getChkJokuso().getSelectedKeys().contains(KEY_0)) {
            div.getTxtJokusoBui().setReadOnly(false);
            div.getRadJokusoTeido().setReadOnly(false);
        }
    }

    private void set褥瘡記入項目(List<ShujiiIkenshoKinyuItem> 記入項目List) {
        boolean flag = false;
        for (ShujiiIkenshoKinyuItem item : 記入項目List) {
            if (じょくそう_記入項目 == item.get連番()) {
                flag = true;
                div.getTxtJokusoBui().setValue(get記入項目の値(item));
                モード判断_記入項目(item);
            }
        }
        if (!flag) {
            記入項目List.add(new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), じょくそう_記入項目).createBuilderForEdit().set厚労省IF識別コード(new Code(
                                    KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
    }

    private void set褥瘡_程度(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        RString selectKey = RString.EMPTY;
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (じょくそう_程度 == item.get連番()) {
                flag = true;
                selectKey = set程度(item);
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), じょくそう_程度).createBuilderForEdit().set厚労省IF識別コード(new Code(
                                    KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!RString.isNullOrEmpty(selectKey)) {
            div.getRadJokusoTeido().setSelectedKey(selectKey);
        }
    }

    private void setその他の皮膚疾患(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        List<RString> selectKey = new ArrayList<>();
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (その他の皮膚疾患 == item.get連番()) {
                flag = true;
                selectKey.addAll(setCheckBox(item, KEY_0));
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), その他の皮膚疾患).createBuilderForEdit().set厚労省IF識別コード(new Code(
                                    KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        div.getChkSonotaHifuShikkan().setSelectedItemsByKey(selectKey);
        if (div.getChkSonotaHifuShikkan().getSelectedKeys().contains(KEY_0)) {
            div.getTxtSonotaHifuShikkanBui().setReadOnly(false);
            div.getRadSonotaHifuShikkanTeido().setReadOnly(false);
        }
    }

    private void setその他の皮膚疾患記入項目(List<ShujiiIkenshoKinyuItem> 記入項目List) {
        boolean flag = false;
        for (ShujiiIkenshoKinyuItem item : 記入項目List) {
            if (その他の皮膚疾患_記入項目 == item.get連番()) {
                flag = true;
                div.getTxtSonotaHifuShikkanBui().setValue(get記入項目の値(item));
                モード判断_記入項目(item);
            }
        }
        if (!flag) {
            記入項目List.add(new ShujiiIkenshoKinyuItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), その他の皮膚疾患_記入項目).createBuilderForEdit().set厚労省IF識別コード(new Code(
                                    KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
    }

    private void setその他の皮膚疾患_程度(List<ShujiiIkenshoIkenItem> 意見項目List) {
        boolean flag = false;
        RString selectKey = RString.EMPTY;
        for (ShujiiIkenshoIkenItem item : 意見項目List) {
            if (その他の皮膚疾患_程度 == item.get連番()) {
                flag = true;
                selectKey = set程度(item);
                モード判断_意見項目(item);
            }
        }
        if (!flag) {
            意見項目List.add(new ShujiiIkenshoIkenItem(new ShinseishoKanriNo(管理番号),
                    Integer.valueOf(履歴番号.toString()), その他の皮膚疾患_程度).createBuilderForEdit().set厚労省IF識別コード(new Code(KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード())).build());
        }
        if (!RString.isNullOrEmpty(selectKey)) {
            div.getRadSonotaHifuShikkanTeido().setSelectedKey(selectKey);
        }
    }

    private RString setRadioKey(ShujiiIkenshoIkenItem item) {
        return itemToKey(item.get意見項目());
    }

    private RString set認知症高齢者の日常生活自立度Key(ShujiiIkenshoIkenItem item) {
        if (IkenKomoku03.自立.getコード().equals(item.get意見項目())) {
            return KEY_0;
        } else if (IkenKomoku03.Ⅰ.getコード().equals(item.get意見項目())) {
            return KEY_1;
        } else if (IkenKomoku03.Ⅱa.getコード().equals(item.get意見項目())) {
            return KEY_2;
        } else if (IkenKomoku03.Ⅱa.getコード().equals(item.get意見項目())) {
            return KEY_3;
        } else if (IkenKomoku03.Ⅲa.getコード().equals(item.get意見項目())) {
            return KEY_4;
        } else if (IkenKomoku03.Ⅲb.getコード().equals(item.get意見項目())) {
            return KEY_5;
        } else if (IkenKomoku03.Ⅳ.getコード().equals(item.get意見項目())) {
            return KEY_6;
        } else if (IkenKomoku03.M.getコード().equals(item.get意見項目())) {
            return KEY_7;
        } else {
            return KEY_8;
        }
    }

    private List<RString> setCheckBoxNasiAri(ShujiiIkenshoIkenItem item) {
        List<RString> selectKey = new ArrayList<>();
        if (IkenKomoku07.有.getコード().equals(item.get意見項目())) {
            selectKey.add(KEY_1);
        } else {
            selectKey.add(KEY_0);
        }
        return selectKey;
    }

    private RString setCheck短期記憶(ShujiiIkenshoIkenItem item) {
        RString selectKey = RString.EMPTY;
        if (IkenKomoku04.問題なし.getコード().equals(item.get意見項目())) {
            selectKey = KEY_0;
        } else if (IkenKomoku04.問題あり.getコード().equals(item.get意見項目())) {
            selectKey = KEY_1;
        } else {
            selectKey = KEY_2;
        }
        return selectKey;
    }

    private RString setCheck認知能(ShujiiIkenshoIkenItem item) {
        RString selectKey = RString.EMPTY;
        if (IkenKomoku05.自立.getコード().equals(item.get意見項目())) {
            selectKey = KEY_0;
        } else if (IkenKomoku05.いくらか困難.getコード().equals(item.get意見項目())) {
            selectKey = KEY_1;
        } else if (IkenKomoku05.見守りが必要.getコード().equals(item.get意見項目())) {
            selectKey = KEY_2;
        } else if (IkenKomoku05.判断できない.getコード().equals(item.get意見項目())) {
            selectKey = KEY_3;
        } else {
            selectKey = KEY_4;
        }
        return selectKey;
    }

    private RString setCheck伝達能力(ShujiiIkenshoIkenItem item) {
        RString selectKey = RString.EMPTY;
        if (IkenKomoku06.伝えられる.getコード().equals(item.get意見項目())) {
            selectKey = KEY_0;
        } else if (IkenKomoku06.いくらか困難.getコード().equals(item.get意見項目())) {
            selectKey = KEY_1;
        } else if (IkenKomoku06.具体的要求に限られる.getコード().equals(item.get意見項目())) {
            selectKey = KEY_2;
        } else if (IkenKomoku06.伝えられない.getコード().equals(item.get意見項目())) {
            selectKey = KEY_3;
        } else {
            selectKey = KEY_4;
        }
        return selectKey;
    }

    private RString setCheckBox体重の変化(ShujiiIkenshoIkenItem item) {
        RString selectKey = RString.EMPTY;
        if (IkenKomoku09.増加.getコード().equals(item.get意見項目())) {
            selectKey = KEY_0;
        } else if (IkenKomoku09.減少.getコード().equals(item.get意見項目())) {
            selectKey = KEY_1;
        } else if (IkenKomoku09.維持.getコード().equals(item.get意見項目())) {
            selectKey = KEY_2;
        }
        return selectKey;
    }

    private RString setCheck右左(ShujiiIkenshoIkenItem item) {
        RString selectKey = RString.EMPTY;
        if (IkenKomoku08.右.getコード().equals(item.get意見項目())) {
            selectKey = KEY_0;
        } else if (IkenKomoku08.左.getコード().equals(item.get意見項目())) {
            selectKey = KEY_1;
        }
        return selectKey;
    }

    private RString set程度(ShujiiIkenshoIkenItem item) {
        RString selectKey = RString.EMPTY;
        if (IkenKomoku10.軽.getコード().equals(item.get意見項目())) {
            selectKey = KEY_0;
        } else if (IkenKomoku10.中.getコード().equals(item.get意見項目())) {
            selectKey = KEY_1;
        } else if (IkenKomoku10.重.getコード().equals(item.get意見項目())) {
            selectKey = KEY_2;
        }
        return selectKey;
    }

    private List<RString> setCheckBox(ShujiiIkenshoIkenItem item, RString key) {
        List<RString> selectKey = new ArrayList<>();
        if (IkenKomoku01.有.getコード().equals(item.get意見項目())) {
            selectKey.add(key);
        }
        return selectKey;
    }

    private RString get記入項目の値(ShujiiIkenshoKinyuItem item) {
        return item.get記入項目() != null ? item.get記入項目() : RString.EMPTY;
    }

    private ShujiiIkenshoIkenItem モード判断_意見項目(ShujiiIkenshoIkenItem 意見書情報) {
        if (!EntityDataState.Added.equals(意見書情報.toEntity().getState())) {
            return 意見書情報.modifiedModel();
        }
        return 意見書情報;
    }

    private ShujiiIkenshoKinyuItem モード判断_記入項目(ShujiiIkenshoKinyuItem item) {
        if (!EntityDataState.Added.equals(item.toEntity().getState())) {
            return item.modifiedModel();
        }
        return item;
    }

    private RString itemToKey(RString item) {
        if (IkenKomoku02.自立.getコード().equals(item)) {
            return KEY_0;
        } else if (IkenKomoku02.J1.getコード().equals(item)) {
            return KEY_1;
        } else if (IkenKomoku02.J2.getコード().equals(item)) {
            return KEY_2;
        } else if (IkenKomoku02.A1.getコード().equals(item)) {
            return KEY_3;
        } else if (IkenKomoku02.A2.getコード().equals(item)) {
            return KEY_4;
        } else if (IkenKomoku02.B1.getコード().equals(item)) {
            return KEY_5;
        } else if (IkenKomoku02.B2.getコード().equals(item)) {
            return KEY_6;
        } else if (IkenKomoku02.C1.getコード().equals(item)) {
            return KEY_7;
        } else if (IkenKomoku02.C2.getコード().equals(item)) {
            return KEY_8;
        } else {
            return KEY_9;
        }
    }
}
