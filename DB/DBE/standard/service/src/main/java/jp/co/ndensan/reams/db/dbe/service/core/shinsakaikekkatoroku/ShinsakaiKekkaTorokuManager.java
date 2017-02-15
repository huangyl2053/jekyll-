package jp.co.ndensan.reams.db.dbe.service.core.shinsakaikekkatoroku;

import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiWariateJoho;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5502ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5102NinteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5105NinteiKanryoJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5502ShinsakaiWariateJohoDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * {@link IShinsakakKekksaTorokuManager}の実装です。
 */
class ShinsakaiKekkaTorokuManager implements IShinsakakKekksaTorokuManager {

    private final DbT5502ShinsakaiWariateJohoDac dbT5502Dac;
    private final DbT5101NinteiShinseiJohoDac dbT5101Dac;
    private final DbT5102NinteiKekkaJohoDac dbT5102Dac;
    private final DbT5105NinteiKanryoJohoDac dbT5105Dac;

    ShinsakaiKekkaTorokuManager() {
        this.dbT5502Dac = InstanceProvider.create(DbT5502ShinsakaiWariateJohoDac.class);
        this.dbT5101Dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
        this.dbT5102Dac = InstanceProvider.create(DbT5102NinteiKekkaJohoDac.class);
        this.dbT5105Dac = InstanceProvider.create(DbT5105NinteiKanryoJohoDac.class);
    }

    static ShinsakaiKekkaTorokuManager createInstance() {
        return InstanceProvider.create(ShinsakaiKekkaTorokuManager.class);
    }

    @Override
    public int save要介護認定結果情報(NinteiKekkaJoho ninteiKekka) {
        return dbT5102Dac.save(ninteiKekka.toEntity());
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
}
