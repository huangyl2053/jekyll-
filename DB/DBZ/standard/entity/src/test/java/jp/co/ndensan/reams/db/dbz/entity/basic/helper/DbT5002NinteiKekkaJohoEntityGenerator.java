/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5002NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定結果情報エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n8187 久保田 英男
 */
public final class DbT5002NinteiKekkaJohoEntityGenerator {

    public static final RString DEFAULT_申請書管理番号 = new RString("1234567890");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS("20140101102030");
    public static final RString DEFAULT_証記載保険者番号 = new RString("123456");
    public static final RString DEFAULT_被保険者番号 = new RString("1234567890");
    public static final FlexibleDate DEFAULT_要介護度認定年月日 = new FlexibleDate("20150102");
    public static final Code DEFAULT_要介護状態区分コード = new Code("1");
    public static final int DEFAULT_認定有効期間 = 1;
    public static final FlexibleDate DEFAULT_認定有効期間開始年月日 = new FlexibleDate("20150102");
    public static final FlexibleDate DEFAULT_認定有効期間終了年月日 = new FlexibleDate("20150102");
    public static final Code DEFAULT_介護保険の特定疾病コード = new Code("1");
    public static final boolean DEFAULT_施設入所の有無 = true;
    public static final int DEFAULT_介護認定審査会開催番号 = 1;
    public static final RString DEFAULT_介護認定審査会意見 = new RString("1");
    public static final RString DEFAULT_一次判定結果変更理由 = new RString("意見");
    public static final Code DEFAULT_要介護状態像例コード = new Code("1");
    public static final RString DEFAULT_認定審査会意見種類 = new RString("1");
    public static final RString DEFAULT_介護サービス種類01 = new RString("1");
    public static final RString DEFAULT_介護サービス種類02 = new RString("1");
    public static final RString DEFAULT_介護サービス種類03 = new RString("1");
    public static final RString DEFAULT_介護サービス種類04 = new RString("1");
    public static final RString DEFAULT_介護サービス種類05 = new RString("1");
    public static final RString DEFAULT_介護サービス種類06 = new RString("1");
    public static final RString DEFAULT_介護サービス種類07 = new RString("1");
    public static final RString DEFAULT_介護サービス種類08 = new RString("1");
    public static final RString DEFAULT_介護サービス種類09 = new RString("1");
    public static final RString DEFAULT_介護サービス種類10 = new RString("1");
    public static final RString DEFAULT_介護サービス種類11 = new RString("1");
    public static final RString DEFAULT_介護サービス種類12 = new RString("1");
    public static final RString DEFAULT_介護サービス種類13 = new RString("1");
    public static final RString DEFAULT_介護サービス種類14 = new RString("1");
    public static final RString DEFAULT_介護サービス種類15 = new RString("1");
    public static final RString DEFAULT_介護サービス種類16 = new RString("1");
    public static final RString DEFAULT_介護サービス種類17 = new RString("1");
    public static final RString DEFAULT_介護サービス種類18 = new RString("1");
    public static final RString DEFAULT_介護サービス種類19 = new RString("1");
    public static final RString DEFAULT_介護サービス種類20 = new RString("1");
    public static final RString DEFAULT_介護サービス種類21 = new RString("1");
    public static final RString DEFAULT_介護サービス種類22 = new RString("1");
    public static final RString DEFAULT_介護サービス種類23 = new RString("1");
    public static final RString DEFAULT_介護サービス種類24 = new RString("1");
    public static final RString DEFAULT_介護サービス種類25 = new RString("1");
    public static final RString DEFAULT_介護サービス種類26 = new RString("1");
    public static final RString DEFAULT_介護サービス種類27 = new RString("1");
    public static final RString DEFAULT_介護サービス種類28 = new RString("1");
    public static final RString DEFAULT_介護サービス種類29 = new RString("1");
    public static final RString DEFAULT_介護サービス種類30 = new RString("1");
    public static final RString DEFAULT_要介護認定結果異動事由 = new RString("1");
    public static final FlexibleDate DEFAULT_要介護認定結果異動年月日 = new FlexibleDate("20150102");
    public static final RString DEFAULT_要介護認定取消理由 = new RString("1");
    public static final FlexibleDate DEFAULT_要介護認定取消年月日 = new FlexibleDate("20150102");
    public static final RString DEFAULT_通知区分 = new RString("1");
    public static final RString DEFAULT_認定理由 = new RString("1");
    public static final RString DEFAULT_審査会メモ = new RString("1");
    public static final FlexibleDate DEFAULT_IF送付年月日 = new FlexibleDate("20150102");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5002NinteiKekkaJohoEntityGenerator() {
    }

