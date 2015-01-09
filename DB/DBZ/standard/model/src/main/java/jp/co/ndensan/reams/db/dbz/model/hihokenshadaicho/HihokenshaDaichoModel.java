/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoSaikofuKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.KoikinaiJushochitokureishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.JushochiTokureishaKubun;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.ShikakuHihokenshaKubun;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuHenkoJiyuHihokensha;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuJutokuKaijo;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuJutokuTekiyo;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuShutokuJiyuHihokensha;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoshikakuSoshitsuJiyuHihokennsha;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KofuJiyu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 被保険者台帳のモデルクラスです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshaDaichoModel implements Serializable, IHihokenshaDaicho {

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
    @Override
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    @Override
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    @Override
    public YMDHMS get処理日時() {
        return entity.getShoriTimestamp();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    @Override
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 資格取得事由を返します。
     *
     * @return 資格取得事由
     */
    @Override
    public KaigoshikakuShutokuJiyuHihokensha get資格取得事由() {
        return entity.getShikakuShutokuJiyuCode();
    }

    /**
     * 資格取得年月日を返します。
     *
     * @return 資格取得年月日
     */
    @Override
    public FlexibleDate get資格取得年月日() {
        return entity.getShikakuShutokuYMD();
    }

    /**
     * 資格取得届出年月日を返します。
     *
     * @return 資格取得届出年月日
     */
    @Override
    public FlexibleDate get資格取得届出年月日() {
        return entity.getShikakuShutokuTodokedeYMD();
    }

    /**
     * 第1号資格取得年月日を返します。
     *
     * @return 第1号資格取得年月日
     */
    @Override
    public FlexibleDate get第1号資格取得年月日() {
        return entity.getIchigoShikakuShutokuYMD();
    }

    /**
     * 被保険者区分を返します。
     *
     * @return 被保険者区分
     */
    @Override
    public ShikakuHihokenshaKubun get被保険者区分() {
        return ShikakuHihokenshaKubun.toValue(entity.getHihokennshaKubunCode().getColumnValue());
    }

    /**
     * 資格喪失事由を返します。
     *
     * @return 資格喪失事由
     */
    @Override
    public KaigoshikakuSoshitsuJiyuHihokennsha get資格喪失事由() {
        return entity.getShikakuSoshitsuJiyuCode();
    }

    /**
     * 資格喪失年月日を返します。
     *
     * @return 資格喪失年月日
     */
    @Override
    public FlexibleDate get資格喪失年月日() {
        return entity.getShikakuSoshitsuYMD();
    }

    /**
     * 資格喪失届出年月日を返します。
     *
     * @return 資格喪失届出年月日
     */
    @Override
    public FlexibleDate get資格喪失届出年月日() {
        return entity.getShikakuSoshitsuTodokedeYMD();
    }

    /**
     * 住所地特例フラグを返します。
     *
     * @return 住所地特例フラグ
     */
    @Override
    public JushochiTokureishaKubun get住所地特例フラグ() {
        return JushochiTokureishaKubun.toValue(entity.getJushochiTokureiFlag());
    }

    /**
     * 資格変更事由を返します。
     *
     * @return 資格変更事由
     */
    @Override
    public KaigoshikakuHenkoJiyuHihokensha get資格変更事由() {
        return entity.getShikakuHenkoJiyuCode();
    }

    /**
     * 資格変更年月日を返します。
     *
     * @return 資格変更年月日
     */
    @Override
    public FlexibleDate get資格変更年月日() {
        return entity.getShikakuHenkoYMD();
    }

    /**
     * 資格変更届出年月日を返します。
     *
     * @return 資格変更届出年月日
     */
    @Override
    public FlexibleDate get資格変更届出年月日() {
        return entity.getShikakuHenkoTodokedeYMD();
    }

    /**
     * 住所地特例適用事由コードを返します。
     *
     * @return 住所地特例適用事由コード
     */
    @Override
    public KaigoshikakuJutokuTekiyo get住所地特例適用事由() {
        return entity.getJushochitokureiTekiyoJiyuCode();
    }

    /**
     * 適用年月日を返します。
     *
     * @return 適用年月日
     */
    @Override
    public FlexibleDate get住所地特例適用年月日() {
        return entity.getJushochitokureiTekiyoYMD();
    }

    /**
     * 適用届出年月日を返します。
     *
     * @return 適用届出年月日
     */
    @Override
    public FlexibleDate get住所地特例適用届出年月日() {
        return entity.getJushochitokureiTekiyoTodokedeYMD();
    }

    /**
     * 住所地特例解除事由を返します。
     *
     * @return 住所地特例解除事由
     */
    @Override
    public KaigoshikakuJutokuKaijo get住所地特例解除事由コード() {
        return entity.getJushochitokureiKaijoJiyuCode();
    }

    /**
     * 解除年月日を返します。
     *
     * @return 解除年月日
     */
    @Override
    public FlexibleDate get住所地特例解除年月日() {
        return entity.getJushochitokureiKaijoYMD();
    }

    /**
     * 解除届出年月日を返します。
     *
     * @return 解除届出年月日
     */
    @Override
    public FlexibleDate get住所地特例解除届出年月日() {
        return entity.getJushochitokureiKaijoTodokedeYMD();
    }

    /**
     * 広域内住所地特例フラグを返します。
     *
     * @return 広域内住所地特例フラグ
     */
    @Override
    public KoikinaiJushochitokureishaKubun get広域内住所地特例区分() {
        return KoikinaiJushochitokureishaKubun.toValue(entity.getKoikinaiJushochiTokureiFlag());
    }

    /**
     * 広住特措置元市町村コードを返します。
     *
     * @return 広住特措置元市町村コード
     */
    @Override
    public LasdecCode get広住特措置元市町村コード() {
        return entity.getKoikinaiTokureiSochimotoShichosonCode();
    }

    /**
     * 旧市町村コードを返します。
     *
     * @return 旧市町村コード
     */
    @Override
    public LasdecCode get旧市町村コード() {
        return entity.getKyuShichosonCode();
    }

    /**
     * 再交付区分を返します。
     *
     * @return 再交付区分
     */
    @Override
    public HihokenshashoSaikofuKubun get再交付区分() {
        return HihokenshashoSaikofuKubun.toValue(entity.getSaikofuKubun());
    }

    /**
     * 再交付事由コードを返します。
     *
     * @return 再交付事由コード
     */
    @Override
    public KofuJiyu get再交付事由コード() {
        return entity.getSaikofuJiyuCode();
    }

    /**
     * 帳票交付履歴IDを返します。
     *
     * @return 帳票交付履歴ID
     */
    @Override
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
    public void set資格取得事由(KaigoshikakuShutokuJiyuHihokensha 資格取得事由) {
        requireNonNull(資格取得事由, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得事由"));
        entity.setShikakuShutokuJiyuCode(資格取得事由);
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
     * 第1号被保険者年齢到達年月日を設定します。
     *
     * @param 第1号資格取得年月日 第1号資格取得年月日
     */
    public void set第1号資格取得年月日(FlexibleDate 第1号資格取得年月日) {
        requireNonNull(第1号資格取得年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("第1号資格取得年月日"));
        entity.setIchigoShikakuShutokuYMD(第1号資格取得年月日);
    }

    /**
     * 被保険者区分を設定します。
     *
     * @param 被保険者区分 被保険者区分
     */
    public void set被保険者区分(Code 被保険者区分) {
        requireNonNull(被保険者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者区分"));
        entity.setHihokennshaKubunCode(被保険者区分);
    }

    /**
     * 資格喪失事由を設定します。
     *
     * @param 資格喪失事由 資格喪失事由
     */
    public void set資格喪失事由(KaigoshikakuSoshitsuJiyuHihokennsha 資格喪失事由) {
        requireNonNull(資格喪失事由, UrSystemErrorMessages.値がnull.getReplacedMessage("資格喪失事由"));
        entity.setShikakuSoshitsuJiyuCode(資格喪失事由);
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
     * 住所地特例フラグを設定します。
     *
     * @param 住所地特例フラグ 住所地特例フラグ
     */
    public void set住所地特例フラグ(RString 住所地特例フラグ) {
        requireNonNull(住所地特例フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例フラグ"));
        entity.setJushochiTokureiFlag(住所地特例フラグ);
    }

    /**
     * 資格変更事由を設定します。
     *
     * @param 資格変更事由 資格変更事由
     */
    public void set資格変更事由(KaigoshikakuHenkoJiyuHihokensha 資格変更事由) {
        requireNonNull(資格変更事由, UrSystemErrorMessages.値がnull.getReplacedMessage("資格変更事由"));
        entity.setShikakuHenkoJiyuCode(資格変更事由);
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
    public void set住所地特例適用事由(KaigoshikakuJutokuTekiyo 住所地特例適用事由) {
        requireNonNull(住所地特例適用事由, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例適用事由"));
        entity.setJushochitokureiTekiyoJiyuCode(住所地特例適用事由);
    }

    /**
     * 適用年月日を設定します。
     *
     * @param 適用年月日 適用年月日
     */
    public void set住所地特例適用年月日(FlexibleDate 適用年月日) {
        requireNonNull(適用年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用年月日"));
        entity.setJushochitokureiTekiyoYMD(適用年月日);
    }

    /**
     * 適用届出年月日を設定します。
     *
     * @param 適用届出年月日 適用届出年月日
     */
    public void set住所地特例適用届出年月日(FlexibleDate 適用届出年月日) {
        requireNonNull(適用届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用届出年月日"));
        entity.setJushochitokureiTekiyoTodokedeYMD(適用届出年月日);
    }

    /**
     * 住所地特例解除事由を設定します。
     *
     * @param 住所地特例解除事由 住所地特例解除事由
     */
    public void set住所地特例解除事由(KaigoshikakuJutokuKaijo 住所地特例解除事由) {
        requireNonNull(住所地特例解除事由, UrSystemErrorMessages.値がnull.getReplacedMessage("住所地特例解除事由"));
        entity.setJushochitokureiKaijoJiyuCode(住所地特例解除事由);
    }

    /**
     * 解除年月日を設定します。
     *
     * @param 解除年月日 解除年月日
     */
    public void set住所地特例解除年月日(FlexibleDate 解除年月日) {
        requireNonNull(解除年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("解除年月日"));
        entity.setJushochitokureiKaijoYMD(解除年月日);
    }

    /**
     * 解除届出年月日を設定します。
     *
     * @param 解除届出年月日 解除届出年月日
     */
    public void set住所地特例解除届出年月日(FlexibleDate 解除届出年月日) {
        requireNonNull(解除届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("解除届出年月日"));
        entity.setJushochitokureiKaijoTodokedeYMD(解除届出年月日);
    }

    /**
     * 広域内住所地特例フラグを設定します。
     *
     * @param 広域内住所地特例フラグ 広域内住所地特例フラグ
     */
    public void set広域内住所地特例フラグ(RString 広域内住所地特例フラグ) {
        requireNonNull(広域内住所地特例フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("広域内住所地特例フラグ"));
        entity.setKoikinaiJushochiTokureiFlag(広域内住所地特例フラグ);
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
    public void set再交付区分(RString 再交付区分) {
        requireNonNull(再交付区分, UrSystemErrorMessages.値がnull.getReplacedMessage("再交付区分"));
        entity.setSaikofuKubun(再交付区分);
    }

    /**
     * 再交付事由を設定します。
     *
     * @param 再交付事由 再交付事由
     */
    public void set再交付事由(KofuJiyu 再交付事由) {
        requireNonNull(再交付事由, UrSystemErrorMessages.値がnull.getReplacedMessage("再交付事由"));
        entity.setSaikofuJiyuCode(再交付事由);
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
