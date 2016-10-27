/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.shotokushokaihyohakko.SaiHakkoParameter;
import jp.co.ndensan.reams.db.dbb.definition.core.shotokushokaihyo.SaihaqkouTaishoupParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.shotokushokaihyohakko.ShotokuShokaihyoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.SaihaqkouTaishouTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再発行対象者Tempテーブルに登録のクラスです。
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
public class InsReHakouTaisyoshaTmpProcess extends BatchProcessBase<SaihaqkouTaishouTempEntity> {

    private static final RString SELECTPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db"
            + ".mapper.relate.shotokushokaihyo.IShotokushokaihyoMapper.select再発行対象者");

    private static final RString 再発行対象者TEMP = new RString("SaihaqkouTaishouTemp");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter 再発行対象者writer;
    private ShotokuShokaihyoHakkoProcessParameter processParameter;
    private SaihaqkouTaishoupParameter myBatisParameter;

    @Override
    protected IBatchReader createReader() {
        myBatisParameter = creatParameter();
        return new BatchDbReader(SELECTPATH, myBatisParameter);
    }

    @Override
    protected void createWriter() {
        再発行対象者writer = new BatchEntityCreatedTempTableWriter(再発行対象者TEMP, SaihaqkouTaishouTempEntity.class);
    }

    @Override
    protected void process(SaihaqkouTaishouTempEntity t) {
        再発行対象者writer.insert(t);
    }

    private SaihaqkouTaishoupParameter creatParameter() {
        SaihaqkouTaishoupParameter param = new SaihaqkouTaishoupParameter();
        param.set処理年度(processParameter.get処理年度());
        List<YMDHMS> 作成日時List = new ArrayList<>();
        List<RString> 発行ユーザーIDList = new ArrayList<>();
        List<SaiHakkoParameter> 再発行対象リスト = processParameter.get再発行対象リスト();
        for (SaiHakkoParameter entity : 再発行対象リスト) {
            作成日時List.add(entity.get処理日時());
            発行ユーザーIDList.add(entity.getユーザ());
        }
        param.set作成日時List(作成日時List);
        param.set発行ユーザーIDList(発行ユーザーIDList);
        return param;
    }

}
