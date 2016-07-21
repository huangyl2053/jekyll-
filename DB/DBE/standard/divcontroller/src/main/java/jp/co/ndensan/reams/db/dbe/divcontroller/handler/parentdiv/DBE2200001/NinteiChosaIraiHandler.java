package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2200001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.NinnteiChousairaiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.SaiChekkuhyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.WaritsukeBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyotokkijiko.ChosahyoTokkijikoBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.chosahyokihonchosakatamen.ChosahyoKihonchosaKatamenItem;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaisho.ChosaIraishoHeadItem;
import jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyogaikyochosa.ChosahyoGaikyochosaItem;
import jp.co.ndensan.reams.db.dbe.business.report.saichekkuhyo.SaiChekkuhyoItem;
import jp.co.ndensan.reams.db.dbe.definition.core.chosa.ChohyoAtesakiKeisho;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninnteichousairai.SaiChekkuhyoParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.NinteiChosaIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgChosaItakusakiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgMiwaritsukeShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgWaritsukeZumiShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgchosainIchiran_Row;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ninnteichousairai.NinnteiChousairaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChosainJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChosainJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCodeResult;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 認定調査員マスタ画面のハンドラークラスです。
 *
 * @reamsid_L DBE-0010-010 sunhaidi
 */
public class NinteiChosaIraiHandler {

    private static final RString 設定方法 = new RString("1");
    private static final RString WARITSUKE_ZUMI = new RString("割付済み");
    private static final RString MIWARITSUKE = new RString("未割付");
    private static final RString 元号_明治 = new RString("明治");
    private static final RString 元号_大正 = new RString("大正");
    private static final RString 元号_昭和 = new RString("昭和");
    private static final RString 記号 = new RString("✔");
    private static final RString HOUSI = new RString("*");
    private static final RString ハイフン = new RString("-");
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
    private static final RString 文字列1 = new RString("1");
    private static final RString 文字列2 = new RString("2");
    private static final RString 文字列3 = new RString("3");
    private static final RString 文字列4 = new RString("4");
    private static final RString 文字列5 = new RString("5");
    private final NinteiChosaIraiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 認定調査依頼Div
     */
    public NinteiChosaIraiHandler(NinteiChosaIraiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param flg 初期化判断
     */
    public void load(boolean flg) {
        if (flg) {
            div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        }
        div.getTxtChosaItakusakiCode().clearValue();
        div.getTxtChosaItakusakiMeisho().clearValue();
        div.getTxtChosaItakusakiChiku().clearValue();
        div.getTxtChosainCode().clearValue();
        div.getTxtChosainShimei().clearValue();
        div.getTxtChosainChiku().clearValue();
        setDisabledToChosaItakusakiAndChosainKihonJoho(true);
    }

    /**
     * 単一保険者と広域保険者の判断処理です。
     *
     * @return 判断結果(true:単一保険者,false:広域保険者)
     */
    public boolean is単一保険者() {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護認定);
        RString 導入形態コード = 市町村セキュリティ情報.get導入形態コード().value();
        return (DonyuKeitaiCode.事務単一.getCode().equals(導入形態コード)
                || DonyuKeitaiCode.認定単一.getCode().equals(導入形態コード));
    }

    /**
     * 認定調査委託先一覧に検索結果を設定します。
     *
     * @param 認定調査委託先List 認定調査委託先List
     * @return コード取得結果
     */
    public boolean set認定調査委託先一覧(List<NinnteiChousairaiBusiness> 認定調査委託先List) {
        List<dgChosaItakusakiIchiran_Row> dataSource = new ArrayList<>();
        RString 市町村コード = div.getCcdHokenshaList().getSelectedItem().get市町村コード().value();
        RString 市町村名称 = div.getCcdHokenshaList().getSelectedItem().get市町村名称();
        FlexibleDate 基準日 = FlexibleDate.getNowDate();
        for (NinnteiChousairaiBusiness business : 認定調査委託先List) {
            dgChosaItakusakiIchiran_Row row = new dgChosaItakusakiIchiran_Row();
            TextBoxCode chosaItakusakiCode = new TextBoxCode();
            chosaItakusakiCode.setValue(nullToEmpty(business.getNinteichosaItakusakiCode()));
            row.setChosaItakusakiCode(chosaItakusakiCode);
            row.setChosaItakusakiMeisho(nullToEmpty(business.getJigyoshaMeisho()));
            if (business.getWaritsukeChiku() != null) {
                RString codeName = CodeMaster.getCodeMeisho(
                        SubGyomuCode.DBE認定支援,
                        DBECodeShubetsu.調査地区コード.getコード(),
                        new Code(business.getWaritsukeChiku().value()), 基準日);
                if (codeName != null) {
                    row.setChosaChiku(codeName);
                } else {
                    return false;
                }
            }

            TextBoxNum waritsukeTeiin = new TextBoxNum();
            waritsukeTeiin.setValue(new Decimal(business.getWaritsukeTeiin()));
            row.setWaritsukeTeiin(waritsukeTeiin);
            TextBoxNum waritsukeZumi = new TextBoxNum();
            waritsukeZumi.setValue(new Decimal(business.getWaritsukesumiKensu()));
            row.setWaritsukeZumi(waritsukeZumi);
            row.setChosaItakusakiJusho(nullToEmpty(business.getJusho()));
            row.setChosaItakusakiTelNo(business.getTelNo() == null ? RString.EMPTY : business.getTelNo().value());
            row.setChosaItakusakiKubun(nullToEmpty(business.getKikanKubun()));
            if (is単一保険者()) {
                row.setHokenshaCode(nullToEmpty(市町村コード));
                row.setHokenshaName(nullToEmpty(市町村名称));
            } else {
                row.setHokenshaCode(business.getShichosonCode() == null ? RString.EMPTY : business.getShichosonCode().value());
                row.setHokenshaName(nullToEmpty(business.getShichosonMeisho()));
            }

            dataSource.add(row);
        }
        div.getDgChosaItakusakiIchiran().getFilterList().clear();
        div.getDgChosaItakusakiIchiran().setDataSource(dataSource);
        return true;
    }

