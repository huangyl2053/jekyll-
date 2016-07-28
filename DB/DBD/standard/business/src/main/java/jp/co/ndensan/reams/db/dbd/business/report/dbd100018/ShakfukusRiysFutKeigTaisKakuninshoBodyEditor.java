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
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 社会福祉法人等利用者負担軽減対象確認証ボディEditorです。
 *
 * @reamsid_L DBD-3540-100 wangchao
 */
public class ShakfukusRiysFutKeigTaisKakuninshoBodyEditor implements IShakfukusRiysFutKeigTaisKakuninshoEditor {

    private final RString ホシ = new RString("＊");
    private static final int INDEX_0 = 0;
    private static final int INDEX_2 = 2;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private static final int INDEX_10 = 10;
    private final RString 軽減率_100 = new RString("100");

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
        source.kofuGengo = setWareki(item.get交付日()).substring(INDEX_0, INDEX_2);
        source.kofuYYYY = setWareki(item.get交付日()).substring(INDEX_2, INDEX_4);
        source.kofuMM = setWareki(item.get交付日()).substring(INDEX_5, INDEX_7);
        source.kofuDD = setWareki(item.get交付日()).substring(INDEX_8, INDEX_10);
        source.kakuninNo = item.get社会福祉法人等利用者負担軽減().get確認番号();

        EditedKojin 編集後個人 = getEditedKojin(item.getIKojin(), item.get帳票制御共通(), item.get地方公共団体());
        source.jusho = 編集後個人.get編集後住所();
        source.hihokenshaNameKana = new RString(編集後個人.get名称().getKana().toString());
        source.hihokenshaName = new RString(編集後個人.get名称().getName().toString());

