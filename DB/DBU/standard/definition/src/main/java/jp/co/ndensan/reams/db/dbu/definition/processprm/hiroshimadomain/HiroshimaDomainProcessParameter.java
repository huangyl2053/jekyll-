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
 * 広域内転居結果一覧表のバッチのパラメータです
 *
 * @reamsid_L DBU-1150-020 chenaoqi
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
    private static final RString INDEX = new RString("000000");

    /**
     * コンストラクタ
     *
     * @param 市町村コード 市町村コード
     * @param 市町村名称 市町村名称
     * @param 日付From 日付From
     * @param 日付To 日付To
     * @param 宛名検索条件 IShikibetsuTaishoPSMSearchKey
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

    /**
     * mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public HiroshimaDomainMybatisParameter toIHiroshimaDomainMybatisParameter() {
        return new HiroshimaDomainMybatisParameter(INDEX.equals(市町村コード.value()) ? null : 市町村コード.value(),
                市町村名称,
                日付From == null || 日付From.isEmpty() ? null : 日付From,
                日付To == null || 日付To.isEmpty() ? null : 日付To,
                宛名検索条件);

    }
}
