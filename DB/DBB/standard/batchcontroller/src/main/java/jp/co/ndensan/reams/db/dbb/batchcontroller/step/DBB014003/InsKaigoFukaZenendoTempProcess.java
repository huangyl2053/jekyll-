/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB014003;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuchokaritsuchishoikkatsuhakko.FuchIdoIchijiParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb014003.FuchoKarisanteiTsuchishoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokaritsuchishoikkatsuhakko.FukaJohoZenendoTmpEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 普徴仮算定の更新後データを抽出するクラスです。
 *
 * @reamsid_L DBB-0710-030 yebangqiang
 */
public class InsKaigoFukaZenendoTempProcess extends BatchProcessBase<FukaJohoZenendoTmpEntity> {

    private static final RString 異動賦課情報一時テーブル = new RString("TempKaigoFukaZennendo");
    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "fuchokaritsuchishoikkatsuhakko.IFuchoKarisanteiTsuchishoHakkoMapper.select前年度全ての賦課情報");
    private FuchoKarisanteiTsuchishoHakkoProcessParameter processParameter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 異動賦課情報一時tableWriter;

    @Override
    protected void createWriter() {
        異動賦課情報一時tableWriter = new BatchEntityCreatedTempTableWriter(異動賦課情報一時テーブル,
                FukaJohoZenendoTmpEntity.class, true);
    }

    @Override
    protected IBatchReader createReader() {
        FuchIdoIchijiParameter myBatisParameter = new FuchIdoIchijiParameter();
        myBatisParameter.set調定前年度(processParameter.get調定年度().minusYear(1));
        return new BatchDbReader(MAPPERPATH, myBatisParameter);
    }

    @Override
    protected void process(FukaJohoZenendoTmpEntity fukaTmpEntity) {
        異動賦課情報一時tableWriter.insert(fukaTmpEntity);
    }

    @Override
    protected void afterExecute() {
    }

}
