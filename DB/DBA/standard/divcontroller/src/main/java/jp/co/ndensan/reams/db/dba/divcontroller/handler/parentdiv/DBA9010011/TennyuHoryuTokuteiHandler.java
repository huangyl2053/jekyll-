/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA9010011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tennyuhoryutokuteijushoichiran.TennyuHoryuTokuteiBusiness;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA9010011.TennyuHoryuTokuteiJushoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA9010011.ddlTennyuHoryuTokuteiJushoIchiran_Row;
import jp.co.ndensan.reams.db.dba.service.core.tennyuhoryutokuteijushotoroku.TennyuHoryuTokuteiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RendoHoryuTokuteiJusho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RendoHoryuTokuteiJushoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RendoHoryuTokuteiJushoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoseiShichoson;
import jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ShichosonInput.ShichosonInputDiv;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.BanchiCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 連動保留特定住所登録の取得するクラスです。
 *
 * @reamsid_L DBA-0480-010 zhangzhiming
 */
public class TennyuHoryuTokuteiHandler {

    private final TennyuHoryuTokuteiJushoDiv div;
    private static final RString SHICHOSONCODE_VALUE = new RString("11");
    private static final RString 追加 = new RString("追加");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 保存 = new RString("TennyuHozon");
    private static final RString 市町村コード = new RString("txtShichosonCode");
    private static final RString 市町村名称 = new RString("txtShichosonName");
    private static final int 桁数_5 = 5;

    /**
     * コンストラクタです。
     *
     * @param div 連動保留特定住所登録パネル
     */
    public TennyuHoryuTokuteiHandler(TennyuHoryuTokuteiJushoDiv div) {
        this.div = div;
    }

