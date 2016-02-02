/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.dbu0050021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dba.definition.message.DbaErrorMessages;
import jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.dbu0050011.TaishokensakuJyouken;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050021.KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050021.YoshikiyonMeisaiDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.dbu0050011.TaishokensakuJyoukenHandler;
import jp.co.ndensan.reams.db.dbu.entity.insuranceinformation.InsuranceInformationEntity;
import jp.co.ndensan.reams.db.dbu.entity.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenJigyoHokokuNenpoEntity;
import jp.co.ndensan.reams.db.dbu.entity.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbu.entity.kaigohokentokubetukaikeikeirijyokyoregist.ShichosonEntity;
import jp.co.ndensan.reams.db.dbu.service.core.kaigohokentokubetukaikeikeirijyokyoregist.KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.TokeiTaishoKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.JigyoHokokuNenpoShoriName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 介護保険特別会計経理状況登録_様式４ハンドラクラスです。
 */
public class KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler {

    private final KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div;
    private static RString 内部処理モード;
    public static final RString 内部処理モード_修正追加 = new RString("修正追加");
    public static final RString 内部処理モード_修正 = new RString("修正");
    public static final RString 内部処理モード_削除 = new RString("削除");
    public static final RString 内部処理モード_追加 = new RString("追加");
    private static RString 画面表示;
    public static final RString 画面表示_完了 = new RString("完了");
    public static final RString 画面表示_修正 = new RString("修正");
    public static final RString 画面表示_削除 = new RString("削除");
    public static final RString 画面表示_追加 = new RString("追加");
    private final Decimal DECIMAL_0 = new Decimal("0");
    private final RString DOUBLE_ZEOR = new RString("00");
    private final RString ONE = new RString("1");
    private final RString TWO = new RString("2");
    private final RString 状態1 = new RString("状態1");
    private final RString 状態1_確定 = new RString("状態1");
    private final RString 状態2 = new RString("状態2");
    private final RString 状態3 = new RString("状態3");
    private final Code 表番号_09 = new Code("09");
    private final Code 集計番号_0100 = new Code("0100");
    private final Code 集計単位_1 = new Code("1");
    private final RString 保険料横縦番号 = new RString("1_1");
    private final RString 総務費横縦番号 = new RString("1_2");
    private final RString 認定負担金横縦番号 = new RString("2_1");
    private final RString 介護サービス等諸費横縦番号 = new RString("2_2");
    private final RString その他横縦番号 = new RString("3_1");
    private final RString 介護予防サービス等諸費横縦番号 = new RString("3_2");
    private final RString 使用料横縦番号 = new RString("4_1");
    private final RString 高額介護サービス等費横縦番号 = new RString("4_2");
    private final RString 手数料横縦番号 = new RString("5_1");
    private final RString 高額医療合算介護サービス等費横縦番号 = new RString("5_2");
    private final RString 介護給付費負担金横縦番号 = new RString("6_1");
    private final RString 特定入所者介護サービス等費横縦番号 = new RString("6_2");
    private final RString 調整交付金横縦番号 = new RString("7_1");
    private final RString 審査支払手数料横縦番号 = new RString("7_2");
    private final RString 地域支援事業交付金_介護予防事業横縦番号 = new RString("8_1");
    private final RString 市町村特別給付費横縦番号 = new RString("8_2");
    private final RString 地域支援事業交付金_包括的支援事業横縦番号 = new RString("9_1");
    private final RString その他_保険給付費横縦番号 = new RString("9_2");
    private final RString その他_国庫支出金横縦番号 = new RString("10_1");
    private final RString 介護予防事業費横縦番号 = new RString("10_2");
    private final RString 介護給付費交付金横縦番号 = new RString("11_1");
    private final RString 包括的支援事業_任意事業_地域支援事業横縦番号 = new RString("112");
    private final RString 地域支援事業支援交付金横縦番号 = new RString("12_1");
    private final RString 財政安定化基金拠出金横縦番号 = new RString("12_2");
    private final RString 都道府県負担金横縦番号 = new RString("13_1");
    private final RString 相互財政安定化事業負担金横縦番号 = new RString("13_2");
    private final RString 財政安定化基金支出金横縦番号 = new RString("14_1");
    private final RString 保健福祉事業費横縦番号 = new RString("14_2");
    private final RString 都道府県支出金_地域支援事業交付金横縦番号 = new RString("15_1");
    private final RString 基金積立金横縦番号 = new RString("15_2");
    private final RString 地域支援事業交付金_任意事業横縦番号 = new RString("16_1");
    private final RString 財政安定化基金償還金横縦番号 = new RString("16_2");
    private final RString その他_都道府県支出金横縦番号 = new RString("17_1");
    private final RString その他_公債費横縦番号 = new RString("17_2");
    private final RString 相互財政安定化事業交付金横縦番号 = new RString("18_1");
    private final RString 予備費横縦番号 = new RString("18_2");
    private final RString 財産収入横縦番号 = new RString("19_1");
    private final RString 介護サービス事業勘定繰出金横縦番号 = new RString("19_2");
    private final RString 寄附金横縦番号 = new RString("20_1");
    private final RString 他会計繰出金横縦番号 = new RString("20_2");
    private final RString 一般会計繰入金横縦番号 = new RString("21_1");
    private final RString その他_諸支出金横縦番号 = new RString("21_2");
    private final RString 総務費に係る一般会計繰入金横縦番号 = new RString("22_1");
    private final RString 介護給付費準備基金繰入金横縦番号 = new RString("23_1");
    private final RString 介護サービス事業勘定繰入金横縦番号 = new RString("24_1");
    private final RString 地域支援事業繰入金_介護予防事業横縦番号 = new RString("25_1");
    private final RString 地域支援事業繰入金_任意事業横縦番号 = new RString("26_1");
    private final RString その他_繰入金横縦番号 = new RString("27_1");
    private final RString 繰越金横縦番号 = new RString("28_1");
    private final RString 財政安定化基金貸付金横縦番号 = new RString("29_1");
    private final RString その他_市町村債横縦番号 = new RString("30_1");
    private final RString 諸収入横縦番号 = new RString("31_1");
    private final RString 合計１横縦番号 = new RString("32_1");
    private final RString 合計２横縦番号 = new RString("32_2");
    private final RString 歳入歳出差引残額横縦番号 = new RString("33_1");
    private final RString うち基金繰入額横縦番号 = new RString("34_1");
    private final RString 介護給付費準備基金保有額横縦番号 = new RString("35_1");
    private final TextBoxNum 保険料;
    private final TextBoxNum 総務費;
    private final TextBoxNum 認定負担金;
    private final TextBoxNum 介護サービス等諸費;
    private final TextBoxNum その他;
    private final TextBoxNum 介護予防サービス等諸費;
    private final TextBoxNum 使用料;
    private final TextBoxNum 高額介護サービス等費;
    private final TextBoxNum 手数料;
    private final TextBoxNum 高額医療合算介護サービス等費;
    private final TextBoxNum 介護給付費負担金;
    private final TextBoxNum 特定入所者介護サービス等費;
    private final TextBoxNum 調整交付金;
    private final TextBoxNum 審査支払手数料;
    private final TextBoxNum 地域支援事業交付金_介護予防事業;
    private final TextBoxNum 市町村特別給付費;
    private final TextBoxNum 地域支援事業交付金_包括的支援事業;
    private final TextBoxNum その他_保険給付費;
    private final TextBoxNum その他_国庫支出金;
    private final TextBoxNum 介護予防事業費;
    private final TextBoxNum 介護給付費交付金;
    private final TextBoxNum 包括的支援事業_任意事業_地域支援事業;
    private final TextBoxNum 地域支援事業支援交付金;
    private final TextBoxNum 財政安定化基金拠出金;
    private final TextBoxNum 都道府県負担金;
    private final TextBoxNum 相互財政安定化事業負担金;
    private final TextBoxNum 財政安定化基金支出金;
    private final TextBoxNum 保健福祉事業費;
    private final TextBoxNum 都道府県支出金_地域支援事業交付金;
    private final TextBoxNum 基金積立金;
    private final TextBoxNum 地域支援事業交付金_任意事業;
    private final TextBoxNum 財政安定化基金償還金;
    private final TextBoxNum その他_都道府県支出金;
    private final TextBoxNum その他_公債費;
    private final TextBoxNum 相互財政安定化事業交付金;
    private final TextBoxNum 予備費;
    private final TextBoxNum 財産収入;
    private final TextBoxNum 介護サービス事業勘定繰出金;
    private final TextBoxNum 寄附金;
    private final TextBoxNum 他会計繰出金;
    private final TextBoxNum 一般会計繰入金;
    private final TextBoxNum その他_諸支出金;
    private final TextBoxNum 総務費に係る一般会計繰入金;
    private final TextBoxNum 介護給付費準備基金繰入金;
    private final TextBoxNum 介護サービス事業勘定繰入金;
    private final TextBoxNum 地域支援事業繰入金_介護予防事業;
    private final TextBoxNum 地域支援事業繰入金_任意事業;
    private final TextBoxNum その他_繰入金;
    private final TextBoxNum 繰越金;
    private final TextBoxNum 財政安定化基金貸付金;
    private final TextBoxNum その他_市町村債;
    private final TextBoxNum 諸収入;
    private final TextBoxNum 合計１;
    private final TextBoxNum 合計２;
    private final TextBoxNum 歳入歳出差引残額;
    private final TextBoxNum うち基金繰入額;
    private final TextBoxNum 介護給付費準備基金保有額;

