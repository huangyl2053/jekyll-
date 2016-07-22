/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100017;

import jp.co.ndensan.reams.db.dbd.business.report.hanyo.HokenshaNameOutput;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100017.HomKaigRiysFutgGengNinteishoReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 訪問介護等利用者負担額減額認定証ボディEditorです。
 *
 * @reamsid_L DBD-3540-080 wangchao
 */
public class HomKaigRiysFutgGengNinteishoBodyEditor implements IHomKaigRiysFutgGengNinteishoEditor {

    private final RString ホシ = new RString("＊");
    private final static int INDEX_0 = 0;
    private final static int INDEX_1 = 1;
    private final static int INDEX_2 = 2;
    private final static int INDEX_3 = 3;
    private final static int INDEX_4 = 4;
    private final static int INDEX_5 = 5;
    private final static int INDEX_6 = 6;
    private final static int INDEX_7 = 7;
    private final static int INDEX_8 = 8;
    private final static int INDEX_9 = 9;
    private final HomKaigRiysFutgGengNinteishoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 訪問介護等利用者負担額減額認定証
     */
    public HomKaigRiysFutgGengNinteishoBodyEditor(HomKaigRiysFutgGengNinteishoItem item) {
        this.item = item;
    }

    /**
     * 訪問介護等利用者負担額減額認定証ボディEditorです。
     *
     * @param source 訪問介護等利用者負担額減額認定証Source
     * @return 訪問介護等利用者負担額減額認定証Source
     */
    @Override
    public HomKaigRiysFutgGengNinteishoReportSource edit(HomKaigRiysFutgGengNinteishoReportSource source) {
        return bodyEdit(source);
    }

    private HomKaigRiysFutgGengNinteishoReportSource bodyEdit(HomKaigRiysFutgGengNinteishoReportSource source) {
        source.kofuGengo = item.get交付日().wareki().toDateString().substring(INDEX_0, INDEX_1);
        source.kofuYYYY = item.get交付日().wareki().toDateString().substring(INDEX_1, INDEX_3);
        source.kofuMM = item.get交付日().wareki().toDateString().substring(INDEX_4, INDEX_6);
        source.kofuDD = item.get交付日().wareki().toDateString().substring(INDEX_7, INDEX_9);

        source.futanNo1 = item.get訪問介護利用者負担額減額().get公費負担者番号().substring(INDEX_0, INDEX_1);
        source.futanNo2 = item.get訪問介護利用者負担額減額().get公費負担者番号().substring(INDEX_1, INDEX_2);
        source.futanNo3 = item.get訪問介護利用者負担額減額().get公費負担者番号().substring(INDEX_2, INDEX_3);
        source.futanNo4 = item.get訪問介護利用者負担額減額().get公費負担者番号().substring(INDEX_3, INDEX_4);
        source.futanNo5 = item.get訪問介護利用者負担額減額().get公費負担者番号().substring(INDEX_4, INDEX_5);
        source.futanNo6 = item.get訪問介護利用者負担額減額().get公費負担者番号().substring(INDEX_5, INDEX_6);
        source.futanNo7 = item.get訪問介護利用者負担額減額().get公費負担者番号().substring(INDEX_6, INDEX_7);
        source.futanNo8 = item.get訪問介護利用者負担額減額().get公費負担者番号().substring(INDEX_7, INDEX_8);

        source.jukyuNo1 = item.get訪問介護利用者負担額減額().get公費受給者番号().substring(INDEX_0, INDEX_1);
        source.jukyuNo2 = item.get訪問介護利用者負担額減額().get公費受給者番号().substring(INDEX_1, INDEX_2);
        source.jukyuNo3 = item.get訪問介護利用者負担額減額().get公費受給者番号().substring(INDEX_2, INDEX_3);
        source.jukyuNo4 = item.get訪問介護利用者負担額減額().get公費受給者番号().substring(INDEX_3, INDEX_4);
        source.jukyuNo5 = item.get訪問介護利用者負担額減額().get公費受給者番号().substring(INDEX_4, INDEX_5);
        source.jukyuNo6 = item.get訪問介護利用者負担額減額().get公費受給者番号().substring(INDEX_5, INDEX_6);
        source.jukyuNo7 = item.get訪問介護利用者負担額減額().get公費受給者番号().substring(INDEX_6, INDEX_7);

        EditedKojin 編集後個人 = getEditedKojin(item.getIKojin(), item.get帳票制御共通(), item.get地方公共団体());
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

        source.kyufuRitsu = new RString(item.get訪問介護利用者負担額減額().get給付率().toString());

        for (DbT7067ChohyoSeigyoHanyoEntity entity : item.get帳票制御汎用List()) {
            if (new RString(ChohyoSeigyoHanyoKeysDBD100017.保険者名表示.name()).equals(entity.getKomokuName())
                    && HokenshaNameOutput.印字する.getコード().equals(entity.getKomokuValue())) {
                source.hokenshaJusho = DbBusinessConfig.get(ConfigNameDBU.保険者情報_住所, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
                source.hokenshaName1 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
                source.hokenshaTelNo = DbBusinessConfig.get(ConfigNameDBU.保険者情報_電話番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
                source.denshiKoin = item.getNinshoshaSource().denshiKoin;
                break;
            }
        }

        source.shikibetsuCode = item.getIKojin().get識別コード().getColumnValue();
        source.hihokenshaNo = item.get訪問介護利用者負担額減額().get被保険者番号().getColumnValue();

        return source;

    }

    private static EditedKojin getEditedKojin(IKojin kojin, ChohyoSeigyoKyotsu 帳票制御共通, Association 地方公共団体) {
        return new EditedKojin(kojin, 帳票制御共通, 地方公共団体);
    }
}
