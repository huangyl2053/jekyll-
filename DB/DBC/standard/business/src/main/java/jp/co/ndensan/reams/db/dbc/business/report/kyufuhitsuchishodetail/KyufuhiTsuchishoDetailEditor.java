/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhitsuchishodetail;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhitsuchishodetail.KyufuhiTsuchishoDetailEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhitsuchishodetail.KyufuhiTsuchishoDetailReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険給付費通知書(２ページ目以降)のEditorです。
 *
 * @reamsid_L DBC-2280-050 lizhuoxuan
 *
 */
public class KyufuhiTsuchishoDetailEditor implements IKyufuhiTsuchishoDetailEditor {

    private final KyufuhiTsuchishoDetailEntity item;
    private int index;
    private static final int PAGECOUNT = 25;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link KyufuhiTsuchishoDetailEntity}
     * @param index int
     */
    protected KyufuhiTsuchishoDetailEditor(KyufuhiTsuchishoDetailEntity item, int index) {
        this.item = item;
        this.index = index;
    }

    @Override
    public KyufuhiTsuchishoDetailReportSource edit(KyufuhiTsuchishoDetailReportSource source) {
        return editSource(source);
    }

    private KyufuhiTsuchishoDetailReportSource editSource(KyufuhiTsuchishoDetailReportSource source) {
        source.hihokenshaName = item.get被保険者氏名();
        source.hokenshaNo = item.get被保険者番号();
        source.shukeiserviceSTYM = item.getサービス集計開始年月();
        source.shukeiserviceEDYM = item.getサービス集計終了年月();
        source.listServiceIchiranUpper_1 = item.getサービス提供年月();
        source.listServiceIchiranUpper_2 = item.getサービス事業者();
        source.listServiceIchiranUpper_3 = item.getサービス種類_サービス略称();
        source.listServiceIchiranUpper_4 = item.getサービス日数_回数();
        source.listServiceIchiranUpper_5 = item.get利用者負担額合計額_円();
        source.listServiceIchiranUpper_6 = item.getサービス費用合計額_円();
        source.listServiceIchiranLower_1 = item.getサービス事業者1();
        source.listServiceIchiranLower_2 = item.getサービス種類_サービス略称1();
        source.tsuchibun1 = item.get通知文1();
        source.tsuchibun2 = item.get通知文2();
        getイメージ03(item);
        source.pageBunshi = new RString(item.getページ分子());
        source.pageBunbo = new RString(item.getページ分母());
        return source;
    }

    private void getイメージ03(KyufuhiTsuchishoDetailEntity item) {
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