    /**
     * コンストラクタです。
     *
     * @param div 介護保険特別会計経理状況登録_様式４情報Div
     */
    public KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Handler(KaigoHokenTokubetuKaikeiKeiriJyokyoRegist1Div div) {
        this.div = div;
        YoshikiyonMeisaiDiv yoshikiyonMeisaiDiv = div.getHihokenshabango().getYoshikiyonMeisai();
        保険料 = yoshikiyonMeisaiDiv.getTxthokenryo();
        総務費 = yoshikiyonMeisaiDiv.getTxtsaishutsusomu();
        認定負担金 = yoshikiyonMeisaiDiv.getTxtnintei();
        介護サービス等諸費 = yoshikiyonMeisaiDiv.getTxtlsabisunadoshohi();
        その他 = yoshikiyonMeisaiDiv.getTxtfuntansonota();
        介護予防サービス等諸費 = yoshikiyonMeisaiDiv.getTxtyobonadoshohi();
        使用料 = yoshikiyonMeisaiDiv.getTxtshiyoo();
        高額介護サービス等費 = yoshikiyonMeisaiDiv.getTxtkogakukaigo();
        手数料 = yoshikiyonMeisaiDiv.getTxttesu();
        高額医療合算介護サービス等費 = yoshikiyonMeisaiDiv.getTxtlkogakuiryo();
        介護給付費負担金 = yoshikiyonMeisaiDiv.getTxtkyufu();
        特定入所者介護サービス等費 = yoshikiyonMeisaiDiv.getTxttokuteinyusho();
        調整交付金 = yoshikiyonMeisaiDiv.getTxtchosei();
        審査支払手数料 = yoshikiyonMeisaiDiv.getTxtshinsashiharai();
        地域支援事業交付金_介護予防事業 = yoshikiyonMeisaiDiv.getTxtkaigoyobo();
        市町村特別給付費 = yoshikiyonMeisaiDiv.getTxtshichosontokubetsukyufu();
        地域支援事業交付金_包括的支援事業 = yoshikiyonMeisaiDiv.getTxthokatsu();
        その他_保険給付費 = yoshikiyonMeisaiDiv.getTxtkyusonota();
        その他_国庫支出金 = yoshikiyonMeisaiDiv.getTxtkokkosonota();
        介護予防事業費 = yoshikiyonMeisaiDiv.getTxtchiikikaigoyobo();
        介護給付費交付金 = yoshikiyonMeisaiDiv.getTxtkyufukofukin();
        包括的支援事業_任意事業_地域支援事業 = yoshikiyonMeisaiDiv.getTxtchiikihokatsujigyo();
        地域支援事業支援交付金 = yoshikiyonMeisaiDiv.getTxtchiikishienkofukin();
        財政安定化基金拠出金 = yoshikiyonMeisaiDiv.getTxtzaisanantei();
        都道府県負担金 = yoshikiyonMeisaiDiv.getTxttodofukenfutankin();
        相互財政安定化事業負担金 = yoshikiyonMeisaiDiv.getTxtkokkozaisan();
        財政安定化基金支出金 = yoshikiyonMeisaiDiv.getTxtzaiseiantei();
        保健福祉事業費 = yoshikiyonMeisaiDiv.getTxthokenfukushi();
        都道府県支出金_地域支援事業交付金 = yoshikiyonMeisaiDiv.getTxtchiikishienyobo();
        基金積立金 = yoshikiyonMeisaiDiv.getTxtkikin();
        地域支援事業交付金_任意事業 = yoshikiyonMeisaiDiv.getTxtchiikishienhokatsu();
        財政安定化基金償還金 = yoshikiyonMeisaiDiv.getTxtv();
        その他_都道府県支出金 = yoshikiyonMeisaiDiv.getTxttodofukensonota();
        その他_公債費 = yoshikiyonMeisaiDiv.getTxtkosaikosaisonota();
        相互財政安定化事業交付金 = yoshikiyonMeisaiDiv.getTxtzaisanshunyu();
        予備費 = yoshikiyonMeisaiDiv.getTxtyobihi();
        財産収入 = yoshikiyonMeisaiDiv.getTxtzaisanshuny();
        介護サービス事業勘定繰出金 = yoshikiyonMeisaiDiv.getTxtkaigosabisukanjo();
        寄附金 = yoshikiyonMeisaiDiv.getTxtkifukin();
        他会計繰出金 = yoshikiyonMeisaiDiv.getTxttakaikei();
        一般会計繰入金 = yoshikiyonMeisaiDiv.getTxtippankaikei();
        その他_諸支出金 = yoshikiyonMeisaiDiv.getTxtshoshishutsusonota();
        総務費に係る一般会計繰入金 = yoshikiyonMeisaiDiv.getTxtsomuhi();
        介護給付費準備基金繰入金 = yoshikiyonMeisaiDiv.getTxtjumbikikin();
        介護サービス事業勘定繰入金 = yoshikiyonMeisaiDiv.getTxtchiikishienkaigoyobo();
        地域支援事業繰入金_介護予防事業 = yoshikiyonMeisaiDiv.getTxttiikikaigoyobo();
        地域支援事業繰入金_任意事業 = yoshikiyonMeisaiDiv.getTxtkurichiikishienhokatsu();
        その他_繰入金 = yoshikiyonMeisaiDiv.getTxtkurinyukinsonota();
        繰越金 = yoshikiyonMeisaiDiv.getTxtkurikoshikin();
        財政安定化基金貸付金 = yoshikiyonMeisaiDiv.getTxtsaizaiseiantei();
        その他_市町村債 = yoshikiyonMeisaiDiv.getTxtsaisonota();
        諸収入 = yoshikiyonMeisaiDiv.getTxtshoshunyu();
        合計１ = yoshikiyonMeisaiDiv.getTxtsainyugokei();
        合計２ = yoshikiyonMeisaiDiv.getTxtsaishutsugoukei();
        歳入歳出差引残額 = yoshikiyonMeisaiDiv.getTxtsainyushutsusa();
        うち基金繰入額 = yoshikiyonMeisaiDiv.getTxtuchikikinkurigaku();
        介護給付費準備基金保有額 = yoshikiyonMeisaiDiv.getTxtkaigokyufuhijunhoyu();
    }

