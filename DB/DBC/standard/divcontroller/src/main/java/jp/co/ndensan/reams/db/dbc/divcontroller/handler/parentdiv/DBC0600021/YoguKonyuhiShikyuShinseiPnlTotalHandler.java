/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0600021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanFukushiYoguHanbaihi;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei.FukushiYoguKonyuhiShikyuShiseiMeisaiDivEntity;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei.SokanbaraiShiharaiKekkaResult;
import jp.co.ndensan.reams.db.dbc.definition.core.shinsahoho.ShinsaHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shinseisha.ShinseishaKubun;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600021.YoguKonyuhiShikyuShinseiPnlTotalDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600021.dgSeikyuDetail_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0600011.PnlTotalParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0600021.YoguKonyuhiShikyuShinseiPnlTotalParameter;
import jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei.FukushiyoguKonyuhiShikyuGendogaku;
import jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei.FukushiyoguKonyuhiShikyuShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.kijunt.IKoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzWarningMessages;
import jp.co.ndensan.reams.db.dbz.service.core.kijuntsukishichosonjoho.KijuntsukiShichosonjohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 *
 * 画面設計_DBCMN51001_福祉用具購入費支給申請_明細登録
 *
 * @reamsid_L DBC-1020-030 quxiaodong
 */
public class YoguKonyuhiShikyuShinseiPnlTotalHandler {

