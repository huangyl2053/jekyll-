/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SeikatsuhogoRireki;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.seikatsuhogorireki.SeikaatsuhogoBusiness;
import jp.co.ndensan.reams.db.dbz.definition.mybatis.param.seikatsuhogorireki.SeikaatsuhogoDataModel;
import jp.co.ndensan.reams.db.dbz.service.core.seikatsuhogorireki.SeikatsuhogoRirekiFinder;
import jp.co.ndensan.reams.ur.urd.definition.core.seikatsuhogo.KyugoShisetsuNyuTaishoKubunType;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 共有子Div生活保護履歴画面のhandlerクラスです。
 *
 * @reamsid_L DBZ-4520-010 zhangzhiming
 */
public class SeikatsuhogoRirekiHandler {

    private final SeikatsuhogoRirekiDiv div;
    private final RString 登録 = new RString("登録");
    private final RString 照会 = new RString("照会");
    private final RString 表示モード_新規 = new RString("新規");

    /**
     * コンストラクタです。
     *
     * @param div 生活保護履歴画面div
     */
    public SeikatsuhogoRirekiHandler(SeikatsuhogoRirekiDiv div) {
        this.div = div;
    }

    /**
     * 生活保護履歴画面初期化処理です。
     *
     * @param 識別コード 識別コード
     * @param 業務コード 業務コード
     * @param 表示モード 表示モード
     */
    public void initialize(ShikibetsuCode 識別コード, GyomuCode 業務コード, RString 表示モード) {
        List<SeikaatsuhogoBusiness> business = SeikatsuhogoRirekiFinder.createInstance().search生活保護情報(識別コード, 業務コード).records();
        List<dgSeikatsuhogoRireki_Row> rowList = new ArrayList<>();
        for (SeikaatsuhogoBusiness list : business) {
            dgSeikatsuhogoRireki_Row row = new dgSeikatsuhogoRireki_Row();
            row.getTxtJukyushaNo().setValue(list.get受給者番号());
            row.getTxtKaishiYM().setValue(new RDate(list.get受給開始日().toString()));
            row.getTxtHaishiYM().setValue(new RDate(list.get受給廃止日().toString()));
            row.setTxtHokenryoDairiNofuKubun(list.get納付区分());
            row.getTxtHokenryoDairiNofuYM().setValue(new RDate(list.get納付年月().toString()));
            if (list.get入退所区分() != null) {
                row.setTxtKyugoshisetsuNyutaishoKubun(KyugoShisetsuNyuTaishoKubunType
                        .toValue(list.get入退所区分()).toRString());
            }
            if (KyugoShisetsuNyuTaishoKubunType.退所.code().equals(list.get入退所区分())) {
                row.getTxtKyugoshisetsuTaishoDate().setValue(new RDate(list.get入退所日().toString()));
            }
            if (KyugoShisetsuNyuTaishoKubunType.入所.code().equals(list.get入退所区分())) {
                row.getTxtKyugoshisetsuNyushoDate().setValue(new RDate(list.get入退所日().toString()));
            }
            if (!RString.isNullOrEmpty(list.get扶助種類())) {
                row.setTxtFujoShurui(list.get扶助種類().substring(0, list.get扶助種類().length() - 1));
            }
            if (!RString.isNullOrEmpty(list.get扶助種類コード())) {
                row.setTxtFujoShuruiCode(list.get扶助種類コード().substring(0, list.get扶助種類コード().length() - 1));
            }
            rowList.add(row);
        }
        if (登録.equals(表示モード)) {
            div.getBtnAddRow().setVisible(true);
            div.getDgSeikatsuhogoRireki().getGridSetting().getColumn("btnSelectRow").setVisible(false);
            div.getDgSeikatsuhogoRireki().getGridSetting().getColumn("btnModifyRow").setVisible(true);
            div.getDgSeikatsuhogoRireki().getGridSetting().getColumn("btnDeleteRow").setVisible(true);
            div.getDgSeikatsuhogoRireki().getGridSetting().setIsShowRowState(true);
        }
        if (照会.equals(表示モード)) {
            div.getBtnAddRow().setVisible(false);
            div.getDgSeikatsuhogoRireki().getGridSetting().getColumn("btnSelectRow").setVisible(true);
            div.getDgSeikatsuhogoRireki().getGridSetting().getColumn("btnModifyRow").setVisible(false);
            div.getDgSeikatsuhogoRireki().getGridSetting().getColumn("btnDeleteRow").setVisible(false);
            div.getDgSeikatsuhogoRireki().getGridSetting().setIsShowRowState(false);
        }
        div.getDgSeikatsuhogoRireki().setDataSource(rowList);
    }

    /**
     * 生活保護明細ダイアログを表示します。
     *
     * @param 表示モード 表示モード
     */
    public void onbtn_HiyuoJi(RString 表示モード) {
        dgSeikatsuhogoRireki_Row dgRow = div.getDgSeikatsuhogoRireki().getSelectedItems().get(0);
        SeikaatsuhogoDataModel dataModel = new SeikaatsuhogoDataModel();
        dataModel.set表示モード(表示モード);
        if (!表示モード_新規.equals(表示モード)) {
            dataModel.set受給者番号(dgRow.getTxtJukyushaNo().getValue());
            dataModel.set受給開始日(dgRow.getTxtKaishiYM().getValue());
            dataModel.set受給廃止日(dgRow.getTxtHaishiYM().getValue());
            dataModel.set納付区分(dgRow.getTxtHokenryoDairiNofuKubun());
            dataModel.set納付年月(dgRow.getTxtHokenryoDairiNofuYM().getValue());
            dataModel.set入退所区分(dgRow.getTxtKyugoshisetsuNyutaishoKubun());
            dataModel.set入所日(dgRow.getTxtKyugoshisetsuNyushoDate().getValue());
            dataModel.set退所日(dgRow.getTxtKyugoshisetsuTaishoDate().getValue());
            dataModel.set扶助種類(dgRow.getTxtFujoShurui());
            dataModel.set扶助種類コード(dgRow.getTxtFujoShuruiCode());
        }
        div.setHdnDataPass(DataPassingConverter.serialize(dataModel));
    }

    /**
     * 明細から戻ってきた受給期間情報が既に登録済みの場合、チェック実行します。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateCheck() {
        return createValidationHandler(div).validateCheck();
    }

    private SeikatsuValidationHandler createValidationHandler(SeikatsuhogoRirekiDiv div) {
        return new SeikatsuValidationHandler(div);
    }
}
