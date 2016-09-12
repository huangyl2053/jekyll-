/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput2.KihonChosaInput2;

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
 * 共有子Div「認定基本調査入力」の第二群生活機能の状態を変更するクラスです。
 *
 * @reamsid_L DBE-3000-091 wangjie2
 */
public class KihonChosaInputHandler2 {

    private final KihonChosaInput2Div div;
    private final RString 認定調査前回結果表示 = new RString("1");
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
    private static final RString KEY1 = new RString("key1");
    private static final RString KEY0 = new RString("key0");
    private static final RString KEY2 = new RString("key2");
    private static final RString KEY3 = new RString("key3");
    private static final RString KEY4 = new RString("key4");
    private static final RString KEY5 = new RString("key5");
    private static final RString KEY6 = new RString("key6");
    private static final RString KEY7 = new RString("key7");
    private static final RString KEY8 = new RString("key8");
    private final RString 調査項目1 = new RString("1");
    private final RString 調査項目2 = new RString("2");
    private final RString 調査項目3 = new RString("3");
    private final RString 調査項目4 = new RString("4");
    private final RString 調査項目5 = new RString("5");

    /**
     * コンストラクタです。
     *
     * @param div KihonChosaInput2Div
     */
    public KihonChosaInputHandler2(KihonChosaInput2Div div) {
        this.div = div;
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
            div.getSeikatsuKinou().setShinseishoKanriNo(申請書管理番号.getColumnValue());
        }
        div.getSeikatsuKinou().setRecordNumber(認定調査依頼履歴番号);
        if (null == 認定調査基本情報リスト) {
            認定調査基本情報リスト = new ArrayList<>();
        }
        RString 認定調査前回結果表示 = DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果表示, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (!this.認定調査前回結果表示.equals(認定調査前回結果表示)) {
            div.getZenkaiHyojiTeiji().setDisplayNone(true);
        }
        List<RString> 認定調査特記情報List = get特記事項番号List(申請書管理番号);
        ArrayList<RString> 認定調査特記情報ArrayList = new ArrayList<>(認定調査特記情報List);
        div.getSeikatsuKinou().setNinteichosaTokkijikoNoList(DataPassingConverter.serialize(認定調査特記情報ArrayList));
        onLoad第二群生活機能(認定調査基本情報リスト, 認定調査前回結果表示);
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

