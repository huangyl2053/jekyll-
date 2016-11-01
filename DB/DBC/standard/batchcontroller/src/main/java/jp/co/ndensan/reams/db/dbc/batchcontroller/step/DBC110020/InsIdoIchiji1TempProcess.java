/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110020;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.Ido1TmpEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * データレコード書込みクラスです。
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public class InsIdoIchiji1TempProcess extends BatchProcessBase<Ido1TmpEntity> {

    private static final RString MYBATIS_ID = new RString("");

    private Ido1TmpEntity before;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID);
    }

    @Override
    protected void createWriter() {
    }

    @Override
    protected void process(Ido1TmpEntity entity) {
        if (before == null) {
            before = entity;
        }
    }
}
