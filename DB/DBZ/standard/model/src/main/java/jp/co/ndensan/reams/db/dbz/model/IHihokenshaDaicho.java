/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者台帳のインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IHihokenshaDaicho {

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    LasdecCode get市町村コード();

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    HihokenshaNo get被保険者番号();

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    YMDHMS get処理日時();

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    ShikibetsuCode get識別コード();

    /**
     * 資格取得事由コードを返します。
     *
     * @return 資格取得事由コード
     */
    RString get資格取得事由コード();

    /**
     * 資格取得日を返します。
     *
     * @return 資格取得日
     */
    FlexibleDate get資格取得日();

    /**
     * 資格取得届出日を返します。
     *
     * @return 資格取得届出日
     */
    FlexibleDate get資格取得届出日();

    /**
     * 第1号被保険者年齢到達日を返します。
     *
     * @return 第1号被保険者年齢到達日
     */
    FlexibleDate get第1号被保険者年齢到達日();

    /**
     * 被保険者区分コードを返します。
     *
     * @return 被保険者区分コード
     */
    Code get被保険者区分コード();

    /**
     * 資格喪失事由コードを返します。
     *
     * @return 資格喪失事由コード
     */
    RString get資格喪失事由コード();

    /**
     * 資格喪失日を返します。
     *
     * @return 資格喪失日
     */
    FlexibleDate get資格喪失日();

    /**
     * 資格喪失届出日を返します。
     *
     * @return 資格喪失届出日
     */
    FlexibleDate get資格喪失届出日();

    /**
     * 住所地特例フラグを返します。
     *
     * @return 住所地特例フラグ
     */
    RString get住所地特例フラグ();

    /**
     * 資格変更事由コードを返します。
     *
     * @return 資格変更事由コード
     */
    RString get資格変更事由コード();

    /**
     * 資格変更日を返します。
     *
     * @return 資格変更日
     */
    FlexibleDate get資格変更日();

    /**
     * 資格変更届出日を返します。
     *
     * @return 資格変更届出日
     */
    FlexibleDate get資格変更届出日();

    /**
     * 住所地特例適用事由コードを返します。
     *
     * @return 住所地特例適用事由コード
     */
    RString get住所地特例適用事由コード();

    /**
     * 適用日を返します。
     *
     * @return 適用日
     */
    FlexibleDate get適用日();

    /**
     * 適用届出日を返します。
     *
     * @return 適用届出日
     */
    FlexibleDate get適用届出日();

    /**
     * 住所地特例解除事由コードを返します。
     *
     * @return 住所地特例解除事由コード
     */
    RString get住所地特例解除事由コード();

    /**
     * 解除日を返します。
     *
     * @return 解除日
     */
    FlexibleDate get解除日();

    /**
     * 解除届出日を返します。
     *
     * @return 解除届出日
     */
    FlexibleDate get解除届出日();

    /**
     * 広域内住所地特例フラグを返します。
     *
     * @return 広域内住所地特例フラグ
     */
    RString get広域内住所地特例フラグ();

    /**
     * 広住特措置元市町村コードを返します。
     *
     * @return 広住特措置元市町村コード
     */
    LasdecCode get広住特措置元市町村コード();

    /**
     * 旧市町村コードを返します。
     *
     * @return 旧市町村コード
     */
    LasdecCode get旧市町村コード();

    /**
     * 再交付区分を返します。
     *
     * @return 再交付区分
     */
    RString get再交付区分();

    /**
     * 再交付事由コードを返します。
     *
     * @return 再交付事由コード
     */
    RString get再交付事由コード();

    /**
     * 帳票交付履歴IDを返します。
     *
     * @return 帳票交付履歴ID
     */
    RString get帳票交付履歴ID();

    /**
     * 被保険者台帳のモデルを帰します。
     *
     * @return 被保険者台帳モデル
     */
    HihokenshaDaichoModel toModel();
}
