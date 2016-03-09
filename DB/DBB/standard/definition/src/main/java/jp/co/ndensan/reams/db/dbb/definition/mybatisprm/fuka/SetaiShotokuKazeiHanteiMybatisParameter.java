/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 世帯把握（バッチ）のバッチのパラメータです
 *
 * @author chenaoqi
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SetaiShotokuKazeiHanteiMybatisParameter implements IMyBatisParameter {

    private final RString 管理識別区分;

    /**
     * コンストラクタです
     *
     * @param 管理識別区分 RString
     */
    SetaiShotokuKazeiHanteiMybatisParameter(RString 管理識別区分) {
        this.管理識別区分 = 管理識別区分;
    }

    /**
     * コンストラクタです
     *
     * @param 管理識別区分 RString
     * @return
     */
    public static SetaiShotokuKazeiHanteiMybatisParameter createSelectByKeyParam(RString 管理識別区分) {
        return new SetaiShotokuKazeiHanteiMybatisParameter(管理識別区分);
    }
}
