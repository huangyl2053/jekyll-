/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7116JukyushaGendoGakuKanriEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 受給者限度額管理エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋文娟
 */
public final class DbT7116JukyushaGendoGakuKanriEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final RString DEFAULT_識別区分 = new RString("1");
    public static final FlexibleYearMonth DEFAULT_有効開始年月 = new FlexibleYearMonth(new RString("201406"));
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final FlexibleYearMonth DEFAULT_有効終了年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_要介護状態区分 = new RString("1");
    public static final RString DEFAULT_拡大倍数 = new RString("1");
    public static final Decimal DEFAULT_切り分け単位数 = new Decimal(1);
    public static final FlexibleDate DEFAULT_登録年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_変更年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_限度額管理期間数 = new RString("1");
    public static final RString DEFAULT_新体系管理区分 = new RString("1");
    public static final RString DEFAULT_新体系拡大適用有無 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7116JukyushaGendoGakuKanriEntityGenerator() {
    }

    public static DbT7116JukyushaGendoGakuKanriEntity createDbT7116JukyushaGendoGakuKanriEntity() {
        DbT7116JukyushaGendoGakuKanriEntity entity = new DbT7116JukyushaGendoGakuKanriEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setShikibetsuKubun(DEFAULT_識別区分);
        entity.setYukoKaishiYM(DEFAULT_有効開始年月);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setYukoShuryoYM(DEFAULT_有効終了年月);
        entity.setYoKaigoJotaiKubun(DEFAULT_要介護状態区分);
        entity.setKakudaiBaisu(DEFAULT_拡大倍数);
        entity.setKiriwakeTaniSu(DEFAULT_切り分け単位数);
        entity.setTorokuYMD(DEFAULT_登録年月日);
        entity.setHenkoYMD(DEFAULT_変更年月日);
        entity.setGendoGakuKanriKikanSu(DEFAULT_限度額管理期間数);
        entity.setShinTaikeiKanriKubun(DEFAULT_新体系管理区分);
        entity.setShinTaikeiKakudaiTekiyoUmu(DEFAULT_新体系拡大適用有無);
        return entity;
    }
}
