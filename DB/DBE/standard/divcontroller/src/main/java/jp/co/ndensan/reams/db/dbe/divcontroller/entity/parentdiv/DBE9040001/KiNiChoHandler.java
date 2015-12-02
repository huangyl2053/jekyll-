package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.konicho.KoNiChoItem;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.konicho.KoNiChoRelateMapperParameter;
import jp.co.ndensan.reams.db.dbe.service.core.konicho.KoNiChoManager;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5913ChosainJohoDac;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * このコードはツールによって生成されました。</br>
 * このファイルへの変更は、再生成時には損失するため</br>
 * 不正な動作の原因になります。</br>
 * DBE9040001の状態名定義クラスです
 *
 * @author 自動生成
 */
public class KiNiChoHandler {

    private final mainPanelDiv div;
    private DbT5913ChosainJohoDac DbT5913dac;
    private KoNiChoRelateMapperParameter param;
    private DataGrid1_Row row;

    /**
     * コンストラクタです。
     *
     * @param div
     */
    public KiNiChoHandler(mainPanelDiv div) {
        this.div = div;
    }

    /**
     * サービスコード検索一覧初期化状態の設定します。
     *
     */
    public void onLoad() {
        div.getSubPanel1().getTextBox1().setValue(new RString(""));
        div.getSubPanel1().getRadioButton1().setVisible(true);
    }

    /**
     * 画面初期化の設定します。
     *
     */
    public void initialize() {
        div.getSubPanel1().getTextBox1().clearValue();
        div.getSubPanel1().getRadioButton1().setDisabledItem(null);

        ChosaItakusakiCode 認定調査委託先コード = new ChosaItakusakiCode(new RString("1"));
        ResponseData<mainPanelDiv> response = new ResponseData<>();
        if ("1".equals(認定調査委託先コード)) {
            KoNiChoRelateMapperParameter.createSelectByKeyParam(true, LasdecCode.EMPTY, 認定調査委託先コード, 認定調査委託先コード,
                    RString.EMPTY, RString.EMPTY, ChosainCode.EMPTY, ChosainCode.EMPTY, RString.HALF_SPACE, RString.HALF_SPACE, RString.EMPTY);
        } else {
            this.onLoad();
        }
    }

//    public void initialize() {
//        //TODO
//        KoNiChoManager service = KoNiChoManager.createInstance();
//        KoNiChoRelateMapperParameter.createSelectByKeyParam(true, LasdecCode.EMPTY, ChosaItakusakiCode.EMPTY,
//                ChosaItakusakiCode.EMPTY, RString.EMPTY, RString.EMPTY, ChosainCode.EMPTY, ChosainCode.EMPTY, RString.HALF_SPACE, RString.HALF_SPACE, RString.EMPTY);
//        List<KoNiChoItem> list = service.get調査員内容(param);
//        List<DataGrid1_Row> dataList = new ArrayList();
//        for (KoNiChoItem serviceCode : list) {
//            DataGrid1_Row row = new DataGrid1_Row();
//            row.setChosainCode(null);
//            //DOTO
//        }
//        dataList.add(row);
//    }
    public void onClick_クリア() {
        div.getSubPanel1().getTextBox1().setValue(new RString(""));
        div.getSubPanel1().getRadioButton1().setVisible(true);

    }

    public void onClick_ボタン検索() {

        KoNiChoManager service = KoNiChoManager.createInstance();
        List<KoNiChoItem> list = service.get調査員内容(param);
        if (list.size() > 0) {
            List<DataGrid1_Row> dataList = new ArrayList();
            for (KoNiChoItem item : list) {
                DataGrid1_Row row = new DataGrid1_Row();
                row.setShichoson(RString.EMPTY);
                row.setShichosonMeisho(null);
                row.setNinteiChosainNo(null);
                row.setChosainShimei(null);
                row.setChosainKanaShimei(null);
                row.setNinteichosaItakusakiCode(null);
                row.setJigyoshaMeisho(null);
                row.setSeibetsu(null);
                row.setChikuCode(null);
                row.setChosainShikaku(null);
                row.setChosaKanoNinzuPerMonth(null);
                row.setJokyoFlag(RString.EMPTY);
                row.setYubinNo(null);
                row.setJusho(null);
                row.setTelNo(null);
                row.setFaxNo(null);
            }
            dataList.add(row);
        } else {
            //throw new (getMessage(URZE00014));
        }

    }

    public void onClick_ボタン追加(DbT5913ChosainJohoEntity entity) {
        div.getSubPanel2().setVisible(true);
        div.getSubPanel1().setDisabled(true);
        //div.getSubPanel3().getAuthState();

        div.getSubPanel1().getTextBox1().setDisabled(true);
        div.getSubPanel1().getTextBox1().setValue(RString.EMPTY);
        div.getSubPanel1().getTextBox1().setValue(RString.EMPTY);
        div.getSubPanel1().getTextBox1().setValue(RString.EMPTY);

        div.getSubPanel1().getTextBox1().setValue(RString.EMPTY);
        div.getSubPanel1().getTextBox1().setValue(RString.EMPTY);
        div.getSubPanel1().getTextBox1().setValue(RString.EMPTY);
        div.getSubPanel1().getTextBox1().setValue(RString.EMPTY);
        div.getSubPanel1().getTextBox1().setValue(RString.EMPTY);
        div.getSubPanel1().getTextBox1().setValue(RString.EMPTY);

//        dataList.add(row);
    }
}
