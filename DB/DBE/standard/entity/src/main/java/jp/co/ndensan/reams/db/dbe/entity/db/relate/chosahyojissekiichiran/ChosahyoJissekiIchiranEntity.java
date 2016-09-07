/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahyojissekiichiran;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票出力用認定調査実績集計表Builderクラスです。
 *
 * @reamsid_L DBE-1691-030 dangjingjing
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosahyoJissekiIchiranEntity implements IChosahyoJissekiIchiranCsvEucEntity {

    @CsvField(order = 1, name = "保険者")
    private final RString 保険者番号;
    @CsvField(order = 2, name = "調査機関コード")
    private final RString 調査機関コード;
    @CsvField(order = 3, name = "調査機関名称")
    private final RString 調査機関名称;
    @CsvField(order = 4, name = "調査員氏名")
    private final RString 調査員氏名;
    @CsvField(order = 5, name = "被保険者番号")
    private final RString 被保険者番号;
    @CsvField(order = 6, name = "申請者氏名")
    private final RString 申請者氏名;
    @CsvField(order = 7, name = "調査実施日")
    private final RString 調査実施日;
    @CsvField(order = 8, name = "調査区分")
    private final RString 調査区分;
    @CsvField(order = 9, name = "訪問の種類")
    private final RString 訪問の種類;

    /**
     * コンストラクタです。
     *
     * @param 保険者番号 保険者番号
     * @param 調査機関コード 調査機関コード
     * @param 調査機関名称 調査機関名称
     * @param 調査員氏名 調査員氏名
     * @param 被保険者番号 被保険者番号
     * @param 申請者氏名 申請者氏名
     * @param 調査実施日 調査実施日
     * @param 調査区分 調査区分
     * @param 訪問の種類 訪問の種類
     */
    public ChosahyoJissekiIchiranEntity(
            RString 保険者番号,
            RString 調査機関コード,
            RString 調査機関名称,
            RString 調査員氏名,
            RString 被保険者番号,
            RString 申請者氏名,
            RString 調査実施日,
            RString 調査区分,
            RString 訪問の種類) {
        this.保険者番号 = 保険者番号;
        this.調査機関コード = 調査機関コード;
        this.調査機関名称 = 調査機関名称;
        this.調査員氏名 = 調査員氏名;
        this.被保険者番号 = 被保険者番号;
        this.申請者氏名 = 申請者氏名;
        this.調査実施日 = 調査実施日;
        this.調査区分 = 調査区分;
        this.訪問の種類 = 訪問の種類;
    }
}
