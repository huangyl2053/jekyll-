/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB011001;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchokarisanteifuka.TokuchoKarisanteiFukaMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteifuka.TokuchoKarisanteiFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager.ShutsuryokujunTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 出力順Temppのrocessクラスです。
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
public class InsShutsuryokujunProcess extends BatchProcessBase<DbT2015KeisangoJohoEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchokarisanteifuka."
            + "ITokuchoKariSanteiFukaMapper.select計算後情報");
    private TokuchoKarisanteiFukaProcessParameter processParameter;
    private static final RString 出力順_TABLE_NAME = new RString("ShutsuryokujunTemp");
    private static final RString 特別徴収 = new RString("0");
    private static final RString 併用徴収 = new RString("1");
    private static final RString 普通徴収 = new RString("3");
    private static final RString 特徴開始月 = new RString("0");
    private static final RString 特徴開始月_4月 = new RString("4");
    private static final RString 特徴開始月_6月 = new RString("6");
    private static final RString 特徴開始月_8月 = new RString("8");
    private static final int INT_1 = -1;

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        TokuchoKarisanteiFukaMyBatisParameter parameter = new TokuchoKarisanteiFukaMyBatisParameter();
        parameter.set調定年度(processParameter.get調定年度());
        parameter.set賦課年度(processParameter.get賦課年度());
        parameter.set調定日時(processParameter.get調定日時());
        return new BatchDbReader(READ_DATA_ID, parameter);
    }

    @Override
    protected void createWriter() {
        tempDbWriter = new BatchEntityCreatedTempTableWriter(出力順_TABLE_NAME, ShutsuryokujunTempEntity.class);
    }

    @Override
    protected void process(DbT2015KeisangoJohoEntity entity) {
        ShutsuryokujunTempEntity 出力順TemoEntity = new ShutsuryokujunTempEntity();
        出力順TemoEntity.setChoteiNendo(entity.getChoteiNendo());
        出力順TemoEntity.setFukaNendo(entity.getFukaNendo());
        出力順TemoEntity.setTsuchishoNo(entity.getTsuchishoNo());
        出力順TemoEntity.setChoshuHoho(特別徴収);
        if (普通徴収.equals(entity.getChoshuHoho4gatsu())) {
            出力順TemoEntity.setChoshuHoho(併用徴収);
        }
        出力順TemoEntity.setTokuchoKaisiTuki(特徴開始月);
        if (Decimal.ZERO.compareTo(entity.getTkKibetsuGaku01()) == INT_1) {
            出力順TemoEntity.setTokuchoKaisiTuki(特徴開始月_4月);
        } else if (Decimal.ZERO.compareTo(entity.getTkKibetsuGaku02()) == INT_1) {
            出力順TemoEntity.setTokuchoKaisiTuki(特徴開始月_6月);
        } else if (Decimal.ZERO.compareTo(entity.getTkKibetsuGaku03()) == INT_1) {
            出力順TemoEntity.setTokuchoKaisiTuki(特徴開始月_8月);
        }
        tempDbWriter.insert(出力順TemoEntity);
    }

}
