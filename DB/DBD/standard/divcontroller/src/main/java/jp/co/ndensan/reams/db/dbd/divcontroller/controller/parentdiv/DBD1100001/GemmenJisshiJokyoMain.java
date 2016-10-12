/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1100001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD104010.DBD104010_JukyushaGemmenJisshiJokyoParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1100001.GemmenJisshiJokyoMainDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1100001.GemmenJisshiJokyoMainHandler;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.NendoUtil;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者減免実施状況のDivControllerです。
 *
 * @reamsid_L DBD-3770-010 x_liuwei
 */
public class GemmenJisshiJokyoMain {

    private static final int LENGTH = 32;

    /**
     * 画面初期化処理です。
     *
     * @param div GemmenJisshiJokyoMainDiv
     * @return ResponseData<GemmenJisshiJokyoMainDiv>
     */
    public ResponseData<GemmenJisshiJokyoMainDiv> onload(GemmenJisshiJokyoMainDiv div) {
        div.getGemmenJisshiJokyoJoken().getCcdAtenaJoken().initialize();
        div.getGemmenJisshiJokyoJoken().getTxtTaishoNendo().setDomain(NendoUtil.getNendo(RDate.getNowDate()));
        List<RString> list = new ArrayList();
        for (int i = 1; i < LENGTH; i++) {
            list.add(new RString(i));
        }
        div.getGemmenJisshiJokyoJoken().getTxtKijunBi().setSuggest(list);
        return ResponseData.of(div).respond();
    }

    /**
     * 出力帳票onChange。
     *
     * @param div GemmenJisshiJokyoMainDiv
     * @return ResponseData<GemmenJisshiJokyoMainDiv>
     */
    public ResponseData<GemmenJisshiJokyoMainDiv> onChange_RadShutsuryokuChohyo(GemmenJisshiJokyoMainDiv div) {
        getHandler(div).onChange_RadShutsuryokuChohyo();
        return ResponseData.of(div).respond();
    }

    /**
     * 基準年月と基準日onChange。
     *
     * @param div GemmenJisshiJokyoMainDiv
     * @return ResponseData<GemmenJisshiJokyoMainDiv>
     */
    public ResponseData<GemmenJisshiJokyoMainDiv> onChange_RadKijun(GemmenJisshiJokyoMainDiv div) {
        getHandler(div).onChange_RadKijun();
        return ResponseData.of(div).respond();
    }

    /**
     * 条件を保存するバッタンonClick。
     *
     * @param div GemmenJisshiJokyoMainDiv
     * @return ResponseData<BatchParameterMap>
     */
    public ResponseData<BatchParameterMap> onClick_btnBatchParameterSave(GemmenJisshiJokyoMainDiv div) {
        //TODO
        ResponseData<BatchParameterMap> responseData = new ResponseData<>();
        responseData.data = new BatchParameterMap(getHandler(div).onClick_btnBatchParameterSave());
        return responseData;
    }

    /**
     * 条件を復元するバッタンonClick。
     *
     * @param div GemmenJisshiJokyoMainDiv
     * @return ResponseData<GemmenJisshiJokyoMainDiv>
     */
    public ResponseData<GemmenJisshiJokyoMainDiv> onClick_btnBatchParameterRestore(GemmenJisshiJokyoMainDiv div) {
        //TODO
        getHandler(div).onClick_btnBatchParameterRestore();
        return ResponseData.of(div).respond();
    }

    /**
     * 処理実行の確認です。
     *
     * @param div GemmenJisshiJokyoMainDiv
     * @return ResponseData<DBD104010_JukyushaGemmenJisshiJokyoParameter>
     */
    public ResponseData<DBD104010_JukyushaGemmenJisshiJokyoParameter> onClickCheck_btnBatchRegister(GemmenJisshiJokyoMainDiv div) {
        DBD104010_JukyushaGemmenJisshiJokyoParameter parameter = getHandler(div).onClick_btnBatchParameterSave();
        return ResponseData.of(parameter).respond();
    }

    private GemmenJisshiJokyoMainHandler getHandler(GemmenJisshiJokyoMainDiv div) {
        return new GemmenJisshiJokyoMainHandler(div);
    }
}
