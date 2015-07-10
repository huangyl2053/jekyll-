/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7035RendoPatternEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 連動パターンエンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋文娟
 */
public final class DbT7035RendoPatternEntityGenerator {

    public static final LasdecCode DEFAULT_送信元市町村コード = new LasdecCode("202011");
    public static final LasdecCode DEFAULT_送信先市町村コード = new LasdecCode("202011");
    public static final RString DEFAULT_種別 = new RString("1");
    public static final FlexibleDate DEFAULT_有効開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_有効終了年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_連動形態コード = new RString("1");
    public static final RString DEFAULT_送信元フォーマットバージョン = new RString("1");
    public static final RString DEFAULT_送信元エンコーディング = new RString("1");
    public static final RString DEFAULT_送信先フォーマットバージョン = new RString("1");
    public static final RString DEFAULT_送信先エンコーディング = new RString("1");
    public static final RString DEFAULT_コード変換区分 = new RString("1");
    public static final RString DEFAULT_外字変換区分 = new RString("1");
    public static final RString DEFAULT_全件連動区分 = new RString("1");
    public static final RString DEFAULT_連携区分 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7035RendoPatternEntityGenerator() {
    }

    public static DbT7035RendoPatternEntity createDbT7035RendoPatternEntity() {
        DbT7035RendoPatternEntity entity = new DbT7035RendoPatternEntity();
        entity.setMotoShichosonCode(DEFAULT_送信元市町村コード);
        entity.setSakiShichosonCode(DEFAULT_送信先市町村コード);
        entity.setShubetsu(DEFAULT_種別);
        entity.setYukoKaishiYMD(DEFAULT_有効開始年月日);
        entity.setYukoShuryoYMD(DEFAULT_有効終了年月日);
        entity.setRendoKeitaiCode(DEFAULT_連動形態コード);
        entity.setMotoFormatVersion(DEFAULT_送信元フォーマットバージョン);
        entity.setMotoEncodeKeitai(DEFAULT_送信元エンコーディング);
        entity.setSakiFormatVersion(DEFAULT_送信先フォーマットバージョン);
        entity.setSakiEncodeKeitai(DEFAULT_送信先エンコーディング);
        entity.setCodeHenkanKubun(DEFAULT_コード変換区分);
        entity.setGaijiHenkanKubun(DEFAULT_外字変換区分);
        entity.setZenkenRendoKubun(DEFAULT_全件連動区分);
        entity.setRendoKubun(DEFAULT_連携区分);
        return entity;
    }
}
