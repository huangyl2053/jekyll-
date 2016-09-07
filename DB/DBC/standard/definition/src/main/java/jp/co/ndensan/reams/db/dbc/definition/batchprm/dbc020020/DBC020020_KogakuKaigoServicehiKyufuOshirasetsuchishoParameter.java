/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc020020;

import jp.co.ndensan.reams.db.dbc.definition.core.shunyugaku.ShutsuryokuJoken;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufuoshirasetsuchisho.KogakuKaigoServicehiOshiraseHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額サービス費給付お知らせ通知書作成のバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC020020_KogakuKaigoServicehiKyufuOshirasetsuchishoParameter extends BatchParameterBase {

    @BatchParameter(key = "shoriYm", name = "処理年月")
    private FlexibleYearMonth shoriYm;
    @BatchParameter(key = "sakuseibi", name = "作成日")
    private FlexibleDate sakuseibi;
    @BatchParameter(key = "hihokenshaNo", name = "被保険者番号")
    private HihokenshaNo hihokenshaNo;
    @BatchParameter(key = "isShinseishoHakko", name = "is申請書発行")
    private boolean isShinseishoHakko;
    @BatchParameter(key = "isOshiraseTsuchishoHakko", name = "isお知らせ通知書発行")
    private boolean isOshiraseTsuchishoHakko;
    @BatchParameter(key = "isHakkoIchiranhyoHakko", name = "is発行一覧表発行")
    private boolean isHakkoIchiranhyoHakko;
    @BatchParameter(key = "isKinyuKikanHyoji", name = "is金融機関表示")
    private boolean isKinyuKikanHyoji;
    @BatchParameter(key = "shutsuryokujunId", name = "出力順ID")
    private Long shutsuryokujunId;
    @BatchParameter(key = "shinseibi", name = "申請日")
    private FlexibleDate shiseibi;
    @BatchParameter(key = "uketsukebi", name = "受付日")
    private FlexibleDate uketsukebi;
    @BatchParameter(key = "keteibi", name = "決定日")
    private FlexibleDate keteibi;
    @BatchParameter(key = "shinseishoTeishutsuKigen", name = "申請書提出期限")
    private FlexibleDate shinseishoTeishutsuKigen;
    @BatchParameter(key = "chushutsuJoken", name = "抽出条件")
    private ShutsuryokuJoken chushutsuJoken;
    @BatchParameter(key = "menuId", name = "メニューID")
    private RString menuId;
    @BatchParameter(key = "bunshoMojiretsu", name = "文書番号文字列")
    private RString bunshoMojiretsu;
    @BatchParameter(key = "isJutakuAri", name = "is受託あり")
    private boolean isJutakuAri;
    @BatchParameter(key = "ininjoTeishutsusaki", name = "申請書委任状提出先")
    private RString ininjoTeishutsusaki;
    @BatchParameter(key = "shinseishoTelNoHyoji", name = "申請書電話番号表示")
    private RString shinseishoTelNoHyoji;

    /**
     * プロセスパラメータを作成します。
     *
     * @return プロセスパラメータ
     */
    public KogakuKaigoServicehiOshiraseHakkoProcessParameter toProcessParameter() {
        return new KogakuKaigoServicehiOshiraseHakkoProcessParameter(shoriYm, sakuseibi, hihokenshaNo, isShinseishoHakko,
                isOshiraseTsuchishoHakko, isHakkoIchiranhyoHakko, isKinyuKikanHyoji, shiseibi, uketsukebi, keteibi, shinseishoTeishutsuKigen,
                chushutsuJoken, menuId, isJutakuAri, shutsuryokujunId, bunshoMojiretsu, ininjoTeishutsusaki, shinseishoTelNoHyoji);
    }
}
