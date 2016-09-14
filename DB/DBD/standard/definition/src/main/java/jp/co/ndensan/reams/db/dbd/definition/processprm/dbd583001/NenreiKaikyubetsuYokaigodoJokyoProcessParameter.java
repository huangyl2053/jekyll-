/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd583001;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd583001.NenreiKaikyubetsuYokaigodoJokyoMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import lombok.Getter;
import lombok.Setter;

/**
 * 年齢階級別要介護度状況（統計表）のProcessパラメータクラスです。
 *
 * @reamsid_L DBD-1790-020 donghj
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenreiKaikyubetsuYokaigodoJokyoProcessParameter implements IBatchProcessParameter {

    private RDate 基準日;
    private RYearMonth 基準年月;
    private RString 地区区分;
    private Code 開始地区コード;
    private Code 終了地区コード;
    private RString 旧市町村コード;
    private RString 旧市町村名称;

    /**
     * コンストラクタです。
     *
     * @param 基準日 基準日
     * @param 基準年月 基準年月
     * @param 地区区分 地区区分
     * @param 開始地区コード 開始地区コード
     * @param 終了地区コード 終了地区コード
     * @param 旧市町村コード 旧市町村名称
     * @param 旧市町村名称 旧市町村名称
     */
    public NenreiKaikyubetsuYokaigodoJokyoProcessParameter(RDate 基準日, RYearMonth 基準年月, RString 地区区分,
            Code 開始地区コード, Code 終了地区コード, RString 旧市町村コード, RString 旧市町村名称) {
        this.基準日 = 基準日;
        this.基準年月 = 基準年月;
        this.地区区分 = 地区区分;
        this.開始地区コード = 開始地区コード;
        this.終了地区コード = 終了地区コード;
        this.旧市町村コード = 旧市町村コード;
        this.旧市町村名称 = 旧市町村名称;
    }

    /**
     * コンストラクタです。
     *
     * @param shikibetsuTaishoPSMSearchKey IShikibetsuTaishoPSMSearchKey
     * @return NenreiKaikyubetsuYokaigodoJokyoMybatisParameter
     */
    public NenreiKaikyubetsuYokaigodoJokyoMybatisParameter toNenreiKaikyubetsuYokaigodoJokyoMybatisParameter(
            IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey) {
        FlexibleDate 基準日1 = null;
        FlexibleDate 基準年月1 = null;
        if (基準日 != null) {
            基準日1 = new FlexibleDate(基準日.toDateString());
        }
        if (基準年月 != null) {
            基準年月1 = new FlexibleDate(基準年月.toDateString());
        }
        return new NenreiKaikyubetsuYokaigodoJokyoMybatisParameter(基準日1, 基準年月1,
                地区区分, 開始地区コード, 終了地区コード,
                旧市町村コード, shikibetsuTaishoPSMSearchKey);
    }

}
