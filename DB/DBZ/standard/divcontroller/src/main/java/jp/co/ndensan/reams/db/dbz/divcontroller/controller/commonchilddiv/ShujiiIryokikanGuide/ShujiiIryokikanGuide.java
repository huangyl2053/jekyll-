/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.ShujiiIryokikanGuide;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiguide.ShujiiIryokikanAndShujii;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.shujiiiryokikanandshujiiguide.ShujiiIryokikanAndShujiiGuideParameter;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShujiiIryokikanGuide.ShujiiIryokikanGuide.ShujiiIryokikanGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.shujiiiryokikanGuide.ShujiiIryokikanGuideHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.shujiiiryokikanGuide.ShujiiIryokikanGuideValidationHandler;
import jp.co.ndensan.reams.db.dbz.service.core.shujiiiryokikanandshujiiguide.ShujiiIryokikanAndShujiiGuideFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 主治医医療機関ガイドのコントローラです。
 *
 * @reamsid_L DBZ-1300-130 xuyannan
 */
public class ShujiiIryokikanGuide {

    private static final RString 状況フラグ_有効 = new RString("有効");
    private final ShujiiIryokikanAndShujiiGuideFinder finder;

    /**
     * コンストラクタです。
     */
    public ShujiiIryokikanGuide() {
        finder = ShujiiIryokikanAndShujiiGuideFinder.createInstance();
    }

    /**
     * 画面内容から、主治医医療機関ガイドを反映します。
     *
     * @param div 画面情報
     * @return ResponseData<ShujiiIryokikanGuideDiv>
     */
    public ResponseData<ShujiiIryokikanGuideDiv> onLoad(ShujiiIryokikanGuideDiv div) {
        div.getHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        getHandler(div).intialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 「条件をクリアする」ボタン押下、検索条件をクリアします。
     *
     * @param div 画面情報
     * @return ResponseData<ShujiiIryokikanGuideDiv>
     */
    public ResponseData<ShujiiIryokikanGuideDiv> onClick_btnClear(ShujiiIryokikanGuideDiv div) {
        getHandler(div).btnClear();
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索する」ボタン押下、主治医医療機関＆主治医情報を検索します。
     *
     * @param div 画面情報
     * @return ResponseData<ShujiiIryokikanGuideDiv>
     */
    public ResponseData<ShujiiIryokikanGuideDiv> onClick_btnKensaku(ShujiiIryokikanGuideDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForMaxKensu();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        RString 市町村コード = div.getHokenshaList().getSelectedItem().get市町村コード().value();
        List<ShujiiIryokikanAndShujii> list = finder.search主治医医療機関情報(
                ShujiiIryokikanAndShujiiGuideParameter.createKensakuJokenParameter(
                        市町村コード,
                        SubGyomuCode.DBD介護受給.value().equals(div.getHdnDatabaseSubGyomuCode()),
                        div.getTxtIryoKikanCodeFrom().getValue(),
                        div.getTxtIryoKikanCodeTo().getValue(),
                        状況フラグ_有効.equals(div.getRadIryoKikanJokyo().getSelectedValue()),
                        div.getTxtIryoKikanName().getValue(),
                        div.getTxtIryoKikanKanaMeisho().getValue(),
                        new RString(""),
                        new RString(""),
                        true,
                        new RString(""),
                        new RString(""),
                        div.getTxtMaxKensu().getValue().intValue())).records();
        getHandler(div).setDataGrid(list);
        return ResponseData.of(div).respond();
    }

    /**
     * 検索結果一覧にて、選択ボタンを押下します。
     *
     * @param div 画面情報
     * @return ResponseData<ShujiiIryokikanGuideDiv>
     */
    public ResponseData<ShujiiIryokikanGuideDiv> onSelect(ShujiiIryokikanGuideDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForSelectbtn();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).onSelectbtn();
        return ResponseData.of(div).dialogOKClose();
    }

    private ShujiiIryokikanGuideHandler getHandler(ShujiiIryokikanGuideDiv div) {
        return new ShujiiIryokikanGuideHandler(div);
    }

    private ShujiiIryokikanGuideValidationHandler getValidationHandler(ShujiiIryokikanGuideDiv div) {
        return new ShujiiIryokikanGuideValidationHandler(div);
    }
}
