package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2200001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.NinnteiChousairaiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.WaritsukeBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaisho.ChosaIraishoHeadItem;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei.ChosaKubun;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.NinteiChosaIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgChosaItakusakiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgMiwaritsukeShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgWaritsukeZumiShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgchosainIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.DonyukeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.NinteiShinseiKubunShinsei;
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
            div.getCcdHokenshaList().setDisabled(false);
        } else {
            div.getCcdHokenshaList().setDisabled(true);
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
        if (DonyukeitaiCode.事務単一.getCode().equals(導入形態コード)
                || DonyukeitaiCode.認定単一.getCode().equals(導入形態コード)) {
            return true;
        } else {
            return false;
        }
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
            // TODO
            row.setHokenshaCode(nullToEmpty(市町村コード));
            row.setHokenshaName(nullToEmpty(市町村名称));
            dataSource.add(row);
        }
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
            if (business.getTemp_shujiiName() != null) {
                row.setZenkaiChosaItakusaki(business.getTemp_shujiiName().value());
            }
            row.setZenkaiNinteiChosainShimei(nullToEmpty(business.getTemp_chosainShimei()));
            row.setHokensha(hokenshaName);
            if (business.getChosaKubun() != null) {
                row.setChosaKubun(ChosaKubun.toValue(business.getChosaKubun().value()).getコード());
            }
            if (business.getJusho() != null) {
                row.setJusho(business.getJusho().value());
            }
            row.setShujiiIryoKikan(nullToEmpty(business.getIryoKikanMeisho()));
            if (business.getShujiiName() != null) {
                row.setShujii(business.getShujiiName().value());
            }

            row.setZenkaiShujiiIryoKikan(nullToEmpty(business.getTemp_jigyoshaMeisho()));
            row.setZenkaiShujii(nullToEmpty(business.getTemp_iryoKikanMeisho()));
            row.setShinseishoKanriNo(nullToEmpty(business.getShinseishoKanriNo()));
            row.setNinteichosaIraiRirekiNo(new RString(String.valueOf(business.getNinteichosaIraiRirekiNo())));
            row.setKoroshoIfShikibetsuCode(
                    business.getKoroshoIfShikibetsuCode() == null ? RString.EMPTY : business.getKoroshoIfShikibetsuCode().value());
            row.setWaritsukeTeiin(new RString(String.valueOf(business.getWaritsukeTeiin())));
            row.setChosaKanoNinzuPerMonth(new RString(String.valueOf(business.getChosaKanoNinzuPerMonth())));
            if (business.getNinteichosaKigenYMD() != null) {
                row.setNinteichosaKigenYMD(new RString(business.getNinteichosaKigenYMD().toString()));
            }
            if (business.getHihokenshaKana() != null) {
                row.setHihokenshaKana(business.getHihokenshaKana().value());
            }
            if (business.getSeinengappiYMD() != null) {
                row.setSeinengappiYMD(new RString(business.getSeinengappiYMD().toString()));
            }
            if (business.getYubinNo() != null) {
                row.setYubinNo(business.getYubinNo().value());
            }
            if (business.getTelNo() != null) {
                row.setTelNo(business.getTelNo().value());
            }
            if (business.getHomonChosasakiYubinNo() != null) {
                row.setHomonChosasakiYubinNo(business.getHomonChosasakiYubinNo().value());
            }
            if (business.getHomonChosasakiJusho() != null) {
                row.setHomonChosasakiJusho(business.getHomonChosasakiJusho().value());
            }
            if (business.getHomonChosasakiName() != null) {
                row.setHomonChosasakiName(business.getHomonChosasakiName().value());
            }
            if (business.getHomonChosasakiTelNo() != null) {
                row.setHomonChosasakiTelNo(business.getHomonChosasakiTelNo().value());
            }
            if (business.getNinteiShinseiYMDKoShin() != null) {
                row.setNinteiShinseiYMDKoShin(new RString(business.getNinteiShinseiYMDKoShin().toString()));
            }
            if (business.getZenkaiNinteiYMD() != null) {
                row.setZenkaiNinteiYMD(new RString(business.getZenkaiNinteiYMD().toString()));
            }
            if (business.getZenYokaigoKubunCode() != null) {
                row.setZenYokaigoKubunCode(business.getZenYokaigoKubunCode().value());
            }
            row.setAge(new RString(String.valueOf(business.getAge())));

            dataSource.add(row);
        }
        div.getDgMiwaritsukeShinseishaIchiran().setDataSource(dataSource);
    }

    /**
     * 未割付申請者一覧Gridに割付済み申請者を設定します。
     *
     * @param waritsukeZumiShinseishaIchiranRow 割付済み申請者
     */
    public void set未割付申請者一覧(dgWaritsukeZumiShinseishaIchiran_Row waritsukeZumiShinseishaIchiranRow) {
        dgMiwaritsukeShinseishaIchiran_Row row = new dgMiwaritsukeShinseishaIchiran_Row();
        RString jotai = waritsukeZumiShinseishaIchiranRow.getJotai();
        if (MIWARITSUKE.equals(jotai)) {
            row.setJotai(jotai);
        } else {
            row.setJotai(WARITSUKE_ZUMI);
        }

        row.setHihokenshaNo(waritsukeZumiShinseishaIchiranRow.getHihokenshaNo());
        row.setHihokenshaShimei(waritsukeZumiShinseishaIchiranRow.getHihokenshaShimei());
        row.setSeibetsu(waritsukeZumiShinseishaIchiranRow.getSeibetsu());
        row.setNinteiShinseiDay(waritsukeZumiShinseishaIchiranRow.getNinteiShinseiDay());
        row.setShinseiKubunShinseiji(waritsukeZumiShinseishaIchiranRow.getShinseiKubunShinseiji());
        row.setChiku(waritsukeZumiShinseishaIchiranRow.getChiku());
        row.setZenkaiChosaItakusaki(waritsukeZumiShinseishaIchiranRow.getZenkaiChosaItakusaki());
        row.setZenkaiNinteiChosainShimei(waritsukeZumiShinseishaIchiranRow.getZenkaiChosain());
        row.setHokensha(waritsukeZumiShinseishaIchiranRow.getHokensha());
        row.setChosaKubun(waritsukeZumiShinseishaIchiranRow.getChosaKubun());
        row.setJusho(waritsukeZumiShinseishaIchiranRow.getJusho());
        row.setShujiiIryoKikan(waritsukeZumiShinseishaIchiranRow.getShujiIryoKikan());
        row.setShujii(waritsukeZumiShinseishaIchiranRow.getShujii());
        row.setZenkaiShujiiIryoKikan(waritsukeZumiShinseishaIchiranRow.getZenkaiShujiIryoKikan());
        row.setZenkaiShujii(waritsukeZumiShinseishaIchiranRow.getZenkaiShujii());
        row.setChosaIraiDay(waritsukeZumiShinseishaIchiranRow.getChosaIraiDay());
        row.setIraishoShutsuryokuDay(waritsukeZumiShinseishaIchiranRow.getIraishoShutsuryokuDay());
        row.setChosahyoNadoShutsuryookuDay(waritsukeZumiShinseishaIchiranRow.getChosahyoNadoShutsuryookuDay());
        row.setNinteichosaKanryoYMD(waritsukeZumiShinseishaIchiranRow.getNinteichosaKanryoYMD());
        row.setShinseishoKanriNo(waritsukeZumiShinseishaIchiranRow.getShinseishoKanriNo());
        row.setNinteichosaIraiRirekiNo(waritsukeZumiShinseishaIchiranRow.getNinteichosaIraiRirekiNo());
        row.setKoroshoIfShikibetsuCode(waritsukeZumiShinseishaIchiranRow.getKoroshoIfShikibetsuCode());
        row.setWaritsukeTeiin(waritsukeZumiShinseishaIchiranRow.getWaritsukeTeiin());
        row.setChosaKanoNinzuPerMonth(waritsukeZumiShinseishaIchiranRow.getChosaKanoNinzuPerMonth());
        row.setNinteichosaKigenYMD(waritsukeZumiShinseishaIchiranRow.getNinteichosaKigenYMD());
        row.setHihokenshaKana(waritsukeZumiShinseishaIchiranRow.getHihokenshaKana());
        row.setSeinengappiYMD(waritsukeZumiShinseishaIchiranRow.getSeinengappiYMD());
        row.setYubinNo(waritsukeZumiShinseishaIchiranRow.getYubinNo());
        row.setTelNo(waritsukeZumiShinseishaIchiranRow.getTelNo());
        row.setHomonChosasakiYubinNo(waritsukeZumiShinseishaIchiranRow.getHomonChosasakiYubinNo());
        row.setHomonChosasakiJusho(waritsukeZumiShinseishaIchiranRow.getHomonChosasakiJusho());
        row.setHomonChosasakiName(waritsukeZumiShinseishaIchiranRow.getHomonChosasakiName());
        row.setHomonChosasakiTelNo(waritsukeZumiShinseishaIchiranRow.getHomonChosasakiTelNo());
        row.setNinteiShinseiYMDKoShin(waritsukeZumiShinseishaIchiranRow.getNinteiShinseiYMDKoShin());
        row.setZenkaiNinteiYMD(waritsukeZumiShinseishaIchiranRow.getZenkaiNinteiYMD());
        row.setZenYokaigoKubunCode(waritsukeZumiShinseishaIchiranRow.getZenYokaigoKubunCode());
        row.setAge(waritsukeZumiShinseishaIchiranRow.getAge());
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
            if (business.getTemp_shujiiName() != null) {
                row.setZenkaiChosaItakusaki(business.getTemp_shujiiName().value());
            }
            row.setZenkaiChosain(nullToEmpty(business.getTemp_chosainShimei()));

            if (business.getNinteichosaIraiYMD() != null) {
                row.setChosaIraiDay(business.getNinteichosaIraiYMD().wareki().toDateString());
            }
            if (business.getChosaKubun() != null) {
                row.setChosaKubun(ChosaKubun.toValue(business.getChosaKubun().value()).getコード());
            }

            row.setHokensha(hokenshaName);
            if (business.getJusho() != null) {
                row.setJusho(business.getJusho().value());
            }
            row.setShujiIryoKikan(nullToEmpty(business.getIryoKikanMeisho()));
            if (business.getShujiiName() != null) {
                row.setShujii(business.getShujiiName().value());
            }

            row.setZenkaiShujiIryoKikan(nullToEmpty(business.getTemp_jigyoshaMeisho()));
            row.setZenkaiShujii(nullToEmpty(business.getTemp_iryoKikanMeisho()));
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
            row.setWaritsukeTeiin(new RString(String.valueOf(business.getWaritsukeTeiin())));
            row.setChosaKanoNinzuPerMonth(new RString(String.valueOf(business.getChosaKanoNinzuPerMonth())));
            if (business.getNinteichosaKigenYMD() != null) {
                row.setNinteichosaKigenYMD(new RString(business.getNinteichosaKigenYMD().toString()));
            }
            if (business.getHihokenshaKana() != null) {
                row.setHihokenshaKana(business.getHihokenshaKana().value());
            }
            if (business.getSeinengappiYMD() != null) {
                row.setSeinengappiYMD(new RString(business.getSeinengappiYMD().toString()));
            }
            if (business.getYubinNo() != null) {
                row.setYubinNo(business.getYubinNo().value());
            }
            if (business.getTelNo() != null) {
                row.setTelNo(business.getTelNo().value());
            }
            if (business.getHomonChosasakiYubinNo() != null) {
                row.setHomonChosasakiYubinNo(business.getHomonChosasakiYubinNo().value());
            }
            if (business.getHomonChosasakiJusho() != null) {
                row.setHomonChosasakiJusho(business.getHomonChosasakiJusho().value());
            }
            if (business.getHomonChosasakiName() != null) {
                row.setHomonChosasakiName(business.getHomonChosasakiName().value());
            }
            if (business.getHomonChosasakiTelNo() != null) {
                row.setHomonChosasakiTelNo(business.getHomonChosasakiTelNo().value());
            }
            if (business.getNinteiShinseiYMDKoShin() != null) {
                row.setNinteiShinseiYMDKoShin(new RString(business.getNinteiShinseiYMDKoShin().toString()));
            }
            if (business.getZenkaiNinteiYMD() != null) {
                row.setZenkaiNinteiYMD(new RString(business.getZenkaiNinteiYMD().toString()));
            }
            if (business.getZenYokaigoKubunCode() != null) {
                row.setZenYokaigoKubunCode(business.getZenYokaigoKubunCode().value());
            }
            row.setAge(new RString(String.valueOf(business.getAge())));
            dataSource.add(row);
        }
        div.getDgWaritsukeZumiShinseishaIchiran().setDataSource(dataSource);
        div.getTxtChosaIraiDay().setValue(RDate.getNowDate());
    }

    /**
     * 割付済み申請者一覧Gridに検索結果を設定します。
     *
     * @param miwaritsukeShinseishaIchiranRow 未割付申請者
     */
    public void set割付済み申請者一覧(dgMiwaritsukeShinseishaIchiran_Row miwaritsukeShinseishaIchiranRow) {
        dgWaritsukeZumiShinseishaIchiran_Row row = new dgWaritsukeZumiShinseishaIchiran_Row();
        RString jotai = miwaritsukeShinseishaIchiranRow.getJotai();
        if (WARITSUKE_ZUMI.equals(jotai)) {
            row.setJotai(jotai);
        } else {
            row.setJotai(MIWARITSUKE);
        }
        row.setHihokenshaNo(miwaritsukeShinseishaIchiranRow.getHihokenshaNo());
        row.setHihokenshaShimei(miwaritsukeShinseishaIchiranRow.getHihokenshaShimei());
        row.setSeibetsu(miwaritsukeShinseishaIchiranRow.getSeibetsu());
        row.setNinteiShinseiDay(miwaritsukeShinseishaIchiranRow.getNinteiShinseiDay());
        row.setShinseiKubunShinseiji(miwaritsukeShinseishaIchiranRow.getShinseiKubunShinseiji());
        row.setChiku(miwaritsukeShinseishaIchiranRow.getChiku());
        row.setZenkaiChosaItakusaki(miwaritsukeShinseishaIchiranRow.getZenkaiChosaItakusaki());
        row.setZenkaiChosain(miwaritsukeShinseishaIchiranRow.getZenkaiNinteiChosainShimei());
        row.setChosaIraiDay(miwaritsukeShinseishaIchiranRow.getChosaIraiDay());
        row.setChosaKubun(miwaritsukeShinseishaIchiranRow.getChosaKubun());
        row.setHokensha(miwaritsukeShinseishaIchiranRow.getHokensha());
        row.setJusho(miwaritsukeShinseishaIchiranRow.getJusho());
        row.setShujiIryoKikan(miwaritsukeShinseishaIchiranRow.getShujiiIryoKikan());
        row.setShujii(miwaritsukeShinseishaIchiranRow.getShujii());
        row.setZenkaiShujiIryoKikan(miwaritsukeShinseishaIchiranRow.getZenkaiShujiiIryoKikan());
        row.setZenkaiShujii(miwaritsukeShinseishaIchiranRow.getZenkaiShujii());
        row.setIraishoShutsuryokuDay(miwaritsukeShinseishaIchiranRow.getIraishoShutsuryokuDay());
        row.setChosahyoNadoShutsuryookuDay(miwaritsukeShinseishaIchiranRow.getChosahyoNadoShutsuryookuDay());
        row.setNinteichosaKanryoYMD(miwaritsukeShinseishaIchiranRow.getNinteichosaKanryoYMD());
        row.setShinseishoKanriNo(miwaritsukeShinseishaIchiranRow.getShinseishoKanriNo());
        row.setNinteichosaIraiRirekiNo(miwaritsukeShinseishaIchiranRow.getNinteichosaIraiRirekiNo());
        row.setKoroshoIfShikibetsuCode(miwaritsukeShinseishaIchiranRow.getKoroshoIfShikibetsuCode());
        row.setWaritsukeTeiin(miwaritsukeShinseishaIchiranRow.getWaritsukeTeiin());
        row.setChosaKanoNinzuPerMonth(miwaritsukeShinseishaIchiranRow.getChosaKanoNinzuPerMonth());
        row.setNinteichosaKigenYMD(miwaritsukeShinseishaIchiranRow.getNinteichosaKigenYMD());
        row.setHihokenshaKana(miwaritsukeShinseishaIchiranRow.getHihokenshaKana());
        row.setSeinengappiYMD(miwaritsukeShinseishaIchiranRow.getSeinengappiYMD());
        row.setYubinNo(miwaritsukeShinseishaIchiranRow.getYubinNo());
        row.setTelNo(miwaritsukeShinseishaIchiranRow.getTelNo());
        row.setHomonChosasakiYubinNo(miwaritsukeShinseishaIchiranRow.getHomonChosasakiYubinNo());
        row.setHomonChosasakiJusho(miwaritsukeShinseishaIchiranRow.getHomonChosasakiJusho());
        row.setHomonChosasakiName(miwaritsukeShinseishaIchiranRow.getHomonChosasakiName());
        row.setHomonChosasakiTelNo(miwaritsukeShinseishaIchiranRow.getHomonChosasakiTelNo());
        row.setNinteiShinseiYMDKoShin(miwaritsukeShinseishaIchiranRow.getNinteiShinseiYMDKoShin());
        row.setZenkaiNinteiYMD(miwaritsukeShinseishaIchiranRow.getZenkaiNinteiYMD());
        row.setZenYokaigoKubunCode(miwaritsukeShinseishaIchiranRow.getZenYokaigoKubunCode());
        row.setAge(miwaritsukeShinseishaIchiranRow.getAge());
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
        List<dgWaritsukeZumiShinseishaIchiran_Row> dgWaritsukeZumiShinseishaIchiran = div.getDgWaritsukeZumiShinseishaIchiran().getDataSource();

        i = 1;
        for (dgWaritsukeZumiShinseishaIchiran_Row row : dgWaritsukeZumiShinseishaIchiran) {
            TextBoxNum num = new TextBoxNum();
            num.setValue(new Decimal(i++));
            row.setNo(num);
        }
        div.getDgWaritsukeZumiShinseishaIchiran().setDataSource(dgWaritsukeZumiShinseishaIchiran);
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
        for (dgMiwaritsukeShinseishaIchiran_Row miwaritsukeShinseishaIchiran_Row : dgMiwaritsukeShinseishaIchiran) {
            if (!RString.EMPTY.equals(miwaritsukeShinseishaIchiran_Row.getJotai())) {
                isUpdate = true;
                break;
            }
        }
        List<dgWaritsukeZumiShinseishaIchiran_Row> dgWaritsukeZumiShinseishaIchiran = div.getDgWaritsukeZumiShinseishaIchiran().getDataSource();
        for (dgWaritsukeZumiShinseishaIchiran_Row waritsukeZumiShinseishaIchiran_Row : dgWaritsukeZumiShinseishaIchiran) {
            if (!RString.EMPTY.equals(waritsukeZumiShinseishaIchiran_Row.getJotai())) {
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
        for (dgMiwaritsukeShinseishaIchiran_Row miwaritsukeShinseishaIchiran_Row : dgMiwaritsukeShinseishaIchiran) {
            if (WARITSUKE_ZUMI.equals(miwaritsukeShinseishaIchiran_Row.getJotai())) {
                isUpdate = true;
                break;
            }
        }
        List<dgWaritsukeZumiShinseishaIchiran_Row> dgWaritsukeZumiShinseishaIchiran = div.getDgWaritsukeZumiShinseishaIchiran().getDataSource();
        for (dgWaritsukeZumiShinseishaIchiran_Row waritsukeZumiShinseishaIchiran_Row : dgWaritsukeZumiShinseishaIchiran) {
            if (MIWARITSUKE.equals(waritsukeZumiShinseishaIchiran_Row.getJotai())) {
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
        List<dgWaritsukeZumiShinseishaIchiran_Row> dgWaritsukeZumiShinseishaIchiran = div.getDgWaritsukeZumiShinseishaIchiran().getDataSource();
        int count = 0;
        for (dgWaritsukeZumiShinseishaIchiran_Row waritsukeZumiShinseishaIchiran_Row : dgWaritsukeZumiShinseishaIchiran) {
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
     * @return　認定調査依頼書印刷用パラメータ
     */
    public List<ChosaIraishoHeadItem> create認定調査依頼書印刷用パラメータ() {
        List<dgWaritsukeZumiShinseishaIchiran_Row> selectedItems = div.getDgWaritsukeZumiShinseishaIchiran().getSelectedItems();
        int renban = 1;
        List<ChosaIraishoHeadItem> chosaIraishoHeadItemList = new ArrayList<>();
        for (dgWaritsukeZumiShinseishaIchiran_Row row : selectedItems) {
            RString[] TempP_被保険者番号 = get被保険者番号(row.getHihokenshaNo());
            RString TempP_誕生日明治 = RString.EMPTY;
            RString TempP_誕生日大正 = RString.EMPTY;
            RString TempP_誕生日昭和 = RString.EMPTY;
            RDate seinengappiYMD = new RDate(row.getSeinengappiYMD().toString());
            RString era = seinengappiYMD.wareki().eraType(EraType.KANJI).getEra();

            if (元号_明治.equals(era)) {
                TempP_誕生日大正 = HOUSI;
                TempP_誕生日昭和 = HOUSI;
            } else if (元号_大正.equals(era)) {
                TempP_誕生日明治 = HOUSI;
                TempP_誕生日昭和 = HOUSI;
            } else if (元号_昭和.equals(era)) {
                TempP_誕生日大正 = HOUSI;
                TempP_誕生日明治 = HOUSI;
            }
            RString seibetsu = row.getSeibetsu();
            RString TempP_性別男 = RString.EMPTY;
            RString TempP_性別女 = RString.EMPTY;

            if (Seibetsu.男.get名称().equals(seibetsu)) {
                TempP_性別女 = HOUSI;
            } else {
                TempP_性別男 = HOUSI;
            }
            // TODO CompToiawasesaki．出力項目．通知文 取得方式が知らない
            ChosaIraishoHeadItem item = new ChosaIraishoHeadItem(RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    TempP_被保険者番号[0],
                    TempP_被保険者番号[1],
                    TempP_被保険者番号[2],
                    TempP_被保険者番号[3],
                    TempP_被保険者番号[4],
                    TempP_被保険者番号[5],
                    TempP_被保険者番号[6],
                    TempP_被保険者番号[7],
                    TempP_被保険者番号[8],
                    TempP_被保険者番号[9],
                    row.getHihokenshaKana(),
                    TempP_誕生日明治,
                    TempP_誕生日大正,
                    TempP_誕生日昭和,
                    seinengappiYMD.wareki().toDateString(),
                    row.getHihokenshaShimei(),
                    TempP_性別男,
                    TempP_性別女,
                    row.getYubinNo(),
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

    private RString[] get被保険者番号(RString Temp_被保険者番号) {
        RString[] TempP_被保険者番号 = {RString.EMPTY,
            RString.EMPTY,
            RString.EMPTY,
            RString.EMPTY,
            RString.EMPTY,
            RString.EMPTY,
            RString.EMPTY,
            RString.EMPTY,
            RString.EMPTY,
            RString.EMPTY};

        if (0 < Temp_被保険者番号.length()) {
            TempP_被保険者番号[0] = Temp_被保険者番号.substring(0, 1);
        }
        if (1 < Temp_被保険者番号.length()) {
            TempP_被保険者番号[1] = Temp_被保険者番号.substring(1, 2);
        }
        if (2 < Temp_被保険者番号.length()) {
            TempP_被保険者番号[2] = Temp_被保険者番号.substring(2, 3);
        }
        if (3 < Temp_被保険者番号.length()) {
            TempP_被保険者番号[3] = Temp_被保険者番号.substring(3, 4);
        }
        if (4 < Temp_被保険者番号.length()) {
            TempP_被保険者番号[4] = Temp_被保険者番号.substring(4, 5);
        }
        if (5 < Temp_被保険者番号.length()) {
            TempP_被保険者番号[5] = Temp_被保険者番号.substring(5, 6);
        }
        if (6 < Temp_被保険者番号.length()) {
            TempP_被保険者番号[6] = Temp_被保険者番号.substring(6, 7);
        }
        if (7 < Temp_被保険者番号.length()) {
            TempP_被保険者番号[7] = Temp_被保険者番号.substring(7, 8);
        }
        if (8 < Temp_被保険者番号.length()) {
            TempP_被保険者番号[8] = Temp_被保険者番号.substring(8, 9);
        }
        if (9 < Temp_被保険者番号.length()) {
            TempP_被保険者番号[9] = Temp_被保険者番号.substring(9);
        }

        return TempP_被保険者番号;
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        } else {
            return obj;
        }
    }
}
