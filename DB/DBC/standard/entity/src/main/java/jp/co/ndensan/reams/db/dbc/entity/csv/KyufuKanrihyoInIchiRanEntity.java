/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票取込結果一覧表CSVのエンティティクラスです。
 *
 * @author N8156 宮本 康
 */
public class KyufuKanrihyoInIchiRanEntity {

    @CsvField(order = 10)
    private RString 連番;
    @CsvField(order = 20)
    private RString 対象年月;
    @CsvField(order = 30)
    private RString 支援事業者番号;
    @CsvField(order = 40)
    private RString 支援事業者名称;
    @CsvField(order = 50)
    private RString 計画作成区分コード;
    @CsvField(order = 60)
    private RString 計画作成区分;
    @CsvField(order = 70)
    private RString 作成区分コード;
    @CsvField(order = 80)
    private RString 作成区分;
    @CsvField(order = 90)
    private RString 被保険者番号;
    @CsvField(order = 100)
    private RString 被保険者氏名;
    @CsvField(order = 110)
    private RString 作成種別区分コード;
    @CsvField(order = 120)
    private RString 作成種別区分;
    @CsvField(order = 130)
    private RString 要介護状態区分コード;
    @CsvField(order = 140)
    private RString 要介護状態区分;
    @CsvField(order = 150)
    private RString 限度額管理期間_開始;
    @CsvField(order = 160)
    private RString 限度額管理期間_終了;
    @CsvField(order = 170)
    private RString 区分支給限度基準額;
    @CsvField(order = 180)
    private RString 指定サービス単位;
    @CsvField(order = 190)
    private RString 基準該当サービス単位;
    @CsvField(order = 200)
    private RString 合計単位;
    @CsvField(order = 210)
    private RString 証記載保険者番号;
    @CsvField(order = 220)
    private RString 備考;

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public RString get連番() {
        return 連番;
    }

    /**
     * 対象年月を返します。
     *
     * @return 対象年月
     */
    public RString get対象年月() {
        return 対象年月;
    }

    /**
     * 支援事業者番号を返します。
     *
     * @return 支援事業者番号
     */
    public RString get支援事業者番号() {
        return 支援事業者番号;
    }

    /**
     * 支援事業者名称を返します。
     *
     * @return 支援事業者名称
     */
    public RString get支援事業者名称() {
        return 支援事業者名称;
    }

    /**
     * 計画作成区分コードを返します。
     *
     * @return 計画作成区分コード
     */
    public RString get計画作成区分コード() {
        return 計画作成区分コード;
    }

    /**
     * 計画作成区分を返します。
     *
     * @return 計画作成区分
     */
    public RString get計画作成区分() {
        return 計画作成区分;
    }

    /**
     * 作成区分コードを返します。
     *
     * @return 作成区分コード
     */
    public RString get作成区分コード() {
        return 作成区分コード;
    }

    /**
     * 作成区分を返します。
     *
     * @return 作成区分
     */
    public RString get作成区分() {
        return 作成区分;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return 被保険者番号;
    }

    /**
     * 被保険者氏名を返します。
     *
     * @return 被保険者氏名
     */
    public RString get被保険者氏名() {
        return 被保険者氏名;
    }

    /**
     * 作成種別区分コードを返します。
     *
     * @return 作成種別区分コード
     */
    public RString get作成種別区分コード() {
        return 作成種別区分コード;
    }

    /**
     * 作成種別区分を返します。
     *
     * @return 作成種別区分
     */
    public RString get作成種別区分() {
        return 作成種別区分;
    }

    /**
     * 要介護状態区分コードを返します。
     *
     * @return 要介護状態区分コード
     */
    public RString get要介護状態区分コード() {
        return 要介護状態区分コード;
    }

    /**
     * 要介護状態区分を返します。
     *
     * @return 要介護状態区分
     */
    public RString get要介護状態区分() {
        return 要介護状態区分;
    }

    /**
     * 限度額管理期間_開始を返します。
     *
     * @return 限度額管理期間_開始
     */
    public RString get限度額管理期間_開始() {
        return 限度額管理期間_開始;
    }

    /**
     * 限度額管理期間_終了を返します。
     *
     * @return 限度額管理期間_終了
     */
    public RString get限度額管理期間_終了() {
        return 限度額管理期間_終了;
    }

    /**
     * 区分支給限度基準額を返します。
     *
     * @return 区分支給限度基準額
     */
    public RString get区分支給限度基準額() {
        return 区分支給限度基準額;
    }

    /**
     * 指定サービス単位を返します。
     *
     * @return 指定サービス単位
     */
    public RString get指定サービス単位() {
        return 指定サービス単位;
    }

    /**
     * 基準該当サービス単位を返します。
     *
     * @return 基準該当サービス単位
     */
    public RString get基準該当サービス単位() {
        return 基準該当サービス単位;
    }

    /**
     * 合計単位を返します。
     *
     * @return 合計単位
     */
    public RString get合計単位() {
        return 合計単位;
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return 証記載保険者番号;
    }

