/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者台帳ビューのモデルクラスです。
 *
 * @author N8156 宮本 康
 */
public class HihokenshaDaichoViewModel {

    private final DbV1001HihokenshaDaichoEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity DbV1001HihokenshaDaichoEntity
     */
    public HihokenshaDaichoViewModel(DbV1001HihokenshaDaichoEntity entity) {
        this.entity = entity;
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
     * 資格取得事由コードを返します。
     *
     * @return 資格取得事由コード
     */
    public RString get資格取得事由コード() {
        return entity.getShikakuShutokuJiyuCode();
    }

    /**
     * 資格取得日を返します。
     *
     * @return 資格取得日
     */
    public FlexibleDate get資格取得日() {
        return entity.getShikakuShutokuYMD();
    }

    /**
     * 資格取得届出日を返します。
     *
     * @return 資格取得届出日
     */
    public FlexibleDate get資格取得届出日() {
        return entity.getShikakuShutokuTodokedeYMD();
    }

    /**
     * 第1号被保険者年齢到達日を返します。
     *
     * @return 第1号被保険者年齢到達日
     */
    public FlexibleDate get第1号被保険者年齢到達日() {
        return entity.getIchigoHihokenshaNenreiTotatsuYMD();
    }

    /**
     * 被保険者区分コードを返します。
     *
     * @return 被保険者区分コード
     */
    public Code get被保険者区分コード() {
        return entity.getHihokennshaKubunCode();
    }

    /**
     * 資格喪失事由コードを返します。
     *
     * @return 資格喪失事由コード
     */
    public RString get資格喪失事由コード() {
        return entity.getShikakuSoshitsuJiyuCode();
    }

    /**
     * 資格喪失日を返します。
     *
     * @return 資格喪失日
     */
    public FlexibleDate get資格喪失日() {
        return entity.getShikakuSoshitsuYMD();
    }

    /**
     * 資格喪失届出日を返します。
     *
     * @return 資格喪失届出日
     */
    public FlexibleDate get資格喪失届出日() {
        return entity.getShikakuSoshitsuTodokedeYMD();
    }

    /**
     * 住所地特例フラグを返します。
     *
     * @return 住所地特例フラグ
     */
    public RString get住所地特例フラグ() {
        return entity.getJushochiTokureiFlag();
    }

    /**
     * 資格変更事由コードを返します。
     *
     * @return 資格変更事由コード
     */
    public RString get資格変更事由コード() {
        return entity.getShikakuHenkoJiyuCode();
    }

    /**
     * 資格変更日を返します。
     *
     * @return 資格変更日
     */
    public FlexibleDate get資格変更日() {
        return entity.getShikakuHenkoYMD();
    }

    /**
     * 資格変更届出日を返します。
     *
     * @return 資格変更届出日
     */
    public FlexibleDate get資格変更届出日() {
        return entity.getShikakuHenkoTodokedeYMD();
    }

    /**
     * 住所地特例適用事由コードを返します。
     *
     * @return 住所地特例適用事由コード
     */
    public RString get住所地特例適用事由コード() {
        return entity.getJushochitokureiTekiyoJiyuCode();
    }

    /**
     * 適用日を返します。
     *
     * @return 適用日
     */
    public FlexibleDate get適用日() {
        return entity.getJushochitokureiTekiyoYMD();
    }

    /**
     * 適用届出日を返します。
     *
     * @return 適用届出日
     */
    public FlexibleDate get適用届出日() {
        return entity.getJushochitokureiTekiyoTodokedeYMD();
    }

    /**
     * 住所地特例解除事由コードを返します。
     *
     * @return 住所地特例解除事由コード
     */
    public RString get住所地特例解除事由コード() {
        return entity.getJushochitokureiKaijoJiyuCode();
    }

    /**
     * 解除日を返します。
     *
     * @return 解除日
     */
    public FlexibleDate get解除日() {
        return entity.getJushochitokureiKaijoYMD();
    }

    /**
     * 解除届出日を返します。
     *
     * @return 解除届出日
     */
    public FlexibleDate get解除届出日() {
        return entity.getJushochitokureiKaijoTodokedeYMD();
    }

    /**
     * 広域内住所地特例フラグを返します。
     *
     * @return 広域内住所地特例フラグ
     */
    public RString get広域内住所地特例フラグ() {
        return entity.getKoikinaiJushochiTokureiFlag();
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
    public RString get再交付区分() {
        return entity.getSaikofuKubun();
    }

    /**
     * 再交付事由コードを返します。
     *
     * @return 再交付事由コード
     */
    public RString get再交付事由コード() {
        return entity.getSaikofuJiyuCode();
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
     * DbV1001HihokenshaDaichoEntityを返します。
     *
     * @return DbV1001HihokenshaDaichoEntity
     */
    public DbV1001HihokenshaDaichoEntity getDbV1001HihokenshaDaichoEntity() {
        return entity;
    }
}