    /**
     * 内部処理モードの取得処理です。
     *
     * @return 内部処理モード
     */
    public RString get内部処理モード() {
        return 内部処理モード;
    }

    /**
     * 画面表示の取得処理です。
     *
     * @return 画面表示
     */
    public RString get画面表示() {
        return 画面表示;
    }

    /**
     * 画面初期化処理です。
     */
    public void onload() {
        InsuranceInformationEntity insuranceInfEntity = get引き継ぎデータ();
        TextBoxFlexibleDate 報告年度Box = div.getHihokenshabango().getYoshikiyonMeisai().getTxthokokuYM();
        TextBoxFlexibleDate 集計年度Box = div.getHihokenshabango().getYoshikiyonMeisai().getTxtShukeiYM();
        if (TaishokensakuJyoukenHandler.DELETE.equals(insuranceInfEntity.get処理フラグ())
                || TaishokensakuJyoukenHandler.UPDATE.equals(insuranceInfEntity.get処理フラグ())) {
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager 介護保険特別会計経理状況登録Manager
                    = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();
            List<KaigoHokenJigyoHokokuNenpoEntity> 詳細データLst
                    = 介護保険特別会計経理状況登録Manager.getJigyoHokokuNenpoDetal(new FlexibleYear(insuranceInfEntity.get報告年().toString()),
                            new RString(insuranceInfEntity.get集計対象年().toString()), insuranceInfEntity.get統計対象区分(),
                            insuranceInfEntity.get市町村コード(), 集計番号_0100.getColumnValue());
            KaigoHokenJigyoHokokuNenpoEntity 詳細データ = 詳細データLst.get(0);
            if (詳細データ.get詳細データエリア().isEmpty()) {
                if (!(TaishokensakuJyoukenHandler.DELETE.equals(insuranceInfEntity.get処理フラグ()))) {
                    内部処理モード = 内部処理モード_修正追加;
                }
                報告年度Box.setValue(new FlexibleDate(詳細データ.get報告年().getYearValue(), 1, 1));
                報告年度Box.setReadOnly(true);
                TextBoxCode 保険者コードBox = div.getHihokenshabango().getYoshikiyonMeisai().getTxtHihokenshabango();
                保険者コードBox.setValue(insuranceInfEntity.get保険者コード().getColumnValue());
                保険者コードBox.setReadOnly(true);
                TextBox 保険者名称Box = div.getHihokenshabango().getYoshikiyonMeisai().getTxthihokenshamei();
                保険者名称Box.setValue(insuranceInfEntity.get市町村名称());
                保険者名称Box.setReadOnly(true);
            } else {
                報告年度Box.setValue(new FlexibleDate(insuranceInfEntity.get報告年().getYearValue(), 1, 1));
                集計年度Box.setValue(new FlexibleDate(insuranceInfEntity.get集計対象年().getYearValue(), 1, 1));
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtHihokenshabango()
                        .setValue(insuranceInfEntity.get保険者コード().getColumnValue());
                div.getHihokenshabango().getYoshikiyonMeisai().getTxthihokenshamei().setValue(insuranceInfEntity.get市町村名称());
                報告年度Box.setReadOnly(true);
                集計年度Box.setReadOnly(true);
                div.getHihokenshabango().getYoshikiyonMeisai().getTxtHihokenshabango().setReadOnly(true);
                div.getHihokenshabango().getYoshikiyonMeisai().getTxthihokenshamei().setReadOnly(true);
                div.getHihokenshabango().getYoshikiyonMeisai().getDdlShicyoson().setVisible(true);
                div.getHihokenshabango().getYoshikiyonMeisai().getBtnHoukokuNenKT().setVisible(true);
                if (TaishokensakuJyoukenHandler.UPDATE.equals(insuranceInfEntity.get処理フラグ())) {
                    詳細データエリ表示(詳細データ, 状態2);
                    div.getCcdKanryoMessage().setDisplayNone(true);
                    div.getHihokenshabango().getBtnYoshikiyon().setDisabled(true);
                    div.getHihokenshabango().getBntYoskiyonosan().setDisabled(false);
                    div.getHihokenshabango().getBtnYoshikiyonnoni().setDisabled(false);
                    CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnAddCancel"), false);
                    CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnModCancel"), true);
                    CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnDelCancel"), false);
                    CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnSaveCancel"), true);
                    CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnComplete"), false);
                    内部処理モード = 内部処理モード_修正;
                    画面表示 = 画面表示_修正;
                } else {
                    詳細データエリ表示(詳細データ, 状態3);
                    div.getCcdKanryoMessage().setDisplayNone(true);
                    div.getHihokenshabango().getBtnYoshikiyon().setDisabled(true);
                    if (TaishokensakuJyoukenHandler.入力未.equals(insuranceInfEntity.get様式４の２入力状況())) {
                        div.getHihokenshabango().getBtnYoshikiyonnoni().setDisabled(true);
                    }
                    if (TaishokensakuJyoukenHandler.入力未.equals(insuranceInfEntity.get様式４の３入力状況())) {
                        div.getHihokenshabango().getBntYoskiyonosan().setDisabled(true);
                    }
                    CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnAddCancel"), false);
                    CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnModCancel"), false);
                    CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnDelCancel"), true);
                    CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnSaveCancel"), true);
                    CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnComplete"), false);
                    内部処理モード = 内部処理モード_削除;
                    画面表示 = 画面表示_削除;
                }
            }
        } else if (TaishokensakuJyoukenHandler.ADD.equals(insuranceInfEntity.get処理フラグ())) {
//            List<ShichosonEntity> 市町村Lst = get市町村Lst();
//            if (市町村Lst.isEmpty()) {
//                throw new ApplicationException(DbaErrorMessages.広域構成市町村からの補正処理.getMessage());
//            }
//            List<KeyValueDataSource> dataSource = getDataSourceFrom市町村Lst(市町村Lst);
            RDate date = RDate.getNowDate();
            FlexibleDate 報告年度;
            FlexibleDate 集計年度;
            if (date.getMonthValue() < 6) {
                報告年度 = new FlexibleDate(date.getYear().getYearValue() - 1, date.getMonthValue(), date.getDayValue());
                集計年度 = new FlexibleDate(date.getYear().getYearValue() - 2, date.getMonthValue(), date.getDayValue());
            } else {
                報告年度 = new FlexibleDate(date.getYear().getYearValue(), date.getMonthValue(), date.getDayValue());
                集計年度 = new FlexibleDate(date.getYear().getYearValue() - 1, date.getMonthValue(), date.getDayValue());
            }
            報告年度Box.setValue(報告年度);
            集計年度Box.setValue(集計年度);
            div.getCcdKanryoMessage().setDisplayNone(true);
            div.getHihokenshabango().getBtnYoshikiyon().setDisabled(true);
            div.getHihokenshabango().getBntYoskiyonosan().setDisabled(false);
            div.getHihokenshabango().getBtnYoshikiyonnoni().setDisabled(false);
            div.getHihokenshabango().getYoshikiyonMeisai().getTxthokokuYM().setReadOnly(false);
            div.getHihokenshabango().getYoshikiyonMeisai().getTxtShukeiYM().setReadOnly(true);
            div.getHihokenshabango().getYoshikiyonMeisai().getTxtHihokenshabango().setDisplayNone(true);
            div.getHihokenshabango().getYoshikiyonMeisai().getTxthihokenshamei().setDisplayNone(true);
            //div.getHihokenshabango().getYoshikiyonMeisai().getDdlShicyoson().setDataSource(dataSource);
            div.getHihokenshabango().getYoshikiyonMeisai().getDdlShicyoson().setDisabled(true);
            div.getHihokenshabango().getYoshikiyonMeisai().getDdlShicyoson().setSelectedIndex(0);
            div.getHihokenshabango().getYoshikiyonMeisai().getBtnHoukokuNenKT().setDisabled(false);
            //CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnAddCancel"), true);
            //CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnModCancel"), false);
            //CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnDelCancel"), false);
            //CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnAddUpdate"), false);
            //CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnComplete"), false);
            内部処理モード = 内部処理モード_追加;
            画面表示 = 画面表示_追加;
            詳細データエリ表示(null, 状態1);
        }
    }

