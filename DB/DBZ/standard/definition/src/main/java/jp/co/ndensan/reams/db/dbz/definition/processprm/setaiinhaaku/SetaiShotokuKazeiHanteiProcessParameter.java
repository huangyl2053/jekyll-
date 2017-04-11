/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.processprm.setaiinhaaku;

import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.fuka.SetaiHaakuMybatisParameter;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.fuka.SetaiShotokuKazeiHanteiMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 世帯把握（バッチ）のバッチのパラメータです
 *
 * @reamsid_L DBB-0640-010 chenaoqi
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
        return new SetaiShotokuKazeiHanteiMybatisParameter(管理識別区分);
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @param searchKey
     * @return mybatisパラメータ
     */
    public SetaiHaakuMybatisParameter toSetaiHaakuMybatisParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        return new SetaiHaakuMybatisParameter(searchKey);
    }

}
