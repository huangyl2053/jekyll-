/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110060;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_SakuseiErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060.HokenshaShutokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060.KogakuGassanShinseishoHokenshaShutokuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算支給申請書情報作成の保険者番号の取得Process
 *
 * @reamsid_L DBC-2630-030 wangxue
 */
public class KogakugassanShikyushinseishoOutHokenshaShutokuProcess extends BatchProcessBase<KogakuGassanShinseishoHokenshaShutokuEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110060."
            + "IKogakugassanShikyushinseishoOutMapper.get保険者番号の取得データ");
    private static final RString 処理結果リスト一時TABLE_NAME = new RString("DbWT1002KokuhorenSakuseiError");

    private List<Integer> 件数List;
    private List<Integer> レコード件数List;
    private List<HokenshaNo> 保険者番号List;
    private OutputParameter<HokenshaShutokuEntity> returnEntity;
    private HokenshaShutokuEntity outEntity;
    private boolean 取得件数flag;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時tableWriter;

    /**
     * 保険者番号と件数の取得です。
     */
    public static final RString PARAMETER_OUT_RETURNENTITY;

    static {
        PARAMETER_OUT_RETURNENTITY = new RString("returnEntity");
    }

    @Override
    protected void initialize() {
        outEntity = new HokenshaShutokuEntity();
        returnEntity = new OutputParameter<>();
        件数List = new ArrayList<>();
        レコード件数List = new ArrayList<>();
        保険者番号List = new ArrayList<>();
        取得件数flag = false;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void createWriter() {
        処理結果リスト一時tableWriter = new BatchEntityCreatedTempTableWriter(処理結果リスト一時TABLE_NAME,
                DbWT1002KokuhorenSakuseiErrorTempEntity.class);
    }

    @Override
    protected void process(KogakuGassanShinseishoHokenshaShutokuEntity entity) {
        取得件数flag = true;
        件数List.add(entity.get件数());
        レコード件数List.add(entity.getレコード件数());
        保険者番号List.add(entity.get保険者番号());
    }

    @Override
    protected void afterExecute() {
        if (!取得件数flag) {
            処理結果リスト一時tableWriter.insert(getKokuhorenSakuseiError());
        }
        outEntity.set件数List(件数List);
        outEntity.setレコード件数List(レコード件数List);
        outEntity.set保険者番号List(保険者番号List);
        returnEntity.setValue(outEntity);
    }

    private DbWT1002KokuhorenSakuseiErrorTempEntity getKokuhorenSakuseiError() {
        DbWT1002KokuhorenSakuseiErrorTempEntity tempEntity = new DbWT1002KokuhorenSakuseiErrorTempEntity();
        tempEntity.setErrorKubun(KokuhorenJoho_SakuseiErrorKubun.送付対象データなし.getコード());
        tempEntity.setShoHokanehshaNo(ShoKisaiHokenshaNo.EMPTY);
        tempEntity.setHihokenshaNo(HihokenshaNo.EMPTY);
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
