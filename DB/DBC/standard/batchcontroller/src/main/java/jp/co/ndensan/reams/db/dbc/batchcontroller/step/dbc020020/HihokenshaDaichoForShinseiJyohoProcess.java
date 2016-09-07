/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.HihokenshaDaichoShinseiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 被保険者台帳データの取得、申請情報に付与します。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
public class HihokenshaDaichoForShinseiJyohoProcess extends BatchProcessBase<HihokenshaDaichoShinseiRelateEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufuoshirasetsuchisho.IKogakuKaigoServicehiOshiraseHakkoMapper.get被保険者台帳データFor申請情報");
    private static final RString TABLE_NAME = new RString("ShinseiJohoTemp");

    @BatchWriter
    private IBatchTableWriter<ShinseiJohoTempEntity> tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID);
    }

    @Override
    protected void createWriter() {
        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, ShinseiJohoTempEntity.class);
    }

    @Override
    protected void process(HihokenshaDaichoShinseiRelateEntity entity) {
        ShinseiJohoTempEntity 申請情報 = entity.get申請情報();
        申請情報.setIdoYMDJoho(entity.get被保険者台帳().getIdoYMD());
        申請情報.setIdoJiyuCodeJoho(entity.get被保険者台帳().getIdoJiyuCode());
        申請情報.setShichosonCodeJoho(entity.get被保険者台帳().getShichosonCode());
        申請情報.setShikibetsuCodeJoho(entity.get被保険者台帳().getShikibetsuCode());
        申請情報.setShikakuShutokuJiyuCodeJoho(entity.get被保険者台帳().getShikakuShutokuJiyuCode());
        申請情報.setShikakuShutokuYMDJoho(entity.get被保険者台帳().getShikakuShutokuYMD());
        申請情報.setShikakuShutokuTodokedeYMDJoho(entity.get被保険者台帳().getShikakuShutokuTodokedeYMD());
        申請情報.setIchigoShikakuShutokuYMDJoho(entity.get被保険者台帳().getIchigoShikakuShutokuYMD());
        申請情報.setHihokennshaKubunCodeJoho(entity.get被保険者台帳().getHihokennshaKubunCode());
        申請情報.setShikakuSoshitsuJiyuCodeJoho(entity.get被保険者台帳().getShikakuSoshitsuJiyuCode());
        申請情報.setShikakuSoshitsuYMDJoho(entity.get被保険者台帳().getShikakuSoshitsuYMD());
        申請情報.setShikakuSoshitsuTodokedeYMDJoho(entity.get被保険者台帳().getShikakuSoshitsuTodokedeYMD());
        申請情報.setShikakuHenkoJiyuCodeJoho(entity.get被保険者台帳().getShikakuHenkoJiyuCode());
        申請情報.setShikakuHenkoYMDJoho(entity.get被保険者台帳().getShikakuHenkoYMD());
        申請情報.setShikakuHenkoTodokedeYMDJoho(entity.get被保険者台帳().getShikakuHenkoTodokedeYMD());
        申請情報.setJushochitokureiTekiyoJiyuCodeJoho(entity.get被保険者台帳().getJushochitokureiTekiyoJiyuCode());
        申請情報.setJushochitokureiTekiyoYMDJoho(entity.get被保険者台帳().getJushochitokureiTekiyoYMD());
        申請情報.setJushochitokureiTekiyoTodokedeYMDJoho(entity.get被保険者台帳().getJushochitokureiTekiyoTodokedeYMD());
        申請情報.setJushochitokureiKaijoJiyuCodeJoho(entity.get被保険者台帳().getJushochitokureiKaijoJiyuCode());
        申請情報.setJushochitokureiKaijoYMDJoho(entity.get被保険者台帳().getJushochitokureiKaijoYMD());
        申請情報.setJushochitokureiKaijoTodokedeYMDJoho(entity.get被保険者台帳().getJushochitokureiKaijoTodokedeYMD());
        申請情報.setJushochiTokureiFlagJoho(entity.get被保険者台帳().getJushochiTokureiFlag());
        申請情報.setKoikinaiJushochiTokureiFlagJoho(entity.get被保険者台帳().getKoikinaiJushochiTokureiFlag());
        申請情報.setKoikinaiTokureiSochimotoShichosonCodeJoho(entity.get被保険者台帳().getKoikinaiTokureiSochimotoShichosonCode());
        申請情報.setKyuShichosonCodeJoho(entity.get被保険者台帳().getKyuShichosonCode());
        申請情報.setState(EntityDataState.Modified);
        tempDbWriter.update(申請情報);
    }
}
