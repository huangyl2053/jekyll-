/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoSaikofuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoSaikofuKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.JushochitokureiKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.JushochitokureishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.JushochitokureiTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.KoikinaiJushochitokureishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static java.util.Objects.requireNonNull;

/**
 * 被保険者台帳管理のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class HihokenshaDaichoModel implements Serializable {

    private DbT1001HihokenshaDaichoEntity entity;

    /**
     * コンストラクタです。
     */
    public HihokenshaDaichoModel() {
        entity = new DbT1001HihokenshaDaichoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT1001HihokenshaDaichoEntity
     */
    public HihokenshaDaichoModel(DbT1001HihokenshaDaichoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT1001HihokenshaDaichoEntityを返します。
     *
     * @return DbT1001HihokenshaDaichoEntity
     */
    public DbT1001HihokenshaDaichoEntity getEntity() {
        return entity;
    }

    /**
     * DbT1001HihokenshaDaichoEntityを設定します。
     *
     * @param entity DbT1001HihokenshaDaichoEntity
     */
    public void setEntity(DbT1001HihokenshaDaichoEntity entity) {
        this.entity = entity;
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getShoriTimestamp();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 資格取得事由を返します。
     *
     * @return 資格取得事由
     */
    public ShikakuShutokuJiyu get資格取得事由() {
        return ShikakuShutokuJiyu.toValue(entity.getShikakuShutokuJiyuCode());
    }

    /**
     * 資格取得年月日を返します。
     *
     * @return 資格取得年月日
     */
    public FlexibleDate get資格取得年月日() {
        return entity.getShikakuShutokuYMD();
    }

    /**
     * 資格取得届出年月日を返します。
     *
     * @return 資格取得届出年月日
     */
    public FlexibleDate get資格取得届出年月日() {
        return entity.getShikakuShutokuTodokedeYMD();
    }

    /**
     * 第1号資格取得年月日を返します。
     *
     * @return 第1号資格取得年月日
     */
    public FlexibleDate get第1号資格取得年月日() {
        return entity.getIchigoShikakuShutokuYMD();
    }

    /**
     * 被保険者区分コードを返します。
     *
     * @return 被保険者区分コード
     */
    public RString get被保険者区分コード() {
        return entity.getHihokennshaKubunCode();
    }

    /**
     * 資格喪失事由を返します。
     *
     * @return 資格喪失事由
     */
    public ShikakuSoshitsuJiyu get資格喪失事由() {
        return ShikakuSoshitsuJiyu.toValue(entity.getShikakuSoshitsuJiyuCode());
    }

    /**
     * 資格喪失年月日を返します。
     *
     * @return 資格喪失年月日
     */
    public FlexibleDate get資格喪失年月日() {
        return entity.getShikakuSoshitsuYMD();
    }

    /**
     * 資格喪失届出年月日を返します。
     *
     * @return 資格喪失届出年月日
     */
    public FlexibleDate get資格喪失届出年月日() {
        return entity.getShikakuSoshitsuTodokedeYMD();
    }

    /**
     * 住所地特例者区分を返します。
     *
     * @return 住所地特例者区分
     */
    public JushochitokureishaKubun get住所地特例者区分() {
        return JushochitokureishaKubun.toValue(entity.getJushochiTokureiFlag());
    }

    /**
     * 資格変更事由を返します。
     *
     * @return 資格変更事由
     */
    public ShikakuHenkoJiyu get資格変更事由() {
        return ShikakuHenkoJiyu.toValue(entity.getShikakuHenkoJiyuCode());
    }

    /**
     * 資格変更年月日を返します。
     *
     * @return 資格変更年月日
     */
    public FlexibleDate get資格変更年月日() {
        return entity.getShikakuHenkoYMD();
    }

    /**
     * 資格変更届出年月日を返します。
     *
     * @return 資格変更届出年月日
     */
    public FlexibleDate get資格変更届出年月日() {
        return entity.getShikakuHenkoTodokedeYMD();
    }

    /**
     * 住所地特例適用事由を返します。
     *
     * @return 住所地特例適用事由
     */
    public JushochitokureiTekiyoJiyu get住所地特例適用事由() {
        return JushochitokureiTekiyoJiyu.toValue(entity.getJushochitokureiTekiyoJiyuCode());
    }

    /**
     * 適用年月日を返します。
     *
     * @return 適用年月日
     */
    public FlexibleDate get適用年月日() {
        return entity.getJushochitokureiTekiyoYMD();
    }

    /**
     * 適用届出年月日を返します。
     *
     * @return 適用届出年月日
     */
    public FlexibleDate get適用届出年月日() {
        return entity.getJushochitokureiTekiyoTodokedeYMD();
    }

    /**
     * 住所地特例解除事由を返します。
     *
     * @return 住所地特例解除事由
     */
    public JushochitokureiKaijoJiyu get住所地特例解除事由() {
        return JushochitokureiKaijoJiyu.toValue(entity.getJushochitokureiKaijoJiyuCode());
    }

    /**
     * 解除年月日を返します。
     *
     * @return 解除年月日
     */
    public FlexibleDate get解除年月日() {
        return entity.getJushochitokureiKaijoYMD();
    }

    /**
     * 解除届出年月日を返します。
     *
     * @return 解除届出年月日
     */
    public FlexibleDate get解除届出年月日() {
        return entity.getJushochitokureiKaijoTodokedeYMD();
    }

    /**
     * 広域内住所地特例者区分を返します。
     *
     * @return 広域内住所地特例者区分
     */
    public KoikinaiJushochitokureishaKubun get広域内住所地特例者区分() {
        return KoikinaiJushochitokureishaKubun.toValue(entity.getKoikinaiJushochiTokureiFlag());
    }

    /**
     * 広住特措置元市町村コードを返します。
     *
     * @return 広住特措置元市町村コード
     */
    public LasdecCode get広住特措置元市町村コード() {
        return entity.getKoikinaiTokureiSochimotoShichosonCode();
    }

    /**
     * 旧市町村コードを返します。
     *
     * @return 旧市町村コード
     */
    public LasdecCode get旧市町村コード() {
        return entity.getKyuShichosonCode();
    }

    /**
     * 再交付区分を返します。
     *
     * @return 再交付区分
     */
    public HihokenshashoSaikofuKubun get再交付区分() {
        return HihokenshashoSaikofuKubun.toValue(entity.getSaikofuKubun());
    }

    /**
     * 再交付事由を返します。
     *
     * @return 再交付事由
     */
    public HihokenshashoSaikofuJiyu get再交付事由() {
        return HihokenshashoSaikofuJiyu.toValue(entity.getSaikofuJiyuCode());
    }

    /**
     * 帳票交付履歴IDを返します。
     *
     * @return 帳票交付履歴ID
     */
    public RString get帳票交付履歴ID() {
        return entity.getChohyoKofuRirekiID();
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     */
    public void set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
    }

    /**
     * 資格取得事由を設定します。
     *
     * @param 資格取得事由 資格取得事由
     */
    public void set資格取得事由(ShikakuShutokuJiyu 資格取得事由) {
        requireNonNull(資格取得事由, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得事由"));
        entity.setShikakuShutokuJiyuCode(資格取得事由.getCode());
    }

    /**
     * 資格取得年月日を設定します。
     *
     * @param 資格取得年月日 資格取得年月日
     */
    public void set資格取得年月日(FlexibleDate 資格取得年月日) {
        requireNonNull(資格取得年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得年月日"));
        entity.setShikakuShutokuYMD(資格取得年月日);
    }

    /**
     * 資格取得届出年月日を設定します。
     *
     * @param 資格取得届出年月日 資格取得届出年月日
     */
    public void set資格取得届出年月日(FlexibleDate 資格取得届出年月日) {
        requireNonNull(資格取得届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得届出年月日"));
        entity.setShikakuShutokuTodokedeYMD(資格取得届出年月日);
    }

    /**
     * 第1号資格取得年月日を設定します。
     *
     * @param 第1号資格取得年月日 第1号資格取得年月日
     */
    public void set第1号資格取得年月日(FlexibleDate 第1号資格取得年月日) {
        requireNonNull(第1号資格取得年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("第1号資格取得年月日"));
        entity.setIchigoShikakuShutokuYMD(第1号資格取得年月日);
    }

    /**
     * 被保険者区分コードを設定します。
     *
     * @param 被保険者区分コード 被保険者区分コード
     */
    public void set被保険者区分コード(RString 被保険者区分コード) {
        requireNonNull(被保険者区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者区分コード"));
        entity.setHihokennshaKubunCode(被保険者区分コード);
    }

    /**
     * 資格喪失事由を設定します。
     *
     * @param 資格喪失事由 資格喪失事由
     */
    public void set資格喪失事由(ShikakuSoshitsuJiyu 資格喪失事由) {
        requireNonNull(資格喪失事由, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失事由"));
        entity.setShikakuSoshitsuJiyuCode(資格喪失事由.getCode());
    }

    /**
     * 資格喪失年月日を設定します。
     *
     * @param 資格喪失年月日 資格喪失年月日
     */
    public void set資格喪失年月日(FlexibleDate 資格喪失年月日) {
        requireNonNull(資格喪失年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失年月日"));
        entity.setShikakuSoshitsuYMD(資格喪失年月日);
    }

    /**
     * 資格喪失届出年月日を設定します。
     *
     * @param 資格喪失届出年月日 資格喪失届出年月日
     */
    public void set資格喪失届出年月日(FlexibleDate 資格喪失届出年月日) {
        requireNonNull(資格喪失届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失届出年月日"));
        entity.setShikakuSoshitsuTodokedeYMD(資格喪失届出年月日);
    }

    /**
     * 住所地特例者区分を設定します。
     *
     * @param 住所地特例者区分 住所地特例者区分
     */
    public void set住所地特例者区分(JushochitokureishaKubun 住所地特例者区分) {
        requireNonNull(住所地特例者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例者区分"));
        entity.setJushochiTokureiFlag(住所地特例者区分.code());
    }

    /**
     * 資格変更事由を設定します。
     *
     * @param 資格変更事由 資格変更事由
     */
    public void set資格変更事由(ShikakuHenkoJiyu 資格変更事由) {
        requireNonNull(資格変更事由, UrSystemErrorMessages.値がnull.getReplacedMessage("資格変更事由"));
        entity.setShikakuHenkoJiyuCode(資格変更事由.getCode());
    }

    /**
     * 資格変更年月日を設定します。
     *
     * @param 資格変更年月日 資格変更年月日
     */
    public void set資格変更年月日(FlexibleDate 資格変更年月日) {
        requireNonNull(資格変更年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格変更年月日"));
        entity.setShikakuHenkoYMD(資格変更年月日);
    }

    /**
     * 資格変更届出年月日を設定します。
     *
     * @param 資格変更届出年月日 資格変更届出年月日
     */
    public void set資格変更届出年月日(FlexibleDate 資格変更届出年月日) {
        requireNonNull(資格変更届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格変更届出年月日"));
        entity.setShikakuHenkoTodokedeYMD(資格変更届出年月日);
    }

    /**
     * 住所地特例適用事由を設定します。
     *
     * @param 住所地特例適用事由 住所地特例適用事由
     */
    public void set住所地特例適用事由(JushochitokureiTekiyoJiyu 住所地特例適用事由) {
        requireNonNull(住所地特例適用事由, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例適用事由"));
        entity.setJushochitokureiTekiyoJiyuCode(住所地特例適用事由.getCode());
    }

    /**
     * 適用年月日を設定します。
     *
     * @param 適用年月日 適用年月日
     */
    public void set適用年月日(FlexibleDate 適用年月日) {
        requireNonNull(適用年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用年月日"));
        entity.setJushochitokureiTekiyoYMD(適用年月日);
    }

    /**
     * 適用届出年月日を設定します。
     *
     * @param 適用届出年月日 適用届出年月日
     */
    public void set適用届出年月日(FlexibleDate 適用届出年月日) {
        requireNonNull(適用届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用届出年月日"));
        entity.setJushochitokureiTekiyoTodokedeYMD(適用届出年月日);
    }

    /**
     * 住所地特例解除事由を設定します。
     *
     * @param 住所地特例解除事由 住所地特例解除事由
     */
    public void set住所地特例解除事由(JushochitokureiKaijoJiyu 住所地特例解除事由) {
        requireNonNull(住所地特例解除事由, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例解除事由"));
        entity.setJushochitokureiKaijoJiyuCode(住所地特例解除事由.getCode());
    }

    /**
     * 解除年月日を設定します。
     *
     * @param 解除年月日 解除年月日
     */
    public void set解除年月日(FlexibleDate 解除年月日) {
        requireNonNull(解除年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("解除年月日"));
        entity.setJushochitokureiKaijoYMD(解除年月日);
    }

    /**
     * 解除届出年月日を設定します。
     *
     * @param 解除届出年月日 解除届出年月日
     */
    public void set解除届出年月日(FlexibleDate 解除届出年月日) {
        requireNonNull(解除届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("解除届出年月日"));
        entity.setJushochitokureiKaijoTodokedeYMD(解除届出年月日);
    }

    /**
     * 広域内住所地特例者区分を設定します。
     *
     * @param 広域内住所地特例者区分 広域内住所地特例者区分
     */
    public void set広域内住所地特例者区分(KoikinaiJushochitokureishaKubun 広域内住所地特例者区分) {
        requireNonNull(広域内住所地特例者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("広域内住所地特例者区分"));
        entity.setKoikinaiJushochiTokureiFlag(広域内住所地特例者区分.getCode());
    }

    /**
     * 広住特措置元市町村コードを設定します。
     *
     * @param 広住特措置元市町村コード 広住特措置元市町村コード
     */
    public void set広住特措置元市町村コード(LasdecCode 広住特措置元市町村コード) {
        requireNonNull(広住特措置元市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("広住特措置元市町村コード"));
        entity.setKoikinaiTokureiSochimotoShichosonCode(広住特措置元市町村コード);
    }

    /**
     * 旧市町村コードを設定します。
     *
     * @param 旧市町村コード 旧市町村コード
     */
    public void set旧市町村コード(LasdecCode 旧市町村コード) {
        requireNonNull(旧市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("旧市町村コード"));
        entity.setKyuShichosonCode(旧市町村コード);
    }

    /**
     * 再交付区分を設定します。
     *
     * @param 再交付区分 再交付区分
     */
    public void set再交付区分(HihokenshashoSaikofuKubun 再交付区分) {
        requireNonNull(再交付区分, UrSystemErrorMessages.値がnull.getReplacedMessage("再交付区分"));
        entity.setSaikofuKubun(再交付区分.getCode());
    }

    /**
     * 再交付事由を設定します。
     *
     * @param 再交付事由 再交付事由
     */
    public void set再交付事由(HihokenshashoSaikofuJiyu 再交付事由) {
        requireNonNull(再交付事由, UrSystemErrorMessages.値がnull.getReplacedMessage("再交付事由"));
        entity.setSaikofuJiyuCode(再交付事由.getCode());
    }

    /**
     * 帳票交付履歴IDを設定します。
     *
     * @param 帳票交付履歴ID 帳票交付履歴ID
     */
    public void set帳票交付履歴ID(RString 帳票交付履歴ID) {
        requireNonNull(帳票交付履歴ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票交付履歴ID"));
        entity.setChohyoKofuRirekiID(帳票交付履歴ID);
    }

    /**
     * 状態に削除を設定します。
     *
     * @param deleteFlag deleteFlag
     */
    public void setDeletedState(boolean deleteFlag) {
        if (deleteFlag) {
            entity.setState(EntityDataState.Deleted);
        } else {
            entity.unsetState();
        }
    }

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    public EntityDataState getState() {
        return entity.getState();
    }
}
