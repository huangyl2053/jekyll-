/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyotakuservicekeikakusa;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.kyotakuservicekeikakusakusei.KyotakuServiceKeikakuSakuseiSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 計画届出状況チェックリストHeaderEditorクラスです。
 *
 * @reamsid_L DBC-1960-040 wangxingpeng
 */
public class KyotakuServiceKeikakuSaHeaderEditor implements IKyotakuServiceKeikakuSaEditor {

    private final KyotakuServiceKeikakuSaParam target;
    private static final RString SAKUSEI = new RString("作成");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;

    /**
     * コンストラクタです。
     *
     * @param target KyotakuServiceKeikakuSaParam
     */
    public KyotakuServiceKeikakuSaHeaderEditor(KyotakuServiceKeikakuSaParam target) {
        this.target = target;
    }

    @Override
    public KyotakuServiceKeikakuSakuseiSource edit(KyotakuServiceKeikakuSakuseiSource source) {

        editorタイトル部(source);
        editorヘッダー(source);
        return source;

    }

    private void editorタイトル部(KyotakuServiceKeikakuSakuseiSource source) {

        source.joken1 = target.get申請日();
        source.joken2 = target.get対象者();
        source.joken3 = target.get届出状況();
        if (target.get基準日() != null) {
            source.kijunYmd = new RString(target.get基準日().toString());
        }

    }

    private void editorヘッダー(KyotakuServiceKeikakuSakuseiSource source) {
        RString 作成日 = target.getシステム日時().getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = target.getシステム日時().getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE).concat(SAKUSEI);
        source.shoriYmdHms = 作成日.concat(RString.HALF_SPACE).concat(作成時);
        if (target.get地方公共団体() != null) {
            if (target.get地方公共団体().get地方公共団体コード() != null) {
                source.cityCd = target.get地方公共団体().get地方公共団体コード().getColumnValue();
            }
            source.cityMei = target.get地方公共団体().get市町村名();
        }
        editIOutputOrder(source);

    }

    private void editIOutputOrder(KyotakuServiceKeikakuSakuseiSource source) {
        List<ISetSortItem> list = null;
        IOutputOrder 出力順 = target.get出力順();
        if (出力順 != null) {
            list = 出力順.get設定項目リスト();
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        if (list.size() > INDEX_0 && list.get(INDEX_0).is改頁項目()) {
            source.kaiPageArea1 = list.get(INDEX_0).get項目名();
        }
        if (list.size() > INDEX_1 && list.get(INDEX_1).is改頁項目()) {
            source.kaiPageArea2 = list.get(INDEX_1).get項目名();
        }
        if (list.size() > INDEX_2 && list.get(INDEX_2).is改頁項目()) {
            source.kaiPageArea3 = list.get(INDEX_2).get項目名();
        }
        if (list.size() > INDEX_3 && list.get(INDEX_3).is改頁項目()) {
            source.kaiPageArea4 = list.get(INDEX_3).get項目名();
        }
        if (list.size() > INDEX_4 && list.get(INDEX_4).is改頁項目()) {
            source.kaiPageArea5 = list.get(INDEX_4).get項目名();
        }
        if (list.size() > INDEX_0) {
            source.sortJunArea1 = list.get(INDEX_0).get項目名();
        }
        if (list.size() > INDEX_1) {
            source.sortJunArea2 = list.get(INDEX_1).get項目名();
        }
        if (list.size() > INDEX_2) {
            source.sortJunArea3 = list.get(INDEX_2).get項目名();
        }
        if (list.size() > INDEX_3) {
            source.sortJunArea4 = list.get(INDEX_3).get項目名();
        }
        if (list.size() > INDEX_4) {
            source.sortJunArea5 = list.get(INDEX_4).get項目名();
        }
    }

}