    /**
     * 調査員情報一覧に検索結果を設定します。
     *
     * @param 調査員情報一覧List 調査員情報一覧List
     * @param selectRow dgChosaItakusakiIchiran_Row
     */
    public void set調査員情報一覧(List<NinnteiChousairaiBusiness> 調査員情報一覧List, dgChosaItakusakiIchiran_Row selectRow) {
        List<dgchosainIchiran_Row> dataSource = new ArrayList<>();
        for (NinnteiChousairaiBusiness business : 調査員情報一覧List) {
            dgchosainIchiran_Row row = new dgchosainIchiran_Row();
            TextBoxCode chosainCode = new TextBoxCode();
            chosainCode.setValue(nullToEmpty(business.getNinteiChosainNo()));
            row.setChosainCode(chosainCode);
            row.setChosainShimei(nullToEmpty(business.getChosainShimei()));
            row.setChosainKanaShimei(nullToEmpty(business.getChosainKanaShimei()));
            if (!RString.isNullOrEmpty(business.getSeibetsu())) {
                row.setChosainSeibetsu(Seibetsu.toValue(business.getSeibetsu()).get名称());
            }
            row.setChosainTelNo(business.getTelNo() == null ? RString.EMPTY : business.getTelNo().value());
            row.setChosaChiku(nullToEmpty(business.getChikuCode()));
            TextBoxNum waritsukeZumi = new TextBoxNum();
            waritsukeZumi.setValue(new Decimal(business.getWaritsukesumiKensu()));
            row.setWaritsukeZumi(waritsukeZumi);
            row.setChosainShikaku(nullToEmpty(business.getChosainShikaku()));
            row.setChosaKanoNinzuPerMonth(new RString(String.valueOf(business.getChosaKanoNinzuPerMonth())));
            row.setHokenshaCode(nullToEmpty(selectRow.getHokenshaCode()));
            row.setHokenshaName(nullToEmpty(selectRow.getHokenshaName()));
            dataSource.add(row);
        }
        div.getDgchosainIchiran().getFilterList().clear();
        div.getDgchosainIchiran().setDataSource(dataSource);
    }

    /**
     * 未割付申請者一覧Gridに検索結果を設定します。
     *
     * @param 未割付一覧 未割付一覧検索結果
     * @param hokenshaName 保険者名称
     */
    public void set未割付申請者一覧(List<WaritsukeBusiness> 未割付一覧, RString hokenshaName) {
        List<dgMiwaritsukeShinseishaIchiran_Row> dataSource = new ArrayList<>();
        int i = 1;
        for (WaritsukeBusiness business : 未割付一覧) {
            dgMiwaritsukeShinseishaIchiran_Row row = new dgMiwaritsukeShinseishaIchiran_Row();
            row.setNo(new RString(String.valueOf(i++)));
            row.setJotai(RString.EMPTY);
            row.setHihokenshaNo(nullToEmpty(business.getHihokenshaNo()));
            row.setHihokenshaShimei(business.getHihokenshaName() == null ? RString.EMPTY : business.getHihokenshaName().value());
            if (business.getSeibetsu() != null && !RString.isNullOrEmpty(business.getSeibetsu().value())) {
                row.setSeibetsu(Seibetsu.toValue(business.getSeibetsu().value()).get名称());
            }
            if (business.getNinteiShinseiYMD() != null) {
                TextBoxDate ninteiShinseiDay = new TextBoxDate();
                ninteiShinseiDay.setValue(new RDate(business.getNinteiShinseiYMD().toString()));
                row.setNinteiShinseiDay(ninteiShinseiDay);
            }
            if (business.getNinteiShinseiKubunCode() != null) {
                int ninteiShinseiKubun = Integer.parseInt(business.getNinteiShinseiKubunCode().getColumnValue().toString());
                row.setShinseiKubunShinseiji(new RString(NinteiShinseiKubunShinsei.toValue(ninteiShinseiKubun).name()));
            }
            if (business.getChikuCode() != null) {
                row.setChiku(business.getChikuCode().value());
            }
            row.setZenkaiChosaItakusaki(nullToEmpty(business.getTemp_jigyoshaMeisho()));
            row.setZenkaiNinteiChosainShimei(nullToEmpty(business.getTemp_chosainShimei()));
            row.setHokensha(nullToEmpty(hokenshaName));
            if (business.getChosaKubun() != null) {
                row.setChosaKubun(ChosaKubun.toValue(business.getChosaKubun().value()).get名称());
            }
            if (business.getJusho() != null) {
                row.setJusho(business.getJusho().value());
            }
            row.setShujiiIryoKikan(nullToEmpty(business.getIryoKikanMeisho()));
            if (business.getShujiiName() != null) {
                row.setShujii(business.getShujiiName().value());
            }

            row.setZenkaiShujiiIryoKikan(nullToEmpty(business.getTemp_iryoKikanMeisho()));
            if (business.getTemp_shujiiName() != null) {
                row.setZenkaiShujii(business.getTemp_shujiiName().value());
            }

            row.setShinseishoKanriNo(nullToEmpty(business.getShinseishoKanriNo()));
            row.setNinteichosaIraiRirekiNo(new RString(String.valueOf(business.getNinteichosaIraiRirekiNo())));
            row.setKoroshoIfShikibetsuCode(
                    business.getKoroshoIfShikibetsuCode() == null ? RString.EMPTY : business.getKoroshoIfShikibetsuCode().value());
            setDgMiwaritsukeShinseishaIchiran_Row(row, business);
            dataSource.add(row);
        }
        div.getDgMiwaritsukeShinseishaIchiran().getFilterList().clear();
        div.getDgMiwaritsukeShinseishaIchiran().setDataSource(dataSource);
    }

    private void setDgMiwaritsukeShinseishaIchiran_Row(dgMiwaritsukeShinseishaIchiran_Row row, WaritsukeBusiness business) {
        row.setWaritsukeTeiin(new RString(String.valueOf(business.getWaritsukeTeiin())));
        row.setChosaKanoNinzuPerMonth(new RString(String.valueOf(business.getChosaKanoNinzuPerMonth())));
        if (business.getNinteichosaKigenYMD() != null) {
            row.setNinteichosaKigenYMD(new RString(business.getNinteichosaKigenYMD().toString()));
        }
        row.setHihokenshaKana(business.getHihokenshaKana() == null ? RString.EMPTY : business.getHihokenshaKana().value());
        if (business.getSeinengappiYMD() != null) {
            row.setSeinengappiYMD(new RString(business.getSeinengappiYMD().toString()));
        }
        row.setYubinNo(business.getYubinNo() == null ? RString.EMPTY : business.getYubinNo().value());
        row.setTelNo(business.getTelNo() == null ? RString.EMPTY : business.getTelNo().value());
        row.setHomonChosasakiYubinNo(
                business.getHomonChosasakiYubinNo() == null ? RString.EMPTY : business.getHomonChosasakiYubinNo().value());
        row.setHomonChosasakiJusho(business.getHomonChosasakiJusho() == null ? RString.EMPTY : business.getHomonChosasakiJusho().value());
        row.setHomonChosasakiName(business.getHomonChosasakiName() == null ? RString.EMPTY : business.getHomonChosasakiName().value());
        row.setHomonChosasakiTelNo(business.getHomonChosasakiTelNo() == null ? RString.EMPTY : business.getHomonChosasakiTelNo().value());
        if (business.getNinteiShinseiYMDKoShin() != null) {
            row.setNinteiShinseiYMDKoShin(new RString(business.getNinteiShinseiYMDKoShin().toString()));
        }
        if (business.getZenkaiNinteiYMD() != null) {
            row.setZenkaiNinteiYMD(new RString(business.getZenkaiNinteiYMD().toString()));
        }
        row.setZenYokaigoKubunCode(business.getZenYokaigoKubunCode() == null ? RString.EMPTY : business.getZenYokaigoKubunCode().value());
        row.setAge(new RString(String.valueOf(business.getAge())));
        row.setNinteiChosainCode(nullToEmpty(business.getNinteiChosainCode()));
    }

