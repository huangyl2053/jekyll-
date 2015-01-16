/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 新旧適用除外施設番号変換テーブルエンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202011");
    public static final RString DEFAULT_新適用除外施設番号 = new RString("123");
    public static final RString DEFAULT_旧適用除外施設番号 = new RString("123");
    public static final LasdecCode DEFAULT_市町村コード２ = new LasdecCode("202011");
    public static final RString DEFAULT_旧適用除外施設番号２ = new RString("123");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntityGenerator() {
    }

    public static DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity createDbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity() {
        DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity entity = new DbT7031ShinKyuTekiyoJogaiShisetsuNoHenkanEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShinTekiyoJogaiShisetsuNo(DEFAULT_新適用除外施設番号);
        entity.setKyuTekiyoJogaiShisetsuNo(DEFAULT_旧適用除外施設番号);
        entity.setShichosonCode2(DEFAULT_市町村コード２);
        entity.setKyuTekiyoJogaiShisetsuNo2(DEFAULT_旧適用除外施設番号２);
        return entity;
    }
}
