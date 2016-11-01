/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2400011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.tesuryoseikyukenshinseishosakusei.TesuryoSeikyuKenShinseishoSakuseiBusiness;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC100010.DBC100010_KaishuriyushoSeikyushoShinseishoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2400011.TesuryoSeikyuKenShinseishoSakuseiParameterDiv;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成 ハンドラクラスです。
 *
 * @reamsid_L DBC-2860-010 dangjingjing
 */
public class TesuryoSeikyuKenShinseishoSakuseiParameterHandler {

    private final RString 処理対象区分Check = new RString("1");
    private final TesuryoSeikyuKenShinseishoSakuseiParameterDiv div;

    /**
     * コンストラクタです。
     *
     * @param div TesuryoSeikyuKenShinseishoSakuseiParameterDiv
     */
    public TesuryoSeikyuKenShinseishoSakuseiParameterHandler(TesuryoSeikyuKenShinseishoSakuseiParameterDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param business 住宅改修理由書作成手数料請求書兼申請書
     */
    public void onLoad(TesuryoSeikyuKenShinseishoSakuseiBusiness business) {
        if (business.get対象開始日時() != null) {
            div.getChushutsuJokenPanel().getTxtZenkaiRiyushoSakuseiShinseiYMD().setFromValue(business.get対象開始日時().getDate());
        }
        if (business.get対象終了日時() != null) {
            div.getChushutsuJokenPanel().getTxtZenkaiRiyushoSakuseiShinseiYMD().setToValue(business.get対象終了日時().getDate());
        }
        if (business.get対象終了日時() != null && !business.get対象終了日時().isEmpty()) {
            div.getChushutsuJokenPanel().getTxtRiyushoSakuseiShinseiYMD().setFromValue(business.get対象終了日時().plusDay(1).getDate());
        }
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        KeyValueDataSource data = new KeyValueDataSource(new RString("1"), new RString("申請書作成済分を含める"));
        dataSource.add(data);
        div.getChushutsuJokenPanel().getChkShoriTaishoKubun().setDataSource(dataSource);
    }

    /**
     * 実行ボタン処理です
     *
     * @param div 様式別連携情報Div
     * @param 市町村コード 市町村コード
     * @param 市町村名 市町村名
     * @return HoshuShiharaiJunbiBatchParameter
     */
    public DBC100010_KaishuriyushoSeikyushoShinseishoParameter onClick_btnJikko(TesuryoSeikyuKenShinseishoSakuseiParameterDiv div,
            RString 市町村コード, RString 市町村名) {
        DBC100010_KaishuriyushoSeikyushoShinseishoParameter batchParameter = new DBC100010_KaishuriyushoSeikyushoShinseishoParameter();
        batchParameter.set市町村コード(new LasdecCode(市町村コード));
        batchParameter.set市町村名(市町村名);
        batchParameter.set作成申請年月日開始(rDateToFlexibleDate(div.getChushutsuJokenPanel().getTxtRiyushoSakuseiShinseiYMD().getFromValue()));
        batchParameter.set作成申請年月日終了(rDateToFlexibleDate(div.getChushutsuJokenPanel().getTxtRiyushoSakuseiShinseiYMD().getToValue()));
        batchParameter.set作成日(FlexibleDate.getNowDate());
        batchParameter.set処理対象区分(get処理対象区分(div));
        return batchParameter;
    }

    private FlexibleDate rDateToFlexibleDate(RDate date) {
        if (date != null) {
            return new FlexibleDate(date.toDateString());
        }
        return FlexibleDate.EMPTY;
    }

    private RString get処理対象区分(TesuryoSeikyuKenShinseishoSakuseiParameterDiv div) {
        if (div.getChushutsuJokenPanel().getChkShoriTaishoKubun().getSelectedKeys().contains(処理対象区分Check)) {
            return 処理対象区分Check;
        }
        return RString.EMPTY;
    }
}
