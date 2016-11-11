/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishofukushiyogutaiyohinmoku;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhitsuchishofukushiyogutaiyohinmoku.KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishofukushiyogutaiyohinmoku.KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 帳票設計_DBC100043_介護保険給付費通知書（福祉用具貸与品目）のEditorです。
 *
 * @reamsid_L DBC-2280-060 lizhuoxuan
 *
 */
public class KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEditor1 implements IKyufuhiTsuchishoFukushiYoguTaiyoHinmokuEditor {

    private final KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity item;
    private final int i;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity}
     * @param i int
     */
    public KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEditor1(KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity item, int i) {
        this.item = item;
        this.i = i;
    }

    @Override
    public KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource edit(KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource source) {
        return editSource(source);
    }

    private KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource editSource(KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource source) {
        if (item.get費用額() != null && i < item.get費用額().size() && item.get費用額().get(i) != null) {
            source.listRiyoFukushiyogu_5 = new RString(item.get費用額().get(i).toString());
        }
        if (item.getサービス年月() != null && i < item.getサービス年月().size() && item.getサービス年月().get(i) != null) {
            source.listRiyoFukushiyogu_1 = new FlexibleDate(item.getサービス年月().get(i)).wareki()
                    .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        if (item.getサービス事業所() != null && i < item.getサービス事業所().size()) {
            source.listRiyoFukushiyogu_2 = item.getサービス事業所().get(i);
        }
        if (item.getタイコード() != null && i < item.getタイコード().size()) {
            source.listRiyoFukushiyogu_3 = item.getタイコード().get(i);
        }
        if (item.get福祉用具商品名() != null && i < item.get福祉用具商品名().size()) {
            source.listRiyoFukushiyogu_4 = item.get福祉用具商品名().get(i);
        }
        source = editSource1(source);
        source = editSource2(source);
        source = editSource3(source);
        return source;
    }

    private KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource editSource1(KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource source) {
        if (item.get費用額円_1() != null && i < item.get費用額円_1().size()) {
            source.listSankouShiryoHiyoGakuIchiran1_1 = new RString(item.get費用額円_1().get(i).toString());
        }
        if (item.get件数件_1() != null && i < item.get件数件_1().size()) {
            source.listSankouShiryoHiyoGakuIchiran1_2 = new RString(item.get件数件_1().get(i).toString());
        }
        if (item.get割合_1() != null && i < item.get割合_1().size()) {
            source.listSankouShiryoHiyoGakuIchiran1_3 = new RString(item.get割合_1().get(i).toString());
        }
        if (item.get全国1() != null && i < item.get全国1().size()) {
            source.listSankouShiryoKokyoDantaiBetsuIchiran1_1 = new RString(item.get全国1().get(i).toString());
        }
        if (item.get都道府県1() != null && i < item.get都道府県1().size()) {
            source.listSankouShiryoKokyoDantaiBetsuIchiran1_2 = new RString(item.get都道府県1().get(i).toString());
        }
        if (item.get保険者1() != null && i < item.get保険者1().size()) {
            source.listSankouShiryoKokyoDantaiBetsuIchiran1_3 = new RString(item.get保険者1().get(i).toString());
        }
        if (item.getあなたの位置1() != null && i < item.getあなたの位置1().size()) {
            source.listSankouShiryoHiyoGakuIchiran1_4 = new RString(item.getあなたの位置1().get(i).toString());
        }
        return source;
    }

    private KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource editSource2(KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource source) {
        if (item.get費用額円_2() != null && i < item.get費用額円_2().size()) {
            source.listSankouShiryoHiyoGakuIchiran2_1 = new RString(item.get費用額円_2().get(i).toString());
        }
        if (item.get件数件_2() != null && i < item.get件数件_2().size()) {
            source.listSankouShiryoHiyoGakuIchiran2_2 = new RString(item.get件数件_2().get(i).toString());
        }
        if (item.get割合_2() != null && i < item.get割合_2().size()) {
            source.listSankouShiryoHiyoGakuIchiran2_3 = new RString(item.get割合_2().get(i).toString());
        }
        if (item.get全国2() != null && i < item.get全国2().size()) {
            source.listSankouShiryoKokyoDantaiBetsuIchiran2_1 = new RString(item.get全国2().get(i).toString());
        }
        if (item.get都道府県2() != null && i < item.get都道府県2().size()) {
            source.listSankouShiryoKokyoDantaiBetsuIchiran2_2 = new RString(item.get都道府県2().get(i).toString());
        }
        if (item.get保険者2() != null && i < item.get保険者2().size()) {
            source.listSankouShiryoKokyoDantaiBetsuIchiran2_3 = new RString(item.get保険者2().get(i).toString());
        }
        if (item.getあなたの位置2() != null && i < item.getあなたの位置2().size()) {
            source.listSankouShiryoHiyoGakuIchiran2_4 = new RString(item.getあなたの位置2().get(i).toString());
        }
        return source;
    }

    private KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource editSource3(KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource source) {
        if (item.get費用額円_3() != null && i < item.get費用額円_3().size()) {
            source.listSankouShiryoHiyoGakuIchiran3_1 = new RString(item.get費用額円_3().get(i).toString());
        }
        if (item.get件数件_3() != null && i < item.get件数件_3().size()) {
            source.listSankouShiryoHiyoGakuIchiran3_2 = new RString(item.get件数件_3().get(i).toString());
        }
        if (item.get割合_3() != null && i < item.get割合_3().size()) {
            source.listSankouShiryoHiyoGakuIchiran3_3 = new RString(item.get割合_3().get(i).toString());
        }
        if (item.get全国3() != null && i < item.get全国3().size()) {
            source.listSankouShiryoKokyoDantaiBetsuIchiran3_1 = new RString(item.get全国3().get(i).toString());
        }
        if (item.get都道府県3() != null && i < item.get都道府県3().size()) {
            source.listSankouShiryoKokyoDantaiBetsuIchiran3_2 = new RString(item.get都道府県3().get(i).toString());
        }
        if (item.get保険者3() != null && i < item.get保険者3().size()) {
            source.listSankouShiryoKokyoDantaiBetsuIchiran3_3 = new RString(item.get保険者3().get(i).toString());
        }
        if (item.getあなたの位置3() != null && i < item.getあなたの位置3().size()) {
            source.listSankouShiryoHiyoGakuIchiran3_4 = new RString(item.getあなたの位置3().get(i).toString());
        }
        return source;
    }
}
