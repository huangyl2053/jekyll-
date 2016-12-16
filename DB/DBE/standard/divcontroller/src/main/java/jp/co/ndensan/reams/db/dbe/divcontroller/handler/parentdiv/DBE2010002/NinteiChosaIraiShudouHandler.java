/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2010002;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairaishudou.NinnteiChousairaiShudouBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.ninteishinseijoho.NinteiShinseiJoho2;
import jp.co.ndensan.reams.db.dbe.business.report.chosairairirekiichiran.ChosairairirekiIchiranBusiness;
import jp.co.ndensan.reams.db.dbe.definition.core.chosa.ChohyoAtesakiKeisho;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010002.NinteiChosaIraiShudouDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosahyogaikyotokki.GaikyotokkiA4Business;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosahyotokkijiko.ChosahyoTokkijikoBusiness;
import jp.co.ndensan.reams.db.dbz.business.report.chosairaisho.ChosaIraishoHeadItem;
import jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyogaikyochosa.ChosahyoGaikyochosaItem;
import jp.co.ndensan.reams.db.dbz.business.report.saichekkuhyo.SaiChekkuhyoItem;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.RensakusakiTsuzukigara;
import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 認定調査依頼(手動)のハンドラークラスです。
 *
 * @reamsid_L DBE-1590-010 sunhaidi
 */
public class NinteiChosaIraiShudouHandler {

    private static final RString 未選択 = new RString("0");
    private static final RString 選択 = new RString("1");
    private static final RString 元号_明治 = new RString("明治");
    private static final RString 元号_大正 = new RString("大正");
    private static final RString 元号_昭和 = new RString("昭和");
    private static final RString 記号 = new RString("✔");
    private static final RString HOUSI = new RString("*");
    private static final RString 文字列0 = new RString("0");
    private static final RString 文字列1 = new RString("1");
    private static final RString 文字列2 = new RString("2");
    private static final RString 文字列3 = new RString("3");
    private static final RString 文字列4 = new RString("4");
    private static final RString 文字列5 = new RString("5");
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private static final int INDEX_9 = 9;
    private static final int INDEX_10 = 10;
    private static final int INDEX_11 = 11;
    private static final RString YOKAIGOJOTAIKUBUN01 = new RString("01");
    private static final RString YOKAIGOJOTAIKUBUN12 = new RString("12");
    private static final RString YOKAIGOJOTAIKUBUN13 = new RString("13");
    private static final RString YOKAIGOJOTAIKUBUN21 = new RString("21");
    private static final RString YOKAIGOJOTAIKUBUN22 = new RString("22");
    private static final RString YOKAIGOJOTAIKUBUN23 = new RString("23");
    private static final RString YOKAIGOJOTAIKUBUN24 = new RString("24");
    private static final RString YOKAIGOJOTAIKUBUN25 = new RString("25");
    private static final RString IFSHIKIBETSUCODE99A = new RString("99A");
    private static final RString IFSHIKIBETSUCODE02A = new RString("02A");
    private static final RString IFSHIKIBETSUCODE06A = new RString("06A");
    private static final RString IFSHIKIBETSUCODE09A = new RString("09A");
    private final NinteiChosaIraiShudouDiv div;
    private static final RString DDL_KEY0 = new RString("key0");
    private static final RString DDL_KEY1 = new RString("key1");
    private static final RString DDL_KEY2 = new RString("key2");
    private static final RString デザインシートOCR = new RString("1");
    private static final RString 白紙カラープリンター = new RString("2");

    /**
     * コンストラクタです。
     *
     * @param div 認定調査依頼Div
     */
    public NinteiChosaIraiShudouHandler(NinteiChosaIraiShudouDiv div) {
        this.div = div;
    }

    /**
     * 認定調査依頼(手動)の初期化処理です。
     *
     * @param 認定調査依頼List 認定調査依頼List
     */
    public void onLoad(List<NinnteiChousairaiShudouBusiness> 認定調査依頼List) {
        if (!認定調査依頼List.isEmpty()) {
            NinnteiChousairaiShudouBusiness 認定調査依頼 = 認定調査依頼List.get(0);
            div.getNinteichosaIraiByHand().getCcdItakusakiAndChosainInput().initialize(new RString("SimpleInputMode"),
                    認定調査依頼.get認定調査委託先コード(), 認定調査依頼.get事業者名称(),
                    認定調査依頼.get認定調査員コード(), 認定調査依頼.get調査員氏名());
            div.getNinteichosaIraiByHand().getCcdItakusakiAndChosainInput().setHdnShichosonCode(認定調査依頼.get市町村コード());
            div.getNinteichosaIraiByHand().getCcdItakusakiAndChosainInput().setHdnShinseishoKanriNo(認定調査依頼.get申請書管理番号());
            div.getCcdNinteiShinseishaKihonInfo().initialize(new ShinseishoKanriNo(認定調査依頼.get申請書管理番号()));
            if (!RString.isNullOrEmpty(認定調査依頼.get認定調査依頼履歴番号())) {
                div.getNinteichosaIraiByHand().getDdlIraiKubun().setDisabled(true);
            } else {
                div.getNinteichosaIraiByHand().getDdlIraiKubun().setDisabled(false);
            }
            RString 認定調査依頼年月日 = 認定調査依頼.get認定調査依頼年月日();
            if (!RString.isNullOrEmpty(認定調査依頼年月日)) {
                div.getNinteichosaIraiByHand().getTxtChosaIraiD().setValue(new RDate(認定調査依頼年月日.toString()));
            }
            div.getTxtHokkoymd().setValue(RDate.getNowDate());
            div.getTxtKigenymd().setValue(RDate.getNowDate());
            setCheckBoxValue(認定調査依頼.get市町村コード());
        }
    }

