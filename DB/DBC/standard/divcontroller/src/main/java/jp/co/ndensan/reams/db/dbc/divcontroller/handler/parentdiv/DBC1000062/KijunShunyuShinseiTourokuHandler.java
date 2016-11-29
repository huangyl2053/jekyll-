/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1000062;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KijunShunyugakuTekiyoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KijunShunyugakuTekiyoKanriBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugaku.KijunShunyuShinseiDate;
import jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugaku.KijunShunyugakuDate;
import jp.co.ndensan.reams.db.dbc.definition.core.juryoininbarai.SanteiKijungaku;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000062.DBC1000062TransitionEventName;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000062.KijunShunyuShinseiTourokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000062.dgIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000062.dgMeisai_Row;
import jp.co.ndensan.reams.db.dbc.service.core.kijunshunyugaku.KijunShunyuShinseiTourokuManager;
import jp.co.ndensan.reams.db.dbc.service.core.kyufutsuchisakuseiikatu.HihokenshaDaichoAliveManager;
import jp.co.ndensan.reams.db.dbx.business.core.view.HihokenshaDaichoAlive;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku;
import jp.co.ndensan.reams.db.dbz.business.core.view.KaigoShotokuAlive;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.SetaiKazeiKubun;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.db.dbz.service.core.setai.SetaiinFinder;
import jp.co.ndensan.reams.db.dbz.service.core.setaiinshotokujoho.SetaiinShotokuJohoFinder;
import jp.co.ndensan.reams.db.dbz.service.core.view.ShotokuManager;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojins;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.IShikibetsuTaishoFinder;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.definition.core.memo.MemoShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.ur.urz.divcontroller.controller.commonchilddiv.memo.MemoNyuryoku.MemoNyuryokuHandler;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.exclusion.LockingKey;
import jp.co.ndensan.reams.uz.uza.exclusion.RealInitialLocker;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Width;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * DBC1000062_基準収入額適用申請登録のハンドラクラスです。
 *
 * @reamsid_L DBC-4620-010 wangkanglei
 */
public class KijunShunyuShinseiTourokuHandler {

    private final KijunShunyuShinseiTourokuDiv div;
    private static final RString KEY_被保険者番号 = new RString("被保険者番号");
    private static final RString MESSAGE_被保険者 = new RString("被保険者として登録されていない");
    private static final RString MESSAGE_処理 = new RString("処理");
    private static final RString KEY_受給 = new RString("受給");
    private static final RString KEY_事業対象 = new RString("事業対象");
    private static final RString KEY_HMS = new RString("000000");
    private static final RString KEY_年度 = new RString("年度");
    private static final RString KEY_月日 = new RString("1231");
    private static final RString KEY_追加 = new RString("追加");
    private static final RString KEY_修正 = new RString("修正");
    private static final RString KEY_削除 = new RString("削除");
    private static final RString KEY_1号 = new RString("1");
    private static final RString 歳_16 = new RString("16");
    private static final RString 歳_18 = new RString("18");
    private static final RString 歳_65 = new RString("65");
    private static final RString 区分_本人 = new RString("1");
    private static final RString 世帯主 = new RString("世帯主");
    private static final RString 識別対象区分 = new RString("個人");
    private static final RString KEY_未満人数 = new RString("未満人数");
    private static final RString KEY_以上人数 = new RString("以上人数");
    private static final RString MESSAGE_登録されている住民 = new RString("xxxx時点で登録されている住民");
    private static final RString MESSAGE_識別コード = new RString("識別コード：xxxxは既に登録されている住民");
    private static final RString MESSAGE_XXXX = new RString("xxxx");
    private static final RString MESSAGE_世帯課税区分 = new RString("世帯課税区分が「非課税」の");
    private static final RString MESSAGE_登録 = new RString("登録");
    private static final RString MESSAGE_世帯員に第１号被保険者 = new RString("世帯員に第１号被保険者が存在しない。"
            + "または受給者・事業対象者として登録されていない");
    private static final RString MESSAGE_世帯員を表示 = new RString("世帯員を表示");
    private static final Decimal 円_38万 = new Decimal(380000);
    private static final Decimal 円_33万 = new Decimal(330000);
    private static final Decimal 円_12万 = new Decimal(120000);
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_4 = 4;
    private static final int NUM_6 = 6;
    private static final RString 照会モード = new RString("0");
    private static final RString 追加モード = new RString("1");
    private static final RString 世帯再算出フラグ_0 = new RString("0");
    private static final RString 世帯再算出フラグ_1 = new RString("1");
    private static final RString 改行 = new RString("<br>");
    private static final RString KEY_円 = new RString("円");
    private static final RString DBCHIHOKENSHANO = new RString("DBCHihokenshaNo");
    private static final RString 業務固有の識別情報名称 = new RString("業務固有の識別情報");
    private static final Code 業務固有 = new Code("0003");
    private static final RString 保存するボタン = new RString("btnCommonUpdate");
    private static final RString コンマ = new RString(",");
    private static final RString メモ = new RString("memo");
    private static final RString 識別対象コード = new RString("shikibetsuCode");
    private static final int 歳以上_65 = 65;
    private static final Decimal 円_145万 = new Decimal("1450000");
    private static final Decimal 円_383万 = new Decimal("3830000");
    private static final Decimal 円_520万 = new Decimal("5200000");
    private static final RString 日付_1231 = new RString("1231");

