/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehishikyuketteitsuchisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.core.KensakuYoShikibetsuCode;
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
 * 高額サービス費支給（不支給）決定通知書作成の帳票出力用のパラメータです
 *
 * @reamsid_L DBC-2000-030 wangxue
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
class _JigyoKogakuKetteiTsuchishoReportParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

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

    private final KensakuYoShikibetsuCode tmp_shikibetsuCode;
    private final GyomuCode uaft250_gyomuCode;
    private final SubGyomuCode uaft250_subGyomuCode;
    private final KamokuCode uaft250_kamokuCode;
    private final Boolean uaft250_gyomuKoyuKeyRiyoFlag;
    private final RString uaft250_gyomuKoyuKey;
    private final RString uaft250_shikibetsuCode;
    private final Boolean uaft250_isUseTableColumn;
    private final Boolean uaft250_sofusakiRiyoFlag;
    private final Boolean uaft250_dainoRiyoFlag;
    private final Boolean uaft250_setaiNushiRiyoFlag;
    private final Boolean uaft250_daihyoshaRiyokuFlag;
    private final FlexibleDate uaft250_kijunYMD;
    private final List<ShikibetsuCode> uaft250_shikibetsuCodeList;

    public _JigyoKogakuKetteiTsuchishoReportParameter(
            IKozaSearchKey kozaSearchKey,
            IAtesakiPSMSearchKey atesakiPSMSearchKey,
            List<KamokuCode> 権限有科目リスト,
            IShikibetsuTaishoPSMSearchKey searchKey) {
        super(searchKey);
        this.koza_kozaId = kozaSearchKey.get口座ID();
        this.usesKoza_kozaId = koza_kozaId != null;
        this.koza_shikibetsuCode = kozaSearchKey.get識別コード();
        this.usesKoza_shikibetsuCode = !koza_shikibetsuCode.isEmpty();
        this.koza_gyomuCode = kozaSearchKey.get業務コード();
        this.usesKoza_gyomuCode = !koza_gyomuCode.value().isEmpty();
        this.koza_subGyomuCode = kozaSearchKey.getサブ業務コード();
        this.usesKoza_subGyomuCode = !koza_subGyomuCode.value().isEmpty();
        this.koza_kamokuCode = get検索用科目リスト(kozaSearchKey.get科目コード(), 権限有科目リスト);
        this.koza_gyomubetsuPrimaryKey = kozaSearchKey.get業務別主キー();
        this.usesKoza_gyomubetsuPrimaryKey = !koza_gyomubetsuPrimaryKey.isEmpty();
        this.koza_gyomuKoyuKey = kozaSearchKey.get業務固有キーリスト();
        this.usesKoza_gyomuKoyuKey = !koza_gyomuKoyuKey.isEmpty();
        this.koza_yotoKubun = kozaSearchKey.get用途区分コード();
        this.usesKoza_yotoKubun = !koza_yotoKubun.isEmpty();
        this.koza_kijunYMD = kozaSearchKey.get基準日();
        this.usesKoza_kijunYMD = !koza_kijunYMD.isEmpty();
        this.koza_genNendo = RDate.getNowDate().getNendo();

        this.uaft250_gyomuCode = atesakiPSMSearchKey.get業務判定キー().get業務コード();
        this.uaft250_subGyomuCode = atesakiPSMSearchKey.get業務判定キー().getサブ業務コード();
        this.uaft250_kamokuCode = atesakiPSMSearchKey.get業務判定キー().get科目コード();
        this.uaft250_gyomuKoyuKeyRiyoFlag = atesakiPSMSearchKey.get業務固有キー利用区分().isGyomuKoyuKeyRiyo();
        this.uaft250_gyomuKoyuKey = atesakiPSMSearchKey.get業務判定キー().get業務固有キー();
        this.tmp_shikibetsuCode = atesakiPSMSearchKey.get識別コード();
        this.uaft250_shikibetsuCode = tmp_shikibetsuCode.getColumnValue();
        this.uaft250_isUseTableColumn = tmp_shikibetsuCode.isUseTableColumn();
        this.uaft250_sofusakiRiyoFlag = atesakiPSMSearchKey.get送付先利用区分().isSofusakiRiyo();
        this.uaft250_dainoRiyoFlag = atesakiPSMSearchKey.get代納人利用区分().isDainoRiyo();
        this.uaft250_setaiNushiRiyoFlag = atesakiPSMSearchKey.get世帯主利用区分().isSetainushiRiyo();
        this.uaft250_daihyoshaRiyokuFlag = atesakiPSMSearchKey.get法人代表者利用区分().isHojinDaihyoshaRiyo();
        this.uaft250_kijunYMD = atesakiPSMSearchKey.get基準日();
        this.uaft250_shikibetsuCodeList = atesakiPSMSearchKey.get識別コードリスト();
    }

    private List<KamokuCode> get検索用科目リスト(KamokuCode 指定科目コード, List<KamokuCode> 権限有科目リスト) {
        if (指定科目コード.isEmpty()) {
            return 権限有科目リスト;
        }
        List<KamokuCode> list = new ArrayList<>();
        if (権限有科目リスト.contains(指定科目コード)) {
            list.add(指定科目コード);
        }
        return list;
    }
}
