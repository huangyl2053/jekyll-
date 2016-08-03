/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1140011;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1140011.ShotokuJohoTorokuTotalDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1140011.dgSetaiShotoku_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.config.FukaKeisanConfig;
import jp.co.ndensan.reams.db.dbz.business.config.ShotokuHikidashiConfig;
import jp.co.ndensan.reams.db.dbz.business.core.Shotoku;
import jp.co.ndensan.reams.db.dbz.business.core.basic.SetaiinShotoku;
import jp.co.ndensan.reams.db.dbz.business.core.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.definition.core.config.ConfigKeysHizuke;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.GekihenkanwaSochi;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.TorokuGyomu;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShotokuManager;
import jp.co.ndensan.reams.db.dbz.service.core.setaiinshotokujoho.SetaiinShotokuJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.Month;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 画面設計_DBBGM13003_所得照会回答内容登録のハンドラクラス
 *
 * @reamsid_L DBB-1750-010 zhangrui
 */
public final class ShotokuJohoTorokuHandler {

    private final ShotokuJohoTorokuTotalDiv div;
    private static final RString 改行タグ = new RString("<br>");
    private static final RString 同月サービス_あり = new RString("あり");
    private static final RString 同月サービス_なし = new RString("なし");
    private static final RString 状態_編集あり = new RString("修正");
    private static final RString 住民税減免前後表示区分_表示しない = new RString("0");
    private static final RString 優先区分 = new RString("1");
    private static final RString 個人番号_利用有無 = new RString("個人番号 利用有無");
    private static final RString 法人番号_利用有無 = new RString("法人番号 利用有無");
    private static final RString 複数宛名識別対象有無 = new RString("複数宛名識別対象有無");
    private static final RString EUC_帳票スプール有無 = new RString("EUC・帳票スプール有無");
    private static final RString 保存する = new RString("btnUpdateShoki");
    private static final RString 有り = new RString("有り");
    private static final RString 無し = new RString("無し");
    private static final RString コンマ = new RString(",");
    private static final RString 激変緩和_対象 = new RString("対象者");
    private static final RString 激変緩和_なし = new RString("なし");

    private static final int 所得引出_64歳 = 64;

    private final SetaiinShotokuJohoFinder 世帯員所得情報Finder;
    private final DataGridSetting shotokuJohoGridSetting;

    /**
     * コンストラクタ
     *
     * @param div
     */
    private ShotokuJohoTorokuHandler(ShotokuJohoTorokuTotalDiv div) {
        this.世帯員所得情報Finder = SetaiinShotokuJohoFinder.createInstance();
        this.div = div;
        this.shotokuJohoGridSetting = div.getDgSetaiShotoku().getGridSetting();
    }

    /**
     * コンストラクタです
     *
     * @param div 画面DIV
     * @return Mainハンドラークラス
     */
    public static ShotokuJohoTorokuHandler of(ShotokuJohoTorokuTotalDiv div) {
        return new ShotokuJohoTorokuHandler(div);
    }

    /**
     * 画面初期化処理です。
     *
     * @param viewStateData FukaTaishoshaKey
     */
    public void onload(FukaTaishoshaKey viewStateData) {
        set初期状態_データ準備(viewStateData);
        set初期状態_表示制御();
        changeTo初期状態(true);
    }

    private void set初期状態_データ準備(FukaTaishoshaKey viewStateData) {
        TsuchishoNo 通知書番号 = viewStateData.get通知書番号();
        FlexibleYear 賦課年度 = viewStateData.get賦課年度();
        LasdecCode 市町村コード = viewStateData.get市町村コード();
        ShikibetsuCode 識別コード = viewStateData.get識別コード();
        FlexibleYear 所得年度 = viewStateData.get賦課年度();
        YMDHMS 所得基準日時 = YMDHMS.now();
        KaigoFukaKihonSearchKey searchKey = new KaigoFukaKihonSearchKey.Builder(通知書番号, 賦課年度, 市町村コード, 識別コード).build();
        div.getKaigoFukaKihon().load(searchKey);
        div.getKaigoAtenaInfo().initialize(識別コード);
        load世帯所得情報一覧(識別コード, 所得年度, 所得基準日時, true);
        日付関連_所得年度コンフィグによる制御(div.getSetaiShotokuInfo().getTxtSetaiIchiranKazeiNendo().getDomain());
        AccessLogger.log(AccessLogType.照会, toPersonalData(識別コード));
    }

