/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jutakukaishusikyushinseiikkatushinsa;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 未審査支給申請一覧取得用MyBatisパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class MiShinasaShikyuShinseiParameter extends UaFt200FindShikibetsuTaishoParam {

    private final FlexibleDate 支給申請開始日;
    private final FlexibleDate 支給申請終了日;

    /**
     * コンストラクタです。
     *
     * @param searchKey
     * @param 支給申請開始日
     * @param 支給申請終了日
     */
    public MiShinasaShikyuShinseiParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            FlexibleDate 支給申請開始日,
            FlexibleDate 支給申請終了日) {
        super(searchKey);
        this.支給申請開始日 = 支給申請開始日;
        this.支給申請終了日 = 支給申請終了日;
    }

    /**
     * コンストラクタです。
     *
     * @param searchKey
     * @param 支給申請開始日
     * @param 支給申請終了日
     * @return
     */
    public static MiShinasaShikyuShinseiParameter
            createSelectByKeyParam(IShikibetsuTaishoPSMSearchKey searchKey,
                    FlexibleDate 支給申請開始日,
                    FlexibleDate 支給申請終了日) {
        return new MiShinasaShikyuShinseiParameter(searchKey, 支給申請開始日, 支給申請終了日);
    }
}
