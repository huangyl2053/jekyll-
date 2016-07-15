/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100018;

import jp.co.ndensan.reams.db.dbd.business.report.hanyo.HokenshaNameOutput;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100018.ShakfukusRiysFutKeigTaisKakuninshoReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 社会福祉法人等利用者負担軽減対象確認証ボディEditorです。
 *
 * @reamsid_L DBD-3540-100 wangchao
 */
public class ShakfukusRiysFutKeigTaisKakuninshoBodyEditor implements IShakfukusRiysFutKeigTaisKakuninshoEditor {

    private final RString ホシ = new RString("＊");

    private final ShakfukusRiysFutKeigTaisKakuninshoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item 社会福祉法人等利用者負担軽減対象確認証
     */
    public ShakfukusRiysFutKeigTaisKakuninshoBodyEditor(ShakfukusRiysFutKeigTaisKakuninshoItem item) {
        this.item = item;
    }

    /**
     * 社会福祉法人等利用者負担軽減対象確認証ボディEditorです。
     *
     * @param source 社会福祉法人等利用者負担軽減対象確認証Source
     * @return 社会福祉法人等利用者負担軽減対象確認証Source
     */
    @Override
    public ShakfukusRiysFutKeigTaisKakuninshoReportSource edit(ShakfukusRiysFutKeigTaisKakuninshoReportSource source) {
        return bodyEdit(source);
    }

    private ShakfukusRiysFutKeigTaisKakuninshoReportSource bodyEdit(ShakfukusRiysFutKeigTaisKakuninshoReportSource source) {
        source.kofuGengo = item.get交付日().wareki().toDateString().substring(1, 2);
        source.kofuYYYY = item.get交付日().wareki().toDateString().substring(2, 4);
        source.kofuMM = item.get交付日().wareki().toDateString().substring(5, 7);
        source.kofuDD = item.get交付日().wareki().toDateString().substring(8, 10);

        EditedKojin 編集後個人 = getEditedKojin(item.getIKojin(), item.get帳票制御共通());
        source.jusho = 編集後個人.get編集後住所();
        source.hihokenshaNameKana = new RString(編集後個人.get名称().getKana().toString());
        source.hihokenshaName = new RString(編集後個人.get名称().getName().toString());

        RString 元号 = item.getIKojin().get生年月日().toFlexibleDate().wareki().toDateString().substring(1, 2);
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
            source.birthYYYY = item.getIKojin().get生年月日().toFlexibleDate().wareki().toDateString().substring(2, 4);
            source.birthMM = item.getIKojin().get生年月日().toFlexibleDate().wareki().toDateString().substring(5, 7);
            source.birthDD = item.getIKojin().get生年月日().toFlexibleDate().wareki().toDateString().substring(8, 10);
        } else {
            source.birthGengoMeiji = ホシ;
            source.birthGengoTaisho = ホシ;
            source.birthGengoShowa = ホシ;
            RString 生年月日 = item.getIKojin().get生年月日().toFlexibleDate().wareki().eraType(EraType.KANJI_RYAKU).firstYear(
                    FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            source.birthYYYY = 生年月日.substring(2, 5);
            source.birthMM = 生年月日.substring(5, 8);
            source.birthDD = 生年月日.substring(8, 11);
        }

        if (Gender.MALE.equals(item.getIKojin().get性別())) {
            source.man = RString.EMPTY;
            source.woman = ホシ;
        } else {
            source.man = ホシ;
            source.woman = RString.EMPTY;
        }

        source.tekiyoGengo = item.get社会福祉法人等利用者負担軽減().get適用開始年月日().wareki().toDateString().substring(1, 2);
        source.tekiyoYYYY = item.get社会福祉法人等利用者負担軽減().get適用開始年月日().wareki().toDateString().substring(2, 4);
        source.tekiyoMM = item.get社会福祉法人等利用者負担軽減().get適用開始年月日().wareki().toDateString().substring(5, 7);
        source.tekiyoDD = item.get社会福祉法人等利用者負担軽減().get適用開始年月日().wareki().toDateString().substring(8, 10);
        source.yukoGengo = item.get社会福祉法人等利用者負担軽減().get適用終了年月日().wareki().toDateString().substring(1, 2);
        source.yukoYYYY = item.get社会福祉法人等利用者負担軽減().get適用終了年月日().wareki().toDateString().substring(2, 4);
        source.yukoMM = item.get社会福祉法人等利用者負担軽減().get適用終了年月日().wareki().toDateString().substring(5, 7);
        source.yukoDD = item.get社会福祉法人等利用者負担軽減().get適用終了年月日().wareki().toDateString().substring(8, 10);

        source.keigenRitsu1 = RString.EMPTY;
        source.keigenRitsu2 = RString.EMPTY;

        source = genmenWariai(source, item);

        for (DbT7067ChohyoSeigyoHanyoEntity entity : item.get帳票制御汎用List()) {
            if (new RString(ChohyoSeigyoHanyoKeysDBD100018.保険者名表示.name()).equals(entity.getKomokuName())
                    && HokenshaNameOutput.印字する.getコード().equals(entity.getKomokuValue())) {
                source.hokenshaJusho = DbBusinessConfig.get(ConfigNameDBU.保険者情報_住所, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
                source.hokenshaName1 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
                source.hokenshaTelNo = DbBusinessConfig.get(ConfigNameDBU.保険者情報_電話番号, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
                source.denshiKoin = getCompNinshosha(item).denshiKoin;
                break;
            }
        }

        source.shikibetsuCode = item.getIKojin().get識別コード().getColumnValue();
        source.hihokenshaNo = item.get社会福祉法人等利用者負担軽減().get被保険者番号().getColumnValue();
        return source;

    }

    private ShakfukusRiysFutKeigTaisKakuninshoReportSource genmenWariai(
            ShakfukusRiysFutKeigTaisKakuninshoReportSource source, ShakfukusRiysFutKeigTaisKakuninshoItem item) {
        source.genmenNaiyo = RString.EMPTY;
        source.genmenRitsu = RString.EMPTY;
        source.keigenRitsu = RString.EMPTY;
        source.genmenNaiyo1 = RString.EMPTY;
        source.genmenNaiyo2 = RString.EMPTY;
        return source;
    }

    private static EditedKojin getEditedKojin(IKojin kojin, ChohyoSeigyoKyotsu 帳票制御共通) {
        return new EditedKojin(kojin, 帳票制御共通);
    }

    private static NinshoshaSource getCompNinshosha(ShakfukusRiysFutKeigTaisKakuninshoItem item) {
        return NinshoshaSourceBuilderFactory.createInstance(
                item.get認証者(), item.get地方公共団体(), item.getイメージファイルパス(), item.get交付日()).buildSource();
    }
}
