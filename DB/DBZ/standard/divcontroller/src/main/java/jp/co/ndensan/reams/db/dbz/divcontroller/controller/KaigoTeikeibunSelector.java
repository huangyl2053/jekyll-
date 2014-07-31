/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.KaigoTeikeibun;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoTeikeibun.KaigoTeikeibunDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoTeikeibun.dgTeikeibun_Row;
import jp.co.ndensan.reams.db.dbz.realservice.KaigoTeikeibunFinder;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.TeikeibunShubetsu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.TeikeibunKubun;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N9606 漢那 憲作
 */
public class KaigoTeikeibunSelector {

    /**
     * 画面ロード時の設定を行います。
     *
     * @param div 定型文情報Div
     * @return ResponseData
     */
    public ResponseData onLoad(KaigoTeikeibunDiv div) {
        ResponseData<KaigoTeikeibunDiv> response = new ResponseData<>();

        //タイトル設定
        if (div.getTeikeiKbn().equals(TeikeibunKubun.特記事項.getCode())) {
            div.setTitle(TeikeibunKubun.特記事項.toRString());
        } else if (div.getTeikeiKbn().equals(TeikeibunKubun.特記事項以外.getCode())) {

            if (div.getTeikeiShubetsu().isEmpty()) {
                div.setTitle(TeikeibunKubun.特記事項以外.toRString());
            } else {
                div.setTitle(TeikeibunShubetsu.toValue(div.getTeikeiShubetsu()).toRString());
            }
        }

        List<KaigoTeikeibun> list = new ArrayList<>();
        if (div.getTeikeiShubetsu().isEmpty()) {
            //定型区分をキーにして定型文情報を検索
            list = new KaigoTeikeibunFinder().getTeikeibunList(
                    div.getTeikeiKbn());
        } else {
            //定型区分、種別をキーにして定型文情報を検索
            list = new KaigoTeikeibunFinder().getTeikeibunList(
                    div.getTeikeiKbn(),
                    div.getTeikeiShubetsu());
        }

        if (list.isEmpty()) {
            div.getDgTeikeibun().setDataSource(Collections.EMPTY_LIST);
        } else {
            //定型文データグリッド設定
            List<dgTeikeibun_Row> teikeibunList = new ArrayList<>();
            for (KaigoTeikeibun teikeibun : list) {
                teikeibunList.add(createTeikeibunListRow(
                        teikeibun.getコード(),
                        teikeibun.get内容()
                ));
            }
            div.getDgTeikeibun().setDataSource(teikeibunList);
        }

        response.data = div;
        return response;
    }

    private dgTeikeibun_Row createTeikeibunListRow(
            RString code,
            RString naiyo
    ) {

        return new dgTeikeibun_Row(
                code,
                naiyo
        );
    }

    /**
     * 定型文選択画面-「定型文データグリッド」選択時の処理を表します。
     *
     * @param div 定型文情報Div
     * @return ResponseData
     */
    public ResponseData onSelectBySelectButton_dgTeikeibun(KaigoTeikeibunDiv div) {
        ResponseData<KaigoTeikeibunDiv> response = new ResponseData<>();

        div.setTeikeibunNaiyo(div.getDgTeikeibun().getSelectedItems().get(0).getNaiyo());

        response.data = div;
        return response;
    }

}
