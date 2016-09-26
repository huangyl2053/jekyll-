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
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiJutakuKaishuhiBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010019.JyutakuKayisyuHiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010019.dgJutakuKaishuhi_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
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
    private static final RString 前事業者 = new RString("0");
    private static final RString 前月 = new RString("1");
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
            if (ZERO.equals(識別番号管理.getケアマネジメント設定区分())) {
                div.getBtnCareManagement().setDisabled(true);
            }
            if (ZERO.equals(識別番号管理.get社会福祉法人軽減設定区分())) {
                div.getBtnShafukuKeigen().setDisabled(true);
            }
            if (ZERO.equals(識別番号管理.get所定疾患施設療養設定区分())) {

                div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(true);
            } else {
                div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(false);
            }
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
        List<KyufujissekiJutakuKaishuhiBusiness> 給付実績住宅改修費List = 引き継ぎ情報.getCsData_H();
        List<dgJutakuKaishuhi_Row> rowList = new ArrayList<>();
        RDate サービス提供年月 = div.getCcdKyufuJissekiHeader().getサービス提供年月();
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 実績区分コード = div.getCcdKyufuJissekiHeader().get実績区分コード();
        RString 整理番号 = div.getCcdKyufuJissekiHeader().get整理番号();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        for (KyufujissekiJutakuKaishuhiBusiness business : 給付実績住宅改修費List) {
            KyufujissekiJutakuKaishuhi kyufujissekiJutakuKaishuhi = business.get給付実績住宅改修費情報();
            if (kyufujissekiJutakuKaishuhi.getサービス提供年月().equals(new FlexibleYearMonth(サービス提供年月.getYearMonth().toString()))
                    && check事業所番号Null(kyufujissekiJutakuKaishuhi.get事業所番号()).equals(事業者番号)
                    && nullToEMPTY(kyufujissekiJutakuKaishuhi.get整理番号()).equals(整理番号)
                    && check入力識別番号Null(kyufujissekiJutakuKaishuhi.get入力識別番号()).equals(様式番号)) {
                dgJutakuKaishuhi_Row row = new dgJutakuKaishuhi_Row();
                row.setTxtService(business.getサービス種類略称());
                row.setTxtChakkoYMD(getパターン1(kyufujissekiJutakuKaishuhi.get住宅改修着工年月日()));
                row.setTxtJigyoshaName(nullToEMPTY(kyufujissekiJutakuKaishuhi.get住宅改修事業者名()));
                row.setTxtJusho(nullToEMPTY(kyufujissekiJutakuKaishuhi.get住宅改修住宅住所()));
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
            div.getCcdKyufuJissekiHeader().set事業者番号(check事業所番号Null(ヘッダ情報2.get(index + i).get事業所番号()));
            div.getCcdKyufuJissekiHeader().set様式番号(ヘッダ情報2.get(index + i).get識別番号());
            setDataGrid(引き継ぎ情報, ヘッダ情報2.get(index + i).getサービス提供年月(),
                    check事業所番号Null(ヘッダ情報2.get(index + i).get事業所番号()), ヘッダ情報2.get(index + i).get整理番号(),
                    ヘッダ情報2.get(index + i).get給付実績区分コード(), ヘッダ情報2.get(index + i).get識別番号());
        }
    }

    /**
     * 直近サービス提供年月の取得処理。
     *
     * @param 月Flg 月Flg
     * @param サービス提供年月 サービス提供年月
     * @param 引き継ぎ情報 引き継ぎ情報
     * @return サービス提供年月
     */
    public FlexibleYearMonth get直近サービス提供年月(RString 月Flg, RDate サービス提供年月, KyufuJissekiPrmBusiness 引き継ぎ情報) {
        List<KyufujissekiJutakuKaishuhiBusiness> 給付実績住宅改修費List = 引き継ぎ情報.getCsData_H();
        Collections.sort(給付実績住宅改修費List, new DateComparatorServiceTeikyoYM());
        List<KyufujissekiJutakuKaishuhi> サービス提供年月前 = new ArrayList<>();
        List<KyufujissekiJutakuKaishuhi> サービス提供年月後 = new ArrayList<>();
        if (サービス提供年月 != null) {
            for (KyufujissekiJutakuKaishuhiBusiness business : 給付実績住宅改修費List) {
                KyufujissekiJutakuKaishuhi kyufujissekiJutakuKaishuhi = business.get給付実績住宅改修費情報();
                if (new FlexibleYearMonth(サービス提供年月.getYearMonth().toDateString()).isBefore(kyufujissekiJutakuKaishuhi.getサービス提供年月())) {
                    サービス提供年月後.add(kyufujissekiJutakuKaishuhi);
                }
                if (kyufujissekiJutakuKaishuhi.getサービス提供年月().isBefore(new FlexibleYearMonth(サービス提供年月.getYearMonth().toDateString()))) {
                    サービス提供年月前.add(kyufujissekiJutakuKaishuhi);
                }
            }
        }
        if (前月.equals(月Flg)) {
            return サービス提供年月前.get(0).getサービス提供年月();
        } else {
            return サービス提供年月後.get(サービス提供年月後.size() - 1).getサービス提供年月();
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

    private void set前月と次月の状態(List<KyufujissekiJutakuKaishuhiBusiness> 給付実績住宅改修費List, FlexibleYearMonth サービス提供年月KEY) {
        Collections.sort(給付実績住宅改修費List, new DateComparatorServiceTeikyoYM());
        div.getBtnZengetsu().setDisabled(true);
        div.getBtnJigetsu().setDisabled(true);
        if (給付実績住宅改修費List != null && !給付実績住宅改修費List.isEmpty()) {
            div.getBtnZengetsu().setDisabled(!給付実績住宅改修費List.
                    get(給付実績住宅改修費List.size() - 1).get給付実績住宅改修費情報().getサービス提供年月().isBefore(サービス提供年月KEY));
            div.getBtnJigetsu().setDisabled(!サービス提供年月KEY.isBefore(
                    給付実績住宅改修費List.get(0).get給付実績住宅改修費情報().getサービス提供年月()));
        }
    }

    private int get事業者番号index(List<KyufuJissekiHedajyoho2> 事業者番号リスト, RString 整理番号, RString 事業者番号, RString 様式番号, RString サービス提供年月, RString 実績区分コード) {
        for (int index = 0; index < 事業者番号リスト.size(); index++) {
            if (check事業所番号Null(事業者番号リスト.get(index).get事業所番号()).equals(事業者番号)
                    && nullToEMPTY(事業者番号リスト.get(index).get整理番号()).equals(整理番号)
                    && nullToEMPTY(事業者番号リスト.get(index).get識別番号()).equals(様式番号)
                    && 事業者番号リスト.get(index).getサービス提供年月().toDateString().equals(サービス提供年月)
                    && nullToEMPTY(事業者番号リスト.get(index).get給付実績区分コード()).equals(実績区分コード)) {
                return index;
            }
        }
        return 0;
    }

    private static class DateComparatorServiceTeikyoYM implements Comparator<KyufujissekiJutakuKaishuhiBusiness>, Serializable {

        private static final long serialVersionUID = -300796001015547240L;

        @Override
        public int compare(KyufujissekiJutakuKaishuhiBusiness o1, KyufujissekiJutakuKaishuhiBusiness o2) {
            return o2.get給付実績住宅改修費情報().getサービス提供年月().compareTo(o1.get給付実績住宅改修費情報().getサービス提供年月());
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
        List<KyufujissekiJutakuKaishuhiBusiness> 給付実績住宅改修費List = 引き継ぎ情報.getCsData_H();
        List<dgJutakuKaishuhi_Row> rowList = new ArrayList<>();
        for (KyufujissekiJutakuKaishuhiBusiness business : 給付実績住宅改修費List) {
            KyufujissekiJutakuKaishuhi kyufujissekiJutakuKaishuhi = business.get給付実績住宅改修費情報();
            if (kyufujissekiJutakuKaishuhi.getサービス提供年月().equals(サービス提供年月)
                    && check事業所番号Null(kyufujissekiJutakuKaishuhi.get事業所番号()).equals(事業者番号)
                    && nullToEMPTY(kyufujissekiJutakuKaishuhi.get整理番号()).equals(整理番号)
                    && check入力識別番号Null(kyufujissekiJutakuKaishuhi.get入力識別番号()).equals(様式番号)) {
                dgJutakuKaishuhi_Row row = new dgJutakuKaishuhi_Row();
                row.setTxtService(business.getサービス種類略称());
                row.setTxtChakkoYMD(getパターン1(kyufujissekiJutakuKaishuhi.get住宅改修着工年月日()));
                row.setTxtJigyoshaName(nullToEMPTY(kyufujissekiJutakuKaishuhi.get住宅改修事業者名()));
                row.setTxtJusho(nullToEMPTY(kyufujissekiJutakuKaishuhi.get住宅改修住宅住所()));
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

    private RString nullToEMPTY(RString 項目) {
        if (!RString.isNullOrEmpty(項目)) {
            return 項目;
        }
        return RString.EMPTY;
    }

    private RString check事業所番号Null(JigyoshaNo 事業所番号) {
        if (事業所番号 != null && !事業所番号.isEmpty()) {
            return 事業所番号.value();
        }
        return RString.EMPTY;
    }

    private RString check入力識別番号Null(NyuryokuShikibetsuNo 入力識別番号) {
        if (入力識別番号 != null && !入力識別番号.isEmpty()) {
            return 入力識別番号.value();
        }
        return RString.EMPTY;
    }
}
