/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0610011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanFukushiYoguHanbaihi;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyuikkatushinsa.ShokanShinseiEntityResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shinnsanaiyo.ShinsaNaiyoKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0610011.YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0610011.dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row;
import jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyuikkatushinsa.FukushiyoguKonyuhiShikyuIkkatuShinsa;
import jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei.FukushiYoguKounyuhiDouituHinmokuChofukuHantei;
import jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei.FukushiyoguKonyuhiShikyuGendogaku;
import jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei.FukushiyoguKonyuhiShikyuShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 福祉用具購入費支給申請審査 未審査支給申請一覧のHandlerです。
 *
 * @reamsid_L DBC-1020-040 gongliang
 */
public class YoguKonyuhiShikyuShinseiMishinsaSearchHandler {

    private final YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv div;
    private final RString 承認する = new RString("承認する");
    private final RString 却下する = new RString("却下する");

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
     *
     * @param 支給申請日From RDate 支給申請日To
     * @param 支給申請日To 支給申請日To
     * @return ViewStateのデータ福祉審査_決定　List<ShokanShinseiEntityResult>
     */
    public ArrayList<ShokanShinseiEntityResult> 未審査分検索処理(RDate 支給申請日From, RDate 支給申請日To) {
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
        setグリッド(resultList);
        if (!resultList.isEmpty()) {
            div.getYoguKonyuhiShikyuShinseiMishinsaResultList().getBtnIkkatsuShinsa().setDisabled(false);
        } else {
            div.getYoguKonyuhiShikyuShinseiMishinsaResultList().getBtnIkkatsuShinsa().setDisabled(true);
        }
        div.getYoguKonyuhiShikyuShinseiMishinsaSearchCondition().setIsOpen(false);
        div.getYoguKonyuhiShikyuShinseiMishinsaResultList().setIsOpen(true);
        return resultList;
    }

    /**
     * 支給申請内容を一括審査・決定するボタンHandler処理
     */
    public void 審査決定処理() {
        List<dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row> selectedMishinsaShikyuShinsei = div.getYoguKonyuhiShikyuShinseiMishinsaResultList()
                .getDgYoguKonyuhiShisaMishinsaShikyuShinseiList().getSelectedItems();
        for (dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row row : selectedMishinsaShikyuShinsei) {
            if (限度額チェック(row) && !品目チェック(row)) {
                row.setTxtShinsaNo(ShinsaNaiyoKubun.承認する.getコード());
                row.getTxtShinsaResult().setValue(承認する);
            } else {
                row.setTxtShinsaNo(ShinsaNaiyoKubun.却下する.getコード());
                row.getTxtShinsaResult().setValue(却下する);
            }
        }
    }

