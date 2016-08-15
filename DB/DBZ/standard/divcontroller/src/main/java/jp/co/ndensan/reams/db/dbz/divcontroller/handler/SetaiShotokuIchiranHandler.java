/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.config.FukaKeisanConfig;
import jp.co.ndensan.reams.db.dbz.business.config.NenreiTotatsuChecker;
import jp.co.ndensan.reams.db.dbz.business.config.ShotokuHikidashiConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiShotokuIchiranComparators;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShotokuRirekiIchiranComparators;
import jp.co.ndensan.reams.db.dbz.business.core.view.KaigoShotokuAlive;
import jp.co.ndensan.reams.db.dbx.definition.core.config.ConfigKeysHizuke;
import jp.co.ndensan.reams.db.dbz.definition.core.config.ConfigKeysNenreiTotatsuKijunJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.GekihenkanwaSochi;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.TorokuGyomu;
import jp.co.ndensan.reams.db.dbz.definition.core.util.accesslog.ExpandedInfomations;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.SetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.SetaiShotokuIchiranDiv.DisplayMode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.dgSetaiShotoku_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.dgShotokuRireki_Row;
import jp.co.ndensan.reams.db.dbz.service.core.setaiinshotokujoho.SetaiinShotokuJohoFinder;
import jp.co.ndensan.reams.db.dbz.service.core.view.ShotokuManager;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.Month;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.Comparators;

/**
 * {@link KaokuSearchParentDiv}のHandlerクラスです。
 */
public class SetaiShotokuIchiranHandler {

    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private static final int INDEX_9 = 9;
    private static final int INDEX_13 = 13;
    private static final RString BR = new RString("<br>");
    private final SetaiShotokuIchiranDiv div;
    private final DataGridSetting setaiShotokuGridSetting;
    private final DataGridSetting shotokuRirekiGridSetting;

    /**
     * コンストラクタです。
     *
     * @param div 世帯所得一覧Div
     */
    public SetaiShotokuIchiranHandler(SetaiShotokuIchiranDiv div) {
        this.div = div;
        this.setaiShotokuGridSetting = div.getDgSetaiShotoku().getGridSetting();
        this.shotokuRirekiGridSetting = div.getDgShotokuRireki().getGridSetting();
    }

    /**
     * Divの初期化を行います。
     *
     * @param 識別コード 識別コード
     * @param 世帯基準年月日 世帯基準年月日
     * @param 所得年度 所得年度
     * @param 所得基準年月日時分秒 所得基準年月日時分秒
     */
    public void initialize(ShikibetsuCode 識別コード, FlexibleDate 世帯基準年月日, FlexibleYear 所得年度, YMDHMS 所得基準年月日時分秒) {
        div.setTxtShikibetsuCode(識別コード.value());
        div.setTxtShotokuKijunYMDHMS(所得基準年月日時分秒.wareki().toDateString());
        div.getTxtSetaiIchiranKazeiNendo().setDomain(所得年度);
        div.getTxtSetaiIchiranKijunYMD().setValue(new RDate(世帯基準年月日.toString()));
        日付関連_所得年度コンフィグによる制御(所得年度);
        DisplayMode mode = div.getMode_DisplayMode();
        if (mode.equals(DisplayMode.FukaShokai)) {
            initialize賦課照会モード();
        } else if (mode.equals(DisplayMode.ShotokuShokai)) {
            initialize所得照会モード();
        } else if (mode.equals(DisplayMode.ShotokuRirekiShokai)) {
            initialize所得履歴照会モード();
        } else if (mode.equals(DisplayMode.KogakuKaigoServicehi)) {
            initialize高額介護サービス費モード();
        }
        List<SetaiinShotoku> setaiinShotokuList = get世帯員所得Data(識別コード, 所得基準年月日時分秒);
        set住民税減免前_後表示制御情報TO世帯一覧();
        set激変緩和表示制御情報TO世帯一覧();
        load世帯員所得一覧(setaiinShotokuList);
        set世帯一覧行選択制御();
    }