    /**
     * コンストラクタです。
     *
     * @param div 画面Div
     */
    public KijunShunyuShinseiTourokuHandler(KijunShunyuShinseiTourokuDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面Div
     * @return ハンドラ
     */
    public static KijunShunyuShinseiTourokuHandler of(KijunShunyuShinseiTourokuDiv div) {
        return new KijunShunyuShinseiTourokuHandler(div);
    }

    /**
     * 画面のdataSourceの設定のメソッドです。
     */
    public void set画面のdataSource() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(SanteiKijungaku.算定基準額_37_200円.getコード(),
                SanteiKijungaku.算定基準額_37_200円.get略称()));
        dataSource.add(new KeyValueDataSource(SanteiKijungaku.算定基準額_44_400円.getコード(),
                SanteiKijungaku.算定基準額_44_400円.get略称()));
        div.getMeisai().getDdlSanteiKijunGaku().setDataSource(dataSource);
    }

    /**
     * 保存するボタン制御
     *
     */
    public void set保存するボタンDisabled() {
        if (div.getDgIchiran().getDataSource().isEmpty() || !is入力()) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存するボタン, true);
        } else {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存するボタン, false);
        }
    }

    /**
     * 画面初期化のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param 世帯コード SetaiCode
     * @return 基準収入額適用管理情報
     */
    public Map<RString, List<KijunShunyugakuTekiyoKanri>> initialize(HihokenshaNo 被保険者番号,
            ShikibetsuCode 識別コード,
            SetaiCode 世帯コード) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(KEY_被保険者番号.toString(), 被保険者番号);
        HihokenshaDaicho 被保険者台帳 = KijunShunyuShinseiTourokuManager.createInstance().get被保険者台帳(parameter);
        Map<RString, List<KijunShunyugakuTekiyoKanri>> 基準収入Map = new HashMap<>();
        if (被保険者台帳 == null) {
            throw new ApplicationException(DbzErrorMessages.実行不可.getMessage().replace(
                    MESSAGE_被保険者.toString(), MESSAGE_処理.toString()));
        } else if (被保険者台帳.is論理削除フラグ()) {
            throw new ApplicationException(DbzErrorMessages.実行不可.getMessage().replace(
                    MESSAGE_被保険者.toString(), MESSAGE_処理.toString()));
        } else {
            div.getIchiran().getCcdKaigoAtenaInfo().initialize(識別コード);
            List<KijunShunyugakuTekiyoKanri> 基準収入額適用管理情報List = KijunShunyuShinseiTourokuManager
                    .createInstance().get基準収入額適用管理情報(被保険者番号, 世帯コード);

            List<dgIchiran_Row> rowList = new ArrayList<>();
            dgIchiran_Row row;
            SetaiCode 管理情報世帯コード;
            FlexibleYear 管理情報年度;
            int 管理情報履歴番号;
            for (KijunShunyugakuTekiyoKanri 管理情報 : 基準収入額適用管理情報List) {
                row = new dgIchiran_Row();
                管理情報世帯コード = 管理情報.get世帯コード();
                管理情報年度 = 管理情報.get年度();
                管理情報履歴番号 = 管理情報.get履歴番号();
                List<KijunShunyugakuTekiyoKanri> 基準収入額適用管理情報明細List = KijunShunyuShinseiTourokuManager
                        .createInstance().get基準収入額適用管理情報BY世帯コード(管理情報世帯コード, 管理情報年度, 管理情報履歴番号);
                RString key = 管理情報世帯コード.value().concat(getWarekiYear(管理情報年度)).concat(new RString(管理情報履歴番号).padLeft("0", NUM_4));
                基準収入Map.put(key, 基準収入額適用管理情報明細List);
                List<KijunShunyuShinseiDate> 基準収入額データList = get基準収入額データ(管理情報, 基準収入額適用管理情報明細List);
                rowList.add(set画面の初期化項目(管理情報, row, 基準収入額データList));
            }
            div.getIchiran().getDgIchiran().setDataSource(rowList);
        }
        div.getIchiran().setDisabled(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存するボタン, false);
        AccessLogger.log(AccessLogType.照会, toPersonalData(識別コード, 被保険者番号.getColumnValue()));
        return 基準収入Map;
    }

    private dgIchiran_Row set画面の初期化項目(KijunShunyugakuTekiyoKanri 管理情報, dgIchiran_Row row,
            List<KijunShunyuShinseiDate> 基準収入額データList) {
        row.setSetaiCode(管理情報.get世帯コード().getColumnValue());
        row.setShoriNendo(getWarekiYear(管理情報.get年度()));
        row.setRirekiNo(new RString(管理情報.get履歴番号()).padLeft("0", NUM_4));
        row.setSetaikijunYMD(toWarekiHalf_Zero(管理情報.get申請書作成の世帯基準日()));
        row.setShinseiYMD(toWarekiHalf_Zero(管理情報.get申請日()));
        row.setShinseishoSakuseiYMD(toWarekiHalf_Zero(管理情報.get申請書作成日()));
        row.setTekiyoKaishiYM(toWarekiHalf_Zero(管理情報.get適用開始年月()));
        if (管理情報.get算定基準額() != null) {
            row.setSanteiKijunGaku(DecimalFormatter.toコンマ区切りRString(管理情報.get算定基準額(), NUM_0));
        }
        row.setKetteiYMD(toWarekiHalf_Zero(管理情報.get決定日()));
        row.setKetteiTsuchishoHakkoYMD(toWarekiHalf_Zero(管理情報.get決定通知書発行日()));
        if (is住民税を判定(基準収入額データList)) {
            row.setSetaiKazei(SetaiKazeiKubun.課税.get名称());
        } else {
            row.setSetaiKazei(SetaiKazeiKubun.非課税.get名称());
        }
        if (管理情報.get世帯員の総収入額() != null) {
            row.setSoshunyuGaku(new RString(管理情報.get世帯員の総収入額().toString()));
        }
        row.setUnder16(new RString(管理情報.get年少扶養控除_16歳未満人数()));
        row.setOver16(new RString(管理情報.get年少扶養控除_16から18歳未満人数()));
        row.setKijyunShunyuGakuData(DataPassingConverter.serialize((Serializable) 基準収入額データList));
        row.setCancelButtonState(DataGridButtonState.Disabled);
        return row;
    }

    private boolean is住民税を判定(List<KijunShunyuShinseiDate> 基準収入額データList) {
        RString 課税 = KazeiKubun.課税.getコード();
        for (KijunShunyuShinseiDate 基準収入額データ : 基準収入額データList) {
            if (課税.equals(基準収入額データ.get住民税())) {
                return true;
            }
        }
        return false;
    }

    private RString toWarekiHalf_Zero(FlexibleDate targetValue) {
        if (targetValue == null) {
            return RString.EMPTY;
        }
        return targetValue.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.ZERO).width(Width.HALF).toDateString();
    }

    private RString toWarekiHalf_Zero(FlexibleYearMonth targetValue) {
        if (targetValue == null) {
            return RString.EMPTY;
        }
        return targetValue.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                separator(Separator.PERIOD).fillType(FillType.ZERO).width(Width.HALF).toDateString();
    }

    private RString getWarekiYear(FlexibleYear date) {
        RString wareki = RString.EMPTY;
        if (date != null) {
            wareki = date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).getYear()
                    .concat(KEY_年度);
        }
        return wareki;
    }

    private List<KijunShunyuShinseiDate> get基準収入額データ(KijunShunyugakuTekiyoKanri 管理情報,
            List<KijunShunyugakuTekiyoKanri> 管理情報明細List) {

        List<KijunShunyuShinseiDate> 基準収入額データList = new ArrayList<>();
        KijunShunyuShinseiDate 基準収入額データ;
        for (KijunShunyugakuTekiyoKanri 管理情報明細 : 管理情報明細List) {
            基準収入額データ = new KijunShunyuShinseiDate();
            HihokenshaNo 被保険者番号 = 管理情報明細.get被保険者番号();
            FlexibleDate 世帯基準日 = 管理情報.get申請書作成の世帯基準日();

            基準収入額データ.set被保険者番号(被保険者番号);
            基準収入額データ.set公的年金(管理情報明細.get公的年金収入額());
            基準収入額データ.set給与(管理情報明細.get給与収入額());
            基準収入額データ.set年金_給与以外の収入(管理情報明細.getその他の収入額());
            基準収入額データ.set宛先印字者(管理情報明細.is宛先印字対象者フラグ());
            基準収入額データ.set前年12月31日時点の世帯主(管理情報明細.is世帯主フラグ());
            基準収入額データ.set課税所得_控除前(管理情報明細.get課税所得額());
            基準収入額データ.set課税所得_控除後(管理情報明細.get課税所得額_控除後());

            if (世帯基準日 != null) {
                HihokenshaDaicho 被保険者台帳情報 = HihokenshaDaichoManager.createInstance().find被保険者台帳(
                        被保険者番号, 世帯基準日);
                if (被保険者台帳情報 == null) {
                    continue;
                }
                ShikibetsuCode 識別コード = 被保険者台帳情報.get識別コード();
                基準収入額データ.set識別コード(識別コード);
                IShikibetsuTaishoFinder 識別対象Finder = ShikibetsuTaishoService.getShikibetsuTaishoFinder();
                IShikibetsuTaisho 宛名情報 = 識別対象Finder.get識別対象(GyomuCode.DB介護保険,
                        識別コード, KensakuYusenKubun.住登外優先);
                if (宛名情報 != null) {
                    基準収入額データ.set氏名(宛名情報.get名称().getName().value());
                    基準収入額データ.set氏名カナ(宛名情報.get名称().getKana().value());
                    基準収入額データ.set生年月日(宛名情報.to個人().get生年月日().toFlexibleDate());
                    基準収入額データ.set性別(宛名情報.to個人().get性別().getCommonName());
                    基準収入額データ.set年齢(宛名情報.to個人().get年齢算出().get年齢());
                    基準収入額データ.set続柄(宛名情報.to個人().get続柄());
                }

                KaigoShotokuAlive 所得情報 = ShotokuManager.createInstance().get介護所得Alive(識別コード,
                        管理情報.get年度(), new YMDHMS(世帯基準日.toString().concat(KEY_HMS.toString())));
                if (所得情報 != null) {
                    基準収入額データ.set住民税(所得情報.get課税区分_住民税減免後());
                    基準収入額データ.set合計所得金額(所得情報.get合計所得金額());
                    基準収入額データ.set年金等収入(所得情報.get年金収入額());
                    基準収入額データ.set年金等所得(所得情報.get年金所得額());
                }

                int 受給者台帳カウント = KijunShunyuShinseiTourokuManager.createInstance().get受給(被保険者番号, 世帯基準日, false);
                if (NUM_1 < 受給者台帳カウント) {
                    基準収入額データ.set受給(KEY_受給);
                } else {
                    基準収入額データ.set受給(RString.EMPTY);
                }

                int 事業対象者カウント = KijunShunyuShinseiTourokuManager.createInstance().get事業対象(被保険者番号, 世帯基準日);
                if (NUM_1 < 事業対象者カウント) {
                    基準収入額データ.set事業対象(KEY_事業対象);
                } else {
                    基準収入額データ.set事業対象(RString.EMPTY);
                }
            }
            基準収入額データList.add(基準収入額データ);
        }
        return 基準収入額データList;
    }

    /**
     * 一覧Grid削除ボタンのメソッドです。
     */
    public void set一覧削除() {
        dgIchiran_Row 削除Row = div.getIchiran().getDgIchiran().getClickedItem();
        if (RowState.Added.equals(削除Row.getRowState())) {
            div.getIchiran().getDgIchiran().getDataSource().remove(削除Row);
        } else {
            削除Row.setRowState(RowState.Deleted);
            削除Row.setCancelButtonState(DataGridButtonState.Enabled);
            削除Row.setDeleteButtonState(DataGridButtonState.Disabled);
            削除Row.setModifyButtonState(DataGridButtonState.Disabled);
            削除Row.setRowBgColor(DataGridCellBgColor.bgColorGray);
        }
    }

    /**
     * 一覧Grid取消ボタンのメソッドです。
     */
    public void set一覧取消() {
        dgIchiran_Row 取消Row = div.getIchiran().getDgIchiran().getClickedItem();
        取消Row.setRowState(RowState.Unchanged);
        取消Row.setCancelButtonState(DataGridButtonState.Disabled);
        取消Row.setDeleteButtonState(DataGridButtonState.Enabled);
        取消Row.setModifyButtonState(DataGridButtonState.Enabled);
        取消Row.setRowBgColor(DataGridCellBgColor.bgColorNormal);
    }

    /**
     * 明細情報の表示のメソッドです。
     *
     * @param 状態 RString
     * @param 世帯コード SetaiCode
     * @param 識別コード ShikibetsuCode
     */
    public void set明細パネル(RString 状態, SetaiCode 世帯コード, ShikibetsuCode 識別コード) {
        List<KijunShunyuShinseiDate> 基準収入額データList;
        clear明細パネル();
        if (KEY_追加.equals(状態)) {
            RString 所得年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_所得年度, RDate.getNowDate(),
                    SubGyomuCode.DBB介護賦課);
            div.getMeisai().getTxtSetaiCode().setValue(世帯コード.getColumnValue());
            div.getMeisai().getTxtShoriNendo().setValue(new FlexibleDate(new RDate(所得年度.toString()).toDateString()));
            div.getMeisai().getTxtSetaiinHaakuKijunYMD().setValue(FlexibleDate.getNowDate());
            div.getMeisai().getTxtShinseiYMD().setValue(FlexibleDate.getNowDate());
            div.getMeisai().getTxtShinseishoSakuseiYMD().setValue(FlexibleDate.getNowDate());

            if (is世帯員所得(識別コード, new FlexibleYear(所得年度))) {
                div.getMeisai().getTxtSetaiKazei().setValue(SetaiKazeiKubun.課税.get名称());
            } else {
                div.getMeisai().getTxtSetaiKazei().setValue(SetaiKazeiKubun.非課税.get名称());
            }
            div.getMeisai().getTxtTekiyoStartYM().setValue(FlexibleDate.EMPTY);
            div.getMeisai().getDdlSanteiKijunGaku().setIsBlankLine(true);
            div.getMeisai().getDdlSanteiKijunGaku().setSelectedIndex(NUM_0);
            div.getMeisai().getTxtKetteiYMD().setValue(FlexibleDate.EMPTY);
            div.getMeisai().getTxtKetteiTsuchishoHakkoYMD().setValue(FlexibleDate.EMPTY);
            Map<RString, Integer> 人数 = 計算控除対象人数(識別コード, new FlexibleYear(所得年度));
            div.getMeisai().getTxtUnder16().setValue(new Decimal(人数.get(KEY_未満人数)));
            div.getMeisai().getTxtOver16().setValue(new Decimal(人数.get(KEY_以上人数)));
            div.getMeisai().getTxtTotalShunyu().setValue(new Decimal(0));
            div.setHdnRirekiNo(new RString(getMax履歴番号() + NUM_1));
            基準収入額データList = get明細Gird(識別コード);
            追加状態定義();
            set明細パネル(false);
        } else {
            dgIchiran_Row 修正Row = div.getIchiran().getDgIchiran().getClickedItem();
            div.getMeisai().getTxtSetaiCode().setValue(修正Row.getSetaiCode());
            div.getMeisai().getTxtShoriNendo().setValue(toFlexibleDate(修正Row.getShoriNendo().substring(NUM_0, NUM_4)));
            div.getMeisai().getTxtSetaiinHaakuKijunYMD().setValue(toFlexibleDate(修正Row.getSetaikijunYMD()));
            div.getMeisai().getTxtShinseiYMD().setValue(toFlexibleDate(修正Row.getShinseiYMD()));
            div.getMeisai().getTxtShinseishoSakuseiYMD().setValue(toFlexibleDate(修正Row.getShinseishoSakuseiYMD()));
            div.getMeisai().getTxtSetaiKazei().setValue(修正Row.getSetaiKazei());
            if (修正Row.getTekiyoKaishiYM() != null && !修正Row.getTekiyoKaishiYM().isEmpty()) {
                div.getMeisai().getTxtTekiyoStartYM().setValue(toFlexibleDate(修正Row.getTekiyoKaishiYM().substring(NUM_0, NUM_6)));
            }
            if (修正Row.getSanteiKijunGaku() != null && !修正Row.getSanteiKijunGaku().isEmpty()) {
                div.getMeisai().getDdlSanteiKijunGaku().setSelectedValue(修正Row.getSanteiKijunGaku().concat(KEY_円));
            } else {
                div.getMeisai().getDdlSanteiKijunGaku().setIsBlankLine(true);
            }
            div.getMeisai().getTxtKetteiYMD().setValue(toFlexibleDate(修正Row.getKetteiYMD()));
            div.getMeisai().getTxtKetteiTsuchishoHakkoYMD().setValue(toFlexibleDate(修正Row.getKetteiTsuchishoHakkoYMD()));
            if (修正Row.getUnder16() != null && !修正Row.getUnder16().isEmpty()) {
                div.getMeisai().getTxtUnder16().setValue(new Decimal(修正Row.getUnder16().toString()));
            }
            if (修正Row.getOver16() != null && !修正Row.getOver16().isEmpty()) {
                div.getMeisai().getTxtOver16().setValue(new Decimal(修正Row.getOver16().toString()));
            }
            if (修正Row.getSoshunyuGaku() != null && !修正Row.getSoshunyuGaku().isEmpty()) {
                div.getMeisai().getTxtTotalShunyu().setValue(new Decimal(修正Row.getSoshunyuGaku().toString()));
            }
            div.setHdnRowId(DataPassingConverter.serialize(修正Row.getId()));
            div.setHdnRirekiNo(修正Row.getRirekiNo());
            基準収入額データList = DataPassingConverter.deserialize(修正Row.getKijyunShunyuGakuData(), List.class);
            修正状態定義();
            set明細パネル(true);
        }

        set明細Girdの項目(基準収入額データList, 状態);
        set押下可能ボタン();
        set隠し項目(識別コード);
    }

    private void set明細パネル(boolean flag) {
        div.getMeisai().getTxtSetaiCode().setDisabled(flag);
        div.getMeisai().getTxtShoriNendo().setDisabled(flag);
        div.getMeisai().getTxtSetaiinHaakuKijunYMD().setDisabled(flag);
        div.getMeisai().getTxtShinseiYMD().setDisabled(false);
        div.getMeisai().getTxtShinseishoSakuseiYMD().setDisabled(flag);
        div.getMeisai().getBtnSetaiSaiSanshutsu().setDisabled(flag);
    }

    private void clear明細パネル() {
        div.getMeisai().getTxtSetaiCode().clearValue();
        div.getMeisai().getTxtShoriNendo().clearValue();
        div.getMeisai().getTxtSetaiinHaakuKijunYMD().clearValue();
        div.getMeisai().getTxtShinseiYMD().clearValue();
        div.getMeisai().getTxtShinseishoSakuseiYMD().clearValue();
        div.getMeisai().getTxtSetaiKazei().clearValue();
        div.getMeisai().getTxtTekiyoStartYM().clearValue();
        div.getMeisai().getTxtKetteiYMD().clearValue();
        div.getMeisai().getTxtKetteiTsuchishoHakkoYMD().clearValue();
        div.getMeisai().getTxtUnder16().clearValue();
        div.getMeisai().getTxtOver16().clearValue();
        div.getMeisai().getTxtTotalShunyu().clearValue();
        div.setHdnRirekiNo(RString.EMPTY);
    }

    private List<KijunShunyuShinseiDate> sort基準収入額データ(List<KijunShunyuShinseiDate> 基準収入額データList) {
        Collections.sort(基準収入額データList, new Comparator<KijunShunyuShinseiDate>() {
            @Override
            public int compare(KijunShunyuShinseiDate o1, KijunShunyuShinseiDate o2) {
                int flag = o1.get被保険者番号().compareTo(o2.get被保険者番号());
                if (0 == flag) {
                    flag = o2.get受給().compareTo(o1.get受給());
                    if (0 == flag) {
                        flag = o2.get事業対象().compareTo(o1.get事業対象());
                    }
                }
                return flag;
            }
        });
        return 基準収入額データList;
    }

    private int getMax履歴番号() {
        List<dgIchiran_Row> rowList = div.getIchiran().getDgIchiran().getDataSource();
        int 履歴番号 = NUM_0;
        if (rowList == null || rowList.isEmpty()) {
            return 履歴番号;
        }
        for (dgIchiran_Row row : rowList) {
            int 番号 = Integer.valueOf(row.getRirekiNo().toString());
            if (履歴番号 < 番号) {
                履歴番号 = 番号;
            }
        }
        return 履歴番号;
    }

    private void 追加状態定義() {
        div.getMeisai().getTxtSetaiCode().setReadOnly(false);
        div.getMeisai().getTxtShoriNendo().setReadOnly(false);
        div.getMeisai().getTxtSetaiinHaakuKijunYMD().setReadOnly(false);
        div.getMeisai().getTxtShinseiYMD().setReadOnly(false);
        div.getMeisai().getTxtShinseishoSakuseiYMD().setReadOnly(false);
        div.getMeisai().getTxtKetteiTsuchishoHakkoYMD().setReadOnly(true);
        div.getMeisai().getTxtUnder16().setReadOnly(false);
        div.getMeisai().getTxtOver16().setReadOnly(false);
    }

    private void 修正状態定義() {
        div.getMeisai().getTxtKetteiTsuchishoHakkoYMD().setReadOnly(true);
        div.getMeisai().getBtnSetaiSaiSanshutsu().setDisabled(true);
        div.getMeisai().getTxtShinseiYMD().setReadOnly(false);
        div.getMeisai().getTxtUnder16().setReadOnly(false);
        div.getMeisai().getTxtOver16().setReadOnly(false);
    }

    private void set明細Girdの項目(List<KijunShunyuShinseiDate> 基準収入額データList, RString 状態) {
        List<dgMeisai_Row> rowList = new ArrayList<>();
        dgMeisai_Row row;
        int count = NUM_0;
        List<PersonalData> personalDataList = new ArrayList();
        for (KijunShunyuShinseiDate 基準収入額データ : 基準収入額データList) {
            row = new dgMeisai_Row();
            ShikibetsuCode 識別コード = 基準収入額データ.get識別コード();
            if (識別コード != null && !識別コード.isEmpty()) {
                row.setShikibetsuCode(識別コード.getColumnValue());
            }
            row.setHihokenshaNo(基準収入額データ.get被保険者番号().getColumnValue());
            RString 氏名 = 基準収入額データ.get氏名();
            RString 氏名カナ = 基準収入額データ.get氏名カナ();
            RString name = RString.EMPTY;
            if (!RString.isNullOrEmpty(氏名)) {
                name = name.concat(氏名);
            }
            if (!RString.isNullOrEmpty(氏名カナ)) {
                name = name.concat(改行).concat(氏名カナ);
            }
            row.setName(name);
            row.setBirthYMD(toWarekiHalf_Zero(基準収入額データ.get生年月日()));
            row.setGender(基準収入額データ.get性別());
            row.setAge(基準収入額データ.get年齢());
            row.setZokugara(基準収入額データ.get続柄());
            row.getKotekiNenkin().setValue(基準収入額データ.get公的年金());
            row.getKyuyo().setValue(基準収入額データ.get給与());
            row.getOtherIncome().setValue(基準収入額データ.get年金_給与以外の収入());
            if (KEY_追加.equals(状態)) {
                row.setRowState(RowState.Added);
                if (count == NUM_0) {
                    row.setAtesakiPrint(true);
                    count = count + NUM_1;
                }
            } else {
                RString row状態 = 基準収入額データ.get状態();
                if (KEY_追加.equals(row状態)) {
                    row.setRowState(RowState.Added);
                } else if (KEY_削除.equals(row状態)) {
                    row.setRowState(RowState.Deleted);
                } else {
                    row.setRowState(RowState.Modified);
                }
                row.setAtesakiPrint(基準収入額データ.get宛先印字者());
            }
            RString 受給 = 基準収入額データ.get受給();
            RString 事業対象 = 基準収入額データ.get事業対象();
            RString 受給_事業対象 = RString.EMPTY;
            if (!RString.isNullOrEmpty(受給)) {
                受給_事業対象 = 受給_事業対象.concat(受給);
            }
            if (!RString.isNullOrEmpty(事業対象)) {
                受給_事業対象 = 受給_事業対象.concat(改行).concat(事業対象);
            }
            row.setJyukyuJigyoTaisho(受給_事業対象);
            row.setJuminZei(基準収入額データ.get住民税());
            row.getGokeiShotoku().setValue(基準収入額データ.get合計所得金額());
            row.getNenkinShunyu().setValue(基準収入額データ.get年金等収入());
            row.getNenkinShotoku().setValue(基準収入額データ.get年金等所得());
            row.getKazeiShotokuKojomae().setValue(基準収入額データ.get課税所得_控除前());
            row.getKazeiShotokuKojogo().setValue(基準収入額データ.get課税所得_控除後());
            row.setZennenSetainushi(基準収入額データ.get前年12月31日時点の世帯主());
            row.setShikibetsuTaishoKubun(識別対象区分);
            row.setCancelButtonState(DataGridButtonState.Disabled);
            rowList.add(row);
            personalDataList.add(toPersonalData(基準収入額データ.get識別コード(),
                    基準収入額データ.get被保険者番号().getColumnValue()));
        }
        AccessLogger.log(AccessLogType.照会, personalDataList);
        MemoNyuryokuHandler.dataGridupdateImage(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付, div.getMeisai().getDgMeisai(),
                MemoShikibetsuTaisho.識別コード.get識別対象(), 識別対象コード, RString.EMPTY, RString.EMPTY, メモ);
        div.getMeisai().getDgMeisai().setDataSource(rowList);
    }

    /**
     * 「ボタンの押下可能の設定」のメソッドです。
     */
    public void set押下可能ボタン() {
        RString 世帯コード = div.getMeisai().getTxtSetaiCode().getValue();
        FlexibleDate 処理年度 = div.getMeisai().getTxtShoriNendo().getValue();
        FlexibleDate 基準日 = div.getMeisai().getTxtSetaiinHaakuKijunYMD().getValue();
        if (世帯コード != null && !世帯コード.isEmpty()
                && 処理年度 != null && !処理年度.isEmpty()
                && 基準日 != null && !基準日.isEmpty()) {
            div.getMeisai().getBtnShowShotokuJokyo().setDisabled(false);
            div.getMeisai().getBtnShowZennendo().setDisabled(false);
            div.getMeisai().getBtnAddMeisai().setDisabled(false);
        } else {
            div.getMeisai().getBtnShowShotokuJokyo().setDisabled(true);
            div.getMeisai().getBtnShowZennendo().setDisabled(true);
            div.getMeisai().getBtnAddMeisai().setDisabled(true);
        }
    }

    /**
     * 所得状況ボタン押した時、状況隠し項目再設定
     */
    public void set所得状況隠し項目() {
        FlexibleDate 処理年度 = div.getMeisai().getTxtShoriNendo().getValue();
        FlexibleDate 基準日 = div.getMeisai().getTxtSetaiinHaakuKijunYMD().getValue();
        div.getMeisai().setHdnHenkomaeShoriNendo(DataPassingConverter.serialize(処理年度));
        div.getMeisai().setHdnHenkomaeSetaiinHaakuKijunYMD(DataPassingConverter.serialize(基準日));
    }

    /**
     * 12/31状況ボタン押した時、状況隠し項目再設定
     */
    public void set1231状況隠し項目() {
        FlexibleYear 処理年度 = new FlexibleYear(div.getMeisai().getTxtShoriNendo().getValue().toString().substring(NUM_0, NUM_4));
        FlexibleDate 計算基準日 = new FlexibleDate(処理年度.minusYear(NUM_1).toDateString().concat(KEY_月日).toString());
        div.getMeisai().setHdnHenkomaeShoriNendo(DataPassingConverter.serialize(div.getMeisai().getTxtShoriNendo().getValue()));
        div.getMeisai().setHdnHenkomaeSetaiinHaakuKijunYMD(DataPassingConverter.serialize(計算基準日));
    }

    private void set隠し項目(ShikibetsuCode 識別コード) {
        RString 世帯コード = div.getMeisai().getTxtSetaiCode().getValue();
        FlexibleDate 処理年度 = div.getMeisai().getTxtShoriNendo().getValue();
        FlexibleDate 基準日 = div.getMeisai().getTxtSetaiinHaakuKijunYMD().getValue();
        div.getMeisai().setHdnModeAdd(DataPassingConverter.serialize(追加モード));
        div.getMeisai().setHdnModeReference(DataPassingConverter.serialize(照会モード));
        div.getMeisai().setHdnShikibetuCode(DataPassingConverter.serialize(識別コード));
        div.getMeisai().setHdnButtonSaiSanshutsuFlag(DataPassingConverter.serialize(世帯再算出フラグ_0));
        div.getMeisai().setHdnHenkomaeStaiCode(DataPassingConverter.serialize(世帯コード));
        div.getMeisai().setHdnHenkomaeShoriNendo(DataPassingConverter.serialize(処理年度));
        div.getMeisai().setHdnHenkomaeSetaiinHaakuKijunYMD(DataPassingConverter.serialize(基準日));
        div.getMeisai().setHdnGyomuCode(DataPassingConverter.serialize(GyomuCode.DB介護保険));
        div.getMeisai().setHdnShikibetsuTaishoKubun(MemoShikibetsuTaisho.識別コード.get識別対象());
    }

    private List<KijunShunyuShinseiDate> get明細Gird(ShikibetsuCode 識別コード) {
        List<KijunShunyuShinseiDate> 基準収入額データList = new ArrayList<>();
        FlexibleDate 世帯員把握基準日 = div.getMeisai().getTxtSetaiinHaakuKijunYMD().getValue();
        FlexibleDate 処理年度 = div.getMeisai().getTxtShoriNendo().getValue();
        FlexibleYear 年度 = new FlexibleYear(処理年度.toString().substring(NUM_0, NUM_4));
        FlexibleDate 前年度基準日 = new FlexibleDate(年度.minusYear(NUM_1).toDateString().concat(日付_1231).toString());
        int count = NUM_0;
        List<SetaiinJoho> 世帯員情報List = SetaiinFinder.createInstance().get世帯員情報By識別コード(識別コード, 世帯員把握基準日);
        List<HihokenshaDaicho> 被保険者台帳情報List = new ArrayList<>();
        List<ShikibetsuCode> 識別コードList = new ArrayList<>();
        List<SetaiinShotoku> 世帯員所得List = new ArrayList<>();
        for (SetaiinJoho 世帯員情報 : 世帯員情報List) {
            if (識別コードList.contains(世帯員情報.get識別対象().get識別コード())) {
                continue;
            } else {
                識別コードList.add(世帯員情報.get識別対象().get識別コード());
            }
            HihokenshaDaicho 最新被保険者台帳 = HihokenshaDaichoManager.createInstance().get最新被保険者台帳(new LasdecCode(
                    ControlDataHolder.getReamsDonyuDantaiCode().getColumnValue()), 世帯員情報.get識別対象().get識別コード());
            if (最新被保険者台帳 != null && KEY_1号.equals(最新被保険者台帳.get被保険者区分コード())) {
                被保険者台帳情報List.add(最新被保険者台帳);
            }
        }
        for (HihokenshaDaicho 被保険者台帳 : 被保険者台帳情報List) {
            List<SetaiinShotoku> 世帯員所得 = SetaiinShotokuJohoFinder.createInstance().get世帯員所得情報(
                    被保険者台帳.get識別コード(), 年度, new YMDHMS(世帯員把握基準日.toString().concat(KEY_HMS.toString())));
            世帯員所得 = filter世帯員所得(世帯員所得);
            if (世帯員所得 != null && !世帯員所得.isEmpty()) {
                世帯員所得List.addAll(世帯員所得);
            }
        }
        RString システム日付 = RDate.getNowDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        if (世帯員所得List == null || 世帯員所得List.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage()
                    .replace(MESSAGE_登録されている住民.replace(MESSAGE_XXXX, システム日付).toString()));
        } else if (is非課税(世帯員所得List)) {
            throw new ApplicationException(DbzErrorMessages.実行不可.getMessage()
                    .replace(MESSAGE_世帯課税区分.toString(), MESSAGE_登録.toString()));
        } else {
            count = count + set基準収入額データ(世帯員所得List, 基準収入額データList, 世帯員把握基準日, 前年度基準日);
        }
        if (NUM_0 == count) {
            throw new ApplicationException(DbzErrorMessages.実行不可.getMessage()
                    .replace(MESSAGE_世帯員に第１号被保険者.toString(), MESSAGE_世帯員を表示.toString()));
        }
        if (!基準収入額データList.isEmpty()) {
            sort基準収入額データ(基準収入額データList);
        }
        return 基準収入額データList;
    }

    private List<SetaiinShotoku> filter世帯員所得(List<SetaiinShotoku> 世帯員所得List) {
        List<SetaiinShotoku> 世帯員所得情報 = new ArrayList<>();
        HihokenshaDaichoAliveManager manager = new HihokenshaDaichoAliveManager();
        HihokenshaDaichoAlive hihokenshaDaichoAlive;
        for (SetaiinShotoku 世帯員所得 : 世帯員所得List) {
            FlexibleDate 計算基準日 = new FlexibleDate(RDateTime.now().getDate().toDateString());
            AgeCalculator 年齢 = new AgeCalculator(DateOfBirthFactory.createInstance(世帯員所得.get生年月日()),
                    JuminJotai.住民, 世帯員所得.get住民情報_異動日(), 計算基準日);
            if (!is年齢以上(年齢.get年齢(), 歳_65)) {
                continue;
            }
            hihokenshaDaichoAlive = manager.get最新の被保険者台帳情報(世帯員所得.get被保険者番号().value());
            if (hihokenshaDaichoAlive == null || hihokenshaDaichoAlive.get資格喪失事由コード().isNullOrEmpty()) {
                世帯員所得情報.add(世帯員所得);
            }
        }
        return 世帯員所得情報;
    }

    private int set基準収入額データ(List<SetaiinShotoku> 世帯員所得List,
            List<KijunShunyuShinseiDate> 基準収入額データList,
            FlexibleDate 世帯員把握基準日,
            FlexibleDate 前年度基準日) {
        KijunShunyuShinseiDate 基準収入額データ;
        int count = NUM_0;
        for (SetaiinShotoku 世帯員所得 : 世帯員所得List) {
            HihokenshaNo 被保険者番号 = 世帯員所得.get被保険者番号();
            基準収入額データ = new KijunShunyuShinseiDate();
            基準収入額データ.set識別コード(世帯員所得.get識別コード());
            基準収入額データ.set被保険者番号(世帯員所得.get被保険者番号());
            基準収入額データ.set氏名(世帯員所得.get氏名());
            基準収入額データ.set氏名カナ(世帯員所得.getカナ氏名());
            基準収入額データ.set生年月日(世帯員所得.get生年月日());
            基準収入額データ.set性別(世帯員所得.get性別());
            FlexibleDate 計算基準日 = new FlexibleDate(RDateTime.now().getDate().toDateString());
            AgeCalculator 年齢 = new AgeCalculator(DateOfBirthFactory.createInstance(世帯員所得.get生年月日()),
                    JuminJotai.住民, 世帯員所得.get住民情報_異動日(), 計算基準日);
            基準収入額データ.set年齢(年齢.get年齢());
            基準収入額データ.set続柄(世帯員所得.get続柄());
            基準収入額データ.set公的年金(null);
            基準収入額データ.set給与(null);
            基準収入額データ.set年金_給与以外の収入(null);
            int 受給者台帳カウント = KijunShunyuShinseiTourokuManager.createInstance().get受給(被保険者番号,
                    世帯員把握基準日, true);
            if (NUM_0 < 受給者台帳カウント) {
                基準収入額データ.set受給(KEY_受給);
                count = count + NUM_1;
            } else {
                基準収入額データ.set受給(RString.EMPTY);
            }

            int 事業対象者カウント = KijunShunyuShinseiTourokuManager.createInstance().get事業対象(
                    被保険者番号, 世帯員把握基準日);
            if (NUM_0 < 事業対象者カウント) {
                基準収入額データ.set事業対象(KEY_事業対象);
                count = count + NUM_1;
            } else {
                基準収入額データ.set事業対象(RString.EMPTY);
            }
            if (KazeiKubun.課税.getコード().equals(世帯員所得.get課税区分_住民税減免後())) {
                基準収入額データ.set住民税(SetaiKazeiKubun.課税.get名称());
            } else {
                基準収入額データ.set住民税(SetaiKazeiKubun.非課税.get名称());
            }

            基準収入額データ.set合計所得金額(世帯員所得.get合計所得金額());
            基準収入額データ.set年金等収入(世帯員所得.get年金収入額());
            基準収入額データ.set年金等所得(世帯員所得.get年金所得額());
            Decimal 課税所得額 = 世帯員所得.get課税所得額();
            基準収入額データ.set課税所得_控除前(課税所得額);
            if (区分_本人.equals(世帯員所得.get本人区分())) {
                Decimal 未満人数 = div.getMeisai().getTxtUnder16().getValue();
                Decimal 以上人数 = div.getMeisai().getTxtOver16().getValue();
                if (課税所得額 == null) {
                    課税所得額 = Decimal.ZERO;
                }
                Decimal 課税所得_控除後 = 課税所得額.subtract((未満人数.multiply(円_33万).add(以上人数.multiply(円_12万))));
                if (Decimal.ZERO.compareTo(課税所得_控除後) == 1) {
                    基準収入額データ.set課税所得_控除後(Decimal.ZERO);
                } else {
                    基準収入額データ.set課税所得_控除後(課税所得_控除後);
                }
            } else {
                基準収入額データ.set課税所得_控除後(課税所得額);
            }
            IKojins 世帯員リスト = SetaiinFinder.createInstance().get世帯員リスト(世帯員所得.get識別コード(), 前年度基準日);
            基準収入額データ.set前年12月31日時点の世帯主(is前年12月31日時点の世帯主(世帯員所得.get識別コード(), 世帯員リスト));
            基準収入額データList.add(基準収入額データ);
        }
        return count;
    }

    private boolean is前年12月31日時点の世帯主(ShikibetsuCode 識別コード, IKojins 世帯員リスト) {
        for (IKojin 世帯員 : 世帯員リスト) {
            if (識別コード.value().equals(世帯員.get識別コード().value())) {
                return 世帯員.is世帯主();
            }
        }
        return false;
    }

    private boolean is非課税(List<SetaiinShotoku> 世帯員所得List) {
        RString 非課税 = KazeiKubun.非課税.getコード();
        for (SetaiinShotoku 世帯員所得 : 世帯員所得List) {
            if (世帯員所得.get課税区分_住民税減免後().isNullOrEmpty()) {
                continue;
            }
            if (!非課税.equals(世帯員所得.get課税区分_住民税減免後())) {
                return false;
            }
        }
        return true;
    }

    private Map<RString, Integer> 計算控除対象人数(ShikibetsuCode 識別コード, FlexibleYear 所得年度) {
        Map<RString, Integer> 人数Map = new HashMap<>();
        List<SetaiinShotoku> 世帯員所得List = SetaiinShotokuJohoFinder.createInstance().get世帯員所得情報(
                識別コード, 所得年度, null);
        FlexibleDate 計算基準日 = new FlexibleDate(RDateTime.now().getDate().toDateString());
        int 未満人数 = 0;
        int 以上人数 = 0;
        for (SetaiinShotoku 世帯員所得 : 世帯員所得List) {
            AgeCalculator 年齢 = new AgeCalculator(DateOfBirthFactory.createInstance(世帯員所得.get生年月日()),
                    JuminJotai.住民, 世帯員所得.get住民情報_異動日(), 計算基準日);
            if (is年齢未満(年齢.get年齢(), 歳_16)
                    && 0 < 円_38万.compareTo(世帯員所得.get合計所得金額() == null ? Decimal.ZERO : 世帯員所得.get合計所得金額())) {
                未満人数 = 未満人数 + 1;
            }
            if (is年齢以上(年齢.get年齢(), 歳_16) && is年齢未満(年齢.get年齢(), 歳_18)
                    && 0 < 円_38万.compareTo(世帯員所得.get合計所得金額() == null ? Decimal.ZERO : 世帯員所得.get合計所得金額())) {
                以上人数 = 以上人数 + 1;
            }
        }
        人数Map.put(KEY_未満人数, 未満人数);
        人数Map.put(KEY_以上人数, 以上人数);
        return 人数Map;
    }

    private boolean is年齢未満(RString 年齢, RString 基準年齢) {
        if (年齢.isNullOrEmpty()) {
            return true;
        }
        return Integer.parseInt(年齢.toString()) < Integer.parseInt(基準年齢.toString());
    }

    private boolean is年齢以上(RString 年齢, RString 基準年齢) {
        if (年齢.isNullOrEmpty()) {
            return false;
        }
        return Integer.parseInt(年齢.toString()) >= Integer.parseInt(基準年齢.toString());
    }

    private boolean is世帯員所得(ShikibetsuCode 識別コード, FlexibleYear 所得年度) {
        RString 課税 = KazeiKubun.課税.getコード();
        List<SetaiinShotoku> 世帯員所得List = SetaiinShotokuJohoFinder.createInstance().get世帯員所得情報(
                識別コード, 所得年度, YMDHMS.now());
        for (SetaiinShotoku 世帯員所得 : 世帯員所得List) {
            if (課税.equals(世帯員所得.get課税区分_住民税減免後())) {
                return true;
            }
        }
        return false;
    }

    private FlexibleDate toFlexibleDate(RString date) {
        if (date == null || date.isEmpty()) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(new RDate(date.toString()).toDateString());
    }

    /**
     * 世帯再算出ボタン押下のメソッドです。
     *
     * @param 識別コード ShikibetsuCode
     * @param 状態 RString
     */
    public void set世帯再算出(ShikibetsuCode 識別コード, RString 状態) {
        RString 世帯コード = div.getMeisai().getTxtSetaiCode().getValue();
        FlexibleDate 処理年度 = div.getMeisai().getTxtShoriNendo().getValue();
        FlexibleYear 年度 = new FlexibleYear(処理年度.toString().substring(NUM_0, NUM_4));
        FlexibleDate 基準日 = div.getMeisai().getTxtSetaiinHaakuKijunYMD().getValue();
        Map<RString, Integer> 控除対象人数 = 計算控除対象人数(識別コード, 年度);
        div.getMeisai().getTxtUnder16().setValue(new Decimal(控除対象人数.get(KEY_未満人数)));
        div.getMeisai().getTxtOver16().setValue(new Decimal(控除対象人数.get(KEY_以上人数)));
        set明細Girdの項目(get明細Gird(識別コード), 状態);
        div.getMeisai().setHdnButtonSaiSanshutsuFlag(DataPassingConverter.serialize(世帯再算出フラグ_1));
        div.getMeisai().setHdnHenkomaeStaiCode(DataPassingConverter.serialize(世帯コード));
        div.getMeisai().setHdnHenkomaeShoriNendo(DataPassingConverter.serialize(処理年度));
        div.getMeisai().setHdnHenkomaeSetaiinHaakuKijunYMD(DataPassingConverter.serialize(基準日));
    }

    /**
     * 総収入金額算出のメソッドです。
     */
    public void set総収入金額() {
        List<dgMeisai_Row> rowList = div.getMeisai().getDgMeisai().getDataSource();
        Decimal 総金額 = Decimal.ZERO;
        Decimal 公的年金;
        Decimal 給与;
        Decimal 以外の収入;
        for (dgMeisai_Row row : rowList) {
            if (RowState.Deleted.equals(row.getRowState())) {
                continue;
            }
            公的年金 = row.getKotekiNenkin().getValue() == null ? Decimal.ZERO : row.getKotekiNenkin().getValue();
            給与 = row.getKyuyo().getValue() == null ? Decimal.ZERO : row.getKyuyo().getValue();
            以外の収入 = row.getOtherIncome().getValue() == null ? Decimal.ZERO : row.getOtherIncome().getValue();
            総金額 = 総金額.add(公的年金).add(給与).add(以外の収入);
        }
        div.getMeisai().getTxtTotalShunyu().setValue(総金額);
    }

    /**
     * 世帯員Grid削除ボタンのメソッドです。
     */
    public void set世帯員削除() {
        dgMeisai_Row 削除Row = div.getMeisai().getDgMeisai().getClickedItem();
        if (RowState.Added.equals(削除Row.getRowState())) {
            div.getMeisai().getDgMeisai().getDataSource().remove(削除Row);
        } else {
            削除Row.setRowState(RowState.Deleted);
            削除Row.setCancelButtonState(DataGridButtonState.Enabled);
            削除Row.setDeleteButtonState(DataGridButtonState.Disabled);
            削除Row.setRowBgColor(DataGridCellBgColor.bgColorGray);
        }
    }

    /**
     * 世帯員Grid取消ボタンのメソッドです。
     */
    public void set世帯員取消() {
        dgMeisai_Row 取消Row = div.getMeisai().getDgMeisai().getClickedItem();
        取消Row.setRowState(RowState.Modified);
        取消Row.setCancelButtonState(DataGridButtonState.Disabled);
        取消Row.setDeleteButtonState(DataGridButtonState.Enabled);
        取消Row.setRowBgColor(DataGridCellBgColor.bgColorNormal);
    }

    /**
     * 控除再算出ボタンのメソッドです。
     *
     * @param 状態 RString
     */
    public void set控除算出(RString 状態) {
        List<dgMeisai_Row> rowList = div.getMeisai().getDgMeisai().getDataSource();
        if (KEY_追加.equals(状態)) {
            for (dgMeisai_Row row : rowList) {
                Decimal 課税所得額 = row.getKazeiShotokuKojomae().getValue();
                set控除前後(row, 課税所得額);
            }
        } else {
            FlexibleDate 世帯基準日 = div.getMeisai().getTxtSetaiinHaakuKijunYMD().getValue();
            FlexibleDate 処理年度 = div.getMeisai().getTxtShoriNendo().getValue();
            FlexibleYear 年度 = new FlexibleYear(処理年度.toString().substring(NUM_0, NUM_4));
            for (dgMeisai_Row row : rowList) {
                HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getHihokenshaNo());
                HihokenshaDaicho 被保険者台帳情報 = HihokenshaDaichoManager.createInstance().find被保険者台帳(
                        被保険者番号, 世帯基準日);
                if (被保険者台帳情報 != null) {
                    List<SetaiinShotoku> 世帯員所得List = SetaiinShotokuJohoFinder.createInstance().get世帯員所得情報(
                            被保険者台帳情報.get識別コード(), 年度, YMDHMS.now());
                    Decimal 課税所得額 = 世帯員所得List == null || 世帯員所得List.isEmpty()
                            ? Decimal.ZERO : 世帯員所得List.get(NUM_0).get課税所得額();
                    row.getKazeiShotokuKojomae().setValue(課税所得額);
                    set控除前後(row, 課税所得額);
                }
            }
        }
    }

    private void set控除前後(dgMeisai_Row row, Decimal 課税所得額) {
        if (row.getZennenSetainushi()) {
            Decimal 未満人数 = div.getMeisai().getTxtUnder16().getValue();
            Decimal 以上人数 = div.getMeisai().getTxtOver16().getValue();
            if (課税所得額 == null) {
                課税所得額 = Decimal.ZERO;
            }
            Decimal 課税所得_控除後 = 課税所得額.subtract((未満人数.multiply(円_33万).add(以上人数.multiply(円_12万))));
            if (Decimal.ZERO.compareTo(課税所得_控除後) == 1) {
                row.getKazeiShotokuKojogo().setValue(Decimal.ZERO);
            } else {
                row.getKazeiShotokuKojogo().setValue(課税所得_控除後);
            }
        } else {
            row.getKazeiShotokuKojogo().setValue(課税所得額);
        }
    }

    /**
     * ダイアログで選択された世帯員を明細に追加のメソッドです。
     */
    public void setダイアログで選択された世帯員() {
        List<dgMeisai_Row> rowList = div.getMeisai().getDgMeisai().getDataSource();
        List<RString> 識別コードList = new ArrayList<>();
        for (dgMeisai_Row row : rowList) {
            if (!識別コードList.contains(row.getShikibetsuCode())) {
                識別コードList.add(row.getShikibetsuCode());
            }
        }
        List<KijunShunyugakuDate> 選択世帯員List = DataPassingConverter.deserialize(
                div.getMeisai().getHdnDaialogSelectSetaiinJoho(), List.class);
        RStringBuilder builder = new RStringBuilder();
        for (KijunShunyugakuDate 選択世帯員 : 選択世帯員List) {
            if (識別コードList.contains(選択世帯員.get識別コード())) {
                if (builder.length() > 0) {
                    builder.append(コンマ);
                }
                builder.append(選択世帯員.get識別コード());
            }
        }
        if (builder.length() > 0) {
            throw new ApplicationException(DbzErrorMessages.理由付き登録不可.getMessage()
                    .replace(MESSAGE_識別コード.replace(MESSAGE_XXXX, builder.toRString()).toString()));
        }
        set世帯員(選択世帯員List, rowList);
    }

    private void set世帯員(List<KijunShunyugakuDate> 選択世帯員List, List<dgMeisai_Row> rowList) {
        dgMeisai_Row row;
        for (KijunShunyugakuDate 選択世帯員 : 選択世帯員List) {
            row = new dgMeisai_Row();
            row.setShikibetsuCode(選択世帯員.get識別コード());
            row.setHihokenshaNo(選択世帯員.get被保険者番号());
            RString 氏名 = 選択世帯員.get氏名();
            RString 氏名カナ = 選択世帯員.get氏名カナ();
            if (氏名 != null && 氏名カナ != null) {
                row.setName(選択世帯員.get氏名().concat(改行).concat(選択世帯員.get氏名カナ()));
            }
            row.setBirthYMD(toWarekiHalf_Zero(選択世帯員.get生年月日()));
            row.setGender(選択世帯員.get性別());
            row.setAge(選択世帯員.get年齢());
            row.setZokugara(選択世帯員.get続柄());
            row.setJuminZei(選択世帯員.get住民税());
            row.getGokeiShotoku().setValue(選択世帯員.get合計所得金額());
            row.getNenkinShunyu().setValue(選択世帯員.get年金等収入());
            row.getNenkinShotoku().setValue(選択世帯員.get年金等所得());
            row.getKazeiShotokuKojomae().setValue(選択世帯員.get課税所得());
            row.setShikibetsuTaishoKubun(識別対象区分);
            row.setRowState(RowState.Added);
            row.setCancelButtonState(DataGridButtonState.Disabled);
            rowList.add(row);
        }
    }

    /**
     * 収入額チェックのメソッドです。
     *
     * @return boolean
     */
    public boolean is収入額チェック() {
        List<dgMeisai_Row> rowList = div.getMeisai().getDgMeisai().getDataSource();
        Decimal 所得情報の収入合計 = Decimal.ZERO;
        Decimal 入力した収入合計 = Decimal.ZERO;
        Decimal 合計所得金額;
        Decimal 年金等所得;
        Decimal 年金等収入;
        Decimal 公的年金;
        Decimal 給与;
        Decimal 年金給与以外の収入;
        for (dgMeisai_Row row : rowList) {
            合計所得金額 = row.getGokeiShotoku().getValue();
            if (合計所得金額 == null) {
                合計所得金額 = Decimal.ZERO;
            }
            年金等収入 = row.getNenkinShunyu().getValue();
            if (年金等収入 == null) {
                年金等収入 = Decimal.ZERO;
            }
            年金等所得 = row.getNenkinShotoku().getValue();
            if (年金等所得 == null) {
                年金等所得 = Decimal.ZERO;
            }
            所得情報の収入合計 = 所得情報の収入合計.add(合計所得金額.subtract(年金等所得).add(年金等収入));
            公的年金 = row.getKotekiNenkin().getValue();
            if (公的年金 == null) {
                公的年金 = Decimal.ZERO;
            }
            給与 = row.getKyuyo().getValue();
            if (給与 == null) {
                給与 = Decimal.ZERO;
            }
            年金給与以外の収入 = row.getOtherIncome().getValue();
            if (年金給与以外の収入 == null) {
                年金給与以外の収入 = Decimal.ZERO;
            }
            入力した収入合計 = 入力した収入合計.add(公的年金.add(給与).add(年金給与以外の収入));
        }
        return (入力した収入合計.compareTo(所得情報の収入合計) < NUM_0);
    }

    /**
     * 確定ボタン押下、明細画面の設定内容を一覧Gridに反映のメソッドです。
     *
     * @param 画面状態 RString
     */
    public void get明細情報の反映(RString 画面状態) {
        dgIchiran_Row row;
        if (KEY_追加.equals(画面状態)) {
            List<dgIchiran_Row> rowList = div.getIchiran().getDgIchiran().getDataSource();
            row = new dgIchiran_Row();
            set一覧Grid(row);
            row.setRowState(RowState.Added);
            rowList.add(row);
        } else {
            row = getSelectedRow();
            if (!RowState.Added.equals(row.getRowState())) {
                row.setRowState(RowState.Modified);
            }
            set一覧Grid(row);
        }
    }

    private void set一覧Grid(dgIchiran_Row row) {
        FlexibleDate 処理年度 = div.getMeisai().getTxtShoriNendo().getValue();
        FlexibleYear 年度 = new FlexibleYear(処理年度.toString().substring(NUM_0, NUM_4));
        row.setSetaiCode(div.getMeisai().getTxtSetaiCode().getValue());
        row.setShoriNendo(getWarekiYear(年度));
        row.setRirekiNo(div.getHdnRirekiNo().padLeft("0", NUM_4));
        row.setSetaikijunYMD(toWarekiHalf_Zero(div.getMeisai().getTxtSetaiinHaakuKijunYMD().getValue()));
        row.setShinseiYMD(toWarekiHalf_Zero(div.getMeisai().getTxtShinseiYMD().getValue()));
        row.setShinseishoSakuseiYMD(toWarekiHalf_Zero(div.getMeisai().getTxtShinseishoSakuseiYMD().getValue()));
        row.setTekiyoKaishiYM(get適用開始(div.getMeisai().getTxtTekiyoStartYM().getValue()));
        if (div.getMeisai().getDdlSanteiKijunGaku().getSelectedValue().length() >= NUM_6) {
            row.setSanteiKijunGaku(div.getMeisai().getDdlSanteiKijunGaku().getSelectedValue().substring(NUM_0, NUM_6));
        }
        row.setKetteiYMD(toWarekiHalf_Zero(div.getMeisai().getTxtKetteiYMD().getValue()));
        row.setKetteiTsuchishoHakkoYMD(toWarekiHalf_Zero(div.getMeisai().getTxtKetteiTsuchishoHakkoYMD().getValue()));
        row.setSetaiKazei(div.getMeisai().getTxtSetaiKazei().getValue());
        row.setSoshunyuGaku(new RString(div.getMeisai().getTxtTotalShunyu().getValue().toString()));
        row.setUnder16(new RString(div.getMeisai().getTxtUnder16().getValue().toString()));
        row.setOver16(new RString(div.getMeisai().getTxtOver16().getValue().toString()));
        row.setKijyunShunyuGakuData(DataPassingConverter.serialize((Serializable) get明細Grid基準収入額データ()));
        row.setCancelButtonState(DataGridButtonState.Disabled);
    }

    private RString get適用開始(FlexibleDate 適用開始) {
        if (適用開始 == null || 適用開始.toString().isEmpty()) {
            return RString.EMPTY;
        }
        return toWarekiHalf_Zero(new FlexibleYearMonth(適用開始.toString().substring(NUM_0, NUM_6)));
    }

    private List<KijunShunyuShinseiDate> get明細Grid基準収入額データ() {
        List<KijunShunyuShinseiDate> 基準収入額データList = new ArrayList<>();
        KijunShunyuShinseiDate 基準収入額データ;
        List<dgMeisai_Row> rowList = div.getMeisai().getDgMeisai().getDataSource();
        for (dgMeisai_Row row : rowList) {
            基準収入額データ = new KijunShunyuShinseiDate();
            基準収入額データ.set識別コード(new ShikibetsuCode(row.getShikibetsuCode()));
            基準収入額データ.set被保険者番号(new HihokenshaNo(row.getHihokenshaNo()));
            RString 氏名 = RString.EMPTY;
            RString 氏名カナ = RString.EMPTY;
            int length = row.getName().split(改行.toString()).size();
            if (length == NUM_1) {
                氏名 = row.getName().split(改行.toString()).get(NUM_0);
            } else if (length == NUM_2) {
                氏名 = row.getName().split(改行.toString()).get(NUM_0);
                氏名カナ = row.getName().split(改行.toString()).get(NUM_1);
            }
            基準収入額データ.set氏名(氏名);
            基準収入額データ.set氏名カナ(氏名カナ);
            基準収入額データ.set生年月日(toFlexibleDate(row.getBirthYMD()));
            基準収入額データ.set性別(row.getGender());
            基準収入額データ.set年齢(row.getAge());
            基準収入額データ.set続柄(row.getZokugara());
            基準収入額データ.set公的年金(row.getKotekiNenkin().getValue());
            基準収入額データ.set給与(row.getKyuyo().getValue());
            基準収入額データ.set年金_給与以外の収入(row.getOtherIncome().getValue());
            基準収入額データ.set宛先印字者(row.getAtesakiPrint());
            RString 受給 = RString.EMPTY;
            RString 事業対象 = RString.EMPTY;
            int count = row.getJyukyuJigyoTaisho().split(改行.toString()).size();
            if (count == NUM_1) {
                受給 = row.getJyukyuJigyoTaisho().split(改行.toString()).get(NUM_0);
            } else if (count == NUM_2) {
                受給 = row.getJyukyuJigyoTaisho().split(改行.toString()).get(NUM_0);
                事業対象 = row.getJyukyuJigyoTaisho().split(改行.toString()).get(NUM_1);
            }
            基準収入額データ.set受給(受給);
            基準収入額データ.set事業対象(事業対象);
            基準収入額データ.set住民税(row.getJuminZei());
            基準収入額データ.set合計所得金額(row.getGokeiShotoku().getValue());
            基準収入額データ.set年金等収入(row.getNenkinShunyu().getValue());
            基準収入額データ.set年金等所得(row.getNenkinShotoku().getValue());
            基準収入額データ.set課税所得_控除前(row.getKazeiShotokuKojomae().getValue());
            基準収入額データ.set課税所得_控除後(row.getKazeiShotokuKojogo().getValue());
            基準収入額データ.set前年12月31日時点の世帯主(row.getZennenSetainushi());
            if (RowState.Added.equals(row.getRowState())) {
                基準収入額データ.set状態(KEY_追加);
            } else if (RowState.Deleted.equals(row.getRowState())) {
                基準収入額データ.set状態(KEY_削除);
            } else {
                基準収入額データ.set状態(KEY_修正);
            }
            基準収入額データList.add(基準収入額データ);
        }
        return 基準収入額データList;
    }

    private dgIchiran_Row getSelectedRow() {
        return div.getIchiran().getDgIchiran().getDataSource().get(
                DataPassingConverter.deserialize(div.getHdnRowId(), Integer.class));
    }

    /**
     * toPersonalDataのンメソッドです。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 RString
     * @return PersonalData
     */
    public PersonalData toPersonalData(ShikibetsuCode 識別コード, RString 被保険者番号) {
        ExpandedInformation expandedInfo3 = new ExpandedInformation(業務固有, 業務固有の識別情報名称, 被保険者番号);
        return PersonalData.of(識別コード, expandedInfo3);
    }

    /**
     * 前排他のンメソッドです。
     *
     * @param 被保険者番号 RString
     * @return boolean
     */
    public boolean get前排他(RString 被保険者番号) {
        LockingKey 排他キー = new LockingKey(DBCHIHOKENSHANO.concat(被保険者番号));
        return RealInitialLocker.tryGetLock(排他キー);
    }

    /**
     * 前排他キーの解除のンメソッドです。
     *
     * @param 被保険者番号 RString
     */
    public void 前排他キーの解除(RString 被保険者番号) {
        LockingKey 排他キー = new LockingKey(DBCHIHOKENSHANO.concat(被保険者番号));
        RealInitialLocker.release(排他キー);
    }

    /**
     * 入力内容の破棄確認のンメソッドです。
     *
     * @param div 画面Div
     * @param eventName 遷移イベント
     * @param 被保険者番号 HihokenshaNo
     * @return 遷移画面
     */
    public ResponseData<KijunShunyuShinseiTourokuDiv> getCheckMessage(
            KijunShunyuShinseiTourokuDiv div,
            DBC1000062TransitionEventName eventName,
            HihokenshaNo 被保険者番号) {
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            return ResponseData.of(div).forwardWithEventName(eventName).respond();
        }
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.入力内容の破棄.getMessage().getCode(),
                    UrQuestionMessages.入力内容の破棄.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.入力内容の破棄.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            前排他キーの解除(被保険者番号.getColumnValue());
            return ResponseData.of(div).forwardWithEventName(eventName).respond();
        } else {
            return ResponseData.of(div).respond();
        }
    }

    /**
     * 保存ボタン押下時の処理のンメソッドです。
     *
     * @param 基準収入Map Map
     */
    public void to保存(Map<RString, List<KijunShunyugakuTekiyoKanri>> 基準収入Map) {
        List<dgIchiran_Row> rowList = div.getIchiran().getDgIchiran().getDataSource();
        List<KijunShunyugakuTekiyoKanri> 追加基準収入額データList = new ArrayList<>();
        List<KijunShunyugakuTekiyoKanri> 修正基準収入額データList = new ArrayList<>();
        List<KijunShunyugakuTekiyoKanri> 削除基準収入額データList = new ArrayList<>();
        for (dgIchiran_Row row : rowList) {
            RowState rowState = row.getRowState();
            RString 世帯コード = row.getSetaiCode();
            RString 年度 = row.getShoriNendo();
            RString 履歴番号 = row.getRirekiNo();
            RString key = 世帯コード.concat(年度).concat(履歴番号);
            if (RowState.Added.equals(rowState)) {
                List<KijunShunyuShinseiDate> 基準収入額データList = DataPassingConverter.deserialize(
                        row.getKijyunShunyuGakuData(), List.class);
                set追加基準収入額データ(追加基準収入額データList, 基準収入額データList, row);
            }
            if (RowState.Modified.equals(rowState)) {
                List<KijunShunyuShinseiDate> 基準収入額データList = DataPassingConverter.deserialize(
                        row.getKijyunShunyuGakuData(), List.class);
                set修正基準収入額データ(修正基準収入額データList, 追加基準収入額データList, 削除基準収入額データList,
                        基準収入額データList, 基準収入Map.get(key), row);
            }
            if (RowState.Deleted.equals(rowState)) {
                削除基準収入額データList.addAll(基準収入Map.get(key));
            }
        }
        KijunShunyuShinseiTourokuManager.createInstance().保存基準収入額適用管理情報(追加基準収入額データList,
                修正基準収入額データList, 削除基準収入額データList);
    }

    private void set修正基準収入額データ(List<KijunShunyugakuTekiyoKanri> 修正基準収入額データList,
            List<KijunShunyugakuTekiyoKanri> 追加基準収入額データList,
            List<KijunShunyugakuTekiyoKanri> 削除基準収入額データList,
            List<KijunShunyuShinseiDate> 基準収入額データList,
            List<KijunShunyugakuTekiyoKanri> 初期基準収入額データList,
            dgIchiran_Row row) {
        KijunShunyugakuTekiyoKanri 修正基準収入額データ;
        KijunShunyugakuTekiyoKanriBuilder データBuilder;
        for (KijunShunyuShinseiDate 基準収入額データ : 基準収入額データList) {
            RString 世帯コード = row.getSetaiCode();
            RString 年度 = row.getShoriNendo();
            RString 履歴番号 = row.getRirekiNo();
            FlexibleYear 処理年度 = new FlexibleYear(new RDate(年度.substring(NUM_0, NUM_4).toString()).getYear().toDateString());
            HihokenshaNo 被保険者番号 = 基準収入額データ.get被保険者番号();
            修正基準収入額データ = get初期基準収入額データ(初期基準収入額データList, new SetaiCode(世帯コード),
                    処理年度, Integer.valueOf(履歴番号.toString()), 被保険者番号);
            if (修正基準収入額データ != null) {
                if (KEY_削除.equals(基準収入額データ.get状態())) {
                    削除基準収入額データList.add(修正基準収入額データ);
                } else {
                    データBuilder = getデータBuilder(修正基準収入額データ, 基準収入額データ, row);
                    修正基準収入額データ = データBuilder.build();
                    修正基準収入額データList.add(修正基準収入額データ);
                }
            } else {
                修正基準収入額データ = new KijunShunyugakuTekiyoKanri(new SetaiCode(世帯コード),
                        処理年度, Integer.valueOf(履歴番号.toString()), 被保険者番号);
                データBuilder = getデータBuilder(修正基準収入額データ, 基準収入額データ, row);
                修正基準収入額データ = データBuilder.build();
                追加基準収入額データList.add(修正基準収入額データ);
            }
        }
    }

    private KijunShunyugakuTekiyoKanriBuilder getデータBuilder(KijunShunyugakuTekiyoKanri 修正基準収入額データ,
            KijunShunyuShinseiDate 基準収入額データ,
            dgIchiran_Row row) {
        KijunShunyugakuTekiyoKanriBuilder データBuilder = 修正基準収入額データ.createBuilderForEdit();
        データBuilder.set公的年金収入額(基準収入額データ.get公的年金())
                .set給与収入額(基準収入額データ.get給与())
                .setその他の収入額(基準収入額データ.get年金_給与以外の収入())
                .set算定基準額(toRString_Decimal(row.getSanteiKijunGaku()))
                .set適用開始年月(toFlexibleYearMonth(row.getTekiyoKaishiYM()))
                .set申請日(toFlexibleDate(row.getShinseiYMD()))
                .set決定日(toFlexibleDate(row.getKetteiYMD()))
                .set申請書作成日(toFlexibleDate(row.getShinseishoSakuseiYMD()))
                .set申請書作成の世帯基準日(toFlexibleDate(row.getSetaikijunYMD()))
                .set決定通知書発行日(toFlexibleDate(row.getKetteiTsuchishoHakkoYMD()))
                .set宛先印字対象者フラグ(基準収入額データ.get宛先印字者());
        if (!RString.isNullOrEmpty(row.getUnder16())) {
            データBuilder.set年少扶養控除_16歳未満人数(Integer.valueOf(row.getUnder16().toString()));
        }
        if (!RString.isNullOrEmpty(row.getOver16())) {
            データBuilder.set年少扶養控除_16から18歳未満人数(Integer.valueOf(row.getOver16().toString()));
        }
        データBuilder.set世帯員の総収入額(toRString_Decimal(row.getSoshunyuGaku()))
                .set世帯主フラグ(基準収入額データ.get前年12月31日時点の世帯主())
                .set課税所得額(基準収入額データ.get課税所得_控除前())
                .set課税所得額_控除後(基準収入額データ.get課税所得_控除後());
        return データBuilder;
    }

    private KijunShunyugakuTekiyoKanri get初期基準収入額データ(List<KijunShunyugakuTekiyoKanri> 初期基準収入額データList,
            SetaiCode 世帯コード,
            FlexibleYear 年度,
            int 履歴番号,
            HihokenshaNo 被保険者番号) {
        for (KijunShunyugakuTekiyoKanri 初期基準収入額データ : 初期基準収入額データList) {
            if (世帯コード.equals(初期基準収入額データ.get世帯コード())
                    && 年度.equals(初期基準収入額データ.get年度())
                    && 履歴番号 == 初期基準収入額データ.get履歴番号()
                    && 被保険者番号.equals(初期基準収入額データ.get被保険者番号())) {
                return 初期基準収入額データ;
            }
        }
        return null;
    }

    private void set追加基準収入額データ(List<KijunShunyugakuTekiyoKanri> 追加基準収入額データList,
            List<KijunShunyuShinseiDate> 基準収入額データList,
            dgIchiran_Row row) {
        KijunShunyugakuTekiyoKanri 追加基準収入額データ;
        KijunShunyugakuTekiyoKanriBuilder データBuilder;
        for (KijunShunyuShinseiDate 基準収入額データ : 基準収入額データList) {
            RString 世帯コード = row.getSetaiCode();
            RString 年度 = row.getShoriNendo();
            RString 履歴番号 = row.getRirekiNo();
            HihokenshaNo 被保険者番号 = 基準収入額データ.get被保険者番号();
            追加基準収入額データ = new KijunShunyugakuTekiyoKanri(new SetaiCode(世帯コード),
                    new FlexibleYear(new RDate(年度.substring(NUM_0, NUM_4).toString()).getYear().toDateString()),
                    Integer.valueOf(履歴番号.toString()), 被保険者番号);
            データBuilder = 追加基準収入額データ.createBuilderForEdit();
            データBuilder.set公的年金収入額(基準収入額データ.get公的年金())
                    .set給与収入額(基準収入額データ.get給与())
                    .setその他の収入額(基準収入額データ.get年金_給与以外の収入())
                    .set算定基準額(toRString_Decimal(row.getSanteiKijunGaku()))
                    .set適用開始年月(toFlexibleYearMonth(row.getTekiyoKaishiYM()))
                    .set申請日(toFlexibleDate(row.getShinseiYMD()))
                    .set決定日(toFlexibleDate(row.getKetteiYMD()))
                    .set申請書作成日(toFlexibleDate(row.getShinseishoSakuseiYMD()))
                    .set申請書作成の世帯基準日(toFlexibleDate(row.getSetaikijunYMD()))
                    .set決定通知書発行日(toFlexibleDate(row.getKetteiTsuchishoHakkoYMD()))
                    .set宛先印字対象者フラグ(基準収入額データ.get宛先印字者());
            if (!RString.isNullOrEmpty(row.getUnder16())) {
                データBuilder.set年少扶養控除_16歳未満人数(Integer.valueOf(row.getUnder16().toString()));
            }
            if (!RString.isNullOrEmpty(row.getOver16())) {
                データBuilder.set年少扶養控除_16から18歳未満人数(Integer.valueOf(row.getOver16().toString()));
            }
            データBuilder.set世帯員の総収入額(toRString_Decimal(row.getSoshunyuGaku()))
                    .set世帯主フラグ(基準収入額データ.get前年12月31日時点の世帯主())
                    .set課税所得額(基準収入額データ.get課税所得_控除前())
                    .set課税所得額_控除後(基準収入額データ.get課税所得_控除後());
            追加基準収入額データ = データBuilder.build();
            追加基準収入額データList.add(追加基準収入額データ);
        }
    }

    private Decimal toRString_Decimal(RString 金額) {
        if (RString.isNullOrEmpty(金額)) {
            return null;
        }
        List<RString> commaList = 金額.split(コンマ.toString());
        RString date = commaList.get(NUM_0);
        int count = NUM_0;
        for (RString comma : commaList) {
            if (count == NUM_0) {
                count = count + NUM_1;
                continue;
            }
            date = date.concat(comma);
        }
        return new Decimal(date.toString());
    }

    private FlexibleYearMonth toFlexibleYearMonth(RString date) {
        if (date == null || date.isEmpty()) {
            return FlexibleYearMonth.EMPTY;
        }
        return new FlexibleYearMonth(new RDate(date.toString()).getYearMonth().toDateString());
    }

    /**
     * 世帯再算出ボタン押下チェックのンメソッドです。
     *
     * @return boolean
     */
    public boolean is世帯再算出ボタン押下チェック() {
        RString 世帯再算フラグ = DataPassingConverter.deserialize(
                div.getMeisai().getHdnButtonSaiSanshutsuFlag(), RString.class);
        if (世帯再算出フラグ_0.equals(世帯再算フラグ) || 世帯再算出フラグ_1.equals(世帯再算フラグ)) {
            RString 変更前世帯コード = DataPassingConverter.deserialize(
                    div.getMeisai().getHdnHenkomaeStaiCode(), RString.class);
            FlexibleDate 変更前処理年度 = DataPassingConverter.deserialize(
                    div.getMeisai().getHdnHenkomaeShoriNendo(), FlexibleDate.class);
            FlexibleDate 変更前基準日 = DataPassingConverter.deserialize(
                    div.getMeisai().getHdnHenkomaeSetaiinHaakuKijunYMD(), FlexibleDate.class);
            RString 世帯コード = div.getMeisai().getTxtSetaiCode().getValue();
            FlexibleDate 処理年度 = div.getMeisai().getTxtShoriNendo().getValue();
            FlexibleDate 基準日 = div.getMeisai().getTxtSetaiinHaakuKijunYMD().getValue();
            return (変更前世帯コード.equals(世帯コード) && 変更前処理年度.equals(処理年度) && 変更前基準日.equals(基準日));
        }
        return true;
    }

    /**
     * 受給者・事業対象者のチェックのンメソッドです。
     *
     * @return boolean
     */
    public boolean is受給者事業対象者のチェック() {
        List<dgMeisai_Row> rowList = div.getMeisai().getDgMeisai().getDataSource();
        for (dgMeisai_Row row : rowList) {
            if (row.getJyukyuJigyoTaisho() != null && !row.getJyukyuJigyoTaisho().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 算定基準額のチェックのンメソッドです。
     *
     * @return boolean
     */
    public boolean is算定基準額のチェック() {
        List<dgMeisai_Row> rowList = div.getMeisai().getDgMeisai().getDataSource();
        Decimal 二人以上で総収入金額 = Decimal.ZERO;
        Decimal 公的年金;
        Decimal 給与;
        Decimal 以外の収入;
        for (dgMeisai_Row row : rowList) {
            公的年金 = row.getKotekiNenkin().getValue() == null ? Decimal.ZERO : row.getKotekiNenkin().getValue();
            給与 = row.getKyuyo().getValue() == null ? Decimal.ZERO : row.getKyuyo().getValue();
            以外の収入 = row.getOtherIncome().getValue() == null ? Decimal.ZERO : row.getOtherIncome().getValue();
            二人以上で総収入金額 = 二人以上で総収入金額.add(公的年金).add(給与).add(以外の収入);
        }

        return getチェック(rowList, 二人以上で総収入金額);
    }

    private boolean getチェック(List<dgMeisai_Row> rowList,
            Decimal 二人以上で総収入金額) {

        RString 算定基準額 = div.getMeisai().getDdlSanteiKijunGaku().getSelectedValue();
        Decimal 一人で総収入金額;
        Decimal 公的年金;
        Decimal 給与;
        Decimal 以外の収入;
        Decimal 課税所得;
        int 年齢;
        for (dgMeisai_Row row : rowList) {
            年齢 = get年齢(row.getAge());
            課税所得 = row.getKazeiShotokuKojogo().getValue() == null ? Decimal.ZERO : row.getKazeiShotokuKojogo().getValue();
            公的年金 = row.getKotekiNenkin().getValue() == null ? Decimal.ZERO : row.getKotekiNenkin().getValue();
            給与 = row.getKyuyo().getValue() == null ? Decimal.ZERO : row.getKyuyo().getValue();
            以外の収入 = row.getOtherIncome().getValue() == null ? Decimal.ZERO : row.getOtherIncome().getValue();
            一人で総収入金額 = 公的年金.add(給与).add(以外の収入);
            if (歳以上_65 <= 年齢) {
                if (円_145万.compareTo(課税所得) < NUM_1
                        && (円_383万.compareTo(一人で総収入金額) == NUM_1 || 円_520万.compareTo(二人以上で総収入金額) == NUM_1)
                        && !SanteiKijungaku.算定基準額_44_400円.get略称().equals(算定基準額)) {
                    return false;
                }

                if (円_145万.compareTo(課税所得) < NUM_1
                        && (円_383万.compareTo(一人で総収入金額) < NUM_1 || 円_520万.compareTo(二人以上で総収入金額) < NUM_1)
                        && !SanteiKijungaku.算定基準額_37_200円.get略称().equals(算定基準額)) {
                    return false;
                }

                if (円_145万.compareTo(課税所得) == NUM_1
                        && SanteiKijungaku.算定基準額_44_400円.get略称().equals(算定基準額)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean is入力() {
        for (dgIchiran_Row row : div.getDgIchiran().getDataSource()) {
            if (!RowState.Unchanged.equals(row.getRowState())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 総収入額チェックのメソッドです。
     *
     * @return 総収入額チェック結果
     */
    public boolean is総収入額チェック() {
        Decimal 総収入額 = div.getMeisai().getTxtTotalShunyu().getValue();
        return 総収入額.equals(get明細行総収入金額());
    }

    private Decimal get明細行総収入金額() {
        List<dgMeisai_Row> rowList = div.getMeisai().getDgMeisai().getDataSource();
        Decimal 明細行総収入金額 = Decimal.ZERO;
        Decimal 公的年金;
        Decimal 給与;
        Decimal 以外の収入;
        for (dgMeisai_Row row : rowList) {
            if (get年齢(row.getAge()) < 歳以上_65 || RowState.Deleted.equals(row.getRowState())) {
                continue;
            }
            公的年金 = row.getKotekiNenkin().getValue() == null ? Decimal.ZERO : row.getKotekiNenkin().getValue();
            給与 = row.getKyuyo().getValue() == null ? Decimal.ZERO : row.getKyuyo().getValue();
            以外の収入 = row.getOtherIncome().getValue() == null ? Decimal.ZERO : row.getOtherIncome().getValue();
            明細行総収入金額 = 明細行総収入金額.add(公的年金).add(給与).add(以外の収入);
        }
        return 明細行総収入金額;
    }

    private int get年齢(RString 年齢) {
        if (年齢.isNullOrEmpty()) {
            return 0;
        }
        return Integer.parseInt(年齢.toString());
    }
}
