/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100008;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd100008.NinteiKoshinTsuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担限度額認定更新のお知らせ通知書
 *
 * @reamsid_L DBD-3570-040 liangbc
 */
public class NinteiKoshinTsuchishoCompSofubutsuAtesakiEditor implements INinteiKoshinTsuchishoEditor {

    private final NinteiKoshinTsuchishoItem item;
    private final RString 空白 = RString.EMPTY;

    /**
     * インスタンスを生成します。
     *
     * @param item パラメータ
     */
    protected NinteiKoshinTsuchishoCompSofubutsuAtesakiEditor(NinteiKoshinTsuchishoItem item) {
        this.item = item;
    }

    @Override
    public NinteiKoshinTsuchishoReportSource edit(NinteiKoshinTsuchishoReportSource source) {
        SofubutsuAtesakiSource atesakiSource = getSofubutsuAtesakiSource(item.get編集後宛先());
        source.yubinNo = atesakiSource.yubinNo;
        source.gyoseiku1 = 空白;
        source.jusho4 = 空白;
        source.jushoText = atesakiSource.jushoText;
        source.jusho5 = 空白;
        source.jusho6 = 空白;
        source.katagakiText = atesakiSource.katagakiText;
        source.katagaki3 = 空白;
        source.katagakiSmall2 = atesakiSource.katagakiSmall2;
        source.katagaki4 = 空白;
        source.katagakiSmall1 = atesakiSource.katagakiSmall1;
        source.shimei3 = 空白;
        source.shimeiSmall2 = atesakiSource.shimeiSmall2;
        source.shimeiText = atesakiSource.shimeiText;
        source.meishoFuyo2 = atesakiSource.meishoFuyo2;
        source.shimeiSmall1 = atesakiSource.shimeiSmall1;
        source.dainoKubunMei = atesakiSource.dainoKubunMei;
        source.shimei4 = 空白;
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
}
