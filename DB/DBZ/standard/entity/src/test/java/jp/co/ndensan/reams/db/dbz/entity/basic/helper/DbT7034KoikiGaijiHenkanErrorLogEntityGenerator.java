/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7034KoikiGaijiHenkanErrorLogEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域外字変換エラーログエンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋文娟
 */
public final class DbT7034KoikiGaijiHenkanErrorLogEntityGenerator {

    public static final RString DEFAULT_処理番号 = new RString("1");
    public static final RString DEFAULT_連番 = new RString("1");
    public static final LasdecCode DEFAULT_市町村番号 = new LasdecCode("202011");
    public static final RString DEFAULT_種別 = new RString("1");
    public static final RDateTime DEFAULT_処理日時 = RDateTime.of(2014, 9, 01, 10, 20, 30, 123);
    public static final LasdecCode DEFAULT_送信元市町村コード = new LasdecCode("202011");
    public static final RString DEFAULT_送信元市町村名称 = new RString("1");
    public static final LasdecCode DEFAULT_送信先市町村コード = new LasdecCode("202011");
    public static final RString DEFAULT_送信先市町村名称 = new RString("1");
    public static final ShikibetsuCode DEFAULT_住基識別コード = new ShikibetsuCode("000001234567890");
    public static final RString DEFAULT_確認区分 = new RString("1");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final RString DEFAULT_レコードＮｏ = new RString("1");
    public static final RString DEFAULT_変換エラーフィールド名称 = new RString("1");
    public static final RString DEFAULT_変換エラーフィールドＮｏ = new RString("1");
    public static final RString DEFAULT_変換エラーコード = new RString("1");
    public static final RString DEFAULT_エラー表示連番 = new RString("1");
    public static final RString DEFAULT_エラー表示フィールド名称 = new RString("1");
    public static final RString DEFAULT_エラー表示フィールド = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7034KoikiGaijiHenkanErrorLogEntityGenerator() {
    }

    public static DbT7034KoikiGaijiHenkanErrorLogEntity createDbT7034KoikiGaijiHenkanErrorLogEntity() {
        DbT7034KoikiGaijiHenkanErrorLogEntity entity = new DbT7034KoikiGaijiHenkanErrorLogEntity();
        entity.setShoriNo(DEFAULT_処理番号);
        entity.setRenNo(DEFAULT_連番);
        entity.setShichosonCode(DEFAULT_市町村番号);
        entity.setShubetsu(DEFAULT_種別);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setMotoShichosonCode(DEFAULT_送信元市町村コード);
        entity.setMotoShichosonMeisho(DEFAULT_送信元市町村名称);
        entity.setSakiShichosonCode(DEFAULT_送信先市町村コード);
        entity.setSakiShichosonMeisho(DEFAULT_送信先市町村名称);
        entity.setJukiShikibetsuCode(DEFAULT_住基識別コード);
        entity.setKakuninKubun(DEFAULT_確認区分);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setRecoadNo(DEFAULT_レコードＮｏ);
        entity.setErrorKomokuMeisho(DEFAULT_変換エラーフィールド名称);
        entity.setErrorKomokuNo(DEFAULT_変換エラーフィールドＮｏ);
        entity.setErrorCode(DEFAULT_変換エラーコード);
        entity.setErrorHyojiRenban(DEFAULT_エラー表示連番);
        entity.setErrorHyojiKomokuMeisho(DEFAULT_エラー表示フィールド名称);
        entity.setErrorHyojiKomoku(DEFAULT_エラー表示フィールド);
        return entity;
    }
}
