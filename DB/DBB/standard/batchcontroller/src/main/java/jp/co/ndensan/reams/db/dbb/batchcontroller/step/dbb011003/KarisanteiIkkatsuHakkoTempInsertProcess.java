/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb011003;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteitsuchishohakko.TokuchoKaishiTsuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteitsuchishohakko.KarisanteiIkkatsuHakkoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteitsuchishohakko.TsuchishoDataTempEntity;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 仮算定一括発行一時テーブルに登録
 *
 * @reamsid_L DBB-0790-030 chenaoqi
 */
public class KarisanteiIkkatsuHakkoTempInsertProcess extends BatchProcessBase<TsuchishoDataTempEntity> {

    private TokuchoKaishiTsuchishoProcessParameter parameter;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 仮算定一括発行一時tableWriter;

    private static final RString 仮算定一括発行一時_TABLE_NAME = new RString("KarisanteiIkkatsuHakkoTemp");
    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate"
            + ".tokuchokarisanteitsuchishohakko.ITokuchoKarisanteiTsuchishoHakkoMapper.select仮算定一括発行一時のデータ");
    private static final RString LEFT_FORMAT = new RString("'{");
    private static final RString RIGHT_FORMAT = new RString("}'");
    private static final RString MIDDLE_FORMAT = new RString(",");

    @Override
    protected void createWriter() {
        仮算定一括発行一時tableWriter = new BatchEntityCreatedTempTableWriter(仮算定一括発行一時_TABLE_NAME,
                KarisanteiIkkatsuHakkoTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        FlexibleYear 調定年度minus1 = parameter.get調定年度().minusYear(1);
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());
        RStringBuilder rStringBuilder = new RStringBuilder();
        rStringBuilder.append(LEFT_FORMAT);
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                rStringBuilder.append(list.get(i) == null ? RString.EMPTY : list.get(i).getColumnValue());
                if (i != list.size() - 1) {
                    rStringBuilder.append(MIDDLE_FORMAT);
                }
            }
        }
        rStringBuilder.append(RIGHT_FORMAT);
        RString 科目コード = rStringBuilder.toRString();
        RString 処理日 = new RString(FlexibleDate.getNowDate().toString());
        parameter.set調定年度minus1(調定年度minus1);
        parameter.set科目コード(科目コード);
        parameter.set処理日(処理日);
        return new BatchDbReader(MAPPERPATH, parameter.toMyBatisParameter());
    }

    @Override
    protected void process(TsuchishoDataTempEntity entity) {
        仮算定一括発行一時tableWriter.insert(entity.toKarisanteiIkkatsuHakkoTempEntity());
    }

}
