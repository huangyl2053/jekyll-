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
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoIraiKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
    private static final int 初期履歴番号 = 1;
    private static final int 初期作成回数 = 1;
    private static final int 数字_1 = 1;

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
        builder.set主治医意見書作成期限年月日(FlexibleDate.EMPTY);
        builder.set論理削除フラグ(false);
        builder.build().toEntity().setState(EntityDataState.Added);
        list.add(builder.build());
        return list;
    }

    private void set依頼区分() {
        List<KeyValueDataSource> 依頼区分 = new ArrayList<>();
        for (IkenshoIraiKubun ikenshoIraiKubun : IkenshoIraiKubun.values()) {
            依頼区分.add(new KeyValueDataSource(ikenshoIraiKubun.getコード(), ikenshoIraiKubun.get名称()));
        }
        div.getDdlIraiKubun().setDataSource(依頼区分);
    }
}