    /**
     * 世帯所得情報一覧を再表示する
     *
     * @param 識別コード ShikibetsuCode
     * @param 所得年度 FlexibleYear
     * @param 所得基準日時 YMDHMS
     * @param flag true:処理詳細1.3の方法 false:4.1の方法
     */
    public void load世帯所得情報一覧(ShikibetsuCode 識別コード, FlexibleYear 所得年度, YMDHMS 所得基準日時, boolean flag) {
        List<SetaiinShotoku> 世帯員所得情報List;
        if (flag) {
            世帯員所得情報List = 世帯員所得情報Finder.get世帯員所得情報(識別コード, 所得年度, 所得基準日時);
        } else {
            世帯員所得情報List = 世帯員所得情報Finder.get世帯員所得情報(識別コード, FlexibleDate.getNowDate(), 所得年度, YMDHMS.now(), false);
        }
        div.getSetaiShotokuInfo().getTxtSetaiIchiranKijunYMD().setValue(RDate.getNowDate());
        div.getSetaiShotokuInfo().getTxtSetaiIchiranKazeiNendo().setDomain(所得年度);
        List<dgSetaiShotoku_Row> dataList = new ArrayList<>();
        if (null != 世帯員所得情報List && !世帯員所得情報List.isEmpty()) {
            div.getSetaiShotokuInfo().getTxtSetaiIchiranSetaiCode().setDomain(new SetaiCode(世帯員所得情報List.get(0).get世帯コード()));
            for (SetaiinShotoku 世帯員所得情報 : 世帯員所得情報List) {
                dgSetaiShotoku_Row row = new dgSetaiShotoku_Row();
                row.setTxtJotai(RowState.Modified.equals(row.getRowState()) ? 状態_編集あり : RString.EMPTY);
                row.setTxtKetsugo01(世帯員所得情報.get識別コード().value().concat(改行タグ).concat(世帯員所得情報.get被保険者番号().value()));
                row.setTxtShimei(世帯員所得情報.getカナ氏名().concat(改行タグ).concat(世帯員所得情報.get氏名()));
                row.setTxtKetsugo02(世帯員所得情報.get生年月日().wareki().toDateString().concat(RString.FULL_SPACE)
                        .concat(getNotNull(世帯員所得情報.get性別())).concat(改行タグ).concat(世帯員所得情報.get続柄()));
                row.setTxtShubetsu(RString.isNullOrEmpty(世帯員所得情報.get種別コード()) ? RString.EMPTY : 世帯員所得情報.get種別());
                row.setTxtIdoYMD(世帯員所得情報.get住民情報_異動日().wareki().toDateString());
                RString 課税区分_住民税減免前 = RString.EMPTY;
                try {
                    課税区分_住民税減免前 = KazeiKubun.toValue(世帯員所得情報.get課税区分_住民税減免前()).get名称();
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(ShotokuJohoTorokuHandler.class.getName()).log(Level.SEVERE, null, ex.getMessage());
                }
                row.setTxtJuminzeiGenmenMae(課税区分_住民税減免前);
                RString 課税区分_住民税減免後 = RString.EMPTY;
                try {
                    課税区分_住民税減免後 = KazeiKubun.toValue(世帯員所得情報.get課税区分_住民税減免後()).get名称();
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(ShotokuJohoTorokuHandler.class.getName()).log(Level.SEVERE, null, ex.getMessage());
                }
                row.setTxtJuminzeiGenmenAto(課税区分_住民税減免後);
                row.setTxtJuminzei(課税区分_住民税減免前);
                RString 激変緩和措置区分 = RString.EMPTY;
                try {
                    GekihenkanwaSochi 激変緩和 = GekihenkanwaSochi.toValue(getNotNull(世帯員所得情報.get激変緩和措置()));
                    激変緩和措置区分 = 激変緩和.equals(GekihenkanwaSochi.対象) ? 激変緩和_対象 : RString.EMPTY;
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(ShotokuJohoTorokuHandler.class.getName()).log(Level.SEVERE, null, ex.getMessage());
                }
                row.setTxtGekihenTaishosha(激変緩和措置区分);
                boolean is被保険者 = !RString.isNullOrEmpty(世帯員所得情報.get被保険者番号().value());
                if (get金額表示Flg(世帯員所得情報.get生年月日(), is被保険者)) {
                    RString 合計所得金額 = (null == 世帯員所得情報.get合計所得金額()) ? RString.EMPTY
                            : editComma(new RString(世帯員所得情報.get合計所得金額().toString()));
                    RString 課税所得額 = (null == 世帯員所得情報.get課税所得額()) ? RString.EMPTY
                            : editComma(new RString(世帯員所得情報.get課税所得額().toString()));
                    RString 年金収入額 = (null == 世帯員所得情報.get年金収入額()) ? RString.EMPTY
                            : editComma(new RString(世帯員所得情報.get年金収入額().toString()));
                    RString 年金所得額 = (null == 世帯員所得情報.get年金所得額()) ? RString.EMPTY
                            : editComma(new RString(世帯員所得情報.get年金所得額().toString()));
                    row.setTxtKetsugo03(合計所得金額.concat(改行タグ).concat(課税所得額));
                    row.setTxtKetsugo04(年金収入額.concat(改行タグ).concat(年金所得額));
                }
                RString 登録業務 = RString.EMPTY;
                try {
                    登録業務 = TorokuGyomu.toValue(世帯員所得情報.get登録業務()).get名称();
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(ShotokuJohoTorokuHandler.class.getName()).log(Level.SEVERE, null, ex.getMessage());
                }
                row.setTxtTorokuGyomu(登録業務.concat(改行タグ).concat(世帯員所得情報.get更正日().wareki().toDateString()));
                row.setTxtJukiIdoYMD(世帯員所得情報.get住民情報_異動日().wareki().toDateString());
                row.setTxtJuteiYMD(世帯員所得情報.get住民情報_住定日().wareki().toDateString());
                row.setTxtJukiIdoJiyu(RString.isNullOrEmpty(世帯員所得情報.get住民情報_異動事由コード())
                        ? RString.EMPTY : 世帯員所得情報.get住民情報_異動事由());
                row.setTxtDougetsuService(世帯員所得情報.is同月サービス有無() ? 同月サービス_あり : 同月サービス_なし);
                dataList.add(row);
            }
        }
        div.getDgSetaiShotoku().getDataSource().clear();
        div.getDgSetaiShotoku().setDataSource(dataList);
    }