    public static DbT5002NinteiKekkaJohoEntity createDbT5002NinteiKekkaJohoEntity() {
        DbT5002NinteiKekkaJohoEntity entity = new DbT5002NinteiKekkaJohoEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setYoukaigodoNinteiYMD(DEFAULT_要介護度認定年月日);
        entity.setYoukaigoJotaiKubunCode(DEFAULT_要介護状態区分コード);
        entity.setNinteiYukoKikan(DEFAULT_認定有効期間);
        entity.setNinteiYukoKaishiYMD(DEFAULT_認定有効期間開始年月日);
        entity.setNinteiYukoShuryoYMD(DEFAULT_認定有効期間終了年月日);
        entity.setTokuteiShippeiCode(DEFAULT_介護保険の特定疾病コード);
        entity.setShisetsuNyushoFlag(DEFAULT_施設入所の有無);
        entity.setShinsakaiKaisaiNo(DEFAULT_介護認定審査会開催番号);
        entity.setShinsakaiIken(DEFAULT_介護認定審査会意見);
        entity.setIchijiHnateiKekkaHenkoRiyu(DEFAULT_一次判定結果変更理由);
        entity.setYokaigoJotaizoReiCode(DEFAULT_要介護状態像例コード);
        entity.setNinteishinsakaiIkenShurui(DEFAULT_認定審査会意見種類);
        entity.setKaigoServiceShurui01(DEFAULT_介護サービス種類01);
        entity.setKaigoServiceShurui02(DEFAULT_介護サービス種類02);
        entity.setKaigoServiceShurui03(DEFAULT_介護サービス種類03);
        entity.setKaigoServiceShurui04(DEFAULT_介護サービス種類04);
        entity.setKaigoServiceShurui05(DEFAULT_介護サービス種類05);
        entity.setKaigoServiceShurui06(DEFAULT_介護サービス種類06);
        entity.setKaigoServiceShurui07(DEFAULT_介護サービス種類07);
        entity.setKaigoServiceShurui08(DEFAULT_介護サービス種類08);
        entity.setKaigoServiceShurui09(DEFAULT_介護サービス種類09);
        entity.setKaigoServiceShurui10(DEFAULT_介護サービス種類10);
        entity.setKaigoServiceShurui11(DEFAULT_介護サービス種類11);
        entity.setKaigoServiceShurui12(DEFAULT_介護サービス種類12);
        entity.setKaigoServiceShurui13(DEFAULT_介護サービス種類13);
        entity.setKaigoServiceShurui14(DEFAULT_介護サービス種類14);
        entity.setKaigoServiceShurui15(DEFAULT_介護サービス種類15);
        entity.setKaigoServiceShurui16(DEFAULT_介護サービス種類16);
        entity.setKaigoServiceShurui17(DEFAULT_介護サービス種類17);
        entity.setKaigoServiceShurui18(DEFAULT_介護サービス種類18);
        entity.setKaigoServiceShurui19(DEFAULT_介護サービス種類19);
        entity.setKaigoServiceShurui20(DEFAULT_介護サービス種類20);
        entity.setKaigoServiceShurui21(DEFAULT_介護サービス種類21);
        entity.setKaigoServiceShurui22(DEFAULT_介護サービス種類22);
        entity.setKaigoServiceShurui23(DEFAULT_介護サービス種類23);
        entity.setKaigoServiceShurui24(DEFAULT_介護サービス種類24);
        entity.setKaigoServiceShurui25(DEFAULT_介護サービス種類25);
        entity.setKaigoServiceShurui26(DEFAULT_介護サービス種類26);
        entity.setKaigoServiceShurui27(DEFAULT_介護サービス種類27);
        entity.setKaigoServiceShurui28(DEFAULT_介護サービス種類28);
        entity.setKaigoServiceShurui29(DEFAULT_介護サービス種類29);
        entity.setKaigoServiceShurui30(DEFAULT_介護サービス種類30);
        entity.setNinteiKekkaIdoJiyu(DEFAULT_要介護認定結果異動事由);
        entity.setNinteiKekkaIdoYMD(DEFAULT_要介護認定結果異動年月日);
        entity.setNinteiTorikeshiRiyu(DEFAULT_要介護認定取消理由);
        entity.setNinteiTorikeshiYMD(DEFAULT_要介護認定取消年月日);
        entity.setTuchiKubun(DEFAULT_通知区分);
        entity.setNinteiRiyu(DEFAULT_認定理由);
        entity.setShinsakaiMemo(DEFAULT_審査会メモ);
        entity.setIfSofuYMD(DEFAULT_IF送付年月日);
        return entity;
    }
}
