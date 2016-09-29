/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD519001;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 申請情報IF作成のバッチパラメータクラスです。
 *
 * @reamsid_L DBD-1480-020 liuyl
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD519001_NinteishinseiInfoIfParameter extends BatchParameterBase {

    @BatchParameter(key = "証記載保険者番号", name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @BatchParameter(key = "市町村コード", name = "市町村コード")
    private LasdecCode 市町村コード;
    @BatchParameter(key = "被保険者番号", name = "被保険者番号")
    private HihokenshaNo 被保険者番号;
    @BatchParameter(key = "今回開始期間FROM", name = "今回開始期間FROM")
    private RDateTime 今回開始期間FROM;
    @BatchParameter(key = "今回開始期間TO", name = "今回開始期間TO")
    private RDateTime 今回開始期間TO;
    @BatchParameter(key = "新ファイル名", name = "新ファイル名")
    private RString 新ファイル名;
    @BatchParameter(key = "対象外被保険者番号リスト", name = "対象外被保険者番号リスト")
    private List<HihokenshaNo> 対象外被保険者番号リスト;

    /**
     * バーチのパラメータを作成します。
     *
     */
    public DBD519001_NinteishinseiInfoIfParameter() {

    }

    /**
     * バーチのパラメータを作成します。
     *
     * @param 証記載保険者番号 RString
     * @param 市町村コード LasdecCode
     * @param 被保険者番号 HihokenshaNo
     * @param 今回開始期間FROM RDateTime
     * @param 今回開始期間TO RDateTime
     * @param 新ファイル名 RString
     * @param 対象外被保険者番号リスト List<HihokenshaNo>
     */
    public DBD519001_NinteishinseiInfoIfParameter(
            RString 証記載保険者番号,
            LasdecCode 市町村コード,
            HihokenshaNo 被保険者番号,
            RDateTime 今回開始期間FROM,
            RDateTime 今回開始期間TO,
            RString 新ファイル名,
            List<HihokenshaNo> 対象外被保険者番号リスト) {
        this.証記載保険者番号 = 証記載保険者番号;
        this.市町村コード = 市町村コード;
        this.被保険者番号 = 被保険者番号;
        this.今回開始期間FROM = 今回開始期間FROM;
        this.今回開始期間TO = 今回開始期間TO;
        this.新ファイル名 = 新ファイル名;
        this.対象外被保険者番号リスト = 対象外被保険者番号リスト;
    }

}
