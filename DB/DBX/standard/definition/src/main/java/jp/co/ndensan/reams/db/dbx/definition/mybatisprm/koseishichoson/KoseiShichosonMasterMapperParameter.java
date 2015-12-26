/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.mybatisprm.koseishichoson;

import jp.co.ndensan.reams.db.dbx.definition.core.koseishichoson.ShichosonShikibetsuID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 構成市町村マスタを特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KoseiShichosonMasterMapperParameter {

    private final ShichosonShikibetsuID shichosonShikibetsuId;
    private LasdecCode shichonCode;
    private boolean usesshichonCode;

    /**
     * コンストラクタです。
     * KoseiShichosonMasterMapperParameter
     *
     *
     * @param shichosonShikibetsuId 市町村識別ID
     * @param shichonCode 市町村コード
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private KoseiShichosonMasterMapperParameter(
            @lombok.NonNull ShichosonShikibetsuID shichosonShikibetsuId,
            @lombok.NonNull LasdecCode shichonCode
    ) {
        this.shichosonShikibetsuId = shichosonShikibetsuId;
        this.shichonCode = shichonCode;
        this.usesshichonCode = !shichonCode.isEmpty();
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 市町村識別ID 市町村識別ID
     * @return 身体手帳検索パラメータ
     */
    public static KoseiShichosonMasterMapperParameter createSelectByKeyParam(
            @lombok.NonNull RString 市町村識別ID) {
        return new KoseiShichosonMasterMapperParameter(
                new ShichosonShikibetsuID(市町村識別ID), LasdecCode.EMPTY);
    }

    /**
     * getshichonCode
     *
     * @return shichonCode
     */
    public LasdecCode getshichonCode() {
        return shichonCode;
    }

    /**
     * getusesshichonCode
     *
     * @return shichonCode
     */
    public boolean isusesshichonCode() {
        return usesshichonCode;
    }
}
