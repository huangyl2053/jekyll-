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
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteiidokanendo.HonsanteiIdoKanendoResult;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.KozaFurikaeOutputType;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NotsuKozaShutsuryokuTaisho;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550001.KanendoFukaDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550001.dgChushutsuKikan_Row;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550001.dgShoriKakunin_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.OutputChohyoIchiran.dgOutputChohyoIchiran_Row;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * @reamsid_L DBB-1760-010 quxiaodong
 */
public class KanendoFukaHandler {

    private final KanendoFukaDiv div;
    private static final RString 定値_日時 = new RString("23:59:59");
    private static final RString ZERO_RS = new RString("0");
    private static final RString ONE_RS = new RString("1");
    private static final RString TWO_RS = new RString("2");
    private static final int THREE_RS = 3;
    private final RString 本算定異動_過年度 = new RString("DBBMN45000");
    private final RString 過年度異動通知書作成 = new RString("DBBMN45002");
    private final RString 個人住民税処理状況 = new RString("BbT1901KojinJuminzeiShoriJokyo");
    private final RString 決定通知書の発行日 = new RString("決定通知書の発行日");
    private final RString 変更通知書の発行日 = new RString("変更通知書の発行日");
    private final RString 納入通知書の発行日 = new RString("納入通知書の発行日");
    private final RString 対象者 = new RString("対象者");
    private final RString 通知書チェックボックス = new RString("通知書チェックボックス");
    private final RString 未 = new RString("未");
    private final RString 済 = new RString("済");
    private final RString 実行 = new RString("Element1");
    private static final ReportId 決定変更通知書_帳票分類ID = new ReportId("DBB100039_KaigoHokenHokenryogakuKetteiTsuchishoDaihyo");
    private static final ReportId 納入通知書_帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");

    /**
     * 初期化
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     */
    public KanendoFukaHandler(KanendoFukaDiv div) {
        this.div = div;
    }

