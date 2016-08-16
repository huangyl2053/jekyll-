/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufuoshirasetsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.shunyugaku.ShutsuryokuJoken;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigoservicehikyufuoshirasetsuchisho.KogakuKaigoServicehiOshiraseHakkoMybatisParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額サービス費給付お知らせ通知書作成のプロセス用パラメータクラスです。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKaigoServicehiOshiraseHakkoProcessParameter implements IBatchProcessParameter {

    private FlexibleYearMonth shoriYm;
    private FlexibleDate sakuseibi;
    private HihokenshaNo hihokenshaNo;
    private boolean isShinseishoHakko;
    private boolean isOshiraseTsuchishoHakko;
    private boolean isHakkoIchiranhyoHakko;
    private boolean isKinyuKikanHyoji;
    private FlexibleDate shiseibi;
    private FlexibleDate uketsukebi;
    private FlexibleDate keteibi;
    private FlexibleDate shinseishoTeishutsuKigen;
    private ShutsuryokuJoken chushutsuJoken;
    private RString menuId;
    private boolean isJutakuAri;
    private RString orderBy;
    private Long shutsuryokujunId;
    private RString bunshoMojiretsu;
    private IShikibetsuTaishoPSMSearchKey 宛名検索条件;
    private IKozaSearchKey 口座検索条件;
    private List<KamokuCode> 権限有科目リスト;
    private IAtesakiPSMSearchKey 宛先検索条件;
    private RString 保険者番号;
    private RString 事業高額;
    private RString 初回申請把握基準日;

    /**
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
     * @param shutsuryokujunId shutsuryokujunId
     * @param bunshoMojiretsu 文書番号文字列
     */
    public KogakuKaigoServicehiOshiraseHakkoProcessParameter(FlexibleYearMonth shoriYm, FlexibleDate sakuseibi, HihokenshaNo hihokenshaNo,
            boolean isShinseishoHakko, boolean isOshiraseTsuchishoHakko, boolean isHakkoIchiranhyoHakko, boolean isKinyuKikanHyoji,
            FlexibleDate shiseibi, FlexibleDate uketsukebi, FlexibleDate keteibi, FlexibleDate shinseishoTeishutsuKigen,
            ShutsuryokuJoken chushutsuJoken, RString menuId, boolean isJutakuAri, Long shutsuryokujunId, RString bunshoMojiretsu) {
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
        this.chushutsuJoken = chushutsuJoken;
        this.menuId = menuId;
        this.isJutakuAri = isJutakuAri;
        this.shutsuryokujunId = shutsuryokujunId;
        this.bunshoMojiretsu = bunshoMojiretsu;
    }

    /**
     * MYBATIS用パラメータを作成します。
     *
     * @return MYBATIS用パラメータ
     */
    public KogakuKaigoServicehiOshiraseHakkoMybatisParameter toMybatisParamter() {
        return new KogakuKaigoServicehiOshiraseHakkoMybatisParameter(shoriYm, sakuseibi, hihokenshaNo, isShinseishoHakko, isOshiraseTsuchishoHakko,
                isHakkoIchiranhyoHakko, isKinyuKikanHyoji, shiseibi, uketsukebi, keteibi, shinseishoTeishutsuKigen, chushutsuJoken, menuId,
                isJutakuAri, orderBy, 保険者番号, 事業高額, 初回申請把握基準日, 宛名検索条件, 宛先検索条件, 口座検索条件, 権限有科目リスト);
    }

}
