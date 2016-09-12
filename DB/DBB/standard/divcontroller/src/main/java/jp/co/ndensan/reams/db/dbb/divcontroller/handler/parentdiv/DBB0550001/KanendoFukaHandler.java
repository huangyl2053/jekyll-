/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0550001;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbb.business.core.basic.honsanteiidokanendo.HonsanteiIdoDivParameter;
import jp.co.ndensan.reams.db.dbb.business.core.basic.honsanteiidokanendo.HonsanteiIdoParameter;
import jp.co.ndensan.reams.db.dbb.business.core.tsuchisho.notsu.ShutsuryokuKiKoho;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidogennen.ChohyoResult;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.KozaFurikaeOutputType;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NotsuKozaShutsuryokuTaisho;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550001.KanendoFukaDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550001.dgChushutsuKikan_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550001.dgShoriKakunin_Row;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteiidokanendo.HonsanteiIdoKanendo;
import jp.co.ndensan.reams.db.dbb.service.core.tsuchisho.notsu.ShutsuryokuKiKohoFactory;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * @reamsid_L DBB-0920-010 quxiaodong
 */
public class KanendoFukaHandler {

    private final KanendoFukaDiv div;
    private static final RString コンマ = new RString(".");
    private static final RString 日時 = new RString("235959");
    private static final RString ZERO_RS = new RString("0");
    private static final RString ONE_RS = new RString("1");
    private static final RString TWO_RS = new RString("2");
    private static final RString する = new RString("する");
    private static final RString 全て = new RString("全て");
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private final RString 本算定異動_過年度 = new RString("DBBMN45001");
    private final RString 過年度異動通知書作成 = new RString("DBBMN45002");
    private final RString 過年度実行ボタン = new RString("Element1");
    private final RString 過年度通知書作成実行ボタン = new RString("btnRegister");
    private final RString 過年度 = new RString("DBB0550001");
    private final RString 過年度異動通知書 = new RString("DBB0550003");
    private final RString 個人住民税処理状況 = new RString("BbT1901KojinJuminzeiShoriJokyo");
    private final RString 未 = new RString("未");
    private final RString 済 = new RString("済");
    private static final RString 月分 = new RString("月");
    private static final ReportId 決定変更通知書_帳票分類ID = new ReportId("DBB100039_KaigoHokenHokenryogakuKetteiTsuchishoDaihyo");
    private static final ReportId 納入通知書_帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");
    private static final RString 決定変更通知書 = new RString("DBB100039_KaigoHokenHokenryogakuKetteiTsuchishoDaihyo");
    private static final RString 納入通知書 = new RString("DBB100045_HokenryoNonyuTsuchishoDaihyo");

    /**
     * 初期化
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     */
    public KanendoFukaHandler(KanendoFukaDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドます。
     *
     * @param 調定年度 FlexibleYear
     * @param shdaList List<ShoriDateKanri>
     * @param shoriDate3 ShoriDateKanri
     * @return flag
     */
    public boolean initialize(FlexibleYear 調定年度, List<ShoriDateKanri> shdaList, ShoriDateKanri shoriDate3) {
        set処理対象();
        div.getKanendoShoriNaiyo().getTxtChoteiNendo().setDomain(new RYear(調定年度.toString()));
        set抽出開始日時と終了日時(shoriDate3);
        set算定帳票作成();
        set対象賦課年度();
        set帳票作成個別情報();
        List<KeyValueDataSource> 対象者 = new ArrayList<>();
        List<KeyValueDataSource> 口座振替者 = new ArrayList<>();
        for (NotsuKozaShutsuryokuTaisho notko : NotsuKozaShutsuryokuTaisho.values()) {
            if (!notko.get名称().equals(全て)) {
                KeyValueDataSource dataSource = new KeyValueDataSource(notko.getコード(), notko.get名称());
                対象者.add(dataSource);
            }
        }
        div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkNotsuTaishosha().setDataSource(対象者);
        div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchiTaishosha().setDataSource(対象者);
        for (KozaFurikaeOutputType kofu : KozaFurikaeOutputType.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(kofu.getコード(), kofu.get名称());
            口座振替者.add(dataSource);
        }
        div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getRadNotsuKozaShutsuryokuYoshiki().setDataSource(口座振替者);
        return 処理日付管理マスタ(shdaList);
    }

    private void set処理対象() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        RDate date = RDate.getNowDate();
        int 境界日付 = date.getLastDay() - Integer.valueOf(DbBusinessConfig.get(
                ConfigNameDBB.日付関連_更正月判定日数, date, SubGyomuCode.DBB介護賦課).toString());
        int 日 = date.getDayValue();
        RString 属する月 = new RString(String.valueOf(date.getMonthValue()));
        dataSource.add(new KeyValueDataSource(属する月.padZeroToLeft(NUM_2), 属する月.concat(月分)));
        if (日 < 境界日付 || date.getMonthValue() == NUM_3) {
            div.getKanendoShoriNaiyo().getDdlShoritsuki().setDataSource(dataSource);
            div.getKanendoShoriNaiyo().getDdlShoritsuki().setSelectedKey(属する月.padZeroToLeft(NUM_2));
        } else {
            RString 翌月 = new RString(String.valueOf(date.plusMonth(NUM_1).getMonthValue()));
            dataSource.add(new KeyValueDataSource(翌月.padZeroToLeft(NUM_2), 翌月.concat(月分)));
            div.getKanendoShoriNaiyo().getDdlShoritsuki().setDataSource(dataSource);
            div.getKanendoShoriNaiyo().getDdlShoritsuki().setSelectedKey(翌月.padZeroToLeft(NUM_2));
        }
    }

