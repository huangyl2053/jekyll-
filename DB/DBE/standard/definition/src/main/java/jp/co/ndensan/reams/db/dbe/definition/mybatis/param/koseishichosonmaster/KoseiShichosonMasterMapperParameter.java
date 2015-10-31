/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.koseishichosonmaster;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 構成市町村マスタを特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class KoseiShichosonMasterMapperParameter {

    private final RString shichosonShokibetsuID;
    private final LasdecCode shichosonCode;

    /**
     * コンストラクタです。
     *
     * @param RString shichosonShokibetsuID
     * @param LasdecCode shichosonCode
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private KoseiShichosonMasterMapperParameter(
            RString shichosonShokibetsuID,
            LasdecCode shichosonCode) {

        this.shichosonShokibetsuID = shichosonShokibetsuID;
        this.shichosonCode = shichosonCode;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param RString shichosonShokibetsuID
     * @param LasdecCode shichosonCode
     * @return 身体手帳検索パラメータ
     */
    public static KoseiShichosonMasterMapperParameter createSelectByKeyParam(
            RString shichosonShokibetsuID,
            LasdecCode shichosonCode) {
        return new KoseiShichosonMasterMapperParameter(shichosonShokibetsuID, shichosonCode);
    }

}
