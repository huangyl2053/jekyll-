/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanjuryoininkeiyakusha;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受領委任契約番号存在チェック用画面検索DIVのクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChkKeiyakuNoParameter implements Serializable {

    private HihokenshaNo 被保険者番号;
    private FlexibleDate 修正前_申請年月日;
    private RString 修正前_契約事業者番号;
    private RString 修正前_契約サービス種類;
    private FlexibleYear 年度;
    private RString 番号1;
    private RString 番号2;
    private RString 画面モード;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 修正前_申請年月日 修正前_申請年月日
     * @param 修正前_契約事業者番号 修正前_契約事業者番号
     * @param 修正前_契約サービス種類 修正前_契約サービス種類
     * @param 年度 年度
     * @param 番号1 番号1
     * @param 番号2 番号2
     * @param 画面モード 画面モード
     */
    public ChkKeiyakuNoParameter(HihokenshaNo 被保険者番号,
            FlexibleDate 修正前_申請年月日,
            RString 修正前_契約事業者番号,
            RString 修正前_契約サービス種類,
            FlexibleYear 年度,
            RString 番号1,
            RString 番号2,
            RString 画面モード) {
        this.被保険者番号 = 被保険者番号;
        this.修正前_申請年月日 = 修正前_申請年月日;
        this.修正前_契約事業者番号 = 修正前_契約事業者番号;
        this.修正前_契約サービス種類 = 修正前_契約サービス種類;
        this.年度 = 年度;
        this.番号1 = 番号1;
        this.番号2 = 番号2;
        this.画面モード = 画面モード;
    }
}
