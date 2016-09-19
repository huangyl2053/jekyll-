/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1010011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.business.core.shokanshikyuketteitsuchishohakkou.ShokanShikyuKetteiTsuchishoHakkouBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.shoukanbaraishikyuketteitsuchisho.ShoukanbaraiShikyuketteiTsuuchishoOutputEntity;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishoshiharaiyoteibiyijiari.ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishoshiharaiyoteibiyijinashi.ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiItem;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1010011.ShokanShikyuKetteiTsuchishoHakkouDiv;
import jp.co.ndensan.reams.db.dbc.service.core.shoukanbaraishikyuketteitsuchisho.ShoukanbaraiShikyuKetteiTsuchisho;
import jp.co.ndensan.reams.db.dbc.service.report.shokanketteitsuchishoshiharaiyoteibiyijinashi.ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriService;
import jp.co.ndensan.reams.db.dbc.service.report.shokanketteitsuchishoshiharaiyoteibiyijinashi.ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiService;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.sashitome.ShiharaiHohoHenkoSashitome;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.service.core.basic.ShokanHanteiKekkaManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 償還払い支給（不支給）決定通知書作成（単）のHandlerです。
 *
 * @reamsid_L DBC-5310-010 liuyl
 */
public class ShokanShikyuKetteiTsuchishoHakkouHandler {

    private final ShokanShikyuKetteiTsuchishoHakkouDiv div;
    private static final RString DBCSHIKIBETSUCODE = new RString("DBCshikibetsuCode");

