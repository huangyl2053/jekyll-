/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4030011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.shogaishakojotaishoshalist.ShogaishaKojoTaishoshaListParameter;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.shogaishakoujo.NinteiNaiyoKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.shogaishakoujo.Ninteikubun;
import jp.co.ndensan.reams.db.dbd.definition.core.shogaishakojotaishoshalist.ShogaishaKojoTaishoshaListData;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4030011.ShogaishaKoujoTaishoNinteiShoDiv;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 「障がい者控除対象者認定書一括発行」画面のHandlerクラスです。
 *
 * @reamsid_L DBD-3860-010 donghj
 */
public class ShogaishaKoujoTaishoNinteiShoHandler {

    private final ShogaishaKoujoTaishoNinteiShoDiv div;

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
     */
    public void onLoad() {
        div.getTyusyutuJyokenPanel().getDdlNinteiKbn().setDataSource(setDdlNinteiKbnDataSource());
        div.getTyusyutuJyokenPanel().getDdlNinteiNaiyo().setDataSource(setDdlNinteiNaiyoDataSource());
        div.getTyusyutuJyokenPanel().getDdlninchishoNichijoSeikatsuJiritsudo().setDataSource(setDdlDataSource());
        div.getTyusyutuJyokenPanel().getDdlShogaiNichijoSeikatsuJiritsudo().setDataSource(setDdlShogaiDataSource());
        div.getTyusyutuJyokenPanel().getDdlSoshituJiyu().setDataSource(setDdlSoshituJiyuDataSource());
        div.getTyusyutuJyokenPanel().getDdlShogaishaTecho().setDataSource(setDdlShogaishaTechoDataSource());
        div.getTyusyutuJyokenPanel().getDropDownList1().setDataSource(setDropDownListDataSource());
    }

    private List<KeyValueDataSource> setDdlNinteiKbnDataSource() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (Ninteikubun num : Ninteikubun.values()) {
            dataSourceList.add(new KeyValueDataSource(num.getコード(), num.get名称()));
        }
        return dataSourceList;
    }

    private List<KeyValueDataSource> setDdlNinteiNaiyoDataSource() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (NinteiNaiyoKubun num : NinteiNaiyoKubun.values()) {
            dataSourceList.add(new KeyValueDataSource(num.getコード(), num.get名称()));
        }
        return dataSourceList;
    }

    private List<KeyValueDataSource> setDdlDataSource() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (NinchishoNichijoSeikatsuJiritsudoCode num : NinchishoNichijoSeikatsuJiritsudoCode.values()) {
            dataSourceList.add(new KeyValueDataSource(num.getコード(), num.get名称()));
        }
        return dataSourceList;
    }

    private List<KeyValueDataSource> setDdlShogaiDataSource() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (ShogaiNichijoSeikatsuJiritsudoCode num : ShogaiNichijoSeikatsuJiritsudoCode.values()) {
            dataSourceList.add(new KeyValueDataSource(num.getコード(), num.get名称()));
        }
        return dataSourceList;
    }

    private List<KeyValueDataSource> setDdlSoshituJiyuDataSource() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (ShikakuSoshitsuJiyu num : ShikakuSoshitsuJiyu.values()) {
            dataSourceList.add(new KeyValueDataSource(num.getコード(), num.get名称()));
        }
        return dataSourceList;
    }

    private List<KeyValueDataSource> setDdlShogaishaTechoDataSource() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (DdlShogaishaTecho num : DdlShogaishaTecho.values()) {
            dataSourceList.add(new KeyValueDataSource(num.getコード(), num.get名称()));
        }
        return dataSourceList;
    }

    private List<KeyValueDataSource> setDropDownListDataSource() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (DropDownList num : DropDownList.values()) {
            dataSourceList.add(new KeyValueDataSource(num.getコード(), num.get名称()));
        }
        return dataSourceList;
    }

    private enum DdlShogaishaTecho {

        あり("key1", "あり"),
        なし("key2", "なし");

        private final RString code;
        private final RString fullName;

        private DdlShogaishaTecho(String code, String fullname) {
            this.code = new RString(code);
            this.fullName = new RString(fullname);
        }

        private RString getコード() {
            return code;
        }

        private RString get名称() {
            return fullName;
        }
    }

    private enum DropDownList {

        含む("key1", "含む"),
        含まない("key2", "含まない");
        private final RString code;
        private final RString fullName;

        private DropDownList(String code, String fullname) {
            this.code = new RString(code);
            this.fullName = new RString(fullname);
        }

        private RString getコード() {
            return code;
        }

        private RString get名称() {
            return fullName;
        }
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
        tempData.set認知症高齢者の日常生活自立度(div.getTyusyutuJyokenPanel().getDdlninchishoNichijoSeikatsuJiritsudo().getSelectedValue());
        tempData.set障害高齢者の日常生活自立度(div.getTyusyutuJyokenPanel().getDdlShogaiNichijoSeikatsuJiritsudo().getSelectedValue());
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
        RString reamsLoginID = UrControlDataFactory.createInstance().getLoginInfo().getUserId();
        IOutputOrder outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBD介護受給,
                div.getShogaishaKojoNinteishoOutput().getCommonChildDiv1().get帳票ID(), reamsLoginID,
                div.getShogaishaKojoNinteishoOutput().getCommonChildDiv1().get出力順ID());
        // TODO
        return MyBatisOrderByClauseCreator.create(BreakerFieldsEnum.class, outputOrder);

    }

    /**
     * 帳票設計_DBD100025_障がい者控除対象者認定証 出力順設定可能項目です。
     */
    public enum BreakerFieldsEnum implements IReportItems {

        /**
         * 対象年度
         */
        対象年度(new RString("0002"), new RString(""), new RString("\"").concat(new RString("")).concat(new RString("\""))),;

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private BreakerFieldsEnum(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
            this.項目ID = 項目ID;
            this.フォームフィールド名 = フォームフィールド名;
            this.myBatis項目名 = myBatis項目名;
        }

        @Override
        public RString get項目ID() {
            return 項目ID;
        }

        @Override
        public RString getフォームフィールド名() {
            return フォームフィールド名;
        }

        @Override
        public RString getMyBatis項目名() {
            return myBatis項目名;
        }
    }
}
