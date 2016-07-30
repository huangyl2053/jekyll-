/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100015;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.report.hanyo.HokenshaNameOutput;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100015.RiysFutgGengMenjNinteishoReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用者負担額減額・免除等認定証ボディEditorです。
 *
 * @reamsid_L DBD-3540-060 wangchao
 */
public class RiysFutgGengMenjNinteishoBodyEditor implements IRiysFutgGengMenjNinteishoEditor {

    private final RString ホシ = new RString("＊");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private static final int INDEX_10 = 10;

    private final RiyoshaFutangakuGengaku 利用者負担額減額情報;
    private final IKojin iKojin;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用List;
    private final Association 地方公共団体;
    private final RDate 交付日;
    private final NinshoshaSource ninshoshaSource;

    /**
     * インスタンスを生成します。
     *
     * @param 利用者負担額減額情報 利用者負担額減額情報
     * @param iKojin iKojin
     * @param 帳票制御共通 帳票制御共通
     * @param 帳票制御汎用List 帳票制御汎用List
     * @param 地方公共団体 地方公共団体
     * @param 交付日 交付日
     * @param ninshoshaSource NinshoshaSource
     */
    public RiysFutgGengMenjNinteishoBodyEditor(RiyoshaFutangakuGengaku 利用者負担額減額情報, IKojin iKojin,
            ChohyoSeigyoKyotsu 帳票制御共通, List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用List, Association 地方公共団体,
            RDate 交付日, NinshoshaSource ninshoshaSource) {
        this.利用者負担額減額情報 = 利用者負担額減額情報;
        this.iKojin = iKojin;
        this.帳票制御共通 = 帳票制御共通;
        this.帳票制御汎用List = 帳票制御汎用List;
        this.地方公共団体 = 地方公共団体;
        this.交付日 = 交付日;
        this.ninshoshaSource = ninshoshaSource;
    }

    /**
     * 利用者負担額減額・免除等認定証ボディEditorです。
     *
     * @param source 利用者負担額減額・免除等認定証Source
     * @return 利用者負担額減額・免除等認定証Source
     */
    @Override
    public RiysFutgGengMenjNinteishoReportSource edit(RiysFutgGengMenjNinteishoReportSource source) {
        return bodyEdit(source);
    }

