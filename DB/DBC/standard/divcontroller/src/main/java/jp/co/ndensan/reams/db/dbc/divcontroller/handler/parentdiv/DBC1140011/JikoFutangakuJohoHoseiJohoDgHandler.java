/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1140011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanJikoFutanGaku;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanJikoFutanGakuMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.kogaku.KogakuGassanJikofutangakuHosei;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_Idokubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_Over70_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ShotokuKbn;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1140011.JikoFutangakuHoseiDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1140011.JikoFutangakuJohoHoseiJohoDgDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1140011.dgJohoIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1140011.tplJikofutanKanriJoho1Div;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1140011.tplJikofutanKanriJoho2Div;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KogakuGassanJikoFutanGakuManager;
import jp.co.ndensan.reams.db.dbc.service.core.basic.KogakuGassanJikoFutanGakuMeisaiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 高額合算自己負担額情報補正(単)_情報一覧のHandlerクラスです。
 *
 * @reamsid_L DBC-2080-010 jiangzongyue
 */
public class JikoFutangakuJohoHoseiJohoDgHandler {

    private final JikoFutangakuJohoHoseiJohoDgDiv div;

    private static final RString 所得区分_課税 = new RString("10");
    private static final RString 所得区分_非課税 = new RString("11");
    private static final RString 課税 = new RString("課税");
    private static final RString 非課税 = new RString("非課税");
    private static final RString CODE_ONE = new RString("1");
    private static final RString CODE_TWO = new RString("2");
    private static final RString 非該当 = new RString("非該当");
    private static final RString 該当 = new RString("該当");
    private static final int INT_0 = 0;
    private static final int INT_2 = 2;
    private static final int INT_4 = 4;
    private static final int 年度_2013 = 2013;
    private static final int 年度_2014 = 2014;
    private static final int 年度_2015 = 2015;
    private static final RString 異動区分_1 = new RString("1");
    private static final RString 異動区分_2 = new RString("2");
    private static final RString 異動区分_3 = new RString("3");
    private static final RString 本算定 = new RString("本算定");
    private static final RString 仮算定 = new RString("仮算定");
    private static final RString CODE_003 = new RString("003");
    private static final RString 名称_被保険者番号 = new RString("被保険者番号");
    private static final RString KEY_ZERO = new RString("key0");

