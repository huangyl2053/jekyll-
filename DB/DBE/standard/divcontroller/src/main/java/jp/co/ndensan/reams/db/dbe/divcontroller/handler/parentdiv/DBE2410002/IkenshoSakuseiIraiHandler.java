/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2410002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJohoBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshoirairirekiichiran.IkenshoirairirekiichiranShudou;
import jp.co.ndensan.reams.db.dbe.definition.core.IshiKubun;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410002.IkenshoSakuseiIraiDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoIraiKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 主治医意見書作成依頼(手動)のHandlerクラスです。
 *
 * @reamsid_L DBE-1590-030 zuotao
 */
public class IkenshoSakuseiIraiHandler {

    private final IkenshoSakuseiIraiDiv div;
    private static final RString SELECTED_KEY0 = new RString("key0");
    private static final RString SELECTED_KEY1 = new RString("key1");
    private static final RString SELECTED_KEY2 = new RString("key2");
    private static final int 初期履歴番号 = 1;
    private static final int 初期作成回数 = 1;
    private static final RString 主治医意見書作成期限設定方法_1 = new RString("1");
    private static final int 数字_1 = 1;
    private static final RString 指定医 = new RString("2");

    /**
     * コンストラクタです。
     *
     * @param div 主治医意見書作成依頼(手動)Div
     */
    public IkenshoSakuseiIraiHandler(IkenshoSakuseiIraiDiv div) {
        this.div = div;
    }

    /**
     * 主治医意見書作成依頼(手動)の初期化設定します。
     *
     * @param 主治医意見書作成依頼 主治医意見書作成依頼
     */
    public void initialize(IkenshoirairirekiichiranShudou 主治医意見書作成依頼) {
        set依頼区分();
        if (主治医意見書作成依頼 == null) {
            return;
        }
        if (RString.isNullOrEmpty(主治医意見書作成依頼.get主治医意見書作成依頼履歴番号())) {
            div.getDdlIraiKubun().setDisabled(false);
            div.getDdlIraiKubun().setSelectedKey(IkenshoIraiKubun.初回依頼.getコード());
        } else {
            div.getDdlIraiKubun().setDisabled(true);
            div.getDdlIraiKubun().setSelectedKey(主治医意見書作成依頼.get主治医意見書依頼区分());
        }
        div.setIkenshoIraiRirekiNo(主治医意見書作成依頼.get主治医意見書作成依頼履歴番号());
        if (主治医意見書作成依頼.get主治医意見書作成依頼年月日() != null && !主治医意見書作成依頼.get主治医意見書作成依頼年月日().isEmpty()) {
            div.getTxtSakuseiIraiD().setValue(new RDate(主治医意見書作成依頼.get主治医意見書作成依頼年月日().toString()));
        }
        
        boolean is指定医 = false;
        if (主治医意見書作成依頼.get医師区分コード() != null && 指定医.equals(主治医意見書作成依頼.get医師区分コード().value())) {
            is指定医 = true;
        }
        setCheckBoxValue();
    }

    private void setCheckBoxValue() {

        if (SELECTED_KEY2.equals(div.getRadKigen().getSelectedKey())) {
            div.getTxtKigenymd().setDisabled(false);
        } else {
            div.getTxtKigenymd().setDisabled(true);
        }
    }

