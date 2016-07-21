/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.koikinaijushochitokurei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.core.koikinaijushochitokurei.KoikinaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbu.definition.core.koikinaijushochitokurei.KoikinaiJushochiTokureiItiranEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.GaikokujinSeinengappiHyojihoho;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import lombok.Getter;
import lombok.Setter;

/**
 * 域内住所地特例者一覧表バッチから取った入力パラメータにより、帳票用データを作成します。
 *
 * @reamsid_L DBU-1140-040 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KoikinaiJushochiTokureishaIchiranhyoChohyoDataSakusei {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString DATE_作成 = new RString("作成");
    private static final RString 氏名_データなし = new RString("該当データがありません");

    private RString 印刷日時;
    private RString ページ数;
    private RString 市町村コード;
    private RString 市町村名;
    private RString 並び順１;
    private RString 並び順２;
    private RString 並び順３;
    private RString 並び順４;
    private RString 並び順５;
    private RString 改頁１;
    private RString 改頁２;
    private RString 改頁３;
    private RString 改頁４;
    private RString 改頁５;
    private RString 被保険者番号;
    private RString 氏名カナ;
    private RString 生年月日;
    private RString 住所コード;
    private RString 行政区CD;
    private RString 行政区;
    private RString 取得日;
    private RString 取得届出日;
    private RString 喪失日;
    private RString 喪失届出日;
    private RString 資格区分;
    private RString 住特;
    private RString 識別コード;
    private RString 氏名;
    private RString 性別;
    private RString 世帯コード;
    private RString 住所;
    private RString 広住取得日;
    private RString 広住取得届出日;
    private RString 広住喪失日;
    private RString 広住喪失届出日;
    private RString 措置市町村コード;
    private RString 措置市町村名称;

    private KoikinaiJushochiTokureishaIchiranhyoChohyoDataSakusei() {

    }

    /**
     * 帳票データ作成します。
     *
     * @param entity 広域内住所地特例者一覧表情報Entity
     * @return 帳票用データ
     */
    public static List<KoikinaiJushochiTokureishaIchiranhyoChohyoDataSakusei> createReportDate(KoikinaiJushochiTokureiItiranEntity entity) {
        List<KoikinaiJushochiTokureishaIchiranhyoChohyoDataSakusei> データList = new ArrayList<>();
        RDateTime printdate = RDateTime.now();
        RStringBuilder printTimeStampSb = new RStringBuilder();
        printTimeStampSb.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(String.format("%02d", printdate.getHour()));
        printTimeStampSb.append(DATE_時);
        printTimeStampSb.append(String.format("%02d", printdate.getMinute()));
        printTimeStampSb.append(DATE_分);
        printTimeStampSb.append(String.format("%02d", printdate.getSecond()));
        printTimeStampSb.append(DATE_秒);
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(DATE_作成);

        RString 印刷日時 = printTimeStampSb.toRString();
        RString 市町村コード = entity.get市町村コード();
        RString 市町村名 = entity.get市町村名();
        RString 並び順1 = entity.get並び順();
        RString 並び順2 = entity.get並び順();
        RString 並び順3 = entity.get並び順();
        RString 並び順4 = entity.get並び順();
        RString 並び順5 = entity.get並び順();
        if (entity.get広域内住所地特例者List().isEmpty()) {
            KoikinaiJushochiTokureishaIchiranhyoChohyoDataSakusei データ = new KoikinaiJushochiTokureishaIchiranhyoChohyoDataSakusei();
            データ.set印刷日時(印刷日時);
            データ.setページ数(new RString("1"));
            データ.set市町村コード(市町村コード);
            データ.set市町村名(市町村名);
            データ.set並び順１(並び順1);
            データ.set並び順２(並び順2);
            データ.set並び順３(並び順3);
            データ.set並び順４(並び順4);
            データ.set並び順５(並び順5);
            データ.set改頁１(RString.EMPTY);
            データ.set改頁２(RString.EMPTY);
            データ.set改頁３(RString.EMPTY);
            データ.set改頁４(RString.EMPTY);
            データ.set改頁５(RString.EMPTY);
            データ.set氏名(氏名_データなし);
            データList.add(データ);
        } else {
            for (int i = 0; i < entity.get広域内住所地特例者List().size(); i++) {
                KoikinaiJushochiTokureishaIchiranhyoChohyoDataSakusei データ
                        = new KoikinaiJushochiTokureishaIchiranhyoChohyoDataSakusei();
                KoikinaiJushochiTokureiEntity 該当データ = entity.get広域内住所地特例者List().get(i);
                データ.set印刷日時(印刷日時);
                データ.set市町村コード(市町村コード);
                データ.set市町村名(市町村名);
                データ.set並び順１(並び順1);
                データ.set並び順２(並び順2);
                データ.set並び順３(並び順3);
                データ.set並び順４(並び順4);
                データ.set並び順５(並び順5);
                データ.set改頁１(RString.EMPTY);
                データ.set改頁２(RString.EMPTY);
                データ.set改頁３(RString.EMPTY);
                データ.set改頁４(RString.EMPTY);
                データ.set改頁５(RString.EMPTY);
                データ.set氏名(氏名_データなし);
                データ.set被保険者番号(該当データ.get被保険者番号());
                データ.set氏名カナ(該当データ.get氏名カナ());
                データ.set生年月日(get生年月日(該当データ));
                データ.set住所コード(該当データ.get住所コード());
                データ.set行政区CD(該当データ.get行政区CD());
                データ.set行政区(該当データ.get行政区());
                データ.set取得日(timeToRString(該当データ.get取得日()));
                データ.set取得届出日(timeToRString(該当データ.get取得届出日()));
                データ.set喪失日(timeToRString(該当データ.get喪失日()));
                データ.set喪失届出日(timeToRString(該当データ.get喪失届出日()));
                データ.set資格区分(該当データ.get資格区分());
                データ.set住特(該当データ.get住特());
                データ.set識別コード(該当データ.get識別コード());
                データ.set氏名(該当データ.get氏名());
                データ.set性別(Seibetsu.toValue(該当データ.get性別()).get名称());
                データ.set世帯コード(該当データ.get世帯コード());
                データ.set住所(該当データ.get住所());
                データ.set広住取得日(timeToRString(該当データ.get広住取得日()));
                データ.set広住取得届出日(timeToRString(該当データ.get広住取得届出日()));
                データ.set広住喪失日(timeToRString(該当データ.get広住喪失日()));
                データ.set広住喪失届出日(timeToRString(該当データ.get広住喪失届出日()));
                データ.set措置市町村コード(該当データ.get措置市町村コード());
                データ.set措置市町村名称(該当データ.get措置市町村名称());
                データList.add(データ);
            }
        }
        return データList;
    }

    private static RString get生年月日(KoikinaiJushochiTokureiEntity 該当データ) {
        if (JuminShubetsu.日本人.getCode().equals(該当データ.get住民種別コード())
                || JuminShubetsu.住登外個人_日本人.getCode().equals(該当データ.get住民種別コード())) {
            return timeToRString(該当データ.get生年月日());
        } else if (JuminShubetsu.外国人.getCode().equals(該当データ.get住民種別コード())
                || JuminShubetsu.住登外個人_外国人.getCode().equals(該当データ.get住民種別コード())) {
            if (GaikokujinSeinengappiHyojihoho.和暦表示.getコード().equals(DbBusinessConfig
                    .get(ConfigNameDBU.外国人表示制御_生年月日表示方法, RDate.getNowDate()))) {
                return timeToRString(該当データ.get生年月日());
            } else if (GaikokujinSeinengappiHyojihoho.西暦表示.getコード().equals(DbBusinessConfig
                    .get(ConfigNameDBU.外国人表示制御_生年月日表示方法, RDate.getNowDate()))) {
                return new FlexibleDate(該当データ.get生年月日()).wareki()
                        .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
            }
        }
        return RString.EMPTY;
    }

    private static RString timeToRString(RString time) {
        if (RString.isNullOrEmpty(time)) {
            return RString.EMPTY;
        }
        return new RDate(time.toString()).wareki()
                .separator(Separator.PERIOD).fillType(FillType.NONE).toDateString();
    }

}
