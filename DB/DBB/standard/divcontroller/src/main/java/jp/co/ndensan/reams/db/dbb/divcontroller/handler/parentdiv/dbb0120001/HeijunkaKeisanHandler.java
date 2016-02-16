/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb0120001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoHeijunkaKeisanHoho6Gatsu;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.TokuchoKaishiTsuhishoKariOutputJoken;
import jp.co.ndensan.reams.db.dbb.definition.core.valueobject.tokuchoheijunka6gatsutsuchishoikkatsuhakko.TokuchoHeijunka6gatsuTsuchishoIkkatsuHakkoTempData;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0120001.HeijunkaKeisanDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0120001.dgHeijunkaShoriKakunin1_Row;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.kaigofukatokuchoheijunka6.ShorijyokyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.dbbbt35003.OutputChohyoIchiranEntity;
import jp.co.ndensan.reams.db.dbb.service.core.kaigofukatokuchoheijunka6.KaigoFukaTokuchoHeijunka6;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ConfigNameDBB;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.OutputChohyoIchiran.dgOutputChohyoIchiran_Row;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 特徴平準化（特徴6月分）のHandlerクラスです。
 *
 */
public class HeijunkaKeisanHandler {

    private final HeijunkaKeisanDiv div;
    private final RString 特徴平準化_特徴6月分_メニュー = new RString("DBBMN35001");
    private final RString 特徴平準化_特徴6月分_通知書一括発行メニュー = new RString("DBBMN35003");
    private final RString 状況未 = new RString("未");
    private final RString 状況済 = new RString("済");
    private final RString 平準化しない = new RString("0");
    private final RString 平準化するを判定し = new RString("1");
    private final RString 特別徴収平準化計算_特別徴収6月分 = new RString("特別徴収平準化計算（特別徴収6月分）");
    private final RString 仮算定額変更通知書_平準化 = new RString("仮算定額変更通知書(平準化)");
    private static final RString 遷移元区分_0 = new RString("0");
    private static final RString 遷移元区分_1 = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param div
     */
    public HeijunkaKeisanHandler(HeijunkaKeisanDiv div) {
        this.div = div;
    }

