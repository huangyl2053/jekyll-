/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.batchprm.fuka;

import jp.co.ndensan.reams.db.dbz.definition.processprm.fuka.SetaiShotokuKazeiHanteiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 世帯把握（バッチ）のバッチのパラメータです
 *
 * @reamsid_L DBB-0640-010 chenaoqi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SetaiShotokuKazeiHanteiBatchParameter extends BatchParameterBase {

    @BatchParameter(key = "管理識別区分", name = "管理識別区分")
    private RString 管理識別区分;

    /**
     * コンストラクタです。
     *
     * @param 管理識別区分 RString
     */
    public SetaiShotokuKazeiHanteiBatchParameter(RString 管理識別区分) {
        this.管理識別区分 = 管理識別区分;
    }

    /**
     * processのパラメータを生成します。
     *
     * @return processパラメータ
     */
    public SetaiShotokuKazeiHanteiProcessParameter toSetaiShotokuKazeiHanteiProcessParameter() {
        return new SetaiShotokuKazeiHanteiProcessParameter(管理識別区分);
    }

}
