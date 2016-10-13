/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200002;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00002.NinteishaListSakuseiResultCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00002.NinteishaListSakuseiResultEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist.CSVSettings;
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
 * 利用者負担額減免認定者リストCSV編集。
 *
 * @reamsid_L DBD-3980-030 x_youyj
 */
public class NinteishaListSakuseiBusiness {

    private static final RString THERE = new RString("3");
    private static final RString ZEROSIX = new RString("06");
    private static final RString 却下 = new RString("却下");
    private static final RString 承認 = new RString("承認");
    private static final RString 空白 = new RString("");
    private static final RString ASTERISK = new RString("*");
    private static final RString 課 = new RString("課");
    private static final RString 旧措置者 = new RString("旧措置者");
    private int 連番 = 0;

    /**
     * 利用者負担額減免認定者リストCSV編集
     *
     * @param t NinteishaListSakuseiResultEntity
     * @param csv出力設定 List<CSVSettings>
     * @return NinteishaListSakuseiResultCsvEntity
     */
    public NinteishaListSakuseiResultCsvEntity set利用者負担額減免認定者リストCSV(NinteishaListSakuseiResultEntity t, List<CSVSettings> csv出力設定) {
        NinteishaListSakuseiResultCsvEntity resultEntity = new NinteishaListSakuseiResultCsvEntity();
        resultEntity.set連番(new RString(String.valueOf(++連番)));
        resultEntity.set被保険者番号(t.get被保険者番号().getColumnValue());
        if (t.getPsmEntity() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(t.getPsmEntity());
            resultEntity.set識別コード(kojin.get識別コード().getColumnValue());
            resultEntity.set住所コード(kojin.get住所().get全国住所コード().getColumnValue());
            resultEntity.set氏名(kojin.get名称().getName().getColumnValue());
            resultEntity.setカナ氏名(kojin.get名称().getKana().getColumnValue());
            resultEntity.set年齢(kojin.get年齢算出().get年齢());
            resultEntity.set住民種別(kojin.get住民状態().住民状態略称());
            resultEntity.set郵便番号(kojin.get住所().get郵便番号().getColumnValue());
            resultEntity.set住所(kojin.get住所().get住所());
            resultEntity.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().getColumnValue());
            resultEntity.set行政区(kojin.get行政区画().getGyoseiku().get名称());
        }
        if (t.get減免減額申請Entity() != null && t.get減免減額申請Entity().getShoKisaiHokenshaNo() != null) {
            resultEntity.set証保険者番号(t.get減免減額申請Entity().getShoKisaiHokenshaNo().getColumnValue());
        }
        if (t.get利用者負担額減額Entity() != null && t.get利用者負担額減額Entity().getKetteiKubun() != null) {
            if (KetteiKubun.承認しない.getコード().equals(t.get利用者負担額減額Entity().getKetteiKubun())) {
                resultEntity.set決定区分(却下);
            } else if (KetteiKubun.承認する.getコード().equals(t.get利用者負担額減額Entity().getKetteiKubun())) {
                resultEntity.set決定区分(承認);
            } else {
                resultEntity.set決定区分(空白);
            }
        }
        if (t.is老齢福祉年金受給者()) {
            resultEntity.set老齢福祉年金受給(ASTERISK);
        } else {
            resultEntity.set老齢福祉年金受給(空白);
        }

