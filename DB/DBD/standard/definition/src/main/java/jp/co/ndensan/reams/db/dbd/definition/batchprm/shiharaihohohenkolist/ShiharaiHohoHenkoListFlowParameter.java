/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.shiharaihohohenkolist;

import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohokanrilist.ShiharaiHohoKanriListData;
import jp.co.ndensan.reams.db.dbd.definition.processprm.shiharaihohohenkolist.CreateTaishoshaJohoTempTableProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 支払方法変更管理リスト作成バッチ用のパラメータです。
 *
 * @reamsid_L DBD-3630-010 zhulx
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoHenkoListFlowParameter extends BatchParameterBase {

    private FlexibleDate 基準日;
    private RString 登録者選択;
    private RString 差止予告登録者の選択;
    private RString 差止登録者の選択;
    private RString 償還予告登録者の選択;
    private RString 償還決定登録者の選択;
    private RString 償還決定登録者1の選択;
    private RString 償還決定登録者2の選択;
    private Long 改頁出力順ID;
    private RString 帳票ID;

    /**
     * 画面からのパラメータを作成します。
     *
     * @param tempData 画面データ
     */
    public void toDbd207010BatchParameter(ShiharaiHohoKanriListData tempData) {
        this.基準日 = tempData.get基準日();
        this.登録者選択 = tempData.get登録者選択();
        this.差止予告登録者の選択 = tempData.get差止予告登録者の選択();
        this.差止登録者の選択 = tempData.get差止登録者の選択();
        this.償還予告登録者の選択 = tempData.get償還予告登録者の選択();
        this.償還決定登録者の選択 = tempData.get償還決定登録者の選択();
        this.償還決定登録者1の選択 = tempData.get償還決定登録者1の選択();
        this.償還決定登録者2の選択 = tempData.get償還決定登録者2の選択();
        this.改頁出力順ID = tempData.get改頁出力順ID();
        this.帳票ID = tempData.get帳票ID();
    }

    /**
     * processのパラメータを生成します。
     *
     * @return processパラメータ
     */
    public CreateTaishoshaJohoTempTableProcessParameter toShiharaiHohoKanriListProcessParameter() {
        return new CreateTaishoshaJohoTempTableProcessParameter(
                this.基準日,
                this.登録者選択,
                this.差止予告登録者の選択,
                this.差止登録者の選択,
                this.償還予告登録者の選択,
                this.償還決定登録者の選択,
                this.償還決定登録者1の選択,
                this.償還決定登録者2の選択,
                this.改頁出力順ID,
                this.帳票ID);
    }
}
