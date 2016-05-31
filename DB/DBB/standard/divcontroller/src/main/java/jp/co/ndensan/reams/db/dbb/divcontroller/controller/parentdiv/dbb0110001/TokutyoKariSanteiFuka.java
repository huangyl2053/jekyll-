/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.dbb0110001;

import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchokarisanteifuka.TokuchoKariSanteiParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0110001.TokutyoKariSanteiFukaDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb0110001.TokutyoKariSanteiFukaHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 画面設計_DBBGM33001_特徴仮算定賦課
 *
 * @reamsid_L DBB-0790-010 yangchenbing
 */
public class TokutyoKariSanteiFuka {

    private static final RString 発行日 = new RString("発行日");

    /**
     * コントロールdivが「生成」された際の処理です。(オンロード) .
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<TokutyoKariSanteiFukaDiv> onLoad(TokutyoKariSanteiFukaDiv div) {
        TokutyoKariSanteiFukaHandler handler = getHandler(div);
        handler.initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 特徴仮算定賦課を「実行する」を押下する。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     *
     */
    public ResponseData<TokuchoKariSanteiParameter> btnSantei(TokutyoKariSanteiFukaDiv div) {
        //TODO  batchをを待つ、batchparameterを待つ
        TokuchoKariSanteiParameter param = getHandler(div).btncommon(div);
        return ResponseData.of(param).respond();
    }

    /**
     * 特徴仮算定賦課を「予約する」を押下する。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<TokuchoKariSanteiParameter> btnSanteiYoyaku(TokutyoKariSanteiFukaDiv div) {
        //TODO  batchをを待つ、batchparameterを待つ
        TokuchoKariSanteiParameter param = getHandler(div).btncommon(div);
        return ResponseData.of(param).respond();
    }

    /**
     * 発行日未入力チェックのンメソッドです。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<TokutyoKariSanteiFukaDiv> publishDateCheck(TokutyoKariSanteiFukaDiv div) {
        Map<RString, RString> map = div.getTokutyoKariSanteiFukaChohyoHakko().getCcdChohyoIchiran().getSelected帳票IdAnd出力順Id();
        RString publishidate = div.getTokutyoKariSanteiFukaChohyoHakko().getTokutyoKariTsuchiKobetsuJoho().
                getTxtTokuKaishiTsuchiHakkoYMD2().getText();
        if (!map.isEmpty() && RString.isNullOrEmpty(publishidate)) {
            throw new ApplicationException(UrErrorMessages.必須
                    .getMessage().replace(発行日.toString()).evaluate());
        }
        return ResponseData.of(div).respond();
    }

    private TokutyoKariSanteiFukaHandler getHandler(TokutyoKariSanteiFukaDiv div) {
        return TokutyoKariSanteiFukaHandler.of(div);
    }
}
