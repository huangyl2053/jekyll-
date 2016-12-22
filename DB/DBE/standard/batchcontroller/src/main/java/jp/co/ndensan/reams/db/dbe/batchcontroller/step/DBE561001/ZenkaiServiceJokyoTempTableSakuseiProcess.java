/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE561001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.centertransmission.CenterTransmissionMybitisParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.centertransmission.CenterTransmissionProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.ZenkaiChosahyoServiceJokyoTempEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.ZenkaiServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.ZenkaiServiceJokyoTempTableEditorEntity;
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
public class ZenkaiServiceJokyoTempTableSakuseiProcess extends BatchKeyBreakBase<ZenkaiServiceJokyoEntity> {

    private static final RString SELECT_ZENKAISERVICEJOKYO = new RString("jp.co.ndensan.reams.db.dbe"
            + ".persistence.db.mapper.relate.centertransmission.ICenterTransmissionMapper.getZenkaiNinteichosahyoServiceJokyo");
    private CenterTransmissionProcessParameter parameter;
    private CenterTransmissionMybitisParamter mybitisParamter;
    private ZenkaiChosahyoServiceJokyoTempEntity tempEntity;
    private List<RString> 申請書管理番号リスト;
    private boolean isデータあり;

    @BatchWriter
    BatchEntityCreatedTempTableWriter zenkaiServiceJokyoTemp;

    @Override
    protected void initialize() {
        isデータあり = false;
        申請書管理番号リスト = parameter.get申請書管理番号リスト();
        mybitisParamter = parameter.toCenterTransmissionMybitisParamter();
        mybitisParamter.setShinseishoKanriNoList(申請書管理番号リスト);
        tempEntity = new ZenkaiChosahyoServiceJokyoTempEntity();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_ZENKAISERVICEJOKYO, mybitisParamter);
    }

    @Override
    protected void createWriter() {
        zenkaiServiceJokyoTemp = new BatchEntityCreatedTempTableWriter(
                ZenkaiChosahyoServiceJokyoTempEntity.TABLE_NAME, ZenkaiChosahyoServiceJokyoTempEntity.class);
    }

    @Override
    protected void keyBreakProcess(ZenkaiServiceJokyoEntity entity) {
        if (hasBrek(getBefore(), entity)) {
            zenkaiServiceJokyoTemp.insert(tempEntity);
            tempEntity = new ZenkaiChosahyoServiceJokyoTempEntity();
        }
    }

    @Override
    protected void usualProcess(ZenkaiServiceJokyoEntity entity) {
        isデータあり = true;
        tempEntity.setShinseishoKanriNo(entity.getShinseishoKanriNo());
        tempEntity.setKoroshoIfShikibetsuCode(entity.getKoroshoIfShikibetsuCode());
        tempEntity.setZenkaiShinseishoKanriNo(entity.getZenkaiShinseishoKanriNo());
        new ZenkaiServiceJokyoTempTableEditorEntity(tempEntity).set前回サービスの状況(entity);
    }

    @Override
    protected void afterExecute() {
        if (isデータあり) {
            zenkaiServiceJokyoTemp.insert(tempEntity);
        }
    }

    private boolean hasBrek(ZenkaiServiceJokyoEntity before, ZenkaiServiceJokyoEntity current) {
        return !before.getShinseishoKanriNo().equals(current.getShinseishoKanriNo())
                || !before.getKoroshoIfShikibetsuCode().equals(current.getKoroshoIfShikibetsuCode());
    }
}
