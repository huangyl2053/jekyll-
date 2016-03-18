/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE5410001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo.KojinShinchokuJokyohyoJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.kojinjokyoshokai.KojinJokyoShokaiParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5410001.DBE5410001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5410001.KojinJokyoShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5410001.KojinJokyoShokaiHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.kojinjokyoshokai.KojinJokyoShokaiFinder;
import jp.co.ndensan.reams.db.dbe.service.report.kojinshinchokujokyohyo.KojinShinchokuJokyohyoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.NinteiShinseiBusinessCollection;
import jp.co.ndensan.reams.db.dbz.business.core.servicetype.ninteishinsei.NinteiShinseiCodeModel;
import jp.co.ndensan.reams.db.dbz.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 要介護認定個人状況照会処理のクラスです。
 */
public class KojinJokyoShokai {

    private static final RString 照会モード = new RString("ShokaiMode");

    /**
     * 画面初期化処理です。
     *
     * @param div 要介護認定個人状況照会div
     * @return ResponseData<KojinJokyoShokaiDiv>
     */
    public ResponseData<KojinJokyoShokaiDiv> onLoad(KojinJokyoShokaiDiv div) {
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        KojinJokyoShokaiParameter parameter = KojinJokyoShokaiParameter.createSelectByKeyParam(申請書管理番号);
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
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        NinteiShinseiBusinessCollection collection = new NinteiShinseiBusinessCollection();
        collection.setHdnDatabaseSubGyomuCode(SubGyomuCode.DBE認定支援);
        collection.setShinseishoKanriNo(申請書管理番号);
        div.setNinteiShinseiBusinessCollection(DataPassingConverter.serialize(collection));
        return ResponseData.of(div).respond();
    }

    /**
     * 連絡事項ボタン処理です。
     *
     * @param div 要介護認定個人状況照会div
     * @return ResponseData<KojinJokyoShokaiDiv>
     */
    public ResponseData<KojinJokyoShokaiDiv> onClick_btnShichosonRenrakuJiko(KojinJokyoShokaiDiv div) {
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        NinteiShinseiCodeModel shinseiCodeModel = new NinteiShinseiCodeModel();
        shinseiCodeModel.set連絡事項(申請書管理番号.getColumnValue());
        shinseiCodeModel.set表示モード(照会モード);
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
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        div.setHdnShinseishoKanriNo(DataPassingConverter.serialize(申請書管理番号));
        return ResponseData.of(div).respond();
    }

    /**
     * 意見書依頼照会処理です。
     *
     * @param div 要介護認定個人状況照会div
     * @return ResponseData<KojinJokyoShokaiDiv>
     */
    public ResponseData<KojinJokyoShokaiDiv> onClick_btnShujiiIkenshoSakuseiIraiShokai(KojinJokyoShokaiDiv div) {
        ViewStateHolder.put(ViewStateKeys.被保険者番号, div.getCcdKaigoNinteiShikakuInfo().get被保険者番号());
        // TODO  内部QA：866 Redmine：#74276(画面遷移方式が知らない、現時点対応不可)
        return ResponseData.of(div).respond();
    }

    /**
     * 調査依頼照会処理です。
     *
     * @param div 要介護認定個人状況照会div
     * @return ResponseData<KojinJokyoShokaiDiv>
     */
    public ResponseData<KojinJokyoShokaiDiv> onClick_btnNinteiChosaIraiShokai(KojinJokyoShokaiDiv div) {
        ViewStateHolder.put(ViewStateKeys.被保険者番号, div.getCcdKaigoNinteiShikakuInfo().get被保険者番号());
        // TODO  内部QA：866 Redmine：#74276(画面遷移方式が知らない、現時点対応不可)
        return ResponseData.of(div).respond();
    }

    /**
     * 個人進捗状況表を発行する処理です。
     *
     * @param div 要介護認定個人状況照会div
     * @return ResponseData<KojinJokyoShokaiDiv>
     */
    public ResponseData<SourceDataCollection> onClick_btnprint(KojinJokyoShokaiDiv div) {
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        KojinJokyoShokaiParameter parameter = KojinJokyoShokaiParameter.createSelectByKeyParam(申請書管理番号);
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
        return ResponseData.of(div).forwardWithEventName(DBE5410001TransitionEventName.進捗状況照会に遷移する).respond();
    }

    private KojinJokyoShokaiHandler getHandler(KojinJokyoShokaiDiv div) {
        return new KojinJokyoShokaiHandler(div);
    }
}