    /**
     * 市町村Lst取得処理です。
     *
     * @return List<ShichosonEntity>
     */
    private List<ShichosonEntity> get市町村Lst() {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager 介護保険特別会計経理状況登録Manager = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();
        List<ShichosonEntity> 市町村Lst = 介護保険特別会計経理状況登録Manager.getShichosonCodeNameList();
        return 市町村Lst;
    }

    /**
     * 詳細データエリア表示すること処理です。
     *
     * @param 詳細データ 詳細データ
     * @param 状態 状態
     */
    private void 詳細データエリ表示(KaigoHokenJigyoHokokuNenpoEntity 詳細データ, RString 状態) {
        if (状態2.equals(状態) || 状態3.equals(状態)) {
            保険料.setValue(new Decimal(詳細データ.get詳細データエリア().get(保険料横縦番号).toString()));
            総務費.setValue(new Decimal(詳細データ.get詳細データエリア().get(総務費横縦番号).toString()));
            認定負担金.setValue(new Decimal(詳細データ.get詳細データエリア().get(認定負担金横縦番号).toString()));
            介護サービス等諸費.setValue(new Decimal(詳細データ.get詳細データエリア().get(介護サービス等諸費横縦番号).toString()));
            その他.setValue(new Decimal(詳細データ.get詳細データエリア().get(その他横縦番号).toString()));
            介護予防サービス等諸費.setValue(new Decimal(詳細データ.get詳細データエリア().get(介護予防サービス等諸費横縦番号).toString()));
            使用料.setValue(new Decimal(詳細データ.get詳細データエリア().get(使用料横縦番号).toString()));
            高額介護サービス等費.setValue(new Decimal(詳細データ.get詳細データエリア().get(高額介護サービス等費横縦番号).toString()));
            手数料.setValue(new Decimal(詳細データ.get詳細データエリア().get(手数料横縦番号).toString()));
            高額医療合算介護サービス等費.setValue(new Decimal(詳細データ.get詳細データエリア().get(高額医療合算介護サービス等費横縦番号).toString()));
            介護給付費負担金.setValue(new Decimal(詳細データ.get詳細データエリア().get(介護給付費負担金横縦番号).toString()));
            特定入所者介護サービス等費.setValue(new Decimal(詳細データ.get詳細データエリア().get(特定入所者介護サービス等費横縦番号).toString()));
            調整交付金.setValue(new Decimal(詳細データ.get詳細データエリア().get(調整交付金横縦番号).toString()));
            審査支払手数料.setValue(new Decimal(詳細データ.get詳細データエリア().get(審査支払手数料横縦番号).toString()));
            地域支援事業交付金_介護予防事業.setValue(new Decimal(詳細データ.get詳細データエリア().get(地域支援事業交付金_介護予防事業横縦番号).toString()));
            市町村特別給付費.setValue(new Decimal(詳細データ.get詳細データエリア().get(市町村特別給付費横縦番号).toString()));
            地域支援事業交付金_包括的支援事業.setValue(new Decimal(詳細データ.get詳細データエリア().get(地域支援事業交付金_包括的支援事業横縦番号).toString()));
            その他_保険給付費.setValue(new Decimal(詳細データ.get詳細データエリア().get(その他_保険給付費横縦番号).toString()));
            その他_国庫支出金.setValue(new Decimal(詳細データ.get詳細データエリア().get(その他_国庫支出金横縦番号).toString()));
            介護予防事業費.setValue(new Decimal(詳細データ.get詳細データエリア().get(介護予防事業費横縦番号).toString()));
            介護給付費交付金.setValue(new Decimal(詳細データ.get詳細データエリア().get(介護給付費交付金横縦番号).toString()));
            包括的支援事業_任意事業_地域支援事業.setValue(new Decimal(詳細データ.get詳細データエリア().get(包括的支援事業_任意事業_地域支援事業横縦番号).toString()));
            地域支援事業支援交付金.setValue(new Decimal(詳細データ.get詳細データエリア().get(地域支援事業支援交付金横縦番号).toString()));
            財政安定化基金拠出金.setValue(new Decimal(詳細データ.get詳細データエリア().get(保険料横縦番号).toString()));
            都道府県負担金.setValue(new Decimal(詳細データ.get詳細データエリア().get(財政安定化基金拠出金横縦番号).toString()));
            相互財政安定化事業負担金.setValue(new Decimal(詳細データ.get詳細データエリア().get(相互財政安定化事業負担金横縦番号).toString()));
            財政安定化基金支出金.setValue(new Decimal(詳細データ.get詳細データエリア().get(財政安定化基金支出金横縦番号).toString()));
            保健福祉事業費.setValue(new Decimal(詳細データ.get詳細データエリア().get(保健福祉事業費横縦番号).toString()));
            都道府県支出金_地域支援事業交付金.setValue(new Decimal(詳細データ.get詳細データエリア().get(都道府県支出金_地域支援事業交付金横縦番号).toString()));
            基金積立金.setValue(new Decimal(詳細データ.get詳細データエリア().get(基金積立金横縦番号).toString()));
            地域支援事業交付金_任意事業.setValue(new Decimal(詳細データ.get詳細データエリア().get(地域支援事業交付金_任意事業横縦番号).toString()));
            財政安定化基金償還金.setValue(new Decimal(詳細データ.get詳細データエリア().get(財政安定化基金償還金横縦番号).toString()));
            その他_都道府県支出金.setValue(new Decimal(詳細データ.get詳細データエリア().get(その他_都道府県支出金横縦番号).toString()));
            その他_公債費.setValue(new Decimal(詳細データ.get詳細データエリア().get(その他_公債費横縦番号).toString()));
            相互財政安定化事業交付金.setValue(new Decimal(詳細データ.get詳細データエリア().get(相互財政安定化事業交付金横縦番号).toString()));
            予備費.setValue(new Decimal(詳細データ.get詳細データエリア().get(予備費横縦番号).toString()));
            財産収入.setValue(new Decimal(詳細データ.get詳細データエリア().get(財産収入横縦番号).toString()));
            介護サービス事業勘定繰出金.setValue(new Decimal(詳細データ.get詳細データエリア().get(介護サービス事業勘定繰出金横縦番号).toString()));
            寄附金.setValue(new Decimal(詳細データ.get詳細データエリア().get(寄附金横縦番号).toString()));
            他会計繰出金.setValue(new Decimal(詳細データ.get詳細データエリア().get(他会計繰出金横縦番号).toString()));
            一般会計繰入金.setValue(new Decimal(詳細データ.get詳細データエリア().get(一般会計繰入金横縦番号).toString()));
            その他_諸支出金.setValue(new Decimal(詳細データ.get詳細データエリア().get(その他_諸支出金横縦番号).toString()));
            総務費に係る一般会計繰入金.setValue(new Decimal(詳細データ.get詳細データエリア().get(総務費に係る一般会計繰入金横縦番号).toString()));
            介護給付費準備基金繰入金.setValue(new Decimal(詳細データ.get詳細データエリア().get(介護給付費準備基金繰入金横縦番号).toString()));
            介護サービス事業勘定繰入金.setValue(new Decimal(詳細データ.get詳細データエリア().get(介護サービス事業勘定繰入金横縦番号).toString()));
            地域支援事業繰入金_介護予防事業.setValue(new Decimal(詳細データ.get詳細データエリア().get(地域支援事業繰入金_介護予防事業横縦番号).toString()));
            地域支援事業繰入金_任意事業.setValue(new Decimal(詳細データ.get詳細データエリア().get(地域支援事業繰入金_任意事業横縦番号).toString()));
            その他_繰入金.setValue(new Decimal(詳細データ.get詳細データエリア().get(その他_繰入金横縦番号).toString()));
            繰越金.setValue(new Decimal(詳細データ.get詳細データエリア().get(繰越金横縦番号).toString()));
            財政安定化基金貸付金.setValue(new Decimal(詳細データ.get詳細データエリア().get(財政安定化基金貸付金横縦番号).toString()));
            その他_市町村債.setValue(new Decimal(詳細データ.get詳細データエリア().get(その他_市町村債横縦番号).toString()));
            諸収入.setValue(new Decimal(詳細データ.get詳細データエリア().get(諸収入横縦番号).toString()));
            合計１.setValue(new Decimal(詳細データ.get詳細データエリア().get(合計１横縦番号).toString()));
            合計２.setValue(new Decimal(詳細データ.get詳細データエリア().get(合計２横縦番号).toString()));
            歳入歳出差引残額.setValue(new Decimal(詳細データ.get詳細データエリア().get(歳入歳出差引残額横縦番号).toString()));
            うち基金繰入額.setValue(new Decimal(詳細データ.get詳細データエリア().get(うち基金繰入額横縦番号).toString()));
            介護給付費準備基金保有額.setValue(new Decimal(詳細データ.get詳細データエリア().get(介護給付費準備基金保有額横縦番号).toString()));
        }
        if (状態2.equals(状態) || 状態3.equals(状態) || 状態1.equals(状態) || 状態1_確定.equals(状態)) {
            Boolean readOnly = 状態3.equals(状態) || 状態1.equals(状態);
            保険料.setReadOnly(readOnly);
            総務費.setReadOnly(readOnly);
            認定負担金.setReadOnly(readOnly);
            介護サービス等諸費.setReadOnly(readOnly);
            その他.setReadOnly(readOnly);
            介護予防サービス等諸費.setReadOnly(readOnly);
            使用料.setReadOnly(readOnly);
            高額介護サービス等費.setReadOnly(readOnly);
            手数料.setReadOnly(readOnly);
            高額医療合算介護サービス等費.setReadOnly(readOnly);
            介護給付費負担金.setReadOnly(readOnly);
            特定入所者介護サービス等費.setReadOnly(readOnly);
            調整交付金.setReadOnly(readOnly);
            審査支払手数料.setReadOnly(readOnly);
            地域支援事業交付金_介護予防事業.setReadOnly(readOnly);
            市町村特別給付費.setReadOnly(readOnly);
            地域支援事業交付金_包括的支援事業.setReadOnly(readOnly);
            その他_保険給付費.setReadOnly(readOnly);
            その他_国庫支出金.setReadOnly(readOnly);
            介護予防事業費.setReadOnly(readOnly);
            介護給付費交付金.setReadOnly(readOnly);
            包括的支援事業_任意事業_地域支援事業.setReadOnly(readOnly);
            地域支援事業支援交付金.setReadOnly(readOnly);
            財政安定化基金拠出金.setReadOnly(readOnly);
            都道府県負担金.setReadOnly(readOnly);
            相互財政安定化事業負担金.setReadOnly(readOnly);
            財政安定化基金支出金.setReadOnly(readOnly);
            保健福祉事業費.setReadOnly(readOnly);
            都道府県支出金_地域支援事業交付金.setReadOnly(readOnly);
            基金積立金.setReadOnly(readOnly);
            地域支援事業交付金_任意事業.setReadOnly(readOnly);
            財政安定化基金償還金.setReadOnly(readOnly);
            その他_都道府県支出金.setReadOnly(readOnly);
            その他_公債費.setReadOnly(readOnly);
            相互財政安定化事業交付金.setReadOnly(readOnly);
            予備費.setReadOnly(readOnly);
            財産収入.setReadOnly(readOnly);
            介護サービス事業勘定繰出金.setReadOnly(readOnly);
            寄附金.setReadOnly(readOnly);
            他会計繰出金.setReadOnly(readOnly);
            一般会計繰入金.setReadOnly(readOnly);
            その他_諸支出金.setReadOnly(readOnly);
            総務費に係る一般会計繰入金.setReadOnly(readOnly);
            介護給付費準備基金繰入金.setReadOnly(readOnly);
            介護サービス事業勘定繰入金.setReadOnly(readOnly);
            地域支援事業繰入金_介護予防事業.setReadOnly(readOnly);
            地域支援事業繰入金_任意事業.setReadOnly(readOnly);
            その他_繰入金.setReadOnly(readOnly);
            繰越金.setReadOnly(readOnly);
            財政安定化基金貸付金.setReadOnly(readOnly);
            その他_市町村債.setReadOnly(readOnly);
            諸収入.setReadOnly(readOnly);
            合計１.setReadOnly(readOnly);
            合計２.setReadOnly(readOnly);
            歳入歳出差引残額.setReadOnly(readOnly);
            うち基金繰入額.setReadOnly(readOnly);
            介護給付費準備基金保有額.setReadOnly(readOnly);
        }
    }

