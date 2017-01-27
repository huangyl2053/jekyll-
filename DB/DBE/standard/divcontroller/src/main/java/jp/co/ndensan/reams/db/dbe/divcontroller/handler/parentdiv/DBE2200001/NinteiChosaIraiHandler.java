package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2200001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.NinnteiChousairaiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.WaritsukeBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninnteichousairai.NinnteiChousairaiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.NinteiChosaIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgChosaItakusakiIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgMiwaritsukeShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgWaritsukeZumiShinseishaIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2200001.dgchosainIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaItakuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 認定調査員マスタ画面のハンドラークラスです。
 *
 * @reamsid_L DBE-0010-010 sunhaidi
 */
public class NinteiChosaIraiHandler {

    private static final RString 未割付 = new RString("未割付");
    private static final RString 割付解除 = new RString("割付解除");
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
        clear検索条件();
        RString 最大取得件数 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 最大取得件数上限 = DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        div.getTxtSaidaiHyojiKensu().setValue(new Decimal(最大取得件数.toString()));
        div.getTxtSaidaiHyojiKensu().setMaxValue(new Decimal(最大取得件数上限.toString()));
    }

    /**
     * 検索条件をクリアします。
     */
    public void clear検索条件() {
        div.getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        div.getTxtChosaItakusaki().clearValue();
    }

    /**
     * 調査委託先取得パラメータを作成します。
     *
     * @param 保険者番号 ShoKisaiHokenshaNo
     * @param 支所コード RString
     * @param 市町村コード LasdecCode
     * @return NinnteiChousairaiParameter
     */
    public NinnteiChousairaiParameter create調査委託先取得パラメータ(ShoKisaiHokenshaNo 保険者番号,
            RString 支所コード, LasdecCode 市町村コード) {
        ChosaItakusakiCode 調査委託先コード
                = (div.getTxtChosaItakusaki().getValue() != null && !div.getTxtChosaItakusaki().getValue().equals(RString.EMPTY))
                ? new ChosaItakusakiCode(div.getTxtChosaItakusaki().getValue())
                : null;
        int 依頼件数集計月数 = Integer.parseInt(DbBusinessConfig.get(
                ConfigNameDBE.認定調査依頼_依頼件数集計月数, RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString());
        RDate 依頼件数集計開始日 = RDate.getNowDate().minusMonth(依頼件数集計月数);
        return NinnteiChousairaiParameter.createParam調査委託先(保険者番号, 支所コード, 市町村コード, 調査委託先コード,
                依頼件数集計開始日, RDate.getNowDate(), div.getTxtSaidaiHyojiKensu().getValue().intValue());
    }

    /**
     * 認定調査委託先一覧に検索結果を設定します。
     *
     * @param 認定調査委託先List 認定調査委託先List
     */
    public void set認定調査委託先一覧(SearchResult<NinnteiChousairaiBusiness> 認定調査委託先List) {
        List<dgChosaItakusakiIchiran_Row> dataSource = new ArrayList<>();
        boolean is単一保険者 = is単一保険者();
        for (NinnteiChousairaiBusiness 認定調査委託先 : 認定調査委託先List.records()) {
            dgChosaItakusakiIchiran_Row row = new dgChosaItakusakiIchiran_Row();
            row.getChosaItakusakiCode().setValue(nullToEmpty(認定調査委託先.getNinteichosaItakusakiCode()));
            row.setChosaItakusakiMeisho(nullToEmpty(認定調査委託先.getJigyoshaMeisho()));
            if (認定調査委託先.getWaritsukeChiku() != null) {
                RString 割付地区 = CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, DBECodeShubetsu.調査地区コード.getコード(),
                        new Code(認定調査委託先.getWaritsukeChiku().value()), FlexibleDate.getNowDate());
                if (割付地区 != null) {
                    row.setChosaChiku(割付地区);
                } else {
                    throw new ApplicationException(UrErrorMessages.対象データなし.getMessage());
                }
            }
            row.getWaritsukeTeiin().setValue(new Decimal(認定調査委託先.getWaritsukeTeiin()));
            row.getWaritsukeZumi().setValue(new Decimal(認定調査委託先.getWaritsukesumiKensu()));
            row.setChosaItakusakiJusho(nullToEmpty(認定調査委託先.getJusho()));
            row.setChosaItakusakiTelNo(認定調査委託先.getTelNo() == null ? RString.EMPTY : 認定調査委託先.getTelNo().value());
            if (認定調査委託先.getChosaItakuKubun() != null
                    && !認定調査委託先.getChosaItakuKubun().trim().isEmpty()) {
                row.setChosaItakusakiKubun(ChosaItakuKubunCode.toValue(認定調査委託先.getChosaItakuKubun()).get名称());
            } else {
                row.setChosaItakusakiKubun(RString.EMPTY);
            }
            if (is単一保険者) {
                row.setHokenshaCode(nullToEmpty(div.getCcdHokenshaList().getSelectedItem().get市町村コード().value()));
                row.setHokenshaName(nullToEmpty(div.getCcdHokenshaList().getSelectedItem().get市町村名称()));
            } else {
                row.setHokenshaCode((認定調査委託先.getShichosonCode() != null) ? 認定調査委託先.getShichosonCode().value() : RString.EMPTY);
                row.setHokenshaName(nullToEmpty(認定調査委託先.getShichosonMeisho()));
            }
            row.getIraiJissekiKensu().setValue(new Decimal(認定調査委託先.getIraiKensu()));
            row.setShoKisaiHokenshaNo(認定調査委託先.getShoKisaiHokenshaNo());
            dataSource.add(row);
        }
        div.getDgChosaItakusakiIchiran().getFilterList().clear();
        div.getDgChosaItakusakiIchiran().setDataSource(dataSource);
        div.getDgChosaItakusakiIchiran().getGridSetting().setLimitRowCount(div.getTxtSaidaiHyojiKensu().getValue().intValue());
        div.getDgChosaItakusakiIchiran().getGridSetting().setSelectedRowCount(認定調査委託先List.totalCount());
    }

    /**
     * 調査員情報一覧に検索結果を設定します。
     *
     * @param 調査員List 調査員情報一覧List
     */
    public void set調査員情報一覧(List<NinnteiChousairaiBusiness> 調査員List) {
        List<dgchosainIchiran_Row> dataSource = new ArrayList<>();
        ShoKisaiHokenshaNo 証記載保険者番号 = ViewStateHolder.get(ViewStateKeys.証記載保険者番号, ShoKisaiHokenshaNo.class);
        RString 保険者名称 = ViewStateHolder.get(ViewStateKeys.保険者名称, RString.class);
        for (NinnteiChousairaiBusiness 調査員 : 調査員List) {
            dgchosainIchiran_Row row = new dgchosainIchiran_Row();
            row.getChosainCode().setValue(nullToEmpty(調査員.getNinteiChosainNo()));
            row.setChosainShimei(nullToEmpty(調査員.getChosainShimei()));
            row.setChosainKanaShimei(nullToEmpty(調査員.getChosainKanaShimei()));
            if (!RString.isNullOrEmpty(調査員.getSeibetsu())) {
                row.setChosainSeibetsu(Seibetsu.toValue(調査員.getSeibetsu()).get名称());
            }
            row.setChosainTelNo(調査員.getTelNo() == null ? RString.EMPTY : 調査員.getTelNo().value());
            row.setChosaChiku(nullToEmpty(調査員.getChikuCode()));
            if (調査員.getChikuCode() != null) {
                RString codeName = CodeMaster.getCodeMeisho(
                        SubGyomuCode.DBE認定支援,
                        DBECodeShubetsu.調査地区コード.getコード(),
                        new Code(調査員.getChikuCode()),
                        FlexibleDate.getNowDate());
                if (codeName != null) {
                    row.setChosaChiku(codeName);
                }
            }
            row.getWaritsukeZumi().setValue(new Decimal(調査員.getWaritsukesumiKensu()));
            if (調査員.getChosainShikaku() != null && !調査員.getChosainShikaku().trim().isEmpty()) {
                row.setChosainShikaku(Sikaku.toValue(調査員.getChosainShikaku()).get名称());
            }
            row.setChosaKanoNinzuPerMonth(new RString(調査員.getChosaKanoNinzuPerMonth()));
            row.setHokenshaCode(nullToEmpty(証記載保険者番号.value()));
            row.setHokenshaName(nullToEmpty(保険者名称));
            dataSource.add(row);
        }
        div.getDgchosainIchiran().getFilterList().clear();
        div.getDgchosainIchiran().setDataSource(dataSource);
    }

    /**
     * 未割付申請者一覧Gridに検索結果を設定します。
     *
     * @param 未割付申請者List 未割付一覧検索結果
     * @param hokenshaName 保険者名称
     */
    public void set未割付申請者一覧(List<WaritsukeBusiness> 未割付申請者List, RString hokenshaName) {
        List<dgMiwaritsukeShinseishaIchiran_Row> dataSource = new ArrayList<>();
        int number = 1;
        for (WaritsukeBusiness 未割付申請者 : 未割付申請者List) {
            dgMiwaritsukeShinseishaIchiran_Row row = new dgMiwaritsukeShinseishaIchiran_Row();
            row.setNo(new RString(number++));
            row.setJotai(RString.EMPTY);
            row.setHihokenshaNo(nullToEmpty(未割付申請者.getHihokenshaNo()));
            row.setHihokenshaShimei(未割付申請者.getHihokenshaName() == null ? RString.EMPTY : 未割付申請者.getHihokenshaName().value());
            if (未割付申請者.getSeibetsu() != null && !RString.isNullOrEmpty(未割付申請者.getSeibetsu().value())) {
                row.setSeibetsu(Seibetsu.toValue(未割付申請者.getSeibetsu().value()).get名称());
            }
            if (未割付申請者.getNinteiShinseiYMD() != null && !未割付申請者.getNinteiShinseiYMD().isEmpty()) {
                row.getNinteiShinseiDay().setValue(new RDate(未割付申請者.getNinteiShinseiYMD().toString()));
            }
            if (未割付申請者.getNinteiShinseiKubunCode() != null && !RString.isNullOrEmpty(未割付申請者.getNinteiShinseiKubunCode().value())) {
                int ninteiShinseiKubun = Integer.parseInt(未割付申請者.getNinteiShinseiKubunCode().getColumnValue().toString());
                row.setShinseiKubunShinseiji(new RString(NinteiShinseiKubunShinsei.toValue(ninteiShinseiKubun).name()));
            }
            if (未割付申請者.getChikuCode() != null) {
                RString codeName = CodeMaster.getCodeMeisho(
                        SubGyomuCode.DBE認定支援,
                        DBECodeShubetsu.調査地区コード.getコード(),
                        new Code(未割付申請者.getChikuCode().value()),
                        FlexibleDate.getNowDate());
                if (codeName != null) {
                    row.setChiku(codeName);
                }
            }
            row.setZenkaiChosaItakusaki(nullToEmpty(未割付申請者.getTemp_jigyoshaMeisho()));
            row.setZenkaiNinteiChosainShimei(nullToEmpty(未割付申請者.getTemp_chosainShimei()));
            row.setHokensha(nullToEmpty(hokenshaName));
            row.setChosaKubun(NinteiChousaIraiKubunCode.toValue(未割付申請者.getChosaKubun().value()).get名称());
            if (未割付申請者.getJusho() != null) {
                row.setJusho(未割付申請者.getJusho().value());
            }
            row.setShujiiIryoKikan(nullToEmpty(未割付申請者.getIryoKikanMeisho()));
            if (未割付申請者.getShujiiName() != null) {
                row.setShujii(未割付申請者.getShujiiName().value());
            }

            row.setZenkaiShujiiIryoKikan(nullToEmpty(未割付申請者.getTemp_iryoKikanMeisho()));
            if (未割付申請者.getTemp_shujiiName() != null) {
                row.setZenkaiShujii(未割付申請者.getTemp_shujiiName().value());
            }

            row.setShinseishoKanriNo(nullToEmpty(未割付申請者.getShinseishoKanriNo()));
            row.setNinteichosaIraiRirekiNo(new RString(未割付申請者.getNinteichosaIraiRirekiNo()));
            row.setKoroshoIfShikibetsuCode(
                    未割付申請者.getKoroshoIfShikibetsuCode() == null ? RString.EMPTY : 未割付申請者.getKoroshoIfShikibetsuCode().value());
            setDgMiwaritsukeShinseishaIchiran_Row(row, 未割付申請者);
            dataSource.add(row);
        }
        div.getDgMiwaritsukeShinseishaIchiran().getFilterList().clear();
        div.getDgMiwaritsukeShinseishaIchiran().setDataSource(dataSource);
    }

    private void setDgMiwaritsukeShinseishaIchiran_Row(dgMiwaritsukeShinseishaIchiran_Row row, WaritsukeBusiness 未割付申請者) {
        row.setWaritsukeTeiin(new RString(未割付申請者.getWaritsukeTeiin()));
        row.setChosaKanoNinzuPerMonth(new RString(未割付申請者.getChosaKanoNinzuPerMonth()));
        if (未割付申請者.getNinteichosaKigenYMD() != null) {
            row.setNinteichosaKigenYMD(new RString(未割付申請者.getNinteichosaKigenYMD().toString()));
        }
        row.setHihokenshaKana(未割付申請者.getHihokenshaKana() == null ? RString.EMPTY : 未割付申請者.getHihokenshaKana().value());
        if (未割付申請者.getSeinengappiYMD() != null) {
            row.setSeinengappiYMD(new RString(未割付申請者.getSeinengappiYMD().toString()));
        }
        row.setYubinNo(未割付申請者.getYubinNo() == null ? RString.EMPTY : 未割付申請者.getYubinNo().value());
        row.setTelNo(未割付申請者.getTelNo() == null ? RString.EMPTY : 未割付申請者.getTelNo().value());
        row.setHomonChosasakiYubinNo(
                未割付申請者.getHomonChosasakiYubinNo() == null ? RString.EMPTY : 未割付申請者.getHomonChosasakiYubinNo().value());
        row.setHomonChosasakiJusho(未割付申請者.getHomonChosasakiJusho() == null ? RString.EMPTY : 未割付申請者.getHomonChosasakiJusho().value());
        row.setHomonChosasakiName(未割付申請者.getHomonChosasakiName() == null ? RString.EMPTY : 未割付申請者.getHomonChosasakiName().value());
        row.setHomonChosasakiTelNo(未割付申請者.getHomonChosasakiTelNo() == null ? RString.EMPTY : 未割付申請者.getHomonChosasakiTelNo().value());
        if (未割付申請者.getNinteiShinseiYMDKoShin() != null && !未割付申請者.getNinteiShinseiYMDKoShin().isEmpty()) {
            row.setNinteiShinseiYMDKoShin(new RString(未割付申請者.getNinteiShinseiYMDKoShin().toString()));
        }
        if (未割付申請者.getZenkaiNinteiYMD() != null && !未割付申請者.getZenkaiNinteiYMD().isEmpty()) {
            row.setZenkaiNinteiYMD(new RString(未割付申請者.getZenkaiNinteiYMD().toString()));
        }
        row.setZenYokaigoKubunCode(未割付申請者.getZenYokaigoKubunCode() == null ? RString.EMPTY : 未割付申請者.getZenYokaigoKubunCode().value());
        row.setAge(new RString(未割付申請者.getAge()));
        row.setNinteiChosainCode(nullToEmpty(未割付申請者.getNinteiChosainCode()));
        row.setHokenshaNo(未割付申請者.getHokenshaNo());
    }

    /**
     * 未割付申請者一覧Gridに割付済み申請者を設定します。
     *
     * @param waritsukeZumiShinseishaRow 割付済み申請者
     */
    public void set未割付申請者一覧(dgWaritsukeZumiShinseishaIchiran_Row waritsukeZumiShinseishaRow) {
        dgMiwaritsukeShinseishaIchiran_Row row = new dgMiwaritsukeShinseishaIchiran_Row();
        RString jotai = waritsukeZumiShinseishaRow.getJotai();
        if (未割付.equals(jotai)) {
            row.setJotai(RString.EMPTY);
        } else {
            row.setJotai(割付解除);
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
        row.getNinteichosaKanryoYMD().setValue(waritsukeZumiShinseishaRow.getNinteichosaKanryoYMD().getValue());
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
        row.setHokenshaNo(waritsukeZumiShinseishaRow.getHokenshaNo());
        div.getDgMiwaritsukeShinseishaIchiran().getDataSource().add(row);
    }

    /**
     * 割付済み申請者一覧Gridに検索結果を設定します。
     *
     * @param 割付済み申請者List 割付済み申請者一覧検索結果
     * @param hokenshaName 保険者名称
     */
    public void set割付済み申請者一覧(List<WaritsukeBusiness> 割付済み申請者List, RString hokenshaName) {
        List<dgWaritsukeZumiShinseishaIchiran_Row> dataSource = new ArrayList<>();
        int number = 1;
        for (WaritsukeBusiness 割付済み申請者 : 割付済み申請者List) {
            dgWaritsukeZumiShinseishaIchiran_Row row = new dgWaritsukeZumiShinseishaIchiran_Row();
            row.getNo().setValue(new Decimal(number++));
            row.setJotai(RString.EMPTY);
            row.setHihokenshaNo(nullToEmpty(割付済み申請者.getHihokenshaNo()));
            row.setHihokenshaShimei(割付済み申請者.getHihokenshaName() == null ? RString.EMPTY : 割付済み申請者.getHihokenshaName().value());
            if (割付済み申請者.getSeibetsu() != null && !RString.isNullOrEmpty(割付済み申請者.getSeibetsu().value())) {
                row.setSeibetsu(Seibetsu.toValue(割付済み申請者.getSeibetsu().value()).get名称());
            }
            setNinteiShinseiJoho(割付済み申請者, row);
            if (割付済み申請者.getChikuCode() != null) {
                RString codeName = CodeMaster.getCodeMeisho(
                        SubGyomuCode.DBE認定支援,
                        DBECodeShubetsu.調査地区コード.getコード(),
                        new Code(割付済み申請者.getChikuCode().value()),
                        FlexibleDate.getNowDate());
                if (codeName != null) {
                    row.setChiku(codeName);
                }
            }
            row.setZenkaiChosaItakusaki(nullToEmpty(割付済み申請者.getTemp_jigyoshaMeisho()));
            row.setZenkaiChosain(nullToEmpty(割付済み申請者.getTemp_chosainShimei()));

            if (割付済み申請者.getNinteichosaIraiYMD() != null && !割付済み申請者.getNinteichosaIraiYMD().isEmpty()) {
                row.setChosaIraiDay(割付済み申請者.getNinteichosaIraiYMD().wareki().toDateString());
            }
            row.setChosaKubun(NinteiChousaIraiKubunCode.toValue(割付済み申請者.getChosaKubun().value()).get名称());
            row.setHokensha(nullToEmpty(hokenshaName));
            if (割付済み申請者.getJusho() != null) {
                row.setJusho(割付済み申請者.getJusho().value());
            }
            row.setShujiIryoKikan(nullToEmpty(割付済み申請者.getIryoKikanMeisho()));
            if (割付済み申請者.getShujiiName() != null) {
                row.setShujii(割付済み申請者.getShujiiName().value());
            }

            row.setZenkaiShujiIryoKikan(nullToEmpty(割付済み申請者.getTemp_iryoKikanMeisho()));
            if (割付済み申請者.getTemp_shujiiName() != null) {
                row.setZenkaiShujii(割付済み申請者.getTemp_shujiiName().value());
            }

            if (割付済み申請者.getIraishoShutsuryokuYMD() != null && 割付済み申請者.getIraishoShutsuryokuYMD().isValid()) {
                row.getIraishoShutsuryokuDay().setValue(new RDate(割付済み申請者.getIraishoShutsuryokuYMD().toString()));
            }

            setChosahyoShutsuryokuJoho(割付済み申請者, row);
            row.setShinseishoKanriNo(nullToEmpty(割付済み申請者.getShinseishoKanriNo()));
            row.setNinteichosaIraiRirekiNo(new RString(割付済み申請者.getNinteichosaIraiRirekiNo()));
            row.setKoroshoIfShikibetsuCode(
                    割付済み申請者.getKoroshoIfShikibetsuCode() == null ? RString.EMPTY : 割付済み申請者.getKoroshoIfShikibetsuCode().value());
            setDgWaritsukeZumiShinseishaIchiran_Row(割付済み申請者, row);
            dataSource.add(row);
        }
        div.getDgWaritsukeZumiShinseishaIchiran().getFilterList().clear();
        div.getDgWaritsukeZumiShinseishaIchiran().setDataSource(dataSource);
        div.getTxtChosaIraiDay().setValue(RDate.getNowDate());
    }

    private void setNinteiShinseiJoho(WaritsukeBusiness 割付済み申請者, dgWaritsukeZumiShinseishaIchiran_Row row) throws IllegalArgumentException {
        if (割付済み申請者.getNinteiShinseiYMD() != null && 割付済み申請者.getNinteiShinseiYMD().isValid()) {
            row.getNinteiShinseiDay().setValue(new RDate(割付済み申請者.getNinteiShinseiYMD().toString()));
        }
        if (割付済み申請者.getNinteiShinseiKubunCode() != null && !RString.isNullOrEmpty(割付済み申請者.getNinteiShinseiKubunCode().value())) {
            int ninteiShinseiKubun = Integer.parseInt(割付済み申請者.getNinteiShinseiKubunCode().getColumnValue().toString());
            row.setShinseiKubunShinseiji(new RString(NinteiShinseiKubunShinsei.toValue(ninteiShinseiKubun).name()));
        }
    }

    private void setChosahyoShutsuryokuJoho(WaritsukeBusiness 割付済み申請者, dgWaritsukeZumiShinseishaIchiran_Row row) throws IllegalArgumentException {
        if (割付済み申請者.getChosahyoTouShutsuryokuYMD() != null && 割付済み申請者.getChosahyoTouShutsuryokuYMD().isValid()) {
            row.getChosahyoNadoShutsuryookuDay().setValue(new RDate(割付済み申請者.getChosahyoTouShutsuryokuYMD().toString()));
        }
        row.getNinteichosaKanryoYMD().setValue(割付済み申請者.getNinteichosaKanryoYMD());
    }

    private void setDgWaritsukeZumiShinseishaIchiran_Row(WaritsukeBusiness 割付済み申請者, dgWaritsukeZumiShinseishaIchiran_Row row) {
        row.setWaritsukeTeiin(new RString(割付済み申請者.getWaritsukeTeiin()));
        row.setChosaKanoNinzuPerMonth(new RString(割付済み申請者.getChosaKanoNinzuPerMonth()));
        if (割付済み申請者.getNinteichosaKigenYMD() != null) {
            row.setNinteichosaKigenYMD(new RString(割付済み申請者.getNinteichosaKigenYMD().toString()));
        }
        row.setHihokenshaKana(割付済み申請者.getHihokenshaKana() == null ? RString.EMPTY : 割付済み申請者.getHihokenshaKana().value());
        if (割付済み申請者.getSeinengappiYMD() != null) {
            row.setSeinengappiYMD(new RString(割付済み申請者.getSeinengappiYMD().toString()));
        }
        row.setYubinNo(割付済み申請者.getYubinNo() == null ? RString.EMPTY : 割付済み申請者.getYubinNo().value());
        row.setTelNo(割付済み申請者.getTelNo() == null ? RString.EMPTY : 割付済み申請者.getTelNo().value());
        row.setHomonChosasakiYubinNo(
                割付済み申請者.getHomonChosasakiYubinNo() == null ? RString.EMPTY : 割付済み申請者.getHomonChosasakiYubinNo().value());
        row.setHomonChosasakiJusho(割付済み申請者.getHomonChosasakiJusho() == null ? RString.EMPTY : 割付済み申請者.getHomonChosasakiJusho().value());
        row.setHomonChosasakiName(割付済み申請者.getHomonChosasakiName() == null ? RString.EMPTY : 割付済み申請者.getHomonChosasakiName().value());
        row.setHomonChosasakiTelNo(割付済み申請者.getHomonChosasakiTelNo() == null ? RString.EMPTY : 割付済み申請者.getHomonChosasakiTelNo().value());
        if (割付済み申請者.getNinteiShinseiYMDKoShin() != null) {
            row.setNinteiShinseiYMDKoShin(new RString(割付済み申請者.getNinteiShinseiYMDKoShin().toString()));
        }
        if (割付済み申請者.getZenkaiNinteiYMD() != null) {
            row.setZenkaiNinteiYMD(new RString(割付済み申請者.getZenkaiNinteiYMD().toString()));
        }
        row.setZenYokaigoKubunCode(割付済み申請者.getZenYokaigoKubunCode() == null ? RString.EMPTY : 割付済み申請者.getZenYokaigoKubunCode().value());
        row.setAge(new RString(割付済み申請者.getAge()));
        row.setNinteiChosainCode(nullToEmpty(割付済み申請者.getNinteiChosainCode()));
        row.setHokenshaNo(nullToEmpty(割付済み申請者.getHokenshaNo()));
        row.setNinteiChosaItakusakiCode(nullToEmpty(割付済み申請者.getNinteiChosaItakusakiCode()));
        row.setShichosonCode(nullToEmpty(割付済み申請者.getShichosonCode()));
        row.setRenrakusakiYubinNo(割付済み申請者.getRenrakusakiYubinNo() == null ? RString.EMPTY : 割付済み申請者.getRenrakusakiYubinNo().value());
        row.setRenrakusakiTelNo(割付済み申請者.getRenrakusakiTelNo() == null ? RString.EMPTY : 割付済み申請者.getRenrakusakiTelNo().value());
        row.setRenrakusakiKeitaiTelNo(割付済み申請者.getRenrakusakiKeitaiTelNo() == null ? RString.EMPTY : 割付済み申請者.getRenrakusakiKeitaiTelNo().value());
        row.setRenrakusakiShimei(割付済み申請者.getRenrakusakiShimei() == null ? RString.EMPTY : 割付済み申請者.getRenrakusakiShimei().value());
        row.setRenrakusakiTuzukigara(nullToEmpty(割付済み申請者.getRenrakusakiTuzukigara()));
        row.setRenrakusakiJusho(割付済み申請者.getRenrakusakiJusho() == null ? RString.EMPTY : 割付済み申請者.getRenrakusakiJusho().value());
    }

    /**
     * 割付済み申請者一覧Gridに検索結果を設定します。
     *
     * @param miwaritsukeShinseishaRow 未割付申請者
     */
    public void set割付済み申請者一覧(dgMiwaritsukeShinseishaIchiran_Row miwaritsukeShinseishaRow) {
        dgWaritsukeZumiShinseishaIchiran_Row row = new dgWaritsukeZumiShinseishaIchiran_Row();
        RString jotai = miwaritsukeShinseishaRow.getJotai();
        if (割付解除.equals(jotai)) {
            row.setJotai(RString.EMPTY);
        } else {
            row.setJotai(未割付);
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
        row.getNinteichosaKanryoYMD().setValue(miwaritsukeShinseishaRow.getNinteichosaKanryoYMD().getValue());
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
        row.setHokenshaNo(miwaritsukeShinseishaRow.getHokenshaNo());
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
     * 調査員基本情報に検索結果を設定します。
     *
     * @param row 調査員基本情報
     */
    public void set調査員基本情報(dgchosainIchiran_Row row) {
        div.getTxtChosainCode().setValue(row.getChosainCode().getValue());
        div.getTxtChosainShimei().setValue(row.getChosainShimei());
        div.getTxtChosainChiku().setValue(row.getChosaChiku());
    }

    /**
     * 調査員基本情報を初期化します。
     *
     */
    public void clear調査員基本情報() {
        div.getTxtChosainCode().clearValue();
        div.getTxtChosainShimei().clearValue();
        div.getTxtChosainChiku().clearValue();
    }

    /**
     * 変更かあるか判定します。
     *
     * @return 判断結果（編集内容があるの場合:true、編集内容がなしの場合：false）
     */
    public boolean exist変更() {
        List<dgMiwaritsukeShinseishaIchiran_Row> dgMiwaritsukeShinseishaIchiran = div.getDgMiwaritsukeShinseishaIchiran().getDataSource();
        for (dgMiwaritsukeShinseishaIchiran_Row miwaritsukeShinseishaRow : dgMiwaritsukeShinseishaIchiran) {
            if (割付解除.equals(miwaritsukeShinseishaRow.getJotai())) {
                return true;
            }
        }
        List<dgWaritsukeZumiShinseishaIchiran_Row> dgWaritsukeZumiShinseisha = div.getDgWaritsukeZumiShinseishaIchiran().getDataSource();
        for (dgWaritsukeZumiShinseishaIchiran_Row waritsukeZumiShinseishaRow : dgWaritsukeZumiShinseisha) {
            if (未割付.equals(waritsukeZumiShinseishaRow.getJotai())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 割付済み申請者一覧Gridで選択されている申請者の申請管理番号のリストを返します。
     *
     * @return 申請管理番号のリスト
     */
    public List<ShinseishoKanriNo> getSelected申請書管理番号リスト() {
        List<ShinseishoKanriNo> 申請書管理番号リスト = new ArrayList<>();
        for (dgWaritsukeZumiShinseishaIchiran_Row row : div.getDgWaritsukeZumiShinseishaIchiran().getSelectedItems()) {
            申請書管理番号リスト.add(new ShinseishoKanriNo(row.getShinseishoKanriNo()));
        }
        return 申請書管理番号リスト;
    }

    private boolean is単一保険者() {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護認定);
        RString 導入形態コード = 市町村セキュリティ情報.get導入形態コード().value();
        return (DonyuKeitaiCode.事務単一.getCode().equals(導入形態コード)
                || DonyuKeitaiCode.認定単一.getCode().equals(導入形態コード));
    }

    private RString nullToEmpty(RString obj) {
        return (obj != null) ? obj : RString.EMPTY;
    }
}
