/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3080DaisanshaKoiJidanEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護第三者行為示談エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT3080DaisanshaKoiJidanEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("01234567"));
    public static final RString DEFAULT_第三者行為届出管理番号 = new RString("123");
    public static final FlexibleDate DEFAULT_示談報告書受付年月日 = new FlexibleDate("20140402");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final RString DEFAULT_第三者行為求償協議区分 = new RString("3");
    public static final FlexibleDate DEFAULT_示談報告書提出年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_示談成立年月日 = new FlexibleDate("20140402");
    public static final FlexibleYearMonth DEFAULT_給付期間開始年月 = new FlexibleYearMonth(new RString("201402"));
    public static final FlexibleYearMonth DEFAULT_給付期間終了年月 = new FlexibleYearMonth(new RString("201502"));
    public static final RString DEFAULT_過失割合_加害者 = new RString("1");
    public static final RString DEFAULT_過失割合_被害者 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3080DaisanshaKoiJidanEntityGenerator() {
    }

    public static DbT3080DaisanshaKoiJidanEntity createDbT3080DaisanshaKoiJidanEntity() {
        DbT3080DaisanshaKoiJidanEntity entity = new DbT3080DaisanshaKoiJidanEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setTodokedeKanriNo(DEFAULT_第三者行為届出管理番号);
        entity.setJidanHokokushoUketukeYMD(DEFAULT_示談報告書受付年月日);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setKyushoKyogiKubun(DEFAULT_第三者行為求償協議区分);
        entity.setJidanHokokushoTeishutsuYMD(DEFAULT_示談報告書提出年月日);
        entity.setJidanSeiritsuYMD(DEFAULT_示談成立年月日);
        entity.setKyufuKaishiYMD(DEFAULT_給付期間開始年月);
        entity.setKyufuShuryoYMD(DEFAULT_給付期間終了年月);
        entity.setKashitsuWariai_Kagaisha(DEFAULT_過失割合_加害者);
        entity.setKashitsuWariai_Higaisha(DEFAULT_過失割合_被害者);
        return entity;
    }
}
