/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2410001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.kojinirainaiyoukoshin.KojinIraiNaiyouBusiness;
import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410001.DBE2410001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410001.DBE2410001TransitionEventName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410001.KojinIraiNaiyouKoshinDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2410001.KojinIraiNaiyouKoshinHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteiKanryoJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.kojinirainaiyoukoshin.KojinIraiNaiyouKoshinFinder;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.ikenshoprint.IkenshoPrintParameterModel;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.gamensenikbn.GamenSeniKbn;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 個人依頼内容更新(認定調査票・主治医意見書編集)のコントローラです。
 *
 * @reamsid_L DBE-1590-020 zhangzhiming
 */
public class KojinIraiNaiyouKoshin {

    /**
     * 画面初期化処理です。
     *
     * @param div KojinIraiNaiyouKoshinDiv
     * @return ResponseData<KojinIraiNaiyouKoshinDiv>
     */
    public ResponseData<KojinIraiNaiyouKoshinDiv> onLoad(KojinIraiNaiyouKoshinDiv div) {
        if (new RString(DbeErrorMessages.審査会割当済のため処理不可.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode()) && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            setDisabledControl_Error(div);
            return ResponseData.of(div).respond();
        }
        ShinseishoKanriNo 申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        KojinIraiNaiyouBusiness 今回調査情報 = KojinIraiNaiyouKoshinFinder.createInstance().getKonnkaiChousa(申請書管理番号);
        KojinIraiNaiyouBusiness 今回主治医情報 = KojinIraiNaiyouKoshinFinder.createInstance().getKonnkaiSyuji(申請書管理番号);
        KojinIraiNaiyouBusiness 前回調査情報 = KojinIraiNaiyouKoshinFinder.createInstance().getZennkaiChousa(申請書管理番号);
        KojinIraiNaiyouBusiness 前回主治医情報 = KojinIraiNaiyouKoshinFinder.createInstance().getZennkaiSyuji(申請書管理番号);
        getHandler(div).onLoad(申請書管理番号, 今回調査情報, 今回主治医情報, 前回調査情報, 前回主治医情報);
        ViewStateHolder.put(ViewStateKeys.申請書管理番号, 申請書管理番号);
        ShinsakaiWariateJohoManager shinsakaiWariateManager = InstanceProvider.create(ShinsakaiWariateJohoManager.class);
        boolean 審査会割当済 = shinsakaiWariateManager.get審査会割当データ(申請書管理番号);
        if (審査会割当済) {
            if (!ResponseHolder.isReRequest()) {
                ErrorMessage message = new ErrorMessage(DbeErrorMessages.審査会割当済のため処理不可.getMessage().getCode(),
                        DbeErrorMessages.審査会割当済のため処理不可.getMessage().evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        RString モード = ViewStateHolder.get(ViewStateKeys.モード, RString.class);
        if(モード != null && モード.equals(new RString("1件"))){
            return ResponseData.of(div).setState(DBE2410001StateName.初期表示_一件);
        }else{
            return ResponseData.of(div).respond();
        }
    }

    private KojinIraiNaiyouKoshinHandler getHandler(KojinIraiNaiyouKoshinDiv div) {
        return new KojinIraiNaiyouKoshinHandler(div);
    }

    /**
     * 戻るボタンを押下の場合、要介護認定申請検索へ遷移します。
     *
     * @param div KojinIraiNaiyouKoshinDiv
     * @return ResponseData<KojinIraiNaiyouKoshinDiv>
     */
    public ResponseData<KojinIraiNaiyouKoshinDiv> btn_Back(KojinIraiNaiyouKoshinDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBE2410001TransitionEventName.検索へ戻る).respond();
    }
    
     /**
     * btn_ReSearch処理。
     *
     * @param div KojinIraiNaiyouKoshinDiv
     * @return ResponseData<KojinIraiNaiyouKoshinDiv>
     */
    public ResponseData<KojinIraiNaiyouKoshinDiv> btn_ReSearch(KojinIraiNaiyouKoshinDiv div) {
        ViewStateHolder.put(ViewStateKeys.機能詳細画面から再検索, Boolean.TRUE);
        return ResponseData.of(div).respond();
    }
    
    /**
     * 調査の「依頼書等を印刷する」ボタン押下時
     * 
     * @param div KojinIraiNaiyouKoshinDiv
     * @return ResponseData<KojinIraiNaiyouKoshinDiv>
     */
    public ResponseData<KojinIraiNaiyouKoshinDiv> onBeforeOpen_btnChosaPrint(KojinIraiNaiyouKoshinDiv div) {
        List<ShinseishoKanriNo> 申請書管理番号リスト = new ArrayList<>();
        申請書管理番号リスト.add(ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class));
        IkenshoPrintParameterModel model = new IkenshoPrintParameterModel();
        model.set申請書管理番号リスト(申請書管理番号リスト);
        model.set市町村コード(ViewStateHolder.get(ViewStateKeys.市町村コード, LasdecCode.class));
        model.set遷移元画面区分(GamenSeniKbn.認定調査依頼);
        div.setHiddenIuputModel(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }
    
    /**
     * 意見書の「依頼書等を印刷する」ボタン押下時
     * 
     * @param div KojinIraiNaiyouKoshinDiv
     * @return ResponseData<KojinIraiNaiyouKoshinDiv>
     */
    public ResponseData<KojinIraiNaiyouKoshinDiv> onBeforeOpen_btnIkenshoPrint(KojinIraiNaiyouKoshinDiv div) {
        List<ShinseishoKanriNo> 申請書管理番号リスト = new ArrayList<>();
        申請書管理番号リスト.add(ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class));
        IkenshoPrintParameterModel model = new IkenshoPrintParameterModel();
        model.set申請書管理番号リスト(申請書管理番号リスト);
        model.set市町村コード(ViewStateHolder.get(ViewStateKeys.市町村コード, LasdecCode.class));
        model.set遷移元画面区分(GamenSeniKbn.主治医意見書依頼);
        div.setHiddenIuputModel(DataPassingConverter.serialize(model));
        return ResponseData.of(div).respond();
    }

    private void setDisabledControl_Error(KojinIraiNaiyouKoshinDiv div) {
        div.setDisabled(true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnIkenshoIraiNoToroku"), true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnChosaIraiNoToroku"), true);
    }
}