    /**
     * 賦課照会モードでDivの初期化を行います。
     */
    void initialize賦課照会モード() {
        setaiShotokuGridSetting.getColumns().get(INDEX_13).setVisible(false);
        div.getDgSetaiShotoku().setGridSetting(setaiShotokuGridSetting);
    }

    /**
     * 所得照会モードでDivの初期化を行います。
     */
    void initialize所得照会モード() {
        setaiShotokuGridSetting.getColumns().get(INDEX_13).setVisible(false);
        div.getDgSetaiShotoku().setGridSetting(setaiShotokuGridSetting);
    }

    /**
     * 所得履歴照会モードでDivの初期化を行います。
     */
    void initialize所得履歴照会モード() {
        setaiShotokuGridSetting.getColumns().get(INDEX_13).setVisible(true);
        div.getDgSetaiShotoku().setGridSetting(setaiShotokuGridSetting);
    }

    /**
     * 高額介護サービス費モードでDivの初期化を行います。
     */
    void initialize高額介護サービス費モード() {
        setaiShotokuGridSetting.getColumns().get(INDEX_13).setVisible(true);
        div.getDgSetaiShotoku().setGridSetting(setaiShotokuGridSetting);
    }

    /**
     * {@link SetaiinShotoku}情報を取得し{@link SetaiShotokuIchiranDiv}にセットします。 <br/>
     * 世帯員所得情報の取得
     *
     * @param 識別コード 識別コード
     * @param 所得基準年月日 所得基準年月日
     * @return 世帯員所得情報リスト
     */
    public List<SetaiinShotoku> get世帯員所得Data(ShikibetsuCode 識別コード, YMDHMS 所得基準年月日) {
        // 現在設定されている共有子Divのモードを取得する
        DisplayMode mode = div.getMode_DisplayMode();
        SetaiinShotokuJohoFinder 世帯員所得情報Finder = SetaiinShotokuJohoFinder.createInstance();
        List<SetaiinShotoku> 世帯員所得情報 = new ArrayList();
        // 世帯員所得情報を取得する。モードにより条件を変更する。
        // 賦課照会モードのとき
        if (mode.equals(DisplayMode.FukaShokai)) {
            世帯員所得情報 = 世帯員所得情報Finder.get世帯員所得情報(識別コード,
                    new FlexibleDate(div.getTxtSetaiIchiranKijunYMD().getValue().toDateString()),
                    div.getTxtSetaiIchiranKazeiNendo().getDomain(), 所得基準年月日, false);
            // 所得照会モードのとき
        } else if (mode.equals(DisplayMode.ShotokuShokai)) {
            世帯員所得情報 = 世帯員所得情報Finder.get世帯員所得情報(識別コード, new FlexibleYear(new RDate(
                    div.getDdlSetaiIchiranKazeiNendo().getSelectedValue().toString()).getYear().toDateString()), 所得基準年月日);
            // 高額介護サービス費のとき
        } else if (mode.equals(DisplayMode.KogakuKaigoServicehi)) {
            世帯員所得情報 = 世帯員所得情報Finder.get世帯員所得情報(識別コード,
                    new FlexibleDate(div.getTxtSetaiIchiranKijunYMD().getValue().toDateString()),
                    new FlexibleYear(new RDate(div.getDdlSetaiIchiranKazeiNendo().getSelectedValue().toString())
                            .getYear().toDateString()), 所得基準年月日, true);
        }
        // 世帯所得情報リスト内のソート
        return ItemList.of(世帯員所得情報).sorted(new Comparators.MultiComparator<>(
                SetaiShotokuIchiranComparators.orderBy本人区分.desc(),
                SetaiShotokuIchiranComparators.orderBy住民票表示順
        )).toList();
    }