    private final YoguKonyuhiShikyuShinseiPnlTotalDiv div;
    private static final RString BLANK = new RString("0");
    private static final RString コード種別 = new RString("0006");
    private static final RString NUM1 = new RString("0001");
    private static final RString NUM3 = new RString("0000000000");
    private static final RString NUM01 = new RString("01");
    private static final RString NUMB1 = new RString("1");
    private static final RString NUMB2 = new RString("2");
    private static final RString NUM0000 = new RString("0000");
    private static final Decimal NUM100 = new Decimal(100);
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_5 = 5;
    private static final RString NUM41 = new RString("41");
    private static final RString NUM44 = new RString("44");
    private static final RString 証明書コード1 = new RString("21C1");
    private static final RString 証明書コード2 = new RString("21C2");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 審査 = new RString("審査");
    private static final RString 購入日 = new RString("購入日");
    private static final RString 種目 = new RString("種目");
    private static final RString 商品名 = new RString("商品名");
    private static final RString 製造事業者 = new RString("製造事業者");
    private static final RString 販売事業者 = new RString("販売事業者");
    private static final RString 購入金額 = new RString("購入金額");
    private static final RString 処理モード登録 = new RString("処理モード登録");
    private static final RString 処理モード修正 = new RString("処理モード修正");
    private static final RString 処理モード削除 = new RString("処理モード削除");
    private static final RString 申請を保存する = new RString("btnUpdate");
    private static final RString 種目コード = new RString("種目コード");
    private static final RString 品目コード = new RString("品目コード");
    private static final RString 購入年月日 = new RString("購入年月日");
    private static final RString 領収年月日 = new RString(
            "領収年月日にサービス提供年月より前の日付が設定されています。");

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
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtKyufuritsu().
                    setValue(shokankihon.get保険給付率().value());
        }
        if (shokankihon.get事業者番号() != null) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtJigyoshaNo().
                    setValue(shokankihon.get事業者番号().value());
        }
        if (shokanshinsei != null && shokanshinsei.get証記載保険者番号() != null) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getDdlShityoson().
                    setSelectedKey(shokanshinsei.get証記載保険者番号().value());
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
        builder.append(RString.HALF_SPACE);
        if (略称 != null) {
            builder.append(略称);
        }
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSyomeisyo().setValue(builder.toRString());
    }

    /**
     * 支給申請内容エリア．保険者
     *
     * @param サービス提供年月 FlexibleYearMonth
     * @return dataSourceList
     */
    public List<KeyValueDataSource> get保険者(FlexibleYearMonth サービス提供年月) {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        RString 導入形態 = ShichosonSecurityJoho.getShichosonSecurityJoho(
                GyomuBunrui.介護事務).get導入形態コード().value();
        FlexibleDate 基準年月 = null;
        if (サービス提供年月 != null) {
            基準年月 = new FlexibleDate(サービス提供年月.toString());
        }
        List<IKoseiShichosonMaster> kilist = KijuntsukiShichosonjohoFinder.createInstance().
                getKijuntsukiShichosonjohos(基準年月, 導入形態);
        for (IKoseiShichosonMaster list : kilist) {
            KeyValueDataSource dataSource = new KeyValueDataSource(
                    list.get市町村コード().value(), list.get市町村名称());
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
        KeyValueDataSource dataSourceBlank = new KeyValueDataSource(BLANK, RString.EMPTY);
        dataSourceList.add(dataSourceBlank);
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
        if (row.getTxtShumoku().getValue() != null) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getDdlShumoku().
                    setSelectedKey(row.getTxtShumoku().getValue());
        }
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
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtBuyYMD().setDisabled(flag);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getDdlShumoku().setDisabled(flag);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtShohinName().setDisabled(flag);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtSeizoJigyosha().setDisabled(flag);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtHanbaiJigyosha().setDisabled(flag);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtBuyAmount().setDisabled(flag);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtHinmokuCode().setDisabled(flag);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getRadShinsaMethod().setDisabled(flag);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getBtnClear().setDisabled(flag);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getBtnModifyDetail().setDisabled(flag);
    }

    /**
     * setDgSeikyuDetail
     *
     * @param row dgSeikyuDetail_Row
     * @param 処理モード RString
     */
    public void setDgSeikyuDetail(dgSeikyuDetail_Row row, RString 処理モード) {
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtBuyYMD() != null) {
            row.getTxtBuyYMD().setValue(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getYoguKonyuhiDetailInput().getTxtBuyYMD().getValue());
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getDdlShumoku().getSelectedKey() != null && !div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getYoguKonyuhiDetailInput().getDdlShumoku().getSelectedKey().isEmpty()) {
            row.getTxtShumoku().setValue(
                    div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                    getDdlShumoku().getSelectedKey());
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtShohinName() != null) {
            row.getTxtShohinName().setValue(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getYoguKonyuhiDetailInput().getTxtShohinName().getValue());
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtSeizoJigyosha() != null) {
            row.getFukushiYoguSeizoJigyoshaName().setValue(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getYoguKonyuhiDetailInput().getTxtSeizoJigyosha().getValue());
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtHanbaiJigyosha() != null) {
            row.getFukushiYoguHanbaiJigyoshaName().setValue(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getYoguKonyuhiDetailInput().getTxtHanbaiJigyosha().getValue());
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
        if (処理モード登録.equals(処理モード)) {
            List<dgSeikyuDetail_Row> list = div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getDgSeikyuDetail().getDataSource();
            list.add(row);
        }
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
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getDdlShumoku().setSelectedKey(BLANK);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getRadShinsaMethod().setSelectedKey(NUMB1);
    }

    /**
     * 登録前回支払結果情報
     *
     * @param soshkere SokanbaraiShiharaiKekkaResult
     */
    public void 登録前回支払結果情報(SokanbaraiShiharaiKekkaResult soshkere) {
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtZenkaiHiyogakuGokei().setValue(
                soshkere.get費用額合計());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtZenkaiHokenTaishoHiyogakuGokei().setValue(
                soshkere.get保険対象費用額());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtZenkaiHokenkyufugakuGokei().setValue(
                new Decimal(soshkere.get保険給付額()));
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtZenkaiRiyoshaFutangakuGokei().setValue(
                new Decimal(soshkere.get利用者負担額()));
    }

    /**
     * 登録以外前回支払結果情報
     *
     * @param soshkere1 SokanbaraiShiharaiKekkaResult
     * @param soshkere2 SokanbaraiShiharaiKekkaResult
     */
    public void 登録以外前回支払結果情報(SokanbaraiShiharaiKekkaResult soshkere1,
            SokanbaraiShiharaiKekkaResult soshkere2) {
        if (soshkere1.get費用額合計() != null && soshkere2.get費用額合計() != null) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtZenkaiHiyogakuGokei().setValue(
                    soshkere1.get費用額合計().subtract(soshkere2.get費用額合計()));
        }
        if (soshkere1.get保険対象費用額() != null && soshkere2.get保険対象費用額() != null) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                    getTxtZenkaiHokenTaishoHiyogakuGokei().setValue(
                            soshkere1.get保険対象費用額().subtract(soshkere2.get保険対象費用額()));
        }
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtZenkaiHokenkyufugakuGokei().setValue(
                new Decimal(soshkere1.get保険給付額()).subtract(new Decimal(soshkere2.get保険給付額())));
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtZenkaiRiyoshaFutangakuGokei().setValue(
                new Decimal(soshkere1.get利用者負担額()).subtract(new Decimal(soshkere2.get利用者負担額())));
    }

    /**
     * 今回支払結果情報
     *
     * @param soshkere SokanbaraiShiharaiKekkaResult
     */
    public void 今回支払結果情報(SokanbaraiShiharaiKekkaResult soshkere) {
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtKonkaiHiyogakuGokei().setValue(
                soshkere.get費用額合計());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtKonkaiHokenTaishoHiyogakuGokei().setValue(
                soshkere.get保険対象費用額());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtKonkaiHokenkyufugakuGokei().setValue(
                new Decimal(soshkere.get保険給付額()));
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtKonkaiRiyoshaFutangakuGokei().setValue(
                new Decimal(soshkere.get利用者負担額()));
    }

    /**
     * 今回の支払状況連動。
     */
    public void 今回の支払状況連動() {
        Decimal 保険給付額 = Decimal.ZERO;
        Decimal 購入金額合計 = Decimal.ZERO;
        List<dgSeikyuDetail_Row> rowList = div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getDgSeikyuDetail().getDataSource();
        for (dgSeikyuDetail_Row row : rowList) {
            if (!RowState.Deleted.equals(row.getRowState()) && row.getTxtBuyAmount().getValue() != null) {
                購入金額合計 = 購入金額合計.add(row.getTxtBuyAmount().getValue());
            }
        }
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtKonkaiHiyogakuGokei().setValue(購入金額合計);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtKonkaiHokenTaishoHiyogakuGokei()
                .setValue(購入金額合計);
        Decimal 給付率 = div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtKyufuritsu().getValue().
                divide(NUM100).stripTrailingZeros();
        if (給付率 != null) {
            保険給付額 = 購入金額合計.multiply(給付率);
        }
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtKonkaiHokenkyufugakuGokei()
                .setValue(保険給付額);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtKonkaiRiyoshaFutangakuGokei()
                .setValue(購入金額合計.subtract(保険給付額));
    }

    /**
     * 償還払支給申請情報取得
     *
     * @param shokanshinsei ShokanShinsei
     */
    public void 償還払支給申請情報(ShokanShinsei shokanshinsei) {
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseibi().setValue(
                new RDate(shokanshinsei.get申請年月日().toString()));
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtUkechikebi().setValue(
                new RDate(shokanshinsei.get受付年月日().toString()));
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtRyosyuYMD().setValue(
                new RDate(shokanshinsei.get領収年月日().toString()));
        if (shokanshinsei.get申請者区分() != null && !shokanshinsei.get申請者区分().isEmpty()) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getDdlShinseisyakubun().setSelectedKey(
                    shokanshinsei.get申請者区分());
        }
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseiriyu().setValue(
                shokanshinsei.get申請理由());
        if (shokanshinsei.get申請事業者コード() != null) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtJigyosya().setValue(
                    shokanshinsei.get申請事業者コード().value());
        }
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShimei().setValue(
                shokanshinsei.get申請者氏名());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShimeiKana().setValue(
                shokanshinsei.get申請者氏名カナ());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseisyaTel().setDomain(
                shokanshinsei.get申請者電話番号());
        if (shokanshinsei.get審査結果() != null && !shokanshinsei.get審査結果().isEmpty()) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsakekka().
                    getRadShinsakekka().setSelectedKey(shokanshinsei.get審査結果());
        }
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseisyaYubin().setValue(
                shokanshinsei.get申請者郵便番号());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().
                getTxtShinseisyaJyusyo().setDomain(new AtenaJusho(shokanshinsei.get申請者住所()));
    }

    /**
     * 保存処理
     *
     * @param parameter PnlTotalParameter
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param 状態 RString
     * @param 整理番号 RString
     * @param shokankihon ShokanKihon
     * @param shshResult ShokanShinsei
     * @param shokanShukei ShokanShukei
     * @param shkonlist List<ShokanFukushiYoguHanbaihi> shkonlist
     * @param 償還払支給判定結果 ShokanHanteiKekka
     */
    public void 保存処理(PnlTotalParameter parameter, HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード,
            RString 状態, RString 整理番号, ShokanKihon shokankihon, ShokanShinsei shshResult,
            ShokanShukei shokanShukei, List<ShokanFukushiYoguHanbaihi> shkonlist, ShokanHanteiKekka 償還払支給判定結果) {
        FlexibleYearMonth サービス提供年月;
        RString 様式番号;
        JigyoshaNo 事業者番号;
        RString 明細番号;
        if (!登録.equals(状態)) {
            サービス提供年月 = new FlexibleYearMonth(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getTxtTeikyoYM().getValue().getYearMonth().toString());
            整理番号 = parameter.getSerialNo();
            様式番号 = parameter.getYoshikiNo();
            事業者番号 = parameter.getJigyosyaNo();
            明細番号 = parameter.getMeisaiNo();
        } else {
            RString 証明書コード = RString.EMPTY;
            RString サービス種類 = div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtServiceCode().getValue();
            サービス提供年月 = new FlexibleYearMonth(
                    div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtTeikyoYM().getValue().getYearMonth().toString());
            if (NUM41.equals(サービス種類)) {
                証明書コード = 証明書コード1;
            }
            if (NUM44.equals(サービス種類)) {
                証明書コード = 証明書コード2;
            }
            様式番号 = 証明書コード;
            事業者番号 = new JigyoshaNo(div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtJigyoshaNo().getValue());
            明細番号 = NUM1;
        }
        List<ShokanFukushiYoguHanbaihi> entityList = new ArrayList<>();
        List<dgSeikyuDetail_Row> dgrow = div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getDgSeikyuDetail().getDataSource();
        int max連番 = 0;
        Map<RString, ShokanFukushiYoguHanbaihi> mapList = new HashMap<>();
        if (登録.equals(状態)) {
            for (dgSeikyuDetail_Row row : dgrow) {
                ShokanFukushiYoguHanbaihi entityAdded = new ShokanFukushiYoguHanbaihi(
                        被保険者番号,
                        サービス提供年月,
                        整理番号,
                        事業者番号,
                        様式番号,
                        NUM1,
                        new RString(String.valueOf(row.getId() + NUM_1))).
                        createBuilderForEdit().build();
                entityAdded = buildshokanFukushi(entityAdded, row);
                entityList.add(entityAdded.added());
            }
        } else {
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
                            new RString(String.valueOf(max連番))).createBuilderForEdit().build();
                    entityAdded = buildshokanFukushi(entityAdded, row);
                    entityList.add(entityAdded.added());
                }
            }
        }
        ShokanKihon 償還払請求基本 = get償還払請求基本(shokankihon,
                被保険者番号,
                サービス提供年月,
                整理番号,
                様式番号,
                事業者番号,
                明細番号);
        ShokanShinsei 償還払支給申請 = get償還払支給申請(shshResult,
                被保険者番号,
                サービス提供年月,
                整理番号, 状態);
        ShokanShukei 償還払請求集計 = get償還払請求集計(
                shokanShukei,
                被保険者番号,
                サービス提供年月,
                整理番号,
                様式番号,
                事業者番号,
                明細番号);
        if (削除.equals(状態)) {

            FukushiyoguKonyuhiShikyuShinsei.createInstance().
                    delete(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 識別コード);
        } else if (修正.equals(状態)) {
            FukushiYoguKonyuhiShikyuShiseiMeisaiDivEntity fuentity = 保存Entity(entityList,
                    償還払請求基本,
                    償還払支給申請,
                    償還払請求集計,
                    被保険者番号,
                    サービス提供年月,
                    整理番号,
                    様式番号,
                    事業者番号,
                    明細番号,
                    識別コード,
                    修正,
                    償還払支給判定結果);
            FukushiyoguKonyuhiShikyuShinsei.createInstance().update(fuentity);
        } else if (登録.equals(状態)) {
            FukushiYoguKonyuhiShikyuShiseiMeisaiDivEntity fuentity = FukushiYoguKonyuhiShikyuShiseiMeisaiDivEntity.
                    createEntity(登録, 償還払請求基本, 償還払支給申請, 償還払請求集計);
            fuentity.add福祉用具販売費リスト(登録, entityList);
            FukushiyoguKonyuhiShikyuShinsei.createInstance().insert(fuentity);

        } else if (審査.equals(状態)) {
            FukushiYoguKonyuhiShikyuShiseiMeisaiDivEntity fuentity = 保存Entity(entityList,
                    償還払請求基本,
                    償還払支給申請,
                    償還払請求集計,
                    被保険者番号,
                    サービス提供年月,
                    整理番号,
                    様式番号,
                    事業者番号,
                    明細番号,
                    識別コード,
                    審査,
                    償還払支給判定結果);
            FukushiyoguKonyuhiShikyuShinsei.createInstance().updShinsa(fuentity);
        }
    }

    private FukushiYoguKonyuhiShikyuShiseiMeisaiDivEntity 保存Entity(List<ShokanFukushiYoguHanbaihi> entityList,
            ShokanKihon 償還払請求基本,
            ShokanShinsei 償還払支給申請,
            ShokanShukei 償還払請求集計,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            RString 様式番号,
            JigyoshaNo 事業者番号,
            RString 明細番号,
            ShikibetsuCode 識別コード,
            RString 状態Flag,
            ShokanHanteiKekka 償還払支給判定結果) {

        FukushiYoguKonyuhiShikyuShiseiMeisaiDivEntity fuentity = FukushiYoguKonyuhiShikyuShiseiMeisaiDivEntity.
                createEntity(状態Flag, 償還払請求基本, 償還払支給申請, 償還払請求集計);
        fuentity.set被保険者番号(被保険者番号);
        fuentity.set提供_購入_年月(サービス提供年月);
        fuentity.set整理番号(整理番号);
        fuentity.set事業者番号(事業者番号);
        fuentity.set証明書コード(様式番号);
        fuentity.set明細番号(明細番号);
        fuentity.set識別コード(識別コード);
        List<ShokanFukushiYoguHanbaihi> 修正List = new ArrayList<>();
        List<ShokanFukushiYoguHanbaihi> 登録List = new ArrayList<>();
        List<ShokanFukushiYoguHanbaihi> 削除List = new ArrayList<>();
        if (!entityList.isEmpty()) {
            for (ShokanFukushiYoguHanbaihi entity : entityList) {
                if (EntityDataState.Modified.equals(entity.toEntity().getState())) {
                    修正List.add(entity);
                }
                if (EntityDataState.Added.equals(entity.toEntity().getState())) {
                    登録List.add(entity);
                }
                if (EntityDataState.Deleted.equals(entity.toEntity().getState())) {
                    削除List.add(entity);
                }
            }
        }
        fuentity.add福祉用具販売費リスト(修正, 修正List);
        fuentity.add福祉用具販売費リスト(登録, 登録List);
        fuentity.add福祉用具販売費リスト(削除, 削除List);
        fuentity.set償還払支給判定結果(償還払支給判定結果);
        return fuentity;
    }

    private ShokanKihon get償還払請求基本(ShokanKihon entity,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            RString 様式番号,
            JigyoshaNo 事業者番号,
            RString 明細番号) {
        if (entity == null) {
            entity = new ShokanKihon(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号)
                    .createBuilderForEdit().build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtTeikyoYM() != null) {
            entity = entity.createBuilderForEdit().setサービス提供年月(new FlexibleYearMonth(div.
                    getYoguKonyuhiShikyuShinseiContentsPanel().getTxtTeikyoYM().
                    getValue().getYearMonth().toString())).build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtJigyoshaNo() != null) {
            entity = entity.createBuilderForEdit().set事業者番号(new JigyoshaNo(
                    div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtJigyoshaNo().getValue())).build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtKyufuritsu().getValue() != null) {
            entity = entity.createBuilderForEdit().set保険給付率(new HokenKyufuRitsu(
                    div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtKyufuritsu().getValue())).build();
        }
        if (div.getTpSummary().getTxtKonkaiHiyogakuGokei().getValue() != null) {
            entity = entity.createBuilderForEdit().setサービス単位数(div.getTpSummary().
                    getTxtKonkaiHiyogakuGokei().getValue().intValue()).build();
        }
        if (div.getTpSummary().getTxtKonkaiHokenkyufugakuGokei().getValue() != null) {
            entity = entity.createBuilderForEdit().set保険請求額(div.getTpSummary().
                    getTxtKonkaiHokenkyufugakuGokei().getValue()).build();
        }
        if (div.getTpSummary().getTxtKonkaiRiyoshaFutangakuGokei().getValue() != null) {
            entity = entity.createBuilderForEdit().set利用者負担額(div.getTpSummary().
                    getTxtKonkaiRiyoshaFutangakuGokei().getValue().intValue()).build();
        }
        return entity;
    }

    private ShokanShukei get償還払請求集計(ShokanShukei entity,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            RString 様式番号,
            JigyoshaNo 事業者番号,
            RString 明細番号) {
        List<dgSeikyuDetail_Row> dgrow = div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getDgSeikyuDetail().getDataSource();
        if (entity == null) {
            entity = new ShokanShukei(被保険者番号, サービス提供年月, 整理番号, 事業者番号, 様式番号, 明細番号, NUMB1)
                    .createBuilderForEdit().build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtServiceCode().getValue() != null) {
            entity = entity.createBuilderForEdit().setサービス種類コード(new ServiceShuruiCode(div.
                    getYoguKonyuhiShikyuShinseiContentsPanel().getTxtServiceCode().getValue())).build();
        }
        if (dgrow != null && !dgrow.isEmpty()) {
            entity = entity.createBuilderForEdit().set審査方法区分コード(dgrow.get(0).getTxtShinsa()).build();
        } else {
            entity = entity.createBuilderForEdit().set審査方法区分コード(NUMB2).build();
        }
        if (div.getTpSummary().getTxtKonkaiHokenkyufugakuGokei().getValue() != null) {
            entity = entity.createBuilderForEdit().set請求額(div.getTpSummary().
                    getTxtKonkaiHokenkyufugakuGokei().getValue()).build();
        }
        if (div.getTpSummary().getTxtKonkaiRiyoshaFutangakuGokei().getValue() != null) {
            entity = entity.createBuilderForEdit().set利用者負担額(div.getTpSummary().
                    getTxtKonkaiRiyoshaFutangakuGokei().getValue().intValue()).build();
        }
        if (div.getTpSummary().getTxtKonkaiHokenTaishoHiyogakuGokei().getValue() != null) {
            entity = entity.createBuilderForEdit().set点数_金額(div.getTpSummary().
                    getTxtKonkaiHokenTaishoHiyogakuGokei().getValue().intValue()).build();
        }
        return entity;
    }

    private ShokanShinsei get償還払支給申請(ShokanShinsei entity, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            RString 状態) {
        if (entity == null) {
            entity = new ShokanShinsei(被保険者番号, サービス提供年月, 整理番号).createBuilderForEdit().build();
        }
        entity = clearsShokanShinsei(entity);
        List<dgSeikyuDetail_Row> dgrow = div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getDgSeikyuDetail().getDataSource();
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getChkKokuhorenSend().isAllSelected()) {
            entity = entity.createBuilderForEdit().set国保連再送付フラグ(true).build();
        } else {
            entity = entity.createBuilderForEdit().set国保連再送付フラグ(false).build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getDdlShityoson().getSelectedKey() != null
                && !div.getYoguKonyuhiShikyuShinseiContentsPanel().getDdlShityoson().getSelectedKey().isEmpty()) {
            entity = entity.createBuilderForEdit().set証記載保険者番号(new ShoKisaiHokenshaNo(
                    div.getYoguKonyuhiShikyuShinseiContentsPanel().getDdlShityoson().getSelectedKey())).build();
        }
        if (dgrow != null && !dgrow.isEmpty()) {
            entity = entity.createBuilderForEdit().set審査方法区分(dgrow.get(0).getTxtShinsa()).build();
        } else {
            entity = entity.createBuilderForEdit().set審査方法区分(NUMB2).build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseibi() != null) {
            entity = entity.createBuilderForEdit().set申請年月日(new FlexibleDate(
                    div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().
                    getTxtShinseibi().getValue().toString())).build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtUkechikebi() != null) {
            entity = entity.createBuilderForEdit().set受付年月日(new FlexibleDate(
                    div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getPnlShinsesyaJoho().getTxtUkechikebi().getValue().toString())).build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtRyosyuYMD() != null) {
            entity = entity.createBuilderForEdit().set領収年月日(new FlexibleDate(
                    div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getPnlShinsesyaJoho().getTxtRyosyuYMD().getValue().toString())).build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().
                getDdlShinseisyakubun().getSelectedKey() != null
                && !div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().
                getDdlShinseisyakubun().getSelectedKey().isEmpty()) {
            entity = entity.createBuilderForEdit().set申請者区分(
                    div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().
                    getDdlShinseisyakubun().getSelectedKey()).build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseiriyu() != null) {
            entity = entity.createBuilderForEdit().set申請理由(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getPnlShinsesyaJoho().getTxtShinseiriyu().getValue()).build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtJigyosya().getValue() != null
                && !div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().
                getTxtJigyosya().getValue().isEmpty()) {
            entity = entity.createBuilderForEdit().set申請事業者コード(new JigyoshaNo(
                    div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getPnlShinsesyaJoho().getTxtJigyosya().getValue())).build();
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
        if (審査.equals(状態)) {
            entity = entity.createBuilderForEdit().set支給申請審査区分(NUMB2).build();
        } else {
            entity = entity.createBuilderForEdit().set支給申請審査区分(NUMB1).build();
        }
        entity = get償還払支給申請2(entity);
        return entity;
    }

    private ShokanShinsei get償還払支給申請2(ShokanShinsei entity) {
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseisyaTel() != null) {
            entity = entity.createBuilderForEdit().set申請者電話番号(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getPnlShinsesyaJoho().getTxtShinseisyaTel().getDomain()).build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseisyaYubin() != null) {
            entity = entity.createBuilderForEdit().set申請者郵便番号(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getPnlShinsesyaJoho().getTxtShinseisyaYubin().getValue()).build();
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseisyaJyusyo() != null) {
            entity = entity.createBuilderForEdit().set申請者住所(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getPnlShinsesyaJoho().getTxtShinseisyaJyusyo().getDomain().value()).build();
        }
        if (div.getTpSummary().getTxtKonkaiHiyogakuGokei().getValue() != null) {
            entity = entity.createBuilderForEdit().set支払金額合計(div.getTpSummary().
                    getTxtKonkaiHiyogakuGokei().getValue()).build();
        }
        if (div.getTpSummary().getTxtKonkaiHokenTaishoHiyogakuGokei().getValue() != null) {
            entity = entity.createBuilderForEdit().set保険対象費用額(div.getTpSummary().
                    getTxtKonkaiHokenTaishoHiyogakuGokei().getValue()).build();
        }
        if (div.getTpSummary().getTxtKonkaiHokenkyufugakuGokei().getValue() != null) {
            entity = entity.createBuilderForEdit().set保険給付額(div.getTpSummary().getTxtKonkaiHokenkyufugakuGokei().
                    getValue().intValue()).build();
        }
        if (div.getTpSummary().getTxtKonkaiRiyoshaFutangakuGokei().getValue() != null) {
            entity = entity.createBuilderForEdit().set利用者負担額(div.getTpSummary().
                    getTxtKonkaiRiyoshaFutangakuGokei().getValue().intValue()).build();
        }
        if (div.getCcdShiharaiHohoInfo().getShiharaiHohoRad() != null
                && !div.getCcdShiharaiHohoInfo().getShiharaiHohoRad().isEmpty()) {
            entity = entity.createBuilderForEdit().set支払方法区分コード(
                    div.getCcdShiharaiHohoInfo().getShiharaiHohoRad()).build();
        }
        if (div.getCcdShiharaiHohoInfo().getShiharaiBasho() != null) {
            entity = entity.createBuilderForEdit().set支払場所(
                    div.getCcdShiharaiHohoInfo().getShiharaiBasho()).build();
        }
        if (div.getCcdShiharaiHohoInfo().getStartYMD() != null) {
            entity = entity.createBuilderForEdit().set支払期間開始年月日(
                    new FlexibleDate(div.getCcdShiharaiHohoInfo().getStartYMD().toString())).build();
        }
        if (div.getCcdShiharaiHohoInfo().getEndYMD() != null) {
            entity = entity.createBuilderForEdit().set支払期間終了年月日(
                    new FlexibleDate(div.getCcdShiharaiHohoInfo().getEndYMD().toString())).build();
        }
        if (div.getCcdShiharaiHohoInfo().getStartHHMM() != null) {
            RString 時間 = new RString(div.getCcdShiharaiHohoInfo().getStartHHMM().toString());
            entity = entity.createBuilderForEdit().set支払窓口開始時間(
                    時間.substring(NUM_0, NUM_2).concat(時間.substring(NUM_3, NUM_5))).build();
        }
        if (div.getCcdShiharaiHohoInfo().getEndHHMM() != null) {
            RString 時間 = new RString(div.getCcdShiharaiHohoInfo().getEndHHMM().toString());
            entity = entity.createBuilderForEdit().set支払窓口終了時間(
                    時間.substring(NUM_0, NUM_2).concat(時間.substring(NUM_3, NUM_5))).build();
        }
        if (div.getCcdShiharaiHohoInfo().getKozaNo() != null
                && !div.getCcdShiharaiHohoInfo().getKozaNo().isEmpty()) {
            entity = entity.createBuilderForEdit().set口座ID(
                    Long.parseLong(div.getCcdShiharaiHohoInfo().getKozaNo().toString())).build();
        }
        if (div.getCcdShiharaiHohoInfo().getKeiyakuNo() != null) {
            entity = entity.createBuilderForEdit().set受領委任契約番号(
                    div.getCcdShiharaiHohoInfo().getKeiyakuNo()).build();
        }
        return entity;
    }

    private ShokanShinsei clearsShokanShinsei(ShokanShinsei entity) {
        entity = entity.createBuilderForEdit()
                .set国保連再送付フラグ(false)
                .set申請年月日(null)
                .set申請理由(null)
                .set申請事業者コード(null)
                .set申請者氏名(null)
                .set申請者氏名カナ(null)
                .set申請者住所(null)
                .set申請者郵便番号(null)
                .set支払期間開始年月日(null)
                .set支払期間終了年月日(null)
                .set支払窓口開始時間(null)
                .set支払窓口終了時間(null)
                .set受領委任契約番号(null)
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
            entity = entity.createBuilderForEdit().set福祉用具製造事業者名(row.
                    getFukushiYoguSeizoJigyoshaName().getValue()).build();
        }
        if (row.getFukushiYoguHanbaiJigyoshaName().getValue() != null) {
            entity = entity.createBuilderForEdit().set福祉用具販売事業者名(row.
                    getFukushiYoguHanbaiJigyoshaName().getValue()).build();
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
        entity = entity.createBuilderForEdit().setサービスコード(new ServiceCode(
                div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getTxtServiceCode().getValue().concat(NUM0000))).build();
        entity = entity.createBuilderForEdit().set差額金額(0).build();
        return entity;

    }

    private ShokanFukushiYoguHanbaihi clearshokanShukei(ShokanFukushiYoguHanbaihi entity) {
        entity = entity.createBuilderForEdit()
                .set福祉用具販売年月日(null)
                .set福祉用具種目コード(NUM01)
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
     * @param モード RString
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 確定チェック(RString モード) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        List<dgSeikyuDetail_Row> rowData = div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getDgSeikyuDetail().getDataSource();
        List<dgSeikyuDetail_Row> rowList = new ArrayList<>();
        rowList.addAll(rowData);
        rowList.remove(div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().getClickedItem());
        RString ddlShumoku = div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getYoguKonyuhiDetailInput().getDdlShumoku().getSelectedKey();
        RString hinmokuCode = div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getYoguKonyuhiDetailInput().getTxtHinmokuCode().getValue();
        入力チェック(validPairs);
        if (!処理モード登録.equals(モード) && RowState.Deleted.equals(selectRow().getRowState())) {
            return validPairs;
        }
        for (dgSeikyuDetail_Row row : rowList) {
            if (ddlShumoku.equals(row.getTxtShumoku().getValue()) && !RowState.Deleted.equals(row.getRowState())) {
                validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                        UrErrorMessages.既に登録済, 種目コード.toString())));
            }
            if (hinmokuCode != null && hinmokuCode.equals(row.getHinmokuCode().getValue())
                    && !RowState.Deleted.equals(row.getRowState())) {
                validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                        UrErrorMessages.既に登録済, 品目コード.toString())));
            }
        }
        if (null != div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getTxtTeikyoYM().getValue() && div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getYoguKonyuhiDetailInput().getTxtBuyYMD().getValue() != null && !div.
                getYoguKonyuhiShikyuShinseiContentsPanel()
                .getTxtTeikyoYM().getValue().getYearMonth().equals(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                        getYoguKonyuhiDetailInput().getTxtBuyYMD().getValue().getYearMonth())) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.入力値が不正_追加メッセージあり, 購入年月日.toString())));
        }
        return validPairs;
    }

    private ValidationMessageControlPairs 入力チェック(ValidationMessageControlPairs validPairs) {
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtBuyYMD().
                getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 購入日.toString())));
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getDdlShumoku().getSelectedKey() == null || div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getYoguKonyuhiDetailInput().getDdlShumoku().getSelectedKey().equals(BLANK)) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 種目.toString())));
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtShohinName().
                getValue() == null || div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getYoguKonyuhiDetailInput().getTxtShohinName().getValue().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 商品名.toString())));
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtSeizoJigyosha().
                getValue() == null || div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getYoguKonyuhiDetailInput().getTxtSeizoJigyosha().getValue().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 製造事業者.toString())));
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtHanbaiJigyosha().
                getValue() == null || div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getYoguKonyuhiDetailInput().getTxtHanbaiJigyosha().getValue().isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 販売事業者.toString())));
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().getTxtBuyAmount().
                getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 購入金額.toString())));
        }
        return validPairs;
    }

    /**
     * 保存チェック
     *
     * @param skipFlg boolean
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 サービス提供年月
     * @param 様式番号 RString
     * @param 整理番号 RString
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 保存チェック(boolean skipFlg, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 様式番号, RString 整理番号) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (skipFlg) {
            if (!check領収年月日()) {
                validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                        DbzWarningMessages.確認, 領収年月日.toString())));
            }
            if (!check品目コード()) {
                validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                        UrWarningMessages.重複, 品目コード.toString())));
            }
            if (!check限度額(被保険者番号, サービス提供年月, 様式番号, 整理番号)) {
                validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                        DbcWarningMessages.福祉用具限度額確認)));
            }
        }
        if (null != div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getTxtTeikyoYM().getValue() && div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getYoguKonyuhiDetailInput().getTxtBuyYMD().getValue() != null && !div.
                getYoguKonyuhiShikyuShinseiContentsPanel()
                .getTxtTeikyoYM().getValue().getYearMonth().equals(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                        getYoguKonyuhiDetailInput().getTxtBuyYMD().getValue().getYearMonth())) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.入力値が不正_追加メッセージあり, 購入年月日.toString())));
            return validPairs;
        }
        return validPairs;
    }

    /**
     * 限度額チェック
     *
     * @return validPairs
     */
    public ValidationMessageControlPairs 限度額チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                DbcWarningMessages.福祉用具限度額確認)));
        return validPairs;
    }

    private boolean check領収年月日() {
        boolean flag = true;
        List<dgSeikyuDetail_Row> dgrow = div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().getDataSource();
        RDate ryosyuYMD = div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().
                getTxtRyosyuYMD().getValue();
        for (dgSeikyuDetail_Row row : dgrow) {
            if (RowState.Deleted.equals(row.getRowState())) {
                continue;
            }
            if (row.getTxtBuyYMD().getValue() != null && ryosyuYMD != null && (ryosyuYMD.getYearMonth().compareTo(
                    row.getTxtBuyYMD().getValue().getYearMonth()) < 0)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private boolean check限度額(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 様式番号, RString 整理番号) {
        JigyoshaNo 事業者番号 = null;
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtJigyoshaNo().getValue() != null) {
            事業者番号 = new JigyoshaNo(div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtJigyoshaNo().getValue());
        }
        RString 明細番号 = null;
        boolean flag = FukushiyoguKonyuhiShikyuGendogaku.createInstance().chkKonyuhiShikyuGendogaku(被保険者番号,
                サービス提供年月,
                整理番号,
                事業者番号,
                様式番号,
                明細番号,
                div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtKonkaiHokenTaishoHiyogakuGokei()
                .getValue());
        return flag;
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
     * @param 処理モード RString
     */
    public void modifyRow(dgSeikyuDetail_Row row, RString 処理モード) {
        if (処理モード修正.equals(処理モード)) {
            boolean flag = checkState(row);
            if (flag) {
                row.setRowState(RowState.Modified);
                setDgSeikyuDetail(row, 処理モード);
            }
        } else if (処理モード削除.equals(処理モード)) {
            if (RowState.Added.equals(row.getRowState())) {
                div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().getDataSource().remove(
                        div.getYoguKonyuhiShikyuShinseiContentsPanel().getRowId().getValue().intValue());
            } else {
                row.setRowState(RowState.Deleted);
            }
        } else if (処理モード登録.equals(処理モード)) {
            row.setRowState(RowState.Added);
            setDgSeikyuDetail(row, 処理モード);
        }
        readOnly福祉用具購入費明細(true);
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
        if (hokenKyufuritsu != null) {
            div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtKyufuritsu().setValue(hokenKyufuritsu.value());
        }
    }

    /**
     * is内容変更状態
     *
     * @param parameter YoguKonyuhiShikyuShinseiPnlTotalParameter
     * @return is内容変更状態
     */
    public boolean is内容変更状態(YoguKonyuhiShikyuShinseiPnlTotalParameter parameter) {
        for (dgSeikyuDetail_Row ddgList : div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getDgSeikyuDetail().getDataSource()) {
            if (RowState.Modified.equals(ddgList.getRowState())
                    || RowState.Added.equals(ddgList.getRowState())
                    || RowState.Deleted.equals(ddgList.getRowState())) {
                return true;
            }
        }
        if (is比較変更年月日(parameter.getサービス提供年月(),
                div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtTeikyoYM().getValue())
                || is比較変更(parameter.get事業者(), div.getYoguKonyuhiShikyuShinseiContentsPanel().
                        getTxtJigyoshaNo().getValue())
                || is比較変更(parameter.get証明書(), div.getYoguKonyuhiShikyuShinseiContentsPanel().
                        getTxtSyomeisyo().getValue())) {
            return true;
        }
        if (is内容変更_申請者情報(parameter)) {
            return true;
        } else {
            return is支払方法情報(parameter);
        }
    }

    private boolean is内容変更_申請者情報(YoguKonyuhiShikyuShinseiPnlTotalParameter parameter) {
        return is比較変更年月日(parameter.get申請日(), div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getTxtShinseibi().getValue())
                || is比較変更年月日(parameter.get受付年月日(), div.getYoguKonyuhiShikyuShinseiContentsPanel().
                        getTxtUkechikebi().getValue())
                || is比較変更年月日(parameter.get領収年月日(), div.getYoguKonyuhiShikyuShinseiContentsPanel().
                        getTxtRyosyuYMD().getValue())
                || is比較変更(parameter.get申請者区分(), div.getYoguKonyuhiShikyuShinseiContentsPanel().
                        getDdlShinseisyakubun().getSelectedKey())
                || is比較変更(parameter.get申請理由(), div.getYoguKonyuhiShikyuShinseiContentsPanel().
                        getTxtShinseiriyu().getValue())
                || is比較変更(parameter.get事業者コード(), div.getYoguKonyuhiShikyuShinseiContentsPanel().
                        getTxtJigyosya().getValue())
                || is比較変更(parameter.get氏名１(), div.getYoguKonyuhiShikyuShinseiContentsPanel().
                        getTxtShimei().getValue())
                || is比較変更(parameter.get氏名２(), div.getYoguKonyuhiShikyuShinseiContentsPanel().
                        getTxtShimeiKana().getValue())
                || is比較変更(parameter.get電話番号(), div.getYoguKonyuhiShikyuShinseiContentsPanel().
                        getTxtShinseisyaTel().getDomain().value())
                || is比較変更(parameter.get郵便番号(), div.getYoguKonyuhiShikyuShinseiContentsPanel().
                        getTxtShinseisyaYubin().getValue().value())
                || is比較変更(parameter.get住所(), div.getYoguKonyuhiShikyuShinseiContentsPanel().
                        getTxtShinseisyaJyusyo().getDomain().value());
    }

    private boolean is支払方法情報(YoguKonyuhiShikyuShinseiPnlTotalParameter parameter) {

        return is比較変更(parameter.get窓口払い_支払場所(), div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getCcdShiharaiHohoInfo().getShiharaiBasho())
                || is比較変更日(parameter.get窓口払い_開始日(), div.getYoguKonyuhiShikyuShinseiContentsPanel().
                        getCcdShiharaiHohoInfo().getStartYMD())
                || is比較変更日(parameter.get窓口払い_終了日(), div.getYoguKonyuhiShikyuShinseiContentsPanel().
                        getCcdShiharaiHohoInfo().getEndYMD())
                || is比較変更時間(parameter.get窓口払い_開始時間(), div.getYoguKonyuhiShikyuShinseiContentsPanel().
                        getCcdShiharaiHohoInfo().getStartHHMM())
                || is比較変更時間(parameter.get窓口払い_終了時間(), div.getYoguKonyuhiShikyuShinseiContentsPanel().
                        getCcdShiharaiHohoInfo().getEndHHMM())
                || is比較変更(parameter.get口座払い_口座ＩＤ(), div.getYoguKonyuhiShikyuShinseiContentsPanel().
                        getCcdShiharaiHohoInfo().getKozaNo())
                || is比較変更(parameter.get受領委任払い_契約番号(), div.getYoguKonyuhiShikyuShinseiContentsPanel().
                        getCcdShiharaiHohoInfo().getKeiyakuNo());
    }

    private boolean is比較変更(RString s1, RString s2) {
        if (s1 == null && s2 == null) {
            return false;
        } else if (s1 == null || s2 == null) {
            return true;
        } else {
            return !s1.equals(s2);
        }
    }

    private boolean is比較変更日(RString s1, RDate s2) {
        if (s1 == null && s2 == null) {
            return false;
        } else if (s1 == null || s2 == null) {
            return true;
        } else {
            return !s1.equals(new RString(s2.toString()));
        }
    }

    private boolean is比較変更年月日(RDate s1, RDate s2) {
        if (s1 == null && s2 == null) {
            return false;
        } else if (s1 == null || s2 == null) {
            return true;
        } else {
            return !s1.equals(s2);
        }
    }

    private boolean is比較変更時間(RString s1, RTime s2) {
        if (s1 == null && s2 == null) {
            return false;
        } else if (s1 == null || s2 == null) {
            return true;
        } else {
            return !s1.equals(new RString(s2.toString()));
        }
    }

    /**
     * 保存画面データ
     *
     * @return 画面データ
     */
    public YoguKonyuhiShikyuShinseiPnlTotalParameter set画面データ() {
        YoguKonyuhiShikyuShinseiPnlTotalParameter parameter = new YoguKonyuhiShikyuShinseiPnlTotalParameter();
        parameter.setサービス提供年月(div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtTeikyoYM().getValue());
        parameter.set保険者(div.getYoguKonyuhiShikyuShinseiContentsPanel().getDdlShityoson().getSelectedKey());
        parameter.set国保連再送付(div.getYoguKonyuhiShikyuShinseiContentsPanel().getChkKokuhorenSend().isAllSelected());
        parameter.set事業者(div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtJigyoshaNo().getValue());
        parameter.set証明書(div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSyomeisyo().getValue());
        parameter.set申請日(div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtShinseibi().getValue());
        parameter.set受付年月日(div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtUkechikebi().getValue());
        parameter.set領収年月日(div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtRyosyuYMD().getValue());
        parameter.set申請者区分(div.getYoguKonyuhiShikyuShinseiContentsPanel().getDdlShinseisyakubun().getSelectedKey());
        parameter.set申請理由(div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtShinseiriyu().getValue());
        parameter.set事業者コード(div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtJigyosya().getValue());
        parameter.set氏名１(div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtShimei().getValue());
        parameter.set氏名２(div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtShimeiKana().getValue());
        parameter.set電話番号(div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtShinseisyaTel().getDomain().value());
        parameter.set郵便番号(div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtShinseisyaYubin().getValue().value());
        parameter.set住所(div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtShinseisyaJyusyo().getDomain().value());
        parameter.set窓口払い_支払場所(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getCcdShiharaiHohoInfo().getShiharaiBasho());
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getCcdShiharaiHohoInfo().getStartYMD() != null) {
            parameter.set窓口払い_開始日(new RString(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getCcdShiharaiHohoInfo().getStartYMD().toString()));
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getCcdShiharaiHohoInfo().getEndYMD() != null) {
            parameter.set窓口払い_終了日(new RString(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getCcdShiharaiHohoInfo().getEndYMD().toString()));
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getCcdShiharaiHohoInfo().getStartHHMM() != null) {
            parameter.set窓口払い_開始時間(new RString(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getCcdShiharaiHohoInfo().getStartHHMM().toString()));
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getCcdShiharaiHohoInfo().getEndHHMM() != null) {
            parameter.set窓口払い_終了時間(new RString(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getCcdShiharaiHohoInfo().getEndHHMM().toString()));
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getCcdShiharaiHohoInfo().getKozaNo() != null) {
            parameter.set口座払い_口座ＩＤ(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getCcdShiharaiHohoInfo().getKozaNo());
        }
        if (div.getYoguKonyuhiShikyuShinseiContentsPanel().
                getCcdShiharaiHohoInfo().getKeiyakuNo() != null) {
            parameter.set受領委任払い_契約番号(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                    getCcdShiharaiHohoInfo().getKeiyakuNo());
        }
        return parameter;
    }

    /**
     * get申請者区分リスト
     */
    public void get申請者区分リスト() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        KeyValueDataSource dataSourceBlank = new KeyValueDataSource(BLANK, RString.EMPTY);
        dataSourceList.add(dataSourceBlank);
        for (ShinseishaKubun 申請者区分 : ShinseishaKubun.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(申請者区分.getコード(), 申請者区分.get名称());
            dataSourceList.add(dataSource);
        }
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getDdlShinseisyakubun().
                setDataSource(dataSourceList);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getDdlShinseisyakubun().setSelectedKey(
                BLANK);
    }

    /**
     * 登録モード
     */
    public void set登録モード() {
        int 設定値 = 0;
        RString 設定値の年月 = DbBusinessConfig.get(ConfigNameDBC.初期表示_償還支給申請登録初期,
                RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (設定値の年月 != null && !設定値の年月.isEmpty()) {
            設定値 = Integer.valueOf(設定値の年月.toString());
        }
        div.getPnlButton().getBtnKetteiJoho().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getChkKokuhorenSend().setVisible(false);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSyomeisyo().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().
                getGridSetting().setIsShowSelectButtonColumn(false);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtTeikyoYM().setValue(
                new RDate(RDate.getNowDate().getYearMonth().minusMonth(設定値).toString()));
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDdlShityoson().setDataSource(
                get保険者(new FlexibleYearMonth(div.getYoguKonyuhiShikyuShinseiContentsPanel().
                                getTxtTeikyoYM().getValue().getYearMonth().toString())));
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSeiriNo().clearValue();
        RString 給付率 = DbBusinessConfig.get(ConfigNameDBU.介護保険法情報_保険給付率_標準給付率, RDate.getNowDate(),
                SubGyomuCode.DBU介護統計報告);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtKyufuritsu().setValue(new Decimal(給付率.toString()));
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtJigyoshaNo().setValue(NUM3);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtJigyoshaNo().setDisabled(false);
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
                getBtnModifyDetail().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getBtnClear().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsakekka().setVisible(false);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtUkechikebi().clearValue();
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtRyosyuYMD().clearValue();
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtZenkaiHiyogakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtZenkaiHokenTaishoHiyogakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtZenkaiHokenkyufugakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtZenkaiRiyoshaFutangakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtKonkaiHiyogakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtKonkaiHokenTaishoHiyogakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtKonkaiHokenkyufugakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtKonkaiRiyoshaFutangakuGokei().setDisabled(true);
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
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtZenkaiHiyogakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtZenkaiHokenTaishoHiyogakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtZenkaiHokenkyufugakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtZenkaiRiyoshaFutangakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtKonkaiHiyogakuGokei().setDisabled(true);
    }

    /**
     * 削除モード
     */
    public void set削除モード() {
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtTeikyoYM().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDdlShityoson().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSyomeisyo().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtJigyoshaNo().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getBtnAddDetail().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().
                getGridSetting().setIsShowSelectButtonColumn(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().
                getGridSetting().setIsShowDeleteButtonColumn(false);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().
                getGridSetting().setIsShowModifyButtonColumn(false);
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
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getYoguKonyuhiDetailInput().
                getTxtHinmokuCode().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseisyaJyusyo().setDisabled(true);
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
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsakekka().getRadShinsakekka().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtZenkaiHiyogakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getBtnGendogakuCheck().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getBtnKakoFukushiyogukonyuhiKakutei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtZenkaiHokenTaishoHiyogakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtZenkaiHokenkyufugakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtZenkaiRiyoshaFutangakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtKonkaiHiyogakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtKonkaiHokenTaishoHiyogakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtKonkaiHokenkyufugakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtKonkaiRiyoshaFutangakuGokei().setDisabled(true);
    }

    /**
     * 参照モード
     */
    public void set参照モード() {
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtTeikyoYM().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDdlShityoson().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtSyomeisyo().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getBtnAddDetail().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShiharaiHoho().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().
                getGridSetting().setIsShowSelectButtonColumn(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().
                getGridSetting().setIsShowDeleteButtonColumn(false);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().
                getGridSetting().setIsShowModifyButtonColumn(false);
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
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseisyaJyusyo().setDisabled(true);
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
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsakekka().getRadShinsakekka().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getBtnGendogakuCheck().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getBtnKakoFukushiyogukonyuhiKakutei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtZenkaiHiyogakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtZenkaiHokenTaishoHiyogakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtZenkaiHokenkyufugakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtZenkaiRiyoshaFutangakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtKonkaiHiyogakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtKonkaiHokenTaishoHiyogakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtKonkaiHokenkyufugakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtKonkaiRiyoshaFutangakuGokei().setDisabled(true);
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
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtZenkaiHiyogakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtZenkaiHokenTaishoHiyogakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtZenkaiHokenkyufugakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtZenkaiRiyoshaFutangakuGokei().setDisabled(true);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().
                getTxtKonkaiHiyogakuGokei().setDisabled(true);
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

    /**
     * 本人情報をコピーする
     */
    public void set申請者情報() {
        div.getKaigoCommonPanel().getCcdShikakuKihon().get被保険者番号();
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtJigyosya().setValue(
                div.getYoguKonyuhiShikyuShinseiContentsPanel().getTxtJigyoshaNo().getValue());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShimei().setValue(
                div.getKaigoCommonPanel().getCcdAtenaInfo().get氏名漢字());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShimeiKana().setValue(
                div.getKaigoCommonPanel().getCcdAtenaInfo().get氏名カナ());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseisyaTel().setDomain(
                div.getKaigoCommonPanel().getCcdAtenaInfo().getAtenaInfoDiv().
                getAtenaShokaiSimpleData().getShikibetsuTaishoHisory().get直近().get連絡先１());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseisyaYubin().setValue(
                div.getKaigoCommonPanel().getCcdAtenaInfo().get郵便番号());
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlShinsesyaJoho().getTxtShinseisyaJyusyo().setDomain(
                div.getKaigoCommonPanel().getCcdAtenaInfo().get住所());
    }

    /**
     * getGridData
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @return 償還払請求福祉用具販売費List
     */
    public List<ShokanFukushiYoguHanbaihi> getGridData(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号) {
        List<dgSeikyuDetail_Row> dgrow = div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().getDataSource();
        List<ShokanFukushiYoguHanbaihi> list = new ArrayList<>();
        for (dgSeikyuDetail_Row row : dgrow) {
            ShokanFukushiYoguHanbaihi entityAdded = new ShokanFukushiYoguHanbaihi(
                    被保険者番号,
                    サービス提供年月,
                    整理番号,
                    事業者番号,
                    様式番号,
                    NUM1,
                    new RString(String.format("%02d", 1))).createBuilderForEdit().build();
            entityAdded = buildshokanFukushi(entityAdded, row);
            list.add(entityAdded);
        }
        return list;
    }

    /**
     * set前回までの支払結果
     *
     * @param 費用額合計 Decimal
     * @param 保険対象費用額 Decimal
     * @param 保険給付額 Decimal
     * @param 利用者負担額 Decimal
     */
    public void set前回までの支払結果(Decimal 費用額合計, Decimal 保険対象費用額, Decimal 保険給付額, Decimal 利用者負担額) {
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtZenkaiHiyogakuGokei().setValue(
                費用額合計);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtZenkaiHokenTaishoHiyogakuGokei().setValue(
                保険対象費用額);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtZenkaiHokenkyufugakuGokei().setValue(
                保険給付額);
        div.getYoguKonyuhiShikyuShinseiContentsPanel().getPnlSummary().getTxtZenkaiRiyoshaFutangakuGokei().setValue(
                利用者負担額);
    }

    /**
     * 品目コード重複チェック（年度単位）
     *
     * @return flag
     */
    public boolean check品目コード() {
        Set<RString> sets = new HashSet<>();
        boolean flag = true;
        List<dgSeikyuDetail_Row> dgrow = div.getYoguKonyuhiShikyuShinseiContentsPanel().getDgSeikyuDetail().getDataSource();
        for (dgSeikyuDetail_Row row : dgrow) {
            if (RowState.Deleted.equals(row.getRowState())) {
                continue;
            }
            if (sets.contains(row.getHinmokuCode().getValue())) {
                flag = false;
                break;
            } else {
                sets.add(row.getHinmokuCode().getValue());
            }
        }
        return flag;
    }
}
