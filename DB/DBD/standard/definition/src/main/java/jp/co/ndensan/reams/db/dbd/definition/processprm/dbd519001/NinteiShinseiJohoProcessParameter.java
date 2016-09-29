/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd519001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd519001.NinteiShinseiJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 申請情報抽出_バッチ処理パラメータクラスです。
 *
 * @reamsid_L DBD-1480-020 liuyl
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiShinseiJohoProcessParameter implements IBatchProcessParameter {

    private RString 証記載保険者番号;
    private HihokenshaNo 被保険者番号;
    private RDateTime 今回開始期間FROM;
    private RDateTime 今回開始期間TO;
    private List<HihokenshaNo> 対象外被保険者番号リスト;

    /**
     * コンストラクタです。
     *
     * @param 証記載保険者番号 RString
     * @param 被保険者番号 HihokenshaNo
     * @param 今回開始期間FROM RDateTime
     * @param 今回開始期間TO RDateTime
     * @param 対象外被保険者番号リスト List<HihokenshaNo>
     */
    public NinteiShinseiJohoProcessParameter(RString 証記載保険者番号, HihokenshaNo 被保険者番号,
            RDateTime 今回開始期間FROM, RDateTime 今回開始期間TO, List<HihokenshaNo> 対象外被保険者番号リスト) {
        this.証記載保険者番号 = 証記載保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.今回開始期間FROM = 今回開始期間FROM;
        this.今回開始期間TO = 今回開始期間TO;
        this.対象外被保険者番号リスト = 対象外被保険者番号リスト;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @return NinteiShinseiJohoMybatisParameter
     */
    public NinteiShinseiJohoMybatisParameter toNinteiShinseiJohoMybatisParameter() {
        return new NinteiShinseiJohoMybatisParameter(証記載保険者番号, 被保険者番号, 今回開始期間FROM, 今回開始期間TO, 対象外被保険者番号リスト);
    }
}
