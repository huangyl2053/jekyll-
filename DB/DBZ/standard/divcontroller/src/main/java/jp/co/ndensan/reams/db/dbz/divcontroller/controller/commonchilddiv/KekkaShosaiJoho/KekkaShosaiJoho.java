/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.KekkaShosaiJoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.kekkashosaijoho.KekkaShosaiJohoModel;
import jp.co.ndensan.reams.db.dbz.business.core.kekkashosaijoho.KekkaShosaiJohoOutModel;
import jp.co.ndensan.reams.db.dbz.business.core.kekkashosaijoho.KekkaShosaiJohoServiceShuri;
import jp.co.ndensan.reams.db.dbz.business.core.ninteiinput.NinteiInputDataPassModel;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KekkaShosaiJoho.KekkaShosaiJoho.KekkaShosaiJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KekkaShosaiJoho.KekkaShosaiJoho.KekkaShosaiJohoValidationHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.dgServiceIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.IShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.ShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 結果詳細情報画面のコントローラです。
 *
 * @reamsid_L DBZ-1320-020 zuotao
 */
public class KekkaShosaiJoho {

    private static final RString モード_喪失 = new RString("SoshitsuMode");
    private static final RString モード_職権取消入力 = new RString("ShokkenTorikeshiInputMode");
    private static final RString モード_照会 = new RString("ShokaiMode");
    private static final RString モード_入力 = new RString("InputMode");
    private static final RString モード_一部喪失 = new RString("IchibuSoshitsuMode");

