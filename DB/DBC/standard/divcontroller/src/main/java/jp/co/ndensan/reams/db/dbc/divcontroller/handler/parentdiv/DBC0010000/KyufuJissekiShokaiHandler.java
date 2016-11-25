/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010000;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHeader;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho1;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiSearchDataBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiShukeiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiShukeiKekkaDataBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiShokaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.dgKyufuJissekiMeisaiList_Row;
import jp.co.ndensan.reams.db.dbc.service.core.kyufujissekishokai.KyufuJissekiShokaiFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 給付実績照会_給付実績照会検索一覧画面
 *
 * @reamsid_L DBC-2970-010 linghuhang
 */
public class KyufuJissekiShokaiHandler {

    private final KyufuJissekiShokaiDiv div;
    private static final int 年度始 = 2000;
    private static final RString KEY = new RString("key0");
    private static final int INT_ZERO = 0;
    private static final int INT_ICHI = 1;
    private static final int INT_NI = 2;
    private static final int INT_SAN = 3;
    private static final int INT_YON = 4;
    private static final int INT_GO = 5;
    private static final int INT_ROKU = 6;
    private static final int INT_NANA = 7;
    private static final int INT_HACHI = 8;
    private static final int INT_KYU = 9;
    private static final int INT_JYU = 10;
    private static final int INT_JYUI = 11;
    private static final int INT_JYUN = 12;
    private static final int INT_JYUS = 13;
    private static final int INT_JYUY = 14;
    private static final int INT_JYUG = 15;
    private static final int INT_JYUR = 16;
    private static final int INT_JYUNA = 17;
    private static final int INT_JYUH = 18;
    private static final int INT_JYUK = 19;
    private static final int INT_NJYU = 20;
    private static final int INT_NJYUI = 21;
    private static final int INT_NJYUN = 22;
    private static final int INT_NJYUS = 23;
    private static final int INT_NJYUY = 24;
    private static final int INT_NJYUG = 25;
    private static final int INT_NJYUR = 26;
    private static final int INT_NJYUNA = 27;
    private static final int INT_NJYUH = 28;
    private static final int INT_NJYUK = 29;
    private static final int INT_SJYU = 30;
    private static final int INT_SJYUI = 31;
    private static final int INT_SJYUN = 32;
    private static final int INT_SJYUS = 33;
    private static final int INT_SJYUY = 34;
    private static final int INT_SJYUG = 35;
    private static final int INT_SJYUR = 36;
    private static final int INT_SJYUNA = 37;
    private static final int INT_SJYUH = 38;
    private static final int INT_SJYUK = 39;
    private static final int INT_YJYU = 40;
    private static final int INT_YJYUI = 41;
    private static final int INT_YJYUN = 42;
    private static final int INT_YJYUS = 43;
    private static final int INT_YJYUY = 44;
    private static final int INT_YJYUG = 45;
    private static final int INT_YJYUR = 46;
    private static final int INT_47 = 47;
    private static final int INT_YJYUH = 48;
    private static final int INT_49 = 49;
    private static final int INT_50 = 50;
    private static final int INT_51 = 51;
    private static final int INT_52 = 52;
    private static final int INT_53 = 53;
    private static final int INT_54 = 54;
    private static final int INT_55 = 55;
    private static final int INT_56 = 56;
    private static final int INT_57 = 57;
    private static final int INT_58 = 58;
    private static final int INT_59 = 59;
    private static final int INT_NJYUNG = 75;
    private static final RString RS_ZERO = new RString(0);
    private static final RString 指定居宅サービス = new RString("指定居宅サービス");
    private static final RString 居宅介護 = new RString("居宅介護");
    private static final RString 指定施設サービス等 = new RString("指定施設サービス等");
    private static final RString 介護予防_日常生活支援総合事業 = new RString("介護予防・日常生活支援総合事業");
    private static final RString 介護予防日常生活支援総合事業 = new RString("介護予防日常生活支援総合事業");
    private static final RString 訪問通所 = new RString("訪問通所");
    private static final RString 短期入所 = new RString("短期入所");
    private static final RString 地域密着 = new RString("地域密着");
    private static final RString 生活支援 = new RString("生活支援");
    private static final RString サービス種類 = new RString("txtServiceShurui");
    private static final RString サービス組１ = new RString("txtServiceGroup1");
    private static final RString サービス組２ = new RString("txtServiceGroup2");
    private static final RString 居宅サービス合計単位 = new RString("居宅サービス合計単位");
    private static final RString 地域密着型サービス合計単位 = new RString("地域密着型サービス合計単位");
    private static final RString 給付費合計 = new RString("給付費合計");
    private static final RString 利用者負担合計 = new RString("利用者負担合計");

    private static final RString GOKEI_PATTERN1_1 = new RString("居宅_単位数");
    private static final RString GOKEI_PATTERN1_2 = new RString("居宅_単位数＋出来高単位数");
    private static final RString GOKEI_PATTERN2_1 = new RString("施設_単位数");
    private static final RString GOKEI_PATTERN2_2 = new RString("施設_単位数＋出来高単位数");
    private static final RString GOKEI_PATTERN3 = new RString("地域密着型");
    private static final RString GOKEI_PATTERN4 = new RString("生活支援");
    private static final RString GOKEI_PATTERN5 = new RString("高額介護");
    private static final RString GOKEI_PATTERN6_1 = new RString("福祉用具販売");
    private static final RString GOKEI_PATTERN6_2 = new RString("住宅改修");
    private static final RString GOKEI_PATTERN_NOTHING = new RString("");

    /**
     * コンストラクタです。
     *
     * @param div 給付実績照会検索一覧画面Div
     */
    public KyufuJissekiShokaiHandler(KyufuJissekiShokaiDiv div) {
        this.div = div;
    }

    /**
     * 画面の初期化メソッドです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     */
    public void onLoad(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        div.getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getCcdKaigoShikakuKihon().initialize(被保険者番号);
        div.getDdlKyufuJissekiSearchNendo().setDataSource(get年度());
        div.getTxtKyufuJissekiSearchServiceTeikyoYM().setDisabled(true);
    }

    /**
     * 「条件をクリアする」ボタン押下する、検索条件パネル内の状態を初期状態にする。
     */
    public void onClick_btnKyufuJissekiSearchClear() {
        RDate システム日付 = RDate.getNowDate();
        div.getRadNendo().setSelectedKey(KEY);
        div.getDdlKyufuJissekiSearchNendo().setSelectedKey(new RString(システム日付.getYearValue()));
        div.getRadKyufuJissekiSearchDateType().clearSelectedItem();
        div.getTxtKyufuJissekiSearchServiceTeikyoYM().clearFromValue();
        div.getTxtKyufuJissekiSearchServiceTeikyoYM().clearToValue();
        div.getRadTaisho1().setSelectedKey(KEY);
        if (!RString.isNullOrEmpty(div.getRadNendo().getSelectedKey())) {
            div.getDdlKyufuJissekiSearchNendo().setDisabled(false);
            div.getTxtKyufuJissekiSearchServiceTeikyoYM().setDisabled(true);
        } else {
            div.getDdlKyufuJissekiSearchNendo().setDisabled(true);
            div.getTxtKyufuJissekiSearchServiceTeikyoYM().setDisabled(false);
        }
    }

    /**
     * 抽出範囲を変更する場合、画面を表示する。
     */
    public void onChange_radKyufuJissekiSearchDateType() {
        if (!RString.isNullOrEmpty(div.getRadNendo().getSelectedKey())) {
            div.getDdlKyufuJissekiSearchNendo().setDisabled(false);
            div.getTxtKyufuJissekiSearchServiceTeikyoYM().setDisabled(true);
        } else {
            div.getDdlKyufuJissekiSearchNendo().setDisabled(true);
            div.getTxtKyufuJissekiSearchServiceTeikyoYM().setDisabled(false);
        }
    }

    /**
     * 「検索する」ボタン押下する、画面一覧を表示する。
     *
     * @param 給付実績ヘッダ情報1 給付実績ヘッダ情報1
     * @param サービス提供年月_開始 サービス提供年月_開始
     * @param サービス提供年月_終了 サービス提供年月_終了
     * @param 一覧データ 一覧データ
     * @return 給付実績基本情報子Divデータ
     */
    public KyufuJissekiHeader onClick_btnKyufuJissekiSearch(KyufuJissekiHedajyoho1 給付実績ヘッダ情報1,
            FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了,
            KyufuJissekiSearchDataBusiness 一覧データ) {
        set明細一覧行();
        set明細一覧列(サービス提供年月_開始, サービス提供年月_終了);
        set一覧設定(一覧データ);
        setボタン表示非表示の設定(サービス提供年月_開始, サービス提供年月_終了);
        setボタン活性非活性の設定();
        return get給付実績基本情報子Div(給付実績ヘッダ情報1);
    }

