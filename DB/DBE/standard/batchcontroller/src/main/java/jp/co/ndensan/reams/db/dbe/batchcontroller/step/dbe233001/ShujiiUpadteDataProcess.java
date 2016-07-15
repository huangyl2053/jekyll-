/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.dbe233001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.dbe233001.ShujiiUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic.IDbT5301ShujiiIkenshoIraiJohoMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書督促状情報テーブルの更新処理のクラスです。
 *
 * @reamsid_L DBE-0060-040 zhangzhiming
 */
public class ShujiiUpadteDataProcess extends BatchProcessBase<RString> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbz.persistence.db.mapper.basic.IDbT5301ShujiiIkenshoIraiJohoMapper."
            + "getListForProcess");
    private ShujiiUpdateProcessParameter processParameter;
    private IDbT5301ShujiiIkenshoIraiJohoMapper mapper;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5301ShujiiIkenshoIraiJohoEntity> dbT5301Temp;

    @Override
    protected void initialize() {
        mapper = getMapper(IDbT5301ShujiiIkenshoIraiJohoMapper.class);
    }

    @Override
    protected void createWriter() {
        dbT5301Temp = new BatchPermanentTableWriter<>(DbT5301ShujiiIkenshoIraiJohoEntity.class);
    }

    @Override
    protected void process(RString item) {

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void afterExecute() {
        List<RString> noList = processParameter.get申請書管理番号List();
        if (noList != null && !noList.isEmpty()) {
            for (RString shinseishoKanriNo : noList) {
                DbT5301ShujiiIkenshoIraiJohoEntity entity = mapper
                        .get主治医意見書依頼情報BY申請書管理番号(processParameter.toShujiiUpdateMybatisParameter(shinseishoKanriNo));
                entity.setIkenshoSakuseiTokusokuYMD(new FlexibleDate(processParameter
                        .toShujiiUpdateMybatisParameter(shinseishoKanriNo).getTemp_督促日()));
                entity.setIkenshoSakuseiTokusokuHoho(processParameter.toShujiiUpdateMybatisParameter(shinseishoKanriNo).getTemp_督促方法());
                entity.setIkenshoTokusokuKaisu(entity.getIkenshoTokusokuKaisu() + 1);
                entity.setIkenshoTokusokuMemo(processParameter.toShujiiUpdateMybatisParameter(shinseishoKanriNo).getTemp_督促メモ());
                dbT5301Temp.update(entity);
            }
        }
    }
}