    /**
     * 備考を返します。
     *
     * @return 備考
     */
    public RString get備考() {
        return 備考;
    }

    /**
     * 連番を設定します。
     *
     * @param 連番 連番
     */
    public void set連番(RString 連番) {
        this.連番 = 連番;
    }

    /**
     * 対象年月を設定します。
     *
     * @param 対象年月 対象年月
     */
    public void set対象年月(RString 対象年月) {
        this.対象年月 = 対象年月;
    }

    /**
     * 支援事業者番号を設定します。
     *
     * @param 支援事業者番号 支援事業者番号
     */
    public void set支援事業者番号(RString 支援事業者番号) {
        this.支援事業者番号 = 支援事業者番号;
    }

    /**
     * 支援事業者名称を設定します。
     *
     * @param 支援事業者名称 支援事業者名称
     */
    public void set支援事業者名称(RString 支援事業者名称) {
        this.支援事業者名称 = 支援事業者名称;
    }

    /**
     * 計画作成区分コードを設定します。
     *
     * @param 計画作成区分コード 計画作成区分コード
     */
    public void set計画作成区分コード(RString 計画作成区分コード) {
        this.計画作成区分コード = 計画作成区分コード;
    }

    /**
     * 計画作成区分を設定します。
     *
     * @param 計画作成区分 計画作成区分
     */
    public void set計画作成区分(RString 計画作成区分) {
        this.計画作成区分 = 計画作成区分;
    }

    /**
     * 作成区分コードを設定します。
     *
     * @param 作成区分コード 作成区分コード
     */
    public void set作成区分コード(RString 作成区分コード) {
        this.作成区分コード = 作成区分コード;
    }

    /**
     * 作成区分を設定します。
     *
     * @param 作成区分 作成区分
     */
    public void set作成区分(RString 作成区分) {
        this.作成区分 = 作成区分;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(RString 被保険者番号) {
        this.被保険者番号 = 被保険者番号;
    }

    /**
     * 被保険者氏名を設定します。
     *
     * @param 被保険者氏名 被保険者氏名
     */
    public void set被保険者氏名(RString 被保険者氏名) {
        this.被保険者氏名 = 被保険者氏名;
    }

    /**
     * 作成種別区分コードを設定します。
     *
     * @param 作成種別区分コード 作成種別区分コード
     */
    public void set作成種別区分コード(RString 作成種別区分コード) {
        this.作成種別区分コード = 作成種別区分コード;
    }

    /**
     * 作成種別区分を設定します。
     *
     * @param 作成種別区分 作成種別区分
     */
    public void set作成種別区分(RString 作成種別区分) {
        this.作成種別区分 = 作成種別区分;
    }

    /**
     * 要介護状態区分コードを設定します。
     *
     * @param 要介護状態区分コード 要介護状態区分コード
     */
    public void set要介護状態区分コード(RString 要介護状態区分コード) {
        this.要介護状態区分コード = 要介護状態区分コード;
    }

    /**
     * 要介護状態区分を設定します。
     *
     * @param 要介護状態区分 要介護状態区分
     */
    public void set要介護状態区分(RString 要介護状態区分) {
        this.要介護状態区分 = 要介護状態区分;
    }

    /**
     * 限度額管理期間_開始を設定します。
     *
     * @param 限度額管理期間_開始 限度額管理期間_開始
     */
    public void set限度額管理期間_開始(RString 限度額管理期間_開始) {
        this.限度額管理期間_開始 = 限度額管理期間_開始;
    }

    /**
     * 限度額管理期間_終了を設定します。
     *
     * @param 限度額管理期間_終了 限度額管理期間_終了
     */
    public void set限度額管理期間_終了(RString 限度額管理期間_終了) {
        this.限度額管理期間_終了 = 限度額管理期間_終了;
    }

    /**
     * 区分支給限度基準額を設定します。
     *
     * @param 区分支給限度基準額 区分支給限度基準額
     */
    public void set区分支給限度基準額(RString 区分支給限度基準額) {
        this.区分支給限度基準額 = 区分支給限度基準額;
    }

    /**
     * 指定サービス単位を設定します。
     *
     * @param 指定サービス単位 指定サービス単位
     */
    public void set指定サービス単位(RString 指定サービス単位) {
        this.指定サービス単位 = 指定サービス単位;
    }

    /**
     * 基準該当サービス単位を設定します。
     *
     * @param 基準該当サービス単位 基準該当サービス単位
     */
    public void set基準該当サービス単位(RString 基準該当サービス単位) {
        this.基準該当サービス単位 = 基準該当サービス単位;
    }

    /**
     * 合計単位を設定します。
     *
     * @param 合計単位 合計単位
     */
    public void set合計単位(RString 合計単位) {
        this.合計単位 = 合計単位;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(RString 証記載保険者番号) {
        this.証記載保険者番号 = 証記載保険者番号;
    }

    /**
     * 備考を設定します。
     *
     * @param 備考 備考
     */
    public void set備考(RString 備考) {
        this.備考 = 備考;
    }
}
