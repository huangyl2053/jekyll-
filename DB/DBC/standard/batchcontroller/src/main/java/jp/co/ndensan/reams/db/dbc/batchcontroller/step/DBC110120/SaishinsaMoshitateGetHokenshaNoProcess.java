/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110120;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.DbWT1741SaishinsaMoshitateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護給付費再審査申立書情報作成・保険者番号取得を実行する。
 *
 * @reamsid_L DBC-2540-030 liuhui
 */
public class SaishinsaMoshitateGetHokenshaNoProcess extends BatchProcessBase<DbWT1741SaishinsaMoshitateEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "saishinsamoshitateshoout.ISaishinsaMoshitateshoOutJohoMapper.select保険者番号取得関連リスト");
    private List<RString> hokenshaNoList;
    /**
     * エントリ情報Listです。
     */
    public static final RString PARAMETER_OUT_OUTPUTENTRY;

    static {
        PARAMETER_OUT_OUTPUTENTRY = new RString("outputEntry");
    }
    private OutputParameter<List> outputEntry;

    @Override
    protected void initialize() {
        outputEntry = new OutputParameter<>();
        hokenshaNoList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void process(DbWT1741SaishinsaMoshitateEntity entity) {
        hokenshaNoList.add(entity.getHokenshaNo().getColumnValue());
    }

    @Override
    protected void afterExecute() {
        outputEntry.setValue(hokenshaNoList);
    }
}
