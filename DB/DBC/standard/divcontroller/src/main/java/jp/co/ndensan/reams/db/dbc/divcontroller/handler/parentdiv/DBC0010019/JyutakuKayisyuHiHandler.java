/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010019;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiJutakuKaishuhi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010019.JyutakuKayisyuHiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010019.dgJutakuKaishuhi_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 画面設計_DBCMN11002_給付実績照会_(DBC0010019)住宅改修費のHandlerです。
 *
 * @reamsid_L DBC-2970-110 lishengli
 */
public class JyutakuKayisyuHiHandler {

    private static final RString ZERO = new RString("0");
    private static final RString 前事業者 = new RString("1");
    private static final RString NI = new RString("2");
    private static final FlexibleYearMonth 平成24年4月 = new FlexibleYearMonth("201204");
    private final JyutakuKayisyuHiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div JyutakuKayisyuHiDiv
     */
    public JyutakuKayisyuHiHandler(JyutakuKayisyuHiDiv div) {
        this.div = div;
    }

    /**
     * 画面の共有子Divを初期化する。
     *
     * @param 引き継ぎ情報 KyufuJissekiPrmBusiness
     * @param 整理番号 RString
     * @param サービス提供年月 FlexibleYearMonth
     * @param 識別番号 NyuryokuShikibetsuNo
     */
    public void load共有子Div(KyufuJissekiPrmBusiness 引き継ぎ情報, RString 整理番号,
            FlexibleYearMonth サービス提供年月, NyuryokuShikibetsuNo 識別番号) {
        HihokenshaNo 被保険者番号 = 引き継ぎ情報.getKojinKakuteiKey().get被保険者番号();
        div.getCcdKyufuJissekiHeader().initialize(被保険者番号, サービス提供年月, 整理番号, 識別番号);
    }

    /**
     * ボタン表示制御の設定処理です。
     *
     * @param shikibetsuNoKanriList List<ShikibetsuNoKanri>
     * @param サービス提供年月 サービス提供年月
     */
    public void setボタン状態(List<ShikibetsuNoKanri> shikibetsuNoKanriList, FlexibleYearMonth サービス提供年月) {
        div.getBtnKihon().setDisabled(false);
        div.getBtnMeisaiShukei().setDisabled(false);
        div.getBtnShokuji().setDisabled(false);
        div.getBtnFukushiYoguKonyu().setDisabled(false);
        div.getBtnTokuteiNyushosha().setDisabled(false);
        div.getBtnKogakuKaigoService().setDisabled(false);
        div.getBtnTokuteiShinryo().setDisabled(false);
        div.getBtnKyotakuServiceKeikaku().setDisabled(false);
        div.getBtnJutakuKaishu().setDisabled(false);
        div.getBtnCareManagement().setDisabled(false);
        div.getBtnShafukuKeigen().setDisabled(false);
        if (shikibetsuNoKanriList != null && !shikibetsuNoKanriList.isEmpty()) {
            ShikibetsuNoKanri 識別番号管理 = shikibetsuNoKanriList.get(0);
            if (ZERO.equals(識別番号管理.get基本設定区分())) {
                div.getBtnKihon().setDisabled(true);
            }
            if (ZERO.equals(識別番号管理.get明細設定区分())) {
                div.getBtnMeisaiShukei().setDisabled(true);
            }
            if (ZERO.equals(識別番号管理.get所定疾患施設療養設定区分())) {
                div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(true);
            }
            if (ZERO.equals(識別番号管理.get食事費用設定区分())) {
                div.getBtnShokuji().setDisabled(true);
            }
            if (ZERO.equals(識別番号管理.get福祉用具購入費設定区分())) {
                div.getBtnFukushiYoguKonyu().setDisabled(true);
            }
            if (ZERO.equals(識別番号管理.get特定入所者設定区分())) {
                div.getBtnTokuteiNyushosha().setDisabled(true);
            }
            if (ZERO.equals(識別番号管理.get高額介護サービス費設定区分())) {
                div.getBtnKogakuKaigoService().setDisabled(true);
            }
            if (ZERO.equals(識別番号管理.get特定診療費設定区分())) {
                div.getBtnTokuteiShinryo().setDisabled(true);
            }
            if (ZERO.equals(識別番号管理.get居宅計画費設定区分())) {
                div.getBtnKyotakuServiceKeikaku().setDisabled(true);
            }
            if (ZERO.equals(識別番号管理.get住宅改修費設定区分())) {
                div.getBtnJutakuKaishu().setDisabled(true);
            }
            if (ZERO.equals(識別番号管理.getケアマネジメント設定区分())) {
                div.getBtnCareManagement().setDisabled(true);
            }
            if (ZERO.equals(識別番号管理.get社会福祉法人軽減設定区分())) {
                div.getBtnShafukuKeigen().setDisabled(true);
            }
            set所定疾患施設療養費_緊急時施設療養費ボタン(識別番号管理, サービス提供年月);
        }
    }