    private KyufuJissekiHeader get給付実績基本情報子Div(KyufuJissekiHedajyoho1 給付実績ヘッダ情報1) {
        KyufuJissekiHeader data = new KyufuJissekiHeader();
        data.set被保険者番号(get被保険者番号(給付実績ヘッダ情報1.get被保険者番号()));
        if (給付実績ヘッダ情報1.get認定年月日() != null && !給付実績ヘッダ情報1.get認定年月日().isEmpty()
                && !RString.isNullOrEmpty(給付実績ヘッダ情報1.get要介護認定状態区分コード())) {
            data.set要介護度(YokaigoJotaiKubunSupport.toValue(
                    給付実績ヘッダ情報1.get認定年月日().getYearMonth(), 給付実績ヘッダ情報1.get要介護認定状態区分コード()).getName());
        }
        if (給付実績ヘッダ情報1.get認定有効期間開始年月日() != null && !給付実績ヘッダ情報1.get認定有効期間開始年月日().isEmpty()) {
            data.set有効期間開始年月日(new RDate(給付実績ヘッダ情報1.get認定有効期間開始年月日().toString()));
        }
        if (給付実績ヘッダ情報1.get認定有効期間終了年月日() != null && !給付実績ヘッダ情報1.get認定有効期間終了年月日().isEmpty()) {
            data.set有効期間終了年月日(new RDate(給付実績ヘッダ情報1.get認定有効期間終了年月日().toString()));
        }
        data.set氏名(給付実績ヘッダ情報1.get名称());
        data.set性別(get性別(給付実績ヘッダ情報1.get性別コード()));
        if (給付実績ヘッダ情報1.get生年月日() != null && 給付実績ヘッダ情報1.get生年月日().isWareki()) {
            data.set生年月日(new RDate(給付実績ヘッダ情報1.get生年月日().toString()));
        }
        data.set住民種別(給付実績ヘッダ情報1.get住民種別());
        return data;
    }

    /**
     * 「＜＜」ボタンを押下する場合、画面を表示します。
     *
     * @param サービス提供年月_開始 サービス提供年月_開始
     * @param サービス提供年月_終了 サービス提供年月_終了
     * @param 一覧データ 一覧データ
     */
    public void onClick_btnSento(FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了,
            KyufuJissekiSearchDataBusiness 一覧データ) {
        int 列 = サービス提供年月_終了.getBetweenMonths(サービス提供年月_開始) + INT_ICHI;
        FlexibleYearMonth 計算後サービス提供年月_開始 = サービス提供年月_開始.plusMonth(列 - INT_SJYUR);
        set明細一覧列(計算後サービス提供年月_開始, サービス提供年月_終了);
        setボタン活性非活性の設定();
        set一覧設定(一覧データ);
    }

    /**
     * 「＜」ボタンを押下する場合、画面を表示します。
     *
     * @param 一覧データ 一覧データ
     */
    public void onClick_btnMae(KyufuJissekiSearchDataBusiness 一覧データ) {
        FlexibleYearMonth 計算後サービス提供年月_終了 = get前列日期().plusMonth(INT_ICHI);
        FlexibleYearMonth 計算後サービス提供年月_開始 = get後列日期().plusMonth(INT_ICHI);
        set明細一覧列(計算後サービス提供年月_開始, 計算後サービス提供年月_終了);
        setボタン活性非活性の設定();
        set一覧設定(一覧データ);
    }

    /**
     * 「＞」ボタンを押下する場合、画面を表示します。
     *
     * @param 一覧データ 一覧データ
     */
    public void onClick_btnTsugi(KyufuJissekiSearchDataBusiness 一覧データ) {
        FlexibleYearMonth 計算後サービス提供年月_終了 = get前列日期().minusMonth(INT_ICHI);
        FlexibleYearMonth 計算後サービス提供年月_開始 = get後列日期().minusMonth(INT_ICHI);
        set明細一覧列(計算後サービス提供年月_開始, 計算後サービス提供年月_終了);
        setボタン活性非活性の設定();
        set一覧設定(一覧データ);
    }

    /**
     * 「＞＞」ボタンを押下する場合、画面を表示します。
     *
     * @param サービス提供年月_開始 サービス提供年月_開始
     * @param サービス提供年月_終了 サービス提供年月_終了
     * @param 一覧データ 一覧データ
     */
    public void onClick_btnSaigo(FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了,
            KyufuJissekiSearchDataBusiness 一覧データ) {
        int 列 = サービス提供年月_終了.getBetweenMonths(サービス提供年月_開始) + INT_ICHI;
        FlexibleYearMonth 計算後サービス提供年月_終了 = サービス提供年月_終了.minusMonth(列 - INT_SJYUR);
        set明細一覧列(サービス提供年月_開始, 計算後サービス提供年月_終了);
        setボタン活性非活性の設定();
        set一覧設定(一覧データ);
    }

