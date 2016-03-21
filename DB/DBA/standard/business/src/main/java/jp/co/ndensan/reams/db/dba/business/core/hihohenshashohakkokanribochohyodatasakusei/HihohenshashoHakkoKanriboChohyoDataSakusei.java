/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihohenshashohakkokanribochohyodatasakusei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoBodyItem;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.AkasiHakouKanriEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.AkasiHakouKanriRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.HihohenshashoHakkoKanriboChohyoDataSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.ShoYoshikiKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 *
 * 被保険者証発行管理簿_帳票データ作成のクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HihohenshashoHakkoKanriboChohyoDataSakusei {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString DATE_作成 = new RString("作成");
    private static final RString 改頁 = new RString("被保険者証発行管理簿");
    private static final RString 被保険者証発行 = new RString("介護保険　被保険者証発行管理一覧表");
    private static final RString 資格者証発行 = new RString("介護保険　資格者証発行管理一覧表");
    private static final CodeShubetsu コード種別_0002 = new CodeShubetsu("0002");
    private static final CodeShubetsu コード種別_0003 = new CodeShubetsu("0003");
    private static final CodeShubetsu コード種別_0004 = new CodeShubetsu("0004");
    private static final CodeShubetsu コード種別_0005 = new CodeShubetsu("0005");

    /**
     * 証発行管理帳票データリスト作成します。
     *
     * @param relateEntityList 証発行管理リスト情報EntityList
     * @return List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity>
     * 証発行管理リスト帳票用データリスト
     */
    public List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity> getShohakkoKanriChohyoDataList(AkasiHakouKanriRelateEntity relateEntityList) {
        List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity> chohyoDataEntityList = new ArrayList<>();
        for (AkasiHakouKanriEntity entity : relateEntityList.getAkasiHakouKanriEntityList()) {
            HihohenshashoHakkoKanriboChohyoDataSakuseiEntity chohyoDataEntity = new HihohenshashoHakkoKanriboChohyoDataSakuseiEntity();
            chohyoDataEntity.set印刷日時(get印刷日時());
            chohyoDataEntity.set帳票タイトル(relateEntityList.getChouhouTitle());
            chohyoDataEntity.set市町村コード(relateEntityList.getShichosonCode().value());
            chohyoDataEntity.set市町村名(relateEntityList.getShichosonMeisho());
            // TODO ソート順/改頁　技術点問題あり。   2016/01/20まで。
            //chohyoDataEntity.setソート順１(NarabiJunType.toValue(relateEntityList.getSortJun()).toRString());
            chohyoDataEntity.setソート順２(RString.EMPTY);
            chohyoDataEntity.setソート順３(RString.EMPTY);
            chohyoDataEntity.setソート順４(RString.EMPTY);
            chohyoDataEntity.setソート順５(RString.EMPTY);
//            if (NextPageType.委託先コード.code().equals(relateEntityList.getKayiPeji())) {
//                chohyoDataEntity.set改頁１(改頁);
//            } else {
//                chohyoDataEntity.set改頁１(RString.EMPTY);
//            }
            chohyoDataEntity.set改頁２(RString.EMPTY);
            chohyoDataEntity.set改頁３(RString.EMPTY);
            chohyoDataEntity.set改頁４(RString.EMPTY);
            chohyoDataEntity.set改頁５(RString.EMPTY);
            int ページ数 = 1;
            chohyoDataEntity.setページ数(ページ数);
            chohyoDataEntity.set被保険者番号(entity.getHihokenshaNo());
            chohyoDataEntity.set識別コード(entity.getShikibetsuCode().value());
            chohyoDataEntity.set郵便番号(entity.getYubinNo());
            chohyoDataEntity.set氏名(entity.getMeisho());
            chohyoDataEntity.set住所(entity.getJusho());
            chohyoDataEntity.set市町村コードListYou(entity.getShichosonCode().value());
            chohyoDataEntity.set交付年月日(entity.getKofuYMD().wareki()
                    .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
            chohyoDataEntity.set交付事由コード(entity.getKofuJiyu());
            if (被保険者証発行.equals(relateEntityList.getChouhouTitle())) {
                chohyoDataEntity.set交付事由略称(CodeMaster.getCodeRyakusho(
                        SubGyomuCode.DBA介護資格, コード種別_0002, new Code(entity.getKofuJiyu())));
                chohyoDataEntity.set交付事由名称(CodeMaster.getCodeMeisho(
                        SubGyomuCode.DBA介護資格, コード種別_0002, new Code(entity.getKofuJiyu())));
                chohyoDataEntity.set回収事由名称(
                        CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格, コード種別_0003, new Code(entity.getKofuJiyu())));
            } else if (資格者証発行.equals(relateEntityList.getChouhouTitle())) {
                chohyoDataEntity.set交付事由略称(CodeMaster.getCodeRyakusho(
                        SubGyomuCode.DBA介護資格, コード種別_0004, new Code(entity.getKofuJiyu())));
                chohyoDataEntity.set交付事由名称(CodeMaster.getCodeMeisho(
                        SubGyomuCode.DBA介護資格, コード種別_0004, new Code(entity.getKofuJiyu())));
                chohyoDataEntity.set回収事由名称(CodeMaster.getCodeMeisho(
                        SubGyomuCode.DBA介護資格, コード種別_0005, new Code(entity.getKofuJiyu())));
            }
            chohyoDataEntity.set回収年月日(entity.getKaishuYMD().wareki()
                    .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
            chohyoDataEntity.set回収事由コード(entity.getKofuJiyu());

            chohyoDataEntity.set有効期限((new RString(entity.getYukoKigenYMD().toString())));
            chohyoDataEntity.set様式(ShoYoshikiKubun.toValue(entity.getShoYoshikiKubunCode()).get名称());
            chohyoDataEntityList.add(chohyoDataEntity);
        }
        return chohyoDataEntityList;
    }

    public List<HihokenshashoHakkoKanriIchiranhyoBodyItem> setShohakkoKanriChohyoDataList(AkasiHakouKanriRelateEntity relateEntityList) {
        List<HihokenshashoHakkoKanriIchiranhyoBodyItem> list = new ArrayList();
        List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity> chohyoDataEntityList = getShohakkoKanriChohyoDataList(relateEntityList);
        for (HihohenshashoHakkoKanriboChohyoDataSakuseiEntity entity : chohyoDataEntityList) {
            HihokenshashoHakkoKanriIchiranhyoBodyItem bodyItem = new HihokenshashoHakkoKanriIchiranhyoBodyItem(
                    entity.get被保険者番号(),
                    entity.get識別コード(),
                    entity.get氏名(),
                    entity.get交付年月日(),
                    entity.get交付事由コード(),
                    entity.get交付事由名称(),
                    entity.get交付事由略称(),
                    entity.get有効期限(),
                    entity.get市町村コード(),
                    entity.get郵便番号(),
                    entity.get住所(),
                    entity.get回収年月日(),
                    entity.get回収事由コード(),
                    entity.get回収事由名称(),
                    entity.get様式());
            list.add(bodyItem);
        }

        return list;

    }

    private RString get印刷日時() {
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
        return printTimeStampSb.toRString();
    }
}