    private RiysFutgGengMenjNinteishoReportSource bodyEdit(RiysFutgGengMenjNinteishoReportSource source) {
        source.kofuGengo = setWareki(交付日).substring(INDEX_0, INDEX_2);
        source.kofuYYYY = setWareki(交付日).substring(INDEX_2, INDEX_4);
        source.kofuMM = setWareki(交付日).substring(INDEX_5, INDEX_7);
        source.kofuDD = setWareki(交付日).substring(INDEX_8, INDEX_10);
        source.hihokenshaNo = 利用者負担額減額情報.get被保険者番号().getColumnValue();

        EditedKojin 編集後個人 = getEditedKojin(iKojin, 帳票制御共通, 地方公共団体);
        source.jusho = 編集後個人.get編集後住所();
        source.hihokenshaNameKana = new RString(編集後個人.get名称().getKana().toString());
        source.hihokenshaName = new RString(編集後個人.get名称().getName().toString());

        RString 元号 = setWareki(iKojin.get生年月日().toFlexibleDate().toRDate()).substring(INDEX_0, INDEX_2);
        if (iKojin.is日本人()) {
            if (new RString("明治").equals(元号)) {
                source.birthGengoMeiji = RString.EMPTY;
                source.birthGengoTaisho = ホシ;
                source.birthGengoShowa = ホシ;
            } else if (new RString("大正").equals(元号)) {
                source.birthGengoTaisho = RString.EMPTY;
                source.birthGengoMeiji = ホシ;
                source.birthGengoShowa = ホシ;
            } else if (new RString("昭和").equals(元号)) {
                source.birthGengoShowa = RString.EMPTY;
                source.birthGengoMeiji = ホシ;
                source.birthGengoTaisho = ホシ;
            } else {
                source.birthGengoMeiji = ホシ;
                source.birthGengoTaisho = ホシ;
                source.birthGengoShowa = ホシ;
            }
            source.birthYYYY = setWareki(iKojin.get生年月日().toFlexibleDate().toRDate()).substring(INDEX_2, INDEX_4);
            source.birthMM = setWareki(iKojin.get生年月日().toFlexibleDate().toRDate()).substring(INDEX_5, INDEX_7);
            source.birthDD = setWareki(iKojin.get生年月日().toFlexibleDate().toRDate()).substring(INDEX_8, INDEX_10);
        } else {
            source.birthGengoMeiji = ホシ;
            source.birthGengoTaisho = ホシ;
            source.birthGengoShowa = ホシ;
            RString 生年月日 = iKojin.get生年月日().toFlexibleDate().seireki().toDateString();
            source.birthYYYY = 生年月日.substring(INDEX_0, INDEX_4);
            source.birthMM = 生年月日.substring(INDEX_5, INDEX_7);
            source.birthDD = 生年月日.substring(INDEX_8, INDEX_10);
        }

        if (Gender.MALE.equals(iKojin.get性別())) {
            source.man = RString.EMPTY;
            source.woman = ホシ;
        } else {
            source.man = ホシ;
            source.woman = RString.EMPTY;
        }

        source.tekiyoGengo = setWareki(利用者負担額減額情報.get適用開始年月日().toRDate()).substring(INDEX_0, INDEX_2);
        source.tekiyoYYYY = setWareki(利用者負担額減額情報.get適用開始年月日().toRDate()).substring(INDEX_2, INDEX_4);
        source.tekiyoMM = setWareki(利用者負担額減額情報.get適用開始年月日().toRDate()).substring(INDEX_5, INDEX_7);
        source.tekiyoDD = setWareki(利用者負担額減額情報.get適用開始年月日().toRDate()).substring(INDEX_8, INDEX_10);
        source.yukoGengo = setWareki(利用者負担額減額情報.get適用終了年月日().toRDate()).substring(INDEX_0, INDEX_2);
        source.yukoYYYY = setWareki(利用者負担額減額情報.get適用終了年月日().toRDate()).substring(INDEX_2, INDEX_4);
        source.yukoMM = setWareki(利用者負担額減額情報.get適用終了年月日().toRDate()).substring(INDEX_5, INDEX_7);
        source.yukoDD = setWareki(利用者負担額減額情報.get適用終了年月日().toRDate()).substring(INDEX_8, INDEX_10);

        source.kyufuRitsu = new RString(利用者負担額減額情報.get給付率().getColumnValue().toString());

        source.hokenshaNo1 = 利用者負担額減額情報.get証記載保険者番号().getColumnValue().substring(INDEX_0, INDEX_1);
        source.hokenshaNo2 = 利用者負担額減額情報.get証記載保険者番号().getColumnValue().substring(INDEX_1, INDEX_2);
        source.hokenshaNo3 = 利用者負担額減額情報.get証記載保険者番号().getColumnValue().substring(INDEX_2, INDEX_3);
        source.hokenshaNo4 = 利用者負担額減額情報.get証記載保険者番号().getColumnValue().substring(INDEX_3, INDEX_4);
        source.hokenshaNo5 = 利用者負担額減額情報.get証記載保険者番号().getColumnValue().substring(INDEX_4, INDEX_5);
        source.hokenshaNo6 = 利用者負担額減額情報.get証記載保険者番号().getColumnValue().substring(INDEX_5, INDEX_6);

        for (DbT7067ChohyoSeigyoHanyoEntity entity : 帳票制御汎用List) {
            if (new RString(ChohyoSeigyoHanyoKeysDBD100015.保険者名表示.name()).equals(entity.getKomokuName())
                    && HokenshaNameOutput.印字する.getコード().equals(entity.getKomokuValue())) {
                source.hokenshaJusho = DbBusinessConfig.get(ConfigNameDBU.保険者情報_住所, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
                source.hokenshaName1 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
                source.hokenshaTelNo = DbBusinessConfig.get(ConfigNameDBU.保険者情報_電話番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
                source.denshiKoin = ninshoshaSource.denshiKoin;
                break;
            }
        }

        source.shikibetsuCode = iKojin.get識別コード().getColumnValue();
        source.hihokenshaNo = 利用者負担額減額情報.get被保険者番号().getColumnValue();
        return source;
    }

    private static EditedKojin getEditedKojin(IKojin kojin, ChohyoSeigyoKyotsu 帳票制御共通, Association 地方公共団体) {
        return new EditedKojin(kojin, 帳票制御共通, 地方公共団体);
    }

    private RString setWareki(RDate 日付) {
        return 日付.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
    }
}
