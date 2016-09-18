/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010012;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiMeisaiJushochiTokurei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiShukei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiMeisaiBusiness;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekiyoshikikubun.KyufuJissekiYoshikiKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010012.KyufuJissekiSyokaiMeisaiSyukeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010012.dgKyufuJissekiMeisaiJustoku_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010012.dgKyufuJissekiMeisai_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010012.dgKyufuJissekiShukei_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 給付実績照会_明細集計画面処理handlerクラスです。
 *
 * @reamsid_L DBC-2970-040 wangxiaodong
 */
public class KyufuJissekiSyokaiMeisaiSyukeiHandler {

    private static final FlexibleYearMonth 平成27年4月 = new FlexibleYearMonth("201504");
    private static final RString 非活性 = new RString("0");
    private static final RString TEXT_後 = new RString("後");
    private static final RString TEXT_前月 = new RString("前月");
    private static final RString TEXT_次月 = new RString("次月");
    private static final RString TEXT_前事業者 = new RString("前事業者");
    private static final RString TEXT_保険 = new RString("保険");
    private static final RString TEXT_公費１ = new RString("公費１");
    private static final RString TEXT_公費２ = new RString("公費２");
    private static final RString TEXT_公費３ = new RString("公費３");
    private static final int INT_ZERO = 0;

    private final KyufuJissekiSyokaiMeisaiSyukeiDiv div;

    /**
     * コンストラクタです
     *
     * @param div KyufuJissekiSyokaiMeisaiSyukeiDiv
     */
    public KyufuJissekiSyokaiMeisaiSyukeiHandler(KyufuJissekiSyokaiMeisaiSyukeiDiv div) {
        this.div = div;
    }

    /**
     * 画面の共有子Divを初期化する。
     *
     * @param 集計情報リスト List<KyufujissekiShukei>
     * @param 明細情報リスト List<KyufujissekiMeisaiBusiness>
     * @param 明細情報特例リスト List<KyufujissekiMeisaiJushochiTokurei>
     * @param 整理番号 RString
     * @param サービス提供年月 FlexibleYearMonth
     * @param 様式番号 RString
     * @param 事業者番号 RString
     */
    public void onLoad(List<KyufujissekiShukei> 集計情報リスト, List<KyufujissekiMeisaiBusiness> 明細情報リスト,
            List<KyufujissekiMeisaiJushochiTokurei> 明細情報特例リスト, RString 整理番号,
            FlexibleYearMonth サービス提供年月, RString 様式番号, RString 事業者番号) {
        set明細情報の表示制御(様式番号, サービス提供年月);
        set明細情報特例の表示制御(様式番号, サービス提供年月);
        setDataGrid総計(get給付実績集計情報(集計情報リスト, 整理番号, 事業者番号, 様式番号, checkDate(サービス提供年月)),
                get給付実績明細情報(明細情報リスト, 整理番号, 事業者番号, 様式番号, checkDate(サービス提供年月)),
                get給付実績明細情報特例(明細情報特例リスト, 整理番号, 事業者番号, 様式番号, checkDate(サービス提供年月)));
        check前次月Btn(getサービス提供年月リスト(集計情報リスト, 明細情報リスト), サービス提供年月);
    }

    /**
     * 画面のデータを設定する。
     *
     * @param 集計情報リスト List<KyufujissekiShukei>
     * @param 明細情報リスト List<KyufujissekiMeisai>
     * @param 明細情報特例リスト List<KyufujissekiMeisaiJushochiTokurei>
     */
    public void setDataGrid総計(List<KyufujissekiShukei> 集計情報リスト,
            List<KyufujissekiMeisaiBusiness> 明細情報リスト,
            List<KyufujissekiMeisaiJushochiTokurei> 明細情報特例リスト) {
        if (!div.getDgKyufuJissekiShukei().isDisplayNone() && !集計情報リスト.isEmpty()) {
            setDataGrid集計情報(集計情報リスト);
        }
        if (!div.getDgKyufuJissekiMeisai().isDisplayNone() && !明細情報リスト.isEmpty()) {
            setDataGrid明細情報(明細情報リスト);
        }
        if (!div.getDgKyufuJissekiMeisaiJustoku().isDisplayNone() && !明細情報特例リスト.isEmpty()) {
            setDataGrid明細情報特例(明細情報特例リスト);
        }
    }

    private void setDataGrid集計情報(List<KyufujissekiShukei> 集計情報リスト) {
        List<dgKyufuJissekiShukei_Row> rowList = new ArrayList<>();
        for (KyufujissekiShukei 集計情報データ : 集計情報リスト) {
            rowList.addAll(set集計情報(集計情報データ));
        }
        div.getDgKyufuJissekiShukei().setDataSource(rowList);
    }

    private void setDataGrid明細情報(List<KyufujissekiMeisaiBusiness> 明細情報リスト) {
        List<dgKyufuJissekiMeisai_Row> rowList = new ArrayList<>();
        List<dgKyufuJissekiMeisai_Row> rowList_後 = new ArrayList<>();
        for (KyufujissekiMeisaiBusiness 明細情報データ : 明細情報リスト) {
            rowList.add(set明細情報(明細情報データ));
            rowList_後.add(set明細情報_後(明細情報データ));
        }
        rowList.addAll(rowList_後);
        div.getDgKyufuJissekiMeisai().setDataSource(rowList);
    }

    private void setDataGrid明細情報特例(List<KyufujissekiMeisaiJushochiTokurei> 明細情報特例リスト) {
        List<dgKyufuJissekiMeisaiJustoku_Row> rowList = new ArrayList<>();
        List<dgKyufuJissekiMeisaiJustoku_Row> rowList_後 = new ArrayList<>();
        for (KyufujissekiMeisaiJushochiTokurei 明細情報特例データ : 明細情報特例リスト) {
            rowList.add(set明細情報特例(明細情報特例データ));
            rowList_後.add(set明細情報特例_後(明細情報特例データ));
        }
        rowList.addAll(rowList_後);
        div.getDgKyufuJissekiMeisaiJustoku().setDataSource(rowList);
    }

