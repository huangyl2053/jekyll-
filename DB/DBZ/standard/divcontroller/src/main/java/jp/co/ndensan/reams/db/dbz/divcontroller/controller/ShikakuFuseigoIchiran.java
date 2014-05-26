package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShikakuFuseigoIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgShikakuFuseigoIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author N1319
 */
public class ShikakuFuseigoIchiran {

    /**
     * 画面が読み込まれた際の初期値をセットします。
     *
     * @param panel 資格不整合一覧Div
     * @return 資格不整合一覧DivのResponseData
     */
    //TODO N1319荻原　宏二 各種DB項目はDBアクセスが可能になった時点でデータの取得部分を差し替える。
    public ResponseData<ShikakuFuseigoIchiranDiv> getOnLoadData(ShikakuFuseigoIchiranDiv panel) {
        ResponseData<ShikakuFuseigoIchiranDiv> response = new ResponseData<>();
        setFuseigoData(panel);
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        dataSource.add(new KeyValueDataSource(new RString("IgnoreNoDisp"), new RString("あああ")));
        panel.getChkIgnoreNoDisp().setSelectedItems(dataSource);
        panel.getLblDummy().setText(new RString("不整合ダミー印字"));
        response.data = panel;
        return response;
    }

    private void setFuseigoData(ShikakuFuseigoIchiranDiv panel) {
        List<dgShikakuFuseigoIchiran_Row> arrayData = createRowShikakuFuseigoTestData();
        DataGrid<dgShikakuFuseigoIchiran_Row> grid = panel.getDgShikakuFuseigoIchiran();
        grid.setDataSource(arrayData);
    }

    private List<dgShikakuFuseigoIchiran_Row> createRowShikakuFuseigoTestData() {
        List<dgShikakuFuseigoIchiran_Row> arrayData = new ArrayList<>();
        dgShikakuFuseigoIchiran_Row item;
//        List<HashMap> shikakuFuseigoSource = YamlLoader.load(new RString("ShikakuFuseigoData.yml"));
        item = createRowShikakuFuseigoData("1234567890", "1234560123456789", "ｶｲｺﾞ ﾃｽﾄ", "介護　てすと", "資格取得日・住登日不一致", "20140331", "", "20140401", "");
        arrayData.add(item);
        return arrayData;
    }

    private dgShikakuFuseigoIchiran_Row createRowShikakuFuseigoData(String 被保番号, String 識別コード, String カナ氏名, String 氏名,
            String 不整合内容, String 資格取得日, String 資格喪失日, String 住登日, String 消除日) {
        dgShikakuFuseigoIchiran_Row row;
        row = new dgShikakuFuseigoIchiran_Row(false, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY);
        row.setTxtHihoNo(new RString(被保番号));
        row.setTxtShikibetsuCode(new RString(識別コード));
        row.setTxtKanaShimei(new RString(カナ氏名));
        row.setTxtShimei(new RString(氏名));
        row.setTxtFuseigo(new RString(不整合内容));
//        row.getTxtShikakuGetYmd().setValue(new RString(資格取得日));
//        row.getTxtShikakuLostYmd().setValue(new RString(資格喪失日));
//        row.getTxtJutouYmd().setValue(new RString(住登日));
//        row.getTxtShojoYmd().setValue(new RString(消除日));
        createRowKetsugo(row);
        return row;
    }

    /*
     データグリッド内に挿入する際に二行として表示させるための成型メソッドです。
     */
    private void createRowKetsugo(dgShikakuFuseigoIchiran_Row row) {
        row.setTxtKetsugo01(row.getTxtHihoNo().concat(new RString("<br>")).concat(row.getTxtShikibetsuCode()).concat(new RString("  ")));
        row.setTxtKetsugo02(row.getTxtKanaShimei().concat(new RString("<br>")).concat(row.getTxtShimei()).concat(new RString("  ")));
//        row.setTxtKetsugo03(new FlexibleDate(row.getTxtShikakuGetYmd().getValue()).wareki().toDateString().concat(new RString("<br>")).concat(new FlexibleDate(row.getTxtShikakuGetYmd().getValue()).wareki().toDateString()));
//        row.setTxtKetsugo03(new FlexibleDate(row.getTxtJutouYmd().getValue()).wareki().toDateString().concat(new RString("<br>")).concat(new FlexibleDate(row.getTxtShojoYmd().getValue()).wareki().toDateString()));
    }

}
