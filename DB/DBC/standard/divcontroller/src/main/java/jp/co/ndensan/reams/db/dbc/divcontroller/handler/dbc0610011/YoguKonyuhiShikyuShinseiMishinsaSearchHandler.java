/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0610011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanFukushiYoguHanbaihi;
import jp.co.ndensan.reams.db.dbc.definition.core.shinnsanaiyo.ShinsaNaiyoKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0610011.YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0610011.dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0610011.ShikyuShinseiki;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyuikkatushinsa.ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyuikkatushinsa.FukushiyoguKonyuhiShikyuIkkatuShinsa;
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
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 福祉用具購入費支給申請審査 未審査支給申請一覧のHandlerです。
 */
public class YoguKonyuhiShikyuShinseiMishinsaSearchHandler {

    private final YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv div;
    private final RString 審査 = new RString("審査");
    private final RString 承認する = new RString("承認する");
    private final RString 却下する = new RString("却下する");

    /**
     * YoguKonyuhiShikyuShinseiMishinsaSearchHandler
     *
     * @param div 
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
        ArrayList<ShokanShinseiEntity> resultList = (ArrayList<ShokanShinseiEntity>) FukushiyoguKonyuhiShikyuIkkatuShinsa.createInstance()
                .getMiShinsaShinseiList(申請日From, 申請日To);
        if (null == resultList || resultList.isEmpty()) {
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
                .getDgYoguKonyuhiShisaMishinsaShikyuShinseiList().getSelectedItems();
        for (dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row row : selectedMishinsaShikyuShinsei) {
            if (限度額チェッ(row) == !品目チェック(row)) {
                row.getTxtShinsaNo().setValue(ShinsaNaiyoKubun.承認する.getコード());
                row.getTxtShinsaResult().setValue(承認する);
            } else {
                row.getTxtShinsaNo().setValue(ShinsaNaiyoKubun.却下する.getコード());
                row.getTxtShinsaResult().setValue(却下する);
            }
        }
    }

    /**
     * ViewStateの設定
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
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.画面モード, 審査);
        ShikyuShinseiki param = new ShikyuShinseiki(被保険者番号,
                サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
        ViewStateHolder.put(ViewStateKeys.支給申請情報検索キー, param);
    }

    /**
     * 決定日入力チェック
     *
     * @param 決定日 
     */
    public void 決定日入力チェック(RDate 決定日) {
        if (決定日 == null) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace("決定日"));
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
     * @param 決定日 
     */
    public void 保存処理(FlexibleDate 決定日) {
        List<ShokanShinseiEntity> updList = new ArrayList<>();
        List<dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row> selectedMishinsaShikyuShinsei = div.getYoguKonyuhiShikyuShinseiMishinsaResultList()
                .getDgYoguKonyuhiShisaMishinsaShikyuShinseiList().getSelectedItems();
        for (dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row row : selectedMishinsaShikyuShinsei) {
            int i = row.getRowNum().getValue().intValue();
            List<ShokanShinseiEntity> entityList = ViewStateHolder.get(ViewStateKeys.福祉審査_決定, List.class);
            ShokanShinseiEntity entity = entityList.get(i);
//            entity.get償還払請求基本Entity().setHiHokenshaNo(new HihokenshaNo(row.getTxtHihoNo().getValue()));
//            entity.get償還払請求基本Entity().setServiceTeikyoYM(new FlexibleYearMonth(row.getTxtTenkyoYM().getValue().getYearMonth().toString()));
//            entity.get償還払請求基本Entity().setSeiriNp(row.getTxtSeiriNo().getValue());
//            entity.get償還払請求基本Entity().setJigyoshaNo(new JigyoshaNo(row.getTxtJigyoshaNo().getValue()));
//            entity.get償還払請求基本Entity().setYoshikiNo(row.getTxtYoshikiNo().getValue());
//            entity.get償還払請求基本Entity().setMeisaiNo(row.getTxtMeisaiNo().getValue());
            // TODO 償還払請求基本．被保険者番号??
            entity.set氏名(new AtenaMeisho(row.getTxtHihoName().getValue()));
            entity.get償還払支給申請Entity().setShinseiYMD(new FlexibleDate(row.getTxtShikyuShinseiDate().getValue().toString()));
            entity.get償還払支給申請Entity().setHokenTaishoHiyogaku(row.getTxtHiyoTotal().getValue());
            entity.get償還払支給申請Entity().setRiyoshaFutangaku(Integer.parseInt(row.getTxtRiyoshaFutanAmount().getValue().toString()));
            entity.get償還払支給申請Entity().setShiharaiKingakuTotal(row.getTxtHokenKyufuAmount().getValue());
            entity.get償還払支給申請Entity().setShinsaKekka(row.getTxtShinsaNo().getValue());
            updList.add(entity);
        }
        FukushiyoguKonyuhiShikyuIkkatuShinsa.createInstance().updShikyuShinsei(決定日, updList);
    }

