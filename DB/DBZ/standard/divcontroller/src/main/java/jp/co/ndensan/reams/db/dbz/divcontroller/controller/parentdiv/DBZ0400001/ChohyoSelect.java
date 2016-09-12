/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv.DBZ0400001;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0400001.ChohyoSelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.DBZ0400001.ChohyoSelectHandler;
import jp.co.ndensan.reams.db.dbz.service.core.chohyoseigyokyotsucontro.ChohyoSeigyoKyotsuControFinder;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 帳票選択データの取得処理クラスです。
 *
 * @reamsid_L DBA-1201-010 wanghui
 */
public class ChohyoSelect {

    private final ChohyoSeigyoKyotsuControFinder finder;

    /**
     * コンストラクタです。
     *
     */
    public ChohyoSelect() {
        this.finder = ChohyoSeigyoKyotsuControFinder.createInstance();
    }

    /**
     * 初期化します。
     *
     * @param div ChohyoSelectDiv
     * @return ResponseData<ChohyoSelectDiv>
     */
    public ResponseData<ChohyoSelectDiv> onLoad(ChohyoSelectDiv div) {
        SubGyomuCode サブ業務コード = ControlDataHolder.getExecutionSubGyomuCode();
        List<ChohyoSeigyoKyotsu> resultList = finder.select帳票分類名称(サブ業務コード, true).records();
        getHandler(div).initialize(resultList);
        return ResponseData.of(div).respond();
    }

    /**
     * 帳票一覧Grid.選択ボタン。
     *
     * @param div ChohyoSelectDiv
     * @return ResponseData<ChohyoSelectDiv>
     */
    public ResponseData<ChohyoSelectDiv> onClick_dgChohyoIchiran(ChohyoSelectDiv div) {
        ViewStateHolder.put(ViewStateKeys.帳票分類ID, div.getDgChohyoIchiran().getClickedItem().getChohyoBunruiId());
        ViewStateHolder.put(ViewStateKeys.帳票分類名称, div.getDgChohyoIchiran().getClickedItem().getChohyoBunruiName());
        return ResponseData.of(div).respond();
    }

    private ChohyoSelectHandler getHandler(ChohyoSelectDiv div) {
        return new ChohyoSelectHandler(div);
    }
}
