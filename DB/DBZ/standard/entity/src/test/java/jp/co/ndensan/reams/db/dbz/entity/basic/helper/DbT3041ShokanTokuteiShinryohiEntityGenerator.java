/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3041ShokanTokuteiShinryohiEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払請求特定診療費エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 周杏月
 */
public final class DbT3041ShokanTokuteiShinryohiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleYearMonth DEFAULT_サービス提供年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_整理番号 = new RString("1");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo(new RString("2"));
    public static final RString DEFAULT_様式番号 = new RString("1");
    public static final RString DEFAULT_順次番号 = new RString("1");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final RString DEFAULT_傷病名 = new RString("1");
    public static final int DEFAULT_指導管理料等単位数 = 1;
    public static final int DEFAULT_単純エックス線単位数 = 1;
    public static final int DEFAULT_リハビリテーション単位数 = 1;
    public static final int DEFAULT_精神科専門療法単位数 = 1;
    public static final int DEFAULT_合計単位数 = 1;
    public static final RString DEFAULT_摘要１ = new RString("1");
    public static final RString DEFAULT_摘要２ = new RString("1");
    public static final RString DEFAULT_摘要３ = new RString("1");
    public static final RString DEFAULT_摘要４ = new RString("1");
    public static final RString DEFAULT_摘要５ = new RString("1");
    public static final RString DEFAULT_摘要６ = new RString("1");
    public static final RString DEFAULT_摘要７ = new RString("1");
    public static final RString DEFAULT_摘要８ = new RString("1");
    public static final RString DEFAULT_摘要９ = new RString("1");
    public static final RString DEFAULT_摘要１０ = new RString("1");
    public static final RString DEFAULT_摘要１１ = new RString("1");
    public static final RString DEFAULT_摘要１２ = new RString("1");
    public static final RString DEFAULT_摘要１３ = new RString("1");
    public static final RString DEFAULT_摘要１４ = new RString("1");
    public static final RString DEFAULT_摘要１５ = new RString("1");
    public static final RString DEFAULT_摘要１６ = new RString("1");
    public static final RString DEFAULT_摘要１７ = new RString("1");
    public static final RString DEFAULT_摘要１８ = new RString("1");
    public static final RString DEFAULT_摘要１９ = new RString("1");
    public static final RString DEFAULT_摘要２０ = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3041ShokanTokuteiShinryohiEntityGenerator() {
    }

    public static DbT3041ShokanTokuteiShinryohiEntity createDbT3041ShokanTokuteiShinryohiEntity() {
        DbT3041ShokanTokuteiShinryohiEntity entity = new DbT3041ShokanTokuteiShinryohiEntity();
        entity.setHiHokenshaNo(DEFAULT_被保険者番号);
        entity.setServiceTeikyoYM(DEFAULT_サービス提供年月);
        entity.setSeiriNo(DEFAULT_整理番号);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setYoshikiNo(DEFAULT_様式番号);
        entity.setJunjiNo(DEFAULT_順次番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setShobyoName(DEFAULT_傷病名);
        entity.setShidoKanriryoTanisu(DEFAULT_指導管理料等単位数);
        entity.setTanjunXsenTanisu(DEFAULT_単純エックス線単位数);
        entity.setRehabilitationTanisu(DEFAULT_リハビリテーション単位数);
        entity.setSeishinkaSemmonRyoyohouTanisu(DEFAULT_精神科専門療法単位数);
        entity.setTotalTanisu(DEFAULT_合計単位数);
        entity.setTekiyo1(DEFAULT_摘要１);
        entity.setTekiyo2(DEFAULT_摘要２);
        entity.setTekiyo3(DEFAULT_摘要３);
        entity.setTekiyo4(DEFAULT_摘要４);
        entity.setTekiyo5(DEFAULT_摘要５);
        entity.setTekiyo6(DEFAULT_摘要６);
        entity.setTekiyo7(DEFAULT_摘要７);
        entity.setTekiyo8(DEFAULT_摘要８);
        entity.setTekiyo9(DEFAULT_摘要９);
        entity.setTekiyo10(DEFAULT_摘要１０);
        entity.setTekiyo11(DEFAULT_摘要１１);
        entity.setTekiyo12(DEFAULT_摘要１２);
        entity.setTekiyo13(DEFAULT_摘要１３);
        entity.setTekiyo14(DEFAULT_摘要１４);
        entity.setTekiyo15(DEFAULT_摘要１５);
        entity.setTekiyo16(DEFAULT_摘要１６);
        entity.setTekiyo17(DEFAULT_摘要１７);
        entity.setTekiyo18(DEFAULT_摘要１８);
        entity.setTekiyo19(DEFAULT_摘要１９);
        entity.setTekiyo20(DEFAULT_摘要２０);
        return entity;
    }
}
