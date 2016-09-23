/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd202010;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00003.KakuninListNoRenbanCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00003.NinteishaListSakuseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00003.SetaiInRisutoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 訪問介護利用者負担額減額認定者リス発行ビジネスクラスです。
 *
 * @reamsid_L DBD-3970-050 x_lilh
 */
public class NinteishaListSakuseiNoRenbaBusiness {

    private static final RString SPACE = new RString(" ");
    private static final RString SXING = new RString("*");
    private static final RString KE = new RString("課");
    private static final RString JIUCUO = new RString("旧措置者");

    /**
     * CSV出力情報を設定します．
     *
     * @param eucCsvEntity CSV出力情報
     * @param t SQL取得情報
     * @param is日付スラッシュ編集 is日付スラッシュ編集
     * @param has世帯員以外情報 has世帯員以外情報
     * @param has世帯員情報 has世帯員情報
     * @param 世帯員情報Index 世帯員情報Index
     */
    public void setEucCsvEntity(KakuninListNoRenbanCsvEntity eucCsvEntity, NinteishaListSakuseiEntity t, boolean is日付スラッシュ編集,
            boolean has世帯員以外情報, boolean has世帯員情報, int 世帯員情報Index) {

        if (has世帯員以外情報) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(t.getPsmEntity());

            eucCsvEntity.set被保険者番号(t.get被保険者番号().getColumnValue());
            eucCsvEntity.set識別コード(kojin.get識別コード().value());
            eucCsvEntity.set住所コード(kojin.get住所().get全国住所コード().value());
            if (t.get訪問介護利用者負担額減額() != null && t.get訪問介護利用者負担額減額().getShoKisaiHokenshaNo() != null) {
                eucCsvEntity.set証保険者番号(t.get訪問介護利用者負担額減額().getShoKisaiHokenshaNo().value());
            }

            eucCsvEntity.set氏名(kojin.get名称().getName().value());
            eucCsvEntity.setカナ氏名(kojin.get名称().getKana().value());
            eucCsvEntity.set年齢(kojin.get年齢算出().get年齢());
            eucCsvEntity.set住民種別(kojin.get住民状態().住民状態略称());
            eucCsvEntity.set郵便番号(kojin.get住所().get郵便番号().value());
            eucCsvEntity.set住所(kojin.get住所().get住所());
            eucCsvEntity.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().value());
            eucCsvEntity.set行政区(kojin.get行政区画().getGyoseiku().get名称());

            edit出力情報_訪問介護利用者負担額減額(eucCsvEntity, t, is日付スラッシュ編集);
            edit出力情報_受給者(eucCsvEntity, t);

