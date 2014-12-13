/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 新旧他特例施設番号変換テーブルエンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202011");
    public static final RString DEFAULT_新他特例施設番号 = new RString("123");
    public static final RString DEFAULT_旧他特例施設番号 = new RString("123");
    public static final LasdecCode DEFAULT_市町村コード２ = new LasdecCode("202011");
    public static final RString DEFAULT_旧他特例施設番号２ = new RString("123");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityGenerator() {
    }

    public static DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity createDbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity() {
        DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity entity = new DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShinTaTokureiShisetsuNo(DEFAULT_新他特例施設番号);
        entity.setKyuTaTokureiShisetsuNo(DEFAULT_旧他特例施設番号);
        entity.setShichosonCode2(DEFAULT_市町村コード２);
        entity.setKyuTaTokureiShisetsuNo2(DEFAULT_旧他特例施設番号２);
        return entity;
    }
}
