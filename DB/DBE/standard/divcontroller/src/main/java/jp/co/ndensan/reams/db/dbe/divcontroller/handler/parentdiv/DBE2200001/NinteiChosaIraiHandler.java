package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2200001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.NinnteiChousairaiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.WaritsukeBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaisho.ChosaIraishoHeadItem;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.shinsei.ChosaKubun;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.NinteiChosaIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgChosaItakusakiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgMiwaritsukeShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgWaritsukeZumiShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgchosainIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 認定調査員マスタ画面のハンドラークラスです。
 */
public class NinteiChosaIraiHandler {

    private static final RString 設定方法 = new RString("1");
    private static final CodeShubetsu CHIKU_CODE_SHUBETSU = new CodeShubetsu("5001");
    private static final RString WARITSUKE_ZUMI = new RString("割付済み");
    private static final RString MIWARITSUKE = new RString("未割付");
    private static final RString 元号_明治 = new RString("明治");
    private static final RString 元号_大正 = new RString("大正");
    private static final RString 元号_昭和 = new RString("昭和");
    private static final RString HOUSI = new RString("*");
    private static final RString ハイフン = new RString("-");
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private static final int INDEX_9 = 9;
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
     */
    public void load() {
        div.getCcdHokenshaList().loadHokenshaList();
        div.getTxtChosaItakusakiCode().clearValue();
        div.getTxtChosaItakusakiMeisho().clearValue();
        div.getTxtChosaItakusakiChiku().clearValue();
        div.getTxtChosainCode().clearValue();
        div.getTxtChosainShimei().clearValue();
        div.getTxtChosainChiku().clearValue();
        setDisabledToChosaItakusakiAndChosainKihonJoho(true);
        if (is単一保険者()) {
            div.getCcdHokenshaList().setDisabled(true);
        } else {
            div.getCcdHokenshaList().setDisabled(false);
        }
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
     */
    public void set認定調査委託先一覧(List<NinnteiChousairaiBusiness> 認定調査委託先List) {
        List<dgChosaItakusakiIchiran_Row> dataSource = new ArrayList<>();
        RString 市町村コード = div.getCcdHokenshaList().getSelectedItem().get市町村コード().value();
        RString 市町村名称 = div.getCcdHokenshaList().getSelectedItem().get市町村名称();
        for (NinnteiChousairaiBusiness business : 認定調査委託先List) {
            dgChosaItakusakiIchiran_Row row = new dgChosaItakusakiIchiran_Row();
            TextBoxCode chosaItakusakiCode = new TextBoxCode();
            chosaItakusakiCode.setValue(nullToEmpty(business.getNinteichosaItakusakiCode()));
            row.setChosaItakusakiCode(chosaItakusakiCode);
            row.setChosaItakusakiMeisho(nullToEmpty(business.getJigyoshaMeisho()));
            UzT0007CodeEntity codeEntity = null;
            if (business.getWaritsukeChiku() != null) {
                codeEntity = CodeMaster.getCode(
                        SubGyomuCode.DBE認定支援,
                        CHIKU_CODE_SHUBETSU,
                        new Code(business.getWaritsukeChiku().value()));
            }

            if (codeEntity != null) {
                row.setChosaChiku(nullToEmpty(codeEntity.getコード名称()));
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
        List<dgWaritsukeZumiShinseishaIchiran_Row> dgWaritsukeZumiShinseishaIchiran = div.getDgWaritsukeZumiShinseishaIchiran().getDataSource();
        for (dgWaritsukeZumiShinseishaIchiran_Row waritsukeZumiShinseishaRow : dgWaritsukeZumiShinseishaIchiran) {
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
        for (dgWaritsukeZumiShinseishaIchiran_Row waritsukeZumiShinseishaIchiran_Row : dgWaritsukeZumiShinseisha) {
            RString jotai = waritsukeZumiShinseishaIchiran_Row.getJotai();
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
        RString 認定調査期限設定方法 = BusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, SubGyomuCode.DBE認定支援);
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
        int renban = 1;
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
            // TODO 内部QA：467 Redmine：#73861(CompToiawasesaki．出力項目．通知文 取得方式が知らない)
            ChosaIraishoHeadItem item = new ChosaIraishoHeadItem(RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
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
                    row.getHomonChosasakiJusho(),
                    row.getHomonChosasakiJusho(),
                    row.getHomonChosasakiName(),
                    row.getHomonChosasakiTelNo(),
                    row.getNinteiShinseiYMDKoShin(),
                    row.getNinteichosaKigenYMD(),
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    new RString(String.valueOf(renban++)));
            chosaIraishoHeadItemList.add(item);
        }
        return chosaIraishoHeadItemList;
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

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        } else {
            return obj;
        }
    }
}