    /**
     * {@link SetaiinShotoku}情報を{@link SetaiShotokuIchiranDiv}にセットします。<br/>
     * 最新世帯員所得情報の取得
     *
     * @param 識別コード 識別コード
     * @return 世帯員所得情報リスト
     */
    public List<SetaiinShotoku> set最新世帯員所得情報(ShikibetsuCode 識別コード) {
        DisplayMode mode = div.getMode_DisplayMode();
        SetaiinShotokuJohoFinder 世帯員所得情報Finder = SetaiinShotokuJohoFinder.createInstance();
        List<SetaiinShotoku> 世帯員所得情報 = new ArrayList();
        if (mode.equals(DisplayMode.FukaShokai)) {
            世帯員所得情報 = 世帯員所得情報Finder.get世帯員所得情報(識別コード, FlexibleDate.getNowDate(),
                    div.getTxtSetaiIchiranKazeiNendo().getDomain(), YMDHMS.now(), false);
        } else if (mode.equals(DisplayMode.KogakuKaigoServicehi)) {
            世帯員所得情報 = 世帯員所得情報Finder.get世帯員所得情報(識別コード, FlexibleDate.getNowDate(),
                    new FlexibleYear(new RDate(div.getDdlSetaiIchiranKazeiNendo().getSelectedValue().toString())
                            .getYear().toDateString()), YMDHMS.now(), true);
        }
        return ItemList.of(世帯員所得情報).sorted(
                new Comparators.MultiComparator<>(
                        SetaiShotokuIchiranComparators.orderBy本人区分.desc(),
                        SetaiShotokuIchiranComparators.orderBy住民票表示順
                )
        ).toList();
    }

    /**
     * {@link SetaiinShotoku}情報を{@link SetaiShotokuIchiranDiv}にセットします。<br/>
     * 住民税減免前/後の表示制御
     */
    public void set住民税減免前_後表示制御情報TO世帯一覧() {
        ShotokuHikidashiConfig shotokuHikidashiConfig = new ShotokuHikidashiConfig();
        RString juminzeiGenmenHyojiKubun = shotokuHikidashiConfig.get所得引出_住民税減免前後表示区分();
        if (juminzeiGenmenHyojiKubun.equals(new RString("0"))) {
            //住民税減免前,減免後が非表示になっているか要確認
            setaiShotokuGridSetting.getColumns().get(INDEX_6).setVisible(false);
            setaiShotokuGridSetting.getColumns().get(INDEX_7).setVisible(false);
            setaiShotokuGridSetting.getColumns().get(INDEX_8).setVisible(true);
            div.getDgSetaiShotoku().setGridSetting(setaiShotokuGridSetting);
        } else if (juminzeiGenmenHyojiKubun.equals(new RString("1"))) {
            setaiShotokuGridSetting.getColumns().get(INDEX_6).setVisible(true);
            setaiShotokuGridSetting.getColumns().get(INDEX_7).setVisible(true);
            setaiShotokuGridSetting.getColumns().get(INDEX_8).setVisible(false);
        }
        div.getDgSetaiShotoku().setGridSetting(setaiShotokuGridSetting);
    }

    /**
     * {@link SetaiinShotoku}情報を{@link SetaiShotokuIchiranDiv}にセットします。<br/>
     * 住民税減免前/後の表示制御
     */
    public void set住民税減免前_後表示制御情報TO所得履歴一覧() {
        ShotokuHikidashiConfig shotokuHikidashiConfig = new ShotokuHikidashiConfig();
        RString juminzeiGenmenHyojiKubun = shotokuHikidashiConfig.get所得引出_住民税減免前後表示区分();
        if (juminzeiGenmenHyojiKubun.equals(new RString("0"))) {
            shotokuRirekiGridSetting.getColumns().get(INDEX_3).setVisible(false);
            shotokuRirekiGridSetting.getColumns().get(INDEX_4).setVisible(false);
            shotokuRirekiGridSetting.getColumns().get(INDEX_5).setVisible(true);
            div.getDgSetaiShotoku().setGridSetting(shotokuRirekiGridSetting);
        } else if (juminzeiGenmenHyojiKubun.equals(new RString("1"))) {
            shotokuRirekiGridSetting.getColumns().get(INDEX_3).setVisible(true);
            shotokuRirekiGridSetting.getColumns().get(INDEX_4).setVisible(true);
            shotokuRirekiGridSetting.getColumns().get(INDEX_5).setVisible(false);
        }
        div.getDgShotokuRireki().setGridSetting(shotokuRirekiGridSetting);
    }

