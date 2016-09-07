/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.source.futanwariaisho.FutanWariaiShoSource;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiMeisai;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.definition.core.futanwariai.FutanwariaiKubun;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 帳票設計_DBC100065_負担割合証Editor
 *
 * @reamsid_L DBC-5010-030 surun
 */
public class FutanWariaiShoEditor implements IFutanWariaiShoEditor {

    private final FutanWariaiShoDivParameter entity;
    private final NinshoshaSource 認証者ソースデータ;
    private final HihokenshaNo 被保険者番号;
    private final EditedKojin 編集後個人;
    private final List<RiyoshaFutanWariaiMeisai> 利用者負担割合明細List;
    private final HokenshaNo 保険者コード取得;
    private final RString flag;
    private final List<IKojin> 個人List;
    private static final RString 照会画面 = new RString("1");
    private static final RString 更新結果確認画面 = new RString("2");
    private static final RString 定数_交付年月日 = new RString("交付年月日　");
    private static final RString 定数_開始年月日 = new RString("開始年月日　");
    private static final RString 定数_終了年月日 = new RString("終了年月日　");
    private static final RString 定数_ONE = new RString("1");
    private static final int INDEX_ZERO = 0;
    private static final int INDEX_ONE = 1;
    private static final int INDEX_TWO = 2;
    private static final int INDEX_THREE = 3;
    private static final int INDEX_FOUR = 4;
    private static final int INDEX_FIVE = 5;
    private static final int INDEX_SIX = 6;

    /**
     * コンストラクタです。
     *
     * @param entity FutanWariaiShoDivParameter
     * @param 認証者ソースデータ NinshoshaSource
     * @param 被保険者番号 HihokenshaNo
     * @param 編集後個人 EditedKojin
     * @param 利用者負担割合明細List List<RiyoshaFutanWariaiMeisai>
     * @param 保険者コード取得 HokenshaNo
     * @param flag RString
     * @param 個人List List<IKojin>
     */
    public FutanWariaiShoEditor(FutanWariaiShoDivParameter entity, NinshoshaSource 認証者ソースデータ, HihokenshaNo 被保険者番号,
            EditedKojin 編集後個人, List<RiyoshaFutanWariaiMeisai> 利用者負担割合明細List, HokenshaNo 保険者コード取得,
            RString flag, List<IKojin> 個人List) {
        this.entity = entity;
        this.認証者ソースデータ = 認証者ソースデータ;
        this.被保険者番号 = 被保険者番号;
        this.編集後個人 = 編集後個人;
        this.利用者負担割合明細List = 利用者負担割合明細List;
        this.保険者コード取得 = 保険者コード取得;
        this.flag = flag;
        this.個人List = 個人List;
    }

