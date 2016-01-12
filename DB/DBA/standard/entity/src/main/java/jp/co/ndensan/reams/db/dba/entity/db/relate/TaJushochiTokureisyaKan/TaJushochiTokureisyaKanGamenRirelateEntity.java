/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.TaJushochiTokureisyaKan;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoTatokuKaijoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoTatokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 *
 * 他住所地特例者管理のRelateEntityクラスです。
 */
public class TaJushochiTokureisyaKanGamenRirelateEntity {

    private RString joutai;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private FlexibleDate idoYMD;
    @PrimaryKey
    private RString edaNo;
    private RString idoJiyuCode;
    private LasdecCode shichosonCode;
    private KaigoTatokuTekiyoJiyu tekiyoJiyuCode;
    private FlexibleDate tekiyoYMD;
    private FlexibleDate tekiyoTodokedeYMD;
    private FlexibleDate tekiyoUketsukeYMD;
    private KaigoTatokuKaijoJiyu kaijoJiyuCode;
    private FlexibleDate kaijoYMD;
    private FlexibleDate kaijoTodokedeYMD;
    private FlexibleDate kaijoUketsukeYMD;
    private ShoKisaiHokenshaNo sochiHokenshaNo;
    private HihokenshaNo sochiHihokenshaNo;
    private FlexibleDate tatokuRenrakuhyoHakkoYMD;
    private FlexibleDate shisetsuTaishoTsuchiHakkoYMD;
    private FlexibleDate shisetsuHenkoTsuchiHakkoYMD;
    private boolean logicalDeletedFlag;
    private RString tekiyouZiyuuCode;
    private RString kaijoZiyuuCode;
    @PrimaryKey
    private Decimal rirekiNo;
    private RString daichoShubetsu;
    private RString nyushoShisetsuShurui;
    private JigyoshaNo nyushoShisetsuCode;
    private FlexibleDate nyushoShoriYMD;
    private FlexibleDate nyushoYMD;
    private FlexibleDate taishoShoriYMD;
    private FlexibleDate taishoYMD;
    private RString roomKigoNo;

    /**
     * 状態のgetメソッドです。
     *
     * @return 状態
     */
    public RString getJoutai() {
        return joutai;
    }

    /**
     * 状態のsetメソッドです。
     *
     * @param joutai 状態
     */
    public void setJoutai(RString joutai) {
        this.joutai = joutai;
    }

    /**
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     *
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 異動日のgetメソッドです。
     *
     * @return 異動日
     */
    public FlexibleDate getIdoYMD() {
        return idoYMD;
    }

    /**
     * 異動日のsetメソッドです。
     *
     * @param idoYMD 異動日
     */
    public void setIdoYMD(FlexibleDate idoYMD) {
        this.idoYMD = idoYMD;
    }

    /**
     * 枝番のgetメソッドです。
     *
     * @return 枝番
     */
    public RString getEdaNo() {
        return edaNo;
    }

    /**
     * 枝番のsetメソッドです。
     *
     * @param edaNo 枝番
     */
    public void setEdaNo(RString edaNo) {
        this.edaNo = edaNo;
    }

    /**
     * 異動事由コードのgetメソッドです。
     *
     * @return 異動事由コード
     */
    public RString getIdoJiyuCode() {
        return idoJiyuCode;
    }

    /**
     * 異動事由コードのsetメソッドです。
     *
     * @param idoJiyuCode 異動事由コード
     */
    public void setIdoJiyuCode(RString idoJiyuCode) {
        this.idoJiyuCode = idoJiyuCode;
    }

    /**
     * 市町村コードのgetメソッドです。
     *
     * @return 市町村コード
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * 市町村コードのsetメソッドです。
     *
     * @param shichosonCode 市町村コード
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * 他市町村住所地特例適用事由コードのgetメソッドです。
     *
     * @return 他市町村住所地特例適用事由コード
     */
    public KaigoTatokuTekiyoJiyu getTekiyoJiyuCode() {
        return tekiyoJiyuCode;
    }

    /**
     * 他市町村住所地特例適用事由コードのsetメソッドです。
     *
     * @param tekiyoJiyuCode 他市町村住所地特例適用事由コード
     */
    public void setTekiyoJiyuCode(KaigoTatokuTekiyoJiyu tekiyoJiyuCode) {
        this.tekiyoJiyuCode = tekiyoJiyuCode;
    }