    /**
     * {@link SetaiinShotoku}情報を{@link SetaiShotokuIchiranDiv}にセットします。<br/>
     * 激変緩和の表示制御
     */
    public void set激変緩和表示制御情報TO世帯一覧() {
        FlexibleYear 賦課年度 = find賦課年度(div);
        if (賦課年度.isEmpty()) {
            return;
        }

        FukaKeisanConfig fukakeisanConfig = new FukaKeisanConfig();
        FlexibleYear 激変緩和開始年度 = fukakeisanConfig.get激変緩和開始年度();
        FlexibleYear 激変緩和終了年度 = fukakeisanConfig.get激変緩和終了年度();
        if (激変緩和開始年度.isBefore(賦課年度) && 賦課年度.isBefore(激変緩和終了年度)) {
            setaiShotokuGridSetting.getColumns().get(INDEX_9).setVisible(true);
        } else {
            setaiShotokuGridSetting.getColumns().get(INDEX_9).setVisible(false);
        }
        div.getDgSetaiShotoku().setGridSetting(setaiShotokuGridSetting);
    }

    private static FlexibleYear find賦課年度(SetaiShotokuIchiranDiv self) {
        switch (self.getMode_DisplayMode()) {
            case FukaShokai:
                return self.getTxtSetaiIchiranKazeiNendo().getDomain();
            case ShotokuShokai:
            case KogakuKaigoServicehi:
                return new FlexibleYear(
                        new RDate(self.getDdlSetaiIchiranKazeiNendo().getSelectedValue().toString())
                        .getYear().toDateString());
            default:
                return FlexibleYear.EMPTY;
        }
    }

    /**
     * {@link SetaiinShotoku}情報を{@link SetaiShotokuIchiranDiv}にセットします。<br/>
     * 激変緩和の表示制御
     */
    public void set激変緩和表示制御情報TO所得履歴一覧() {
        FlexibleYear 賦課年度 = find賦課年度(div);
        if (賦課年度.isEmpty()) {
            return;
        }

        FukaKeisanConfig fukakeisanConfig = new FukaKeisanConfig();
        FlexibleYear 激変緩和開始年度 = fukakeisanConfig.get激変緩和開始年度();
        FlexibleYear 激変緩和終了年度 = fukakeisanConfig.get激変緩和終了年度();

        if (激変緩和開始年度.isBefore(賦課年度) && 賦課年度.isBefore(激変緩和終了年度)) {
            shotokuRirekiGridSetting.getColumns().get(INDEX_6).setVisible(true);
        } else {
            shotokuRirekiGridSetting.getColumns().get(INDEX_6).setVisible(false);
        }
        div.getDgShotokuRireki().setGridSetting(shotokuRirekiGridSetting);
    }

    /**
     * {@link SetaiinShotoku}情報を{@link SetaiShotokuIchiranDiv}にセットします。<br/>
     * 画面表示_64歳未満場合の表示内容
     *
     * @param setaiinShotokuList {@link SetaiinShotoku}
     */
    public void load世帯員所得一覧(List<SetaiinShotoku> setaiinShotokuList) {
        ShotokuHikidashiConfig shotokuHikidashiConfig = new ShotokuHikidashiConfig();
        RString syotokuKingakuHyojiKubun = shotokuHikidashiConfig.get所得引出_64歳未満所得金額表示区分();
        // 所得引出_６４歳未満所得金額表示区分=0（表示しない）のとき
        if (syotokuKingakuHyojiKubun.equals(new RString("0"))) {
            DisplayMode mode = div.getMode_DisplayMode();
            // 画面.所得年度の４／１時点で６４歳未満の場合、以下の項目は空白で表示する。
            // 合計所得金額、年金収入額、年金所得額、課税所得額
            if (!has年齢到達From所得年度(mode)) {
                edit世帯員所得情報(setaiinShotokuList, false);
                // 所得年度の４／１時点で６５歳以上の場合
            } else {
                edit世帯員所得情報(setaiinShotokuList, true);
            }
            // 所得引出_６４歳未満所得金額表示区分=1（表示する）のとき
        } else if (syotokuKingakuHyojiKubun.equals(new RString("1"))) {
            edit世帯員所得情報(setaiinShotokuList, true);
        }
    }

