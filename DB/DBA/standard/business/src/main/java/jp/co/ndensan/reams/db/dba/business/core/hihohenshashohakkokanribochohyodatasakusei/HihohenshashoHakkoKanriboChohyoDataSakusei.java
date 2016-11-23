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
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoYoshikiKubun;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 *
 * 被保険者証発行管理簿_帳票データ作成のクラスです。
 *
 * @reamsid_L DBA-0600-050 zhangguopeng
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HihohenshashoHakkoKanriboChohyoDataSakusei {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString DATE_作成 = new RString("作成");
    private static final RString 証発行モード_被保険者 = new RString("001");
    private static final RString 証発行モード_資格者 = new RString("002");
    private static final RString ハイフン = new RString("-");
    private static final int 郵便番号_0桁 = 0;
    private static final int 郵便番号_3桁 = 3;
    private final RStringBuilder 郵便番号 = new RStringBuilder();

    private static final int ソート順1 = 1;
    private static final int ソート順2 = 2;
    private static final int ソート順3 = 3;
    private static final int ソート順4 = 4;
    private static final int ソート順5 = 5;

    /**
     * 証発行管理帳票データリスト作成します。
     *
     * @param relateEntityList 証発行管理リスト情報EntityList
     * @param order ソート順
     * @return List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity>
     * 証発行管理リスト帳票用データリスト
     */
    public List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity> getShohakkoKanriChohyoDataList(
            AkasiHakouKanriRelateEntity relateEntityList, List<ISetSortItem> order) {
        List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity> chohyoDataEntityList = new ArrayList<>();
        if (!relateEntityList.getAkasiHakouKanriEntityList().isEmpty()) {
            for (AkasiHakouKanriEntity entity : relateEntityList.getAkasiHakouKanriEntityList()) {

                HihohenshashoHakkoKanriboChohyoDataSakuseiEntity chohyoDataEntity = craeteEntity(relateEntityList, entity, order);
                chohyoDataEntity.set被保険者番号(entity.getHihokenshaNo());
                chohyoDataEntity.set識別コード(entity.getShikibetsuCode().value());
                if (!(RString.isNullOrEmpty(entity.getYubinNo()))) {
                    郵便番号.append(entity.getYubinNo().substring(郵便番号_0桁, 郵便番号_3桁));
                    郵便番号.append(ハイフン);
                    郵便番号.append(entity.getYubinNo().substring(郵便番号_3桁, entity.getYubinNo().length()));
                    chohyoDataEntity.set郵便番号(郵便番号.toRString());
                    郵便番号.delete(郵便番号_0桁, 郵便番号.length());
                } else {
                    chohyoDataEntity.set郵便番号(YubinNo.EMPTY.getColumnValue());
                }
                chohyoDataEntity.set氏名(entity.getMeisho());
                chohyoDataEntity.set住所(entity.getJusho());
                chohyoDataEntity.set市町村コードListYou(entity.getShichosonCode().value());

                chohyoDataEntity.set交付事由コード(entity.getKofuJiyu());
                if (証発行モード_被保険者.equals(relateEntityList.getAkasihakoumode())) {
                    chohyoDataEntity.set交付事由略称(CodeMaster.getCodeRyakusho(
                            SubGyomuCode.DBA介護資格,
                            DBACodeShubetsu.被保険者証交付事由.getコード(),
                            new Code(entity.getKofuJiyu()),
                            FlexibleDate.getNowDate()));
                    chohyoDataEntity.set交付事由名称(CodeMaster.getCodeMeisho(
                            SubGyomuCode.DBA介護資格,
                            DBACodeShubetsu.被保険者証交付事由.getコード(),
                            new Code(entity.getKofuJiyu()),
                            FlexibleDate.getNowDate()));
                    chohyoDataEntity.set回収事由名称(CodeMaster.getCodeMeisho(
                            SubGyomuCode.DBA介護資格,
                            DBACodeShubetsu.被保険者証回収事由.getコード(),
                            new Code(entity.getKaishuJiyu()),
                            FlexibleDate.getNowDate()));
                } else if (証発行モード_資格者.equals(relateEntityList.getAkasihakoumode())) {
                    chohyoDataEntity.set交付事由略称(CodeMaster.getCodeRyakusho(
                            SubGyomuCode.DBA介護資格,
                            DBACodeShubetsu.資格者証交付事由.getコード(),
                            new Code(entity.getKofuJiyu()),
                            FlexibleDate.getNowDate()));
                    chohyoDataEntity.set交付事由名称(CodeMaster.getCodeMeisho(
                            SubGyomuCode.DBA介護資格,
                            DBACodeShubetsu.資格者証交付事由.getコード(),
                            new Code(entity.getKofuJiyu()),
                            FlexibleDate.getNowDate()));
                    chohyoDataEntity.set回収事由名称(CodeMaster.getCodeMeisho(
                            SubGyomuCode.DBA介護資格,
                            DBACodeShubetsu.資格者証回収事由.getコード(),
                            new Code(entity.getKaishuJiyu()),
                            FlexibleDate.getNowDate()));
                }
                chohyoDataEntity.set回収年月日Str(entity.getKaishuYMD() != null ? entity.getKaishuYMD().wareki().eraType(
                        EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(
                                Separator.PERIOD).fillType(FillType.BLANK).toDateString() : RString.EMPTY);
                chohyoDataEntity.set回収年月日(entity.getKaishuYMD() != null ? entity.getKaishuYMD() : FlexibleDate.EMPTY);
                chohyoDataEntity.set回収事由コード(entity.getKaishuJiyu());

                chohyoDataEntity.set交付年月日Str(entity.getKofuYMD() != null ? entity.getKofuYMD().wareki().eraType(
                        EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(
                                Separator.PERIOD).fillType(FillType.BLANK).toDateString() : RString.EMPTY);
                chohyoDataEntity.set交付年月日(entity.getKofuYMD() != null ? entity.getKofuYMD() : FlexibleDate.EMPTY);

                chohyoDataEntity.set有効期限Str(entity.getYukoKigenYMD() != null ? entity.getYukoKigenYMD().wareki().eraType(
                        EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(
                                Separator.PERIOD).fillType(FillType.BLANK).toDateString() : RString.EMPTY);
                chohyoDataEntity.set有効期限(entity.getYukoKigenYMD() != null ? entity.getYukoKigenYMD() : FlexibleDate.EMPTY);

                chohyoDataEntity.set様式(RString.isNullOrEmpty(entity.getShoYoshikiKubunCode())
                        ? RString.EMPTY : ShoYoshikiKubun.toValue(entity.getShoYoshikiKubunCode()).get名称());
                chohyoDataEntity.set連番(entity.getRenban());

                chohyoDataEntityList.add(chohyoDataEntity);
            }
        } else {
            chohyoDataEntityList.add(craeteEntity(relateEntityList, null, order));
        }
        return chohyoDataEntityList;
    }

    private HihohenshashoHakkoKanriboChohyoDataSakuseiEntity craeteEntity(AkasiHakouKanriRelateEntity relateEntityList,
            AkasiHakouKanriEntity entity, List<ISetSortItem> order) {
        HihohenshashoHakkoKanriboChohyoDataSakuseiEntity chohyoDataEntity = new HihohenshashoHakkoKanriboChohyoDataSakuseiEntity();
        chohyoDataEntity.set印刷日時(get印刷日時());
        chohyoDataEntity.set帳票タイトル(relateEntityList.getChouhouTitle());
        chohyoDataEntity.set市町村コード(relateEntityList.getShichosonCode().value());
        chohyoDataEntity.set市町村名(relateEntityList.getShichosonMeisho());

        int limit = order.size() < ソート順5 ? order.size() : ソート順5;

        for (int i = 0; i < limit; i++) {
            ISetSortItem sortItem = order.get(i);
            if (i + 1 == ソート順1) {
                chohyoDataEntity.setソート順１(sortItem.get項目名());
                if (sortItem.is改頁項目() && entity != null) {
                    chohyoDataEntity.set改頁１(entity.getPageBreakItem1());
                }
            } else if (i + 1 == ソート順2) {
                chohyoDataEntity.setソート順２(sortItem.get項目名());
                if (sortItem.is改頁項目() && entity != null) {
                    chohyoDataEntity.set改頁２(entity.getPageBreakItem2());
                }
            } else if (i + 1 == ソート順3) {
                chohyoDataEntity.setソート順３(sortItem.get項目名());
                if (sortItem.is改頁項目() && entity != null) {
                    chohyoDataEntity.set改頁３(entity.getPageBreakItem3());
                }
            } else if (i + 1 == ソート順4) {
                chohyoDataEntity.setソート順４(sortItem.get項目名());
                if (sortItem.is改頁項目() && entity != null) {
                    chohyoDataEntity.set改頁４(entity.getPageBreakItem4());
                }
            } else if (i + 1 == ソート順5) {
                chohyoDataEntity.setソート順５(sortItem.get項目名());
                if (sortItem.is改頁項目() && entity != null) {
                    chohyoDataEntity.set改頁５(entity.getPageBreakItem5());
                }
            }
        }
        chohyoDataEntity.set隠し改頁項目(RString.EMPTY);

        return chohyoDataEntity;
    }

    /**
     * 証発行管理帳票ボディデータリスト作成します。
     *
     * @param relateEntityList 証発行管理リスト情報EntityList
     * @param order ソート順
     * @return List<HihokenshashoHakkoKanriIchiranhyoBodyItem>
     * 証発行管理リスト帳票用ボディデータリスト
     */
    public List<HihokenshashoHakkoKanriIchiranhyoBodyItem> setShohakkoKanriChohyoDataList(
            AkasiHakouKanriRelateEntity relateEntityList, List<ISetSortItem> order) {
        List<HihokenshashoHakkoKanriIchiranhyoBodyItem> list = new ArrayList();
        List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity> chohyoDataEntityList
                = getShohakkoKanriChohyoDataList(relateEntityList, order);
        for (HihohenshashoHakkoKanriboChohyoDataSakuseiEntity entity : chohyoDataEntityList) {
            HihokenshashoHakkoKanriIchiranhyoBodyItem bodyItem = new HihokenshashoHakkoKanriIchiranhyoBodyItem(
                    entity.get被保険者番号(),
                    entity.get識別コード(),
                    entity.get氏名(),
                    entity.get交付年月日Str(),
                    entity.get交付事由コード(),
                    entity.get交付事由名称(),
                    entity.get交付事由略称(),
                    entity.get有効期限Str(),
                    entity.get市町村コードListYou(),
                    entity.get郵便番号(),
                    entity.get住所(),
                    entity.get回収年月日Str(),
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