        if (t.is生活保護受給者()) {
            resultEntity.set生活保護受給区分(ASTERISK);
        } else {
            resultEntity.set生活保護受給区分(空白);
        }
        if (t.get本人課税区分() != null) {
            if (KazeiKubun.課税.getコード().equals(t.get本人課税区分())) {
                resultEntity.set課税区分(課);
            } else {
                resultEntity.set課税区分(空白);
            }
        }
        if (t.get利用者負担額減額Entity() == null || t.get利用者負担額減額Entity().getKyuhuritsu() == null) {
            resultEntity.set減免給付率(空白);
        } else {
            HokenKyufuRitsu kyuhuritsu = t.get利用者負担額減額Entity().getKyuhuritsu();
            if (kyuhuritsu != null) {
                Decimal str = kyuhuritsu.getColumnValue();
                resultEntity.set減免給付率(new RString(str.toString()));
            }
        }
        setVoidEntity(resultEntity, t, csv出力設定);
        setEntity(resultEntity, t, csv出力設定);
        return resultEntity;
    }

    private NinteishaListSakuseiResultCsvEntity setVoidEntity(NinteishaListSakuseiResultCsvEntity resultEntity,
            NinteishaListSakuseiResultEntity t, List<CSVSettings> csv出力設定) {
        if (t.get減免減額申請Entity() != null) {
            resultEntity.set減免事由(t.get減免減額申請Entity().getGemmenGengakuShurui());
        }
        for (CSVSettings csvsetings : csv出力設定) {
            if (THERE.equals(csvsetings.getコード())) {
                set減免申請日(resultEntity, t);
            } else {
                FlexibleDate shineiYMD = null;
                FlexibleDate ketteiYMD = null;
                FlexibleDate tekiyoKaishiYMD = null;
                FlexibleDate tekiyoShuryoYMD = null;
                if (t.get利用者負担額減額Entity() != null) {
                    shineiYMD = t.get利用者負担額減額Entity().getShinseiYMD();
                    ketteiYMD = t.get利用者負担額減額Entity().getKetteiYMD();
                    tekiyoKaishiYMD = t.get利用者負担額減額Entity().getTekiyoKaishiYMD();
                    tekiyoShuryoYMD = t.get利用者負担額減額Entity().getTekiyoShuryoYMD();
                }
                if (shineiYMD != null && !shineiYMD.isEmpty()) {
                    resultEntity.set減免申請日(shineiYMD.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString());
                }
                if (ketteiYMD != null && !ketteiYMD.isEmpty()) {
                    resultEntity.set減免決定日(ketteiYMD.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString());
                }
                if (tekiyoKaishiYMD != null && !tekiyoKaishiYMD.isEmpty()) {
                    resultEntity.set減免適用日(tekiyoKaishiYMD.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString());
                }
                if (tekiyoShuryoYMD != null && !tekiyoShuryoYMD.isEmpty()) {
                    resultEntity.set減免有効期限(tekiyoShuryoYMD.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString());
                }
            }
        }
        resultEntity.set入所施設コード(t.get入所施設コード());
        resultEntity.set入所施設名称(t.get入所施設名称());
        return resultEntity;
    }

    private void set減免申請日(NinteishaListSakuseiResultCsvEntity resultEntity, NinteishaListSakuseiResultEntity t) {
        FlexibleDate shineiYMD = null;
        FlexibleDate ketteiYMD = null;
        FlexibleDate tekiyoKaishiYMD = null;
        FlexibleDate tekiyoShuryoYMD = null;
        if (t.get利用者負担額減額Entity() != null) {
            shineiYMD = t.get利用者負担額減額Entity().getShinseiYMD();
            ketteiYMD = t.get利用者負担額減額Entity().getKetteiYMD();
            tekiyoKaishiYMD = t.get利用者負担額減額Entity().getTekiyoKaishiYMD();
            tekiyoShuryoYMD = t.get利用者負担額減額Entity().getTekiyoShuryoYMD();
        }
        if (shineiYMD != null && !shineiYMD.isEmpty()) {
            resultEntity.set減免申請日(shineiYMD.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        }
        if (ketteiYMD != null && !ketteiYMD.isEmpty()) {
            resultEntity.set減免決定日(ketteiYMD.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        }
        if (tekiyoKaishiYMD != null && !tekiyoKaishiYMD.isEmpty()) {
            resultEntity.set減免適用日(tekiyoKaishiYMD.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        }
        if (tekiyoShuryoYMD != null && !tekiyoShuryoYMD.isEmpty()) {
            resultEntity.set減免有効期限(tekiyoShuryoYMD.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        }
    }

    private NinteishaListSakuseiResultCsvEntity setEntity(NinteishaListSakuseiResultCsvEntity resultEntity,
            NinteishaListSakuseiResultEntity t, List<CSVSettings> csv出力設定) {
        if (t.get厚労省IF識別コード() != null && !t.get厚労省IF識別コード().isEmpty()) {
            if (t.get認定情報の要介護状態区分コード() == null || t.get認定情報の要介護状態区分コード().isEmpty()) {
                resultEntity.set要介護度((YokaigoJotaiKubunSupport.toValue(KoroshoInterfaceShikibetsuCode.toValue(t.get厚労省IF識別コード()),
                        ZEROSIX)).getName());
            } else {
                resultEntity.set要介護度((YokaigoJotaiKubunSupport.toValue(KoroshoInterfaceShikibetsuCode.toValue(t.get厚労省IF識別コード()),
                        t.get認定情報の要介護状態区分コード())).getName());
            }
        }
        for (CSVSettings csvsetings : csv出力設定) {
            if (THERE.equals(csvsetings.getコード())) {
                認定日期(resultEntity, t);
            } else {
                els認定日期(resultEntity, t);
            }
        }
        if (t.is旧措置者フラグ()) {
            resultEntity.set旧措置(旧措置者);
        } else {
            resultEntity.set旧措置(空白);
        }
        if (t.is所得税課税者()) {
            resultEntity.set所得税課税区分(課);
        } else {
            resultEntity.set所得税課税区分(空白);
        }

        return resultEntity;
    }

    private void els認定日期(NinteishaListSakuseiResultCsvEntity resultEntity, NinteishaListSakuseiResultEntity t) {
        FlexibleDate 認定年月日 = t.get認定情報の認定年月日();
        if (認定年月日 != null && !認定年月日.isEmpty()) {
            resultEntity.set認定日(認定年月日.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString());
        } else {
            FlexibleDate クリスト実施日 = t.get総者のチェックリスト実施日();
            if (クリスト実施日 != null && !クリスト実施日.isEmpty()) {
                resultEntity.set認定日(クリスト実施日.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString());
            }
        }
        FlexibleDate 認定有効期間開始年月日 = t.get認定情報の認定有効期間開始年月日();
        if (認定有効期間開始年月日 != null && !認定有効期間開始年月日.isEmpty()) {
            resultEntity.set認定開始日(認定有効期間開始年月日.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString());
        } else {
            FlexibleDate 適用開始年月日 = t.get総者の適用開始年月日();
            if (適用開始年月日 != null && !適用開始年月日.isEmpty()) {
                resultEntity.set認定開始日(適用開始年月日.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString());
            }
        }
        FlexibleDate 認定有効期間終了年月日 = t.get認定情報の認定有効期間終了年月日();
        if (認定有効期間終了年月日 != null && !認定有効期間終了年月日.isEmpty()) {
            resultEntity.set認定終了日(認定有効期間終了年月日.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString());
        } else {
            FlexibleDate 適用終了年月日 = t.get総者の適用終了年月日();
            if (適用終了年月日 != null && !適用終了年月日.isEmpty()) {
                resultEntity.set認定終了日(適用終了年月日.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString());
            }
        }
    }

    private void 認定日期(NinteishaListSakuseiResultCsvEntity resultEntity, NinteishaListSakuseiResultEntity t) {
        FlexibleDate 認定年月日 = t.get認定情報の認定年月日();
        if (認定年月日 != null && !認定年月日.isEmpty()) {
            resultEntity.set認定日(認定年月日.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        } else {
            FlexibleDate クリスト実施日 = t.get総者のチェックリスト実施日();
            if (クリスト実施日 != null && !クリスト実施日.isEmpty()) {
                resultEntity.set認定日(クリスト実施日.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
            }
        }
        FlexibleDate 認定有効期間開始年月日 = t.get認定情報の認定有効期間開始年月日();
        if (認定有効期間開始年月日 != null && !認定有効期間開始年月日.isEmpty()) {
            resultEntity.set認定開始日(認定有効期間開始年月日.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        } else {
            FlexibleDate 適用開始年月日 = t.get総者の適用開始年月日();
            if (適用開始年月日 != null && !適用開始年月日.isEmpty()) {
                resultEntity.set認定開始日(適用開始年月日.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
            }
        }
        FlexibleDate 認定有効期間終了年月日 = t.get認定情報の認定有効期間終了年月日();
        if (認定有効期間終了年月日 != null && !認定有効期間終了年月日.isEmpty()) {
            resultEntity.set認定終了日(認定有効期間終了年月日.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
        } else {
            FlexibleDate 適用終了年月日 = t.get総者の適用終了年月日();
            if (適用終了年月日 != null && !適用終了年月日.isEmpty()) {
                resultEntity.set認定終了日(適用終了年月日.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString());
            }
        }
    }
}
