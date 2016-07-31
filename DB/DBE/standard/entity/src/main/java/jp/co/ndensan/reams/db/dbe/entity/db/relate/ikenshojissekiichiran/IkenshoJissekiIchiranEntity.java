/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshojissekiichiran;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書作成実績集計表の帳票のパラメータクラスです。
 *
 * @reamsid_L DBE-1690-040 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoJissekiIchiranEntity implements IIkenshoJissekiIchiranCsvEucEntity {

    @CsvField(order = 1, name = "保険者")
    private final RString 保険者番号;
    @CsvField(order = 2, name = "医療機関コード")
    private final RString 医療機関コード;
    @CsvField(order = 3, name = "医療機関名")
    private final RString 医療機関名称;
    @CsvField(order = 4, name = "主治医名")
    private final RString 主治医氏名;
    @CsvField(order = 5, name = "被保険者番号")
    private final RString 被保険者番号;
    @CsvField(order = 6, name = "申請者名")
    private final RString 申請者氏名;
    @CsvField(order = 7, name = "記入日")
    private final RString 記入日;
    @CsvField(order = 8, name = "入手日")
    private final RString 入手日;
    @CsvField(order = 9, name = "在宅_新")
    private final RString 入手パターン_在新;
    @CsvField(order = 10, name = "在宅_継")
    private final RString 入手パターン_在継;
    @CsvField(order = 11, name = "施設_新")
    private final RString 入手パターン_施新;
    @CsvField(order = 12, name = "施設_継")
    private final RString 入手パターン_施継;
    @CsvField(order = 13, name = "医師区分")
    private final RString 医師区分;

    /**
     * コンストラクタです。
     *
     * @param 保険者番号 保険者番号
     * @param 医療機関コード 医療機関コード
     * @param 医療機関名称 医療機関名称
     * @param 主治医氏名 主治医氏名
     * @param 被保険者番号 被保険者番号
     * @param 申請者氏名 申請者氏名
     * @param 記入日 記入日
     * @param 入手日 入手日
     * @param 入手パターン_在新 入手パターン_在新
     * @param 入手パターン_在継 入手パターン_在継
     * @param 入手パターン_施新 入手パターン_施新
     * @param 入手パターン_施継 入手パターン_施継
     * @param 医師区分 医師区分
     */
    public IkenshoJissekiIchiranEntity(RString 保険者番号,
            RString 医療機関コード,
            RString 医療機関名称,
            RString 主治医氏名,
            RString 被保険者番号,
            RString 申請者氏名,
            RString 記入日,
            RString 入手日,
            RString 入手パターン_在新,
            RString 入手パターン_在継,
            RString 入手パターン_施新,
            RString 入手パターン_施継,
            RString 医師区分) {
        this.保険者番号 = 保険者番号;
        this.医療機関コード = 医療機関コード;
        this.医療機関名称 = 医療機関名称;
        this.主治医氏名 = 主治医氏名;
        this.被保険者番号 = 被保険者番号;
        this.申請者氏名 = 申請者氏名;
        this.記入日 = 記入日;
        this.入手日 = 入手日;
        this.入手パターン_在新 = 入手パターン_在新;
        this.入手パターン_在継 = 入手パターン_在継;
        this.入手パターン_施新 = 入手パターン_施新;
        this.入手パターン_施継 = 入手パターン_施継;
        this.医師区分 = 医師区分;
    }
}
