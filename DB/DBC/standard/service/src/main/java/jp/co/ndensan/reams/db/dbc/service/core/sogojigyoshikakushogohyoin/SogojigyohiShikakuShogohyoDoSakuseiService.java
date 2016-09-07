/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.sogojigyoshikakushogohyoin;

import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KeikakuSakuseiKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.ShikakuShogohyoKeikokuShubetsu;
import jp.co.ndensan.reams.db.dbc.entity.csv.sogojigyoshikakushogohyoin.SogojigyohiShikakuShogohyoInCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyoshikakushogohyoin.SogojigyohiShikakuShogohyoInEntity;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.core.IYokaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 総合事業費資格照合表情報取込のCSVファイル項目値を設定する。
 *
 * @reamsid_L DBC-2890-012 wangxue
 */
public class SogojigyohiShikakuShogohyoDoSakuseiService {

    private static final RString SAKUSEI = new RString("作成");
    private static final int 小数点 = 2;
    private static final int DIVIDE_100 = 100;

    /**
     * {@link InstanceProvider#create}にて生成した{@link SogojigyohiShikakuShogohyoDoSakuseiService}のインスタンスを返します。
     *
     * @return KyufuJissekiKoshinReadCsvFileService
     */
    public static SogojigyohiShikakuShogohyoDoSakuseiService createInstance() {

        return InstanceProvider.create(SogojigyohiShikakuShogohyoDoSakuseiService.class);
    }

