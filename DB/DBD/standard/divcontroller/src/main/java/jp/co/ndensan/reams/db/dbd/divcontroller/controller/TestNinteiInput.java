/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.NinteiInput.NinteiInputDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.NinteiInput.dgServiceIchiran_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.TestNinteiInput.TestNinteiInputDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 共有子Div「認定情報」のテストクラスです。
 *
 * @author N8235 船山 洋介
 */
public class TestNinteiInput {

    private static final int TEMNYU_MODE = 0;
    private static final int INPUT_MODE = 1;
    private static final int TOKUSHUTSUIKA_MODE = 2;
    private static final int TOKUSHUSHUSEI_MODE = 3;
    private static final int SHOKAI_MODE = 4;
    private static final int NINTEI_MODE = 5;
    private static final int SHOKKENTSUIKA_MODE = 6;
    private static final int SHOKKENSHUSEI_MODE = 7;
    private static final int ICHIBUSOSITSU_MODE = 8;

    /**
     * 子Divのロード時の処理を行います。
     *
     * @param div TestNinteiInputDiv
     * @return 引数のDivを持つResponseData
     */
    public ResponseData<TestNinteiInputDiv> onClickBtnLoad(TestNinteiInputDiv div) {
        div.getCcdNinteiInput().intialize();
        return createResponseData(div);

    }

    /**
     * 子Divへ被保険者番号をセットします。
     *
     * @param div TestNinteiInputDiv
     * @return 引数のDivを持つResponseData
     */
    public ResponseData<TestNinteiInputDiv> onBlurTxtHihokenshaNoSet(TestNinteiInputDiv div) {
        div.getCcdNinteiInput().setHdnHihokenshaNo(div.getTxtHihokenshaNo().getValue());
        return createResponseData(div);
    }

    /**
     * 子Divへ厚労省IF識別コードをセットします。
     *
     * @param div TestNinteiInputDiv
     * @return 引数のDivを持つResponseData
     */
    public ResponseData<TestNinteiInputDiv> onBlurTxtIfCodeSet(TestNinteiInputDiv div) {
        div.getCcdNinteiInput().setHdnKoroshoIfShikibetsuCode(div.getTxtIfShikibetsuCode().getValue());
        return createResponseData(div);
    }

    /**
     * 子Divへ申請書管理番号をセットします。
     *
     * @param div TestNinteiInputDiv
     * @return 引数のDivを持つResponseData
     */
    public ResponseData<TestNinteiInputDiv> onBlurTxtShinseishoKanriNoSet(TestNinteiInputDiv div) {
        div.getCcdNinteiInput().setHdnShinseishoKanriNo(div.getTxtShinseishoKanriNo().getValue());
        return createResponseData(div);
    }

    /**
     * 子Divに設定された値をクリアーします。
     *
     * @param div TestNinteiInputDiv
     * @return 引数のDivを持つResponseData
     */
    public ResponseData<TestNinteiInputDiv> onClickBtnClear(TestNinteiInputDiv div) {
        div.getCcdNinteiInput().clear();
        div.getCcdNinteiInput().setサービス一覧(new ArrayList<dgServiceIchiran_Row>());
        return createResponseData(div);

    }

    /**
     * 子Divにモードpを設定します。
     *
     * @param div TestNinteiInputDiv
     * @return 引数のDivを持つResponseData
     */
    public ResponseData<TestNinteiInputDiv> onChangeRadModeSet(TestNinteiInputDiv div) {
        switch (div.getRadModeSet().getSelectedIndex()) {
            case TEMNYU_MODE:
                div.getCcdNinteiInput().setMode_ShoriType(NinteiInputDiv.ShoriType.TemnyuMode);
                break;

            case INPUT_MODE:
                div.getCcdNinteiInput().setMode_ShoriType(NinteiInputDiv.ShoriType.InputMode);
                break;

            case TOKUSHUTSUIKA_MODE:
                div.getCcdNinteiInput().setMode_ShoriType(NinteiInputDiv.ShoriType.TokushuTsuikaMode);
                break;

            case TOKUSHUSHUSEI_MODE:
                div.getCcdNinteiInput().setMode_ShoriType(NinteiInputDiv.ShoriType.TokushuShuseiMode);
                break;

            case SHOKAI_MODE:
                div.getCcdNinteiInput().setMode_ShoriType(NinteiInputDiv.ShoriType.ShokaiMode);
                break;

            case NINTEI_MODE:
                div.getCcdNinteiInput().setMode_ShoriType(NinteiInputDiv.ShoriType.NinteiMode);
                break;

            case SHOKKENTSUIKA_MODE:
                div.getCcdNinteiInput().setMode_ShoriType(NinteiInputDiv.ShoriType.ShokkenTsuikaMode);
                break;

            case SHOKKENSHUSEI_MODE:
                div.getCcdNinteiInput().setMode_ShoriType(NinteiInputDiv.ShoriType.ShokkenShuseiMode);
                break;

            case ICHIBUSOSITSU_MODE:
                div.getCcdNinteiInput().setMode_ShoriType(NinteiInputDiv.ShoriType.IchibuSoshitsuMode);
                break;

            default:
        }

        return createResponseData(div);
    }

    private ResponseData<TestNinteiInputDiv> createResponseData(TestNinteiInputDiv div) {
        ResponseData<TestNinteiInputDiv> responseData = new ResponseData<>();
        responseData.data = div;
        return responseData;
    }
}
