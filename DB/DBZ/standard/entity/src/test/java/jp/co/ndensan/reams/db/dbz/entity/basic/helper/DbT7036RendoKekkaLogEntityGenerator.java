/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7036RendoKekkaLogEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHM;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 連動結果ログエンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋文娟
 */
public final class DbT7036RendoKekkaLogEntityGenerator {

    public static final RString DEFAULT_処理番号 = new RString("1");
    public static final RString DEFAULT_種別 = new RString("1");
    public static final RString DEFAULT_処理ＩＤ = new RString("1");
    public static final LasdecCode DEFAULT_送信元市町村コード = new LasdecCode("202011");
    public static final LasdecCode DEFAULT_送信先市町村コード = new LasdecCode("202011");
    public static final RString DEFAULT_結果区分 = new RString("1");
    public static final RString DEFAULT_確認区分 = new RString("1");
    public static final YMDHM DEFAULT_処理開始時刻 = new YMDHM(new RString("201404151020"));
    public static final YMDHM DEFAULT_処理終了時刻 = new YMDHM(new RString("201404151020"));
    public static final RString DEFAULT_ログファイル名 = new RString("1");
    public static final RString DEFAULT_表示用条件 = new RString("1");
    public static final RString DEFAULT_メッセージ = new RString("1");
    public static final RString DEFAULT_連動形態 = new RString("1");
    public static final RString DEFAULT_UL_受信結果区分 = new RString("1");
    public static final RString DEFAULT_UL_文字コード変換結果区分 = new RString("1");
    public static final RString DEFAULT_UL_処理１結果区分 = new RString("1");
    public static final RString DEFAULT_UL_処理２結果区分 = new RString("1");
    public static final RString DEFAULT_UL_処理３結果区分 = new RString("1");
    public static final RString DEFAULT_DL_処理１結果区分 = new RString("1");
    public static final RString DEFAULT_DL_コード変換結果区分 = new RString("1");
    public static final RString DEFAULT_DL_文字コード変換結果区分 = new RString("1");
    public static final RString DEFAULT_DL_送信１結果区分 = new RString("1");
    public static final RString DEFAULT_DL_処理２結果区分 = new RString("1");
    public static final RString DEFAULT_DL_受信１結果区分 = new RString("1");
    public static final RString DEFAULT_処理メッセージ１ = new RString("1");
    public static final RString DEFAULT_処理メッセージ２ = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7036RendoKekkaLogEntityGenerator() {
    }

    public static DbT7036RendoKekkaLogEntity createDbT7036RendoKekkaLogEntity() {
        DbT7036RendoKekkaLogEntity entity = new DbT7036RendoKekkaLogEntity();
        entity.setShoriNo(DEFAULT_処理番号);
        entity.setShubetsu(DEFAULT_種別);
        entity.setShoriID(DEFAULT_処理ＩＤ);
        entity.setMotoShichosonCode(DEFAULT_送信元市町村コード);
        entity.setSakiShichosonCode(DEFAULT_送信先市町村コード);
        entity.setKekkaKubun(DEFAULT_結果区分);
        entity.setKakuninKubun(DEFAULT_確認区分);
        entity.setShoriKaishiTimestamp(DEFAULT_処理開始時刻);
        entity.setShoriShuryoTimestamp(DEFAULT_処理終了時刻);
        entity.setLogFileMei(DEFAULT_ログファイル名);
        entity.setHyojiJoken(DEFAULT_表示用条件);
        entity.setMesseage(DEFAULT_メッセージ);
        entity.setRendoKeitai(DEFAULT_連動形態);
        entity.setUpLoad_JushinKekkaKubun(DEFAULT_UL_受信結果区分);
        entity.setUpLoad_MojiCodeHenkanKekkaKubun(DEFAULT_UL_文字コード変換結果区分);
        entity.setUpLoad_Shori1KekkaKubun(DEFAULT_UL_処理１結果区分);
        entity.setUpLoad_Shori2kekkaKubun(DEFAULT_UL_処理２結果区分);
        entity.setUpLoad_Shori3KekkaKubun(DEFAULT_UL_処理３結果区分);
        entity.setDownLoad_Shori1KekkaKubun(DEFAULT_DL_処理１結果区分);
        entity.setDownLoad_CodeHenkanKekkaKubun(DEFAULT_DL_コード変換結果区分);
        entity.setDownLoad_MojiCodeHenkanKekkaKubun(DEFAULT_DL_文字コード変換結果区分);
        entity.setDownLoad_Soshin1KekkaKubun(DEFAULT_DL_送信１結果区分);
        entity.setDownLoad_shori2KekkaKubun(DEFAULT_DL_処理２結果区分);
        entity.setDownLoad_Jushon1KekkaKubun(DEFAULT_DL_受信１結果区分);
        entity.setShoriMessage1(DEFAULT_処理メッセージ１);
        entity.setShoriMessage2(DEFAULT_処理メッセージ２);
        return entity;
    }
}
