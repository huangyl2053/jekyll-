/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishoginfuri;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriSource;
import jp.co.ndensan.reams.db.dbz.business.core.kaigosofubutsuatesakisource.KaigoSofubutsuAtesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;

/**
 *
 * 帳票設計_DBBRP00007_3_保険料納入通知書（仮算定）【銀振タイプ】CompSofubutsuAtesaki2Editor
 *
 * @reamsid_L DBB-9110-030 wangjie2
 */
public class CompSofubutsuAtesaki2Editor implements IKarisanteiHokenryoNonyuTsuchishoGinfuriEditor {

    private final KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報;

    /**
     * インスタンスを生成します。
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報
     */
    protected CompSofubutsuAtesaki2Editor(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {
        this.仮算定納入通知書情報 = 仮算定納入通知書情報;
    }

    @Override
    public KarisanteiHokenryoNonyuTsuchishoGinfuriSource edit(KarisanteiHokenryoNonyuTsuchishoGinfuriSource source) {
        EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報 = null == 仮算定納入通知書情報.get編集後仮算定通知書共通情報()
                ? new EditedKariSanteiTsuchiShoKyotsu() : 仮算定納入通知書情報.get編集後仮算定通知書共通情報();
        EditedAtesaki 編集後宛先 = 編集後仮算定通知書共通情報.get編集後宛先();
        KaigoSofubutsuAtesakiSource kaigoSofubutsuAtesakiSource = null;
        if (編集後宛先 != null) {
            kaigoSofubutsuAtesakiSource = 編集後宛先.getSofubutsuAtesakiSource();
        }
        if (kaigoSofubutsuAtesakiSource != null) {
            SofubutsuAtesakiSource sofubutsuAtesakiSource = kaigoSofubutsuAtesakiSource.get送付物宛先ソース();
            if (sofubutsuAtesakiSource != null) {
                source.customerBarCode1 = sofubutsuAtesakiSource.customerBarCode;
                source.dainoKubunMei1 = sofubutsuAtesakiSource.dainoKubunMei;
                source.gyoseiku2 = sofubutsuAtesakiSource.gyoseiku;
                source.jusho4 = sofubutsuAtesakiSource.jusho1;
                source.jusho5 = sofubutsuAtesakiSource.jusho2;
                source.jusho6 = sofubutsuAtesakiSource.jusho3;
                source.jushoText1 = sofubutsuAtesakiSource.jushoText;
                source.kakkoLeft3 = sofubutsuAtesakiSource.kakkoLeft1;
                source.kakkoLeft4 = sofubutsuAtesakiSource.kakkoLeft2;
                source.kakkoRight3 = sofubutsuAtesakiSource.kakkoRight1;
                source.kakkoRight4 = sofubutsuAtesakiSource.kakkoRight2;
                source.katagaki3 = sofubutsuAtesakiSource.katagaki1;
                source.katagaki4 = sofubutsuAtesakiSource.katagaki2;
                source.katagakiSmall3 = sofubutsuAtesakiSource.katagakiSmall1;
                source.katagakiSmall4 = sofubutsuAtesakiSource.katagakiSmall2;
                source.katagakiText1 = sofubutsuAtesakiSource.katagakiText;
                source.meishoFuyo3 = sofubutsuAtesakiSource.meishoFuyo1;
                source.meishoFuyo4 = sofubutsuAtesakiSource.meishoFuyo2;
                source.samaBun3 = sofubutsuAtesakiSource.samaBun1;
                source.samaBun4 = sofubutsuAtesakiSource.samaBun2;
                source.samabunShimei3 = sofubutsuAtesakiSource.samabunShimei1;
                source.samabunShimei4 = sofubutsuAtesakiSource.samabunShimei2;
                source.samabunShimeiSmall3 = sofubutsuAtesakiSource.samabunShimeiSmall1;
                source.samabunShimeiSmall4 = sofubutsuAtesakiSource.samabunShimeiSmall2;
                source.samabunShimeiText1 = sofubutsuAtesakiSource.samabunShimeiText;
                source.shimei3 = sofubutsuAtesakiSource.shimei1;
                source.shimei4 = sofubutsuAtesakiSource.shimei2;
                source.shimeiSmall3 = sofubutsuAtesakiSource.shimeiSmall1;
                source.shimeiSmall4 = sofubutsuAtesakiSource.shimeiSmall2;
                source.shimeiText1 = sofubutsuAtesakiSource.shimeiText;
                source.yubinNo2 = sofubutsuAtesakiSource.yubinNo;
                //世帯主名 様方
            }
        }
        return source;
    }

}