    /**
     * ボタン状態の設定です。
     *
     * @param 識別番号管理 ShikibetsuNoKanri
     * @param サービス提供年月 FlexibleYearMonth
     */
    public void setButton(ShikibetsuNoKanri 識別番号管理, FlexibleYearMonth サービス提供年月) {
        if (非活性.equals(識別番号管理.get基本設定区分())) {
            div.getBtnKihon().setDisabled(true);
        } else {
            div.getBtnKihon().setDisabled(false);
        }
        div.getBtnMeisaiShukei().setDisabled(true);
        if (非活性.equals(識別番号管理.get緊急時施設療養設定区分())) {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(false);
        }
        if (非活性.equals(識別番号管理.get所定疾患施設療養設定区分())) {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(false);
        }
        if (非活性.equals(識別番号管理.get食事費用設定区分())) {
            div.getBtnShokuji().setDisabled(true);
        } else {
            div.getBtnShokuji().setDisabled(false);
        }
        if (非活性.equals(識別番号管理.get福祉用具購入費設定区分())) {
            div.getBtnFukushiYoguKonyu().setDisabled(true);
        } else {
            div.getBtnFukushiYoguKonyu().setDisabled(false);
        }
        addButtonSet(識別番号管理);
    }

    private void addButtonSet(ShikibetsuNoKanri 識別番号管理) {
        if (非活性.equals(識別番号管理.get特定入所者設定区分())) {
            div.getBtnTokuteiNyushosha().setDisabled(true);
        } else {
            div.getBtnTokuteiNyushosha().setDisabled(false);
        }
        if (非活性.equals(識別番号管理.get高額介護サービス費設定区分())) {
            div.getBtnKogakuKaigoService().setDisabled(true);
        } else {
            div.getBtnKogakuKaigoService().setDisabled(false);
        }
        if (非活性.equals(識別番号管理.get特定診療費設定区分())) {
            div.getBtnTokuteiShinryo().setDisabled(true);
        } else {
            div.getBtnTokuteiShinryo().setDisabled(false);
        }
        if (非活性.equals(識別番号管理.get居宅計画費設定区分())) {
            div.getBtnKyotakuServiceKeikaku().setDisabled(true);
        } else {
            div.getBtnKyotakuServiceKeikaku().setDisabled(false);
        }
        if (非活性.equals(識別番号管理.get住宅改修費設定区分())) {
            div.getBtnJutakuKaishu().setDisabled(true);
        } else {
            div.getBtnJutakuKaishu().setDisabled(false);
        }
        if (非活性.equals(識別番号管理.getケアマネジメント設定区分())) {
            div.getBtnCareManagement().setDisabled(true);
        } else {
            div.getBtnCareManagement().setDisabled(false);
        }
        if (非活性.equals(識別番号管理.get社会福祉法人軽減設定区分())) {
            div.getBtnShafukuKeigen().setDisabled(true);
        } else {
            div.getBtnShafukuKeigen().setDisabled(false);
        }
    }

    /**
     * 事業者番号の設定です。
     *
     * @param 事業者番号リスト List<KyufuJissekiHedajyoho2>
     * @param 整理番号 RString
     * @param 事業者番号 RString
     * @param 様式番号 RString
     * @param サービス提供年月 RString
     * @param 実績区分コード RString
     * @return index index
     */
    public int get事業者番号index(List<KyufuJissekiHedajyoho2> 事業者番号リスト, RString 整理番号, RString 事業者番号,
            RString 様式番号, RString サービス提供年月, RString 実績区分コード) {
        for (int index = 0; index < 事業者番号リスト.size(); index++) {
            if (事業者番号.equals(事業者番号リスト.get(index).get事業所番号().value())
                    && 整理番号.equals(事業者番号リスト.get(index).get整理番号())
                    && 様式番号.equals(事業者番号リスト.get(index).get識別番号())
                    && サービス提供年月.equals(事業者番号リスト.get(index).getサービス提供年月().toDateString())
                    && 実績区分コード.equals(事業者番号リスト.get(index).get給付実績区分コード())) {
                return index;
            }
        }
        return INT_ZERO;
    }

    /**
     * change年月です。
     *
     * @param data RString
     * @param 被保険者番号 HihokenshaNo
     * @param 集計情報リスト List<KyufujissekiShukei>
     * @param 明細情報リスト List<KyufujissekiMeisaiBusiness>
     * @param 明細情報特例リスト List<KyufujissekiMeisaiJushochiTokurei>
     * @param 事業者番号リスト List<KyufuJissekiHedajyoho2>
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 識別番号 NyuryokuShikibetsuNo
     */
    public void change年月(RString data, HihokenshaNo 被保険者番号, List<KyufujissekiShukei> 集計情報リスト,
            List<KyufujissekiMeisaiBusiness> 明細情報リスト, List<KyufujissekiMeisaiJushochiTokurei> 明細情報特例リスト,
            List<KyufuJissekiHedajyoho2> 事業者番号リスト, FlexibleYearMonth サービス提供年月, RString 整理番号,
            NyuryokuShikibetsuNo 識別番号) {

        List<KyufujissekiShukei> 集計情報取得リスト = new ArrayList<>();
        List<KyufujissekiMeisaiBusiness> 明細情報取得リスト = new ArrayList<>();
        for (KyufujissekiShukei 集計情報取得 : 集計情報リスト) {
            if (div.getCcdKyufuJissekiHeader().get事業者番号().equals(集計情報取得.get事業所番号().value())) {
                集計情報取得リスト.add(集計情報取得);
            }
        }
        for (KyufujissekiMeisaiBusiness 明細情報取得 : 明細情報取得リスト) {
            if (div.getCcdKyufuJissekiHeader().get事業者番号().equals(明細情報取得.get給付実績明細().get事業所番号().value())) {
                明細情報取得リスト.add(明細情報取得);
            }
        }
        int index = INT_ZERO;
        List<FlexibleYearMonth> サービス提供年月リスト = getサービス提供年月リスト(集計情報取得リスト, 明細情報取得リスト);
        Collections.sort(サービス提供年月リスト, new DateComparatorServiceTeikyoYM());
        for (int i = 0; i < サービス提供年月リスト.size(); i++) {
            if (サービス提供年月.equals(サービス提供年月リスト.get(i))) {
                index = i;
                break;
            }
        }
        FlexibleYearMonth 今提供年月 = サービス提供年月;
        if (INT_ZERO <= index && index <= サービス提供年月リスト.size() - 1) {
            if (TEXT_前月.equals(data) && index != サービス提供年月リスト.size() - 1) {
                今提供年月 = サービス提供年月リスト.get(index + 1);
            } else if (TEXT_次月.equals(data) && INT_ZERO != index) {
                今提供年月 = サービス提供年月リスト.get(index - 1);
            }
        }
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        RString 実績区分コード = div.getCcdKyufuJissekiHeader().get実績区分コード();
        div.getCcdKyufuJissekiHeader().initialize(被保険者番号, 今提供年月, 整理番号, 識別番号);
        setDataGrid総計(get給付実績集計情報(集計情報リスト, 整理番号, 事業者番号, 様式番号, サービス提供年月.toDateString()),
                get給付実績明細情報(明細情報リスト, 整理番号, 事業者番号, 様式番号, サービス提供年月.toDateString()),
                get給付実績明細情報特例(明細情報特例リスト, 整理番号, 事業者番号, 様式番号, サービス提供年月.toDateString()));
        check前次月Btn(サービス提供年月リスト, 今提供年月);
        check事業者Btn(事業者番号リスト, 整理番号, 事業者番号, 様式番号, サービス提供年月.toDateString(), 実績区分コード);
    }

