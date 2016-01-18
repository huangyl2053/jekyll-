/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihohenshashohakkokanribochohyodatasakusei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.AkasiHakouKanriEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.AkasiHakouKanriRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.HihohenshashoHakkoKanriboChohyoDataSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.ShoYoshikiKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
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

    /**
     * 証発行管理帳票データリスト作成します。
     *
     * @param relateEntityList 証発行管理リスト情報EntityList
     * @return List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity>
     * 証発行管理リスト帳票用データリスト
     */
    public List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity> getShohakkoKanriChohyoDataList(AkasiHakouKanriRelateEntity relateEntityList) {

        HihohenshashoHakkoKanriboChohyoDataSakuseiEntity chohyoDataEntity = new HihohenshashoHakkoKanriboChohyoDataSakuseiEntity();
        List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity> chohyoDataEntityList = new ArrayList<>();
        chohyoDataEntity.set印刷日時(get印刷日時());

        chohyoDataEntity.set帳票タイトル(relateEntityList.getChouhouTitle());
        chohyoDataEntity.set市町村コード(relateEntityList.getShichosonCode());
        chohyoDataEntity.set市町村名(relateEntityList.getShichosonMeisho());
        // TODO ソート順/改頁　技術点問題あり。   2016/01/20まで。
        //chohyoDataEntity.setソート順１(NarabiJunType.toValue(relateEntityList.getSortJun()).toRString());
        chohyoDataEntity.setソート順２(RString.EMPTY);
        chohyoDataEntity.setソート順３(RString.EMPTY);
        chohyoDataEntity.setソート順４(RString.EMPTY);
        chohyoDataEntity.setソート順５(RString.EMPTY);
//        if (NextPageType.委託先コード.code().equals(relateEntityList.getKayiPeji())) {
//            chohyoDataEntity.set改頁１(改頁);
//        } else {
//            chohyoDataEntity.set改頁１(RString.EMPTY);
//        }
        chohyoDataEntity.set改頁２(RString.EMPTY);
        chohyoDataEntity.set改頁３(RString.EMPTY);
        chohyoDataEntity.set改頁４(RString.EMPTY);
        chohyoDataEntity.set改頁５(RString.EMPTY);
        int ページ数 = 1;
        for (AkasiHakouKanriEntity entity : relateEntityList.getAkasiHakouKanriEntityList()) {
            chohyoDataEntity.setページ数(ページ数);
            chohyoDataEntity.set被保険者番号(entity.getHihokenshaNo());
            chohyoDataEntity.set識別コード(entity.getShikibetsuCode());
            chohyoDataEntity.set郵便番号(entity.getYubinNo());
            chohyoDataEntity.set氏名(entity.getMeisho());
            chohyoDataEntity.set住所(entity.getJusho());
            chohyoDataEntity.set市町村コードListYou(entity.getShichosonCode());
            chohyoDataEntity.set交付年月日(entity.getKofuYMD().wareki()
                    .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
            chohyoDataEntity.set交付事由コード(entity.getKofuJiyu());
            // TODO 張国朋 QA 499 回復から提供されたら対応可能。2016/01/20 まで
            chohyoDataEntity.set交付事由略称(CodeMaster.getCodeRyakusho(new CodeShubetsu("0002"), new Code(entity.getKofuJiyu())));
            // TODO 張国朋 QA 499 回復から提供されたら対応可能。2016/01/20 まで
            chohyoDataEntity.set交付事由名称(CodeMaster.getCodeMeisho(new CodeShubetsu("0002"), new Code(entity.getKofuJiyu())));
            chohyoDataEntity.set回収年月日(entity.getKaishuYMD().wareki()
                    .eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
            chohyoDataEntity.set回収事由コード(entity.getKofuJiyu());
            // TODO 張国朋 QA 499 回復から提供されたら対応可能。2016/01/20 まで
            chohyoDataEntity.set回収事由名称(CodeMaster.getCodeMeisho(new CodeShubetsu("0003"), new Code(entity.getKofuJiyu())));
            chohyoDataEntity.set有効期限((new RString(entity.getYukoKigenYMD().toString())));
            // TODO 張国朋 QA 54 回復から提供されたら対応可能。2016/01/20 まで
            chohyoDataEntity.set様式(ShoYoshikiKubun.toValue(entity.getShoYoshikiKubunCode()).get名称());
        }
        chohyoDataEntityList.add(chohyoDataEntity);
        return chohyoDataEntityList;
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