    /**
     * 抽出開始日時と終了日時
     *
     * @param shoriDate ShoriDateKanri
     */
    public void set抽出開始日時と終了日時(ShoriDateKanri shoriDate) {
        RString 前日まで = RDate.getNowDate().minusDay(1).wareki().toDateString().concat(RString.HALF_SPACE).
                concat(RDate.getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        int 前月末の日 = RDate.getNowDate().minusMonth(1).getLastDay();
        RString 前月まで = RDate.getNowDate().getYearMonth().minusMonth(1).wareki().
                toDateString().concat(コンマ).concat(String.valueOf(前月末の日)).concat(RString.HALF_SPACE).concat(
                        RDate.getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        RString 当日を含む = RDate.getNowDate().wareki().
                toDateString().concat(RString.HALF_SPACE).concat(
                        RDate.getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        List<dgChushutsuKikan_Row> rowList = new ArrayList<>();
        dgChushutsuKikan_Row row = new dgChushutsuKikan_Row();
        if (shoriDate != null && shoriDate.get基準日時() != null) {
            RString 年月日 = shoriDate.get基準日時().getRDateTime().getDate().wareki().toDateString();
            RString 時刻 = shoriDate.get基準日時().getRDateTime().getTime().
                    toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            RString 基準日時 = 年月日.concat(RString.HALF_SPACE).concat(時刻);
            row.getTxtChishutsuStNichiji().setValue(基準日時);
            row.getTxtChushutsuStYMD().setValue(shoriDate.get基準日時().getRDateTime().getDate());
            row.getTxtChushutsuStTime().setValue(shoriDate.get基準日時().getRDateTime().getTime());
        }
        if (div.getKanendoFukaChushutsuJoken().getRadChushutsuJoken().getSelectedKey().equals(ZERO_RS)) {
            row.getTxtChishutsuEdNichiji().setValue(前月まで);
            row.getTxtChushutsuEdYMD().setValue(new RDate(RDate.getNowDate().
                    getYearMonth().minusMonth(1).toDateString().concat(String.valueOf(前月末の日)).toString()));
            row.getTxtChushutsuEdTime().setValue(new RTime(日時));
        } else if (div.getKanendoFukaChushutsuJoken().getRadChushutsuJoken().getSelectedKey().equals(ONE_RS)) {
            row.getTxtChishutsuEdNichiji().setValue(前日まで);
            row.getTxtChushutsuEdYMD().setValue(RDate.getNowDate().minusDay(1));
            row.getTxtChushutsuEdTime().setValue(RDate.getNowTime());
        } else if (div.getKanendoFukaChushutsuJoken().getRadChushutsuJoken().getSelectedKey().equals(TWO_RS)) {
            row.getTxtChishutsuEdNichiji().setValue(当日を含む);
            row.getTxtChushutsuEdYMD().setValue(RDate.getNowDate());
            row.getTxtChushutsuEdTime().setValue(RDate.getNowTime());
        }

        rowList.add(row);
        div.getKanendoFukaChushutsuJoken().getDgChushutsuKikan().setDataSource(rowList);
    }

    private boolean 処理日付管理マスタ(List<ShoriDateKanri> shdaList) {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        List<dgShoriKakunin_Row> rowList = new ArrayList<>();
        dgShoriKakunin_Row row = new dgShoriKakunin_Row();
        boolean flag = false;
        if (本算定異動_過年度.equals(menuID)) {
            row.getTxtShoriMei().setValue(個人住民税処理状況);
            //TODO 処理日時 状況   QA808
        } else if (過年度異動通知書作成.equals(menuID)) {
            RString 処理名 = ShoriName.過年度賦課.get名称();
            row.getTxtShoriMei().setValue(処理名);
            if (shdaList.isEmpty()) {
                row.getTxtJokyo().setValue(未);
                flag = true;
            } else if (!shdaList.isEmpty() && (null == shdaList.get(0).get基準日時()
                    || shdaList.get(0).get基準日時().isEmpty())) {
                row.getTxtJokyo().setValue(未);
                flag = true;
            } else if (!shdaList.isEmpty() && shdaList.get(0).get基準日時() != null
                    && !shdaList.get(0).get基準日時().isEmpty()) {
                RString 年月日 = shdaList.get(0).get基準日時().getRDateTime().getDate().wareki().toDateString();
                RString 時刻 = shdaList.get(0).get基準日時().getRDateTime().getTime().
                        toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
                RString 基準日時 = 年月日.concat(RString.HALF_SPACE).concat(時刻);
                row.getTxtJokyo().setValue(済);
                row.getTxtShoriNichiji().setValue(基準日時);
            }
        }
        rowList.add(row);
        div.getKanendoFukaBatchParameter().getDgShoriKakunin().setDataSource(rowList);
        return flag;
    }

    private void set算定帳票作成() {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        if (本算定異動_過年度.equals(menuID)) {
            div.getKanendoFukaChohyoHakko().getCcdChohyoIchiran().load(SubGyomuCode.DBB介護賦課, 過年度);
        } else if (過年度異動通知書作成.equals(menuID)) {
            div.getKanendoFukaChohyoHakko().getCcdChohyoIchiran().load(SubGyomuCode.DBB介護賦課, 過年度異動通知書);
        }
    }

    private void set対象賦課年度() {
        List<KeyValueDataSource> 対象賦課年度 = new ArrayList<>();
        RString 調定年度 = DbBusinessConfig.get(
                ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        int 賦課年度1 = Integer.parseInt(調定年度.toString()) - 1;
        int 賦課年度2 = Integer.parseInt(調定年度.toString()) - 2;
        KeyValueDataSource dataSource1 = new KeyValueDataSource(ZERO_RS, new RString(賦課年度1));
        KeyValueDataSource dataSource2 = new KeyValueDataSource(ONE_RS, new RString(賦課年度2));
        対象賦課年度.add(dataSource1);
        対象賦課年度.add(dataSource2);
        div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkKetteiTsuchiTaishoNendo().setDataSource(対象賦課年度);
        div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchiTaishoFukaNendo().setDataSource(対象賦課年度);
        div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkNotsuTaishoFukaNedno().setDataSource(対象賦課年度);
    }

    /**
     * set帳票作成個別情報
     */
    public void set帳票作成個別情報() {
        try {
            FuchoKiUtil util = new FuchoKiUtil();
            KitsukiList 期月リスト = util.get期月リスト();
            Kitsuki 月の期 = 期月リスト.get月の期(Tsuki.toValue((div.getKanendoShoriNaiyo().
                    getDdlShoritsuki().getSelectedKey())));
            List<HonsanteiIdoParameter> hoList = get各通知書の帳票ID();
            FlexibleYear 調定年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                    RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString());
            List<ChohyoResult> 帳票IDList = HonsanteiIdoKanendo.
                    createInstance().getChohyoID(調定年度, new RString(月の期.get期AsInt()), hoList, ZERO_RS);
            List<ShutsuryokuKiKoho> 出力期;
            ShutsuryokuKiKohoFactory kohoFactory = new ShutsuryokuKiKohoFactory(調定年度);
            RString 算定期 = 月の期.get期();
            if (帳票IDList != null) {
                boolean flag = false;
                for (ChohyoResult result : 帳票IDList) {
                    if (納入通知書.equals(result.get帳票ID())) {
                        flag = true;
                    }
                }
                出力期 = kohoFactory.create出力期候補(flag, 算定期);
            } else {
                出力期 = kohoFactory.create出力期候補(false, 算定期);
            }
            List<KeyValueDataSource> dataSource = new ArrayList<>();
            for (ShutsuryokuKiKoho entity : 出力期) {
                if (div.getKanendoShoriNaiyo().getDdlShoritsuki().
                        getSelectedKey().equals(entity.get期月().get月().getコード())) {
                    dataSource.add(new KeyValueDataSource(entity.get期月().get月().getコード(), entity.get表示文字列()));
                    div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getDdlNotsuShutsuryokuKi().setDataSource(dataSource);
                    div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                            getDdlNotsuShutsuryokuKi().setSelectedKey(div.getKanendoShoriNaiyo().getDdlShoritsuki().
                                    getSelectedKey());
                }
            }
            div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getDdlNotsuShutsuryokuKi().setDisabled(true);
        } catch (ApplicationException e) {
            throw new ApplicationException(DbbErrorMessages.帳票ID取得不可のため処理不可.getMessage());
        }
    }

    /**
     * バッチパラメータの設定
     *
     * @return HonsanteiIdoDivParameter
     */
    public HonsanteiIdoDivParameter setBatchParam() {
        HonsanteiIdoDivParameter parameter = new HonsanteiIdoDivParameter();
        FlexibleYear 調定年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString());
        parameter.set調定年度(調定年度);
        parameter.set処理対象(div.getKanendoShoriNaiyo().getDdlShoritsuki().getSelectedValue());
        if (!div.getKanendoFukaChushutsuJoken().getDgChushutsuKikan().getDataSource().isEmpty()
                && div.getKanendoFukaChushutsuJoken().getDgChushutsuKikan().
                getDataSource().get(0).getTxtChishutsuStNichiji().getValue() != null
                && div.getKanendoFukaChushutsuJoken().getDgChushutsuKikan().
                getDataSource().get(0).getTxtChishutsuEdNichiji().getValue() != null) {
            YMDHMS 抽出開始日時 = new YMDHMS(div.getKanendoFukaChushutsuJoken().getDgChushutsuKikan().
                    getDataSource().get(0).getTxtChushutsuStYMD().getValue(),
                    div.getKanendoFukaChushutsuJoken().getDgChushutsuKikan().
                    getDataSource().get(0).getTxtChushutsuStTime().getValue());
            YMDHMS 抽出終了日時 = new YMDHMS(div.getKanendoFukaChushutsuJoken().getDgChushutsuKikan().
                    getDataSource().get(0).getTxtChushutsuEdYMD().getValue(),
                    div.getKanendoFukaChushutsuJoken().getDgChushutsuKikan().
                    getDataSource().get(0).getTxtChushutsuEdTime().getValue());
            parameter.set抽出開始日時(抽出開始日時);
            parameter.set抽出終了日時(抽出終了日時);
        }
        List<HonsanteiIdoParameter> 出力帳票一覧 = new ArrayList<>();
        Map<RString, RString> rowMap = div.getCcdChohyoIchiran().getSelected帳票IdAnd出力順Id();
        HonsanteiIdoParameter chohyoMeter;
        Set<Map.Entry<RString, RString>> set = rowMap.entrySet();
        for (Map.Entry<RString, RString> entry : set) {
            chohyoMeter = new HonsanteiIdoParameter();
            chohyoMeter.set帳票分類ID(new ReportId(entry.getKey()));
            chohyoMeter.set出力順ID(entry.getValue());
            出力帳票一覧.add(chohyoMeter);
        }
        parameter.set出力帳票一覧(出力帳票一覧);
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkKetteiTsuchi().isAllSelected()) {
            parameter.set決定_チェックボックス(ONE_RS);
        } else {
            parameter.set決定_チェックボックス(ZERO_RS);
        }
        List<FlexibleYear> 決定list = new ArrayList<>();
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkKetteiTsuchiTaishoNendo().isAllSelected()) {
            決定list.add(調定年度.minusYear(1));
            決定list.add(調定年度.minusYear(2));
        } else if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkKetteiTsuchiTaishoNendo().
                getSelectedKeys().contains(ZERO_RS)) {
            決定list.add(調定年度.minusYear(1));
            決定list.add(FlexibleYear.EMPTY);
        } else if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkKetteiTsuchiTaishoNendo().
                getSelectedKeys().contains(ONE_RS)) {
            決定list.add(FlexibleYear.EMPTY);
            決定list.add(調定年度.minusYear(2));
        }
        parameter.set決定_対象賦課年度(決定list);
        parameter.set決定_文書番号(div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                getCcdBunshoBangoKetteiTsuchi().get文書番号());
        parameter.set決定_発行日(div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                getTxtKetteiTsuchiHakkoYMD().getValue());
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchi().isAllSelected()) {
            parameter.set変更_チェックボックス(ONE_RS);
        } else {
            parameter.set変更_チェックボックス(ZERO_RS);
        }
        List<FlexibleYear> 変更list = new ArrayList<>();
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchiTaishoFukaNendo().isAllSelected()) {
            変更list.add(調定年度.minusYear(1));
            変更list.add(調定年度.minusYear(2));
        } else if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchiTaishoFukaNendo().
                getSelectedKeys().contains(ZERO_RS)) {
            変更list.add(調定年度.minusYear(1));
            変更list.add(FlexibleYear.EMPTY);
        } else if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchiTaishoFukaNendo().
                getSelectedKeys().contains(ONE_RS)) {
            変更list.add(FlexibleYear.EMPTY);
            変更list.add(調定年度.minusYear(2));
        }
        parameter.set変更_対象賦課年度(変更list);
        parameter.set変更_発行日(div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                getTxtHenkoTsuchiHakkoYMD().getValue());
        parameter.set変更_文書番号(div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                getCcdBunshoBangoHenkoTsuchi().get文書番号());
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchiTaishosha().isAllSelected()) {
            parameter.set変更_対象者(TWO_RS);
        } else if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchiTaishosha().
                getSelectedKeys().contains(ZERO_RS)) {
            parameter.set変更_対象者(ZERO_RS);
        } else if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchiTaishosha().
                getSelectedKeys().contains(ONE_RS)) {
            parameter.set変更_対象者(ONE_RS);
        }
        return setBatchParam2(parameter);
    }

    private HonsanteiIdoDivParameter setBatchParam2(HonsanteiIdoDivParameter parameter) {
        FlexibleYear 調定年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString());
        List<FlexibleYear> 納入list = new ArrayList<>();
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkNotsuTaishoFukaNedno().isAllSelected()) {
            納入list.add(調定年度.minusYear(1));
            納入list.add(調定年度.minusYear(2));
        } else if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkNotsuTaishoFukaNedno().
                getSelectedKeys().contains(ZERO_RS)) {
            納入list.add(調定年度.minusYear(1));
            納入list.add(FlexibleYear.EMPTY);
        } else if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkNotsuTaishoFukaNedno().
                getSelectedKeys().contains(ONE_RS)) {
            納入list.add(FlexibleYear.EMPTY);
            納入list.add(調定年度.minusYear(2));
        }
        parameter.set納入_対象賦課年度(納入list);
        parameter.set納入_発行日(div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                getTxtNotsuHakkoYMD().getValue());
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getDdlNotsuShutsuryokuKi().getSelectedKey() != null) {
            parameter.set納入_出力期(div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                    getDdlNotsuShutsuryokuKi().getSelectedKey());
        }
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkNotsuTaishosha().isAllSelected()) {
            parameter.set納入_対象者(TWO_RS);
        } else if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkNotsuTaishosha().
                getSelectedKeys().contains(ZERO_RS)) {
            parameter.set納入_対象者(ZERO_RS);
        } else if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkNotsuTaishosha().
                getSelectedKeys().contains(ONE_RS)) {
            parameter.set納入_対象者(ONE_RS);
        }
        parameter.set納入_口座振替様式(div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                getRadNotsuKozaShutsuryokuYoshiki().getSelectedKey());
        if (する.equals(div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                getRadNotsuSeikatsuHogo().getSelectedValue())) {
            parameter.set納入_生活保護対象者(ONE_RS);
        } else {
            parameter.set納入_生活保護対象者(ZERO_RS);
        }
        if (する.equals(div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                getRadNotsuYamawake().getSelectedValue())) {
            parameter.set納入_ページごとに山分け(ZERO_RS);
        } else {
            parameter.set納入_ページごとに山分け(ONE_RS);
        }
        Map<RString, RString> rowMap = div.getCcdChohyoIchiran().getSelected帳票IdAnd出力順Id();
        Set<Map.Entry<RString, RString>> set = rowMap.entrySet();
        boolean 納入通知書Flag = false;
        for (Map.Entry<RString, RString> entry : set) {
            if (納入通知書.equals(entry.getKey())) {
                納入通知書Flag = true;
            }
        }
        if (過年度異動通知書作成.equals(ResponseHolder.getMenuID())
                || (納入通知書Flag && 本算定異動_過年度.equals(ResponseHolder.getMenuID()))) {
            parameter.set一括発行起動フラグ(true);
        } else {
            parameter.set一括発行起動フラグ(false);
        }
        FuchoKiUtil util = new FuchoKiUtil();
        KitsukiList 期月リスト = util.get期月リスト();
        Kitsuki 月の期 = 期月リスト.get月の期(Tsuki.toValue((div.getKanendoShoriNaiyo().
                getDdlShoritsuki().getSelectedKey())));
        RString 算定期 = 月の期.get期();
        parameter.set算定期(算定期);
        return parameter;
    }

    /**
     * get各通知書の帳票ID
     *
     * @return List<HonsanteiIdoParameter>
     */
    public List<HonsanteiIdoParameter> get各通知書の帳票ID() {
        Map<RString, RString> rowMap = div.getCcdChohyoIchiran().getSelected帳票IdAnd出力順Id();
        List<HonsanteiIdoParameter> 出力帳票一覧 = new ArrayList<>();
        HonsanteiIdoParameter chohyoMeter;
        Set<Map.Entry<RString, RString>> set = rowMap.entrySet();
        for (Map.Entry<RString, RString> entry : set) {
            chohyoMeter = new HonsanteiIdoParameter();
            if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkKetteiTsuchi().isAllSelected()
                    || div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchi().isAllSelected()) {
                chohyoMeter.set帳票分類ID(決定変更通知書_帳票分類ID);
            } else {
                chohyoMeter.set帳票分類ID(納入通知書_帳票分類ID);
            }
            chohyoMeter.set出力順ID(entry.getValue());
            出力帳票一覧.add(chohyoMeter);
        }
        return 出力帳票一覧;
    }

    /**
     * 実行ボタン状態の設定する。
     *
     * @param flag 実行ボタンの活性と不活性flag
     */
    public void set実行ボタン(boolean flag) {
        RString メニューID = ResponseHolder.getMenuID();
        if (本算定異動_過年度.equals(メニューID)) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(過年度実行ボタン, flag);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(過年度通知書作成実行ボタン, flag);
        }
    }

    /**
     * 入力チェックのメソッドです。
     *
     * @return ResponseData
     */
    public ValidationMessageControlPairs getCheckMessage() {
        Map<RString, RString> rowMap = div.getCcdChohyoIchiran().getSelected帳票IdAnd出力順Id();
        Set<Map.Entry<RString, RString>> set = rowMap.entrySet();
        boolean 決定変更通知書Flag = false;
        boolean 納入通知書Flag = false;
        for (Map.Entry<RString, RString> entry : set) {
            if (決定変更通知書.equals(entry.getKey())) {
                決定変更通知書Flag = true;
            }
            if (納入通知書.equals(entry.getKey())) {
                納入通知書Flag = true;
            }
        }
        KanendoFukaValidationHandler validation = new KanendoFukaValidationHandler(div);
        return validation.check実行(決定変更通知書Flag, 納入通知書Flag);
    }
}
