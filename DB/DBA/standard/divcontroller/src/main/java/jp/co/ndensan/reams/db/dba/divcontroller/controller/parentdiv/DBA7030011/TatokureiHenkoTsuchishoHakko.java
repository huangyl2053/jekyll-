package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA7030011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tajushochitokureisyakanri.TaJushochiTokureisyaKanriMaster;
import jp.co.ndensan.reams.db.dba.business.core.tajushochitokureisyakanri.TashichosonBusiness;
import jp.co.ndensan.reams.db.dba.business.core.tashichosonjushochitokureishisetsuhenkotsuchisho.TatokuKanrenChohyoHenkoTsuchishoBusiness;
import jp.co.ndensan.reams.db.dba.business.core.tatokukanrenchohyoshiji.TatokuKanrenChohyoShijiData;
import jp.co.ndensan.reams.db.dba.business.report.shisetsuhenkotsuchisho.ShisetsuHenkoTsuchishoItem;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tatokukanrenchohyoshijidata.TatokuKanrenParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7030011.TatokureiHenkoTsuchishoHakkoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA7030011.TatokureiHenkoTsuchishoHakkoHandler;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA7030011.TatokureiHenkoTsuchishoHakkoValidationHandler;
import jp.co.ndensan.reams.db.dba.service.core.tajushochito.TaJushochiTokureisyaKanriManager;
import jp.co.ndensan.reams.db.dba.service.core.tashichosonjushochitokureisharenrakuhyo.TashichosonJushochitokureishaRenrakuhyoFinder;
import jp.co.ndensan.reams.db.dba.service.core.tashichosonjushochitokureishisetsuhenkotsuchisho.TaShichosonJushochiTokureiShisetsuHenkoTsuchishoFinder;
import jp.co.ndensan.reams.db.dba.service.report.shisetsuhenkotsuchisho.ShisetsuHenkoTsuchishoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokurei;
import jp.co.ndensan.reams.db.dbz.business.core.TashichosonJushochiTokureiIdentifier;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStateKey;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.BunshoNoFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.IBunshoNoFinder;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * 他特例施設変更通知書発行のクラスです。
 *
 * @reamsid_L DBA-0380-020 houtianpeng
 */
public class TatokureiHenkoTsuchishoHakko {

    private static final RString 発行ボタン = new RString("btnReportPublish");
    private static final RString 発行チェックボタン = new RString("btnCheck");
    private static final RString 汎用キー_文書番号 = new RString("文書番号");

