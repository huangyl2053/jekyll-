/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0320001;

import jp.co.ndensan.reams.db.dbb.business.core.Kiwarigaku;
import jp.co.ndensan.reams.db.dbb.business.core.basic.Fuka;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.business.core.viewstate.FukaShokaiKey;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaMapper;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.ViewStateKeyCreator;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.FukaShokaiControlDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.FukakonkyoAndKiwariDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.FukakonkyoNengakuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.KikanDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.tblFukaKonkyoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320001.tblFukakonkyoMeisaiDiv;
import jp.co.ndensan.reams.db.dbb.service.core.FukaMiscManager;
import jp.co.ndensan.reams.db.dbb.service.core.basic.FukaManager;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.db.dbb.service.core.relate.KiwarigakuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.fuka.SanteiState;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 賦課根拠・期割Div, コントローラDivへデータを表示します。
 */
public class FukakonkyoAndKiwariPresenter {

    private static final int MARCH = 3;
    private static final int APRIL = 4;
    private static final int MAY = 5;
    private static final int AUGUST = 8;
    private static final int POINT_OF_ROUND_DOWN = 0;
    private static final int NUMBER_OF_MONTHS_OF_A_YEAR = 12;
    private final KiwarigakuManager manager;
    private final HokenryoDankaiSettings 保険料段階取得;
    private final FukaShokaiControlDiv controlDiv;
    private final FukakonkyoAndKiwariDiv kiwariDiv;

    /**
     * 指定の賦課根拠・期割Div, コントローラDivへデータを表示するインスタンスを生成します。
     *
     * @param controlDiv コントローラDiv
     * @param kiwariDiv 賦課根拠・期割Div
     */
    public FukakonkyoAndKiwariPresenter(FukaShokaiControlDiv controlDiv, FukakonkyoAndKiwariDiv kiwariDiv) {
        this.controlDiv = controlDiv;
        this.kiwariDiv = kiwariDiv;
        this.保険料段階取得 = HokenryoDankaiSettings.createInstance();
        this.manager = new KiwarigakuManager();
    }

    /**
     * 指定の{@link FukaTaishoshaKey}に該当する賦課を画面へ表示します。
     *
     * @param taishoshaKey {@link FukaTaishoshaKey}
     */
    public FukaShokaiKey set賦課(FukaTaishoshaKey taishoshaKey) {
        final FukaMiscManager fukaManager = new FukaMiscManager();
        Fuka model = fukaManager.find賦課直近(
                taishoshaKey.get調定年度(),
                taishoshaKey.get賦課年度(),
                taishoshaKey.get通知書番号()).findFirst().orElse(null);
        return set賦課Nullable(model);
    }

    /**
     * 指定の賦課履歴を画面へ設定します。{@code null}が指定された場合は、何も表示されません。
     *
     * @param model 賦課履歴
     */
    public FukaShokaiKey set賦課Nullable(Fuka model) {
        FukaShokaiKey key = model == null ? FukaShokaiKey.EMPTY : createFukaShokaiKey(model);
        if (model != null) {
            setDisplay(this.kiwariDiv, model, key);
        }
        setFukaShokaiControlToShokaiKey(this.controlDiv, key);
        return key;
    }

    private static FukaShokaiKey createFukaShokaiKey(Fuka model) {
        FukaShokaiKey key = ViewStateKeyCreator.createFukaShokaiKey(model, AtenaMeisho.EMPTY);
        ViewStateHolder.put(ViewStateKeys.賦課照会キー, key);
        return key;
    }

    private void setDisplay(FukakonkyoAndKiwariDiv div, Fuka model, FukaShokaiKey key) {
        div.getLblNenkinShunyuValue().setText(RString.EMPTY);
        div.getLblHokenryoDankaiValue().setText(RString.EMPTY);

        changeDivState(div, key.get算定状態());
        set賦課根拠(div.getTblFukakonkyoMeisai(), model);

        div.getCcdKiwarigaku().load(key.get調定年度(), key.get賦課年度(), key.get通知書番号(), new Decimal(key.get履歴番号()));

        set調定事由(div.getTblFukaKonkyo(), model);

        if (key.get算定状態() == SanteiState.本算定) {
            set賦課根拠Of本算定(div.getTblFukakonkyoMeisai(), model);
            set期間(div.getKikan(), model);
            set年額Of本算定(div.getFukakonkyoNengaku(), model);
        } else if (key.get算定状態() == SanteiState.仮算定) {
            set賦課根拠Of仮算定(div.getTblFukakonkyoMeisai(), model);
            set年額Of仮算定(div, model);
        }
    }

