/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD4040011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.dbt4030011.NinteishoJohoBusiness;
import static jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4040011.DBD4040011TransitionEventName.検索に戻る;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4040011.ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4040011.ShogaishaKojoTaishoshaNinteishoHakkoHandler;
import jp.co.ndensan.reams.db.dbd.service.report.dbd100025.ShogaishaKojoNinteishoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.report.hakkorireki.GyomuKoyuJoho;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.core.reportprinthistory.ChohyoHakkoRirekiJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.reportprinthistory.HakkoRirekiManagerFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportprinthistory.IHakkoRirekiManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceData;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 障がい者控除対象者認定画面のDivControllerです
 *
 * @reamsid_L DBD-3870-010 jinge
 */
public class ShogaishaKojoTaishoshaNinteishoHakkoPanel {

    /**
     * 画面初期化
     *
     * @param div ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv
     * @return ResponseData<ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv>
     */
    public ResponseData<ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv> onLoad(ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv div) {
        getHandler(div).initialize(get識別コードFromViewState(), get被保険者番号FromViewState());
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行する」ボタンを押した後のバリデーションする。
     *
     * @param div ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv
     * @return ResponseData
     */
    public ResponseData<SourceDataCollection> onClick_btnHakko(ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv div) {
        ResponseData<SourceDataCollection> response = new ResponseData<>();
        HashMap<Code, RString> hashMap = new HashMap();
        hashMap.put(new Code(GyomuKoyuJoho.被保番号.getコード()), get被保険者番号FromViewState().getColumnValue());
        RDate 発行日 = div.getShogaishaKojoNinteishoHakko().getShogaishaKojoNinteisho().getNinteishoPrintSetting().getIssueDate();
        NinteishoJohoBusiness business = new NinteishoJohoBusiness();
        business.set発行日(発行日);
        business.set被保険者番号(get被保険者番号FromViewState());
        business.set対象者氏名(div.getTaishoshaAtena().get氏名漢字());
        business.set対象者住所(div.getTaishoshaAtena().get住所().getColumnValue());

        FlexibleDate 対象者生年月日 = div.getTaishoshaAtena().getShokaiData().getTxtSeinengappiYMD().getValue();
        if (JuminShubetsu.外国人.getCode().equals(div.getTaishoshaAtena().getAtenaInfoDiv().getHdnTxtJuminShubetsu())
                || JuminShubetsu.住登外個人_外国人.getCode().equals(div.getTaishoshaAtena().getAtenaInfoDiv().getHdnTxtJuminShubetsu())) {
            business.set対象者生年月日(対象者生年月日.seireki()
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        } else {
            business.set対象者生年月日(対象者生年月日.wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }
        business.set対象者性別(div.getTaishoshaAtena().getShokaiData().getTxtSeibetsu().getValue());
        business.set申請者氏名(div.getShogaishaKojoNinteishoHakko().getShogaishaKojoNinteisho().getShogaishaKojoShinseisha().getTxtShinseishaName().getValue());
        business.set申請者住所(div.getShogaishaKojoNinteishoHakko().getShogaishaKojoNinteisho().getShogaishaKojoShinseisha().getTxtShinseishaJusho().getValue());
        business.set障害理由区分(div.getShogaishaKojoNinteishoHakko().getShogaishaKojoTaishoshaDetail().getTxtNinteiKubun().getValue());
        business.set障害理由内容(div.getShogaishaKojoNinteishoHakko().getShogaishaKojoTaishoshaDetail().getTxtNinteiNaiyo().getValue());
        ShogaishaKojoNinteishoPrintService service = new ShogaishaKojoNinteishoPrintService();
        try (ReportManager reportManager = new ReportManager()) {
            service.print(business, reportManager);

            SourceDataCollection collection = reportManager.publish();
            for (SourceData data : collection) {
                insert発行履歴(data, 発行日, get識別コードFromViewState(), hashMap);
            }
            response.data = collection;
        }
        return response;
    }

    /**
     * 「連絡先」発行するボタンボタンを押した後のバリデーションする。
     *
     * @param div ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv
     * @return ResponseData
     */
    public ResponseData<ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv> onClick_btnReturnToSearch(ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv div) {
        return ResponseData.of(div).forwardWithEventName(検索に戻る).respond();
    }

    private HihokenshaNo get被保険者番号FromViewState() {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        if (null == 被保険者番号) {
            被保険者番号 = HihokenshaNo.EMPTY;
        }
        return 被保険者番号;
    }

    private ShikibetsuCode get識別コードFromViewState() {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode 識別コード = taishoshaKey.get識別コード();
        if (null == 識別コード) {
            識別コード = ShikibetsuCode.EMPTY;
        }
        return 識別コード;
    }

    /**
     * 発行履歴の登録
     *
     * @param sourceData SourceDataCollectionのSourceData
     * @param 発行日 発行日
     * @param 識別コード 識別コード
     * @param hashMap 業務固有情報hashmap
     */
    public void insert発行履歴(SourceData sourceData, RDate 発行日, ShikibetsuCode 識別コード, HashMap<Code, RString> hashMap) {
        IHakkoRirekiManager manager = HakkoRirekiManagerFactory.createInstance();
        List<ShikibetsuCode> shikibetsuCodeList = new ArrayList<>();
        shikibetsuCodeList.add(識別コード);
        manager.insert帳票発行履歴(
                sourceData,
                new FlexibleDate(発行日.toDateString()),
                ChohyoHakkoRirekiJotai.新規作成,
                hashMap, shikibetsuCodeList
        );
    }

    private ShogaishaKojoTaishoshaNinteishoHakkoHandler getHandler(ShogaishaKojoTaishoshaNinteishoHakkoPanelDiv div) {
        return new ShogaishaKojoTaishoshaNinteishoHakkoHandler(div);
    }
}
