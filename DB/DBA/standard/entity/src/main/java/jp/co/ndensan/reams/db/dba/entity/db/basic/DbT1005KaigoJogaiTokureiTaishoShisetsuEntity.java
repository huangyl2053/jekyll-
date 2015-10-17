package jp.co.ndensan.reams.db.dba.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import java.util.Objects;

/**
 * 介護除外住所地特例対象施設テーブルのエンティティクラスです。
 */
public class DbT1005KaigoJogaiTokureiTaishoShisetsuEntity extends DbTableEntityBase<DbT1005KaigoJogaiTokureiTaishoShisetsuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT1005KaigoJogaiTokureiTaishoShisetsu");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString jigyoshaShubetsu;
    @PrimaryKey
    private RString jigyoshaNo;
    @PrimaryKey
    private FlexibleDate yukoKaishiYMD;
    private FlexibleDate yukoShuryoYMD;
    private RString kannaiKangaiKubun;
    private AtenaMeisho jigyoshaMeisho;
    private AtenaKanaMeisho jigyoshaKanaMeisho;
    private YubinNo yubinNo;
    private RString jigyoshaJusho;
    private RString jigyoshaKanaJusho;
    private TelNo telNo;
    private TelNo faxNo;
    private RString idoJiyuCode;
    private FlexibleDate idoYMD;
    private AtenaMeisho daihyoshaMeisho;
    private AtenaKanaMeisho daihyoshaKanaMeisho;
    private RString yakushoku;
    private RString biko;
    private FlexibleDate jigyoKaishiYMD;
    private FlexibleDate jigyoKyushiYMD;
    private FlexibleDate jigyoHaishiYMD;
    private FlexibleDate jigyoSaikaiYMD;

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
     * 事業者種別のgetメソッドです。
     * 
     * @return 事業者種別
     */
    public RString getJigyoshaShubetsu() {
        return jigyoshaShubetsu;
    }

    /**
     * 事業者種別のsetメソッドです。
     * 
     * @param jigyoshaShubetsu 事業者種別
     */
    public void setJigyoshaShubetsu(RString jigyoshaShubetsu) {
        this.jigyoshaShubetsu = jigyoshaShubetsu;
    }

    /**
     * 事業者番号のgetメソッドです。
     * 
     * @return 事業者番号
     */
    public RString getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * 事業者番号のsetメソッドです。
     * 
     * @param jigyoshaNo 事業者番号
     */
    public void setJigyoshaNo(RString jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * 有効開始年月日のgetメソッドです。
     * 
     * @return 有効開始年月日
     */
    public FlexibleDate getYukoKaishiYMD() {
        return yukoKaishiYMD;
    }

    /**
     * 有効開始年月日のsetメソッドです。
     * 
     * @param yukoKaishiYMD 有効開始年月日
     */
    public void setYukoKaishiYMD(FlexibleDate yukoKaishiYMD) {
        this.yukoKaishiYMD = yukoKaishiYMD;
    }

    /**
     * 有効終了年月日のgetメソッドです。
     * 
     * @return 有効終了年月日
     */
    public FlexibleDate getYukoShuryoYMD() {
        return yukoShuryoYMD;
    }

    /**
     * 有効終了年月日のsetメソッドです。
     * 
     * @param yukoShuryoYMD 有効終了年月日
     */
    public void setYukoShuryoYMD(FlexibleDate yukoShuryoYMD) {
        this.yukoShuryoYMD = yukoShuryoYMD;
    }

    /**
     * 管内・管外区分のgetメソッドです。
     * <br/>
     * <br/>1:管内、2:管外
     * 
     * @return 管内・管外区分
     */
    public RString getKannaiKangaiKubun() {
        return kannaiKangaiKubun;
    }

    /**
     * 管内・管外区分のsetメソッドです。
     * <br/>
     * <br/>1:管内、2:管外
     * 
     * @param kannaiKangaiKubun 管内・管外区分
     */
    public void setKannaiKangaiKubun(RString kannaiKangaiKubun) {
        this.kannaiKangaiKubun = kannaiKangaiKubun;
    }

    /**
     * 事業者名称のgetメソッドです。
     * 
     * @return 事業者名称
     */
    public AtenaMeisho getJigyoshaMeisho() {
        return jigyoshaMeisho;
    }

    /**
     * 事業者名称のsetメソッドです。
     * 
     * @param jigyoshaMeisho 事業者名称
     */
    public void setJigyoshaMeisho(AtenaMeisho jigyoshaMeisho) {
        this.jigyoshaMeisho = jigyoshaMeisho;
    }

    /**
     * 事業者名称カナのgetメソッドです。
     * 
     * @return 事業者名称カナ
     */
    public AtenaKanaMeisho getJigyoshaKanaMeisho() {
        return jigyoshaKanaMeisho;
    }

    /**
     * 事業者名称カナのsetメソッドです。
     * 
     * @param jigyoshaKanaMeisho 事業者名称カナ
     */
    public void setJigyoshaKanaMeisho(AtenaKanaMeisho jigyoshaKanaMeisho) {
        this.jigyoshaKanaMeisho = jigyoshaKanaMeisho;
    }

    /**
     * 郵便番号のgetメソッドです。
     * 
     * @return 郵便番号
     */
    public YubinNo getYubinNo() {
        return yubinNo;
    }

    /**
     * 郵便番号のsetメソッドです。
     * 
     * @param yubinNo 郵便番号
     */
    public void setYubinNo(YubinNo yubinNo) {
        this.yubinNo = yubinNo;
    }

    /**
     * 事業者住所のgetメソッドです。
     * 
     * @return 事業者住所
     */
    public RString getJigyoshaJusho() {
        return jigyoshaJusho;
    }

    /**
     * 事業者住所のsetメソッドです。
     * 
     * @param jigyoshaJusho 事業者住所
     */
    public void setJigyoshaJusho(RString jigyoshaJusho) {
        this.jigyoshaJusho = jigyoshaJusho;
    }

    /**
     * 事業者住所カナのgetメソッドです。
     * 
     * @return 事業者住所カナ
     */
    public RString getJigyoshaKanaJusho() {
        return jigyoshaKanaJusho;
    }

    /**
     * 事業者住所カナのsetメソッドです。
     * 
     * @param jigyoshaKanaJusho 事業者住所カナ
     */
    public void setJigyoshaKanaJusho(RString jigyoshaKanaJusho) {
        this.jigyoshaKanaJusho = jigyoshaKanaJusho;
    }

    /**
     * 電話番号のgetメソッドです。
     * 
     * @return 電話番号
     */
    public TelNo getTelNo() {
        return telNo;
    }

    /**
     * 電話番号のsetメソッドです。
     * 
     * @param telNo 電話番号
     */
    public void setTelNo(TelNo telNo) {
        this.telNo = telNo;
    }

    /**
     * FAX番号のgetメソッドです。
     * 
     * @return FAX番号
     */
    public TelNo getFaxNo() {
        return faxNo;
    }

    /**
     * FAX番号のsetメソッドです。
     * 
     * @param faxNo FAX番号
     */
    public void setFaxNo(TelNo faxNo) {
        this.faxNo = faxNo;
    }

    /**
     * 異動事由のgetメソッドです。
     * 
     * @return 異動事由
     */
    public RString getIdoJiyuCode() {
        return idoJiyuCode;
    }

    /**
     * 異動事由のsetメソッドです。
     * 
     * @param idoJiyuCode 異動事由
     */
    public void setIdoJiyuCode(RString idoJiyuCode) {
        this.idoJiyuCode = idoJiyuCode;
    }

    /**
     * 異動年月日のgetメソッドです。
     * 
     * @return 異動年月日
     */
    public FlexibleDate getIdoYMD() {
        return idoYMD;
    }

    /**
     * 異動年月日のsetメソッドです。
     * 
     * @param idoYMD 異動年月日
     */
    public void setIdoYMD(FlexibleDate idoYMD) {
        this.idoYMD = idoYMD;
    }

    /**
     * 代表者名称のgetメソッドです。
     * 
     * @return 代表者名称
     */
    public AtenaMeisho getDaihyoshaMeisho() {
        return daihyoshaMeisho;
    }

    /**
     * 代表者名称のsetメソッドです。
     * 
     * @param daihyoshaMeisho 代表者名称
     */
    public void setDaihyoshaMeisho(AtenaMeisho daihyoshaMeisho) {
        this.daihyoshaMeisho = daihyoshaMeisho;
    }

    /**
     * 代表者名称カナのgetメソッドです。
     * 
     * @return 代表者名称カナ
     */
    public AtenaKanaMeisho getDaihyoshaKanaMeisho() {
        return daihyoshaKanaMeisho;
    }

    /**
     * 代表者名称カナのsetメソッドです。
     * 
     * @param daihyoshaKanaMeisho 代表者名称カナ
     */
    public void setDaihyoshaKanaMeisho(AtenaKanaMeisho daihyoshaKanaMeisho) {
        this.daihyoshaKanaMeisho = daihyoshaKanaMeisho;
    }

    /**
     * 役職のgetメソッドです。
     * 
     * @return 役職
     */
    public RString getYakushoku() {
        return yakushoku;
    }

    /**
     * 役職のsetメソッドです。
     * 
     * @param yakushoku 役職
     */
    public void setYakushoku(RString yakushoku) {
        this.yakushoku = yakushoku;
    }

    /**
     * 備考のgetメソッドです。
     * 
     * @return 備考
     */
    public RString getBiko() {
        return biko;
    }

    /**
     * 備考のsetメソッドです。
     * 
     * @param biko 備考
     */
    public void setBiko(RString biko) {
        this.biko = biko;
    }

    /**
     * 事業開始年月日のgetメソッドです。
     * 
     * @return 事業開始年月日
     */
    public FlexibleDate getJigyoKaishiYMD() {
        return jigyoKaishiYMD;
    }

    /**
     * 事業開始年月日のsetメソッドです。
     * 
     * @param jigyoKaishiYMD 事業開始年月日
     */
    public void setJigyoKaishiYMD(FlexibleDate jigyoKaishiYMD) {
        this.jigyoKaishiYMD = jigyoKaishiYMD;
    }

    /**
     * 事業休止年月日のgetメソッドです。
     * 
     * @return 事業休止年月日
     */
    public FlexibleDate getJigyoKyushiYMD() {
        return jigyoKyushiYMD;
    }

    /**
     * 事業休止年月日のsetメソッドです。
     * 
     * @param jigyoKyushiYMD 事業休止年月日
     */
    public void setJigyoKyushiYMD(FlexibleDate jigyoKyushiYMD) {
        this.jigyoKyushiYMD = jigyoKyushiYMD;
    }

    /**
     * 事業廃止年月日のgetメソッドです。
     * 
     * @return 事業廃止年月日
     */
    public FlexibleDate getJigyoHaishiYMD() {
        return jigyoHaishiYMD;
    }

    /**
     * 事業廃止年月日のsetメソッドです。
     * 
     * @param jigyoHaishiYMD 事業廃止年月日
     */
    public void setJigyoHaishiYMD(FlexibleDate jigyoHaishiYMD) {
        this.jigyoHaishiYMD = jigyoHaishiYMD;
    }

    /**
     * 事業再開年月日のgetメソッドです。
     * 
     * @return 事業再開年月日
     */
    public FlexibleDate getJigyoSaikaiYMD() {
        return jigyoSaikaiYMD;
    }

    /**
     * 事業再開年月日のsetメソッドです。
     * 
     * @param jigyoSaikaiYMD 事業再開年月日
     */
    public void setJigyoSaikaiYMD(FlexibleDate jigyoSaikaiYMD) {
        this.jigyoSaikaiYMD = jigyoSaikaiYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT1005KaigoJogaiTokureiTaishoShisetsuEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT1005KaigoJogaiTokureiTaishoShisetsuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.jigyoshaShubetsu, other.jigyoshaShubetsu)) {
            return false;
        }
        if (!Objects.equals(this.jigyoshaNo, other.jigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.yukoKaishiYMD, other.yukoKaishiYMD)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity) {
        this.jigyoshaShubetsu = entity.jigyoshaShubetsu;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.yukoKaishiYMD = entity.yukoKaishiYMD;
        this.yukoShuryoYMD = entity.yukoShuryoYMD;
        this.kannaiKangaiKubun = entity.kannaiKangaiKubun;
        this.jigyoshaMeisho = entity.jigyoshaMeisho;
        this.jigyoshaKanaMeisho = entity.jigyoshaKanaMeisho;
        this.yubinNo = entity.yubinNo;
        this.jigyoshaJusho = entity.jigyoshaJusho;
        this.jigyoshaKanaJusho = entity.jigyoshaKanaJusho;
        this.telNo = entity.telNo;
        this.faxNo = entity.faxNo;
        this.idoJiyuCode = entity.idoJiyuCode;
        this.idoYMD = entity.idoYMD;
        this.daihyoshaMeisho = entity.daihyoshaMeisho;
        this.daihyoshaKanaMeisho = entity.daihyoshaKanaMeisho;
        this.yakushoku = entity.yakushoku;
        this.biko = entity.biko;
        this.jigyoKaishiYMD = entity.jigyoKaishiYMD;
        this.jigyoKyushiYMD = entity.jigyoKyushiYMD;
        this.jigyoHaishiYMD = entity.jigyoHaishiYMD;
        this.jigyoSaikaiYMD = entity.jigyoSaikaiYMD;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(jigyoshaShubetsu, jigyoshaNo, yukoKaishiYMD, yukoShuryoYMD, kannaiKangaiKubun, jigyoshaMeisho, jigyoshaKanaMeisho, yubinNo, jigyoshaJusho, jigyoshaKanaJusho, telNo, faxNo, idoJiyuCode, idoYMD, daihyoshaMeisho, daihyoshaKanaMeisho, yakushoku, biko, jigyoKaishiYMD, jigyoKyushiYMD, jigyoHaishiYMD, jigyoSaikaiYMD);
    }

// </editor-fold>
}
