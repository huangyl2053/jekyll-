/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kaishuriyushoshikyuketteitsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishuriyushosakusei.JutakuKaishuRiyushoSakuseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutariyutesuseikenshinichiran.JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranData;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaishuriyushoshikyuketteitsuchisho.DbWT3095JutakuKaishuRiyushoTesuryoMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaishuriyushoshikyuketteitsuchisho.KaishuriyushoShikyuKetteitsuchishoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ur.urz.business.core.toiawasesaki.Toiawasesaki;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 住宅改修理由書作成手数料支給（不支給）決定通知書作成のビジネスクラスです。
 *
 * @reamsid_L DBC-2850-030 zuotao
 */
public class KaishuriyushoShikyuKetteitsuchishoBusiness {

    private static final RString 支払方法 = new RString("口座振り込み");
    private static final RString 内線 = new RString("内線");

    /**
     * 住宅改修理由書作成手数料請求明細Entityを作成します。
     *
     * @param entity 住宅改修理由書作成手数料請求取得のEntity
     * @return 住宅改修理由書作成手数料請求明細Entity
     */
    public DbWT3095JutakuKaishuRiyushoTesuryoMeisaiEntity create住宅改修理由書作成手数料請求明細(KaishuriyushoShikyuKetteitsuchishoEntity entity) {
        DbWT3095JutakuKaishuRiyushoTesuryoMeisaiEntity 明細 = new DbWT3095JutakuKaishuRiyushoTesuryoMeisaiEntity();
        明細.setShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo());
        明細.setHihokenshaNo(entity.getHihokenshaNo());
        明細.setServiceCode(entity.getServiceCode());
        明細.setJutakuKaishuJigyoshaMeisho(entity.getJutakuKaishuJigyoshaMeisho());
        明細.setJutakuKaishuChakkoYMD(entity.getJutakuKaishuChakkoYMD());
        明細.setJutakuKaishuJushoShozaisha(entity.getJutakuKaishuJushoShozaisha());
        明細.setKaishuTaishoJutakuJusho(entity.getKaishuTaishoJutakuJusho());
        明細.setKaishuNaiyo_kasho_Kibo(entity.getKaishuNaiyo_kasho_Kibo());
        明細.setRiyushoSakuseiYMD(entity.getRiyushoSakuseiYMD());
        明細.setRiyushoSakuseiJigyoshaNo(entity.getRiyushoSakuseiJigyoshaNo());
        明細.setRiyushoSakuseishaMei(entity.getRiyushoSakuseishaMei());
        明細.setRiyushoSakuseishaMeiKana(entity.getRiyushoSakuseishaMeiKana());
        明細.setRiyushoSakuseiShinseiYMD(entity.getRiyushoSakuseiShinseiYMD());
        明細.setRiyushoSakuseiUketsukeYMD(entity.getRiyushoSakuseiUketsukeYMD());
        明細.setShukeiNo(entity.getShukeiNo());
        明細.setShukeiFlag(entity.isShukeiFlag());
        明細.setRirekiNo(0);
        明細.setShikibetsuCode(entity.getShikibetsuCode());
        return 明細;
    }

    /**
     * 決定通知書情報を作成します。
     *
     * @param 認証者情報 認証者情報
     * @param 帳票共通情報 帳票共通情報
     * @param 通知文上段 通知文上段
     * @param 通知文下段 通知文下段
     * @param 問合せ 問合せ
     * @param entity 住宅改修理由書作成手数料請求取得のEntity
     * @return 決定通知書情報
     */
    public JutakuKaishuRiyushoSakuseiEntity create決定通知書情報(NinshoshaSource 認証者情報,
            ChohyoSeigyoKyotsu 帳票共通情報, RString 通知文上段, RString 通知文下段,
            Toiawasesaki 問合せ, KaishuriyushoShikyuKetteitsuchishoEntity entity) {

        JutakuKaishuRiyushoSakuseiEntity 帳票データ = new JutakuKaishuRiyushoSakuseiEntity();
        帳票データ.setHakkoYMD(認証者情報.hakkoYMD);
        帳票データ.setDenshiKoin(認証者情報.denshiKoin);
        帳票データ.setNinshoshaYakushokuMei(認証者情報.ninshoshaYakushokuMei);
        帳票データ.setKoinMojiretsu(認証者情報.koinMojiretsu);
        帳票データ.setNinshoshaShimeiKakenai(認証者情報.ninshoshaShimeiKakenai);
        帳票データ.setNinshoshaShimeiKakeru(認証者情報.ninshoshaShimeiKakeru);
        帳票データ.setKoinShoryaku(認証者情報.koinShoryaku);

        // TODO QA1784確認中
        // 帳票データ.setSofusakiYubinNo();
        帳票データ.setTsuchoBun(通知文上段);
        FlexibleDate 受付年月日 = entity.getRiyushoSakuseiUketsukeYMD();
        if (受付年月日 != null && !受付年月日.isEmpty()) {
            帳票データ.setUketsukeYMD(new RString(受付年月日.toString()));
        }
        FlexibleDate 決定年月日 = entity.getShikyu_FushikyuKetteiYMD();
        if (決定年月日 != null && !決定年月日.isEmpty()) {
            帳票データ.setKetteiYMD(new RString(決定年月日.toString()));
        }
        帳票データ.setKetteiKekka(entity.getShikyu_FushikyuKubun());
        if (entity.getRiyushoSakuseiSeikyuKingaku() != null) {
            帳票データ.setTesuryo(DecimalFormatter.toコンマ区切りRString(entity.getRiyushoSakuseiSeikyuKingaku(), 0));
        }
        帳票データ.setFushikyuRiyu(entity.getFushikyuRiyu());
        帳票データ.setShiharaiHouhou(支払方法);
        FlexibleDate 支払予定日 = entity.getTesuryoShiharaiYoteiYMD();
        if (支払予定日 != null && !支払予定日.isEmpty()) {
            帳票データ.setShiharaiYoteiYMD(new RString(支払予定日.toString()));
        }
        帳票データ.setTsuchiBun(通知文下段);
        if (問合せ != null) {

            帳票データ.setChoshaBushoName(問合せ.get庁舎部署名());
            if (問合せ.get郵便番号() != null) {
                帳票データ.setYubinBango(問合せ.get郵便番号().value());
            }
            帳票データ.setShozaichi(問合せ.get所在地());
            帳票データ.setTelNo(問合せ.get電話番号());
            RString 内線番号 = 問合せ.get内線番号();
            帳票データ.setTantoName(問合せ.get担当名());
            if (!RString.isNullOrEmpty(内線番号)) {
                帳票データ.setNaisenLabel(内線);
            }
            帳票データ.setNaisenNo(内線番号);
        }
        return 帳票データ;
    }

    /**
     * 住宅改修理由書作成手数料請求書兼申請書entityを作成します。
     *
     * @param entity 住宅改修理由書作成手数料請求取得のEntity
     * @return 住宅改修理由書作成手数料請求書兼申請書情報
     */
    public JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranData createcreate住宅改修理由書作成手数料請求書兼申請書(KaishuriyushoShikyuKetteitsuchishoEntity entity) {
        JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranData data = new JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranData();
        AtenaMeisho 事業者名 = entity.getJutakuKaishuJigyoshaMeisho();
        if (事業者名 != null) {
            data.set事業者名(事業者名.value());
        }
        data.set理由書作成日(entity.getRiyushoSakuseiYMD());
        data.set被保険者番号(entity.getHihokenshaNo().value());
        // TODO 1782確認中
        data.set被保険者氏名(RString.EMPTY);
        data.set改修先住所(entity.getKaishuTaishoJutakuJusho());
        data.set工事の種類(entity.getKaishuNaiyo_kasho_Kibo());
        AtenaMeisho 理由書作成者 = entity.getJutakuKaishuJigyoshaMeisho();
        if (理由書作成者 != null) {
            data.set理由書作成者(理由書作成者.value());
        }
        return data;
    }
}
