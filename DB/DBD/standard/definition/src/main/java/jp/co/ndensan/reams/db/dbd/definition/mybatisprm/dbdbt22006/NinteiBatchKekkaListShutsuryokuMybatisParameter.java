/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbdbt22006;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担限度額認定申請一括承認（バッチ）_結果一覧出力MyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-3710-040 chenxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiBatchKekkaListShutsuryokuMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private IShikibetsuTaishoPSMSearchKey searchKey;
    private RString 出力順;
    private FlexibleDate 認定期間_開始日;
    private FlexibleDate 認定期間_終了日;

    /**
     * コンストラクタです。
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param 出力順 RString
     * @param 認定期間_開始日 認定期間_開始日
     * @param 認定期間_終了日 認定期間_終了日
     */
    public NinteiBatchKekkaListShutsuryokuMybatisParameter(
            IShikibetsuTaishoPSMSearchKey searchKey,
            RString 出力順,
            FlexibleDate 認定期間_開始日,
            FlexibleDate 認定期間_終了日) {
        super(searchKey);
        this.出力順 = 出力順;
        this.認定期間_開始日 = 認定期間_開始日;
        this.認定期間_終了日 = 認定期間_終了日;
    }

}
