package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080;

import jp.co.ndensan.reams.db.dbc.business.core.dbc020080.DBC020080DataUtil;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ErrorListType;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020080.TaishoshaChushuJigyobunProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.DBC020080ShoriKekkaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.DBC020080TaishoDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.JissekiFutangakuDataTempEntity;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）の対象者抽出事業分のプロセスです。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
public class TaishoshaChushuJigyobunProcess extends BatchProcessBase<DBC020080TaishoDataEntity> {

    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc020080.IJigyobunKogakuGassanJikofutangakuKeisanMapper.get対象者抽出事業分データ");
    private static final RString TABLE_NAME = new RString("JissekiFutangakuDataTemp");

    /**
     * 出力パラメターデータがありの名称です。
     */
    public static final RString OUTPUTNAME;
    private TaishoshaChushuJigyobunProcessParameter parameter;
    private DBC020080DataUtil util;
    private RString beforeKey;
    private OutputParameter<Boolean> isデータがあり;
    private RString 市町村名;
    @BatchWriter
    private IBatchTableWriter 実績負担額データ;
    @BatchWriter
    private IBatchTableWriter 処理結果リスト;

    static {
        OUTPUTNAME = new RString("isデータがあり");
    }

    @Override
    protected void initialize() {
        isデータがあり.setValue(Boolean.FALSE);
        beforeKey = RString.EMPTY;
        util = new DBC020080DataUtil();
        parameter.set宛名検索条件(util.get宛名検索条件());
        市町村名 = AssociationFinderFactory.createInstance().getAssociation().get市町村名();
    }

    @Override
    protected void createWriter() {
        実績負担額データ = new BatchEntityCreatedTempTableWriter(
                TABLE_NAME, JissekiFutangakuDataTempEntity.class);
        処理結果リスト = new BatchEntityCreatedTempTableWriter(
                DBC020080ShoriKekkaTempEntity.TABLE_NAME, DBC020080ShoriKekkaTempEntity.class, true);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH, parameter.toTaishoshaChushuJigyobunMyBatisParameter());
    }

    @Override
    protected void process(DBC020080TaishoDataEntity entity) {
        isデータがあり.setValue(Boolean.TRUE);
        JissekiFutangakuDataTempEntity result = util.toJissekiTempEntityTaishoChuShu(entity, parameter.get処理日時(), 市町村名);
        実績負担額データ.insert(result);
        if (entity.getDaichoHihokenshaNo() == null) {
            return;
        }
        DBC020080ShoriKekkaTempEntity errorEntity
                = util.toShoriKekkaTempEntity(result, KaigoGassan_ErrorListType.リストタイプ0);
        RString nowKey = util.getKeyOfShoriKekkaTemp(errorEntity);
        if (nowKey.equals(beforeKey)) {
            return;
        }
        処理結果リスト.insert(errorEntity);
        beforeKey = nowKey;
    }

}
