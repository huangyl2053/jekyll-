/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.ShujiiIryokikanAndShujiiGuide;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiguide.ShujiiIryokikanAndShujii;
import jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiinput.ShujiiIryokikanandshujiiDataPassModel;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.shujiiiryokikanandshujiiguide.ShujiiIryokikanAndShujiiGuideParameter;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.shujiiiryokikanandshujiiguide.ShujiiIryokikanAndShujiiGuideHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.shujiiiryokikanandshujiiguide.ShujiiIryokikanAndShujiiGuideValidationHandler;
import jp.co.ndensan.reams.db.dbz.service.core.shujiiiryokikanandshujiiguide.ShujiiIryokikanAndShujiiGuideFinder;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuideDiv.TaishoMode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 主治医医療機関＆主治医ガイドのコントローラです。
 *
 * @reamsid_L DBZ-1300-130 xuyannan
 */
public class ShujiiIryokikanAndShujiiGuide {

    private static final RString 状況フラグ_有効 = new RString("有効");
    private final ShujiiIryokikanAndShujiiGuideFinder finder;

    /**
     * コンストラクタです。
     */
    public ShujiiIryokikanAndShujiiGuide() {
        finder = ShujiiIryokikanAndShujiiGuideFinder.createInstance();
    }

    /**
     * 画面内容から、主治医医療機関＆主治医ガイドを反映します。
     *
     * @param div 画面情報
     * @return ResponseData<ShujiiIryokikanAndShujiiGuideDiv>
     */
    public ResponseData<ShujiiIryokikanAndShujiiGuideDiv> onLoad(ShujiiIryokikanAndShujiiGuideDiv div) {
        div.getHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        getHandler(div).intialize();

        ShujiiIryokikanandshujiiDataPassModel dataPassModel = DataPassingConverter.deserialize(
                div.getHdnDataPass(), ShujiiIryokikanandshujiiDataPassModel.class);
        RString 市町村コード = new RString("");
        if (dataPassModel != null) {
            if (RString.isNullOrEmpty(dataPassModel.get市町村コード())) {
                市町村コード = div.getHokenshaList().getSelectedItem().get市町村コード().value();
            } else {
                市町村コード = dataPassModel.get市町村コード();
                div.getHokenshaList().setSelectedShichosonIfExist(new LasdecCode(市町村コード));
            }
            if (!RString.isNullOrEmpty(dataPassModel.get主治医医療機関コード())
                    && new RString(TaishoMode.ShujiiMode.toString()).equals(dataPassModel.get対象モード())) {
                div.getTxtIryoKikanCodeFrom().setValue(dataPassModel.get主治医医療機関コード());
                div.getTxtIryoKikanCodeTo().setValue(dataPassModel.get主治医医療機関コード());
            }
        }

        List<ShujiiIryokikanAndShujii> list = finder.search主治医医療機関_主治医情報(
                ShujiiIryokikanAndShujiiGuideParameter.createKensakuJokenParameter(
                        市町村コード,
                        SubGyomuCode.DBD介護受給.value().equals(div.getHdnDatabaseSubGyomuCode()),
                        div.getTxtIryoKikanCodeFrom().getValue(),
                        div.getTxtIryoKikanCodeTo().getValue(),
                        状況フラグ_有効.equals(div.getRadIryoKikanJokyo().getSelectedValue()),
                        div.getTxtIryoKikanName().getValue(),
                        div.getTxtIryoKikanKanaMeisho().getValue(),
                        div.getTxtShuijiiCodeFrom().getValue(),
                        div.getTxtShujiiCodeTo().getValue(),
                        状況フラグ_有効.equals(div.getRadShujiiJokyo().getSelectedValue()),
                        div.getTxtShujiiShimei().getValue(),
                        div.getTxtShujiiKanaShimei().getValue(),
                        div.getTxtMaxKensu().getValue().intValue())).records();

        getHandler(div)
                .setDataGrid(list);
        return ResponseData.of(div)
                .respond();
    }

