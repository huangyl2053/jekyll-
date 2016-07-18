/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE6030001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.chosahyojissekiichiran.ChosahyoJissekiIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosahyojissekiichiran.ChosahyoJissekiIchiranMybitisParamter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6030001.NinteiChosaJissekiShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6030001.NinteiChosaJissekiShokaiHandler;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosajissekishokai.NinteiChosaJissekiShokaiFindler;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 認定調査実績照会の画面処理クラスです。
 *
 * @reamsid_L DBE-1691-010 dangjingjing
 */
public class NinteiChosaJissekiShokai {

    private static final RString CSVを出力する = new RString("1");
    private static final RString 集計表を発行する = new RString("2");

    /**
     * 画面の初期化です。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiChosaJissekiShokaiDiv>
     */
    public ResponseData<NinteiChosaJissekiShokaiDiv> onLoad(NinteiChosaJissekiShokaiDiv div) {
        div.getChosaJisshibi().getCcdHokensya().loadHokenshaList(GyomuBunrui.介護認定);
        div.getChosaJisshibi().getTxtMaxKensu().setValue(new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getChosaJisshibi().getTxtMaxKensu().setMaxValue(new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        getHandler(div).set初期状態();
        return ResponseData.of(div).respond();
    }

    /**
     * 「条件をクリアする」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiChosaJissekiShokaiDiv>
     */
    public ResponseData<NinteiChosaJissekiShokaiDiv> onClick_btnKensakuClear(NinteiChosaJissekiShokaiDiv div) {
        getHandler(div).set初期状態();
        getHandler(div).onClick_BtnKensakuClear();
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiChosaJissekiShokaiDiv>
     */
    public ResponseData<NinteiChosaJissekiShokaiDiv> onClick_btnkensaku(NinteiChosaJissekiShokaiDiv div) {
        RString 意見書記入日FROM = RString.EMPTY;
        RString 意見書記入日TO = RString.EMPTY;
        if (div.getChosaJisshibi().getTxtChosaJisshibi().getFromValue() != null) {
            意見書記入日FROM = div.getChosaJisshibi().getTxtChosaJisshibi().getFromValue().toDateString();
        }
        if (div.getChosaJisshibi().getTxtChosaJisshibi().getToValue() != null) {
            意見書記入日TO = div.getChosaJisshibi().getTxtChosaJisshibi().getToValue().toDateString();
        }
        ChosahyoJissekiIchiranMybitisParamter paramter = ChosahyoJissekiIchiranMybitisParamter.createGamenParamter(false,
                意見書記入日FROM,
                意見書記入日TO,
                div.getChosaJisshibi().getCcdHokensya().getSelectedItem().get市町村コード().value(),
                new RString(div.getChosaJisshibi().getTxtMaxKensu().getValue().toString()));
        getHandler(div).set一覧状態();
        getHandler(div).onClick_btnKensuku(NinteiChosaJissekiShokaiFindler.creatInstance().get帳票出力用認定調査実績集計表(paramter).records());
        if (div.getDgNinteiChosaJisseki().getDataSource().isEmpty()) {
            CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnPulish"), false);
            CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnShutsutyoku"), false);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「条件に戻る」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiChosaJissekiShokaiDiv>
     */
    public ResponseData<NinteiChosaJissekiShokaiDiv> onClick_btnBackToKensaku(NinteiChosaJissekiShokaiDiv div) {
        getHandler(div).set初期状態();
        return ResponseData.of(div).respond();
    }

    /**
     * 「CSVを出力する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiChosaJissekiShokaiBatchParameter>
     */
    public ResponseData<ChosahyoJissekiIchiranBatchParameter> onClick_BtnShutsutyoku(NinteiChosaJissekiShokaiDiv div) {
        ChosahyoJissekiIchiranBatchParameter param = getHandler(div).createBatchParam(CSVを出力する);
        return ResponseData.of(param).respond();
    }

    /**
     * 「集計表を発行する」ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<NinteiChosaJissekiShokaiBatchParameter>
     */
    public ResponseData<ChosahyoJissekiIchiranBatchParameter> onClick_BtnPulish(NinteiChosaJissekiShokaiDiv div) {
        ChosahyoJissekiIchiranBatchParameter param = getHandler(div).createBatchParam(集計表を発行する);
        return ResponseData.of(param).respond();
    }

    private NinteiChosaJissekiShokaiHandler getHandler(NinteiChosaJissekiShokaiDiv div) {
        return new NinteiChosaJissekiShokaiHandler(div);
    }

}
