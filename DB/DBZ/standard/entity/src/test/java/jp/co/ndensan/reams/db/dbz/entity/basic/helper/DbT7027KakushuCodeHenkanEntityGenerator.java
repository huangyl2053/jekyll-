/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7027KakushuCodeHenkanEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 各種コード変換テーブルエンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT7027KakushuCodeHenkanEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202011");
    public static final RString DEFAULT_コード区分 = new RString("1");
    public static final RString DEFAULT_内部コード = new RString("6123");
    public static final RString DEFAULT_内部番号 = new RString("12");
    public static final RString DEFAULT_外部コード = new RString("1223");
    public static final LasdecCode DEFAULT_市町村コード２ = new LasdecCode("202011");
    public static final RString DEFAULT_外部コード２ = new RString("4123");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7027KakushuCodeHenkanEntityGenerator() {
    }

    public static DbT7027KakushuCodeHenkanEntity createDbT7027KakushuCodeHenkanEntity() {
        DbT7027KakushuCodeHenkanEntity entity = new DbT7027KakushuCodeHenkanEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setCodeKubun(DEFAULT_コード区分);
        entity.setNaibuCode(DEFAULT_内部コード);
        entity.setNaibuNo(DEFAULT_内部番号);
        entity.setGaibuCode(DEFAULT_外部コード);
        entity.setShichosonCode2(DEFAULT_市町村コード２);
        entity.setGaibuCode2(DEFAULT_外部コード２);
        return entity;
    }
}
