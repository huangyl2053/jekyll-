/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishofukushiyogutaiyohinmoku;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhitsuchishofukushiyogutaiyohinmoku.KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishofukushiyogutaiyohinmoku.KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBC100043_介護保険給付費通知書（福祉用具貸与品目）のEditorです。
 *
 * @reamsid_L DBC-2280-060 lizhuoxuan
 *
 */
public class KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEditor implements IKyufuhiTsuchishoFukushiYoguTaiyoHinmokuEditor {

    private final KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity item;
    private int index;
    private static final int PAGECOUNT = 25;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity}
     * @param index int
     */
    protected KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEditor(KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity item, int index) {
        this.item = item;
        this.index = index;
    }

    @Override
    public KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource edit(KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource source) {
        return editSource(source);
    }

    private KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource editSource(KyufuhiTsuchishoFukushiYoguTaiyoHinmokuReportSource source) {
        source.hihokenshaName = item.get被保険者氏名();
        source.hokenshaNo = item.get被保険者番号();
        source.shukeiserviceSTYM = item.getサービス集計開始年月();
        source.shukeiserviceEDYM = item.getサービス集計終了年月();
        source.tsuchibun1 = item.get通知文1();
        source.listRiyoFukushiyogu_1 = item.getサービス年月();
        source.listRiyoFukushiyogu_2 = item.getサービス事業所();
        source.listRiyoFukushiyogu_3 = item.getタイコード();
        source.listRiyoFukushiyogu_4 = item.get福祉用具商品名();
        source.listRiyoFukushiyogu_5 = item.get費用額();
        source.sankouShiryoTitle1 = item.get参考資料タイトル1();
        source.listSankouShiryoHiyoGakuIchiran1_1 = item.get費用額円_1();
        source.listSankouShiryoHiyoGakuIchiran1_2 = item.get件数件_1();
        source.listSankouShiryoHiyoGakuIchiran1_3 = item.get割合_1();
        source.listSankouShiryoHiyoGakuIchiran1_4 = item.getあなたの位置1();
        source.listSankouShiryoKokyoDantaiBetsuIchiran1_1 = item.get全国1();
        source.listSankouShiryoKokyoDantaiBetsuIchiran1_2 = item.get都道府県1();
        source.listSankouShiryoKokyoDantaiBetsuIchiran1_3 = item.get保険者1();
        source.sankouShiryoTitle2 = item.get参考資料タイトル2();
        source.listSankouShiryoHiyoGakuIchiran2_1 = item.get費用額円_2();
        source.listSankouShiryoHiyoGakuIchiran2_2 = item.get件数件_2();
        source.listSankouShiryoHiyoGakuIchiran2_3 = item.get割合_2();
        source.listSankouShiryoHiyoGakuIchiran2_4 = item.getあなたの位置2();
        source.listSankouShiryoKokyoDantaiBetsuIchiran2_1 = item.get全国2();
        source.listSankouShiryoKokyoDantaiBetsuIchiran2_2 = item.get都道府県2();
        source.listSankouShiryoKokyoDantaiBetsuIchiran2_3 = item.get保険者2();
        source.sankouShiryoTitle3 = item.get参考資料タイトル3();
        source.listSankouShiryoHiyoGakuIchiran3_1 = item.get費用額円_3();
        source.listSankouShiryoHiyoGakuIchiran3_2 = item.get件数件_3();
        source.listSankouShiryoHiyoGakuIchiran3_3 = item.get割合_3();
        source.listSankouShiryoHiyoGakuIchiran3_4 = item.getあなたの位置3();
        source.listSankouShiryoKokyoDantaiBetsuIchiran3_1 = item.get全国3();
        source.listSankouShiryoKokyoDantaiBetsuIchiran3_2 = item.get都道府県3();
        source.listSankouShiryoKokyoDantaiBetsuIchiran3_3 = item.get保険者3();
        source.tsuchibun3 = item.get通知文3();
        getイメージ03(item);
        source.pageBunshi = new RString(item.getページ分子());
        source.pageBunbo = new RString(item.getページ分母());
        return source;
    }

    private void getイメージ03(KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity item) {
        index = index + 1;
        if (index % PAGECOUNT > 0) {
            item.setページ分子((index - (index % PAGECOUNT)) / PAGECOUNT + 1);
        } else {
            item.setページ分子(index / PAGECOUNT);
        }
        if (item.getCount() % PAGECOUNT > 0) {
            item.setページ分母((item.getCount() - (item.getCount() % PAGECOUNT)) / PAGECOUNT + 1);
        } else {
            item.setページ分母(item.getCount() / PAGECOUNT);
        }
    }
}
