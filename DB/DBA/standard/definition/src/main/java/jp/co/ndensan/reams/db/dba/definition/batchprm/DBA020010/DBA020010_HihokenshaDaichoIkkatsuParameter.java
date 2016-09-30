/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.batchprm.DBA020010;

import jp.co.ndensan.reams.db.dba.definition.processprm.dba020010.IkkatsuSusakuseiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者台帳一括作成のバッチのパラメータです
 *
 * @reamsid_L DBA-0510-010 duanzhanli
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DBA020010_HihokenshaDaichoIkkatsuParameter extends BatchParameterBase {

    private static final String KEY_CHUSHUTSUFLAG = "chushutsuFlag";
    private static final String KEY_SHUTSURYOKUFLAG = "shutsuryokuFlag";
    private static final String KEY_SHUTSURYOKUJUN_ID = "shutsuryokujunId";
    private static final String KEY_LOGINUSER_ID = "loginUserId";

    @BatchParameter(key = KEY_CHUSHUTSUFLAG, name = "資格喪失者抽出フラグ")
    private boolean chushutsuFlag;
    @BatchParameter(key = KEY_SHUTSURYOKUFLAG, name = "出力フラグ")
    private boolean shutsuryokuFlag;
    @BatchParameter(key = KEY_SHUTSURYOKUJUN_ID, name = "出力順ID")
    private Long shutsuryokujunId;
    @BatchParameter(key = KEY_LOGINUSER_ID, name = "登録ユーザーID")
    private RString loginUserId;

    /**
     * コンストラクタです。<br/>
     *
     * @param chushutsuFlag 資格喪失者抽出フラグ
     * @param shutsuryokuFlag 出力フラグ
     * @param shutsuryokujunId 出力順ID
     * @param loginUserId 登録ユーザーID
     */
    public DBA020010_HihokenshaDaichoIkkatsuParameter(boolean chushutsuFlag,
            boolean shutsuryokuFlag,
            Long shutsuryokujunId,
            RString loginUserId) {
        this.chushutsuFlag = chushutsuFlag;
        this.shutsuryokuFlag = shutsuryokuFlag;
        this.shutsuryokujunId = shutsuryokujunId;
        this.loginUserId = loginUserId;
    }

    /**
     * コンストラクタです。<br/>
     *
     */
    public DBA020010_HihokenshaDaichoIkkatsuParameter() {
    }

    /**
     * processのパラメータを生成します。
     *
     * @return processパラメータ
     */
    public IkkatsuSusakuseiProcessParameter toIkkatsuHakkoProcessParameter() {
        return new IkkatsuSusakuseiProcessParameter(chushutsuFlag, shutsuryokuFlag, shutsuryokujunId, loginUserId);
    }
}
