/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0600021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanFukushiYoguHanbaihi;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei.FukushiYoguKonyuhiShikyuShiseiMeisaiDivEntity;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei.SokanbaraiShiharaiKekkaResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shinsahoho.ShinsaHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shinseisha.ShinseishaKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.config.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600021.YoguKonyuhiShikyuShinseiPnlTotalDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600021.dgSeikyuDetail_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.KyufugakuSummaryDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0600011.PnlTotalParameter;
import jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei.FukushiyoguKonyuhiShikyuShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.kijunt.IKoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.service.core.kijuntsukishichosonjoho.KijuntsukiShichosonjohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 画面設計_DBCMN51001_福祉用具購入費支給申請_明細登録
 *
 * @reamsid_L DBC-1020-030 quxiaodong
 */
public class YoguKonyuhiShikyuShinseiPnlTotalHandler {

    private final YoguKonyuhiShikyuShinseiPnlTotalDiv div;
    private static final RString 申請者区分BLANK = new RString("0");
    private static final RString コード種別 = new RString("0006");
    private static final RString KEY = new RString("key0");
    private static final RString NUM3 = new RString("0000000000");
    private static final RString NUM1 = new RString("0001");
    private static final RString NUMB1 = new RString("1");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 審査 = new RString("審査");
    private static final RString 処理モード登録 = new RString("処理モード登録");
    private static final RString 処理モード修正 = new RString("処理モード修正");
    private static final RString 処理モード削除 = new RString("処理モード削除");
    private static final RString 処理モード選択 = new RString("処理モード選択");
    private static final RString 申請を保存する = new RString("btnUpdate");
    private static final RString 種目コード = new RString("種目コード");
    private static final RString 品目コード = new RString("品目コード");
    private static final RString 購入年月日 = new RString("購入年月日");
    private static final RString 領収年月日 = new RString(
            "領収年月日にサービス提供年月より前の日付が設定されています。よろしいですか？");

    /**
     * 初期化
     *
     * @param div YoguKonyuhiShikyuShinseiPnlTotalDiv
     */
    public YoguKonyuhiShikyuShinseiPnlTotalHandler(YoguKonyuhiShikyuShinseiPnlTotalDiv div) {
        this.div = div;
    }

