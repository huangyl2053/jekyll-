/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.NinteiShinseiRenrakusakiJoho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBZCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.RenrakusakiJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.RensakusakiTsuzukigara;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiJoho.NinteiShinseiRenrakusakiJoho.NinteiShinseiRenrakusakiJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiJoho.NinteiShinseiRenrakusakiJoho.dgRenrakusakiIchiran_Row;
import jp.co.ndensan.reams.db.dbz.service.core.shishosecurityjoho.ShishoSecurityJoho;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定申請連絡先情報のHandlerクラスです。
 *
 * @reamsid_L DBZ-1300-100 dongyabin
 */
public class NinteiShinseiRenrakusakiJohoHandler {

    private final NinteiShinseiRenrakusakiJohoDiv div;
    private final int INT_0 = 0;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public NinteiShinseiRenrakusakiJohoHandler(NinteiShinseiRenrakusakiJohoDiv div) {
        this.div = div;
    }

    /**
     * 画面項目をクリアします。
     */
    public void setClear() {
        div.getRenrakusakiNyuryoku().getTxtRenban().clearValue();
        div.getDdlRenrakusakiKubun().setSelectedIndex(0);
        div.getDdlShisho().setSelectedIndex(0);
        div.getDdlTsuzukigara().setSelectedIndex(0);
        div.getTxtShimei().clearValue();
        div.getTxtKanaShimei().clearValue();
        div.getTxtYubinNo().clearValue();
        div.getTxtJusho().clearValue();
        div.getTxtTelNo().clearDomain();
        div.getTxtMobileNo().clearDomain();
        div.getTxtYusenJuni().clearValue();
    }

    /**
     * 画面初期化を設定します。
     */
    public void onLoad() {
        set支所ドロップダウンリスト();
        set連絡先区分DDL();
        set本人との関係DDL();
        set画面ReadOnly();
    }

