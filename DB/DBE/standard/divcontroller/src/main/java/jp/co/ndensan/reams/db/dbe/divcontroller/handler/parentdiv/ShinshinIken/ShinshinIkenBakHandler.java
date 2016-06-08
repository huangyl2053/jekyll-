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

    private static final RString チェックボックス_1 = new RString("key0");
    private static final RString チェックボックス_2 = new RString("key1");
    private static final RString チェックボックス_3 = new RString("key2");
    private static final RString チェックボックス_4 = new RString("key3");
    private static final RString チェックボックス_5 = new RString("key4");
    private static final RString チェックボックス_6 = new RString("key5");
    private static final RString チェックボックス_7 = new RString("key6");
    private static final RString チェックボックス_8 = new RString("key7");
    private static final RString チェックボックス_9 = new RString("key8");
    private static final RString チェックボックス_10 = new RString("key9");
    private static final RString チェックボックス_11 = new RString("key10");
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
    private final ShujiiIkenshoJoho 要介護認定主治医意見書情報_TMP;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     * @param 要介護認定申請情報 要介護認定申請情報
     * @param 管理番号 管理番号
     * @param 履歴番号 履歴番号
     * @param 要介護認定主治医意見書情報_TMP 要介護認定主治医意見書情報_TMP
     */
    public ShinshinIkenBakHandler(ShinshinIkenDiv div,
            NinteiShinseiJoho 要介護認定申請情報,
            RString 管理番号,
            RString 履歴番号,
            ShujiiIkenshoJoho 要介護認定主治医意見書情報_TMP) {
        this.div = div;
        this.要介護認定申請情報 = 要介護認定申請情報;
        this.管理番号 = 管理番号;
        this.履歴番号 = 履歴番号;
        this.要介護認定主治医意見書情報_TMP = 要介護認定主治医意見書情報_TMP;
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
        set意見項目Emtpy(要介護認定主治医意見書情報_TMP, 寝たきり度);
        for (RString key : div.getChkShogaiKoreishaNichijoSeikatsuJiritsudo().getSelectedKeys()) {
            set意見項目(要介護認定主治医意見書情報_TMP, 寝たきり度, key);
        }
        set意見項目Emtpy(要介護認定主治医意見書情報_TMP, 認知症高齢者の日常生活自立度);
        for (RString key : div.getChkNinchishoKoreishaJiritsu().getSelectedKeys()) {
            set意見項目(要介護認定主治医意見書情報_TMP, 認知症高齢者の日常生活自立度, key);
        }
        set意見項目(要介護認定主治医意見書情報_TMP, 短期記憶, div.getRadTankiKioku().getSelectedKey());
        set意見項目(要介護認定主治医意見書情報_TMP, 認知能力, div.getRadNichijoNinchiNoryoku().getSelectedKey());
        set意見項目(要介護認定主治医意見書情報_TMP, 伝達能力, div.getRadIshiDentatsuNoryoku().getSelectedKey());
        set意見項目Emtpy(要介護認定主治医意見書情報_TMP, 認知症の周辺症状);
        for (RString key : div.getChkNinchishoShuhenShojoUmu().getSelectedKeys()) {
            set意見項目(要介護認定主治医意見書情報_TMP, 認知症の周辺症状, key);
        }
        if (div.getChkNinchishoShuhenShojo().getSelectedKeys().contains(チェックボックス_1)) {
            set意見項目(要介護認定主治医意見書情報_TMP, 幻視幻聴, チェックボックス_2);
        } else {
            set意見項目(要介護認定主治医意見書情報_TMP, 幻視幻聴, チェックボックス_1);
        }
        if (div.getChkNinchishoShuhenShojo().getSelectedKeys().contains(チェックボックス_2)) {
            set意見項目(要介護認定主治医意見書情報_TMP, 妄想, チェックボックス_2);
        } else {
            set意見項目(要介護認定主治医意見書情報_TMP, 妄想, チェックボックス_1);
        }
        if (div.getChkNinchishoShuhenShojo().getSelectedKeys().contains(チェックボックス_3)) {
            set意見項目(要介護認定主治医意見書情報_TMP, 昼夜逆転, チェックボックス_2);
        } else {
            set意見項目(要介護認定主治医意見書情報_TMP, 昼夜逆転, チェックボックス_1);
        }
        if (div.getChkNinchishoShuhenShojo().getSelectedKeys().contains(チェックボックス_4)) {
            set意見項目(要介護認定主治医意見書情報_TMP, 暴言, チェックボックス_2);
        } else {
            set意見項目(要介護認定主治医意見書情報_TMP, 暴言, チェックボックス_1);
        }
        if (div.getChkNinchishoShuhenShojo().getSelectedKeys().contains(チェックボックス_5)) {
            set意見項目(要介護認定主治医意見書情報_TMP, 暴行, チェックボックス_2);
        } else {
            set意見項目(要介護認定主治医意見書情報_TMP, 暴行, チェックボックス_1);
        }
        if (div.getChkNinchishoShuhenShojo().getSelectedKeys().contains(チェックボックス_6)) {
            set意見項目(要介護認定主治医意見書情報_TMP, 介護への抵抗, チェックボックス_2);
        } else {
            set意見項目(要介護認定主治医意見書情報_TMP, 介護への抵抗, チェックボックス_1);
        }
        if (div.getChkNinchishoShuhenShojo().getSelectedKeys().contains(チェックボックス_7)) {
            set意見項目(要介護認定主治医意見書情報_TMP, 徘徊, チェックボックス_2);
        } else {
            set意見項目(要介護認定主治医意見書情報_TMP, 徘徊, チェックボックス_1);
        }
        if (div.getChkNinchishoShuhenShojo().getSelectedKeys().contains(チェックボックス_8)) {
            set意見項目(要介護認定主治医意見書情報_TMP, 火の不始末, チェックボックス_2);
        } else {
            set意見項目(要介護認定主治医意見書情報_TMP, 火の不始末, チェックボックス_1);
        }
        if (div.getChkNinchishoShuhenShojo().getSelectedKeys().contains(チェックボックス_9)) {
            set意見項目(要介護認定主治医意見書情報_TMP, 不潔行為, チェックボックス_2);
        } else {
            set意見項目(要介護認定主治医意見書情報_TMP, 不潔行為, チェックボックス_1);
        }
        if (div.getChkNinchishoShuhenShojo().getSelectedKeys().contains(チェックボックス_10)) {
            set意見項目(要介護認定主治医意見書情報_TMP, 異食行動, チェックボックス_2);
        } else {
            set意見項目(要介護認定主治医意見書情報_TMP, 異食行動, チェックボックス_1);
        }
        if (div.getChkNinchishoShuhenShojo().getSelectedKeys().contains(チェックボックス_11)) {
            set意見項目(要介護認定主治医意見書情報_TMP, 性的問題行動, チェックボックス_2);
        } else {
            set意見項目(要介護認定主治医意見書情報_TMP, 性的問題行動, チェックボックス_1);
        }
        set意見項目(要介護認定主治医意見書情報_TMP, その他, keyToItemNasiari(div.getChkNinchishoShuhenShojoSonota().getSelectedKeys()));
        set記入項目(要介護認定主治医意見書情報_TMP, その他_記入項目, div.getTxtSonotaKinyu().getValue());
        set意見項目Emtpy(要介護認定主治医意見書情報_TMP, その他の精神神経症状);
        for (RString key : div.getChkSonotaShojo().getSelectedKeys()) {
            set意見項目(要介護認定主治医意見書情報_TMP, その他の精神神経症状, key);
        }
        set記入項目(要介護認定主治医意見書情報_TMP, その他の精神神経症状_記入項目, div.getTxtShojomei().getValue());
        set意見項目Emtpy(要介護認定主治医意見書情報_TMP, 専門医受診の有無);
        for (RString key : div.getChkSenmonJushin().getSelectedKeys()) {
            set意見項目(要介護認定主治医意見書情報_TMP, 専門医受診の有無, key);
        }
        set記入項目(要介護認定主治医意見書情報_TMP, 専門医受診の有無_記入項目, div.getTxtShosaiTokkiJiko().getValue());
        set意見項目Emtpy(要介護認定主治医意見書情報_TMP, 利き腕);
        for (RString key : div.getChkKikiude().getSelectedKeys()) {
            set意見項目(要介護認定主治医意見書情報_TMP, 利き腕, key);
        }
        set記入項目(要介護認定主治医意見書情報_TMP, 身長_記入項目, div.getTxtShincho().getValue());
        set記入項目(要介護認定主治医意見書情報_TMP, 体重_記入項目, div.getTxtTaiju().getValue());
        set意見項目Emtpy(要介護認定主治医意見書情報_TMP, 過去6カ月の体重の変化);
        for (RString key : div.getChkKakoTaijuHenka().getSelectedKeys()) {
            set意見項目(要介護認定主治医意見書情報_TMP, 過去6カ月の体重の変化, set過去6カ月の体重(key));
        }
        return set呼び出し元画面への戻り値_下();
    }

    private NinteiShinseiJoho set呼び出し元画面への戻り値_下() {
        set意見項目(要介護認定主治医意見書情報_TMP, 四肢欠損, keyToItemNasiari(div.getChkShishiKesson().getSelectedKeys()));
        set記入項目(要介護認定主治医意見書情報_TMP, 四肢欠損_記入項目, div.getTxtShishiKessonBui().getValue());
        set意見項目(要介護認定主治医意見書情報_TMP, 麻痺, keyToItemNasiari(div.getChkMahi().getSelectedKeys()));
        set意見項目(要介護認定主治医意見書情報_TMP, 麻痺_右上肢, keyToItemNasiari(div.getChkMigiJoshiMahi().getSelectedKeys()));
        set意見項目Emtpy(要介護認定主治医意見書情報_TMP, 麻痺_右上肢_程度);
        for (RString key : div.getChkMigiJoshiMahiTeido().getSelectedKeys()) {
            set意見項目(要介護認定主治医意見書情報_TMP, 麻痺_右上肢_程度, key);
        }
        set意見項目(要介護認定主治医意見書情報_TMP, 麻痺_左上肢, keyToItemNasiari(div.getChkHidariJoshiMahi().getSelectedKeys()));
        set意見項目Emtpy(要介護認定主治医意見書情報_TMP, 麻痺_左上肢_程度);
        for (RString key : div.getChkHidariJoshiMahiTeido().getSelectedKeys()) {
            set意見項目(要介護認定主治医意見書情報_TMP, 麻痺_左上肢_程度, key);
        }
        set意見項目(要介護認定主治医意見書情報_TMP, 麻痺_右下肢, keyToItemNasiari(div.getChkMigiKashiMahi().getSelectedKeys()));
        set意見項目Emtpy(要介護認定主治医意見書情報_TMP, 麻痺_右下肢_程度);
        for (RString key : div.getChkMigiKashiMahiTeido().getSelectedKeys()) {
            set意見項目(要介護認定主治医意見書情報_TMP, 麻痺_右下肢_程度, key);
        }
        set意見項目(要介護認定主治医意見書情報_TMP, 麻痺_左下肢, keyToItemNasiari(div.getChkHidariKashiMahi().getSelectedKeys()));
        set意見項目Emtpy(要介護認定主治医意見書情報_TMP, 麻痺_左下肢_程度);
        for (RString key : div.getChkHidariKashiMahiTeido().getSelectedKeys()) {
            set意見項目(要介護認定主治医意見書情報_TMP, 麻痺_左下肢_程度, key);
        }
        set意見項目(要介護認定主治医意見書情報_TMP, 麻痺_その他, keyToItemNasiari(div.getChkSonotaMahi().getSelectedKeys()));
        set記入項目(要介護認定主治医意見書情報_TMP, 麻痺_その他_記入項目, div.getTxtSonotaMahiBui().getValue());
        set意見項目Emtpy(要介護認定主治医意見書情報_TMP, 麻痺_その他_程度);
        for (RString key : div.getSonotaMahiTeido().getSelectedKeys()) {
            set意見項目(要介護認定主治医意見書情報_TMP, 麻痺_その他_程度, key);
        }
        set意見項目(要介護認定主治医意見書情報_TMP, 筋力の低下, keyToItemNasiari(div.getChkKinryokuTeika().getSelectedKeys()));
        set記入項目(要介護認定主治医意見書情報_TMP, 筋力の低下_記入項目, div.getTxtKinryokuTeikaBui().getValue());
        set意見項目Emtpy(要介護認定主治医意見書情報_TMP, 筋力の低下_程度);
        for (RString key : div.getChkKinryokuTeikaTeido().getSelectedKeys()) {
            set意見項目(要介護認定主治医意見書情報_TMP, 筋力の低下_程度, key);
        }
        set意見項目(要介護認定主治医意見書情報_TMP, 関節の拘縮, keyToItemNasiari(div.getChkKansetsuKoshuku().getSelectedKeys()));
        set記入項目(要介護認定主治医意見書情報_TMP, 関節の拘縮_記入項目, div.getTxtKansetsuKoshukuBui().getValue());
        set意見項目Emtpy(要介護認定主治医意見書情報_TMP, 関節の拘縮_程度);
        for (RString key : div.getChkKansetsuKoshukuTeido().getSelectedKeys()) {
            set意見項目(要介護認定主治医意見書情報_TMP, 関節の拘縮_程度, key);
        }
        set意見項目(要介護認定主治医意見書情報_TMP, 関節の痛み, keyToItemNasiari(div.getChkKansetsuItami().getSelectedKeys()));
        set記入項目(要介護認定主治医意見書情報_TMP, 関節の痛み_記入項目, div.getTxtKansetsuItamiBui().getValue());
        set意見項目Emtpy(要介護認定主治医意見書情報_TMP, 関節の痛み_程度);
        for (RString key : div.getChkKansetsuItamiTeido().getSelectedKeys()) {
            set意見項目(要介護認定主治医意見書情報_TMP, 関節の痛み_程度, key);
        }
        set意見項目(要介護認定主治医意見書情報_TMP, 失調_不随意運動, keyToItemNasiari(div.getChkShicchoFuzuii().getSelectedKeys()));
        if (div.getChkFuzuiiJoshi().getSelectedKeys().contains(チェックボックス_1)) {
            set意見項目(要介護認定主治医意見書情報_TMP, 失調_不随意運動_上肢_右, チェックボックス_2);
        }
        if (div.getChkFuzuiiJoshi().getSelectedKeys().contains(チェックボックス_2)) {
            set意見項目(要介護認定主治医意見書情報_TMP, 失調_不随意運動_上肢_左, チェックボックス_2);
        }
        if (div.getChkFuzuiiKashi().getSelectedKeys().contains(チェックボックス_1)) {
            set意見項目(要介護認定主治医意見書情報_TMP, 失調_不随意運動_下肢_右, チェックボックス_2);
        }
        if (div.getChkFuzuiiKashi().getSelectedKeys().contains(チェックボックス_2)) {
            set意見項目(要介護認定主治医意見書情報_TMP, 失調_不随意運動_下肢_左, チェックボックス_2);
        }
        if (div.getChkTaikan().getSelectedKeys().contains(チェックボックス_1)) {
            set意見項目(要介護認定主治医意見書情報_TMP, 失調_不随意運動_体幹_右, チェックボックス_2);
        }
        if (div.getChkTaikan().getSelectedKeys().contains(チェックボックス_2)) {
            set意見項目(要介護認定主治医意見書情報_TMP, 失調_不随意運動_体幹_左, チェックボックス_2);
        }
        set意見項目(要介護認定主治医意見書情報_TMP, じょくそう, keyToItemNasiari(div.getChkJokuso().getSelectedKeys()));
        set記入項目(要介護認定主治医意見書情報_TMP, じょくそう_記入項目, div.getTxtJokusoBui().getValue());
        set意見項目Emtpy(要介護認定主治医意見書情報_TMP, じょくそう_程度);
        for (RString key : div.getChkJokusoTeido().getSelectedKeys()) {
            set意見項目(要介護認定主治医意見書情報_TMP, じょくそう_程度, key);
        }
        set意見項目(要介護認定主治医意見書情報_TMP, その他の皮膚疾患, keyToItemNasiari(div.getChkSonotaHifuShikkan().getSelectedKeys()));
        set記入項目(要介護認定主治医意見書情報_TMP, その他の皮膚疾患_記入項目, div.getTxtSonotaHifuShikkanBui().getValue());
        set意見項目Emtpy(要介護認定主治医意見書情報_TMP, その他の皮膚疾患_程度);
        for (RString key : div.getChkSonotaHifuShikkanTeido().getSelectedKeys()) {
            set意見項目(要介護認定主治医意見書情報_TMP, その他の皮膚疾患_程度, key);
        }
        ShujiiIkenshoIraiJohoIdentifier 主治医意見書作成依頼情報Key = new ShujiiIkenshoIraiJohoIdentifier(new ShinseishoKanriNo(管理番号),
                Integer.valueOf(履歴番号.toString()));
        要介護認定申請情報.createBuilderForEdit().setShujiiIkenshoIraiJoho(要介護認定申請情報.getShujiiIkenshoIraiJoho(主治医意見書作成依頼情報Key)
                .createBuilderForEdit().setShujiiIkenshoJoho(要介護認定主治医意見書情報_TMP).build());
        return 要介護認定申請情報;

    }

    private void set意見項目Emtpy(ShujiiIkenshoJoho 要介護認定主治医意見書情報_T, int 連番) {
        要介護認定主治医意見書情報_T.createBuilderForEdit().setShujiiIkenshoIkenItem(要介護認定主治医意見書情報_TMP
                .getShujiiIkenshoIkenItem(create意見項目の識別子(連番)).createBuilderForEdit().set意見項目(RString.EMPTY).build()).build();
    }

    private void set意見項目(ShujiiIkenshoJoho 要介護認定主治医意見書情報_T, int 連番, RString key) {
        要介護認定主治医意見書情報_T.createBuilderForEdit().setShujiiIkenshoIkenItem(要介護認定主治医意見書情報_TMP
                .getShujiiIkenshoIkenItem(create意見項目の識別子(連番)).createBuilderForEdit().set意見項目(keyToItem(key)).build()).build();
    }

    private void set記入項目(ShujiiIkenshoJoho 要介護認定主治医意見書情報_T, int 連番, RString key) {
        要介護認定主治医意見書情報_T.createBuilderForEdit().setShujiiIkenshoKinyuItem(要介護認定主治医意見書情報_TMP
                .getShujiiIkenshoKinyuItem(create記入項目の識別子(連番)).createBuilderForEdit().set記入項目(key).build()).build();
    }

    private ShujiiIkenshoIkenItemIdentifier create意見項目の識別子(int 連番) {
        return new ShujiiIkenshoIkenItemIdentifier(new ShinseishoKanriNo(管理番号), Integer.parseInt(履歴番号.toString()), 連番);
    }

    private ShujiiIkenshoKinyuItemIdentifier create記入項目の識別子(int 連番) {
        return new ShujiiIkenshoKinyuItemIdentifier(new ShinseishoKanriNo(管理番号), Integer.parseInt(履歴番号.toString()), 連番);
    }

    private RString keyToItem(RString key) {
        if (チェックボックス_1.equals(key)) {
            return IkenKomoku02.自立.getコード();
        } else if (チェックボックス_2.equals(key)) {
            return IkenKomoku02.J1.getコード();
        } else if (チェックボックス_3.equals(key)) {
            return IkenKomoku02.J2.getコード();
        } else if (チェックボックス_4.equals(key)) {
            return IkenKomoku02.A1.getコード();
        } else if (チェックボックス_5.equals(key)) {
            return IkenKomoku02.A2.getコード();
        } else if (チェックボックス_6.equals(key)) {
            return IkenKomoku02.B1.getコード();
        } else if (チェックボックス_7.equals(key)) {
            return IkenKomoku02.B2.getコード();
        } else if (チェックボックス_8.equals(key)) {
            return IkenKomoku02.C1.getコード();
        } else if (チェックボックス_9.equals(key)) {
            return IkenKomoku02.C2.getコード();
        } else if (チェックボックス_10.equals(key)) {
            return IkenKomoku02.未記入.getコード();
        } else {
            return IkenKomoku01.無.getコード();
        }
    }

    private RString keyToItemNasiari(List<RString> keys) {
        if (keys.contains(チェックボックス_1)) {
            return チェックボックス_2;
        }
        return チェックボックス_1;
    }

    private RString set過去6カ月の体重(RString keys) {
        if (keys.contains(チェックボックス_1)) {
            return チェックボックス_1;
        } else if (keys.contains(チェックボックス_2)) {
            return チェックボックス_3;
        } else {
            return チェックボックス_2;
        }
    }
}
