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
            source.yubinNo = 主治医意見書確認書Entity.get送付物宛先().yubinNo;
            source.gyoseiku = 主治医意見書確認書Entity.get送付物宛先().gyoseiku;
            source.jusho3 = 主治医意見書確認書Entity.get送付物宛先().jusho3;
            source.jushoText = 主治医意見書確認書Entity.get送付物宛先().jushoText;
            source.jusho1 = 主治医意見書確認書Entity.get送付物宛先().jusho1;
            source.jusho2 = 主治医意見書確認書Entity.get送付物宛先().jusho2;
            source.katagakiText = 主治医意見書確認書Entity.get送付物宛先().katagakiText;
            source.katagaki2 = 主治医意見書確認書Entity.get送付物宛先().katagaki2;
            source.katagakiSmall2 = 主治医意見書確認書Entity.get送付物宛先().katagakiSmall2;
            source.katagaki1 = 主治医意見書確認書Entity.get送付物宛先().katagaki1;
            source.katagakiSmall1 = 主治医意見書確認書Entity.get送付物宛先().katagakiSmall1;
            source.shimei2 = 主治医意見書確認書Entity.get送付物宛先().shimei2;
            source.shimeiSmall2 = 主治医意見書確認書Entity.get送付物宛先().shimeiSmall2;
            source.shimeiText = 主治医意見書確認書Entity.get送付物宛先().shimeiText;
            source.meishoFuyo2 = 主治医意見書確認書Entity.get送付物宛先().meishoFuyo2;
            source.shimeiSmall1 = 主治医意見書確認書Entity.get送付物宛先().shimeiSmall1;
            source.dainoKubunMei = 主治医意見書確認書Entity.get送付物宛先().dainoKubunMei;
            source.shimei1 = 主治医意見書確認書Entity.get送付物宛先().shimei1;
            source.meishoFuyo1 = 主治医意見書確認書Entity.get送付物宛先().meishoFuyo1;
            source.samabunShimeiText = 主治医意見書確認書Entity.get送付物宛先().samabunShimeiText;
            source.samaBun2 = 主治医意見書確認書Entity.get送付物宛先().samaBun2;
            source.samabunShimeiSmall2 = 主治医意見書確認書Entity.get送付物宛先().samabunShimeiSmall2;
            source.kakkoLeft2 = 主治医意見書確認書Entity.get送付物宛先().kakkoLeft2;
            source.samabunShimei2 = 主治医意見書確認書Entity.get送付物宛先().samabunShimei2;
            source.kakkoRight2 = 主治医意見書確認書Entity.get送付物宛先().kakkoRight2;
            source.kakkoLeft1 = 主治医意見書確認書Entity.get送付物宛先().kakkoLeft1;
            source.samabunShimei1 = 主治医意見書確認書Entity.get送付物宛先().samabunShimei1;
            source.samaBun1 = 主治医意見書確認書Entity.get送付物宛先().samaBun1;
            source.kakkoRight1 = 主治医意見書確認書Entity.get送付物宛先().kakkoRight1;
            source.samabunShimeiSmall1 = 主治医意見書確認書Entity.get送付物宛先().samabunShimeiSmall1;
            source.customerBarCode = 主治医意見書確認書Entity.get送付物宛先().customerBarCode;
            source.hakkoYMD = 主治医意見書確認書Entity.get認証者().hakkoYMD;
            source.denshiKoin = 主治医意見書確認書Entity.get認証者().denshiKoin;
            source.ninshoshaYakushokuMei = 主治医意見書確認書Entity.get認証者().ninshoshaYakushokuMei;
            source.ninshoshaYakushokuMei1 = 主治医意見書確認書Entity.get認証者().ninshoshaYakushokuMei1;
            source.ninshoshaYakushokuMei2 = 主治医意見書確認書Entity.get認証者().ninshoshaYakushokuMei2;
            source.koinMojiretsu = 主治医意見書確認書Entity.get認証者().koinMojiretsu;
            source.ninshoshaShimeiKakeru = 主治医意見書確認書Entity.get認証者().ninshoshaShimeiKakeru;
            source.ninshoshaShimeiKakenai = 主治医意見書確認書Entity.get認証者().ninshoshaShimeiKakenai;
            source.koinShoryaku = 主治医意見書確認書Entity.get認証者().koinShoryaku;
            source.bunshoNo = 主治医意見書確認書Entity.get帳票固有情報().get文書番号();
            source.title = new RString("主治医意見書確認書");
            source.shinsei_ymd = 主治医意見書確認書Entity.get帳票固有情報().get申請日();
            source.NEN = 主治医意見書確認書Entity.get帳票固有情報().get年();
            source.jusyo1 = 主治医意見書確認書Entity.get帳票固有情報().get住所１();
            source.jusyo2 = 主治医意見書確認書Entity.get帳票固有情報().get住所２();
            source.hihoName1 = 主治医意見書確認書Entity.get帳票固有情報().get氏名１();
            source.hihoName2 = 主治医意見書確認書Entity.get帳票固有情報().get氏名２();
            source.hihoNo = 主治医意見書確認書Entity.get帳票固有情報().get被保険者番号();
            source.ikesyosakuseiYmd = 主治医意見書確認書Entity.get帳票固有情報().get主治医意見書作成日();
            source.ninnteikikan = 主治医意見書確認書Entity.get帳票固有情報().get要介護認定の有効期間開始().concat(new RString("～").
                    concat(主治医意見書確認書Entity.get帳票固有情報().get要介護認定の有効期間終了()));
            source.jiritsudoB1 = 主治医意見書確認書Entity.get帳票固有情報().get寝たきり度_B1();
            source.jiritsudoB2 = 主治医意見書確認書Entity.get帳票固有情報().get寝たきり度_B2();
            source.jiritsudoC1 = 主治医意見書確認書Entity.get帳票固有情報().get寝たきり度_C1();
            source.jiritsudoC2 = 主治医意見書確認書Entity.get帳票固有情報().get寝たきり度_C2();
        }
        return source;
    }
}
