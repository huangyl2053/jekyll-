/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.tennyutenshutsumitorokuichiranhyo;

import jp.co.ndensan.reams.db.dba.business.report.tennyutenshutsumitorokuichiranhyo.TennyuTenshutsuMiTorokuIchiranhyoBodyItem;
import jp.co.ndensan.reams.db.dba.definition.core.shikakuidomishorisha.TennyuSakuseiJiyu;
import jp.co.ndensan.reams.db.dba.definition.core.shikakuidomishorisha.TenshutsuSakuseiJiyu;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tennyutenshuhosyutaisyosya.TennyuHosyutaiSyosyaEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.tennyutenshuhosyutaisyosya.TennyuTenshutsuMitorokuIchiranhyoEucCsvEntity;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 転入転出未登録一覧表のビジネスです。
 *
 * @reamsid_L DBU-4110-030 yaodongsheng
 */
public class TennyuTenshutsuMiTorokuIchiranhyoResult {

    private static final RString フラグ1 = new RString("1");
    private static final RString 住所地特例フラグ1 = new RString("住所地特例");
    private static final RString 転入 = new RString("転入不一致");

    /**
     * CSVentityと帳票item
     *
     * @param entity 転入転出entity
     * @param csvEntity 転入転出CSVentity
     * @param bodyItem 帳票bodyitem
     */
    public void setNyuBodyItem(TennyuHosyutaiSyosyaEntity entity,
            TennyuTenshutsuMitorokuIchiranhyoEucCsvEntity csvEntity, TennyuTenshutsuMiTorokuIchiranhyoBodyItem bodyItem) {
        RString データ内容 = entity.getデータ内容();
        csvEntity.setDatanaiyo(entity.getデータ内容());
        bodyItem.setデータ内容(entity.getデータ内容());
        csvEntity.setShikibetsuCode(entity.get識別コード());
        bodyItem.set識別コード(entity.get識別コード());
        csvEntity.setSetaiCode(entity.get世帯コード());
        bodyItem.set世帯コード(entity.get世帯コード());
        RString 市町村コード = entity.get市町村コード();
        csvEntity.setShichosonCode(市町村コード);
        bodyItem.set市町村コード(市町村コード);
        RString 市町村名 = RString.isNullOrEmpty(entity.get市町村名()) ? RString.EMPTY : entity.get市町村名();
        csvEntity.setShichosonName(市町村名);
        bodyItem.set市町村名(市町村名);
        csvEntity.setKanaShimei(entity.get宛名カナ氏名());
        bodyItem.setカナ氏名(entity.get宛名カナ氏名());
        csvEntity.setShimei(entity.get宛名氏名());
        bodyItem.set氏名(entity.get宛名氏名());
        RString 住民状態コード = entity.get住民状態コード();
        RString 住民状態 = RString.isNullOrEmpty(住民状態コード) ? RString.EMPTY : JuminJotai.toValue(住民状態コード).住民状態略称();
        csvEntity.setJuminJotai(住民状態);
        bodyItem.set住民状態(住民状態);
        RString 年月日 = entity.get生年月日();
        RString 生年月日 = RString.isNullOrEmpty(年月日) ? RString.EMPTY : format(年月日);
        csvEntity.setSeinengappiYMD(生年月日);
        bodyItem.set生年月日(生年月日);
        RString 性別コード = entity.get性別コード();
        RString 性別 = RString.isNullOrEmpty(性別コード) ? RString.EMPTY : Gender.toValue(性別コード).getCommonName();
        csvEntity.setSeibetsu(性別);
        bodyItem.set性別(性別);
        RString 異動事由コード = entity.get異動事由コード();
        csvEntity.setIdoJiyuCode(異動事由コード);
        bodyItem.set異動事由コード(異動事由コード);
        RString 異動事由 = RString.isNullOrEmpty(異動事由コード) ? RString.EMPTY : JukiIdoJiyu.toValue(異動事由コード).get異動事由略称();
        csvEntity.setIdoJiyu(異動事由);
        bodyItem.set異動事由(異動事由);
        RString 登録異動年月日 = entity.get登録異動年月日();
        RString 登録異動日 = RString.isNullOrEmpty(登録異動年月日) ? RString.EMPTY : format(登録異動年月日);
        csvEntity.setTorokuIdoYMD(登録異動日);
        bodyItem.set登録異動日(登録異動日);
        RString 登録届出年月日 = entity.get登録異動届出年月日();
        RString 登録届出日 = RString.isNullOrEmpty(登録届出年月日) ? RString.EMPTY : format(登録届出年月日);
        csvEntity.setTorokuTodokedeYMD(登録届出日);
        bodyItem.set登録届出日(登録届出日);
        RString 住所地特例 = entity.get住所地特例フラグ();
        if (フラグ1.equals(住所地特例)) {
            住所地特例 = 住所地特例フラグ1;
        } else {
            住所地特例 = RString.EMPTY;
        }
        csvEntity.setJushochiTokurei(住所地特例);
        bodyItem.set住所地特例(住所地特例);
        RString 消除異動年月日 = entity.get消除異動年月日();
        RString 消除異動日 = RString.isNullOrEmpty(消除異動年月日) ? RString.EMPTY : format(消除異動年月日);
        csvEntity.setShojoIdoYMD(消除異動日);
        bodyItem.set消除異動日(消除異動日);
        RString 消除届出年月日 = entity.get消除異動届出年月日();
        RString 消除届出日 = RString.isNullOrEmpty(消除届出年月日) ? RString.EMPTY : format(消除届出年月日);
        csvEntity.setShojoTodokedeYMD(消除届出日);
        bodyItem.set消除届出日(消除届出日);
        RString 転出予定異動年月日 = entity.get転出予定異動年月日();
        RString 転出予定異動日 = RString.isNullOrEmpty(転出予定異動年月日) ? RString.EMPTY : format(転出予定異動年月日);
        csvEntity.setTenshutsuYoteiIdoYMD(転出予定異動日);
        bodyItem.set転出予定異動日(転出予定異動日);
        RStringBuilder 住所 = new RStringBuilder();
        住所.append(entity.get住所()).append(entity.get番地()).append(entity.get方書());
        csvEntity.setJusho(住所.toRString());
        bodyItem.set住所(住所.toRString());
        RStringBuilder 転出予定住所前住所 = new RStringBuilder();
        転出予定住所前住所.append(entity.get予定前住所住所()).append(entity.get予定前住所番地()).append(entity.get予定前住所方書());
        csvEntity.setTenshutsuYoteiJusho(転出予定住所前住所.toRString());
        bodyItem.set転出予定住所前住所(転出予定住所前住所.toRString());
        RString 作成事由コード = entity.get作成事由コード();
        csvEntity.setSakuseiJiyuCode(作成事由コード);
        bodyItem.set作成事由コードMiddle(作成事由コード);
        RString 作成事由;
        if (転入.equals(データ内容)) {
            作成事由 = RString.isNullOrEmpty(作成事由コード) ? RString.EMPTY : TennyuSakuseiJiyu.toValue(作成事由コード).get名称();
        } else {
            作成事由 = RString.isNullOrEmpty(作成事由コード) ? RString.EMPTY : TenshutsuSakuseiJiyu.toValue(作成事由コード).get名称();
        }
        csvEntity.setSakuseiJiyu(作成事由);
        bodyItem.set作成事由Middle(作成事由);
        bodyItem.set全国住所コード(entity.get全国住所コード());
    }

    private RString format(RString 年月日) {
        return new FlexibleDate(年月日).wareki().eraType(EraType.KANJI_RYAKU)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    /**
     * 帳票分類ID「DBA200014_TennyuTenshutsuMitorokuIchiranhyo」転入・転出未登録一覧表出力順設定可能項目です。
     */
    public enum ShutsuryokujunEnum implements IReportItems {

        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString("listLower_7"), new RString("全国住所コード")),
        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString("listLower_1"), new RString("世帯コード")),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString("listMiddle_1"), new RString("識別コード")),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString("listMiddle_2"), new RString("宛名カナ氏名")),
        /**
         * 生年月日
         */
        生年月日(new RString("0012"), new RString("listMiddle_3"), new RString("生年月日")),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString("listUpper_2"), new RString("市町村コード"));

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
