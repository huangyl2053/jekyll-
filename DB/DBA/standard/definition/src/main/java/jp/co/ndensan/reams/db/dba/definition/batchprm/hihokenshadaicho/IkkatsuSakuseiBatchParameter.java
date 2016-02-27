/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.batchprm.hihokenshadaicho;

import jp.co.ndensan.reams.db.dba.definition.processprm.hihokenshadaicho.IkkatsuSusakuseiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証一括発行のバッチのパラメータです
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class IkkatsuSakuseiBatchParameter extends BatchParameterBase {

    private static final String KEY_CHUSHUTSUFLAG = "chushutsuFlag";
    private static final String KEY_SHUTSURYOKUFLAG = "shutsuryokuFlag";
    private static final String KEY_SHUTSURYOKUJUN_ID = "shutsuryokujunId";

    @BatchParameter(key = KEY_CHUSHUTSUFLAG, name = "資格喪失者抽出フラグ")
    private boolean chushutsuFlag;
    @BatchParameter(key = KEY_SHUTSURYOKUFLAG, name = "出力フラグ")
    private boolean shutsuryokuFlag;
    @BatchParameter(key = KEY_SHUTSURYOKUJUN_ID, name = "出力順ID")
    private RString shutsuryokujunId;

    /**
     * コンストラクタです。<br/>
     *
     * @param chushutsuFlag 資格喪失者抽出フラグ
     * @param shutsuryokuFlag 出力フラグ
     * @param shutsuryokujunId 出力順ID
     *
     */
    public IkkatsuSakuseiBatchParameter(boolean chushutsuFlag,
            boolean shutsuryokuFlag,
            RString shutsuryokujunId) {
        this.chushutsuFlag = chushutsuFlag;
        this.shutsuryokuFlag = shutsuryokuFlag;
        this.shutsuryokujunId = shutsuryokujunId;
    }

    /**
     * processのパラメータを生成します。
     *
     * @return processパラメータ
     */
    public IkkatsuSusakuseiProcessParameter toIkkatsuHakkoProcessParameter() {
        return new IkkatsuSusakuseiProcessParameter(chushutsuFlag, shutsuryokuFlag, shutsuryokujunId);
    }
}
