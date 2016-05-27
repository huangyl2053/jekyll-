package jp.co.ndensan.reams.db.dbb.definition.batchprm.fukajohotoroku;

import jp.co.ndensan.reams.db.dbb.definition.processprm.fukajohotoroku.FukaJohoHenshuProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
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
public class FukaJohoTorokuBatchParameter extends BatchParameterBase {

    @BatchParameter(key = "is当初処理", name = "is当初処理")
    private boolean is当初処理;

    /**
     * コンストラクタです。
     *
     * @param is当初処理 boolean
     */
    public FukaJohoTorokuBatchParameter(boolean is当初処理) {
        this.is当初処理 = is当初処理;
    }

    /**
     * processのパラメータを生成します。
     *
     * @return processパラメータ
     */
    public FukaJohoHenshuProcessParameter toFukaJohoHenshuProcessParameter() {
        return new FukaJohoHenshuProcessParameter(is当初処理);
    }
}