    /**
     * 支給申請内容エリア
     *
     * @param shokankihon ShokanKihon
     * @param shokanshinsei ShokanShinsei
     *
     */
    public void 支給申請内容エリア(ShokanKihon shokankihon, ShokanShinsei shokanshinsei) {
        if (shokankihon.getサービス提供年月() != null) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtTeikyoYM().setValue(
                    new RDate(shokankihon.getサービス提供年月().toString()));
        }
        if (shokankihon.get整理番号() != null) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSeiriNo().setValue(shokankihon.get整理番号());
        }
        if (shokankihon.get保険給付率() != null) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtKyufuritsu().setValue(shokankihon.get保険給付率().value());
        }
        if (shokanshinsei.is国保連再送付フラグ()) {
            List<RString> list = new ArrayList<>();
            list.add(KEY);
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getChkKokuhorenSend().setSelectedItemsByKey(list);
        }
        if (shokankihon.get事業者番号() != null) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtJigyoshaNo().setValue(shokankihon.get事業者番号().value());
        }

    }

    /**
     * get証明書
     *
     * @param shokankihon ShokanKihon
     * @param 略称 RString
     */
    public void get証明書(ShokanKihon shokankihon, RString 略称) {
        RStringBuilder builder = new RStringBuilder();
        if (shokankihon.get様式番号() != null) {
            builder.append(shokankihon.get様式番号());
        }
        if (略称 != null) {
            builder.append(略称);
        }
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSyomeisyo().setValue(builder.toRString());
    }

    /**
     * 支給申請内容エリア．保険者
     *
     * @param shokankihon ShokanKihon
     * @return dataSourceList
     */
    public List<KeyValueDataSource> get保険者(ShokanKihon shokankihon) {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        RString 導入形態 = ShichosonSecurityJoho.getShichosonSecurityJoho(
                GyomuBunrui.介護事務).get導入形態コード().value();
        FlexibleDate 基準年月 = null;
        if (shokankihon.getサービス提供年月() != null) {
            基準年月 = new FlexibleDate(shokankihon.getサービス提供年月().toString());
        }
        List<IKoseiShichosonMaster> kilist = KijuntsukiShichosonjohoFinder.createInstance().getKijuntsukiShichosonjohos(
                基準年月, 導入形態);
        for (IKoseiShichosonMaster list : kilist) {
            KeyValueDataSource dataSource = new KeyValueDataSource(
                    list.get市町村コード().value(), list.get証記載保険者番号().value());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    /**
     * 支給申請内容エリア．種目
     *
     * @return dataSourceList
     */
    public List<KeyValueDataSource> get種目() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        List<UzT0007CodeEntity> costlist = CodeMaster.getCode(
                SubGyomuCode.DBC介護給付, new CodeShubetsu(コード種別), FlexibleDate.getNowDate());
        for (UzT0007CodeEntity list : costlist) {
            KeyValueDataSource dataSource = new KeyValueDataSource(list.getコード().value(), list.getコード名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    /**
     * 福祉用具販売費情報取得
     *
     * @param shfuyoHanb List<ShokanFukushiYoguHanbaihi>
     */
    public void 福祉用具販売費情報(List<ShokanFukushiYoguHanbaihi> shfuyoHanb) {
        List<dgSeikyuDetail_Row> rowList = new ArrayList<>();
        for (ShokanFukushiYoguHanbaihi shfu : shfuyoHanb) {
            dgSeikyuDetail_Row row = new dgSeikyuDetail_Row();
            if (shfu.get福祉用具販売年月日() != null) {
                row.getTxtBuyYMD().setValue(new RDate(shfu.get福祉用具販売年月日().toString()));
            }
            row.getTxtShumoku().setValue(shfu.get福祉用具種目コード());
            row.getTxtShohinName().setValue(shfu.get福祉用具商品名());
            row.getTxtBuyAmount().setValue(new Decimal(shfu.get購入金額()));
            if (shfu.get審査方法区分コード() != null) {
                row.getTxtShinsaMethod().setValue(ShinsaHohoKubun.toValue(shfu.get審査方法区分コード()).get名称());
            }
            row.getFukushiYoguSeizoJigyoshaName().setValue(shfu.get福祉用具製造事業者名());
            row.getFukushiYoguHanbaiJigyoshaName().setValue(shfu.get福祉用具販売事業者名());
            row.getHinmokuCode().setValue(shfu.get品目コード());
            row.setRenban(shfu.get連番());
            row.setTxtShinsa(shfu.get審査方法区分コード());
            rowList.add(row);
        }
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().setDataSource(rowList);
    }

    /**
     * set福祉用具購入費明細
     */
    public void set福祉用具購入費明細() {
        dgSeikyuDetail_Row row = div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().getClickedItem();
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtBuyYMD().
                setValue(row.getTxtBuyYMD().getValue());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getDdlShumoku().
                setSelectedKey(row.getTxtShumoku().getValue());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtShohinName().
                setValue(row.getTxtShohinName().getValue());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtSeizoJigyosha().
                setValue(row.getFukushiYoguSeizoJigyoshaName().getValue());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtHanbaiJigyosha().
                setValue(row.getFukushiYoguHanbaiJigyoshaName().getValue());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtBuyAmount().
                setValue(row.getTxtBuyAmount().getValue());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtHinmokuCode().
                setValue(row.getHinmokuCode().getValue());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getRadShinsaMethod().
                setSelectedValue(row.getTxtShinsaMethod().getValue());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getRowId().setValue(new Decimal(row.getId()));

    }

    /**
     * readOnly福祉用具購入費明細
     *
     * @param flag boolean
     */
    public void readOnly福祉用具購入費明細(boolean flag) {
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtBuyYMD().setReadOnly(flag);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getDdlShumoku().setReadOnly(flag);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtShohinName().setReadOnly(flag);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtSeizoJigyosha().setReadOnly(flag);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtHanbaiJigyosha().setReadOnly(flag);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtBuyAmount().setReadOnly(flag);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtHinmokuCode().setReadOnly(flag);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getRadShinsaMethod().setReadOnly(flag);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getBtnClear().setDisabled(flag);
    }

    /**
     * setDgSeikyuDetail
     *
     * @param row dgSeikyuDetail_Row
     */
    public void setDgSeikyuDetail(dgSeikyuDetail_Row row) {
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtBuyYMD() != null) {
            row.getTxtBuyYMD().setValue(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getYoguKonyuhiDetailInput().getTxtBuyYMD().getValue());
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getDdlShumoku() != null) {
            row.getTxtShumoku().setValue(
                    div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                    getDdlShumoku().getSelectedValue());
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtShohinName() != null) {
            row.getTxtShohinName().setValue(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getYoguKonyuhiDetailInput().getTxtShohinName().getValue());
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtSeizoJigyosha() != null) {
            row.setFukushiYoguSeizoJigyoshaName(
                    div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtSeizoJigyosha());
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtHanbaiJigyosha() != null) {
            row.setFukushiYoguHanbaiJigyoshaName(
                    div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtHanbaiJigyosha());
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtBuyAmount() != null) {
            row.getTxtBuyAmount().setValue(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getYoguKonyuhiDetailInput().getTxtBuyAmount().getValue());
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtHinmokuCode() != null) {
            row.getHinmokuCode().setValue(div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                    getTxtHinmokuCode().getValue());
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getRadShinsaMethod() != null) {
            row.getTxtShinsaMethod().setValue(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getYoguKonyuhiDetailInput().getRadShinsaMethod().getSelectedValue());
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getRadShinsaMethod() != null) {
            row.setTxtShinsa(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getYoguKonyuhiDetailInput().getRadShinsaMethod().getSelectedKey());
        }
        if (処理モード登録.equals(ViewStateHolder.get(ViewStateKeys.処理モード, RString.class))) {
            List<dgSeikyuDetail_Row> list = div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getDgSeikyuDetail().getDataSource();
            list.add(row);
        }
        clear福祉用具購入費明細();
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().setVisible(false);

    }

    /**
     * clear福祉用具購入費明細
     */
    public void clear福祉用具購入費明細() {
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtBuyYMD().clearValue();
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtShohinName().clearValue();
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtSeizoJigyosha().clearValue();
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtHanbaiJigyosha().clearValue();
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtBuyAmount().clearValue();
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtHinmokuCode().clearValue();
    }

    /**
     * 今までの支払結果情報
     *
     * @param soshkere SokanbaraiShiharaiKekkaResult
     */
    public void 今までの支払結果情報(SokanbaraiShiharaiKekkaResult soshkere) {
        KyufugakuSummaryDiv kyusummary = (KyufugakuSummaryDiv) div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getCcdKyufuGakuSummay();
        kyusummary.getTblSeikyuSummary().getTxtPayTotalMae().setValue(soshkere.get費用額合計());
        kyusummary.getTblSeikyuSummary().getTxtHokenSeikyuAmountMae().setValue(soshkere.get保険対象費用額());
        kyusummary.getTblSeikyuSummary().getTxtRiyoshaFutanAmountMae().setValue(new Decimal(soshkere.get保険給付額()));
        kyusummary.getTblSeikyuSummary().getTxtLimitOverAmountMae().setValue(new Decimal(soshkere.get利用者負担額()));
    }

    /**
     * 今回登録済みの支払結果情報
     *
     * @param soshkere SokanbaraiShiharaiKekkaResult
     */
    public void 今回登録済みの支払結果情報(SokanbaraiShiharaiKekkaResult soshkere) {
        KyufugakuSummaryDiv kyusummary = (KyufugakuSummaryDiv) div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getCcdKyufuGakuSummay();
        kyusummary.getTblSeikyuSummary().getTxtPayTotalNow().setValue(soshkere.get費用額合計());
        kyusummary.getTblSeikyuSummary().getTxtHokenSeikyuAmountNow().setValue(soshkere.get保険対象費用額());
        kyusummary.getTblSeikyuSummary().getTxtRiyoshaFutanAmountNow().setValue(new Decimal(soshkere.get保険給付額()));
        kyusummary.getTblSeikyuSummary().getTxtLimitOverAmountNow().setValue(new Decimal(soshkere.get利用者負担額()));
    }

    /**
     * 今回の支払状況連動
     *
     * @param soshkere SokanbaraiShiharaiKekkaResult
     * @param hokenKyufuritsu HokenKyufuRitsu
     */
    public void 今回の支払状況連動(SokanbaraiShiharaiKekkaResult soshkere, HokenKyufuRitsu hokenKyufuritsu) {
        KyufugakuSummaryDiv kyusummary = (KyufugakuSummaryDiv) div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getCcdKyufuGakuSummay();
        Decimal 保険給付額 = null;
        kyusummary.getTblSeikyuSummary().getTxtPayTotalNow().setValue(soshkere.get費用額合計());
        kyusummary.getTblSeikyuSummary().getTxtHokenSeikyuAmountNow().setValue(soshkere.get保険対象費用額());
        if (soshkere.get費用額合計() != null && hokenKyufuritsu.value() != null) {
            保険給付額 = soshkere.get費用額合計().multiply(hokenKyufuritsu.value());
        }
        kyusummary.getTblSeikyuSummary().getTxtRiyoshaFutanAmountNow().setValue(保険給付額);
        if (soshkere.get費用額合計() != null && 保険給付額 != null) {
            kyusummary.getTblSeikyuSummary().getTxtLimitOverAmountNow().setValue(
                    soshkere.get費用額合計().subtract(保険給付額));
        }
    }

    /**
     * 償還払支給申請情報取得
     *
     * @param shokanshinsei ShokanShinsei
     */
    public void 償還払支給申請情報(ShokanShinsei shokanshinsei) {
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getDdlShinseisyakubun().
                setDataSource(get申請者区分リスト());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseibi().setValue(
                new RDate(shokanshinsei.get申請年月日().toString()));
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtUkechikebi().setValue(
                new RDate(shokanshinsei.get受付年月日().toString()));
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtRyosyuYMD().setValue(
                new RDate(shokanshinsei.get領収年月日().toString()));
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getDdlShinseisyakubun().setSelectedKey(
                shokanshinsei.get申請者区分());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseiriyu().setValue(
                shokanshinsei.get申請理由());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtJigyosya().setValue(
                shokanshinsei.get申請事業者コード().value());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShimei().setValue(
                shokanshinsei.get申請者氏名());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShimeiKana().setValue(
                shokanshinsei.get申請者氏名カナ());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseisyaTel().setDomain(
                shokanshinsei.get申請者電話番号());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsakekka().
                getRadShinsakekka().setSelectedKey(shokanshinsei.get審査結果());
        //TODO
//        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseisyaYubin().setValue(
//                new YubinNo(shokanshinsei.get申請者住所()));
    }

    /**
     * 保存処理
     */
    public void 保存処理() {
        PnlTotalParameter parameter = ViewStateHolder.get(ViewStateKeys.支給申請情報検索キー,
                PnlTotalParameter.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth サービス提供年月 = parameter.getTeikyoYM();
        RString 整理番号 = parameter.getSerialNo();
        RString 様式番号 = parameter.getYoshikiNo();
        JigyoshaNo 事業者番号 = parameter.getJigyosyaNo();
        List<ShokanFukushiYoguHanbaihi> entityList = new ArrayList<>();
        List<dgSeikyuDetail_Row> dgrow = div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getDgSeikyuDetail().getDataSource();
        ShokanKihon shokankihon = ViewStateHolder.get(ViewStateKeys.福祉償還払請求基本, ShokanKihon.class);
        ShokanShinsei shshResult = ViewStateHolder.get(ViewStateKeys.福祉償還払支給申請, ShokanShinsei.class);
        ShokanShukei 償還払請求集計 = ViewStateHolder.get(ViewStateKeys.福祉償還払請求集計, ShokanShukei.class);
        int max連番 = 0;
        List<ShokanFukushiYoguHanbaihi> shkonlist = ViewStateHolder.get(
                ViewStateKeys.福祉用具販売費, List.class);
        Map<RString, ShokanFukushiYoguHanbaihi> mapList = new HashMap<>();
        for (ShokanFukushiYoguHanbaihi meisaiResult : shkonlist) {
            mapList.put(meisaiResult.get連番(), meisaiResult);
            if (max連番 < Integer.parseInt(meisaiResult.get連番().toString())) {
                max連番 = Integer.parseInt(meisaiResult.get連番().toString());
            }
        }
        for (dgSeikyuDetail_Row row : dgrow) {
            if (RowState.Modified.equals(row.getRowState())) {
                ShokanFukushiYoguHanbaihi entityModified = mapList.get(row.getRenban());
                entityModified = buildshokanFukushi(entityModified, row);
                entityList.add(entityModified.modified());

            } else if (RowState.Deleted.equals(row.getRowState())) {
                entityList.add(mapList.get(row.getRenban()).deleted());
            } else if (RowState.Added.equals(row.getRowState())) {
                max連番 = max連番 + 1;
                ShokanFukushiYoguHanbaihi entityAdded = new ShokanFukushiYoguHanbaihi(
                        被保険者番号,
                        サービス提供年月,
                        整理番号,
                        事業者番号,
                        様式番号,
                        NUM1,
                        new RString(String.format("%02d", max連番))).createBuilderForEdit().build();
                entityAdded = buildshokanFukushi(entityAdded, row);
                entityList.add(entityAdded.added());
            }
        }
        ShokanKihon 償還払請求基本 = get償還払請求基本(shokankihon);
        ShokanShinsei 償還払支給申請 = get償還払支給申請(shshResult);

        if (削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            FukushiyoguKonyuhiShikyuShinsei.createInstance().
                    delete(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, NUM1);
        } else if (修正.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            FukushiYoguKonyuhiShikyuShiseiMeisaiDivEntity fuentity = FukushiYoguKonyuhiShikyuShiseiMeisaiDivEntity.
                    createEntity(修正, 償還払請求基本, 償還払支給申請, 償還払請求集計);
            fuentity.add福祉用具販売費リスト(修正, entityList);
            FukushiyoguKonyuhiShikyuShinsei.createInstance().update(fuentity);
        } else if (登録.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            FukushiYoguKonyuhiShikyuShiseiMeisaiDivEntity fuentity = FukushiYoguKonyuhiShikyuShiseiMeisaiDivEntity.
                    createEntity(登録, 償還払請求基本, 償還払支給申請, 償還払請求集計);
            fuentity.add福祉用具販売費リスト(登録, entityList);
            FukushiyoguKonyuhiShikyuShinsei.createInstance().insert(fuentity);

        } else if (審査.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
            FukushiYoguKonyuhiShikyuShiseiMeisaiDivEntity fuentity = FukushiYoguKonyuhiShikyuShiseiMeisaiDivEntity.
                    createEntity(審査, 償還払請求基本, 償還払支給申請, 償還払請求集計);
            fuentity.add福祉用具販売費リスト(審査, entityList);
            FukushiyoguKonyuhiShikyuShinsei.createInstance().updShinsa(fuentity);
        }
    }

    private ShokanKihon get償還払請求基本(ShokanKihon entity) {
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtTeikyoYM() != null) {
            entity = entity.createBuilderForEdit().setサービス提供年月(new FlexibleYearMonth(div.
                    getYoguKonyuhiShikyuShinseiContentsPanel().getTxtTeikyoYM().getValue().getYearMonth().toString())).build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getChkKokuhorenSend() != null) {
            entity = entity.createBuilderForEdit().set事業者番号(new JigyoshaNo(
                    div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtJigyoshaNo().getValue())).build();
        }
        return entity;
    }

    private ShokanShinsei get償還払支給申請(ShokanShinsei entity) {
        entity = clearsShokanShinsei(entity);
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getChkKokuhorenSend().getSelectedKeys() != null) {
            entity = entity.createBuilderForEdit().set国保連再送付フラグ(true).build();
        } else {
            entity = entity.createBuilderForEdit().set国保連再送付フラグ(false).build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getDdlShityoson().getSelectedKey() != null) {
            entity = entity.createBuilderForEdit().set証記載保険者番号(new ShoKisaiHokenshaNo(
                    div.getYoguKonyuhiShikyuShinseiContentsPanel().getDdlShityoson().getSelectedKey())).build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getDdlShityoson().getSelectedKey() != null) {
            entity = entity.createBuilderForEdit().set証記載保険者番号(new ShoKisaiHokenshaNo(
                    div.getYoguKonyuhiShikyuShinseiContentsPanel().getDdlShityoson().getSelectedKey())).build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsakekka().
                getRadShinsakekka().getSelectedKey() != null) {
            entity = entity.createBuilderForEdit().set審査結果(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getPnlShinsakekka().getRadShinsakekka().getSelectedKey()).build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseibi() != null) {
            entity = entity.createBuilderForEdit().set申請年月日(new FlexibleDate(
                    div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().
                    getTxtShinseibi().toString())).build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtUkechikebi() != null) {
            entity = entity.createBuilderForEdit().set受付年月日(new FlexibleDate(
                    div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getPnlShinsesyaJoho().getTxtUkechikebi().toString())).build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtRyosyuYMD() != null) {
            entity = entity.createBuilderForEdit().set領収年月日(new FlexibleDate(
                    div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getPnlShinsesyaJoho().getTxtUkechikebi().toString())).build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getDdlShinseisyakubun().getSelectedKey() != null) {
            entity = entity.createBuilderForEdit().set申請者区分(
                    div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().
                    getDdlShinseisyakubun().getSelectedKey()).build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseiriyu() != null) {
            entity = entity.createBuilderForEdit().set申請理由(
                    div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseiriyu().getValue()).build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtJigyosya() != null) {
            entity = entity.createBuilderForEdit().set申請事業者コード(new JigyoshaNo(
                    div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getPnlShinsesyaJoho().getTxtJigyosya().toString())).build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShimei() != null) {
            entity = entity.createBuilderForEdit().set申請者氏名(
                    div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getPnlShinsesyaJoho().getTxtShimei().getValue()).build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShimeiKana() != null) {
            entity = entity.createBuilderForEdit().set申請者氏名カナ(
                    div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getPnlShinsesyaJoho().getTxtShimeiKana().getValue()).build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseisyaTel() != null) {
            entity = entity.createBuilderForEdit().set申請者電話番号(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getPnlShinsesyaJoho().getTxtShinseisyaTel().getDomain()).build();
        }
        //TODO申請者住所
        return entity;
    }

    private ShokanShinsei clearsShokanShinsei(ShokanShinsei entity) {
        entity = entity.createBuilderForEdit()
                .set国保連再送付フラグ(false)
                .set審査結果(NUMB1)
                .set申請年月日(null)
                .set申請者区分(KEY)
                .set申請理由(null)
                .set申請事業者コード(null)
                .set申請者氏名(null)
                .set申請者氏名カナ(null)
                //TODO申請者住所
                .set申請者電話番号(null).build();
        return entity;
    }

    private ShokanFukushiYoguHanbaihi buildshokanFukushi(ShokanFukushiYoguHanbaihi entity, dgSeikyuDetail_Row row) {
        entity = clearshokanShukei(entity);
        if (row.getTxtBuyYMD() != null) {
            entity = entity.createBuilderForEdit().set福祉用具販売年月日(
                    new FlexibleDate(row.getTxtBuyYMD().getValue().toString())).build();
        }
        if (row.getTxtShumoku().getValue() != null) {
            entity = entity.createBuilderForEdit().set福祉用具種目コード(row.getTxtShumoku().getValue()).build();
        }
        if (row.getTxtShohinName().getValue() != null) {
            entity = entity.createBuilderForEdit().set福祉用具商品名(row.getTxtShohinName().getValue()).build();
        }
        if (row.getFukushiYoguSeizoJigyoshaName().getValue() != null) {
            entity = entity.createBuilderForEdit().set福祉用具製造事業者名(row.getFukushiYoguSeizoJigyoshaName().getValue()).build();
        }
        if (row.getFukushiYoguHanbaiJigyoshaName().getValue() != null) {
            entity = entity.createBuilderForEdit().set福祉用具販売事業者名(row.getFukushiYoguHanbaiJigyoshaName().getValue()).build();
        }
        if (row.getTxtBuyAmount().getValue() != null) {
            entity = entity.createBuilderForEdit().set購入金額(row.getTxtBuyAmount().getValue().intValue()).build();
        }
        if (row.getHinmokuCode().getValue() != null) {
            entity = entity.createBuilderForEdit().set品目コード(row.getHinmokuCode().getValue()).build();
        }
        if (row.getTxtShinsa() != null) {
            entity = entity.createBuilderForEdit().set審査方法区分コード(row.getTxtShinsa()).build();
        }
        return entity;

    }

    private ShokanFukushiYoguHanbaihi clearshokanShukei(ShokanFukushiYoguHanbaihi entity) {
        entity = entity.createBuilderForEdit()
                .set福祉用具販売年月日(null)
                .set福祉用具種目コード(null)
                .set福祉用具商品名(null)
                .set福祉用具製造事業者名(null)
                .set福祉用具販売事業者名(null)
                .set購入金額(0)
                .set品目コード(null)
                .set審査方法区分コード(null).build();
        return entity;
    }

    /**
     * 確定チェック
     *
     * @return validPairs
     */
    public ValidationMessageControlPairs 確定チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        PnlTotalParameter parameter = ViewStateHolder.get(ViewStateKeys.支給申請情報検索キー,
                PnlTotalParameter.class);
        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.被保険者番号, HihokenshaNo.class);
        FlexibleYearMonth サービス提供年月 = parameter.getTeikyoYM();
        RString 整理番号 = parameter.getSerialNo();
        RString 様式番号 = parameter.getYoshikiNo();
        JigyoshaNo 事業者番号 = parameter.getJigyosyaNo();
        List<dgSeikyuDetail_Row> rowData = div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().getDataSource();
        rowData.remove(div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().getClickedItem());
        RString ddlShumoku = div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getYoguKonyuhiDetailInput().getDdlShumoku().getSelectedKey();
        RString hinmokuCode = div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getYoguKonyuhiDetailInput().getTxtHinmokuCode().getValue();
        if (RowState.Deleted.equals(selectRow().getRowState())) {
            return validPairs;
        }
        for (dgSeikyuDetail_Row row : rowData) {
            if (ddlShumoku.equals(row.getTxtShumoku().getValue()) && RowState.Deleted.equals(row.getRowState())) {
                validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                        UrErrorMessages.既に登録済, 種目コード.toString())));
            }
            if (hinmokuCode != null && hinmokuCode.equals(row.getHinmokuCode().getValue())
                    && RowState.Deleted.equals(row.getRowState())) {
                validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                        UrErrorMessages.既に登録済, 品目コード.toString())));
            }
        }
        if (null != div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getTxtTeikyoYM() && div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getYoguKonyuhiDetailInput().getTxtBuyYMD() != null && !div.getYoguKonyuhiShikyuShinseiContentsPanel()
                .getTxtTeikyoYM().getValue().getYearMonth().equals(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                        getYoguKonyuhiDetailInput().getTxtBuyYMD().getValue().getYearMonth())) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.入力値が不正_追加メッセージあり, 購入年月日.toString())));
        }
        return validPairs;
    }

    /**
     * 保存チェック
     *
     * @return validPairs
     */
    public ValidationMessageControlPairs 保存チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
