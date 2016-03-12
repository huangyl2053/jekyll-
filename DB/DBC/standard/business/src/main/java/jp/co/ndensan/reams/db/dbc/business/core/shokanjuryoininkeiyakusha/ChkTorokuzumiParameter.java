/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanjuryoininkeiyakusha;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 登録済みチェック用画面検索DIVのクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChkTorokuzumiParameter implements Serializable {

    private HihokenshaNo 被保険者番号;
    private FlexibleDate 修正前_申請年月日;
    private RString 修正前_契約事業者番号;
    private RString 修正前_契約サービス種類;
    private FlexibleDate 申請年月日;
    private RString 契約事業者番号;
    private RString 契約サービス種類;
    private RString 画面モード;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 修正前_申請年月日 修正前_申請年月日
     * @param 修正前_契約事業者番号 修正前_契約事業者番号
     * @param 修正前_契約サービス種類 修正前_契約サービス種類
     * @param 申請年月日 申請年月日
     * @param 契約事業者番号 契約事業者番号
     * @param 契約サービス種類 契約サービス種類
     * @param 画面モード 画面モード
     */
    public ChkTorokuzumiParameter(HihokenshaNo 被保険者番号,
            FlexibleDate 修正前_申請年月日,
            RString 修正前_契約事業者番号,
            RString 修正前_契約サービス種類,
            FlexibleDate 申請年月日,
            RString 契約事業者番号,
            RString 契約サービス種類,
            RString 画面モード) {
        this.被保険者番号 = 被保険者番号;
        this.修正前_申請年月日 = 修正前_申請年月日;
        this.修正前_契約事業者番号 = 修正前_契約事業者番号;
        this.修正前_契約サービス種類 = 修正前_契約サービス種類;
        this.申請年月日 = 申請年月日;
        this.契約事業者番号 = 契約事業者番号;
        this.契約サービス種類 = 契約サービス種類;
        this.画面モード = 画面モード;
    }
}
