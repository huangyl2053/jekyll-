/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110010;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KyotakuKeikakuJikosakuseiKanriTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * エラー登録Process クラスです
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
public class JigyoshaNameOutDoErrorProcess extends BatchProcessBase<KyotakuKeikakuJikosakuseiKanriTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate"
            + ".dbc110010.IKyufukanrihyoOutMapper.doエラー登録");
    private static final RString 事業者名称 = new RString("「事業者名称」");
    @BatchWriter
    private IBatchTableWriter 処理結果リスト一時tableWriter;
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT1002KokuhorenSakuseiError");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME,
                        KokuhorenSakuseiErrorTempEntity.class);
    }

    @Override
    protected void process(KyotakuKeikakuJikosakuseiKanriTempEntity entity) {

        KokuhorenSakuseiErrorTempEntity 処理結果 = new KokuhorenSakuseiErrorTempEntity();
        処理結果.setErrorKubun(KokuhorenJoho_SakuseiErrorKubun.名称取得エラー.getコード());
        処理結果.setShoHokanehshaNo(RString.EMPTY);
        処理結果.setHihokenshaNo(entity.getHihokenshaNo().getColumnValue());
        処理結果.setKey1(entity.getTaishoYM());
        処理結果.setKey2(entity.getRiyoYM());
        処理結果.setKey3(entity.getServiceTeikyoJigyoshaName());
        処理結果.setKey4(entity.getServiceShuruiCode());
        処理結果.setKey5(RString.EMPTY);
        処理結果.setHihokenshaKanaShimei(RString.EMPTY);
        処理結果.setHihokenshaShimei(RString.EMPTY);
        処理結果.setBiko(事業者名称);
        処理結果リスト一時tableWriter.insert(処理結果);

    }
}
