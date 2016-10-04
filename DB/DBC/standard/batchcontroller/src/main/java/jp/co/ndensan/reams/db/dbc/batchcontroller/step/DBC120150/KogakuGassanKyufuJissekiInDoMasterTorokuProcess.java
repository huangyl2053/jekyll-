/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120150;

import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_KyufuJissekiDataKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassankyufujissekiin.KogakuGassanKyufuJissekiInLoginMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassankyufujissekiin.KogakuGassanKyufuJissekiInDoMasterLoginProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3075KogakuGassanKyufuJissekiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiin.DbWT38P1KogakuGassanKyufuJissekiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiin.KogakuGassanKyufuJissekiInDoMasterTorokuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * 高額合算給付実績取込のマスタ登録(データ追加)。
 *
 * @reamsid_L DBC-2700-010 wangxingpeng
 */
public class KogakuGassanKyufuJissekiInDoMasterTorokuProcess
        extends BatchProcessBase<KogakuGassanKyufuJissekiInDoMasterTorokuEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakugassankyufujissekiin.IKogakuGassanKyufuJissekiInMapper.select高額合算給付実績と一時データ");
    private KogakuGassanKyufuJissekiInDoMasterLoginProcessParameter parameter;
    private KogakuGassanKyufuJissekiInLoginMybatisParameter dbParameter;
    private CountedItem 採番;
    private static final FlexibleYear 年度 = new FlexibleYear("0000");
    private static final RString INT_1 = new RString("1");
    private static final RString INT_2 = new RString("2");
    private int count = 0;
    @BatchWriter
    BatchPermanentTableWriter dbT3075Writer;
    @BatchWriter
    BatchPermanentTableWriter dbWT38P1Writer;

    @Override
    protected void initialize() {
        super.initialize();
        dbParameter = new KogakuGassanKyufuJissekiInLoginMybatisParameter();
        dbParameter.set処理年月(parameter.get処理年月());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, dbParameter);
    }

    @Override
    protected void createWriter() {
        dbT3075Writer = new BatchPermanentTableWriter(DbT3075KogakuGassanKyufuJissekiEntity.class);
        dbWT38P1Writer = new BatchPermanentTableWriter(DbWT38P1KogakuGassanKyufuJissekiTempEntity.class);
    }

    @Override
    protected void process(KogakuGassanKyufuJissekiInDoMasterTorokuEntity entity) {
        if (entity.get高額合算給付実績一時() != null) {
            採番 = Saiban.get(SubGyomuCode.DBZ介護共通, entity.get高額合算給付実績一時().getSeiriNo(), 年度, count);
        }
        DbT3075KogakuGassanKyufuJissekiEntity 高額合算給付実績 = entity.get高額合算給付実績();

        if (高額合算給付実績 == null) {
            doデータ追加(entity);
            count = count + 1;

        }

    }

    private void doデータ追加(KogakuGassanKyufuJissekiInDoMasterTorokuEntity entity) {
        DbT3075KogakuGassanKyufuJissekiEntity dbt3075entity = new DbT3075KogakuGassanKyufuJissekiEntity();
        DbWT38P1KogakuGassanKyufuJissekiTempEntity 高額合算給付実績一時 = entity.get高額合算給付実績一時();
        dbt3075entity.setKokanJohoShikibetsuNo(高額合算給付実績一時.getKokanJohoShikibetsuNo());
        dbt3075entity.setHihokenshaNo(高額合算給付実績一時.getHihokenshaNoIn());
        dbt3075entity.setShikyuShinseiSeiriNo(高額合算給付実績一時.getShikyuShinseiSeiriNo());
        dbt3075entity.setSeiriNo(new RString(採番.getCount()));
        dbt3075entity.setJikoFutanSeiriNo(高額合算給付実績一時.getJikoFutanSeiriNo());
        dbt3075entity.setHokenSeidoCode(高額合算給付実績一時.getHokenSeidoCode());
        dbt3075entity.setKyufuJissekiSakuseiKubunCode(高額合算給付実績一時.getKyufuJissekiSakuseiKubunCode());
        dbt3075entity.setShoKisaiHokenshaNo(高額合算給付実績一時.getShoKisaiHokenshaNo());
        dbt3075entity.setKokuho_HihokenshaShoKigo(高額合算給付実績一時.getKokuho_HihokenshaShoKigo());
        dbt3075entity.setShinseiYMD(高額合算給付実績一時.getShinseiYMD());
        dbt3075entity.setKetteiYMD(高額合算給付実績一時.getKetteiYMD());
        dbt3075entity.setJikoFutanSogaku(高額合算給付実績一時.getJikoFutanSogaku());
        dbt3075entity.setShikyuGaku(高額合算給付実績一時.getShikyuGaku());
        dbt3075entity.setShoriYM(高額合算給付実績一時.getShoriYM());
        dbt3075entity.setUketoriYM(parameter.get処理年月());
        dbt3075entity.setSofuYM(FlexibleYearMonth.EMPTY);
        if (RString.isNullOrEmpty(parameter.get処理区分())) {
            dbt3075entity.setDataKubun(KaigoGassan_KyufuJissekiDataKubun.国保連からの返却データ以外.getCode());
        }
        if (INT_1.equals(parameter.get処理区分())) {
            dbt3075entity.setDataKubun(KaigoGassan_KyufuJissekiDataKubun.国保連からの送付データ後期分.getCode());
        }
        if (INT_2.equals(parameter.get処理区分())) {
            dbt3075entity.setDataKubun(KaigoGassan_KyufuJissekiDataKubun.国保連からの送付データ国保分.getCode());
        }
        dbT3075Writer.insert(dbt3075entity);

    }
}
