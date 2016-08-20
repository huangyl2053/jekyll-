/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.gemmenGengakuTaishoShaHanteiYoukonSakusei;

import jp.co.ndensan.reams.db.dbd.definition.processprm.hanteiyoukonsakusei.GemmenGengakuTaishoShaHanteiYoukonSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengakutaishoshahanteiyoukonsakusei.SetaiinHaakuJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengakutaishoshahanteiyoukonsakusei.SetaiinHaakuJohoTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBDBTZ0001_減免減額対象者判定用根拠作成_process処理クラスです。
 *
 * @reamsid_L DBD-3710-090 liuwei2
 */
public class SetaiinHaakuInputSakusei extends BatchProcessBase<SetaiinHaakuJohoEntity> {

    private static final RString MYBATIS_SELECT_ID_世帯員把握情報 = new RString("jp.co.ndensan.reams.db.dbd.persistence"
            + ".db.mapper.relate.gemmenGengakuTaishoShaHanteiYoukonSakusei.ISetaiinHaakuJohoMapper.get世帯員把握情報");

    private GemmenGengakuTaishoShaHanteiYoukonSakuseiProcessParameter processParamter;

    private SetaiinHaakuJohoTempTableEntity item;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter setaiinHaakuJohoEntityTemp;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID_世帯員把握情報, processParamter.toGemmenGengakuTaishoShaHanteiYoukonSakuseiMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        setaiinHaakuJohoEntityTemp = new BatchEntityCreatedTempTableWriter(SetaiinHaakuJohoTempTableEntity.TABLE_NAME,
                SetaiinHaakuJohoTempTableEntity.class);
    }

    @Override
    protected void process(SetaiinHaakuJohoEntity list) {
        item = set減免減額対象者判定用根拠作成対象者(list);
        setaiinHaakuJohoEntityTemp.insert(item);
    }

    private SetaiinHaakuJohoTempTableEntity set減免減額対象者判定用根拠作成対象者(SetaiinHaakuJohoEntity list) {
        SetaiinHaakuJohoTempTableEntity tempTable = new SetaiinHaakuJohoTempTableEntity();
        tempTable.setHihokenshaNo(list.get被保険者番号());
        tempTable.setShikibetsuCode(list.get識別コード());
        tempTable.setKijunYMD(list.get基準年月日());
        if ((!processParamter.get所得年度().isEmpty()) || (processParamter.get所得年度() != null)) {
            tempTable.setShotokuNendo(processParamter.get所得年度());
        } else {
            tempTable.setShotokuNendo(list.get所得年度());
        }
        tempTable.setJushochiTokureiFlag(list.get住所地特例フラグ());
        return tempTable;
    }
}