    /**
     * コンストラクタです。
     *
     * @param div ShokanShikyuKetteiTsuchishoHakkouDiv
     */
    public ShokanShikyuKetteiTsuchishoHakkouHandler(ShokanShikyuKetteiTsuchishoHakkouDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param shikibetsuCode ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param 償還払支給判定結果List List<ShokanShikyuKetteiTsuchishoHakkouBusiness>
     * @param 受給者台帳List List<JukyushaDaicho>
     * @param 総合事業対象者List List<SogoJigyoTaishosha>
     * @param 償還払支給判定結果 List<ShokanHanteiKekka>
     */
    public void onLoad(ShikibetsuCode shikibetsuCode, HihokenshaNo 被保険者番号,
            List<ShokanShikyuKetteiTsuchishoHakkouBusiness> 償還払支給判定結果List,
            List<JukyushaDaicho> 受給者台帳List,
            List<SogoJigyoTaishosha> 総合事業対象者List,
            List<ShokanHanteiKekka> 償還払支給判定結果) {
        LockingKey key = new LockingKey(DBCSHIKIBETSUCODE.concat(被保険者番号.getColumnValue()));
        RealInitialLocker.lock(key);
        div.getShokanShikyuKetteiTsuchishoHakkouKihon().initialize(shikibetsuCode);
        div.getShokanShikyuKetteiTsuchishoSakuseiKaigoKihon().initialize(被保険者番号);
        div.getShokanShikyuKetteiTsuchishoHakkouPrint().getTxtHakkouYMD().setValue(RDate.getNowDate());
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("'被保険者番号"),
                被保険者番号.value());
        AccessLogger.log(AccessLogType.照会, PersonalData.of(shikibetsuCode, expandedInfo));
        if (受給者台帳List.isEmpty() || 総合事業対象者List.isEmpty()) {
            throw new ApplicationException(DbdErrorMessages.受給共通_受給者_事業対象者登録なし.getMessage());
        }
        if (償還払支給判定結果.isEmpty()) {
            throw new ApplicationException(DbcErrorMessages.償還決定データなし.getMessage());
        }
        List<FlexibleYearMonth> サービス提供年月List = getサービス提供年月(償還払支給判定結果List);
        div.getDdlServiceTeikyoYM().setDataSource(getサービス提供年月DataSource(サービス提供年月List));
        List<RString> 整理番号List = new ArrayList<>();
        if (!サービス提供年月List.isEmpty()) {
            div.getDdlServiceTeikyoYM().setSelectedValue(サービス提供年月List.get(0).wareki().toDateString());
            整理番号List = get整理番号(サービス提供年月List.get(0), 償還払支給判定結果List);
        }
        div.getDdlSeiriNO().setDataSource(get整理番号DataSource(整理番号List));
        if (!整理番号List.isEmpty()) {
            div.getDdlSeiriNO().setSelectedValue(整理番号List.get(0));
        }
        if (!償還払支給判定結果List.isEmpty()) {
            if (償還払支給判定結果List.get(0).get償還払支給判定結果().get決定通知書作成年月日() != null && !償還払支給判定結果List.get(0).
                    get償還払支給判定結果().get決定通知書作成年月日().isEmpty()) {
                div.getShokanShikyuKetteiTsuchishoHakkouPrint().getTxtZenkaiHakkoYMD().setValue(new RDate(償還払支給判定結果List.get(0).
                        get償還払支給判定結果().get決定通知書作成年月日().toString()));
            }
        }
        ChohyoSeigyoHanyoManager manager = new ChohyoSeigyoHanyoManager();
        ChohyoSeigyoHanyo 帳票制御 = manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.
                getReportId(), new RString("支払予定日印字有無"));
        if (帳票制御.get設定値().equals(new RString("0"))) {
            div.getShokanShikyuKetteiTsuchishoHakkouPrint().getTxtShiharaiYoteiYMD().setVisible(false);
        }
    }

    /**
     * サービス提供年月を変更。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 償還払支給判定結果List List<ShokanShikyuKetteiTsuchishoHakkouBusiness>
     */
    public void onChange_ServiceTeikyo(HihokenshaNo 被保険者番号, List<ShokanShikyuKetteiTsuchishoHakkouBusiness> 償還払支給判定結果List) {
        RString サービス提供年月 = div.getDdlServiceTeikyoYM().getSelectedKey();
        List<RString> 整理番号List = get整理番号(new FlexibleYearMonth(サービス提供年月), 償還払支給判定結果List);
        div.getDdlSeiriNO().setDataSource(get整理番号DataSource(整理番号List));
        if (!整理番号List.isEmpty()) {
            div.getDdlSeiriNO().setSelectedValue(整理番号List.get(0));
        }
        RString 整理番号 = div.getDdlSeiriNO().getSelectedValue();
        FlexibleDate 決定通知書作成年月日 = null;
        for (ShokanShikyuKetteiTsuchishoHakkouBusiness shakan : 償還払支給判定結果List) {
            if (shakan.get償還払支給判定結果().getサービス提供年月().toDateString().equals(サービス提供年月) && shakan.
                    get償還払支給判定結果().get整理番号().equals(整理番号)) {
                決定通知書作成年月日 = shakan.get償還払支給判定結果().get決定通知書作成年月日();
                break;
            }
        }
        if (決定通知書作成年月日 != null && !決定通知書作成年月日.isEmpty()) {
            div.getShokanShikyuKetteiTsuchishoHakkouPrint().getTxtZenkaiHakkoYMD().setValue(new RDate(決定通知書作成年月日.toString()));
        } else {
            div.getShokanShikyuKetteiTsuchishoHakkouPrint().getTxtZenkaiHakkoYMD().clearValue();
        }
    }

    /**
     * 帳票発行処理のメソッドです。
     *
     * @param kozaID long
     * @param manage ShoukanbaraiShikyuKetteiTsuchisho
     * @param shikibetsuCode ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param 帳票制御汎用 ChohyoSeigyoHanyo
     * @param 差額支給対象者区分 RString
     * @return SourceDataCollection
     */
    public SourceDataCollection to帳票発行処理(long kozaID, ShoukanbaraiShikyuKetteiTsuchisho manage,
            ShikibetsuCode shikibetsuCode, HihokenshaNo 被保険者番号, ChohyoSeigyoHanyo 帳票制御汎用, RString 差額支給対象者区分) {
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(div.getDdlServiceTeikyoYM().getSelectedKey());
        RString 整理番号 = div.getDdlSeiriNO().getSelectedValue();
        FlexibleDate 支払予定日 = FlexibleDate.EMPTY;
        if (div.getShokanShikyuKetteiTsuchishoHakkouPrint().getTxtShiharaiYoteiYMD().getValue() != null) {
            支払予定日 = new FlexibleDate(div.getShokanShikyuKetteiTsuchishoHakkouPrint().getTxtShiharaiYoteiYMD().getValue().toDateString());
        }
        ShokanHanteiKekkaManager shokanHanteiKekkaManager = new ShokanHanteiKekkaManager();
        ShokanHanteiKekka 償還払支給判定結果 = shokanHanteiKekkaManager.get償還払支給判定結果(被保険者番号, サービス提供年月, 整理番号);
        ShoukanbaraiShikyuketteiTsuuchishoOutputEntity 償還払支給決定通知書 = manage.
                editShoukanbaraiShikyuketteiTsuuchisho(shikibetsuCode, 被保険者番号,
                        get帳票ID(帳票制御汎用),
                        サービス提供年月,
                        整理番号,
                        div.getShokanShikyuKetteiTsuchishoHakkouPrint().getCcdBunshoNO().get文書番号(),
                        new FlexibleDate(div.getShokanShikyuKetteiTsuchishoHakkouPrint().getTxtHakkouYMD().getValue().toDateString()),
                        支払予定日,
                        kozaID,
                        償還払支給判定結果.get支給_不支給決定区分(),
                        差額支給対象者区分);
        if (償還払支給決定通知書.getデータ有無().equals(new RString("1"))) {
            throw new ApplicationException(DbcErrorMessages.高額合算支給情報存在エラー.getMessage());
        }
        if (帳票制御汎用.get設定値().equals(new RString("0"))) {
            ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiService printService = new ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiService();
            return printService.print(getNashiIten(償還払支給決定通知書));
        } else {
            ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriService printService = new ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriService();
            return printService.print(getAriItem(償還払支給決定通知書));
        }

    }

    /**
     * 整理番号を変更。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 償還払支給判定結果List List<ShokanShikyuKetteiTsuchishoHakkouBusiness>
     */
    public void onChange_SeiriNO(HihokenshaNo 被保険者番号, List<ShokanShikyuKetteiTsuchishoHakkouBusiness> 償還払支給判定結果List) {
        RString サービス提供年月 = div.getDdlServiceTeikyoYM().getSelectedKey();
        RString 整理番号 = div.getDdlSeiriNO().getSelectedValue();
        FlexibleDate 決定通知書作成年月日 = null;
        for (ShokanShikyuKetteiTsuchishoHakkouBusiness shakan : 償還払支給判定結果List) {
            if (shakan.get償還払支給判定結果().getサービス提供年月().toDateString().equals(サービス提供年月) && shakan.
                    get償還払支給判定結果().get整理番号().equals(整理番号)) {
                決定通知書作成年月日 = shakan.get償還払支給判定結果().get決定通知書作成年月日();
                break;
            }
        }
        if (決定通知書作成年月日 != null && !決定通知書作成年月日.isEmpty()) {
            div.getShokanShikyuKetteiTsuchishoHakkouPrint().getTxtZenkaiHakkoYMD().setValue(new RDate(決定通知書作成年月日.toString()));
        } else {
            div.getShokanShikyuKetteiTsuchishoHakkouPrint().getTxtZenkaiHakkoYMD().clearValue();
        }
    }

    /**
     * 償還払支給判定結果を返します。
     *
     * @param 償還払支給判定結果List List<ShokanShikyuKetteiTsuchishoHakkouBusiness>
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @return ShokanHanteiKekka
     */
    public ShokanHanteiKekka get償還払支給判定結果(
            List<ShokanShikyuKetteiTsuchishoHakkouBusiness> 償還払支給判定結果List,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号) {
        ShokanHanteiKekka shokanHanteiKekka = null;
        for (ShokanShikyuKetteiTsuchishoHakkouBusiness 償還払支給判定結果 : 償還払支給判定結果List) {
            if (償還払支給判定結果.get償還払支給判定結果().getサービス提供年月().equals(サービス提供年月) && 償還払支給判定結果.
                    get償還払支給判定結果().get整理番号().equals(整理番号)) {
                shokanHanteiKekka = 償還払支給判定結果.get償還払支給判定結果();
                break;
            }
        }
        return shokanHanteiKekka;
    }

    /**
     * 入力チェック。
     *
     * @param 支払方法変更差止 ShiharaiHohoHenkoSashitome
     * @param 差額支給対象者区分 RString
     * @param shokanHanteiKekka ShokanHanteiKekka
     * @return 差額支給対象者区分
     */
    public RString check(ShiharaiHohoHenkoSashitome 支払方法変更差止, RString 差額支給対象者区分, ShokanHanteiKekka shokanHanteiKekka) {
        if (支払方法変更差止 != null) {
            if (支払方法変更差止.get差止控除番号() != null && !支払方法変更差止.get差止控除番号().isEmpty()) {
                throw new ApplicationException(DbcErrorMessages.支払方法差止エラー.getMessage());
            } else if (shokanHanteiKekka.get差額金額合計() != null && shokanHanteiKekka.get差額金額合計().compareTo(Decimal.ZERO) == 0) {
                throw new ApplicationException(DbcErrorMessages.差額支給エラー.getMessage());
            } else {
                差額支給対象者区分 = new RString("1");
            }
        }
        return 差額支給対象者区分;
    }

    private List<FlexibleYearMonth> getサービス提供年月(List<ShokanShikyuKetteiTsuchishoHakkouBusiness> 償還払支給判定結果List) {
        List<FlexibleYearMonth> サービス提供年月List = new ArrayList<>();
        FlexibleYearMonth 提供年月 = FlexibleYearMonth.EMPTY;
        for (ShokanShikyuKetteiTsuchishoHakkouBusiness shokan : 償還払支給判定結果List) {
            if (!提供年月.equals(shokan.get償還払支給判定結果().getサービス提供年月())) {
                サービス提供年月List.add(shokan.get償還払支給判定結果().getサービス提供年月());
            }
            提供年月 = shokan.get償還払支給判定結果().getサービス提供年月();
        }
        return サービス提供年月List;
    }

    private List<KeyValueDataSource> getサービス提供年月DataSource(List<FlexibleYearMonth> サービス提供年月List) {
        List<KeyValueDataSource> dataSources = new ArrayList<>();
        for (FlexibleYearMonth サービス提供年月 : サービス提供年月List) {
            KeyValueDataSource data = new KeyValueDataSource(サービス提供年月.toDateString(),
                    サービス提供年月.wareki().toDateString());
            dataSources.add(data);
        }
        return dataSources;
    }

    private List<RString> get整理番号(FlexibleYearMonth サービス提供年月,
            List<ShokanShikyuKetteiTsuchishoHakkouBusiness> 償還払支給判定結果List) {
        List<RString> 整理番号List = new ArrayList<>();
        for (ShokanShikyuKetteiTsuchishoHakkouBusiness shokan : 償還払支給判定結果List) {
            if (shokan.get償還払支給判定結果().getサービス提供年月().toDateString().equals(サービス提供年月.toDateString())) {
                整理番号List.add(shokan.get償還払支給判定結果().get整理番号());
            }
        }
        return 整理番号List;
    }

    private List<KeyValueDataSource> get整理番号DataSource(List<RString> 整理番号List) {
        List<KeyValueDataSource> dataSources = new ArrayList<>();
        for (RString 整理番号 : 整理番号List) {
            KeyValueDataSource data = new KeyValueDataSource(整理番号, 整理番号);
            dataSources.add(data);
        }
        return dataSources;
    }

    private ReportId get帳票ID(ChohyoSeigyoHanyo 帳票制御汎用) {
        if (帳票制御汎用.get設定値().equals(new RString("0"))) {
            return ReportIdDBC.DBC100002.getReportId();
        } else {
            return ReportIdDBC.DBC100003.getReportId();
        }
    }

    private List<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiItem>
            getNashiIten(ShoukanbaraiShikyuketteiTsuuchishoOutputEntity 償還払支給決定通知書) {
        List<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiItem> itemList = new ArrayList<>();
        ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiItem item = new ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiItem();
        item.setBunshoNo(償還払支給決定通知書.get償還払支給決定通知書().get文書番号());
        item.setTitle(償還払支給決定通知書.get償還払支給決定通知書().getTitle());
        item.setTitle2_1(償還払支給決定通知書.get償還払支給決定通知書().getTitle2());
        item.setTitle2_2_1(償還払支給決定通知書.get償還払支給決定通知書().getTitle221());
        item.setTitle2_2_2(償還払支給決定通知書.get償還払支給決定通知書().getTitle222());
        item.setTitle2_3_1(償還払支給決定通知書.get償還払支給決定通知書().getTitle231());
        item.setTitle2_3_2(償還払支給決定通知書.get償還払支給決定通知書().getTitle232());
        item.setTitle2_4(償還払支給決定通知書.get償還払支給決定通知書().getTitle24());
        item.setTsuchibun1(償還払支給決定通知書.get償還払支給決定通知書().get通知文1());
        item.setHihokenshaName(償還払支給決定通知書.get償還払支給決定通知書().get被保険者氏名());
        item.setHihokenshaNo1(償還払支給決定通知書.get償還払支給決定通知書().get被保険者番号1());
        item.setHihokenshaNo2(償還払支給決定通知書.get償還払支給決定通知書().get被保険者番号2());
        item.setHihokenshaNo3(償還払支給決定通知書.get償還払支給決定通知書().get被保険者番号3());
        item.setHihokenshaNo4(償還払支給決定通知書.get償還払支給決定通知書().get被保険者番号4());
        item.setHihokenshaNo5(償還払支給決定通知書.get償還払支給決定通知書().get被保険者番号5());
        item.setHihokenshaNo6(償還払支給決定通知書.get償還払支給決定通知書().get被保険者番号6());
        item.setHihokenshaNo7(償還払支給決定通知書.get償還払支給決定通知書().get被保険者番号7());
        item.setHihokenshaNo8(償還払支給決定通知書.get償還払支給決定通知書().get被保険者番号8());
        item.setHihokenshaNo9(償還払支給決定通知書.get償還払支給決定通知書().get被保険者番号9());
        item.setHihokenshaNo10(償還払支給決定通知書.get償還払支給決定通知書().get被保険者番号10());
        if (償還払支給決定通知書.get償還払支給決定通知書().getUketsukeYMD() != null) {
            item.setUketsukeYMD(new RString(償還払支給決定通知書.get償還払支給決定通知書().getUketsukeYMD().toString()));
        } else {
            item.setUketsukeYMD(RString.EMPTY);
        }
        if (償還払支給決定通知書.get償還払支給決定通知書().getKetteiYMD() != null) {
            item.setKetteiYMD(new RString(償還払支給決定通知書.get償還払支給決定通知書().getKetteiYMD().toString()));
        } else {
            item.setKetteiYMD(RString.EMPTY);
        }
        if (償還払支給決定通知書.get償還払支給決定通知書().getShiharaiKingakuUchiwakeRiyoshabun() != null) {
            item.setHonninShiharaiGaku(new RString(償還払支給決定通知書.get償還払支給決定通知書().
                    getShiharaiKingakuUchiwakeRiyoshabun().toString()));
        } else {
            item.setHonninShiharaiGaku(RString.EMPTY);
        }
        if (償還払支給決定通知書.get償還払支給決定通知書().getServiceTeikyoYM() != null) {
            item.setTaishoYM(償還払支給決定通知書.get償還払支給決定通知書().getServiceTeikyoYM().toDateString());
        } else {
            item.setTaishoYM(RString.EMPTY);
        }
        item.setKyufuShu1(償還払支給決定通知書.get償還払支給決定通知書().get給付の種類1());
        item.setKyufuShu2(償還払支給決定通知書.get償還払支給決定通知書().get給付の種類2());
        item.setKyufuShu3(償還払支給決定通知書.get償還払支給決定通知書().get給付の種類3());
        item.setKekka(償還払支給決定通知書.get償還払支給決定通知書().getShikyuHushikyuKetteiKubun());
        if (償還払支給決定通知書.get償還払支給決定通知書().getShiharaiKingaku() != null) {
            item.setShikyuGaku(new RString(償還払支給決定通知書.get償還払支給決定通知書().getShiharaiKingaku().toString()));
        } else {
            item.setShikyuGaku(RString.EMPTY);
        }
        item.setRiyu1(償還払支給決定通知書.get償還払支給決定通知書().get増減の理由1());
        item.setRiyuTitle(償還払支給決定通知書.get償還払支給決定通知書().get増減の理由Title());
        item.setRiyu2(償還払支給決定通知書.get償還払支給決定通知書().get増減の理由2());
        item.setRiyu3(償還払支給決定通知書.get償還払支給決定通知書().get増減の理由3());
        item.setTorikeshi1(償還払支給決定通知書.get償還払支給決定通知書().getTorikeshi1());
        item.setTorikeshi2(償還払支給決定通知書.get償還払支給決定通知書().getTorikeshi2());
        item.setBankName(償還払支給決定通知書.get償還払支給決定通知書().getBankName());
        item.setMochimono1(償還払支給決定通知書.get償還払支給決定通知書().getMochimono1());
        item.setTorikeshiMochimono1(償還払支給決定通知書.get償還払支給決定通知書().getTorikeshiMochimono1());
        item.setBranchBankName(償還払支給決定通知書.get償還払支給決定通知書().getBranchBankName());
        item.setMochimono2(償還払支給決定通知書.get償還払支給決定通知書().getMochimono2());
        item.setTorikeshiMochimono2(償還払支給決定通知書.get償還払支給決定通知書().getTorikeshiMochimono2());
        item.setMochimono3(償還払支給決定通知書.get償還払支給決定通知書().getMochimono3());
        item.setShiharaiBasho(償還払支給決定通知書.get償還払支給決定通知書().getShiharaiBasho());
        item.setTorikeshiShiharaibasho(償還払支給決定通知書.get償還払支給決定通知書().getTorikeshiShiharaibasho());
        item.setShumokuTitle(償還払支給決定通知書.get償還払支給決定通知書().getShumokuTitle());
        item.setKouzaShu(償還払支給決定通知書.get償還払支給決定通知書().getKouzaShu());
        item.setBangoTitle(償還払支給決定通知書.get償還払支給決定通知書().getBangoTitle());
        item.setKouzaNo(償還払支給決定通知書.get償還払支給決定通知書().getKouzaNo());
        item.setShiharaiStartYMD(償還払支給決定通知書.get償還払支給決定通知書().getShiharaiStartYMD());
        item.setKouzaMeigi(償還払支給決定通知書.get償還払支給決定通知書().getKouzaMeigi());
        item.setTorikeshiShiharaikikan(償還払支給決定通知書.get償還払支給決定通知書().getTorikeshiShiharaikikan());
        item.setShiharaiEndYMD(償還払支給決定通知書.get償還払支給決定通知書().getShiharaiEndYMD());
        item.setKaraFugo(償還払支給決定通知書.get償還払支給決定通知書().getKaraFugo());
        item.setShiharaiStartHMS(償還払支給決定通知書.get償還払支給決定通知書().getShiharaiStart());
        item.setShiharaiEndHMS(償還払支給決定通知書.get償還払支給決定通知書().getShiharaiEnd());
        item.setTsuchibun2(償還払支給決定通知書.get償還払支給決定通知書().get通知文2());
        item.setSeirino(償還払支給決定通知書.get償還払支給決定通知書().getSeirino());
        item.setTsuchino(償還払支給決定通知書.get償還払支給決定通知書().getTsuchino());
        item.setRemban(償還払支給決定通知書.get償還払支給決定通知書().get通番());
        item.setTsuchibunLarge(償還払支給決定通知書.get償還払支給決定通知書().get通知文3());
        item.setTsuchibunMix1(償還払支給決定通知書.get償還払支給決定通知書().get通知文4());
        item.setTsuchibunMix2(償還払支給決定通知書.get償還払支給決定通知書().get通知文5());
        item.setTsuchibunMixtwo1(償還払支給決定通知書.get償還払支給決定通知書().get通知文6());
        item.setTsuchibunMixtwo2(償還払支給決定通知書.get償還払支給決定通知書().get通知文7());
        item.setYubinNo(償還払支給決定通知書.get償還払支給決定通知書().getYubinNo());
        item.setGyoseiku2(償還払支給決定通知書.get償還払支給決定通知書().getGyoseiku2());
        item.setJusho4(償還払支給決定通知書.get償還払支給決定通知書().getJusho4());
        item.setJushoText(償還払支給決定通知書.get償還払支給決定通知書().getJushoText());
        item.setJusho5(償還払支給決定通知書.get償還払支給決定通知書().getJusho5());
        item.setJusho6(償還払支給決定通知書.get償還払支給決定通知書().getJusho6());
        item.setKatagakiText(償還払支給決定通知書.get償還払支給決定通知書().getKatagakiText());
        item.setKatagaki3(償還払支給決定通知書.get償還払支給決定通知書().getKatagaki3());
        item.setKatagakiSmall2(償還払支給決定通知書.get償還払支給決定通知書().getKatagakiSmall2());
        item.setKatagaki4(償還払支給決定通知書.get償還払支給決定通知書().getKatagaki4());
        item.setKatagakiSmall1(償還払支給決定通知書.get償還払支給決定通知書().getKatagakiSmall1());
        item.setShimei5(償還払支給決定通知書.get償還払支給決定通知書().getShimei5());
        item.setShimeiSmall2(償還払支給決定通知書.get償還払支給決定通知書().getShimeiSmall2());
        item.setShimeiText(償還払支給決定通知書.get償還払支給決定通知書().getShimeiText());
        item.setMeishoFuyo2(償還払支給決定通知書.get償還払支給決定通知書().getMeishoFuyo2());
        item.setShimeiSmall1(償還払支給決定通知書.get償還払支給決定通知書().getShimeiSmall1());
        item.setDainoKubunMei(償還払支給決定通知書.get償還払支給決定通知書().getDainoKubunMei());
        item.setShimei6(償還払支給決定通知書.get償還払支給決定通知書().getShimei6());
        item.setMeishoFuyo1(償還払支給決定通知書.get償還払支給決定通知書().getMeishoFuyo1());
        item.setSamabunShimeiText(償還払支給決定通知書.get償還払支給決定通知書().getSamabunShimeiText());
        item.setKakkoLeft2(償還払支給決定通知書.get償還払支給決定通知書().getKakkoLeft2());
        item.setSamabunShimei2(償還払支給決定通知書.get償還払支給決定通知書().getSamabunShimei2());
        item.setSamabunShimeiSmall2(償還払支給決定通知書.get償還払支給決定通知書().getSamabunShimeiSmall2());
        item.setSamaBun2(償還払支給決定通知書.get償還払支給決定通知書().getSamaBun2());
        item.setKakkoRight2(償還払支給決定通知書.get償還払支給決定通知書().getKakkoRight2());
        item.setKakkoLeft1(償還払支給決定通知書.get償還払支給決定通知書().getKakkoLeft1());
        item.setSamabunShimei1(償還払支給決定通知書.get償還払支給決定通知書().getSamabunShimei1());
        item.setSamaBun1(償還払支給決定通知書.get償還払支給決定通知書().getSamaBun1());
        item.setKakkoRight1(償還払支給決定通知書.get償還払支給決定通知書().getSamaBun1());
        item.setSamabunShimeiSmall1(償還払支給決定通知書.get償還払支給決定通知書().getSamabunShimeiSmall1());
        item.setCustomerBarCode(償還払支給決定通知書.get償還払支給決定通知書().getCustomerBarCode());
        itemList.add(item);
        return itemList;
    }

    private List<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem>
            getAriItem(ShoukanbaraiShikyuketteiTsuuchishoOutputEntity 償還払支給決定通知書) {
        List<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem> items = new ArrayList<>();
        ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem item = new ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem();
        item.setBunshoNo(償還払支給決定通知書.get償還払支給決定通知書().get文書番号());
        item.setTitle(償還払支給決定通知書.get償還払支給決定通知書().getTitle());
        item.setTitle2_1(償還払支給決定通知書.get償還払支給決定通知書().getTitle2());
        item.setTitle2_2_1(償還払支給決定通知書.get償還払支給決定通知書().getTitle221());
        item.setTitle2_2_2(償還払支給決定通知書.get償還払支給決定通知書().getTitle222());
        item.setTitle2_3_1(償還払支給決定通知書.get償還払支給決定通知書().getTitle231());
        item.setTitle2_3_2(償還払支給決定通知書.get償還払支給決定通知書().getTitle232());
        item.setTitle2_4(償還払支給決定通知書.get償還払支給決定通知書().getTitle24());
        item.setTsuchibun1(償還払支給決定通知書.get償還払支給決定通知書().get通知文1());
        item.setHihokenshaName(償還払支給決定通知書.get償還払支給決定通知書().get被保険者氏名());
        item.setHihokenshaNo1(償還払支給決定通知書.get償還払支給決定通知書().get被保険者番号1());
        item.setHihokenshaNo2(償還払支給決定通知書.get償還払支給決定通知書().get被保険者番号2());
        item.setHihokenshaNo3(償還払支給決定通知書.get償還払支給決定通知書().get被保険者番号3());
        item.setHihokenshaNo4(償還払支給決定通知書.get償還払支給決定通知書().get被保険者番号4());
        item.setHihokenshaNo5(償還払支給決定通知書.get償還払支給決定通知書().get被保険者番号5());
        item.setHihokenshaNo6(償還払支給決定通知書.get償還払支給決定通知書().get被保険者番号6());
        item.setHihokenshaNo7(償還払支給決定通知書.get償還払支給決定通知書().get被保険者番号7());
        item.setHihokenshaNo8(償還払支給決定通知書.get償還払支給決定通知書().get被保険者番号8());
        item.setHihokenshaNo9(償還払支給決定通知書.get償還払支給決定通知書().get被保険者番号9());
        item.setHihokenshaNo10(償還払支給決定通知書.get償還払支給決定通知書().get被保険者番号10());
        if (償還払支給決定通知書.get償還払支給決定通知書().getUketsukeYMD() != null) {
            item.setUketsukeYMD(new RString(償還払支給決定通知書.get償還払支給決定通知書().getUketsukeYMD().toString()));
        } else {
            item.setUketsukeYMD(RString.EMPTY);
        }
        if (償還払支給決定通知書.get償還払支給決定通知書().getKetteiYMD() != null) {
            item.setKetteiYMD(new RString(償還払支給決定通知書.get償還払支給決定通知書().getKetteiYMD().toString()));
        } else {
            item.setKetteiYMD(RString.EMPTY);
        }
        if (償還払支給決定通知書.get償還払支給決定通知書().getShiharaiKingakuUchiwakeRiyoshabun() != null) {
            item.setHonninShiharaiGaku(new RString(償還払支給決定通知書.get償還払支給決定通知書().getShiharaiKingakuUchiwakeRiyoshabun().toString()));
        } else {
            item.setHonninShiharaiGaku(RString.EMPTY);
        }
        if (償還払支給決定通知書.get償還払支給決定通知書().getServiceTeikyoYM() != null) {
            item.setTaishoYM(償還払支給決定通知書.get償還払支給決定通知書().getServiceTeikyoYM().toDateString());
        } else {
            item.setTaishoYM(RString.EMPTY);
        }
        item.setKyufuShu1(償還払支給決定通知書.get償還払支給決定通知書().get給付の種類1());
        item.setKyufuShu2(償還払支給決定通知書.get償還払支給決定通知書().get給付の種類2());
        item.setKyufuShu3(償還払支給決定通知書.get償還払支給決定通知書().get給付の種類3());
        item.setKekka(償還払支給決定通知書.get償還払支給決定通知書().getShikyuHushikyuKetteiKubun());
        if (償還払支給決定通知書.get償還払支給決定通知書().getShiharaiKingaku() != null) {
            item.setShikyuGaku(new RString(償還払支給決定通知書.get償還払支給決定通知書().getShiharaiKingaku().toString()));
        } else {
            item.setShikyuGaku(RString.EMPTY);
        }
        item.setRiyu1(償還払支給決定通知書.get償還払支給決定通知書().get増減の理由1());
        item.setRiyuTitle(償還払支給決定通知書.get償還払支給決定通知書().get増減の理由Title());
        item.setRiyu2(償還払支給決定通知書.get償還払支給決定通知書().get増減の理由2());
        item.setRiyu3(償還払支給決定通知書.get償還払支給決定通知書().get増減の理由3());
        item.setTorikeshi1(償還払支給決定通知書.get償還払支給決定通知書().getTorikeshi1());
        item.setTorikeshi2(償還払支給決定通知書.get償還払支給決定通知書().getTorikeshi2());
        item.setBankName(償還払支給決定通知書.get償還払支給決定通知書().getBankName());
        item.setMochimono1(償還払支給決定通知書.get償還払支給決定通知書().getMochimono1());
        item.setTorikeshiMochimono1(償還払支給決定通知書.get償還払支給決定通知書().getTorikeshiMochimono1());
        item.setBranchBankName(償還払支給決定通知書.get償還払支給決定通知書().getBranchBankName());
        item.setMochimono2(償還払支給決定通知書.get償還払支給決定通知書().getMochimono2());
        item.setTorikeshiMochimono2(償還払支給決定通知書.get償還払支給決定通知書().getTorikeshiMochimono2());
        item.setMochimono3(償還払支給決定通知書.get償還払支給決定通知書().getMochimono3());
        item.setShiharaiBasho(償還払支給決定通知書.get償還払支給決定通知書().getShiharaiBasho());
        item.setTorikeshiShiharaibasho(償還払支給決定通知書.get償還払支給決定通知書().getTorikeshiShiharaibasho());
        item.setShumokuTitle(償還払支給決定通知書.get償還払支給決定通知書().getShumokuTitle());
        item.setKouzaShu(償還払支給決定通知書.get償還払支給決定通知書().getKouzaShu());
        item.setBangoTitle(償還払支給決定通知書.get償還払支給決定通知書().getBangoTitle());
        item.setKouzaNo(償還払支給決定通知書.get償還払支給決定通知書().getKouzaNo());
        item.setShiharaiStartYMD(償還払支給決定通知書.get償還払支給決定通知書().getShiharaiStartYMD());
        item.setKouzaMeigi(償還払支給決定通知書.get償還払支給決定通知書().getKouzaMeigi());
        item.setTorikeshiShiharaikikan(償還払支給決定通知書.get償還払支給決定通知書().getTorikeshiShiharaikikan());
        item.setShiharaiEndYMD(償還払支給決定通知書.get償還払支給決定通知書().getShiharaiEndYMD());
        item.setKaraFugo(償還払支給決定通知書.get償還払支給決定通知書().getKaraFugo());
        item.setShiharaiStartHMS(償還払支給決定通知書.get償還払支給決定通知書().getShiharaiStart());
        item.setShiharaiEndHMS(償還払支給決定通知書.get償還払支給決定通知書().getShiharaiEnd());
        if (償還払支給決定通知書.get償還払支給決定通知書().get支払予定日() != null) {
            item.setSihaYoYmd(new RString(償還払支給決定通知書.get償還払支給決定通知書().get支払予定日().toString()));
        } else {
            item.setSihaYoYmd(RString.EMPTY);
        }
        item.setTsuchibun２(償還払支給決定通知書.get償還払支給決定通知書().get通知文2());
        item.setSeirino(償還払支給決定通知書.get償還払支給決定通知書().getSeirino());
        item.setTsuchino(償還払支給決定通知書.get償還払支給決定通知書().getTsuchino());
        item.setRemban(償還払支給決定通知書.get償還払支給決定通知書().get通番());
        item.setTsuchibunLarge(償還払支給決定通知書.get償還払支給決定通知書().get通知文3());
        item.setTsuchibunMix1(償還払支給決定通知書.get償還払支給決定通知書().get通知文4());
        item.setTsuchibunMix2(償還払支給決定通知書.get償還払支給決定通知書().get通知文5());
        item.setTsuchibunMixtwo1(償還払支給決定通知書.get償還払支給決定通知書().get通知文6());
        item.setTsuchibunMixtwo2(償還払支給決定通知書.get償還払支給決定通知書().get通知文7());
        item.setYubinNo(償還払支給決定通知書.get償還払支給決定通知書().getYubinNo());
        item.setGyoseiku2(償還払支給決定通知書.get償還払支給決定通知書().getGyoseiku2());
        item.setJusho4(償還払支給決定通知書.get償還払支給決定通知書().getJusho4());
        item.setJushoText(償還払支給決定通知書.get償還払支給決定通知書().getJushoText());
        item.setJusho5(償還払支給決定通知書.get償還払支給決定通知書().getJusho5());
        item.setJusho6(償還払支給決定通知書.get償還払支給決定通知書().getJusho6());
        item.setKatagakiText(償還払支給決定通知書.get償還払支給決定通知書().getKatagakiText());
        item.setKatagaki3(償還払支給決定通知書.get償還払支給決定通知書().getKatagaki3());
        item.setKatagakiSmall2(償還払支給決定通知書.get償還払支給決定通知書().getKatagakiSmall2());
        item.setKatagaki4(償還払支給決定通知書.get償還払支給決定通知書().getKatagaki4());
        item.setKatagakiSmall1(償還払支給決定通知書.get償還払支給決定通知書().getKatagakiSmall1());
        item.setShimei5(償還払支給決定通知書.get償還払支給決定通知書().getShimei5());
        item.setShimeiSmall2(償還払支給決定通知書.get償還払支給決定通知書().getShimeiSmall2());
        item.setShimeiText(償還払支給決定通知書.get償還払支給決定通知書().getShimeiText());
        item.setMeishoFuyo2(償還払支給決定通知書.get償還払支給決定通知書().getMeishoFuyo2());
        item.setShimeiSmall1(償還払支給決定通知書.get償還払支給決定通知書().getShimeiSmall1());
        item.setDainoKubunMei(償還払支給決定通知書.get償還払支給決定通知書().getDainoKubunMei());
        item.setShimei6(償還払支給決定通知書.get償還払支給決定通知書().getShimei6());
        item.setMeishoFuyo1(償還払支給決定通知書.get償還払支給決定通知書().getMeishoFuyo1());
        item.setSamabunShimeiText(償還払支給決定通知書.get償還払支給決定通知書().getSamabunShimeiText());
        item.setKakkoLeft2(償還払支給決定通知書.get償還払支給決定通知書().getKakkoLeft2());
        item.setSamabunShimei2(償還払支給決定通知書.get償還払支給決定通知書().getSamabunShimei2());
        item.setSamabunShimeiSmall2(償還払支給決定通知書.get償還払支給決定通知書().getSamabunShimeiSmall2());
        item.setSamaBun2(償還払支給決定通知書.get償還払支給決定通知書().getSamaBun2());
        item.setKakkoRight2(償還払支給決定通知書.get償還払支給決定通知書().getKakkoRight2());
        item.setKakkoLeft1(償還払支給決定通知書.get償還払支給決定通知書().getKakkoLeft1());
        item.setSamabunShimei1(償還払支給決定通知書.get償還払支給決定通知書().getSamabunShimei1());
        item.setSamaBun1(償還払支給決定通知書.get償還払支給決定通知書().getSamaBun1());
        item.setKakkoRight1(償還払支給決定通知書.get償還払支給決定通知書().getSamaBun1());
        item.setSamabunShimeiSmall1(償還払支給決定通知書.get償還払支給決定通知書().getSamabunShimeiSmall1());
        item.setCustomerBarCode(償還払支給決定通知書.get償還払支給決定通知書().getCustomerBarCode());
        items.add(item);
        return items;
    }
}
