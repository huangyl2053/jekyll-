/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1009ShikakuShutokuJogaishaEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格取得除外者エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT1009ShikakuShutokuJogaishaEntityGenerator {

    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("012340123400001");
    public static final int DEFAULT_履歴番号 = 1;
    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("209007");
    public static final RString DEFAULT_資格取得除外理由 = new RString("Data");
    public static final FlexibleDate DEFAULT_資格取得除外年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_資格取得除外解除年月日 = new FlexibleDate("19900101");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT1009ShikakuShutokuJogaishaEntityGenerator() {
    }

    public static DbT1009ShikakuShutokuJogaishaEntity createDbT1009ShikakuShutokuJogaishaEntity() {
        DbT1009ShikakuShutokuJogaishaEntity entity = new DbT1009ShikakuShutokuJogaishaEntity();
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShikakuShutokuJogaiRiyu(DEFAULT_資格取得除外理由);
        entity.setShikakuShutokuJogaiYMD(DEFAULT_資格取得除外年月日);
        entity.setShikakuShutokuJogaiKaijoYMD(DEFAULT_資格取得除外解除年月日);
        return entity;
    }
}
