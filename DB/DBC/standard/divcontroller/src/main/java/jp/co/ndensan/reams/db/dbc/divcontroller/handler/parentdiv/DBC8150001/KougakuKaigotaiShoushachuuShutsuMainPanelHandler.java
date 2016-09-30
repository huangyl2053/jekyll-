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
        div.getChushutsuKikanPanel().getTxtChushutsuKikanZenkai().setFromDatePlaceHolder(RString.EMPTY);
        div.getChushutsuKikanPanel().getTxtChushutsuKikanZenkai().setFromPlaceHolder(RString.EMPTY);
        div.getChushutsuKikanPanel().getTxtChushutsuKikanZenkai().setToDatePlaceHolder(RString.EMPTY);
        div.getChushutsuKikanPanel().getTxtChushutsuKikanZenkai().setToPlaceHolder(RString.EMPTY);
        div.getChushutsuKikanPanel().setTxtShoriYMDZenkai(null);
        div.getChushutsuKikanPanel().setTxtShoriHMZenkai(null);
    }

    /**
     * 抽出期間パネル 前回の設定です。
     *
     * @param shoriDateKanriEntity shoriDateKanriEntity
     */
    public void set処理日付管理(ShoriDateKanri shoriDateKanriEntity) {
        div.getChushutsuKikanPanel().getTxtChushutsuKikanZenkai().setFromDatePlaceHolder(get年月日(shoriDateKanriEntity.get対象開始年月日()));
        div.getChushutsuKikanPanel().getTxtChushutsuKikanZenkai().setFromPlaceHolder(get日時(shoriDateKanriEntity.get対象開始日時()));
        div.getChushutsuKikanPanel().getTxtChushutsuKikanZenkai().setToDatePlaceHolder(get年月日(shoriDateKanriEntity.get対象終了年月日()));
        div.getChushutsuKikanPanel().getTxtChushutsuKikanZenkai().setToPlaceHolder(get日時(shoriDateKanriEntity.get対象終了日時()));
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
        div.getKogakuTaishoshaShoriPanel().getTxtShoriHMD().setValue(get最新処理時刻(kokuhorenInterfaceKanriEntity.get処理実施日時()));
        div.getKogakuTaishoshaShoriPanel().getTxtShinsaYM().setValue(get処理年月(kokuhorenInterfaceKanriEntity.get処理年月()));
    }

    /**
     **抽出期間パネルの設定です
     */
    public void set抽出期間_今回() {
        div.getChushutsuKikanPanel().getTxtChushutsuKikanKonkai().setFromDatePlaceHolder(RString.EMPTY);
        div.getChushutsuKikanPanel().getTxtChushutsuKikanKonkai().setFromPlaceHolder(RString.EMPTY);
        set今回();
    }

    /**
     * 抽出期間パネルの設定です
     *
     * @param shoriDateKanriEntity shoriDateKanriEntity
     */
    public void set抽出期間_今回(ShoriDateKanri shoriDateKanriEntity) {
        div.getChushutsuKikanPanel().getTxtChushutsuKikanKonkai().setFromDatePlaceHolder(get年月日(shoriDateKanriEntity.get対象終了年月日()));
        div.getChushutsuKikanPanel().getTxtChushutsuKikanKonkai().setFromPlaceHolder(get日時(shoriDateKanriEntity.get対象終了日時()));
        set今回();
    }

    /**
     * 計算対象期間パネルの設定です
     *
     * @param 年月範囲 年月範囲
     */
    public void set計算対象期間パネル(RString 年月範囲) {
        RDate 審査年月 = div.getKogakuTaishoshaShoriPanel().getTxtShinsaYM().getValue();
//        RString 年月範囲 = DbBusinessConfig.get(ConfigNameDBC.高額対象者抽出再計算_年月範囲, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (審査年月 != null) {
            RDate 開始年月 = 審査年月.minusMonth(1);
            RDate 終了年月 = 審査年月.minusMonth(1).minusMonth(Integer.valueOf(年月範囲.toString()));
            div.getKeisanTaishoKikanPanel().getTxtKeisanTaishoKikanYM().setToPlaceHolder(get計算対象期間(開始年月));
            div.getKeisanTaishoKikanPanel().getTxtKeisanTaishoKikanYM().setFromPlaceHolder(get計算対象期間(終了年月));
        } else {
            div.getKeisanTaishoKikanPanel().getTxtKeisanTaishoKikanYM().setToPlaceHolder(RString.EMPTY);
            div.getKeisanTaishoKikanPanel().getTxtKeisanTaishoKikanYM().setFromPlaceHolder(RString.EMPTY);
        }
    }

    /**
     * 高額介護対象者抽出の実行です。
     *
     * @return DBC815001_KogakuKaigoTaishoshaChushutsuSokyubun
     */
    public DBC815001_KogakuKaigoTaishoshaChushutsuSokyubunParameter onClick_実行ボタン() {
        boolean テスト出力 = false;
        RString 年度 = div.getKogakuTaishoshaShoriPanel().getTxtShinsaYM().getValue().getYear().toDateString();
        RString 処理年月日 = div.getKogakuTaishoshaShoriPanel().getTxtShinsaYM().getValue().toDateString();
        RString 処理日 = div.getKogakuTaishoshaShoriPanel().getTxtShoriYMD().getValue().toDateString();
        RString 処理時 = div.getKogakuTaishoshaShoriPanel().getTxtShoriHMD().getText();
        RString 処理日時 = 処理日.concat(処理時);
        RString 抽出期間開始日時 = toRStringDate(div.getKeisanTaishoKikanPanel().getTxtKeisanTaishoKikanYM().getFromPlaceHolder());
        RString 抽出期間終了日時 = toRStringDate(div.getKeisanTaishoKikanPanel().getTxtKeisanTaishoKikanYM().getToPlaceHolder());
        RString 帳票ID = 帳票コード;
        Long 出力順ID = div.getCcdChohyoShutsuryokujun().get出力順ID();
        RString 開始年月日１ = toRStringDate(div.getKeisanTaishoKikanPanel().getTxtKeisanTaishoKikanYM().getFromPlaceHolder());
        RString 終了年月日１ = toRStringDate(div.getKeisanTaishoKikanPanel().getTxtKeisanTaishoKikanYM().getToPlaceHolder());
        RString 開始年月日２ = new RDate(終了年月日１.toString()).minusYear(年前_5).toDateString();
        RString 終了年月日２ = new RDate(開始年月日１.toString()).minusMonth(1).toDateString();
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
                開始年月日１,
                終了年月日１,
                開始年月日２,
                終了年月日２,
                テスト出力);
    }

    private RString toRStringDate(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return new RDate(obj.toString()).toDateString();
    }

    private RString get計算対象期間(RDate value) {
        if (value == null) {
            return RString.EMPTY;
        } else {
            return value.getYearMonth().wareki().toDateString();
        }
    }

    private void set今回() {
        div.getChushutsuKikanPanel().getTxtChushutsuKikanKonkai().setToDatePlaceHolder(RDate.getNowDate().wareki().toDateString());
        div.getChushutsuKikanPanel().getTxtChushutsuKikanKonkai().setToPlaceHolder(RDate.getNowTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        div.getChushutsuKikanPanel().getTxtShoriYMDKonkai().setValue(RDate.getNowDate());
        div.getChushutsuKikanPanel().getTxtShoriHMKonkai().setValue(new RTime(RDate.getNowTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
    }

    private RDate get処理年月(FlexibleYearMonth value) {
        if (value == null || value.isEmpty()) {
            return new RDate(RString.EMPTY.toString());
        } else {
            return new RDate(value.wareki().toDateString().toString());
        }
    }

    private RTime get最新処理時刻(YMDHMS value) {
        if (value == null || value.isEmpty()) {
            return new RTime(RString.EMPTY);
        } else {
            return new RTime(value.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        }
    }

    private RDate get最新処理日時(YMDHMS value) {
        if (value == null || value.isEmpty()) {
            return new RDate(RString.EMPTY.toString());
        } else {
            return new RDate(value.getDate().wareki().toDateString().toString());
        }
    }

    private RString get年月日(FlexibleDate value) {
        if (value == null || value.isEmpty()) {
            return RString.EMPTY;
        } else {
            return value.wareki().toDateString();
        }
    }

    private RString get日時(YMDHMS value) {
        if (value == null || value.isEmpty()) {
            return RString.EMPTY;
        } else {
            return value.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss);
        }
    }

    private RDate get日付(FlexibleDate value) {
        if (value == null || value.isEmpty()) {
            return new RDate(RString.EMPTY.toString());
        } else {
            return new RDate(value.wareki().toDateString().toString());
        }
    }

    private RTime get時刻(YMDHMS value) {
        if (value == null || value.isEmpty()) {
            return new RTime(RString.EMPTY);
        } else {
            return new RTime(value.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
        }
    }
}