    private void set初期状態_表示制御() {
        set住民税減免前_後表示制御情報TO世帯一覧();
        set激変緩和表示制御情報TO世帯一覧();
    }

    private boolean get金額表示Flg(FlexibleDate 生年月日, boolean is被保険者) {
        ShotokuHikidashiConfig shotokuHikidashiConfig = new ShotokuHikidashiConfig();
        RString syotokuKingakuHyojiKubun = shotokuHikidashiConfig.get所得引出_64歳未満所得金額表示区分();
        // 業務コンフィング（賦課）「所得引出_６４歳未満所得金額表示区分」が「0:表示しない」、
        // かつ、住民税課税年度（ドロップダウン）の値の４月１日時点で６４歳未満
        // かつ、被保険者でない場合、以下の項目は空白で表示する。
        // 合計所得金額、年金収入額、年金所得額、課税所得額
        return !syotokuKingakuHyojiKubun.equals(住民税減免前後表示区分_表示しない) || has年齢到達From所得年度(生年月日) || is被保険者;
    }

    private boolean has年齢到達From所得年度(FlexibleDate 生年月日) {
        RDate 計算基準日 = new RDate(div.getSetaiShotokuInfo().getDdlSetaiIchiranKazeiNendo().getSelectedValue().toString());
        計算基準日 = new RDate(計算基準日.getYearValue(), Month.APRIL.getValue(), 1);
        return 生年月日.plusYear(所得引出_64歳).compareTo(new FlexibleDate(計算基準日.toDateString())) < 0;

    }