    /**
     * 「保存する」ボタンを押下すること処理です。
     */
    public void onClick_btnSave() {
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager 介護保険特別会計経理状況登録Manager
                = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();
        List<KaigoHokenJigyoHokokuNenpoEntity> 画面入力データLst = new ArrayList<>();
        if (内部処理モード_追加.equals(内部処理モード)) {
            KaigoHokenJigyoHokokuNenpoEntity 画面入力データ = get画面入力データ();
            画面入力データLst.add(画面入力データ);
            介護保険特別会計経理状況登録Manager.regKaigoHokenTokubetuKaikeiKeiriJyokyo(画面入力データLst);
        } else if (内部処理モード_修正.equals(内部処理モード)) {
            KaigoHokenJigyoHokokuNenpoEntity 修正データ = get修正データ();
            画面入力データLst.add(修正データ);
            介護保険特別会計経理状況登録Manager.updKaigoHokenTokubetuKaikeiKeiriJyokyo(画面入力データLst);
        } else if (内部処理モード_修正追加.equals(内部処理モード)) {
            KaigoHokenJigyoHokokuNenpoEntity 画面入力データ = get画面入力データ();
            画面入力データLst.add(画面入力データ);
            介護保険特別会計経理状況登録Manager.regUpdKaigoHokenTokubetuKaikeiKeiriJyokyo(画面入力データLst);
        } else if (内部処理モード_削除.equals(内部処理モード)) {
            InsuranceInformationEntity insuranceInfEntity = get引き継ぎデータ();
            介護保険特別会計経理状況登録Manager.delKaigoHokenTokubetuKaikeiKeiriJyokyo(
                    insuranceInfEntity.get報告年(),
                    insuranceInfEntity.get集計対象年(),
                    insuranceInfEntity.get統計対象区分(),
                    insuranceInfEntity.get市町村コード(),
                    insuranceInfEntity.get表番号(), 集計番号_0100);
        }
        div.getHihokenshabango().setDisplayNone(true);
        div.getCcdKanryoMessage().setDisplayNone(false);
    }

