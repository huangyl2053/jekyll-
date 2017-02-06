/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.sonotakikanmaster;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合議体情報作成RelateEntityクラスです。
 *
 * @reamsid_L DBE-0090-020 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SonotaKikanJohoCSVEntity {

    @CsvField(order = 1)
    private RString 保険者番号;
    @CsvField(order = 2)
    private RString 保険者;
    @CsvField(order = 3)
    private RString その他機関コード;
    @CsvField(order = 4)
    private RString 機関名称;
    @CsvField(order = 5)
    private RString 機関名称カナ;
    @CsvField(order = 6)
    private RString 郵便番号;
    @CsvField(order = 7)
    private RString 住所;
    @CsvField(order = 8)
    private RString 住所カナ;
    @CsvField(order = 9)
    private RString 電話番号;
    @CsvField(order = 10)
    private RString 調査委託区分;
    @CsvField(order = 11)
    private RString 割付定員;
    @CsvField(order = 12)
    private RString 割付地区;
    @CsvField(order = 13)
    private RString 機関の区分;
    @CsvField(order = 14)
    private RString その他機関の状況;

    /**
     * コンストラクタです。
     *
     * @param 保険者番号 保険者番号
     * @param 保険者 保険者
     * @param その他機関コード その他機関コード
     * @param 機関名称 機関名称
     * @param 機関名称カナ 機関名称カナ
     * @param 郵便番号 郵便番号
     * @param 住所 住所
     * @param 住所カナ 住所カナ
     * @param 電話番号 電話番号
     * @param 調査委託区分 調査委託区分
     * @param 割付定員 割付定員
     * @param 割付地区 割付地区
     * @param 機関の区分 機関の区分
     * @param その他機関の状況 その他機関の状況
     */
    public SonotaKikanJohoCSVEntity(
            RString 保険者番号,
            RString 保険者,
            RString その他機関コード,
            RString 機関名称,
            RString 機関名称カナ,
            RString 郵便番号,
            RString 住所,
            RString 住所カナ,
            RString 電話番号,
            RString 調査委託区分,
            RString 割付定員,
            RString 割付地区,
            RString 機関の区分,
            RString その他機関の状況) {
        this.保険者番号 = 保険者番号;
        this.保険者 = 保険者;
        this.その他機関コード = その他機関コード;
        this.機関名称 = 機関名称;
        this.機関名称カナ = 機関名称カナ;
        this.郵便番号 = 郵便番号;
        this.住所 = 住所;
        this.住所カナ = 住所カナ;
        this.電話番号 = 電話番号;
        this.調査委託区分 = 調査委託区分;
        this.割付定員 = 割付定員;
        this.割付地区 = 割付地区;
        this.機関の区分 = 機関の区分;
        this.その他機関の状況 = その他機関の状況;
    }

}
