/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0030001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.relate.tokuchokarisanteifukakakutei.TokuchoKarisanteiFukaKakuteiMapperParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0030001.FukaKakuteiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0030001.FukaKakuteiPanelHandler;
import jp.co.ndensan.reams.db.dbb.service.tokuchokarisanteifukakakutei.TokuchoKarisanteiFukaKakuteiManager;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 特徴仮算定賦課確定コントローラです。
 */
public class FukaKakutei {

    /**
     * onLoadの処理を行います。
     *
     * @param div 特徴仮算定賦課確定Div
     * @return ResponseData
     */
    public ResponseData<FukaKakuteiDiv> onLoad(FukaKakuteiDiv div) {
        BusinessConfig.get(ConfigNameDBB.日付関連_調定年度, SubGyomuCode.DBB介護賦課);
        getHandler(div).initialize(TokuchoKarisanteiFukaKakuteiManager.createInstance());
        return ResponseData.of(div).respond();

    }

    /**
     * 確定処理実行します。
     *
     * @param div 特徴仮算定賦課確定Div
     * @return ResponseData
     */
    public ResponseData<FukaKakuteiDiv> onClick_Kakuninjiko(FukaKakuteiDiv div) {
        確定処理実行(div);
        updateFukaShoriJyokyo(div);
        return ResponseData.of(div).respond();

    }

    private FukaKakuteiPanelHandler getHandler(FukaKakuteiDiv div) {
        return new FukaKakuteiPanelHandler(div);
    }

    private void 確定処理実行(FukaKakuteiDiv div) {
        TokuchoKarisanteiFukaKakuteiManager
                .createInstance().updateKijunDateTime(div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtKakuteiFukaNendo().getDomain(),
                        div.getFukaKakuteiBatchParameter().get処理名());
    }

    private boolean updateFukaShoriJyokyo(FukaKakuteiDiv div) {
        TokuchoKarisanteiFukaKakuteiMapperParameter parameter = TokuchoKarisanteiFukaKakuteiMapperParameter.createParam(div.getFukaKakuteiBatchParameter().
                getFukaKeisanShoriNaiyo().getTxtFukaKeisanShoriNichiji().getValue(), div.getFukaKakuteiBatchParameter().
                getFukaKeisanShoriNaiyo().getTxtKakuteiFukaNendo().getDomain());
        boolean 賦課処理状況 = TokuchoKarisanteiFukaKakuteiManager.createInstance().updateFukaShoriJyokyo(parameter);
        return 賦課処理状況;
    }
}