    /**
     * change事業者です。
     *
     * @param data RString
     * @param 事業者番号リスト List<KyufuJissekiHedajyoho2>
     * @param 集計情報リスト List<KyufujissekiShukei>
     * @param 明細情報リスト List<KyufujissekiMeisaiBusiness>
     * @param 明細情報特例リスト List<KyufujissekiMeisaiJushochiTokurei>
     */
    public void change事業者(RString data, List<KyufuJissekiHedajyoho2> 事業者番号リスト,
            List<KyufujissekiShukei> 集計情報リスト, List<KyufujissekiMeisaiBusiness> 明細情報リスト,
            List<KyufujissekiMeisaiJushochiTokurei> 明細情報特例リスト) {
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 整理番号 = div.getCcdKyufuJissekiHeader().get整理番号();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        RString 実績区分コード = div.getCcdKyufuJissekiHeader().get実績区分コード();
        RString サービス提供年月 = div.getCcdKyufuJissekiHeader().getサービス提供年月().getYearMonth().toDateString();
        List<FlexibleYearMonth> サービス提供年月リスト = new ArrayList<>();
        List<KyufujissekiShukei> 集計情報取得リスト = new ArrayList<>();
        List<KyufujissekiMeisaiBusiness> 明細情報取得リスト = new ArrayList<>();
        set明細情報の表示制御(様式番号, new FlexibleYearMonth(サービス提供年月));
        set明細情報特例の表示制御(様式番号, new FlexibleYearMonth(サービス提供年月));
        int index = get事業者番号index(事業者番号リスト, 整理番号, 事業者番号, 様式番号, サービス提供年月, 実績区分コード);
        int i;
        if (TEXT_前事業者.equals(data)) {
            i = -1;
        } else {
            i = 1;
        }
        if (index + i < 事業者番号リスト.size() && -1 < index + i) {
            div.getCcdKyufuJissekiHeader().set事業者名称(事業者番号リスト.get(index + i).get事業者名称());
            div.getCcdKyufuJissekiHeader().set事業者番号(事業者番号リスト.get(index + i).get事業所番号().value());
            div.getCcdKyufuJissekiHeader().set実績区分(事業者番号リスト.get(index + i).get給付実績区分コード());
            div.getCcdKyufuJissekiHeader().set整理番号(事業者番号リスト.get(index + i).get整理番号());
            div.getCcdKyufuJissekiHeader().set識別番号名称(事業者番号リスト.get(index + i).get識別番号名称());
            div.getCcdKyufuJissekiHeader().set様式番号(事業者番号リスト.get(index + i).get識別番号());
            for (KyufujissekiShukei 集計情報取得 : 集計情報リスト) {
                if (事業者番号リスト.get(index + i).get事業所番号().value().equals(集計情報取得.get事業所番号().value())) {
                    集計情報取得リスト.add(集計情報取得);
                }
            }
            for (KyufujissekiMeisaiBusiness 明細情報取得 : 明細情報取得リスト) {
                if (事業者番号リスト.get(index + i).get事業所番号().value().equals(明細情報取得.get給付実績明細().get事業所番号().value())) {
                    明細情報取得リスト.add(明細情報取得);
                }
            }
            setDataGrid総計(get給付実績集計情報(集計情報リスト, 整理番号, 事業者番号リスト.get(index + i).get事業所番号().value(), 様式番号, サービス提供年月),
                    get給付実績明細情報(明細情報リスト, 整理番号, 事業者番号リスト.get(index + i).get事業所番号().value(), 様式番号, サービス提供年月),
                    get給付実績明細情報特例(明細情報特例リスト, 整理番号, 事業者番号リスト.get(index + i).get事業所番号().value(), 様式番号, サービス提供年月));
            サービス提供年月リスト = getサービス提供年月リスト(集計情報取得リスト, 明細情報取得リスト);
        }
        Collections.sort(サービス提供年月リスト, new DateComparatorServiceTeikyoYM());
        div.getBtnMaeJigyosha().setDisabled(true);
        div.getBtnAtoJigyosha().setDisabled(true);
        if (0 < index + i) {
            div.getBtnMaeJigyosha().setDisabled(false);
        }
        if (index + i + 1 < 事業者番号リスト.size()) {
            div.getBtnAtoJigyosha().setDisabled(false);
        }
        check前次月Btn(サービス提供年月リスト, new FlexibleYearMonth(サービス提供年月));
    }

    private List<FlexibleYearMonth> getサービス提供年月リスト(List<KyufujissekiShukei> 集計情報リスト,
            List<KyufujissekiMeisaiBusiness> 明細情報リスト) {
        List<FlexibleYearMonth> 提供年月リスト = new ArrayList<>();
        for (KyufujissekiShukei 集計情報 : 集計情報リスト) {
            FlexibleYearMonth 提供年月 = 集計情報.getサービス提供年月();
            if (!提供年月リスト.contains(提供年月)) {
                提供年月リスト.add(提供年月);
            }
        }
        for (KyufujissekiMeisaiBusiness 明細情報 : 明細情報リスト) {
            FlexibleYearMonth 提供年月 = 明細情報.get給付実績明細().getサービス提供年月();
            if (!提供年月リスト.contains(提供年月)) {
                提供年月リスト.add(提供年月);
            }
        }
        return 提供年月リスト;
    }

    /**
     * get給付実績明細データです。
     *
     * @param 給付実績明細リスト List<KyufujissekiMeisaiBusiness>
     * @param 整理番号 RString
     * @param 様式番号 RString
     * @param 事業者番号 RString
     * @param サービス提供年月 RString
     * @return 給付実績明細データ List<KyufujissekiMeisaiBusiness>
     */
    public List<KyufujissekiMeisaiBusiness> get給付実績明細情報(List<KyufujissekiMeisaiBusiness> 給付実績明細リスト, RString 整理番号,
            RString 事業者番号, RString 様式番号, RString サービス提供年月) {
        List<KyufujissekiMeisaiBusiness> 給付実績明細データ = new ArrayList<>();
        for (KyufujissekiMeisaiBusiness 給付実績明細 : 給付実績明細リスト) {
            if (事業者番号.equals(給付実績明細.get給付実績明細().get事業所番号().value())
                    && 整理番号.equals(給付実績明細.get給付実績明細().get整理番号())
                    && 様式番号.equals(給付実績明細.get給付実績明細().get入力識別番号().value())
                    && サービス提供年月.equals(給付実績明細.get給付実績明細().getサービス提供年月().toDateString())) {
                給付実績明細データ.add(給付実績明細);
            }
        }
        return 給付実績明細データ;
    }

