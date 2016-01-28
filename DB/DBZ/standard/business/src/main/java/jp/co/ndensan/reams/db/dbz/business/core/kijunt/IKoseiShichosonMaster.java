/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.kijunt;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * リスト(市町村情報)の取得します
 *
 */
public interface IKoseiShichosonMaster {

    /**
     * 市町村識別IDのgetメソッドです。
     *
     * @return 市町村識別ID
     */
    RString get市町村識別ID();

    /**
     * 市町村コードのgetメソッドです。
     *
     * @return 市町村コード
     */
    LasdecCode get市町村コード();

    /**
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    ShoKisaiHokenshaNo get証記載保険者番号();

    /**
     * 国保連広域内市町村番号のgetメソッドです。
     *
     * @return 国保連広域内市町村番号
     */
    RString get国保連広域内市町村番号();

    /**
     * 市町村名称のgetメソッドです。
     *
     * @return 市町村名称
     */
    RString get市町村名称();

    /**
     * 都道府県名称のgetメソッドです。
     *
     * @return 都道府県名称
     */
    RString get都道府県名称();

    /**
     * 郡名称のgetメソッドです。
     *
     * @return 郡名称
     */
    RString get郡名称();

    /**
     * 郵便番号のgetメソッドです。
     *
     * @return 郵便番号
     */
    YubinNo get郵便番号();

    /**
     * 住所のgetメソッドです。
     *
     * @return 住所
     */
    AtenaJusho get住所();

    /**
     * 電話番号のgetメソッドです。
     *
     * @return 電話番号
     */
    TelNo get電話番号();

    /**
     * 最優先地区コードのgetメソッドです。
     *
     * @return 最優先地区コード
     */
    RString get最優先地区コード();

    /**
     * 帳票用都道府県名称表示有無のgetメソッドです。
     *
     * @return 帳票用都道府県名称表示有無
     */
    RString get帳票用都道府県名称表示有無();

    /**
     * 帳票用郡名称表示有無のgetメソッドです。
     *
     * @return 帳票用郡名称表示有無
     */
    RString get帳票用郡名称表示有無();

    /**
     * 帳票用市町村名称表示有無のgetメソッドです。
     *
     * @return 帳票用市町村名称表示有無
     */
    RString get帳票用市町村名称表示有無();

    /**
     * 帳票用住所編集方法のgetメソッドです。
     *
     * @return 帳票用住所編集方法
     */
    RString get帳票用住所編集方法();

    /**
     * 帳票用方書表示有無のgetメソッドです。
     *
     * @return 帳票用方書表示有無
     */
    RString get帳票用方書表示有無();

    /**
     * 老人保健市町村番号のgetメソッドです。
     *
     * @return 老人保健市町村番号
     */
    RString get老人保健市町村番号();

    /**
     * 老人保健受給者番号体系のgetメソッドです。
     *
     * @return 老人保健受給者番号体系
     */
    RString get老人保健受給者番号体系();

    /**
     * 特徴分配集約のgetメソッドです。
     * <br/>
     * <br/>0：なし　1：あり（国保／後期）　2：あり（後期）
     *
     * @return 特徴分配集約
     */
    RString get特徴分配集約();

    /**
     * 移行日のgetメソッドです。
     *
     * @return 移行日
     */
    FlexibleDate get移行日();

    /**
     * 加入日のgetメソッドです。
     *
     * @return 加入日
     */
    FlexibleDate get加入日();

    /**
     * 離脱日のgetメソッドです。
     *
     * @return 離脱日
     */
    FlexibleDate get離脱日();

    /**
     * 合併旧市町村区分 １：合併前の旧市町村である ０：最新の広域構成市町村であるのgetメソッドです。
     *
     * @return 合併旧市町村区分 １：合併前の旧市町村である ０：最新の広域構成市町村である
     */
    RString get合併旧市町村区分();

    /**
     * 合併旧市町村表示有無 合併旧市町村で表示を必要とする市町村について、表示設定が行われる １：表示する ０：表示しないのgetメソッドです。
     *
     * @return 合併旧市町村表示有無 合併旧市町村で表示を必要とする市町村について、表示設定が行われる １：表示する ０：表示しない
     */
    RString get合併旧市町村表示有無();

    /**
     * 合併情報地域番号のgetメソッドです。
     *
     * @return 合併情報地域番号
     */
    RString get合併情報地域番号();

    /**
     * 運用保険者番号のgetメソッドです。
     *
     * @return 運用保険者番号
     */
    ShoKisaiHokenshaNo get運用保険者番号();

    /**
     * 運用開始日のgetメソッドです。
     *
     * @return 運用開始日
     */
    FlexibleDate get運用開始日();

    /**
     * 運用終了日のgetメソッドです。
     *
     * @return 運用終了日
     */
    FlexibleDate get運用終了日();

    /**
     * 運用形態区分のgetメソッドです。
     * <br/>
     * <br/>単独
     * <br/>広域連合
     * <br/>一部事務組合
     *
     * @return 運用形態区分
     */
    RString get運用形態区分();

}