    /**
     * 転入保留特定住所一覧を検索します。
     *
     * @param businessList List<TennyuHoryuTokuteiBusiness>
     */
    public void onLoad(List<TennyuHoryuTokuteiBusiness> businessList) {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存, true);
        div.getBtnTennyuHoryuTokuteiJushoHozon().setDisabled(false);
        div.getBtnKakutei().setDisabled(true);
        div.getTennyuHoryuTokuteiJushoNyuryoku().setDisabled(true);
        div.getCcdShichousonInputGuide().load(RString.EMPTY);
        div.getCcdJushoInputGuide().initialize();
        div.getCcdBunchiInput().initialize();
        div.getCcdSisetuInputGuide().initialize();
        List<ddlTennyuHoryuTokuteiJushoIchiran_Row> dgKoufuKaishuList = new ArrayList<>();
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        Code 導入形態コード = 市町村セキュリティ情報.get導入形態コード();
        if (!SHICHOSONCODE_VALUE.equals(導入形態コード.getKey().substring(1))) {
            div.getDdlTennyuHoryuTokuteiJushoIchiran().getGridSetting().getColumn(市町村コード).setVisible(false);
            div.getDdlTennyuHoryuTokuteiJushoIchiran().getGridSetting().getColumn(市町村名称).setVisible(false);
        }
        if (businessList != null && !businessList.isEmpty()) {
            for (TennyuHoryuTokuteiBusiness tennyuhoryu : businessList) {
                ddlTennyuHoryuTokuteiJushoIchiran_Row dgJigyoshaItiran = new ddlTennyuHoryuTokuteiJushoIchiran_Row();
                dgJigyoshaItiran.setTxtKanriNo(tennyuhoryu.get管理番号());
                dgJigyoshaItiran.setTxtShichosonCode(tennyuhoryu.get市町村コード().value());
                dgJigyoshaItiran.setTxtShichosonName(tennyuhoryu.get市町村名称());
                dgJigyoshaItiran.setTxtJushoCode(tennyuhoryu.get住所コード());
                dgJigyoshaItiran.setTxtJusho(tennyuhoryu.get住所().value());
                dgJigyoshaItiran.setTxtBanchiCode1(tennyuhoryu.get番地コード1().value());
                dgJigyoshaItiran.setTxtBanchiCode2(tennyuhoryu.get番地コード2().value());
                dgJigyoshaItiran.setTxtBanchiCode3(tennyuhoryu.get番地コード3().value());
                dgJigyoshaItiran.setTxtBanchi(tennyuhoryu.get番地().value());
                dgJigyoshaItiran.setTxtShisetsuShurui(tennyuhoryu.get施設種類());
                if (!RString.isNullOrEmpty(tennyuhoryu.get施設種類())) {
                    dgJigyoshaItiran.setTxtShisetsuName(ShisetsuType.toValue(tennyuhoryu.get施設種類()).get名称());
                }
                RStringBuilder builder = new RStringBuilder();
                builder.append(tennyuhoryu.get施設コード());
                builder.append(RString.HALF_SPACE);
                builder.append(tennyuhoryu.get施設名称() == null ? RString.EMPTY : tennyuhoryu.get施設名称());
                dgJigyoshaItiran.setTxtShisetsuJoho(builder.toRString());
                dgKoufuKaishuList.add(dgJigyoshaItiran);
            }
        }
        div.getDdlTennyuHoryuTokuteiJushoIchiran().setDataSource(dgKoufuKaishuList);
    }

    /**
     * 「転入保留特定住所を追加する」ボタンをクリックします。
     *
     */
    public void onClick_btnAdd() {
        div.getBtnKakutei().setDisabled(false);
        div.getTennyuHoryuTokuteiJushoNyuryoku().setDisabled(false);
        div.getCcdShichousonInputGuide().clear();
        div.getCcdJushoInputGuide().clear();
        div.getCcdBunchiInput().clear();
        div.getCcdSisetuInputGuide().clear();
        div.getTennyuHoryuTokuteiJushoNyuryoku().setTxtJotai(追加);
        div.getCcdShichousonInputGuide().setInputMode(ShichosonInputDiv.InputMode.名称及びコード);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存, true);
    }

    /**
     * 入力チェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs detaCheck() {
        return createValidationHandler(div).validateCheck();
    }

    private TennyuHoryuValidationHandler createValidationHandler(TennyuHoryuTokuteiJushoDiv div) {
        return new TennyuHoryuValidationHandler(div);
    }

    /**
     * 「転入保留特定住所を確定する」ボタンをクリックします。
     *
     */
    public void onClick_btnKakutei() {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存, false);
        List<ddlTennyuHoryuTokuteiJushoIchiran_Row> dgKoufuKaishuList = div.getDdlTennyuHoryuTokuteiJushoIchiran().getDataSource();
        div.getCcdShichousonInputGuide().get市町村コード();
        div.getCcdBunchiInput().get番地().getColumnValue();
        int rowcount = 0;
        if (!追加.equals(div.getTennyuHoryuTokuteiJushoNyuryoku().getTxtJotai())) {
            rowcount = div.getDdlTennyuHoryuTokuteiJushoIchiran().getClickedItem().getId();
        }
        ddlTennyuHoryuTokuteiJushoIchiran_Row row;
        RString 市町村 = div.getCcdShichousonInputGuide().get市町村コード();
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        Code 導入形態コード = 市町村セキュリティ情報.get導入形態コード();
        市町村セキュリティ情報.get市町村情報().get市町村コード();
        if (SHICHOSONCODE_VALUE.equals(導入形態コード.getKey().substring(1))) {
            List<KoseiShichoson> koseiShichosonList = KoikiShichosonJohoFinder.createInstance().getKoseiShichosonList().records();
            for (KoseiShichoson koseiList : koseiShichosonList) {
                if (div.getCcdShichousonInputGuide().get市町村コード()
                        .equals(koseiList.get市町村コード().value().substring(0, 桁数_5))) {
                    市町村 = koseiList.get市町村コード().value();
                }
            }
        } else {
            市町村 = 市町村セキュリティ情報.get市町村情報().get市町村コード().getColumnValue();
        }
        if (追加.equals(div.getTennyuHoryuTokuteiJushoNyuryoku().getTxtJotai())) {
            row = new ddlTennyuHoryuTokuteiJushoIchiran_Row();
            row.setRowState(RowState.Added);
            row.setTxtShichosonCode(市町村);
            row.setTxtShichosonName(div.getCcdShichousonInputGuide().get市町村名称());
            row.setTxtJushoCode(div.getCcdJushoInputGuide().get町域コード().getColumnValue());
            row.setTxtJusho(div.getCcdJushoInputGuide().get町域名称());
            row.setTxtBanchiCode1(div.getCcdBunchiInput().get番地コード1().getColumnValue());
            row.setTxtBanchiCode2(div.getCcdBunchiInput().get番地コード2().getColumnValue());
            row.setTxtBanchiCode3(div.getCcdBunchiInput().get番地コード3().getColumnValue());
            row.setTxtBanchi(div.getCcdBunchiInput().get番地().getColumnValue());
            row.setTxtShisetsuShurui(div.getCcdSisetuInputGuide().get施設種類());
            if (!RString.isNullOrEmpty(div.getCcdSisetuInputGuide().get施設種類())) {
                row.setTxtShisetsuName(ShisetsuType.toValue(div.getCcdSisetuInputGuide().get施設種類()).get名称());
            }
            RStringBuilder builder = new RStringBuilder();
            builder.append(div.getCcdSisetuInputGuide().getNyuryokuShisetsuKodo());
            builder.append(RString.HALF_SPACE);
            builder.append(div.getCcdSisetuInputGuide().getNyuryokuShisetsuMeisho());
            row.setTxtShisetsuJoho(builder.toRString());
            dgKoufuKaishuList.add(row);
        }
        if (修正.equals(div.getTennyuHoryuTokuteiJushoNyuryoku().getTxtJotai())) {
            row = dgKoufuKaishuList.get(rowcount);
            row.setTxtShichosonCode(市町村);
            row.setTxtShichosonName(div.getCcdShichousonInputGuide().get市町村名称());
            row.setTxtJushoCode(div.getCcdJushoInputGuide().get町域コード().getColumnValue());
            row.setTxtJusho(div.getCcdJushoInputGuide().get町域名称());
            row.setTxtBanchiCode1(div.getCcdBunchiInput().get番地コード1().getColumnValue());
            row.setTxtBanchiCode2(div.getCcdBunchiInput().get番地コード2().getColumnValue());
            row.setTxtBanchiCode3(div.getCcdBunchiInput().get番地コード3().getColumnValue());
            row.setTxtBanchi(div.getCcdBunchiInput().get番地().getColumnValue());
            row.setTxtShisetsuShurui(div.getCcdSisetuInputGuide().get施設種類());
            if (!RString.isNullOrEmpty(div.getCcdSisetuInputGuide().get施設種類())) {
                row.setTxtShisetsuName(ShisetsuType.toValue(div.getCcdSisetuInputGuide().get施設種類()).get名称());
            }
            RStringBuilder builder = new RStringBuilder();
            builder.append(div.getCcdSisetuInputGuide().getNyuryokuShisetsuKodo());
            builder.append(RString.HALF_SPACE);
            builder.append(div.getCcdSisetuInputGuide().getNyuryokuShisetsuMeisho());
            row.setTxtShisetsuJoho(builder.toRString());
            if (RowState.Added.equals(row.getRowState())) {
                row.setRowState(RowState.Added);
            } else {
                row.setRowState(RowState.Modified);
            }
            dgKoufuKaishuList.set(rowcount, row);
        }
        if (削除.equals(div.getTennyuHoryuTokuteiJushoNyuryoku().getTxtJotai())) {
            row = dgKoufuKaishuList.get(rowcount);
            if (RowState.Added.equals(row.getRowState())) {
                dgKoufuKaishuList.remove(rowcount);
            } else {
                row.setRowState(RowState.Deleted);
                dgKoufuKaishuList.set(rowcount, row);
            }
        }
    }

    /**
     * 「修正」ボタンをクリックします。
     *
     */
    public void onClick_btnModify() {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存, true);
        div.getBtnKakutei().setDisabled(false);
        div.getTennyuHoryuTokuteiJushoNyuryoku().setDisabled(false);
        div.getTennyuHoryuTokuteiJushoNyuryoku().setTxtJotai(修正);
        ddlTennyuHoryuTokuteiJushoIchiran_Row dgRow = div.getDdlTennyuHoryuTokuteiJushoIchiran().getSelectedItems().get(0);
        div.getCcdShichousonInputGuide().load(dgRow.getTxtShichosonCode().substring(0, 桁数_5));
        div.getCcdShichousonInputGuide().setInputMode(ShichosonInputDiv.InputMode.名称);
        div.getCcdJushoInputGuide().load(new ChoikiCode(dgRow.getTxtJushoCode()));
        div.getCcdBunchiInput().load(new AtenaBanchi(dgRow.getTxtBanchi()));
        div.getCcdSisetuInputGuide().set施設種類(dgRow.getTxtShisetsuShurui());
        div.getCcdSisetuInputGuide().setNyuryokuShisetsuKodo(dgRow.getTxtShisetsuJoho()
                .split(RString.HALF_SPACE.toString()).get(0));
        div.getCcdSisetuInputGuide().setShisetsuMeisho(dgRow.getTxtShisetsuJoho()
                .split(RString.HALF_SPACE.toString()).get(1));
    }

    /**
     * 「削除」ボタンをクリックします。
     *
     */
    public void onClick_btnDelete() {
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存, true);
        div.getBtnKakutei().setDisabled(false);
        div.getTennyuHoryuTokuteiJushoNyuryoku().setDisabled(true);
        div.getTennyuHoryuTokuteiJushoNyuryoku().setTxtJotai(削除);
        ddlTennyuHoryuTokuteiJushoIchiran_Row dgRow = div.getDdlTennyuHoryuTokuteiJushoIchiran().getSelectedItems().get(0);
        div.getCcdShichousonInputGuide().load(dgRow.getTxtShichosonCode().substring(0, 桁数_5));
        div.getCcdJushoInputGuide().load(new ChoikiCode(dgRow.getTxtJushoCode()));
        div.getCcdBunchiInput().load(new AtenaBanchi(dgRow.getTxtBanchi()));
        div.getCcdSisetuInputGuide().set施設種類(dgRow.getTxtShisetsuShurui());
        div.getCcdSisetuInputGuide().setNyuryokuShisetsuKodo(dgRow.getTxtShisetsuJoho()
                .split(RString.HALF_SPACE.toString()).get(0));
        div.getCcdSisetuInputGuide().setShisetsuMeisho(dgRow.getTxtShisetsuJoho()
                .split(RString.HALF_SPACE.toString()).get(1));
    }

    /**
     * 転入保留特定住所一覧を設定します。
     *
     * @param models models
     */
    public void onClick_SaveButton(Models<RendoHoryuTokuteiJushoIdentifier, RendoHoryuTokuteiJusho> models) {
        List<ddlTennyuHoryuTokuteiJushoIchiran_Row> dgKoufuKaishuList = div.getDdlTennyuHoryuTokuteiJushoIchiran().getDataSource();
        TennyuHoryuTokuteiManager manager = TennyuHoryuTokuteiManager.createInstance();
        for (ddlTennyuHoryuTokuteiJushoIchiran_Row list : dgKoufuKaishuList) {
            if (RowState.Added.equals(list.getRowState())) {
                RString 管理番号 = manager.getKanriNo();
                RendoHoryuTokuteiJusho rendoHoryu = new RendoHoryuTokuteiJusho(RString.isNullOrEmpty(管理番号) ? new RString("1")
                        : new RString(String.valueOf(Integer.parseInt(管理番号.toString()) + 1)), new LasdecCode(list.getTxtShichosonCode()));
                RendoHoryuTokuteiJushoBuilder builder = rendoHoryu.createBuilderForEdit();
                builder.set住所(new AtenaJusho(list.getTxtJusho()));
                builder.set住所コード(new ChoikiCode(list.getTxtJushoCode()));
                builder.set施設コード(list.getTxtShisetsuJoho().split(RString.HALF_SPACE.toString()).get(0));
                builder.set施設種類(list.getTxtShisetsuShurui());
                builder.set番地(new AtenaBanchi(list.getTxtBanchi()));
                builder.set番地コード１(new BanchiCode(list.getTxtBanchiCode1()));
                builder.set番地コード２(new BanchiCode(list.getTxtBanchiCode2()));
                builder.set番地コード３(new BanchiCode(list.getTxtBanchiCode3()));
                builder.set施設名称(new AtenaMeisho(list.getTxtShisetsuJoho().split(RString.HALF_SPACE.toString()).get(1)));
                manager.insertOrUpdateOrDel(builder.build(), EntityDataState.Added);
            }
            if (RowState.Modified.equals(list.getRowState())) {
                RendoHoryuTokuteiJushoIdentifier key = new RendoHoryuTokuteiJushoIdentifier(list.getTxtKanriNo(),
                        new LasdecCode(list.getTxtShichosonCode()));
                RendoHoryuTokuteiJusho rendoHoryu = models.get(key);
                RendoHoryuTokuteiJushoBuilder builder = rendoHoryu.createBuilderForEdit();
                builder.set住所(new AtenaJusho(list.getTxtJusho()));
                builder.set住所コード(new ChoikiCode(list.getTxtJushoCode()));
                builder.set施設コード(list.getTxtShisetsuJoho().split(RString.HALF_SPACE.toString()).get(0));
                builder.set施設種類(list.getTxtShisetsuShurui());
                builder.set番地(new AtenaBanchi(list.getTxtBanchi()));
                builder.set番地コード１(new BanchiCode(list.getTxtBanchiCode1()));
                builder.set番地コード２(new BanchiCode(list.getTxtBanchiCode2()));
                builder.set番地コード３(new BanchiCode(list.getTxtBanchiCode3()));
                builder.set施設名称(new AtenaMeisho(list.getTxtShisetsuJoho().split(RString.HALF_SPACE.toString()).get(1)));
                manager.insertOrUpdateOrDel(builder.build(), EntityDataState.Modified);
            }
            if (RowState.Deleted.equals(list.getRowState())) {
                RendoHoryuTokuteiJushoIdentifier key = new RendoHoryuTokuteiJushoIdentifier(list.getTxtKanriNo(),
                        new LasdecCode(list.getTxtShichosonCode()));
                RendoHoryuTokuteiJusho rendoHoryu = models.get(key);
                RendoHoryuTokuteiJushoBuilder builder = rendoHoryu.createBuilderForEdit();
                manager.insertOrUpdateOrDel(builder.build(), EntityDataState.Deleted);
            }
        }
    }
}