    private void setCheckBoxValue(RString 市町村コード) {

        RString 用紙タイプ = getConfigValue(ConfigNameDBE.認定調査票_概況調査_用紙タイプ,市町村コード);
        
        RString 認定調査依頼書 = 未選択;
        RString 認定調査票 = 未選択;
        RString 認定調査票_特記事項 = 未選択;
        RString 認定調査票OCR = 未選択;
        RString 認定調査票OCR_特記事項 = 未選択;
        RString 認定調査票_特記事項_項目有り = 未選択;
        RString 認定調査票_特記事項_項目無し = 未選択;
        RString 認定調査票_特記事項_フリー様式 = 未選択;
        RString 認定調査票差異チェック票 = 未選択;
        RString 調査特記_概況特記 = 未選択;
        RString 認定調査依頼該当者履歴一覧 = 未選択;

        if(デザインシートOCR.equals(用紙タイプ)){
            認定調査票 = 選択;
            認定調査票_特記事項 = 選択;
        }
        if(白紙カラープリンター.equals(用紙タイプ)){
            認定調査票OCR = 選択;
            認定調査票OCR_特記事項 = 選択;
        }
    
        List<RString> selectedItemList = new ArrayList();
        if (選択.equals(認定調査依頼書)) {
            selectedItemList.add(DDL_KEY0);
        }
        div.getChkIrai().setSelectedItemsByKey(selectedItemList);
        
        selectedItemList = new ArrayList();
        if (選択.equals(認定調査票)) {
            selectedItemList.add(DDL_KEY0);
        }
        if (選択.equals(認定調査票_特記事項)) {
            selectedItemList.add(DDL_KEY1);
        }
        div.getChkNinteichosaDesign().setSelectedItemsByKey(selectedItemList);
        
        selectedItemList = new ArrayList();
        if (選択.equals(認定調査票OCR)) {
            selectedItemList.add(DDL_KEY0);
        }
        if (選択.equals(認定調査票OCR_特記事項)) {
            selectedItemList.add(DDL_KEY1);
        }
        div.getChkNinteichosaOcr().setSelectedItemsByKey(selectedItemList);
        
        selectedItemList = new ArrayList();
        if (選択.equals(認定調査票_特記事項_項目有り)) {
            selectedItemList.add(DDL_KEY0);
        }
        if (選択.equals(認定調査票_特記事項_項目無し)) {
            selectedItemList.add(DDL_KEY1);
        }
        if (選択.equals(認定調査票_特記事項_フリー様式)) {
            selectedItemList.add(DDL_KEY2);
        }
        div.getChkTokkiJko().setSelectedItemsByKey(selectedItemList);
        
        selectedItemList = new ArrayList();
        if (選択.equals(認定調査票差異チェック票)) {
            selectedItemList.add(DDL_KEY0);
        }
        if (選択.equals(調査特記_概況特記)) {
            selectedItemList.add(DDL_KEY1);
        }
        if (選択.equals(認定調査依頼該当者履歴一覧)) {
            selectedItemList.add(DDL_KEY2);
        }
        div.getChkSaiCheck().setSelectedItemsByKey(selectedItemList);
    }

    
    /**
     * 提出期限のonChange処理です。
     */
    public void onChange_radKigen() {
        RString key = div.getRadKigen().getSelectedKey();
        if (new RString("2").equals(key)) {
            div.getTxtKigenymd().setReadOnly(false);
            div.getTxtKigenymd().setValue(RDate.getNowDate());
        } else {
            div.getTxtKigenymd().clearValue();
            div.getTxtKigenymd().setReadOnly(true);
        }
    }

