package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.dbc040010.DBC040010DataUtil;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ErrorKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040010.TaishoshaChushuJigyobunProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040010.DBC040010ShoriKekkaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040010.DBC040010TaishoDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040010.JissekiFutangakuDataTempEntity;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）の対象者抽出事業分のプロセスです。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
public class TaishoshaChushuJigyobunProcess extends BatchProcessBase<DBC040010TaishoDataEntity> {

    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc040010.IKogakuGassanJikofutangakuKeisanMapper.get対象者抽出事業分データ");
    private static final RString TABLE_NAME = new RString("JissekiFutangakuDataTemp");

    /**
     * 出力パラメターデータがありの名称です。
     */
    private TaishoshaChushuJigyobunProcessParameter parameter;
    private DBC040010DataUtil util;
    private RString 市町村名;
    private List<RString> keysOfShoriKekkaTemp;
    @BatchWriter
    private IBatchTableWriter 実績負担額データ;
    @BatchWriter
    private IBatchTableWriter 処理結果リスト;

    @Override
    protected void initialize() {
        keysOfShoriKekkaTemp = new ArrayList<>();
        util = new DBC040010DataUtil();
        parameter.set宛名検索条件(util.get宛名検索条件());
        市町村名 = AssociationFinderFactory.createInstance().getAssociation().get市町村名();
    }

    @Override
    protected void createWriter() {
        実績負担額データ = new BatchEntityCreatedTempTableWriter(
                TABLE_NAME, JissekiFutangakuDataTempEntity.class);
        処理結果リスト = new BatchEntityCreatedTempTableWriter(
                DBC040010ShoriKekkaTempEntity.TABLE_NAME, DBC040010ShoriKekkaTempEntity.class, true);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH, parameter.toTaishoshaChushuJigyobunMyBatisParameter());
    }

    @Override
    protected void process(DBC040010TaishoDataEntity entity) {
        JissekiFutangakuDataTempEntity result = util.toJissekiTempEntityTaishoChuShu(entity, parameter.get処理日時(), 市町村名);
        実績負担額データ.insert(result);
        if (entity.getDaichoHihokenshaNo() != null) {
            return;
        }
        DBC040010ShoriKekkaTempEntity errorEntity
                = util.toShoriKekkaTempEntity(result, KaigoGassan_ErrorKubun.被保険者情報取得エラー);
        RString keyOfShoriKekkaTemp = util.getKeyOfShoriKekkaTemp(errorEntity);
        if (keysOfShoriKekkaTemp.contains(keyOfShoriKekkaTemp)) {
            return;
        }
        処理結果リスト.insert(errorEntity);
        keysOfShoriKekkaTemp.add(keyOfShoriKekkaTemp);
    }

}
