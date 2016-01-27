/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者台帳管理を管理するクラスです。
 */
public class HihokenshaDaicho {

    private DbT1001HihokenshaDaichoEntity hihokenshaDaichoEntity;

    /**
     * コンストラクタです。
     */
    public HihokenshaDaicho() {
    }

    /**
     * コンストラクタです。
     *
     * @param hihokenshaDaichoEntity DbT1001HihokenshaDaichoEntity
     */
    public HihokenshaDaicho(DbT1001HihokenshaDaichoEntity hihokenshaDaichoEntity) {
        this.hihokenshaDaichoEntity = hihokenshaDaichoEntity;
    }

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaDaichoEntity.getHihokenshaNo();
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        hihokenshaDaichoEntity.setHihokenshaNo(hihokenshaNo);
    }

    /**
     * 異動日のgetメソッドです。
     *
     * @return 異動日
     */
    public FlexibleDate getIdoYMD() {
        return hihokenshaDaichoEntity.getIdoYMD();
    }

    /**
     * 異動日のsetメソッドです。
     *
     * @param idoYMD 異動日
     */
    public void setIdoYMD(FlexibleDate idoYMD) {
        hihokenshaDaichoEntity.setIdoYMD(idoYMD);
    }

    /**
     * 枝番のgetメソッドです。
     *
     * @return 枝番
     */
    public RString getEdaNo() {
        return hihokenshaDaichoEntity.getEdaNo();
    }

    /**
     * 枝番のsetメソッドです。
     *
     * @param edaNo 枝番
     */
    public void setEdaNo(RString edaNo) {
        hihokenshaDaichoEntity.setEdaNo(edaNo);
    }

    /**
     * 異動事由コードのgetメソッドです。
     *
     * @return 異動事由コード
     */
    public RString getIdoJiyuCode() {
        return hihokenshaDaichoEntity.getIdoJiyuCode();
    }

    /**
     * 異動事由コードのsetメソッドです。
     *
     * @param idoJiyuCode 異動事由コード
     */
    public void setIdoJiyuCode(RString idoJiyuCode) {
        hihokenshaDaichoEntity.setIdoJiyuCode(idoJiyuCode);
    }

    /**
     * 市町村コードのgetメソッドです。
     *
     * @return 市町村コード
     */
    public LasdecCode getShichosonCode() {
        return hihokenshaDaichoEntity.getShichosonCode();
    }

    /**
     * 市町村コードのsetメソッドです。
     *
     * @param shichosonCode 市町村コード
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        hihokenshaDaichoEntity.setShichosonCode(shichosonCode);
    }

    /**
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return hihokenshaDaichoEntity.getShikibetsuCode();
    }

    /**
     * 識別コードのsetメソッドです。
     *
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        hihokenshaDaichoEntity.setShikibetsuCode(shikibetsuCode);
    }

    /**
     * 資格取得事由コードのgetメソッドです。
     *
     * @return 資格取得事由コード
     */
    public RString getShikakuShutokuJiyuCode() {
        return hihokenshaDaichoEntity.getShikakuShutokuJiyuCode();
    }

    /**
     * 資格取得事由コードのsetメソッドです。
     *
     * @param shikakuShutokuJiyuCode 資格取得事由コード
     */
    public void setShikakuShutokuJiyuCode(RString shikakuShutokuJiyuCode) {
        hihokenshaDaichoEntity.setShikakuShutokuJiyuCode(shikakuShutokuJiyuCode);
    }

    /**
     * 資格取得年月日のgetメソッドです。
     *
     * @return 資格取得年月日
     */
    public FlexibleDate getShikakuShutokuYMD() {
        return hihokenshaDaichoEntity.getShikakuShutokuYMD();
    }

    /**
     * 資格取得年月日のsetメソッドです。
     *
     * @param shikakuShutokuYMD 資格取得年月日
     */
    public void setShikakuShutokuYMD(FlexibleDate shikakuShutokuYMD) {
        hihokenshaDaichoEntity.setShikakuShutokuYMD(shikakuShutokuYMD);
    }

    /**
     * 資格取得届出年月日のgetメソッドです。
     *
     * @return 資格取得届出年月日
     */
    public FlexibleDate getShikakuShutokuTodokedeYMD() {
        return hihokenshaDaichoEntity.getShikakuShutokuTodokedeYMD();
    }

    /**
     * 資格取得届出年月日のsetメソッドです。
     *
     * @param shikakuShutokuTodokedeYMD 資格取得届出年月日
     */
    public void setShikakuShutokuTodokedeYMD(FlexibleDate shikakuShutokuTodokedeYMD) {
        hihokenshaDaichoEntity.setShikakuShutokuTodokedeYMD(shikakuShutokuTodokedeYMD);
    }

    /**
     * 第1号資格取得年月日のgetメソッドです。
     *
     * @return 第1号資格取得年月日
     */
    public FlexibleDate getIchigoShikakuShutokuYMD() {
        return hihokenshaDaichoEntity.getIchigoShikakuShutokuYMD();
    }

    /**
     * 第1号資格取得年月日のsetメソッドです。
     *
     * @param ichigoShikakuShutokuYMD 第1号資格取得年月日
     */
    public void setIchigoShikakuShutokuYMD(FlexibleDate ichigoShikakuShutokuYMD) {
        hihokenshaDaichoEntity.setIchigoShikakuShutokuYMD(ichigoShikakuShutokuYMD);
    }

    /**
     * 被保険者区分コードのgetメソッドです。
     * <br/>
     * <br/>１号・２号
     *
     * @return 被保険者区分コード
     */
    public RString getHihokennshaKubunCode() {
        return hihokenshaDaichoEntity.getHihokennshaKubunCode();
    }

    /**
     * 被保険者区分コードのsetメソッドです。
     * <br/>
     * <br/>１号・２号
     *
     * @param hihokennshaKubunCode 被保険者区分コード
     */
    public void setHihokennshaKubunCode(RString hihokennshaKubunCode) {
        hihokenshaDaichoEntity.setHihokennshaKubunCode(hihokennshaKubunCode);
    }

    /**
     * 資格喪失事由コードのgetメソッドです。
     *
     * @return 資格喪失事由コード
     */
    public RString getShikakuSoshitsuJiyuCode() {
        return hihokenshaDaichoEntity.getShikakuSoshitsuJiyuCode();
    }

    /**
     * 資格喪失事由コードのsetメソッドです。
     *
     * @param shikakuSoshitsuJiyuCode 資格喪失事由コード
     */
    public void setShikakuSoshitsuJiyuCode(RString shikakuSoshitsuJiyuCode) {
        hihokenshaDaichoEntity.setShikakuSoshitsuJiyuCode(shikakuSoshitsuJiyuCode);
    }

    /**
     * 資格喪失年月日のgetメソッドです。
     *
     * @return 資格喪失年月日
     */
    public FlexibleDate getShikakuSoshitsuYMD() {
        return hihokenshaDaichoEntity.getShikakuSoshitsuYMD();
    }

    /**
     * 資格喪失年月日のsetメソッドです。
     *
     * @param shikakuSoshitsuYMD 資格喪失年月日
     */
    public void setShikakuSoshitsuYMD(FlexibleDate shikakuSoshitsuYMD) {
        hihokenshaDaichoEntity.setShikakuSoshitsuYMD(shikakuSoshitsuYMD);
    }

    /**
     * 資格喪失届出年月日のgetメソッドです。
     *
     * @return 資格喪失届出年月日
     */
    public FlexibleDate getShikakuSoshitsuTodokedeYMD() {
        return hihokenshaDaichoEntity.getShikakuSoshitsuTodokedeYMD();
    }

    /**
     * 資格喪失届出年月日のsetメソッドです。
     *
     * @param shikakuSoshitsuTodokedeYMD 資格喪失届出年月日
     */
    public void setShikakuSoshitsuTodokedeYMD(FlexibleDate shikakuSoshitsuTodokedeYMD) {
        hihokenshaDaichoEntity.setShikakuSoshitsuTodokedeYMD(shikakuSoshitsuTodokedeYMD);
    }

    /**
     * 資格変更事由コードのgetメソッドです。
     *
     * @return 資格変更事由コード
     */
    public RString getShikakuHenkoJiyuCode() {
        return hihokenshaDaichoEntity.getShikakuHenkoJiyuCode();
    }

    /**
     * 資格変更事由コードのsetメソッドです。
     *
     * @param shikakuHenkoJiyuCode 資格変更事由コード
     */
    public void setShikakuHenkoJiyuCode(RString shikakuHenkoJiyuCode) {
        hihokenshaDaichoEntity.setShikakuHenkoJiyuCode(shikakuHenkoJiyuCode);
    }

    /**
     * 資格変更年月日のgetメソッドです。
     *
     * @return 資格変更年月日
     */
    public FlexibleDate getShikakuHenkoYMD() {
        return hihokenshaDaichoEntity.getShikakuHenkoYMD();
    }

    /**
     * 資格変更年月日のsetメソッドです。
     *
     * @param shikakuHenkoYMD 資格変更年月日
     */
    public void setShikakuHenkoYMD(FlexibleDate shikakuHenkoYMD) {
        hihokenshaDaichoEntity.setShikakuHenkoYMD(shikakuHenkoYMD);
    }

    /**
     * 資格変更届出年月日のgetメソッドです。
     *
     * @return 資格変更届出年月日
     */
    public FlexibleDate getShikakuHenkoTodokedeYMD() {
        return hihokenshaDaichoEntity.getShikakuHenkoTodokedeYMD();
    }

    /**
     * 資格変更届出年月日のsetメソッドです。
     *
     * @param shikakuHenkoTodokedeYMD 資格変更届出年月日
     */
    public void setShikakuHenkoTodokedeYMD(FlexibleDate shikakuHenkoTodokedeYMD) {
        hihokenshaDaichoEntity.setShikakuHenkoTodokedeYMD(shikakuHenkoTodokedeYMD);
    }

    /**
     * 住所地特例適用事由コードのgetメソッドです。
     *
     * @return 住所地特例適用事由コード
     */
    public RString getJushochitokureiTekiyoJiyuCode() {
        return hihokenshaDaichoEntity.getJushochitokureiTekiyoJiyuCode();
    }

    /**
     * 住所地特例適用事由コードのsetメソッドです。
     *
     * @param jushochitokureiTekiyoJiyuCode 住所地特例適用事由コード
     */
    public void setJushochitokureiTekiyoJiyuCode(RString jushochitokureiTekiyoJiyuCode) {
        hihokenshaDaichoEntity.setJushochitokureiTekiyoJiyuCode(jushochitokureiTekiyoJiyuCode);
    }

    /**
     * 適用年月日のgetメソッドです。
     *
     * @return 適用年月日
     */
    public FlexibleDate getJushochitokureiTekiyoYMD() {
        return hihokenshaDaichoEntity.getJushochitokureiTekiyoYMD();
    }

    /**
     * 適用年月日のsetメソッドです。
     *
     * @param jushochitokureiTekiyoYMD 適用年月日
     */
    public void setJushochitokureiTekiyoYMD(FlexibleDate jushochitokureiTekiyoYMD) {
        hihokenshaDaichoEntity.setJushochitokureiTekiyoYMD(jushochitokureiTekiyoYMD);
    }

    /**
     * 適用届出年月日のgetメソッドです。
     *
     * @return 適用届出年月日
     */
    public FlexibleDate getJushochitokureiTekiyoTodokedeYMD() {
        return hihokenshaDaichoEntity.getJushochitokureiTekiyoTodokedeYMD();
    }

    /**
     * 適用届出年月日のsetメソッドです。
     *
     * @param jushochitokureiTekiyoTodokedeYMD 適用届出年月日
     */
    public void setJushochitokureiTekiyoTodokedeYMD(FlexibleDate jushochitokureiTekiyoTodokedeYMD) {
        hihokenshaDaichoEntity.setJushochitokureiTekiyoTodokedeYMD(jushochitokureiTekiyoTodokedeYMD);
    }

    /**
     * 住所地特例解除事由コードのgetメソッドです。
     *
     * @return 住所地特例解除事由コード
     */
    public RString getJushochitokureiKaijoJiyuCode() {
        return hihokenshaDaichoEntity.getJushochitokureiKaijoJiyuCode();
    }

    /**
     * 住所地特例解除事由コードのsetメソッドです。
     *
     * @param jushochitokureiKaijoJiyuCode 住所地特例解除事由コード
     */
    public void setJushochitokureiKaijoJiyuCode(RString jushochitokureiKaijoJiyuCode) {
        hihokenshaDaichoEntity.setJushochitokureiKaijoJiyuCode(jushochitokureiKaijoJiyuCode);
    }

    /**
     * 解除年月日のgetメソッドです。
     *
     * @return 解除年月日
     */
    public FlexibleDate getJushochitokureiKaijoYMD() {
        return hihokenshaDaichoEntity.getJushochitokureiKaijoYMD();
    }

    /**
     * 解除年月日のsetメソッドです。
     *
     * @param jushochitokureiKaijoYMD 解除年月日
     */
    public void setJushochitokureiKaijoYMD(FlexibleDate jushochitokureiKaijoYMD) {
        hihokenshaDaichoEntity.setJushochitokureiKaijoYMD(jushochitokureiKaijoYMD);
    }

    /**
     * 解除届出年月日のgetメソッドです。
     *
     * @return 解除届出年月日
     */
    public FlexibleDate getJushochitokureiKaijoTodokedeYMD() {
        return hihokenshaDaichoEntity.getJushochitokureiKaijoTodokedeYMD();
    }

    /**
     * 解除届出年月日のsetメソッドです。
     *
     * @param jushochitokureiKaijoTodokedeYMD 解除届出年月日
     */
    public void setJushochitokureiKaijoTodokedeYMD(FlexibleDate jushochitokureiKaijoTodokedeYMD) {
        hihokenshaDaichoEntity.setJushochitokureiKaijoTodokedeYMD(jushochitokureiKaijoTodokedeYMD);
    }

    /**
     * 住所地特例フラグのgetメソッドです。
     *
     * @return 住所地特例フラグ
     */
    public RString getJushochiTokureiFlag() {
        return hihokenshaDaichoEntity.getJushochiTokureiFlag();
    }

    /**
     * 住所地特例フラグのsetメソッドです。
     *
     * @param jushochiTokureiFlag 住所地特例フラグ
     */
    public void setJushochiTokureiFlag(RString jushochiTokureiFlag) {
        hihokenshaDaichoEntity.setJushochiTokureiFlag(jushochiTokureiFlag);
    }

    /**
     * 広域内住所地特例フラグのgetメソッドです。
     *
     * @return 広域内住所地特例フラグ
     */
    public RString getKoikinaiJushochiTokureiFlag() {
        return hihokenshaDaichoEntity.getKoikinaiJushochiTokureiFlag();
    }

    /**
     * 広域内住所地特例フラグのsetメソッドです。
     *
     * @param koikinaiJushochiTokureiFlag 広域内住所地特例フラグ
     */
    public void setKoikinaiJushochiTokureiFlag(RString koikinaiJushochiTokureiFlag) {
        hihokenshaDaichoEntity.setKoikinaiJushochiTokureiFlag(koikinaiJushochiTokureiFlag);
    }

    /**
     * 広住特措置元市町村コードのgetメソッドです。
     *
     * @return 広住特措置元市町村コード
     */
    public LasdecCode getKoikinaiTokureiSochimotoShichosonCode() {
        return hihokenshaDaichoEntity.getKoikinaiTokureiSochimotoShichosonCode();
    }

    /**
     * 広住特措置元市町村コードのsetメソッドです。
     *
     * @param koikinaiTokureiSochimotoShichosonCode 広住特措置元市町村コード
     */
    public void setKoikinaiTokureiSochimotoShichosonCode(LasdecCode koikinaiTokureiSochimotoShichosonCode) {
        hihokenshaDaichoEntity.setKoikinaiTokureiSochimotoShichosonCode(koikinaiTokureiSochimotoShichosonCode);
    }

    /**
     * 旧市町村コードのgetメソッドです。
     * <br/>
     * <br/>合併市町村の時は、旧市町村コードを設定
     *
     * @return 旧市町村コード
     */
    public LasdecCode getKyuShichosonCode() {
        return hihokenshaDaichoEntity.getKyuShichosonCode();
    }

    /**
     * 旧市町村コードのsetメソッドです。
     * <br/>
     * <br/>合併市町村の時は、旧市町村コードを設定
     *
     * @param kyuShichosonCode 旧市町村コード
     */
    public void setKyuShichosonCode(LasdecCode kyuShichosonCode) {
        hihokenshaDaichoEntity.setKyuShichosonCode(kyuShichosonCode);
    }

}
