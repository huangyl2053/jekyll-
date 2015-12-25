/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.KaigoTeikeibun;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoTeikeibun.KaigoTeikeibunDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoTeikeibun.dgTeikeibun_Row;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.TeikeibunShubetsuTokki;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.TeikeibunShubetsuElseTokki;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.TeikeibunKubun;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

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

        //定型文種別ドロップダウンリスト設定
        div.getDdlTeikenbunShubetsu().setDataSource(
                getTeikeibunShubetsuList(div));

        div.getDdlTeikenbunShubetsu().setSelectedIndex(0);

        List<KaigoTeikeibun> list = new ArrayList<>();
        if (!div.getTeikeiShubetsu().isEmpty()) {
            div.getDdlTeikenbunShubetsu().setDisabled(true);
        }
//        if (div.getTeikeiShubetsu().isEmpty()) {
            //定型区分、種別"001"をキーにして定型文情報を検索
//            list = new KaigoTeikeibunFinder().getTeikeibunList(
//                    div.getTeikeiKbn(),
//                    new RString("001"));

//            //定型区分をキーにして定型文情報を検索
//            list = new KaigoTeikeibunFinder().getTeikeibunList(
//                    div.getTeikeiKbn());
//        } else {
            //定型区分、種別をキーにして定型文情報を検索
//            list = new KaigoTeikeibunFinder().getTeikeibunList(
//                    div.getTeikeiKbn(),
//                    div.getTeikeiShubetsu());

//            div.getDdlTeikenbunShubetsu().setDisabled(true);
//        }

        //定型文データグリッドの設定
        List<dgTeikeibun_Row> teikeibunList = getDgTeikeibunList(list);
        div.getDgTeikeibun().setDataSource(teikeibunList);

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
     * 定型文種別ドロップダウンリストに表示するデータを取得します。
     *
     * @param div 定型文情報Div
     * @return 定型文種別表示List
     */
    private List<KeyValueDataSource> getTeikeibunShubetsuList(KaigoTeikeibunDiv div) {

        List<KeyValueDataSource> dataSource = new ArrayList<>();

        if (div.getTeikeiKbn().equals(TeikeibunKubun.特記事項.getCode())) {

            if (div.getTeikeiShubetsu().isEmpty()) {

                for (TeikeibunShubetsuTokki value : TeikeibunShubetsuTokki.values()) {
                    dataSource.add(new KeyValueDataSource(
                            value.getCode(), value.toRString())
                    );
                }

            } else {

                dataSource.add(new KeyValueDataSource(
                        TeikeibunShubetsuTokki.toValue(div.getTeikeiShubetsu()).getCode(),
                        TeikeibunShubetsuTokki.toValue(div.getTeikeiShubetsu()).toRString()));

            }

        } else if (div.getTeikeiKbn().equals(TeikeibunKubun.特記事項以外.getCode())) {

            if (div.getTeikeiShubetsu().isEmpty()) {

                for (TeikeibunShubetsuElseTokki value : TeikeibunShubetsuElseTokki.values()) {
                    dataSource.add(new KeyValueDataSource(
                            value.getCode(), value.toRString())
                    );
                }

            } else {

                dataSource.add(new KeyValueDataSource(
                        TeikeibunShubetsuElseTokki.toValue(div.getTeikeiShubetsu()).getCode(),
                        TeikeibunShubetsuElseTokki.toValue(div.getTeikeiShubetsu()).toRString()));

            }
        }
        return dataSource;
    }

    /**
     * 定型文データグリッドに表示するデータを取得します。
     *
     * @param div 介護定型文情報List
     * @return 定型文表示List
     */
    private List<dgTeikeibun_Row> getDgTeikeibunList(List<KaigoTeikeibun> list) {
        List<dgTeikeibun_Row> teikeibunList = new ArrayList<>();

        if (!list.isEmpty()) {
            for (KaigoTeikeibun teikeibun : list) {
                teikeibunList.add(createTeikeibunListRow(
                        teikeibun.getコード(),
                        teikeibun.get内容()
                ));
            }
        }
        return teikeibunList;
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

    /**
     * 定型文選択画面-「定型文種別ドロップダウンリスト」選択変更時の処理を表します。
     *
     * @param div 定型文情報Div
     * @return ResponseData
     */
    public ResponseData onChange_ddlTeikenbunShubetsu(KaigoTeikeibunDiv div) {
        ResponseData<KaigoTeikeibunDiv> response = new ResponseData<>();

        List<KaigoTeikeibun> list = new ArrayList<>();
//        list = new KaigoTeikeibunFinder().getTeikeibunList(
//                div.getTeikeiKbn(),
//                div.getDdlTeikenbunShubetsu().getSelectedKey());

        //定型文データグリッドの設定
        List<dgTeikeibun_Row> teikeibunList = getDgTeikeibunList(list);
        div.getDgTeikeibun().setDataSource(teikeibunList);

        response.data = div;
        return response;
    }
}
