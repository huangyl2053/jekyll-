/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1340001;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc020030.DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcInformationMessages;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcQuestionMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1340001.JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikan;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikanShiten;
import jp.co.ndensan.reams.ua.uax.service.core.kinyukikan.KinyuKikanManager;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.DayOfWeek;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * DBCMNN2004_事業合算・事業分振込明細書作成（一括）のクラスです。
 *
 * @reamsid_L DBC-4870-010 zhouchuanlin
 */
public class JigyobunKogakuGassanFurikomiMeisaishoBatchParamHandler {

    private final JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv div;
    private static final RString 処理名_口座 = new RString("事業高額合算振込明細書作成口座");
    private static final RString 処理名_窓口 = new RString("事業高額合算振込明細書作成窓口");
    private static final RString 窓口 = new RString("窓口");
    private static final RString 口座 = new RString("口座");
    private static final RString ＦＤ作成_1 = new RString("1");
    private static final RString ＦＤ作成_0 = new RString("0");
    private static final RString 全て = new RString("全て");
    private static final RString 振込指定日_MSG = new RString("振込指定日");
    private static final RString 発行済のみ = new RString("発行済のみ");
    private static final RString KEY_1 = new RString("1");
    private static final RString KEY_3 = new RString("3");
    private static final RString 時 = new RString("時");
    private static final RString 分 = new RString("分");
    private static final RString 秒 = new RString("秒");
    private static final int INDEX_0 = 0;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_9 = 9;
    private static final int INDEX_8 = 8;
    private static final ReportId 帳票ID = new ReportId("DBC200003_FurikomiMeisaiIchiran");

