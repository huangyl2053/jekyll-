/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険施設入退所エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT1004ShisetsuNyutaishoEntityGenerator {

    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("012340123400001");
    public static final int DEFAULT_履歴番号 = 0;
    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("209007");
    public static final RString DEFAULT_台帳種別 = new RString("Data");
    public static final RString DEFAULT_入所施設種類 = new RString("Data");
    public static final JigyoshaNo DEFAULT_入所施設コード = new JigyoshaNo("1");
    public static final FlexibleDate DEFAULT_入所処理年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_入所年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_退所処理年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_退所年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_部屋記号番号 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT1004ShisetsuNyutaishoEntityGenerator() {
    }

    public static DbT1004ShisetsuNyutaishoEntity createDbT1004ShisetsuNyutaishoEntity() {
        DbT1004ShisetsuNyutaishoEntity entity = new DbT1004ShisetsuNyutaishoEntity();
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setDaichoShubetsu(DEFAULT_台帳種別);
        entity.setNyushoShisetsuShurui(DEFAULT_入所施設種類);
        entity.setNyushoShisetsuCode(DEFAULT_入所施設コード);
        entity.setNyushoShoriYMD(DEFAULT_入所処理年月日);
        entity.setNyushoYMD(DEFAULT_入所年月日);
        entity.setTaishoShoriYMD(DEFAULT_退所処理年月日);
        entity.setTaishoYMD(DEFAULT_退所年月日);
        entity.setRoomKigoNo(DEFAULT_部屋記号番号);
        return entity;
    }
}
