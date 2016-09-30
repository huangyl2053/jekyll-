/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110910;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.setaiyin.SetaiinHaakuSubTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 2_世帯員把握の作成クラスです。
 *
 * @reamsid_L DBC-2770-060 jinjue
 */
public class SetaiShotoProcess extends BatchProcessBase<SetaiinHaakuSubTempEntity> {

    // TODO 　一時ファイルでバッチに未実装
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.futangendogakurirekijyoho.IFutanGendogakuRirekiJyohoMapper.get負担限度額履歴情報");
    private static final RString 世帯員把握トリガ一時 = new RString("SetaiYinHaAKuToRiGaTemp");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 世帯員把握トリガ;

    @Override
    protected void initialize() {
        世帯員把握トリガ = new BatchEntityCreatedTempTableWriter(世帯員把握トリガ一時,
                SetaiinHaakuSubTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(SetaiinHaakuSubTempEntity entity) {
    }

    @Override
    protected void afterExecute() {
        SetaiinHaakuSubTempEntity entity = new SetaiinHaakuSubTempEntity();
//        entity.setHihokenshaNo(new HihokenshaNo("1546200012"));
//        entity.setJukyuYMD(new FlexibleDate("20100530"));
//        entity.setJuushotitokureigaitou(new RString("1"));
//        entity.setShikibetsuCode(new ShikibetsuCode("000000001011009"));
//        entity.setShotokuNendo(new FlexibleYear("2010"));
//        SetaiinHaakuSubTempEntity entity11 = new SetaiinHaakuSubTempEntity();
//        entity11.setHihokenshaNo(new HihokenshaNo("1546200010"));
//        entity11.setJukyuYMD(new FlexibleDate("20100530"));
//        entity11.setJuushotitokureigaitou(new RString("5"));
//        entity11.setShikibetsuCode(new ShikibetsuCode("000000001011009"));
//        entity11.setShotokuNendo(new FlexibleYear("2010"));
//        SetaiinHaakuSubTempEntity entity1 = new SetaiinHaakuSubTempEntity();
//        entity1.setHihokenshaNo(new HihokenshaNo("1546200014"));
//        entity1.setJukyuYMD(new FlexibleDate("20030530"));
//        entity1.setJuushotitokureigaitou(new RString("1"));
//        entity1.setShikibetsuCode(new ShikibetsuCode("000000001011008"));
//        entity1.setShotokuNendo(new FlexibleYear("2010"));
        世帯員把握トリガ.insert(entity);
//        世帯員把握トリガ.insert(entity11);
//        世帯員把握トリガ.insert(entity1);
    }
}
