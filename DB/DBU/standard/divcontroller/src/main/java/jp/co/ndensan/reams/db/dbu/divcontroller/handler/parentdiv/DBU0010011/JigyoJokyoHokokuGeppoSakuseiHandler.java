/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0010011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0010011.JigyoJokyoHokokuGeppoSakuseiDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.gappeijoho.GappeiCityJohoBFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 事業状況報告（月報）作成の処理です
 *
 * @reamsid_L DBU-5550-010 dangjingjing
 */
public class JigyoJokyoHokokuGeppoSakuseiHandler {

    private static final RString 合併あり = new RString("1");
    private static final RString 審査年月 = new RString("1");
    private static final RString 決定年月 = new RString("2");
    private static final int 月 = 3;
    private static final RString 点 = new RString(".");
    private static final RString 集計のみ = new RString("shukei");
    private static final RString 集計後に印刷 = new RString("shukeiOutput");
    private static final RString 過去の集計結果を印刷 = new RString("kakoShukeiOutput");
    private static final RString すべて選択 = new RString("all");
    private static final RString 一般状況1_11 = new RString("ippan1_11");
    private static final RString 一般状況12_14_現物分 = new RString("ippan12_14Genbutsu");
    private static final RString 保険給付決定状況_現物分 = new RString("hokenKyufuGenbutsu");
    private static final RString 一般状況12_14_償還分 = new RString("ippan12_14Shokan");
    private static final RString 保険給付決定状況_償還分 = new RString("hokenKyufuShokan");
    private static final RString 保険給付決定状況_高額分 = new RString("hokenKyufuKogaku");
    private static final RString 保険給付決定状況_高額合算分 = new RString("hokenKyufuKogakuGassan");
    private static final RString 審査年月で集計 = new RString("shinsaYM4");
    private static final RString 決定年月で集計 = new RString("keiteiYM4");
    private static final RString 給付審査年月で集計 = new RString("shinsaYM5");
    private static final RString 給付決定年月で集計 = new RString("keiteiYM5");
    private static final RDate 基準日 = RDate.getNowDate();
    private static final RString 年度内連番 = new RString("0001");
    private static final FlexibleDate 平成年月 = new FlexibleDate("平成21年7月");
    private final JigyoJokyoHokokuGeppoSakuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 各種申請書Div
     */
    public JigyoJokyoHokokuGeppoSakuseiHandler(JigyoJokyoHokokuGeppoSakuseiDiv div) {
        this.div = div;
    }

    /**
     * 事業状況報告（月報）作成の初期化処理です。
     *
     * @param shoriDateKanriList <ShoriDateKanri>
     */
    public void onLoad(List<ShoriDateKanri> shoriDateKanriList) {
        set合併市町村用保険者選択ラジオボタン();
        set広域構成市町村用保険者選択ラジオボタン();
        set市町村選択ダイアログボタン();
        set過去報告年月(shoriDateKanriList);
        set初期状態();
        set日付();
        set時刻();
        RString 集計年月 = DbBusinessConfig.get(ConfigNameDBU.事業状況報告_一般状況集計方法, 基準日, SubGyomuCode.DBU介護統計報告);
        if (集計年月.equals(審査年月)) {
            div.getRadlblShukeiType4().setSelectedKey(審査年月で集計);
        } else if (集計年月.equals(決定年月)) {
            div.getRadlblShukeiType4().setSelectedKey(決定年月で集計);
        }
        RString 給付年月 = DbBusinessConfig.get(ConfigNameDBU.事業状況報告_保険給付集計方法, 基準日, SubGyomuCode.DBU介護統計報告);
        if (給付年月.equals(審査年月)) {
            div.getRadlblShukeiType5().setSelectedKey(給付審査年月で集計);
        } else if (給付年月.equals(決定年月)) {
            div.getRadlblShukeiType5().setSelectedKey(給付決定年月で集計);
        }
    }

    private void set合併市町村用保険者選択ラジオボタン() {
        if (is合併あり() && is単一()) {
            div.getTblJikkoTani().getDdlKakoHokokuYM().setVisible(true);
            div.getTblJikkoTani().getRadGappeiShichoson().setVisible(true);
            div.getTblJikkoTani().getBtnShichosonSelect().setVisible(true);
            div.getTblJikkoTani().getRadKoikiRengo().setVisible(true);
        } else if (!is合併あり() && is単一()
                || is広域()) {
            div.getTblJikkoTani().getDdlKakoHokokuYM().setVisible(true);
            div.getTblJikkoTani().getRadGappeiShichoson().setVisible(false);
            div.getTblJikkoTani().getBtnShichosonSelect().setVisible(true);
            div.getTblJikkoTani().getRadKoikiRengo().setVisible(true);
        }
    }

    private void set広域構成市町村用保険者選択ラジオボタン() {
        if (is広域()) {
            div.getTblJikkoTani().getRadKoikiRengo().setVisible(true);
            div.getTblJikkoTani().getBtnShichosonSelect().setVisible(true);
            div.getTblJikkoTani().getDdlKakoHokokuYM().setVisible(true);
            div.getTblJikkoTani().getRadGappeiShichoson().setVisible(false);
        } else if (!is合併あり() && is単一()) {
            div.getTblJikkoTani().getBtnShichosonSelect().setVisible(false);
            div.getTblJikkoTani().getDdlKakoHokokuYM().setVisible(true);
            div.getTblJikkoTani().getRadGappeiShichoson().setVisible(false);
            div.getTblJikkoTani().getRadKoikiRengo().setVisible(true);
        }
    }

    private void set市町村選択ダイアログボタン() {
        if (is合併あり() && is広域()) {
            div.getTblJikkoTani().getBtnShichosonSelect().setVisible(true);
            div.getTblJikkoTani().getRadGappeiShichoson().setVisible(true);
            div.getTblJikkoTani().getBtnShichosonSelect().setDisabled(false);
            div.getTblJikkoTani().getRadKoikiRengo().setVisible(true);
        } else if (!is合併あり() && is単一()) {
            div.getTblJikkoTani().getBtnShichosonSelect().setVisible(false);
            div.getTblJikkoTani().getDdlKakoHokokuYM().setVisible(true);
            div.getTblJikkoTani().getRadGappeiShichoson().setVisible(false);
            div.getTblJikkoTani().getRadKoikiRengo().setVisible(true);
        }
    }

