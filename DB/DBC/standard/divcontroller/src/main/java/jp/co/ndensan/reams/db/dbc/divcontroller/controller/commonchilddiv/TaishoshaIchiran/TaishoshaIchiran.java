/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.TaishoshaIchiran;

import jp.co.ndensan.reams.db.dbc.business.core.kyodojukyushataishosha.KyodoJukyushaTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.TaishoshaIchiran.TaishoshaIchiran.TaishoshaIchiranDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.TaishoshaIchiran.TaishoshaIchiran.TaishoshaIchiranDivHandler;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.taishoshaichiran.TaishoshaIchiranParameter;
import jp.co.ndensan.reams.db.dbc.service.core.kyodoshoriyojukyushaidorenrakuhyo.KyodoshoriyoJukyushaIdoRenrakuhyo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 対象者一覧共有子Div
 *
 * @reamsid_L DBC-4471-010 xupeng
 */
public class TaishoshaIchiran {

    /**
     * 「選択ボタン」押下
     *
     * @param div TaishoshaIchiranDiv
     * @return ResponseData<TaishoshaIchiranDiv>
     */
    public ResponseData<TaishoshaIchiranDiv> onClick_btnSelect(TaishoshaIchiranDiv div) {
        KyodoJukyushaTaishoshaEntity entity = getHandler(div).set選択行検索キー();
        ViewStateHolder.put(ViewStateKeys.一覧検索キー, entity);
        ShikibetsuCode 識別コード = KyodoshoriyoJukyushaIdoRenrakuhyo.createInstance().get識別コード(entity.get被保番号());
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        TaishoshaIchiranParameter parameter = getHandler(div).set登録退避用検索キー();
        ViewStateHolder.put(ViewStateKeys.退避用データ, parameter);
        return ResponseData.of(div).respond();
    }

    /**
     * 「修正ボタン」押下
     *
     * @param div TaishoshaIchiranDiv
     * @return ResponseData<TaishoshaIchiranDiv>
     */
    public ResponseData<TaishoshaIchiranDiv> onClick_btnModify(TaishoshaIchiranDiv div) {
        KyodoJukyushaTaishoshaEntity entity = getHandler(div).set選択行検索キー();
        ViewStateHolder.put(ViewStateKeys.一覧検索キー, entity);
        ShikibetsuCode 識別コード = KyodoshoriyoJukyushaIdoRenrakuhyo.createInstance().get識別コード(entity.get被保番号());
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        TaishoshaIchiranParameter parameter = getHandler(div).set登録退避用検索キー();
        ViewStateHolder.put(ViewStateKeys.退避用データ, parameter);
        return ResponseData.of(div).respond();
    }

    private TaishoshaIchiranDivHandler getHandler(TaishoshaIchiranDiv div) {
        return TaishoshaIchiranDivHandler.of(div);
    }

}
