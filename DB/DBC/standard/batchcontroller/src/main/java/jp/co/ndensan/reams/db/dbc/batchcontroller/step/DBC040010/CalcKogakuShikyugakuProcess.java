/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.dbc040010.DBC040010DataUtil;
import jp.co.ndensan.reams.db.dbc.business.core.dbc040010.KogakuShikyugakuJoho;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_ErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040010.CalcKogakuShikyugakuRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040010.DBC040010ShoriKekkaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040010.JissekiFutangakuDataTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）の高額支給額集計のプロセスクラスです。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
public class CalcKogakuShikyugakuProcess extends BatchProcessBase<CalcKogakuShikyugakuRelateEntity> {

    private static final RString TABLE_NAME = new RString("JissekiFutangakuDataTemp");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc040010.IKogakuGassanJikofutangakuKeisanMapper.get高額支給額集計");
    private static final int INDEX_16 = 16;
    private static final RString 定数_1 = new RString("1");
    private static final RString 定数_2 = new RString("2");
    private static final RString 定数_3 = new RString("3");
    private static final RString 定数_4 = new RString("4");
    private static final RString アスタリスク = new RString("*");
    private DBC040010DataUtil util;
    private JissekiFutangakuDataTempEntity updEntity;
    private boolean isあり;
    private CalcKogakuShikyugakuRelateEntity beforeEntity;
    private boolean wKm_blnIchiranKBN1;
    private boolean wKm_blnIchiranKBN2;
    private RString wKm_strIchiranhyoKBN;
    private List<Decimal> wK_KogakuShikyugaku;
    private List<RString> keysOfShoriKekkaTemp;
    @BatchWriter
    private IBatchTableWriter 処理結果リスト;
    @BatchWriter
    private IBatchTableWriter 実績負担額Writer;

    @Override
    protected void initialize() {
        keysOfShoriKekkaTemp = new ArrayList<>();
        isあり = false;
        util = new DBC040010DataUtil();
        wKm_blnIchiranKBN1 = false;
        wKm_blnIchiranKBN2 = false;
        wKm_strIchiranhyoKBN = RString.EMPTY;
        wK_KogakuShikyugaku = new ArrayList<>();
        for (int index = 0; index < INDEX_16; index++) {
            wK_KogakuShikyugaku.add(Decimal.ZERO);
        }
    }

    @Override
    protected void createWriter() {
        処理結果リスト = new BatchEntityCreatedTempTableWriter(
                DBC040010ShoriKekkaTempEntity.TABLE_NAME, DBC040010ShoriKekkaTempEntity.class, true);
        実績負担額Writer = new BatchEntityCreatedTempTableWriter(TABLE_NAME, JissekiFutangakuDataTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH);
    }

    @Override
    protected void process(CalcKogakuShikyugakuRelateEntity entity) {
        isあり = true;
        JissekiFutangakuDataTempEntity 実績負担額 = entity.get実績負担額データEntity();
        if (beforeEntity == null) {
            updEntity = 実績負担額;
            initHandle();
            loopHandle(entity);
            beforeEntity = entity;
            return;
        }
        if (実績負担額.equalsPrimaryKeys(beforeEntity.get実績負担額データEntity())) {
            loopHandle(entity);
            beforeEntity = entity;
            return;
        }
        beforeUpdate();
        updEntity.setState(EntityDataState.Modified);
        実績負担額Writer.update(updEntity);
        updEntity = 実績負担額;
        initHandle();
        loopHandle(entity);
        beforeEntity = entity;
    }

    @Override
    protected void afterExecute() {
        if (!isあり) {
            return;
        }
        beforeUpdate();
        実績負担額Writer.update(updEntity);
    }

    private void initHandle() {
        wKm_blnIchiranKBN1 = false;
        wKm_blnIchiranKBN2 = false;
        wKm_strIchiranhyoKBN = RString.EMPTY;
        for (int i = 0; i < INDEX_16; i++) {
            wK_KogakuShikyugaku.set(i, Decimal.ZERO);
        }
    }

    private void loopHandle(CalcKogakuShikyugakuRelateEntity entity) {
        KogakuShikyugakuJoho joho = util.cal高額支給額加算額(entity, wK_KogakuShikyugaku);
        wKm_blnIchiranKBN1 = wKm_blnIchiranKBN1 || joho.isWKm_blnIchiranKBN1();
        wKm_blnIchiranKBN2 = wKm_blnIchiranKBN2 || joho.isWKm_blnIchiranKBN2();
    }

    private void beforeUpdate() {
        util.update高額支給額加算額(updEntity, wK_KogakuShikyugaku);
        if (wKm_blnIchiranKBN1 && !wKm_blnIchiranKBN2) {
            wKm_strIchiranhyoKBN = 定数_1;
        } else if (!wKm_blnIchiranKBN1 && wKm_blnIchiranKBN2) {
            wKm_strIchiranhyoKBN = 定数_2;
        } else if (wKm_blnIchiranKBN1 && wKm_blnIchiranKBN2) {
            wKm_strIchiranhyoKBN = 定数_3;
        } else {
            if (util.is１件でも存在する(updEntity, wK_KogakuShikyugaku)) {
                wKm_strIchiranhyoKBN = 定数_4;
            } else {
                wKm_strIchiranhyoKBN = RString.EMPTY;
            }
        }
        updEntity.setIchiranKakuninKubun(wKm_strIchiranhyoKBN);
        updEntity.setIchiranKakuninKubun2(util.is警告判定有無(updEntity) ? アスタリスク : RString.EMPTY);
        if (!util.isマイナス値の月が存在(wK_KogakuShikyugaku)) {
            return;
        }
        DBC040010ShoriKekkaTempEntity errorEntity = util.toShoriKekkaTempEntity(updEntity, KaigoGassan_ErrorKubun.高額支給額集計エラー);
        RString keyOfShoriKekkaTemp = util.getKeyOfShoriKekkaTemp(errorEntity);
        if (keysOfShoriKekkaTemp.contains(keyOfShoriKekkaTemp)) {
            return;
        }
        処理結果リスト.insert(errorEntity);
        keysOfShoriKekkaTemp.add(keyOfShoriKekkaTemp);
    }
}
