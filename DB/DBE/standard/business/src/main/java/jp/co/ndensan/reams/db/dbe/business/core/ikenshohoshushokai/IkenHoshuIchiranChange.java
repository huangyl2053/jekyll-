/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikenshohoshushokai;

import jp.co.ndensan.reams.db.dbe.definition.processprm.ikenshohoshushokai.IkenHoshuIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshushokai.GokeiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshushokai.IkenHoshuIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshushokai.IkenshoHoshuShokaiRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 主治医意見書作成実績集計表の帳票のパラメータを作成します。
 *
 * @reamsid_L DBE-1690-020 dongyabin
 */
public final class IkenHoshuIchiranChange {

    private static int 件数_値;
    private static final int 頁_件数 = 25;
    private static final int ONE = 1;

    private IkenHoshuIchiranChange() {
    }

    /**
     * 主治医意見書作成実績集計表の帳票のパラメータを作成します。
     *
     * @param entity 主治医意見書作成実績集計表情報
     * @param parameter 主治医意見書作成のprocessのパラメータ
     * @return 主治医意見書作成実績集計表の帳票のパラメータ
     */
    public static IkenHoshuIchiranEntity createIkenHoshuIchiranData(IkenshoHoshuShokaiRelateEntity entity,
            IkenHoshuIchiranProcessParameter parameter) {
        RString 意見;
        if (new RString("1").equals(entity.get主治医意見書依頼区分())) {
            意見 = new RString("初");
        } else {
            意見 = new RString("再");
        }
        IkenHoshuIchiranEntity data = new IkenHoshuIchiranEntity(entity.get主治医医療機関コード(),
                entity.get医療機関名称(),
                entity.get主治医コード(),
                entity.get主治医氏名(),
                entity.get主治医意見書作成依頼年月日().wareki().toDateString(),
                entity.get主治医意見書記入年月日().wareki().toDateString(),
                entity.get主治医意見書受領年月日().wareki().toDateString(),
                意見,
                entity.get証記載保険者番号(),
                entity.get被保険者番号(),
                entity.get被保険者氏名(),
                entity.get在宅_新(),
                entity.get在宅_継(),
                entity.get施設_新(),
                entity.get施設_継(),
                DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get主治医意見書作成料()), 0).concat("円"),
                DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get主治医意見書別途診療費()), 0).concat("円"),
                DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get主治医意見書作成料()), 0).concat("円"));
        RStringBuilder 抽出期間 = new RStringBuilder();
        抽出期間.append(parameter.get作成依頼日期間開始().wareki().toDateString());
        抽出期間.append("～");
        抽出期間.append(parameter.get作成依頼日期間終了().wareki().toDateString());
        data.set抽出期間(抽出期間.toRString());
        return data;
    }

    /**
     * 主治医意見書作成実績集計表の帳票の合計データを作成します。
     *
     * @param entity 主治医意見書作成実績集計表情報
     * @param 番号 主治医意見書作成報酬帳票の一覧リストのNo
     * @param 件数 主治医意見書作成報酬帳票の一覧リストの件数
     * @return 主治医意見書作成実績集計表の帳票の合計データ
     */
    public static GokeiEntity createGokeiDate(IkenshoHoshuShokaiRelateEntity entity, int 番号, int 件数) {
        件数_値 = entity.get件数();
        GokeiEntity data;
        if (件数_値 - ONE <= 件数 && 番号 % 頁_件数 == ONE) {
            data = new GokeiEntity(
                    entity.get在新_合計(),
                    entity.get在継_合計(),
                    entity.get施新_合計(),
                    entity.get施継_合計(),
                    DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get作成料_合計()), 0).concat("円"),
                    DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get診断検査費用_合計()), 0).concat("円"),
                    DecimalFormatter.toコンマ区切りRString(new Decimal(entity.get合計()), 0).concat("円"),
                    番号);
        } else {
            data = new GokeiEntity();
        }
        return data;
    }
}
