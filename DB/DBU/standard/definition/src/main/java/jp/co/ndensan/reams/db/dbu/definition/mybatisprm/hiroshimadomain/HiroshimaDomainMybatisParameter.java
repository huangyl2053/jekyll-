/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.hiroshimadomain;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 広域内転居結果一覧表のバッチのパラメータです
 *
 * @reamsid_L DBU-1150-020 chenaoqi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HiroshimaDomainMybatisParameter extends UaFt200FindShikibetsuTaishoParam
        implements IMyBatisParameter {

    private final RString 市町村コード;
    private final RString 市町村名称;
    private final FlexibleDate 日付From;
    private final FlexibleDate 日付To;

    /**
     * コンストラクタです
     *
     * @param 市町村コード 市町村コード
     * @param 市町村名称 市町村名称
     * @param 日付From 日付From
     * @param 日付To 日付To
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     */
    public HiroshimaDomainMybatisParameter(
            RString 市町村コード,
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
}