    @Override
    public FutanWariaiShoSource edit(FutanWariaiShoSource source) {
        if (entity != null && entity.get交付年月日() != null) {
            source.kofuYmd = 定数_交付年月日.concat(entity.get交付年月日().wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }
        if (照会画面.equals(flag)) {
            set照会画面(source);
        } else if (更新結果確認画面.equals(flag)) {
            set更新結果確認画面(source);
        }
        if (保険者コード取得 != null && 保険者コード取得.getColumnValue().length() >= INDEX_ONE) {
            source.hokenshaCode1 = 保険者コード取得.getColumnValue().substring(INDEX_ZERO, INDEX_ONE);
        }
        if (保険者コード取得 != null && 保険者コード取得.getColumnValue().length() >= INDEX_TWO) {
            source.hokenshaCode2 = 保険者コード取得.getColumnValue().substring(INDEX_ONE, INDEX_TWO);
        }
        if (保険者コード取得 != null && 保険者コード取得.getColumnValue().length() >= INDEX_THREE) {
            source.hokenshaCode3 = 保険者コード取得.getColumnValue().substring(INDEX_TWO, INDEX_THREE);
        }
        if (保険者コード取得 != null && 保険者コード取得.getColumnValue().length() >= INDEX_FOUR) {
            source.hokenshaCode4 = 保険者コード取得.getColumnValue().substring(INDEX_THREE, INDEX_FOUR);
        }
        if (保険者コード取得 != null && 保険者コード取得.getColumnValue().length() >= INDEX_FIVE) {
            source.hokenshaCode5 = 保険者コード取得.getColumnValue().substring(INDEX_FOUR, INDEX_FIVE);
        }
        if (保険者コード取得 != null && 保険者コード取得.getColumnValue().length() >= INDEX_SIX) {
            source.hokenshaCode6 = 保険者コード取得.getColumnValue().substring(INDEX_FIVE, INDEX_SIX);
        }
        source.hokenshaJusho = DbBusinessConfig.get(ConfigNameDBU.保険者情報_住所,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        source.ninshosha_ninshoshaShimeiKakenai = 認証者ソースデータ.ninshoshaShimeiKakenai;
        source.tel = DbBusinessConfig.get(ConfigNameDBU.保険者情報_電話番号,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        source.ninshosha_denshiKoin = 認証者ソースデータ.denshiKoin;
        source.renban = 定数_ONE;
        source.ocrRenban = 定数_ONE;
        return source;
    }

    private void set照会画面(FutanWariaiShoSource source) {
        if (entity != null) {
            source.hihokenshaNo = entity.get被保険者番号();
            source.jusho = entity.get住所();
            source.kanaMei = entity.getカナ氏名();
            source.shimei = entity.get氏名();
        }
        set日本人外国人(source);
        if (entity != null) {
            source.seibetsu = entity.get性別();
        }
        if (利用者負担割合明細List != null && !利用者負担割合明細List.isEmpty()) {
            set利用者負担割合(source);
        }
    }

    private void set日本人外国人(FutanWariaiShoSource source) {
        if (個人List != null && !個人List.isEmpty()) {
            //TODO
            IKojin 個人 = 個人List.get(INDEX_ZERO);
            if (個人.is日本人()) {
                source.umareYmd = entity.get生年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                        fillType(FillType.BLANK).toDateString();
            } else {
                source.umareYmd = entity.get生年月日().seireki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
        }
    }

    private void set利用者負担割合(FutanWariaiShoSource source) {
        int size = 利用者負担割合明細List.size();
        if (size == INDEX_ONE) {
            RString 負担割合区分1 = 利用者負担割合明細List.get(INDEX_ZERO).get負担割合区分();
            source.futanWariai1 = FutanwariaiKubun.toValue(負担割合区分1).get名称();
            FlexibleDate 有効開始日1 = 利用者負担割合明細List.get(INDEX_ZERO).get有効開始日();
            if (有効開始日1 != null) {
                source.tekiyoKaishiYmd1 = 定数_開始年月日.concat(有効開始日1.wareki().eraType(EraType.KANJI).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            }
            FlexibleDate 有効終了日1 = 利用者負担割合明細List.get(INDEX_ZERO).get有効終了日();
            if (有効終了日1 != null) {
                source.tekiyoShuryoYmd1 = 定数_終了年月日.concat(有効終了日1.wareki().eraType(EraType.KANJI).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            }
            source.futanWariai2 = RString.EMPTY;
            source.tekiyoKaishiYmd2 = RString.EMPTY;
            source.tekiyoShuryoYmd2 = RString.EMPTY;

        } else if (size > INDEX_TWO) {
            RString 負担割合区分1 = 利用者負担割合明細List.get(size - INDEX_TWO).get負担割合区分();
            if (負担割合区分1 != null) {
                source.futanWariai1 = FutanwariaiKubun.toValue(負担割合区分1).get名称();
            }
            FlexibleDate 有効開始日1 = 利用者負担割合明細List.get(size - INDEX_TWO).get有効開始日();
            if (有効開始日1 != null) {
                source.tekiyoKaishiYmd1 = 定数_開始年月日.concat(有効開始日1.wareki().eraType(EraType.KANJI).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            }
            FlexibleDate 有効終了日1 = 利用者負担割合明細List.get(size - INDEX_TWO).get有効終了日();
            if (有効終了日1 != null) {
                source.tekiyoShuryoYmd1 = 定数_終了年月日.concat(有効終了日1.wareki().eraType(EraType.KANJI).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            }
            RString 負担割合区分2 = 利用者負担割合明細List.get(size - INDEX_ONE).get負担割合区分();
            if (負担割合区分2 != null) {
                source.futanWariai2 = FutanwariaiKubun.toValue(負担割合区分2).get名称();
            }
            FlexibleDate 有効開始日2 = 利用者負担割合明細List.get(size - INDEX_ONE).get有効開始日();
            if (有効開始日2 != null) {
                source.tekiyoKaishiYmd2 = 定数_開始年月日.concat(有効開始日2.wareki().eraType(EraType.KANJI).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            }
            FlexibleDate 有効終了日2 = 利用者負担割合明細List.get(size - INDEX_ONE).get有効終了日();
            if (有効終了日2 != null) {
                source.tekiyoShuryoYmd2 = 定数_終了年月日.concat(有効終了日2.wareki().eraType(EraType.KANJI).
                        firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            }
        }
    }

    private void set更新結果確認画面(FutanWariaiShoSource source) {
        if (被保険者番号 != null) {
            source.hihokenshaNo = 被保険者番号.getColumnValue();
        }
        if (編集後個人 != null) {
            source.jusho = 編集後個人.get編集後住所();
            source.kanaMei = 編集後個人.get名称().getName().getColumnValue();
            source.shimei = 編集後個人.get名称().getName().getColumnValue();
            source.umareYmd = 編集後個人.get生年月日For帳票();
            source.seibetsu = 編集後個人.get性別();
        }
        if (entity != null) {
            source.futanWariai1 = entity.get負担割合上段();
        }
        if (entity != null && entity.get適用期間開始日上段() != null) {
            source.tekiyoKaishiYmd1 = new RString(entity.get適用期間開始日上段().toString());
        }
        if (entity != null && entity.get適用期間終了日上段() != null) {
            source.tekiyoShuryoYmd1 = new RString(entity.get適用期間終了日上段().toString());
        }
        if (entity != null) {
            source.futanWariai2 = entity.get負担割合下段();
        }
        if (entity != null && entity.get適用期間開始日下段() != null) {
            source.tekiyoKaishiYmd2 = new RString(entity.get適用期間開始日下段().toString());
        }
        if (entity != null && entity.get適用期間終了日下段() != null) {
            source.tekiyoShuryoYmd2 = new RString(entity.get適用期間終了日下段().toString());
        }
    }

}
