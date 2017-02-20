/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahyojissekiichiran;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
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

    @CsvField(order = 1, name = "保険者番号")
    private final RString 保険者番号;
    @CsvField(order = 2, name = "保険者名称")
    private final RString 保険者名称;
    @CsvField(order = 3, name = "調査機関コード")
    private final RString 調査機関コード;
    @CsvField(order = 4, name = "調査機関名称")
    private final RString 調査機関名称;
    @CsvField(order = 5, name = "調査員コード")
    private final RString 調査員コード;
    @CsvField(order = 6, name = "調査員氏名")
    private final RString 調査員氏名;
    @CsvField(order = 7, name = "被保険者番号")
    private final RString 被保険者番号;
    @CsvField(order = 8, name = "被保険者氏名")
    private final RString 被保険者氏名;
    @CsvField(order = 9, name = "調査依頼日")
    private final RString 調査依頼日;
    @CsvField(order = 10, name = "調査実施日")
    private final RString 調査実施日;
    @CsvField(order = 11, name = "調査入手日")
    private final RString 調査入手日;
    @CsvField(order = 12, name = "調査区分")
    private final RString 調査区分;
    @CsvField(order = 13, name = "訪問の種類")
    private final RString 訪問の種類;
    @CsvField(order = 14, name = "単価")
    private final RString 単価;

    /**
     * コンストラクタです。
     *
     * @param 保険者番号 保険者番号
     * @param 保険者名称 保険者名称
     * @param 調査機関コード 調査機関コード
     * @param 調査機関名称 調査機関名称
     * @param 調査員コード 調査員コード
     * @param 調査員氏名 調査員氏名
     * @param 被保険者番号 被保険者番号
     * @param 申請者氏名 申請者氏名
     * @param 調査依頼日 調査依頼日
     * @param 調査実施日 調査実施日
     * @param 調査入手日 調査入手日
     * @param 調査区分 調査区分
     * @param 訪問の種類 訪問の種類
     * @param 単価
     */
    public ChosahyoJissekiIchiranEntity(
            RString 保険者番号,
            RString 保険者名称,
            RString 調査機関コード,
            RString 調査機関名称,
            RString 調査員コード,
            RString 調査員氏名,
            RString 被保険者番号,
            RString 申請者氏名,
            RString 調査依頼日,
            RString 調査実施日,
            RString 調査入手日,
            RString 調査区分,
            RString 訪問の種類,
            RString 単価) {
        this.保険者番号 = 保険者番号;
        this.保険者名称 = 保険者名称;
        this.調査機関コード = 調査機関コード;
        this.調査機関名称 = 調査機関名称;
        this.調査員コード = 調査員コード;
        this.調査員氏名 = 調査員氏名;
        this.被保険者番号 = 被保険者番号;
        this.被保険者氏名 = 申請者氏名;
        this.調査依頼日 = 調査依頼日;
        this.調査実施日 = 調査実施日;
        this.調査入手日 = 調査入手日;
        this.調査区分 = 調査区分;
        this.訪問の種類 = 訪問の種類;
        this.単価 = 単価;
    }

    public ChosahyoJissekiIchiranEntity(ChosahyoJissekiIchiranRelateEntity relateEntity) {
        this.保険者番号 = relateEntity.get証記載保険者番号();
        this.保険者名称 = relateEntity.get市町村名称();
        this.調査機関コード = relateEntity.get調査委託先コード();
        this.調査機関名称 = relateEntity.get事業者名称();
        this.調査員コード = relateEntity.get調査員コード();
        this.調査員氏名 = relateEntity.get調査員氏名();
        this.被保険者番号 = relateEntity.get被保険者番号();
        this.被保険者氏名 = relateEntity.get被保険者氏名();
        this.調査依頼日 = dateFormat(relateEntity.get認定調査依頼年月日());
        this.調査実施日 = dateFormat(relateEntity.get認定調査実施年月日());
        this.調査入手日 = dateFormat(relateEntity.get認定調査受領年月日());
        this.調査区分 = ChosaKubun.toValue(relateEntity.get認定調査区分コード()).get名称();
        if (relateEntity.is訪問の種類()) {
            this.訪問の種類 = new RString("居宅");
        } else {
            this.訪問の種類 = new RString("施設");
        }
        this.単価 = relateEntity.get単価();
    }
    
    private static RString dateFormat(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        RDate date_tem = new RDate(date.toString());
        return date_tem.seireki().separator(Separator.SLASH).toDateString();
    }
}
