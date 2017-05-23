package jp.co.ndensan.reams.db.dbe.service.core.shinsakaikekkatoroku;

import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiWariateJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuDeletionCandidate;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikekkatoroku.ShinsakaiKekkaTorokuDeletionCandidateEntity;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5102NinteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5105NinteiKanryoJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5116IchijiHanteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5201NinteichosaIraiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5301ShujiiIkenshoIraiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5502ShinsakaiWariateJohoDac;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * {@link IShinsakakKekksaTorokuManager}の実装です。
 */
class ShinsakaiKekkaTorokuManager implements IShinsakakKekksaTorokuManager {

    private final DbT5502ShinsakaiWariateJohoDac dbT5502Dac;
    private final DbT5101NinteiShinseiJohoDac dbT5101Dac;
    private final DbT5102NinteiKekkaJohoDac dbT5102Dac;
    private final DbT5105NinteiKanryoJohoDac dbT5105Dac;
    private final DbT5201NinteichosaIraiJohoDac dbT5201Dac;
    private final DbT5301ShujiiIkenshoIraiJohoDac dbT5301Dac;
    private final DbT5116IchijiHanteiKekkaJohoDac dbT5116Dac;

    ShinsakaiKekkaTorokuManager() {
        this.dbT5502Dac = InstanceProvider.create(DbT5502ShinsakaiWariateJohoDac.class);
        this.dbT5101Dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
        this.dbT5102Dac = InstanceProvider.create(DbT5102NinteiKekkaJohoDac.class);
        this.dbT5105Dac = InstanceProvider.create(DbT5105NinteiKanryoJohoDac.class);
        this.dbT5201Dac = InstanceProvider.create(DbT5201NinteichosaIraiJohoDac.class);
        this.dbT5301Dac = InstanceProvider.create(DbT5301ShujiiIkenshoIraiJohoDac.class);
        this.dbT5116Dac = InstanceProvider.create(DbT5116IchijiHanteiKekkaJohoDac.class);
    }

    static ShinsakaiKekkaTorokuManager createInstance() {
        return InstanceProvider.create(ShinsakaiKekkaTorokuManager.class);
    }

    @Override
    public int save要介護認定結果情報(NinteiKekkaJoho ninteiKekka) {
        return dbT5102Dac.saveOrDelete(ninteiKekka.toEntity());
    }

    @Override
    public int save介護認定審査会割当情報(ShinsakaiWariateJoho shinsakaiWariateJoho) {
        return dbT5502Dac.save(shinsakaiWariateJoho.toEntity());
    }

    @Override
    public int save要介護認定申請情報(NinteiShinseiJoho ninteiShinsei) {
        return dbT5101Dac.save(ninteiShinsei.toEntity());
    }

    @Override
    public int save要介護認定完了情報(NinteiKanryoJoho ninteiKanryo) {
        return dbT5105Dac.save(ninteiKanryo.toEntity());
    }

    @Override
    public void delete削除候補(ShinsakaiKekkaTorokuDeletionCandidate o) {
        ShinsakaiKekkaTorokuDeletionCandidateEntity e = o.toEntity();
        save一次判定結果情報(e.getIchijiHanteiEntity());
        save意見書依頼情報(e.getIkenshoIraiEntity());
        save調査依頼情報(e.getChosaIraiEntity());
    }

    private void save調査依頼情報(DbT5201NinteichosaIraiJohoEntity entity) {
        if (entity == null || entity.getState() == EntityDataState.Unchanged) {
            return;
        }
        dbT5201Dac.save(entity);
    }

    private void save意見書依頼情報(DbT5301ShujiiIkenshoIraiJohoEntity entity) {
        if (entity == null || entity.getState() == EntityDataState.Unchanged) {
            return;
        }
        dbT5301Dac.save(entity);
    }

    private void save一次判定結果情報(DbT5116IchijiHanteiKekkaJohoEntity entity) {
        if (entity == null || entity.getState() == EntityDataState.Unchanged) {
            return;
        }
        dbT5116Dac.saveOrDeletePhysical(entity);
    }
}
