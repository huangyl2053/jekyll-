/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険施設入退所エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT1004ShisetsuNyutaishoEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202011");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final RString DEFAULT_台帳種別 = new RString("1");
    public static final RString DEFAULT_入所施設種類 = new RString("1");
    public static final RString DEFAULT_入所施設コード = new RString("1");
    public static final FlexibleDate DEFAULT_入所年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_退所年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_入所処理年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_退所処理年月日 = new FlexibleDate("20140402");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT1004ShisetsuNyutaishoEntityGenerator() {
    }

    public static DbT1004ShisetsuNyutaishoEntity createDbT1004ShisetsuNyutaishoEntity() {
        DbT1004ShisetsuNyutaishoEntity entity = new DbT1004ShisetsuNyutaishoEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setDaichoShubetsu(DEFAULT_台帳種別);
        entity.setNyushoShisetsuShurui(DEFAULT_入所施設種類);
        entity.setNyushoShisetsuCode(DEFAULT_入所施設コード);
        entity.setNyushoYMD(DEFAULT_入所年月日);
        entity.setTaishoYMD(DEFAULT_退所年月日);
        entity.setNyushoShoriYMD(DEFAULT_入所処理年月日);
        entity.setTaishoShoriYMD(DEFAULT_退所処理年月日);
        return entity;
    }
}
