/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.HanteiKekkaCode;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikekkatoroku.ShinsakaiKekkaTorokuDeletionCandidateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 *
 */
public class ShinsakaiKekkaTorokuDeletionCandidate {

    private final ShinsakaiKekkaTorokuDeletionCandidateEntity entity;

    /**
     *
     * @param entity
     */
    public ShinsakaiKekkaTorokuDeletionCandidate(ShinsakaiKekkaTorokuDeletionCandidateEntity entity) {
        this.entity = entity;
    }

    /**
     *
     * @param hanteiKekka
     * @return
     */
    public ShinsakaiKekkaTorokuDeletionCandidate deletedBy(HanteiKekkaCode hanteiKekka) {
        ShinsakaiKekkaTorokuDeletionCandidateEntity e
                = new ShinsakaiKekkaTorokuDeletionCandidateEntity();
        e.setShinseishoKanriNo(this.entity.getShinseishoKanriNo());
        if (hanteiKekka == HanteiKekkaCode.再調査_意見書のみ || hanteiKekka == HanteiKekkaCode.再調査_調査_意見書) {
            DbT5201NinteichosaIraiJohoEntity chosa = this.entity.getChosaIraiEntity();
            e.setChosaIrai(deletedIfNonnull(chosa));
        }
        if (hanteiKekka == HanteiKekkaCode.再調査_調査のみ || hanteiKekka == HanteiKekkaCode.再調査_調査_意見書) {
            DbT5301ShujiiIkenshoIraiJohoEntity iken = this.entity.getIkenshoIraiEntity();
            e.setIkenshoIrai(deletedIfNonnull(iken));
        }
        DbT5116IchijiHanteiKekkaJohoEntity ichiji = this.entity.getIchijiHanteiEntity();
        e.setIchijiHantei(deletedIfNonnull(ichiji));
        return new ShinsakaiKekkaTorokuDeletionCandidate(entity);
    }

    private static <T extends DbTableEntityBase> List<T> deletedIfNonnull(T t) {
        if (t == null) {
            return Collections.<T>emptyList();
        }
        t.setState(EntityDataState.Deleted);
        return Collections.<T>singletonList(t);
    }

    /**
     *
     * @return
     */
    public ShinsakaiKekkaTorokuDeletionCandidateEntity toEntity() {
        return this.entity;
    }
}