    /**
     * get給付実績集計データです。
     *
     * @param 給付実績集計リスト List<KyufujissekiShukei>
     * @param 整理番号 RString
     * @param 様式番号 RString
     * @param 事業者番号 RString
     * @param サービス提供年月 RString
     * @return 給付実績明細データ List<KyufujissekiShukei>
     */
    public List<KyufujissekiShukei> get給付実績集計情報(List<KyufujissekiShukei> 給付実績集計リスト, RString 整理番号,
            RString 事業者番号, RString 様式番号, RString サービス提供年月) {
        List<KyufujissekiShukei> 給付実績集計データ = new ArrayList<>();
        for (KyufujissekiShukei 給付実績集計 : 給付実績集計リスト) {
            if (事業者番号.equals(給付実績集計.get事業所番号().value())
                    && 整理番号.equals(給付実績集計.get整理番号())
                    && 様式番号.equals(給付実績集計.get入力識別番号().value())
                    && サービス提供年月.equals(給付実績集計.getサービス提供年月().toDateString())) {
                給付実績集計データ.add(給付実績集計);
            }
        }
        return 給付実績集計データ;
    }

    /**
     * get給付実績明細データです。
     *
     * @param 給付実績明細情報特例リスト List<KyufujissekiMeisaiJushochiTokurei>
     * @param 整理番号 RString
     * @param 様式番号 RString
     * @param 事業者番号 RString
     * @param サービス提供年月 RString
     * @return 給付実績明細データ List<KyufujissekiMeisaiJushochiTokurei>
     */
    public List<KyufujissekiMeisaiJushochiTokurei> get給付実績明細情報特例(
            List<KyufujissekiMeisaiJushochiTokurei> 給付実績明細情報特例リスト, RString 整理番号,
            RString 事業者番号, RString 様式番号, RString サービス提供年月) {
        List<KyufujissekiMeisaiJushochiTokurei> 給付実績明細情報特例データ = new ArrayList<>();
        for (KyufujissekiMeisaiJushochiTokurei 給付実績明細情報特例 : 給付実績明細情報特例リスト) {
            if (事業者番号.equals(給付実績明細情報特例.get事業所番号().value())
                    && 整理番号.equals(給付実績明細情報特例.get整理番号())
                    && 様式番号.equals(給付実績明細情報特例.get入力識別番号().value())
                    && サービス提供年月.equals(給付実績明細情報特例.getサービス提供年月().toDateString())) {
                給付実績明細情報特例データ.add(給付実績明細情報特例);
            }
        }
        return 給付実績明細情報特例データ;
    }

    /**
     * 前次月ボタン状態設定。
     *
     * @param サービス提供年月リスト サービス提供年月リスト
     * @param サービス提供年月 サービス提供年月
     */
    public void check前次月Btn(List<FlexibleYearMonth> サービス提供年月リスト, FlexibleYearMonth サービス提供年月) {
        Collections.sort(サービス提供年月リスト, new DateComparatorServiceTeikyoYM());

        if (サービス提供年月.isBeforeOrEquals(サービス提供年月リスト.get(サービス提供年月リスト.size() - 1))) {
            div.getBtnZengetsu().setDisabled(true);
        } else {
            div.getBtnZengetsu().setDisabled(false);
        }
        if (サービス提供年月リスト.get(INT_ZERO).isBeforeOrEquals(サービス提供年月)) {
            div.getBtnJigetsu().setDisabled(true);
        } else {
            div.getBtnJigetsu().setDisabled(false);
        }
    }

    /**
     * 事業者btnのstateです。
     *
     * @param 事業者番号リスト List<KyufuJissekiHedajyoho2>
     * @param 整理番号 RString
     * @param 様式番号 RString
     * @param 事業者番号 RString
     * @param サービス提供年月 RString
     * @param 実績区分コード RString
     */
    public void check事業者Btn(List<KyufuJissekiHedajyoho2> 事業者番号リスト, RString 整理番号, RString 事業者番号,
            RString 様式番号, RString サービス提供年月, RString 実績区分コード) {
        if (!事業者番号リスト.isEmpty()) {
            div.getBtnMaeJigyosha().setDisabled(true);
            div.getBtnAtoJigyosha().setDisabled(true);
            int index = get事業者番号index(事業者番号リスト, 整理番号, 事業者番号, 様式番号, サービス提供年月, 実績区分コード);
            if (0 < index) {
                div.getBtnMaeJigyosha().setDisabled(false);
            }
            if (index + 1 < 事業者番号リスト.size()) {
                div.getBtnAtoJigyosha().setDisabled(false);
            }
        }
    }

    private void set明細情報の表示制御(RString 様式番号, FlexibleYearMonth サービス提供年月) {
        KyufuJissekiYoshikiKubun 基準様式番号 = KyufuJissekiYoshikiKubun.toValue(様式番号);
        if (KyufuJissekiYoshikiKubun._21C1_福祉用具販売費.equals(基準様式番号)
                || KyufuJissekiYoshikiKubun._21C2_予防用具販売費.equals(基準様式番号)
                || KyufuJissekiYoshikiKubun._21D1_住宅改修費.equals(基準様式番号)
                || KyufuJissekiYoshikiKubun._21D2_予防住宅改修費.equals(基準様式番号)) {
            div.getDgKyufuJissekiMeisai().setDisplayNone(true);
        } else if (平成27年4月.isBeforeOrEquals(サービス提供年月)) {
            if (KyufuJissekiYoshikiKubun._7131_様式第二.equals(基準様式番号)
                    && KyufuJissekiYoshikiKubun._2131_様式第二.equals(基準様式番号)) {
                div.getDgKyufuJissekiMeisai().setDisplayNone(false);
            }
            if (KyufuJissekiYoshikiKubun._7132_様式第二の二.equals(基準様式番号)
                    && KyufuJissekiYoshikiKubun._2132_様式第二の二.equals(基準様式番号)) {
                div.getDgKyufuJissekiMeisai().setDisplayNone(false);
            }
        } else if (KyufuJissekiYoshikiKubun._71R1_様式第二の三.equals(基準様式番号)
                || KyufuJissekiYoshikiKubun._8171_様式第七の三.equals(基準様式番号)) {
            div.getDgKyufuJissekiMeisai().setDisplayNone(false);
        } else {
            div.getDgKyufuJissekiMeisai().setDisplayNone(true);
        }
    }