    /**
     * 適用年月日のgetメソッドです。
     *
     * @return 適用年月日
     */
    public FlexibleDate getTekiyoYMD() {
        return tekiyoYMD;
    }

    /**
     * 適用年月日のsetメソッドです。
     *
     * @param tekiyoYMD 適用年月日
     */
    public void setTekiyoYMD(FlexibleDate tekiyoYMD) {
        this.tekiyoYMD = tekiyoYMD;
    }

    /**
     * 適用届出年月日のgetメソッドです。
     *
     * @return 適用届出年月日
     */
    public FlexibleDate getTekiyoTodokedeYMD() {
        return tekiyoTodokedeYMD;
    }

    /**
     * 適用届出年月日のsetメソッドです。
     *
     * @param tekiyoTodokedeYMD 適用届出年月日
     */
    public void setTekiyoTodokedeYMD(FlexibleDate tekiyoTodokedeYMD) {
        this.tekiyoTodokedeYMD = tekiyoTodokedeYMD;
    }

    /**
     * 適用受付年月日のgetメソッドです。
     *
     * @return 適用受付年月日
     */
    public FlexibleDate getTekiyoUketsukeYMD() {
        return tekiyoUketsukeYMD;
    }

    /**
     * 適用受付年月日のsetメソッドです。
     *
     * @param tekiyoUketsukeYMD 適用受付年月日
     */
    public void setTekiyoUketsukeYMD(FlexibleDate tekiyoUketsukeYMD) {
        this.tekiyoUketsukeYMD = tekiyoUketsukeYMD;
    }

    /**
     * 他市町村住所地特例解除事由コードのgetメソッドです。
     *
     * @return 他市町村住所地特例解除事由コード
     */
    public KaigoTatokuKaijoJiyu getKaijoJiyuCode() {
        return kaijoJiyuCode;
    }

    /**
     * 他市町村住所地特例解除事由コードのsetメソッドです。
     *
     * @param kaijoJiyuCode 他市町村住所地特例解除事由コード
     */
    public void setKaijoJiyuCode(KaigoTatokuKaijoJiyu kaijoJiyuCode) {
        this.kaijoJiyuCode = kaijoJiyuCode;
    }

    /**
     * 解除年月日のgetメソッドです。
     *
     * @return 解除年月日
     */
    public FlexibleDate getKaijoYMD() {
        return kaijoYMD;
    }

    /**
     * 解除年月日のsetメソッドです。
     *
     * @param kaijoYMD 解除年月日
     */
    public void setKaijoYMD(FlexibleDate kaijoYMD) {
        this.kaijoYMD = kaijoYMD;
    }

    /**
     * 解除届出年月日のgetメソッドです。
     *
     * @return 解除届出年月日
     */
    public FlexibleDate getKaijoTodokedeYMD() {
        return kaijoTodokedeYMD;
    }

    /**
     * 解除届出年月日のsetメソッドです。
     *
     * @param kaijoTodokedeYMD 解除届出年月日
     */
    public void setKaijoTodokedeYMD(FlexibleDate kaijoTodokedeYMD) {
        this.kaijoTodokedeYMD = kaijoTodokedeYMD;
    }

    /**
     * 解除受付年月日のgetメソッドです。
     *
     * @return 解除受付年月日
     */
    public FlexibleDate getKaijoUketsukeYMD() {
        return kaijoUketsukeYMD;
    }

    /**
     * 解除受付年月日のsetメソッドです。
     *
     * @param kaijoUketsukeYMD 解除受付年月日
     */
    public void setKaijoUketsukeYMD(FlexibleDate kaijoUketsukeYMD) {
        this.kaijoUketsukeYMD = kaijoUketsukeYMD;
    }

    /**
     * 措置保険者番号のgetメソッドです。
     *
     * @return 措置保険者番号
     */
    public ShoKisaiHokenshaNo getSochiHokenshaNo() {
        return sochiHokenshaNo;
    }

    /**
     * 措置保険者番号のsetメソッドです。
     *
     * @param sochiHokenshaNo 措置保険者番号
     */
    public void setSochiHokenshaNo(ShoKisaiHokenshaNo sochiHokenshaNo) {
        this.sochiHokenshaNo = sochiHokenshaNo;
    }