    /**
     * 保存ボタンHandler処理
     *
     * @param 決定日 FlexibleDate
     * @param entityList ViewStateの福祉審査_決定
     */
    public void 保存処理(FlexibleDate 決定日, List<ShokanShinseiEntityResult> entityList) {
        List<ShokanShinseiEntityResult> updList = new ArrayList<>();
        List<dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row> selectedMishinsaShikyuShinsei = div.getYoguKonyuhiShikyuShinseiMishinsaResultList()
                .getDgYoguKonyuhiShisaMishinsaShikyuShinseiList().getSelectedItems();
        for (dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row row : selectedMishinsaShikyuShinsei) {
            if (row.getTxtShinsaNo() == null || row.getTxtShinsaNo().isEmpty()) {
                return;
            }
            ShokanShinseiEntityResult entity = entityList.get(row.getRowNum().getValue().intValue());
            entity.getEntity().get償還払請求基本Entity().setHiHokenshaNo(
                    row.getTxtHihoNo().getValue() == null || row.getTxtHihoNo().getValue().isEmpty()
                    ? HihokenshaNo.EMPTY
                    : new HihokenshaNo(row.getTxtHihoNo().getValue()));
            entity.getEntity().get償還払請求基本Entity().setServiceTeikyoYM(
                    row.getTxtTenkyoYM().getValue() == null ? FlexibleYearMonth.EMPTY
                    : new FlexibleYearMonth(row.getTxtTenkyoYM().getValue().getYearMonth().toString()));
            entity.getEntity().get償還払請求基本Entity().setSeiriNo(row.getTxtSeiriNo().getValue());
            entity.getEntity().get償還払請求基本Entity().setJigyoshaNo(
                    row.getTxtJigyoshaNo() == null || row.getTxtJigyoshaNo().isEmpty()
                    ? JigyoshaNo.EMPTY : new JigyoshaNo(row.getTxtJigyoshaNo()));
            entity.getEntity().get償還払請求基本Entity().setYoshikiNo(row.getTxtYoshikiNo());
            entity.getEntity().get償還払請求基本Entity().setMeisaiNo(row.getTxtMeisaiNo());
            entity.getEntity().set氏名(new AtenaMeisho(row.getTxtHihoName().getValue()));
            entity.getEntity().get償還払支給申請Entity().setShinseiYMD(
                    row.getTxtShikyuShinseiDate().getValue() == null ? FlexibleDate.EMPTY : new FlexibleDate(row.getTxtShikyuShinseiDate().getValue().toString()));
            entity.getEntity().get償還払支給申請Entity().setHokenTaishoHiyogaku(row.getTxtHiyoTotal().getValue());
            entity.getEntity().get償還払支給申請Entity().setRiyoshaFutangaku(
                    row.getTxtRiyoshaFutanAmount().getValue() == null ? 0 : Integer.valueOf(row.getTxtRiyoshaFutanAmount().getValue().toString()));
            entity.getEntity().get償還払支給申請Entity().setShiharaiKingakuTotal(row.getTxtHokenKyufuAmount().getValue());
            entity.getEntity().get償還払支給申請Entity().setShinsaKekka(row.getTxtShinsaNo());
            entity.getEntity().set識別コード(new ShikibetsuCode(row.getShikibetsuCode()));
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
            ShikibetsuCode 識別コード = entity.getEntity().get識別コード();
            if (支給申請日 != null && !支給申請日.isEmpty()) {
                row.getTxtShikyuShinseiDate().setValue(new RDate(支給申請日.toString()));
            }
            if (提供購入年月 != null && !提供購入年月.isEmpty()) {
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
                row.setTxtJigyoshaNo(事業者番号.getColumnValue());
            }
            if (識別コード != null) {
                row.setShikibetsuCode(識別コード.getColumnValue());
            }
            row.setSelected(Boolean.TRUE);
            row.getTxtHokenKyufuAmount().setValue(new Decimal(entity.getEntity().get償還払支給申請Entity().getHokenKyufugaku()));
            row.getTxtRiyoshaFutanAmount().setValue(new Decimal(entity.getEntity().get償還払支給申請Entity().getRiyoshaFutangaku()));
            row.getTxtHiyoTotal().setValue(entity.getEntity().get償還払支給申請Entity().getShiharaiKingakuTotal());
            row.getTxtSeiriNo().setValue(entity.getEntity().get償還払請求基本Entity().getSeiriNo());
            row.setTxtYoshikiNo(entity.getEntity().get償還払請求基本Entity().getYoshikiNo());
            row.setTxtMeisaiNo(entity.getEntity().get償還払請求基本Entity().getMeisaiNo());
            row.setTxtShinsaNo(entity.getEntity().get償還払支給申請Entity().getShinsaKekka());
            row.getRowNum().setValue(new Decimal(i));
            i = i + 1;
            rowList.add(row);
        }
        div.getYoguKonyuhiShikyuShinseiMishinsaResultList().getDgYoguKonyuhiShisaMishinsaShikyuShinseiList().setDataSource(rowList);
    }

    private Boolean 限度額チェック(dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row row) {
        HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getTxtHihoNo().getValue());
        RYearMonth サービス提供年月Row = row.getTxtTenkyoYM().getValue() == null
                ? null : row.getTxtTenkyoYM().getValue().getYearMonth();
        FlexibleYearMonth サービス提供年月 = null;
        if (サービス提供年月Row != null) {
            サービス提供年月 = new FlexibleYearMonth(サービス提供年月Row.toString());
        }
        RString 整理番号 = row.getTxtSeiriNo().getValue();
        JigyoshaNo 事業者番号 = row.getTxtJigyoshaNo() == null || row.getTxtJigyoshaNo().isEmpty()
                ? JigyoshaNo.EMPTY
                : new JigyoshaNo(row.getTxtJigyoshaNo());
        RString 様式番号 = row.getTxtYoshikiNo();
        RString 明細番号 = row.getTxtMeisaiNo();
        Decimal 今回の保険対象費用額 = row.getTxtHiyoTotal().getValue();
        return FukushiyoguKonyuhiShikyuGendogaku.createInstance().chkKonyuhiShikyuGendogaku(被保険者番号,
                サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, 今回の保険対象費用額);
    }

    private Boolean 品目チェック(dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row row) {
        HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getTxtHihoNo().getValue());
        RYearMonth サービス提供年月Row = row.getTxtTenkyoYM().getValue() == null
                ? null : row.getTxtTenkyoYM().getValue().getYearMonth();
        FlexibleYearMonth サービス提供年月 = null;
        if (サービス提供年月Row != null) {
            サービス提供年月 = new FlexibleYearMonth(サービス提供年月Row.toString());
        }
        RString 整理番号 = row.getTxtSeiriNo().getValue();
        JigyoshaNo 事業者番号 = row.getTxtJigyoshaNo() == null || row.getTxtJigyoshaNo().isEmpty()
                ? JigyoshaNo.EMPTY
                : new JigyoshaNo(row.getTxtJigyoshaNo());
        RString 様式番号 = row.getTxtYoshikiNo();
        RString 明細番号 = row.getTxtMeisaiNo();
        List<ShokanFukushiYoguHanbaihi> 福祉用具購入販売費リスト = FukushiyoguKonyuhiShikyuShinsei.createInstance()
                .getShokanFukushiYoguHanbaihi(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        return new FukushiYoguKounyuhiDouituHinmokuChofukuHantei().chkHinmokuCodePerYear(被保険者番号,
                サービス提供年月, 福祉用具購入販売費リスト, 整理番号);
    }
}