    private void onLoad第二群生活機能(List<KihonChosaInput> 認定調査基本情報リスト, RString 認定調査前回結果表示) {
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

    private void set外出頻度(List<RString> 外出頻度Keys, List<RString> 前回外出頻度Keys, KihonChosaInput 認定調査基本情報) {
        int 連番 = 認定調査基本情報.get調査連番();
        int 前回連番 = 認定調査基本情報.get前回調査連番();
        RString 調査項目 = 認定調査基本情報.get調査項目();
        RString 前回調査項目 = 認定調査基本情報.get前回調査項目();
        if (連番 == 整数32) {
            div.getBtnHindo().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(外出頻度Keys, 調査項目, false, false);
        }
        if (前回連番 == 整数32) {
            setKeyBy調査項目(前回外出頻度Keys, 前回調査項目, false, false);
        }
    }

    private void 外出頻度画面表示(List<RString> 外出頻度Keys, List<RString> 前回外出頻度Keys, RString 認定調査前回結果表示) {
        if (!外出頻度Keys.isEmpty()) {
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
            div.getBtnZubon().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(ズボン等の着脱Keys, 調査項目, true, false);
        }
        if (前回連番 == 整数31) {
            setKeyBy調査項目(前回ズボン等の着脱Keys, 前回調査項目, true, false);
        }
    }

    private void ズボン等の着脱画面表示(List<RString> ズボン等の着脱Keys, List<RString> 前回ズボン等の着脱Keys, RString 認定調査前回結果表示) {
        if (!ズボン等の着脱Keys.isEmpty()) {
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
            div.getBtnUwagi().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(上衣の着脱Keys, 調査項目, true, false);
        }
        if (前回連番 == 整数30) {
            setKeyBy調査項目(前回上衣の着脱Keys, 前回調査項目, true, false);
        }
    }

    private void 上衣の着脱画面表示(List<RString> 上衣の着脱Keys, List<RString> 前回上衣の着脱Keys, RString 認定調査前回結果表示) {
        if (!上衣の着脱Keys.isEmpty()) {
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
            div.getBtnSeihatsu().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(整髪Keys, 調査項目, false, false);
        }
        if (前回連番 == 整数29) {
            setKeyBy調査項目(前回整髪Keys, 前回調査項目, false, false);
        }
    }

    private void 整髪画面表示(List<RString> 整髪Keys, List<RString> 前回整髪Keys, RString 認定調査前回結果表示) {
        if (!整髪Keys.isEmpty()) {
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
            div.getBtnSengan().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(洗顔Keys, 調査項目, false, false);
        }
        if (前回連番 == 整数28) {
            setKeyBy調査項目(前回洗顔Keys, 前回調査項目, false, false);
        }
    }

    private void 洗顔画面表示(List<RString> 洗顔Keys, List<RString> 前回洗顔Keys, RString 認定調査前回結果表示) {
        if (!洗顔Keys.isEmpty()) {
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
            div.getBtnKokou().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(口腔清潔Keys, 調査項目, false, false);
        }
        if (前回連番 == 整数27) {
            setKeyBy調査項目(前回口腔清潔Keys, 前回調査項目, false, false);
        }
    }

    private void 口腔清潔画面表示(List<RString> 口腔清潔Keys, List<RString> 前回口腔清潔Keys, RString 認定調査前回結果表示) {
        if (!口腔清潔Keys.isEmpty()) {
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
            div.getBtnHaiben().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(排便Keys, 調査項目, true, false);
        }
        if (前回連番 == 整数26) {
            setKeyBy調査項目(前回排便Keys, 前回調査項目, true, false);
        }
    }

    private void 排便画面表示(List<RString> 排便Keys, List<RString> 前回排便Keys, RString 認定調査前回結果表示) {
        if (!排便Keys.isEmpty()) {
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
            div.getBtnHainyo().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(排尿Keys, 調査項目, true, false);
        }
        if (前回連番 == 整数25) {
            setKeyBy調査項目(前回排尿Keys, 前回調査項目, true, false);
        }
    }

    private void 排尿画面表示(List<RString> 排尿Keys, List<RString> 前回排尿Keys, RString 認定調査前回結果表示) {
        if (!排尿Keys.isEmpty()) {
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
            div.getBtnShokuji().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(食事摂取Keys, 調査項目, true, false);
        }
        if (前回連番 == 整数24) {
            setKeyBy調査項目(前回食事摂取Keys, 前回調査項目, true, false);
        }
    }

    private void 食事摂取画面表示(List<RString> 食事摂取Keys, List<RString> 前回食事摂取Keys, RString 認定調査前回結果表示) {
        if (!食事摂取Keys.isEmpty()) {
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
            div.getBtnEnka().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(えん下Keys, 調査項目, false, false);
        }
        if (前回連番 == 整数23) {
            setKeyBy調査項目(前回えん下Keys, 前回調査項目, false, false);
        }
    }

    private void えん下画面表示(List<RString> えん下Keys, List<RString> 前回えん下Keys, RString 認定調査前回結果表示) {
        if (!えん下Keys.isEmpty()) {
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
            div.getBtnIdou().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(移動Keys, 調査項目, true, false);
        }
        if (前回連番 == 整数22) {
            setKeyBy調査項目(前回移動Keys, 前回調査項目, true, false);
        }
    }

    private void 移動画面表示(List<RString> 移動Keys, List<RString> 前回移動Keys, RString 認定調査前回結果表示) {
        if (!移動Keys.isEmpty()) {
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
            div.getBtnIjyo().setDisabled(!認定調査基本情報.is特記事項有無());
            setKeyBy調査項目(移乗Keys, 調査項目, true, false);
        }
        if (前回連番 == 整数21) {
            setKeyBy調査項目(前回移乗Keys, 前回調査項目, true, false);
        }
    }

    private void 移乗画面表示(List<RString> 移乗Keys, List<RString> 前回移乗Keys, RString 認定調査前回結果表示) {
        if (!移乗Keys.isEmpty()) {
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
        第二群生活機能Confirm(認定調査基本情報リスト);
        return 認定調査基本情報リスト;
    }

    private void 第二群生活機能Confirm(ArrayList<KihonChosaInput> 認定調査基本情報リスト) {
        RString 移乗Keys = div.getRadIjyo().getSelectedKey();
        RString 移動Keys = div.getRadIdou().getSelectedKey();
        RString えん下Keys = div.getRadEnka().getSelectedKey();
        RString 食事摂取Keys = div.getRadShokuji().getSelectedKey();
        RString 排尿Keys = div.getRadHainyo().getSelectedKey();
        RString 排便Keys = div.getRadHaiben().getSelectedKey();
        RString 口腔清潔Keys = div.getRadKokou().getSelectedKey();
        RString 洗顔Keys = div.getRadSengan().getSelectedKey();
        RString 整髪Keys = div.getRadSeihatsu().getSelectedKey();
        RString 上衣の着脱Keys = div.getRadUwagi().getSelectedKey();
        RString ズボン等の着脱Keys = div.getRadZubon().getSelectedKey();
        RString 外出頻度Keys = div.getRadHindo().getSelectedKey();
        単項Confirm(認定調査基本情報リスト, 整数21, 移乗Keys);
        単項Confirm(認定調査基本情報リスト, 整数22, 移動Keys);
        単項Confirm(認定調査基本情報リスト, 整数23, えん下Keys);
        単項Confirm(認定調査基本情報リスト, 整数24, 食事摂取Keys);
        単項Confirm(認定調査基本情報リスト, 整数25, 排尿Keys);
        単項Confirm(認定調査基本情報リスト, 整数26, 排便Keys);
        単項Confirm(認定調査基本情報リスト, 整数27, 口腔清潔Keys);
        単項Confirm(認定調査基本情報リスト, 整数28, 洗顔Keys);
        単項Confirm(認定調査基本情報リスト, 整数29, 整髪Keys);
        単項Confirm(認定調査基本情報リスト, 整数30, 上衣の着脱Keys);
        単項Confirm(認定調査基本情報リスト, 整数31, ズボン等の着脱Keys);
        単項Confirm(認定調査基本情報リスト, 整数32, 外出頻度Keys);
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

}
