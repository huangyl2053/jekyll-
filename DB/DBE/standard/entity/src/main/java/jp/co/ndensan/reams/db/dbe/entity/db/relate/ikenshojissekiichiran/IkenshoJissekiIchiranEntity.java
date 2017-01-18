/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshojissekiichiran;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IshiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.ZaitakuShisetsuKubun;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
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

    @CsvField(order = 1, name = "保険者番号")
    private final RString 保険者番号;
    @CsvField(order = 2, name = "保険者名称")
    private final RString 保険者名称;
    @CsvField(order = 3, name = "医療機関コード")
    private final RString 医療機関コード;
    @CsvField(order = 4, name = "医療機関名")
    private final RString 医療機関名称;
    @CsvField(order = 5, name = "主治医コード")
    private final RString 主治医コード;
    @CsvField(order = 6, name = "主治医名")
    private final RString 主治医氏名;
    @CsvField(order = 7, name = "被保険者番号")
    private final RString 被保険者番号;
    @CsvField(order = 8, name = "被保険者氏名")
    private final RString 被保険者氏名;
    @CsvField(order = 9, name = "依頼日")
    private final RString 依頼日;
    @CsvField(order = 10, name = "記入日")
    private final RString 記入日;
    @CsvField(order = 11, name = "入手日")
    private final RString 入手日;
    @CsvField(order = 12, name = "在宅_新")
    private final RString 入手パターン_在新;
    @CsvField(order = 13, name = "在宅_継")
    private final RString 入手パターン_在継;
    @CsvField(order = 14, name = "施設_新")
    private final RString 入手パターン_施新;
    @CsvField(order = 15, name = "施設_継")
    private final RString 入手パターン_施継;
    @CsvField(order = 16, name = "医師区分")
    private final RString 医師区分;
    
    private static final RString MARU = new RString("○");

    /**
     * コンストラクタです。
     *
     * @param 保険者番号 保険者番号
     * @param 保険者名称 保険者名称
     * @param 医療機関コード 医療機関コード
     * @param 医療機関名称 医療機関名称
     * @param 主治医コード 主治医コード
     * @param 主治医氏名 主治医氏名
     * @param 被保険者番号 被保険者番号
     * @param 申請者氏名 申請者氏名
     * @param 依頼日 依頼日
     * @param 記入日 記入日
     * @param 入手日 入手日
     * @param 入手パターン_在新 入手パターン_在新
     * @param 入手パターン_在継 入手パターン_在継
     * @param 入手パターン_施新 入手パターン_施新
     * @param 入手パターン_施継 入手パターン_施継
     * @param 医師区分 医師区分
     */
    public IkenshoJissekiIchiranEntity(RString 保険者番号,
            RString 保険者名称,
            RString 医療機関コード,
            RString 医療機関名称,
            RString 主治医コード,
            RString 主治医氏名,
            RString 被保険者番号,
            RString 申請者氏名,
            RString 依頼日,
            RString 記入日,
            RString 入手日,
            RString 入手パターン_在新,
            RString 入手パターン_在継,
            RString 入手パターン_施新,
            RString 入手パターン_施継,
            RString 医師区分) {
        this.保険者番号 = 保険者番号;
        this.保険者名称 = 保険者名称;
        this.医療機関コード = 医療機関コード;
        this.医療機関名称 = 医療機関名称;
        this.主治医コード = 主治医コード;
        this.主治医氏名 = 主治医氏名;
        this.被保険者番号 = 被保険者番号;
        this.被保険者氏名 = 申請者氏名;
        this.依頼日 = 依頼日;
        this.記入日 = 記入日;
        this.入手日 = 入手日;
        this.入手パターン_在新 = 入手パターン_在新;
        this.入手パターン_在継 = 入手パターン_在継;
        this.入手パターン_施新 = 入手パターン_施新;
        this.入手パターン_施継 = 入手パターン_施継;
        this.医師区分 = 医師区分;
    }

    public IkenshoJissekiIchiranEntity(IkenshoJissekiIchiranRelateEntity relateEntity) {
        RString 在宅_新 = RString.EMPTY;
        RString 在宅_継 = RString.EMPTY;
        RString 施設_新 = RString.EMPTY;
        RString 施設_継 = RString.EMPTY;
        if (ZaitakuShisetsuKubun.在宅.getコード().equals(relateEntity.get在宅_施設区分())) {
            if (IkenshoIraiKubun.初回依頼.getコード().equals(relateEntity.get主治医意見書依頼区分())) {
                在宅_新 = MARU;
            }
            if (IkenshoIraiKubun.再依頼.getコード().equals(relateEntity.get主治医意見書依頼区分())
                    || IkenshoIraiKubun.再意見書.getコード().equals(relateEntity.get主治医意見書依頼区分())) {
                在宅_継 = MARU;
            }
        }
        if (ZaitakuShisetsuKubun.施設.getコード().equals(relateEntity.get在宅_施設区分())) {
            if (IkenshoIraiKubun.初回依頼.getコード().equals(relateEntity.get主治医意見書依頼区分())) {
                施設_新 = MARU;
            }
            if (IkenshoIraiKubun.再依頼.getコード().equals(relateEntity.get主治医意見書依頼区分())
                    || IkenshoIraiKubun.再意見書.getコード().equals(relateEntity.get主治医意見書依頼区分())) {
                施設_継 = MARU;
            }
        }
        this.保険者番号 = relateEntity.get証記載保険者番号();
        this.保険者名称 = relateEntity.get市町村名称();
        this.医療機関コード = relateEntity.get医療機関コード();
        this.医療機関名称 = relateEntity.get医療機関名称();
        this.主治医コード = relateEntity.get主治医コード();
        this.主治医氏名 = relateEntity.get主治医氏名();
        this.被保険者番号 = relateEntity.get被保険者番号();
        this.被保険者氏名 = relateEntity.get申請者氏名();
        this.依頼日 = dateFormat(relateEntity.get依頼日());
        this.記入日 = dateFormat(relateEntity. get記入日());
        this.入手日 = dateFormat(relateEntity.get入手日());
        this.入手パターン_在新 = 在宅_新;
        this.入手パターン_在継 = 在宅_継;
        this.入手パターン_施新 = 施設_新;
        this.入手パターン_施継 = 施設_継;
        this.医師区分 = IshiKubunCode.toValue(relateEntity.get医師区分コード()).get名称();
    }

    private static RString dateFormat(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        RDate date_tem = new RDate(date.toString());
        return date_tem.seireki().separator(Separator.SLASH).toDateString();
    }
}
