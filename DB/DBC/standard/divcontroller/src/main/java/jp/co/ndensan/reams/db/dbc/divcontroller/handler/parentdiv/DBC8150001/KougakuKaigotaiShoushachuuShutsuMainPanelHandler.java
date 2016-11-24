/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8150001;

import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC815001.DBC815001_KogakuKaigoTaishoshaChushutsuSokyubunParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8150001.KougakuKaigotaiShoushachuuShutsuMainPanelDiv;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 *
 * 画面設計_DBCMN41003_高額介護対象者抽出（遡及分）のハンドラクラスです。
 *
 * @reamsid_L DBC-5750-010 zhengsongling
 */
public class KougakuKaigotaiShoushachuuShutsuMainPanelHandler {

    private static final RString 帳票コード = new RString("DBC200100_KogakuServicehiTaishoshaIchiranSokyubun");
    private static final int 年前_5 = 5;
    private final KougakuKaigotaiShoushachuuShutsuMainPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div HanyoListParamPanelDiv
     */
    public KougakuKaigotaiShoushachuuShutsuMainPanelHandler(KougakuKaigotaiShoushachuuShutsuMainPanelDiv div) {
        this.div = div;
    }

    /**
     * 抽出期間パネル 前回の設定です。
     */
    public void set処理日付管理() {
        div.getChushutsuKikanPanel().getTxtChushutsuKikanZenkai().setFromDateValue(null);
        div.getChushutsuKikanPanel().getTxtChushutsuKikanZenkai().setFromTimeValue(null);
        div.getChushutsuKikanPanel().getTxtChushutsuKikanZenkai().setToDateValue(null);
        div.getChushutsuKikanPanel().getTxtChushutsuKikanZenkai().setToTimeValue(null);
        div.getChushutsuKikanPanel().getTxtShoriYMDZenkai().setValue(null);
        div.getChushutsuKikanPanel().getTxtShoriHMZenkai().setValue(null);
    }

    /**
     * 抽出期間パネル 前回の設定です。
     *
     * @param shoriDateKanriEntity shoriDateKanriEntity
     */
    public void set処理日付管理(ShoriDateKanri shoriDateKanriEntity) {
        div.getChushutsuKikanPanel().getTxtChushutsuKikanZenkai().setFromDateValue(get年月日(shoriDateKanriEntity.get対象開始年月日()));
        div.getChushutsuKikanPanel().getTxtChushutsuKikanZenkai().setFromTimeValue(get時刻(shoriDateKanriEntity.get対象開始日時()));
        div.getChushutsuKikanPanel().getTxtChushutsuKikanZenkai().setToDateValue(get年月日(shoriDateKanriEntity.get対象終了年月日()));
        div.getChushutsuKikanPanel().getTxtChushutsuKikanZenkai().setToTimeValue(get時刻(shoriDateKanriEntity.get対象終了日時()));
        div.getChushutsuKikanPanel().getTxtShoriYMDZenkai().setValue(get日付(shoriDateKanriEntity.get基準年月日()));
        div.getChushutsuKikanPanel().getTxtShoriHMZenkai().setValue(get時刻(shoriDateKanriEntity.get基準日時()));
    }

    /**
     * 高額対象者処理パネルの設定です。
     */
    public void set国保連インターフェース管理() {
        div.getKogakuTaishoshaShoriPanel().getTxtShoriYMD().setValue(null);
        div.getKogakuTaishoshaShoriPanel().getTxtShoriHMD().setValue(null);
        div.getKogakuTaishoshaShoriPanel().getTxtShinsaYM().setValue(null);
    }

