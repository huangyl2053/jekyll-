/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100030;

import jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei.ShugiiIkenshoKakuninshoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100030.ShujiiIkenshoKakuninshoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書確認書Editorです。
 *
 * @reamsid_L DBD-5790-030 x_zhaowen
 */
public class ShujiiIkenshoKakuninshoEditor implements IShugiiIkenshoKakuninshoEditor {

    private final ShugiiIkenshoKakuninshoEntity 主治医意見書確認書Entity;

    /**
     * インスタンスを生成します。
     *
     * @param 主治医意見書確認書Entity ShugiiIkenshoKakuninshoEntity
     */
    public ShujiiIkenshoKakuninshoEditor(ShugiiIkenshoKakuninshoEntity 主治医意見書確認書Entity) {
        this.主治医意見書確認書Entity = 主治医意見書確認書Entity;
    }

    @Override
    public ShujiiIkenshoKakuninshoReportSource edit(ShujiiIkenshoKakuninshoReportSource source) {
        return editSource(source);
    }

    private ShujiiIkenshoKakuninshoReportSource editSource(ShujiiIkenshoKakuninshoReportSource source) {

        source.title = new RString("主治医意見書確認書");
        if (主治医意見書確認書Entity != null) {
            source.yubinNo = 主治医意見書確認書Entity.get宛名情報_送付先郵便番号();
            source.gyoseiku = 主治医意見書確認書Entity.get宛名情報_送付先行政区名();
            source.jusho3 = 主治医意見書確認書Entity.get宛名情報_送付先住所3();
//            source.jushoText = 主治医意見書確認書Entity.get;
            source.jusho1 = 主治医意見書確認書Entity.get宛名情報_送付先住所1();
            source.jusho2 = 主治医意見書確認書Entity.get宛名情報_送付先住所2();
//            source.katagakiText = 主治医意見書確認書Entity.get;
            source.katagaki2 = 主治医意見書確認書Entity.get宛名情報_送付先方書2();
            source.katagakiSmall2 = 主治医意見書確認書Entity.get宛名情報_送付先方書2小();
            source.katagaki1 = 主治医意見書確認書Entity.get宛名情報_送付先方書1();
            source.katagakiSmall1 = 主治医意見書確認書Entity.get宛名情報_送付先方書1小();
//            source.shimei2 = 主治医意見書確認書Entity.get;
//            source.shimeiSmall2 = 主治医意見書確認書Entity.get;
//            source.shimeiText = 主治医意見書確認書Entity.get;
//            source.meishoFuyo2 = 主治医意見書確認書Entity.get;
//            source.shimeiSmall1 = 主治医意見書確認書Entity.get;
            source.dainoKubunMei = 主治医意見書確認書Entity.get宛名情報_代納人区分();
//            source.shimei1 = 主治医意見書確認書Entity.get;
//            source.meishoFuyo1 = 主治医意見書確認書Entity.get;
//            source.samabunShimeiText = 主治医意見書確認書Entity.get;
//            source.samaBun2 = 主治医意見書確認書Entity.get;
//            source.samabunShimeiSmall2 = 主治医意見書確認書Entity.get;
            source.kakkoLeft2 = 主治医意見書確認書Entity.get宛名情報_左括弧2();
//            source.samabunShimei2 = 主治医意見書確認書Entity.get;
            source.kakkoRight2 = 主治医意見書確認書Entity.get宛名情報_右括弧2();
            source.kakkoLeft1 = 主治医意見書確認書Entity.get宛名情報_左括弧1();
//            source.samabunShimei1 = 主治医意見書確認書Entity.get;
//            source.samaBun1 = 主治医意見書確認書Entity.get;
            source.kakkoRight1 = 主治医意見書確認書Entity.get宛名情報_右括弧1();
//            source.samabunShimeiSmall1 = 主治医意見書確認書Entity.get;
            source.customerBarCode = 主治医意見書確認書Entity.getカスタマバーコード();
//            source.hakkoYMD = 主治医意見書確認書Entity.get;
            source.denshiKoin = 主治医意見書確認書Entity.get電子公印();
            source.ninshoshaYakushokuMei = 主治医意見書確認書Entity.get役職名();
            source.ninshoshaYakushokuMei1 = 主治医意見書確認書Entity.get役職名１();
            source.ninshoshaYakushokuMei2 = 主治医意見書確認書Entity.get役職名２();
//            source.koinMojiretsu = 主治医意見書確認書Entity.get;
            source.ninshoshaShimeiKakeru = 主治医意見書確認書Entity.get認証者氏名掛ける();
            source.ninshoshaShimeiKakenai = 主治医意見書確認書Entity.get認証者氏名掛けない();
            source.koinShoryaku = 主治医意見書確認書Entity.get公印書略();
            source.bunshoNo = 主治医意見書確認書Entity.get文書番号();
//            source.title = 主治医意見書確認書Entity.get;
            source.shinsei_ymd = 主治医意見書確認書Entity.get申請日();
            source.NEN = 主治医意見書確認書Entity.get発行日();
            source.jusyo1 = 主治医意見書確認書Entity.get住所１();
            source.jusyo2 = 主治医意見書確認書Entity.get住所２();
            source.hihoName1 = 主治医意見書確認書Entity.get氏名１();
            source.hihoName2 = 主治医意見書確認書Entity.get氏名２();
            source.hihoNo = 主治医意見書確認書Entity.get被保険者番号();
            source.ikesyosakuseiYmd = 主治医意見書確認書Entity.get主治医意見書作成日();
//            source.ninnteikikan = 主治医意見書確認書Entity.get;
            source.jiritsudoB1 = 主治医意見書確認書Entity.get寝たきり度_B1();
            source.jiritsudoB2 = 主治医意見書確認書Entity.get寝たきり度_B2();
            source.jiritsudoC1 = 主治医意見書確認書Entity.get寝たきり度_C1();
            source.jiritsudoC2 = 主治医意見書確認書Entity.get寝たきり度_C2();
//            source.chohyoNo = 主治医意見書確認書Entity.get;
        }

        return source;
    }
}
