/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010;

import jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo.Tokeihyo_TaishoNengetsu;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc150010.ToukeiJukyushaTaichoDataSakuseiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc150010.RiyojokyoTokeihyoMeisaiListProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1512JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.riyojokyotokeihyomeisailistsakusei.IRiyoJokyoTokeihyoMeisaiListSakuseiMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 抽出範囲外データ削除のプロセスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
public class DbWT1512HaiigaiDataDeleteProcess extends BatchProcessBase<DbWT1512JukyushaDaichoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.riyojokyotokeihyomeisailistsakusei.IRiyoJokyoTokeihyoMeisaiListSakuseiMapper.select有効認定期間終了年月");

    private static final RString TABLE_受給者台帳一時 = new RString("DbWT1512JukyushaDaicho");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 受給者台帳一時TBL;
    ToukeiJukyushaTaichoDataSakuseiMybatisParameter param;
    private RiyojokyoTokeihyoMeisaiListProcessParameter parameter;

    @Override
    protected void initialize() {
        if (Tokeihyo_TaishoNengetsu.サービス提供年月.getコード().equals(parameter.get対象年月())) {
            param = new ToukeiJukyushaTaichoDataSakuseiMybatisParameter(parameter.get開始年月(), parameter.get終了年月());
        } else {
            IRiyoJokyoTokeihyoMeisaiListSakuseiMapper mapper = getMapper(IRiyoJokyoTokeihyoMeisaiListSakuseiMapper.class);
            param = new ToukeiJukyushaTaichoDataSakuseiMybatisParameter(mapper.selectMinサービス提供年月(), mapper.selectMaxサービス提供年月());
        }
    }

    @Override
    protected void createWriter() {
        受給者台帳一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_受給者台帳一時,
                DbWT1512JukyushaDaichoEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, param);
    }

    @Override
    protected void process(DbWT1512JukyushaDaichoEntity entity) {
        受給者台帳一時TBL.delete(entity);
    }
}