    private List<KeyValueDataSource> get年度() {
        RDate システム日付 = RDate.getNowDate();
        List<KeyValueDataSource> keyValue = new ArrayList<>();
        for (int 年度 = 年度始; 年度 <= システム日付.getYearValue(); 年度++) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(new RString(年度));
            dataSource.setValue(new RDate(年度).wareki().getYear());
            keyValue.add(dataSource);
        }
        Collections.sort(keyValue, new DateComparator());
        return keyValue;
    }

    private void set明細一覧行() {
        RString 検索対象 = div.getRadTaisho1().getSelectedKey();
        List<dgKyufuJissekiMeisaiList_Row> 種類明細一覧 = get明細空白一覧(検索対象);
        for (int i = 0; i < 種類明細一覧.size(); i++) {
            set明細一覧固定項目(i, 種類明細一覧.get(i), 検索対象);
        }
        List<dgKyufuJissekiMeisaiList_Row> 合計一覧 = get合計空白一覧(検索対象);
        for (int i = 0; i < 合計一覧.size(); i++) {
            set合計一覧固定項目(i, 合計一覧.get(i), 検索対象);
        }
        種類明細一覧.addAll(合計一覧);
        div.getDgKyufuJissekiMeisaiList().setDataSource(種類明細一覧);
    }

    private void set明細一覧列(FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了) {
        set一覧表示();
        int 列数 = サービス提供年月_終了.getBetweenMonths(サービス提供年月_開始) + INT_ICHI;
        if (列数 <= INT_SJYUR) {
            for (int i = INT_SAN; i < (列数 * INT_NI + INT_SAN); i++) {
                set列名の設定(i, サービス提供年月_開始, サービス提供年月_終了);
            }
            for (int i = (列数 * INT_NI + INT_SAN); i < INT_NJYUNG; i++) {
                div.getDgKyufuJissekiMeisaiList().getGridSetting().getColumns().get(i).setVisible(false);
            }
        } else {
            FlexibleYearMonth 計算後サービス提供年月_開始 = サービス提供年月_開始.plusMonth(列数 - INT_SJYUR);
            for (int i = INT_SAN; i < INT_NJYUNG; i++) {
                set列名の設定(i, 計算後サービス提供年月_開始, サービス提供年月_終了);
            }
        }
    }

    private void set一覧表示() {
        for (int i = INT_ZERO; i < INT_NJYUNG; i++) {
            div.getDgKyufuJissekiMeisaiList().getGridSetting().getColumns().get(i).setVisible(true);
        }
    }

    private RString get被保険者番号(HihokenshaNo 被保険者番号) {
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            return 被保険者番号.value();
        }
        return RString.EMPTY;
    }

    private RString get性別(RString 性別コード) {
        if (!RString.isNullOrEmpty(性別コード)) {
            return Seibetsu.toValue(性別コード).get名称();
        }
        return RString.EMPTY;
    }

    private List<dgKyufuJissekiMeisaiList_Row> get明細空白一覧(RString 検索対象) {
        List<dgKyufuJissekiMeisaiList_Row> rowList = new ArrayList<>();
        if (KEY.equals(検索対象)) {
            for (int i = 1; i < INT_YJYUH; i++) {
                dgKyufuJissekiMeisaiList_Row row = new dgKyufuJissekiMeisaiList_Row();
                rowList.add(row);
            }
        } else {
            for (int i = 1; i < INT_NJYUN; i++) {
                dgKyufuJissekiMeisaiList_Row row = new dgKyufuJissekiMeisaiList_Row();
                rowList.add(row);
            }
        }
        return rowList;
    }

    private List<dgKyufuJissekiMeisaiList_Row> get合計空白一覧(RString 検索対象) {
        List<dgKyufuJissekiMeisaiList_Row> rowList = new ArrayList<>();
        if (KEY.equals(検索対象)) {
            for (int i = 1; i < INT_JYUN; i++) {
                dgKyufuJissekiMeisaiList_Row row = new dgKyufuJissekiMeisaiList_Row();
                rowList.add(row);
            }
        } else {
            for (int i = 1; i < INT_ROKU; i++) {
                dgKyufuJissekiMeisaiList_Row row = new dgKyufuJissekiMeisaiList_Row();
                rowList.add(row);
            }
        }
        return rowList;
    }

    private void set明細一覧固定項目(int 一覧行数, dgKyufuJissekiMeisaiList_Row 明細一覧, RString 検索対象) {
        switch (一覧行数) {
            case INT_ZERO:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(指定居宅サービス);
                    明細一覧.setTxtServiceGroup2(訪問通所);
                    明細一覧.setTxtServiceShurui(new RString("訪問介護"));
                    明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                } else {
                    明細一覧.setTxtServiceGroup1(介護予防日常生活支援総合事業);
                    明細一覧.setTxtServiceGroup2(訪問通所);
                    明細一覧.setTxtServiceShurui(new RString("総合訪問型予防サービス"));
                    明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                }
                break;
            case INT_ICHI:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("訪問入浴"));
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("総合訪問入浴介護"));
                }
                明細一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_NI:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("訪問看護"));
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("総合訪問看護"));
                }
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_SAN:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("訪問リハビリ"));
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("総合訪問リハビリテーション"));
                }
                明細一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            default:
                set明細一覧項目１(一覧行数, 明細一覧, 検索対象);
                break;
        }
    }

    private void set明細一覧項目１(int 一覧行数, dgKyufuJissekiMeisaiList_Row 明細一覧, RString 検索対象) {
        switch (一覧行数) {
            case INT_YON:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("通所介護"));
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("総合通所型予防サービス"));
                }
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_GO:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("通所リハビリ"));
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("総合通所リハビリテーション"));
                }
                明細一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_ROKU:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("福祉用具貸与"));
                    明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("総合福祉用具貸与"));
                }
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_NANA:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(短期入所);
                    明細一覧.setTxtServiceShurui(new RString("生活介護"));
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(短期入所);
                    明細一覧.setTxtServiceShurui(new RString("総合短期入所生活介護"));
                }
                明細一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            default:
                set明細一覧固定項目１(一覧行数, 明細一覧, 検索対象);
                break;
        }
    }

    private void set明細一覧固定項目１(int 一覧行数, dgKyufuJissekiMeisaiList_Row 明細一覧, RString 検索対象) {
        switch (一覧行数) {
            case INT_HACHI:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("療養介護（老人保険施設）"));
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("総合短期入所療養介護(老健)"));
                }
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_KYU:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("療養介護（療養型医療施設等）"));
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("総合短期入所療養介護(医療)"));
                }
                明細一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_JYU:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("出来高請求額"));
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_JYUI:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("居宅療養管理指導"));
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("総合居宅療養管理指導"));
                }
                明細一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            default:
                set明細一覧項目２(一覧行数, 明細一覧, 検索対象);
                break;
        }
    }

    private void set明細一覧項目２(int 一覧行数, dgKyufuJissekiMeisaiList_Row 明細一覧, RString 検索対象) {
        switch (一覧行数) {
            case INT_JYUN:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("特定施設入所者生活介護（短期以外）"));
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("総合特定施設入居者生活介護"));
                }
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_JYUS:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("特定施設入所者生活介護（短期）"));
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(地域密着);
                    明細一覧.setTxtServiceShurui(new RString("総合認知症型共同生活介護"));
                }
                明細一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_JYUY:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(地域密着);
                    明細一覧.setTxtServiceShurui(new RString("認知症対応型共同生活介護"));
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("総合認知症型共同生活(短期)"));
                }
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                break;
            default:
                set明細一覧固定項目２(一覧行数, 明細一覧, 検索対象);
                break;
        }
    }

    private void set明細一覧固定項目２(int 一覧行数, dgKyufuJissekiMeisaiList_Row 明細一覧, RString 検索対象) {
        switch (一覧行数) {
            case INT_JYUG:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("地域密着型特定施設入所者生活介護(短期以外)"));
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("総合認知症対応型通所介護"));
                }
                明細一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_JYUR:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("地域密着型特定施設入所者生活介護(短期)"));
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("総合小規模多機能型居宅介護"));
                }
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_JYUNA:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("認知症対応型共同生活(短期)"));
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("ケアマネジメント"));
                }
                明細一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_JYUH:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("夜間対応型訪問介護"));
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(生活支援);
                    明細一覧.setTxtServiceShurui(new RString("生活支援サービス(配食)"));
                }
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_JYUK:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("認知症対応型通所介護"));
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("生活支援サービス(見守り)"));
                }
                明細一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_NJYU:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("小規模多機能型居宅介護（短期以外）"));
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("生活支援サービス(その他)"));
                }
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                break;
            default:
                set明細一覧固定項目３(一覧行数, 明細一覧);
                break;
        }
    }

    private void set明細一覧固定項目３(int 一覧行数, dgKyufuJissekiMeisaiList_Row 明細一覧) {
        switch (一覧行数) {
            case INT_NJYUI:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("小規模多機能型居宅介護（短期）"));
                明細一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_NJYUN:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("定期巡回・随時対応型訪問介護看護"));
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_NJYUS:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("複合型（看護小規模多機能型居宅介護・短期以外）"));
                明細一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_NJYUY:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("複合型（看護小規模多機能型居宅介護・短期）"));
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                break;
            default:
                set明細一覧固定項目４(一覧行数, 明細一覧);
                break;
        }
    }

    private void set明細一覧固定項目４(int 一覧行数, dgKyufuJissekiMeisaiList_Row 明細一覧) {
        switch (一覧行数) {
            case INT_NJYUG:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("地域密着型通所介護"));
                明細一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_NJYUR:
                明細一覧.setTxtServiceGroup1(居宅介護);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("居宅介護支援"));
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_NJYUNA:
                明細一覧.setTxtServiceGroup1(指定施設サービス等);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("介護福祉施設サービス"));
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_NJYUH:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("介護保健施設サービス"));
                明細一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_NJYUK:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("介護療養施設サービス"));
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_SJYU:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(地域密着);
                明細一覧.setTxtServiceShurui(new RString("地域密着型介護老人福祉施設"));
                明細一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_SJYUI:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("出来高請求額"));
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_SJYUN:
                明細一覧.setTxtServiceGroup1(介護予防_日常生活支援総合事業);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("訪問型サービス（みなし）"));
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightYellow);
                break;
            default:
                set明細一覧固定項目５(一覧行数, 明細一覧);
                break;
        }
    }

    private void set明細一覧固定項目５(int 一覧行数, dgKyufuJissekiMeisaiList_Row 明細一覧) {
        switch (一覧行数) {
            case INT_SJYUS:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("訪問型サービス（独自）"));
                明細一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightYellow);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_SJYUY:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("訪問型サービス（独自／定率）"));
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_SJYUG:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("訪問型サービス（独自／定額）"));
                明細一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightYellow);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_SJYUR:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("通所型サービス（みなし）"));
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_SJYUNA:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("通所型サービス（独自）"));
                明細一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightYellow);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_SJYUH:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("通所型サービス（独自／定率）"));
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_SJYUK:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("通所型サービス（独自／定額）"));
                明細一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightYellow);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_YJYU:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("介護予防ケアマネジメント"));
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_YJYUI:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("その他の生活支援（配食／定率）"));
                明細一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightYellow);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_YJYUN:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("その他の生活支援（配食／定額）"));
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_YJYUS:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("その他の生活支援（見守り／定率）"));
                明細一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightYellow);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_YJYUY:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("その他の生活支援（見守り／定額）"));
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_YJYUG:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("その他の生活支援（その他／定率）"));
                明細一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightYellow);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_YJYUR:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("その他の生活支援（その他／定額）"));
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightYellow);
                break;
            default:
                break;
        }
    }

    private void set合計一覧固定項目(int 一覧行数,
            dgKyufuJissekiMeisaiList_Row 合計一覧, RString 検索対象) {
        if (KEY.equals(検索対象)) {
            合計一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
            合計一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
        } else {
            合計一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightYellow);
            合計一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightYellow);
        }
        switch (一覧行数) {
            case INT_ZERO:
                if (KEY.equals(検索対象)) {
                    合計一覧.setTxtServiceGroup1(new RString("合計"));
                    合計一覧.setTxtServiceGroup2(RString.EMPTY);
                    合計一覧.setTxtServiceShurui(居宅サービス合計単位);
                    合計一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                } else {
                    合計一覧.setTxtServiceGroup1(RString.EMPTY);
                    合計一覧.setTxtServiceGroup2(RString.EMPTY);
                    合計一覧.setTxtServiceShurui(居宅サービス合計単位);
                    合計一覧.setRowBgColor(DataGridCellBgColor.bgColorLightYellow);
                }
                break;
            case INT_ICHI:
                if (KEY.equals(検索対象)) {
                    合計一覧.setTxtServiceGroup1(RString.EMPTY);
                    合計一覧.setTxtServiceGroup2(RString.EMPTY);
                    合計一覧.setTxtServiceShurui(new RString("施設サービス合計単位"));
                } else {
                    合計一覧.setTxtServiceGroup1(RString.EMPTY);
                    合計一覧.setTxtServiceGroup2(RString.EMPTY);
                    合計一覧.setTxtServiceShurui(地域密着型サービス合計単位);
                }
                break;
            case INT_NI:
                if (KEY.equals(検索対象)) {
                    合計一覧.setTxtServiceGroup1(RString.EMPTY);
                    合計一覧.setTxtServiceGroup2(RString.EMPTY);
                    合計一覧.setTxtServiceShurui(地域密着型サービス合計単位);
                    合計一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                } else {
                    合計一覧.setTxtServiceGroup1(RString.EMPTY);
                    合計一覧.setTxtServiceGroup2(RString.EMPTY);
                    合計一覧.setTxtServiceShurui(new RString("生活支援サービス合計単位"));
                    合計一覧.setRowBgColor(DataGridCellBgColor.bgColorLightYellow);
                }
                break;
            case INT_SAN:
                if (KEY.equals(検索対象)) {
                    合計一覧.setTxtServiceGroup1(RString.EMPTY);
                    合計一覧.setTxtServiceGroup2(RString.EMPTY);
                    合計一覧.setTxtServiceShurui(new RString("総合事業合計単位"));
                } else {
                    合計一覧.setTxtServiceGroup1(RString.EMPTY);
                    合計一覧.setTxtServiceGroup2(RString.EMPTY);
                    合計一覧.setTxtServiceShurui(給付費合計);
                }
                break;
            case INT_YON:
                if (KEY.equals(検索対象)) {
                    合計一覧.setTxtServiceGroup1(RString.EMPTY);
                    合計一覧.setTxtServiceGroup2(RString.EMPTY);
                    合計一覧.setTxtServiceShurui(給付費合計);
                    合計一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                } else {
                    合計一覧.setTxtServiceGroup1(RString.EMPTY);
                    合計一覧.setTxtServiceGroup2(RString.EMPTY);
                    合計一覧.setTxtServiceShurui(利用者負担合計);
                    合計一覧.setRowBgColor(DataGridCellBgColor.bgColorLightYellow);
                }
                break;
            case INT_GO:
                合計一覧.setTxtServiceGroup1(RString.EMPTY);
                合計一覧.setTxtServiceGroup2(RString.EMPTY);
                合計一覧.setTxtServiceShurui(new RString("給付費合計（総合事業）"));
                break;
            case INT_ROKU:
                合計一覧.setTxtServiceGroup1(RString.EMPTY);
                合計一覧.setTxtServiceGroup2(RString.EMPTY);
                合計一覧.setTxtServiceShurui(利用者負担合計);
                合計一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_NANA:
                合計一覧.setTxtServiceGroup1(RString.EMPTY);
                合計一覧.setTxtServiceGroup2(RString.EMPTY);
                合計一覧.setTxtServiceShurui(new RString("利用者負担合計（総合事業）"));
                break;
            case INT_HACHI:
                合計一覧.setTxtServiceGroup1(RString.EMPTY);
                合計一覧.setTxtServiceGroup2(RString.EMPTY);
                合計一覧.setTxtServiceShurui(new RString("高額介護費"));
                合計一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_KYU:
                合計一覧.setTxtServiceGroup1(RString.EMPTY);
                合計一覧.setTxtServiceGroup2(RString.EMPTY);
                合計一覧.setTxtServiceShurui(new RString("福祉用具販売"));
                break;
            case INT_JYU:
                合計一覧.setTxtServiceGroup1(RString.EMPTY);
                合計一覧.setTxtServiceGroup2(RString.EMPTY);
                合計一覧.setTxtServiceShurui(new RString("住宅改修"));
                合計一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                break;
            default:
                break;
        }
    }

    private List<RString> get年度列名(FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了) {
        List<RString> 計算後年 = new ArrayList<>();
        int 列 = サービス提供年月_終了.getBetweenMonths(サービス提供年月_開始) + INT_ICHI;
        FlexibleYearMonth 計算後年月 = サービス提供年月_終了.plusMonth(INT_ICHI);
        for (int i = 0; i < 列; i++) {
            計算後年月 = 計算後年月.minusMonth(INT_ICHI);
            計算後年.add(計算後年月.wareki().toDateString());
        }
        return 計算後年;
    }

    private void setボタン表示非表示の設定(FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了) {
        div.getBtnSento().setVisible(true);
        div.getBtnMae().setVisible(true);
        div.getBtnTsugi().setVisible(true);
        div.getBtnSaigo().setVisible(true);
        int 列 = サービス提供年月_終了.getBetweenMonths(サービス提供年月_開始) + INT_ICHI;
        if (列 < INT_SJYUNA) {
            div.getBtnSento().setVisible(false);
            div.getBtnMae().setVisible(false);
            div.getBtnTsugi().setVisible(false);
            div.getBtnSaigo().setVisible(false);
        }
    }

    private void setボタン活性非活性の設定() {
        if (div.getBtnSento().isVisible()) {
            FlexibleYearMonth サービス提供年月_開始
                    = new FlexibleYearMonth(div.getHiddenStartYM());
            FlexibleYearMonth サービス提供年月_終了
                    = new FlexibleYearMonth(div.getHiddenEndYM());
            div.getBtnSento().setDisabled(true);
            div.getBtnMae().setDisabled(true);
            div.getBtnTsugi().setDisabled(true);
            div.getBtnSaigo().setDisabled(true);
            if (サービス提供年月_終了.equals(get前列日期())) {
                div.getBtnTsugi().setDisabled(false);
                div.getBtnSaigo().setDisabled(false);
            } else if (サービス提供年月_開始.equals(get後列日期())) {
                div.getBtnSento().setDisabled(false);
                div.getBtnMae().setDisabled(false);
            } else {
                div.getBtnSento().setDisabled(false);
                div.getBtnMae().setDisabled(false);
                div.getBtnTsugi().setDisabled(false);
                div.getBtnSaigo().setDisabled(false);
            }
        }
    }

    private void set列名の設定(int 列, FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了) {
        if (INT_ZERO < 列 && 列 % INT_NI != INT_ZERO) {
            RString 列名 = get年度列名(サービス提供年月_開始, サービス提供年月_終了).get(列 / INT_NI - INT_ICHI);
            div.getDgKyufuJissekiMeisaiList().getGridSetting().getColumns().get(列).setGroupName(列名);
            div.getDgKyufuJissekiMeisaiList().getGridSetting().getColumns().get(列 + 1).setGroupName(列名);
        }
    }

    private FlexibleYearMonth get前列日期() {
        RString 列日期 = div.getDgKyufuJissekiMeisaiList().getGridSetting().getColumns().get(INT_SAN).getGroupName();
        return new FlexibleYearMonth(new RDate(列日期.toString()).getYearMonth().toDateString());
    }

    private FlexibleYearMonth get後列日期() {
        RString 列日期 = div.getDgKyufuJissekiMeisaiList().getGridSetting().getColumns().get(INT_NJYUNG - INT_ICHI).getGroupName();
        return new FlexibleYearMonth(new RDate(列日期.toString()).getYearMonth().toDateString());
    }

    private RString getデータフォマート(Decimal 項目データ) {
        return DecimalFormatter.toコンマ区切りRString(項目データ, INT_ZERO);
    }

    private static class DateComparator implements Comparator<KeyValueDataSource>, Serializable {

        @Override
        public int compare(KeyValueDataSource o1, KeyValueDataSource o2) {
            return o2.getKey().compareTo(o1.getKey());
        }
    }

    /**
     * 集計データを取得する。
     *
     * @param サービス提供年月_開始 サービス提供年月_開始
     * @param サービス提供年月_終了 サービス提供年月_終了
     * @param is経過措置 is経過措置
     * @param 給付実績情報照会情報 給付実績情報照会情報
     * @param 被保険者番号 被保険者番号
     */
    public void edit集計データ(FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了,
            boolean is経過措置, KyufuJissekiPrmBusiness 給付実績情報照会情報, HihokenshaNo 被保険者番号) {
        List<KyufuJissekiShukeiKekkaDataBusiness> 集計データ
                = KyufuJissekiShokaiFinder.createInstance().get集計データ(is経過措置, サービス提供年月_開始, サービス提供年月_終了, 被保険者番号);
        List<KyufuJissekiShukeiKekka> 集計結果List;
        if (is経過措置) {
            集計結果List = edit集計結果_経過措置(集計データ, サービス提供年月_開始, サービス提供年月_終了);
        } else {
            集計結果List = edit集計結果(集計データ, サービス提供年月_開始, サービス提供年月_終了);
        }
        給付実績情報照会情報.getSearchData().set給付実績集計結果明細データ(集計結果List);
    }

    private List<KyufuJissekiShukeiKekka> edit集計結果_経過措置(List<KyufuJissekiShukeiKekkaDataBusiness> 集計データ,
            FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了) {
        List<KyufuJissekiShukeiKekka> 集計結果List = new ArrayList<>();
        FlexibleYearMonth 処理対象年月 = new FlexibleYearMonth(サービス提供年月_終了.toDateString());
        int index = 0;
        while (処理対象年月.isBeforeOrEquals(サービス提供年月_終了) && サービス提供年月_開始.isBeforeOrEquals(処理対象年月)) {
            List<KyufuJissekiShukeiKekka> 処理対象年月集計結果List = 初期化処理対象年月集計結果List(処理対象年月, true);
            while (集計データ.size() > index && 処理対象年月.equals(集計データ.get(index).getServiceTeikyoYM())) {
                KyufuJissekiShukeiKekkaDataBusiness 処理対象集計データ = 集計データ.get(index);
                for (int i = 0; i < INT_NJYUI; i++) {
                    if (isServiceShuruiCodeNullOrEmpty(処理対象集計データ.getServiceSyuruiCode())) {
                        break;
                    }
                    if (chk単位数加算対象_経過措置(i, serviceSyuruiCodeToServiceCategoryShurui(処理対象集計データ.getServiceSyuruiCode()))) {
                        処理対象年月集計結果List.get(i).setKensu(
                                処理対象年月集計結果List.get(i).getKensu().add(Decimal.ONE));
                        処理対象年月集計結果List.get(i).setKingaku(
                                処理対象年月集計結果List.get(i).getKingaku().add(nullToZero(処理対象集計データ.getTanisu())));
                    }
                    if (chk出来高単位数加算対象_経過措置(i, serviceSyuruiCodeToServiceCategoryShurui(処理対象集計データ.getServiceSyuruiCode()))) {
                        処理対象年月集計結果List.get(i).setKensu(
                                処理対象年月集計結果List.get(i).getKensu().add(Decimal.ONE));
                        処理対象年月集計結果List.get(i).setKingaku(
                                処理対象年月集計結果List.get(i).getKingaku().add(nullToZero(処理対象集計データ.getDekidakaTanisu())));
                    }
                }
                RString パターン番号
                        = get合計パターン番号_経過措置(serviceSyuruiCodeToServiceCategoryShurui(処理対象集計データ.getServiceSyuruiCode()));
                edit合計一覧用集計結果_経過措置(パターン番号, 処理対象年月集計結果List, 処理対象集計データ);
                index++;
            }
            集計結果List.addAll(処理対象年月集計結果List);
            処理対象年月 = new FlexibleYearMonth(処理対象年月.minusMonth(1).toDateString());
        }
        return 集計結果List;
    }

    private void edit合計一覧用集計結果_経過措置(RString パターン番号,
            List<KyufuJissekiShukeiKekka> 処理対象年月集計結果List,
            KyufuJissekiShukeiKekkaDataBusiness 処理対象集計データ) {
        if (GOKEI_PATTERN1_1.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_NJYUI), 処理対象集計データ.getTanisu());
            金額単位数加算(処理対象年月集計結果List.get(INT_NJYUY), 処理対象集計データ.getSeikyugaku());
            金額単位数加算(処理対象年月集計結果List.get(INT_NJYUG), 処理対象集計データ.getRiyoshaFutangaku());
        } else if (GOKEI_PATTERN1_2.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_NJYUI),
                    nullToZero(処理対象集計データ.getTanisu()).add(nullToZero(処理対象集計データ.getDekidakaTanisu())));
            金額単位数加算(処理対象年月集計結果List.get(INT_NJYUY), 処理対象集計データ.getSeikyugaku());
            金額単位数加算(処理対象年月集計結果List.get(INT_NJYUG), 処理対象集計データ.getRiyoshaFutangaku());
        } else if (GOKEI_PATTERN3.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_NJYUN), 処理対象集計データ.getTanisu());
            金額単位数加算(処理対象年月集計結果List.get(INT_NJYUY), 処理対象集計データ.getSeikyugaku());
            金額単位数加算(処理対象年月集計結果List.get(INT_NJYUG), 処理対象集計データ.getRiyoshaFutangaku());
        } else if (GOKEI_PATTERN4.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_NJYUS), 処理対象集計データ.getTanisu());
            金額単位数加算(処理対象年月集計結果List.get(INT_NJYUY), 処理対象集計データ.getSeikyugaku());
            金額単位数加算(処理対象年月集計結果List.get(INT_NJYUG), 処理対象集計データ.getRiyoshaFutangaku());
        }
    }

    private List<KyufuJissekiShukeiKekka> edit集計結果(List<KyufuJissekiShukeiKekkaDataBusiness> 集計データ,
            FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了) {
        List<KyufuJissekiShukeiKekka> 集計結果List = new ArrayList<>();
        FlexibleYearMonth 処理対象年月 = new FlexibleYearMonth(サービス提供年月_終了.toDateString());
        int index = 0;
        while (処理対象年月.isBeforeOrEquals(サービス提供年月_終了) && サービス提供年月_開始.isBeforeOrEquals(処理対象年月)) {
            List<KyufuJissekiShukeiKekka> 処理対象年月集計結果List = 初期化処理対象年月集計結果List(処理対象年月, false);
            while (集計データ.size() > index && 処理対象年月.equals(集計データ.get(index).getServiceTeikyoYM())) {
                KyufuJissekiShukeiKekkaDataBusiness 処理対象集計データ = 集計データ.get(index);
                for (int i = 0; i < INT_47; i++) {
                    if (isServiceShuruiCodeNullOrEmpty(処理対象集計データ.getServiceSyuruiCode())) {
                        break;
                    }
                    if (chk単位数加算対象(i, serviceSyuruiCodeToServiceCategoryShurui(処理対象集計データ.getServiceSyuruiCode()))) {
                        処理対象年月集計結果List.get(i).setKensu(
                                処理対象年月集計結果List.get(i).getKensu().add(Decimal.ONE));
                        処理対象年月集計結果List.get(i).setKingaku(
                                処理対象年月集計結果List.get(i).getKingaku().add(nullToZero(処理対象集計データ.getTanisu())));
                    }
                    if (chk出来高単位数加算対象(i, serviceSyuruiCodeToServiceCategoryShurui(処理対象集計データ.getServiceSyuruiCode()))) {
                        処理対象年月集計結果List.get(i).setKensu(
                                処理対象年月集計結果List.get(i).getKensu().add(Decimal.ONE));
                        処理対象年月集計結果List.get(i).setKingaku(
                                処理対象年月集計結果List.get(i).getKingaku().add(nullToZero(処理対象集計データ.getDekidakaTanisu())));
                    }
                }
                RString パターン番号;
                if (isServiceShuruiCodeNullOrEmpty(処理対象集計データ.getServiceSyuruiCode())) {
                    パターン番号 = GOKEI_PATTERN5;
                } else {
                    パターン番号 = get合計パターン番号(serviceSyuruiCodeToServiceCategoryShurui(処理対象集計データ.getServiceSyuruiCode()));
                }
                edit合計一覧用集計結果(パターン番号, 処理対象年月集計結果List, 処理対象集計データ);
                index++;
            }
            集計結果List.addAll(処理対象年月集計結果List);
            処理対象年月 = new FlexibleYearMonth(処理対象年月.minusMonth(1).toDateString());
        }
        return 集計結果List;
    }

    private void edit合計一覧用集計結果(RString パターン番号,
            List<KyufuJissekiShukeiKekka> 処理対象年月集計結果List,
            KyufuJissekiShukeiKekkaDataBusiness 処理対象集計データ) {
        if (GOKEI_PATTERN1_1.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_47), 処理対象集計データ.getTanisu());
            金額単位数加算(処理対象年月集計結果List.get(INT_51), 処理対象集計データ.getSeikyugaku());
            金額単位数加算(処理対象年月集計結果List.get(INT_53), 処理対象集計データ.getRiyoshaFutangaku());
        } else if (GOKEI_PATTERN1_2.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_47),
                    nullToZero(処理対象集計データ.getTanisu()).add(nullToZero(処理対象集計データ.getDekidakaTanisu())));
            金額単位数加算(処理対象年月集計結果List.get(INT_51), 処理対象集計データ.getSeikyugaku());
            金額単位数加算(処理対象年月集計結果List.get(INT_53), 処理対象集計データ.getRiyoshaFutangaku());
        } else if (GOKEI_PATTERN2_1.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_YJYUH), 処理対象集計データ.getTanisu());
            金額単位数加算(処理対象年月集計結果List.get(INT_51), 処理対象集計データ.getSeikyugaku());
            金額単位数加算(処理対象年月集計結果List.get(INT_53), 処理対象集計データ.getRiyoshaFutangaku());
        } else if (GOKEI_PATTERN2_2.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_YJYUH),
                    nullToZero(処理対象集計データ.getTanisu()).add(nullToZero(処理対象集計データ.getDekidakaTanisu())));
            金額単位数加算(処理対象年月集計結果List.get(INT_51), 処理対象集計データ.getSeikyugaku());
            金額単位数加算(処理対象年月集計結果List.get(INT_53), 処理対象集計データ.getRiyoshaFutangaku());
        } else if (GOKEI_PATTERN3.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_49),
                    nullToZero(処理対象集計データ.getTanisu()).add(nullToZero(処理対象集計データ.getDekidakaTanisu())));
            金額単位数加算(処理対象年月集計結果List.get(INT_51), 処理対象集計データ.getSeikyugaku());
            金額単位数加算(処理対象年月集計結果List.get(INT_53), 処理対象集計データ.getRiyoshaFutangaku());
        } else if (GOKEI_PATTERN4.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_50),
                    nullToZero(処理対象集計データ.getTanisu()).add(nullToZero(処理対象集計データ.getDekidakaTanisu())));
            金額単位数加算(処理対象年月集計結果List.get(INT_52), 処理対象集計データ.getSeikyugaku());
            金額単位数加算(処理対象年月集計結果List.get(INT_54), 処理対象集計データ.getRiyoshaFutangaku());
        } else if (GOKEI_PATTERN5.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_55), 処理対象集計データ.getSeikyugaku());
        } else if (GOKEI_PATTERN6_1.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_56), 処理対象集計データ.getSeikyugaku());
        } else if (GOKEI_PATTERN6_2.equals(パターン番号)) {
            金額単位数加算(処理対象年月集計結果List.get(INT_57), 処理対象集計データ.getSeikyugaku());
        }
    }

    private void 金額単位数加算(KyufuJissekiShukeiKekka 集計結果, Decimal 金額) {
        集計結果.setKensu(集計結果.getKensu().add(Decimal.ONE));
        集計結果.setKingaku(集計結果.getKingaku().add(nullToZero(金額)));
    }

    private Decimal nullToZero(Decimal value) {
        if (null == value) {
            return Decimal.ZERO;
        }
        return value;
    }

    private boolean isServiceShuruiCodeNullOrEmpty(ServiceShuruiCode code) {
        return null == code || code.isEmpty();
    }

    private ServiceCategoryShurui serviceSyuruiCodeToServiceCategoryShurui(ServiceShuruiCode code) {
        return ServiceCategoryShurui.toValue(code.getColumnValue());
    }

    private List<KyufuJissekiShukeiKekka> 初期化処理対象年月集計結果List(FlexibleYearMonth 処理対象年月, boolean is経過措置) {
        int count = INT_58;
        if (is経過措置) {
            count = INT_NJYUR;
        }
        List<KyufuJissekiShukeiKekka> 処理対象年月集計結果List = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            処理対象年月集計結果List.add(初期化集計結果(処理対象年月));
        }
        return 処理対象年月集計結果List;
    }

    private KyufuJissekiShukeiKekka 初期化集計結果(FlexibleYearMonth 処理対象年月) {
        KyufuJissekiShukeiKekka 集計結果 = new KyufuJissekiShukeiKekka();
        集計結果.setServiceTeikyoYM(処理対象年月);
        集計結果.setKensu(Decimal.ZERO);
        集計結果.setKingaku(Decimal.ZERO);
        return 集計結果;
    }

    private boolean chk単位数加算対象9(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_YJYUN:
                switch (サービス種類) {
                    case 配食定額:
                        return true;
                    default:
                        return false;
                }
            case INT_YJYUS:
                switch (サービス種類) {
                    case 見守定率:
                        return true;
                    default:
                        return false;
                }
            case INT_YJYUY:
                switch (サービス種類) {
                    case 見守定額:
                        return true;
                    default:
                        return false;
                }
            case INT_YJYUG:
                switch (サービス種類) {
                    case その他率:
                        return true;
                    default:
                        return false;
                }
            case INT_YJYUR:
                switch (サービス種類) {
                    case その他額:
                        return true;
                    default:
                        return false;
                }
            default:
                return false;
        }
    }

    private boolean chk単位数加算対象8(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_SJYUNA:
                switch (サービス種類) {
                    case 通所独自:
                        return true;
                    default:
                        return false;
                }
            case INT_SJYUH:
                switch (サービス種類) {
                    case 通所定率:
                        return true;
                    default:
                        return false;
                }
            case INT_SJYUK:
                switch (サービス種類) {
                    case 通所定額:
                        return true;
                    default:
                        return false;
                }
            case INT_YJYU:
                switch (サービス種類) {
                    case 予防ケア:
                        return true;
                    default:
                        return false;
                }
            case INT_YJYUI:
                switch (サービス種類) {
                    case 配食定率:
                        return true;
                    default:
                        return false;
                }
            default:
                return chk単位数加算対象9(i, サービス種類);
        }
    }

    private boolean chk単位数加算対象7(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_SJYUN:
                switch (サービス種類) {
                    case 訪問みな:
                        return true;
                    default:
                        return false;
                }
            case INT_SJYUS:
                switch (サービス種類) {
                    case 訪問独自:
                        return true;
                    default:
                        return false;
                }
            case INT_SJYUY:
                switch (サービス種類) {
                    case 訪問定率:
                        return true;
                    default:
                        return false;
                }
            case INT_SJYUG:
                switch (サービス種類) {
                    case 訪問定額:
                        return true;
                    default:
                        return false;
                }
            case INT_SJYUR:
                switch (サービス種類) {
                    case 通所みな:
                        return true;
                    default:
                        return false;
                }
            default:
                return chk単位数加算対象8(i, サービス種類);
        }
    }

    private boolean chk単位数加算対象6(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_NJYUR:
                switch (サービス種類) {
                    case 居宅支援:
                    case 予防支援:
                        return true;
                    default:
                        return false;
                }
            case INT_NJYUNA:
                switch (サービス種類) {
                    case 福祉施設:
                        return true;
                    default:
                        return false;
                }
            case INT_NJYUH:
                switch (サービス種類) {
                    case 老健施設:
                        return true;
                    default:
                        return false;
                }
            case INT_NJYUK:
                switch (サービス種類) {
                    case 医療施設:
                        return true;
                    default:
                        return false;
                }
            case INT_SJYU:
                switch (サービス種類) {
                    case 地福祉生:
                        return true;
                    default:
                        return false;
                }
            default:
                return chk単位数加算対象7(i, サービス種類);
        }
    }

    private boolean chk単位数加算対象5(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_NJYUI:
                switch (サービス種類) {
                    case 地小規単:
                    case 地予小短:
                        return true;
                    default:
                        return false;
                }
            case INT_NJYUN:
                switch (サービス種類) {
                    case 定期随時:
                        return true;
                    default:
                        return false;
                }
            case INT_NJYUS:
                switch (サービス種類) {
                    case 看小短外:
                        return true;
                    default:
                        return false;
                }
            case INT_NJYUY:
                switch (サービス種類) {
                    case 看小規短:
                        return true;
                    default:
                        return false;
                }
            case INT_NJYUG:
                switch (サービス種類) {
                    case 地域通所:
                        return true;
                    default:
                        return false;
                }
            default:
                return chk単位数加算対象6(i, サービス種類);
        }
    }

    private boolean chk単位数加算対象4(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_JYUR:
                switch (サービス種類) {
                    case 地施短期:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUNA:
                switch (サービス種類) {
                    case 地共同短:
                    case 地予共短:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUH:
                switch (サービス種類) {
                    case 地夜間訪:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUK:
                switch (サービス種類) {
                    case 地通所介:
                    case 地予通所:
                        return true;
                    default:
                        return false;
                }
            case INT_NJYU:
                switch (サービス種類) {
                    case 地小短外:
                    case 地予小外:
                        return true;
                    default:
                        return false;
                }
            default:
                return chk単位数加算対象5(i, サービス種類);
        }
    }

    private boolean chk単位数加算対象3(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_JYUI:
                switch (サービス種類) {
                    case 療養指導:
                    case 予療養指:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUN:
                switch (サービス種類) {
                    case 特施短外:
                    case 予特施設:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUS:
                switch (サービス種類) {
                    case 特施短期:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUY:
                switch (サービス種類) {
                    case 地共同介:
                    case 地予共同:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUG:
                switch (サービス種類) {
                    case 地施短外:
                        return true;
                    default:
                        return false;
                }
            default:
                return chk単位数加算対象4(i, サービス種類);
        }
    }

    private boolean chk単位数加算対象2(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_GO:
                switch (サービス種類) {
                    case 通所リハ:
                    case 予通リハ:
                        return true;
                    default:
                        return false;
                }
            case INT_ROKU:
                switch (サービス種類) {
                    case 用具貸与:
                    case 予用貸与:
                        return true;
                    default:
                        return false;
                }
            case INT_NANA:
                switch (サービス種類) {
                    case 短期生活:
                    case 予短介護:
                        return true;
                    default:
                        return false;
                }
            case INT_HACHI:
                switch (サービス種類) {
                    case 短期老健:
                    case 予短老健:
                        return true;
                    default:
                        return false;
                }
            case INT_KYU:
                switch (サービス種類) {
                    case 短期医療:
                    case 予短医療:
                        return true;
                    default:
                        return false;
                }
            default:
                return chk単位数加算対象3(i, サービス種類);
        }
    }

    private boolean chk単位数加算対象(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case 0:
                switch (サービス種類) {
                    case 訪問介護:
                    case 予訪介護:
                        return true;
                    default:
                        return false;
                }
            case 1:
                switch (サービス種類) {
                    case 訪問入浴:
                    case 予訪入浴:
                        return true;
                    default:
                        return false;
                }
            case 2:
                switch (サービス種類) {
                    case 訪問看護:
                    case 予訪看護:
                        return true;
                    default:
                        return false;
                }
            case INT_SAN:
                switch (サービス種類) {
                    case 訪問リハ:
                    case 予訪リハ:
                        return true;
                    default:
                        return false;
                }
            case INT_YON:
                switch (サービス種類) {
                    case 通所介護:
                    case 予通介護:
                        return true;
                    default:
                        return false;
                }
            default:
                return chk単位数加算対象2(i, サービス種類);
        }
    }

    private boolean chk出来高単位数加算対象(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_JYU:
                switch (サービス種類) {
                    case 短期老健:
                    case 予短老健:
                    case 短期医療:
                    case 予短医療:
                        return true;
                    default:
                        return false;
                }
            case INT_SJYUI:
                switch (サービス種類) {
                    case 老健施設:
                    case 医療施設:
                        return true;
                    default:
                        return false;
                }
            default:
                return false;
        }
    }

    private RString get合計パターン番号(ServiceCategoryShurui サービス種類) {
        switch (サービス種類) {
            case 訪問介護:
            case 予訪介護:
            case 訪問入浴:
            case 予訪入浴:
            case 訪問看護:
            case 予訪看護:
            case 訪問リハ:
            case 予訪リハ:
            case 通所介護:
            case 予通介護:
            case 通所リハ:
                return GOKEI_PATTERN1_1;
            default:
                return get合計パターン番号1(サービス種類);
        }
    }

    private RString get合計パターン番号1(ServiceCategoryShurui サービス種類) {
        switch (サービス種類) {
            case 訪問介護:
            case 予訪介護:
            case 訪問入浴:
            case 予訪入浴:
            case 訪問看護:
            case 予訪看護:
            case 訪問リハ:
            case 予訪リハ:
            case 通所介護:
            case 予通介護:
                return GOKEI_PATTERN1_1;
            default:
                return get合計パターン番号2(サービス種類);
        }
    }

    private RString get合計パターン番号2(ServiceCategoryShurui サービス種類) {
        switch (サービス種類) {
            case 短期老健:
            case 予短老健:
            case 短期医療:
            case 予短医療:
                return GOKEI_PATTERN1_2;
            case 福祉施設:
                return GOKEI_PATTERN2_1;
            case 老健施設:
            case 医療施設:
                return GOKEI_PATTERN2_2;
            default:
                return get合計パターン番号3(サービス種類);
        }
    }

    private RString get合計パターン番号3(ServiceCategoryShurui サービス種類) {
        switch (サービス種類) {
            case 地共同介:
            case 地予共同:
            case 地施短外:
            case 地施短期:
            case 地共同短:
            case 地予共短:
            case 地夜間訪:
            case 地通所介:
            case 地予通所:
            case 地小短外:
            case 地予小外:
            case 地小規単:
            case 地予小短:
            case 定期随時:
            case 看小短外:
            case 看小規短:
            case 地域通所:
            case 地福祉生:
                return GOKEI_PATTERN3;
            default:
                return get合計パターン番号4(サービス種類);
        }
    }

    private RString get合計パターン番号4(ServiceCategoryShurui サービス種類) {
        switch (サービス種類) {
            case 訪問みな:
            case 訪問独自:
            case 訪問定率:
            case 訪問定額:
            case 通所みな:
            case 通所独自:
            case 通所定率:
            case 通所定額:
            case 予防ケア:
            case 配食定率:
            case 配食定額:
            case 見守定率:
            case 見守定額:
            case その他率:
            case その他額:
                return GOKEI_PATTERN4;
            default:
                return get合計パターン番号5(サービス種類);
        }
    }

    private RString get合計パターン番号5(ServiceCategoryShurui サービス種類) {
        switch (サービス種類) {
            case 用具販売:
            case 予用販売:
                return GOKEI_PATTERN6_1;
            case 住宅改修:
            case 予住改修:
                return GOKEI_PATTERN6_2;
            default:
                return GOKEI_PATTERN_NOTHING;
        }
    }

    private boolean chk単位数加算対象_経過措置(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case 0:
                switch (サービス種類) {
                    case 総訪予防:
                        return true;
                    default:
                        return false;
                }
            case 1:
                switch (サービス種類) {
                    case 総訪入浴:
                        return true;
                    default:
                        return false;
                }
            case 2:
                switch (サービス種類) {
                    case 総訪看護:
                        return true;
                    default:
                        return false;
                }
            case INT_SAN:
                switch (サービス種類) {
                    case 総訪リハ:
                        return true;
                    default:
                        return false;
                }
            case INT_YON:
                switch (サービス種類) {
                    case 総通予防:
                        return true;
                    default:
                        return false;
                }
            case INT_GO:
                switch (サービス種類) {
                    case 総通リハ:
                        return true;
                    default:
                        return false;
                }
            default:
                return chk単位数加算対象_経過措置2(i, サービス種類);
        }
    }

    private boolean chk単位数加算対象_経過措置2(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_ROKU:
                switch (サービス種類) {
                    case 総用貸与:
                        return true;
                    default:
                        return false;
                }
            case INT_NANA:
                switch (サービス種類) {
                    case 総短介護:
                        return true;
                    default:
                        return false;
                }
            case INT_HACHI:
                switch (サービス種類) {
                    case 総短老健:
                        return true;
                    default:
                        return false;
                }
            case INT_KYU:
                switch (サービス種類) {
                    case 総短医療:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUI:
                switch (サービス種類) {
                    case 総療養指:
                        return true;
                    default:
                        return false;
                }
            default:
                return chk単位数加算対象_経過措置3(i, サービス種類);
        }
    }

    private boolean chk単位数加算対象_経過措置3(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_JYUN:
                switch (サービス種類) {
                    case 総特施設:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUS:
                switch (サービス種類) {
                    case 地総通所:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUY:
                switch (サービス種類) {
                    case 地総共短:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUG:
                switch (サービス種類) {
                    case 地総共同:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUR:
                switch (サービス種類) {
                    case 地総小規:
                        return true;
                    default:
                        return false;
                }
            default:
                return chk単位数加算対象_経過措置4(i, サービス種類);
        }
    }

    private boolean chk単位数加算対象_経過措置4(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_JYUNA:
                switch (サービス種類) {
                    case ケアマネ:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUH:
                switch (サービス種類) {
                    case 生活配食:
                        return true;
                    default:
                        return false;
                }
            case INT_JYUK:
                switch (サービス種類) {
                    case 生活見守:
                        return true;
                    default:
                        return false;
                }
            case INT_NJYU:
                switch (サービス種類) {
                    case 生活他:
                        return true;
                    default:
                        return false;
                }
            default:
                return false;
        }
    }

    private boolean chk出来高単位数加算対象_経過措置(int i, ServiceCategoryShurui サービス種類) {
        switch (i) {
            case INT_JYU:
                switch (サービス種類) {
                    case 総短老健:
                    case 総短医療:
                        return true;
                    default:
                        return false;
                }
            default:
                return false;
        }
    }

    private RString get合計パターン番号_経過措置(ServiceCategoryShurui サービス種類) {
        switch (サービス種類) {
            case 総訪予防:
            case 総訪入浴:
            case 総訪看護:
            case 総訪リハ:
            case 総通予防:
            case 総通リハ:
            case 総用貸与:
            case 総短介護:
            case 総療養指:
            case 総特施設:
                return GOKEI_PATTERN1_1;
            default:
                return get合計パターン番号_経過措置2(サービス種類);
        }
    }

    private RString get合計パターン番号_経過措置2(ServiceCategoryShurui サービス種類) {
        switch (サービス種類) {
            case 総短老健:
            case 総短医療:
                return GOKEI_PATTERN1_2;
            case 地総通所:
            case 地総共短:
            case 地総共同:
            case 地総小規:
            case ケアマネ:
                return GOKEI_PATTERN3;
            case 生活配食:
            case 生活見守:
            case 生活他:
                return GOKEI_PATTERN4;
            default:
                return GOKEI_PATTERN_NOTHING;
        }
    }

    private void set一覧設定(KyufuJissekiSearchDataBusiness 一覧データ) {
        int 列位値 = 1;
        List<dgKyufuJissekiMeisaiList_Row> 種類明細一覧 = div.getDgKyufuJissekiMeisaiList().getDataSource();
        int idxST = Integer.parseInt(div.getHiddenStartIndex().toString());
        int idxED = Integer.parseInt(div.getHiddenEndIndex().toString());
        int count = INT_58;
        if (!KEY.equals(div.getHiddenSearchKey())) {
            count = INT_NJYUR;
        }

        for (int i = 0; i < 種類明細一覧.size(); i++) {
            for (int j = idxST; j <= idxED; j++) {
                if (一覧データ.get給付実績集計結果明細データ().get((j) * count + i).getKensu().equals(Decimal.ZERO)) {
                    set一覧対象金額データ(種類明細一覧.get(i), 列位値, RString.EMPTY, true);
                } else {
                    set一覧対象金額データ(種類明細一覧.get(i), 列位値,
                            getデータフォマート(一覧データ.get給付実績集計結果明細データ().get((j) * count + i).getKingaku()), false);
                }
                列位値++;
            }
            列位値 = 1;
        }

    }

    private void set一覧対象金額データ(dgKyufuJissekiMeisaiList_Row 明細一覧, int 列, RString 対象金額, boolean 表示制御) {
        switch (列) {
            case INT_ICHI:
                明細一覧.getBtnYM1().setDisabled(表示制御);
                明細一覧.getBtnYM1().setVisible(!表示制御);
                明細一覧.setTxtYM1(対象金額);
                break;
            case INT_NI:
                明細一覧.getBtnYM2().setDisabled(表示制御);
                明細一覧.getBtnYM2().setVisible(!表示制御);
                明細一覧.setTxtYM2(対象金額);
                break;
            case INT_SAN:
                明細一覧.getBtnYM3().setDisabled(表示制御);
                明細一覧.getBtnYM3().setVisible(!表示制御);
                明細一覧.setTxtYM3(対象金額);
                break;
            case INT_YON:
                明細一覧.getBtnYM4().setDisabled(表示制御);
                明細一覧.getBtnYM4().setVisible(!表示制御);
                明細一覧.setTxtYM4(対象金額);
                break;
            case INT_GO:
                明細一覧.getBtnYM5().setDisabled(表示制御);
                明細一覧.getBtnYM5().setVisible(!表示制御);
                明細一覧.setTxtYM5(対象金額);
                break;
            case INT_ROKU:
                明細一覧.getBtnYM6().setDisabled(表示制御);
                明細一覧.getBtnYM6().setVisible(!表示制御);
                明細一覧.setTxtYM6(対象金額);
                break;
            case INT_NANA:
                明細一覧.getBtnYM7().setDisabled(表示制御);
                明細一覧.getBtnYM7().setVisible(!表示制御);
                明細一覧.setTxtYM7(対象金額);
                break;
            case INT_HACHI:
                明細一覧.getBtnYM8().setDisabled(表示制御);
                明細一覧.getBtnYM8().setVisible(!表示制御);
                明細一覧.setTxtYM8(対象金額);
                break;
            case INT_KYU:
                明細一覧.getBtnYM9().setDisabled(表示制御);
                明細一覧.getBtnYM9().setVisible(!表示制御);
                明細一覧.setTxtYM9(対象金額);
                break;
            case INT_JYU:
                明細一覧.getBtnYM10().setDisabled(表示制御);
                明細一覧.getBtnYM10().setVisible(!表示制御);
                明細一覧.setTxtYM10(対象金額);
                break;
            case INT_JYUI:
                明細一覧.getBtnYM11().setDisabled(表示制御);
                明細一覧.getBtnYM11().setVisible(!表示制御);
                明細一覧.setTxtYM11(対象金額);
                break;
            case INT_JYUN:
                明細一覧.getBtnYM12().setDisabled(表示制御);
                明細一覧.getBtnYM12().setVisible(!表示制御);
                明細一覧.setTxtYM12(対象金額);
                break;
            default:
                set一覧対象金額データ2(明細一覧, 列, 対象金額, 表示制御);
        }
    }

    private void set一覧対象金額データ2(dgKyufuJissekiMeisaiList_Row 明細一覧, int 列, RString 対象金額, boolean 表示制御) {
        switch (列) {
            case INT_JYUS:
                明細一覧.getBtnYM13().setDisabled(表示制御);
                明細一覧.getBtnYM13().setVisible(!表示制御);
                明細一覧.setTxtYM13(対象金額);
                break;
            case INT_JYUY:
                明細一覧.getBtnYM14().setDisabled(表示制御);
                明細一覧.getBtnYM14().setVisible(!表示制御);
                明細一覧.setTxtYM14(対象金額);
                break;
            case INT_JYUG:
                明細一覧.getBtnYM15().setDisabled(表示制御);
                明細一覧.getBtnYM15().setVisible(!表示制御);
                明細一覧.setTxtYM15(対象金額);
                break;
            case INT_JYUR:
                明細一覧.getBtnYM16().setDisabled(表示制御);
                明細一覧.getBtnYM16().setVisible(!表示制御);
                明細一覧.setTxtYM16(対象金額);
                break;
            case INT_JYUNA:
                明細一覧.getBtnYM17().setDisabled(表示制御);
                明細一覧.getBtnYM17().setVisible(!表示制御);
                明細一覧.setTxtYM17(対象金額);
                break;
            case INT_JYUH:
                明細一覧.getBtnYM18().setDisabled(表示制御);
                明細一覧.getBtnYM18().setVisible(!表示制御);
                明細一覧.setTxtYM18(対象金額);
                break;
            case INT_JYUK:
                明細一覧.getBtnYM19().setDisabled(表示制御);
                明細一覧.getBtnYM19().setVisible(!表示制御);
                明細一覧.setTxtYM19(対象金額);
                break;
            case INT_NJYU:
                明細一覧.getBtnYM20().setDisabled(表示制御);
                明細一覧.getBtnYM20().setVisible(!表示制御);
                明細一覧.setTxtYM20(対象金額);
                break;
            case INT_NJYUI:
                明細一覧.getBtnYM21().setDisabled(表示制御);
                明細一覧.getBtnYM21().setVisible(!表示制御);
                明細一覧.setTxtYM21(対象金額);
                break;
            case INT_NJYUN:
                明細一覧.getBtnYM22().setDisabled(表示制御);
                明細一覧.getBtnYM22().setVisible(!表示制御);
                明細一覧.setTxtYM22(対象金額);
                break;
            case INT_NJYUS:
                明細一覧.getBtnYM23().setDisabled(表示制御);
                明細一覧.getBtnYM23().setVisible(!表示制御);
                明細一覧.setTxtYM23(対象金額);
                break;
            case INT_NJYUY:
                明細一覧.getBtnYM24().setDisabled(表示制御);
                明細一覧.getBtnYM24().setVisible(!表示制御);
                明細一覧.setTxtYM24(対象金額);
                break;
            default:
                set一覧対象金額データ3(明細一覧, 列, 対象金額, 表示制御);
        }
    }

    private void set一覧対象金額データ3(dgKyufuJissekiMeisaiList_Row 明細一覧, int 列, RString 対象金額, boolean 表示制御) {
        switch (列) {
            case INT_NJYUG:
                明細一覧.getBtnYM25().setDisabled(表示制御);
                明細一覧.getBtnYM25().setVisible(!表示制御);
                明細一覧.setTxtYM25(対象金額);
                break;
            case INT_NJYUR:
                明細一覧.getBtnYM26().setDisabled(表示制御);
                明細一覧.getBtnYM26().setVisible(!表示制御);
                明細一覧.setTxtYM26(対象金額);
                break;
            case INT_NJYUNA:
                明細一覧.getBtnYM27().setDisabled(表示制御);
                明細一覧.getBtnYM27().setVisible(!表示制御);
                明細一覧.setTxtYM27(対象金額);
                break;
            case INT_NJYUH:
                明細一覧.getBtnYM28().setDisabled(表示制御);
                明細一覧.getBtnYM28().setVisible(!表示制御);
                明細一覧.setTxtYM28(対象金額);
                break;
            case INT_NJYUK:
                明細一覧.getBtnYM29().setDisabled(表示制御);
                明細一覧.getBtnYM29().setVisible(!表示制御);
                明細一覧.setTxtYM29(対象金額);
                break;
            case INT_SJYU:
                明細一覧.getBtnYM30().setDisabled(表示制御);
                明細一覧.getBtnYM30().setVisible(!表示制御);
                明細一覧.setTxtYM30(対象金額);
                break;
            case INT_SJYUI:
                明細一覧.getBtnYM31().setDisabled(表示制御);
                明細一覧.getBtnYM31().setVisible(!表示制御);
                明細一覧.setTxtYM31(対象金額);
                break;
            case INT_SJYUN:
                明細一覧.getBtnYM32().setDisabled(表示制御);
                明細一覧.getBtnYM32().setVisible(!表示制御);
                明細一覧.setTxtYM32(対象金額);
                break;
            case INT_SJYUS:
                明細一覧.getBtnYM33().setDisabled(表示制御);
                明細一覧.getBtnYM33().setVisible(!表示制御);
                明細一覧.setTxtYM33(対象金額);
                break;
            case INT_SJYUY:
                明細一覧.getBtnYM34().setDisabled(表示制御);
                明細一覧.getBtnYM34().setVisible(!表示制御);
                明細一覧.setTxtYM34(対象金額);
                break;
            case INT_SJYUG:
                明細一覧.getBtnYM35().setDisabled(表示制御);
                明細一覧.getBtnYM35().setVisible(!表示制御);
                明細一覧.setTxtYM35(対象金額);
                break;
            case INT_SJYUR:
                明細一覧.getBtnYM36().setDisabled(表示制御);
                明細一覧.getBtnYM36().setVisible(!表示制御);
                明細一覧.setTxtYM36(対象金額);
                break;
            default:
                break;
        }
    }

}