    /**
     * 高額対象者処理パネルの設定です。
     *
     * @param kokuhorenInterfaceKanriEntity kokuhorenInterfaceKanriEntity
     */
    public void set国保連インターフェース管理(KokuhorenInterfaceKanri kokuhorenInterfaceKanriEntity) {
        div.getKogakuTaishoshaShoriPanel().getTxtShoriYMD().setValue(get最新処理日時(kokuhorenInterfaceKanriEntity.get処理実施日時()));
        div.getKogakuTaishoshaShoriPanel().getTxtShoriHMD().setValue(get時刻(kokuhorenInterfaceKanriEntity.get処理実施日時()));
        div.getKogakuTaishoshaShoriPanel().getTxtShinsaYM().setValue(get処理年月(kokuhorenInterfaceKanriEntity.get処理年月()));
    }

    /**
     **抽出期間パネルの設定です
     */
    public void set抽出期間_今回() {
        div.getChushutsuKikanPanel().getTxtChushutsuKikanKonkai().setFromDateValue(null);
        div.getChushutsuKikanPanel().getTxtChushutsuKikanKonkai().setFromTimeValue(null);
        set今回();
    }

    /**
     * 抽出期間パネルの設定です。
     *
     * @param shoriDateKanriEntity shoriDateKanriEntity
     */
    public void set抽出期間_今回(ShoriDateKanri shoriDateKanriEntity) {
        div.getChushutsuKikanPanel().getTxtChushutsuKikanKonkai().setFromDateValue(get年月日(shoriDateKanriEntity.get対象終了年月日()));
        div.getChushutsuKikanPanel().getTxtChushutsuKikanKonkai().setFromTimeValue(get時刻(shoriDateKanriEntity.get対象終了日時()));
        set今回();
    }

    /**
     * 計算対象期間パネルの設定です。
     *
     * @param 年月範囲 年月範囲
     */
    public void set計算対象期間パネル(RString 年月範囲) {
        RDate 審査年月 = div.getKogakuTaishoshaShoriPanel().getTxtShinsaYM().getValue();
        if (審査年月 != null) {
            RDate 開始年月 = 審査年月.minusMonth(1);
            RDate 終了年月 = 審査年月.minusMonth(1).minusMonth(Integer.valueOf(年月範囲.toString()));
            div.getKeisanTaishoKikanPanel().getTxtKeisanTaishoKikanYM().setToValue(開始年月);
            div.getKeisanTaishoKikanPanel().getTxtKeisanTaishoKikanYM().setFromValue(終了年月);
        } else {
            div.getKeisanTaishoKikanPanel().getTxtKeisanTaishoKikanYM().setToValue(null);
            div.getKeisanTaishoKikanPanel().getTxtKeisanTaishoKikanYM().setFromValue(null);
        }
    }

