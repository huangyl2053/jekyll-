/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TekiyoJogaiRireki.TekiyoJogaiRireki;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.service.core.tekiyojogaisha.TekiyoJogaishaManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaishoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.business.core.TekiyoJogaishaIdentifier;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 適用除外者を保存します。
 * 通常、このような実装は推奨されません。
 * （serviceパッケージのクラスからトランザクションを貼るのが推奨です。）
 */
class TekiyoJogaiRirekiPersistor {

    TekiyoJogaiRirekiPersistor() {
    }

    /**
     * インスタンスを生成します。
     * このメソッドからインスタンスを生成した場合のみ、正常にトランザクション処理が実施されます。
     */
    static TekiyoJogaiRirekiPersistor createInstance() {
        return InstanceProvider.create(TekiyoJogaiRirekiPersistor.class);
    }

    /**
     * 適用除外者管理の共有子DIVの画面内容から、適用除外者情報をDBに反映します。
     *
     * @param 識別コード 識別コード
     */
    @Transaction
    void save適用除外者(TekiyoJogaiRirekiDiv div, ShikibetsuCode 識別コード) {
        List<datagridTekiyoJogai_Row> rowList = div.getDatagridTekiyoJogai().getDataSource();
        Models<TekiyoJogaishaIdentifier, TekiyoJogaisha> 適用除外者Model
                = ViewStateHolder.get(ViewStateKeys.適用除外者情報, Models.class);
        Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> 保険施設入退所Model
                = ViewStateHolder.get(ViewStateKeys.保険施設入退所情報, Models.class);

        for (datagridTekiyoJogai_Row row : rowList) {
            if (row.getRowState() == null || RowState.Unchanged.equals(row.getRowState())) {
                continue;
            }

            FlexibleDate 変更前異動日 = new FlexibleDate(row.getHenkoumaeIdoYMD());
            FlexibleDate 変更後異動日 = new FlexibleDate(row.getHenkougoIdoYMD());
            RString 変更前枝番 = row.getHenkoumaeEdaNo();
            RString 変更後枝番 = row.getHenkougoEdaNo();
            switch (div.getMode_DisplayMode()) {
                case 適用登録モード:
                    TekiyoJogaishaIdentifier torokuTarget
                            = new TekiyoJogaishaIdentifier(識別コード, 変更後異動日, 変更後枝番);
                    ShisetsuNyutaishoIdentifier taishoTarget
                            = new ShisetsuNyutaishoIdentifier(識別コード, Integer.parseInt(row.getRirekiNo().toString()));
                    TekiyoJogaishaManager.createInstance().saveTekiyoJogaisha適用登録(
                            set適用状態適用除外者情報(適用除外者Model.get(torokuTarget), row).toEntity(),
                            set適用状態介護保険施設入退所(保険施設入退所Model.get(taishoTarget), row).toEntity(),
                            識別コード);
                    Collections.sort(rowList, new TekiyoJogaiRirekiHandler.DateComparator());
                    break;
                case 解除モード:
                    TekiyoJogaishaIdentifier beforeIdentifier
                            = new TekiyoJogaishaIdentifier(識別コード, 変更前異動日, 変更前枝番);
                    TekiyoJogaishaIdentifier afterIdentifiier
                            = new TekiyoJogaishaIdentifier(識別コード, 変更後異動日, 変更後枝番);
                    ShisetsuNyutaishoIdentifier taisho = new ShisetsuNyutaishoIdentifier(
                            識別コード, Integer.parseInt(row.getRirekiNo().toString()));
                    TekiyoJogaishaManager.createInstance().saveTekiyoJogaisha解除(
                            適用除外者Model.get(beforeIdentifier).createBuilderForEdit().set論理削除フラグ(true).build().toEntity(),
                            set解除状態適用除外者情報(適用除外者Model.get(afterIdentifiier), row).toEntity(),
                            set解除状態介護保険施設入退所(保険施設入退所Model.get(taisho), row).toEntity(), 識別コード);
            }

            if (RowState.Added.equals(row.getRowState())) {
                TekiyoJogaishaManager.createInstance()
                        .regTekiyoJogaisha(
                                set適用除外者情報(適用除外者Model.get(new TekiyoJogaishaIdentifier(識別コード, 変更後異動日, 変更後枝番)), row)
                                .toEntity()
                        );
            } else if (RowState.Modified.equals(row.getRowState())) {
                TekiyoJogaishaManager.createInstance()
                        .regTekiyoJogaisha(
                                適用除外者Model.get(new TekiyoJogaishaIdentifier(識別コード, 変更前異動日, 変更前枝番))
                                .createBuilderForEdit().set論理削除フラグ(true).build()
                                .toEntity()
                        );
                TekiyoJogaishaManager.createInstance()
                        .regTekiyoJogaisha(
                                set修正状態適用除外者情報(適用除外者Model.get(new TekiyoJogaishaIdentifier(識別コード, 変更後異動日, 変更後枝番)), row)
                                .toEntity()
                        );
            } else if (RowState.Deleted.equals(row.getRowState())) {
                TekiyoJogaishaManager.createInstance()
                        .regTekiyoJogaisha(
                                適用除外者Model.get(new TekiyoJogaishaIdentifier(識別コード, 変更前異動日, 変更前枝番))
                                .createBuilderForEdit()
                                .set論理削除フラグ(true)
                                .build().toEntity()
                        );
            }
        }
    }

