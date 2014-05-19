/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.HihokenshaJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteiKekkaNyuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.NinteiShinsaKekkaNyuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ShinsaTaishoshaItiranDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.TaishoShinsakaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgShinsaTaishoshaIchiran_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 審査会審査対象者一覧の情報を編集します。
 *
 * @author N1013 松本直樹
 */
public class ShinsaTaishoshaItiran {

    /**
     *
     * @param div
     * @return
     */
    public ResponseData getOnloadData(ShinsaTaishoshaItiranDiv div) {
        ResponseData<ShinsaTaishoshaItiranDiv> response = new ResponseData<>();

        div.getDgShinsaTaishoshaIchiran().setDataSource(createRowSetaiTestData());

        response.data = div;
        return response;
    }

    public ResponseData onClickNyuryoku(ShinsaTaishoshaItiranDiv taishoshaItiranDiv) {
        ResponseData<ShinsaTaishoshaItiranDiv> response = new ResponseData<>();

        response.data = taishoshaItiranDiv;
        return response;
    }

    /*
     個人情報の初期値のテストデータです。
     */
    private List<dgShinsaTaishoshaIchiran_Row> createRowSetaiTestData() {
        List<dgShinsaTaishoshaIchiran_Row> arrayData = new ArrayList<>();
        dgShinsaTaishoshaIchiran_Row item;

        item = createRowKojinData("01", "電算市", "0000000001", "テスト　一郎", "テスト　イチロウ", "男",
                "2014/04/01", "要支援１", "１２", "2013/06/01", "2014/05/31", "要支援２", " ", " ", "　", "　");
        arrayData.add(item);
        item = createRowKojinData("01", "電算市", "0000000032", "テスト　花子", "テスト　ハナコ", "女",
                "2014/04/10", "要介護１", "２４", "2012/05/01", "2014/04/30", "要介護２", " ", " ", "　", "　");
        arrayData.add(item);

        return arrayData;
    }

    /**
     *
     * @param 順
     * @param 保険者
     * @param 被保番号
     * @param 氏名
     * @param カナ氏名
     * @param 性別
     * @param 申請日
     * @param 前回要介護度
     * @param 前回有効期間
     * @param 前回開始日
     * @param 前回終了日
     * @param 一次判定結果
     * @param 認定結果
     * @param 有効期間月数
     * @param 開始日
     * @param 終了日
     * @return
     */
    private dgShinsaTaishoshaIchiran_Row createRowKojinData(String 順, String 保険者, String 被保番号, String 氏名,
            String カナ氏名, String 性別, String 申請日, String 前回要介護度, String 前回有効期間, String 前回開始日, String 前回終了日,
            String 一次判定結果, String 認定結果, String 有効期間月数, String 開始日, String 終了日) {

        Button btn = new Button();

        dgShinsaTaishoshaIchiran_Row rowKojinData = new dgShinsaTaishoshaIchiran_Row(btn,
                RString.HALF_SPACE, RString.FULL_SPACE, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE,
                RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE,
                RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE, RString.HALF_SPACE);

        rowKojinData.set順(new RString(順));
        rowKojinData.set保険者(new RString(保険者));
        rowKojinData.set被保番号(new RString(被保番号));
        rowKojinData.set氏名(new RString(氏名));
        rowKojinData.setカナ氏名(new RString(カナ氏名));
        rowKojinData.set性別(new RString(性別));
        rowKojinData.set申請日(new RString(申請日));
        rowKojinData.set前回要介護度(new RString(前回要介護度));
        rowKojinData.set有効期間月数(new RString(前回有効期間));
        rowKojinData.set前回有効期間開始日(new RString(前回開始日));
        rowKojinData.set前回有効期間終了日(new RString(前回終了日));
        rowKojinData.set一次判定結果(new RString(一次判定結果));
        rowKojinData.set認定結果(new RString(認定結果));
        rowKojinData.set有効期間月数(new RString(有効期間月数));
        rowKojinData.set開始日(new RString(開始日));
        rowKojinData.set終了日(new RString(終了日));

        return rowKojinData;
    }

}
