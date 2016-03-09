/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.fuka;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka.SetaiShotokuKazeiHanteiMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 世帯把握（バッチ）のバッチのパラメータです
 *
 * @author chenaoqi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class SetaiShotokuKazeiHanteiProcessParameter implements IBatchProcessParameter {

    private RString 管理識別区分;

    /**
     * コンストラクタ
     *
     * @param 管理識別区分 RString
     */
    public SetaiShotokuKazeiHanteiProcessParameter(RString 管理識別区分) {
        this.管理識別区分 = 管理識別区分;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public SetaiShotokuKazeiHanteiMybatisParameter toSetaiShotokuKazeiHanteiMybatisParameter() {
        return SetaiShotokuKazeiHanteiMybatisParameter.createSelectByKeyParam(管理識別区分);

    }

}
