/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.dbb0320001;

import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaMapper;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.ViewStateKeyCreator;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.FukakonkyoAndKiwariDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.FukakonkyoNengakuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.KikanDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.tblFukaKonkyoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001.tblFukakonkyoMeisaiDiv;
import jp.co.ndensan.reams.db.dbz.business.HokenryoDankai;
import jp.co.ndensan.reams.db.dbz.business.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.SanteiState;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.IViewStateValue;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.viewstate.ViewStates;
import jp.co.ndensan.reams.db.dbz.model.FukaTaishoshaKey;
import jp.co.ndensan.reams.db.dbz.model.fuka.FukaModel;
import jp.co.ndensan.reams.db.dbz.realservice.FukaManager;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 賦課根拠・期割Divのコントローラです。
 *
 * @author n3317 塚田 萌
 */
public class FukakonkyoAndKiwari {

    /**
     * 初期処理です。
     *
     * @param div 賦課根拠・期割Div
     * @return レスポンスデータ
     */
    public ResponseData<FukakonkyoAndKiwariDiv> initialize(FukakonkyoAndKiwariDiv div) {

        final FukaManager fukaFinder = new FukaManager();
        FukaTaishoshaKey fukaTaishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();

//        FukaModel model = FukaShokaiController.getFukaModelByFukaShokaiKey();
        FukaModel model = fukaFinder.find賦課直近(
                new ChoteiNendo(fukaTaishoshaKey.get調定年度()),
                new FukaNendo(fukaTaishoshaKey.get賦課年度()),
                fukaTaishoshaKey.get通知書番号()).findFirst().get();

        FukaShokaiKey key = createFukaShokaiKey(model);

        return createResponseData(setDisplay(div, model, key));
    }

    /**
     * ２回目以降処理です。
     *
     * @param div 賦課根拠・期割Div
     * @return レスポンスデータ
     */
    public ResponseData<FukakonkyoAndKiwariDiv> reLoad(FukakonkyoAndKiwariDiv div) {

        FukaModel model = FukaShokaiController.getFukaModelByFukaShokaiKey();

        FukaShokaiKey key = createFukaShokaiKey(model);

        return createResponseData(setDisplay(div, model, key));
    }

    /**
     * 賦課情報から賦課照会キーをViewStateに格納し、作成した賦課照会キーを返却します。
     *
     * @param model 賦課情報モデル
     * @return 賦課照会キー
     */
    private FukaShokaiKey createFukaShokaiKey(FukaModel model) {
        FukaShokaiKey key = ViewStateKeyCreator.createFukaShokaiKey(model, AtenaMeisho.EMPTY);
        IViewStateValue<FukaShokaiKey> value = ViewStates.access().valueAssignedToA(FukaShokaiKey.class);
        value.put(key);

        return key;
    }

    private FukakonkyoAndKiwariDiv setDisplay(FukakonkyoAndKiwariDiv div, FukaModel model, FukaShokaiKey key) {

        changeDivState(div, key.get算定状態());
        set賦課根拠(div.getTblFukakonkyoMeisai(), model);

        div.getCcdKiwarigaku().load(key.get調定年度(), key.get賦課年度(), key.get通知書番号(), key.get処理日時());

        set調定事由(div.getTblFukaKonkyo(), model);

        if (key.get算定状態() == SanteiState.本算定) {
            set賦課根拠Of本算定(div.getTblFukakonkyoMeisai(), model);
            set期間(div.getKikan(), model);
            set年額Of本算定(div.getFukakonkyoNengaku(), model);
        } else if (key.get算定状態() == SanteiState.仮算定) {
            set賦課根拠Of仮算定(div.getTblFukakonkyoMeisai(), model);
            set年額Of仮算定(div, model);
        }

        return div;
    }

