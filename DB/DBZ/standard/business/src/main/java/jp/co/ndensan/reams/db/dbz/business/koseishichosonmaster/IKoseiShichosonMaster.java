/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.koseishichosonmaster;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 構成市町村マスタ情報（ビジネス）を扱うインタフェースです。
 *
 * @author n8223　朴義一
 */
public interface IKoseiShichosonMaster {

    /**
     * 市町村識別IDを返します。
     *
     * @return 市町村識別ID
     */
    RString get市町村識別ID();

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    LasdecCode get市町村コード();

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    ShoKisaiHokenshaNo get証記載保険者番号();

    /**
     * 国保連広域内市町村番号を返します。
     *
     * @return 国保連広域内市町村番号
     */
    RString get国保連広域内市町村番号();

    /**
     * 市町村名称を返します。
     *
     * @return 市町村名称
     */
    RString get市町村名称();

    /**
     * 都道府県名称を返します。
     *
     * @return 都道府県名称
     */
    RString get都道府県名称();

    /**
     * 郡名称を返します。
     *
     * @return 郡名称
     */
    RString get郡名称();

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    YubinNo get郵便番号();

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    AtenaJusho get住所();

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    TelNo get電話番号();

    /**
     * 最優先地区コードを返します。
     *
     * @return 最優先地区コード
     */
    RString get最優先地区コード();

    /**
     * 帳票用都道府県名称表示有無を返します。
     *
     * @return 帳票用都道府県名称表示有無
     */
    RString get帳票用都道府県名称表示有無();

    /**
     * 帳票用郡名称表示有無を返します。
     *
     * @return 帳票用郡名称表示有無
     */
    RString get帳票用郡名称表示有無();

    /**
     * 帳票用市町村名称表示有無を返します。
     *
     * @return 帳票用市町村名称表示有無
     */
    RString get帳票用市町村名称表示有無();

    /**
     * 帳票用住所編集方法を返します。
     *
     * @return 帳票用住所編集方法
     */
    RString get帳票用住所編集方法();

    /**
     * 帳票用方書表示有無を返します。
     *
     * @return 帳票用方書表示有無
     */
    RString get帳票用方書表示有無();

    /**
     * 外国人氏名表示方法を返します。
     *
     * @return 外国人氏名表示方法
     */
    RString get外国人氏名表示方法();

    /**
     * 老人保健市町村番号を返します。
     *
     * @return 老人保健市町村番号
     */
    RString get老人保健市町村番号();

    /**
     * 老人保健受給者番号体系を返します。
     *
     * @return 老人保健受給者番号体系
     */
    RString get老人保健受給者番号体系();

    /**
     * 特徴分配集約を返します。
     *
     * @return 特徴分配集約
     */
    RString get特徴分配集約();

    /**
     * 移行日を返します。
     *
     * @return 移行日
     */
    FlexibleDate get移行日();

    /**
     * 加入日を返します。
     *
     * @return 加入日
     */
    FlexibleDate get加入日();

    /**
     * 離脱日を返します。
     *
     * @return 離脱日
     */
    FlexibleDate get離脱日();

    /**
     * 合併旧市町村区分を返します。
     *
     * @return 合併旧市町村区分
     */
    RString get合併旧市町村区分();

    /**
     * 合併旧市町村表示有無を返します。
     *
     * @return 合併旧市町村表示有無
     */
    RString get合併旧市町村表示有無();

    /**
     * 合併情報地域番号を返します。
     *
     * @return 合併情報地域番号
     */
    RString get合併情報地域番号();

    /**
     * 運用保険者番号を返します。
     *
     * @return 運用保険者番号
     */
    ShoKisaiHokenshaNo get運用保険者番号();

    /**
     * 運用開始日を返します。
     *
     * @return 運用開始日
     */
    FlexibleDate get運用開始日();

    /**
     * 運用終了日を返します。
     *
     * @return 運用終了日
     */
    FlexibleDate get運用終了日();

    /**
     * 運用形態区分を返します。
     *
     * @return 運用形態区分
     */
    RString get運用形態区分();

}
