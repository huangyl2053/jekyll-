/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb012001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.dbbbt35001.TokuchoHeinjunka6GatsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt35001.TokuchoHeinjunka6GatsuProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka6gatsu.FukaJohoTmpEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴平準化（特徴6月分）バッチ平準化前賦課Temp出力クラスです。
 *
 * @reamsid_L DBB-0810-010 yebangqiang
 */
public class InsHeinjunkaFukaTmpProcess extends BatchProcessBase<FukaJohoTmpEntity> {

    private static final RString 平準化前賦課TEMP_TABLE_NAME = new RString("TmpHeijunkaMae");
    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate"
            + ".tokuchoheinjunka6gatsu.ITokuchoHeinjunka6GatsuBatchMapper.get平準化前賦課Temp");
    private static final RString 徴収方法_普通 = new RString("2");
    private static final RString 徴収方法_特別 = new RString("1");
    private static final int 期_01 = 1;
    private static final int 期_02 = 2;
    private static final int 期_03 = 3;
    private static final int 期_04 = 4;
    private static final int 期_05 = 5;
    private static final int 期_06 = 6;
    private static final int 期_07 = 7;
    private static final int 期_08 = 8;
    private static final int 期_09 = 9;
    private static final int 期_10 = 10;
    private static final int 期_11 = 11;
    private static final int 期_12 = 12;
    private static final int 期_13 = 13;
    private static final int 期_14 = 14;
    private TokuchoHeinjunka6GatsuProcessParameter parameter;
    private TsuchishoNo tsuchishoNo;
    private FukaJohoTmpEntity fukaTmpEntity;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 仮算定一括発行一時tableWriter;

    @Override
    protected void createWriter() {
        仮算定一括発行一時tableWriter = new BatchEntityCreatedTempTableWriter(平準化前賦課TEMP_TABLE_NAME,
                FukaJohoTmpEntity.class, true);
    }

    @Override
    protected IBatchReader createReader() {
        TokuchoHeinjunka6GatsuMyBatisParameter myBatisParameter = new TokuchoHeinjunka6GatsuMyBatisParameter();
        myBatisParameter.set調定年度(parameter.get調定年度());
        myBatisParameter.set賦課年度(parameter.get賦課年度());
        return new BatchDbReader(MAPPERPATH, myBatisParameter);
    }

    @Override
    protected void process(FukaJohoTmpEntity fukaTmpEntity) {
        if (tsuchishoNo == null) {
            tsuchishoNo = fukaTmpEntity.getTsuchishoNo();
            this.fukaTmpEntity = fukaTmpEntity;
            仮算定一括発行一時tableWriter.insert(this.fukaTmpEntity);
        }
        if (tsuchishoNo.equals(fukaTmpEntity.getTsuchishoNo())) {
            if (徴収方法_特別.equals(fukaTmpEntity.getChoshuHouhou())) {
                特別徴収金額設定(this.fukaTmpEntity, fukaTmpEntity.getKi());
            } else if (徴収方法_普通.equals(fukaTmpEntity.getChoshuHouhou())) {
                普通徴収金額設定(this.fukaTmpEntity, fukaTmpEntity.getKi());
            }
        } else {
            仮算定一括発行一時tableWriter.update(this.fukaTmpEntity);
            tsuchishoNo = fukaTmpEntity.getTsuchishoNo();
            this.fukaTmpEntity = fukaTmpEntity;
        }
    }

    private void 普通徴収金額設定(FukaJohoTmpEntity fukaTmpEntity, int ki) {
        switch (ki) {
            case 期_01:
                fukaTmpEntity.setFuKibetsuGaku01(fukaTmpEntity.getChoteigaku());
                break;
            case 期_02:
                fukaTmpEntity.setFuKibetsuGaku02(fukaTmpEntity.getChoteigaku());
                break;
            case 期_03:
                fukaTmpEntity.setFuKibetsuGaku03(fukaTmpEntity.getChoteigaku());
                break;
            case 期_04:
                fukaTmpEntity.setFuKibetsuGaku04(fukaTmpEntity.getChoteigaku());
                break;
            case 期_05:
                fukaTmpEntity.setFuKibetsuGaku05(fukaTmpEntity.getChoteigaku());
                break;
            case 期_06:
                fukaTmpEntity.setFuKibetsuGaku06(fukaTmpEntity.getChoteigaku());
                break;
            case 期_07:
                fukaTmpEntity.setFuKibetsuGaku07(fukaTmpEntity.getChoteigaku());
                break;
            case 期_08:
                fukaTmpEntity.setFuKibetsuGaku08(fukaTmpEntity.getChoteigaku());
                break;
            case 期_09:
                fukaTmpEntity.setFuKibetsuGaku09(fukaTmpEntity.getChoteigaku());
                break;
            case 期_10:
                fukaTmpEntity.setFuKibetsuGaku10(fukaTmpEntity.getChoteigaku());
                break;
            case 期_11:
                fukaTmpEntity.setFuKibetsuGaku11(fukaTmpEntity.getChoteigaku());
                break;
            case 期_12:
                fukaTmpEntity.setFuKibetsuGaku12(fukaTmpEntity.getChoteigaku());
                break;
            case 期_13:
                fukaTmpEntity.setFuKibetsuGaku13(fukaTmpEntity.getChoteigaku());
                break;
            case 期_14:
                fukaTmpEntity.setFuKibetsuGaku14(fukaTmpEntity.getChoteigaku());
                break;
            default:
                break;
        }
    }

    private void 特別徴収金額設定(FukaJohoTmpEntity fukaTmpEntity, int ki) {
        switch (ki) {
            case 期_01:
                fukaTmpEntity.setTkKibetsuGaku01(fukaTmpEntity.getChoteigaku());
                break;
            case 期_02:
                fukaTmpEntity.setTkKibetsuGaku02(fukaTmpEntity.getChoteigaku());
                break;
            case 期_03:
                fukaTmpEntity.setTkKibetsuGaku03(fukaTmpEntity.getChoteigaku());
                break;
            case 期_04:
                fukaTmpEntity.setTkKibetsuGaku04(fukaTmpEntity.getChoteigaku());
                break;
            case 期_05:
                fukaTmpEntity.setTkKibetsuGaku05(fukaTmpEntity.getChoteigaku());
                break;
            case 期_06:
                fukaTmpEntity.setTkKibetsuGaku06(fukaTmpEntity.getChoteigaku());
                break;
            default:
                break;
        }
    }

}
