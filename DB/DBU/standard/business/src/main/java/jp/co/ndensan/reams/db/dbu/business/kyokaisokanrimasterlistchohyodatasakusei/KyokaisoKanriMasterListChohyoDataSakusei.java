/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.kyokaisokanrimasterlistchohyodatasakusei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisoKanriMasterListChohyoDataSakuseiEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisogGaitoshaListEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisogGaitoshaRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 *
 * ビジネス設計_DBUMN52001_境界層管理マスタリスト_帳票データ作成のクラスです。
 */
public class KyokaisoKanriMasterListChohyoDataSakusei {

    private static final int NOCOUNT_20 = 20;

    /**
     *
     * @param kyokaisogGaitoshaListEntity kyokaisogGaitoshaListEntity
     *
     * @return 境界層管理マスタリスト帳票ソースデータリスト。
     */
    //TODO 南京账票没有提供。测试不可。並び順和改頁已提QA
    public List<KyokaisoKanriMasterListChohyoDataSakuseiEntity> getcreateNenreiToutatsuYoteishaCheckListChohyo(
            KyokaisogGaitoshaListEntity kyokaisogGaitoshaListEntity) {
        KyokaisoKanriMasterListChohyoDataSakuseiEntity chohyoDataEntity = new KyokaisoKanriMasterListChohyoDataSakuseiEntity();
        List<KyokaisoKanriMasterListChohyoDataSakuseiEntity> 境界層管理マスタリスト帳票ソースデータリスト = new ArrayList<>();
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

        if (0 == kyokaisogGaitoshaListEntity.getKyokaisokanrimasterList().size()) {
            境界層管理マスタリスト帳票ソースデータリスト.add(chohyoDataEntity);

        } else {
            chohyoDataEntity = 帳票用データリスト(kyokaisogGaitoshaListEntity);
            境界層管理マスタリスト帳票ソースデータリスト.add(chohyoDataEntity);
        }
        return 境界層管理マスタリスト帳票ソースデータリスト;
    }