    /**
     * 措置被保険者番号のgetメソッドです。
     *
     * @return 措置被保険者番号
     */
    public HihokenshaNo getSochiHihokenshaNo() {
        return sochiHihokenshaNo;
    }

    /**
     * 措置被保険者番号のsetメソッドです。
     *
     * @param sochiHihokenshaNo 措置被保険者番号
     */
    public void setSochiHihokenshaNo(HihokenshaNo sochiHihokenshaNo) {
        this.sochiHihokenshaNo = sochiHihokenshaNo;
    }

    /**
     * 他特例連絡票発行年月日のgetメソッドです。
     *
     * @return 他特例連絡票発行年月日
     */
    public FlexibleDate getTatokuRenrakuhyoHakkoYMD() {
        return tatokuRenrakuhyoHakkoYMD;
    }

    /**
     * 他特例連絡票発行年月日のsetメソッドです。
     *
     * @param tatokuRenrakuhyoHakkoYMD 他特例連絡票発行年月日
     */
    public void setTatokuRenrakuhyoHakkoYMD(FlexibleDate tatokuRenrakuhyoHakkoYMD) {
        this.tatokuRenrakuhyoHakkoYMD = tatokuRenrakuhyoHakkoYMD;
    }

    /**
     * 施設退所通知発行年月日のgetメソッドです。
     *
     * @return 施設退所通知発行年月日
     */
    public FlexibleDate getShisetsuTaishoTsuchiHakkoYMD() {
        return shisetsuTaishoTsuchiHakkoYMD;
    }

    /**
     * 施設退所通知発行年月日のsetメソッドです。
     *
     * @param shisetsuTaishoTsuchiHakkoYMD 施設退所通知発行年月日
     */
    public void setShisetsuTaishoTsuchiHakkoYMD(FlexibleDate shisetsuTaishoTsuchiHakkoYMD) {
        this.shisetsuTaishoTsuchiHakkoYMD = shisetsuTaishoTsuchiHakkoYMD;
    }

    /**
     * 施設変更通知発行年月日のgetメソッドです。
     *
     * @return 施設変更通知発行年月日
     */
    public FlexibleDate getShisetsuHenkoTsuchiHakkoYMD() {
        return shisetsuHenkoTsuchiHakkoYMD;
    }

    /**
     * 施設変更通知発行年月日のsetメソッドです。
     *
     * @param shisetsuHenkoTsuchiHakkoYMD 施設変更通知発行年月日
     */
    public void setShisetsuHenkoTsuchiHakkoYMD(FlexibleDate shisetsuHenkoTsuchiHakkoYMD) {
        this.shisetsuHenkoTsuchiHakkoYMD = shisetsuHenkoTsuchiHakkoYMD;
    }

    /**
     * 論理削除フラグのgetメソッドです。
     *
     * @return 論理削除フラグ
     */
    public boolean getLogicalDeletedFlag() {
        return logicalDeletedFlag;
    }