    /**
     * 「条件をクリアする」ボタン押下、検索条件をクリアします。
     *
     * @param div 画面情報
     * @return ResponseData<ShujiiIryokikanAndShujiiGuideDiv>
     */
    public ResponseData<ShujiiIryokikanAndShujiiGuideDiv> onClick_btnClear(ShujiiIryokikanAndShujiiGuideDiv div) {
        getHandler(div).btnClear();
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索する」ボタン押下、主治医医療機関＆主治医情報を検索します。
     *
     * @param div 画面情報
     * @return ResponseData<ShujiiIryokikanAndShujiiGuideDiv>
     */
    public ResponseData<ShujiiIryokikanAndShujiiGuideDiv> onClick_btnKensaku(ShujiiIryokikanAndShujiiGuideDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForMaxKensu();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();

        }
        ShujiiIryokikanandshujiiDataPassModel dataPassModel = DataPassingConverter.deserialize(
                div.getHdnDataPass(), ShujiiIryokikanandshujiiDataPassModel.class
        );
        RString 市町村コード = new RString("");
        if (dataPassModel != null) {
            if (RString.isNullOrEmpty(dataPassModel.get市町村コード())) {
                市町村コード = div.getHokenshaList().getSelectedItem().get市町村コード().value();
            } else {
                市町村コード = dataPassModel.get市町村コード();
            }
            if (!RString.isNullOrEmpty(dataPassModel.get主治医医療機関コード())
                    && new RString(TaishoMode.ShujiiMode.toString()).equals(dataPassModel.get対象モード())) {
                div.getTxtIryoKikanCodeFrom().setValue(dataPassModel.get主治医医療機関コード());
                div.getTxtIryoKikanCodeTo().setValue(dataPassModel.get主治医医療機関コード());
            }
        }
        List<ShujiiIryokikanAndShujii> list = finder.search主治医医療機関_主治医情報(
                ShujiiIryokikanAndShujiiGuideParameter.createKensakuJokenParameter(
                        市町村コード,
                        SubGyomuCode.DBD介護受給.value().equals(div.getHdnDatabaseSubGyomuCode()),
                        div.getTxtIryoKikanCodeFrom().getValue(),
                        div.getTxtIryoKikanCodeTo().getValue(),
                        状況フラグ_有効.equals(div.getRadIryoKikanJokyo().getSelectedValue()),
                        div.getTxtIryoKikanName().getValue(),
                        div.getTxtIryoKikanKanaMeisho().getValue(),
                        div.getTxtShuijiiCodeFrom().getValue(),
                        div.getTxtShujiiCodeTo().getValue(),
                        状況フラグ_有効.equals(div.getRadShujiiJokyo().getSelectedValue()),
                        div.getTxtShujiiShimei().getValue(),
                        div.getTxtShujiiKanaShimei().getValue(),
                        div.getTxtMaxKensu().getValue().intValue())).records();

        getHandler(div)
                .setDataGrid(list);
        return ResponseData.of(div)
                .respond();
    }

    /**
     * 検索結果一覧にて、選択ボタンを押下します。
     *
     * @param div 画面情報
     * @return ResponseData<ShujiiIryokikanAndShujiiGuideDiv>
     */
    public ResponseData<ShujiiIryokikanAndShujiiGuideDiv> onSelect(ShujiiIryokikanAndShujiiGuideDiv div) {
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForSelectbtn();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();
        }
        getHandler(div).onSelectbtn();
        return ResponseData.of(div).dialogOKClose();
    }

    private ShujiiIryokikanAndShujiiGuideHandler getHandler(ShujiiIryokikanAndShujiiGuideDiv div) {
        return new ShujiiIryokikanAndShujiiGuideHandler(div);
    }

    private ShujiiIryokikanAndShujiiGuideValidationHandler getValidationHandler(ShujiiIryokikanAndShujiiGuideDiv div) {
        return new ShujiiIryokikanAndShujiiGuideValidationHandler(div);
    }
}
