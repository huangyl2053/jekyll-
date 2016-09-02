/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd511001;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.RenZhengzheEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd511001.KoshinShinseiOshiraseTshuchishoReportSource;

/**
 * 認定更新お知らせ通知書Editorです。
 *
 * @reamsid_L DBD-2030-030 donghj
 */
public class KoshinShinseiOshiraseTshuchishoEditor implements IKoshinShinseiOshiraseTshuchishoEditor {

    private final RenZhengzheEntity 認定更新お知らせ通知書Entity;

    /**
     * インスタンスを生成します。
     *
     * @param 認定更新お知らせ通知書Entity RenZhengzheEntity
     */
    public KoshinShinseiOshiraseTshuchishoEditor(RenZhengzheEntity 認定更新お知らせ通知書Entity) {
        this.認定更新お知らせ通知書Entity = 認定更新お知らせ通知書Entity;
    }

    @Override
    public KoshinShinseiOshiraseTshuchishoReportSource edit(KoshinShinseiOshiraseTshuchishoReportSource source) {
        return edit項目(source);
    }

    private KoshinShinseiOshiraseTshuchishoReportSource edit項目(KoshinShinseiOshiraseTshuchishoReportSource source) {
        source.hakkoYMD1 = 認定更新お知らせ通知書Entity.get発行日();
        source.denshiKoin = 認定更新お知らせ通知書Entity.get電子公印();
        source.ninshoshaYakushokuMei = 認定更新お知らせ通知書Entity.get認証者役職名();
        source.ninshoshaYakushokuMei2 = 認定更新お知らせ通知書Entity.get認証者役職名2();
        source.ninshoshaYakushokuMei1 = 認定更新お知らせ通知書Entity.get認証者役職名1();
        source.koinMojiretsu = 認定更新お知らせ通知書Entity.get公印文字列();
        source.ninshoshaShimeiKakeru = 認定更新お知らせ通知書Entity.get認証者氏名_公印に掛ける();
        source.ninshoshaShimeiKakenai = 認定更新お知らせ通知書Entity.get認証者氏名_公印に掛けない();
        source.koinShoryaku = 認定更新お知らせ通知書Entity.get公印省略();

        source.yubinNo = 認定更新お知らせ通知書Entity.get郵便番号();
        source.gyoseiku = 認定更新お知らせ通知書Entity.get行政区();
        source.jusho3 = 認定更新お知らせ通知書Entity.get住所3();
        source.jushoText = 認定更新お知らせ通知書Entity.get住所テキスト();
        source.jusho1 = 認定更新お知らせ通知書Entity.get住所1();
        source.jusho2 = 認定更新お知らせ通知書Entity.get住所2();
        source.katagakiText = 認定更新お知らせ通知書Entity.get方書テキスト();
        source.katagaki2 = 認定更新お知らせ通知書Entity.get方書2();
        source.katagakiSmall2 = 認定更新お知らせ通知書Entity.get方書_小_2();
        source.katagaki1 = 認定更新お知らせ通知書Entity.get方書1();
        source.katagakiSmall1 = 認定更新お知らせ通知書Entity.get方書_小_1();
        source.shimei2 = 認定更新お知らせ通知書Entity.get氏名2();
        source.shimeiSmall2 = 認定更新お知らせ通知書Entity.get氏名_小_2();
        source.shimeiText = 認定更新お知らせ通知書Entity.get氏名テキスト();
        source.meishoFuyo2 = 認定更新お知らせ通知書Entity.get名称付与2();
        source.shimeiSmall1 = 認定更新お知らせ通知書Entity.get氏名_小_1();
        source.dainoKubunMei = 認定更新お知らせ通知書Entity.get代納区分名();
        source.shimei1 = 認定更新お知らせ通知書Entity.get氏名1();
        source.meishoFuyo1 = 認定更新お知らせ通知書Entity.get名称付与1();
        source.samabunShimeiText = 認定更新お知らせ通知書Entity.get様分氏名テキスト();
        source.kakkoLeft2 = 認定更新お知らせ通知書Entity.get括弧左2();
        source.samabunShimei2 = 認定更新お知らせ通知書Entity.get様分氏名2();
        source.samabunShimeiSmall2 = 認定更新お知らせ通知書Entity.get様分氏名_小_2();
        source.samaBun2 = 認定更新お知らせ通知書Entity.get様分2();
        source.kakkoRight2 = 認定更新お知らせ通知書Entity.get括弧右2();
        source.kakkoLeft1 = 認定更新お知らせ通知書Entity.get括弧左1();
        source.samabunShimei1 = 認定更新お知らせ通知書Entity.get様分氏名1();
        source.samaBun1 = 認定更新お知らせ通知書Entity.get様分1();
        source.kakkoRight1 = 認定更新お知らせ通知書Entity.get括弧右1();
        source.samabunShimeiSmall1 = 認定更新お知らせ通知書Entity.get様分氏名_小_1();
        source.customerBarCode = 認定更新お知らせ通知書Entity.getカスタマバーコード();

        source.bunshoNo = 認定更新お知らせ通知書Entity.get文書番号();
        source.title = 認定更新お知らせ通知書Entity.getタイトル();
        source.tsuchibun1 = 認定更新お知らせ通知書Entity.get通知文1();
        source.hihokenshaNameKana = 認定更新お知らせ通知書Entity.get被保険者氏名フリガナ();
        source.hihokenshaNo1 = 認定更新お知らせ通知書Entity.get被保険者番号1();
        source.hihokenshaNo2 = 認定更新お知らせ通知書Entity.get被保険者番号2();
        source.hihokenshaNo3 = 認定更新お知らせ通知書Entity.get被保険者番号3();
        source.hihokenshaNo4 = 認定更新お知らせ通知書Entity.get被保険者番号4();
        source.hihokenshaNo5 = 認定更新お知らせ通知書Entity.get被保険者番号5();
        source.hihokenshaNo6 = 認定更新お知らせ通知書Entity.get被保険者番号6();
        source.hihokenshaNo7 = 認定更新お知らせ通知書Entity.get被保険者番号7();
        source.hihokenshaNo8 = 認定更新お知らせ通知書Entity.get被保険者番号8();
        source.hihokenshaNo9 = 認定更新お知らせ通知書Entity.get被保険者番号9();
        source.hihokenshaNo10 = 認定更新お知らせ通知書Entity.get被保険者番号10();
        source.hihokenshaName = 認定更新お知らせ通知書Entity.get被保険者氏名();
        source.yokaigoNinteiKaishoYMD = 認定更新お知らせ通知書Entity.get要介護認定開始日();
        source.yokaigoNinteiShuryoYMD = 認定更新お知らせ通知書Entity.get要介護認定終了日();
        source.yokaigoJotaiKubun = 認定更新お知らせ通知書Entity.get要介護状態区分();
        source.tsuchibun2 = 認定更新お知らせ通知書Entity.get通知文2();

        return source;
    }

}
