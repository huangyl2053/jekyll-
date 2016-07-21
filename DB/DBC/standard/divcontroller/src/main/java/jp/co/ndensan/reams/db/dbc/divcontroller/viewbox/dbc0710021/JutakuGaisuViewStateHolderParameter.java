/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0710021;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishu;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishuIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishujizenshinsei.ShiharaiKekkaResult;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 遷移画面と支給申請一覧Entityクラスです。
 *
 * @reamsid_L DBC-0992-120 yebangqiang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JutakuGaisuViewStateHolderParameter implements Serializable {

    private JutakuGaisuDataParameter 住宅改修データ;
    private List<JutakuGaisuListDataParameter> 住宅改修内容;
    private ShokanharaKeteiJyohoParameter 償還払決定情報;
    private RString 償還払申請一覧_サービス年月;
    private RString 償還払申請一覧_整理番号;
    private HihokenshaNo 償還払申請一覧_被保険者番号;
    private ShokanShinsei 償還払支給申請情報;
    private ShokanKihon 償還払請求基本;
    private ShokanShukei 償還払請求集計;
    private ShiharaiKekkaResult 過去住宅改修費支払結果;
    private ShokanHanteiKekka 償還払支給判定結果;
    private Map<RString, RString> 申請情報登録_更新前データ;
    private ShokanJutakuKaishuJizenShinsei 申請情報;
    private Models<ShokanJutakuKaishuIdentifier, ShokanJutakuKaishu> 住宅改修内容一覧_検索結果;
}