    private void set金額制御TO内容登録(FlexibleDate 生年月日, boolean is被保険者) {
        if (get金額表示Flg(生年月日, is被保険者)) {
            div.getShotokuJohoToroku().getTxtGokeiShotokuGaku().setDisplayNone(false);
            div.getShotokuJohoToroku().getTxtKazeiShotokuGaku().setDisplayNone(false);
            div.getShotokuJohoToroku().getTxtNenkinShotokuGaku().setDisplayNone(false);
            div.getShotokuJohoToroku().getTxtNenkinShunyuGaku().setDisplayNone(false);
        } else {
            div.getShotokuJohoToroku().getTxtGokeiShotokuGaku().setDisplayNone(true);
            div.getShotokuJohoToroku().getTxtKazeiShotokuGaku().setDisplayNone(true);
            div.getShotokuJohoToroku().getTxtNenkinShotokuGaku().setDisplayNone(true);
            div.getShotokuJohoToroku().getTxtNenkinShunyuGaku().setDisplayNone(true);
        }
    }

    /**
     * 住民税減免前/後の表示制御 世帯一覧
     */
    public void set住民税減免前_後表示制御情報TO世帯一覧() {
        ShotokuHikidashiConfig cfg = new ShotokuHikidashiConfig();
        RString 所得引出_住民税減免前後表示区分 = cfg.get所得引出_住民税減免前後表示区分();
        if (住民税減免前後表示区分_表示しない.equals(所得引出_住民税減免前後表示区分)) {
            shotokuJohoGridSetting.getColumn("txtJuminzeiGenmenMae").setVisible(false);
            shotokuJohoGridSetting.getColumn("txtJuminzeiGenmenAto").setVisible(false);
            shotokuJohoGridSetting.getColumn("txtJuminzei").setVisible(true);
        } else {
            shotokuJohoGridSetting.getColumn("txtJuminzeiGenmenMae").setVisible(true);
            shotokuJohoGridSetting.getColumn("txtJuminzeiGenmenAto").setVisible(true);
            shotokuJohoGridSetting.getColumn("txtJuminzei").setVisible(false);
        }
    }

    /**
     * 住民税減免前/後の表示制御 内容登録
     */
    public void set住民税減免前_後表示制御情報TO内容登録() {
        ShotokuHikidashiConfig cfg = new ShotokuHikidashiConfig();
        RString 所得引出_住民税減免前後表示区分 = cfg.get所得引出_住民税減免前後表示区分();
        if (住民税減免前後表示区分_表示しない.equals(所得引出_住民税減免前後表示区分)) {
            div.getShotokuJohoToroku().getDdlJuminzeiGenmenMae().setVisible(false);
            div.getShotokuJohoToroku().getDdlJuminzeiGenmenAto().setVisible(false);
            div.getShotokuJohoToroku().getDdlJuminzei().setVisible(true);
            div.getShotokuJohoToroku().getDdlJuminzeiGenmenMae().setDisplayNone(true);
            div.getShotokuJohoToroku().getDdlJuminzeiGenmenAto().setDisplayNone(true);
            div.getShotokuJohoToroku().getDdlJuminzei().setDisplayNone(false);
        } else {
            div.getShotokuJohoToroku().getDdlJuminzeiGenmenMae().setVisible(true);
            div.getShotokuJohoToroku().getDdlJuminzeiGenmenAto().setVisible(true);
            div.getShotokuJohoToroku().getDdlJuminzei().setVisible(false);
            div.getShotokuJohoToroku().getDdlJuminzeiGenmenMae().setDisplayNone(false);
            div.getShotokuJohoToroku().getDdlJuminzeiGenmenAto().setDisplayNone(false);
            div.getShotokuJohoToroku().getDdlJuminzei().setDisplayNone(true);
        }
    }

