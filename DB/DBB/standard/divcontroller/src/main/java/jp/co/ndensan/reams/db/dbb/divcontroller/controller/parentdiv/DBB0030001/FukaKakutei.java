/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0030001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.relate.tokuchokarisanteifukakakutei.TokuchoKarisanteiFukaKakuteiMapperParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0030001.FukaKakuteiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0030001.FukaKakuteiPanelHandler;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteifukakakutei.TokuchoKarisanteiFukaKakuteiManager;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 *
 * 特徴仮算定賦課確定コントローラです。
 *
 * @reamsid_L DBB-0800-010 wanghui
 */
public class FukaKakutei {

    private final TokuchoKarisanteiFukaKakuteiManager fukaKakuteiManager;
    private static final RString 特徴仮算定賦課 = new RString("特徴仮算定賦課");
    private static final RString 普徴仮算定賦課 = new RString("普徴仮算定賦課");
    private static final RString 仮算定異動賦課 = new RString("仮算定異動賦課");
    private static final RString 本算定賦課 = new RString("本算定賦課");
    private static final RString 異動賦課 = new RString("異動賦課");
    private static final RString 特徴仮算定賦課確定 = new RString("特徴仮算定賦課確定");
    private static final RString 普徴仮算定賦課確定 = new RString("普徴仮算定賦課確定");
    private static final RString 仮算定異動賦課確定 = new RString("仮算定異動賦課確定");
    private static final RString 本算定賦課確定 = new RString("本算定賦課確定");
    private static final RString 異動賦課確定 = new RString("異動賦課確定");
    private static final RString 共通ボタン = new RString("btnFukaKakutei");
    private static final RString 現年度異動賦課確定 = new RString("現年度異動賦課確定");
    private static final RString DBBMN33003 = new RString("DBBMN33003");
    private static final RString DBBMN34003 = new RString("DBBMN34003");

    /**
     * コンストラクタです。
     */
    public FukaKakutei() {
        fukaKakuteiManager = TokuchoKarisanteiFukaKakuteiManager.createInstance();
    }

    /**
     * onLoadの処理を行います。
     *
     * @param div 特徴仮算定賦課確定Div
     * @return ResponseData
     */
    public ResponseData<FukaKakuteiDiv> onLoad(FukaKakuteiDiv div) {
        RString menuID = ResponseHolder.getMenuID();
        CommonButtonHolder.setDisabledByCommonButtonFieldName(共通ボタン, true);
        getHandler(div).賦課年度の設定();
        if (DBBMN33003.equals(menuID)
                && getHandler(div).処理名_特徴仮算定賦課(基準日時取得(div, 特徴仮算定賦課), 基準日時取得(div, 特徴仮算定賦課確定))) {
            return ResponseData.of(div).rootTitle(特徴仮算定賦課確定).respond();
        }
        if (DBBMN34003.equals(menuID)
                && getHandler(div).処理名_普徴仮算定賦課(基準日時取得(div, 普徴仮算定賦課), 基準日時取得(div, 普徴仮算定賦課確定))) {
            return ResponseData.of(div).rootTitle(普徴仮算定賦課確定).respond();
        }
        if (getHandler(div).処理名_仮算定異動賦課(基準日時取得(div, 仮算定異動賦課), 基準日時取得(div, 仮算定異動賦課確定))) {
            return ResponseData.of(div).rootTitle(現年度異動賦課確定).respond();
        }
        if (getHandler(div).処理名_本算定賦課(基準日時取得(div, 本算定賦課), 基準日時取得(div, 本算定賦課確定))) {
            return ResponseData.of(div).rootTitle(現年度異動賦課確定).respond();
        }
        if (getHandler(div).処理名_異動賦課(基準日時取得(div, 異動賦課), 基準日時取得(div, 異動賦課確定))) {
            return ResponseData.of(div).rootTitle(現年度異動賦課確定).respond();
        }
        return ResponseData.of(div).rootTitle(現年度異動賦課確定).respond();
    }

    /**
     * 確定処理を実行します。
     *
     * @param div 特徴仮算定賦課確定Div
     * @return ResponseData
     */
    public ResponseData<FukaKakuteiDiv> onClick_Kakuninjiko(FukaKakuteiDiv div) {
        基準日時登録更新(div);
        賦課処理状況更新(div);
        return ResponseData.of(div).respond();
    }

    private FukaKakuteiPanelHandler getHandler(FukaKakuteiDiv div) {
        return new FukaKakuteiPanelHandler(div);
    }

    private void 基準日時登録更新(FukaKakuteiDiv div) {
        fukaKakuteiManager.updateKijunDateTime(div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtKakuteiFukaNendo().getDomain(),
                div.getFukaKakuteiBatchParameter().get処理名());
    }

    private void 賦課処理状況更新(FukaKakuteiDiv div) {
        TokuchoKarisanteiFukaKakuteiMapperParameter parameter = TokuchoKarisanteiFukaKakuteiMapperParameter.createParam(
                div.getFukaKakuteiBatchParameter().get基準日時(),
                div.getFukaKakuteiBatchParameter().
                getFukaKeisanShoriNaiyo().getTxtKakuteiFukaNendo().getDomain());
        fukaKakuteiManager.updateFukaShoriJyokyo(parameter);
    }

    private YMDHMS 基準日時取得(FukaKakuteiDiv div, RString 処理名) {

        return fukaKakuteiManager.getKijunDateTime(div.getFukaKakuteiBatchParameter().getFukaKeisanShoriNaiyo().getTxtKakuteiFukaNendo().getDomain(), 処理名);
    }
}
