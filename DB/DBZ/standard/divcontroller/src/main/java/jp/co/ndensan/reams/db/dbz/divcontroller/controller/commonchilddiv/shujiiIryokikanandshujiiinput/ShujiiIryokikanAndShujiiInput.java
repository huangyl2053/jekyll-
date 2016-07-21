/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.shujiiIryokikanandshujiiinput;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.servicetype.ninteishinsei.NinteiShinseiCodeModel;
import jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiinput.ShujiiIryokikanAndShujiiInputResult;
import jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiinput.ShujiiIryokikanandshujiiDataPassModel;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuideDiv.TaishoMode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputHandler;
import jp.co.ndensan.reams.db.dbz.service.core.shujiiiryokikanandshujiiinput.ShujiiIryokikanAndShujiiInputFinder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 主治医医療機関&主治医入力のコントローラです。
 *
 * @reamsid_L DBZ-1300-140 chengsanyuan
 */
public class ShujiiIryokikanAndShujiiInput {

    private final ShujiiIryokikanAndShujiiInputFinder servie;

    /**
     * コンストラクタです。
     *
     */
    public ShujiiIryokikanAndShujiiInput() {
        this.servie = ShujiiIryokikanAndShujiiInputFinder.createInstance();
    }

    /**
     * 主治医医療機関コードロストフォーカスの時、画面を設定します。
     *
     * @param div 治医医療機関&主治医入力Div
     * @return ResponseData<ShujiiIryokikanAndShujiiInputDiv>
     */
    public ResponseData<ShujiiIryokikanAndShujiiInputDiv> onBlur_txtIryoKikanCode(ShujiiIryokikanAndShujiiInputDiv div) {
        RString 主治医医療機関名称 = servie.getIryoKikanMeisho(new LasdecCode(div.getHdnShichosonCode()),
                div.getTxtIryoKikanCode().getValue());
        createHandler(div).setIryoKikanName(主治医医療機関名称);
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医コードロストフォーカスの時、画面を設定します。
     *
     * @param div 治医医療機関&主治医入力Div
     * @return ResponseData<ShujiiIryokikanAndShujiiInputDiv>
     */
    public ResponseData<ShujiiIryokikanAndShujiiInputDiv> onBlur_txtShujiiCode(ShujiiIryokikanAndShujiiInputDiv div) {
        RString 主治医氏名 = servie.getShujiiName(new LasdecCode(div.getHdnShichosonCode()),
                div.getTxtIryoKikanCode().getValue(),
                div.getTxtShujiiCode().getValue());
        createHandler(div).setShujiiName(主治医氏名);
        return ResponseData.of(div).respond();
    }

    /**
     * 前回申請情報をセットします。
     *
     * @param div 治医医療機関&主治医入力Div
     * @return ResponseData<ShujiiIryokikanAndShujiiInputDiv>
     */
    public ResponseData<ShujiiIryokikanAndShujiiInputDiv> onClick_btnZenkaiIrokikanJoho(ShujiiIryokikanAndShujiiInputDiv div) {
        ShujiiIryokikanAndShujiiInputResult 前回申請情報 = servie.getZenkaiFukushaJoho(
                new ShinseishoKanriNo(div.getHdnShinseishoKanriNo()),
                new LasdecCode(div.getHdnShichosonCode()));
        createHandler(div).setZenkaiIrokikanJoho(前回申請情報);
        return ResponseData.of(div).respond();
    }

    /**
     * 入力された情報をクリアします。
     *
     * @param div 治医医療機関&主治医入力Div
     * @return ResponseData<ShujiiIryokikanAndShujiiInputDiv>
     */
    public ResponseData<ShujiiIryokikanAndShujiiInputDiv> onClick_btnClear(ShujiiIryokikanAndShujiiInputDiv div) {
        createHandler(div).initialize(new LasdecCode(div.getHdnShichosonCode()),
                new ShinseishoKanriNo(div.getHdnShinseishoKanriNo()), SubGyomuCode.EMPTY);
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医医療機関ガイドのデータを設定します。
     *
     * @param div 治医医療機関&主治医入力Div
     * @return ResponseData<ShujiiIryokikanAndShujiiInputDiv>
     */
    public ResponseData<ShujiiIryokikanAndShujiiInputDiv> onClick_btnShujiiGuide(ShujiiIryokikanAndShujiiInputDiv div) {
        ShujiiIryokikanandshujiiDataPassModel modle = new ShujiiIryokikanandshujiiDataPassModel();
        modle.set市町村コード(div.getHdnShichosonCode());
        modle.setサブ業務コード(div.getHdnSubGyomuModel());
        modle.set対象モード(new RString(TaishoMode.ShujiiMode.toString()));
        div.setHdnDataPass(DataPassingConverter.serialize(modle));
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医医療機関ガイドのデータを設定します。
     *
     * @param div 治医医療機関&主治医入力Div
     * @return ResponseData<ShujiiIryokikanAndShujiiInputDiv>
     */
    public ResponseData<ShujiiIryokikanAndShujiiInputDiv> onClick_btnIryokikanGuide(ShujiiIryokikanAndShujiiInputDiv div) {
        ShujiiIryokikanandshujiiDataPassModel modle = new ShujiiIryokikanandshujiiDataPassModel();
        modle.set市町村コード(div.getHdnShichosonCode());
        modle.setサブ業務コード(div.getHdnSubGyomuModel());
        modle.set対象モード(new RString(TaishoMode.IryoKikanMode.toString()));
        div.setHdnDataPass(DataPassingConverter.serialize(modle));
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医医療機関ガイドのデータを設定します。
     *
     * @param div 治医医療機関&主治医入力Div
     * @return ResponseData<ShujiiIryokikanAndShujiiInputDiv>
     */
    public ResponseData<ShujiiIryokikanAndShujiiInputDiv> onOKClose_btnShujiiGuide(ShujiiIryokikanAndShujiiInputDiv div) {
        ShujiiIryokikanandshujiiDataPassModel modle = DataPassingConverter.deserialize(div.getHdnDataPass(), ShujiiIryokikanandshujiiDataPassModel.class);
        div.getTxtShujiiCode().setValue(modle.get主治医コード());
        div.getTxtShujiiName().setValue(modle.get主治医氏名());
        div.getTxtIryoKikanCode().setValue(modle.get主治医医療機関コード());
        div.getTxtIryoKikanName().setValue(modle.get主治医医療機関名称());
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医医療機関ガイドのデータを設定します。
     *
     * @param div 治医医療機関&主治医入力Div
     * @return ResponseData<ShujiiIryokikanAndShujiiInputDiv>
     */
    public ResponseData<ShujiiIryokikanAndShujiiInputDiv> onOKClose_btnIryokikanGuide(ShujiiIryokikanAndShujiiInputDiv div) {
        ShujiiIryokikanandshujiiDataPassModel modle = DataPassingConverter.deserialize(div.getHdnDataPass(), ShujiiIryokikanandshujiiDataPassModel.class);
        div.getTxtIryoKikanCode().setValue(modle.get主治医医療機関コード());
        div.getTxtIryoKikanName().setValue(modle.get主治医医療機関名称());
        return ResponseData.of(div).respond();
    }

    /**
     * 主治医への連絡事項のデータを設定します。
     *
     * @param div 治医医療機関&主治医入力Div
     * @return ResponseData<ShujiiIryokikanAndShujiiInputDiv>
     */
    public ResponseData<ShujiiIryokikanAndShujiiInputDiv> onBefore_btnShujiiRenrakuJiko(ShujiiIryokikanAndShujiiInputDiv div) {
        NinteiShinseiCodeModel shinseiCodeModel = new NinteiShinseiCodeModel();
        if (!RString.isNullOrEmpty(div.getHdnShujiiRenrakuJiko())) {
            shinseiCodeModel.set連絡事項(div.getHdnShujiiRenrakuJiko());
        }
        shinseiCodeModel.set表示モード(NinteiShinseiCodeModel.HyojiMode.InputMode);
        ViewStateHolder.put(ViewStateKeys.モード, shinseiCodeModel);

        return ResponseData.of(div).respond();
    }

    /**
     * 主治医への連絡事項のデータを設定します。
     *
     * @param div 治医医療機関&主治医入力Div
     * @return ResponseData<ShujiiIryokikanAndShujiiInputDiv>
     */
    public ResponseData<ShujiiIryokikanAndShujiiInputDiv> onOKClose_btnShujiiRenrakuJiko(ShujiiIryokikanAndShujiiInputDiv div) {
        NinteiShinseiCodeModel shinseiCodeModel = ViewStateHolder.get(ViewStateKeys.モード, NinteiShinseiCodeModel.class);
        div.setHdnShujiiRenrakuJiko(shinseiCodeModel.get連絡事項());
        return ResponseData.of(div).respond();
    }

    private ShujiiIryokikanAndShujiiInputHandler createHandler(ShujiiIryokikanAndShujiiInputDiv div) {
        return new ShujiiIryokikanAndShujiiInputHandler(div);
    }
}
