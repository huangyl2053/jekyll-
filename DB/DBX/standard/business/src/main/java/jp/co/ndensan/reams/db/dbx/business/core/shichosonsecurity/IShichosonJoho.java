/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity;

import jp.co.ndensan.reams.db.dbx.definition.core.koseishichoson.ShichosonShikibetsuID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 市町村情報です。
 */
public interface IShichosonJoho {

    /**
     * 住所を返却します。
     *
     * @return 住所
     */
    RString get住所();

    /**
     * 加入日を返却します。
     *
     * @return 加入日
     */
    FlexibleDate get加入日();

    /**
     * 合併情報地域番号を返却します。
     *
     * @return 合併情報地域番号
     */
    RString get合併情報地域番号();

    /**
     * 合併旧市町村区分を返却します。
     *
     * @return 合併旧市町村区分
     */
    RString get合併旧市町村区分();

    /**
     * 合併旧市町村表示有無を返却します。
     *
     * @return 合併旧市町村表示有無
     */
    RString get合併旧市町村表示有無();

    /**
     * 国保連広域内市町村番号を返却します。
     *
     * @return 国保連広域内市町村番号
     */
    RString get国保連広域内市町村番号();

    /**
     * 市町村コードを返却します。
     *
     * @return 市町村コード
     */
    LasdecCode get市町村コード();

    /**
     * 市町村名を返却します。
     *
     * @return 市町村名
     */
    RString get市町村名();

    /**
     * 市町村識別IDを返却します。
     *
     * @return 市町村識別ID
     */
    ShichosonShikibetsuID get市町村識別ID();

    /**
     * 帳票用住所編集方法を返却します。
     *
     * @return 帳票用住所編集方法
     */
    RString get帳票用住所編集方法();

    /**
     * 帳票用市町村名称表示有無を返却します。
     *
     * @return 帳票用市町村名称表示有無
     */
    RString get帳票用市町村名称表示有無();

    /**
     * 帳票用方書表示有無を返却します。
     *
     * @return 帳票用方書表示有無
     */
    RString get帳票用方書表示有無();

    /**
     * 帳票用郡名称表示有無を返却します。
     *
     * @return 帳票用郡名称表示有無
     */
    RString get帳票用郡名称表示有無();

    /**
     * 帳票用都道府県名称表示有無を返却します。
     *
     * @return 帳票用都道府県名称表示有無
     */
    RString get帳票用都道府県名称表示有無();

    /**
     * 最優先地区コードを返却します。
     *
     * @return 最優先地区コード
     */
    RString get最優先地区コード();

    /**
     * 特徴分配集約を返却します。
     *
     * @return 特徴分配集約
     */
    RString get特徴分配集約();

    /**
     * 移行日を返却します。
     *
     * @return 移行日
     */
    FlexibleDate get移行日();

    /**
     * 老人保健受給者番号体系を返却します。
     *
     * @return 老人保健受給者番号体系
     */
    RString get老人保健受給者番号体系();

    /**
     * 老人保健市町村番号を返却します。
     *
     * @return 老人保健市町村番号
     */
    RString get老人保健市町村番号();

    /**
     * 証記載保険者番号を返却します。
     *
     * @return 証記載保険者番号
     */
    ShoKisaiHokenshaNo get証記載保険者番号();

    /**
     * 運用保険者番号を返却します。
     *
     * @return 運用保険者番号
     */
    ShoKisaiHokenshaNo get運用保険者番号();

    /**
     * 運用形態区分を返却します。
     *
     * @return 運用形態区分
     */
    RString get運用形態区分();

    /**
     * 運用終了日を返却します。
     *
     * @return 運用終了日
     */
    FlexibleDate get運用終了日();

    /**
     * 運用開始日を返却します。
     *
     * @return 運用開始日
     */
    FlexibleDate get運用開始日();

    /**
     * 郡名称を返却します。
     *
     * @return 郡名称
     */
    RString get郡名称();

    /**
     * 郵便番号を返却します。
     *
     * @return 郵便番号
     */
    RString get郵便番号();

    /**
     * 都道府県名称を返却します。
     *
     * @return 都道府県名称
     */
    RString get都道府県名称();

    /**
     * 離脱日を返却します。
     *
     * @return 離脱日
     */
    FlexibleDate get離脱日();

    /**
     * 電話番号を返却します。
     *
     * @return 電話番号
     */
    RString get電話番号();
}
