/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU050020;

import jp.co.ndensan.reams.db.dbu.definition.processprm.hiroshimadomain.HiroshimaDomainProcessParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
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
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBU050020_KoikinaiTenkyoKekkaIchiranhyoParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;
    @BatchParameter(key = "市町村コード", name = "市町村コード")
    private LasdecCode 市町村コード;
    @BatchParameter(key = "市町村名称", name = "市町村名称")
    private RString 市町村名称;
    @BatchParameter(key = "日付From", name = "日付From")
    private FlexibleDate 日付From;
    @BatchParameter(key = "日付To", name = "日付To")
    private FlexibleDate 日付To;
    private IShikibetsuTaishoPSMSearchKey 宛名検索条件;

    /**
     * コンストラクタです。
     *
     */
    public DBU050020_KoikinaiTenkyoKekkaIchiranhyoParameter() {

    }

    /**
     * コンストラクタです。
     *
     * @param 市町村コード 市町村コード
     * @param 市町村名称 市町村名称
     * @param 日付From 日付From
     * @param 日付To 日付To
     * @param 宛名検索条件 IShikibetsuTaishoPSMSearchKey
     */
    public DBU050020_KoikinaiTenkyoKekkaIchiranhyoParameter(LasdecCode 市町村コード,
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
     * processのパラメータを生成します。
     *
     * @return processパラメータ
     */
    public HiroshimaDomainProcessParameter toHiroshimaDomainProcessParameter() {
        return new HiroshimaDomainProcessParameter(市町村コード, 市町村名称, 日付From, 日付To, 宛名検索条件);
    }
}
