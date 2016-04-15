/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0610011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanFukushiYoguHanbaihi;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyuikkatushinsa.ShokanShinseiEntityResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shinnsanaiyo.ShinsaNaiyoKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0610011.YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0610011.dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0600011.PnlTotalParameter;
import jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyuikkatushinsa.FukushiyoguKonyuhiShikyuIkkatuShinsa;
import jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei.FukushiYoguKounyuhiDouituHinmokuChofukuHantei;
import jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei.FukushiyoguKonyuhiShikyuGendogaku;
import jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei.FukushiyoguKonyuhiShikyuShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 福祉用具購入費支給申請審査 未審査支給申請一覧のHandlerです。
 *
 * @reamsid_L DBC-1021-090 gongliang
 */
public class YoguKonyuhiShikyuShinseiMishinsaSearchHandler {

    private final YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv div;
    private final RString 審査 = new RString("審査");
    private final RString 承認する = new RString("承認する");
    private final RString 却下する = new RString("却下する");
    private final RString 決定日R = new RString("決定日");

    /**
     * YoguKonyuhiShikyuShinseiMishinsaSearchHandler
     *
     * @param div YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv
     */
    public YoguKonyuhiShikyuShinseiMishinsaSearchHandler(YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv div) {
        this.div = div;
    }

    /**
     * 「未審査分を検索する」ボタンHandler処理
     */
    public void 未審査分検索処理() {
        RDate 支給申請日From = div.getYoguKonyuhiShikyuShinseiMishinsaSearchCondition().getTxtShikyuShinseiDateRange().getFromValue();
        RDate 支給申請日To = div.getYoguKonyuhiShikyuShinseiMishinsaSearchCondition().getTxtShikyuShinseiDateRange().getToValue();
        FlexibleDate 申請日From = null;
        FlexibleDate 申請日To = null;
        if (支給申請日From != null) {
            申請日From = new FlexibleDate(支給申請日From.toString());
        }
        if (支給申請日To != null) {
            申請日To = new FlexibleDate(支給申請日To.toString());
        }
        ArrayList<ShokanShinseiEntityResult> resultList = (ArrayList<ShokanShinseiEntityResult>) FukushiyoguKonyuhiShikyuIkkatuShinsa
                .createInstance().getMiShinsaShinseiList(申請日From, 申請日To);
        if (resultList == null || resultList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        ViewStateHolder.put(ViewStateKeys.福祉審査_決定, resultList);
        setグリッド(resultList);
    }

    /**
     * 支給申請内容を一括審査・決定するボタンHandler処理
     */
    public void 審査決定処理() {
        List<dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row> selectedMishinsaShikyuShinsei = div.getYoguKonyuhiShikyuShinseiMishinsaResultList()
                .getDgYoguKonyuhiShisaMishinsaShikyuShinseiList().getDataSource();
        for (dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row row : selectedMishinsaShikyuShinsei) {
            if (限度額チェック(row) && !品目チェック(row)) {
                row.getTxtShinsaNo().setValue(ShinsaNaiyoKubun.承認する.getコード());
                row.getTxtShinsaResult().setValue(承認する);
            } else {
                row.getTxtShinsaNo().setValue(ShinsaNaiyoKubun.却下する.getコード());
                row.getTxtShinsaResult().setValue(却下する);
            }
        }
    }

    /**
     * 申請グリッドの修正ボタン ViewStateの設定
     */
    public void setViewState() {
        dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row row = div.getYoguKonyuhiShikyuShinseiMishinsaResultList()
                .getDgYoguKonyuhiShisaMishinsaShikyuShinseiList().getActiveRow();
        HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getTxtHihoNo().getValue());
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(row.getTxtTenkyoYM().getValue().getYearMonth().toString());
        RString 整理番号 = row.getTxtSeiriNo().getValue();
        JigyoshaNo 事業者番号 = new JigyoshaNo(row.getTxtJigyoshaNo().getValue());
        RString 様式番号 = row.getTxtYoshikiNo().getValue();
        RString 明細番号 = row.getTxtMeisaiNo().getValue();
        RDate 決定日 = div.getYoguKonyuhiShikyuShinseiMishinsaResultList().getTxtKetteiYMD().getValue();
        ViewStateHolder.put(ViewStateKeys.決定日, 決定日);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.画面モード, 審査);
        PnlTotalParameter param = new PnlTotalParameter(被保険者番号,
                サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        ViewStateHolder.put(ViewStateKeys.支給申請情報検索キー, param);
    }

