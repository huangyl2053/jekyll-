/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者台帳管理を管理するクラスです。
 */
public class HihokenshaDaicho {

    private DbT1001HihokenshaDaichoEntity entity;

    /**
     * コンストラクタです。
     */
    public HihokenshaDaicho() {
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT1001HihokenshaDaichoEntity
     */
    public HihokenshaDaicho(DbT1001HihokenshaDaichoEntity entity) {
        this.entity = entity;
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return entity.getHihokenshaNo();
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        requireNonNull(hihokenshaNo, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        entity.setHihokenshaNo(hihokenshaNo);
    }

    /**
     * 異動日を取得します。
     *
     * @return 異動日
     */
    public FlexibleDate getIdoYMD() {
        return entity.getIdoYMD();
    }

    /**
     * 異動日を設定します。
     *
     * @param idoYMD 異動日
     */
    public void setIdoYMD(FlexibleDate idoYMD) {
        requireNonNull(idoYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        entity.setIdoYMD(idoYMD);
    }

    /**
     * 枝番を取得します。
     *
     * @return 枝番
     */
    public RString getEdaNo() {
        return entity.getEdaNo();
    }

    /**
     * 枝番を設定します。
     *
     * @param edaNo 枝番
     */
    public void setEdaNo(RString edaNo) {
        requireNonNull(edaNo, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));
        entity.setEdaNo(edaNo);
    }

    /**
     * 異動事由コードを取得します。
     *
     * @return 異動事由コード
     */
    public RString getIdoJiyuCode() {
        return entity.getIdoJiyuCode();
    }

    /**
     * 異動事由コードを設定します。
     *
     * @param idoJiyuCode 異動事由コード
     */
    public void setIdoJiyuCode(RString idoJiyuCode) {
        requireNonNull(idoJiyuCode, UrSystemErrorMessages.値がnull.getReplacedMessage("異動事由コード"));
        entity.setIdoJiyuCode(idoJiyuCode);
    }

    /**
     * 市町村コードを取得します。
     *
     * @return 市町村コード
     */
    public LasdecCode getShichosonCode() {
        return entity.getShichosonCode();
    }

    /**
     * 市町村コードを設定します。
     *
     * @param shichosonCode 市町村コード
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        requireNonNull(shichosonCode, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(shichosonCode);
    }

    /**
     * 識別コードを取得します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return entity.getShikibetsuCode();
    }

    /**
     * 識別コードを設定します。
     *
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        requireNonNull(shikibetsuCode, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(shikibetsuCode);
    }

    /**
     * 資格取得事由コードを取得します。
     *
     * @return 資格取得事由コード
     */
    public RString getShikakuShutokuJiyuCode() {
        return entity.getShikakuShutokuJiyuCode();
    }

    /**
     * 資格取得事由コードを設定します。
     *
     * @param shikakuShutokuJiyuCode 資格取得事由コード
     */
    public void setShikakuShutokuJiyuCode(RString shikakuShutokuJiyuCode) {
        requireNonNull(shikakuShutokuJiyuCode, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得事由コード"));
        entity.setShikakuShutokuJiyuCode(shikakuShutokuJiyuCode);
    }

    /**
     * 資格取得年月日を取得します。
     *
     * @return 資格取得年月日
     */
    public FlexibleDate getShikakuShutokuYMD() {
        return entity.getShikakuShutokuYMD();
    }

    /**
     * 資格取得年月日を設定します。
     *
     * @param shikakuShutokuYMD 資格取得年月日
     */
    public void setShikakuShutokuYMD(FlexibleDate shikakuShutokuYMD) {
        requireNonNull(shikakuShutokuYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得年月日"));
        entity.setShikakuShutokuYMD(shikakuShutokuYMD);
    }

    /**
     * 資格取得届出年月日を取得します。
     *
     * @return 資格取得届出年月日
     */
    public FlexibleDate getShikakuShutokuTodokedeYMD() {
        return entity.getShikakuShutokuTodokedeYMD();
    }

    /**
     * 資格取得届出年月日を設定します。
     *
     * @param shikakuShutokuTodokedeYMD 資格取得届出年月日
     */
    public void setShikakuShutokuTodokedeYMD(FlexibleDate shikakuShutokuTodokedeYMD) {
        requireNonNull(shikakuShutokuTodokedeYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得届出年月日"));
        entity.setShikakuShutokuTodokedeYMD(shikakuShutokuTodokedeYMD);
    }

    /**
     * 第1号資格取得年月日を取得します。
     *
     * @return 第1号資格取得年月日
     */
    public FlexibleDate getIchigoShikakuShutokuYMD() {
        return entity.getIchigoShikakuShutokuYMD();
    }

    /**
     * 第1号資格取得年月日を設定します。
     *
     * @param ichigoShikakuShutokuYMD 第1号資格取得年月日
     */
    public void setIchigoShikakuShutokuYMD(FlexibleDate ichigoShikakuShutokuYMD) {
        requireNonNull(ichigoShikakuShutokuYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("第1号資格取得年月日"));
        entity.setIchigoShikakuShutokuYMD(ichigoShikakuShutokuYMD);
    }

    /**
     * 被保険者区分コードを取得します。
     *
     * @return 被保険者区分コード
     */
    public RString getHihokennshaKubunCode() {
        return entity.getHihokennshaKubunCode();
    }

    /**
     * 被保険者区分コードを設定します。
     *
     * @param hihokennshaKubunCode 被保険者区分コード
     */
    public void setHihokennshaKubunCode(RString hihokennshaKubunCode) {
        requireNonNull(hihokennshaKubunCode, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者区分コード"));
        entity.setHihokennshaKubunCode(hihokennshaKubunCode);
    }

    /**
     * 資格喪失事由コードを取得します。
     *
     * @return 資格喪失事由コード
     */
    public RString getShikakuSoshitsuJiyuCode() {
        return entity.getShikakuSoshitsuJiyuCode();
    }

    /**
     * 資格喪失事由コードを設定します。
     *
     * @param shikakuSoshitsuJiyuCode 資格喪失事由コード
     */
    public void setShikakuSoshitsuJiyuCode(RString shikakuSoshitsuJiyuCode) {
        requireNonNull(shikakuSoshitsuJiyuCode, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失事由コード"));
        entity.setShikakuSoshitsuJiyuCode(shikakuSoshitsuJiyuCode);
    }

    /**
     * 資格喪失年月日を取得します。
     *
     * @return 資格喪失年月日
     */
    public FlexibleDate getShikakuSoshitsuYMD() {
        return entity.getShikakuSoshitsuYMD();
    }

    /**
     * 資格喪失年月日を設定します。
     *
     * @param shikakuSoshitsuYMD 資格喪失年月日
     */
    public void setShikakuSoshitsuYMD(FlexibleDate shikakuSoshitsuYMD) {
        requireNonNull(shikakuSoshitsuYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失年月日"));
        entity.setShikakuSoshitsuYMD(shikakuSoshitsuYMD);
    }

    /**
     * 資格喪失届出年月日を取得します。
     *
     * @return 資格喪失届出年月日
     */
    public FlexibleDate getShikakuSoshitsuTodokedeYMD() {
        return entity.getShikakuSoshitsuTodokedeYMD();
    }

    /**
     * 資格喪失届出年月日を設定します。
     *
     * @param shikakuSoshitsuTodokedeYMD 資格喪失届出年月日
     */
    public void setShikakuSoshitsuTodokedeYMD(FlexibleDate shikakuSoshitsuTodokedeYMD) {
        requireNonNull(shikakuSoshitsuTodokedeYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失届出年月日"));
        entity.setShikakuSoshitsuTodokedeYMD(shikakuSoshitsuTodokedeYMD);
    }

    /**
     * 資格変更事由コードを取得します。
     *
     * @return 資格変更事由コード
     */
    public RString getShikakuHenkoJiyuCode() {
        return entity.getShikakuHenkoJiyuCode();
    }

    /**
     * 資格変更事由コードを設定します。
     *
     * @param shikakuHenkoJiyuCode 資格変更事由コード
     */
    public void setShikakuHenkoJiyuCode(RString shikakuHenkoJiyuCode) {
        requireNonNull(shikakuHenkoJiyuCode, UrSystemErrorMessages.値がnull.getReplacedMessage("資格変更事由コード"));
        entity.setShikakuHenkoJiyuCode(shikakuHenkoJiyuCode);
    }

    /**
     * 資格変更年月日を取得します。
     *
     * @return 資格変更年月日
     */
    public FlexibleDate getShikakuHenkoYMD() {
        return entity.getShikakuHenkoYMD();
    }

    /**
     * 資格変更年月日を設定します。
     *
     * @param shikakuHenkoYMD 資格変更年月日
     */
    public void setShikakuHenkoYMD(FlexibleDate shikakuHenkoYMD) {
        requireNonNull(shikakuHenkoYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("資格変更年月日"));
        entity.setShikakuHenkoYMD(shikakuHenkoYMD);
    }

    /**
     * 資格変更届出年月日を取得します。
     *
     * @return 資格変更届出年月日
     */
    public FlexibleDate getShikakuHenkoTodokedeYMD() {
        return entity.getShikakuHenkoTodokedeYMD();
    }

    /**
     * 資格変更届出年月日を設定します。
     *
     * @param shikakuHenkoTodokedeYMD 資格変更届出年月日
     */
    public void setShikakuHenkoTodokedeYMD(FlexibleDate shikakuHenkoTodokedeYMD) {
        requireNonNull(shikakuHenkoTodokedeYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("資格変更届出年月日"));
        entity.setShikakuHenkoTodokedeYMD(shikakuHenkoTodokedeYMD);
    }

    /**
     * 住所地特例適用事由コードを取得します。
     *
     * @return 住所地特例適用事由コード
     */
    public RString getJushochitokureiTekiyoJiyuCode() {
        return entity.getJushochitokureiTekiyoJiyuCode();
    }

    /**
     * 住所地特例適用事由コードを設定します。
     *
     * @param jushochitokureiTekiyoJiyuCode 住所地特例適用事由コード
     */
    public void setJushochitokureiTekiyoJiyuCode(RString jushochitokureiTekiyoJiyuCode) {
        requireNonNull(jushochitokureiTekiyoJiyuCode, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例適用事由コード"));
        entity.setJushochitokureiTekiyoJiyuCode(jushochitokureiTekiyoJiyuCode);
    }

    /**
     * 適用年月日を取得します。
     *
     * @return 適用年月日
     */
    public FlexibleDate getJushochitokureiTekiyoYMD() {
        return entity.getJushochitokureiTekiyoYMD();
    }

    /**
     * 適用年月日を設定します。
     *
     * @param jushochitokureiTekiyoYMD 適用年月日
     */
    public void setJushochitokureiTekiyoYMD(FlexibleDate jushochitokureiTekiyoYMD) {
        requireNonNull(jushochitokureiTekiyoYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("適用年月日"));
        entity.setJushochitokureiTekiyoYMD(jushochitokureiTekiyoYMD);
    }

    /**
     * 適用届出年月日を取得します。
     *
     * @return 適用届出年月日
     */
    public FlexibleDate getJushochitokureiTekiyoTodokedeYMD() {
        return entity.getJushochitokureiTekiyoTodokedeYMD();
    }

    /**
     * 適用届出年月日を設定します。
     *
     * @param jushochitokureiTekiyoTodokedeYMD 適用届出年月日
     */
    public void setJushochitokureiTekiyoTodokedeYMD(FlexibleDate jushochitokureiTekiyoTodokedeYMD) {
        requireNonNull(jushochitokureiTekiyoTodokedeYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("適用届出年月日"));
        entity.setJushochitokureiTekiyoTodokedeYMD(jushochitokureiTekiyoTodokedeYMD);
    }

    /**
     * 住所地特例解除事由コードを取得します。
     *
     * @return 住所地特例解除事由コード
     */
    public RString getJushochitokureiKaijoJiyuCode() {
        return entity.getJushochitokureiKaijoJiyuCode();
    }

    /**
     * 住所地特例解除事由コードを設定します。
     *
     * @param jushochitokureiKaijoJiyuCode 住所地特例解除事由コード
     */
    public void setJushochitokureiKaijoJiyuCode(RString jushochitokureiKaijoJiyuCode) {
        requireNonNull(jushochitokureiKaijoJiyuCode, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例解除事由コード"));
        entity.setJushochitokureiKaijoJiyuCode(jushochitokureiKaijoJiyuCode);
    }

    /**
     * 解除年月日を取得します。
     *
     * @return 解除年月日
     */
    public FlexibleDate getJushochitokureiKaijoYMD() {
        return entity.getJushochitokureiKaijoYMD();
    }

    /**
     * 解除年月日を設定します。
     *
     * @param jushochitokureiKaijoYMD 解除年月日
     */
    public void setJushochitokureiKaijoYMD(FlexibleDate jushochitokureiKaijoYMD) {
        requireNonNull(jushochitokureiKaijoYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("解除年月日"));
        entity.setJushochitokureiKaijoYMD(jushochitokureiKaijoYMD);
    }

    /**
     * 解除届出年月日を取得します。
     *
     * @return 解除届出年月日
     */
    public FlexibleDate getJushochitokureiKaijoTodokedeYMD() {
        return entity.getJushochitokureiKaijoTodokedeYMD();
    }

    /**
     * 解除届出年月日を設定します。
     *
     * @param jushochitokureiKaijoTodokedeYMD 解除届出年月日
     */
    public void setJushochitokureiKaijoTodokedeYMD(FlexibleDate jushochitokureiKaijoTodokedeYMD) {
        requireNonNull(jushochitokureiKaijoTodokedeYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("解除届出年月日"));
        entity.setJushochitokureiKaijoTodokedeYMD(jushochitokureiKaijoTodokedeYMD);
    }

    /**
     * 住所地特例フラグを取得します。
     *
     * @return 住所地特例フラグ
     */
    public RString getJushochiTokureiFlag() {
        return entity.getJushochiTokureiFlag();
    }

    /**
     * 住所地特例フラグを設定します。
     *
     * @param jushochiTokureiFlag 住所地特例フラグ
     */
    public void setJushochiTokureiFlag(RString jushochiTokureiFlag) {
        requireNonNull(jushochiTokureiFlag, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例フラグ"));
        entity.setJushochiTokureiFlag(jushochiTokureiFlag);
    }

    /**
     * 広域内住所地特例フラグを取得します。
     *
     * @return 広域内住所地特例フラグ
     */
    public RString getKoikinaiJushochiTokureiFlag() {
        return entity.getKoikinaiJushochiTokureiFlag();
    }

    /**
     * 広域内住所地特例フラグを設定します。
     *
     * @param koikinaiJushochiTokureiFlag 広域内住所地特例フラグ
     */
    public void setKoikinaiJushochiTokureiFlag(RString koikinaiJushochiTokureiFlag) {
        requireNonNull(koikinaiJushochiTokureiFlag, UrSystemErrorMessages.値がnull.getReplacedMessage("広域内住所地特例フラグ"));
        entity.setKoikinaiJushochiTokureiFlag(koikinaiJushochiTokureiFlag);
    }

    /**
     * 広住特措置元市町村コードを取得します。
     *
     * @return 広住特措置元市町村コード
     */
    public LasdecCode getKoikinaiTokureiSochimotoShichosonCode() {
        return entity.getKoikinaiTokureiSochimotoShichosonCode();
    }

    /**
     * 広住特措置元市町村コードを設定します。
     *
     * @param koikinaiTokureiSochimotoShichosonCode 広住特措置元市町村コード
     */
    public void setKoikinaiTokureiSochimotoShichosonCode(LasdecCode koikinaiTokureiSochimotoShichosonCode) {
        requireNonNull(koikinaiTokureiSochimotoShichosonCode, UrSystemErrorMessages.値がnull.getReplacedMessage("広住特措置元市町村コード"));
        entity.setKoikinaiTokureiSochimotoShichosonCode(koikinaiTokureiSochimotoShichosonCode);
    }

    /**
     * 旧市町村コードを取得します。
     *
     * @return 旧市町村コード
     */
    public LasdecCode getKyuShichosonCode() {
        return entity.getKyuShichosonCode();
    }

    /**
     * 旧市町村コードを設定します。
     *
     * @param kyuShichosonCode 旧市町村コード
     */
    public void setKyuShichosonCode(LasdecCode kyuShichosonCode) {
        requireNonNull(kyuShichosonCode, UrSystemErrorMessages.値がnull.getReplacedMessage("旧市町村コード"));
        entity.setKyuShichosonCode(kyuShichosonCode);
    }

}
