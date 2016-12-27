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
    private RString 証記載保険者番号;
    @CsvField(order = 2)
    private RString その他機関コード;
    @CsvField(order = 3)
    private RString 機関名称;
    @CsvField(order = 4)
    private RString 機関名称カナ;
    @CsvField(order = 5)
    private RString 郵便番号;
    @CsvField(order = 6)
    private RString 住所;
    @CsvField(order = 7)
    private RString 電話番号;
    @CsvField(order = 8)
    private RString 調査委託区分;
    @CsvField(order = 9)
    private RString 機関の区分;

    /**
     * コンストラクタです。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param その他機関コード その他機関コード
     * @param 機関名称 機関名称
     * @param 機関名称カナ 機関名称カナ
     * @param 郵便番号 郵便番号
     * @param 住所 住所
     * @param 電話番号 電話番号
     * @param 調査委託区分 調査委託区分
     * @param 機関の区分 機関の区分
     */
    public SonotaKikanJohoCSVEntity(
            RString 証記載保険者番号,
            RString その他機関コード,
            RString 機関名称,
            RString 機関名称カナ,
            RString 郵便番号,
            RString 住所,
            RString 電話番号,
            RString 調査委託区分,
            RString 機関の区分) {
        this.証記載保険者番号 = 証記載保険者番号;
        this.その他機関コード = その他機関コード;
        this.機関名称 = 機関名称;
        this.機関名称カナ = 機関名称カナ;
        this.郵便番号 = 郵便番号;
        this.住所 = 住所;
        this.電話番号 = 電話番号;
        this.調査委託区分 = 調査委託区分;
        this.機関の区分 = 機関の区分;
    }

}
