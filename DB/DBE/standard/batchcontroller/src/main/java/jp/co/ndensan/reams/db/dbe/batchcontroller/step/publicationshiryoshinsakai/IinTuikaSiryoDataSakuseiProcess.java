/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.publicationshiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.publicationshiryoshinsakai.IinTuutishoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.publicationshiryoshinsakai.IinTuikaSiryoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.publicationshiryoshinsakai.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定追加資料鑑情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class IinTuikaSiryoDataSakuseiProcess extends BatchProcessBase<ShinsakaiIinJohoEntity> {

    private static final RString SELECT_TUIKASIRYOJOHO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.publicationshiryoshinsakai.IShiryoShinsakaiIinMapper.getIinShimei");
    private IinTuikaSiryoProcessParameter paramter;
    private IinTuutishoMyBatisParameter myBatisParameter;

    @Override
    protected void initialize() {
        myBatisParameter = paramter.toIinTuutishoMyBatisParameter();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_TUIKASIRYOJOHO, myBatisParameter);
    }

    @Override
    protected void process(ShinsakaiIinJohoEntity t) {
        // TODO 実装しない。
    }

}
