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
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKogakuKaigoServicehi;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho1;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiKihonKyotakuServiceBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiKihonShukeiBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiSearchDataBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiShokaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.dgKyufuJissekiGokeiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.dgKyufuJissekiMeisaiList_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridColumn;
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
    private static final int INT_YJYUH = 48;
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
    private static final RString 利用者負担額合計 = new RString("利用者負担額合計");

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
     */
    public void onClick_btnKyufuJissekiSearch(KyufuJissekiHedajyoho1 給付実績ヘッダ情報1,
            FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了,
            KyufuJissekiSearchDataBusiness 一覧データ) {
        div.getTxtKyufuJissekiListHihokenshaNo().setValue(get被保険者番号(給付実績ヘッダ情報1.get被保険者番号()));
        div.getTxtKyufuJissekiListJuminShubetsu().setValue(get住民種別(給付実績ヘッダ情報1.get資格取得事由コード()));
        if (給付実績ヘッダ情報1.get認定年月日() != null && !給付実績ヘッダ情報1.get認定年月日().isEmpty()
                && !RString.isNullOrEmpty(給付実績ヘッダ情報1.get要介護認定状態区分コード())) {
            div.getTxtKyufuJissekiListYokaigodo().setValue(YokaigoJotaiKubunSupport.toValue(
                    給付実績ヘッダ情報1.get認定年月日().getYearMonth(), 給付実績ヘッダ情報1.get要介護認定状態区分コード()).getName());
        }
        if (給付実績ヘッダ情報1.get認定有効期間開始年月日() != null && !給付実績ヘッダ情報1.get認定有効期間開始年月日().isEmpty()) {
            div.getTxtKyufuJissekiListNinteiYukoKikan().setFromValue(new RDate(給付実績ヘッダ情報1.get認定有効期間開始年月日().toString()));
        }
        if (給付実績ヘッダ情報1.get認定有効期間終了年月日() != null && !給付実績ヘッダ情報1.get認定有効期間終了年月日().isEmpty()) {
            div.getTxtKyufuJissekiListNinteiYukoKikan().setToValue(new RDate(給付実績ヘッダ情報1.get認定有効期間終了年月日().toString()));
        }
        div.getTxtKyufuJissekiListName().setValue(給付実績ヘッダ情報1.get名称());
        div.getTxtKyufuJissekiListSeibetsu().setValue(get性別(給付実績ヘッダ情報1.get性別コード()));
        if (給付実績ヘッダ情報1.get生年月日() != null && !給付実績ヘッダ情報1.get生年月日().isEmpty()) {
            div.getTxtKyufuJissekiListSeinengappi().setValue(給付実績ヘッダ情報1.get生年月日().wareki().toDateString());
        }
        set明細一覧行();
        set合計一覧行();
        set明細一覧列(サービス提供年月_開始, サービス提供年月_終了);
        set一覧設定(一覧データ);
        setボタン表示非表示の設定(サービス提供年月_開始, サービス提供年月_終了);
        setボタン活性非活性の設定();
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
        div.getDgKyufuJissekiMeisaiList().setDataSource(種類明細一覧);
    }

    private void set合計一覧行() {
        RString 検索対象 = div.getRadTaisho1().getSelectedKey();
        List<dgKyufuJissekiGokeiList_Row> 合計一覧 = get合計空白一覧(検索対象);
        for (int i = 0; i < 合計一覧.size(); i++) {
            set合計一覧固定項目(i, 合計一覧.get(i), 検索対象);
        }
        div.getDgKyufuJissekiGokeiList().setDataSource(合計一覧);
    }

    private void set明細一覧列(FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了) {
        set一覧表示();
        if (!RString.isNullOrEmpty(div.getRadNendo().getSelectedKey())) {
            for (int i = INT_SAN; i < INT_NJYUNA; i++) {
                set列名の設定(i, サービス提供年月_開始, サービス提供年月_終了);
            }
            for (int i = INT_NJYUNA; i < INT_NJYUNG; i++) {
                div.getDgKyufuJissekiMeisaiList().getGridSetting().getColumns().get(i).setVisible(false);
                div.getDgKyufuJissekiGokeiList().getGridSetting().getColumns().get(i).setVisible(false);
            }
        } else {
            int 列数 = サービス提供年月_終了.getBetweenMonths(サービス提供年月_開始) + INT_ICHI;
            if (列数 <= INT_SJYUR) {
                for (int i = INT_SAN; i < (列数 * INT_NI + INT_SAN); i++) {
                    set列名の設定(i, サービス提供年月_開始, サービス提供年月_終了);
                }
                for (int i = (列数 * INT_NI + INT_SAN); i < INT_NJYUNG; i++) {
                    div.getDgKyufuJissekiMeisaiList().getGridSetting().getColumns().get(i).setVisible(false);
                    div.getDgKyufuJissekiGokeiList().getGridSetting().getColumns().get(i).setVisible(false);
                }
            } else {
                FlexibleYearMonth 計算後サービス提供年月_開始 = サービス提供年月_開始.plusMonth(列数 - INT_SJYUR);
                for (int i = INT_SAN; i < INT_NJYUNG; i++) {
                    set列名の設定(i, 計算後サービス提供年月_開始, サービス提供年月_終了);
                }
            }
        }
    }

    private void set一覧表示() {
        for (int i = INT_ZERO; i < INT_NJYUNG; i++) {
            div.getDgKyufuJissekiMeisaiList().getGridSetting().getColumns().get(i).setVisible(true);
            div.getDgKyufuJissekiGokeiList().getGridSetting().getColumns().get(i).setVisible(true);
        }
    }

    private RString get被保険者番号(HihokenshaNo 被保険者番号) {
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            return 被保険者番号.value();
        }
        return RString.EMPTY;
    }

    private RString get住民種別(RString 資格取得事由コード) {
        if (!RString.isNullOrEmpty(資格取得事由コード)) {
            return ShikakuShutokuJiyu.toValue(資格取得事由コード).get名称();
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

    private List<dgKyufuJissekiGokeiList_Row> get合計空白一覧(RString 検索対象) {
        List<dgKyufuJissekiGokeiList_Row> rowList = new ArrayList<>();
        if (KEY.equals(検索対象)) {
            for (int i = 1; i < INT_JYUN; i++) {
                dgKyufuJissekiGokeiList_Row row = new dgKyufuJissekiGokeiList_Row();
                rowList.add(row);
            }
        } else {
            for (int i = 1; i < INT_ROKU; i++) {
                dgKyufuJissekiGokeiList_Row row = new dgKyufuJissekiGokeiList_Row();
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
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_NI:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("訪問看護"));
                    明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("総合訪問看護"));
                    明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                }
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_SAN:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("訪問リハピリ"));
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("総合訪問リハビリテーション"));
                }
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
                    明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("総合通所型予防サービス"));
                    明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                }
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_GO:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("通所リハピリ"));
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("総合通所リハビリテーション"));
                }
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
                    明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                }
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
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
                    明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("総合短期入所療養介護(老健)"));
                    明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                }
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
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
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_JYU:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("出来高神請求費（短期入所療養介護）"));
                    明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("出来高請求額"));
                    明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                }
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
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
                    明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("総合特定施設入居者生活介護"));
                    明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                }
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
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
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_JYUY:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(地域密着);
                    明細一覧.setTxtServiceShurui(new RString("認知症対応型共同生活介護"));
                    明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("総合認知症型共同生活(短期)"));
                    明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                }
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
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
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_JYUR:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("地域密着型特定施設入所者生活介護(短期)"));
                    明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("総合小規模多機能型居宅介護"));
                    明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                }
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
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
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_JYUH:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("夜間対応型訪問介護"));
                    明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(生活支援);
                    明細一覧.setTxtServiceShurui(new RString("生活支援サービス(配食)"));
                    明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                }
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
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
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_NJYU:
                if (KEY.equals(検索対象)) {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("小規模多機能型居宅介護（短期以外）"));
                    明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                } else {
                    明細一覧.setTxtServiceGroup1(RString.EMPTY);
                    明細一覧.setTxtServiceGroup2(RString.EMPTY);
                    明細一覧.setTxtServiceShurui(new RString("生活支援サービス(その他)"));
                    明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                }
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
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
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_NJYUN:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("定期巡回・随時対応型訪問介護看護"));
                明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_NJYUS:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("複合型（看護小規模多機能型居宅介護・短期以外）"));
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_NJYUY:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("複合型（看護小規模多機能型居宅介護・短期）"));
                明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
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
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_NJYUR:
                明細一覧.setTxtServiceGroup1(居宅介護);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(居宅介護);
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_NJYUNA:
                明細一覧.setTxtServiceGroup1(指定施設サービス等);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("介護福祉施設サービス"));
                明細一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_NJYUH:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("介護保健施設サービス"));
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_NJYUK:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("介護療養施設サービス"));
                明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_SJYU:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(地域密着);
                明細一覧.setTxtServiceShurui(new RString("地域密着型介護老人福祉施設"));
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_SJYUI:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("出来高請求費"));
                明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
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
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_SJYUY:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("訪問型サービス（独自／定率）"));
                明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightYellow);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_SJYUG:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("訪問型サービス（独自／定額）"));
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_SJYUR:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("通所型サービス（みなし）"));
                明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightYellow);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_SJYUNA:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("通所型サービス（独自）"));
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_SJYUH:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("通所型サービス（独自／定率）"));
                明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightYellow);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_SJYUK:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("通所型サービス（独自／定額）"));
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_YJYU:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("介護予防ケアマネジメント"));
                明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightYellow);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_YJYUI:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("その他の生活支援（配食／定率）"));
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_YJYUN:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("その他の生活支援（配食／定額）"));
                明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightYellow);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_YJYUS:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("その他の生活支援（見守り／定率）"));
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_YJYUY:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("その他の生活支援（見守り／定額）"));
                明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightYellow);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_YJYUG:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("その他の生活支援（その他／定率）"));
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_YJYUR:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("その他の生活支援（その他／定額）"));
                明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightYellow);
                明細一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            default:
                break;
        }
    }

    private void set合計一覧固定項目(int 一覧行数,
            dgKyufuJissekiGokeiList_Row 合計一覧, RString 検索対象) {
        switch (一覧行数) {
            case INT_ZERO:
                if (KEY.equals(検索対象)) {
                    合計一覧.setTxtServiceGroup1(RString.EMPTY);
                    合計一覧.setTxtServiceGroup2(RString.EMPTY);
                    合計一覧.setTxtServiceShurui(居宅サービス合計単位);
                    合計一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
                } else {
                    合計一覧.setTxtServiceGroup1(RString.EMPTY);
                    合計一覧.setTxtServiceGroup2(RString.EMPTY);
                    合計一覧.setTxtServiceShurui(居宅サービス合計単位);
                    合計一覧.setRowBgColor(DataGridCellBgColor.bgColorLightBlue);
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
                合計一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
                合計一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_NI:
                if (KEY.equals(検索対象)) {
                    合計一覧.setTxtServiceGroup1(RString.EMPTY);
                    合計一覧.setTxtServiceGroup2(RString.EMPTY);
                    合計一覧.setTxtServiceShurui(地域密着型サービス合計単位);
                    合計一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                } else {
                    合計一覧.setTxtServiceGroup1(RString.EMPTY);
                    合計一覧.setTxtServiceGroup2(RString.EMPTY);
                    合計一覧.setTxtServiceShurui(new RString("生活支援サービス合計単位"));
                    合計一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                }
                合計一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
                合計一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
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
                    set選択ボタン表示非表示の設定(合計一覧);
                }
                合計一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
                合計一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_YON:
                if (KEY.equals(検索対象)) {
                    合計一覧.setTxtServiceGroup1(RString.EMPTY);
                    合計一覧.setTxtServiceGroup2(RString.EMPTY);
                    合計一覧.setTxtServiceShurui(給付費合計);
                    合計一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                } else {
                    合計一覧.setTxtServiceGroup1(RString.EMPTY);
                    合計一覧.setTxtServiceGroup2(RString.EMPTY);
                    合計一覧.setTxtServiceShurui(利用者負担額合計);
                    合計一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                }
                合計一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
                合計一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                set選択ボタン表示非表示の設定(合計一覧);
                break;
            case INT_GO:
                合計一覧.setTxtServiceGroup1(RString.EMPTY);
                合計一覧.setTxtServiceGroup2(RString.EMPTY);
                合計一覧.setTxtServiceShurui(new RString("給付費合計（総合事業）"));
                合計一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
                合計一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                set選択ボタン表示非表示の設定(合計一覧);
                break;
            case INT_ROKU:
                合計一覧.setTxtServiceGroup1(RString.EMPTY);
                合計一覧.setTxtServiceGroup2(RString.EMPTY);
                合計一覧.setTxtServiceShurui(利用者負担額合計);
                合計一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                合計一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
                合計一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                set選択ボタン表示非表示の設定(合計一覧);
                break;
            case INT_NANA:
                合計一覧.setTxtServiceGroup1(RString.EMPTY);
                合計一覧.setTxtServiceGroup2(RString.EMPTY);
                合計一覧.setTxtServiceShurui(new RString("利用者負担合計（総合事業）"));
                合計一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
                合計一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                set選択ボタン表示非表示の設定(合計一覧);
                break;
            case INT_HACHI:
                合計一覧.setTxtServiceGroup1(RString.EMPTY);
                合計一覧.setTxtServiceGroup2(RString.EMPTY);
                合計一覧.setTxtServiceShurui(new RString("高額介護費"));
                合計一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                合計一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
                合計一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_KYU:
                合計一覧.setTxtServiceGroup1(RString.EMPTY);
                合計一覧.setTxtServiceGroup2(RString.EMPTY);
                合計一覧.setTxtServiceShurui(new RString("福祉用具販売"));
                合計一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
                合計一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_JYU:
                合計一覧.setTxtServiceGroup1(RString.EMPTY);
                合計一覧.setTxtServiceGroup2(RString.EMPTY);
                合計一覧.setTxtServiceShurui(new RString("住宅改修"));
                合計一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                合計一覧.setCellBgColor(サービス組１.toString(), DataGridCellBgColor.bgColorLightBlue);
                合計一覧.setCellBgColor(サービス組２.toString(), DataGridCellBgColor.bgColorLightBlue);
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

    private void set選択ボタン表示非表示の設定(dgKyufuJissekiGokeiList_Row 合計一覧) {
        合計一覧.getBtnYM1().setVisible(false);
        合計一覧.getBtnYM2().setVisible(false);
        合計一覧.getBtnYM3().setVisible(false);
        合計一覧.getBtnYM4().setVisible(false);
        合計一覧.getBtnYM5().setVisible(false);
        合計一覧.getBtnYM6().setVisible(false);
        合計一覧.getBtnYM7().setVisible(false);
        合計一覧.getBtnYM8().setVisible(false);
        合計一覧.getBtnYM9().setVisible(false);
        合計一覧.getBtnYM10().setVisible(false);
        合計一覧.getBtnYM11().setVisible(false);
        合計一覧.getBtnYM12().setVisible(false);
        合計一覧.getBtnYM13().setVisible(false);
        合計一覧.getBtnYM14().setVisible(false);
        合計一覧.getBtnYM15().setVisible(false);
        合計一覧.getBtnYM16().setVisible(false);
        合計一覧.getBtnYM17().setVisible(false);
        合計一覧.getBtnYM18().setVisible(false);
        合計一覧.getBtnYM19().setVisible(false);
        合計一覧.getBtnYM20().setVisible(false);
        合計一覧.getBtnYM21().setVisible(false);
        合計一覧.getBtnYM22().setVisible(false);
        合計一覧.getBtnYM23().setVisible(false);
        合計一覧.getBtnYM24().setVisible(false);
        合計一覧.getBtnYM25().setVisible(false);
        合計一覧.getBtnYM26().setVisible(false);
        合計一覧.getBtnYM27().setVisible(false);
        合計一覧.getBtnYM28().setVisible(false);
        合計一覧.getBtnYM29().setVisible(false);
        合計一覧.getBtnYM30().setVisible(false);
        合計一覧.getBtnYM31().setVisible(false);
        合計一覧.getBtnYM32().setVisible(false);
        合計一覧.getBtnYM33().setVisible(false);
        合計一覧.getBtnYM34().setVisible(false);
        合計一覧.getBtnYM35().setVisible(false);
        合計一覧.getBtnYM36().setVisible(false);
    }

    private void setボタン活性非活性の設定() {
        if (div.getBtnSento().isVisible()) {
            FlexibleYearMonth サービス提供年月_開始
                    = new FlexibleYearMonth(div.getTxtKyufuJissekiSearchServiceTeikyoYM().
                            getFromValue().toDateString().substring(INT_ZERO, INT_ROKU));
            FlexibleYearMonth サービス提供年月_終了
                    = new FlexibleYearMonth(div.getTxtKyufuJissekiSearchServiceTeikyoYM().
                            getToValue().toDateString().substring(INT_ZERO, INT_ROKU));
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

    private void set一覧設定(KyufuJissekiSearchDataBusiness 一覧データ) {
        int 列位値 = 1;
        for (int i = INT_YON; i < INT_NJYUNG; i++) {
            if (i % INT_NI == INT_ZERO) {
                DataGridColumn 列 = div.getDgKyufuJissekiMeisaiList().getGridSetting().getColumns().get(i);
                if (列.isVisible()) {
                    FlexibleYearMonth 列日期 = new FlexibleYearMonth(new RDate(列.getGroupName().toString()).getYearMonth().toDateString());
                    set一覧列設定(get集計_後_点数合計給付明細列一覧データ(一覧データ, 列日期),
                            get計画費_後_点数給付明細列一覧データ(一覧データ, 列日期),
                            get高額明細_支給額一覧データ(一覧データ, 列日期), 列位値);
                    列位値 = 列位値 + 1;
                }
            }
        }
    }

    private List<KyufuJissekiKihonShukeiBusiness> get集計_後_点数合計給付明細列一覧データ(
            KyufuJissekiSearchDataBusiness 一覧データ, FlexibleYearMonth 列日期) {
        List<KyufuJissekiKihonShukeiBusiness> 給付明細列一覧データ = new ArrayList<>();
        List<KyufuJissekiKihonShukeiBusiness> 給付実績基本集計データ = 一覧データ.get給付実績基本集計データ();
        for (KyufuJissekiKihonShukeiBusiness 給付実績基本集計 : 給付実績基本集計データ) {
            FlexibleYearMonth サービス提供年月 = 給付実績基本集計.get給付実績集計データ().getサービス提供年月();
            if (列日期.equals(サービス提供年月)) {
                給付明細列一覧データ.add(給付実績基本集計);
            }
        }
        return 給付明細列一覧データ;
    }

    private List<KyufuJissekiKihonKyotakuServiceBusiness> get計画費_後_点数給付明細列一覧データ(
            KyufuJissekiSearchDataBusiness 一覧データ, FlexibleYearMonth 列日期) {
        List<KyufuJissekiKihonKyotakuServiceBusiness> 計画費集計データ = new ArrayList<>();
        List<KyufuJissekiKihonKyotakuServiceBusiness> 居宅サービス計画費データ = 一覧データ.get給付実績基本居宅サービス計画費データ();
        for (KyufuJissekiKihonKyotakuServiceBusiness 計画費データ : 居宅サービス計画費データ) {
            FlexibleYearMonth サービス提供年月 = 計画費データ.get給付実績基本居宅サービス計画費データ().getサービス提供年月();
            if (列日期.equals(サービス提供年月)) {
                計画費集計データ.add(計画費データ);
            }
        }
        return 計画費集計データ;
    }

    private List<KyufujissekiKogakuKaigoServicehi> get高額明細_支給額一覧データ(
            KyufuJissekiSearchDataBusiness 一覧データ, FlexibleYearMonth 列日期) {
        List<KyufujissekiKogakuKaigoServicehi> 実績高額集計データ = new ArrayList<>();
        List<KyufujissekiKogakuKaigoServicehi> 実績高額介護サービス費データ = 一覧データ.get給付実績高額介護サービス費データ();
        for (KyufujissekiKogakuKaigoServicehi 実績高額 : 実績高額介護サービス費データ) {
            FlexibleYearMonth サービス提供年月 = 実績高額.getサービス提供年月();
            if (列日期.equals(サービス提供年月)) {
                実績高額集計データ.add(実績高額);
            }
        }
        return 実績高額集計データ;
    }

    private void set一覧列設定(List<KyufuJissekiKihonShukeiBusiness> 給付明細列一覧データ,
            List<KyufuJissekiKihonKyotakuServiceBusiness> 計画費集計データ,
            List<KyufujissekiKogakuKaigoServicehi> 実績高額集計データ, int 列位値) {
        List<dgKyufuJissekiMeisaiList_Row> 種類明細一覧 = div.getDgKyufuJissekiMeisaiList().getDataSource();
        List<dgKyufuJissekiGokeiList_Row> 種類合計一覧 = div.getDgKyufuJissekiGokeiList().getDataSource();
        RString 検索対象 = div.getRadTaisho1().getSelectedKey();
        for (int i = INT_ZERO; i < 種類明細一覧.size(); i++) {
            set一覧対象金額データ(種類明細一覧.get(i), 列位値, get行対象金額(i, 給付明細列一覧データ, 計画費集計データ, 検索対象));
        }
        for (int i = INT_ZERO; i < 種類合計一覧.size(); i++) {
            set合計一覧対象金額データ(種類合計一覧.get(i), 列位値, get合計行対象金額(i, 給付明細列一覧データ, 実績高額集計データ, 検索対象));
        }
    }

    private RString get行対象金額(int 行位値, List<KyufuJissekiKihonShukeiBusiness> 給付明細列一覧データ,
            List<KyufuJissekiKihonKyotakuServiceBusiness> 計画費集計データ, RString 検索対象) {
        switch (行位値) {
            case INT_ZERO:
                if (KEY.equals(検索対象)) {
                    return getデータフォマート(get項目データ(給付明細列一覧データ,
                            ServiceCategoryShurui.訪問介護.getコード(), ServiceCategoryShurui.予訪介護.getコード()));
                } else {
                    return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.総訪予防.getコード()));
                }
            case INT_ICHI:
                if (KEY.equals(検索対象)) {
                    return getデータフォマート(get項目データ(給付明細列一覧データ,
                            ServiceCategoryShurui.訪問入浴.getコード(), ServiceCategoryShurui.予訪入浴.getコード()));
                } else {
                    return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.総訪入浴.getコード()));
                }
            case INT_NI:
                if (KEY.equals(検索対象)) {
                    return getデータフォマート(get項目データ(給付明細列一覧データ,
                            ServiceCategoryShurui.訪問看護.getコード(), ServiceCategoryShurui.予訪看護.getコード()));
                } else {
                    return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.総訪看護.getコード()));
                }
            case INT_SAN:
                if (KEY.equals(検索対象)) {
                    return getデータフォマート(get項目データ(給付明細列一覧データ,
                            ServiceCategoryShurui.訪問リハ.getコード(), ServiceCategoryShurui.予訪リハ.getコード()));
                } else {
                    return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.総訪リハ.getコード()));
                }
            case INT_YON:
                if (KEY.equals(検索対象)) {
                    return getデータフォマート(get項目データ(給付明細列一覧データ,
                            ServiceCategoryShurui.通所介護.getコード(), ServiceCategoryShurui.予通介護.getコード()));
                } else {
                    return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.総通予防.getコード()));
                }
            case INT_GO:
                if (KEY.equals(検索対象)) {
                    return getデータフォマート(get項目データ(給付明細列一覧データ,
                            ServiceCategoryShurui.通所リハ.getコード(), ServiceCategoryShurui.予通リハ.getコード()));
                } else {
                    return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.総通リハ.getコード()));
                }
            case INT_ROKU:
                if (KEY.equals(検索対象)) {
                    return getデータフォマート(get項目データ(給付明細列一覧データ,
                            ServiceCategoryShurui.用具貸与.getコード(), ServiceCategoryShurui.予用貸与.getコード()));
                } else {
                    return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.総用貸与.getコード()));
                }
            case INT_NANA:
                if (KEY.equals(検索対象)) {
                    return getデータフォマート(get項目データ(給付明細列一覧データ,
                            ServiceCategoryShurui.短期生活.getコード(), ServiceCategoryShurui.予短介護.getコード()));
                } else {
                    return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.総短介護.getコード()));
                }
            case INT_HACHI:
                if (KEY.equals(検索対象)) {
                    return getデータフォマート(get項目データ(給付明細列一覧データ,
                            ServiceCategoryShurui.短期老健.getコード(), ServiceCategoryShurui.予短老健.getコード()));
                } else {
                    return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.総短老健.getコード()));
                }
            default:
                return get行対象金額１(行位値, 給付明細列一覧データ, 計画費集計データ, 検索対象);
        }
    }

    private RString get行対象金額１(int 行位値, List<KyufuJissekiKihonShukeiBusiness> 給付明細列一覧データ,
            List<KyufuJissekiKihonKyotakuServiceBusiness> 計画費集計データ, RString 検索対象) {
        switch (行位値) {
            case INT_KYU:
                if (KEY.equals(検索対象)) {
                    return getデータフォマート(get項目データ(給付明細列一覧データ,
                            ServiceCategoryShurui.短期医療.getコード(), ServiceCategoryShurui.予短医療.getコード()));
                } else {
                    return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.総短医療.getコード()));
                }
            case INT_JYU:
                if (KEY.equals(検索対象)) {
                    return getデータフォマート(get項目データ(給付明細列一覧データ,
                            ServiceCategoryShurui.短期老健.getコード(), ServiceCategoryShurui.短期医療.getコード(),
                            ServiceCategoryShurui.予短老健.getコード(), ServiceCategoryShurui.予短医療.getコード()));
                } else {
                    return getデータフォマート(get後_保険_出来高単位数合計(給付明細列一覧データ,
                            ServiceCategoryShurui.総短老健.getコード(), ServiceCategoryShurui.総短医療.getコード()));
                }
            case INT_JYUI:
                if (KEY.equals(検索対象)) {
                    return getデータフォマート(get項目データ(給付明細列一覧データ,
                            ServiceCategoryShurui.療養指導.getコード(), ServiceCategoryShurui.予療養指.getコード()));
                } else {
                    return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.総療養指.getコード()));
                }
            case INT_JYUN:
                if (KEY.equals(検索対象)) {
                    return getデータフォマート(get項目データ(給付明細列一覧データ,
                            ServiceCategoryShurui.特施短外.getコード(), ServiceCategoryShurui.予特施設.getコード()));
                } else {
                    return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.総特施設.getコード()));
                }
            case INT_JYUS:
                if (KEY.equals(検索対象)) {
                    return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.特施短期.getコード()));
                } else {
                    return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.地総通所.getコード()));
                }
            case INT_JYUY:
                if (KEY.equals(検索対象)) {
                    return getデータフォマート(get項目データ(給付明細列一覧データ,
                            ServiceCategoryShurui.地共同介.getコード(), ServiceCategoryShurui.地予共同.getコード()));
                } else {
                    return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.地総共短.getコード()));
                }
            case INT_JYUG:
                if (KEY.equals(検索対象)) {
                    return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.地施短外.getコード()));
                } else {
                    return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.地総共同.getコード()));
                }
            case INT_JYUR:
                if (KEY.equals(検索対象)) {
                    return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.地施短期.getコード()));
                } else {
                    return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.地総小規.getコード()));
                }
            default:
                return get行対象金額２(行位値, 給付明細列一覧データ, 計画費集計データ, 検索対象);
        }
    }

    private RString get行対象金額２(int 行位値, List<KyufuJissekiKihonShukeiBusiness> 給付明細列一覧データ,
            List<KyufuJissekiKihonKyotakuServiceBusiness> 計画費集計データ, RString 検索対象) {
        switch (行位値) {
            case INT_JYUNA:
                if (KEY.equals(検索対象)) {
                    return getデータフォマート(get項目データ(給付明細列一覧データ,
                            ServiceCategoryShurui.地共同短.getコード(), ServiceCategoryShurui.地予共短.getコード()));
                } else {
                    return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.ケアマネ.getコード()));
                }
            case INT_JYUH:
                if (KEY.equals(検索対象)) {
                    return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.地夜間訪.getコード()));
                } else {
                    return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.生活配食.getコード()));
                }
            case INT_JYUK:
                if (KEY.equals(検索対象)) {
                    return getデータフォマート(get項目データ(給付明細列一覧データ,
                            ServiceCategoryShurui.地通所介.getコード(), ServiceCategoryShurui.地予通所.getコード()));
                } else {
                    return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.生活見守.getコード()));
                }
            case INT_NJYU:
                if (KEY.equals(検索対象)) {
                    return getデータフォマート(get項目データ(給付明細列一覧データ,
                            ServiceCategoryShurui.地小短外.getコード(), ServiceCategoryShurui.地予小外.getコード()));
                } else {
                    return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.生活他.getコード()));
                }
            case INT_NJYUI:
                return getデータフォマート(get項目データ(給付明細列一覧データ,
                        ServiceCategoryShurui.地小規単.getコード(), ServiceCategoryShurui.地予小短.getコード()));
            case INT_NJYUN:
                return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.定期随時.getコード()));
            default:
                return get行対象金額３(行位値, 給付明細列一覧データ, 計画費集計データ);
        }
    }

    private RString get行対象金額３(int 行位値, List<KyufuJissekiKihonShukeiBusiness> 給付明細列一覧データ,
            List<KyufuJissekiKihonKyotakuServiceBusiness> 計画費集計データ) {
        switch (行位値) {
            case INT_NJYUS:
                return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.看小短外.getコード()));
            case INT_NJYUY:
                return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.看小規短.getコード()));
            case INT_NJYUG:
                return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.地域通所.getコード()));
            case INT_NJYUR:
                return getデータフォマート(get計画費_後_点数(計画費集計データ,
                        ServiceCategoryShurui.居宅支援.getコード(), ServiceCategoryShurui.予防支援.getコード()));
            case INT_NJYUNA:
                return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.福祉施設.getコード()));
            case INT_NJYUH:
                return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.老健施設.getコード()));
            case INT_NJYUK:
                return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.医療施設.getコード()));
            case INT_SJYU:
                return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.地福祉生.getコード()));
            case INT_SJYUI:
                return getデータフォマート(get後_保険_出来高単位数合計(給付明細列一覧データ,
                        ServiceCategoryShurui.老健施設.getコード(), ServiceCategoryShurui.医療施設.getコード()));
            case INT_SJYUN:
                return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.訪問みな.getコード()));
            case INT_SJYUS:
                return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.訪問独自.getコード()));
            default:
                return get行対象金額４(行位値, 給付明細列一覧データ);
        }
    }

    private RString get行対象金額４(int 行位値, List<KyufuJissekiKihonShukeiBusiness> 給付明細列一覧データ) {
        switch (行位値) {
            case INT_SJYUY:
                return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.訪問定率.getコード()));
            case INT_SJYUG:
                return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.訪問定額.getコード()));
            case INT_SJYUR:
                return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.通所みな.getコード()));
            case INT_SJYUNA:
                return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.通所独自.getコード()));
            case INT_SJYUH:
                return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.通所定率.getコード()));
            case INT_SJYUK:
                return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.通所定額.getコード()));
            case INT_YJYU:
                return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.予防ケア.getコード()));
            case INT_YJYUI:
                return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.配食定率.getコード()));
            case INT_YJYUN:
                return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.配食定額.getコード()));
            case INT_YJYUS:
                return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.見守定率.getコード()));
            case INT_YJYUY:
                return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.見守定額.getコード()));
            case INT_YJYUG:
                return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.その他率.getコード()));
            case INT_YJYUR:
                return getデータフォマート(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.その他額.getコード()));
            default:
                return RS_ZERO;
        }
    }

    private RString get合計行対象金額(int 行位値, List<KyufuJissekiKihonShukeiBusiness> 給付明細列一覧データ,
            List<KyufujissekiKogakuKaigoServicehi> 実績高額集計データ, RString 検索対象) {
        switch (行位値) {
            case INT_ZERO:
                return getデータフォマート(get居宅サービス合計単位(給付明細列一覧データ));
            case INT_ICHI:
                if (KEY.equals(検索対象)) {
                    return getデータフォマート(get施設サービス合計単位(給付明細列一覧データ));
                } else {
                    return getデータフォマート(get地域密着型サービス合計単位(給付明細列一覧データ));
                }
            case INT_NI:
                if (KEY.equals(検索対象)) {
                    return getデータフォマート(get地域密着型サービス合計単位(給付明細列一覧データ));
                } else {
                    return getデータフォマート(get生活支援サービス合計単位(給付明細列一覧データ));
                }
            case INT_SAN:
                if (KEY.equals(検索対象)) {
                    return getデータフォマート(get総合事業合計単位(給付明細列一覧データ));
                } else {
                    return getデータフォマート(get集計_後_保険請求分請求額(給付明細列一覧データ));
                }
            case INT_YON:
                if (KEY.equals(検索対象)) {
                    return getデータフォマート(get集計_後_保険請求分請求額(給付明細列一覧データ));
                } else {
                    return getデータフォマート(get集計_利用者負担額(給付明細列一覧データ));
                }
            case INT_GO:
                return RString.EMPTY;
            case INT_ROKU:
                return getデータフォマート(get集計_利用者負担額(給付明細列一覧データ));
            case INT_NANA:
                return RString.EMPTY;
            case INT_HACHI:
                return getデータフォマート(get高額明細_支給額(実績高額集計データ));
            case INT_KYU:
                return getデータフォマート(get集計_後_保険請求分請求額(給付明細列一覧データ,
                        ServiceCategoryShurui.用具販売.getコード(), ServiceCategoryShurui.予用販売.getコード()));
            case INT_JYU:
                return getデータフォマート(get集計_後_保険請求分請求額(給付明細列一覧データ,
                        ServiceCategoryShurui.住宅改修.getコード(), ServiceCategoryShurui.予住改修.getコード()));
            default:
                return RS_ZERO;
        }
    }

    private Decimal get項目データ(List<KyufuJissekiKihonShukeiBusiness> 給付明細列一覧データ,
            RString サービス種類１) {
        Decimal 項目データ = new Decimal(INT_ZERO);
        for (KyufuJissekiKihonShukeiBusiness 給付明細列一覧 : 給付明細列一覧データ) {
            RString 対象サービス種類 = 給付明細列一覧.get給付実績集計データ().getサービス種類コード().value();
            if (対象サービス種類.equals(サービス種類１)) {
                Decimal 点数合計 = 給付明細列一覧.get給付実績集計データ().get後_単位数合計();
                if (点数合計 == null) {
                    点数合計 = new Decimal(INT_ZERO);
                }
                項目データ = 項目データ.add(点数合計);
            }
        }
        return 項目データ;
    }

    private Decimal get項目データ(List<KyufuJissekiKihonShukeiBusiness> 給付明細列一覧データ,
            RString サービス種類１, RString サービス種類２) {
        Decimal 項目データ = new Decimal(INT_ZERO);
        for (KyufuJissekiKihonShukeiBusiness 給付明細列一覧 : 給付明細列一覧データ) {
            RString 対象サービス種類 = 給付明細列一覧.get給付実績集計データ().getサービス種類コード().value();
            if (対象サービス種類.equals(サービス種類１) || 対象サービス種類.equals(サービス種類２)) {
                Decimal 点数合計 = 給付明細列一覧.get給付実績集計データ().get後_単位数合計();
                if (点数合計 == null) {
                    点数合計 = new Decimal(INT_ZERO);
                }
                項目データ = 項目データ.add(点数合計);
            }
        }
        return 項目データ;
    }

    private Decimal get後_保険_出来高単位数合計(List<KyufuJissekiKihonShukeiBusiness> 給付明細列一覧データ,
            RString サービス種類１, RString サービス種類２) {
        Decimal 項目データ = new Decimal(INT_ZERO);
        for (KyufuJissekiKihonShukeiBusiness 給付明細列一覧 : 給付明細列一覧データ) {
            RString 対象サービス種類 = 給付明細列一覧.get給付実績集計データ().getサービス種類コード().value();
            if (対象サービス種類.equals(サービス種類１) || 対象サービス種類.equals(サービス種類２)) {
                Decimal 点数合計 = 給付明細列一覧.get給付実績集計データ().get後_保険_出来高単位数合計();
                if (点数合計 == null) {
                    点数合計 = new Decimal(INT_ZERO);
                }
                項目データ = 項目データ.add(点数合計);
            }
        }
        return 項目データ;
    }

    private Decimal get計画費_後_点数(List<KyufuJissekiKihonKyotakuServiceBusiness> 計画費集計データ,
            RString サービス種類１, RString サービス種類２) {
        Decimal 項目データ = new Decimal(INT_ZERO);
        for (KyufuJissekiKihonKyotakuServiceBusiness 計画費データ : 計画費集計データ) {
            RString 対象サービス種類 = 計画費データ.get給付実績基本居宅サービス計画費データ().getレコード種別コード();
            if (対象サービス種類.equals(サービス種類１) || 対象サービス種類.equals(サービス種類２)) {
                Decimal 点数合計 = 計画費データ.get給付実績基本居宅サービス計画費データ().get後_サービス単位数合計();
                if (点数合計 == null) {
                    点数合計 = new Decimal(INT_ZERO);
                }
                項目データ = 項目データ.add(点数合計);
            }
        }
        return 項目データ;
    }

    private Decimal get項目データ(List<KyufuJissekiKihonShukeiBusiness> 給付明細列一覧データ,
            RString サービス種類１, RString サービス種類２, RString サービス種類３, RString サービス種類４) {
        Decimal 項目データ = new Decimal(INT_ZERO);
        for (KyufuJissekiKihonShukeiBusiness 給付明細列一覧 : 給付明細列一覧データ) {
            RString 対象サービス種類 = 給付明細列一覧.get給付実績集計データ().getサービス種類コード().value();
            if (対象サービス種類.equals(サービス種類１) || 対象サービス種類.equals(サービス種類２)
                    || 対象サービス種類.equals(サービス種類３) || 対象サービス種類.equals(サービス種類４)) {
                Decimal 点数合計 = 給付明細列一覧.get給付実績集計データ().get後_保険_出来高単位数合計();
                if (点数合計 == null) {
                    点数合計 = new Decimal(INT_ZERO);
                }
                項目データ = 項目データ.add(点数合計);
            }
        }
        return 項目データ;
    }

    private RString getデータフォマート(Decimal 項目データ) {
        return DecimalFormatter.toコンマ区切りRString(項目データ, INT_ZERO);
    }

    private Decimal get居宅サービス合計単位(List<KyufuJissekiKihonShukeiBusiness> 給付明細列一覧データ) {
        Decimal 合計 = new Decimal(INT_ZERO);
        合計 = 合計.add(get項目データ(給付明細列一覧データ,
                ServiceCategoryShurui.訪問介護.getコード(), ServiceCategoryShurui.予訪介護.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ,
                ServiceCategoryShurui.訪問入浴.getコード(), ServiceCategoryShurui.予訪入浴.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ,
                ServiceCategoryShurui.訪問看護.getコード(), ServiceCategoryShurui.予訪看護.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ,
                ServiceCategoryShurui.訪問リハ.getコード(), ServiceCategoryShurui.予訪リハ.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ,
                ServiceCategoryShurui.通所介護.getコード(), ServiceCategoryShurui.予通介護.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ,
                ServiceCategoryShurui.通所リハ.getコード(), ServiceCategoryShurui.予通リハ.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ,
                ServiceCategoryShurui.用具貸与.getコード(), ServiceCategoryShurui.予用貸与.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ,
                ServiceCategoryShurui.短期生活.getコード(), ServiceCategoryShurui.予短介護.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ,
                ServiceCategoryShurui.短期老健.getコード(), ServiceCategoryShurui.予短老健.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ,
                ServiceCategoryShurui.短期医療.getコード(), ServiceCategoryShurui.予短医療.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ,
                ServiceCategoryShurui.短期老健.getコード(), ServiceCategoryShurui.短期医療.getコード(),
                ServiceCategoryShurui.予短老健.getコード(), ServiceCategoryShurui.予短医療.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ,
                ServiceCategoryShurui.療養指導.getコード(), ServiceCategoryShurui.予療養指.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ,
                ServiceCategoryShurui.特施短外.getコード(), ServiceCategoryShurui.予特施設.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.特施短期.getコード()));
        return 合計;
    }

    private Decimal get施設サービス合計単位(List<KyufuJissekiKihonShukeiBusiness> 給付明細列一覧データ) {
        Decimal 合計 = new Decimal(INT_ZERO);
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.福祉施設.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.老健施設.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.医療施設.getコード()));
        合計 = 合計.add(get後_保険_出来高単位数合計(給付明細列一覧データ,
                ServiceCategoryShurui.老健施設.getコード(), ServiceCategoryShurui.医療施設.getコード()));
        return 合計;
    }

    private Decimal get地域密着型サービス合計単位(List<KyufuJissekiKihonShukeiBusiness> 給付明細列一覧データ) {
        Decimal 合計 = new Decimal(INT_ZERO);
        合計 = 合計.add(get項目データ(給付明細列一覧データ,
                ServiceCategoryShurui.地共同介.getコード(), ServiceCategoryShurui.地予共同.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.地施短外.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.地施短期.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ,
                ServiceCategoryShurui.地共同短.getコード(), ServiceCategoryShurui.地予共短.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.地夜間訪.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ,
                ServiceCategoryShurui.地通所介.getコード(), ServiceCategoryShurui.地予通所.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ,
                ServiceCategoryShurui.地小短外.getコード(), ServiceCategoryShurui.地予小外.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ,
                ServiceCategoryShurui.地小規単.getコード(), ServiceCategoryShurui.地予小短.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.定期随時.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.看小短外.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.看小規短.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.地域通所.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.地福祉生.getコード()));
        return 合計;
    }

    private Decimal get総合事業合計単位(List<KyufuJissekiKihonShukeiBusiness> 給付明細列一覧データ) {
        Decimal 合計 = new Decimal(INT_ZERO);
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.訪問みな.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.訪問独自.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.訪問定率.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.訪問定額.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.通所みな.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.通所独自.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.通所定率.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.通所定額.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.予防ケア.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.配食定率.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.配食定額.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.見守定率.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.見守定額.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.その他率.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.その他額.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.総訪予防.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.総訪入浴.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.総訪看護.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.総訪リハ.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.総通予防.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.総通リハ.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.総用貸与.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.総短介護.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.総短老健.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.総短医療.getコード()));
        合計 = 合計.add(get後_保険_出来高単位数合計(給付明細列一覧データ,
                ServiceCategoryShurui.総短老健.getコード(), ServiceCategoryShurui.総短医療.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.総療養指.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.総特施設.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.地総通所.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.地総共短.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.地総共同.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.地総小規.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.ケアマネ.getコード()));
        return 合計;
    }

    private Decimal get生活支援サービス合計単位(List<KyufuJissekiKihonShukeiBusiness> 給付明細列一覧データ) {
        Decimal 合計 = new Decimal(INT_ZERO);
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.生活配食.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.生活見守.getコード()));
        合計 = 合計.add(get項目データ(給付明細列一覧データ, ServiceCategoryShurui.生活他.getコード()));
        return 合計;
    }

    private Decimal get集計_後_保険請求分請求額(List<KyufuJissekiKihonShukeiBusiness> 給付明細列一覧データ) {
        Decimal 項目データ = new Decimal(INT_ZERO);
        for (KyufuJissekiKihonShukeiBusiness 給付明細列一覧 : 給付明細列一覧データ) {
            Decimal 点数合計 = 給付明細列一覧.get給付実績集計データ().get後_保険請求分請求額();
            if (点数合計 == null) {
                点数合計 = new Decimal(INT_ZERO);
            }
            項目データ = 項目データ.add(点数合計);
        }
        return 項目データ;
    }

    private Decimal get集計_後_保険請求分請求額(List<KyufuJissekiKihonShukeiBusiness> 給付明細列一覧データ,
            RString サービス種類１, RString サービス種類２) {
        Decimal 項目データ = new Decimal(INT_ZERO);
        for (KyufuJissekiKihonShukeiBusiness 給付明細列一覧 : 給付明細列一覧データ) {
            RString 対象サービス種類 = 給付明細列一覧.get給付実績集計データ().getサービス種類コード().value();
            if (サービス種類１.equals(対象サービス種類) || サービス種類２.equals(対象サービス種類)) {
                Decimal 点数合計 = 給付明細列一覧.get給付実績集計データ().get後_保険請求分請求額();
                if (点数合計 == null) {
                    点数合計 = new Decimal(INT_ZERO);
                }
                項目データ = 項目データ.add(点数合計);
            }
        }
        return 項目データ;
    }

    private Decimal get集計_利用者負担額(List<KyufuJissekiKihonShukeiBusiness> 給付明細列一覧データ) {
        Decimal 項目データ = new Decimal(INT_ZERO);
        for (KyufuJissekiKihonShukeiBusiness 給付明細列一覧 : 給付明細列一覧データ) {
            Decimal 点数合計 = 給付明細列一覧.get給付実績集計データ().get保険_利用者負担額();
            if (点数合計 == null) {
                点数合計 = new Decimal(INT_ZERO);
            }
            項目データ = 項目データ.add(点数合計);
        }
        return 項目データ;
    }

    private Decimal get高額明細_支給額(List<KyufujissekiKogakuKaigoServicehi> 実績高額集計データ) {
        Decimal 項目データ = new Decimal(INT_ZERO);
        for (KyufujissekiKogakuKaigoServicehi 実績高額データ : 実績高額集計データ) {
            Decimal 点数合計 = new Decimal(実績高額データ.get支給額());
            項目データ = 項目データ.add(点数合計);
        }
        return 項目データ;
    }

    private void set一覧対象金額データ(dgKyufuJissekiMeisaiList_Row 明細一覧, int 列, RString 対象金額) {
        switch (列) {
            case INT_ICHI:
                明細一覧.setTxtYM1(対象金額);
                break;
            case INT_NI:
                明細一覧.setTxtYM2(対象金額);
                break;
            case INT_SAN:
                明細一覧.setTxtYM3(対象金額);
                break;
            case INT_YON:
                明細一覧.setTxtYM4(対象金額);
                break;
            case INT_GO:
                明細一覧.setTxtYM5(対象金額);
                break;
            case INT_ROKU:
                明細一覧.setTxtYM6(対象金額);
                break;
            case INT_NANA:
                明細一覧.setTxtYM7(対象金額);
                break;
            case INT_HACHI:
                明細一覧.setTxtYM8(対象金額);
                break;
            case INT_KYU:
                明細一覧.setTxtYM9(対象金額);
                break;
            case INT_JYU:
                明細一覧.setTxtYM10(対象金額);
                break;
            case INT_JYUI:
                明細一覧.setTxtYM11(対象金額);
                break;
            case INT_JYUN:
                明細一覧.setTxtYM12(対象金額);
                break;
            case INT_JYUS:
                明細一覧.setTxtYM13(対象金額);
                break;
            case INT_JYUY:
                明細一覧.setTxtYM14(対象金額);
                break;
            case INT_JYUG:
                明細一覧.setTxtYM15(対象金額);
                break;
            case INT_JYUR:
                明細一覧.setTxtYM16(対象金額);
                break;
            case INT_JYUNA:
                明細一覧.setTxtYM17(対象金額);
                break;
            case INT_JYUH:
                明細一覧.setTxtYM18(対象金額);
                break;
            default:
                set一覧対象金額データ１(明細一覧, 列, 対象金額);
        }
    }

    private void set一覧対象金額データ１(dgKyufuJissekiMeisaiList_Row 明細一覧, int 列, RString 対象金額) {
        switch (列) {
            case INT_JYUK:
                明細一覧.setTxtYM19(対象金額);
                break;
            case INT_NJYU:
                明細一覧.setTxtYM20(対象金額);
                break;
            case INT_NJYUI:
                明細一覧.setTxtYM21(対象金額);
                break;
            case INT_NJYUN:
                明細一覧.setTxtYM22(対象金額);
                break;
            case INT_NJYUS:
                明細一覧.setTxtYM23(対象金額);
                break;
            case INT_NJYUY:
                明細一覧.setTxtYM24(対象金額);
                break;
            case INT_NJYUG:
                明細一覧.setTxtYM25(対象金額);
                break;
            case INT_NJYUR:
                明細一覧.setTxtYM26(対象金額);
                break;
            case INT_NJYUNA:
                明細一覧.setTxtYM27(対象金額);
                break;
            case INT_NJYUH:
                明細一覧.setTxtYM28(対象金額);
                break;
            case INT_NJYUK:
                明細一覧.setTxtYM29(対象金額);
                break;
            case INT_SJYU:
                明細一覧.setTxtYM30(対象金額);
                break;
            case INT_SJYUI:
                明細一覧.setTxtYM31(対象金額);
                break;
            case INT_SJYUN:
                明細一覧.setTxtYM32(対象金額);
                break;
            case INT_SJYUS:
                明細一覧.setTxtYM33(対象金額);
                break;
            case INT_SJYUY:
                明細一覧.setTxtYM34(対象金額);
                break;
            case INT_SJYUG:
                明細一覧.setTxtYM35(対象金額);
                break;
            case INT_SJYUR:
                明細一覧.setTxtYM36(対象金額);
                break;
            default:
                break;
        }
    }

    private void set合計一覧対象金額データ(dgKyufuJissekiGokeiList_Row 合計一覧, int 列, RString 対象金額) {
        switch (列) {
            case INT_ICHI:
                合計一覧.setTxtYM1(対象金額);
                break;
            case INT_NI:
                合計一覧.setTxtYM2(対象金額);
                break;
            case INT_SAN:
                合計一覧.setTxtYM3(対象金額);
                break;
            case INT_YON:
                合計一覧.setTxtYM4(対象金額);
                break;
            case INT_GO:
                合計一覧.setTxtYM5(対象金額);
                break;
            case INT_ROKU:
                合計一覧.setTxtYM6(対象金額);
                break;
            case INT_NANA:
                合計一覧.setTxtYM7(対象金額);
                break;
            case INT_HACHI:
                合計一覧.setTxtYM8(対象金額);
                break;
            case INT_KYU:
                合計一覧.setTxtYM9(対象金額);
                break;
            case INT_JYU:
                合計一覧.setTxtYM10(対象金額);
                break;
            case INT_JYUI:
                合計一覧.setTxtYM11(対象金額);
                break;
            case INT_JYUN:
                合計一覧.setTxtYM12(対象金額);
                break;
            case INT_JYUS:
                合計一覧.setTxtYM13(対象金額);
                break;
            case INT_JYUY:
                合計一覧.setTxtYM14(対象金額);
                break;
            case INT_JYUG:
                合計一覧.setTxtYM15(対象金額);
                break;
            case INT_JYUR:
                合計一覧.setTxtYM16(対象金額);
                break;
            case INT_JYUNA:
                合計一覧.setTxtYM17(対象金額);
                break;
            case INT_JYUH:
                合計一覧.setTxtYM18(対象金額);
                break;
            default:
                set合計一覧対象金額データ１(合計一覧, 列, 対象金額);
        }
    }

    private void set合計一覧対象金額データ１(dgKyufuJissekiGokeiList_Row 合計一覧, int 列, RString 対象金額) {
        switch (列) {
            case INT_JYUK:
                合計一覧.setTxtYM19(対象金額);
                break;
            case INT_NJYU:
                合計一覧.setTxtYM20(対象金額);
                break;
            case INT_NJYUI:
                合計一覧.setTxtYM21(対象金額);
                break;
            case INT_NJYUN:
                合計一覧.setTxtYM22(対象金額);
                break;
            case INT_NJYUS:
                合計一覧.setTxtYM23(対象金額);
                break;
            case INT_NJYUY:
                合計一覧.setTxtYM24(対象金額);
                break;
            case INT_NJYUG:
                合計一覧.setTxtYM25(対象金額);
                break;
            case INT_NJYUR:
                合計一覧.setTxtYM26(対象金額);
                break;
            case INT_NJYUNA:
                合計一覧.setTxtYM27(対象金額);
                break;
            case INT_NJYUH:
                合計一覧.setTxtYM28(対象金額);
                break;
            case INT_NJYUK:
                合計一覧.setTxtYM29(対象金額);
                break;
            case INT_SJYU:
                合計一覧.setTxtYM30(対象金額);
                break;
            case INT_SJYUI:
                合計一覧.setTxtYM31(対象金額);
                break;
            case INT_SJYUN:
                合計一覧.setTxtYM32(対象金額);
                break;
            case INT_SJYUS:
                合計一覧.setTxtYM33(対象金額);
                break;
            case INT_SJYUY:
                合計一覧.setTxtYM34(対象金額);
                break;
            case INT_SJYUG:
                合計一覧.setTxtYM35(対象金額);
                break;
            case INT_SJYUR:
                合計一覧.setTxtYM36(対象金額);
                break;
            default:
                break;
        }
    }

    private static class DateComparator implements Comparator<KeyValueDataSource>, Serializable {

        @Override
        public int compare(KeyValueDataSource o1, KeyValueDataSource o2) {
            return o2.getKey().compareTo(o1.getKey());
        }
    }
}
