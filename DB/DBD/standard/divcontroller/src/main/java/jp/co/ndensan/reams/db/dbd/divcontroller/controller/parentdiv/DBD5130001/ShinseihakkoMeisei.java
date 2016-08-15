/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5130001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd501002.ShinseiShoEntity;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5130001.ShinseihakkoMeiseiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5130001.ShinseihakkoMeiseiHandler;
import jp.co.ndensan.reams.db.dbd.service.report.dbd501001.YokaigoNinteiShinseishoPrintService;
import jp.co.ndensan.reams.db.dbd.service.report.dbd501002.YokaigoNinteikbnHenkoShinseishoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.report.hakkorireki.GyomuKoyuJoho;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.core.reportprinthistory.ChohyoHakkoRirekiJotai;
import jp.co.ndensan.reams.ur.urz.service.core.reportprinthistory.HakkoRirekiManagerFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportprinthistory.IHakkoRirekiManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceData;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 要介護認定申請書発行画面のDivControllerです。
 *
 * @reamsid_L DBD-1400-010 tianyh
 */
public class ShinseihakkoMeisei {

    /**
     * 画面初期化
     *
     * @param shinseihakkoMeiseiDiv ShinseihakkoMeiseiDiv
     * @return ResponseData<ShinseihakkoMeiseiDiv>
     */
    public ResponseData<ShinseihakkoMeiseiDiv> onLoad(ShinseihakkoMeiseiDiv shinseihakkoMeiseiDiv) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        ShikibetsuCode 識別コード = taishoshaKey.get識別コード();
        getHandler(shinseihakkoMeiseiDiv).initialize(識別コード, 被保険者番号);
        return ResponseData.of(shinseihakkoMeiseiDiv).respond();
    }

    /**
     * 「連絡先」申請書を発行するボタンを押した後のバリデーションする。
     *
     * @param div ShinseihakkoMeiseiDiv
     * @return ResponseData
     */
    public ResponseData<ShinseihakkoMeiseiDiv> check_RadShinseiKubun(ShinseihakkoMeiseiDiv div) {
        int selectIndex = div.getShinseihakkoMeisei2().getPrintSelect().getRadShinseiKubun().getSelectedIndex();
        RString yokaigodo = div.getShinseihakkoMeisei2().getCcdZenkaiNinteiKekkaJoho().getTxtYokaigodo().getValue();
        if (selectIndex != 0 && (yokaigodo == null || yokaigodo.isEmpty())) {
            throw new ApplicationException(DbzErrorMessages.実行不可.getMessage().replace("要介護度が空白のため", "更新申請の選択ができません"));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 帳票を出力する
     *
     * @param shinseihakkoMeiseiDiv ShinseihakkoMeiseiDiv
     * @return ResponseData
     */
    public ResponseData<ShinseihakkoMeiseiDiv> onClick_btnPublish(ShinseihakkoMeiseiDiv shinseihakkoMeiseiDiv) {
        ShinseiShoEntity shinseiShoEntity = getHandler(shinseihakkoMeiseiDiv).getShinseiShoEntity();
        ResponseData<SourceDataCollection> response = new ResponseData<>();
        int radShinseiKubunSelectIndex = shinseihakkoMeiseiDiv.getShinseihakkoMeisei2().getPrintSelect().getRadShinseiKubun().getSelectedIndex();
        try (ReportManager reportManager = new ReportManager()) {
            if (radShinseiKubunSelectIndex == 2) {
                YokaigoNinteiShinseishoPrintService shinseishoPrintService = new YokaigoNinteiShinseishoPrintService();
                shinseishoPrintService.print(shinseiShoEntity, reportManager);
            } else {
                YokaigoNinteikbnHenkoShinseishoPrintService teiShinseishoPrintService = new YokaigoNinteikbnHenkoShinseishoPrintService();
                teiShinseishoPrintService.print(shinseiShoEntity, reportManager);
            }
            HashMap<Code, RString> hashMap = new HashMap();
            hashMap.put(new Code(GyomuKoyuJoho.被保番号.getコード()), shinseiShoEntity.get被保険者番号());
            SourceDataCollection collection = reportManager.publish();
            response.data = collection;
        }
        return ResponseData.of(shinseihakkoMeiseiDiv).respond();
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

    private ShinseihakkoMeiseiHandler getHandler(ShinseihakkoMeiseiDiv div) {
        return new ShinseihakkoMeiseiHandler(div);
    }

}
