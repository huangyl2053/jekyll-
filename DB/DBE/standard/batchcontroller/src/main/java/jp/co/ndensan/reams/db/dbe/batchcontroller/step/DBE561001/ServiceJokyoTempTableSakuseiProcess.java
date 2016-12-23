/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE561001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.centertransmission.CenterTransmissionMybitisParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.centertransmission.CenterTransmissionProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.NinteichosahyoServiceJokyoTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.ServiceJokyoTempTableEditorEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調査票（概況調査）サービスの状況一時テーブルのProcessクラスです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
public class ServiceJokyoTempTableSakuseiProcess extends BatchKeyBreakBase<DbT5207NinteichosahyoServiceJokyoEntity> {

    private static final RString SELECT_SERVICEJOKYO = new RString("jp.co.ndensan.reams.db.dbe"
            + ".persistence.db.mapper.relate.centertransmission.ICenterTransmissionMapper.getNinteichosahyoServiceJokyo");
    private CenterTransmissionProcessParameter parameter;
    private CenterTransmissionMybitisParamter mybitisParamter;
    private NinteichosahyoServiceJokyoTempEntity tempEntity;
    private List<RString> 申請書管理番号リスト;
    private boolean isデータあり;

    @BatchWriter
    BatchEntityCreatedTempTableWriter ninteichosahyoServiceJokyoTemp;

    @Override
    protected void initialize() {
        isデータあり = false;
        申請書管理番号リスト = parameter.get申請書管理番号リスト();
        mybitisParamter = parameter.toCenterTransmissionMybitisParamter();
        mybitisParamter.setShinseishoKanriNoList(申請書管理番号リスト);
        tempEntity = new NinteichosahyoServiceJokyoTempEntity();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_SERVICEJOKYO, mybitisParamter);
    }

    @Override
    protected void createWriter() {
        ninteichosahyoServiceJokyoTemp = new BatchEntityCreatedTempTableWriter(
                NinteichosahyoServiceJokyoTempEntity.TABLE_NAME, NinteichosahyoServiceJokyoTempEntity.class);
    }

    @Override
    protected void keyBreakProcess(DbT5207NinteichosahyoServiceJokyoEntity entity) {
        if (hasBrek(getBefore(), entity)) {
            ninteichosahyoServiceJokyoTemp.insert(tempEntity);
            tempEntity = new NinteichosahyoServiceJokyoTempEntity();
        }
    }

    @Override
    protected void usualProcess(DbT5207NinteichosahyoServiceJokyoEntity entity) {
        isデータあり = true;
        tempEntity.setShinseishoKanriNo(entity.getShinseishoKanriNo());
        tempEntity.setKoroshoIfShikibetsuCode(entity.getKoroshoIfShikibetsuCode());
        new ServiceJokyoTempTableEditorEntity(tempEntity).setサービスの状況(entity);
    }

    @Override
    protected void afterExecute() {
        if (isデータあり) {
            ninteichosahyoServiceJokyoTemp.insert(tempEntity);
        }
    }

    private boolean hasBrek(DbT5207NinteichosahyoServiceJokyoEntity before, DbT5207NinteichosahyoServiceJokyoEntity current) {
        return !before.getShinseishoKanriNo().equals(current.getShinseishoKanriNo())
                || !before.getKoroshoIfShikibetsuCode().equals(current.getKoroshoIfShikibetsuCode());
    }
}
