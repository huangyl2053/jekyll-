/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB9020001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020001.FukaKijunTotalDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB9020001.FukaKijunTotalHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * システム管理（賦課基準）のイベント処理です。
 *
 * @reamsid_L DBB-1770-010 zhangrui
 */
public class FukaKijunTotal {

    /**
     * 画面初期化です。
     *
     * @param div システム管理（賦課基準）の画面Div
     * @return ResponseData<FukaKijunTotalDiv>
     */
    public ResponseData<FukaKijunTotalDiv> onload(FukaKijunTotalDiv div) {
        FukaKijunTotalHandler handler = getHandler(div);
        handler.前排他を設定する();
        handler.賦課年度の設定();
        handler.ランクの取得();
        return ResponseData.of(div).setState(handler.遷移先の設定());
    }

    /**
     * 賦課年度選択イベント処理。
     *
     * @param div システム管理（賦課基準）の画面Div
     * @return ResponseData<FukaKijunTotalDiv>
     */
    public ResponseData<FukaKijunTotalDiv> onChange_DdlFukaNendo(FukaKijunTotalDiv div) {
        FukaKijunTotalHandler handler = getHandler(div);
        handler.ランクの取得();
        return ResponseData.of(div).setState(handler.遷移先の設定());
    }

    /**
     * ランク選択イベント処理。
     *
     * @param div システム管理（賦課基準）の画面Div
     * @return ResponseData<FukaKijunTotalDiv>
     */
    public ResponseData<FukaKijunTotalDiv> onChange_DdlRank(FukaKijunTotalDiv div) {
        FukaKijunTotalHandler handler = getHandler(div);
        return ResponseData.of(div).setState(handler.遷移先の設定());
    }

    private FukaKijunTotalHandler getHandler(FukaKijunTotalDiv div) {
        return new FukaKijunTotalHandler(div);
    }
}
