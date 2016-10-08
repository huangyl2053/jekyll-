/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd205010;

import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.RiyoshaFutanDankai;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbz00001.KakuninListCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbz00001.NinteishaListSakuseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbz00001.SetaiInRisutoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 負担限度額認定者リスト発行ビジネスクラスです。
 *
 * @reamsid_L DBD-3960-050 x_liuwei
 */
public class NinteishaListSakuseiBusiness {

    /**
     * CSV出力情報を設定します．
     *
     * @param eucCsvEntity CSV出力情報
     * @param t SQL取得情報
     * @param 連番 連番
     * @param is日付スラッシュ編集 is日付スラッシュ編集
     * @param has世帯員以外情報 has世帯員以外情報
     * @param has世帯員情報 has世帯員情報
     * @param 世帯員情報Index 世帯員情報Index
     */
    public void setEucCsvEntity(KakuninListCsvEntity eucCsvEntity, NinteishaListSakuseiEntity t, int 連番, boolean is日付スラッシュ編集,
            boolean has世帯員以外情報, boolean has世帯員情報, int 世帯員情報Index) {
        if (has世帯員以外情報) {
            eucCsvEntity.set連番(new RString(連番));
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(t.getPsmEntity());
            eucCsvEntity.set被保険者番号(t.get被保険者番号().getColumnValue());
            eucCsvEntity.set識別コード(kojin.get識別コード().value());
            eucCsvEntity.set住所コード(kojin.get住所().get全国住所コード().value());
            if (t.get介護保険負担限度額認定Entity() != null && t.get介護保険負担限度額認定Entity().getShoKisaiHokenshaNo() != null) {
                eucCsvEntity.set証保険者番号(t.get介護保険負担限度額認定Entity().getShoKisaiHokenshaNo().value());
            }
            eucCsvEntity.set氏名(kojin.get名称().getName().value());
            eucCsvEntity.setカナ氏名(kojin.get名称().getKana().value());
            eucCsvEntity.set年齢(kojin.get年齢算出().get年齢());
            eucCsvEntity.set住民種別(kojin.get住民状態().住民状態略称());
            eucCsvEntity.set郵便番号(kojin.get住所().get郵便番号().value());
            eucCsvEntity.set住所(kojin.get住所().get住所());
            eucCsvEntity.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().value());
            eucCsvEntity.set行政区(kojin.get行政区画().getGyoseiku().get名称());
            edit出力情報_介護保険負担限度額認定(eucCsvEntity, t, is日付スラッシュ編集);
            eucCsvEntity.set老齢福祉年金受給区分(t.is老齢福祉年金受給者() ? new RString("*") : RString.EMPTY);
            eucCsvEntity.set生活保護受給区分(t.is生活保護受給者() ? new RString("*") : RString.EMPTY);
            eucCsvEntity.set所得税区分(t.is所得税課税者() ? new RString("課") : RString.EMPTY);
            eucCsvEntity.set課税区分(KazeiKubun.課税.getコード().equals(t.get本人課税区分()) ? new RString("課") : RString.EMPTY);
            eucCsvEntity.set合計所得金額(new RString(t.get合計所得_含年金収入().toString()));
            eucCsvEntity.set入所施設コード(t.get入所施設コード());
            eucCsvEntity.set入所施設名称(t.get入所施設名称());
            eucCsvEntity.set認定前負担段階(RiyoshaFutanDankai.toValue(t.get利用者負担段階()).get名称());
            eucCsvEntity.set旧措置_受給者台帳(t.is受給者台帳Newest_旧措置者フラグ() ? new RString("旧措置者") : RString.EMPTY);

            if (t.get認定情報Entity() != null
                    && t.get認定情報Entity().get認定情報_要介護状態区分コード() != null
                    && t.get要介護認定申請情報_厚労省IF識別コード() != null) {
                eucCsvEntity.set要介護度(YokaigoJotaiKubunSupport.toValue(KoroshoInterfaceShikibetsuCode.toValue(t.get要介護認定申請情報_厚労省IF識別コード()),
                        t.get認定情報Entity().get認定情報_要介護状態区分コード()).getName());
            }
            if (t.get認定情報Entity() != null) {
                eucCsvEntity.set認定日(set年月日(t.get認定情報Entity().get認定情報_認定年月日(), is日付スラッシュ編集));
                eucCsvEntity.set認定開始日(set年月日(t.get認定情報Entity().get認定情報_認定有効期間開始年月日(), is日付スラッシュ編集));
                eucCsvEntity.set認定終了日(set年月日(t.get認定情報Entity().get認定情報_認定有効期間終了年月日(), is日付スラッシュ編集));
            }

            if (t.get介護保険負担限度額認定Entity() != null && kojin.get異動年月日() != null) {
                eucCsvEntity.set住民となった日(set年月日(kojin.get異動年月日(), is日付スラッシュ編集));
            }

            eucCsvEntity.set住所地特例該当(new RString("1").equals(t.get被保険者台帳情報_住所地特例フラグ()) ? new RString("*") : RString.EMPTY);
            if (t.get非課税年金勘案額() == null) {
                eucCsvEntity.set非課税年金有(RString.EMPTY);
            } else {
                eucCsvEntity.set非課税年金有(new RString("*"));
            }

        }