    private boolean has年齢到達From所得年度(DisplayMode mode) {
        FlexibleYear 所得年度 = FlexibleYear.EMPTY;
        if (mode.equals(DisplayMode.FukaShokai)) {
            所得年度 = div.getTxtSetaiIchiranKazeiNendo().getDomain();
        } else if (mode.equals(DisplayMode.ShotokuShokai) || mode.equals(DisplayMode.KogakuKaigoServicehi)) {
            所得年度 = new FlexibleYear(new RDate(div.getDdlSetaiIchiranKazeiNendo().getSelectedValue().toString())
                    .getYear().toDateString());
        }
        RDate 計算基準日 = new RDate(所得年度.getYearValue(), Month.APRIL.getValue(), 1);
        NenreiTotatsuChecker checker
                = new NenreiTotatsuChecker(ConfigKeysNenreiTotatsuKijunJoho.年齢到達基準_第１号被保険者到達基準年齢, 計算基準日);
        return checker.personBornOn(new FlexibleDate(計算基準日.toDateString())).has年齢到達();
    }

    private void edit世帯員所得情報(List<SetaiinShotoku> 世帯員所得情報リスト, boolean displayNenkingaku) {
        List<dgSetaiShotoku_Row> list = new ArrayList();

        for (SetaiinShotoku 世帯員所得 : 世帯員所得情報リスト) {
            if (世帯員所得.get世帯コード() != null) {
                div.getTxtSetaiIchiranSetaiCode().setDomain(new SetaiCode(世帯員所得.get世帯コード()));
            }
            dgSetaiShotoku_Row row = new dgSetaiShotoku_Row();
            row.setHdnHihoNo(世帯員所得.get被保険者番号().value());
            row.setHdnShikibetsuCode(世帯員所得.get識別コード().value());
            row.setTxtKetsugo01(世帯員所得.get識別コード().value().concat(BR).concat(世帯員所得.get被保険者番号().value()));
            row.setTxtShimei(世帯員所得.getカナ氏名() != null
                    ? 世帯員所得.getカナ氏名().concat(BR).concat(世帯員所得.get氏名() != null
                            ? 世帯員所得.get氏名()
                            : RString.EMPTY)
                    : RString.EMPTY);
            row.setTxtKetsugo02(世帯員所得.get生年月日() != null
                    ? new RString(世帯員所得.get生年月日().wareki().separator(Separator.PERIOD).toDateString().toString())
                    .concat(RString.FULL_SPACE).concat(世帯員所得.get性別()).concat(BR).concat(世帯員所得.get続柄())
                    : RString.EMPTY);
            row.setTxtShubetsu(世帯員所得.get種別());
            row.setTxtIdoYMD(世帯員所得.get住民情報_異動日() != null
                    ? new RString(世帯員所得.get住民情報_異動日().wareki().separator(Separator.PERIOD).toDateString().toString())
                    : RString.EMPTY);
            row.setTxtJuminzeiGenmenMae(世帯員所得.get課税区分_住民税減免前() != null && !世帯員所得.get課税区分_住民税減免前().isEmpty()
                    ? KazeiKubun.toValue(世帯員所得.get課税区分_住民税減免前()).get名称()
                    : RString.EMPTY);
            row.setTxtJuminzeiGenmenAto(世帯員所得.get課税区分_住民税減免後() != null && !世帯員所得.get課税区分_住民税減免後().isEmpty()
                    ? KazeiKubun.toValue(世帯員所得.get課税区分_住民税減免後()).get名称()
                    : RString.EMPTY);
            row.setTxtJuminzei(世帯員所得.get課税区分_住民税減免前() != null && !世帯員所得.get課税区分_住民税減免前().isEmpty()
                    ? KazeiKubun.toValue(世帯員所得.get課税区分_住民税減免前()).get名称()
                    : RString.EMPTY);
            row.setTxtGekihenTaishosha(GekihenkanwaSochi.対象.getコード()
                    .equals(世帯員所得.get激変緩和措置()) ? new RString("対象者")
                    : GekihenkanwaSochi.対象外.get名称());
            if (displayNenkingaku) {
                row.setTxtKetsugo03(世帯員所得.get合計所得金額() != null
                        ? editComma(new RString(世帯員所得.get合計所得金額().toString())).concat(BR).concat(世帯員所得.get課税所得額() != null
                                ? editComma(new RString(世帯員所得.get課税所得額().toString()))
                                : RString.EMPTY)
                        : RString.EMPTY);
                row.setTxtKetsugo04(世帯員所得.get年金収入額() != null
                        ? editComma(new RString(世帯員所得.get年金収入額().toString())).concat(BR).concat(世帯員所得.get年金所得額() != null
                                ? editComma(new RString(世帯員所得.get年金所得額().toString()))
                                : RString.EMPTY)
                        : RString.EMPTY);
            }
            editDgSetaiShotokuRow(世帯員所得, row);
            list.add(row);

        }
        div.getDgSetaiShotoku().setDataSource(list);
    }

