/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0120001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.kaigofukatokuchoheijunka6.ShorijyokyoJoho;
import jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchoheijunka6tsuchishoikatsuhako.HeijunkaKeisanPageJoho;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheijunka6tsuchishoikatsuhako.OutputChohyoIchiran;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheijunka6tsuchishoikatsuhako.TokuchoHeijunka6gatsuTsuchishoIkatsuHakoFlowParameter;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoHeijunkaKeisanHoho6Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.HeijunkaHenkoOutputJoken;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0120001.HeijunkaKeisanDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0120001.dgHeijunkaShoriKakunin1_Row;
import jp.co.ndensan.reams.db.dbb.service.core.kaigofukatokuchoheijunka6.KaigoFukaTokuchoHeijunka6;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.OutputChohyoIchiran.dgOutputChohyoIchiran_Row;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 特徴平準化（特徴6月分）のHandlerクラスです。
 *
 * @reamsid_L DBB-0820-010 xuyue
 */
public class HeijunkaKeisanHandler {

    private final HeijunkaKeisanDiv div;
    private final RString 特徴平準化_特徴6月分_メニュー = new RString("DBBMN35001");
    private final RString 特徴平準化_特徴6月分_通知書一括発行メニュー = new RString("DBBMN35003");
    private final RString 状況未 = new RString("未");
    private final RString 状況済 = new RString("済");
    private final RString 平準化しない = new RString("0");
    private final RString 前半と後半1_1 = new RString("前半と後半を１：１にする");
    private final RString 年額より４月分 = new RString("年額より４月分を引いた額を５期で割る");
    private final RString 平準化するを判定し = new RString("1");
    private final RString 特別徴収平準化計算_特別徴収6月分 = new RString("特別徴収平準化計算（特別徴収6月分）");
    private final RString 仮算定額変更通知書_平準化 = new RString("仮算定額変更通知書(平準化)");
    private static final RString 遷移元区分_0 = new RString("0");
    private static final RString 遷移元区分_1 = new RString("1");
    private static final RString 帳票グループコード_DBB0120001 = new RString("DBB0120001");
    private static final RString 帳票グループコード_DBB0120003 = new RString("DBB0120003");
    private static final ReportId REPORTID_DBB100012 = new ReportId("DBB100012_KarisanteiHenjunkaHenkoTsuchishoDaihyo");
    private static final RString 選択列表示 = new RString("1");
    private static final RString 設定ボタン列表示 = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param div コントロールdiv
     */
    public HeijunkaKeisanHandler(HeijunkaKeisanDiv div) {
        this.div = div;
    }

    /**
     * コントロールdivの初期処理です。
     */
    public void initialize() {

        FlexibleYear 調定年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        FlexibleYear 賦課年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        div.getShoriJokyo().getHeijunkaShoriNaiyo().getTxtChoteiNendo().setDomain(調定年度);
        div.getShoriJokyo().getHeijunkaShoriNaiyo().getTxtFukaNendo().setDomain(賦課年度);

        KaigoFukaTokuchoHeijunka6 kaigoFukaTokuchoHeijunka6 = KaigoFukaTokuchoHeijunka6.createInstance();
        RString 遷移元区分;
        if (ResponseHolder.getMenuID().equals(特徴平準化_特徴6月分_メニュー)) {
            遷移元区分 = 遷移元区分_0;
        } else {
            遷移元区分 = 遷移元区分_1;
        }
        List<ShorijyokyoJoho> 処理日付管理マスタList = kaigoFukaTokuchoHeijunka6.getShoriJohkyoList(遷移元区分, new FlexibleYear(調定年度.toDateString()));
        List<dgHeijunkaShoriKakunin1_Row> 処理状況データList = new ArrayList<>();
        dgHeijunkaShoriKakunin1_Row row = new dgHeijunkaShoriKakunin1_Row();
        if (処理日付管理マスタList == null || 処理日付管理マスタList.isEmpty()) {
            row.setTxtJokyo(状況未);
            処理状況データList.add(row);
        }
        YMDHMS 基準日時;
        RString 処理名;
        FlexibleDate 処理日;
        RString 処理時;
        if (処理日付管理マスタList == null) {
            処理日付管理マスタList = new ArrayList<>();
        }
        for (ShorijyokyoJoho entity : 処理日付管理マスタList) {
            基準日時 = entity.get基準日時();
            処理名 = entity.get処理名();
            if (基準日時 != null) {
                row.setTxtShoriMei(処理名);
                row.setTxtJokyo(状況済);
                処理日 = new FlexibleDate(基準日時.getYearValue(), 基準日時.getMonthValue(), 基準日時.getDayValue());
                処理時 = 基準日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss);
                row.setTxtShoriNichiji(処理日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                        separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString().concat(RString.HALF_SPACE).concat(処理時));
            } else {
                row.setTxtShoriMei(処理名);
                row.setTxtJokyo(状況未);
                row.setTxtShoriNichiji(RString.EMPTY);
            }
            処理状況データList.add(row);
        }
        div.getShoriJokyo().getHeijunkaShoriKakunin().getDgHeijunkaShoriKakunin1().setDataSource(処理状況データList);