    /**
     * コンストラクタです。
     *
     * @param div JikoFutangakuJohoHoseiJohoDgDiv
     */
    public JikoFutangakuJohoHoseiJohoDgHandler(JikoFutangakuJohoHoseiJohoDgDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div JikoFutangakuJohoHoseiJohoDgDiv
     * @return JikoFutangakuJohoHoseiJohoDgHandler
     */
    public static JikoFutangakuJohoHoseiJohoDgHandler of(JikoFutangakuJohoHoseiJohoDgDiv div) {
        return new JikoFutangakuJohoHoseiJohoDgHandler(div);
    }

    /**
     * 初期化のメソッドです。
     *
     * @param 対象者 TaishoshaKey
     */
    public void initializeDisplay(TaishoshaKey 対象者) {
        div.getKogakuGassanShikyuShinseiTorokuKihon().initialize(対象者.get識別コード());
        div.getKogakuGassanShikyuShinseiTorokuKaigoKihon().initialize(対象者.get被保険者番号());
        div.getChkRirekiHyouji().setSelectedItemsByKey(Collections.EMPTY_LIST);
        div.getDgJohoIchiran().init();
    }

    /**
     * 履歴を表示するのイベントです。
     *
     * @param resultList List<KogakuGassanJikoFutanGaku>
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     */
    public void onClick_chkRirekiHyouji(List<KogakuGassanJikoFutanGaku> resultList, HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        List<dgJohoIchiran_Row> rowList = new ArrayList();
        for (KogakuGassanJikoFutanGaku result : resultList) {
            dgJohoIchiran_Row row = new dgJohoIchiran_Row();
            row.setTxtTaishoNendo(result.get対象年度().toDateString());
            row.setTxtSanteiKubun(set算定区分(result.get異動区分()));
            row.setTxtHokenshaNo(result.get保険者番号().getColumnValue());
            row.setTxtShikyuShinseishoSeiriNo(result.get支給申請書整理番号());
            row.setTxtIdoKubun(result.get異動区分() == null ? RString.EMPTY
                    : KaigoGassan_Idokubun.toValue(result.get異動区分()).get名称());
            row.setTxtRirekiNo(new RString(result.get履歴番号()));
            row.setTxtUketoriNengetsu(result.get自己負担額証明書情報受取年月() == null ? RString.EMPTY
                    : result.get自己負担額証明書情報受取年月().toDateString());
            row.setTxtHoseiYMDTan(result.getバッチ補正実施年月日() == null || result.getバッチ補正実施年月日().isEmpty() ? RString.EMPTY
                    : DateConverter.toWarekiHalf_Zero(
                            new RDate(result.getバッチ補正実施年月日().toString())));
            row.setTxtHoseiYMDTan(result.getリアル補正実施年月日() == null || result.getリアル補正実施年月日().isEmpty() ? RString.EMPTY
                    : DateConverter.toWarekiHalf_Zero(
                            new RDate(result.getリアル補正実施年月日().toString())));
            row.setTxtSofuNengetsu(result.get補正済自己負担額情報送付年月() == null || result.get補正済自己負担額情報送付年月().isEmpty() ? RString.EMPTY
                    : new RString(result.get補正済自己負担額情報送付年月().toString()));
            row.setTxtDataKBN(result.getデータ作成区分() == null ? RString.EMPTY
                    : result.getデータ作成区分());
            rowList.add(row);
        }
        div.getDgJohoIchiran().setDataSource(rowList);
    }

    /**
     * onLoad時アクセスログ出力します。
     *
     * @param resultList List<KogakuGassanJikoFutanGaku>
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     */
    public void 履歴を表示printLog(List<KogakuGassanJikoFutanGaku> resultList, ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        List<dgJohoIchiran_Row> rowList = new ArrayList();
        List<PersonalData> personalDataList = new ArrayList();
        for (KogakuGassanJikoFutanGaku result : resultList) {
            dgJohoIchiran_Row row = new dgJohoIchiran_Row();
            row.setTxtTaishoNendo(result.get対象年度().toDateString());
            row.setTxtSanteiKubun(set算定区分(result.get異動区分()));
            row.setTxtHokenshaNo(result.get保険者番号().getColumnValue());
            row.setTxtShikyuShinseishoSeiriNo(result.get支給申請書整理番号());
            row.setTxtIdoKubun(result.get異動区分() == null ? RString.EMPTY
                    : KaigoGassan_Idokubun.toValue(result.get異動区分()).get名称());
            row.setTxtRirekiNo(new RString(result.get履歴番号()));
            row.setTxtUketoriNengetsu(result.get自己負担額証明書情報受取年月() == null || result.get自己負担額証明書情報受取年月().isEmpty() ? RString.EMPTY
                    : result.get自己負担額証明書情報受取年月().toDateString());
            row.setTxtHoseiYMDTan(result.getバッチ補正実施年月日() == null || result.getバッチ補正実施年月日().isEmpty() ? RString.EMPTY
                    : DateConverter.toWarekiHalf_Zero(
                            new RDate(result.getバッチ補正実施年月日().toString())));
            row.setTxtSofuNengetsu(result.get補正済自己負担額情報送付年月() == null || result.get補正済自己負担額情報送付年月().isEmpty() ? RString.EMPTY
                    : new RString(result.get補正済自己負担額情報送付年月().toString()));
            row.setTxtDataKBN(result.getデータ作成区分() == null ? RString.EMPTY
                    : result.getデータ作成区分());
            rowList.add(row);
            ExpandedInformation expandedInfo = new ExpandedInformation(new Code(CODE_003),
                    名称_被保険者番号, 被保険者番号.getColumnValue());
            PersonalData personalData = PersonalData.of(識別コード, expandedInfo);
            personalDataList.add(personalData);
        }
        div.getDgJohoIchiran().setDataSource(rowList);
        AccessLogger.log(AccessLogType.照会, personalDataList);
    }

    private RString set算定区分(RString 異動区分) {
        if (異動区分_1.equals(異動区分) || 異動区分_2.equals(異動区分)) {
            return 本算定;
        } else if (異動区分_3.equals(異動区分)) {
            return 仮算定;
        }
        return RString.EMPTY;
    }

    /**
     * 窓口払情報開始日の制御事件です。
     *
     */
    public void onChange_txtMadoguchiKaishiYMD() {
        if (div.getTxtMadoguchiKaishiYMD().getValue() == null) {
            div.getTxtMadoguchiKaishiYoubi().clearValue();
        } else {
            RString 曜日 = new RString(div.getTxtMadoguchiKaishiYMD()
                    .getValue().getDayOfWeek().getShortTerm());
            div.getTxtMadoguchiKaishiYoubi().setValue(曜日);
        }
    }

    /**
     * 窓口払情報終了日の制御事件です。
     *
     */
    public void onChange_txtMadoguchiShuryoYMD() {
        if (div.getTxtMadoguchiShuryoYMD().getValue() == null) {
            div.getTxtMadoguchiShuryoYoubi().clearValue();
        } else {
            RString 曜日 = new RString(div.getTxtMadoguchiShuryoYMD()
                    .getValue().getDayOfWeek().getShortTerm());
            div.getTxtMadoguchiShuryoYoubi().setValue(曜日);
        }
    }

    /**
     * 履歴Dgdの選択ボタンの処理です。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param row dgJohoIchiran_Row
     * @return boolean
     */
    public boolean isCheckPass(HihokenshaNo 被保険者番号, dgJohoIchiran_Row row) {
        int 履歴番号 = Integer.parseInt(row.getTxtRirekiNo().toString());
        FlexibleYear 対象年度 = new FlexibleYear(row.getTxtTaishoNendo());
        HokenshaNo 保険者番号 = new HokenshaNo(row.getTxtHokenshaNo());
        RString 支給申請書整理番号 = row.getTxtShikyuShinseishoSeiriNo();
        KogakuGassanJikoFutanGakuManager manager = new KogakuGassanJikoFutanGakuManager();
        KogakuGassanJikoFutanGaku 高額合算自己負担額 = manager.getMax履歴番号(
                被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号);
        return 履歴番号 - 高額合算自己負担額.get履歴番号() == 0;
    }

    /**
     * 自己負担額一覧に戻るボタンクリック時の事件です。
     *
     * @param result KogakuGassanJikoFutanGaku
     * @return boolean
     */
    public boolean onClick_btnJikofutangakuJohoNiModoru(KogakuGassanJikoFutanGaku result) {
        return result == null ? false : 編集処理対象から画面(result).hasChanged();
    }

    /**
     * 編集処理対象から画面のメソッドです。
     *
     * @param result KogakuGassanJikoFutanGaku
     * @return KogakuGassanJikoFutanGaku
     */
    public KogakuGassanJikoFutanGaku 編集処理対象から画面(KogakuGassanJikoFutanGaku result) {
        return result.createBuilderForEdit()
                .set所得区分(div.getDdlShotokuKBN().getSelectedKey())
                .set所得区分_70歳以上の者に係る(div.getDdl70SaiIjouShotokuKBN().getSelectedKey())
                .set被保険者氏名(div.getTxtHihokenshaShimei() == null ? null
                        : new AtenaMeisho(div.getTxtHihokenshaShimei().getDomain().getColumnValue()))
                .set後期保険者番号(div.getTxtKoukiHokenjaNO().getValue())
                .set後期被保険者番号(div.getTxtKoukiHihokenshaNO().getValue())
                .set国保保険者番号(div.getTxtKokuhoHokenjaNO().getValue())
                .set国保被保険者証番号(div.getTxtKokuhoHihokenshashouNO().getValue())
                .set国保個人番号(div.getTxtKokuhoHihokenshaKojinNO().getValue())
                .set申請年月日(getDate(div.getTxtShinseiYMD().getValue()))
                .set対象計算期間開始年月日(getDate(div.getTxtTaishouKeisanKikan().getFromValue()))
                .set対象計算期間終了年月日(getDate(div.getTxtTaishouKeisanKikan().getToValue()))
                .set被保険者期間開始年月日(getDate(div.getTxtHihokenshaKikan().getFromValue()))
                .set被保険者期間終了年月日(getDate(div.getTxtHihokenshaKikan().getToValue()))
                .set宛先氏名(div.getTxtAtesakiShimei() == null ? null
                        : new AtenaMeisho(div.getTxtAtesakiShimei().getDomain().getColumnValue()))
                .set宛先郵便番号(div.getTxtAtesakiYubinNo().getValue())
                .set宛先住所(div.getTxtAtesakiJusho().getValue())
                .set支払場所(div.getTxtMadoguchiShiharaiBasho().getValue())
                .set支払期間開始年月日(getDate(div.getTxtMadoguchiKaishiYMD().getValue()))
                .set支払期間開始時間(set時間(div.getTxtMadoguchiKaishiJikan().getValue(), div.getTxtMadoguchiKaishiFun().getValue()))
                .set支払期間終了年月日(getDate(div.getTxtMadoguchiShuryoYMD().getValue()))
                .set支払期間終了時間(set時間(div.getTxtMadoguchiShuryoJikan().getValue(), div.getTxtMadoguchiShuryoFun().getValue()))
                .build();
    }

    private FlexibleDate getDate(RDate date) {
        if (date != null) {
            return new FlexibleDate(date.toDateString());
        }
        return null;
    }

    private RString set時間(RString 時, RString 分) {
        RString jikan = 時 == null ? RString.EMPTY : 時;
        RString fun = 分 == null ? RString.EMPTY : 分;
        if (jikan.isEmpty() || fun.isEmpty()) {
            RString 時間 = jikan.concat(fun);
            return RString.isNullOrEmpty(時間) ? null : 時間;
        } else {
            RString 時間 = jikan.padZeroToLeft(2).concat(fun.padZeroToLeft(2));
            return RString.isNullOrEmpty(時間) ? null : 時間;
        }
    }

    /**
     * 履歴Dgdの選択ボタンの処理です。
     *
     * @param result KogakuGassanJikoFutanGaku
     */
    public void onSelect_dgRireki(KogakuGassanJikoFutanGaku result) {
        init自己負担額管理情報入力共通(result);
        init自己負担管理情報１タブ(result);
        init自己負担管理情報２タブ(result);
    }

    /**
     * 編集処理対象から画面のメソッドです。
     *
     * @param result KogakuGassanJikoFutanGaku
     * @param 自己負担額保持 KogakuGassanJikofutangakuHosei
     * @return KogakuGassanJikoFutanGaku
     */
    public KogakuGassanJikoFutanGaku 編集処理対象から保持Entity(
            KogakuGassanJikoFutanGaku result, KogakuGassanJikofutangakuHosei 自己負担額保持) {
        return result.createBuilderForEdit()
                .set補正済_合計_自己負担額(自己負担額保持.get変更後_合計_補正後_自己負担額())
                .set補正済_合計_70_74自己負担額_内訳(
                        自己負担額保持.get変更後_合計_補正後_うち70_74歳に係る負担額())
                .set補正済_合計_70未満高額支給額(自己負担額保持.get変更後_合計_補正後_高額介護_予防_サービス費())
                .build();
    }

    /**
     * 負担額明細一覧を返します。
     *
     * @param 自己負担額保持 JigyoKogakuGassanJikofutangakuHosei
     * @return List<KogakuGassanJikoFutanGakuMeisai>
     */
    public List<KogakuGassanJikoFutanGakuMeisai> setFutanGakuMeisai(
            KogakuGassanJikofutangakuHosei 自己負担額保持) {
        KogakuGassanJikoFutanGakuMeisaiManager manager = new KogakuGassanJikoFutanGakuMeisaiManager();
        List<KogakuGassanJikoFutanGakuMeisai> resultList = manager.get対象月除く負担額明細(
                自己負担額保持.get被保険者番号(),
                自己負担額保持.get対象年度(),
                自己負担額保持.get保険者番号(),
                自己負担額保持.get支給申請書整理番号(),
                Integer.parseInt(自己負担額保持.get履歴番号().toString()));
        return setResultList(resultList, 自己負担額保持);
    }

    private void init自己負担額管理情報入力共通(KogakuGassanJikoFutanGaku result) {
        JikoFutangakuHoseiDetailDiv detailDiv = div.getJikoFutangakuHoseiDetail();
        detailDiv.getTxtSanteiKBN().setValue(set算定区分(result.get異動区分()));
        detailDiv.getTxtTaishouNendo().setValue(new RDate(result.get対象年度().getYearValue()));
        detailDiv.getTxtShoukisaiHokenjaNO().setValue(result.get保険者番号().getColumnValue());
        detailDiv.getTxtShikyuShinseiSeiriNO().setValue(result.get支給申請書整理番号());
        if (result.get自己負担額証明書情報受取年月() == null || result.get自己負担額証明書情報受取年月().isEmpty()) {
            detailDiv.getTxtUketoriYM().clearValue();
        } else {
            detailDiv.getTxtUketoriYM().setValue(new RDate(
                    result.get自己負担額証明書情報受取年月().toString()));
        }
        List<RString> 再送フラグList = new ArrayList();
        if (CODE_ONE.equals(result.get再送フラグ())) {
            再送フラグList.add(KEY_ZERO);
            detailDiv.getChkSaisouKBN().setSelectedItemsByKey(再送フラグList);
        }
        List<RString> 送付対象外フラグList = new ArrayList();
        if (CODE_ONE.equals(result.get送付対象外フラグ())) {
            送付対象外フラグList.add(KEY_ZERO);
            detailDiv.getChkSoufuTaishougai().setSelectedItemsByKey(送付対象外フラグList);
        }
        if (result.getバッチ補正実施年月日() == null || result.getバッチ補正実施年月日().isEmpty()) {
            detailDiv.getTxtHoseibiKatsu().clearValue();
        } else {
            detailDiv.getTxtHoseibiKatsu().setValue(new RDate(result.getバッチ補正実施年月日().toString()));
        }
        if (result.getリアル補正実施年月日() == null || result.getリアル補正実施年月日().isEmpty()) {
            detailDiv.getTxtHoseibiTan().clearValue();
        } else {
            detailDiv.getTxtHoseibiTan().setValue(new RDate(result.getリアル補正実施年月日().toString()));
        }
    }

    private void init自己負担管理情報１タブ(KogakuGassanJikoFutanGaku result) {
        tplJikofutanKanriJoho1Div kanriJohoDiv1
                = div.getJikoFutangakuHoseiDetail().getTplJikofutanKanriJoho1();
        kanriJohoDiv1.getTxtIdouKBN().setValue(result.get異動区分() == null ? RString.EMPTY
                : KaigoGassan_Idokubun.toValue(result.get異動区分()).get名称());
        kanriJohoDiv1.getDdlShotokuKBN().setIsBlankLine(false);
        kanriJohoDiv1.getDdlShotokuKBN().setDataSource(set所得区分(result.get対象年度()));
        if (RString.isNullOrEmpty(result.get所得区分())) {
            kanriJohoDiv1.getDdlShotokuKBN().setSelectedIndex(0);
        } else {
            kanriJohoDiv1.getDdlShotokuKBN().setSelectedKey(result.get所得区分());
        }
        kanriJohoDiv1.getDdl70SaiIjouShotokuKBN().setDataSource(set70歳以上所得区分());
        if (result.get70歳以上の者に係る所得区分() == null || result.get70歳以上の者に係る所得区分().isEmpty()) {
            kanriJohoDiv1.getDdl70SaiIjouShotokuKBN().setSelectedIndex(0);
        } else {
            kanriJohoDiv1.getDdl70SaiIjouShotokuKBN().setSelectedKey(
                    result.get70歳以上の者に係る所得区分());
        }
        if (result.get被保険者氏名() == null) {
            kanriJohoDiv1.getTxtHihokenshaShimei().clearDomain();
        } else {
            kanriJohoDiv1.getTxtHihokenshaShimei().setDomain(result.get被保険者氏名());
        }
        if (result.get後期保険者番号() == null) {
            kanriJohoDiv1.getTxtKoukiHokenjaNO().clearValue();
        } else {
            kanriJohoDiv1.getTxtKoukiHokenjaNO().setValue(result.get後期保険者番号());
        }
        if (result.get後期被保険者番号() == null) {
            kanriJohoDiv1.getTxtKoukiHihokenshaNO().clearValue();
        } else {
            kanriJohoDiv1.getTxtKoukiHihokenshaNO().setValue(result.get後期被保険者番号());
        }
        if (result.get国保保険者番号() == null) {
            kanriJohoDiv1.getTxtKokuhoHokenjaNO().clearValue();
        } else {
            kanriJohoDiv1.getTxtKokuhoHokenjaNO().setValue(result.get国保保険者番号());
        }
        if (result.get国保個人番号() == null) {
            kanriJohoDiv1.getTxtKokuhoHihokenshaKojinNO().clearValue();
        } else {
            kanriJohoDiv1.getTxtKokuhoHihokenshaKojinNO().setValue(result.get国保個人番号());
        }
        if (result.get国保被保険者証番号() == null) {
            kanriJohoDiv1.getTxtKokuhoHihokenshashouNO().clearValue();
        } else {
            kanriJohoDiv1.getTxtKokuhoHihokenshashouNO().setValue(result.get国保被保険者証番号());
        }
        編集年月日(result, kanriJohoDiv1);
    }

    private void init自己負担管理情報２タブ(KogakuGassanJikoFutanGaku result) {
        tplJikofutanKanriJoho2Div kanriJohoDiv2
                = div.getJikoFutangakuHoseiDetail().getTplJikofutanKanriJoho2();
        if (result.get宛先氏名() == null) {
            kanriJohoDiv2.getTxtAtesakiShimei().clearDomain();
        } else {
            kanriJohoDiv2.getTxtAtesakiShimei().setDomain(result.get宛先氏名());
        }
        if (result.get宛先郵便番号() == null) {
            kanriJohoDiv2.getTxtAtesakiYubinNo().clearValue();
        } else {
            kanriJohoDiv2.getTxtAtesakiYubinNo().setValue(result.get宛先郵便番号());
        }
        if (result.get宛先住所() == null) {
            kanriJohoDiv2.getTxtAtesakiJusho().clearValue();
        } else {
            kanriJohoDiv2.getTxtAtesakiJusho().setValue(result.get宛先住所());
        }
        kanriJohoDiv2.getTxtMadoguchiTaishoushaHantei().
                setValue(set対象者判定(result.get窓口払対象者判定コード()));
        if (result.get支払場所() == null) {
            kanriJohoDiv2.getTxtMadoguchiShiharaiBasho().clearValue();
        } else {
            kanriJohoDiv2.getTxtMadoguchiShiharaiBasho().setValue(result.get支払場所());
        }
        set開始終了日(result);
    }

    private void set開始終了日(KogakuGassanJikoFutanGaku result) {
        if (result.get支払期間開始年月日() == null || result.get支払期間開始年月日().isEmpty()) {
            div.getTxtMadoguchiKaishiYMD().clearValue();
            div.getTxtMadoguchiKaishiYoubi().clearValue();
        } else {
            div.getTxtMadoguchiKaishiYMD().setValue(
                    new RDate(result.get支払期間開始年月日().toString()));
            div.getTxtMadoguchiKaishiYoubi().setValue(
                    new RString(result.get支払期間開始年月日().getDayOfWeek().getShortTerm()));
        }
        if (result.get支払期間開始時間() == null || result.get支払期間開始時間().isEmpty()) {
            div.getTxtMadoguchiKaishiJikan().clearValue();
            div.getTxtMadoguchiKaishiFun().clearValue();
        } else {
            div.getTxtMadoguchiKaishiJikan().setValue(result.get支払期間開始時間().substring(INT_0, INT_2));
            div.getTxtMadoguchiKaishiFun().setValue(result.get支払期間開始時間().substring(INT_2, INT_4));
        }
        if (result.get支払期間終了年月日() == null || result.get支払期間終了年月日().isEmpty()) {
            div.getTxtMadoguchiShuryoYMD().clearValue();
            div.getTxtMadoguchiShuryoYoubi().clearValue();
        } else {
            div.getTxtMadoguchiShuryoYMD().setValue(
                    new RDate(result.get支払期間終了年月日().toString()));
            div.getTxtMadoguchiShuryoYoubi().setValue(
                    new RString(result.get支払期間終了年月日().getDayOfWeek().getShortTerm()));
        }
        if (result.get支払期間終了時間() == null || result.get支払期間終了時間().isEmpty()) {
            div.getTxtMadoguchiShuryoJikan().clearValue();
            div.getTxtMadoguchiShuryoFun().clearValue();
        } else {
            div.getTxtMadoguchiShuryoJikan().setValue(result.get支払期間終了時間().substring(INT_0, INT_2));
            div.getTxtMadoguchiShuryoFun().setValue(result.get支払期間終了時間().substring(INT_2, INT_4));
        }
    }

    private RString set対象者判定(RString 窓口払対象者判定コード) {
        if (CODE_ONE.equals(窓口払対象者判定コード)) {
            return 非該当;
        } else if (CODE_TWO.equals(窓口払対象者判定コード)) {
            return 該当;
        }
        return RString.EMPTY;
    }

    private List<KeyValueDataSource> set70歳以上所得区分() {
        List<KeyValueDataSource> dataSource = new ArrayList();
        for (KaigoGassan_Over70_ShotokuKbn type : KaigoGassan_Over70_ShotokuKbn.values()) {
            dataSource.add(new KeyValueDataSource(type.getCode(), type.get名称()));
        }
        return dataSource;
    }

    private void 編集年月日(KogakuGassanJikoFutanGaku result,
            tplJikofutanKanriJoho1Div kanriJohoDiv1) throws IllegalArgumentException {
        if (result.get申請年月日() == null) {
            kanriJohoDiv1.getTxtShinseiYMD().clearValue();
        } else {
            kanriJohoDiv1.getTxtShinseiYMD().setValue(new RDate(result.get申請年月日().toString()));
        }
        if (result.get対象計算期間開始年月日() == null) {
            kanriJohoDiv1.getTxtTaishouKeisanKikan().clearFromValue();
        } else {
            kanriJohoDiv1.getTxtTaishouKeisanKikan().setFromValue(
                    new RDate(result.get対象計算期間開始年月日().toString()));
        }
        if (result.get対象計算期間終了年月日() == null) {
            kanriJohoDiv1.getTxtTaishouKeisanKikan().clearToValue();
        } else {
            kanriJohoDiv1.getTxtTaishouKeisanKikan().setToValue(
                    new RDate(result.get対象計算期間終了年月日().toString()));
        }
        if (result.get被保険者期間開始年月日() == null) {
            kanriJohoDiv1.getTxtHihokenshaKikan().clearFromValue();
        } else {
            kanriJohoDiv1.getTxtHihokenshaKikan().setFromValue(
                    new RDate(result.get被保険者期間開始年月日().toString()));
        }
        if (result.get被保険者期間終了年月日() == null) {
            kanriJohoDiv1.getTxtHihokenshaKikan().clearToValue();
        } else {
            kanriJohoDiv1.getTxtHihokenshaKikan().setToValue(
                    new RDate(result.get被保険者期間終了年月日().toString()));
        }
    }

    private List<KeyValueDataSource> set所得区分(FlexibleYear 対象年度) {
        int 年度 = 対象年度.getYearValue();
        List<KeyValueDataSource> h25年度以前 = new ArrayList();
        h25年度以前.add(new KeyValueDataSource(所得区分_課税, 課税));
        h25年度以前.add(new KeyValueDataSource(所得区分_非課税, 非課税));
        h25年度以前.add(new KeyValueDataSource(KaigoGassan_ShotokuKbn.上位所得者.getCode(),
                KaigoGassan_ShotokuKbn.上位所得者.get名称()));
        List<KeyValueDataSource> h26年度以降 = new ArrayList();
        List<KeyValueDataSource> h27年1月以降 = new ArrayList();
        for (KaigoGassan_ShotokuKbn type : KaigoGassan_ShotokuKbn.values()) {
            if (type.getCode() == null || type.getCode().isEmpty()) {
                h27年1月以降.add(new KeyValueDataSource(RString.HALF_SPACE, type.get名称()));
            } else {
                h27年1月以降.add(new KeyValueDataSource(type.getCode(), type.get名称()));
            }
            if (KaigoGassan_ShotokuKbn.区分ア.get名称().equals(type.get名称())
                    || KaigoGassan_ShotokuKbn.区分イ.get名称().equals(type.get名称())
                    || KaigoGassan_ShotokuKbn.区分ウ.get名称().equals(type.get名称())
                    || KaigoGassan_ShotokuKbn.区分エ.get名称().equals(type.get名称())
                    || KaigoGassan_ShotokuKbn.区分オ.get名称().equals(type.get名称())) {
                h26年度以降.add(new KeyValueDataSource(type.getCode(), type.get名称()));
            }
        }
        if (年度_2013 - 年度 >= 0) {
            return h25年度以前;
        } else if (年度_2014 - 年度 < 0 && 年度_2015 - 年度 <= 0) {
            return h26年度以降;
        } else {
            return h27年1月以降;
        }
    }

    private List<KogakuGassanJikoFutanGakuMeisai> setResultList(
            List<KogakuGassanJikoFutanGakuMeisai> resultList,
            KogakuGassanJikofutangakuHosei 自己負担額保持) {
        List<KogakuGassanJikoFutanGakuMeisai> businessList = new ArrayList();
        for (KogakuGassanJikoFutanGakuMeisai item : resultList) {
            switch (item.get対象月().toString()) {
                case "004":
                    item = item.createBuilderForEdit().set補正済_自己負担額(自己負担額保持.get変更後_補正後_自己負担額_4月分())
                            .set補正済_70_74自己負担額_内数(自己負担額保持.get変更後_補正後_うち70_74歳に係る負担額_4月分())
                            .set補正済_70未満高額支給額(自己負担額保持.get変更後_補正後_高額介護_予防_サービス費_4月分()).build();
                    businessList.add(item);
                    break;
                case "005":
                    item = item.createBuilderForEdit().set補正済_自己負担額(自己負担額保持.get変更後_補正後_自己負担額_5月分())
                            .set補正済_70_74自己負担額_内数(自己負担額保持.get変更後_補正後_うち70_74歳に係る負担額_5月分())
                            .set補正済_70未満高額支給額(自己負担額保持.get変更後_補正後_高額介護_予防_サービス費_5月分()).build();
                    businessList.add(item);
                    break;
                case "006":
                    item = item.createBuilderForEdit().set補正済_自己負担額(自己負担額保持.get変更後_補正後_自己負担額_6月分())
                            .set補正済_70_74自己負担額_内数(自己負担額保持.get変更後_補正後_うち70_74歳に係る負担額_6月分())
                            .set補正済_70未満高額支給額(自己負担額保持.get変更後_補正後_高額介護_予防_サービス費_6月分()).build();
                    businessList.add(item);
                    break;
                case "007":
                    item = item.createBuilderForEdit().set補正済_自己負担額(自己負担額保持.get変更後_補正後_自己負担額_7月分())
                            .set補正済_70_74自己負担額_内数(自己負担額保持.get変更後_補正後_うち70_74歳に係る負担額_7月分())
                            .set補正済_70未満高額支給額(自己負担額保持.get変更後_補正後_高額介護_予防_サービス費_7月分()).build();
                    businessList.add(item);
                    break;
                case "008":
                    item = item.createBuilderForEdit().set補正済_自己負担額(自己負担額保持.get変更後_補正後_自己負担額_8月分())
                            .set補正済_70_74自己負担額_内数(自己負担額保持.get変更後_補正後_うち70_74歳に係る負担額_8月分())
                            .set補正済_70未満高額支給額(自己負担額保持.get変更後_補正後_高額介護_予防_サービス費_8月分()).build();
                    businessList.add(item);
                    break;
                case "009":
                    item = item.createBuilderForEdit().set補正済_自己負担額(自己負担額保持.get変更後_補正後_自己負担額_9月分())
                            .set補正済_70_74自己負担額_内数(自己負担額保持.get変更後_補正後_うち70_74歳に係る負担額_9月分())
                            .set補正済_70未満高額支給額(自己負担額保持.get変更後_補正後_高額介護_予防_サービス費_9月分()).build();
                    businessList.add(item);
                    break;
                case "010":
                    item = item.createBuilderForEdit().set補正済_自己負担額(自己負担額保持.get変更後_補正後_自己負担額_10月分())
                            .set補正済_70_74自己負担額_内数(自己負担額保持.get変更後_補正後_うち70_74歳に係る負担額_10月分())
                            .set補正済_70未満高額支給額(自己負担額保持.get変更後_補正後_高額介護_予防_サービス費_10月分()).build();
                    businessList.add(item);
                    break;
                case "011":
                    item = item.createBuilderForEdit().set補正済_自己負担額(自己負担額保持.get変更後_補正後_自己負担額_11月分())
                            .set補正済_70_74自己負担額_内数(自己負担額保持.get変更後_補正後_うち70_74歳に係る負担額_11月分())
                            .set補正済_70未満高額支給額(自己負担額保持.get変更後_補正後_高額介護_予防_サービス費_11月分()).build();
                    businessList.add(item);
                    break;
                case "012":
                    item = item.createBuilderForEdit().set補正済_自己負担額(自己負担額保持.get変更後_補正後_自己負担額_12月分())
                            .set補正済_70_74自己負担額_内数(自己負担額保持.get変更後_補正後_うち70_74歳に係る負担額_12月分())
                            .set補正済_70未満高額支給額(自己負担額保持.get変更後_補正後_高額介護_予防_サービス費_12月分()).build();
                    businessList.add(item);
                    break;
                case "101":
                    item = item.createBuilderForEdit().set補正済_自己負担額(自己負担額保持.get変更後_補正後_自己負担額_翌年1月分())
                            .set補正済_70_74自己負担額_内数(自己負担額保持.get変更後_補正後_うち70_74歳に係る負担額_翌年1月分())
                            .set補正済_70未満高額支給額(自己負担額保持.get変更後_補正後_高額介護_予防_サービス費_翌年1月分()).build();
                    businessList.add(item);
                    break;
                case "102":
                    item = item.createBuilderForEdit().set補正済_自己負担額(自己負担額保持.get変更後_補正後_自己負担額_翌年2月分())
                            .set補正済_70_74自己負担額_内数(自己負担額保持.get変更後_補正後_うち70_74歳に係る負担額_翌年2月分())
                            .set補正済_70未満高額支給額(自己負担額保持.get変更後_補正後_高額介護_予防_サービス費_翌年2月分()).build();
                    businessList.add(item);
                    break;
                case "103":
                    item = item.createBuilderForEdit().set補正済_自己負担額(自己負担額保持.get変更後_補正後_自己負担額_翌年3月分())
                            .set補正済_70_74自己負担額_内数(自己負担額保持.get変更後_補正後_うち70_74歳に係る負担額_翌年3月分())
                            .set補正済_70未満高額支給額(自己負担額保持.get変更後_補正後_高額介護_予防_サービス費_翌年3月分()).build();
                    businessList.add(item);
                    break;
                case "104":
                    item = item.createBuilderForEdit().set補正済_自己負担額(自己負担額保持.get変更後_補正後_自己負担額_翌年4月分())
                            .set補正済_70_74自己負担額_内数(自己負担額保持.get変更後_補正後_うち70_74歳に係る負担額_翌年4月分())
                            .set補正済_70未満高額支給額(自己負担額保持.get変更後_補正後_高額介護_予防_サービス費_翌年4月分()).build();
                    businessList.add(item);
                    break;
                case "105":
                    item = item.createBuilderForEdit().set補正済_自己負担額(自己負担額保持.get変更後_補正後_自己負担額_翌年5月分())
                            .set補正済_70_74自己負担額_内数(自己負担額保持.get変更後_補正後_うち70_74歳に係る負担額_翌年5月分())
                            .set補正済_70未満高額支給額(自己負担額保持.get変更後_補正後_高額介護_予防_サービス費_翌年5月分()).build();
                    businessList.add(item);
                    break;
                case "106":
                    item = item.createBuilderForEdit().set補正済_自己負担額(自己負担額保持.get変更後_補正後_自己負担額_翌年6月分())
                            .set補正済_70_74自己負担額_内数(自己負担額保持.get変更後_補正後_うち70_74歳に係る負担額_翌年6月分())
                            .set補正済_70未満高額支給額(自己負担額保持.get変更後_補正後_高額介護_予防_サービス費_翌年6月分()).build();
                    businessList.add(item);
                    break;
                case "107":
                    item = item.createBuilderForEdit().set補正済_自己負担額(自己負担額保持.get変更後_補正後_自己負担額_翌年7月分())
                            .set補正済_70_74自己負担額_内数(自己負担額保持.get変更後_補正後_うち70_74歳に係る負担額_翌年7月分())
                            .set補正済_70未満高額支給額(自己負担額保持.get変更後_補正後_高額介護_予防_サービス費_翌年7月分()).build();
                    businessList.add(item);
                    break;
                default:
                    break;
            }
        }
        return businessList;
    }

    /**
     * 再送区分送付対象外制御の処理です。
     *
     * @param flg boolean
     * @param result KogakuGassanJikoFutanGaku
     */
    public void 再送区分送付対象外制御(boolean flg, KogakuGassanJikoFutanGaku result) {
        if (flg) {
            div.getJikoFutangakuHoseiDetail().getChkSoufuTaishougai().setDisabled(false);
            if (result.get補正済自己負担額情報送付年月() != null) {
                div.getChkSaisouKBN().setDisabled(false);
            } else if (CODE_ONE.equals(result.get送付対象外フラグ())) {
                div.getChkSaisouKBN().setDisabled(true);
            } else {
                div.getChkSaisouKBN().setDisabled(true);
            }
        } else {
            div.getJikoFutangakuHoseiDetail().getChkSoufuTaishougai().setDisabled(true);
            div.getChkSaisouKBN().setDisabled(true);
        }
    }
}