    /**
     *
     * get印刷日時取得です。
     */
    private static RString get印刷日時() {
        RStringBuilder systemDateTime = new RStringBuilder();
        RDateTime datetime = RDate.getNowDateTime();
        systemDateTime.append(datetime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(String.format("%02d", datetime.getHour()));
        systemDateTime.append(new RString("時"));
        systemDateTime.append(String.format("%02d", datetime.getMinute()));
        systemDateTime.append(new RString("分"));
        systemDateTime.append(String.format("%02d", datetime.getSecond()));
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
        int nocount = 0;
        List<KyokaisoKanriMasterListChohyoDataSakuseiEntity> 境界層管理マスタ帳票用データリスト = new ArrayList<>();
        List<KyokaisogGaitoshaRelateEntity> 境界層管理マスタリスト = kyokaisogGaitoshaListEntity.getKyokaisokanrimasterList();
        List<HihokenshaNo> 被保険者番号 = new ArrayList<>();
        List<ShikibetsuCode> 識別コード = new ArrayList<>();
        List<RString> カナ氏名 = new ArrayList<>();
        List<RString> 氏名 = new ArrayList<>();
        List<RString> 性別 = new ArrayList<>();
        List<RString> 種別 = new ArrayList<>();
        List<RString> 状態 = new ArrayList<>();
        List<SetaiCode> 世帯コード = new ArrayList<>();
        List<FlexibleDate> 生年月日 = new ArrayList<>();
        List<FlexibleDate> 該当申請日 = new ArrayList<>();
        List<FlexibleDate> 該当開始日 = new ArrayList<>();
        List<FlexibleDate> 該当終了日 = new ArrayList<>();
        List<RString> 給付額減額解除 = new ArrayList<>();
        List<Decimal> 標準負担減額後負担額 = new ArrayList<>();
        List<RString> 居住費軽減後居室種類 = new ArrayList<>();
        List<Decimal> 居住費軽減後負担額 = new ArrayList<>();
        List<Decimal> 食費軽減後負担額 = new ArrayList<>();
        List<Decimal> 高額ｻｰﾋﾞｽ費減額後上限額 = new ArrayList<>();
        List<RString> 保険料納付減額後保険料段階 = new ArrayList<>();
        for (KyokaisogGaitoshaRelateEntity entity : 境界層管理マスタリスト) {
            被保険者番号.add(entity.getHihokenshaNo());
            識別コード.add(entity.getShikibetsuCode());
            カナ氏名.add(entity.getKanaShimei());
            氏名.add(entity.getMeisho());
            if (new RString("1").equals(entity.getSetaiCode().value())) {
                性別.add(new RString("男"));
            } else if (new RString("2").equals(entity.getSetaiCode().value())) {
                性別.add(new RString("女"));
            }

            種別.add(new RString(CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                    new CodeShubetsu(entity.getJuminShubetsuCode()), Code.EMPTY).getコード名称().toString()));
            状態.add(new RString(CodeMaster.getCode(SubGyomuCode.DBA介護資格, CodeShubetsu.EMPTY,
                    new Code(entity.getJuminJotaiCode())).getコード名称().toString()));
            世帯コード.add(entity.getSetaiCode());
            生年月日.add(new FlexibleDate(entity.getSeinengappiYMD().
                    wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString()));
            該当申請日.add(new FlexibleDate(entity.getShinseiYMD().
                    wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString()));
            該当開始日.add(new FlexibleDate(entity.getTekiyoKaishiYMD().
                    wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString()));
            該当終了日.add(new FlexibleDate(entity.getTekiyoShuryoYMD().
                    wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString()));
            給付額減額解除.add(entity.getKyuufugakuGengakuKisaiKiajoFlag());
            標準負担減額後負担額.add(entity.getHyojunFutanKeigengoFutangaku());
            居住費軽減後居室種類.add(new RString(CodeMaster.getCode(SubGyomuCode.DBA介護資格, new CodeShubetsu("0243"),
                    new Code(entity.getKyojuhiKeigengoKyoshitsuShuruiCode())).getコード名称().toString()));
            居住費軽減後負担額.add(entity.getKyojuhiKeigengoHutangaku());
            食費軽減後負担額.add(entity.getShokuhiKeigengoHutangaku());
            高額ｻｰﾋﾞｽ費減額後上限額.add(entity.getKogakuServicehiJogengakuGengakugoJogengaku());
            保険料納付減額後保険料段階.add(entity.getGengakuGoHokenryoDankai());
            if ((nocount + 1) % NOCOUNT_20 == 0) {
                KyokaisoKanriMasterListChohyoDataSakuseiEntity entity1
                        = new KyokaisoKanriMasterListChohyoDataSakuseiEntity();
                entity1.set被保険者番号(被保険者番号);
                entity1.set識別コード(識別コード);
                entity1.setカナ氏名(カナ氏名);
                entity1.set氏名(氏名);
                entity1.set性別(性別);
                entity1.set種別(種別);
                entity1.set状態(状態);
                entity1.set世帯コード(世帯コード);
                entity1.set生年月日(生年月日);
                entity1.set該当申請日(該当申請日);
                entity1.set該当開始日(該当開始日);
                entity1.set該当終了日(該当終了日);
                entity1.set給付額減額解除(給付額減額解除);
                entity1.set標準負担減額後負担額(標準負担減額後負担額);
                entity1.set居住費軽減後居室種類(居住費軽減後居室種類);
                entity1.set居住費軽減後負担額(居住費軽減後負担額);
                entity1.set食費軽減後負担額(食費軽減後負担額);
                entity1.set高額ｻｰﾋﾞｽ費減額後上限額(高額ｻｰﾋﾞｽ費減額後上限額);
                entity1.set保険料納付減額後保険料段階(保険料納付減額後保険料段階);
                被保険者番号.clear();
                識別コード.clear();
                カナ氏名.clear();
                氏名.clear();
                性別.clear();
                種別.clear();
                状態.clear();
                世帯コード.clear();
                生年月日.clear();
                該当申請日.clear();
                該当開始日.clear();
                該当終了日.clear();
                給付額減額解除.clear();
                標準負担減額後負担額.clear();
                居住費軽減後居室種類.clear();
                居住費軽減後負担額.clear();
                食費軽減後負担額.clear();
                高額ｻｰﾋﾞｽ費減額後上限額.clear();
                保険料納付減額後保険料段階.clear();
                境界層管理マスタ帳票用データリスト.add(entity1);

            } else if (境界層管理マスタリスト.size() - 境界層管理マスタリスト.size() % NOCOUNT_20 < (nocount + 1)) {
                KyokaisoKanriMasterListChohyoDataSakuseiEntity entity1
                        = new KyokaisoKanriMasterListChohyoDataSakuseiEntity();
                entity1.set被保険者番号(被保険者番号);
                entity1.set識別コード(識別コード);
                entity1.setカナ氏名(カナ氏名);
                entity1.set氏名(氏名);
                entity1.set性別(性別);
                entity1.set種別(種別);
                entity1.set状態(状態);
                entity1.set世帯コード(世帯コード);
                entity1.set生年月日(生年月日);
                entity1.set該当申請日(該当申請日);
                entity1.set該当開始日(該当開始日);
                entity1.set該当終了日(該当終了日);
                entity1.set給付額減額解除(給付額減額解除);
                entity1.set標準負担減額後負担額(標準負担減額後負担額);
                entity1.set居住費軽減後居室種類(居住費軽減後居室種類);
                entity1.set居住費軽減後負担額(居住費軽減後負担額);
                entity1.set食費軽減後負担額(食費軽減後負担額);
                entity1.set高額ｻｰﾋﾞｽ費減額後上限額(高額ｻｰﾋﾞｽ費減額後上限額);
                entity1.set保険料納付減額後保険料段階(保険料納付減額後保険料段階);
                境界層管理マスタ帳票用データリスト.add(entity1);
            }
            nocount++;
        }
        return 境界層管理マスタ帳票用データリスト;
    }

}