    private void set支所ドロップダウンリスト() {
        List<KeyValueDataSource> dataSrouceList = new ArrayList<>();
        if (ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護認定).get支所管理有無フラグ()) {
            div.getDdlShisho().setDisplayNone(false);
            KeyValueDataSource dataSource = new KeyValueDataSource(new RString("key0"),
                    ShishoSecurityJoho.createInstance().getShishoCode(UrControlDataFactory.
                            createInstance().getLoginInfo().getUserId()));
            dataSrouceList.add(dataSource);
        }
        div.getDdlShisho().setDataSource(dataSrouceList);
        div.getDdlShisho().setSelectedIndex(0);
    }

    private void set連絡先区分DDL() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        List<UzT0007CodeEntity> codeList = CodeMaster.getCode(SubGyomuCode.DBZ介護共通, DBZCodeShubetsu.介護連絡先区分.getコード(), FlexibleDate.getNowDate());
        for (UzT0007CodeEntity code : codeList) {
            KeyValueDataSource dataSoruce = new KeyValueDataSource(code.getコード().getColumnValue(), code.getコード名称());
            dataSourceList.add(dataSoruce);
        }
        div.getDdlRenrakusakiKubun().setDataSource(dataSourceList);
        div.getDdlRenrakusakiKubun().setSelectedIndex(0);
    }

    private void set本人との関係DDL() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (RensakusakiTsuzukigara data : RensakusakiTsuzukigara.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(data.getコード(), data.get名称());
            dataSourceList.add(dataSource);
        }
        div.getDdlTsuzukigara().setDataSource(dataSourceList);
        div.getDdlTsuzukigara().setSelectedIndex(0);
    }

    /**
     * hdnReadOnlyでShoriTypeモード判定します。
     */
    public void set画面ReadOnly() {
        if (new RString("1").equals(div.getHdnReadOnly())) {
            div.getRenrakusakiIchiran().setReadOnly(true);
            div.getRenrakusakiNyuryoku().setReadOnly(true);
            div.getBtnKakutei().setDisabled(true);
            div.getBtnModoru().setDisabled(false);
            div.getBtnKakutei().setVisible(false);
            div.getBtnToroku().setVisible(false);
            div.getBtnShinkiTsuika().setDisplayNone(true);
            div.getBtnFukushaTsuika().setDisplayNone(true);
            div.getBtnZenkaiFukusha().setDisplayNone(true);
        } else {
            div.setMode_ShoriType(NinteiShinseiRenrakusakiJohoDiv.ShoriType.ShokaiMode);
        }
    }

    /**
     * 介護連絡先情報を設定します。
     *
     * @param renrakusakiJohoList 介護連絡先情報（受給）
     */
    public void setRenrakusaki(List<RenrakusakiJoho> renrakusakiJohoList) {
        List<dgRenrakusakiIchiran_Row> dateSource = new ArrayList<>();
           for (RenrakusakiJoho renrakusakiJoho : renrakusakiJohoList) {
            TextBoxNum remban = new TextBoxNum();
            TextBoxNum yusen = new TextBoxNum();
            remban.setValue(Decimal.valueOf(renrakusakiJoho.get連番()));
            yusen.setValue(Decimal.valueOf(renrakusakiJoho.get優先順位()));
            dgRenrakusakiIchiran_Row row = new dgRenrakusakiIchiran_Row(remban,
                    renrakusakiJoho.get連絡先氏名() == null ? RString.EMPTY : renrakusakiJoho.
                    get連絡先氏名().getColumnValue(),
                    renrakusakiJoho.get連絡先続柄(),
                    renrakusakiJoho.get連絡先住所() == null ? RString.EMPTY : renrakusakiJoho
                    .get連絡先住所().getColumnValue(),
                    renrakusakiJoho.get連絡先電話番号() == null ? RString.EMPTY : renrakusakiJoho.
                    get連絡先電話番号().getColumnValue(),
                    renrakusakiJoho.get連絡先携帯番号() == null ? RString.EMPTY : renrakusakiJoho.
                    get連絡先携帯番号().getColumnValue(),
                    yusen,
                    renrakusakiJoho.get連絡先区分番号(),
                    renrakusakiJoho.get支所コード() == null ? RString.EMPTY : renrakusakiJoho.get支所コード().getColumnValue(),
                    renrakusakiJoho.get連絡先氏名カナ() == null ? RString.EMPTY : renrakusakiJoho.get連絡先氏名カナ().getColumnValue(),
                    renrakusakiJoho.get連絡先携帯番号() == null ? RString.EMPTY : renrakusakiJoho.get連絡先郵便番号().getColumnValue(),
                    renrakusakiJoho.get申請書管理番号().value());
            if (!EntityDataState.Deleted.equals(renrakusakiJoho.toEntity().getState())) {
                dateSource.add(row);
            }
        }
        div.getDgRenrakusakiIchiran().setDataSource(dateSource);
    }

    /**
     * 報を連絡先入力Divに反映します。
     */
    public void set連絡先入力情報() {
        dgRenrakusakiIchiran_Row row = div.getDgRenrakusakiIchiran().getActiveRow();
        div.getTxtRenban().setValue(row.getRenban().getValue());
        div.getTxtShimei().setValue(row.getShimei());
    }

    /**
     * 連絡先入力の各項目をクリアします。
     */
    public void set連絡先入力の各項目をクリア() {
        div.getTxtRenban().clearValue();
        div.getTxtShimei().clearValue();
        div.getTxtKanaShimei().clearValue();
        div.getTxtYubinNo().clearValue();
        div.getTxtJusho().clearValue();
        div.getTxtTelNo().clearDomain();
        div.getTxtMobileNo().clearDomain();
        div.getTxtYusenJuni().clearValue();
        div.getDdlRenrakusakiKubun().setSelectedIndex(0);
        div.getDdlShisho().setSelectedIndex(0);
        div.getDdlTsuzukigara().setSelectedIndex(0);

    }

    /**
     * 連絡先一覧の選択行の情報を連絡先入力Divに反映します。
     */
    public void set連絡先入力() {
        dgRenrakusakiIchiran_Row row = div.getDgRenrakusakiIchiran().getActiveRow();
        div.getTxtRenban().setValue(row.getRenban().getValue());
        div.getTxtShimei().setValue(row.getShimei());
        div.getTxtKanaShimei().setValue(row.getKanaShimei());
        div.getTxtYubinNo().setValue(RString.isNullOrEmpty(row.getYuubinBango()) ? YubinNo.EMPTY : new YubinNo(row.getYuubinBango()));
        div.getTxtJusho().setValue(row.getJusho());
        div.getTxtTelNo().setDomain(RString.isNullOrEmpty(row.getTelNo()) ? TelNo.EMPTY : new TelNo(row.getTelNo()));
        div.getTxtMobileNo().setDomain(RString.isNullOrEmpty(row.getMobileNo()) ? TelNo.EMPTY : new TelNo(row.getMobileNo()));
        div.getTxtYusenJuni().setValue(row.getYusenJuni().getValue());
        div.getDdlRenrakusakiKubun().setSelectedKey(row.getRenrakusakiKuBun());
        div.getDdlShisho().setSelectedValue(row.getSisyo());
        div.getDdlTsuzukigara().setSelectedValue(row.getTsuzukigara());
    }

    /**
     * 画面項目の使用可を設定します。
     */
    public void set画面項目の使用可() {
        div.getBtnFukushaTsuika().setDisabled(true);
    }

    /**
     * DataSourceを一覧へセットします。
     */
    public void setDataSourceを一覧() {
        if (NinteiShinseiRenrakusakiJohoDiv.ShoriType.InputMode.equals(div.getMode_ShoriType())) {
            set追加の一覧();
        } else if (NinteiShinseiRenrakusakiJohoDiv.ShoriType.KoshinMode.equals(div.getMode_ShoriType())) {
            set修正の一覧();
        }
    }

    private void set追加の一覧() {
        List<dgRenrakusakiIchiran_Row> dateSoruce = div.getDgRenrakusakiIchiran().getDataSource();
        TextBoxNum num = setRenban(dateSoruce); 
        TextBoxNum yusen = new TextBoxNum(); 
        yusen.setValue(div.getTxtYusenJuni().getValue());
        dgRenrakusakiIchiran_Row row = new dgRenrakusakiIchiran_Row(num,
                nullTOEmpty(div.getTxtShimei().getValue()),
                nullTOEmpty(div.getDdlTsuzukigara().getSelectedValue()),
                nullTOEmpty(div.getTxtJusho().getValue()),
                nullTOEmpty(div.getTxtTelNo().getDomain().getColumnValue()),
                nullTOEmpty(div.getTxtMobileNo().getDomain().getColumnValue()),
                yusen,
                div.getDdlRenrakusakiKubun().getSelectedKey(),
                div.getDdlShisho().getSelectedValue(),
                nullTOEmpty(div.getTxtKanaShimei().getValue()),
                div.getTxtYubinNo().getValue() == null ? RString.EMPTY : div.getTxtYubinNo().getValue().getColumnValue(),
                RString.EMPTY);
        dateSoruce.add(row);
        div.getDgRenrakusakiIchiran().setDataSource(dateSoruce);
    }

    private void set修正の一覧() {
        List<dgRenrakusakiIchiran_Row> dateSoruce = div.getDgRenrakusakiIchiran().getDataSource();
        TextBoxNum num = div.getDgRenrakusakiIchiran().getClickedItem().getRenban(); 
        TextBoxNum yusen = new TextBoxNum(); 
        yusen.setValue(div.getTxtYusenJuni().getValue());
        dgRenrakusakiIchiran_Row row = new dgRenrakusakiIchiran_Row(num,
                nullTOEmpty(div.getTxtShimei().getValue()),
                nullTOEmpty(div.getDdlTsuzukigara().getSelectedValue()),
                nullTOEmpty(div.getTxtJusho().getValue()),
                nullTOEmpty(div.getTxtTelNo().getDomain().getColumnValue()),
                nullTOEmpty(div.getTxtMobileNo().getDomain().getColumnValue()),
                yusen,
                div.getDdlRenrakusakiKubun().getSelectedKey(),
                div.getDdlShisho().getSelectedValue(),
                nullTOEmpty(div.getTxtKanaShimei().getValue()),
                div.getTxtYubinNo().getValue() == null ? RString.EMPTY : div.getTxtYubinNo().getValue().getColumnValue(),
                div.getDgRenrakusakiIchiran().getActiveRow().getShinseishoKanriNo());
        dateSoruce.set(div.getDgRenrakusakiIchiran().getClickedRowId(), row);
        div.getDgRenrakusakiIchiran().setDataSource(dateSoruce);
    }
    
    private TextBoxNum setRenban(List<dgRenrakusakiIchiran_Row> dateSoruce) {
        TextBoxNum num = new TextBoxNum();
        if (dateSoruce.isEmpty()) {
            num.setValue(Decimal.ONE);
        } else {
            Collections.sort(dateSoruce, new Comparator<dgRenrakusakiIchiran_Row>() {
                @Override
                public int compare(dgRenrakusakiIchiran_Row o1, dgRenrakusakiIchiran_Row o2) {
                    return o1.getRenban().getValue().compareTo(o2.getRenban().getValue());
                }
            });
            num.setValue(dateSoruce.get(dateSoruce.size() - 1).getRenban().getValue().add(Decimal.ONE));
        }
        return num;
    }

    
    /**
     * 連絡先一覧のデータソースをビジネスへ変換します。
     *
     * @param dbdBusiness List<RenrakusakiJoho>
     * @return List<RenrakusakiJoho>
     */
    public List<RenrakusakiJoho> setBusiness(List<RenrakusakiJoho> dbdBusiness) {
        if (RString.isNullOrEmpty(div.getDgRenrakusakiIchiran().getDataSource().get(INT_0).getShinseishoKanriNo())) {
            dbdBusiness = new ArrayList<>();
        }
        for (dgRenrakusakiIchiran_Row row : div.getDgRenrakusakiIchiran().getDataSource()) {
            if (RString.isNullOrEmpty(row.getShinseishoKanriNo())) {
                RenrakusakiJoho business = new RenrakusakiJoho(ShinseishoKanriNo.EMPTY, row.getRenban().getValue().intValue());
                business = business.createBuilderForEdit().set連絡先氏名(new AtenaMeisho(row.getShimei())).build();
                business = business.createBuilderForEdit().set連絡先続柄(row.getTsuzukigara()).build();
                business = business.createBuilderForEdit().set連絡先住所(new AtenaJusho(row.getJusho())).build();
                business = business.createBuilderForEdit().set連絡先電話番号(new TelNo(row.getTelNo())).build();
                business = business.createBuilderForEdit().set連絡先携帯番号(new TelNo(row.getMobileNo())).build();
                business = business.createBuilderForEdit().set優先順位(row.getYusenJuni().getValue() == null ? 0
                        : row.getYusenJuni().getValue().intValue()).build();
                business = business.createBuilderForEdit().set連絡先区分番号(row.getRenrakusakiKuBun()).build();
                business = business.createBuilderForEdit().set支所コード(new ShishoCode(row.getSisyo())).build();
                business = business.createBuilderForEdit().set連絡先氏名カナ(new AtenaKanaMeisho(row.getKanaShimei())).build();
                business = business.createBuilderForEdit().set連絡先郵便番号(new YubinNo(row.getYuubinBango())).build();
                dbdBusiness.add(business);
            } else {
                for (int i = 0; i < dbdBusiness.size(); i++) {
                    RenrakusakiJoho joho = dbdBusiness.get(i);
                    if (row.getShinseishoKanriNo().equals(joho.get申請書管理番号().value())
                            && row.getRenban().getText().toInt() == joho.get連番()) {
                        joho = joho.createBuilderForEdit().set連絡先氏名(new AtenaMeisho(row.getShimei())).build();
                        joho = joho.createBuilderForEdit().set連絡先続柄(row.getTsuzukigara()).build();
                        joho = joho.createBuilderForEdit().set連絡先住所(new AtenaJusho(row.getJusho())).build();
                        joho = joho.createBuilderForEdit().set連絡先電話番号(new TelNo(row.getTelNo())).build();
                        joho = joho.createBuilderForEdit().set連絡先携帯番号(new TelNo(row.getMobileNo())).build();
                        joho = joho.createBuilderForEdit().set優先順位(row.getYusenJuni().getValue() == null ? 0
                                : row.getYusenJuni().getValue().intValue()).build();
                        joho = joho.createBuilderForEdit().set連絡先区分番号(row.getRenrakusakiKuBun()).build();
                        joho = joho.createBuilderForEdit().set支所コード(new ShishoCode(row.getSisyo())).build();
                        joho = joho.createBuilderForEdit().set連絡先氏名カナ(new AtenaKanaMeisho(row.getKanaShimei())).build();
                        joho = joho.createBuilderForEdit().set連絡先郵便番号(new YubinNo(row.getYuubinBango())).build();
                        if (joho.hasChanged()) {
                            dbdBusiness.set(i, joho.modifiedModel());
                        }
                    }
                }
            }
        }
        return dbdBusiness;

    }

    private RString nullTOEmpty(RString obj) {
        return RString.isNullOrEmpty(obj) ? RString.EMPTY : obj;
    }

}
