/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.kihonchosainput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput.KihonChosaInputDiv;
import jp.co.ndensan.reams.db.dbz.service.core.kihonchosainput.KihonChosaInputFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 共有子Div「認定基本調査入力」の状態を変更するクラスです。
 */
public class KihonChosaInputHandler {

    private final KihonChosaInputDiv div;
    private final RString 認定調査前回結果表示 = new RString("1");
    private final RString 調査項目1 = new RString("1");
    private final RString 調査項目2 = new RString("2");
    private final RString 調査項目3 = new RString("3");
    private final RString 調査項目4 = new RString("4");
    private final RString 調査項目5 = new RString("5");
    private static final int 整数3 = 3;
    private static final int 整数4 = 4;
    private static final int 整数5 = 5;
    private static final int 整数6 = 6;
    private static final int 整数7 = 7;
    private static final int 整数8 = 8;
    private static final int 整数9 = 9;
    private static final int 整数10 = 10;
    private static final int 整数11 = 11;
    private static final int 整数12 = 12;
    private static final int 整数13 = 13;
    private static final int 整数14 = 14;
    private static final int 整数15 = 15;
    private static final int 整数16 = 16;
    private static final int 整数17 = 17;
    private static final int 整数18 = 18;
    private static final int 整数19 = 19;
    private static final int 整数20 = 20;
    private static final int 整数21 = 21;
    private static final int 整数22 = 22;
    private static final int 整数23 = 23;
    private static final int 整数24 = 24;
    private static final int 整数25 = 25;
    private static final int 整数26 = 26;
    private static final int 整数27 = 27;
    private static final int 整数28 = 28;
    private static final int 整数29 = 29;
    private static final int 整数30 = 30;
    private static final int 整数31 = 31;
    private static final int 整数32 = 32;
    private static final int 整数33 = 33;
    private static final int 整数34 = 34;
    private static final int 整数35 = 35;
    private static final int 整数36 = 36;
    private static final int 整数37 = 37;
    private static final int 整数38 = 38;
    private static final int 整数39 = 39;
    private static final int 整数40 = 40;
    private static final int 整数41 = 41;
    private static final int 整数42 = 42;
    private static final int 整数43 = 43;
    private static final int 整数44 = 44;
    private static final int 整数45 = 45;
    private static final int 整数46 = 46;
    private static final int 整数47 = 47;
    private static final int 整数48 = 48;
    private static final int 整数49 = 49;
    private static final int 整数50 = 50;
    private static final int 整数51 = 51;
    private static final int 整数52 = 52;
    private static final int 整数53 = 53;
    private static final int 整数54 = 54;
    private static final int 整数55 = 55;
    private static final int 整数56 = 56;
    private static final int 整数57 = 57;
    private static final int 整数58 = 58;
    private static final int 整数59 = 59;
    private static final int 整数60 = 60;
    private static final int 整数61 = 61;
    private static final int 整数62 = 62;
    private static final int 整数63 = 63;
    private static final int 整数64 = 64;
    private static final int 整数65 = 65;
    private static final int 整数66 = 66;
    private static final int 整数67 = 67;
    private static final int 整数68 = 68;
    private static final int 整数69 = 69;
    private static final int 整数70 = 70;
    private static final int 整数71 = 71;
    private static final int 整数72 = 72;
    private static final int 整数73 = 73;
    private static final int 整数74 = 74;
    private static final RString KEY1 = new RString("key1");
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY2 = new RString("key2");
    private static final RString KEY3 = new RString("key3");
    private static final RString KEY4 = new RString("key4");
    private static final RString KEY5 = new RString("key5");
    private static final RString KEY6 = new RString("key6");
    private static final RString KEY7 = new RString("key7");
    private static final RString KEY8 = new RString("key8");

    /**
     * コンストラクタです。
     *
     * @param div KihonChosaInputDiv
     */
    public KihonChosaInputHandler(KihonChosaInputDiv div) {
        this.div = div;
    }

    /**
     * 共有子Divの麻痺等の有無ないCHKします。
     *
     */
    public void 麻痺等の有無ないChange() {
        List<RString> selectedKeys = div.getChkMahi().getSelectedKeys();
        RString paraSelected = div.getMahi().getIsMahiSelected();
        RString selected;
        List<RString> selectedItems = new ArrayList<>();
        if (selectedKeys.contains(KEY0)) {
            selectedItems.add(KEY0);
            selected = new RString("1");
        } else {
            selected = new RString("0");
        }
        List<RString> disabledItems = new ArrayList<>();
        if (!selected.equals(paraSelected)) {
            div.getMahi().setIsMahiSelected(selected);
            if (new RString("1").equals(selected)) {
                disabledItems.add(KEY1);
                disabledItems.add(KEY2);
                disabledItems.add(KEY3);
                disabledItems.add(KEY4);
                disabledItems.add(KEY5);
                div.getChkMahi().setSelectedItemsByKey(selectedItems);
                div.getChkMahi().setDisabledItemsByKey(disabledItems);
            } else {
                div.getChkMahi().setDisabledItemsByKey(disabledItems);
            }
        }
    }

    /**
     * 共有子Divの拘縮の有無ないCHKします。
     *
     */
    public void 拘縮の有無ないChange() {
        List<RString> selectedKeys = div.getChkKoshuku().getSelectedKeys();
        RString paraSelected = div.getKoshuku().getIsKoshukuSelected();
        RString selected;
        List<RString> selectedItems = new ArrayList<>();
        if (selectedKeys.contains(KEY0)) {
            selectedItems.add(KEY0);
            selected = new RString("1");
        } else {
            selected = new RString("0");
        }
        List<RString> disabledItems = new ArrayList<>();
        if (!selected.equals(paraSelected)) {
            div.getKoshuku().setIsKoshukuSelected(selected);
            if (new RString("1").equals(selected)) {
                disabledItems.add(KEY1);
                disabledItems.add(KEY2);
                disabledItems.add(KEY3);
                disabledItems.add(KEY4);
                div.getChkKoshuku().setSelectedItemsByKey(selectedItems);
                div.getChkKoshuku().setDisabledItemsByKey(disabledItems);
            } else {
                div.getChkKoshuku().setDisabledItemsByKey(disabledItems);
            }
        }
    }

