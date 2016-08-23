/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE561001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.centertransmission.CenterTransmissionMybitisParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.centertransmission.CenterTransmissionProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.ZenkaiChosaItemEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.ZenkaiChosaItemTempTableEditorEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.ZenkaiNinteichosahyoChosaItemTempEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.centertransmission.ICenterTransmissionMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5129TennyuShiboEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 前回認定調査票（基本調査）調査項目一時テーブルのProcessクラスです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
public class ZenkaiChosaItemTempTableSakuseiProcess extends BatchKeyBreakBase<ZenkaiChosaItemEntity> {

    private static final RString SELECT_NINTEICHOSAHYOCHOSAITEM = new RString("jp.co.ndensan.reams.db.dbe"
            + ".persistence.db.mapper.relate.centertransmission.ICenterTransmissionMapper.getZenkaiNinteichosahyoChosaItem");
    private CenterTransmissionProcessParameter parameter;
    private CenterTransmissionMybitisParamter mybitisParamter;
    private ICenterTransmissionMapper mapper;
    private ZenkaiNinteichosahyoChosaItemTempEntity tempEntity;
    private ZenkaiChosaItemTempTableEditorEntity editorEntity;
    private List<RString> 申請書管理番号リスト;
    private boolean isデータあり;

    @BatchWriter
    BatchEntityCreatedTempTableWriter zenkaiChosaItemTemp;

    @Override
    protected void initialize() {
        isデータあり = false;
        申請書管理番号リスト = parameter.get申請書管理番号リスト();
        mybitisParamter = parameter.toCenterTransmissionMybitisParamter();
        mapper = getMapper(ICenterTransmissionMapper.class);
        if (parameter.is転入死亡情報出力()) {
            get申請書管理番号リスト(mapper.getShinseishoKanriNoByTennyuShibo(mybitisParamter));
        }
        mybitisParamter.setShinseishoKanriNoList(申請書管理番号リスト);
        tempEntity = new ZenkaiNinteichosahyoChosaItemTempEntity();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_NINTEICHOSAHYOCHOSAITEM, mybitisParamter);
    }

    @Override
    protected void createWriter() {
        zenkaiChosaItemTemp = new BatchEntityCreatedTempTableWriter(
                ZenkaiNinteichosahyoChosaItemTempEntity.TABLE_NAME, ZenkaiNinteichosahyoChosaItemTempEntity.class);
    }

    @Override
    protected void keyBreakProcess(ZenkaiChosaItemEntity entity) {
        if (hasBrek(getBefore(), entity)) {
            zenkaiChosaItemTemp.insert(tempEntity);
            tempEntity = new ZenkaiNinteichosahyoChosaItemTempEntity();
        }
    }

    @Override
    protected void usualProcess(ZenkaiChosaItemEntity entity) {
        isデータあり = true;
        tempEntity.setShinseishoKanriNo(entity.getShinseishoKanriNo());
        tempEntity.setKoroshoIfShikibetsuCode(entity.getKoroshoIfShikibetsuCode());
        editorEntity = new ZenkaiChosaItemTempTableEditorEntity(tempEntity);
        editorEntity.set前回調査項目(entity);
    }

    @Override
    protected void afterExecute() {
        if (isデータあり) {
            zenkaiChosaItemTemp.insert(tempEntity);
        }
    }

    private boolean hasBrek(ZenkaiChosaItemEntity before, ZenkaiChosaItemEntity current) {
        return !before.getShinseishoKanriNo().equals(current.getShinseishoKanriNo())
                || !before.getKoroshoIfShikibetsuCode().equals(current.getKoroshoIfShikibetsuCode());
    }

    private void get申請書管理番号リスト(List<DbT5129TennyuShiboEntity> shinseishoKanriNoList) {
        for (DbT5129TennyuShiboEntity entity : shinseishoKanriNoList) {
            if (!申請書管理番号リスト.contains(entity.getShinseishoKanriNo().value())) {
                申請書管理番号リスト.add(entity.getShinseishoKanriNo().value());
            }
        }
    }

}
