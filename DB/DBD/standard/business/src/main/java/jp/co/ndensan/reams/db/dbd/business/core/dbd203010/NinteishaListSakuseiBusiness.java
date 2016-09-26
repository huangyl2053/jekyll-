/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd203010;

import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd200004.Setaiinshotokujoho;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd200004.ShakaiFukushiHojinKeigenCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd200004.ShakaiFukushiHojinKeigenGaitoshaIchiranEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 連番ありCSV作成の取得ビジネスクラスです
 *
 * @reamsid_L DBD-3830-030 tianyh
 */
public class NinteishaListSakuseiBusiness {

    private boolean 日付スラッシュ編集;
    private static final RString 承認する = new RString("1");
    private static final RString 承認しない = new RString("0");
    private static final RString 承認 = new RString("承認");
    private static final RString 却下 = new RString("却下");
    private static final RString 自己作成 = new RString("自己作成");
    private static final RString 課 = new RString("課");
    private static final RString 旧措置者 = new RString("旧措置者");
    private static final RString 居宅サービスのみ = new RString("居宅サービスのみ");
    private static final RString 居住費食費のみ = new RString("居住費・食費のみ");
    private static final RString 旧措ユ個のみ = new RString("旧措ユ個のみ");
    private static final RString POINT = new RString("、");
    private static final RString ASTERISK = new RString("*");
    private static final int NO_0 = 0;
    private static final int NO_1 = 1;

    /**
     * CSV出力情報を設定します．
     *
     * @param eucCsvEntity ShakaiFukushiHojinKeigenCsvEntity
     * @param entity ShakaiFukushiHojinKeigenGaitoshaIchiranEntity
     * @param 連番 int
     * @param 日付スラッシュ編集_flag boolean
     *
     */
    public void setEucCsvEntity(ShakaiFukushiHojinKeigenCsvEntity eucCsvEntity,
            ShakaiFukushiHojinKeigenGaitoshaIchiranEntity entity, int 連番, boolean 日付スラッシュ編集_flag) {
        日付スラッシュ編集 = 日付スラッシュ編集_flag;
        eucCsvEntity.set連番(new RString(連番));
        if (entity.get社会福祉法人等利用者負担軽減の情報() != null) {
            seteucCsvEntity軽減の情報_NotNull(eucCsvEntity, entity);
        } else {
            eucCsvEntity.set証保険者番号(RString.EMPTY);
            eucCsvEntity.set確認番号(RString.EMPTY);
            eucCsvEntity.set決定区分(RString.EMPTY);
            eucCsvEntity.set減免事由(RString.EMPTY);
            eucCsvEntity.set減免申請日(RString.EMPTY);
            eucCsvEntity.set減免決定日(RString.EMPTY);
            eucCsvEntity.set減免適用日(RString.EMPTY);
            eucCsvEntity.set減免有効期限(RString.EMPTY);
            eucCsvEntity.set軽減率分子(RString.EMPTY);
            eucCsvEntity.set軽減率分母(RString.EMPTY);
            eucCsvEntity.set対象サービスの制限(RString.EMPTY);
        }
        eucCsvEntity.set被保険者番号(entity.get被保険者番号() != null ? entity.get被保険者番号().value() : RString.EMPTY);
        if (entity.get宛名() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
            eucCsvEntity.set識別コード(kojin.get識別コード().value());
            eucCsvEntity.set住所コード(kojin.get住所().get全国住所コード().value());
            eucCsvEntity.set氏名(kojin.get名称().getName().value());
            eucCsvEntity.setカナ氏名(kojin.get名称().getKana().value());
            eucCsvEntity.set年齢(kojin.get年齢算出().get年齢());
            eucCsvEntity.set住民種別(kojin.get住民状態().住民状態略称());
            eucCsvEntity.set郵便番号(kojin.get住所().get住所());
            eucCsvEntity.set住所(kojin.get住所().get住所());
            eucCsvEntity.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().value());
            eucCsvEntity.set行政区(kojin.get行政区画().getGyoseiku().get名称());
        } else {
            eucCsvEntity.set識別コード(RString.EMPTY);
            eucCsvEntity.set住所コード(RString.EMPTY);
            eucCsvEntity.set氏名(RString.EMPTY);
            eucCsvEntity.setカナ氏名(RString.EMPTY);
            eucCsvEntity.set年齢(RString.EMPTY);
            eucCsvEntity.set住民種別(RString.EMPTY);
            eucCsvEntity.set郵便番号(RString.EMPTY);
            eucCsvEntity.set住所(RString.EMPTY);
            eucCsvEntity.set行政区コード(RString.EMPTY);
            eucCsvEntity.set行政区(RString.EMPTY);
        }