    /**
     * CSVファイル出力データを作成する。
     *
     * @param entity SogojigyohiShikakuShogohyoInEntity
     * @param システム日付 RDateTime
     * @param 市町村セキュリティ ShichosonSecurityJoho
     * @return SogojigyohiShikakuShogohyoInCsvEntity
     */
    public SogojigyohiShikakuShogohyoInCsvEntity getCsvEntity(SogojigyohiShikakuShogohyoInEntity entity,
            RDateTime システム日付, ShichosonSecurityJoho 市町村セキュリティ) {
        SogojigyohiShikakuShogohyoInCsvEntity resultEntity
                = new SogojigyohiShikakuShogohyoInCsvEntity();
        if (entity.get連番() == 1) {
            RString 審査年月 = entity.get審査年月().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            resultEntity.set審査年月(審査年月);
            RString 作成日 = システム日付.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 作成時 = システム日付.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            resultEntity.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時).concat(RString.HALF_SPACE).concat(SAKUSEI));
        } else {
            resultEntity.set審査年月(RString.EMPTY);
            resultEntity.set作成日時(RString.EMPTY);
        }
        resultEntity.set連番(new RString(Integer.toString(entity.get連番())));
        if (null != entity.get資格照合_保険者番号()) {
            resultEntity.set保険者番号(entity.get資格照合_保険者番号().getColumnValue());
        }
        resultEntity.set保険者名(entity.get資格照合_保険者名());
        if (null != entity.get登録被保険者番号()) {
            resultEntity.set被保険者番号(entity.get登録被保険者番号().getColumnValue());
        }
        resultEntity.set被保険者氏名(entity.get宛名名称());
        if (null != entity.getサービス種類コード()) {
            resultEntity.setサービス種類コード(entity.getサービス種類コード().getColumnValue());
        }
        resultEntity.setサービス種類名(entity.getサービス種類名());
        if (null != entity.getサービス提供年月()) {
            resultEntity.setサービス提供年月(entity.getサービス提供年月().wareki().separator(Separator.PERIOD)
                    .fillType(FillType.BLANK).toDateString());
        }
        if (null != entity.get種別() && !entity.get種別().isEmpty()) {
            ShikakuShogohyoKeikokuShubetsu 警告種別 = ShikakuShogohyoKeikokuShubetsu.toValue(entity.get種別());
            resultEntity.set警告種別(警告種別.get名称());
        }
        if (null != entity.get事業所番号()) {
            resultEntity.set事業者番号(entity.get事業所番号().getColumnValue());
        }
        resultEntity.set事業者名(entity.get事業所名());
        if (null != entity.get要介護区分コード()) {
            resultEntity.set要介護区分コード(entity.get要介護区分コード().getColumnValue());
            if (null != entity.getサービス提供年月()) {
                IYokaigoJotaiKubun 要介護区分 = YokaigoJotaiKubunSupport.toValue(entity.getサービス提供年月(),
                        entity.get要介護区分コード().getColumnValue());
                resultEntity.set要介護度(要介護区分.getName());
            }
        }
        set有効期間(entity, resultEntity);
        set費用と区分(entity, resultEntity);
        if (市町村セキュリティ.get導入形態コード().is広域()) {
            if (null != entity.get証記載保険者番号()) {
                resultEntity.set証記載保険者番号(entity.get証記載保険者番号().getColumnValue());
            } else {
                resultEntity.set証記載保険者番号(RString.EMPTY);
            }
        }
        return resultEntity;
    }

    private void set有効期間(SogojigyohiShikakuShogohyoInEntity entity, SogojigyohiShikakuShogohyoInCsvEntity resultEntity) {
        if (null != entity.get認定有効期間_開始年月日()) {
            resultEntity.set認定有効期間_開始(entity.get認定有効期間_開始年月日().wareki().separator(Separator.PERIOD)
                    .fillType(FillType.BLANK).toDateString());
        }
        if (null != entity.get認定有効期間_終了年月日()) {
            resultEntity.set認定有効期間_終了(entity.get認定有効期間_終了年月日().wareki().separator(Separator.PERIOD)
                    .fillType(FillType.BLANK).toDateString());
        }
        if (null != entity.get限度額適用期間_開始年月日()) {
            resultEntity.set限度額適用期間_開始(entity.get限度額適用期間_開始年月日().wareki().separator(Separator.PERIOD)
                    .fillType(FillType.BLANK).toDateString());
        }
        if (null != entity.get限度額適用期間_終了年月日()) {
            resultEntity.set限度額適用期間_終了(entity.get限度額適用期間_終了年月日().wareki().separator(Separator.PERIOD)
                    .fillType(FillType.BLANK).toDateString());
        }
    }

    private void set費用と区分(SogojigyohiShikakuShogohyoInEntity entity, SogojigyohiShikakuShogohyoInCsvEntity resultEntity) {
        resultEntity.set支給限度額(doカンマ編集(entity.get支給限度額()));
        if (null != entity.get居宅サービス計画作成区分コード()) {
            resultEntity.set居宅サービス計画作成区分コード(entity.get居宅サービス計画作成区分コード().getColumnValue());
            if (!entity.get居宅サービス計画作成区分コード().isEmpty()) {
                JukyushaIF_KeikakuSakuseiKubunCode 計画作成区分 = JukyushaIF_KeikakuSakuseiKubunCode
                        .toValue(entity.get居宅サービス計画作成区分コード().getColumnValue());
                resultEntity.set居宅サービス計画作成区分(計画作成区分.get名称());
            }
        }
        if (null != entity.get支援事業所番号()) {
            resultEntity.set支援事業者番号(entity.get支援事業所番号().getColumnValue());
        }
        if (null != entity.get単位数単価()) {
            resultEntity.set単位数単価(DecimalFormatter.toRString(entity.get単位数単価().divide(DIVIDE_100), 小数点));
        }
        resultEntity.set保険給付率(do給付率編集(entity.get保険給付率()));
        resultEntity.set公費1給付率(do給付率編集(entity.get公費１給付率()));
        resultEntity.set公費2給付率(do給付率編集(entity.get公費２給付率()));
        resultEntity.set公費3給付率(do給付率編集(entity.get公費３給付率()));
        resultEntity.setサービス日数_回数(doカンマ編集(new Decimal(entity.getサービス日数_回数())));
        resultEntity.setサービス単位数(doカンマ編集(entity.getサービス単位数()));
        resultEntity.set利用者負担額(doカンマ編集(entity.get利用者負担額()));
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

    private RString do給付率編集(HokenKyufuRitsu number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toRString(number.getColumnValue(), 0);
    }
}