    /**
     * 未割付申請者一覧Gridに割付済み申請者を設定します。
     *
     * @param waritsukeZumiShinseishaRow 割付済み申請者
     */
    public void set未割付申請者一覧(dgWaritsukeZumiShinseishaIchiran_Row waritsukeZumiShinseishaRow) {
        dgMiwaritsukeShinseishaIchiran_Row row = new dgMiwaritsukeShinseishaIchiran_Row();
        RString jotai = waritsukeZumiShinseishaRow.getJotai();
        if (MIWARITSUKE.equals(jotai)) {
            row.setJotai(jotai);
        } else {
            row.setJotai(WARITSUKE_ZUMI);
        }

        row.setHihokenshaNo(waritsukeZumiShinseishaRow.getHihokenshaNo());
        row.setHihokenshaShimei(waritsukeZumiShinseishaRow.getHihokenshaShimei());
        row.setSeibetsu(waritsukeZumiShinseishaRow.getSeibetsu());
        row.setNinteiShinseiDay(waritsukeZumiShinseishaRow.getNinteiShinseiDay());
        row.setShinseiKubunShinseiji(waritsukeZumiShinseishaRow.getShinseiKubunShinseiji());
        row.setChiku(waritsukeZumiShinseishaRow.getChiku());
        row.setZenkaiChosaItakusaki(waritsukeZumiShinseishaRow.getZenkaiChosaItakusaki());
        row.setZenkaiNinteiChosainShimei(waritsukeZumiShinseishaRow.getZenkaiChosain());
        row.setHokensha(waritsukeZumiShinseishaRow.getHokensha());
        row.setChosaKubun(waritsukeZumiShinseishaRow.getChosaKubun());
        row.setJusho(waritsukeZumiShinseishaRow.getJusho());
        row.setShujiiIryoKikan(waritsukeZumiShinseishaRow.getShujiIryoKikan());
        row.setShujii(waritsukeZumiShinseishaRow.getShujii());
        row.setZenkaiShujiiIryoKikan(waritsukeZumiShinseishaRow.getZenkaiShujiIryoKikan());
        row.setZenkaiShujii(waritsukeZumiShinseishaRow.getZenkaiShujii());
        row.setChosaIraiDay(waritsukeZumiShinseishaRow.getChosaIraiDay());
        row.setIraishoShutsuryokuDay(waritsukeZumiShinseishaRow.getIraishoShutsuryokuDay());
        row.setChosahyoNadoShutsuryookuDay(waritsukeZumiShinseishaRow.getChosahyoNadoShutsuryookuDay());
        row.setNinteichosaKanryoYMD(waritsukeZumiShinseishaRow.getNinteichosaKanryoYMD());
        row.setShinseishoKanriNo(waritsukeZumiShinseishaRow.getShinseishoKanriNo());
        row.setNinteichosaIraiRirekiNo(waritsukeZumiShinseishaRow.getNinteichosaIraiRirekiNo());
        row.setKoroshoIfShikibetsuCode(waritsukeZumiShinseishaRow.getKoroshoIfShikibetsuCode());
        row.setWaritsukeTeiin(waritsukeZumiShinseishaRow.getWaritsukeTeiin());
        row.setChosaKanoNinzuPerMonth(waritsukeZumiShinseishaRow.getChosaKanoNinzuPerMonth());
        row.setNinteichosaKigenYMD(waritsukeZumiShinseishaRow.getNinteichosaKigenYMD());
        row.setHihokenshaKana(waritsukeZumiShinseishaRow.getHihokenshaKana());
        row.setSeinengappiYMD(waritsukeZumiShinseishaRow.getSeinengappiYMD());
        row.setYubinNo(waritsukeZumiShinseishaRow.getYubinNo());
        row.setTelNo(waritsukeZumiShinseishaRow.getTelNo());
        row.setHomonChosasakiYubinNo(waritsukeZumiShinseishaRow.getHomonChosasakiYubinNo());
        row.setHomonChosasakiJusho(waritsukeZumiShinseishaRow.getHomonChosasakiJusho());
        row.setHomonChosasakiName(waritsukeZumiShinseishaRow.getHomonChosasakiName());
        row.setHomonChosasakiTelNo(waritsukeZumiShinseishaRow.getHomonChosasakiTelNo());
        row.setNinteiShinseiYMDKoShin(waritsukeZumiShinseishaRow.getNinteiShinseiYMDKoShin());
        row.setZenkaiNinteiYMD(waritsukeZumiShinseishaRow.getZenkaiNinteiYMD());
        row.setZenYokaigoKubunCode(waritsukeZumiShinseishaRow.getZenYokaigoKubunCode());
        row.setAge(waritsukeZumiShinseishaRow.getAge());
        row.setNinteiChosainCode(waritsukeZumiShinseishaRow.getNinteiChosainCode());
        div.getDgMiwaritsukeShinseishaIchiran().getDataSource().add(row);
    }

