/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc150030;

import jp.co.ndensan.reams.db.dbc.definition.processprm.servicecoderiyojokyo.DbWT3470UpdateProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030.DbWT3470chohyouShutsuryokuyouTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票出力用一時TBLの取得処理Processクラスです。
 *
 * @reamsid_L DBC-3340-030 jiangxiaolong
 */
public class UpdateChohyouShutsuryokuyouProcess
        extends BatchProcessBase<RString> {

    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.servicecoderiyojokyo."
                    + "IServicecodeRiyojokyoMapper.update帳票出力用一時TBL");
    private DbWT3470UpdateProcessParameter parameter;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 帳票出力用一時tableWriter;
    private static final RString 帳票出力用一時_TABLE_NAME = new RString("DbWT3470chohyouShutsuryokuyou");

    @Override
    protected void initialize() {
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, parameter.toMybatisParam());
    }

    @Override
    protected void createWriter() {
        帳票出力用一時tableWriter = new BatchEntityCreatedTempTableWriter(
                帳票出力用一時_TABLE_NAME, DbWT3470chohyouShutsuryokuyouTempEntity.class);
    }

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process(RString サービス略称) {
        DbWT3470chohyouShutsuryokuyouTempEntity tempEntity = new DbWT3470chohyouShutsuryokuyouTempEntity();
        tempEntity.setRenban(parameter.get履歴番号());
        tempEntity.setServiceShuruiCode(parameter.getサービス種類コード());
        tempEntity.setSortYouKomokuCode(parameter.getソート用サービス項目コード());
        tempEntity.setYoKaigoJotaiKubunCode(parameter.get要介護状態区分コード());
        tempEntity.setNissuKaisuSyukeichi(parameter.get日数_回数集計値());
        tempEntity.setTaniSuSyukeichi(parameter.get単位数集計値());
        tempEntity.setServiceRyakushou(サービス略称);
        帳票出力用一時tableWriter.update(tempEntity);
    }

    @Override
    protected void afterExecute() {
    }

}
