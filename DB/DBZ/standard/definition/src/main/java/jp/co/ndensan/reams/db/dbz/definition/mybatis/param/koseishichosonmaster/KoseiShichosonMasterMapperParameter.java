/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatis.param.koseishichosonmaster;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 構成市町村マスタを特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class KoseiShichosonMasterMapperParameter {

    private final LasdecCode shichonCode;

    private final boolean usesshichonCode;

    /**
     * コンストラクタです。
     *
     * @param shichonCode shichonCode
     * @param usesshichonCode usesshichonCode
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private KoseiShichosonMasterMapperParameter(
            @lombok.NonNull LasdecCode shichonCode,
            boolean usesshichonCode) {

        this.shichonCode = shichonCode;

        this.usesshichonCode = usesshichonCode;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shichonCode shichonCode
     * @param usesshichonCode usesshichonCode
     * @return 身体手帳検索パラメータ
     */
    public static KoseiShichosonMasterMapperParameter createSelectByKeyParam(
            LasdecCode shichonCode,
            boolean usesshichonCode) {
        return new KoseiShichosonMasterMapperParameter(shichonCode, usesshichonCode);
    }

}
