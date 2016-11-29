/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlistchohyodatasakusei;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisoKanriMasterListChohyoDataSakuseiEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisogGaitoshaListEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisogGaitoshaRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBZCodeShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 *
 * ビジネス設計_DBUMN52001_境界層管理マスタリスト_帳票データ作成のクラスです。
 *
 * @reamsid_L DBU-1050-040 wanghui
 */
public class KyokaisoKanriMasterListChohyoDataSakusei {

    private static final RString 男 = new RString("1");
    private static final RString 解除する = new RString("1");
    private static final RString 性別_男 = new RString("男");
    private static final RString 性別_女 = new RString("女");
    private static final RString 給付額減額記載解除フラグ_解除する = new RString("解除する");
    private static final int 並び順1 = 0;
    private static final int 並び順2 = 1;
    private static final int 並び順3 = 2;
    private static final int 並び順4 = 3;
    private static final int 並び順5 = 4;
    private static final int 改頁1 = 0;
    private static final int 改頁2 = 1;
    private static final int 改頁3 = 2;
    private static final int 改頁4 = 3;
    private static final int 改頁5 = 4;

    /**
     * @param kyokaisogGaitoshaListEntity kyokaisogGaitoshaListEntity
     * @param entity KyokaisogGaitoshaRelateEntity
     *
     * @return 境界層管理マスタリスト帳票ソースデータリスト。
     */
    public KyokaisoKanriMasterListChohyoDataSakuseiEntity getcreateNenreiToutatsuYoteishaCheckListChohyo(
            KyokaisogGaitoshaListEntity kyokaisogGaitoshaListEntity, KyokaisogGaitoshaRelateEntity entity) {
        KyokaisoKanriMasterListChohyoDataSakuseiEntity 帳票ソースデータ = new KyokaisoKanriMasterListChohyoDataSakuseiEntity();
        if (entity == null) {
            帳票用データリスト(kyokaisogGaitoshaListEntity, 帳票ソースデータ);
        } else {
            get境界層管理マスタリスト分割処理(entity, 帳票ソースデータ);
            帳票ソースデータ.set印刷日時(get印刷日時());
            帳票ソースデータ.setページ数(RString.EMPTY);
            帳票ソースデータ.set市町村コード(kyokaisogGaitoshaListEntity.get市町村コード());
            帳票ソースデータ.set市町村名(kyokaisogGaitoshaListEntity.get市町村名());
            if (kyokaisogGaitoshaListEntity.get並び順() != null) {
                帳票ソースデータ.set並び順1(kyokaisogGaitoshaListEntity.get並び順().get(並び順1));
                帳票ソースデータ.set並び順2(kyokaisogGaitoshaListEntity.get並び順().get(並び順2));
                帳票ソースデータ.set並び順3(kyokaisogGaitoshaListEntity.get並び順().get(並び順3));
                帳票ソースデータ.set並び順4(kyokaisogGaitoshaListEntity.get並び順().get(並び順4));
                帳票ソースデータ.set並び順5(kyokaisogGaitoshaListEntity.get並び順().get(並び順5));
            }
            if (kyokaisogGaitoshaListEntity.get改頁() != null) {
                帳票ソースデータ.set改頁1(kyokaisogGaitoshaListEntity.get改頁().get(改頁1));
                帳票ソースデータ.set改頁2(kyokaisogGaitoshaListEntity.get改頁().get(改頁2));
                帳票ソースデータ.set改頁3(kyokaisogGaitoshaListEntity.get改頁().get(改頁3));
                帳票ソースデータ.set改頁4(kyokaisogGaitoshaListEntity.get改頁().get(改頁4));
                帳票ソースデータ.set改頁5(kyokaisogGaitoshaListEntity.get改頁().get(改頁5));
            }
        }
        return 帳票ソースデータ;
    }

