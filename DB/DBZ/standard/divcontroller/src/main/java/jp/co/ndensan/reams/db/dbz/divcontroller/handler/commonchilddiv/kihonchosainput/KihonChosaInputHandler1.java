/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.kihonchosainput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput.KihonChosaInput.KihonChosaInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.IconType;
import jp.co.ndensan.reams.uz.uza.ui.binding.ListControlTextIcon;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 共有子Div「認定基本調査入力」の状態を変更するクラスです。
 */
public class KihonChosaInputHandler1 {

    private final KihonChosaInputDiv div;
    private final RString 認定調査前回結果表示 = new RString("1");
    private final RString 調査項目ある = new RString("1");
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
    public KihonChosaInputHandler1(KihonChosaInputDiv div) {
        this.div = div;
    }

    /**
     * 共有子Divの第一群身体機能を初期化します。
     *
     * @param 認定調査基本情報リスト 認定調査基本情報リスト
     * @param 認定調査前回結果表示 認定調査前回結果表示
     */
    public void onLoad第一群身体機能(ArrayList<KihonChosaInput> 認定調査基本情報リスト, RString 認定調査前回結果表示) {
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
    }

    /**
     * 共有子Divの第二群生活機能を初期化します。
     *
     * @param 認定調査基本情報リスト 認定調査基本情報リスト
     * @param 認定調査前回結果表示 認定調査前回結果表示
     */
    public void onLoad第二群生活機能(ArrayList<KihonChosaInput> 認定調査基本情報リスト, RString 認定調査前回結果表示) {
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
        for (KihonChosaInput 認定調査基本情報 : 認定調査基本情報リスト) {
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
        }
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
    }

