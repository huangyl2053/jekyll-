/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者台帳のモデルクラスです。
 *
 * @author N8156 宮本 康
 */
public class HihokenshaDaichoModel implements IHihokenshaDaicho {

    private final DbT1001HihokenshaDaichoEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity DbT1001HihokenshaDaichoEntity
     */
    public HihokenshaDaichoModel(DbT1001HihokenshaDaichoEntity entity) {
        this.entity = entity;
    }

    @Override
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    @Override
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    @Override
    public YMDHMS get処理日時() {
        return entity.getShoriTimestamp();
    }

    @Override
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    @Override
    public RString get資格取得事由コード() {
        return entity.getShikakuShutokuJiyuCode();
    }

    @Override
    public FlexibleDate get資格取得日() {
        return entity.getShikakuShutokuYMD();
    }

    @Override
    public FlexibleDate get資格取得届出日() {
        return entity.getShikakuShutokuTodokedeYMD();
    }

    @Override
    public FlexibleDate get第1号被保険者年齢到達日() {
        return entity.getIchigoHihokenshaNenreiTotatsuYMD();
    }

    @Override
    public Code get被保険者区分コード() {
        return entity.getHihokennshaKubunCode();
    }

    @Override
    public RString get資格喪失事由コード() {
        return entity.getShikakuSoshitsuJiyuCode();
    }

    @Override
    public FlexibleDate get資格喪失日() {
        return entity.getShikakuSoshitsuYMD();
    }

    @Override
    public FlexibleDate get資格喪失届出日() {
        return entity.getShikakuSoshitsuTodokedeYMD();
    }

    @Override
    public RString get住所地特例フラグ() {
        return entity.getJushochiTokureiFlag();
    }

    @Override
    public RString get資格変更事由コード() {
        return entity.getShikakuHenkoJiyuCode();
    }

    @Override
    public FlexibleDate get資格変更日() {
        return entity.getShikakuHenkoYMD();
    }

    @Override
    public FlexibleDate get資格変更届出日() {
        return entity.getShikakuHenkoTodokedeYMD();
    }

    @Override
    public RString get住所地特例適用事由コード() {
        return entity.getJushochitokureiTekiyoJiyuCode();
    }

    @Override
    public FlexibleDate get適用日() {
        return entity.getJushochitokureiTekiyoYMD();
    }

    @Override
    public FlexibleDate get適用届出日() {
        return entity.getJushochitokureiTekiyoTodokedeYMD();
    }

    @Override
    public RString get住所地特例解除事由コード() {
        return entity.getJushochitokureiKaijoJiyuCode();
    }

    @Override
    public FlexibleDate get解除日() {
        return entity.getJushochitokureiKaijoYMD();
    }

    @Override
    public FlexibleDate get解除届出日() {
        return entity.getJushochitokureiKaijoTodokedeYMD();
    }

    @Override
    public RString get広域内住所地特例フラグ() {
        return entity.getKoikinaiJushochiTokureiFlag();
    }

    @Override
    public LasdecCode get広住特措置元市町村コード() {
        return entity.getKoikinaiTokureiSochimotoShichosonCode();
    }

    @Override
    public LasdecCode get旧市町村コード() {
        return entity.getKyuShichosonCode();
    }

    @Override
    public RString get再交付区分() {
        return entity.getSaikofuKubun();
    }

    @Override
    public RString get再交付事由コード() {
        return entity.getSaikofuJiyuCode();
    }

    @Override
    public RString get帳票交付履歴ID() {
        return entity.getChohyoKofuRirekiID();
    }