    /**
     * 結果詳細情報画面初期化処理です。
     *
     * @param div 結果詳細情報画面Div
     * @return ResponseData<KekkaShosaiJohoDiv>
     */
    public ResponseData<KekkaShosaiJohoDiv> onLoad(KekkaShosaiJohoDiv div) {
        KekkaShosaiJohoModel model = DataPassingConverter.deserialize(div.getHdnKekkaShosaiJohoModel(), KekkaShosaiJohoModel.class);
        RString mode = model.getMode();
        if (モード_喪失.equals(mode)) {
            div.getCcdNinteiInput().set状態(モード_入力);
            div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.ZenbuSoshitsuMode);
            div.setMode_ShoriType(KekkaShosaiJohoDiv.ShoriType.SoshitsuMode);
        } else if (モード_職権取消入力.equals(mode)) {
            div.getCcdNinteiInput().set状態(モード_一部喪失);
            div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.TokushuTsuikaMode);
            div.setMode_ShoriType(KekkaShosaiJohoDiv.ShoriType.ShokkenTorikeshiInputMode);
        } else if (モード_照会.equals(mode)) {
            div.getCcdNinteiInput().set状態(モード_照会);
            div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.ShokaiMode);
            div.setMode_ShoriType(KekkaShosaiJohoDiv.ShoriType.ShokaiMode);
        } else if (モード_入力.equals(mode)) {
            div.getCcdNinteiInput().set状態(モード_入力);
            div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.ShokaiMode);
            div.setMode_ShoriType(KekkaShosaiJohoDiv.ShoriType.InputMode);
            NinteiInputDataPassModel passModel = new NinteiInputDataPassModel();
            passModel.setSubGyomuCode(model.getDataPassModel().getSubGyomuCode());
            passModel.set厚労省IFコード(model.getDataPassModel().get厚労省IFコード());
            passModel.set申請書管理番号(model.getDataPassModel().get申請書管理番号());
            passModel.set認定区分(new RString("1"));
            passModel.setみなし更新認定(new ArrayList<RString>());
            div.getCcdNinteiInput().initialize(passModel);
            div.getCcdShinseiSonotaJohoInput().initialize();
        }
        div.getCcdNinteiInput().initialize(model.getDataPassModel());
        div.getCcdShinseiSonotaJohoInput().initialize();
        if (!RString.isNullOrEmpty(model.getIdoJiyuCode())) {
            div.getCcdShinseiSonotaJohoInput().set異動事由(model.getIdoJiyuCode());
        }
        if (!RString.isNullOrEmpty(model.getSakujoJiyuCode())) {
            div.getCcdShinseiSonotaJohoInput().set削除事由(model.getSakujoJiyuCode());
        }
        div.getCcdShinseiSonotaJohoInput().set理由(model.getRiyu());
        div.getCcdShinseiSonotaJohoInput().set喪失日(model.getSoshitsuDay());
        div.getCcdShinseiSonotaJohoInput().set取消日(model.getTorisageDay());
        div.getCcdShinseiSonotaJohoInput().set当初認定期間From(model.getToshoNinteiKikanFrom());
        div.getCcdShinseiSonotaJohoInput().set当初認定期間To(model.getToshoNinteiKikanTo());
        div.getCcdShinseiSonotaJohoInput().set発行日１(model.getJukyuShikakuHakkoDay1());
        div.getCcdShinseiSonotaJohoInput().set発行日2(model.getJukyuShikakuHakkoDay2());
        div.getTxtShinseiKubunShinsei().setValue(model.getShinseiKubunShinsei());
        div.getTxtShinseiKubunLaw().setValue(model.getShinseiKubunLaw());
        return ResponseData.of(div).respond();
    }

    /**
     * 結果詳細情報画面登録処理です。
     *
     * @param div 結果詳細情報画面Div
     * @return ResponseData<KekkaShosaiJohoDiv>
     */
    public ResponseData<KekkaShosaiJohoDiv> onClick_btnToroku(KekkaShosaiJohoDiv div) {
        KekkaShosaiJohoModel model = DataPassingConverter.deserialize(div.getHdnKekkaShosaiJohoModel(), KekkaShosaiJohoModel.class);
        RString mode = model.getMode();
        if (モード_喪失.equals(mode) || モード_入力.equals(mode)) {
            ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
            pairs.add(createValidationHandler(div).check有効開始日());
            pairs.add(createValidationHandler(div).check有効終了日());
            pairs.add(div.getCcdNinteiInput().開始終了日前後順check());
            pairs.add(createValidationHandler(div).checkサービス区分());
            if (pairs.iterator().hasNext()) {
                return ResponseData.of(div).addValidationMessages(pairs).respond();
            }
        }
        KekkaShosaiJohoOutModel outModel = new KekkaShosaiJohoOutModel();
        outModel.set認定内容(div.getCcdNinteiInput().getNaiyo());
        List<dgServiceIchiran_Row> rowList = div.getCcdNinteiInput().getServiceRow();
        List<KekkaShosaiJohoServiceShuri> サービス類リスト = new ArrayList<>();
        for (dgServiceIchiran_Row row : rowList) {
            サービス類リスト.add(new KekkaShosaiJohoServiceShuri(row.getCode(), row.getServiceName()));
        }
        outModel.setサービス類リスト(サービス類リスト);
        IShinseiSonotaJohoInputDiv sonotaJohoInputDiv = div.getCcdShinseiSonotaJohoInput();
        outModel.set異動事由コード(sonotaJohoInputDiv.get異動事由());
        outModel.set除事由コード(sonotaJohoInputDiv.get削除事由());
        outModel.set理由(sonotaJohoInputDiv.get理由());
        outModel.set喪失日(sonotaJohoInputDiv.get喪失日());
        outModel.set取下日(sonotaJohoInputDiv.get取消日());
        outModel.set当初認定期間開始(sonotaJohoInputDiv.get当初認定期間開始());
        outModel.set当初認定期間終了(sonotaJohoInputDiv.get当初認定期間終了());
        outModel.set発行日１(sonotaJohoInputDiv.get受給資格者証発行日１());
        outModel.set発行日２(sonotaJohoInputDiv.get受給資格者証発効日２());
        outModel.set申請区分申請時(div.getTxtShinseiKubunShinsei().getValue());
        outModel.set申請区分法令(div.getTxtShinseiKubunLaw().getValue());
        div.setHdnKekkaShosaiJohoOutModel(DataPassingConverter.serialize(outModel));
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 結果詳細情報画面戻る処理です。
     *
     * @param div 結果詳細情報画面Div
     * @return ResponseData<KekkaShosaiJohoDiv>
     */
    public ResponseData<KekkaShosaiJohoDiv> onClick_btnModoru(KekkaShosaiJohoDiv div) {
        return ResponseData.of(div).respond();
    }

    private KekkaShosaiJohoValidationHandler createValidationHandler(KekkaShosaiJohoDiv div) {
        return new KekkaShosaiJohoValidationHandler(div);
    }
}
