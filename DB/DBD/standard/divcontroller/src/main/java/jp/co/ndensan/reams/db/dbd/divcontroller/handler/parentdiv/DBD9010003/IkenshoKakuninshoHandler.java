/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD9010003;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.IryohiKojo;
import jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei.IryohiKojoEntityResult;
import jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei.KenshoKakuninshoinfo;
import jp.co.ndensan.reams.db.dbd.definition.core.iryohikojo.NichijoSeikatsuJiritsudo;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010003.IkenshoKakuninshoDiv;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;

/**
 *
 * @reamsid_L DBD-5790-010 x_zhaowen
 */
public class IkenshoKakuninshoHandler {

    private final IkenshoKakuninshoDiv div;
    private static final RString 帳票分類ID = new RString("DBD100030_ShujiiIkenshoKakuninsho");
    private static final RString 帳票 = new RString("主治医意見書確認書");
    private static final RString あり = new RString("あり");
    private static final RString なし = new RString("なし");
    private static final int NOM_0 = 0;

    /**
     * コンストラクタです。
     *
     * @param div IkenshoKakuninshoDiv
     */
    public IkenshoKakuninshoHandler(IkenshoKakuninshoDiv div) {
        this.div = div;
    }

    /**
     * 主治医意見書確認書画面の初期化
     *
     * @param taishoshaKey TaishoshaKey
     * @param 医療費控除情報リスト List<IryohiKojoEntity>
     */
    public void initialize(TaishoshaKey taishoshaKey, List<IryohiKojo> 医療費控除情報リスト) {
        div.getPanelKakuninsho().getCcdKaigoAtenaInfo().initialize(taishoshaKey.get識別コード());
        div.getPanelKakuninsho().getCcdKaigoShikakuKihon().initialize(taishoshaKey.get被保険者番号());
        div.getPanelShosaiEria().getCcdBunshoBangoInput().initialize(new ReportId(帳票分類ID));
        div.getPanelShosaiEria().getTxtCyouhyou().setValue(帳票);
        div.getPanelShosaiEria().getTxtSakuseiBi().setValue(new RDate(RDate.getNowDate().wareki().toDateString().toString()));
        if (医療費控除情報リスト.get(NOM_0).get控除対象年() != null && !医療費控除情報リスト.get(NOM_0).get控除対象年().isEmpty()) {
            RYear 控除対象年 = new RYear(医療費控除情報リスト.get(NOM_0).get控除対象年().toDateString());
            div.getPanelShosaiEria().getDdlTaishonen().setSelectedKey(控除対象年.toDateString());
        }
        if (医療費控除情報リスト.get(NOM_0).get発行年月日() != null && !医療費控除情報リスト.get(NOM_0).get発行年月日().isEmpty()) {
            div.getPanelShosaiEria().getTxtZenkaiHakkouBi().setValue(new RDate(医療費控除情報リスト.get(NOM_0).get発行年月日().
                    wareki().toDateString().toString()));
        }
        if (医療費控除情報リスト.get(NOM_0).get申請年月日() != null && !医療費控除情報リスト.get(NOM_0).get申請年月日().isEmpty()) {
            div.getPanelShosaiEria().getTxtShinseiBi().setValue(new RDate(医療費控除情報リスト.get(NOM_0).get申請年月日().
                    wareki().toDateString().toString()));
        }
        if (医療費控除情報リスト.get(NOM_0).get主治医意見書受領年月日() != null && !医療費控除情報リスト.get(NOM_0).get主治医意見書受領年月日().isEmpty()) {
            div.getPanelShosaiEria().getTxtDateIkensyoSakuseiBi().setValue(new RDate(医療費控除情報リスト.get(NOM_0).get主治医意見書受領年月日()
                    .wareki().toDateString().toString()));
        }
        if (医療費控除情報リスト.get(NOM_0).get認定有効期間開始年月日() != null && !医療費控除情報リスト.get(NOM_0).get認定有効期間開始年月日().isEmpty()) {
            div.getPanelShosaiEria().getTxtNinteiKikan().setFromValue(new RDate(医療費控除情報リスト.get(NOM_0).get認定有効期間開始年月日().
                    wareki().toDateString().toString()));
        }
        if (医療費控除情報リスト.get(NOM_0).get認定有効期間終了年月日() != null && !医療費控除情報リスト.get(NOM_0).get認定有効期間終了年月日().isEmpty()) {
            div.getPanelShosaiEria().getTxtNinteiKikan().setToValue(new RDate(医療費控除情報リスト.get(NOM_0).get認定有効期間終了年月日().
                    wareki().toDateString().toString()));
        }
        if (医療費控除情報リスト.get(NOM_0).get日常生活自立度() != null) {
            div.getPanelShosaiEria().getTxtZiritudo().setValue(get日常生活自立度(医療費控除情報リスト.get(NOM_0).get日常生活自立度()));
        }
        div.getPanelShosaiEria().getTxtNyoushikkin().setValue(医療費控除情報リスト.get(NOM_0).toEntity().getNyoshikkinHassei() ? あり : なし);
        div.setHdndatakubun(医療費控除情報リスト.get(NOM_0).getデータ区分());
    }

