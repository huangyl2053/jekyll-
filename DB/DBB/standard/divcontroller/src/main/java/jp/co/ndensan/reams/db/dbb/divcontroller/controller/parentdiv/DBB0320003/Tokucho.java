/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320003;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaMapper;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320003.TokuChoIdoAndIraiDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320003.TokuChoKekkaDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320003.TokuchoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320003.dgTokuChoIdoAndIrai_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320003.dgTokuchoKekka_Row;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.config.ConfigKeysTokuchoHosoku;
import jp.co.ndensan.reams.db.dbz.definition.core.config.TokuchoHosokuConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.fuka.SanteiState;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.FukaNendo;
import jp.co.ndensan.reams.ue.uex.business.core.NenkinTokuchoKaifuJoho;
import jp.co.ndensan.reams.ue.uex.definition.core.KakushuKubun;
import jp.co.ndensan.reams.ue.uex.definition.core.ShoriKekka;
import jp.co.ndensan.reams.ue.uex.service.core.NenkinTokuchoKaifuJohoManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMasterNoOption;

/**
 * 賦課照会の特別徴収Divのコントローラです。
 *
 * @author N3317 塚田 萌
 */
public class Tokucho {

    private static final int NUMBER_OF_DIGIT = 3;
    private static final int INT_04 = 04;
    private static final int INT_3 = 3;

    /**
     * コントロールdivが「生成」された際の処理です。
     *
     * @param div 特別徴収Div
     * @return レスポンスデータ
     */
    public ResponseData<TokuchoDiv> onload(TokuchoDiv div) {
        return initialize(div);
    }

    /**
     * コントロールdivが「非表示」→「表示」となった際の処理です。
     *
     * @param div 特別徴収Div
     * @return レスポンスデータ
     */
    public ResponseData<TokuchoDiv> onActive(TokuchoDiv div) {
        return initialize(div);
    }

    /**
     * 初期処理です。
     *
     * @param div 特別徴収Div
     * @return レスポンスデータ
     */
    public ResponseData<TokuchoDiv> initialize(TokuchoDiv div) {

        // コントロールの値をクリアする。
        clearDiv(div);

        FukaShokaiKey key = FukaShokaiController.getFukaShokaiKeyInViewState();
        // 介護徴収方法を取得する
        ChoshuHoho model = FukaShokaiController.getChoshuHohoModelByFukaShokaiKeyWithoutRirekiNo();
        // 賦課照会コントロールキー.データ状態（仮徴収/本徴収）に応じて徴収ラジオボタンを設定しその内容を表示する。
        if (key.get算定状態() == SanteiState.仮算定) {
            setDivFor仮算定(div, model);
        } else {
            setDivFor本算定(div, model);
        }
        return createResponseData(div);
    }

    /**
     * 徴収ラジオボタンが変更された時のイベントです。
     *
     * @param div 特別徴収Div
     * @return レスポンスデータ
     */
    public ResponseData<TokuchoDiv> onChange_radChoshu(TokuchoDiv div) {

        FukaShokaiKey key = FukaShokaiController.getFukaShokaiKeyInViewState();
        ViewStateHolder.put(ViewStateKeys.賦課照会キー, key);
        // 年金保険者突合情報について、仮徴収/本徴収/翌年度のいずれかの情報を再表示する
        ChoshuHoho model = FukaShokaiController.getChoshuHohoModelByFukaShokaiKeyWithoutRirekiNo();
        if (div.getRadChoshu().getSelectedKey().equals(SanteiState.仮算定.getKey())) {
            setDivFor仮算定(div, model);
        } else if (div.getRadChoshu().getSelectedKey().equals(SanteiState.本算定.getKey())) {
            setDivFor本算定(div, model);
        } else {
            setDivFor翌年度(div, model);
        }
        return createResponseData(div);
    }

    private void setDivFor仮算定(TokuchoDiv div, ChoshuHoho model) {
        div.getRadChoshu().setSelectedKey(SanteiState.仮算定.getKey());
        div.getTxtKisoNenkinNo2().setValue(model.get仮徴収_基礎年金番号());
        div.getTxtNenkinCode2().setValue(model.get仮徴収_年金コード());
        div.getTxtKaishiYM().setValue(new FlexibleDate(build開始年月(model.get仮徴収_捕捉月(), model.get賦課年度().minusYear(1))));
        RString nenkinCode = createNenkinCode(model.get仮徴収_年金コード());
        RString nenkinCodeMeisho = CodeMasterNoOption.getCodeMeisho(SubGyomuCode.UEX分配集約公開, new CodeShubetsu("0046"), new Code(nenkinCode));
        div.getTxtTokubetsuChoshuTaishoNenkin().setValue(nenkinCode.concat(nenkinCodeMeisho));
        set年金保険者突合Div(div,
                new FukaNendo(model.get賦課年度().minusYear(1)), model.get仮徴収_基礎年金番号(), model.get仮徴収_年金コード(), model.get仮徴収_捕捉月());
        set特徴異動and依頼Div(div.getTokuChoIdoAndIrai(), model);
        set特徴結果Div(div.getTokuChoKekka(), model);
    }