            if (t.get認定情報Entity() != null
                    && t.get認定情報Entity().get認定情報_要介護状態区分コード() != null
                    && t.get要介護認定申請情報_厚労省IF識別コード() != null) {
                eucCsvEntity.set要介護度(YokaigoJotaiKubunSupport.toValue(KoroshoInterfaceShikibetsuCode.toValue(t.get認定情報Entity().get認定情報_要介護状態区分コード()),
                        t.get要介護認定申請情報_厚労省IF識別コード()).getName());
            }
            if (t.get認定情報Entity() != null) {
                eucCsvEntity.set認定日(set年月日(t.get認定情報Entity().get認定情報_認定年月日(), is日付スラッシュ編集));
                eucCsvEntity.set認定開始日(set年月日(t.get認定情報Entity().get認定情報_認定有効期間開始年月日(), is日付スラッシュ編集));
                eucCsvEntity.set認定終了日(set年月日(t.get認定情報Entity().get認定情報_認定有効期間終了年月日(), is日付スラッシュ編集));
            }

        }

        if (has世帯員情報) {
            SetaiInRisutoEntity setaEntity = t.get世帯員リスト().get(世帯員情報Index);
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(t.get世帯員リスト().get(世帯員情報Index).get世帯員宛名());
            eucCsvEntity.set世帯員氏名(kojin.get名称().getName().value());
            eucCsvEntity.set世帯員住民種別(kojin.get住民状態().住民状態略称());
            if (setaEntity.get課税区分() != null && !setaEntity.get課税区分().isEmpty() && setaEntity.get課税区分().equals(new RString("1"))) {
                eucCsvEntity.set世帯員課税区分(KE);
            } else {
                eucCsvEntity.set世帯員課税区分(SPACE);
            }
            if (setaEntity.get課税所得額() != null && setaEntity.get課税所得額().intValue() > 0) {
                eucCsvEntity.set世帯員所得税課税区分(KE);
            } else {
                eucCsvEntity.set世帯員所得税課税区分(SPACE);
            }
        }
    }

    private void edit出力情報_訪問介護利用者負担額減額(KakuninListNoRenbanCsvEntity eucCsvEntity, NinteishaListSakuseiEntity t, boolean is日付スラッシュ編集) {
        if (t.get訪問介護利用者負担額減額() != null && t.get訪問介護利用者負担額減額().getKohiJukyushaNo() != null) {
            eucCsvEntity.set公費受給者番号(t.get訪問介護利用者負担額減額().getKohiJukyushaNo());
        }

        if (t.get訪問介護利用者負担額減額() != null && t.get訪問介護利用者負担額減額().getHobetsuKubun() != null) {
            eucCsvEntity.set法別番号(t.get訪問介護利用者負担額減額().getHobetsuKubun());
        }
        if (t.get訪問介護利用者負担額減額() != null && t.get訪問介護利用者負担額減額().getKetteiKubun() != null) {
            eucCsvEntity.set決定区分(t.get訪問介護利用者負担額減額().getKetteiKubun());
        }

        if (t.get訪問介護利用者負担額減額() != null && t.get訪問介護利用者負担額減額().getShinseiYMD() != null) {
            eucCsvEntity.set減免申請日(set年月日(t.get訪問介護利用者負担額減額().getShinseiYMD(), is日付スラッシュ編集));
        }

        if (t.get訪問介護利用者負担額減額() != null && t.get訪問介護利用者負担額減額().getKetteiYMD() != null) {
            eucCsvEntity.set減免決定日(set年月日(t.get訪問介護利用者負担額減額().getKetteiYMD(), is日付スラッシュ編集));
        }

        if (t.get訪問介護利用者負担額減額() != null && t.get訪問介護利用者負担額減額().getTekiyoKaishiYMD() != null) {
            eucCsvEntity.set減免適用日(set年月日(t.get訪問介護利用者負担額減額().getTekiyoKaishiYMD(), is日付スラッシュ編集));
        }

        if (t.get訪問介護利用者負担額減額() != null && t.get訪問介護利用者負担額減額().getTekiyoShuryoYMD() != null) {
            eucCsvEntity.set減免有効期限(set年月日(t.get訪問介護利用者負担額減額().getTekiyoShuryoYMD(), is日付スラッシュ編集));
        }

        if (t.get訪問介護利用者負担額減額() != null && t.get訪問介護利用者負担額減額().getKyufuritsu() != null) {
            Decimal 給付率Vlaue = t.get訪問介護利用者負担額減額().getKyufuritsu().value();
            eucCsvEntity.set給付率(new RString(給付率Vlaue.toString()));
        }

        if (t.get訪問介護利用者負担額減額() != null && t.get訪問介護利用者負担額減額().getShogaishaTechoTokyu() != null) {
            eucCsvEntity.set障害者手帳等級(t.get訪問介護利用者負担額減額().getShogaishaTechoTokyu());
        }

        if (t.get訪問介護利用者負担額減額() != null && t.get訪問介護利用者負担額減額().getShogaishaTechoNo() != null) {
            eucCsvEntity.set障害者番号(t.get訪問介護利用者負担額減額().getShogaishaTechoNo());
        }
    }

    private void edit出力情報_受給者(KakuninListNoRenbanCsvEntity eucCsvEntity, NinteishaListSakuseiEntity t) {

        if (t.is老齢福祉年金受給者()) {
            eucCsvEntity.set老齢福祉年金受給(SXING);
        } else {
            eucCsvEntity.set老齢福祉年金受給(SPACE);
        }

        if (t.is生活保護受給者()) {
            eucCsvEntity.set生活保護受給区分(SXING);
        } else {
            eucCsvEntity.set生活保護受給区分(SPACE);
        }
        if (t.get本人課税区分().equals(KazeiKubun.課税.getコード())) {
            eucCsvEntity.set課税区分(KE);
        } else {
            eucCsvEntity.set課税区分(SPACE);
        }

        eucCsvEntity.set特定疾病(RString.isNullOrEmpty(t.get要介護認定申請情報_2号特定疾病コード()) ? RString.EMPTY
                : TokuteiShippei.toValue(t.get要介護認定申請情報_2号特定疾病コード()).get名称());
        if (t.is所得税課税者()) {
            eucCsvEntity.set所得税課税区分(KE);
        } else {
            eucCsvEntity.set所得税課税区分(SPACE);
        }
        if (t.is受給者台帳Newest_旧措置者フラグ()) {
            eucCsvEntity.set旧措置(JIUCUO);
        } else {
            eucCsvEntity.set旧措置(SPACE);
        }

    }

    private RString set年月日(FlexibleDate 年月日, boolean is日付スラッシュ編集) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        } else {
            if (is日付スラッシュ編集) {
                return 年月日.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
            }
            return 年月日.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString();
        }
    }
}
