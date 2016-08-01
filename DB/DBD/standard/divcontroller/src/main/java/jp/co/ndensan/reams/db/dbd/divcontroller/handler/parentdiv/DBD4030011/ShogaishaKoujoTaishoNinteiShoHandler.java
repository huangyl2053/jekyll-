/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4030011;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.shogaishakojotaishoshalist.ShogaishaKojoTaishoshaListParameter;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.shogaishakoujo.NinteiNaiyoKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.shogaishakoujo.Ninteikubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shogaishakojotaishoshalist.ShogaishaKojoTaishoshaListData;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4030011.ShogaishaKoujoTaishoNinteiShoDiv;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 「障がい者控除対象者認定書一括発行」画面のHandlerクラスです。
 *
 * @reamsid_L DBD-3860-010 donghj
 */
public class ShogaishaKoujoTaishoNinteiShoHandler {

    private ShogaishaKoujoTaishoNinteiShoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 障がい者控除対象者認定書一括発行のコントロールdiv
     */
    public ShogaishaKoujoTaishoNinteiShoHandler(ShogaishaKoujoTaishoNinteiShoDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     */
    public void onLoad() {
        setDdlNinteiKbnDataSource(div.getTyusyutuJyokenPanel().getDdlNinteiKbn().getDataSource());

        setDdlNinteiNaiyoDataSource(div.getTyusyutuJyokenPanel().getDdlNinteiNaiyo().getDataSource());

        setDdlDataSource(div.getTyusyutuJyokenPanel().getDdlninchishoNichijoSeikatsuJiritsudo().getDataSource());

        setDdlShogaiDataSource(div.getTyusyutuJyokenPanel().getDdlShogaiNichijoSeikatsuJiritsudo().getDataSource());

        setDdlSoshituJiyuDataSource(div.getTyusyutuJyokenPanel().getDdlSoshituJiyu().getDataSource());

        setDdlShogaishaTechoDataSource(div.getTyusyutuJyokenPanel().getDdlShogaishaTecho().getDataSource(),
                new RString("key1"), new RString("あり"));
        setDdlShogaishaTechoDataSource(div.getTyusyutuJyokenPanel().getDdlShogaishaTecho().getDataSource(),
                new RString("key2"), new RString("なし"));

        setDdlShogaishaTechoDataSource(div.getTyusyutuJyokenPanel().getDropDownList1().getDataSource(),
                new RString("key1"), new RString("含む"));
        setDdlShogaishaTechoDataSource(div.getTyusyutuJyokenPanel().getDropDownList1().getDataSource(),
                new RString("key2"), new RString("含まない"));

    }

    /**
     * DataSourceの设定
     *
     * @param dataSource List<KeyValueDataSource>
     */
    public void setDdlNinteiKbnDataSource(List<KeyValueDataSource> dataSource) {
        for (Ninteikubun num : Ninteikubun.values()) {
            KeyValueDataSource data = new KeyValueDataSource(num.getコード(), num.get名称());
            dataSource.add(data);
        }
    }

    private void setDdlNinteiNaiyoDataSource(List<KeyValueDataSource> dataSource) {
        for (NinteiNaiyoKubun num : NinteiNaiyoKubun.values()) {
            KeyValueDataSource data = new KeyValueDataSource(num.getコード(), num.get名称());
            dataSource.add(data);
        }
    }

    private void setDdlDataSource(List<KeyValueDataSource> dataSource) {
        for (NinchishoNichijoSeikatsuJiritsudoCode num : NinchishoNichijoSeikatsuJiritsudoCode.values()) {
            KeyValueDataSource data = new KeyValueDataSource(num.getコード(), num.get名称());
            dataSource.add(data);
        }
    }

    private void setDdlShogaiDataSource(List<KeyValueDataSource> dataSource) {
        for (ShogaiNichijoSeikatsuJiritsudoCode num : ShogaiNichijoSeikatsuJiritsudoCode.values()) {
            KeyValueDataSource data = new KeyValueDataSource(num.getコード(), num.get名称());
            dataSource.add(data);
        }
    }

    private void setDdlSoshituJiyuDataSource(List<KeyValueDataSource> dataSource) {
        for (ShikakuSoshitsuJiyu num : ShikakuSoshitsuJiyu.values()) {
            KeyValueDataSource data = new KeyValueDataSource(num.getコード(), num.get名称());
            dataSource.add(data);
        }
    }

    private void setDdlShogaishaTechoDataSource(List<KeyValueDataSource> dataSource,
            RString keyNum, RString keyValues) {
        KeyValueDataSource data = new KeyValueDataSource(keyNum, keyValues);
        dataSource.add(data);
    }

    /**
     * バッチ用パラメータを作成します。
     *
     * @return ShogaishaKojoTaishoshaListParameter 障がい者控除対象者認定書一括発行リスト_バッチ用のパラメータです。
     */
    public ShogaishaKojoTaishoshaListParameter getParameter() {
        ShogaishaKojoTaishoshaListParameter parameter = new ShogaishaKojoTaishoshaListParameter();
        ShogaishaKojoTaishoshaListData tempData = new ShogaishaKojoTaishoshaListData();
        tempData.set対象年度(div.getTyusyutuJyokenPanel().getTxtTaishoNendo().getValue());
        tempData.set被保険者番号(div.getTyusyutuJyokenPanel().getTxtHihokenshaNo().getValue());
        tempData.set氏名(div.getTyusyutuJyokenPanel().getTxtShimei().getValue());
        tempData.set認定区分(div.getTyusyutuJyokenPanel().getDdlNinteiKbn().getSelectedValue());
        tempData.set認定内容(div.getTyusyutuJyokenPanel().getDdlNinteiNaiyo().getSelectedValue());
        tempData.set認知症高齢者の日常生活自立度(div.getTyusyutuJyokenPanel().
                getDdlninchishoNichijoSeikatsuJiritsudo().getSelectedValue());
        tempData.set障害高齢者の日常生活自立度(div.getTyusyutuJyokenPanel().
                getDdlShogaiNichijoSeikatsuJiritsudo().getSelectedValue());
        tempData.set障がい者手帳(div.getTyusyutuJyokenPanel().getDdlShogaishaTecho().getSelectedValue());
        tempData.set喪失事由(div.getTyusyutuJyokenPanel().getDdlSoshituJiyu().getSelectedValue());
        tempData.set喪失日FROM(div.getTyusyutuJyokenPanel().getTxtSoshituDay().getFromValue());
        tempData.set喪失日TO(div.getTyusyutuJyokenPanel().getTxtSoshituDay().getToValue());
        tempData.set決定日FROM(div.getTyusyutuJyokenPanel().getTxtKeteiDay().getFromValue());
        tempData.set決定日TO(div.getTyusyutuJyokenPanel().getTxtKeteiDay().getToValue());
        tempData.set前回非該当者(div.getTyusyutuJyokenPanel().getDropDownList1().getSelectedValue());
        tempData.set交付日(div.getShogaishaKojoNinteishoOutput().getTxtKofuDay().getValue());
        tempData.set出力順(get画面出力順());
        parameter.toDbd100025BatchParameter(null);
        return parameter;

    }

    /**
     * 出力順を取得します。
     *
     * @return ShogaishaKojoTaishoshaListParameter 障がい者控除対象者認定書一括発行リスト_バッチ用のパラメータです。
     */
    public RString get画面出力順() {

//TODO        RString reamsLoginID = UrControlDataFactory.createInstance().getLoginInfo().getUserId();
//TODO        IOutputOrder outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBD介護受給,
//TODO                div.getShogaishaKojoNinteishoOutput().getCommonChildDiv1().get帳票ID(), reamsLoginID,
//TODO                div.getShogaishaKojoNinteishoOutput().getCommonChildDiv1().get出力順ID());
        RString 出力順 = null;     //TODO  = MyBatisOrderByClauseCreator.create(.class, outputOrder);
        return 出力順;

    }

}
