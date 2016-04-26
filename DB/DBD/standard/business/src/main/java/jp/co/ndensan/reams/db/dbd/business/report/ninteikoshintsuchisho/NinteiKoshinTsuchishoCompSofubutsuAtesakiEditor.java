/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.ninteikoshintsuchisho;

import jp.co.ndensan.reams.db.dbd.entity.report.ninteikoshintsuchisho.NinteiKoshinTsuchisho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;

/**
 * 負担限度額認定更新のお知らせ通知書
 *
 * @reamsid_L DBD-3570-040 liangbc
 */
public class NinteiKoshinTsuchishoCompSofubutsuAtesakiEditor implements INinteiKoshinTsuchishoEditor {

    private final NinteiKoshinTsuchishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item パラメータ
     */
    protected NinteiKoshinTsuchishoCompSofubutsuAtesakiEditor(NinteiKoshinTsuchishoItem item) {
        this.item = item;
    }

    @Override
    public NinteiKoshinTsuchisho edit(NinteiKoshinTsuchisho source) {
        SofubutsuAtesakiSource atesakiSource = getSofubutsuAtesakiSource(
                getEditedAtesaki(item.getIAtesaki(), item.get地方公共団体(), item.get帳票制御共通()));
        source.yubinNo = atesakiSource.yubinNo;
        //source.gyoseiku1 = atesakiSource.gyoseiku1;
        //source.jusho4 = atesakiSource.jusho4;
        source.jushoText = atesakiSource.jushoText;
        //source.jusho5 = atesakiSource.jusho5;
        //source.jusho6 = atesakiSource.jusho6;
        source.katagakiText = atesakiSource.katagakiText;
        //source.katagaki3 = atesakiSource.katagaki3;
        source.katagakiSmall2 = atesakiSource.katagakiSmall2;
        //source.katagaki4 = atesakiSource.katagaki4;
        source.katagakiSmall1 = atesakiSource.katagakiSmall1;
//        source.shimei3 = atesakiSource.shimei3;
        source.shimeiSmall2 = atesakiSource.shimeiSmall2;
        source.shimeiText = atesakiSource.shimeiText;
        source.meishoFuyo2 = atesakiSource.meishoFuyo2;
        source.shimeiSmall1 = atesakiSource.shimeiSmall1;
        source.dainoKubunMei = atesakiSource.dainoKubunMei;
//        source.shimei4 = atesakiSource.shimei4;
        source.meishoFuyo1 = atesakiSource.meishoFuyo1;
        source.samabunShimeiText = atesakiSource.samabunShimeiText;
        source.samabunShimeiSmall2 = atesakiSource.samabunShimeiSmall2;
        source.samaBun2 = atesakiSource.samaBun2;
        source.kakkoLeft2 = atesakiSource.kakkoLeft2;
        source.samabunShimei2 = atesakiSource.samabunShimei2;
        source.kakkoRight2 = atesakiSource.kakkoRight2;
        source.kakkoLeft1 = atesakiSource.kakkoLeft1;
        source.samabunShimei1 = atesakiSource.samabunShimei1;
        source.samaBun1 = atesakiSource.samaBun1;
        source.kakkoRight1 = atesakiSource.kakkoRight1;
        source.samabunShimeiSmall1 = atesakiSource.samabunShimeiSmall1;
        source.customerBarCode = atesakiSource.customerBarCode;
        return source;
    }

    private static SofubutsuAtesakiSource getSofubutsuAtesakiSource(EditedAtesaki atesaki) {
        return atesaki.getSofubutsuAtesakiSource().get送付物宛先ソース();
    }

    private static EditedAtesaki getEditedAtesaki(IAtesaki atesaki, Association 地方公共団体, ChohyoSeigyoKyotsu 帳票制御共通) {
        return new EditedAtesaki(atesaki, 地方公共団体, 帳票制御共通);
    }
}
