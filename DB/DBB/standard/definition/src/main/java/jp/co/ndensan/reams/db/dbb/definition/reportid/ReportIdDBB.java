/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.reportid;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 帳票ＩＤの列挙型です。
 *
 * @reamsid_L DBB-9999-022 liuyang
 */
public enum ReportIdDBB {

    /**
     * 所得照会票【Ａ４横（標準版）】
     */
    DBB100001(new ReportId("DBB100001_ShotokuShokaihyoA4Yoko"), new RString("所得照会票【Ａ４横（標準版）】")),
    /**
     * 所得照会票【Ａ４縦】
     */
    DBB100002(new ReportId("DBB100002_ShotokuShokaihyoA4Tate"), new RString("所得照会票【Ａ４縦】")),
    /**
     * 保険料納入通知書（仮算定）【コンビニ期毎タイプ（連帳）】
     */
    DBB100029(new ReportId("DBB100029_KarisanteiNonyuTsuchishoCVSKigotoRencho"),
            new RString("保険料納入通知書（仮算定）【コンビニ期毎タイプ（連帳）】")),
    /**
     * 保険料納入通知書（仮算定）【コンビニ角公タイプ（連帳）】
     */
    DBB100025(new ReportId("DBB100025_KarisanteiNonyuTsuchishoCVSKakukoRencho"),
            new RString("保険料納入通知書（仮算定）【コンビニ角公タイプ（連帳）】")),
    /**
     * 保険料納入通知書（仮算定）【コンビニマルチ収納タイプ通知書（連帳）】
     */
    DBB100027(new ReportId("DBB100027_KarisanteiNonyuTsuchishoCVSMultiRencho"),
            new RString("保険料納入通知書（仮算定）【コンビニマルチ収納タイプ通知書（連帳）】")),
    /**
     * 保険料納入通知書（仮算定）【ブック（口振依頼あり通知書＋納付書）タイプ（連帳）】
     */
    DBB100022(new ReportId("DBB100022_KarisanteiNonyuTsuchishoBookFuriKaeAriRencho"),
            new RString("保険料納入通知書（仮算定）【ブック（口振依頼あり通知書＋納付書）タイプ（連帳）】")),
    /**
     * 保険料納入通知書（仮算定）【ブック（口振依頼なし通知書）タイプ（連帳）】
     */
    DBB100023(new ReportId("DBB100023_KarisanteiNonyuTsuchishoBookFuriKaeNashiRencho"),
            new RString("保険料納入通知書（仮算定）【ブック（口振依頼なし通知書）タイプ（連帳）】")),
    /**
     * 保険料納入通知書（仮算定）【銀振4期タイプ（連帳）】
     */
    DBB100019(new ReportId("DBB100019_KarisanteiHokenryoNonyuTsuchishoGinfuriRencho"),
            new RString("保険料納入通知書（仮算定）【銀振4期タイプ（連帳）】")),
    /**
     * 保険料納入通知書（仮算定）【期毎タイプ（連帳）】
     */
    DBB100015(new ReportId("DBB100015_KarisanteiHokenryoNonyuTsuchishoKigotoRencho"),
            new RString("保険料納入通知書（仮算定）【期毎タイプ（連帳）】")),
    /**
     * 保険料納入通知書（本算定過年度）【コンビニ期毎タイプ】
     */
    DBB100076(new ReportId("DBB100076_KanendoNonyuTsuchishoCVSKigoto"),
            new RString("保険料納入通知書（本算定過年度）【コンビニ期毎タイプ】")),
    /**
     * 保険料納入通知書（本算定過年度）【コンビニ角公タイプ】
     */
    DBB100073(new ReportId("DBB100073_KanendoNonyuTsuchishoCVSKakuko"),
            new RString("保険料納入通知書（本算定過年度）【コンビニ角公タイプ】")),
    /**
     * 保険料納入通知書（本算定過年度）【コンビニマルチ収納タイプ通知書】
     */
    DBB100075(new ReportId("DBB100075_KanendoNonyuTsuchishoCVSMulti"),
            new RString("保険料納入通知書（本算定過年度）【コンビニマルチ収納タイプ通知書】")),
    /**
     * 保険料納入通知書（本算定過年度）【ブック（口振依頼あり通知書＋納付書）タイプ】
     */
    DBB100071(new ReportId("DBB100071_KanendoNonyuTsuchishoBookFuriKaeAri"),
            new RString("保険料納入通知書（本算定過年度）【ブック（口振依頼あり通知書＋納付書）タイプ】")),
    /**
     * 保険料納入通知書（本算定過年度）【ブック（口振依頼なし通知書＋納付書）タイプ】
     */
    DBB100072(new ReportId("DBB100072_KanendoNonyuTsuchishoBookFuriKaeNashi"),
            new RString("保険料納入通知書（本算定過年度）【ブック（口振依頼なし通知書＋納付書）タイプ】")),
    /**
     * 保険料納入通知書（本算定過年度）【銀振4期タイプ】
     */
    DBB100069(new ReportId("DBB100069_KanendoHokenryoNonyuTsuchishoGinfuriFourKi"),
            new RString("保険料納入通知書（本算定過年度）【銀振4期タイプ】")),
    /**
     * 保険料納入通知書（本算定過年度）【銀振5期タイプ】
     */
    DBB100070(new ReportId("DBB100070_KanendoHokenryoNonyuTsuchishoGinfuriFiveKi"),
            new RString("保険料納入通知書（本算定過年度）【銀振5期タイプ】")),
    /**
     * 保険料納入通知書（本算定過年度）【期毎タイプ】
     */
    DBB100066(new ReportId("DBB100066_KanendoHokenryoNonyuTsuchishoKigoto"), new RString("保険料納入通知書（本算定過年度）【期毎タイプ】")),
    /**
     * 保険料納入通知書（仮算定）【期毎タイプ】
     */
    DBB100014(new ReportId("DBB100014_KarisanteiHokenryoNonyuTsuchishoKigoto"), new RString("保険料納入通知書（仮算定）【期毎タイプ】")),
    /**
     * 保険料納入通知書（仮算定）【銀振4期タイプ】
     */
    DBB100018(new ReportId("DBB100018_KarisanteiHokenryoNonyuTsuchishoGinfuri"), new RString("保険料納入通知書（仮算定）【銀振4期タイプ】")),
    /**
     * 保険料納入通知書（仮算定）【ブック（口振依頼なし通知書＋納付書）タイプ】
     */
    DBB100021(new ReportId("DBB100021_KarisanteiHokenryoNonyuTsuchishoBookFuriKaeNashi"),
            new RString("保険料納入通知書（仮算定）【ブック（口振依頼なし通知書＋納付書）タイプ】")),
    /**
     * 保険料納入通知書（仮算定）【ブック（口振依頼あり通知書＋納付書）タイプ】
     */
    DBB100020(new ReportId("DBB100020_KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAri"),
            new RString("保険料納入通知書（仮算定）【ブック（口振依頼あり通知書＋納付書）タイプ】")),
    /**
     * 保険料納入通知書（仮算定）【コンビニマルチ収納タイプ通知書】
     */
    DBB100026(new ReportId("DBB100026_KarisanteiNonyuTsuchishoCVSMulti"),
            new RString("保険料納入通知書（仮算定）【コンビニマルチ収納タイプ通知書】")),
    /**
     * 保険料納入通知書（仮算定）【コンビニ角公タイプ】
     */
    DBB100024(new ReportId("DBB100024_KarisanteiNonyuTsuchishoCVSKakuko"),
            new RString("保険料納入通知書（仮算定）【コンビニ角公タイプ】")),
    /**
     * 保険料納入通知書（仮算定）【コンビニ期毎タイプ】
     */
    DBB100028(new ReportId("DBB100028_KarisanteiNonyuTsuchishoCVSKigoto"),
            new RString("保険料納入通知書（仮算定）【コンビニ期毎タイプ】")),
    /**
     * 本算定結果一覧表
     */
    DBB200009(new ReportId("DBB200009_HonsanteiKekkaIcihiran"), new RString("本算定結果一覧表")),
    /**
     * 保険料納入通知書（本算定）【コンビニ角公タイプ】
     */
    DBB100059(new ReportId("DBB100059_NonyuTsuchishoCVSKakuko"), new RString("保険料納入通知書（本算定）【コンビニ角公タイプ】")),
    /**
     * 保険料納入通知書（本算定）【コンビニ角公タイプ（連帳）】
     */
    DBB100060(new ReportId("DBB100060_NonyuTsuchishoCVSKakukoRencho"), new RString("保険料納入通知書（本算定）【コンビニ角公タイプ（連帳）】")),
    /**
     * 保険料納入通知書（本算定）【コンビニマルチ収納タイプ通知書（連帳）】
     */
    DBB100062(new ReportId("DBB100062_NonyuTsuchishoCVSMultiRencho"),
            new RString("保険料納入通知書（本算定）【コンビニマルチ収納タイプ通知書（連帳）】")),
    /**
     * 保険料納入通知書（本算定）【コンビニマルチ収納タイプ納付書】
     */
    DBB100061(new ReportId("DBB100061_NonyuTsuchishoCVSMulti"),
            new RString("保険料納入通知書（本算定）【コンビニマルチ収納タイプ納付書】")),
    /**
     * 保険料納入通知書（本算定）【ブック（口振依頼あり通知書＋納付書）タイプ（連帳）】
     */
    DBB100057(new ReportId("DBB100057_NonyuTsuchishoBookFuriKaeAriRencho"),
            new RString("保険料納入通知書（本算定）【ブック（口振依頼あり通知書＋納付書）タイプ（連帳）】")),
    /**
     * 保険料納入通知書（本算定）【ブック（口振依頼なし通知書＋納付書）タイプ（連帳）】
     */
    DBB100058(new ReportId("DBB100058_HokenryoNonyuTsuchishoBookFuriKaeNashiRencho"),
            new RString("保険料納入通知書（本算定）【ブック（口振依頼なし通知書＋納付書）タイプ（連帳）】")),
    /**
     * 保険料納入通知書（本算定）【銀振4期タイプ（連帳）】
     */
    DBB100052(new ReportId("DBB100052_HokenryoNonyuTsuchishoGinfuriFourKiRencho"),
            new RString("保険料納入通知書（本算定）【銀振4期タイプ（連帳）】")),
    /**
     * 保険料納入通知書（本算定）【銀振5期タイプ（連帳）】
     */
    DBB100054(new ReportId("DBB100054_HokenryoNonyuTsuchishoGinfuriFiveKiRencho"),
            new RString("保険料納入通知書（本算定）【銀振5期タイプ（連帳）】")),
    /**
     * 保険料納入通知書（本算定）【期毎タイプ（連帳）】
     */
    DBB100046(new ReportId("DBB100046_HokenryoNonyuTsuchishoKigotoRencho"),
            new RString("保険料納入通知書（本算定）【期毎タイプ（連帳）】")),
    /**
     * 保険料納入通知書（本算定）【コンビニ期毎タイプ（連帳）】
     */
    DBB100064(new ReportId("DBB100064_NonyuTsuchishoCVSKigotoRencho"),
            new RString("保険料納入通知書（本算定）【コンビニ期毎タイプ（連帳）】")),
    /**
     * 特別徴収開始通知書（本算定）【シーラタイプ（連帳）】
     */
    DBB100035(new ReportId("DBB100035_TokubetsuChoshuKaishiTsuchishoSealerRencho"),
            new RString("特別徴収開始通知書（本算定）【シーラタイプ（連帳）】")),
    /**
     * 特別徴収開始通知書（本算定）【B5横タイプ2（連帳）】
     */
    DBB100037(new ReportId("DBB100037_TokubetsuChoshuKaishiTsuchishoB52Rencho"),
            new RString("特別徴収開始通知書（本算定）【B5横タイプ2（連帳）】")),
    /**
     * 特別徴収開始通知書（本算定）【B5横タイプ（連帳）】
     */
    DBB100033(new ReportId("DBB100033_TokubetsuChoshuKaishiTsuchishoB5Rencho"),
            new RString("特別徴収開始通知書（本算定）【B5横タイプ（連帳）】")),
    /**
     * 介護保険料徴収猶予取消通知書【B5横タイプ】
     */
    DBB100083(new ReportId("DBB100083_KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoB5Yoko"),
            new RString("介護保険料徴収猶予取消通知書【B5横タイプ】")),
    /**
     * 介護保険料徴収猶予取消通知書【A4縦タイプ】
     */
    DBB100084(new ReportId("DBB100084_KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoA4Tate"),
            new RString("介護保険料徴収猶予取消通知書【A4縦タイプ】")),
    /**
     * 介護保険料減免取消通知書【B5横タイプ】
     */
    DBB100079(new ReportId("DBB100079_KaigoHokenHokenryoGenmenTorikeshiTsuchishoB5Yoko"), new RString("介護保険料減免取消通知書【B5横タイプ】")),
    /**
     * 介護保険料減免取消通知書【A4縦タイプ】
     */
    DBB100080(new ReportId("DBB100080_KaigoHokenHokenryoGenmenTorikeshiTsuchishoA4Tate"), new RString("介護保険料減免取消通知書【A4縦タイプ】")),
    /**
     * 介護保険料額決定通知書【B5横タイプ】
     */
    DBB100039(new ReportId("DBB100039_KaigoHokenHokenryogakuKetteiTsuchishoB5Yoko"), new RString("介護保険料額決定通知書【B5横タイプ】")),
    /**
     * 介護保険料額決定通知書【A4縦タイプ】
     */
    DBB100040(new ReportId("DBB100040_KaigoHokenHokenryogakuKetteiTsuchishoA4Tate"), new RString("介護保険料額決定通知書【A4縦タイプ】")),
    /**
     * 介護保険料額決定通知書【A4縦タイプ（連帳）】
     */
    DBB100041(new ReportId("DBB100041_KaigoHokenHokenryogakuKetteiTsuchishoA4Rencho"), new RString("介護保険料額決定通知書【A4縦タイプ（連帳）】")),
    /**
     * 介護保険料額変更兼特別徴収中止通知書【B5横タイプ】
     */
    DBB100042(new ReportId("DBB100042_KaigoHokenHokenryogakuHenkoKenChushiTsuchishoB5Yoko"),
            new RString("介護保険料額変更兼特別徴収中止通知書【B5横タイプ】")),
    /**
     * 介護保険料額変更兼特別徴収中止通知書【A4縦タイプ】
     */
    DBB100043(new ReportId("DBB100043_KaigoHokenHokenryogakuHenkoKenChushiTsuchishoA4Tate"),
            new RString("介護保険料額変更兼特別徴収中止通知書【A4縦タイプ】")),
    /**
     * 介護保険料額変更兼特別徴収中止通知書【A4縦タイプ（連帳）】
     */
    DBB100044(new ReportId("DBB100044_KaigoHokenryogakuHenkoKenChushiTsuchishoA4TateRencho"),
            new RString("介護保険料額変更兼特別徴収中止通知書【A4縦タイプ（連帳）】")),
    /**
     * 特別徴収開始通知書（本算定）【B5横タイプ】
     */
    DBB100032(new ReportId("DBB100032_TokubetsuChoshuKaishiTsuchishoB5"), new RString("特別徴収開始通知書（本算定）【B5横タイプ】")),
    /**
     * 特別徴収開始通知書（本算定）【B5横タイプ2】
     */
    DBB100036(new ReportId("DBB100036_TokubetsuChoshuKaishiTsuchishoB52"), new RString("特別徴収開始通知書（本算定）【B5横タイプ2】")),
    /**
     * 特別徴収開始通知書（本算定）【A4縦・オーバレイタイプ】
     */
    DBB100038(new ReportId("DBB100038_TokubetsuChoshuKaishiTsuchishoOverlayA4Tate"),
            new RString("特別徴収開始通知書（本算定）【A4縦・オーバレイタイプ】")),
    /**
     * 特別徴収開始通知書（本算定）【シーラタイプ】
     */
    DBB100034(new ReportId("DBB100034_TokubetsuChoshuKaishiTsuchishoSealer"), new RString("特別徴収開始通知書（本算定）【シーラタイプ】")),
    /**
     * 保険料納入通知書（本算定）【コンビニ期毎タイプ】
     */
    DBB100063(new ReportId("DBB100063_NonyuTsuchishoCVSKigoto"), new RString("保険料納入通知書（本算定）【コンビニ期毎タイプ】")),
    /**
     * 保険料納入通知書（本算定）【ブック（口振依頼あり通知書＋納付書）タイプ】
     */
    DBB100055(new ReportId("DBB100055_NonyuTsuchishoBookFuriKaeAri"),
            new RString("保険料納入通知書（本算定）【ブック（口振依頼あり通知書＋納付書）タイプ】")),
    /**
     * 保険料納入通知書（本算定）【ブック（口振依頼なし通知書＋納付書）タイプ】
     */
    DBB100056(new ReportId("DBB100056_HokenryoNonyuTsuchishoBookFuriKaeNashi"),
            new RString("保険料納入通知書（本算定）【ブック（口振依頼なし通知書＋納付書）タイプ】")),
    /**
     * 保険料納入通知書（本算定）【銀振4期タイプ】
     */
    DBB100051(new ReportId("DBB100051_HokenryoNonyuTsuchishoGinfuriFourKi"), new RString("保険料納入通知書（本算定）【銀振4期タイプ】")),
    /**
     * 保険料納入通知書（本算定）【銀振5期タイプ】
     */
    DBB100053(new ReportId("DBB100053_HokenryoNonyuTsuchishoGinfuriFiveKi"), new RString("保険料納入通知書（本算定）【銀振5期タイプ】")),
    /**
     * 保険料納入通知書（本算定）【期毎タイプ】
     */
    DBB100045(new ReportId("DBB100045_HokenryoNonyuTsuchishoKigoto"), new RString("保険料納入通知書（本算定）【期毎タイプ】")),
    /**
     * 仮算定額変更通知書【A4縦タイプ】
     */
    DBB100011(new ReportId("DBB100011_KarisanteiHenkoTsuchishoA4Tate"), new RString("仮算定額変更通知書【A4縦タイプ】")),
    /**
     * 仮算定額変更通知書【B5横タイプ】
     */
    DBB100010(new ReportId("DBB100010_KarisanteiHenkoTsuchishoB5Yoko"), new RString("仮算定額変更通知書【B5横タイプ】")),
    /**
     * 仮算定額変更通知書【A4縦・特別徴収平準化通知タイプ】
     */
    DBB100013(new ReportId("DBB100013_KarisanteiHenjunkaHenkoTsuchishoA4Tate"), new RString("仮算定額変更通知書【A4縦・特別徴収平準化通知タイプ】")),
    /**
     * 仮算定額変更通知書【B5横・特別徴収平準化通知タイプ】
     */
    DBB100012(new ReportId("DBB100012_KarisanteiHenjunkaHenkoTsuchishoB5Yoko"), new RString("仮算定額変更通知書【B5横・特別徴収平準化通知タイプ】")),
    /**
     * 特別徴収開始通知書（仮算定）【B5横タイプ】
     */
    DBB100003(new ReportId("DBB100003_TokubetsuChoshuKaishiTsuchishoKariB5"), new RString("特別徴収開始通知書（仮算定）【B5横タイプ】")),
    /**
     * 特別徴収開始通知書（仮算定）【B5横タイプ（連帳）】
     */
    DBB100004(new ReportId("DBB100004_TokubetsuChoshuKaishiTsuchishoKariB5Rencho"), new RString("特別徴収開始通知書（仮算定）【B5横タイプ（連帳）】")),
    /**
     * 特別徴収開始通知書（仮算定）【シーラタイプ】
     */
    DBB100005(new ReportId("DBB100005_TokubetsuChoshuKaishiTsuchishoKariSealer"), new RString("特別徴収開始通知書（仮算定）【シーラタイプ】")),
    /**
     * 特別徴収開始通知書（仮算定）【シーラタイプ（連帳）】
     */
    DBB100006(new ReportId("DBB100006_TokubetsuChoshuKaishiTsuchishoKariSealerRencho"), new RString("特別徴収開始通知書（仮算定）【シーラタイプ（連帳）】")),
    /**
     * 特別徴収開始通知書（仮算定）【A4縦・オーバレイタイプ】
     */
    DBB100008(new ReportId("DBB100008_TokubetsuChoshuKaishiTsuchishoKariOverlayA4Tate"), new RString("特別徴収開始通知書（仮算定）【A4縦・オーバレイタイプ】")),
    /**
     * 特別徴収開始通知書（仮算定）【B5横・オーバレイタイプ】
     */
    DBB100009(new ReportId("DBB100009_TokubetsuChoshuKaishiTsuchishoKariOverlayB5Yoko"), new RString("特別徴収開始通知書（仮算定）【B5横・オーバレイタイプ】")),
    /**
     * 仮算定異動（一括）結果一覧表の帳票ID
     */
    DBB200013(new ReportId("DBB200013_KarisanteiIdoKekkaIchiran"), new RString("仮算定異動（一括）結果一覧表")),
    /**
     * 調定簿（帳票）
     */
    DBB3001(new ReportId("DBB300001_Choteibo"), new RString("介護保険料　調定簿")),
    /**
     * 賦課台帳（本算定）の帳票ID
     */
    DBB100065(new ReportId("DBB100065_FukaDaicho"), new RString("賦課台帳 本算定")),
    /**
     * 月別推移表の帳票ID。
     */
    DBB300002(new ReportId("DBB300002_TsukibetsuSuiihyo"), new RString("月別推移表")),
    /**
     * 通知書発行後異動対象者一覧の帳票ID
     */
    DBB200028(new ReportId("DBB200028_HakkogoIdoTaishoshaIchiran"), new RString("通知書発行後異動対象者一覧")),
    /**
     * 介護保険料減免決定通知書A4縦タイプ帳票
     */
    DBB100078(new ReportId("DBB100078_KaigoHokenHokenryoGenmenKetteiTsuchishoA4Tate"), new RString("介護保険料減免決定通知書A4縦タイプ.")),
    /**
     * 介護保険料減免決定通知書B5横タイプ
     */
    DBB100077(new ReportId("DBB100077_KaigoHokenHokenryoGenmenKetteiTsuchishoB5Yoko"), new RString("介護保険料減免決定通知書B5横タイプ.")),
    /**
     * 賦課台帳（仮算定）の帳票ID
     */
    DBB100031(new ReportId("DBB100031_KarisanteiFukaDaicho"), new RString("賦課台帳 仮算定")),
    /**
     * 介護保険料徴収猶予決定通知書B5横タイプの帳票ID
     */
    DBB100081(new ReportId("DBB100081_KaigoHokenHokenryoChoshuyoyoKetteiTsuchishoB5Yoko"), new RString("介護保険料徴収猶予決定通知書")),
    /**
     * 介護保険料徴収猶予決定通知書A4縦タイプの帳票ID
     */
    DBB100082(new ReportId("DBB100082_KaigoHokenHokenryoChoshuyoyoKetteiTsuchishoA4Tate"), new RString("介護保険料徴収猶予決定通知書")),
    /**
     * 保険料納入通知書（本算定）の帳票ID
     */
    DBB200010(new ReportId("DBB200010_NonyuTsuchishoHonsanteiHakkoIchiran"), new RString("保険料納入通知書 本算定")),
    /**
     * 介護保険料額決定通知書発行一覧表の帳票ID
     */
    DBB200012(new ReportId("DBB200012_KaigoHokenryogakuKetteiHenkoTsuchiHakkoIchiran"), new RString("介護保険料額決定通知書発行 一覧表")),
    /**
     * 特別徴収開始通知書（本算定）発行一覧表の帳票ID
     */
    DBB200001(new ReportId("DBB200001_TokubetsuChoshuKaishiTsuchishoKariHakkoIchiran"), new RString("特別徴収開始通知書 本算定")),
    /**
     * 特別徴収開始通知書（本算定）発行一覧表の帳票ID
     */
    DBB200002(new ReportId("DBB200002_TokubetsuChoshuKarisanteiKekkaIchiran"), new RString("特別徴収仮算定結果一覧表")),
    /**
     * 特別徴収平準化計算（特別徴収6月分）結果一覧表の帳票ID
     */
    DBB200003(new ReportId("DBB200003_TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiran"), new RString("特別徴収平準化計算（特別徴収6月分）結果一覧表")),
    /**
     * 特別徴収平準化仮算定額変更通知書発行一覧表の帳票ID
     */
    DBB200004(new ReportId("DBB200004_TokuChoHeijunkaTsuchishoHakkoIchiran"), new RString("特別徴収平準化仮算定額変更通知書発行一覧表")),
    /**
     * 普徴仮算定結果一覧表の帳票ID
     */
    DBB200006(new ReportId("DBB200006_FutsuChoshuKarisanteiKekkaIchiran"), new RString("普徴仮算定結果一覧表")),
    /**
     * 介護保険所得情報一覧表の帳票ID
     */
    DBB200008(new ReportId("DBB200008_KaigoHokenShotokuJohoIchiran"), new RString("介護保険所得情報一覧表")),
    /**
     * 保険料納入通知書（本算定過年度異動）発行一覧表の帳票ID
     */
    DBB200011(new ReportId("DBB200011_TokubetsuChoshuKaishiTsuchishoHonsanteiHakkoIchiran"), new RString("特別徴収開始通知書（本算定）発行一覧表")),
    /**
     * 仮算定額変更通知書発行一覧表の帳票ID
     */
    DBB200014(new ReportId("DBB200014_KariSanteigakuHenkoTsuchishoHakkoIchiran"), new RString("仮算定額変更通知書発行一覧表")),
    /**
     * /**
     * 本算定異動（現年度）結果一覧表の帳票ID
     */
    DBB200015(new ReportId("DBB200015_HonsanteiIdouKekkaIchiran"), new RString("本算定異動（現年度）結果一覧表")),
    /**
     * 保険料納入通知書（本算定現年度異動）発行一覧表の帳票ID
     */
    DBB200016(new ReportId("DBB200016_HonsanteiGennendoIdoNonyutsuchishoHakkoIchiran"), new RString("保険料納入通知書（本算定現年度異動）発行一覧表")),
    /**
     * 保険料納入通知書（本算定過年度異動）発行一覧表の帳票ID
     */
    DBB200017(new ReportId("DBB200017_HonsanteiKanendoIdoNonyutsuchishoHakkoIchiran"), new RString("保険料納入通知書（本算定過年度異動）発行一覧表")),
    /**
     * 特別徴収依頼金額明細一覧表の帳票ID
     */
    DBB200023(new ReportId("DBB200023_TokubetsuChoshuIraikingakuMeisaiIchiran"), new RString("特別徴収依頼金額明細一覧表")),
    /**
     * 所得照会票発行一覧表の帳票ID
     */
    DBB200024(new ReportId("DBB200024_ShotokushokaihyoHakkoIchiran"), new RString("所得照会票発行一覧表")),
    /**
     * 介護保険　特別徴収同定一覧表の帳票ID
     */
    DBB200031(new ReportId("DBB200031_TokubetsuChoshuDoteiIchiran"), new RString("介護保険　特別徴収同定一覧表")),
    /**
     * 介護保険　特別徴収同定一覧表の帳票ID
     */
    DBB200032(new ReportId("DBB200032_TokubetsuChoshuMidoteiIchiran"), new RString("介護保険　特別徴収未同定一覧表")),
    /**
     *
     * 本算定異動（過年度）結果一覧表の帳票ID
     */
    DBB200027(new ReportId("DBB200027_KanendoIdouKekkaIchiran"), new RString("本算定異動（過年度）結果一覧表")),
    /**
     * 保険料納入通知書（仮算定）発行一覧表の帳票ID
     */
    DBB200007(new ReportId("DBB200007_KariNonyuTsuchishoHakkoIchiran"), new RString("保険料納入通知書（仮算定）発行一覧表"));

    private final ReportId reportId;
    private final RString reportName;

    private ReportIdDBB(ReportId reportId, RString reportName) {
        this.reportId = reportId;
        this.reportName = reportName;
    }

    /**
     * 帳票ＩＤの取得します。
     *
     * @return 帳票ＩＤ
     */
    public ReportId getReportId() {
        return reportId;
    }

    /**
     * 帳票Nameの取得します。
     *
     * @return 帳票Name
     */
    public RString getReportName() {
        return reportName;
    }

}