    /**
     * 激変緩和の表示制御 世帯一覧
     */
    public void set激変緩和表示制御情報TO世帯一覧() {
        FukaKeisanConfig fukaKeisanCfg = new FukaKeisanConfig();
        RString 住民税課税年度 = div.getSetaiShotokuInfo().getDdlSetaiIchiranKazeiNendo().getSelectedValue();
        if (fukaKeisanCfg.get激変緩和期間().between(trans和暦to西暦(住民税課税年度))) {
            shotokuJohoGridSetting.getColumn("txtGekihenTaishosha").setVisible(true);
        } else {
            shotokuJohoGridSetting.getColumn("txtGekihenTaishosha").setVisible(false);
        }
    }

    /**
     * 激変緩和の表示制御 内容登録
     */
    public void set激変緩和表示制御情報TO内容登録() {
        FukaKeisanConfig fukaKeisanCfg = new FukaKeisanConfig();
        RString 住民税課税年度 = div.getSetaiShotokuInfo().getDdlSetaiIchiranKazeiNendo().getSelectedValue();
        if (fukaKeisanCfg.get激変緩和期間().between(trans和暦to西暦(住民税課税年度))) {
            div.getShotokuJohoToroku().getDdlGekihenKanwa().setVisible(true);
            div.getShotokuJohoToroku().getDdlGekihenKanwa().setDisplayNone(false);
        } else {
            div.getShotokuJohoToroku().getDdlGekihenKanwa().setVisible(false);
            div.getShotokuJohoToroku().getDdlGekihenKanwa().setDisplayNone(true);
        }
    }

    private PersonalData toPersonalData(ShikibetsuCode 識別コード) {
        ExpandedInformation expandedInfo1 = new ExpandedInformation(new Code("0001"), 個人番号_利用有無, 有り);
        ExpandedInformation expandedInfo2 = new ExpandedInformation(new Code("0002"), 法人番号_利用有無, 無し);
        ExpandedInformation expandedInfo3 = new ExpandedInformation(new Code("0003"), 複数宛名識別対象有無, 無し);
        ExpandedInformation expandedInfo4 = new ExpandedInformation(new Code("0004"), EUC_帳票スプール有無, 無し);
        return PersonalData.of(識別コード, expandedInfo1, expandedInfo2, expandedInfo3, expandedInfo4);
    }