    private void setDivFor本算定(TokuchoDiv div, ChoshuHoho model) {
        div.getRadChoshu().setSelectedKey(SanteiState.本算定.getKey());
        div.getTxtKisoNenkinNo2().setValue(model.get本徴収_基礎年金番号());
        div.getTxtNenkinCode2().setValue(model.get本徴収_年金コード());
        div.getTxtKaishiYM().setValue(new FlexibleDate(build開始年月(model.get本徴収_捕捉月(), model.get賦課年度())));
        RString nenkinCode = createNenkinCode(model.get本徴収_年金コード());
        RString nenkinCodeMeisho = CodeMasterNoOption.getCodeMeisho(SubGyomuCode.UEX分配集約公開, new CodeShubetsu("0046"), new Code(nenkinCode));
        div.getTxtTokubetsuChoshuTaishoNenkin().setValue(nenkinCode.concat(nenkinCodeMeisho));
        set年金保険者突合Div(div,
                new FukaNendo(model.get賦課年度()), model.get本徴収_基礎年金番号(), model.get本徴収_年金コード(), model.get本徴収_捕捉月());
        set特徴異動and依頼Div(div.getTokuChoIdoAndIrai(), model);
        set特徴結果Div(div.getTokuChoKekka(), model);
    }

    private void setDivFor翌年度(TokuchoDiv div, ChoshuHoho model) {
        // 翌年度情報に値がなく、本徴収情報に値がある 場合
        if ((model.get翌年度仮徴収_基礎年金番号() == null || model.get翌年度仮徴収_基礎年金番号().isEmpty())
                && (model.get翌年度仮徴収_年金コード() == null || model.get翌年度仮徴収_年金コード().isEmpty())
                && (model.get翌年度仮徴収_捕捉月() == null || model.get翌年度仮徴収_捕捉月().isEmpty())) {
            // 介護徴収方法．特別徴収停止事由コード=空白 のとき、翌年度選択も本徴収情報と同じ内容を画面表示する。
            if (model.get特別徴収停止事由コード() == null || model.get特別徴収停止事由コード().isEmpty()) {
                setDivFor本算定(div, model);
            }
        } else {
            div.getTxtKisoNenkinNo2().setValue(model.get翌年度仮徴収_基礎年金番号());
            div.getTxtNenkinCode2().setValue(model.get翌年度仮徴収_年金コード());
            div.getTxtKaishiYM().setValue(new FlexibleDate(build開始年月(model.get翌年度仮徴収_捕捉月(), model.get賦課年度())));
            RString nenkinCode = createNenkinCode(model.get翌年度仮徴収_年金コード());
            RString nenkinCodeMeisho = CodeMasterNoOption.getCodeMeisho(SubGyomuCode.UEX分配集約公開, new CodeShubetsu("0046"), new Code(nenkinCode));
            div.getTxtTokubetsuChoshuTaishoNenkin().setValue(nenkinCode.concat(nenkinCodeMeisho));
            set年金保険者突合Div(div,
                    new FukaNendo(model.get賦課年度()), model.get翌年度仮徴収_基礎年金番号(), model.get翌年度仮徴収_年金コード(), model.get翌年度仮徴収_捕捉月());
            set特徴異動and依頼Div(div.getTokuChoIdoAndIrai(), model);
            set特徴結果Div(div.getTokuChoKekka(), model);
        }
        div.getRadChoshu().setSelectedKey(new RString("3"));
    }

    private RString build開始年月(RString 捕捉月, FlexibleYear 年度) {
        ConfigKeysTokuchoHosoku configKey = ConfigKeysTokuchoHosoku.toValue(捕捉月);
        TokuchoHosokuConfig config = new TokuchoHosokuConfig();
        RString 開始月 = config.get(configKey, toEffectiveDate(年度));
        if (is開始月between01to08(開始月)) {
            年度 = 年度.plusYear(1);
        }
        return 年度.toDateString().concat(開始月);
    }

    private boolean is開始月between01to08(RString 開始月) {
        return 開始月.compareTo("01") >= 0 && 開始月.compareTo("08") <= 0;
    }

    private RDate toEffectiveDate(FlexibleYear 年度) {
        return new RDate(年度.getYearValue(), INT_04, 01);
    }

