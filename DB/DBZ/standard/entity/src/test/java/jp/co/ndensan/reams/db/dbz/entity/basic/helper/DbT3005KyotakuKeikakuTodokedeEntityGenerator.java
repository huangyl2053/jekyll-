/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3005KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 居宅給付計画届出エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT3005KyotakuKeikakuTodokedeEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("2"));
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final FlexibleYearMonth DEFAULT_対象年月 = new FlexibleYearMonth(new RString("201406"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final RString DEFAULT_届出区分 = new RString("1");
    public static final FlexibleDate DEFAULT_届出年月日 = new FlexibleDate("20140402");
    public static final AtenaMeisho DEFAULT_届出者氏名 = new AtenaMeisho("電算太郎");
    public static final AtenaKanaMeisho DEFAULT_届出者氏名カナ = new AtenaKanaMeisho("デンサンタロウ");
    public static final YubinNo DEFAULT_届出者郵便番号 = new YubinNo(new RString("123-1234"));
    public static final RString DEFAULT_届出者住所 = new RString("1");
    public static final TelNo DEFAULT_届出者電話番号 = new TelNo("012-345-6789");
    public static final RString DEFAULT_届出者関係区分 = new RString("1");
    public static final RString DEFAULT_暫定区分 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3005KyotakuKeikakuTodokedeEntityGenerator() {
    }

    public static DbT3005KyotakuKeikakuTodokedeEntity createDbT3005KyotakuKeikakuTodokedeEntity() {
        DbT3005KyotakuKeikakuTodokedeEntity entity = new DbT3005KyotakuKeikakuTodokedeEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setTaishoYM(DEFAULT_対象年月);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setTodokedeKubun(DEFAULT_届出区分);
        entity.setTodokedeYMD(DEFAULT_届出年月日);
        entity.setTodokedeshaShimei(DEFAULT_届出者氏名);
        entity.setTodokedeshaShimeiKana(DEFAULT_届出者氏名カナ);
        entity.setTodokedeshaYubinNo(DEFAULT_届出者郵便番号);
        entity.setTodokedeshaJusho(DEFAULT_届出者住所);
        entity.setTodokedeshaTelNo(DEFAULT_届出者電話番号);
        entity.setTodokedeshaKankeiKubun(DEFAULT_届出者関係区分);
        entity.setZanteiKubun(DEFAULT_暫定区分);
        return entity;
    }
}