    /**
     * 「報告年度を確定する」ボタンを押下すること処理です。
     */
    public void onClick_btnConfirm() {
        List<ShichosonEntity> 市町村Lst = get市町村Lst();
        TextBoxFlexibleDate 報告年度Box = div.getHihokenshabango().getYoshikiyonMeisai().getTxthokokuYM();
        FlexibleDate 報告年度 = 報告年度Box.getValue();
        int choice = div.getHihokenshabango().getYoshikiyonMeisai().getDdlShicyoson().getSelectedIndex();
        ShichosonEntity 市町村 = 市町村Lst.get(choice);
        TokeiTaishoKubun 保険者区分 = 市町村.get保険者区分();
        LasdecCode 市町村コード = 市町村.get市町村コード();
        if (!報告年度.isEmpty()) {
            KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager 介護保険特別会計経理状況登録Manager
                    = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();
            List<KaigoHokenJigyoHokokuNenpoEntity> 一覧データLst
                    = 介護保険特別会計経理状況登録Manager.getJigyoHokokuNenpoList(報告年度.getYear(), 市町村コード, 保険者区分);
            KaigoHokenJigyoHokokuNenpoEntity 一覧データ = 一覧データLst.get(0);
            if (一覧データ != null && !一覧データ.get詳細データエリア().isEmpty()) {
                //TODO DBAE00027（該当報告年度の集計データは既に存在しているため、追加はできません。）は、DB（統合）介護メッセージ一覧.xlsxにありません
                throw new ApplicationException(DbaErrorMessages.該当報告年度の集計データは既に存在.getMessage());
            } else {
                報告年度Box.setReadOnly(true);
                div.getHihokenshabango().getYoshikiyonMeisai().getDdlShicyoson().setDisabled(true);
                div.getHihokenshabango().getYoshikiyonMeisai().getBtnHoukokuNenKT().setDisabled(true);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnSaveCancel"), true);
                詳細データエリ表示(null, 状態1_確定);
            }
        } else {
            throw new ApplicationException(UrErrorMessages.必須.getMessage());
        }

    }

    /**
     * 「報告年度」フォーカスロスト処理です。
     */
    public void lostFocus() {
        TextBoxFlexibleDate 報告年度Box = div.getHihokenshabango().getYoshikiyonMeisai().getTxthokokuYM();
        TextBoxFlexibleDate 集計年度Box = div.getHihokenshabango().getYoshikiyonMeisai().getTxthokokuYM();
        RString 報告年度String = 報告年度Box.getText();
        int 報告年度Year = Integer.parseInt(報告年度String.substring(0, 4).toString());
        FlexibleDate 報告年度 = 報告年度Box.getValue();
        if (!報告年度.isEmpty()) {
            FlexibleDate 集計年度;
            RDate date = RDate.getNowDate();
            if (報告年度Year == date.getYearValue()) {
                if (date.getMonthValue() >= 6) {
                    集計年度 = new FlexibleDate(date.getYearValue() - 1, date.getMonthValue(), date.getDayValue());
                } else {
                    集計年度 = new FlexibleDate(date.getYearValue() - 2, date.getMonthValue(), date.getDayValue());
                }
            } else {
                集計年度 = new FlexibleDate(報告年度Year, date.getMonthValue(), date.getDayValue());
            }
            集計年度Box.setValue(集計年度);
        }
    }

    /**
     * 修正データの取得処理です。
     *
     * @return 修正データ
     */
    public KaigoHokenJigyoHokokuNenpoEntity get修正データ() {
        InsuranceInformationEntity insuranceInfEntity = get引き継ぎデータ();
        KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager 介護保険特別会計経理状況登録Manager
                = new KaigoHokenTokubetuKaikeiKeiriJyokyoRegistManager();
        List<KaigoHokenJigyoHokokuNenpoEntity> 詳細データLst
                = 介護保険特別会計経理状況登録Manager.getJigyoHokokuNenpoDetal(
                        new FlexibleYear(insuranceInfEntity.get報告年().toString()),
                        new RString(insuranceInfEntity.get集計対象年().toString()),
                        insuranceInfEntity.get統計対象区分(),
                        insuranceInfEntity.get市町村コード(),
                        集計番号_0100.getColumnValue());
        KaigoHokenJigyoHokokuNenpoEntity 詳細データ = 詳細データLst.get(0);
        KaigoHokenJigyoHokokuNenpoEntity 画面入力データ = get画面入力データ();
        KaigoHokenJigyoHokokuNenpoEntity 修正データ = new KaigoHokenJigyoHokokuNenpoEntity();
        修正データ.set報告年(画面入力データ.get報告年());
        修正データ.set報告月(画面入力データ.get報告月());
        修正データ.set市町村コード(画面入力データ.get市町村コード());
        修正データ.set横項目コード(画面入力データ.get横項目コード());
        修正データ.set統計対象区分(画面入力データ.get統計対象区分());
        修正データ.set縦項目コード(画面入力データ.get縦項目コード());
        修正データ.set表番号(画面入力データ.get表番号());
        修正データ.set集計単位(画面入力データ.get集計単位());
        修正データ.set集計対象年(画面入力データ.get集計対象年());
        修正データ.set集計対象月(画面入力データ.get集計対象月());
        修正データ.set集計番号(画面入力データ.get集計番号());
        修正データ.set集計項目名称(画面入力データ.get集計項目名称());
        Map<RString, Decimal> 修正データエリア = new HashMap<>();
        for (Map.Entry<RString, Decimal> 詳細データentry : 詳細データ.get詳細データエリア().entrySet()) {
            if (!詳細データentry.getValue().equals(画面入力データ.get詳細データエリア().get(詳細データentry.getKey()))) {
                修正データエリア.put(詳細データentry.getKey(), 画面入力データ.get詳細データエリア().get(詳細データentry.getKey()));
            }
        }
        修正データ.set詳細データエリア(修正データエリア);
        return 修正データ;
    }

