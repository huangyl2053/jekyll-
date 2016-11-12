/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB271001;

import java.util.AbstractMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchotaishoshadotei.TokuchoTaishoshaDoteiCombineEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.ue.uex.definition.core.DoteiFuitchiRiyu;
import jp.co.ndensan.reams.ue.uex.entity.relate.GyomuHihokenshaTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 *
 * 特徴対象者同定（一括）のバッチフロークラス<br>
 * 業務被保険者情報作成（年次）
 *
 * @reamsid_L DBB-1850-040 zhangrui
 */
public class CreateGyomuHokenshaJohoNenjiProcess extends BatchProcessBase<TokuchoTaishoshaDoteiCombineEntity> {

    /**
     * TABLE_NAME
     */
    public static final RString TABLE_NAME;
    private static final RString ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "tokuchotaishoshadotei.ITokuchoTaishoshaDoteiMapper.get介護の３つのテーブルの全件");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 業務被保険者情報一時tableWriter;

    static {
        TABLE_NAME = new RString("GyomuHihokenshaTemp");
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(ID);
    }

    @Override
    protected void createWriter() {
        業務被保険者情報一時tableWriter
                = new BatchEntityCreatedTempTableWriter(TABLE_NAME,
                        GyomuHihokenshaTempEntity.class);
    }

    @Override
    protected void process(TokuchoTaishoshaDoteiCombineEntity entity) {
        FlexibleDate now = FlexibleDate.getNowDate();
        Map.Entry<ShikibetsuCode, DoteiFuitchiRiyu> entry = get不一致理由_年次(entity, now);

        GyomuHihokenshaTempEntity 業務被保険者情報一時 = new GyomuHihokenshaTempEntity();
        業務被保険者情報一時.setShikibetsuCode(entry.getKey().getColumnValue());
        if (null == entry.getValue()) {
            業務被保険者情報一時.setFuitchiRiyuCode(null);
        } else {
            業務被保険者情報一時.setFuitchiRiyuCode(entry.getValue().getコード());
        }
        業務被保険者情報一時.setState(EntityDataState.Added);
        業務被保険者情報一時tableWriter.insert(業務被保険者情報一時);

    }

    private Map.Entry<ShikibetsuCode, DoteiFuitchiRiyu> get不一致理由_年次(TokuchoTaishoshaDoteiCombineEntity entity,
            FlexibleDate now) {
        DoteiFuitchiRiyu 不一致理由 = null;
        if (null != entity.getHihokensha() && null != entity.getHihokensha().getShikibetsuCode()) {
            boolean 資格喪失flag = do資格喪失の判定(entity.getHihokensha(), now);
            if (資格喪失flag) {
                不一致理由 = do他市町村住所地特例者台帳時不一致理由(entity.getTokurei(), entity.getJogaisha(), true);
            }
        } else {
            不一致理由 = do他市町村住所地特例者台帳時不一致理由(entity.getTokurei(), entity.getJogaisha(), false);
        }
        if (null != entity.getHihokensha() && null != entity.getHihokensha().getShikibetsuCode()) {
            return new AbstractMap.SimpleEntry(entity.getHihokensha().getShikibetsuCode(), 不一致理由);
        } else if (null != entity.getTokurei() && null != entity.getTokurei().getShikibetsuCode()) {
            return new AbstractMap.SimpleEntry(entity.getTokurei().getShikibetsuCode(), 不一致理由);
        } else {
            return new AbstractMap.SimpleEntry(entity.getJogaisha().getShikibetsuCode(), 不一致理由);
        }
    }

    private boolean do資格喪失の判定(DbV1001HihokenshaDaichoEntity 被保険者, FlexibleDate now) {
        return !(ShikakuKubun._１号.getコード().equals(被保険者.getHihokennshaKubunCode())
                && (null != 被保険者.getIchigoShikakuShutokuYMD()
                && !FlexibleDate.EMPTY.equals(被保険者.getIchigoShikakuShutokuYMD())
                && 被保険者.getIchigoShikakuShutokuYMD().isBeforeOrEquals(now))
                && (null == 被保険者.getShikakuSoshitsuYMD() || FlexibleDate.EMPTY.equals(被保険者.getShikakuSoshitsuYMD())
                || now.isBeforeOrEquals(被保険者.getShikakuSoshitsuYMD())) && !被保険者.getLogicalDeletedFlag());
    }

    private DoteiFuitchiRiyu do他市町村住所地特例者台帳時不一致理由(DbV1003TashichosonJushochiTokureiEntity tokurei,
            DbV1002TekiyoJogaishaEntity jogaisha, boolean 被保険者台帳があるFlag) {
        if (null != tokurei && null != tokurei.getShikibetsuCode()) {
            FlexibleDate 解除年月日 = tokurei.getKaijoYMD();
            if (null == 解除年月日 || 解除年月日.equals(FlexibleDate.EMPTY)) {
                return DoteiFuitchiRiyu.資格なし_他特例者;
            }
            return DoteiFuitchiRiyu.資格なし;
        } else if (null != jogaisha && null != jogaisha.getShikibetsuCode()) {
            FlexibleDate 解除年月日 = jogaisha.getKaijoYMD();
            if (null == 解除年月日 || 解除年月日.equals(FlexibleDate.EMPTY)) {
                return DoteiFuitchiRiyu.資格なし_適用除外者;
            }
            return DoteiFuitchiRiyu.資格なし;
        } else if (被保険者台帳があるFlag) {
            return DoteiFuitchiRiyu.資格喪失;
        }
        return null;
    }

}