    private static void changeDivState(FukakonkyoAndKiwariDiv div, SanteiState 算定状態) {
        boolean isHidden = 算定状態 != SanteiState.本算定;

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

    private static void set賦課根拠(tblFukakonkyoMeisaiDiv div, Fuka model) {
        div.getLblFukakijunYMD().setText(model.get賦課期日().wareki().toDateString());
        div.getLblShikakuShutokuYMD().setText(model.get資格取得日().wareki().toDateString());
        div.getLblShikakuSoshitsuYMD().setText(model.get資格喪失日().wareki().toDateString());
        div.getLblSeihoKaishiYMD().setText(model.get生保開始日().wareki().toDateString());
        div.getLblSeihoShuryoYMD().setText(model.get生保廃止日().wareki().toDateString());
        div.getLblRonenKaishiYMD().setText(model.get老年開始日().wareki().toDateString());
        div.getLblRonenShuryoYMD().setText(model.get老年廃止日().wareki().toDateString());
    }

    private void set賦課根拠Of本算定(tblFukakonkyoMeisaiDiv div, Fuka model) {
        div.getLblHonninKazeiValue().setText(model.get課税区分名称());
        div.getLblSetaiKazeiValue().setText(model.get世帯課税区分名称());

        div.getLblShotokuSumValue().setText(FukaMapper.addComma(model.get合計所得金額()));

        div.getLblNenkinShunyuValue().setText(FukaMapper.addComma(model.get公的年金収入額()));

        div.getLblHokenryoDankaiValue().setText(保険料段階取得.get保険料段階ListIn(model.get賦課年度())
                .getBy段階区分(get保険料算定段階(model)).get表記());
    }

    private void set賦課根拠Of仮算定(tblFukakonkyoMeisaiDiv div, Fuka model) {
        FlexibleYear 前年度 = model.get賦課年度().minusYear(1);
        Fuka 前年度賦課 = new FukaManager().get賦課年度最新賦課From被保険者番号(前年度, model.get被保険者番号());
        if (前年度賦課 == null) {
            return;
        }
        div.getLblZenNengakuHokenryoValue().setText(FukaMapper.addComma(前年度賦課.get減免前介護保険料_年額()));

        HokenryoDankai 前年度保険料段階 = 保険料段階取得.get保険料段階ListIn(前年度)
                .getBy段階区分(前年度賦課.get保険料算定段階());
        div.getLblZenHokenryoDankaiValue().setText(前年度保険料段階.get表記());
        div.getLblZenHokenryoritsuValue().setText(FukaMapper.addComma(前年度保険料段階.get保険料率()));
    }

    private void set期間(KikanDiv div, Fuka model) {

        RString 月数1 = getBetweenMonths(model.get月割開始年月1(), model.get月割終了年月1());
        HokenryoDankai 保険料段階1 = 保険料段階取得.get保険料段階ListIn(model.get賦課年度())
                .getBy段階区分(model.get保険料算定段階1());
        div.getLblKikan1().setText(toRange(model.get月割開始年月1(), model.get月割終了年月1()));
        div.getLblTsukiSu1().setText(月数1);
        div.getLblHokenryoDankai1().setText(保険料段階1.get表記());
        div.getLblHokenryoritsu1().setText(FukaMapper.addComma(model.get算定年額保険料1()));
        div.getLblHokenryoSansyutsu1().setText(calc保険料算出額(model.get算定年額保険料1(), 月数1));

        if (model.get月割開始年月2().isValid()) {
            RString 月数2 = getBetweenMonths(model.get月割開始年月2(), model.get月割終了年月2());
            HokenryoDankai 保険料段階2 = 保険料段階取得.get保険料段階ListIn(model.get賦課年度())
                    .getBy段階区分(model.get保険料算定段階2());

            div.getLblKikan2().setText(toRange(model.get月割開始年月2(), model.get月割終了年月2()));
            div.getLblTsukiSu2().setText(月数2);
            div.getLblHokenryoDankai2().setText(保険料段階2.get表記());
            div.getLblHokenryoritsu2().setText(FukaMapper.addComma(model.get算定年額保険料2()));
            div.getLblHokenryoSansyutsu2().setText(calc保険料算出額(model.get算定年額保険料2(), 月数2));
        } else {
            div.getTblKikan2().setDisplayNone(true);
        }
    }

    private static RString calc保険料算出額(Decimal 保険料率, RString 月数) {
        if (月数.isEmpty()) {
            return RString.EMPTY;
        }
        Decimal result = 保険料率.multiply(Integer.parseInt(月数.toString())).divide(NUMBER_OF_MONTHS_OF_A_YEAR);

        return FukaMapper.addComma(result.roundHalfUpTo(POINT_OF_ROUND_DOWN));
    }

    private void set年額Of仮算定(FukakonkyoAndKiwariDiv div, Fuka model) {

        Decimal 徴収額合計 = get徴収額合計(model.get調定年度(), model.get賦課年度(), model.get通知書番号(), model.get履歴番号());
        div.getTxtZanteiKeisanjoHokenryoGaku().setValue(徴収額合計.add(model.get減免額()));
        div.getTxtZanteiGemmenGaku().setValue(model.get減免額());
        div.getTxtZanteiHokenryoGaku().setValue(徴収額合計);
    }

    private Decimal get徴収額合計(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号, int 履歴番号) {
        Kiwarigaku kiwari = manager.load期割額(調定年度, 賦課年度, 通知書番号, 履歴番号).get();
        return kiwari.get普徴期別額合計().add(kiwari.get特徴期別額合計());
    }

    private static void set年額Of本算定(FukakonkyoNengakuDiv div, Fuka model) {
        div.getTxtKeisanjoNenkanHokenryoGaku().setValue(model.get減免前介護保険料_年額());
        div.getTxtGemmenGaku().setValue(model.get減免額());
        div.getTxtNenkanHokenryoGaku().setValue(model.get確定介護保険料_年額());
    }

    private static void set調定事由(tblFukaKonkyoDiv div, Fuka model) {
        if (model.get調定事由1() != null) {
            div.getTxtFukashokaiChoteiJiyu1().setValue(model.get調定事由1().getRyakusho());
        } else {
            div.getTxtFukashokaiChoteiJiyu1().setValue(RString.EMPTY);
        }
        if (model.get調定事由2() != null) {
            div.getTxtFukashokaiChoteiJiyu2().setValue(model.get調定事由2().getRyakusho());
        } else {
            div.getTxtFukashokaiChoteiJiyu2().setValue(RString.EMPTY);

        }
        if (model.get調定事由3() != null) {
            div.getTxtFukashokaiChoteiJiyu3().setValue(model.get調定事由3().getRyakusho());
        } else {
            div.getTxtFukashokaiChoteiJiyu3().setValue(RString.EMPTY);
        }
        if (model.get調定事由4() != null) {
            div.getTxtFukashokaiChoteiJiyu4().setValue(model.get調定事由4().getRyakusho());
        } else {
            div.getTxtFukashokaiChoteiJiyu4().setValue(RString.EMPTY);
        }
    }

    private static RString toRange(FlexibleYearMonth from, FlexibleYearMonth to) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(from.wareki().toDateString()).append(" ～ ").append(to.wareki().toDateString());

        return builder.toRString();
    }