    /**
     * 他特例施設変更通知書発行を初期化します。
     *
     * @param div TatokureiHenkoTsuchishoHakkoDiv
     * @return ResponseData<TatokureiHenkoTsuchishoHakkoDiv>
     */
    public ResponseData<TatokureiHenkoTsuchishoHakkoDiv> onLoad(TatokureiHenkoTsuchishoHakkoDiv div) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class).get識別コード();
        div.getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getCcdKaigoShikakuJoho().initialize(ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class).get被保険者番号());
        List<TaJushochiTokureisyaKanriMaster> tekiyoJohoList = get適用情報(ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class).get識別コード());
        if (tekiyoJohoList != null && !tekiyoJohoList.isEmpty()) {
            TashichosonBusiness 住所地特例Model = TaJushochiTokureisyaKanriManager.createInstance().get他市町村住所地特例(識別コード);
            ViewStateHolder.put(ViewStateKeys.他住所地特例, Models.create(住所地特例Model.get住所地特例List()));
        } else {
            ViewStateHolder.put(ViewStateKeys.他住所地特例, Models.create(new ArrayList()));
        }
        createHandler(div).適用情報Gridの設定(tekiyoJohoList == null ? new ArrayList() : tekiyoJohoList);
        createHandler(div).適用情報の名称編集(ReportIdDBA.DBA100006.getReportId());
        createHandler(div).get初期文書番号取得(ReportIdDBA.DBA100006.getReportId());
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(発行ボタン, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(発行チェックボタン, true);
        return ResponseData.of(div).respond();
    }

    /**
     * 適用情報Grid。
     *
     * @param div TatokureiHenkoTsuchishoHakkoDiv
     * @return ResponseData<TatokureiHenkoTsuchishoHakkoDiv>
     */
    public ResponseData<TatokureiHenkoTsuchishoHakkoDiv> onClick_dgJushochiTokureiRireki(TatokureiHenkoTsuchishoHakkoDiv div) {

        CommonButtonHolder.setDisabledByCommonButtonFieldName(発行チェックボタン, false);
        createHandler(div).適用情報の編集();
        return ResponseData.of(div).respond();
    }

    /**
     * 自動付番ボタン。
     *
     * @param div TatokureiHenkoTsuchishoHakkoDiv
     * @return ResponseData<TatokureiHenkoTsuchishoHakkoDiv>
     */
    public ResponseData<TatokureiHenkoTsuchishoHakkoDiv> onClick_btnJidoFuban(TatokureiHenkoTsuchishoHakkoDiv div) {
        CountedItem countedItem = Saiban.get(SubGyomuCode.DBZ介護共通, 汎用キー_文書番号);
        IBunshoNoFinder bushoFineder = BunshoNoFinderFactory.createInstance();
        BunshoNo bushoNo = bushoFineder.get文書番号管理(ReportIdDBA.DBA100006.getReportId(), FlexibleDate.getNowDate());
        if (bushoNo != null) {
            div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().
                    getCcdBunshoBangoInput().setDecorationClass(bushoNo.edit文書番号(countedItem.nextString()));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行する」ボタン押下の場合、帳票を印刷します。
     *
     * @param div TatokureiHenkoTsuchishoHakkoDiv
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<SourceDataCollection> btnPrint(TatokureiHenkoTsuchishoHakkoDiv div) {

        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class).get識別コード();
        Models<TashichosonJushochiTokureiIdentifier, TashichosonJushochiTokurei> 他市町村住所地特例
                = ViewStateHolder.get(ViewStateKeys.他住所地特例, Models.class);
        TatokuKanrenChohyoShijiData business = 帳票発行指示データ作成(div, false);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(発行チェックボタン, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(発行ボタン, true);
        TatokuKanrenChohyoHenkoTsuchishoBusiness tsuchishoBusiness = TaShichosonJushochiTokureiShisetsuHenkoTsuchishoFinder
                .createInstance().setTatokuKanrenChohyoTaishoTsuchisho(business);
        他市町村住所地特例の更新(createHandler(div).他特例施設変更通知書の編集(他市町村住所地特例, 識別コード));

        ResponseData<SourceDataCollection> response = new ResponseData<>();
        try (ReportManager reportManager = new ReportManager()) {
            response.data = new ShisetsuHenkoTsuchishoPrintService(reportManager).print(dba100006_Item(tsuchishoBusiness));
        }
        return response;
    }

    /**
     * 「発行する」ボタン押下の場合、帳票を印刷します。
     *
     * @param div TatokureiHenkoTsuchishoHakkoDiv
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<TatokureiHenkoTsuchishoHakkoDiv> onClick_btnCheck(TatokureiHenkoTsuchishoHakkoDiv div) {

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            ValidationMessageControlPairs reportPublish = createValidationHandler(div).validateForReportPublish();
            if (reportPublish.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(reportPublish).respond();
            }
            return ResponseData.of(div).addMessage(message).respond();
        }
        return ResponseData.of(div).respond();
    }

    private List<TaJushochiTokureisyaKanriMaster> get適用情報(ShikibetsuCode 識別コード) {

        return TaJushochiTokureisyaKanriManager.createInstance().getTaJushochiTokureiTekiyoJyoho(識別コード).records();
    }

    private void 他市町村住所地特例の更新(TashichosonJushochiTokurei 他市町村住所地特例) {

        TaJushochiTokureisyaKanriManager.createInstance().regTaJushochiTokurei(他市町村住所地特例.toEntity());
    }

    private TatokuKanrenChohyoShijiData 帳票発行指示データ作成(TatokureiHenkoTsuchishoHakkoDiv div, boolean 住所出力不要フラグ) {

        return TashichosonJushochitokureishaRenrakuhyoFinder.createInstance().
                setChohyoData(TatokuKanrenParameter.
                        createParam_TatokuKanren(div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtYubinNo().getValue(),
                                div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getCcdBunshoBangoInput().get文書番号(),
                                div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtJusho().getValue(),
                                div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getCcdPrintContentsSetting().getIssueDate() == null
                                ? FlexibleDate.EMPTY : new FlexibleDate(div.getTajutokuTekiyoJohoIchiran().getReportPublish().
                                        getHenshuNaiyo().getCcdPrintContentsSetting().getIssueDate().toDateString()),
                                div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtYakushoMei() == null ? RString.EMPTY
                                : div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtYakushoMei().getValue(),
                                div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtOnchu() == null ? RString.EMPTY
                                : div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtOnchu().getValue(),
                                div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtTantokamei() == null ? RString.EMPTY
                                : div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtTantokamei().getValue(),
                                div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtSam() == null ? RString.EMPTY
                                : div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().getTxtSam().getValue(),
                                ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class).get識別コード() == null
                                ? ShikibetsuCode.EMPTY : ViewStateHolder.get(ViewStateKey.資格対象者, TaishoshaKey.class).get識別コード(),
                                div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().get措置保険者番号(),
                                div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo() == null ? FlexibleDate.EMPTY
                                : new FlexibleDate(div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().get異動日()),
                                div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().get枝番(),
                                div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().get入所日() == null ? FlexibleDate.EMPTY
                                : new FlexibleDate(div.getTajutokuTekiyoJohoIchiran().getReportPublish().getHenshuNaiyo().get入所日()), 住所出力不要フラグ));
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
        item.setMidashi1(business.get見出し());
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
        item.setHenkomaeShisetsuName(business.get変更前施設名称());
        item.setHenkomaeShisetsuTelNo(business.get変更前施設電話番号());
        item.setHenkomaeShisetsuFaxNo(business.get変更前施設FAX番号());
        item.setHenkomaeShisetsuYubinNo(business.get変更前施設郵便番号());
        item.setHenkomaeShisetsuJusho(business.get変更前施設住所());
        item.setHenkogoShisetsuName(business.get変更後施設名称());
        item.setHenkogoShisetsuTelNo(business.get変更後施設電話番号());
        item.setHenkogoShisetsuFaxNo(business.get変更後施設FAX番号());
        item.setHenkogoShisetsuYubinNo(business.get変更後施設郵便番号());
        item.setHenkogoShisetsuJusho(business.get変更後施設住所());
        return item;
    }

    private TatokureiHenkoTsuchishoHakkoHandler createHandler(TatokureiHenkoTsuchishoHakkoDiv div) {
        return new TatokureiHenkoTsuchishoHakkoHandler(div);
    }

    private TatokureiHenkoTsuchishoHakkoValidationHandler createValidationHandler(TatokureiHenkoTsuchishoHakkoDiv div) {
        return new TatokureiHenkoTsuchishoHakkoValidationHandler(div);
    }
}