    private void set明細情報特例の表示制御(RString 様式番号, FlexibleYearMonth サービス提供年月) {
        KyufuJissekiYoshikiKubun 基準様式番号 = KyufuJissekiYoshikiKubun.toValue(様式番号);
        if (平成27年4月.isBeforeOrEquals(サービス提供年月)) {
            if (KyufuJissekiYoshikiKubun._7131_様式第二.equals(基準様式番号)
                    && KyufuJissekiYoshikiKubun._2131_様式第二.equals(基準様式番号)) {
                div.getDgKyufuJissekiMeisaiJustoku().setDisplayNone(false);
            }
            if (KyufuJissekiYoshikiKubun._7132_様式第二の二.equals(基準様式番号)
                    && KyufuJissekiYoshikiKubun._2132_様式第二の二.equals(基準様式番号)) {
                div.getDgKyufuJissekiMeisaiJustoku().setDisplayNone(false);
            }
        } else if (KyufuJissekiYoshikiKubun._71R1_様式第二の三.equals(基準様式番号)
                || KyufuJissekiYoshikiKubun._8171_様式第七の三.equals(基準様式番号)) {
            div.getDgKyufuJissekiMeisaiJustoku().setDisplayNone(false);
        } else {
            div.getDgKyufuJissekiMeisaiJustoku().setDisplayNone(true);
        }
    }

    private List<dgKyufuJissekiShukei_Row> set集計情報(KyufujissekiShukei 集計情報) {
        List<dgKyufuJissekiShukei_Row> rowList = new ArrayList<>();

        dgKyufuJissekiShukei_Row row_保険 = new dgKyufuJissekiShukei_Row();
        row_保険.setTxtServiceShurui(setサービス種類(集計情報.getサービス種類コード()));
        row_保険.setTxtJitsuNissu(new RString(集計情報.getサービス実日数()));
        row_保険.setTxtKeikakuTani(checkDecimal(集計情報.get計画単位数()));
        row_保険.setTxtTaishoTani(checkDecimal(集計情報.get限度額管理対象単位数()));
        row_保険.setTxtTaishogaiTani(checkDecimal(集計情報.get限度額管理対象外単位数()));
        row_保険.setTxtTankiKeikakuNissu(new RString(集計情報.get短期入所計画日数()));
        row_保険.setTxtHokenKohi(TEXT_保険);
        row_保険.setTxtKettei(RString.EMPTY);
        row_保険.setTxtTankiJitsuNissu(new RString(集計情報.get短期入所実日数()));
        row_保険.setTxtTaniGokei(kinngakuFormat(集計情報.get保険_単位数合計()));
        row_保険.setTxtTanisuTanka(kinngakuFormat(集計情報.get保険_単位数単価()));
        row_保険.setTxtSeikyugaku(kinngakuFormat(集計情報.get保険_請求額()));
        row_保険.setTxtRiyoshaFutangaku(kinngakuFormat(集計情報.get保険_利用者負担額()));
        row_保険.setTxtDekidakaTaniGokei(kinngakuFormat(集計情報.get保険_出来高単位数合計()));
        row_保険.setTxtDekidakaSeikyugaku(kinngakuFormat(集計情報.get保険_出来高請求額()));
        row_保険.setTxtDekidakaHonninFutangaku(kinngakuFormat(集計情報.get保険_出来高医療費利用者負担額()));
        row_保険.setTxtSaiShinsaKaisu(new RString(集計情報.get再審査回数()));
        row_保険.setTxtKagoKaisu(new RString(集計情報.get過誤回数()));
        row_保険.setTxtShinsaYM(checkDate(集計情報.get審査年月()));
        rowList.add(row_保険);

        dgKyufuJissekiShukei_Row row_後_保険 = new dgKyufuJissekiShukei_Row();
        row_後_保険.setTxtServiceShurui(RString.EMPTY);
        row_後_保険.setTxtJitsuNissu(RString.EMPTY);
        row_後_保険.setTxtKeikakuTani(RString.EMPTY);
        row_後_保険.setTxtTaishoTani(RString.EMPTY);
        row_後_保険.setTxtTaishogaiTani(RString.EMPTY);
        row_後_保険.setTxtTankiKeikakuNissu(RString.EMPTY);
        row_後_保険.setTxtHokenKohi(RString.EMPTY);
        row_後_保険.setTxtKettei(TEXT_後);
        row_後_保険.setTxtTankiJitsuNissu(new RString(集計情報.get後_短期入所実日数()));
        row_後_保険.setTxtTaniGokei(kinngakuFormat(集計情報.get後_単位数合計()));
        row_後_保険.setTxtTanisuTanka(kinngakuFormat(集計情報.get保険_単位数単価()));
        row_後_保険.setTxtSeikyugaku(kinngakuFormat(集計情報.get後_保険請求分請求額()));
        row_後_保険.setTxtRiyoshaFutangaku(kinngakuFormat(集計情報.get保険_利用者負担額()));
        row_後_保険.setTxtDekidakaTaniGokei(kinngakuFormat(集計情報.get後_保険_出来高単位数合計()));
        row_後_保険.setTxtDekidakaSeikyugaku(kinngakuFormat(集計情報.get後_保険_出来高請求額()));
        row_後_保険.setTxtDekidakaHonninFutangaku(RString.EMPTY);
        row_後_保険.setTxtSaiShinsaKaisu(new RString(集計情報.get再審査回数()));
        row_後_保険.setTxtKagoKaisu(new RString(集計情報.get過誤回数()));
        row_後_保険.setTxtShinsaYM(checkDate(集計情報.get審査年月()));
        rowList.add(row_後_保険);

        dgKyufuJissekiShukei_Row row_公費１ = new dgKyufuJissekiShukei_Row();
        row_公費１.setTxtServiceShurui(RString.EMPTY);
        row_公費１.setTxtJitsuNissu(RString.EMPTY);
        row_公費１.setTxtKeikakuTani(RString.EMPTY);
        row_公費１.setTxtTaishoTani(RString.EMPTY);
        row_公費１.setTxtTaishogaiTani(RString.EMPTY);
        row_公費１.setTxtTankiKeikakuNissu(RString.EMPTY);
        row_公費１.setTxtHokenKohi(TEXT_公費１);
        row_公費１.setTxtKettei(RString.EMPTY);
        row_公費１.setTxtTankiJitsuNissu(new RString(集計情報.get短期入所実日数()));
        row_公費１.setTxtTaniGokei(kinngakuFormat(集計情報.get公費１_単位数合計()));
        row_公費１.setTxtTanisuTanka(RString.EMPTY);
        row_公費１.setTxtSeikyugaku(kinngakuFormat(集計情報.get公費１_請求額()));
        row_公費１.setTxtRiyoshaFutangaku(RString.EMPTY);
        row_公費１.setTxtDekidakaTaniGokei(kinngakuFormat(集計情報.get公費１_出来高単位数合計()));
        row_公費１.setTxtDekidakaSeikyugaku(kinngakuFormat(集計情報.get公費１_出来高請求額()));
        row_公費１.setTxtDekidakaHonninFutangaku(kinngakuFormat(集計情報.get公費１_出来高医療費利用者負担額()));
        row_公費１.setTxtSaiShinsaKaisu(new RString(集計情報.get再審査回数()));
        row_公費１.setTxtKagoKaisu(new RString(集計情報.get過誤回数()));
        row_公費１.setTxtShinsaYM(checkDate(集計情報.get審査年月()));
        rowList.add(row_公費１);

        dgKyufuJissekiShukei_Row row_後_公費１ = new dgKyufuJissekiShukei_Row();
        row_後_公費１.setTxtServiceShurui(RString.EMPTY);
        row_後_公費１.setTxtJitsuNissu(RString.EMPTY);
        row_後_公費１.setTxtKeikakuTani(RString.EMPTY);
        row_後_公費１.setTxtTaishoTani(RString.EMPTY);
        row_後_公費１.setTxtTaishogaiTani(RString.EMPTY);
        row_後_公費１.setTxtTankiKeikakuNissu(RString.EMPTY);
        row_後_公費１.setTxtHokenKohi(RString.EMPTY);
        row_後_公費１.setTxtKettei(TEXT_後);
        row_後_公費１.setTxtTankiJitsuNissu(new RString(集計情報.get後_短期入所実日数()));
        row_後_公費１.setTxtTaniGokei(kinngakuFormat(集計情報.get後_公費１_単位数合計()));
        row_後_公費１.setTxtTanisuTanka(RString.EMPTY);
        row_後_公費１.setTxtSeikyugaku(kinngakuFormat(集計情報.get後_公費１_請求額()));
        row_後_公費１.setTxtRiyoshaFutangaku(RString.EMPTY);
        row_後_公費１.setTxtDekidakaTaniGokei(kinngakuFormat(集計情報.get後_公費１_出来高単位数合計()));
        row_後_公費１.setTxtDekidakaSeikyugaku(kinngakuFormat(集計情報.get後_公費１_出来高請求額()));
        row_後_公費１.setTxtDekidakaHonninFutangaku(RString.EMPTY);
        row_後_公費１.setTxtSaiShinsaKaisu(new RString(集計情報.get再審査回数()));
        row_後_公費１.setTxtKagoKaisu(new RString(集計情報.get過誤回数()));
        row_後_公費１.setTxtShinsaYM(checkDate(集計情報.get審査年月()));
        rowList.add(row_後_公費１);
        rowList.addAll(addSet集計情報(集計情報));
        return rowList;
    }

