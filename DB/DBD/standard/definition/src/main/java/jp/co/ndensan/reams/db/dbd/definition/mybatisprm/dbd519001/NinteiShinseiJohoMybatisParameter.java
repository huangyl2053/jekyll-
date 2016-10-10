/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd519001;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 申請情報抽出(バッチ) SQLパラメータクラスです。
 *
 * @reamsid_L DBD-1480-040 liuyl
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiShinseiJohoMybatisParameter implements IMyBatisParameter {

    private final RString 証記載保険者番号;
    private final HihokenshaNo 被保険者番号;
    private final RDateTime 今回開始期間FROM;
    private final RDateTime 今回開始期間TO;
    private final List<RString> 対象外被保険者番号リスト;
    private boolean is対象外被保険者番号リスト非空 = true;
    private boolean is被保険者番号非空 = true;
    private boolean is今回開始期間FROM非空 = true;
    private boolean is今回開始期間TO非空 = true;

    /**
     * コンストラクタ。
     *
     * @param 証記載保険者番号 RString
     * @param 被保険者番号 HihokenshaNo
     * @param 今回開始期間FROM RDateTime
     * @param 今回開始期間TO RDateTime
     * @param 対象外被保険者番号リスト List<HihokenshaNo>
     */
    public NinteiShinseiJohoMybatisParameter(RString 証記載保険者番号, HihokenshaNo 被保険者番号,
            RDateTime 今回開始期間FROM, RDateTime 今回開始期間TO, List<RString> 対象外被保険者番号リスト) {
        this.証記載保険者番号 = 証記載保険者番号;
        this.被保険者番号 = 被保険者番号;
        this.今回開始期間FROM = 今回開始期間FROM;
        this.今回開始期間TO = 今回開始期間TO;
        this.対象外被保険者番号リスト = 対象外被保険者番号リスト;
        if (対象外被保険者番号リスト.isEmpty()) {
            this.is対象外被保険者番号リスト非空 = false;
        }
        if (被保険者番号.isEmpty() || 被保険者番号 == null) {
            this.is被保険者番号非空 = false;
        }
        if (今回開始期間FROM.isEqual(RDateTime.MIN)) {
            this.is今回開始期間FROM非空 = false;
        }
        if (今回開始期間TO.isEqual(RDateTime.MIN)) {
            this.is今回開始期間TO非空 = false;
        }
    }

}
