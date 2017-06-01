/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.gensenchoshudatasakusei;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE631001.GensenChoshuProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gensenchoshudatasakusei.GensenChoshuDataSakuseiCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gensenchoshudatasakusei.GensenChoshuRelateEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 源泉徴収データ作成csvのパラメータを作成します。
 *
 * @reamsid_L DBE-2000-020 jinjue
 */
public final class GensenChoshuDataSakuseiChange {

    private static RString 職種 = RString.EMPTY;
    private static RString 所属機関 = RString.EMPTY;

    private GensenChoshuDataSakuseiChange() {
    }

    /**
     * 源泉徴収データ作成のcsvのパラメータを作成します。
     *
     * @param entity 源泉徴収データ作成情報
     * @param parameter 源泉徴収データ作成のバッチのパラメータ
     * @return 源泉徴収データ作成のcsvのパラメータ
     */
    public static GensenChoshuDataSakuseiCsvEntity createData(GensenChoshuRelateEntity entity, GensenChoshuProcessParameter parameter) {
        if (!entity.get介護認定審査員資格コード().isEmpty()) {
            職種 = Sikaku.toValue(entity.get介護認定審査員資格コード().getColumnValue()).get名称();
        }
        if (!RString.isNullOrEmpty(entity.get認定調査員コード())) {
            所属機関 = entity.get事業者名称();
        } else if (!RString.isNullOrEmpty(entity.get主治医コード())) {
            所属機関 = entity.get医療機関名称();
        } else if (!RString.isNullOrEmpty(entity.getその他機関コード())) {
            所属機関 = entity.get機関名称();
        }

        GensenChoshuDataSakuseiCsvEntity data = new GensenChoshuDataSakuseiCsvEntity(entity.get介護認定審査会委員コード(),
                entity.get介護認定審査会委員名(), 職種, 所属機関, entity.get郵便番号(), entity.get住所(), entity.get電話番号(),
                entity.get番号_FAX(), edit生年月日(entity.get生年月日()), find年齢(parameter.get指定年(), entity.get生年月日()),
                entity.get認定審査会報酬合計(), entity.getその他随時報酬合計(), entity.get認定審査交通費等合計(),
                entity.get源泉徴収額(), entity.get合計());
        return data;
    }

    private static RString edit生年月日(FlexibleDate 生年月日) {
        if (生年月日 == null || !生年月日.isValid()) {
            return RString.EMPTY;
        }
        return 生年月日.seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString();
    }

    private static int find年齢(RYear 指定年, FlexibleDate 生年月日) {
        if (生年月日 == null || !生年月日.isValid()) {
            return 0;
        }
        return 指定年.getBetweenYears(new RYear(生年月日.getYear().toString()));
    }
}
