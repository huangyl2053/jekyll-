/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.dbb0120001;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB012001.DBB012001_TokuchoHeinjunka6GatsuParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB012003.DBB012003_TokuchoHeinjunka6GatsuTsuchishoHakkoParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0120001.DBB0120001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0120001.HeijunkaKeisanDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0120001.HeijunkaKeisanHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0120001.HeijunkaKeisanValidationHandler;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.OutputChohyoIchiran.dgOutputChohyoIchiran_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 特徴平準化（特徴6月分）コントロールdivです。
 *
 * @reamsid_L DBB-0820-010 xuyue
 */
public class HeijunkaKeisan {

    private final RString 特徴平準化_特徴6月分_メニュー = new RString("DBBMN35001");
    private final RString 帳票分類ID_DBB100012 = new RString("DBB100012_KarisanteiHenjunkaHenkoTsuchishoDaihyo");

    /**
     * コントロールdivが「生成」された際の処理です。(オンロード)<br/>
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<HeijunkaKeisanDiv> onLoad(HeijunkaKeisanDiv div) {
        getHandler(div).initialize();
        if (ResponseHolder.getMenuID().equals(特徴平準化_特徴6月分_メニュー)) {
            return ResponseData.of(div).setState(DBB0120001StateName.平準化計算);
        }
        return ResponseData.of(div).setState(DBB0120001StateName.通知書一括発行);
    }

    /**
     * コントロールdivが「生成」された際の処理です。(オンアクティブ)<br/>
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<HeijunkaKeisanDiv> onActive(HeijunkaKeisanDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行」ボタンの前処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<HeijunkaKeisanDiv> beforeOnClick_btnHakko(HeijunkaKeisanDiv div) {

        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor発行日の必須入力(validPairs, div);
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 特徴平準化（特徴6月分）メニューからの「実行する」ボタンの処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<DBB012001_TokuchoHeinjunka6GatsuParameter> onClick_btnHeijunkaJikko(HeijunkaKeisanDiv div) {
        DBB012001_TokuchoHeinjunka6GatsuParameter parameter = getHandler(div).setBatchParameter();
        createFlowParameter(div, parameter);
        return ResponseData.of(parameter).respond();
    }

    /**
     * 特徴平準化（特徴6月分）通知書一括発行メニューからの「実行する」ボタンの処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<DBB012003_TokuchoHeinjunka6GatsuTsuchishoHakkoParameter> onClick_btnIkkatsuHakkoJikko(HeijunkaKeisanDiv div) {
        DBB012003_TokuchoHeinjunka6GatsuTsuchishoHakkoParameter parameter = getHandler(div).setIkatsuBatchParameter();
        return ResponseData.of(parameter).respond();
    }

    private void createFlowParameter(HeijunkaKeisanDiv div, DBB012001_TokuchoHeinjunka6GatsuParameter parameter) {
        FlowParameters fp = new FlowParameters();
        boolean 通知書一括発行 = false;
        for (dgOutputChohyoIchiran_Row row : div.getTokuchoHeijunkaChohyoHakko().getCcdChohyoIchiran().get出力帳票一覧()) {
            if (帳票分類ID_DBB100012.equals(row.getChohyoID())) {
                通知書一括発行 = true;
            }
        }
        fp.add(new RString("通知書一括発行"), 通知書一括発行);
        fp.add(new RString("調定年度"), parameter.get調定年度());
        fp.add(new RString("賦課年度"), parameter.get賦課年度());
        fp.add(new RString("出力帳票一覧List"), Base64Serializer.serialize(parameter.get出力帳票entity()));
        fp.add(new RString("発行日"), parameter.get発行日());
        fp.add(new RString("出力対象"), parameter.get出力対象指示フラグ());
        fp.add(new RString("一括発行フラグ"), parameter.is一括発行フラグ());
        fp.add(new RString("帳票グループ"), parameter.get帳票グループ());
        fp.add(new RString("文書番号"), parameter.get文書番号());
        FlowParameterAccessor.merge(fp);
    }

    private HeijunkaKeisanValidationHandler getValidationHandler() {
        return new HeijunkaKeisanValidationHandler();
    }

    private HeijunkaKeisanHandler getHandler(HeijunkaKeisanDiv div) {
        return new HeijunkaKeisanHandler(div);
    }

}
