/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.dbc0700011;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0700011.JutakuKaishuJizenShoninKetteiTsuchishoPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N3317 塚田 萌
 */
public class JutakuKaishuJizenShoninKetteiTsuchishoPanel {

    /**
     * panelロード時の処理です。
     *
     * @param panel 住宅改修事前申請承認決定通知書panel
     * @return response
     */
    public ResponseData<JutakuKaishuJizenShoninKetteiTsuchishoPanelDiv> onLoad(JutakuKaishuJizenShoninKetteiTsuchishoPanelDiv panel) {

        panel.getTxtHakkoDate().setValue(new RDate("20140711"));

        return ResponseData.of(panel).respond();
    }
}
