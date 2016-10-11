/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD519001;

import jp.co.ndensan.reams.db.dbd.business.core.dbd519001.ModifyNinteiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd519001.ModifyNinteiShinseiJohoProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519001.ModifyNinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519001.temp.KouikiyoukaigoNinteishinseiJouhouTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請情報IF編集_process処理クラスです。
 *
 * @reamsid_L DBD-1480-020 liuyl
 */
public class ModifyNinteiShinseiJohoProcess extends BatchProcessBase<ModifyNinteiShinseiJohoEntity> {

    private static final RString MYBATIS_MAPPER_ID3 = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper."
            + "relate.ninteishinseiinfoif.IModifyNinteiShinseiJohoMapper.select申請情報IF電算標準版");
    private static final RString MYBATIS_MAPPER_ID4 = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper."
            + "relate.ninteishinseiinfoif.IModifyNinteiShinseiJohoMapper.select申請情報IF厚労省版");
    private ModifyNinteiShinseiJohoProcessParameter parameter;
    private RString 編集状況フラグ = new RString("0");
    /**
     * Out_編集状況フラグ
     */
    public static final RString OUT編集状況フラグ;
    private OutputParameter<RString> out編集状況フラグ;
    private long i = 1;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tableWriter;

    static {
        OUT編集状況フラグ = new RString("out編集状況フラグ");
    }

    @Override
    protected void beforeExecute() {
        out編集状況フラグ = new OutputParameter<>();
    }

    @Override
    protected IBatchReader createReader() {
        if (parameter.get認定申請IF種類().equals(new RString("3")) || parameter.get認定申請IF種類().equals(new RString("5"))) {
            return new BatchDbReader(MYBATIS_MAPPER_ID3, parameter.toModifyNinteiShinseiJohoMybatisParameter());
        } else {
            return new BatchDbReader(MYBATIS_MAPPER_ID4, parameter.toModifyNinteiShinseiJohoMybatisParameter());
        }
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchEntityCreatedTempTableWriter(KouikiyoukaigoNinteishinseiJouhouTempEntity.TABLE_NAME,
                KouikiyoukaigoNinteishinseiJouhouTempEntity.class);
    }

    @Override
    protected void process(ModifyNinteiShinseiJohoEntity entity) {
        KouikiyoukaigoNinteishinseiJouhouTempEntity tempEntity = new KouikiyoukaigoNinteishinseiJouhouTempEntity();
        ModifyNinteiShinseiJohoManager manager = new ModifyNinteiShinseiJohoManager();
        編集状況フラグ = manager.申請情報IF編集(entity, i, parameter.get認定申請IF種類(), parameter.get市町村コード(), tempEntity);
        tableWriter.insert(tempEntity);
        i++;
    }

    @Override
    protected void afterExecute() {
        out編集状況フラグ.setValue(編集状況フラグ);
    }
}
