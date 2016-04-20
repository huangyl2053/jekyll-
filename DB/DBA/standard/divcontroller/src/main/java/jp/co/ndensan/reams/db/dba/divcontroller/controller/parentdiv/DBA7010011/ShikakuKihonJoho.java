package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA7010011;

import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tajushochitokureisyakanri.TaJushochiTokureisyaKanriMaster;
import jp.co.ndensan.reams.db.dba.business.core.tashichosonjushochitokureishisetsuhenkotsuchisho.TatokuKanrenChohyoHenkoTsuchishoBusiness;
import jp.co.ndensan.reams.db.dba.business.core.tashichosonjushochitokureishisetsuhenkotsuchisho.TatokuKanrenChohyoRenrakuhyoBusiness;
import jp.co.ndensan.reams.db.dba.business.core.tashichosonjushochitokureishisetsutaishotsuchisho.TatokuKanrenChohyoTaishoTsuchishoBusiness;
import jp.co.ndensan.reams.db.dba.business.core.tatokukanrenchohyoshiji.TatokuKanrenChohyoShijiData;
import jp.co.ndensan.reams.db.dba.business.report.shisetsuhenkotsuchisho.ShisetsuHenkoTsuchishoItem;
import jp.co.ndensan.reams.db.dba.business.report.shisetsutaishotsuchisho.ShisetsuTaishoTsuchishoItem;
import jp.co.ndensan.reams.db.dba.business.report.tashichosonjushochitokureisharenrakuhyo.TashichosonJushochitokureishaRenrakuhyoItem;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.definition.tatokukanrenchohyoshijidata.TatokuKanrenParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7010011.ShikakuKihonJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA7010011.ShikakuKihonJohoHandler;
import jp.co.ndensan.reams.db.dba.service.core.tajushochito.TaJushochiTokureisyaKanriManager;
import jp.co.ndensan.reams.db.dba.service.core.tashichosonjushochitokureishisetsuhenkotsuchisho.TaShichosonJushochiTokureiShisetsuHenkoTsuchishoFinder;
import jp.co.ndensan.reams.db.dba.service.core.tashichosonjushochitokureishisetsutaishotsuchisho.TaShichosonJushochiTokureiShisetsuTaishoTsuchishoFinder;
import jp.co.ndensan.reams.db.dba.service.report.shisetsuhenkotsuchisho.ShisetsuHenkoTsuchishoPrintService;
import jp.co.ndensan.reams.db.dba.service.report.shisetsutaishotsuchisho.ShisetsuTaishoTsuchishoPrintService;
import jp.co.ndensan.reams.db.dba.service.report.tashichosonjushochitokureisharenrakuhyo.TashichosonJushochitokureishaRenrakuhyoPrintService;
import jp.co.ndensan.reams.db.dba.service.tashichosonjushochitokureisharenrakuhyo.TashichosonJushochitokureishaRenrakuhyoFinder;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStateKey;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.db.dbz.service.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ZenkokuJushoInput.ZenkokuJushoInputDiv;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.BunshoNoFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.IBunshoNoFinder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * 他市町村住所地特例者関連帳票発行のクラスです。
 *
 * @reamsid_L DBA-0380-020 houtianpeng
 */
public class ShikakuKihonJoho {

    private static final RString 遷移元メニューID_DBAMN12008 = new RString("DBAMN12008");
    private static final RString 遷移元メニューID_DBAMN12009 = new RString("DBAMN12009");
    private static final RString 遷移元メニューID_DBAMN12010 = new RString("DBAMN12010");
    private static final RString 発行ボタン = new RString("btnReportPublish");
    private static final RString 完了ボタン = new RString("btnComplete");
    private static final RString 汎用キー_文書番号 = new RString("文書番号");