    private void setグリッド(List<ShokanShinseiEntity> resultList) {
        List<dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row> rowList = new ArrayList<>();
        int i = 0;
        for (ShokanShinseiEntity entity : resultList) {
            dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row row = new dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row();
            FlexibleDate 支給申請日 = entity.get償還払支給申請Entity().getShinseiYMD();
            FlexibleYearMonth 提供購入年月 = entity.get償還払請求基本Entity().getServiceTeikyoYM();
            if (支給申請日 != null) {
                row.getTxtShikyuShinseiDate().setValue(new RDate(支給申請日.toString()));
            }
            if (提供購入年月 != null) {
                row.getTxtTenkyoYM().setValue(new RDate(提供購入年月.toString()));
            }
            row.getTxtHihoNo().setValue(entity.get償還払請求基本Entity().getHiHokenshaNo().getColumnValue());
            // TODO 償還払請求基本．被保険者番号??
//            row.getTxtHihoName().setValue(entity.get氏名().getColumnValue());
            row.getTxtHokenKyufuAmount().setValue(new Decimal(entity.get償還払支給申請Entity().getHokenKyufugaku()));
            row.getTxtRiyoshaFutanAmount().setValue(new Decimal(entity.get償還払支給申請Entity().getRiyoshaFutangaku()));
            row.getTxtHiyoTotal().setValue(entity.get償還払支給申請Entity().getShiharaiKingakuTotal());
            row.getTxtShinsaResult().setValue(ShinsaNaiyoKubun.toValue(entity.get償還払支給申請Entity().getShinsaKekka()).get名称());
            row.getTxtSeiriNo().setValue(entity.get償還払請求基本Entity().getSeiriNp());
            row.getTxtJigyoshaNo().setValue(new RString(entity.get償還払請求基本Entity().getJigyoshaNo().getColumnValue().toString()));
            row.getTxtYoshikiNo().setValue(entity.get償還払請求基本Entity().getYoshikiNo());
            row.getTxtMeisaiNo().setValue(entity.get償還払請求基本Entity().getMeisaiNo());
            row.getRowNum().setValue(new Decimal(i));
            i = i + 1;
            rowList.add(row);
        }
        div.getYoguKonyuhiShikyuShinseiMishinsaResultList().getDgYoguKonyuhiShisaMishinsaShikyuShinseiList().setDataSource(rowList);
    }

    private Boolean 限度額チェッ(dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row row) {
        HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getTxtHihoNo().getValue());
//        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(row.getTxtTenkyoYM().getValue().getYearMonth().toString());
//        RString 整理番号 = row.getTxtSeiriNo().getValue();
//        JigyoshaNo 事業者番号 = new JigyoshaNo(row.getTxtJigyoshaNo().getValue());
//        RString 様式番号 = row.getTxtYoshikiNo().getValue();
//        RString 明細番号 = row.getTxtMeisaiNo().getValue();
//        Decimal 今回の保険対象費用額 = row.getTxtHiyoTotal().getValue();
        // TODO 
//        return new FukushiyoguKonyuhiShikyuGendogakuValidate().chkKonyuhiShikyuGendogaku(被保険者番号,
//                サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, 今回の保険対象費用額);
        return 被保険者番号 == null;
    }

    private Boolean 品目チェック(dgYoguKonyuhiShisaMishinsaShikyuShinseiList_Row row) {
        HihokenshaNo 被保険者番号 = new HihokenshaNo(row.getTxtHihoNo().getValue());
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(row.getTxtTenkyoYM().getValue().getYearMonth().toString());
        RString 整理番号 = row.getTxtSeiriNo().getValue();
        JigyoshaNo 事業者番号 = new JigyoshaNo(row.getTxtJigyoshaNo().getValue());
        RString 様式番号 = row.getTxtYoshikiNo().getValue();
        RString 明細番号 = row.getTxtMeisaiNo().getValue();
        List<ShokanFukushiYoguHanbaihi> yoguHanbaihiList = FukushiyoguKonyuhiShikyuShinsei.createInstance()
                .getShokanFukushiYoguHanbaihi(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号);
//        List<DbT3048ShokanFukushiYoguHanbaihiEntity> entityList = new ArrayList<>();
//        for(ShokanFukushiYoguHanbaihi yoguhanbaihi : yoguHanbaihiList) {
//            entityList.add(yoguhanbaihi.toEntity());
//        }
//        return new FukushiYoguKounyuhiDouituHinmokuChofukuHantei().chkHinmokuCodePerYear(被保険者番号,
//                サービス提供年月, entityList, 整理番号);
        return yoguHanbaihiList == null;
    }
}
