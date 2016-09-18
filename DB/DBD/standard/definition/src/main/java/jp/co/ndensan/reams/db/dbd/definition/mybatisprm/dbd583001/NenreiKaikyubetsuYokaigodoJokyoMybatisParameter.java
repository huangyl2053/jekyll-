/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd583001;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年齢階級別要介護度状況（統計表）(バッチ)SQLのパラメータクラス
 *
 * @reamsid_L DBD-1790-020 donghj
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenreiKaikyubetsuYokaigodoJokyoMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final FlexibleDate 基準日;
    private final FlexibleDate 基準年月;
    private final RString 地区区分;
    private final Code 開始地区コード;
    private final Code 終了地区コード;
    private final RString 旧市町村コード;
    private final UaFt200FindShikibetsuTaishoParam psmShikibetsuTaisho;

    private final boolean is住所;
    private final boolean is行政区;
    private final boolean is組合;
    private boolean has基準日;
    private boolean has基準年月;
    private boolean has開始地区コード;
    private boolean has終了地区コード;
    private boolean has旧市町村コード;

    /**
     * コンストラクタです。
     *
     * @param 基準日 基準日
     * @param 基準年月 基準年月
     * @param 地区区分 地区区分
     * @param 開始地区コード 開始地区コード
     * @param 終了地区コード 終了地区コード
     * @param 旧市町村コード 旧市町村コード
     * @param shikibetsuTaishoPSMSearchKey 宛名識別対象PSM検索キー
     */
    public NenreiKaikyubetsuYokaigodoJokyoMybatisParameter(FlexibleDate 基準日, FlexibleDate 基準年月,
            RString 地区区分, Code 開始地区コード, Code 終了地区コード, RString 旧市町村コード,
            IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey) {
        super(shikibetsuTaishoPSMSearchKey);
        this.基準日 = 基準日;
        this.基準年月 = 基準年月;
        this.旧市町村コード = 旧市町村コード;
        this.地区区分 = 地区区分;
        this.開始地区コード = 開始地区コード;
        this.終了地区コード = 終了地区コード;
        this.is住所 = new RString("JUSHO").equals(地区区分);
        this.is行政区 = new RString("GYOSEIKU").equals(地区区分);
        this.is組合 = new RString("CHIKU2").equals(地区区分);

        if (基準日 != null) {
            this.has基準日 = true;
        }
        if (基準年月 != null) {
            this.has基準年月 = true;
        }
        if (開始地区コード != null && !開始地区コード.isEmpty()) {
            this.has開始地区コード = true;
        }
        if (終了地区コード != null && !終了地区コード.isEmpty()) {
            this.has終了地区コード = true;
        }
        if (旧市町村コード != null && !旧市町村コード.isEmpty()) {
            this.has旧市町村コード = true;
        }

        this.psmShikibetsuTaisho = new UaFt200FindShikibetsuTaishoParam(shikibetsuTaishoPSMSearchKey);

    }

}
