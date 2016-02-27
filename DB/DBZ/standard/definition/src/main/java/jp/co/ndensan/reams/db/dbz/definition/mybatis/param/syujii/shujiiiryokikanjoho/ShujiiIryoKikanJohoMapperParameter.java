/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatis.param.syujii.shujiiiryokikanjoho;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 主治医医療機関情報を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShujiiIryoKikanJohoMapperParameter {

    private final LasdecCode shichosonCode;
    private final ShujiiIryokikanCode shujiiIryokikanCode;

    /**
     * コンストラクタです。
     *
     * @param shichosonCode LasdecCode
     * @param shujiiIryokikanCode RString
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private ShujiiIryoKikanJohoMapperParameter(
            LasdecCode shichosonCode,
            ShujiiIryokikanCode shujiiIryokikanCode) {

        this.shichosonCode = shichosonCode;
        this.shujiiIryokikanCode = shujiiIryokikanCode;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shichosonCode LasdecCode
     * @param shujiiIryokikanCode RString
     * @return 主治医医療機関情報検索パラメータ
     */
    public static ShujiiIryoKikanJohoMapperParameter createSelectByKeyParam(
            LasdecCode shichosonCode,
            ShujiiIryokikanCode shujiiIryokikanCode) {
        return new ShujiiIryoKikanJohoMapperParameter(shichosonCode, shujiiIryokikanCode);
    }
}
