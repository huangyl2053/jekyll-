/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110050;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050.HokenshaNoShutokuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還連絡票情報作成の送付ファイル作成の保険者番号取得Processです。
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
public class ShokanRenrakuhyoOutGetHokenshaNoProcess extends BatchProcessBase<HokenshaNoShutokuEntity> {

    private static final RString MAPPER_PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc110050.IShokanRenrakuhyoOutMapper.get保険者番号データ");

    private static final RString 処理結果リスト一時TABLE_NAME = new RString("DbWT1002KokuhorenSakuseiError");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 一時Writer;

    private List<HokenshaNoShutokuEntity> hokenshaList;
    private OutputParameter<List<HokenshaNoShutokuEntity>> outHokenshaNo;

    /**
     * 取得して保険者番号List
     */
    public static final RString PARAMETER_OUT_OUTHOKENSHANO;

    static {
        PARAMETER_OUT_OUTHOKENSHANO = new RString("outHokenshaNo");
    }

    @Override
    protected void initialize() {
        hokenshaList = new ArrayList<>();
        outHokenshaNo = new OutputParameter<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_PATH);
    }

    @Override
    protected void createWriter() {
        一時Writer = new BatchEntityCreatedTempTableWriter(処理結果リスト一時TABLE_NAME, DbWT1002KokuhorenSakuseiErrorTempEntity.class);
    }

    @Override
    protected void process(HokenshaNoShutokuEntity entity) {
        hokenshaList.add(entity);
    }

    @Override
    protected void afterExecute() {
        if (hokenshaList.isEmpty()) {
            一時Writer.insert(get処理結果リスト());
        }
        outHokenshaNo.setValue(hokenshaList);
    }

    private DbWT1002KokuhorenSakuseiErrorTempEntity get処理結果リスト() {
        DbWT1002KokuhorenSakuseiErrorTempEntity tempEntity = new DbWT1002KokuhorenSakuseiErrorTempEntity();
        tempEntity.setErrorKubun(KokuhorenJoho_SakuseiErrorKubun.送付対象データなし.getコード());
        tempEntity.setShoHokanehshaNo(null);
        tempEntity.setHihokenshaNo(null);
        tempEntity.setKey1(RString.EMPTY);
        tempEntity.setKey2(RString.EMPTY);
        tempEntity.setKey3(RString.EMPTY);
        tempEntity.setKey4(RString.EMPTY);
        tempEntity.setKey5(RString.EMPTY);
        tempEntity.setHihokenshaKanaShimei(RString.EMPTY);
        tempEntity.setHihokenshaShimei(RString.EMPTY);
        tempEntity.setBiko(RString.EMPTY);
        return tempEntity;
    }

}
