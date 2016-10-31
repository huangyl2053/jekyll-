/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB013001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb013001.TokuchoHeinjunka8GatsuProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka6gatsu.FukaJohoTmpEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka8gatsu.InsFukaErrorTbl1TmpEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 賦課エラー一覧へ登録する。
 *
 * @reamsid_L DBB-0860-030 yebangqiang
 */
public class InsFukaErrorTbl1Process extends BatchProcessBase<FukaJohoTmpEntity> {

    private static final RString ERRORCODE_01 = new RString("01");
    private static final RString 賦課エラー一覧 = new RString("InsFukaErrorTbl1Temp");
    private static final RString 内部帳票ID = new RString("DBB400001_FukaErrorIchitan");
    private static final RString バッチID = new RString("DBB0130001");
    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate"
            + ".tokuchoheinjunka8gatsu.ITokuchoHeinjunka8GatsuBatchMapper.do賦課情報あり_賦課エラー一覧へ登録");
    private TokuchoHeinjunka8GatsuProcessParameter parameter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 賦課の情報一時tableWriter;

    @Override
    protected void createWriter() {
        賦課の情報一時tableWriter = new BatchEntityCreatedTempTableWriter(賦課エラー一覧,
                InsFukaErrorTbl1TmpEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void process(FukaJohoTmpEntity fukaJohoResult) {
        FukaJohoTmpEntity 賦課の情報 = fukaJohoResult;
        InsFukaErrorTbl1TmpEntity insFukaErrorTbl1TmpEntity = new InsFukaErrorTbl1TmpEntity();
        insFukaErrorTbl1TmpEntity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
        insFukaErrorTbl1TmpEntity.setNaibuChouhouID(内部帳票ID);
        insFukaErrorTbl1TmpEntity.setNaibuChouhouSakuseiTime(parameter.get調定日時());
        insFukaErrorTbl1TmpEntity.setFukaNendo(parameter.get賦課年度());
        insFukaErrorTbl1TmpEntity.setTsuchishoNo(賦課の情報.getTsuchishoNo());
        insFukaErrorTbl1TmpEntity.setBatchID(バッチID);
        insFukaErrorTbl1TmpEntity.setBatchKidouTime(parameter.get調定日時().getRDateTime());
        insFukaErrorTbl1TmpEntity.setErrorCode(ERRORCODE_01);
        insFukaErrorTbl1TmpEntity.setHihokenshaNo(賦課の情報.getHihokenshaNo());
        insFukaErrorTbl1TmpEntity.setShikibetsuCode(賦課の情報.getShikibetsuCode());
        insFukaErrorTbl1TmpEntity.setShikakuShutokuYMD(賦課の情報.getShikakuShutokuYMD());
        insFukaErrorTbl1TmpEntity.setShikakuShutokuJiyuCode(賦課の情報.getShikakuShutokuJiyu());
        insFukaErrorTbl1TmpEntity.setShikakuSoshitsuYMD(賦課の情報.getShikakuSoshitsuYMD());
        insFukaErrorTbl1TmpEntity.setShikakuSoshitsuJiyuCode(賦課の情報.getShikakuSoshitsuJiyu());
        賦課の情報一時tableWriter.insert(insFukaErrorTbl1TmpEntity);
    }
}
