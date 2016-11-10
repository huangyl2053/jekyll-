package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB004001;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 賦課の情報を一括登録するバッチのパラメータです。
 *
 * @reamsid_L DBB-9040-070 wangxiaodong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBB004001_FukaJohoTorokuParameter extends BatchParameterBase {

    private static final String DUMMY = "Dummy";

    @BatchParameter(key = DUMMY, name = "Dummy")
    private RString dummy;

    /**
     * コンストラクタです。
     */
    public DBB004001_FukaJohoTorokuParameter() {
        dummy = RString.EMPTY;
    }
}