    /**
     * 他市町村住所地特例者関連帳票発行を初期化します。
     *
     * @param div ShikakuKihonJohoDiv
     * @return ResponseData<ShikakuKihonJohoDiv>
     */
    public ResponseData<ShikakuKihonJohoDiv> onLoad(ShikakuKihonJohoDiv div) {

        div.getCcdKaigoAtenaInfo().onLoad(ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class).get識別コード());
        div.getCcdKaigoShikakuJoho().onLoad(ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class).get被保険者番号());
        List<TaJushochiTokureisyaKanriMaster> tekiyoJohoList = get適用情報(ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class).get識別コード());
        createHandler(div).適用情報Gridの設定(tekiyoJohoList);

        div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getCcdPrintContentsSetting().initialize(true, RDate.getNowDate(), true, false, RDate.MAX, false);
        div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getCcdZenkokuJushoInput().setYubinNoDisplayMode(ZenkokuJushoInputDiv.YubinNoDisplayMode.改行して表示する);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(完了ボタン, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(発行ボタン, true);
        return ResponseData.of(div).respond();
    }

    /**
     * 適用情報Grid。
     *
     * @param div ShikakuKihonJohoDiv
     * @return ResponseData<ShikakuKihonJohoDiv>
     */
    public ResponseData<ShikakuKihonJohoDiv> onClick_dgJushochiTokureiRireki(ShikakuKihonJohoDiv div) {

        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        RString 文書番号取得 = RString.EMPTY;
        if (遷移元メニューID_DBAMN12008.equals(menuID)) {

            文書番号取得 = get文書番号取得(ReportIdDBA.DBA100007.getReportId());
        }
        if (遷移元メニューID_DBAMN12009.equals(menuID)) {

            文書番号取得 = get文書番号取得(ReportIdDBA.DBA100005.getReportId());
        }
        if (遷移元メニューID_DBAMN12010.equals(menuID)) {

            文書番号取得 = get文書番号取得(ReportIdDBA.DBA100006.getReportId());
        }
        createHandler(div).適用情報の編集(文書番号取得);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(発行ボタン, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(完了ボタン, false);
        return ResponseData.of(div).respond();
    }

    /**
     * 前回番号取得ボタン。
     *
     * @param div ShikakuKihonJohoDiv
     * @return ResponseData<ShikakuKihonJohoDiv>
     */
    public ResponseData<ShikakuKihonJohoDiv> onClick_btnZenkaiBango(ShikakuKihonJohoDiv div) {

        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        RString 文書番号取得 = RString.EMPTY;
        if (遷移元メニューID_DBAMN12008.equals(menuID)) {

            文書番号取得 = get文書番号取得(ReportIdDBA.DBA100007.getReportId());
        }
        if (遷移元メニューID_DBAMN12009.equals(menuID)) {

            文書番号取得 = get文書番号取得(ReportIdDBA.DBA100005.getReportId());
        }
        if (遷移元メニューID_DBAMN12010.equals(menuID)) {

            文書番号取得 = get文書番号取得(ReportIdDBA.DBA100006.getReportId());
        }
        div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtBunshoBango().setValue(文書番号取得);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(完了ボタン, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(発行ボタン, true);
        return ResponseData.of(div).respond();
    }

    /**
     * 自動付番ボタン。
     *
     * @param div ShikakuKihonJohoDiv
     * @return ResponseData<ShikakuKihonJohoDiv>
     */
    public ResponseData<ShikakuKihonJohoDiv> onClick_btnJidoFuban(ShikakuKihonJohoDiv div) {
        CountedItem countedItem = Saiban.get(SubGyomuCode.DBZ介護共通, 汎用キー_文書番号);
        IBunshoNoFinder bushoFineder = BunshoNoFinderFactory.createInstance();
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        ReportId 帳票ID = new ReportId("");
        if (遷移元メニューID_DBAMN12008.equals(menuID)) {

            帳票ID = ReportIdDBA.DBA100007.getReportId();
        }
        if (遷移元メニューID_DBAMN12009.equals(menuID)) {

            帳票ID = ReportIdDBA.DBA100005.getReportId();
        }
        if (遷移元メニューID_DBAMN12010.equals(menuID)) {

            帳票ID = ReportIdDBA.DBA100006.getReportId();
        }
        BunshoNo bushoNo = bushoFineder.get文書番号管理(帳票ID, FlexibleDate.getNowDate());
        div.getTajutokuTekiyoJohoIchiran().getReportPublish().
                getHenshuNaiyo().getTxtBunshoBango().setValue(bushoNo.edit文書番号(countedItem.nextString()));
        CommonButtonHolder.setVisibleByCommonButtonFieldName(発行ボタン, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(完了ボタン, false);
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行する」ボタン押下の場合、帳票を印刷します。
     *
     * @param div ShikakuKihonJohoDiv
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<SourceDataCollection> btnPrint(ShikakuKihonJohoDiv div) {

        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        if (遷移元メニューID_DBAMN12008.equals(menuID)) {

            TatokuKanrenChohyoShijiData business = 帳票発行指示データ作成(div);
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(発行ボタン, true);
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(完了ボタン, false);
            TatokuKanrenChohyoRenrakuhyoBusiness renrakuhyoBusiness = TaShichosonJushochiTokureiShisetsuHenkoTsuchishoFinder
                    .createInstance().setTatokuKanrenChohyoRenrakuhyo(business);
            return ResponseData.of(new TashichosonJushochitokureishaRenrakuhyoPrintService().
                    print(dba100007_Item(renrakuhyoBusiness))).respond();
        }
        if (遷移元メニューID_DBAMN12009.equals(menuID)) {

            TatokuKanrenChohyoShijiData business = 帳票発行指示データ作成(div);
            CommonButtonHolder.setVisibleByCommonButtonFieldName(発行ボタン, false);
            CommonButtonHolder.setVisibleByCommonButtonFieldName(完了ボタン, true);
            TatokuKanrenChohyoTaishoTsuchishoBusiness tsuchishoBusiness = TaShichosonJushochiTokureiShisetsuTaishoTsuchishoFinder
                    .createInstance().setTatokuKanrenChohyoTaishoTsuchisho(business);
            return ResponseData.of(new ShisetsuTaishoTsuchishoPrintService().
                    print(dba100005_Item(tsuchishoBusiness))).respond();
        }
        TatokuKanrenChohyoShijiData business = 帳票発行指示データ作成(div);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(発行ボタン, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(完了ボタン, true);
        TatokuKanrenChohyoHenkoTsuchishoBusiness tsuchishoBusiness = TaShichosonJushochiTokureiShisetsuHenkoTsuchishoFinder
                .createInstance().setTatokuKanrenChohyoTaishoTsuchisho(business);
        return ResponseData.of(new ShisetsuHenkoTsuchishoPrintService().
                print(dba100006_Item(tsuchishoBusiness))).respond();
    }

    /**
     * 「発行する」ボタン押下の場合、帳票を印刷します。
     *
     * @param div ShikakuKihonJohoDiv
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<ShikakuKihonJohoDiv> onClick_btnCheck(ShikakuKihonJohoDiv div) {

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        return ResponseData.of(div).respond();
    }

    private List<TaJushochiTokureisyaKanriMaster> get適用情報(ShikibetsuCode 識別コード) {

        return TaJushochiTokureisyaKanriManager.createInstance().getTaJushochiTokureiTekiyoJyoho(識別コード).records();
    }

    private TatokuKanrenChohyoShijiData 帳票発行指示データ作成(ShikakuKihonJohoDiv div) {

        return TashichosonJushochitokureishaRenrakuhyoFinder.createInstance().
                setChohyoData(TatokuKanrenParameter.
                        createParam_TatokuKanren(
                                div.getTajutokuTekiyoJohoIchiran().getReportPublish().
                                getHenshuNaiyo().getCcdZenkokuJushoInput().get郵便番号() == null
                                ? YubinNo.EMPTY : div.getTajutokuTekiyoJohoIchiran().getReportPublish().
                                getHenshuNaiyo().getCcdZenkokuJushoInput().get郵便番号(),
                                div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtBunshoBango() == null
                                ? RString.EMPTY : div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtBunshoBango().getValue(),
                                div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getCcdZenkokuJushoInput().get全国住所コード() == null
                                ? RString.EMPTY : div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getCcdZenkokuJushoInput().get全国住所コード().value(),
                                div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getCcdPrintContentsSetting().getIssueDate() == null ? FlexibleDate.EMPTY
                                : new FlexibleDate(div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getCcdPrintContentsSetting().getIssueDate().toDateString()),
                                // TODO 画面.役所名QA1048
                                div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtYakushoMeiOne() == null ? RString.EMPTY
                                : div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtYakushoMeiOne().getValue(),
                                div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtOnchu() == null ? RString.EMPTY
                                : div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtOnchu().getValue(),
                                div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtTantokamei() == null ? RString.EMPTY
                                : div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtTantokamei().getValue(),
                                div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtSam() == null ? RString.EMPTY
                                : div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtSam().getValue(),
                                ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class).get識別コード() == null
                                ? ShikibetsuCode.EMPTY : ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class).get識別コード(),
                                ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class).get被保険者番号() == null
                                ? RString.EMPTY : ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class).get被保険者番号().value(),
                                div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo() == null ? FlexibleDate.EMPTY
                                : new FlexibleDate(div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().get他市町村住所地特例異動日()),
                                div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().get他市町村住所地特例枝番(),
                                div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().get入所日() == null ? FlexibleDate.EMPTY
                                : new FlexibleDate(div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().get入所日())));
    }
    private TashichosonJushochitokureishaRenrakuhyoItem dba100007_Item(TatokuKanrenChohyoRenrakuhyoBusiness business) {

        TashichosonJushochitokureishaRenrakuhyoItem item = new TashichosonJushochitokureishaRenrakuhyoItem();
        item.setHokenshaYubinNo(business.get保険者郵便番号());
        item.setBunshoNo(business.get文書番号());
        item.setHokenshaJusho(business.get保険者住所());
        item.setHakkoYMD(business.get発行年月日());
        item.setHokenshaName(business.get保険者名());
        item.setTantoBushoName(business.get担当部署名());
        item.setBarcode(business.getバーコード情報());
        item.setMidashi(business.get見出し());
        item.setTennyuYMD(business.get転入年月日());
        item.setNyushoYMD(business.get入所年月日());
        item.setHihokenshaNo1(business.get被保険者番号１());
        item.setHihokenshaNo2(business.get被保険者番号２());
        item.setHihokenshaNo3(business.get被保険者番号３());
        item.setHihokenshaNo4(business.get被保険者番号４());
        item.setHihokenshaNo5(business.get被保険者番号５());
        item.setHihokenshaNo6(business.get被保険者番号６());
        item.setHihokenshaNo7(business.get被保険者番号７());
        item.setHihokenshaNo8(business.get被保険者番号８());
        item.setHihokenshaNo9(business.get被保険者番号９());
        item.setHihokenshaNo10(business.get被保険者番号１０());
        item.setTaishoshaNameKana(business.get対象者名カナ());
        item.setTaishoshaName(business.get対象者名());
        item.setBirthYMD(business.get誕生日());
        item.setSeibetsu(business.get性別());
        item.setTennyumaeYubinNo(business.get郵便番号());
        item.setTennyumaeJusho(business.get住所());
        item.setShisetsuName(business.get施設名称());
        item.setShisetsuTelNo(business.get施設電話番号());
        item.setShisetsuFaxNo(business.get施設FAX番号());
        item.setShisetsuYubinNo(business.get施設郵便番号());
        item.setShisetsuJusho(business.get施設住所());
        return item;
    }

    private ShisetsuTaishoTsuchishoItem dba100005_Item(TatokuKanrenChohyoTaishoTsuchishoBusiness business) {

        ShisetsuTaishoTsuchishoItem item = new ShisetsuTaishoTsuchishoItem();
        item.setHokenshaYubinNo(business.get保険者郵便番号());
        item.setBunshoNo(business.get文書番号());
        item.setHokenshaJusho(business.get保険者住所());
        item.setHakkoYMD(business.get発行年月日());
        item.setHokenshaName(business.get保険者名());
        item.setTantoBushoName(business.get担当部署名());
        item.setBarcode(business.getバーコード情報());
        item.setMidashi(business.get見出し());
        item.setHihokenshaNo1(business.get被保険者番号１());
        item.setHihokenshaNo2(business.get被保険者番号２());
        item.setHihokenshaNo3(business.get被保険者番号３());
        item.setHihokenshaNo4(business.get被保険者番号４());
        item.setHihokenshaNo5(business.get被保険者番号５());
        item.setHihokenshaNo6(business.get被保険者番号６());
        item.setHihokenshaNo7(business.get被保険者番号７());
        item.setHihokenshaNo8(business.get被保険者番号８());
        item.setHihokenshaNo9(business.get被保険者番号９());
        item.setHihokenshaNo10(business.get被保険者番号１０());
        item.setTaishoshaNameKana(business.get対象者名カナ());
        item.setTaishoshaName(business.get対象者名());
        item.setBirthYMD(business.get誕生日());
        item.setSeibetsu(business.get性別());
        item.setTaishogoYubinNo(business.get郵便番号());
        item.setTaishogoJusho(business.get住所());
        item.setShisetsuName(business.get施設名称());
        item.setShisetsuTelNo(business.get施設電話番号());
        item.setShisetsuFaxNo(business.get施設FAX番号());
        item.setShisetsuYubinNo(business.get施設郵便番号());
        item.setShisetsuJusho(business.get施設住所());
        return item;
    }

    private ShisetsuHenkoTsuchishoItem dba100006_Item(TatokuKanrenChohyoHenkoTsuchishoBusiness business) {

        ShisetsuHenkoTsuchishoItem item = new ShisetsuHenkoTsuchishoItem();
        item.setHokenshaYubinNo(business.get保険者郵便番号());
        item.setBunshoNo(business.get文書番号());
        item.setHokenshaJusho(business.get保険者住所());
        item.setHakkoYMD(business.get発行年月日());
        item.setHokenshaName(business.get保険者名());
        item.setTantoBushoName(business.get担当部署名());
        item.setBarcode(business.getバーコード情報());
        item.setMidashi(business.get見出し());
        item.setHihokenshaNo1(business.get被保険者番号１());
        item.setHihokenshaNo2(business.get被保険者番号２());
        item.setHihokenshaNo3(business.get被保険者番号３());
        item.setHihokenshaNo4(business.get被保険者番号４());
        item.setHihokenshaNo5(business.get被保険者番号５());
        item.setHihokenshaNo6(business.get被保険者番号６());
        item.setHihokenshaNo7(business.get被保険者番号７());
        item.setHihokenshaNo8(business.get被保険者番号８());
        item.setHihokenshaNo9(business.get被保険者番号９());
        item.setHihokenshaNo10(business.get被保険者番号１０());
        item.setTaishoshaNameKana(business.get対象者名カナ());
        item.setTaishoshaName(business.get対象者名());
        item.setBirthYMD(business.get誕生日());
        item.setSeibetsu(business.get性別());
        item.setBirthYMD(business.get変更年月日());
        item.setHenkomaeShisetsuName(business.get変更前施設名称() == null ? RString.EMPTY : business.get変更前施設名称().value());
        item.setHenkomaeShisetsuTelNo(business.get変更前施設電話番号() == null ? RString.EMPTY : business.get変更前施設電話番号().value());
        item.setHenkomaeShisetsuFaxNo(business.get変更前施設FAX番号() == null ? RString.EMPTY : business.get変更前施設FAX番号().value());
        item.setHenkomaeShisetsuYubinNo(business.get変更前施設住所());
        item.setHenkomaeShisetsuJusho(business.get変更後施設名称() == null ? RString.EMPTY : business.get変更後施設名称().value());
        item.setHenkogoShisetsuName(business.get変更後施設名称() == null ? RString.EMPTY : business.get変更後施設名称().value());
        item.setHenkogoShisetsuTelNo(business.get変更後施設電話番号() == null ? RString.EMPTY : business.get変更後施設電話番号().value());
        item.setHenkogoShisetsuFaxNo(business.get変更後施設FAX番号() == null ? RString.EMPTY : business.get変更後施設FAX番号().value());
        item.setHenkogoShisetsuYubinNo(business.get変更後施設住所());
        item.setHenkogoShisetsuJusho(business.get変更後施設住所());
        return item;
    }

    private RString get文書番号取得(ReportId reportId) {

        return ReportUtil.get文書番号(SubGyomuCode.DBA介護資格, reportId, FlexibleDate.getNowDate());
    }

    private ShikakuKihonJohoHandler createHandler(ShikakuKihonJohoDiv div) {
        return new ShikakuKihonJohoHandler(div);
    }
}