    private FlexibleDate get主治医意見書作成期限年月日(FlexibleDate 認定申請年月日, IkenshoSakuseiIraiDiv div) {
        RString コンフィグ_主治医意見書作成期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        FlexibleDate 提出期限;
        RString key = div.getRadKigen().getSelectedKey();
        int 期限日数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString());
        if (主治医意見書作成期限設定方法_1.equals(コンフィグ_主治医意見書作成期限設定方法)) {
            if (SELECTED_KEY0.equals(key)) {
                提出期限 = div.getTxtSakuseiIraiD().getValue() != null
                        ? new FlexibleDate(div.getTxtSakuseiIraiD().getValue().plusDay(期限日数).toDateString()) : FlexibleDate.EMPTY;
            } else if (SELECTED_KEY1.equals(key)) {
                提出期限 = FlexibleDate.EMPTY;
            } else {
                提出期限 = (div.getTxtKigenymd().getValue() != null
                        ? new FlexibleDate(div.getTxtKigenymd().getValue().plusDay(期限日数).toDateString()) : FlexibleDate.EMPTY);
            }
        } else {
            提出期限 = 認定申請年月日 != null ? 認定申請年月日.plusDay(期限日数) : FlexibleDate.EMPTY;
        }
        return 提出期限;
    }
    
    /**
     * 主治医意見書作成依頼情報リスト(保存用)を作成します。
     * @param 要介護認定申請情報
     * @param 申請書管理番号
     * @return 主治医意見書作成依頼情報リスト
     */
    public List<ShujiiIkenshoIraiJoho> create主治医意見書作成依頼(NinteiShinseiJoho 要介護認定申請情報, RString 申請書管理番号) {
        List<ShujiiIkenshoIraiJoho> list = new ArrayList();
        if (!RString.isNullOrEmpty(div.getIkenshoIraiRirekiNo())) {
            ShujiiIkenshoIraiJoho updateIkenshoIraiJoho = 要介護認定申請情報.getShujiiIkenshoIraiJoho(
                    new ShujiiIkenshoIraiJohoIdentifier(new ShinseishoKanriNo(申請書管理番号),
                            Integer.parseInt(div.getIkenshoIraiRirekiNo().toString())));
            ShujiiIkenshoIraiJohoBuilder updateBuilder = updateIkenshoIraiJoho.createBuilderForEdit();
            updateBuilder.set論理削除フラグ(true);
            updateBuilder.build().toEntity().setState(EntityDataState.Modified);
            list.add(updateBuilder.build());
        }
        ShujiiIkenshoIraiJoho ikenshoIraiJoho;
        ShujiiIkenshoIraiJohoBuilder builder;
        if (RString.isNullOrEmpty(div.getIkenshoIraiRirekiNo())) {
            ikenshoIraiJoho = new ShujiiIkenshoIraiJoho(new ShinseishoKanriNo(申請書管理番号), 初期履歴番号);
            builder = ikenshoIraiJoho.createBuilderForEdit();
        } else {
            ikenshoIraiJoho = new ShujiiIkenshoIraiJoho(new ShinseishoKanriNo(申請書管理番号),
                    Integer.parseInt(div.getIkenshoIraiRirekiNo().toString()) + 数字_1);
            builder = ikenshoIraiJoho.createBuilderForEdit();
        }
        builder.set厚労省IF識別コード(要介護認定申請情報.get厚労省IF識別コード());
        builder.set主治医医療機関コード(div.getCcdShujiiInput().getIryoKikanCode());
        builder.set主治医コード(div.getCcdShujiiInput().getShujiiCode());
        builder.set主治医意見書依頼区分(div.getDdlIraiKubun().getSelectedKey());
        builder.set主治医意見書作成回数(初期作成回数);
        if (div.getCcdShujiiInput().hasShiteii()) {
            builder.set医師区分コード(new Code(IshiKubun.指定医.getCode()));
        } else {
            builder.set医師区分コード(new Code(IshiKubun.主治医.getCode()));
        }
        builder.set主治医意見書作成依頼年月日(new FlexibleDate(div.getTxtSakuseiIraiD().getValue().toDateString()));
        builder.set主治医意見書作成期限年月日(get主治医意見書作成期限年月日(要介護認定申請情報.get認定申請年月日(), div));
        builder.set論理削除フラグ(false);
        builder.build().toEntity().setState(EntityDataState.Added);
        list.add(builder.build());
        return list;
    }

    private void set依頼区分() {
        List<KeyValueDataSource> 依頼区分 = new ArrayList<>();
        依頼区分.add(new KeyValueDataSource(IkenshoIraiKubun.初回依頼.getコード(), IkenshoIraiKubun.初回依頼.get名称()));
        依頼区分.add(new KeyValueDataSource(IkenshoIraiKubun.再依頼.getコード(), IkenshoIraiKubun.再依頼.get名称()));
        依頼区分.add(new KeyValueDataSource(IkenshoIraiKubun.再意見書.getコード(), IkenshoIraiKubun.再意見書.get名称()));
        div.getDdlIraiKubun().setDataSource(依頼区分);
    }
}
