/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB012001;

import jp.co.ndensan.reams.db.dbb.definition.core.choteijiyu.ChoteiJiyuCode;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaTempEntity;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt35001.TokuchoHeinjunka6GatsuProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchFukaJohoResult;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka6gatsu.FukaJohoTmpEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 賦課の情報一時テーブルに賦課情報を登録クラスです。
 *
 * @reamsid_L DBB-0810-010 yebangqiang
 */
public class InsFukaTmpProcess extends BatchProcessBase<TokuchoHeijunkaRokuBatchFukaJohoResult> {

    private static final RString 賦課の情報一時テーブル = new RString("DbT2002FukaJohoTemp");
    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate"
            + ".tokuchoheinjunka6gatsu.ITokuchoHeinjunka6GatsuBatchMapper.get賦課の情報");
    private static final int NUM_1 = 1;
    private TokuchoHeinjunka6GatsuProcessParameter parameter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 賦課の情報一時tableWriter;

    @Override
    protected void createWriter() {
        賦課の情報一時tableWriter = new BatchEntityCreatedTempTableWriter(賦課の情報一時テーブル,
                FukaJohoTmpEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void process(TokuchoHeijunkaRokuBatchFukaJohoResult fukaJohoResult) {
        FukaJohoTmpEntity 賦課の情報 = fukaJohoResult.get賦課の情報();
        TokuchoHeijunkaRokuBatchHeijunkaKeisanKekaTempEntity 平準化計算結果 = fukaJohoResult.get平準化計算結果();
        賦課の情報.setRirekiNo(賦課の情報.getRirekiNo() + NUM_1);
        賦課の情報.setChoteiNichiji(parameter.get調定日時());
        賦課の情報.setIdoKijunNichiji(parameter.get調定日時());
        賦課の情報.setChoteiJiyu1(ChoteiJiyuCode.平準化による変更6月.getコード());
        賦課の情報.setChoteiJiyu2(RString.EMPTY);
        賦課の情報.setChoteiJiyu3(RString.EMPTY);
        賦課の情報.setChoteiJiyu4(RString.EMPTY);
        賦課の情報.setTkKibetsuGaku01(平準化計算結果.get変更後特徴期別額_１期());
        賦課の情報.setTkKibetsuGaku02(平準化計算結果.get変更後特徴期別額_２期());
        賦課の情報.setTkKibetsuGaku03(平準化計算結果.get変更後特徴期別額_３期());
        賦課の情報一時tableWriter.insert(賦課の情報);
    }
}