    private TekiyoJogaisha set修正状態適用除外者情報(
            TekiyoJogaisha tekiyoJogaisha,
            datagridTekiyoJogai_Row row) {
        FlexibleDate 適用日 = FlexibleDate.EMPTY;
        FlexibleDate 適用届出日 = FlexibleDate.EMPTY;
        FlexibleDate 解除日 = FlexibleDate.EMPTY;
        FlexibleDate 解除届出日 = FlexibleDate.EMPTY;
        if (row.getTekiyoDate().getValue() != null) {
            適用日 = new FlexibleDate(row.getTekiyoDate().getValue().toDateString());
        }
        if (row.getTekiyoTodokeDate().getValue() != null) {
            適用届出日 = new FlexibleDate(row.getTekiyoTodokeDate().getValue().toDateString());
        }
        if (row.getKayijoDate().getValue() != null) {
            解除日 = new FlexibleDate(row.getKayijoDate().getValue().toDateString());
        }
        if (row.getKaijoTodokeDate().getValue() != null) {
            解除届出日 = new FlexibleDate(row.getKaijoTodokeDate().getValue().toDateString());
        }
        return tekiyoJogaisha.createBuilderForEdit()
                .set識別コード(tekiyoJogaisha.get識別コード())
                .set異動日(tekiyoJogaisha.get異動日())
                .set枝番(tekiyoJogaisha.get枝番())
                .set異動事由コード(row.getIdoJiyuCode())
                .set市町村コード(new LasdecCode(row.getShichosonCode()))
                .set適用除外適用事由コード(row.getTekiyoJiyuCode())
                .set適用年月日(適用日)
                .set適用届出年月日(適用届出日)
                .set適用受付年月日(適用届出日)
                .set適用除外解除事由コード(row.getKaijoJiyuCode())
                .set解除年月日(解除日)
                .set解除届出年月日(解除届出日)
                .set解除受付年月日(解除届出日)
                .set入所通知発行日(new FlexibleDate(row.getNyushoTsuchiHakkoYMD()))
                .set退所通知発行日(new FlexibleDate(row.getTaishoTsuchiHakkoYMD()))
                .set変更通知発行日(new FlexibleDate(row.getHenkoTsuchiHakkoYMD()))
                .set論理削除フラグ(false)
                .build();
    }

    private UaFt200FindShikibetsuTaishoEntity get宛名情報(ShikibetsuCode 識別コード) {
        return TekiyoJogaishaManager.createInstance().get宛名情報(識別コード);
    }

    private TekiyoJogaisha set適用除外者情報(
            TekiyoJogaisha tekiyoJogaisha,
            datagridTekiyoJogai_Row row) {
        RString 異動事由コード;
        if (row.getKayijoDate().getValue() == null) {
            異動事由コード = row.getTekiyoJiyuCode();
        } else {
            異動事由コード = row.getKaijoJiyuCode();
        }
        UaFt200FindShikibetsuTaishoEntity 宛名情報 = get宛名情報(tekiyoJogaisha.get識別コード());
        FlexibleDate 適用日 = FlexibleDate.EMPTY;
        FlexibleDate 解除日 = FlexibleDate.EMPTY;
        FlexibleDate 適用届出日 = FlexibleDate.EMPTY;
        FlexibleDate 解除届出日 = FlexibleDate.EMPTY;
        if (row.getTekiyoDate().getValue() != null) {
            適用日 = new FlexibleDate(row.getTekiyoDate().getValue().toDateString());
        }
        if (row.getTekiyoTodokeDate().getValue() != null) {
            適用届出日 = new FlexibleDate(row.getTekiyoTodokeDate().getValue().toDateString());
        }
        if (row.getKayijoDate().getValue() != null) {
            解除日 = new FlexibleDate(row.getKayijoDate().getValue().toDateString());
        }
        if (row.getKaijoTodokeDate().getValue() != null) {
            解除届出日 = new FlexibleDate(row.getKaijoTodokeDate().getValue().toDateString());
        }
        return tekiyoJogaisha.createBuilderForEdit()
                .set識別コード(tekiyoJogaisha.get識別コード())
                .set異動日(解除日)
                .set枝番(tekiyoJogaisha.get枝番())
                .set異動事由コード(異動事由コード)
                .set市町村コード(宛名情報.getGenLasdecCode())
                .set適用除外適用事由コード(row.getTekiyoJiyuCode())
                .set適用年月日(適用日)
                .set適用届出年月日(適用届出日)
                .set適用受付年月日(適用届出日)
                .set適用除外解除事由コード(row.getKaijoJiyuCode())
                .set解除年月日(解除日)
                .set解除届出年月日(解除届出日)
                .set解除受付年月日(解除届出日)
                .set論理削除フラグ(false)
                .build();
    }