    /**
     * 処理対象取得
     *
     * @return 処理対象
     */
    public List<KeyValueDataSource> set処理対象() {
        List<KeyValueDataSource> 処理対象 = new ArrayList<>();
        int 月末の日 = RDate.getNowDate().getLastDay();
        int 日付関連 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBB.日付関連_更正月判定日数,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString());
        int システム日 = RDate.getNowDate().getDayValue();
        if (システム日 < 月末の日 - 日付関連 || RDate.getNowDate().getMonthValue() == THREE_RS) {
            KeyValueDataSource dataSource = new KeyValueDataSource(
                    ONE_RS, Tsuki.toValue(new RString(RDate.getNowDate().getMonthValue())).get名称());
            処理対象.add(dataSource);
        } else {
            KeyValueDataSource dataSource1 = new KeyValueDataSource(
                    ONE_RS, Tsuki.toValue(new RString(RDate.getNowDate().getMonthValue())).get名称());
            KeyValueDataSource dataSource2 = new KeyValueDataSource(
                    TWO_RS, Tsuki.toValue(new RString(RDate.getNowDate().getMonthValue() + 1)).get名称());
            処理対象.add(dataSource1);
            処理対象.add(dataSource2);
        }
        return 処理対象;
    }

    /**
     * 抽出開始日時取得
     *
     * @param shoriDate ShoriDateKanri
     */
    public void set抽出開始日時(ShoriDateKanri shoriDate) {
        RString 前日まで = RDate.getNowDate().minusDay(1).toDateString().
                concat(RDate.getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        int 前月末の日 = RDate.getNowDate().minusMonth(1).getLastDay();
        RString 前月まで = RDate.getNowDate().getYearMonth().minusMonth(1).
                toDateString().concat(String.valueOf(前月末の日)).concat(定値_日時);
        RString 当日を含む = RDate.getNowDate().getYearMonth().
                toDateString().concat(RDate.getNowTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        List<dgChushutsuKikan_Row> rowList = new ArrayList<>();
        dgChushutsuKikan_Row row = new dgChushutsuKikan_Row();
        if (shoriDate != null && shoriDate.get基準日時() != null) {
            RString 年月日 = shoriDate.get基準日時().getRDateTime().getDate().wareki().toDateString();
            RString 時刻 = shoriDate.get基準日時().getRDateTime().getTime().
                    toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            RString 基準日時 = 年月日.concat(時刻);
            row.getTxtChishutsuStNichiji().setValue(基準日時);
        }
        if (div.getKanendoFukaChushutsuJoken().getRadChushutsuJoken().getSelectedKey().equals(ZERO_RS)) {
            row.getTxtChishutsuEdNichiji().setValue(前月まで);
        } else if (div.getKanendoFukaChushutsuJoken().getRadChushutsuJoken().getSelectedKey().equals(ONE_RS)) {
            row.getTxtChishutsuEdNichiji().setValue(前日まで);
        } else if (div.getKanendoFukaChushutsuJoken().getRadChushutsuJoken().getSelectedKey().equals(TWO_RS)) {
            row.getTxtChishutsuEdNichiji().setValue(当日を含む);
        }
        rowList.add(row);
        div.getKanendoFukaChushutsuJoken().getDgChushutsuKikan().setDataSource(rowList);
    }

    /**
     * 処理日付管理マスタ取得
     *
     * @param shdaList List<ShoriDateKanri>
     * @param shoriDate ShoriDateKanri
     */
    public void 処理日付管理マスタ(List<ShoriDateKanri> shdaList, ShoriDateKanri shoriDate) {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        List<dgShoriKakunin_Row> rowList = new ArrayList<>();
        dgShoriKakunin_Row row = new dgShoriKakunin_Row();
        if (本算定異動_過年度.equals(menuID)) {
            row.getTxtShoriMei().setValue(個人住民税処理状況);
            //TODO 処理日時 状況   QA808
        } else if (過年度異動通知書作成.equals(menuID)) {
            RString 処理名 = ShoriName.過年度賦課.get名称();
            row.getTxtShoriMei().setValue(処理名);
            if (shdaList.isEmpty()) {
                row.getTxtJokyo().setValue(未);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(実行, true);
            } else if (!shdaList.isEmpty() && (null == shoriDate.get基準日時() || shoriDate.get基準日時().isEmpty())) {
                row.getTxtJokyo().setValue(未);
                CommonButtonHolder.setDisabledByCommonButtonFieldName(実行, true);
            } else if (!shdaList.isEmpty() && shoriDate.get基準日時() != null && !shoriDate.get基準日時().isEmpty()) {
                RString 年月日 = shoriDate.get基準日時().getRDateTime().getDate().wareki().toDateString();
                RString 時刻 = shoriDate.get基準日時().getRDateTime().getTime().
                        toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
                RString 基準日時 = 年月日.concat(時刻);
                row.getTxtJokyo().setValue(済);
                row.getTxtShoriNichiji().setValue(基準日時);
            }
        }
        rowList.add(row);
        div.getKanendoFukaBatchParameter().getDgShoriKakunin().setDataSource(rowList);
    }

    /**
     * 算定帳票作成
     */
    public void set算定帳票作成() {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();
        if (本算定異動_過年度.equals(menuID)) {
            div.getCcdChohyoIchiran().load(SubGyomuCode.DBB介護賦課, 本算定異動_過年度);
        } else if (過年度異動通知書作成.equals(menuID)) {
            div.getCcdChohyoIchiran().load(SubGyomuCode.DBB介護賦課, 過年度異動通知書作成);
        }
    }

    /**
     * 対象賦課年度取得
     *
     *
     */
    public void set対象賦課年度() {
        List<KeyValueDataSource> 対象賦課年度 = new ArrayList<>();
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
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
     * 帳票作成個別情報取得
     *
     */
    public void set帳票作成個別情報() {
        List<KeyValueDataSource> 対象者 = new ArrayList<>();
        List<KeyValueDataSource> 口座振替者 = new ArrayList<>();
        //TODO 発行日 出力期
        for (NotsuKozaShutsuryokuTaisho notko : NotsuKozaShutsuryokuTaisho.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(notko.getコード(), notko.get名称());
            対象者.add(dataSource);
        }
        div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkNotsuTaishosha().setDataSource(対象者);
        div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchiTaishosha().setDataSource(対象者);
        for (KozaFurikaeOutputType kofu : KozaFurikaeOutputType.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(kofu.getコード(), kofu.get名称());
            口座振替者.add(dataSource);
        }
        div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getRadNotsuKozaShutsuryokuYoshiki().setDataSource(口座振替者);
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
            parameter.set抽出開始日時(new YMDHMS(div.getKanendoFukaChushutsuJoken().getDgChushutsuKikan().
                    getDataSource().get(0).getTxtChishutsuStNichiji().getValue()));
            parameter.set抽出終了日時(new YMDHMS(div.getKanendoFukaChushutsuJoken().getDgChushutsuKikan().
                    getDataSource().get(0).getTxtChishutsuEdNichiji().getValue()));
        }
        List<HonsanteiIdoKanendoResult> hoList = new ArrayList<>();
        for (dgOutputChohyoIchiran_Row row : div.getCcdChohyoIchiran().get出力帳票一覧()) {
            HonsanteiIdoKanendoResult par = new HonsanteiIdoKanendoResult(
                    決定変更通知書_帳票分類ID, row.getChohyoID(), row.getShutsuryokujunID());
            hoList.add(par);
        }
        parameter.set出力帳票一覧(hoList);
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
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getTxtKetteiTsuchiHakkoYMD().getValue() != null) {
            parameter.set決定_発行日(new FlexibleDate(div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                    getTxtKetteiTsuchiHakkoYMD().getValue().toString()));
        }
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
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getTxtHenkoTsuchiHakkoYMD().getValue() != null) {
            parameter.set変更_発行日(new FlexibleDate(div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                    getTxtHenkoTsuchiHakkoYMD().getValue().toString()));
        }
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
        parameter.set変更_対象賦課年度(納入list);
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getTxtHenkoTsuchiHakkoYMD().getValue() != null) {
            parameter.set納入_発行日(new FlexibleDate(div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                    getTxtNotsuHakkoYMD().getValue().toString()));
        }
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getDdlNotsuShutsuryokuKi().getSelectedValue() != null) {
            parameter.set納入_出力期(new FlexibleDate(div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                    getDdlNotsuShutsuryokuKi().getSelectedValue().toString()));
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
        parameter.set納入_生活保護対象者(div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                getRadNotsuSeikatsuHogo().getSelectedKey());
        parameter.set納入_ページごとに山分け(div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().
                getRadNotsuYamawake().getSelectedKey());
        parameter.set一括発行起動フラグ(true);
        return parameter;
    }

    /**
     * 入力チェック
     *
     * @return validPairs
     */
    public ValidationMessageControlPairs 入力チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getTxtKetteiTsuchiHakkoYMD().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 決定通知書の発行日.toString())));
        }
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getTxtHenkoTsuchiHakkoYMD().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 変更通知書の発行日.toString())));
        }
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getTxtNotsuHakkoYMD().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 納入通知書の発行日.toString())));
        }
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkNotsuTaishosha().getSelectedKeys() == null
                || div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkNotsuTaishosha().getSelectedKeys().isEmpty()
                || div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchiTaishosha().getSelectedKeys() == null
                || div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchiTaishosha().getSelectedKeys().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 対象者.toString())));
        }
        if (!div.getKanendoShoriNaiyo().getDdlShoritsuki().getSelectedValue().
                equals(div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getDdlNotsuShutsuryokuKi().getSelectedValue())) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    DbbErrorMessages.賦課処理対象月と通知書出力月の不整合)));
        }
        if (div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkKetteiTsuchi().getSelectedKeys().isEmpty()
                || div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkKetteiTsuchi().getSelectedKeys() == null
                || div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchi().getSelectedKeys().isEmpty()
                || div.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchi().getSelectedKeys() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 通知書チェックボックス.toString())));
        }
        if (div.getCcdChohyoIchiran().getSelected帳票IdAnd出力順Id().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    DbbErrorMessages.帳票ID取得不可のため処理不可)));
        }
        return validPairs;
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

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
