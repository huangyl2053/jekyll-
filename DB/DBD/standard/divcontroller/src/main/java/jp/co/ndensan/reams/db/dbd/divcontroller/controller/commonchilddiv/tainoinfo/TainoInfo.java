/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.commonchilddiv.tainoinfo;

import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoHanteiResult;
import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoHanteiResultKohen;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gengakuinfo.GengakuInfo.GengakuInfoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.tainoinfo.TainoInfo.TainoInfoDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 【共有子Div】 滞納情報のDivControllerです。
 *
 * @reamsid_L DBD-3620-010 liangbc
 */
public class TainoInfo {

    /**
     * 初期化
     *
     * @param div ShotokuJokyoDiv
     * @return ResponseData<TainoInfoDiv>
     */
    public ResponseData<TainoInfoDiv> initialize(TainoInfoDiv div) {
        TainoHanteiResult 滞納判定結果 = div.initialize();
        TainoHanteiResultKohen 更新滞納判定結果 = new TainoHanteiResultKohen(滞納判定結果);
        ViewStateHolder.put(ViewStateKeys.滞納判定結果, 更新滞納判定結果);
        return ResponseData.of(div).respond();
    }

    /**
     * 「基準日で検索する」ボタンをクリックする
     *
     * @param div ShotokuJokyoDiv
     * @return ResponseData<TainoInfoDiv>
     */
    public ResponseData<TainoInfoDiv> onClick_btnKensaku(TainoInfoDiv div) {
        TainoHanteiResult 滞納判定結果 = div.kensaku();
        if (滞納判定結果.get滞納情報().isEmpty()) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        }
        TainoHanteiResultKohen 更新滞納判定結果 = new TainoHanteiResultKohen(滞納判定結果);
        ViewStateHolder.put(ViewStateKeys.滞納判定結果, 更新滞納判定結果);
        return ResponseData.of(div).respond();
    }

    /**
     * 「確定する」ボタンをクリックする
     *
     * @param div GengakuInfoDiv
     * @return ResponseData<GengakuInfoDiv>
     */
    public ResponseData<GengakuInfoDiv> onClick_btnKakutei(GengakuInfoDiv div) {
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 「閉じる」ボタンをクリックする
     *
     * @param div GengakuInfoDiv
     * @return ResponseData<GengakuInfoDiv>
     */
    public ResponseData<GengakuInfoDiv> onClick_btnReturn(GengakuInfoDiv div) {
        ViewStateHolder.remove(ViewStateKeys.滞納判定結果.name());
        return ResponseData.of(div).dialogOKClose();
    }
}