    private void set所定疾患施設療養費_緊急時施設療養費ボタン(ShikibetsuNoKanri 識別番号管理, FlexibleYearMonth サービス提供年月) {
        if (NI.equals(識別番号管理.get所定疾患施設療養設定区分())
                && 平成24年4月.isBeforeOrEquals(サービス提供年月)) {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisplayNone(false);
            div.getBtnKinkyujiShisetsuRyoyo().setDisplayNone(true);
        } else {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisplayNone(true);
            div.getBtnKinkyujiShisetsuRyoyo().setDisplayNone(false);
            if (ZERO.equals(識別番号管理.get緊急時施設療養設定区分())) {
                div.getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
            } else {
                div.getBtnKinkyujiShisetsuRyoyo().setDisabled(false);
            }
        }
    }

    /**
     * データグリッドの設定処理です。
     *
     * @param 引き継ぎ情報 KyufuJissekiPrmBusiness
     */
    public void setデータグリッド(KyufuJissekiPrmBusiness 引き継ぎ情報) {
        List<KyufujissekiJutakuKaishuhi> 給付実績住宅改修費List = 引き継ぎ情報.getCsData_H();
        List<dgJutakuKaishuhi_Row> rowList = new ArrayList<>();
        RDate サービス提供年月 = div.getCcdKyufuJissekiHeader().getサービス提供年月();
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 実績区分コード = div.getCcdKyufuJissekiHeader().get実績区分コード();
        RString 整理番号 = div.getCcdKyufuJissekiHeader().get整理番号();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        for (KyufujissekiJutakuKaishuhi kyufujissekiJutakuKaishuhi : 給付実績住宅改修費List) {
            if (kyufujissekiJutakuKaishuhi.getサービス提供年月().equals(new FlexibleYearMonth(サービス提供年月.getYearMonth().toString()))
                    && 事業者番号.equals(kyufujissekiJutakuKaishuhi.get事業所番号().value())
                    && 整理番号.equals(kyufujissekiJutakuKaishuhi.get整理番号())
                    && 様式番号.equals(kyufujissekiJutakuKaishuhi.get入力識別番号().value())) {
                dgJutakuKaishuhi_Row row = new dgJutakuKaishuhi_Row();
                row.setTxtService(kyufujissekiJutakuKaishuhi.getサービスコード().value());
                row.setTxtChakkoYMD(getパターン1(kyufujissekiJutakuKaishuhi.get住宅改修着工年月日()));
                row.setTxtJigyoshaName(kyufujissekiJutakuKaishuhi.get住宅改修事業者名());
                row.setTxtJusho(kyufujissekiJutakuKaishuhi.get住宅改修住宅住所());
                row.setTxtHiyo(DecimalFormatter.toコンマ区切りRString(kyufujissekiJutakuKaishuhi.get改修金額(), 0));
                row.setTxtShinsaYM(getパターン51(kyufujissekiJutakuKaishuhi.get審査年月()));
                rowList.add(row);
            }
        }
        div.getDgJutakuKaishuhi().setDataSource(rowList);
        set前月と次月の状態(給付実績住宅改修費List, new FlexibleYearMonth(サービス提供年月.getYearMonth().toDateString()));
        List<KyufuJissekiHedajyoho2> ヘッダ情報2 = 引き継ぎ情報.getCommonHeader().get給付実績ヘッダ情報2();
        set前事業者と後事業者の状態(ヘッダ情報2, new FlexibleYearMonth(サービス提供年月.getYearMonth().toDateString()),
                事業者番号, 実績区分コード, 整理番号, 様式番号);
    }