        if (has世帯員情報) {
            SetaiInRisutoEntity setaEntity = t.get世帯員リスト().get(世帯員情報Index);
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(t.get世帯員リスト().get(世帯員情報Index).get世帯員宛名());
            eucCsvEntity.set世帯員氏名(kojin.get名称().getName().value());
            eucCsvEntity.set世帯員住民種別(kojin.get住民状態().住民状態略称());
            if (setaEntity.get課税区分() != null && !setaEntity.get課税区分().isEmpty() && setaEntity.get課税区分().equals(new RString("1"))) {
                eucCsvEntity.set世帯員課税区分(new RString("課"));
            } else {
                eucCsvEntity.set世帯員課税区分(RString.EMPTY);
            }
            if (setaEntity.get課税所得額() != null && setaEntity.get課税所得額().intValue() > 0) {
                eucCsvEntity.set世帯員所得税課税区分(new RString("課"));
            } else {
                eucCsvEntity.set世帯員所得税課税区分(RString.EMPTY);
            }
        }

    }

    private void edit出力情報_介護保険負担限度額認定(KakuninListCsvEntity eucCsvEntity, NinteishaListSakuseiEntity t, boolean is日付スラッシュ編集) {
        if (t.get介護保険負担限度額認定Entity() != null && t.get介護保険負担限度額認定Entity().getKetteiKubun() != null) {
            eucCsvEntity.set決定区分(t.get介護保険負担限度額認定Entity().getKetteiKubun());
        }

        if (t.get介護保険負担限度額認定Entity() != null && t.get介護保険負担限度額認定Entity().getKyusochishaKubun() != null) {
            eucCsvEntity.set旧措置者_負担限度額認定(t.get介護保険負担限度額認定Entity().getKyusochishaKubun());
        }

        edit出力情報_日期について(eucCsvEntity, t, is日付スラッシュ編集);

        if (t.get介護保険負担限度額認定Entity() != null && t.get介護保険負担限度額認定Entity().getRiyoshaFutanDankai() != null) {
            eucCsvEntity.set利用者負担段階(RiyoshaFutanDankai.toValue(t.get介護保険負担限度額認定Entity().getRiyoshaFutanDankai()).get名称());
        }

        if (t.get介護保険負担限度額認定Entity() != null && t.get介護保険負担限度額認定Entity().getShokuhiFutanGendogaku() != null) {
            Decimal 食費負担額 = t.get介護保険負担限度額認定Entity().getShokuhiFutanGendogaku();
            if (null != 食費負担額) {
                eucCsvEntity.set食費負担額(new RString(食費負担額.toString()));
            }
        }

        if (t.get介護保険負担限度額認定Entity() != null && t.get介護保険負担限度額認定Entity().getUnitTypeKoshitsu() != null) {
            Decimal 居住費負担限度額ユニット型個室 = t.get介護保険負担限度額認定Entity().getUnitTypeKoshitsu();
            if (null != 居住費負担限度額ユニット型個室) {
                eucCsvEntity.set居住費負担限度額ユニット型個室(new RString(居住費負担限度額ユニット型個室.toString()));
            }
        }

        if (t.get介護保険負担限度額認定Entity() != null && t.get介護保険負担限度額認定Entity().getUnitTypeJunKoshitsu() != null) {
            Decimal 居住費負担限度額ユニット型準個室 = t.get介護保険負担限度額認定Entity().getUnitTypeJunKoshitsu();
            if (null != 居住費負担限度額ユニット型準個室) {
                eucCsvEntity.set居住費負担限度額ユニット型準個室(new RString(居住費負担限度額ユニット型準個室.toString()));
            }
        }

        if (t.get介護保険負担限度額認定Entity() != null && t.get介護保険負担限度額認定Entity().getJuraiTypeKoshitsu_Tokuyo() != null) {
            Decimal 居住費負担限度額従来型個室_特養等 = t.get介護保険負担限度額認定Entity().getJuraiTypeKoshitsu_Tokuyo();
            if (null != 居住費負担限度額従来型個室_特養等) {
                eucCsvEntity.set居住費負担限度額従来型個室_特養等(new RString(居住費負担限度額従来型個室_特養等.toString()));
            }
        }

        if (t.get介護保険負担限度額認定Entity() != null && t.get介護保険負担限度額認定Entity().getJuraiTypeKoshitsu_Roken_Ryoyo() != null) {
            Decimal 居住費負担限度額従来型個室_老健療養等 = t.get介護保険負担限度額認定Entity().getJuraiTypeKoshitsu_Roken_Ryoyo();
            if (null != 居住費負担限度額従来型個室_老健療養等) {
                eucCsvEntity.set居住費負担限度額従来型個室_老健療養等(new RString(居住費負担限度額従来型個室_老健療養等.toString()));
            }
        }

        if (t.get介護保険負担限度額認定Entity() != null && t.get介護保険負担限度額認定Entity().getTashoshitsu() != null) {
            Decimal 居住費負担限度額多床室 = t.get介護保険負担限度額認定Entity().getTashoshitsu();
            if (null != 居住費負担限度額多床室) {
                eucCsvEntity.set居住費負担限度額多床室(new RString(居住費負担限度額多床室.toString()));
            }
        }

        if (t.get介護保険負担限度額認定Entity() != null) {
            if (t.get介護保険負担限度額認定Entity().getIzokuNenkinJukyuFlag() || t.get介護保険負担限度額認定Entity().getShogaiNenkinJukyuFlag()) {
                eucCsvEntity.set非課税年金自己申告有(new RString("*"));
            } else {
                eucCsvEntity.set非課税年金自己申告有(RString.EMPTY);
            }
        }
    }

    private void edit出力情報_日期について(KakuninListCsvEntity eucCsvEntity, NinteishaListSakuseiEntity t, boolean is日付スラッシュ編集) {
        if (t.get介護保険負担限度額認定Entity() != null && t.get介護保険負担限度額認定Entity().getShinseiYMD() != null) {
            eucCsvEntity.set減免申請日(set年月日(t.get介護保険負担限度額認定Entity().getShinseiYMD(), is日付スラッシュ編集));
        }

        if (t.get介護保険負担限度額認定Entity() != null && t.get介護保険負担限度額認定Entity().getKetteiYMD() != null) {
            eucCsvEntity.set減免決定日(set年月日(t.get介護保険負担限度額認定Entity().getKetteiYMD(), is日付スラッシュ編集));
        }

        if (t.get介護保険負担限度額認定Entity() != null && t.get介護保険負担限度額認定Entity().getTekiyoKaishiYMD() != null) {
            eucCsvEntity.set減免適用日(set年月日(t.get介護保険負担限度額認定Entity().getTekiyoKaishiYMD(), is日付スラッシュ編集));
        }

        if (t.get介護保険負担限度額認定Entity() != null && t.get介護保険負担限度額認定Entity().getTekiyoShuryoYMD() != null) {
            eucCsvEntity.set減免有効期限(set年月日(t.get介護保険負担限度額認定Entity().getTekiyoShuryoYMD(), is日付スラッシュ編集));
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
