/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.NinteiShinseiRenrakusakiJoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.RenrakusakiJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.RensakusakiTsuzukigara;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiJoho.NinteiShinseiRenrakusakiJoho.NinteiShinseiRenrakusakiJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiJoho.NinteiShinseiRenrakusakiJoho.dgRenrakusakiIchiran_Row;
import jp.co.ndensan.reams.db.dbz.service.core.shishosecurityjoho.ShishoSecurityJoho;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 *
 * 認定申請連絡先情報のHandlerクラスです。
 *
 * @reamsid_L DBE-1300-100 dongyabin
 */
public class NinteiShinseiRenrakusakiJohoHandler {

    private final NinteiShinseiRenrakusakiJohoDiv div;

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
        div.getDdlRenrakusakiKubun().getDataSource().clear();
        div.getDdlShisho().getDataSource().clear();
        div.getDdlTsuzukigara().getDataSource().clear();
        div.getTxtShimei().clearValue();
        div.getTxtKanaShimei().clearValue();
        div.getTxtYubinNo().clearValue();
        div.getTxtJusho().clearValue();
        div.getTxtTelNo().clearDomain();
        div.getTxtMobileNo().clearDomain();
        div.getTxtYusenJuni().clearValue();
        div.getDdlShisho().setDisplayNone(true);
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
        if (ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務).get支所管理有無フラグ()) {
            div.getDdlShisho().setDisplayNone(false);
            List<KeyValueDataSource> dataSrouceList = new ArrayList<>();
            KeyValueDataSource dataSource = new KeyValueDataSource(new RString("key0"),
                    ShishoSecurityJoho.createInstance().getShishoCode(UrControlDataFactory.
                            createInstance().getLoginInfo().getUserId()));
            dataSrouceList.add(dataSource);
            div.getDdlShisho().setDataSource(dataSrouceList);
        }
    }
    
    private void set連絡先区分DDL() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        List<UzT0007CodeEntity> codeList = CodeMaster.getCode(new CodeShubetsu("0008"));
        for (UzT0007CodeEntity code : codeList) {
            KeyValueDataSource dataSoruce = new KeyValueDataSource(code.getコード().getColumnValue(), code.getコード名称());
            dataSourceList.add(dataSoruce);
        }
        div.getDdlRenrakusakiKubun().setDataSource(dataSourceList);
    }

    private void set本人との関係DDL() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (RensakusakiTsuzukigara data : RensakusakiTsuzukigara.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource(data.getコード(), data.get名称());
            dataSourceList.add(dataSource);
        }
        div.getDdlTsuzukigara().setDataSource(dataSourceList);
    }
    
    private void set画面ReadOnly() {
        if (new RString("1").equals(div.getHdnReadOnly())) {
            div.setReadOnly(true);
        }
    }
    
    /**
     * 介護連絡先情報を設定します。
     * @param renrakusakiJohoList 介護連絡先情報（受給）
     */
    public void setRenrakusaki(List<RenrakusakiJoho> renrakusakiJohoList) {
        List<dgRenrakusakiIchiran_Row> dateSource = new ArrayList<>();
        for (RenrakusakiJoho renrakusakiJoho : renrakusakiJohoList) {
            dgRenrakusakiIchiran_Row row = new dgRenrakusakiIchiran_Row(new RString(String.valueOf(renrakusakiJoho.get連番())),
                    renrakusakiJoho.get連絡先氏名() == null ? RString.EMPTY : renrakusakiJoho.
                    get連絡先氏名().getColumnValue(),
                    renrakusakiJoho.get連絡先続柄(),
                    renrakusakiJoho.get連絡先住所() == null ? RString.EMPTY : renrakusakiJoho
                    .get連絡先住所().getColumnValue(),
                    renrakusakiJoho.get連絡先電話番号() == null ? RString.EMPTY : renrakusakiJoho.
                    get連絡先電話番号().getColumnValue(),
                    renrakusakiJoho.get連絡先携帯番号() == null ? RString.EMPTY : renrakusakiJoho.
                    get連絡先携帯番号().getColumnValue(),
                    new RString(String.valueOf(renrakusakiJoho.get優先順位())),
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY,
                    RString.EMPTY);
            dateSource.add(row);
        }
        div.getDgRenrakusakiIchiran().setDataSource(dateSource);
    }
    
    /**
     * 報を連絡先入力Divに反映します。
     */
    public void set連絡先入力情報() {
        dgRenrakusakiIchiran_Row row = div.getDgRenrakusakiIchiran().getActiveRow();
        div.getTxtRenban().setValue(row.getRenban());
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
        div.getBtnShinkiTsuika().setDisabled(true);
        div.getRenrakusakiIchiran().setReadOnly(true);
    }
}
