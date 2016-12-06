/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.chosakekkainfogaikyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.chosakekkainfogaikyo.RembanServiceJokyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoshisetsuriyo.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoGaikyo.ChosaKekkaInfoGaikyoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoGaikyo.ChosaKekkaInfoGaikyoHandler;
import jp.co.ndensan.reams.db.dbe.service.core.basic.chosakekkainfogaikyo.ChosaKekkaInfoGaikyoFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査結果情報照会_概況調査取得処理。
 *
 * @reamsid_L DBE-3000-260 lizhuoxuan
 */
public class ChosaKekkaInfoGaikyo {

    private static final RString 出力する = new RString("1");

    /**
     * 認定調査結果情報照会_概況調査_一覧情報。
     *
     * @param div 認定調査結果情報照会_概況調査_一覧情報Div
     * @return 認定調査結果情報照会Div
     */
    public ResponseData<ChosaKekkaInfoGaikyoDiv> onLoad(ChosaKekkaInfoGaikyoDiv div) {
        int 認定調査依頼履歴番号 = 0;
        RString 申請書管理番号 = div.getShinseishoKanriNo();
        if (!div.getNinteichosaRirekiNo().isEmpty() && div.getNinteichosaRirekiNo() != null) {
            認定調査依頼履歴番号 = Integer.parseInt(String.valueOf(div.getNinteichosaRirekiNo()));
        } else {
            return createResponse(div);
        }
        if (出力する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査票_概況特記_出力有無, RDate.getNowDate()))) {
            div.getGaikyoChosaTokkiPanel().setDisplayNone(true);
            div.getGaikyoTokkiPanel().setDisplayNone(false);
        } else {
            div.getGaikyoChosaTokkiPanel().setDisplayNone(false);
            div.getGaikyoTokkiPanel().setDisplayNone(true);
        }
        RString 概況調査テキスト_イメージ区分 = RString.EMPTY;
        RString 概況特記テキスト_イメージ区分 = RString.EMPTY;
        ChosaKekkaInfoGaikyoParameter gaikyoParameter = ChosaKekkaInfoGaikyoParameter.
                createGamenParam(申請書管理番号, 認定調査依頼履歴番号, 概況調査テキスト_イメージ区分, 概況特記テキスト_イメージ区分);
        List<ChosaKekkaInfoGaikyoBusiness> chosaKekkaInfoGaikyoList
                = ChosaKekkaInfoGaikyoFinder.createInstance().getChosaKekkaInfoGaikyo(gaikyoParameter).records();

        List<ChosaKekkaInfoGaikyoBusiness> 認定調査結果概況ListCopy = new ArrayList<>(chosaKekkaInfoGaikyoList);
        chosaKekkaInfoGaikyoList = get認定調査結果概況一覧(認定調査結果概況ListCopy);
        if (chosaKekkaInfoGaikyoList == null || chosaKekkaInfoGaikyoList.isEmpty()) {
            概況調査テキスト_イメージ区分 = TokkijikoTextImageKubun.テキスト.getコード();
            概況特記テキスト_イメージ区分 = TokkijikoTextImageKubun.テキスト.getコード();
        } else {
            概況調査テキスト_イメージ区分 = chosaKekkaInfoGaikyoList.get(0).get概況調査テキストイメージ区分();
            概況特記テキスト_イメージ区分 = chosaKekkaInfoGaikyoList.get(0).get概況調査テキストイメージ区分();
        }
        div.setHdnTextImageKubun(概況調査テキスト_イメージ区分);
        gaikyoParameter = ChosaKekkaInfoGaikyoParameter.createGamenParam(
                申請書管理番号, 認定調査依頼履歴番号, 概況調査テキスト_イメージ区分, 概況特記テキスト_イメージ区分);
        List<RembanServiceJokyoBusiness> serviceJokyos
                = ChosaKekkaInfoGaikyoFinder.createInstance().getRembanServiceJokyo(gaikyoParameter).records();
        List<NinteichosahyoShisetsuRiyo> shisetsuRiyos
                = ChosaKekkaInfoGaikyoFinder.createInstance().get5210NinteichosahyoShisetsu(gaikyoParameter).records();
        getHandler(div).onLoad(chosaKekkaInfoGaikyoList, serviceJokyos, shisetsuRiyos, gaikyoParameter);
        return createResponse(div);
    }

    private List<ChosaKekkaInfoGaikyoBusiness> get認定調査結果概況一覧(List<ChosaKekkaInfoGaikyoBusiness> 認定調査結果概況List) {
        RString 概況調査テキストイメージ区分 = RString.EMPTY;
        int テキストイメージ区分レコードカウント = 0;
        for (ChosaKekkaInfoGaikyoBusiness 認定調査結果概況Entity : 認定調査結果概況List) {
            if (RString.isNullOrEmpty(概況調査テキストイメージ区分)) {
                概況調査テキストイメージ区分 = 認定調査結果概況Entity.get概況調査テキストイメージ区分();
                テキストイメージ区分レコードカウント++;
            }
            if (!概況調査テキストイメージ区分.equals(認定調査結果概況Entity.get概況調査テキストイメージ区分())) {
                テキストイメージ区分レコードカウント++;
                break;
            }
        }
        if (テキストイメージ区分レコードカウント > 1) {
            List<ChosaKekkaInfoGaikyoBusiness> 認定調査結果概況ListCopy = new ArrayList<>(認定調査結果概況List);
            認定調査結果概況List = remove認定調査結果概況一覧(認定調査結果概況ListCopy);
        }
        return 認定調査結果概況List;
    }

    private List<ChosaKekkaInfoGaikyoBusiness> remove認定調査結果概況一覧(List<ChosaKekkaInfoGaikyoBusiness> 認定調査結果概況List) {
        List<ChosaKekkaInfoGaikyoBusiness> イメージのみ認定調査結果概況List = new ArrayList<>();
        for (ChosaKekkaInfoGaikyoBusiness 認定調査結果概況Entity : 認定調査結果概況List) {
            if (TokkijikoTextImageKubun.イメージ.getコード().equals(認定調査結果概況Entity.get概況調査テキストイメージ区分())) {
                イメージのみ認定調査結果概況List.add(認定調査結果概況Entity);
            }
        }
        return イメージのみ認定調査結果概況List;
    }

    /**
     * マスキングボタンを押下します。
     *
     * @param div 画面情報
     * @return 認定調査結果情報照会Div
     */
    public ResponseData<ChosaKekkaInfoGaikyoDiv> onBeforeOpenDialog_btnMaskingGaikyoChosa(ChosaKekkaInfoGaikyoDiv div) {
        return ResponseData.of(div).respond();
    }

    /**
     * 戻るボタンを押下します。
     *
     * @param div 画面情報
     * @return 認定調査結果情報照会Div
     */
    public ResponseData<ChosaKekkaInfoGaikyoDiv> onClick_btnReturn(ChosaKekkaInfoGaikyoDiv div) {
        return ResponseData.of(div).respond();
    }

    private ChosaKekkaInfoGaikyoHandler getHandler(ChosaKekkaInfoGaikyoDiv div) {
        return new ChosaKekkaInfoGaikyoHandler(div);
    }

    private ResponseData<ChosaKekkaInfoGaikyoDiv> createResponse(ChosaKekkaInfoGaikyoDiv div) {
        return ResponseData.of(div).respond();
    }

}