    /**
     * 所得照会回答内容登録エリアで入力した内容を世帯一覧Gridに反映
     */
    public void sync世帯一覧To内容登録() {
        dgSetaiShotoku_Row selected_row = div.getDgSetaiShotoku().getClickedItem();
        if (!RString.isNullOrEmpty(selected_row.getTxtJuminzeiGenmenMae())) {
            div.getShotokuJohoToroku().getDdlJuminzeiGenmenMae().setSelectedValue(selected_row.getTxtJuminzeiGenmenMae());
        }
        if (!RString.isNullOrEmpty(selected_row.getTxtJuminzeiGenmenAto())) {
            div.getShotokuJohoToroku().getDdlJuminzeiGenmenAto().setSelectedValue(selected_row.getTxtJuminzeiGenmenAto());
        }
        if (!RString.isNullOrEmpty(selected_row.getTxtJuminzei())) {
            div.getShotokuJohoToroku().getDdlJuminzei().setSelectedValue(selected_row.getTxtJuminzei());
        }
        if (!RString.isNullOrEmpty(selected_row.getTxtGekihenTaishosha())) {
            div.getShotokuJohoToroku().getDdlGekihenKanwa().setSelectedValue(
                    selected_row.getTxtGekihenTaishosha().equals(激変緩和_対象) ? 激変緩和_対象 : 激変緩和_なし);
        }
        List<RString> ketsugo03List = selected_row.getTxtKetsugo03().split(改行タグ.toString());
        List<RString> ketsugo04List = selected_row.getTxtKetsugo04().split(改行タグ.toString());
        div.getShotokuJohoToroku().getTxtGokeiShotokuGaku().setValue(Decimal.ZERO);
        div.getShotokuJohoToroku().getTxtKazeiShotokuGaku().setValue(Decimal.ZERO);
        div.getShotokuJohoToroku().getTxtNenkinShunyuGaku().setValue(Decimal.ZERO);
        div.getShotokuJohoToroku().getTxtNenkinShotokuGaku().setValue(Decimal.ZERO);
        if (null != ketsugo03List && ketsugo03List.size() == 2) {
            RString 合計所得金額 = removeComma(ketsugo03List.get(0));
            RString 課税所得額 = removeComma(ketsugo03List.get(1));
            div.getShotokuJohoToroku().getTxtGokeiShotokuGaku().setValue(transToDecimal(合計所得金額));
            div.getShotokuJohoToroku().getTxtKazeiShotokuGaku().setValue(transToDecimal(課税所得額));
        }
        if (null != ketsugo04List && ketsugo04List.size() == 2) {
            RString 公的年金収入額 = removeComma(ketsugo04List.get(0));
            RString 公的年金所得額 = removeComma(ketsugo04List.get(1));
            div.getShotokuJohoToroku().getTxtNenkinShunyuGaku().setValue(transToDecimal(公的年金収入額));
            div.getShotokuJohoToroku().getTxtNenkinShotokuGaku().setValue(transToDecimal(公的年金所得額));
        }
        boolean is被保険者 = true;
        FlexibleDate 生年月日 = FlexibleDate.getNowDate();
        List<RString> ketsugo01List = selected_row.getTxtKetsugo01().split(改行タグ.toString());
        if (null != ketsugo01List && ketsugo01List.size() == 2) {
            RString 被保険者番号 = ketsugo01List.get(1);
            is被保険者 = !RString.isNullOrEmpty(被保険者番号.trim());
        }
        List<RString> ketsugo02List = selected_row.getTxtKetsugo02().split(改行タグ.toString());
        if (null != ketsugo02List && ketsugo02List.size() == 2) {
            RString 生年月日Str = ketsugo02List.get(0);
            生年月日Str = 生年月日Str.substring(0, 生年月日Str.lastIndexOf(RString.FULL_SPACE));
            生年月日 = new FlexibleDate((new RDate(生年月日Str.toString())).toString());
        }
        set金額制御TO内容登録(生年月日, is被保険者);
        set住民税減免前_後表示制御情報TO内容登録();
        set激変緩和表示制御情報TO内容登録();
        changeTo初期状態(false);
    }

