/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.futanwariaishohakko;

import jp.co.ndensan.reams.ua.uax.definition.core.KensakuYoShikibetsuCode;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 負担割合証発行（一括）のMybatisパラメータクラスです。
 *
 * @reamsid_L DBC-4990-030 pengxingyi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanwariaishoHakkoMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final IAtesakiPSMSearchKey atesakiKey;
    private final GyomuCode uaft250_gyomuCode;
    private final SubGyomuCode uaft250_subGyomuCode;
    private final KamokuCode uaft250_kamokuCode;
    private final boolean uaft250_gyomuKoyuKeyRiyoFlag;
    private final RString uaft250_gyomuKoyuKey;
    private final RString uaft250_shikibetsuCode;
    private final boolean uaft250_isUseTableColumn;
    private final boolean uaft250_sofusakiRiyoFlag;
    private final boolean uaft250_dainoRiyoFlag;
    private final boolean uaft250_setaiNushiRiyoFlag;
    private final boolean uaft250_daihyoshaRiyokuFlag;
    private final FlexibleDate uaft250_kijunYMD;
    private final KensakuYoShikibetsuCode tmp_shikibetsuCode;

    private FlexibleYear 年度;
    private RDate 交付年月日;
    private RString 発行区分;
    private RString 出力対象;
    private RDateTime 抽出期間開始日時;
    private RDateTime 抽出期間終了日時;
    private RString 出力順;

    /**
     * インスタンスを生成します。
     *
     * @param atesakiKey atesakiKey
     * @param 年度 年度
     * @param 交付年月日 交付年月日
     * @param 発行区分 発行区分
     * @param 出力対象 出力対象
     * @param 抽出期間開始日時 抽出期間開始日時
     * @param 抽出期間終了日時 抽出期間終了日時
     * @param 出力順 出力順
     * @param searchKey searchKey
     */
    public FutanwariaishoHakkoMybatisParameter(IAtesakiPSMSearchKey atesakiKey, FlexibleYear 年度, RDate 交付年月日,
            RString 発行区分, RString 出力対象, RDateTime 抽出期間開始日時, RDateTime 抽出期間終了日時,
            RString 出力順, IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
        this.atesakiKey = atesakiKey;
        this.uaft250_gyomuCode = atesakiKey.get業務判定キー().get業務コード();
        this.uaft250_subGyomuCode = atesakiKey.get業務判定キー().getサブ業務コード();
        this.uaft250_kamokuCode = atesakiKey.get業務判定キー().get科目コード();
        this.uaft250_gyomuKoyuKeyRiyoFlag = atesakiKey.get業務固有キー利用区分().isGyomuKoyuKeyRiyo();
        this.uaft250_gyomuKoyuKey = atesakiKey.get業務判定キー().get業務固有キー();
        this.tmp_shikibetsuCode = atesakiKey.get識別コード();
        this.uaft250_shikibetsuCode = tmp_shikibetsuCode.getColumnValue();
        this.uaft250_isUseTableColumn = tmp_shikibetsuCode.isUseTableColumn();
        this.uaft250_sofusakiRiyoFlag = atesakiKey.get送付先利用区分().isSofusakiRiyo();
        this.uaft250_dainoRiyoFlag = atesakiKey.get代納人利用区分().isDainoRiyo();
        this.uaft250_setaiNushiRiyoFlag = atesakiKey.get世帯主利用区分().isSetainushiRiyo();
        this.uaft250_daihyoshaRiyokuFlag = atesakiKey.get法人代表者利用区分().isHojinDaihyoshaRiyo();
        this.uaft250_kijunYMD = atesakiKey.get基準日();
        this.年度 = 年度;
        this.交付年月日 = 交付年月日;
        this.発行区分 = 発行区分;
        this.出力対象 = 出力対象;
        this.抽出期間開始日時 = 抽出期間開始日時;
        this.抽出期間終了日時 = 抽出期間終了日時;
        this.出力順 = 出力順;
    }

}
