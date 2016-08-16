/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC8120011;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.jikofutangakukeisanikkatsu.JikoFutangakuKeisanIkkatsuPanelBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8120011.JikoFutangakuKeisanIkkatsuPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8120011.JikoFutangakuKeisanIkkatsuPanelHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8120011.JikoFutangakuKeisanIkkatsuPanelValidationHandler;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder._ChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.PessimisticLockingException;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBCMNN1001_事業高額合算・事業分自己負担額計算（括）のクラスです。
 *
 * @reamsid_L DBC-4790-010 chenyadong
 */
public class JikoFutangakuKeisanIkkatsuPanel {

    private static final RString 出力対象_2 = new RString("2");
    private static final RString 出力対象_1 = new RString("1");

    /**
     * 画面初期化のメソッドます。
     *
     * @param div JikoFutangakuKeisanIkkatsuPanelDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuKeisanIkkatsuPanelDiv> onLoad(JikoFutangakuKeisanIkkatsuPanelDiv div) {

        RString メニューID = ResponseHolder.getMenuID();
        LockingKey 前排他キー = new LockingKey(メニューID);
        if (!RealInitialLocker.tryGetLock(前排他キー)) {
            throw new PessimisticLockingException();
        }
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * radSakuseiJokenのonChange事件です。
     *
     * @param div JikoFutangakuKeisanIkkatsuPanelDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuKeisanIkkatsuPanelDiv> onChange_radTaishoshaKeisan(JikoFutangakuKeisanIkkatsuPanelDiv div) {
        getHandler(div).onChangeRadSakuseiJoken();
        return ResponseData.of(div).respond();
    }

    /**
     * 被保険者番号のonBlur事件です。
     *
     * @param div JikoFutangakuKeisanIkkatsuPanelDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuKeisanIkkatsuPanelDiv> onBlur_txtHihokenshaNo(JikoFutangakuKeisanIkkatsuPanelDiv div) {
        getHandler(div).onBlur被保険者番号();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行ボタン押下した時の早期処理」ボタンのメソッドです。
     *
     * @param div ShinNendoKanriJohoSakuseiDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuKeisanIkkatsuPanelDiv> onBeforeOpenCheck(JikoFutangakuKeisanIkkatsuPanelDiv div) {
        if (div.getJikoFutangakuKeisanKekkaIchiranhyoPanelPublish().isIsPublish()) {
            ValidationMessageControlPairs validPairs = getValidationHandler(div).validateFor出力順未設定チェック();
            if (validPairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(validPairs).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行ボタン押下した時の処理」ボタンのメソッドです。
     *
     * @param div ShinNendoKanriJohoSakuseiDiv
     * @return ResponseData
     */
    public ResponseData<JikoFutangakuKeisanIkkatsuPanelBatchParameter> onClick_JikoFutangakuKeisanIkkatsuPanel(JikoFutangakuKeisanIkkatsuPanelDiv div) {
        LockingKey 排他キー = new LockingKey(ResponseHolder.getMenuID());
        RealInitialLocker.release(排他キー);
        JikoFutangakuKeisanIkkatsuPanelBatchParameter param = setBatchParameter(div);
        return ResponseData.of(param).respond();
    }

    private JikoFutangakuKeisanIkkatsuPanelBatchParameter setBatchParameter(JikoFutangakuKeisanIkkatsuPanelDiv div) {
        RString 被保険者番号指定RAD = new RString("hihokenshaNo");
        JikoFutangakuKeisanIkkatsuPanelBatchParameter parameter = new JikoFutangakuKeisanIkkatsuPanelBatchParameter();
        RString 出力対象区分;
        if (被保険者番号指定RAD.equals(div.getRadHihokenshaNo().getSelectedKey())) {
            出力対象区分 = 出力対象_2;
            parameter.setHihokenshano(div.getTxtHihokenshaNo().getValue());
            parameter.setNendo(div.getDdlNendo().getSelectedKey());
            parameter.setUketoriym(null);
        } else {
            出力対象区分 = 出力対象_1;
            parameter.setUketoriym(new FlexibleYearMonth(div.getTxtUketoriYM().getValue().toDateString()));
            parameter.setHihokenshano(null);
            parameter.setNendo(null);
        }
        boolean 出力フラグ;
        if (div.getJikoFutangakuKeisanKekkaIchiranhyoPanelPublish().isIsPublish()) {
            long 出力順ID = div.getCcdChohyoShutsuryokujun().get出力順ID();
            parameter.setShutsuryokujunId(出力順ID);
            出力フラグ = true;
        } else {
            出力フラグ = false;
            parameter.setShutsuryokujunId(null);
        }
        parameter.setShoriTime(RDate.getNowDate().toDateString());
        parameter.setRadSakuseiJoken(出力対象区分);
        parameter.setShuturyokuFlg(出力フラグ);
        Association 市町村コード_Temp = AssociationFinderFactory.createInstance().getAssociation();
        parameter.setDantaiCd(市町村コード_Temp.get地方公共団体コード());
        return parameter;
    }
    //TODO QA1080 
    /**
     * 出力CHKのonChange事件です。
     *
     * @param div JikoFutangakuKeisanIkkatsuPanelDiv
     * @return ResponseData
     */
    /*  public ResponseData<JikoFutangakuKeisanIkkatsuPanelDiv> onChange_ccdChohyoShutsuryokujun(JikoFutangakuKeisanIkkatsuPanelDiv div) {
     getHandler(div).onChange出力CHK();
     return ResponseData.of(div).respond();
     }
     */
    private JikoFutangakuKeisanIkkatsuPanelHandler getHandler(JikoFutangakuKeisanIkkatsuPanelDiv div) {
        return new JikoFutangakuKeisanIkkatsuPanelHandler(div);
    }

    private JikoFutangakuKeisanIkkatsuPanelValidationHandler getValidationHandler(JikoFutangakuKeisanIkkatsuPanelDiv div) {
        return new JikoFutangakuKeisanIkkatsuPanelValidationHandler(div);
    }
}
