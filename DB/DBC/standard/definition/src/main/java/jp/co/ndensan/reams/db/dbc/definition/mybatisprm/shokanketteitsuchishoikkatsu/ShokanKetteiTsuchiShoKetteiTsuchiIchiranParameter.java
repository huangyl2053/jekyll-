/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;

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
    
    private final IKozaSearchKey 口座検索条件;
    private final Long koza_kozaId;
    private final boolean usesKoza_kozaId;
    private final ShikibetsuCode koza_shikibetsuCode;
    private final boolean usesKoza_shikibetsuCode;
    private final GyomuCode koza_gyomuCode;
    private final boolean usesKoza_gyomuCode;
    private final SubGyomuCode koza_subGyomuCode;
    private final boolean usesKoza_subGyomuCode;
    private final List<KamokuCode> koza_kamokuCode;
    private final RString koza_gyomubetsuPrimaryKey;
    private final boolean usesKoza_gyomubetsuPrimaryKey;
    private final List<RString> koza_gyomuKoyuKey;
    private final boolean usesKoza_gyomuKoyuKey;
    private final Code koza_yotoKubun;
    private final boolean usesKoza_yotoKubun;
    private final FlexibleDate koza_kijunYMD;
    private final boolean usesKoza_kijunYMD;
    private final RYear koza_genNendo;
    private final boolean hasValidKamoku;

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
            IAtesakiPSMSearchKey atesakiKey,
             IKozaSearchKey kozaKey, List<KamokuCode> 権限有科目リスト) {
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
        
        this.口座検索条件 = kozaKey;
        this.koza_kozaId = kozaKey.get口座ID();
        this.usesKoza_kozaId = (this.koza_kozaId != null);
        this.koza_shikibetsuCode = kozaKey.get識別コード();
        this.usesKoza_shikibetsuCode = (ShikibetsuCode.EMPTY.compareTo(koza_shikibetsuCode) != 0);
        this.koza_gyomuCode = kozaKey.get業務コード();
        this.usesKoza_gyomuCode = (!this.koza_gyomuCode.value().isEmpty());
        this.koza_subGyomuCode = kozaKey.getサブ業務コード();
        this.usesKoza_subGyomuCode = (!this.koza_subGyomuCode.value().isEmpty());
        this.koza_kamokuCode = get検索用科目リスト(kozaKey.get科目コード(), 権限有科目リスト);
        this.koza_gyomubetsuPrimaryKey = kozaKey.get業務別主キー();
        this.usesKoza_gyomubetsuPrimaryKey = (!this.koza_gyomubetsuPrimaryKey.isEmpty());
        this.koza_gyomuKoyuKey = kozaKey.get業務固有キーリスト();
        this.usesKoza_gyomuKoyuKey = (!this.koza_gyomuKoyuKey.isEmpty());
        this.koza_yotoKubun = kozaKey.get用途区分コード();
        this.usesKoza_yotoKubun = (Code.EMPTY.compareTo(koza_yotoKubun) != 0);
        this.koza_kijunYMD = kozaKey.get基準日();
        this.usesKoza_kijunYMD = (!this.koza_kijunYMD.isEmpty());
        this.koza_genNendo = RDate.getNowDate().getNendo();
        this.hasValidKamoku = has権限有科目();
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
            IAtesakiPSMSearchKey atesakiKey, IKozaSearchKey kozaKey, List<KamokuCode> 権限有科目リスト) {
        return new ShokanKetteiTsuchiShoKetteiTsuchiIchiranParameter(!RString.isNullOrEmpty(出力順), 出力順, 資格区分, psmShikibetsuTaisho, key,
                atesakiKey, kozaKey, 権限有科目リスト);
    }
    
    private boolean has権限有科目() {
        return !this.koza_kamokuCode.isEmpty();
    }

    private List<KamokuCode> get検索用科目リスト(KamokuCode 指定科目コード, List<KamokuCode> 権限有科目リスト) {
        if (KamokuCode.EMPTY.compareTo(指定科目コード) == 0) {
            return 権限有科目リスト;
        }
        List<KamokuCode> list = new ArrayList();
        if (権限有科目リスト.contains(指定科目コード)) {
            list.add(指定科目コード);
        }
        return list;
    }
}