    private List<dgKyufuJissekiShukei_Row> addSet集計情報(KyufujissekiShukei 集計情報) {
        List<dgKyufuJissekiShukei_Row> rowList = new ArrayList<>();

        dgKyufuJissekiShukei_Row row_公費２ = new dgKyufuJissekiShukei_Row();
        row_公費２.setTxtServiceShurui(RString.EMPTY);
        row_公費２.setTxtJitsuNissu(RString.EMPTY);
        row_公費２.setTxtKeikakuTani(RString.EMPTY);
        row_公費２.setTxtTaishoTani(RString.EMPTY);
        row_公費２.setTxtTaishogaiTani(RString.EMPTY);
        row_公費２.setTxtTankiKeikakuNissu(RString.EMPTY);
        row_公費２.setTxtHokenKohi(TEXT_公費２);
        row_公費２.setTxtKettei(RString.EMPTY);
        row_公費２.setTxtTankiJitsuNissu(new RString(集計情報.get短期入所実日数()));
        row_公費２.setTxtTaniGokei(kinngakuFormat(集計情報.get公費２_単位数合計()));
        row_公費２.setTxtTanisuTanka(RString.EMPTY);
        row_公費２.setTxtSeikyugaku(kinngakuFormat(集計情報.get公費２_請求額()));
        row_公費２.setTxtRiyoshaFutangaku(RString.EMPTY);
        row_公費２.setTxtDekidakaTaniGokei(kinngakuFormat(集計情報.get公費２_出来高単位数合計()));
        row_公費２.setTxtDekidakaSeikyugaku(kinngakuFormat(集計情報.get公費２_出来高請求額()));
        row_公費２.setTxtDekidakaHonninFutangaku(RString.EMPTY);
        row_公費２.setTxtSaiShinsaKaisu(new RString(集計情報.get再審査回数()));
        row_公費２.setTxtKagoKaisu(new RString(集計情報.get過誤回数()));
        row_公費２.setTxtShinsaYM(checkDate(集計情報.get審査年月()));
        rowList.add(row_公費２);

        dgKyufuJissekiShukei_Row row_後_公費２ = new dgKyufuJissekiShukei_Row();
        row_後_公費２.setTxtServiceShurui(RString.EMPTY);
        row_後_公費２.setTxtJitsuNissu(RString.EMPTY);
        row_後_公費２.setTxtKeikakuTani(RString.EMPTY);
        row_後_公費２.setTxtTaishoTani(RString.EMPTY);
        row_後_公費２.setTxtTaishogaiTani(RString.EMPTY);
        row_後_公費２.setTxtTankiKeikakuNissu(RString.EMPTY);
        row_後_公費２.setTxtHokenKohi(RString.EMPTY);
        row_後_公費２.setTxtKettei(TEXT_後);
        row_後_公費２.setTxtTankiJitsuNissu(new RString(集計情報.get後_短期入所実日数()));
        row_後_公費２.setTxtTaniGokei(kinngakuFormat(集計情報.get後_公費２_単位数合計()));
        row_後_公費２.setTxtTanisuTanka(RString.EMPTY);
        row_後_公費２.setTxtSeikyugaku(kinngakuFormat(集計情報.get後_公費２_請求額()));
        row_後_公費２.setTxtRiyoshaFutangaku(RString.EMPTY);
        row_後_公費２.setTxtDekidakaTaniGokei(kinngakuFormat(集計情報.get後_公費２_出来高単位数合計()));
        row_後_公費２.setTxtDekidakaSeikyugaku(kinngakuFormat(集計情報.get後_公費２_出来高請求額()));
        row_後_公費２.setTxtDekidakaHonninFutangaku(RString.EMPTY);
        row_後_公費２.setTxtSaiShinsaKaisu(new RString(集計情報.get再審査回数()));
        row_後_公費２.setTxtKagoKaisu(new RString(集計情報.get過誤回数()));
        row_後_公費２.setTxtShinsaYM(checkDate(集計情報.get審査年月()));
        rowList.add(row_後_公費２);

        dgKyufuJissekiShukei_Row row_公費３ = new dgKyufuJissekiShukei_Row();
        row_公費３.setTxtServiceShurui(RString.EMPTY);
        row_公費３.setTxtJitsuNissu(RString.EMPTY);
        row_公費３.setTxtKeikakuTani(RString.EMPTY);
        row_公費３.setTxtTaishoTani(RString.EMPTY);
        row_公費３.setTxtTaishogaiTani(RString.EMPTY);
        row_公費３.setTxtTankiKeikakuNissu(RString.EMPTY);
        row_公費３.setTxtHokenKohi(TEXT_公費３);
        row_公費３.setTxtKettei(RString.EMPTY);
        row_公費３.setTxtTankiJitsuNissu(new RString(集計情報.get短期入所実日数()));
        row_公費３.setTxtTaniGokei(kinngakuFormat(集計情報.get公費３_単位数合計()));
        row_公費３.setTxtTanisuTanka(RString.EMPTY);
        row_公費３.setTxtSeikyugaku(kinngakuFormat(集計情報.get公費３_請求額()));
        row_公費３.setTxtRiyoshaFutangaku(RString.EMPTY);
        row_公費３.setTxtDekidakaTaniGokei(kinngakuFormat(集計情報.get公費３_出来高単位数合計()));
        row_公費３.setTxtDekidakaSeikyugaku(kinngakuFormat(集計情報.get公費３_出来高請求額()));
        row_公費３.setTxtDekidakaHonninFutangaku(RString.EMPTY);
        row_公費３.setTxtSaiShinsaKaisu(new RString(集計情報.get再審査回数()));
        row_公費３.setTxtKagoKaisu(new RString(集計情報.get過誤回数()));
        row_公費３.setTxtShinsaYM(checkDate(集計情報.get審査年月()));
        rowList.add(row_公費３);

        dgKyufuJissekiShukei_Row row_後_公費３ = new dgKyufuJissekiShukei_Row();
        row_後_公費３.setTxtServiceShurui(RString.EMPTY);
        row_後_公費３.setTxtJitsuNissu(RString.EMPTY);
        row_後_公費３.setTxtKeikakuTani(RString.EMPTY);
        row_後_公費３.setTxtTaishoTani(RString.EMPTY);
        row_後_公費３.setTxtTaishogaiTani(RString.EMPTY);
        row_後_公費３.setTxtTankiKeikakuNissu(RString.EMPTY);
        row_後_公費３.setTxtHokenKohi(RString.EMPTY);
        row_後_公費３.setTxtKettei(TEXT_後);
        row_後_公費３.setTxtTankiJitsuNissu(new RString(集計情報.get後_短期入所実日数()));
        row_後_公費３.setTxtTaniGokei(kinngakuFormat(集計情報.get後_公費３_単位数合計()));
        row_後_公費３.setTxtTanisuTanka(RString.EMPTY);
        row_後_公費３.setTxtSeikyugaku(kinngakuFormat(集計情報.get後_公費３_請求額()));
        row_後_公費３.setTxtRiyoshaFutangaku(RString.EMPTY);
        row_後_公費３.setTxtDekidakaTaniGokei(kinngakuFormat(集計情報.get後_公費３_出来高単位数合計()));
        row_後_公費３.setTxtDekidakaSeikyugaku(kinngakuFormat(集計情報.get後_公費３_出来高請求額()));
        row_後_公費３.setTxtDekidakaHonninFutangaku(RString.EMPTY);
        row_後_公費３.setTxtSaiShinsaKaisu(new RString(集計情報.get再審査回数()));
        row_後_公費３.setTxtKagoKaisu(new RString(集計情報.get過誤回数()));
        row_後_公費３.setTxtShinsaYM(checkDate(集計情報.get審査年月()));
        rowList.add(row_後_公費３);
        return rowList;
    }