        RString 減額 = RString.EMPTY;
        RString 減額コンフィグ = DbBusinessConfig.
                get(ConfigNameDBB.特別徴収_平準化計算方法_6月分減額, RDate.getNowDate(), SubGyomuCode.DBB介護賦課, 調定年度.toDateString());
        if (平準化しない.toString().equals(減額コンフィグ.toString())) {
            減額 = TokuchoHeijunkaKeisanHoho6Gatsu.平準化しない.get名称();
        } else if (平準化するを判定し.toString().equals(減額コンフィグ.toString())) {
            減額 = TokuchoHeijunkaKeisanHoho6Gatsu.toValue(DbBusinessConfig.
                    get(ConfigNameDBB.特別徴収_平準化計算方法_6月分, RDate.getNowDate(), SubGyomuCode.DBB介護賦課, 調定年度.toDateString())).get名称();
        }
        RString 増額 = RString.EMPTY;
        RString 増額コンフィグ = DbBusinessConfig.
                get(ConfigNameDBB.特別徴収_平準化計算方法_6月分増額, RDate.getNowDate(), SubGyomuCode.DBB介護賦課, 調定年度.toDateString());
        if (平準化しない.toString().equals(増額コンフィグ.toString())) {
            増額 = TokuchoHeijunkaKeisanHoho6Gatsu.平準化しない.get名称();
        } else if (平準化するを判定し.toString().equals(増額コンフィグ.toString())) {
            増額 = TokuchoHeijunkaKeisanHoho6Gatsu.toValue(DbBusinessConfig.
                    get(ConfigNameDBB.特別徴収_平準化計算方法_6月分, RDate.getNowDate(), SubGyomuCode.DBB介護賦課, 調定年度.toDateString())).get名称();
        }
        div.getHeijunkaKeisanHoho().getTxtKeisanHohoZougaku().setValue(増額);
        div.getHeijunkaKeisanHoho().getTxtKeisanHohoGengaku().setValue(減額);

        RString 帳票グループコード;
        if (ResponseHolder.getMenuID().equals(特徴平準化_特徴6月分_メニュー)) {
            帳票グループコード = 帳票グループコード_DBB0120001;
        } else {
            帳票グループコード = 帳票グループコード_DBB0120003;
        }
        div.getTokuchoHeijunkaChohyoHakko().getCcdChohyoIchiran().load(SubGyomuCode.DBB介護賦課, 帳票グループコード, 選択列表示, 設定ボタン列表示);

        for (int i = 0, len = div.getTokuchoHeijunkaChohyoHakko().getCcdChohyoIchiran().get出力帳票一覧().size(); i < len; i++) {
            if (ResponseHolder.getMenuID().equals(特徴平準化_特徴6月分_メニュー) && 特別徴収平準化計算_特別徴収6月分.
                    equals(div.getTokuchoHeijunkaChohyoHakko().getCcdChohyoIchiran().get出力帳票一覧().get(i).getChohyoName())) {
                div.getTokuchoHeijunkaChohyoHakko().getCcdChohyoIchiran().get出力帳票一覧().get(i).setSelected(true);
                // TODO 74150  読取専用（readOnly = true）の設定メソッドが提供されていない
            } else if (ResponseHolder.getMenuID().equals(特徴平準化_特徴6月分_通知書一括発行メニュー) && 仮算定額変更通知書_平準化.
                    equals(div.getTokuchoHeijunkaChohyoHakko().getCcdChohyoIchiran().get出力帳票一覧().get(i).getChohyoName())) {
                div.getTokuchoHeijunkaChohyoHakko().getCcdChohyoIchiran().get出力帳票一覧().get(i).setSelected(true);
                // TODO 74150  読取専用（readOnly = true）の設定メソッドが提供されていない
            }
        }

