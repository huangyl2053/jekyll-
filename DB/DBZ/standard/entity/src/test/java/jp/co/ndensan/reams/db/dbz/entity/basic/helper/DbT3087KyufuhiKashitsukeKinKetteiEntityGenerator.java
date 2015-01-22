/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3087KyufuhiKashitsukeKinKetteiEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付費貸付金決定エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("02"));
    public static final FlexibleDate DEFAULT_借入申請年月日 = new FlexibleDate("20140402");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final FlexibleDate DEFAULT_貸付審査決定年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_貸付承認_不承認区分 = new RString("1");
    public static final RString DEFAULT_貸付管理番号 = new RString("123");
    public static final Decimal DEFAULT_貸付金額 = new Decimal(10000);
    public static final RString DEFAULT_償還方法 = new RString("1");
    public static final FlexibleDate DEFAULT_償還期限 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_貸付年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_貸付支払方法 = new RString("1");
    public static final RString DEFAULT_貸付窓口支払場所 = new RString("123");
    public static final FlexibleDate DEFAULT_貸付窓口開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_貸付窓口終了年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_貸付窓口閉庁内容 = new RString("123");
    public static final RString DEFAULT_貸付窓口開始時間 = new RString("2014");
    public static final RString DEFAULT_貸付窓口終了時間 = new RString("2015");
    public static final RString DEFAULT_貸付不承認理由 = new RString("1");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3087KyufuhiKashitsukeKinKetteiEntityGenerator() {
    }

    public static DbT3087KyufuhiKashitsukeKinKetteiEntity createDbT3087KyufuhiKashitsukeKinKetteiEntity() {
        DbT3087KyufuhiKashitsukeKinKetteiEntity entity = new DbT3087KyufuhiKashitsukeKinKetteiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setKariireShinseiYMD(DEFAULT_借入申請年月日);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setKashitsukeShinsaKetteiYMD(DEFAULT_貸付審査決定年月日);
        entity.setKashitsukeShonin_FuShoninKubun(DEFAULT_貸付承認_不承認区分);
        entity.setKashitsukeKanriNo(DEFAULT_貸付管理番号);
        entity.setKashitsukeKingaku(DEFAULT_貸付金額);
        entity.setShokanHoho(DEFAULT_償還方法);
        entity.setShokanKigenYMD(DEFAULT_償還期限);
        entity.setKashitsukeYMD(DEFAULT_貸付年月日);
        entity.setKashitsukeShiharaiHoho(DEFAULT_貸付支払方法);
        entity.setKashitsukeMadoguchiShiharaiBasho(DEFAULT_貸付窓口支払場所);
        entity.setKashitsukeMadoguchiKaishiYMD(DEFAULT_貸付窓口開始年月日);
        entity.setKashitsukeMadoguchiShuryoYMD(DEFAULT_貸付窓口終了年月日);
        entity.setKashitsukeMadoguchiHeichoNaiyo(DEFAULT_貸付窓口閉庁内容);
        entity.setKashitsukeMadoguchiKaishiTime(DEFAULT_貸付窓口開始時間);
        entity.setKashitsukeMadoguchiShuryoTime(DEFAULT_貸付窓口終了時間);
        entity.setKashitsukeFuShoninRiyu(DEFAULT_貸付不承認理由);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        return entity;
    }
}
