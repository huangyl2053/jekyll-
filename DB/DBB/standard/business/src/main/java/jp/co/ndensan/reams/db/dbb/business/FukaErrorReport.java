/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business;

import java.util.List;
import jp.co.ndensan.reams.ur.urz.business.internalreport.InternalReportBatchInfo;
import jp.co.ndensan.reams.ur.urz.business.internalreport.InternalReportCommon;
import jp.co.ndensan.reams.ur.urz.business.internalreport.InternalReportInfo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import static java.util.Objects.requireNonNull;

/**
 * 賦課エラー一覧の内部帳票を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class FukaErrorReport extends InternalReportCommon {

    private final List<FukaErrorReportItem> itemList;

    /**
     * 引数から賦課エラー一覧の要素を受け取り、インスタンスを生成します。
     *
     * @param subGyomuCode サブ業務コード
     * @param internalReportInfo 内部帳票情報
     * @param batchInfo 内部帳票バッチ情報
     * @param itemList 内部帳票項目List
     * @throws NullPointerException 引数のいずれかにnullが渡されたとき
     */
    public FukaErrorReport(SubGyomuCode subGyomuCode, InternalReportInfo internalReportInfo, InternalReportBatchInfo batchInfo,
            List<FukaErrorReportItem> itemList) throws NullPointerException {
        super(subGyomuCode, internalReportInfo, batchInfo);

        requireNonNull(itemList, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("内部帳票項目List", getClass().getName()));
        this.itemList = itemList;
    }

    @Override
    public List<FukaErrorReportItem> getItemList() {
        return itemList;
    }

}
