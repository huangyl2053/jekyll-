package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHM;
import java.util.Objects;

/**
 * 連動結果ログテーブルのエンティティクラスです。
 */
public class DbT7036RendoKekkaLogEntity extends DbTableEntityBase<DbT7036RendoKekkaLogEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7036RendoKekkaLog");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString shoriNo;
    private RString shubetsu;
    private RString shoriID;
    private LasdecCode motoShichosonCode;
    private LasdecCode sakiShichosonCode;
    private RString kekkaKubun;
    private RString kakuninKubun;
    private YMDHM ShoriKaishiTimestamp;
    private YMDHM shoriShuryoTimestamp;
    private RString logFileMei;
    private RString hyojiJoken;
    private RString messeage;
    private RString rendoKeitai;
    private RString upLoad_JushinKekkaKubun;
    private RString upLoad_MojiCodeHenkanKekkaKubun;
    private RString upLoad_Shori1KekkaKubun;
    private RString upLoad_Shori2kekkaKubun;
    private RString upLoad_Shori3KekkaKubun;
    private RString downLoad_Shori1KekkaKubun;
    private RString downLoad_CodeHenkanKekkaKubun;
    private RString downLoad_MojiCodeHenkanKekkaKubun;
    private RString downLoad_Soshin1KekkaKubun;
    private RString downLoad_shori2KekkaKubun;
    private RString downLoad_Jushon1KekkaKubun;
    private RString shoriMessage1;
    private RString shoriMessage2;

    /**
     * insertDantaiCdのgetメソッドです。
     * 
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * insertDantaiCdのsetメソッドです。
     * 
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * isDeletedのgetメソッドです。
     * 
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * isDeletedのsetメソッドです。
     * 
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    /**
     * lastUpdateReamsLoginIdのsetメソッドです。
     * 
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * 処理番号のgetメソッドです。
     * 
     * @return 処理番号
     */
    public RString getShoriNo() {
        return shoriNo;
    }

    /**
     * 処理番号のsetメソッドです。
     * 
     * @param shoriNo 処理番号
     */
    public void setShoriNo(RString shoriNo) {
        this.shoriNo = shoriNo;
    }

    /**
     * 種別のgetメソッドです。
     * 
     * @return 種別
     */
    public RString getShubetsu() {
        return shubetsu;
    }

    /**
     * 種別のsetメソッドです。
     * 
     * @param shubetsu 種別
     */
    public void setShubetsu(RString shubetsu) {
        this.shubetsu = shubetsu;
    }

    /**
     * 処理ＩＤのgetメソッドです。
     * 
     * @return 処理ＩＤ
     */
    public RString getShoriID() {
        return shoriID;
    }

    /**
     * 処理ＩＤのsetメソッドです。
     * 
     * @param shoriID 処理ＩＤ
     */
    public void setShoriID(RString shoriID) {
        this.shoriID = shoriID;
    }

    /**
     * 送信元市町村コードのgetメソッドです。
     * 
     * @return 送信元市町村コード
     */
    public LasdecCode getMotoShichosonCode() {
        return motoShichosonCode;
    }

    /**
     * 送信元市町村コードのsetメソッドです。
     * 
     * @param motoShichosonCode 送信元市町村コード
     */
    public void setMotoShichosonCode(LasdecCode motoShichosonCode) {
        this.motoShichosonCode = motoShichosonCode;
    }

    /**
     * 送信先市町村コードのgetメソッドです。
     * 
     * @return 送信先市町村コード
     */
    public LasdecCode getSakiShichosonCode() {
        return sakiShichosonCode;
    }

    /**
     * 送信先市町村コードのsetメソッドです。
     * 
     * @param sakiShichosonCode 送信先市町村コード
     */
    public void setSakiShichosonCode(LasdecCode sakiShichosonCode) {
        this.sakiShichosonCode = sakiShichosonCode;
    }

    /**
     * 結果区分のgetメソッドです。
     * 
     * @return 結果区分
     */
    public RString getKekkaKubun() {
        return kekkaKubun;
    }

    /**
     * 結果区分のsetメソッドです。
     * 
     * @param kekkaKubun 結果区分
     */
    public void setKekkaKubun(RString kekkaKubun) {
        this.kekkaKubun = kekkaKubun;
    }

    /**
     * 確認区分のgetメソッドです。
     * 
     * @return 確認区分
     */
    public RString getKakuninKubun() {
        return kakuninKubun;
    }

    /**
     * 確認区分のsetメソッドです。
     * 
     * @param kakuninKubun 確認区分
     */
    public void setKakuninKubun(RString kakuninKubun) {
        this.kakuninKubun = kakuninKubun;
    }

    /**
     * 処理開始時刻のgetメソッドです。
     * 
     * @return 処理開始時刻
     */
    public YMDHM getShoriKaishiTimestamp() {
        return ShoriKaishiTimestamp;
    }

    /**
     * 処理開始時刻のsetメソッドです。
     * 
     * @param ShoriKaishiTimestamp 処理開始時刻
     */
    public void setShoriKaishiTimestamp(YMDHM ShoriKaishiTimestamp) {
        this.ShoriKaishiTimestamp = ShoriKaishiTimestamp;
    }

    /**
     * 処理終了時刻のgetメソッドです。
     * 
     * @return 処理終了時刻
     */
    public YMDHM getShoriShuryoTimestamp() {
        return shoriShuryoTimestamp;
    }

    /**
     * 処理終了時刻のsetメソッドです。
     * 
     * @param shoriShuryoTimestamp 処理終了時刻
     */
    public void setShoriShuryoTimestamp(YMDHM shoriShuryoTimestamp) {
        this.shoriShuryoTimestamp = shoriShuryoTimestamp;
    }

    /**
     * ログファイル名のgetメソッドです。
     * 
     * @return ログファイル名
     */
    public RString getLogFileMei() {
        return logFileMei;
    }

    /**
     * ログファイル名のsetメソッドです。
     * 
     * @param logFileMei ログファイル名
     */
    public void setLogFileMei(RString logFileMei) {
        this.logFileMei = logFileMei;
    }

    /**
     * 表示用条件のgetメソッドです。
     * 
     * @return 表示用条件
     */
    public RString getHyojiJoken() {
        return hyojiJoken;
    }

    /**
     * 表示用条件のsetメソッドです。
     * 
     * @param hyojiJoken 表示用条件
     */
    public void setHyojiJoken(RString hyojiJoken) {
        this.hyojiJoken = hyojiJoken;
    }

    /**
     * メッセージのgetメソッドです。
     * 
     * @return メッセージ
     */
    public RString getMesseage() {
        return messeage;
    }

    /**
     * メッセージのsetメソッドです。
     * 
     * @param messeage メッセージ
     */
    public void setMesseage(RString messeage) {
        this.messeage = messeage;
    }

    /**
     * 連動形態のgetメソッドです。
     * 
     * @return 連動形態
     */
    public RString getRendoKeitai() {
        return rendoKeitai;
    }

    /**
     * 連動形態のsetメソッドです。
     * 
     * @param rendoKeitai 連動形態
     */
    public void setRendoKeitai(RString rendoKeitai) {
        this.rendoKeitai = rendoKeitai;
    }

    /**
     * UL・受信結果区分のgetメソッドです。
     * 
     * @return UL・受信結果区分
     */
    public RString getUpLoad_JushinKekkaKubun() {
        return upLoad_JushinKekkaKubun;
    }

    /**
     * UL・受信結果区分のsetメソッドです。
     * 
     * @param upLoad_JushinKekkaKubun UL・受信結果区分
     */
    public void setUpLoad_JushinKekkaKubun(RString upLoad_JushinKekkaKubun) {
        this.upLoad_JushinKekkaKubun = upLoad_JushinKekkaKubun;
    }

    /**
     * UL・文字コード変換結果区分のgetメソッドです。
     * 
     * @return UL・文字コード変換結果区分
     */
    public RString getUpLoad_MojiCodeHenkanKekkaKubun() {
        return upLoad_MojiCodeHenkanKekkaKubun;
    }

    /**
     * UL・文字コード変換結果区分のsetメソッドです。
     * 
     * @param upLoad_MojiCodeHenkanKekkaKubun UL・文字コード変換結果区分
     */
    public void setUpLoad_MojiCodeHenkanKekkaKubun(RString upLoad_MojiCodeHenkanKekkaKubun) {
        this.upLoad_MojiCodeHenkanKekkaKubun = upLoad_MojiCodeHenkanKekkaKubun;
    }

    /**
     * UL・処理１結果区分のgetメソッドです。
     * 
     * @return UL・処理１結果区分
     */
    public RString getUpLoad_Shori1KekkaKubun() {
        return upLoad_Shori1KekkaKubun;
    }

    /**
     * UL・処理１結果区分のsetメソッドです。
     * 
     * @param upLoad_Shori1KekkaKubun UL・処理１結果区分
     */
    public void setUpLoad_Shori1KekkaKubun(RString upLoad_Shori1KekkaKubun) {
        this.upLoad_Shori1KekkaKubun = upLoad_Shori1KekkaKubun;
    }

    /**
     * UL・処理２結果区分のgetメソッドです。
     * 
     * @return UL・処理２結果区分
     */
    public RString getUpLoad_Shori2kekkaKubun() {
        return upLoad_Shori2kekkaKubun;
    }

    /**
     * UL・処理２結果区分のsetメソッドです。
     * 
     * @param upLoad_Shori2kekkaKubun UL・処理２結果区分
     */
    public void setUpLoad_Shori2kekkaKubun(RString upLoad_Shori2kekkaKubun) {
        this.upLoad_Shori2kekkaKubun = upLoad_Shori2kekkaKubun;
    }

    /**
     * UL・処理３結果区分のgetメソッドです。
     * 
     * @return UL・処理３結果区分
     */
    public RString getUpLoad_Shori3KekkaKubun() {
        return upLoad_Shori3KekkaKubun;
    }

    /**
     * UL・処理３結果区分のsetメソッドです。
     * 
     * @param upLoad_Shori3KekkaKubun UL・処理３結果区分
     */
    public void setUpLoad_Shori3KekkaKubun(RString upLoad_Shori3KekkaKubun) {
        this.upLoad_Shori3KekkaKubun = upLoad_Shori3KekkaKubun;
    }

    /**
     * DL・処理１結果区分のgetメソッドです。
     * 
     * @return DL・処理１結果区分
     */
    public RString getDownLoad_Shori1KekkaKubun() {
        return downLoad_Shori1KekkaKubun;
    }

    /**
     * DL・処理１結果区分のsetメソッドです。
     * 
     * @param downLoad_Shori1KekkaKubun DL・処理１結果区分
     */
    public void setDownLoad_Shori1KekkaKubun(RString downLoad_Shori1KekkaKubun) {
        this.downLoad_Shori1KekkaKubun = downLoad_Shori1KekkaKubun;
    }

    /**
     * DL・コード変換結果区分のgetメソッドです。
     * 
     * @return DL・コード変換結果区分
     */
    public RString getDownLoad_CodeHenkanKekkaKubun() {
        return downLoad_CodeHenkanKekkaKubun;
    }

    /**
     * DL・コード変換結果区分のsetメソッドです。
     * 
     * @param downLoad_CodeHenkanKekkaKubun DL・コード変換結果区分
     */
    public void setDownLoad_CodeHenkanKekkaKubun(RString downLoad_CodeHenkanKekkaKubun) {
        this.downLoad_CodeHenkanKekkaKubun = downLoad_CodeHenkanKekkaKubun;
    }

    /**
     * DL・文字コード変換結果区分のgetメソッドです。
     * 
     * @return DL・文字コード変換結果区分
     */
    public RString getDownLoad_MojiCodeHenkanKekkaKubun() {
        return downLoad_MojiCodeHenkanKekkaKubun;
    }

    /**
     * DL・文字コード変換結果区分のsetメソッドです。
     * 
     * @param downLoad_MojiCodeHenkanKekkaKubun DL・文字コード変換結果区分
     */
    public void setDownLoad_MojiCodeHenkanKekkaKubun(RString downLoad_MojiCodeHenkanKekkaKubun) {
        this.downLoad_MojiCodeHenkanKekkaKubun = downLoad_MojiCodeHenkanKekkaKubun;
    }

    /**
     * DL・送信１結果区分のgetメソッドです。
     * 
     * @return DL・送信１結果区分
     */
    public RString getDownLoad_Soshin1KekkaKubun() {
        return downLoad_Soshin1KekkaKubun;
    }

    /**
     * DL・送信１結果区分のsetメソッドです。
     * 
     * @param downLoad_Soshin1KekkaKubun DL・送信１結果区分
     */
    public void setDownLoad_Soshin1KekkaKubun(RString downLoad_Soshin1KekkaKubun) {
        this.downLoad_Soshin1KekkaKubun = downLoad_Soshin1KekkaKubun;
    }

    /**
     * DL・処理２結果区分のgetメソッドです。
     * 
     * @return DL・処理２結果区分
     */
    public RString getDownLoad_shori2KekkaKubun() {
        return downLoad_shori2KekkaKubun;
    }

    /**
     * DL・処理２結果区分のsetメソッドです。
     * 
     * @param downLoad_shori2KekkaKubun DL・処理２結果区分
     */
    public void setDownLoad_shori2KekkaKubun(RString downLoad_shori2KekkaKubun) {
        this.downLoad_shori2KekkaKubun = downLoad_shori2KekkaKubun;
    }

    /**
     * DL・受信１結果区分のgetメソッドです。
     * 
     * @return DL・受信１結果区分
     */
    public RString getDownLoad_Jushon1KekkaKubun() {
        return downLoad_Jushon1KekkaKubun;
    }

    /**
     * DL・受信１結果区分のsetメソッドです。
     * 
     * @param downLoad_Jushon1KekkaKubun DL・受信１結果区分
     */
    public void setDownLoad_Jushon1KekkaKubun(RString downLoad_Jushon1KekkaKubun) {
        this.downLoad_Jushon1KekkaKubun = downLoad_Jushon1KekkaKubun;
    }

    /**
     * 処理メッセージ１のgetメソッドです。
     * 
     * @return 処理メッセージ１
     */
    public RString getShoriMessage1() {
        return shoriMessage1;
    }

    /**
     * 処理メッセージ１のsetメソッドです。
     * 
     * @param shoriMessage1 処理メッセージ１
     */
    public void setShoriMessage1(RString shoriMessage1) {
        this.shoriMessage1 = shoriMessage1;
    }

    /**
     * 処理メッセージ２のgetメソッドです。
     * 
     * @return 処理メッセージ２
     */
    public RString getShoriMessage2() {
        return shoriMessage2;
    }

    /**
     * 処理メッセージ２のsetメソッドです。
     * 
     * @param shoriMessage2 処理メッセージ２
     */
    public void setShoriMessage2(RString shoriMessage2) {
        this.shoriMessage2 = shoriMessage2;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7036RendoKekkaLogEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7036RendoKekkaLogEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7036RendoKekkaLogEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoriNo, other.shoriNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7036RendoKekkaLogEntity entity) {
        this.shoriNo = entity.shoriNo;
        this.shubetsu = entity.shubetsu;
        this.shoriID = entity.shoriID;
        this.motoShichosonCode = entity.motoShichosonCode;
        this.sakiShichosonCode = entity.sakiShichosonCode;
        this.kekkaKubun = entity.kekkaKubun;
        this.kakuninKubun = entity.kakuninKubun;
        this.ShoriKaishiTimestamp = entity.ShoriKaishiTimestamp;
        this.shoriShuryoTimestamp = entity.shoriShuryoTimestamp;
        this.logFileMei = entity.logFileMei;
        this.hyojiJoken = entity.hyojiJoken;
        this.messeage = entity.messeage;
        this.rendoKeitai = entity.rendoKeitai;
        this.upLoad_JushinKekkaKubun = entity.upLoad_JushinKekkaKubun;
        this.upLoad_MojiCodeHenkanKekkaKubun = entity.upLoad_MojiCodeHenkanKekkaKubun;
        this.upLoad_Shori1KekkaKubun = entity.upLoad_Shori1KekkaKubun;
        this.upLoad_Shori2kekkaKubun = entity.upLoad_Shori2kekkaKubun;
        this.upLoad_Shori3KekkaKubun = entity.upLoad_Shori3KekkaKubun;
        this.downLoad_Shori1KekkaKubun = entity.downLoad_Shori1KekkaKubun;
        this.downLoad_CodeHenkanKekkaKubun = entity.downLoad_CodeHenkanKekkaKubun;
        this.downLoad_MojiCodeHenkanKekkaKubun = entity.downLoad_MojiCodeHenkanKekkaKubun;
        this.downLoad_Soshin1KekkaKubun = entity.downLoad_Soshin1KekkaKubun;
        this.downLoad_shori2KekkaKubun = entity.downLoad_shori2KekkaKubun;
        this.downLoad_Jushon1KekkaKubun = entity.downLoad_Jushon1KekkaKubun;
        this.shoriMessage1 = entity.shoriMessage1;
        this.shoriMessage2 = entity.shoriMessage2;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoriNo, shubetsu, shoriID, motoShichosonCode, sakiShichosonCode, kekkaKubun, kakuninKubun, ShoriKaishiTimestamp, shoriShuryoTimestamp, logFileMei, hyojiJoken, messeage, rendoKeitai, upLoad_JushinKekkaKubun, upLoad_MojiCodeHenkanKekkaKubun, upLoad_Shori1KekkaKubun, upLoad_Shori2kekkaKubun, upLoad_Shori3KekkaKubun, downLoad_Shori1KekkaKubun, downLoad_CodeHenkanKekkaKubun, downLoad_MojiCodeHenkanKekkaKubun, downLoad_Soshin1KekkaKubun, downLoad_shori2KekkaKubun, downLoad_Jushon1KekkaKubun, shoriMessage1, shoriMessage2);
    }

// </editor-fold>
}