    /**
     * 所得照会回答内容登録エリアで入力した内容を世帯一覧Gridに反映
     */
    public void to世帯所得情報行() {
        dgSetaiShotoku_Row row = div.getDgSetaiShotoku().getClickedItem();
        RString 合計所得金額 = editComma(div.getShotokuJohoToroku().getTxtGokeiShotokuGaku().getText());
        RString 課税所得額 = editComma(div.getShotokuJohoToroku().getTxtKazeiShotokuGaku().getText());
        RString 年金収入額 = editComma(div.getShotokuJohoToroku().getTxtNenkinShunyuGaku().getText());
        RString 年金所得額 = editComma(div.getShotokuJohoToroku().getTxtNenkinShotokuGaku().getText());
        if (div.getShotokuJohoToroku().getTxtGokeiShotokuGaku().isDisplayNone()) {
            合計所得金額 = RString.EMPTY;
            課税所得額 = RString.EMPTY;
            年金収入額 = RString.EMPTY;
            年金所得額 = RString.EMPTY;
        }
        row.setTxtJuminzeiGenmenMae(div.getShotokuJohoToroku().getDdlJuminzeiGenmenMae().getSelectedValue());
        row.setTxtJuminzeiGenmenAto(div.getShotokuJohoToroku().getDdlJuminzeiGenmenAto().getSelectedValue());
        row.setTxtJuminzei(div.getShotokuJohoToroku().getDdlJuminzei().getSelectedValue());
        row.setTxtGekihenTaishosha(div.getShotokuJohoToroku().getDdlGekihenKanwa().getSelectedValue().equals(激変緩和_対象)
                ? 激変緩和_対象 : RString.EMPTY);
        row.setTxtKetsugo03(合計所得金額.concat(改行タグ).concat(課税所得額));
        row.setTxtKetsugo04(年金収入額.concat(改行タグ).concat(年金所得額));
        row.setRowState(RowState.Modified);
        row.setTxtJotai(状態_編集あり);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, false);
        changeTo初期状態(true);
    }

    /**
     * 世帯所得情報一覧に変更したデータを全部「介護所得管理」テーブルに登録する
     *
     * @return 成功：TRUE　失敗：FALSE
     */
    public boolean save世帯登録() {
        boolean flag = true;
        ShotokuManager shotokuManager = new ShotokuManager();
        RDate rdate = new RDate(div.getSetaiShotokuInfo().getDdlSetaiIchiranKazeiNendo().getSelectedValue().toString());
        FlexibleYear 所得年度 = new FlexibleYear(rdate.getYear().toString());
        List<dgSetaiShotoku_Row> rows = div.getDgSetaiShotoku().getDataSource();
        for (dgSetaiShotoku_Row row : rows) {
            if (!RowState.Modified.equals(row.getRowState())) {
                continue;
            }
            RString ketsugo01 = row.getTxtKetsugo01();
            ShikibetsuCode 識別コード = ShikibetsuCode.EMPTY;
            if (!RString.isNullOrEmpty(ketsugo01.trim())) {
                List<RString> ketsugo01List = ketsugo01.split(改行タグ.toString());
                識別コード = new ShikibetsuCode(ketsugo01List.get(0));
            }
            int 履歴番号 = 1;
            List<Shotoku> shotokuList = shotokuManager.get介護所得一覧();
            for (Iterator<Shotoku> i = shotokuList.iterator(); i.hasNext();) {
                Shotoku shotokuTemp = i.next();
                if (!shotokuTemp.get識別コード().toString().equals(識別コード.toString())
                        || (shotokuTemp.get所得年度().compareTo(所得年度) != 0)) {
                    i.remove();
                }
            }
            Collections.sort(shotokuList, new Comparator<Shotoku>() {
                @Override
                public int compare(Shotoku o1, Shotoku o2) {
                    return o2.toEntity().getRirekiNo() - o1.toEntity().getRirekiNo();
                }
            });
            if (!shotokuList.isEmpty()) {
                履歴番号 = shotokuList.get(0).toEntity().getRirekiNo() + 1;
            }
            Shotoku shotoku = new Shotoku(所得年度, 識別コード, 履歴番号);
            shotoku = shotoku.createBuilderForEdit().set公的年金収入額(Decimal.ZERO).build();
            if (div.getShotokuJohoToroku().getDdlJuminzeiGenmenMae().isVisible()) {
                shotoku = shotoku.createBuilderForEdit()
                        .set非課税区分_住民税減免前(KazeiKubun.valueOf(row.getTxtJuminzeiGenmenMae().toString()).getコード())
                        .set非課税区分_住民税減免後(KazeiKubun.valueOf(row.getTxtJuminzeiGenmenAto().toString()).getコード()).build();

            } else {
                shotoku = shotoku.createBuilderForEdit()
                        .set非課税区分_住民税減免前(KazeiKubun.valueOf(row.getTxtJuminzei().toString()).getコード())
                        .set非課税区分_住民税減免後(KazeiKubun.valueOf(row.getTxtJuminzei().toString()).getコード()).build();
            }
            List<RString> ketsugo03List = row.getTxtKetsugo03().split(改行タグ.toString());
            List<RString> ketsugo04List = row.getTxtKetsugo04().split(改行タグ.toString());
            if (null != ketsugo03List && ketsugo03List.size() == 2) {
                RString 合計所得金額 = removeComma(ketsugo03List.get(0));
                RString 課税所得額 = removeComma(ketsugo03List.get(1));
                shotoku = shotoku.createBuilderForEdit().set合計所得金額(transToDecimal(合計所得金額))
                        .set課税所得額(transToDecimal(課税所得額)).build();
            }
            if (null != ketsugo04List && ketsugo04List.size() == 2) {
                RString 公的年金収入額 = removeComma(ketsugo04List.get(0));
                RString 公的年金所得額 = removeComma(ketsugo04List.get(1));
                shotoku = shotoku.createBuilderForEdit().set公的年金収入額(transToDecimal(公的年金収入額))
                        .set公的年金所得額(transToDecimal(公的年金所得額)).build();
            }
            if (div.getShotokuJohoToroku().getDdlGekihenKanwa().isVisible()) {
                GekihenkanwaSochi 激変緩和 = 激変緩和_対象.equals(div.getShotokuJohoToroku().getDdlGekihenKanwa().getSelectedValue())
                        ? GekihenkanwaSochi.対象 : GekihenkanwaSochi.対象外;
                shotoku = shotoku.createBuilderForEdit()
                        .set激変緩和措置区分(激変緩和.getコード()).build();
            } else {
                shotoku = shotoku.createBuilderForEdit().set激変緩和措置区分(RString.EMPTY).build();
            }
            shotoku = shotoku.createBuilderForEdit().set優先区分(優先区分).set処理日時(YMDHMS.now()).build();
            boolean success = shotokuManager.insert介護所得(shotoku);
            if (success) {
                row.setRowState(RowState.Unchanged);
                row.setTxtJotai(RString.EMPTY);
            }
            flag = flag && success;
        }
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存する, false);
        return flag;
    }

    private void 日付関連_所得年度コンフィグによる制御(FlexibleYear 所得年度) {
        List<KeyValueDataSource> kazeiNendoList = new ArrayList();
        FlexibleYear 基準年度 = new FlexibleYear("2000");
        int index = 0;
        RString selectedIndex = new RString("key0");
        FlexibleYear 日付関連_所得年度
                = new FlexibleYear(DbBusinessConfig.get(ConfigKeysHizuke.日付関連_所得年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        for (FlexibleYear 年度 = 日付関連_所得年度; 基準年度.isBeforeOrEquals(年度); 年度 = 年度.minusYear(1)) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(new RString("key" + index));
            keyValue.setValue(new RString(年度.wareki().getYear().toString()));
            kazeiNendoList.add(keyValue);
            if (年度.equals(所得年度)) {
                selectedIndex = new RString("key" + index);
            }
            index++;
        }
        div.getDdlSetaiIchiranKazeiNendo().setDataSource(kazeiNendoList);
        div.getDdlSetaiIchiranKazeiNendo().setSelectedKey(selectedIndex);
    }

    private RString getNotNull(RString rstring) {
        return RString.isNullOrEmpty(rstring) ? RString.EMPTY : rstring;
    }

    private Decimal transToDecimal(RString str) {
        return RString.isNullOrEmpty(str) ? Decimal.ZERO : new Decimal(str.toString());
    }

    private RString editComma(RString target) {
        return new RString(NumberFormat.getNumberInstance(Locale.JAPAN).format(new BigDecimal(target.toString())));
    }

    private RString removeComma(RString target) {
        return target.replace(コンマ.toString(), RString.EMPTY.toString());
    }

    private FlexibleYear trans和暦to西暦(RString 和暦str) {
        return new FlexibleYear(new RDate(和暦str.toString()).getYear().toString());
    }

    private void changeTo初期状態(boolean isDisplay) {
        div.getSetaiShotokuInfo().setDisplayNone(!isDisplay);
        div.getShotokuJohoToroku().setDisplayNone(isDisplay);
    }

}