    /**
     *
     * 印刷日時取得です。
     *
     */
    private static RString get印刷日時() {
        RStringBuilder systemDateTime = new RStringBuilder();
        RDateTime datetime = RDate.getNowDateTime();
        systemDateTime.append(datetime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(String.format("%2d", datetime.getHour()));
        systemDateTime.append(new RString("時"));
        systemDateTime.append(String.format("%2d", datetime.getMinute()));
        systemDateTime.append(new RString("分"));
        systemDateTime.append(String.format("%2d", datetime.getSecond()));
        systemDateTime.append(new RString("秒"));
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(new RString("作成"));
        return systemDateTime.toRString();
    }

    private void 帳票用データリスト(KyokaisogGaitoshaListEntity kyokaisogGaitoshaListEntity,
            KyokaisoKanriMasterListChohyoDataSakuseiEntity chohyoDataEntity) {
        chohyoDataEntity.set印刷日時(get印刷日時());
        chohyoDataEntity.setページ数(new RString("1"));
        chohyoDataEntity.set市町村コード(kyokaisogGaitoshaListEntity.get市町村コード());
        chohyoDataEntity.set市町村名(kyokaisogGaitoshaListEntity.get市町村名());
        if (kyokaisogGaitoshaListEntity.get並び順() != null) {
            chohyoDataEntity.set並び順1(kyokaisogGaitoshaListEntity.get並び順().get(並び順1));
            chohyoDataEntity.set並び順2(kyokaisogGaitoshaListEntity.get並び順().get(並び順2));
            chohyoDataEntity.set並び順3(kyokaisogGaitoshaListEntity.get並び順().get(並び順3));
            chohyoDataEntity.set並び順4(kyokaisogGaitoshaListEntity.get並び順().get(並び順4));
            chohyoDataEntity.set並び順5(kyokaisogGaitoshaListEntity.get並び順().get(並び順5));
        }
        if (kyokaisogGaitoshaListEntity.get改頁() != null) {
            chohyoDataEntity.set改頁1(kyokaisogGaitoshaListEntity.get改頁().get(改頁1));
            chohyoDataEntity.set改頁2(kyokaisogGaitoshaListEntity.get改頁().get(改頁2));
            chohyoDataEntity.set改頁3(kyokaisogGaitoshaListEntity.get改頁().get(改頁3));
            chohyoDataEntity.set改頁4(kyokaisogGaitoshaListEntity.get改頁().get(改頁4));
            chohyoDataEntity.set改頁5(kyokaisogGaitoshaListEntity.get改頁().get(改頁5));
        }
    }

    private void get境界層管理マスタリスト分割処理(
            KyokaisogGaitoshaRelateEntity entity, KyokaisoKanriMasterListChohyoDataSakuseiEntity 帳票用データ) {
        帳票用データ.set被保険者番号(entity.getHihokenshaNo().value());
        帳票用データ.set識別コード(nullToEmpty(entity.getShikibetsuCode().value()));
        帳票用データ.setカナ氏名(nullToEmpty(entity.getKanaShimei()));
        帳票用データ.set氏名(nullToEmpty(entity.getMeisho()));
        帳票用データ.set町域コード(entity.getChoikiCode());
        if (entity.getShichosonCode() != null) {
            帳票用データ.set改頁市町村コード(entity.getShichosonCode().value());
        }
        if (男.equals(nullToEmpty(entity.getSeibetsuCode()))) {
            帳票用データ.set性別(性別_男);
        } else {
            帳票用データ.set性別(性別_女);
        }
        帳票用データ.set種別(entity.getJuminShubetsuCode() == null
                ? RString.EMPTY : JuminShubetsu.toValue(entity.getJuminShubetsuCode()).toRString());
        帳票用データ.set状態(entity.getJuminJotaiCode() == null
                ? RString.EMPTY : JuminJotai.toValue(entity.getJuminJotaiCode()).住民状態略称());
        if (entity.getSetaiCode() != null) {
            帳票用データ.set世帯コード(nullToEmpty(entity.getSetaiCode().value()));
        }
        帳票用データ.set生年月日(共通ポリシfomart(entity.getSeinengappiYMD()));
        帳票用データ.set該当申請日(共通ポリシfomart(entity.getShinseiYMD()));
        帳票用データ.set該当開始日(共通ポリシfomart(entity.getTekiyoKaishiYMD()));
        帳票用データ.set該当終了日(共通ポリシfomart(entity.getTekiyoShuryoYMD()));
        if (解除する.equals(nullToEmpty(entity.getKyuufugakuGengakuKisaiKiajoFlag()))) {
            帳票用データ.set給付額減額解除(給付額減額記載解除フラグ_解除する);
        } else {
            帳票用データ.set給付額減額解除(RString.EMPTY);
        }
        if (entity.getHyojunFutanKeigengoFutangaku() != null) {
            帳票用データ.set標準負担減額後負担額(new RString(DecimalFormatter.toコンマ区切りRString(entity.getHyojunFutanKeigengoFutangaku(), 0).toString()));
        } else {
            帳票用データ.set標準負担減額後負担額(RString.EMPTY);
        }
        if (entity.getKyojuhiKeigengoKyoshitsuShuruiCode() != null) {
            UzT0007CodeEntity 居室種類 = CodeMaster.getCode(SubGyomuCode.DBZ介護共通,
                    DBZCodeShubetsu.居室種類.getコード(), new Code(entity.getKyojuhiKeigengoKyoshitsuShuruiCode()), FlexibleDate.getNowDate());
            if (居室種類 != null) {
                帳票用データ.set居住費軽減後居室種類(new RString(居室種類.getコード名称().toString()));
            }
        } else {
            帳票用データ.set居住費軽減後居室種類(RString.EMPTY);
        }
        setlist(entity, 帳票用データ);
    }

    private void setlist(KyokaisogGaitoshaRelateEntity entity, KyokaisoKanriMasterListChohyoDataSakuseiEntity 帳票用データ) {
        if (entity.getKyojuhiKeigengoHutangaku() != null) {
            帳票用データ.set居住費軽減後負担額(new RString(DecimalFormatter.toコンマ区切りRString(entity.getKyojuhiKeigengoHutangaku(), 0).toString()));
        } else {
            帳票用データ.set居住費軽減後負担額(null);
        }
        if (entity.getShokuhiKeigengoHutangaku() != null) {
            帳票用データ.set食費軽減後負担額(new RString(DecimalFormatter.toコンマ区切りRString(entity.getShokuhiKeigengoHutangaku(), 0).toString()));
        } else {
            帳票用データ.set食費軽減後負担額(null);
        }
        if (entity.getKogakuServicehiJogengakuGengakugoJogengaku() != null) {
            帳票用データ.set高額ｻｰﾋﾞｽ費減額後上限額(new RString(DecimalFormatter.
                    toコンマ区切りRString(entity.getKogakuServicehiJogengakuGengakugoJogengaku(), 0).toString()));
        } else {
            帳票用データ.set高額ｻｰﾋﾞｽ費減額後上限額(null);
        }
        if (entity.getGengakuGoHokenryoDankai() != null) {
            RStringBuilder nituliki = new RStringBuilder();
            nituliki.append(new RString("第"));
            nituliki.append(entity.getGengakuGoHokenryoDankai());
            nituliki.append(new RString("段階"));
            帳票用データ.set保険料納付減額後保険料段階(nituliki.toRString());
        } else {
            帳票用データ.set保険料納付減額後保険料段階(null);
        }
    }

    private RString 共通ポリシfomart(FlexibleDate date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return (date.
                wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }
}
