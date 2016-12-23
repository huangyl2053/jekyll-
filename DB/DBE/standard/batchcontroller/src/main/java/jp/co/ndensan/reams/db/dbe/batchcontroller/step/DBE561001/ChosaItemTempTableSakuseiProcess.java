/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE561001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.centertransmission.CenterTransmissionMybitisParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.centertransmission.CenterTransmissionProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.ChosaItemTempTableEditorEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.NinteichosahyoChosaItemTempEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査票（基本調査）調査項目一時テーブルのProcessクラスです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
public class ChosaItemTempTableSakuseiProcess extends BatchKeyBreakBase<DbT5211NinteichosahyoChosaItemEntity> {

    private static final RString SELECT_NINTEICHOSAHYOCHOSAITEM = new RString("jp.co.ndensan.reams.db.dbe"
            + ".persistence.db.mapper.relate.centertransmission.ICenterTransmissionMapper.getNinteichosahyoChosaItem");
    private CenterTransmissionProcessParameter parameter;
    private CenterTransmissionMybitisParamter mybitisParamter;
    private NinteichosahyoChosaItemTempEntity tempEntity;
    private List<RString> 申請書管理番号リスト;
    private boolean isデータあり;

    @BatchWriter
    BatchEntityCreatedTempTableWriter ninteichosahyoChosaItemTemp;

    @Override
    protected void initialize() {
        isデータあり = false;
        申請書管理番号リスト = parameter.get申請書管理番号リスト();
        mybitisParamter = parameter.toCenterTransmissionMybitisParamter();
        mybitisParamter.setShinseishoKanriNoList(申請書管理番号リスト);
        tempEntity = new NinteichosahyoChosaItemTempEntity();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_NINTEICHOSAHYOCHOSAITEM, mybitisParamter);
    }

    @Override
    protected void createWriter() {
        ninteichosahyoChosaItemTemp = new BatchEntityCreatedTempTableWriter(
                NinteichosahyoChosaItemTempEntity.TABLE_NAME, NinteichosahyoChosaItemTempEntity.class);
    }

    @Override
    protected void keyBreakProcess(DbT5211NinteichosahyoChosaItemEntity entity) {
        if (hasBrek(getBefore(), entity)) {
            ninteichosahyoChosaItemTemp.insert(tempEntity);
            tempEntity = new NinteichosahyoChosaItemTempEntity();
        }
    }

    @Override
    protected void usualProcess(DbT5211NinteichosahyoChosaItemEntity entity) {
        isデータあり = true;
        tempEntity.setShinseishoKanriNo(entity.getShinseishoKanriNo());
        tempEntity.setKoroshoIfShikibetsuCode(entity.getKoroshoIfShikibetsuCode());
        new ChosaItemTempTableEditorEntity(tempEntity).set調査項目(entity);
    }

    @Override
    protected void afterExecute() {
        if (isデータあり) {
            ninteichosahyoChosaItemTemp.insert(tempEntity);
        }
    }

    private boolean hasBrek(DbT5211NinteichosahyoChosaItemEntity before, DbT5211NinteichosahyoChosaItemEntity current) {
        return !before.getShinseishoKanriNo().equals(current.getShinseishoKanriNo())
                || !before.getKoroshoIfShikibetsuCode().equals(current.getKoroshoIfShikibetsuCode());
    }
}
