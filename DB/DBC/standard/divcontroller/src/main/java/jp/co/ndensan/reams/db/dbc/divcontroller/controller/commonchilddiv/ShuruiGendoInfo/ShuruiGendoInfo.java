/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.ShuruiGendoInfo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku.KyufuJikoSakuseiResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShuruiGendoInfo.ShuruiGendoInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShuruiGendoInfo.ShuruiGendoInfoHandler;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * サービス種類限度額統計処理クラスです。
 *
 * @reamsid_L DBC-1930-040 jianglaisheng
 */
public class ShuruiGendoInfo {

    /**
     * 初期化します。
     *
     * @param div ShuruiGendoInfoDiv
     * @return ResponseData <ShuruiGendoInfoDiv>
     */
    public ResponseData<ShuruiGendoInfoDiv> onLoad(ShuruiGendoInfoDiv div) {
        FlexibleYearMonth riyoYM = ViewStateHolder.get(ViewStateKeys.利用年月, FlexibleYearMonth.class);
        List<KyufuJikoSakuseiResult> 給付計画自己作成List = ViewStateHolder.get(ViewStateKeys.給付計画自己作成EntityList, List.class);
        getHandler(div).init(riyoYM, 給付計画自己作成List);
        return ResponseData.of(div).respond();
    }

    /**
     * 「閉じる」ボタン上のメソッドです。
     *
     * @param div ShuruiGendoInfoDiv
     * @return ResponseData
     */
    public ResponseData<ShuruiGendoInfoDiv> onClick_btnClose(ShuruiGendoInfoDiv div) {
        return ResponseData.of(div).dialogOKClose();
    }

    private ShuruiGendoInfoHandler getHandler(ShuruiGendoInfoDiv div) {
        return new ShuruiGendoInfoHandler(div);
    }
}
