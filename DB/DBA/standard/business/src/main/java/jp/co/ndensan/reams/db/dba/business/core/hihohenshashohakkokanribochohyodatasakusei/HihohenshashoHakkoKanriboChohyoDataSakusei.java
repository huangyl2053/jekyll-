/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihohenshashohakkokanribochohyodatasakusei;

import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.AkasiHakouKanriRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.HihokenshashoHakkoKanriIchiranhyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoYoshikiKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shutsuryokujun.ShutsuryokujunRelateEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
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
    private static final RString 被保険者証発行 = new RString("介護保険　被保険者証発行管理一覧表");
    private static final RString 資格者証発行 = new RString("介護保険　資格者証発行管理一覧表");

    /**
     * 証発行管理帳票データリスト作成します。
     *
     * @param entity 証発行管理情報
     * @param 出力順Entity 出力順情報
     * @return 証発行管理リスト帳票用データ
     */
    public HihokenshashoHakkoKanriIchiranhyoEntity getShohakkoKanriChohyoDataList(AkasiHakouKanriRelateEntity entity,
            ShutsuryokujunRelateEntity 出力順Entity) {
        HihokenshashoHakkoKanriIchiranhyoEntity chohyoDataEntity = new HihokenshashoHakkoKanriIchiranhyoEntity();
        chohyoDataEntity.setPrintTimeStamp(get印刷日時());
        chohyoDataEntity.setTitle(entity.getChouhouTitle());
        chohyoDataEntity.setShichosonCode(entity.getShichosonCode().value());
        chohyoDataEntity.setShichosonName(entity.getShichosonMeisho());
        chohyoDataEntity.setShutsuryokujun1(出力順Entity.get出力順1());
        chohyoDataEntity.setShutsuryokujun2(出力順Entity.get出力順2());
        chohyoDataEntity.setShutsuryokujun3(出力順Entity.get出力順3());
        chohyoDataEntity.setShutsuryokujun4(出力順Entity.get出力順4());
        chohyoDataEntity.setShutsuryokujun5(出力順Entity.get出力順5());
        chohyoDataEntity.setKaipage1(出力順Entity.get改頁項目1());
        chohyoDataEntity.setKaipage2(出力順Entity.get改頁項目2());
        chohyoDataEntity.setKaipage3(出力順Entity.get改頁項目3());
        chohyoDataEntity.setKaipage4(出力順Entity.get改頁項目4());
        chohyoDataEntity.setKaipage5(出力順Entity.get改頁項目5());
        chohyoDataEntity.setListUpper_1(entity.getAkasiHakouKanriEntity().getHihokenshaNo());
        chohyoDataEntity.setListUpper_2(entity.getAkasiHakouKanriEntity().getShikibetsuCode().value());
        UaFt200FindShikibetsuTaishoEntity uaFt200Entity = entity.getAkasiHakouKanriEntity().get宛名Entity();
        if (uaFt200Entity != null && uaFt200Entity.getMeisho() != null) {
            AtenaMeisho 氏名 = uaFt200Entity.getMeisho();
            YubinNo 郵便番号 = uaFt200Entity.getYubinNo();
            AtenaJusho 住所 = uaFt200Entity.getJusho();
            if (氏名 != null) {
                chohyoDataEntity.setListUpper_3(氏名.value());
            } else {
                chohyoDataEntity.setListUpper_3(RString.EMPTY);
            }
            if (郵便番号 != null) {
                chohyoDataEntity.setListLower_2(郵便番号.value());
            } else {
                chohyoDataEntity.setListLower_2(RString.EMPTY);
            }
            if (住所 != null) {
                chohyoDataEntity.setListLower_3(住所.value());
            } else {
                chohyoDataEntity.setListLower_3(RString.EMPTY);
            }
        } else {
            chohyoDataEntity.setListUpper_3(RString.EMPTY);
            chohyoDataEntity.setListLower_2(RString.EMPTY);
            chohyoDataEntity.setListLower_3(RString.EMPTY);
        }
        chohyoDataEntity.setListUpper_4(entity.getAkasiHakouKanriEntity().getKofuYMD() != null
                ? entity.getAkasiHakouKanriEntity().getKofuYMD().wareki().eraType(
                        EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(
                        Separator.PERIOD).fillType(FillType.BLANK).toDateString() : RString.EMPTY);
        chohyoDataEntity.setListUpper_5(entity.getAkasiHakouKanriEntity().getKofuJiyuCode().value());
        if (被保険者証発行.equals(entity.getChouhouTitle())) {
            chohyoDataEntity.setListUpper_7(CodeMaster.getCodeRyakusho(
                    SubGyomuCode.DBA介護資格,
                    DBACodeShubetsu.被保険者証交付事由.getコード(),
                    entity.getAkasiHakouKanriEntity().getKofuJiyuCode(),
                    FlexibleDate.getNowDate()));
            chohyoDataEntity.setListUpper_6(CodeMaster.getCodeMeisho(
                    SubGyomuCode.DBA介護資格,
                    DBACodeShubetsu.被保険者証交付事由.getコード(),
                    entity.getAkasiHakouKanriEntity().getKofuJiyuCode(),
                    FlexibleDate.getNowDate()));
            chohyoDataEntity.setListLower_6(CodeMaster.getCodeMeisho(
                    SubGyomuCode.DBA介護資格,
                    DBACodeShubetsu.被保険者証回収事由.getコード(),
                    entity.getAkasiHakouKanriEntity().getKaishuJiyuCode(),
                    FlexibleDate.getNowDate()));
        } else if (資格者証発行.equals(entity.getChouhouTitle())) {
            chohyoDataEntity.setListUpper_7(CodeMaster.getCodeRyakusho(
                    SubGyomuCode.DBA介護資格,
                    DBACodeShubetsu.資格者証交付事由.getコード(),
                    entity.getAkasiHakouKanriEntity().getKofuJiyuCode(),
                    FlexibleDate.getNowDate()));
            chohyoDataEntity.setListUpper_6(CodeMaster.getCodeMeisho(
                    SubGyomuCode.DBA介護資格,
                    DBACodeShubetsu.資格者証交付事由.getコード(),
                    entity.getAkasiHakouKanriEntity().getKofuJiyuCode(),
                    FlexibleDate.getNowDate()));
            chohyoDataEntity.setListLower_6(CodeMaster.getCodeMeisho(
                    SubGyomuCode.DBA介護資格,
                    DBACodeShubetsu.資格者証回収事由.getコード(),
                    entity.getAkasiHakouKanriEntity().getKaishuJiyuCode(),
                    FlexibleDate.getNowDate()));
        }
        chohyoDataEntity.setListLower_4(entity.getAkasiHakouKanriEntity().getKaishuYMD() != null
                ? entity.getAkasiHakouKanriEntity().getKaishuYMD().wareki().eraType(
                        EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(
                        Separator.PERIOD).fillType(FillType.BLANK).toDateString() : RString.EMPTY);
        chohyoDataEntity.setListLower_1(entity.getAkasiHakouKanriEntity().getShichosonCode().value());
        chohyoDataEntity.setListLower_5(entity.getAkasiHakouKanriEntity().getKaishuJiyuCode().value());
        chohyoDataEntity.setListUpper_8(entity.getAkasiHakouKanriEntity().getYukoKigenYMD() != null
                ? entity.getAkasiHakouKanriEntity().getYukoKigenYMD().wareki().eraType(
                        EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(
                        Separator.PERIOD).fillType(FillType.BLANK).toDateString() : RString.EMPTY);
        chohyoDataEntity.setListLower_7(RString.isNullOrEmpty(entity.getAkasiHakouKanriEntity().getShoYoshikiKubunCode())
                ? RString.EMPTY : ShoYoshikiKubun.toValue(entity.getAkasiHakouKanriEntity().getShoYoshikiKubunCode()).get名称());
        return chohyoDataEntity;
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

    /**
     * 帳票分類ID「DBA200004_HihokenshashoHakkoKanriIchiranhyo」（被保険者証発行管理一覧表）出力順設定可能項目です。
     */
    public enum ShutsuryokujunEnum implements IReportItems {

        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString("yubinNo"), new RString("\"ShikibetsuTaisho_yubinNo\"")),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString("choikiCode"), new RString("\"ShikibetsuTaisho_choikiCode\"")),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString("gyoseikuCode"), new RString("\"ShikibetsuTaisho_gyoseikuCode\"")),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString("listUpper_1"), new RString("\"shoKofuKaishu_hihokenshaNo\"")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString("listLower_1"), new RString("\"shoKofuKaishu_shichosonCode\"")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("kanaMeisho"), new RString("\"ShikibetsuTaisho_kanaMeisho\"")),
        /**
         * 交付年月日
         */
        交付年月日(new RString("0122"), new RString("listUpper_4"), new RString("\"shoKofuKaishu_kofuYMD\"")),
        /**
         * 交付事由
         */
        交付事由(new RString("0123"), new RString("listUpper_5"), new RString("\"shoKofuKaishu_kofuJiyu\"")),
        /**
         * 回収年月日
         */
        回収年月日(new RString("0124"), new RString("listLower_4"), new RString("\"shoKofuKaishu_kaishuYMD\"")),
        /**
         * 回収事由
         */
        回収事由(new RString("0125"), new RString("listLower_5"), new RString("\"shoKofuKaishu_kaishuJiyu\"")),
        /**
         * 有効期限
         */
        有効期限(new RString("0126"), new RString("listUpper_8"), new RString("\"shoKofuKaishu_yukoKigenYMD\""));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private ShutsuryokujunEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
            this.項目ID = 項目ID;
            this.フォームフィールド名 = フォームフィールド名;
            this.myBatis項目名 = myBatis項目名;
        }

        @Override
        public RString get項目ID() {
            return 項目ID;
        }

        @Override
        public RString getフォームフィールド名() {
            return フォームフィールド名;
        }

        @Override
        public RString getMyBatis項目名() {
            return myBatis項目名;
        }
    }
}
