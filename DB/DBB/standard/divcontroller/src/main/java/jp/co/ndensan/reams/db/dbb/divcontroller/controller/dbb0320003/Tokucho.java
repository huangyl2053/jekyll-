/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.dbb0320003;

import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaMapper;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.TokuchoDiv;
import jp.co.ndensan.reams.db.dbz.business.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.SanteiState;
import jp.co.ndensan.reams.db.dbz.model.fuka.ChoshuHohoModel;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.NenkinCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 賦課照会の特別徴収Divのコントローラです。
 *
 * @author N3317 塚田 萌
 */
public class Tokucho {

    /**
     * 特別徴収Divの初期処理です。
     *
     * @param div 特別徴収Div
     * @return レスポンスデータ
     */
    public ResponseData<TokuchoDiv> initialize(TokuchoDiv div) {

        FukaShokaiKey key = FukaShokaiController.getFukaShokaiKeyInViewState();
        ChoshuHohoModel model = FukaShokaiController.getChoshuHohoModelByFukaShokaiKey();

        if (key.get算定状態() == SanteiState.仮算定) {
            setDivFor仮算定(div, model);
        } else {
            setDivFor本算定(div, model);
        }
        return createResponseData(div);
    }

    /**
     * 算定状態ラジオボタンが変更された時のイベントです。
     *
     * @param div 特別徴収Div
     * @return レスポンスデータ
     */
    public ResponseData<TokuchoDiv> onChenge_radChoshu(TokuchoDiv div) {

        ChoshuHohoModel model = FukaShokaiController.getChoshuHohoModelByFukaShokaiKey();

        if (div.getRadChoshu().getSelectedKey().equals(SanteiState.仮算定.getKey())) {
            setDivFor仮算定(div, model);
        } else if (div.getRadChoshu().getSelectedKey().equals(SanteiState.本算定.getKey())) {
            setDivFor本算定(div, model);
        } else {
            setDivFor翌年度(div, model);
        }

        return createResponseData(div);
    }

    private void setDivFor仮算定(TokuchoDiv div, ChoshuHohoModel model) {
        div.getTxtKisoNenkinNo2().setValue(model.get仮徴収_基礎年金番号());
        div.getTxtNenkinCode2().setValue(model.get仮徴収_年金コード());
        //TODO 取得した特徴回付の処理年度＋捕捉月
//        div.getTxtHosokuYM().setDomain(FukaMapper.toRYearMonth(model.get仮徴収_捕捉月()));
//TODO コンフィグから取得
//        div.getTxtKaishiYM().setDomain();

        NenkinCode nenkinCode = createNenkinCode(model.get仮徴収_年金コード());
        div.getTxtTokubetsuChoshuTaishoNenkin().setValue(nenkinCode.getRyakusho());

        //TODO 回付情報から＋コードマスタ
//        div.getTxtTokuChoGimusha().setValue(model);
        set年金特徴回付情報(div, model.get仮徴収_基礎年金番号(), model.get仮徴収_年金コード(), model.get仮徴収_捕捉月());
    }

    private void setDivFor本算定(TokuchoDiv div, ChoshuHohoModel model) {
        div.getTxtKisoNenkinNo2().setValue(model.get本徴収_基礎年金番号());
        div.getTxtNenkinCode2().setValue(model.get本徴収_年金コード());
        //TODO 取得した特徴回付の処理年度＋捕捉月
//        div.getTxtHosokuYM().setDomain(FukaMapper.toRYearMonth(model.get本徴収_捕捉月()));
//TODO コンフィグから取得
//        div.getTxtKaishiYM().setDomain();

        NenkinCode nenkinCode = createNenkinCode(model.get本徴収_年金コード());
        div.getTxtTokubetsuChoshuTaishoNenkin().setValue(nenkinCode.getRyakusho());

        //TODO 回付情報から＋コードマスタ
//        div.getTxtTokuChoGimusha().setValue(model);
        set年金特徴回付情報(div, model.get本徴収_基礎年金番号(), model.get本徴収_年金コード(), model.get本徴収_捕捉月());
    }

    private void setDivFor翌年度(TokuchoDiv div, ChoshuHohoModel model) {
        div.getTxtKisoNenkinNo2().setValue(model.get翌年度仮徴収_基礎年金番号());
        div.getTxtNenkinCode2().setValue(model.get翌年度仮徴収_年金コード());
        //TODO 取得した特徴回付の処理年度＋捕捉月
//        div.getTxtHosokuYM().setDomain(FukaMapper.toRYearMonth(model.get翌年度仮徴収_捕捉月()));
//TODO コンフィグから取得
//        div.getTxtKaishiYM().setDomain();

        NenkinCode nenkinCode = createNenkinCode(model.get翌年度仮徴収_年金コード());
        div.getTxtTokubetsuChoshuTaishoNenkin().setValue(nenkinCode.getRyakusho());

        //TODO 回付情報から＋コードマスタ
//        div.getTxtTokuChoGimusha().setValue(model);
        set年金特徴回付情報(div, model.get翌年度仮徴収_基礎年金番号(), model.get翌年度仮徴収_年金コード(), model.get翌年度仮徴収_捕捉月());
    }