    /**
     * 割付済み申請者一覧Gridに検索結果を設定します。
     *
     * @param 割付済み申請者一覧 割付済み申請者一覧検索結果
     * @param hokenshaName 保険者名称
     */
    public void set割付済み申請者一覧(List<WaritsukeBusiness> 割付済み申請者一覧, RString hokenshaName) {
        List<dgWaritsukeZumiShinseishaIchiran_Row> dataSource = new ArrayList<>();
        int i = 1;
        for (WaritsukeBusiness business : 割付済み申請者一覧) {
            dgWaritsukeZumiShinseishaIchiran_Row row = new dgWaritsukeZumiShinseishaIchiran_Row();
            TextBoxNum num = new TextBoxNum();
            num.setValue(new Decimal(i++));
            row.setNo(num);
            row.setJotai(RString.EMPTY);
            row.setHihokenshaNo(nullToEmpty(business.getHihokenshaNo()));
            row.setHihokenshaShimei(business.getHihokenshaName() == null ? RString.EMPTY : business.getHihokenshaName().value());
            if (business.getSeibetsu() != null && !RString.isNullOrEmpty(business.getSeibetsu().value())) {
                row.setSeibetsu(Seibetsu.toValue(business.getSeibetsu().value()).get名称());
            }
            if (business.getNinteiShinseiYMD() != null) {
                TextBoxDate ninteiShinseiDay = new TextBoxDate();
                ninteiShinseiDay.setValue(new RDate(business.getNinteiShinseiYMD().toString()));
                row.setNinteiShinseiDay(ninteiShinseiDay);
            }
            if (business.getNinteiShinseiKubunCode() != null) {
                int ninteiShinseiKubun = Integer.parseInt(business.getNinteiShinseiKubunCode().getColumnValue().toString());
                row.setShinseiKubunShinseiji(new RString(NinteiShinseiKubunShinsei.toValue(ninteiShinseiKubun).name()));
            }
            if (business.getChikuCode() != null) {
                row.setChiku(business.getChikuCode().value());
            }
            row.setZenkaiChosaItakusaki(nullToEmpty(business.getTemp_jigyoshaMeisho()));
            row.setZenkaiChosain(nullToEmpty(business.getTemp_chosainShimei()));

            if (business.getNinteichosaIraiYMD() != null) {
                row.setChosaIraiDay(business.getNinteichosaIraiYMD().wareki().toDateString());
            }
            if (business.getChosaKubun() != null) {
                row.setChosaKubun(ChosaKubun.toValue(business.getChosaKubun().value()).get名称());
            }

            row.setHokensha(nullToEmpty(hokenshaName));
            if (business.getJusho() != null) {
                row.setJusho(business.getJusho().value());
            }
            row.setShujiIryoKikan(nullToEmpty(business.getIryoKikanMeisho()));
            if (business.getShujiiName() != null) {
                row.setShujii(business.getShujiiName().value());
            }

            row.setZenkaiShujiIryoKikan(nullToEmpty(business.getTemp_iryoKikanMeisho()));
            if (business.getTemp_shujiiName() != null) {
                row.setZenkaiShujii(business.getTemp_shujiiName().value());
            }

            TextBoxDate iraishoShutsuryokuDay = new TextBoxDate();
            if (business.getIraishoShutsuryokuYMD() != null) {
                iraishoShutsuryokuDay.setValue(new RDate(business.getIraishoShutsuryokuYMD().toString()));
            }

            row.setIraishoShutsuryokuDay(iraishoShutsuryokuDay);
            TextBoxDate chosahyoNadoShutsuryookuDay = new TextBoxDate();
            if (business.getChosahyoTouShutsuryokuYMD() != null) {
                chosahyoNadoShutsuryookuDay.setValue(new RDate(business.getChosahyoTouShutsuryokuYMD().toString()));
            }

            row.setChosahyoNadoShutsuryookuDay(chosahyoNadoShutsuryookuDay);
            if (business.getNinteichosaKanryoYMD() != null) {
                row.setNinteichosaKanryoYMD(new RString(business.getNinteichosaKanryoYMD().toString()));
            }
            row.setShinseishoKanriNo(nullToEmpty(business.getShinseishoKanriNo()));
            row.setNinteichosaIraiRirekiNo(new RString(String.valueOf(business.getNinteichosaIraiRirekiNo())));
            row.setKoroshoIfShikibetsuCode(
                    business.getKoroshoIfShikibetsuCode() == null ? RString.EMPTY : business.getKoroshoIfShikibetsuCode().value());
            setDgWaritsukeZumiShinseishaIchiran_Row(row, business);
            dataSource.add(row);
        }
        div.getDgWaritsukeZumiShinseishaIchiran().getFilterList().clear();
        div.getDgWaritsukeZumiShinseishaIchiran().setDataSource(dataSource);
        div.getTxtChosaIraiDay().setValue(RDate.getNowDate());
    }

    private void setDgWaritsukeZumiShinseishaIchiran_Row(dgWaritsukeZumiShinseishaIchiran_Row row, WaritsukeBusiness business) {
        row.setWaritsukeTeiin(new RString(String.valueOf(business.getWaritsukeTeiin())));
        row.setChosaKanoNinzuPerMonth(new RString(String.valueOf(business.getChosaKanoNinzuPerMonth())));
        if (business.getNinteichosaKigenYMD() != null) {
            row.setNinteichosaKigenYMD(new RString(business.getNinteichosaKigenYMD().toString()));
        }
        row.setHihokenshaKana(business.getHihokenshaKana() == null ? RString.EMPTY : business.getHihokenshaKana().value());
        if (business.getSeinengappiYMD() != null) {
            row.setSeinengappiYMD(new RString(business.getSeinengappiYMD().toString()));
        }
        row.setYubinNo(business.getYubinNo() == null ? RString.EMPTY : business.getYubinNo().value());
        row.setTelNo(business.getTelNo() == null ? RString.EMPTY : business.getTelNo().value());
        row.setHomonChosasakiYubinNo(
                business.getHomonChosasakiYubinNo() == null ? RString.EMPTY : business.getHomonChosasakiYubinNo().value());
        row.setHomonChosasakiJusho(business.getHomonChosasakiJusho() == null ? RString.EMPTY : business.getHomonChosasakiJusho().value());
        row.setHomonChosasakiName(business.getHomonChosasakiName() == null ? RString.EMPTY : business.getHomonChosasakiName().value());
        row.setHomonChosasakiTelNo(business.getHomonChosasakiTelNo() == null ? RString.EMPTY : business.getHomonChosasakiTelNo().value());
        if (business.getNinteiShinseiYMDKoShin() != null) {
            row.setNinteiShinseiYMDKoShin(new RString(business.getNinteiShinseiYMDKoShin().toString()));
        }
        if (business.getZenkaiNinteiYMD() != null) {
            row.setZenkaiNinteiYMD(new RString(business.getZenkaiNinteiYMD().toString()));
        }
        row.setZenYokaigoKubunCode(business.getZenYokaigoKubunCode() == null ? RString.EMPTY : business.getZenYokaigoKubunCode().value());
        row.setAge(new RString(String.valueOf(business.getAge())));
        row.setNinteiChosainCode(nullToEmpty(business.getNinteiChosainCode()));
        row.setHokenshaNo(nullToEmpty(business.getHokenshaNo()));
        row.setNinteiChosaItakusakiCode(nullToEmpty(business.getNinteiChosaItakusakiCode()));
        row.setShichosonCode(nullToEmpty(business.getShichosonCode()));
        row.setRenrakusakiYubinNo(business.getRenrakusakiYubinNo() == null ? RString.EMPTY : business.getRenrakusakiYubinNo().value());
        row.setRenrakusakiTelNo(business.getRenrakusakiTelNo() == null ? RString.EMPTY : business.getRenrakusakiTelNo().value());
        row.setRenrakusakiKeitaiTelNo(business.getRenrakusakiKeitaiTelNo() == null ? RString.EMPTY : business.getRenrakusakiKeitaiTelNo().value());
        row.setRenrakusakiShimei(business.getRenrakusakiShimei() == null ? RString.EMPTY : business.getRenrakusakiShimei().value());
        row.setRenrakusakiTuzukigara(nullToEmpty(business.getRenrakusakiTuzukigara()));
        row.setRenrakusakiJusho(business.getRenrakusakiJusho() == null ? RString.EMPTY : business.getRenrakusakiJusho().value());
    }

