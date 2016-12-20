/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiiryokikanjohomaster;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 主治医医療機関情報を特定するためのMyBatis用パラメータクラスです。
 * @reamsid_L DBE-0240-010 dongyabin
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class KoseiShujiiIryoKikanMasterSearchParameter {

    private final LasdecCode 市町村コード;
    private final ShujiiIryokikanCode 主治医医療機関コード;

    private KoseiShujiiIryoKikanMasterSearchParameter(
            LasdecCode 市町村コード,
            ShujiiIryokikanCode 主治医医療機関コード) {
        this.市町村コード = 市町村コード;
        this.主治医医療機関コード = 主治医医療機関コード;
    }

    /**
     * 検索用のパラメータを生成します。
     *
     * @param 市町村コード 市町村コード
     * @param 主治医医療機関コード 主治医医療機関コード
     *
     * @return 主治医医療機関情報パラメータ
     */
    public static KoseiShujiiIryoKikanMasterSearchParameter createParam_SelectShujiiIryoKikanJoho(
            LasdecCode 市町村コード,
            ShujiiIryokikanCode 主治医医療機関コード
    ) {
        return new KoseiShujiiIryoKikanMasterSearchParameter(
                市町村コード, 主治医医療機関コード);
    }
}
