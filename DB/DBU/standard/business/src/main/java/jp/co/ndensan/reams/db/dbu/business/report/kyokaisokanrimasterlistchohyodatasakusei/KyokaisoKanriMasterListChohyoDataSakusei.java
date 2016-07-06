/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlistchohyodatasakusei;

import java.util.ArrayList;
import java.util.List;
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

/**
 *
 * ビジネス設計_DBUMN52001_境界層管理マスタリスト_帳票データ作成のクラスです。
 *
 * @reamsid_L DBU-1050-040 wanghui
 */
public class KyokaisoKanriMasterListChohyoDataSakusei {

    private static final int NOCOUNT_20 = 20;
    private static final RString 男 = new RString("1");
    private static final RString 解除する = new RString("1");
    private static final RString 性別_男 = new RString("男");
    private static final RString 性別_女 = new RString("女");
    private static final RString 給付額減額記載解除フラグ_解除する = new RString("解除する");
    private static final RString 改頁 = new RString("1");

    /**
     *
     * @param kyokaisogGaitoshaListEntity kyokaisogGaitoshaListEntity
     *
     * @return 境界層管理マスタリスト帳票ソースデータリスト。
     *
     */
    //TODO QA#73393 改頁 ,並び順取得。
    public List<KyokaisoKanriMasterListChohyoDataSakuseiEntity> getcreateNenreiToutatsuYoteishaCheckListChohyo(
            KyokaisogGaitoshaListEntity kyokaisogGaitoshaListEntity) {
        List<KyokaisoKanriMasterListChohyoDataSakuseiEntity> 境界層管理マスタリスト帳票ソースデータリスト = new ArrayList<>();
        if (kyokaisogGaitoshaListEntity.getKyokaisokanrimasterList() == null
                || 0 == kyokaisogGaitoshaListEntity.getKyokaisokanrimasterList().size()) {
            KyokaisoKanriMasterListChohyoDataSakuseiEntity chohyoDataEntity = 帳票用データリスト(kyokaisogGaitoshaListEntity);
            境界層管理マスタリスト帳票ソースデータリスト.add(chohyoDataEntity);
        } else {
            境界層管理マスタリスト帳票ソースデータリスト = get境界層管理マスタリスト分割処理(kyokaisogGaitoshaListEntity);
            int pageCount = 1;
            for (KyokaisoKanriMasterListChohyoDataSakuseiEntity データリスト : 境界層管理マスタリスト帳票ソースデータリスト) {
                データリスト.set印刷日時(get印刷日時());
                データリスト.setページ数(new RString(String.valueOf(pageCount)));
                データリスト.set市町村コード(kyokaisogGaitoshaListEntity.get市町村コード());
                データリスト.set市町村名(kyokaisogGaitoshaListEntity.get市町村名());
                データリスト.set並び順1(男);
                データリスト.set並び順2(男);
                データリスト.set並び順3(男);
                データリスト.set並び順4(男);
                データリスト.set並び順5(男);
                データリスト.set改頁1(改頁);
                データリスト.set改頁2(改頁);
                データリスト.set改頁3(改頁);
                データリスト.set改頁4(改頁);
                データリスト.set改頁5(改頁);
                pageCount++;
            }
        }
        return 境界層管理マスタリスト帳票ソースデータリスト;
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

    private static KyokaisoKanriMasterListChohyoDataSakuseiEntity
            帳票用データリスト(KyokaisogGaitoshaListEntity kyokaisogGaitoshaListEntity) {
        KyokaisoKanriMasterListChohyoDataSakuseiEntity chohyoDataEntity = new KyokaisoKanriMasterListChohyoDataSakuseiEntity();
        chohyoDataEntity.set印刷日時(get印刷日時());
        chohyoDataEntity.setページ数(new RString("1"));
        chohyoDataEntity.set市町村コード(kyokaisogGaitoshaListEntity.get市町村コード());
        chohyoDataEntity.set市町村名(kyokaisogGaitoshaListEntity.get市町村名());
        //TODO QA#73393 改頁 ,並び順取得。
        chohyoDataEntity.set並び順1(kyokaisogGaitoshaListEntity.get並び順());
        chohyoDataEntity.set並び順2(null);
        chohyoDataEntity.set並び順3(null);
        chohyoDataEntity.set並び順4(null);
        chohyoDataEntity.set並び順5(null);
        chohyoDataEntity.set改頁1(kyokaisogGaitoshaListEntity.get改頁());
        chohyoDataEntity.set改頁2(null);
        chohyoDataEntity.set改頁3(null);
        chohyoDataEntity.set改頁4(null);
        chohyoDataEntity.set改頁5(null);
        return chohyoDataEntity;
    }

    /**
     *
     * 境界層管理マスタリスト分割処理です。
     *
     */
    private List<KyokaisoKanriMasterListChohyoDataSakuseiEntity> get境界層管理マスタリスト分割処理(
            KyokaisogGaitoshaListEntity kyokaisogGaitoshaListEntity) {
        //TODO QA#73393 改頁 ,並び順取得　　List<境界層管理マスタリスト>を引数.並び順でソートする
        int nocount = 0;
        List<KyokaisoKanriMasterListChohyoDataSakuseiEntity> 境界層管理マスタ帳票用データリスト = new ArrayList<>();
        List<KyokaisogGaitoshaRelateEntity> 境界層管理マスタリスト = kyokaisogGaitoshaListEntity.getKyokaisokanrimasterList();
        List<RString> 被保険者番号 = new ArrayList<>();
        List<RString> 識別コード = new ArrayList<>();
        List<RString> カナ氏名 = new ArrayList<>();
        List<RString> 氏名 = new ArrayList<>();
        List<RString> 性別 = new ArrayList<>();
        List<RString> 種別 = new ArrayList<>();
        List<RString> 状態 = new ArrayList<>();
        List<RString> 世帯コード = new ArrayList<>();
        List<RString> 生年月日 = new ArrayList<>();
        List<RString> 該当申請日 = new ArrayList<>();
        List<RString> 該当開始日 = new ArrayList<>();
        List<RString> 該当終了日 = new ArrayList<>();
        List<RString> 給付額減額解除 = new ArrayList<>();
        List<RString> 標準負担減額後負担額 = new ArrayList<>();
        List<RString> 居住費軽減後居室種類 = new ArrayList<>();
        List<RString> 居住費軽減後負担額 = new ArrayList<>();
        List<RString> 食費軽減後負担額 = new ArrayList<>();
        List<RString> 高額ｻｰﾋﾞｽ費減額後上限額 = new ArrayList<>();
        List<RString> 保険料納付減額後保険料段階 = new ArrayList<>();
        for (KyokaisogGaitoshaRelateEntity entity : 境界層管理マスタリスト) {
            被保険者番号.add(entity.getHihokenshaNo().value());
            識別コード.add(nullToEmpty(entity.getShikibetsuCode().value()));
            カナ氏名.add(nullToEmpty(entity.getKanaShimei()));
            氏名.add(nullToEmpty(entity.getMeisho()));
            if (男.equals(nullToEmpty(entity.getSeibetsuCode()))) {
                性別.add(性別_男);
            } else {
                性別.add(性別_女);
            }
            種別.add(entity.getJuminShubetsuCode() == null
                    ? RString.EMPTY : JuminShubetsu.toValue(entity.getJuminShubetsuCode()).toRString());
            状態.add(entity.getJuminJotaiCode() == null
                    ? RString.EMPTY : JuminJotai.toValue(entity.getJuminJotaiCode()).住民状態略称());
            世帯コード.add(nullToEmpty(entity.getSetaiCode().value()));
            生年月日.add(共通ポリシfomart(entity.getSeinengappiYMD()));
            該当申請日.add(共通ポリシfomart(entity.getShinseiYMD()));
            該当開始日.add(共通ポリシfomart(entity.getTekiyoKaishiYMD()));
            該当終了日.add(共通ポリシfomart(entity.getTekiyoShuryoYMD()));
            if (解除する.equals(nullToEmpty(entity.getKyuufugakuGengakuKisaiKiajoFlag()))) {
                給付額減額解除.add(給付額減額記載解除フラグ_解除する);
            } else {
                給付額減額解除.add(RString.EMPTY);
            }
            標準負担減額後負担額.add(nullToEmpty(new RString(entity.getHyojunFutanKeigengoFutangaku().toString())));
            UzT0007CodeEntity 居室種類 = CodeMaster.getCode(SubGyomuCode.DBZ介護共通,
                    DBZCodeShubetsu.居室種類.getコード(), new Code(entity.getKyojuhiKeigengoKyoshitsuShuruiCode()), FlexibleDate.getNowDate());
            if (居室種類 != null) {
                居住費軽減後居室種類.add(new RString(居室種類.getコード名称().toString()));
            } else {
                居住費軽減後居室種類.add(RString.EMPTY);
            }
            居住費軽減後負担額.add(nullToEmpty(new RString(entity.getKyojuhiKeigengoHutangaku().toString())));
            食費軽減後負担額.add(nullToEmpty(new RString(entity.getShokuhiKeigengoHutangaku().toString())));
            高額ｻｰﾋﾞｽ費減額後上限額.add(nullToEmpty(new RString(entity.getKogakuServicehiJogengakuGengakugoJogengaku().toString())));
            保険料納付減額後保険料段階.add(nullToEmpty(new RString(entity.getGengakuGoHokenryoDankai().toString())));

            if ((nocount + 1) % NOCOUNT_20 == 0) {
                KyokaisoKanriMasterListChohyoDataSakuseiEntity データEntity
                        = new KyokaisoKanriMasterListChohyoDataSakuseiEntity();
                データEntity.set被保険者番号(被保険者番号);
                データEntity.set識別コード(識別コード);
                データEntity.setカナ氏名(カナ氏名);
                データEntity.set氏名(氏名);
                データEntity.set性別(性別);
                データEntity.set種別(種別);
                データEntity.set状態(状態);
                データEntity.set世帯コード(世帯コード);
                データEntity.set生年月日(生年月日);
                データEntity.set該当申請日(該当申請日);
                データEntity.set該当開始日(該当開始日);
                データEntity.set該当終了日(該当終了日);
                データEntity.set給付額減額解除(給付額減額解除);
                データEntity.set標準負担減額後負担額(標準負担減額後負担額);
                データEntity.set居住費軽減後居室種類(居住費軽減後居室種類);
                データEntity.set居住費軽減後負担額(居住費軽減後負担額);
                データEntity.set食費軽減後負担額(食費軽減後負担額);
                データEntity.set高額ｻｰﾋﾞｽ費減額後上限額(高額ｻｰﾋﾞｽ費減額後上限額);
                データEntity.set保険料納付減額後保険料段階(保険料納付減額後保険料段階);
                境界層管理マスタ帳票用データリスト.add(データEntity);
                被保険者番号 = new ArrayList<>();
                識別コード = new ArrayList<>();
                カナ氏名 = new ArrayList<>();
                氏名 = new ArrayList<>();
                性別 = new ArrayList<>();
                種別 = new ArrayList<>();
                状態 = new ArrayList<>();
                世帯コード = new ArrayList<>();
                生年月日 = new ArrayList<>();
                該当申請日 = new ArrayList<>();
                該当開始日 = new ArrayList<>();
                該当終了日 = new ArrayList<>();
                給付額減額解除 = new ArrayList<>();
                標準負担減額後負担額 = new ArrayList<>();
                居住費軽減後居室種類 = new ArrayList<>();
                居住費軽減後負担額 = new ArrayList<>();
                食費軽減後負担額 = new ArrayList<>();
                高額ｻｰﾋﾞｽ費減額後上限額 = new ArrayList<>();
                保険料納付減額後保険料段階 = new ArrayList<>();
            } else if (境界層管理マスタリスト.size() == (nocount + 1)) {
                KyokaisoKanriMasterListChohyoDataSakuseiEntity データEntity
                        = new KyokaisoKanriMasterListChohyoDataSakuseiEntity();
                データEntity.set被保険者番号(被保険者番号);
                データEntity.set識別コード(識別コード);
                データEntity.setカナ氏名(カナ氏名);
                データEntity.set氏名(氏名);
                データEntity.set性別(性別);
                データEntity.set種別(種別);
                データEntity.set状態(状態);
                データEntity.set世帯コード(世帯コード);
                データEntity.set生年月日(生年月日);
                データEntity.set該当申請日(該当申請日);
                データEntity.set該当開始日(該当開始日);
                データEntity.set該当終了日(該当終了日);
                データEntity.set給付額減額解除(給付額減額解除);
                データEntity.set標準負担減額後負担額(標準負担減額後負担額);
                データEntity.set居住費軽減後居室種類(居住費軽減後居室種類);
                データEntity.set居住費軽減後負担額(居住費軽減後負担額);
                データEntity.set食費軽減後負担額(食費軽減後負担額);
                データEntity.set高額ｻｰﾋﾞｽ費減額後上限額(高額ｻｰﾋﾞｽ費減額後上限額);
                データEntity.set保険料納付減額後保険料段階(保険料納付減額後保険料段階);
                境界層管理マスタ帳票用データリスト.add(データEntity);
            }
            nocount++;
        }
        return 境界層管理マスタ帳票用データリスト;
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
