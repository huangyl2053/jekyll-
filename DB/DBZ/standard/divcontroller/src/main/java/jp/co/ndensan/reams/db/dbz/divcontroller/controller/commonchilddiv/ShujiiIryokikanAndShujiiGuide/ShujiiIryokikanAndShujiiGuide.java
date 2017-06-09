/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.ShujiiIryokikanAndShujiiGuide;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.HokenshaDDLPattem;
import jp.co.ndensan.reams.db.dbz.business.config.FourMasterConfig;
import jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiguide.ShujiiIryokikanAndShujii;
import jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiinput.ShujiiIryokikanandshujiiDataPassModel;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.shujiiiryokikanandshujiiguide.ShujiiIryokikanAndShujiiGuideParameter;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.shujiiiryokikanandshujiiguide.ShujiiIryokikanAndShujiiGuideHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.shujiiiryokikanandshujiiguide.ShujiiIryokikanAndShujiiGuideValidationHandler;
import jp.co.ndensan.reams.db.dbz.service.core.shujiiiryokikanandshujiiguide.ShujiiIryokikanAndShujiiGuideFinder;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuideDiv.TaishoMode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
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
    private static final RString 状況フラグ無効可 = new RString("状況フラグ無効可");

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
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        div.getHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        getHandler(div).intialize();

        ShujiiIryokikanandshujiiDataPassModel dataPassModel = DataPassingConverter.deserialize(
                div.getHdnDataPass(), ShujiiIryokikanandshujiiDataPassModel.class);
        if (dataPassModel != null) {
            if (new FourMasterConfig().get管理方法().is構成市町村ごと()) {
                if (!RString.isNullOrEmpty(dataPassModel.get市町村コード())) {
                    LasdecCode 市町村コード = new LasdecCode(dataPassModel.get市町村コード());
                    div.getHokenshaList().loadHokenshaList(GyomuBunrui.介護認定, 市町村コード);
                }
            } else {
                div.getHokenshaList().setDisplayNone(true);
            }
            div.getTxtIryoKikanCodeFrom().setValue(RString.EMPTY);
            div.getTxtIryoKikanCodeTo().setValue(RString.EMPTY);
            div.getTxtIryoKikanName().setValue(RString.EMPTY);
            if (dataPassModel.get対象モード().equals(new RString(TaishoMode.ShujiiMode.toString()))) {
                div.getTxtIryoKikanCodeFrom().setValue(dataPassModel.get主治医医療機関コード() != null ? dataPassModel.get主治医医療機関コード() : RString.EMPTY);
                div.getTxtIryoKikanCodeTo().setValue(dataPassModel.get主治医医療機関コード() != null ? dataPassModel.get主治医医療機関コード() : RString.EMPTY);
                div.getTxtIryoKikanName().setValue(dataPassModel.get主治医医療機関名称() != null ? dataPassModel.get主治医医療機関名称() : RString.EMPTY);
            }

            if (!RString.isNullOrEmpty(div.getHdnCanJokyoMuko())) {
                if (状況フラグ無効可.equals(div.getHdnCanJokyoMuko())) {
                    div.getRadIryoKikanJokyo().setDisabled(false);
                    div.getRadShujiiJokyo().setDisabled(false);
                }
            }
            search主治医医療機関and主治医(div, dataPassModel, dataPassModel.get市町村コード());
        }
        return ResponseData.of(div).respond();
    }

    private ResponseData<ShujiiIryokikanAndShujiiGuideDiv> search主治医医療機関and主治医(ShujiiIryokikanAndShujiiGuideDiv div, ShujiiIryokikanandshujiiDataPassModel dataPassModel, RString 市町村コード) {
        List<ShujiiIryokikanAndShujii> list = new ArrayList<>();
        ShujiiIryokikanAndShujiiGuideParameter parameter = getParameter(div, 市町村コード);
        if (dataPassModel.get対象モード().toString().equals(TaishoMode.IryoKikanMode.name())) {
            list = finder.search主治医医療機関情報(parameter).records();
        }
        if (dataPassModel.get対象モード().toString().equals(TaishoMode.ShujiiMode.name())) {
            list = finder.search主治医医療機関_主治医情報(parameter).records();
        }
        if (!list.isEmpty()) {
            getHandler(div).setDataGrid(list, dataPassModel.get対象モード());
        } else {
            div.getDgKensakuKekkaIchiran().clearSource();
            return ResponseData.of(div).addMessage(UrInformationMessages.該当データなし.getMessage()).respond();
        }
        return ResponseData.of(div).respond();
    }

    private ShujiiIryokikanAndShujiiGuideParameter getParameter(ShujiiIryokikanAndShujiiGuideDiv div, RString 市町村コード) {
        return ShujiiIryokikanAndShujiiGuideParameter.createKensakuJokenParameter(
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
                div.getTxtMaxKensu().getValue().intValue());
    }

    /**
     * 「条件をクリアする」ボタン押下、検索条件をクリアします。
     *
     * @param div 画面情報
     * @return ResponseData<ShujiiIryokikanAndShujiiGuideDiv>
     */
    public ResponseData<ShujiiIryokikanAndShujiiGuideDiv> onClick_btnClear(ShujiiIryokikanAndShujiiGuideDiv div) {
        getHandler(div).btnClear();
        ShujiiIryokikanandshujiiDataPassModel dataPassModel = DataPassingConverter.deserialize(
                div.getHdnDataPass(), ShujiiIryokikanandshujiiDataPassModel.class);
        if (dataPassModel != null && !RString.isNullOrEmpty(dataPassModel.get市町村コード())) {
            div.getHokenshaList().setSelectedShichosonIfExist(new LasdecCode(dataPassModel.get市町村コード()));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索する」ボタン押下、主治医医療機関＆主治医情報を検索します。
     *
     * @param div 画面情報
     * @return ResponseData<ShujiiIryokikanAndShujiiGuideDiv>
     */
    public ResponseData<ShujiiIryokikanAndShujiiGuideDiv> onClick_btnKensaku(ShujiiIryokikanAndShujiiGuideDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).respond();
        }
        ValidationMessageControlPairs validPairs = getValidationHandler(div).validateForMaxKensu();
        if (validPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validPairs).respond();

        }
        ShujiiIryokikanandshujiiDataPassModel dataPassModel = DataPassingConverter.deserialize(
                div.getHdnDataPass(), ShujiiIryokikanandshujiiDataPassModel.class
        );

        if (dataPassModel != null) {
            RString 市町村コード = div.getHokenshaList().isDisplayNone()
                    ? RString.EMPTY
                    : div.getHokenshaList().getSelectedItem().get市町村コード().value();
            search主治医医療機関and主治医(div, dataPassModel, 市町村コード);
        }
        return ResponseData.of(div).respond();
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
