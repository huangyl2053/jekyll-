/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE561001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.centertransmission.CenterTransmissionUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7211GaibuRenkeiDataoutputJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * センター送信データ作成のProcessクラスです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
public class UpdateGaibuRenkeiDataoutputJohoProcess extends BatchProcessBase<DbT7211GaibuRenkeiDataoutputJohoEntity> {

    private static final RString SELECT_NINTEISHINSEIJOHO = new RString("jp.co.ndensan.reams.db.dbe"
            + ".persistence.db.mapper.relate.centertransmission.ICenterTransmissionMapper.getGaibuRenkeiDataoutputJoho");
    private CenterTransmissionUpdateProcessParameter parameter;
    private List<RString> 出力された申請書管理番号;

    @BatchWriter
    private BatchPermanentTableWriter<DbT7211GaibuRenkeiDataoutputJohoEntity> tableWriter;

    @Override
    protected void initialize() {
        出力された申請書管理番号 = parameter.get申請書管理番号リスト();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_NINTEISHINSEIJOHO, parameter.toCenterTransmissionUpdateMybitisParamter());
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchPermanentTableWriter<>(DbT7211GaibuRenkeiDataoutputJohoEntity.class);
    }

    @Override
    protected void process(DbT7211GaibuRenkeiDataoutputJohoEntity entity) {
        if (出力された申請書管理番号.contains(entity.getShinseishoKanriNo().value())) {
            entity.setCenterSoshinChushutsuYMD(FlexibleDate.getNowDate());
            tableWriter.update(entity);
            出力された申請書管理番号.remove(entity.getShinseishoKanriNo().value());
        }
    }

    @Override
    protected void afterExecute() {
        for (RString 申請書管理番号 : 出力された申請書管理番号) {
            DbT7211GaibuRenkeiDataoutputJohoEntity johoEntity = new DbT7211GaibuRenkeiDataoutputJohoEntity();
            johoEntity.setShinseishoKanriNo(new ShinseishoKanriNo(申請書管理番号));
            johoEntity.setCenterSoshinChushutsuYMD(FlexibleDate.getNowDate());
            tableWriter.insert(johoEntity);
        }
    }
}
