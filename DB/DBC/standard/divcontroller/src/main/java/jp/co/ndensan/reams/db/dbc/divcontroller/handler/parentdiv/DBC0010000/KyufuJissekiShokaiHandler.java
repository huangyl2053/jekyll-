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
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho1;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiShokaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.dgKyufuJissekiGokeiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.dgKyufuJissekiMeisaiList_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

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
    private static final int INT_YJYUNA = 47;
    private static final int INT_NJYUNG = 75;
    private static final RString 指定居宅サービス = new RString("指定居宅サービス");
    private static final RString 居宅介護 = new RString("居宅介護");
    private static final RString 指定施設サービス等 = new RString("指定施設サービス等");
    private static final RString 介護予防_日常生活支援総合事業 = new RString("介護予防・日常生活支援総合事業");
    private static final RString 介護予防日常生活支援総合事業 = new RString("介護予防日常生活支援総合事業");
    private static final RString 訪問通所 = new RString("訪問通所");
    private static final RString 短期入所 = new RString("短期入所");
    private static final RString 地域密着 = new RString("地域密着");
    private static final RString 生活支援 = new RString("生活支援");
    private static final RString サービス種類 = new RString("サービス種類");
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
     */
    public void onClick_btnKyufuJissekiSearch(KyufuJissekiHedajyoho1 給付実績ヘッダ情報1,
            FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了) {
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
        setボタン活性非活性の設定(サービス提供年月_開始, サービス提供年月_終了);
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

    // TODO service に検索結果を実装無い
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
            }
        }
    }

    private void set一覧表示() {
        for (int i = INT_ZERO; i < INT_NJYUNG; i++) {
            div.getDgKyufuJissekiMeisaiList().getGridSetting().getColumns().get(i).setVisible(true);
            div.getDgKyufuJissekiGokeiList().getGridSetting().getColumns().get(i).setVisible(true);
        }
    }
//
//    private List<dgKyufuJissekiMeisaiList_Row> get種類明細一覧(int 種類明細一覧行) {
//        List<dgKyufuJissekiMeisaiList_Row> 種類明細一覧 = new ArrayList<>();
//        for (int i = 0; i < 種類明細一覧行; i++) {
//            dgKyufuJissekiMeisaiList_Row row = new dgKyufuJissekiMeisaiList_Row();
//
//        }
//        return 種類明細一覧;
//    }

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
            for (int i = 1; i < INT_YJYUNA; i++) {
                dgKyufuJissekiMeisaiList_Row row = new dgKyufuJissekiMeisaiList_Row();
                rowList.add(row);
            }
        } else {
            for (int i = 1; i < INT_NJYUI; i++) {
                dgKyufuJissekiMeisaiList_Row row = new dgKyufuJissekiMeisaiList_Row();
                rowList.add(row);
            }
        }
        return rowList;
    }

    private List<dgKyufuJissekiGokeiList_Row> get合計空白一覧(RString 検索対象) {
        List<dgKyufuJissekiGokeiList_Row> rowList = new ArrayList<>();
        if (KEY.equals(検索対象)) {
            for (int i = 1; i < INT_JYUI; i++) {
                dgKyufuJissekiGokeiList_Row row = new dgKyufuJissekiGokeiList_Row();
                rowList.add(row);
            }
        } else {
            for (int i = 1; i < INT_GO; i++) {
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
                break;
            case INT_NJYUN:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("定期巡回・随時対応型訪問介護看護"));
                明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_NJYUS:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("複合型（看護小規模多機能型居宅介護・短期以外）"));
                break;
            case INT_NJYUY:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("複合型（看護小規模多機能型居宅介護・短期）"));
                明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
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
                break;
            case INT_NJYUH:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("介護保健施設サービス"));
                break;
            case INT_NJYUK:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("介護療養施設サービス"));
                明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                break;
            case INT_SJYU:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(地域密着);
                明細一覧.setTxtServiceShurui(new RString("地域密着型介護老人福祉施設"));
                break;
            case INT_SJYUI:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("出来高請求費"));
                明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
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
                break;
            case INT_SJYUY:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("訪問型サービス（独自／定率）"));
                明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_SJYUG:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("訪問型サービス（独自／定額）"));
                break;
            case INT_SJYUR:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("通所型サービス（みなし）"));
                明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_SJYUNA:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("通所型サービス（独自）"));
                break;
            case INT_SJYUH:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("通所型サービス（独自／定率）"));
                明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_SJYUK:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("通所型サービス（独自／定額）"));
                break;
            case INT_YJYU:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("介護予防ケアマネジメント"));
                明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_YJYUI:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("その他の生活支援（配食／定率）"));
                break;
            case INT_YJYUN:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("その他の生活支援（配食／定額）"));
                明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_YJYUS:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("その他の生活支援（見守り／定率）"));
                break;
            case INT_YJYUY:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("その他の生活支援（見守り／定額）"));
                明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightYellow);
                break;
            case INT_YJYUG:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("その他の生活支援（その他／定率）"));
                break;
            case INT_YJYUR:
                明細一覧.setTxtServiceGroup1(RString.EMPTY);
                明細一覧.setTxtServiceGroup2(RString.EMPTY);
                明細一覧.setTxtServiceShurui(new RString("その他の生活支援（その他／定額）"));
                明細一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightYellow);
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
                    合計一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
                } else {
                    合計一覧.setTxtServiceGroup1(RString.EMPTY);
                    合計一覧.setTxtServiceGroup2(RString.EMPTY);
                    合計一覧.setTxtServiceShurui(利用者負担額合計);
                    合計一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
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
                合計一覧.setTxtServiceShurui(利用者負担額合計);
                合計一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
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
                合計一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
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
                合計一覧.setCellBgColor(サービス種類.toString(), DataGridCellBgColor.bgColorLightBlue);
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

    private void setボタン活性非活性の設定(FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了) {
        int 列 = サービス提供年月_終了.getBetweenMonths(サービス提供年月_開始) + INT_ICHI;
        if (列 < INT_SJYUNA) {
            div.getBtnSento().setDisabled(true);
            div.getBtnMae().setDisabled(true);
            div.getBtnTsugi().setDisabled(true);
            div.getBtnSaigo().setDisabled(true);
        } else {
            div.getBtnSento().setDisabled(true);
            div.getBtnMae().setDisabled(true);
            div.getBtnTsugi().setDisabled(false);
            div.getBtnSaigo().setDisabled(false);
        }
    }

    private void set列名の設定(int 列, FlexibleYearMonth サービス提供年月_開始, FlexibleYearMonth サービス提供年月_終了) {
        if (INT_ZERO < 列 && 列 % INT_NI == INT_ICHI) {
            RString 列名 = get年度列名(サービス提供年月_開始, サービス提供年月_終了).get(列 / INT_NI - INT_ICHI);
            div.getDgKyufuJissekiMeisaiList().getGridSetting().getColumns().get(列).setGroupName(列名);
            div.getDgKyufuJissekiMeisaiList().getGridSetting().getColumns().get(列 + 1).setGroupName(列名);
        }
    }

    private static class DateComparator implements Comparator<KeyValueDataSource>, Serializable {

        @Override
        public int compare(KeyValueDataSource o1, KeyValueDataSource o2) {
            return o2.getKey().compareTo(o1.getKey());
        }
    }
}