    /**
     * 画面詳細エリア入力有無の判定処理です。
     *
     * @param 画面入力データ 画面入力データ
     * @return 画面詳細エリア入力有無
     */
    public Boolean is画面詳細エリア入力有(KaigoHokenJigyoHokokuNenpoEntity 画面入力データ) {
        Map<RString, Decimal> 詳細データエリア = 画面入力データ.get詳細データエリア();
        for (Map.Entry<RString, Decimal> 詳細データentry : 詳細データエリア.entrySet()) {
            if (!DECIMAL_0.equals(詳細データentry.getValue())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 画面入力データの取得処理です。
     *
     * @return 画面入力データ
     */
    public KaigoHokenJigyoHokokuNenpoEntity get画面入力データ() {
        InsuranceInformationEntity insuranceInfEntity = get引き継ぎデータ();
        KaigoHokenJigyoHokokuNenpoEntity 画面入力データ = new KaigoHokenJigyoHokokuNenpoEntity();
        画面入力データ.set報告年(div.getHihokenshabango().getYoshikiyonMeisai().getTxthokokuYM().getValue().getYear());
        画面入力データ.set報告月(DOUBLE_ZEOR);
        画面入力データ.set集計対象年(div.getHihokenshabango().getYoshikiyonMeisai().getTxthokokuYM().getValue().getYear());
        画面入力データ.set集計対象月(DOUBLE_ZEOR);
        画面入力データ.set統計対象区分(insuranceInfEntity.get統計対象区分());
        画面入力データ.set市町村コード(insuranceInfEntity.get市町村コード());
        画面入力データ.set表番号(表番号_09);
        画面入力データ.set集計番号(集計番号_0100);
        画面入力データ.set集計単位(集計単位_1);
        Map<RString, Decimal> 画面入力詳細データエリ = new HashMap<>();
        画面入力詳細データエリ.put(保険料横縦番号,
                保険料.getValue() == null ? DECIMAL_0 : 保険料.getValue());
        画面入力詳細データエリ.put(総務費横縦番号,
                総務費.getValue() == null ? DECIMAL_0 : 総務費.getValue());
        画面入力詳細データエリ.put(認定負担金横縦番号,
                認定負担金.getValue() == null ? DECIMAL_0 : 認定負担金.getValue());
        画面入力詳細データエリ.put(介護サービス等諸費横縦番号,
                介護サービス等諸費.getValue() == null ? DECIMAL_0 : 介護サービス等諸費.getValue());
        画面入力詳細データエリ.put(その他横縦番号, その他.getValue() == null ? DECIMAL_0 : その他.getValue());
        画面入力詳細データエリ.put(介護予防サービス等諸費横縦番号,
                介護予防サービス等諸費.getValue() == null ? DECIMAL_0 : 介護予防サービス等諸費.getValue());
        画面入力詳細データエリ.put(使用料横縦番号,
                使用料.getValue() == null ? DECIMAL_0 : 使用料.getValue());
        画面入力詳細データエリ.put(高額介護サービス等費横縦番号,
                高額介護サービス等費.getValue() == null ? DECIMAL_0 : 高額介護サービス等費.getValue());
        画面入力詳細データエリ.put(手数料横縦番号,
                手数料.getValue() == null ? DECIMAL_0 : 手数料.getValue());
        画面入力詳細データエリ.put(高額医療合算介護サービス等費横縦番号,
                高額医療合算介護サービス等費.getValue() == null ? DECIMAL_0 : 高額医療合算介護サービス等費.getValue());
        画面入力詳細データエリ.put(介護給付費負担金横縦番号, 介護給付費負担金.getValue() == null ? DECIMAL_0 : 介護給付費負担金.getValue());
        画面入力詳細データエリ.put(特定入所者介護サービス等費横縦番号,
                特定入所者介護サービス等費.getValue() == null ? DECIMAL_0 : 特定入所者介護サービス等費.getValue());
        画面入力詳細データエリ.put(調整交付金横縦番号,
                調整交付金.getValue() == null ? DECIMAL_0 : 調整交付金.getValue());
        画面入力詳細データエリ.put(審査支払手数料横縦番号,
                審査支払手数料.getValue() == null ? DECIMAL_0 : 審査支払手数料.getValue());
        画面入力詳細データエリ.put(地域支援事業交付金_介護予防事業横縦番号,
                地域支援事業交付金_介護予防事業.getValue() == null ? DECIMAL_0 : 地域支援事業交付金_介護予防事業.getValue());
        画面入力詳細データエリ.put(市町村特別給付費横縦番号,
                市町村特別給付費.getValue() == null ? DECIMAL_0 : 市町村特別給付費.getValue());
        画面入力詳細データエリ.put(地域支援事業交付金_包括的支援事業横縦番号,
                地域支援事業交付金_包括的支援事業.getValue() == null ? DECIMAL_0 : 地域支援事業交付金_包括的支援事業.getValue());
        画面入力詳細データエリ.put(その他_保険給付費横縦番号,
                その他_保険給付費.getValue() == null ? DECIMAL_0 : その他_保険給付費.getValue());
        画面入力詳細データエリ.put(その他_国庫支出金横縦番号,
                その他_国庫支出金.getValue() == null ? DECIMAL_0 : その他_国庫支出金.getValue());
        画面入力詳細データエリ.put(介護予防事業費横縦番号,
                介護予防事業費.getValue() == null ? DECIMAL_0 : 介護予防事業費.getValue());
        画面入力詳細データエリ.put(介護給付費交付金横縦番号,
                介護給付費交付金.getValue() == null ? DECIMAL_0 : 介護給付費交付金.getValue());
        画面入力詳細データエリ.put(包括的支援事業_任意事業_地域支援事業横縦番号,
                包括的支援事業_任意事業_地域支援事業.getValue() == null ? DECIMAL_0 : 包括的支援事業_任意事業_地域支援事業.getValue());
        画面入力詳細データエリ.put(地域支援事業支援交付金横縦番号,
                地域支援事業支援交付金.getValue() == null ? DECIMAL_0 : 地域支援事業支援交付金.getValue());
        画面入力詳細データエリ.put(財政安定化基金拠出金横縦番号,
                財政安定化基金拠出金.getValue() == null ? DECIMAL_0 : 財政安定化基金拠出金.getValue());
        画面入力詳細データエリ.put(都道府県負担金横縦番号,
                都道府県負担金.getValue() == null ? DECIMAL_0 : 都道府県負担金.getValue());
        画面入力詳細データエリ.put(相互財政安定化事業負担金横縦番号,
                相互財政安定化事業負担金.getValue() == null ? DECIMAL_0 : 相互財政安定化事業負担金.getValue());
        画面入力詳細データエリ.put(財政安定化基金支出金横縦番号,
                財政安定化基金支出金.getValue() == null ? DECIMAL_0 : 財政安定化基金支出金.getValue());
        画面入力詳細データエリ.put(保健福祉事業費横縦番号,
                保健福祉事業費.getValue() == null ? DECIMAL_0 : 保健福祉事業費.getValue());
        画面入力詳細データエリ.put(都道府県支出金_地域支援事業交付金横縦番号,
                都道府県支出金_地域支援事業交付金.getValue() == null ? DECIMAL_0 : 都道府県支出金_地域支援事業交付金.getValue());
        画面入力詳細データエリ.put(基金積立金横縦番号,
                基金積立金.getValue() == null ? DECIMAL_0 : 基金積立金.getValue());
        画面入力詳細データエリ.put(地域支援事業交付金_任意事業横縦番号,
                地域支援事業交付金_任意事業.getValue() == null ? DECIMAL_0 : 地域支援事業交付金_任意事業.getValue());
        画面入力詳細データエリ.put(財政安定化基金償還金横縦番号,
                財政安定化基金償還金.getValue() == null ? DECIMAL_0 : 財政安定化基金償還金.getValue());
        画面入力詳細データエリ.put(その他_都道府県支出金横縦番号,
                その他_都道府県支出金.getValue() == null ? DECIMAL_0 : その他_都道府県支出金.getValue());
        画面入力詳細データエリ.put(その他_公債費横縦番号,
                その他_公債費.getValue() == null ? DECIMAL_0 : その他_公債費.getValue());
        画面入力詳細データエリ.put(相互財政安定化事業交付金横縦番号,
                相互財政安定化事業交付金.getValue() == null ? DECIMAL_0 : 相互財政安定化事業交付金.getValue());
        画面入力詳細データエリ.put(予備費横縦番号,
                予備費.getValue() == null ? DECIMAL_0 : 予備費.getValue());
        画面入力詳細データエリ.put(財産収入横縦番号,
                財産収入.getValue() == null ? DECIMAL_0 : 財産収入.getValue());
        画面入力詳細データエリ.put(介護サービス事業勘定繰出金横縦番号,
                介護サービス事業勘定繰出金.getValue() == null ? DECIMAL_0 : 介護サービス事業勘定繰出金.getValue());
        画面入力詳細データエリ.put(寄附金横縦番号,
                寄附金.getValue() == null ? DECIMAL_0 : 寄附金.getValue());
        画面入力詳細データエリ.put(他会計繰出金横縦番号,
                他会計繰出金.getValue() == null ? DECIMAL_0 : 他会計繰出金.getValue());
        画面入力詳細データエリ.put(一般会計繰入金横縦番号,
                一般会計繰入金.getValue() == null ? DECIMAL_0 : 一般会計繰入金.getValue());
        画面入力詳細データエリ.put(その他_諸支出金横縦番号,
                その他_諸支出金.getValue() == null ? DECIMAL_0 : その他_諸支出金.getValue());
        画面入力詳細データエリ.put(総務費に係る一般会計繰入金横縦番号,
                総務費に係る一般会計繰入金.getValue() == null ? DECIMAL_0 : 総務費に係る一般会計繰入金.getValue());
        画面入力詳細データエリ.put(介護給付費準備基金繰入金横縦番号,
                介護給付費準備基金繰入金.getValue() == null ? DECIMAL_0 : 介護給付費準備基金繰入金.getValue());
        画面入力詳細データエリ.put(介護サービス事業勘定繰入金横縦番号,
                介護サービス事業勘定繰入金.getValue() == null ? DECIMAL_0 : 介護サービス事業勘定繰入金.getValue());
        画面入力詳細データエリ.put(地域支援事業繰入金_介護予防事業横縦番号,
                地域支援事業繰入金_介護予防事業.getValue() == null ? DECIMAL_0 : 地域支援事業繰入金_介護予防事業.getValue());
        画面入力詳細データエリ.put(地域支援事業繰入金_任意事業横縦番号,
                地域支援事業繰入金_任意事業.getValue() == null ? DECIMAL_0 : 地域支援事業繰入金_任意事業.getValue());
        画面入力詳細データエリ.put(その他_繰入金横縦番号,
                その他_繰入金.getValue() == null ? DECIMAL_0 : その他_繰入金.getValue());
        画面入力詳細データエリ.put(繰越金横縦番号,
                繰越金.getValue() == null ? DECIMAL_0 : 繰越金.getValue());
        画面入力詳細データエリ.put(財政安定化基金貸付金横縦番号,
                財政安定化基金貸付金.getValue() == null ? DECIMAL_0 : 財政安定化基金貸付金.getValue());
        画面入力詳細データエリ.put(その他_市町村債横縦番号,
                その他_市町村債.getValue() == null ? DECIMAL_0 : その他_市町村債.getValue());
        画面入力詳細データエリ.put(諸収入横縦番号,
                諸収入.getValue() == null ? DECIMAL_0 : 諸収入.getValue());
        画面入力詳細データエリ.put(合計１横縦番号,
                合計１.getValue() == null ? DECIMAL_0 : 合計１.getValue());
        画面入力詳細データエリ.put(合計２横縦番号,
                合計２.getValue() == null ? DECIMAL_0 : 合計２.getValue());
        画面入力詳細データエリ.put(歳入歳出差引残額横縦番号,
                歳入歳出差引残額.getValue() == null ? DECIMAL_0 : 歳入歳出差引残額.getValue());
        画面入力詳細データエリ.put(うち基金繰入額横縦番号,
                うち基金繰入額.getValue() == null ? DECIMAL_0 : うち基金繰入額.getValue());
        画面入力詳細データエリ.put(介護給付費準備基金保有額横縦番号,
                介護給付費準備基金保有額.getValue() == null ? DECIMAL_0 : 介護給付費準備基金保有額.getValue());

        画面入力データ.set詳細データエリア(画面入力詳細データエリ);
        return 画面入力データ;

    }

    public KaigoHokenShoriDateKanriEntity get処理日付管理マスタ() {
        KaigoHokenShoriDateKanriEntity 処理日付管理マスタ = new KaigoHokenShoriDateKanriEntity();
        FlexibleYear 集計年度 = div.getHihokenshabango().getYoshikiyonMeisai().getTxthokokuYM().getValue().getYear();
        処理日付管理マスタ.set処理名(JigyoHokokuNenpoShoriName.事業状況報告資料_年報_作成特別会計経理状況);
        処理日付管理マスタ.set処理枝番(DOUBLE_ZEOR);
        処理日付管理マスタ.set年度(集計年度);
        処理日付管理マスタ.set年度内連番(DOUBLE_ZEOR);
        処理日付管理マスタ.set基準日時(RDate.getNowDateTime());
        処理日付管理マスタ.set対象開始年月日(new FlexibleDate(集計年度.getYearValue(), 04, 01));
        処理日付管理マスタ.set対象終了年月日(new FlexibleDate(集計年度.getYearValue() + 1, 03, 31));
        return 処理日付管理マスタ;
    }

    /**
     * 市町村のDataSource取得処理です。
     *
     * @param 市町村Lst 市町村Lst
     * @return DataSource
     */
    private List<KeyValueDataSource> getDataSourceFrom市町村Lst(List<ShichosonEntity> 市町村Lst) {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (ShichosonEntity shichosonEntity : 市町村Lst) {
            KeyValueDataSource keyValueDataSource = new KeyValueDataSource(shichosonEntity.get市町村コード().getColumnValue(), shichosonEntity.get市町村名称());
            dataSource.add(keyValueDataSource);
        }
        return dataSource;
    }

    /**
     * 引き継ぎデータ取得処理です。
     *
     */
    private InsuranceInformationEntity get引き継ぎデータ() {
        InsuranceInformationEntity 引き継ぎデータ
                = (InsuranceInformationEntity) ViewStateHolder.get(TaishokensakuJyouken.ViewStateKey.様式４, InsuranceInformationEntity.class);
        if (null == 引き継ぎデータ) {
            引き継ぎデータ = new InsuranceInformationEntity();
            引き継ぎデータ.set処理フラグ(TaishokensakuJyoukenHandler.ADD);
        }
        return 引き継ぎデータ;
    }

}
