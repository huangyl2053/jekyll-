/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC0430011;

import jp.co.ndensan.reams.db.dbc.business.core.KogakuKaigoServicehiOshiraseHakko.KogakuKaigoServicehiOshiraseHakkoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0430011.DBC0430011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0430011.KogakuShikyuShinseishoIkkatsuHakkoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0430011.KogakuShikyuShinseishoIkkatsuHakkoHandler;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 高額サービス費給付お知らせ通知書作成です。
 *
 * @reamsid_L DBC-0430-011 zhengshenlei
 */
public class KogakuShikyuShinseishoIkkatsuHakko {

    private static final RString メニューID_DBCMN43001 = new RString("DBCMN43001");
    private static final RString メニューID_DBCMNL3001 = new RString("DBCMNL3001");
    private static final RString 高額サービス費給付お知らせ通知書作成 = new RString("高額サービス費給付お知らせ通知書作成");
    private static final RString 事業高額サービス費給付お知らせ通知書作成 = new RString("事業高額サービス費給付お知らせ通知書作成");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div KogakuShikyuShinseishoIkkatsuHakkoDivselectControlID
     * @return ResponseData
     */
    public ResponseData<KogakuShikyuShinseishoIkkatsuHakkoDiv> onLoad(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        RString menuID = ResponseHolder.getMenuID();
        getHandler(div).initialize(menuID);
        if (メニューID_DBCMN43001.equals(menuID)) {
            return ResponseData.of(ResponseData.of(div).setState(DBC0430011StateName.NoChange).data)
                    .rootTitle(高額サービス費給付お知らせ通知書作成).respond();
        } else if (メニューID_DBCMNL3001.equals(menuID)) {
            return ResponseData.of(ResponseData.of(div).setState(DBC0430011StateName.NoChange).data)
                    .rootTitle(事業高額サービス費給付お知らせ通知書作成).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 2.　ラジオボタン「radChushutsuJoken（審査年月RAD、被保険者番号RAD、白紙印刷RAD）」の切り替えによる、コントロールの操作
     *
     * @param div KogakuShikyuShinseishoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<KogakuShikyuShinseishoIkkatsuHakkoDiv> btnOnClick_shinsaYM(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        div.getShinseishoHakkoParameters().getTxtShinsaYM().setReadOnly(false);
        div.getShinseishoHakkoParameters().getTxtHihokenshaNo().setReadOnly(true);
        div.getShinseishoHakkoParameters().getDdlServiceYM().setReadOnly(true);
        div.getShinseishoHakkoParameters().getRadHihokenshaNo().clearSelectedItem();
        div.getShinseishoHakkoParameters().getRadHakushiInsatsu().clearSelectedItem();

        return ResponseData.of(div).respond();
    }

    /**
     * ラジオボタンのメソッドます 被保険者番号RAD
     *
     * @param div KogakuShikyuShinseishoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<KogakuShikyuShinseishoIkkatsuHakkoDiv> btnOnClick_radHihokenshaNo(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        RString menuID = ResponseHolder.getMenuID();
        div.getShinseishoHakkoParameters().getTxtShinsaYM().setReadOnly(true);
        div.getShinseishoHakkoParameters().getTxtHihokenshaNo().setReadOnly(false);
        div.getShinseishoHakkoParameters().getDdlServiceYM().setReadOnly(false);
        div.getShinseishoHakkoParameters().getRadShinsaYM().clearSelectedItem();
        div.getShinseishoHakkoParameters().getRadHakushiInsatsu().clearSelectedItem();
        getHandler(div).setサービス年月DDL(menuID);
        return ResponseData.of(div).respond();
    }

    /**
     * ラジオボタンのメソッドです。
     *
     * @param div KogakuShikyuShinseishoIkkatsuHakkoDiv
     * @return ResponseData
     */
    public ResponseData<KogakuShikyuShinseishoIkkatsuHakkoDiv> btnOnClick_radHakushiInsatsu(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        div.getShinseishoHakkoParameters().getTxtShinsaYM().setReadOnly(true);
        div.getShinseishoHakkoParameters().getTxtHihokenshaNo().setReadOnly(true);
        div.getShinseishoHakkoParameters().getDdlServiceYM().setReadOnly(true);
        div.getShinseishoHakkoParameters().getRadShinsaYM().clearSelectedItem();
        div.getShinseishoHakkoParameters().getRadHihokenshaNo().clearSelectedItem();
        return ResponseData.of(div).respond();
    }

    /**
     * 「確定処理を実行する（バッチ用）」ボタンのメソッドます。
     *
     * @param div HeijunkaKakuteiDiv
     * @return ResponseData
     */
    public ResponseData<KogakuKaigoServicehiOshiraseHakkoParameter> onclick_btBatch(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        boolean gotLock = getHandler(div).前排他キーのセット();
        if (!gotLock) {
            throw new PessimisticLockingException();
        }
        KogakuKaigoServicehiOshiraseHakkoParameter parameter = getHandler(div).createBatchParameter(menuID);
        getHandler(div).前排他を解除する();
        return ResponseData.of(parameter).respond();
    }

    private KogakuShikyuShinseishoIkkatsuHakkoHandler getHandler(KogakuShikyuShinseishoIkkatsuHakkoDiv div) {
        return new KogakuShikyuShinseishoIkkatsuHakkoHandler(div);
    }

}