    /**
     * アクセスログ
     *
     * @param 世帯員所得情報リスト 世帯員所得情報リスト
     */
    public void accessLog(List<? extends SetaiinShotoku> 世帯員所得情報リスト) {
        List<PersonalData> personalData = new ArrayList();
        for (SetaiinShotoku setaiin : 世帯員所得情報リスト) {
            if (setaiin.get識別コード().isEmpty()) {
                continue;
            }
            personalData.add(toPersonalData(setaiin));
        }
        AccessLogger.log(AccessLogType.照会, personalData);
    }

    private static PersonalData toPersonalData(SetaiinShotoku setaiin) {
        Objects.requireNonNull(setaiin);
        PersonalData p = PersonalData.of(setaiin.get識別コード());
        if (setaiin.get被保険者番号().isEmpty()) {
            return p;
        }
        p.addExpandedInfo(ExpandedInfomations.被保険者番号.fromValue(setaiin.get被保険者番号().value()));
        return p;
    }

    private void editDgSetaiShotokuRow(SetaiinShotoku 世帯員所得, dgSetaiShotoku_Row row) {
        row.setTxtTorokuGyomu(世帯員所得.get登録業務() != null && !世帯員所得.get登録業務().isEmpty()
                ? new RString(TorokuGyomu.toValue(世帯員所得.get登録業務()).toString()).concat(BR)
                .concat(世帯員所得.get更正日() != null
                        ? 世帯員所得.get更正日().wareki().separator(Separator.PERIOD).toDateString().toString()
                        : RString.EMPTY.toString())
                : RString.EMPTY);
        row.setTxtDougetsuService(世帯員所得.is同月サービス有無() ? new RString("○") : RString.EMPTY);
        row.setTxtJukiIdoYMD(世帯員所得.get住民情報_異動日() != null
                ? new RString(世帯員所得.get住民情報_異動日().wareki().separator(Separator.PERIOD).toDateString().toString())
                : RString.EMPTY);
        row.setTxtJuteiYMD(世帯員所得.get住民情報_住定日() != null
                ? new RString(世帯員所得.get住民情報_住定日().wareki().separator(Separator.PERIOD).toDateString().toString())
                : RString.EMPTY);
        row.setTxtJukiIdoJiyu(世帯員所得.get住民情報_異動事由() != null ? 世帯員所得.get住民情報_異動事由() : RString.EMPTY);
    }

    /**
     * {@link SetaiinShotoku}情報を{@link SetaiShotokuIchiranDiv}にセットします。<br/>
     * 行選択可否の制御
     */
    public void set世帯一覧行選択制御() {
        DisplayMode mode = div.getMode_DisplayMode();
        // 賦課照会、高額介護サービス費モード　のとき
        if (mode.equals(DisplayMode.FukaShokai) || mode.equals(DisplayMode.KogakuKaigoServicehi)) {
            setSetaiIchiranRowUnselectable();
            // 所得照会モードのとき
        } else if (mode.equals(DisplayMode.ShotokuShokai)) {
            ShotokuHikidashiConfig shotokuHikidashiConfig = new ShotokuHikidashiConfig();
            // 所得引出_６４歳未満所得金額表示区分=0（表示しない）のとき
            // 画面.所得年度（※１）の４／１時点ので６４歳未満の場合、行選択を不可にする。
            if (shotokuHikidashiConfig.get所得引出_64歳未満所得金額表示区分().equals(new RString("0")) && !has年齢到達From所得年度(mode)) {
                setSetaiIchiranRowUnselectable();
            }
        }
    }

