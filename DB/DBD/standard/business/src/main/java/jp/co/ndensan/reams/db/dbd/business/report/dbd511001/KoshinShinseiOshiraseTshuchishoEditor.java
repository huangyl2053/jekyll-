/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd511001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.KoshinOshiraseCommonEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd511001.KoshinShinseiOshiraseTshuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定更新お知らせ通知書Editorです。
 *
 * @reamsid_L DBD-2030-030 donghj
 */
public class KoshinShinseiOshiraseTshuchishoEditor implements IKoshinShinseiOshiraseTshuchishoEditor {

    private final NinshoshaSource ninshoshaSource;
    private final IAtesaki 宛先;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final Association 地方公共団体;
    private final List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用;
    private final KoshinOshiraseCommonEntity 認定更新お知らせ通知書Entity;

    /**
     * インスタンスを生成します。
     *
     * @param ninshoshaSource NinshoshaSource
     * @param 宛先 IAtesaki
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param 地方公共団体 Association
     * @param 帳票制御汎用 List<DbT7067ChohyoSeigyoHanyoEntity>
     * @param 認定更新お知らせ通知書Entity KoshinOshiraseCommonEntity
     */
    public KoshinShinseiOshiraseTshuchishoEditor(NinshoshaSource ninshoshaSource, IAtesaki 宛先,
            ChohyoSeigyoKyotsu 帳票制御共通, Association 地方公共団体, List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用,
            KoshinOshiraseCommonEntity 認定更新お知らせ通知書Entity) {
        this.ninshoshaSource = ninshoshaSource;
        this.宛先 = 宛先;
        this.帳票制御共通 = 帳票制御共通;
        this.地方公共団体 = 地方公共団体;
        this.帳票制御汎用 = 帳票制御汎用;
        this.認定更新お知らせ通知書Entity = 認定更新お知らせ通知書Entity;
    }

    @Override
    public KoshinShinseiOshiraseTshuchishoReportSource edit(KoshinShinseiOshiraseTshuchishoReportSource source) {
        return edit項目(source);
    }

    private KoshinShinseiOshiraseTshuchishoReportSource edit項目(KoshinShinseiOshiraseTshuchishoReportSource source) {
        setCompNinshosha(source);
        setCompSofubutsuAtesaki(source);
        setLayer1(source);
        return source;
    }

    private void setCompNinshosha(KoshinShinseiOshiraseTshuchishoReportSource source) {
        source.hakkoYMD1 = ninshoshaSource.hakkoYMD;
        source.denshiKoin = ninshoshaSource.denshiKoin;
        source.ninshoshaYakushokuMei = ninshoshaSource.ninshoshaYakushokuMei;
        source.ninshoshaYakushokuMei2 = ninshoshaSource.ninshoshaYakushokuMei2;
        source.ninshoshaYakushokuMei1 = ninshoshaSource.ninshoshaYakushokuMei1;
        source.koinMojiretsu = ninshoshaSource.koinMojiretsu;
        source.ninshoshaShimeiKakeru = ninshoshaSource.ninshoshaShimeiKakeru;
        source.ninshoshaShimeiKakenai = ninshoshaSource.ninshoshaShimeiKakenai;
        source.koinShoryaku = ninshoshaSource.koinShoryaku;
    }

    private void setCompSofubutsuAtesaki(KoshinShinseiOshiraseTshuchishoReportSource source) {
        EditedAtesaki 編集後宛先 = JushoHenshu.create編集後宛先(this.宛先, this.地方公共団体, this.帳票制御共通);
        SofubutsuAtesakiSource 送付物宛先情報;
        try {
            送付物宛先情報 = 編集後宛先.getSofubutsuAtesakiSource().get送付物宛先ソース();
        } catch (Exception e) {
            送付物宛先情報 = new SofubutsuAtesakiSource();
        }
        source.yubinNo = 送付物宛先情報.yubinNo;
        source.gyoseiku = 送付物宛先情報.gyoseiku;
        source.jusho3 = 送付物宛先情報.jusho3;
        source.jushoText = 送付物宛先情報.jushoText;
        source.jusho1 = 送付物宛先情報.jusho1;
        source.jusho2 = 送付物宛先情報.jusho2;
        source.katagakiText = 送付物宛先情報.katagakiText;
        source.katagaki2 = 送付物宛先情報.katagaki2;
        source.katagakiSmall2 = 送付物宛先情報.katagakiSmall2;
        source.katagaki1 = 送付物宛先情報.katagaki1;
        source.katagakiSmall1 = 送付物宛先情報.katagakiSmall1;
        source.shimei2 = 送付物宛先情報.shimei2;
        source.shimeiSmall2 = 送付物宛先情報.shimeiSmall2;
        source.shimeiText = 送付物宛先情報.shimeiText;
        source.meishoFuyo2 = 送付物宛先情報.meishoFuyo2;
        source.shimeiSmall1 = 送付物宛先情報.shimeiSmall1;
        source.dainoKubunMei = 送付物宛先情報.dainoKubunMei;
        source.shimei1 = 送付物宛先情報.shimei1;
        source.meishoFuyo1 = 送付物宛先情報.meishoFuyo1;
        source.samabunShimeiText = 送付物宛先情報.samabunShimeiText;
        source.kakkoLeft2 = 送付物宛先情報.kakkoLeft2;
        source.samabunShimei2 = 送付物宛先情報.samabunShimei2;
        source.samabunShimeiSmall2 = 送付物宛先情報.samabunShimeiSmall2;
        source.samaBun2 = 送付物宛先情報.samaBun2;
        source.kakkoRight2 = 送付物宛先情報.kakkoRight2;
        source.kakkoLeft1 = 送付物宛先情報.kakkoLeft1;
        source.samabunShimei1 = 送付物宛先情報.samabunShimei1;
        source.samaBun1 = 送付物宛先情報.samaBun1;
        source.kakkoRight1 = 送付物宛先情報.kakkoRight1;
        source.samabunShimeiSmall1 = 送付物宛先情報.samabunShimeiSmall1;
        source.customerBarCode = 送付物宛先情報.customerBarCode;
    }

    private void setLayer1(KoshinShinseiOshiraseTshuchishoReportSource source) {
        source.bunshoNo = 認定更新お知らせ通知書Entity.get文書番号();
        for (DbT7067ChohyoSeigyoHanyoEntity entity : 帳票制御汎用) {
            if (new RString(ChohyoSeigyoHanyoKeysDBD511001.帳票タイトル.name()).equals(entity.getKomokuName())) {
                source.title = entity.getKomokuValue();
                break;
            }
        }
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

    }

}
