/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180010;

import jp.co.ndensan.reams.db.dbc.definition.core.riyoshafutan.RiyoshaFutanWaritaiHantei_ErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.nenjiriyoshafutanwariaihantei.NenjiRiyoshaFutanwariaiHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenjiriyoshafutanwariaihantei.DbWT1801ShoriKekkaKakuninListEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenjiriyoshafutanwariaihantei.JukyushaDaichoTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者台帳一時テーブルにデータの編集を行う
 *
 * @reamsid_L DBC-4980-030 yuanzhenxia
 */
public class JukyushaTaichoTempProcess extends BatchProcessBase<JukyushaDaichoTempEntity> {

    private static final RString DB_READER_MAPPER_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.nenjiriyoshafutanwariaihantei"
                    + ".INenjiRiyoshaFutanwariaiHanteiMapper.getJukyushaDaichoTemp");
    private static final RString 受給者TEMP = new RString("JukyuShaTaichoTempTable");
    private static final RString 処理結果確認リストTEMP = new RString("DbWT1801ShoriKekkaKakuninList");

    private NenjiRiyoshaFutanwariaiHanteiProcessParameter processParameter;

    @BatchWriter
    private IBatchTableWriter tempDbWriter;
    @BatchWriter
    private IBatchTableWriter tempResultListDbWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(DB_READER_MAPPER_ID, processParameter.toNenjiRiyoshaFutanwariaiHanteiMybaticParameter());
    }

    @Override
    protected void createWriter() {
        this.tempDbWriter = new BatchEntityCreatedTempTableWriter(受給者TEMP, JukyushaDaichoTempEntity.class);
        this.tempResultListDbWriter = new BatchEntityCreatedTempTableWriter(処理結果確認リストTEMP, DbWT1801ShoriKekkaKakuninListEntity.class);
    }

    @Override
    protected void process(JukyushaDaichoTempEntity entity) {
        DbWT1801ShoriKekkaKakuninListEntity resultListEntity = new DbWT1801ShoriKekkaKakuninListEntity();
        if (entity.getDbT1001HihokenshaDaicho_hihokenshaNo() == null) {
            resultListEntity.setErrorKubun(RiyoshaFutanWaritaiHantei_ErrorKubun.受給者_被保険者台帳取得.getコード());
            resultListEntity.setHihokenshaNo(entity.getDbT4001JukyushaDaicho_hihokenshaNo().value());
            tempResultListDbWriter.insert(resultListEntity);
        }
        if (entity.getUaFt200FindShikibetsuTaisho_shikibetsuCode() == null) {
            resultListEntity.setErrorKubun(RiyoshaFutanWaritaiHantei_ErrorKubun.受給者_宛名取得.getコード());
            resultListEntity.setHihokenshaNo(entity.getDbT4001JukyushaDaicho_hihokenshaNo().value());
            tempResultListDbWriter.insert(resultListEntity);
        }
        tempDbWriter.insert(entity);
    }

}
