/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.hiroshimadomain;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 広域内転居結果一覧表のバッチのパラメータです
 *
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class HiroshimaDomainMybatisParameter extends UaFt200FindShikibetsuTaishoParam
        implements IMyBatisParameter {

    private final LasdecCode 市町村コード;
    private final RString 市町村名称;
    private final FlexibleDate 日付From;
    private final FlexibleDate 日付To;

    /**
     * コンストラクタです
     *
     * @param searchKey searchKey
     * @param 市町村コード 市町村コード
     * @param 市町村名称 市町村名称
     * @param 日付From 日付From
     * @param 日付To 日付To
     */
    public HiroshimaDomainMybatisParameter(
            LasdecCode 市町村コード,
            RString 市町村名称,
            FlexibleDate 日付From,
            FlexibleDate 日付To,
            IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
        this.日付From = 日付From;
        this.日付To = 日付To;
    }

    /**
     * コンストラクタです
     *
     * @param searchKey searchKey
     * @param 市町村コード 市町村コード
     * @param 市町村名称 市町村名称
     * @param 日付From 日付From
     * @param 日付To 日付To
     * @return HiroshimaDomainMybatisParameter
     */
    public static HiroshimaDomainMybatisParameter createSelectByKeyParam(
            LasdecCode 市町村コード,
            RString 市町村名称,
            FlexibleDate 日付From,
            FlexibleDate 日付To,
            IShikibetsuTaishoPSMSearchKey searchKey) {

        return new HiroshimaDomainMybatisParameter(市町村コード, 市町村名称, 日付From, 日付To, searchKey);
    }

}