    /**
     * 過去報告年月 DDLのデータソースを設定
     *
     * @param shoriDateKanriList
     */
    private void set過去報告年月(List<ShoriDateKanri> shoriDateKanriList) {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (int i = 0; i < shoriDateKanriList.size(); i++) {
            ShoriDateKanri shoriDateKanri = shoriDateKanriList.get(i);
            RStringBuilder 過去年月 = new RStringBuilder();
            過去年月.append(shoriDateKanri.get年度().wareki().toDateString());
            過去年月.append(点);
            過去年月.append(shoriDateKanri.get処理枝番().substring(2));
            KeyValueDataSource dataSource = new KeyValueDataSource(new RString(i), 過去年月.toRString());
            dataSourceList.add(dataSource);
        }
        div.getDdlKakoHokokuYM().setDataSource(dataSourceList);
    }

    /**
     * 画面初期状態の設定です。
     */
    public void set初期状態() {
        if (div.getTblJikkoTani().getRadJikkoTaniKakoShukeiKekka().getSelectedKey().equals(過去の集計結果を印刷)) {
            div.getBtnKakutei().setDisabled(false);
            div.getTxtHokokuYM().setDisabled(false);
        } else {
            div.getDdlKakoHokokuYM().setDisabled(false);
        }
    }

    /**
     * 日付を設定する
     */
    public void set日付() {
        if (div.getTblJikkoTani().getRadJikkoTaniShukeiOnly().getSelectedKey().equals(集計のみ)
                || div.getTblJikkoTani().getRadJikkoTaniShukeiAfterPrint().getSelectedKey().equals(集計後に印刷)) {
            div.getTxtSakuseiYMD1().setValue(RDate.getNowDate());
            div.getTxtSakuseiYMD2().setValue(RDate.getNowDate());
            div.getTxtSakuseiYMD3().setValue(RDate.getNowDate());
            div.getTxtSakuseiYMD4().setValue(RDate.getNowDate());
            div.getTxtSakuseiYMD5().setValue(RDate.getNowDate());
            div.getTxtSakuseiYMD6().setValue(RDate.getNowDate());
            div.getTxtSakuseiYMD7().setValue(RDate.getNowDate());
        }
    }

    /**
     * 時刻を設定する。
     */
    public void set時刻() {
        if (div.getTblJikkoTani().getRadJikkoTaniShukeiOnly().getSelectedKey().equals(集計のみ)
                || div.getTblJikkoTani().getRadJikkoTaniShukeiAfterPrint().getSelectedKey().equals(集計後に印刷)) {
            div.getTxtSakuseiTime1().setValue(RTime.now());
            div.getTxtSakuseiTime2().setValue(RTime.now());
            div.getTxtSakuseiTime3().setValue(RTime.now());
            div.getTxtSakuseiTime4().setValue(RTime.now());
            div.getTxtSakuseiTime5().setValue(RTime.now());
            div.getTxtSakuseiTime6().setValue(RTime.now());
            div.getTxtSakuseiTime7().setValue(RTime.now());
        }
    }

    private boolean is合併あり() {
        return 合併あり.equals(GappeiCityJohoBFinder.createInstance().getGappeijohokubun());
    }

