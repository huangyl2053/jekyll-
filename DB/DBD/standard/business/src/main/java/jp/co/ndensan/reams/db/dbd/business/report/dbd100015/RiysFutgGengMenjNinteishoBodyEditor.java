/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100015;

import jp.co.ndensan.reams.db.dbd.business.report.hanyo.HokenshaNameOutput;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100015.RiysFutgGengMenjNinteishoReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 利用者負担額減額・免除等認定証ボディEditorです。
 *
 * @reamsid_L DBD-3540-060 wangchao
 */
public class RiysFutgGengMenjNinteishoBodyEditor implements IRiysFutgGengMenjNinteishoEditor {

    private final RString ホシ = new RString("＊");
    private final static int INDEX_0 = 0;
    private final static int INDEX_1 = 1;
    private final static int INDEX_2 = 2;
    private final static int INDEX_3 = 3;
    private final static int INDEX_4 = 4;
    private final static int INDEX_5 = 5;
    private final static int INDEX_6 = 6;
    private final static int INDEX_7 = 7;
    private final static int INDEX_9 = 9;
    private final RiysFutgGengMenjNinteishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 利用者負担額減額・免除等認定証
     */
    public RiysFutgGengMenjNinteishoBodyEditor(RiysFutgGengMenjNinteishoItem item) {
        this.item = item;
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
        source.kofuGengo = item.get交付日().wareki().toDateString().substring(INDEX_0, INDEX_1);
        source.kofuYYYY = item.get交付日().wareki().toDateString().substring(INDEX_1, INDEX_3);
        source.kofuMM = item.get交付日().wareki().toDateString().substring(INDEX_4, INDEX_6);
        source.kofuDD = item.get交付日().wareki().toDateString().substring(INDEX_7, INDEX_9);
        source.hihokenshaNo = item.get利用者負担額減額情報().get被保険者番号().getColumnValue();

        EditedKojin 編集後個人 = getEditedKojin(item.getIKojin(), item.get帳票制御共通());
        source.jusho = 編集後個人.get編集後住所();
        source.hihokenshaNameKana = new RString(編集後個人.get名称().getKana().toString());
        source.hihokenshaName = new RString(編集後個人.get名称().getName().toString());

        RString 元号 = item.getIKojin().get生年月日().toFlexibleDate().wareki().toDateString().substring(INDEX_0, INDEX_1);
        if (item.getIKojin().is日本人()) {
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
            }
            source.birthYYYY = item.getIKojin().get生年月日().toFlexibleDate().wareki().toDateString().substring(INDEX_1, INDEX_3);
            source.birthMM = item.getIKojin().get生年月日().toFlexibleDate().wareki().toDateString().substring(INDEX_4, INDEX_6);
            source.birthDD = item.getIKojin().get生年月日().toFlexibleDate().wareki().toDateString().substring(INDEX_7, INDEX_9);
        } else {
            source.birthGengoMeiji = ホシ;
            source.birthGengoTaisho = ホシ;
            source.birthGengoShowa = ホシ;
            RString 生年月日 = item.getIKojin().get生年月日().toFlexibleDate().wareki().eraType(EraType.KANJI_RYAKU).firstYear(
                    FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            source.birthYYYY = 生年月日.substring(INDEX_1, INDEX_3);
            source.birthMM = 生年月日.substring(INDEX_4, INDEX_6);
            source.birthDD = 生年月日.substring(INDEX_7, INDEX_9);
        }

        if (Gender.MALE.equals(item.getIKojin().get性別())) {
            source.man = RString.EMPTY;
            source.woman = ホシ;
        } else {
            source.man = ホシ;
            source.woman = RString.EMPTY;
        }

        source.tekiyoGengo = item.get利用者負担額減額情報().get適用開始年月日().wareki().toDateString().substring(INDEX_0, INDEX_1);
        source.tekiyoYYYY = item.get利用者負担額減額情報().get適用開始年月日().wareki().toDateString().substring(INDEX_1, INDEX_3);
        source.tekiyoMM = item.get利用者負担額減額情報().get適用開始年月日().wareki().toDateString().substring(INDEX_4, INDEX_6);
        source.tekiyoDD = item.get利用者負担額減額情報().get適用開始年月日().wareki().toDateString().substring(INDEX_7, INDEX_9);
        source.yukoGengo = item.get利用者負担額減額情報().get適用終了年月日().wareki().toDateString().substring(INDEX_0, INDEX_1);
        source.yukoYYYY = item.get利用者負担額減額情報().get適用終了年月日().wareki().toDateString().substring(INDEX_1, INDEX_3);
        source.yukoMM = item.get利用者負担額減額情報().get適用終了年月日().wareki().toDateString().substring(INDEX_4, INDEX_6);
        source.yukoDD = item.get利用者負担額減額情報().get適用終了年月日().wareki().toDateString().substring(INDEX_7, INDEX_9);

        source.kyufuRitsu = new RString(item.get利用者負担額減額情報().get給付率().toString());

        source.hokenshaNo1 = item.get利用者負担額減額情報().get被保険者番号().getColumnValue().substring(INDEX_0, INDEX_1);
        source.hokenshaNo2 = item.get利用者負担額減額情報().get被保険者番号().getColumnValue().substring(INDEX_1, INDEX_2);
        source.hokenshaNo3 = item.get利用者負担額減額情報().get被保険者番号().getColumnValue().substring(INDEX_2, INDEX_3);
        source.hokenshaNo4 = item.get利用者負担額減額情報().get被保険者番号().getColumnValue().substring(INDEX_3, INDEX_4);
        source.hokenshaNo5 = item.get利用者負担額減額情報().get被保険者番号().getColumnValue().substring(INDEX_4, INDEX_5);
        source.hokenshaNo6 = item.get利用者負担額減額情報().get被保険者番号().getColumnValue().substring(INDEX_5, INDEX_6);

        for (DbT7067ChohyoSeigyoHanyoEntity entity : item.get帳票制御汎用List()) {
            if (new RString(ChohyoSeigyoHanyoKeysDBD100015.保険者名表示.name()).equals(entity.getKomokuName())
                    && HokenshaNameOutput.印字する.getコード().equals(entity.getKomokuValue())) {
                source.hokenshaJusho = DbBusinessConfig.get(ConfigNameDBU.保険者情報_住所, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
                source.hokenshaName1 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
                source.hokenshaTelNo = DbBusinessConfig.get(ConfigNameDBU.保険者情報_電話番号, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
                source.denshiKoin = item.getNinshoshaSource().denshiKoin;
                break;
            }
        }

        source.shikibetsuCode = item.getIKojin().get識別コード().getColumnValue();
        source.hihokenshaNo = item.get利用者負担額減額情報().get被保険者番号().getColumnValue();
        return source;
    }

    private static EditedKojin getEditedKojin(IKojin kojin, ChohyoSeigyoKyotsu 帳票制御共通) {
        return new EditedKojin(kojin, 帳票制御共通);
    }
}
