/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahoshushokai;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査報酬照会帳票を定義したEntityクラスです。
 *
 * @reamsid_L DBE-1940-020 jinjue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class NinteiChosaHoshuShokaiCsvEntity implements IChosaHoshuShokaiCsvEucEntity {

    @CsvField(order = 1, name = "調査機関コード")
    private RString 調査機関コード;
    @CsvField(order = 2, name = "調査機関名")
    private RString 調査機関名;
    @CsvField(order = 3, name = "調査機関コード")
    private RString 調査員_コード;
    @CsvField(order = 4, name = "調査員_氏名")
    private RString 調査員_氏名;
    @CsvField(order = 5, name = "調査機関コード")
    private RDate 依頼日;
    @CsvField(order = 6, name = "依頼日")
    private RDate 調査日;
    @CsvField(order = 7, name = "入手日")
    private RDate 入手日;
    @CsvField(order = 8, name = "調査_再")
    private RString 調査_再;
    @CsvField(order = 9, name = "保険者")
    private RString 保険者;
    @CsvField(order = 10, name = "申請者_被保険者番号")
    private RString 申請者_被保険者番号;
    @CsvField(order = 11, name = "申請者_氏名")
    private RString 申請者_氏名;
    @CsvField(order = 12, name = "在宅_初")
    private RString 在宅_初;
    @CsvField(order = 13, name = "在宅_再")
    private RString 在宅_再;
    @CsvField(order = 14, name = "施設_初")
    private RString 施設_初;
    @CsvField(order = 15, name = "施設_再")
    private RString 施設_再;
    @CsvField(order = 16, name = "委託料")
    private RString 委託料;
    @CsvField(order = 17, name = "在宅_初合計")
    private int 在宅_初合計;
    @CsvField(order = 18, name = "在宅_再合計")
    private int 在宅_再合計;
    @CsvField(order = 19, name = "施設_初合計")
    private int 施設_初合計;
    @CsvField(order = 20, name = "施設_再合計")
    private int 施設_再合計;
    @CsvField(order = 22, name = "調査依頼日開始")
    private RString 調査依頼日開始;
    @CsvField(order = 23, name = "調査依頼日終了")
    private RString 調査依頼日終了;
    @CsvField(order = 24, name = "no")
    private int 番号;
    @CsvField(order = 25, name = "認定調査委託料")
    private int 認定調査委託料;

    /**
     * コンストラクタです。
     */
    public NinteiChosaHoshuShokaiCsvEntity() {
    }

    /**
     * コンストラクタです。
     *
     * @param 調査機関コード 調査機関コード
     * @param 調査機関名 調査機関名
     * @param 調査員_コード 調査員_コード
     * @param 調査員_氏名 調査員_氏名
     * @param 依頼日 依頼日
     * @param 調査日 調査日
     * @param 入手日 入手日
     * @param 調査_再 調査_再
     * @param 保険者 保険者
     * @param 申請者_被保険者番号 申請者_被保険者番号
     * @param 申請者_氏名 申請者_氏名
     * @param 在宅_初 在宅_初
     * @param 在宅_再 在宅_再
     * @param 施設_初 施設_初
     * @param 施設_再 施設_再
     * @param 委託料 委託料
     * @param 在宅_初合計 在宅_初合計
     * @param 在宅_再合計 在宅_再合計
     * @param 施設_初合計 施設_初合計
     * @param 施設_再合計 施設_再合計
     * @param 調査依頼日開始 調査依頼日開始
     * @param 調査依頼日終了 調査依頼日終了
     * @param 番号 番号
     * @param 認定調査委託料 認定調査委託料
     */
    public NinteiChosaHoshuShokaiCsvEntity(RString 調査機関コード, RString 調査機関名, RString 調査員_コード, RString 調査員_氏名,
            RDate 依頼日, RDate 調査日, RDate 入手日, RString 調査_再, RString 保険者, RString 申請者_被保険者番号, RString 申請者_氏名,
            RString 在宅_初, RString 在宅_再, RString 施設_初, RString 施設_再, RString 委託料, int 在宅_初合計, int 在宅_再合計,
            int 施設_初合計, int 施設_再合計, RString 調査依頼日開始, RString 調査依頼日終了, int 番号, int 認定調査委託料) {
        this.調査機関コード = 調査機関コード;
        this.調査機関名 = 調査機関名;
        this.調査員_コード = 調査員_コード;
        this.調査員_氏名 = 調査員_氏名;
        this.依頼日 = 依頼日;
        this.調査日 = 調査日;
        this.入手日 = 入手日;
        this.調査_再 = 調査_再;
        this.保険者 = 保険者;
        this.申請者_被保険者番号 = 申請者_被保険者番号;
        this.申請者_氏名 = 申請者_氏名;
        this.在宅_初 = 在宅_初;
        this.在宅_再 = 在宅_再;
        this.施設_初 = 施設_初;
        this.施設_再 = 施設_再;
        this.委託料 = 委託料;
        this.在宅_初合計 = 在宅_初合計;
        this.在宅_再合計 = 在宅_再合計;
        this.施設_初合計 = 施設_初合計;
        this.施設_再合計 = 施設_再合計;
        this.調査依頼日終了 = 調査依頼日終了;
        this.調査依頼日開始 = 調査依頼日開始;
        this.番号 = 番号;
        this.認定調査委託料 = 認定調査委託料;
    }
}
