/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.futangendogakunintei.futangendogakuninteishinsei;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiViewState;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinseiIdentifier;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4036FutanGendogakuNinteiBatchTestResultsEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4036FutanGendogakuNinteiBatchTestResultsDac;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 負担限度額認定申請を管理するクラスです。
 *
 * @reamsid_L DBD-3590-010 huangh
 */
public class FutangendogakuNinteiShinseiManager {

    private final DbT4036FutanGendogakuNinteiBatchTestResultsDac dac;

    /**
     * コンストラクタです。
     */
    public FutangendogakuNinteiShinseiManager() {
        this.dac = InstanceProvider.create(DbT4036FutanGendogakuNinteiBatchTestResultsDac.class);
    }

    /**
     * 負担限度額認定申請を管理するクラスを生成します。
     *
     * @return 負担限度額認定申請を管理するクラス
     */
    public static FutangendogakuNinteiShinseiManager createInstance() {
        return InstanceProvider.create(FutangendogakuNinteiShinseiManager.class);
    }

    /**
     * 介護保険負担限度額認定を削除する。
     *
     * @param hihokenshaNo 被保険者番号
     */
    @Transaction
    public void delete利用者負担額減額by被保険者番号(HihokenshaNo hihokenshaNo) {
        for (DbT4036FutanGendogakuNinteiBatchTestResultsEntity entity : dac.selectByHihokenshaNo(hihokenshaNo)) {
            entity.setState(EntityDataState.Deleted);
            dac.save(entity);
        }
    }

    /**
     * 負担限度額認定申請の更新処理
     *
     * @param 申請一覧情報ArrayList 申請一覧情報ArrayList
     * @param new申請情報List new申請情報List
     * @param 被保険者番号 被保険者番号
     */
    @Transaction
    public void save(ArrayList<FutanGendogakuNintei> 申請一覧情報ArrayList,
            ArrayList<FutanGendogakuNinteiViewState> new申請情報List,
            HihokenshaNo 被保険者番号) {
        FutanGendogakuNinteiManager ninteiManager = FutanGendogakuNinteiManager.createInstance();
        for (FutanGendogakuNintei futanGendogakuNintei : 申請一覧情報ArrayList) {
            futanGendogakuNintei = futanGendogakuNintei.deleted();
            FutanGendogakuNinteiBuilder builder = futanGendogakuNintei.createBuilderForEdit();
            if (!futanGendogakuNintei.getGemmenGengakuShinseiList().isEmpty()) {
                GemmenGengakuShinsei gemmenGengakuShinsei = futanGendogakuNintei.getGemmenGengakuShinsei(
                        new GemmenGengakuShinseiIdentifier(futanGendogakuNintei.identifier().get証記載保険者番号(),
                                futanGendogakuNintei.identifier().get被保険者番号(),
                                GemmenGengakuShurui.負担限度額認定.getコード(),
                                futanGendogakuNintei.identifier().get履歴番号()));
                gemmenGengakuShinsei = gemmenGengakuShinsei.deleted();
                builder.setGemmenGengakuShinsei(gemmenGengakuShinsei);
            }
            ninteiManager.saveOrDeletePhysicalBy(builder.build());
        }
        ArrayList<FutanGendogakuNinteiViewState> new申請一覧情報ArrayList = new申請情報List;
        for (FutanGendogakuNinteiViewState ninteiViewState : new申請一覧情報ArrayList) {
            if (EntityDataState.Deleted.equals(ninteiViewState.getState())) {
                continue;
            }

            FutanGendogakuNintei futanGendogakuNintei = ninteiViewState.getFutanGendogakuNintei();
            futanGendogakuNintei = futanGendogakuNintei.added();
            FutanGendogakuNinteiBuilder builder = futanGendogakuNintei.createBuilderForEdit();
            if (!futanGendogakuNintei.getGemmenGengakuShinseiList().isEmpty()) {
                GemmenGengakuShinsei gemmenGengakuShinsei = futanGendogakuNintei.getGemmenGengakuShinsei(
                        new GemmenGengakuShinseiIdentifier(
                                futanGendogakuNintei.get証記載保険者番号(),
                                futanGendogakuNintei.get被保険者番号(),
                                GemmenGengakuShurui.負担限度額認定.getコード(),
                                futanGendogakuNintei.get履歴番号()));

                gemmenGengakuShinsei = gemmenGengakuShinsei.added();
                builder.setGemmenGengakuShinsei(gemmenGengakuShinsei);
            }

            futanGendogakuNintei = builder.build();
            ninteiManager.saveOrDeletePhysicalBy(futanGendogakuNintei);
        }
        this.delete利用者負担額減額by被保険者番号(被保険者番号);
    }
}