        eucCsvEntity.set居宅支援事業者番号(entity.get計画事業者番号() != null ? entity.get計画事業者番号() : RString.EMPTY);
        if (entity.is自己作成()) {
            eucCsvEntity.set居宅支援事業者名称(entity.get計画事業者名() != null ? entity.get計画事業者名() : RString.EMPTY);
        } else {
            eucCsvEntity.set居宅支援事業者名称(自己作成);
        }
        if (entity.is老齢福祉年金受給者()) {
            eucCsvEntity.set老齢福祉年金受給(ASTERISK);
        } else {
            eucCsvEntity.set居宅支援事業者名称(RString.EMPTY);
        }
        if (entity.is生活保護受給者()) {
            eucCsvEntity.set生活保護受給区分(ASTERISK);
        } else {
            eucCsvEntity.set生活保護受給区分(RString.EMPTY);
        }
        if (entity.get本人課税区分().equals(new RString("1"))) {
            eucCsvEntity.set課税区分(課);
        } else {
            eucCsvEntity.set課税区分(RString.EMPTY);
        }
        if (entity.is所得税課税者()) {
            eucCsvEntity.set所得税課税区分(課);
        } else {
            eucCsvEntity.set所得税課税区分(RString.EMPTY);
        }
        eucCsvEntity.set入所施設コード(entity.get入所施設コード());
        eucCsvEntity.set入所施設名称(entity.get入所施設名称());
        if (entity.is旧措置者フラグ()) {
            eucCsvEntity.set旧措置(旧措置者);
        } else {
            eucCsvEntity.set旧措置(RString.EMPTY);
        }
        if (entity.get厚労省IF識別コード() != null && entity.get要介護状態区分コード() != null) {
            eucCsvEntity.set要介護度(YokaigoJotaiKubunSupport.toValue(
                    KoroshoInterfaceShikibetsuCode.toValue(entity.get厚労省IF識別コード()), entity.get要介護状態区分コード()).getName());
        } else {
            eucCsvEntity.set要介護度(RString.EMPTY);
        }
        eucCsvEntity.set認定日(toパターン32or34(日付スラッシュ編集_flag, entity.get認定年月日()));
        eucCsvEntity.set認定開始日(toパターン32or34(日付スラッシュ編集_flag, entity.get認定有効期間開始日()));
        eucCsvEntity.set認定終了日(toパターン32or34(日付スラッシュ編集_flag, entity.get認定有効期間終了日()));
    }

    /**
     * 世帯員CSV出力情報を設定します．
     *
     * @param eucCsvEntity ShakaiFukushiHojinKeigenCsvEntity
     * @param joho Setaiinshotokujoho
     *
     */
    public void set世帯員CsvEntity(ShakaiFukushiHojinKeigenCsvEntity eucCsvEntity, Setaiinshotokujoho joho) {
        if (joho.get世帯員宛名() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(joho.get世帯員宛名());
            eucCsvEntity.set世帯員氏名(kojin.get名称().getName().value());
            eucCsvEntity.set世帯員住民種別(kojin.get住民状態().住民状態略称());
        } else {
            eucCsvEntity.set世帯員氏名(RString.EMPTY);
            eucCsvEntity.set世帯員住民種別(RString.EMPTY);
        }
        if (!joho.get本人課税区分().isNullOrEmpty() && joho.get本人課税区分().equals(new RString("1"))) {
            eucCsvEntity.set世帯員課税区分(課);
        } else {
            eucCsvEntity.set世帯員課税区分(RString.EMPTY);
        }

        if (joho.get課税所得額() != null && joho.get課税所得額().intValue() > 0) {
            eucCsvEntity.set世帯員所得税課税区分(課);
        } else {
            eucCsvEntity.set世帯員所得税課税区分(RString.EMPTY);
        }

    }

    /**
     * EMPTYCSV出力情報を設定します．
     *
     * @param eucCsvEntity ShakaiFukushiHojinKeigenCsvEntity
     *
     */
    public void setCsvEntityEmptyNo世帯員(ShakaiFukushiHojinKeigenCsvEntity eucCsvEntity) {
        eucCsvEntity.setカナ氏名(RString.EMPTY);
        eucCsvEntity.set住所(RString.EMPTY);
        eucCsvEntity.set住所コード(RString.EMPTY);
        eucCsvEntity.set住民種別(RString.EMPTY);
        eucCsvEntity.set入所施設コード(RString.EMPTY);
        eucCsvEntity.set入所施設名称(RString.EMPTY);
        eucCsvEntity.set対象サービスの制限(RString.EMPTY);
        eucCsvEntity.set居宅支援事業者名称(RString.EMPTY);
        eucCsvEntity.set居宅支援事業者番号(RString.EMPTY);
        eucCsvEntity.set年齢(RString.EMPTY);
        eucCsvEntity.set所得税課税区分(RString.EMPTY);
        eucCsvEntity.set旧措置(RString.EMPTY);
        eucCsvEntity.set氏名(RString.EMPTY);
        eucCsvEntity.set決定区分(RString.EMPTY);
        eucCsvEntity.set減免事由(RString.EMPTY);
        eucCsvEntity.set減免有効期限(RString.EMPTY);
        eucCsvEntity.set減免決定日(RString.EMPTY);
        eucCsvEntity.set減免申請日(RString.EMPTY);
        eucCsvEntity.set減免適用日(RString.EMPTY);
        eucCsvEntity.set生活保護受給区分(RString.EMPTY);
        eucCsvEntity.set確認番号(RString.EMPTY);
        eucCsvEntity.set老齢福祉年金受給(RString.EMPTY);
        eucCsvEntity.set行政区(RString.EMPTY);
        eucCsvEntity.set行政区コード(RString.EMPTY);
        eucCsvEntity.set被保険者番号(RString.EMPTY);
        eucCsvEntity.set要介護度(RString.EMPTY);
        eucCsvEntity.set証保険者番号(RString.EMPTY);
        eucCsvEntity.set認定日(RString.EMPTY);
        eucCsvEntity.set認定終了日(RString.EMPTY);
        eucCsvEntity.set認定開始日(RString.EMPTY);
        eucCsvEntity.set課税区分(RString.EMPTY);
        eucCsvEntity.set識別コード(RString.EMPTY);
        eucCsvEntity.set軽減率分子(RString.EMPTY);
        eucCsvEntity.set軽減率分母(RString.EMPTY);
        eucCsvEntity.set連番(RString.EMPTY);
        eucCsvEntity.set郵便番号(RString.EMPTY);
    }

    private void seteucCsvEntity軽減の情報_NotNull(
            ShakaiFukushiHojinKeigenCsvEntity eucCsvEntity, ShakaiFukushiHojinKeigenGaitoshaIchiranEntity entity) {
        ShakaifukuRiyoshaFutanKeigen shakaifukuriyoshafutankeigen = new ShakaifukuRiyoshaFutanKeigen(entity.get社会福祉法人等利用者負担軽減の情報());
        eucCsvEntity.set証保険者番号(
                shakaifukuriyoshafutankeigen.get証記載保険者番号() != null ? shakaifukuriyoshafutankeigen.get証記載保険者番号().value() : RString.EMPTY);
        eucCsvEntity.set確認番号(shakaifukuriyoshafutankeigen.get確認番号());
        if (shakaifukuriyoshafutankeigen.get決定区分() != null) {
            if (shakaifukuriyoshafutankeigen.get決定区分().equals(承認する)) {
                eucCsvEntity.set決定区分(承認);
            } else if (shakaifukuriyoshafutankeigen.get決定区分().equals(承認しない)) {
                eucCsvEntity.set決定区分(却下);
            } else {
                eucCsvEntity.set決定区分(RString.EMPTY);
            }
        } else {
            eucCsvEntity.set決定区分(RString.EMPTY);

        }
        if (shakaifukuriyoshafutankeigen.get申請事由() != null && !shakaifukuriyoshafutankeigen.get申請事由().isEmpty()) {
            eucCsvEntity.set減免事由(shakaifukuriyoshafutankeigen.get申請事由());
        }
        eucCsvEntity.set減免申請日(toパターン32or34(日付スラッシュ編集, shakaifukuriyoshafutankeigen.get申請年月日()));
        eucCsvEntity.set減免決定日(toパターン32or34(日付スラッシュ編集, shakaifukuriyoshafutankeigen.get決定年月日()));
        eucCsvEntity.set減免適用日(toパターン32or34(日付スラッシュ編集, shakaifukuriyoshafutankeigen.get適用開始年月日()));
        eucCsvEntity.set減免有効期限(toパターン32or34(日付スラッシュ編集, shakaifukuriyoshafutankeigen.get適用終了年月日()));
        if (shakaifukuriyoshafutankeigen.get軽減率_分子() != null) {
            eucCsvEntity.set軽減率分子(new RString(shakaifukuriyoshafutankeigen.get軽減率_分子().toString()));
        } else {
            eucCsvEntity.set軽減率分子(RString.EMPTY);
        }
        if (shakaifukuriyoshafutankeigen.get軽減率_分母() != null) {
            eucCsvEntity.set軽減率分母(new RString(shakaifukuriyoshafutankeigen.get軽減率_分子().toString()));
        } else {
            eucCsvEntity.set軽減率分母(RString.EMPTY);
        }

        if (shakaifukuriyoshafutankeigen.is居宅サービス限定()) {
            eucCsvEntity.set対象サービスの制限(居宅サービスのみ.concat(POINT));
        }
        if (shakaifukuriyoshafutankeigen.is居住費_食費のみ() && shakaifukuriyoshafutankeigen.is居宅サービス限定()) {
            eucCsvEntity.set対象サービスの制限(eucCsvEntity.get対象サービスの制限().concat(居住費食費のみ.concat(POINT)));
        }
        if (shakaifukuriyoshafutankeigen.is旧措置者ユニット型個室のみ() && !eucCsvEntity.get対象サービスの制限().isNullOrEmpty()) {
            eucCsvEntity.set対象サービスの制限(eucCsvEntity.get対象サービスの制限().concat(旧措ユ個のみ.concat(POINT)));
        }
        if (eucCsvEntity.get対象サービスの制限() != null) {
            int length = eucCsvEntity.get対象サービスの制限().length();
            eucCsvEntity.set対象サービスの制限(eucCsvEntity.get対象サービスの制限().substring(NO_0, length - NO_1));
        } else {
            eucCsvEntity.set対象サービスの制限(RString.EMPTY);
        }
    }

    private RString toパターン32or34(boolean flag, FlexibleDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        if (flag) {
            return date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        } else {
            return date.seireki().
                    separator(Separator.NONE).
                    fillType(FillType.ZERO).
                    toDateString();
        }
    }
}
