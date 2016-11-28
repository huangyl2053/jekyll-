/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBCN130001;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuGassanJikoFutanGakuShomeisho;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuGassanJikoFutanGakuShomeishoMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.jikofutangakushomeishotoroku.JikofutangakuShomeishoTorokuBusiness;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jikofutangakushomeishotoroku.JikofutangakuShomeishoTorokuParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBCN130001.JikofutangakuShomeishoTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBCN130001.dgShomeishoRireki_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.Formatted;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Width;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 *
 * 事業分自己負担額証明書登録（単）のHandlerクラスです。
 *
 * @reamsid_L DBC-4820-010 sunhaidi
 */
public class JikofutangakuShomeishoTorokuHandler {

    private final JikofutangakuShomeishoTorokuDiv div;
    private static final int 平成26年度 = 2014;
    private static final int SIZE = 6;
    private static final RString STATUS_新規 = new RString("新規");
    private static final RString STATUS_修正 = new RString("修正");
    private static final RString 年号_平 = new RString("平");
    private static final RString 平成 = new RString("4");
    private static final RString 月日 = new RString("年8月1日");
    private static final RString 一月 = new RString("101");
    private static final RString 二月 = new RString("102");
    private static final RString 三月 = new RString("103");
    private static final RString 四月 = new RString("104");
    private static final RString 五月 = new RString("105");
    private static final RString 六月 = new RString("106");
    private static final RString 七月 = new RString("107");
    private static final RString 八月 = new RString("008");
    private static final RString 九月 = new RString("009");
    private static final RString 十月 = new RString("010");
    private static final RString 十一月 = new RString("011");
    private static final RString 十二月 = new RString("012");

    private final Integer 日付_八月 = 8;
    private final Integer 日付_七月 = 7;

    private final RString 開始月日 = new RString("0801");

    private final Integer 年度_26 = 2014;

    private static final int 桁数_4 = 4;

    /**
     * 初期化です。
     *
     * @param div JikofutangakuShomeishoTorokuDiv
     */
    public JikofutangakuShomeishoTorokuHandler(JikofutangakuShomeishoTorokuDiv div) {
        this.div = div;
    }

    /**
     * 初期化です。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     */
    public void onLoad(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        div.getCcdAtenaInfo().initialize(識別コード);
        div.getCcdShikakuInfo().initialize(被保険者番号);
        RDate システム日付 = RDate.getNowDate();
        int システム日付_年 = システム日付.getYearValue();
        int システム日付_月 = システム日付.getMonthValue();
        List<KeyValueDataSource> keyValueList = new LinkedList<>();
        for (int i = システム日付_年; 年度_26 <= i; i--) {
            if ((システム日付_月 <= 日付_七月 && i - 2 <= 年度_26)
                    || (システム日付_月 >= 日付_八月 && i - 1 <= 年度_26)) {
                KeyValueDataSource dateKey_2014以下 = new KeyValueDataSource();
                RString 日付 = new RString(年度_26.toString()).concat(開始月日);
                Formatted formattedDate = new RDate(日付.toString()).wareki()
                        .eraType(EraType.NUMBER).firstYear(FirstYear.ICHI_NEN).fillType(FillType.ZERO).width(Width.HALF);
                if (isContained(keyValueList, formattedDate.getYear())) {
                    continue;
                }
                dateKey_2014以下.setKey(formattedDate.getYear());
                dateKey_2014以下.setValue(formattedDate.getYear().replace(new RString("4"), 年号_平));
                keyValueList.add(dateKey_2014以下);
            } else if ((システム日付_月 >= 日付_八月 && i - 1 > 年度_26) || (システム日付_月 <= 日付_七月 && i - 1 > 年度_26)) {
                KeyValueDataSource dateKey_2014以上 = new KeyValueDataSource();
                int 年度 = i - 1;
                RString 日付 = new RString(String.valueOf(年度)).concat(開始月日);
                Formatted formattedDate = new RDate(日付.toString()).wareki()
                        .eraType(EraType.NUMBER).firstYear(FirstYear.ICHI_NEN).fillType(FillType.ZERO).width(Width.HALF);
                if (isContained(keyValueList, formattedDate.getYear())) {
                    continue;
                }
                dateKey_2014以上.setKey(formattedDate.getYear());
                dateKey_2014以上.setValue(formattedDate.getYear().replace(new RString("4"), 年号_平));
                keyValueList.add(dateKey_2014以上);
            }
        }
        div.getDdlShinkiTaishoNendo().setDataSource(keyValueList);

        RDate 基準日 = RDate.getNowDate();
        RString 保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, 基準日, SubGyomuCode.DBU介護統計報告);
        div.getTxtShinkiTuikaShokisaiHokenshaNo().setValue(保険者番号);
        div.getTxtShinkiShikyuShinseishoSeiriNo().setValue(RString.EMPTY);

        div.getDdlKoshinTaishoNendo().setDataSource(keyValueList);