    /**
     * 算定状態によって項目の表示・非表示を設定します。
     *
     * @param div 賦課根拠・期割Div
     * @param 算定状態 算定状態
     */
    private void changeDivState(FukakonkyoAndKiwariDiv div, SanteiState 算定状態) {
        boolean isHidden;

        if (算定状態 == SanteiState.本算定) {
            isHidden = false;
        } else {
            isHidden = true;
        }

        div.getLblHonninKazei().setDisplayNone(isHidden);
        div.getLblZenHokenryoDankai().setDisplayNone(!isHidden);
        div.getLblHonninKazeiValue().setDisplayNone(isHidden);
        div.getLblZenHokenryoDankaiValue().setDisplayNone(!isHidden);

        div.getLblSetaiKazei().setDisplayNone(isHidden);
        div.getLblZenHokenryoritsu().setDisplayNone(!isHidden);
        div.getLblSetaiKazeiValue().setDisplayNone(isHidden);
        div.getLblZenHokenryoritsuValue().setDisplayNone(!isHidden);

        div.getLblShotokuSum().setDisplayNone(isHidden);
        div.getLblZenNengakuHokenryo().setDisplayNone(!isHidden);
        div.getLblShotokuSumValue().setDisplayNone(isHidden);
        div.getLblZenNengakuHokenryoValue().setDisplayNone(!isHidden);

        div.getLblNenkinShunyu().setDisplayNone(isHidden);
        div.getLblHokenryoDankai().setDisplayNone(isHidden);

        div.getTxtZanteiKeisanjoHokenryoGaku().setDisplayNone(!isHidden);
        div.getTxtZanteiGemmenGaku().setDisplayNone(!isHidden);
        div.getTxtZanteiHokenryoGaku().setDisplayNone(!isHidden);

        div.getFukakonkyoNengaku().setDisplayNone(isHidden);
        div.getKikan().setDisplayNone(isHidden);
    }

    private void set賦課根拠(tblFukakonkyoMeisaiDiv div, FukaModel model) {
        div.getLblFukakijunYMD().setText(model.get賦課期日().wareki().toDateString());
        div.getLblShikakuShutokuYMD().setText(model.get資格取得日().wareki().toDateString());
        div.getLblShikakuSoshitsuYMD().setText(model.get資格喪失日().wareki().toDateString());
        div.getLblSeihoKaishiYMD().setText(model.get生保開始日().wareki().toDateString());
        div.getLblSeihoShuryoYMD().setText(model.get生保廃止日().wareki().toDateString());
        div.getLblRonenKaishiYMD().setText(model.get老年開始日().wareki().toDateString());
        div.getLblRonenShuryoYMD().setText(model.get老年廃止日().wareki().toDateString());
    }

    private void set賦課根拠Of本算定(tblFukakonkyoMeisaiDiv div, FukaModel model) {
        div.getLblHonninKazeiValue().setText(model.get課税区分().toRString());
        div.getLblSetaiKazeiValue().setText(model.get世帯課税区分().toRString());

        div.getLblShotokuSumValue().setText(FukaMapper.addComma(model.get合計所得金額()));

        div.getLblNenkinShunyuValue().setText(FukaMapper.addComma(model.get公的年金収入額()));

        div.getLblHokenryoDankaiValue().setText(
                FukaShokaiController.findHokenryoDankai(model.get賦課年度(), model.get賦課市町村コード(), model.get保険料段階())
                .edit表示用保険料段階());
    }

    private void set賦課根拠Of仮算定(tblFukakonkyoMeisaiDiv div, FukaModel model) {
        Optional<HokenryoDankai> 保険料段階 = FukaShokaiController.findZennendoHokenryoDankai(model);
        if (保険料段階.isPresent()) {
            div.getLblZenHokenryoDankaiValue().setText(保険料段階.get().edit表示用保険料段階());
            div.getLblZenHokenryoritsuValue().setText(FukaMapper.toRString(保険料段階.get().get保険料率()));
        }
        div.getLblZenNengakuHokenryoValue().setText(FukaMapper.addComma(model.get確定介護保険料_年額()));
    }

