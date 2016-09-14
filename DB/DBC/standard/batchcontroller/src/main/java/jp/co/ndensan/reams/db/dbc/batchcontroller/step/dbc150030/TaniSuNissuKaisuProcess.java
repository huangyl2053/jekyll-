/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc150030;

import jp.co.ndensan.reams.db.dbc.definition.processprm.servicecoderiyojokyo.KyufuJissekiMeisaiGetProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030.DbWT3470chohyouShutsuryokuyouTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030.TaniSuNissuKaisuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 日数・回数、単位数を取得、帳票出力用一時TBLの登録Processクラスです。
 *
 * @reamsid_L DBC-3340-030 jiangxiaolong
 */
public class TaniSuNissuKaisuProcess
        extends BatchProcessBase<TaniSuNissuKaisuEntity> {

    private KyufuJissekiMeisaiGetProcessParameter parameter;

    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.servicecoderiyojokyo."
                    + "IServicecodeRiyojokyoMapper.get回数単位数");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 帳票出力用一時tableWriter;
    private static final RString 帳票出力用一時_TABLE_NAME = new RString("DbWT3470chohyouShutsuryokuyou");

    private int 履歴番号;
    private static final int INT_1 = 1;
    private static final int INT_4 = 4;
    private static final RString 文字_0 = new RString("0");

    @Override
    protected void initialize() {
        履歴番号 = INT_1;
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
    protected void process(TaniSuNissuKaisuEntity entity) {
        DbWT3470chohyouShutsuryokuyouTempEntity tempEntity = new DbWT3470chohyouShutsuryokuyouTempEntity();
        tempEntity.setRenban(履歴番号);
        tempEntity.setServiceShuruiCode(entity.getサービス種類コード());
        RString ソート用サービス項目コード = entity.getソート用サービス項目コード();
        if (ソート用サービス項目コード != null) {
            for (int i = ソート用サービス項目コード.length(); i < INT_4; i++) {
                ソート用サービス項目コード = ソート用サービス項目コード.concat(文字_0);
            }
        }
        tempEntity.setSortYouKomokuCode(ソート用サービス項目コード);
        tempEntity.setYoKaigoJotaiKubunCode(entity.get要介護状態区分コード());
        tempEntity.setNissuKaisuSyukeichi(getDecimalVaule(entity.get日数_回数集計値()));
        tempEntity.setTaniSuSyukeichi(getDecimalVaule(entity.get単位数集計値()));
        帳票出力用一時tableWriter.insert(tempEntity);
        履歴番号 = 履歴番号 + INT_1;
    }

    @Override
    protected void afterExecute() {
    }

    private Decimal getDecimalVaule(Decimal 値) {
        if (null != 値) {
            return 値;
        }
        return Decimal.ZERO;
    }

}
