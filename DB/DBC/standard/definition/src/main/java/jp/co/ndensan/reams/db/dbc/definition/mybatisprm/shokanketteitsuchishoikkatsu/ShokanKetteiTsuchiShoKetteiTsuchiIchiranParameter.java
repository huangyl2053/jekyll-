/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu;

import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払い支給（不支給）決定通知書一括作成_決定通知一覧表帳票データ取得のMyBatisパラメータクラスです。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShokanKetteiTsuchiShoKetteiTsuchiIchiranParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final RString 出力順;
    private final boolean has出力順;
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
    private final List<ShikibetsuCode> uaft250_shikibetsuCodeList;
    private final FlexibleDate uaft250_kijunYMD;
    private final RString 資格区分;
    private final UaFt200FindShikibetsuTaishoParam shikibetsutaishoParam;

    /**
     * コンストラクタです。
     *
     * @param has出力順 出力順存在かどうか
     * @param 出力順 出力順
     * @param psmShikibetsuTaisho 宛名識別対象
     */
    private ShokanKetteiTsuchiShoKetteiTsuchiIchiranParameter(boolean has出力順, RString 出力順, RString 資格区分,
            IShikibetsuTaishoPSMSearchKey psmShikibetsuTaisho,
            IShikibetsuTaishoPSMSearchKey key,
            IAtesakiPSMSearchKey atesakiKey) {
        super(key);
        this.has出力順 = has出力順;
        this.出力順 = 出力順;
        this.uaft250_gyomuCode = atesakiKey.get業務判定キー().get業務コード();
        this.uaft250_subGyomuCode = atesakiKey.get業務判定キー().getサブ業務コード();
        this.uaft250_kamokuCode = atesakiKey.get業務判定キー().get科目コード();
        this.uaft250_gyomuKoyuKeyRiyoFlag = atesakiKey.get業務固有キー利用区分().isGyomuKoyuKeyRiyo();
        this.uaft250_gyomuKoyuKey = atesakiKey.get業務判定キー().get業務固有キー();
        this.uaft250_shikibetsuCode = RString.EMPTY;
        this.uaft250_isUseTableColumn = Boolean.FALSE;
        this.uaft250_sofusakiRiyoFlag = atesakiKey.get送付先利用区分().isSofusakiRiyo();
        this.uaft250_dainoRiyoFlag = atesakiKey.get代納人利用区分().isDainoRiyo();
        this.uaft250_setaiNushiRiyoFlag = atesakiKey.get世帯主利用区分().isSetainushiRiyo();
        this.uaft250_daihyoshaRiyokuFlag = atesakiKey.get法人代表者利用区分().isHojinDaihyoshaRiyo();
        this.uaft250_kijunYMD = atesakiKey.get基準日();
        this.uaft250_shikibetsuCodeList = atesakiKey.get識別コードリスト();
        this.資格区分 = 資格区分;
        this.shikibetsutaishoParam = new UaFt200FindShikibetsuTaishoParam(psmShikibetsuTaisho);
    }

    /**
     * コンストラクタです。
     *
     * @param 出力順 出力順
     * @param 資格区分 DBZEnum.資格区分._2号被保険者
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param key 宛名PSMキー
     * @param atesakiKey 宛先PSMキー
     * @return 償還払い支給（不支給）決定通知書一括作成_決定通知一覧表帳票データ取得のMyBatisパラメータクラス
     */
    public static ShokanKetteiTsuchiShoKetteiTsuchiIchiranParameter toMybatisParameter(RString 出力順, RString 資格区分,
            IShikibetsuTaishoPSMSearchKey psmShikibetsuTaisho,
            IShikibetsuTaishoPSMSearchKey key,
            IAtesakiPSMSearchKey atesakiKey) {
        return new ShokanKetteiTsuchiShoKetteiTsuchiIchiranParameter(!RString.isNullOrEmpty(出力順), 出力順, 資格区分, psmShikibetsuTaisho, key, atesakiKey);
    }
}