    /**
     * 高額介護対象者抽出の実行です。
     *
     * @return DBC815001_KogakuKaigoTaishoshaChushutsuSokyubun
     */
    public DBC815001_KogakuKaigoTaishoshaChushutsuSokyubunParameter onClick_実行ボタン() {
        boolean テスト出力 = false;
        RString 年度 = get年度(div.getKogakuTaishoshaShoriPanel().getTxtShinsaYM().getValue());
        FlexibleYearMonth 処理年月日 = get処理年月日(div.getKogakuTaishoshaShoriPanel().getTxtShinsaYM().getValue());
        RString 処理日 = div.getTxtShoriYMDKonkai().getValue().toDateString();
        RString 処理時 = div.getTxtShoriHMKonkai().getText();
        RString 処理日時 = 処理日.concat(処理時);
        RString 抽出期間開始日 = div.getTxtChushutsuKikanKonkai().getFromDateValue().toDateString();
        RString 抽出期間開始時 = get抽出期間(div.getTxtChushutsuKikanKonkai().getFromTimeValue());
        RDateTime 抽出期間開始日時 = get抽出期間日時(抽出期間開始日, 抽出期間開始時);
        RString 抽出期間終了日 = div.getTxtChushutsuKikanKonkai().getToDateValue().toDateString();
        RString 抽出期間終了時 = get抽出期間(div.getTxtChushutsuKikanKonkai().getToTimeValue());
        RDateTime 抽出期間終了日時 = get抽出期間日時(抽出期間終了日, 抽出期間終了時);
        RString 帳票ID = 帳票コード;
        Long 出力順ID = div.getCcdChohyoShutsuryokujun().get出力順ID();
        FlexibleYearMonth 開始年月１ = get処理年月日(div.getKeisanTaishoKikanPanel().getTxtKeisanTaishoKikanYM().getFromValue());
        FlexibleYearMonth 終了年月１ = get処理年月日(div.getKeisanTaishoKikanPanel().getTxtKeisanTaishoKikanYM().getToValue());
        RString 開始年月２;
        RString 終了年月２;
        if (終了年月１ == null || 終了年月１.isEmpty()) {
            開始年月２ = RString.EMPTY;
        } else {
            開始年月２ = new RDate(終了年月１.toString()).minusYear(年前_5).toDateString();
        }
        if (開始年月１ == null || 開始年月１.isEmpty()) {
            終了年月２ = RString.EMPTY;
        } else {
            終了年月２ = new RDate(開始年月１.toString()).minusMonth(1).toDateString();
        }
        if (div.getChkTesutoShuturyoku().isAllSelected()) {
            テスト出力 = true;
        }
        return new DBC815001_KogakuKaigoTaishoshaChushutsuSokyubunParameter(
                年度,
                処理年月日,
                処理日時,
                抽出期間開始日時,
                抽出期間終了日時,
                帳票ID,
                出力順ID,
                開始年月１,
                終了年月１,
                開始年月２,
                終了年月２,
                テスト出力);
    }

    private FlexibleYearMonth get処理年月日(RDate value) {
        if (value == null) {
            return FlexibleYearMonth.EMPTY;
        } else {
            return new FlexibleYearMonth(value.getYearMonth().toDateString());
        }
    }

    private RString get抽出期間(RTime value) {
        if (value == null) {
            return RString.EMPTY;
        } else {
            int hour = value.getHour();
            int minute = value.getMinute();
            int second = value.getSecond();
            return new RString(String.valueOf(hour).concat(String.valueOf(minute)).concat(String.valueOf(second)));
        }
    }

    private RString get年度(RDate value) {
        if (value == null) {
            return RString.EMPTY;
        } else {
            return value.getYear().toDateString();
        }
    }

    private void set今回() {
        div.getChushutsuKikanPanel().getTxtChushutsuKikanKonkai().setToDateValue(RDate.getNowDate());
        div.getChushutsuKikanPanel().getTxtChushutsuKikanKonkai().setToTimeValue(RTime.now());
        div.getChushutsuKikanPanel().getTxtShoriYMDKonkai().setValue(RDate.getNowDate());
        div.getChushutsuKikanPanel().getTxtShoriHMKonkai().setValue(new RTime(RDate.getNowTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
    }

    private RDate get処理年月(FlexibleYearMonth value) {
        if (value == null || value.isEmpty()) {
            return null;
        } else {
            return new RDate(value.wareki().toDateString().toString());
        }
    }

    private RTime get時刻(YMDHMS value) {
        if (value == null || value.isEmpty()) {
            return null;
        } else {
            return new RTime(value.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        }
    }

    private RDate get最新処理日時(YMDHMS value) {
        if (value == null || value.isEmpty()) {
            return null;
        } else {
            return new RDate(value.getDate().wareki().toDateString().toString());
        }
    }

    private RDate get日付(FlexibleDate value) {
        if (value == null || value.isEmpty()) {
            return null;
        } else {
            return new RDate(value.wareki().toDateString().toString());
        }
    }

    private RDate get年月日(FlexibleDate value) {
        if (value == null || value.isEmpty()) {
            return null;
        } else {
            return new RDate(value.toString());
        }
    }

    private RDateTime get抽出期間日時(RString 日, RString 時) {
        if (時.length() == 5) {
           return RDateTime.of(日, new RString("0").concat(時));
        }
        return RDateTime.of(日, 時);
    }
}
