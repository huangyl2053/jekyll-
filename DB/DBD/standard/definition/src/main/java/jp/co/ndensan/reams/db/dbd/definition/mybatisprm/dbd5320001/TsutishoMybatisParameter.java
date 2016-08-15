/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5320001;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.relate.futangendogakunintei.ShikibetsuTaishoPSMMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 通知書一括発行用のパラメータ
 *
 * @reamsid_L DBD-1430-020 lit
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TsutishoMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final FlexibleDate 発行日;
    private final boolean 単票発行済み;
    private final RString 出力順;
    private RString psmShikibetsuTaisho;

    /**
     * コンストラクスです。
     *
     * @param searchKey searchKey
     * @param 発行日 FlexibleDate
     * @param 単票発行済み Boolean
     * @param 出力順 RString
     */
    public TsutishoMybatisParameter(IShikibetsuTaishoPSMSearchKey searchKey,
            FlexibleDate 発行日, Boolean 単票発行済み, RString 出力順) {
        super(searchKey);
        this.発行日 = 発行日;
        this.単票発行済み = 単票発行済み;
        this.出力順 = 出力順;
        this.psmShikibetsuTaisho = new RString(new ShikibetsuTaishoPSMMybatisParameter(searchKey).toString());
    }

    /**
     * psmShikibetsuTaishoの設定
     *
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     */
    public void setPsmShikibetsuTaisho(RString psmShikibetsuTaisho) {
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }
}