    /**
     * コンストラクタです。
     *
     * @param div JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv
     */
    public JigyobunKogakuGassanFurikomiMeisaishoBatchParamHandler(JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドです。
     */
    public void initialize() {
        ShoriDateKanriManager manager = new ShoriDateKanriManager();
        ShoriDateKanri 処理日付管理マスタ = null;
        FlexibleDate 前回対象年月日From = null;
        FlexibleDate 前回対象年月日To = null;
        if (口座.equals(div.getRadSiharaihouhou().getSelectedValue())) {
            処理日付管理マスタ = manager.get前回対象年月日期間(処理名_口座);
        } else if (窓口.equals(div.getRadSiharaihouhou().getSelectedValue())) {
            処理日付管理マスタ = manager.get前回対象年月日期間(処理名_窓口);
        }
        if (処理日付管理マスタ != null) {
            前回対象年月日From = 処理日付管理マスタ.get対象開始年月日();
            前回対象年月日To = 処理日付管理マスタ.get対象終了年月日();
        }
        if (前回対象年月日From != null) {
            div.getTyuusyutuHanni().getTxtZennkaiTaisyouNenngappi().setFromValue(new RDate(前回対象年月日From.toString()));
        }
        if (前回対象年月日To != null) {
            div.getTyuusyutuHanni().getTxtZennkaiTaisyouNenngappi().setToValue(new RDate(前回対象年月日To.toString()));
            div.getTyuusyutuHanni().getTxtKonnkaiTaisyouNenngappi().setFromValue(new RDate((前回対象年月日To.plusDay(1)).toString()));
        } else {
            div.getTyuusyutuHanni().getTxtZennkaiTaisyouNenngappi().setToValue(null);
            div.getTyuusyutuHanni().getTxtKonnkaiTaisyouNenngappi().setFromValue(null);
        }
    }

    /**
     * 取引先金融機関の取得メソッドです。
     */
    public void get取引先金融機関() {
        KinyuKikanManager kinyuKikanManager = KinyuKikanManager.createInstance();
        KinyuKikan 金融機関 = null;
        KinyuKikanShiten 支店 = null;
        RString 金融機関名 = RString.EMPTY;
        RString 支店名 = RString.EMPTY;
        RDate システム日付 = RDate.getNowDate();
        RString 取引先金融機関支店名称 = RString.EMPTY;
        RString 委託者名_1 = DbBusinessConfig.get(ConfigNameDBC.委託者名１, システム日付,
                SubGyomuCode.DBC介護給付);
        RString 委託者名_2 = DbBusinessConfig.get(ConfigNameDBC.委託者名２, システム日付,
                SubGyomuCode.DBC介護給付);
        RString 委託者コード = DbBusinessConfig.get(ConfigNameDBC.委託者コード, システム日付,
                SubGyomuCode.DBC介護給付);
        RString ＦＤ作成 = DbBusinessConfig.get(ConfigNameDBC.ＦＤ作成, システム日付,
                SubGyomuCode.DBC介護給付);
        if (口座.equals(div.getRadSiharaihouhou().getSelectedValue()) && ＦＤ作成_1.equals(ＦＤ作成)) {
            div.getShuturyokuTyouhyou().getChkFDDataSakusei().setDisabled(false);
        } else {
            div.getShuturyokuTyouhyou().getChkFDDataSakusei().setVisible(false);
        }
        div.setFdSakusei(ＦＤ作成);
        RString 委託者名 = 委託者名_1.concat(委託者名_2);
        RString 金融機関コード = DbBusinessConfig.get(ConfigNameDBC.金融機関コード, システム日付,
                SubGyomuCode.DBC介護給付);
        金融機関 = kinyuKikanManager.getValidKinyuKikanOn(new FlexibleDate(システム日付.toString()), 金融機関コード.substring(INDEX_0, INDEX_4));
        if (金融機関 != null) {
            KinyuKikanShitenCode 支店コード = new KinyuKikanShitenCode(金融機関コード.substring(INDEX_5, INDEX_9));
            支店 = 金融機関.get支店(支店コード, new FlexibleDate(システム日付.toString()));
            金融機関名 = 金融機関.get金融機関名称();
        }
        if (支店 != null) {
            支店名 = 支店.get支店名称();
            取引先金融機関支店名称 = 支店.get支店名称();
        }
        RString 取引先金融機関 = 金融機関名.concat(支店名);
        div.getTyuusyutuHanni().getDdlHakkouTaisyou().setSelectedKey(KEY_1);
        div.getShuturyokuTyouhyou().getDdlSyuturyokuTyouhyou().setSelectedKey(KEY_1);
        div.setTorihikiKinyukikanShitennmei(取引先金融機関支店名称);
        div.setItakusya(委託者名);
        div.getTyuusyutuJyoukenn().getTxtItakusya().setValue(委託者名);
        div.getTyuusyutuJyoukenn().getTxtItakusyaCode().setValue(委託者コード);
        div.getTxtTorihikiKinyukikan().setValue(取引先金融機関);
        div.getTyuusyutuHanni().getTxtKonnkaiTaisyouNenngappi().setToValue(システム日付);
        div.getShuturyokuTyouhyou().getTxtSakuseibi().setValue(システム日付);
        div.getShuturyokuTyouhyou().getTxtIraibi().setValue(システム日付);
        div.getShuturyokuTyouhyou().getTxtFurikomiSiteibi().setValue(システム日付);
    }

    /**
     * 支払方法のオンチェンジ事件です。
     *
     * @param div JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv
     */
    public void onChangeRadSiharaihouhou(JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv div) {
        RString ＦＤ作成 = div.getFdSakusei();
        RString 支払方法 = div.getRadSiharaihouhou().getSelectedValue();
        if (ＦＤ作成_1.equals(ＦＤ作成) && 口座.equals(支払方法)) {
            div.getTyuusyutuJyoukenn().getTxtItakusyaCode().setVisible(true);
        } else {
            div.getTyuusyutuJyoukenn().getTxtItakusyaCode().setVisible(false);
        }
        if (口座.equals(支払方法)) {
            div.getTyuusyutuJyoukenn().getTxtItakusya().setValue(div.getItakusya());
            div.getShuturyokuTyouhyou().getDdlSyuturyokuTyouhyou().setDisabled(false);
        } else {
            div.getTyuusyutuJyoukenn().getTxtItakusya().setValue(RString.EMPTY);
            div.getTyuusyutuJyoukenn().getTxtTorihikiKinyukikan().setValue(RString.EMPTY);
            div.getShuturyokuTyouhyou().getDdlSyuturyokuTyouhyou().setSelectedKey(KEY_3);
            div.getShuturyokuTyouhyou().getDdlSyuturyokuTyouhyou().setDisabled(true);
        }
        if (口座.equals(div.getRadSiharaihouhou().getSelectedValue()) && ＦＤ作成_1.equals(ＦＤ作成)) {
            div.getShuturyokuTyouhyou().getChkFDDataSakusei().setDisabled(false);
        } else {
            div.getShuturyokuTyouhyou().getChkFDDataSakusei().setVisible(false);
        }
    }

    /**
     * 発行対象のオンチェンジ事件です。
     *
     * @param div JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv
     */
    public void onChangeDdlHakkouTaisyou(JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv div) {
        if (口座.equals(div.getRadSiharaihouhou().getSelectedValue())) {
            div.getTyuusyutuHanni().getDdlHakkouTaisyou().setDisabled(false);
        } else {
            div.getTyuusyutuHanni().getDdlHakkouTaisyou().setSelectedKey(KEY_1);
            div.getTyuusyutuHanni().getDdlHakkouTaisyou().setDisabled(true);
        }
        if (口座.equals(div.getRadSiharaihouhou().getSelectedValue()) && 発行済のみ.equals(div.getTyuusyutuHanni().getDdlHakkouTaisyou().getSelectedValue())) {
            div.getTyuusyutuHanni().getTxt().setDisabled(false);
        } else {
            div.getTyuusyutuHanni().getTxt().setDisabled(true);
        }
    }

    /**
     * 実行ボタンを押すと、入力チェックのメソッドです。
     *
     * @param div JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv
     * @return ResponseData
     */
    public ResponseData<JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv> checkインフォメーション(JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv div) {
        RDate 振込指定日 = div.getShuturyokuTyouhyou().getTxtFurikomiSiteibi().getValue();
        if (!ResponseHolder.isReRequest()) {
            if (DayOfWeek.SATURDAY.equals(振込指定日.getDayOfWeek())) {
                InformationMessage message = new InformationMessage(
                        DbcInformationMessages.日付_土曜日.getMessage().getCode(),
                        DbcInformationMessages.日付_土曜日.getMessage().replace(
                                振込指定日_MSG.toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            } else if (DayOfWeek.SUNDAY.equals(振込指定日.getDayOfWeek())) {
                InformationMessage message = new InformationMessage(
                        DbcInformationMessages.日付_日曜日.getMessage().getCode(),
                        DbcInformationMessages.日付_日曜日.getMessage().replace(
                                振込指定日_MSG.toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            } else if (振込指定日.isNationalHoliday()) {
                InformationMessage message = new InformationMessage(
                        DbcInformationMessages.日付_祝日.getMessage().getCode(),
                        DbcInformationMessages.日付_祝日.getMessage().replace(
                                振込指定日_MSG.toString()).evaluate());
                return ResponseData.of(div).addMessage(message).respond();
            }
        }
        if (!ResponseHolder.isReRequest() || (isインフォメーションメッセージ()
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes)
                || (is質問() && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes)) {
            return check質問(div);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 前排他キーのセット
     *
     * @return Boolean
     */
    public Boolean 前排他キーのセット() {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        LockingKey 排他キー = new LockingKey(controlData.getMenuID());
        return RealInitialLocker.tryGetLock(排他キー);
    }

    /**
     * 前排他キーの解除
     */
    public void 前排他キーの解除() {
        IUrControlData controlData = UrControlDataFactory.createInstance();
        LockingKey 排他キー = new LockingKey(controlData.getMenuID());
        RealInitialLocker.release(排他キー);
    }

    /**
     * DBCMNN2004_事業合算・事業分振込明細書作成（一括）画面入力するデータより、バッチ用パラメータクラスを作成する。
     *
     * @return PanelBatchParameter
     */
    public DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter creatParameter() {
        // QA#94411
        RString 出力順 = RString.EMPTY;
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder iOutputOrder = finder.get出力順(
                SubGyomuCode.DBC介護給付,
                帳票ID,
                Long.valueOf(div.getCcdChohyoShusuryokujun().get出力順ID().toString()));
        if (iOutputOrder != null) {
            出力順 = MyBatisOrderByClauseCreator.create(null, iOutputOrder);
        }
//        RString 支払方法 = div.getRadSiharaihouhou().getSelectedValue();
        DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter parameter = new DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter();
//        RDate 今回対象年月日From = div.getTyuusyutuHanni().getTxtKonnkaiTaisyouNenngappi().getFromValue();
//        RDate 今回対象年月日To = div.getTyuusyutuHanni().getTxtKonnkaiTaisyouNenngappi().getToValue();
//        RString 出力帳票 = div.getShuturyokuTyouhyou().getDdlSyuturyokuTyouhyou().getSelectedValue();
//        boolean fdDataを作成する = false;
//        RString ＦＤ作成 = div.getFdSakusei();
//        if (ＦＤ作成_1.equals(ＦＤ作成) && 口座.equals(支払方法)
//                && div.getShuturyokuTyouhyou().getChkFDDataSakusei().getSelectedKeys().isEmpty()) {
//            fdDataを作成する = true;
//        }
//        RString 作成日 = format作成日();
//        RDate 依頼日 = div.getShuturyokuTyouhyou().getTxtIraibi().getValue();
//        RDate 振込指定日 = div.getShuturyokuTyouhyou().getTxtFurikomiSiteibi().getValue();
//        RString 発行対象 = div.getTyuusyutuHanni().getDdlHakkouTaisyou().getSelectedValue();
//        RString 取引先金融機関 = div.getTyuusyutuJyoukenn().getTxtTorihikiKinyukikan().getValue();
//        RString 取引先金融機関支店名称 = div.getTorihikiKinyukikanShitennmei();
//        RDate 対象作成年月日 = div.getTyuusyutuHanni().getTxt().getValue();
//        parameter.set支払方法(支払方法);
//        parameter.set今回対象年月日From(今回対象年月日From);
//        parameter.set今回対象年月日To(今回対象年月日To);
//        parameter.set取引先金融機関(取引先金融機関);
//        parameter.set出力帳票(出力帳票);
//        parameter.setFDDataを作成する(fdDataを作成する);
//        parameter.set作成日(作成日);
//        parameter.set依頼日(依頼日);
//        parameter.set振込指定日(振込指定日);
//        parameter.set発行対象(発行対象);
//        parameter.set取引先金融機関支店名称(取引先金融機関支店名称);
//        List<RString> 出力順リスト = new ArrayList<>();
//        出力順リスト.add(出力順);
//        parameter.set出力順設定リスト(出力順リスト);
//        parameter.set対象作成年月日(対象作成年月日);
        return parameter;
    }

    private Boolean isインフォメーションメッセージ() {
        boolean 振込指定日が土曜日Flag = new RString(
                DbcInformationMessages.日付_土曜日.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode());
        boolean 振込指定日が日曜日Flag = new RString(
                DbcInformationMessages.日付_日曜日.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode());
        boolean 振込指定日が祝日Flag = new RString(
                DbcInformationMessages.日付_祝日.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode());
        return 振込指定日が土曜日Flag || 振込指定日が日曜日Flag || 振込指定日が祝日Flag;
    }

    private Boolean is質問() {
        boolean 今回対象年月日From未入力Flag = new RString(
                DbcQuestionMessages.開始年月日未入力_データ全部発行.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode());
        boolean 発行対象DDLは発行済みのみ_全てFlag = new RString(
                DbcQuestionMessages.発行対象は発行済み対象者のみ_全て.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode());
        boolean 口座でFDデータを作成するチェックOFFFlag = new RString(
                DbcQuestionMessages.口座でFDデータを作成するチェックOFF.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode());
        return 今回対象年月日From未入力Flag || 発行対象DDLは発行済みのみ_全てFlag || 口座でFDデータを作成するチェックOFFFlag;
    }

    private ResponseData<JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv> check質問(JigyobunKogakuGassanFurikomiMeisaishoBatchParamDiv div) {
        RString 発行対象 = div.getTyuusyutuHanni().getDdlHakkouTaisyou().getSelectedValue();
        boolean 今回対象年月日From未入力Flag = new RString(
                DbcQuestionMessages.開始年月日未入力_データ全部発行.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode());
        boolean 発行対象DDLは発行済みのみ_全てFlag = new RString(
                DbcQuestionMessages.発行対象は発行済み対象者のみ_全て.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode());
        boolean 口座でFDデータを作成するチェックOFFFlag = new RString(
                DbcQuestionMessages.口座でFDデータを作成するチェックOFF.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode());
        if (!今回対象年月日From未入力Flag
                && !発行対象DDLは発行済みのみ_全てFlag
                && !口座でFDデータを作成するチェックOFFFlag
                && null == div.getTyuusyutuHanni().getTxtKonnkaiTaisyouNenngappi().getFromValue()) {
            return ResponseData.of(div).addMessage(DbcQuestionMessages.開始年月日未入力_データ全部発行.getMessage()).respond();
        }
        if (今回対象年月日From未入力Flag && ResponseHolder.getButtonType() != MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }
        if (!発行対象DDLは発行済みのみ_全てFlag
                && !口座でFDデータを作成するチェックOFFFlag
                && (発行済のみ.equals(発行対象) || 全て.equals(発行対象))) {
            return ResponseData.of(div).addMessage(DbcQuestionMessages.発行対象は発行済み対象者のみ_全て.getMessage()).respond();
        }
        if (発行対象DDLは発行済みのみ_全てFlag && ResponseHolder.getButtonType() != MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }
        if (!口座でFDデータを作成するチェックOFFFlag
                && 口座.equals(div.getRadSiharaihouhou().getSelectedValue())
                && null != div.getShuturyokuTyouhyou().getChkFDDataSakusei()
                && div.getShuturyokuTyouhyou().getChkFDDataSakusei().getSelectedKeys().isEmpty()) {
            return ResponseData.of(div).addMessage(DbcQuestionMessages.口座でFDデータを作成するチェックOFF.getMessage()).respond();
        }
        if (口座でFDデータを作成するチェックOFFFlag && ResponseHolder.getButtonType() != MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).respond();
        }
        return ResponseData.of(div).respond();
    }

    private RString format作成日() {
        RDate date = div.getShuturyokuTyouhyou().getTxtSakuseibi().getValue();
        RTime time = RTime.now();
        RString hour = new RString(time.toString()).substring(INDEX_0, INDEX_2);
        RString min = new RString(time.toString()).substring(INDEX_3, INDEX_5);
        RString sec = new RString(time.toString()).substring(INDEX_6, INDEX_8);
        RString timeFormat = hour.concat(時).concat(min).concat(分).concat(sec).concat(秒);
        RString 作成日 = date.wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString().concat(RString.FULL_SPACE).concat(timeFormat);
        return 作成日;
    }
}
