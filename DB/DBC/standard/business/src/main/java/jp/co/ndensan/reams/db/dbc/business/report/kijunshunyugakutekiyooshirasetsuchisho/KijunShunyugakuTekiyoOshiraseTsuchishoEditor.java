/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyooshirasetsuchisho;

import jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugakutekiyoshinseisho.KijunShunyugakuTekiyoShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyooshirasetsuchisho.KijunShunyugakuTekiyoOshiraseTsuchishoSource;

/**
 * 帳票設計_DBC100063_基準収入額適用お知らせ通知書 Editorクラスです。
 *
 * @reamsid_L DBC-4640-050 lijian
 */
public class KijunShunyugakuTekiyoOshiraseTsuchishoEditor implements IKijunShunyugakuTekiyoOshiraseTsuchishoEditor {

    private final KijunShunyugakuTekiyoShinseishoEntity 基準収入額適用Entity;

    /**
     * コンストラクタです。
     *
     * @param 基準収入額適用Entity KijunShunyugakuTekiyoShinseishoEntity
     */
    public KijunShunyugakuTekiyoOshiraseTsuchishoEditor(KijunShunyugakuTekiyoShinseishoEntity 基準収入額適用Entity) {
        this.基準収入額適用Entity = 基準収入額適用Entity;
    }

    @Override
    public KijunShunyugakuTekiyoOshiraseTsuchishoSource edit(KijunShunyugakuTekiyoOshiraseTsuchishoSource source) {
        source.bunshoNo = 基準収入額適用Entity.get文書番号();
        source.title = 基準収入額適用Entity.getタイトル();
        source.hihokenshaNo1 = 基準収入額適用Entity.get被保険者番号１();
        source.hihoNameKana1 = 基準収入額適用Entity.get被保険者名カナ１();
        source.hihokenshaName1 = 基準収入額適用Entity.get被保険者氏名１();
        source.hihokenshaNo2 = 基準収入額適用Entity.get被保険者番号２();
        source.hihoNameKana2 = 基準収入額適用Entity.get被保険者名カナ２();
        source.hihokenshaName2 = 基準収入額適用Entity.get被保険者氏名２();
        source.hihokenshaNo3 = 基準収入額適用Entity.get被保険者番号３();
        source.hihoNameKana3 = 基準収入額適用Entity.get被保険者名カナ３();
        source.hihokenshaName3 = 基準収入額適用Entity.get被保険者氏名３();
        source.sonotaHihokensha = 基準収入額適用Entity.getその他被保険者();
        set通知文(source);

        if (基準収入額適用Entity.get識別コード１() != null) {
            source.shikibetsuCode1 = 基準収入額適用Entity.get識別コード１().value();
        }
        if (基準収入額適用Entity.get識別コード２() != null) {
            source.shikibetsuCode2 = 基準収入額適用Entity.get識別コード２().value();
        }
        if (基準収入額適用Entity.get識別コード３() != null) {
            source.shikibetsuCode3 = 基準収入額適用Entity.get識別コード３().value();
        }

        setCompNinshosha(source);
        setCompSofubutsuAtesaki(source);
        return source;
    }

    private void set通知文(KijunShunyugakuTekiyoOshiraseTsuchishoSource source) {
        source.tsuchibun1 = 基準収入額適用Entity.get通知文１();
        source.tsuchibun2 = 基準収入額適用Entity.get通知文２();
        source.tsuchibun3 = 基準収入額適用Entity.get通知文３();
        source.tsuchibun4 = 基準収入額適用Entity.get通知文4();
        source.tsuchibun5 = 基準収入額適用Entity.get通知文5();
        source.tsuchibun6 = 基準収入額適用Entity.get通知文6();
        source.tsuchibun7 = 基準収入額適用Entity.get通知文7();
        source.tsuchibun8 = 基準収入額適用Entity.get通知文８();
        source.tsuchibun9 = 基準収入額適用Entity.get通知文９();
        source.tsuchibun10 = 基準収入額適用Entity.get通知文１０();
        source.tsuchibun11 = 基準収入額適用Entity.get通知文１１();
        source.tsuchibun12 = 基準収入額適用Entity.get通知文１２();
        source.tsuchibun13 = 基準収入額適用Entity.get通知文１３();
        source.tsuchibun14 = 基準収入額適用Entity.get通知文１４();
        source.tsuchibun15 = 基準収入額適用Entity.get通知文１５();
        source.tsuchibun16 = 基準収入額適用Entity.get通知文１６();
        source.tsuchibun17 = 基準収入額適用Entity.get通知文１７();
        source.tsuchibun18 = 基準収入額適用Entity.get通知文１８();
        source.tsuchibun19 = 基準収入額適用Entity.get通知文１９();
        source.tsuchibun20 = 基準収入額適用Entity.get通知文２０();
        source.tsuchibun21 = 基準収入額適用Entity.get通知文２１();
        source.tsuchibun22 = 基準収入額適用Entity.get通知文２２();
        source.tsuchibun23 = 基準収入額適用Entity.get通知文２３();
        source.tsuchibun24 = 基準収入額適用Entity.get通知文２４();
        source.tsuchibun25 = 基準収入額適用Entity.get通知文２５();
        source.tsuchibun26 = 基準収入額適用Entity.get通知文２６();
        source.tsuchibun27 = 基準収入額適用Entity.get通知文２７();
        source.tsuchibun28 = 基準収入額適用Entity.get通知文２８();
        source.tsuchibun29 = 基準収入額適用Entity.get通知文２９();
    }

