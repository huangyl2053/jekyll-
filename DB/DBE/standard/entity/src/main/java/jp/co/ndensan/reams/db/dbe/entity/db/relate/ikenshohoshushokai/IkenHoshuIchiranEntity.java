/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshushokai;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書作成報酬の帳票のパラメータクラスです。
 *
 * @reamsid_L DBE-1930-030 chenxiangyu
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenHoshuIchiranEntity implements IIkenHoshuIchiranCsvEucEntity {

    @CsvField(order = 1, name = "医療機関コード")
    private final RString 医療機関番号;
    @CsvField(order = 2, name = "医療機関名")
    private final RString 医療機関名;
    @CsvField(order = 3, name = "主治医_コード")
    private final RString 医師番号;
    @CsvField(order = 4, name = "主治医_氏名")
    private final RString 医師名;
    @CsvField(order = 5, name = "依頼日")
    private final RString 依頼日;
    @CsvField(order = 6, name = "記入日")
    private final RString 記入日;
    @CsvField(order = 7, name = "入手日")
    private final RString 入手日;
    @CsvField(order = 8, name = "意見（再）")
    private final RString 意見;
    @CsvField(order = 9, name = "保険者")
    private final RString 保険者番号;
    @CsvField(order = 10, name = "申請者_被保険者番号")
    private final RString 被保険者番号;
    @CsvField(order = 11, name = "在宅_新")
    private final RString 在新;
    @CsvField(order = 12, name = "在宅_継")
    private final RString 在継;
    @CsvField(order = 13, name = "施設_新")
    private final RString 施新;
    @CsvField(order = 14, name = "施設_継")
    private final RString 施継;
    @CsvField(order = 15, name = "報酬額_作成料")
    private final RString 作成料;
    @CsvField(order = 16, name = "報酬額_診療費等")
    private final RString 診断検査費用;
    @CsvField(order = 17, name = "合計")
    private final RString 合計;
    private RString 抽出期間;
    private final RString 申請者;

    /**
     * コンストラクタです。
     *
     * @param 医療機関番号 医療機関番号
     * @param 医療機関名 医療機関名
     * @param 医師番号 医師番号
     * @param 医師名 医師名
     * @param 依頼日 依頼日
     * @param 記入日 記入日
     * @param 入手日 入手日
     * @param 意見 意見
     * @param 保険者番号 保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 申請者 申請者
     * @param 在新 在新
     * @param 在継 在継
     * @param 施新 施新
     * @param 施継 施継
     * @param 作成料 作成料
     * @param 診断検査費用 診断検査費用
     * @param 合計 合計
     */
    public IkenHoshuIchiranEntity(RString 医療機関番号,
            RString 医療機関名,
            RString 医師番号,
            RString 医師名,
            RString 依頼日,
            RString 記入日,
            RString 入手日,
            RString 意見,
            RString 保険者番号,
            RString 被保険者番号,
            RString 申請者,
            RString 在新,
            RString 在継,
            RString 施新,
            RString 施継,
            RString 作成料,
            RString 診断検査費用,
            RString 合計) {
        this.医療機関番号 = 医療機関番号;
        this.医療機関名 = 医療機関名;
        this.医師番号 = 医師番号;
        this.医師名 = 医師名;
        this.依頼日 = 依頼日;
        this.記入日 = 記入日;
        this.入手日 = 入手日;
        this.意見 = 意見;
        this.保険者番号 = 保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.申請者 = 申請者;
        this.在新 = 在新;
        this.在継 = 在継;
        this.施新 = 施新;
        this.施継 = 施継;
        this.作成料 = 作成料;
        this.診断検査費用 = 診断検査費用;
        this.合計 = 合計;
    }
}
