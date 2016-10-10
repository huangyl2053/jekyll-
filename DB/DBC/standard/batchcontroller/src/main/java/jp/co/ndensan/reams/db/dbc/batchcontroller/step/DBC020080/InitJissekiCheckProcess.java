package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080.JissekiFutangakuDataTempEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc020080.IJigyobunKogakuGassanJikofutangakuKeisanMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）の＜中間DB＞実績負担額データ存在チェックのプロセスです。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
public class InitJissekiCheckProcess extends SimpleBatchProcessBase {

    /**
     * 出力パラメター「データがあり」の名称です。
     */
    public static final RString OUTPUTNAME;
    private OutputParameter<Boolean> isデータがあり;
    private boolean isあり;

    static {
        OUTPUTNAME = new RString("isデータがあり");
    }

    @Override
    protected void beforeExecute() {
        IJigyobunKogakuGassanJikofutangakuKeisanMapper mapper
                = getMapper(IJigyobunKogakuGassanJikofutangakuKeisanMapper.class);
        List<JissekiFutangakuDataTempEntity> resultList = mapper.get実績負担額データ();
        isあり = resultList != null && !resultList.isEmpty();
    }

    @Override
    protected void process() {
        if (isあり) {
            isデータがあり.setValue(Boolean.TRUE);
        } else {
            isデータがあり.setValue(Boolean.FALSE);
        }
    }

}