    private boolean is単一() {
        return DonyuKeitaiCode.事務単一.getCode()
                .equals(ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務).get導入形態コード().value());
    }

    private boolean is広域() {
        return DonyuKeitaiCode.事務広域.getCode()
                .equals(ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務).get導入形態コード().value());
    }

    /**
     * 入力された報告年月より、各集計年月を設定する。
     */
    public void set報告年月() {
        RDate 報告年月 = div.getTblJikkoTani().getTxtHokokuYM().getValue();
        div.getTxtShukeiYM1().setValue(new FlexibleDate(報告年月.minusMonth(1).toDateString()));
        div.getTxtShukeiYM2().setValue(new FlexibleDate(報告年月.minusMonth(2).toDateString()));
        div.getTxtShukeiYM3().setValue(new FlexibleDate(報告年月.minusMonth(2).toDateString()));

        RString 償還分集計年月設定 = DbBusinessConfig.get(ConfigNameDBU.事業状況報告_一般状況集計方法, 基準日, SubGyomuCode.DBU介護統計報告);
        if (償還分集計年月設定.equals(審査年月)) {
            div.getTxtShukeiYM4().setValue(new FlexibleDate(報告年月.minusMonth(月).toDateString()));
            div.setTxtShukeiYM4Bak(報告年月.minusMonth(2).toDateString());
        } else if (償還分集計年月設定.equals(決定年月)) {
            div.getTxtShukeiYM4().setValue(new FlexibleDate(報告年月.minusMonth(1).toDateString()));
            div.setTxtShukeiYM4Bak(報告年月.minusMonth(月).toDateString());
        }
        RString 保険給付集計年月設定 = DbBusinessConfig.get(ConfigNameDBU.事業状況報告_保険給付集計方法, 基準日, SubGyomuCode.DBU介護統計報告);
        if (保険給付集計年月設定.equals(審査年月)) {
            div.getTxtShukeiYM5().setValue(new FlexibleDate(報告年月.minusMonth(月).toDateString()));
            div.setTxtShukeiYM5Bak(報告年月.minusMonth(2).toDateString());
        } else if (償還分集計年月設定.equals(決定年月)) {
            div.getTxtShukeiYM5().setValue(new FlexibleDate(報告年月.minusMonth(1).toDateString()));
            div.setTxtShukeiYM5Bak(報告年月.minusMonth(月).toDateString());
        }

        div.getTxtShukeiYM6().setValue(new FlexibleDate(報告年月.minusMonth(2).toDateString()));
        div.getTxtShukeiYM7().setValue(new FlexibleDate(報告年月.minusMonth(2).toDateString()));
    }

    /**
     * チェックボックスの操作設定
     */
    public void setチェックボックス設定() {
        setチェックボックス();
    }

    private void setチェックボックス() {
        List<RString> 一般状況1_11_List = new ArrayList<>();
        List<RString> 一般状況12_14_現物分_List = new ArrayList<>();
        List<RString> 保険給付決定状況_現物分_List = new ArrayList<>();
        List<RString> 一般状況12_14_償還分_List = new ArrayList<>();
        List<RString> 保険給付決定状況_償還分_List = new ArrayList<>();
        List<RString> 保険給付決定状況_高額分_List = new ArrayList<>();
        List<RString> 保険給付決定状況_高額合算分_List = new ArrayList<>();
        if (div.getTxtShukeiYM1().getValue() != null) {
            一般状況1_11_List.add(一般状況1_11);
            div.getCblOutputTaisho1().setSelectedItemsByKey(一般状況1_11_List);
        } else {
            div.getCblOutputTaisho1().setSelectedItemsByKey(一般状況1_11_List);
        }
        if (div.getTxtShukeiYM2().getValue() != null) {
            一般状況12_14_現物分_List.add(一般状況12_14_現物分);
            div.getCblOutputTaisho2().setSelectedItemsByKey(一般状況12_14_現物分_List);
        } else {
            div.getCblOutputTaisho2().setSelectedItemsByKey(一般状況12_14_現物分_List);
        }
        if (div.getTxtShukeiYM3().getValue() != null) {
            保険給付決定状況_現物分_List.add(保険給付決定状況_現物分);
            div.getCblOutputTaisho3().setSelectedItemsByKey(保険給付決定状況_現物分_List);
        } else {
            div.getCblOutputTaisho3().setSelectedItemsByKey(保険給付決定状況_現物分_List);
        }
        if (div.getTxtShukeiYM4().getValue() != null) {
            一般状況12_14_償還分_List.add(一般状況12_14_償還分);
            div.getCblOutputTaisho4().setSelectedItemsByKey(一般状況12_14_償還分_List);
        } else {
            div.getCblOutputTaisho4().setSelectedItemsByKey(一般状況12_14_償還分_List);
        }
        if (div.getTxtShukeiYM5().getValue() != null) {
            保険給付決定状況_償還分_List.add(保険給付決定状況_償還分);
            div.getCblOutputTaisho5().setSelectedItemsByKey(保険給付決定状況_償還分_List);
        } else {
            div.getCblOutputTaisho5().setSelectedItemsByKey(保険給付決定状況_償還分_List);
        }
        if (div.getTxtShukeiYM6().getValue() != null) {
            保険給付決定状況_高額分_List.add(保険給付決定状況_高額分);
            div.getCblOutputTaisho6().setSelectedItemsByKey(保険給付決定状況_高額分_List);
        } else {
            div.getCblOutputTaisho6().setSelectedItemsByKey(保険給付決定状況_高額分_List);
        }
        if (div.getTxtShukeiYM7().getValue() != null) {
            保険給付決定状況_高額合算分_List.add(保険給付決定状況_高額合算分);
            div.getCblOutputTaisho7().setSelectedItemsByKey(保険給付決定状況_高額合算分_List);
        } else {
            div.getCblOutputTaisho7().setSelectedItemsByKey(保険給付決定状況_高額合算分_List);
        }
        if (!div.getTxtShukeiYM3().getValue().isEmpty() && !div.getTxtShukeiYM5().getValue().isEmpty()
                && !div.getTxtShukeiYM6().getValue().isEmpty() && !div.getTxtShukeiYM7().getValue().isEmpty()) {
            div.getDdlKakoHokokuYM().setDisabled(false);
            if (div.getTxtShukeiYM3().getValue().isBefore(平成年月)) {
                div.getTxtShukeiYM3().setDisabled(true);
            } else {
                div.getTxtShukeiYM3().setDisabled(false);
            }
            if (div.getTxtShukeiYM5().getValue().isBefore(平成年月)) {
                div.getTxtShukeiYM5().setDisabled(true);
            } else {
                div.getTxtShukeiYM5().setDisabled(false);
            }
            if (div.getTxtShukeiYM6().getValue().isBefore(new FlexibleDate("平成18年6月"))) {
                div.getTxtShukeiYM6().setDisabled(true);
            } else {
                div.getTxtShukeiYM6().setDisabled(false);
            }
            if (div.getTxtShukeiYM7().getValue().isBefore(new FlexibleDate("平成24年6月"))) {
                div.getTxtShukeiYM7().setDisabled(true);
            } else {
                div.getTxtShukeiYM7().setDisabled(false);
            }
        } else {
            div.getDdlKakoHokokuYM().setDisabled(true);
        }
    }

    /**
     * 「月報報告 一般状況１～１１」の処理日付管理情報を取得する。
     */
    public void set月報報告_一般状況1_11onClick() {
        ShoriDateKanriManager shoriDateKanriManager = new ShoriDateKanriManager();
        RString 過去報告年月 = div.getTblJikkoTani().getDdlKakoHokokuYM().getSelectedValue();
        RDate 過去報告年月_Date = new RDate(過去報告年月.toString());
        RString 処理枝番 = new RString("00").concat(new RString(過去報告年月_Date.minusMonth(1).getMonthValue()));
        ShoriDateKanri 月報報告_一般状況1_11 = shoriDateKanriManager.get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                new RString("月報報告  一般状況１～１１"), 処理枝番, new FlexibleYear(過去報告年月_Date.seireki().getYear()),
                年度内連番);
        if (月報報告_一般状況1_11 != null) {
            FlexibleDate 集計年月1テキストボックス = new FlexibleDate(月報報告_一般状況1_11.get年度().toDateString()
                    .concat(月報報告_一般状況1_11.get処理枝番().substring(2)));
            if (!div.getTxtShukeiYM1().getValue().isEmpty()) {
                div.getTxtShukeiYM1().setReadOnly(false);
                div.getTxtShukeiYM1().setValue(集計年月1テキストボックス);
            } else {
                div.getTxtShukeiYM1().setReadOnly(true);
            }
            RDate 処理日付 = new RDate(月報報告_一般状況1_11.get基準日時().toString());
            div.getTxtSakuseiYMD1().setValue(処理日付);
            RTime 処理日時 = new RTime(月報報告_一般状況1_11.get基準日時().toDateString());
            div.getTxtSakuseiTime1().setValue(処理日時);
        }
        if (!div.getTxtShukeiYM1().getValue().isEmpty()) {
            div.getDdlKakoHokokuYM().setDisabled(false);
            if (div.getTxtShukeiYM1().getValue().isBefore(new FlexibleDate("平21.07"))) {
                div.getTxtShukeiYM1().setDisabled(true);
            } else {
                div.getTxtShukeiYM1().setDisabled(false);
            }
        } else {
            div.getDdlKakoHokokuYM().setDisabled(true);
        }

    }

    /**
     * 「月報報告 一般状況１２～１４ 現物分」の処理日付管理情報を取得する。
     */
    public void set月報報告_一般状況12_14_現物分onClick() {
        ShoriDateKanriManager shoriDateKanriManager = new ShoriDateKanriManager();
        RString 過去報告年月 = div.getTblJikkoTani().getDdlKakoHokokuYM().getSelectedValue();
        RDate 過去報告年月_Date = new RDate(過去報告年月.toString());
        RString 処理枝番 = new RString("00").concat(new RString(過去報告年月_Date.minusMonth(2).getMonthValue()));
        FlexibleYear 過去報告年月_Year = new FlexibleYear(過去報告年月_Date.seireki().getYear());
        ShoriDateKanri 月報報告_一般状況12_14_現物分 = shoriDateKanriManager.get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                new RString("月報報告 一般状況１２～１４ 現物分"), 処理枝番, 過去報告年月_Year, 年度内連番);
        if (月報報告_一般状況12_14_現物分 != null) {
            FlexibleDate 集計年月2テキストボックス = new FlexibleDate(月報報告_一般状況12_14_現物分.get年度().toDateString()
                    .concat(月報報告_一般状況12_14_現物分.get処理枝番().substring(2)));
            if (!div.getTxtShukeiYM2().getValue().isEmpty()) {
                div.getTxtShukeiYM2().setReadOnly(false);
                div.getTxtShukeiYM2().setValue(集計年月2テキストボックス);
            } else {
                div.getTxtShukeiYM2().setReadOnly(true);
            }
            RDate 処理日付 = new RDate(月報報告_一般状況12_14_現物分.get基準日時().toString());
            div.getTxtSakuseiYMD2().setValue(処理日付);
            RTime 処理日時 = new RTime(月報報告_一般状況12_14_現物分.get基準日時().toDateString());
            div.getTxtSakuseiTime2().setValue(処理日時);
        }
    }

    /**
     * 「月報報告 保険給付決定 現物分」の処理日付管理情報を取得する。
     */
    public void set月報報告_保険給付決定_現物分_onClick() {
        ShoriDateKanriManager shoriDateKanriManager = new ShoriDateKanriManager();
        RString 過去報告年月 = div.getTblJikkoTani().getDdlKakoHokokuYM().getSelectedValue();
        RDate 過去報告年月_Date = new RDate(過去報告年月.toString());
        RString 処理枝番 = new RString("00").concat(new RString(過去報告年月_Date.minusMonth(2).getMonthValue()));
        FlexibleYear 過去報告年月_Year = new FlexibleYear(過去報告年月_Date.seireki().getYear());
        ShoriDateKanri 月報報告_保険給付決定_現物分 = shoriDateKanriManager.get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                new RString("月報報告  保険給付決定  現物分"), 処理枝番, 過去報告年月_Year, 年度内連番);
        if (月報報告_保険給付決定_現物分 != null) {
            FlexibleDate 集計年月3テキストボックス = new FlexibleDate(月報報告_保険給付決定_現物分.get年度().toDateString()
                    .concat(月報報告_保険給付決定_現物分.get処理枝番().substring(2)));
            if (!div.getTxtShukeiYM3().getValue().isEmpty()) {
                div.getTxtShukeiYM3().setReadOnly(false);
                div.getTxtShukeiYM3().setValue(集計年月3テキストボックス);
            } else {
                div.getTxtShukeiYM3().setReadOnly(true);
            }
            RDate 処理日付 = new RDate(月報報告_保険給付決定_現物分.get基準日時().toString());
            div.getTxtSakuseiYMD3().setValue(処理日付);
            RTime 処理日時 = new RTime(月報報告_保険給付決定_現物分.get基準日時().toDateString());
            div.getTxtSakuseiTime3().setValue(処理日時);
        }

    }

    /**
     * 月報報告 一般状況1２～１４ 償還分審査 の処理日付管理情報を取得する。
     */
    public void set月報報告_一般状況12_14_償還分() {

        set一般状況12_14_償還分();
    }

    private void set一般状況12_14_償還分() {
        ShoriDateKanriManager shoriDateKanriManager = new ShoriDateKanriManager();
        RString 過去報告年月 = div.getTblJikkoTani().getDdlKakoHokokuYM().getSelectedValue();
        RDate 過去報告年月_Date = new RDate(過去報告年月.toString());
        RString 処理枝番1 = new RString("00").concat(new RString(過去報告年月_Date.minusMonth(2).getMonthValue()));
        FlexibleYear 過去報告年月_Year = new FlexibleYear(過去報告年月_Date.seireki().getYear());
        ShoriDateKanri 月報報告_一般状況12_14_償還分審査 = shoriDateKanriManager.get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                new RString("月報報告  一般状況1２～１４  償還分審査"), 処理枝番1, 過去報告年月_Year, 年度内連番);
        RString 処理枝番2 = new RString("00").concat(new RString(過去報告年月_Date.minusMonth(1).getMonthValue()));
        ShoriDateKanri 月報報告_一般状況12_14_償還分決定 = shoriDateKanriManager.get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                new RString("月報報告  一般状況1２～１４  償還分決定"), 処理枝番2, 過去報告年月_Year, 年度内連番);
        if (月報報告_一般状況12_14_償還分審査 != null && 月報報告_一般状況12_14_償還分決定 != null) {
            set一般状況両方日付年月();
        }
    }

    private void set一般状況両方日付年月() {
        ShoriDateKanriManager shoriDateKanriManager = new ShoriDateKanriManager();
        RString 過去報告年月 = div.getTblJikkoTani().getDdlKakoHokokuYM().getSelectedValue();
        RDate 過去報告年月_Date = new RDate(過去報告年月.toString());
        RString 処理枝番1 = new RString("00").concat(new RString(過去報告年月_Date.minusMonth(2).getMonthValue()));
        FlexibleYear 過去報告年月_Year = new FlexibleYear(過去報告年月_Date.seireki().getYear());
        ShoriDateKanri 月報報告_一般状況12_14_償還分審査 = shoriDateKanriManager.get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                new RString("月報報告  一般状況1２～１４  償還分審査"), 処理枝番1, 過去報告年月_Year, 年度内連番);
        RString 処理枝番2 = new RString("00").concat(new RString(過去報告年月_Date.minusMonth(1).getMonthValue()));
        ShoriDateKanri 月報報告_一般状況12_14_償還分決定 = shoriDateKanriManager.get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                new RString("月報報告  一般状況1２～１４  償還分決定"), 処理枝番2, 過去報告年月_Year, 年度内連番);
        RString 両方日付管理情報 = DbBusinessConfig.get(ConfigNameDBU.事業状況報告_一般状況集計方法, 基準日, SubGyomuCode.DBU介護統計報告);
        if (両方日付管理情報.equals(審査年月)) {
            FlexibleDate 集計年月4審査 = new FlexibleDate(月報報告_一般状況12_14_償還分審査.get年度().toDateString()
                    .concat(月報報告_一般状況12_14_償還分審査.get処理枝番().substring(2)));
            if (!div.getTxtShukeiYM4().getValue().isEmpty()) {
                div.getTxtShukeiYM4().setReadOnly(false);
                div.getTxtShukeiYM4().setValue(集計年月4審査);
            } else {
                div.getTxtShukeiYM4().setReadOnly(true);
            }
            RDate 処理日付審査 = new RDate(月報報告_一般状況12_14_償還分審査.get基準日時().toString());
            div.getTxtSakuseiYMD4().setValue(処理日付審査);

            RTime 処理日時審査 = new RTime(月報報告_一般状況12_14_償還分審査.get基準日時().toDateString());
            div.getTxtSakuseiTime4().setValue(処理日時審査);
            FlexibleDate 集計年月4決定 = new FlexibleDate(月報報告_一般状況12_14_償還分決定.get年度().toDateString()
                    .concat(月報報告_一般状況12_14_償還分決定.get処理枝番().substring(2)));
            div.setTxtShukeiYM4Bak(new RString(集計年月4決定.toString()));
            RDate 処理日付決定 = new RDate(月報報告_一般状況12_14_償還分決定.get基準日時().toString());
            div.getTxtSakuseiYMD4().setValue(処理日付決定);
            RTime 処理日時決定 = new RTime(月報報告_一般状況12_14_償還分決定.get基準日時().toDateString());
            div.getTxtSakuseiTime4().setValue(処理日時決定);
            div.getRadlblShukeiType4().setSelectedKey(審査年月で集計);
        } else if (両方日付管理情報.equals(決定年月)) {
            FlexibleDate 集計年月4決定 = new FlexibleDate(月報報告_一般状況12_14_償還分決定.get年度().toDateString()
                    .concat(月報報告_一般状況12_14_償還分決定.get処理枝番().substring(2)));
            if (!div.getTxtShukeiYM4().getValue().isEmpty()) {
                div.getTxtShukeiYM4().setReadOnly(false);
                div.getTxtShukeiYM4().setValue(集計年月4決定);
            } else {
                div.getTxtShukeiYM4().setReadOnly(true);
            }
            RDate 処理日付決定 = new RDate(月報報告_一般状況12_14_償還分決定.get基準日時().toString());
            div.getTxtSakuseiYMD4().setValue(処理日付決定);
            RTime 処理日時決定 = new RTime(月報報告_一般状況12_14_償還分決定.get基準日時().toDateString());
            div.getTxtSakuseiTime4().setValue(処理日時決定);
            FlexibleDate 集計年月4審査 = new FlexibleDate(月報報告_一般状況12_14_償還分審査.get年度().toDateString()
                    .concat(月報報告_一般状況12_14_償還分審査.get処理枝番().substring(2)));
            div.setTxtShukeiYM4Bak(new RString(集計年月4審査.toString()));
            RDate 処理日付審査 = new RDate(月報報告_一般状況12_14_償還分審査.get基準日時().toString());
            div.getTxtSakuseiYMD4().setValue(処理日付審査);
            RTime 処理日時審査 = new RTime(月報報告_一般状況12_14_償還分審査.get基準日時().toDateString());
            div.getTxtSakuseiTime4().setValue(処理日時審査);
            div.getRadlblShukeiType4().setSelectedKey(決定年月で集計);
        }
        FlexibleDate 集計年月4審査 = new FlexibleDate(月報報告_一般状況12_14_償還分審査.get年度().toDateString()
                .concat(月報報告_一般状況12_14_償還分審査.get処理枝番().substring(2)));
        if (!div.getTxtShukeiYM4().getValue().isEmpty()) {
            div.getTxtShukeiYM4().setReadOnly(false);
            div.getTxtShukeiYM4().setValue(集計年月4審査);
        } else {
            div.getTxtShukeiYM4().setReadOnly(true);
        }
        RDate 処理日付審査 = new RDate(月報報告_一般状況12_14_償還分審査.get基準日時().toString());
        div.getTxtSakuseiYMD4().setValue(処理日付審査);
        RTime 処理日時審査 = new RTime(月報報告_一般状況12_14_償還分審査.get基準日時().toDateString());
        div.getTxtSakuseiTime4().setValue(処理日時審査);
        div.setTxtShukeiYM4Bak(RString.EMPTY);
        div.getRadlblShukeiType4().setSelectedKey(審査年月で集計);
        FlexibleDate 集計年月4決定 = new FlexibleDate(月報報告_一般状況12_14_償還分決定.get年度().toDateString()
                .concat(月報報告_一般状況12_14_償還分決定.get処理枝番().substring(2)));
        if (!div.getTxtShukeiYM4().getValue().isEmpty()) {
            div.getTxtShukeiYM4().setReadOnly(false);
            div.getTxtShukeiYM4().setValue(集計年月4決定);
        } else {
            div.getTxtShukeiYM4().setReadOnly(true);
        }
        RDate 処理日付決定 = new RDate(月報報告_一般状況12_14_償還分決定.get基準日時().toString());
        div.getTxtSakuseiYMD4().setValue(処理日付決定);
        RTime 処理日時決定 = new RTime(月報報告_一般状況12_14_償還分決定.get基準日時().toDateString());
        div.getTxtSakuseiTime4().setValue(処理日時決定);
        div.setTxtShukeiYM4Bak(RString.EMPTY);
        div.getRadlblShukeiType4().setSelectedKey(決定年月で集計);
    }

    /**
     * 月報報告 保険給付決定 償還分 の処理日付管理情報を取得する。
     */
    public void set月報報告_保険給付決定_償還分() {
        set保険給付決定_償還分();
    }

    private void set保険給付決定_償還分() {
        ShoriDateKanriManager shoriDateKanriManager = new ShoriDateKanriManager();
        RString 過去報告年月 = div.getTblJikkoTani().getDdlKakoHokokuYM().getSelectedValue();
        RDate 過去報告年月_Date = new RDate(過去報告年月.toString());
        RString 処理枝番1 = new RString("00").concat(new RString(過去報告年月_Date.minusMonth(月).getMonthValue()));
        FlexibleYear 過去報告年月_Year = new FlexibleYear(過去報告年月_Date.seireki().getYear());
        ShoriDateKanri 月報報告_保険給付決定_償還分審査 = shoriDateKanriManager.get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                new RString("月報報告  保険給付決定  償還分審査"), 処理枝番1, 過去報告年月_Year, 年度内連番);
        RString 処理枝番2 = new RString("00").concat(new RString(過去報告年月_Date.minusMonth(2).getMonthValue()));
        ShoriDateKanri 月報報告_保険給付決定_償還分決定 = shoriDateKanriManager.get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                new RString("月報報告  保険給付決定  償還分決定"), 処理枝番2, 過去報告年月_Year, 年度内連番);
        if (月報報告_保険給付決定_償還分審査 != null && 月報報告_保険給付決定_償還分決定 != null) {
            set保険給付両方日付管理();
        }
    }

    private void set保険給付両方日付管理() {
        ShoriDateKanriManager shoriDateKanriManager = new ShoriDateKanriManager();
        RString 過去報告年月 = div.getTblJikkoTani().getDdlKakoHokokuYM().getSelectedValue();
        RDate 過去報告年月_Date = new RDate(過去報告年月.toString());
        RString 処理枝番1 = new RString("00").concat(new RString(過去報告年月_Date.minusMonth(月).getMonthValue()));
        FlexibleYear 過去報告年月_Year = new FlexibleYear(過去報告年月_Date.seireki().getYear());
        ShoriDateKanri 月報報告_保険給付決定_償還分審査 = shoriDateKanriManager.get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                new RString("月報報告  保険給付決定  償還分審査"), 処理枝番1, 過去報告年月_Year, 年度内連番);
        RString 処理枝番2 = new RString("00").concat(new RString(過去報告年月_Date.minusMonth(2).getMonthValue()));
        ShoriDateKanri 月報報告_保険給付決定_償還分決定 = shoriDateKanriManager.get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                new RString("月報報告  保険給付決定  償還分決定"), 処理枝番2, 過去報告年月_Year, 年度内連番);
        RString 両方日付管理情報 = DbBusinessConfig.get(ConfigNameDBU.事業状況報告_保険給付集計方法, 基準日, SubGyomuCode.DBU介護統計報告);
        if (両方日付管理情報.equals(審査年月)) {
            FlexibleDate 集計年月5審査 = new FlexibleDate(月報報告_保険給付決定_償還分審査.get年度().toDateString()
                    .concat(月報報告_保険給付決定_償還分審査.get処理枝番().substring(2)));
            if (!div.getTxtShukeiYM5().getValue().isEmpty()) {
                div.getTxtShukeiYM5().setReadOnly(false);
                div.getTxtShukeiYM5().setValue(集計年月5審査);
            } else {
                div.getTxtShukeiYM5().setReadOnly(true);
            }
            RDate 処理日付審査 = new RDate(月報報告_保険給付決定_償還分審査.get基準日時().toString());
            div.getTxtSakuseiYMD5().setValue(処理日付審査);
            RTime 処理日時審査 = new RTime(月報報告_保険給付決定_償還分審査.get基準日時().toDateString());
            div.getTxtSakuseiTime5().setValue(処理日時審査);
            FlexibleDate 集計年月5決定 = new FlexibleDate(月報報告_保険給付決定_償還分決定.get年度().toDateString()
                    .concat(月報報告_保険給付決定_償還分決定.get処理枝番().substring(2)));
            div.setTxtShukeiYM5Bak(new RString(集計年月5決定.toString()));
            RDate 処理日付決定 = new RDate(月報報告_保険給付決定_償還分決定.get基準日時().toString());
            div.getTxtSakuseiYMD5().setValue(処理日付決定);
            RTime 処理日時決定 = new RTime(月報報告_保険給付決定_償還分決定.get基準日時().toDateString());
            div.getTxtSakuseiTime5().setValue(処理日時決定);
            div.getRadlblShukeiType5().setSelectedKey(給付審査年月で集計);
        } else if (両方日付管理情報.equals(決定年月)) {
            FlexibleDate 集計年月5決定 = new FlexibleDate(月報報告_保険給付決定_償還分決定.get年度().toDateString()
                    .concat(月報報告_保険給付決定_償還分決定.get処理枝番().substring(2)));
            if (!div.getTxtShukeiYM5().getValue().isEmpty()) {
                div.getTxtShukeiYM5().setReadOnly(false);
                div.getTxtShukeiYM5().setValue(集計年月5決定);
            } else {
                div.getTxtShukeiYM5().setReadOnly(true);
            }
            RDate 処理日付決定 = new RDate(月報報告_保険給付決定_償還分決定.get基準日時().toString());
            div.getTxtSakuseiYMD5().setValue(処理日付決定);
            RTime 処理日時決定 = new RTime(月報報告_保険給付決定_償還分決定.get基準日時().toDateString());
            div.getTxtSakuseiTime5().setValue(処理日時決定);
            FlexibleDate 集計年月5審査 = new FlexibleDate(月報報告_保険給付決定_償還分審査.get年度().toDateString()
                    .concat(月報報告_保険給付決定_償還分審査.get処理枝番().substring(2)));
            div.setTxtShukeiYM5Bak(new RString(集計年月5審査.toString()));
            RDate 処理日付審査 = new RDate(月報報告_保険給付決定_償還分審査.get基準日時().toString());
            div.getTxtSakuseiYMD5().setValue(処理日付審査);
            RTime 処理日時審査 = new RTime(月報報告_保険給付決定_償還分審査.get基準日時().toDateString());
            div.getTxtSakuseiTime5().setValue(処理日時審査);
            div.getRadlblShukeiType5().setSelectedKey(給付決定年月で集計);
        }
        FlexibleDate 集計年月5審査 = new FlexibleDate(月報報告_保険給付決定_償還分審査.get年度().toDateString()
                .concat(月報報告_保険給付決定_償還分審査.get処理枝番().substring(2)));
        if (!div.getTxtShukeiYM5().getValue().isEmpty()) {
            div.getTxtShukeiYM5().setReadOnly(false);
            div.getTxtShukeiYM5().setValue(集計年月5審査);
        } else {
            div.getTxtShukeiYM5().setReadOnly(true);
        }
        RDate 処理日付審査 = new RDate(月報報告_保険給付決定_償還分審査.get基準日時().toString());
        div.getTxtSakuseiYMD5().setValue(処理日付審査);
        RTime 処理日時審査 = new RTime(月報報告_保険給付決定_償還分審査.get基準日時().toDateString());
        div.getTxtSakuseiTime5().setValue(処理日時審査);
        div.setTxtShukeiYM5Bak(RString.EMPTY);
        div.getRadlblShukeiType5().setSelectedKey(給付審査年月で集計);
        FlexibleDate 集計年月5決定 = new FlexibleDate(月報報告_保険給付決定_償還分決定.get年度().toDateString()
                .concat(月報報告_保険給付決定_償還分決定.get処理枝番().substring(2)));
        if (!div.getTxtShukeiYM5().getValue().isEmpty()) {
            div.getTxtShukeiYM5().setReadOnly(false);
            div.getTxtShukeiYM5().setValue(集計年月5決定);
        } else {
            div.getTxtShukeiYM5().setReadOnly(true);
        }
        RDate 処理日付決定 = new RDate(月報報告_保険給付決定_償還分決定.get基準日時().toString());
        div.getTxtSakuseiYMD5().setValue(処理日付決定);
        RTime 処理日時決定 = new RTime(月報報告_保険給付決定_償還分決定.get基準日時().toDateString());
        div.getTxtSakuseiTime5().setValue(処理日時決定);
        div.setTxtShukeiYM5Bak(RString.EMPTY);
        div.getRadlblShukeiType5().setSelectedKey(給付決定年月で集計);
        if (div.getTxtShukeiYM5().getValue().isBefore(new FlexibleDate("平成21年7月"))) {
            div.getTxtShukeiYM5().setDisabled(true);
        } else {
            div.getTxtShukeiYM5().setDisabled(false);
        }
    }

    /**
     * 「月報報告 保険給付決定 高額分」の処理日付管理情報を取得する。
     */
    public void set月報報告_保険給付決定_高額分() {
        ShoriDateKanriManager shoriDateKanriManager = new ShoriDateKanriManager();
        RString 過去報告年月 = div.getTblJikkoTani().getDdlKakoHokokuYM().getSelectedValue();
        RDate 過去報告年月_Date = new RDate(過去報告年月.toString());
        RString 処理枝番 = new RString("00").concat(new RString(過去報告年月_Date.minusMonth(2).getMonthValue()));
        FlexibleYear 過去報告年月_Year = new FlexibleYear(過去報告年月_Date.seireki().getYear());
        ShoriDateKanri 月報報告_保険給付決定_高額分 = shoriDateKanriManager.get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                new RString("月報報告  保険給付決定  高額分"), 処理枝番, 過去報告年月_Year, 年度内連番);
        if (月報報告_保険給付決定_高額分 != null) {
            FlexibleDate 集計年月6テキストボックス = new FlexibleDate(月報報告_保険給付決定_高額分.get年度().toDateString()
                    .concat(月報報告_保険給付決定_高額分.get処理枝番().substring(2)));
            if (!div.getTxtShukeiYM6().getValue().isEmpty()) {
                div.getTxtShukeiYM6().setReadOnly(false);
                div.getTxtShukeiYM6().setValue(集計年月6テキストボックス);
            } else {
                div.getTxtShukeiYM6().setReadOnly(true);
            }
            if (div.getTxtShukeiYM6().getValue().isBefore(new FlexibleDate("平成18年6月"))) {
                div.getTxtShukeiYM6().setDisabled(true);
            } else {
                div.getTxtShukeiYM6().setDisabled(false);
            }
            RDate 処理日付 = new RDate(月報報告_保険給付決定_高額分.get基準日時().toString());
            div.getTxtSakuseiYMD6().setValue(処理日付);
            RTime 処理日時 = new RTime(月報報告_保険給付決定_高額分.get基準日時().toDateString());
            div.getTxtSakuseiTime6().setValue(処理日時);
        }
    }

    /**
     * 「月報報告 保険給付決定 高額合算分」の処理日付管理情報を取得する。
     */
    public void set月報報告_保険給付決定_高額分算分() {
        ShoriDateKanriManager shoriDateKanriManager = new ShoriDateKanriManager();
        RString 過去報告年月 = div.getTblJikkoTani().getDdlKakoHokokuYM().getSelectedValue();
        RDate 過去報告年月_Date = new RDate(過去報告年月.toString());
        RString 処理枝番 = new RString("00").concat(new RString(過去報告年月_Date.minusMonth(2).getMonthValue()));
        FlexibleYear 過去報告年月_Year = new FlexibleYear(過去報告年月_Date.seireki().getYear());
        ShoriDateKanri 月報報告_保険給付決定_高額合算分 = shoriDateKanriManager.get処理日付管理マスタ(SubGyomuCode.DBU介護統計報告,
                new RString("月報報告  保険給付決定  高額合算分"), 処理枝番, 過去報告年月_Year, 年度内連番);
        if (月報報告_保険給付決定_高額合算分 != null) {
            FlexibleDate 集計年月7テキストボックス = new FlexibleDate(月報報告_保険給付決定_高額合算分.get年度().toDateString()
                    .concat(月報報告_保険給付決定_高額合算分.get処理枝番().substring(2)));
            if (!div.getTxtShukeiYM7().getValue().isEmpty()) {
                div.getTxtShukeiYM7().setReadOnly(false);
                div.getTxtShukeiYM7().setValue(集計年月7テキストボックス);
            } else {
                div.getTxtShukeiYM7().setReadOnly(true);
            }
            if (div.getTxtShukeiYM7().getValue().isBefore(new FlexibleDate("平成24年6月"))) {
                div.getTxtShukeiYM7().setDisabled(true);
            } else {
                div.getTxtShukeiYM7().setDisabled(false);
            }
            RDate 処理日付 = new RDate(月報報告_保険給付決定_高額合算分.get基準日時().toString());
            div.getTxtSakuseiYMD7().setValue(処理日付);
            RTime 処理日時 = new RTime(月報報告_保険給付決定_高額合算分.get基準日時().toDateString());
            div.getTxtSakuseiTime7().setValue(処理日時);
        }

    }

    /**
     * すべて選択チェックボックス の処理です。
     */
    public void setすべて選択() {
        List<RString> 一般状況1_11_List = new ArrayList<>();
        List<RString> 一般状況12_14_現物分_List = new ArrayList<>();
        List<RString> 保険給付決定状況_現物分_List = new ArrayList<>();
        List<RString> 一般状況12_14_償還分_List = new ArrayList<>();
        List<RString> 保険給付決定状況_償還分_List = new ArrayList<>();
        List<RString> 保険給付決定状況_高額分_List = new ArrayList<>();
        List<RString> 保険給付決定状況_高額合算分_List = new ArrayList<>();
        if (div.getCblOutputTaishoAll().getSelectedKeys().contains(すべて選択)) {
            一般状況1_11_List.add(一般状況1_11);
            一般状況12_14_現物分_List.add(一般状況12_14_現物分);
            保険給付決定状況_現物分_List.add(保険給付決定状況_現物分);
            一般状況12_14_償還分_List.add(一般状況12_14_償還分);
            保険給付決定状況_償還分_List.add(保険給付決定状況_償還分);
            保険給付決定状況_高額分_List.add(保険給付決定状況_高額分);
            保険給付決定状況_高額合算分_List.add(保険給付決定状況_高額合算分);
            div.getCblOutputTaisho1().setSelectedItemsByKey(一般状況1_11_List);
            div.getCblOutputTaisho2().setSelectedItemsByKey(一般状況12_14_現物分_List);
            div.getCblOutputTaisho3().setSelectedItemsByKey(保険給付決定状況_現物分_List);
            div.getCblOutputTaisho4().setSelectedItemsByKey(一般状況12_14_償還分_List);
            div.getCblOutputTaisho5().setSelectedItemsByKey(保険給付決定状況_償還分_List);
            div.getCblOutputTaisho6().setSelectedItemsByKey(保険給付決定状況_高額分_List);
            div.getCblOutputTaisho7().setSelectedItemsByKey(保険給付決定状況_高額合算分_List);
        } else {
            div.getCblOutputTaisho1().setSelectedItemsByKey(一般状況1_11_List);
            div.getCblOutputTaisho2().setSelectedItemsByKey(一般状況12_14_現物分_List);
            div.getCblOutputTaisho3().setSelectedItemsByKey(保険給付決定状況_現物分_List);
            div.getCblOutputTaisho4().setSelectedItemsByKey(一般状況12_14_償還分_List);
            div.getCblOutputTaisho5().setSelectedItemsByKey(保険給付決定状況_償還分_List);
            div.getCblOutputTaisho6().setSelectedItemsByKey(保険給付決定状況_高額分_List);
            div.getCblOutputTaisho7().setSelectedItemsByKey(保険給付決定状況_高額合算分_List);
        }
    }

    /**
     * 作成日時の設定 の処理です。
     */
    public void set作成日時の設定() {
        if (!div.getCblOutputTaisho1().getSelectedKeys().contains(一般状況1_11)) {
            div.getTxtSakuseiYMD1().setReadOnly(true);
            div.getTxtSakuseiTime1().setReadOnly(true);
        }
        if (!div.getCblOutputTaisho2().getSelectedKeys().contains(一般状況12_14_現物分)) {
            div.getTxtSakuseiYMD2().setReadOnly(true);
            div.getTxtSakuseiTime2().setReadOnly(true);
        }
        if (!div.getCblOutputTaisho3().getSelectedKeys().contains(保険給付決定状況_現物分)) {
            div.getTxtSakuseiYMD3().setReadOnly(true);
            div.getTxtSakuseiTime3().setReadOnly(true);
        }
        if (!div.getCblOutputTaisho6().getSelectedKeys().contains(保険給付決定状況_高額分)) {
            div.getTxtSakuseiYMD6().setReadOnly(true);
            div.getTxtSakuseiTime6().setReadOnly(true);
        }
        if (!div.getCblOutputTaisho7().getSelectedKeys().contains(保険給付決定状況_高額合算分)) {
            div.getTxtSakuseiYMD7().setReadOnly(true);
            div.getTxtSakuseiTime7().setReadOnly(true);
        }
    }

    /**
     * 一般状況12～14【償還分】チェックボックス の　作成日時の設定 の処理の処理です。
     */
    public void set一般状況償還分() {
        if (div.getCblOutputTaisho4().getSelectedKeys().contains(一般状況12_14_償還分)
                && div.getTxtShukeiYM4().getValue() != null
                && !RString.isNullOrEmpty(div.getTxtShukeiYM4Bak())) {
            div.getTxtSakuseiYMD4().setReadOnly(false);
            div.getTxtSakuseiTime4().setReadOnly(false);
            div.getRadlblShukeiType4().setReadOnly(false);
        } else {
            div.getTxtSakuseiYMD4().setReadOnly(true);
            div.getTxtSakuseiTime4().setReadOnly(true);
            div.getRadlblShukeiType4().setReadOnly(true);
        }
    }

    /**
     * 一般状況12～14【償還分】チェックボックス の　作成日時の設定 の処理の処理です。
     */
    public void set保険給付償還分() {
        if (div.getCblOutputTaisho5().getSelectedKeys().contains(保険給付決定状況_償還分)
                && div.getTxtShukeiYM5().getValue() != null
                && !RString.isNullOrEmpty(div.getTxtShukeiYM5Bak())) {
            div.getTxtSakuseiYMD5().setReadOnly(false);
            div.getTxtSakuseiTime5().setReadOnly(false);
            div.getRadlblShukeiType5().setReadOnly(false);
        } else {
            div.getTxtSakuseiYMD5().setReadOnly(true);
            div.getTxtSakuseiTime5().setReadOnly(true);
            div.getRadlblShukeiType5().setReadOnly(true);
        }
    }
}
