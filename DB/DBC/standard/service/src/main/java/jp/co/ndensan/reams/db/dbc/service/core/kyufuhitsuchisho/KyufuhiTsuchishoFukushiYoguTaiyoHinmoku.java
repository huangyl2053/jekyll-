/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyufuhitsuchisho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufuhitsuchisho.KyufuhiTsuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhitsuchishofukushiyogutaiyohinmoku.KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護保険給付費通知書(福祉用具貸与品目)の帳票データを作成するクラスです。
 *
 * @reamsid_L DBC-2280-030 lizhuoxuan
 */
public class KyufuhiTsuchishoFukushiYoguTaiyoHinmoku {

    private static final Decimal 数値_100 = new Decimal(100);
    private static final int NUM_NINE = 9;

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
        coverEntity.set被保険者氏名(hakkoEntity.get名称());
        coverEntity.set被保険者番号(hakkoEntity.get被保険者番号());
        coverEntity.setサービス集計開始年月(processParameter.getサービス年月開始());
        coverEntity.setサービス集計終了年月(processParameter.getサービス年月終了());
        if (hakkoEntity.getRelateEntity() != null && hakkoEntity.getRelateEntity().getServiceTeikyoYM() != null) {
            coverEntity.setサービス年月(new RString(hakkoEntity.getRelateEntity().getServiceTeikyoYM().toString()));
        }
        if (hakkoEntity.getRelateEntity() != null && hakkoEntity.getRelateEntity().getJigyoshoKanji() != null) {
            coverEntity.setサービス事業所(hakkoEntity.getRelateEntity().getJigyoshoKanji());
        }
        if (hakkoEntity.getRelateEntity() != null && hakkoEntity.getRelateEntity().getFukushiYouguShouhin() != null) {
            coverEntity.setタイコード(hakkoEntity.getRelateEntity().getFukushiYouguKaHinmokuCode());
        }
        if (hakkoEntity.getRelateEntity() != null && hakkoEntity.getRelateEntity().getFukushiYouguShouhin() != null) {
            coverEntity.set福祉用具商品名(hakkoEntity.getRelateEntity().getFukushiYouguShouhin());
        }
        if (hakkoEntity.getRelateEntity() != null && hakkoEntity.getRelateEntity().getHiyouGaku() != null) {
            coverEntity.set費用額(hakkoEntity.getRelateEntity().getHiyouGaku());
        }
        if (hakkoEntity.getRelateEntity() != null) {
            coverEntity = 帳票データ作成1(hakkoEntity, coverEntity);
            coverEntity = 帳票データ作成2(hakkoEntity, coverEntity);
            coverEntity = 帳票データ作成3(hakkoEntity, coverEntity);
        }
        return coverEntity;
    }

    private KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity 帳票データ作成1(KyufuhiTuchiHakkoEntity hakkoEntity,
            KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity coverEntity) {
        RStringBuilder builderイトル1 = new RStringBuilder();
        if (hakkoEntity.getRelateEntity() != null && hakkoEntity.getRelateEntity().getServiceTeikyoYM() != null) {
            builderイトル1.append(new RString(hakkoEntity.getRelateEntity().getServiceTeikyoYM().toString()));
        }
        builderイトル1.append(new RString("全国費用額分布状況【"));
        if (hakkoEntity.getRelateEntity() != null && hakkoEntity.getRelateEntity().getFukushiYouguShouhin() != null) {
            builderイトル1.append(hakkoEntity.getRelateEntity().getFukushiYouguShouhin());
        }
        builderイトル1.append(new RString("】"));
        coverEntity.set参考資料タイトル1(builderイトル1.toRString());
        List<jp.co.ndensan.reams.uz.uza.math.Decimal> 費用額円_1 = new ArrayList<>();
        費用額円_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani1());
        費用額円_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani2());
        費用額円_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani3());
        費用額円_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani4());
        費用額円_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani5());
        費用額円_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani6());
        費用額円_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani7());
        費用額円_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani8());
        費用額円_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani9());
        費用額円_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani10());
        coverEntity.set費用額円_1(費用額円_1);
        Collections.sort(coverEntity.get費用額円_1(), new Comparator<Decimal>() {
            @Override
            public int compare(Decimal rst1, Decimal rst2) {
                return rst1.compareTo(rst2);
            }
        });
        List<jp.co.ndensan.reams.uz.uza.math.Decimal> 件数件_1 = new ArrayList<>();
        件数件_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani1Dosu());
        件数件_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani2Dosu());
        件数件_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani3Dosu());
        件数件_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani4Dosu());
        件数件_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani5Dosu());
        件数件_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani6Dosu());
        件数件_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani7Dosu());
        件数件_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani8Dosu());
        件数件_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani9Dosu());
        件数件_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani10Dosu());
        coverEntity.set件数件_1(件数件_1);
        Decimal kensu = (hakkoEntity.getRelateEntity().getZenkokuTanisuHani1Dosu().
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani2Dosu()).
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani3Dosu()).
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani4Dosu()).
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani5Dosu()).
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani6Dosu()).
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani7Dosu()).
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani8Dosu()).
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani9Dosu()).
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani10Dosu()));
        List<jp.co.ndensan.reams.uz.uza.math.Decimal> 割合_1 = new ArrayList<>();
        割合_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani1Dosu().divide(kensu).multiply(数値_100));
        割合_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani2Dosu().divide(kensu).multiply(数値_100));
        割合_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani3Dosu().divide(kensu).multiply(数値_100));
        割合_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani4Dosu().divide(kensu).multiply(数値_100));
        割合_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani5Dosu().divide(kensu).multiply(数値_100));
        割合_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani6Dosu().divide(kensu).multiply(数値_100));
        割合_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani7Dosu().divide(kensu).multiply(数値_100));
        割合_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani8Dosu().divide(kensu).multiply(数値_100));
        割合_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani9Dosu().divide(kensu).multiply(数値_100));
        割合_1.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani10Dosu().divide(kensu).multiply(数値_100));
        coverEntity.set割合_1(割合_1);
        if (coverEntity.get費用額円_1().get(0).compareTo(coverEntity.get費用額()) <= 0
                && coverEntity.get費用額().compareTo(coverEntity.get費用額円_1().get(NUM_NINE)) <= 0) {
            coverEntity.setあなたの位置1(new RString("◆"));
        }
        List<jp.co.ndensan.reams.uz.uza.math.Decimal> 全国1 = new ArrayList<>();
        全国1.add(hakkoEntity.getRelateEntity().getZenkokuSeikyuKensu());
        全国1.add(hakkoEntity.getRelateEntity().getZenkokuSaiteiHiyouGaku());
        全国1.add(hakkoEntity.getRelateEntity().getZenkokuShikiHiyouGaku());
        全国1.add(hakkoEntity.getRelateEntity().getZenkokuSaikouHiyouGaku());
        全国1.add(hakkoEntity.getRelateEntity().getZenkokuHeikinHiyouGaku());
        coverEntity.set全国1(全国1);
        List<jp.co.ndensan.reams.uz.uza.math.Decimal> 都道府県1 = new ArrayList<>();
        都道府県1.add(hakkoEntity.getRelateEntity().getTodoufukenSeikyuKensu());
        都道府県1.add(hakkoEntity.getRelateEntity().getTodoufukenSaiteiHiyouGaku());
        都道府県1.add(hakkoEntity.getRelateEntity().getTodoufukenShikiHiyouGaku());
        都道府県1.add(hakkoEntity.getRelateEntity().getTodoufukenSaikouHiyouGaku());
        都道府県1.add(hakkoEntity.getRelateEntity().getTodoufukenHeikinHiyouGaku());
        coverEntity.set都道府県1(都道府県1);
        List<jp.co.ndensan.reams.uz.uza.math.Decimal> 保険者1 = new ArrayList<>();
        保険者1.add(hakkoEntity.getRelateEntity().getHokenShaSeikyuKensu());
        保険者1.add(hakkoEntity.getRelateEntity().getHokenShaSaiteiHiyouGaku());
        保険者1.add(hakkoEntity.getRelateEntity().getHokenShaShikiHiyouGaku());
        保険者1.add(hakkoEntity.getRelateEntity().getHokenShaSaikouHiyouGaku());
        保険者1.add(hakkoEntity.getRelateEntity().getHokenShaHeikinHiyouGaku());
        coverEntity.set保険者1(保険者1);
        return coverEntity;
    }

    private KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity 帳票データ作成2(KyufuhiTuchiHakkoEntity hakkoEntity,
            KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity coverEntity) {
        RStringBuilder builderイトル2 = new RStringBuilder();
        if (hakkoEntity.getRelateEntity() != null && hakkoEntity.getRelateEntity().getServiceTeikyoYM() != null) {
            builderイトル2.append(new RString(hakkoEntity.getRelateEntity().getServiceTeikyoYM().toString()));
        }
        builderイトル2.append(new RString("全国費用額分布状況【"));
        if (hakkoEntity.getRelateEntity() != null && hakkoEntity.getRelateEntity().getFukushiYouguShouhin() != null) {
            builderイトル2.append(hakkoEntity.getRelateEntity().getFukushiYouguShouhin());
        }
        builderイトル2.append(new RString("】"));
        coverEntity.set参考資料タイトル2(builderイトル2.toRString());
        List<jp.co.ndensan.reams.uz.uza.math.Decimal> 費用額円_2 = new ArrayList<>();
        費用額円_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani1());
        費用額円_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani2());
        費用額円_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani3());
        費用額円_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani4());
        費用額円_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani5());
        費用額円_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani6());
        費用額円_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani7());
        費用額円_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani8());
        費用額円_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani9());
        費用額円_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani10());
        coverEntity.set費用額円_2(費用額円_2);
        Collections.sort(coverEntity.get費用額円_2(), new Comparator<Decimal>() {
            @Override
            public int compare(Decimal rst1, Decimal rst2) {
                return rst1.compareTo(rst2);
            }
        });
        List<jp.co.ndensan.reams.uz.uza.math.Decimal> 件数件_2 = new ArrayList<>();
        件数件_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani1Dosu());
        件数件_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani2Dosu());
        件数件_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani3Dosu());
        件数件_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani4Dosu());
        件数件_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani5Dosu());
        件数件_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani6Dosu());
        件数件_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani7Dosu());
        件数件_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani8Dosu());
        件数件_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani9Dosu());
        件数件_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani10Dosu());
        coverEntity.set件数件_2(件数件_2);
        Decimal kensu1 = (hakkoEntity.getRelateEntity().getZenkokuTanisuHani1Dosu().
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani2Dosu()).
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani3Dosu()).
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani4Dosu()).
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani5Dosu()).
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani6Dosu()).
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani7Dosu()).
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani8Dosu()).
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani9Dosu()).
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani10Dosu()));
        List<jp.co.ndensan.reams.uz.uza.math.Decimal> 割合_2 = new ArrayList<>();
        割合_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani1Dosu().divide(kensu1).multiply(数値_100));
        割合_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani2Dosu().divide(kensu1).multiply(数値_100));
        割合_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani3Dosu().divide(kensu1).multiply(数値_100));
        割合_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani4Dosu().divide(kensu1).multiply(数値_100));
        割合_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani5Dosu().divide(kensu1).multiply(数値_100));
        割合_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani6Dosu().divide(kensu1).multiply(数値_100));
        割合_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani7Dosu().divide(kensu1).multiply(数値_100));
        割合_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani8Dosu().divide(kensu1).multiply(数値_100));
        割合_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani9Dosu().divide(kensu1).multiply(数値_100));
        割合_2.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani10Dosu().divide(kensu1).multiply(数値_100));
        coverEntity.set割合_2(割合_2);
        if (coverEntity.get費用額円_2().get(0).compareTo(coverEntity.get費用額()) <= 0
                && coverEntity.get費用額().compareTo(coverEntity.get費用額円_2().get(NUM_NINE)) <= 0) {
            coverEntity.setあなたの位置2(new RString("◆"));
        }
        List<jp.co.ndensan.reams.uz.uza.math.Decimal> 全国2 = new ArrayList<>();
        全国2.add(hakkoEntity.getRelateEntity().getZenkokuSeikyuKensu());
        全国2.add(hakkoEntity.getRelateEntity().getZenkokuSaiteiHiyouGaku());
        全国2.add(hakkoEntity.getRelateEntity().getZenkokuShikiHiyouGaku());
        全国2.add(hakkoEntity.getRelateEntity().getZenkokuSaikouHiyouGaku());
        全国2.add(hakkoEntity.getRelateEntity().getZenkokuHeikinHiyouGaku());
        coverEntity.set全国2(全国2);
        List<jp.co.ndensan.reams.uz.uza.math.Decimal> 都道府県2 = new ArrayList<>();
        都道府県2.add(hakkoEntity.getRelateEntity().getTodoufukenSeikyuKensu());
        都道府県2.add(hakkoEntity.getRelateEntity().getTodoufukenSaiteiHiyouGaku());
        都道府県2.add(hakkoEntity.getRelateEntity().getTodoufukenShikiHiyouGaku());
        都道府県2.add(hakkoEntity.getRelateEntity().getTodoufukenSaikouHiyouGaku());
        都道府県2.add(hakkoEntity.getRelateEntity().getTodoufukenHeikinHiyouGaku());
        coverEntity.set都道府県2(都道府県2);
        List<jp.co.ndensan.reams.uz.uza.math.Decimal> 保険者2 = new ArrayList<>();
        保険者2.add(hakkoEntity.getRelateEntity().getHokenShaSeikyuKensu());
        保険者2.add(hakkoEntity.getRelateEntity().getHokenShaSaiteiHiyouGaku());
        保険者2.add(hakkoEntity.getRelateEntity().getHokenShaShikiHiyouGaku());
        保険者2.add(hakkoEntity.getRelateEntity().getHokenShaSaikouHiyouGaku());
        保険者2.add(hakkoEntity.getRelateEntity().getHokenShaHeikinHiyouGaku());
        coverEntity.set保険者2(保険者2);
        return coverEntity;
    }

    private KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity 帳票データ作成3(KyufuhiTuchiHakkoEntity hakkoEntity,
            KyufuhiTsuchishoFukushiYoguTaiyoHinmokuEntity coverEntity) {
        RStringBuilder builderイトル3 = new RStringBuilder();
        if (hakkoEntity.getRelateEntity() != null && hakkoEntity.getRelateEntity().getServiceTeikyoYM() != null) {
            builderイトル3.append(new RString(hakkoEntity.getRelateEntity().getServiceTeikyoYM().toString()));
        }
        builderイトル3.append(new RString("全国費用額分布状況【"));
        if (hakkoEntity.getRelateEntity() != null && hakkoEntity.getRelateEntity().getFukushiYouguShouhin() != null) {
            builderイトル3.append(hakkoEntity.getRelateEntity().getFukushiYouguShouhin());
        }
        builderイトル3.append(new RString("】"));
        coverEntity.set参考資料タイトル3(builderイトル3.toRString());
        List<jp.co.ndensan.reams.uz.uza.math.Decimal> 費用額円_3 = new ArrayList<>();
        費用額円_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani1());
        費用額円_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani2());
        費用額円_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani3());
        費用額円_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani4());
        費用額円_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani5());
        費用額円_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani6());
        費用額円_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani7());
        費用額円_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani8());
        費用額円_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani9());
        費用額円_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani10());
        coverEntity.set費用額円_3(費用額円_3);
        Collections.sort(coverEntity.get費用額円_3(), new Comparator<Decimal>() {
            @Override
            public int compare(Decimal rst1, Decimal rst2) {
                return rst1.compareTo(rst2);
            }
        });
        List<jp.co.ndensan.reams.uz.uza.math.Decimal> 件数件_3 = new ArrayList<>();
        件数件_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani1Dosu());
        件数件_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani2Dosu());
        件数件_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani3Dosu());
        件数件_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani4Dosu());
        件数件_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani5Dosu());
        件数件_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani6Dosu());
        件数件_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani7Dosu());
        件数件_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani8Dosu());
        件数件_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani9Dosu());
        件数件_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani10Dosu());
        coverEntity.set件数件_3(件数件_3);
        Decimal kensu2 = (hakkoEntity.getRelateEntity().getZenkokuTanisuHani1Dosu().
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani2Dosu()).
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani3Dosu()).
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani4Dosu()).
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani5Dosu()).
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani6Dosu()).
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani7Dosu()).
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani8Dosu()).
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani9Dosu()).
                add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani10Dosu()));
        List<jp.co.ndensan.reams.uz.uza.math.Decimal> 割合_3 = new ArrayList<>();
        割合_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani1Dosu().divide(kensu2).multiply(数値_100));
        割合_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani2Dosu().divide(kensu2).multiply(数値_100));
        割合_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani3Dosu().divide(kensu2).multiply(数値_100));
        割合_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani4Dosu().divide(kensu2).multiply(数値_100));
        割合_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani5Dosu().divide(kensu2).multiply(数値_100));
        割合_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani6Dosu().divide(kensu2).multiply(数値_100));
        割合_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani7Dosu().divide(kensu2).multiply(数値_100));
        割合_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani8Dosu().divide(kensu2).multiply(数値_100));
        割合_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani9Dosu().divide(kensu2).multiply(数値_100));
        割合_3.add(hakkoEntity.getRelateEntity().getZenkokuTanisuHani10Dosu().divide(kensu2).multiply(数値_100));
        coverEntity.set割合_3(割合_3);
        if (coverEntity.get費用額円_3().get(0).compareTo(coverEntity.get費用額()) <= 0
                && coverEntity.get費用額().compareTo(coverEntity.get費用額円_3().get(NUM_NINE)) <= 0) {
            coverEntity.setあなたの位置3(new RString("◆"));
        }
        List<jp.co.ndensan.reams.uz.uza.math.Decimal> 全国3 = new ArrayList<>();
        全国3.add(hakkoEntity.getRelateEntity().getZenkokuSeikyuKensu());
        全国3.add(hakkoEntity.getRelateEntity().getZenkokuSaiteiHiyouGaku());
        全国3.add(hakkoEntity.getRelateEntity().getZenkokuShikiHiyouGaku());
        全国3.add(hakkoEntity.getRelateEntity().getZenkokuSaikouHiyouGaku());
        全国3.add(hakkoEntity.getRelateEntity().getZenkokuHeikinHiyouGaku());
        coverEntity.set全国3(全国3);
        List<jp.co.ndensan.reams.uz.uza.math.Decimal> 都道府県3 = new ArrayList<>();
        都道府県3.add(hakkoEntity.getRelateEntity().getTodoufukenSeikyuKensu());
        都道府県3.add(hakkoEntity.getRelateEntity().getTodoufukenSaiteiHiyouGaku());
        都道府県3.add(hakkoEntity.getRelateEntity().getTodoufukenShikiHiyouGaku());
        都道府県3.add(hakkoEntity.getRelateEntity().getTodoufukenSaikouHiyouGaku());
        都道府県3.add(hakkoEntity.getRelateEntity().getTodoufukenHeikinHiyouGaku());
        coverEntity.set都道府県3(都道府県3);
        List<jp.co.ndensan.reams.uz.uza.math.Decimal> 保険者3 = new ArrayList<>();
        保険者3.add(hakkoEntity.getRelateEntity().getHokenShaSeikyuKensu());
        保険者3.add(hakkoEntity.getRelateEntity().getHokenShaSaiteiHiyouGaku());
        保険者3.add(hakkoEntity.getRelateEntity().getHokenShaShikiHiyouGaku());
        保険者3.add(hakkoEntity.getRelateEntity().getHokenShaSaikouHiyouGaku());
        保険者3.add(hakkoEntity.getRelateEntity().getHokenShaHeikinHiyouGaku());
        coverEntity.set保険者3(保険者3);
        return coverEntity;
    }
}