    /**
     * 事業者の変更処理です。
     *
     * @param 事業者Flg 事業者Flg
     * @param 引き継ぎ情報 KyufuJissekiPrmBusiness
     */
    public void chenge事業者(RString 事業者Flg, KyufuJissekiPrmBusiness 引き継ぎ情報) {
        RDate サービス提供年月 = div.getCcdKyufuJissekiHeader().getサービス提供年月();
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 実績区分コード = div.getCcdKyufuJissekiHeader().get実績区分コード();
        RString 整理番号 = div.getCcdKyufuJissekiHeader().get整理番号();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        List<KyufuJissekiHedajyoho2> ヘッダ情報2 = 引き継ぎ情報.getCommonHeader().get給付実績ヘッダ情報2();
        int index = get事業者番号index(ヘッダ情報2, 整理番号, 事業者番号, 様式番号, サービス提供年月.getYearMonth().toDateString(), 実績区分コード);
        int i;
        if (前事業者.equals(事業者Flg)) {
            i = -1;
        } else {
            i = 1;
        }
        if (index + i < ヘッダ情報2.size() && 0 <= index + i) {
            div.getCcdKyufuJissekiHeader().setサービス提供年月(new RDate(ヘッダ情報2.get(index + i).getサービス提供年月().getYearValue(),
                    ヘッダ情報2.get(index + i).getサービス提供年月().getMonthValue()));
            div.getCcdKyufuJissekiHeader().set事業者名称(ヘッダ情報2.get(index + i).get事業者名称());
            div.getCcdKyufuJissekiHeader().set実績区分(ヘッダ情報2.get(index + i).get給付実績区分コード());
            div.getCcdKyufuJissekiHeader().set整理番号(ヘッダ情報2.get(index + i).get整理番号());
            div.getCcdKyufuJissekiHeader().set識別番号名称(ヘッダ情報2.get(index + i).get識別番号名称());
            div.getCcdKyufuJissekiHeader().set事業者番号(ヘッダ情報2.get(index + i).get事業所番号().value());
            div.getCcdKyufuJissekiHeader().set様式番号(ヘッダ情報2.get(index + i).get識別番号());
            setDataGrid(引き継ぎ情報, ヘッダ情報2.get(index + i).getサービス提供年月(),
                    ヘッダ情報2.get(index + i).get事業所番号().value(), ヘッダ情報2.get(index + i).get整理番号(),
                    ヘッダ情報2.get(index + i).get給付実績区分コード(), ヘッダ情報2.get(index + i).get識別番号());
        }
    }

    private void set前事業者と後事業者の状態(List<KyufuJissekiHedajyoho2> ヘッダ情報2, FlexibleYearMonth サービス提供年月, RString 事業者番号,
            RString 実績区分コード, RString 整理番号, RString 様式番号) {
        div.getBtnMaeJigyosha().setDisabled(true);
        div.getBtnAtoJigyosha().setDisabled(true);
        int index = get事業者番号index(ヘッダ情報2, 整理番号, 事業者番号, 様式番号, サービス提供年月.toDateString(), 実績区分コード);
        if (0 < index) {
            div.getBtnMaeJigyosha().setDisabled(false);
        }
        if (index + 1 < ヘッダ情報2.size()) {
            div.getBtnAtoJigyosha().setDisabled(false);
        }
    }

    private void set前月と次月の状態(List<KyufujissekiJutakuKaishuhi> 給付実績住宅改修費List, FlexibleYearMonth サービス提供年月KEY) {
        Collections.sort(給付実績住宅改修費List, new DateComparatorServiceTeikyoYM());
        div.getBtnZengetsu().setDisabled(true);
        div.getBtnJigetsu().setDisabled(true);
        if (給付実績住宅改修費List != null && !給付実績住宅改修費List.isEmpty()) {
            div.getBtnZengetsu().setDisabled(給付実績住宅改修費List.get(0).getサービス提供年月().isBefore(サービス提供年月KEY));
            div.getBtnJigetsu().setDisabled(サービス提供年月KEY.isBefore(
                    給付実績住宅改修費List.get(給付実績住宅改修費List.size() - 1).getサービス提供年月()));
        }
    }

