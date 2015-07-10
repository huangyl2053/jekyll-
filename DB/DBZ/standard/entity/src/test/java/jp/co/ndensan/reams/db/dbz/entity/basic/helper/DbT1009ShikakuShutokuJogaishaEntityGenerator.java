/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1009ShikakuShutokuJogaishaEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格取得除外者エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT1009ShikakuShutokuJogaishaEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202011");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final RString DEFAULT_資格取得除外理由 = new RString("1");
    public static final FlexibleDate DEFAULT_資格取得除外年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_資格取得除外解除年月日 = new FlexibleDate("20140402");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT1009ShikakuShutokuJogaishaEntityGenerator() {
    }

    public static DbT1009ShikakuShutokuJogaishaEntity createDbT1009ShikakuShutokuJogaishaEntity() {
        DbT1009ShikakuShutokuJogaishaEntity entity = new DbT1009ShikakuShutokuJogaishaEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setShoriTimeStamp(DEFAULT_処理日時);
        entity.setShikakuShutokuJogaiRiyu(DEFAULT_資格取得除外理由);
        entity.setShikakuShutokuJogaiYMD(DEFAULT_資格取得除外年月日);
        entity.setShikakuShutokuJogaiKaijoYMD(DEFAULT_資格取得除外解除年月日);
        return entity;
    }
}