    /**
     * 4桁の年金コードから上3桁を切り出し、コードマスタの型にして返します。
     *
     * @param 年金コード 年金コード（4桁）
     * @return 年金コード（3桁のコードを保持するコードマスタ）
     */
    private NenkinCode createNenkinCode(RString 年金コード) {
        final int NUMBER_OF_DIGIT = 3;
        RString 年金コード上3桁 = 年金コード.substring(0, NUMBER_OF_DIGIT);

        return new NenkinCode(年金コード上3桁);
    }

    private void set年金特徴回付情報(TokuchoDiv div, RString 基礎年金番号, RString 年金コード, RString 捕捉月) {
        //TODO 保留　各メソッド（仮、本、翌年度）からキーを渡すので、ここではキーを使ってモデル取得＋セットすればよい

//    set年金保険者突合Div(div.getNenkinHokenshaTotsugoJoho());
//    set特徴異動and依頼Div(div.getTokuChoIdoAndIrai());
//    set特徴結果Div(div.getTokuChoKekka());
    }

//       private void set年金保険者突合Div(NenkinHokenshaTotsugoJohoDiv div) {
//
//        div.getTxtShimeiKana().setValue(cg.getAsRString("氏名カナ"));
//        div.getTxtShimeiKanji().setValue(cg.getAsRString("氏名漢字"));
//        div.getTxtJushoKana().setValue(cg.getAsRString("住所カナ"));
//        div.getTxtJushoKanji().setValue(cg.getAsRString("住所漢字"));
//        div.getTxtSex().setValue(cg.getAsRString("性別"));
//        div.getTxtBirthYMD().setValue(cg.getAsRString("生年月日"));
//    }
//    /**
//     * 異動・依頼DataGridに値をセット
//     *
//     * @param div
//     * @param formatData
//     */
//    private void set特徴異動and依頼Div(TokuChoIdoAndIraiDiv div) {
//        List dataGridAll = new ArrayList();
//
//        for (int i = 0; i < formatData.size(); i++) {
//            List dataGrid = (List) formatData.get(i);
//            dgTokuChoIdoAndIrai_Row row = createRowTokuchoIdoAndIrai(dataGrid);
//
//            dataGridAll.add(row);
//        }
//
//        DataGrid<dgTokuChoIdoAndIrai_Row> grid = div.getTokuChoIdoAndIrai().getDgTokuChoIdoAndIrai();
//        grid.setDataSource(dataGridAll);
//    }
//
//    /**
//     * 異動・依頼DataGridの行を生成
//     *
//     * @param div
//     * @param dataGrid
//     * @return
//     */
//    private dgTokuChoIdoAndIrai_Row createRowTokuchoIdoAndIrai(List dataGrid) {
//        dgTokuChoIdoAndIrai_Row row
//                = new dgTokuChoIdoAndIrai_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
//
//        row.setTxtSofuYM((RString) dataGrid.get(1));
//        row.setTxtTsuchiNaiyo((RString) dataGrid.get(2));
//        row.setTxtKakushuKbn((RString) dataGrid.get(3));
//        row.setTxtKakushuKingaku1((RString) dataGrid.get(4));
//        row.setTxtKakushuKingaku2((RString) dataGrid.get(5));
//        row.setTxtKakushuKingaku3((RString) dataGrid.get(6));
//
//        return row;
//    }
//
//    /**
//     * 特徴結果DataGridをロード
//     *
//     * @param div
//     * @param formatData
//     */
//    private void set特徴結果Div(TokuChoKekkaDiv div, List formatData) {
//        List dataGridAll = new ArrayList();
//
//        for (int i = 0; i < formatData.size(); i++) {
//            List dataGrid = (List) formatData.get(i);
//            dgTokuchoKekka_Row row = createRowTokuchoResult(dataGrid);
//
//            dataGridAll.add(row);
//        }
//
//        DataGrid<dgTokuchoKekka_Row> grid = div.getTokuChoKekka().getDgTokuchoKekka();
//        grid.setDataSource(dataGridAll);
//    }
//
//    /**
//     * 特徴結果DataGridの行を生成
//     *
//     * @param dataGrid
//     * @return
//     */
//    private dgTokuchoKekka_Row createRowTokuchoResult(List dataGrid) {
//        dgTokuchoKekka_Row row
//                = new dgTokuchoKekka_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
//
//        if ((RString) dataGrid.get(0) != null) {
//            row.setTxtUketoriYM((RString) dataGrid.get(0));
//        }
//        if ((RString) dataGrid.get(1) != null) {
//            row.setTxtTsuchiNaiyo((RString) dataGrid.get(1));
//        }
//        if ((RString) dataGrid.get(2) != null) {
//            row.setTxtKakushuKbn((RString) dataGrid.get(2));
//        }
//        if ((RString) dataGrid.get(3) != null) {
//            row.setTxtKakushuKingaku1((RString) dataGrid.get(3));
//        }
//        if ((RString) dataGrid.get(4) != null) {
//            row.setTxtKakushuKingaku2((RString) dataGrid.get(4));
//        }
//        if ((RString) dataGrid.get(5) != null) {
//            row.setTxtKakushuKingaku3((RString) dataGrid.get(5));
//        }
//        if ((RString) dataGrid.get(6) != null) {
//            row.setTxtShoriKekka((RString) dataGrid.get(6));
//        }
//
//        return row;
//    }
    private ResponseData<TokuchoDiv> createResponseData(TokuchoDiv div) {
        ResponseData<TokuchoDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}