    /**
     * 割付済み申請者一覧Gridに検索結果を設定します。
     *
     * @param miwaritsukeShinseishaRow 未割付申請者
     */
    public void set割付済み申請者一覧(dgMiwaritsukeShinseishaIchiran_Row miwaritsukeShinseishaRow) {
        dgWaritsukeZumiShinseishaIchiran_Row row = new dgWaritsukeZumiShinseishaIchiran_Row();
        RString jotai = miwaritsukeShinseishaRow.getJotai();
        if (WARITSUKE_ZUMI.equals(jotai)) {
            row.setJotai(jotai);
        } else {
            row.setJotai(MIWARITSUKE);
        }
        row.setHihokenshaNo(miwaritsukeShinseishaRow.getHihokenshaNo());
        row.setHihokenshaShimei(miwaritsukeShinseishaRow.getHihokenshaShimei());
        row.setSeibetsu(miwaritsukeShinseishaRow.getSeibetsu());
        row.setNinteiShinseiDay(miwaritsukeShinseishaRow.getNinteiShinseiDay());
        row.setShinseiKubunShinseiji(miwaritsukeShinseishaRow.getShinseiKubunShinseiji());
        row.setChiku(miwaritsukeShinseishaRow.getChiku());
        row.setZenkaiChosaItakusaki(miwaritsukeShinseishaRow.getZenkaiChosaItakusaki());
        row.setZenkaiChosain(miwaritsukeShinseishaRow.getZenkaiNinteiChosainShimei());
        row.setChosaIraiDay(miwaritsukeShinseishaRow.getChosaIraiDay());
        row.setChosaKubun(miwaritsukeShinseishaRow.getChosaKubun());
        row.setHokensha(miwaritsukeShinseishaRow.getHokensha());
        row.setJusho(miwaritsukeShinseishaRow.getJusho());
        row.setShujiIryoKikan(miwaritsukeShinseishaRow.getShujiiIryoKikan());
        row.setShujii(miwaritsukeShinseishaRow.getShujii());
        row.setZenkaiShujiIryoKikan(miwaritsukeShinseishaRow.getZenkaiShujiiIryoKikan());
        row.setZenkaiShujii(miwaritsukeShinseishaRow.getZenkaiShujii());
        row.setIraishoShutsuryokuDay(miwaritsukeShinseishaRow.getIraishoShutsuryokuDay());
        row.setChosahyoNadoShutsuryookuDay(miwaritsukeShinseishaRow.getChosahyoNadoShutsuryookuDay());
        row.setNinteichosaKanryoYMD(miwaritsukeShinseishaRow.getNinteichosaKanryoYMD());
        row.setShinseishoKanriNo(miwaritsukeShinseishaRow.getShinseishoKanriNo());
        row.setNinteichosaIraiRirekiNo(miwaritsukeShinseishaRow.getNinteichosaIraiRirekiNo());
        row.setKoroshoIfShikibetsuCode(miwaritsukeShinseishaRow.getKoroshoIfShikibetsuCode());
        row.setWaritsukeTeiin(miwaritsukeShinseishaRow.getWaritsukeTeiin());
        row.setChosaKanoNinzuPerMonth(miwaritsukeShinseishaRow.getChosaKanoNinzuPerMonth());
        row.setNinteichosaKigenYMD(miwaritsukeShinseishaRow.getNinteichosaKigenYMD());
        row.setHihokenshaKana(miwaritsukeShinseishaRow.getHihokenshaKana());
        row.setSeinengappiYMD(miwaritsukeShinseishaRow.getSeinengappiYMD());
        row.setYubinNo(miwaritsukeShinseishaRow.getYubinNo());
        row.setTelNo(miwaritsukeShinseishaRow.getTelNo());
        row.setHomonChosasakiYubinNo(miwaritsukeShinseishaRow.getHomonChosasakiYubinNo());
        row.setHomonChosasakiJusho(miwaritsukeShinseishaRow.getHomonChosasakiJusho());
        row.setHomonChosasakiName(miwaritsukeShinseishaRow.getHomonChosasakiName());
        row.setHomonChosasakiTelNo(miwaritsukeShinseishaRow.getHomonChosasakiTelNo());
        row.setNinteiShinseiYMDKoShin(miwaritsukeShinseishaRow.getNinteiShinseiYMDKoShin());
        row.setZenkaiNinteiYMD(miwaritsukeShinseishaRow.getZenkaiNinteiYMD());
        row.setZenYokaigoKubunCode(miwaritsukeShinseishaRow.getZenYokaigoKubunCode());
        row.setAge(miwaritsukeShinseishaRow.getAge());
        row.setNinteiChosainCode(miwaritsukeShinseishaRow.getNinteiChosainCode());
        div.getDgWaritsukeZumiShinseishaIchiran().getDataSource().add(row);
    }

    /**
     * 委託先基本情報に検索結果を設定します。
     *
     * @param row 認定調査委託先
     */
    public void set委託先基本情報(dgChosaItakusakiIchiran_Row row) {
        div.getTxtChosaItakusakiCode().setValue(row.getChosaItakusakiCode().getValue());
        div.getTxtChosaItakusakiMeisho().setValue(row.getChosaItakusakiMeisho());
        div.getTxtChosaItakusakiChiku().setValue(row.getChosaChiku());
        div.getTxtChosainCode().clearValue();
        div.getTxtChosainShimei().clearValue();
        div.getTxtChosainChiku().clearValue();
    }

    /**
     * 委託先基本情報に検索結果を設定します。
     *
     * @param row 認定調査委託先
     */
    public void set委託先基本情報(dgchosainIchiran_Row row) {
        div.getTxtChosainCode().setValue(row.getChosainCode().getValue());
        div.getTxtChosainShimei().setValue(row.getChosainShimei());
        div.getTxtChosainChiku().setValue(row.getChosaChiku());
    }

    /**
     * 割付済み申請者一覧Gridと未割付申請者一覧Gridの項番を設定します。
     *
     */
    public void initIndex() {

        List<dgMiwaritsukeShinseishaIchiran_Row> dgMiwaritsukeShinseishaIchiran = div.getDgMiwaritsukeShinseishaIchiran().getDataSource();

        int i = 1;
        for (dgMiwaritsukeShinseishaIchiran_Row row : dgMiwaritsukeShinseishaIchiran) {
            row.setNo(new RString(String.valueOf(i++)));
        }
        div.getDgMiwaritsukeShinseishaIchiran().setDataSource(dgMiwaritsukeShinseishaIchiran);
        List<dgWaritsukeZumiShinseishaIchiran_Row> dgWaritsukeZumiShinseisha = div.getDgWaritsukeZumiShinseishaIchiran().getDataSource();

        i = 1;
        for (dgWaritsukeZumiShinseishaIchiran_Row row : dgWaritsukeZumiShinseisha) {
            TextBoxNum num = new TextBoxNum();
            num.setValue(new Decimal(i++));
            row.setNo(num);
        }
        div.getDgWaritsukeZumiShinseishaIchiran().setDataSource(dgWaritsukeZumiShinseisha);
    }

    /**
     * 委託先基本情報に非活用/活用を設定します。
     *
     * @param disabled (true:非活用,false:活用)
     */
    public void setDisabledToChosaItakusakiAndChosainKihonJoho(boolean disabled) {
        div.getTxtChosaItakusakiCode().setDisabled(disabled);
        div.getTxtChosaItakusakiMeisho().setDisabled(disabled);
        div.getTxtChosaItakusakiChiku().setDisabled(disabled);
        div.getTxtChosainCode().setDisabled(disabled);
        div.getTxtChosainShimei().setDisabled(disabled);
        div.getTxtChosainChiku().setDisabled(disabled);
    }

