/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.dbe223001;

import jp.co.ndensan.reams.db.dbe.definition.processprm.dbe223001.NinteichosaIraiJohoUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosatokusokujohakko.NinteiChosaTokusokujoHakkoManager;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査依頼情報テーブルの更新処理のクラスです。
 *
 * @reamsid_L DBE-0030-040 xuyue
 */
public class NinteichosaIraiJohoUpdateProcess extends BatchProcessBase<DbT5201NinteichosaIraiJohoEntity> {

    private NinteichosaIraiJohoUpdateProcessParameter processParameter;
    private NinteiChosaTokusokujoHakkoManager manager;

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.dbe223001.IDbe223001RelateMapper.select認定調査依頼情報BY申請書管理番号");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toNinteiChosaTokusokujoMybatisParameter());
    }

    @Override
    protected void beforeExecute() {
        manager = NinteiChosaTokusokujoHakkoManager.createInstance();
    }

    @Override
    @Transaction
    protected void process(DbT5201NinteichosaIraiJohoEntity entity) {
        manager.update認定調査依頼情報(entity, processParameter);
    }

}
