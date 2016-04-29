/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.gemmen;

import jp.co.ndensan.reams.db.dbb.entity.report.gemmen.KaigoHokenryoGenmenKetteiTsuchishoTateSource;

/**
 * 介護保険料減免決定通知書 A4縦タイプEditorクラスです。
 *
 * @reamsid_L DBB-0740-030 surun
 */
public class GenmenKetteiTsuchiShoTateEditor implements IGenmenKetteiTsuchiShoTateEditor {

    private final GenmenKetteiTsuchiShoItem item;

    /**
     * コンストラクタです。
     *
     * @param item TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranItem
     */
    public GenmenKetteiTsuchiShoTateEditor(GenmenKetteiTsuchiShoItem item) {
        this.item = item;
    }

    @Override
    public KaigoHokenryoGenmenKetteiTsuchishoTateSource edit(KaigoHokenryoGenmenKetteiTsuchishoTateSource source) {
        source.bunshoNo = item.get文書番号();
        source.choteiNendo = item.get調定年度();
        source.fukaNendo = item.get賦課年度();
        source.ketteiKekka = item.get決定結果();
        source.hyojicodeName1 = item.get表示コード名称１();
        source.hyojicodeName2 = item.get表示コード名称２();
        source.hyojicodeName3 = item.get表示コード名称３();
        source.hyojicode1 = item.get表示コード１();
        source.hyojicode2 = item.get表示コード２();
        source.hyojicode3 = item.get表示コード３();
        source.tsuchisjoNo = item.get通知書番号();
        source.setaiCode = item.get世帯コード();
        source.hihokenshaNo = item.get被保険者番号();
        source.shikibetsuCode = item.get識別コード();
        source.genmenKetteiYMD = item.get減免決定年月日();
        source.genmenGakuMae = item.get減免額前();
        source.hokenSanshutsuMae = item.get保険料算出額前();
        source.hokenGakuMae = item.get保険料額前();
        source.genmenGakuAto = item.get減免額後();
        source.hokenSanshutsuAto = item.get保険料算出額後();
        source.hokenGakuAto = item.get保険料額後();
        source.genmenRiyu1 = item.get減免理由1();
        source.genmenRiyu2 = item.get減免理由2();
        source.listKibetsu_1 = item.get期別1();
        source.listKibetsu_2 = item.get期別2();
        source.listKibetsu_3 = item.get期別3();
        source.listKibetsu_4 = item.get期別4();
        source.listKibetsu_5 = item.get期別5();
        source.listKibetsu_6 = item.get期別6();
        source.listKibetsu_7 = item.get期別7();
        source.listKibetsu_8 = item.get期別8();
        source.listZuiji_1 = item.get随時List();
        source.bikoTitle = item.get備考Title();
        source.biko = item.get備考();
        source.hakkoYMD = item.get発行日();
        source.denshiKoin = item.get電子公印();
        source.ninshoshaYakushokuMei = item.get認証者役職名();
        source.koinMojiretsu = item.get公印文字列();
        source.ninshoshaShimeiKakenai = item.get認証者氏名公印に掛けない();
        source.ninshoshaShimeiKakeru = item.get認証者氏名公印に掛ける();
        source.yubinBango = item.get郵便番号Bango();
        source.shozaichi = item.get所在地();
        source.choshaBushoName = item.get庁舎部署名();
        source.tantoName = item.get担当名();
        source.telNo = item.get電話番号();
        source.naisenNo = item.get内線番号();
        source.yubinNo = item.get郵便番号No();
        source.gyoseiku = item.get行政区();
        source.jusho3 = item.get住所3();
        source.jushoText = item.get住所();
        source.jusho1 = item.get住所1();
        source.jusho2 = item.get住所2();
        source.katagakiText = item.get方書();
        source.katagaki2 = item.get方書2();
        source.katagakiSmall2 = item.get方書Small2();
        source.katagaki1 = item.get方書1();
        source.katagakiSmall1 = item.get方書Small1();
        source.kakkoRight2 = item.get右括弧2();
        source.kakkoRight1 = item.get右括弧1();
        source.shimei2 = item.get氏名2();
        source.shimeiSmall2 = item.get氏名Small2();
        source.shimeiText = item.get氏名();
        source.meishoFuyo2 = item.get名称付与2();
        source.shimeiSmall1 = item.get氏名Small1();
        source.dainoKubunMei = item.get代納区分名();
        source.shimei1 = item.get氏名1();
        source.meishoFuyo1 = item.get名称付与1();
        source.samabunShimeiText = item.get様分氏名();
        source.samabunShimeiSmall2 = item.get様分氏名Small2();
        source.samaBun2 = item.get様分2();
        source.kakkoLeft2 = item.get左括弧2();
        source.samabunShimei2 = item.get様分氏名2();
        source.kakkoLeft1 = item.get左括弧1();
        source.samabunShimei1 = item.get様分氏名1();
        source.samaBun1 = item.get様分1();
        source.samabunShimeiSmall1 = item.get様分氏名Small1();
        source.customerBarCode = item.getカスタマバーコード();
        // TODO (QA655) 世帯主名 将来に追加する
        // TODO (QA655) 様方 将来に追加する
        return source;
    }

}
