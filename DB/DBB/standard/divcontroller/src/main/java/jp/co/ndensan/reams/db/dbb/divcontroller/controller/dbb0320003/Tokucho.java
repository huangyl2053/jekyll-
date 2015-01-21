/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.dbb0320003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaMapper;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.TokuChoIdoAndIraiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.TokuChoKekkaDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.TokuchoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.dgTokuChoIdoAndIrai_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003.dgTokuchoKekka_Row;
import jp.co.ndensan.reams.db.dbz.business.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysTokuchoHosoku;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.TokuchoHosokuConfig;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.SanteiState;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.model.fuka.ChoshuHohoModel;
import jp.co.ndensan.reams.ur.urz.definition.nenkintokucho.KakushuKubun;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.NenkinCode;
import jp.co.ndensan.reams.ur.urz.model.NenkinTokuchoKaifuJohoModel;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

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

        div.getTxtKaishiYM().setDomain(new RYearMonth(build開始年月(model.get仮徴収_捕捉月(), model.get賦課年度().value().minusYear(1))));

        NenkinCode nenkinCode = createNenkinCode(model.get仮徴収_年金コード());
        div.getTxtTokubetsuChoshuTaishoNenkin().setValue(nenkinCode.getRyakusho());

        set年金保険者突合Div(div, model.get賦課年度(), model.get仮徴収_基礎年金番号(), model.get仮徴収_年金コード(), model.get仮徴収_捕捉月());
        set特徴異動and依頼Div(div.getTokuChoIdoAndIrai(), model);
        set特徴結果Div(div.getTokuChoKekka(), model);
    }

    private void setDivFor本算定(TokuchoDiv div, ChoshuHohoModel model) {
        div.getTxtKisoNenkinNo2().setValue(model.get本徴収_基礎年金番号());
        div.getTxtNenkinCode2().setValue(model.get本徴収_年金コード());

        div.getTxtKaishiYM().setDomain(new RYearMonth(build開始年月(model.get本徴収_捕捉月(), model.get賦課年度().value())));

        NenkinCode nenkinCode = createNenkinCode(model.get本徴収_年金コード());
        div.getTxtTokubetsuChoshuTaishoNenkin().setValue(nenkinCode.getRyakusho());

        set年金保険者突合Div(div, model.get賦課年度(), model.get本徴収_基礎年金番号(), model.get本徴収_年金コード(), model.get本徴収_捕捉月());
        set特徴異動and依頼Div(div.getTokuChoIdoAndIrai(), model);
        set特徴結果Div(div.getTokuChoKekka(), model);
    }

    private void setDivFor翌年度(TokuchoDiv div, ChoshuHohoModel model) {
        div.getTxtKisoNenkinNo2().setValue(model.get翌年度仮徴収_基礎年金番号());
        div.getTxtNenkinCode2().setValue(model.get翌年度仮徴収_年金コード());

        div.getTxtKaishiYM().setDomain(new RYearMonth(build開始年月(model.get翌年度仮徴収_捕捉月(), model.get賦課年度().value())));

        NenkinCode nenkinCode = createNenkinCode(model.get翌年度仮徴収_年金コード());
        div.getTxtTokubetsuChoshuTaishoNenkin().setValue(nenkinCode.getRyakusho());

        set年金保険者突合Div(div, model.get賦課年度(), model.get翌年度仮徴収_基礎年金番号(), model.get翌年度仮徴収_年金コード(), model.get翌年度仮徴収_捕捉月());
        set特徴異動and依頼Div(div.getTokuChoIdoAndIrai(), model);
        set特徴結果Div(div.getTokuChoKekka(), model);
    }

    private RString build開始年月(RString 捕捉月, FlexibleYear 年度) {
        ConfigKeysTokuchoHosoku configKey = ConfigKeysTokuchoHosoku.toValue(捕捉月);

        TokuchoHosokuConfig config = new TokuchoHosokuConfig();
        RString 開始月 = config.get(configKey, toEffectiveDate(年度));

        if (is開始月between01to08(開始月)) {
            年度.plusYear(1);
        }

        return 年度.toDateString().concat(開始月);
    }

    private boolean is開始月between01to08(RString 開始月) {
        return 開始月.compareTo("01") >= 0 && 開始月.compareTo("08") <= 0;
    }

    private RDate toEffectiveDate(FlexibleYear 年度) {
        return new RDate(年度.getYearValue(), 04, 01);
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

    private void set年金保険者突合Div(TokuchoDiv div,
            FukaNendo 賦課年度, RString 基礎年金番号, RString 年金コード, RString 捕捉月) {

        //TODO メソッド1を呼ぶ　get年金特徴対象者情報("DB",) モデル取れたてい
        NenkinTokuchoKaifuJohoModel model = null;

        div.getTxtHosokuYM().setDomain(new RYearMonth(model.get処理年度().toDateString().concat(捕捉月)));
        //TODO 特徴義務者名　回付情報から＋コードマスタ 修正がマージされればgetRyakushoが取れるはず
        div.getTxtTokuChoGimusha().setValue(model.getDT特別徴収義務者コード());

        div.getNenkinHokenshaTotsugoJoho().getTxtShimeiKana().setValue(model.getDTカナ氏名());
        div.getNenkinHokenshaTotsugoJoho().getTxtShimeiKanji().setValue(model.getDT漢字氏名());
        div.getNenkinHokenshaTotsugoJoho().getTxtJushoKana().setValue(model.getDTカナ住所());
        div.getNenkinHokenshaTotsugoJoho().getTxtJushoKanji().setValue(model.getDT漢字住所());
        div.getNenkinHokenshaTotsugoJoho().getTxtSex().setValue(model.getDT性別());
        div.getNenkinHokenshaTotsugoJoho().getTxtBirthYMD().setValue(model.getDT生年月日());
    }

    private void set特徴異動and依頼Div(TokuChoIdoAndIraiDiv div, ChoshuHohoModel model) {
        //TODO メソッド2を呼ぶ　リスト取れたてい
        List<NenkinTokuchoKaifuJohoModel> 年金特徴送付List = null;
        List dataSource = new ArrayList();

        for (NenkinTokuchoKaifuJohoModel tokuchoKaifuModel : 年金特徴送付List) {
            dataSource.add(toDgTokuChoIdoAndIrai_Row(tokuchoKaifuModel));
        }

        div.getDgTokuChoIdoAndIrai().setDataSource(dataSource);
    }

    private dgTokuChoIdoAndIrai_Row toDgTokuChoIdoAndIrai_Row(NenkinTokuchoKaifuJohoModel model) {

        return new dgTokuChoIdoAndIrai_Row(
                model.get処理対象年月().wareki().toDateString(),
                //TODO enumになってるはず
                model.get通知内容コード(),
                //TODO 通知内容コードを渡す
                KakushuKubun.search各種区分名称(model.get通知内容コード(), model.getDT各種区分()).get各種区分名称(),
                FukaMapper.addComma(new Decimal(model.getDT各種金額欄１().toString())),
                FukaMapper.addComma(new Decimal(model.getDT各種金額欄２().toString())),
                FukaMapper.addComma(new Decimal(model.getDT各種金額欄３().toString())));

    }

    private void set特徴結果Div(TokuChoKekkaDiv div, ChoshuHohoModel model) {
        //TODO メソッド3を呼ぶ　リスト取れたてい
        List<NenkinTokuchoKaifuJohoModel> 年金特徴受取List = null;
        List dataSource = new ArrayList();

        for (NenkinTokuchoKaifuJohoModel tokuchoKaifuModel : 年金特徴受取List) {
            dataSource.add(toDgTokuchoKekka_Row(tokuchoKaifuModel));
        }

        div.getDgTokuchoKekka().setDataSource(dataSource);
    }

    private dgTokuchoKekka_Row toDgTokuchoKekka_Row(NenkinTokuchoKaifuJohoModel model) {

        return new dgTokuchoKekka_Row(
                model.get処理対象年月().wareki().toDateString(),
                //TODO enumになってるはず
                model.get通知内容コード(),
                //TODO 通知内容コードを渡す
                KakushuKubun.search各種区分名称(model.get通知内容コード(), model.getDT各種区分()).get各種区分名称(),
                FukaMapper.addComma(new Decimal(model.getDT各種金額欄１().toString())),
                FukaMapper.addComma(new Decimal(model.getDT各種金額欄２().toString())),
                FukaMapper.addComma(new Decimal(model.getDT各種金額欄３().toString())),
                //TODO enumのはず
                model.getDT処理結果());
    }

    private ResponseData<TokuchoDiv> createResponseData(TokuchoDiv div) {
        ResponseData<TokuchoDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}