    @Override
    public HihokenshaDaichoModel toModel() {
        return new HihokenshaDaichoModel(entity);
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     */
    public void set市町村コード(LasdecCode 市町村コード) {
        entity.setShichosonCode(市町村コード);
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        entity.setHihokenshaNo(被保険者番号);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        entity.setShoriTimestamp(処理日時);
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        entity.setShikibetsuCode(識別コード);
    }

    /**
     * 資格取得事由コードを設定します。
     *
     * @param 資格取得事由コード 資格取得事由コード
     */
    public void set資格取得事由コード(RString 資格取得事由コード) {
        entity.setShikakuShutokuJiyuCode(資格取得事由コード);
    }

    /**
     * 資格取得日を設定します。
     *
     * @param 資格取得日 資格取得日
     */
    public void set資格取得日(FlexibleDate 資格取得日) {
        entity.setShikakuShutokuYMD(資格取得日);
    }

    /**
     * 資格取得届出日を設定します。
     *
     * @param 資格取得届出日 資格取得届出日
     */
    public void set資格取得届出日(FlexibleDate 資格取得届出日) {
        entity.setShikakuShutokuTodokedeYMD(資格取得届出日);
    }

    /**
     * 第1号被保険者年齢到達日を設定します。
     *
     * @param 第1号被保険者年齢到達日 第1号被保険者年齢到達日
     */
    public void set第1号被保険者年齢到達日(FlexibleDate 第1号被保険者年齢到達日) {
        entity.setIchigoHihokenshaNenreiTotatsuYMD(第1号被保険者年齢到達日);
    }

    /**
     * 被保険者区分コードを設定します。
     *
     * @param 被保険者区分コード 被保険者区分コード
     */
    public void set被保険者区分コード(Code 被保険者区分コード) {
        entity.setHihokennshaKubunCode(被保険者区分コード);
    }

    /**
     * 資格喪失事由コードを設定します。
     *
     * @param 資格喪失事由コード 資格喪失事由コード
     */
    public void set資格喪失事由コード(RString 資格喪失事由コード) {
        entity.setShikakuSoshitsuJiyuCode(資格喪失事由コード);
    }

    /**
     * 資格喪失日を設定します。
     *
     * @param 資格喪失日 資格喪失日
     */
    public void set資格喪失日(FlexibleDate 資格喪失日) {
        entity.setShikakuSoshitsuYMD(資格喪失日);
    }

    /**
     * 資格喪失届出日を設定します。
     *
     * @param 資格喪失届出日 資格喪失届出日
     */
    public void set資格喪失届出日(FlexibleDate 資格喪失届出日) {
        entity.setShikakuSoshitsuTodokedeYMD(資格喪失届出日);
    }

    /**
     * 住所地特例フラグを設定します。
     *
     * @param 住所地特例フラグ 住所地特例フラグ
     */
    public void set住所地特例フラグ(RString 住所地特例フラグ) {
        entity.setJushochiTokureiFlag(住所地特例フラグ);
    }

    /**
     * 資格変更事由コードを設定します。
     *
     * @param 資格変更事由コード 資格変更事由コード
     */
    public void set資格変更事由コード(RString 資格変更事由コード) {
        entity.setShikakuHenkoJiyuCode(資格変更事由コード);
    }

    /**
     * 資格変更日を設定します。
     *
     * @param 資格変更日 資格変更日
     */
    public void set資格変更日(FlexibleDate 資格変更日) {
        entity.setShikakuHenkoYMD(資格変更日);
    }

    /**
     * 資格変更届出日を設定します。
     *
     * @param 資格変更届出日 資格変更届出日
     */
    public void set資格変更届出日(FlexibleDate 資格変更届出日) {
        entity.setShikakuHenkoTodokedeYMD(資格変更届出日);
    }

    /**
     * 住所地特例適用事由コードを設定します。
     *
     * @param 住所地特例適用事由コード 住所地特例適用事由コード
     */
    public void set住所地特例適用事由コード(RString 住所地特例適用事由コード) {
        entity.setJushochitokureiTekiyoJiyuCode(住所地特例適用事由コード);
    }

    /**
     * 適用日を設定します。
     *
     * @param 適用日 適用日
     */
    public void set適用日(FlexibleDate 適用日) {
        entity.setJushochitokureiTekiyoYMD(適用日);
    }

    /**
     * 適用届出日を設定します。
     *
     * @param 適用届出日 適用届出日
     */
    public void set適用届出日(FlexibleDate 適用届出日) {
        entity.setJushochitokureiTekiyoTodokedeYMD(適用届出日);
    }

    /**
     * 住所地特例解除事由コードを設定します。
     *
     * @param 住所地特例解除事由コード 住所地特例解除事由コード
     */
    public void set住所地特例解除事由コード(RString 住所地特例解除事由コード) {
        entity.setJushochitokureiKaijoJiyuCode(住所地特例解除事由コード);
    }

    /**
     * 解除日を設定します。
     *
     * @param 解除日 解除日
     */
    public void set解除日(FlexibleDate 解除日) {
        entity.setJushochitokureiKaijoYMD(解除日);
    }

    /**
     * 解除届出日を設定します。
     *
     * @param 解除届出日 解除届出日
     */
    public void set解除届出日(FlexibleDate 解除届出日) {
        entity.setJushochitokureiKaijoTodokedeYMD(解除届出日);
    }

    /**
     * 広域内住所地特例フラグを設定します。
     *
     * @param 広域内住所地特例フラグ 広域内住所地特例フラグ
     */
    public void set広域内住所地特例フラグ(RString 広域内住所地特例フラグ) {
        entity.setKoikinaiJushochiTokureiFlag(広域内住所地特例フラグ);
    }

    /**
     * 広住特措置元市町村コードを設定します。
     *
     * @param 広住特措置元市町村コード 広住特措置元市町村コード
     */
    public void set広住特措置元市町村コード(LasdecCode 広住特措置元市町村コード) {
        entity.setKoikinaiTokureiSochimotoShichosonCode(広住特措置元市町村コード);
    }

    /**
     * 旧市町村コードを設定します。
     *
     * @param 旧市町村コード 旧市町村コード
     */
    public void set旧市町村コード(LasdecCode 旧市町村コード) {
        entity.setKyuShichosonCode(旧市町村コード);
    }

    /**
     * 再交付区分を設定します。
     *
     * @param 再交付区分 再交付区分
     */
    public void set再交付区分(RString 再交付区分) {
        entity.setSaikofuKubun(再交付区分);
    }

    /**
     * 再交付事由コードを設定します。
     *
     * @param 再交付事由コード 再交付事由コード
     */
    public void set再交付事由コード(RString 再交付事由コード) {
        entity.setSaikofuJiyuCode(再交付事由コード);
    }

    /**
     * 帳票交付履歴を設定します。
     *
     * @param 帳票交付履歴 帳票交付履歴
     */
    public void set帳票交付履歴ID(RString 帳票交付履歴) {
        entity.setChohyoKofuRirekiID(帳票交付履歴);
    }

    /**
     * DbT1001HihokenshaDaichoEntityを返します。
     *
     * @return DbT1001HihokenshaDaichoEntity
     */
    public DbT1001HihokenshaDaichoEntity getDbT1001HihokenshaDaichoEntity() {
        return entity;
    }
}
