/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.processprm.hiroshimadomain;

import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.hiroshimadomain.HiroshimaDomainMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author chenaoqi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HiroshimaDomainProcessParameter implements IBatchProcessParameter {

    private LasdecCode 市町村コード;
    private RString 市町村名称;
    private FlexibleDate 日付From;
    private FlexibleDate 日付To;
    private IShikibetsuTaishoPSMSearchKey 宛名検索条件;

    /**
     *
     * @param 宛名検索条件
     * @param 市町村コード
     * @param 市町村名称
     * @param 日付From
     * @param 日付To
     */
    public HiroshimaDomainProcessParameter(
            LasdecCode 市町村コード,
            RString 市町村名称,
            FlexibleDate 日付From,
            FlexibleDate 日付To,
            IShikibetsuTaishoPSMSearchKey 宛名検索条件) {

        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
        this.日付From = 日付From;
        this.日付To = 日付To;
        this.宛名検索条件 = 宛名検索条件;
    }

    public HiroshimaDomainMybatisParameter toIHiroshimaDomainMybatisParameter() {
        return HiroshimaDomainMybatisParameter.createSelectByKeyParam(市町村コード, 市町村名称, 日付From, 日付To, 宛名検索条件);

    }

}
