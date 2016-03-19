/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanshikyuketteiin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 新番号の取得のMybatisパラメタてす。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShokanShikyuKetteiInMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final LasdecCode 市町村コード;
    private final HihokenshaNo 被保険者番号;

    private ShokanShikyuKetteiInMybatisParameter(
            IShikibetsuTaishoPSMSearchKey searchKey,
            @lombok.NonNull HihokenshaNo 被保険者番号,
            @lombok.NonNull LasdecCode 市町村コード) {
        super(searchKey);
        this.被保険者番号 = 被保険者番号;
        this.市町村コード = 市町村コード;
    }

    /**
     * 新番号の取得するパラメータ作成
     *
     * @param 被保険者番号 被保険者番号
     * @param 市町村コード 市町村コード
     * @return ShokanShikyuKetteiInMybatisParameter
     */
    public static ShokanShikyuKetteiInMybatisParameter createParameter(
            HihokenshaNo 被保険者番号,
            LasdecCode 市町村コード) {
        return new ShokanShikyuKetteiInMybatisParameter(null, 被保険者番号, 市町村コード);
    }

    /**
     * 市町村コード取得のパラメータ作成
     *
     * @param 被保険者番号 被保険者番号
     * @return ShokanShikyuKetteiInMybatisParameter
     */
    public static ShokanShikyuKetteiInMybatisParameter createParameter(HihokenshaNo 被保険者番号) {
        return new ShokanShikyuKetteiInMybatisParameter(null, 被保険者番号, LasdecCode.EMPTY);
    }

    /**
     * 識別コード取得のパラメータ作成
     *
     * @param searchKey 宛名識別対象key
     * @return ShokanShikyuKetteiInMybatisParameter
     */
    public static ShokanShikyuKetteiInMybatisParameter createParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        return new ShokanShikyuKetteiInMybatisParameter(searchKey, HihokenshaNo.EMPTY, LasdecCode.EMPTY);
    }
}
