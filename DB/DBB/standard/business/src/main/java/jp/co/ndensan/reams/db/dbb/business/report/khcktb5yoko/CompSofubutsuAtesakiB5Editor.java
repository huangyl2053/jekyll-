/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko;

import jp.co.ndensan.reams.db.dbb.entity.db.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;

/**
 * 介護保険料徴収猶予決定通知書B5横タイプCompSofubutsuAtesakiEditor
 *
 * @reamsid_L DBB-0740-040 sunhui
 */
public class CompSofubutsuAtesakiB5Editor implements IKaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoEditor {

    private final EditedAtesaki 編集後宛先;

    /**
     * コンストラクタです
     *
     * @param 編集後宛先 編集後宛先
     */
    public CompSofubutsuAtesakiB5Editor(EditedAtesaki 編集後宛先) {
        this.編集後宛先 = 編集後宛先;
    }

    @Override
    public KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource edit(
            KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource source) {
        SofubutsuAtesakiSource sofuSource = 編集後宛先.getSofubutsuAtesakiSource().get送付物宛先ソース();

        source.yubinNo = sofuSource.yubinNo;
        source.gyoseiku = sofuSource.gyoseiku;
        source.jusho3 = sofuSource.jusho3;
        source.jushoText = sofuSource.jushoText;
        source.jusho1 = sofuSource.jusho1;
        source.jusho2 = sofuSource.jusho2;
        source.katagakiText = sofuSource.katagakiText;
        source.katagaki2 = sofuSource.katagaki2;
        source.katagakiSmall2 = sofuSource.katagakiSmall2;
        source.katagaki1 = sofuSource.katagaki1;
        source.katagakiSmall1 = sofuSource.katagakiSmall1;
        source.kakkoRight2 = sofuSource.kakkoRight2;
        source.kakkoRight1 = sofuSource.kakkoRight1;
        source.shimei2 = sofuSource.shimei2;
        source.shimeiSmall2 = sofuSource.shimeiSmall2;
        source.shimeiText = sofuSource.shimeiText;
        source.meishoFuyo2 = sofuSource.meishoFuyo2;
        source.shimeiSmall1 = sofuSource.shimeiSmall1;
        source.dainoKubunMei = sofuSource.dainoKubunMei;
        source.shimei1 = sofuSource.shimei1;
        source.meishoFuyo1 = sofuSource.meishoFuyo1;
        source.samabunShimeiText = sofuSource.samabunShimeiText;
        source.samabunShimeiSmall2 = sofuSource.samabunShimeiSmall2;
        source.samaBun2 = sofuSource.samaBun2;
        source.kakkoLeft2 = sofuSource.kakkoLeft2;
        source.samabunShimei2 = sofuSource.samabunShimei2;
        source.kakkoLeft1 = sofuSource.kakkoLeft1;
        source.samabunShimei1 = sofuSource.samabunShimei1;
        source.samaBun1 = sofuSource.samaBun1;
        source.samabunShimeiSmall1 = sofuSource.samabunShimeiSmall1;
        source.customerBarCode = sofuSource.customerBarCode;
        // TODO QA:581
//        source.setainusimei = sofuSource.setainusimei;
//        source.samaKata = sofuSource.samaKata;
        return source;
    }

}
