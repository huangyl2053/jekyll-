/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3005KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 居宅給付計画届出エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3005KyotakuKeikakuTodokedeEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_対象年月 = new FlexibleYearMonth("199001");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final RString DEFAULT_届出区分 = new RString("Data");
    public static final FlexibleDate DEFAULT_届出年月日 = new FlexibleDate("19900101");
    public static final AtenaMeisho DEFAULT_届出者氏名 = new AtenaMeisho("");
    public static final AtenaKanaMeisho DEFAULT_届出者氏名カナ = new AtenaKanaMeisho("");
    public static final YubinNo DEFAULT_届出者郵便番号 = new YubinNo("0010001");
    public static final RString DEFAULT_届出者住所 = new RString("Data");
    public static final TelNo DEFAULT_届出者電話番号 = new TelNo("08011112222");
    public static final RString DEFAULT_届出者関係区分 = new RString("Data");
    public static final RString DEFAULT_暫定区分 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3005KyotakuKeikakuTodokedeEntityGenerator() {
    }

    public static DbT3005KyotakuKeikakuTodokedeEntity createDbT3005KyotakuKeikakuTodokedeEntity() {
        DbT3005KyotakuKeikakuTodokedeEntity entity = new DbT3005KyotakuKeikakuTodokedeEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setTaishoYM(DEFAULT_対象年月);
        entity.setRirekiNo(DEFAULT_履歴番号);
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
