/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0210031;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB021031.DBB021031_DankaibetsuHihokenshasuIchiranhyoSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210031.ShotokuDankaibetsuHihokenshaSuIchiranDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0210031.ShotokuDankaibetsuHihokenshaSuIchiranHandler;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0210031.ShotokuDankaibetsuHihokenshaSuIchiranValidationHandler;
import jp.co.ndensan.reams.db.dbz.business.core.shichosonsentaku.ShichosonSelectorModel;
import jp.co.ndensan.reams.db.dbz.business.core.shichosonsentaku.ShichosonSelectorResult;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 画面設計_DBBGM21004_段階別被保険者数一覧表作成
 *
 * @reamsid_L DBB-1820-010 chenyadong
 */
public class ShotokuDankaibetsuHihokenshaSuIchiran {

    /**
     * 画面初期化のメソッドです。
     *
     * @param div ShotokuDankaibetsuHihokenshaSuIchiranDiv
     * @return ResponseData
     */
    public ResponseData<ShotokuDankaibetsuHihokenshaSuIchiranDiv> onLoad(ShotokuDankaibetsuHihokenshaSuIchiranDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * ddlChoteiNendoのonChange事件です。
     *
     * @param div ShotokuDankaibetsuHihokenshaSuIchiranDiv
     * @return ResponseData
     */
    public ResponseData<ShotokuDankaibetsuHihokenshaSuIchiranDiv> onChange_ddlChoteiNendo(ShotokuDankaibetsuHihokenshaSuIchiranDiv div) {
        getHandler(div).onChangeNendo();
        return ResponseData.of(div).respond();
    }

    /**
     * radShichosonのonChange事件です。
     *
     * @param div ShotokuDankaibetsuHihokenshaSuIchiranDiv
     * @return ResponseData
     */
    public ResponseData<ShotokuDankaibetsuHihokenshaSuIchiranDiv> onChange_radShichoson(ShotokuDankaibetsuHihokenshaSuIchiranDiv div) {
        getHandler(div).onChangeShichoson();
        return ResponseData.of(div).respond();
    }

    /**
     * chkChosaJokenのonChange事件です。
     *
     * @param div ShotokuDankaibetsuHihokenshaSuIchiranDiv
     * @return ResponseData
     */
    public ResponseData<ShotokuDankaibetsuHihokenshaSuIchiranDiv> onChange_chkChosaJoken(ShotokuDankaibetsuHihokenshaSuIchiranDiv div) {
        getHandler(div).onChangeChosaJoken();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行ボタン押下した時の早期処理」ボタンのメソッドです。
     *
     * @param div ShotokuDankaibetsuHihokenshaSuIchiranDiv
     * @return ResponseData
     */
    public ResponseData<ShotokuDankaibetsuHihokenshaSuIchiranDiv> onBeforeOpenChecks(ShotokuDankaibetsuHihokenshaSuIchiranDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validate();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行ボタン押下した時の処理」ボタンのメソッドです。
     *
     * @param div ShotokuDankaibetsuHihokenshaSuIchiranDiv
     * @return ResponseData
     */
    public ResponseData<DBB021031_DankaibetsuHihokenshasuIchiranhyoSakuseiParameter> onClick_btn(
            ShotokuDankaibetsuHihokenshaSuIchiranDiv div) {
        DBB021031_DankaibetsuHihokenshasuIchiranhyoSakuseiParameter param = setBatchParameter(div);
        return ResponseData.of(param).respond();
    }

    private DBB021031_DankaibetsuHihokenshasuIchiranhyoSakuseiParameter setBatchParameter(
            ShotokuDankaibetsuHihokenshaSuIchiranDiv div) {
        DBB021031_DankaibetsuHihokenshasuIchiranhyoSakuseiParameter parameter
                = new DBB021031_DankaibetsuHihokenshasuIchiranhyoSakuseiParameter();
        parameter.setSettingnendo(div.getDdlChoteiNendo().getSelectedKey());
        parameter.setTreatmentday(div.getTxtHonsanteiShoriYMD().getValue());
        parameter.setRegiondivision(div.getRadShichoson().getSelectedValue());

        ShichosonSelectorModel model = DataPassingConverter.deserialize(div.getKyuShichoson(), ShichosonSelectorModel.class);
        List<RString> list = new ArrayList<>();
        if (model != null) {
            for (ShichosonSelectorResult result : model.getList()) {
                if (result.get市町村コード() != null) {
                    list.add(result.get市町村コード().getColumnValue());
                }
            }
            parameter.setDantaiCd(list);
        }
        parameter.setQkijund(div.getTxtShikakuKijunYMD().getValue());
        parameter.setAdjustedkijund(div.getTxtChoteiKijunYMD().getValue());
        return parameter;
    }

    private ShotokuDankaibetsuHihokenshaSuIchiranHandler getHandler(ShotokuDankaibetsuHihokenshaSuIchiranDiv div) {
        return new ShotokuDankaibetsuHihokenshaSuIchiranHandler(div);
    }

    private ShotokuDankaibetsuHihokenshaSuIchiranValidationHandler getValidationHandler(ShotokuDankaibetsuHihokenshaSuIchiranDiv div) {
        return new ShotokuDankaibetsuHihokenshaSuIchiranValidationHandler(div);
    }
}
