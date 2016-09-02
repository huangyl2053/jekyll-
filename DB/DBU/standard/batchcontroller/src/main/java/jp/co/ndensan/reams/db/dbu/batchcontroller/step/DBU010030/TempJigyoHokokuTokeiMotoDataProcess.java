/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010030;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.ippangenbutsu.JigyoHokokuIppanGenbutsuRelateEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.ippangenbutsu.IJigyoHokokuGeppoIppanGenbutsuMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業報告月報_一般現物帳票出力のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5540-030 suguangjun
 *
 */
public class TempJigyoHokokuTokeiMotoDataProcess extends BatchProcessBase<JigyoHokokuIppanGenbutsuRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.ippangenbutsu."
            + "IJigyoHokokuGeppoIppanGenbutsuMapper.getJigyoHokokuTokeiMotoData");
    IJigyoHokokuGeppoIppanGenbutsuMapper mapper;
    private static final RString TABLE_事業報告統計元データ = new RString("tempJigyoHokokuTokeiMotoData");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 事業報告統計元データ一時ファイルB;

    @Override
    protected void initialize() {
        mapper = getMapper(IJigyoHokokuGeppoIppanGenbutsuMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        事業報告統計元データ一時ファイルB = new BatchEntityCreatedTempTableWriter(TABLE_事業報告統計元データ,
                JigyoHokokuIppanGenbutsuRelateEntity.class);
    }

    @Override
    protected void process(JigyoHokokuIppanGenbutsuRelateEntity entity) {
        事業報告統計元データ一時ファイルB.insert(entity);
    }
}
