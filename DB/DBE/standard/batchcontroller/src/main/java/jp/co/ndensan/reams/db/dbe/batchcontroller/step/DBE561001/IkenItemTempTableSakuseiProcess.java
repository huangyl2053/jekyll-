/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE561001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.centertransmission.CenterTransmissionMybitisParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.centertransmission.CenterTransmissionProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.IkenItemTempTableEditorEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.ShujiiIkenshoIkenItemTempEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定主治医意見書意見項目一時テーブルのProcessクラスです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
public class IkenItemTempTableSakuseiProcess extends BatchKeyBreakBase<DbT5304ShujiiIkenshoIkenItemEntity> {

    private static final RString SELECT_SHUJIIIKENSHOIKENITEM = new RString("jp.co.ndensan.reams.db.dbe"
            + ".persistence.db.mapper.relate.centertransmission.ICenterTransmissionMapper.getShujiiIkenshoIkenItem");
    private CenterTransmissionProcessParameter parameter;
    private CenterTransmissionMybitisParamter mybitisParamter;
    private ShujiiIkenshoIkenItemTempEntity tempEntity;
    private List<RString> 申請書管理番号リスト;
    private boolean isデータあり;

    @BatchWriter
    BatchEntityCreatedTempTableWriter shujiiIkenshoIkenItemTemp;

    @Override
    protected void initialize() {
        isデータあり = false;
        申請書管理番号リスト = parameter.get申請書管理番号リスト();
        mybitisParamter = parameter.toCenterTransmissionMybitisParamter();
        mybitisParamter.setShinseishoKanriNoList(申請書管理番号リスト);
        tempEntity = new ShujiiIkenshoIkenItemTempEntity();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_SHUJIIIKENSHOIKENITEM, mybitisParamter);
    }

    @Override
    protected void createWriter() {
        shujiiIkenshoIkenItemTemp = new BatchEntityCreatedTempTableWriter(
                ShujiiIkenshoIkenItemTempEntity.TABLE_NAME, ShujiiIkenshoIkenItemTempEntity.class);
    }

    @Override
    protected void keyBreakProcess(DbT5304ShujiiIkenshoIkenItemEntity entity) {
        if (hasBrek(getBefore(), entity)) {
            shujiiIkenshoIkenItemTemp.insert(tempEntity);
            tempEntity = new ShujiiIkenshoIkenItemTempEntity();
        }
    }

    @Override
    protected void usualProcess(DbT5304ShujiiIkenshoIkenItemEntity entity) {
        isデータあり = true;
        tempEntity.setShinseishoKanriNo(entity.getShinseishoKanriNo());
        tempEntity.setKoroshoIfShikibetsuCode(entity.getKoroshoIfShikibetsuCode());
        new IkenItemTempTableEditorEntity(tempEntity).set調査項目(entity);
    }

    @Override
    protected void afterExecute() {
        if (isデータあり) {
            shujiiIkenshoIkenItemTemp.insert(tempEntity);
        }
    }

    private boolean hasBrek(DbT5304ShujiiIkenshoIkenItemEntity before, DbT5304ShujiiIkenshoIkenItemEntity current) {
        return !before.getShinseishoKanriNo().equals(current.getShinseishoKanriNo())
                || !before.getKoroshoIfShikibetsuCode().equals(current.getKoroshoIfShikibetsuCode());
    }
}