    /**
     * 共有子Divの状態を初期化します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     */
    public void onload(ShinseishoKanriNo 申請書管理番号, RString 認定調査依頼履歴番号) {
        KihonChosaInputFinder findler = KihonChosaInputFinder.createInstance();
        if (申請書管理番号 != null) {
            div.getDaiichigunShintaiKino().setShinseishoKanriNo(申請書管理番号.getColumnValue());
        }
        div.getDaiichigunShintaiKino().setRecordNumber(認定調査依頼履歴番号);
        List<KihonChosaInput> 認定調査基本情報リスト = findler.get認定調査基本情報(申請書管理番号);
        RString 認定調査前回結果表示 = BusinessConfig.get(ConfigNameDBE.認定調査前回結果表示, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        onlod1(認定調査基本情報リスト, 認定調査前回結果表示);
        onlod2(認定調査基本情報リスト, 認定調査前回結果表示);
    }

    private void onlod1(List<KihonChosaInput> 認定調査基本情報リスト, RString 認定調査前回結果表示) {
        List<RString> 麻痺等の有無Keys = new ArrayList<>();
        List<RString> 前回麻痺等の有無Keys = new ArrayList<>();
        List<RString> 麻痺等の有無特記事項番号 = new ArrayList<>();
        List<RString> 拘縮の有無Keys = new ArrayList<>();
        List<RString> 前回拘縮の有無Keys = new ArrayList<>();
        List<RString> 拘縮の有無特記事項番号 = new ArrayList<>();
        List<RString> 寝返りKeys = new ArrayList<>();
        List<RString> 前回寝返りKeys = new ArrayList<>();
        List<RString> 起き上がりKeys = new ArrayList<>();
        List<RString> 前回起き上がりKeys = new ArrayList<>();
        List<RString> 座位保持Keys = new ArrayList<>();
        List<RString> 前回座位保持Keys = new ArrayList<>();
        List<RString> 両足での立位保持Keys = new ArrayList<>();
        List<RString> 前回両足での立位保持Keys = new ArrayList<>();
        List<RString> 歩行Keys = new ArrayList<>();
        List<RString> 前回歩行Keys = new ArrayList<>();
        List<RString> 立ち上がりKeys = new ArrayList<>();
        List<RString> 前回立ち上がりKeys = new ArrayList<>();
        List<RString> 片足での立位Keys = new ArrayList<>();
        List<RString> 前回片足での立位Keys = new ArrayList<>();
        List<RString> 洗身Keys = new ArrayList<>();
        List<RString> 前回洗身Keys = new ArrayList<>();
        List<RString> つめ切りKeys = new ArrayList<>();
        List<RString> 前回つめ切りKeys = new ArrayList<>();
        List<RString> 視力Keys = new ArrayList<>();
        List<RString> 前回視力Keys = new ArrayList<>();
        List<RString> 聴力Keys = new ArrayList<>();
        List<RString> 前回聴力Keys = new ArrayList<>();
        List<RString> 移乗Keys = new ArrayList<>();
        List<RString> 前回移乗Keys = new ArrayList<>();
        List<RString> 移動Keys = new ArrayList<>();
        List<RString> 前回移動Keys = new ArrayList<>();
        List<RString> えん下Keys = new ArrayList<>();
        List<RString> 前回えん下Keys = new ArrayList<>();
        List<RString> 食事摂取Keys = new ArrayList<>();
        List<RString> 前回食事摂取Keys = new ArrayList<>();
        List<RString> 排尿Keys = new ArrayList<>();
        List<RString> 前回排尿Keys = new ArrayList<>();
        List<RString> 排便Keys = new ArrayList<>();
        List<RString> 前回排便Keys = new ArrayList<>();
        List<RString> 口腔清潔Keys = new ArrayList<>();
        List<RString> 前回口腔清潔Keys = new ArrayList<>();
        List<RString> 洗顔Keys = new ArrayList<>();
        List<RString> 前回洗顔Keys = new ArrayList<>();
        List<RString> 整髪Keys = new ArrayList<>();
        List<RString> 前回整髪Keys = new ArrayList<>();
        List<RString> 上衣の着脱Keys = new ArrayList<>();
        List<RString> 前回上衣の着脱Keys = new ArrayList<>();
        List<RString> ズボン等の着脱Keys = new ArrayList<>();
        List<RString> 前回ズボン等の着脱Keys = new ArrayList<>();
        List<RString> 外出頻度Keys = new ArrayList<>();
        List<RString> 前回外出頻度Keys = new ArrayList<>();
        List<RString> 意思の伝達Keys = new ArrayList<>();
        List<RString> 前回意思の伝達Keys = new ArrayList<>();
        List<RString> 毎日の日課を理解Keys = new ArrayList<>();
        List<RString> 前回毎日の日課を理解Keys = new ArrayList<>();
        for (KihonChosaInput 認定調査基本情報 : 認定調査基本情報リスト) {
            set麻痺等の有無Keys(麻痺等の有無Keys, 前回麻痺等の有無Keys, 麻痺等の有無特記事項番号, 認定調査基本情報);
            set拘縮の有無Keys(拘縮の有無Keys, 前回拘縮の有無Keys, 拘縮の有無特記事項番号, 認定調査基本情報);
            set寝返り(寝返りKeys, 前回寝返りKeys, 認定調査基本情報);
            set起き上がり(起き上がりKeys, 前回起き上がりKeys, 認定調査基本情報);
            set座位保持(座位保持Keys, 前回座位保持Keys, 認定調査基本情報);
            set両足での立位保持(両足での立位保持Keys, 前回両足での立位保持Keys, 認定調査基本情報);
            set歩行(歩行Keys, 前回歩行Keys, 認定調査基本情報);
            set立ち上がり(立ち上がりKeys, 前回立ち上がりKeys, 認定調査基本情報);
            set片足での立位(片足での立位Keys, 前回片足での立位Keys, 認定調査基本情報);
            set洗身(洗身Keys, 前回洗身Keys, 認定調査基本情報);
            setつめ切り(つめ切りKeys, 前回つめ切りKeys, 認定調査基本情報);
            set視力(視力Keys, 前回視力Keys, 認定調査基本情報);
            set聴力(聴力Keys, 前回聴力Keys, 認定調査基本情報);
            set移乗(移乗Keys, 前回移乗Keys, 認定調査基本情報);
            set移動(移動Keys, 前回移動Keys, 認定調査基本情報);
            setえん下(えん下Keys, 前回えん下Keys, 認定調査基本情報);
            set食事摂取(食事摂取Keys, 前回食事摂取Keys, 認定調査基本情報);
            set排尿(排尿Keys, 前回排尿Keys, 認定調査基本情報);
            set排便(排便Keys, 前回排便Keys, 認定調査基本情報);
            set口腔清潔(口腔清潔Keys, 前回口腔清潔Keys, 認定調査基本情報);
            set洗顔(洗顔Keys, 前回洗顔Keys, 認定調査基本情報);
            set整髪(整髪Keys, 前回整髪Keys, 認定調査基本情報);
            set上衣の着脱(上衣の着脱Keys, 前回上衣の着脱Keys, 認定調査基本情報);
            setズボン等の着脱(ズボン等の着脱Keys, 前回ズボン等の着脱Keys, 認定調査基本情報);
            set外出頻度(外出頻度Keys, 前回外出頻度Keys, 認定調査基本情報);
            set意思の伝達(意思の伝達Keys, 前回意思の伝達Keys, 認定調査基本情報);
            set毎日の日課を理解(毎日の日課を理解Keys, 前回毎日の日課を理解Keys, 認定調査基本情報);
        }
        麻痺等の有無画面表示(麻痺等の有無Keys, 前回麻痺等の有無Keys, 麻痺等の有無特記事項番号, 認定調査前回結果表示);
        拘縮の有無画面表示(拘縮の有無Keys, 前回拘縮の有無Keys, 拘縮の有無特記事項番号, 認定調査前回結果表示);
        寝返り画面表示(寝返りKeys, 前回寝返りKeys, 認定調査前回結果表示);
        起き上がり画面表示(起き上がりKeys, 前回起き上がりKeys, 認定調査前回結果表示);
        座位保持画面表示(座位保持Keys, 前回座位保持Keys, 認定調査前回結果表示);
        両足での立位保持画面表示(両足での立位保持Keys, 前回両足での立位保持Keys, 認定調査前回結果表示);
        歩行画面表示(歩行Keys, 前回歩行Keys, 認定調査前回結果表示);
        立ち上がり画面表示(立ち上がりKeys, 前回立ち上がりKeys, 認定調査前回結果表示);
        片足での立位画面表示(片足での立位Keys, 前回片足での立位Keys, 認定調査前回結果表示);
        洗身画面表示(洗身Keys, 前回洗身Keys, 認定調査前回結果表示);
        つめ切り画面表示(つめ切りKeys, 前回つめ切りKeys, 認定調査前回結果表示);
        視力画面表示(視力Keys, 前回視力Keys, 認定調査前回結果表示);
        聴力画面表示(聴力Keys, 前回聴力Keys, 認定調査前回結果表示);
        移乗画面表示(移乗Keys, 前回移乗Keys, 認定調査前回結果表示);
        移動画面表示(移動Keys, 前回移動Keys, 認定調査前回結果表示);
        えん下画面表示(えん下Keys, 前回えん下Keys, 認定調査前回結果表示);
        食事摂取画面表示(食事摂取Keys, 前回食事摂取Keys, 認定調査前回結果表示);
        排尿画面表示(排尿Keys, 前回排尿Keys, 認定調査前回結果表示);
        排便画面表示(排便Keys, 前回排便Keys, 認定調査前回結果表示);
        口腔清潔画面表示(口腔清潔Keys, 前回口腔清潔Keys, 認定調査前回結果表示);
        洗顔画面表示(洗顔Keys, 前回洗顔Keys, 認定調査前回結果表示);
        整髪画面表示(整髪Keys, 前回整髪Keys, 認定調査前回結果表示);
        上衣の着脱画面表示(上衣の着脱Keys, 前回上衣の着脱Keys, 認定調査前回結果表示);
        ズボン等の着脱画面表示(ズボン等の着脱Keys, 前回ズボン等の着脱Keys, 認定調査前回結果表示);
        外出頻度画面表示(外出頻度Keys, 前回外出頻度Keys, 認定調査前回結果表示);
        意思の伝達画面表示(意思の伝達Keys, 前回意思の伝達Keys, 認定調査前回結果表示);
        毎日の日課を理解画面表示(毎日の日課を理解Keys, 前回毎日の日課を理解Keys, 認定調査前回結果表示);
    }

    private void onlod2(List<KihonChosaInput> 認定調査基本情報リスト, RString 認定調査前回結果表示) {
        List<RString> 生年月日や年齢を言うKeys = new ArrayList<>();
        List<RString> 前回生年月日や年齢を言うKeys = new ArrayList<>();
        List<RString> 短期記憶Keys = new ArrayList<>();
        List<RString> 前回短期記憶Keys = new ArrayList<>();
        List<RString> 自分の名前を言うKeys = new ArrayList<>();
        List<RString> 前回自分の名前を言うKeys = new ArrayList<>();
        List<RString> 今の季節を理解するKeys = new ArrayList<>();
        List<RString> 前回今の季節を理解するKeys = new ArrayList<>();
        List<RString> 場所の理解Keys = new ArrayList<>();
        List<RString> 前回場所の理解Keys = new ArrayList<>();
        List<RString> 徘徊Keys = new ArrayList<>();
        List<RString> 前回徘徊Keys = new ArrayList<>();
        List<RString> 外出すると戻れないKeys = new ArrayList<>();
        List<RString> 前回外出すると戻れないKeys = new ArrayList<>();
        List<RString> 被虐的Keys = new ArrayList<>();
        List<RString> 前回被虐的Keys = new ArrayList<>();
        List<RString> 作話Keys = new ArrayList<>();
        List<RString> 前回作話Keys = new ArrayList<>();
        List<RString> 感情が不安定Keys = new ArrayList<>();
        List<RString> 前回感情が不安定Keys = new ArrayList<>();
        List<RString> 昼夜逆転Keys = new ArrayList<>();
        List<RString> 前回昼夜逆転Keys = new ArrayList<>();
        List<RString> 同じ話をするKeys = new ArrayList<>();
        List<RString> 前回同じ話をするKeys = new ArrayList<>();
        List<RString> 大声をだすKeys = new ArrayList<>();
        List<RString> 前回大声をだすKeys = new ArrayList<>();
        List<RString> 介護に抵抗Keys = new ArrayList<>();
        List<RString> 前回介護に抵抗Keys = new ArrayList<>();
        List<RString> 落ち着きなしKeys = new ArrayList<>();
        List<RString> 前回落ち着きなしKeys = new ArrayList<>();
        List<RString> 一人で出たがるKeys = new ArrayList<>();
        List<RString> 前回一人で出たがるKeys = new ArrayList<>();
        List<RString> 収集癖Keys = new ArrayList<>();
        List<RString> 前回収集癖Keys = new ArrayList<>();
        List<RString> 物や衣類を壊すKeys = new ArrayList<>();
        List<RString> 前回物や衣類を壊すKeys = new ArrayList<>();
        List<RString> ひどい物忘れKeys = new ArrayList<>();
        List<RString> 前回ひどい物忘れKeys = new ArrayList<>();
        List<RString> 独り言_独り笑いKeys = new ArrayList<>();
        List<RString> 前回独り言_独り笑いKeys = new ArrayList<>();
        List<RString> 自分勝手に行動するKeys = new ArrayList<>();
        List<RString> 前回自分勝手に行動するKeys = new ArrayList<>();
        List<RString> 話がまとまらないKeys = new ArrayList<>();
        List<RString> 前回話がまとまらないKeys = new ArrayList<>();
        List<RString> 薬の内服Keys = new ArrayList<>();
        List<RString> 前回薬の内服Keys = new ArrayList<>();
        List<RString> 金銭の管理Keys = new ArrayList<>();
        List<RString> 前回金銭の管理Keys = new ArrayList<>();
        List<RString> 日常の意思決定Keys = new ArrayList<>();
        List<RString> 前回日常の意思決定Keys = new ArrayList<>();
        List<RString> 集団への不適用Keys = new ArrayList<>();
        List<RString> 前回集団への不適用Keys = new ArrayList<>();
        List<RString> 買い物Keys = new ArrayList<>();
        List<RString> 前回買い物Keys = new ArrayList<>();
        List<RString> 簡単な調理Keys = new ArrayList<>();
        List<RString> 前回簡単な調理Keys = new ArrayList<>();
        List<RString> 特別な対応Keys = new ArrayList<>();
        List<RString> 前回特別な対応Keys = new ArrayList<>();
        List<RString> 特別な対応特記事項番号 = new ArrayList<>();
        List<RString> 障害高齢者の日常生活自立度_寝たきり度Keys = new ArrayList<>();
        List<RString> 前回障害高齢者の日常生活自立度_寝たきり度Keys = new ArrayList<>();
        List<RString> 認知症高齢者の日常生活自立度Keys = new ArrayList<>();
        List<RString> 前回認知症高齢者の日常生活自立度Keys = new ArrayList<>();
        List<RString> 処置内容Keys = new ArrayList<>();
        List<RString> 前回処置内容Keys = new ArrayList<>();
        List<RString> 処置内容特記事項番号 = new ArrayList<>();
        for (KihonChosaInput 認定調査基本情報 : 認定調査基本情報リスト) {
            set生年月日や年齢を言う(生年月日や年齢を言うKeys, 前回生年月日や年齢を言うKeys, 認定調査基本情報);
            set短期記憶(短期記憶Keys, 前回短期記憶Keys, 認定調査基本情報);
            set自分の名前を言う(自分の名前を言うKeys, 前回自分の名前を言うKeys, 認定調査基本情報);
            set今の季節を理解する(今の季節を理解するKeys, 前回今の季節を理解するKeys, 認定調査基本情報);
            set場所の理解(場所の理解Keys, 前回場所の理解Keys, 認定調査基本情報);
            set徘徊(徘徊Keys, 前回徘徊Keys, 認定調査基本情報);
            set外出すると戻れない(外出すると戻れないKeys, 前回外出すると戻れないKeys, 認定調査基本情報);
            set被虐的(被虐的Keys, 前回被虐的Keys, 認定調査基本情報);
            set作話(作話Keys, 前回作話Keys, 認定調査基本情報);
            set感情が不安定(感情が不安定Keys, 前回感情が不安定Keys, 認定調査基本情報);
            set昼夜逆転(昼夜逆転Keys, 前回昼夜逆転Keys, 認定調査基本情報);
            set同じ話をする(同じ話をするKeys, 前回同じ話をするKeys, 認定調査基本情報);
            set大声をだす(大声をだすKeys, 前回大声をだすKeys, 認定調査基本情報);
            set介護に抵抗(介護に抵抗Keys, 前回介護に抵抗Keys, 認定調査基本情報);
            set落ち着きなし(落ち着きなしKeys, 前回落ち着きなしKeys, 認定調査基本情報);
            set一人で出たがる(一人で出たがるKeys, 前回一人で出たがるKeys, 認定調査基本情報);
            set収集癖(収集癖Keys, 前回収集癖Keys, 認定調査基本情報);
            set物や衣類を壊す(物や衣類を壊すKeys, 前回物や衣類を壊すKeys, 認定調査基本情報);
            setひどい物忘れ(ひどい物忘れKeys, 前回ひどい物忘れKeys, 認定調査基本情報);
            set独り言_独り笑い(独り言_独り笑いKeys, 前回独り言_独り笑いKeys, 認定調査基本情報);
            set自分勝手に行動する(自分勝手に行動するKeys, 前回自分勝手に行動するKeys, 認定調査基本情報);
            set話がまとまらない(話がまとまらないKeys, 前回話がまとまらないKeys, 認定調査基本情報);
            set薬の内服(薬の内服Keys, 前回薬の内服Keys, 認定調査基本情報);
            set金銭の管理(金銭の管理Keys, 前回金銭の管理Keys, 認定調査基本情報);
            set日常の意思決定(日常の意思決定Keys, 前回日常の意思決定Keys, 認定調査基本情報);
            set集団への不適用(集団への不適用Keys, 前回集団への不適用Keys, 認定調査基本情報);
            set買い物(買い物Keys, 前回買い物Keys, 認定調査基本情報);
            set簡単な調理(簡単な調理Keys, 前回簡単な調理Keys, 認定調査基本情報);
            set特別な対応Keys(特別な対応Keys, 前回特別な対応Keys, 特別な対応特記事項番号, 認定調査基本情報);
            set処置内容Keys(処置内容Keys, 前回処置内容Keys, 処置内容特記事項番号, 認定調査基本情報);
            set障害高齢者の日常生活自立度_寝たきり度Keys(障害高齢者の日常生活自立度_寝たきり度Keys,
                    前回障害高齢者の日常生活自立度_寝たきり度Keys, 認定調査基本情報);
            set認知症高齢者の日常生活自立度Keys(認知症高齢者の日常生活自立度Keys, 前回認知症高齢者の日常生活自立度Keys, 認定調査基本情報);
        }
        生年月日や年齢を言う画面表示(生年月日や年齢を言うKeys, 前回生年月日や年齢を言うKeys, 認定調査前回結果表示);
        短期記憶画面表示(短期記憶Keys, 前回短期記憶Keys, 認定調査前回結果表示);
        自分の名前を言う画面表示(自分の名前を言うKeys, 前回自分の名前を言うKeys, 認定調査前回結果表示);
        今の季節を理解する画面表示(今の季節を理解するKeys, 前回今の季節を理解するKeys, 認定調査前回結果表示);
        場所の理解画面表示(場所の理解Keys, 前回場所の理解Keys, 認定調査前回結果表示);
        徘徊画面表示(徘徊Keys, 前回徘徊Keys, 認定調査前回結果表示);
        外出すると戻れない画面表示(外出すると戻れないKeys, 前回外出すると戻れないKeys, 認定調査前回結果表示);
        被虐的画面表示(被虐的Keys, 前回被虐的Keys, 認定調査前回結果表示);
        作話画面表示(作話Keys, 前回作話Keys, 認定調査前回結果表示);
        感情が不安定画面表示(感情が不安定Keys, 前回感情が不安定Keys, 認定調査前回結果表示);
        昼夜逆転画面表示(昼夜逆転Keys, 前回昼夜逆転Keys, 認定調査前回結果表示);
        同じ話をする画面表示(同じ話をするKeys, 前回同じ話をするKeys, 認定調査前回結果表示);
        大声をだす画面表示(大声をだすKeys, 前回大声をだすKeys, 認定調査前回結果表示);
        介護に抵抗画面表示(介護に抵抗Keys, 前回介護に抵抗Keys, 認定調査前回結果表示);
        落ち着きなし画面表示(落ち着きなしKeys, 前回落ち着きなしKeys, 認定調査前回結果表示);
        一人で出たがる画面表示(一人で出たがるKeys, 前回一人で出たがるKeys, 認定調査前回結果表示);
        収集癖画面表示(収集癖Keys, 前回収集癖Keys, 認定調査前回結果表示);
        物や衣類を壊す画面表示(物や衣類を壊すKeys, 前回物や衣類を壊すKeys, 認定調査前回結果表示);
        ひどい物忘れ画面表示(ひどい物忘れKeys, 前回ひどい物忘れKeys, 認定調査前回結果表示);
        独り言_独り笑い画面表示(独り言_独り笑いKeys, 前回独り言_独り笑いKeys, 認定調査前回結果表示);
        自分勝手に行動する画面表示(自分勝手に行動するKeys, 前回自分勝手に行動するKeys, 認定調査前回結果表示);
        話がまとまらない画面表示(話がまとまらないKeys, 前回話がまとまらないKeys, 認定調査前回結果表示);
        薬の内服画面表示(薬の内服Keys, 前回薬の内服Keys, 認定調査前回結果表示);
        金銭の管理画面表示(金銭の管理Keys, 前回金銭の管理Keys, 認定調査前回結果表示);
        日常の意思決定画面表示(日常の意思決定Keys, 前回日常の意思決定Keys, 認定調査前回結果表示);
        集団への不適用画面表示(集団への不適用Keys, 前回集団への不適用Keys, 認定調査前回結果表示);
        買い物画面表示(買い物Keys, 前回買い物Keys, 認定調査前回結果表示);
        簡単な調理画面表示(簡単な調理Keys, 前回簡単な調理Keys, 認定調査前回結果表示);
        特別な対応画面表示(特別な対応Keys, 前回特別な対応Keys, 特別な対応特記事項番号, 認定調査前回結果表示);
        障害高齢者の日常生活自立度_寝たきり度画面表示(障害高齢者の日常生活自立度_寝たきり度Keys,
                前回障害高齢者の日常生活自立度_寝たきり度Keys, 認定調査前回結果表示);
        認知症高齢者の日常生活自立度画面表示(認知症高齢者の日常生活自立度Keys, 前回認知症高齢者の日常生活自立度Keys, 認定調査前回結果表示);
        処置内容画面表示(処置内容Keys, 前回処置内容Keys, 処置内容特記事項番号, 認定調査前回結果表示);
    }

    private void set認知症高齢者の日常生活自立度Keys(List<RString> 認知症高齢者の日常生活自立度Keys,
            List<RString> 前回認知症高齢者の日常生活自立度Keys, KihonChosaInput 認定調査基本情報) {
        RString 認知症高齢者自立度RString = 認定調査基本情報.get認知症高齢者自立度().getColumnValue();
        RString 前回認知症高齢者自立度RString = 認定調査基本情報.get前回認知症高齢者自立度().getColumnValue();
        if (NinchishoNichijoSeikatsuJiritsudoCode.自立.getコード().equals(認知症高齢者自立度RString)) {
            認知症高齢者の日常生活自立度Keys.add(KEY0);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅰ.getコード().equals(認知症高齢者自立度RString)) {
            認知症高齢者の日常生活自立度Keys.add(KEY1);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅱa.getコード().equals(認知症高齢者自立度RString)) {
            認知症高齢者の日常生活自立度Keys.add(KEY2);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅱb.getコード().equals(認知症高齢者自立度RString)) {
            認知症高齢者の日常生活自立度Keys.add(KEY3);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅲa.getコード().equals(認知症高齢者自立度RString)) {
            認知症高齢者の日常生活自立度Keys.add(KEY4);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅲb.getコード().equals(認知症高齢者自立度RString)) {
            認知症高齢者の日常生活自立度Keys.add(KEY5);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅳ.getコード().equals(認知症高齢者自立度RString)) {
            認知症高齢者の日常生活自立度Keys.add(KEY6);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.M.getコード().equals(認知症高齢者自立度RString)) {
            認知症高齢者の日常生活自立度Keys.add(KEY7);
        }
        if (NinchishoNichijoSeikatsuJiritsudoCode.自立.getコード().equals(前回認知症高齢者自立度RString)) {
            前回認知症高齢者の日常生活自立度Keys.add(KEY0);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅰ.getコード().equals(前回認知症高齢者自立度RString)) {
            前回認知症高齢者の日常生活自立度Keys.add(KEY1);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅱa.getコード().equals(前回認知症高齢者自立度RString)) {
            前回認知症高齢者の日常生活自立度Keys.add(KEY2);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅱb.getコード().equals(前回認知症高齢者自立度RString)) {
            前回認知症高齢者の日常生活自立度Keys.add(KEY3);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅲa.getコード().equals(前回認知症高齢者自立度RString)) {
            前回認知症高齢者の日常生活自立度Keys.add(KEY4);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅲb.getコード().equals(前回認知症高齢者自立度RString)) {
            前回認知症高齢者の日常生活自立度Keys.add(KEY5);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.Ⅳ.getコード().equals(前回認知症高齢者自立度RString)) {
            前回認知症高齢者の日常生活自立度Keys.add(KEY6);
        } else if (NinchishoNichijoSeikatsuJiritsudoCode.M.getコード().equals(前回認知症高齢者自立度RString)) {
            前回認知症高齢者の日常生活自立度Keys.add(KEY7);
        }
    }

    private void 認知症高齢者の日常生活自立度画面表示(List<RString> 認知症高齢者の日常生活自立度Keys,
            List<RString> 前回認知症高齢者の日常生活自立度Keys, RString 認定調査前回結果表示) {
        if (認知症高齢者の日常生活自立度Keys.isEmpty()) {
            div.getBtnNinchishaJiritsudo().setDisabled(true);
        } else {
            div.getRadNinchishaJiritsudo().setSelectedKey(認知症高齢者の日常生活自立度Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            認知症高齢者の日常生活自立度アンダーライン(前回認知症高齢者の日常生活自立度Keys);
        }
    }

    private void 認知症高齢者の日常生活自立度アンダーライン(List<RString> 前回認知症高齢者の日常生活自立度) {
        if (!前回認知症高齢者の日常生活自立度.isEmpty()) {
            //TODO
            div.getRadNinchishaJiritsudo();
        }
    }

    private void set障害高齢者の日常生活自立度_寝たきり度Keys(List<RString> 障害高齢者の日常生活自立度_寝たきり度Keys,
            List<RString> 前回障害高齢者の日常生活自立度_寝たきり度Keys, KihonChosaInput 認定調査基本情報) {
        RString 障害高齢者自立度RString = 認定調査基本情報.get障害高齢者自立度().getColumnValue();
        RString 前回障害高齢者自立度RString = 認定調査基本情報.get前回障害高齢者自立度().getColumnValue();
        if (ShogaiNichijoSeikatsuJiritsudoCode.自立.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY0);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.J1.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY1);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.J2.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY2);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.A1.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY3);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.A2.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY4);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.B1.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY5);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.B2.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY6);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.C1.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY7);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.C2.getコード().equals(障害高齢者自立度RString)) {
            障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY8);
        }
        if (ShogaiNichijoSeikatsuJiritsudoCode.自立.getコード().equals(前回障害高齢者自立度RString)) {
            前回障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY0);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.J1.getコード().equals(前回障害高齢者自立度RString)) {
            前回障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY1);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.J2.getコード().equals(前回障害高齢者自立度RString)) {
            前回障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY2);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.A1.getコード().equals(前回障害高齢者自立度RString)) {
            前回障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY3);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.A2.getコード().equals(前回障害高齢者自立度RString)) {
            前回障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY4);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.B1.getコード().equals(前回障害高齢者自立度RString)) {
            前回障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY5);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.B2.getコード().equals(前回障害高齢者自立度RString)) {
            前回障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY6);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.C1.getコード().equals(前回障害高齢者自立度RString)) {
            前回障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY7);
        } else if (ShogaiNichijoSeikatsuJiritsudoCode.C2.getコード().equals(前回障害高齢者自立度RString)) {
            前回障害高齢者の日常生活自立度_寝たきり度Keys.add(KEY8);
        }
    }

    private void 障害高齢者の日常生活自立度_寝たきり度画面表示(List<RString> 障害高齢者の日常生活自立度_寝たきり度Keys,
            List<RString> 前回障害高齢者の日常生活自立度_寝たきり度Keys, RString 認定調査前回結果表示) {
        if (障害高齢者の日常生活自立度_寝たきり度Keys.isEmpty()) {
            div.getBtnShogaiKoreisha().setDisabled(true);
        } else {
            div.getRadShogaiKoreisha().setSelectedKey(障害高齢者の日常生活自立度_寝たきり度Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            障害高齢者の日常生活自立度_寝たきり度アンダーライン(前回障害高齢者の日常生活自立度_寝たきり度Keys);
        }
    }

    private void 障害高齢者の日常生活自立度_寝たきり度アンダーライン(List<RString> 前回障害高齢者の日常生活自立度_寝たきり度) {
        if (!前回障害高齢者の日常生活自立度_寝たきり度.isEmpty()) {
            //TODO
            div.getRadShogaiKoreisha();
        }
    }

    private void set特別な対応Keys(List<RString> 特別な対応Keys, List<RString> 前回特別な対応Keys,
            List<RString> 特別な対応特記事項番号, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 特記事項番号 = 認定調査基本情報.get認定調査特記事項番号();
        if (連番 == 整数72) {
            特別な対応Keys.add(KEY0);
            特別な対応特記事項番号.add(特記事項番号);
        } else if (連番 == 整数73) {
            特別な対応Keys.add(KEY1);
            特別な対応特記事項番号.add(特記事項番号);
        } else if (連番 == 整数74) {
            特別な対応Keys.add(KEY2);
            特別な対応特記事項番号.add(特記事項番号);
        }
        if (前回連番 == 整数72) {
            前回特別な対応Keys.add(KEY0);
        } else if (前回連番 == 整数73) {
            前回特別な対応Keys.add(KEY1);
        } else if (前回連番 == 整数74) {
            前回特別な対応Keys.add(KEY2);
        }
    }

    private void 特別な対応画面表示(List<RString> 特別な対応Keys, List<RString> 前回特別な対応Keys,
            List<RString> 特別な対応特記事項番号, RString 認定調査前回結果表示) {
        if (特別な対応Keys.isEmpty()) {
            div.getBtnTokiTaiou().setDisabled(true);
            div.getTokiTaiou().setIsTokiTaiouSelected(new RString("0"));
        } else {
            div.getChkTokiTaiou().setSelectedItemsByKey(特別な対応Keys);
            div.getTokiTaiou().setTokiTaiouShinseishoKanriNo(DataPassingConverter.serialize(
                    new ArrayList<RString>().addAll(特別な対応特記事項番号)));
            div.getTokiTaiou().setIsTokiTaiouSelected(new RString("1"));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            特別な対応アンダーライン(前回特別な対応Keys);
        }
    }

    private void 特別な対応アンダーライン(List<RString> 前回特別な対応) {
        if (!前回特別な対応.isEmpty()) {
            //TODO
            div.getChkTokiTaiou();
        }
    }

    private void set処置内容Keys(List<RString> 処置内容Keys, List<RString> 前回処置内容Keys,
            List<RString> 処置内容特記事項番号, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 特記事項番号 = 認定調査基本情報.get認定調査特記事項番号();
        if (連番 == 整数63) {
            処置内容Keys.add(KEY0);
            処置内容特記事項番号.add(特記事項番号);
        } else if (連番 == 整数64) {
            処置内容Keys.add(KEY1);
            処置内容特記事項番号.add(特記事項番号);
        } else if (連番 == 整数65) {
            処置内容Keys.add(KEY2);
            処置内容特記事項番号.add(特記事項番号);
        } else if (連番 == 整数66) {
            処置内容Keys.add(KEY3);
            処置内容特記事項番号.add(特記事項番号);
        } else if (連番 == 整数67) {
            処置内容Keys.add(KEY4);
            処置内容特記事項番号.add(特記事項番号);
        } else if (連番 == 整数68) {
            処置内容Keys.add(KEY5);
            処置内容特記事項番号.add(特記事項番号);
        } else if (連番 == 整数69) {
            処置内容Keys.add(KEY6);
            処置内容特記事項番号.add(特記事項番号);
        } else if (連番 == 整数70) {
            処置内容Keys.add(KEY7);
            処置内容特記事項番号.add(特記事項番号);
        } else if (連番 == 整数71) {
            処置内容Keys.add(KEY8);
            処置内容特記事項番号.add(特記事項番号);
        }
        if (前回連番 == 整数63) {
            前回処置内容Keys.add(KEY0);
        } else if (前回連番 == 整数64) {
            前回処置内容Keys.add(KEY1);
        } else if (前回連番 == 整数65) {
            前回処置内容Keys.add(KEY2);
        } else if (前回連番 == 整数66) {
            前回処置内容Keys.add(KEY3);
        } else if (前回連番 == 整数67) {
            前回処置内容Keys.add(KEY4);
        } else if (前回連番 == 整数68) {
            前回処置内容Keys.add(KEY5);
        } else if (前回連番 == 整数69) {
            前回処置内容Keys.add(KEY6);
        } else if (前回連番 == 整数70) {
            前回処置内容Keys.add(KEY7);
        } else if (前回連番 == 整数71) {
            前回処置内容Keys.add(KEY8);
        }
    }

    private void 処置内容画面表示(List<RString> 処置内容Keys, List<RString> 前回処置内容Keys,
            List<RString> 処置内容特記事項番号, RString 認定調査前回結果表示) {
        if (処置内容Keys.isEmpty()) {
            div.getBtnShochiNaiyo().setDisabled(true);
            div.getShochiNaiyo().setIsShochiNaiyoSelected(new RString("0"));
        } else {
            div.getChkShochiNaiyo().setSelectedItemsByKey(処置内容Keys);
            div.getShochiNaiyo().setShochiNaiyoShinseishoKanriNo(DataPassingConverter.serialize(
                    new ArrayList<RString>().addAll(処置内容特記事項番号)));
            div.getShochiNaiyo().setIsShochiNaiyoSelected(new RString("1"));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            処置内容アンダーライン(前回処置内容Keys);
        }
    }

    private void 処置内容アンダーライン(List<RString> 前回処置内容) {
        if (!前回処置内容.isEmpty()) {
            //TODO
            div.getChkShochiNaiyo();
        }
    }

    private void set簡単な調理(List<RString> 簡単な調理Keys, List<RString> 前回簡単な調理Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        if (連番 == 整数62) {
            setKeyBy調査項目(簡単な調理Keys, 調査項目, true, false);
            div.getKantanChori().setKantanChoriShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数62) {
            setKeyBy調査項目(前回簡単な調理Keys, 調査項目, true, false);
        }
    }

    private void 簡単な調理画面表示(List<RString> 簡単な調理Keys, List<RString> 前回簡単な調理Keys, RString 認定調査前回結果表示) {
        if (簡単な調理Keys.isEmpty()) {
            div.getBtnKantanChori().setDisabled(true);
        } else {
            div.getRadKantanChori().setSelectedKey(簡単な調理Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            簡単な調理アンダーライン(前回簡単な調理Keys);
        }
    }

    private void 簡単な調理アンダーライン(List<RString> 前回簡単な調理Keys) {
        if (!前回簡単な調理Keys.isEmpty()) {
            //TODO
            div.getRadKantanChori();
        }
    }

    private void set買い物(List<RString> 買い物Keys, List<RString> 前回買い物Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数61) {
            setKeyBy調査項目(買い物Keys, 調査項目, true, false);
            div.getKaiMono().setKaiMonoShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数61) {
            setKeyBy調査項目(前回買い物Keys, 前回調査項目, true, false);
        }
    }

    private void 買い物画面表示(List<RString> 買い物Keys, List<RString> 前回買い物Keys, RString 認定調査前回結果表示) {
        if (買い物Keys.isEmpty()) {
            div.getBtnKaiMono().setDisabled(true);
        } else {
            div.getRadKaiMono().setSelectedKey(買い物Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            買い物アンダーライン(前回買い物Keys);
        }
    }

    private void 買い物アンダーライン(List<RString> 前回買い物Keys) {
        if (!前回買い物Keys.isEmpty()) {
            //TODO
            div.getRadKaiMono();
        }
    }

    private void set集団への不適用(List<RString> 集団への不適用Keys, List<RString> 前回集団への不適用Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数60) {
            setKeyBy調査項目(集団への不適用Keys, 調査項目, true, false);
            div.getShudan().setShudanShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数60) {
            setKeyBy調査項目(前回集団への不適用Keys, 前回調査項目, true, false);
        }
    }

    private void 集団への不適用画面表示(List<RString> 集団への不適用Keys, List<RString> 前回集団への不適用Keys, RString 認定調査前回結果表示) {
        if (集団への不適用Keys.isEmpty()) {
            div.getBtnShudan().setDisabled(true);
        } else {
            div.getRadShudan().setSelectedKey(集団への不適用Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            集団への不適用アンダーライン(前回集団への不適用Keys);
        }
    }

    private void 集団への不適用アンダーライン(List<RString> 前回集団への不適用Keys) {
        if (!前回集団への不適用Keys.isEmpty()) {
            //TODO
            div.getRadShudan();
        }
    }

    private void set日常の意思決定(List<RString> 日常の意思決定Keys, List<RString> 前回日常の意思決定Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数59) {
            setKeyBy調査項目(日常の意思決定Keys, 調査項目, true, false);
            div.getIshiKetei().setIshiKeteiShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数59) {
            setKeyBy調査項目(前回日常の意思決定Keys, 前回調査項目, true, false);
        }
    }

    private void 日常の意思決定画面表示(List<RString> 日常の意思決定Keys, List<RString> 前回日常の意思決定Keys, RString 認定調査前回結果表示) {
        if (日常の意思決定Keys.isEmpty()) {
            div.getBtnIshiKetei().setDisabled(true);
        } else {
            div.getRadIshiKetei().setSelectedKey(日常の意思決定Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            日常の意思決定アンダーライン(前回日常の意思決定Keys);
        }
    }

    private void 日常の意思決定アンダーライン(List<RString> 前回日常の意思決定Keys) {
        if (!前回日常の意思決定Keys.isEmpty()) {
            //TODO
            div.getRadIshiKetei();
        }
    }

    private void set金銭の管理(List<RString> 金銭の管理Keys, List<RString> 前回金銭の管理Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数58) {
            setKeyBy調査項目(金銭の管理Keys, 調査項目, false, false);
            div.getKingakuKanri().setKingakuKanriShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数58) {
            setKeyBy調査項目(前回金銭の管理Keys, 前回調査項目, false, false);
        }
    }

    private void 金銭の管理画面表示(List<RString> 金銭の管理Keys, List<RString> 前回金銭の管理Keys, RString 認定調査前回結果表示) {
        if (金銭の管理Keys.isEmpty()) {
            div.getBtnKingakuKanri().setDisabled(true);
        } else {
            div.getRadKingakuKanri().setSelectedKey(金銭の管理Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            金銭の管理アンダーライン(前回金銭の管理Keys);
        }
    }

    private void 金銭の管理アンダーライン(List<RString> 前回金銭の管理Keys) {
        if (!前回金銭の管理Keys.isEmpty()) {
            //TODO
            div.getRadKingakuKanri();
        }
    }

    private void set薬の内服(List<RString> 薬の内服Keys, List<RString> 前回薬の内服Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数57) {
            setKeyBy調査項目(薬の内服Keys, 調査項目, false, false);
            div.getKusuri().setKusuriShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数57) {
            setKeyBy調査項目(前回薬の内服Keys, 前回調査項目, false, false);
        }
    }

    private void 薬の内服画面表示(List<RString> 薬の内服Keys, List<RString> 前回薬の内服Keys, RString 認定調査前回結果表示) {
        if (薬の内服Keys.isEmpty()) {
            div.getBtnKusuri().setDisabled(true);
        } else {
            div.getRadKusuri().setSelectedKey(薬の内服Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            薬の内服アンダーライン(前回薬の内服Keys);
        }
    }

    private void 薬の内服アンダーライン(List<RString> 前回薬の内服Keys) {
        if (!前回薬の内服Keys.isEmpty()) {
            //TODO
            div.getRadKusuri();
        }
    }

    private void set話がまとまらない(List<RString> 話がまとまらないKeys, List<RString> 前回話がまとまらないKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数56) {
            setKeyBy調査項目(話がまとまらないKeys, 調査項目, false, false);
            div.getMatomeNai().setMatomeNaiShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数56) {
            setKeyBy調査項目(前回話がまとまらないKeys, 前回調査項目, false, false);
        }
    }

    private void 話がまとまらない画面表示(List<RString> 話がまとまらないKeys, List<RString> 前回話がまとまらないKeys, RString 認定調査前回結果表示) {
        if (話がまとまらないKeys.isEmpty()) {
            div.getBtnMatomeNai().setDisabled(true);
        } else {
            div.getRadMatomeNai().setSelectedKey(話がまとまらないKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            話がまとまらないアンダーライン(前回話がまとまらないKeys);
        }
    }

    private void 話がまとまらないアンダーライン(List<RString> 前回話がまとまらないKeys) {
        if (!前回話がまとまらないKeys.isEmpty()) {
            //TODO
            div.getRadMatomeNai();
        }
    }

    private void set自分勝手に行動する(List<RString> 自分勝手に行動するKeys,
            List<RString> 前回自分勝手に行動するKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数55) {
            setKeyBy調査項目(自分勝手に行動するKeys, 調査項目, false, false);
            div.getKateKodo().setKateKodoShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数55) {
            setKeyBy調査項目(前回自分勝手に行動するKeys, 前回調査項目, false, false);
        }
    }

    private void 自分勝手に行動する画面表示(List<RString> 自分勝手に行動するKeys, List<RString> 前回自分勝手に行動するKeys, RString 認定調査前回結果表示) {
        if (自分勝手に行動するKeys.isEmpty()) {
            div.getBtnKateKodo().setDisabled(true);
        } else {
            div.getRadKateKodo().setSelectedKey(自分勝手に行動するKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            自分勝手に行動するアンダーライン(前回自分勝手に行動するKeys);
        }
    }

    private void 自分勝手に行動するアンダーライン(List<RString> 前回自分勝手に行動するKeys) {
        if (!前回自分勝手に行動するKeys.isEmpty()) {
            //TODO
            div.getRadKateKodo();
        }
    }

    private void set独り言_独り笑い(List<RString> 独り言_独り笑いKeys, List<RString> 前回独り言_独り笑いKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数54) {
            setKeyBy調査項目(独り言_独り笑いKeys, 調査項目, false, false);
            div.getHitoriWarai().setHitoriWaraiShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数54) {
            setKeyBy調査項目(前回独り言_独り笑いKeys, 前回調査項目, false, false);
        }
    }

    private void 独り言_独り笑い画面表示(List<RString> 独り言_独り笑いKeys, List<RString> 前回独り言_独り笑いKeys, RString 認定調査前回結果表示) {
        if (独り言_独り笑いKeys.isEmpty()) {
            div.getBtnHitoriWarai().setDisabled(true);
        } else {
            div.getRadHitoriWarai().setSelectedKey(独り言_独り笑いKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            独り言_独り笑いアンダーライン(前回独り言_独り笑いKeys);
        }
    }

    private void 独り言_独り笑いアンダーライン(List<RString> 前回独り言_独り笑いKeys) {
        if (!前回独り言_独り笑いKeys.isEmpty()) {
            //TODO
            div.getRadHitoriWarai();
        }
    }

    private void setひどい物忘れ(List<RString> ひどい物忘れKeys, List<RString> 前回ひどい物忘れKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数53) {
            setKeyBy調査項目(ひどい物忘れKeys, 調査項目, false, false);
            div.getMonoWasure().setMonoWasureShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数53) {
            setKeyBy調査項目(前回ひどい物忘れKeys, 前回調査項目, false, false);
        }
    }

    private void ひどい物忘れ画面表示(List<RString> ひどい物忘れKeys, List<RString> 前回ひどい物忘れKeys, RString 認定調査前回結果表示) {
        if (ひどい物忘れKeys.isEmpty()) {
            div.getBtnMonoWasure().setDisabled(true);
        } else {
            div.getRadMonoWasure().setSelectedKey(ひどい物忘れKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            ひどい物忘れアンダーライン(前回ひどい物忘れKeys);
        }
    }

    private void ひどい物忘れアンダーライン(List<RString> 前回ひどい物忘れKeys) {
        if (!前回ひどい物忘れKeys.isEmpty()) {
            //TODO
            div.getRadMonoWasure();
        }
    }

    private void set物や衣類を壊す(List<RString> 物や衣類を壊すKeys, List<RString> 前回物や衣類を壊すKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数52) {
            setKeyBy調査項目(物や衣類を壊すKeys, 調査項目, false, false);
            div.getKowasu().setKowasuShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数52) {
            setKeyBy調査項目(前回物や衣類を壊すKeys, 前回調査項目, false, false);
        }
    }

    private void 物や衣類を壊す画面表示(List<RString> 物や衣類を壊すKeys, List<RString> 前回物や衣類を壊すKeys, RString 認定調査前回結果表示) {
        if (物や衣類を壊すKeys.isEmpty()) {
            div.getBtnKowasu().setDisabled(true);
        } else {
            div.getRadKowasu().setSelectedKey(物や衣類を壊すKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            物や衣類を壊すアンダーライン(前回物や衣類を壊すKeys);
        }
    }

    private void 物や衣類を壊すアンダーライン(List<RString> 前回物や衣類を壊すKeys) {
        if (!前回物や衣類を壊すKeys.isEmpty()) {
            //TODO
            div.getRadKowasu();
        }
    }

    private void set収集癖(List<RString> 収集癖Keys, List<RString> 前回収集癖Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数51) {
            setKeyBy調査項目(収集癖Keys, 調査項目, false, false);
            div.getShushu().setShushuShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数51) {
            setKeyBy調査項目(前回収集癖Keys, 前回調査項目, false, false);
        }
    }

    private void 収集癖画面表示(List<RString> 収集癖Keys, List<RString> 前回収集癖Keys, RString 認定調査前回結果表示) {
        if (収集癖Keys.isEmpty()) {
            div.getBtnShushu().setDisabled(true);
        } else {
            div.getRadShushu().setSelectedKey(収集癖Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            収集癖アンダーライン(前回収集癖Keys);
        }
    }

    private void 収集癖アンダーライン(List<RString> 前回収集癖Keys) {
        if (!前回収集癖Keys.isEmpty()) {
            //TODO
            div.getRadShushu();
        }
    }

    private void set一人で出たがる(List<RString> 一人で出たがるKeys, List<RString> 前回一人で出たがるKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数50) {
            setKeyBy調査項目(一人で出たがるKeys, 調査項目, false, false);
            div.getOutLonly().setOutLonlyShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数50) {
            setKeyBy調査項目(前回一人で出たがるKeys, 前回調査項目, false, false);
        }
    }

    private void 一人で出たがる画面表示(List<RString> 一人で出たがるKeys, List<RString> 前回一人で出たがるKeys, RString 認定調査前回結果表示) {
        if (一人で出たがるKeys.isEmpty()) {
            div.getBtnOutLonly().setDisabled(true);
        } else {
            div.getRadOutLonly().setSelectedKey(一人で出たがるKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            一人で出たがるアンダーライン(前回一人で出たがるKeys);
        }
    }

    private void 一人で出たがるアンダーライン(List<RString> 前回一人で出たがるKeys) {
        if (!前回一人で出たがるKeys.isEmpty()) {
            //TODO
            div.getRadOutLonly();
        }
    }

    private void set落ち着きなし(List<RString> 落ち着きなしKeys, List<RString> 前回落ち着きなしKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数49) {
            setKeyBy調査項目(落ち着きなしKeys, 調査項目, false, false);
            div.getOchituki().setOchitukiShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数49) {
            setKeyBy調査項目(前回落ち着きなしKeys, 前回調査項目, false, false);
        }
    }

    private void 落ち着きなし画面表示(List<RString> 落ち着きなしKeys, List<RString> 前回落ち着きなしKeys, RString 認定調査前回結果表示) {
        if (落ち着きなしKeys.isEmpty()) {
            div.getBtnOchituki().setDisabled(true);
        } else {
            div.getRadOchituki().setSelectedKey(落ち着きなしKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            落ち着きなしアンダーライン(前回落ち着きなしKeys);
        }
    }

    private void 落ち着きなしアンダーライン(List<RString> 前回落ち着きなしKeys) {
        if (!前回落ち着きなしKeys.isEmpty()) {
            //TODO
            div.getRadOchituki();
        }
    }

    private void set介護に抵抗(List<RString> 介護に抵抗Keys, List<RString> 前回介護に抵抗Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数48) {
            setKeyBy調査項目(介護に抵抗Keys, 調査項目, false, false);
            div.getTeikou().setTeikouShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数48) {
            setKeyBy調査項目(前回介護に抵抗Keys, 前回調査項目, false, false);
        }
    }

    private void 介護に抵抗画面表示(List<RString> 介護に抵抗Keys, List<RString> 前回介護に抵抗Keys, RString 認定調査前回結果表示) {
        if (介護に抵抗Keys.isEmpty()) {
            div.getBtnTeikou().setDisabled(true);
        } else {
            div.getRadTeikou().setSelectedKey(介護に抵抗Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            介護に抵抗アンダーライン(前回介護に抵抗Keys);
        }
    }

    private void 介護に抵抗アンダーライン(List<RString> 前回介護に抵抗Keys) {
        if (!前回介護に抵抗Keys.isEmpty()) {
            //TODO
            div.getRadTeikou();
        }
    }

    private void set大声をだす(List<RString> 大声をだすKeys, List<RString> 前回大声をだすKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数47) {
            setKeyBy調査項目(大声をだすKeys, 調査項目, false, false);
            div.getBigVoice().setBigVoiceShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数47) {
            setKeyBy調査項目(前回大声をだすKeys, 前回調査項目, false, false);
        }
    }

    private void 大声をだす画面表示(List<RString> 大声をだすKeys, List<RString> 前回大声をだすKeys, RString 認定調査前回結果表示) {
        if (大声をだすKeys.isEmpty()) {
            div.getBtnBigVoice().setDisabled(true);
        } else {
            div.getRadBigVoice().setSelectedKey(大声をだすKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            大声をだすアンダーライン(前回大声をだすKeys);
        }
    }

    private void 大声をだすアンダーライン(List<RString> 前回大声をだすKeys) {
        if (!前回大声をだすKeys.isEmpty()) {
            //TODO
            div.getRadBigVoice();
        }
    }

    private void set同じ話をする(List<RString> 同じ話をするKeys, List<RString> 前回同じ話をするKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数46) {
            setKeyBy調査項目(同じ話をするKeys, 調査項目, false, false);
            div.getOnajiHanashi().setOnajiHanashiShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数46) {
            setKeyBy調査項目(前回同じ話をするKeys, 前回調査項目, false, false);
        }
    }

    private void 同じ話をする画面表示(List<RString> 同じ話をするKeys, List<RString> 前回同じ話をするKeys, RString 認定調査前回結果表示) {
        if (同じ話をするKeys.isEmpty()) {
            div.getBtnOnajiHanashi().setDisabled(true);
        } else {
            div.getRadOnajiHanashi().setSelectedKey(同じ話をするKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            同じ話をするアンダーライン(前回同じ話をするKeys);
        }
    }

    private void 同じ話をするアンダーライン(List<RString> 前回同じ話をするKeys) {
        if (!前回同じ話をするKeys.isEmpty()) {
            //TODO
            div.getRadOnajiHanashi();
        }
    }

    private void set昼夜逆転(List<RString> 昼夜逆転Keys, List<RString> 前回昼夜逆転Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数45) {
            setKeyBy調査項目(昼夜逆転Keys, 調査項目, false, false);
            div.getChuyaku().setChuyakuShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数45) {
            setKeyBy調査項目(前回昼夜逆転Keys, 前回調査項目, false, false);
        }
    }

    private void 昼夜逆転画面表示(List<RString> 昼夜逆転Keys, List<RString> 前回昼夜逆転Keys, RString 認定調査前回結果表示) {
        if (昼夜逆転Keys.isEmpty()) {
            div.getBtnChuyaku().setDisabled(true);
        } else {
            div.getRadChuyaku().setSelectedKey(昼夜逆転Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            昼夜逆転アンダーライン(前回昼夜逆転Keys);
        }
    }

    private void 昼夜逆転アンダーライン(List<RString> 前回昼夜逆転Keys) {
        if (!前回昼夜逆転Keys.isEmpty()) {
            //TODO
            div.getRadChuyaku();
        }
    }

    private void set感情が不安定(List<RString> 感情が不安定Keys, List<RString> 前回感情が不安定Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数44) {
            setKeyBy調査項目(感情が不安定Keys, 調査項目, false, false);
            div.getKanjyo().setKanjyoShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数44) {
            setKeyBy調査項目(前回感情が不安定Keys, 前回調査項目, false, false);
        }
    }

    private void 感情が不安定画面表示(List<RString> 感情が不安定Keys, List<RString> 前回感情が不安定Keys, RString 認定調査前回結果表示) {
        if (感情が不安定Keys.isEmpty()) {
            div.getBtnKanjyo().setDisabled(true);
        } else {
            div.getRadKanjyo().setSelectedKey(感情が不安定Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            感情が不安定アンダーライン(前回感情が不安定Keys);
        }
    }

    private void 感情が不安定アンダーライン(List<RString> 前回感情が不安定Keys) {
        if (!前回感情が不安定Keys.isEmpty()) {
            //TODO
            div.getRadKanjyo();
        }
    }

    private void set作話(List<RString> 作話Keys, List<RString> 前回作話Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数43) {
            setKeyBy調査項目(作話Keys, 調査項目, false, false);
            div.getTukuriHanashi().setTukuriHanashiShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数43) {
            setKeyBy調査項目(前回作話Keys, 前回調査項目, false, false);
        }
    }

    private void 作話画面表示(List<RString> 作話Keys, List<RString> 前回作話Keys, RString 認定調査前回結果表示) {
        if (作話Keys.isEmpty()) {
            div.getBtnTukuriHanashi().setDisabled(true);
        } else {
            div.getRadTukuriHanashi().setSelectedKey(作話Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            作話アンダーライン(前回作話Keys);
        }
    }

    private void 作話アンダーライン(List<RString> 前回作話Keys) {
        if (!前回作話Keys.isEmpty()) {
            //TODO
            div.getRadTukuriHanashi();
        }
    }

    private void set被虐的(List<RString> 被虐的Keys, List<RString> 前回被虐的Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数42) {
            setKeyBy調査項目(被虐的Keys, 調査項目, false, false);
            div.getHiryaku().setHiryakuShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数42) {
            setKeyBy調査項目(前回被虐的Keys, 前回調査項目, false, false);
        }
    }

    private void 被虐的画面表示(List<RString> 被虐的Keys, List<RString> 前回被虐的Keys, RString 認定調査前回結果表示) {
        if (被虐的Keys.isEmpty()) {
            div.getHiryaku().setDisabled(true);
        } else {
            div.getRadbtnHiryaku().setSelectedKey(被虐的Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            被虐的アンダーライン(前回被虐的Keys);
        }
    }

    private void 被虐的アンダーライン(List<RString> 前回被虐的Keys) {
        if (!前回被虐的Keys.isEmpty()) {
            //TODO
            div.getRadbtnHiryaku();
        }
    }

    private void set外出すると戻れない(List<RString> 外出すると戻れないKeys,
            List<RString> 前回外出すると戻れないKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数41) {
            setKeyBy調査項目(外出すると戻れないKeys, 調査項目, false, false);
            div.getModoru().setModoruShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数41) {
            setKeyBy調査項目(前回外出すると戻れないKeys, 前回調査項目, false, false);
        }
    }

    private void 外出すると戻れない画面表示(List<RString> 外出すると戻れないKeys, List<RString> 前回外出すると戻れないKeys, RString 認定調査前回結果表示) {
        if (外出すると戻れないKeys.isEmpty()) {
            div.getBtnModoru().setDisabled(true);
        } else {
            div.getRadModoru().setSelectedKey(外出すると戻れないKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            外出すると戻れないアンダーライン(前回外出すると戻れないKeys);
        }
    }

    private void 外出すると戻れないアンダーライン(List<RString> 前回外出すると戻れないKeys) {
        if (!前回外出すると戻れないKeys.isEmpty()) {
            //TODO
            div.getRadModoru();
        }
    }

    private void set徘徊(List<RString> 徘徊Keys, List<RString> 前回徘徊Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数40) {
            setKeyBy調査項目(徘徊Keys, 調査項目, false, false);
            div.getHaikai().setHaikaiShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数40) {
            setKeyBy調査項目(前回徘徊Keys, 前回調査項目, false, false);
        }
    }

    private void 徘徊画面表示(List<RString> 徘徊Keys, List<RString> 前回徘徊Keys, RString 認定調査前回結果表示) {
        if (徘徊Keys.isEmpty()) {
            div.getBtnHaikai().setDisabled(true);
        } else {
            div.getRadHaikai().setSelectedKey(徘徊Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            徘徊アンダーライン(前回徘徊Keys);
        }
    }

    private void 徘徊アンダーライン(List<RString> 前回徘徊Keys) {
        if (!前回徘徊Keys.isEmpty()) {
            //TODO
            div.getRadHaikai();
        }
    }

    private void set場所の理解(List<RString> 場所の理解Keys, List<RString> 前回場所の理解Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数39) {
            setKeyBy調査項目が2(場所の理解Keys, 調査項目);
            div.getBasho().setBashoShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数39) {
            setKeyBy調査項目が2(前回場所の理解Keys, 前回調査項目);
        }
    }

    private void 場所の理解画面表示(List<RString> 場所の理解Keys,
            List<RString> 前回場所の理解Keys, RString 認定調査前回結果表示) {
        if (場所の理解Keys.isEmpty()) {
            div.getBtnBasho().setDisabled(true);
        } else {
            div.getRadBasho().setSelectedKey(場所の理解Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            場所の理解アンダーライン(前回場所の理解Keys);
        }
    }

    private void 場所の理解アンダーライン(List<RString> 前回場所の理解Keys) {
        if (!前回場所の理解Keys.isEmpty()) {
            //TODO
            div.getRadBasho();
        }
    }

    private void set今の季節を理解する(List<RString> 今の季節を理解するKeys,
            List<RString> 前回今の季節を理解するKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数38) {
            setKeyBy調査項目が2(今の季節を理解するKeys, 調査項目);
            div.getKisetsu().setKisetsuShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数38) {
            setKeyBy調査項目が2(前回今の季節を理解するKeys, 前回調査項目);
        }
    }

    private void 今の季節を理解する画面表示(List<RString> 今の季節を理解するKeys,
            List<RString> 前回今の季節を理解するKeys, RString 認定調査前回結果表示) {
        if (今の季節を理解するKeys.isEmpty()) {
            div.getBtnKisetsu().setDisabled(true);
        } else {
            div.getRadKisetsu().setSelectedKey(今の季節を理解するKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            今の季節を理解するアンダーライン(前回今の季節を理解するKeys);
        }
    }

    private void 今の季節を理解するアンダーライン(List<RString> 前回今の季節を理解するKeys) {
        if (!前回今の季節を理解するKeys.isEmpty()) {
            //TODO
            div.getRadKisetsu();
        }
    }

    private void set自分の名前を言う(List<RString> 自分の名前を言うKeys, List<RString> 前回自分の名前を言うKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数37) {
            setKeyBy調査項目が2(自分の名前を言うKeys, 調査項目);
            div.getNameInfo().setNameInfoShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数37) {
            setKeyBy調査項目が2(前回自分の名前を言うKeys, 前回調査項目);
        }
    }

    private void 自分の名前を言う画面表示(List<RString> 自分の名前を言うKeys, List<RString> 前回自分の名前を言うKeys, RString 認定調査前回結果表示) {
        if (自分の名前を言うKeys.isEmpty()) {
            div.getBtnNameInfo().setDisabled(true);
        } else {
            div.getRadNameInfo().setSelectedKey(自分の名前を言うKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            自分の名前を言うアンダーライン(前回自分の名前を言うKeys);
        }
    }

    private void 自分の名前を言うアンダーライン(List<RString> 前回自分の名前を言うKeys) {
        if (!前回自分の名前を言うKeys.isEmpty()) {
            //TODO
            div.getRadNameInfo();
        }
    }

    private void set短期記憶(List<RString> 短期記憶Keys, List<RString> 前回短期記憶Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数36) {
            setKeyBy調査項目が2(短期記憶Keys, 調査項目);
            div.getDankiKioku().setDankiKiokuShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数36) {
            setKeyBy調査項目が2(前回短期記憶Keys, 前回調査項目);
        }
    }

    private void 短期記憶画面表示(List<RString> 短期記憶Keys, List<RString> 前回短期記憶Keys, RString 認定調査前回結果表示) {
        if (短期記憶Keys.isEmpty()) {
            div.getBtnDankiKioku().setDisabled(true);
        } else {
            div.getRadDankiKioku().setSelectedKey(短期記憶Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            短期記憶アンダーライン(前回短期記憶Keys);
        }
    }

    private void 短期記憶アンダーライン(List<RString> 前回短期記憶Keys) {
        if (!前回短期記憶Keys.isEmpty()) {
            //TODO
            div.getRadDankiKioku();
        }
    }

    private void set生年月日や年齢を言う(List<RString> 生年月日や年齢を言うKeys,
            List<RString> 前回生年月日や年齢を言うKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数35) {
            setKeyBy調査項目が2(生年月日や年齢を言うKeys, 調査項目);
            div.getInfo().setInfoShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数35) {
            setKeyBy調査項目が2(前回生年月日や年齢を言うKeys, 前回調査項目);
        }
    }

    private void 生年月日や年齢を言う画面表示(List<RString> 生年月日や年齢を言うKeys,
            List<RString> 前回生年月日や年齢を言うKeys, RString 認定調査前回結果表示) {
        if (生年月日や年齢を言うKeys.isEmpty()) {
            div.getBtnInfo().setDisabled(true);
        } else {
            div.getRadInfo().setSelectedKey(生年月日や年齢を言うKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            生年月日や年齢を言うアンダーライン(前回生年月日や年齢を言うKeys);
        }
    }

    private void 生年月日や年齢を言うアンダーライン(List<RString> 前回生年月日や年齢を言うKeys) {
        if (!前回生年月日や年齢を言うKeys.isEmpty()) {
            //TODO
            div.getRadInfo();
        }
    }

    private void set毎日の日課を理解(List<RString> 毎日の日課を理解Keys, List<RString> 前回毎日の日課を理解Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数34) {
            setKeyBy調査項目が2(毎日の日課を理解Keys, 調査項目);
            div.getNikka().setNikkaShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数34) {
            setKeyBy調査項目が2(前回毎日の日課を理解Keys, 前回調査項目);
        }
    }

    private void 毎日の日課を理解画面表示(List<RString> 毎日の日課を理解Keys, List<RString> 前回毎日の日課を理解Keys, RString 認定調査前回結果表示) {
        if (毎日の日課を理解Keys.isEmpty()) {
            div.getBtnNikka().setDisabled(true);
        } else {
            div.getRadNikka().setSelectedKey(毎日の日課を理解Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            毎日の日課を理解アンダーライン(前回毎日の日課を理解Keys);
        }
    }

    private void 毎日の日課を理解アンダーライン(List<RString> 前回毎日の日課を理解Keys) {
        if (!前回毎日の日課を理解Keys.isEmpty()) {
            //TODO
            div.getRadNikka();
        }
    }

    private void set意思の伝達(List<RString> 意思の伝達Keys, List<RString> 前回意思の伝達Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数33) {
            setKeyBy調査項目(意思の伝達Keys, 調査項目, true, false);
            div.getIshiDentatsu().setIshiDentatsuShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数33) {
            setKeyBy調査項目(前回意思の伝達Keys, 前回調査項目, true, false);
        }
    }

    private void 意思の伝達画面表示(List<RString> 意思の伝達Keys, List<RString> 前回意思の伝達Keys, RString 認定調査前回結果表示) {
        if (意思の伝達Keys.isEmpty()) {
            div.getBtnIshiDentatsu().setDisabled(true);
        } else {
            div.getRadIshiDentatsu().setSelectedKey(意思の伝達Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            意思の伝達アンダーライン(前回意思の伝達Keys);
        }
    }

    private void 意思の伝達アンダーライン(List<RString> 前回意思の伝達Keys) {
        if (!前回意思の伝達Keys.isEmpty()) {
            //TODO
            div.getRadIshiDentatsu();
        }
    }

    private void set外出頻度(List<RString> 外出頻度Keys, List<RString> 前回外出頻度Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数32) {
            setKeyBy調査項目(外出頻度Keys, 調査項目, false, false);
            div.getHindo().setHindoShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数32) {
            setKeyBy調査項目(前回外出頻度Keys, 前回調査項目, false, false);
        }
    }

    private void 外出頻度画面表示(List<RString> 外出頻度Keys, List<RString> 前回外出頻度Keys, RString 認定調査前回結果表示) {
        if (外出頻度Keys.isEmpty()) {
            div.getBtnHindo().setDisabled(true);
        } else {
            div.getRadHindo().setSelectedKey(外出頻度Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            外出頻度アンダーライン(前回外出頻度Keys);
        }
    }

    private void 外出頻度アンダーライン(List<RString> 前回外出頻度Keys) {
        if (!前回外出頻度Keys.isEmpty()) {
            //TODO
            div.getRadHindo();
        }
    }

    private void setズボン等の着脱(List<RString> ズボン等の着脱Keys, List<RString> 前回ズボン等の着脱Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数31) {
            setKeyBy調査項目(ズボン等の着脱Keys, 調査項目, true, false);
            div.getZubon().setZubonShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数31) {
            setKeyBy調査項目(前回ズボン等の着脱Keys, 前回調査項目, true, false);
        }
    }

    private void ズボン等の着脱画面表示(List<RString> ズボン等の着脱Keys, List<RString> 前回ズボン等の着脱Keys, RString 認定調査前回結果表示) {
        if (ズボン等の着脱Keys.isEmpty()) {
            div.getBtnZubon().setDisabled(true);
        } else {
            div.getRadZubon().setSelectedKey(ズボン等の着脱Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            ズボン等の着脱アンダーライン(前回ズボン等の着脱Keys);
        }
    }

    private void ズボン等の着脱アンダーライン(List<RString> 前回ズボン等の着脱Keys) {
        if (!前回ズボン等の着脱Keys.isEmpty()) {
            //TODO
            div.getRadZubon();
        }
    }

    private void set上衣の着脱(List<RString> 上衣の着脱Keys, List<RString> 前回上衣の着脱Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数30) {
            setKeyBy調査項目(上衣の着脱Keys, 調査項目, true, false);
            div.getUwagi().setUwagiShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数30) {
            setKeyBy調査項目(前回上衣の着脱Keys, 前回調査項目, true, false);
        }
    }

    private void 上衣の着脱画面表示(List<RString> 上衣の着脱Keys, List<RString> 前回上衣の着脱Keys, RString 認定調査前回結果表示) {
        if (上衣の着脱Keys.isEmpty()) {
            div.getBtnUwagi().setDisabled(true);
        } else {
            div.getRadUwagi().setSelectedKey(上衣の着脱Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            上衣の着脱アンダーライン(前回上衣の着脱Keys);
        }
    }

    private void 上衣の着脱アンダーライン(List<RString> 前回上衣の着脱Keys) {
        if (!前回上衣の着脱Keys.isEmpty()) {
            //TODO
            div.getRadUwagi();
        }
    }

    private void set整髪(List<RString> 整髪Keys, List<RString> 前回整髪Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数29) {
            setKeyBy調査項目(整髪Keys, 調査項目, false, false);
            div.getSeihatsu().setSeihatsuShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数29) {
            setKeyBy調査項目(前回整髪Keys, 前回調査項目, false, false);
        }
    }

    private void 整髪画面表示(List<RString> 整髪Keys, List<RString> 前回整髪Keys, RString 認定調査前回結果表示) {
        if (整髪Keys.isEmpty()) {
            div.getBtnSeihatsu().setDisabled(true);
        } else {
            div.getRadSeihatsu().setSelectedKey(整髪Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            整髪アンダーライン(前回整髪Keys);
        }
    }

    private void 整髪アンダーライン(List<RString> 前回整髪Keys) {
        if (!前回整髪Keys.isEmpty()) {
            //TODO
            div.getRadSeihatsu();
        }
    }

    private void set洗顔(List<RString> 洗顔Keys, List<RString> 前回洗顔Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数28) {
            setKeyBy調査項目(洗顔Keys, 調査項目, false, false);
            div.getSengan().setSenganShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数28) {
            setKeyBy調査項目(前回洗顔Keys, 前回調査項目, false, false);
        }
    }

    private void 洗顔画面表示(List<RString> 洗顔Keys, List<RString> 前回洗顔Keys, RString 認定調査前回結果表示) {
        if (洗顔Keys.isEmpty()) {
            div.getBtnSengan().setDisabled(true);
        } else {
            div.getRadSengan().setSelectedKey(洗顔Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            洗顔アンダーライン(前回洗顔Keys);
        }
    }

    private void 洗顔アンダーライン(List<RString> 前回洗顔Keys) {
        if (!前回洗顔Keys.isEmpty()) {
            //TODO
            div.getRadSengan();
        }
    }

    private void set口腔清潔(List<RString> 口腔清潔Keys, List<RString> 前回口腔清潔Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数27) {
            setKeyBy調査項目(口腔清潔Keys, 調査項目, false, false);
            div.getKokou().setKokouShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数27) {
            setKeyBy調査項目(前回口腔清潔Keys, 前回調査項目, false, false);
        }
    }

    private void 口腔清潔画面表示(List<RString> 口腔清潔Keys, List<RString> 前回口腔清潔Keys, RString 認定調査前回結果表示) {
        if (口腔清潔Keys.isEmpty()) {
            div.getBtnKokou().setDisabled(true);
        } else {
            div.getRadKokou().setSelectedKey(口腔清潔Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            口腔清潔アンダーライン(前回口腔清潔Keys);
        }
    }

    private void 口腔清潔アンダーライン(List<RString> 前回口腔清潔Keys) {
        if (!前回口腔清潔Keys.isEmpty()) {
            //TODO
            div.getRadKokou();
        }
    }

    private void set排便(List<RString> 排便Keys, List<RString> 前回排便Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数26) {
            setKeyBy調査項目(排便Keys, 調査項目, true, false);
            div.getHaiben().setHaibenShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数26) {
            setKeyBy調査項目(前回排便Keys, 前回調査項目, true, false);
        }
    }

    private void 排便画面表示(List<RString> 排便Keys, List<RString> 前回排便Keys, RString 認定調査前回結果表示) {
        if (排便Keys.isEmpty()) {
            div.getBtnHaiben().setDisabled(true);
        } else {
            div.getRadHaiben().setSelectedKey(排便Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            排便アンダーライン(前回排便Keys);
        }
    }

    private void 排便アンダーライン(List<RString> 前回排便Keys) {
        if (!前回排便Keys.isEmpty()) {
            //TODO
            div.getRadHaiben();
        }
    }

    private void set排尿(List<RString> 排尿Keys, List<RString> 前回排尿Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数25) {
            setKeyBy調査項目(排尿Keys, 調査項目, true, false);
            div.getHainyo().setHainyoShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数25) {
            setKeyBy調査項目(前回排尿Keys, 前回調査項目, true, false);
        }
    }

    private void 排尿画面表示(List<RString> 排尿Keys, List<RString> 前回排尿Keys, RString 認定調査前回結果表示) {
        if (排尿Keys.isEmpty()) {
            div.getBtnHainyo().setDisabled(true);
        } else {
            div.getRadHainyo().setSelectedKey(排尿Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            排尿アンダーライン(前回排尿Keys);
        }
    }

    private void 排尿アンダーライン(List<RString> 前回排尿Keys) {
        if (!前回排尿Keys.isEmpty()) {
            //TODO
            div.getRadHainyo();
        }
    }

    private void set食事摂取(List<RString> 食事摂取Keys, List<RString> 前回食事摂取Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数24) {
            setKeyBy調査項目(食事摂取Keys, 調査項目, true, false);
            div.getShokuji().setShokujiShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数24) {
            setKeyBy調査項目(前回食事摂取Keys, 前回調査項目, true, false);
        }
    }

    private void 食事摂取画面表示(List<RString> 食事摂取Keys, List<RString> 前回食事摂取Keys, RString 認定調査前回結果表示) {
        if (食事摂取Keys.isEmpty()) {
            div.getBtnShokuji().setDisabled(true);
        } else {
            div.getRadShokuji().setSelectedKey(食事摂取Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            食事摂取アンダーライン(前回食事摂取Keys);
        }
    }

    private void 食事摂取アンダーライン(List<RString> 前回食事摂取Keys) {
        if (!前回食事摂取Keys.isEmpty()) {
            //TODO
            div.getRadShokuji();
        }
    }

    private void setえん下(List<RString> えん下Keys, List<RString> 前回えん下Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数23) {
            setKeyBy調査項目(えん下Keys, 調査項目, false, false);
            div.getEnka().setEnkaShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数23) {
            setKeyBy調査項目(前回えん下Keys, 前回調査項目, false, false);
        }
    }

    private void えん下画面表示(List<RString> えん下Keys, List<RString> 前回えん下Keys, RString 認定調査前回結果表示) {
        if (えん下Keys.isEmpty()) {
            div.getBtnEnka().setDisabled(true);
        } else {
            div.getRadEnka().setSelectedKey(えん下Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            えん下アンダーライン(前回えん下Keys);
        }
    }

    private void えん下アンダーライン(List<RString> 前回えん下Keys) {
        if (!前回えん下Keys.isEmpty()) {
            //TODO
            div.getRadEnka();
        }
    }

    private void set移動(List<RString> 移動Keys, List<RString> 前回移動Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数22) {
            setKeyBy調査項目(移動Keys, 調査項目, true, false);
            div.getIdou().setIdouShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数22) {
            setKeyBy調査項目(前回移動Keys, 前回調査項目, true, false);
        }
    }

    private void 移動画面表示(List<RString> 移動Keys, List<RString> 前回移動Keys, RString 認定調査前回結果表示) {
        if (移動Keys.isEmpty()) {
            div.getBtnIdou().setDisabled(true);
        } else {
            div.getRadIdou().setSelectedKey(移動Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            移動アンダーライン(前回移動Keys);
        }
    }

    private void 移動アンダーライン(List<RString> 前回移動Keys) {
        if (!前回移動Keys.isEmpty()) {
            //TODO
            div.getRadIdou();
        }
    }

    private void set移乗(List<RString> 移乗Keys, List<RString> 前回移乗Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数21) {
            setKeyBy調査項目(移乗Keys, 調査項目, true, false);
            div.getIjyo().setIjyoShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数21) {
            setKeyBy調査項目(前回移乗Keys, 前回調査項目, true, false);
        }
    }

    private void 移乗画面表示(List<RString> 移乗Keys, List<RString> 前回移乗Keys, RString 認定調査前回結果表示) {
        if (移乗Keys.isEmpty()) {
            div.getBtnIjyo().setDisabled(true);
        } else {
            div.getRadIjyo().setSelectedKey(移乗Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            移乗アンダーライン(前回移乗Keys);
        }
    }

    private void 移乗アンダーライン(List<RString> 前回移乗Keys) {
        if (!前回移乗Keys.isEmpty()) {
            //TODO
            div.getRadIjyo();
        }
    }

    private void set視力(List<RString> 視力Keys, List<RString> 前回視力Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数19) {
            setKeyBy調査項目(視力Keys, 調査項目, true, true);
            div.getShiryoku().setShiryokuShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数19) {
            setKeyBy調査項目(前回視力Keys, 前回調査項目, true, true);
        }
    }

    private void 視力画面表示(List<RString> 視力Keys, List<RString> 前回視力Keys, RString 認定調査前回結果表示) {
        if (視力Keys.isEmpty()) {
            div.getBtnShiryoku().setDisabled(true);
        } else {
            div.getRadShiryoku().setSelectedKey(視力Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            視力アンダーライン(前回視力Keys);
        }
    }

    private void 視力アンダーライン(List<RString> 前回視力Keys) {
        if (!前回視力Keys.isEmpty()) {
            //TODO
            div.getRadShiryoku();
        }
    }

    private void set聴力(List<RString> 聴力Keys, List<RString> 前回聴力Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数20) {
            setKeyBy調査項目(聴力Keys, 調査項目, true, true);
            div.getChoryoku().setChoryokuShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数20) {
            setKeyBy調査項目(前回聴力Keys, 前回調査項目, true, true);
        }
    }

    private void 聴力画面表示(List<RString> 聴力Keys, List<RString> 前回聴力Keys, RString 認定調査前回結果表示) {
        if (聴力Keys.isEmpty()) {
            div.getBtnChoryoku().setDisabled(true);
        } else {
            div.getRadChoryoku().setSelectedKey(聴力Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            聴力アンダーライン(前回聴力Keys);
        }
    }

    private void 聴力アンダーライン(List<RString> 前回聴力Keys) {
        if (!前回聴力Keys.isEmpty()) {
            //TODO
            div.getRadChoryoku();
        }
    }

    private void setつめ切り(List<RString> つめ切りKeys, List<RString> 前回つめ切りKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数18) {
            setKeyBy調査項目(つめ切りKeys, 調査項目, false, false);
            div.getTumeKiri().setTumeKiriShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数18) {
            setKeyBy調査項目(前回つめ切りKeys, 前回調査項目, false, false);
        }
    }

    private void つめ切り画面表示(List<RString> つめ切りKeys, List<RString> 前回つめ切りKeys, RString 認定調査前回結果表示) {
        if (つめ切りKeys.isEmpty()) {
            div.getBtnTumeKiri().setDisabled(true);
        } else {
            div.getRadTumeKiri().setSelectedKey(つめ切りKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            つめ切りアンダーライン(前回つめ切りKeys);
        }
    }

    private void つめ切りアンダーライン(List<RString> 前回つめ切りKeys) {
        if (!前回つめ切りKeys.isEmpty()) {
            //TODO
            div.getRadTumeKiri();
        }
    }

    private void set洗身(List<RString> 洗身Keys, List<RString> 前回洗身Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数17) {
            setKeyBy調査項目(洗身Keys, 調査項目, true, false);
            div.getSenshin().setSenshinShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数17) {
            setKeyBy調査項目(前回洗身Keys, 前回調査項目, true, false);
        }
    }

    private void 洗身画面表示(List<RString> 洗身Keys, List<RString> 前回洗身Keys, RString 認定調査前回結果表示) {
        if (洗身Keys.isEmpty()) {
            div.getBtnSenshin().setDisabled(true);
        } else {
            div.getRadSenshin().setSelectedKey(洗身Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            洗身アンダーライン(前回洗身Keys);
        }
    }

    private void 洗身アンダーライン(List<RString> 前回洗身Keys) {
        if (!前回洗身Keys.isEmpty()) {
            //TODO
            div.getRadSenshin();
        }
    }

    private void set片足での立位(List<RString> 片足での立位Keys, List<RString> 前回片足での立位Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数16) {
            setKeyBy調査項目(片足での立位Keys, 調査項目, false, false);
            div.getKataAshi().setKataAshiShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数16) {
            setKeyBy調査項目(前回片足での立位Keys, 前回調査項目, false, false);
        }
    }

    private void 片足での立位画面表示(List<RString> 片足での立位Keys, List<RString> 前回片足での立位Keys, RString 認定調査前回結果表示) {
        if (片足での立位Keys.isEmpty()) {
            div.getBtnKataAshi().setDisabled(true);
        } else {
            div.getRadKataAshi().setSelectedKey(片足での立位Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            片足での立位アンダーライン(前回片足での立位Keys);
        }
    }

    private void 片足での立位アンダーライン(List<RString> 前回片足での立位Keys) {
        if (!前回片足での立位Keys.isEmpty()) {
            //TODO
            div.getRadKataAshi();
        }
    }

    private void set立ち上がり(List<RString> 立ち上がりKeys, List<RString> 前回立ち上がりKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数15) {
            setKeyBy調査項目(立ち上がりKeys, 調査項目, false, false);
            div.getTachiAgari().setTachiAgariShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数15) {
            setKeyBy調査項目(前回立ち上がりKeys, 前回調査項目, false, false);
        }
    }

    private void 立ち上がり画面表示(List<RString> 立ち上がりKeys, List<RString> 前回立ち上がりKeys, RString 認定調査前回結果表示) {
        if (立ち上がりKeys.isEmpty()) {
            div.getBtnTachiAgari().setDisabled(true);
        } else {
            div.getRadTachiAgari().setSelectedKey(立ち上がりKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            立ち上がりアンダーライン(前回立ち上がりKeys);
        }
    }

    private void 立ち上がりアンダーライン(List<RString> 前回立ち上がりKeys) {
        if (!前回立ち上がりKeys.isEmpty()) {
            //TODO
            div.getRadTachiAgari();
        }
    }

    private void set歩行(List<RString> 歩行Keys, List<RString> 前回歩行Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数14) {
            setKeyBy調査項目(歩行Keys, 調査項目, false, false);
            div.getBuko().setBukoShinseishoKanriNo(DataPassingConverter.serialize(
                    new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数14) {
            setKeyBy調査項目(前回歩行Keys, 前回調査項目, false, false);
        }
    }

    private void 歩行画面表示(List<RString> 歩行Keys, List<RString> 前回歩行Keys, RString 認定調査前回結果表示) {
        if (歩行Keys.isEmpty()) {
            div.getBtnBuko().setDisabled(true);
        } else {
            div.getRadBuko().setSelectedKey(歩行Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            歩行アンダーライン(前回歩行Keys);
        }
    }

    private void 歩行アンダーライン(List<RString> 前回歩行Keys) {
        if (!前回歩行Keys.isEmpty()) {
            //TODO
            div.getRadBuko();
        }
    }

    private void set両足での立位保持(List<RString> 両足での立位保持Keys, List<RString> 前回両足での立位保持Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数13) {
            setKeyBy調査項目(両足での立位保持Keys, 調査項目, false, false);
            div.getRyoAshi().setRyoAshiShinseishoKanriNo(DataPassingConverter.serialize(
                    new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数13) {
            setKeyBy調査項目(前回両足での立位保持Keys, 前回調査項目, false, false);
        }
    }

    private void 両足での立位保持画面表示(List<RString> 両足での立位保持Keys, List<RString> 前回両足での立位保持Keys, RString 認定調査前回結果表示) {
        if (両足での立位保持Keys.isEmpty()) {
            div.getBtnRyoAshi().setDisabled(true);
        } else {
            div.getRadRyoAshi().setSelectedKey(両足での立位保持Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            両足での立位保持アンダーライン(前回両足での立位保持Keys);
        }
    }

    private void 両足での立位保持アンダーライン(List<RString> 前回両足での立位保持Keys) {
        if (!前回両足での立位保持Keys.isEmpty()) {
            //TODO
            div.getRadRyoAshi();
        }
    }

    private void set座位保持(List<RString> 座位保持Keys, List<RString> 前回座位保持Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数12) {
            setKeyBy調査項目(座位保持Keys, 調査項目, true, false);
            div.getZai().setZaiShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数12) {
            setKeyBy調査項目(前回座位保持Keys, 前回調査項目, true, false);
        }
    }

    private void 座位保持画面表示(List<RString> 座位保持Keys, List<RString> 前回座位保持Keys, RString 認定調査前回結果表示) {
        if (座位保持Keys.isEmpty()) {
            div.getBtnZai().setDisabled(true);
        } else {
            div.getRadZai().setSelectedKey(座位保持Keys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            座位保持アンダーライン(前回座位保持Keys);
        }
    }

    private void 座位保持アンダーライン(List<RString> 前回座位保持Keys) {
        if (!前回座位保持Keys.isEmpty()) {
            //TODO
            div.getRadZai();
        }
    }

    private void set寝返り(List<RString> 寝返りKeys, List<RString> 前回寝返りKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数10) {
            setKeyBy調査項目(寝返りKeys, 調査項目, false, false);
            div.getNeKaeri().setNeKaeriShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数10) {
            setKeyBy調査項目(前回寝返りKeys, 前回調査項目, false, false);
        }
    }

    private void set起き上がり(List<RString> 起き上がりKeys, List<RString> 前回起き上がりKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数11) {
            setKeyBy調査項目(起き上がりKeys, 調査項目, false, false);
            div.getOkiAgari().setOkiAgariShinseishoKanriNo(
                    DataPassingConverter.serialize(new ArrayList<RString>().add(認定調査基本情報.get認定調査特記事項番号())));
        }
        if (前回連番 == 整数11) {
            setKeyBy調査項目(前回起き上がりKeys, 前回調査項目, false, false);
        }
    }

    private void 起き上がり画面表示(List<RString> 起き上がりKeys, List<RString> 前回起き上がりKeys, RString 認定調査前回結果表示) {
        if (起き上がりKeys.isEmpty()) {
            div.getBtnOkiAgari().setDisabled(true);
        } else {
            div.getRadOkiAgari().setSelectedKey(起き上がりKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            起き上がりアンダーライン(前回起き上がりKeys);
        }
    }

    private void 起き上がりアンダーライン(List<RString> 前回起き上がりKeys) {
        if (!前回起き上がりKeys.isEmpty()) {
            //TODO
            div.getRadOkiAgari();
        }
    }

    private void setKeyBy調査項目(List<RString> keys, RString 調査項目, boolean is調査項目4がある, boolean is調査項目5がある) {
        if (調査項目1.equals(調査項目)) {
            keys.add(KEY0);
        } else if (調査項目2.equals(調査項目)) {
            keys.add(KEY1);
        } else if (調査項目3.equals(調査項目)) {
            keys.add(KEY2);
        }
        if (調査項目4.equals(調査項目) && is調査項目4がある) {
            keys.add(KEY3);
        }
        if (調査項目5.equals(調査項目) && is調査項目5がある) {
            keys.add(KEY4);
        }
    }

    private void setKeyBy調査項目が2(List<RString> keys, RString 調査項目) {
        if (調査項目1.equals(調査項目)) {
            keys.add(KEY0);
        } else if (調査項目2.equals(調査項目)) {
            keys.add(KEY1);
        }
    }

    private void 寝返り画面表示(List<RString> 寝返りKeys, List<RString> 前回寝返りKeys, RString 認定調査前回結果表示) {
        if (寝返りKeys.isEmpty()) {
            div.getBtnNeKaeri().setDisabled(true);
        } else {
            div.getRadNeKaeri().setSelectedKey(寝返りKeys.get(0));
        }
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            寝返りアンダーライン(前回寝返りKeys);
        }
    }

    private void 寝返りアンダーライン(List<RString> 前回寝返りKeys) {
        if (!前回寝返りKeys.isEmpty()) {
            //TODO
            div.getRadNeKaeri();
        }
    }

    private void set拘縮の有無Keys(List<RString> 拘縮の有無Keys, List<RString> 前回拘縮の有無Keys,
            List<RString> 拘縮の有無特記事項番号, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 特記事項番号 = 認定調査基本情報.get認定調査特記事項番号();
        if (連番 == 整数6) {
            拘縮の有無Keys.add(KEY1);
            拘縮の有無特記事項番号.add(特記事項番号);
        } else if (連番 == 整数7) {
            拘縮の有無Keys.add(KEY2);
            拘縮の有無特記事項番号.add(特記事項番号);
        } else if (連番 == 整数8) {
            拘縮の有無Keys.add(KEY3);
            拘縮の有無特記事項番号.add(特記事項番号);
        } else if (連番 == 整数9) {
            拘縮の有無Keys.add(KEY4);
            拘縮の有無特記事項番号.add(特記事項番号);
        }
        if (前回連番 == 整数6) {
            前回拘縮の有無Keys.add(KEY1);
        } else if (前回連番 == 整数7) {
            前回拘縮の有無Keys.add(KEY2);
        } else if (前回連番 == 整数8) {
            前回拘縮の有無Keys.add(KEY3);
        } else if (前回連番 == 整数9) {
            前回拘縮の有無Keys.add(KEY4);
        }

    }

    private void set麻痺等の有無Keys(List<RString> 麻痺等の有無Keys, List<RString> 前回麻痺等の有無Keys,
            List<RString> 麻痺等の有無特記事項番号, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 特記事項番号 = 認定調査基本情報.get認定調査特記事項番号();
        if (連番 == 1) {
            麻痺等の有無Keys.add(KEY1);
            麻痺等の有無特記事項番号.add(特記事項番号);
        } else if (連番 == 2) {
            麻痺等の有無Keys.add(KEY2);
            麻痺等の有無特記事項番号.add(特記事項番号);
        } else if (連番 == 整数3) {
            麻痺等の有無Keys.add(KEY3);
            麻痺等の有無特記事項番号.add(特記事項番号);
        } else if (連番 == 整数4) {
            麻痺等の有無Keys.add(KEY4);
            麻痺等の有無特記事項番号.add(特記事項番号);
        } else if (連番 == 整数5) {
            麻痺等の有無Keys.add(KEY5);
            麻痺等の有無特記事項番号.add(特記事項番号);
        }
        if (前回連番 == 1) {
            前回麻痺等の有無Keys.add(KEY1);
        } else if (前回連番 == 2) {
            前回麻痺等の有無Keys.add(KEY2);
        } else if (前回連番 == 整数3) {
            前回麻痺等の有無Keys.add(KEY3);
        } else if (前回連番 == 整数4) {
            前回麻痺等の有無Keys.add(KEY4);
        } else if (前回連番 == 整数5) {
            前回麻痺等の有無Keys.add(KEY5);
        }
    }

    private void 拘縮の有無画面表示(List<RString> 拘縮の有無Keys, List<RString> 前回拘縮の有無Keys,
            List<RString> 拘縮の有無特記事項番号, RString 認定調査前回結果表示) {
        if (拘縮の有無Keys.isEmpty()) {
            div.getBtnKoshuku().setDisabled(true);
            拘縮の有無Keys.add(KEY0);
            List<RString> disabledKeys = new ArrayList<>();
            disabledKeys.add(KEY1);
            disabledKeys.add(KEY2);
            disabledKeys.add(KEY3);
            disabledKeys.add(KEY4);
            div.getKoshuku().setIsKoshukuSelected(new RString("1"));
            div.getChkKoshuku().setDisabledItemsByKey(disabledKeys);
        } else {
            div.getKoshuku().setKoshukuShinseishoKanriNo(DataPassingConverter.serialize(new ArrayList<RString>().addAll(拘縮の有無特記事項番号)));
            div.getKoshuku().setIsKoshukuSelected(new RString("0"));
        }
        div.getChkKoshuku().setSelectedItemsByKey(拘縮の有無Keys);
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            拘縮の有無アンダーライン(前回拘縮の有無Keys);
        }
    }

    private void 拘縮の有無アンダーライン(List<RString> 前回拘縮の有無) {
        if (!前回拘縮の有無.isEmpty()) {
            //TODO
            div.getChkKoshuku();
        }
    }

    private void 麻痺等の有無画面表示(List<RString> 麻痺等の有無Keys, List<RString> 前回麻痺等の有無Keys,
            List<RString> 麻痺等の有無特記事項番号, RString 認定調査前回結果表示) {
        if (麻痺等の有無Keys.isEmpty()) {
            div.getBtnMahi().setDisabled(true);
            麻痺等の有無Keys.add(KEY0);
            List<RString> disabledKeys = new ArrayList<>();
            disabledKeys.add(KEY1);
            disabledKeys.add(KEY2);
            disabledKeys.add(KEY3);
            disabledKeys.add(KEY4);
            disabledKeys.add(KEY5);
            div.getMahi().setIsMahiSelected(new RString("1"));
            div.getChkMahi().setDisabledItemsByKey(disabledKeys);
        } else {
            div.getMahi().setMahiShinseishoKanriNo(DataPassingConverter.serialize(new ArrayList<RString>().addAll(麻痺等の有無特記事項番号)));
            div.getMahi().setIsMahiSelected(new RString("0"));
        }
        div.getChkMahi().setSelectedItemsByKey(麻痺等の有無Keys);
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            麻痺等の有無アンダーライン(前回麻痺等の有無Keys);
        }
    }

    private void 麻痺等の有無アンダーライン(List<RString> 前回麻痺等の有無) {
        if (!前回麻痺等の有無.isEmpty()) {
            //TODO
            div.getChkMahi();
        }
    }

}
