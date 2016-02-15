/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyushisei;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * @author chenaoqi
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanFukushiYoguHanbaihiParameter extends UaFt200FindShikibetsuTaishoParam {

    private final FlexibleDate 支給申請日From;
    private final FlexibleDate 支給申請日To;

    /**
     * コンストラクタです。
     *
     * @param searchKey
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
     * @param searchKey
     * @param 支給申請日From 支給申請日From
     * @param 支給申請日To 支給申請日To
     * @return 償還払申請一覧検索パラメータ
     */
    public static ShokanFukushiYoguHanbaihiParameter createSelectByKeyParam(IShikibetsuTaishoPSMSearchKey searchKey,
            FlexibleDate 支給申請日From, FlexibleDate 支給申請日To) {

        return new ShokanFukushiYoguHanbaihiParameter(searchKey, 支給申請日From, 支給申請日To);
    }

}