    /**
     * 対象年DDLonChange
     *
     * @param 医療費控除情報リスト List<IryohiKojoEntity>
     */
    public void onChange対象年(List<IryohiKojoEntityResult> 医療費控除情報リスト) {
        RString 控除対象年 = div.getPanelShosaiEria().getDdlTaishonen().getSelectedKey();
        IryohiKojoEntityResult 表示対象データ = null;
        RString 表示対象のデータ区分 = RString.EMPTY;
        for (IryohiKojoEntityResult 医療費控除 : 医療費控除情報リスト) {
            if (控除対象年.equals(医療費控除.get控除対象年())) {
                表示対象データ = 医療費控除;
                表示対象のデータ区分 = 医療費控除.getデータ区分();
                break;
            }
        }
        if (表示対象データ != null) {
            div.getPanelShosaiEria().getTxtZenkaiHakkouBi().setValue(new RDate(表示対象データ.get発行年月日().wareki().toDateString().toString()));
            div.getPanelShosaiEria().getTxtShinseiBi().setValue(new RDate(表示対象データ.get申請年月日().wareki().toDateString().toString()));
            div.getPanelShosaiEria().getTxtDateIkensyoSakuseiBi().setValue(
                    new RDate(表示対象データ.get主治医意見書受領年月日().wareki().toDateString().toString()));
            div.getPanelShosaiEria().getTxtNinteiKikan().setFromValue(
                    new RDate(表示対象データ.get認定有効期間開始年月日().wareki().toDateString().toString()));
            div.getPanelShosaiEria().getTxtNinteiKikan().setFromValue(
                    new RDate(表示対象データ.get認定有効期間終了年月日().wareki().toDateString().toString()));
            div.getPanelShosaiEria().getTxtZiritudo().setValue(get日常生活自立度(表示対象データ.get日常生活自立度()));
            div.getPanelShosaiEria().getTxtNyoushikkin().setValue(表示対象データ.is尿失禁の有無() ? あり : なし);
            div.setHdndatakubun(表示対象のデータ区分);
        }
    }

    /**
     * 主治医意見書確認書を設置する
     *
     * @param taishoshaKey TaishoshaKey
     * @return ShugiiIkenshoKakuninshoEntity
     */
    public KenshoKakuninshoinfo create主治医意見書確認書Entity(TaishoshaKey taishoshaKey) {
        KenshoKakuninshoinfo 主治医意見書確認書Entity = new KenshoKakuninshoinfo();
        主治医意見書確認書Entity.set識別コード(taishoshaKey.get識別コード());
        主治医意見書確認書Entity.set被保険者番号(taishoshaKey.get被保険者番号().getColumnValue());
        主治医意見書確認書Entity.set帳票分類ID(帳票分類ID);
        主治医意見書確認書Entity.set作成日(div.getTxtSakuseiBi().getValue());
        主治医意見書確認書Entity.set文書番号(div.getCcdBunshoBangoInput().get文書番号());
        主治医意見書確認書Entity.set対象年(div.getDdlTaishonen().getSelectedValue());
        主治医意見書確認書Entity.set申請日(div.getTxtShinseiBi().getValue());
        主治医意見書確認書Entity.set主治医意見書作成日(div.getTxtDateIkensyoSakuseiBi().getValue());
        主治医意見書確認書Entity.set認定期間開始日(div.getTxtNinteiKikan().getFromValue());
        主治医意見書確認書Entity.set認定期間終了日(div.getTxtNinteiKikan().getToValue());
        主治医意見書確認書Entity.set日常生活自立度(div.getTxtZiritudo().getValue());
        主治医意見書確認書Entity.set尿失禁の有無(div.getTxtNyoushikkin().getValue());
        return 主治医意見書確認書Entity;
    }

    /**
     * 主治医意見書確認書画面にて発行するボタン押下時(onClick)
     *
     * @param div IkenshoKakuninshoDiv
     * @return boolean
     */
    public boolean btnReportPublishnoCheck(IkenshoKakuninshoDiv div) {
        if (div.getTxtDateIkensyoSakuseiBi().getValue() == null) {
            return false;
        } else if (div.getTxtNinteiKikan().getFromValue() == null) {
            return false;
        } else if (div.getTxtNinteiKikan().getToValue() == null) {
            return false;
        } else if (get日常生活自立度(div.getTxtZiritudo().getValue()).isEmpty()) {
            return false;
        } else if (なし.equals(div.getTxtNyoushikkin().getValue())) {
            return false;
        } else {
            return true;
        }
    }

    private RString get日常生活自立度(RString 日常生活自立度) {
        if (NichijoSeikatsuJiritsudo.Ｂ１.getコード().equals(日常生活自立度)) {
            return NichijoSeikatsuJiritsudo.Ｂ１.get名称();
        } else if (NichijoSeikatsuJiritsudo.Ｂ２.getコード().equals(日常生活自立度)) {
            return NichijoSeikatsuJiritsudo.Ｂ２.get名称();
        } else if (NichijoSeikatsuJiritsudo.Ｃ１.getコード().equals(日常生活自立度)) {
            return NichijoSeikatsuJiritsudo.Ｃ１.get名称();
        } else if (NichijoSeikatsuJiritsudo.Ｃ２.getコード().equals(日常生活自立度)) {
            return NichijoSeikatsuJiritsudo.Ｃ２.get名称();
        }
        return RString.EMPTY;
    }

}
