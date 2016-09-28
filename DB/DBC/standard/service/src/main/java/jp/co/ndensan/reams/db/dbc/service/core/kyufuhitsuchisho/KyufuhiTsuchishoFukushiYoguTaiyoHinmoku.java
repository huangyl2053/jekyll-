/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyufuhitsuchisho;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufuhitsuchisho.KyufuhiTsuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhitsuchishofukushiyogutaiyohinmoku.KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 介護保険給付費通知書(福祉用具貸与品目)の帳票データを作成するクラスです。
 *
 * @reamsid_L DBC-2280-030 lizhuoxuan
 */
public class KyufuhiTsuchishoFukushiYoguTaiyoHinmoku {

    /**
     * コンストラクタです。
     *
     * @param hakkoEntity KyufuhiTuchiHakkoEntity
     * @param processParameter KyufuhiTsuchishoProcessParameter
     * @return 介護保険給付費通知書のEntity
     */
    public KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity 帳票データ作成(KyufuhiTuchiHakkoEntity hakkoEntity,
            KyufuhiTsuchishoProcessParameter processParameter) {
        KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity coverEntity = new KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity();
        coverEntity.set被保険者氏名(hakkoEntity.get被保険者番号());
        coverEntity.set被保険者氏名(hakkoEntity.get被保険者番号());
        coverEntity.setサービス集計開始年月(processParameter.getサービス年月開始());
        coverEntity.setサービス集計終了年月(processParameter.getサービス年月終了());
        coverEntity.setサービス年月(new RString(hakkoEntity.getRelateEntity().getServiceTeikyoYM().toString()));
        coverEntity.setサービス事業所(hakkoEntity.getRelateEntity().getJigyoshoKanji());
        coverEntity.setタイコード(hakkoEntity.getRelateEntity().getFukushiYouguKaHinmokuCode());
        coverEntity.set福祉用具商品名(hakkoEntity.getRelateEntity().getFukushiYouguShouhin());
        coverEntity.set費用額(new RString(hakkoEntity.getRelateEntity().getHiyouGaku().toString()));
        RStringBuilder builderイトル1 = new RStringBuilder();
        builderイトル1.append(new RString(hakkoEntity.getRelateEntity().getServiceTeikyoYM().toString()));
        builderイトル1.append(new RString("全国費用額分布状況【"));
        builderイトル1.append(hakkoEntity.getRelateEntity().getFukushiYouguShouhin());
        builderイトル1.append(new RString("】"));
        coverEntity.set参考資料タイトル1(builderイトル1.toRString());
        if (hakkoEntity.getRelateEntity().getZenkokuTanisuHani1().longValue() <= hakkoEntity.getRelateEntity().getHiyouGaku().longValue()
                || hakkoEntity.getRelateEntity().getHiyouGaku().longValue() <= hakkoEntity.getRelateEntity().getZenkokuTanisuHani10().longValue()) {
            coverEntity.setあなたの位置1(new RString("◆"));
        }
        RStringBuilder builderイトル2 = new RStringBuilder();
        builderイトル2.append(new RString(hakkoEntity.getRelateEntity().getServiceTeikyoYM().toString()));
        builderイトル2.append(new RString("全国費用額分布状況【"));
        builderイトル2.append(hakkoEntity.getRelateEntity().getFukushiYouguShouhin());
        builderイトル2.append(new RString("】"));
        coverEntity.set参考資料タイトル2(builderイトル2.toRString());
        if (hakkoEntity.getRelateEntity().getZenkokuTanisuHani1().longValue() <= hakkoEntity.getRelateEntity().getHiyouGaku().longValue()
                || hakkoEntity.getRelateEntity().getHiyouGaku().longValue() <= hakkoEntity.getRelateEntity().getZenkokuTanisuHani10().longValue()) {
            coverEntity.setあなたの位置2(new RString("◆"));
        }
        RStringBuilder builderイトル3 = new RStringBuilder();
        builderイトル3.append(new RString(hakkoEntity.getRelateEntity().getServiceTeikyoYM().toString()));
        builderイトル3.append(new RString("全国費用額分布状況【"));
        builderイトル3.append(hakkoEntity.getRelateEntity().getFukushiYouguShouhin());
        builderイトル3.append(new RString("】"));
        coverEntity.set参考資料タイトル3(builderイトル3.toRString());
        if (hakkoEntity.getRelateEntity().getZenkokuTanisuHani1().longValue() <= hakkoEntity.getRelateEntity().getHiyouGaku().longValue()
                || hakkoEntity.getRelateEntity().getHiyouGaku().longValue() <= hakkoEntity.getRelateEntity().getZenkokuTanisuHani10().longValue()) {
            coverEntity.setあなたの位置3(new RString("◆"));
        }
        return coverEntity;
    }
}
