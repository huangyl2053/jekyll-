package jp.co.ndensan.reams.db.dbb.definition.processprm.fukajohotoroku;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import lombok.Getter;
import lombok.Setter;

/**
 * 賦課の情報を一括登録するバッチデータ作成用Processパラメータです。
 *
 * @reamsid_L DBB-9040-070 wangxiaodong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaJohoHenshuProcessParameter implements IBatchProcessParameter {

    private boolean is当初処理;

    /**
     * コンストラクタ
     *
     * @param is当初処理 boolean
     */
    public FukaJohoHenshuProcessParameter(boolean is当初処理) {
        this.is当初処理 = is当初処理;
    }
}