    private TekiyoJogaisha set適用状態適用除外者情報(
            TekiyoJogaisha tekiyoJogaisha,
            datagridTekiyoJogai_Row row) {
        UaFt200FindShikibetsuTaishoEntity 宛名情報 = get宛名情報(tekiyoJogaisha.get識別コード());
        FlexibleDate 適用日 = FlexibleDate.EMPTY;
        FlexibleDate 適用届出日 = FlexibleDate.EMPTY;
        if (row.getTekiyoDate().getValue() != null) {
            適用日 = new FlexibleDate(row.getTekiyoDate().getValue().toDateString());
        }
        if (row.getTekiyoTodokeDate().getValue() != null) {
            適用届出日 = new FlexibleDate(row.getTekiyoTodokeDate().getValue().toDateString());
        }
        return tekiyoJogaisha.createBuilderForEdit()
                .set識別コード(tekiyoJogaisha.get識別コード())
                .set異動日(適用日)
                .set枝番(tekiyoJogaisha.get枝番())
                .set異動事由コード(row.getTekiyoJiyuCode())
                .set市町村コード(宛名情報.getGenLasdecCode())
                .set適用除外適用事由コード(row.getTekiyoJiyuCode())
                .set適用年月日(適用日)
                .set適用届出年月日(適用届出日)
                .set適用受付年月日(適用届出日)
                .set適用除外解除事由コード(row.getKaijoJiyuCode())
                .set論理削除フラグ(false)
                .build();
    }

    private TekiyoJogaisha set解除状態適用除外者情報(
            TekiyoJogaisha tekiyoJogaisha,
            datagridTekiyoJogai_Row row) {
        FlexibleDate 適用日 = FlexibleDate.EMPTY;
        FlexibleDate 適用届出日 = FlexibleDate.EMPTY;
        FlexibleDate 解除日 = FlexibleDate.EMPTY;
        FlexibleDate 解除届出日 = FlexibleDate.EMPTY;
        if (row.getTekiyoDate().getValue() != null) {
            適用日 = new FlexibleDate(row.getTekiyoDate().getValue().toDateString());
        }
        if (row.getTekiyoTodokeDate().getValue() != null) {
            適用届出日 = new FlexibleDate(row.getTekiyoTodokeDate().getValue().toDateString());
        }
        if (row.getKayijoDate().getValue() != null) {
            解除日 = new FlexibleDate(row.getKayijoDate().getValue().toDateString());
        }
        if (row.getKaijoTodokeDate().getValue() != null) {
            解除届出日 = new FlexibleDate(row.getKaijoTodokeDate().getValue().toDateString());
        }
        return tekiyoJogaisha.createBuilderForEdit()
                .set識別コード(tekiyoJogaisha.get識別コード())
                .set異動日(解除日)
                .set枝番(tekiyoJogaisha.get枝番())
                .set異動事由コード(row.getKaijoJiyuCode())
                .set市町村コード(new LasdecCode(row.getShichosonCode()))
                .set適用除外適用事由コード(row.getTekiyoJiyuCode())
                .set適用年月日(適用日)
                .set適用届出年月日(適用届出日)
                .set適用受付年月日(適用届出日)
                .set適用除外解除事由コード(row.getKaijoJiyuCode())
                .set解除年月日(解除日)
                .set解除届出年月日(解除届出日)
                .set解除受付年月日(解除届出日)
                .set入所通知発行日(new FlexibleDate(row.getNyushoTsuchiHakkoYMD()))
                .set退所通知発行日(new FlexibleDate(row.getTaishoTsuchiHakkoYMD()))
                .set変更通知発行日(new FlexibleDate(row.getHenkoTsuchiHakkoYMD()))
                .set論理削除フラグ(false)
                .build();
    }

    private ShisetsuNyutaisho set適用状態介護保険施設入退所(
            ShisetsuNyutaisho taisho,
            datagridTekiyoJogai_Row row) {
        UaFt200FindShikibetsuTaishoEntity 宛名情報 = get宛名情報(taisho.get識別コード());
        return taisho.createBuilderForEdit()
                .set市町村コード(宛名情報.getGenLasdecCode())
                .set台帳種別(new RString("3"))
                .set入所施設種類(row.getShisetsuShurui())
                .set入所施設コード(new JigyoshaNo(row.getNyushoShisetsuCode()))
                .set入所処理年月日(FlexibleDate.getNowDate())
                .set入所年月日(new FlexibleDate(row.getNyuShoDate().getValue().toDateString()))
                .build();
    }

    private ShisetsuNyutaisho set解除状態介護保険施設入退所(
            ShisetsuNyutaisho taisho,
            datagridTekiyoJogai_Row row) {
        return taisho.createBuilderForEdit()
                .set退所年月日(new FlexibleDate(row.getTaiShoDate().getValue().toDateString()))
                .set退所処理年月日(FlexibleDate.getNowDate())
                .build();
    }

}