    private dgKyufuJissekiMeisai_Row set明細情報(KyufujissekiMeisaiBusiness 明細情報) {
        dgKyufuJissekiMeisai_Row row = new dgKyufuJissekiMeisai_Row();
        row.setTxtService(setサービス種類(明細情報.get給付実績明細().getサービス種類コード()));
        row.setTxtKettei(RString.EMPTY);
        row.setTxtTani(checkDecimal(明細情報.get給付実績明細().get単位数()));
        row.setTxtKaisu(new RString(明細情報.get給付実績明細().get日数_回数()));
        row.setTxtKohi1Nissu(new RString(明細情報.get給付実績明細().get公費１対象日数_回数()));
        row.setTxtKohi2Nissu(new RString(明細情報.get給付実績明細().get公費２対象日数_回数()));
        row.setTxtKohi3Nissu(new RString(明細情報.get給付実績明細().get公費３対象日数_回数()));
        row.setTxtServiceTani(checkDecimal(明細情報.get給付実績明細().getサービス単位数()));
        row.setTxtKohi1Tani(checkDecimal(明細情報.get給付実績明細().get公費１対象サービス単位数()));
        row.setTxtKohi2Tani(checkDecimal(明細情報.get給付実績明細().get公費２対象サービス単位数()));
        row.setTxtKohi3Tani(checkDecimal(明細情報.get給付実績明細().get公費３対象サービス単位数()));
        row.setTxtSaiShinsaKaisu(new RString(明細情報.get給付実績明細().get再審査回数()));
        row.setTxtKagoKaisu(new RString(明細情報.get給付実績明細().get過誤回数()));
        row.setTxtShinsaYM(checkDate(明細情報.get給付実績明細().get審査年月()));
        row.setTxtTekiyo(明細情報.get給付実績明細().get摘要());
        return row;
    }

