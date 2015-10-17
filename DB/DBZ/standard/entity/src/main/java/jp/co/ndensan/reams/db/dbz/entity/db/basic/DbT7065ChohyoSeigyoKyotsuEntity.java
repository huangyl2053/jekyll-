package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import java.util.Objects;

/**
 * 帳票制御共通テーブルのエンティティクラスです。
 * <br/> 帳票制御のために必要な共通的な項目を管理します。
 */
public class DbT7065ChohyoSeigyoKyotsuEntity extends DbTableEntityBase<DbT7065ChohyoSeigyoKyotsuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7065ChohyoSeigyoKyotsu");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private SubGyomuCode subGyomuCode;
    @PrimaryKey
    private ReportId chohyoBunruiID;
    private RString chohyoBunruiMeisho;
    private RString jushoHenshuKubun;
    private boolean jushoHenshuTodoufukenMeiHyojiUmu;
    private boolean jushoHenshuGunMeiHyojiUmu;
    private boolean jushoHenshuShichosonMeiHyojiUmu;
    private RString jushoHenshuChoikiHenshuHoho;
    private boolean jushoHenshuKatagakiHyojiUmu;
    private boolean SetainushiHyojiUmu;
    private boolean customerBarCodeShiyoUmu;
    private RString customerBarCodeHenkanErrHenshuHoho;
    private RString gaibuChohyoMojigireSeigyo;
    private RString naibuChohyoMojigireSeigyo;
    private RString mojigireBunriSeigyo;
    private RString teikeibunMojiSize;
    private boolean kozaMaskUmu;
    private RString kozaMeigininKanaYusenKubun;
    private boolean daikoPrintUmu;
    private RString chikuHyoji1;
    private RString chikuHyoji2;
    private RString chikuHyoji3;

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
     * サブ業務コードのgetメソッドです。
     * 
     * @return サブ業務コード
     */
    public SubGyomuCode getSubGyomuCode() {
        return subGyomuCode;
    }

    /**
     * サブ業務コードのsetメソッドです。
     * 
     * @param subGyomuCode サブ業務コード
     */
    public void setSubGyomuCode(SubGyomuCode subGyomuCode) {
        this.subGyomuCode = subGyomuCode;
    }

    /**
     * 帳票分類IDのgetメソッドです。
     * 
     * @return 帳票分類ID
     */
    public ReportId getChohyoBunruiID() {
        return chohyoBunruiID;
    }

    /**
     * 帳票分類IDのsetメソッドです。
     * 
     * @param chohyoBunruiID 帳票分類ID
     */
    public void setChohyoBunruiID(ReportId chohyoBunruiID) {
        this.chohyoBunruiID = chohyoBunruiID;
    }

    /**
     * 帳票分類名称のgetメソッドです。
     * 
     * @return 帳票分類名称
     */
    public RString getChohyoBunruiMeisho() {
        return chohyoBunruiMeisho;
    }

    /**
     * 帳票分類名称のsetメソッドです。
     * 
     * @param chohyoBunruiMeisho 帳票分類名称
     */
    public void setChohyoBunruiMeisho(RString chohyoBunruiMeisho) {
        this.chohyoBunruiMeisho = chohyoBunruiMeisho;
    }

    /**
     * 住所編集区分のgetメソッドです。
     * <br/>
     * <br/>0:市町村共通　1:帳票独自
     * 
     * @return 住所編集区分
     */
    public RString getJushoHenshuKubun() {
        return jushoHenshuKubun;
    }

    /**
     * 住所編集区分のsetメソッドです。
     * <br/>
     * <br/>0:市町村共通　1:帳票独自
     * 
     * @param jushoHenshuKubun 住所編集区分
     */
    public void setJushoHenshuKubun(RString jushoHenshuKubun) {
        this.jushoHenshuKubun = jushoHenshuKubun;
    }

    /**
     * 住所編集都道府県名表示有無のgetメソッドです。
     * 
     * @return 住所編集都道府県名表示有無
     */
    public boolean getJushoHenshuTodoufukenMeiHyojiUmu() {
        return jushoHenshuTodoufukenMeiHyojiUmu;
    }

    /**
     * 住所編集都道府県名表示有無のsetメソッドです。
     * 
     * @param jushoHenshuTodoufukenMeiHyojiUmu 住所編集都道府県名表示有無
     */
    public void setJushoHenshuTodoufukenMeiHyojiUmu(boolean jushoHenshuTodoufukenMeiHyojiUmu) {
        this.jushoHenshuTodoufukenMeiHyojiUmu = jushoHenshuTodoufukenMeiHyojiUmu;
    }

    /**
     * 住所編集郡名表示有無のgetメソッドです。
     * 
     * @return 住所編集郡名表示有無
     */
    public boolean getJushoHenshuGunMeiHyojiUmu() {
        return jushoHenshuGunMeiHyojiUmu;
    }

    /**
     * 住所編集郡名表示有無のsetメソッドです。
     * 
     * @param jushoHenshuGunMeiHyojiUmu 住所編集郡名表示有無
     */
    public void setJushoHenshuGunMeiHyojiUmu(boolean jushoHenshuGunMeiHyojiUmu) {
        this.jushoHenshuGunMeiHyojiUmu = jushoHenshuGunMeiHyojiUmu;
    }

    /**
     * 住所編集市町村名表示有無のgetメソッドです。
     * 
     * @return 住所編集市町村名表示有無
     */
    public boolean getJushoHenshuShichosonMeiHyojiUmu() {
        return jushoHenshuShichosonMeiHyojiUmu;
    }

    /**
     * 住所編集市町村名表示有無のsetメソッドです。
     * 
     * @param jushoHenshuShichosonMeiHyojiUmu 住所編集市町村名表示有無
     */
    public void setJushoHenshuShichosonMeiHyojiUmu(boolean jushoHenshuShichosonMeiHyojiUmu) {
        this.jushoHenshuShichosonMeiHyojiUmu = jushoHenshuShichosonMeiHyojiUmu;
    }

    /**
     * 住所編集町域編集方法のgetメソッドです。
     * <br/>
     * <br/>1:住所＋番地　
     * <br/>2:行政区＋番地　
     * <br/>3:住所＋番地（行政区）　
     * <br/>4:番地のみ　
     * <br/>5:表示なし(住所は印字しない)
     * 
     * @return 住所編集町域編集方法
     */
    public RString getJushoHenshuChoikiHenshuHoho() {
        return jushoHenshuChoikiHenshuHoho;
    }

    /**
     * 住所編集町域編集方法のsetメソッドです。
     * <br/>
     * <br/>1:住所＋番地　
     * <br/>2:行政区＋番地　
     * <br/>3:住所＋番地（行政区）　
     * <br/>4:番地のみ　
     * <br/>5:表示なし(住所は印字しない)
     * 
     * @param jushoHenshuChoikiHenshuHoho 住所編集町域編集方法
     */
    public void setJushoHenshuChoikiHenshuHoho(RString jushoHenshuChoikiHenshuHoho) {
        this.jushoHenshuChoikiHenshuHoho = jushoHenshuChoikiHenshuHoho;
    }

    /**
     * 住所編集方書表示有無のgetメソッドです。
     * 
     * @return 住所編集方書表示有無
     */
    public boolean getJushoHenshuKatagakiHyojiUmu() {
        return jushoHenshuKatagakiHyojiUmu;
    }

    /**
     * 住所編集方書表示有無のsetメソッドです。
     * 
     * @param jushoHenshuKatagakiHyojiUmu 住所編集方書表示有無
     */
    public void setJushoHenshuKatagakiHyojiUmu(boolean jushoHenshuKatagakiHyojiUmu) {
        this.jushoHenshuKatagakiHyojiUmu = jushoHenshuKatagakiHyojiUmu;
    }

    /**
     * 世帯主表示有無のgetメソッドです。
     * 
     * @return 世帯主表示有無
     */
    public boolean getSetainushiHyojiUmu() {
        return SetainushiHyojiUmu;
    }

    /**
     * 世帯主表示有無のsetメソッドです。
     * 
     * @param SetainushiHyojiUmu 世帯主表示有無
     */
    public void setSetainushiHyojiUmu(boolean SetainushiHyojiUmu) {
        this.SetainushiHyojiUmu = SetainushiHyojiUmu;
    }

    /**
     * カスタマバーコード使用有無のgetメソッドです。
     * 
     * @return カスタマバーコード使用有無
     */
    public boolean getCustomerBarCodeShiyoUmu() {
        return customerBarCodeShiyoUmu;
    }

    /**
     * カスタマバーコード使用有無のsetメソッドです。
     * 
     * @param customerBarCodeShiyoUmu カスタマバーコード使用有無
     */
    public void setCustomerBarCodeShiyoUmu(boolean customerBarCodeShiyoUmu) {
        this.customerBarCodeShiyoUmu = customerBarCodeShiyoUmu;
    }

    /**
     * カスタマバーコード変換エラー編集方法のgetメソッドです。
     * <br/>
     * <br/>1:空白をセット  2:入力郵便番号をセット
     * 
     * @return カスタマバーコード変換エラー編集方法
     */
    public RString getCustomerBarCodeHenkanErrHenshuHoho() {
        return customerBarCodeHenkanErrHenshuHoho;
    }

    /**
     * カスタマバーコード変換エラー編集方法のsetメソッドです。
     * <br/>
     * <br/>1:空白をセット  2:入力郵便番号をセット
     * 
     * @param customerBarCodeHenkanErrHenshuHoho カスタマバーコード変換エラー編集方法
     */
    public void setCustomerBarCodeHenkanErrHenshuHoho(RString customerBarCodeHenkanErrHenshuHoho) {
        this.customerBarCodeHenkanErrHenshuHoho = customerBarCodeHenkanErrHenshuHoho;
    }

    /**
     * 外部帳票文字切れ制御のgetメソッドです。
     * <br/>
     * <br/>0:印字しない　1:印字可能範囲まで印字する
     * 
     * @return 外部帳票文字切れ制御
     */
    public RString getGaibuChohyoMojigireSeigyo() {
        return gaibuChohyoMojigireSeigyo;
    }

    /**
     * 外部帳票文字切れ制御のsetメソッドです。
     * <br/>
     * <br/>0:印字しない　1:印字可能範囲まで印字する
     * 
     * @param gaibuChohyoMojigireSeigyo 外部帳票文字切れ制御
     */
    public void setGaibuChohyoMojigireSeigyo(RString gaibuChohyoMojigireSeigyo) {
        this.gaibuChohyoMojigireSeigyo = gaibuChohyoMojigireSeigyo;
    }

    /**
     * 内部帳票文字切れ制御のgetメソッドです。
     * <br/>
     * <br/>1:印字可能範囲まで印字する　2:オーバーフローマークを印字する
     * 
     * @return 内部帳票文字切れ制御
     */
    public RString getNaibuChohyoMojigireSeigyo() {
        return naibuChohyoMojigireSeigyo;
    }

    /**
     * 内部帳票文字切れ制御のsetメソッドです。
     * <br/>
     * <br/>1:印字可能範囲まで印字する　2:オーバーフローマークを印字する
     * 
     * @param naibuChohyoMojigireSeigyo 内部帳票文字切れ制御
     */
    public void setNaibuChohyoMojigireSeigyo(RString naibuChohyoMojigireSeigyo) {
        this.naibuChohyoMojigireSeigyo = naibuChohyoMojigireSeigyo;
    }

    /**
     * 文字切れ分離制御のgetメソッドです。
     * <br/>
     * <br/>0:山分けしない　1:山分けする
     * 
     * @return 文字切れ分離制御
     */
    public RString getMojigireBunriSeigyo() {
        return mojigireBunriSeigyo;
    }

    /**
     * 文字切れ分離制御のsetメソッドです。
     * <br/>
     * <br/>0:山分けしない　1:山分けする
     * 
     * @param mojigireBunriSeigyo 文字切れ分離制御
     */
    public void setMojigireBunriSeigyo(RString mojigireBunriSeigyo) {
        this.mojigireBunriSeigyo = mojigireBunriSeigyo;
    }

    /**
     * 定型文文字サイズのgetメソッドです。
     * <br/>
     * <br/>1:フォント小　
     * <br/>2:フォント大　
     * <br/>3:フォント上小下大　
     * <br/>4:フォント上大下小
     * 
     * @return 定型文文字サイズ
     */
    public RString getTeikeibunMojiSize() {
        return teikeibunMojiSize;
    }

    /**
     * 定型文文字サイズのsetメソッドです。
     * <br/>
     * <br/>1:フォント小　
     * <br/>2:フォント大　
     * <br/>3:フォント上小下大　
     * <br/>4:フォント上大下小
     * 
     * @param teikeibunMojiSize 定型文文字サイズ
     */
    public void setTeikeibunMojiSize(RString teikeibunMojiSize) {
        this.teikeibunMojiSize = teikeibunMojiSize;
    }

    /**
     * 口座マスク有無のgetメソッドです。
     * 
     * @return 口座マスク有無
     */
    public boolean getKozaMaskUmu() {
        return kozaMaskUmu;
    }

    /**
     * 口座マスク有無のsetメソッドです。
     * 
     * @param kozaMaskUmu 口座マスク有無
     */
    public void setKozaMaskUmu(boolean kozaMaskUmu) {
        this.kozaMaskUmu = kozaMaskUmu;
    }

    /**
     * 口座名義人カナ優先区分のgetメソッドです。
     * <br/>
     * <br/>0:表示しない　1:表示する
     * 
     * @return 口座名義人カナ優先区分
     */
    public RString getKozaMeigininKanaYusenKubun() {
        return kozaMeigininKanaYusenKubun;
    }

    /**
     * 口座名義人カナ優先区分のsetメソッドです。
     * <br/>
     * <br/>0:表示しない　1:表示する
     * 
     * @param kozaMeigininKanaYusenKubun 口座名義人カナ優先区分
     */
    public void setKozaMeigininKanaYusenKubun(RString kozaMeigininKanaYusenKubun) {
        this.kozaMeigininKanaYusenKubun = kozaMeigininKanaYusenKubun;
    }

    /**
     * 代行プリント有無のgetメソッドです。
     * 
     * @return 代行プリント有無
     */
    public boolean getDaikoPrintUmu() {
        return daikoPrintUmu;
    }

    /**
     * 代行プリント有無のsetメソッドです。
     * 
     * @param daikoPrintUmu 代行プリント有無
     */
    public void setDaikoPrintUmu(boolean daikoPrintUmu) {
        this.daikoPrintUmu = daikoPrintUmu;
    }

    /**
     * 地区表示1のgetメソッドです。
     * <br/>
     * <br/>0:なし　
     * <br/>1:住所コード　
     * <br/>2:行政区コード
     * 
     * @return 地区表示1
     */
    public RString getChikuHyoji1() {
        return chikuHyoji1;
    }

    /**
     * 地区表示1のsetメソッドです。
     * <br/>
     * <br/>0:なし　
     * <br/>1:住所コード　
     * <br/>2:行政区コード
     * 
     * @param chikuHyoji1 地区表示1
     */
    public void setChikuHyoji1(RString chikuHyoji1) {
        this.chikuHyoji1 = chikuHyoji1;
    }

    /**
     * 地区表示2のgetメソッドです。
     * <br/>
     * <br/>0:なし　
     * <br/>3:地区コード１　
     * <br/>4:地区コード２　
     * <br/>5:地区コード３　
     * <br/>6:納組コード
     * 
     * @return 地区表示2
     */
    public RString getChikuHyoji2() {
        return chikuHyoji2;
    }

    /**
     * 地区表示2のsetメソッドです。
     * <br/>
     * <br/>0:なし　
     * <br/>3:地区コード１　
     * <br/>4:地区コード２　
     * <br/>5:地区コード３　
     * <br/>6:納組コード
     * 
     * @param chikuHyoji2 地区表示2
     */
    public void setChikuHyoji2(RString chikuHyoji2) {
        this.chikuHyoji2 = chikuHyoji2;
    }

    /**
     * 地区表示3のgetメソッドです。
     * <br/>
     * <br/>0:なし　
     * <br/>3:地区コード１　
     * <br/>4:地区コード２　
     * <br/>5:地区コード３　
     * <br/>6:納組コード
     * 
     * @return 地区表示3
     */
    public RString getChikuHyoji3() {
        return chikuHyoji3;
    }

    /**
     * 地区表示3のsetメソッドです。
     * <br/>
     * <br/>0:なし　
     * <br/>3:地区コード１　
     * <br/>4:地区コード２　
     * <br/>5:地区コード３　
     * <br/>6:納組コード
     * 
     * @param chikuHyoji3 地区表示3
     */
    public void setChikuHyoji3(RString chikuHyoji3) {
        this.chikuHyoji3 = chikuHyoji3;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7065ChohyoSeigyoKyotsuEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7065ChohyoSeigyoKyotsuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7065ChohyoSeigyoKyotsuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.subGyomuCode, other.subGyomuCode)) {
            return false;
        }
        if (!Objects.equals(this.chohyoBunruiID, other.chohyoBunruiID)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7065ChohyoSeigyoKyotsuEntity entity) {
        this.subGyomuCode = entity.subGyomuCode;
        this.chohyoBunruiID = entity.chohyoBunruiID;
        this.chohyoBunruiMeisho = entity.chohyoBunruiMeisho;
        this.jushoHenshuKubun = entity.jushoHenshuKubun;
        this.jushoHenshuTodoufukenMeiHyojiUmu = entity.jushoHenshuTodoufukenMeiHyojiUmu;
        this.jushoHenshuGunMeiHyojiUmu = entity.jushoHenshuGunMeiHyojiUmu;
        this.jushoHenshuShichosonMeiHyojiUmu = entity.jushoHenshuShichosonMeiHyojiUmu;
        this.jushoHenshuChoikiHenshuHoho = entity.jushoHenshuChoikiHenshuHoho;
        this.jushoHenshuKatagakiHyojiUmu = entity.jushoHenshuKatagakiHyojiUmu;
        this.SetainushiHyojiUmu = entity.SetainushiHyojiUmu;
        this.customerBarCodeShiyoUmu = entity.customerBarCodeShiyoUmu;
        this.customerBarCodeHenkanErrHenshuHoho = entity.customerBarCodeHenkanErrHenshuHoho;
        this.gaibuChohyoMojigireSeigyo = entity.gaibuChohyoMojigireSeigyo;
        this.naibuChohyoMojigireSeigyo = entity.naibuChohyoMojigireSeigyo;
        this.mojigireBunriSeigyo = entity.mojigireBunriSeigyo;
        this.teikeibunMojiSize = entity.teikeibunMojiSize;
        this.kozaMaskUmu = entity.kozaMaskUmu;
        this.kozaMeigininKanaYusenKubun = entity.kozaMeigininKanaYusenKubun;
        this.daikoPrintUmu = entity.daikoPrintUmu;
        this.chikuHyoji1 = entity.chikuHyoji1;
        this.chikuHyoji2 = entity.chikuHyoji2;
        this.chikuHyoji3 = entity.chikuHyoji3;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(subGyomuCode, chohyoBunruiID, chohyoBunruiMeisho, jushoHenshuKubun, jushoHenshuTodoufukenMeiHyojiUmu, jushoHenshuGunMeiHyojiUmu, jushoHenshuShichosonMeiHyojiUmu, jushoHenshuChoikiHenshuHoho, jushoHenshuKatagakiHyojiUmu, SetainushiHyojiUmu, customerBarCodeShiyoUmu, customerBarCodeHenkanErrHenshuHoho, gaibuChohyoMojigireSeigyo, naibuChohyoMojigireSeigyo, mojigireBunriSeigyo, teikeibunMojiSize, kozaMaskUmu, kozaMeigininKanaYusenKubun, daikoPrintUmu, chikuHyoji1, chikuHyoji2, chikuHyoji3);
    }

// </editor-fold>
}
