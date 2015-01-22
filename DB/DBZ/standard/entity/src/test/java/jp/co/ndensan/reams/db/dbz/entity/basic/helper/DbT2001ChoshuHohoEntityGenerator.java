/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.code.kyotsu.TokubetsuChoshuTeishiJiyu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護徴収方法エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT2001ChoshuHohoEntityGenerator {

    public static final FlexibleYear DEFAULT_賦課年度 = new FlexibleYear("2014");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final RDateTime DEFAULT_処理日時 = RDateTime.of(2014, 9, 01, 10, 20, 30, 123);
    public static final RString DEFAULT_徴収方法4月 = new RString("1");
    public static final RString DEFAULT_徴収方法5月 = new RString("1");
    public static final RString DEFAULT_徴収方法6月 = new RString("1");
    public static final RString DEFAULT_徴収方法7月 = new RString("1");
    public static final RString DEFAULT_徴収方法8月 = new RString("1");
    public static final RString DEFAULT_徴収方法9月 = new RString("1");
    public static final RString DEFAULT_徴収方法10月 = new RString("1");
    public static final RString DEFAULT_徴収方法11月 = new RString("1");
    public static final RString DEFAULT_徴収方法12月 = new RString("1");
    public static final RString DEFAULT_徴収方法1月 = new RString("1");
    public static final RString DEFAULT_徴収方法2月 = new RString("1");
    public static final RString DEFAULT_徴収方法3月 = new RString("1");
    public static final RString DEFAULT_徴収方法翌4月 = new RString("1");
    public static final RString DEFAULT_徴収方法翌5月 = new RString("1");
    public static final RString DEFAULT_徴収方法翌6月 = new RString("1");
    public static final RString DEFAULT_徴収方法翌7月 = new RString("1");
    public static final RString DEFAULT_徴収方法翌8月 = new RString("1");
    public static final RString DEFAULT_徴収方法翌9月 = new RString("1");
    public static final RString DEFAULT_仮徴収_基礎年金番号 = new RString("1");
    public static final RString DEFAULT_仮徴収_年金コード = new RString("1");
    public static final RString DEFAULT_仮徴収_捕捉月 = new RString("1");
    public static final RString DEFAULT_本徴収_基礎年金番号 = new RString("1");
    public static final RString DEFAULT_本徴収_年金コード = new RString("1");
    public static final RString DEFAULT_本徴収_捕捉月 = new RString("1");
    public static final RString DEFAULT_翌年度仮徴収_基礎年金番号 = new RString("1");
    public static final RString DEFAULT_翌年度仮徴収_年金コード = new RString("1");
    public static final RString DEFAULT_翌年度仮徴収_捕捉月 = new RString("1");
    public static final boolean DEFAULT_依頼情報送付済みフラグ = false;
    public static final boolean DEFAULT_追加依頼情報送付済みフラグ = false;
    public static final YMDHMS DEFAULT_特別徴収停止日時 = new YMDHMS(new RString("20140415102030"));
    public static final TokubetsuChoshuTeishiJiyu DEFAULT_特別徴収停止事由 = new TokubetsuChoshuTeishiJiyu(new RString("1"));

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT2001ChoshuHohoEntityGenerator() {
    }

    public static DbT2001ChoshuHohoEntity createDbT2001ChoshuHohoEntity() {
        DbT2001ChoshuHohoEntity entity = new DbT2001ChoshuHohoEntity();
        entity.setFukaNendo(DEFAULT_賦課年度);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setChoshuHoho4gatsu(DEFAULT_徴収方法4月);
        entity.setChoshuHoho5gatsu(DEFAULT_徴収方法5月);
        entity.setChoshuHoho6gatsu(DEFAULT_徴収方法6月);
        entity.setChoshuHoho7gatsu(DEFAULT_徴収方法7月);
        entity.setChoshuHoho8gatsu(DEFAULT_徴収方法8月);
        entity.setChoshuHoho9gatsu(DEFAULT_徴収方法9月);
        entity.setChoshuHoho10gatsu(DEFAULT_徴収方法10月);
        entity.setChoshuHoho11gatsu(DEFAULT_徴収方法11月);
        entity.setChoshuHoho12gatsu(DEFAULT_徴収方法12月);
        entity.setChoshuHoho1gatsu(DEFAULT_徴収方法1月);
        entity.setChoshuHoho2gatsu(DEFAULT_徴収方法2月);
        entity.setChoshuHoho3gatsu(DEFAULT_徴収方法3月);
        entity.setChoshuHohoYoku4gatsu(DEFAULT_徴収方法翌4月);
        entity.setChoshuHohoYoku5gatsu(DEFAULT_徴収方法翌5月);
        entity.setChoshuHohoYoku6gatsu(DEFAULT_徴収方法翌6月);
        entity.setChoshuHohoYoku7gatsu(DEFAULT_徴収方法翌7月);
        entity.setChoshuHohoYoku8gatsu(DEFAULT_徴収方法翌8月);
        entity.setChoshuHohoYoku9gatsu(DEFAULT_徴収方法翌9月);
        entity.setKariNenkinNo(DEFAULT_仮徴収_基礎年金番号);
        entity.setKariNenkinCode(DEFAULT_仮徴収_年金コード);
        entity.setKariHosokuM(DEFAULT_仮徴収_捕捉月);
        entity.setHonNenkinNo(DEFAULT_本徴収_基礎年金番号);
        entity.setHonNenkinCode(DEFAULT_本徴収_年金コード);
        entity.setHonHosokuM(DEFAULT_本徴収_捕捉月);
        entity.setYokunendoKariNenkinNo(DEFAULT_翌年度仮徴収_基礎年金番号);
        entity.setYokunendoKariNenkinCode(DEFAULT_翌年度仮徴収_年金コード);
        entity.setYokunendoKariHosokuM(DEFAULT_翌年度仮徴収_捕捉月);
        entity.setIraiSohuzumiFlag(DEFAULT_依頼情報送付済みフラグ);
        entity.setTsuikaIraiSohuzumiFlag(DEFAULT_追加依頼情報送付済みフラグ);
        entity.setTokuchoTeishiTimestamp(DEFAULT_特別徴収停止日時);
        entity.setTokuchoTeishiJiyuCode(DEFAULT_特別徴収停止事由);
        return entity;
    }
}