    private void setCompNinshosha(KijunShunyugakuTekiyoOshiraseTsuchishoSource source) {
        if (基準収入額適用Entity.getNinshoshaSource() != null) {
            source.hakkoYMD = 基準収入額適用Entity.getNinshoshaSource().hakkoYMD;
            source.denshiKoin = 基準収入額適用Entity.getNinshoshaSource().denshiKoin;
            source.ninshoshaYakushokuMei = 基準収入額適用Entity.getNinshoshaSource().ninshoshaYakushokuMei;
            source.ninshoshaYakushokuMei1 = 基準収入額適用Entity.getNinshoshaSource().ninshoshaYakushokuMei1;
            source.koinMojiretsu = 基準収入額適用Entity.getNinshoshaSource().koinMojiretsu;
            source.ninshoshaYakushokuMei2 = 基準収入額適用Entity.getNinshoshaSource().ninshoshaYakushokuMei2;
            source.ninshoshaShimeiKakenai = 基準収入額適用Entity.getNinshoshaSource().ninshoshaShimeiKakenai;
            source.ninshoshaShimeiKakeru = 基準収入額適用Entity.getNinshoshaSource().ninshoshaShimeiKakeru;
            source.koinShoryaku = 基準収入額適用Entity.getNinshoshaSource().koinShoryaku;
        }
    }

    private void setCompSofubutsuAtesaki(KijunShunyugakuTekiyoOshiraseTsuchishoSource source) {
        if (基準収入額適用Entity.getAtesakiSource() != null) {
            source.yubinNo = 基準収入額適用Entity.getAtesakiSource().yubinNo;
            source.gyoseiku1 = 基準収入額適用Entity.getAtesakiSource().gyoseiku;
            source.jusho4 = 基準収入額適用Entity.getAtesakiSource().jusho1;
            source.jushoText = 基準収入額適用Entity.getAtesakiSource().jushoText;
            source.jusho5 = 基準収入額適用Entity.getAtesakiSource().jusho2;
            source.jusho6 = 基準収入額適用Entity.getAtesakiSource().jusho3;
            source.katagakiText = 基準収入額適用Entity.getAtesakiSource().katagakiText;
            source.katagaki3 = 基準収入額適用Entity.getAtesakiSource().katagaki1;
            source.katagakiSmall2 = 基準収入額適用Entity.getAtesakiSource().katagakiSmall2;
            source.katagaki4 = 基準収入額適用Entity.getAtesakiSource().katagaki2;
            source.katagakiSmall1 = 基準収入額適用Entity.getAtesakiSource().katagakiSmall1;
            source.shimei3 = 基準収入額適用Entity.getAtesakiSource().shimei1;
            source.shimeiSmall2 = 基準収入額適用Entity.getAtesakiSource().shimeiSmall2;
            source.shimeiText = 基準収入額適用Entity.getAtesakiSource().shimeiText;
            source.meishoFuyo2 = 基準収入額適用Entity.getAtesakiSource().meishoFuyo2;
            source.shimeiSmall1 = 基準収入額適用Entity.getAtesakiSource().shimeiSmall1;
            source.dainoKubunMei = 基準収入額適用Entity.getAtesakiSource().dainoKubunMei;
            source.shimei4 = 基準収入額適用Entity.getAtesakiSource().shimei2;
            source.meishoFuyo1 = 基準収入額適用Entity.getAtesakiSource().meishoFuyo1;
            source.samabunShimeiText = 基準収入額適用Entity.getAtesakiSource().samabunShimeiText;
            source.kakkoLeft2 = 基準収入額適用Entity.getAtesakiSource().kakkoLeft2;
            source.samabunShimei2 = 基準収入額適用Entity.getAtesakiSource().samabunShimei2;
            source.samabunShimeiSmall2 = 基準収入額適用Entity.getAtesakiSource().samabunShimeiSmall2;
            source.samaBun2 = 基準収入額適用Entity.getAtesakiSource().samaBun2;
            source.kakkoRight2 = 基準収入額適用Entity.getAtesakiSource().kakkoRight2;
            source.kakkoLeft1 = 基準収入額適用Entity.getAtesakiSource().kakkoLeft1;
            source.samabunShimei1 = 基準収入額適用Entity.getAtesakiSource().samabunShimei1;
            source.samaBun1 = 基準収入額適用Entity.getAtesakiSource().samaBun1;
            source.kakkoRight1 = 基準収入額適用Entity.getAtesakiSource().kakkoRight1;
            source.samabunShimeiSmall1 = 基準収入額適用Entity.getAtesakiSource().samabunShimeiSmall1;
            source.customerBarCode = 基準収入額適用Entity.getAtesakiSource().customerBarCode;

        }
    }

}
