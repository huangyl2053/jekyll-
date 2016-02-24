/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyuikkatushinsa;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 福祉用具購入費支給申請一括審査・決定パラメータ
 *
 * @author 陳奥奇
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanFukushiYoguHanbaihiParameter extends UaFt200FindShikibetsuTaishoParam {

    private final FlexibleDate 支給申請日From;
    private final FlexibleDate 支給申請日To;

    /**
     * コンストラクタです。
     *
     * @param searchKey 宛名検索条件
     * @param 支給申請日From 支給申請日From
     * @param 支給申請日To 支給申請日To
     */
    public ShokanFukushiYoguHanbaihiParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            FlexibleDate 支給申請日From, FlexibleDate 支給申請日To) {
        super(searchKey);
        this.支給申請日From = 支給申請日From;
        this.支給申請日To = 支給申請日To;
    }

    /**
     * コンストラクタです
     *
     * @param searchKey 宛名検索条件
     * @param 支給申請日From 支給申請日From
     * @param 支給申請日To 支給申請日To
     * @return 福祉用具購入費支給申請一括審査・決定パラメータ
     */
    public static ShokanFukushiYoguHanbaihiParameter createSelectByKeyParam(IShikibetsuTaishoPSMSearchKey searchKey,
            FlexibleDate 支給申請日From, FlexibleDate 支給申請日To) {

        return new ShokanFukushiYoguHanbaihiParameter(searchKey, 支給申請日From, 支給申請日To);
    }

}