    /**
     * 論理削除フラグのsetメソッドです。
     *
     * @param logicalDeletedFlag 論理削除フラグ
     */
    public void setLogicalDeletedFlag(boolean logicalDeletedFlag) {
        this.logicalDeletedFlag = logicalDeletedFlag;
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public Decimal getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(Decimal rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 台帳種別のgetメソッドです。
     * <br/>
     * <br/>1:被保険者台帳,2:他市町村住所地特例者台帳、3:適用除外者台帳
     *
     * @return 台帳種別
     */
    public RString getDaichoShubetsu() {
        return daichoShubetsu;
    }

    /**
     * 台帳種別のsetメソッドです。
     * <br/>
     * <br/>1:被保険者台帳,2:他市町村住所地特例者台帳、3:適用除外者台帳
     *
     * @param daichoShubetsu 台帳種別
     */
    public void setDaichoShubetsu(@Nonnull RString daichoShubetsu) {
        this.daichoShubetsu = daichoShubetsu;
    }

    /**
     * 入所施設種類のgetメソッドです。
     * <br/>
     * <br/>11:介護保険施設、12:住所地特例対象施設、21:適用除外施設
     *
     * @return 入所施設種類
     */
    public RString getNyushoShisetsuShurui() {
        return nyushoShisetsuShurui;
    }

    /**
     * 入所施設種類のsetメソッドです。
     * <br/>
     * <br/>11:介護保険施設、12:住所地特例対象施設、21:適用除外施設
     *
     * @param nyushoShisetsuShurui 入所施設種類
     */
    public void setNyushoShisetsuShurui(@Nonnull RString nyushoShisetsuShurui) {
        this.nyushoShisetsuShurui = nyushoShisetsuShurui;
    }

    /**
     * 入所施設コードのgetメソッドです。
     *
     * @return 入所施設コード
     */
    public JigyoshaNo getNyushoShisetsuCode() {
        return nyushoShisetsuCode;
    }

    /**
     * 入所施設コードのsetメソッドです。
     *
     * @param nyushoShisetsuCode 入所施設コード
     */
    public void setNyushoShisetsuCode(@Nonnull JigyoshaNo nyushoShisetsuCode) {
        this.nyushoShisetsuCode = nyushoShisetsuCode;
    }

    /**
     * 入所処理年月日のgetメソッドです。
     *
     * @return 入所処理年月日
     */
    @CheckForNull
    public FlexibleDate getNyushoShoriYMD() {
        return nyushoShoriYMD;
    }

    /**
     * 入所処理年月日のsetメソッドです。
     *
     * @param nyushoShoriYMD 入所処理年月日
     */
    public void setNyushoShoriYMD(FlexibleDate nyushoShoriYMD) {
        this.nyushoShoriYMD = nyushoShoriYMD;
    }

    /**
     * 入所年月日のgetメソッドです。
     *
     * @return 入所年月日
     */
    public FlexibleDate getNyushoYMD() {
        return nyushoYMD;
    }

    /**
     * 入所年月日のsetメソッドです。
     *
     * @param nyushoYMD 入所年月日
     */
    public void setNyushoYMD(@Nonnull FlexibleDate nyushoYMD) {
        this.nyushoYMD = nyushoYMD;
    }

    /**
     * 退所処理年月日のgetメソッドです。
     *
     * @return 退所処理年月日
     */
    @CheckForNull
    public FlexibleDate getTaishoShoriYMD() {
        return taishoShoriYMD;
    }

    /**
     * 退所処理年月日のsetメソッドです。
     *
     * @param taishoShoriYMD 退所処理年月日
     */
    public void setTaishoShoriYMD(FlexibleDate taishoShoriYMD) {
        this.taishoShoriYMD = taishoShoriYMD;
    }

    /**
     * 退所年月日のgetメソッドです。
     *
     * @return 退所年月日
     */
    @CheckForNull
    public FlexibleDate getTaishoYMD() {
        return taishoYMD;
    }

    /**
     * 退所年月日のsetメソッドです。
     *
     * @param taishoYMD 退所年月日
     */
    public void setTaishoYMD(FlexibleDate taishoYMD) {
        this.taishoYMD = taishoYMD;
    }

    /**
     * 部屋記号番号のgetメソッドです。
     * <br/>
     * <br/>部屋の記号番号
     *
     * @return 部屋記号番号
     */
    @CheckForNull
    public RString getRoomKigoNo() {
        return roomKigoNo;
    }

    /**
     * 部屋記号番号のsetメソッドです。
     * <br/>
     * <br/>部屋の記号番号
     *
     * @param roomKigoNo 部屋記号番号
     */
    public void setRoomKigoNo(RString roomKigoNo) {
        this.roomKigoNo = roomKigoNo;
    }

    /**
     * 適用事由コードのgetメソッドです。
     *
     * @return 適用事由コード
     */
    public RString getTekiyouZiyuuCode() {
        return tekiyouZiyuuCode;
    }

    /**
     * 適用事由コードのsetメソッドです。
     *
     * @param TekiyouZiyuuCode 適用事由コード
     */
    public void setTekiyouZiyuucode(RString TekiyouZiyuuCode) {
        this.tekiyouZiyuuCode = TekiyouZiyuuCode;
    }

    /**
     * 解除事由コードのgetメソッドです。
     *
     * @return 解除事由コード
     */
    public RString getKaijoZiyuuCode() {
        return kaijoZiyuuCode;
    }

    /**
     * 解除事由コードのsetメソッドです。
     *
     * @param KaijoZiyuuCode 解除事由コード
     */
    public void setKaijoZiyuuCode(RString kaijoZiyuuCode) {
        this.kaijoZiyuuCode = kaijoZiyuuCode;
    }

}