    /**
     * 4桁の年金コードから上3桁を切り出し、コードマスタの型にして返します。
     *
     * @param 年金コード 年金コード（4桁）
     * @return 年金コード（3桁のコードを保持するコードマスタ）
     */
    private RString createNenkinCode(RString 年金コード) {
        return (年金コード != null && 年金コード.length() >= INT_3) ? 年金コード.substring(0, NUMBER_OF_DIGIT) : RString.EMPTY;
    }

    private void set年金保険者突合Div(TokuchoDiv div, FukaNendo 賦課年度, RString 基礎年金番号, RString 年金コード, RString 捕捉月) {
        // 捕捉月 = 「02」のとき、処理年度 = 引数.処理年度 + 1 。以外、処理年度 = 引数.処理年度
        if (捕捉月.compareTo("02") == 0) {
            賦課年度 = new FukaNendo(賦課年度.value().plusYear(1));
        }
        NenkinTokuchoKaifuJohoManager manager = new NenkinTokuchoKaifuJohoManager();
        NenkinTokuchoKaifuJoho kaifuJoho = manager.get年金特徴対象者情報(
                GyomuCode.DB介護保険, 賦課年度.value(), 基礎年金番号, 年金コード, 捕捉月);
        if (kaifuJoho == null) {
            return;
        }
        div.getTxtHosokuYM().setValue(new FlexibleDate(kaifuJoho.get処理年度().toDateString().concat(捕捉月)));
        RString tokubetsuChoshuCodeMeisho = CodeMasterNoOption.getCodeMeisho(SubGyomuCode.UEX分配集約公開, new CodeShubetsu("0047"), kaifuJoho.getDT特別徴収義務者コード().value());
        div.getTxtTokuChoGimusha().setValue(kaifuJoho.getDT特別徴収義務者コード().value().value().concat(tokubetsuChoshuCodeMeisho));

        div.getNenkinHokenshaTotsugoJoho().getTxtShimeiKana().setValue(kaifuJoho.getDTカナ氏名());
        div.getNenkinHokenshaTotsugoJoho().getTxtShimeiKanji().setValue(kaifuJoho.getDT漢字氏名());
        div.getNenkinHokenshaTotsugoJoho().getTxtJushoKana().setValue(kaifuJoho.getDTカナ住所());
        div.getNenkinHokenshaTotsugoJoho().getTxtJushoKanji().setValue(kaifuJoho.getDT漢字住所());
        div.getNenkinHokenshaTotsugoJoho().getTxtSex().setValue(kaifuJoho.getDT性別().value().get性別名称());
        div.getNenkinHokenshaTotsugoJoho().getTxtBirthYMD().setValue(new FlexibleDate(kaifuJoho.getDT生年月日()).wareki().toDateString());
    }

    private void set特徴異動and依頼Div(TokuChoIdoAndIraiDiv div, ChoshuHoho model) {
        NenkinTokuchoKaifuJohoManager manager = new NenkinTokuchoKaifuJohoManager();
        List<NenkinTokuchoKaifuJoho> 年金特徴送付List = manager.get年金特徴送付情報List(
                GyomuCode.DB介護保険, model.get賦課年度(),
                model.get仮徴収_基礎年金番号(), model.get仮徴収_年金コード(),
                model.get本徴収_基礎年金番号(), model.get本徴収_年金コード(),
                model.get翌年度仮徴収_基礎年金番号(), model.get翌年度仮徴収_年金コード());

        List dataSource = new ArrayList();
        for (NenkinTokuchoKaifuJoho tokuchoKaifu : 年金特徴送付List) {
            dataSource.add(toDgTokuChoIdoAndIrai_Row(tokuchoKaifu));
        }
        div.getDgTokuChoIdoAndIrai().setDataSource(dataSource);
    }

    private void set特徴結果Div(TokuChoKekkaDiv div, ChoshuHoho model) {
        NenkinTokuchoKaifuJohoManager manager = new NenkinTokuchoKaifuJohoManager();
        List<NenkinTokuchoKaifuJoho> 年金特徴受取List = manager.get年金特徴受取情報List(
                GyomuCode.DB介護保険, model.get賦課年度(),
                model.get仮徴収_基礎年金番号(), model.get仮徴収_年金コード(),
                model.get本徴収_基礎年金番号(), model.get本徴収_年金コード());

        List dataSource = new ArrayList();
        for (NenkinTokuchoKaifuJoho tokuchoKaifu : 年金特徴受取List) {
            dataSource.add(toDgTokuchoKekka_Row(tokuchoKaifu));
        }
        div.getDgTokuchoKekka().setDataSource(dataSource);
    }

