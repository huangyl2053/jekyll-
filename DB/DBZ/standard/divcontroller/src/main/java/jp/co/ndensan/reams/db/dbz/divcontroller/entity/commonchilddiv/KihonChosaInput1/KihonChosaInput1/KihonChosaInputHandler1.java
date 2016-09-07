/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput1.KihonChosaInput1;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaSpecial;
import jp.co.ndensan.reams.db.dbz.service.core.kihonchosainput.KihonChosaInputFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.IconType;
import jp.co.ndensan.reams.uz.uza.ui.binding.ListControlTextIcon;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 共有子Div「認定基本調査入力」の第一群身体機能の状態を変更するクラスです。
 *
 * @reamsid_L DBE-3000-090 wangjie2
 */
public class KihonChosaInputHandler1 {

    private final KihonChosaInput1Div div;
    private final RString 認定調査前回結果表示 = new RString("1");
    private final RString 調査項目ある = new RString("2");
    private final RString 調査項目ない = new RString("1");
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
    private final RString 調査項目1 = new RString("1");
    private final RString 調査項目2 = new RString("2");
    private final RString 調査項目3 = new RString("3");
    private final RString 調査項目4 = new RString("4");
    private final RString 調査項目5 = new RString("5");
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
     * @param div KihonChosaInput1Div
     */
    public KihonChosaInputHandler1(KihonChosaInput1Div div) {
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
     * @param 認定調査基本情報リスト 認定調査基本情報リスト
     */
    public void onLoad(ShinseishoKanriNo 申請書管理番号, RString 認定調査依頼履歴番号, List<KihonChosaInput> 認定調査基本情報リスト) {
        if (申請書管理番号 != null) {
            div.getDaiichigunShintaiKino().setShinseishoKanriNo(申請書管理番号.getColumnValue());
        }
        div.getDaiichigunShintaiKino().setRecordNumber(認定調査依頼履歴番号);
        if (null == 認定調査基本情報リスト) {
            認定調査基本情報リスト = new ArrayList<>();
        }
        RString 認定調査前回結果表示 = DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果表示, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (!this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            div.getZenkaiHyojiTeiji().setDisplayNone(true);
        }
        List<RString> 認定調査特記情報List = get特記事項番号List(申請書管理番号);
        ArrayList<RString> 認定調査特記情報ArrayList = new ArrayList<>(認定調査特記情報List);
        div.getDaiichigunShintaiKino().setNinteichosaTokkijikoNoList(DataPassingConverter.serialize(認定調査特記情報ArrayList));
        onLoad第一群身体機能(認定調査基本情報リスト, 認定調査前回結果表示);
    }

    private List<RString> get特記事項番号List(ShinseishoKanriNo 申請書管理番号) {
        KihonChosaInputFinder finder = KihonChosaInputFinder.createInstance();
        List<KihonChosaSpecial> 認定調査特記情報List = finder.get認定調査特記情報(申請書管理番号);
        List<RString> 特記事項番号List = new ArrayList<>();
        for (KihonChosaSpecial 認定調査特記情報 : 認定調査特記情報List) {
            特記事項番号List.add(認定調査特記情報.get認定調査特記事項番号());
        }
        return 特記事項番号List;
    }

    private void onLoad第一群身体機能(List<KihonChosaInput> 認定調査基本情報リスト, RString 認定調査前回結果表示) {
        List<RString> 麻痺等の有無Keys = new ArrayList<>();
        List<RString> 前回麻痺等の有無Keys = new ArrayList<>();
        List<RString> 拘縮の有無Keys = new ArrayList<>();
        List<RString> 前回拘縮の有無Keys = new ArrayList<>();
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
            set麻痺等の有無Keys(麻痺等の有無Keys, 前回麻痺等の有無Keys, 認定調査基本情報);
            set拘縮の有無Keys(拘縮の有無Keys, 前回拘縮の有無Keys, 認定調査基本情報);
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
        麻痺等の有無画面表示(麻痺等の有無Keys, 前回麻痺等の有無Keys, 認定調査前回結果表示);
        拘縮の有無画面表示(拘縮の有無Keys, 前回拘縮の有無Keys, 認定調査前回結果表示);
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

    private void set視力(List<RString> 視力Keys, List<RString> 前回視力Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数19) {
            div.getBtnShiryoku().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(視力Keys, 調査項目, true, true);
        }
        if (前回連番 == 整数19) {
            setKeyBy調査項目(前回視力Keys, 前回調査項目, true, true);
        }
    }

    private void 視力画面表示(List<RString> 視力Keys, List<RString> 前回視力Keys, RString 認定調査前回結果表示) {
        if (!視力Keys.isEmpty()) {
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
            div.getBtnChoryoku().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(聴力Keys, 調査項目, true, true);
        }
        if (前回連番 == 整数20) {
            setKeyBy調査項目(前回聴力Keys, 前回調査項目, true, true);
        }
    }

    private void 聴力画面表示(List<RString> 聴力Keys, List<RString> 前回聴力Keys, RString 認定調査前回結果表示) {
        if (!聴力Keys.isEmpty()) {
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
            div.getBtnTumeKiri().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(つめ切りKeys, 調査項目, false, false);
        }
        if (前回連番 == 整数18) {
            setKeyBy調査項目(前回つめ切りKeys, 前回調査項目, false, false);
        }
    }

    private void つめ切り画面表示(List<RString> つめ切りKeys, List<RString> 前回つめ切りKeys, RString 認定調査前回結果表示) {
        if (!つめ切りKeys.isEmpty()) {
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
            div.getBtnSenshin().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(洗身Keys, 調査項目, true, false);
        }
        if (前回連番 == 整数17) {
            setKeyBy調査項目(前回洗身Keys, 前回調査項目, true, false);
        }
    }

    private void 洗身画面表示(List<RString> 洗身Keys, List<RString> 前回洗身Keys, RString 認定調査前回結果表示) {
        if (!洗身Keys.isEmpty()) {
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
            div.getBtnKataAshi().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(片足での立位Keys, 調査項目, false, false);
        }
        if (前回連番 == 整数16) {
            setKeyBy調査項目(前回片足での立位Keys, 前回調査項目, false, false);
        }
    }

    private void 片足での立位画面表示(List<RString> 片足での立位Keys, List<RString> 前回片足での立位Keys, RString 認定調査前回結果表示) {
        if (!片足での立位Keys.isEmpty()) {
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
            div.getBtnTachiAgari().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(立ち上がりKeys, 調査項目, false, false);
        }
        if (前回連番 == 整数15) {
            setKeyBy調査項目(前回立ち上がりKeys, 前回調査項目, false, false);
        }
    }

    private void 立ち上がり画面表示(List<RString> 立ち上がりKeys, List<RString> 前回立ち上がりKeys, RString 認定調査前回結果表示) {
        if (!立ち上がりKeys.isEmpty()) {
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
            div.getBtnBuko().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(歩行Keys, 調査項目, false, false);
        }
        if (前回連番 == 整数14) {
            setKeyBy調査項目(前回歩行Keys, 前回調査項目, false, false);
        }
    }

    private void 歩行画面表示(List<RString> 歩行Keys, List<RString> 前回歩行Keys, RString 認定調査前回結果表示) {
        if (!歩行Keys.isEmpty()) {
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
            div.getBtnRyoAshi().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(両足での立位保持Keys, 調査項目, false, false);
        }
        if (前回連番 == 整数13) {
            setKeyBy調査項目(前回両足での立位保持Keys, 前回調査項目, false, false);
        }
    }

    private void 両足での立位保持画面表示(List<RString> 両足での立位保持Keys, List<RString> 前回両足での立位保持Keys, RString 認定調査前回結果表示) {
        if (!両足での立位保持Keys.isEmpty()) {
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
            div.getBtnZai().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(座位保持Keys, 調査項目, true, false);
        }
        if (前回連番 == 整数12) {
            setKeyBy調査項目(前回座位保持Keys, 前回調査項目, true, false);
        }
    }

    private void 座位保持画面表示(List<RString> 座位保持Keys, List<RString> 前回座位保持Keys, RString 認定調査前回結果表示) {
        if (!座位保持Keys.isEmpty()) {
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
            div.getBtnNeKaeri().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(寝返りKeys, 調査項目, false, false);
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
            div.getBtnOkiAgari().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(起き上がりKeys, 調査項目, false, false);
        }
        if (前回連番 == 整数11) {
            setKeyBy調査項目(前回起き上がりKeys, 前回調査項目, false, false);
        }
    }

    private void 起き上がり画面表示(List<RString> 起き上がりKeys, List<RString> 前回起き上がりKeys, RString 認定調査前回結果表示) {
        if (!起き上がりKeys.isEmpty()) {
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

    private void 寝返り画面表示(List<RString> 寝返りKeys, List<RString> 前回寝返りKeys, RString 認定調査前回結果表示) {
        if (!寝返りKeys.isEmpty()) {
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

    private void set拘縮の有無Keys(List<RString> 拘縮の有無Keys, List<RString> 前回拘縮の有無Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 >= 整数6 && 連番 <= 整数9) {
            div.getBtnKoshuku().setDisabled(!認定調査基本情報.is特記事項有無());
        }
        if (調査項目ある.equals(調査項目)) {
            if (連番 == 整数6) {
                拘縮の有無Keys.add(KEY1);
            } else if (連番 == 整数7) {
                拘縮の有無Keys.add(KEY2);
            } else if (連番 == 整数8) {
                拘縮の有無Keys.add(KEY3);
            } else if (連番 == 整数9) {
                拘縮の有無Keys.add(KEY4);
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

    private void set麻痺等の有無Keys(List<RString> 麻痺等の有無Keys, List<RString> 前回麻痺等の有無Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 >= 1 && 連番 <= 整数5) {
            div.getBtnMahi().setDisabled(!認定調査基本情報.is特記事項有無());
        }
        if (調査項目ある.equals(調査項目)) {
            if (連番 == 1) {
                麻痺等の有無Keys.add(KEY1);
            } else if (連番 == 2) {
                麻痺等の有無Keys.add(KEY2);
            } else if (連番 == 整数3) {
                麻痺等の有無Keys.add(KEY3);
            } else if (連番 == 整数4) {
                麻痺等の有無Keys.add(KEY4);
            } else if (連番 == 整数5) {
                麻痺等の有無Keys.add(KEY5);
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

    private void 拘縮の有無画面表示(List<RString> 拘縮の有無Keys, List<RString> 前回拘縮の有無Keys, RString 認定調査前回結果表示) {
        if (拘縮の有無Keys.isEmpty()) {
            拘縮の有無Keys.add(KEY0);
            List<RString> disabledKeys = new ArrayList<>();
            disabledKeys.add(KEY1);
            disabledKeys.add(KEY2);
            disabledKeys.add(KEY3);
            disabledKeys.add(KEY4);
            div.getKoshuku().setIsKoshukuSelected(new RString("1"));
            div.getChkKoshuku().setDisabledItemsByKey(disabledKeys);
        } else {
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

    private void 麻痺等の有無画面表示(List<RString> 麻痺等の有無Keys, List<RString> 前回麻痺等の有無Keys, RString 認定調査前回結果表示) {
        if (麻痺等の有無Keys.isEmpty()) {
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
            div.getMahi().setIsMahiSelected(new RString("0"));
        }
        div.getChkMahi().setMaxCheckedItem(整数6);
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

    /**
     * 認定基本調査入力を確認を押下する。
     *
     * @param 認定調査基本情報リスト 認定調査基本情報リスト
     * @return 認定調査基本情報リスト
     */
    public ArrayList<KihonChosaInput> onClick_btnConfirm(ArrayList<KihonChosaInput> 認定調査基本情報リスト) {
        if (null == 認定調査基本情報リスト) {
            認定調査基本情報リスト = new ArrayList<>();
        }
        第一群身体機能Confirm(認定調査基本情報リスト);
        return 認定調査基本情報リスト;
    }

    private void 第一群身体機能Confirm(ArrayList<KihonChosaInput> 認定調査基本情報リスト) {
        List<RString> 麻痺等の有無Keys = div.getChkMahi().getSelectedKeys();
        List<RString> 拘縮の有無Keys = div.getChkKoshuku().getSelectedKeys();
        RString 寝返りKey = div.getRadNeKaeri().getSelectedKey();
        RString 起き上がりKey = div.getRadOkiAgari().getSelectedKey();
        RString 座位保持Key = div.getRadZai().getSelectedKey();
        RString 両足での立位保持Key = div.getRadRyoAshi().getSelectedKey();
        RString 歩行Key = div.getRadBuko().getSelectedKey();
        RString 立ち上がりKey = div.getRadTachiAgari().getSelectedKey();
        RString 片足での立位Key = div.getRadKataAshi().getSelectedKey();
        RString 洗身Key = div.getRadSenshin().getSelectedKey();
        RString つめ切りKey = div.getRadTumeKiri().getSelectedKey();
        RString 視力Key = div.getRadShiryoku().getSelectedKey();
        RString 聴力Key = div.getRadChoryoku().getSelectedKey();
        単項Confirm(認定調査基本情報リスト, 整数10, 寝返りKey);
        単項Confirm(認定調査基本情報リスト, 整数11, 起き上がりKey);
        単項Confirm(認定調査基本情報リスト, 整数12, 座位保持Key);
        単項Confirm(認定調査基本情報リスト, 整数13, 両足での立位保持Key);
        単項Confirm(認定調査基本情報リスト, 整数14, 歩行Key);
        単項Confirm(認定調査基本情報リスト, 整数15, 立ち上がりKey);
        単項Confirm(認定調査基本情報リスト, 整数16, 片足での立位Key);
        単項Confirm(認定調査基本情報リスト, 整数17, 洗身Key);
        単項Confirm(認定調査基本情報リスト, 整数18, つめ切りKey);
        単項Confirm(認定調査基本情報リスト, 整数19, 視力Key);
        単項Confirm(認定調査基本情報リスト, 整数20, 聴力Key);
        List<Integer> 麻痺拘縮連番List = new ArrayList<>();
        add連番ListBy麻痺等の有無Keys(麻痺拘縮連番List, 麻痺等の有無Keys);
        add連番ListBy拘縮の有無Keys(麻痺拘縮連番List, 拘縮の有無Keys);
        checkListBoxConfirm(認定調査基本情報リスト, 麻痺拘縮連番List);
    }

    private void checkListBoxConfirm(ArrayList<KihonChosaInput> 認定調査基本情報リスト, List<Integer> 連番List) {
        ArrayList<KihonChosaInput> remove認定調査基本情報リスト = new ArrayList<>();
        ArrayList<KihonChosaInput> add認定調査基本情報リスト = new ArrayList<>();
        for (KihonChosaInput 認定調査基本情報 : 認定調査基本情報リスト) {
            int 認定調査基本情報_連番 = 認定調査基本情報.get調査連番();
            if ((認定調査基本情報_連番 <= 整数9 && 認定調査基本情報_連番 >= 1)) {
                if (!is認定調査基本情報_連番が連番Listに存在(連番List, 認定調査基本情報_連番)
                        && 調査項目ある.equals(認定調査基本情報.get調査項目())) {
                    KihonChosaInput new認定調査基本情報 = new KihonChosaInput(認定調査基本情報.get申請書管理番号(),
                            認定調査基本情報.get認定調査依頼履歴番号(), 認定調査基本情報.get認知症高齢者自立度(),
                            認定調査基本情報.get障害高齢者自立度(), 認定調査基本情報.get調査連番(), 調査項目ない,
                            認定調査基本情報.get前回認知症高齢者自立度(), 認定調査基本情報.get前回障害高齢者自立度(), 認定調査基本情報.get前回調査連番(),
                            認定調査基本情報.get前回調査項目(), 認定調査基本情報.is特記事項有無());
                    remove認定調査基本情報リスト.add(認定調査基本情報);
                    add認定調査基本情報リスト.add(new認定調査基本情報);
                } else if (is認定調査基本情報_連番が連番Listに存在(連番List, 認定調査基本情報_連番)
                        && !調査項目ある.equals(認定調査基本情報.get調査項目())) {
                    KihonChosaInput new認定調査基本情報 = new KihonChosaInput(認定調査基本情報.get申請書管理番号(),
                            認定調査基本情報.get認定調査依頼履歴番号(), 認定調査基本情報.get認知症高齢者自立度(),
                            認定調査基本情報.get障害高齢者自立度(), 認定調査基本情報.get調査連番(), 調査項目ある,
                            認定調査基本情報.get前回認知症高齢者自立度(), 認定調査基本情報.get前回障害高齢者自立度(), 認定調査基本情報.get前回調査連番(),
                            認定調査基本情報.get前回調査項目(), 認定調査基本情報.is特記事項有無());
                    remove認定調査基本情報リスト.add(認定調査基本情報);
                    add認定調査基本情報リスト.add(new認定調査基本情報);
                }
            }
        }
        if (!remove認定調査基本情報リスト.isEmpty()) {
            認定調査基本情報リスト.removeAll(remove認定調査基本情報リスト);
            認定調査基本情報リスト.addAll(add認定調査基本情報リスト);
        }
    }

    private boolean is認定調査基本情報_連番が連番Listに存在(List<Integer> 連番List, int 認定調査基本情報_連番) {
        for (int 連番 : 連番List) {
            if (連番 == 認定調査基本情報_連番) {
                return true;
            }
        }
        return false;
    }

    private void 単項Confirm(ArrayList<KihonChosaInput> 認定調査基本情報リスト, int 連番, RString 単項Key) {
        ArrayList<KihonChosaInput> remove認定調査基本情報リスト = new ArrayList<>();
        ArrayList<KihonChosaInput> add認定調査基本情報リスト = new ArrayList<>();
        if (単項Key.isNullOrEmpty()) {
            return;
        }
        boolean is連番対応認定調査基本情報なし = true;
        for (KihonChosaInput 認定調査基本情報 : 認定調査基本情報リスト) {
            if (連番 == 認定調査基本情報.get調査連番()) {
                if (!get調査項目By単項Key(単項Key).equals(認定調査基本情報.get調査項目())) {
                    KihonChosaInput new認定調査基本情報 = new KihonChosaInput(認定調査基本情報.get申請書管理番号(),
                            認定調査基本情報.get認定調査依頼履歴番号(), 認定調査基本情報.get認知症高齢者自立度(),
                            認定調査基本情報.get障害高齢者自立度(), 認定調査基本情報.get調査連番(), get調査項目By単項Key(単項Key),
                            認定調査基本情報.get前回認知症高齢者自立度(), 認定調査基本情報.get前回障害高齢者自立度(), 認定調査基本情報.get前回調査連番(),
                            認定調査基本情報.get前回調査項目(), 認定調査基本情報.is特記事項有無());
                    remove認定調査基本情報リスト.add(認定調査基本情報);
                    add認定調査基本情報リスト.add(new認定調査基本情報);
                }
                is連番対応認定調査基本情報なし = false;
            }
        }
        if (!remove認定調査基本情報リスト.isEmpty()) {
            認定調査基本情報リスト.removeAll(remove認定調査基本情報リスト);
            認定調査基本情報リスト.addAll(add認定調査基本情報リスト);
        }
        if (is連番対応認定調査基本情報なし) {
            認定調査基本情報リスト.add(new KihonChosaInput(ShinseishoKanriNo.EMPTY, 0, Code.EMPTY, Code.EMPTY,
                    連番, get調査項目By単項Key(単項Key), Code.EMPTY, Code.EMPTY, 0, RString.EMPTY, false));
        }
    }

    private RString get調査項目By単項Key(RString 単項Key) {
        if (KEY0.equals(単項Key)) {
            return 調査項目1;
        } else if (KEY1.equals(単項Key)) {
            return 調査項目2;
        } else if (KEY2.equals(単項Key)) {
            return 調査項目3;
        } else if (KEY3.equals(単項Key)) {
            return 調査項目4;
        } else if (KEY4.equals(単項Key)) {
            return 調査項目5;
        }
        return RString.EMPTY;
    }

    private void add連番ListBy麻痺等の有無Keys(List<Integer> 連番List, List<RString> 麻痺等の有無keys) {
        if (麻痺等の有無keys.isEmpty()) {
            return;
        }
        if (KEY0.equals(麻痺等の有無keys.get(0))) {
            return;
        }
        for (RString key : 麻痺等の有無keys) {
            if (KEY1.equals(key)) {
                連番List.add(1);
            } else if (KEY2.equals(key)) {
                連番List.add(2);
            } else if (KEY3.equals(key)) {
                連番List.add(整数3);
            } else if (KEY4.equals(key)) {
                連番List.add(整数4);
            } else if (KEY5.equals(key)) {
                連番List.add(整数5);
            }
        }
    }

    private void add連番ListBy拘縮の有無Keys(List<Integer> 連番List, List<RString> 拘縮の有無keys) {
        if (拘縮の有無keys.isEmpty()) {
            return;
        }
        if (KEY0.equals(拘縮の有無keys.get(0))) {
            return;
        }
        for (RString key : 拘縮の有無keys) {
            if (KEY1.equals(key)) {
                連番List.add(整数6);
            } else if (KEY2.equals(key)) {
                連番List.add(整数7);
            } else if (KEY3.equals(key)) {
                連番List.add(整数8);
            } else if (KEY4.equals(key)) {
                連番List.add(整数9);
            }
        }
    }

}