//        RString hinmokuCode = div.getYoguKonyuhiShikyuShinseiContentsPanel().
//                getYoguKonyuhiDetailInput().getTxtHinmokuCode().getValue();
//        RYear buyY = div.getYoguKonyuhiShikyuShinseiContentsPanel().
//                getYoguKonyuhiDetailInput().getTxtBuyYMD().getValue().getYear();
//        RString ddlShumoku = div.getYoguKonyuhiShikyuShinseiContentsPanel().
//                getYoguKonyuhiDetailInput().getDdlShumoku().getSelectedKey();
//        if (!削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
//            for (ShokanFukushiYoguHanbaihi shlist : shfuhalist) {
//                if (buyY.equals(new RYear(shlist.getサービス提供年月().getYear().toString()))
//                        && hinmokuCode.equals(shlist.get品目コード())) {
//                    validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
//                            UrWarningMessages.重複, 品目コード.toString())));
//                }
//            }
//        }
//        if (!削除.equals(ViewStateHolder.get(ViewStateKeys.状態, RString.class))) {
//            for (ShokanFukushiYoguHanbaihi shlist : shfuhalist) {
//                if (ddlShumoku.equals(shlist.get福祉用具種目コード())) {
//                    validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
//                            UrWarningMessages.重複, 種目コード.toString())));
//                }
//            }
//        }
        RYearMonth ryosyuYMD = div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().
                getTxtRyosyuYMD().getValue().getYearMonth();
        List<dgSeikyuDetail_Row> rowData = div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().getDataSource();
        for (dgSeikyuDetail_Row row : rowData) {
            if (RowState.Deleted.equals(row.getRowState())) {
                continue;
            }
            RYearMonth teikyoYM = row.getTxtBuyYMD().getValue().getYearMonth();
            if (ryosyuYMD != null && (ryosyuYMD.compareTo(teikyoYM) < 0)) {
                validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                        UrWarningMessages.保存の確認, 領収年月日.toString())));
            }
        }
        //TODO限度額チェック
        return validPairs;
    }

    /**
     * selectRow
     *
     * @return dgSeikyuDetail_Row
     */
    public dgSeikyuDetail_Row selectRow() {
        return div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().getDataSource().get(
                Integer.parseInt(div.getYoguKonyuhiShikyuShinseiContentsPanel().getRowId().getValue().toString()));

    }

    /**
     * modifyRow
     *
     * @param row dgSeikyuDetail_Row
     */
    public void modifyRow(dgSeikyuDetail_Row row) {
        RString state = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
        if (処理モード修正.equals(state)) {
            boolean flag = checkState(row);
            if (flag) {
                row.setRowState(RowState.Modified);
                setDgSeikyuDetail(row);
            }
        } else if (処理モード削除.equals(state)) {
            if (RowState.Added.equals(row.getRowState())) {
                div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().getDataSource().remove(
                        Integer.parseInt(div.getYoguKonyuhiShikyuShinseiContentsPanel().getRowId().toString()));
                clear福祉用具購入費明細();
                div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().setDisabled(true);
            } else {
                row.setRowState(RowState.Deleted);
                setDgSeikyuDetail(row);
            }
        } else if (処理モード登録.equals(state)) {
            row.setRowState(RowState.Added);
            setDgSeikyuDetail(row);
        }
    }

    private boolean checkState(dgSeikyuDetail_Row ddgRow) {
        checkState1(ddgRow);
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtBuyAmount() == null && ddgRow.getTxtBuyAmount() != null) {
            return true;
        } else if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtBuyAmount() != null && !(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getYoguKonyuhiDetailInput().getTxtBuyAmount().equals(ddgRow.getTxtBuyAmount()))) {
            return true;
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtSeizoJigyosha() == null && ddgRow.getFukushiYoguSeizoJigyoshaName() != null) {
            return true;
        } else if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtSeizoJigyosha() != null && !(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getYoguKonyuhiDetailInput().getTxtSeizoJigyosha().getValue().equals(
                        ddgRow.getFukushiYoguSeizoJigyoshaName().getValue()))) {
            return true;
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtHanbaiJigyosha() == null && ddgRow.getFukushiYoguHanbaiJigyoshaName() != null) {
            return true;
        } else if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtHanbaiJigyosha() != null && !(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getYoguKonyuhiDetailInput().getTxtHanbaiJigyosha().getValue().equals(
                        ddgRow.getFukushiYoguHanbaiJigyoshaName().getValue()))) {
            return true;
        }
        return !ddgRow.getHinmokuCode().getValue().equals(div.
                getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtHinmokuCode().getValue());
    }

    private boolean checkState1(dgSeikyuDetail_Row ddgRow) {
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtBuyYMD() == null
                && ddgRow.getTxtBuyYMD() != null) {
            return true;
        } else if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtBuyYMD() != null
                && !(div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtBuyYMD().getValue().
                equals(ddgRow.getTxtBuyYMD().getValue()))) {
            return true;
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getDdlShumoku() == null
                && ddgRow.getTxtShumoku() != null) {
            return true;
        } else if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getDdlShumoku() != null
                && !(div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getDdlShumoku().
                getSelectedValue().equals(ddgRow.getTxtShumoku().getValue()))) {
            return true;
        }
        return !ddgRow.getTxtShohinName().getValue().equals(
                div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtShohinName().getValue());
    }

    /**
     * get給付率
     *
     * @param hokenKyufuritsu HokenKyufuRitsu
     */
    public void get給付率(HokenKyufuRitsu hokenKyufuritsu) {
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtKyufuritsu().setValue(hokenKyufuritsu.value());
    }

    /**
     * is内容変更状態
     *
     *
     * @return false
     */
    public boolean is内容変更状態() {
        for (dgSeikyuDetail_Row ddgList : div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getDgSeikyuDetail().getDataSource()) {
            if (RowState.Modified.equals(ddgList.getRowState())
                    || RowState.Added.equals(ddgList.getRowState())
                    || RowState.Deleted.equals(ddgList.getRowState())) {
                return true;
            }
        }
        //todo
        return true;
    }

    private List<KeyValueDataSource> get申請者区分リスト() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        KeyValueDataSource dataSourceBlank = new KeyValueDataSource(申請者区分BLANK, RString.EMPTY);
        dataSourceList.add(dataSourceBlank);
        for (ShinseishaKubun 申請者区分 : ShinseishaKubun.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(申請者区分.getコード(), 申請者区分.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    /**
     * 登録モード
     */
    public void set登録モード() {
        int 設定値 = 0;
        RString 設定値の年月 = BusinessConfig.get(ConfigNameDBC.初期表示_償還支給申請登録初期, SubGyomuCode.DBC介護給付);
        if (!設定値の年月.isNullOrEmpty()) {
            設定値 = Integer.valueOf(設定値の年月.toString());
        }
        div.getPnlButton().getBtnKetteiJoho().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSyomeisyo().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().
                getGridSetting().setIsShowSelectButtonColumn(false);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtTeikyoYM().setValue(
                new RDate(RDate.getNowDate().getYearMonth().minusMonth(設定値).toString()));
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSeiriNo().clearValue();
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtKyufuritsu().clearValue();
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtJigyoshaNo().setValue(NUM3);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().setVisible(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtBuyYMD().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getDdlShumoku().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtShohinName().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtSeizoJigyosha().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtHanbaiJigyosha().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtBuyAmount().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getRadShinsaMethod().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtHinmokuCode().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getBtnClear().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getBtnModifyDetail().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsakekka().setVisible(false);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtUkechikebi().clearValue();
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtRyosyuYMD().clearValue();
        div.getPnlKeteiJohoMsg().getCcdMessage().setVisible(false);
    }

    /**
     * 修正モード
     */
    public void set修正モード() {
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtTeikyoYM().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDdlShityoson().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSyomeisyo().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().
                getGridSetting().setIsShowSelectButtonColumn(false);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().setVisible(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtBuyYMD().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getDdlShumoku().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtShohinName().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtSeizoJigyosha().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtHanbaiJigyosha().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtBuyAmount().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getRadShinsaMethod().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getBtnClear().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getBtnModifyDetail().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsakekka().setVisible(false);
        div.getPnlKeteiJohoMsg().getCcdMessage().setVisible(false);
    }

    /**
     * 削除モード
     */
    public void set削除モード() {
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtTeikyoYM().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDdlShityoson().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSyomeisyo().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().
                getGridSetting().setIsShowSelectButtonColumn(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().
                getGridSetting().setIsShowDeleteButtonColumn(false);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().
                getGridSetting().setIsShowModifyButtonColumn(false);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().setVisible(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtBuyYMD().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getDdlShumoku().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtShohinName().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtSeizoJigyosha().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtHanbaiJigyosha().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtBuyAmount().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getRadShinsaMethod().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getBtnClear().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getBtnModifyDetail().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseibi().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getDdlShinseisyakubun().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseiriyu().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtJigyosya().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShimei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShimeiKana().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseisyaTel().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseisyaYubin().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getBtnHonninJohoCopy().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getBtnJigyosya().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsakekka().setDisabled(true);
        div.getPnlKeteiJohoMsg().getCcdMessage().setVisible(false);
    }

    /**
     * 参照モード
     */
    public void set参照モード() {
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtTeikyoYM().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDdlShityoson().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSyomeisyo().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getBtnAddDetail().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().
                getGridSetting().setIsShowSelectButtonColumn(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().
                getGridSetting().setIsShowDeleteButtonColumn(false);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().
                getGridSetting().setIsShowModifyButtonColumn(false);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().setVisible(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtBuyYMD().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getDdlShumoku().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtShohinName().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtSeizoJigyosha().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtHanbaiJigyosha().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtBuyAmount().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getRadShinsaMethod().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getBtnClear().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getBtnModifyDetail().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseibi().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtUkechikebi().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtRyosyuYMD().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getDdlShinseisyakubun().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseiriyu().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtJigyosya().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShimei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShimeiKana().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseisyaTel().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseisyaYubin().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getBtnHonninJohoCopy().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getBtnJigyosya().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsakekka().setDisabled(true);
        div.getPnlKeteiJohoMsg().getCcdMessage().setVisible(false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(申請を保存する, false);
    }

    /**
     * 審査モード
     */
    public void set審査モード() {
        div.getPnlButton().getBtnKetteiJoho().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtTeikyoYM().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDdlShityoson().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSyomeisyo().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().
                getGridSetting().setIsShowSelectButtonColumn(false);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().setVisible(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtBuyYMD().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getDdlShumoku().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtShohinName().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtSeizoJigyosha().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtHanbaiJigyosha().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtBuyAmount().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getRadShinsaMethod().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getBtnClear().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getBtnModifyDetail().setDisabled(true);
        div.getPnlKeteiJohoMsg().getCcdMessage().setVisible(false);
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
