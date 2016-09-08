/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110120;

import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.DbWT1741SaishinsaMoshitateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 介護給付費再審査申立書情報作成・事業者名称エラー登録を実行する。
 *
 * @reamsid_L DBC-2540-030 liuhui
 */
public class SaishinsaMoshitateDoJigyoshaNameErrTourokuProcess extends BatchProcessBase<DbWT1741SaishinsaMoshitateEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "saishinsamoshitateshoout.ISaishinsaMoshitateshoOutJohoMapper.select事業者名称エラーデータ関連リスト");
    private static final RString エラー区分_名称取得エラー = new RString("02");
    private static final RString 事業者名称 = new RString("事業者名称");
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
                        DbWT1002KokuhorenSakuseiErrorTempEntity.class);
    }

    @Override
    protected void process(DbWT1741SaishinsaMoshitateEntity entity) {

        DbWT1002KokuhorenSakuseiErrorTempEntity 処理結果 = new DbWT1002KokuhorenSakuseiErrorTempEntity();
        処理結果.setErrorKubun(エラー区分_名称取得エラー);
        処理結果.setShoHokanehshaNo(entity.getShokisaiHokenshaNo());
        処理結果.setHihokenshaNo(entity.getHiHokenshaNo());
        処理結果.setKey1(getColumnValue(entity.getJigyoshoNo()));
        処理結果.setKey2(entity.getServiceTeikyoYM().wareki().firstYear(FirstYear.ICHI_NEN).toDateString());
        処理結果.setKey3(getColumnValue(entity.getServiceTeikyoShuruiCode()));
        処理結果.setKey4(getColumnValue(entity.getServiceKomokuCode()));
        処理結果.setKey4(RString.EMPTY);
        処理結果.setHihokenshaKanaShimei(RString.EMPTY);
        処理結果.setHihokenshaShimei(RString.EMPTY);
        処理結果.setBiko(事業者名称);
        処理結果.setState(EntityDataState.Added);
        処理結果リスト一時tableWriter.insert(処理結果);

    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }
}
