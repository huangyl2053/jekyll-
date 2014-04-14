/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.HonsanteiBatchKidoMainDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.dgShikakuFuseigoIchiran_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 *
 * @author N1319
 */
public class HonsanteiBatchKidoMain {

    /**
     * 画面が読み込まれた際の初期値をセットします。
     *
     * @param panel 所得照会票発行個人一覧Div
     * @return 所得照会票発行個人一覧DivのResponseData
     */
    //TODO N1319荻原　宏二 各種DB項目はDBアクセスが可能になった時点でデータの取得部分を差し替える。
    public ResponseData<HonsanteiBatchKidoMainDiv> getOnLoadData(HonsanteiBatchKidoMainDiv panel) {
        ResponseData<HonsanteiBatchKidoMainDiv> response = new ResponseData<>();
        setDefaultParam(panel);
        response.data = panel;
        return response;
    }

    private void setDefaultParam(HonsanteiBatchKidoMainDiv panel) {
        panel.getShoriJokyoPanel().getTxtJuminzeiKakuteiNichiji().setValue(RDate.MAX);
        panel.getShoriJokyoPanel().getTxtTokuchoDoteiShoriNichiji().setValue(RDate.MAX);
        setFuseigoData(panel);

    }

    private void setFuseigoData(HonsanteiBatchKidoMainDiv panel) {
        List<dgShikakuFuseigoIchiran_Row> arrayData = createRowShikakuFuseigoTestData();
    }

    private List<dgShikakuFuseigoIchiran_Row> createRowShikakuFuseigoTestData() {
        List<dgShikakuFuseigoIchiran_Row> arrayData = new ArrayList<>();
        dgShikakuFuseigoIchiran_Row item = null;
        item = createRowShikakuFuseigoData("1234567890", "1234560123456789", "ｶｲｺﾞ ﾃｽﾄ", "介護　てすと", "資格取得日・住登日不一致", "H240331", "", "H240401", "");
        arrayData.add(item);
        return arrayData;
    }

    private dgShikakuFuseigoIchiran_Row createRowShikakuFuseigoData(String 被保番号, String 識別コード, String カナ氏名, String 氏名,
            String 不整合内容, String 資格取得日, String 資格喪失日, String 住登日, String 消除日) {
        dgShikakuFuseigoIchiran_Row row = new dgShikakuFuseigoIchiran_Row(RString.HALF_SPACE, RString.HALF_SPACE, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY);
        row.setTxtHihoNo(new RString(被保番号));
        row.setTxtShikibetsuCode(new RString(識別コード));
        row.setTxtKanaShimei(new RString(カナ氏名));
        row.setTxtShimei(new RString(氏名));
        row.setTxtFuseigo(new RString(不整合内容));
        row.getTxtShikakuGetYmd().setValue(new RString(資格取得日));
        row.getTxtShikakuLostYmd().setValue(new RString(資格喪失日));
        row.getTxtJutouYmd().setValue(new RString(住登日));
        row.getTxtShojoYmd().setValue(new RString(消除日));
        createRowKetsugo(row);
        return row;
    }

    /*
     データグリッド内に挿入する際に二行として表示させるための成型メソッドです。
     */
    private void createRowKetsugo(dgShikakuFuseigoIchiran_Row row) {
        row.setTxtKetsugo01(row.getTxtHihoNo().concat(new RString("<br>")).concat(row.getTxtShikibetsuCode()).concat(new RString("  ")));
        row.setTxtKetsugo02(row.getTxtKanaShimei().concat(new RString("<br>")).concat(row.getTxtShimei()).concat(new RString("  ")));
        row.setTxtKetsugo03(new FlexibleDate(row.getTxtShikakuGetYmd().getValue()).wareki().toDateString().concat(new RString("<br>")).concat(new FlexibleDate(row.getTxtShikakuGetYmd().getValue()).wareki().toDateString()));
        row.setTxtKetsugo03(new FlexibleDate(row.getTxtJutouYmd().getValue()).wareki().toDateString().concat(new RString("<br>")).concat(new FlexibleDate(row.getTxtShojoYmd().getValue()).wareki().toDateString()));
    }
}
