/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehikyufuoshirasetsuchisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.shunyugaku.ShutsuryokuJoken;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import lombok.Getter;

/**
 * 高額サービス費給付お知らせ通知書作成のMYBATIS用パラメータクラスです。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class KogakuKaigoServicehiOshiraseHakkoMybatisParameter extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final FlexibleYearMonth shoriYm;
    private final FlexibleDate sakuseibi;
    private final HihokenshaNo hihokenshaNo;
    private final boolean isShinseishoHakko;
    private final boolean isOshiraseTsuchishoHakko;
    private final boolean isHakkoIchiranhyoHakko;
    private final boolean isKinyuKikanHyoji;
    private final FlexibleDate shiseibi;
    private final FlexibleDate uketsukebi;
    private final FlexibleDate keteibi;
    private final FlexibleDate shinseishoTeishutsuKigen;
    private final RString chushutsuJoken;
    private final RString menuId;
    private final boolean isJutakuAri;
    private final RString orderBy;
    private final RString 保険者番号;
    private final RString 事業高額;
    private final RString 初回申請把握基準日;

    private final IShikibetsuTaishoPSMSearchKey searchKey;
    private final KensakuYoShikibetsuCode tmp_shikibetsuCode;
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
     *
     * コンストラクタです。
     *
     * @param shoriYm 処理年月
     * @param sakuseibi 作成日
     * @param hihokenshaNo 被保険者番号
     * @param isShinseishoHakko is申請書発行
     * @param isOshiraseTsuchishoHakko isお知らせ通知書発行
     * @param isHakkoIchiranhyoHakko is発行一覧表発行
     * @param isKinyuKikanHyoji is金融機関表示
     * @param shiseibi 申請日
     * @param uketsukebi 受付日
     * @param keteibi 決定日
     * @param shinseishoTeishutsuKigen 申請書提出期限
     * @param chushutsuJoken 抽出条件
     * @param menuId メニューID
     * @param isJutakuAri is受託あり
     * @param orderBy 出力順
     * @param 保険者番号 保険者番号
     * @param 事業高額 事業高額
     * @param 初回申請把握基準日 初回申請把握基準日
     * @param searchKey searchKey
     * @param atesakiKey atesakiKey
     * @param kozaKey kozaKey
     * @param 権限有科目リスト 権限有科目リスト
     */
    public KogakuKaigoServicehiOshiraseHakkoMybatisParameter(FlexibleYearMonth shoriYm, FlexibleDate sakuseibi,
            HihokenshaNo hihokenshaNo, boolean isShinseishoHakko, boolean isOshiraseTsuchishoHakko,
            boolean isHakkoIchiranhyoHakko, boolean isKinyuKikanHyoji, FlexibleDate shiseibi, FlexibleDate uketsukebi,
            FlexibleDate keteibi, FlexibleDate shinseishoTeishutsuKigen, ShutsuryokuJoken chushutsuJoken, RString menuId,
            boolean isJutakuAri, RString orderBy, RString 保険者番号, RString 事業高額, RString 初回申請把握基準日,
            IShikibetsuTaishoPSMSearchKey searchKey, IAtesakiPSMSearchKey atesakiKey,
            IKozaSearchKey kozaKey, List<KamokuCode> 権限有科目リスト) {
        super(searchKey);
        this.shoriYm = shoriYm;
        this.sakuseibi = sakuseibi;
        this.hihokenshaNo = hihokenshaNo;
        this.isShinseishoHakko = isShinseishoHakko;
        this.isOshiraseTsuchishoHakko = isOshiraseTsuchishoHakko;
        this.isHakkoIchiranhyoHakko = isHakkoIchiranhyoHakko;
        this.isKinyuKikanHyoji = isKinyuKikanHyoji;
        this.shiseibi = shiseibi;
        this.uketsukebi = uketsukebi;
        this.keteibi = keteibi;
        this.shinseishoTeishutsuKigen = shinseishoTeishutsuKigen;
        this.chushutsuJoken = chushutsuJoken == null ? RString.EMPTY : chushutsuJoken.getコード();
        this.menuId = menuId;
        this.isJutakuAri = isJutakuAri;
        this.orderBy = orderBy;
        this.保険者番号 = 保険者番号;
        this.事業高額 = 事業高額;
        this.初回申請把握基準日 = 初回申請把握基準日;

        this.searchKey = searchKey;
        this.uaft250_gyomuCode = atesakiKey.get業務判定キー().get業務コード();
        this.uaft250_subGyomuCode = atesakiKey.get業務判定キー().getサブ業務コード();
        this.uaft250_kamokuCode = atesakiKey.get業務判定キー().get科目コード();
        this.uaft250_gyomuKoyuKeyRiyoFlag = atesakiKey.get業務固有キー利用区分().isGyomuKoyuKeyRiyo();
        this.uaft250_gyomuKoyuKey = atesakiKey.get業務判定キー().get業務固有キー();
        this.tmp_shikibetsuCode = atesakiKey.get識別コード();
        this.uaft250_shikibetsuCode = this.tmp_shikibetsuCode.getColumnValue();
        this.uaft250_isUseTableColumn = this.tmp_shikibetsuCode.isUseTableColumn();
        this.uaft250_sofusakiRiyoFlag = atesakiKey.get送付先利用区分().isSofusakiRiyo();
        this.uaft250_dainoRiyoFlag = atesakiKey.get代納人利用区分().isDainoRiyo();
        this.uaft250_setaiNushiRiyoFlag = atesakiKey.get世帯主利用区分().isSetainushiRiyo();
        this.uaft250_daihyoshaRiyokuFlag = atesakiKey.get法人代表者利用区分().isHojinDaihyoshaRiyo();
        this.uaft250_kijunYMD = atesakiKey.get基準日();

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