    /**
     * {@link SetaiinShotoku}情報を取得し{@link SetaiShotokuIchiranDiv}にセットします。<br/>
     * 所得情報履歴の取得
     *
     * @param 識別コード 識別コード
     * @return 所得情報履歴リスト
     */
    public List<KaigoShotokuAlive> get所得情報履歴(ShikibetsuCode 識別コード) {
        ShotokuManager 介護所得Finder = ShotokuManager.createInstance();
        KaigoShotokuAlive shotokuAlive = 介護所得Finder.get介護所得Alive(識別コード,
                new FlexibleYear(new RDate(div.getDdlSetaiIchiranKazeiNendo().getSelectedValue().toString())
                        .getYear().toDateString()));

        return shotokuAlive == null
                ? Collections.<KaigoShotokuAlive>emptyList()
                : ItemList.of(shotokuAlive).sorted(ShotokuRirekiIchiranComparators.orderBy履歴番号.desc()).toList();
    }

    /**
     * {@link SetaiinShotoku}情報を取得し{@link SetaiShotokuIchiranDiv}にセットします。
     *
     * @param 介護所得履歴リスト 介護所得履歴リスト
     */
    public void load所得情報履歴(List<KaigoShotokuAlive> 介護所得履歴リスト) {
        dgSetaiShotoku_Row setaiShotokuRow = div.getDgSetaiShotoku().getClickedItem();
        List<dgShotokuRireki_Row> list = new ArrayList();
        for (KaigoShotokuAlive 介護所得情報 : 介護所得履歴リスト) {
            dgShotokuRireki_Row row = new dgShotokuRireki_Row();
            row.setTxtRirekiNo(介護所得情報.get履歴番号() != null
                    ? new RString(介護所得情報.get履歴番号().toString())
                    : RString.EMPTY);
            row.setTxtKetsugo01(setaiShotokuRow.getTxtKetsugo01());
            row.setTxtShimei(setaiShotokuRow.getTxtShimei());
            row.setTxtJuminzeiGenmenMae(介護所得情報.get課税区分_住民税減免前() != null && !介護所得情報.get課税区分_住民税減免前().isEmpty()
                    ? KazeiKubun.toValue(介護所得情報.get課税区分_住民税減免前()).get名称()
                    : RString.EMPTY);
            row.setTxtJuminzeiGenmenAto(介護所得情報.get課税区分_住民税減免後() != null && !介護所得情報.get課税区分_住民税減免後().isEmpty()
                    ? KazeiKubun.toValue(介護所得情報.get課税区分_住民税減免後()).get名称()
                    : RString.EMPTY);
            row.setTxtJuminzei(介護所得情報.get課税区分_住民税減免前() != null && !介護所得情報.get課税区分_住民税減免前().isEmpty()
                    ? KazeiKubun.toValue(介護所得情報.get課税区分_住民税減免前()).get名称()
                    : RString.EMPTY);
            row.setTxtGekihenTaishosha(GekihenkanwaSochi.対象.getコード().equals(介護所得情報.get激変緩和措置())
                    ? new RString("対象者")
                    : GekihenkanwaSochi.対象外.get名称());
            row.setTxtKetsugo03(介護所得情報.get合計所得金額() != null
                    ? editComma(new RString(介護所得情報.get合計所得金額().toString())).concat(BR)
                    .concat(介護所得情報.get課税所得額() != null
                            ? editComma(new RString(介護所得情報.get課税所得額().toString()))
                            : RString.EMPTY
                    )
                    : RString.EMPTY);
            row.setTxtKetsugo04(介護所得情報.get年金収入額() != null
                    ? editComma(new RString(介護所得情報.get年金収入額().toString())).concat(BR)
                    .concat(介護所得情報.get年金所得額() != null
                            ? editComma(new RString(介護所得情報.get年金所得額().toString()))
                            : RString.EMPTY)
                    : RString.EMPTY);
            row.setTxtTorokuGyomu(介護所得情報.get登録業務() != null && !介護所得情報.get登録業務().isEmpty()
                    ? new RString(TorokuGyomu.toValue(介護所得情報.get登録業務()).toString()).concat(BR)
                    .concat(介護所得情報.get更正日() != null
                            ? 介護所得情報.get更正日().wareki().separator(Separator.PERIOD).toDateString().toString()
                            : RString.EMPTY.toString())
                    : RString.EMPTY);
            list.add(row);
        }
        div.getDgShotokuRireki().setDataSource(list);
    }