    private dgTokuChoIdoAndIrai_Row toDgTokuChoIdoAndIrai_Row(NenkinTokuchoKaifuJoho kaifuJoho) {
        KakushuKubun 各種区分 = KakushuKubun.toValue(kaifuJoho.get通知内容コード().value().get通知内容コード(), kaifuJoho.getDT各種区分());
        return new dgTokuChoIdoAndIrai_Row(
                kaifuJoho.get処理対象年月() != null ? kaifuJoho.get処理対象年月().wareki().toDateString() : RString.EMPTY,
                kaifuJoho.get通知内容コード() != null
                ? kaifuJoho.get通知内容コード().value().get通知内容コード().concat(kaifuJoho.get通知内容コード().value().get通知内容名称()) : RString.EMPTY,
                kaifuJoho.get通知内容コード() != null && kaifuJoho.getDT各種区分() != null
                ? (各種区分 != null ? 各種区分.get各種区分名称() : RString.EMPTY) : RString.EMPTY,
                kaifuJoho.getDT各種金額欄１() != null ? FukaMapper.addComma(new Decimal(kaifuJoho.getDT各種金額欄１().toString())) : RString.EMPTY,
                kaifuJoho.getDT各種金額欄２() != null ? FukaMapper.addComma(new Decimal(kaifuJoho.getDT各種金額欄２().toString())) : RString.EMPTY,
                kaifuJoho.getDT各種金額欄３() != null ? FukaMapper.addComma(new Decimal(kaifuJoho.getDT各種金額欄３().toString())) : RString.EMPTY);
    }

    private dgTokuchoKekka_Row toDgTokuchoKekka_Row(NenkinTokuchoKaifuJoho kaifuJoho) {
        KakushuKubun 各種区分 = KakushuKubun.toValue(kaifuJoho.get通知内容コード().value().get通知内容コード(), kaifuJoho.getDT各種区分());
        ShoriKekka 処理結果 = ShoriKekka.toValue(kaifuJoho.get通知内容コード().value().get通知内容コード(), kaifuJoho.getDT処理結果());
        return new dgTokuchoKekka_Row(
                kaifuJoho.get処理対象年月() != null ? kaifuJoho.get処理対象年月().wareki().toDateString() : RString.EMPTY,
                kaifuJoho.get通知内容コード() != null
                ? kaifuJoho.get通知内容コード().value().get通知内容コード().concat(kaifuJoho.get通知内容コード().value().get通知内容名称()) : RString.EMPTY,
                kaifuJoho.get通知内容コード() != null && kaifuJoho.getDT各種区分() != null
                ? (各種区分 != null ? 各種区分.get各種区分名称() : RString.EMPTY) : RString.EMPTY,
                kaifuJoho.getDT各種金額欄１() != null ? FukaMapper.addComma(new Decimal(kaifuJoho.getDT各種金額欄１().toString())) : RString.EMPTY,
                kaifuJoho.getDT各種金額欄２() != null ? FukaMapper.addComma(new Decimal(kaifuJoho.getDT各種金額欄２().toString())) : RString.EMPTY,
                kaifuJoho.getDT各種金額欄３() != null ? FukaMapper.addComma(new Decimal(kaifuJoho.getDT各種金額欄３().toString())) : RString.EMPTY,
                kaifuJoho.get通知内容コード() != null && kaifuJoho.getDT処理結果() != null
                ? (処理結果 != null ? 処理結果.get処理結果名称() : RString.EMPTY) : RString.EMPTY);
    }

    private void clearDiv(TokuchoDiv div) {
        // TODO 徴収ラジオボタンのクリア
        div.getTxtKisoNenkinNo2().clearValue();
        div.getTxtTokubetsuChoshuTaishoNenkin().clearValue();
        div.getTxtNenkinCode2().clearValue();
        div.getTxtTokuChoGimusha().clearValue();
        div.getTxtHosokuYM().clearValue();
        div.getTxtKaishiYM().clearValue();
        div.getNenkinHokenshaTotsugoJoho().getTxtShimeiKana().clearValue();
        div.getNenkinHokenshaTotsugoJoho().getTxtSex().clearValue();
        div.getNenkinHokenshaTotsugoJoho().getTxtBirthYMD().clearValue();
        div.getNenkinHokenshaTotsugoJoho().getTxtShimeiKanji().clearValue();
        div.getNenkinHokenshaTotsugoJoho().getTxtJushoKana().clearValue();
        div.getNenkinHokenshaTotsugoJoho().getTxtJushoKanji().clearValue();
        div.getTokuChoIdoAndIrai().getDgTokuChoIdoAndIrai().setDataSource(Collections.EMPTY_LIST);
        div.getTokuChoKekka().getDgTokuchoKekka().setDataSource(Collections.EMPTY_LIST);
    }

    private ResponseData<TokuchoDiv> createResponseData(TokuchoDiv div) {
        return ResponseData.of(div).respond();
    }
}
