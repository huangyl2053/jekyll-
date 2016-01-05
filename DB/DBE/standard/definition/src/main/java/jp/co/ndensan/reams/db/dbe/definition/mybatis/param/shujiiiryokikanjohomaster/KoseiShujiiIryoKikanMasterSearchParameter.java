/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shujiiiryokikanjohomaster;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 主治医医療機関情報を特定するためのMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class KoseiShujiiIryoKikanMasterSearchParameter {

    private final LasdecCode 市町村コード;
    private final ShujiiIryokikanCode 主治医医療機関コード;

    private KoseiShujiiIryoKikanMasterSearchParameter(
            LasdecCode 市町村コード,
            ShujiiIryokikanCode 主治医医療機関コード) {
        this.市町村コード = 市町村コード;
        this.主治医医療機関コード = 主治医医療機関コード;
    }

    public static KoseiShujiiIryoKikanMasterSearchParameter createParam_SelectShujiiIryoKikanJoho(
            LasdecCode 市町村コード,
            ShujiiIryokikanCode 主治医医療機関コード
    ) {
        return new KoseiShujiiIryoKikanMasterSearchParameter(
                市町村コード, 主治医医療機関コード);
    }

}