        div.getTokuchoHeijunkaChohyoHakko().getCcdHeijunkaHenkoTsuchishoBunshoNo().initialize(REPORTID_DBB100012, FlexibleDate.getNowDate());
        div.getTokuchoHeijunkaChohyoHakko().getRadHeijunkaHenkoTsuchi().setSelectedIndex(0);
    }

    /**
     * 画面側からバッチパラメータを取得します。
     *
     * @return バッチパラメータ
     */
    public TokuchoHeijunka6gatsuTsuchishoIkatsuHakoFlowParameter setBatchParameter() {

        HeijunkaKeisanPageJoho data = new HeijunkaKeisanPageJoho();
        data.set調定年度(div.getShoriJokyo().getHeijunkaShoriNaiyo().getTxtChoteiNendo().getDomain());
        data.set賦課年度(div.getShoriJokyo().getHeijunkaShoriNaiyo().getTxtFukaNendo().getDomain());
        if (平準化しない.equals(div.getHeijunkaKeisanHoho().getTxtKeisanHohoZougaku().getText())) {
            data.set増額平準化方法(new RString("0"));
        } else if (前半と後半1_1.equals(div.getHeijunkaKeisanHoho().getTxtKeisanHohoZougaku().getText())) {
            data.set増額平準化方法(new RString("1"));
        } else if (年額より４月分.equals(div.getHeijunkaKeisanHoho().getTxtKeisanHohoZougaku().getText())) {
            data.set増額平準化方法(new RString("2"));
        }

        if (平準化しない.equals(div.getHeijunkaKeisanHoho().getTxtKeisanHohoGengaku().getText())) {
            data.set減額平準化方法(new RString("0"));
        } else if (前半と後半1_1.equals(div.getHeijunkaKeisanHoho().getTxtKeisanHohoGengaku().getText())) {
            data.set減額平準化方法(new RString("1"));
        } else if (年額より４月分.equals(div.getHeijunkaKeisanHoho().getTxtKeisanHohoGengaku().getText())) {
            data.set減額平準化方法(new RString("2"));
        }
        data.set帳票グループ(div.getTokuchoHeijunkaChohyoHakko().getCcdChohyoIchiran().get帳票出力グループコード());

        List<OutputChohyoIchiran> outputChohyoIchiranList = new ArrayList<>();
        OutputChohyoIchiran outputChohyoIchiran;
        for (dgOutputChohyoIchiran_Row row : div.getTokuchoHeijunkaChohyoHakko().getCcdChohyoIchiran().get出力帳票一覧()) {
            outputChohyoIchiran = new OutputChohyoIchiran();
            outputChohyoIchiran.set帳票分類ID(row.getChohyoID());
            outputChohyoIchiran.set帳票名(row.getChohyoName());
            outputChohyoIchiran.set出力順ID(row.getShutsuryokujunID());
            outputChohyoIchiranList.add(outputChohyoIchiran);
        }
        data.set出力帳票一覧List(outputChohyoIchiranList);
        data.set発行日(div.getTokuchoHeijunkaChohyoHakko().getTxtHeijunkaHenkoTsuchiHakkoYMD().getValue());

        RString 出力対象 = RString.EMPTY;
        int 出力対象Index = div.getTokuchoHeijunkaChohyoHakko().getRadHeijunkaHenkoTsuchi().getSelectedIndex();
        if (出力対象Index == 0) {
            出力対象 = HeijunkaHenkoOutputJoken.全件_追加候補者含む.getコード();
        } else if (出力対象Index == 1) {
            出力対象 = HeijunkaHenkoOutputJoken.全件_追加候補者含まない.getコード();
        } else if (出力対象Index == 2) {
            出力対象 = HeijunkaHenkoOutputJoken.追加候補者のみ.getコード();
        }
        data.set出力対象指示フラグ(出力対象);
        data.set一括発行フラグ(true);

        KaigoFukaTokuchoHeijunka6 kaigoFukaTokuchoHeijunka6 = KaigoFukaTokuchoHeijunka6.createInstance();
        return kaigoFukaTokuchoHeijunka6.getBatchiPara(data);
    }

}
