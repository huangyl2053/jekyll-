/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.commonchilddiv.gengakuinfo;

import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoHanteiResult;
import jp.co.ndensan.reams.db.dbd.business.core.taino.TainoHanteiResultKohen;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.TainoHanteiKubun;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gengakuinfo.GengakuInfo.GengakuInfoDiv;
import jp.co.ndensan.reams.db.dbd.service.core.taino.TainoJokyoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoKanriKubun;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 【共有子Div】 減額情報のDivControllerです。
 *
 * @reamsid_L DBD-3620-030 liangbc
 */
public class GengakuInfo {

    /**
     * 初期化
     *
     * @param div GengakuInfoDiv
     * @return ResponseData<GengakuInfoDiv>
     */
    public ResponseData<GengakuInfoDiv> initialize(GengakuInfoDiv div) {
        if (div.is管理区分と滞納判定区分と履歴番号ある()) {
            TainoHanteiResult 滞納判定結果 = TainoJokyoFinder.createInstance().find支払方法変更滞納(new HihokenshaNo(div.getHihokenshaNo()),
                    ShiharaiHenkoKanriKubun.toValue(div.getKanriKuben()), Integer.parseInt(div.getRirekiNo().toString()),
                    TainoHanteiKubun.toValue(div.getTainohanteiKuben()));
            TainoHanteiResultKohen 更新滞納判定結果 = new TainoHanteiResultKohen(滞納判定結果);
            ViewStateHolder.put(ViewStateKeys.滞納判定結果, 更新滞納判定結果);
            div.init照会モード(滞納判定結果);
        } else {
            div.init状態１();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「基準日で検索する」ボタンをクリックする
     *
     * @param div GengakuInfoDiv
     * @return ResponseData<GengakuInfoDiv>
     */
    public ResponseData<GengakuInfoDiv> onClick_btnKensaku(GengakuInfoDiv div) {
        TainoHanteiResult 滞納判定結果 = TainoJokyoFinder.createInstance().research滞納情報(new HihokenshaNo(div.getHihokenshaNo()),
                new FlexibleDate(div.getTxtHanteiKijunYMD().getValue().toString()));
        TainoHanteiResultKohen 更新滞納判定結果 = new TainoHanteiResultKohen(滞納判定結果);
        ViewStateHolder.put(ViewStateKeys.滞納判定結果, 更新滞納判定結果);
        div.init状態２(滞納判定結果);
        return ResponseData.of(div).respond();
    }

    /**
     * 収納情報エリアの「選択」ボタンをクリックする
     *
     * @param div GengakuInfoDiv
     * @return ResponseData<GengakuInfoDiv>
     */
    public ResponseData<GengakuInfoDiv> onSelect_dgGenGaku(GengakuInfoDiv div) {
        TainoHanteiResultKohen 滞納判定結果 = ViewStateHolder.get(ViewStateKeys.滞納判定結果, TainoHanteiResultKohen.class);
        div.init状態３(滞納判定結果);
        return ResponseData.of(div).respond();
    }

    /**
     * 「収納情報に戻る」ボタンをクリックする
     *
     * @param div GengakuInfoDiv
     * @return ResponseData<GengakuInfoDiv>
     */
    public ResponseData<GengakuInfoDiv> onClick_btnModoru(GengakuInfoDiv div) {
        div.getTainoNendo().setIsOpen(true);
        div.getTainoGengakuShosaiInfo().setIsOpen(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 全行表示チェックボックスのチェックオン/チェックオフ
     *
     * @param div GengakuInfoDiv
     * @return ResponseData<GengakuInfoDiv>
     */
    public ResponseData<GengakuInfoDiv> onClick_chkHyojiKirikae(GengakuInfoDiv div) {
        div.setIs賦課年度_普特_通知書番号Visible(!div.getChkHyojiKirikae().getSelectedItems().isEmpty());
        return ResponseData.of(div).respond();
    }

    /**
     * 「閉じる」ボタンをクリックする
     *
     * @param div GengakuInfoDiv
     * @return ResponseData<GengakuInfoDiv>
     */
    public ResponseData<GengakuInfoDiv> onClick_btnReturn(GengakuInfoDiv div) {
        return ResponseData.of(div).dialogOKClose();
    }

}