    /**
     * 決定日入力チェック
     *
     * @param 決定日 RDate
     */
    public void 決定日入力チェック(RDate 決定日) {
        if (決定日 == null) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(決定日R.toString()));
        }
    }

    /**
     * 選択チェック
     */
    public void 選択チェック() {
        List<dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row> selectedMishinsaShikyuShinsei = div.getYoguKonyuhiShikyuShinseiMishinsaResultList()
                .getDgYoguKonyuhiShisaMishinsaShikyuShinseiList().getSelectedItems();
        if (selectedMishinsaShikyuShinsei == null || selectedMishinsaShikyuShinsei.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.対象行を選択.getMessage());
        }
    }

    /**
     * 保存ボタンHandler処理
     *
     * @param 決定日 FlexibleDate
     */
    public void 保存処理(FlexibleDate 決定日) {
        List<ShokanShinseiEntityResult> updList = new ArrayList<>();
        List<dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row> selectedMishinsaShikyuShinsei = div.getYoguKonyuhiShikyuShinseiMishinsaResultList()
                .getDgYoguKonyuhiShisaMishinsaShikyuShinseiList().getSelectedItems();
        List<ShokanShinseiEntityResult> entityList = ViewStateHolder.get(ViewStateKeys.福祉審査_決定, List.class);
        for (dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row row : selectedMishinsaShikyuShinsei) {
            ShokanShinseiEntityResult entity = entityList.get(row.getRowNum().getValue().intValue());
            entity.getEntity().get償還払請求基本Entity().setHiHokenshaNo(new HihokenshaNo(row.getTxtHihoNo().getValue()));
            entity.getEntity().get償還払請求基本Entity().setServiceTeikyoYM(
                    new FlexibleYearMonth(row.getTxtTenkyoYM().getValue().getYearMonth().toString()));
            entity.getEntity().get償還払請求基本Entity().setSeiriNo(row.getTxtSeiriNo().getValue());
            entity.getEntity().get償還払請求基本Entity().setJigyoshaNo(new JigyoshaNo(row.getTxtJigyoshaNo().getValue()));
            entity.getEntity().get償還払請求基本Entity().setYoshikiNo(row.getTxtYoshikiNo().getValue());
            entity.getEntity().get償還払請求基本Entity().setMeisaiNo(row.getTxtMeisaiNo().getValue());
            // TODO セルフ業務決定_GS_DB介護保険 番号:8  償還払請求基本．被保険者番号?
            entity.getEntity().set氏名(new AtenaMeisho(row.getTxtHihoName().getValue()));
            entity.getEntity().get償還払支給申請Entity().setShinseiYMD(new FlexibleDate(row.getTxtShikyuShinseiDate().getValue().toString()));
            entity.getEntity().get償還払支給申請Entity().setHokenTaishoHiyogaku(row.getTxtHiyoTotal().getValue());
            entity.getEntity().get償還払支給申請Entity().setRiyoshaFutangaku(
                    Integer.parseInt(row.getTxtRiyoshaFutanAmount().getValue().toString()));
            entity.getEntity().get償還払支給申請Entity().setShiharaiKingakuTotal(row.getTxtHokenKyufuAmount().getValue());
            entity.getEntity().get償還払支給申請Entity().setShinsaKekka(row.getTxtShinsaNo().getValue());
            updList.add(entity);
        }
        FukushiyoguKonyuhiShikyuIkkatuShinsa.createInstance().updShikyuShinsei(決定日, updList);
    }

    private void setグリッド(List<ShokanShinseiEntityResult> resultList) {
        List<dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row> rowList = new ArrayList<>();
        int i = 0;
        for (ShokanShinseiEntityResult entity : resultList) {
            dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row row = new dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row();
            FlexibleDate 支給申請日 = entity.getEntity().get償還払支給申請Entity().getShinseiYMD();
            FlexibleYearMonth 提供購入年月 = entity.getEntity().get償還払請求基本Entity().getServiceTeikyoYM();
            HihokenshaNo 被保番号 = entity.getEntity().get償還払請求基本Entity().getHiHokenshaNo();
            AtenaMeisho 氏名 = entity.getEntity().get氏名();
            RString 審査結果 = entity.getEntity().get償還払支給申請Entity().getShinsaKekka();
            JigyoshaNo 事業者番号 = entity.getEntity().get償還払請求基本Entity().getJigyoshaNo();
            if (支給申請日 != null) {
                row.getTxtShikyuShinseiDate().setValue(new RDate(支給申請日.toString()));
            }
            if (提供購入年月 != null) {
                row.getTxtTenkyoYM().setValue(new RDate(提供購入年月.toString()));
            }
            if (被保番号 != null) {
                row.getTxtHihoNo().setValue(被保番号.getColumnValue());
            }
            if (氏名 != null) {
                row.getTxtHihoName().setValue(氏名.getColumnValue());
            }
            if (審査結果 != null) {
                row.getTxtShinsaResult().setValue(ShinsaNaiyoKubun.toValue(審査結果).get名称());
            }
            if (事業者番号 != null) {
                row.getTxtJigyoshaNo().setValue(new RString(事業者番号.getColumnValue().toString()));
            }
            row.getTxtHokenKyufuAmount().setValue(new Decimal(entity.getEntity().get償還払支給申請Entity().getHokenKyufugaku()));
            row.getTxtRiyoshaFutanAmount().setValue(new Decimal(entity.getEntity().get償還払支給申請Entity().getRiyoshaFutangaku()));
            row.getTxtHiyoTotal().setValue(entity.getEntity().get償還払支給申請Entity().getShiharaiKingakuTotal());
            row.getTxtSeiriNo().setValue(entity.getEntity().get償還払請求基本Entity().getSeiriNo());
            row.getTxtYoshikiNo().setValue(entity.getEntity().get償還払請求基本Entity().getYoshikiNo());
            row.getTxtMeisaiNo().setValue(entity.getEntity().get償還払請求基本Entity().getMeisaiNo());
            row.getTxtShinsaNo().setValue(entity.getEntity().get償還払支給申請Entity().getShinsaKekka());
            row.getRowNum().setValue(new Decimal(i));
            i = i + 1;
            rowList.add(row);
        }
        div.getYoguKonyuhiShikyuShinseiMishinsaResultList().getDgYoguKonyuhiShisaMishinsaShikyuShinseiList().setDataSource(rowList);
    }

    private Boolean 限度額チェック(dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row row) {
        HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getTxtHihoNo().getValue());
        RYearMonth サービス提供年月Row = row.getTxtTenkyoYM().getValue().getYearMonth();
        FlexibleYearMonth サービス提供年月 = null;
        if (サービス提供年月Row != null) {
            サービス提供年月 = new FlexibleYearMonth(サービス提供年月Row.toString());
        }
        RString 整理番号 = row.getTxtSeiriNo().getValue();
        JigyoshaNo 事業者番号 = new JigyoshaNo(row.getTxtJigyoshaNo().getValue());
        RString 様式番号 = row.getTxtYoshikiNo().getValue();
        RString 明細番号 = row.getTxtMeisaiNo().getValue();
        Decimal 今回の保険対象費用額 = row.getTxtHiyoTotal().getValue();
        return FukushiyoguKonyuhiShikyuGendogaku.createInstance().chkKonyuhiShikyuGendogaku(被保険者番号,
                サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, 今回の保険対象費用額);
    }

    private Boolean 品目チェック(dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row row) {
        HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getTxtHihoNo().getValue());
        RYearMonth サービス提供年月Row = row.getTxtTenkyoYM().getValue().getYearMonth();
        FlexibleYearMonth サービス提供年月 = null;
        if (サービス提供年月Row != null) {
            サービス提供年月 = new FlexibleYearMonth(サービス提供年月Row.toString());
        }
        RString 整理番号 = row.getTxtSeiriNo().getValue();
        JigyoshaNo 事業者番号 = new JigyoshaNo(row.getTxtJigyoshaNo().getValue());
        RString 様式番号 = row.getTxtYoshikiNo().getValue();
        RString 明細番号 = row.getTxtMeisaiNo().getValue();
        List<ShokanFukushiYoguHanbaihi> 福祉用具購入販売費リスト = FukushiyoguKonyuhiShikyuShinsei.createInstance()
                .getShokanFukushiYoguHanbaihi(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        return new FukushiYoguKounyuhiDouituHinmokuChofukuHantei().chkHinmokuCodePerYear(被保険者番号,
                サービス提供年月, 福祉用具購入販売費リスト, 整理番号);
    }
}