    /**
     * 編集内容判断処理です。
     *
     * @return 判断結果（編集内容があるの場合:true、編集内容がなしの場合：false）
     */
    public boolean isUpdate() {
        boolean isUpdate = false;
        List<dgMiwaritsukeShinseishaIchiran_Row> dgMiwaritsukeShinseishaIchiran = div.getDgMiwaritsukeShinseishaIchiran().getDataSource();
        for (dgMiwaritsukeShinseishaIchiran_Row miwaritsukeShinseishaRow : dgMiwaritsukeShinseishaIchiran) {
            if (!RString.EMPTY.equals(miwaritsukeShinseishaRow.getJotai())) {
                isUpdate = true;
                break;
            }
        }
        List<dgWaritsukeZumiShinseishaIchiran_Row> dgWaritsukeZumiShinseisha = div.getDgWaritsukeZumiShinseishaIchiran().getDataSource();
        for (dgWaritsukeZumiShinseishaIchiran_Row waritsukeZumiShinseishaRow : dgWaritsukeZumiShinseisha) {
            if (!RString.EMPTY.equals(waritsukeZumiShinseishaRow.getJotai())) {
                isUpdate = true;
                break;
            }
        }
        return isUpdate;
    }

    /**
     * 編集内容判断処理です。
     *
     * @return 判断結果（編集内容があるの場合:true、編集内容がなしの場合：false）
     */
    public boolean isUpdateForHozon() {
        boolean isUpdate = false;
        List<dgMiwaritsukeShinseishaIchiran_Row> dgMiwaritsukeShinseishaIchiran = div.getDgMiwaritsukeShinseishaIchiran().getDataSource();
        for (dgMiwaritsukeShinseishaIchiran_Row miwaritsukeShinseishaRow : dgMiwaritsukeShinseishaIchiran) {
            if (WARITSUKE_ZUMI.equals(miwaritsukeShinseishaRow.getJotai())) {
                isUpdate = true;
                break;
            }
        }
        List<dgWaritsukeZumiShinseishaIchiran_Row> dgWaritsukeZumiShinseisha = div.getDgWaritsukeZumiShinseishaIchiran().getDataSource();
        for (dgWaritsukeZumiShinseishaIchiran_Row waritsukeZumiShinseishaRow : dgWaritsukeZumiShinseisha) {
            if (MIWARITSUKE.equals(waritsukeZumiShinseishaRow.getJotai())) {
                isUpdate = true;
                break;
            }
        }
        return isUpdate;
    }