        div.getTxtKoshinShikyuShinseishoSeiriNo().setValue(RString.EMPTY);
        div.getDdlShinkiTaishoNendo().setSelectedKey(keyValueList.get(0).getKey());
        div.getDdlKoshinTaishoNendo().setSelectedKey(keyValueList.get(0).getKey());
    }

    private boolean isContained(List<KeyValueDataSource> keyValueList, RString year) {
        for (KeyValueDataSource list : keyValueList) {
            if (list.getKey().equals(year)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 初期値と比較してチェックします。
     *
     * @return true:変更,false未変更
     */
    public boolean is証明書検索画面変更() {
        RString 新規_対象年度 = div.getDdlShinkiTaishoNendo().getSelectedKey();
        RString year = RDate.getNowDate().getYear().wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).fillType(FillType.ZERO).toDateString();
        boolean is変更 = false;
        if (!新規_対象年度.equals(year.replace(年号_平.toString(), 平成.toString()))) {
            is変更 = true;
        }
        RString 保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        if (!保険者番号.equals(div.getTxtShinkiTuikaShokisaiHokenshaNo().getValue())) {
            is変更 = true;
        }
        if (!RString.isNullOrEmpty(div.getTxtTorokuShikyuShinseishoSeiriNo().getValue())) {
            is変更 = true;
        }
        RString 更新_対象年度 = div.getDdlKoshinTaishoNendo().getSelectedKey();
        if (!更新_対象年度.equals(year.replace(年号_平.toString(), 平成.toString()))) {
            is変更 = true;
        }
        if (!RString.isNullOrEmpty(div.getTxtKoshinShikyuShinseishoSeiriNo().getValue())) {
            is変更 = true;
        }
        if (!div.getChkIsRirekiHyoji().getSelectedKeys().isEmpty()) {
            is変更 = true;
        }
        List<dgShomeishoRireki_Row> dataList = div.getDgShomeishoRireki().getDataSource();
        if (!dataList.isEmpty()) {
            is変更 = true;
        }
        return is変更;
    }

    /**
     * executionStatus が修正の場合、初期値と比較してチェックします。
     *
     * @param business JikofutangakuShomeishoTorokuBusiness
     * @return true:変更,false未変更
     */
    public boolean is修正_証明書登録画面変更(JikofutangakuShomeishoTorokuBusiness business) {
        boolean is変更 = false;
        if (STATUS_新規.equals(div.getExecutionStatus())) {
            return is変更;
        }
        JigyoKogakuGassanJikoFutanGakuShomeisho shomeisho = business.get事業高額合算自己負担額証明書情報();
        RString 対象年度 = shomeisho.get対象年度()
                .wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN)
                .fillType(FillType.BLANK).toDateString();
        RString 登録_対象年度 = div.getTxtTorokuTaishoNendo().getValue();
        if (!登録_対象年度.equals(対象年度)) {
            is変更 = true;
        }
        RString 保険者番号 = div.getTxtTorokuShokisaiHokenshaNo().getValue();
        if (!保険者番号.equals(shomeisho.get証記載保険者番号().value())) {
            is変更 = true;
        }
        RString 登録_支給申請書整理番号 = div.getTxtTorokuShokisaiHokenshaNo().getValue();
        if (!登録_支給申請書整理番号.equals(shomeisho.get支給申請書整理番号())) {
            is変更 = true;
        }
        RString 登録_履歴番号 = div.getTxtTorokuRirekiNo().getValue();
        if (!登録_履歴番号.equals(new RString(String.valueOf(shomeisho.get履歴番号())))) {
            is変更 = true;
        }
        if (div.getTxtUketsukeDate().getValue() != null
                && !div.getTxtUketsukeDate().getValue().equals(shomeisho.get受付年月日())) {
            is変更 = true;
        }
        if (!div.getTxtJikofutangakuShomeishoSeiriNo().getValue().equals(shomeisho.get自己負担額証明書整理番号())) {
            is変更 = true;
        }
        if (!div.getCcdTennyumaeHokensha().getHokenjaNo().equals(shomeisho.get転入前保険者番号().value())) {
            is変更 = true;
        }
        is変更 = is負担額変更(is変更, shomeisho);
        is変更 = is負担額変更1(is変更, business);
        return is変更;
    }

    private boolean is負担額変更(boolean is変更, JigyoKogakuGassanJikoFutanGakuShomeisho shomeisho) {
        RDate 対象計算期間開始年月日 = div.getTxtTaishoKikan().getFromValue();
        if (対象計算期間開始年月日 != null
                && !new FlexibleDate(対象計算期間開始年月日.toDateString()).equals(shomeisho.get対象計算期間開始年月日())) {
            is変更 = true;
        }
        RDate 対象計算期間終了年月日 = div.getTxtTaishoKikan().getToValue();
        if (対象計算期間終了年月日 != null
                && !new FlexibleDate(対象計算期間終了年月日.toDateString()).equals(shomeisho.get対象計算期間終了年月日())) {
            is変更 = true;
        }
        RDate 被保険者期間開始年月日 = div.getTxtHihokenshaKikan().getFromValue();
        if (被保険者期間開始年月日 != null
                && !new FlexibleDate(被保険者期間開始年月日.toDateString()).equals(shomeisho.get被保険者期間開始年月日())) {
            is変更 = true;
        }
        RDate 被保険者期間終了年月日 = div.getTxtHihokenshaKikan().getToValue();
        if (被保険者期間終了年月日 != null
                && !new FlexibleDate(被保険者期間終了年月日.toDateString()).equals(shomeisho.get被保険者期間終了年月日())) {
            is変更 = true;
        }
        if (div.getTxtHakkoDate().getValue() != null && !div.getTxtHakkoDate().getValue().equals(shomeisho.get発行年月日())) {
            is変更 = true;
        }
        if (div.getTxtYubinNo().getValue() != null && div.getTxtYubinNo().getValue().equals(shomeisho.get支給額計算結果連絡先郵便番号())) {
            is変更 = true;
        }
        if (!div.getTxtRenrakusakiJusho().getValue().equals(shomeisho.get支給額計算結果連絡先住所())) {
            is変更 = true;
        }
        if (!div.getTxtRenrakusakiMei1().getValue().equals(shomeisho.get支給額計算結果連絡先名称1())) {
            is変更 = true;
        }
        if (!div.getTxtRenrakusakiMei2().getValue().equals(shomeisho.get支給額計算結果連絡先名称2())) {
            is変更 = true;
        }
        return is変更;
    }

    private boolean is負担額変更1(boolean is変更, JikofutangakuShomeishoTorokuBusiness business) {
        List<JigyoKogakuGassanJikoFutanGakuShomeishoMeisai> 明細List = getJibunnoMeisaiList(business.get事業高額合算自己負担額証明書情報(),
                business.get事業高額合算自己負担額証明書明細情報());

        for (JigyoKogakuGassanJikoFutanGakuShomeishoMeisai meisai : 明細List) {
            if (八月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku8 = div.getTxtJikofutangaku8().getValue();
                if (txtJikofutangaku8 != null && !txtJikofutangaku8.equals(meisai.get自己負担額())) {
                    is変更 = true;
                }
                Decimal txtUchiFutangaku8 = div.getTxtUchiFutangaku8().getValue();
                if (txtUchiFutangaku8 != null && !txtUchiFutangaku8.equals(meisai.get70_74自己負担額_内数())) {
                    is変更 = true;
                }
            }
            if (九月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku9 = div.getTxtJikofutangaku9().getValue();
                if (txtJikofutangaku9 != null && !txtJikofutangaku9.equals(meisai.get自己負担額())) {
                    is変更 = true;
                }
                Decimal txtUchiFutangaku8 = div.getTxtUchiFutangaku8().getValue();
                if (txtUchiFutangaku8 != null && !txtUchiFutangaku8.equals(meisai.get70_74自己負担額_内数())) {
                    is変更 = true;
                }
            }
            if (十月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku10 = div.getTxtJikofutangaku10().getValue();
                if (txtJikofutangaku10 != null && !txtJikofutangaku10.equals(meisai.get自己負担額())) {
                    is変更 = true;
                }
                Decimal txtUchiFutangaku10 = div.getTxtUchiFutangaku10().getValue();
                if (txtUchiFutangaku10 != null && !txtUchiFutangaku10.equals(meisai.get70_74自己負担額_内数())) {
                    is変更 = true;
                }
            }

            is変更 = is負担額変更2(is変更, meisai);
            is変更 = is負担額変更3(is変更, meisai);
            is変更 = is負担額変更4(is変更, meisai);
        }
        return is変更;
    }

    private boolean is負担額変更2(boolean is変更, JigyoKogakuGassanJikoFutanGakuShomeishoMeisai meisai) {
        if (十一月.equals(meisai.get対象月())) {
            Decimal txtJikofutangaku11 = div.getTxtJikofutangaku11().getValue();
            if (txtJikofutangaku11 != null && !txtJikofutangaku11.equals(meisai.get自己負担額())) {
                is変更 = true;
            }
            Decimal txtUchiFutangaku11 = div.getTxtUchiFutangaku11().getValue();
            if (txtUchiFutangaku11 != null && !txtUchiFutangaku11.equals(meisai.get70_74自己負担額_内数())) {
                is変更 = true;
            }
        }
        if (十二月.equals(meisai.get対象月())) {
            Decimal txtJikofutangaku12 = div.getTxtJikofutangaku12().getValue();
            if (txtJikofutangaku12 != null && !txtJikofutangaku12.equals(meisai.get自己負担額())) {
                is変更 = true;
            }
            Decimal txtUchiFutangaku12 = div.getTxtUchiFutangaku12().getValue();
            if (txtUchiFutangaku12 != null && !txtUchiFutangaku12.equals(meisai.get70_74自己負担額_内数())) {
                is変更 = true;
            }
        }
        if (一月.equals(meisai.get対象月())) {
            Decimal txtJikofutangaku1 = div.getTxtJikofutangaku1().getValue();
            if (txtJikofutangaku1 != null && !txtJikofutangaku1.equals(meisai.get自己負担額())) {
                is変更 = true;
            }
            Decimal txtUchiFutangaku1 = div.getTxtUchiFutangaku1().getValue();
            if (txtUchiFutangaku1 != null && !txtUchiFutangaku1.equals(meisai.get70_74自己負担額_内数())) {
                is変更 = true;
            }
        }

        return is変更;
    }

    private boolean is負担額変更3(boolean is変更, JigyoKogakuGassanJikoFutanGakuShomeishoMeisai meisai) {
        if (二月.equals(meisai.get対象月())) {
            Decimal txtJikofutangaku2 = div.getTxtJikofutangaku2().getValue();
            if (txtJikofutangaku2 != null && !txtJikofutangaku2.equals(meisai.get自己負担額())) {
                is変更 = true;
            }
            Decimal txtUchiFutangaku2 = div.getTxtUchiFutangaku2().getValue();
            if (txtUchiFutangaku2 != null && !txtUchiFutangaku2.equals(meisai.get70_74自己負担額_内数())) {
                is変更 = true;
            }
        }
        if (三月.equals(meisai.get対象月())) {
            Decimal txtJikofutangaku3 = div.getTxtJikofutangaku3().getValue();
            if (txtJikofutangaku3 != null && !txtJikofutangaku3.equals(meisai.get自己負担額())) {
                is変更 = true;
            }
            Decimal txtUchiFutangaku3 = div.getTxtUchiFutangaku3().getValue();
            if (txtUchiFutangaku3 != null && !txtUchiFutangaku3.equals(meisai.get70_74自己負担額_内数())) {
                is変更 = true;
            }
        }
        if (四月.equals(meisai.get対象月())) {
            Decimal txtJikofutangaku4 = div.getTxtJikofutangaku4().getValue();
            if (txtJikofutangaku4 != null && !txtJikofutangaku4.equals(meisai.get自己負担額())) {
                is変更 = true;
            }
            Decimal txtUchiFutangaku4 = div.getTxtUchiFutangaku4().getValue();
            if (txtUchiFutangaku4 != null && !txtUchiFutangaku4.equals(meisai.get70_74自己負担額_内数())) {
                is変更 = true;
            }
        }

        return is変更;
    }

    private boolean is負担額変更4(boolean is変更, JigyoKogakuGassanJikoFutanGakuShomeishoMeisai meisai) {

        if (五月.equals(meisai.get対象月())) {
            Decimal txtJikofutangaku5 = div.getTxtJikofutangaku5().getValue();
            if (txtJikofutangaku5 != null && !txtJikofutangaku5.equals(meisai.get自己負担額())) {
                is変更 = true;
            }
            Decimal txtUchiFutangaku5 = div.getTxtUchiFutangaku5().getValue();
            if (txtUchiFutangaku5 != null && !txtUchiFutangaku5.equals(meisai.get70_74自己負担額_内数())) {
                is変更 = true;
            }
        }
        if (六月.equals(meisai.get対象月())) {
            Decimal txtJikofutangaku6 = div.getTxtJikofutangaku6().getValue();
            if (txtJikofutangaku6 != null && !txtJikofutangaku6.equals(meisai.get自己負担額())) {
                is変更 = true;
            }
            Decimal txtUchiFutangaku6 = div.getTxtUchiFutangaku6().getValue();
            if (txtUchiFutangaku6 != null && !txtUchiFutangaku6.equals(meisai.get70_74自己負担額_内数())) {
                is変更 = true;
            }
        }
        if (七月.equals(meisai.get対象月())) {
            Decimal txtJikofutangaku7 = div.getTxtJikofutangaku7().getValue();
            if (txtJikofutangaku7 != null && !txtJikofutangaku7.equals(meisai.get自己負担額())) {
                is変更 = true;
            }
            Decimal txtUchiFutangaku7 = div.getTxtUchiFutangaku7().getValue();
            if (txtUchiFutangaku7 != null && !txtUchiFutangaku7.equals(meisai.get70_74自己負担額_内数())) {
                is変更 = true;
            }
        }
        return is変更;
    }

    /**
     * 初期値と比較してチェックします。
     *
     * @param business JikofutangakuShomeishoTorokuBusiness
     * @return true:変更,false未変更
     */
    public boolean is証明書登録画面変更(JikofutangakuShomeishoTorokuBusiness business) {

        if (STATUS_新規.equals(div.getExecutionStatus())) {
            return is追加_証明書登録画面変更();
        } else if (STATUS_修正.equals(div.getExecutionStatus())) {
            return is修正_証明書登録画面変更(business);
        }
        return false;
    }

    /**
     * executionStatus が追加の場合、初期値と比較してチェックします。
     *
     * @return true:変更,false未変更
     */
    public boolean is追加_証明書登録画面変更() {
        RString 新規_対象年度 = div.getDdlShinkiTaishoNendo().getSelectedValue();
        boolean is変更 = false;
        RString 登録_対象年度 = div.getTxtTorokuTaishoNendo().getValue();
        if (!新規_対象年度.equals(登録_対象年度)) {
            is変更 = true;
        }
        RString 保険者番号 = div.getTxtTorokuShokisaiHokenshaNo().getValue();
        if (!保険者番号.equals(div.getTxtShinkiTuikaShokisaiHokenshaNo().getValue())) {
            is変更 = true;
        }
        RString 登録_支給申請書整理番号 = div.getTxtKoshinShikyuShinseishoSeiriNo().getValue();
        if (!登録_支給申請書整理番号.equals(div.getTxtShinkiShikyuShinseishoSeiriNo().getValue())) {
            is変更 = true;
        }
        RString 登録_履歴番号 = div.getTxtTorokuRirekiNo().getValue();
        if (!RString.isNullOrEmpty(登録_履歴番号)) {
            is変更 = true;
        }
        if (div.getTxtUketsukeDate().getValue() != null) {
            is変更 = true;
        }
        if (!RString.isNullOrEmpty(div.getTxtJikofutangakuShomeishoSeiriNo().getValue())) {
            is変更 = true;
        }
        if (!div.getCcdTennyumaeHokensha().getHokenjaNo().isEmpty()) {
            is変更 = true;
        }
        if (div.getTxtTaishoKikan().getFromValue() != null) {
            is変更 = true;
        }
        if (div.getTxtTaishoKikan().getToValue() != null) {
            is変更 = true;
        }
        if (div.getTxtHihokenshaKikan().getFromValue() != null) {
            is変更 = true;
        }
        if (div.getTxtHihokenshaKikan().getToValue() != null) {
            is変更 = true;
        }
        if (div.getTxtHakkoDate().getValue() != null) {
            is変更 = true;
        }
        if (div.getTxtYubinNo().getValue() != null) {
            is変更 = true;
        }
        if (!RString.isNullOrEmpty(div.getTxtRenrakusakiJusho().getValue())) {
            is変更 = true;
        }
        if (!RString.isNullOrEmpty(div.getTxtRenrakusakiMei1().getValue())) {
            is変更 = true;
        }
        if (!RString.isNullOrEmpty(div.getTxtRenrakusakiMei2().getValue())) {
            is変更 = true;
        }
        is変更 = is負担額変更1(is変更);
        is変更 = is負担額変更2(is変更);
        return is変更;
    }

    private boolean is負担額変更1(boolean is変更) {
        if (div.getTxtJikofutangaku8().getValue() != null) {
            is変更 = true;
        }
        if (div.getTxtUchiFutangaku8().getValue() != null) {
            is変更 = true;
        }
        if (div.getTxtJikofutangaku9().getValue() != null) {
            is変更 = true;
        }
        if (div.getTxtUchiFutangaku9().getValue() != null) {
            is変更 = true;
        }
        if (div.getTxtJikofutangaku10().getValue() != null) {
            is変更 = true;
        }
        if (div.getTxtUchiFutangaku10().getValue() != null) {
            is変更 = true;
        }
        if (div.getTxtJikofutangaku11().getValue() != null) {
            is変更 = true;
        }
        if (div.getTxtUchiFutangaku11().getValue() != null) {
            is変更 = true;
        }
        if (div.getTxtJikofutangaku12().getValue() != null) {
            is変更 = true;
        }
        if (div.getTxtUchiFutangaku12().getValue() != null) {
            is変更 = true;
        }
        return is変更;
    }

    private boolean is負担額変更2(boolean is変更) {
        if (div.getTxtJikofutangaku1().getValue() != null) {
            is変更 = true;
        }
        if (div.getTxtUchiFutangaku1().getValue() != null) {
            is変更 = true;
        }
        if (div.getTxtJikofutangaku2().getValue() != null) {
            is変更 = true;
        }
        if (div.getTxtUchiFutangaku2().getValue() != null) {
            is変更 = true;
        }
        if (div.getTxtJikofutangaku3().getValue() != null) {
            is変更 = true;
        }
        if (div.getTxtUchiFutangaku3().getValue() != null) {
            is変更 = true;
        }
        if (div.getTxtJikofutangaku4().getValue() != null) {
            is変更 = true;
        }
        if (div.getTxtUchiFutangaku4().getValue() != null) {
            is変更 = true;
        }
        if (div.getTxtJikofutangaku5().getValue() != null) {
            is変更 = true;
        }
        if (div.getTxtUchiFutangaku5().getValue() != null) {
            is変更 = true;
        }
        if (div.getTxtJikofutangaku6().getValue() != null) {
            is変更 = true;
        }
        if (div.getTxtUchiFutangaku6().getValue() != null) {
            is変更 = true;
        }
        if (div.getTxtJikofutangaku7().getValue() != null) {
            is変更 = true;
        }
        if (div.getTxtUchiFutangaku7().getValue() != null) {
            is変更 = true;
        }
        if (div.getTxtJikofutangakuGokei().getValue() != null) {
            is変更 = true;
        }
        if (div.getTxtUchiFutangakuGokei().getValue() != null) {
            is変更 = true;
        }
        return is変更;
    }

    /**
     * 自己負担額合計の計算します。
     *
     */
    public void 自己負担額合計の計算() {
        Decimal jikofutangakuGokei = nullToZero(div.getTxtJikofutangaku8().getValue())
                .add(nullToZero(div.getTxtJikofutangaku9().getValue()))
                .add(nullToZero(div.getTxtJikofutangaku10().getValue()))
                .add(nullToZero(div.getTxtJikofutangaku11().getValue()))
                .add(nullToZero(div.getTxtJikofutangaku12().getValue()))
                .add(nullToZero(div.getTxtJikofutangaku1().getValue()))
                .add(nullToZero(div.getTxtJikofutangaku2().getValue()))
                .add(nullToZero(div.getTxtJikofutangaku3().getValue()))
                .add(nullToZero(div.getTxtJikofutangaku4().getValue()))
                .add(nullToZero(div.getTxtJikofutangaku5().getValue()))
                .add(nullToZero(div.getTxtJikofutangaku6().getValue()))
                .add(nullToZero(div.getTxtJikofutangaku7().getValue()));

        div.getTxtJikofutangakuGokei().setValue(jikofutangakuGokei);
    }

    private Decimal nullToZero(Decimal obj) {
        if (obj == null) {
            return Decimal.ZERO;
        } else {
            return obj;
        }
    }

    /**
     * うち70～74歳に係る負担額合計の計算します。
     *
     */
    public void うち70_74歳に係る負担額合計の計算() {
        Decimal uchiFutangakuGokei = nullToZero(div.getTxtUchiFutangaku8().getValue())
                .add(nullToZero(div.getTxtUchiFutangaku9().getValue()))
                .add(nullToZero(div.getTxtUchiFutangaku10().getValue()))
                .add(nullToZero(div.getTxtUchiFutangaku11().getValue()))
                .add(nullToZero(div.getTxtUchiFutangaku12().getValue()))
                .add(nullToZero(div.getTxtUchiFutangaku1().getValue()))
                .add(nullToZero(div.getTxtUchiFutangaku2().getValue()))
                .add(nullToZero(div.getTxtUchiFutangaku3().getValue()))
                .add(nullToZero(div.getTxtUchiFutangaku4().getValue()))
                .add(nullToZero(div.getTxtUchiFutangaku5().getValue()))
                .add(nullToZero(div.getTxtUchiFutangaku6().getValue()))
                .add(nullToZero(div.getTxtUchiFutangaku7().getValue()));

        div.getTxtUchiFutangakuGokei().setValue(uchiFutangakuGokei);
    }

    /**
     * Parameterを取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return JikofutangakuShomeishoTorokuParameter
     */
    public JikofutangakuShomeishoTorokuParameter getParameterForbtnSearch(HihokenshaNo 被保険者番号) {
        JikofutangakuShomeishoTorokuParameter parameter = new JikofutangakuShomeishoTorokuParameter();
        RString 対象年度 = div.getDdlKoshinTaishoNendo().getSelectedKey();
        RStringBuilder 対象年度_SB = new RStringBuilder(対象年度);
        対象年度_SB.append("0101");
        RString 支給申請書整理番号 = div.getTxtKoshinShikyuShinseishoSeiriNo().getValue();

        parameter.set対象年度(new FlexibleDate(対象年度_SB.toRString()).getYear().toDateString());
        parameter.set支給申請書整理番号(支給申請書整理番号);
        parameter.set被保険者番号(被保険者番号.value());
        parameter.setUse支給申請書整理番号(!RString.isNullOrEmpty(支給申請書整理番号));
        return parameter;
    }

    /**
     * Parameterを取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return JikofutangakuShomeishoTorokuParameter
     */
    public JikofutangakuShomeishoTorokuParameter getParameterFor登録(HihokenshaNo 被保険者番号) {
        JikofutangakuShomeishoTorokuParameter parameter = new JikofutangakuShomeishoTorokuParameter();
        RString txtTorokuTaishoNendo = div.getTxtTorokuTaishoNendo().getValue();
        RStringBuilder 対象年度 = new RStringBuilder(txtTorokuTaishoNendo.substring(0, 桁数_4));
        対象年度.append(月日);
        parameter.set対象年度(new RDate(対象年度.toString()).getYear().toDateString());
        RString 支給申請書整理番号 = div.getTxtTorokuShikyuShinseishoSeiriNo().getValue();
        parameter.set支給申請書整理番号(支給申請書整理番号);
        parameter.set被保険者番号(被保険者番号.value());
        RString 証記載保険者番号 = div.getTxtTorokuShokisaiHokenshaNo().getValue();
        parameter.set証記載保険者番号(証記載保険者番号);
        RString 転入前保険者番号 = div.getCcdTennyumaeHokensha().getHokenjaNo();
        parameter.set転入前保険者番号(転入前保険者番号);
        parameter.setUse支給申請書整理番号(!RString.isNullOrEmpty(支給申請書整理番号));
        return parameter;
    }

    /**
     * Parameterを取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return JikofutangakuShomeishoTorokuParameter
     */
    public JikofutangakuShomeishoTorokuParameter getParameterSelectRow(HihokenshaNo 被保険者番号) {
        JikofutangakuShomeishoTorokuParameter parameter = new JikofutangakuShomeishoTorokuParameter();

        dgShomeishoRireki_Row row = div.getDgShomeishoRireki().getActiveRow();
        RStringBuilder 対象年度 = new RStringBuilder(row.getTaishoNendo());
        対象年度.append(月日);
        parameter.set対象年度(new RDate(対象年度.toString()).getYear().toDateString());
        parameter.set支給申請書整理番号(row.getShikyuShinseishoSeiriNo());
        parameter.set被保険者番号(被保険者番号.value());
        parameter.set証記載保険者番号(row.getShokisaiHokenshaNo());
        RString 転入前保険者番号 = row.getTennyumaeShokisaiHokensha();
        if (!RString.isNullOrEmpty(転入前保険者番号) && SIZE <= 転入前保険者番号.length()) {
            parameter.set転入前保険者番号(転入前保険者番号.substring(0, SIZE));
        }
        parameter.setUse支給申請書整理番号(!RString.isNullOrEmpty(row.getShikyuShinseishoSeiriNo()));
        parameter.set履歴番号(Integer.parseInt(row.getRirekiNo().toString()));
        return parameter;
    }

    /**
     * 事業高額合算自己負担額証明書データを証明書履歴GRDに設定します。
     *
     * @param 証明書情報List 証明書情報List
     */
    public void set証明書履歴GRD(List<JigyoKogakuGassanJikoFutanGakuShomeisho> 証明書情報List) {
        List<dgShomeishoRireki_Row> dataSource = new ArrayList<>();
        for (JigyoKogakuGassanJikoFutanGakuShomeisho shomeisho : 証明書情報List) {
            dgShomeishoRireki_Row row = new dgShomeishoRireki_Row();
            RString 対象年度 = shomeisho.get対象年度()
                    .wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN)
                    .fillType(FillType.BLANK).toDateString();
            row.setTaishoNendo(対象年度);
            row.setShokisaiHokenshaNo(shomeisho.get証記載保険者番号().value());
            row.setShikyuShinseishoSeiriNo(shomeisho.get支給申請書整理番号());
            RStringBuilder 転入前証記載保険者 = new RStringBuilder();
            転入前証記載保険者.append(shomeisho.get転入前保険者番号().value());
            転入前証記載保険者.append(new RString(" "));
            転入前証記載保険者.append(shomeisho.get転入前保険者名());
            row.setTennyumaeShokisaiHokensha(転入前証記載保険者.toRString());
            row.setRirekiNo(new RString(String.valueOf(shomeisho.get履歴番号())));
            RStringBuilder 被保険者期間 = new RStringBuilder();
            被保険者期間.append(shomeisho.get被保険者期間開始年月日().wareki().toString());
            被保険者期間.append(new RString("～"));
            被保険者期間.append(shomeisho.get被保険者期間終了年月日().wareki().toString());
            row.setHihokenshaKikan(被保険者期間.toRString());
            TextBoxFlexibleDate uketsukeDate = new TextBoxFlexibleDate();
            uketsukeDate.setValue(shomeisho.get受付年月日());
            row.setUketsukeDate(uketsukeDate);
            row.setTaishoNendoKouSin(shomeisho.get対象年度().toDateString());
            dataSource.add(row);
        }
        div.getDgShomeishoRireki().setDataSource(dataSource);
    }

    /**
     * 証明書登録が読取専用に設定します。
     *
     * @param 読取専用 boolean
     */
    public void set証明書登録To読取専用(boolean 読取専用) {
        div.getTxtTorokuTaishoNendo().setReadOnly(読取専用);
        div.getTxtTorokuShokisaiHokenshaNo().setReadOnly(読取専用);
        div.getTxtTorokuShikyuShinseishoSeiriNo().setReadOnly(読取専用);
        div.getTxtTorokuRirekiNo().setReadOnly(読取専用);
        div.getTxtUketsukeDate().setReadOnly(読取専用);
        div.getTxtJikofutangakuShomeishoSeiriNo().setReadOnly(読取専用);
        div.getCcdTennyumaeHokensha().setReadOnly(読取専用);
        div.getTxtTaishoKikan().setReadOnly(読取専用);
        div.getTxtHihokenshaKikan().setReadOnly(読取専用);
        div.getTxtHakkoDate().setReadOnly(読取専用);
        div.getTxtYubinNo().setReadOnly(読取専用);
        div.getTxtRenrakusakiJusho().setReadOnly(読取専用);
        div.getTxtRenrakusakiMei1().setReadOnly(読取専用);
        div.getTxtRenrakusakiMei2().setReadOnly(読取専用);

        div.getTxtJikofutangaku8().setReadOnly(読取専用);
        div.getTxtUchiFutangaku8().setReadOnly(読取専用);

        div.getTxtJikofutangaku9().setReadOnly(読取専用);
        div.getTxtUchiFutangaku9().setReadOnly(読取専用);

        div.getTxtJikofutangaku10().setReadOnly(読取専用);
        div.getTxtUchiFutangaku10().setReadOnly(読取専用);

        div.getTxtJikofutangaku11().setReadOnly(読取専用);
        div.getTxtUchiFutangaku11().setReadOnly(読取専用);

        div.getTxtJikofutangaku12().setReadOnly(読取専用);
        div.getTxtUchiFutangaku12().setReadOnly(読取専用);

        div.getTxtJikofutangaku1().setReadOnly(読取専用);
        div.getTxtUchiFutangaku1().setReadOnly(読取専用);
        div.getTxtJikofutangaku2().setReadOnly(読取専用);
        div.getTxtUchiFutangaku2().setReadOnly(読取専用);
        div.getTxtJikofutangaku3().setReadOnly(読取専用);
        div.getTxtUchiFutangaku3().setReadOnly(読取専用);
        div.getTxtJikofutangaku4().setReadOnly(読取専用);
        div.getTxtUchiFutangaku4().setReadOnly(読取専用);
        div.getTxtJikofutangaku5().setReadOnly(読取専用);
        div.getTxtUchiFutangaku5().setReadOnly(読取専用);
        div.getTxtJikofutangaku6().setReadOnly(読取専用);
        div.getTxtUchiFutangaku6().setReadOnly(読取専用);
        div.getTxtJikofutangaku7().setReadOnly(読取専用);
        div.getTxtUchiFutangaku7().setReadOnly(読取専用);
        div.getTxtJikofutangakuGokei().setReadOnly(読取専用);
        div.getTxtUchiFutangakuGokei().setReadOnly(読取専用);
    }

    /**
     * 事業高額合算自己負担額証明書を作成します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 Decimal
     * @return JigyoKogakuGassanJikoFutanGakuShomeisho
     */
    public JigyoKogakuGassanJikoFutanGakuShomeisho get事業高額合算自己負担額証明書(HihokenshaNo 被保険者番号, Decimal 履歴番号) {
        RString txtTorokuTaishoNendo = div.getTxtTorokuTaishoNendo().getValue();
        RStringBuilder 対象年度 = new RStringBuilder(txtTorokuTaishoNendo.substring(0, 桁数_4));
        対象年度.append(月日);
        RString 支給申請書整理番号 = div.getTxtTorokuShikyuShinseishoSeiriNo().getValue();
        RString 証記載保険者番号 = div.getTxtTorokuShokisaiHokenshaNo().getValue();
        RString 転入前保険者番号 = div.getCcdTennyumaeHokensha().getHokenjaNo();

        JigyoKogakuGassanJikoFutanGakuShomeisho shomeisho = new JigyoKogakuGassanJikoFutanGakuShomeisho(
                被保険者番号,
                new FlexibleYear(new RDate(対象年度.toString()).getYear().toDateString()),
                new HokenshaNo(証記載保険者番号),
                支給申請書整理番号,
                new HokenshaNo(転入前保険者番号),
                履歴番号.add(Decimal.ONE).intValue());

        return shomeisho.createBuilderForEdit().set自己負担額証明書整理番号(div.getTxtJikofutangakuShomeishoSeiriNo().getValue())
                .set転入前保険者名(div.getCcdTennyumaeHokensha().getHokenjaName())
                .set対象計算期間開始年月日(new FlexibleDate(div.getTxtTaishoKikan().getFromValue().toDateString()))
                .set対象計算期間終了年月日(new FlexibleDate(div.getTxtTaishoKikan().getToValue().toDateString()))
                .set被保険者期間開始年月日(new FlexibleDate(div.getTxtHihokenshaKikan().getFromValue().toDateString()))
                .set被保険者期間終了年月日(new FlexibleDate(div.getTxtHihokenshaKikan().getToValue().toDateString()))
                .set発行年月日(div.getTxtHakkoDate().getValue())
                .set合計合計_自己負担額(nullToZero(div.getTxtJikofutangakuGokei().getValue()))
                .set合計_70_74自己負担額_内訳(nullToZero(div.getTxtUchiFutangakuGokei().getValue()))
                .set合計_70未満高額支給額(Decimal.ZERO)
                .set合計_70_74高額支給額(Decimal.ZERO)
                .set支給額計算結果連絡先郵便番号(div.getTxtYubinNo().getValue())
                .set支給額計算結果連絡先住所(div.getTxtRenrakusakiJusho().getValue())
                .set支給額計算結果連絡先名称1(div.getTxtRenrakusakiMei1().getValue())
                .set支給額計算結果連絡先名称2(div.getTxtRenrakusakiMei2().getValue())
                .set備考(RString.EMPTY)
                .set受付年月日(div.getTxtUketsukeDate().getValue())
                .set支給額計算年月日(FlexibleDate.EMPTY).build();
    }

    /**
     * 事業高額合算自己負担額証明書を作成します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 更新前データ JigyoKogakuGassanJikoFutanGakuShomeisho
     * @return JigyoKogakuGassanJikoFutanGakuShomeisho
     */
    public JigyoKogakuGassanJikoFutanGakuShomeisho get更新用事業高額合算自己負担額証明書(HihokenshaNo 被保険者番号,
            JigyoKogakuGassanJikoFutanGakuShomeisho 更新前データ) {
        RString txtTorokuTaishoNendo = div.getTxtTorokuTaishoNendo().getValue();
        RStringBuilder 対象年度 = new RStringBuilder(txtTorokuTaishoNendo.substring(0, 桁数_4));
        対象年度.append(月日);
        RString 支給申請書整理番号 = div.getTxtTorokuShikyuShinseishoSeiriNo().getValue();
        RString 証記載保険者番号 = div.getTxtTorokuShokisaiHokenshaNo().getValue();
        RString 転入前保険者番号 = div.getCcdTennyumaeHokensha().getHokenjaNo();

        JigyoKogakuGassanJikoFutanGakuShomeisho shomeisho = new JigyoKogakuGassanJikoFutanGakuShomeisho(
                被保険者番号,
                new FlexibleYear(new RDate(対象年度.toString()).getYear().toDateString()),
                new HokenshaNo(証記載保険者番号),
                支給申請書整理番号,
                new HokenshaNo(転入前保険者番号),
                更新前データ.get履歴番号());

        return shomeisho.createBuilderForEdit().set自己負担額証明書整理番号(div.getTxtJikofutangakuShomeishoSeiriNo().getValue())
                .set転入前保険者名(div.getCcdTennyumaeHokensha().getHokenjaName())
                .set対象計算期間開始年月日(new FlexibleDate(div.getTxtTaishoKikan().getFromValue().toDateString()))
                .set対象計算期間終了年月日(new FlexibleDate(div.getTxtTaishoKikan().getToValue().toDateString()))
                .set被保険者期間開始年月日(new FlexibleDate(div.getTxtHihokenshaKikan().getFromValue().toDateString()))
                .set被保険者期間終了年月日(new FlexibleDate(div.getTxtHihokenshaKikan().getToValue().toDateString()))
                .set発行年月日(div.getTxtHakkoDate().getValue())
                .set合計合計_自己負担額(nullToZero(div.getTxtJikofutangakuGokei().getValue()))
                .set合計_70_74自己負担額_内訳(nullToZero(div.getTxtUchiFutangakuGokei().getValue()))
                .set合計_70未満高額支給額(更新前データ.get合計_70未満高額支給額())
                .set合計_70_74高額支給額(更新前データ.get合計_70_74高額支給額())
                .set支給額計算結果連絡先郵便番号(div.getTxtYubinNo().getValue())
                .set支給額計算結果連絡先住所(div.getTxtRenrakusakiJusho().getValue())
                .set支給額計算結果連絡先名称1(div.getTxtRenrakusakiMei1().getValue())
                .set支給額計算結果連絡先名称2(div.getTxtRenrakusakiMei2().getValue())
                .set備考(更新前データ.get備考())
                .set受付年月日(div.getTxtUketsukeDate().getValue())
                .set支給額計算年月日(更新前データ.get支給額計算年月日()).build();
    }

    /**
     * 事業高額合算自己負担額証明書を作成します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 更新前データ JigyoKogakuGassanJikoFutanGakuShomeisho
     * @return JigyoKogakuGassanJikoFutanGakuShomeisho
     */
    public JigyoKogakuGassanJikoFutanGakuShomeisho get更新用事業高額合算自己負担額証明書1(HihokenshaNo 被保険者番号,
            JigyoKogakuGassanJikoFutanGakuShomeisho 更新前データ) {
        return 更新前データ.createBuilderForEdit().set自己負担額証明書整理番号(div.getTxtJikofutangakuShomeishoSeiriNo().getValue())
                .set転入前保険者名(div.getCcdTennyumaeHokensha().getHokenjaName())
                .set対象計算期間開始年月日(new FlexibleDate(div.getTxtTaishoKikan().getFromValue().toDateString()))
                .set対象計算期間終了年月日(new FlexibleDate(div.getTxtTaishoKikan().getToValue().toDateString()))
                .set被保険者期間開始年月日(new FlexibleDate(div.getTxtHihokenshaKikan().getFromValue().toDateString()))
                .set被保険者期間終了年月日(new FlexibleDate(div.getTxtHihokenshaKikan().getToValue().toDateString()))
                .set発行年月日(div.getTxtHakkoDate().getValue())
                .set合計合計_自己負担額(nullToZero(div.getTxtJikofutangakuGokei().getValue()))
                .set合計_70_74自己負担額_内訳(nullToZero(div.getTxtUchiFutangakuGokei().getValue()))
                .set支給額計算結果連絡先郵便番号(div.getTxtYubinNo().getValue())
                .set支給額計算結果連絡先住所(div.getTxtRenrakusakiJusho().getValue())
                .set支給額計算結果連絡先名称1(div.getTxtRenrakusakiMei1().getValue())
                .set支給額計算結果連絡先名称2(div.getTxtRenrakusakiMei2().getValue())
                .set受付年月日(div.getTxtUketsukeDate().getValue()).build();
    }

    /**
     * 事業高額合算自己負担額証明書明細を作成します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 Decimal
     * @return List<JigyoKogakuGassanJikoFutanGakuShomeishoMeisai>
     */
    public List<JigyoKogakuGassanJikoFutanGakuShomeishoMeisai> get事業高額合算自己負担額証明書明細(HihokenshaNo 被保険者番号, Decimal 履歴番号) {
        List<JigyoKogakuGassanJikoFutanGakuShomeishoMeisai> meisaiList = new ArrayList<>();
        RString txtTorokuTaishoNendo = div.getTxtTorokuTaishoNendo().getValue();
        RStringBuilder 対象年度 = new RStringBuilder(txtTorokuTaishoNendo.substring(0, 桁数_4));
        対象年度.append(月日);
        RString 支給申請書整理番号 = div.getTxtTorokuShikyuShinseishoSeiriNo().getValue();
        RString 証記載保険者番号 = div.getTxtTorokuShokisaiHokenshaNo().getValue();
        RString 転入前保険者番号 = div.getCcdTennyumaeHokensha().getHokenjaNo();
        for (RString 対象月 : get対象月リスト()) {
            JigyoKogakuGassanJikoFutanGakuShomeishoMeisai meisai = new JigyoKogakuGassanJikoFutanGakuShomeishoMeisai(
                    被保険者番号,
                    new FlexibleYear(new RDate(対象年度.toString()).getYear().toDateString()),
                    new HokenshaNo(証記載保険者番号),
                    支給申請書整理番号,
                    new HokenshaNo(転入前保険者番号),
                    履歴番号.add(Decimal.ONE).intValue(), 対象月);
            JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiBuilder meisaiBuilder = meisai.createBuilderForEdit();
            meisaiBuilder = meisaiBuilder.set70未満高額支給額(Decimal.ZERO).set70_74高額支給額(Decimal.ZERO).set摘要(RString.EMPTY);
            if (八月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku8().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku8().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (九月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku9().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku9().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (十月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku10().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku10().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (十一月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku11().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku11().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (十二月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku12().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku12().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (一月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku1().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku1().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (二月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku2().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku2().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (三月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku3().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku3().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (四月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku4().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku4().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (五月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku5().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku5().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (六月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku6().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku6().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (七月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku7().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku7().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            }

            meisaiList.add(meisaiBuilder.build());
        }
        return meisaiList;
    }

    /**
     * 事業高額合算自己負担額証明書明細を作成します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 更新前データ List<JigyoKogakuGassanJikoFutanGakuShomeishoMeisai>
     * @return List<JigyoKogakuGassanJikoFutanGakuShomeishoMeisai>
     */
    public List<JigyoKogakuGassanJikoFutanGakuShomeishoMeisai> get更新用事業高額合算自己負担額証明書明細(HihokenshaNo 被保険者番号,
            List<JigyoKogakuGassanJikoFutanGakuShomeishoMeisai> 更新前データ) {
        List<JigyoKogakuGassanJikoFutanGakuShomeishoMeisai> meisaiList = new ArrayList<>();
        RString txtTorokuTaishoNendo = div.getTxtTorokuTaishoNendo().getValue();
        RStringBuilder 対象年度 = new RStringBuilder(txtTorokuTaishoNendo.substring(0, 桁数_4));
        対象年度.append(月日);
        RString 支給申請書整理番号 = div.getTxtTorokuShikyuShinseishoSeiriNo().getValue();
        RString 証記載保険者番号 = div.getTxtTorokuShokisaiHokenshaNo().getValue();
        RString 転入前保険者番号 = div.getCcdTennyumaeHokensha().getHokenjaNo();
        for (JigyoKogakuGassanJikoFutanGakuShomeishoMeisai meisai対象 : 更新前データ) {
            JigyoKogakuGassanJikoFutanGakuShomeishoMeisai meisai = new JigyoKogakuGassanJikoFutanGakuShomeishoMeisai(
                    被保険者番号,
                    new FlexibleYear(new RDate(対象年度.toString()).getYear().toDateString()),
                    new HokenshaNo(証記載保険者番号),
                    支給申請書整理番号,
                    new HokenshaNo(転入前保険者番号),
                    meisai対象.get履歴番号(), meisai対象.get対象月());
            JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiBuilder meisaiBuilder = meisai.createBuilderForEdit();
            meisaiBuilder = meisaiBuilder.set70未満高額支給額(meisai対象.get70未満高額支給額())
                    .set70_74高額支給額(meisai対象.get70_74高額支給額())
                    .set摘要(meisai対象.get摘要());
            if (八月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku8().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku8().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (九月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku9().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku9().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (十月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku10().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku10().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (十一月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku11().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku11().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (十二月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku12().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku12().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (一月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku1().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku1().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (二月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku2().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku2().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (三月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku3().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku3().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (四月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku4().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku4().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (五月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku5().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku5().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (六月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku6().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku6().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (七月.equals(meisai.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku7().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku7().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            }

            meisaiList.add(meisaiBuilder.build());
        }
        return meisaiList;
    }

    /**
     * 事業高額合算自己負担額証明書明細を作成します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 更新前データ List<JigyoKogakuGassanJikoFutanGakuShomeishoMeisai>
     * @return List<JigyoKogakuGassanJikoFutanGakuShomeishoMeisai>
     */
    public List<JigyoKogakuGassanJikoFutanGakuShomeishoMeisai> get更新用事業高額合算自己負担額証明書明細1(HihokenshaNo 被保険者番号,
            List<JigyoKogakuGassanJikoFutanGakuShomeishoMeisai> 更新前データ) {
        List<JigyoKogakuGassanJikoFutanGakuShomeishoMeisai> meisaiList = new ArrayList<>();
        for (JigyoKogakuGassanJikoFutanGakuShomeishoMeisai meisai対象 : 更新前データ) {
            JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiBuilder meisaiBuilder = meisai対象.createBuilderForEdit();
            if (八月.equals(meisai対象.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku8().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku8().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (九月.equals(meisai対象.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku9().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku9().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (十月.equals(meisai対象.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku10().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku10().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (十一月.equals(meisai対象.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku11().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku11().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (十二月.equals(meisai対象.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku12().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku12().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (一月.equals(meisai対象.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku1().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku1().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (二月.equals(meisai対象.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku2().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku2().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (三月.equals(meisai対象.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku3().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku3().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (四月.equals(meisai対象.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku4().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku4().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (五月.equals(meisai対象.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku5().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku5().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (六月.equals(meisai対象.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku6().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku6().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            } else if (七月.equals(meisai対象.get対象月())) {
                Decimal txtJikofutangaku = nullToZero(div.getTxtJikofutangaku7().getValue());
                Decimal txtUchiFutangaku = nullToZero(div.getTxtUchiFutangaku7().getValue());
                meisaiBuilder = meisaiBuilder.set自己負担額(txtJikofutangaku).set70_74自己負担額_内数(txtUchiFutangaku);
            }

            meisaiList.add(meisaiBuilder.build());
        }
        return meisaiList;
    }

    private List<RString> get対象月リスト() {
        List<RString> list = new ArrayList<>();
        list.add(八月);
        list.add(九月);
        list.add(十月);
        list.add(十一月);
        list.add(十二月);
        list.add(一月);
        list.add(二月);
        list.add(三月);
        list.add(四月);
        list.add(五月);
        list.add(六月);
        list.add(七月);
        return list;
    }

    /**
     * 事業高額合算支給申請書情報を登録情報に設定します。
     *
     * @param 登録情報報List List<JikofutangakuShomeishoTorokuBusiness>
     */
    public void set登録情報(List<JikofutangakuShomeishoTorokuBusiness> 登録情報報List) {
        JikofutangakuShomeishoTorokuBusiness business = 登録情報報List.get(0);
        JigyoKogakuGassanJikoFutanGakuShomeisho shomeisho = business.get事業高額合算自己負担額証明書情報();
        RString 対象年度 = shomeisho.get対象年度()
                .wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN)
                .fillType(FillType.BLANK).toDateString();
        div.getTxtTorokuTaishoNendo().setValue(対象年度);
        div.getTxtTorokuShokisaiHokenshaNo().setValue(shomeisho.get証記載保険者番号().value());
        div.getTxtTorokuShikyuShinseishoSeiriNo().setValue(shomeisho.get支給申請書整理番号());
        div.getTxtTorokuRirekiNo().setValue(new RString(String.valueOf(shomeisho.get履歴番号())));
        div.getTxtUketsukeDate().setValue(shomeisho.get受付年月日());
        div.getTxtJikofutangakuShomeishoSeiriNo().setValue(shomeisho.get自己負担額証明書整理番号());
        div.getCcdTennyumaeHokensha().intialize(new HokenjaNo(shomeisho.get転入前保険者番号().value()));
        div.getTxtTaishoKikan().setFromValue(new RDate(shomeisho.get対象計算期間開始年月日().toString()));
        div.getTxtTaishoKikan().setToValue(new RDate(shomeisho.get対象計算期間終了年月日().toString()));
        div.getTxtHihokenshaKikan().setFromValue(new RDate(shomeisho.get被保険者期間開始年月日().toString()));
        div.getTxtHihokenshaKikan().setToValue(new RDate(shomeisho.get被保険者期間終了年月日().toString()));
        div.getTxtHakkoDate().setValue(shomeisho.get発行年月日());
        div.getTxtYubinNo().setValue(shomeisho.get支給額計算結果連絡先郵便番号());
        div.getTxtRenrakusakiJusho().setValue(shomeisho.get支給額計算結果連絡先住所());
        div.getTxtRenrakusakiMei1().setValue(shomeisho.get支給額計算結果連絡先名称1());
        div.getTxtRenrakusakiMei2().setValue(shomeisho.get支給額計算結果連絡先名称2());
        List<JigyoKogakuGassanJikoFutanGakuShomeishoMeisai> 明細List = getJibunnoMeisaiList(shomeisho,
                business.get事業高額合算自己負担額証明書明細情報());

        for (JigyoKogakuGassanJikoFutanGakuShomeishoMeisai meisai : 明細List) {
            if (八月.equals(meisai.get対象月())) {
                div.getTxtJikofutangaku8().setValue(meisai.get自己負担額());
                div.getTxtUchiFutangaku8().setValue(meisai.get70_74自己負担額_内数());
            }
            if (九月.equals(meisai.get対象月())) {
                div.getTxtJikofutangaku9().setValue(meisai.get自己負担額());
                div.getTxtUchiFutangaku9().setValue(meisai.get70_74自己負担額_内数());
            }
            if (十月.equals(meisai.get対象月())) {
                div.getTxtJikofutangaku10().setValue(meisai.get自己負担額());
                div.getTxtUchiFutangaku10().setValue(meisai.get70_74自己負担額_内数());
            }
            if (十一月.equals(meisai.get対象月())) {
                div.getTxtJikofutangaku11().setValue(meisai.get自己負担額());
                div.getTxtUchiFutangaku11().setValue(meisai.get70_74自己負担額_内数());
            }
            if (十二月.equals(meisai.get対象月())) {
                div.getTxtJikofutangaku12().setValue(meisai.get自己負担額());
                div.getTxtUchiFutangaku12().setValue(meisai.get70_74自己負担額_内数());
            }
            if (一月.equals(meisai.get対象月())) {
                div.getTxtJikofutangaku1().setValue(meisai.get自己負担額());
                div.getTxtUchiFutangaku1().setValue(meisai.get70_74自己負担額_内数());
            }
            if (二月.equals(meisai.get対象月())) {
                div.getTxtJikofutangaku2().setValue(meisai.get自己負担額());
                div.getTxtUchiFutangaku2().setValue(meisai.get70_74自己負担額_内数());
            }
            if (三月.equals(meisai.get対象月())) {
                div.getTxtJikofutangaku3().setValue(meisai.get自己負担額());
                div.getTxtUchiFutangaku3().setValue(meisai.get70_74自己負担額_内数());
            }
            if (四月.equals(meisai.get対象月())) {
                div.getTxtJikofutangaku4().setValue(meisai.get自己負担額());
                div.getTxtUchiFutangaku4().setValue(meisai.get70_74自己負担額_内数());
            }
            if (五月.equals(meisai.get対象月())) {
                div.getTxtJikofutangaku5().setValue(meisai.get自己負担額());
                div.getTxtUchiFutangaku5().setValue(meisai.get70_74自己負担額_内数());
            }
            if (六月.equals(meisai.get対象月())) {
                div.getTxtJikofutangaku6().setValue(meisai.get自己負担額());
                div.getTxtUchiFutangaku6().setValue(meisai.get70_74自己負担額_内数());
            }
            if (七月.equals(meisai.get対象月())) {
                div.getTxtJikofutangaku7().setValue(meisai.get自己負担額());
                div.getTxtUchiFutangaku7().setValue(meisai.get70_74自己負担額_内数());
            }
        }

        div.getTxtJikofutangakuGokei().setValue(shomeisho.get合計_自己負担額());
        div.getTxtUchiFutangakuGokei().setValue(shomeisho.get合計_70_74自己負担額_内訳());
    }

    private List<JigyoKogakuGassanJikoFutanGakuShomeishoMeisai> getJibunnoMeisaiList(JigyoKogakuGassanJikoFutanGakuShomeisho shomeisho,
            List<JigyoKogakuGassanJikoFutanGakuShomeishoMeisai> meisaiList) {
        List<JigyoKogakuGassanJikoFutanGakuShomeishoMeisai> jibunnoMeisaiList = new ArrayList<>();
        for (JigyoKogakuGassanJikoFutanGakuShomeishoMeisai meisai : meisaiList) {
            if (shomeisho.get被保険者番号().equals(meisai.get被保険者番号())
                    && shomeisho.get対象年度().equals(meisai.get対象年度())
                    && shomeisho.get証記載保険者番号().equals(meisai.get証記載保険者番号())
                    && shomeisho.get支給申請書整理番号().equals(meisai.get支給申請書整理番号())
                    && shomeisho.get転入前保険者番号().equals(meisai.get転入前保険者番号())
                    && shomeisho.get履歴番号() == meisai.get履歴番号()) {
                jibunnoMeisaiList.add(meisai);
            }
        }
        return jibunnoMeisaiList;
    }

    /**
     * 証明書登録画面への値の設定（新規追加時）です。
     *
     */
    public void set登録情報() {
        RStringBuilder 対象年度SB = new RStringBuilder(div.getDdlShinkiTaishoNendo().getSelectedValue());
        対象年度SB.append(月日);
        RString 対象年度 = new RDate(対象年度SB.toString())
                .wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN)
                .fillType(FillType.BLANK).toDateString();
        div.getTxtTorokuTaishoNendo().setValue(対象年度.substring(0, 桁数_4));
        div.getTxtTorokuShokisaiHokenshaNo().setValue(div.getTxtShinkiTuikaShokisaiHokenshaNo().getValue());
        div.getTxtTorokuShikyuShinseishoSeiriNo().setValue(div.getTxtShinkiShikyuShinseishoSeiriNo().getValue());
        div.getTxtTorokuRirekiNo().clearValue();
        div.getTxtUketsukeDate().clearValue();
        div.getTxtJikofutangakuShomeishoSeiriNo().clearValue();
        div.getCcdTennyumaeHokensha().clear();
        div.getTxtTaishoKikan().clearFromValue();
        div.getTxtTaishoKikan().clearToValue();
        div.getTxtHihokenshaKikan().clearFromValue();
        div.getTxtHihokenshaKikan().clearToValue();
        div.getTxtHakkoDate().clearValue();
        div.getTxtYubinNo().clearValue();
        div.getTxtRenrakusakiJusho().clearValue();
        div.getTxtRenrakusakiMei1().clearValue();
        div.getTxtRenrakusakiMei2().clearValue();

        div.getTxtJikofutangaku8().clearValue();
        div.getTxtUchiFutangaku8().clearValue();

        div.getTxtJikofutangaku9().clearValue();
        div.getTxtUchiFutangaku9().clearValue();

        div.getTxtJikofutangaku10().clearValue();
        div.getTxtUchiFutangaku10().clearValue();

        div.getTxtJikofutangaku11().clearValue();
        div.getTxtUchiFutangaku11().clearValue();

        div.getTxtJikofutangaku12().clearValue();
        div.getTxtUchiFutangaku12().clearValue();

        div.getTxtJikofutangaku1().clearValue();
        div.getTxtUchiFutangaku1().clearValue();
        div.getTxtJikofutangaku2().clearValue();
        div.getTxtUchiFutangaku2().clearValue();
        div.getTxtJikofutangaku3().clearValue();
        div.getTxtUchiFutangaku3().clearValue();
        div.getTxtJikofutangaku4().clearValue();
        div.getTxtUchiFutangaku4().clearValue();
        div.getTxtJikofutangaku5().clearValue();
        div.getTxtUchiFutangaku5().clearValue();
        div.getTxtJikofutangaku6().clearValue();
        div.getTxtUchiFutangaku6().clearValue();
        div.getTxtJikofutangaku7().clearValue();
        div.getTxtUchiFutangaku7().clearValue();
        div.getTxtJikofutangakuGokei().clearValue();
        div.getTxtUchiFutangakuGokei().clearValue();
    }
}
