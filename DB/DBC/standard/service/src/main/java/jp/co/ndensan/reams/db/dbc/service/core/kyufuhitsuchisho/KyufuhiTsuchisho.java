/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyufuhitsuchisho;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufuhitsuchisho.KyufuhiTsuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhitsuchishocover.KyufuhiTsuchishoCoverEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.report.parts.toiawasesaki.IToiawasesakiSourceBuilder;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険給付費通知書の帳票データを作成するクラスです。
 *
 * @reamsid_L DBC-2280-030 lizhuoxuan
 */
public class KyufuhiTsuchisho {

    /**
     * コンストラクタです。
     *
     * @param hakkoEntity KyufuhiTuchiHakkoEntity
     * @param processParameter KyufuhiTsuchishoProcessParameter
     * @param ninshoshaSource NinshoshaSource
     * @param sourceBuilder IToiawasesakiSourceBuilder
     * @param atesakiSource SofubutsuAtesakiSource
     * @return 介護保険給付費通知書のEntity
     */
    public KyufuhiTsuchishoCoverEntity 帳票データ作成(KyufuhiTuchiHakkoEntity hakkoEntity,
            KyufuhiTsuchishoProcessParameter processParameter,
            NinshoshaSource ninshoshaSource, SofubutsuAtesakiSource atesakiSource, IToiawasesakiSourceBuilder sourceBuilder) {
        KyufuhiTsuchishoCoverEntity coverEntity = new KyufuhiTsuchishoCoverEntity();
        coverEntity.setHokenshaNo(hakkoEntity.get被保険者番号());
        AtenaMeisho meisho = hakkoEntity.getAtesakiEntity().getKanjiShimei();
        if (meisho != null && !meisho.isEmpty()) {
            coverEntity.setHihokenshaName(meisho.value());
        }
        coverEntity.setShukeiserviceSTYM(processParameter.getサービス年月開始());
        coverEntity.setShukeiserviceEDYM(processParameter.getサービス年月終了());
        coverEntity.setToiawasesakiTitle(new RString("問い合わせ先"));
        coverEntity.setListServiceIchiranUpper_1(hakkoEntity.getサービス提供年月());
        coverEntity.setListServiceIchiranUpper_2(hakkoEntity.get事業者名称());
        coverEntity.setListServiceIchiranUpper_3(hakkoEntity.getサービス名称());
        coverEntity.setListServiceIchiranUpper_4(hakkoEntity.get日数_回数());
        coverEntity.setListServiceIchiranUpper_5(new RString(hakkoEntity.get利用者負担額().toString()));
        coverEntity.setListServiceIchiranUpper_6(new RString(hakkoEntity.getサービス費用合計額().toString()));
        coverEntity.setListServiceIchiranLower_1(hakkoEntity.get事業者名称());
        coverEntity.setListServiceIchiranLower_2(hakkoEntity.getサービス名称());
        coverEntity.setDenshiKoin(ninshoshaSource.hakkoYMD);
        coverEntity.setHakkoYMD(ninshoshaSource.denshiKoin);
        coverEntity.setNinshoshaYakushokuMei(ninshoshaSource.ninshoshaYakushokuMei);
        coverEntity.setNinshoshaYakushokuMei1(ninshoshaSource.ninshoshaYakushokuMei1);
        coverEntity.setNinshoshaYakushokuMei2(ninshoshaSource.ninshoshaYakushokuMei2);
        coverEntity.setNinshoshaShimeiKakenai(ninshoshaSource.ninshoshaShimeiKakenai);
        coverEntity.setNinshoshaShimeiKakeru(ninshoshaSource.ninshoshaShimeiKakeru);
        coverEntity.setKoinShoryaku(ninshoshaSource.koinShoryaku);
        coverEntity.setKoinMojiretsu(ninshoshaSource.koinMojiretsu);
        coverEntity.setYubinNo(atesakiSource.yubinNo);
        coverEntity.setGyoseiku(atesakiSource.gyoseiku);
        coverEntity.setJusho4(atesakiSource.jusho1);
        coverEntity.setJushoText(atesakiSource.jushoText);
        coverEntity.setJusho5(atesakiSource.jusho2);
        coverEntity.setJusho6(atesakiSource.jusho3);
        coverEntity.setKatagakiText(atesakiSource.katagakiText);
        coverEntity.setKatagaki3(atesakiSource.katagaki1);
        coverEntity.setKatagakiSmall2(atesakiSource.katagakiSmall2);
        coverEntity.setKatagaki4(atesakiSource.katagaki2);
        coverEntity.setKatagakiSmall1(atesakiSource.katagakiSmall1);
        coverEntity.setShimei5(atesakiSource.shimei1);
        coverEntity.setShimeiSmall2(atesakiSource.shimeiSmall2);
        coverEntity.setShimeiText(atesakiSource.shimeiText);
        coverEntity.setMeishoFuyo2(atesakiSource.meishoFuyo2);
        coverEntity.setShimeiSmall1(atesakiSource.shimeiSmall1);
        coverEntity.setDainoKubunMei(atesakiSource.dainoKubunMei);
        coverEntity.setShimei6(atesakiSource.shimei2);
        coverEntity.setMeishoFuyo1(atesakiSource.meishoFuyo1);
        coverEntity.setSamabunShimeiText(atesakiSource.samabunShimeiText);
        coverEntity.setSamaBun2(atesakiSource.samaBun2);
        coverEntity.setKakkoLeft2(atesakiSource.kakkoLeft2);
        coverEntity.setSamabunShimei2(atesakiSource.samabunShimei2);
        coverEntity.setSamabunShimeiSmall2(atesakiSource.samabunShimeiSmall2);
        coverEntity.setKakkoRight2(atesakiSource.kakkoRight2);
        coverEntity.setKakkoLeft1(atesakiSource.kakkoLeft1);
        coverEntity.setSamabunShimei1(atesakiSource.samabunShimei1);
        coverEntity.setSamaBun1(atesakiSource.samaBun1);
        coverEntity.setSamabunShimeiSmall1(atesakiSource.samabunShimeiSmall1);
        coverEntity.setCustomerBarCode(ReportUtil.getCustomerBarCode(hakkoEntity.get住所(), hakkoEntity.get郵便番号()));
        coverEntity.setYubinBango(sourceBuilder.buildSource().yubinBango);
        coverEntity.setShozaichi(sourceBuilder.buildSource().shozaichi);
        coverEntity.setChoshaBushoName(sourceBuilder.buildSource().choshaBushoName);
        coverEntity.setTantoName(sourceBuilder.buildSource().tantoName);
        coverEntity.setTelNo(sourceBuilder.buildSource().telNo);
        coverEntity.setNaisenLabel(sourceBuilder.buildSource().naisenLabel);
        coverEntity.setNaisenNo(sourceBuilder.buildSource().naisenNo);
        return coverEntity;
    }
}