    private int get事業者番号index(List<KyufuJissekiHedajyoho2> 事業者番号リスト, RString 整理番号, RString 事業者番号, RString 様式番号, RString サービス提供年月, RString 実績区分コード) {
        for (int index = 0; index < 事業者番号リスト.size(); index++) {
            if (事業者番号.equals(事業者番号リスト.get(index).get事業所番号().value())
                    && 整理番号.equals(事業者番号リスト.get(index).get整理番号())
                    && 様式番号.equals(事業者番号リスト.get(index).get識別番号())
                    && サービス提供年月.equals(事業者番号リスト.get(index).getサービス提供年月().toDateString())
                    && 実績区分コード.equals(事業者番号リスト.get(index).get給付実績区分コード())) {
                return index;
            }
        }
        return 0;
    }

    private static class DateComparatorServiceTeikyoYM implements Comparator<KyufujissekiJutakuKaishuhi>, Serializable {

        private static final long serialVersionUID = -300796001015547240L;

        @Override
        public int compare(KyufujissekiJutakuKaishuhi o1, KyufujissekiJutakuKaishuhi o2) {
            return o2.getサービス提供年月().compareTo(o1.getサービス提供年月());
        }
    }

    private RString getパターン1(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return 年月日.wareki().toDateString();
        }
        return RString.EMPTY;
    }

    private RString getパターン51(FlexibleYearMonth 年月) {
        if (年月 != null && !年月.isEmpty()) {
            return 年月.wareki().toDateString();
        }
        return RString.EMPTY;
    }

    private void setDataGrid(KyufuJissekiPrmBusiness 引き継ぎ情報, FlexibleYearMonth サービス提供年月, RString 事業者番号, RString 整理番号,
            RString 実績区分コード, RString 様式番号) {
        List<KyufujissekiJutakuKaishuhi> 給付実績住宅改修費List = 引き継ぎ情報.getCsData_H();
        List<dgJutakuKaishuhi_Row> rowList = new ArrayList<>();
        for (KyufujissekiJutakuKaishuhi kyufujissekiJutakuKaishuhi : 給付実績住宅改修費List) {
            if (kyufujissekiJutakuKaishuhi.getサービス提供年月().equals(サービス提供年月)
                    && 事業者番号.equals(kyufujissekiJutakuKaishuhi.get事業所番号().value())
                    && 整理番号.equals(kyufujissekiJutakuKaishuhi.get整理番号())
                    && 様式番号.equals(kyufujissekiJutakuKaishuhi.get入力識別番号().value())) {
                dgJutakuKaishuhi_Row row = new dgJutakuKaishuhi_Row();
                row.setTxtService(kyufujissekiJutakuKaishuhi.getサービスコード().value());
                row.setTxtChakkoYMD(getパターン1(kyufujissekiJutakuKaishuhi.get住宅改修着工年月日()));
                row.setTxtJigyoshaName(kyufujissekiJutakuKaishuhi.get住宅改修事業者名());
                row.setTxtJusho(kyufujissekiJutakuKaishuhi.get住宅改修住宅住所());
                row.setTxtHiyo(DecimalFormatter.toコンマ区切りRString(kyufujissekiJutakuKaishuhi.get改修金額(), 0));
                row.setTxtShinsaYM(getパターン51(kyufujissekiJutakuKaishuhi.get審査年月()));
                rowList.add(row);
            }
        }
        div.getDgJutakuKaishuhi().setDataSource(rowList);
        div.getDgJutakuKaishuhi().setDataSource(rowList);
        set前月と次月の状態(給付実績住宅改修費List, サービス提供年月);
        List<KyufuJissekiHedajyoho2> ヘッダ情報2 = 引き継ぎ情報.getCommonHeader().get給付実績ヘッダ情報2();
        set前事業者と後事業者の状態(ヘッダ情報2, サービス提供年月, 事業者番号, 実績区分コード, 整理番号, 様式番号);
    }
}
