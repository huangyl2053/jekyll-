/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.HihokenshaDaichoShinseiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoShokanTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 被保険者台帳データの取得、申請償還情報に付与します。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
public class HihokenshaDaichoForShinseiShokanProcess extends BatchProcessBase<HihokenshaDaichoShinseiRelateEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufuoshirasetsuchisho.IKogakuKaigoServicehiOshiraseHakkoMapper.get被保険者台帳データFor申請情報償還");
    private static final RString TABLE_NAME = new RString("ShinseiJohoShokanTemp");

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID);
    }

    @Override
    protected void createWriter() {
        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, ShinseiJohoShokanTempEntity.class);
    }

    @Override
    protected void process(HihokenshaDaichoShinseiRelateEntity entity) {
        ShinseiJohoShokanTempEntity 申請情報償還 = entity.get申請情報償還();
        申請情報償還.setIdoYMDShokan(entity.get被保険者台帳().getIdoYMD());
        申請情報償還.setIdoJiyuCodeShokan(entity.get被保険者台帳().getIdoJiyuCode());
        申請情報償還.setShichosonCodeShokan(entity.get被保険者台帳().getShichosonCode());
        申請情報償還.setShikibetsuCodeShokan(entity.get被保険者台帳().getShikibetsuCode());
        申請情報償還.setShikakuShutokuJiyuCodeShokan(entity.get被保険者台帳().getShikakuShutokuJiyuCode());
        申請情報償還.setShikakuShutokuYMDShokan(entity.get被保険者台帳().getShikakuShutokuYMD());
        申請情報償還.setShikakuShutokuTodokedeYMDShokan(entity.get被保険者台帳().getShikakuShutokuTodokedeYMD());
        申請情報償還.setIchigoShikakuShutokuYMDShokan(entity.get被保険者台帳().getIchigoShikakuShutokuYMD());
        申請情報償還.setHihokennshaKubunCodeShokan(entity.get被保険者台帳().getHihokennshaKubunCode());
        申請情報償還.setShikakuSoshitsuJiyuCodeShokan(entity.get被保険者台帳().getShikakuSoshitsuJiyuCode());
        申請情報償還.setShikakuSoshitsuYMDShokan(entity.get被保険者台帳().getShikakuSoshitsuYMD());
        申請情報償還.setShikakuSoshitsuTodokedeYMDShokan(entity.get被保険者台帳().getShikakuSoshitsuTodokedeYMD());
        申請情報償還.setShikakuHenkoJiyuCodeShokan(entity.get被保険者台帳().getShikakuHenkoJiyuCode());
        申請情報償還.setShikakuHenkoYMDShokan(entity.get被保険者台帳().getShikakuHenkoYMD());
        申請情報償還.setShikakuHenkoTodokedeYMDShokan(entity.get被保険者台帳().getShikakuHenkoTodokedeYMD());
        申請情報償還.setJushochitokureiTekiyoJiyuCodeShokan(entity.get被保険者台帳().getJushochitokureiTekiyoJiyuCode());
        申請情報償還.setJushochitokureiTekiyoYMDShokan(entity.get被保険者台帳().getJushochitokureiTekiyoYMD());
        申請情報償還.setJushochitokureiTekiyoTodokedeYMDShokan(entity.get被保険者台帳().getJushochitokureiTekiyoTodokedeYMD());
        申請情報償還.setJushochitokureiKaijoJiyuCodeShokan(entity.get被保険者台帳().getJushochitokureiKaijoJiyuCode());
        申請情報償還.setJushochitokureiKaijoYMDShokan(entity.get被保険者台帳().getJushochitokureiKaijoYMD());
        申請情報償還.setJushochitokureiKaijoTodokedeYMDShokan(entity.get被保険者台帳().getJushochitokureiKaijoTodokedeYMD());
        申請情報償還.setJushochiTokureiFlagShokan(entity.get被保険者台帳().getJushochiTokureiFlag());
        申請情報償還.setKoikinaiJushochiTokureiFlagShokan(entity.get被保険者台帳().getKoikinaiJushochiTokureiFlag());
        申請情報償還.setKoikinaiTokureiSochimotoShichosonCodeShokan(entity.get被保険者台帳().getKoikinaiTokureiSochimotoShichosonCode());
        申請情報償還.setKyuShichosonCodeShokan(entity.get被保険者台帳().getKyuShichosonCode());
        申請情報償還.setState(EntityDataState.Modified);
        tempDbWriter.update(申請情報償還);
    }
}