        RString 元号 = setWareki(item.getIKojin().get生年月日().toFlexibleDate().toRDate()).substring(INDEX_0, INDEX_2);
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
            } else {
                source.birthGengoMeiji = ホシ;
                source.birthGengoTaisho = ホシ;
                source.birthGengoShowa = ホシ;
            }
            source.birthYYYY = setWareki(item.getIKojin().get生年月日().toFlexibleDate().toRDate()).substring(INDEX_2, INDEX_4);
            source.birthMM = setWareki(item.getIKojin().get生年月日().toFlexibleDate().toRDate()).substring(INDEX_5, INDEX_7);
            source.birthDD = setWareki(item.getIKojin().get生年月日().toFlexibleDate().toRDate()).substring(INDEX_8, INDEX_10);
        } else {
            source.birthGengoMeiji = ホシ;
            source.birthGengoTaisho = ホシ;
            source.birthGengoShowa = ホシ;
            RString 生年月日 = item.getIKojin().get生年月日().toFlexibleDate().seireki().toDateString();
            source.birthYYYY = 生年月日.substring(INDEX_0, INDEX_4);
            source.birthMM = 生年月日.substring(INDEX_5, INDEX_7);
            source.birthDD = 生年月日.substring(INDEX_8, INDEX_10);
        }

        if (Gender.MALE.equals(item.getIKojin().get性別())) {
            source.man = RString.EMPTY;
            source.woman = ホシ;
        } else {
            source.man = ホシ;
            source.woman = RString.EMPTY;
        }

        source.tekiyoGengo = setWareki(item.get社会福祉法人等利用者負担軽減().get適用開始年月日().toRDate()).substring(INDEX_0, INDEX_2);
        source.tekiyoYYYY = setWareki(item.get社会福祉法人等利用者負担軽減().get適用開始年月日().toRDate()).substring(INDEX_2, INDEX_4);
        source.tekiyoMM = setWareki(item.get社会福祉法人等利用者負担軽減().get適用開始年月日().toRDate()).substring(INDEX_5, INDEX_7);
        source.tekiyoDD = setWareki(item.get社会福祉法人等利用者負担軽減().get適用開始年月日().toRDate()).substring(INDEX_8, INDEX_10);
        source.yukoGengo = setWareki(item.get社会福祉法人等利用者負担軽減().get適用終了年月日().toRDate()).substring(INDEX_0, INDEX_2);
        source.yukoYYYY = setWareki(item.get社会福祉法人等利用者負担軽減().get適用終了年月日().toRDate()).substring(INDEX_2, INDEX_4);
        source.yukoMM = setWareki(item.get社会福祉法人等利用者負担軽減().get適用終了年月日().toRDate()).substring(INDEX_5, INDEX_7);
        source.yukoDD = setWareki(item.get社会福祉法人等利用者負担軽減().get適用終了年月日().toRDate()).substring(INDEX_8, INDEX_10);

        source.keigenRitsu1 = RString.EMPTY;
        source.keigenRitsu2 = RString.EMPTY;

        setGenmenWariai(source, item);

        for (DbT7067ChohyoSeigyoHanyoEntity entity : item.get帳票制御汎用List()) {
            if (new RString(ChohyoSeigyoHanyoKeysDBD100018.保険者名表示.name()).equals(entity.getKomokuName())
                    && HokenshaNameOutput.印字する.getコード().equals(entity.getKomokuValue())) {
                source.hokenshaJusho = DbBusinessConfig.get(ConfigNameDBU.保険者情報_住所, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
                source.hokenshaName1 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
                source.hokenshaTelNo = DbBusinessConfig.get(ConfigNameDBU.保険者情報_電話番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
                source.denshiKoin = item.getNinshoshaSource().denshiKoin;
                break;
            }
        }

        source.shikibetsuCode = item.getIKojin().get識別コード().getColumnValue();
        source.hihokenshaNo = item.get社会福祉法人等利用者負担軽減().get被保険者番号().getColumnValue();
        return source;

    }

    private void setGenmenWariai(ShakfukusRiysFutKeigTaisKakuninshoReportSource source, ShakfukusRiysFutKeigTaisKakuninshoItem item) {
        RString 減額割合 = new RString(item.get社会福祉法人等利用者負担軽減().get軽減率_分子().toString()
                .concat("/")
                .concat(item.get社会福祉法人等利用者負担軽減().get軽減率_分母().toString()));
        if (item.get社会福祉法人等利用者負担軽減().is生保扶助見直し特例有無()) {
            source.genmenRitsu = 減額割合;
            for (DbT7067ChohyoSeigyoHanyoEntity entity : item.get帳票制御汎用List()) {
                if (new RString(ChohyoSeigyoHanyoKeysDBD100018.減免内容の制限事項３_５.name()).equals(entity.getKomokuName())) {
                    source.genmenNaiyo1 = entity.getKomokuValue();
                    break;
                }
            }
            source.genmenNaiyo = RString.EMPTY;
            source.keigenRitsu = RString.EMPTY;
            source.genmenNaiyo2 = RString.EMPTY;
        } else if (軽減率_100.equals(new RString(item.get社会福祉法人等利用者負担軽減().get軽減率_分子().toString()))
                && (軽減率_100.equals(new RString(item.get社会福祉法人等利用者負担軽減().get軽減率_分母().toString())))) {
            source.genmenRitsu = 減額割合;
            for (DbT7067ChohyoSeigyoHanyoEntity entity : item.get帳票制御汎用List()) {
                if (new RString(ChohyoSeigyoHanyoKeysDBD100018.減免内容の制限事項３_４.name()).equals(entity.getKomokuName())) {
                    source.genmenNaiyo1 = entity.getKomokuValue();
                    break;
                }
            }

            source.genmenNaiyo = RString.EMPTY;
            source.keigenRitsu = RString.EMPTY;
            source.genmenNaiyo2 = RString.EMPTY;
        } else {
            if (item.get社会福祉法人等利用者負担軽減().is居宅サービス限定() || item.get社会福祉法人等利用者負担軽減().is旧措置者ユニット型個室のみ()) {
                source.genmenRitsu = 減額割合;
                source.keigenRitsu = RString.EMPTY;
            } else {
                source.genmenRitsu = RString.EMPTY;
                source.keigenRitsu = 減額割合;
            }
            source.genmenNaiyo = RString.EMPTY;
            setgenmenNaiyo(source, item);
        }
    }

    private void setgenmenNaiyo(ShakfukusRiysFutKeigTaisKakuninshoReportSource source, ShakfukusRiysFutKeigTaisKakuninshoItem item) {
        if (item.get社会福祉法人等利用者負担軽減().is居宅サービス限定()) {
            for (DbT7067ChohyoSeigyoHanyoEntity entity : item.get帳票制御汎用List()) {
                if (new RString(ChohyoSeigyoHanyoKeysDBD100018.減免内容の制限事項１.name()).equals(entity.getKomokuName())) {
                    source.genmenNaiyo1 = entity.getKomokuValue();
                    break;
                }
            }
        } else if (item.get社会福祉法人等利用者負担軽減().is旧措置者ユニット型個室のみ()) {
            for (DbT7067ChohyoSeigyoHanyoEntity entity : item.get帳票制御汎用List()) {
                if (new RString(ChohyoSeigyoHanyoKeysDBD100018.減免内容の制限事項３_１.name()).equals(entity.getKomokuName())) {
                    source.genmenNaiyo1 = entity.getKomokuValue();
                    break;
                }
            }
        } else {
            source.genmenNaiyo1 = RString.EMPTY;
        }

        if (item.get社会福祉法人等利用者負担軽減().is居住費_食費のみ()) {
            for (DbT7067ChohyoSeigyoHanyoEntity entity : item.get帳票制御汎用List()) {
                if (new RString(ChohyoSeigyoHanyoKeysDBD100018.減免内容の制限事項２.name()).equals(entity.getKomokuName())) {
                    source.genmenNaiyo2 = entity.getKomokuValue();
                    break;
                }
            }
        } else {
            source.genmenNaiyo2 = RString.EMPTY;
        }
    }

    private static EditedKojin getEditedKojin(IKojin kojin, ChohyoSeigyoKyotsu 帳票制御共通, Association 地方公共団体) {
        return new EditedKojin(kojin, 帳票制御共通, 地方公共団体);
    }

    private RString setWareki(RDate 日付) {
        return 日付.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString();
    }
}
