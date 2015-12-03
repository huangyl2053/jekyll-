/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.syujii.shujiiiryokikanjoho;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医医療機関情報を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class ShujiiIryoKikanJohoMapperParameter {

    private final LasdecCode shichosonCode;
    private final RString shujiiIryokikanCode;

    /**
     * コンストラクタです。
     *
     * @param shichosonCode LasdecCode
     * @param shujiiIryokikanCode RString
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private ShujiiIryoKikanJohoMapperParameter(
            LasdecCode shichosonCode,
            RString shujiiIryokikanCode) {

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
            RString shujiiIryokikanCode) {
        return new ShujiiIryoKikanJohoMapperParameter(shichosonCode, shujiiIryokikanCode);
    }
}