    private void set期間(KikanDiv div, FukaModel model) {

        RString 月数1 = getBetweenMonths(model.get月割開始年月1(), model.get月割終了年月1());
        HokenryoDankai 保険料段階1 = FukaShokaiController.findHokenryoDankai(model.get賦課年度(), model.get賦課市町村コード(), model.get保険料算定段階1());

        div.getLblKikan1().setText(toRange(model.get月割開始年月1(), model.get月割終了年月1()));
        div.getLblTsukiSu1().setText(月数1);
        div.getLblHokenryoDankai1().setText(保険料段階1.edit表示用保険料段階());
        div.getLblHokenryoritsu1().setText(FukaMapper.addComma(保険料段階1.get保険料率()));
        div.getLblHokenryoSansyutsu1().setText(calc保険料算出額(保険料段階1.get保険料率(), 月数1));
        div.getLblHokenryo1().setText(FukaMapper.addComma(model.get算定年額保険料1()));

        if (model.get月割開始年月2().isValid()) {
            RString 月数2 = getBetweenMonths(model.get月割開始年月2(), model.get月割終了年月2());
            HokenryoDankai 保険料段階2 = FukaShokaiController.findHokenryoDankai(model.get賦課年度(), model.get賦課市町村コード(), model.get保険料算定段階2());

            div.getLblKikan2().setText(toRange(model.get月割開始年月2(), model.get月割終了年月2()));
            div.getLblTsukiSu2().setText(月数2);
            div.getLblHokenryoDankai2().setText(保険料段階2.edit表示用保険料段階());
            div.getLblHokenryoritsu2().setText(FukaMapper.addComma(保険料段階2.get保険料率()));
            div.getLblHokenryoSansyutsu2().setText(calc保険料算出額(保険料段階2.get保険料率(), 月数2));
            div.getLblHokenryo1().setText(FukaMapper.addComma(model.get算定年額保険料1()));
        } else {
            div.getTblKikan2().setDisplayNone(true);
        }
    }

    private RString calc保険料算出額(Decimal 保険料率, RString 月数) {
        final int NUMBER_OF_MONTHS_OF_A_YEAR = 12;
        final int POINT_OF_ROUND_DOWN = 0;

        if (月数.isEmpty()) {
            return RString.EMPTY;
        }
        Decimal result = 保険料率.multiply(Integer.parseInt(月数.toString())).divide(NUMBER_OF_MONTHS_OF_A_YEAR);

        return FukaMapper.addComma(result.roundDownTo(POINT_OF_ROUND_DOWN));
    }

    private void set年額Of仮算定(FukakonkyoAndKiwariDiv div, FukaModel model) {
        div.getTxtZanteiKeisanjoHokenryoGaku().setValue(model.get減免前介護保険料_年額());
        div.getTxtZanteiGemmenGaku().setValue(model.get減免額());
        div.getTxtZanteiHokenryoGaku().setValue(model.get確定介護保険料_年額());
    }

    private void set年額Of本算定(FukakonkyoNengakuDiv div, FukaModel model) {
        div.getTxtKeisanjoNenkanHokenryoGaku().setValue(model.get減免前介護保険料_年額());
        div.getTxtGemmenGaku().setValue(model.get減免額());
        div.getTxtNenkanHokenryoGaku().setValue(model.get確定介護保険料_年額());
    }

    private void set調定事由(tblFukaKonkyoDiv div, FukaModel model) {
        div.getTxtFukashokaiChoteiJiyu1().setValue(model.get調定事由1().getRyakusho());
        if (model.get調定事由2() != null) {
            div.getTxtFukashokaiChoteiJiyu2().setValue(model.get調定事由2().getRyakusho());
        }
        if (model.get調定事由3() != null) {
            div.getTxtFukashokaiChoteiJiyu3().setValue(model.get調定事由3().getRyakusho());
        }
        if (model.get調定事由4() != null) {
            div.getTxtFukashokaiChoteiJiyu4().setValue(model.get調定事由4().getRyakusho());
        }

    }

    private RString toRange(FlexibleYearMonth from, FlexibleYearMonth to) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(from.wareki().toDateString()).append(" ～ ").append(to.wareki().toDateString());

        return builder.toRString();
    }

    /**
     * 引数の期間の月数を返します。<br/>
     * ただし、4月～3月は月数12、5月～8月は月数4を返します。
     *
     * @param from 開始月
     * @param to 終了月
     * @return 月数
     */
    private RString getBetweenMonths(FlexibleYearMonth from, FlexibleYearMonth to) {
        final int MARCH = 3;
        final int APRIL = 4;
        final int MAY = 5;
        final int AUGUST = 8;

        if (!from.isValid()) {
            return RString.EMPTY;
        }
        if (from.getMonthValue() == APRIL && to.getMonthValue() == MARCH) {
            return new RString("12");
        }
        if (from.getMonthValue() == MAY && to.getMonthValue() == AUGUST) {
            return new RString("4");
        }

        Integer source = to.getBetweenMonths(from);

        return new RString(source.toString());
    }

    private ResponseData<FukakonkyoAndKiwariDiv> createResponseData(FukakonkyoAndKiwariDiv div) {
        ResponseData<FukakonkyoAndKiwariDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}