    /**
     * 共有子Divの第三群認知機能を初期化します。
     *
     * @param 認定調査基本情報リスト 認定調査基本情報リスト
     * @param 認定調査前回結果表示 認定調査前回結果表示
     */
    public void onLoad第三群認知機能(ArrayList<KihonChosaInput> 認定調査基本情報リスト, RString 認定調査前回結果表示) {
        List<RString> 意思の伝達Keys = new ArrayList<>();
        List<RString> 前回意思の伝達Keys = new ArrayList<>();
        List<RString> 毎日の日課を理解Keys = new ArrayList<>();
        List<RString> 前回毎日の日課を理解Keys = new ArrayList<>();
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
        for (KihonChosaInput 認定調査基本情報 : 認定調査基本情報リスト) {
            set意思の伝達(意思の伝達Keys, 前回意思の伝達Keys, 認定調査基本情報);
            set毎日の日課を理解(毎日の日課を理解Keys, 前回毎日の日課を理解Keys, 認定調査基本情報);
            set生年月日や年齢を言う(生年月日や年齢を言うKeys, 前回生年月日や年齢を言うKeys, 認定調査基本情報);
            set短期記憶(短期記憶Keys, 前回短期記憶Keys, 認定調査基本情報);
            set自分の名前を言う(自分の名前を言うKeys, 前回自分の名前を言うKeys, 認定調査基本情報);
            set今の季節を理解する(今の季節を理解するKeys, 前回今の季節を理解するKeys, 認定調査基本情報);
            set場所の理解(場所の理解Keys, 前回場所の理解Keys, 認定調査基本情報);
            set徘徊(徘徊Keys, 前回徘徊Keys, 認定調査基本情報);
            set外出すると戻れない(外出すると戻れないKeys, 前回外出すると戻れないKeys, 認定調査基本情報);
        }
        意思の伝達画面表示(意思の伝達Keys, 前回意思の伝達Keys, 認定調査前回結果表示);
        毎日の日課を理解画面表示(毎日の日課を理解Keys, 前回毎日の日課を理解Keys, 認定調査前回結果表示);
        生年月日や年齢を言う画面表示(生年月日や年齢を言うKeys, 前回生年月日や年齢を言うKeys, 認定調査前回結果表示);
        短期記憶画面表示(短期記憶Keys, 前回短期記憶Keys, 認定調査前回結果表示);
        自分の名前を言う画面表示(自分の名前を言うKeys, 前回自分の名前を言うKeys, 認定調査前回結果表示);
        今の季節を理解する画面表示(今の季節を理解するKeys, 前回今の季節を理解するKeys, 認定調査前回結果表示);
        場所の理解画面表示(場所の理解Keys, 前回場所の理解Keys, 認定調査前回結果表示);
        徘徊画面表示(徘徊Keys, 前回徘徊Keys, 認定調査前回結果表示);
        外出すると戻れない画面表示(外出すると戻れないKeys, 前回外出すると戻れないKeys, 認定調査前回結果表示);
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadModoru().setIcon(getListControlTextIcon(前回外出すると戻れないKeys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadHaikai().setIcon(getListControlTextIcon(前回徘徊Keys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadBasho().setIcon(getListControlTextIcon(前回場所の理解Keys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadKisetsu().setIcon(getListControlTextIcon(前回今の季節を理解するKeys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadNameInfo().setIcon(getListControlTextIcon(前回自分の名前を言うKeys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadDankiKioku().setIcon(getListControlTextIcon(前回短期記憶Keys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadInfo().setIcon(getListControlTextIcon(前回生年月日や年齢を言うKeys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadNikka().setIcon(getListControlTextIcon(前回毎日の日課を理解Keys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadIshiDentatsu().setIcon(getListControlTextIcon(前回意思の伝達Keys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadHindo().setIcon(getListControlTextIcon(前回外出頻度Keys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadZubon().setIcon(getListControlTextIcon(前回ズボン等の着脱Keys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadUwagi().setIcon(getListControlTextIcon(前回上衣の着脱Keys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadSeihatsu().setIcon(getListControlTextIcon(前回整髪Keys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadSengan().setIcon(getListControlTextIcon(前回洗顔Keys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadKokou().setIcon(getListControlTextIcon(前回口腔清潔Keys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadHaiben().setIcon(getListControlTextIcon(前回排便Keys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadHainyo().setIcon(getListControlTextIcon(前回排尿Keys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadShokuji().setIcon(getListControlTextIcon(前回食事摂取Keys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadEnka().setIcon(getListControlTextIcon(前回えん下Keys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadIdou().setIcon(getListControlTextIcon(前回移動Keys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadIjyo().setIcon(getListControlTextIcon(前回移乗Keys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadShiryoku().setIcon(getListControlTextIcon(前回視力Keys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadChoryoku().setIcon(getListControlTextIcon(前回聴力Keys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadTumeKiri().setIcon(getListControlTextIcon(前回つめ切りKeys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadSenshin().setIcon(getListControlTextIcon(前回洗身Keys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadKataAshi().setIcon(getListControlTextIcon(前回片足での立位Keys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadTachiAgari().setIcon(getListControlTextIcon(前回立ち上がりKeys));
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
                    get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadBuko().setIcon(getListControlTextIcon(前回歩行Keys));
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
                    get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadRyoAshi().setIcon(getListControlTextIcon(前回両足での立位保持Keys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadZai().setIcon(getListControlTextIcon(前回座位保持Keys));
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
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
        }
        if (前回連番 == 整数10) {
            setKeyBy調査項目(前回寝返りKeys, 前回調査項目, false, false);
        }
    }

    private ArrayList<RString> get認定調査特記事項番号List(KihonChosaInput 認定調査基本情報) {
        ArrayList<RString> list = new ArrayList<>();
        if (認定調査基本情報 != null) {
            list.add(認定調査基本情報.get認定調査特記事項番号());
        }
        return list;
    }

    private void set起き上がり(List<RString> 起き上がりKeys, List<RString> 前回起き上がりKeys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数11) {
            setKeyBy調査項目(起き上がりKeys, 調査項目, false, false);
            div.getOkiAgari().setOkiAgariShinseishoKanriNo(
                    DataPassingConverter.serialize(get認定調査特記事項番号List(認定調査基本情報)));
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
            div.getRadOkiAgari().setIcon(getListControlTextIcon(前回起き上がりKeys));
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
            div.getRadNeKaeri().setIcon(getListControlTextIcon(前回寝返りKeys));
        }
    }

    private void set拘縮の有無Keys(List<RString> 拘縮の有無Keys, List<RString> 前回拘縮の有無Keys,
            List<RString> 拘縮の有無特記事項番号, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        RString 特記事項番号 = 認定調査基本情報.get認定調査特記事項番号();
        if (調査項目ある.equals(調査項目)) {
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
        }
        if (調査項目ある.equals(前回調査項目)) {
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
    }

    private void set麻痺等の有無Keys(List<RString> 麻痺等の有無Keys, List<RString> 前回麻痺等の有無Keys,
            List<RString> 麻痺等の有無特記事項番号, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        RString 特記事項番号 = 認定調査基本情報.get認定調査特記事項番号();
        if (調査項目ある.equals(調査項目)) {
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
        }
        if (調査項目ある.equals(前回調査項目)) {
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
            div.getKoshuku().setKoshukuShinseishoKanriNo(DataPassingConverter.serialize(new ArrayList<>(拘縮の有無特記事項番号)));
            div.getKoshuku().setIsKoshukuSelected(new RString("0"));
        }
        div.getChkKoshuku().setSelectedItemsByKey(拘縮の有無Keys);
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            拘縮の有無アンダーライン(前回拘縮の有無Keys);
        }
    }

    private void 拘縮の有無アンダーライン(List<RString> 前回拘縮の有無) {
        if (!前回拘縮の有無.isEmpty()) {
            div.getChkKoshuku().setIcon(getListControlTextIcon(前回拘縮の有無));
        } else {
            前回拘縮の有無.add(KEY0);
            div.getChkKoshuku().setIcon(getListControlTextIcon(前回拘縮の有無));
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
            div.getMahi().setMahiShinseishoKanriNo(DataPassingConverter.serialize(new ArrayList<>(麻痺等の有無特記事項番号)));
            div.getMahi().setIsMahiSelected(new RString("0"));
        }
        div.getChkMahi().setSelectedItemsByKey(麻痺等の有無Keys);
        if (this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            麻痺等の有無アンダーライン(前回麻痺等の有無Keys);
        }
    }

    private void 麻痺等の有無アンダーライン(List<RString> 前回麻痺等の有無) {
        if (!前回麻痺等の有無.isEmpty()) {
            div.getChkMahi().setIcon(getListControlTextIcon(前回麻痺等の有無));
        } else {
            前回麻痺等の有無.add(KEY0);
            div.getChkMahi().setIcon(getListControlTextIcon(前回麻痺等の有無));
        }
    }

    private List<ListControlTextIcon> getListControlTextIcon(List<RString> 前回Keys) {
        List<ListControlTextIcon> iconList = new ArrayList<>();
        for (RString 前回Key : 前回Keys) {
            if (KEY0.equals(前回Key)) {
                iconList.add(new ListControlTextIcon(KEY0, IconType.File_Ari));
            } else if (KEY1.equals(前回Key)) {
                iconList.add(new ListControlTextIcon(KEY1, IconType.File_Ari));
            } else if (KEY2.equals(前回Key)) {
                iconList.add(new ListControlTextIcon(KEY2, IconType.File_Ari));
            } else if (KEY3.equals(前回Key)) {
                iconList.add(new ListControlTextIcon(KEY3, IconType.File_Ari));
            } else if (KEY4.equals(前回Key)) {
                iconList.add(new ListControlTextIcon(KEY4, IconType.File_Ari));
            } else if (KEY5.equals(前回Key)) {
                iconList.add(new ListControlTextIcon(KEY5, IconType.File_Ari));
            } else if (KEY6.equals(前回Key)) {
                iconList.add(new ListControlTextIcon(KEY6, IconType.File_Ari));
            } else if (KEY7.equals(前回Key)) {
                iconList.add(new ListControlTextIcon(KEY7, IconType.File_Ari));
            } else if (KEY8.equals(前回Key)) {
                iconList.add(new ListControlTextIcon(KEY8, IconType.File_Ari));
            }
        }
        return iconList;
    }

}
