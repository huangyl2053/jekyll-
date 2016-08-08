/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.hoshumasutakoshin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiChosaHoshuTanka;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiIinBetsuTanka;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiIinHoshuTanka;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShujiiIkenshoHoshuTanka;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5031NinteiChosaHoshuTankaEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5032ShujiiIkenshoHoshuTankaEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5033ShinsakaiIinHoshuTankaEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5034ShinsakaiIinBetsuTankaEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5031NinteiChosaHoshuTankaDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5032ShujiiIkenshoHoshuTankaDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5033ShinsakaiIinHoshuTankaDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5034ShinsakaiIinBetsuTankaDac;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 報酬マスタメンテナンス画面を管理するクラスです。
 *
 * @reamsid_L DBE-1710-010 dingyi
 */
public class HoshuMasutaKoshinManager {

    private final DbT5031NinteiChosaHoshuTankaDac dbT5031Dac;
    private final DbT5032ShujiiIkenshoHoshuTankaDac dbT5032Dac;
    private final DbT5033ShinsakaiIinHoshuTankaDac dbT5033Dac;
    private final DbT5034ShinsakaiIinBetsuTankaDac dbT5034Dac;

    /**
     * コンストラクタです。
     */
    public HoshuMasutaKoshinManager() {
        dbT5031Dac = InstanceProvider.create(DbT5031NinteiChosaHoshuTankaDac.class);
        dbT5032Dac = InstanceProvider.create(DbT5032ShujiiIkenshoHoshuTankaDac.class);
        dbT5033Dac = InstanceProvider.create(DbT5033ShinsakaiIinHoshuTankaDac.class);
        dbT5034Dac = InstanceProvider.create(DbT5034ShinsakaiIinBetsuTankaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5031NinteiChosaHoshuTankaDac}
     * @param dac {@link DbT5032ShujiiIkenshoHoshuTankaDac}
     * @param dac {@link DbT5033ShinsakaiIinHoshuTankaDac}
     * @param dac {@link DbT5034ShinsakaiIinBetsuTankaDac}
     */
    HoshuMasutaKoshinManager(DbT5031NinteiChosaHoshuTankaDac dbT5031Dac,
            DbT5032ShujiiIkenshoHoshuTankaDac dbT5032Dac, DbT5033ShinsakaiIinHoshuTankaDac dbT5033Dac,
            DbT5034ShinsakaiIinBetsuTankaDac dbT5034Dac) {
        this.dbT5031Dac = dbT5031Dac;
        this.dbT5032Dac = dbT5032Dac;
        this.dbT5033Dac = dbT5033Dac;
        this.dbT5034Dac = dbT5034Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HoshuMasutaKoshinManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link HoshuMasutaKoshinManager}のインスタンス
     */
    public static HoshuMasutaKoshinManager createInstance() {
        return InstanceProvider.create(HoshuMasutaKoshinManager.class);
    }

    /**
     * 審査員報酬単価マスタ情報の取得します。
     *
     * @return 審査員報酬単価マスタ情報
     */
    @Transaction
    public SearchResult<ShinsakaiIinHoshuTanka> get審査員報酬単価マスタ情報() {
        List<ShinsakaiIinHoshuTanka> list = new ArrayList<>();
        List<DbT5033ShinsakaiIinHoshuTankaEntity> entityList = dbT5033Dac.selectAllOrderBy();
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<ShinsakaiIinHoshuTanka>emptyList(), 0, false);
        }
        for (DbT5033ShinsakaiIinHoshuTankaEntity entity : entityList) {
            list.add(new ShinsakaiIinHoshuTanka(entity));
        }
        return SearchResult.of(list, 0, false);
    }

    /**
     * 意見書報酬単価マスタ情報の取得します。
     *
     * @return 意見書報酬単価マスタ情報
     */
    @Transaction
    public SearchResult<ShujiiIkenshoHoshuTanka> get意見書報酬単価マスタ情報() {
        List<ShujiiIkenshoHoshuTanka> list = new ArrayList<>();
        List<DbT5032ShujiiIkenshoHoshuTankaEntity> entityList = dbT5032Dac.selectAllOrderBy();
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<ShujiiIkenshoHoshuTanka>emptyList(), 0, false);
        }
        for (DbT5032ShujiiIkenshoHoshuTankaEntity entity : entityList) {
            list.add(new ShujiiIkenshoHoshuTanka(entity));
        }
        return SearchResult.of(list, 0, false);
    }

    /**
     * 認定調査報酬単価マスタ情報の取得します。
     *
     * @return 認定調査報酬単価マスタ情報
     */
    @Transaction
    public SearchResult<NinteiChosaHoshuTanka> get認定調査報酬単価マスタ情報() {
        List<NinteiChosaHoshuTanka> list = new ArrayList<>();
        List<DbT5031NinteiChosaHoshuTankaEntity> entityList = dbT5031Dac.selectAllOrderBy();
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<NinteiChosaHoshuTanka>emptyList(), 0, false);
        }
        for (DbT5031NinteiChosaHoshuTankaEntity entity : entityList) {
            list.add(new NinteiChosaHoshuTanka(entity));
        }
        return SearchResult.of(list, 0, false);
    }

    /**
     * 審査会委員別単価マスタ情報の取得します。
     *
     * @return 審査会委員別単価マスタ情報
     */
    @Transaction
    public SearchResult<ShinsakaiIinBetsuTanka> get審査会委員別単価マスタ情報() {
        List<ShinsakaiIinBetsuTanka> list = new ArrayList<>();
        List<DbT5034ShinsakaiIinBetsuTankaEntity> entityList = dbT5034Dac.selectAllOrderBy();
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<ShinsakaiIinBetsuTanka>emptyList(), 0, false);
        }
        for (DbT5034ShinsakaiIinBetsuTankaEntity entity : entityList) {
            list.add(new ShinsakaiIinBetsuTanka(entity));
        }
        return SearchResult.of(list, 0, false);
    }

    /**
     * 入力データをＤＢに更新します。
     *
     * @param 審査員報酬単価マスタ更新情報 審査員報酬単価マスタ更新情報
     * @param 意見書報酬単価マスタ更新情報 意見書報酬単価マスタ更新情報
     * @param 認定調査報酬単価マスタ更新情報 認定調査報酬単価マスタ更新情報
     * @param 審査会委員別単価マスタ更新情報 審査会委員別単価マスタ更新情報
     */
    @Transaction
    public void updateマスタ情報(List<ShinsakaiIinHoshuTanka> 審査員報酬単価マスタ更新情報,
            List<ShujiiIkenshoHoshuTanka> 意見書報酬単価マスタ更新情報,
            List<NinteiChosaHoshuTanka> 認定調査報酬単価マスタ更新情報,
            List<ShinsakaiIinBetsuTanka> 審査会委員別単価マスタ更新情報) {
        for (ShinsakaiIinHoshuTanka 審査員報酬単価マスタ : 審査員報酬単価マスタ更新情報) {
            DbT5033ShinsakaiIinHoshuTankaEntity entity = 審査員報酬単価マスタ.toEntity();
            if (EntityDataState.Deleted.equals(entity.getState())) {
                dbT5033Dac.saveByForDeletePhysical(entity);
            } else {
                dbT5033Dac.save(entity);
            }
        }
        for (ShujiiIkenshoHoshuTanka 意見書報酬単価マスタ : 意見書報酬単価マスタ更新情報) {
            DbT5032ShujiiIkenshoHoshuTankaEntity entity = 意見書報酬単価マスタ.toEntity();
            if (EntityDataState.Deleted.equals(entity.getState())) {
                dbT5032Dac.saveOrDeletePhysicalBy(entity);
            } else {
                dbT5032Dac.save(entity);
            }
        }
        for (NinteiChosaHoshuTanka 認定調査報酬単価マスタ : 認定調査報酬単価マスタ更新情報) {
            DbT5031NinteiChosaHoshuTankaEntity entity = 認定調査報酬単価マスタ.toEntity();
            if (EntityDataState.Deleted.equals(entity.getState())) {
                dbT5031Dac.saveOrDeletePhysicalBy(entity);
            } else {
                dbT5031Dac.save(entity);
            }
        }
        for (ShinsakaiIinBetsuTanka 審査会委員別単価マスタ : 審査会委員別単価マスタ更新情報) {
            DbT5034ShinsakaiIinBetsuTankaEntity entity = 審査会委員別単価マスタ.toEntity();
            if (EntityDataState.Deleted.equals(entity.getState())) {
                dbT5034Dac.saveOrDeletePhysicalBy(entity);
            } else {
                dbT5034Dac.save(entity);
            }
        }
    }

}
