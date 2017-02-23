/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.HanteiKekkaCode;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikekkatoroku.ShinsakaiKekkaTorokuDeletionCandidateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 審査会結果登録する処理で判定結果によっては削除される情報を保持します。
 */
public class ShinsakaiKekkaTorokuDeletionCandidate implements Serializable {

    private final ShinsakaiKekkaTorokuDeletionCandidateEntity entity;

    /**
     * @param entity {@link ShinsakaiKekkaTorokuDeletionCandidateEntity}
     */
    public ShinsakaiKekkaTorokuDeletionCandidate(ShinsakaiKekkaTorokuDeletionCandidateEntity entity) {
        this.entity = entity;
    }

    /**
     * @return {@link ShinsakaiKekkaTorokuDeletionCandidateEntity}
     */
    public ShinsakaiKekkaTorokuDeletionCandidateEntity toEntity() {
        return this.entity;
    }

    /**
     * @param hanteiKekka 判定結果区分
     * @return 判定結果により、削除する情報を更新した新しいインスタンス
     */
    public ShinsakaiKekkaTorokuDeletionCandidate deletedBy(HanteiKekkaCode hanteiKekka) {
        ShinsakaiKekkaTorokuDeletionCandidateEntity e
                = new ShinsakaiKekkaTorokuDeletionCandidateEntity();
        e.shallowCopy(this.entity);
        e.setChosaIrai(asDeletedIfTimely(this.entity.getChosaIraiEntity(), hanteiKekka));
        e.setIkenshoIrai(asDeletedIfTimely(this.entity.getIkenshoIraiEntity(), hanteiKekka));
        e.setIchijiHantei(asDeletedIfTimely(this.entity.getIchijiHanteiEntity(), hanteiKekka));
        return new ShinsakaiKekkaTorokuDeletionCandidate(e);
    }

    private static List<DbT5201NinteichosaIraiJohoEntity> asDeletedIfTimely(DbT5201NinteichosaIraiJohoEntity chosa, HanteiKekkaCode hanteiKekka) {
        if (chosa == null) {
            return Collections.emptyList();
        }
        if (hanteiKekka == HanteiKekkaCode.再調査_調査のみ
                || hanteiKekka == HanteiKekkaCode.再調査_調査_意見書) {
            DbT5201NinteichosaIraiJohoEntity ne = chosa.clone();
            ne.setLogicalDeletedFlag(true);
            return Collections.singletonList(ne);
        } else {
            return Collections.singletonList(chosa);
        }
    }

    private static List<DbT5301ShujiiIkenshoIraiJohoEntity> asDeletedIfTimely(DbT5301ShujiiIkenshoIraiJohoEntity iken, HanteiKekkaCode hanteiKekka) {
        if (iken == null) {
            return Collections.emptyList();
        }
        if (hanteiKekka == HanteiKekkaCode.再調査_意見書のみ
                || hanteiKekka == HanteiKekkaCode.再調査_調査_意見書) {
            DbT5301ShujiiIkenshoIraiJohoEntity ne = iken.clone();
            ne.setLogicalDeletedFlag(true);
            return Collections.singletonList(ne);
        } else {
            return Collections.singletonList(iken);
        }
    }

    private static List<DbT5116IchijiHanteiKekkaJohoEntity> asDeletedIfTimely(DbT5116IchijiHanteiKekkaJohoEntity ichiji, HanteiKekkaCode hanteiKekka) {
        if (ichiji == null) {
            return Collections.emptyList();
        }
        if (hanteiKekka == HanteiKekkaCode.再調査_調査のみ
                || hanteiKekka == HanteiKekkaCode.再調査_意見書のみ
                || hanteiKekka == HanteiKekkaCode.再調査_調査_意見書) {
            DbT5116IchijiHanteiKekkaJohoEntity ne = ichiji.clone();
            ne.setState(EntityDataState.Deleted);
            return Collections.singletonList(ne);
        } else {
            return Collections.singletonList(ichiji);
        }
    }
}