    /**
     * コントロールdivの初期処理です。
     */
    public void initialize() {

        RYear 調定年度 = new RYear(BusinessConfig.get(ConfigNameDBB.日付関連_調定年度, SubGyomuCode.DBB介護賦課));
        RYear 賦課年度 = new RYear(BusinessConfig.get(ConfigNameDBB.日付関連_調定年度, SubGyomuCode.DBB介護賦課));
        div.getShoriJokyo().getHeijunkaShoriNaiyo().getTxtChoteiNendo().setDomain(調定年度); //調定年度.wareki().toDateString()
        div.getShoriJokyo().getHeijunkaShoriNaiyo().getTxtFukaNendo().setDomain(賦課年度);  // new RYear(賦課年度.wareki().toDateString())

        
        // test 用
//        List<shorijyokyoEntity> 処理日付管理マスタList = new ArrayList<>();
//        shorijyokyoEntity en = new shorijyokyoEntity();
//        en.set処理名(new RString("処理名"));
//        en.set基準日時(new YMDHMS(new RString("20160101121212")));
//        en.set基準年月日(FlexibleDate.MAX);
//        処理日付管理マスタList.add(en);

        KaigoFukaTokuchoHeijunka6 kaigoFukaTokuchoHeijunka6 = new KaigoFukaTokuchoHeijunka6();
        RString 遷移元区分;
        if (ResponseHolder.getUIContainerId().equals(特徴平準化_特徴6月分_メニュー)) {
            遷移元区分 = 遷移元区分_0;
        } else {
            遷移元区分 = 遷移元区分_1;
        }
        List<ShorijyokyoEntity> 処理日付管理マスタList = kaigoFukaTokuchoHeijunka6.getShoriJohkyoList(遷移元区分, new FlexibleYear(調定年度.toDateString()));  // TODO WC DbT7022ShoriDateKanriDacの修正 OK?
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
        for (ShorijyokyoEntity entity : 処理日付管理マスタList) {
            基準日時 = entity.get基準日時();
            処理名 = entity.get処理名();
            if (基準日時 != null) {
                row.setTxtShoriMei(処理名);
                row.setTxtJokyo(状況済);
                処理日 = new FlexibleDate(基準日時.getYearValue(), 基準日時.getMonthValue(), 基準日時.getDayValue());
                処理時 = new RString(基準日時.getRDateTime().getHour() + ":" + 基準日時.getRDateTime().getMinute() + ":" + 基準日時.getRDateTime().getSecond());
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
        RString 減額コンフィグ = BusinessConfig.get(ConfigNameDBB.特別徴収_平準化計算方法_6月分減額, SubGyomuCode.DBB介護賦課, 調定年度.toDateString());
        if (平準化しない.toString().equals(減額コンフィグ.toString())) {
            減額 = TokuchoHeijunkaKeisanHoho6Gatsu.平準化しない.get名称();
        } else if (平準化するを判定し.toString().equals(減額コンフィグ.toString())) {
            減額 = TokuchoHeijunkaKeisanHoho6Gatsu.toValue(BusinessConfig.
                    get(ConfigNameDBB.特別徴収_平準化計算方法_6月分減額, SubGyomuCode.DBB介護賦課, 調定年度.toDateString())).get名称();
        }
        RString 増額 = RString.EMPTY;
        RString 増額コンフィグ = BusinessConfig.get(ConfigNameDBB.特別徴収_平準化計算方法_6月分増額, SubGyomuCode.DBB介護賦課, 調定年度.toDateString());
        if (平準化しない.toString().equals(増額コンフィグ.toString())) {
            増額 = TokuchoHeijunkaKeisanHoho6Gatsu.平準化しない.get名称();
        } else if (平準化するを判定し.toString().equals(増額コンフィグ.toString())) {
            増額 = TokuchoHeijunkaKeisanHoho6Gatsu.toValue(BusinessConfig.
                    get(ConfigNameDBB.特別徴収_平準化計算方法_6月分増額, SubGyomuCode.DBB介護賦課, 調定年度.toDateString())).get名称();
        }
        div.getHeijunkaKeisanHoho().getTxtKeisanHohoZougaku().setValue(増額);
        div.getHeijunkaKeisanHoho().getTxtKeisanHohoGengaku().setValue(減額);

        RString 帳票グループコード;
        if (ResponseHolder.getUIContainerId().equals(特徴平準化_特徴6月分_メニュー)) {
            帳票グループコード = new RString("DBB0120001(特徴平準化（特徴6月分）)");
        } else {
            帳票グループコード = new RString("DBB0120003(特徴平準化（特徴6月分）通知書一括発行)");
        }
        div.getTokuchoHeijunkaChohyoHakko().getCcdChohyoIchiran().load(SubGyomuCode.DBE認定支援, 帳票グループコード, new RString("1"), new RString("1")); // test用 .load(SubGyomuCode.DBE認定支援, new RString("DBB0120001"), new RString("1"), new RString("1"))

        for (int i = 0, len = div.getTokuchoHeijunkaChohyoHakko().getCcdChohyoIchiran().get出力帳票一覧().size(); i < len; i++) {
            if (ResponseHolder.getUIContainerId().equals(特徴平準化_特徴6月分_メニュー) && 特別徴収平準化計算_特別徴収6月分.equals(div.getTokuchoHeijunkaChohyoHakko().getCcdChohyoIchiran().get出力帳票一覧().get(i).getChohyoName())) {
                div.getTokuchoHeijunkaChohyoHakko().getCcdChohyoIchiran().get出力帳票一覧().get(i).setSelected(true);
//             div.getTokuchoHeijunkaChohyoHakko().getCcdChohyoIchiran().get出力帳票一覧().get(i).setSelectable(false);   // TODO 74150  読取専用（readOnly = true）の設定メソッドが提供されていない
            } else if (ResponseHolder.getUIContainerId().equals(特徴平準化_特徴6月分_通知書一括発行メニュー) && 仮算定額変更通知書_平準化.equals(div.getTokuchoHeijunkaChohyoHakko().getCcdChohyoIchiran().get出力帳票一覧().get(i).getChohyoName())) {
                div.getTokuchoHeijunkaChohyoHakko().getCcdChohyoIchiran().get出力帳票一覧().get(i).setSelected(true);
                // TODO 74150  読取専用（readOnly = true）の設定メソッドが提供されていない
            }
        }

//        div.getTokuchoHeijunkaChohyoHakko().getCcdHeijunkaHenkoTsuchishoBunshoNo();  // TODO QA DBZ.BunshoBangoInput 書番号を取得  20160215 未実装　待ち
        div.getTokuchoHeijunkaChohyoHakko().getRadHeijunkaHenkoTsuchi().setSelectedIndex(0);
    }

    /**
     * 画面側からtempDataを取得します。
     * 
     * @return tempData
     */
    public TokuchoHeijunka6gatsuTsuchishoIkkatsuHakkoTempData getTempData() {
        TokuchoHeijunka6gatsuTsuchishoIkkatsuHakkoTempData tempData = new TokuchoHeijunka6gatsuTsuchishoIkkatsuHakkoTempData();
        tempData.set調定年度(div.getShoriJokyo().getHeijunkaShoriNaiyo().getTxtChoteiNendo().getDomain());
        tempData.set賦課年度(div.getShoriJokyo().getHeijunkaShoriNaiyo().getTxtFukaNendo().getDomain());

        List<OutputChohyoIchiranEntity> outputChohyoIchiranList = new ArrayList<>();
        OutputChohyoIchiranEntity entity;
        for (dgOutputChohyoIchiran_Row row : div.getTokuchoHeijunkaChohyoHakko().getCcdChohyoIchiran().get出力帳票一覧()) {
            entity = new OutputChohyoIchiranEntity();
            entity.setChohyoName(row.getChohyoName());
            entity.setHdnHyojijun(row.getHdnHyojijun());
            entity.setShutsuryokujun(row.getShutsuryokujun());
            outputChohyoIchiranList.add(entity);
        }
        tempData.set出力帳票一覧List(outputChohyoIchiranList);
        tempData.set発行日(div.getTokuchoHeijunkaChohyoHakko().getTxtHeijunkaHenkoTsuchiHakkoYMD().getValue());

        RString 出力対象 = RString.EMPTY;
        int 出力対象Index = div.getTokuchoHeijunkaChohyoHakko().getRadHeijunkaHenkoTsuchi().getSelectedIndex();
        if (出力対象Index == 0) {
            出力対象 = TokuchoKaishiTsuhishoKariOutputJoken.全件_追加候補者含む.get名称();
        } else if (出力対象Index == 1) {
            出力対象 = TokuchoKaishiTsuhishoKariOutputJoken.全件_追加候補者含まない.get名称();
        } else if (出力対象Index == 2) {
            出力対象 = TokuchoKaishiTsuhishoKariOutputJoken.追加候補者のみ全て.get名称();
        }
        tempData.set出力対象(出力対象);
        tempData.set一括発行フラグ(true);
        return tempData;
    }

}