    /**
     * {@link SetaiShotokuIchiranDiv}で選択された{@link SetaiinShotoku}情報を取得します。
     *
     * @return 世帯員所得情報リスト
     */
    public List<SetaiinShotoku> get世帯員所得SelectedFor賦課() {
        List<SetaiinShotoku> result = new ArrayList<>();
        for (dgSetaiShotoku_Row row : div.getDgSetaiShotoku().getSelectedItems()) {
            result.add(createSetaiinShotoku(row));
        }
        return result;
    }

    /**
     * 賦課の比較のための{@link SetaiinShotoku}を{@link dgSetaiShotoku_Row}から作成。
     *
     * @param row
     * @return
     */
    private SetaiinShotoku createSetaiinShotoku(dgSetaiShotoku_Row row) {
        ShikibetsuCode shikibetsuCode = new ShikibetsuCode(row.getTxtKetsugo01().split(BR.toString()).get(0));
        HihokenshaNo hihokenshaNo = new HihokenshaNo(row.getTxtKetsugo01().split(BR.toString()).get(1));

        return new SetaiinShotoku(
                shikibetsuCode, hihokenshaNo, RString.EMPTY, RString.EMPTY,
                FlexibleDate.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, Decimal.ZERO, Decimal.ZERO,
                Decimal.ZERO, Decimal.ZERO, RString.EMPTY, FlexibleDate.EMPTY,
                false, FlexibleDate.EMPTY, FlexibleDate.EMPTY, RString.EMPTY,
                RString.EMPTY, 0, RString.EMPTY, RString.EMPTY);
    }

    private void setSetaiIchiranRowUnselectable() {
        List<dgSetaiShotoku_Row> list = div.getDgSetaiShotoku().getDataSource();
        for (dgSetaiShotoku_Row row : list) {
            if (row.getTxtKetsugo01().isEmpty()) {
                row.setSelectable(false);
            }
        }
    }

    private void 日付関連_所得年度コンフィグによる制御(FlexibleYear 所得年度) {
        List<KeyValueDataSource> kazeiNendoList = new ArrayList();
        FlexibleYear 基準年度 = new FlexibleYear("2000");
        int index = 0;
        RString selectedIndex = new RString("key0");
        FlexibleYear 日付関連_所得年度
                = new FlexibleYear(DbBusinessConfig.get(ConfigKeysHizuke.日付関連_所得年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        for (FlexibleYear 年度 = 日付関連_所得年度; 基準年度.isBefore(年度); 年度 = 年度.minusYear(1)) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(new RString("key" + index));
            keyValue.setValue(new RString(年度.wareki().getYear().toString()));
            index++;
            kazeiNendoList.add(keyValue);
            if (年度.equals(所得年度)) {
                selectedIndex = new RString("key" + index);
            }
        }
        div.getDdlSetaiIchiranKazeiNendo().setDataSource(kazeiNendoList);
        div.getDdlSetaiIchiranKazeiNendo().setSelectedKey(selectedIndex);
    }

    private RString editComma(RString target) {
        return new RString(NumberFormat.getNumberInstance(Locale.JAPAN).format(new BigDecimal(target.toString())));
    }
}