    /**
     * 認定調査票_特記事項印刷用パラメータを作成します。
     *
     * @param ninteiShinseiJoho NinteiShinseiJoho2
     * @return 認認定調査票_特記事項印刷用パラメータ
     */
    public GaikyotokkiA4Business create認定調査票_概況特記印刷用パラメータ(NinteiShinseiJoho2 ninteiShinseiJoho) {
        GaikyotokkiA4Business gaikyotokkiA4Business = new GaikyotokkiA4Business();
        List<RString> 保険者番号リスト = get被保険者番号(ninteiShinseiJoho.get証記載保険者番号());
        List<RString> 被保険者番号リスト = get被保険者番号(ninteiShinseiJoho.get被保険者番号());

        gaikyotokkiA4Business.setHokenshaNo1(保険者番号リスト.get(0));
        gaikyotokkiA4Business.setHokenshaNo2(保険者番号リスト.get(1));
        gaikyotokkiA4Business.setHokenshaNo3(保険者番号リスト.get(2));
        gaikyotokkiA4Business.setHokenshaNo4(保険者番号リスト.get(INDEX_3));
        gaikyotokkiA4Business.setHokenshaNo5(保険者番号リスト.get(INDEX_4));
        gaikyotokkiA4Business.setHokenshaNo6(保険者番号リスト.get(INDEX_5));
        if (ninteiShinseiJoho.get認定申請年月日() != null) {
            RString ninteiShinseiDay = ninteiShinseiJoho.get認定申請年月日().wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.ICHI_NEN)
                    .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
            gaikyotokkiA4Business.setShinseiYY1(ninteiShinseiDay.substring(1, 2));
            gaikyotokkiA4Business.setShinseiYY2(ninteiShinseiDay.substring(2, INDEX_3));
            gaikyotokkiA4Business.setShinseiMM1(ninteiShinseiDay.substring(INDEX_4, INDEX_5));
            gaikyotokkiA4Business.setShinseiMM2(ninteiShinseiDay.substring(INDEX_5, INDEX_6));
            gaikyotokkiA4Business.setShinseiDD1(ninteiShinseiDay.substring(INDEX_7, INDEX_8));
            gaikyotokkiA4Business.setShinseiDD2(ninteiShinseiDay.substring(INDEX_8));
        }
        gaikyotokkiA4Business.setHihokenshaNo1(被保険者番号リスト.get(0));
        gaikyotokkiA4Business.setHihokenshaNo2(被保険者番号リスト.get(1));
        gaikyotokkiA4Business.setHihokenshaNo3(被保険者番号リスト.get(2));
        gaikyotokkiA4Business.setHihokenshaNo4(被保険者番号リスト.get(INDEX_3));
        gaikyotokkiA4Business.setHihokenshaNo5(被保険者番号リスト.get(INDEX_4));
        gaikyotokkiA4Business.setHihokenshaNo6(被保険者番号リスト.get(INDEX_5));
        gaikyotokkiA4Business.setHihokenshaNo7(被保険者番号リスト.get(INDEX_6));
        gaikyotokkiA4Business.setHihokenshaNo8(被保険者番号リスト.get(INDEX_7));
        gaikyotokkiA4Business.setHihokenshaNo9(被保険者番号リスト.get(INDEX_8));
        gaikyotokkiA4Business.setHihokenshaNo10(被保険者番号リスト.get(INDEX_9));
        if (ninteiShinseiJoho.get被保険者氏名() != null) {
            gaikyotokkiA4Business.setShinseishaName(ninteiShinseiJoho.get被保険者氏名().value());
        }
        return gaikyotokkiA4Business;
    }

    /**
     * 認定調査依頼該当者履歴一覧印刷用パラメータを作成します。
     *
     * @param businessList List<NinnteiChousairaiShudouBusiness>
     * @return 認定調査依頼該当者履歴一覧印刷用パラメータ
     */
    public List<ChosairairirekiIchiranBusiness> create調査依頼該当者履歴一覧印刷用パラメータ(List<NinnteiChousairaiShudouBusiness> businessList) {
        List<ChosairairirekiIchiranBusiness> 調査依頼該当者履歴一覧 = new ArrayList<>();

        for (NinnteiChousairaiShudouBusiness business : businessList) {
            RString 認定調査依頼年月日 = RString.EMPTY;
            if (!RString.isNullOrEmpty(business.get認定調査依頼年月日())) {
                認定調査依頼年月日 = new RDate(business.get認定調査依頼年月日().toString()).wareki().toDateString();
            }
            RString 認定申請区分_申請時 = RString.EMPTY;
            if (!RString.isNullOrEmpty(business.get認定申請区分_申請時_コード())) {
                認定申請区分_申請時 = NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分_申請時_コード()).get略称();
            }

            調査依頼該当者履歴一覧.add(new ChosairairirekiIchiranBusiness(business.get直近区分(),
                    business.get被保険者番号(),
                    business.get被保険者氏名(),
                    business.get被保険者氏名カナ(),
                    business.get住所(),
                    business.get事業者名称(),
                    business.get調査員氏名(),
                    認定調査依頼年月日,
                    認定申請区分_申請時));
        }

        return 調査依頼該当者履歴一覧;
    }

    /**
     * 認定調査依頼書印刷用パラメータを作成します。
     *
     * @param business NinnteiChousairaiShudouBusiness
     * @return 認定調査依頼書印刷用パラメータ
     */
    public List<ChosaIraishoHeadItem> create認定調査依頼書印刷用パラメータ(NinnteiChousairaiShudouBusiness business) {

        List<ChosaIraishoHeadItem> chosaIraishoHeadItemList = new ArrayList<>();
        RString タイトル = DbBusinessConfig.get(ConfigNameDBE.認定調査依頼書, RDate.getNowDate(), SubGyomuCode.DBE認定支援);

        List<RString> 被保険者番号リスト = get被保険者番号(business.get被保険者番号());
        RString 文書番号 = ReportUtil.get文書番号(SubGyomuCode.DBE認定支援, ReportIdDBZ.DBE220001.getReportId(), FlexibleDate.getNowDate());
        RString customerBarCode = RString.EMPTY;
        if (!RString.isNullOrEmpty(business.get調査委託先郵便番号()) && !RString.isNullOrEmpty(business.get調査委託先住所())) {
            customerBarCode = ReportUtil.getCustomerBarCode(business.get調査委託先郵便番号(), business.get調査委託先住所());
        }
        Map<Integer, RString> 通知文
                = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, ReportIdDBZ.DBE220001.getReportId(), KamokuCode.EMPTY, 1);

        RString 誕生日明治 = HOUSI;
        RString 誕生日大正 = HOUSI;
        RString 誕生日昭和 = HOUSI;
        FlexibleDate seinengappiYMD = new FlexibleDate(business.get生年月日());
        RString era = seinengappiYMD.wareki().eraType(EraType.KANJI).getEra();
        if (元号_明治.equals(era)) {
            誕生日明治 = RString.EMPTY;
        } else if (元号_大正.equals(era)) {
            誕生日大正 = RString.EMPTY;
        } else if (元号_昭和.equals(era)) {
            誕生日昭和 = RString.EMPTY;
        }
        RString seibetsu = business.get性別();
        RString 性別男 = RString.EMPTY;
        RString 性別女 = RString.EMPTY;

        if (Seibetsu.男.getコード().equals(seibetsu)) {
            性別女 = HOUSI;
        } else {
            性別男 = HOUSI;
        }
        RString 認定申請年月日 = RString.EMPTY;
        if (!RString.isNullOrEmpty(business.get認定申請年月日())) {
            認定申請年月日 = new FlexibleDate(business.get認定申請年月日()).wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        ChosaIraishoHeadItem item = new ChosaIraishoHeadItem(
                div.getTxtHokkoymd().getValue().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                文書番号,
                RString.isNullOrEmpty(business.get調査委託先郵便番号()) ? RString.EMPTY : new YubinNo(business.get調査委託先郵便番号()).getEditedYubinNo(),
                business.get調査委託先住所(),
                business.get事業者名称(),
                business.get調査員氏名(),
                get名称付与(),
                customerBarCode,
                business.get被保険者番号(),
                タイトル,
                通知文.get(1),
                被保険者番号リスト.get(0),
                被保険者番号リスト.get(1),
                被保険者番号リスト.get(2),
                被保険者番号リスト.get(INDEX_3),
                被保険者番号リスト.get(INDEX_4),
                被保険者番号リスト.get(INDEX_5),
                被保険者番号リスト.get(INDEX_6),
                被保険者番号リスト.get(INDEX_7),
                被保険者番号リスト.get(INDEX_8),
                被保険者番号リスト.get(INDEX_9),
                business.get被保険者氏名カナ(),
                誕生日明治,
                誕生日大正,
                誕生日昭和,
                business.get生年月日(),
                business.get被保険者氏名(),
                性別男,
                性別女,
                RString.isNullOrEmpty(business.get郵便番号()) ? RString.EMPTY : new YubinNo(business.get郵便番号()).getEditedYubinNo(),
                business.get住所(),
                business.get電話番号(),
                RString.isNullOrEmpty(business.get訪問調査先郵便番号()) ? RString.EMPTY : new YubinNo(business.get訪問調査先郵便番号()).getEditedYubinNo(),
                business.get訪問調査先住所(),
                business.get訪問調査先名称(),
                business.get訪問調査先電話番号(),
                認定申請年月日,
                set認定調査提出期限(business),
                通知文.get(2)
        );
        chosaIraishoHeadItemList.add(item);
        return chosaIraishoHeadItemList;
    }

    /**
     * 認定調査票_概況調査_基本調査の印刷用パラメータを作成します。
     *
     * @param business 印刷用パラメータ
     * @return 認定調査票_概況調査パラメータ
     */
    public List<ChosahyoGaikyochosaItem> create認定調査票_概況調査_基本調査パラメータ(NinnteiChousairaiShudouBusiness business) {
        List<ChosahyoGaikyochosaItem> itemList = new ArrayList<>();
        RString ninteiShinseiDay = new FlexibleDate(business.get認定申請年月日()).wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.ICHI_NEN)
                .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        List<RString> 保険者番号リスト = get被保険者番号(business.get保険者番号());
        List<RString> 被保険者番号リスト = get被保険者番号(business.get被保険者番号());
        List<RString> 認定調査員コードリスト = get認定調査員コード(business.get認定調査員コード());
        List<RString> 認定調査委託先コードリスト = get認定調査委託先コード(business.get認定調査委託先コード());
        RString 生年月日 = business.get生年月日();
        RString 年号 = new FlexibleDate(生年月日).wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).fillType(FillType.BLANK).toDateString();
        RString 前回認定年月日 = RString.isNullOrEmpty(business.get前回認定年月日()) ? RString.EMPTY
                : new FlexibleDate(business.get前回認定年月日()).seireki().separator(Separator.NONE).fillType(FillType.BLANK).toDateString();
        RString 前回要介護状態区分コード = business.get前回要介護状態区分コード();
        RString 要支援 = RString.EMPTY;
        if (YOKAIGOJOTAIKUBUN12.equals(前回要介護状態区分コード)
                || YOKAIGOJOTAIKUBUN13.equals(前回要介護状態区分コード)) {
            要支援 = 記号;
        }
        ChosahyoGaikyochosaItem item = new ChosahyoGaikyochosaItem(
                保険者番号リスト.get(0),
                保険者番号リスト.get(1),
                保険者番号リスト.get(2),
                保険者番号リスト.get(INDEX_3),
                保険者番号リスト.get(INDEX_4),
                保険者番号リスト.get(INDEX_5),
                ninteiShinseiDay.substring(1, 2),
                ninteiShinseiDay.substring(2, INDEX_3),
                ninteiShinseiDay.substring(INDEX_4, INDEX_5),
                ninteiShinseiDay.substring(INDEX_5, INDEX_6),
                ninteiShinseiDay.substring(INDEX_7, INDEX_8),
                ninteiShinseiDay.substring(INDEX_8),
                被保険者番号リスト.get(0),
                被保険者番号リスト.get(1),
                被保険者番号リスト.get(2),
                被保険者番号リスト.get(INDEX_3),
                被保険者番号リスト.get(INDEX_4),
                被保険者番号リスト.get(INDEX_5),
                被保険者番号リスト.get(INDEX_6),
                被保険者番号リスト.get(INDEX_7),
                被保険者番号リスト.get(INDEX_8),
                被保険者番号リスト.get(INDEX_9),
                認定調査員コードリスト.get(0),
                認定調査員コードリスト.get(1),
                認定調査員コードリスト.get(2),
                認定調査員コードリスト.get(INDEX_3),
                認定調査員コードリスト.get(INDEX_4),
                認定調査員コードリスト.get(INDEX_5),
                認定調査員コードリスト.get(INDEX_6),
                認定調査員コードリスト.get(INDEX_7),
                business.get調査員氏名(),
                認定調査委託先コードリスト.get(0),
                認定調査委託先コードリスト.get(1),
                認定調査委託先コードリスト.get(2),
                認定調査委託先コードリスト.get(INDEX_3),
                認定調査委託先コードリスト.get(INDEX_4),
                認定調査委託先コードリスト.get(INDEX_5),
                認定調査委託先コードリスト.get(INDEX_6),
                認定調査委託先コードリスト.get(INDEX_7),
                認定調査委託先コードリスト.get(INDEX_8),
                認定調査委託先コードリスト.get(INDEX_9),
                認定調査委託先コードリスト.get(INDEX_10),
                認定調査委託先コードリスト.get(INDEX_11),
                business.get事業者名称(),
                business.get被保険者氏名カナ(),
                business.get被保険者氏名(),
                Seibetsu.男.getコード().equals(business.get性別()) ? 記号 : RString.EMPTY,
                Seibetsu.女.getコード().equals(business.get性別()) ? 記号 : RString.EMPTY,
                business.get住所(),
                RString.isNullOrEmpty(business.get郵便番号()) ? RString.EMPTY : new YubinNo(business.get郵便番号()).getEditedYubinNo(),
                business.get電話番号(),
                年号.startsWith(元号_明治) ? 記号 : RString.EMPTY,
                年号.startsWith(元号_大正) ? 記号 : RString.EMPTY,
                年号.startsWith(元号_昭和) ? 記号 : RString.EMPTY,
                年号.substring(2, INDEX_4),
                年号.substring(INDEX_5, INDEX_7),
                年号.substring(INDEX_8),
                business.get年齢(),
                business.get連絡先住所(),
                RString.isNullOrEmpty(business.get連絡先郵便番号()) ? RString.EMPTY : new YubinNo(business.get連絡先郵便番号()).getEditedYubinNo(),
                business.get連絡先電話番号(),
                business.get連絡先携帯番号(),
                business.get連絡先氏名(),
                !RString.isNullOrEmpty(business.get連絡先続柄()) ? RensakusakiTsuzukigara.toValue(business.get連絡先続柄()).get名称() : RString.EMPTY,
                RString.isNullOrEmpty(前回認定年月日) ? 記号 : RString.EMPTY,
                !RString.isNullOrEmpty(前回認定年月日) ? 記号 : RString.EMPTY,
                !RString.isNullOrEmpty(前回認定年月日) ? 前回認定年月日.substring(0, INDEX_4) : RString.EMPTY,
                !RString.isNullOrEmpty(前回認定年月日) ? 前回認定年月日.substring(INDEX_4, INDEX_6) : RString.EMPTY,
                !RString.isNullOrEmpty(前回認定年月日) ? 前回認定年月日.substring(INDEX_6, INDEX_8) : RString.EMPTY,
                YOKAIGOJOTAIKUBUN01.equals(前回要介護状態区分コード) ? 記号 : RString.EMPTY,
                要支援,
                get要支援詳細(前回要介護状態区分コード),
                get要介護(前回要介護状態区分コード),
                get要介護詳細(前回要介護状態区分コード),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
        itemList.add(item);
        item = createChosahyoKihonchosa(保険者番号リスト, ninteiShinseiDay, 被保険者番号リスト);
        itemList.add(item);
        return itemList;
    }

    private List<RString> get被保険者番号(RString 被保険者番号) {
        List<RString> 被保険者番号リスト = new ArrayList<>();
        for (int i = 0; i <= INDEX_9; i++) {
            被保険者番号リスト.add(RString.EMPTY);
        }

        if (0 < 被保険者番号.length()) {
            被保険者番号リスト.set(0, 被保険者番号.substring(0, 1));
        }
        if (1 < 被保険者番号.length()) {
            被保険者番号リスト.set(1, 被保険者番号.substring(1, 2));
        }
        if (2 < 被保険者番号.length()) {
            被保険者番号リスト.set(2, 被保険者番号.substring(2, INDEX_3));
        }
        if (INDEX_3 < 被保険者番号.length()) {
            被保険者番号リスト.set(INDEX_3, 被保険者番号.substring(INDEX_3, INDEX_4));
        }
        if (INDEX_4 < 被保険者番号.length()) {
            被保険者番号リスト.set(INDEX_4, 被保険者番号.substring(INDEX_4, INDEX_5));
        }
        if (INDEX_5 < 被保険者番号.length()) {
            被保険者番号リスト.set(INDEX_5, 被保険者番号.substring(INDEX_5, INDEX_6));
        }
        if (INDEX_6 < 被保険者番号.length()) {
            被保険者番号リスト.set(INDEX_6, 被保険者番号.substring(INDEX_6, INDEX_7));
        }
        if (INDEX_7 < 被保険者番号.length()) {
            被保険者番号リスト.set(INDEX_7, 被保険者番号.substring(INDEX_7, INDEX_8));
        }
        if (INDEX_8 < 被保険者番号.length()) {
            被保険者番号リスト.set(INDEX_8, 被保険者番号.substring(INDEX_8, INDEX_9));
        }
        if (INDEX_9 < 被保険者番号.length()) {
            被保険者番号リスト.set(INDEX_9, 被保険者番号.substring(INDEX_9));
        }

        return 被保険者番号リスト;
    }

    private ChosahyoGaikyochosaItem createChosahyoKihonchosa(List<RString> 証記載保険者番号リスト, RString ninteiShinseiDay, List<RString> 被保険者番号リスト) {
        ChosahyoGaikyochosaItem item;
        item = new ChosahyoGaikyochosaItem(
                証記載保険者番号リスト.get(0),
                証記載保険者番号リスト.get(1),
                証記載保険者番号リスト.get(2),
                証記載保険者番号リスト.get(INDEX_3),
                証記載保険者番号リスト.get(INDEX_4),
                証記載保険者番号リスト.get(INDEX_5),
                ninteiShinseiDay.substring(1, 2),
                ninteiShinseiDay.substring(2, INDEX_3),
                ninteiShinseiDay.substring(INDEX_4, INDEX_5),
                ninteiShinseiDay.substring(INDEX_5, INDEX_6),
                ninteiShinseiDay.substring(INDEX_7, INDEX_8),
                ninteiShinseiDay.substring(INDEX_8),
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY,
                被保険者番号リスト.get(0),
                被保険者番号リスト.get(1),
                被保険者番号リスト.get(2),
                被保険者番号リスト.get(INDEX_3),
                被保険者番号リスト.get(INDEX_4),
                被保険者番号リスト.get(INDEX_5),
                被保険者番号リスト.get(INDEX_6),
                被保険者番号リスト.get(INDEX_7),
                被保険者番号リスト.get(INDEX_8),
                被保険者番号リスト.get(INDEX_9));
        return item;
    }

    /**
     * 認定調査票_特記事項印刷用パラメータを作成します。
     *
     * @param business NinnteiChousairaiShudouBusiness
     * @param 両面フラグ 両面フラグ
     * @return 認定調査票_特記事項パラメータ
     */
    public List<ChosahyoTokkijikoBusiness> create認定調査票_特記事項パラメータ(NinnteiChousairaiShudouBusiness business, boolean 両面フラグ) {
        List<ChosahyoTokkijikoBusiness> itemList = new ArrayList<>();
        if (business != null) {
            RString ninteiShinseiDay = new FlexibleDate(business.get認定申請年月日()).wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.ICHI_NEN)
                    .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
            List<RString> 証記載保険者番号リスト = get被保険者番号(business.get証記載保険者番号());
            List<RString> 被保険者番号リスト = get被保険者番号(business.get被保険者番号());
            ChosahyoTokkijikoBusiness item = new ChosahyoTokkijikoBusiness(
                    証記載保険者番号リスト.get(INDEX_3),
                    ninteiShinseiDay.substring(1, 2),
                    ninteiShinseiDay.substring(2, INDEX_3),
                    ninteiShinseiDay.substring(INDEX_4, INDEX_5),
                    ninteiShinseiDay.substring(INDEX_5, INDEX_6),
                    ninteiShinseiDay.substring(INDEX_7, INDEX_8),
                    ninteiShinseiDay.substring(INDEX_8),
                    証記載保険者番号リスト.get(0),
                    証記載保険者番号リスト.get(1),
                    証記載保険者番号リスト.get(2),
                    証記載保険者番号リスト.get(INDEX_4),
                    証記載保険者番号リスト.get(INDEX_5),
                    被保険者番号リスト.get(0),
                    被保険者番号リスト.get(2),
                    被保険者番号リスト.get(INDEX_3),
                    被保険者番号リスト.get(INDEX_4),
                    被保険者番号リスト.get(INDEX_5),
                    被保険者番号リスト.get(INDEX_6),
                    被保険者番号リスト.get(INDEX_7),
                    被保険者番号リスト.get(INDEX_8),
                    被保険者番号リスト.get(INDEX_9),
                    被保険者番号リスト.get(1),
                    business.get被保険者氏名() == null ? RString.EMPTY : business.get被保険者氏名());
            itemList.add(item);
            if (両面フラグ) {
                itemList.add(new ChosahyoTokkijikoBusiness(
                        RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                        RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                        RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                        RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY));
            }
        }

        return itemList;
    }

    /**
     * 認定調査票_特記事項_フリー様式印刷用パラメータを作成します。
     *
     * @param ninteiShinseiJoho NinteiShinseiJoho2
     * @return 認定調査票_特記事項_フリー様式パラメータ
     */
    public List<ChosahyoTokkijikoBusiness> create認定調査票_特記事項_フリー様式パラメータ(NinteiShinseiJoho2 ninteiShinseiJoho) {
        List<ChosahyoTokkijikoBusiness> itemList = new ArrayList<>();

        if (ninteiShinseiJoho != null) {
            RString ninteiShinseiDay = ninteiShinseiJoho.get認定申請年月日().wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.ICHI_NEN)
                    .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
            List<RString> 保険者番号リスト = get被保険者番号(ninteiShinseiJoho.get証記載保険者番号());
            List<RString> 被保険者番号リスト = get被保険者番号(ninteiShinseiJoho.get被保険者番号());
            ChosahyoTokkijikoBusiness item = new ChosahyoTokkijikoBusiness(
                    保険者番号リスト.get(INDEX_3),
                    ninteiShinseiDay.substring(1, 2),
                    ninteiShinseiDay.substring(2, INDEX_3),
                    ninteiShinseiDay.substring(INDEX_4, INDEX_5),
                    ninteiShinseiDay.substring(INDEX_5, INDEX_6),
                    ninteiShinseiDay.substring(INDEX_7, INDEX_8),
                    ninteiShinseiDay.substring(INDEX_8),
                    保険者番号リスト.get(0),
                    保険者番号リスト.get(1),
                    保険者番号リスト.get(2),
                    保険者番号リスト.get(INDEX_4),
                    保険者番号リスト.get(INDEX_5),
                    被保険者番号リスト.get(0),
                    被保険者番号リスト.get(2),
                    被保険者番号リスト.get(INDEX_3),
                    被保険者番号リスト.get(INDEX_4),
                    被保険者番号リスト.get(INDEX_5),
                    被保険者番号リスト.get(INDEX_6),
                    被保険者番号リスト.get(INDEX_7),
                    被保険者番号リスト.get(INDEX_8),
                    被保険者番号リスト.get(INDEX_9),
                    被保険者番号リスト.get(1),
                    ninteiShinseiJoho.get被保険者氏名() == null ? RString.EMPTY : ninteiShinseiJoho.get被保険者氏名().value());
            itemList.add(item);
        }
        return itemList;
    }

    /**
     * 概況特記パラメータを作成します。
     *
     * @param ninteiShinseiJoho 認定申請情報
     * @return 概況特記パラメータ
     */
    public List<GaikyotokkiA4Business> create概況特記_パラメータ(NinteiShinseiJoho2 ninteiShinseiJoho) {
        List<GaikyotokkiA4Business> itemList = new ArrayList<>();
        if (ninteiShinseiJoho != null) {
            RString ninteiShinseiDay = ninteiShinseiJoho.get認定申請年月日().wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.ICHI_NEN)
                    .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
            List<RString> 保険者番号リスト = get被保険者番号(ninteiShinseiJoho.get証記載保険者番号());
            List<RString> 被保険者番号リスト = get被保険者番号(ninteiShinseiJoho.get被保険者番号());
            GaikyotokkiA4Business item = new GaikyotokkiA4Business();

            item.setShinseiYY1(ninteiShinseiDay.substring(1, 2));
            item.setShinseiYY2(ninteiShinseiDay.substring(2, INDEX_3));
            item.setShinseiMM1(ninteiShinseiDay.substring(INDEX_4, INDEX_5));
            item.setShinseiMM2(ninteiShinseiDay.substring(INDEX_5, INDEX_6));
            item.setShinseiDD1(ninteiShinseiDay.substring(INDEX_7, INDEX_8));
            item.setShinseiDD2(ninteiShinseiDay.substring(INDEX_8));
            item.setHokenshaNo1(保険者番号リスト.get(0));
            item.setHokenshaNo2(保険者番号リスト.get(1));
            item.setHokenshaNo3(保険者番号リスト.get(2));
            item.setHokenshaNo4(保険者番号リスト.get(INDEX_3));
            item.setHokenshaNo5(保険者番号リスト.get(INDEX_4));
            item.setHokenshaNo6(保険者番号リスト.get(INDEX_5));
            item.setHihokenshaNo1(被保険者番号リスト.get(0));
            item.setHihokenshaNo2(被保険者番号リスト.get(1));
            item.setHihokenshaNo3(被保険者番号リスト.get(2));
            item.setHihokenshaNo4(被保険者番号リスト.get(INDEX_3));
            item.setHihokenshaNo5(被保険者番号リスト.get(INDEX_4));
            item.setHihokenshaNo6(被保険者番号リスト.get(INDEX_5));
            item.setHihokenshaNo7(被保険者番号リスト.get(INDEX_6));
            item.setHihokenshaNo8(被保険者番号リスト.get(INDEX_7));
            item.setHihokenshaNo9(被保険者番号リスト.get(INDEX_8));
            item.setHihokenshaNo10(被保険者番号リスト.get(INDEX_9));
            item.setShinseishaName(ninteiShinseiJoho.get被保険者氏名().value());
            itemList.add(item);
        }
        return itemList;
    }

    /**
     * 要介護認定調査票差異チェック票印刷用パラメータを作成します。
     *
     * @param businessList List<NinnteiChousairaiShudouBusiness>
     * @return 要介護認定調査票差異チェック票パラメータ
     */
    public List<SaiChekkuhyoItem> create調査票差異チェック票_DBE292004パラメータ(List<NinnteiChousairaiShudouBusiness> businessList) {
        List<SaiChekkuhyoItem> itemList = new ArrayList<>();
        Map<RString, RString> 前回連番Map = new HashMap();
        for (NinnteiChousairaiShudouBusiness business : businessList) {
            前回連番Map.put(business.get連番(), business.get調査項目());
        }
        if (!businessList.isEmpty()) {
            NinnteiChousairaiShudouBusiness business = businessList.get(0);
            itemList.add(new SaiChekkuhyoItem(
                    get判定結果(business.get厚労省IF識別コード(), business.get要介護認定一次判定結果コード()),
                    business.get被保険者番号(),
                    business.get被保険者氏名(),
                    business.get年齢(),
                    get判定結果(business.get厚労省IF識別コード(), business.get二次判定要介護状態区分コード()),
                    business.get二次判定年月日(),
                    business.get生年月日(),
                    前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_左上肢.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_右上肢.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_左下肢.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_右下肢.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_その他.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_肩関節.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_股関節.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_膝関節.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_その他.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.寝返り.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.起き上がり.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.座位保持.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.両足での立位.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.歩行.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.立ち上がり.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.片足での立位.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.洗身.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.つめ切り.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.視力.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.聴力.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.移乗.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.移動.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.えん下.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.食事摂取.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.排尿.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.排便.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.口腔清潔.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.洗顔.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.整髪.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.上衣の着脱.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.ズボン等の着脱.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.外出頻度.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.意思の伝達.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.毎日の日課を理解.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.生年月日をいう.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.短期記憶.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.自分の名前をいう.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.今の季節を理解.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.場所の理解.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.常時の徘徊.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.外出して戻れない.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.被害的.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.作話.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.感情が不安定.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.昼夜逆転.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.同じ話をする.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.大声を出す.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.介護に抵抗.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.落ち着きなし.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.一人で出たがる.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.収集癖.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.物や衣類を壊す.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.ひどい物忘れ.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.独り言_独り笑い.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.自分勝手に行動する.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.話がまとまらない.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.薬の内服.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.金銭の管理.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.日常の意思決定.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.集団への不適応.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.買い物.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.簡単な調理.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.点滴の管理.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.中心静脈栄養.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.透析.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.ストーマの処置.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.酸素療法.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.レスピレーター.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.気管切開の処置.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.疼痛の看護.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.経管栄養.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.モニター測定.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.じょくそうの処置.getコード()),
                    前回連番Map.get(NinteichosaKomokuMapping09B.カテーテル.getコード()),
                    NinchishoNichijoSeikatsuJiritsudoCode.toValue(business.get認知症高齢者自立度コード()).get名称(),
                    ShogaiNichijoSeikatsuJiritsudoCode.toValue(business.get障害高齢者自立度コード()).get名称()
            ));
        }
        return itemList;
    }

    private RString get判定結果(RString 厚労省IF識別コード, RString 判定結果コード) {
        RString 判定結果 = RString.EMPTY;
        if (IFSHIKIBETSUCODE99A.equals(厚労省IF識別コード)) {
            判定結果 = IchijiHanteiKekkaCode99.toValue(判定結果コード).get名称();
        } else if (IFSHIKIBETSUCODE09A.equals(厚労省IF識別コード)) {
            判定結果 = IchijiHanteiKekkaCode09.toValue(判定結果コード).get名称();
        } else if (IFSHIKIBETSUCODE06A.equals(厚労省IF識別コード)) {
            判定結果 = IchijiHanteiKekkaCode06.toValue(判定結果コード).get名称();
        } else if (IFSHIKIBETSUCODE02A.equals(厚労省IF識別コード)) {
            判定結果 = IchijiHanteiKekkaCode02.toValue(判定結果コード).get名称();
        }
        return 判定結果;
    }

    private List<RString> get認定調査員コード(RString 認定調査員コード) {
        List<RString> 認定調査員コードリスト = new ArrayList<>();
        for (int i = 0; i <= INDEX_7; i++) {
            認定調査員コードリスト.add(RString.EMPTY);
        }

        if (0 < 認定調査員コード.length()) {
            認定調査員コードリスト.set(0, 認定調査員コード.substring(0, 1));
        }
        if (1 < 認定調査員コード.length()) {
            認定調査員コードリスト.set(1, 認定調査員コード.substring(1, 2));
        }
        if (2 < 認定調査員コード.length()) {
            認定調査員コードリスト.set(2, 認定調査員コード.substring(2, INDEX_3));
        }
        if (INDEX_3 < 認定調査員コード.length()) {
            認定調査員コードリスト.set(INDEX_3, 認定調査員コード.substring(INDEX_3, INDEX_4));
        }
        if (INDEX_4 < 認定調査員コード.length()) {
            認定調査員コードリスト.set(INDEX_4, 認定調査員コード.substring(INDEX_4, INDEX_5));
        }
        if (INDEX_5 < 認定調査員コード.length()) {
            認定調査員コードリスト.set(INDEX_5, 認定調査員コード.substring(INDEX_5, INDEX_6));
        }
        if (INDEX_6 < 認定調査員コード.length()) {
            認定調査員コードリスト.set(INDEX_6, 認定調査員コード.substring(INDEX_6, INDEX_7));
        }
        if (INDEX_7 < 認定調査員コード.length()) {
            認定調査員コードリスト.set(INDEX_7, 認定調査員コード.substring(INDEX_7, INDEX_8));
        }

        return 認定調査員コードリスト;
    }

    private List<RString> get認定調査委託先コード(RString 認定調査委託先コード) {
        List<RString> 認定調査委託先コードリスト = new ArrayList<>();
        for (int i = 0; i <= INDEX_11; i++) {
            認定調査委託先コードリスト.add(RString.EMPTY);
        }

        if (0 < 認定調査委託先コード.length()) {
            認定調査委託先コードリスト.set(0, 認定調査委託先コード.substring(0, 1));
        }
        if (1 < 認定調査委託先コード.length()) {
            認定調査委託先コードリスト.set(1, 認定調査委託先コード.substring(1, 2));
        }
        if (2 < 認定調査委託先コード.length()) {
            認定調査委託先コードリスト.set(2, 認定調査委託先コード.substring(2, INDEX_3));
        }
        if (INDEX_3 < 認定調査委託先コード.length()) {
            認定調査委託先コードリスト.set(INDEX_3, 認定調査委託先コード.substring(INDEX_3, INDEX_4));
        }
        if (INDEX_4 < 認定調査委託先コード.length()) {
            認定調査委託先コードリスト.set(INDEX_4, 認定調査委託先コード.substring(INDEX_4, INDEX_5));
        }
        if (INDEX_5 < 認定調査委託先コード.length()) {
            認定調査委託先コードリスト.set(INDEX_5, 認定調査委託先コード.substring(INDEX_5, INDEX_6));
        }
        if (INDEX_6 < 認定調査委託先コード.length()) {
            認定調査委託先コードリスト.set(INDEX_6, 認定調査委託先コード.substring(INDEX_6, INDEX_7));
        }
        if (INDEX_7 < 認定調査委託先コード.length()) {
            認定調査委託先コードリスト.set(INDEX_7, 認定調査委託先コード.substring(INDEX_7, INDEX_8));
        }
        if (INDEX_8 < 認定調査委託先コード.length()) {
            認定調査委託先コードリスト.set(INDEX_8, 認定調査委託先コード.substring(INDEX_8, INDEX_9));
        }
        if (INDEX_9 < 認定調査委託先コード.length()) {
            認定調査委託先コードリスト.set(INDEX_9, 認定調査委託先コード.substring(INDEX_9, INDEX_10));
        }
        if (INDEX_10 < 認定調査委託先コード.length()) {
            認定調査委託先コードリスト.set(INDEX_10, 認定調査委託先コード.substring(INDEX_10, INDEX_11));
        }
        if (INDEX_11 < 認定調査委託先コード.length()) {
            認定調査委託先コードリスト.set(INDEX_11, 認定調査委託先コード.substring(INDEX_11));
        }

        return 認定調査委託先コードリスト;
    }

    private RString set認定調査提出期限(NinnteiChousairaiShudouBusiness business) {
        RString 認定調査期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.認定調査期限設定方法,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        RString 提出期限 = RString.EMPTY;
        RString key = div.getRadKigen().getSelectedKey();
        int 期限日数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.認定調査期限日数,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString());
        if (文字列1.equals(認定調査期限設定方法)) {
            if (文字列0.equals(key)) {
                提出期限 = !RString.isNullOrEmpty(business.get認定調査依頼年月日())
                        ? new RString(new FlexibleDate(business.get認定調査依頼年月日()).plusDay(期限日数).toString()) : RString.EMPTY;
            } else if (文字列1.equals(key)) {
                提出期限 = RString.EMPTY;
            } else if (文字列2.equals(key)) {
                RDate 共通日 = div.getTxtKigenymd().getValue();

                提出期限 = (共通日 != null ? new RString(共通日.plusDay(期限日数).toString()) : RString.EMPTY);
            }
        } else {
            提出期限 = !RString.isNullOrEmpty(business.get認定申請年月日())
                    ? new RString(new FlexibleDate(business.get認定申請年月日()).plusDay(期限日数).toString()) : RString.EMPTY;
        }
        return 提出期限;
    }

    private RString get名称付与() {
        RString key = DbBusinessConfig.get(ConfigNameDBE.認定調査依頼書_宛先敬称, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        RString meishoFuyo = RString.EMPTY;
        if (ChohyoAtesakiKeisho.なし.getコード().equals(key)) {
            meishoFuyo = RString.EMPTY;
        } else if (ChohyoAtesakiKeisho.様.getコード().equals(key)) {
            meishoFuyo = ChohyoAtesakiKeisho.様.get名称();
        } else if (ChohyoAtesakiKeisho.殿.getコード().equals(key)) {
            meishoFuyo = ChohyoAtesakiKeisho.殿.get名称();
        }
        return meishoFuyo;
    }

    private RString get要支援詳細(RString yokaigoJotaiKubun) {
        RString 要支援詳細 = RString.EMPTY;
        if (YOKAIGOJOTAIKUBUN12.equals(yokaigoJotaiKubun)) {
            要支援詳細 = 文字列1;
        } else if (YOKAIGOJOTAIKUBUN13.equals(yokaigoJotaiKubun)) {
            要支援詳細 = 文字列2;
        }
        return 要支援詳細;
    }

    private RString get要介護(RString yokaigoJotaiKubun) {
        RString 要介護 = RString.EMPTY;
        if (YOKAIGOJOTAIKUBUN21.equals(yokaigoJotaiKubun)
                || YOKAIGOJOTAIKUBUN22.equals(yokaigoJotaiKubun)
                || YOKAIGOJOTAIKUBUN23.equals(yokaigoJotaiKubun)
                || YOKAIGOJOTAIKUBUN24.equals(yokaigoJotaiKubun)
                || YOKAIGOJOTAIKUBUN25.equals(yokaigoJotaiKubun)) {
            要介護 = 記号;
        }
        return 要介護;
    }

    private RString get要介護詳細(RString yokaigoJotaiKubun) {
        RString 要介護詳細 = RString.EMPTY;
        if (YOKAIGOJOTAIKUBUN21.equals(yokaigoJotaiKubun)) {
            要介護詳細 = 文字列1;
        } else if (YOKAIGOJOTAIKUBUN22.equals(yokaigoJotaiKubun)) {
            要介護詳細 = 文字列2;
        } else if (YOKAIGOJOTAIKUBUN23.equals(yokaigoJotaiKubun)) {
            要介護詳細 = 文字列3;
        } else if (YOKAIGOJOTAIKUBUN24.equals(yokaigoJotaiKubun)) {
            要介護詳細 = 文字列4;
        } else if (YOKAIGOJOTAIKUBUN25.equals(yokaigoJotaiKubun)) {
            要介護詳細 = 文字列5;
        }
        return 要介護詳細;
    }
    private RString getConfigValue(ConfigNameDBE config,RString 市町村コード) {
        return DbBusinessConfig.get(config, RDate.getNowDate(), SubGyomuCode.DBE認定支援,市町村コード);
    }
}
