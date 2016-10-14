/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv.DBC2210011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.tokubetsukyufujigyoshakannri.TokubetsuKyufuJigyoshaSearchResult;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011.DBC2210011StateName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011.TokubetsuKyufuJigyoshaKannriDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2210011.dgTokubetsuKyufuJigyoshaList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2210011.TokubetsuKyufuJigyoshaKannriHandler;
import jp.co.ndensan.reams.db.dbc.service.core.tokubetsukyufujigyoshakannri.TokubetsuKyufuJigyoshaRelateFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.CheckDigitFactory;
import jp.co.ndensan.reams.uz.uza.math.CheckDigitKind;
import jp.co.ndensan.reams.uz.uza.math.ICheckDigit;

/**
 * 画面設計_DBCMNG1002_市町村特別給付・サービス事業者管理のDivControllerです。
 *
 * @reamsid_L DBC-3430-010 miaojin
 */
public class TokubetsuKyufuJigyoshaKannri {

    /**
     * 画面初期化
     *
     * @param div TokubetsuKyufuJigyoshaKannriDiv
     * @return ResponseData<TokubetsuKyufuJigyoshaKannriDiv>
     */
    public ResponseData<TokubetsuKyufuJigyoshaKannriDiv> onLoad(TokubetsuKyufuJigyoshaKannriDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).setState(DBC2210011StateName.検索初期);
    }

    /**
     * 「Ｃ／Ｄ　Button」の押した(onClick)イベントを行う。
     *
     * @param div TokubetsuKyufuJigyoshaKannriDiv
     * @return 引数のDivを持つResponseData型
     */
    public ResponseData<TokubetsuKyufuJigyoshaKannriDiv> onClick_btnSearchCheckDigit(TokubetsuKyufuJigyoshaKannriDiv div) {
        ICheckDigit icheckgigit = CheckDigitFactory.getInstance(CheckDigitKind.Modulus10);
        getHandler(div).setモジュラス１０(icheckgigit);
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索する」の押した(onClick)イベントを行う。
     *
     * @param div TokubetsuKyufuJigyoshaKannriDiv
     * @return 引数のDivを持つResponseData型
     */
    public ResponseData<TokubetsuKyufuJigyoshaKannriDiv> onClick_btnSearch(TokubetsuKyufuJigyoshaKannriDiv div) {
        RString 県コード = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuJigyoshaSearchCode().getDdlSearchKenCode().getSelectedKey();
        RString 事業者区分 = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuJigyoshaSearchCode().getTxtSearchJigyoshaKubun().getText();
        RString 郡市コード = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuJigyoshaSearchCode().getTxtSearchGunshiCode().getText();
        RString 連番 = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuJigyoshaSearchCode().getTxtSearchRenban().getText();
        RString cd = div.getTokubetsuKyufuJigyoshaSearch().getTokubetsuKyufuJigyoshaSearchCode().getTxtSearchCheckDigit().getText();
        JigyoshaNo 事業者番号 = new JigyoshaNo(県コード.concat(事業者区分).concat(郡市コード).concat(連番).concat(cd));
        List<TokubetsuKyufuJigyoshaSearchResult> businessList = TokubetsuKyufuJigyoshaRelateFinder.createInstance().select事業者情報(事業者番号).records();
        if (businessList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象者が存在しない.getMessage());
        } else {
            getHandler(div).setサービス事業者一覧(businessList);
        }
        return ResponseData.of(div).setState(DBC2210011StateName.一覧);
    }

    /**
     * 「事業者情報を追加する」の押した(onClick)イベントを行う。
     *
     * @param div TokubetsuKyufuJigyoshaKannriDiv
     * @return 引数のDivを持つResponseData型
     */
    public ResponseData<TokubetsuKyufuJigyoshaKannriDiv> onClick_btnJigyoshaAdd(TokubetsuKyufuJigyoshaKannriDiv div) {
        getHandler(div).set項目クリア();
        getHandler(div).set事業者コード();
        getHandler(div).set追加ボタンを押した状態制御();
        return ResponseData.of(div).setState(DBC2210011StateName.詳細情報);
    }

    /**
     * 「サービス事業者一覧DataGrid.選択」の押した(onClick)イベントを行う。
     *
     * @param div TokubetsuKyufuJigyoshaKannriDiv
     * @return 引数のDivを持つResponseData型
     */
    public ResponseData<TokubetsuKyufuJigyoshaKannriDiv> onClick_btnSelect(TokubetsuKyufuJigyoshaKannriDiv div) {
        dgTokubetsuKyufuJigyoshaList_Row 選択row = div.getTokubetsuKyufuJigyoshaList().getDgTokubetsuKyufuJigyoshaList().getActiveRow();
        getHandler(div).set項目クリア();
        getHandler(div).set選択項目1_5(選択row);
        getHandler(div).set選択ボタンを押した状態制御();
        return ResponseData.of(div).setState(DBC2210011StateName.詳細情報);
    }

    /**
     * 「サービス事業者一覧DataGrid.修正」の押した(onClick)イベントを行う。
     *
     * @param div TokubetsuKyufuJigyoshaKannriDiv
     * @return 引数のDivを持つResponseData型
     */
    public ResponseData<TokubetsuKyufuJigyoshaKannriDiv> onClick_btnModify(TokubetsuKyufuJigyoshaKannriDiv div) {
        dgTokubetsuKyufuJigyoshaList_Row 選択row = div.getTokubetsuKyufuJigyoshaList().getDgTokubetsuKyufuJigyoshaList().getActiveRow();
        getHandler(div).set項目クリア();
        getHandler(div).set選択項目1_5(選択row);
        getHandler(div).set修正ボタンを押した状態制御();
        return ResponseData.of(div).setState(DBC2210011StateName.詳細情報);
    }

    /**
     * 「サービス事業者一覧DataGrid.削除」の押した(onClick)イベントを行う。
     *
     * @param div TokubetsuKyufuJigyoshaKannriDiv
     * @return 引数のDivを持つResponseData型
     */
    public ResponseData<TokubetsuKyufuJigyoshaKannriDiv> onClick_btnDelete(TokubetsuKyufuJigyoshaKannriDiv div) {
        dgTokubetsuKyufuJigyoshaList_Row 選択row = div.getTokubetsuKyufuJigyoshaList().getDgTokubetsuKyufuJigyoshaList().getActiveRow();
        getHandler(div).set項目クリア();
        getHandler(div).set選択項目1_5(選択row);
        getHandler(div).set選択ボタンを押した状態制御();
        return ResponseData.of(div).setState(DBC2210011StateName.詳細情報);
    }

    private TokubetsuKyufuJigyoshaKannriHandler getHandler(TokubetsuKyufuJigyoshaKannriDiv div) {
        return new TokubetsuKyufuJigyoshaKannriHandler(div);
    }

}
