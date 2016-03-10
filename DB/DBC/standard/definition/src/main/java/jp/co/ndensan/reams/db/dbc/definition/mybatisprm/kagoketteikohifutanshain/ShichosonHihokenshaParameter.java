/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kagoketteikohifutanshain;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 新被保険者番号一時テーブルに対するMapperパラメータ
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShichosonHihokenshaParameter {

    private final LasdecCode 市町村コード;
    private final HihokenshaNo 被保険者番号;

    private ShichosonHihokenshaParameter(
            @lombok.NonNull HihokenshaNo 被保険者番号,
            @lombok.NonNull LasdecCode 市町村コード) {
        this.被保険者番号 = 被保険者番号;
        this.市町村コード = 市町村コード;
    }

    /**
     * 新被保険者番号を取得するパラメータ作成
     *
     * @param 被保険者番号 被保険者番号
     * @param 市町村コード 市町村コード
     * @return ShichosonHihokenshaParameter
     */
    public static ShichosonHihokenshaParameter createParameter(
            HihokenshaNo 被保険者番号,
            LasdecCode 市町村コード) {
        return new ShichosonHihokenshaParameter(被保険者番号, 市町村コード);
    }

    /**
     * 市町村コード取得のパラメータ作成
     *
     * @param 被保険者番号 被保険者番号
     * @return ShichosonHihokenshaParameter
     */
    public static ShichosonHihokenshaParameter createParameter(HihokenshaNo 被保険者番号) {
        return new ShichosonHihokenshaParameter(被保険者番号, LasdecCode.EMPTY);
    }
}