    private static RString getBetweenMonths(FlexibleYearMonth from, FlexibleYearMonth to) {
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

    private static RString get保険料算定段階(Fuka model) {
        if (model.get保険料算定段階2().isNullOrEmpty()) {
            return model.get保険料算定段階1();
        } else {
            return model.get保険料算定段階2();
        }
    }

    private static void setFukaShokaiControlToShokaiKey(FukaShokaiControlDiv div, FukaShokaiKey key) {
        if (!key.hasAll(FukaShokaiKey.Items.賦課年度, FukaShokaiKey.Items.調定年度,
                FukaShokaiKey.Items.通知書番号, FukaShokaiKey.Items.履歴番号)) {
            div.getBtnFukakonkyoKiwari().setDisabled(true);
            div.getBtnSetaiinShotoku().setDisabled(true);
            div.getBtnTokucho().setDisabled(true);
            div.getBtnGemmen().setDisabled(true);
            div.getBtnRirekiHyoji().setDisabled(true);
            return;
        }

        if (key.get調定年度() != null) {
            div.getTxtChoteiNendo().setDomain(key.get調定年度());
        }
        if (key.get賦課年度() != null) {
            div.getTxtFukaNendo().setDomain(key.get賦課年度());
        }
        if (key.get更正月() != null) {
            div.getTxtKoseiM().setValue(key.get更正月());
        }
        if (key.get更正日時() != null) {
            div.getTxtKoseiYMD().setValue(new FlexibleDate(key.get更正日時().getDate().toString()));
            div.getTxtKoseiTime().setValue(key.get更正日時().getRDateTime().getTime());
        }
    }
}
