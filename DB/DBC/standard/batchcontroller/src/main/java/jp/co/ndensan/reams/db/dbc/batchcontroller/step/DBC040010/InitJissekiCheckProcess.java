package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040010;

import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040010.IKogakuGassanJikofutangakuKeisanMapper;
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
        isデータがあり = new OutputParameter<>();
        IKogakuGassanJikofutangakuKeisanMapper mapper
                = getMapper(IKogakuGassanJikofutangakuKeisanMapper.class);
        Integer 件数 = mapper.get実績負担額データの件数();
        isあり = 件数 != null && 件数 > 0;
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
