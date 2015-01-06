/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理マスタエンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT7022ShoriDateKanriEntityGenerator {

    public static final GyomuCode DEFAULT_業務コード = new GyomuCode("DC");
    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202011");
    public static final RString DEFAULT_バッチＩＤ = new RString("123");
    public static final RString DEFAULT_バッチID枝番 = new RString("123");
    public static final FlexibleYear DEFAULT_年度 = new FlexibleYear("2014");
    public static final RString DEFAULT_年度内連番 = new RString("123");
    public static final FlexibleDate DEFAULT_基準年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_対象開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_対象終了年月日 = new FlexibleDate("20140402");
    public static final YMDHMS DEFAULT_対象開始日時 = new YMDHMS(new RString("20140415102030"));
    public static final YMDHMS DEFAULT_対象終了日時 = new YMDHMS(new RString("20140415102030"));

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7022ShoriDateKanriEntityGenerator() {
    }

    public static DbT7022ShoriDateKanriEntity createDbT7022ShoriDateKanriEntity() {
        DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
        entity.setGyomuCode(DEFAULT_業務コード);
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setBatchID(DEFAULT_バッチＩＤ);
        entity.setBatchIDEdaban(DEFAULT_バッチID枝番);
        entity.setNendo(DEFAULT_年度);
        entity.setNendoNaiRenban(DEFAULT_年度内連番);
        entity.setKijunYMD(DEFAULT_基準年月日);
        entity.setTaishoKaishiYMD(DEFAULT_対象開始年月日);
        entity.setTaishoShuryoYMD(DEFAULT_対象終了年月日);
        entity.setTaishoKaishiTimestamp(DEFAULT_対象開始日時);
        entity.setTaishoShuryoTimestamp(DEFAULT_対象終了日時);
        return entity;
    }
}