    /**
     * 割付済み人数を取得します。
     *
     * @return 割付済み人数
     */
    public int get既存割付済み人数() {
        List<dgWaritsukeZumiShinseishaIchiran_Row> dgWaritsukeZumiShinseisha = div.getDgWaritsukeZumiShinseishaIchiran().getDataSource();
        int count = 0;
        for (dgWaritsukeZumiShinseishaIchiran_Row waritsukeZumiShinseisha : dgWaritsukeZumiShinseisha) {
            RString jotai = waritsukeZumiShinseisha.getJotai();
            if (RString.EMPTY.equals(jotai) || WARITSUKE_ZUMI.equals(jotai)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 印刷条件DIVの初期化処理です。
     *
     */
    public void init印刷条件DIV() {
        RString 認定調査期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (設定方法.equals(認定調査期限設定方法)) {
            div.getRadkigen().setDisabled(false);
        } else {
            div.getRadkigen().setDisabled(true);
        }
        RDate nowDate = RDate.getNowDate();
        div.getTxthokkoymd().setValue(nowDate);
        div.getTxtkigenymd().setValue(nowDate);
    }

    /**
     * 認定調査依頼書印刷用パラメータを作成します。
     *
     * @return 認定調査依頼書印刷用パラメータ
     */
    public List<ChosaIraishoHeadItem> create認定調査依頼書印刷用パラメータ() {
        List<dgWaritsukeZumiShinseishaIchiran_Row> selectedItems = div.getDgWaritsukeZumiShinseishaIchiran().getSelectedItems();
        List<ChosaIraishoHeadItem> chosaIraishoHeadItemList = new ArrayList<>();
        for (dgWaritsukeZumiShinseishaIchiran_Row row : selectedItems) {
            List<RString> 被保険者番号リスト = get被保険者番号(row.getHihokenshaNo());
            RString 誕生日明治 = HOUSI;
            RString 誕生日大正 = HOUSI;
            RString 誕生日昭和 = HOUSI;
            RDate seinengappiYMD = new RDate(row.getSeinengappiYMD().toString());
            RString era = seinengappiYMD.wareki().eraType(EraType.KANJI).getEra();

            if (元号_明治.equals(era)) {
                誕生日明治 = RString.EMPTY;
            } else if (元号_大正.equals(era)) {
                誕生日大正 = RString.EMPTY;
            } else if (元号_昭和.equals(era)) {
                誕生日昭和 = RString.EMPTY;
            }
            RString seibetsu = row.getSeibetsu();
            RString 性別男 = RString.EMPTY;
            RString 性別女 = RString.EMPTY;

            if (Seibetsu.男.get名称().equals(seibetsu)) {
                性別女 = HOUSI;
            } else {
                性別男 = HOUSI;
            }
            ChosainJoho 調査員情報 = new ChosainJohoManager().get調査員情報(new LasdecCode(row.getShichosonCode()),
                    new ChosaItakusakiCode(row.getNinteiChosaItakusakiCode()),
                    new ChosainCode(row.getNinteiChosainCode()));
            Map<Integer, RString> 通知文
                    = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE220001.getReportId(), KamokuCode.EMPTY, 1);
            RString homonChosasakiJusho = row.getHomonChosasakiJusho();
            YubinNo 郵便番号 = 調査員情報.get郵便番号();
            AtenaJusho 住所 = 調査員情報.get住所();
            ChosaIraishoHeadItem item = new ChosaIraishoHeadItem(
                    div.getTxthokkoymd().getValue().toDateString(),
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    郵便番号 == null ? RString.EMPTY : 郵便番号.value(),
                    住所 == null ? RString.EMPTY : 住所.value(),
                    調査員情報.get所属機関名称(),
                    調査員情報.get調査員氏名(),
                    get名称付与(),
                    getカスタマーバーコード(調査員情報),
                    RString.EMPTY,
                    ConfigNameDBE.認定調査依頼書.get名称(),
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
                    row.getHihokenshaKana(),
                    誕生日明治,
                    誕生日大正,
                    誕生日昭和,
                    seinengappiYMD.wareki().toDateString(),
                    row.getHihokenshaShimei(),
                    性別男,
                    性別女,
                    editYubinNoToIchiran(row.getYubinNo()),
                    row.getJusho(),
                    row.getTelNo(),
                    row.getHomonChosasakiYubinNo(),
                    homonChosasakiJusho,
                    row.getHomonChosasakiName(),
                    row.getHomonChosasakiTelNo(),
                    row.getNinteiShinseiYMDKoShin(),
                    row.getNinteichosaKigenYMD(),
                    通知文.get(2)
            );
            chosaIraishoHeadItemList.add(item);
        }
        return chosaIraishoHeadItemList;
    }

    private RString getカスタマーバーコード(ChosainJoho 調査員情報) {
        RString カスタマーバーコード = RString.EMPTY;
        CustomerBarCode barCode = new CustomerBarCode();
        YubinNo 郵便番号 = 調査員情報.get郵便番号();
        AtenaJusho 住所 = 調査員情報.get住所();
        if (郵便番号 != null && 住所 != null) {
            CustomerBarCodeResult result = barCode.convertCustomerBarCode(郵便番号.value(), 住所.value());
            if (result != null) {
                カスタマーバーコード = result.getCustomerBarCode();
            }
        }
        return カスタマーバーコード;
    }

    private RString get名称付与() {
        RString key = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成依頼書_宛先敬称, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
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

    /**
     * 認定調査票_概況調査印刷用パラメータを作成します。
     *
     * @return 認定調査票_概況調査パラメータ
     */
    public List<ChosahyoGaikyochosaItem> create認定調査票_概況調査パラメータ() {
        List<ChosahyoGaikyochosaItem> itemList = new ArrayList<>();
        List<dgWaritsukeZumiShinseishaIchiran_Row> selectedItems = div.getDgWaritsukeZumiShinseishaIchiran().getSelectedItems();
        for (dgWaritsukeZumiShinseishaIchiran_Row row : selectedItems) {
            RString ninteiShinseiDay = row.getNinteiShinseiDay().getValue().wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.ICHI_NEN)
                    .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
            List<RString> 保険者番号リスト = get被保険者番号(row.getHokenshaNo());
            List<RString> 被保険者番号リスト = get被保険者番号(row.getHihokenshaNo());
            List<RString> 認定調査員コードリスト = get認定調査員コード(row.getNinteiChosainCode());
            List<RString> 認定調査委託先コードリスト = get認定調査委託先コード(row.getNinteiChosaItakusakiCode());
            RString 生年月日 = row.getSeinengappiYMD();
            RString 年号 = new FlexibleDate(生年月日).wareki().eraType(EraType.KANJI).toDateString();
            RString 前回認定年月日 = row.getZenkaiNinteiYMD();
            RString 前回要介護状態区分コード = row.getZenYokaigoKubunCode();
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
                    div.getTxtChosainShimei().getValue(),
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
                    row.getZenkaiChosaItakusaki(),
                    row.getHihokenshaKana(),
                    row.getHihokenshaShimei(),
                    Seibetsu.男.get名称().equals(row.getSeibetsu()) ? 記号 : RString.EMPTY,
                    Seibetsu.女.get名称().equals(row.getSeibetsu()) ? 記号 : RString.EMPTY,
                    row.getJusho(),
                    row.getYubinNo(),
                    row.getTelNo(),
                    年号.startsWith(元号_明治) ? 記号 : RString.EMPTY,
                    年号.startsWith(元号_大正) ? 記号 : RString.EMPTY,
                    年号.startsWith(元号_昭和) ? 記号 : RString.EMPTY,
                    年号.substring(2, INDEX_4),
                    年号.substring(INDEX_5, INDEX_7),
                    年号.substring(INDEX_8),
                    row.getAge(),
                    row.getRenrakusakiJusho(),
                    row.getRenrakusakiYubinNo(),
                    row.getRenrakusakiTelNo(),
                    row.getRenrakusakiKeitaiTelNo(),
                    row.getRenrakusakiShimei(),
                    row.getRenrakusakiTuzukigara(),
                    RString.isNullOrEmpty(前回認定年月日) ? 記号 : RString.EMPTY,
                    !RString.isNullOrEmpty(前回認定年月日) ? 記号 : RString.EMPTY,
                    !RString.isNullOrEmpty(前回認定年月日) ? 前回認定年月日.substring(0, INDEX_4) : RString.EMPTY,
                    !RString.isNullOrEmpty(前回認定年月日) ? 前回認定年月日.substring(INDEX_4, INDEX_6) : RString.EMPTY,
                    !RString.isNullOrEmpty(前回認定年月日) ? 前回認定年月日.substring(INDEX_6, INDEX_8) : RString.EMPTY,
                    YOKAIGOJOTAIKUBUN01.equals(前回要介護状態区分コード) ? 記号 : RString.EMPTY,
                    要支援,
                    get要支援詳細(前回要介護状態区分コード),
                    get要介護(前回要介護状態区分コード),
                    get要介護詳細(前回要介護状態区分コード));
            itemList.add(item);
        }
        return itemList;
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

    /**
     * 認定調査票_基本調査印刷用パラメータを作成します。
     *
     * @return 認定調査票_基本調査パラメータ
     */
    public List<ChosahyoKihonchosaKatamenItem> create認定調査票_基本調査パラメータ() {
        List<ChosahyoKihonchosaKatamenItem> itemList = new ArrayList<>();
        List<dgWaritsukeZumiShinseishaIchiran_Row> selectedItems = div.getDgWaritsukeZumiShinseishaIchiran().getSelectedItems();

        for (dgWaritsukeZumiShinseishaIchiran_Row row : selectedItems) {
            RString ninteiShinseiDay = row.getNinteiShinseiDay().getValue().wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.ICHI_NEN)
                    .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
            List<RString> 証記載保険者番号リスト = get被保険者番号(row.getHokenshaNo());
            List<RString> 被保険者番号リスト = get被保険者番号(row.getHihokenshaNo());
            ChosahyoKihonchosaKatamenItem item = new ChosahyoKihonchosaKatamenItem(
                    ninteiShinseiDay.substring(1, 2),
                    ninteiShinseiDay.substring(2, INDEX_3),
                    ninteiShinseiDay.substring(INDEX_4, INDEX_5),
                    ninteiShinseiDay.substring(INDEX_5, INDEX_6),
                    ninteiShinseiDay.substring(INDEX_7, INDEX_8),
                    ninteiShinseiDay.substring(INDEX_8),
                    証記載保険者番号リスト.get(0),
                    証記載保険者番号リスト.get(1),
                    証記載保険者番号リスト.get(2),
                    証記載保険者番号リスト.get(INDEX_3),
                    証記載保険者番号リスト.get(INDEX_4),
                    証記載保険者番号リスト.get(INDEX_5),
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
            itemList.add(item);
        }
        return itemList;
    }

    /**
     * 認定調査票_特記事項印刷用パラメータを作成します。
     *
     * @return 認定調査票_特記事項パラメータ
     */
    public List<ChosahyoTokkijikoBusiness> create認定調査票_特記事項パラメータ() {
        List<ChosahyoTokkijikoBusiness> itemList = new ArrayList<>();
        List<dgWaritsukeZumiShinseishaIchiran_Row> selectedItems = div.getDgWaritsukeZumiShinseishaIchiran().getSelectedItems();

        for (dgWaritsukeZumiShinseishaIchiran_Row row : selectedItems) {
            RString ninteiShinseiDay = row.getNinteiShinseiDay().getValue().wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.ICHI_NEN)
                    .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
            List<RString> 証記載保険者番号リスト = get被保険者番号(row.getHokenshaNo());
            List<RString> 被保険者番号リスト = get被保険者番号(row.getHihokenshaNo());
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
                    row.getHihokenshaShimei());
            itemList.add(item);
        }
        return itemList;
    }

