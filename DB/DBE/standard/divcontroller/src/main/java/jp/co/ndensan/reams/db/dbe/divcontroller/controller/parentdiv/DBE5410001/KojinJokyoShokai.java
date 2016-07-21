/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5410001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo.KojinShinchokuJokyohyoJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.kojinjokyoshokai.KojinJokyoShokaiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5410001.DBE5410001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5410001.KojinJokyoShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5410001.KojinJokyoShokaiHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.kojinjokyoshokai.KojinJokyoShokaiFinder;
import jp.co.ndensan.reams.db.dbe.service.report.kojinshinchokujokyohyo.KojinShinchokuJokyohyoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.NinteiShinseiBusinessCollection;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.RenrakusakiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.servicetype.ninteishinsei.NinteiShinseiCodeModel;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 要介護認定個人状況照会処理のクラスです。
 *
 * @reamsid_L DBE-0200-010 suguangjun
 */
public class KojinJokyoShokai {

    /**
     * 画面初期化処理です。
     *
     * @param div 要介護認定個人状況照会div
     * @return ResponseData<KojinJokyoShokaiDiv>
     */
    public ResponseData<KojinJokyoShokaiDiv> onLoad(KojinJokyoShokaiDiv div) {
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        KojinJokyoShokaiParameter parameter = KojinJokyoShokaiParameter.createSelectByKeyParam(new ShinseishoKanriNo(申請書管理番号));
        KojinJokyoShokaiFinder kojinJokyoShokaiFinder = KojinJokyoShokaiFinder.createInstance();
        List<jp.co.ndensan.reams.db.dbe.business.core.kojinjokyoshokai.KojinJokyoShokai> kojinJokyoShokaiList
                = kojinJokyoShokaiFinder.getKojinJokyoShokai(parameter).records();
        if (!kojinJokyoShokaiList.isEmpty()) {
            getHandler(div).setKojinJokyoShokai(kojinJokyoShokaiList, 申請書管理番号);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 連絡先ボタン処理です。
     *
     * @param div 要介護認定個人状況照会div
     * @return ResponseData<KojinJokyoShokaiDiv>
     */
    public ResponseData<KojinJokyoShokaiDiv> onClick_btnRenrakusaki(KojinJokyoShokaiDiv div) {
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        KojinJokyoShokaiParameter parameter = KojinJokyoShokaiParameter.createSelectByKeyParam(new ShinseishoKanriNo(申請書管理番号));
        KojinJokyoShokaiFinder kojinJokyoShokaiFinder = KojinJokyoShokaiFinder.createInstance();
        List<RenrakusakiJoho> rakusakiJohoList = kojinJokyoShokaiFinder.getRenrakusakiJoho(parameter).records();
        NinteiShinseiBusinessCollection data = new NinteiShinseiBusinessCollection();
        data.setDbdBusiness(rakusakiJohoList);
        div.setNinteiShinseiBusinessCollection(DataPassingConverter.serialize(data));
        div.setHdnRenrakusakiReadOnly(new RString("1"));
        return ResponseData.of(div).respond();
    }

    /**
     * 連絡事項ボタン処理です。
     *
     * @param div 要介護認定個人状況照会div
     * @return ResponseData<KojinJokyoShokaiDiv>
     */
    public ResponseData<KojinJokyoShokaiDiv> onClick_btnShichosonRenrakuJiko(KojinJokyoShokaiDiv div) {
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        KojinJokyoShokaiParameter parameter = KojinJokyoShokaiParameter.createSelectByKeyParam(new ShinseishoKanriNo(申請書管理番号));
        KojinJokyoShokaiFinder kojinJokyoShokaiFinder = KojinJokyoShokaiFinder.createInstance();
        List<jp.co.ndensan.reams.db.dbe.business.core.kojinjokyoshokai.KojinJokyoShokai> kojinJokyoShokaiList
                = kojinJokyoShokaiFinder.getKojinJokyoShokai(parameter).records();
        NinteiShinseiCodeModel shinseiCodeModel = new NinteiShinseiCodeModel();
        if (!kojinJokyoShokaiList.isEmpty()) {
            shinseiCodeModel.set連絡事項(kojinJokyoShokaiList.get(0).get市町村連絡事項());
        }
        shinseiCodeModel.set表示モード(NinteiShinseiCodeModel.HyojiMode.ShokaiMode);
        ViewStateHolder.put(ViewStateKeys.モード, shinseiCodeModel);
        return ResponseData.of(div).respond();
    }

    /**
     * 審査会情報ボタン処理です。
     *
     * @param div 要介護認定個人状況照会div
     * @return ResponseData<KojinJokyoShokaiDiv>
     */
    public ResponseData<KojinJokyoShokaiDiv> onClick_btnShinsakaiJoho(KojinJokyoShokaiDiv div) {
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        div.setHdnShinseishoKanriNo(申請書管理番号);
        return ResponseData.of(div).respond();
    }

    /**
     * 意見書依頼照会処理です。
     *
     * @param div 要介護認定個人状況照会div
     * @return ResponseData<KojinJokyoShokaiDiv>
     */
    public ResponseData<KojinJokyoShokaiDiv> onClick_btnShujiiIkenshoSakuseiIraiShokai(KojinJokyoShokaiDiv div) {
        div.setHihokenshano(div.getHihokenshano());
        return ResponseData.of(div).respond();
    }

    /**
     * 調査依頼照会処理です。
     *
     * @param div 要介護認定個人状況照会div
     * @return ResponseData<KojinJokyoShokaiDiv>
     */
    public ResponseData<KojinJokyoShokaiDiv> onClick_btnNinteiChosaIraiShokai(KojinJokyoShokaiDiv div) {
        ViewStateHolder.put(ViewStateKeys.被保険者番号, new HihokenshaNo(div.getHihokenshano()));
        return ResponseData.of(div).respond();
    }

    /**
     * 個人進捗状況表を発行する処理です。
     *
     * @param div 要介護認定個人状況照会div
     * @return ResponseData<KojinJokyoShokaiDiv>
     */
    public ResponseData<SourceDataCollection> onClick_btnprint(KojinJokyoShokaiDiv div) {
        RString 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, RString.class);
        KojinJokyoShokaiParameter parameter = KojinJokyoShokaiParameter.createSelectByKeyParam(new ShinseishoKanriNo(申請書管理番号));
        KojinJokyoShokaiFinder kojinJokyoShokaiFinder = KojinJokyoShokaiFinder.createInstance();
        List<jp.co.ndensan.reams.db.dbe.business.core.kojinjokyoshokai.KojinJokyoShokai> kojinJokyoShokaiList
                = kojinJokyoShokaiFinder.getKojinShinchokuJokyohyo(parameter).records();
        if (!kojinJokyoShokaiList.isEmpty()) {
            KojinShinchokuJokyohyoJoho jokyohyoEntity = getHandler(div).setKojinShinchokuJokyohyo(kojinJokyoShokaiList);
            return ResponseData.of(new KojinShinchokuJokyohyoPrintService().print(jokyohyoEntity)).respond();
        }
        throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
    }

    /**
     * 申請者一覧画面に遷移する。
     *
     * @param div KojinJokyoShokaiDiv
     * @return ResponseData<KojinJokyoShokaiDiv>
     */
    public ResponseData<KojinJokyoShokaiDiv> onClick_btnBackIryokikanToComplete(KojinJokyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBE5410001TransitionEventName.一覧に戻る).respond();
    }

    /**
     * 申請者検索画面に遷移する.
     *
     * @param div KojinJokyoShokaiDiv
     * @return ResponseData<KojinJokyoShokaiDiv>
     */
    public ResponseData<KojinJokyoShokaiDiv> onClick_btnBackIryokikanToComplet(KojinJokyoShokaiDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBE5410001TransitionEventName.検索に戻る).respond();
    }

    /**
     * 進捗状況照会に遷移する
     *
     * @param div KojinJokyoShokaiDiv
     * @return ResponseData<KojinJokyoShokaiDiv>
     */
    public ResponseData<KojinJokyoShokaiDiv> onClick_btnToShinchokuJyokyo(KojinJokyoShokaiDiv div) {
        ViewStateHolder.put(ViewStateKeys.保険者番号, div.getShoKisaiHokenshaNo());
        return ResponseData.of(div).forwardWithEventName(DBE5410001TransitionEventName.進捗状況照会に遷移する).respond();
    }

    private KojinJokyoShokaiHandler getHandler(KojinJokyoShokaiDiv div) {
        return new KojinJokyoShokaiHandler(div);
    }
}
