/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kaishuriyushoshikyuketteitsuchisho;

import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishuriyushosakusei.JutakuKaishuRiyushoSakuseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutariyutesuseikenshinichiran.JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranData;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaishuriyushoshikyuketteitsuchisho.KaishuriyushoShikyuKetteitsuchishoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.ur.urz.business.core.toiawasesaki.Toiawasesaki;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
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
        YubinNo 送付先郵便番号 = entity.getDbT7060Entity().getYubinNo();
        RString 郵便番号 = RString.EMPTY;
        if (送付先郵便番号 != null) {
            郵便番号 = 送付先郵便番号.getYubinNo();
        }
        帳票データ.setSofusakiYubinNo(郵便番号);
        AtenaJusho 送付先住所 = entity.getDbT7060Entity().getJigyoshaAddress();
        RString 住所 = RString.EMPTY;
        if (送付先住所 != null) {
            住所 = 送付先住所.value();
        }
        帳票データ.setSofusakiJusho(住所);
        帳票データ.setSofusakiShimei(entity.getDbT7060Entity().getJigyoshaName().value());
        RString code = new CustomerBarCode().convertCustomerBarCode(郵便番号, 住所).getCustomerBarCode();
        帳票データ.setJigyoshoCustomerBarCode(code);
        帳票データ.setTsuchoBun(通知文上段);
        FlexibleDate 受付年月日 = entity.getRiyushoSakuseiUketsukeYMD();
        if (受付年月日 != null && !受付年月日.isEmpty()) {
            帳票データ.setUketsukeYMD(受付年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
        }
        FlexibleDate 決定年月日 = entity.getShikyu_FushikyuKetteiYMD();
        if (決定年月日 != null && !決定年月日.isEmpty()) {
            帳票データ.setKetteiYMD(決定年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
        }
        帳票データ.setKetteiKekka(ShikyuFushikyuKubun.toValue(entity.getShikyu_FushikyuKubun()).get名称());
        帳票データ.setTesuryo(this.get金額(entity.getRiyushoSakuseiSeikyuKingaku()));
        帳票データ.setFushikyuRiyu(entity.getFushikyuRiyu());
        帳票データ.setShiharaiHouhou(支払方法);
        FlexibleDate 支払予定日 = entity.getTesuryoShiharaiYoteiYMD();
        if (支払予定日 != null && !支払予定日.isEmpty()) {
            帳票データ.setShiharaiYoteiYMD(支払予定日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
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
    public JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranData
            createcreate住宅改修理由書作成手数料請求書兼申請書(KaishuriyushoShikyuKetteitsuchishoEntity entity) {
        JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranData data = new JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranData();
        AtenaMeisho 事業者名 = entity.getJutakuKaishuJigyoshaMeisho();
        if (事業者名 != null) {
            data.set事業者名(事業者名.value());
        }
        data.set理由書作成日(entity.getRiyushoSakuseiYMD());
        data.set被保険者番号(entity.getHihokenshaNo().value());
        RString 被保険者氏名;
        AtenaMeisho 被保険者 = entity.getPsmEntity().getMeisho();
        if (entity.getPsmEntity() != null && 被保険者 != null) {
            被保険者氏名 = 被保険者.value();
        } else {
            被保険者氏名 = entity.getJutakuKaishuJushoShozaisha().value();
        }
        data.set被保険者氏名(被保険者氏名);
        data.set改修先住所(entity.getKaishuTaishoJutakuJusho());
        data.set工事の種類(entity.getKaishuNaiyo_kasho_Kibo());
        AtenaMeisho 理由書作成者 = entity.getRiyushoSakuseishaMei();
        if (理由書作成者 != null) {
            data.set理由書作成者(理由書作成者.value());
        }
        return data;
    }

    private RString get金額(Decimal 金額) {
        if (金額 != null) {
            return DecimalFormatter.toコンマ区切りRString(金額, 0);
        }
        return new RString(Decimal.ZERO.intValue());
    }

    /**
     * 出力順設定可能項目です。
     */
    public enum JutakuKaishuRiyushoSakuseiTeshuryoKetteiTsuchishoEnum implements IReportItems {

        /**
         * 証記載保険者番号
         */
        証記載保険者番号(new RString("0103"), new RString(""), new RString("\"DbT3095JutakuKaishuRiyushoTesuryoMeisai\".\"shoKisaiHokenshaNo\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString(""), new RString("\"DbT3095JutakuKaishuRiyushoTesuryoMeisai\".\"hihokenshaNo\"")),
        /**
         * 住宅改修理由書作成年月日
         */
        住宅改修理由書作成年月日(new RString("0374"), new RString(""),
                new RString("\"DbT3095JutakuKaishuRiyushoTesuryoMeisai\".\"riyushoSakuseiYMD\"")),
        /**
         * 住宅改修理由書作成申請年月日
         */
        住宅改修理由書作成申請年月日(new RString("0375"), new RString(""),
                new RString("\"DbT3095JutakuKaishuRiyushoTesuryoMeisai\".\"riyushoSakuseiShinseiYMD\"")),
        /**
         * 住宅改修理由書作成受付年月日
         */
        住宅改修理由書作成受付年月日(new RString("0376"), new RString(""),
                new RString("\"DbT3095JutakuKaishuRiyushoTesuryoMeisai\".\"riyushoSakuseiUketsukeYMD\""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private JutakuKaishuRiyushoSakuseiTeshuryoKetteiTsuchishoEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
            this.項目ID = 項目ID;
            this.フォームフィールド名 = フォームフィールド名;
            this.myBatis項目名 = myBatis項目名;
        }

        @Override
        public RString get項目ID() {
            return 項目ID;
        }

        @Override
        public RString getフォームフィールド名() {
            return フォームフィールド名;
        }

        @Override
        public RString getMyBatis項目名() {
            return myBatis項目名;
        }
    }
}