    /**
     * 認定調査票_特記事項_フリー様式印刷用パラメータを作成します。
     *
     * @return 認定調査票_特記事項_フリー様式パラメータ
     */
    public List<ChosahyoTokkijikoBusiness> create認定調査票_特記事項_フリー様式パラメータ() {
        List<ChosahyoTokkijikoBusiness> itemList = new ArrayList<>();
        List<dgWaritsukeZumiShinseishaIchiran_Row> selectedItems = div.getDgWaritsukeZumiShinseishaIchiran().getSelectedItems();
        for (dgWaritsukeZumiShinseishaIchiran_Row row : selectedItems) {
            List<RString> 保険者番号リスト = get被保険者番号(row.getHokensha());
            List<RString> 被保険者番号リスト = get被保険者番号(row.getHihokenshaNo());
            RString ninteiShinseiDay = row.getNinteiShinseiDay().getValue().wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.ICHI_NEN)
                    .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
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
                    row.getHihokenshaShimei());
            itemList.add(item);
        }
        return itemList;
    }

    /**
     * 要介護認定調査票差異チェック票印刷用パラメータを作成します。
     *
     * @return 要介護認定調査票差異チェック票パラメータ
     */
    public List<SaiChekkuhyoItem> create調査票差異チェック票_DBE292001パラメータ() {
        List<SaiChekkuhyoItem> itemList = new ArrayList<>();
        List<dgWaritsukeZumiShinseishaIchiran_Row> selectedItems = div.getDgWaritsukeZumiShinseishaIchiran().getSelectedItems();
        NinnteiChousairaiFinder ninnteiChousairaiFinder = NinnteiChousairaiFinder.createInstance();
        for (dgWaritsukeZumiShinseishaIchiran_Row row : selectedItems) {
            List<SaiChekkuhyoBusiness> businessList = ninnteiChousairaiFinder.get認定調査票差異チェック票情報(SaiChekkuhyoParameter.createParam(
                    ShoriJotaiKubun.通常.getコード(),
                    ShoriJotaiKubun.延期.getコード(),
                    row.getShinseishoKanriNo())).records();
            Map<RString, RString> 前回連番Map = new HashMap();
            editSaiChekkuhyoBusiness(businessList, 前回連番Map);
            RString 前回一次判定結果 = RString.EMPTY;
            RString 前回二次判定結果 = RString.EMPTY;
            RString 二次判定年月日 = RString.EMPTY;
            RString 前回認知症高齢者自立度 = RString.EMPTY;
            RString 前回障害高齢者自立度 = RString.EMPTY;
            if (!businessList.isEmpty()) {
                前回一次判定結果 = get判定結果(row.getKoroshoIfShikibetsuCode(), businessList.get(0).getIchijiHanteiKekkaCode());
                前回二次判定結果 = get判定結果(row.getKoroshoIfShikibetsuCode(), businessList.get(0).getNijiHanteiYokaigoJotaiKubun());
                二次判定年月日 = new RString(businessList.get(0).getNijiHanteiYMD().toString());
                前回認知症高齢者自立度 = businessList.get(0).getNinchishoSeikatsuJiritsudo();
                前回障害高齢者自立度 = businessList.get(0).getShogaiSeikatsuJiritsudo();
            }
            itemList.add(new SaiChekkuhyoItem(
                    前回一次判定結果,
                    row.getHihokenshaNo(),
                    row.getHihokenshaShimei(),
                    row.getAge(),
                    前回二次判定結果,
                    二次判定年月日,
                    row.getSeinengappiYMD(),
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
                    前回認知症高齢者自立度,
                    前回障害高齢者自立度
            ));
        }
        return itemList;
    }

    /**
     * 要介護認定調査票差異チェック票印刷用パラメータを作成します。
     *
     * @return 要介護認定調査票差異チェック票パラメータ
     */
    public List<SaiChekkuhyoItem> create調査票差異チェック票_DBE292004パラメータ() {
        List<SaiChekkuhyoItem> itemList = new ArrayList<>();
        List<dgWaritsukeZumiShinseishaIchiran_Row> selectedItems = div.getDgWaritsukeZumiShinseishaIchiran().getSelectedItems();
        NinnteiChousairaiFinder ninnteiChousairaiFinder = NinnteiChousairaiFinder.createInstance();
        for (dgWaritsukeZumiShinseishaIchiran_Row row : selectedItems) {
            List<SaiChekkuhyoBusiness> businessList = ninnteiChousairaiFinder.get認定調査票差異チェック票情報(SaiChekkuhyoParameter.createParam(
                    ShoriJotaiKubun.通常.getコード(),
                    ShoriJotaiKubun.延期.getコード(),
                    row.getShinseishoKanriNo())).records();
            Map<RString, RString> 前回連番Map = new HashMap();
            editSaiChekkuhyoBusiness(businessList, 前回連番Map);
            RString 前回認知症高齢者自立度 = RString.EMPTY;
            RString 前回障害高齢者自立度 = RString.EMPTY;
            if (!businessList.isEmpty()) {
                前回認知症高齢者自立度 = businessList.get(0).getNinchishoSeikatsuJiritsudo();
                前回障害高齢者自立度 = businessList.get(0).getShogaiSeikatsuJiritsudo();
            }
            RString 前回一次判定結果 = RString.EMPTY;
            RString 前回二次判定結果 = RString.EMPTY;
            RString 二次判定年月日 = RString.EMPTY;
            if (!businessList.isEmpty()) {
                前回一次判定結果 = get判定結果(row.getKoroshoIfShikibetsuCode(), businessList.get(0).getIchijiHanteiKekkaCode());
                前回二次判定結果 = get判定結果(row.getKoroshoIfShikibetsuCode(), businessList.get(0).getNijiHanteiYokaigoJotaiKubun());
                二次判定年月日 = new RString(businessList.get(0).getNijiHanteiYMD().toString());
            }
            itemList.add(new SaiChekkuhyoItem(
                    前回一次判定結果,
                    row.getHihokenshaNo(),
                    row.getHihokenshaShimei(),
                    row.getAge(),
                    前回二次判定結果,
                    二次判定年月日,
                    row.getSeinengappiYMD(),
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
                    前回認知症高齢者自立度,
                    前回障害高齢者自立度
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

    private void editSaiChekkuhyoBusiness(List<SaiChekkuhyoBusiness> businessList, Map<RString, RString> 前回連番Map) {
        for (SaiChekkuhyoBusiness business : businessList) {
            前回連番Map.put(business.getRemban(), business.getResearchItem());
        }
    }

    private RString editYubinNoToIchiran(RString yubinNo) {
        RStringBuilder yubinNoSb = new RStringBuilder();
        if (INDEX_3 <= yubinNo.length()) {
            yubinNoSb.append(yubinNo.substring(0, INDEX_3));
            yubinNoSb.append(ハイフン);
            yubinNoSb.append(yubinNo.substring(INDEX_3));
        } else {
            yubinNoSb.append(yubinNo);
        }
        return yubinNoSb.toRString();
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

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        } else {
            return obj;
        }
    }
}
