/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchservice.step.DBC120010;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.DbcMapperInterfaces;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.KokuhorenJohoTorikomiBatchParameter;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;

/**
 *
 * @author N2810 久保 里史
 */
public class KokuhorenIFUpdataProcess extends BatchProcessBase<DbT3104KokuhorenInterfaceKanriEntity> {

    //パラメータ名
    public static final RString PARAMETER_SHORIYM = new RString("shoriYM");
    public static final RString PARAMETER_KOKANSHIKIBETSUNO = new RString("kokanShikibetsuNo");
    public static final RString PARAMETER_SHORIJOTAIKUBUN = new RString("shoriJotaiKubun");

    //パラメータ受取変数
    InputParameter<RString> shoriYM;
    InputParameter<RString> kokanShikibetsuNo;
    InputParameter<RString> shoriJotaiKubun;

    //IBatchWriterを実装したクラス
    @BatchWriter
    BatchPermanentTableWriter kokuhorenInterfaceKanriWriter;

    @Override
    protected IBatchReader createReader() {

        sqlParameter.put(PARAMETER_SHORIYM.toString(), shoriYM.getValue());
        sqlParameter.put(PARAMETER_KOKANSHIKIBETSUNO.toString(), kokanShikibetsuNo.getValue());
        return new BatchDbReader(DbcMapperInterfaces.国保連ＩＦ管理_データ取得byキー.getFullPath(), sqlParameter);
    }

    @Override
    protected void createWriter() {
        kokuhorenInterfaceKanriWriter
                = new BatchPermanentTableWriter(DbT3104KokuhorenInterfaceKanriEntity.class);
    }

    @Override
    protected void process(DbT3104KokuhorenInterfaceKanriEntity line) {
        line.setShoriJotaiKubun(shoriJotaiKubun.getValue());
        kokuhorenInterfaceKanriWriter.update(line);
    }
}
