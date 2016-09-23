/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD9010003;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei.IryohiKojoEntityResult;
import jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei.ShugiiIkenshoKakuninshoEntity;
import jp.co.ndensan.reams.db.dbd.definition.core.iryohikojo.NichijoSeikatsuJiritsudo;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010003.IkenshoKakuninshoDiv;
import jp.co.ndensan.reams.db.dbd.service.core.iryohikojokakuninsinsei.IryoHiKojoKakuninSinsei;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @reamsid_L DBD-5790-010 x_zhaowen
 */
public class IkenshoKakuninshoHandler {

    private final IkenshoKakuninshoDiv div;
//    private RString 表示対象のデータ区分 = RString.EMPTY;
    private static final RString 帳票分類ID = new RString("DBD100030_ShujiiIkenshoKakuninsho");
    private static final RString 帳票 = new RString("主治医意見書確認書");
    private static final RString あり = new RString("あり");
    private static final RString なし = new RString("なし");

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
    public void initialize(TaishoshaKey taishoshaKey, List<IryohiKojoEntityResult> 医療費控除情報リスト) {
        div.getPanelKakuninsho().getCcdKaigoAtenaInfo().initialize(taishoshaKey.get識別コード());
        div.getPanelKakuninsho().getCcdKaigoShikakuKihon().initialize(taishoshaKey.get被保険者番号());
        div.getPanelShosaiEria().getCcdBunshoBangoInput().initialize(new ReportId(帳票分類ID));
        div.getPanelShosaiEria().getTxtCyouhyou().setValue(帳票);
        div.getPanelShosaiEria().getTxtSakuseiBi().setValue(RDate.getNowDate());
    }

    /**
     * 対象年DDLonChange
     *
     * @param 医療費控除情報リスト List<IryohiKojoEntity>
     */
    public void onChange対象年(List<IryohiKojoEntityResult> 医療費控除情報リスト) {
        RString 控除対象年 = div.getPanelShosaiEria().getDdlTaishonen().getSelectedKey();
        IryohiKojoEntityResult 表示対象データ = null;
        for (IryohiKojoEntityResult 医療費控除 : 医療費控除情報リスト) {
            if (控除対象年.equals(医療費控除.get控除対象年())) {
                表示対象データ = 医療費控除;
//                表示対象のデータ区分 = 医療費控除.getデータ区分();
                break;
            }
        }
        if (表示対象データ != null) {
            div.getPanelShosaiEria().getTxtZenkaiHakkouBi().setValue(表示対象データ.get発行年月日().toRDate());
            div.getPanelShosaiEria().getTxtShinseiBi().setValue(表示対象データ.get申請年月日().toRDate());
            div.getPanelShosaiEria().getTxtDateIkensyoSakuseiBi().setValue(表示対象データ.get主治医意見書受領年月日().toRDate());
            div.getPanelShosaiEria().getTxtNinteiKikan().setFromValue(表示対象データ.get認定有効期間開始年月日().toRDate());
            div.getPanelShosaiEria().getTxtNinteiKikan().setToValue(表示対象データ.get認定有効期間終了年月日().toRDate());
            div.getPanelShosaiEria().getTxtZiritudo().setValue(get日常生活自立度(表示対象データ.get日常生活自立度()));
            div.getPanelShosaiEria().getTxtNyoushikkin().setValue(表示対象データ.is尿失禁の有無() ? あり : なし);
        }
    }

    /**
     *
     * @param taishoshaKey TaishoshaKey
     * @return ShugiiIkenshoKakuninshoEntity
     */
    public ShugiiIkenshoKakuninshoEntity create主治医意見書確認書Entity(TaishoshaKey taishoshaKey) {
        ShugiiIkenshoKakuninshoEntity 主治医意見書確認書Entity = IryoHiKojoKakuninSinsei.createIntance().editsyujiikensho_Kakunisho(
                taishoshaKey.get識別コード(),
                taishoshaKey.get被保険者番号().getColumnValue(),
                帳票分類ID,
                div.getTxtSakuseiBi().getValue(),
                div.getCcdBunshoBangoInput().get文書番号(),
                div.getDdlTaishonen().getSelectedValue(),
                div.getTxtShinseiBi().getValue(),
                div.getTxtDateIkensyoSakuseiBi().getValue(),
                div.getTxtNinteiKikan().getFromValue(),
                div.getTxtNinteiKikan().getToValue(),
                div.getTxtZiritudo().getValue(),
                div.getTxtNyoushikkin().getValue()
        );
        return 主治医意見書確認書Entity;
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