    private dgKyufuJissekiMeisai_Row set明細情報_後(KyufujissekiMeisaiBusiness 明細情報) {
        dgKyufuJissekiMeisai_Row row_後 = new dgKyufuJissekiMeisai_Row();
        row_後.setTxtService(setサービス種類(明細情報.get給付実績明細().getサービス種類コード()));
        row_後.setTxtKettei(TEXT_後);
        row_後.setTxtTani(checkDecimal(明細情報.get給付実績明細().get後_単位数()));
        row_後.setTxtKaisu(new RString(明細情報.get給付実績明細().get後_日数_回数()));
        row_後.setTxtKohi1Nissu(new RString(明細情報.get給付実績明細().get後_公費１対象日数_回数()));
        row_後.setTxtKohi2Nissu(new RString(明細情報.get給付実績明細().get後_公費２対象日数_回数()));
        row_後.setTxtKohi3Nissu(new RString(明細情報.get給付実績明細().get後_公費３対象日数_回数()));
        row_後.setTxtServiceTani(checkDecimal(明細情報.get給付実績明細().get後_サービス単位数()));
        row_後.setTxtKohi1Tani(checkDecimal(明細情報.get給付実績明細().get後_公費１対象サービス単位数()));
        row_後.setTxtKohi2Tani(checkDecimal(明細情報.get給付実績明細().get後_公費２対象サービス単位数()));
        row_後.setTxtKohi3Tani(checkDecimal(明細情報.get給付実績明細().get後_公費３対象サービス単位数()));
        row_後.setTxtSaiShinsaKaisu(new RString(明細情報.get給付実績明細().get再審査回数()));
        row_後.setTxtKagoKaisu(new RString(明細情報.get給付実績明細().get過誤回数()));
        row_後.setTxtShinsaYM(checkDate(明細情報.get給付実績明細().get審査年月()));
        row_後.setTxtTekiyo(明細情報.get給付実績明細().get摘要());
        return row_後;
    }

    private dgKyufuJissekiMeisaiJustoku_Row set明細情報特例(KyufujissekiMeisaiJushochiTokurei 明細情報特例) {
        dgKyufuJissekiMeisaiJustoku_Row row = new dgKyufuJissekiMeisaiJustoku_Row();
        row.setTxtService(setサービス種類(明細情報特例.getサービス種類コード()));
        row.setTxtKettei(RString.EMPTY);
        row.setTxtTani(checkDecimal(明細情報特例.get単位数()));
        row.setTxtKaisu(checkDecimal(明細情報特例.get日数_回数()));
        row.setTxtKohi1Nissu(checkDecimal(明細情報特例.get公費１対象日数_回数()));
        row.setTxtKohi2Nissu(checkDecimal(明細情報特例.get公費２対象日数_回数()));
        row.setTxtKohi3Nissu(checkDecimal(明細情報特例.get公費３対象日数_回数()));
        row.setTxtServiceTani(new RString(明細情報特例.getサービス単位数()));
        row.setTxtKohi1Tani(new RString(明細情報特例.get公費１対象サービス単位数()));
        row.setTxtKohi2Tani(new RString(明細情報特例.get公費２対象サービス単位数()));
        row.setTxtKohi3Tani(new RString(明細情報特例.get公費３対象サービス単位数()));
        row.setTxtSaiShinsaKaisu(checkDecimal(明細情報特例.get再審査回数()));
        row.setTxtKagoKaisu(checkDecimal(明細情報特例.get過誤回数()));
        row.setTxtShinsaYM(checkDate(明細情報特例.get審査年月()));
        row.setTxtShisetsuShozaiHokenshaNo(set証記載保険者番号(明細情報特例.get証記載保険者番号()));
        row.setTxtShisetsuShozaiHokenshaName(明細情報特例.get被保険者番号().value());
        row.setTxtTekiyo(明細情報特例.get摘要());
        return row;
    }

    private dgKyufuJissekiMeisaiJustoku_Row set明細情報特例_後(KyufujissekiMeisaiJushochiTokurei 明細情報特例) {
        dgKyufuJissekiMeisaiJustoku_Row row_後 = new dgKyufuJissekiMeisaiJustoku_Row();
        row_後.setTxtService(setサービス種類(明細情報特例.getサービス種類コード()));
        row_後.setTxtKettei(TEXT_後);
        row_後.setTxtTani(checkDecimal(明細情報特例.get後_単位数()));
        row_後.setTxtKaisu(checkDecimal(明細情報特例.get後_日数_回数()));
        row_後.setTxtKohi1Nissu(checkDecimal(明細情報特例.get後_公費１対象日数_回数()));
        row_後.setTxtKohi2Nissu(checkDecimal(明細情報特例.get後_公費２対象日数_回数()));
        row_後.setTxtKohi3Nissu(checkDecimal(明細情報特例.get後_公費３対象日数_回数()));
        row_後.setTxtServiceTani(new RString(明細情報特例.get後_サービス単位数()));
        row_後.setTxtKohi1Tani(new RString(明細情報特例.get後_公費１対象サービス単位数()));
        row_後.setTxtKohi2Tani(new RString(明細情報特例.get後_公費２対象サービス単位数()));
        row_後.setTxtKohi3Tani(new RString(明細情報特例.get後_公費３対象サービス単位数()));
        row_後.setTxtSaiShinsaKaisu(checkDecimal(明細情報特例.get再審査回数()));
        row_後.setTxtKagoKaisu(checkDecimal(明細情報特例.get過誤回数()));
        row_後.setTxtShinsaYM(checkDate(明細情報特例.get審査年月()));
        row_後.setTxtShisetsuShozaiHokenshaNo(set証記載保険者番号(明細情報特例.get証記載保険者番号()));
        row_後.setTxtShisetsuShozaiHokenshaName(明細情報特例.get被保険者番号().value());
        row_後.setTxtTekiyo(明細情報特例.get摘要());
        return row_後;
    }

    private RString set証記載保険者番号(HokenshaNo data) {
        if (data == null) {
            return RString.EMPTY;
        }
        return data.value();
    }

    private RString setサービス種類(ServiceShuruiCode サービス種類コード) {
        if (サービス種類コード != null && !サービス種類コード.isEmpty()) {
            return ServiceCategoryShurui.toValue(サービス種類コード.getColumnValue()).get名称();
        }
        return RString.EMPTY;
    }

    private RString checkDate(FlexibleYearMonth data) {
        if (data == null) {
            return RString.EMPTY;
        }
        return data.wareki().toDateString();
    }

    private RString checkDecimal(Decimal data) {
        if (data == null) {
            return RString.EMPTY;
        }
        return new RString(data.toString());
    }

    private RString kinngakuFormat(Decimal data) {
        if (data == null || data == Decimal.ZERO) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(data, INT_ZERO);
    }

    private static class DateComparatorServiceTeikyoYM implements Comparator<FlexibleYearMonth>, Serializable {

        private static final long serialVersionUID = 3519678578744079048L;

        @Override
        public int compare(FlexibleYearMonth o1, FlexibleYearMonth o2) {
            return o2.compareTo(o1);
        }
    }
}
